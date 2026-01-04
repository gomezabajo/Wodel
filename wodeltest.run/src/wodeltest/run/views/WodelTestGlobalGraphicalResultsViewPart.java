package wodeltest.run.views;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.List;
import java.util.Locale;
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
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;
import org.osgi.framework.Bundle;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodeltest.run.utils.JUnitProgressBar;
import wodeltest.run.utils.MutatorHelper;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.WodelTestClass;
import wodel.utils.manager.WodelTestClassInfo;
import wodel.utils.manager.WodelTestGlobalResult;
import wodeltest.extension.utils.WodelTestMutatorResult;
import wodel.utils.manager.WodelTestResult;
import wodel.utils.manager.WodelTestResultClass;
import wodel.utils.manager.WodelTestResultTest;
import wodel.utils.manager.WodelTestTest;
import wodel.utils.manager.WodelTestUtils;

public class WodelTestGlobalGraphicalResultsViewPart extends ViewPart implements IPartListener {

	public static final String ID = "wodeltest.run.views.WodelTestGlobalGraphicalResultsViewPart"; //$NON-NLS-1$
	private static List<IProject> projects;
	private static Map<String, String[]> equivalentMutants = new TreeMap<String, String[]>();
	private static int LEFT_BUTTON = 1;
	private static GlobalResultsProvider resultsProvider = null;
	private static Map<String, Map<String, List<WodelTestClass>>> classes = null;
	
	private static int numOperatorsSelected = 0;
	private static int numOperatorsApplied = 0;

	private static int numMutantsGenerated = 0;
	private static Map<String, Double> mutationScore = null;
	
	private static Map<String, Long> runningTimes = null;
	private static Map<String, Long> mutationTimes = null;
	
	private static Map<String, Map<String, List<WodelTestClass>>> packageClasses = null;
	
	private static List<String> testSuiteNames = null;
	
	private static IWodelTest test = null;

	private static int BAR_SIZE = 1000;
	private static int BAR_START = 350;
	private static final Color RED = new Color(Display.getCurrent(), 255, 102, 102);
	private static final Color GREEN = new Color(Display.getCurrent(), 102, 255, 102);
	private static final Color BLACK = new Color(Display.getCurrent(), 0, 0, 0);
	private static final Color ORANGE = new Color(Display.getCurrent(), 255, 178, 102);
	private static final Color BLUE = new Color(Display.getCurrent(), 102, 102, 255);

	private static Map<String, Composite> contents = new TreeMap<String, Composite>();

	private TabFolder m_tabFolder = null;

	private static TabItem currentTab = null;
	
	private static boolean partDeactivated = false;
	
	private JUnitProgressBar progressBar = null;
	
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
		
		public Bar() {
		}
	}
	
	private static IWodelTest getTest(String[] testInfo) {
		IWodelTest test = null;
		List<IWodelTest> tests = new ArrayList<IWodelTest>();
		if (Platform.getExtensionRegistry() != null) {
			IConfigurationElement[] extensions = Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							"wodeltest.extension.MutTesting");
			for (int j = 0; j < extensions.length; j++) {
				IWodelTest t = null;
				try {
					t = (IWodelTest) extensions[j]
							.createExecutableExtension("class");
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tests.add(t);
			}
		}
		
		for (IWodelTest t : tests) {
			if (t.getProjectName().equals(testInfo[0]))
			{
				test = t;
				break;
			}
		}
		return test;
	}
	
	private class GlobalResultsProvider {

		private Map<String, List<GlobalResult>> entries = null; 

	    private GlobalResultsProvider() {
		    if (test == null) {
		    	return;
		    }
		    for (IProject project : projects) {
				mutationScore = new LinkedHashMap<String, Double>();
		        entries = new TreeMap<String, List<GlobalResult>>();
				String path = project.getLocation().toFile().getPath();
				//String testSuiteName = Platform.getPreferencesService().getString("WodelTest", "Current test-suite", WodelTestUtils.getTestSuiteName(project), null);
				Map<String, String> globalResultsPaths = new TreeMap<String, String>();
				Map<String, String[]> globalResults = new TreeMap<String, String[]>();
				Map<String, String> equivalentPaths = new TreeMap<String, String>();
				Map<String, String[]> equivalents = new TreeMap<String, String[]>();
				runningTimes = new TreeMap<String, Long>();
				mutationTimes = new TreeMap<String, Long>();
				packageClasses = new TreeMap<String, Map<String, List<WodelTestClass>>>();
				classes = new TreeMap<String, Map<String, List<WodelTestClass>>>();
				testSuiteNames = new ArrayList<String>();
				testSuiteNames.addAll(WodelTestUtils.getTestSuitesNames(project));
			    String classespath = path + "/data/classes.txt";
				for (String testSuiteName : testSuiteNames) {
					String globalResultsPath = path + "/data/" + testSuiteName + "/" + project.getName() + ".global.results.txt";
					globalResultsPaths.put(testSuiteName, globalResultsPath);
					globalResults.put(testSuiteName, WodelTestUtils.loadFile(globalResultsPath));
					String equivalentpath = path + "/data/" + testSuiteName + "/classes.equivalent.txt";
					equivalentPaths.put(testSuiteName, equivalentpath);
				    String[] equivalent = WodelTestUtils.loadFile(equivalentpath);
					equivalents.put(testSuiteName, equivalent);
					if (equivalentMutants.get(testSuiteName) == null) {
						equivalentMutants.put(testSuiteName, new String[0]);
					}
				    if (equivalent.length > 0) {
					    equivalentMutants.put(testSuiteName, equivalent[0].split("[|]"));
				    }
				    else {
				    	equivalentMutants.put(testSuiteName, null);
				    }
				    long runningTime = Long.parseLong(globalResults.get(testSuiteName)[0]) / 1000;
				    runningTimes.put(testSuiteName, runningTime);
				    long mutationTime = Long.parseLong(globalResults.get(testSuiteName)[1]) / 1000;
				    mutationTimes.put(testSuiteName, mutationTime);
				    String infopath = path + "/data/" + testSuiteName + "/classes.results.txt";
				    if (test == null) {
					    String projectNamePath = path + "/data/project.txt";
						String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
						test = getTest(testInfo);
						if (test == null) {
							return;
						}
				    }
					if (test == null) {
						String projectNamePath = path + "/data/project.txt";
						String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
						test = getTest(testInfo);
						if (test == null) {
							return;
						}
					}
					Map<String, List<WodelTestClass>> pckClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
				    packageClasses.put(testSuiteName, pckClasses);
				    Map<String, List<WodelTestClass>> clss = new LinkedHashMap<String, List<WodelTestClass>>();
				    for (String pckName : pckClasses.keySet()) {
				    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(pckClasses, pckName, project.getName(), classespath, infopath);
				    	clss.put(pckName, pckclasses);
				    }
				    classes.put(testSuiteName, clss);
				}
				
				Bundle bundle = Platform.getBundle("wodel.models");
				URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
				
				MutatorHelper mutatorHelper = new MutatorHelper(test);
				Map<String, Class<?>> mutators = mutatorHelper.getMutators();
				
				Map<String, List<WodelTestMutatorResult>> mutatorData = new TreeMap<String, List<WodelTestMutatorResult>>();
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
							for (String testSuiteName : testSuiteNames) {
								int numberOfMutants = 0;
								int failures = 0;
								List<String> paths = new ArrayList<String>();
								for (String key : classes.get(testSuiteName).keySet()) {
									List<WodelTestClass> wtcl = classes.get(testSuiteName).get(key);
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
								if (mutatorData.get(testSuiteName) == null) {
									mutatorData.put(testSuiteName, new ArrayList<WodelTestMutatorResult>());
								}
								mutatorData.get(testSuiteName).add(wtmr);
								numOperatorsApplied = globalResults.get(testSuiteName).length > 3 ? Integer.parseInt(globalResults.get(testSuiteName)[3]) : 0;
								//for (WodelTestMutatorResult wtmr : mutatorData) {
								//	if (wtmr.getNumberOfMutants() > 0) {
								//		numMutatorsApplied++;
								//	}
								//}
								
								String resultsPath = path + "/data/" + testSuiteName + "/classes.results.txt";
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
								numMutantsGenerated = Integer.parseInt(globalResults.get(testSuiteName)[4]);
								int numMutantsNonCompiling = Integer.parseInt(globalResults.get(testSuiteName)[5]);
								int numMutantsCompiling = numMutantsGenerated - numMutantsNonCompiling;
								int numMutantsEquivalent = 0;
								if (equivalentMutants != null && equivalentMutants.get(testSuiteName) != null) {
									numMutantsEquivalent = equivalentMutants.get(testSuiteName).length;
								}
								mutationScore.put(testSuiteName, numMutantsCompiling > 0 ? 1.0 * numMutantsKilled / (numMutantsCompiling - numMutantsEquivalent) : 0);
								Locale.setDefault(new Locale ("en", "US"));
								DecimalFormat formatter = new DecimalFormat("###.##%");
								entries.put(testSuiteName, new ArrayList<GlobalResult>());
								GlobalResult entry = new GlobalResult();
								entry.name = "#Generated mutants";
								entry.value =  numMutantsGenerated + " (Mutation score: " + formatter.format(mutationScore.get(testSuiteName)) + ") (Running time: " + runningTimes.get(testSuiteName) + " s.; Mutation time: " + mutationTimes.get(testSuiteName) + " s.; Tests execution time: " + (runningTimes.get(testSuiteName) - mutationTimes.get(testSuiteName)) + " s.)";
								entry.percent = -1.0;
								entries.get(testSuiteName).add(entry);
								numOperatorsSelected = globalResults.get(testSuiteName).length > 2 ? Integer.parseInt(globalResults.get(testSuiteName)[2]) : 0;
								entry = new GlobalResult();
								entry.name = "#Mutation operators selected";
								entry.value = numOperatorsSelected;
								entry.percent = -1.0;
								entries.get(testSuiteName).add(entry);
								entry = new GlobalResult();
								entry.name = "#Mutation operators applied";
								entry.value = numOperatorsApplied;
								entry.percent = numOperatorsSelected > 0 ? 1.0 * numOperatorsApplied / numOperatorsSelected : 1.0;
								entries.get(testSuiteName).add(entry);
								entry = new GlobalResult();
								entry.name = "#Mutants compiling";
								entry.value = numMutantsCompiling;
								entry.percent = -1.0;
								entries.get(testSuiteName).add(entry);
								entry = new GlobalResult();
								entry.name = "#Mutants killed";
								entry.value = numMutantsKilled;
								entry.percent = numMutantsCompiling > 0 ? 1.0 * (numMutantsKilled - numMutantsEquivalent) / numMutantsGenerated : 0;
								entries.get(testSuiteName).add(entry);
								
								int numMutantsLive = numMutantsCompiling - numMutantsKilled;
								entry = new GlobalResult();
								entry.name = "#Mutants live";
								entry.value = numMutantsLive;
								entry.percent = numMutantsCompiling > 0 ? 1.0 * numMutantsLive / numMutantsGenerated : 0;
								entries.get(testSuiteName).add(entry);

								entry = new GlobalResult();
								entry.name = "#Mutants equivalent";
								entry.value = numMutantsEquivalent;
								entry.percent = -1.0;
								entries.get(testSuiteName).add(entry);
								
								entry = new GlobalResult();
								entry.name = "Mutation score";
								entry.value = -1;
								entry.percent = mutationScore.get(testSuiteName);
								entries.get(testSuiteName).add(entry);
								
								String testsResultsPath = path + "/data/" + testSuiteName + "/" + project.getName() + ".tests.results.txt";
								WodelTestGlobalResult testsResults = WodelTestGlobalResult.loadValues(testsResultsPath);
								
								int numTestsExecuted = testsResults.getNumTestsExecuted();
								entry = new GlobalResult();
								entry.name = "#Tests executed";
								entry.value = numTestsExecuted;
								entry.percent = -1.0;
								entries.get(testSuiteName).add(entry);
								
								int numTestsFailed = testsResults.getNumTestsFailed();
								entry = new GlobalResult();
								entry.name = "#Tests failed";
								entry.value = numTestsFailed;
								entry.percent = numTestsExecuted > 0 ? 1.0 * numTestsFailed / numTestsExecuted : 0;
								entries.get(testSuiteName).add(entry);
								
								int numTestsPassed = testsResults.getNumTestsExecuted() - testsResults.getNumTestsFailed();
								entry = new GlobalResult();
								entry.name = "#Tests passed";
								entry.value = numTestsPassed;
								entry.percent = numTestsExecuted > 0 ? 1.0 * numTestsPassed / numTestsExecuted : 0;
								entries.get(testSuiteName).add(entry);
								
								int numTestsError = testsResults.getNumTestsError();
								entry = new GlobalResult();
								entry.name = "#Tests error";
								entry.value = numTestsError;
								entry.percent = numTestsExecuted > 0 ? 1.0 * numTestsError / numTestsExecuted : 0;
								entries.get(testSuiteName).add(entry);
							}
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
		    }
	    }

	    public Map<String, List<GlobalResult>> getGlobalResults() {
	        return entries;
	    }
	}
	
	@Override
	public void createPartControl(Composite parent) {
		if ((projects = WodelTestUtils.getOpenWodelTestSUTProjects()) == null || (projects.isEmpty())) {
			return;
		}
		
	    m_tabFolder = new TabFolder(parent, SWT.FILL);
	    m_tabFolder.setLayoutData(new GridLayout());
		m_tabFolder.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				TabFolder tabFolder = (TabFolder) event.getSource();
				currentTab = tabFolder.getItem(tabFolder.getSelectionIndex());
				String testSuiteName = currentTab.getText();
				if (currentTab != null && contents != null && contents.get(testSuiteName) != null) {
					contents.get(testSuiteName).layout();
					contents.get(testSuiteName).redraw();
				}
			}
		});
		
		for (IProject project : projects) {
			testSuiteNames = new ArrayList<String>();
			testSuiteNames.addAll(WodelTestUtils.getTestSuitesNames(project));
			mutationScore = new LinkedHashMap<String, Double>();
			String path = project.getLocation().toFile().getPath();
			//String testSuiteName = Platform.getPreferencesService().getString("WodelTest", "Current test-suite", WodelTestUtils.getTestSuiteName(project), null);
			Map<String, String> globalResultsPaths = new TreeMap<String, String>();
			Map<String, String[]> globalResults = new TreeMap<String, String[]>();
			Map<String, String> equivalentPaths = new TreeMap<String, String>();
			Map<String, String[]> equivalents = new TreeMap<String, String[]>();
			runningTimes = new TreeMap<String, Long>();
			mutationTimes = new TreeMap<String, Long>();
			packageClasses = new TreeMap<String, Map<String, List<WodelTestClass>>>();
			classes = new TreeMap<String, Map<String, List<WodelTestClass>>>();
			for (String testSuiteName : testSuiteNames) {
				String globalResultsPath = path + "/data/" + testSuiteName + "/" + project.getName() + ".global.results.txt";
				globalResultsPaths.put(testSuiteName, globalResultsPath);
				globalResults.put(testSuiteName, WodelTestUtils.loadFile(globalResultsPath));
			    String classespath = path + "/data/classes.txt";
			    String infopath = path + "/data/" + testSuiteName + "/classes.results.txt";
			    if (test == null) {
				    String projectNamePath = path + "/data/project.txt";
					String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
					test = getTest(testInfo);
					if (test == null) {
						return;
					}
			    }
			    Map<String, List<WodelTestClass>> pckClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
			    packageClasses.put(testSuiteName, pckClasses);
			    Map<String, List<WodelTestClass>> clss = new LinkedHashMap<String, List<WodelTestClass>>();
			    for (String pckName : pckClasses.keySet()) {
			    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(pckClasses, pckName, project.getName(), classespath, infopath);
			    	clss.put(pckName, pckclasses);
			    }
			    classes.put(testSuiteName, clss);

//	    		final GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
//	    		data.horizontalAlignment = SWT.FILL;
	    		
	    		

//	    		final Canvas canvas = new Canvas(currentContents, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);
//		    	canvas.setLayoutData(data);
//		    	canvas.setVisible(true);
		    	
				String appliedMutatorsPath = path + "/data/mutators.txt";
				String[] appliedMutators = WodelTestUtils.loadFile(appliedMutatorsPath);
				if (appliedMutators.length > 0) {
					appliedMutators = appliedMutators[0].split("[|]");
				}
				if (test == null) {
					String projectNamePath = path + "/data/project.txt";
					String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
					test = getTest(testInfo);
					if (test == null) {
						return;
					}
				}
			    resultsProvider = new GlobalResultsProvider(); 
				MutatorHelper mutatorHelper = new MutatorHelper(test);
				//String testSuiteName = Platform.getPreferencesService().getString("WodelTest", "Current test-suite", WodelTestUtils.getTestSuiteName(project), null);
				Map<String, Class<?>> mutators = mutatorHelper.getMutators();
				Bundle bundle = Platform.getBundle("wodel.models");
				URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
			
				try {
					String ecore = FileLocator.resolve(fileURL).getFile();
					List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore);
					String appliedMutatorsText = "";
					String notAppliedMutatorsText = "";
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
					
					if (test == null) {
						String projectNamePath = path + "/data/project.txt";
						String[] testInfo = WodelTestResultClass.loadProjectInfo(projectNamePath);
						test = getTest(testInfo);
						if (test == null) {
							return;
						}
					}
				    if (classes.get(testSuiteName) == null) {
				    	pckClasses = WodelTestUtils.getPackageClasses(test, project.getName(), classespath, infopath);
					    packageClasses.put(testSuiteName, pckClasses);
					    clss = new LinkedHashMap<String, List<WodelTestClass>>();
					    for (String pckName : pckClasses.keySet()) {
					    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(pckClasses, pckName, project.getName(), classespath, infopath);
					    	clss.put(pckName, pckclasses);
					    }
					    classes.put(testSuiteName, clss);
				    }
				    List<String> killedClassesList = new ArrayList<String>();
				    List<String> equivalentClassesList = new ArrayList<String>();
				    List<String> liveClassesList = new ArrayList<String>();
				    for (String classname : classes.get(testSuiteName).keySet()) {
				    	List<WodelTestClass> clsss = classes.get(testSuiteName).get(classname);
						for (WodelTestClass cls : clsss) {
							for (WodelTestClassInfo info : cls.info) {
								if (info.getNumFailedTests() > 0) {
									if (!killedClassesList.contains(info.path)) {
										killedClassesList.add(info.path);
									}
								}
								else {
									boolean equiv = false;
									if (equivalentMutants.get(testSuiteName) != null) {
										for (String equivalentMutant : equivalentMutants.get(testSuiteName)) {
											if (info.path.startsWith(equivalentMutant)) {
												equiv = true;
												break;
											}
										}
										if (equiv && !equivalentClassesList.contains(info.path)) {
											equivalentClassesList.add(info.path);
											continue;
										}
									}
									if (!liveClassesList.contains(info.path)) {
										liveClassesList.add(info.path);
									}
								}
							}
						}
				    }
				    String killedClassesText = "";
				    for (String killedClass : killedClassesList) {
				    	killedClassesText += killedClass + "\n";
				    }
				    String equivalentClassesText = "";
				    for (String equivalentClass : equivalentClassesList) {
				    	equivalentClassesText += equivalentClass + "\n";
				    }
				    String liveClassesText = "";
				    for (String liveClass : liveClassesList) {
				    	liveClassesText += liveClass + "\n";
				    }
				    List<WodelTestTest> appliedTestsList = WodelTestUtils.getTests(packageClasses.get(testSuiteName), project.getName(), classespath, infopath);
				    List<String> failedTestsList = new ArrayList<String>();
				    List<String> passedTestsList = new ArrayList<String>();
				    List<String> errorTestsList = new ArrayList<String>();
				    for (WodelTestTest appliedTest : appliedTestsList) {
						for (WodelTestResultTest result : appliedTest.getResults()) {
							if (result.getDetectedMutants() > 0) {
								if (!failedTestsList.contains(result.getName())) {
									failedTestsList.add(result.getName());
								}
							}
						}
					}
				    for (WodelTestTest appliedTest : appliedTestsList) {
				    	for (WodelTestResultTest result : appliedTest.getResults()) {
							if (result.getDetectedMutants() == 0 && result.getFailures() == 0 && !failedTestsList.contains(result.getName()) && !passedTestsList.contains(result.getName())) {
								passedTestsList.add(result.getName());
							}
						}
				    }
				    for (WodelTestTest appliedTest : appliedTestsList) {
				    	for (WodelTestResultTest result : appliedTest.getResults()) {
				    		if (result.getFailures() > 0) {
				    			errorTestsList.add(result.getName());
				    		}
				    	}
				    }
				    
				    String failedTestsText = "";
				    for (String failedTest : failedTestsList) {
				    	failedTestsText += failedTest + "\n";
				    }
				    String passedTestsText = "";
				    for (String passedTest : passedTestsList) {
				    	passedTestsText += passedTest + "\n";
				    }
				    String errorTestsText = "";
				    for (String errorTest : errorTestsList) {
				    	errorTestsText += errorTest + "\n";
				    }

				    /*
				    canvas.addPaintListener(new PaintListener() {
				    	
						@Override
						public void paintControl(PaintEvent e) {
							
							// TODO Auto-generated method stub
							GC gc = e.gc;
							Bar bar = null;

							for (GlobalResult entry : resultsProvider.getGlobalResults().get(testSuiteName)) {
								int value = 0;
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
//									case "#Tests passed":
//										bar.title = "Tests passed/executed";
//										bar.value2 = (int) entry.value;
//										redSize = (int) ((1.0 * bar.value2 / bar.value1) * 200);
//										greenSize = 200 - redSize;
//										gc.setLineWidth(1);
//										gc.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
//										gc.drawText(bar.title + " (" + String.format("%.0f", bar.value2) + "/" + String.format("%.0f", bar.value1) + ")", 0, 190);
//										gc.setLineWidth(20);
//										gc.setForeground(display.getSystemColor(SWT.COLOR_RED));
//										gc.drawLine(350, 200, 350 + redSize, 200);
//										gc.setForeground(display.getSystemColor(SWT.COLOR_GREEN));
//										gc.drawLine(350 + redSize, 200, 350 + redSize + greenSize, 200);
//										break;
								}
							}
						}
				    });

				    canvas.addMouseListener(new MouseAdapter() {
				    	public void mouseDown(MouseEvent event) {
				    		if (event.button == LEFT_BUTTON) {
				    			Bar bar = null;
				    			for (GlobalResult entry : resultsProvider.getGlobalResults().get(testSuiteName)) {
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
//									case "Mutation score":
//										greenSize = (int) (entry.percent * BAR_SIZE);
//										redSize = BAR_SIZE - greenSize;
//				    					if (event.x >= BAR_START && event.x <= BAR_START + greenSize && event.y >= 100 && event.y <= 120) {
//				    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
//				    							public void run() {
//				    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
//				    								MessageBox messageBox = new MessageBox(shell);
//				    								messageBox.setText("Killed mutants");
//				    								messageBox.setMessage(killedClassesMessage);
//				    								messageBox.open();
//				    							}
//				    						});
//				    					}
//				    					if (event.x >= BAR_START + greenSize && event.x <= BAR_START + greenSize + redSize && event.y >= 100 && event.y <= 120) {
//				    						PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
//				    							public void run() {
//				    								Shell shell = PlatformUI.getWorkbench().getDisplay().getShells()[0];
//				    								MessageBox messageBox = new MessageBox(shell);
//				    								messageBox.setText("Live mutants");
//				    								messageBox.setMessage(liveClassesMessage);
//				    								messageBox.open();
//				    							}
//				    						});
//				    					}
//										break;
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
	*/
					final List<String> killedClasses = killedClassesList;
				    final List<String> equivalentClasses = equivalentClassesList;
				    final List<String> liveClasses = liveClassesList;
				    final List<String> failedTests = failedTestsList;
				    final List<String> passedTests = passedTestsList;
				    final List<String> errorTests = errorTestsList;
				    final String appliedMutatorsMessage = appliedMutatorsText;
				    final String notAppliedMutatorsMessage = notAppliedMutatorsText;
				    final String killedClassesMessage = killedClassesText;
				    final String equivalentClassesMessage = equivalentClassesText;
				    final String liveClassesMessage = liveClassesText;
				    final String failedTestsMessage = failedTestsText;
				    final String passedTestsMessage = passedTestsText;
				    final String errorTestsMessage = errorTestsText;
				    
					Group currentContents = new Group(m_tabFolder, SWT.FILL);
			    	currentContents.setLayout(new GridLayout());
				    
					String equivalentpath = path + "/data/" + testSuiteName + "/classes.equivalent.txt";
					equivalentPaths.put(testSuiteName, equivalentpath);
				    String[] equivalent = WodelTestUtils.loadFile(equivalentpath);
					equivalents.put(testSuiteName, equivalent);
					if (equivalentMutants.get(testSuiteName) == null) {
						equivalentMutants.put(testSuiteName, new String[0]);
					}
				    if (equivalent.length > 0) {
					    equivalentMutants.put(testSuiteName, equivalent[0].split("[|]"));
				    }
				    else {
				    	equivalentMutants.put(testSuiteName, null);
				    }
				    long runningTime = Long.parseLong(globalResults.get(testSuiteName)[0]) / 1000;
				    runningTimes.put(testSuiteName, runningTime);
				    long mutationTime = Long.parseLong(globalResults.get(testSuiteName)[1]) / 1000;
				    mutationTimes.put(testSuiteName, mutationTime);
					numMutantsGenerated = Integer.parseInt(globalResults.get(testSuiteName)[4]);
					int numMutantsNonCompiling = Integer.parseInt(globalResults.get(testSuiteName)[5]);
					int numMutantsCompiling = numMutantsGenerated - numMutantsNonCompiling;
					int numMutantsEquivalent = 0;
					if (equivalentMutants != null && equivalentMutants.get(testSuiteName) != null) {
						numMutantsEquivalent = equivalentMutants.get(testSuiteName).length;
					}
					int numMutantsKilled = 0;
					String resultsPath = path + "/data/" + testSuiteName + "/classes.results.txt";
					List<WodelTestResultClass> mutatorResults = WodelTestResultClass.loadFile(resultsPath);
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
					mutationScore.put(testSuiteName, numMutantsCompiling > 0 ? 1.0 * numMutantsKilled / (numMutantsCompiling - numMutantsEquivalent) : 0);
			    	DecimalFormat formatter = new DecimalFormat("###.##%");
		    		currentContents.setText("#Generated mutants: " + numMutantsGenerated + " - Mutation score: " + formatter.format(mutationScore.get(testSuiteName)) + " - Total running time: " + runningTimes.get(testSuiteName) + " s. - Mutation time: " + mutationTimes.get(testSuiteName) + " s. - Tests execution time: " + (runningTimes.get(testSuiteName) - mutationTimes.get(testSuiteName)) + " s.");
				    currentContents.setVisible(true);
				    currentContents.layout(true, true);

				    contents.put(testSuiteName, currentContents);
		    		
		    		final TabItem tabItem = new TabItem(m_tabFolder, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		    		tabItem.setText(testSuiteName);
		    		tabItem.setControl(currentContents);
		    		m_tabFolder.setVisible(true);
		    		m_tabFolder.layout(true, true);

				    final int numOperatorsNotApplied = numOperatorsSelected - numOperatorsApplied;

				    Group operatorsResults = new Group(currentContents, SWT.FILL);
				    operatorsResults.setLayout(new GridLayout());
				    operatorsResults.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
				    operatorsResults.setText("Mutation operators applied/selected: " + numOperatorsApplied + "/" + numOperatorsSelected);
				    operatorsResults.setVisible(true);
				    operatorsResults.layout(true, true);
				    
				    final JUnitProgressBar fOperatorsBar = new JUnitProgressBar(operatorsResults);
					fOperatorsBar.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
					
				    fOperatorsBar.reset(false, false, numOperatorsApplied, numOperatorsNotApplied, numOperatorsSelected, numOperatorsSelected);
				    fOperatorsBar.setVisible(true);
				    fOperatorsBar.layout(true, true);
				    
				    final int killed = killedClasses.size();
				    final int liveOrEquivalent = liveClasses.size() + equivalentClasses.size();
				    final int totalMutantsCount = killedClasses.size() + liveClasses.size() + equivalentClasses.size();
				    
					Group mutantsResults = new Group(currentContents, SWT.FILL);
				    mutantsResults.setLayout(new GridLayout());
					mutantsResults.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
				    mutantsResults.setText("Killed mutants/total generated mutants: " + killed + "/" + totalMutantsCount);
				    mutantsResults.setVisible(true);
				    mutantsResults.layout(true, true);

				    final JUnitProgressBar fMutantsBar = new JUnitProgressBar(mutantsResults);
					fMutantsBar.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
					
				    fMutantsBar.reset(false, false, killed, liveOrEquivalent, totalMutantsCount, totalMutantsCount);
				    fMutantsBar.setVisible(true);
				    fMutantsBar.layout(true, true);

				    final int passed = passedTests.size();
				    final int failed = failedTests.size();
				    final int total = passedTests.size() + failedTests.size();
				    
					Group testsResults = new Group(currentContents, SWT.FILL);
				    testsResults.setLayout(new GridLayout());
					testsResults.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
				    testsResults.setText("Failed tests/total tests: " + failed + "/" + total);
				    testsResults.setVisible(true);
				    testsResults.layout(true, true);

				    final JUnitProgressBar fTestsBar = new JUnitProgressBar(testsResults);
					fTestsBar.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
					
				    fTestsBar.reset(false, false, failed, passed, total, total);
				    fTestsBar.setVisible(true);
				    fTestsBar.layout(true, true);

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
			}
			
		    
		    getSite().getPage().addPartListener(this);
		}
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
		if ((projects = WodelTestUtils.getOpenWodelTestSUTProjects()) == null || (projects.isEmpty())) {
			return;
		}
		// TODO Auto-generated method stub
		if (partDeactivated == false) {
			resultsProvider = new GlobalResultsProvider();
			if (contents != null) {
				for (IProject project : projects) {
					testSuiteNames = new ArrayList<String>();
					testSuiteNames.addAll(WodelTestUtils.getTestSuitesNames(project));
					for (String testSuiteName : testSuiteNames) {
						if (contents.get(testSuiteName) != null) {
							contents.get(testSuiteName).layout();
							contents.get(testSuiteName).redraw();
						}
					}
				}
			}
	    }
		partDeactivated = false;
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
		partDeactivated = true;

	}

	@Override
	public void partOpened(IWorkbenchPart part) {
		// TODO Auto-generated method stub
		
	}
}
