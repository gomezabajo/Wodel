/*
 * generated by Xtext 2.13.0
 */
package wodeledu.dsls.scoping

import mutatext.Option
import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import wodel.utils.manager.ModelManager
import java.util.ArrayList
import org.eclipse.emf.ecore.EClassifier
import org.osgi.framework.Bundle
import org.eclipse.core.runtime.Platform
import java.net.URL
import org.eclipse.core.runtime.FileLocator
import mutatext.Configuration

/**
 * @author Pablo Gomez-Abajo
 * 
 * Scope provider for the mutaText language.
 *
 */ 
class MutaTextScopeProvider extends AbstractMutaTextScopeProvider {

	/**
	 * Option.type can refer to any EClass in the .ecore file.
	 */
	def IScope scope_Option_type(Option opt, EReference ref) {
		val Bundle bundle = Platform.getBundle("wodel.models")
	   	val URL fileURL = bundle.getEntry("/model/AppliedMutations.ecore")
	   	val String ecore = FileLocator.resolve(fileURL).getFile()
       	Scopes.scopeFor(getEClasses(ecore))   
	}
	
	/**
	 * Option.object is an optional argument that can be any EClass in the metamodel.
	 */
	def IScope scope_Option_object(Option option, EReference ref) {
       	Scopes.scopeFor(getEClasses((option.eContainer as Configuration).metamodel))   
	}
	
	/** 
	 * It returns the list of classes defined in a meta-model.
	 * @param String file containing the metamodel
	 * @return List<EClass>
	 */
	 def private List<EClass> getEClasses (String metamodelFile) {
        val List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile)
        val List<EClass>   classes   = new ArrayList<EClass>()
        for (EPackage pck : metamodel)
          for (EClassifier cl : pck.EClassifiers)
            if (cl instanceof EClass)
           		classes.add(cl as EClass)
        return classes
	 }

}
