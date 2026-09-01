package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import modeldraw.MutatorDraw
import wodel.utils.manager.ModelManager
import wodel.utils.manager.JavaUtils
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
	private def String lastSegment(String value) {
		if (value === null || value.empty) {
			return ""
		}
		val normalized = value.replace("\\", "/")
		val slash = normalized.lastIndexOf("/")
		if (slash >= 0) normalized.substring(slash + 1) else normalized
	}

	private def String javaString(String value) {
		if (value === null) {
			return ""
		}
		value.replace("\\", "\\\\").replace("\"", "\\\"")
	}

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var i = 0
		val baseName = resource.URI.lastSegment.replace(".draw", "").replace(".", "_")
		for(e: resource.allContents.toIterable.filter(MutatorDraw)) {
			fileName = if (i == 0) baseName + "Draw.java" else baseName + i + "Draw.java"
			metamodel = new ArrayList<EPackage>()
			metamodel.addAll(ModelManager.loadMetaModel(e.metamodel))
			roots = new ArrayList<EClass>()
			roots.addAll(ModelManager.getRootEClasses(metamodel))
			className = fileName.replace("Draw.java", "")
     		fsa.generateFile("mutator/" + className + "/" + fileName, JavaUtils.format(e.compile, false))
			i++
		}
	}

	def generate(MutatorDraw draw, int index) '''
		umlcode = new LinkedHashSet<String>();
		«IF draw.instances.get(index).nodes !== null»
			«IF draw.instances.get(index).nodes.size() > 0»
				generateUMLNodes(packages, model, umlnodes, umlrels, id);
			«ENDIF»
		«ENDIF»
		umlcode.add("@startuml");
		umlcode.add("skinparam classAttributeIconSize 0");
		rels = new LinkedHashSet<String>();
		selectedNodes = umlnodes.get(«index»);
		if (selectedNodes != null) {
			for (EObject umlnode : selectedNodes.keySet()) {
				List<LabelStyle> labels = selectedNodes.get(umlnode);
				if (labels != null) {
					for (LabelStyle label : labels) {
						if (label != null && label.label != null && label.name != null) {
							umlcode.add((label.label.replaceAll("'", "") + " " + label.name.replaceAll("'", "")).trim());
						}
					}
				}
			}
		}
		«IF draw.instances.get(index).relations !== null»
			«IF draw.instances.get(index).relations.size() > 0»
				generateUMLEdges(packages, model, umlnodes, umlrels, id);
			«ENDIF»
		«ENDIF»
		selectedRelations = umlrels.get(«index»);
		if (selectedRelations != null) {
			for (EObject umlrel : selectedRelations.keySet()) {
				Map<String, List<LabelStyle>> relationMap = selectedRelations.get(umlrel);
				if (relationMap != null) {
					for (String key : relationMap.keySet()) {
						List<LabelStyle> values = relationMap.get(key);
						if (values != null) {
							for (LabelStyle value : values) {
								if (value != null && value.style != null && value.name != null) {
									rels.add((key.replaceAll("'", "") + " " + value.style + " " + value.name.replaceAll("'", "")).trim());
								}
							}
						}
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
		
		import java.io.BufferedReader;
		import java.io.File;
		import java.io.IOException;
		import java.lang.reflect.InvocationTargetException;
		import java.net.URISyntaxException;
		import java.nio.charset.StandardCharsets;
		import java.nio.file.Files;
		import java.nio.file.Path;
		import java.util.ArrayList;
		import java.util.Collections;
		import java.util.LinkedHashMap;
		import java.util.LinkedHashSet;
		import java.util.List;
		import java.util.Map;
		import java.util.Set;
		
		import org.eclipse.core.commands.AbstractHandler;
		import org.eclipse.core.commands.ExecutionEvent;
		import org.eclipse.core.commands.ExecutionException;
		import org.eclipse.core.resources.IProject;
		import org.eclipse.core.runtime.IProgressMonitor;
		import org.eclipse.core.runtime.NullProgressMonitor;
		import org.eclipse.emf.ecore.EObject;
		import org.eclipse.emf.ecore.EPackage;
		import org.eclipse.emf.ecore.resource.Resource;
		import org.eclipse.jface.dialogs.ProgressMonitorDialog;
		import org.eclipse.jface.operation.IRunnableWithProgress;
		import org.eclipse.swt.widgets.Shell;
		import org.eclipse.ui.handlers.HandlerUtil;
		
		import net.sourceforge.plantuml.GeneratedImage;
		import net.sourceforge.plantuml.SourceFileReader;
		import wodel.utils.exceptions.MetaModelNotFoundException;
		import wodel.utils.exceptions.ModelNotFoundException;
		import wodel.utils.exceptions.ReferenceNonExistingException;
		import wodel.utils.manager.DrawUtils.LabelStyle;
		import wodel.utils.manager.ModelManager;
		import wodel.utils.manager.ProjectUtils;
		
		public class «className»Draw extends AbstractHandler implements wodeledu.extension.run.commands.IMutatorDraw {

			private static final String MODEL_EXTENSION = ".model";
			private static final String ECORE_EXTENSION = ".ecore";
			private static final String METAMODEL_FILE_NAME = "«javaString(lastSegment(draw.metamodel))»";

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
				Set<EObject> result = new LinkedHashSet<EObject>();
				List<EObject> pending = new ArrayList<EObject>();
				pending.add(cl);

				while (!pending.isEmpty()) {
					EObject current = pending.remove(pending.size() - 1);
					try {
						Object ob = ModelManager.getReferences("superclass", current);
						if (ob instanceof List<?>) {
							for (Object candidate : (List<?>) ob) {
								if (candidate instanceof EObject && result.add((EObject) candidate)) {
									pending.add((EObject) candidate);
								}
							}
						}
						else if (ob instanceof EObject && result.add((EObject) ob)) {
							pending.add((EObject) ob);
						}
					}
					catch (ReferenceNonExistingException e) {
						// This object simply has no superclass reference.
					}
				}

				result.remove(cl);
				return result;
			}
			
			private class RunMutatorDrawWithProgress implements IRunnableWithProgress {
				@Override
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					try {
						generate(monitor);
					}
					catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						throw e;
					}
					catch (Exception e) {
						throw new InvocationTargetException(e);
					}
				}
			}

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
										label.name = getOrdinalFor(j) + " : -" + attName + " = " + quote + (attValues.size() > k ? attValues.get(k) : "") + quote;
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
				

			private File resolveProjectDirectory() throws IOException {
				try {
					File location = new File(
							«className»Draw.class
								.getProtectionDomain()
								.getCodeSource()
								.getLocation()
								.toURI()
					);

					if (location.isFile()) {
						location = location.getParentFile();
					}
					if (location != null && "bin".equals(location.getName())) {
						location = location.getParentFile();
					}
					else if (location != null
							&& "classes".equals(location.getName())
							&& location.getParentFile() != null
							&& "target".equals(location.getParentFile().getName())) {
						location = location.getParentFile().getParentFile();
					}

					if (location != null && location.isDirectory()) {
						return location.getCanonicalFile();
					}
				}
				catch (URISyntaxException e) {
					// Fall through to the Eclipse workspace lookup below.
				}

				IProject project = ProjectUtils.getProject();
				if (project != null && project.getLocation() != null) {
					return project.getLocation().toFile().getCanonicalFile();
				}

				throw new IOException(
						"Cannot determine the Wodel-EDU project directory for "
						+ «className»Draw.class.getName()
				);
			}

			private ProjectFolders readProjectFolders(File projectDirectory) throws IOException {
				File configFile = new File(projectDirectory, "data/config/config.txt");
				if (!configFile.isFile()) {
					throw new IOException("Cannot find Wodel configuration file: " + configFile);
				}

				try (BufferedReader reader = Files.newBufferedReader(
						configFile.toPath(),
						StandardCharsets.UTF_8
				)) {
					String modelFolder = reader.readLine();
					String mutantFolder = reader.readLine();
					if (modelFolder == null || modelFolder.isBlank()
							|| mutantFolder == null || mutantFolder.isBlank()) {
						throw new IOException("Invalid Wodel configuration file: " + configFile);
					}

					return new ProjectFolders(
							new File(projectDirectory, modelFolder).getCanonicalFile(),
							new File(projectDirectory, mutantFolder).getCanonicalFile()
					);
				}
			}

			private File resolveMetamodelFile(File modelDirectory) throws IOException {
				if (METAMODEL_FILE_NAME != null && !METAMODEL_FILE_NAME.isBlank()) {
					File expected = new File(modelDirectory, METAMODEL_FILE_NAME);
					if (expected.isFile()) {
						return expected;
					}
				}

				File[] files = modelDirectory.listFiles();
				if (files != null) {
					for (File file : files) {
						if (file.isFile() && file.getName().endsWith(ECORE_EXTENSION)) {
							return file;
						}
					}
				}

				throw new IOException("Cannot find an Ecore metamodel in " + modelDirectory);
			}

			private void renderPlantUML(File sourceFile) throws IOException {
				SourceFileReader reader = new SourceFileReader(false, sourceFile);
				List<GeneratedImage> images = reader.getGeneratedImages();
				if (images == null || images.isEmpty()) {
					throw new IOException(
							"PlantUML did not generate an image for " + sourceFile
					);
				}

				File image = images.get(0).getPngFile();
				if (image == null || !image.isFile()) {
					throw new IOException(
							"PlantUML did not create the expected PNG for " + sourceFile
					);
				}
			}

			private void renderModel(
					File modelFile,
					List<EPackage> packages,
					File outputDirectory,
					File projectDirectory,
					IProgressMonitor monitor,
					boolean mutant)
					throws ModelNotFoundException, IOException, InterruptedException {

				if (modelFile == null || !modelFile.isFile()
						|| !modelFile.getName().endsWith(MODEL_EXTENSION)) {
					return;
				}

				checkCanceled(monitor);
				ensureDirectory(outputDirectory);

				String displayPath = safeRelativize(
						projectDirectory.toPath().toAbsolutePath().normalize(),
						modelFile.toPath().toAbsolutePath().normalize()
				);

				Resource model = null;
				try {
					model = ModelManager.loadModel(packages, modelFile.getAbsolutePath());
					Map<Integer, Map<EObject, List<LabelStyle>>> umlnodes = null;
					Map<Integer, Map<EObject, Map<String, List<LabelStyle>>>> umlrels = null;
					Map<String, Integer> id  = null;
					Set<String> umlcode = null;
					String outputBaseName = null;
					File umlFile = null;
					Set<String> rels = null;
					Map<EObject, List<LabelStyle>> selectedNodes = null;
					Map<EObject, Map<String, List<LabelStyle>>> selectedRelations = null;
					//«var int renderIndex = 0»
					«FOR MutatorInstance instance : draw.instances»
						«IF roots !== null && roots.size() > renderIndex + 1»
							checkCanceled(monitor);
							monitor.subTask(
									"Rendering image for " + (mutant ? "mutant " : "model ")
									+ displayPath + " («roots.get(renderIndex + 1).name»)"
							);

							umlnodes = new LinkedHashMap<Integer, Map<EObject, List<LabelStyle>>>();
							umlrels = new LinkedHashMap<Integer, Map<EObject, Map<String, List<LabelStyle>>>>();
							id = new LinkedHashMap<String, Integer>();
							«draw.generate(renderIndex)»

							outputBaseName = "«javaString(roots.get(renderIndex + 1).name)»_"
									+ stripExtension(modelFile.getName());
							umlFile = new File(outputDirectory, outputBaseName + ".txt");
							Files.write(umlFile.toPath(), umlcode, StandardCharsets.UTF_8);
							renderPlantUML(umlFile);
							monitor.worked(1);
						«ENDIF»
						//«renderIndex++»
					«ENDFOR»
				}
				finally {
					if (model != null && model.isLoaded()) {
						model.unload();
					}
				}
			}

			public void generate(IProgressMonitor progressMonitor)
					throws MetaModelNotFoundException, ModelNotFoundException,
					       IOException, InterruptedException {

				IProgressMonitor monitor = progressMonitor != null
						? progressMonitor
						: new NullProgressMonitor();

				File projectDirectory = resolveProjectDirectory();
				ProjectFolders folders = readProjectFolders(projectDirectory);
				File metamodelFile = resolveMetamodelFile(folders.modelDirectory);
				File diagramsDirectory = new File(projectDirectory, "src-gen/html/diagrams");
				ensureDirectory(diagramsDirectory);

				List<EPackage> packages = ModelManager.loadMetaModel(metamodelFile.getAbsolutePath());
				List<String> models = ModelManager.getModels(«className»Draw.class);
				List<String> mutants = ModelManager.getMutants(«className»Draw.class);
				if (models == null) {
					models = Collections.emptyList();
				}
				if (mutants == null) {
					mutants = Collections.emptyList();
				}

				int totalTasks = (models.size() + mutants.size()) * «draw.instances.size()»;
				monitor.beginTask("Rendering PlantUML diagrams", totalTasks);
				try {
					for (String modelPath : models) {
						checkCanceled(monitor);
						File modelFile = new File(modelPath);
						File outputDirectory = new File(
								diagramsDirectory,
								stripExtension(modelFile.getName())
						);
						renderModel(
								modelFile,
								packages,
								outputDirectory,
								projectDirectory,
								monitor,
								false
						);
					}

					Path mutantRoot = folders.mutantDirectory.toPath().toAbsolutePath().normalize();
					for (String mutantPath : mutants) {
						checkCanceled(monitor);
						File mutantFile = new File(mutantPath);
						File parentFile = mutantFile.getParentFile();
						String relative = parentFile != null
								? safeRelativize(
										mutantRoot,
										parentFile.toPath().toAbsolutePath().normalize()
								)
								: "";
						File outputDirectory = relative.isEmpty()
								? diagramsDirectory
								: new File(diagramsDirectory, relative);

						renderModel(
								mutantFile,
								packages,
								outputDirectory,
								projectDirectory,
								monitor,
								true
						);
					}
				}
				finally {
					monitor.done();
				}
			}

			private String safeRelativize(Path root, Path child) {
				try {
					if (child.startsWith(root)) {
						return root.relativize(child).toString();
					}
				}
				catch (IllegalArgumentException e) {
					// Different filesystem roots; use the common output directory.
				}
				return "";
			}

			private String stripExtension(String fileName) {
				if (fileName == null) {
					return "";
				}
				int dot = fileName.lastIndexOf('.');
				return dot > 0 ? fileName.substring(0, dot) : fileName;
			}

			private void ensureDirectory(File directory) throws IOException {
				if (directory.isDirectory()) {
					return;
				}
				if (!directory.mkdirs() && !directory.isDirectory()) {
					throw new IOException("Cannot create directory: " + directory);
				}
			}

			private void checkCanceled(IProgressMonitor monitor) throws InterruptedException {
				if (monitor != null && monitor.isCanceled()) {
					throw new InterruptedException("PlantUML rendering was canceled");
				}
			}

			private static final class ProjectFolders {
				private final File modelDirectory;
				private final File mutantDirectory;

				private ProjectFolders(File modelDirectory, File mutantDirectory) {
					this.modelDirectory = modelDirectory;
					this.mutantDirectory = mutantDirectory;
				}
			}

            @Override
            public Object execute(ExecutionEvent event) throws ExecutionException {
                Shell shell = event != null ? HandlerUtil.getActiveShell(event) : null;

                if (shell == null || shell.isDisposed()) {
                    try {
                        generate(new NullProgressMonitor());
                    }
                    catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    catch (Exception e) {
                        throw new ExecutionException(
                                "Error rendering Wodel-EDU PlantUML diagrams",
                                e
                        );
                    }
                    return null;
                }

                ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
                try {
                    dialog.run(true, true, new RunMutatorDrawWithProgress());
                }
                catch (InvocationTargetException e) {
                    Throwable cause = e.getCause() != null ? e.getCause() : e;
                    throw new ExecutionException(
                            "Error rendering Wodel-EDU PlantUML diagrams",
                            cause
                    );
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return null;
            }

            @Override
            public void run() {
                try {
                    generate(new NullProgressMonitor());
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException(
                            "PlantUML rendering was interrupted",
                            e
                    );
                }
                catch (Exception e) {
                    throw new IllegalStateException(
                            "Error rendering Wodel-EDU PlantUML diagrams",
                            e
                    );
                }
            }

        }
			'''
}
