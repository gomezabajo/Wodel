package manager;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mutatorenvironment.Block;
import edutest.MultiChoiceEmendation;
import edutest.Test;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ModelNotFoundException;

public class TestUtils {

	public static class Registry {
		public Resource seed;
		public ArrayList<Resource> mutants;
		public ArrayList<Resource> history;
		public HashMap<Resource, ArrayList<Registry>> wrong;
	}

	public static class TestOption implements Cloneable {
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
	
	public static Registry getRegistry(MultiChoiceEmendation exercise, Test test, ArrayList<EObject> blocks, ArrayList<EPackage> packages, ArrayList<EPackage> registrypackages) throws ModelNotFoundException {
		File outFolder = new File(ModelManager.getOutputPath() + '/' + test.getSource().replace(".model", ""));
		Registry registry = new Registry();
		registry.seed = ModelManager.loadModel(packages, ModelManager.getModelsFolder() + '/' + test.getSource());
		registry.mutants = new ArrayList<Resource>();
		registry.history = new ArrayList<Resource>();
		registry.wrong = new HashMap<Resource, ArrayList<Registry>>();
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
}
