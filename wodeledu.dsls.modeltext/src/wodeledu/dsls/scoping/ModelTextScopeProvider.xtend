package wodeledu.dsls.scoping

import org.eclipse.xtext.scoping.IScope
import modeltext.Element
import org.eclipse.emf.ecore.EReference
import java.util.ArrayList
import org.eclipse.emf.ecore.EClass
import modeltext.IdentifyElements
import org.eclipse.xtext.scoping.Scopes
import modeltext.Variable
import org.eclipse.emf.ecore.EAttribute
import java.util.List
import org.eclipse.emf.ecore.EPackage
import wodel.utils.manager.ModelManager
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EStructuralFeature
import modeltext.ValuedFeature

/**
 * @author Pablo Gomez-Abajo
 * 
 * Scope provider for the modelText language.
 *
 */ 
class ModelTextScopeProvider extends AbstractModelTextScopeProvider {

	def IScope scope_Element_type(Element element, EReference ref) {
		val scope = new ArrayList<EClass>()
		scope.addAll(getEClasses((element.eContainer as IdentifyElements).metamodel))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Element_ref(Element element, EReference ref) {
		val scope = new ArrayList<EReference>()
		if (element.type !== null) {
			scope.addAll(getEReferences((element.eContainer as IdentifyElements).metamodel, element.type.name))
		}
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Variable_id(Variable variable, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		if (variable.ref === null) {
			scope.addAll(getEAttributes((variable.eContainer.eContainer as IdentifyElements).metamodel, (variable.eContainer as Element).type.name))
		}
		if (variable.ref !== null) {
			scope.addAll(getEAttributes((variable.eContainer.eContainer as IdentifyElements).metamodel, (variable.ref as EReference).getEType.name))
		}
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Variable_ref(Variable variable, EReference ref) {
		val scope = new ArrayList<EReference>()
		scope.addAll(getEReferences((variable.eContainer.eContainer as IdentifyElements).metamodel, (variable.eContainer as Element).type.name))
       	Scopes.scopeFor(scope)
	}


	def IScope scope_ValuedFeature_feat(Element element, EReference ref) {
		val scope = new ArrayList<EStructuralFeature>()
		scope.addAll(getEStructuralFeatures((element.eContainer as IdentifyElements).metamodel, element.type.name))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_ValuedFeature_refFeature(Element element, EReference ref) {
		val scope = new ArrayList<EStructuralFeature>()
		val List<EStructuralFeature> features = new ArrayList<EStructuralFeature>()
		if (element.feature !== null && element.feature.size > 0) {
			for (ValuedFeature feature : element.feature) {
				features.addAll(getEStructuralFeatures((element.eContainer as IdentifyElements).metamodel, feature.feat.EType.name))
			}
		}
		scope.addAll(features)
       	Scopes.scopeFor(scope)
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
	 
	 /**
	   * It return the list of structural features of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EStructuralFeature> list of structural features
	   */ 
	 def private List<EStructuralFeature> getEStructuralFeatures (String metamodelFile, String eclassName) {
	  	val List<EPackage>    metamodel  = ModelManager.loadMetaModel(metamodelFile)
	  	val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
        val ArrayList<EStructuralFeature> features = new ArrayList<EStructuralFeature>()
        if (eclass !== null) {
        	features.addAll(eclass.EAllStructuralFeatures)
        	for (EClass c : eclass.getESuperTypes) {
        		features.addAll(c.EAllStructuralFeatures)
        	}
        }
        return features
  	}
	 
	 
	 /**
	   * It return the list of attributes of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EAttribute> list of attributes
	   */ 
	 def private List<EAttribute> getEAttributes (String metamodelFile, String eclassName) {
	  	val List<EPackage>    metamodel  = ModelManager.loadMetaModel(metamodelFile)
	  	val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
	  	if (eclass!==null) {
	  		return eclass.EAllAttributes
		}
	  	else {
	  		return new ArrayList<EAttribute>()
	  	}
  	}
  	
  	/** 
	 * It returns the list of references of a class.
	 * @param String file containing the metamodel
	 * @param String class name
	 * @return List<EReference>
	 */
	 def private List<EReference> getEReferences (String metamodelFile, String eclassName) {
        val List<EPackage>   metamodel  = ModelManager.loadMetaModel(metamodelFile)
        val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
        if (eclass !== null) {
        	return eclass.EAllReferences
        }
        else {
        	return new ArrayList<EReference>()
        }
	 }
}
