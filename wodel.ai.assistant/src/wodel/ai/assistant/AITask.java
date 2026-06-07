package wodel.ai.assistant;

import com.google.inject.Injector;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.osgi.framework.Bundle;

import wodel.ai.assistant.llm.GPTClient;
import wodel.ai.assistant.tasks.evaluator.IEvalTask;
import wodel.ai.assistant.tasks.fixers.EvaluationContext;
import wodel.ai.assistant.tasks.fixers.IFixerTask;
import wodel.ai.assistant.tasks.fixers.ImprovementPipeline;
import wodel.ai.assistant.tasks.fixers.LLMResponse;
import wodel.ai.assistant.tasks.fixers.TaskQualityEvaluationResult;
import wodel.ai.assistant.utils.MetamodelToText;
import wodel.dsls.WodelStandaloneSetup;
import mutatorenvironment.MutatorenvironmentPackage;

public abstract class AITask extends MTTask implements IFixerTask {
	public static final String GOTTEN_MODEL = "Gotten Model", MM_PATH = "Meta-model Path", MR_NAME = "MR name";
	private static final String SYSTEM_PROMPT_HEADER = 
"""
Gotten is a DSL to define metamorphic relations, together with their input features, output features, and processors.
This is an example of a Gotten program with two metamorphic relations:

metamodel datacentre "/sample.gotten/model/datac.ecore" with m1, m2
metamodel workload "/sample.gotten/model/workload.ecore" with w1, w2		
datacentre input Features {
  context DataCentre def: NNodes: Int = racks->collect(numBoards*board.nodesPerBoard)->sum()
  context DataCentre def: CPU: Int = racks->collect(numBoards*board.nodesPerBoard*board.nodeType.CPUCores*board.nodeType.CPUSpeed)->sum()
}
output Features {
  Time: Long
  Energy: Long	
}
MetamorphicRelations {		
  MR1 = [ (NNodes(m1) > NNodes(m2)) implies (Time(m1) <= Time(m2)) ]	
  MR2 = [ (CPU(m1) > CPU(m2) and (w1) == (w2)) implies (Energy(m1) <= Energy(m2)) ]	
}

You also must consider some aspects: 
 *The output features, like Time and Energy, only receive a single parameter: the model m1 or m2. Example:  Time(m1), Time(m2), Energy(m1), Energy(m2). NOT Time(m1,w1)
 *When the multiplicity of a metamodel is Multiplicity: 1..1, (range of elements, from 1 to 1) means that only a single element of the class is considered.
 For example, if board has this definition on the metamodel " Reference: board → Board (Multiplicity: 1..1)" using "board->collect(nodeType.DiskSpeed)->sum()" is incorrect. You must use "board.nodeType.DiskSpeed"
 * The input features may use OCL in their definition       
The Gotten Xtext grammar is as follows:
""";
	private static final String SYSTEM_PROMPT_FOOTER = "You are an assistant to help the user work with Gotten.";
	private static final String SYSTEM_PROMPT_MM = "Code that you generate, must be conformance with the following metamodel description: \"\"\"";
	private static final int MAX_ATTEMPTS = 3;
	private String gottenGrammar;
	protected String metamodelDescription;
	protected String metamodelPath;
	protected GPTClient client;
	// xtext validation:
	private XtextResourceSet resourceSet;
	private IResourceValidator validator;
	protected boolean bValidateCode;
	
	// improvement cycles
	protected ImprovementPipeline cycle;
	protected IEvalTask evalTask;
	protected IFixerTask fixerTask;
	private String userInput = "";
	
	
	public AITask() {
		this.client = new GPTClient()
						//.withModel("gpt-3.5-turbo")
						.withModel("gpt-4o-mini")
        				.withTemperature(0);

		// Initialize and register Gotten package 
		MutatorenvironmentPackage.eINSTANCE.eClass();
		EPackage.Registry.INSTANCE.put(MutatorenvironmentPackage.eNS_URI, MutatorenvironmentPackage.eINSTANCE);
		
		// Initialize injector, Xtext resource set, and validator
		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
		this.resourceSet  = injector.getInstance(XtextResourceSet.class);
		this.validator    = injector.getInstance(IResourceValidator.class);
		bValidateCode = true;
	}
	
	public GPTClient getLLMClient() {
		return client;
	}
	
	public AITask(String description) {
		this();
		this.description = description;
	}
	
	public AITask withModel(String model) {
		this.client.withModel(model);
		return this;
	}
	
	public AITask withImprovementCycle(ImprovementPipeline ic) {
		this.cycle =  ic;
		return this;
	}
	
	public void setMetamodelPath(String metamodelPath) {
		this.metamodelPath = metamodelPath; 
	}
	
	public AITask setVerbose(boolean v) {
		this.client.setVerbose(v);
		return this;
	}
	
	public Object executeWithInput(String userInput) throws Exception {	
		return this.getAnswer(userInput);
	}
	
	public LLMResponse getAnswer(String userInput) throws Exception{
		int attempt=0;
		this.userInput = userInput;
		List<String> errors = null;
		List<String> followup = new ArrayList<>();
		String prompt = null;
		LLMResponse response = null;
		// loop until free of syntactic errors (linking error about missing metamodel types are allowed)
		do {
			System.out.println(":::: ATTEMPT "+(attempt+1)+"\n");
			// prepare followup if needed
			if (response!=null && errors!=null) {
				followup.add(response.getCode());                 // suggested code
				followup.add("> " + String.join("\n> ", errors)); // errors in suggested code
			}
			// call LLM agent
			prompt   = attempt==0 ? this.buildPrompt(userInput) : this.buildFollowupPrompt(userInput, followup.toArray(new String[0]));
			response = this.client.sendPrompt(prompt);
			
			if(bValidateCode)
				errors   = this.validateGottenCode(response.getCode(), true);			
		} while (bValidateCode && !errors.isEmpty() && (++attempt)<MAX_ATTEMPTS);
		response.setUserInput(userInput);
		return response;
	}
	
	protected String buildPrompt(String userInput) {
		String strRet;
		if (this.gottenGrammar==null)
			this.readGrammar();
		
		if(metamodelDescription == null)
			this.loadMMDescription();
		
		if(metamodelDescription == null)
			strRet = escapeJson(SYSTEM_PROMPT_HEADER + this.gottenGrammar + SYSTEM_PROMPT_FOOTER);
		else
			strRet = escapeJson(SYSTEM_PROMPT_HEADER + this.gottenGrammar +SYSTEM_PROMPT_MM+this.metamodelDescription+ SYSTEM_PROMPT_FOOTER);
		
		return strRet;
	}

	private void loadMMDescription() {
		MetamodelToText mmToText = new MetamodelToText();
    	
    	if(this.metamodelPath != null && mmToText.loadMM(this.metamodelPath))
    	{
    		metamodelDescription = mmToText.getMetamodelDescription();
    	}
		
	}
	protected String buildFollowupPrompt(String userInput, String... followup) {
		return this.buildPrompt(userInput) + escapeJson(String.join("\n", followup));
	}
	

	/**
	private void readGrammar() {		
		try {
			this.gottenGrammar = "";
            List<String> lines = Files.readAllLines(Paths.get("Gotten.xtext"));
            for (String line : lines) {
                this.gottenGrammar+=line;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
	}	
	*/
	
	private void readGrammar() {
		this.gottenGrammar = "";
		Bundle bundle = Platform.getBundle("MeTAssist");
		URL gottenGrammarURL = bundle.getEntry("/Gotten.xtext");
		try {
			java.net.URI gottenGrammarURI = FileLocator.resolve(gottenGrammarURL).toURI();
			List<String> lines = Files.readAllLines(Paths.get(gottenGrammarURI));
            for (String line : lines) {
                this.gottenGrammar+=line;
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * It validates a gotten program
	 * @param code gotten program
	 * @param excludeEtypeErrors true to exclude linking errors about missing eclasses and efeatures
	 * @return errors in gotten program
	 */
	private List<String> validateGottenCode(String code, boolean excludeEtypeErrors) {
		Resource     resource = resourceSet.createResource(URI.createURI("dummy:/dummy_" + System.currentTimeMillis() + ".gotten"));
		List<String> issues   = new ArrayList<>();		
		try {
			resource.load(new ByteArrayInputStream(code.getBytes()), null);
			List<Issue> allIssues = validator.validate(resource, CheckMode.ALL, new CancelIndicator() {
				@Override
				public boolean isCanceled() {
					// TODO Auto-generated method stub
					return false;
				}});
			if (!allIssues.isEmpty()) {
				Pattern etypeErrorPattern   = Pattern.compile("^Couldn't resolve reference to E(Class|StructuralFeature|Object)");
				Pattern linkingErrorPattern = Pattern.compile("Linking$");
				for (Issue issue : allIssues) {
					if (excludeEtypeErrors && 
						linkingErrorPattern.matcher(issue.getCode()).find() && 
						etypeErrorPattern.matcher(issue.getMessage()).find())
						continue;
					issues.add(issue.getMessage());
				}
			}
			// print in console
			if (!issues.isEmpty()) {
				System.out.println("\nIssues");
				System.out.println("--------------------------------------------------");
				for (String issue : issues) System.out.println(" > " + issue);
				System.out.println("");
			}
		} 
		catch (IOException e) { e.printStackTrace(); }
		return issues;
	}

	public AITask validating(boolean validate) {
		this.bValidateCode = validate;
		return this;
	}
	
	public String escapeJson(String str) {
        return str.replace("\\", "\\\\")  // Escape backslash
                  .replace("\"", "\\\"")  // Escape double quote
                  .replace("\n", "\\n")  // Escape new line
                  .replace("\r", "\\r")  // Escape carriage return
                  .replace("\t", "\\t"); // Escape tab
    }
	
	public IFixerTask getFixerTask() {		// factory methods
		return this.fixerTask;
	}
	
	public IEvalTask getEvaluatorTask() {	// factory methods
		return this.evalTask;
	}
	
	public AITask withEvalTask(IEvalTask et) {
		this.evalTask = et;
		return this;
	}
	
	public AITask withFixerTask(IFixerTask ft) {
		this.fixerTask = ft;
		return this;
	}
	
	public AITask withSelfFixTask() {
		this.fixerTask = this;
		this.client.withTemperature(this.client.getTemperature()+0.25);
		return this;
	}

	public AITask withImprovementPipeline(int maxIterations) {
		return this.withImprovementPipeline(maxIterations, false);
	}
	
	public AITask withImprovementPipeline(int maxIterations, boolean improving) {
		this.cycle = new ImprovementPipeline(this.getEvaluatorTask(), this.getFixerTask(), maxIterations, improving);		
		return this;
	}
	
	// simply retry, taking the previous userInput
	public LLMResponse fix(TaskQualityEvaluationResult result, EvaluationContext evalContext) {
		try {
			return this.getAnswer(userInput);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	
}
