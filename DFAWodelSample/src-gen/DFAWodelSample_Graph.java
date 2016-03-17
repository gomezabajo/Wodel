import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.InterruptedException;
import java.util.ArrayList;
import java.util.HashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;

public class DFAWodelSample_Graph implements manager.IMutatorGraph {

	public void generate() throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {
		
		String metamodel = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model/DFAAutomaton.ecore";
		ArrayList<EPackage> packages = ModelManager.loadMetaModel(metamodel);


		// GENERATES PNG FILES FROM SOURCE MODELS
		File folder = new File("C:/eclipse/runtime-EclipseApplication/DFAWodelSample/model");
		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				String pathfile = file.getPath();
				if (pathfile.endsWith(".model") == true) {
					Resource model = ModelManager.loadModel(packages, pathfile);
					String dotfile = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/" + 
						file.getName().replace(".model", "") + "/" +
						file.getName().replace(".model", ".dot");
					String pngfile = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/" + 
						file.getName().replace(".model", "") + "/" +
						file.getName().replace(".model", ".png");
					
					HashMap<String, String> dotnodes = new HashMap<String, String>();
					HashMap<String, String> dotedges = new HashMap<String, String>();
					// COUNTER: 
					ArrayList<EObject> lnode_0 = ModelManager.getObjectsOfType("State", model);
					for (EObject node : lnode_0) {
						String name = "";
						for (EAttribute att : node.eClass().getEAllAttributes()) {
							if (att.getName().equals("name")) {
								name = (String) node.eGet(att);
								break;
							}
						}
						for (EAttribute att : node.eClass().getEAllAttributes()) {
							if (att.getName().equals("isInitial")) {
								Boolean value = (Boolean) node.eGet(att);
								if (value == true) {
									if (dotnodes.containsKey("_nil") == false) {
										dotnodes.put("_nil", "style = invis");
									}
									if (dotnodes.containsKey(name) == false) {
										dotnodes.put(name, "shape = circle");
									}
									dotedges.put("_nil -> " + name, "");
								}
							}
						}
					}
					// COUNTER: 1
					ArrayList<EObject> lnode_1 = ModelManager.getObjectsOfType("State", model);
					for (EObject node : lnode_1) {
						String name = "";
						for (EAttribute att : node.eClass().getEAllAttributes()) {
							if (att.getName().equals("name")) {
								name = (String) node.eGet(att);
								break;
							}
						}
						for (EAttribute att : node.eClass().getEAllAttributes()) {
							if (att.getName().equals("isFinal")) {
								Boolean value = (Boolean) node.eGet(att);
								if (value == false) {
									if (dotnodes.containsKey(name) == false) {
										dotnodes.put(name, "shape = circle");
									}
								}
							}
						}
					}
					// COUNTER: 2
					ArrayList<EObject> lnode_2 = ModelManager.getObjectsOfType("State", model);
					for (EObject node : lnode_2) {
						String name = "";
						for (EAttribute att : node.eClass().getEAllAttributes()) {
							if (att.getName().equals("name")) {
								name = (String) node.eGet(att);
								break;
							}
						}
						for (EAttribute att : node.eClass().getEAllAttributes()) {
							if (att.getName().equals("isFinal")) {
								Boolean value = (Boolean) node.eGet(att);
								if (value == true) {
									dotnodes.put(name, "shape = doublecircle");
								}
							}
						}
					}
					// COUNTER: 3
					// COUNTER: 0
					ArrayList<EObject> ledge_0 = ModelManager.getObjectsOfType("Transition", model);
					for (EObject edge : ledge_0) {
						String source = "";
						String target = "";
						String label = "";
						for (EReference ref : edge.eClass().getEAllReferences()) {
							if (ref.getName().equals("src")) {
								EObject src = (EObject) edge.eGet(ref);
								for (EAttribute att : src.eClass().getEAllAttributes()) {
									if (att.getName().equals("name")) {
										source = (String) src.eGet(att);
										break;
									}
								}
							}
							if (ref.getName().equals("tar")) {
								EObject tar = (EObject) edge.eGet(ref);
								for (EAttribute att : tar.eClass().getEAllAttributes()) {
									if (att.getName().equals("name")) {
										target = (String) tar.eGet(att);
										break;
									}
								}
							}
							if (ref.getName().equals("symbol")) {
								EObject lbl = (EObject) edge.eGet(ref);
								for (EAttribute att : lbl.eClass().getEAllAttributes()) {
									if (att.getName().equals("symbol")) {
										label = (String) lbl.eGet(att);
										break;
									}
								}
							}
						}
						if (dotedges.containsKey(source + " -> " + target) == true) {
							String prevlbl = dotedges.get(source + " -> " + target);
							label = prevlbl + ", " + label;
						}
						dotedges.put(source + " -> " + target, label);
					}
					// COUNTER: 1
					ArrayList<String> dotcode = new ArrayList<String>();
					dotcode.add("digraph Automaton {\n");
					for (String dotnode : dotnodes.keySet()) {
						if (dotnodes.get(dotnode).equals("")) {
							dotcode.add(dotnode + ";\n");
						}
						else {
							dotcode.add(dotnode + " [" + dotnodes.get(dotnode) + "];\n");
						}
					}
					for (String dotedge : dotedges.keySet()) {
						if (dotedges.get(dotedge).equals("")) {
							dotcode.add(dotedge + ";\n");
						}
						else {
							dotcode.add(dotedge + " [label = \"" + dotedges.get(dotedge) + "\"];\n");
						}
					}
					dotcode.add("}");
					System.out.println(dotcode);
					System.out.println(dotfile);
					File diagramsfolder = new File("C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/");
					if (diagramsfolder.exists() != true) {
						diagramsfolder.mkdir();
					}
					File dotfolder = new File("C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/" + 
						file.getName().replace(".model", "") + "/");
					if (dotfolder.exists() != true) {
						dotfolder.mkdir();
					}
					PrintWriter dotwriter = new PrintWriter(dotfile);
					for (String dotline : dotcode) {
						dotwriter.println(dotline);
					}
					dotwriter.close();
					String[] command = {"dot", "-Tpng", dotfile, "-o", pngfile};
					try {
						Process proc = Runtime.getRuntime().exec(command);
						proc.waitFor(); 
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		// GENERATES PNG FILES FROM MUTANTS
		folder = new File("C:/eclipse/runtime-EclipseApplication/DFAWodelSample/out");
		for (File exercise : folder.listFiles()) {
			if (exercise.isDirectory()) {
				for (File file : exercise.listFiles()) {
					String pathfile = file.getPath();
					if (pathfile.endsWith(".model") == true) {
						Resource model = ModelManager.loadModel(packages, pathfile);
						String dotfile = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/" + exercise.getName() + "/" +
							file.getName().replace(".model", ".dot");
						String pngfile = "C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/" + exercise.getName() + "/" +
							file.getName().replace(".model", ".png");
						HashMap<String, String> dotnodes = new HashMap<String, String>();
						HashMap<String, String> dotedges = new HashMap<String, String>();
						// COUNTER: 0
						ArrayList<EObject> lnode_0 = ModelManager.getObjectsOfType("State", model);
						for (EObject node : lnode_0) {
							String name = "";
							for (EAttribute att : node.eClass().getEAllAttributes()) {
								if (att.getName().equals("name")) {
									name = (String) node.eGet(att);
									break;
								}
							}
							for (EAttribute att : node.eClass().getEAllAttributes()) {
								if (att.getName().equals("isInitial")) {
									Boolean value = (Boolean) node.eGet(att);
									if (value == true) {
										if (dotnodes.containsKey("_nil") == false) {
											dotnodes.put("_nil", "style = invis");
										}
										if (dotnodes.containsKey(name) == false) {
											dotnodes.put(name, "shape = circle");
										}
										dotedges.put("_nil -> " + name, "");
									}
								}
							}
						}
						// COUNTER: 1
						ArrayList<EObject> lnode_1 = ModelManager.getObjectsOfType("State", model);
						for (EObject node : lnode_1) {
							String name = "";
							for (EAttribute att : node.eClass().getEAllAttributes()) {
								if (att.getName().equals("name")) {
									name = (String) node.eGet(att);
									break;
								}
							}
							for (EAttribute att : node.eClass().getEAllAttributes()) {
								if (att.getName().equals("isFinal")) {
									Boolean value = (Boolean) node.eGet(att);
									if (value == false) {
										if (dotnodes.containsKey(name) == false) {
											dotnodes.put(name, "shape = circle");
										}
									}
								}
							}
						}
						// COUNTER: 2
						ArrayList<EObject> lnode_2 = ModelManager.getObjectsOfType("State", model);
						for (EObject node : lnode_2) {
							String name = "";
							for (EAttribute att : node.eClass().getEAllAttributes()) {
								if (att.getName().equals("name")) {
									name = (String) node.eGet(att);
									break;
								}
							}
							for (EAttribute att : node.eClass().getEAllAttributes()) {
								if (att.getName().equals("isFinal")) {
									Boolean value = (Boolean) node.eGet(att);
									if (value == true) {
										dotnodes.put(name, "shape = doublecircle");
									}
								}
							}
						}
						// COUNTER: 3
						// COUNTER: 0
						ArrayList<EObject> ledge_0 = ModelManager.getObjectsOfType("Transition", model);
						for (EObject edge : ledge_0) {
							String source = "";
							String target = "";
							String label = "";
							for (EReference ref : edge.eClass().getEAllReferences()) {
								if (ref.getName().equals("src")) {
									EObject src = (EObject) edge.eGet(ref);
									for (EAttribute att : src.eClass().getEAllAttributes()) {
										if (att.getName().equals("name")) {
											source = (String) src.eGet(att);
											break;
										}
									}
								}
								if (ref.getName().equals("tar")) {
									EObject tar = (EObject) edge.eGet(ref);
									for (EAttribute att : tar.eClass().getEAllAttributes()) {
										if (att.getName().equals("name")) {
											target = (String) tar.eGet(att);
											break;
										}
									}
								}
								if (ref.getName().equals("symbol")) {
									EObject lbl = (EObject) edge.eGet(ref);
									for (EAttribute att : lbl.eClass().getEAllAttributes()) {
										if (att.getName().equals("symbol")) {
											label = (String) lbl.eGet(att);
											break;
										}
									}
								}
							}
							if (dotedges.containsKey(source + " -> " + target) == true) {
								String prevlbl = dotedges.get(source + " -> " + target);
								label = prevlbl + ", " + label;
							}
							dotedges.put(source + " -> " + target, label);
						}
						// COUNTER: 1
						ArrayList<String> dotcode = new ArrayList<String>();
						dotcode.add("digraph Automaton {\n");
						for (String dotnode : dotnodes.keySet()) {
							if (dotnodes.get(dotnode).equals("")) {
								dotcode.add(dotnode + ";\n");
							}
							else {
								dotcode.add(dotnode + " [" + dotnodes.get(dotnode) + "];\n");
							}
						}
						int i = 0;
						for (String dotedge : dotedges.keySet()) {
							if (dotedges.get(dotedge).equals("")) {
								dotcode.add(dotedge + ";\n");
							}
							else {
								dotcode.add(dotedge + " [label = \"" + dotedges.get(dotedge) + "\"];\n");
							}
							i++;
						}
						dotcode.add("}");
						System.out.println(dotcode);
						System.out.println(dotfile);
						File diagramsfolder = new File("C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/");
						if (diagramsfolder.exists() != true) {
							diagramsfolder.mkdir();
						}
						File dotfolder = new File("C:/eclipse/runtime-EclipseApplication/DFAWodelSample/src-gen/html/diagrams/" + exercise + "/");
						if (dotfolder.exists() != true) {
							dotfolder.mkdir();
						}
						PrintWriter dotwriter = new PrintWriter(dotfile);
						for (String dotline : dotcode) {
							dotwriter.println(dotline);
						}
						dotwriter.close();
						String[] command = {"dot", "-Tpng", dotfile, "-o", pngfile};
						try {
							Process proc = Runtime.getRuntime().exec(command);
							proc.waitFor(); 
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
}

