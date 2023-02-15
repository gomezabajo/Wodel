package test.views;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import manager.MutatorUtils;
import utils.MutatorHelper;
import manager.IWodelTest;
import manager.WodelTestClass;
import manager.WodelTestClassInfo;
import manager.WodelTestGlobalResult;
import wodel.wodeltest.WodelTestMutatorResult;
import manager.WodelTestResult;
import manager.WodelTestResultClass;
import manager.WodelTestResultTest;
import manager.WodelTestTest;
import manager.WodelTestUtils;

public class WodelTestGlobalGraphicalResultsViewPart extends ViewPart implements IPartListener {

	public static final String ID= "test.views.WodelTestGlobalGraphicalResultsViewPart"; //$NON-NLS-1$
	private static IProject project;
	private static String[] equivalentMutants = new String[0];
	private static int LEFT_BUTTON = 1;
	private static GlobalResultsProvider resultsProvider = null;
	private static Composite composite = null;
	private static Map<String, List<WodelTestClass>> classes = null;
	
	private static Map<String, List<WodelTestClass>> packageClasses = null;

	private static int BAR_SIZE = 1000;
	private static int BAR_START = 350;
	private static final Color RED = new Color(Display.getCurrent(), 255, 102, 102);
	private static final Color GREEN = new Color(Display.getCurrent(), 102, 255, 102);
	private static final Color BLACK = new Color(Display.getCurrent(), 0, 0, 0);
	private static final Color ORANGE = new Color(Display.getCurrent(), 255, 178, 102);
	private static final Color BLUE = new Color(Display.getCurrent(), 102, 102, 255);

	private static class GlobalResult {
		public String name;
		public Object value;
		public double percent;
		
		public GlobalResult() {
			
		}
	}
	private static class Bar {
		public String title;
		public double value1;
		public double value2;
	}

	private class GlobalResultsProvider {

	    private List<GlobalResult> entries;

	    private GlobalResultsProvider() {
	        entries = new ArrayList<GlobalResult>();
			String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
			String globalResultsPath = path + "/data/" + project.getName() + ".global.results.txt";
			String[] globalResults = WodelTestUtils.loadFile(globalResultsPath);
		    String equivalentpath = path + "/data/classes.equivalent.txt";
		    String[] equivalent = WodelTestUtils.loadFile(equivalentpath);
		    if (equivalent.length > 0) {
			    equivalentMutants = equivalent[0].split("[|]");
		    }
		    else {
		    	equivalentMutants = null;
		    }
			long runningTime = Long.parseLong(globalResults[0]) / 1000;
			long mutationTime = Long.parseLong(globalResults[1]) / 1000;
			
		    IWodelTest test = MutatorHelper.getTest(project);
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			
		    String classespath = path + "/data/classes.txt";
		    String infopath = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString() + "/data/classes.results.txt";
	    	packageClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
		    classes = new HashMap<String, List<WodelTestClass>>();
		    for (String pckName : packageClasses.keySet()) {
		    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(test, packageClasses, pckName, project.getName(), classespath, infopath);
		    	classes.put(pckName, pckclasses);
		    }
			MutatorHelper mutatorHelper = new MutatorHelper(test);
			Map<String, Class<?>> mutators = mutatorHelper.getMutators();
			
			List<WodelTestMutatorResult> mutatorData = new ArrayList<WodelTestMutatorResult>();
			try {
				String ecore = FileLocator.resolve(fileURL).getFile();
				List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore);
				for (String projectName : mutators.keySet()) {
					Class<?> mutator = mutators.get(projectName);
					Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath(mutator) + "/" + mutator.getSimpleName().replace("Dynamic", "") + ".model");
					List<EObject> blocks = MutatorUtils.getBlocks(model);
					for (EObject block : blocks) {
						String name = ModelManager.getStringAttribute("name", block);
						String description = ModelManager.getStringAttribute("description", block);
						int numberOfMutants = 0;
						int failures = 0;
						List<String> paths = new ArrayList<String>();
						for (String key : classes.keySet()) {
							List<WodelTestClass> wtcl = classes.get(key);
							for (WodelTestClass wtc : wtcl) {
								for (WodelTestClassInfo info : wtc.info) {
									if (info.path.contains("/" + name + "/") || info.path.contains("\\" + name + "\\")) {
										failures += info.numFailures;
										numberOfMutants++;
										paths.add(info.path);
									}
								}
							}
						}
						WodelTestMutatorResult wtmr = new WodelTestMutatorResult(name, description, numberOfMutants, failures, paths);
						mutatorData.add(wtmr);
					}
				}
			} catch (MetaModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int numMutatorsApplied = globalResults.length > 3 ? Integer.parseInt(globalResults[3]) : 0;
			//for (WodelTestMutatorResult wtmr : mutatorData) {
			//	if (wtmr.getNumberOfMutants() > 0) {
			//		numMutatorsApplied++;
			//	}
			//}
			
			String resultsPath = path + "/data/classes.results.txt";
			List<WodelTestResultClass> mutatorResults = WodelTestResultClass.loadFile(resultsPath);

			int numMutantsKilled = 0;

			for (WodelTestResultClass mutatorResultClass : mutatorResults) {
				boolean killed = false;
				for (WodelTestResult mutatorResult : mutatorResultClass.getResults()) {
					if (mutatorResult.getFailureCount() > 0) {
						killed = true;
						break;
					}
				}
				if (killed == true) {
					numMutantsKilled++;
				}
			}
			int numMutantsGenerated = Integer.parseInt(globalResults[4]);
			int numMutantsNonCompiling = Integer.parseInt(globalResults[5]);
			int numMutantsCompiling = numMutantsGenerated - numMutantsNonCompiling;
			int numMutantsEquivalent = 0;
			if (equivalentMutants != null) {
				numMutantsEquivalent = equivalentMutants.length;
			}
			double mutationScore = numMutantsCompiling > 0 ? 1.0 * numMutantsKilled / (numMutantsCompiling - numMutantsEquivalent) : 0;
			DecimalFormat formatter = new DecimalFormat("###.##%");
			GlobalResult entry = new GlobalResult();
			entry.name = "#Generated mutants";
			entry.value = numMutantsGenerated + " (Mutation score: " + formatter.format(mutationScore) + ") (Running time: " + runningTime + " s.; Mutation time: " + mutationTime + " s.; Tests execution time: " + (runningTime - mutationTime) + " s.)";
			entry.percent = -1.0;
			entries.add(entry);
			
			int numMutatorsSelected = globalResults.length > 2 ? Integer.parseInt(globalResults[2]) : 0;
			entry = new GlobalResult();
			entry.name = "#Mutation operators selected";
			entry.value = numMutatorsSelected;
			entry.percent = -1.0;
			entries.add(entry);
			entry = new GlobalResult();
			entry.name = "#Mutation operators applied";
			entry.value = numMutatorsApplied;
			entry.percent = numMutatorsSelected > 0 ? 1.0 * numMutatorsApplied / numMutatorsSelected : 1.0;
			entries.add(entry);
			entry = new GlobalResult();
			entry.name = "#Mutants compiling";
			entry.value = numMutantsCompiling;
			entry.percent = -1.0;
			entries.add(entry);
			entry = new GlobalResult();
			entry.name = "#Mutants killed";
			entry.value = numMutantsKilled;
			entry.percent = numMutantsCompiling > 0 ? 1.0 * (numMutantsKilled - numMutantsEquivalent) / numMutantsGenerated : 0;
			entries.add(entry);
			
			int numMutantsLive = numMutantsCompiling - numMutantsKilled;
			entry = new GlobalResult();
			entry.name = "#Mutants live";
			entry.value = numMutantsLive;
			entry.percent = numMutantsCompiling > 0 ? 1.0 * numMutantsLive / numMutantsGenerated : 0;
			entries.add(entry);

			entry = new GlobalResult();
			entry.name = "#Mutants equivalent";
			entry.value = numMutantsEquivalent;
			entry.percent = -1.0;
			entries.add(entry);
			
			entry = new GlobalResult();
			entry.name = "Mutation score";
			entry.value = -1;
			entry.percent = mutationScore;
			entries.add(entry);
			
			String testsResultsPath = path + "/data/" + project.getName() + ".tests.results.txt";
			WodelTestGlobalResult testsResults = WodelTestGlobalResult.loadValues(testsResultsPath);
			
			int numTestsExecuted = testsResults.getNumTestsExecuted();
			entry = new GlobalResult();
			entry.name = "#Tests executed";
			entry.value = numTestsExecuted;
			entry.percent = -1.0;
			entries.add(entry);
			
			int numTestsFailed = testsResults.getNumTestsFailed();
			entry = new GlobalResult();
			entry.name = "#Tests failed";
			entry.value = numTestsFailed;
			entry.percent = numTestsExecuted > 0 ? 1.0 * numTestsFailed / numTestsExecuted : 0;
			entries.add(entry);
			
			int numTestsPassed = testsResults.getNumTestsExecuted() - testsResults.getNumTestsFailed();
			entry = new GlobalResult();
			entry.name = "#Tests passed";
			entry.value = numTestsPassed;
			entry.percent = numTestsExecuted > 0 ? 1.0 * numTestsPassed / numTestsExecuted : 0;
			entries.add(entry);
			
			int numTestsError = testsResults.getNumTestsError();
			entry = new GlobalResult();
			entry.name = "#Tests error";
			entry.value = numTestsError;
			entry.percent = numTestsExecuted > 0 ? 1.0 * numTestsError / numTestsExecuted : 0;
			entries.add(entry);
	    }

	    public List<GlobalResult> getGlobalResults() {
	        return entries;
	    }
	}
	
	@Override
	public void createPartControl(Composite parent) {
		if (WodelTestUtils.isReadyProject() != true) {
			return;
		}
		project = WodelTestUtils.getProject();
	    composite = parent;
	    resultsProvider = new GlobalResultsProvider(); 
	    final Canvas canvas = new Canvas(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

		String path = ModelManager.getWorkspaceAbsolutePath() + "/" + project.getFullPath().toFile().getPath().toString();
		String appliedMutatorsPath = path + "/data/mutators.txt";
		String[] appliedMutators = WodelTestUtils.loadFile(appliedMutatorsPath);
		if (appliedMutators.length > 0) {
			appliedMutators = appliedMutators[0].split("[|]");
		}
		String projectNamePath = path + "/data/project.txt";
		String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
		List<IWodelTest> tests = new ArrayList<IWodelTest>();
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodel.wodeltest.MutTest");
			for (int j = 0; j < extensions.length; j++) {
				IWodelTest test = null;
				try {
					test = (IWodelTest) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tests.add(test);
			}
		}
		
		IWodelTest test = null;
		for (IWodelTest t : tests) {
			if (t.getProjectName().equals(testInfo[0]))
			{
				test = t;
				break;
			}
		}
		if (test == null) {
			return;
		}
		MutatorHelper mutatorHelper = new MutatorHelper(test);
		Map<String, Class<?>> mutators = mutatorHelper.getMutators();
		Bundle bundle = Platform.getBundle("wodel.models");
		URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
		String appliedMutatorsText = "";
		String notAppliedMutatorsText = "";
		try {
			String ecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore);
			for (String mutatorName : mutators.keySet()) {
				Class<?> cls = mutators.get(mutatorName);
				Resource model = ModelManager.loadModel(mutatorpackages, ModelManager.getOutputPath(cls) + "/" + mutatorName.replace("Dynamic", "") + ".model");
				List<EObject> blocks = MutatorUtils.getBlocks(model);
				for (EObject block : blocks) {
					String name = ModelManager.getStringAttribute("name", block);
					String description = ModelManager.getStringAttribute("description", block);
					String label = name + (description != null ? ": " + description : "");
					boolean included = Platform.getPreferencesService().getBoolean("WodelTest", name, true, null);
					if (included == true) {
						if (Arrays.asList(appliedMutators).contains(name)) {
							appliedMutatorsText += label + "\n";
						}
						else {
							notAppliedMutatorsText += label + "\n";
						}
					}
				}
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final String appliedMutatorsMessage = appliedMutatorsText;
		final String notAppliedMutatorsMessage = notAppliedMutatorsText;
		
	    String classespath = path + "/data/classes.txt";
	    String infopath = path + "/data/classes.results.txt";
	    if (classes == null) {
	    	packageClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
		    classes = new HashMap<String, List<WodelTestClass>>();
		    for (String pckName : packageClasses.keySet()) {
		    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(test, packageClasses, pckName, project.getName(), classespath, infopath);
		    	classes.put(pckName, pckclasses);
		    }
	    }
	    List<String> killedClasses = new ArrayList<String>();
	    List<String> equivalentClasses = new ArrayList<String>();
	    List<String> liveClasses = new ArrayList<String>();
	    for (String classname : classes.keySet()) {
	    	List<WodelTestClass> clss = classes.get(classname);
			for (WodelTestClass cls : clss) {
				for (WodelTestClassInfo info : cls.info) {
					if (info.getNumFailedTests() > 0) {
						if (!killedClasses.contains(info.path)) {
							killedClasses.add(info.path);
						}
					}
					else {
						boolean equivalent = false;
						if (equivalentMutants != null) {
							for (String equivalentMutant : equivalentMutants) {
								if (info.path.startsWith(equivalentMutant)) {
									equivalent = true;
									break;
								}
							}
							if (equivalent && !equivalentClasses.contains(info.path)) {
								equivalentClasses.add(info.path);
								continue;
							}
						}
						if (!liveClasses.contains(info.path)) {
							liveClasses.add(info.path);
						}
					}
				}
			}
	    }
	    String killedClassesText = "";
	    for (String killedClass : killedClasses) {
	    	killedClassesText += killedClass + "\n";
	    }
	    String equivalentClassesText = "";
	    for (String equivalentClass : equivalentClasses) {
	    	equivalentClassesText += equivalentClass + "\n";
	    }
	    String liveClassesText = "";
	    for (String liveClass : liveClasses) {
	    	liveClassesText += liveClass + "\n";
	    }
	    final String killedClassesMessage = killedClassesText;
	    final String equivalentClassesMessage = equivalentClassesText;
	    final String liveClassesMessage = liveClassesText;

	    List<WodelTestTest> appliedTests = WodelTestUtils.getTests(test, packageClasses, project.getName(), classespath, infopath);
	    List<String> failedTests = new ArrayList<String>();
	    List<String> passedTests = new ArrayList<String>();
	    List<String> errorTests = new ArrayList<String>();
	    for (WodelTestTest appliedTest : appliedTests) {
			for (WodelTestResultTest result : appliedTest.getResults()) {
				if (result.getDetectedMutants() > 0) {
					if (!failedTests.contains(result.getName())) {
						failedTests.add(result.getName());
					}
				}
			}
		}
	    for (WodelTestTest appliedTest : appliedTests) {
	    	for (WodelTestResultTest result : appliedTest.getResults()) {
				if (result.getDetectedMutants() == 0 && result.getFailures() == 0 && !failedTests.contains(result.getName()) && !passedTests.contains(result.getName())) {
					passedTests.add(result.getName());
				}
			}
	    }
	    for (WodelTestTest appliedTest : appliedTests) {
	    	for (WodelTestResultTest result : appliedTest.getResults()) {
	    		if (result.getFailures() > 0) {
	    			errorTests.add(result.getName());
	    		}
	    	}
	    }
	    
	    String failedTestsText = "";
	    for (String failedTest : failedTests) {
	    	failedTestsText += failedTest + "\n";
	    }
	    String passedTestsText = "";
	    for (String passedTest : passedTests) {
	    	passedTestsText += passedTest + "\n";
	    }
	    String errorTestsText = "";
	    for (String errorTest : errorTests) {
	    	errorTestsText += errorTest + "\n";
	    }

	    final String failedTestsMessage = failedTestsText;
	    final String passedTestsMessage = passedTestsText;
	    final String errorTestsMessage = errorTestsText;
	    
	    canvas.addPaintListener(new PaintListener() {
	    	
			@Override
			public void paintControl(PaintEvent e) {
				// TODO Auto-generated method stub
				GC gc = e.gc;
				
				Bar bar = null;
				int value = 0;
				for (GlobalResult entry : resultsProvider.getGlobalResults()) {
					switch (entry.name) {
						case "#Generated mutants":
							gc.setLineWidth(1);
							gc.setForeground(BLACK);
							gc.drawText(entry.name + ": " + entry.value, 0, 10);
							break;
						case "#Mutation operators selected":
							bar = new Bar();
							bar.title = "Mutation operators applied:not applied";
							bar.value1 = (int) entry.value;
							break;
						case "#Mutation operators applied":
							bar.value2 = (int) entry.value;
							int greenSize = (int) ((1.0 * bar.value1 == 0 ? 1 : bar.value2 / bar.value1) * BAR_SIZE);
							int redSize = BAR_SIZE - greenSize;
							gc.setLineWidth(1);
							gc.setForeground(BLACK);
							gc.drawText(bar.title + " (" + String.format("%.0f", bar.value2) + ":" + String.format("%.0f", bar.value1 == 0 ? 0 : bar.value1 - bar.value2) + ")", 0, 40);
							gc.setLineWidth(20);
							gc.setForeground(GREEN);
							gc.drawLine(BAR_START, 50, BAR_START + greenSize, 50);
							gc.setForeground(RED);
							gc.drawLine(BAR_START + greenSize, 50, BAR_START + greenSize + redSize, 50);
							gc.setForeground(BLACK);
							DecimalFormat formatter = new DecimalFormat("###.##%");
							if ((bar.value1 == 0) || (bar.value1 != 0 && bar.value2 != 0)) {
								gc.drawText("% Mutation operators applied " + formatter.format(1.0 * bar.value1 == 0 ? 1 : bar.value2 / bar.value1), BAR_START + 10, 42, true);
							}
							if (bar.value1 != 0 && (bar.value1 - bar.value2) != 0) {
								gc.drawText("% Mutation operators not applied " + formatter.format(1.0 * bar.value1 == 0 ? 0 : (bar.value1 - bar.value2) / bar.value1), BAR_START + 10 + greenSize, 42, true);
							}
							break;
						case "#Mutants compiling":
							bar = new Bar();
							bar.title = "Mutants killed:equivalent:live";
							bar.value1 = (int) entry.value;
							break;
						case "#Mutants killed":
							bar.value2 = (int) entry.value;
							break;
						case "#Mutants equivalent":
							value = (int) entry.value;
							greenSize = (int) ((1.0 * bar.value2 / bar.value1) * BAR_SIZE);
							int orangeSize = (int) ((1.0 * value / bar.value1) * BAR_SIZE);
							redSize = BAR_SIZE - orangeSize - greenSize;
							gc.setLineWidth(1);
							gc.setForeground(BLACK);
							gc.drawText(bar.title + " (" + String.format("%.0f", bar.value2) + ":" + String.format("%d", value) + ":" + String.format("%.0f", bar.value1 == 0 ? 0 : bar.value1 - value - bar.value2) + ")", 0, 70);
							gc.setLineWidth(20);
							gc.setForeground(GREEN);
							gc.drawLine(BAR_START, 80, BAR_START + greenSize, 80);
							gc.setForeground(ORANGE);
							gc.drawLine(BAR_START + greenSize, 80, BAR_START + greenSize + orangeSize, 80);
							gc.setForeground(RED);
							gc.drawLine(BAR_START + greenSize + orangeSize, 80, BAR_START + greenSize + orangeSize + redSize, 80);
							formatter = new DecimalFormat("###.##%");
							gc.setForeground(BLACK);
							if (bar.value2 != 0) {
								gc.drawText("% Mutants killed " + formatter.format(1.0 * bar.value2 / bar.value1), BAR_START + 10, 72, true);
							}
							if (value != 0) {
				            	gc.drawText("% Muts. equiv. " + formatter.format(1.0 * value / bar.value1), BAR_START + 10 + greenSize, 72, true);
							}
							if ((bar.value1 - value - bar.value2) != 0) {
								gc.drawText("% Mutants live " + formatter.format(1.0 * (bar.value1 - value - bar.value2) / bar.value1), BAR_START + 10 + orangeSize + greenSize, 72, true);
							}
							gc.setLineWidth(1);
							gc.setForeground(BLACK);
							//gc.drawText("#Equivalent mutants: " + String.format("%d", value), 0, 100);
							//gc.setLineWidth(20);
							break;
						//case "Mutation score":
						//	greenSize = (int) (entry.percent * BAR_SIZE);
						//	redSize = BAR_SIZE - greenSize;
						//	gc.setLineWidth(1);
						//	gc.setForeground(BLACK);
						//	bar.title = "Mutants killed:live";
						//	gc.drawText(bar.title + " (" + String.format("%.0f", bar.value2) + ":" + String.format("%.0f", bar.value1 == 0 ? 0 : bar.value1 - value - bar.value2) + ")", 0, 100);
						//	gc.setLineWidth(20);
						//	gc.setForeground(GREEN);
						//	gc.drawLine(BAR_START, 110, BAR_START + greenSize, 110);
						//	gc.setForeground(RED);
						//	gc.drawLine(BAR_START + greenSize, 110, BAR_START + greenSize + redSize, 110);
						//	gc.setForeground(BLACK);
						//	formatter = new DecimalFormat("###.##%");
						//	gc.drawText(entry.name + " " + formatter.format(entry.percent), BAR_START + 10, 102, true);
						//	//gc.drawText(entry.name + ": " + String.format("%.0f%%", (double) entry.percent * 100), 0, 100);
						//	break;
						case "#Tests executed":
							bar = new Bar();
							bar.title = "Tests failed:passed:error";
							bar.value1 = failedTests.size() + passedTests.size() + errorTests.size();
							break;
						case "#Tests failed":
							bar.value2 =  failedTests.size();
							greenSize = (int) ((1.0 * bar.value2 / bar.value1) * BAR_SIZE);
							value = errorTests.size();
							int blueSize = (int) ((1.0 * value / bar.value1) * BAR_SIZE);
							redSize = BAR_SIZE - blueSize - greenSize;
							gc.setLineWidth(1);
							gc.setForeground(BLACK);
							//gc.drawText(bar.title + " (" + String.format("%.0f", bar.value2) + ":" + String.format("%.0f", bar.value1 - bar.value2 - value) + ":" + String.format("%d", value) + ")", 0, 130);
							gc.drawText(bar.title + " (" + String.format("%.0f", bar.value2) + ":" + String.format("%.0f", bar.value1 - bar.value2 - value) + ":" + String.format("%d", value) + ")", 0, 100);
							gc.setLineWidth(20);
							gc.setForeground(GREEN);
							//gc.drawLine(BAR_START, 140, BAR_START + greenSize, 140);
							gc.drawLine(BAR_START, 110, BAR_START + greenSize, 110);
							gc.setForeground(RED);
							//gc.drawLine(BAR_START + greenSize, 140, BAR_START + greenSize + redSize, 140);
							gc.drawLine(BAR_START + greenSize, 110, BAR_START + greenSize + redSize, 110);
							gc.setForeground(BLUE);
							//gc.drawLine(BAR_START + greenSize + redSize, 140, BAR_START + greenSize + redSize + blueSize, 140);
							gc.drawLine(BAR_START + greenSize + redSize, 110, BAR_START + greenSize + redSize + blueSize, 110);
							formatter = new DecimalFormat("###.##%");
							gc.setForeground(BLACK);
							if (bar.value2 != 0) {
								//gc.drawText("% Tests failed " + formatter.format(1.0 * bar.value2 / bar.value1), BAR_START + 10, 132, true);
								gc.drawText("% Tests failed " + formatter.format(1.0 * bar.value2 / bar.value1), BAR_START + 10, 102, true);
							}
							if ((bar.value1 - bar.value2 - value) != 0) {
								//gc.drawText("% Tests passed " + formatter.format(1.0 * (bar.value1 - bar.value2 - value) / bar.value1), BAR_START + 10 + greenSize, 132, true);
								gc.drawText("% Tests passed " + formatter.format(1.0 * (bar.value1 - bar.value2 - value) / bar.value1), BAR_START + 10 + greenSize, 102, true);
							}
							if (value != 0) {
				            	//gc.drawText("% Tests error " + formatter.format(1.0 * value / bar.value1), BAR_START + 10 + greenSize + redSize, 132, true);
								gc.drawText("% Tests error " + formatter.format(1.0 * value / bar.value1), BAR_START + 10 + greenSize + redSize, 102, true);
							}
							break;
//						case "#Tests passed":
//							bar.title = "Tests passed/executed";
//							bar.value2 = (int) entry.value;
//							redSize = (int) ((1.0 * bar.value2 / bar.value1) * 200);
//							greenSize = 200 - redSize;
//							gc.setLineWidth(1);
//							gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
//							gc.drawText(bar.title + " (" + String.format("%.0f", bar.value2) + "/" + String.format("%.0f", bar.value1) + ")", 0, 190);
//							gc.setLineWidth(20);
//							gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
//							gc.drawLine(350, 200, 350 + redSize, 200);
//							gc.setForeground(display.getSystemColor(SWT.COLOR_GREEN));
//							gc.drawLine(350 + redSize, 200, 350 + redSize + greenSize, 200);
//							break;
					}
				}
			}
	    });

	    canvas.addMouseListener(new MouseAdapter() {
	    	public void mouseDown(MouseEvent event) {
	    		if (event.button == LEFT_BUTTON) {
	    			Bar bar = null;
	    			for (GlobalResult entry : resultsProvider.getGlobalResults()) {
	    				switch (entry.name) {
	    				case "#Mutation operators selected" :
	    					bar = new Bar();
	    					bar.value1 = (int) entry.value;
	    					break;
	    				case "#Mutation operators applied":
	    					bar.value2 = (int) entry.value;
	    					int greenSize = (int) ((1.0 * bar.value2 / bar.value1) * BAR_SIZE);
							int redSize = BAR_SIZE - greenSize;
	    					if (event.x >= BAR_START && event.x <= BAR_START + greenSize && event.y >= 40 && event.y <= 60) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Mutation operators applied");
	    								messageBox.setMessage(appliedMutatorsMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					if (event.x >= BAR_START + greenSize && event.x <= BAR_START + greenSize + redSize && event.y >= 40 && event.y <= 60) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Mutation operators selected but not applied");
	    								messageBox.setMessage(notAppliedMutatorsMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					break;
						case "#Mutants compiling":
							bar = new Bar();
							bar.value1 = (int) entry.value;
							break;
						case "#Mutants killed":
							bar.value2 = (int) entry.value;
							break;
						case "#Mutants equivalent":
							int value = (int) entry.value;
							greenSize = (int) ((1.0 * bar.value2 / bar.value1) * BAR_SIZE);
							int orangeSize = (int) ((1.0 * value / bar.value1) * BAR_SIZE);
							redSize = BAR_SIZE - orangeSize - greenSize;
							redSize = BAR_SIZE - greenSize;
	    					if (event.x >= BAR_START && event.x <= BAR_START + greenSize && event.y >= 70 && event.y <= 90) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Killed mutants");
	    								messageBox.setMessage(killedClassesMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					if (event.x >= BAR_START + greenSize && event.x <= BAR_START + greenSize + orangeSize && event.y >= 70 && event.y <= 90) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Equivalent mutants");
	    								messageBox.setMessage(equivalentClassesMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					if (event.x >= BAR_START + greenSize + orangeSize && event.x <= BAR_START + greenSize + orangeSize + redSize && event.y >= 70 && event.y <= 90) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Live mutants");
	    								messageBox.setMessage(liveClassesMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					break;
//						case "Mutation score":
//							greenSize = (int) (entry.percent * BAR_SIZE);
//							redSize = BAR_SIZE - greenSize;
//	    					if (event.x >= BAR_START && event.x <= BAR_START + greenSize && event.y >= 100 && event.y <= 120) {
//	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
//	    							public void run() {
//	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
//	    								MessageBox messageBox = new MessageBox(shell);
//	    								messageBox.setText("Killed mutants");
//	    								messageBox.setMessage(killedClassesMessage);
//	    								messageBox.open();
//	    							}
//	    						});
//	    					}
//	    					if (event.x >= BAR_START + greenSize && event.x <= BAR_START + greenSize + redSize && event.y >= 100 && event.y <= 120) {
//	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
//	    							public void run() {
//	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
//	    								MessageBox messageBox = new MessageBox(shell);
//	    								messageBox.setText("Live mutants");
//	    								messageBox.setMessage(liveClassesMessage);
//	    								messageBox.open();
//	    							}
//	    						});
//	    					}
//							break;
						case "#Tests executed":
							bar = new Bar();
							bar.value1 = failedTests.size() + passedTests.size() + errorTests.size();
							break;
						case "#Tests failed":
							bar.value2 = failedTests.size();
							greenSize = (int) ((1.0 * bar.value2 / bar.value1) * BAR_SIZE);
							value = errorTests.size();
							int blueSize = (int) ((1.0 * value / bar.value1) * BAR_SIZE);
							redSize = BAR_SIZE - blueSize - greenSize;
	    					//if (event.x >= BAR_START && event.x <= BAR_START + greenSize && event.y >= 130 && event.y <= 150) {
							if (event.x >= BAR_START && event.x <= BAR_START + greenSize && event.y >= 100 && event.y <= 120) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Failed tests");
	    								messageBox.setMessage(failedTestsMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					//if (event.x >= BAR_START + greenSize && event.x <= BAR_START + greenSize + redSize && event.y >= 130 && event.y <= 150) {
							if (event.x >= BAR_START + greenSize && event.x <= BAR_START + greenSize + redSize && event.y >= 100 && event.y <= 120) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Passed tests");
	    								messageBox.setMessage(passedTestsMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					//if (event.x >= BAR_START + greenSize + redSize && event.x <= BAR_START + greenSize + redSize + blueSize && event.y >= 130 && event.y <= 150) {
							if (event.x >= BAR_START + greenSize + redSize && event.x <= BAR_START + greenSize + redSize + blueSize && event.y >= 100 && event.y <= 120) {
	    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
	    							public void run() {
	    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
	    								MessageBox messageBox = new MessageBox(shell);
	    								messageBox.setText("Error tests");
	    								messageBox.setMessage(errorTestsMessage);
	    								messageBox.open();
	    							}
	    						});
	    					}
	    					break;
	    				}
	    			}
	    		}
	    	}
	    });
	    
	    getSite().getPage().addPartListener(this);
	}
	
	@Override
	public void dispose() {
		getSite().getPage().removePartListener(this);
	}
	
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void partActivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		resultsProvider = new GlobalResultsProvider();
		if (composite != null) {
			composite.layout();
			composite.redraw();
		}
	}

	@Override
	public void partBroughtToTop(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partClosed(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partDeactivated(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}
}
