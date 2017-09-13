import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.lang.InterruptedException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import manager.DrawUtils.LabelStyle;

public class wodeledu_fa_Graph implements manager.IMutatorGraph {
	

	private static void generateNodes(ArrayList<EPackage> packages, Resource model, HashMap<EObject, LabelStyle> dotnodes, HashMap<String, ArrayList<HashMap<String, String>>> dotrels) {
		// COUNTER: 
		ArrayList<EObject> lnode_0 = ModelManager.getObjectsOfType("State", model);
		for (EObject node : lnode_0) {
			LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
			ArrayList<HashMap<String, String>> rels = new ArrayList<HashMap<String, String>>();
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
						LabelStyle style = null;
					{
						style = new LabelStyle();
						style.name = "_nil";
						style.shape = "style = invis"; 
						dotnodes.put(EcoreUtil.create(node.eClass()), style);
					}
					if (dotnodes.containsKey(node) == false) {
						style = new LabelStyle();
					}
					else {
						style = dotnodes.get(node);
					}
					style.name = name;
					style.border = "0";
					style.shape = "shape = circle";
					dotnodes.put(node, style);
					rels.add(parameters);
					dotrels.put("_nil -> " + name, rels);
					}
				}
			}
		}
		// INC COUNTER: 1
		ArrayList<EObject> lnode_1 = ModelManager.getObjectsOfType("State", model);
		for (EObject node : lnode_1) {
			LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
			ArrayList<HashMap<String, String>> rels = new ArrayList<HashMap<String, String>>();
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
						LabelStyle style = null;
					if (dotnodes.containsKey(node) == false) {
						style = new LabelStyle();
					}
					else {
						style = dotnodes.get(node);
					}
					style.name = name;
					style.border = "0";
					style.shape = "shape = circle";
					dotnodes.put(node, style);
					}
				}
			}
		}
		// INC COUNTER: 2
		ArrayList<EObject> lnode_2 = ModelManager.getObjectsOfType("State", model);
		for (EObject node : lnode_2) {
			LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
			ArrayList<HashMap<String, String>> rels = new ArrayList<HashMap<String, String>>();
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
						LabelStyle style = null;
					if (dotnodes.containsKey(node) == false) {
						style = new LabelStyle();
					}
					else {
						style = dotnodes.get(node);
					}
					style.name = name;
					style.border = "0";
					style.shape = "shape = doublecircle";
					dotnodes.put(node, style);
					}
				}
			}
		}
		// INC COUNTER: 3
		for (EObject dotnode : dotnodes.keySet()) {
			if (dotnodes.get(dotnode) != null) {
				LabelStyle style = dotnodes.get(dotnode);
				if (style.style.length() == 0) {
					if (style.label.length() == 0) {
						style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD>" + style.name + "</TD></TR></TABLE>>";
					}
					else {
						if (style.label.endsWith("<TR>")) {
							style.label = style.label.substring(0, style.label.length() - 4);
						}
						if (style.label.endsWith("<TR></TD></TR>")) {
							style.label = style.label.substring(0, style.label.length() - 14);
						}
						style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD>" + style.name + "</TD></TR><TR>" + style.label + "</TABLE>>";
					}
				}
				else {
					if (style.label.length() == 0) {
						style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD><" + style.style + ">" + style.name + "</" + style.style + "></TD></TR></TABLE>>";
					}
					else {
						if (style.label.endsWith("<TR>")) {
							style.label = style.label.substring(0, style.label.length() - 4);
						}
						if (style.label.endsWith("<TR></TD></TR>")) {
							style.label = style.label.substring(0, style.label.length() - 14);
						}
						style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD><" + style.style + ">" + style.name + "</" + style.style + "></TD></TR><TR>" + style.label + "</TABLE>>";
					}
				}
				dotnodes.put(dotnode, style);
			}
		}
	}
	
	private static void generateRelations(Resource model, HashMap<String, ArrayList<HashMap<String, String>>> dotrels, HashMap<String, ArrayList<String>> dottext) {
		// COUNTER: 
		//
		ArrayList<EObject> ledge_0 = ModelManager.getObjectsOfType("Transition", model);
		for (EObject edge : ledge_0) {
			LinkedHashMap<String, String> parameters = new LinkedHashMap<String, String>();
			ArrayList<HashMap<String, String>> rels = new ArrayList<HashMap<String, String>>();
			String source = "";
			String target = "";
			String label = "";
			String src_label = "";
			String tar_label = "";
			for (EReference ref : edge.eClass().getEAllReferences()) {
				if (ref.getName().equals("src")) {
					EObject src = (EObject) edge.eGet(ref);
					if (src != null) {
						for (EAttribute att : src.eClass().getEAllAttributes()) {
						if (att.getName().equals("name")) {
								source = (String) src.eGet(att);
								break;
							}
						}
					}
				}
	if (ref.getName().equals("tar")) {
		EObject tar = (EObject) edge.eGet(ref);
		if (tar != null) {
			for (EAttribute att : tar.eClass().getEAllAttributes()) {
				if (att.getName().equals("name")) {
					target = (String) tar.eGet(att);
					break;
				}
			}
		}
	}
}
			for (EReference ref : edge.eClass().getEAllReferences()) {
				if (ref.getName().equals("symbol")) {
					EObject obj = (EObject) edge.eGet(ref);
					if (obj != null) {
						for (EAttribute att : obj.eClass().getEAllAttributes()) {
						if (att.getName().equals("symbol")) {
							label = "\"" + (String) obj.eGet(att) + "\"";
						}
						}
					}
				}
			}
			parameters.put("label", label);
			if (dotrels.containsKey(source + "->" + target) == true) {
				rels = dotrels.get(source + "->" + target);
			}
			else {
				rels = new ArrayList<HashMap<String, String>>();
			}
			if (source.length() > 0 && target.length() > 0) {
				rels.add(parameters);
				dotrels.put(source + "->" + target, rels);
			}
		}
		// COUNTER: 1
		for (String relname : dotrels.keySet()) {
			ArrayList<HashMap<String, String>> rels = dotrels.get(relname);
			for (HashMap<String, String> params : rels) {
				int i = 0;
				String config = "";
				for (String key : params.keySet()) {
					if (i == 0) {
						if (params.get(key) != null) {
							if (params.get(key).length() > 0) {
								config = key + "=" + params.get(key);
								i++;
							}
						}
					}
					else {
						if (params.get(key) != null) {
							if (params.get(key).length() > 0) {
								config = config + ", " + key + "=" + params.get(key);
								i++;
							}
						}
					}
				}
				ArrayList<String> lconf = null;
				if (dottext.containsKey(relname) == true) {
					lconf = dottext.get(relname);
				}
				else {
					lconf = new ArrayList<String>();
				}
				lconf.add(config);
				dottext.put(relname, lconf);
			}
		}
	}
	
	public static void generateGraphs(File file, String folder, ArrayList<EPackage> packages, File exercise) throws ModelNotFoundException, FileNotFoundException {
		if (file.isFile()) {
			String pathfile = file.getPath();
			if (pathfile.endsWith(".model") == true) {
				Resource model = ModelManager.loadModel(packages, pathfile);
				String path = exercise.getName() + "/";
				List<String> folders = Arrays.asList(folder.split("/"));
				if (folders.size() > 0) {
					for (String folderName : folders) {
						path += folderName + "/";
					}
				}
				String dotfile = "C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + "/" +
					path + file.getName().replace(".model", ".dot");
				String pngfile = "C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + "/" +
					path + file.getName().replace(".model", ".png");
				HashMap<EObject, LabelStyle> dotnodes = new HashMap<EObject, LabelStyle>();
				HashMap<String, ArrayList<HashMap<String, String>>> dotrels = new HashMap<String, ArrayList<HashMap<String, String>>>();
				HashMap<String, ArrayList<String>> dottext = new HashMap<String, ArrayList<String>>();
				ArrayList<String> dotcode = new ArrayList<String>();
				generateNodes(packages, model, dotnodes, dotrels);
				generateRelations(model, dotrels, dottext);
				dotcode.add("digraph Automaton {\n");
				for (EObject dotnode : dotnodes.keySet()) {
					if (dotnodes.get(dotnode) != null) {
						dotcode.add(dotnodes.get(dotnode).name.replaceAll("'", "") + " [" + dotnodes.get(dotnode).label.replaceAll("'", "") + "];\n");
					}
				}
				for (String dott : dottext.keySet()) {
					if (dotrels.get(dott) == null) {
						dotcode.add(dott + ";\n");
					}
					else {
						if (dotrels.get(dott).size() == 0) {
							dotcode.add(dott + ";\n");
						}
						else {
							for (String text : dottext.get(dott)) {
								dotcode.add(dott.replaceAll("'", "") + " [" + text.replaceAll("'", "") + "];\n");
							}
						}
					}
				}
				dotcode.add("}");
				System.out.println(dotcode);
				System.out.println(dotfile);
				File diagramsfolder = new File("C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/");
				if (diagramsfolder.exists() != true) {
					diagramsfolder.mkdir();
				}
				File exercisefolder = new File("C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + exercise.getName() + "/");
				if (exercisefolder.exists() != true) {
					exercisefolder.mkdir();
				}
				path = exercise.getName() + "/";
				folders = Arrays.asList(folder.split("/"));
				if (folders.size() > 0) {
					for (String folderName : folders) {
						path += folderName + "/";
						exercisefolder = new File("C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + path);
						if (exercisefolder.exists() != true) {
							exercisefolder.mkdir();
						}
					}
				}
				System.out.println("path: " + path);
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
				//Reload input
				try {
					model.unload();
					model.load(null);
				} catch (Exception e) {}
			}
		}
		else {
			if (file.getName().equals("registry") != true) {
				File[] filesBlock = file.listFiles();
				for (File fileBlock : filesBlock) {
					generateGraphs(fileBlock, folder + "/" + file.getName(), packages, exercise);
				}
			}
		}
	}
		
	public void generate() throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {
			
		String metamodel = "C:/eclipse/workspace/wodeledu_fa/data/model/DFAAutomaton.ecore";
		ArrayList<EPackage> packages = ModelManager.loadMetaModel(metamodel);
		// GENERATES PNG FILES FROM SOURCE MODELS
		File folder = new File("C:/eclipse/workspace/wodeledu_fa/data/model");
		for (File file : folder.listFiles()) {
			if (file.isFile()) {
				String pathfile = file.getPath();
				if (pathfile.endsWith(".model") == true) {
					Resource model = ModelManager.loadModel(packages, pathfile);
					String dotfile = "C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + 
						file.getName().replace(".model", "") + "/" +
						file.getName().replace(".model", ".dot");
					String pngfile = "C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + 
						file.getName().replace(".model", "") + "/" +
						file.getName().replace(".model", ".png");
					HashMap<EObject, LabelStyle> dotnodes = new HashMap<EObject, LabelStyle>();
					HashMap<String, ArrayList<HashMap<String, String>>> dotrels = new HashMap<String, ArrayList<HashMap<String, String>>>();
					HashMap<String, ArrayList<String>> dottext = new HashMap<String, ArrayList<String>>();
					ArrayList<String> dotcode = new ArrayList<String>();
					generateNodes(packages, model, dotnodes, dotrels);
					generateRelations(model, dotrels, dottext);
					dotcode.add("digraph Automaton {\n");
					for (EObject dotnode : dotnodes.keySet()) {
						if (dotnodes.get(dotnode) != null) {
							dotcode.add(dotnodes.get(dotnode).name.replaceAll("'", "") + " [" + dotnodes.get(dotnode).label.replaceAll("'", "") + "];\n");
						}
					}
					for (String dott : dottext.keySet()) {
						if (dotrels.get(dott) == null) {
							dotcode.add(dott + ";\n");
						}
						else {
							if (dotrels.get(dott).size() == 0) {
								dotcode.add(dott + ";\n");
							}
							else {
								for (String text : dottext.get(dott)) {
									dotcode.add(dott.replaceAll("'", "") + " [" + text.replaceAll("'", "") + "];\n");
								}
							}
						}
					}
					dotcode.add("}");
					System.out.println(dotcode);
					System.out.println(dotfile);
					File diagramsfolder = new File("C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/");
					if (diagramsfolder.exists() != true) {
						diagramsfolder.mkdir();
					}
					File dotfolder = new File("C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + 
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
					//Reload input
    				try {
						model.unload();
						model.load(null);
					} catch (Exception e) {}
				}
			}
		}

		// GENERATES PNG FILES FROM MUTANTS
		folder = new File("C:/eclipse/workspace/wodeledu_fa/data/out");
		for (File exercise : folder.listFiles()) {
			if (exercise.isDirectory()) {
				for (File file : exercise.listFiles()) {
					if (file.isFile()) {
						String pathfile = file.getPath();
						if (pathfile.endsWith(".model") == true) {
							Resource model = ModelManager.loadModel(packages, pathfile);
							String dotfile = "C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + exercise.getName() + "/" +
								file.getName().replace(".model", ".dot");
							String pngfile = "C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + exercise.getName() + "/" +
							file.getName().replace(".model", ".png");
							HashMap<EObject, LabelStyle> dotnodes = new HashMap<EObject, LabelStyle>();
							HashMap<String, ArrayList<HashMap<String, String>>> dotrels = new HashMap<String, ArrayList<HashMap<String, String>>>();
							HashMap<String, ArrayList<String>> dottext = new HashMap<String, ArrayList<String>>();
							ArrayList<String> dotcode = new ArrayList<String>();
							generateNodes(packages, model, dotnodes, dotrels);
							generateRelations(model, dotrels, dottext);
							dotcode.add("digraph Automaton {\n");
							for (EObject dotnode : dotnodes.keySet()) {
								if (dotnodes.get(dotnode) != null) {
									dotcode.add(dotnodes.get(dotnode).name.replaceAll("'", "") + " [" + dotnodes.get(dotnode).label.replaceAll("'", "") + "];\n");
								}
							}
							for (String dott : dottext.keySet()) {
								if (dotrels.get(dott) == null) {
									dotcode.add(dott + ";\n");
								}
								else {
									if (dotrels.get(dott).size() == 0) {
										dotcode.add(dott + ";\n");
									}
									else {
										for (String text : dottext.get(dott)) {
											dotcode.add(dott.replaceAll("'", "") + " [" + text.replaceAll("'", "") + "];\n");
										}
									}
								}
							}
							dotcode.add("}");
							System.out.println(dotcode);
							System.out.println(dotfile);
							File diagramsfolder = new File("C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/");
							if (diagramsfolder.exists() != true) {
								diagramsfolder.mkdir();
							}
							File dotfolder = new File("C:/eclipse/workspace/wodeledu_fa/src-gen/html/diagrams/" + exercise.getName() + "/");
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
							//Reload input
	    					try {
								model.unload();
								model.load(null);
							} catch (Exception e) {}
						}
					}
					else {
						if (file.getName().equals("registry") != true) {
							File[] filesBlock = file.listFiles();
							for (File fileBlock : filesBlock) {
								generateGraphs(fileBlock, file.getName(), packages, exercise);
							}
						}
					}
				}
			}
		}
	}
}

