/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.scoping

import org.eclipse.xtext.scoping.IScope
import edutest.MutatorTests
import org.eclipse.emf.ecore.EReference
import manager.ModelManager
import java.util.ArrayList
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.common.util.URI
import org.eclipse.xtext.scoping.Scopes
import org.eclipse.emf.ecore.EObject
import mutatorenvironment.Block
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import java.util.List
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider

/**
 * @author Pablo Gomez-Abajo
 * 
 * Scope provider for the eduTest language.
 *
 */ 
class EduTestScopeProvider extends AbstractDeclarativeScopeProvider {

	/**
	 * MutatorTests.block can refers to any block declared in the .mutator file.
	 */
	def IScope scope_MutatorTests_block(MutatorTests mts, EReference ref) {
		val xmiFileName = "file:/" + ModelManager.getWorkspaceAbsolutePath + '/' + manager.WodelContext.getProject + '/' + ModelManager.getOutputFolder + '/' +  mts.eResource.URI.lastSegment.replaceAll("test", "model")
		val Bundle bundle = Platform.getBundle("wodel.models")
	   	val URL fileURL = bundle.getEntry("/models/MutatorEnvironment.ecore")
	   	val String ecore = FileLocator.resolve(fileURL).getFile()
		val List<EPackage> mutatorpackages = ModelManager.loadMetaModel(ecore)
		val Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFileName).toFileString)
		val List<EObject> eobjects = ModelManager.getObjectsOfType("Block", mutatormodel)
		var ArrayList<Block> blocks = null;
		for (EObject eobject : eobjects) {
			blocks.add(eobject as Block)
		}
       	Scopes.scopeFor(blocks)   
	}			

}
