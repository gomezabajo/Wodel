package wodeledu.dsls.scoping

import wodeledu.dsls.scoping.AbstractModelDrawScopeProvider

import org.eclipse.xtext.scoping.IScope
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.Scopes
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import wodel.utils.manager.ModelManager
import java.util.ArrayList
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EAttribute
import modeldraw.MutatorDraw
import modeldraw.Edge
import modeldraw.Node
import modeldraw.Level
import org.eclipse.emf.ecore.EEnumLiteral
import org.eclipse.emf.ecore.EEnum
import modeldraw.Information
import modeldraw.NodeEnumerator
import modeldraw.Content
import org.eclipse.emf.ecore.EStructuralFeature
import modeldraw.ValuedFeature
import modeldraw.MutatorInstance

class ModelDrawScopeProvider extends AbstractModelDrawScopeProvider {
	def IScope scope_Item_name(MutatorDraw draw, EReference ref) {
		val scope = new ArrayList<EClass>()
		scope.addAll(getEClasses(draw.metamodel))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Item_name(MutatorInstance instance, EReference ref) {
		val scope = new ArrayList<EClass>()
		scope.addAll(getEClasses((instance.eContainer as MutatorDraw).metamodel))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Item_name(Node node, EReference ref) {
		val scope = new ArrayList<EClass>()
		scope.addAll(getEClasses(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Item_name(Edge edge, EReference ref) {
		val scope = new ArrayList<EClass>()
		scope.addAll(getEClasses(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Node_reference(Node node, EReference ref) {
		val scope = new ArrayList<EReference>()
		scope.addAll(getEReferences(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, node.name.name))
		Scopes.scopeFor(scope)
	}

	def IScope scope_Node_targetNode(Node node, EReference ref) {
		val scope = new ArrayList<EClass>()
		scope.addAll(getEClasses(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel))
		Scopes.scopeFor(scope)
	}

	def IScope scope_ValuedFeature_feat(Node node, EReference ref) {
		val scope = new ArrayList<EStructuralFeature>()
		scope.addAll(getEStructuralFeatures(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, node.name.name))
		if (node.targetNode !== null) {
			scope.addAll(getEStructuralFeatures(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, node.targetNode.name))
		}
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_ValuedFeature_refFeature(Node node, EReference ref) {
		val scope = new ArrayList<EStructuralFeature>()
		val List<EStructuralFeature> features = new ArrayList<EStructuralFeature>()
		if (node.feature !== null && node.feature.size > 0) {
			for (ValuedFeature feature : node.feature) {
				features.addAll(getEStructuralFeatures(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, feature.feat.EType.name))
			}
		}
		if (node.targetFeature !== null && node.targetFeature.size > 0) {
			for (ValuedFeature feature : node.targetFeature) {
				features.addAll(getEStructuralFeatures(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, feature.feat.EType.name))
			}
		}
		scope.addAll(features)
       	Scopes.scopeFor(scope)
	}

	def IScope scope_NamedItem_attName(Node node, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((node.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, node.name.name))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_NamedItem_attName(Edge edge, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_NamedItem_attName(Content content, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((content.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, content.name.name))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_NamedItem_attName(Level level, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((level.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, level.name.name))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Edge_source(Edge edge, EReference ref) {
		val scope = new ArrayList<EReference>()
		scope.addAll(getEReferences(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Edge_target(Edge edge, EReference ref) {
		val scope = new ArrayList<EReference>()
		scope.addAll(getEReferences(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Relation_reference(Edge edge, EReference ref) {
		val scope = new ArrayList<EReference>()
		scope.addAll(getEReferences(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
		Scopes.scopeFor(scope)
	}
	
	def IScope scope_Relation_refType(Edge edge, EReference ref) {
		val scope = new ArrayList<EReference>()
		if (edge.reference !== null && edge.reference.size > 0) {
			for (EReference reference : edge.reference) {
				scope.addAll(getEReferences(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, reference.EType.name))
			}
		}
		Scopes.scopeFor(scope)
	}

	def IScope scope_Relation_label(Edge edge, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		if (edge.reference !== null && edge.reference.size > 0) {
			for (EReference reference : edge.reference) {
				scope.addAll(getEAttributes(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, reference.EType.name))
			}
		}
		else {
			scope.addAll(getEAttributes(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
		}
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Relation_src_label(Edge edge, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Relation_tar_label(Edge edge, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Relation_targetNode(Edge edge, EReference ref) {
		val scope = new ArrayList<EClass>()
		scope.addAll(getEClasses(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel))
		Scopes.scopeFor(scope)
	}

	def IScope scope_ValuedFeature_feat(Edge edge, EReference ref) {
		val scope = new ArrayList<EStructuralFeature>()
		scope.addAll(getEStructuralFeatures(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.name.name))
		if (edge.targetNode !== null) {
			scope.addAll(getEStructuralFeatures(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, edge.targetNode.name))
		}
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_ValuedFeature_refFeature(Edge edge, EReference ref) {
		val scope = new ArrayList<EStructuralFeature>()
		val List<EStructuralFeature> features = new ArrayList<EStructuralFeature>()
		if (edge.feature !== null && edge.feature.size > 0) {
			for (ValuedFeature feature : edge.feature) {
				features.addAll(getEStructuralFeatures(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, feature.feat.EType.name))
			}
		}
		if (edge.targetFeature !== null && edge.targetFeature.size > 0) {
			for (ValuedFeature feature : edge.targetFeature) {
				features.addAll(getEStructuralFeatures(((edge.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, feature.feat.EType.name))
			}
		}
		scope.addAll(features)
       	Scopes.scopeFor(scope)
	}

	def IScope scope_Level_upper(Level level, EReference ref) {
		val scope = new ArrayList<EReference>()
		scope.addAll(getEReferences(((level.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, level.name.name))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Content_attName(Content content, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((content.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, content.name.name))
		Scopes.scopeFor(scope)
	}
	
	def IScope scope_NodeEnumerator_att(Content content, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((content.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, content.name.name))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Enumerator_literal(NodeEnumerator nodenum, EReference ref) {
		val scope = new ArrayList<EEnumLiteral>()
		scope.addAll(getELiterals(((nodenum.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, nodenum.att.EType.name))
		Scopes.scopeFor(scope)
	}

	def IScope scope_Information_type(Content content, EReference ref) {
		val scope = new ArrayList<EReference>()
		scope.addAll(getEReferences(((content.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, content.name.name))
       	Scopes.scopeFor(scope)
	}
	
	def IScope scope_Information_att(Information info, EReference ref) {
		val scope = new ArrayList<EAttribute>()
		scope.addAll(getEAttributes(((info.eContainer as MutatorInstance).eContainer as MutatorDraw).metamodel, info.type.EType.name))
       	Scopes.scopeFor(scope)
	}
	
	/** 
	 * It returns the list of classes defined in a meta-model.
	 * @param String file containing the metamodel
	 * @return List<EClass>
	 */
	 def private List<EClass> getEClassesSubpackages (EPackage pck) {
        val List<EClass>   classes   = new ArrayList<EClass>()
        for (EClassifier cl : pck.EClassifiers) {
          if (cl instanceof EClass)
      	    classes.add(cl as EClass)
   	    }
        for (EPackage spck : pck.ESubpackages) {
      	  val List<EClass> classesSubpackage = getEClassesSubpackages(spck)
      	  for (EClass cl : classesSubpackage) {
      	    if (!classes.contains(cl)) {
      	  	     classes.add(cl)
      	  	}
      	  }
      	}
        return classes
	 }

	/** 
	 * It returns the list of classes defined in a meta-model.
	 * @param String file containing the metamodel
	 * @return List<EClass>
	 */
	 def private List<EClass> getEClasses (String metamodelFile) {
        val List<EPackage> metamodel = ModelManager.loadMetaModel(metamodelFile)
        val List<EClass>   classes   = new ArrayList<EClass>()
   	    for (EPackage pck : metamodel) {
       	  for (EClassifier cl : pck.EClassifiers)
           	if (cl instanceof EClass)
      			classes.add(cl as EClass)
      	  for (EPackage spck : pck.ESubpackages) {
      	  	val List<EClass> classesSubpackage = getEClassesSubpackages(spck)
      	  	for (EClass cl : classesSubpackage) {
      	  		if (!classes.contains(cl)) {
      	  			classes.add(cl)
      	  		}
      	  	}
      	  }
		}
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
        val ArrayList<EAttribute> atts = new ArrayList<EAttribute>()
        if (eclass !== null) {
        	atts.addAll(eclass.EAllAttributes)
        	for (EClass c : eclass.getESuperTypes) {
        		atts.addAll(c.EAllAttributes)
        	}
        }
        return atts
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
        val ArrayList<EReference> refs = new ArrayList<EReference>()
        if (eclass !== null) {
        	refs.addAll(eclass.EAllReferences)
        	for (EClass c : eclass.getESuperTypes) {
        		refs.addAll(c.EAllReferences)
        	}
        }
        return refs
	 }
	 
	 /** 
	 * It returns the list of literals of a enum.
	 * @param String file containing the metamodel
	 * @param String class name
	 * @return List<EReference>
	 */
	 def private List<EEnumLiteral> getELiterals (String metamodelFile, String eenumName) {
        val List<EPackage>   metamodel  = ModelManager.loadMetaModel(metamodelFile)
        val EEnum            eenum     = ModelManager.getObjectOfType(eenumName, metamodel) as EEnum
        val ArrayList<EEnumLiteral> lits = new ArrayList<EEnumLiteral>()
        if (eenum !== null) {
        	lits.addAll(eenum.ELiterals)
        }
        return lits
	 }
}