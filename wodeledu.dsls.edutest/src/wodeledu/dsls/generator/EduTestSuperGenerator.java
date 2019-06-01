package wodeledu.dsls.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.FileLocator;
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
import manager.WodelContext;
import modeltext.Element;
import mutatext.Constant;
import mutatext.Option;
import mutatext.Text;
import mutatext.Variable;
import mutatext.VariableType;
import mutatext.Word;
import mutatorenvironment.Block;

public class EduTestSuperGenerator extends AbstractGenerator {

	protected Map<MutatorTests, List<Test>> tests = new HashMap<MutatorTests, List<Test>>();
	protected Map<MutatorTests, Map<Test, List<String>>> diagrams = new HashMap<MutatorTests, Map<Test, List<String>>>();
	protected Map<MutatorTests, Map<Test, List<String>>> rand = new HashMap<MutatorTests, Map<Test, List<String>>>();
	protected Map<MutatorTests, Map<Test, Registry>> dataRegistry = new HashMap<MutatorTests, Map<Test, Registry>>();
	protected Map<MutatorTests, Map<Test, Double>> puntuation = new HashMap<MutatorTests, Map<Test, Double>>();
	protected Map<MutatorTests, Map<Test, Double>> penalty = new HashMap<MutatorTests, Map<Test, Double>>();
	protected Map<MutatorTests, Integer> total = new HashMap<MutatorTests, Integer>();
	protected Map<MutatorTests, Map<Test, List<TestOption>>> options = new HashMap<MutatorTests, Map<Test, List<TestOption>>>();

	private class Registry {
		public Resource seed;
		public List<Resource> mutants;
		public List<Resource> history;
		public Map<Resource, List<Registry>> wrong;
	}

	protected class TestOption implements Cloneable {
		public String path;
		public Resource resource;
		public Resource seed;
		public ArrayList<String> text;
		public boolean solution;
		public int total;
		
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
	private Registry getRegistry(MultiChoiceEmendation exercise, Test test, List<EObject> blocks, List<EPackage> packages, List<EPackage> registrypackages) throws ModelNotFoundException {
		Registry registry = new Registry();
		File outFolder = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", ""));
		String modelPath = ModelManager.getModelsFolder() + '/' + test.getSource();
		registry.seed = ModelManager.loadModel(packages, modelPath);
		registry.mutants = new ArrayList<Resource>();
		registry.history = new ArrayList<Resource>();
		registry.wrong = new HashMap<Resource, List<Registry>>();
		if (outFolder.isDirectory() == true) {
			if (exercise.getBlock() != null) {
				for (File f : outFolder.listFiles()) {
					if (f.isFile() == true) {
						if (f.getName().endsWith(".model")) {
							registry.mutants.add(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + f.getName()));
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
						if (f.getName().equals(exercise.getBlock().getName())) {
							for (File s : f.listFiles()) {
								if (s.isFile() == true) {
									if (s.getName().endsWith(".model")) {
										registry.mutants.add(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + exercise.getBlock().getName() +'/' + s.getName()));
										for (File r : f.listFiles()) {
											if (r.getName().equals("registry")) {
												for (File reg : r.listFiles()) {
													if (reg.getName().endsWith(".model")) {
														if (reg.getName().startsWith(s.getName().replace(".model", ""))) {
															registry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + exercise.getBlock().getName() + "/registry/" + reg.getName()));

														}
													}
												}
											}
										}
										if (registry.wrong.get(registry.mutants.get(registry.mutants.size() - 1)) == null) {
											registry.wrong.put(registry.mutants.get(registry.mutants.size()- 1), new ArrayList<Registry>());
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
												for (EObject block : from) {
													String blockName = "";
													for (EAttribute att : block.eClass().getEAllAttributes()) {
														if (att.getName().equals("name")) {
															blockName = (String) block.eGet(att);
															break;
														}
													}
													if (blockName.equals(exercise.getBlock().getName())) {
														Registry wrongRegistry = new Registry();
														wrongRegistry.seed = ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + exercise.getBlock().getName() +'/' + s.getName());
														wrongRegistry.mutants = new ArrayList<Resource>();
														wrongRegistry.history = new ArrayList<Resource>();
														File wrongOutFolder = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + "/" + name + '/' +  exercise.getBlock().getName());
														if (wrongOutFolder.isDirectory() == true) {
															for (File wf : wrongOutFolder.listFiles()) {
																if (wf.getName().equals(s.getName().replace(".model", ""))) {
																	for (File w : wf.listFiles()) {
																		if (w.isFile() == true) {
																			if (w.getName().endsWith(".model")) {
																				wrongRegistry.mutants.add(ModelManager.loadModel(packages, ModelManager.getOutputPath() + '/'  + test.getSource().replace(".model", "") + '/' + name + '/' + exercise.getBlock().getName() +'/' + s.getName().replace(".model", "") + '/' + w.getName()));
																				for (File r : wf.listFiles()) {
																					if (r.isDirectory() == true) {
																						if (r.getName().equals("registry")) {
																							for (File reg : r.listFiles()) {
																								if (reg.getName().endsWith(".model")) {
																									wrongRegistry.history.add(ModelManager.loadModel(registrypackages, ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", "") + '/' + name + '/' + exercise.getBlock().getName() + '/' + s.getName().replace(".model", "") + "/registry/" + reg.getName()));
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
														registry.wrong.get(registry.mutants.get(registry.mutants.size() - 1)).add(wrongRegistry);
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
		}

		return registry;
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
			textOptions.addAll(optCheck.text);
			int equals = 0;
			for (String text : optCheck.text) {
				for (String newText : opt.text) {
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
		return false;
	}

	/**
	 * If check box option is already in the list
	 * @param testOptions
	 * @param opt
	 * @return
	 */
	private boolean subsumeCheckbox(List<TestOption> testOptions, TestOption opt) {
		for (TestOption optCheck : testOptions) {
			if (optCheck.text.size() > 0) {
				String textOption = optCheck.text.get(0);
				String newText = opt.text.get(0);
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
			File folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/diagrams/" + test.getSource().replace(".model", ""));
			List<String> fileNames = new ArrayList<String>();
			if (folder.isDirectory() == true) {
				for (File f : folder.listFiles()) {
					if (f.getName().endsWith(".png")) {
						fileNames.add(f.getName());
					}
				}
			}
			if (exercise.getBlock() != null) {
				folder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/diagrams/" + test.getSource().replace(".model", "") + "/" + exercise.getBlock().getName());
				if (folder.isDirectory() == true) {
					for (File f : folder.listFiles()) {
						if (f.getName().endsWith(".png")) {
							fileNames.add(exercise.getBlock().getName() + "/" + f.getName());
						}
					}
				}
				if (exercise.getBlock().getFrom().size() > 0) {
					for (Block b : exercise.getBlock().getFrom()) {
						File wrongFolder = new File(ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() + "/src-gen/html/diagrams/" + test.getSource().replace(".model", "") + "/" + b.getName() + "/" + exercise.getBlock().getName());
						if (wrongFolder.isDirectory() == true) {
							for (File f : wrongFolder.listFiles()) {
								for (File w : f.listFiles()) {
									if (w.getName().endsWith(".png")) {
										fileNames.add(b.getName() + "/" + exercise.getBlock().getName() + "/" + f.getName() + "/" + w.getName());
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
	private void storeMultiChoiceEmendationOption(MultiChoiceEmendation exercise, String text, Mode mode, TestOption opt, List<TestOption> opts) {
		try {
			if (mode == Mode.RADIOBUTTON) {
				if (opt.text.contains(text) != true) {
					opt.text.add(text);
				}
			}
			if (mode == Mode.CHECKBOX) {
				opt.text = new ArrayList<String>();
				opt.text.add(text);
				TestOption optClone = (TestOption) opt.clone();
				boolean isRepeated = subsumeCheckbox(opts, optClone);
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
	private void storeMultiChoiceEmendationOptionList(MultiChoiceEmendation exercise, String text, List<String> list, Mode mode, TestOption opt, List<TestOption> opts) {
		try {
			if (mode == Mode.RADIOBUTTON) { 
				if (text.length() > 0 && list.contains(text) != true) {
					list.add(text);
				}
			}
			if (mode == Mode.CHECKBOX) {
				opt.text = new ArrayList<String>();
				opt.text.add(text);
				TestOption optClone = (TestOption) opt.clone();
				boolean isRepeated = subsumeCheckbox(opts, optClone);
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
	private void storeAttributeChangedOptions(MultiChoiceEmendation exercise, Resource cfgoptsresource, Resource idelemsresource, InformationChanged informationChanged, TestOption opt, List<TestOption> opts, Mode mode) {
		List<AttributeChanged> attChanges = informationChanged.getAttChanges();
		EObject object = ModelManager.getEObject(informationChanged.getObject(), opt.seed);
		List<String> attributes = new ArrayList<String>();
		for (AttributeChanged att : attChanges) {
			String text = "";
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
						text += ((Constant) w).getValue() + " ";
					}
					if (w instanceof Variable) {
						Variable variable = (Variable) w;
						if (variable.getType() == VariableType.FIRST_OBJECT) {
							for (modeltext.Word v : firstElement.getWords()) {
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
						if (variable.getType() == VariableType.SECOND_OBJECT) {
							for (modeltext.Word v : secondElement.getWords()) {
								if (v instanceof modeltext.Constant) {
									text += ((modeltext.Constant) v).getValue() + " ";
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
										text +=  o.eGet(ModelManager.getAttributeByName(((modeltext.Variable) v).getId().getName(), o)) + " ";
									}
								}
							}
						}
						if (variable.getType() == VariableType.FIRST_ATT_NAME) {
							text += attName + " ";
						}
						if (variable.getType() == VariableType.SECOND_ATT_NAME) {
							text += firstName + " ";
						}
						if (variable.getType() == VariableType.FIRST_VALUE) {
							text += object.eGet(attributeName) + " ";
						}
						if (variable.getType() == VariableType.SECOND_VALUE) {
							text += newVal + " ";
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
						if (variable.getType() == VariableType.ATT_NAME) {
							text += attName + " ";
						}
						if (variable.getType() == VariableType.OLD_VALUE) {
							text += oldVal + " ";
						}
						if (variable.getType() == VariableType.NEW_VALUE) {
							text += newVal + " ";
						}
					}
				}
			}
			storeMultiChoiceEmendationOptionList(exercise, text, attributes, mode, opt, opts);
		}
		if (mode == Mode.RADIOBUTTON) { 
			for (String txt : attributes) {
				if (!opt.text.contains(txt)) {
					opt.text.add(txt);
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
								o = (EObject) to.eGet(((modeltext.Variable) v).getRef());
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
	private void storeReferenceChangedOptions(MultiChoiceEmendation exercise, Resource cfgoptsresource, Resource idelemsresource, InformationChanged informationChanged, TestOption opt, List<TestOption> opts, Mode mode) {
		List<ReferenceChanged> refChanges = informationChanged.getRefChanges();
		EObject object = ModelManager.getEObject(informationChanged.getObject(), opt.seed);
		List<String> references = new ArrayList<String>();
		for (ReferenceChanged ref : refChanges) {
			String text = "";
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
				text += getReferenceChangedOptionNewerOlder(t, object, from, to, element, fromElement, toElement, refTarElement, refSrcElement);
			}
			if (!older) {
				text += getReferenceChangedOptionNotOlder(opt, t, object, to, element, toElement, refSrcElement);
			}
			if (!newer) {
				text += getReferenceChangedOptionNotNewer(opt, t, object, from, fromElement, toElement, refSrcElement);
			}
			storeMultiChoiceEmendationOptionList(exercise, text, references, mode, opt, opts);
		}
		if (mode == Mode.RADIOBUTTON) { 
			for (String txt : references) {
				if (!opt.text.contains(txt)) {
					opt.text.add(txt);
				}
			}
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
					opt.text = new ArrayList<String>();
					List<EObject> mutations = MutatorUtils.getMutations(ModelManager.getObjects(opt.resource));
					for (EObject mutation : mutations) {
						String text = "";
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
								text = getObjectCreatedOption(cfgoptsresource, idelemsresource, (ObjectCreated) mutation, opt);
								storeMultiChoiceEmendationOption(exercise, text, mode, opt, opts);
							}
							if (mutation instanceof ObjectRemoved) {
								text = getObjectRemovedOption(cfgoptsresource, idelemsresource, (ObjectRemoved) mutation, opt);
								storeMultiChoiceEmendationOption(exercise, text, mode, opt, opts);
							}							
							if (mutation instanceof SourceReferenceChanged) {
								text = getSourceReferenceChangedOption(cfgoptsresource, idelemsresource, (SourceReferenceChanged) mutation, opt);
								storeMultiChoiceEmendationOption(exercise, text, mode, opt, opts);
							}
							if (mutation instanceof TargetReferenceChanged) {
								text = getTargetReferenceChangedOption(cfgoptsresource, idelemsresource, (TargetReferenceChanged) mutation, opt);
								storeMultiChoiceEmendationOption(exercise, text, mode, opt, opts);
							}
//							if (mutation instanceof ReferenceSwap) {
//							}
							if (mutation instanceof ReferenceCreated) {
								text = getReferenceCreatedOption(cfgoptsresource, idelemsresource, (ReferenceCreated) mutation, opt);
								storeMultiChoiceEmendationOption(exercise, text, mode, opt, opts);
							}
							if (mutation instanceof ReferenceRemoved) {
								text = getReferenceRemovedOption(cfgoptsresource, idelemsresource, (ReferenceRemoved) mutation, opt);
								storeMultiChoiceEmendationOption(exercise, text, mode, opt, opts);
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
						if (opt.text != null) {
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
	private void buildMultiChoiceEmendation(Resource resource, MultiChoiceEmendation exercise, List<EObject> blocks) {
		try {
			Map<Test, Registry> dataReg = new HashMap<Test, Registry>();
			Bundle bundle = Platform.getBundle("wodel.models");
			String ecore = ModelManager.getMetaModel().replace("\\", "/");
			List<EPackage> packages = ModelManager.loadMetaModel(ecore);
			URL fileURL = bundle.getEntry("/models/AppliedMutations.ecore");
			String registryecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> registrypackages = ModelManager.loadMetaModel(registryecore);
			String xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() +
					"/" + ModelManager.getOutputFolder() + "/" + resource.getURI().lastSegment().replaceAll(".test", "_modeltext.model");
			fileURL = bundle.getEntry("/models/ModelText.ecore");
			String idelemsecore = FileLocator.resolve(fileURL).getFile();
			List<EPackage> idelemspackages = ModelManager.loadMetaModel(idelemsecore);
			Resource idelemsresource = ModelManager.loadModel(idelemspackages, URI.createURI(xmiFileName).toFileString());
			xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath() + "/" + WodelContext.getProject() +
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
						diagramPath = reg.mutants.get(rnd).getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png");
					}
					else {
						diagramPath = reg.mutants.get(rnd).getURI().path().replace(ModelManager.getOutputPath(), "").replace(".model", ".png");
					}
					opt.path = "diagrams" + diagramPath;
					opt.resource = reg.history.get(rnd);
					opt.seed = reg.seed;
					opt.solution = true;
					List<TestOption> opts = new ArrayList<TestOption>();
					opts.add(opt);
					for (Registry wrongRegistry : dataRegistry.get(exercise).get(test).wrong.get(reg.mutants.get(rnd))) {
						if (wrongRegistry.mutants.size() > 0) {
							rnd = ModelManager.getRandomIndex(wrongRegistry.mutants);
							opt = new TestOption();
							opt.path = "diagrams" + wrongRegistry.mutants.get(rnd).getURI().path().replace(ModelManager.getOutputPath().substring(2, ModelManager.getOutputPath().length()), "").replace(".model", ".png");
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
	 * Generates the options for the test exercises application
	 * @param program
	 * @param resource
	 * @return
	 */
	protected void buildOptions(Program program, Resource resource, List<EObject> blocks) {
		for (MutatorTests exercise : program.getExercises()) {
			total.put(exercise, 0);
			Map<Test, List<String>> diags = new HashMap<Test, List<String>>();
			if (exercise instanceof AlternativeResponse || exercise instanceof MultiChoiceDiagram) {
				buildAlternativeResponseOrMultiChoiceDiagram(exercise, diags);
			}
			if (exercise instanceof MultiChoiceEmendation) {
				buildMultiChoiceEmendation(resource, (MultiChoiceEmendation) exercise, blocks);
			}
		}
	}
	
	@Override
	public void doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		// TODO Auto-generated method stub
		
	}
	

}
