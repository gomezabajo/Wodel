package wodeledu.dsls.generator.modeldraw

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import modeldraw.MutatorDraw
import wodel.utils.manager.ModelManager
import wodel.utils.manager.JavaUtils
import org.eclipse.core.resources.IProject
import wodel.utils.manager.ProjectUtils
import modeldraw.Node
import org.eclipse.xtext.generator.AbstractGenerator
import modeldraw.NodeStyle
import modeldraw.ValuedFeature
import modeldraw.MutatorInstance
import modeldraw.Edge
import modeldraw.Relation
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import java.util.ArrayList

/**
 * @author Pablo Gomez-Abajo - modelDraw dot code generator.
 * 
 * Generates the Java code for the graphical
 * representation of the models. PlantUML mode.
 *  
 */
class ModelDrawPlantUMLGenerator extends AbstractGenerator {
	
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

	def generate(MutatorDraw draw, String folder, int index) '''
		Set<String> umlcode = new LinkedHashSet<String>();
		«IF draw.instances.get(index).nodes !== null»
		«IF draw.instances.get(index).nodes.size() > 0»
		generateUMLNodes(packages, model, umlnodes, umlrels, id);
		«ENDIF»
		«ENDIF»
		umlcode.add("@startuml");
		umlcode.add("skinparam classAttributeIconSize 0");
		Set<String> rels = new LinkedHashSet<String>();
		for (EObject umlnode : umlnodes.get(«index»).keySet()) {
			if (umlnodes.get(«index»).get(umlnode) != null) {
				for (LabelStyle label : umlnodes.get(«index»).get(umlnode)) {
					umlcode.add((label.label.replaceAll("'", "") + " " + label.name.replaceAll("'", "")).trim());
				}
			}
		}
		«IF draw.instances.get(index).relations !== null»
		«IF draw.instances.get(index).relations.size() > 0»
		generateUMLEdges(packages, model, umlnodes, umlrels, id);
		«ENDIF»
		«ENDIF»
		for (EObject umlrel : umlrels.get(«index»).keySet()) {
			if (umlrels.get(«index»).get(umlrel) != null) {
				for (String key : umlrels.get(«index»).get(umlrel).keySet()) {
					for (LabelStyle value : umlrels.get(«index»).get(umlrel).get(key)) {
						rels.add((key.replaceAll("'", "") + " " + value.style + " " + value.name.replaceAll("'", "")).trim());
					}
				}
			}
		}
		for (String rel : rels) {
			umlcode.add(rel);
		}
		umlcode.add("@enduml");
	'''
	
	def compile(MutatorDraw draw) '''
	package mutator.«className»;
	
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.IOException;
	import java.io.OutputStream;
	import java.io.PrintWriter;
	import java.io.UnsupportedEncodingException;
	import java.util.List;
	import java.util.ArrayList;
	import java.util.Map;
	import java.util.Arrays;	
	import java.util.HashMap;
	import java.util.LinkedHashMap;
	import java.util.Set;
	import java.util.LinkedHashSet;
		
	import org.eclipse.emf.ecore.EObject;
	import org.eclipse.emf.ecore.EPackage;
	import org.eclipse.emf.ecore.resource.Resource;
	import org.eclipse.emf.ecore.util.EcoreUtil;
	
	import org.eclipse.core.resources.IProject;
	
	import net.sourceforge.plantuml.SourceStringReader;
	import wodel.utils.exceptions.MetaModelNotFoundException;
	import wodel.utils.exceptions.ModelNotFoundException;
	import wodel.utils.exceptions.ReferenceNonExistingException;
	import wodel.utils.manager.ProjectUtils;
	import wodel.utils.manager.ModelManager;
	import wodel.utils.manager.DrawUtils.LabelStyle;
	
	import net.sourceforge.plantuml.GeneratedImage;
	import net.sourceforge.plantuml.SourceFileReader;
	
	import org.eclipse.core.runtime.IProgressMonitor;
		
	import org.eclipse.jface.operation.IRunnableWithProgress;
			
	import java.lang.reflect.InvocationTargetException;
			
	import org.eclipse.core.commands.AbstractHandler;
		
	import org.eclipse.core.commands.ExecutionEvent;
	import org.eclipse.core.commands.ExecutionException;
		
	import org.eclipse.jface.dialogs.ProgressMonitorDialog;
	import org.eclipse.jface.operation.IRunnableWithProgress;
		
	import org.eclipse.swt.widgets.Display;
	import org.eclipse.swt.widgets.Shell;
	
	
	public class «className»Draw extends AbstractHandler implements wodeledu.extension.run.commands.IMutatorDraw {
		
		private Display activeDisplay = null;
		private Shell activeShell = null;
		
		private String getOrdinalFor(int value) {
			int hundredRemainder = value % 100;
			int tenRemainder = value % 10;
			if (hundredRemainder - tenRemainder == 10) {
				return value + "th";
			}
		
			switch (tenRemainder) {
				case 1:
					return value + "st";
				case 2:
					return value + "nd";
				case 3:
					return value + "rd";
				default:
					return value + "th";
			}
		}
		
		private Set<EObject> getSuperClasses(EObject cl) {
			Set<EObject> superclasses = new LinkedHashSet<EObject>();
			try {
				Object ob = ModelManager.getReferences("superclass", cl);
				if (ob instanceof List<?>) {
					superclasses.addAll((List<EObject>) ob);
				}
				for (EObject supercl : superclasses) {
					Set<EObject> supsuperclasses = getSuperClasses(supercl);
					superclasses.addAll(supsuperclasses);
				}
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return superclasses;
		}
		
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
			
   			«var String folder = ProjectUtils.getProject.getLocation.toFile.getPath.replace("\\", "/") + "/"»
			private void generateUMLNodes(List<EPackage> packages, Resource model, Map<Integer, Map<EObject, List<LabelStyle>>> umlnodes, Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels, Map<String, Integer> id) {
				// COUNTER: «var int counter = 0»
				Map<EObject, List<LabelStyle>> localnodes = null;
				Map<EObject, Map<String, List<LabelStyle>>> localrels = null;
			
				int i = 0;
				int j = 0;
				«FOR MutatorInstance instance : draw.instances»
				if (umlnodes.get(«counter») == null) {			
					localnodes = new LinkedHashMap<EObject, List<LabelStyle>>();
				}
				else {
					localnodes = new LinkedHashMap<EObject, List<LabelStyle>>(umlnodes.get(«counter»));
				}
				umlnodes.put(«counter», localnodes);
				if (umlrels.get(«counter») == null) {
					localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>();
				}
				else {
					localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>(umlrels.get(«counter»));
				}
				umlrels.put(«counter», localrels);

				«IF draw.instances.get(counter).nodes !== null»
				«IF draw.instances.get(counter).nodes.size() > 0»
				try {
				Map<String, List<LabelStyle>> rels = new LinkedHashMap<String, List<LabelStyle>>();
				// COUNTER: «var int counter2 = 0»
				«FOR Node node : draw.instances.get(counter).nodes»
				i = 0;
				List<EObject> lnode_«counter»_«counter2» = ModelManager.getObjectsOfType("«node.name.name»", model);
				for (EObject node : lnode_«counter»_«counter2») {
					String name = ModelManager.getStringAttribute("name", node);
					String typeName = node.eClass().getName();
					LabelStyle label = new LabelStyle();
					«IF node.name.name.equals("Class")»
					label.label = "«node.name.name.toLowerCase()»";
					label.name = name;
					«ELSEIF node.name.name.equals("Object")»
					Object o = ModelManager.getReferences("class", node);
					EObject cl = null;
					if (o instanceof List<?>) {
						cl = ((List<EObject>) o).get(0);
					}
					label.label = "«node.name.name.toLowerCase()»";
					label.name = "\"" + name + " :<u>" + ModelManager.getStringAttribute("name", cl) + "</u>\" as " + getOrdinalFor(i);
					id.put(ModelManager.getURIEnding(node), i);
					i++;
					«ENDIF»
					«IF node.feature !== null»
					boolean value = false;
					«FOR ValuedFeature feature : node.feature»
					«IF feature.feat.EType.name.equals("EBoolean")»
					value = ModelManager.getBooleanAttribute("«feature.feat.name»", node);
					if (value == true) {
						«IF node.style == NodeStyle.ITALIC»
						label.label = "«feature.feat.name»";
						«ENDIF»
					}
					«ENDIF»
					«ENDFOR»
					«ENDIF»
					List<LabelStyle> labelList = new ArrayList<LabelStyle>();
					if (localnodes.get(node) != null) {
						labelList = localnodes.get(node);
					}
					labelList.add(label);
					localnodes.put(node, labelList);
					Object noderels = ModelManager.getReferences("superclass", node);
					if (noderels instanceof List<?>) {
						for (EObject nnode : (List<EObject>) noderels) {
							String rel = ModelManager.getStringAttribute("name", nnode);
							List<LabelStyle> values = new ArrayList<LabelStyle>();
							if (rels.get(rel) != null) {
								values = rels.get(rel);
							}
							label = new LabelStyle();
							label.name = name;
							label.style = "<|--";
							values.add(label);
							rels.put(rel, values);
						}
						localrels.put(node, rels);
					}
				}
				j = 0;
				for (EObject node : lnode_«counter»_«counter2») {
					String name = ModelManager.getStringAttribute("name", node);
					String typeName = node.eClass().getName();
					«IF node.name.name.equals("Class")»
					Object obj = ModelManager.getReferences("ownedAttributes", node);
					List<EObject> attributes = null;
					if (obj instanceof List<?>) {
						attributes = (List<EObject>) obj;
					}
					for (EObject att : attributes) {
						String attName = "";
						if (att != null) {
							attName = ModelManager.getStringAttribute("name", att);
						}
						Object obj2 = ModelManager.getReferences("type", att);
						EObject type = null;
						if (obj2 instanceof List<?>) {
							type = ((List<EObject>) obj2).get(0);
						}
						typeName = "";
						if (type != null) {
							typeName = ModelManager.getStringAttribute("name", type);
						}
						if (attName.length() > 0 && typeName.length() > 0) {
							LabelStyle label = new LabelStyle();
							label.label = "";
							label.name = name + " : -" + attName + " : " + typeName;
							List<LabelStyle> labelList = new ArrayList<LabelStyle>();
							if (localnodes.get(node) != null) {
								labelList = localnodes.get(node);
							}
							labelList.add(label);
							localnodes.put(node, labelList);
						}
					}
					«ENDIF»
					«IF node.name.name.equals("Object")»
					Object o = ModelManager.getReferences("class", node);
					EObject cl = null;
					if (o instanceof List<?>) {
						cl = ((List<EObject>) o).get(0);
					}
					Object obj = ModelManager.getListStringAttribute("ownedAttributeValues", node);
					List<String> attValues = null;
					if (obj instanceof List<?>) {
						attValues = (List<String>) obj;
					}
					Object ob = ModelManager.getReferences("ownedAttributes", cl);
					Set<EObject> attributes = new LinkedHashSet<EObject>();
					if (ob instanceof List<?>) {
						attributes.addAll((List<EObject>) ob);
					}
					Set<EObject> superclasses = getSuperClasses(cl);
					for (EObject supercl : superclasses) {
						ob = ModelManager.getReferences("ownedAttributes", supercl);
						if (ob instanceof List<?>) {
							attributes.addAll((List<EObject>) ob);
						}
					}
					int k = 0;
					for (EObject att : attributes) {
						String attName = "";
						if (att != null) {
							attName = ModelManager.getStringAttribute("name", att);
						}
						Object obj2 = ModelManager.getReferences("type", att);
						EObject type = null;
						if (obj2 instanceof List<?>) {
							type = ((List<EObject>) obj2).get(0);
						}
						typeName = "";
						if (type != null) {
							typeName = ModelManager.getStringAttribute("name", type);
						}
						String quote = "";
						if (typeName.equals("String")) {
							quote = "\"";
						}
						if (attName.length() > 0 && typeName.length() > 0) {
							LabelStyle label = new LabelStyle();
							label.label = "";
							label.name = getOrdinalFor(j) + " : -" + attName + " = " + quote + attValues.get(k) + quote;
							List<LabelStyle> labelList = new ArrayList<LabelStyle>();
							if (localnodes.get(node) != null) {
								labelList = localnodes.get(node);
							}
							labelList.add(label);
							localnodes.put(node, labelList);
						}
						k++;
					}
					j++;
					«ENDIF»
				}
				// INC COUNTER: «counter2++»
				«ENDFOR»
				} catch (ReferenceNonExistingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			«ENDIF»
			«ENDIF»
			// INC COUNTER: «counter++»
			«ENDFOR»
			}
		
			private void generateUMLEdges(List<EPackage> packages, Resource model, Map<Integer, Map<EObject, List<LabelStyle>>> umlnodes, Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels, Map<String, Integer> id) {
				// COUNTER: «counter = 0»
				Map<EObject, Map<String, List<LabelStyle>>> localrels = null;
				int i = 0;
				«FOR MutatorInstance instance : draw.instances»			
				if (umlrels.get(«counter») == null) {
					localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>();
				}
				else {
					localrels = new LinkedHashMap<EObject, Map<String, List<LabelStyle>>>(umlrels.get(«counter»));
				}
				umlrels.put(«counter», localrels);
				//«var boolean needsTryCatch = false»
				//«var boolean needsRels = true»
				//«var boolean needsO = true»
				//«var boolean needsSrc = true»
				//«var boolean needsTar = true»
				«IF draw.instances.get(counter).relations !== null»
				«IF draw.instances.get(counter).relations.size() > 0»
				«FOR Relation rel : draw.instances.get(counter).relations»
				«IF rel instanceof Edge»
				//«var Edge edge = rel as Edge»
				«IF edge.name.name.equals("ClassAssociation") || edge.name.name.equals("ClassAggregation") || edge.name.name.equals("ClassComposition") 
				|| edge.name.name.equals("ObjectAssociation") || edge.name.name.equals("ObjectAggregation") || edge.name.name.equals("ObjectComposition")»
				«IF edge.source !== null && edge.target !== null»
				«{needsTryCatch = true; ""}»
				«ENDIF»
				«ENDIF»
				«ENDIF»
				«ENDFOR»
				«ENDIF»
				«ENDIF»

				«IF draw.instances.get(counter).relations !== null»
				«IF draw.instances.get(counter).relations.size() > 0»
				«IF needsTryCatch == true»
				try {
				«ELSE»
				{
				«ENDIF»
				«IF needsRels == true»
				Map<String, List<LabelStyle>> rels = null;
				«{needsRels = false; ""}»
				«ELSE»
				rels = null;
				«ENDIF»
				«IF needsO == true»
				Object o = null;
				«{needsO = false; ""}»
				«ELSE»
				o = null;
				«ENDIF»
				«IF needsSrc == true»
				EObject src = null;
				«{needsSrc = false; ""}»
				«ELSE»
				src = null;
				«ENDIF»
				«IF needsTar == true»
				EObject tar = null;
				«{needsTar = false; ""}»
				«ELSE»
				tar = null;
				«ENDIF»
				// COUNTER: «var int counter2 = 0»
				«FOR Relation rel : draw.instances.get(counter).relations»
				«IF rel instanceof Edge»
				//«var Edge edge = rel as Edge»
				List<EObject> ledge_«counter»_«counter2» = ModelManager.getObjectsOfType("«edge.name.name»", model);
				i = 0;
				for (EObject edge : ledge_«counter»_«counter2») {
					if (localrels.get(edge) == null) {
						rels = new LinkedHashMap<String, List<LabelStyle>>();
					}
					else {
						rels = new LinkedHashMap<String, List<LabelStyle>>(localrels.get(edge));
					}
					String typeName = edge.eClass().getName();
					String src_label = "";
					String tar_label = "";
					«IF edge.name.name.equals("ClassAssociation") || edge.name.name.equals("ClassAggregation") || edge.name.name.equals("ClassComposition")»
					«IF edge.source !== null && edge.target !== null»
					«IF edge.name.name.equals("ClassAssociation")»
					String ref = "source";
					«ELSEIF edge.name.name.equals("ClassAggregation")»
					String ref = "source";
					«ELSEIF edge.name.name.equals("ClassComposition")»
					String ref = "constituent";
					«ENDIF»
					o = ModelManager.getReferences(ref, edge);
					src = null;
					if (o instanceof List<?>) {
						src = ((List<EObject>) o).get(0);
					}
					«IF edge.name.name.equals("ClassAssociation")»
					ref = "target";
					«ELSEIF edge.name.name.equals("ClassAggregation")»
					ref = "target";
					«ELSEIF edge.name.name.equals("ClassComposition")»
					ref = "composite";
					«ENDIF»
					o = ModelManager.getReferences(ref, edge);
					tar = null;
					if (o instanceof List<?>) {
						tar = ((List<EObject>) o).get(0);
					}
					if (src != null && tar != null) {
						String multiplicitySource = ModelManager.getStringAttribute("multiplicitySource", edge);
						if (multiplicitySource == null || multiplicitySource.equals("1")) {
							multiplicitySource = "";
						}
						String multiplicityTarget = ModelManager.getStringAttribute("multiplicityTarget", edge);
						if (multiplicityTarget == null || multiplicityTarget.equals("1")) {
							multiplicityTarget = "";
						}
						src_label = ModelManager.getStringAttribute("name", src);
						tar_label = ModelManager.getStringAttribute("name", tar);
						List<LabelStyle> target = new ArrayList<LabelStyle>();
						if (rels.get(src_label) != null) {
							target = rels.get(src_label);
						}
						LabelStyle tar_lbl = new LabelStyle();
						tar_lbl.name = tar_label;
					«IF edge.name.name.equals("ClassAssociation")»
						tar_lbl.style = (multiplicitySource.length() > 0 ? " \"" + multiplicitySource + "\" " : "") + "<-->" + (multiplicityTarget.length() > 0 ? "\" " + multiplicityTarget + "\" " : "");
					«ELSEIF edge.name.name.equals("ClassAggregation")»
						tar_lbl.style = (multiplicitySource.length() > 0 ? " \"" + multiplicitySource + "\" " : "") + "o-->" + (multiplicityTarget.length() > 0 ? "\" " + multiplicityTarget + "\" " : "");
					«ELSEIF edge.name.name.equals("ClassComposition")»
						tar_lbl.style = (multiplicitySource.length() > 0 ? " \"" + multiplicitySource + "\" " : "") + "*-->" + (multiplicityTarget.length() > 0 ? "\" " + multiplicityTarget + "\" " : "");
					«ENDIF»
						target.add(tar_lbl);
						rels.put(src_label, target);
					}
					«ENDIF»
					«ENDIF»
					«IF edge.name.name.equals("ObjectAssociation") || edge.name.name.equals("ObjectAggregation") || edge.name.name.equals("ObjectComposition")»
					«IF edge.source !== null && edge.target !== null»
					«IF edge.name.name.equals("ObjectAssociation")»
					String ref = "source";
					«ELSEIF edge.name.name.equals("ObjectAggregation")»
					String ref = "source";
					«ELSEIF edge.name.name.equals("ObjectComposition")»
					String ref = "constituent";
					«ENDIF»
					o = ModelManager.getReferences(ref, edge);
					src = null;
					if (o instanceof List<?>) {
						src = ((List<EObject>) o).get(0);
					}
					«IF edge.name.name.equals("ObjectAssociation")»
					ref = "target";
					«ELSEIF edge.name.name.equals("ObjectAggregation")»
					ref = "target";
					«ELSEIF edge.name.name.equals("ObjectComposition")»
					ref = "composite";
					«ENDIF»
					o = ModelManager.getReferences(ref, edge);
					tar = null;
					if (o instanceof List<?>) {
						tar = ((List<EObject>) o).get(0);
					}
					if (src != null && tar != null) {
						String multiplicitySource = ModelManager.getStringAttribute("multiplicitySource", edge);
						if (multiplicitySource == null || multiplicitySource.equals("1")) {
							multiplicitySource = "";
						}
						String multiplicityTarget = ModelManager.getStringAttribute("multiplicityTarget", edge);
						if (multiplicityTarget == null || multiplicityTarget.equals("1")) {
							multiplicityTarget = "";
						}
						src_label = getOrdinalFor(id.get(ModelManager.getURIEnding(src)));
						tar_label = getOrdinalFor(id.get(ModelManager.getURIEnding(tar)));
						List<LabelStyle> target = new ArrayList<LabelStyle>();
						if (rels.get(src_label) != null) {
							target = rels.get(src_label);
						}
						LabelStyle tar_lbl = new LabelStyle();
						tar_lbl.name = tar_label;
						tar_lbl.style = (multiplicitySource.length() > 0 ? " \"" + multiplicitySource + "\" " : "") + "--" + (multiplicityTarget.length() > 0 ? "\" " + multiplicityTarget + "\" " : "");
						target.add(tar_lbl);
						rels.put(src_label, target);
					}
					«ENDIF»
					«ENDIF»
					localrels.put(edge, rels);
					i++;
				}
					«ENDIF»
					// INC COUNTER: «counter2++»
					«ENDFOR»
					«IF needsTryCatch == true»
				} catch (ReferenceNonExistingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				«ELSE»
				}
					«ENDIF»
					«ENDIF»
					«ENDIF»
			// INC COUNTER: «counter++»
			«ENDFOR»
			}
	
			public  void generateUMLGraphs(File file, String folder, List<EPackage> packages, File exercise, String projectName, IProgressMonitor monitor) throws ModelNotFoundException, FileNotFoundException, UnsupportedEncodingException {
			//«counter = 1»
			«FOR MutatorInstance instance : draw.instances»			
				if (file.isFile()) {
					String pathfile = file.getPath();
					if (pathfile.endsWith(".model") == true) {
						String printPathfile = pathfile.replace("\\", "/");
						printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
						«IF roots !== null && roots.size() > counter»
						monitor.subTask("Rendering image for mutant " + printPathfile + " («roots.get(counter).name»)");
						Resource model = ModelManager.loadModel(packages, pathfile);
						String path = exercise.getName() + "/" + folder;
						String umlfile = "«folder»src-gen/html/diagrams/" + 
							path + "/«roots.get(counter).name»_" + file.getName().replace(".model", ".txt");
						Map<Integer, Map<EObject, List<LabelStyle>>> umlnodes = new LinkedHashMap<Integer, Map<EObject, List<LabelStyle>>>();
						Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels = new LinkedHashMap<Integer, Map<EObject, Map<String, List<LabelStyle>>>>();
						Map<String, Integer> id = new LinkedHashMap<String, Integer>();
						«draw.generate(folder, counter - 1)»
						File diagramsfolder = new File("«folder»src-gen/html/diagrams/");
						if (diagramsfolder.exists() != true) {
							diagramsfolder.mkdirs();
						}
						File exercisefolder = new File("«folder»src-gen/html/diagrams/" + path + "/");
						if (exercisefolder.exists() != true) {
							exercisefolder.mkdirs();
						}
						PrintWriter umlwriter = new PrintWriter(umlfile, "UTF-8");
						for (String umlline : umlcode) {
							umlwriter.println(umlline);
						}
						umlwriter.close();
						try {
							SourceFileReader reader = new SourceFileReader(new File(umlfile));
							List<GeneratedImage> list = reader.getGeneratedImages();
							File umlpng = list.get(0).getPngFile();
							umlpng.createNewFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//Reload input
						try {
							model.unload();
							model.load(null);
						} catch (Exception e) {}
						monitor.worked(1);
						«ENDIF»
					}
				}
				else {
					if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
						File[] filesBlock = file.listFiles();
						for (File fileBlock : filesBlock) {
							generateUMLGraphs(fileBlock, folder + file.getName(), packages, exercise, projectName, monitor);
						}
					}
				}
			//«counter ++»
			«ENDFOR»
			}
				
			public void generate(IProgressMonitor monitor) throws MetaModelNotFoundException, ModelNotFoundException, FileNotFoundException {
				
				String metamodel = "«ModelManager.getMetaModel().replace("\\", "/")»";
				List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
				String projectName = ProjectUtils.getProject().getName();
				List<String> models = ModelManager.getModels();
				List<String> mutants = ModelManager.getMutants();
								
				int totalTasks = (models.size() + mutants.size()) * «draw.instances.size()»;
							
				monitor.beginTask("Rendering models", totalTasks);

				// GENERATES PNG FILES FROM SOURCE MODELS
				File folder = new File("«folder»data/model");
				for (File file : folder.listFiles()) {
				//«counter = 1»
				«FOR MutatorInstance instance : draw.instances»			
					if (file.isFile()) {
						String pathfile = file.getPath();
						if (pathfile.endsWith(".model") == true) {
							String printPathfile = pathfile.replace("\\", "/");
							printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
							«IF roots !== null && roots.size() > counter»
							monitor.subTask("Rendering image for model " + printPathfile + " («roots.get(counter).name»)");
							Resource model = ModelManager.loadModel(packages, pathfile);
							String umlfile = "«folder»src-gen/html/diagrams/" + 
								file.getName().replace(".model", "") + "/" +
								"«roots.get(counter).name»_" + file.getName().replace(".model", ".txt");
							Map<Integer, Map<EObject, List<LabelStyle>>> umlnodes = new LinkedHashMap<Integer, Map<EObject, List<LabelStyle>>>();
							Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels = new LinkedHashMap<Integer, Map<EObject, Map<String, List<LabelStyle>>>>();
							Map<String, Integer> id = new LinkedHashMap<String, Integer>();
							«draw.generate(folder, counter - 1)»
							File diagramsfolder = new File("«folder»src-gen/html/diagrams/");
							if (diagramsfolder.exists() != true) {
								diagramsfolder.mkdirs();
							}
							File umlfolder = new File("«folder»src-gen/html/diagrams/" + 
								file.getName().replace(".model", "") + "/");
							if (umlfolder.exists() != true) {
								umlfolder.mkdirs();
							}
							try {
								PrintWriter umlwriter = new PrintWriter(umlfile, "UTF-8");
								for (String umlline : umlcode) {
									umlwriter.println(umlline);
								}
								umlwriter.close();
							} catch (UnsupportedEncodingException e) {
								//Reload input
		    					try {
									model.unload();
									model.load(null);
								} catch (Exception ex) {}
								continue;
							}
							try {
								SourceFileReader reader = new SourceFileReader(new File(umlfile));
								List<GeneratedImage> list = reader.getGeneratedImages();
								File umlpng = list.get(0).getPngFile();
								umlpng.createNewFile();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							//Reload input
							try {
								model.unload();
								model.load(null);
							} catch (Exception e) {}
							monitor.worked(1);
							«ENDIF»
						}
					}
				//«counter ++»
				«ENDFOR»
				}
	
				// GENERATES PNG FILES FROM MUTANTS
				folder = new File("«folder»data/out");
				for (File exercise : folder.listFiles()) {
					if (exercise.isDirectory()) {
						for (File file : exercise.listFiles()) {
						//«counter = 1»
						«FOR MutatorInstance instance : draw.instances»			
							if (file.isFile()) {
								String pathfile = file.getPath();
								if (pathfile.endsWith(".model") == true) {
									String printPathfile = pathfile.replace("\\", "/");
									printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
									«IF roots !== null && roots.size() > counter»
									monitor.subTask("Rendering image for mutant " + printPathfile + " («roots.get(counter).name»)");
									Resource model = ModelManager.loadModel(packages, pathfile);
									String umlfile = "«folder»src-gen/html/diagrams/" + exercise.getName() + "/" +
										"«roots.get(counter).name»_" + file.getName().replace(".model", ".txt");
									Map<Integer, Map<EObject, List<LabelStyle>>> umlnodes = new LinkedHashMap<Integer, Map<EObject, List<LabelStyle>>>();
									Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels = new LinkedHashMap<Integer, Map<EObject, Map<String, List<LabelStyle>>>>();
									Map<String, Integer> id = new LinkedHashMap<String, Integer>();
									«draw.generate(folder, counter - 1)»
									File diagramsfolder = new File("«folder»src-gen/html/diagrams/");
									if (diagramsfolder.exists() != true) {
										diagramsfolder.mkdirs();
									}
									File umlfolder = new File("«folder»src-gen/html/diagrams/" + exercise.getName() + "/");
									if (umlfolder.exists() != true) {
										umlfolder.mkdirs();
									}
									try {
										PrintWriter umlwriter = new PrintWriter(umlfile, "UTF-8");
										for (String umlline : umlcode) {
											umlwriter.println(umlline);
										}
										umlwriter.close();
									} catch (UnsupportedEncodingException e) {
										//Reload input
		    							try {
											model.unload();
											model.load(null);
										} catch (Exception ex) {}
										continue;
									}
									try {
										SourceFileReader reader = new SourceFileReader(new File(umlfile));
										List<GeneratedImage> list = reader.getGeneratedImages();
										File umlpng = list.get(0).getPngFile();
										umlpng.createNewFile();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									//Reload input
									try {
										model.unload();
										model.load(null);
									} catch (Exception e) {}
									monitor.worked(1);
									«ENDIF»
								}
							}
							else {
								if (file.getName().equals("registry") != true && !file.getName().endsWith("vs")) {
									File[] filesBlock = file.listFiles();
									for (File fileBlock : filesBlock) {
										try {
											generateUMLGraphs(fileBlock, file.getName(), packages, exercise, projectName, monitor);
										} catch (UnsupportedEncodingException e) {
											continue;
										}
									}
								}
							}
						//«counter ++»
						«ENDFOR»
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
