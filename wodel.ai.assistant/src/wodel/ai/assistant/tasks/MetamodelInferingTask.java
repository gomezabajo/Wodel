package wodel.ai.assistant.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import wodel.ai.assistant.AITask;
import wodel.ai.assistant.tasks.fixers.LLMResponse;

public class MetamodelInferingTask extends AITask {
	private String gottenModel;
	private boolean bEcoreMode;
	
	//TODO: Refactorizar solo con el tipo
	private static final String MM_PROMPT_FROM_ENV_ECORE = "\"You are a specialist in the Gotten framework for Metamorphic Testing. "
			+ "I provide you a “Gotten environment” defined that includes:\n"
			+ "Declarations metamodel ... with ... "
			+ "Definitions of input Features and output Features."
			+ "MetamorphicRelations block."
			+ "{model}"
			+ "\"\\n\"\n"
			+ "Your task is to generate the complete Ecore metamodel (a .ecore file) that reflects:\\n\"\n"
			+ "The classes and their attributes/references required by the contexts used in the input features.\\n\"\n"
			+ "The correct multiplicity (e.g., 1..1 or 0..*) based on how collections are used in the OCL expressions (->collect, ->sum, etc.).\\n\"\n"
			+ "The mapping between each model variable (m1, m2, …) and the EClasses."
			+ "Dont forget to include the Types of the attributes";
	
	private static final String MM_PROMPT_FROM_ENV_EMFATIC = "\"You are a specialist in the Gotten framework for Metamorphic Testing and in EMF’s EMFatic syntax. You already have a “Gotten environment” defined that includes:\\n\"\n"
			+ "-Declarations metamodel … with …\\n\"\n"
			+ "-Definitions of input Features and output Features\\n\"\n"
			+ "{model}"
			+ "\\n\"\n"
			+ "Your task is to generate the complete Emfatic metamodel (a .emfatic file) that reflects:\\n\"\n"
			+ "The classes and their attributes/references required by the contexts used in the input features.\\n\"\n"
			+ "The correct multiplicity (e.g., 1..1 or 0..*) based on how collections are used in the OCL expressions (->collect, ->sum, etc.).\\n\"\n"
			+ "The mapping between each model variable (m1, m2, …) and the EClasses.\\n\"\n";
	
	private static final String OUTPUT_ECORE = "Generate a metamdelmodel XML content of the *.ecore file. Do not produce any explanation, ONLY the code.";
	private static final String OUTPUT_EMFATIC = "Generate a metamdelmodel content of the *.emfatic file. Do not produce any explanation, ONLY the code.";
	
	public MetamodelInferingTask(String gottenModel, boolean bEcoreMode) {
		this.gottenModel = gottenModel;		
		this.bEcoreMode = bEcoreMode;
	}
	
	@Override
	protected String buildPrompt(String userInput) {	// we ignore userInput
		String finalPrompt;
		
		if(bEcoreMode)
		{
			finalPrompt = super.buildPrompt(userInput) +
					 "\\n" + this.mmEcorePrompt() +
					 "\\n" + OUTPUT_ECORE;
		}
		else
		{
			finalPrompt = super.buildPrompt(userInput) +
					 "\\n" + this.mmEmfaticPrompt() +
					 "\\n" + OUTPUT_EMFATIC;			
		}

		
		return finalPrompt;
	}
	private String mmEcorePrompt() {		
		String prompt = MM_PROMPT_FROM_ENV_ECORE.replace("{model}", this.gottenModel);
		return this.escapeJson(prompt);
	}
	
	private String mmEmfaticPrompt() {		
		String prompt = MM_PROMPT_FROM_ENV_EMFATIC.replace("{model}", this.gottenModel);
		return this.escapeJson(prompt);
	}	
	
	public String generateMetamodel(String path) {
		List<Long> durations = new ArrayList<>();
		String extension;
		
		long start = System.nanoTime();
		try {
			LLMResponse response = this.getAnswer("");
			
			if(this.bEcoreMode)
				extension = "ecore";
			else
				extension = "emfatic";
			
			this.saveTo(path+File.separator+"mm."+extension, response.getResponse());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.nanoTime();
		durations.add(end - start); // time in nanoseconds
		this.computeExecStats(durations);
		return null;
	}

	private void computeExecStats(List<Long> durations) {
		// Convert nanoseconds to milliseconds
		List<Double> durationsMs = new ArrayList<>();
		for (long duration : durations) {
			durationsMs.add(duration / 1000000.0);
		}
		// Compute average
		double sum = durationsMs.stream().mapToDouble(Double::doubleValue).sum();
		double avg = sum / durationsMs.size();

		// Compute median
		Collections.sort(durationsMs);
		double median;
		int size = durationsMs.size();
		if (size % 2 == 0) {
			median = (durationsMs.get(size / 2 - 1) + durationsMs.get(size / 2)) / 2.0;
		} else {
			median = durationsMs.get(size / 2);
		}

		// Compute standard deviation
		double variance = durationsMs.stream().mapToDouble(d -> Math.pow(d - avg, 2)).sum() / durationsMs.size();
		double stdDev = Math.sqrt(variance);

		// Print results
		System.out.println("\nTiming Statistics (ms):");
		System.out.printf("Average time: %.2f ms\n", avg);
		System.out.printf("Median time: %.2f ms\n", median);
		System.out.printf("Standard deviation: %.2f ms\n", stdDev);		
	}

	private void saveTo(String path, String response) {
		try {
			PrintWriter pw = new PrintWriter(path);
			pw.print(response);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
/*
//TODO:
//*Que se pueda inferir de un modelo gotten proporcionado
//*Que se pueda inferir de una descripcion
//*Que se pueda inferir de un articulo

PROMPT1="Eres un especialista en el framework Gotten para Metamorphic Testing. Tienes ya definido un “entorno Gotten” que incluye:
- Declaraciones `metamodel … with …`
- Definiciones de `input Features` y `output Features`
- Bloque `MetamorphicRelations`

Tu tarea es generar **el metamodelo Ecore completo** (archivo `.ecore`) que refleje:
1. Las clases y sus atributos/referencias necesarios para los contextos usados en las input features.
2. La multiplicidad correcta (p.ej. 1..1 o 0..*) según cómo se usan las colecciones en las expresiones OCL (`->collect`, `->sum`, etc.).
3. Las correspondencias entre cada variable de modelo (`m1`, `m2`, …) y las EClasses.
4. Comentarios que expliquen cada elemento del metamodelo.

Proporciona:
- El contenido XML del archivo `*.ecore`.
- Un breve párrafo explicando cómo encaja este metamodelo con las input/output features y las metamorphic relations de tu entorno Gotten.
"
*/
}