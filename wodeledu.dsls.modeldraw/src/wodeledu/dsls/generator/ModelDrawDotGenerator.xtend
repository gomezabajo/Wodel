package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import modeldraw.MutatorDraw
import wodel.utils.manager.ModelManager
import modeldraw.NodeType
import modeldraw.NodeShape
import modeldraw.Edge
import modeldraw.Level
import modeldraw.Content
import modeldraw.Decoration
import modeldraw.NodeStyle
import modeldraw.Relation
import wodel.utils.manager.JavaUtils
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import org.eclipse.core.resources.IProject
import wodel.utils.manager.ProjectUtils
import modeldraw.ValuedFeature
import modeldraw.Node
import org.eclipse.xtext.generator.AbstractGenerator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EClass
import java.util.ArrayList

/**
 * @author Pablo Gomez-Abajo - modelDraw dot code generator.
 * 
 * Generates the Java code for the graphical
 * representation of the models. GraphViz mode.
 *  
 */
class ModelDrawDotGenerator extends AbstractGenerator {
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

	def generate(MutatorDraw draw, String folder) '''
		Map<EObject, LabelStyle> dotnodes = new HashMap<EObject, LabelStyle>();
		Map<String, List<Map<String, String>>> dotrels = new HashMap<String, List<Map<String, String>>>();
		Map<String, List<String>> dottext = new HashMap<String, List<String>>();
		List<String> dotcode = new ArrayList<String>();
		«IF draw.instances.get(0).nodes !== null»
			«IF draw.instances.get(0).nodes.size() > 0»
				generateNodes(packages, model, dotnodes, dotrels);
			«ENDIF»
		«ENDIF»
		«IF draw.instances.get(0).relations !== null»
			«IF draw.instances.get(0).relations.size() > 0»
				generateRelations(model, dotrels, dottext);
			«ENDIF»
		«ENDIF»
		dotcode.add("digraph «draw.instances.get(0).name.name» {\n\nrankdir=LR;\n");
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
	'''
	
	def compile(Content content, String hmname) '''
		«IF content !== null»
			«IF content.nodenum !== null && content.nodenum.size() > 0»
				«FOR nodenum : content.nodenum»
					for (EAttribute attribute : obj.eClass().getEAllAttributes()) {
						«IF nodenum.att !== null»
							if (attribute.getName().equals("«nodenum.att.name»")) {
						«ELSE»
							if (attribute.getName().equals("name")) {
						«ENDIF»
						if (obj.eGet(attribute) != null) {
							EObject o = (EObject) obj.eGet(attribute);
							if (o instanceof EEnumLiteral) {
								EEnumLiteral lit = (EEnumLiteral) o;
								«IF nodenum.enumerator !== null && nodenum.enumerator.size() > 0»
									«FOR lit : nodenum.enumerator»
										if (lit.getLiteral().equals("«lit.literal.name»")) {
											text = «hmname».get(obj);
											text = text + "«lit.value» ";
											«hmname».put(obj, text);
										break;
										}
									«ENDFOR»
								«ENDIF»
							}
							}
							break;
						}
					}
				«ENDFOR»
			«ENDIF»
			«IF content.info !== null && content.info.size() > 0»
				«FOR info : content.info»
					for (EReference r : obj.eClass().getEAllReferences()) {
						«IF info.type !== null»
							if (r.getName().equals("«info.type.name»")) {
						«ELSE»
							if (r.getName().equals("name")) {
						«ENDIF»
						if (obj.eGet(r) != null) {
							EObject o = (EObject) obj.eGet(r);
							for (EAttribute attribute : o.eClass().getEAllAttributes()) {
								«IF info.att !== null»
									if (attribute.getName().equals("«info.att.name»")) {
								«ELSE»
									if (attribute.getName().equals("name")) {
								«ENDIF»
								text = «hmname».get(obj);
								text = text + (String) o.eGet(attribute) + " ";
								«hmname».put(obj, text);
								break;
								}
							}
							}
							break;
						}
					}
				«ENDFOR»
			«ENDIF»
			for (EAttribute attribute : obj.eClass().getEAllAttributes()) {
				«IF content.attName !== null»
					if (attribute.getName().equals("«content.attName.name»")) {
				«ELSE»
					if (attribute.getName().equals("name")) {
				«ENDIF»
				text = «hmname».get(obj);
				text = text + (String) obj.eGet(attribute) + " ";
				«hmname».put(obj, text);
				break;
				}
			}
			«IF content.symbol !== null»
				text = «hmname».get(obj);
				text = text + "«content.symbol»";
				«hmname».put(obj, text);
			«ENDIF»
		«ENDIF»
	'''
	
	def decorate(Relation rel) '''
		«IF rel.label !== null && rel.label.size > 0»
			parameters.put("label", label);
		«ENDIF»
		«IF rel.tar_decoration != Decoration.NONE»
			if (parameters.containsKey("dir") == false) {
				parameters.put("dir", "both");
			}
			if (parameters.containsKey("arrowtail") == false) {
				parameters.put("arrowtail", "none");
			}
			«IF rel.tar_decoration == Decoration.TRIANGLE»
				parameters.put("arrowhead", "empty");
			«ELSE»
				«IF rel.tar_decoration != Decoration.EMPTY»
					parameters.put("arrowhead", "«rel.tar_decoration»");
				«ELSE»
					parameters.put("arrowhead", "none");
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF rel.tar_label !== null»
			if (parameters.containsKey("dir") == false) {
				parameters.put("dir", "both");
			}
			if (parameters.containsKey("arrowhead") == false) {
				parameters.put("arrowhead", "none");
			}
			if (parameters.containsKey("arrowtail") == false) {
				parameters.put("arrowtail", "none");
			}
			parameters.put("headlabel", tar_label != null ? tar_label : "");
		«ENDIF»
		«IF rel.src_decoration != Decoration.NONE»
			if (parameters.containsKey("dir") == false) {
				parameters.put("dir", "both");
			}
			if (parameters.containsKey("arrowhead") == false) {
				parameters.put("arrowhead", "none");
			}
			«IF rel.src_decoration == Decoration.TRIANGLE»
				parameters.put("arrowtail", "empty");
			«ELSE»
				«IF rel.src_decoration != Decoration.EMPTY»
					parameters.put("arrowtail", "«rel.src_decoration»");
				«ELSE»
					parameters.put("arrowtail", "none");
				«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF rel.src_label !== null»
			if (parameters.containsKey("dir") == false) {
				parameters.put("dir", "both");
			}
			if (parameters.containsKey("arrowhead") == false) {
				parameters.put("arrowhead", "none");
			}
			if (parameters.containsKey("arrowtail") == false) {
				parameters.put("arrowtail", "none");
			}
			parameters.put("taillabel", src_label != null ? src_label : "");
		«ENDIF»
	'''
	
	
	def compile(MutatorDraw draw) '''
		package mutator.«className»;
		
		import java.io.File;
		import java.io.FileNotFoundException;
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
		import wodel.utils.manager.DrawUtils.LabelStyle;
		
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
					
						«var String folder = ProjectUtils.getProject.getLocation.toFile.getPath.replace("\\", "/") + "/"»
			«IF draw.instances.get(0).nodes !== null»
				«IF draw.instances.get(0).nodes.size() > 0»
					private void generateNodes(List<EPackage> packages, Resource model, Map<EObject, LabelStyle> dotnodes, Map<String, List<Map<String, String>>> dotrels) {
						// COUNTER: «var counter = 0»
						«FOR Node node : draw.instances.get(0).nodes»
							List<EObject> lnode_«counter» = ModelManager.getObjectsOfType("«node.name.name»", model);
							for (EObject node : lnode_«counter») {
								Map<String, String> parameters = new LinkedHashMap<String, String>();
								List<Map<String, String>> rels = new ArrayList<Map<String, String>>();
								String name = "";
								String typeName = node.eClass().getName();
								for (EAttribute att : node.eClass().getEAllAttributes()) {
									«IF node.attName !== null»
										if (att.getName().equals("«node.attName.name»")) {
									«ELSE»
										if (att.getName().equals("name")) {
									«ENDIF»
									name = (String) node.eGet(att);
									break;
								}
							}
							«IF node.feature !== null»
								«IF node.feature.size() == 0»
									LabelStyle style = null;
									«IF node.type == NodeType.MARKEDNODE»
										style = new LabelStyle();
										style.name = "_nil";
										style.shape = "style = invis"; 
										dotnodes.put(EcoreUtil.create(node.eClass()), style);
										if (dotnodes.containsKey(node) == false) {
											style = new LabelStyle();
										}
										else {
											style = dotnodes.get(node);
										}
										style.name = name;
										style.border = "0";
										«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
											style.shape = "shape = «node.shape»";
										«ENDIF»
										«IF node.shape == NodeShape.LOGIC»
											style.path = "C:/eclipse/workspace/wodel.wodeledu/content/images/logic_" + typeName.toLowerCase() + ".png";
										«ENDIF»
										«IF node.shape == NodeShape.LOAD»
											style.path = "«node.pathShape»";
										«ENDIF»
										dotnodes.put(node, style);
										rels.add(parameters);
										dotrels.put("_nil -> " + name, rels);
									«ENDIF»
									«IF node.type == NodeType.NODE»
										if (dotnodes.containsKey(node) == false) {
											style = new LabelStyle();
										}
										else {
											style = dotnodes.get(node);
										}
										style.name = name;
										style.border = "0";
										«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
											style.shape = "shape = «node.shape»";
										«ENDIF»
										«IF node.shape == NodeShape.LOGIC»
											style.path = "C:/eclipse/workspace/wodel.wodeledu/content/images/logic_" + typeName.toLowerCase() + ".png";
										«ENDIF»
										«IF node.shape == NodeShape.LOAD»
											style.path = "«node.pathShape»";
										«ENDIF»
										dotnodes.put(node, style);
									«ENDIF»
									«IF node.shape == NodeShape.RECORD»
										if (dotnodes.containsKey(node) == false) {
											style = new LabelStyle();
										}
										else {
											style = dotnodes.get(node);
										}
										style.name = name;
										«IF node.style == NodeStyle.ITALIC»
											style.style = "I";
										«ENDIF»
										«IF node.style == NodeStyle.UNDERLINE»
											style.style = "U";
										«ENDIF»
										style.border = "1";
										style.shape ="shape = plaintext, style= filled, fillcolor=«node.color»";
										dotnodes.put(node, style);
									«ENDIF»
								«ELSE»
									«FOR ValuedFeature feat : node.feature»
										for (EStructuralFeature feat : node.eClass().getEAllStructuralFeatures()) {
											if (feat.getName().equals("«feat.feat.name»")) {
												Object featObject = node.eGet(feat);
												«IF feat instanceof ValuedFeature»
													«IF feat.feat instanceof EAttribute»
														if (featObject instanceof Boolean) {
														Boolean value = (Boolean) featObject;
														«IF feat.negation == true»
															if (value == false) {
														«ELSE»
															if (value == true) {
														«ENDIF»
														LabelStyle style = null;
														«IF node.type == NodeType.MARKEDNODE»
															style = new LabelStyle();
															style.name = "_nil";
															style.shape = "style = invis"; 
															dotnodes.put(EcoreUtil.create(node.eClass()), style);
															if (dotnodes.containsKey(node) == false) {
																style = new LabelStyle();
															}
															else {
																style = dotnodes.get(node);
															}
															style.name = name;
															style.border = "0";
															«IF node.shape != NodeShape.LOAD»
																style.shape = "shape = «node.shape»";
															«ENDIF»
															«IF node.shape == NodeShape.LOAD»
																style.path = "«node.pathShape»";
															«ENDIF»
															dotnodes.put(node, style);
															rels.add(parameters);
															dotrels.put("_nil -> " + name, rels);
														«ENDIF»
														«IF node.type == NodeType.NODE»
															if (dotnodes.containsKey(node) == false) {
																style = new LabelStyle();
															}
															else {
																style = dotnodes.get(node);
															}
															style.name = name;
															style.border = "0";
															«IF node.shape != NodeShape.LOAD»
																style.shape = "shape = «node.shape»";
															«ENDIF»
															«IF node.shape == NodeShape.LOAD»
																style.path = "«node.pathShape»";
															«ENDIF»
															dotnodes.put(node, style);
														«ENDIF»
														«IF node.shape == NodeShape.RECORD»
															if (dotnodes.containsKey(node) == false) {
																style = new LabelStyle();
															}
															else {
																style = dotnodes.get(node);
															}
															style.name = name;
															«IF node.style == NodeStyle.ITALIC»
																style.style = "I";
															«ENDIF»
															«IF node.style == NodeStyle.UNDERLINE»
																style.style = "U";
															«ENDIF»
															style.border = "1";
															style.shape ="shape = plaintext, style= filled, fillcolor=«node.color»";
															dotnodes.put(node, style);
														«ENDIF»
														}
													«ENDIF»
													«IF feat.feat instanceof EReference»
														«IF feat.refFeature === null»
															{
															Boolean value = (featObject == null);
															«IF feat.value !== null && feat.value.equals("null")»
																if (value == true) {
															«ELSE»
																if (value == false) {
															«ENDIF»
															LabelStyle style = null;
															«IF node.type == NodeType.MARKEDNODE»
																style = new LabelStyle();
																style.name = "_nil";
																style.shape = "style = invis"; 
																dotnodes.put(EcoreUtil.create(node.eClass()), style);
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
																rels.add(parameters);
																dotrels.put("_nil -> " + name, rels);
															«ENDIF»
															«IF node.type == NodeType.NODE»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
															«ENDIF»
															«IF node.shape == NodeShape.RECORD»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																«IF node.style == NodeStyle.ITALIC»
																	style.style = "I";
																«ENDIF»
																«IF node.style == NodeStyle.UNDERLINE»
																	style.style = "U";
																«ENDIF»
																style.border = "1";
																style.shape ="shape = plaintext, style= filled, fillcolor=«node.color»";
																dotnodes.put(node, style);
															«ENDIF»
															}
														«ENDIF»
														«IF feat.refFeature !== null»
															if (featObject instanceof EObject) {
																for (EStructuralFeature refFeature : ((EObject) featObject).eClass().getEAllStructuralFeatures()) {
																if (refFeature.getName().equals("«feat.refFeature.name»")) {
																Object refFeatureObject = ((EObject) featObject).eGet(refFeature);
															if (refFeatureObject instanceof Boolean) {
															Boolean value = (Boolean) refFeatureObject;
															«IF feat.negation == true»
																if (value == false) {
															«ELSE»
																if (value == true) {
															«ENDIF»
															LabelStyle style = null;
															«IF node.type == NodeType.MARKEDNODE»
																style = new LabelStyle();
																style.name = "_nil";
																style.shape = "style = invis"; 
																dotnodes.put(EcoreUtil.create(node.eClass()), style);
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
																rels.add(parameters);
																dotrels.put("_nil -> " + name, rels);
															«ENDIF»
															«IF node.type == NodeType.NODE»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
															«ENDIF»
															«IF node.shape == NodeShape.RECORD»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																«IF node.style == NodeStyle.ITALIC»
																	style.style = "I";
																«ENDIF»
																«IF node.style == NodeStyle.UNDERLINE»
																	style.style = "U";
																«ENDIF»
																style.border = "1";
																style.shape ="shape = plaintext, style= filled, fillcolor=«node.color»";
																dotnodes.put(node, style);
															«ENDIF»
															}
															}
															else {
															Boolean value = (refFeatureObject == null);
															«IF feat.value !== null && feat.value.equals("null")»
																if (value == true) {
															«ELSE»
																if (value == false) {
															«ENDIF»
															LabelStyle style = null;
															«IF node.type == NodeType.MARKEDNODE»
																style = new LabelStyle();
																style.name = "_nil";
																style.shape = "style = invis"; 
																dotnodes.put(EcoreUtil.create(node.eClass()), style);
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
																rels.add(parameters);
																dotrels.put("_nil -> " + name, rels);
															«ENDIF»
															«IF node.type == NodeType.NODE»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
															«ENDIF»
															«IF node.shape == NodeShape.RECORD»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																«IF node.style == NodeStyle.ITALIC»
																	style.style = "I";
																«ENDIF»
																«IF node.style == NodeStyle.UNDERLINE»
																	style.style = "U";
																«ENDIF»
																style.border = "1";
																style.shape ="shape = plaintext, style= filled, fillcolor=«node.color»";
																dotnodes.put(node, style);
															«ENDIF»
															}
															}
															}
															}
															}
															if (featObject instanceof List<?>) {
																for (EObject featOb : (List<EObject>) featObject) {
																for (EStructuralFeature refFeature : featOb.eClass().getEAllStructuralFeatures()) {
																if (refFeature.getName().equals("«feat.refFeature.name»")) {
																Object refFeatureObject = featOb.eGet(refFeature);
															if (refFeatureObject instanceof Boolean) {
															Boolean value = (Boolean) refFeatureObject;
															«IF feat.negation == true»
																if (value == false) {
															«ELSE»
																if (value == true) {
															«ENDIF»
															LabelStyle style = null;
															«IF node.type == NodeType.MARKEDNODE»
																style = new LabelStyle();
																style.name = "_nil";
																style.shape = "style = invis"; 
																dotnodes.put(EcoreUtil.create(node.eClass()), style);
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
																rels.add(parameters);
																dotrels.put("_nil -> " + name, rels);
															«ENDIF»
															«IF node.type == NodeType.NODE»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
															«ENDIF»
															«IF node.shape == NodeShape.RECORD»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																«IF node.style == NodeStyle.ITALIC»
																	style.style = "I";
																«ENDIF»
																«IF node.style == NodeStyle.UNDERLINE»
																	style.style = "U";
																«ENDIF»
																style.border = "1";
																style.shape ="shape = plaintext, style= filled, fillcolor=«node.color»";
																dotnodes.put(node, style);
															«ENDIF»
															}
															}
															else {
															Boolean value = (refFeatureObject == null);
															«IF feat.value !== null && feat.value.equals("null")»
																if (value == true) {
															«ELSE»
																if (value == false) {
															«ENDIF»
															LabelStyle style = null;
															«IF node.type == NodeType.MARKEDNODE»
																style = new LabelStyle();
																style.name = "_nil";
																style.shape = "style = invis"; 
																dotnodes.put(EcoreUtil.create(node.eClass()), style);
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
																rels.add(parameters);
																dotrels.put("_nil -> " + name, rels);
															«ENDIF»
															«IF node.type == NodeType.NODE»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																style.border = "0";
																«IF node.shape != NodeShape.LOAD»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOAD»
																	style.path = "«node.pathShape»";
																«ENDIF»
																dotnodes.put(node, style);
															«ENDIF»
															«IF node.shape == NodeShape.RECORD»
																if (dotnodes.containsKey(node) == false) {
																	style = new LabelStyle();
																}
																else {
																	style = dotnodes.get(node);
																}
																style.name = name;
																«IF node.style == NodeStyle.ITALIC»
																	style.style = "I";
																«ENDIF»
																«IF node.style == NodeStyle.UNDERLINE»
																	style.style = "U";
																«ENDIF»
																style.border = "1";
																style.shape ="shape = plaintext, style= filled, fillcolor=«node.color»";
																dotnodes.put(node, style);
															«ENDIF»
															}
															}
															}
															}
															}
														«ENDIF»
													«ENDIF»
												«ENDIF»
												«IF node.reference !== null»
													«IF node.reference.size() > 0»
														Map<EObject, String> table = new HashMap<EObject, String>();
														«FOR ref : node.reference»
															«IF draw.instances.get(0).contents !== null»
																«IF draw.instances.get(0).contents.size() > 0»
																	for (EReference ref : node.eClass().getEAllReferences()) {
																		String label = "";
																		List<EClass> classes = null;
																		EClass cl = null;
																		if (ref.getName().equals("«ref.name»")) {
																			//COUNT SET:«var int count = 0»
																			«FOR content : draw.instances.get(0).contents»
																				//COUNT INC: «count++»
																				classes = new ArrayList<EClass>();
																				cl = ModelManager.getEClassByName(packages, "«content.name.name»");
																				classes.addAll(cl.getESuperTypes());
																				classes.add(cl);
																				for (EClass c : classes) {
																					if (c.getName().equals(ref.getEType().getName())) {
																						String text = "";
																						if (ref.getUpperBound() < 0 || ref.getUpperBound() > 1) {
																							List<EObject> lobj = (List<EObject>) node.eGet(ref);
																							if (lobj != null) {
																								for (EObject obj : lobj) {
																									if (obj != null) {
																										if (obj.eClass().getName().equals("«content.name.name»")) {
																											if (table.containsKey(obj) == false) {
																												table.put(obj, "");
																											}
																											«content.compile("table")»
																											if (label.length() > 0) {
																												if (label.endsWith("<TR>") == true) {
																													label = label + "<TD>" + table.get(obj);
																												}
																												else {
																													label = label + "<BR/>" + table.get(obj);
																												}
																											}
																											else {
																												label = "<TD>" + table.get(obj);
																											}
																										}
																									}
																								}
																							}
																						}
																						else {
																							EObject obj = (EObject) node.eGet(ref);
																							if (obj != null) {
																								if (obj.eClass().getName().equals("«content.name.name»")) {
																									if (table.containsKey(obj) == false) {
																										table.put(obj, "");
																									}
																									«content.compile("table")»
																									if (label.length() > 0) {
																										if (label.endsWith("<TR>") == true) {
																											label = label + "<TD>" + table.get(obj);
																										}
																										else {
																											label = label + "<BR/>" + table.get(obj);
																										}
																									}
																									else {
																										label = "<TD>" + table.get(obj);
																									}
																								}
																							}
																						}
																					}
																				}
																				if (label.length() > 0) {
																					label = label + "</TD></TR><TR>";
																				}
																			«ENDFOR»
																			if (dotnodes.containsKey(node) == true) {
																				if (dotnodes.get(node) != null) {
																					LabelStyle style = dotnodes.get(node);
																					style.label = style.label + label;
																					dotnodes.put(node, style);
																				}
																			}
																		}
																	}
																«ENDIF»
															«ENDIF»
														«ENDFOR»
													«ENDIF»
												«ENDIF»
												}
											}
										}
									«ENDFOR»
								«ENDIF»
							«ENDIF»
						}
						// INC COUNTER: «counter = counter + 1»
					«ENDFOR»
					for (EObject dotnode : dotnodes.keySet()) {
						if (dotnodes.get(dotnode) != null) {
							LabelStyle style = dotnodes.get(dotnode);
							if (style.style.length() == 0) {
								if (style.label.length() == 0) {
									if (style.path.isEmpty()) {
										style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD>" + style.name + "</TD></TR></TABLE>>";
									}
									else {
										style.label = "image=\"" + style.path + "\", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD></TD></TR></TABLE>>";
									}
								}
								else {
									if (style.label.endsWith("<TR>")) {
										style.label = style.label.substring(0, style.label.length() - 4);
									}
									if (style.label.endsWith("<TR></TD></TR>")) {
										style.label = style.label.substring(0, style.label.length() - 14);
									}
									if (style.path.isEmpty()) {
										style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD>" + style.name + "</TD></TR><TR>" + style.label + "</TABLE>>";
									}
									else {
										style.label = "image=\"" + style.path + "\", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD></TD></TR><TR>" + style.label + "</TABLE>>";
									}
								}
							}
							else {
								if (style.label.length() == 0) {
									if (style.path.isEmpty()) {
										style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD><" + style.style + ">" + style.name + "</" + style.style + "></TD></TR></TABLE>>";
									}
									else {
										style.label = "image=\"" + style.path + "\", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD><" + style.style + "><TR><TD><" + style.style + "></" + style.style + "></TD></TR></TABLE>>";
									}
								}
								else {
									if (style.label.endsWith("<TR>")) {
										style.label = style.label.substring(0, style.label.length() - 4);
									}
									if (style.label.endsWith("<TR></TD></TR>")) {
										style.label = style.label.substring(0, style.label.length() - 14);
									}
									if (style.path.isEmpty()) {
										style.label = style.shape + ", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD><" + style.style + ">" + style.name + "</" + style.style + "></TD></TR><TR>" + style.label + "</TABLE>>";
									}
									else {
										style.label = "image=\"" + style.path + "\", label=<<TABLE BORDER=\"0\" CELLBORDER=\"" + style.border + "\" CELLSPACING=\"0\"><TR><TD><" + style.style + "></TD></TR><TR><TD><" + style.style + "></" + style.style + "></TD></TR><TR>" + style.label + "</TABLE>>";
									}
								}
							}
							dotnodes.put(dotnode, style);
						}
					}
				}
			«ENDIF»
			«ENDIF»
			
			«IF draw.instances.get(0).relations !== null»
			«IF draw.instances.get(0).relations.size() > 0»
				private void generateRelations(Resource model, Map<String, List<Map<String, String>>> dotrels, Map<String, List<String>> dottext) {
					// COUNTER: «var counter = 0»
					«FOR Relation rel : draw.instances.get(0).relations»
						«IF rel instanceof Edge»
							//«var Edge edge = rel as Edge»
							List<EObject> ledge_«counter» = ModelManager.getObjectsOfType("«edge.name.name»", model);
							for (EObject edge : ledge_«counter») {
								«IF edge.feature !== null»
									boolean valid = true;
									«FOR ValuedFeature feat : edge.feature»
										for (EStructuralFeature feat : edge.eClass().getEAllStructuralFeatures()) {
											if (feat.getName().equals("«feat.feat.name»")) {
												Object featObject = edge.eGet(feat);
												«IF feat.feat instanceof EAttribute»
													if (featObject instanceof Boolean) {
														Boolean value = (Boolean) featObject;
														«IF feat.negation == true»
															if (value != false) {
																valid = false;
															}
														«ELSE»
															if (value != true) {
																valid = false;
															}
														«ENDIF»
													}
												«ENDIF»
												«IF feat.feat instanceof EReference»
													«IF feat.refFeature === null»
														Boolean value = (featObject == null);
														«IF feat.value !== null && feat.value.equals("null")»
															if (value != true) {
																valid = false;
															}
														«ELSE»
															if (value != false) {
																valid = false;
															}
														«ENDIF»
													«ENDIF»
												«ENDIF»
												«IF feat.refFeature !== null»
													if (featObject instanceof EObject) {
														for (EStructuralFeature refFeature : ((EObject) featObject).eClass().getEAllStructuralFeatures()) {
															if (refFeature.getName().equals("«feat.refFeature.name»")) {
																Object refFeatureObject = ((EObject) featObject).eGet(refFeature);
																if (refFeatureObject instanceof Boolean) {
																	Boolean value = (Boolean) refFeatureObject;
																	«IF feat.negation == true»
																		if (value != false) {
																			valid = false;
																		}
																	«ELSE»
																		if (value != true) {
																			valid = false;
																		}
																	«ENDIF»
																}
																else {
																	Boolean value = (refFeatureObject == null);
																	«IF feat.value !== null && feat.value.equals("null")»
																		if (value != true) {
																			valid = false;
																		}
																	«ELSE»
																		if (value != false) {
																			valid = false;
																		}
																	«ENDIF»
																}
															}
														}
													}
												«ENDIF»
											}
										}
									«ENDFOR»
									if (valid != true) {
										continue;
									}
								«ENDIF»
								Map<String, String> parameters = new LinkedHashMap<String, String>();
								List<Map<String, String>> rels = new ArrayList<Map<String, String>>();
								List<String> source = new ArrayList<String>();
								List<String> target = new ArrayList<String>();
								String label = "";
								String src_label = "";
								String tar_label = "";
								«IF edge.targetNode === null»
									for (EReference ref : edge.eClass().getEAllReferences()) {
									«IF edge.source !== null»
										if (ref.getName().equals("«edge.source.name»")) {
											EObject src = (EObject) edge.eGet(ref);
											if (src != null) {
												for (EAttribute att : src.eClass().getEAllAttributes()) {
												«IF edge.attName !== null»
													if (att.getName().equals("«edge.attName.name»")) {
												«ELSE»
													if (att.getName().equals("name")) {
												«ENDIF»
												source.add((String) src.eGet(att));
												break;
													}
												}
											}
										}
									«ENDIF»
									«IF edge.target !== null»
										if (ref.getName().equals("«edge.target.name»")) {
											EObject tar = (EObject) edge.eGet(ref);
											if (tar != null) {
												for (EAttribute att : tar.eClass().getEAllAttributes()) {
												«IF edge.attName !== null»
													if (att.getName().equals("«edge.attName.name»")) {
												«ELSE»
													if (att.getName().equals("name")) {
												«ENDIF»
												target.add((String) tar.eGet(att));
												break;
													}
												}
											}
										}
									«ENDIF»
									}
								«ENDIF»
								«IF edge.targetNode !== null»
									List<EObject> targetNodes = ModelManager.getConnectedObjectsOfType("«edge.targetNode.name»", edge);
									for (EObject targetNode : targetNodes) {
										EObject featObject = null;
										«IF edge.targetFeature !== null»
											boolean targetValid = true;
											«FOR ValuedFeature feat : edge.targetFeature»
												for (EStructuralFeature feat : targetNode.eClass().getEAllStructuralFeatures()) {
													if (feat.getName().equals("«feat.feat.name»")) {
														Object ob = targetNode.eGet(feat);
														if (ob instanceof EObject) {
															featObject = (EObject) ob;
														} 
														«IF feat.feat instanceof EAttribute»
															if (featObject instanceof Boolean) {
															Boolean value = (Boolean) featObject;
															«IF feat.negation == true»
																if (value != false) {
																	targetValid = false;
																}
															«ELSE»
																if (value != true) {
																	targetValid = false;
																}
															«ENDIF»
														}
													«ENDIF»
													«IF feat.feat instanceof EReference»
														«IF feat.refFeature === null»
															Boolean value = (featObject == null);
															«IF feat.value !== null && feat.value.equals("null")»
																if (value != true) {
																	targetValid = false;
																}
															«ELSE»
																if (value != false) {
																	targetValid = false;
																}
															«ENDIF»
														«ENDIF»
													«ENDIF»
													«IF feat.refFeature !== null»
														if (featObject instanceof EObject) {
															for (EStructuralFeature refFeature : ((EObject) featObject).eClass().getEAllStructuralFeatures()) {
																if (refFeature.getName().equals("«feat.refFeature.name»")) {
																	Object refFeatureObject = ((EObject) featObject).eGet(refFeature);
																	if (refFeatureObject instanceof Boolean) {
																		Boolean value = (Boolean) refFeatureObject;
																		«IF feat.negation == true»
																			if (value != false) {
																				targetValid = false;
																			}
																		«ELSE»
																			if (value != true) {
																				targetValid = false;
																			}
																		«ENDIF»
																	}
																	else {
																		Boolean value = (refFeatureObject == null);
																		«IF feat.value !== null && feat.value.equals("null")»
																			if (value != true) {
																				targetValid = false;
																			}
																		«ELSE»
																			if (value != false) {
																				targetValid = false;
																			}
																		«ENDIF»
																	}
																}
															}
														}
													«ENDIF»
												}
											}
										«ENDFOR»
										if (targetValid == false) {
											continue;
										}	
									«ENDIF»
									EObject src = null;
									EObject tar = null;
									if (featObject == null) {
										src = edge;
										tar = targetNode;
									}
									else {
										src = targetNode;
										tar = featObject;
									}
									String srcName = "";
									if (src != null) {
										for (EAttribute att : src.eClass().getEAllAttributes()) {
										«IF edge.attName !== null»
											if (att.getName().equals("«edge.attName.name»")) {
										«ELSE»
											if (att.getName().equals("name")) {
										«ENDIF»
										srcName = (String) src.eGet(att);
										break;
											}
										}
									}
									String tarName = "";
									if (tar != null) {
										for (EAttribute att : tar.eClass().getEAllAttributes()) {
										«IF edge.attName !== null»
											if (att.getName().equals("«edge.attName.name»")) {
										«ELSE»
											if (att.getName().equals("name")) {
										«ENDIF»
										tarName = (String) tar.eGet(att);
										break;
											}
										}
									}
									if (!srcName.isEmpty() && !tarName.isEmpty() && !source.contains(srcName)) { //&& !target.contains(tarName)) {
										source.add(srcName);
										target.add(tarName);
									}
								}
							«ENDIF» 
							«IF edge.reference !== null»
								«IF edge.label !== null || edge.src_label !== null || edge.tar_label !== null»
									label += "\"";
									«IF edge.reference.size > 0»
										for (EReference ref : edge.eClass().getEAllReferences()) {
											«var int i = 0»
											«var int j = 0»
											«FOR EReference reference : edge.reference»
												if (ref.getName().equals("«reference.name»")) {
													EObject obj = (EObject) edge.eGet(ref);
													if (obj != null) {
														«IF edge.label !== null && edge.label.size > i»
															«var boolean found = false»
															«FOR EAttribute att : reference.getEReferenceType.getEAllAttributes»
																«IF att.getName().equals(edge.label.get(i).getName())»
																	for (EAttribute att : obj.eClass().getEAllAttributes()) {
																	    if (att.getName().equals("«edge.label.get(i).name»")) {
																	     if (att.getEType().getName().equals("EString")) {
																	      label += (String) obj.eGet(att) + ", ";
																	     }
																	     if (att.getEType() instanceof EEnum) {
																	      EEnumLiteral value = (EEnumLiteral) obj.eGet(att);
																	      label += value.getName() + ", ";
																	     }
																	    }
																	}
																	//«found = true»
																	//«i++»
																«ENDIF»
															«ENDFOR»
															«IF found == false»
																for (EReference refType : obj.eClass().getEAllReferences()) {
																	//«var String refTypeName = Decoration.NONE.literal»
																	«IF edge.refType.size > j »
																		//«refTypeName = edge.refType.get(j).name»
																	«ENDIF»
																	if (refType.getName().equals("«refTypeName»")) {
																		EObject o = (EObject) ((EObject) edge.eGet(ref)).eGet(refType);
																		if (o != null) {
																		    for (EAttribute att : o.eClass().getEAllAttributes()) {
																		     if (att.getName().equals("«edge.label.get(i).name»")) {
																		         if (att.getEType().getName().equals("EString")) {
																		          label += (String) o.eGet(att) + ", ";
																		         }
																		         if (att.getEType() instanceof EEnum) {
																		          EEnumLiteral value = (EEnumLiteral) o.eGet(att);
																		          label += value.getName() + ", ";
																		      }
																		     }
																		    }
																		}
																	   }
																}
																//«i++»
																//«j++»
															«ENDIF»
														«ENDIF»
														«IF edge.src_label !== null»
															if (att.getName().equals("«edge.src_label.name»")) {
																src_label = "\"" + (String) obj.eGet(att) + "\"";
															}
														«ENDIF»
														«IF edge.tar_label !== null»
															if (att.getName().equals("«edge.tar_label.name»")) {
																tar_label = "\"" + (String) obj.eGet(att) + "\"";
															}
														«ENDIF»
													}
												}
											«ENDFOR»
										}
									«ENDIF»
									if (label.indexOf(",") > 0) {
										label = label.substring(0, label.lastIndexOf(","));
									}
									label += "\"";
								«ENDIF»
							«ELSE»
								«IF edge.label !== null || edge.src_label !== null || edge.tar_label !== null»
									label = "\"";
									for (EAttribute att : edge.eClass().getEAllAttributes()) {
									«IF edge.label !== null && edge.label.size > 0»
										«var int i = 0»
										«FOR EAttribute label : edge.label»
											if (att.getName().equals("«label.name»")) {
												if (att.getEType().getName().equals("EString")) {
													label += (String) edge.eGet(att) + ", ";
												}
												if (att.getEType() instanceof EEnum) {
													EEnumLiteral value = (EEnumLiteral) obj.eGet(att);
													label += value.getName() + ", ";
												}
											}
											//«i++»
										«ENDFOR»
									«ENDIF»
									«IF edge.src_label !== null»
										if (att.getName().equals("«edge.src_label.name»")) {
											src_label = "\"" + (String) edge.eGet(att) + "\"";
										}
									«ENDIF»
									«IF edge.tar_label !== null»
										if (att.getName().equals("«edge.tar_label.name»")) {
											tar_label = "\"" + (String) edge.eGet(att) + "\"";
										}
									«ENDIF»
									}
									if (label.indexOf(",") > 0) {
										label = label.substring(0, label.lastIndexOf(","));
									}
									label += "\""; 
								«ENDIF»
							«ENDIF»
							«edge.decorate»
							if (source.size() == target.size()) {
								for (int i = 0; i < source.size() && i < target.size(); i++) {
									if (dotrels.containsKey(source.get(i) + "->" + target.get(i)) == true) {
										rels = dotrels.get(source.get(i) + "->" + target.get(i));
									}
									else {
										rels = new ArrayList<Map<String, String>>();
									}
									boolean found = false;
									for (Map<String, String> rel : rels) {
										for (String key : rel.keySet()) {
											if (key.equals("label")) {
												for (String keyParameters : parameters.keySet()) {
													if (key.equals(keyParameters)) {
														if (parameters.get(keyParameters).length() > 1) {
															String value = rel.get(key);
															if (value.length() > 0) {
																value = value.substring(0, value.length() - 1);
															}
															value += "\n" + parameters.get(keyParameters).substring(1, parameters.get(keyParameters).length());
															rel.put(key, value);
															found = true;
														}
													}
												}
											}
										}
									}
									if (found == false) {
										rels.add(parameters);
									}
									dotrels.put(source.get(i) + "->" + target.get(i), rels);
								}
							}
							else {
								for (int i = 0; i < source.size(); i++) {
									if (dotrels.containsKey(source.get(i) + "->" + target.get(i)) == true) {
										rels = dotrels.get(source.get(i) + "->" + target.get(i));
									}
									else {
										rels = new ArrayList<Map<String, String>>();
									}
									boolean found = false;
									for (Map<String, String> rel : rels) {
										for (String key : rel.keySet()) {
											if (key.equals("label")) {
												for (String keyParameters : parameters.keySet()) {
													if (key.equals(keyParameters)) {
														if (parameters.get(keyParameters).length() > 1) {
															String value = rel.get(key);
															if (value.length() > 0) {
																value = value.substring(0, value.length() - 1);
															}
															value += "\n" + parameters.get(keyParameters).substring(1, parameters.get(keyParameters).length());
															rel.put(key, value);
															found = true;
														}
													}
												}
											}
										}
									}
									if (found == false) {
										rels.add(parameters);
									}
									dotrels.put(source.get(i) + "->" + target.get(i), rels);
								}
							}
							}
						«ENDIF»
						«IF rel instanceof Level»
							//«var level = rel as Level»
							List<EObject> llevel_«counter» = ModelManager.getObjectsOfType("«level.name.name»", model);
							for (EObject level : llevel_«counter») {
								Map<String, String> parameters = new LinkedHashMap<String, String>();
								List<Map<String, String>> rels = new ArrayList<Map<String, String>>();
								String source = "";
								List<String> target = new ArrayList<String>();
								for (EAttribute att : level.eClass().getEAllAttributes()) {
									«IF level.attName !== null»
										if (att.getName().equals("«level.attName.name»")) {
									«ELSE»
										if (att.getName().equals("name")) {
									«ENDIF»
									source = (String) level.eGet(att);
									break;
									}
								}
								for (EReference ref : level.eClass().getEAllReferences()) {
									«IF level.upper !== null»
										if (ref.getName().equals("«level.upper.name»")) {
											if (ref.getUpperBound() < 0 || ref.getUpperBound() > 1) {
												List<EObject> ltar = (List<EObject>) level.eGet(ref);
												if (ltar != null) {
													for (EObject otar : ltar) {
														if (otar != null) {
															for (EAttribute att : otar.eClass().getEAllAttributes()) {
																«IF level.attName !== null»
																	if (att.getName().equals("«level.attName.name»")) {
																«ELSE»
																	if (att.getName().equals("name")) {
																«ENDIF»
																target.add((String) otar.eGet(att));
																break;
																}
															}
														}
													}
												}
											}
											else {
												EObject tar = (EObject) level.eGet(ref);
												if (tar != null) {
													for (EAttribute att : tar.eClass().getEAllAttributes()) {
													«IF level.attName !== null»
														if (att.getName().equals("«level.attName.name»")) {
													«ELSE»
														if (att.getName().equals("name")) {
													«ENDIF»
													target.add((String) tar.eGet(att));
													break;
														}
													}
												}
											}
										}
									«ENDIF»
								}
								«level.decorate»
								for (String tar : target) {
									if ((source != null) && (tar != null)) {
										if (source.length() > 0 && tar.length() > 0) {
											if (dotrels.containsKey(source + "->" + tar) == true) {
												rels = dotrels.get(source + "->" + tar);
											}
											else {
												rels = new ArrayList<Map<String, String>>();
											}
											if (source.length() > 0 && tar.length() > 0) {
												if (rels.contains(parameters) == false) {
													rels.add(parameters);
													dotrels.put(source + "->" + tar, rels);
												}
											}
										}
									}
								}
							}
						«ENDIF»
						// COUNTER: «counter = counter + 1»
					«ENDFOR»
					for (String relname : dotrels.keySet()) {
						List<Map<String, String>> rels = dotrels.get(relname);
						for (Map<String, String> params : rels) {
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
							List<String> lconf = null;
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
			«ENDIF»
			«ENDIF»
			
			public void generateGraphs(File file, String folder, List<EPackage> packages, File exercise, String projectName, IProgressMonitor monitor) throws ModelNotFoundException, FileNotFoundException, UnsupportedEncodingException {
			if (file.isFile()) {
				String pathfile = file.getPath();
				if (pathfile.endsWith(".model") == true) {
					String printPathfile = pathfile.replace("\\", "/");
					printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
					monitor.subTask("Rendering image for mutant " + printPathfile);
					Resource model = ModelManager.loadModel(packages, pathfile);
					String path = exercise.getName() + "/";
					List<String> folders = Arrays.asList(folder.split("/"));
					if (folders.size() > 0) {
						for (String folderName : folders) {
							path += folderName + "/";
						}
					}
					String dotfile = "«folder»src-gen/html/diagrams/" + path + "«roots.get(0).name»_" + file.getName().replace(".model", ".dot");
					String pngfile = "«folder»src-gen/html/diagrams/" + path + "«roots.get(0).name»_" + file.getName().replace(".model", ".png");
					«draw.generate(folder)»
					File exercisefolder = new File("«folder»src-gen/html/diagrams/" + path);
					if (exercisefolder.exists() != true) {
						exercisefolder.mkdirs();
					}
					PrintWriter dotwriter = new PrintWriter(dotfile, "UTF-8");
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
				
				// GENERATES PNG FILES FROM SOURCE MODELS
				File folder = new File("«folder»data/model");
				for (File file : folder.listFiles()) {
					if (file.isFile()) {
						String pathfile = file.getPath();
						if (pathfile.endsWith(".model") == true) {
							String printPathfile = pathfile.replace("\\", "/");
							printPathfile = printPathfile.substring(printPathfile.lastIndexOf("/" + projectName + "/") + ("/" + projectName + "/").length(), printPathfile.length());
							monitor.subTask("Rendering image for model " + printPathfile);
							Resource model = ModelManager.loadModel(packages, pathfile);
							String dotfile = "«folder»src-gen/html/diagrams/" + 
								file.getName().replace(".model", "") + "/" +
								"«roots.get(0).name»_" + file.getName().replace(".model", ".dot");
							String pngfile = "«folder»src-gen/html/diagrams/" + 
								file.getName().replace(".model", "") + "/" +
								"«roots.get(0).name»_" + file.getName().replace(".model", ".png");
							«draw.generate(folder)»
							File diagramsfolder = new File("«folder»src-gen/html/diagrams/");
							if (diagramsfolder.exists() != true) {
								diagramsfolder.mkdir();
							}
							File dotfolder = new File("«folder»src-gen/html/diagrams/" + 
								file.getName().replace(".model", "") + "/");
							if (dotfolder.exists() != true) {
								dotfolder.mkdir();
							}
							PrintWriter dotwriter = null;
							try {
								dotwriter = new PrintWriter(dotfile, "UTF-8");
								for (String dotline : dotcode) {
									dotwriter.println(dotline);
								}
								dotwriter.close();
							} catch (UnsupportedEncodingException e) {
								//Reload input
											try {
									model.unload();
									model.load(null);
								} catch (Exception ex) {}
								continue;
							}
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
							monitor.worked(1);
						}
					}
				}
		
				// GENERATES PNG FILES FROM MUTANTS
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
							String dotfile = "«folder»src-gen/html/diagrams/" + exercise.getName() + "/" +
								"«roots.get(0).name»_" + file.getName().replace(".model", ".dot");
							String pngfile = "«folder»src-gen/html/diagrams/" + exercise.getName() + "/" +
							"«roots.get(0).name»_" + file.getName().replace(".model", ".png");
							«draw.generate(folder)»
							File diagramsfolder = new File("«folder»src-gen/html/diagrams/");
							if (diagramsfolder.exists() != true) {
								diagramsfolder.mkdir();
							}
							File dotfolder = new File("«folder»src-gen/html/diagrams/" + exercise.getName() + "/");
							if (dotfolder.exists() != true) {
								dotfolder.mkdir();
							}
							PrintWriter dotwriter = null;
							try {
								dotwriter = new PrintWriter(dotfile, "UTF-8");
								for (String dotline : dotcode) {
									dotwriter.println(dotline);
								}
								dotwriter.close();
							} catch (UnsupportedEncodingException e) {
								//Reload input
											try {
									model.unload();
									model.load(null);
								} catch (Exception ex) {}
								continue;
							}
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
