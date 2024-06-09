package wodel.dsls.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.core.resources.IProject
import org.eclipse.emf.ecore.EClass
import java.util.Map
import org.eclipse.emf.common.util.URI
import java.util.HashMap
import java.util.Map.Entry
import java.util.AbstractMap.SimpleEntry
import wodel.utils.manager.ProjectUtils
import java.io.File
import java.util.List
import java.util.ArrayList
import wodel.utils.manager.ModelManager
import mutatorenvironment.MutatorEnvironment
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.core.runtime.Platform
import mutatorenvironment.MutatorenvironmentFactory
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.EPackage
import wodel.utils.manager.UseGeneratorUtils
import mutatorenvironment.Constraint
import mutatorenvironment.miniOCL.InvariantCS
import wodel.dsls.WodelUtils
import org.eclipse.emf.ecore.EStructuralFeature

/**
 * @author Pablo Gomez-Abajo - Wodel USE code generator.
 * 
 * Generates the USE code and the .properties file for
 * the seeds synthesizer.
 *  
 */

class WodelUseGenerator extends AbstractGenerator {
		private static class Cardinality {
		int min = 0
		int max = 0
	}
	
	private IProject project = null
	private String fileName
	private String modelName
	private String useName
	private String propertiesName
	private String path
	private EClass root
	private String dummyClassName = "Dummy"
	private Map<URI, Map<URI, Entry<String, String>>> useReferences = new HashMap<URI, Map<URI, Entry<String, String>>>()
	public String predefinedConfiguration = null;
	public String configurationName = null;
	public Map<String, Integer> numObjects = null;
	public Map<String, SimpleEntry<String, String>> tagsByClass = null;
//	public List<String> classesWithAttributeName = null;
//	public List<String> specificOCLCode = null;
//	public List<String> propertiesNames = null;
	
	private int maxInteger
	private int minInteger
	private int maxReal
	private int minReal
	private int maxString
	private int maxObjectsCardinality
	private int maxAssociationsCardinality
	
	def String getProjectName() {
		var String projectName = null
		if (ProjectUtils.project !== null) {
			projectName = ProjectUtils.project.name
		}
		else {
			projectName = ProjectUtils.projectName
		}
		return projectName
	}

	def List<String> getMutators(File[] files) {
		var List<String> mutators = new ArrayList<String>()
		if (files !== null) {
			for (File file : files) {
				if (file !== null) {
					if (file.isFile == true) {
						if (file.getName().endsWith(".mutator")) {
							var mutator = file.getName().replaceAll(".mutator", "")
							if (!mutators.contains(mutator)) {
								mutators.add(mutator)
							}
						}
					}
					else if (file.isDirectory == true) {
						var List<String> nextMutators = new ArrayList<String>()
						nextMutators.addAll(getMutators(file.listFiles))
						for (String nextMutator : nextMutators) {
							if (!mutators.contains(nextMutator)) {
								mutators.add(nextMutator)
							}
						}
					}
				}
			}
		}
		return mutators
	}
	
	def String getMutatorPath(MutatorEnvironment e, File[] files) {
		var String mutatorPath = null
		if (mutatorPath === null && files !== null) {
			for (File file : files) {
				if (mutatorPath !== null) {
					return mutatorPath
				}
				if (file !== null) {
				 	if (file.isFile == true) {
						if (file.getName().equals(fileName)) {
							var mutatorFolderAndFile = file.path.substring(file.path.indexOf(getProjectName)).replace("\\", "/")
							mutatorPath = "file:/" + ModelManager.getWorkspaceAbsolutePath(e) + "/" + mutatorFolderAndFile
						}
					}
					else  {
						mutatorPath = getMutatorPath(e, file.listFiles)
					}
				}
			}
		}
		return mutatorPath
	}
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		ProjectUtils.resetProject()
		project = ProjectUtils.getProject()
		path = ModelManager.getWorkspaceAbsolutePath(this.class) + '/' + getProjectName	

		var MutatorEnvironment mutatorEnvironment = null
		for(e: resource.allContents.toIterable.filter(MutatorEnvironment)) {
			maxInteger = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum integer value", "100", null))
			minInteger = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Minimum integer value", "-100", null))
			maxReal = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum real value", "100", null))
			minReal = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Minimum real value", "0", null))
			maxString = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum string value", "10", null))
			maxObjectsCardinality = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum cardinality for objects value", "10", null))
			maxAssociationsCardinality = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Maximum cardinality for associations value", "10", null))
			fileName = resource.URI.lastSegment
					
			fileName = fileName.replaceAll(".mutator", ".java").replace(".model", ".java")
			modelName = fileName.replaceAll(".java", "")
			useName = fileName.replaceAll(".java", ".use")
			propertiesName = fileName.replaceAll(".java", ".properties")
			fsa.generateFile(useName, e.use(resource, resource).removeComments("use"))
			fsa.generateFile(propertiesName, e.properties(resource, resource).removeComments("properties"))
			mutatorEnvironment = e
			for (b : mutatorEnvironment.blocks) {
				fileName = resource.URI.lastSegment
				fileName = fileName.replaceAll(".model", "").replaceAll(".mutator", "_" + b.name + ".java").replace(".model", "_" + b.name + ".java")
				modelName = fileName.replaceAll(".java", "")
				useName = fileName.replaceAll(".java", ".use")
				propertiesName = fileName.replaceAll(".java", ".properties")
				val MutatorEnvironment blockMutatorEnvironment = MutatorenvironmentFactory.eINSTANCE.createMutatorEnvironment
				blockMutatorEnvironment.definition = EcoreUtil.copy(e.definition)
				blockMutatorEnvironment.blocks.add(EcoreUtil.copy(b))
				val Resource blockResource = ModelManager.createModel("file://" + ModelManager.getWorkspaceAbsolutePath(this.class) + '/' + getProjectName + '/' + ModelManager.outputFolder + "/" + modelName + ".model")
				blockResource.contents.add(blockMutatorEnvironment)
				fsa.generateFile(useName, blockMutatorEnvironment.use(resource, blockResource).removeComments("use"))
				fsa.generateFile(propertiesName, blockMutatorEnvironment.properties(resource, blockResource).removeComments("properties"))
			}
		}
	}
	
	def CharSequence removeComments(CharSequence contents, String type) {
		if (type.equals("use")) {
			return contents.toString.replaceAll("--.*", "").replaceAll("(?m)^[ \t]*\r?\n", "")
		}
		if (type.equals("properties")) {
			return contents.toString.replaceAll("#.*", "").replaceAll("(?m)^[ \t]*\r?\n", "")
		}
	}
	
	def getRandom(int range) {
		if(range==1) return 0
		
        var int value = System.nanoTime().intValue % range
        if (value<0) value= value*-1
        
        return value
	}
	
   def void incContainers(EClass eclass, HashMap<String, Cardinality> classes, List<EPackage> packages, EClass root) {
   		var List<EClassifier> containers = ModelManager.getContainerTypes(packages, EcoreUtil.getURI(eclass))
   		for (EClassifier container : containers) {
   			if (!container.name.equals(root.name) && !container.name.equals(eclass.name)) {
   				var Cardinality cardinality = classes.get(container.name)
   				for (EReference ref : (container as EClass).EAllReferences) {
   					if (ref.EType.name.equals(eclass.name)) {
   						if (ref.isContainment) {
   							if (cardinality.min == 0) {
   								cardinality.min++
   							}
   						}
   					}
   				}
   				classes.put(container.name, cardinality)
   				incContainers(container as EClass, classes, packages, root)
   			}
   		}
   }
  
   def void processBlocks(HashMap<String, Cardinality> classes, HashMap<String, HashMap<String, Cardinality>> blockCardinalities) {
		for (String blockName : blockCardinalities.keySet()) {
			var HashMap<String, Cardinality> cardinality = blockCardinalities.get(blockName)
			for (String className : cardinality.keySet()) {
				var Cardinality cBlock = cardinality.get(className)
				var Cardinality cMain = classes.get(className)
				if (cBlock.min > cMain.min) {
					cMain.min = cBlock.min
				} 
				classes.put(className, cMain)
			}
		}
   }
   
   def generate(MutatorEnvironment e, Resource program, List<EClass> eclasses, HashMap<URI, String> classNames) '''
		# «var HashMap<String, Cardinality> classes = new HashMap<String, Cardinality>()»
		«IF numObjects === null»
		«FOR classURI : classNames.keySet()»
		# «var Cardinality cardinality = new Cardinality»
		# «cardinality.min = 0»
		«IF EcoreUtil.getURI(root).equals(classURI)»
		# «cardinality.min++»
		# «cardinality.max = 1»
		«ELSE»
		# «cardinality.max = maxObjectsCardinality»
		«ENDIF»
		# «classes.put(classNames.get(classURI), cardinality)»
		«ENDFOR»
		
		«IF e.blocks.size > 0»
		# «var HashMap<String, HashMap<String, Cardinality>> blockCardinalities = new HashMap<String, HashMap<String, Cardinality>>()»
		«FOR b : e.blocks»
		# «var HashMap<String, Cardinality> cls = new HashMap<String, Cardinality>()»
		«FOR classURI : classNames.keySet()»
		# «var Cardinality cardinality = new Cardinality»
		# «cardinality.min = 0»
		«IF EcoreUtil.getURI(root).equals(classURI)»
		# «cardinality.min++»
		# «cardinality.max = 1»
		«ELSE»
		# «cardinality.max = maxObjectsCardinality»
		«ENDIF»
		«ENDFOR»
		# «blockCardinalities.put(b.name, cls)»
		«ENDFOR»
		
		#«classes.processBlocks(blockCardinalities)»
		«ENDIF»
		
		«FOR classURI : classNames.keySet()»
		«var String useClassName = classNames.get(classURI)»
		«UseGeneratorUtils.encodeWord(useClassName)»_min = «classes.get(useClassName).min»
		«UseGeneratorUtils.encodeWord(useClassName)»_max = «classes.get(useClassName).max»
		«ENDFOR»
		«ELSE»
		
		«FOR eclass : eclasses»
		# «var Cardinality cardinality = new Cardinality»
		# «cardinality.min = 0»
		«IF EcoreUtil.getURI(root).equals(EcoreUtil.getURI(eclass))»
		# «cardinality.min++»
		# «cardinality.max = 1»
		«ELSE»
		«IF numObjects.containsKey(eclass.getName())»
		# «cardinality.min = numObjects.get(eclass.getName())»
		# «cardinality.max = numObjects.get(eclass.getName())»
		«ENDIF»
		«ENDIF»
		# «classes.put(classNames.get(EcoreUtil.getURI(eclass)), cardinality)»
		«ENDFOR»
		
		«FOR classURI : classNames.keySet()»
		«var String useClassName = classNames.get(classURI)»
		«UseGeneratorUtils.encodeWord(useClassName)»_min = «classes.get(useClassName).min»
		«UseGeneratorUtils.encodeWord(useClassName)»_max = «classes.get(useClassName).max»
		«ENDFOR»
		«ENDIF»
		
		«IF tagsByClass !== null && tagsByClass.size() > 0»
		# «var Map<String, SimpleEntry<String, String>> tagsByClassURI = new HashMap<String, SimpleEntry<String, String>>()»
		«FOR eclass : eclasses»
		«IF tagsByClass.containsKey(eclass.getName())»
		# «tagsByClassURI.put(classNames.get(EcoreUtil.getURI(eclass)), tagsByClass.get(eclass.getName()))»
		«ENDIF»
		«ENDFOR»
		
		«FOR classURI : classNames.keySet()»
		«var String useClassName = classNames.get(classURI)»
		«IF tagsByClassURI.containsKey(classNames.get(classURI))»
		«UseGeneratorUtils.encodeWord(useClassName)»_«tagsByClassURI.get(classNames.get(classURI)).getKey()» = Set{«tagsByClassURI.get(classNames.get(classURI)).getValue()»}
		«ENDIF»
		«ENDFOR»
		«ENDIF»
		

		«FOR classURI : classNames.keySet()»
		«var String useClassName = classNames.get(classURI)»
		«UseGeneratorUtils.encodeWord(useClassName)»_min = «classes.get(useClassName).min»
		«UseGeneratorUtils.encodeWord(useClassName)»_max = «classes.get(useClassName).max»
		«ENDFOR»

«««		«IF configurationName != null && configurationName.length > 0»
«««		«UseGeneratorUtils.processPropertiesConfiguration(e, program, modelName, useReferences, predefinedConfiguration, configurationName)»
«««		«ENDIF»

		# Associations
		# «var HashMap<String, Integer> associationNames = new HashMap<String, Integer>()»
		«FOR eclass : eclasses»
		# «var EPackage pck = eclass.EPackage»
		# «var List<EReference> refs = eclass.getEAllReferences()»
		«IF refs.size > 0»
		«FOR ref : refs»
		# «var EPackage refEPackage = ref.EReferenceType.EPackage»
		«IF refEPackage !== null»
		# «var String associationName = pck.name + "XxxX" + eclass.name + "XxxX" + refEPackage.name + "XxxX" + ref.EType.name»
		«IF associationNames.get(associationName) !== null»
		# «associationNames.put(associationName, associationNames.get(associationName) + 1)»
		# «associationName += associationNames.get(associationName)»
		«ELSE»
		# «associationNames.put(associationName, 0)»
		«ENDIF»
		# «var int min = 0»
		«IF classes.get(refEPackage.name + "XxxX" + ref.EType.name) !== null»
		«IF (classes.get(pck.name + "XxxX" + eclass.name).min < classes.get(refEPackage.name + "XxxX" + ref.EType.name).min)»
		# «min = classes.get(pck.name + "XxxX" + eclass.name).min»
		«ELSE»
		# «min = classes.get(refEPackage.name + "XxxX" + ref.EType.name).min»
		«ENDIF»
		«ELSE»
		# «min = 0»
		«ENDIF»
		«UseGeneratorUtils.encodeWord(associationName)»_min = «min»
		«UseGeneratorUtils.encodeWord(associationName)»_max = «maxAssociationsCardinality»
		«ENDIF»
		«ENDFOR»
		«ENDIF»
		«ENDFOR»
   '''
   
   def properties(MutatorEnvironment e, Resource program, Resource model) '''
		[default]
		
		Integer_min = «minInteger»
		Integer_max = «maxInteger»
		
		Real_min = «minReal»
		Real_max = «maxReal»
		
		String_max = «maxString»
		
		«dummyClassName»_min = 1
		«dummyClassName»_max = 1
		
		# «var List<EPackage> packages = ModelManager.loadMetaModel(e.definition.metamodel)»
		# «var List<EClass> eclasses = ModelManager.getEClasses(packages)»
		# «var HashMap<URI, String> classNames = UseGeneratorUtils.buildClassNames(eclasses)»
		# «root = ModelManager.getRootEClass(packages)»
		
		«e.generate(program, eclasses, classNames)»
		aggregationcyclefreeness = on
		forbiddensharing = on
		
   '''
   
   def use(MutatorEnvironment e, Resource program, Resource model) '''
«««	«UseGeneratorUtils.generateUSE(model, e, modelName, useReferences, numObjects, classesWithAttributeName, specificOCLCode)»
	«UseGeneratorUtils.generateUSE(model, e, modelName, useReferences)»
	«var int i = 0»
	«FOR Constraint constraint : e.constraints»
	«IF constraint.expressions !== null»
	«FOR InvariantCS inv : constraint.expressions»
	«var String constraintText = WodelUtils.getConstraintText(fileName, inv)»
	«IF constraintText.length > 0»
	«var String feature = constraintText.substring(0, constraintText.indexOf("->"))»
	«var EClass eclass = constraint.type»
	«var EClass featureclass = null»
	«FOR EStructuralFeature sf : eclass.EAllStructuralFeatures»
	«IF (sf.name.equals(feature))»
	-- «featureclass = sf.EType as EClass»
	«ENDIF»
	«ENDFOR»
	«IF featureclass !== null»
	inv mutcode«i» : «featureclass.name».allInstances()->«constraintText.substring(constraintText.indexOf("->") + "->".length, constraintText.length())»
	-- «i++»
	«ENDIF»
	«ENDIF»
	«ENDFOR»
	«ENDIF»
	«IF constraint.rules !== null»
	«FOR String rule : constraint.rules»
	«IF rule.length > 0»
	«var String feature = rule.substring(0, rule.indexOf("->"))»
	«var EClass eclass = constraint.type»
	«var EClass featureclass = null»
	«FOR EStructuralFeature sf : eclass.EAllStructuralFeatures»
	«IF (sf.name.equals(feature))»
	-- «featureclass = sf.EType as EClass»
	«ENDIF»
	«ENDFOR»
	«IF featureclass !== null»
	inv mutcode«i» : «featureclass.name».allInstances()->«rule.substring(rule.indexOf("->") + "->".length, rule.length())»
	-- «i++»
	«ENDIF»
	«ENDIF»
	«ENDFOR»
	«ENDIF»
	«ENDFOR»
	'''
}