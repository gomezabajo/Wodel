package wodeledu.dsls.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.osgi.framework.Bundle;

import appliedMutations.AttributeChanged;
import appliedMutations.AttributeSwap;
import appliedMutations.InformationChanged;
import appliedMutations.ObjectCreated;
import appliedMutations.ObjectRemoved;
import appliedMutations.ReferenceChanged;
//import appliedMutations.ObjectRetyped;
import appliedMutations.ReferenceCreated;
import appliedMutations.ReferenceRemoved;
//import appliedMutations.ReferenceSwap;
import appliedMutations.SourceReferenceChanged;
import appliedMutations.TargetReferenceChanged;
import edutest.AlternativeResponse;
import edutest.MatchPairs;
import edutest.MissingWords;
import edutest.Mode;
import edutest.MultiChoiceDiagram;
import edutest.MultiChoiceEmendation;
import edutest.MutatorTests;
import edutest.Program;
import edutest.Test;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import manager.MutatorUtils;
import manager.ProjectUtils;
import modeltext.Element;
import mutatext.Constant;
import mutatext.Option;
import mutatext.Text;
import mutatext.Variable;
import mutatext.VariableType;
import mutatext.Word;
import mutatorenvironment.Block;
import mutatorenvironment.ModifyInformationMutator;

public class EduTestSuperGenerator extends AbstractGenerator {

	protected IProject project = null;
	protected Map<MutatorTests, List<Test>> tests = new HashMap<MutatorTests, List<Test>>();
	protected Map<MutatorTests, Map<Test, List<String>>> diagrams = new HashMap<MutatorTests, Map<Test, List<String>>>();
	protected Map<MutatorTests, Map<Test, List<String>>> rand = new HashMap<MutatorTests, Map<Test, List<String>>>();
	protected Map<MutatorTests, Map<Test, Registry>> dataRegistry = new HashMap<MutatorTests, Map<Test, Registry>>();
	protected Map<MutatorTests, Map<Test, Double>> puntuation = new HashMap<MutatorTests, Map<Test, Double>>();
	protected Map<MutatorTests, Map<Test, Double>> penalty = new HashMap<MutatorTests, Map<Test, Double>>();
	protected Map<MutatorTests, Integer> total = new HashMap<MutatorTests, Integer>();
	protected Map<MutatorTests, Map<Test, List<TestOption>>> options = new HashMap<MutatorTests, Map<Test, List<TestOption>>>();
	
	public EduTestSuperGenerator() {
		ProjectUtils.resetProject();
		project = ProjectUtils.getProject();
	}

	private class Registry {
		public Resource seed;
		public List<SimpleEntry<Resource, Resource>> mutants;
		public List<Resource> history;
		public Map<Resource, List<Registry>> wrong;
	}

	protected class TestOption implements Cloneable {
		public String path;
		public Resource resource;
		public Resource seed;
		public Resource mutant;
		public SimpleEntry<Resource, Resource> entry;
		public List<SimpleEntry<Resource, Map<String, List<String>>>> reverse;
		public Map<String, List<String>> text;
		public boolean solution;
		public int total;
		
		public Map<String, List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>> options;
		
		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
	}
	
	/**
	 * Removes comments from html code
	 */
	protected static CharSequence removeComments(CharSequence sequence) {
		List<String> comments = new ArrayList<String>();
		Pattern commentsPattern = Pattern.compile("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)|<!--.*-->");

        String text = sequence.toString();
        String noStrings = text.replaceAll("(\".*?(?<!\\\\)\")", "");
        Matcher commentsMatcher = commentsPattern.matcher(noStrings);

        while (commentsMatcher.find()) {
            String comment = commentsMatcher.group();
            if (!comments.contains(comment)) {
            	comments.add(comment);
            }
        }
        comments.sort((c1, c2) -> c2.length() - c1.length());
        
        for (String comment : comments) {
        	Pattern commentPattern = null;
        	if (comment.length() == 2) {
        		commentPattern = Pattern.compile(Pattern.quote(comment) + "\r?\n");
        	}
        	else {
        		commentPattern = Pattern.compile(Pattern.quote(comment));
        	}
        	Matcher commentMatcher = commentPattern.matcher(text);
        	text = commentMatcher.replaceAll("");
        }

        return text.replaceAll("(?m)^[ \t]*\r?\n", "");
	}
	
	/**
	 * Removes comments from xml code
	 */
	protected static CharSequence removeXMLComments(CharSequence sequence) {
		List<String> comments = new ArrayList<String>();
		Pattern commentsPattern = Pattern.compile("<!--.*-->");

        String text = sequence.toString();
        String noStrings = text.replaceAll("(\".*?(?<!\\\\)\")", "");
        Matcher commentsMatcher = commentsPattern.matcher(noStrings);

        while (commentsMatcher.find()) {
            String comment = commentsMatcher.group();
            if (!comments.contains(comment)) {
            	comments.add(comment);
            }
        }
        comments.sort((c1, c2) -> c2.length() - c1.length());
        
        for (String comment : comments) {
        	Pattern commentPattern = null;
        	if (comment.length() == 2) {
        		commentPattern = Pattern.compile(Pattern.quote(comment) + "\r?\n");
        	}
        	else {
        		commentPattern = Pattern.compile(Pattern.quote(comment));
        	}
        	Matcher commentMatcher = commentPattern.matcher(text);
        	text = commentMatcher.replaceAll("");
        }

        return text.replaceAll("(?m)^[ \t]*\r?\n", "");
	}

	/**
	 * Gets the registry object for the test exercise
	 * It stores the solution and the wrong answers
	 * @param exercise
	 * @param test
	 * @param blocks
	 * @param packages
	 * @param registrypackages
	 * @return
	 * @throws ModelNotFoundException
	 */
	private Registry getRegistry(MutatorTests exercise, Test test, List<EObject> blocks, List<EPackage> packages, List<EPackage> registrypackages) throws ModelNotFoundException {
		Registry registry = new Registry();
		File outFolder = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", ""));
		String modelPath = ModelManager.getModelsFolder() + '/' + test.getSource();
		registry.seed = ModelManager.loadModel(packages, modelPath);
		registry.mutants = new ArrayList<SimpleEntry<Resource, Resource>>();
		registry.history = new ArrayList<Resource>();
		registry.wrong = new HashMap<Resource, List<Registry>>();
		if (outFolder.isDirectory() == true) {
			if (exercise.getBlocks() != null) {
				for (Block block : exercise.getBlocks()) {
					if (block.getFrom() == null || block.getFrom().size() == 0) {
						for (File f : outFolder.listFiles()) {
							if (f.isFile() == true) {
								if (f.getName().endsWith(".model") && !f.getName().contains("_") && !f.getName().equals("Reverse.model")) {
									registry.mutants.add(new SimpleEntry<Resource, Resource>(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + f.getName()), null));
									for (File r : outFolder.listFiles()) {
										if (r.isDirectory() == true) {
											if (r.getName().equals("registry")) {
												for (File reg : r.listFiles()) {
													if (reg.getName().endsWith(".model")) {
														if (reg.getName().startsWith(f.getName().replace(".model", ""))) {
															registry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + "/registry/" + reg.getName()));
														}
													}
												}
											}
										}
									}
								}
							}
							else {
								if (f.getName().equals(block.getName())) {
									for (File s : f.listFiles()) {
										if (s.isFile() == true) {
											if (s.getName().endsWith(".model") && !s.getName().contains("_") && !f.getName().equals("Reverse.model")) {
												registry.mutants.add(new SimpleEntry<Resource, Resource>(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + block.getName() +'/' + s.getName()), null));
												for (File r : f.listFiles()) {
													if (r.getName().equals("registry")) {
														for (File reg : r.listFiles()) {
															if (reg.getName().endsWith(".model")) {
																if (reg.getName().startsWith(s.getName().replace(".model", ""))) {
																	registry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + block.getName() + "/registry/" + reg.getName()));
																}
															}
														}
													}
												}
												if (registry.wrong.get(registry.mutants.get(registry.mutants.size() - 1).getKey()) == null) {
													registry.wrong.put(registry.mutants.get(registry.mutants.size()- 1).getKey(), new ArrayList<Registry>());
												}
												for (EObject b : blocks) {
													List<EObject> from = null;
													String name = "";
													for (EReference ref : b.eClass().getEAllReferences()) {
														if (ref.getName().equals("from")) {
															from = (List<EObject>) b.eGet(ref);
															break;
														}
													}
													for (EAttribute att : b.eClass().getEAllAttributes()) {
														if (att.getName().equals("name")) {
															name = (String) b.eGet(att);
															break;
														}
													}
													if (from != null) {
														for (EObject bl : from) {
															String blockName = "";
															for (EAttribute att : bl.eClass().getEAllAttributes()) {
																if (att.getName().equals("name")) {
																	blockName = (String) bl.eGet(att);
																	break;
																}
															}
															if (blockName.equals(block.getName())) {
																Registry wrongRegistry = new Registry();
																wrongRegistry.seed = ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + block.getName() +'/' + s.getName());
																wrongRegistry.mutants = new ArrayList<SimpleEntry<Resource, Resource>>();
																wrongRegistry.history = new ArrayList<Resource>();
																File wrongOutFolder = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + "/" + name + '/' + block.getName());
																if (wrongOutFolder.isDirectory() == true) {
																	for (File wf : wrongOutFolder.listFiles()) {
																		if (wf.getName().equals(s.getName().replace(".model", ""))) {
																			for (File w : wf.listFiles()) {
																				if (w.isFile() == true) {
																					if (w.getName().endsWith(".model")) {
																						wrongRegistry.mutants.add(new SimpleEntry<Resource, Resource>(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + name + '/' + block.getName() +'/' + s.getName().replace(".model", "") + '/' + w.getName()), null));
																						for (File r : wf.listFiles()) {
																							if (r.isDirectory() == true) {
																								if (r.getName().equals("registry")) {
																									for (File reg : r.listFiles()) {
																										if (reg.getName().endsWith(".model")) {
																											wrongRegistry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + name + '/' + block.getName() + '/' + s.getName().replace(".model", "") + "/registry/" + reg.getName()));
																										}
																									}
																								}
																							}
																						}
																					}
																				}
																			}
																		}
																	}
																}
																registry.wrong.get(registry.mutants.get(registry.mutants.size() - 1).getKey()).add(wrongRegistry);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
					else {
						Block b = block;
						while (b != null) {
							Block fr = b;
							String blockPath = b.getName() + '/' ;
							while (fr != null) {
								outFolder = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + blockPath);
								if (outFolder.exists()) {
									for (File f : outFolder.listFiles()) {
										if (f.isFile() == true) {
											if (f.getName().endsWith(".model") && !f.getName().contains("_") && !f.getName().equals("Reverse.model")) {
												registry.mutants.add(new SimpleEntry<Resource, Resource>(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + blockPath + '/' + f.getName()), null));
												for (File r : outFolder.listFiles()) {
													if (r.isDirectory() == true) {
														if (r.getName().equals("registry")) {
															for (File reg : r.listFiles()) {
																if (reg.getName().endsWith(".model")) {
																	if (reg.getName().startsWith(f.getName().replace(".model", ""))) {
																		registry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + blockPath + "/registry/" + reg.getName()));
																	}
																}
															}
														}
													}
												}
											}
										}
										else {
											if (f.getName().startsWith("Output") && !f.getName().endsWith("vs")) {
												File ss = f;
												String mutantPath = blockPath;
												while (ss.isFile() == false || ss == null) {
													if (!ss.getName().startsWith("Output")) {
														break;
													}
													if (ss.listFiles() != null && ss.listFiles().length > 0) {
														f = ss;
														ss = ss.listFiles()[0];
														mutantPath += "/" + f.getName();
													}
													else {
														ss = null;
													}
												}
												boolean found = false;
												for (File s : f.listFiles()) {
													if (s.isFile()) {
														found = true;
														break;
													}
												}
												if (found == false) {
													mutantPath = mutantPath.substring(0, mutantPath.lastIndexOf("/"));
													f = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + mutantPath);
												}
												for (File s : f.listFiles()) {
													if (s.isFile() == true) {
														if (s.getName().endsWith(".model") && ! s.getName().contains("_") && !f.getName().equals("Reverse.model")) {
															registry.mutants.add(new SimpleEntry<Resource, Resource>(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + mutantPath + '/' + s.getName()), null));
															for (File r : f.listFiles()) {
																if (r.getName().equals("registry")) {
																	for (File reg : r.listFiles()) {
																		if (reg.getName().endsWith(".model")) {
																			if (reg.getName().startsWith(s.getName().replace(".model", ""))) {
																				registry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + mutantPath + "/registry/" + reg.getName()));
																			}
																		}
																	}
																}
															}
															if (registry.wrong.get(registry.mutants.get(registry.mutants.size() - 1).getKey()) == null) {
																registry.wrong.put(registry.mutants.get(registry.mutants.size() - 1).getKey(), new ArrayList<Registry>());
															}
														}
													}
												}
											}
										}
									}
								}
								if (fr.getFrom() == null || fr.getFrom().size() == 0) {
									break;
								}
								fr = fr.getFrom().get(0);
								blockPath = "/" + blockPath + "/" + fr.getName();
							}
							for (Block from : b.getFrom()) {
								fr = from;
								blockPath = b.getName() + '/' + from.getName();
								while (fr != null) {
									outFolder = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + blockPath);
									if (outFolder.exists()) {
										for (File f : outFolder.listFiles()) {
											if (f.isFile() == true) {
												if (f.getName().endsWith(".model") && !f.getName().contains("_") && !f.getName().equals("Reverse.model")) {
													registry.mutants.add(new SimpleEntry<Resource, Resource>(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + blockPath + '/' + f.getName()), null));
													for (File r : outFolder.listFiles()) {
														if (r.isDirectory() == true) {
															if (r.getName().equals("registry")) {
																for (File reg : r.listFiles()) {
																	if (reg.getName().endsWith(".model")) {
																		if (reg.getName().startsWith(f.getName().replace(".model", ""))) {
																			registry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + blockPath + "/registry/" + reg.getName()));
																		}
																	}
																}
															}
														}
													}
												}
											}
											else {
												if (f.getName().startsWith("Output") && !f.getName().endsWith("vs")) {
													File ss = f;
													String mutantPath = blockPath;
													while (ss.isFile() == false || ss == null) {
														if (!ss.getName().startsWith("Output")) {
															break;
														}
														if (ss.listFiles() != null && ss.listFiles().length > 0) {
															f = ss;
															ss = ss.listFiles()[0];
															mutantPath += "/" + f.getName();
														}
														else {
															ss = null;
														}
													}
													boolean found = false;
													for (File s : f.listFiles()) {
														if (s.isFile()) {
															found = true;
															break;
														}
													}
													if (found == false) {
														mutantPath = mutantPath.substring(0, mutantPath.lastIndexOf("/"));
														f = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + mutantPath);
													}
													for (File s : f.listFiles()) {
														if (s.isFile() == true) {
															if (s.getName().endsWith(".model") && ! s.getName().contains("_") && !f.getName().equals("Reverse.model")) {
																registry.mutants.add(new SimpleEntry<Resource, Resource>(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + mutantPath + '/' + s.getName()), null));
																for (File r : f.listFiles()) {
																	if (r.getName().equals("registry")) {
																		for (File reg : r.listFiles()) {
																			if (reg.getName().endsWith(".model")) {
																				if (reg.getName().startsWith(s.getName().replace(".model", ""))) {
																					registry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + mutantPath + "/registry/" + reg.getName()));
																				}
																			}
																		}
																	}
																}
																if (registry.wrong.get(registry.mutants.get(registry.mutants.size() - 1).getKey()) == null) {
																	registry.wrong.put(registry.mutants.get(registry.mutants.size() - 1).getKey(), new ArrayList<Registry>());
																}
															}
														}
													}
												}
											}
										}
									}
									if (fr.getFrom() == null || fr.getFrom().size() == 0) {
										break;
									}
									fr = fr.getFrom().get(0);
									blockPath = "/" + blockPath + "/" + fr.getName();
								}
							}
							if (b.getFrom() != null && b.getFrom().size() != 0) {
								b = b.getFrom().get(0);
							}
							else {
								b = null;
							}
						}
					}
				}
			}
		}

		return registry;
	}
	
	protected String getText(String identifier, String fileName, Resource resource) throws ModelNotFoundException {
		String text = "";
		try {
			Bundle bundle = Platform.getBundle("wodel.models");
			URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore");
			String mutatorecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
			String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", ".model");
			Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString());
			EObject definition = ModelManager.getObjectsOfType("Definition", mutatormodel).get(0);
			String metamodel = ModelManager.getStringAttribute("metamodel", definition);

			if (Platform.getExtensionRegistry() != null) {
				IConfigurationElement[] extensions = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								"wodel.model2text.ModelToText");

				IConfigurationElement appropriateExtension = null;
				for (IConfigurationElement extension : extensions) {
					Class<?> extensionClass = Platform.getBundle(extension.getDeclaringExtension().getContributor().getName()).loadClass(extension.getAttribute("class"));
					Object model2Text =  extensionClass.getDeclaredConstructor().newInstance();
					Method getURI = extensionClass.getDeclaredMethod("getURI");
					List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
					String uri = (String) getURI.invoke(model2Text);
					if (uri.equals(packages.get(0).getNsURI())) {
						Method getId = extensionClass.getDeclaredMethod("getId");
						String id = (String) getId.invoke(model2Text);
						if (identifier.equals(id)) { 
							appropriateExtension = extension;
							break;
						}
					}
				}
				if (appropriateExtension != null) {
					Class<?> extensionClass = Platform.getBundle(appropriateExtension.getDeclaringExtension().getContributor().getName()).loadClass(appropriateExtension.getAttribute("class"));
					Object model2Text =  extensionClass.getDeclaredConstructor().newInstance();
					Method getText = extensionClass.getDeclaredMethod("getText", new Class[]{String.class, String.class});
					text = (String) getText.invoke(model2Text, metamodel, fileName);
				}
				//List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				//Resource model = ModelManager.loadModel(packages, URI.createURI("file://" + ModelManager.getModelsFolder() + "/" + fileName).toFileString());
				//Resource model = ModelManager.loadModel(packages, fileName);
				//if (packages.get(0).getNsURI().equals("http://dfaAutomaton/1.0")) {
				//	text = DFA2Regex.toRegExp(DFAUtils.convertToDFA(packages, model));
				//}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidRegistryObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * If radio option is already in the list
	 * @param testOptions
	 * @param opt
	 * @return
	 */
	private boolean subsumeRadio(List<TestOption> testOptions, TestOption opt) {
		for (TestOption optCheck : testOptions) {
			List<String> textOptions = new ArrayList<String>();
			for (String mutationURI : optCheck.text.keySet()) {
				textOptions.addAll(optCheck.text.get(mutationURI));
				int equals = 0;
				for (String text : optCheck.text.get(mutationURI)) {
					for (String newText : opt.text.get(mutationURI)) {
						if (text.equals(newText)) {
							equals++;
						}
					}
				}
				if (equals == optCheck.text.size()) {
					if (optCheck.solution == false) {
						testOptions.remove(optCheck);
						return false;
					}
					else {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * If check box option is already in the list
	 * @param testOptions
	 * @param opt
	 * @return
	 */
	private boolean subsumeCheckbox(List<TestOption> testOptions, TestOption opt, String mutationURI) {
		for (TestOption optCheck : testOptions) {
			if (optCheck.text.size() > 0) {
				if (optCheck.text.get(mutationURI) != null && optCheck.text.get(mutationURI).size() > 0) {
					String textOption = optCheck.text.get(mutationURI).get(0);
					String newText = opt.text.get(mutationURI).get(0);
					if (newText.equals(textOption) ) {
						if (optCheck.solution == false) {
							testOptions.remove(optCheck);
							return false;
						}
						else {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * Builds the options for the AlternativeResponse
	 * or the MultiChoiceDiagram
	 * @param exercise
	 * @param diags
	 */
	private void buildAlternativeResponseOrMultiChoiceDiagram(MutatorTests exercise, Map<Test, List<String>> diags) {
		for (Test test : exercise.getTests()) {
			File folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/diagrams/" + test.getSource().replace(".model", ""));
			List<String> fileNames = new ArrayList<String>();
			if (folder.isDirectory() == true) {
				for (File f : folder.listFiles()) {
					if (f.getName().endsWith(".png")) {
						fileNames.add(f.getName());
					}
				}
			}
			if (exercise.getBlocks() != null) {
				for (Block block : exercise.getBlocks()) {
					folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/diagrams/" + test.getSource().replace(".model", "") + "/" + block.getName());
					if (folder.isDirectory() == true) {
						for (File f : folder.listFiles()) {
							if (f.getName().endsWith(".png")) {
								fileNames.add(block.getName() + "/" + f.getName());
							}
						}
					}
					if (block.getFrom().size() > 0) {
						for (Block b : block.getFrom()) {
						File wrongFolder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/diagrams/" + test.getSource().replace(".model", "") + "/" + b.getName() + "/" + block.getName());
							if (wrongFolder.isDirectory() == true) {
								for (File f : wrongFolder.listFiles()) {
									for (File w : f.listFiles()) {
										if (w.getName().endsWith(".png")) {
											fileNames.add(b.getName() + "/" + block.getName() + "/" + f.getName() + "/" + w.getName());
										}
									}
								}
							}
						}
					}
				}
			}
			diags.put(test, fileNames);
		}
		diagrams.put(exercise, diags);
		Map<Test, List<String>> random = new HashMap<Test, List<String>>();
		for (Test test : exercise.getTests()) {
			List<String> entry = diagrams.get(exercise).get(test);
			Collections.shuffle(entry);
			random.put(test, entry);
		}
		rand.put(exercise, random);
	}
	
	/**
	 * Stores the natural language option
	 * It checks if the option is a radio-button
	 * or it is a check-box
	 * @param exercise
	 * @param text
	 * @param mode
	 * @param opt
	 * @param opts
	 */
	private void storeOption(MutatorTests exercise, List<String> text, Mode mode, TestOption opt, List<TestOption> opts, String mutationURI) {
		try {
			if (mode == Mode.RADIOBUTTON) {
				for (String txt : text) {
					boolean found = false;
					for (String mutURI : opt.text.keySet()) {
						if (opt.text.get(mutURI).contains(txt)) {
							found = true;
							break;
						}
					}
					if (txt.length() > 0 && found == false) {
						opt.text.get(mutationURI).add(txt);
					}
				}
			}
			if (mode == Mode.CHECKBOX) {
				opt.text.put(mutationURI, new ArrayList<String>());
				for (String txt : text) {
					boolean found = false;
					for (String mutURI : opt.text.keySet()) {
						if (opt.text.get(mutURI).contains(txt)) {
							found = true;
							break;
						}
					}
					if (txt.length() > 0 && found == false) {
						opt.text.get(mutationURI).add(txt);
					}
				}
				TestOption optClone = (TestOption) opt.clone();
				boolean isRepeated = subsumeCheckbox(opts, optClone, mutationURI);
				if (isRepeated == false) {
					total.put(exercise, total.get(exercise) + 1);
					opts.add(optClone);
				}
			}
			if (mode == null) {
				opt.text.put(mutationURI, new ArrayList<String>());
				for (String txt : text) {
					boolean found = false;
					for (String mutURI : opt.text.keySet()) {
						if (opt.text.get(mutURI).contains(txt)) {
							found = true;
							break;
						}
					}
					if (txt.length() > 0 && found == false) {
						opt.text.get(mutationURI).add(txt);
					}
				}
				TestOption optClone = (TestOption) opt.clone();
				boolean isRepeated = subsumeCheckbox(opts, optClone, mutationURI);
				if (isRepeated == false) {
					total.put(exercise, total.get(exercise) + 1);
					opts.add(optClone);
				}
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Stores the natural language option list
	 * It checks if the option is a radio-button
	 * or it is a check-box
	 * @param exercise
	 * @param text
	 * @param list
	 * @param mode
	 * @param opt
	 * @param opts
	 */
	private void storeOptionList(MutatorTests exercise, List<String> text, List<String> list, Mode mode, TestOption opt, List<TestOption> opts, String mutationURI) {
		try {
			if (mode == Mode.RADIOBUTTON) {
				for (String txt : text) {
					if (txt.length() > 0 && opt.text.get(mutationURI).contains(txt) != true) {
						list.add(txt);
					}
				}
			}
			if (mode == Mode.CHECKBOX) {
				opt.text.put(mutationURI, new ArrayList<String>());
				for (String txt : text) {
					boolean found = false;
					for (String mutURI : opt.text.keySet()) {
						if (opt.text.get(mutURI).contains(txt)) {
							found = true;
							break;
						}
					}
					if (txt.length() > 0 && found == false) {
						opt.text.get(mutationURI).add(txt);
					}
				}
				TestOption optClone = (TestOption) opt.clone();
				boolean isRepeated = subsumeCheckbox(opts, optClone, mutationURI);
				if (isRepeated == false) {
					total.put(exercise, total.get(exercise) + 1);
					opts.add(optClone);
				}
			}
			if (mode == null) {
				opt.text.put(mutationURI, new ArrayList<String>());
				for (String txt : text) {
					boolean found = false;
					for (String mutURI : opt.text.keySet()) {
						if (opt.text.get(mutURI).contains(txt)) {
							found = true;
							break;
						}
					}
					if (txt.length() > 0 && found == false) {
						opt.text.get(mutationURI).add(txt);
					}
				}
				TestOption optClone = (TestOption) opt.clone();
				boolean isRepeated = subsumeCheckbox(opts, optClone, mutationURI);
				if (isRepeated == false) {
					total.put(exercise, total.get(exercise) + 1);
					opts.add(optClone);
				}
			}
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the natural language option
	 * for the create object mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param objectCreated
	 * @param opt
	 * @return
	 */
	private String getObjectCreatedOption(Resource cfgoptsresource, Resource idelemsresource, ObjectCreated objectCreated, TestOption opt) {
		String text = "";
		Option cfgopt = MutatorUtils.getConfigureOption("ObjectCreated", cfgoptsresource);
		EObject object = ModelManager.getEObject(objectCreated.getObject().get(0), opt.seed);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				text += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
			}
		}
		return text;
	}
	
	/**
	 * Gets the natural language option
	 * for the remove object mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param objectRemoved
	 * @param opt
	 * @return
	 */
	private String getObjectRemovedOption(Resource cfgoptsresource, Resource idelemsresource, ObjectRemoved objectRemoved, TestOption opt) {
		String text = "";
		Option cfgopt = MutatorUtils.getConfigureOption("ObjectRemoved", cfgoptsresource);
		EObject object = ModelManager.getEObject(objectRemoved.getObject().get(0), opt.seed);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				text += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
			}
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the modify source reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param sourceReferenceChanged
	 * @param opt
	 * @return
	 */
	private String getSourceReferenceChangedOption(Resource cfgoptsresource, Resource idelemsresource, SourceReferenceChanged sourceReferenceChanged, TestOption opt) {
		String text = "";
		Option cfgopt = MutatorUtils.getConfigureOption("SourceReferenceChanged", cfgoptsresource);
		EObject from = ModelManager.getEObject(sourceReferenceChanged.getFrom(), opt.seed);
		String refName = sourceReferenceChanged.getRefName();
		EStructuralFeature srcRef = from.eClass().getEStructuralFeature(refName);
		Element srcElement = MutatorUtils.getElement((EObject) from.eGet(srcRef), idelemsresource);
		EObject to = ModelManager.getEObject(sourceReferenceChanged.getTo(), opt.seed);
		EStructuralFeature tarRef = to.eClass().getEStructuralFeature(refName);
		Element tarElement = MutatorUtils.getElement((EObject) to.eGet(tarRef), idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				text += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OLD_FROM_OBJECT) {
					for (modeltext.Word v : srcElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = (EObject) from.eGet(srcRef);
							}
							else {
								o = (EObject) ((EObject) from.eGet(srcRef)).eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), (EObject) from.eGet(srcRef)));
							}
							if (o != null) {
								text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.FROM_OBJECT) {
					for (modeltext.Word v : tarElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = (EObject) to.eGet(tarRef);
							}
							else {
								o = (EObject) ((EObject) to.eGet(tarRef)).eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), (EObject) to.eGet(tarRef)));
							}
							if (o != null) {
								text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					for (modeltext.Word v : tarElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
					}
				}
			}
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the modify target reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param targetReferenceChanged
	 * @param opt
	 * @return
	 */
	private String getTargetReferenceChangedOption(Resource cfgoptsresource, Resource idelemsresource, TargetReferenceChanged targetReferenceChanged, TestOption opt) {
		String text = "";
		Option cfgopt = MutatorUtils.getConfigureOption("TargetReferenceChanged", cfgoptsresource);
		EObject object = ModelManager.getEObject(targetReferenceChanged.getObject().get(0), opt.seed);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		String refName = targetReferenceChanged.getRefName();
		EStructuralFeature refSrc = ModelManager.getReferenceByName(refName, object);
		Element refSrcElement = MutatorUtils.getRefElement(object, refSrc, idelemsresource);
		EStructuralFeature refTar = ModelManager.getReferenceByName(refName, object);
		Element refTarElement = MutatorUtils.getRefElement(object, refTar, idelemsresource);
		EObject from = ModelManager.getEObject(targetReferenceChanged.getFrom(), opt.seed);
		Element fromElement = MutatorUtils.getElement(from, idelemsresource);
		EObject to = ModelManager.getEObject(targetReferenceChanged.getTo(), opt.seed);
		Element toElement = MutatorUtils.getElement(to, idelemsresource);
		EObject oldTo = ModelManager.getEObject(targetReferenceChanged.getOldTo(), opt.seed);
		Element oldToElement = MutatorUtils.getElement(oldTo, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				text += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.FROM_OBJECT) {
					for (modeltext.Word v : fromElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = from;
							}
							else {
								o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
							}
							if (o != null) {
								text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.TO_OBJECT) {
					for (modeltext.Word v : toElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = to;
							}
							else {
								o = (EObject) to.eGet(((modeltext.Variable) v).getRef());
							}
							if (o != null) {
								text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.OLD_TO_OBJECT) {
					for (modeltext.Word v : oldToElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = oldTo;
							}
							else {
								o = (EObject) oldTo.eGet(((modeltext.Variable) v).getRef());
							}
							if (o != null) {
								text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					for (modeltext.Word v : refTarElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
					}
				}
				if (variable.getType() == VariableType.SRC_REF_NAME) {
					for (modeltext.Word v : refSrcElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
					}
				}
			}
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the create reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param referenceCreated
	 * @param opt
	 * @return
	 */
	private String getReferenceCreatedOption(Resource cfgoptsresource, Resource idelemsresource, ReferenceCreated referenceCreated, TestOption opt) {
		String text = "";
		Option cfgopt = MutatorUtils.getConfigureOption("ReferenceCreated", cfgoptsresource);
		EObject object = ModelManager.getEObject(referenceCreated.getObject().get(0), opt.seed);
		String refName = referenceCreated.getRefName();
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				text += ((Constant) w).getValue();
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					text += refName + " ";
				}
			}
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the remove reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param referenceRemoved
	 * @param opt
	 * @return
	 */
	private String getReferenceRemovedOption(Resource cfgoptsresource, Resource idelemsresource, ReferenceRemoved referenceRemoved, TestOption opt) {
		String text = "";
		Option cfgopt = MutatorUtils.getConfigureOption("ReferenceRemoved", cfgoptsresource);
		EObject object = ModelManager.getEObject(referenceRemoved.getObject().get(0), opt.seed);
		EObject ref = ModelManager.getEObject(referenceRemoved.getRef().get(0), opt.seed);
		String refName = (String) ModelManager.getAttribute("name", ref);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				text += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					text += refName + " ";
				}
			}
		}
		return text;
	}

	/**
	 * Stores the natural language options
	 * for the modify attributes mutation
	 * @param exercise
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param informationChanged
	 * @param opt
	 * @param opts
	 * @param mode
	 */
	private void storeAttributeChangedOptions(MutatorTests exercise, Resource cfgoptsresource, Resource idelemsresource, InformationChanged informationChanged, TestOption opt, List<TestOption> opts, Mode mode) {
		List<AttributeChanged> attChanges = informationChanged.getAttChanges();
		EObject object = ModelManager.getEObject(informationChanged.getObject(), opt.seed);
		List<String> attributes = new ArrayList<String>();
		List<String> text = new ArrayList<String>();
		for (AttributeChanged att : attChanges) {
			String txt = "";
			if (att instanceof AttributeSwap) {
				AttributeSwap attSwap = (AttributeSwap) att;
				String attName = attSwap.getAttName();
				EStructuralFeature attributeName = object.eClass().getEStructuralFeature(attName);
				EObject attObject = ModelManager.getEObject(attSwap.getAttObject(), opt.seed);
				String firstName = attSwap.getFirstName();
				String newVal = attSwap.getNewVal();
				Option cfgopt = MutatorUtils.getConfigureOption("AttributeSwap", cfgoptsresource);
				Element firstElement = MutatorUtils.getElement(object, idelemsresource);
				Element secondElement = MutatorUtils.getElement(attObject, idelemsresource);
				Text t = null;
				if (opt.solution == true) {
					t = cfgopt.getValid();
				}
				else {
					t = cfgopt.getInvalid();
				}
				for (Word w : t.getWords()) {
					if (w instanceof Constant) {
						txt += ((Constant) w).getValue() + " ";
					}
					if (w instanceof Variable) {
						Variable variable = (Variable) w;
						if (variable.getType() == VariableType.FIRST_OBJECT) {
							for (modeltext.Word v : firstElement.getWords()) {
								if (v instanceof modeltext.Constant) {
									txt += ((modeltext.Constant) v).getValue() + " ";
								}
								if (v instanceof modeltext.Variable) {
									EObject o = null;
									if (((modeltext.Variable) v).getRef() == null) {
										o = object;
									}
									else {
										o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
									}
									if (o != null) {
										txt +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									}
								}
							}
						}
						if (variable.getType() == VariableType.SECOND_OBJECT) {
							for (modeltext.Word v : secondElement.getWords()) {
								if (v instanceof modeltext.Constant) {
									txt += ((modeltext.Constant) v).getValue() + " ";
								}
								if (v instanceof modeltext.Variable) {
									EObject o = null;
									if (((modeltext.Variable) v).getRef() == null) {
										o = attObject;
									}
									else {
										o = (EObject) attObject.eGet(((modeltext.Variable) v).getRef());
									}
									if (o != null) {
										txt +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									}
								}
							}
						}
						if (variable.getType() == VariableType.FIRST_ATT_NAME) {
							txt += attName + " ";
						}
						if (variable.getType() == VariableType.SECOND_ATT_NAME) {
							txt += firstName + " ";
						}
						if (variable.getType() == VariableType.FIRST_VALUE) {
							txt += object.eGet(attributeName) + " ";
						}
						if (variable.getType() == VariableType.SECOND_VALUE) {
							txt += newVal + " ";
						}
					}
				}
			}
			else {
				Option cfgopt = MutatorUtils.getConfigureOption("AttributeChanged", cfgoptsresource);
				String attName = att.getAttName();
				String oldVal = att.getOldVal();
				String newVal = att.getNewVal();
				Element element = MutatorUtils.getElement(object, idelemsresource);
				Element elementValues = MutatorUtils.getElementValues(object, idelemsresource, opt.solution);
				Text t = null;
				if (opt.solution == true) {
					t = cfgopt.getValid();
				}
				else {
					t = cfgopt.getInvalid();
				}
				for (Word w : t.getWords()) {
					if (w instanceof Constant) {
						txt += ((Constant) w).getValue() + " ";
					}
					if (w instanceof Variable) {
						Variable variable = (Variable) w;
						if (variable.getType() == VariableType.OBJECT) {
							for (modeltext.Word v : element.getWords()) {
								if (v instanceof modeltext.Constant) {
									txt += ((modeltext.Constant) v).getValue() + " ";
								}
								EObject o = null;
								if (v instanceof modeltext.Variable) {
									if (((modeltext.Variable) v).getRef() == null) {
										o = object;
									}
									else {
										o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
									}
									if (o != null) {
										txt +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									}
								}
							}
						}
						if (variable.getType() == VariableType.ATT_NAME) {
							txt += attName + " ";
						}
						if (variable.getType() == VariableType.OLD_VALUE) {
							txt += oldVal + " ";
						}
						if (variable.getType() == VariableType.NEW_VALUE) {
							txt += newVal + " ";
						}
						if (variable.getType() == VariableType.VALUE) {
							for (modeltext.Word v : elementValues.getWords()) {
								if (v instanceof modeltext.Constant) {
									txt += ((modeltext.Constant) v).getValue() + " ";
								}
							}
						}
					}
				}
			}
			text.add(txt);
			storeOptionList(exercise, text, attributes, mode, opt, opts, EcoreUtil.getURI(informationChanged.getDef()).toString());
		}
		if (mode == Mode.RADIOBUTTON) { 
			for (String txt : attributes) {
				if (!opt.text.get(EcoreUtil.getURI(informationChanged.getDef()).toString()).contains(txt)) {
					opt.text.get(EcoreUtil.getURI(informationChanged.getDef()).toString()).add(txt);
				}
			}
		}
	}

	/**
	 * Gets the natural language option for the
	 * reference changed mutation
	 * @param t
	 * @param object
	 * @param from
	 * @param to
	 * @param element
	 * @param fromElement
	 * @param refTarElement
	 * @param refSrcElement
	 * @return
	 */
	private String getReferenceChangedOptionNewerOlder(Text t, EObject object, EObject from, EObject to, Element element, Element fromElement, Element toElement, Element refTarElement, Element refSrcElement) {
		String text = "";
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				text += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.FROM_OBJECT) {
					for (modeltext.Word v : fromElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = from;
							}
							else {
								o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.TO_OBJECT) {
					for (modeltext.Word v : toElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							text += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = to;
							}
							else {
								o = (EObject) to.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), to));
							}
							if (o != null) {
								text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					if (refTarElement != null) {
						for (modeltext.Word v : refTarElement.getWords()) {
							if (v instanceof modeltext.Constant) {
								text += ((modeltext.Constant) v).getValue() + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.SRC_REF_NAME) {
					if (refTarElement != null) {
						for (modeltext.Word v : refSrcElement.getWords()) {
							if (v instanceof modeltext.Constant) {
								text += ((modeltext.Constant) v).getValue() + " ";
							}
						}
					}
				}
			}
		}
		return text;
	}
	
	/**
	 * Gets the natural language option for the
	 * reference changed mutation
	 * @param opt
	 * @param t
	 * @param object
	 * @param to
	 * @param element
	 * @param refSrcElement
	 * @return
	 */
	private String getReferenceChangedOptionNotOlder(TestOption opt, Text t, EObject object, EObject to, Element element, Element toElement, Element refSrcElement) {
		String text = "";
		if (opt.solution == true) {
			text += "Delete ";
			for (modeltext.Word v : refSrcElement.getWords()) {
				if (v instanceof modeltext.Constant) {
					text += ((modeltext.Constant) v).getValue() + " ";
				}
			}
			text += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : element.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
					if (variable.getType() == VariableType.TO_OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = to;
								}
								else {
									o = (EObject) to.eGet(((modeltext.Variable) v).getRef());
								}
								if (o != null) {
									text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
				}
			}
		}
		else {
			text += "Create ";
			for (modeltext.Word v : refSrcElement.getWords()) {
				if (v instanceof modeltext.Constant) {
					text += ((modeltext.Constant) v).getValue() + " ";
				}
			}
			text += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : element.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
					if (variable.getType() == VariableType.TO_OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = to;
								}
								else {
									o = (EObject) to.eGet(((modeltext.Variable) v).getRef());
								}
								if (o != null) {
									text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
				}
			}
		}
		return text;
	}
	
	private String getReferenceChangedOptionNotNewer(TestOption opt, Text t, EObject object, EObject from, Element fromElement, Element toElement, Element refSrcElement) {
		String text = "";
		if (opt.solution == true) {
			text += "Create ";
			for (modeltext.Word v : refSrcElement.getWords()) {
				if (v instanceof modeltext.Constant) {
					text += ((modeltext.Constant) v).getValue() + " ";
				}
			}
			text += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.FROM_OBJECT) {
						for (modeltext.Word v : fromElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = from;
								}
								else {
									o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
								}
								if (o != null) {
									text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
				}
			}
		}
		else {
			text += "Delete ";
			for (modeltext.Word v : refSrcElement.getWords()) {
				if (v instanceof modeltext.Constant) {
					text += ((modeltext.Constant) v).getValue() + " ";
				}
			}
			text += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.FROM_OBJECT) {
						for (modeltext.Word v : fromElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = from;
								}
								else {
									o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
								}
								if (o != null) {
									text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								}
							}
						}
					}
				}
			}
		}
		return text;
	}

	/**
	 * Stores the natural language options
	 * for the modify references mutation
	 * @param exercise
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param informationChanged
	 * @param opt
	 * @param opts
	 * @param mode
	 */
	private void storeReferenceChangedOptions(MutatorTests exercise, Resource cfgoptsresource, Resource idelemsresource, InformationChanged informationChanged, TestOption opt, List<TestOption> opts, Mode mode) {
		List<ReferenceChanged> refChanges = informationChanged.getRefChanges();
		EObject object = ModelManager.getEObject(informationChanged.getObject(), opt.seed);
		List<String> references = new ArrayList<String>();
		List<String> text = new ArrayList<String>();
		for (ReferenceChanged ref : refChanges) {
			String txt = "";
			ReferenceChanged referenceChanged = (ReferenceChanged) ref;
			Option cfgopt = MutatorUtils.getConfigureOption("ReferenceChanged", cfgoptsresource);
			Element element = MutatorUtils.getElement(object, idelemsresource);
			String srcRefName = referenceChanged.getSrcRefName();
			EStructuralFeature refSrc = object.eClass().getEStructuralFeature(srcRefName);
			Element refSrcElement = MutatorUtils.getRefElement(object, refSrc, idelemsresource);
			String refName = referenceChanged.getRefName();
			EStructuralFeature refTar = ModelManager.getReferenceByName(refName, object);
			Element refTarElement = MutatorUtils.getRefElement(object, refTar, idelemsresource);
			EObject from = null;
			if (referenceChanged.getFrom() != null) {
				from = ModelManager.getEObject(referenceChanged.getFrom(), opt.seed);
			}
			Element fromElement = MutatorUtils.getElement(from, idelemsresource);
			EObject to = ModelManager.getEObject(referenceChanged.getTo(), opt.seed);
			Element toElement = MutatorUtils.getElement(to, idelemsresource);
			Text t = null;
			if (opt.solution == true) {
				t = cfgopt.getValid();
			}
			else {
				t = cfgopt.getInvalid();
			}
			boolean older = fromElement != null;
			boolean newer = toElement != null;
			if (older && newer) {
				txt += getReferenceChangedOptionNewerOlder(t, object, from, to, element, fromElement, toElement, refTarElement, refSrcElement);
			}
			if (!older) {
				txt += getReferenceChangedOptionNotOlder(opt, t, object, to, element, toElement, refSrcElement);
			}
			if (!newer) {
				txt += getReferenceChangedOptionNotNewer(opt, t, object, from, fromElement, toElement, refSrcElement);
			}
			text.add(txt);
			storeOptionList(exercise, text, references, mode, opt, opts, EcoreUtil.getURI(informationChanged.getDef()).toString());
		}
		if (mode == Mode.RADIOBUTTON) { 
			for (String txt : references) {
				if (!opt.text.get(EcoreUtil.getURI(informationChanged.getDef()).toString()).contains(txt)) {
					opt.text.get(EcoreUtil.getURI(informationChanged.getDef()).toString()).add(txt);
				}
			}
		}
	}

	/**
	 * Gets the natural language option
	 * for the create object mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param objectCreated
	 * @param opt
	 * @return
	 */
	private List<String> getObjectCreatedText(Resource cfgoptsresource, Resource idelemsresource, ObjectCreated objectCreated, TestOption opt, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		Option cfgopt = MutatorUtils.getConfigureOption("ObjectCreated", cfgoptsresource);
		EObject object = ModelManager.getEObject(objectCreated.getObject().get(0), opt.seed);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		String txt = "";
		boolean createText = false;
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				if (createText == true) {
					text.add(txt);
					txt = "";
					createText = false;
				}
				txt += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(objectCreated.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}
	
	/**
	 * Gets the natural language option
	 * for the remove object mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param objectRemoved
	 * @param opt
	 * @return
	 */
	private List<String> getObjectRemovedText(Resource cfgoptsresource, Resource idelemsresource, ObjectRemoved objectRemoved, TestOption opt, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		Option cfgopt = MutatorUtils.getConfigureOption("ObjectRemoved", cfgoptsresource);
		EObject object = ModelManager.getEObject(objectRemoved.getObject().get(0), opt.seed);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		String txt = "";
		boolean createText = false;
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				if (createText == true) {
					text.add(txt);
					txt = "";
					createText = false;
				}
				txt += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(objectRemoved.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the modify source reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param sourceReferenceChanged
	 * @param opt
	 * @return
	 */
	private List<String> getSourceReferenceChangedText(Resource cfgoptsresource, Resource idelemsresource, SourceReferenceChanged sourceReferenceChanged, TestOption opt, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		Option cfgopt = MutatorUtils.getConfigureOption("SourceReferenceChanged", cfgoptsresource);
		EObject from = ModelManager.getEObject(sourceReferenceChanged.getFrom(), opt.seed);
		String refName = sourceReferenceChanged.getRefName();
		EStructuralFeature srcRef = from.eClass().getEStructuralFeature(refName);
		Element srcElement = MutatorUtils.getElement((EObject) from.eGet(srcRef), idelemsresource);
		EObject to = ModelManager.getEObject(sourceReferenceChanged.getTo(), opt.seed);
		EStructuralFeature tarRef = to.eClass().getEStructuralFeature(refName);
		Element tarElement = MutatorUtils.getElement((EObject) to.eGet(tarRef), idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		String txt = "";
		boolean createText = false;
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				if (createText == true) {
					text.add(txt);
					txt = "";
					createText = false;
				}
				txt += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OLD_FROM_OBJECT) {
					for (modeltext.Word v : srcElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = (EObject) from.eGet(srcRef);
							}
							else {
								o = (EObject) ((EObject) from.eGet(srcRef)).eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), (EObject) from.eGet(srcRef)));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(sourceReferenceChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;									
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.FROM_OBJECT) {
					for (modeltext.Word v : tarElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = (EObject) to.eGet(tarRef);
							}
							else {
								o = (EObject) ((EObject) to.eGet(tarRef)).eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), (EObject) to.eGet(tarRef)));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(sourceReferenceChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					for (modeltext.Word v : tarElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
 						}
					}
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the modify target reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param targetReferenceChanged
	 * @param opt
	 * @return
	 */
	private List<String> getTargetReferenceChangedText(Resource cfgoptsresource, Resource idelemsresource, TargetReferenceChanged targetReferenceChanged, TestOption opt, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		Option cfgopt = MutatorUtils.getConfigureOption("TargetReferenceChanged", cfgoptsresource);
		EObject object = ModelManager.getEObject(targetReferenceChanged.getObject().get(0), opt.seed);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		String refName = targetReferenceChanged.getRefName();
		EStructuralFeature refSrc = ModelManager.getReferenceByName(refName, object);
		Element refSrcElement = MutatorUtils.getRefElement(object, refSrc, idelemsresource);
		EStructuralFeature refTar = ModelManager.getReferenceByName(refName, object);
		Element refTarElement = MutatorUtils.getRefElement(object, refTar, idelemsresource);
		EObject from = ModelManager.getEObject(targetReferenceChanged.getFrom(), opt.seed);
		Element fromElement = MutatorUtils.getElement(from, idelemsresource);
		EObject to = ModelManager.getEObject(targetReferenceChanged.getTo(), opt.seed);
		Element toElement = MutatorUtils.getElement(to, idelemsresource);
		EObject oldTo = ModelManager.getEObject(targetReferenceChanged.getOldTo(), opt.seed);
		Element oldToElement = MutatorUtils.getElement(oldTo, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		String txt = "";
		boolean createText = false;
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				if (createText == true) {
					text.add(txt);
					txt = "";
					createText = false;
				}
				txt += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(targetReferenceChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.FROM_OBJECT) {
					for (modeltext.Word v : fromElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = from;
							}
							else {
								o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(targetReferenceChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.TO_OBJECT) {
					for (modeltext.Word v : toElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = to;
							}
							else {
								o = (EObject) to.eGet(((modeltext.Variable) v).getRef());
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(targetReferenceChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.OLD_TO_OBJECT) {
					for (modeltext.Word v : oldToElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = oldTo;
							}
							else {
								o = (EObject) oldTo.eGet(((modeltext.Variable) v).getRef());
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(targetReferenceChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					for (modeltext.Word v : refTarElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
 						}
					}
				}
				if (variable.getType() == VariableType.SRC_REF_NAME) {
					for (modeltext.Word v : refSrcElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
 						}
					}
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the create reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param referenceCreated
	 * @param opt
	 * @return
	 */
	private List<String> getReferenceCreatedText(Resource cfgoptsresource, Resource idelemsresource, ReferenceCreated referenceCreated, TestOption opt, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		Option cfgopt = MutatorUtils.getConfigureOption("ReferenceCreated", cfgoptsresource);
		EObject object = ModelManager.getEObject(referenceCreated.getObject().get(0), opt.seed);
		String refName = referenceCreated.getRefName();
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		String txt = "";
		boolean createText = false;
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				if (createText == true) {
					text.add(txt);
					txt = "";
					createText = false;
				}
				txt += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(referenceCreated.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					if (createText == true) {
						text.add(txt);
						txt = "";
						createText = false;
					}
					txt += refName + " ";
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}

	/**
	 * Gets the natural language options
	 * for the remove reference mutation
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param referenceRemoved
	 * @param opt
	 * @return
	 */
	private List<String> getReferenceRemovedText(Resource cfgoptsresource, Resource idelemsresource, ReferenceRemoved referenceRemoved, TestOption opt, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		Option cfgopt = MutatorUtils.getConfigureOption("ReferenceRemoved", cfgoptsresource);
		EObject object = ModelManager.getEObject(referenceRemoved.getObject().get(0), opt.seed);
		EObject ref = ModelManager.getEObject(referenceRemoved.getRef().get(0), opt.seed);
		String refName = (String) ModelManager.getAttribute("name", ref);
		Element element = MutatorUtils.getElement(object, idelemsresource);
		Text t = null;
		if (opt.solution == true) {
			t = cfgopt.getValid();
		}
		else {
			t = cfgopt.getInvalid();
		}
		String txt = "";
		boolean createText = false;
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				if (createText == true) {
					text.add(txt);
					txt = "";
					createText = false;
				}
				txt += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(referenceRemoved.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					if (createText == true) {
						text.add(txt);
						txt = "";
						createText = false;
					}
					txt += refName + " ";
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}

	/**
	 * Stores the natural language options
	 * for the modify attributes mutation
	 * @param exercise
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param informationChanged
	 * @param opt
	 * @param opts
	 * @param mode
	 */
	private void storeAttributeChangedText(MutatorTests exercise, Resource cfgoptsresource, Resource idelemsresource, InformationChanged informationChanged, TestOption opt, List<TestOption> opts, Mode mode, String[] mutURI, int[] index) {
		List<AttributeChanged> attChanges = informationChanged.getAttChanges();
		EObject object = ModelManager.getEObject(informationChanged.getObject(), opt.seed);
		List<String> attributes = new ArrayList<String>();
		List<String> text = new ArrayList<String>();
		for (AttributeChanged att : attChanges) {
			if (att instanceof AttributeSwap) {
				AttributeSwap attSwap = (AttributeSwap) att;
				String attName = attSwap.getAttName();
				EStructuralFeature attributeName = object.eClass().getEStructuralFeature(attName);
				EObject attObject = ModelManager.getEObject(attSwap.getAttObject(), opt.seed);
				String firstName = attSwap.getFirstName();
				String newVal = attSwap.getNewVal();
				Option cfgopt = MutatorUtils.getConfigureOption("AttributeSwap", cfgoptsresource);
				Element firstElement = MutatorUtils.getElement(object, idelemsresource);
				Element secondElement = MutatorUtils.getElement(attObject, idelemsresource);
				Text t = null;
				if (opt.solution == true) {
					t = cfgopt.getValid();
				}
				else {
					t = cfgopt.getInvalid();
				}
				String txt = "";
				boolean createText = false;
				for (Word w : t.getWords()) {
					if (w instanceof Constant) {
						if (createText == true) {
							text.add(txt);
							txt = "";
							createText = false;
						}
						txt += ((Constant) w).getValue() + " ";
					}
					if (w instanceof Variable) {
						Variable variable = (Variable) w;
						if (variable.getType() == VariableType.FIRST_OBJECT) {
							for (modeltext.Word v : firstElement.getWords()) {
								if (v instanceof modeltext.Constant) {
									if (createText == true) {
										text.add(txt);
										txt = "";
										createText = false;
									}
									txt += ((modeltext.Constant) v).getValue() + " ";
								}
								if (v instanceof modeltext.Variable) {
									createText = true;
									EObject o = null;
									if (((modeltext.Variable) v).getRef() == null) {
										o = object;
									}
									else {
										o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
									}
									if (o != null) {
										List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
										if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
											entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
											opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
										}
										else {
											entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
										}
										//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
										String type = o.eClass().getName();
										List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
										index[0]++;
										for (EObject ob : objects) {
											SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
											if (EcoreUtil.equals(o, ob)) {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
											}
											else {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
											}
											entries.add(value);
										}
									}
								}
							}
						}
						if (variable.getType() == VariableType.SECOND_OBJECT) {
							for (modeltext.Word v : secondElement.getWords()) {
								if (v instanceof modeltext.Constant) {
									if (createText == true) {
										text.add(txt);
										txt = "";
										createText = false;
									}
									txt += ((modeltext.Constant) v).getValue() + " ";
								}
								if (v instanceof modeltext.Variable) {
									createText = true;
									EObject o = null;
									if (((modeltext.Variable) v).getRef() == null) {
										o = attObject;
									}
									else {
										o = (EObject) attObject.eGet(((modeltext.Variable) v).getRef());
									}
									if (o != null) {
										List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
										mutURI[0] = EcoreUtil.getURI(informationChanged.getDef()).toString();
										if (opt.options.get(mutURI[0]) == null) {
											entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
											opt.options.put(mutURI[0], entries);
										}
										else {
											entries = opt.options.get(mutURI[0]);
										}
										//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
										String type = o.eClass().getName();
										List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
										index[0]++;
										for (EObject ob : objects) {
											SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
											if (EcoreUtil.equals(o, ob)) {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
											}
											else {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
											}
											entries.add(value);
										}
									}
								}
							}
						}
						if (variable.getType() == VariableType.FIRST_ATT_NAME) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(attName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									for (EAttribute attribute : eClass.getEAllAttributes()) {
										if (attribute.getEAttributeType().getInstanceTypeName().equals(eAttribute.getEAttributeType().getInstanceTypeName())) {
											SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
											if (attribute.getName().equals(eAttribute.getName())) {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(attribute.getName(), new SimpleEntry<Integer, Boolean>(index[0], true));
											}
											else {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(attribute.getName(), new SimpleEntry<Integer, Boolean>(index[0], false));
											}
											entries.add(value);
										}
									}
								}
							}
						}
						if (variable.getType() == VariableType.SECOND_ATT_NAME) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(firstName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									for (EAttribute attribute : eClass.getEAllAttributes()) {
										if (attribute.getEAttributeType().getInstanceTypeName().equals(eAttribute.getEAttributeType().getInstanceTypeName())) {
											SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
											if (attribute.getName().equals(eAttribute.getName())) {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(attribute.getName(), new SimpleEntry<Integer, Boolean>(index[0], true));
											}
											else {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(attribute.getName(), new SimpleEntry<Integer, Boolean>(index[0], false));
											}
											entries.add(value);
										}
									}
								}
							}
						}
						if (variable.getType() == VariableType.FIRST_VALUE) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(attributeName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									if (eAttribute.getEAttributeType().getInstanceTypeName().equals("boolean")) {
										boolean solution = false;
										if (object.eGet(attributeName).equals("true")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>("true", new SimpleEntry<Integer, Boolean>(index[0], solution)));
										solution = false;
										if (object.eGet(attributeName).equals("false")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>("false", new SimpleEntry<Integer, Boolean>(index[0], solution)));
									}
								}
							}
						}
						if (variable.getType() == VariableType.SECOND_VALUE) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(attName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									if (eAttribute.getEAttributeType().getInstanceTypeName().equals("boolean")) {
										boolean solution = false;
										if (newVal.equals("true")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>("true", new SimpleEntry<Integer, Boolean>(index[0], solution)));
										solution = false;
										if (newVal.equals("false")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>("false", new SimpleEntry<Integer, Boolean>(index[0], solution)));
									}
								}
							}
						}
					}
				}
				if (txt.length() > 0) {
					text.add(txt);
				}
			}
			else {
				Option cfgopt = MutatorUtils.getConfigureOption("AttributeChanged", cfgoptsresource);
				String attName = att.getAttName();
				String oldVal = att.getOldVal();
				String newVal = att.getNewVal();
				Element element = MutatorUtils.getElement(object, idelemsresource);
				Element elementValues = MutatorUtils.getElementValues(object, idelemsresource, opt.solution);
				Text t = null;
				if (opt.solution == true) {
					t = cfgopt.getValid();
				}
				else {
					t = cfgopt.getInvalid();
				}
				String txt = "";
				boolean createText = false;
				for (Word w : t.getWords()) {
					if (w instanceof Constant) {
						if (createText == true) {
							text.add(txt);
							txt = "";
							createText = false;
						}
						txt += ((Constant) w).getValue() + " ";
					}
					if (w instanceof Variable) {
						Variable variable = (Variable) w;
						if (variable.getType() == VariableType.OBJECT) {
							for (modeltext.Word v : element.getWords()) {
								if (v instanceof modeltext.Constant) {
									if (createText == true) {
										text.add(txt);
										txt = "";
										createText = false;
									}
									txt += ((modeltext.Constant) v).getValue() + " ";
								}
								if (v instanceof modeltext.Variable) {
									createText = true;
									EObject o = null;
									if (((modeltext.Variable) v).getRef() == null) {
										o = object;
									}
									else {
										o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
									}
									if (o != null) {
										List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
										mutURI[0] = EcoreUtil.getURI(informationChanged.getDef()).toString();
										if (opt.options.get(mutURI[0]) == null) {
											entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
											opt.options.put(mutURI[0], entries);
										}
										else {
											entries = opt.options.get(mutURI[0]);
										}
										//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
										String type = o.eClass().getName();
										List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
										index[0]++;
										for (EObject ob : objects) {
											SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
											if (EcoreUtil.equals(o, ob)) {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
											}
											else {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
											}
											entries.add(value);
										}
									}
								}
							}
						}
						if (variable.getType() == VariableType.ATT_NAME) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(attName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									for (EAttribute attribute : eClass.getEAllAttributes()) {
										if (attribute.getEAttributeType().getInstanceTypeName().equals(eAttribute.getEAttributeType().getInstanceTypeName())) {
											SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
											if (attribute.getName().equals(eAttribute.getName())) {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(attribute.getName(), new SimpleEntry<Integer, Boolean>(index[0], true));
											}
											else {
												value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(attribute.getName(), new SimpleEntry<Integer, Boolean>(index[0], false));
											}
											entries.add(value);
										}
									}
								}
							}
						}
						if (variable.getType() == VariableType.OLD_VALUE) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(attName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									if (eAttribute.getEAttributeType().getInstanceTypeName().equals("boolean")) {
										boolean solution = false;
										if (oldVal.equals("true")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>("true", new SimpleEntry<Integer, Boolean>(index[0], solution)));
										solution = false;
										if (oldVal.equals("false")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>("false", new SimpleEntry<Integer, Boolean>(index[0], solution)));
									}
								}
							}
						}
						if (variable.getType() == VariableType.NEW_VALUE) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(attName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									if (eAttribute.getEAttributeType().getInstanceTypeName().equals("boolean")) {
										boolean solution = false;
										if (newVal.equals("true")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>("true", new SimpleEntry<Integer, Boolean>(index[0], solution)));
										solution = false;
										if (newVal.equals("false")) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean >>("false", new SimpleEntry<Integer, Boolean>(index[0], solution)));
									}
								}
							}
						}
						if (variable.getType() == VariableType.VALUE) {
							createText = true;
							ModifyInformationMutator modify = (ModifyInformationMutator) att.getDef();
							if (modify != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								EClass eClass = modify.getObject().getType();
								EAttribute eAttribute = null;
								for (EAttribute attribute : eClass.getEAllAttributes()) {
									if (attribute.getName().equals(attName)) {
										eAttribute = attribute;
										break;
									}
								}
								if (eAttribute != null) {
									index[0]++;
									String solutionText = "";
									for (modeltext.Word v : elementValues.getWords()) {
										solutionText += ((modeltext.Constant) v).getValue() + " ";
									}
									List<Element> elements = MutatorUtils.getAllElementValues(object, idelemsresource);
									for (Element elem : elements) {
										String optionText = "";
										for (modeltext.Word v : elem.getWords()) {
											optionText += ((modeltext.Constant) v).getValue() + " ";
										}
										boolean solution = false;
										if (optionText.equals(solutionText)) {
											solution = true;
										}
										entries.add(new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(optionText, new SimpleEntry<Integer, Boolean>(index[0], solution)));
									}
								}
							}
						}
					}
				}
				if (txt.length() > 0) {
					text.add(txt);
				}
			}
			storeOptionList(exercise, text, attributes, mode, opt, opts, EcoreUtil.getURI(informationChanged.getDef()).toString());
		}
		if (mode == Mode.RADIOBUTTON) { 
			for (String txt : attributes) {
				if (!opt.text.get(EcoreUtil.getURI(informationChanged.getDef()).toString()).contains(txt)) {
					opt.text.get(EcoreUtil.getURI(informationChanged.getDef()).toString()).add(txt);
				}
			}
		}
	}
	
	/**
	 * Gets the natural language option for the
	 * reference changed mutation
	 * @param t
	 * @param object
	 * @param from
	 * @param to
	 * @param element
	 * @param fromElement
	 * @param refTarElement
	 * @param refSrcElement
	 * @return
	 */
	private List<String> getReferenceChangedTextNewerOlder(Text t, InformationChanged informationChanged, TestOption opt, EObject object, EObject from, EObject to, Element element, Element fromElement, Element toElement, Element refTarElement, Element refSrcElement, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		String txt = "";
		boolean createText = false;
		for (Word w : t.getWords()) {
			if (w instanceof Constant) {
				if (createText == true) {
					text.add(txt);
					txt = "";
					createText = false;
				}
				txt += ((Constant) w).getValue() + " ";
			}
			if (w instanceof Variable) {
				Variable variable = (Variable) w;
				if (variable.getType() == VariableType.OBJECT) {
					for (modeltext.Word v : element.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = object;
							}
							else {
								o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
								}
								else {
									entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.FROM_OBJECT) {
					for (modeltext.Word v : fromElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = from;
							}
							else {
								o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(informationChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.TO_OBJECT) {
					for (modeltext.Word v : toElement.getWords()) {
						if (v instanceof modeltext.Constant) {
							if (createText == true) {
								text.add(txt);
								txt = "";
								createText = false;
							}
							txt += ((modeltext.Constant) v).getValue() + " ";
						}
						if (v instanceof modeltext.Variable) {
							createText = true;
							EObject o = null;
							if (((modeltext.Variable) v).getRef() == null) {
								o = to;
							}
							else {
								o = (EObject) to.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), to));
							}
							if (o != null) {
								List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
								mutURI[0] = EcoreUtil.getURI(informationChanged.getDef()).toString();
								if (opt.options.get(mutURI[0]) == null) {
									entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
									opt.options.put(mutURI[0], entries);
								}
								else {
									entries = opt.options.get(mutURI[0]);
								}
								//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
								String type = o.eClass().getName();
								List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
								index[0]++;
								for (EObject ob : objects) {
									SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
									if (EcoreUtil.equals(o, ob)) {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
									}
									else {
										value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
									}
									entries.add(value);
								}
							}
						}
					}
				}
				if (variable.getType() == VariableType.REF_NAME) {
					if (refTarElement != null) {
						for (modeltext.Word v : refTarElement.getWords()) {
							if (v instanceof modeltext.Constant) {
								if (createText == true) {
									text.add(txt);
									txt = "";
									createText = false;
								}
								txt += ((modeltext.Constant) v).getValue() + " ";
							}
						}
					}
				}
				if (variable.getType() == VariableType.SRC_REF_NAME) {
					if (refTarElement != null) {
						for (modeltext.Word v : refSrcElement.getWords()) {
							if (v instanceof modeltext.Constant) {
								if (createText == true) {
									text.add(txt);
									txt = "";
									createText = false;
								}
								txt += ((modeltext.Constant) v).getValue() + " ";
							}
						}
					}
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}
	
	/**
	 * Gets the natural language option for the
	 * reference changed mutation
	 * @param opt
	 * @param t
	 * @param object
	 * @param to
	 * @param element
	 * @param refSrcElement
	 * @return
	 */
	private List<String> getReferenceChangedTextNotOlder(Text t, InformationChanged informationChanged, TestOption opt, EObject object, EObject to, Element element, Element toElement, Element refSrcElement, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		String txt = "";
		boolean createText = false;
		if (opt.solution == true) {
			txt += "Delete ";
			for (modeltext.Word w : refSrcElement.getWords()) {
				if (w instanceof Constant) {
					if (createText == true) {
						text.add(txt);
						txt = "";
						createText = false;
					}
					txt += ((Constant) w).getValue() + " ";
				}
			}
			txt += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : element.getWords()) {
							if (v instanceof modeltext.Variable) {
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
									}
									else {
										entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
									}
									//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
					if (variable.getType() == VariableType.TO_OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								createText = true;
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = to;
								}
								else {
									o = (EObject) to.eGet(((modeltext.Variable) v).getRef());
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									mutURI[0] = EcoreUtil.getURI(informationChanged.getDef()).toString();
									if (opt.options.get(mutURI[0]) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(mutURI[0], entries);
									}
									else {
										entries = opt.options.get(mutURI[0]);
									}
									//text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			txt += "Create ";
			for (modeltext.Word w : refSrcElement.getWords()) {
				if (w instanceof modeltext.Constant) {
					if (w instanceof Constant) {
						if (createText == true) {
							text.add(txt);
							txt = "";
							createText = false;
						}
						txt += ((Constant) w).getValue() + " ";
					}
				}
			}
			txt += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : element.getWords()) {
							if (v instanceof modeltext.Variable) {
								createText = true;
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
									}
									else {
										entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
									}
									//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
					if (variable.getType() == VariableType.TO_OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								createText = true;
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = to;
								}
								else {
									o = (EObject) to.eGet(((modeltext.Variable) v).getRef());
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
									}
									else {
										entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
									}
									//text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}
	
	private List<String> getReferenceChangedTextNotNewer(Text t, InformationChanged informationChanged, TestOption opt, EObject object, EObject from, Element fromElement, Element toElement, Element refSrcElement, String[] mutURI, int[] index) {
		List<String> text = new ArrayList<String>();
		String txt = "";
		boolean createText = false;
		if (opt.solution == true) {
			txt += "Create ";
			for (modeltext.Word w : refSrcElement.getWords()) {
				if (w instanceof Constant) {
					if (createText == true) {
						text.add(txt);
						txt = "";
						createText = false;
					}
					txt += ((Constant) w).getValue() + " ";
				}
			}
			txt += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.FROM_OBJECT) {
						for (modeltext.Word v : fromElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								createText = true;
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = from;
								}
								else {
									o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
									}
									else {
										entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
									}
									//text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								createText = true;
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									mutURI[0] = EcoreUtil.getURI(informationChanged.getDef()).toString();
									if (opt.options.get(mutURI[0]) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(mutURI[0], entries);
									}
									else {
										entries = opt.options.get(mutURI[0]);
									}
									//text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
				}
			}
		}
		else {
			txt += "Delete ";
			for (modeltext.Word w : refSrcElement.getWords()) {
				if (w instanceof modeltext.Constant) {
					if (w instanceof Constant) {
						if (createText == true) {
							text.add(txt);
							txt = "";
							createText = false;
						}
						txt += ((Constant) w).getValue() + " ";
					}
				}
			}
			txt += " from ";
			for (Word w : t.getWords()) {
				if (w instanceof Variable) {
					Variable variable = (Variable) w;
					if (variable.getType() == VariableType.FROM_OBJECT) {
						for (modeltext.Word v : fromElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								createText = true;
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = from;
								}
								else {
									o = (EObject) from.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), from));
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
									}
									else {
										entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
									}
									//text += o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
					if (variable.getType() == VariableType.OBJECT) {
						for (modeltext.Word v : toElement.getWords()) {
							if (v instanceof modeltext.Variable) {
								createText = true;
								EObject o = null;
								if (((modeltext.Variable) v).getRef() == null) {
									o = object;
								}
								else {
									o = (EObject) object.eGet(ModelManager.getReferenceByName(((modeltext.Variable) v).getRef().getName(), object));
								}
								if (o != null) {
									List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = null;
									if (opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString()) == null) {
										entries = new ArrayList<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>();
										opt.options.put(EcoreUtil.getURI(informationChanged.getDef()).toString(), entries);
									}
									else {
										entries = opt.options.get(EcoreUtil.getURI(informationChanged.getDef()).toString());
									}
									//text +=  "to " + o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									String type = o.eClass().getName();
									List<EObject> objects = ModelManager.getObjectsOfType(type, o.eResource());
									index[0]++;
									for (EObject ob : objects) {
										SimpleEntry<String, SimpleEntry<Integer, Boolean>> value = null;
										if (EcoreUtil.equals(o, ob)) {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], true));
										}
										else {
											value = new SimpleEntry<String, SimpleEntry<Integer, Boolean>>(ModelManager.getStringAttribute(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), ob).getName(), ob), new SimpleEntry<Integer, Boolean>(index[0], false));
										}
										entries.add(value);
									}
								}
							}
						}
					}
				}
			}
		}
		if (txt.length() > 0) {
			text.add(txt);
		}
		return text;
	}

	/**
	 * Stores the natural language options
	 * for the modify references mutation
	 * @param exercise
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param informationChanged
	 * @param opt
	 * @param opts
	 * @param mode
	 */
	private void storeReferenceChangedText(MutatorTests exercise, Resource cfgoptsresource, Resource idelemsresource, InformationChanged informationChanged, TestOption opt, List<TestOption> opts, Mode mode, String[] mutURI, int[] index) {
		List<ReferenceChanged> refChanges = informationChanged.getRefChanges();
		EObject object = ModelManager.getEObject(informationChanged.getObject(), opt.seed);
		List<String> references = new ArrayList<String>();
		List<String> text = new ArrayList<String>();
		for (ReferenceChanged ref : refChanges) {
			ReferenceChanged referenceChanged = (ReferenceChanged) ref;
			Option cfgopt = MutatorUtils.getConfigureOption("ReferenceChanged", cfgoptsresource);
			Element element = MutatorUtils.getElement(object, idelemsresource);
			String srcRefName = referenceChanged.getSrcRefName();
			EStructuralFeature refSrc = object.eClass().getEStructuralFeature(srcRefName);
			Element refSrcElement = MutatorUtils.getRefElement(object, refSrc, idelemsresource);
			String refName = referenceChanged.getRefName();
			EStructuralFeature refTar = ModelManager.getReferenceByName(refName, object);
			Element refTarElement = MutatorUtils.getRefElement(object, refTar, idelemsresource);
			EObject from = ModelManager.getEObject(referenceChanged.getFrom(), opt.seed);
			Element fromElement = MutatorUtils.getElement(from, idelemsresource);
			EObject to = ModelManager.getEObject(referenceChanged.getTo(), opt.seed);
			Element toElement = MutatorUtils.getElement(to, idelemsresource);
			Text t = null;
			if (opt.solution == true) {
				t = cfgopt.getValid();
			}
			else {
				t = cfgopt.getInvalid();
			}
			boolean older = fromElement != null;
			boolean newer = toElement != null;
			if (older && newer) {
				text.addAll(getReferenceChangedTextNewerOlder(t, informationChanged, opt, object, from, to, element, fromElement, toElement, refTarElement, refSrcElement, mutURI, index));
			}
			if (!older) {
				text.addAll(getReferenceChangedTextNotOlder(t, informationChanged, opt, object, to, element, toElement, refSrcElement, mutURI, index));
			}
			if (!newer) {
				text.addAll(getReferenceChangedTextNotNewer(t, informationChanged, opt, object, from, fromElement, toElement, refSrcElement, mutURI, index));
			}
			storeOptionList(exercise, text, references, mode, opt, opts, EcoreUtil.getURI(informationChanged.getDef()).toString());
		}
	}
	
	/**
	 * Builds the multi choice emendation
	 * natural language options
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param exercise
	 * @param testOptions
	 * @param mode
	 */
	private void buildOptionsMultiChoiceEmendation(Resource cfgoptsresource, Resource idelemsresource, MultiChoiceEmendation exercise, Map<Test, List<TestOption>> testOptions, Mode mode) {
		for (Test test : exercise.getTests()) {
			List<TestOption> opts = new ArrayList<TestOption>();
			if (options.get(exercise).get(test) != null) {
				for (TestOption opt : options.get(exercise).get(test)) {
					opt.text = new HashMap<String, List<String>>();
					List<EObject> mutations = MutatorUtils.getMutations(ModelManager.getObjects(opt.resource));
					for (EObject mutation : mutations) {
						List<String> text = new ArrayList<String>();
						List<EClass> superTypes = mutation.eClass().getEAllSuperTypes();
						boolean flag = false;
						for (EClass cl : superTypes) {
							if (cl.getName().equals("AppMutation")) {
								flag = true;
								break;
							}
						}
						if (flag == true) {
							if (mutation instanceof ObjectCreated) {
								text.add(getObjectCreatedOption(cfgoptsresource, idelemsresource, (ObjectCreated) mutation, opt));
								storeOption(exercise, text, mode, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof ObjectRemoved) {
								text.add(getObjectRemovedOption(cfgoptsresource, idelemsresource, (ObjectRemoved) mutation, opt));
								storeOption(exercise, text, mode, opt, opts, EcoreUtil.getURI(mutation).toString());
							}							
							if (mutation instanceof SourceReferenceChanged) {
								text.add(getSourceReferenceChangedOption(cfgoptsresource, idelemsresource, (SourceReferenceChanged) mutation, opt));
								storeOption(exercise, text, mode, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof TargetReferenceChanged) {
								text.add(getTargetReferenceChangedOption(cfgoptsresource, idelemsresource, (TargetReferenceChanged) mutation, opt));
								storeOption(exercise, text, mode, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
//							if (mutation instanceof ReferenceSwap) {
//							}
							if (mutation instanceof ReferenceCreated) {
								text.add(getReferenceCreatedOption(cfgoptsresource, idelemsresource, (ReferenceCreated) mutation, opt));
								storeOption(exercise, text, mode, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof ReferenceRemoved) {
								text.add(getReferenceRemovedOption(cfgoptsresource, idelemsresource, (ReferenceRemoved) mutation, opt));
								storeOption(exercise, text, mode, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof InformationChanged) {
								storeAttributeChangedOptions(exercise, cfgoptsresource, idelemsresource, (InformationChanged) mutation, opt, opts, mode);
								storeReferenceChangedOptions(exercise, cfgoptsresource, idelemsresource, (InformationChanged) mutation, opt, opts, mode);
							}
//							if (mutation instanceof ObjectRetyped) {
//							}
						}
					}
					if (mode == Mode.RADIOBUTTON) {
						if (opt.text != null && opt.text.size() > 0) {
							boolean isRepeated = subsumeRadio(opts, opt);
							if (isRepeated == false) {
								total.put(exercise, total.get(exercise) + 1);
								opts.add(opt);
							}
						}
					}
				}
				Collections.shuffle(opts);
				testOptions.put(test, opts);
			}
		}
	}

	/**
	 * Builds the options for the MultiChoiceEmendation
	 * @param resource
	 * @param exercise
	 * @param blocks
	 */
	private void buildMultiChoiceEmendation(Resource resource, MultiChoiceEmendation exercise, List<EObject> blocks, Class<?> cls) {
		try {
			Map<Test, Registry> dataReg = new HashMap<Test, Registry>();
			Bundle bundle = Platform.getBundle("wodel.models");
			String ecore = ModelManager.getMetaModel().replace("\\", "/");
			List<EPackage> packages = ModelManager.loadMetaModel(ecore, cls);
			URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
			String registryecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> registrypackages = ModelManager.loadMetaModel(registryecore);
			String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_modeltext.model");
			fileURL = bundle.getEntry("/models/ModelText.ecore");
			String idelemsecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> idelemspackages = ModelManager.loadMetaModel(idelemsecore);
			Resource idelemsresource = ModelManager.loadModel(idelemspackages, URI.createURI(xmiFileName).toFileString());
			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_mutatext.model");
			fileURL = bundle.getEntry("/models/MutaText.ecore");
			String cfgoptsecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> cfgoptspackages = ModelManager.loadMetaModel(cfgoptsecore);
			Resource cfgoptsresource = ModelManager.loadModel(cfgoptspackages, URI.createURI(xmiFileName).toFileString());
			for (Test test : exercise.getTests()) {
				dataReg.put(test, getRegistry((MultiChoiceEmendation) exercise, test, blocks, packages, registrypackages));
			}
			dataRegistry.put(exercise, dataReg);
			Map<Test, List<TestOption>> testOptions = new HashMap<Test, List<TestOption>>();
			for (Test test : exercise.getTests()) {
				if (dataRegistry.get(exercise).get(test).mutants.size() > 0) {
					int rnd = ModelManager.getRandomIndex(dataRegistry.get(exercise).get(test).mutants);
					TestOption opt = new TestOption();
					Registry reg = dataRegistry.get(exercise).get(test);
					String diagramPath = "";
					if (ModelManager.getOutputPath().indexOf(":") != -1) {
						diagramPath = reg.mutants.get(rnd).getKey().getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png");
					}
					else {
						diagramPath = reg.mutants.get(rnd).getKey().getURI().path().replace(ModelManager.getOutputPath(), "").replace(".model", ".png");
					}
					opt.path = "diagrams" + diagramPath;
					opt.resource = reg.history.get(rnd);
					opt.seed = reg.seed;
					opt.solution = true;
					List<TestOption> opts = new ArrayList<TestOption>();
					opts.add(opt);
					for (Registry wrongRegistry : dataRegistry.get(exercise).get(test).wrong.get(reg.mutants.get(rnd).getKey())) {
						if (wrongRegistry.mutants.size() > 0) {
							rnd = ModelManager.getRandomIndex(wrongRegistry.mutants);
							opt = new TestOption();
							opt.path = "diagrams" + wrongRegistry.mutants.get(rnd).getKey().getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png");
							opt.resource = wrongRegistry.history.get(rnd);
							opt.seed = wrongRegistry.seed;
							opt.solution = false;
							opts.add(opt);
						}
					}
					testOptions.put(test, opts);
				}
			}
			options.put(exercise, testOptions);
			buildOptionsMultiChoiceEmendation(cfgoptsresource, idelemsresource, exercise, testOptions, exercise.getConfig().getMode());
			options.put(exercise, testOptions);
		} catch (IOException e) {
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

	/**
	 * Builds the match pairs
	 * natural language options
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param exercise
	 * @param testOptions
	 * @param mode
	 */
	private void buildOptionsMatchPairs(Resource cfgoptsresource, Resource idelemsresource, MatchPairs exercise, Map<Test, List<TestOption>> testOptions) {
		for (Test test : exercise.getTests()) {
			List<TestOption> opts = new ArrayList<TestOption>();
			if (options.get(exercise).get(test) != null) {
				for (TestOption opt : options.get(exercise).get(test)) {
					opt.text = new HashMap<String, List<String>>();
					List<EObject> mutations = MutatorUtils.getMutations(ModelManager.getObjects(opt.resource));
					for (EObject mutation : mutations) {
						List<String> text = new ArrayList<String>();
						List<EClass> superTypes = mutation.eClass().getEAllSuperTypes();
						boolean flag = false;
						for (EClass cl : superTypes) {
							if (cl.getName().equals("AppMutation")) {
								flag = true;
								break;
							}
						}
						if (flag == true) {
							if (mutation instanceof ObjectCreated) {
								text.add(getObjectCreatedOption(cfgoptsresource, idelemsresource, (ObjectCreated) mutation, opt));
								storeOption(exercise, text, null, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof ObjectRemoved) {
								text.add(getObjectRemovedOption(cfgoptsresource, idelemsresource, (ObjectRemoved) mutation, opt));
								storeOption(exercise, text, null, opt, opts, EcoreUtil.getURI(mutation).toString());
							}							
							if (mutation instanceof SourceReferenceChanged) {
								text.add(getSourceReferenceChangedOption(cfgoptsresource, idelemsresource, (SourceReferenceChanged) mutation, opt));
								storeOption(exercise, text, null, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof TargetReferenceChanged) {
								text.add(getTargetReferenceChangedOption(cfgoptsresource, idelemsresource, (TargetReferenceChanged) mutation, opt));
								storeOption(exercise, text, null, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
//							if (mutation instanceof ReferenceSwap) {
//							}
							if (mutation instanceof ReferenceCreated) {
								text.add(getReferenceCreatedOption(cfgoptsresource, idelemsresource, (ReferenceCreated) mutation, opt));
								storeOption(exercise, text, null, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof ReferenceRemoved) {
								text.add(getReferenceRemovedOption(cfgoptsresource, idelemsresource, (ReferenceRemoved) mutation, opt));
								storeOption(exercise, text, null, opt, opts, EcoreUtil.getURI(mutation).toString());
							}
							if (mutation instanceof InformationChanged) {
								storeAttributeChangedOptions(exercise, cfgoptsresource, idelemsresource, (InformationChanged) mutation, opt, opts, null);
								storeReferenceChangedOptions(exercise, cfgoptsresource, idelemsresource, (InformationChanged) mutation, opt, opts, null);
							}
//							if (mutation instanceof ObjectRetyped) {
//							}
						}
					}
				}
				Collections.shuffle(opts);
				testOptions.put(test, opts);
			}
		}
	}

//	/**
//	 * Builds the options for the MultiChoiceEmendation
//	 * @param resource
//	 * @param exercise
//	 * @param blocks
//	 */
//	private void buildMatchPairs(Resource resource, MatchPairs exercise, List<EObject> blocks, Class<?> cls) {
//		try {
//			Map<Test, Registry> dataReg = new HashMap<Test, Registry>();
//			Bundle bundle = Platform.getBundle("wodel.models");
//			String ecore = ModelManager.getMetaModel().replace("\\", "/");
//			List<EPackage> packages = ModelManager.loadMetaModel(ecore, cls);
//			URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
//			String registryecore = FileLocator.resolve(fileURL).getFile();
//			List<EPackage> registrypackages = ModelManager.loadMetaModel(registryecore);
//			String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() +
//					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_modeltext.model");
//			fileURL = bundle.getEntry("/models/ModelText.ecore");
//			String idelemsecore = FileLocator.resolve(fileURL).getFile();
//			List<EPackage> idelemspackages = ModelManager.loadMetaModel(idelemsecore);
//			Resource idelemsresource = ModelManager.loadModel(idelemspackages, URI.createURI(xmiFileName).toFileString());
//			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() +
//					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_mutatext.model");
//			fileURL = bundle.getEntry("/models/MutaText.ecore");
//			String cfgoptsecore = FileLocator.resolve(fileURL).getFile();
//			List<EPackage> cfgoptspackages = ModelManager.loadMetaModel(cfgoptsecore);
//			Resource cfgoptsresource = ModelManager.loadModel(cfgoptspackages, URI.createURI(xmiFileName).toFileString());
//			Map<Test, List<TestOption>> testOptions = new HashMap<Test, List<TestOption>>();
//			for (Test test : exercise.getTests()) {
//				dataReg.put(test, getRegistry((MatchPairs) exercise, test, blocks, packages, registrypackages));
//			}
//			for (Test test : dataReg.keySet()) {
//				Registry reg = dataReg.get(test);
//				if (reg.mutants.size() == 0) {
//					options.put(exercise, testOptions);
//					return;
//				}
//				for (SimpleEntry<Resource, Resource> mut : reg.mutants) {
//					System.out.println(mut.getKey().getURI());
//				}
//				for (Resource hist : reg.history) {
//					System.out.println(hist.getURI());
//				}
//			}
//			int longestMutantPath = Integer.MIN_VALUE;
//			int longestHistoryPath = Integer.MIN_VALUE;
//			for (Test test : dataReg.keySet()) {
//				Registry reg = dataReg.get(test);
//				for (SimpleEntry<Resource, Resource> mut : reg.mutants) {
//					if (mut.getKey().getURI().toFileString().length() > longestMutantPath) {
//						longestMutantPath = mut.getKey().getURI().toFileString().length();
//					}
//				}
//				for (Resource hist : reg.history) {
//					if (hist.getURI().toFileString().length() > longestHistoryPath) {
//						longestHistoryPath = hist.getURI().toFileString().length();
//					}
//				}
//			}
//			Map<Test, Registry> selectedDataReg = new HashMap<Test, Registry>();
//			for (Test test : dataReg.keySet()) {
//				Registry reg = dataReg.get(test);
//				Registry newReg = new Registry();
//				newReg.seed = reg.seed; 
//				newReg.mutants = new ArrayList<SimpleEntry<Resource, Resource>>();
//				newReg.history = new ArrayList<Resource>();
//				for (SimpleEntry<Resource, Resource> mut : reg.mutants) {
//					if (mut.getKey().getURI().toFileString().length() == longestMutantPath) {
//						newReg.mutants.add(new SimpleEntry<Resource, Resource>(mut.getKey(), null));
//					}
//				}
//				for (Resource hist : reg.history) {
//					if (hist.getURI().toFileString().length() == longestHistoryPath) {
//						newReg.history.add(hist);
//					}
//				}
//				selectedDataReg.put(test, newReg);
//			}
//			for (Test test : selectedDataReg.keySet()) {
//				Registry reg = selectedDataReg.get(test);
//				System.out.println(reg.seed.getURI());
//				for (SimpleEntry<Resource, Resource> mut : reg.mutants) {
//					System.out.println(mut.getKey().getURI());
//				}
//				for (Resource st : reg.history) {
//					System.out.println(st.getURI());
//				}
//			}
//			Map<Test, Registry> exerciseDataReg = new HashMap<Test, Registry>();
//			for (Test test : selectedDataReg.keySet()) {
//				Registry reg = selectedDataReg.get(test);
//				Registry newReg = new Registry();
//				newReg.seed = reg.seed;
//				System.out.println(reg.seed.getURI());
//				newReg.mutants = new ArrayList<SimpleEntry<Resource, Resource>>();
//				newReg.history = new ArrayList<Resource>();
//				int rnd = ModelManager.getRandomIndex(reg.mutants);
//				newReg.mutants.add(reg.mutants.get(rnd));
//				newReg.history.add(reg.history.get(rnd));
//				System.out.println(newReg.mutants.get(0).getKey().getURI());
//				System.out.println(newReg.history.get(0).getURI());
//				exerciseDataReg.put(test, newReg);
//			}
//			for (Test test : dataReg.keySet()) {
//				Registry reg = dataReg.get(test);
//				Registry newReg = exerciseDataReg.get(test);
//				String ex = reg.seed.getURI().toString().substring(reg.seed.getURI().toString().lastIndexOf("/") + 1, reg.seed.getURI().toString().length());
//				System.out.println(ex);
//				Resource mutant = newReg.mutants.get(0).getKey();
//				List<String> bks = new ArrayList<String>();
//				List<String> muts = new ArrayList<String>();
//				String path = mutant.getURI().toString().substring(mutant.getURI().toString().lastIndexOf(ex.substring(0, ex.indexOf("."))) + ex.substring(0, ex.indexOf(".")).length(), mutant.getURI().toString().length());
//				while (path.charAt(0) == '/') {
//					path = path.substring(1, path.length());
//				}
//				String[] bckNames = path.split("/");
//				for (String bckName : bckNames) {
//					if (!bckName.endsWith(".model") && !bckName.startsWith("Output") && !bckName.equals("")) {
//						bks.add(bckName.trim());
//					}
//					if (bckName.startsWith("Output") && !bckName.endsWith(".model")) {
//						muts.add(bckName.trim());
//					}
//					if (bckName.startsWith("Output") && bckName.endsWith(".model")) {
//						muts.add(bckName.substring(0, bckName.indexOf(".")).trim());
//					}
//				}
//				int j = 0;
//				while (true) {
//					int i = j + 1;
//					String previous = "";
//					for (; i < bks.size(); i++) {
//						previous += "/" + bks.get(i);
//					}
//					System.out.println(previous);
//					for (int k = 0; k < bks.size() - (j + 1); k++) {
//						previous += "/" + muts.get(k);
//					}
//					if (previous.length() == 0) {
//						break;
//					}
//					previous += ".model";
//					System.out.println(previous);
//					int index = -1;
//					i = 0;
//					for (SimpleEntry<Resource, Resource> mut : reg.mutants) {
//						if (mut.getKey().getURI().toString().replaceAll("//", "/").replaceAll("//", "/").contains(previous) && !mut.getKey().getURI().toString().replaceAll("//", "/").replaceAll("//", "/").equals(newReg.mutants.get(j).getKey().getURI().toString().replaceAll("//", "/").replaceAll("//", "/"))) {
//							index = i;
//						}
//						System.out.println(mut.getKey().getURI());
//						i++;
//					}
//					if (index != -1) {
//						newReg.mutants.add(reg.mutants.get(index));
//						newReg.history.add(reg.history.get(index));
//					}
//					else {
//						break;
//					}
//					j++;
//				}
//			}
//			Map<Test, List<Integer>> orderedTestMap = new HashMap<Test, List<Integer>>();
//			for (Test test : exerciseDataReg.keySet()) {
//				List<Integer> orderedList = new ArrayList<Integer>();
//				Registry reg = exerciseDataReg.get(test);
//				while (orderedList.size() < reg.mutants.size()) {
//					int min = Integer.MAX_VALUE;
//					int index = -1;
//					for (int i = 0; i < reg.mutants.size(); i++) {
//						if (!orderedList.contains(i) && reg.mutants.get(i).getKey().getURI().toFileString().length() < min) {
//							min = reg.mutants.get(i).getKey().getURI().toFileString().length();
//							index = i;
//						}
//					}
//					if (index != -1) {
//						orderedList.add(index);
//					}
//					else {
//						break;
//					}
//				}
//				orderedTestMap.put(test, orderedList);
//			}
//			for (Test test : exerciseDataReg.keySet()) {
//				List<Integer> orderedList = orderedTestMap.get(test);
//				Registry reg = exerciseDataReg.get(test);
//				SimpleEntry<Resource, Resource> entry = reg.mutants.get(orderedList.get(0));
//				entry.setValue(reg.seed);
//				for (int i = 1; i < orderedList.size(); i++) {
//					entry = reg.mutants.get(orderedList.get(i));
//					entry.setValue(reg.mutants.get(orderedList.get(i - 1)).getKey());
//				}
//			}
//			for (Test test : exerciseDataReg.keySet()) {
//				Registry reg = exerciseDataReg.get(test);
//				System.out.println(reg.seed.getURI());
//				for (SimpleEntry<Resource, Resource> mut : reg.mutants) { 
//					System.out.println(mut.getKey().getURI());
//					System.out.println(mut.getValue().getURI());
//				}
//				for (SimpleEntry<Resource, Resource> pre : reg.mutants) { 
//					System.out.println(pre.getValue().getURI());
//				}
//				for (Resource hist : reg.history) {
//					System.out.println(hist.getURI());
//				}
//			}
//			dataRegistry.put(exercise, exerciseDataReg);
//			List<String> coveredBlocks = new ArrayList<String>();
//			for (Test test : exercise.getTests()) {
//				List<TestOption> opts = new ArrayList<TestOption>();
//				if (dataRegistry.get(exercise).get(test).mutants.size() > 0) {
//					for (int i = 0; i < dataRegistry.get(exercise).get(test).mutants.size(); i++) {
//						Registry reg = dataRegistry.get(exercise).get(test);
//						boolean covered = false;
//						List<Integer> indexes = new ArrayList<Integer>();
//						for (int j = 0; j < reg.mutants.size(); j++) {
//							indexes.add(j);
//						}
//						int k = i;
//						while (covered == false && indexes.size() > 0) {
//							for (EObject block : exercise.getBlocks()) {
//								String name = ModelManager.getStringAttribute("name", block);
//								if (reg.mutants.get(k).getKey().getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").contains("/" + name + "/") && !coveredBlocks.contains(name)) {
//									coveredBlocks.add(name);
//									covered = true;
//									break;
//								}
//								else if (coveredBlocks.size() == exercise.getBlocks().size()) {
//									covered = true;
//									break;
//								}
//								else {
//									indexes.remove(Integer.valueOf(k));
//									if (indexes.size() > 0) {
//										int index = ModelManager.getRandomIndex(indexes);
//										k = indexes.get(index);
//									}
//								}
//							}
//							String diagramPath = "";
//							if (ModelManager.getOutputPath().indexOf(":") != -1) {
//								diagramPath = reg.mutants.get(i).getKey().getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png");
//							}
//							else {
//								diagramPath = reg.mutants.get(i).getKey().getURI().path().replace(ModelManager.getOutputPath(), "").replace(".model", ".png");
//							}
//							TestOption opt = new TestOption();
//							opt.path = "diagrams" + diagramPath;
//							opt.resource = reg.history.get(i);
//							opt.seed = reg.mutants.get(i).getValue();
//							opt.mutant = reg.mutants.get(i).getKey();
//							opt.solution = true;
//							opts.add(opt);
////							for (Registry wrongRegistry : dataRegistry.get(exercise).get(test).wrong.get(reg.mutants.get(k))) {
////								if (wrongRegistry.mutants.size() > 0) {
////									k = ModelManager.getRandomIndex(wrongRegistry.mutants);
////									opt = new TestOption();
////									opt.path = "diagrams" + wrongRegistry.mutants.get(k).getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png");
////									opt.resource = wrongRegistry.history.get(k);
////									opt.seed = wrongRegistry.seed;
////									opt.solution = false;
////									opts.add(opt);
////								}
////							}
//						}
//					}
//					testOptions.put(test, opts);
//				}
//			}
//			options.put(exercise, testOptions);
//			buildOptionsMatchPairs(cfgoptsresource, idelemsresource, exercise, testOptions);
//			for (Test test : testOptions.keySet()) {
//				List<TestOption> finalTestOptions = new ArrayList<TestOption>();
//				for (TestOption testOption : testOptions.get(test)) {
//					boolean found = false;
//					for (TestOption finalTestOption : finalTestOptions) {
//						if (testOption.text.equals(finalTestOption.text)) {
//							found = true;
//							break;
//						}
//					}
//					if (found == false) {
//						finalTestOptions.add(testOption);
//					}
//				}
//				testOptions.put(test, finalTestOptions);
//			}
//			for (Test test : testOptions.keySet()) {
//				for (TestOption testOption : testOptions.get(test)) {
//					String previousBlock = testOption.mutant.getURI().path();
//					previousBlock = previousBlock.substring(previousBlock.indexOf("/" + test.getSource().replace(".model", "") + "/") + ("/" + test.getSource().replace(".model", "") + "/").length(), previousBlock.length());
//					while (previousBlock.indexOf("/") == 0) {
//						previousBlock = previousBlock.substring(1, previousBlock.length());
//					}
//					previousBlock = previousBlock.substring(0, previousBlock.indexOf("/"));
//					String reversePath = testOption.mutant.getURI().path();
//					reversePath = reversePath.replace(".model", "/" + previousBlock + "/Reverse.model");
//					System.out.println(reversePath);
//					reversePath = ModelManager.getOutputPath() + "/" + reversePath.substring(reversePath.indexOf("/" + test.getSource().replace(".model", "") + "/"), reversePath.length());
//					File check = new File(reversePath);
//					System.out.println(reversePath);
//					if (check.exists()) {
//						testOption.reverse = new ArrayList<SimpleEntry<Resource, Map<String, List<String>>>>();
//						testOption.reverse.add(new SimpleEntry<Resource, Map<String, List<String>>>(ModelManager.loadModel(packages, reversePath), testOption.text));
//						SimpleEntry<Resource, Resource> previous = new SimpleEntry<Resource, Resource>(testOption.mutant, testOption.seed);
//						while (previous != null) {
//							boolean found = false;
//							for (TestOption op : testOptions.get(test)) {
//								if (op.mutant.getURI().equals(previous.getValue().getURI())) {
//									previous = new SimpleEntry<Resource, Resource>(op.mutant, op.seed);
//									found = true;
//									previousBlock = previous.getKey().getURI().path();
//									previousBlock = previousBlock.substring(previousBlock.indexOf("/" + test.getSource().replace(".model", "") + "/") + ("/" + test.getSource().replace(".model", "") + "/").length(), previousBlock.length());
//									while (previousBlock.indexOf("/") == 0) {
//										previousBlock = previousBlock.substring(1, previousBlock.length());
//									}
//									previousBlock = previousBlock.substring(0, previousBlock.indexOf("/"));
//									reversePath = testOption.mutant.getURI().path();
//									reversePath = reversePath.replace(".model", "/" + previousBlock + "/Reverse.model");
//									System.out.println(reversePath);
//									reversePath = ModelManager.getOutputPath() + "/" + reversePath.substring(reversePath.indexOf("/" + test.getSource().replace(".model", "") + "/"), reversePath.length());
//									check = new File(reversePath);
//									System.out.println(reversePath);
//									testOption.reverse.add(new SimpleEntry<Resource, Map<String, List<String>>>(ModelManager.loadModel(packages, reversePath), op.text));
//									break;
//								}
//							}
//							if (found == false) {
//								previous = null;
//								break;
//							}
//						}
//					}
//				}
//			}
//			options.put(exercise, testOptions);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (MetaModelNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ModelNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * Builds the options for the MultiChoiceEmendation
	 * @param resource
	 * @param exercise
	 * @param blocks
	 */
	private void buildMatchPairs(Resource resource, MatchPairs exercise, List<EObject> blocks, Class<?> cls) {
		try {
			Map<Test, Registry> dataReg = new HashMap<Test, Registry>();
			Bundle bundle = Platform.getBundle("wodel.models");
			String ecore = ModelManager.getMetaModel().replace("\\", "/");
			List<EPackage> packages = ModelManager.loadMetaModel(ecore, cls);
			URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
			String registryecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> registrypackages = ModelManager.loadMetaModel(registryecore);
			String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_modeltext.model");
			fileURL = bundle.getEntry("/models/ModelText.ecore");
			String idelemsecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> idelemspackages = ModelManager.loadMetaModel(idelemsecore);
			Resource idelemsresource = ModelManager.loadModel(idelemspackages, URI.createURI(xmiFileName).toFileString());
			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_mutatext.model");
			fileURL = bundle.getEntry("/models/MutaText.ecore");
			String cfgoptsecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> cfgoptspackages = ModelManager.loadMetaModel(cfgoptsecore);
			Resource cfgoptsresource = ModelManager.loadModel(cfgoptspackages, URI.createURI(xmiFileName).toFileString());
			Map<Test, List<TestOption>> testOptions = new HashMap<Test, List<TestOption>>();
			for (Test test : exercise.getTests()) {
				dataReg.put(test, getRegistry((MatchPairs) exercise, test, blocks, packages, registrypackages));
			}
			dataRegistry.put(exercise, dataReg);
			List<String> coveredBlocks = new ArrayList<String>();
			for (Test test : exercise.getTests()) {
				List<TestOption> opts = new ArrayList<TestOption>();
				if (dataRegistry.get(exercise).get(test).mutants.size() > 0) {
					for (int i = 0; i < dataRegistry.get(exercise).get(test).mutants.size(); i++) {
						Registry reg = dataRegistry.get(exercise).get(test);
						boolean covered = false;
						List<Integer> indexes = new ArrayList<Integer>();
						for (int j = 0; j < reg.mutants.size(); j++) {
							indexes.add(j);
						}
						int k = i;
						while (covered == false && indexes.size() > 0) {
							for (EObject block : exercise.getBlocks()) {
								String name = ModelManager.getStringAttribute("name", block);
								if (reg.mutants.get(k).getKey().getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").contains("/" + name + "/") && !coveredBlocks.contains(name)) {
									coveredBlocks.add(name);
									covered = true;
									break;
								}
								else if (coveredBlocks.size() == exercise.getBlocks().size()) {
									covered = true;
									break;
								}
								else {
									indexes.remove(Integer.valueOf(k));
									if (indexes.size() > 0) {
										int index = ModelManager.getRandomIndex(indexes);
										k = indexes.get(index);
									}
								}
							}
							String diagramPath = "";
							if (ModelManager.getOutputPath().indexOf(":") != -1) {
								diagramPath = reg.seed.getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png").replaceAll("\\\\", "/");
							}
							else {
								diagramPath = reg.seed.getURI().path().replace(ModelManager.getOutputPath(), "").replace(".model", ".png").replaceAll("\\\\", "/");
							}
							diagramPath = diagramPath.substring(diagramPath.lastIndexOf("/") + 1, diagramPath.length());
							diagramPath = "diagrams/" + diagramPath.replace(".png", "") + "/" + diagramPath;
							TestOption opt = new TestOption();
							opt.path = diagramPath;
							opt.resource = reg.history.get(k);
							opt.seed = reg.seed;
							opt.entry = reg.mutants.get(k);
							opt.solution = false;
							opts.add(opt);
						}
					}
					testOptions.put(test, opts);
				}
			}
			options.put(exercise, testOptions);
			buildOptionsMatchPairs(cfgoptsresource, idelemsresource, exercise, testOptions);
			options.put(exercise, testOptions);
		} catch (IOException e) {
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

	
	/**
	 * Builds the match pairs
	 * natural language options
	 * @param cfgoptsresource
	 * @param idelemsresource
	 * @param exercise
	 * @param testOptions
	 * @param mode
	 */
	private void buildOptionsMissingWords(Resource cfgoptsresource, Resource idelemsresource, MissingWords exercise, Map<Test, List<TestOption>> testOptions) {
		for (Test test : exercise.getTests()) {
			List<TestOption> opts = new ArrayList<TestOption>();
			if (options.get(exercise).get(test) != null) {
				for (TestOption opt : options.get(exercise).get(test)) {
					opt.options = new TreeMap<String, List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>>>();
					opt.text = new TreeMap<String, List<String>>();
					List<EObject> mutations = MutatorUtils.getMutations(ModelManager.getObjects(opt.resource));
					int[] index = new int[1];
					index[0] = 0;
					for (EObject mutation : mutations) {
						List<String> text = new ArrayList<String>();
						List<EClass> superTypes = mutation.eClass().getEAllSuperTypes();
						boolean flag = false;
						for (EClass cl : superTypes) {
							if (cl.getName().equals("AppMutation")) {
								flag = true;
								break;
							}
						}
						if (flag == true) {
							String[] mutationURI = new String[1];
							if (mutation instanceof ObjectCreated) {
								text = getObjectCreatedText(cfgoptsresource, idelemsresource, (ObjectCreated) mutation, opt, mutationURI, index);
								storeOption(exercise, text, null, opt, opts, mutationURI[0]);
							}
							if (mutation instanceof ObjectRemoved) {
								text = getObjectRemovedText(cfgoptsresource, idelemsresource, (ObjectRemoved) mutation, opt, mutationURI, index);
								storeOption(exercise, text, null, opt, opts, mutationURI[0]);
							}							
							if (mutation instanceof SourceReferenceChanged) {
								text = getSourceReferenceChangedText(cfgoptsresource, idelemsresource, (SourceReferenceChanged) mutation, opt, mutationURI, index);
								storeOption(exercise, text, null, opt, opts, mutationURI[0]);
							}
							if (mutation instanceof TargetReferenceChanged) {
								text = getTargetReferenceChangedText(cfgoptsresource, idelemsresource, (TargetReferenceChanged) mutation, opt, mutationURI, index);
								storeOption(exercise, text, null, opt, opts, mutationURI[0]);
							}
//							if (mutation instanceof ReferenceSwap) {
//							}
							if (mutation instanceof ReferenceCreated) {
								text = getReferenceCreatedText(cfgoptsresource, idelemsresource, (ReferenceCreated) mutation, opt, mutationURI, index);
								storeOption(exercise, text, null, opt, opts, mutationURI[0]);
							}
							if (mutation instanceof ReferenceRemoved) {
								text = getReferenceRemovedText(cfgoptsresource, idelemsresource, (ReferenceRemoved) mutation, opt, mutationURI, index);
								storeOption(exercise, text, null, opt, opts, mutationURI[0]);
							}
							if (mutation instanceof InformationChanged) {
								storeAttributeChangedText(exercise, cfgoptsresource, idelemsresource, (InformationChanged) mutation, opt, opts, null, mutationURI, index);
								storeReferenceChangedText(exercise, cfgoptsresource, idelemsresource, (InformationChanged) mutation, opt, opts, null, mutationURI, index);
							}
//							if (mutation instanceof ObjectRetyped) {
//							}
						}
					}
				}
			}
			Collections.shuffle(opts);
			testOptions.put(test, opts);
		}
	}

	/**
	 * Builds the options for the MultiChoiceEmendation
	 * @param resource
	 * @param exercise
	 * @param blocks
	 */
	private void buildMissingWords(Resource resource, MissingWords exercise, List<EObject> blocks, Class<?> cls) {
		try {
			Map<Test, Registry> dataReg = new HashMap<Test, Registry>();
			Bundle bundle = Platform.getBundle("wodel.models");
			String ecore = ModelManager.getMetaModel().replace("\\", "/");
			List<EPackage> packages = ModelManager.loadMetaModel(ecore, cls);
			URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
			String registryecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> registrypackages = ModelManager.loadMetaModel(registryecore);
			String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_modeltext.model");
			fileURL = bundle.getEntry("/models/ModelText.ecore");
			String idelemsecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> idelemspackages = ModelManager.loadMetaModel(idelemsecore);
			Resource idelemsresource = ModelManager.loadModel(idelemspackages, URI.createURI(xmiFileName).toFileString());
			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_mutatext.model");
			fileURL = bundle.getEntry("/models/MutaText.ecore");
			String cfgoptsecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> cfgoptspackages = ModelManager.loadMetaModel(cfgoptsecore);
			Resource cfgoptsresource = ModelManager.loadModel(cfgoptspackages, URI.createURI(xmiFileName).toFileString());
			for (Test test : exercise.getTests()) {
				dataReg.put(test, getRegistry((MissingWords) exercise, test, blocks, packages, registrypackages));
			}
			dataRegistry.put(exercise, dataReg);
			Map<Test, List<TestOption>> testOptions = new HashMap<Test, List<TestOption>>();
			for (Test test : exercise.getTests()) {
				if (dataRegistry.get(exercise).get(test).mutants.size() > 0) {
					List<TestOption> opts = new ArrayList<TestOption>();
					for (int k = 0; k < dataRegistry.get(exercise).get(test).mutants.size(); k++) {
						TestOption opt = new TestOption();
						Registry reg = dataRegistry.get(exercise).get(test);
						String diagramPath = "";
						if (ModelManager.getOutputPath().indexOf(":") != -1) {
							diagramPath = reg.mutants.get(k).getKey().getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png");
						}
						else {
							diagramPath = reg.mutants.get(k).getKey().getURI().path().replace(ModelManager.getOutputPath(), "").replace(".model", ".png");
						}
						opt.path = "diagrams" + diagramPath;
						opt.resource = reg.history.get(k);
						opt.seed = reg.seed;
						opt.solution = true;
						opts.add(opt);
					}
					testOptions.put(test, opts);
				}
			}
			options.put(exercise, testOptions);
			buildOptionsMissingWords(cfgoptsresource, idelemsresource, exercise, testOptions);
	        for (Test test : exercise.getTests()) {
		        String textWithGaps = "";
				int k = 0;
				int solution = 0;
	        	for (TestOption opt : options.get(exercise).get(test)) {
	        		for (String key : opt.options.keySet()) {
        				String opWithGaps = "";
        				int tmp = k;
	        			for (String text : opt.text.get(key)) {
	        				k++;
	        				opWithGaps += text + "%" + k+ " ";
	        			}
	        			k = tmp;
	        			List<SimpleEntry<String, SimpleEntry<Integer, Boolean>>> entries = opt.options.get(key);
	        			for (SimpleEntry<String, SimpleEntry<Integer, Boolean>> entry : entries) {
	        				solution++;
	        				if (entry.getValue().getValue() == true) {
	        					k++;
	        					opWithGaps = opWithGaps.replace("%" + k, "[[" + solution + "]]");
	        				}
	        			}
	    	        	textWithGaps += opWithGaps.trim() + ". ";
	        		}
	        	}
	        }
			options.put(exercise, testOptions);
		} catch (IOException e) {
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

	
	/**
	 * Generates the options for the test exercises application
	 * @param program
	 * @param resource
	 * @return
	 */
	protected void buildOptions(Program program, Resource resource, List<EObject> blocks, Class<?> cls) {
		for (MutatorTests exercise : program.getExercises()) {
			total.put(exercise, 0);
			Map<Test, List<String>> diags = new HashMap<Test, List<String>>();
			if (exercise instanceof AlternativeResponse || exercise instanceof MultiChoiceDiagram) {
				buildAlternativeResponseOrMultiChoiceDiagram(exercise, diags);
			}
			if (exercise instanceof MultiChoiceEmendation) {
				buildMultiChoiceEmendation(resource, (MultiChoiceEmendation) exercise, blocks, cls);
			}
			if (exercise instanceof MatchPairs) {
				buildMatchPairs(resource, (MatchPairs) exercise, blocks, cls);
			}
			if (exercise instanceof MissingWords) {
				buildMissingWords(resource, (MissingWords) exercise, blocks, cls);
			}
		}
	}
	
	protected String getStringBase64(String fileName) {
		String base64 = "";
		File file = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + project.getName() + "/src-gen/html/" + fileName);
		try {
			byte[] bytes = Base64.getEncoder().withoutPadding().encode(Files.readAllBytes(file.toPath()));
			base64 = new String(bytes, StandardCharsets.UTF_8);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return base64;
	}
	
	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// TODO Auto-generated method stub
	}
}
