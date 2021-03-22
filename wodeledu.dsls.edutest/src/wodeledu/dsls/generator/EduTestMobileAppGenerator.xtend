package wodeledu.dsls.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import manager.ModelManager
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EObject
import exceptions.ModelNotFoundException
import org.eclipse.emf.common.util.URI
import edutest.Program

class EduTestMobileAppGenerator extends EduTestSuperGenerator {
	
	private List<EObject> blocks
	private String fileName
	private String pageName
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		try {
			var i = 0;
			//loads the mutator model
			var xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + "/" + manager.WodelContext.getProject +
			"/" + ModelManager.getOutputFolder + "/" + resource.URI.lastSegment.replaceAll(".test", ".model")
			val Bundle bundle = Platform.getBundle("wodel.models")
	   		val URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore")
	   		val String mutatorecore = FileLocator.resolve(fileURL).getFile()
			//val String mutatorecore = ModelManager.getWorkspaceAbsolutePath + "/" + WodelContext.getProject() + "/resources/MutatorEnvironment.ecore";
			val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore)
			//val EPackage epackage = mutatorpackages.get(0);
			//EPackage.Registry.INSTANCE.put(epackage.getNsURI(), epackage);
			val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString)
			blocks = ModelManager.getObjectsOfType("Block", mutatormodel)

			for (p : resource.allContents.toIterable.filter(Program)) {
				if (i == 0) {
					fileName = 'mobile/' + resource.URI.lastSegment.replaceAll(".test", "") + '.app'
					pageName = resource.URI.lastSegment.replaceAll(".test", "") + '.app'
				} else {
					fileName = 'mobile/' + resource.URI.lastSegment.replaceAll(".test", "") + i + '.app'
					pageName = resource.URI.lastSegment.replaceAll(".test", "") + i + '.app'
				}
				fsa.generateFile(fileName, p.compile(resource))
				i++
			}
		}
		catch (ModelNotFoundException e) {
		}
	}

	def compile(Program program, Resource resource) '''
		MobileApp code will be generated here!!
	'''
	
}