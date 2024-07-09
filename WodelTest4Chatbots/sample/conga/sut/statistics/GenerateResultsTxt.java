package statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import wodel.utils.manager.WodelTestClass;
import wodel.utils.manager.WodelTestClassInfo;
import wodel.utils.manager.WodelTestResult;
import wodel.utils.manager.WodelTestResultClass;
import wodel.utils.manager.WodelTestUtils;
import wodel.utils.manager.WodelTestResultInfo;
import wodel.utils.manager.WodelTestResultTest;
import wodel.utils.manager.WodelTestTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodeltest.extension.utils.WodelTestMutatorResult;

import appliedMutations.AttributeChanged;
import appliedMutations.InformationChanged;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ReferenceChanged;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;

public class GenerateResultsTxt {
	
	private static final String projectPath = GenerateResultsTxt.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(0, GenerateResultsTxt.class.getProtectionDomain().getCodeSource().getLocation().toString().lastIndexOf("/")).substring(0, GenerateResultsTxt.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(0, GenerateResultsTxt.class.getProtectionDomain().getCodeSource().getLocation().toString().lastIndexOf("/")).lastIndexOf("/")).replace("file:/", "");
	private static final String projectName = projectPath.substring(projectPath.lastIndexOf("/") + 1, projectPath.length());
	private static final String wodelTestProjectPath = "C:/eclipse/runtime-EclipseApplicationpersonal-bot/testBotGenerator";
	private static final String outputPath = wodelTestProjectPath + "/data/out";
	
	public static TreeMap<String, List<String>> loadClasses(String path) {
		TreeMap<String, List<String>> classes = new TreeMap<String, List<String>>();
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] values = line.split("[|]");
				List<String> paths = new ArrayList<String>();
				for (int i = 1; i < values.length; i++) {
					paths.add(values[i]);
				}
				classes.put(values[0], paths);
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		return classes;
	}
	
	public static String[] loadFile(String path) {
		String[] data = new String[0];
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			int i = 0;
			while ((line = br.readLine()) != null) {
				data = Arrays.copyOf(data, i + 1);
				data[i] = line;
				i++;
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		return data;
	}
	public static List<String> getMutationTextList(String projectName, String packagename, String sourcepath) {
		List<String> mutationTextList = new ArrayList<String>();
		try {
			String mutantpath = packagename.length() > 0 ? sourcepath.substring(sourcepath.indexOf(packagename) + (packagename + "/").length(), sourcepath.length()) : sourcepath.indexOf(projectName) > 0 ? sourcepath.substring(sourcepath.indexOf(projectName) + (projectName + "/").length(), sourcepath.length()) : sourcepath;
			String blockName = mutantpath.indexOf("/") > 0 ? mutantpath.substring(0, mutantpath.indexOf("/")) : "";
			String modelName = blockName.length() > 0 ? mutantpath.substring(mutantpath.indexOf(blockName) + (blockName + "/").length(), mutantpath.length()) : mutantpath;
			if (modelName.indexOf("/") != -1) {
				modelName = modelName.substring(0, modelName.indexOf("/")) + ".model";
			}
			else if (modelName.indexOf(".") != -1){
				modelName = modelName.substring(0, modelName.indexOf(".")) + ".model";
			}
			else {
				return mutationTextList;
			}
			String path = outputPath + "/" + projectName + "/" + blockName + "/" + modelName;
			if (!modelName.contains("_") && path.contains("out")) {
				String registryName = modelName.replace(".model", "Registry.model");
				String registryPath = path.substring(0, path.lastIndexOf("/") + 1) + "registry" + "/" + registryName;
				if (new File(registryPath).exists()) {
//					Bundle bundle = Platform.getBundle("wodel.models");
//					URL fileURL = bundle.getEntry("/model/AppliedMutations.ecore");
//					String ecore = FileLocator.resolve(fileURL).getFile();
					String ecore = "C:/eclipse/workspace/wodel.models/model/AppliedMutations.ecore";
					List<EPackage> packages = ModelManager.loadMetaModel(ecore);
					Resource registry = ModelManager.loadModel(packages, registryPath);
					List<EObject> objects = ModelManager.getAllObjects(registry);
					List<EObject> mutations = MutatorUtils.getMutations(objects);
					for (EObject mutation : mutations) {
						if (mutation.eClass().getName().equals("InformationChanged")) {
							InformationChanged mut = (InformationChanged) mutation;
							String mutationText = "modify information mutator: ";
							List<AttributeChanged> attChanges = mut.getAttChanges();
							for (AttributeChanged attChange : attChanges) {
								mutationText += attChange.getOldVal() + " replaced by " + attChange.getNewVal();
							}
							List<ReferenceChanged> refChanges = mut.getRefChanges();
							for (ReferenceChanged refChange : refChanges) {
								EObject from = refChange.getFrom();
								EObject to = refChange.getTo();
								if (from != null && to != null) {
									mutationText += "source " + from.eClass().getName() + " to " + to.eClass().getName();
								}
							}
							mutationTextList.add(mutationText);
						}
						if (mutation.eClass().getName().equals("ObjectRemoved")) {
							ObjectRemoved mut = (ObjectRemoved) mutation;
							String mutationText = "remove object mutator: ";
							mutationText += mut.getType().getName() + " object removed";
							mutationTextList.add(mutationText);
						}
						if (mutation.eClass().getName().equals("ObjectCreated")) {
							ObjectCreated mut = (ObjectCreated) mutation;
							String mutationText = "create object mutator: ";
							if (mut.getObject().size() > 0) {
								mutationText += mut.getObject().get(0).eClass().getName() + " object created";
							}
							mutationTextList.add(mutationText);
						}
					}
				}
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mutationTextList;
	}

	
	public static WodelTestClassInfo getInfo(String projectName, String packagename, String infopath, String classpath) {
		WodelTestClassInfo info = new WodelTestClassInfo();
		info.packagename = packagename;
		info.path = classpath;
		try {
			FileReader fr = new FileReader(infopath);
			BufferedReader br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				String infoLine = null;
				String[] values = line.split("[|]");
				String path = values[0].replaceAll("\\\\", "/");
				if (path.equals(classpath)) {
					infoLine = line;
				}
				else {
					if (path.endsWith("/")) {
						path = path.substring(0, path.length() - 1);
					}
					String processedClasspath = classpath;
					if (processedClasspath.indexOf("/") != -1) {
						if (processedClasspath.indexOf("/src/") != -1) {
							String pck = processedClasspath.substring(0, processedClasspath.indexOf("/src/"));
							processedClasspath = processedClasspath.substring(processedClasspath.indexOf("/src/") + "/src".length(), processedClasspath.length());
							processedClasspath = pck + "/" + processedClasspath.substring(1, processedClasspath.length()).replace("/", ".");
							processedClasspath = processedClasspath.substring(0, processedClasspath.indexOf(".java"));
						}
					}
					if (classpath.indexOf("/") != -1 && path.startsWith(processedClasspath)) {
						infoLine = line;
					}
					if (infoLine == null && classpath.indexOf("/") != -1 && (classpath.substring(0, classpath.lastIndexOf("/")).startsWith(path))) {
						infoLine = line;
					}
				}
				if (infoLine != null) {
					String[] test = values[3].split(":");
					if (info.tests == null) {
						info.tests = new ArrayList<WodelTestResultInfo>();
					}
					int index = 6;
					values = infoLine.split("[|]");
					int value = 0;
					while (index < values.length) {
						try {
							value = Integer.parseInt(values[index++]);
						}
						catch (NumberFormatException ex) {
							continue;
						}
						break;
					}
					value = 0;
					while (index < values.length) {
						try {
							value = Integer.parseInt(values[index++]);
						}
						catch (NumberFormatException ex) {
							continue;
						}
						break;
					}
					String[] messagesText = values[4].split(";");
					String[] failureText = values[5].split(";");
					int i = 0;
					for (String t : test) {
						String[] pair = t.split("=");
						if (pair.length > 1) {
							WodelTestResultInfo result = null;
							boolean notAdded = true;
							for (WodelTestResultInfo tt : info.tests) {
								if (tt.name.equals(pair[0])) {
									result = tt;
									notAdded = false;
									break;
								}
							}
							if (notAdded == false) {
								result.value = result.value || Boolean.parseBoolean(pair[1]);
								result.numExecutions ++;
								result.numFailed = Boolean.parseBoolean(pair[1]) ? result.numFailed + 1 : result.numFailed;
								result.message = messagesText.length > i ? result.message + "|" + messagesText[i].trim() : "";
								if (Boolean.parseBoolean(pair[1]) == false) {
									result.failure = failureText.length > i ? result.failure || Boolean.parseBoolean(failureText[i]) : false;
									if (Boolean.parseBoolean(failureText[i]) == true) {
										info.numFailures++;
									}
								}
								i++;
								continue;
							}
							result = new WodelTestResultInfo();
							result.name = pair[0];
							result.value = Boolean.parseBoolean(pair[1]);
							result.numExecutions = 1;
							result.numFailed = result.value ? 1 : 0;
							result.message = messagesText.length > i ? messagesText[i].trim() : "";
							if (result.value == false) {
								result.failure = failureText.length > i ? Boolean.parseBoolean(failureText[i]) : false;
								if (result.failure == true) {
									info.numFailures++;
								}
							}
							i++;
							info.tests.add(result);
						}
					}
				}
			}
			br.close();
			fr.close();
		} catch (IOException ex){
		}
		info.mutationText = getMutationTextList(projectName, info.packagename, info.path);
		return info;
	}
	
	public static Map<String, List<WodelTestClass>> getPackageClasses(String projectName, String path, String pathResults) {
		TreeMap<String, List<String>> classes = loadClasses(path);
		Map<String, List<WodelTestClass>> packageClasses = new HashMap<String, List<WodelTestClass>>();
		if (classes.size() > 0) {
			for (String classname : classes.keySet()) {
				String[] splitted = classname.split("\\.");
				String packagename = "";
				for (String value : Arrays.asList(splitted).subList(0, splitted.length - 1)) {
					packagename += value + ".";
				}
				if (packagename.equals("")) {
					packagename = "default";
				}
				else {
					packagename = packagename.substring(0, packagename.length() - 1);
				}
				String clsname = splitted[splitted.length - 1];
				WodelTestClass wodelTestClass = new WodelTestClass();
				wodelTestClass.depth = true;
				wodelTestClass.classname = clsname;
				List<String> paths = classes.get(classname);
				List<WodelTestClass> currentClasses = packageClasses.get(packagename);
				if (currentClasses == null) {
					currentClasses = new ArrayList<WodelTestClass>();
				}
				wodelTestClass.info = new ArrayList<WodelTestClassInfo>();
				for (String classpath : paths) {
					if (!packagename.equals("default")) {
						wodelTestClass.info.add(getInfo(projectName, packagename, pathResults, classpath));
					}
					else {
						wodelTestClass.info.add(getInfo(projectName, "", pathResults, classpath));
					}
				}
				currentClasses.add(wodelTestClass);
				packageClasses.put(packagename, currentClasses);
			}
		}
		else {
			String[] values = loadFile(pathResults);
			List<WodelTestClass> currentClasses = new ArrayList<WodelTestClass>();
			for (String value : values) {
				String data[] = value.split("[|]");
				WodelTestClass wodelTestClass = null;
				for (WodelTestClass currentClass : currentClasses) {
					if (currentClass.classname.equals(data[0])) {
						wodelTestClass = currentClass;
						break;
					}
				}
				if (wodelTestClass == null) {
					wodelTestClass = new WodelTestClass();
					currentClasses.add(wodelTestClass);
				}
				wodelTestClass.depth = false;
				wodelTestClass.classname = data[0];
				if (wodelTestClass.info == null) {
					wodelTestClass.info = new ArrayList<WodelTestClassInfo>();
					wodelTestClass.info.add(getInfo(projectName, "", pathResults, data[0]));
				}
			}
			packageClasses.put("default", currentClasses);
		}
		return packageClasses;
	}
	
	private static List<String> getMutators(File folder) {
		List<String> mutators = new ArrayList<String>();
		if (folder.exists() && folder.isDirectory()) {
			for (File file : folder.listFiles()) {
				if (file.isFile()) {
					if (file.getName().endsWith(".mutator")) {
						String mutatorName = file.getName().replace(".mutator", "");
						if (!mutators.contains(mutatorName)) {
							mutators.add(mutatorName);
						}
					}
				}
				if (file.isDirectory()) {
					List<String> innerMutators = getMutators(file);
					for (String mutatorName : innerMutators) {
						if (!mutators.contains(mutatorName)) {
							mutators.add(mutatorName);
						}
					}
				}
			}
		}

		return mutators;
	}
	
	public static List<String> getTestSuitesNames() {
		List<String> testSuitesNames = new ArrayList<String>();
		String path = projectPath;
		try {
			BufferedReader br = new BufferedReader(new FileReader(path + "/data/" + projectName + ".test.txt"));
			br.readLine();
			String line = null;
			while ((line = br.readLine()) != null) {
				testSuitesNames.add(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testSuitesNames;
	}
	
	private static void generateResultsTxt() {
		String zipPath = projectPath + "/zip";
		File zipFolder = new File(zipPath);
		String chatbotName = "";
		if (zipFolder.exists() && zipFolder.isDirectory() && zipFolder.listFiles().length > 0) {
			File[] chatbotFiles = zipFolder.listFiles();
			chatbotName = chatbotFiles[0].getName();
			chatbotName = chatbotName.substring(0, chatbotName.indexOf(".zip"));
		}
		List<String> testSuiteNames = getTestSuitesNames();
		//String testSuiteName = Platform.getPreferencesService().getString("WodelTest", "Current test-suite", WodelTestUtils.getTestSuiteName(project), null);
		Map<String, String> globalResultsPaths = new TreeMap<String, String>();
		Map<String, String[]> globalResults = new TreeMap<String, String[]>();
		Map<String, String> equivalentPaths = new TreeMap<String, String>();
		Map<String, String[]> equivalents = new TreeMap<String, String[]>();
		Map<String, Long> runningTimes = new TreeMap<String, Long>();
		Map<String, Long> mutationTimes = new TreeMap<String, Long>();
		Map<String, Map<String, List<WodelTestClass>>> packageClasses = new TreeMap<String, Map<String, List<WodelTestClass>>>();
		Map<String, Map<String, List<WodelTestClass>>> classes = new TreeMap<String, Map<String, List<WodelTestClass>>>();
		Map<String, List<WodelTestTest>> tests = new TreeMap<String, List<WodelTestTest>>();
		Map<String, List<String>> executedTests = new TreeMap<String, List<String>>();
		Map<String, Integer> numberOfTestsExecuted = new TreeMap<String, Integer>();
		Map<String, List<String>> failedTests = new TreeMap<String, List<String>>();
		Map<String, Integer> numberOfTestsFailed = new TreeMap<String, Integer>();
		Map<String, String[]> equivalentMutants = new TreeMap<String, String[]>();
	    String classespath = projectPath + "/data/classes.txt";
	    for (String testSuiteName : testSuiteNames) {
			String globalResultsPath = projectPath + "/data/" + testSuiteName + "/" + projectName + ".global.results.txt";
			globalResultsPaths.put(testSuiteName, globalResultsPath);
			globalResults.put(testSuiteName, WodelTestUtils.loadFile(globalResultsPath));
			String equivalentpath = projectPath + "/data/" + testSuiteName + "/classes.equivalent.txt";
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
		    if (globalResults.get(testSuiteName).length > 1) {
			    long runningTime = Long.parseLong(globalResults.get(testSuiteName)[0]) / 1000;
			    runningTimes.put(testSuiteName, runningTime);
			    long mutationTime = Long.parseLong(globalResults.get(testSuiteName)[1]) / 1000;
			    mutationTimes.put(testSuiteName, mutationTime);
		    }
		    String infopath = projectPath + "/data/" + testSuiteName + "/classes.results.txt";
		    Map<String, List<WodelTestClass>> pckClasses = getPackageClasses(projectName, classespath, infopath);
		    packageClasses.put(testSuiteName, pckClasses);
		    Map<String, List<WodelTestClass>> clss = new TreeMap<String, List<WodelTestClass>>();
		    for (String pckName : pckClasses.keySet()) {
		    	List<WodelTestClass> pckclasses = WodelTestUtils.getClasses(pckClasses, pckName, projectName, classespath, infopath);
		    	clss.put(pckName, pckclasses);
		    }
		    classes.put(testSuiteName, clss);

		    List<WodelTestTest> currentTotalTests = WodelTestUtils.getTests(packageClasses.get(testSuiteName), projectName, classespath, infopath);
		    List<String> totalTests = new ArrayList<String>();
		    tests.put(testSuiteName, currentTotalTests);
		    for (WodelTestTest t : currentTotalTests) {
		    	List<WodelTestResultTest> results = t.getResults();
				for (WodelTestResultTest testResult : results) {
			    	String tName = testResult.getName();
					if (tName.indexOf("(C\\\\") != -1) {
						tName = tName.substring(0, tName.indexOf("(C\\\\")).trim();
					}
					boolean found = false;
					for (String totalTest : totalTests) {
						if (tName.equals(totalTest)) {
							found = true;
							break;
						}
					}
					if (!found) {
						totalTests.add(tName);
					}
				}
		    }
		    executedTests.put(testSuiteName, totalTests);
		    numberOfTestsExecuted.put(testSuiteName, totalTests.size());
	    }
		
		List<String> mutators = getMutators(new File(wodelTestProjectPath));
		
		Map<String, Map<String, List<WodelTestMutatorResult>>> mutatorData = new TreeMap<String, Map<String, List<WodelTestMutatorResult>>>();
		Map<String, Integer> numMutatorsAppliedMap = new TreeMap<String, Integer>();
		Map<String, Integer> numMutantsKilledMap = new TreeMap<String, Integer>();
		Map<String, Map<String, Integer>> numMutantsGeneratedByBlockMap = new TreeMap<String, Map<String, Integer>>();
		Map<String, Integer> numMutantsGeneratedByMutationOperator = new TreeMap<String, Integer>();
		Map<String, Map<String, Integer>> numMutantsKilledByBlockMap = new TreeMap<String, Map<String, Integer>>();
		Map<String, Map<String, List<String>>> mutantsLiveByBlockMap = new TreeMap<String, Map<String, List<String>>>();
		Map<String, Map<String, List<String>>> mutantsKilledByBlockMap = new TreeMap<String, Map<String, List<String>>>();
		Map<String, Integer> numMutantsGeneratedMap = new TreeMap<String, Integer>();
		Map<String, Integer> numMutantsNonCompilingMap = new TreeMap<String, Integer>();
		Map<String, Integer> numMutantsCompilingMap = new TreeMap<String, Integer>();
		Map<String, Integer> numMutantsEquivalentMap = new TreeMap<String, Integer>();
		Map<String, Double> mutationScoreMap = new TreeMap<String, Double>();
		Map<String, String> mutatorDescription = new TreeMap<String, String>();
		Map<String, Map<String, List<String>>> testsFailedByBlockMap = new TreeMap<String, Map<String, List<String>>>();
		Map<String, Map<String, Integer>> numTestsFailedByBlockMap = new TreeMap<String, Map<String, Integer>>();
		List<EObject> blocks = null;
		try {
//			Bundle bundle = Platform.getBundle("wodel.models");
//			URL fileURL = bundle.getEntry("/model/MutatorEnvironment.ecore");
//			String ecore = FileLocator.resolve(fileURL).getFile();
			String ecore = "C:/eclipse/workspace/wodel.models/model/MutatorEnvironment.ecore";
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore);
			for (String mutator : mutators) {
				Resource model = ModelManager.loadModelNoException(mutatorpackages, outputPath + "/" + mutator + ".model");
				blocks = MutatorUtils.getBlocks(model);
				for (String testSuiteName : testSuiteNames) {
					Map<String, Integer> numMutantsGeneratedByBlock = new TreeMap<String, Integer>();
					Map<String, Integer> numMutantsKilledByBlock = new TreeMap<String, Integer>();
					Map<String, List<String>> mutantsKilledByBlock = new TreeMap<String, List<String>>();
					Map<String, List<String>> mutantsLiveByBlock = new TreeMap<String, List<String>>();
					Map<String, List<WodelTestMutatorResult>> testSuiteMutatorData = new TreeMap<String, List<WodelTestMutatorResult>>();
					int numMutantsGenerated = 0;
					for (EObject block : blocks) {
						String name = ModelManager.getStringAttribute("name", block);
						String description = ModelManager.getStringAttribute("description", block);
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
						List<WodelTestMutatorResult> results = testSuiteMutatorData.get(name);
						if (results == null) {
							results = new ArrayList<WodelTestMutatorResult>();
						}
						testSuiteMutatorData.put(name, results);
						results.add(wtmr);
						int numMutatorsApplied = globalResults.get(testSuiteName).length > 3 ? Integer.parseInt(globalResults.get(testSuiteName)[3]) : 0;
						numMutatorsAppliedMap.put(testSuiteName, numMutatorsApplied);
						//for (WodelTestMutatorResult wtmr : mutatorData) {
						//	if (wtmr.getNumberOfMutants() > 0) {
						//		numMutatorsApplied++;
						//	}
						//}
					}
					String resultsPath = projectPath + "/data/" + testSuiteName + "/classes.results.txt";
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

					for (EObject block : blocks) {
						String name = ModelManager.getStringAttribute("name", block);
						String description = ModelManager.getStringAttribute("description", block);
						int numMutantsKilledBlock = 0;
						for (WodelTestResultClass mutatorResultClass : mutatorResults) {
							if (mutatorResultClass.getName().contains("/" + name + "/") || mutatorResultClass.getName().contains("\\" + name + "\\")) {
								boolean killed = false;
								for (WodelTestResult mutatorResult : mutatorResultClass.getResults()) {
									if (mutatorResult.getFailureCount() > 0) {
										killed = true;
										break;
									}
								}
								if (killed == true) {
									numMutantsKilledBlock++;
								}
							}
						}
						numMutantsKilledByBlock.put(name, numMutantsKilledBlock);
						mutatorDescription.put(name, description);
						List<String> liveMutants = mutantsLiveByBlock.get(name);
						if (liveMutants == null) {
							liveMutants = new ArrayList<String>();
						}
						for (WodelTestResultClass mutatorResultClass : mutatorResults) {
							if (mutatorResultClass.getName().contains("/" + name + "/") || mutatorResultClass.getName().contains("\\" + name + "\\")) {
								for (WodelTestResult mutatorResult : mutatorResultClass.getResults()) {
									if (mutatorResult.getFailureCount() == 0) {
										String mutant = mutatorResult.getClassName().substring(mutatorResult.getClassName().lastIndexOf("/"), mutatorResult.getClassName().length());
										if (!liveMutants.contains(mutant)) {
											liveMutants.add(mutant);
										}
									}
								}
							}
						}
						mutantsLiveByBlock.put(name, liveMutants);
						List<String> killedMutants = mutantsKilledByBlock.get(name);
						if (killedMutants == null) {
							killedMutants = new ArrayList<String>();
						}
						for (WodelTestResultClass mutatorResultClass : mutatorResults) {
							if (mutatorResultClass.getName().contains("/" + name + "/") || mutatorResultClass.getName().contains("\\" + name + "\\")) {
								for (WodelTestResult mutatorResult : mutatorResultClass.getResults()) {
									if (mutatorResult.getFailureCount() > 0) {
										String mutant = mutatorResult.getClassName().substring(mutatorResult.getClassName().lastIndexOf("/"), mutatorResult.getClassName().length());
										if (!killedMutants.contains(mutant)) {
											killedMutants.add(mutant);
										}
									}
								}
							}
						}
						mutantsKilledByBlock.put(name, killedMutants);
						numMutantsKilledByBlock.put(name, numMutantsKilledBlock);
						numMutantsGeneratedByMutationOperator.put(name, numMutantsKilledBlock + liveMutants.size());
						numMutantsGenerated += numMutantsKilledBlock + liveMutants.size();
					}
					
					int numMutantsNonCompiling = 0;
					int numMutantsCompiling = 0;
					int numMutantsEquivalent = 0;
					if (globalResults.get(testSuiteName).length > 5) {
						//numMutantsGenerated = Integer.parseInt(globalResults.get(testSuiteName)[4]);
						numMutantsNonCompiling = Integer.parseInt(globalResults.get(testSuiteName)[5]);
						numMutantsCompiling = numMutantsGenerated - numMutantsNonCompiling;
						numMutantsEquivalent = 0;
						if (equivalentMutants != null && equivalentMutants.get(testSuiteName) != null) {
							numMutantsEquivalent = equivalentMutants.get(testSuiteName).length;
						}
					}
					if (globalResults.get(testSuiteName).length <= 5) {
						numMutantsCompiling = numMutantsGenerated;
					}
					
					double mutationScore = numMutantsCompiling > 0 ? 1.0 * numMutantsKilled / (numMutantsCompiling - numMutantsEquivalent) : 0;
					numMutantsKilledMap.put(testSuiteName, numMutantsKilled);
					numMutantsKilledByBlockMap.put(testSuiteName, numMutantsKilledByBlock);
					numMutantsGeneratedMap.put(testSuiteName, numMutantsGenerated);
					numMutantsCompilingMap.put(testSuiteName, numMutantsCompiling);
					numMutantsNonCompilingMap.put(testSuiteName, numMutantsNonCompiling);
					numMutantsEquivalentMap.put(testSuiteName, numMutantsEquivalent);
					mutationScoreMap.put(testSuiteName, mutationScore);
					mutatorData.put(testSuiteName, testSuiteMutatorData);
					mutantsLiveByBlockMap.put(testSuiteName, mutantsLiveByBlock);
					mutantsKilledByBlockMap.put(testSuiteName, mutantsKilledByBlock);
					numMutantsGeneratedByBlockMap.put(testSuiteName, numMutantsGeneratedByBlock);

				    Map<String, Integer> numTestsFailedByBlock = new TreeMap<String, Integer>();
					Map<String, List<String>> testsFailedByBlock = new TreeMap<String, List<String>>();
					for (String className : classes.get(testSuiteName).keySet()) {
						List<WodelTestClass> classList = classes.get(testSuiteName).get(className);
						for (EObject block : blocks) {
							String name = ModelManager.getStringAttribute("name", block);
							for (WodelTestClass cls : classList) {
								for (WodelTestClassInfo info : cls.info) {
									if (info.getNumFailedTests() > 0 && info.path.contains("/" + name + "/")) {
										if (info.tests != null) {
											for (WodelTestResultInfo test : info.tests) {
												if (test.value == true) {
													String newTestName = test.name;
													if (newTestName.indexOf("(C\\\\") != -1) {
														newTestName = newTestName.substring(0, newTestName.indexOf("(C\\\\")).trim();
													}
													List<String> wodelTestResultTest = new ArrayList<String>();
													if (testsFailedByBlock.get(name) != null) {
														wodelTestResultTest = testsFailedByBlock.get(name);
													}
													boolean found = false;
													for (String wodelTestResultT : wodelTestResultTest) {
														String testName = wodelTestResultT;
														if (testName.indexOf("(C\\\\") != -1) {
															testName = testName.substring(0, testName.indexOf("(C\\\\")).trim();
														}
														if (testName.equals(newTestName)) {
															found = true;
															break;
														}
													}
													if (!found) {
														wodelTestResultTest.add(newTestName);
													}
													testsFailedByBlock.put(name, wodelTestResultTest);
												}
											}
										}
									}
								}
							}
						}
					}
					for (EObject block : blocks) {
						String name = ModelManager.getStringAttribute("name", block);
						if (testsFailedByBlock.get(name) == null) {
							numTestsFailedByBlock.put(name, 0);
						}
						else {
							numTestsFailedByBlock.put(name, testsFailedByBlock.get(name).size());
						}
					}
					testsFailedByBlockMap.put(testSuiteName, testsFailedByBlock);
					numTestsFailedByBlockMap.put(testSuiteName, numTestsFailedByBlock);
					List<String> testF = new ArrayList<String>();
					for (EObject block : blocks) {
						String name = ModelManager.getStringAttribute("name", block);
						if (testsFailedByBlock.get(name) != null) {
							for (String t : testsFailedByBlock.get(name)) {
								if (!testF.contains(t)) {
									testF.add(t);
								}
							}
						}
					}
					failedTests.put(testSuiteName, testF);
					numberOfTestsFailed.put(testSuiteName, testF.size());
				}
			}
//			String[][] data = new String[10][];
//			if (10 > 0) {
//				int k = 0;
//				for (List<String> dataList : metamorphicDataList) {
//					data[k] = new String[dataList.size()];
//					for (int i = 0; i < dataList.size(); i++) {
//						data[k][i] = dataList.get(i);
//					}
//					k++;
//				}
//			}
//			String[] header = new String[6];
//			header[0] = "Processor ID";
//			header[1] = "RuleName";
//			header[2] = "Models";
//			header[3] = "Result";
//			header[4] = "Is evaluable";
//			header[5] = "Instantiated MeT Rule";
//			String folderName =  projectPath + "/results";
//			File folder = new File(folderName);
//			if (!folder.exists() || !folder.isDirectory()) {
//				folder.mkdir();
//			}
//			ConvertToCSV.writeCSV(folderName + "/statistics.csv", header, data);
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int totalNumberOfGeneratedMutants = 0;
		int totalNumberOfAppliedTests = 0;
		if (testSuiteNames.size() > 0) {
			if (numMutantsGeneratedMap.get(testSuiteNames.get(0)) != null) {
				totalNumberOfGeneratedMutants = numMutantsGeneratedMap.get(testSuiteNames.get(0));
				Map<String, List<String>> liveMutants = new TreeMap<String, List<String>>();
				Map<String, List<String>> killedMutants = new TreeMap<String, List<String>>();
				Map<String, List<AbstractMap.SimpleEntry<String, Integer>>> overlappedMutants = new TreeMap<String, List<AbstractMap.SimpleEntry<String, Integer>>>();
				Map<String, List<String>> testsFailed = new TreeMap<String, List<String>>();
				for (String testSuiteName : testSuiteNames) {
					totalNumberOfAppliedTests += executedTests.get(testSuiteName).size();
					if (numMutantsGeneratedMap.get(testSuiteName) > 0) {
						for (String blockName : mutatorData.get(testSuiteName).keySet()) {
							if (testsFailedByBlockMap.get(testSuiteName).get(blockName) != null) {
								for (String failedTest : testsFailedByBlockMap.get(testSuiteName).get(blockName)) {
									List<String> testsF = new ArrayList<String>();
									if (testsFailed.get(blockName) != null) {
										testsF = testsFailed.get(blockName);
									}
									if (!testsF.contains(failedTest)) {
										testsF.add(failedTest);
									}
									testsFailed.put(blockName, testsF);
								}
							}

							List<WodelTestMutatorResult> results = mutatorData.get(testSuiteName).get(blockName);
							for (WodelTestMutatorResult result : results) {
								if (result.getNumberOfMutants() > 0) {
									if (numMutantsKilledByBlockMap.get(testSuiteName).get(blockName) < result.getNumberOfMutants()) {
										mutantsLiveByBlockMap.get(testSuiteName).get(blockName).sort(new Comparator<String>() {
											@Override
											public int compare(String o1, String o2) {
												return Integer.valueOf(o1.substring("/Output".length(), o1.indexOf(".zip"))) - Integer.valueOf(o2.substring("/Output".length(), o2.indexOf(".zip")));
											}
										});
									}
								}
							}
						}
						for (String blockName : mutatorData.get(testSuiteName).keySet()) {
							List<String> killed = new ArrayList<String>();
							List<AbstractMap.SimpleEntry<String, Integer>> overlapped = new ArrayList<AbstractMap.SimpleEntry<String, Integer>>();
							if (killedMutants.get(blockName) == null) {
								killedMutants.put(blockName, killed);
							}
							killed = killedMutants.get(blockName);
							if (overlappedMutants.get(blockName) == null) {
								overlappedMutants.put(blockName, overlapped);
							}
							overlapped = overlappedMutants.get(blockName);
							for (String mutant : mutantsKilledByBlockMap.get(testSuiteName).get(blockName)) {
								killed.add(mutant);
								AbstractMap.SimpleEntry<String, Integer> occ = new AbstractMap.SimpleEntry<String, Integer>(mutant, 1);
								boolean found = false;
								for (AbstractMap.SimpleEntry<String, Integer> mutOcc : overlapped) {
									if (mutOcc.getKey().equals(occ.getKey())) {
										mutOcc.setValue(mutOcc.getValue() + 1);
										found = true;
									}
								}
								if (!found) {
									overlapped.add(occ);
								}
							}
						}
						if (liveMutants.size() == 0) {
							for (String blockName : mutatorData.get(testSuiteName).keySet()) {
								List<String> live = new ArrayList<String>();
								if (liveMutants.get(blockName) == null) {
									liveMutants.put(blockName, live);
								}
								live = liveMutants.get(blockName);
								for (String mutant : mutantsLiveByBlockMap.get(testSuiteName).get(blockName)) {
									live.add(mutant);
								}
							}
						}
						else {
							for (String blockName : mutatorData.get(testSuiteName).keySet()) {
								if (liveMutants.get(blockName) != null) {
									if (mutantsLiveByBlockMap.get(testSuiteName).get(blockName).size() == 0) {
										liveMutants.get(blockName).clear();
									}
									else {
										List<String> live = new ArrayList<String>();
										live.addAll(liveMutants.get(blockName));
										for (String mutant : liveMutants.get(blockName)) {
											if (!mutantsLiveByBlockMap.get(testSuiteName).get(blockName).contains(mutant)) {
												live.remove(mutant);
											}
										}
										liveMutants.put(blockName, live);
									}
								}
							}
						}
					}
				}
				int numLiveMutants = 0;
				for (String blockName : liveMutants.keySet()) {
					if (liveMutants.get(blockName).size() > 0) {
						liveMutants.get(blockName).sort(new Comparator<String>() {
							@Override
							public int compare(String o1, String o2) {
								return Integer.valueOf(o1.substring("/Output".length(), o1.indexOf(".zip"))) - Integer.valueOf(o2.substring("/Output".length(), o2.indexOf(".zip")));
							}
							
						});
						numLiveMutants += liveMutants.get(blockName).size();
					}
				}
				int numOverlappedMutants = 0;
				Map<String, List<String>> simpleOverlappedMutants = new TreeMap<String, List<String>>();
				for (String blockName : overlappedMutants.keySet()) {
					List<String> simpleOverlapped = new ArrayList<String>();
					if (simpleOverlappedMutants.get(blockName) == null) {
						simpleOverlappedMutants.put(blockName, simpleOverlapped);
					}
					simpleOverlapped = simpleOverlappedMutants.get(blockName);
					List<AbstractMap.SimpleEntry<String, Integer>> overlapped = overlappedMutants.get(blockName);
					if (overlapped.size() > 0) {
						for (AbstractMap.SimpleEntry<String, Integer> occ : overlapped) {
							if (occ.getValue() > 2) {
								simpleOverlapped.add(occ.getKey());
								numOverlappedMutants++;
							}
						}
					}
					simpleOverlappedMutants.put(blockName, simpleOverlapped);
					simpleOverlappedMutants.get(blockName).sort(new Comparator<String>() {
						@Override
						public int compare(String o1, String o2) {
							return Integer.valueOf(o1.substring("/Output".length(), o1.indexOf(".zip"))) - Integer.valueOf(o2.substring("/Output".length(), o2.indexOf(".zip")));
						}
						
					});
				}
				List<String> overallFailedTests = new ArrayList<String>();
				for (String blockName : testsFailed.keySet()) {
					for (String testFailed : testsFailed.get(blockName)) {
						if (!overallFailedTests.contains(testFailed)) {
							overallFailedTests.add(testFailed);
						}
					}
				}
				System.out.println("Overall results for (" + chatbotName + ") ---------------------------");
				System.out.println("#Generated mutants: " + totalNumberOfGeneratedMutants);
				double percent = totalNumberOfGeneratedMutants > 0 ? (totalNumberOfGeneratedMutants - numLiveMutants) * 100.0 / totalNumberOfGeneratedMutants : 0;
				System.out.println("#Killed mutants --- killed at least by one test-suite: " + (totalNumberOfGeneratedMutants - numLiveMutants) + " (" + String.format("%.2f", percent) + "%)");
				percent = totalNumberOfGeneratedMutants > 0 ? numLiveMutants * 100.0 / totalNumberOfGeneratedMutants : 0;
				System.out.println("#Live mutants --- not killed by any test-suite: " + numLiveMutants + " (" + String.format("%.2f", percent) + "%)");
				percent = totalNumberOfGeneratedMutants > 0 ? (totalNumberOfGeneratedMutants - numLiveMutants) * 100.0 / totalNumberOfGeneratedMutants : 0;
				System.out.println("Mutation score: " + " (" + String.format("%.2f", percent) + "%)");
				System.out.println("#Applied tests: " + totalNumberOfAppliedTests);
				percent = totalNumberOfAppliedTests > 0 ? overallFailedTests.size() * 100.0 / totalNumberOfAppliedTests : 0;
				System.out.println("#Failed tests: " + overallFailedTests.size() + " (" + String.format("%.2f", percent) + "%)");
				percent = totalNumberOfGeneratedMutants > 0 ? numOverlappedMutants * 100.0 / totalNumberOfGeneratedMutants : 0;
				System.out.println("#Overlapped mutants --- killed at least by three test-suites: " + numOverlappedMutants + " (" + String.format("%.2f", percent) + "%)");
				System.out.println("\n--- Live mutants --- not killed by any test-suite (" + chatbotName + ") ---------------------------");
				for (String blockName : liveMutants.keySet()) {
					if (numMutantsGeneratedByMutationOperator.get(blockName) > 0) {
						System.out.println("--- " + blockName + " --- " + mutatorDescription.get(blockName) + " ---");
						System.out.println("#Generated mutants: " + numMutantsGeneratedByMutationOperator.get(blockName));
						percent = numMutantsGeneratedByMutationOperator.get(blockName) > 0 ? (numMutantsGeneratedByMutationOperator.get(blockName) - liveMutants.get(blockName).size()) * 100.0 / numMutantsGeneratedByMutationOperator.get(blockName) : 0;
						System.out.println("#Killed mutants: " + (numMutantsGeneratedByMutationOperator.get(blockName) - liveMutants.get(blockName).size()) + " (" + String.format("%.2f", percent) + "%)");
						percent = numMutantsGeneratedByMutationOperator.get(blockName) > 0 ? liveMutants.get(blockName).size() * 100.0 / numMutantsGeneratedByMutationOperator.get(blockName) : 0;
						System.out.println("#Live mutants: " + liveMutants.get(blockName).size() + " (" + String.format("%.2f", percent) + "%)");
						for (String mutant : liveMutants.get(blockName)) {
							System.out.println(mutant.substring(1, mutant.length()));
						}
						percent = numMutantsGeneratedByMutationOperator.get(blockName) > 0 ? simpleOverlappedMutants.get(blockName).size() * 100.0 / numMutantsGeneratedByMutationOperator.get(blockName) : 0;
						System.out.println("#Overlapped mutants: " + simpleOverlappedMutants.get(blockName).size() + " (" + String.format("%.2f", percent) + "%)");
						for (String mutant : simpleOverlappedMutants.get(blockName)) {
							System.out.println(mutant.substring(1, mutant.length()));
						}
						int numberOfFailedTests = 0;
						if (testsFailed.get(blockName) != null) {
							numberOfFailedTests = testsFailed.get(blockName).size();
						}
						percent = totalNumberOfAppliedTests > 0 ? numberOfFailedTests * 100.0 / totalNumberOfAppliedTests : 0;
						System.out.println("#Failed tests: " + numberOfFailedTests + " (" + String.format("%.2f", percent) + "%)");
/*
						if (testsFailed.get(blockName) != null) {
							for (String test : testsFailed.get(blockName)) {
								System.out.println(test);
							}
						}
*/
					}
				}
				for (String testSuiteName : testSuiteNames) {
					if (numMutantsGeneratedMap.get(testSuiteName) > 0) {
						System.out.println("\nResults for: " + testSuiteName + " (" + chatbotName + ") ---------------------------");
						System.out.println("Mutation score: " + String.format("%.2f", mutationScoreMap.get(testSuiteName) * 100) + "%");
						percent = numMutantsGeneratedMap.get(testSuiteName) * 100.0 / numMutantsGeneratedMap.get(testSuiteName);
						System.out.println("#Generated mutants: " + numMutantsGeneratedMap.get(testSuiteName) + " (" + String.format("%.2f", percent) + "%)");
						percent = numMutantsCompilingMap.get(testSuiteName) * 100.0 / numMutantsGeneratedMap.get(testSuiteName);
						System.out.println("#Compiling mutants: " + numMutantsCompilingMap.get(testSuiteName) + " (" + String.format("%.2f", percent) + "%)");
						percent = numMutantsKilledMap.get(testSuiteName) * 100.0 / numMutantsGeneratedMap.get(testSuiteName);
						System.out.println("#Killed mutants: " + numMutantsKilledMap.get(testSuiteName) + " (" + String.format("%.2f", percent) + "%)");
						percent = numMutantsEquivalentMap.get(testSuiteName) * 100.0 / numMutantsGeneratedMap.get(testSuiteName);
						System.out.println("#Semantically equivalent mutants: " + numMutantsEquivalentMap.get(testSuiteName) + " (" + String.format("%.2f", percent) + "%)");
						int numMutantsLive = (numMutantsGeneratedMap.get(testSuiteName) - numMutantsKilledMap.get(testSuiteName) - numMutantsEquivalentMap.get(testSuiteName));
						percent = numMutantsLive * 100.0 / numMutantsGeneratedMap.get(testSuiteName);
						System.out.println("#Live mutants: " + numMutantsLive + " (" + String.format("%.2f", percent) + "%)");
						System.out.println("#Total tests: " + numberOfTestsExecuted.get(testSuiteName));
						percent = numberOfTestsFailed.get(testSuiteName) * 100.0 / numberOfTestsExecuted.get(testSuiteName);
						System.out.println("#Failed tests: " + numberOfTestsFailed.get(testSuiteName) + " (" + String.format("%.2f", percent) + "%)");
						percent = numMutatorsAppliedMap.get(testSuiteName) * 100.0 / blocks.size();
						System.out.println("#Mutation operators applied: " + numMutatorsAppliedMap.get(testSuiteName) + " (" + String.format("%.2f", percent) + "%)");
						
						for (String blockName : mutatorData.get(testSuiteName).keySet()) {
							List<WodelTestMutatorResult> results = mutatorData.get(testSuiteName).get(blockName);
							for (WodelTestMutatorResult result : results) {
								if (result.getNumberOfMutants() > 0) {
									System.out.println("Results for operator: " + blockName + " " + mutatorDescription.get(blockName) + " ----- " + testSuiteName + " (" + chatbotName + ") ----");
									percent = result.getNumberOfMutants() * 100.0 / numMutantsGeneratedMap.get(testSuiteName);
									System.out.println("#Generated mutants: " + result.getNumberOfMutants() + " (" + String.format("%.2f", percent) + "%)");
									percent = numMutantsKilledByBlockMap.get(testSuiteName).get(blockName) * 100.0 / result.getNumberOfMutants();
									System.out.println("#Killed mutants: " + numMutantsKilledByBlockMap.get(testSuiteName).get(blockName) + " (" + String.format("%.2f", percent) + "%)");
									if (numMutantsKilledByBlockMap.get(testSuiteName).get(blockName) < result.getNumberOfMutants()) {
										System.out.println("Live mutants for operator: " + blockName);
										mutantsLiveByBlockMap.get(testSuiteName).get(blockName).sort(new Comparator<String>() {
											@Override
											public int compare(String o1, String o2) {
												return Integer.valueOf(o1.substring("/Output".length(), o1.indexOf(".zip"))) - Integer.valueOf(o2.substring("/Output".length(), o2.indexOf(".zip")));
											}
										});
										for (String mutant : mutantsLiveByBlockMap.get(testSuiteName).get(blockName)) {
											System.out.println(mutant.substring(1, mutant.length()));
										}
										percent = mutantsLiveByBlockMap.get(testSuiteName).get(blockName).size() * 100.0 / result.getNumberOfMutants();
										System.out.println("#Live mutants: " + mutantsLiveByBlockMap.get(testSuiteName).get(blockName).size() + " (" + String.format("%.2f", percent) + "%)");

									}
									List<String> testResults = testsFailedByBlockMap.get(testSuiteName).get(blockName);
									int testResultsSize = 0;
									if (testResults != null) {
										testResultsSize = testResults.size();
									}
									percent = totalNumberOfAppliedTests > 0 ? numberOfTestsExecuted.get(testSuiteName) * 100.0 / totalNumberOfAppliedTests : 0;
									System.out.println("#Total tests: " + numberOfTestsExecuted.get(testSuiteName) + " (" + String.format("%.2f", percent) + "%)");
									percent = testResultsSize * 100.0 / numberOfTestsExecuted.get(testSuiteName);
									System.out.println("#Failed tests: " + numTestsFailedByBlockMap.get(testSuiteName).get(blockName) + " (" + String.format("%.2f", percent) + "%)");
		/*
									if (testResults != null) {
										for (String test : testResults) {
											System.out.println(test);
										}
									}
		*/
								}
							}
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		generateResultsTxt();
	}
}
