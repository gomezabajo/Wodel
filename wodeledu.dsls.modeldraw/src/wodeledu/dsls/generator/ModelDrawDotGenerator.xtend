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

	private def String rootTypeName() {
		if (roots !== null && !roots.empty && roots.get(0) !== null && roots.get(0).name !== null) {
			return roots.get(0).name
		}
		"Model"
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

	def generate(MutatorDraw draw) '''
		Map<EObject, LabelStyle> dotnodes = new LinkedHashMap<EObject, LabelStyle>();
		Map<String, List<Map<String, String>>> dotrels = new LinkedHashMap<String, List<Map<String, String>>>();
		Map<String, List<String>> dottext = new LinkedHashMap<String, List<String>>();
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
		
		import java.io.BufferedReader;
		import java.io.File;
		import java.io.IOException;
		import java.lang.InterruptedException;
		import java.net.URL;
		import java.net.URISyntaxException;
		import java.nio.charset.StandardCharsets;
		import java.nio.file.Files;
		import java.nio.file.Path;
		import java.util.ArrayList;
		import java.util.HashMap;
		import java.util.Map;
		import java.util.LinkedHashMap;
		import java.util.List;
		import java.util.Collections;
		import java.util.concurrent.TimeUnit;
		
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
		
		import org.eclipse.core.runtime.FileLocator;
		import org.eclipse.core.runtime.IProgressMonitor;
		import org.eclipse.core.runtime.NullProgressMonitor;
		import org.eclipse.core.runtime.Platform;
		
		import org.eclipse.jface.operation.IRunnableWithProgress;
			
		import java.lang.reflect.InvocationTargetException;
			
		import org.eclipse.core.commands.AbstractHandler;
		
		import org.eclipse.core.commands.ExecutionEvent;
		import org.eclipse.core.commands.ExecutionException;
		
		import org.eclipse.core.resources.IProject;
		
		import org.eclipse.jface.dialogs.ProgressMonitorDialog;
		
		import org.eclipse.swt.widgets.Shell;
		
		import org.eclipse.ui.handlers.HandlerUtil;
		import org.osgi.framework.Bundle;
		
		public class «className»Draw extends AbstractHandler implements wodeledu.extension.run.commands.IMutatorDraw {

			private static final String MODEL_EXTENSION = ".model";
			private static final String ECORE_EXTENSION = ".ecore";
			private static final String DIAGRAM_PREFIX = "«javaString(rootTypeName)»";
			private static final String METAMODEL_FILE_NAME = "«javaString(lastSegment(draw.metamodel))»";
			private static final String RENDERER_PLUGIN_ID = "wodeledu.dsls.EduTest";
			private static final String RENDERER_PREFERENCE = "Model-Draw renderer path";
			private static final String[] LOGIC_IMAGE_BUNDLE_IDS = {
				"wodel.wodeledu",
				"wodeledu.models"
			};
		
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
											style.path = resolveLogicImage(typeName);
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
											style.path = resolveLogicImage(typeName);
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
															«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
																style.shape = "shape = «node.shape»";
															«ENDIF»
															«IF node.shape == NodeShape.LOGIC»
																style.path = resolveLogicImage(typeName);
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
																style.path = resolveLogicImage(typeName);
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
																«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOGIC»
																	style.path = resolveLogicImage(typeName);
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
																	style.path = resolveLogicImage(typeName);
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
																«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOGIC»
																	style.path = resolveLogicImage(typeName);
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
																	style.path = resolveLogicImage(typeName);
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
																«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOGIC»
																	style.path = resolveLogicImage(typeName);
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
																	style.path = resolveLogicImage(typeName);
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
																«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOGIC»
																	style.path = resolveLogicImage(typeName);
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
																	style.path = resolveLogicImage(typeName);
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
																«IF node.shape != NodeShape.LOAD && node.shape != NodeShape.LOGIC»
																	style.shape = "shape = «node.shape»";
																«ENDIF»
																«IF node.shape == NodeShape.LOGIC»
																	style.path = resolveLogicImage(typeName);
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
																	style.path = resolveLogicImage(typeName);
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

		private String resolveDotExecutable() {
			String rendererPath = Platform.getPreferencesService().getString(
					RENDERER_PLUGIN_ID,
					RENDERER_PREFERENCE,
					"",
					null
			);

			if (rendererPath != null && !rendererPath.isBlank()) {
				File configured = new File(rendererPath).getAbsoluteFile();
				if (configured.isFile()) {
					return configured.getAbsolutePath();
				}
				if (configured.isDirectory()) {
					String executableName = isWindows() ? "dot.exe" : "dot";
					File executable = new File(configured, executableName);
					if (executable.isFile()) {
						return executable.getAbsolutePath();
					}
				}
			}

			// Graphviz may already be available on PATH.
			return "dot";
		}

		private boolean isWindows() {
			return System.getProperty("os.name", "")
					.toLowerCase()
					.contains("win");
		}

		private String resolveLogicImage(String typeName) {
			String imageName = "logic_"
					+ (typeName != null ? typeName.toLowerCase() : "")
					+ ".png";
			String entryPath = "/content/images/" + imageName;

			for (String bundleId : LOGIC_IMAGE_BUNDLE_IDS) {
				Bundle bundle = Platform.getBundle(bundleId);
				if (bundle == null) {
					continue;
				}
				URL entry = bundle.getEntry(entryPath);
				if (entry == null) {
					continue;
				}
				try {
					URL fileUrl = FileLocator.toFileURL(entry);
					return new File(fileUrl.toURI())
							.getAbsolutePath()
							.replace('\\', '/');
				}
				catch (Exception e) {
					// Try the next candidate bundle.
				}
			}

			throw new IllegalStateException(
					"Cannot resolve ModelDraw logic image: " + imageName
			);
		}

		private void runGraphviz(
				String dotExecutable,
				File dotFile,
				File pngFile,
				IProgressMonitor monitor)
				throws IOException, InterruptedException {

			checkCanceled(monitor);

			ProcessBuilder builder = new ProcessBuilder(
					dotExecutable,
					"-Tpng",
					dotFile.getAbsolutePath(),
					"-o",
					pngFile.getAbsolutePath()
			);
			builder.directory(dotFile.getParentFile());
			builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
			builder.redirectError(ProcessBuilder.Redirect.INHERIT);

			Process process;
			try {
				process = builder.start();
			}
			catch (IOException e) {
				throw new IOException(
						"Cannot execute Graphviz 'dot'. Configure '"
						+ RENDERER_PREFERENCE
						+ "' with the Graphviz executable/bin directory or add Graphviz to PATH.",
						e
				);
			}

			waitForProcess(process, monitor, "Graphviz dot");

			if (!pngFile.isFile()) {
				throw new IOException("Graphviz did not create the expected PNG: " + pngFile);
			}
		}

		private void waitForProcess(
				Process process,
				IProgressMonitor monitor,
				String description)
				throws IOException, InterruptedException {
			try {
				while (!process.waitFor(200, TimeUnit.MILLISECONDS)) {
					checkCanceled(monitor);
				}
				int exitCode = process.exitValue();
				if (exitCode != 0) {
					throw new IOException(description + " failed with exit code " + exitCode);
				}
			}
			catch (InterruptedException e) {
				if (process.isAlive()) {
					process.destroyForcibly();
				}
				Thread.currentThread().interrupt();
				throw e;
			}
		}

		private void renderModel(
				File modelFile,
				List<EPackage> packages,
				File outputDirectory,
				File projectDirectory,
				String dotExecutable,
				IProgressMonitor monitor,
				boolean mutant)
				throws MetaModelNotFoundException, ModelNotFoundException,
				       IOException, InterruptedException {

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
			monitor.subTask(
					"Rendering image for " + (mutant ? "mutant " : "model ") + displayPath
			);

			Resource model = null;
			try {
				model = ModelManager.loadModel(packages, modelFile.getAbsolutePath());
				«draw.generate()»

				String outputBaseName = DIAGRAM_PREFIX + "_" + stripExtension(modelFile.getName());
				File dotFile = new File(outputDirectory, outputBaseName + ".dot");
				File pngFile = new File(outputDirectory, outputBaseName + ".png");

				Files.write(dotFile.toPath(), dotcode, StandardCharsets.UTF_8);
				runGraphviz(dotExecutable, dotFile, pngFile, monitor);
				monitor.worked(1);
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
			String dotExecutable = resolveDotExecutable();

			List<EPackage> packages = ModelManager.loadMetaModel(metamodelFile.getAbsolutePath());
			List<String> models = ModelManager.getModels(«className»Draw.class);
			List<String> mutants = ModelManager.getMutants(«className»Draw.class);
			if (models == null) {
				models = Collections.emptyList();
			}
			if (mutants == null) {
				mutants = Collections.emptyList();
			}

			monitor.beginTask("Rendering GraphViz diagrams", models.size() + mutants.size());
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
							dotExecutable,
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
							? safeRelativize(mutantRoot, parentFile.toPath().toAbsolutePath().normalize())
							: "";
					File outputDirectory = relative.isEmpty()
							? diagramsDirectory
							: new File(diagramsDirectory, relative);

					renderModel(
							mutantFile,
							packages,
							outputDirectory,
							projectDirectory,
							dotExecutable,
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
				throw new InterruptedException("GraphViz rendering was canceled");
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
                /*
                 * Interactive command entry point. When Eclipse invokes this
                 * handler from the UI, use the active shell for a progress
                 * dialog. If no UI shell is available, fall back to direct
                 * execution rather than failing.
                 */
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
                                "Error rendering Wodel-EDU GraphViz diagrams",
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
                            "Error rendering Wodel-EDU GraphViz diagrams",
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
                /*
                 * Non-UI extension entry point used reflectively by Wodel.
                 * It is commonly called from Wodel's existing background
                 * progress operation, where there may be no active workbench
                 * window. Do not open a nested ProgressMonitorDialog here.
                 */
                try {
                    generate(new NullProgressMonitor());
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException(
                            "GraphViz rendering was interrupted",
                            e
                    );
                }
                catch (Exception e) {
                    throw new IllegalStateException(
                            "Error rendering Wodel-EDU GraphViz diagrams",
                            e
                    );
                }
            }
        }
	'''
}
