package wodeledu.dsls.generator

import modeldraw.MutatorDraw
import wodel.utils.manager.ModelManager
import wodel.utils.manager.JavaUtils
import org.eclipse.xtext.generator.AbstractGenerator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import java.util.ArrayList
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import wodel.utils.manager.ProjectUtils
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.ResourcesPlugin

class ModelDrawPyCodeGenerator extends AbstractGenerator {
	private String fileName
	private String className
	private List<EPackage> metamodel
	private List<EClass> roots
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
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
	
	def static IProject projectOf(Resource r) {
		val uri = r?.URI
		if (uri !== null && uri.platformResource) {
			val projectName = uri.segment(1) // platform:/resource/<project>/...
			return ResourcesPlugin.workspace.root.getProject(projectName)
		}
		null
	}
	
	def compile(MutatorDraw draw) '''
		//«var IProject project = projectOf(draw.eResource)»
		«{project = project !== null ? project : ProjectUtils.getProject; ""}» 
		//«var String folder = project.getLocation.toFile.getPath.replace("\\", "/") + "/"»
		
		package mutator.«className»;
			
			import java.io.BufferedReader;
			import java.io.File;
			import java.io.FileNotFoundException;
			import java.io.FileReader;
			import java.io.PrintWriter;
			import java.io.IOException;
			import java.io.UnsupportedEncodingException;
			import java.lang.InterruptedException;
			import java.util.Arrays;
			import java.util.ArrayList;
			import java.util.HashMap;
			import java.util.Map;
			import java.util.LinkedHashMap;
			import java.util.List;
			
			import org.eclipse.emf.ecore.EAttribute;
			import org.eclipse.emf.ecore.EClass;
			import org.eclipse.emf.ecore.EEnum;
			import org.eclipse.emf.ecore.EEnumLiteral;
			import org.eclipse.emf.ecore.EObject;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.emf.ecore.EReference;
			import org.eclipse.emf.ecore.EStructuralFeature;
			import org.eclipse.emf.ecore.resource.Resource;
			import org.eclipse.emf.ecore.util.EcoreUtil;
			
			import wodel.utils.exceptions.MetaModelNotFoundException;
			import wodel.utils.exceptions.ModelNotFoundException;
			import wodel.utils.manager.ProjectUtils;
			import wodel.utils.manager.ModelManager;
			import wodel.utils.manager.Py2Code;
			import wodel.utils.manager.DrawUtils.LabelStyle;
			
			import org.eclipse.core.runtime.IProgressMonitor;
				
			import java.lang.reflect.InvocationTargetException;
				
			import org.eclipse.core.commands.AbstractHandler;
			
			import org.eclipse.core.commands.ExecutionEvent;
			import org.eclipse.core.commands.ExecutionException;
				
			import org.eclipse.core.resources.IProject;
				
			import org.eclipse.jface.dialogs.ProgressMonitorDialog;
			import org.eclipse.jface.operation.IRunnableWithProgress;
				
			import org.eclipse.swt.widgets.Display;
			import org.eclipse.swt.widgets.Shell;
			
			import org.jsoup.Jsoup;
			import org.jsoup.nodes.Document;
				
			public class «className»Draw extends AbstractHandler implements wodeledu.extension.run.commands.IMutatorDraw {
					
				private class RunMutatorPyCodeWithProgress implements IRunnableWithProgress {
				
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
					
			public void generate(IProgressMonitor monitor) throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {
									
				String metamodel = "«ModelManager.getMetaModel().replace("\\", "/")»";
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
									
				List<String> models = ModelManager.getModels(«className»Draw.class);
				List<String> mutants = ModelManager.getMutants(«className»Draw.class);
													
				int totalTasks = models.size() + mutants.size();
		
				monitor.beginTask("Rendering models", totalTasks);
				
				// GENERATES Py code programs FROM SOURCE MODELS
				File folder = new File("«folder»data/model");
				for (File file : folder.listFiles()) {
					if (file.isFile()) {
						String pathfile = file.getPath();
						if (pathfile.endsWith(".model") == true) {
							String printPathfile = pathfile.replace("\\", "/");
							printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/«project.name»/") + ("/«project.name»/").length(), printPathfile.length());
							monitor.subTask("Generating python code for mutant" + printPathfile);
							Resource model = ModelManager.loadModel(packages, pathfile);
							String path = file.getName().replace(".model", "") + "/";
							String pycodefile = "«folder»src-gen/html/code/" + 
								path + 
								"«roots.get(0).name»_" + file.getName().replace(".model", ".py");
							String htmlfile = "«folder»src-gen/html/code/" + 
								path + 
								"«roots.get(0).name»_" + file.getName().replace(".model", ".html");
							String batfile = "«folder»src-gen/html/code/" + 
								path + 
								"«roots.get(0).name»_" + file.getName().replace(".model", ".bat");
							File pyfolder = new File("«folder»src-gen/html/code/" + 
								path);
							if (pyfolder.exists() != true) {
								pyfolder.mkdirs();
							}
							PrintWriter pywriter = null;
							try {
								pywriter = new PrintWriter(pycodefile, "UTF-8");
								String program = Py2Code.toPython(ModelManager.getRoot(model));
								pywriter.println(program);
								pywriter.close();
							} catch (UnsupportedEncodingException e) {
								//Reload input
								try {
									model.unload();
									model.load(null);
								} catch (Exception ex) {
								}
								continue;
							}
							PrintWriter batwriter = null;
							try {
								batwriter = new PrintWriter(batfile, "UTF-8");
								batwriter.println("cd \\");
								batwriter.println("cd «folder»src-gen/html/code/" + file.getName().replace(".model", "") + "/");
								batwriter.println("pygmentize -O full,style=emacs,linenos=1 -o «roots.get(0).name»_" + file.getName().replace(".model", ".html") + " «roots.get(0).name»_" + file.getName().replace(".model", ".py"));
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
							BufferedReader br = new BufferedReader(new FileReader(htmlfile));
							Document doc = null; 
							try {
							    StringBuilder sb = new StringBuilder();
							    String line = br.readLine();
							
							    while (line != null) {
							        sb.append(line);
							        sb.append(System.lineSeparator());
							        line = br.readLine();
							    }
							    String html = sb.toString();
							    doc = Jsoup.parse(html);
							} catch (Exception e) {
								//Reload input
								try {
									model.unload();
									model.load(null);
								} catch (Exception ex) {
								}
								continue;
							} finally {
								try {
									br.close();
							    } catch (IOException e) {
							    	// TODO Auto-generated catch block
							    	e.printStackTrace();
							    }
							}
							PrintWriter htmlwriter = null;
							//try {
								//htmlwriter = new PrintWriter(htmlfile, "UTF-8");
								//htmlwriter.println(doc.toString());
								//htmlwriter.close();
							//} catch (UnsupportedEncodingException e) {
								//Reload input
								//try {
									//model.unload();
									//model.load(null);
								//} catch (Exception ex) {
								//}
								//continue;
							//}
							
							//Reload input
							try {
								model.unload();
								model.load(null);
							} catch (Exception e) {
							}
							monitor.worked(1);
						}
					}
				}
							
							
		// GENERATES Python Code FROM MUTANTS
		folder = new File("«folder»data/out");
		for (File exercise : folder.listFiles()) {
			if (exercise.isDirectory()) {
				for (File file : exercise.listFiles()) {
					if (file.isFile()) {
						String pathfile = file.getPath();
						if (pathfile.endsWith(".model") == true) {
							String printPathfile = pathfile.replace("\\", "/");
							printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/«project.name»/") + ("/«project.name»/").length(), printPathfile.length());
							monitor.subTask("Generating python code for mutant " + printPathfile);
							Resource model = ModelManager.loadModel(packages, pathfile);
							String path = exercise.getName() + "/";
							String pycodefile = "«folder»src-gen/html/code/" + path +
								"«roots.get(0).name»_" + file.getName().replace(".model", ".py");
							String htmlfile = "«folder»src-gen/html/code/" + path +
								"«roots.get(0).name»_" + file.getName().replace(".model", ".html");
							String batfile = "«folder»src-gen/html/code/" + path + "«roots.get(0).name»_" + file.getName().replace(".model", ".bat");
							File pyfolder = new File("«folder»src-gen/html/code/" + path);
							if (pyfolder.exists() != true) {
								pyfolder.mkdirs();
							}
							PrintWriter pywriter = null;
							try {
								pywriter = new PrintWriter(pycodefile, "UTF-8");
								String program = Py2Code.toPython(ModelManager.getRoot(model));
								pywriter.println(program);
								pywriter.close();
							} catch (UnsupportedEncodingException e) {
								//Reload input
								try {
									model.unload();
									model.load(null);
								} catch (Exception ex) {
								}
								continue;
							}
							PrintWriter batwriter = null;
							try {
								batwriter = new PrintWriter(batfile, "UTF-8");
								batwriter.println("cd \\");
								batwriter.println("cd «folder»src-gen/html/code/" + exercise.getName() + "/");
								batwriter.println("pygmentize -O full,style=emacs,linenos=1 -o «roots.get(0).name»_" + file.getName().replace(".model", ".html") + " «roots.get(0).name»_" + file.getName().replace(".model", ".py"));
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
							
							BufferedReader br = new BufferedReader(new FileReader(htmlfile));
							Document doc = null; 
							try {
							    StringBuilder sb = new StringBuilder();
							    String line = br.readLine();
							
							    while (line != null) {
							        sb.append(line);
							        sb.append(System.lineSeparator());
							        line = br.readLine();
							    }
							    String html = sb.toString();
							    doc = Jsoup.parse(html);
							} catch (Exception e) {
								//Reload input
								try {
									model.unload();
									model.load(null);
								} catch (Exception ex) {
								}
								continue;
							} finally {
							    try {
									br.close();
							    } catch (IOException e) {
							    	// TODO Auto-generated catch block
							    	e.printStackTrace();
							    }
							}
							PrintWriter htmlwriter = null;
							//try {
								//htmlwriter = new PrintWriter(htmlfile, "UTF-8");
								//htmlwriter.println(doc.toString());
								//htmlwriter.close();
							//} catch (UnsupportedEncodingException e) {
								//Reload input
								//try {
									//model.unload();
									//model.load(null);
								//} catch (Exception ex) {
								//}
								//continue;
							//}
							//Reload input
							try {
								model.unload();
								model.load(null);
							} catch (Exception e) {
							}
							monitor.worked(1);
						}
						else {
							if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
								File[] filesBlock = file.listFiles();
								for (File fileBlock : filesBlock) {
									generatePyCode(fileBlock, packages, exercise, monitor);
								}
							}
						}
					}
					else {
						if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
							File[] filesBlock = file.listFiles();
							for (File fileBlock : filesBlock) {
								generatePyCode(fileBlock, packages, exercise, monitor);
							}
						}
					}
				}
			}
		}
		}
	}
		public void generatePyCode(File file, List<EPackage> packages, File exercise, IProgressMonitor monitor) throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {
			if (file.isFile()) {
				String pathfile = file.getPath();
				if (pathfile.endsWith(".model") == true) {
					String printPathfile = pathfile.replace("\\", "/");
					printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/«project.name»/") + ("/«project.name»/").length(), printPathfile.length());
					monitor.subTask("Generating python code for mutant " + printPathfile);
					Resource model = ModelManager.loadModel(packages, pathfile);
					String path = file.getParent().replace("\\", "/").substring("«folder»data/out".length()) + "/";
					String pycodefile = "«folder»src-gen/html/code/" + path + "«roots.get(0).name»_" + file.getName().replace(".model", ".py");
					String htmlfile = "«folder»src-gen/html/code/" + path + "«roots.get(0).name»_" + file.getName().replace(".model", ".html");
					String batfile = "«folder»src-gen/html/code/" + path + "«roots.get(0).name»_" + file.getName().replace(".model", ".bat");
					File exercisefolder = new File("«folder»src-gen/html/code/" + path);
					if (exercisefolder.exists() != true) {
						exercisefolder.mkdirs();
					}
					PrintWriter pywriter = null;
					try {
						pywriter = new PrintWriter(pycodefile, "UTF-8");
						String program = Py2Code.toPython(ModelManager.getRoot(model));
						pywriter.println(program);
						pywriter.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					PrintWriter batwriter = null;
					try {
						batwriter = new PrintWriter(batfile, "UTF-8");
						batwriter.println("cd \\");
						batwriter.println("cd «folder»src-gen/html/code/" + path);
						batwriter.println("pygmentize -O full,style=emacs,linenos=1 -o «roots.get(0).name»_" + file.getName().replace(".model", ".html") + " «roots.get(0).name»_" + file.getName().replace(".model", ".py"));
						batwriter.println("exit");
						batwriter.close();
					} catch (UnsupportedEncodingException e) {
						//Reload input
						try {
							model.unload();
							model.load(null);
						} catch (Exception ex) {}
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
					BufferedReader br = new BufferedReader(new FileReader(htmlfile));
					Document doc = null; 
					try {
						StringBuilder sb = new StringBuilder();
						String line = br.readLine();
						while (line != null) {
							sb.append(line);
							sb.append(System.lineSeparator());
							line = br.readLine();
						}
						String html = sb.toString();
						doc = Jsoup.parse(html);
					} catch (Exception e) {
						//Reload input
						try {
							model.unload();
							model.load(null);
						} catch (Exception ex) {
						}
					} finally {
						try {
							br.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					PrintWriter htmlwriter = null;
					//try {
						//htmlwriter = new PrintWriter(htmlfile, "UTF-8");
						//htmlwriter.println(doc.toString());
						//htmlwriter.close();
					//} catch (UnsupportedEncodingException e) {
						//Reload input
						//try {
							//model.unload();
							//model.load(null);
						//} catch (Exception ex) {
						//}
					//}
					try {
						model.unload();
						model.load(null);
					} catch (Exception e) {
					}
					monitor.worked(1);
				}
			}
			else {
				generatePyCodeRecursive(file, packages, exercise, monitor);
			}
		}
		
		private void generatePyCodeRecursive(File file, List<EPackage> packages, File exercise, IProgressMonitor monitor) throws FileNotFoundException, MetaModelNotFoundException, ModelNotFoundException {
			if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
				File[] filesInBlock = file.listFiles();
				if (filesInBlock != null && filesInBlock.length > 0) {
					for (File fileInBlock : filesInBlock) {
						if (fileInBlock.isFile()) {
							generatePyCode(fileInBlock, packages, exercise, monitor);
						}
						else {
							generatePyCodeRecursive(fileInBlock, packages, exercise, monitor);
						}
					}
				}
			}
		}
		
		@Override
		public Object execute(ExecutionEvent event) throws ExecutionException {
			try {
				RunMutatorPyCodeWithProgress runMutatorPyCodeWithProgress = new RunMutatorPyCodeWithProgress();
				ProgressMonitorDialog monitor = new ProgressMonitorDialog(new Shell(new Display()));
				monitor.run(true, true, runMutatorPyCodeWithProgress);
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		@Override
		public void run() {
			try {
				execute(null);
			}
			catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	'''
}