package mutator.wodeltest.[@**@];

import wodel.utils.manager.IOUtils;
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.WodelTestGlobalResult;
import wodel.utils.manager.WodelTestGlobalResult.Status;
import wodel.utils.manager.WodelTestInfo;
import wodel.utils.manager.WodelTestResultClass;
import wodel.utils.manager.WodelTestResult;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.net.HttpURLConnection;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.JavaCore;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

//import org.jvnet.winp.WinProcess;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.comments.CommentLine;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.representer.Representer;

import es.main.RasaParserGenerator;

public class WodelTest implements IWodelTest {
	
	public static int PORT = 5005;
	public static final int[] EXCLUDED_PORTS = {5040};
	public static final int TIMEOUT = 2000;
	public static final int TIMEOUT_SECONDS = 36000;
	public static final int[] RESPONSE_CODES = {200, 405};
	public static final int BOT_TIMEOUT = 1000;
	public static final String RASA_KIND_ID = "rasa";
	public static final String BOTIUM_KIND_ID = "botium";
	public static final String RASA_BAT_FILENAME = "rasa_bat.bat";
	public static final String BOTIUM_BAT_FILENAME = "botium_bat.bat";
	public static final String RASA_VERSION = "1";
	public static final String RASA_LANGUAGE = "en";
	public static final String BOTIUM_RASA_MODE_REST_INPUT = "REST_INPUT";
	public static final String BOTIUM_RASA_MODE_NLU_INPUT = "NLU_INPUT";
	public static final String CONDA_ENVIRONMENT = "chatbots-test";
	
	public static enum TestKind {
		RASA_TEST,
		BOTIUM_TEST,
		UNKNOWN_TEST
	}
	
	public static enum BotiumRasaMode {
		REST_INPUT,
		NLU_INPUT,
		UNKNOWN_INPUT
	}

	public class BotiumRunner implements Runnable {
		
		private int port = 0;
		private String botiumBatFile = "";
		private String botiumProcessTitle = "";
		//private WinProcess rasaProcess = null;
		private Process rasaProcess = null;
		private boolean last = false;
		
		private String botiumPath = "";
		private WodelTestGlobalResult globalResult = null;
		private String artifactPath = null;
		private List<WodelTestResultClass> results = null;
		
		//public BotiumRunner(int port, String botiumBatFile, String botiumProcessTitle, WinProcess rasaProcess, boolean last, String botiumPath, WodelTestGlobalResult globalResult, String artifactPath, List<WodelTestResultClass> results) {
		public BotiumRunner(int port, String botiumBatFile, String botiumProcessTitle, Process rasaProcess, boolean last, String botiumPath, WodelTestGlobalResult globalResult, String artifactPath, List<WodelTestResultClass> results) {
			this.port = port;
			this.botiumBatFile = botiumBatFile;
			this.botiumProcessTitle = botiumProcessTitle;
			this.rasaProcess = rasaProcess;
			this.last = last;
			this.botiumPath = botiumPath;
			this.globalResult = globalResult;
			this.artifactPath = artifactPath;
			this.results = results;
		}

		@Override
		public void run() {
			/*** espera a que se cargue el chatbot ***/
			boolean ready = waitSetUp("http://127.0.0.1", this.port, TIMEOUT, TIMEOUT_SECONDS);
			if (ready == false) {
				return;
			}
			/*** ejecuta botium ***/
			Process botiumProcess = execBat(this.botiumBatFile, this.botiumProcessTitle, true);
			/*** terminar los procesos ***/
			botiumProcess.destroy();
			if (last) {
				this.rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				this.rasaProcess.destroy();
				this.rasaProcess.destroyForcibly();
				//this.rasaProcess.killRecursively();
			}

			/*** recolectar resultados ***/
			String botiumMochawesomePath = this.botiumPath + "/mochawesome-report/mochawesome.json";
			WodelTestResult wtr = parseBotiumTestResults(this.globalResult, this.artifactPath, botiumMochawesomePath);
			WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(this.results, this.artifactPath);
			if (resultClass == null) {
				resultClass = new WodelTestResultClass(this.artifactPath);
				this.results.add(resultClass);
			}
			resultClass.addResult(wtr);
		}
	}

	@Override
	public String getProjectName() {
		return "[@**@]";
	}
	
	@Override
	public String getNatureId() {
		return JavaCore.NATURE_ID;
	}

	@Override
	public void compile(IProject project) {
	}

	@Override
	public List<String> artifactPaths(IProject project, String projectPath, File outputFolder, List<String> blockNames) {
		List<String> artifactPaths = new ArrayList<String>();
		projectPath = projectPath.replace("\\", "/");
		String mutantPath = projectPath + "/mutants/zip";
		File mutantFolder = new File(mutantPath);
		if (mutantFolder.exists()) {
			if (mutantFolder.listFiles() != null) {
				for (File chatbotFolder : mutantFolder.listFiles()) {
					String chatbotPath = mutantPath + "/" + chatbotFolder.getName();
					if (blockNames.size() > 0) {
						for (String blockName : blockNames) {
							String blockPath = chatbotPath + "/" + blockName;
							File blockFolder = new File(blockPath);
							if (blockFolder.exists()) {
								for (File zipFolder : blockFolder.listFiles()) {
									String zipPath = blockPath + "/" + zipFolder.getName();
									File modelFolder = new File(zipPath);
									if (modelFolder.exists()) {
										for (File artifact : modelFolder.listFiles()) {
											if (artifact.exists()) {
												artifactPaths.add(zipPath + "/" + artifact.getName());
											}
										}
									}
								}
							}
						}
					}
					String blockPath = chatbotPath + "/" + chatbotFolder.getName();
					File blockFolder = new File(blockPath);
					if (blockFolder.exists()) {
						if (blockFolder.listFiles() != null) {
							for (File zipFolder : blockFolder.listFiles()) {
								String zipPath = blockPath + "/" + zipFolder.getName();
								File modelFolder = new File(zipPath);
								if (modelFolder.exists()) {
									for (File artifact : modelFolder.listFiles()) {
										if (artifact.exists()) {
											artifactPaths.add(zipPath + "/" + artifact.getName());
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return artifactPaths;
	}
	
	private static File newFile(File destinationDir, ZipEntry zipEntry) throws IOException {
	    File destFile = new File(destinationDir, zipEntry.getName());

	    String destDirPath = destinationDir.getCanonicalPath();
	    String destFilePath = destFile.getCanonicalPath();

	    if (!destFilePath.startsWith(destDirPath + File.separator)) {
	        throw new IOException("Entry is outside of the target dir: " + zipEntry.getName());
	    }

	    return destFile;
	}
	
	private static void unzip(String inFile, String outFolder) throws IOException {
		byte[] buffer = new byte[1024];
		ZipInputStream zis = new ZipInputStream(new FileInputStream(inFile));
		ZipEntry zipEntry = zis.getNextEntry();
		File fOutFolderFile = new File(outFolder);
		while (zipEntry != null) {
		    File newFile = newFile(fOutFolderFile, zipEntry);
		    if (zipEntry.isDirectory()) {
		        if (!newFile.isDirectory() && !newFile.mkdirs()) {
		            throw new IOException("Failed to create directory " + newFile);
		        }
		    } else {
		        // fix for Windows-created archives
		        File parent = newFile.getParentFile();
		        if (!parent.isDirectory() && !parent.mkdirs()) {
		            throw new IOException("Failed to create directory " + parent);
		        }

		        // write file content
		        FileOutputStream fos = new FileOutputStream(newFile);
		        int len;
		        while ((len = zis.read(buffer)) > 0) {
		            fos.write(buffer, 0, len);
		        }
		        fos.close();
		    }
		    zipEntry = zis.getNextEntry();
		}
	}
	
	private void createBatToLaunchRasa(int port, String batfile, String unit, String[] folders) {
		PrintWriter batwriter = null;
		try {
			batwriter = new PrintWriter(batfile, "UTF-8");
			batwriter.println(unit + ":");
			batwriter.println("cd \\");
			for (String folder : folders) {
				batwriter.println("cd " + folder);
			}
			batwriter.println("call activate " + CONDA_ENVIRONMENT);
			batwriter.println("rasa train");
			batwriter.println("rasa run -m models --enable-api --cors \"*\" --debug --port " + port);
			batwriter.close();
		} catch (UnsupportedEncodingException e) {
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createBatToLaunchRasaTest(String batfile, String unit, String[] folders) {
		PrintWriter batwriter = null;
		try {
			batwriter = new PrintWriter(batfile, "UTF-8");
			batwriter.println(unit + ":");
			batwriter.println("cd \\");
			for (String folder : folders) {
				batwriter.println("cd " + folder);
			}
			batwriter.println("call activate " + CONDA_ENVIRONMENT);
			batwriter.println("rasa train");
			batwriter.println("rasa test core --stories tests/conversation_tests.md --successes");
			batwriter.println("exit");
			batwriter.close();
		} catch (UnsupportedEncodingException e) {
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createBatToLaunchBotium(String chatbot, String mutant, String batfile, String unit, String[] folders, boolean expand) {
		PrintWriter batwriter = null;
		try {
			batwriter = new PrintWriter(batfile, "UTF-8");
			batwriter.println(unit + ":");
			batwriter.println("cd \\");
			for (String folder : folders) {
				batwriter.println("cd " + folder);
			}
			String commandToLaunchBotium = "call botium-cli run " + (expand ? "--expandscriptingmemory ./Scriptingmemory " : "") + "--timeout " + TIMEOUT + " mochawesome"; /* > botium.txt"; */
			batwriter.println(commandToLaunchBotium); /* > botium.txt");*/
			//batwriter.println("taskkill /FI \"WINDOWTITLE eq " + rasaProcessTitle + "\" /T /F");
			batwriter.println("exit");
			batwriter.close();
		} catch (UnsupportedEncodingException e) {
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Process execBat(String batfile, String title, boolean wait) {
		ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "start \"" + title + "\" " + (wait ? "/wait" : ""), batfile);
		Process proc = null;
		try {
			proc = pb.start();
			proc.waitFor(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return proc;
	}
	
	private static boolean isSetUp(String strurl, int port, int timeout) {
      boolean responseOK = false;
	    strurl = strurl.replaceFirst("https", "http");
	    try {
	    	URL plainurl = new URL(strurl);
	    	URL url = new URL(plainurl.getProtocol(), plainurl.getHost(), port, plainurl.getFile());
	    	HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setConnectTimeout(timeout);
	        connection.setReadTimeout(timeout);
	        connection.setRequestMethod("HEAD");
	        int responseCode = connection.getResponseCode();
	        for (int respCode : RESPONSE_CODES) {
	        	if (responseCode == respCode) {
	        		responseOK = true;
	        		break;
	        	}
	        }
	    } catch (IOException exception) {
	    }
	    return responseOK;
	}
	
	private static TestKind getTestKind(String testSuitePath) {
		TestKind testKind = TestKind.UNKNOWN_TEST;
		File testSuiteFolder = new File(testSuitePath);
		if (!testSuiteFolder.exists() || !testSuiteFolder.isDirectory()) {
			return testKind;
		}
		File testConfigFolder = null;
		for (File file : testSuiteFolder.listFiles()) {
			if (file.isDirectory() && file.getName().equals("data")) {
				testConfigFolder = file;
				break;
			}
		}
		if (testConfigFolder == null) {
			return testKind;
		}
		String testSuiteKind = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(testSuitePath + "/data/config.txt"));
			testSuiteKind = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (testSuiteKind) {
			case RASA_KIND_ID: 		testKind = TestKind.RASA_TEST;
									break;
			case BOTIUM_KIND_ID: 	testKind = TestKind.BOTIUM_TEST;
									break;
		}
		
		return testKind;
	}
	
	private static BotiumRasaMode getBotiumRasaMode(String testSuitePath) {
		BotiumRasaMode rasaMode = BotiumRasaMode.UNKNOWN_INPUT;
		File testSuiteFolder = new File(testSuitePath);
		if (!testSuiteFolder.exists() || !testSuiteFolder.isDirectory()) {
			return rasaMode;
		}
		File testConfigFolder = null;
		for (File file : testSuiteFolder.listFiles()) {
			if (file.isDirectory() && file.getName().equals("data")) {
				testConfigFolder = file;
				break;
			}
		}
		if (testConfigFolder == null) {
			return rasaMode;
		}
		String botiumRasaMode = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(testSuitePath + "/data/config.txt"));
			br.readLine();
			botiumRasaMode = br.readLine();
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (botiumRasaMode) {
			case BOTIUM_RASA_MODE_REST_INPUT: 		rasaMode = BotiumRasaMode.REST_INPUT;
													break;
			case BOTIUM_RASA_MODE_NLU_INPUT:	 	rasaMode = BotiumRasaMode.NLU_INPUT;
													break;
		}
		
		return rasaMode;
	}

	private static boolean waitSetUp(String strurl, int port, int timeout, int timeoutSeconds) {
		boolean scanning = true;
		boolean ready = false;
		long startTs = System.currentTimeMillis();
		try {
			while (scanning) {
				long currentTs = System.currentTimeMillis();
				if (currentTs - startTs > (timeoutSeconds * 1000)) {
					scanning = false;
					ready = false;
					return ready;
				}
				ready = isSetUp(strurl, port, timeout);
				if (ready == true) {
					return ready;
				}
				if (ready == false) {
					Thread.sleep(timeout);
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ready;
	}
	
	private static void generateBotiumJSON(String chatbot, String mutant, BotiumRasaMode rasaMode, String botiumJSONPath, int port) {
		PrintWriter jsonwriter = null;
		try {
			jsonwriter = new PrintWriter(botiumJSONPath, "UTF-8");
			jsonwriter.println("{");
			jsonwriter.println("  \"botium\": {");
			jsonwriter.println("    \"Capabilities\": {");
			jsonwriter.println("      \"PROJECTNAME\": \"" + chatbot + "-" + mutant.replace("/", "-") + "\",");
			jsonwriter.println("      \"CONTAINERMODE\": \"rasa\",");
			jsonwriter.println("      \"RASA_ENDPOINT_URL\": \"http://127.0.0.1:" + port + "\",");
			if (rasaMode == BotiumRasaMode.REST_INPUT) {
				jsonwriter.println("      \"RASA_MODE\": \"" + BOTIUM_RASA_MODE_REST_INPUT + "\",");
			}
			if (rasaMode == BotiumRasaMode.NLU_INPUT) {
				jsonwriter.println("      \"RASA_MODE\": \"" + BOTIUM_RASA_MODE_NLU_INPUT + "\",");
			}
			jsonwriter.println("      \"SCRIPTING_ENABLE_MEMORY\": true,");
			jsonwriter.println("      \"WAITFORBOTTIMEOUT\": " + BOT_TIMEOUT + ",");
			jsonwriter.println("      \"BIG_TESTSET_MODE_ON\": true,");
			jsonwriter.println("      \"SCRIPTING_MEMORYEXPANSION_KEEP_ORIG\": false,");
			jsonwriter.println("      \"SCRIPTING_MEMORY_MATCHING_MODE\": \"non_whitespace\"");
			jsonwriter.println("    }");
			jsonwriter.println("  }");
			jsonwriter.println("}");
			jsonwriter.close();
		} catch (UnsupportedEncodingException e) {
			return;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static WodelTestResult parseBotiumTestResults(WodelTestGlobalResult globalResult, String artifactPath, String fileName) {
		List<Object> tests = new ArrayList<Object>();
		List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();
		WodelTestResult wtr = new WodelTestResult(artifactPath.substring(artifactPath.lastIndexOf("/"), artifactPath.length()), artifactPath, tests, testsInfo);
		try {
			FileInputStream stream = new FileInputStream(fileName);
			JsonReader json = new JsonReader(new InputStreamReader(stream));
			json.setLenient(true);
			while (json.peek() != JsonToken.END_DOCUMENT) {
				JsonObject jsonObject = JsonParser.parseReader(json).getAsJsonObject();
				JsonArray jsonResults = jsonObject.getAsJsonArray("results");
				for (int i = 0; i < jsonResults.size(); i++) {
					JsonObject jsonResult = jsonResults.get(i).getAsJsonObject();
					JsonArray jsonSuites = jsonResult.getAsJsonArray("suites");
					for (int j = 0; j < jsonSuites.size(); j++) {
						JsonObject jsonSuite = jsonSuites.get(j).getAsJsonObject();
						JsonArray jsonTests = jsonSuite.getAsJsonArray("tests");
						int testsFailed = 0;
						for (int k = 0; k < jsonTests.size(); k++) {
							JsonObject jsonTest = jsonTests.get(k).getAsJsonObject();
							JsonElement jsonTitle = jsonTest.get("title");
							String title = jsonTitle.getAsString();
							JsonElement jsonState = jsonTest.get("state");
							String state = jsonState.getAsString();
							JsonPrimitive jsonContext = jsonTest.getAsJsonPrimitive("context");
							if (state.equals("failed")) {
								testsFailed++;
							}
							boolean failed = state.equals("passed") ? false : true;
							String context = jsonContext.getAsString().replace("\\n", "").replace("\n", "");
							if (context.indexOf("\"value\": \"#me:") > 0) {
								context = context.substring(context.indexOf("\"value\": \"#me:") + "\"value\": \"".length(), context.length());
							}
							context = context.substring(0, context.length() > 64 ? 64 : context.length());
							context = context.replace(";", "").replace(":", "").replace("|", "");
							context += "...";
							WodelTestInfo info = new WodelTestInfo(title, failed, title, context);
							testsInfo.add(info);
							tests.add(title);
						}
						globalResult.incNumTestsExecuted(jsonTests.size());
						globalResult.incNumTestsFailed(testsFailed);
					}
				}
			}
			json.close();
			stream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wtr;
	}
	
	private static RasaResult parseRasaTestResultsHelper(String path) {
		RasaResult rasaResult = null;
		try {
			LoaderOptions loaderOptions = new LoaderOptions();
	        loaderOptions.setProcessComments(true);
			DumperOptions dumperOptions = new DumperOptions();
			dumperOptions.setProcessComments(true);
			dumperOptions.setPrettyFlow(true);
			dumperOptions.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
			Representer represent = new Representer(dumperOptions);
			represent.getPropertyUtils().setSkipMissingProperties(true);
			Yaml yaml = new Yaml(new Constructor(RasaResult.class, loaderOptions), represent, dumperOptions, loaderOptions);
			FileReader reader = new FileReader(path);
			Node node = yaml.compose(reader);
			if (node instanceof MappingNode) {
				MappingNode rootNode = (MappingNode) node; 
				rasaResult = new RasaResult();
				for (NodeTuple tupleNode: rootNode.getValue()) {
					Node keyNode = tupleNode.getKeyNode();
					Node valueNode = tupleNode.getValueNode();
					if (keyNode instanceof ScalarNode) {
						ScalarNode scalarKeyNode = (ScalarNode) keyNode;
						if (valueNode instanceof ScalarNode) {
							ScalarNode scalarValueNode = (ScalarNode) valueNode;
							if (scalarKeyNode.getValue().equals("version")) {
								rasaResult.setVersion(scalarValueNode.getValue());
							}
						}
						if (valueNode instanceof SequenceNode) {
							SequenceNode sequenceValueNode = (SequenceNode) valueNode;
							if (scalarKeyNode.getValue().equals("stories")) {
								List<RasaStory> stories = new ArrayList<RasaStory>();
								for (Node sequenceNode : sequenceValueNode.getValue()) {
									RasaStory story = new RasaStory();
									if (sequenceNode instanceof MappingNode) {
										MappingNode mappingSequenceNode = (MappingNode) sequenceNode;
										for (NodeTuple tupleSequenceNode : mappingSequenceNode.getValue()) {
											Node keySequenceNode = tupleSequenceNode.getKeyNode();
											Node valueSequenceNode = tupleSequenceNode.getValueNode();
											if (keySequenceNode instanceof ScalarNode) {
												ScalarNode scalarKeySequenceNode = (ScalarNode) keySequenceNode;
												if (valueSequenceNode instanceof ScalarNode) {
													ScalarNode scalarValueSequenceNode = (ScalarNode) valueSequenceNode;
													if (scalarKeySequenceNode.getValue().equals("story")) {
														story.setStory(scalarValueSequenceNode.getValue());
													}
												}
												if (valueSequenceNode instanceof SequenceNode) {
													SequenceNode sequenceValueSequenceNode = (SequenceNode) valueSequenceNode;
													if (scalarKeySequenceNode.getValue().equals("steps")) {
														List<RasaStep> steps = new ArrayList<RasaStep>();
														for (Node sequenceSequenceNode : sequenceValueSequenceNode.getValue()) {
															RasaStep step = new RasaStep();
															if (sequenceSequenceNode instanceof MappingNode) {
																MappingNode mappingSequenceSequenceNode = (MappingNode) sequenceSequenceNode;
																for (NodeTuple tupleSequenceSequenceNode : mappingSequenceSequenceNode.getValue()) {
																	Node keySequenceSequenceNode = tupleSequenceSequenceNode.getKeyNode();
																	Node valueSequenceSequenceNode = tupleSequenceSequenceNode.getValueNode();
																	if (keySequenceSequenceNode instanceof ScalarNode) {
																		ScalarNode scalarKeySequenceSequenceNode = (ScalarNode) keySequenceSequenceNode;
																		if (valueSequenceSequenceNode instanceof ScalarNode) {
																			ScalarNode scalarValueSequenceSequenceNode = (ScalarNode) valueSequenceSequenceNode;
																			if (scalarKeySequenceSequenceNode.getValue().equals("intent")) {
																				step.setIntent(scalarValueSequenceSequenceNode.getValue());
																			}
																			if (scalarKeySequenceSequenceNode.getValue().equals("action")) {
																				List<CommentLine> comments = scalarValueSequenceSequenceNode.getInLineComments();
																				if (comments != null) {
																					for (CommentLine comment : comments) {
																						step.addComment(comment.getValue());
																					}
																				}
																				step.setAction(scalarValueSequenceSequenceNode.getValue());
																			}
																		}
																	}
																}
															}
															steps.add(step);
														}
														story.setSteps(steps);
													}
												}
											}
										}
									}
									stories.add(story);
								}
								rasaResult.setStories(stories);
							}
						}
					}
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rasaResult;
	}
	private static void processRasaTestResults(RasaResult result, boolean fails, List<WodelTestInfo> testsInfo, List<Object> tests, WodelTestGlobalResult globalResult) {
		if (result != null && result.getStories() != null) {
			for (RasaStory story : result.getStories()) {
				String title = story.getStory().replace(":", "\\");
				String context = "";
				if (story.getSteps() != null) {
					for (RasaStep step : story.getSteps()) {
						context += step.toString() + " ";
						if (step.getContext().length() > 0) {
							context += "- " + step.getContext() + " ";
						}
					}
				}
				context.trim().replace(":", "\\");
				WodelTestInfo info = new WodelTestInfo(title, fails, title, context);
				testsInfo.add(info);
				tests.add(title);
			}
			globalResult.incNumTestsExecuted(result.getStories().size());
			if (fails == true) {
				globalResult.incNumTestsFailed(result.getStories().size());
			}
		}
	}
	
	private static WodelTestResult parseRasaTestResults(WodelTestGlobalResult globalResult, String artifactPath, String folderName) {
		List<Object> tests = new ArrayList<Object>();
		List<WodelTestInfo> testsInfo = new ArrayList<WodelTestInfo>();
		WodelTestResult wtr = new WodelTestResult(artifactPath.substring(artifactPath.lastIndexOf("/"), artifactPath.length()), artifactPath, tests, testsInfo);
		String successfulTestStoriesPath = folderName + "/results/successful_test_stories.yml";
		String storiesWithWarningsPath = folderName + "/results/stories_with_warnings.yml";
		String failedTestStoriesPath = folderName + "/results/failed_test_stories.yml";
		RasaResult passed = parseRasaTestResultsHelper(successfulTestStoriesPath);
		RasaResult warning = parseRasaTestResultsHelper(storiesWithWarningsPath);
		RasaResult failed = parseRasaTestResultsHelper(failedTestStoriesPath);
		processRasaTestResults(passed, false, testsInfo, tests, globalResult);
		processRasaTestResults(warning, true, testsInfo, tests, globalResult);
		processRasaTestResults(failed, true, testsInfo, tests, globalResult);
		return wtr;
	}

	private boolean detectScriptingmemory(String botiumPath) {
		String expandScriptingmemory = botiumPath + "/Scriptingmemory";
		File fScriptingmemory = new File(expandScriptingmemory);
		return (fScriptingmemory.exists() && fScriptingmemory.isDirectory());
	}

	private void incrementPort() {
		boolean validPort = false;
		while (validPort == false) {
			PORT++;
			validPort = true;
			for (int excluded_port : EXCLUDED_PORTS) {
				if (excluded_port == PORT) {
					validPort = false;
					break;
				}
			}
		}
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath) {
		incrementPort();
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		try {
			List<WodelTestResultClass> results = globalResult.getResults();
			String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
			/*** descomprimir el chatbot ***/
			artifactPath = artifactPath.replace("\\", "/");
			String chatbotFile = artifactPath;
			String chatbotPath = artifactPath.substring(0, artifactPath.lastIndexOf("/")).replace("/zip/", "/unzip/");
			unzip(chatbotFile, chatbotPath);
			/*** identificar el tipo de test (rasa o botium) ***/
			TestKind testKind = getTestKind(testSuitePath);
			if (testKind == TestKind.RASA_TEST) {
				/*** ejecutar test en rasa ***/
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaResultsPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				IOUtils.copyFolder(chatbotPath, rasaResultsPath);
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, rasaResultsPath + "/" + RASA_LANGUAGE);
				String testSuiteUnit = null;
				String testSuiteFolder = rasaResultsPath;
				if (!testSuitePath.startsWith("/")) {
					testSuiteUnit = testSuitePath.substring(0, 1);
					testSuiteFolder = testSuiteFolder.substring(3, testSuiteFolder.length());
				}
				testSuiteFolder += "/" + RASA_LANGUAGE;
				String[] testSuiteFolders = testSuiteFolder.split("/");
				String rasaBatFile = rasaResultsPath + "/" + RASA_LANGUAGE + "/" + RASA_BAT_FILENAME;
				createBatToLaunchRasaTest(rasaBatFile, testSuiteUnit, testSuiteFolders);
				String rasaTitle = "rasa_" + chatbotName; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, true);
				/*** terminar los procesos ***/
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();
				
				/*** recolectar resultados ***/
				WodelTestResult wtr = parseRasaTestResults(globalResult, artifactPath, rasaResultsPath + "/" + RASA_LANGUAGE);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
				
			}
			if (testKind == TestKind.BOTIUM_TEST) {
				BotiumRasaMode rasaMode = getBotiumRasaMode(testSuitePath);
				/*** cargar en rasa ***/
				String chatbotUnit = null;
				String chatbotFolder = chatbotPath;
				if (!chatbotPath.startsWith("/")) {
					chatbotUnit = chatbotPath.substring(0, 1);
					chatbotFolder = chatbotFolder.substring(3, chatbotFolder.length());
				}
				chatbotFolder += "/" + RASA_LANGUAGE;
				String[] chatbotFolders = chatbotFolder.split("/");
				String rasaBatFile = chatbotPath + "/" + RASA_BAT_FILENAME;
				int port = PORT;
				createBatToLaunchRasa(port, rasaBatFile, chatbotUnit, chatbotFolders);
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaTitle = "rasa_" + chatbotName + "_" + port; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, false);
				boolean ready = waitSetUp("http://127.0.0.1", port, TIMEOUT, TIMEOUT_SECONDS);
				if (ready == false) {
					return null;
				}

				/*** aplicar el test ***/
				String botiumPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, botiumPath);
				String botiumJSONPath = botiumPath + "/botium.json";
				generateBotiumJSON(chatbotName, mutant, rasaMode, botiumJSONPath, port);
				String botiumBatFile = botiumPath + "/" + BOTIUM_BAT_FILENAME;
				String botiumUnit = null;
				String botiumFolder = botiumPath;
				if (!botiumPath.startsWith("/")) {
					botiumUnit = botiumPath.substring(0, 1);
					botiumFolder = botiumFolder.substring(3, botiumFolder.length());
				}
				String[] botiumFolders = botiumFolder.split("/");
				createBatToLaunchBotium(chatbotName, mutant, botiumBatFile, botiumUnit, botiumFolders, detectScriptingmemory(botiumPath));
				String botiumTitle = "botium_" + chatbotName + "_" + port;
				//WinProcess rasaWinProcess = new WinProcess(rasaProcess);
				Process botiumProcess = execBat(botiumBatFile, botiumTitle, true);
				/*** terminar los procesos ***/
				botiumProcess.destroy();
				//rasaWinProcess.killRecursively();
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();

				/*** recolectar resultados ***/
				String botiumMochawesomePath = botiumPath + "/mochawesome-report/mochawesome.json";
				WodelTestResult wtr = parseBotiumTestResults(globalResult, artifactPath, botiumMochawesomePath);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
			}
		} catch (SecurityException e) {
			// 	TODO Auto-generated catch block
			e.printStackTrace();
			globalResult.setStatus(Status.EXCEPTION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return globalResult;
	}
	
	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, int port) {
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		try {
			List<WodelTestResultClass> results = globalResult.getResults();
			String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
			/*** descomprimir el chatbot ***/
			artifactPath = artifactPath.replace("\\", "/");
			String chatbotFile = artifactPath;
			String chatbotPath = artifactPath.substring(0, artifactPath.lastIndexOf("/")).replace("/zip/", "/unzip/");
			unzip(chatbotFile, chatbotPath);
			/*** identificar el tipo de test (rasa o botium) ***/
			TestKind testKind = getTestKind(testSuitePath);
			if (testKind == TestKind.RASA_TEST) {
				/*** ejecutar test en rasa ***/
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaResultsPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				IOUtils.copyFolder(chatbotPath, rasaResultsPath);
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, rasaResultsPath + "/" + RASA_LANGUAGE);
				String testSuiteUnit = null;
				String testSuiteFolder = rasaResultsPath;
				if (!rasaResultsPath.startsWith("/")) {
					testSuiteUnit = rasaResultsPath.substring(0, 1);
					testSuiteFolder = testSuiteFolder.substring(3, testSuiteFolder.length());
				}
				testSuiteFolder += "/" + RASA_LANGUAGE;
				String[] testSuiteFolders = testSuiteFolder.split("/");
				String rasaBatFile = rasaResultsPath + "/" + RASA_LANGUAGE + "/" + RASA_BAT_FILENAME;
				createBatToLaunchRasaTest(rasaBatFile, testSuiteUnit, testSuiteFolders);
				String rasaTitle = "rasa_" + chatbotName; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, true);
				/*** terminar los procesos ***/
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();
				
				/*** recolectar resultados ***/
				WodelTestResult wtr = parseRasaTestResults(globalResult, artifactPath, rasaResultsPath + "/" + RASA_LANGUAGE);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
				
			}
			if (testKind == TestKind.BOTIUM_TEST) {
				BotiumRasaMode rasaMode = getBotiumRasaMode(testSuitePath);
				/*** cargar en rasa ***/
				String chatbotUnit = null;
				String chatbotFolder = chatbotPath;
				if (!chatbotPath.startsWith("/")) {
					chatbotUnit = chatbotPath.substring(0, 1);
					chatbotFolder = chatbotFolder.substring(3, chatbotFolder.length());
				}
				chatbotFolder += "/" + RASA_LANGUAGE;
				String[] chatbotFolders = chatbotFolder.split("/");
				String rasaBatFile = chatbotPath + "/" + RASA_BAT_FILENAME;
				createBatToLaunchRasa(port, rasaBatFile, chatbotUnit, chatbotFolders);
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaTitle = "rasa_" + chatbotName + "_" + port; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, false);
				boolean ready = waitSetUp("http://127.0.0.1", port, TIMEOUT, TIMEOUT_SECONDS);
				if (ready == false) {
					return null;
				}

				/*** aplicar el test ***/
				String botiumPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, botiumPath);
				String botiumJSONPath = botiumPath + "/botium.json";
				generateBotiumJSON(chatbotName, mutant, rasaMode, botiumJSONPath, port);
				String botiumBatFile = botiumPath + "/" + BOTIUM_BAT_FILENAME;
				String botiumUnit = null;
				String botiumFolder = botiumPath;
				if (!botiumPath.startsWith("/")) {
					botiumUnit = botiumPath.substring(0, 1);
					botiumFolder = botiumFolder.substring(3, botiumFolder.length());
				}
				String[] botiumFolders = botiumFolder.split("/");
				createBatToLaunchBotium(chatbotName, mutant, botiumBatFile, botiumUnit, botiumFolders, detectScriptingmemory(botiumPath));
				String botiumTitle = "botium_" + chatbotName + "_" + port;
				//WinProcess rasaWinProcess = new WinProcess(rasaProcess);
				Process botiumProcess = execBat(botiumBatFile, botiumTitle, true);
				/*** terminar los procesos ***/
				botiumProcess.destroy();
				//rasaWinProcess.killRecursively();
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();

				/*** recolectar resultados ***/
				String botiumMochawesomePath = botiumPath + "/mochawesome-report/mochawesome.json";
				WodelTestResult wtr = parseBotiumTestResults(globalResult, artifactPath, botiumMochawesomePath);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
			}
		} catch (SecurityException e) {
			// 	TODO Auto-generated catch block
			e.printStackTrace();
			globalResult.setStatus(Status.EXCEPTION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return globalResult;
	}

	@Override
	public WodelTestGlobalResult run(IProject project, IProject testSuiteProject, String artifactPath, List<Thread> threads) {
		incrementPort();
		WodelTestGlobalResult globalResult = new WodelTestGlobalResult();
		try {
			List<WodelTestResultClass> results = globalResult.getResults();
			String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
			/*** descomprimir el chatbot ***/
			artifactPath = artifactPath.replace("\\", "/");
			String chatbotFile = artifactPath;
			String chatbotPath = artifactPath.substring(0, artifactPath.lastIndexOf("/")).replace("/zip/", "/unzip/");
			unzip(chatbotFile, chatbotPath);
			/*** identificar el tipo de test (rasa o botium) ***/
			TestKind testKind = getTestKind(testSuitePath);
			if (testKind == TestKind.RASA_TEST) {
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaResultsPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				IOUtils.copyFolder(chatbotPath, rasaResultsPath);
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, rasaResultsPath + "/" + RASA_LANGUAGE);
				String testSuiteUnit = null;
				String testSuiteFolder = rasaResultsPath;
				if (!rasaResultsPath.startsWith("/")) {
					testSuiteUnit = rasaResultsPath.substring(0, 1);
					testSuiteFolder = testSuiteFolder.substring(3, testSuiteFolder.length());
				}
				testSuiteFolder += "/" + RASA_LANGUAGE;
				String[] testSuiteFolders = testSuiteFolder.split("/");
				String rasaBatFile = rasaResultsPath + "/" + RASA_LANGUAGE + "/" + RASA_BAT_FILENAME;
				createBatToLaunchRasaTest(rasaBatFile, testSuiteUnit, testSuiteFolders);
				String rasaTitle = "rasa_" + chatbotName; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, true);
				/*** terminar los procesos ***/
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();
				
				/*** recolectar resultados ***/
				WodelTestResult wtr = parseRasaTestResults(globalResult, artifactPath, rasaResultsPath + "/" + RASA_LANGUAGE);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
			}
			/*** cargar en rasa ***/
			if (testKind == TestKind.BOTIUM_TEST) {
				BotiumRasaMode rasaMode = getBotiumRasaMode(testSuitePath);
				String chatbotUnit = null;
				String chatbotFolder = chatbotPath;
				if (!chatbotPath.startsWith("/")) {
					chatbotUnit = chatbotPath.substring(0, 1);
					chatbotFolder = chatbotFolder.substring(3, chatbotFolder.length());
				}
				chatbotFolder += "/" + RASA_LANGUAGE;
				String[] chatbotFolders = chatbotFolder.split("/");
				String rasaBatFile = chatbotPath + "/" + RASA_BAT_FILENAME;
				int port = PORT;
				createBatToLaunchRasa(port, rasaBatFile, chatbotUnit, chatbotFolders);
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaTitle = "rasa_" + chatbotName + "_" + port; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, false);
				String botiumPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, botiumPath);
				String botiumJSONPath = botiumPath + "/botium.json";
				generateBotiumJSON(chatbotName, mutant, rasaMode, botiumJSONPath, port);
				String botiumBatFile = botiumPath + "/" + BOTIUM_BAT_FILENAME;
				String botiumUnit = null;
				String botiumFolder = botiumPath;
				if (!botiumPath.startsWith("/")) {
					botiumUnit = botiumPath.substring(0, 1);
					botiumFolder = botiumFolder.substring(3, botiumFolder.length());
				}
				String[] botiumFolders = botiumFolder.split("/");
				createBatToLaunchBotium(chatbotName, mutant, botiumBatFile, botiumUnit, botiumFolders, detectScriptingmemory(botiumPath));

				/*** lanza botium en un nuevo hilo ***/
				String botiumTitle = "botium_" + chatbotName + "_" + port;
				//WinProcess rasaWinProcess = new WinProcess(rasaProcess);
				//BotiumRunner botiumRunner = new BotiumRunner(port, botiumBatFile, botiumTitle, rasaWinProcess, true, botiumPath, globalResult, artifactPath, results);
				BotiumRunner botiumRunner = new BotiumRunner(port, botiumBatFile, botiumTitle, rasaProcess, true, botiumPath, globalResult, artifactPath, results);
				Thread botiumThread = new Thread(botiumRunner);
				botiumThread.start();
				threads.add(botiumThread);
			}

		} catch (SecurityException e) {
			// 	TODO Auto-generated catch block
			e.printStackTrace();
			globalResult.setStatus(Status.EXCEPTION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return globalResult;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects, String artifactPath) {
		incrementPort();
		Map<IProject, WodelTestGlobalResult> globalResultsMap = new HashMap<IProject, WodelTestGlobalResult>();
		try {
			/*** descomprimir el chatbot ***/
			artifactPath = artifactPath.replace("\\", "/");
			String chatbotFile = artifactPath;
			String chatbotPath = artifactPath.substring(0, artifactPath.lastIndexOf("/")).replace("/zip/", "/unzip/");
			unzip(chatbotFile, chatbotPath);
			/*** identificar el tipo de test (rasa o botium) ***/
			List<IProject> rasaTests = new ArrayList<IProject>();
			List<IProject> botiumTests = new ArrayList<IProject>();
			for (IProject testSuiteProject : testSuitesProjects) {
				String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
				TestKind testKind = getTestKind(testSuitePath);
				if (testKind == TestKind.RASA_TEST) {
					rasaTests.add(testSuiteProject);
				}
				if (testKind == TestKind.BOTIUM_TEST) {
					botiumTests.add(testSuiteProject);
				}
			}
			/*** ejecutar test en rasa ***/
			for (IProject testSuiteProject : rasaTests) {
				String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaResultsPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				IOUtils.copyFolder(chatbotPath, rasaResultsPath);
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, rasaResultsPath + "/" + RASA_LANGUAGE);
				String testSuiteUnit = null;
				String testSuiteFolder = rasaResultsPath;
				if (!rasaResultsPath.startsWith("/")) {
					testSuiteUnit = rasaResultsPath.substring(0, 1);
					testSuiteFolder = testSuiteFolder.substring(3, testSuiteFolder.length());
				}
				testSuiteFolder += "/" + RASA_LANGUAGE;
				String[] testSuiteFolders = testSuiteFolder.split("/");
				String rasaBatFile = rasaResultsPath + "/" + RASA_LANGUAGE + "/" + RASA_BAT_FILENAME;
				createBatToLaunchRasaTest(rasaBatFile, testSuiteUnit, testSuiteFolders);
				String rasaTitle = "rasa_" + chatbotName; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, true);
				/*** terminar los procesos ***/
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();
				
				/*** recolectar resultados ***/
				if (globalResultsMap.get(testSuiteProject) == null) {
					globalResultsMap.put(testSuiteProject, new WodelTestGlobalResult());
				}
				List<WodelTestResultClass> results = globalResultsMap.get(testSuiteProject).getResults();
				WodelTestResult wtr = parseRasaTestResults(globalResultsMap.get(testSuiteProject), artifactPath, rasaResultsPath + "/" + RASA_LANGUAGE);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
			}
			/*** si hay al menos un test de botium ***/
			if (botiumTests.size() > 0) {
				/*** cargar en rasa ***/
				String chatbotUnit = null;
				String chatbotFolder = chatbotPath;
				if (!chatbotPath.startsWith("/")) {
					chatbotUnit = chatbotPath.substring(0, 1);
					chatbotFolder = chatbotFolder.substring(3, chatbotFolder.length());
				}
				chatbotFolder += "/" + RASA_LANGUAGE;
				String[] chatbotFolders = chatbotFolder.split("/");
				String rasaBatFile = chatbotPath + "/" + RASA_BAT_FILENAME;
				int port = PORT;
				createBatToLaunchRasa(port, rasaBatFile, chatbotUnit, chatbotFolders);
				String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
				String mutant = chatbotName; 
				chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
				mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
				mutant = mutant.substring(0, mutant.lastIndexOf("/"));
				String rasaTitle = "rasa_" + chatbotName + "_" + port; 
				Process rasaProcess = execBat(rasaBatFile, rasaTitle, false);
				boolean ready = waitSetUp("http://127.0.0.1", port, TIMEOUT, TIMEOUT_SECONDS);
				if (ready == false) {
					return null;
				}
				for (IProject botiumTestSuiteProject : botiumTests) {
					/*** aplicar el test ***/
					String testSuitePath = botiumTestSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
					BotiumRasaMode rasaMode = getBotiumRasaMode(testSuitePath);
					String botiumPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
					testSuitePath += "/" + chatbotName + "/base";
					IOUtils.copyFolder(testSuitePath, botiumPath);
					String botiumJSONPath = botiumPath + "/botium.json";
					generateBotiumJSON(chatbotName, mutant, rasaMode, botiumJSONPath, port);
					String botiumBatFile = botiumPath + "/" + BOTIUM_BAT_FILENAME;
					String botiumUnit = null;
					String botiumFolder = botiumPath;
					if (!botiumPath.startsWith("/")) {
						botiumUnit = botiumPath.substring(0, 1);
						botiumFolder = botiumFolder.substring(3, botiumFolder.length());
					}
					String[] botiumFolders = botiumFolder.split("/");
					createBatToLaunchBotium(chatbotName, mutant, botiumBatFile, botiumUnit, botiumFolders, detectScriptingmemory(botiumPath));
					String botiumTitle = "botium_" + chatbotName + "_" + port;
					//WinProcess rasaWinProcess = new WinProcess(rasaProcess);
					Process botiumProcess = execBat(botiumBatFile, botiumTitle, true);
					/*** terminar los procesos ***/
					botiumProcess.destroy();
					if (botiumTestSuiteProject.getName().equals(botiumTests.get(botiumTests.size() - 1).getName())) {
						rasaProcess.descendants().forEach(p -> {
							p.destroy();
							p.destroyForcibly();
						});
						rasaProcess.destroy();
						rasaProcess.destroyForcibly();
						//rasaWinProcess.killRecursively();
					}

					try {
						/*** recolectar resultados ***/
						if (globalResultsMap.get(botiumTestSuiteProject) == null) {
							globalResultsMap.put(botiumTestSuiteProject, new WodelTestGlobalResult());
						}
						List<WodelTestResultClass> results = globalResultsMap.get(botiumTestSuiteProject).getResults();
						String botiumMochawesomePath = botiumPath + "/mochawesome-report/mochawesome.json";
						WodelTestResult wtr = parseBotiumTestResults(globalResultsMap.get(botiumTestSuiteProject), artifactPath, botiumMochawesomePath);
						WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
						if (resultClass == null) {
							resultClass = new WodelTestResultClass(artifactPath);
							results.add(resultClass);
						}
						resultClass.addResult(wtr);
					} catch (SecurityException e) {
						// 	TODO Auto-generated catch block
						e.printStackTrace();
						globalResultsMap.get(botiumTestSuiteProject).setStatus(Status.EXCEPTION);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return globalResultsMap;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, int port) {
		Map<IProject, WodelTestGlobalResult> globalResultsMap = new HashMap<IProject, WodelTestGlobalResult>();
		String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
		String mutant = chatbotName; 
		chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
		mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
		mutant = mutant.substring(0, mutant.lastIndexOf("/"));
		Process rasaProcess = null;
		artifactPath = artifactPath.replace("\\", "/");
		String chatbotFile = artifactPath;
		String chatbotPath = artifactPath.substring(0, artifactPath.lastIndexOf("/")).replace("/zip/", "/unzip/");
		try {
			/*** descomprimir el chatbot ***/
			unzip(chatbotFile, chatbotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*** identificar el tipo de test (rasa o botium) ***/
		List<IProject> rasaTests = new ArrayList<IProject>();
		List<IProject> botiumTests = new ArrayList<IProject>();
		for (IProject testSuiteProject : testSuitesProjects) {
			String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
			TestKind testKind = getTestKind(testSuitePath);
			if (testKind == TestKind.RASA_TEST) {
				rasaTests.add(testSuiteProject);
			}
			if (testKind == TestKind.BOTIUM_TEST) {
				botiumTests.add(testSuiteProject);
			}
		}
		/*** ejecutar test en rasa ***/
		for (IProject testSuiteProject : rasaTests) {
			try {
				String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
				String rasaResultsPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				IOUtils.copyFolder(chatbotPath, rasaResultsPath);
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, rasaResultsPath + "/" + RASA_LANGUAGE);
				String testSuiteUnit = null;
				String testSuiteFolder = rasaResultsPath;
				if (!rasaResultsPath.startsWith("/")) {
					testSuiteUnit = rasaResultsPath.substring(0, 1);
					testSuiteFolder = testSuiteFolder.substring(3, testSuiteFolder.length());
				}
				testSuiteFolder += "/" + RASA_LANGUAGE;
				String[] testSuiteFolders = testSuiteFolder.split("/");
				String rasaBatFile = rasaResultsPath + "/" + RASA_LANGUAGE + "/" + RASA_BAT_FILENAME;
				createBatToLaunchRasaTest(rasaBatFile, testSuiteUnit, testSuiteFolders);
				String rasaTitle = "rasa_" + chatbotName; 
				rasaProcess = execBat(rasaBatFile, rasaTitle, true);
				/*** terminar los procesos ***/
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();
				
				/*** recolectar resultados ***/
				if (globalResultsMap.get(testSuiteProject) == null) {
					globalResultsMap.put(testSuiteProject, new WodelTestGlobalResult());
				}
				List<WodelTestResultClass> results = globalResultsMap.get(testSuiteProject).getResults();
				WodelTestResult wtr = parseRasaTestResults(globalResultsMap.get(testSuiteProject), artifactPath, rasaResultsPath + "/" + RASA_LANGUAGE);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*** si hay al menos un test de botium ***/
		if (botiumTests.size() > 0) {
			/*** cargar en rasa ***/
			String chatbotUnit = null;
			String chatbotFolder = chatbotPath;
			if (!chatbotPath.startsWith("/")) {
				chatbotUnit = chatbotPath.substring(0, 1);
				chatbotFolder = chatbotFolder.substring(3, chatbotFolder.length());
			}
			chatbotFolder += "/" + RASA_LANGUAGE;
			String[] chatbotFolders = chatbotFolder.split("/");
			String rasaBatFile = chatbotPath + "/" + RASA_BAT_FILENAME;
			createBatToLaunchRasa(port, rasaBatFile, chatbotUnit, chatbotFolders);
			String rasaTitle = "rasa_" + chatbotName + "_" + port; 
			rasaProcess = execBat(rasaBatFile, rasaTitle, false);
			boolean ready = waitSetUp("http://127.0.0.1", port, TIMEOUT, TIMEOUT_SECONDS);
			if (ready == false) {
				return null;
			}
		}

		/*** aplicar test de botium ***/
		for (IProject testSuiteProject : botiumTests) {
			try {
				String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
				BotiumRasaMode rasaMode = getBotiumRasaMode(testSuitePath);
				String botiumPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, botiumPath);
				String botiumJSONPath = botiumPath + "/botium.json";
				generateBotiumJSON(chatbotName, mutant, rasaMode, botiumJSONPath, port);
				String botiumBatFile = botiumPath + "/" + BOTIUM_BAT_FILENAME;
				String botiumUnit = null;
				String botiumFolder = botiumPath;
				if (!botiumPath.startsWith("/")) {
					botiumUnit = botiumPath.substring(0, 1);
					botiumFolder = botiumFolder.substring(3, botiumFolder.length());
				}
				String[] botiumFolders = botiumFolder.split("/");
				createBatToLaunchBotium(chatbotName, mutant, botiumBatFile, botiumUnit, botiumFolders, detectScriptingmemory(botiumPath));
				String botiumTitle = "botium_" + chatbotName + "_" + port;
				//WinProcess rasaWinProcess = new WinProcess(rasaProcess);
				Process botiumProcess = execBat(botiumBatFile, botiumTitle, true);
				/*** terminar los procesos ***/
				botiumProcess.destroy();
				if (testSuiteProject.getName().equals(botiumTests.get(botiumTests.size() - 1).getName())) {
					//rasaWinProcess.killRecursively();
					rasaProcess.descendants().forEach(p -> {
						p.destroy();
						p.destroyForcibly();
					});
					rasaProcess.destroy();
					rasaProcess.destroyForcibly();
				}
				/*** recolectar resultados ***/
				if (globalResultsMap.get(testSuiteProject) == null) {
					globalResultsMap.put(testSuiteProject, new WodelTestGlobalResult());
				}
				List<WodelTestResultClass> results = globalResultsMap.get(testSuiteProject).getResults();
				String botiumMochawesomePath = botiumPath + "/mochawesome-report/mochawesome.json";
				WodelTestResult wtr = parseBotiumTestResults(globalResultsMap.get(testSuiteProject), artifactPath, botiumMochawesomePath);
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
			} catch (SecurityException e) {
				// 	TODO Auto-generated catch block
				e.printStackTrace();
				globalResultsMap.get(testSuiteProject).setStatus(Status.EXCEPTION);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return globalResultsMap;
	}

	@Override
	public Map<IProject, WodelTestGlobalResult> run(IProject project, List<IProject> testSuitesProjects,
			String artifactPath, List<Thread> threads) {
		incrementPort();
		Map<IProject, WodelTestGlobalResult> globalResultsMap = new HashMap<IProject, WodelTestGlobalResult>();
		String chatbotName = artifactPath.substring(artifactPath.indexOf("/mutants/zip/") + "/mutants/zip/".length(), artifactPath.length());
		String mutant = chatbotName; 
		chatbotName = chatbotName.substring(0, chatbotName.indexOf("/"));
		mutant = mutant.substring(mutant.indexOf(chatbotName + "/") + (chatbotName + "/").length(), mutant.length());
		mutant = mutant.substring(0, mutant.lastIndexOf("/"));
		Process rasaProcess = null;
		int port = PORT;
		/*** descomprimir el chatbot ***/
		artifactPath = artifactPath.replace("\\", "/");
		String chatbotFile = artifactPath;
		String chatbotPath = artifactPath.substring(0, artifactPath.lastIndexOf("/")).replace("/zip/", "/unzip/");
		try {
			unzip(chatbotFile, chatbotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*** identificar el tipo de test (rasa o botium) ***/
		List<IProject> rasaTests = new ArrayList<IProject>();
		List<IProject> botiumTests = new ArrayList<IProject>();
		for (IProject testSuiteProject : testSuitesProjects) {
			String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
			TestKind testKind = getTestKind(testSuitePath);
			if (testKind == TestKind.RASA_TEST) {
				rasaTests.add(testSuiteProject);
			}
			if (testKind == TestKind.BOTIUM_TEST) {
				botiumTests.add(testSuiteProject);
			}
		}
		for (IProject testSuiteProject : rasaTests) {
			try {
				/*** ejecutar test en rasa ***/
				String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
				String rasaResultsPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				IOUtils.copyFolder(chatbotPath, rasaResultsPath);
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, rasaResultsPath + "/" + RASA_LANGUAGE);
				String testSuiteUnit = null;
				String testSuiteFolder = rasaResultsPath;
				if (!testSuitePath.startsWith("/")) {
					testSuiteUnit = testSuitePath.substring(0, 1);
					testSuiteFolder = testSuiteFolder.substring(3, testSuiteFolder.length());
				}
				testSuiteFolder += "/" + RASA_LANGUAGE;
				String[] testSuiteFolders = testSuiteFolder.split("/");
				String rasaBatFile = rasaResultsPath + "/" + RASA_LANGUAGE + "/" + RASA_BAT_FILENAME;
				createBatToLaunchRasaTest(rasaBatFile, testSuiteUnit, testSuiteFolders);
				String rasaTitle = "rasa_" + chatbotName; 
				rasaProcess = execBat(rasaBatFile, rasaTitle, true);
				/*** terminar los procesos ***/
				rasaProcess.descendants().forEach(p -> {
					p.destroy();
					p.destroyForcibly();
				});
				rasaProcess.destroy();
				rasaProcess.destroyForcibly();
				
				/*** recolectar resultados ***/
				WodelTestResult wtr = parseRasaTestResults(globalResultsMap.get(testSuiteProject), artifactPath, rasaResultsPath + "/" + RASA_LANGUAGE);
				List<WodelTestResultClass> results = globalResultsMap.get(testSuiteProject).getResults();
				WodelTestResultClass resultClass = WodelTestResultClass.getWodelTestResultClassByName(results, artifactPath);
				if (resultClass == null) {
					resultClass = new WodelTestResultClass(artifactPath);
					results.add(resultClass);
				}
				resultClass.addResult(wtr);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*** si hay al menos un test de botium ***/
		if (botiumTests.size() > 0) {
			/*** cargar en rasa ***/
			String chatbotUnit = null;
			String chatbotFolder = chatbotPath;
			if (!chatbotPath.startsWith("/")) {
				chatbotUnit = chatbotPath.substring(0, 1);
				chatbotFolder = chatbotFolder.substring(3, chatbotFolder.length());
			}
			chatbotFolder += "/" + RASA_LANGUAGE;
			String[] chatbotFolders = chatbotFolder.split("/");
			String rasaBatFile = chatbotPath + "/" + RASA_BAT_FILENAME;
			createBatToLaunchRasa(port, rasaBatFile, chatbotUnit, chatbotFolders);
			String rasaTitle = "rasa_" + chatbotName + "_" + port; 
			rasaProcess = execBat(rasaBatFile, rasaTitle, false);
		}
		/*** aplicar test de botium ***/
		for (IProject testSuiteProject : botiumTests) {
			try {
				String testSuitePath = testSuiteProject.getLocation().toFile().getPath().replace("\\", "/");
				BotiumRasaMode rasaMode = getBotiumRasaMode(testSuitePath);
				String botiumPath = testSuitePath  + "/" + chatbotName + "/" + mutant;
				testSuitePath += "/" + chatbotName + "/base";
				IOUtils.copyFolder(testSuitePath, botiumPath);
				String botiumJSONPath = botiumPath + "/botium.json";
				generateBotiumJSON(chatbotName, mutant, rasaMode, botiumJSONPath, port);
				String botiumBatFile = botiumPath + "/" + BOTIUM_BAT_FILENAME;
				String botiumUnit = null;
				String botiumFolder = botiumPath;
				if (!botiumPath.startsWith("/")) {
					botiumUnit = botiumPath.substring(0, 1);
					botiumFolder = botiumFolder.substring(3, botiumFolder.length());
				}
				String[] botiumFolders = botiumFolder.split("/");
				createBatToLaunchBotium(chatbotName, mutant, botiumBatFile, botiumUnit, botiumFolders, detectScriptingmemory(botiumPath));

				/*** lanza botium en un nuevo hilo ***/
				if (globalResultsMap.get(testSuiteProject) == null) {
					globalResultsMap.put(testSuiteProject, new WodelTestGlobalResult());
				}
				List<WodelTestResultClass> results = globalResultsMap.get(testSuiteProject).getResults();
				String botiumTitle = "botium_" + chatbotName + "_" + port;
				//WinProcess rasaWinProcess = new WinProcess(rasaProcess);
				boolean last = false; 
				if (testSuiteProject.getName().equals(botiumTests.get(botiumTests.size() - 1).getName())) {
					last = true;
				}
				//BotiumRunner botiumRunner = new BotiumRunner(port, botiumBatFile, botiumTitle, rasaWinProcess, last, botiumPath, globalResultsMap.get(testSuiteProject), artifactPath, results);
				BotiumRunner botiumRunner = new BotiumRunner(port, botiumBatFile, botiumTitle, rasaProcess, last, botiumPath, globalResultsMap.get(testSuiteProject), artifactPath, results);
				Thread botiumThread = new Thread(botiumRunner);
				botiumThread.start();
				threads.add(botiumThread);
			} catch (SecurityException e) {
				// 	TODO Auto-generated catch block
				e.printStackTrace();
				globalResultsMap.get(testSuiteProject).setStatus(Status.EXCEPTION);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return globalResultsMap;
	}

	@Override
	public void projectToModel(String projectName, Class<?> cls) {
		String projectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/");
		String targetPath = ModelManager.getMetaModelPath(cls);
		File sourceFolder = new File(projectPath + "/zip");
		for (File source : sourceFolder.listFiles()) {
			if (source.getName().endsWith(".zip")) {
				String inputPath = projectPath + "/zip/" +  source.getName(); 
				try {
					RasaParserGenerator.doRasaParser(inputPath, targetPath + "/xmi", RASA_VERSION);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				String modelName = source.getName().replace(".zip", ".xmi");
				IOUtils.copyFile(targetPath + "/xmi/" + modelName, targetPath + "/" + modelName.replace(".xmi", ".model"));
			}
		}
	}

	@Override
	public void projectToModel(IProject project, Class<?> cls) {
		String projectPath = project.getLocation().toFile().toPath().toString().replace("\\", "/");
		String targetPath = ModelManager.getMetaModelPath(cls);
		File sourceFolder = new File(projectPath + "/zip");
		for (File source : sourceFolder.listFiles()) {
			if (source.getName().endsWith(".zip")) {
				String inputPath = projectPath + "/zip/" +  source.getName(); 
				try {
					RasaParserGenerator.doRasaParser(inputPath, targetPath + "/xmi", RASA_VERSION);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				String modelName = source.getName().replace(".zip", ".xmi");
				IOUtils.copyFile(targetPath + "/xmi/" + modelName, targetPath + "/" + modelName.replace(".xmi", ".model"));
			}
		}
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName, String projectName, Class<?> cls) {
		String modelsFolder = ModelManager.getMetaModelPath(cls);
		File fModelsFolder = new File(modelsFolder);
		List<String> models = new ArrayList<String>(); 
		for (File fSeedFile : fModelsFolder.listFiles()) {
			if (fSeedFile.isFile() && fSeedFile.getName().endsWith(".model")) {
				models.add(fSeedFile.getPath().toString().replace("\\", "/"));
			}
		}
		String seedFile = models.get(0);
		String seedName = seedFile.substring(seedFile.lastIndexOf("/") + 1, seedFile.length()).replace(".model", "");
		String projectPath = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName).getLocation().toFile().getPath().replace("\\", "/");
		String outputSeedPath = projectPath + "/mutants/zip/" + className + "/" + seedName;
		if (!new File(outputSeedPath).exists()) {
			try {
				RasaParserGenerator.doRasaGenerator(seedFile, outputSeedPath, RASA_VERSION);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String inputFile = ModelManager.getOutputPath(cls) + "/" + className + "/" + folderName + "/" + modelName;
		String outputPath = projectPath + "/mutants/zip/" + className + "/" + folderName;
		try {
			RasaParserGenerator.doRasaGenerator(inputFile, outputPath, RASA_VERSION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modelToProject(String className, Resource model, String folderName, String modelName,
			IProject project, Class<?> cls) {
		String modelsFolder = ModelManager.getMetaModelPath(cls);
		File fModelsFolder = new File(modelsFolder);
		List<String> models = new ArrayList<String>(); 
		for (File fSeedFile : fModelsFolder.listFiles()) {
			if (fSeedFile.isFile() && fSeedFile.getName().endsWith(".model")) {
				models.add(fSeedFile.getPath().toString().replace("\\", "/"));
			}
		}
		String seedFile = models.get(0);
		String seedName = seedFile.substring(seedFile.lastIndexOf("/") + 1, seedFile.length()).replace(".model", "");
		String outputSeedPath = project.getLocation().toFile().getPath().replace("\\", "/") + "/mutants/zip/" + className + "/" + seedName;
		if (!new File(outputSeedPath).exists()) {
			try {
				RasaParserGenerator.doRasaGenerator(seedFile, outputSeedPath, RASA_VERSION);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String inputFile = ModelManager.getOutputPath(cls) + "/" + className + "/" + folderName + "/" + modelName;
		String outputPath = project.getLocation().toFile().getPath().replace("\\", "/") + "/mutants/zip/" + className + "/" + folderName;
		try {
			RasaParserGenerator.doRasaGenerator(inputFile, outputPath, RASA_VERSION);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getContainerEClassName() {
		return "";
	}

	@Override
	public boolean annotateMutation(Resource model, EObject container, String annotation) {
		return false;
	}
}