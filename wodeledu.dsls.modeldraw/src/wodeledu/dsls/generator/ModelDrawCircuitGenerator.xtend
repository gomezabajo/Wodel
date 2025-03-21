package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import modeldraw.MutatorDraw
import wodel.utils.manager.ModelManager
import wodel.utils.manager.JavaUtils
import wodel.utils.manager.ProjectUtils
import org.eclipse.core.runtime.Platform
import org.eclipse.xtext.generator.AbstractGenerator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import java.util.ArrayList

/**
 * @author Pablo Gomez-Abajo - modelDraw code generator.
 * 
 * Generates the Java code for the graphical
 * representation of the models. Circuit mode.
 *  
 */
class ModelDrawCircuitGenerator extends AbstractGenerator {
	
	private String fileName
	private String className
	
	private String rendererPath
	private String rendererUnit
	private String[] rendererFolders
	
	private List<EPackage> metamodel
	private List<EClass> roots
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		rendererPath = Platform.getPreferencesService().getString("wodeledu.dsls.EduTest", "Model-Draw renderer path", "", null);
		if (rendererPath === null || rendererPath.isEmpty()) {
			rendererPath = "d:/dpic"
		}
		if (!rendererPath.startsWith("/")) {
			rendererUnit = rendererPath.substring(0, 1);
			rendererPath = rendererPath.substring(3, rendererPath.length)
		}
		rendererFolders = rendererPath.replace("\\", "/").split("/")
		
		var i = 0;
		fileName = resource.URI.lastSegment
		fileName = fileName.replaceAll(".draw", "").replaceAll("[.]", "_") + ".draw"
		for(e: resource.allContents.toIterable.filter(MutatorDraw)) {
			if (i == 0) {
				fileName = fileName.replace(".draw", "") + 'Draw.java'
			}
			else {
				fileName = fileName.replace(".draw", "") + i + 'Draw.java'
			}
			metamodel = new ArrayList<EPackage>()
			metamodel.addAll(ModelManager.loadMetaModel(e.metamodel))
			roots = new ArrayList<EClass>()
			roots.addAll(ModelManager.getRootEClasses(metamodel))
			className = fileName.replaceAll("Draw.java", "")
     		fsa.generateFile("mutator/" + className + "/" + fileName, JavaUtils.format(e.compile, false))
			i++
		}
	}
	
	def compile(MutatorDraw draw) '''
		
		//«var String folder = ProjectUtils.getProject.getLocation.toFile.getPath.replace("\\", "/") + "/"»
		
		package mutator.«className»;
		
		import java.io.File;
		import java.io.FileNotFoundException;
		import java.io.PrintWriter;
		import java.io.IOException;
		import java.io.UnsupportedEncodingException;
		import java.lang.InterruptedException;
		import java.util.AbstractMap.SimpleEntry;
		import java.util.ArrayList;
		import java.util.Arrays;
		import java.util.List;
		import java.util.Map;
		import java.util.HashMap;
		
		import org.eclipse.emf.ecore.EPackage;
		import org.eclipse.emf.ecore.resource.Resource;
		
		import wodel.utils.exceptions.MetaModelNotFoundException;
		import wodel.utils.exceptions.ModelNotFoundException;
		import wodel.utils.manager.CircuitUtils;
		import wodel.utils.manager.CircuitUtils.LogicalCircuit;
		import wodel.utils.manager.CircuitUtils.LogicalNode;
		import wodel.utils.manager.CircuitUtils.LogicalInputPin;
		import wodel.utils.manager.CircuitUtils.LogicalOutputPin;
		import wodel.utils.manager.CircuitUtils.LogicalNOT;
		import wodel.utils.manager.CircuitUtils.LogicalAND;
		import wodel.utils.manager.CircuitUtils.LogicalOR;
		import wodel.utils.manager.ModelManager;
		import wodel.utils.manager.ProjectUtils;
		
		import org.eclipse.core.runtime.IProgressMonitor;
		
		import org.eclipse.jface.operation.IRunnableWithProgress;
		
		import java.lang.reflect.InvocationTargetException;
		
		import org.eclipse.core.commands.AbstractHandler;
		
		import org.eclipse.core.commands.ExecutionEvent;
		import org.eclipse.core.commands.ExecutionException;
		
		import org.eclipse.core.resources.IProject;
		
		import org.eclipse.jface.dialogs.ProgressMonitorDialog;
		import org.eclipse.jface.operation.IRunnableWithProgress;
		
		import org.eclipse.swt.widgets.Display;
		import org.eclipse.swt.widgets.Shell;
		
		public class «className»Draw extends AbstractHandler implements wodeledu.extension.run.commands.IMutatorDraw {
			
			private Display activeDisplay = null;
			private Shell activeShell = null;
			
			private class RunMutatorDrawWithProgress implements IRunnableWithProgress {
				
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						generate(monitor);
					}
					catch (MetaModelNotFoundException e) {
						e.printStackTrace();
					}
					catch (ModelNotFoundException e) {
						e.printStackTrace();
					}
					catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
		
				private String generateCircuitMacrosSpecificacion(List<EPackage> packages, Resource model, String fileName) {
			String m4text = "";
			m4text += ".PS\n";
			m4text += "# " + fileName.replace(".model", "") + ".m4\n";
			m4text += "log_init\n\n";
			m4text += "define(`del',`L_unit*5/2')\n\n";
			m4text += "dmov = 0.4\n";
			m4text += "# Input labels\n";
			m4text += "C: grid_(0,0)\n";
			m4text += "DE: C+grid_(0,AND_ht*7/4)\n";
			LogicalCircuit lc = CircuitUtils.convertToLC(packages, model);
			List<LogicalInputPin> inputPins = lc.getInputPins();
			Map<String, SimpleEntry<String, Integer>> relationsMap = new HashMap<String, SimpleEntry<String, Integer>>();
			int position = 0; 
			if (inputPins.size() > 0) {
				m4text += "A0: DE+grid_(0,BUF_ht*5/2); dot(at A0); \"" + inputPins.get(0).getName() + "\" rjust at A0\n";
				relationsMap.put(inputPins.get(0).getName(), new SimpleEntry<String, Integer>("A0", position)); 
			}
			for (int i = 1; i < inputPins.size(); i++) {
				m4text += "A" + i + ": A" + (i - 1) + "+grid_(0,BUF_ht*5/2); dot(at A" + i + "); \"" + inputPins.get(i).getName() + "\" rjust at A" + i +"\n";
				relationsMap.put(inputPins.get(i).getName(), new SimpleEntry<String, Integer>("A" + i, position)); 
			}
			m4text += "  move to (-0.2,0)   # Lettering within the global object\n\n";
			List<LogicalNode> nextNodes = new ArrayList<LogicalNode>();
			for (int i = 0; i < inputPins.size(); i++) {
				LogicalNode nextNode = lc.getNodeWithInput(inputPins.get(i).getName());
				if (nextNode != null && !nextNodes.contains(nextNode)) {
					nextNodes.add(nextNode);
				}
			}
			inputPins.clear();
			for (int i = 0; i < nextNodes.size(); i++) {
				LogicalOutputPin outputPin = nextNodes.get(i).getOutputPin();
				if (outputPin != null) {
					LogicalInputPin nextInputPin = outputPin.getTarget();
					if (nextInputPin != null) {
						if (!inputPins.contains(nextInputPin)) {
							inputPins.add(nextInputPin);
						}
					}
				}
			}
			char alphabet = 'G';
			int index = 0;
			for (int i = 0; i < nextNodes.size(); i++) {
				SimpleEntry<String, Integer> previousNode = relationsMap.get(nextNodes.get(i).getInputPins().get(0).getName());
				if (previousNode == null) {
					previousNode = relationsMap.get(nextNodes.get(i).getInputPins().get(1).getName());
				} 
				String inputLabel = previousNode.getKey();
				position = previousNode.getValue() + 8;
				String gateName = "";
				if (nextNodes.get(i) instanceof LogicalNOT) {
					if (!lc.getInputPins().containsAll(nextNodes.get(i).getInputPins())) {
						position += 16;
					}
					gateName = "NOT";
				}
				if (nextNodes.get(i) instanceof LogicalAND) {
					if (!lc.getInputPins().containsAll(nextNodes.get(i).getInputPins())) {
						position += 16;
					}
					gateName = "AND";
				}
				if (nextNodes.get(i) instanceof LogicalOR) {
					if (!lc.getInputPins().containsAll(nextNodes.get(i).getInputPins())) {
						position += 16;
					}
					gateName = "OR";
				}
				m4text += String.valueOf((char) (alphabet + index)) + (i + 1) + ": " + gateName + "_gate at (" + inputLabel + "+grid_(" + position + ",BUF_ht*" + position + ")," + inputLabel + ")\n";
				relationsMap.put(nextNodes.get(i).getName(), new SimpleEntry<String, Integer>(String.valueOf((char) (alphabet + index)) + (i + 1), position)); 
				m4text += "\n";
			}
			int counter = 0;
			for (int i = 0; i < nextNodes.size(); i++) {
				SimpleEntry<String, Integer> previousNode = relationsMap.get(nextNodes.get(i).getName());
				String inputLabel = previousNode.getKey();
				if (nextNodes.get(i).getInputPins().size() == 1) {
					if (nextNodes.get(i).getInputs().size() == 0) {
						m4text += "line right 3*del from A" + counter + " to " + inputLabel + ".In1\n";
						counter++;
					} else {
						SimpleEntry<String, Integer> previousInputNode = relationsMap.get(nextNodes.get(i).getInputs().get(0).getName());
						if (previousInputNode != null) {
							String previousInputLabel = previousInputNode.getKey();
							m4text += "line right 3*del from " + previousInputLabel + ".Out to "
									+ inputLabel + ".In2\n";
						}
					}
				}
				if (nextNodes.get(i).getInputPins().size() > 1) {
					if (nextNodes.get(i).getInputs().size() == 0) {
						m4text += "line right 3*del from A" + counter + " to " + inputLabel + ".In2\n";
						counter++;
						m4text += "line right 3*del from A" + counter + " to " + inputLabel + ".In1\n";
						counter++;
					}
					if (nextNodes.get(i).getInputs().size() == 1) {
						m4text += "line right 3*del from A" + counter + " to " + inputLabel + ".In2\n";
						counter++;
						SimpleEntry<String, Integer> previousInputNode = relationsMap.get(nextNodes.get(i).getInputs().get(0).getName());
						if (previousInputNode != null) {
							String previousInputLabel = previousInputNode.getKey();
							m4text += "line right 3*del from " + previousInputLabel + ".Out to "
									+ inputLabel + ".In1\n";
						}
					}
					if (nextNodes.get(i).getInputs().size() == 2) {
						SimpleEntry<String, Integer> previousInputNode = relationsMap.get(nextNodes.get(i).getInputs().get(0).getName());
						String previousInputLabel = previousInputNode.getKey();
						m4text += "line right 3*del from " + previousInputLabel + ".Out to "
								+ inputLabel + ".In2\n";
						previousInputNode = relationsMap.get(nextNodes.get(i).getInputs().get(1).getName());
						previousInputLabel = previousInputNode.getKey();
						m4text += "line right 3*del from " + previousInputLabel + ".Out to "
								+ inputLabel + ".In1\n";
					}
				}
			}
			m4text += "\n";
			LogicalNode outputNode = lc.getOutputNode();
			while (outputNode != null && !nextNodes.contains(outputNode) && index < lc.getDistance()) {
				index++;
				nextNodes.clear(); 
				for (int i = 0; i < inputPins.size(); i++) {
					LogicalNode nextNode = lc.getNodeWithInput(inputPins.get(i).getName());
					if (nextNode != null && !nextNodes.contains(nextNode)) {
						if (nextNode.getInputPins().size() == 1 && !lc.getInputPins().contains(nextNode.getInputPins().get(0))) {
							nextNodes.add(nextNode);
						}
						if (nextNode.getInputPins().size() > 1 && !lc.getInputPins().contains(nextNode.getInputPins().get(0)) && !lc.getInputPins().contains(nextNode.getInputPins().get(1))) {
							nextNodes.add(nextNode);
						}
					}
				}
				inputPins.clear();
				for (int i = 0; i < nextNodes.size(); i++) {
					LogicalOutputPin outputPin = nextNodes.get(i).getOutputPin();
					if (outputPin != null) {
						LogicalInputPin nextInputPin = outputPin.getTarget();
						if (nextInputPin != null) {
							if (!inputPins.contains(nextInputPin)) {
								inputPins.add(nextInputPin);
							}
						}
					}
				}
				for (int i = 0; i < nextNodes.size(); i++) {
					SimpleEntry<String, Integer> previousNode = relationsMap.get(nextNodes.get(i).getInputs().get(0).getName());
					if (previousNode == null) {
						previousNode = relationsMap.get(nextNodes.get(i).getInputs().get(1).getName());
					}
					String inputLabel = previousNode.getKey();
					position = previousNode.getValue() + 16;
					String gateName = "";
					if (nextNodes.get(i) instanceof LogicalNOT) {
						gateName = "NOT";
					}
					if (nextNodes.get(i) instanceof LogicalAND) {
						gateName = "AND";
					}
					if (nextNodes.get(i) instanceof LogicalOR) {
						gateName = "OR";
					}
					m4text += String.valueOf((char) (alphabet + index)) + (i + 1) + ": " + gateName + "_gate at (" + inputLabel + "+grid_(" + position + ",BUF_ht*" + position + ")," + inputLabel + "+grid_(0,BUF_ht*15/13))\n";
					relationsMap.put(nextNodes.get(i).getName(), new SimpleEntry<String, Integer>(String.valueOf((char) (alphabet + index)) + (i + 1), position)); 
					m4text += "\n";
				} 
				for (int i = 0; i < nextNodes.size(); i++) {
					if (nextNodes.get(i).getInputs().size() == 1) {
						SimpleEntry<String, Integer> previousNode = relationsMap.get(nextNodes.get(i).getInputs().get(0).getName());
						String inputLabel = previousNode.getKey();
						m4text += "line right 3*del from " + inputLabel + ".Out to " + String.valueOf((char) (alphabet + index)) + (i + 1) + ".In1\n";
					}
					if (nextNodes.get(i).getInputs().size() > 1) {
						SimpleEntry<String, Integer> previousNode = relationsMap.get(nextNodes.get(i).getInputs().get(0).getName());
						if (previousNode != null) {
							String inputLabel = previousNode.getKey();
							m4text += "line right 3*del from " + inputLabel + ".Out to " + String.valueOf((char) (alphabet + index)) + (i + 1) + ".In2\n";
						}
						previousNode = relationsMap.get(nextNodes.get(i).getInputs().get(1).getName());
						if (previousNode != null) {
							String inputLabel = previousNode.getKey();
							m4text += "line right 3*del from " + inputLabel + ".Out to " + String.valueOf((char) (alphabet + index)) + (i + 1) + ".In1\n";
						}
					}
					m4text += "\n";
				}
			}
			if (outputNode != null) {
				SimpleEntry<String, Integer> previousNode = relationsMap.get(outputNode.getName());
				if (previousNode != null) {
					String inputLabel = previousNode.getKey();
					m4text += "LOUT: line right del from " + inputLabel + ".Out; dot at (LOUT,Here); move right 0.2; \"" + outputNode.getOutputPin().getName() + "\" rjust\n\n";
				}
			}
		
					m4text += ".PE\n";
					return m4text;
				} 
		
				private void generateGraphs(File file, String folder, List<EPackage> packages, File exercise, String projectName, IProgressMonitor monitor) throws ModelNotFoundException, FileNotFoundException, UnsupportedEncodingException {
			if (file.isFile()) {
				String pathfile = file.getPath();
				if (pathfile.endsWith(".model") == true) {
					String printPathfile = pathfile.replace("\\", "/");
					printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
					monitor.subTask("Rendering image for mutant " + printPathfile);
					Resource model = ModelManager.loadModel(packages, pathfile);
					String m4text = generateCircuitMacrosSpecificacion(packages, model, file.getName());
					String path = exercise.getName() + "/";
					List<String> folders = Arrays.asList(folder.split("/"));
					if (folders.size() > 0) {
						for (String folderName : folders) {
							path += folderName + "/";
						}
					}
					String m4file = "«folder»src-gen/html/diagrams/" + 
						path + "«roots.get(0).name»_" + file.getName().replace(".model", ".m4");
					String batfile = "«folder»src-gen/html/diagrams/" + 
						path + "«roots.get(0).name»_" + file.getName().replace(".model", ".bat");
					String svgfile = "«folder»src-gen/html/diagrams/" + 
						path + "«roots.get(0).name»_" + file.getName().replace(".model", ".svg");
					String pngfile = "«folder»src-gen/html/diagrams/" + 
						path + "«roots.get(0).name»_" + file.getName().replace(".model", ".png");
					File exercisefolder = new File("«folder»src-gen/html/diagrams/" + path);
					if (exercisefolder.exists() != true) {
						exercisefolder.mkdirs();
					}
					PrintWriter m4writer = null;
					try {
						m4writer = new PrintWriter(m4file, "UTF-8");
						String[] m4lines = m4text.split("\n");
						for (int i = 0; i < m4lines.length - 1; i++) {
							m4writer.println(m4lines[i]);
						}
						m4writer.print(m4lines[m4lines.length - 1]);
						m4writer.close();
					} catch (UnsupportedEncodingException e) {
						//Reload input
						try {
							model.unload();
							model.load(null);
						} catch (Exception ex) {}
						return;
					}
					PrintWriter batwriter = null;
					try {
						batwriter = new PrintWriter(batfile, "UTF-8");
						batwriter.println("«rendererUnit»:");
						batwriter.println("cd \\");
						«FOR String rendererFolder : rendererFolders»
							batwriter.println("cd «rendererFolder»");
						«ENDFOR»
						batwriter.println("m4 liblog.m4 " + m4file + " | dpic -v > " + svgfile);
						batwriter.println("cd batik");
						batwriter.println("java -jar batik-rasterizer-1.18.jar -m image/png -d " + pngfile + " " +  svgfile + " 2>&1");
						batwriter.println("exit");
						batwriter.close();
					} catch (UnsupportedEncodingException e) {
						//Reload input
						try {
							model.unload();
							model.load(null);
						} catch (Exception ex) {}
						return;
					}
					String[] command = {"cmd", "/c", batfile};
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
					//SVGUtils.convert2PNG(svgfile);
					//Reload input
					try {
						model.unload();
						model.load(null);
					} catch (Exception e) {}
					monitor.worked(1);
				}
			}
			else {
				if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
					File[] filesBlock = file.listFiles();
					for (File fileBlock : filesBlock) {
						generateGraphs(fileBlock, folder + file.getName(), packages, exercise, projectName, monitor);
					}
				}
			}
				}
				public void generate(IProgressMonitor monitor) throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {
						
					String metamodel = "«ModelManager.getMetaModel().replace("\\", "/")»";
					List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
					String projectName = ProjectUtils.getProject().getName();
					
					List<String> models = ModelManager.getModels();
					List<String> mutants = ModelManager.getMutants();
					
					int totalTasks = models.size() + mutants.size();
					
					monitor.beginTask("Rendering models", totalTasks);
					
					// GENERATES svg FILES FROM SOURCE MODELS
					File folder = new File("«folder»data/model");
					for (File file : folder.listFiles()) {
						if (file.isFile()) {
							String pathfile = file.getPath();
							if (pathfile.endsWith(".model") == true) {
								String printPathfile = pathfile.replace("\\", "/");
								printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
								monitor.subTask("Rendering image for model " + printPathfile);
								Resource model = ModelManager.loadModel(packages, pathfile);
								String m4text = generateCircuitMacrosSpecificacion(packages, model, file.getName());
								String m4file = "«folder»src-gen/html/diagrams/" + file.getName().replace(".model", "") + "/" +
									"«roots.get(0).name»_" + file.getName().replace(".model", ".m4");
								String batfile = "«folder»src-gen/html/diagrams/" + file.getName().replace(".model", "") + "/" +
									"«roots.get(0).name»_" + file.getName().replace(".model", ".bat");
								String svgfile = "«folder»src-gen/html/diagrams/" + file.getName().replace(".model", "") + "/" +
									"«roots.get(0).name»_" + file.getName().replace(".model", ".svg");
								String pngfile = "«folder»src-gen/html/diagrams/" + file.getName().replace(".model", "") + "/" +
									"«roots.get(0).name»_" + file.getName().replace(".model", ".png");
								File diagramsfolder = new File("«folder»src-gen/html/diagrams/");
								if (diagramsfolder.exists() != true) {
									diagramsfolder.mkdir();
								}
								File m4folder = new File("«folder»src-gen/html/diagrams/" + 
									file.getName().replace(".model", "") + "/");
								if (m4folder.exists() != true) {
									m4folder.mkdir();
								}
								PrintWriter m4writer = null;
								try {
									m4writer = new PrintWriter(m4file, "UTF-8");
									String[] m4lines = m4text.split("\n");
									for (int i = 0; i < m4lines.length - 1; i++) {
										m4writer.println(m4lines[i]);
									}
									m4writer.print(m4lines[m4lines.length - 1]);
									m4writer.close();
								} catch (UnsupportedEncodingException e) {
									//Reload input
										try {
										model.unload();
										model.load(null);
									} catch (Exception ex) {}
									continue;
								}
								PrintWriter batwriter = null;
								try {
									batwriter = new PrintWriter(batfile, "UTF-8");
									batwriter.println("«rendererUnit»:");
									batwriter.println("cd \\");
									«FOR String rendererFolder : rendererFolders»
										batwriter.println("cd «rendererFolder»");
									«ENDFOR»
									batwriter.println("m4 liblog.m4 " + m4file + " | dpic -v > " + svgfile);
									batwriter.println("cd batik");
									batwriter.println("java -jar batik-rasterizer-1.18.jar -m image/png -d " + pngfile + " " +  svgfile + " 2>&1");
									batwriter.println("exit");
									batwriter.close();
								} catch (UnsupportedEncodingException e) {
									//Reload input
										try {
										model.unload();
										model.load(null);
									} catch (Exception ex) {}
									continue;
								}
								String[] command = {"cmd", "/c", batfile};
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
								//SVGUtils.convert2PNG(svgfile);
								//Reload input
									try {
									model.unload();
									model.load(null);
								} catch (Exception e) {}
								monitor.worked(1);
							}
						}
					}
					// GENERATES svg FILES FROM MUTANTS
					folder = new File("«folder»data/out");
					for (File exercise : folder.listFiles()) {
						if (exercise.isDirectory()) {
							for (File file : exercise.listFiles()) {
								if (file.isFile()) {
									String pathfile = file.getPath();
									if (pathfile.endsWith(".model") == true) {
										String printPathfile = pathfile.replace("\\", "/");
										printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
										monitor.subTask("Rendering image for mutant " + printPathfile);
										Resource model = ModelManager.loadModel(packages, pathfile);
										String m4text = generateCircuitMacrosSpecificacion(packages, model, file.getName());
										String m4file = "«folder»src-gen/html/diagrams/" + exercise.getName() + "/" +
											"«roots.get(0).name»_" + file.getName().replace(".model", ".m4");
										String batfile = "«folder»src-gen/html/diagrams/" + exercise.getName() + "/" +
											"«roots.get(0).name»_" + file.getName().replace(".model", ".bat");
										String svgfile = "«folder»src-gen/html/diagrams/" + exercise.getName() + "/" +
											"«roots.get(0).name»_" + file.getName().replace(".model", ".svg");
										String pngfile = "«folder»src-gen/html/diagrams/" + exercise.getName() + "/" +
											"«roots.get(0).name»_" + file.getName().replace(".model", ".png");
										File diagramsfolder = new File("«folder»src-gen/html/diagrams/");
										if (diagramsfolder.exists() != true) {
											diagramsfolder.mkdir();
										}
										File m4folder = new File("«folder»src-gen/html/diagrams/" + exercise.getName() + "/");
										if (m4folder.exists() != true) {
											m4folder.mkdir();
										}
										PrintWriter m4writer = null;
										try {
											m4writer = new PrintWriter(m4file, "UTF-8");
											String[] m4lines = m4text.split("\n");
											for (int i = 0; i < m4lines.length - 1; i++) {
												m4writer.println(m4lines[i]);
											}
											m4writer.print(m4lines[m4lines.length - 1]);
											m4writer.close();
										} catch (UnsupportedEncodingException e) {
											//Reload input
												try {
												model.unload();
												model.load(null);
											} catch (Exception ex) {}
											continue;
										}
										PrintWriter batwriter = null;
										try {
											batwriter = new PrintWriter(batfile, "UTF-8");
											batwriter.println("«rendererUnit»:");
											batwriter.println("cd \\");
											«FOR String rendererFolder : rendererFolders»
												batwriter.println("cd «rendererFolder»");
											«ENDFOR»
											batwriter.println("m4 liblog.m4 " + m4file + " | dpic -v > " + svgfile);
											batwriter.println("cd batik");
											batwriter.println("java -jar batik-rasterizer-1.18.jar -m image/png -d " + pngfile + " " +  svgfile + " 2>&1");
											batwriter.println("exit");
											batwriter.close();
										} catch (UnsupportedEncodingException e) {
											//Reload input
												try {
												model.unload();
												model.load(null);
											} catch (Exception ex) {}
											continue;
										}
										String command = "cmd.exe /c start " + batfile;
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
										//SVGUtils.convert2PNG(svgfile);
										//Reload input
													try {
											model.unload();
											model.load(null);
										} catch (Exception e) {}
										monitor.worked(1);
									}
								}
								else {
									if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
										File[] filesBlock = file.listFiles();
										for (File fileBlock : filesBlock) {
											try {
												generateGraphs(fileBlock, file.getName(), packages, exercise, projectName, monitor);
											} catch (UnsupportedEncodingException e) {
												continue;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		
			@Override
			public Object execute(ExecutionEvent event) throws ExecutionException {
			try {
				RunMutatorDrawWithProgress runMutatorDrawWithProgress = new RunMutatorDrawWithProgress();
				ProgressMonitorDialog monitor = new ProgressMonitorDialog(activeShell);
				monitor.run(true, true, runMutatorDrawWithProgress);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			}
			
			public void run(IProject project, String filename) {
			       activeDisplay = new Display();
			       activeShell = new Shell(activeDisplay);
				try {
				       execute(null);
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
				//update(project, filename);
			}
		}
	'''
}
