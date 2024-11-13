package wodel.dsls.scoping

import org.eclipse.xtext.scoping.IScope
import mutatorenvironment.ObjectEmitter
import org.eclipse.emf.ecore.EReference
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Definition
import org.eclipse.emf.ecore.EClass
import java.util.List
import mutatorenvironment.RetypeObjectMutator
import wodel.utils.manager.MutatorUtils
import wodel.utils.manager.ModelManager
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.SelectObjectMutator
import java.util.ArrayList
import mutatorenvironment.Program
import org.eclipse.xtext.scoping.Scopes
import mutatorenvironment.ReferenceInit
import mutatorenvironment.ReferenceSet
import mutatorenvironment.Mutator
import org.eclipse.emf.ecore.EPackage
import mutatorenvironment.CreateObjectMutator
import mutatorenvironment.ModifyInformationMutator
import mutatorenvironment.SelectSampleMutator
import mutatorenvironment.CloneObjectMutator
import org.eclipse.emf.ecore.EClassifier
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.OtherTypeSelection
import mutatorenvironment.TypedSelection
import mutatorenvironment.ObSelectionStrategy
import mutatorenvironment.ModifyTargetReferenceMutator
import mutatorenvironment.CreateReferenceMutator
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import mutatorenvironment.ReferenceAdd
import mutatorenvironment.ReferenceRemove
import mutatorenvironment.ReferenceEvaluation
import org.eclipse.emf.ecore.EObject
import mutatorenvironment.RemoveObjectMutator
import mutatorenvironment.ModifySourceReferenceMutator
import java.io.File
import wodel.utils.manager.ProjectUtils
import mutatorenvironment.RemoveRandomReferenceMutator
import mutatorenvironment.RemoveCompleteReferenceMutator
import mutatorenvironment.RemoveSpecificReferenceMutator
import org.eclipse.emf.ecore.EAttribute
import mutatorenvironment.AttributeSet
import mutatorenvironment.AttributeScalar
import mutatorenvironment.AttributeCopy
import mutatorenvironment.AttributeSwap
import mutatorenvironment.ReferenceSwap
import org.eclipse.xtext.EcoreUtil2
import mutatorenvironment.ReferenceAtt
import mutatorenvironment.Evaluation
import mutatorenvironment.Expression
import mutatorenvironment.AttributeEvaluation
import org.eclipse.emf.ecore.EEnum
import mutatorenvironment.Constraint
import mutatorenvironment.ObjectAttributeType
import mutatorenvironment.MinValueType
import mutatorenvironment.MaxValueType
import mutatorenvironment.RandomNumberType
import org.eclipse.emf.ecore.EStructuralFeature
import mutatorenvironment.miniOCL.InvariantCS
import mutatorenvironment.miniOCL.CallExpCS
import mutatorenvironment.miniOCL.NameExpCS
import mutatorenvironment.miniOCL.PathElementCS
import mutatorenvironment.Block
import mutatorenvironment.CompositeMutator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.util.EcoreUtil
import java.util.Set
import java.util.HashSet
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider

class WodelScopeProvider extends AbstractDeclarativeScopeProvider {
	
	/**
	 * ObjectEmitter.type can contain any EClass from the input meta-model.
	 * Except the RetypeObjectMutator that can contain any compatible EClass.
	 */
	def IScope scope_ObjectEmitter_type(ObjectEmitter obj, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(obj)
        val Definition  definition = env.definition
        var List<EClass> classes = null
       	// add metamodel classes to scope
       	if (obj instanceof RetypeObjectMutator) {
       		val RetypeObjectMutator retypeObjectMutator = obj as RetypeObjectMutator
       		val EClass type = MutatorUtils.getStrategyType(retypeObjectMutator.object)
       		classes = ModelManager.getSiblingEClasses(definition.metamodel, type)
       	}
       	else if (obj instanceof RandomTypeSelection && obj.eContainer instanceof SelectObjectMutator) {
  			classes = new ArrayList<EClass>()
			classes.addAll(getEClasses(definition))
       	}
       	else {
       		classes = getEClasses(definition) 
       	}
       	Scopes.scopeFor( classes )   
	}				
	
	/**
	 * ObjectEmitter.type can contain any EClass from the input meta-model.
	 * Except the RetypeObjectMutator that can contain any compatible EClass.
	 */
	def IScope scope_ObjectEmitter_types(ObjectEmitter obj, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(obj)
        val Definition  definition = env.definition
        var List<EClass> classes = null
       	// add metamodel classes to scope
       	if (obj instanceof RetypeObjectMutator) {
       		val RetypeObjectMutator retypeObjectMutator = obj as RetypeObjectMutator
       		var List<EClass> types = MutatorUtils.getStrategyTypes(retypeObjectMutator.object)
       		classes = ModelManager.getSiblingEClasses(definition.metamodel, types)
       	}
       	else if (obj instanceof RandomTypeSelection && obj.eContainer instanceof SelectObjectMutator) {
  			classes = new ArrayList<EClass>()
			classes.addAll(getEClasses(definition) )
       	}
       	else {
       		classes = getEClasses(definition) 
       	}
       	Scopes.scopeFor( classes )   
	}				

	/**
	 * CreateObjectMutator.container, when a specific object is used as a container,
	 * can contain any previous object whose type is a container for the created object. 
	 */
	def IScope scope_SpecificObjectSelection_objSel(ReferenceInit com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com as ReferenceSet) 
        val Definition definition  = env.definition
        var String metamodel       = definition?.metamodel
        var String className = com.reference.get(0).getEType.getName
        
        val scope = new ArrayList()
       	if (className !== null) {
	        val List<Mutator> commands = getCommands(com.eContainer as Mutator)
    	    var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
	        var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
			var List<String> classNames = new ArrayList<String>()
   			var List<EClass> classes = new ArrayList<EClass>()
   			if (eclass !== null) {
   				classes.add(eclass)
   			}
   			classes.addAll(getESubClasses(definition, eclass))
			for (EClass cl : classes) {
				if (!classNames.contains(cl.name)) {
  					classNames.add(cl.name)
   				}
   			}
        	for (mutator : commands) {
        		if (mutator.name !== null && 
        			commands.indexOf(mutator) < commands.indexOf(com.eContainer as Mutator) &&
        			(mutator instanceof CreateObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof SelectObjectMutator || mutator instanceof SelectSampleMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) &&
        			classNames.contains(mutator.type.name))
				scope.add(mutator)
			}
		}
        
   		Scopes.scopeFor( scope )  
	}

	/**
	 * CreateObjectMutator.container, when a specific object is used as a container,
	 * can contain any previous object whose type is a container for the created object. 
	 */
	def IScope scope_SpecificObjectSelection_objSel(CreateObjectMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        var String metamodel       = definition?.metamodel
        var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   		var EClass eclass = ModelManager.getEClassByName(packages, com.type.name)
   		if (eclass === null) {
			metamodel = getMetamodel(definition, com.type.name)
   		}
        val List<String> resourceMM = getResourceMetamodels(definition)
        var List<String> metamodels = new ArrayList<String>()
        metamodels.add(metamodel)
        metamodels.addAll(resourceMM)
		var List<String> scontainers = new ArrayList<String>()
        for (String mm : metamodels) {
	        val List<EClass> containers  = getEContainers(mm, com.type)
	        for (EClassifier cl : containers) scontainers.add(cl.name)
	        val List<EReference> references = getEReferences(definition, com.type.name)
	        for (EReference eref : references) {
	        	scontainers.add(eref.getEType().name)
	        }
        }
        // example: create Class in c [where c is the result of a previous mutator]
        
        // find previously created objects, i.e., 
        // -mutations with a name, 
        // -previous to this one,
        // -where the created object has an appropriate type
        val scope = new ArrayList()
        for (mutator : commands) { 
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof SelectObjectMutator || mutator instanceof SelectSampleMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) &&
        		scontainers.contains(mutator.type.name))
			scope.add(mutator)
		}
        
        // add objects to scope
        Scopes.scopeFor(scope)
	}
	
	/**
	 * SelectObjectMutator.container, when a specific object is used as a container,
	 * can contain any previous object whose type is a container for the selected object. 
	 */
	def IScope scope_SpecificObjectSelection_objSel(SelectObjectMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        var String metamodel       = definition?.metamodel
        var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   		var EClass eclass = ModelManager.getEClassByName(packages, com.type.name)
   		if (eclass === null) {
			metamodel = getMetamodel(definition, com.type.name)
   		}
        
        val List<String> resourceMM = getResourceMetamodels(definition)
        var List<String> metamodels = new ArrayList<String>()
        metamodels.add(metamodel)
        metamodels.addAll(resourceMM)
		var List<String> scontainers = new ArrayList<String>()
        for (String mm : metamodels) {
	        val List<EClass> containers  = getEContainers(mm, com.type)
	        for (EClassifier cl : containers) scontainers.add(cl.name)
        }

        // example: create Class in c [where c is the result of a previous mutator]
        
        // find previously created objects, i.e., 
        // -mutations with a name, 
        // -previous to this one,
        // -where the created object has an appropriate type
        val scope = new ArrayList()
        for (mutator : commands) {
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof SelectObjectMutator || mutator instanceof SelectSampleMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) &&
        		scontainers.contains(mutator.type.name)) 
				scope.add(mutator)
		}
        
        // add objects to scope
        Scopes.scopeFor(scope)
	}
	
	/**
	 * CreateObjectMutator.container, when a specific object is used as a container,
	 * can contain any previous object whose type is a container for the created object. 
	 */
	def IScope scope_SpecificClosureSelection_objSel(CreateObjectMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        var String metamodel       = definition?.metamodel
        var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   		var EClass eclass = ModelManager.getEClassByName(packages, com.type.name)
   		if (eclass === null) {
			metamodel = getMetamodel(definition, com.type.name)
   		}
        
        val List<String> resourceMM = getResourceMetamodels(definition)
        var List<String> metamodels = new ArrayList<String>()
        metamodels.add(metamodel)
        metamodels.addAll(resourceMM)
		var List<String> scontainers = new ArrayList<String>()
        for (String mm : metamodels) {
	        val List<EClass> containers  = getEContainers(mm, com.type)
	        for (EClassifier cl : containers) scontainers.add(cl.name)
    	    val List<EReference> references = getEReferences(definition, com.type.name)
	        for (EReference eref : references) {
        		scontainers.add(eref.getEType().name)
        	}
        }
        // example: create Class in c [where c is the result of a previous mutator]
        
        // find previously created objects, i.e., 
        // -mutations with a name, 
        // -previous to this one,
        // -where the created object has an appropriate type
        val scope = new ArrayList()
        for (mutator : commands) { 
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof SelectObjectMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) &&
        		scontainers.contains(mutator.type.name))
			scope.add(mutator)
		}
        
        // add objects to scope
        Scopes.scopeFor(scope)
	}
	
	/**
	 * SelectObjectMutator.container, when a specific object is used as a container,
	 * can contain any previous object whose type is a container for the selected object. 
	 */
	def IScope scope_SpecificClosureSelection_objSel(SelectObjectMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        
        var String metamodel       = definition?.metamodel
        var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   		var EClass eclass = ModelManager.getEClassByName(packages, com.type.name)
   		if (eclass === null) {
			metamodel = getMetamodel(definition, com.type.name)
   		}

        val List<String> resourceMM = getResourceMetamodels(definition)
        var List<String> metamodels = new ArrayList<String>()
        metamodels.add(metamodel)
        metamodels.addAll(resourceMM)
		var List<String> scontainers = new ArrayList<String>()
        for (String mm : metamodels) {
	        val List<EClass> containers  = getEContainers(mm, com.type)
	        for (EClassifier cl : containers) scontainers.add(cl.name)
        }

        // example: create Class in c [where c is the result of a previous mutator]
        
        // find previously created objects, i.e., 
        // -mutations with a name, 
        // -previous to this one,
        // -where the created object has an appropriate type
        val scope = new ArrayList()
        for (mutator : commands) {
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof SelectObjectMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) &&
        		scontainers.contains(mutator.type.name)) 
				scope.add(mutator)
		}
        
        // add objects to scope
        Scopes.scopeFor(scope)
	}
	/**
	 * CompleteTypeSelection.type can contain any EClass from the input meta-model.
	 */
	def IScope scope_CompleteTypeSelection_type(CompleteTypeSelection com, EReference ref) {
		anyTypeSelection (com);
	}
	
	/**
	 * RandomTypeSelection.type can contain any EClass from the input meta-model.
	 */
	def IScope scope_RandomTypeSelection_type(RandomTypeSelection com, EReference ref) {
		anyTypeSelection (com);
	}

	/**
	 * OtherTypeSelection.type can contain any EClass from the input meta-model.
	 */
	def IScope scope_OtherTypeSelection_type(OtherTypeSelection com, EReference ref) {
		anyTypeSelection (com);
	}
	
	/**
	 * TypedSelection.type can contain any EClass from the input meta-model.
	 */
	def IScope scope_TypeSelection_type(TypedSelection com, EReference ref) {
		anyTypeSelection (com);
	}
	
	/**
	 * Common implementation for methods scope_CompleteTypeSelection_type, scope_RandomTypeSelection_type and scope_OtherTypeSelection_type.
	 */
	private def IScope anyTypeSelection(ObSelectionStrategy com) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val Definition definition  = env.definition
        var String metamodel       = definition?.metamodel
        val scope = new ArrayList()
		
		if (com.eContainer instanceof ModifyTargetReferenceMutator) {
  			val ModifyTargetReferenceMutator mutator = com.eContainer as ModifyTargetReferenceMutator
		    var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, mutator.refType.name)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, com.type.name)
			}
  			if (mutator.source == com) { // estamos modificando el source
        		scope.addAll(getESources(definition, mutator.refType.name))
  			} 
  			else if (mutator.newTarget == com) { // estamos modificando el newTarget
        		scope.addAll(getETargets(definition, mutator.refType.name))
  			} 
		}
		else if (com.eContainer instanceof CreateReferenceMutator) {
  			val CreateReferenceMutator mutator = com.eContainer as CreateReferenceMutator
		    var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, mutator.refType.name)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, com.type.name)
			}
  			if (mutator.source == com) { // estamos modificando el source
        		scope.addAll(getESources(definition, mutator.refType.name))
  			} 
  			else if (mutator.target == com) { // estamos modificando el newTarget
        		scope.addAll(getETargets(definition, mutator.refType.name))
  			} 
		}
		else if (com.eContainer instanceof MutatorEnvironment ||
			     com.eContainer instanceof CreateObjectMutator ||
			     com.eContainer instanceof SelectObjectMutator ||
			     com.eContainer instanceof SelectSampleMutator ||
			     com.eContainer instanceof CloneObjectMutator ||
			     com.eContainer instanceof RetypeObjectMutator) {
       		// add metamodel classes to scope
			var List<EClass> classes = getEClasses(definition)
        	scope.addAll(classes)
		}       

   		Scopes.scopeFor(scope) 
	}	

	/**
	 * SpecificObjectSelection.objSel can contain any EClass from the input meta-model.
	 */
	def IScope scope_SpecificObjectSelection_objSel(SpecificObjectSelection com, EReference ref) {
   		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<Mutator> scope = new ArrayList<Mutator>()
        
		if (com.eContainer instanceof ModifyTargetReferenceMutator) {
  			val ModifyTargetReferenceMutator mutator = com.eContainer as ModifyTargetReferenceMutator
  			val List<Mutator> commands = getCommands(mutator)
  			
  			if (mutator.source == com) { // estamos modificando el source
  				val List<EClass> containers  = getESources(definition, mutator.refType.name)
        		val List<String> scontainers = new ArrayList<String>() 
        		for (EClassifier cl : containers) scontainers.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope)        	
        	}         
  		
  			else if (mutator.newTarget == com) { // estamos modificando el newTarget
  				val List<EClass> containments  = getETargets(definition, mutator.refType.name)
        		val List<String> scontainments = new ArrayList<String>() 
        		for (EClassifier cl : containments) scontainments.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainments.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope) 
  			}  		
  		} 
  		else if (com.eContainer instanceof CreateReferenceMutator) {
  			val CreateReferenceMutator mutator = com.eContainer as CreateReferenceMutator
  			val List<Mutator> commands = getCommands(mutator)
  			
  			if (mutator.source == com) { // estamos modificando el source
  				val List<EClass> containers  = getESources(definition, mutator.refType.name)
        		val List<String> scontainers = new ArrayList<String>() 
        		for (EClassifier cl : containers) scontainers.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope)        	
        	}         
  		
  			else if (mutator.target == com) { // estamos modificando el newTarget
  				val List<EClass> containments  = getETargets(definition, mutator.refType.name)
        		val List<String> scontainments = new ArrayList<String>() 
        		for (EClassifier cl : containments) scontainments.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainments.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope) 
  			}  		
  		}		 
	}
	
	/**
	 * SpecificObjectSelection.objSel can contain any EClass from the input meta-model.
	 */
	def IScope scope_SpecificClosureSelection_objSel(SpecificClosureSelection com, EReference ref) {
   		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<Mutator> scope = new ArrayList<Mutator>()
        
		if (com.eContainer instanceof ModifyTargetReferenceMutator) {
  			val ModifyTargetReferenceMutator mutator = com.eContainer as ModifyTargetReferenceMutator
  			val List<Mutator> commands = getCommands(mutator)
  			
  			if (mutator.source == com) { // estamos modificando el source
  				val List<EClass> containers  = getESources(definition, mutator.refType.name)
        		val List<String> scontainers = new ArrayList<String>() 
        		for (EClassifier cl : containers) scontainers.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator ||  mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope)        	
        	}         
  		
  			else if (mutator.newTarget == com) { // estamos modificando el newTarget
  				val List<EClass> containments  = getETargets(definition, mutator.refType.name)
        		val List<String> scontainments = new ArrayList<String>() 
        		for (EClassifier cl : containments) scontainments.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainments.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope) 
  			}  		
  		} 
  		else if (com.eContainer instanceof CreateReferenceMutator) {
  			val CreateReferenceMutator mutator = com.eContainer as CreateReferenceMutator
  			val List<Mutator> commands = getCommands(mutator)
  			
  			if (mutator.source == com) { // estamos modificando el source
  				val List<EClass> containers  = getESources(definition, mutator.refType.name)
        		val List<String> scontainers = new ArrayList<String>() 
        		for (EClassifier cl : containers) scontainers.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope)        	
        	}         
  		
  			else if (mutator.target == com) { // estamos modificando el newTarget
  				val List<EClass> containments  = getETargets(definition, mutator.refType.name)
        		val List<String> scontainments = new ArrayList<String>() 
        		for (EClassifier cl : containments) scontainments.add(cl.name)

        		for (c : commands) {
        			if (c.name !== null && 
        				commands.indexOf(c) < commands.indexOf(mutator) &&
        				(c instanceof CreateObjectMutator || c instanceof SelectObjectMutator || c instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainments.contains(c.type.name)){ 
						scope.add(c)
					}
				}
        
       			// add objects to scope
        		Scopes.scopeFor(scope) 
  			}  		
  		}		 
	}
					
	/**
	 * CreateObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the created object.
	 */
	def IScope scope_RandomTypeSelection_type(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected object.
	 */
	def IScope scope_RandomTypeSelection_type(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectSampleMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected objects.
	 */
	def IScope scope_RandomTypeSelection_type(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * CloneObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the cloned object.
	 */
	def IScope scope_RandomTypeSelection_type(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * RetypeObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the retyped object.
	 */
	def IScope scope_RandomTypeSelection_type(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	

/**
	 * CreateObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the created object.
	 */
	def IScope scope_OtherTypeSelection_type(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected object.
	 */
	def IScope scope_OtherTypeSelection_type(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectSampleMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected objects.
	 */
	def IScope scope_OtherTypeSelection_type(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * CloneObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the cloned object.
	 */
	def IScope scope_OtherTypeSelection_type(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * RetypeObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the retyped object.
	 */
	def IScope scope_OtherTypeSelection_type(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	/**
	 * CreateObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the created object.
	 */
	def IScope scope_TypeSelection_type(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected object.
	 */
	def IScope scope_TypeSelection_type(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectSampleMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected objects.
	 */
	def IScope scope_TypeSelection_type(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * CloneObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the cloned object.
	 */
	def IScope scope_TypeSelection_type(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * RetypeObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the retyped object.
	 */
	def IScope scope_TypeSelection_type(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * CreateObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the created object.
	 */
	def IScope scope_RandomTypeSelection_types(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected object.
	 */
	def IScope scope_RandomTypeSelection_types(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectSampleMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected objects.
	 */
	def IScope scope_RandomTypeSelection_types(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * CloneObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the cloned object.
	 */
	def IScope scope_RandomTypeSelection_types(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * RetypeObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the retyped object.
	 */
	def IScope scope_RandomTypeSelection_types(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	

/**
	 * CreateObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the created object.
	 */
	def IScope scope_OtherTypeSelection_types(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected object.
	 */
	def IScope scope_OtherTypeSelection_types(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectSampleMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected objects.
	 */
	def IScope scope_OtherTypeSelection_types(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * CloneObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the cloned object.
	 */
	def IScope scope_OtherTypeSelection_types(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * RetypeObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the retyped object.
	 */
	def IScope scope_OtherTypeSelection_types(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	/**
	 * CreateObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the created object.
	 */
	def IScope scope_TypeSelection_types(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected object.
	 */
	def IScope scope_TypeSelection_types(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * SelectSampleMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the selected objects.
	 */
	def IScope scope_TypeSelection_types(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * CloneObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the cloned object.
	 */
	def IScope scope_TypeSelection_types(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}
	
	/**
	 * RetypeObjectMutator.container, when a random type is used as a container, 
	 * can contain any EClass which is a container for the retyped object.
	 */
	def IScope scope_TypeSelection_types(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        Scopes.scopeFor( getEContainers(definition.metamodel, com.type) )              
	}

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is CreateObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = null
        	if (com.container instanceof RandomTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof CompleteTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.container as SpecificObjectSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				sourceClassName = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
       				sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
       			}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		
       		if (com.container instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.container as SpecificClosureSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				sourceClassName = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
       				sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
       			}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.container instanceof TypedSelection) {
       			sourceClassName = com.container.type.name
       		}
        	
	       	// 	add references to scope
   	   		scope.addAll(getEReferences(definition, sourceClassName, com.type.name))
   		}
   		else {
       		var String className = com.type.name
       		
       		// 	add references to scope
       		scope.addAll(getEReferences(definition, className))
       	}
   		Scopes.scopeFor( scope )  
    }
    
	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is CreateObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.container.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName, com.container.refRefType.EType.name))
   		}
   		Scopes.scopeFor( scope )  
    }

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is CreateObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.container.refRefType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName, com.container.refRefRefType.EType.name))
   		}
   		Scopes.scopeFor( scope )  
    }

   /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceInit.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(ReferenceInit com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        if (com.object instanceof ObSelectionStrategy) {
        	var String className = null
        	if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
        	
	       	// 	add references to scope
   	   		scope.addAll(getEReferences(definition, className))
   		}
   		Scopes.scopeFor( scope )  
    }
    
   /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceInit.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(ReferenceInit com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName, com.object.refRefType.EType.name))
   		}
   		Scopes.scopeFor( scope )
   	}

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is CreateObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(ReferenceInit com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName, com.object.refRefType.EType.name))
   		}
   		Scopes.scopeFor( scope )  
    }
    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceAdd.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(ReferenceAdd com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        if (com.object instanceof ObSelectionStrategy) {
        	var String className = null
        	if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
        	
	       	// 	add references to scope
   	   		scope.addAll(getEReferences(definition, className))
   		}
   		Scopes.scopeFor( scope )  
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceAdd.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(ReferenceAdd com, EReference ref) {
    	val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName, com.object.refRefType.EType.name))
   		}
   		Scopes.scopeFor( scope )
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceAdd.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(ReferenceAdd com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName, com.object.refRefType.EType.name))
   		}
   		Scopes.scopeFor( scope )  
    }
    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceRemove.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(ReferenceRemove com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        if (com.object instanceof ObSelectionStrategy) {
        	var String className = null
        	if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
        	
	       	// 	add references to scope
   	   		scope.addAll(getEReferences(definition, className))
   		}
   		Scopes.scopeFor( scope )  
    }
    
    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceRemove.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(ReferenceRemove com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
   		}
   		Scopes.scopeFor( scope )
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceRemove.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(ReferenceRemove com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refRefType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
   		}
   		Scopes.scopeFor( scope )  
    }
	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceEvaluation.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(ReferenceEvaluation refEv, EReference ref) {
		var EObject container = refEv.eContainer
		while (container instanceof Mutator == false && container !== null) {
			container = container.eContainer
		}
       	val List<EReference> scope = new ArrayList<EReference>()
		if (container !== null) {
			val MutatorEnvironment env = getMutatorEnvironment(	container as Mutator)
    		val Definition definition = env.definition
			var String className = null
			if (refEv.value instanceof SpecificObjectSelection) {
				val SpecificObjectSelection selection = refEv.value as SpecificObjectSelection
				if (selection.objSel instanceof CreateObjectMutator) {
					className = selection.objSel.type.name
				}
				if (selection.objSel instanceof SelectObjectMutator) {
					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
				}
				if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
				if (selection.objSel instanceof CloneObjectMutator) {
					className = selection.objSel.type.name
				}
				if (selection.objSel instanceof RetypeObjectMutator) {
					className = selection.objSel.type.name
				}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
				// add references to scope
				scope.addAll(getEReferences(definition, className))
			}
			if (refEv.value instanceof SpecificClosureSelection) {
				val SpecificClosureSelection selection = refEv.value as SpecificClosureSelection
				if (selection.objSel instanceof CreateObjectMutator) {
					className = selection.objSel.type.name
				}
				if (selection.objSel instanceof SelectObjectMutator) {
					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
				}
				if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
				if (selection.objSel instanceof CloneObjectMutator) {
					className = selection.objSel.type.name
				}
				if (selection.objSel instanceof RetypeObjectMutator) {
					className = selection.objSel.type.name
				}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
				// add references to scope
				scope.addAll(getEReferences(definition, className))
			}
		}
  		Scopes.scopeFor( scope )  
    }

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceEvaluation.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(ReferenceEvaluation refEv, EReference ref) {
		var EObject container = refEv.eContainer
		while (container instanceof Mutator == false && container !== null) {
			container = container.eContainer
		}
    	val List<EReference> scope = new ArrayList<EReference>()
		if (container !== null) {
			val MutatorEnvironment env = getMutatorEnvironment(	container as Mutator)
			val Definition definition = env.definition
			scope.addAll(getEReferences(definition, refEv.value.refType.EType.name))
		}
		Scopes.scopeFor( scope ) 
	}

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is ReferenceEvaluation.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(ReferenceEvaluation refEv, EReference ref) {
		var EObject container = refEv.eContainer
		while (container instanceof Mutator == false && container !== null) {
			container = container.eContainer
		}
    	val List<EReference> scope = new ArrayList<EReference>()
		if (container !== null) {
			val MutatorEnvironment env = getMutatorEnvironment(	container as Mutator)
			val Definition definition = env.definition
			scope.addAll(getEReferences(definition, refEv.value.refRefType.EType.name))
		}
		Scopes.scopeFor( scope ) 
	}

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is SelectObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = null
        	if (com.container instanceof RandomTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof CompleteTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.container as SpecificObjectSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
   					sourceClassName = (selection.objSel as SelectObjectMutator).object.type.name
       				if ((selection.objSel as SelectObjectMutator).object.resource !== null) {
       					val String resourceName = (selection.objSel as SelectObjectMutator).object.resource
   						if (definition instanceof Program) {
   							val Program program = definition as Program
   							var mutatorenvironment.Resource resource = null
   							for (mutatorenvironment.Resource res : program.resources) {
   								if (res.name.equals(resourceName)) {
   									resource = res
   								}
   							}
   						}
       				}
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		
       		if (com.container instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.container as SpecificClosureSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				sourceClassName = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
        	if (com.container instanceof TypedSelection) {
       			sourceClassName = com.container.type.name
       		}
        	
//        	var String targetClassName = null
//       		if (com.object instanceof RandomTypeSelection) {
//       			targetClassName = com.object.type.name
//       		}
//       		if (com.object instanceof CompleteTypeSelection) {
//       			targetClassName = com.object.type.name
//       		}
//       		if (com.object instanceof SpecificObjectSelection) {
//       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
//       			if (selection.refType === null) {
//       				if (selection.objSel instanceof SelectObjectMutator) {
//       					targetClassName = (selection.objSel as SelectObjectMutator).object.type.name
//       				}
//   				}
//   				else {
//   					targetClassName = selection.refType.EType.name
//   				}
//       		}
//       		if (com.object instanceof SpecificClosureSelection) {
//       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
//       			if (selection.refType === null) {
//       				if (selection.objSel instanceof SelectObjectMutator) {
//       					targetClassName = (selection.objSel as SelectObjectMutator).object.type.name
//       				}
//   				}
//   				else {
//   					targetClassName = selection.refType.EType.name
//   				}
//       		}
	       	// 	add references to scope
   	   		scope.addAll(getEReferences(definition, sourceClassName))
       	}
       	else {
       		var String className = null
       		if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
       		
       		// 	add references to scope
       		scope.addAll(getEReferences(definition, className))
       	}
   		Scopes.scopeFor( scope )  
    }

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is SelectObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.container.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
   		}
   		Scopes.scopeFor( scope )
    }


	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is SelectObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(SelectObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.container.refRefType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
   		}
   		Scopes.scopeFor( scope )
    }
	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is CloneObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = null
        	if (com.container instanceof RandomTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof CompleteTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.container as SpecificObjectSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				sourceClassName = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.container instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.container as SpecificClosureSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				sourceClassName = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
        	if (com.container instanceof TypedSelection) {
       			sourceClassName = com.container.type.name
       		}
        	
//        	var String targetClassName = null
//       		if (com.object instanceof RandomTypeSelection) {
//       			targetClassName = com.object.type.name
//       		}
//       		if (com.object instanceof CompleteTypeSelection) {
//       			targetClassName = com.object.type.name
//       		}
//       		if (com.object instanceof SpecificObjectSelection) {
//       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
//       			if (selection.refType === null) {
//       				if (selection.objSel instanceof SelectObjectMutator) {
//       					targetClassName = (selection.objSel as SelectObjectMutator).object.type.name
//       				}
//   				}
//   				else {
//   					targetClassName = selection.refType.EType.name
//   				}
//       		}
//       		if (com.object instanceof SpecificClosureSelection) {
//       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
//       			if (selection.refType === null) {
//       				if (selection.objSel instanceof SelectObjectMutator) {
//       					targetClassName = (selection.objSel as SelectObjectMutator).object.type.name
//       				}
//   				}
//   				else {
//   					targetClassName = selection.refType.EType.name
//   				}
//       		}
	       	// 	add references to scope
       		scope.addAll(getEReferences(definition, sourceClassName))
       	}
       	else {
       		var String className = null
       		if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
       		// 	add references to scope
       		scope.addAll(getEReferences(definition, className))
       	}
   		Scopes.scopeFor( scope )  
    }
    
	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is CloneObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
   		}
   		Scopes.scopeFor( scope )
    }

	/**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is CloneObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.container.refRefType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
   		}
   		Scopes.scopeFor( scope )
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is RemoveObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = null
        	if (com.container instanceof RandomTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof CompleteTypeSelection) {
       			sourceClassName = com.container.type.name
       		}
       		if (com.container instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.container as SpecificObjectSelection
     				if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				sourceClassName = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.container instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.container as SpecificClosureSelection
     				if (selection.objSel instanceof CreateObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				sourceClassName = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					sourceClassName = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				sourceClassName = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				sourceClassName = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
        	if (com.container instanceof TypedSelection) {
       			sourceClassName = com.container.type.name
       		}
        	
//        	var String targetClassName = null
//       		if (com.object instanceof RandomTypeSelection) {
//       			targetClassName = com.object.type.name
//       		}
//       		if (com.object instanceof CompleteTypeSelection) {
//       			targetClassName = com.object.type.name
//       		}
//       		if (com.object instanceof SpecificObjectSelection) {
//       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
//       			if (selection.refType === null) {
//       				if (selection.objSel instanceof SelectObjectMutator) {
//       					targetClassName = (selection.objSel as SelectObjectMutator).object.type.name
//       				}
//   				}
//   				else {
//   					targetClassName = selection.refType.EType.name
//   				}
//       		}
//       		if (com.object instanceof SpecificClosureSelection) {
//       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
//       			if (selection.refType === null) {
//       				if (selection.objSel instanceof SelectObjectMutator) {
//       					targetClassName = (selection.objSel as SelectObjectMutator).object.type.name
//       				}
//   				}
//   				else {
//   					targetClassName = selection.refType.EType.name
//   				}
//       		}
//       		if (com.object instanceof TypedSelection) {
//       			targetClassName = com.object.type.name
//       		}
	       	// 	add references to scope
   	   		scope.addAll(getEReferences(definition, sourceClassName))
       	}
       	else {
       		var String className = null
       		if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
       		// 	add references to scope
       		scope.addAll(getEReferences(definition, className))
       	}
   		Scopes.scopeFor( scope )  
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is RemoveObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.container.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
        }
   		Scopes.scopeFor( scope )
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is RemoveObjetMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.container instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.container.refRefType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
        }
   		Scopes.scopeFor( scope )
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is SelectSampleMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refType(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String className = null
        	if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
     				if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof RetypeObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof ModifyInformationMutator) {
       				className = MutatorUtils.selectModifyInformationMutatorHelperName(selection.objSel as ModifyInformationMutator)
       			}
       		}
        	if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
        	
	       	// 	add references to scope
   	   		scope.addAll(getEReferences(definition, className))
       	}
   		Scopes.scopeFor( scope )  
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is SelectSampleMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefType(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()

        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
        }
   		Scopes.scopeFor( scope )
    }

    /**
	 * ObSelectionStrategy.refType can contain any EReference defined by the 
	 * SelectedObject.eContainer whose type is SelectSampleMutator.type.
	 */
    def IScope scope_ObSelectionStrategy_refRefRefType(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()

        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String sourceClassName = com.object.refRefType.EType.name
   	   		scope.addAll(getEReferences(definition, sourceClassName))
        }
   		Scopes.scopeFor( scope )
    }

	/**
	 * ModifySourceReferenceMutator.refType can contain any EReference in the metamodel.
	 */
	def IScope scope_ModifySourceReferenceMutator_refType(ModifySourceReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
       	scope.addAll(getEReferences(definition))
        
        Scopes.scopeFor( scope )              
    }
    
    /**
	 * ModifyTargetReferenceMutator.refType can contain any EReference in the metamodel.
	 */
	def IScope scope_ModifyTargetReferenceMutator_refType(ModifyTargetReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        
        val List<EReference> scope = new ArrayList<EReference>()
        
       	scope.addAll(getEReferences(definition))
        
        Scopes.scopeFor( scope )              
    }
    
    /**
	 * CreateReferenceMutator.refType can contain any EReference in the metamodel.
	 */
	def IScope scope_CreateReferenceMutator_refType(CreateReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EReference> scope = new ArrayList<EReference>()
        
       	scope.addAll(getEReferences(definition))
        
        Scopes.scopeFor( scope )          
    }
    
	/**
	 * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.newSource, when a specific 
	 * object is used as from/to, can contain any previous object defining the modified reference. 
	 */
	def IScope scope_SpecificObjectSelection_objSel(ModifySourceReferenceMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        val scope = new ArrayList()
        
        val List<EClass> containers  = getESources(definition, com.refType.name)
        val List<String> scontainers = new ArrayList<String>() 
        for (EClassifier cl : containers) scontainers.add(cl.name)

        for (mutator : commands) {
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        		scontainers.contains(mutator.type.name)) 
				scope.add(mutator) // add object to scope
		}
        
        Scopes.scopeFor(scope)
	}
	
	/**
	 * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.newSource, when a specific 
	 * object is used as from/to, can contain any previous object defining the modified reference. 
	 */
	def IScope scope_SpecificClosureSelection_objSel(ModifySourceReferenceMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        val scope = new ArrayList()
        
        val List<EClass> containers  = getESources(definition, com.refType.name)
        val List<String> scontainers = new ArrayList<String>() 
        for (EClassifier cl : containers) scontainers.add(cl.name)

        for (mutator : commands) {
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        		scontainers.contains(mutator.type.name)) 
				scope.add(mutator) // add object to scope
		}
        
        Scopes.scopeFor(scope)
	}
	/**
	 * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.to, when a random 
	 * type is used as from/to, can contain any EClass which defines the modified reference.
	 */
	def IScope scope_RandomTypeSelection_type(ModifySourceReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        
        Scopes.scopeFor( getESources(definition, com.refType.name) )              
	}
	
	/**
	 * ModifySourceReferenceMutator.from and ModifySourceReferenceMutator.to, when a random 
	 * type is used as from/to, can contain any EClass which defines the modified reference.
	 */
	def IScope scope_TypeSelection_type(ModifySourceReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        
        Scopes.scopeFor( getESources(definition, com.refType.name) )              
	}
	
	/**
	 * Helper to get all the EClasses contained in the processed models. 
	 */
	def private List<EClass> HelperRandomTypeSelectionModelEClasses(Definition definition, Program program) {
		val scope = new ArrayList()
		/*if (program.source.multiple == false) {*/
		if (!program.source.path.endsWith('/')) {
        	scope.addAll(getModelEClasses(definition, program.source.path))
        }
        if (program.source.path.endsWith('/')) {
		/*if (program.source.multiple == true) {*/
        	val File[] files = new File(ProjectUtils.getProject.getLocation.toFile.getPath + '/' + program.source.path).listFiles()
        	for (file : files) {
				if (file.isFile() == true) {
					if (file.getPath().endsWith(".model") == true) {
						scope.addAll(getModelEClasses(definition, file.getPath))
					}
				}
			}
			return scope
		}
	}
	
	/**
	 * RemoveObjectMutator.object, when a random type is used.
	 */
	def IScope scope_RandomTypeSelection_type(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	val Program program = definition as Program
        	val scope = HelperRandomTypeSelectionModelEClasses(definition, program)
        	Scopes.scopeFor(scope)    
        }
	}
	
	/**
	 * RemoveObjectMutator.object, when a specific selection strategy is used.
	 */
	def IScope scope_SpecificObjectSelection_objSel(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		val List<Mutator> commands = getCommands(com)
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	Scopes.scopeFor( commands )
        }          
	}
	
	/**
	 * RemoveObjectMutator.object, when a specific closure selection strategy is used.
	 */
	def IScope scope_SpecificClosureSelection_objSel(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		val List<Mutator> commands = getCommands(com)
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	Scopes.scopeFor( commands )
        }          
	}
	
	/**
	 * RemoveObjectMutator.object, when a complete type selection is used.
	 */
	def IScope scope_CompleteTypeSelection_type(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	val Program program = definition as Program
        	val scope = HelperRandomTypeSelectionModelEClasses(definition, program)
        	Scopes.scopeFor(scope)    
        }
	}
	
	/**
	 * RemoveObjectMutator.object, when a complete type selection is used.
	 */
	def IScope scope_TypeSelection_type(RemoveObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	val Program program = definition as Program
        	val scope = HelperRandomTypeSelectionModelEClasses(definition, program)
        	Scopes.scopeFor(scope)    
        }
	}
	

	/**
	 * ObjectEmitter.type, when a specific selection type
	 * is used, can be of any EClass defined in the meta-model. 
	 */
	def IScope scope_ObjectEmitter_type(SpecificObjectSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	Scopes.scopeFor( getEClasses(definition)  )    
        }
	}
	
	/**
	 * ObjectEmitter.type, when a specific closure selection type
	 * is used, can be of any EClass defined in the meta-model. 
	 */
	def IScope scope_ObjectEmitter_type(SpecificClosureSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	Scopes.scopeFor( getEClasses(definition)  )    
        }
	}

	/**
	 * ModifyInformationMutator.object, when a specific 
	 * object is used, can contain any previous object defining the modified reference. 
	 */
	def IScope scope_SpecificObjectSelection_objSel(ModifyInformationMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        
        if(definition instanceof Program) {
        	val scope = new ArrayList()
        	if (!definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == false) {*/
        		val String model = ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path
        		val List<EClass> classes  = getModelEClasses(definition, model)
        		val List<String> sclasses = new ArrayList<String>() 
       			for (EClassifier cl : classes) sclasses.add(cl.name) {
       				val List<Mutator> objects = new ArrayList<Mutator>()
		        	for (mutator : commands) {
    	    		if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				sclasses.contains(mutator.type.name)) 
						objects.add(mutator)
					}
		        	scope.addAll(objects)
				}
			}
			if (definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == true) {*/
				val ArrayList<String> models = new ArrayList<String>()
				
				val File[] files = new File(ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path).listFiles()
        		for (file : files) {
					if (file.isFile() == true) {
						if (file.getPath().endsWith(".model") == true) {
							models.add(file.getPath())
						}
					}
				}
				val List<EClass> classes = new ArrayList<EClass>()
				for (model : models) {
        			classes.addAll(getModelEClasses(definition, model))
        		}
        		val List<String> sclasses = new ArrayList<String>() 
       			for (EClassifier cl : classes) sclasses.add(cl.name) {
       				val List<Mutator> objects = new ArrayList<Mutator>()
		        	for (mutator : commands) {
    	    		if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				sclasses.contains(mutator.type.name)) 
						objects.add(mutator)
					}
		        	scope.addAll(objects)
				}
			}
        	// add objects to scope
        	Scopes.scopeFor(scope)
        }       
	}

	/**
	 * ModifyInformationMutator.object, when a specific closure 
	 * object is used, can contain any previous object defining the modified reference. 
	 */
	def IScope scope_SpecificClosureSelection_objSel(ModifyInformationMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        
        if(definition instanceof Program) {
        	val scope = new ArrayList()
        	if (!definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == false) {*/
        		val String model = ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path
        		val List<EClass> classes  = getModelEClasses(definition, model)
        		val List<String> sclasses = new ArrayList<String>() 
       			for (EClassifier cl : classes) sclasses.add(cl.name) {
       				val List<Mutator> objects = new ArrayList<Mutator>()
		        	for (mutator : commands) {
    	    		if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				sclasses.contains(mutator.type.name)) 
						objects.add(mutator)
					}
		        	scope.addAll(objects)
				}
			}
			if (definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == true) {*/
				val ArrayList<String> models = new ArrayList<String>()
				
				val File[] files = new File(ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path).listFiles()
        		for (file : files) {
					if (file.isFile() == true) {
						if (file.getPath().endsWith(".model") == true) {
							models.add(file.getPath())
						}
					}
				}
				val List<EClass> classes = new ArrayList<EClass>()
				for (model : models) {
        			classes.addAll(getModelEClasses(definition, model))
        		}
        		val List<String> sclasses = new ArrayList<String>() 
       			for (EClassifier cl : classes) sclasses.add(cl.name) {
       				val List<Mutator> objects = new ArrayList<Mutator>()
		        	for (mutator : commands) {
    	    		if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof SelectSampleMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				sclasses.contains(mutator.type.name)) 
						objects.add(mutator)
					}
		        	scope.addAll(objects)
				}
			}
        	// add objects to scope
        	Scopes.scopeFor(scope)
        }       
	}
	
	/**
	 * ModifyInformationMutator.type, when a random type is used.
	 */
	def IScope scope_RandomTypeSelection_type(ModifyInformationMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if (definition instanceof Program) {
	      	Scopes.scopeFor( getEClasses(definition)  )    
        }          
	}
	
	/**
	 * ModifyInformationMutator.type, when a random type is used.
	 */
	def IScope scope_TypeSelection_type(ModifyInformationMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if (definition instanceof Program) {
	      	Scopes.scopeFor( getEClasses(definition)  )    
        }          
	}
	
	/**
	 * RemoveRandomReferenceMutator.refType.
	 */
	def IScope scope_RemoveRandomReferenceMutator_refType(RemoveRandomReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	Scopes.scopeFor( getEReferences(definition) )    
        }          
	}
	
	/**
	 * RemoveRandomReferenceMutator.type.
	 */
	def IScope scope_RemoveRandomReferenceMutator_type(RemoveRandomReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	Scopes.scopeFor( getEClasses(definition)  )    
        }          
	}
	
	/**
	 * Helper to get all the EClasses contained in the processed models that contain a refTypeName reference. 
	 */
	def private ArrayList<EClass> HelperRandomTypeSelectionModelESources(Definition definition, Program program, String refTypeName) {
		val scope = new ArrayList()
		if (!program.source.path.endsWith('/')) {
		/*if (program.source.multiple == false) {*/
        	scope.addAll(getModelEClasses(definition, program.source.path))
        }
        if (program.source.path.endsWith('/')) {
		/*if (program.source.multiple == true) { */
        	val File[] files = new File(ProjectUtils.getProject.getLocation.toFile.getPath + '/' + program.source.path).listFiles()
        	for (file : files) {
				if (file.isFile() == true) {
					if (file.getPath().endsWith(".model") == true) {
						scope.addAll(getModelESources(definition, file.getPath, refTypeName))
					}
				}
			}
			return scope
		}
	}
	
	/**
	 * RemoveRandomReferenceMutator.container, when a random 
	 * type is used, can contain any EClass which defines the modified reference.
	 */
	def IScope scope_RandomTypeSelection_type(RemoveRandomReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	val Program program = definition as Program
        	val scope = HelperRandomTypeSelectionModelESources(definition, program, com.refType.name)
        	Scopes.scopeFor(scope)    
        }
	}
	
	/**
	 * RemoveRandomReferenceMutator.container, when a random 
	 * type is used, can contain any EClass which defines the modified reference.
	 */
	def IScope scope_TypeSelection_type(RemoveRandomReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	val Program program = definition as Program
        	val scope = HelperRandomTypeSelectionModelESources(definition, program, com.refType.name)
        	Scopes.scopeFor(scope)    
        }
	}
	
	/**
	 * RemoveCompleteReferenceMutator.refType.
	 */
	def IScope scope_RemoveCompleteReferenceMutator_refType(RemoveCompleteReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	val scope = new ArrayList()
        	scope.addAll(getEReferences(definition))
        	Scopes.scopeFor(scope)    
        }          
	}
	
	/**
	 * RemoveCompleteReferenceMutator.type.
	 */
	def IScope scope_RemoveCompleteReferenceMutator_type(RemoveCompleteReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	Scopes.scopeFor( getEClasses(definition)  )    
        }          
	}
	
	/**
	 * RemoveCompleteReferenceMutator.container, when a random 
	 * type is used, can contain any EClass which defines the modified reference.
	 */
	def IScope scope_RandomTypeSelection_type(RemoveCompleteReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	val Program program = definition as Program
        	val scope = HelperRandomTypeSelectionModelESources(definition, program, com.refType.name)
        	Scopes.scopeFor(scope)    
        }
	}

	/**
	 * RemoveCompleteReferenceMutator.container, when a random 
	 * type is used, can contain any EClass which defines the modified reference.
	 */
	def IScope scope_TypeSelection_type(RemoveCompleteReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	val Program program = definition as Program
        	val scope = HelperRandomTypeSelectionModelESources(definition, program, com.refType.name)
        	Scopes.scopeFor(scope)    
        }
	}
	/**
	 * RemoveSpecificReferenceMutatorMutator.refType.
	 */
	def IScope scope_RemoveSpecificReferenceMutator_refType(RemoveSpecificReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	Scopes.scopeFor( getEReferences(definition) )    
        }          
	}
	
	/**
	 * RemoveSpecificReferenceMutator.container.
	 */
	def IScope scope_RemoveSpecificReferenceMutator_container(RemoveSpecificReferenceMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        if(definition instanceof Program) {
        	//val String model = (definition as Program).model
        	Scopes.scopeFor( getEClasses(definition)  )    
        }          
	}
	
	/**
	 * RemoveSpecificReferenceMutator.container, when a specific 
	 * object is used, can contain any previous object defining the modified reference. 
	 */
	def IScope scope_SpecificObjectSelection_objSel(RemoveSpecificReferenceMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        
        if(definition instanceof Program) {
        	val scope = new ArrayList()
        	if (!definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == false) {*/
        		val String model = ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path
	        	val List<EClass> containers  = getModelESources(definition, model, com.refType.name)
	        	val List<String> scontainers = new ArrayList<String>() 
    	   		for (EClassifier cl : containers) scontainers.add(cl.name)
		       	val List<Mutator> objects = new ArrayList<Mutator>()
        		for (mutator : commands) {
        			if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(mutator.type.name)) 
						objects.add(mutator)
				}
	        	scope.addAll(objects)
    	    }
    	    if (definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == true) {*/
				val ArrayList<String> models = new ArrayList<String>()
				val File[] files = new File(ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path).listFiles()
        		for (file : files) {
					if (file.isFile() == true) {
						if (file.getPath().endsWith(".model") == true) {
							models.add(file.getPath())
						}
					}
				}
	        	val List<EClass> containers = new ArrayList<EClass>()
				for (model : models) {
        			containers.addAll(getModelESources(definition, model, com.refType.name))
        		}
        		val List<String> scontainers = new ArrayList<String>() 
       			for (EClassifier cl : containers) scontainers.add(cl.name)
       			val List<Mutator> objects = new ArrayList<Mutator>()
        		for (mutator : commands) {
        			if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(mutator.type.name)) 
						objects.add(mutator)
				}
	        	scope.addAll(objects)
			}
        	Scopes.scopeFor(scope)
        }       
	}
	
	/**
	 * RemoveSpecificReferenceMutator.container, when a specific closure 
	 * object is used, can contain any previous object defining the modified reference. 
	 */
	def IScope scope_SpecificClosureSelection_objSel(RemoveSpecificReferenceMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        
        if(definition instanceof Program) {
        	val scope = new ArrayList()
        	if (!definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == false) {*/
        		val String model = ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path
	        	val List<EClass> containers  = getModelESources(definition, model, com.refType.name)
	        	val List<String> scontainers = new ArrayList<String>() 
    	   		for (EClassifier cl : containers) scontainers.add(cl.name)
		       	val List<Mutator> objects = new ArrayList<Mutator>()
        		for (mutator : commands) {
        			if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(mutator.type.name)) 
						objects.add(mutator)
				}
	        	scope.addAll(objects)
    	    }
    	    if (definition.source.path.endsWith('/')) {
			/*if (definition.source.multiple == true) {*/
				val ArrayList<String> models = new ArrayList<String>()
				val File[] files = new File(ProjectUtils.getProject.getLocation.toFile.getPath + '/' + definition.source.path).listFiles()
        		for (file : files) {
					if (file.isFile() == true) {
						if (file.getPath().endsWith(".model") == true) {
							models.add(file.getPath())
						}
					}
				}
	        	val List<EClass> containers = new ArrayList<EClass>()
				for (model : models) {
        			containers.addAll(getModelESources(definition, model, com.refType.name))
        		}
        		val List<String> scontainers = new ArrayList<String>() 
       			for (EClassifier cl : containers) scontainers.add(cl.name)
       			val List<Mutator> objects = new ArrayList<Mutator>()
        		for (mutator : commands) {
        			if (mutator.name !== null && 
        				commands.indexOf(mutator) < commands.indexOf(com) &&
        				(mutator instanceof CreateObjectMutator || mutator instanceof SelectObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) && 
        				scontainers.contains(mutator.type.name)) 
						objects.add(mutator)
				}
	        	scope.addAll(objects)
			}
        	Scopes.scopeFor(scope)
        }       
	}

    /**
     * CreateObjectMutator.attributes must contain attributes of the CreateObjetMutator.type type. 
     */
    def IScope scope_AttributeSet_attribute(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        var String      metamodel = definition?.metamodel
        var String className = com.type.name
        var List<EAttribute> attributes = getEAttributes(definition, className)
        if (com.attributes.size > 0) {
        	for (AttributeSet attSet : com.attributes) {
				if (attSet instanceof AttributeScalar) {
					attributes.addAll(getEAttributes(definition, className))
				}
				if (attSet instanceof AttributeCopy) {
					if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
						val SpecificObjectSelection sel = (attSet as AttributeCopy).object as SpecificObjectSelection
						if (sel.objSel instanceof SelectObjectMutator) {
							if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
								val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
									object as RandomTypeSelection
								className = strategy.type.name
								var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
								var EClass eclass = ModelManager.getEClassByName(packages, className)
								if (eclass === null) {
									metamodel = getMetamodel(definition, className)
								}
								attributes.addAll(getEAttributes(definition, className))
							}
						}
					}
				}
				if (attSet instanceof AttributeSwap) {
					if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
						val SpecificObjectSelection sel = (attSet as AttributeSwap).object as SpecificObjectSelection
						if (sel.objSel instanceof SelectObjectMutator) {
							if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
								val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
									object as RandomTypeSelection
								className = strategy.type.name
								var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
								var EClass eclass = ModelManager.getEClassByName(packages, className)
								if (eclass === null) {
									metamodel = getMetamodel(definition, className)
								}
								attributes.addAll(getEAttributes(definition, className))
							}
						}
					}
				}
			}
		}
       	Scopes.scopeFor( attributes )              
    }

    /**
     * CreateObjectMutator.references must contain references of the CreateObjetMutator.type type. 
     */  
    def IScope scope_ReferenceSet_reference(CreateObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		val Definition definition = env.definition
		Scopes.scopeFor(getEReferences(definition, com.type.name))
	}

	/**
	 * ModifyInformationMutator.attributes must contain attributes of the ModifyInformationMutator.object type. 
	 */
	def IScope scope_AttributeSet_attribute(ModifyInformationMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		val List<Mutator> commands = getCommands(com)
		val Definition definition = env.definition
		var String metamodel = definition?.metamodel
		val scope = new ArrayList()
		if (com.object instanceof SpecificObjectSelection) {
			val String name = (com.object as SpecificObjectSelection).objSel.name
			var command = getCommand(name, commands, commands.indexOf(com))
			if (command !== null) {
				scope.addAll(getEAttributes(definition, getType(command)))
				var String className = ""
				if (com.attributes.size > 0) {
					for (AttributeSet attSet : com.attributes) {
						if (attSet instanceof AttributeScalar) {
							if (com.object instanceof RandomTypeSelection) {
								var RandomTypeSelection strategy = com.object as RandomTypeSelection
								var EClass type = strategy.type
								scope.addAll(getEAttributes(definition, type.name))
							}
						}
						if (attSet instanceof AttributeCopy) {
							if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeCopy).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}

						if (attSet instanceof AttributeSwap) {
							if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeSwap).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
					}
				}
			}
		} else if (com.object instanceof SpecificClosureSelection) {
			val String name = (com.object as SpecificClosureSelection).objSel.name
			var command = getCommand(name, commands, commands.indexOf(com))
			if (command !== null) {
				scope.addAll(getEAttributes(definition, getType(command)))
				var String className = ""
				if (com.attributes.size > 0) {
					for (AttributeSet attSet : com.attributes) {
						if (attSet instanceof AttributeCopy) {
							if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeCopy).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
						if (attSet instanceof AttributeSwap) {
							if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeSwap).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
					}

				}
			}
		} else if (com.object instanceof CompleteTypeSelection) {
			val String name = (com.object as CompleteTypeSelection).type.name
			// for (EAttribute eatt: getEAttributes(definition.metamodel, name)) {
			// System.out.println("attribute: "+ eatt.name)
			// }
			scope.addAll(getEAttributes(definition, name))
			var String className = ""
			if (com.attributes.size > 0) {
				for (AttributeSet attSet : com.attributes) {
					if (attSet instanceof AttributeCopy) {
						if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeCopy).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}
					if (attSet instanceof AttributeSwap) {
						if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeSwap).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}

				}
			}
		} else if (com.object instanceof RandomTypeSelection) {
			val String name = (com.object as RandomTypeSelection).type.name
			// for (EAttribute eatt: getEAttributes(definition.metamodel, name)) {
			// System.out.println("attribute: "+ eatt.name)
			// }
			scope.addAll(getEAttributes(definition, name))
			var String className = ""
			if (com.attributes.size > 0) {
				for (AttributeSet attSet : com.attributes) {
					if (attSet instanceof AttributeCopy) {
						if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeCopy).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}
					if (attSet instanceof AttributeSwap) {
						if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeSwap).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}

				}
			}
		} else if (com.object instanceof TypedSelection) {
			val String name = (com.object as TypedSelection).type.name
			// for (EAttribute eatt: getEAttributes(definition.metamodel, name)) {
			// System.out.println("attribute: "+ eatt.name)
			// }
			scope.addAll(getEAttributes(definition, name))
			{
				var String className = ""
				if (com.attributes.size > 0) {
					for (AttributeSet attSet : com.attributes) {
						if (attSet instanceof AttributeCopy) {
							if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeCopy).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
						if (attSet instanceof AttributeSwap) {
							if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeSwap).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
					}

				}
			}
		}
       	Scopes.scopeFor(scope)              
    }

    /**
     * ModifyInformationMutator.references must contain references of the ModifyInformationMutator.type type. 
     */  
    def IScope scope_ReferenceSet_reference(ModifyInformationMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		val List<Mutator> commands = getCommands(com)
        val Definition  definition = env.definition
       	val scope = new ArrayList()
       	if(com.object instanceof SpecificObjectSelection) {
       		val String name = (com.object as SpecificObjectSelection).objSel.name
			var command = getCommand (name, commands, commands.indexOf(com))
			if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
       	}
       	else if(com.object instanceof SpecificClosureSelection) {
       		val String name = (com.object as SpecificClosureSelection).objSel.name
			var command = getCommand (name, commands, commands.indexOf(com))
			if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
       	}
        else if(com.object instanceof CompleteTypeSelection){
       		val String name = (com.object as CompleteTypeSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
       	}
       	else if(com.object instanceof RandomTypeSelection){
       		val String name = (com.object as RandomTypeSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
		}
       	else if(com.object instanceof TypedSelection){
       		val String name = (com.object as TypedSelection).type.name
			// for (EReference eref: getEReferences(definition, name)) {
			// System.out.println("reference: "+ eref.name)
			// }
			scope.addAll(getEReferences(definition, name))
		}
		Scopes.scopeFor(scope)
	}

	/**
	 * CloneObjectMutator.attributes must contain attributes of the CloneObjectMutator.object type. 
	 */
	def IScope scope_AttributeSet_attribute(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		val List<Mutator> commands = getCommands(com)
		val Definition definition = env.definition
		var String metamodel = definition?.metamodel
		val scope = new ArrayList()
		if (com.object instanceof SpecificObjectSelection) {
			val String name = (com.object as SpecificObjectSelection).objSel.name
			var command = getCommand(name, commands, commands.indexOf(com))
			if (command !== null) {
				scope.addAll(getEAttributes(definition, getType(command)))
				var String className = ""
				if (com.attributes.size > 0) {
					for (AttributeSet attSet : com.attributes) {
						if (attSet instanceof AttributeScalar) {
							if (com.object instanceof RandomTypeSelection) {
								var RandomTypeSelection strategy = com.object as RandomTypeSelection
								var EClass type = strategy.type
								scope.addAll(getEAttributes(definition, type.name))
							}
						}
						if (attSet instanceof AttributeCopy) {
							if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeCopy).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
						if (attSet instanceof AttributeSwap) {
							if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeSwap).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
					}

				}
			}
		} else if (com.object instanceof SpecificClosureSelection) {
			val String name = (com.object as SpecificClosureSelection).objSel.name
			var command = getCommand(name, commands, commands.indexOf(com))
			if (command !== null) {
				scope.addAll(getEAttributes(definition, getType(command)))
				var String className = ""
				if (com.attributes.size > 0) {
					for (AttributeSet attSet : com.attributes) {
						if (attSet instanceof AttributeCopy) {
							if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeCopy).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
						if (attSet instanceof AttributeSwap) {
							if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeSwap).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
					}

				}
			}
		} else if (com.object instanceof CompleteTypeSelection) {
			val String name = (com.object as CompleteTypeSelection).type.name
			// for (EAttribute eatt: getEAttributes(definition.metamodel, name)) {
			// System.out.println("attribute: "+ eatt.name)
			// }
			scope.addAll(getEAttributes(definition, name))
			var String className = ""
			if (com.attributes.size > 0) {
				for (AttributeSet attSet : com.attributes) {
					if (attSet instanceof AttributeCopy) {
						if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeCopy).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}
					if (attSet instanceof AttributeSwap) {
						if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeSwap).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}

				}
			}
		} else if (com.object instanceof RandomTypeSelection) {
			val String name = (com.object as RandomTypeSelection).type.name
			// for (EAttribute eatt: getEAttributes(definition.metamodel, name)) {
			// System.out.println("attribute: "+ eatt.name)
			// }
			scope.addAll(getEAttributes(definition, name))
			var String className = ""
			if (com.attributes.size > 0) {
				for (AttributeSet attSet : com.attributes) {
					if (attSet instanceof AttributeCopy) {
						if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeCopy).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}
					if (attSet instanceof AttributeSwap) {
						if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
							val SpecificObjectSelection sel = (attSet as AttributeSwap).
								object as SpecificObjectSelection
							if (sel.objSel instanceof SelectObjectMutator) {
								if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
									val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
										object as RandomTypeSelection
									className = strategy.type.name
									var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
									var EClass eclass = ModelManager.getEClassByName(packages, className)
									if (eclass === null) {
										metamodel = getMetamodel(definition, className)
									}
									scope.addAll(getEAttributes(definition, className))
								}
							}
						}
					}

				}
			}
		} else if (com.object instanceof TypedSelection) {
			val String name = (com.object as TypedSelection).type.name
			// for (EAttribute eatt: getEAttributes(definition.metamodel, name)) {
			// System.out.println("attribute: "+ eatt.name)
			// }
			scope.addAll(getEAttributes(definition, name))
			{
				var String className = ""
				if (com.attributes.size > 0) {
					for (AttributeSet attSet : com.attributes) {
						if (attSet instanceof AttributeCopy) {
							if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeCopy).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}
						if (attSet instanceof AttributeSwap) {
							if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
								val SpecificObjectSelection sel = (attSet as AttributeSwap).
									object as SpecificObjectSelection
								if (sel.objSel instanceof SelectObjectMutator) {
									if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
										val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
											object as RandomTypeSelection
										className = strategy.type.name
										var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
										var EClass eclass = ModelManager.getEClassByName(packages, className)
										if (eclass === null) {
											metamodel = getMetamodel(definition, className)
										}
										scope.addAll(getEAttributes(definition, className))
									}
								}
							}
						}

					}
				}
			}
		}
		Scopes.scopeFor(scope)
	}

    /**
     * CloneObjectMutator.references must contain references of the CloneObjectMutator.type type. 
     */  
    def IScope scope_ReferenceSet_reference(CloneObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		val List<Mutator> commands = getCommands(com)
        val Definition  definition = env.definition
       	val scope = new ArrayList()
       	if(com.object instanceof SpecificObjectSelection) {
       		val String name = (com.object as SpecificObjectSelection).objSel.name
			var command = getCommand (name, commands, commands.indexOf(com))
			if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
       	}
       	else if(com.object instanceof SpecificObjectSelection) {
       		val String name = (com.object as SpecificObjectSelection).objSel.name
			var command = getCommand (name, commands, commands.indexOf(com))
			if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
       	}
        else if(com.object instanceof CompleteTypeSelection){
       		val String name = (com.object as CompleteTypeSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
       	}
       	else if(com.object instanceof RandomTypeSelection){
       		val String name = (com.object as RandomTypeSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
       	}
       	else if(com.object instanceof TypedSelection){
       		val String name = (com.object as TypedSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
       	}
       	Scopes.scopeFor(scope)       
    }
    
    /**
     * RetypeObjectMutator.attributes must contain attributes of the CloneObjectMutator.object type. 
     */
    def IScope scope_AttributeSet_attribute(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		val Definition definition = env.definition
		var String metamodel = definition?.metamodel
		val scope = new ArrayList()
		scope.addAll(getEAttributes(definition, getType(com)))
		var String className = ""
		if (com.attributes.size > 0) {
			for (AttributeSet attSet : com.attributes) {
				if (attSet instanceof AttributeScalar) {
					if (com.object instanceof RandomTypeSelection) {
						var RandomTypeSelection strategy = com.object as RandomTypeSelection
						var EClass type = strategy.type
						scope.addAll(getEAttributes(definition, type.name))
					}
				}
				if (attSet instanceof AttributeCopy) {
					if ((attSet as AttributeCopy).object instanceof SpecificObjectSelection) {
						val SpecificObjectSelection sel = (attSet as AttributeCopy).object as SpecificObjectSelection
						if (sel.objSel instanceof SelectObjectMutator) {
							if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
								val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
									object as RandomTypeSelection
								className = strategy.type.name
								var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
								var EClass eclass = ModelManager.getEClassByName(packages, className)
								if (eclass === null) {
									metamodel = getMetamodel(definition, className)
								}
								scope.addAll(getEAttributes(definition, className))
							}
						}
					}
				}
				if (attSet instanceof AttributeSwap) {
					if ((attSet as AttributeSwap).object instanceof SpecificObjectSelection) {
						val SpecificObjectSelection sel = (attSet as AttributeSwap).object as SpecificObjectSelection
						if (sel.objSel instanceof SelectObjectMutator) {
							if ((sel.objSel as SelectObjectMutator).object instanceof RandomTypeSelection) {
								val RandomTypeSelection strategy = (sel.objSel as SelectObjectMutator).
									object as RandomTypeSelection
								className = strategy.type.name
								var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
								var EClass eclass = ModelManager.getEClassByName(packages, className)
								if (eclass === null) {
									metamodel = getMetamodel(definition, className)
								}
								scope.addAll(getEAttributes(definition, className))
							}
						}
					}
				}
			}
		}
		Scopes.scopeFor(scope)
	}

    /**
     * RetypeObjectMutator.references must contain references of the RetypeObjectMutator.type type and RetypeObjectMutator.types. 
     */  
    def IScope scope_ReferenceSet_reference(RetypeObjectMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
       	Scopes.scopeFor(getEReferences(definition, getType(com))) 
       	             
    }

    /**
     * ReferenceInit.refType must contain references of the type of ReferenceInit.object. 
     */
    def IScope scope_ReferenceSet_refType (ReferenceInit com, EReference container) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
			val List<Mutator> commands = getCommands(currentMutator)
			var String      objectName = com.object?.type?.name
			if (com.object instanceof SpecificObjectSelection) 
				objectName = (com.object as SpecificObjectSelection)?.objSel?.name
			if (com.object instanceof SpecificClosureSelection) 
				objectName = (com.object as SpecificClosureSelection)?.objSel?.name
			
			// search specific selected object among the previous commands
			var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
			if (command !== null) return Scopes.scopeFor( getEReferences(definition, getType(command)) )			
       	}
       	Scopes.scopeFor(new ArrayList())
    }
    
    // TODO: similar for ReferenceSwap.reference, but in this case, the object is optional, in which case, we take the type of the closest object in the mutation
    /**
     * ReferenceSwap.reference must contain references of the type of ReferenceSwap.object,
     * or of the type of the mutator if no object is specified. 
     */
    def IScope scope_ReferenceSet_reference (ReferenceSwap com, EReference container) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
			val List<Mutator> commands = getCommands(currentMutator)
			if (com.object === null) return Scopes.scopeFor( getEReferences(definition, getType(currentMutator)) )
			
			var String      objectName = com.object?.type?.name
			if (com.object instanceof SpecificObjectSelection) 
				objectName = (com.object as SpecificObjectSelection)?.objSel?.name
			if (com.object instanceof SpecificClosureSelection) 
				objectName = (com.object as SpecificClosureSelection)?.objSel?.name
				
			// search specific selected object among the previous commands
			var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
			if (command !== null) return Scopes.scopeFor( getEReferences(definition, getType(command)) )
       	}
       	Scopes.scopeFor(new ArrayList())
    }

    /**
     * ReferenceAtt.attribute must contain attributes of the type of ReferenceAtt.reference. 
     */
    def IScope scope_ReferenceAtt_attribute (ReferenceAtt com, EReference container) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
    	var ArrayList<EAttribute> atts = new ArrayList<EAttribute>()
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			var String className = com.reference.get(0).EType.name
			atts.addAll(getEAttributes(definition, className))
       	}
       	Scopes.scopeFor(atts)
    }
    
    /**
     * ReferenceAdd.refType must contain references of the type of ReferenceAdd.object. 
     */
    def IScope scope_ReferenceSet_refType (ReferenceAdd com, EReference container) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
			val List<Mutator> commands = getCommands(currentMutator)
			var String      objectName = com.object?.type?.name
			if (com.object instanceof SpecificObjectSelection) 
				objectName = (com.object as SpecificObjectSelection)?.objSel?.name
			if (com.object instanceof SpecificClosureSelection) 
				objectName = (com.object as SpecificClosureSelection)?.objSel?.name
			
			// search specific selected object among the previous commands
			var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
			if (command !== null) return Scopes.scopeFor( getEReferences(definition, getType(command)) )			
       	}
       	Scopes.scopeFor(new ArrayList())
    }
    
    /**
     * ReferenceRemove.refType must contain references of the type of ReferenceRemove.object. 
     */
    def IScope scope_ReferenceSet_refType (ReferenceRemove com, EReference container) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
			val List<Mutator> commands = getCommands(currentMutator)
			var String      objectName = com.object?.type?.name
			if (com.object instanceof SpecificObjectSelection) 
				objectName = (com.object as SpecificObjectSelection)?.objSel?.name
			if (com.object instanceof SpecificClosureSelection) 
				objectName = (com.object as SpecificClosureSelection)?.objSel?.name
			
			// search specific selected object among the previous commands
			var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
			if (command !== null) return Scopes.scopeFor( getEReferences(definition, getType(command)) )			
       	}
       	Scopes.scopeFor(new ArrayList())
    }

  	/**
     * ReferenceEvaluation.name must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_name(RandomTypeSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
       		Scopes.scopeFor( getEReferences(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }
    
  	/**
     * ReferenceEvaluation.name must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_name(OtherTypeSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
       		Scopes.scopeFor( getEReferences(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }

  	/**
     * ReferenceEvaluation.name must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_name(CompleteTypeSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
       		Scopes.scopeFor( getEReferences(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }
    
  	/**
     * ReferenceEvaluation.name must contain the references defined by com.type
     */
     def IScope scope_ReferenceEvaluation_name(SpecificObjectSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		var List<EReference> references = new ArrayList<EReference>()
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
			val List<Mutator> commands = getCommands(currentMutator)
			var String      metamodel = definition?.metamodel
			var Set<String>	classNames = new HashSet<String>()
			if (com.refType === null) {
				val String objectName = com.objSel?.name
				// search specific selected object among the previous commands
				var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
				if (command !== null) {
					classNames.addAll(getType(command))
				}
			}
			else {
				classNames.add(com.refType.EType.name)
			}
			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
			for (String className : classNames) {
				var EClass eclass = ModelManager.getEClassByName(packages, className)
   				if (eclass === null) {
					metamodel = getMetamodel(definition, className)
   				}
   				references.addAll( getEReferences(definition, className) )
   			}
       	}
       	Scopes.scopeFor(references)
    }
    
    /**
     * ReferenceEvaluation.name must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_name(SpecificClosureSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
			val List<Mutator> commands = getCommands(currentMutator)
			if (com.refType === null) {
				val String objectName = com.objSel?.name
				// search specific selected object among the previous commands
				var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
				if (command !== null) return Scopes.scopeFor( getEReferences(definition, getType(command)) )
			}
			else {
				return Scopes.scopeFor(getEReferences(definition, com.refType.EType.name))
			}
       	}
       	Scopes.scopeFor(new ArrayList())
    }        
    
    /**
     * ReferenceEvaluation.name must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_name(TypedSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
       		Scopes.scopeFor( getEReferences(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }
    
  	/**
     * AttributeEvaluation.name must contain the attributes defined by com.type 
     */
    def IScope scope_AttributeEvaluation_name(RandomTypeSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
       		Scopes.scopeFor( getEAttributes(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }
    
  	/**
     * AttributeEvaluation.name must contain the attributes defined by com.type 
     */
    def IScope scope_AttributeEvaluation_name(OtherTypeSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
       		Scopes.scopeFor( getEAttributes(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }

  	/**
     * AttributeEvaluation.name must contain the attributes defined by com.type 
     */
     def IScope scope_AttributeEvaluation_name(CompleteTypeSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
       		Scopes.scopeFor( getEAttributes(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }    

  	/**
     * AttributeEvaluation.name must contain the attributes defined by com.type
     */
     def IScope scope_AttributeEvaluation_name(SpecificObjectSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		var List<EAttribute> attributes = new ArrayList<EAttribute>()
		if (env !== null) {
			val Definition  definition = env.definition
			
			var String      metamodel = definition?.metamodel
			var Set<String>		classNames = new HashSet<String>()
			if (com.refType === null) {
				val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
				val List<Mutator>	commands = getCommands(currentMutator)
				val String			objectName = com.objSel?.name
				// search specific selected object among the previous commands
				var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
				if (command !== null) {
					classNames.addAll(getType(command))
				}
			}
			else {
				classNames.add(com.refType.EType.name)
			}
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			for (String className : classNames) {
	   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   				if (eclass === null) {
					metamodel = getMetamodel(definition, className)
				}
				attributes.addAll( getEAttributes(definition, className) )
			}
       	}
       	Scopes.scopeFor(attributes)
    }
    
    /**
     * AttributeEvaluation.name must contain the attributes defined by com.type
     */
     def IScope scope_AttributeEvaluation_name(SpecificClosureSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		if (env !== null) {
			val Definition  definition = env.definition
			
			// obtain mutator that contains the specific object selection
			if (com.refType === null) {
				val Mutator currentMutator = EcoreUtil2.getContainerOfType(com, Mutator)
				val List<Mutator> commands = getCommands(currentMutator)
				val String      objectName = com.objSel?.name
			
				// search specific selected object among the previous commands
				var command = getCommand (objectName, commands, commands.indexOf(currentMutator))
				if (command !== null) return Scopes.scopeFor( getEAttributes(definition, getType(command)) )
			}
			else {
				return Scopes.scopeFor (getEAttributes(definition, com.refType.EType.name))
			}
       	}
       	Scopes.scopeFor(new ArrayList())
    }

  	/**
     * AttributeEvaluation.name must contain the attributes defined by com.type 
     */
    def IScope scope_AttributeEvaluation_name(TypedSelection com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			val String       className = com.type?.name
       		Scopes.scopeFor( getEAttributes(definition, className) )
       	}
       	else Scopes.scopeFor(new ArrayList())
    }

//  	/**
//     * SelectObjectMutator.refType must be of the SelectObjectMutator.object type. 
//     */
//    def IScope scope_ObSelectionStrategy_refType(SelectObjectMutator com, EReference ref) {
//		val MutatorEnvironment env = getMutatorEnvironment(com) 
//		val List<Mutator> commands = getCommands(com)
//        val Definition  definition = env.definition
//        var String name = ""
//       	val scope = new ArrayList()
//       	if(com.object instanceof SpecificObjectSelection) {
//       		name = (com.object as SpecificObjectSelection).objSel.name
//			var command = getCommand (name, commands, commands.indexOf(com))
//			if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )			
//       	}
//        else if(com.object instanceof CompleteTypeSelection){
//       		name = (com.object as CompleteTypeSelection).type.name
//       		//for (EReference eref: getEReferences(definition, name)) {
//       		//	System.out.println("reference: "+ eref.name)
//       		//}
//			scope.addAll(getEReferences(definition, name))
//       	}
//       	else if(com.object instanceof RandomTypeSelection){
//       		name = (com.object as RandomTypeSelection).type.name
//       		//for (EReference eref: getEReferences(definition, name)) {
//       		//	System.out.println("reference: "+ eref.name)
//       		//}
//			scope.addAll(getEReferences(definition, name))
//       	}
//       	Scopes.scopeFor(scope)              
//    }
//    
    /**
     * ModifyInformationMutator.refType must be of the ModifyInformationMutator.object type. 
     */
    def IScope scope_ObSelectionStrategy_refType(ModifyInformationMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
		val List<Mutator> commands = getCommands(com)
        val Definition  definition = env.definition
       	val scope = new ArrayList()
       	if(com.object instanceof SpecificObjectSelection) {
       		val String name = (com.object as SpecificObjectSelection).objSel.name
			var command = getCommand (name, commands, commands.indexOf(com))
			if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
       	}
       	else if(com.object instanceof SpecificClosureSelection) {
       		val String name = (com.object as SpecificClosureSelection).objSel.name
			var command = getCommand (name, commands, commands.indexOf(com))
			if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
       	}
        else if(com.object instanceof CompleteTypeSelection){
       		val String name = (com.object as CompleteTypeSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
       	}
       	else if(com.object instanceof RandomTypeSelection){
       		val String name = (com.object as RandomTypeSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
       	}
       	else if(com.object instanceof TypedSelection){
       		val String name = (com.object as TypedSelection).type.name
       		//for (EReference eref: getEReferences(definition, name)) {
       		//	System.out.println("reference: "+ eref.name)
       		//}
			scope.addAll(getEReferences(definition, name))
       	}
       	Scopes.scopeFor(scope)              
    }
    
    /**
     * ReferenceEvaluation.refType must be of com.type. 
     */
    def IScope scope_ReferenceEvaluation_refType(RandomTypeSelection com, EReference ref) {
   		val scope = new ArrayList()
      	
      	var EObject mut = null
       	if ( (com.eContainer instanceof ReferenceInit ||
       		com.eContainer instanceof ReferenceAdd ||
       		com.eContainer instanceof ReferenceRemove) &&
       		(com.eContainer.eContainer instanceof CreateObjectMutator ||
       		 com.eContainer.eContainer instanceof SelectObjectMutator)) {
    	   		mut = com.eContainer.eContainer
		}
       	else if (com.eContainer instanceof CreateObjectMutator ||
       		com.eContainer instanceof SelectObjectMutator || 
       		com.eContainer instanceof ModifyInformationMutator) {
       		mut = com.eContainer
       	}
       	
       	if (mut !== null) {
			val MutatorEnvironment env = getMutatorEnvironment(com) 
        	val Definition  definition = env.definition
       		val List<Mutator> commands = getCommands(mut as Mutator)
		    if (com.expression !== null) {
	        	val Expression exp = com.expression
	        	if (exp.first instanceof ReferenceEvaluation) {
		        	val ReferenceEvaluation first = exp.first as ReferenceEvaluation
		        	if (first.value !== null) {
		        		if (first.value instanceof SpecificObjectSelection) {
		    				if ((first.value as SpecificObjectSelection).objSel !== null) {
			       				val String name = (first.value as SpecificObjectSelection).objSel.name
	       						var command = getCommand (name, commands, commands.indexOf(mut))
	       						if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
		        			}
		        		}
		        	}
		        	for (Evaluation second : exp.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			if (second.value instanceof SpecificObjectSelection) {
		        				if ((second.value as SpecificObjectSelection).objSel !== null) {
				       				val String name = (second.value as SpecificObjectSelection).objSel.name
       								var command = getCommand (name, commands, commands.indexOf(mut))
       								if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
		        				}
		        			}
	        			}
	        		}
	        	}
		    }
       	}
       	
       	Scopes.scopeFor(scope)             
    }
    
    /**
     * ReferenceEvaluation.refType must be of com.type. 
     */
    def IScope scope_ReferenceEvaluation_refType(OtherTypeSelection com, EReference ref) {
   		val scope = new ArrayList()
      	
      	var EObject mut = null
       	if ( (com.eContainer instanceof ReferenceInit ||
       		com.eContainer instanceof ReferenceAdd ||
       		com.eContainer instanceof ReferenceRemove) &&
       		(com.eContainer.eContainer instanceof CreateObjectMutator ||
       		 com.eContainer.eContainer instanceof SelectObjectMutator)) {
    	   		mut = com.eContainer.eContainer
		}
       	else if (com.eContainer instanceof CreateObjectMutator ||
       		com.eContainer instanceof SelectObjectMutator || 
       		com.eContainer instanceof ModifyInformationMutator) {
       		mut = com.eContainer
       	}
       	
       	if (mut !== null) {
			val MutatorEnvironment env = getMutatorEnvironment(com) 
        	val Definition  definition = env.definition
       		val List<Mutator> commands = getCommands(mut as Mutator)
		    if (com.expression !== null) {
	        	val Expression exp = com.expression
	        	if (exp.first instanceof ReferenceEvaluation) {
		        	val ReferenceEvaluation first = exp.first as ReferenceEvaluation
		        	if (first.value !== null) {
		        		if (first.value instanceof SpecificObjectSelection) {
		    				if ((first.value as SpecificObjectSelection).objSel !== null) {
			       				val String name = (first.value as SpecificObjectSelection).objSel.name
	       						var command = getCommand (name, commands, commands.indexOf(mut))
	       						if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
		        			}
		        		}
		        	}
		        	for (Evaluation second : exp.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			if (second.value instanceof SpecificObjectSelection) {
		        				if ((second.value as SpecificObjectSelection).objSel !== null) {
				       				val String name = (second.value as SpecificObjectSelection).objSel.name
       								var command = getCommand (name, commands, commands.indexOf(mut))
       								if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
		        				}
		        			}
	        			}
	        		}
	        	}
		    }
       	}
       	
       	Scopes.scopeFor(scope)             
    }

    
    /**
     * ReferenceEvaluation.refType must be of com.type. 
     */
    def IScope scope_ReferenceEvaluation_refType(TypedSelection com, EReference ref) {
   		val scope = new ArrayList()
      	
      	var EObject mut = null
       	if ( (com.eContainer instanceof ReferenceInit ||
       		com.eContainer instanceof ReferenceAdd ||
       		com.eContainer instanceof ReferenceRemove) &&
       		(com.eContainer.eContainer instanceof CreateObjectMutator ||
       		 com.eContainer.eContainer instanceof SelectObjectMutator)) {
    	   		mut = com.eContainer.eContainer
		}
       	else if (com.eContainer instanceof CreateObjectMutator ||
       		com.eContainer instanceof SelectObjectMutator || 
       		com.eContainer instanceof ModifyInformationMutator) {
       		mut = com.eContainer
       	}
       	
       	if (mut !== null) {
			val MutatorEnvironment env = getMutatorEnvironment(com) 
        	val Definition  definition = env.definition
       		val List<Mutator> commands = getCommands(mut as Mutator)
		    if (com.expression !== null) {
	        	val Expression exp = com.expression
	        	if (exp.first instanceof ReferenceEvaluation) {
		        	val ReferenceEvaluation first = exp.first as ReferenceEvaluation
		        	if (first.value !== null) {
		        		if (first.value instanceof SpecificObjectSelection) {
		    				if ((first.value as SpecificObjectSelection).objSel !== null) {
			       				val String name = (first.value as SpecificObjectSelection).objSel.name
	       						var command = getCommand (name, commands, commands.indexOf(mut))
	       						if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
		        			}
		        		}
		        	}
		        	for (Evaluation second : exp.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			if (second.value instanceof SpecificObjectSelection) {
		        				if ((second.value as SpecificObjectSelection).objSel !== null) {
				       				val String name = (second.value as SpecificObjectSelection).objSel.name
       								var command = getCommand (name, commands, commands.indexOf(mut))
       								if (command !== null) scope.addAll( getEReferences(definition, getType(command)) )
		        				}
		        			}
	        			}
	        		}
	        	}
		    }
       	}
       	
       	Scopes.scopeFor(scope)             
    }
    
    /**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refName(RandomTypeSelection com, EReference ref) {
       	val List<EReference> scope = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
       	val Definition  definition = env.definition
		if (env !== null) {
			if (com.expression?.first instanceof ReferenceEvaluation) {
		       	val ReferenceEvaluation refEv = com.expression?.first as ReferenceEvaluation
		       	var EClass typeFirst = null
				if (refEv.^self == true) {
					var Mutator mut = null
					var EObject container = com.eContainer
					while (container instanceof Mutator == false && container !== null) {
						container = container.eContainer
					}
					mut = container as Mutator
					if (mut instanceof CreateObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof SelectObjectMutator) {
       					typeFirst = mut.object.type
       				}
       				if (mut instanceof SelectSampleMutator) {
       					typeFirst = MutatorUtils.selectSampleMutatorHelperType(mut)
       				}
       				if (mut instanceof CloneObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof RetypeObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof ModifyInformationMutator) {
       					typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(mut as ModifyInformationMutator)
       				}
				}
				else {
					typeFirst = refEv.name.EType as EClass
				}
   				var String className = typeFirst.name
   			
   				scope.addAll(getEReferences(definition, className))

   				if (com.expression?.second !== null) {
   					for (Evaluation second : com.expression?.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			var EClass type = null
		        			if (second.^self == true) {
		        				type = typeFirst
		        			}
		        			else {
		        				type = second.name.EType as EClass
		        			}
		        			className = type.name
		        			scope.addAll(getEReferences(definition, className))
	        			}
	        		}
   				}
   			}
       	}
   		Scopes.scopeFor( scope )
    }
    
    /**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refName(OtherTypeSelection com, EReference ref) {
       	val List<EReference> scope = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
       	val Definition  definition = env.definition
		if (env !== null) {
			if (com.expression?.first instanceof ReferenceEvaluation) {
		       	val ReferenceEvaluation refEv = com.expression?.first as ReferenceEvaluation
		       	var EClass typeFirst = null
				if (refEv.^self == true) {
					var Mutator mut = null
					var EObject container = com.eContainer
					while (container instanceof Mutator == false && container !== null) {
						container = container.eContainer
					}
					mut = container as Mutator
					if (mut instanceof CreateObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof SelectObjectMutator) {
       					typeFirst = mut.object.type
       				}
       				if (mut instanceof SelectSampleMutator) {
       					typeFirst = MutatorUtils.selectSampleMutatorHelperType(mut)
       				}
       				if (mut instanceof CloneObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof RetypeObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof ModifyInformationMutator) {
       					typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(mut as ModifyInformationMutator)
       				}
				}
				else {
					typeFirst = refEv.name.EType as EClass
				}
   				var String className = typeFirst.name
   			
   				scope.addAll(getEReferences(definition, className))

   				if (com.expression?.second !== null) {
   					for (Evaluation second : com.expression?.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			var EClass type = null
		        			if (second.^self == true) {
		        				type = typeFirst
		        			}
		        			else {
		        				type = second.name.EType as EClass
		        			}
		        			className = type.name
		        			scope.addAll(getEReferences(definition, className))
	        			}
	        		}
   				}
   			}
       	}
   		Scopes.scopeFor( scope )
    }

  	/**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refName(CompleteTypeSelection com, EReference ref) {
       	val List<EReference> scope = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
       	val Definition  definition = env.definition
		if (env !== null) {
			if (com.expression?.first instanceof ReferenceEvaluation) {
		       	val ReferenceEvaluation refEv = com.expression?.first as ReferenceEvaluation
		       	var EClass typeFirst = null
				if (refEv.^self == true) {
					var Mutator mut = null
					var EObject container = com.eContainer
					while (container instanceof Mutator == false && container !== null) {
						container = container.eContainer
					}
					mut = container as Mutator
					if (mut instanceof CreateObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof SelectObjectMutator) {
       					typeFirst = mut.object.type
       				}
       				if (mut instanceof SelectSampleMutator) {
       					typeFirst = MutatorUtils.selectSampleMutatorHelperType(mut)
       				}
       				if (mut instanceof CloneObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof RetypeObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof ModifyInformationMutator) {
       					typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(mut as ModifyInformationMutator)
       				}
				}
				else {
					typeFirst = refEv.name.EType as EClass
				}
   				var String className = typeFirst.name
   			
   				scope.addAll(getEReferences(definition, className))

   				if (com.expression?.second !== null) {
   					for (Evaluation second : com.expression?.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			var EClass type = null
		        			if (second.^self == true) {
		        				type = typeFirst
		        			}
		        			else {
		        				type = second.name.EType as EClass
		        			}
		        			className = type.name
		        			scope.addAll(getEReferences(definition, className))
	        			}
	        		}
   				}
   			}
       	}
   		Scopes.scopeFor( scope )
    }
    
  	/**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refName(SpecificObjectSelection com, EReference ref) {
       	val List<EReference> scope = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
       	val Definition  definition = env.definition
		if (env !== null) {
			if (com.expression?.first instanceof ReferenceEvaluation) {
		       	val ReferenceEvaluation refEv = com.expression?.first as ReferenceEvaluation
		       	var EClass typeFirst = null
				if (refEv.^self == true) {
					var Mutator mut = null
					var EObject container = com.eContainer
					while (container instanceof Mutator == false && container !== null) {
						container = container.eContainer
					}
					mut = container as Mutator
					if (mut instanceof CreateObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof SelectObjectMutator) {
       					typeFirst = mut.object.type
       				}
       				if (mut instanceof SelectSampleMutator) {
       					typeFirst = MutatorUtils.selectSampleMutatorHelperType(mut)
       				}
       				if (mut instanceof CloneObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof RetypeObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof ModifyInformationMutator) {
       					typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(mut as ModifyInformationMutator)
       				}
				}
				else {
					typeFirst = refEv.name.EType as EClass
				}
   				var String className = typeFirst.name
   			
   				scope.addAll(getEReferences(definition, className))

   				if (com.expression?.second !== null) {
   					for (Evaluation second : com.expression?.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			var EClass type = null
		        			if (second.^self == true) {
		        				type = typeFirst
		        			}
		        			else {
		        				type = second.name.EType as EClass
		        			}
		        			className = type.name
		        			scope.addAll(getEReferences(definition, className))
	        			}
	        		}
   				}
   			}
       	}
   		Scopes.scopeFor( scope )
    }
    
    /**
     * ReferenceEvaluation.name must contain the references defined by ... 
     */
     def IScope scope_ReferenceEvaluation_refName(SpecificClosureSelection com, EReference ref) {
       	val List<EReference> scope = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
       	val Definition  definition = env.definition
		if (env !== null) {
			if (com.expression?.first instanceof ReferenceEvaluation) {
		       	val ReferenceEvaluation refEv = com.expression?.first as ReferenceEvaluation
		       	var EClass typeFirst = null
				if (refEv.^self == true) {
					var Mutator mut = null
					var EObject container = com.eContainer
					while (container instanceof Mutator == false && container !== null) {
						container = container.eContainer
					}
					mut = container as Mutator
					if (mut instanceof CreateObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof SelectObjectMutator) {
       					typeFirst = mut.object.type
       				}
       				if (mut instanceof SelectSampleMutator) {
       					typeFirst = MutatorUtils.selectSampleMutatorHelperType(mut)
       				}
       				if (mut instanceof CloneObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof RetypeObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof ModifyInformationMutator) {
       					typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(mut as ModifyInformationMutator)
       				}
				}
				else {
					typeFirst = refEv.name.EType as EClass
				}
   				var String className = typeFirst.name
   			
   				scope.addAll(getEReferences(definition, className))

   				if (com.expression?.second !== null) {
   					for (Evaluation second : com.expression?.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			var EClass type = null
		        			if (second.^self == true) {
		        				type = typeFirst
		        			}
		        			else {
		        				type = second.name.EType as EClass
		        			}
		        			className = type.name
		        			scope.addAll(getEReferences(definition, className))
	        			}
	        		}
   				}
   			}
       	}
   		Scopes.scopeFor( scope )
    }        
    
     /**
     * ReferenceEvaluation.name must contain the references defined by ... 
     */
     def IScope scope_ReferenceEvaluation_refName(TypedSelection com, EReference ref) {
       	val List<EReference> scope = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
       	val Definition  definition = env.definition
		if (env !== null) {
			if (com.expression?.first instanceof ReferenceEvaluation) {
		       	val ReferenceEvaluation refEv = com.expression?.first as ReferenceEvaluation
		       	var EClass typeFirst = null
				if (refEv.^self == true) {
					var Mutator mut = null
					var EObject container = com.eContainer
					while (container instanceof Mutator == false && container !== null) {
						container = container.eContainer
					}
					mut = container as Mutator
					if (mut instanceof CreateObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof SelectObjectMutator) {
       					typeFirst = mut.object.type
       				}
       				if (mut instanceof SelectSampleMutator) {
       					typeFirst = MutatorUtils.selectSampleMutatorHelperType(mut)
       				}
       				if (mut instanceof CloneObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof RetypeObjectMutator) {
       					typeFirst = mut.type
       				}
       				if (mut instanceof ModifyInformationMutator) {
       					typeFirst = MutatorUtils.selectModifyInformationMutatorHelperType(mut as ModifyInformationMutator)
       				}
				}
				else {
					typeFirst = refEv.name.EType as EClass
				}
   				var String className = typeFirst.name
   			
   				scope.addAll(getEReferences(definition, className))

   				if (com.expression?.second !== null) {
   					for (Evaluation second : com.expression?.second) {
		        		if (second instanceof ReferenceEvaluation) {
		        			var EClass type = null
		        			if (second.^self == true) {
		        				type = typeFirst
		        			}
		        			else {
		        				type = second.name.EType as EClass
		        			}
		        			className = type.name
		        			scope.addAll(getEReferences(definition, className))
	        			}
	        		}
   				}
   			}
       	}
   		Scopes.scopeFor( scope )
    }

    /**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refRefName(RandomTypeSelection com, EReference ref) {
		var List<EReference> refs = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).refName
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			refs.addAll(getEReferences(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.refName
		        		className = reference.EType.name
		        		refs.addAll(getEReferences(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( refs )
    }

    /**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refRefName(OtherTypeSelection com, EReference ref) {
		var List<EReference> refs = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).refName
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			refs.addAll(getEReferences(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.refName
		        		className = reference.EType.name
		        		refs.addAll(getEReferences(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( refs )
    }

    /**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_attName(RandomTypeSelection com, EReference ref) {
		var List<EAttribute> atts = new ArrayList<EAttribute>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).name
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			atts.addAll(getEAttributes(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.name
		        		className = reference.EType.name
		        		atts.addAll(getEAttributes(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( atts )
    }
    
    /**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_attName(OtherTypeSelection com, EReference ref) {
		var List<EAttribute> atts = new ArrayList<EAttribute>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).name
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			atts.addAll(getEAttributes(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.name
		        		className = reference.EType.name
		        		atts.addAll(getEAttributes(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( atts )
    }
    
  	/**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_attName(CompleteTypeSelection com, EReference ref) {
		var List<EAttribute> atts = new ArrayList<EAttribute>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).name
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			atts.addAll(getEAttributes(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.name
		        		className = reference.EType.name
		        		atts.addAll(getEAttributes(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( atts )
    }
    
  	/**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_attName(SpecificObjectSelection com, EReference ref) {
		var List<EAttribute> atts = new ArrayList<EAttribute>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).name
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			atts.addAll(getEAttributes(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.name
		        		className = reference.EType.name
		        		atts.addAll(getEAttributes(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( atts )
    }
    
    /**
     * ReferenceEvaluation.name must contain the references defined by ... 
     */
     def IScope scope_ReferenceEvaluation_attName(SpecificClosureSelection com, EReference ref) {
		var List<EAttribute> atts = new ArrayList<EAttribute>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).name
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			atts.addAll(getEAttributes(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.name
		        		className = reference.EType.name
		        		atts.addAll(getEAttributes(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( atts )
    }        
    
     /**
     * ReferenceEvaluation.name must contain the references defined by ... 
     */
     def IScope scope_ReferenceEvaluation_attName(TypedSelection com, EReference ref) {
		var List<EAttribute> atts = new ArrayList<EAttribute>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).name
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			atts.addAll(getEAttributes(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.name
		        		className = reference.EType.name
		        		atts.addAll(getEAttributes(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( atts )
    }

  	/**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refRefName(CompleteTypeSelection com, EReference ref) {
		var List<EReference> refs = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).refName
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			refs.addAll(getEReferences(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.refName
		        		className = reference.EType.name
		        		refs.addAll(getEReferences(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( refs )
    }
    
  	/**
     * ReferenceEvaluation.refName must contain the references defined by com.type 
     */
     def IScope scope_ReferenceEvaluation_refRefName(SpecificObjectSelection com, EReference ref) {
		var List<EReference> refs = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).refName
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			refs.addAll(getEReferences(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.refName
		        		className = reference.EType.name
		        		refs.addAll(getEReferences(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( refs )
    }
    
    /**
     * ReferenceEvaluation.name must contain the references defined by ... 
     */
     def IScope scope_ReferenceEvaluation_refRefName(SpecificClosureSelection com, EReference ref) {
		var List<EReference> refs = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).refName
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			refs.addAll(getEReferences(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.refName
		        		className = reference.EType.name
		        		refs.addAll(getEReferences(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( refs )
    }        
    
     /**
     * ReferenceEvaluation.name must contain the references defined by ... 
     */
     def IScope scope_ReferenceEvaluation_refRefName(TypedSelection com, EReference ref) {
		var List<EReference> refs = new ArrayList<EReference>()
		val MutatorEnvironment env = getMutatorEnvironment(com)
		if (env !== null) {
        	val Definition  definition = env.definition
   			var EReference   reference = (com.expression?.first as ReferenceEvaluation).refName
   			var String       className = reference.EType.name
   			var String       metamodel = definition?.metamodel
   			var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   			var EClass eclass = ModelManager.getEClassByName(packages, className)
   			if (eclass === null) {
				metamodel = getMetamodel(definition, className)
   			}
   			
   			refs.addAll(getEReferences(definition, className))
   			
   			if (com.expression?.second !== null) {
   				for (Evaluation second : com.expression?.second) {
		        	if (second instanceof ReferenceEvaluation) {
		        		reference = second.refName
		        		className = reference.EType.name
		        		refs.addAll(getEReferences(definition, className))
	        		}
	        	}
   			}
       	}
   		Scopes.scopeFor( refs )
    }

    /**
	 * Constraint.type can contain any EClass from the input meta-model.
	 */
	def IScope scope_Constraint_type(Constraint c, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(c)
        val Definition  definition = env.definition
       	// add metamodel classes to scope
       	Scopes.scopeFor( getEClasses(definition)  )   
	}
	
	/**
	 * ListType.value can contain any EEnumLiteral from the input EEnum.
	 */
	def IScope scope_ListType_value(ReferenceAtt refAtt, EReference ref) {
		var ArrayList<EObject> values = new ArrayList<EObject>()
       	var EAttribute attribute = refAtt.attribute;
		if (attribute.getEType instanceof EEnum) {
    		val EEnum en = attribute.getEType as EEnum
   			values.addAll(en.getELiterals)
    	}
       	// add metamodel classes to scope
       	Scopes.scopeFor( values )   
	}
	
	/**
	 * ListType.value can contain any EEnumLiteral from the input EEnum.
	 */
	def IScope scope_ListType_value(AttributeEvaluation attEv, EReference ref) {
		var ArrayList<EObject> values = new ArrayList<EObject>()
       	var EAttribute attribute = attEv.name;
		if (attribute.getEType instanceof EEnum) {
    		val EEnum en = attribute.getEType as EEnum
   			values.addAll(en.getELiterals)
    	}
       	// add metamodel classes to scope
       	Scopes.scopeFor( values )   
	}
	
	/**
	 * ListType.value can contain any EEnumLiteral from the input EEnum.
	 */
	def IScope scope_ListType_value(AttributeScalar attScal, EReference ref) {
		var ArrayList<EObject> values = new ArrayList<EObject>()
       	var EAttribute attribute = attScal.attribute.get(0);
		if (attribute.getEType instanceof EEnum) {
    		val EEnum en = attribute.getEType as EEnum
   			values.addAll(en.getELiterals)
    	}
       	// add metamodel classes to scope
       	Scopes.scopeFor( values )   
	}
	
	/**
	 * ObjectAttributeType.objSel can contain the previous defined mutators 
	 */
	def IScope scope_ObjectAttributeType_objSel(SelectObjectMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        
        val List<EClass> containers  = getEContainers(definition.metamodel, com.type)
        val List<String> scontainers = new ArrayList<String>()
        for (EClassifier cl : containers) scontainers.add(cl.name)
        val List<EReference> references = getEReferences(definition, com.type.name)
        for (EReference eref : references) {
        	scontainers.add(eref.getEType().name)
        }
        // example: create Class in c [where c is the result of a previous mutator]
        
        // find previously created objects, i.e., 
        // -mutations with a name, 
        // -previous to this one,
        // -where the created object has an appropriate type
        val scope = new ArrayList()
        for (mutator : commands) { 
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof SelectObjectMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) &&
        		scontainers.contains(mutator.type.name))
			scope.add(mutator)
		}
        
        // add objects to scope
        Scopes.scopeFor(scope)
	}
	
	/**
	 * ObjectAttributeType.objSel can contain the previous defined mutators 
	 */
	def IScope scope_ObjectAttributeType_objSel(ModifyInformationMutator com, EReference ref) {				
		val MutatorEnvironment env = getMutatorEnvironment(com)
        val List<Mutator> commands = getCommands(com)
        val Definition definition  = env.definition
        
        val List<EClass> containers  = getEContainers(definition.metamodel, com.type)
        val List<String> scontainers = new ArrayList<String>()
        for (EClassifier cl : containers) scontainers.add(cl.name)
        val List<EReference> references = getEReferences(definition, com.type.name)
        for (EReference eref : references) {
        	scontainers.add(eref.getEType().name)
        }
        // example: create Class in c [where c is the result of a previous mutator]
        
        // find previously created objects, i.e., 
        // -mutations with a name, 
        // -previous to this one,
        // -where the created object has an appropriate type
        val scope = new ArrayList()
        for (mutator : commands) { 
        	if (mutator.name !== null && 
        		commands.indexOf(mutator) < commands.indexOf(com) &&
        		(mutator instanceof CreateObjectMutator || mutator instanceof ModifyInformationMutator || mutator instanceof SelectObjectMutator || mutator instanceof CloneObjectMutator || mutator instanceof RetypeObjectMutator) &&
        		scontainers.contains(mutator.type.name))
			scope.add(mutator)
		}
        
        // add objects to scope
        Scopes.scopeFor(scope)
	}
	
	/**
	 * ObjectAttributeType.attribute must be of the type defined by com.type 
	 */
     def IScope scope_ObjectAttributeType_attribute(ObjectAttributeType com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com.objSel)
		var List<EAttribute> attributes = new ArrayList<EAttribute>()
		var Mutator mut = null
		var EObject container = com.eContainer
		while (container instanceof Mutator == false && container !== null) {
			container = container.eContainer
		}
		mut = container as Mutator
		val List<Mutator> commands = getCommands(mut)
		var Set<String> classNames = new HashSet<String>()
		for (Mutator command : commands) {
			if (command.name !== null) {
				if (command.name.equals(com.objSel.name)) {
					classNames.addAll(getType(command))
				}
			}
		}
		if (env !== null && classNames !== null && classNames.size() > 0) {
        	val Definition  definition = env.definition
   			var EObject      sel = com.objSel
   			if (sel instanceof SelectObjectMutator &&
   				(sel as SelectObjectMutator).object instanceof RandomTypeSelection &&
   				((sel as SelectObjectMutator).object as RandomTypeSelection).resource !== null
   			) {
   				val String resourceName = ((sel as SelectObjectMutator).object as RandomTypeSelection).resource
   				if (definition instanceof Program) {
   					val Program program = definition as Program
   					var mutatorenvironment.Resource resource = null
   					for (mutatorenvironment.Resource res : program.resources) {
   						if (res.name.equals(resourceName)) {
   							resource = res
   						}
   					}
   				}
   			}
   			for (String className : classNames) {
   				attributes.addAll( getEAttributes(definition, className) ) 
   			}
       	}
       	Scopes.scopeFor(attributes)
    }
    
	/**
	 * MinValueType.attribute must be of the type defined by com.type 
	 */
     def IScope scope_MinValueType_attribute(MinValueType com, EReference ref) {
		
		var ArrayList<EAttribute> scopes = new ArrayList<EAttribute>()
       	
       	var Mutator mut = null
		var EObject container = com.eContainer
		while (container instanceof Mutator == false && container !== null) {
			container = container.eContainer
		}
		
		if (container !== null) {
			mut = container as Mutator
			val MutatorEnvironment env = getMutatorEnvironment(mut) 
    	    val Definition  definition = env.definition
        	var String className = null
        	if (mut instanceof CreateObjectMutator) {
        		className = mut.type.name
        	}
        	if (mut instanceof CloneObjectMutator) {
	       		if (mut.object instanceof SpecificObjectSelection) {
    	   			val SpecificObjectSelection selection = mut.object as SpecificObjectSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof SpecificClosureSelection) {
    	   			val SpecificClosureSelection selection = mut.object as SpecificClosureSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof RandomTypeSelection) {
       				val RandomTypeSelection selection = mut.object as RandomTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof CompleteTypeSelection) {
       				val CompleteTypeSelection selection = mut.object as CompleteTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof TypedSelection) {
       				val TypedSelection selection = mut.object as TypedSelection
       				className = selection.type.name
       			}
       		} 
	       	if (mut instanceof SelectObjectMutator) {
	       		if (mut.object instanceof SpecificObjectSelection) {
    	   			val SpecificObjectSelection selection = mut.object as SpecificObjectSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof SpecificClosureSelection) {
    	   			val SpecificClosureSelection selection = mut.object as SpecificClosureSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof RandomTypeSelection) {
       				val RandomTypeSelection selection = mut.object as RandomTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof CompleteTypeSelection) {
       				val CompleteTypeSelection selection = mut.object as CompleteTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof TypedSelection) {
       				val TypedSelection selection = mut.object as TypedSelection
       				className = selection.type.name
       			}
       		} 
     		
       		if (mut instanceof ModifyInformationMutator) {
	       		if (mut.object instanceof SpecificObjectSelection) {
    	   			val SpecificObjectSelection selection = mut.object as SpecificObjectSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof SpecificClosureSelection) {
    	   			val SpecificClosureSelection selection = mut.object as SpecificClosureSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof RandomTypeSelection) {
       				val RandomTypeSelection selection = mut.object as RandomTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof CompleteTypeSelection) {
       				val CompleteTypeSelection selection = mut.object as CompleteTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof TypedSelection) {
       				val TypedSelection selection = mut.object as TypedSelection
       				className = selection.type.name
       			}
       		}
			if (className !== null) {
				scopes.addAll( getEAttributes(definition, className) )
       		}
		}
		Scopes.scopeFor( scopes )
    }
    
	/**
	 * MaxValueType.attribute must be of the type defined by com.type 
	 */
     def IScope scope_MaxValueType_attribute(MaxValueType com, EReference ref) {
		
		var ArrayList<EAttribute> scopes = new ArrayList<EAttribute>()
       	
       	var Mutator mut = null
		var EObject container = com.eContainer
		while (container instanceof Mutator == false && container !== null) {
			container = container.eContainer
		}
		
		if (container !== null) {
			mut = container as Mutator
			val MutatorEnvironment env = getMutatorEnvironment(mut) 
    	    val Definition  definition = env.definition
        	var String className = null
        	if (mut instanceof CreateObjectMutator) {
        		className = mut.type.name
        	}
        	if (mut instanceof CloneObjectMutator) {
	       		if (mut.object instanceof SpecificObjectSelection) {
    	   			val SpecificObjectSelection selection = mut.object as SpecificObjectSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof SpecificClosureSelection) {
    	   			val SpecificClosureSelection selection = mut.object as SpecificClosureSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof RandomTypeSelection) {
       				val RandomTypeSelection selection = mut.object as RandomTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof CompleteTypeSelection) {
       				val CompleteTypeSelection selection = mut.object as CompleteTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof TypedSelection) {
       				val TypedSelection selection = mut.object as TypedSelection
       				className = selection.type.name
       			}
       		} 
	       	if (mut instanceof SelectObjectMutator) {
	       		if (mut.object instanceof SpecificObjectSelection) {
    	   			val SpecificObjectSelection selection = mut.object as SpecificObjectSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof SpecificClosureSelection) {
    	   			val SpecificClosureSelection selection = mut.object as SpecificClosureSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof RandomTypeSelection) {
       				val RandomTypeSelection selection = mut.object as RandomTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof CompleteTypeSelection) {
       				val CompleteTypeSelection selection = mut.object as CompleteTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof TypedSelection) {
       				val TypedSelection selection = mut.object as TypedSelection
       				className = selection.type.name
       			}
       		} 
     		
       		if (mut instanceof ModifyInformationMutator) {
	       		if (mut.object instanceof SpecificObjectSelection) {
    	   			val SpecificObjectSelection selection = mut.object as SpecificObjectSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof SpecificClosureSelection) {
    	   			val SpecificClosureSelection selection = mut.object as SpecificClosureSelection
       				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof RetypeObjectMutator) {
       					className = selection.objSel.type.name
       				}
       			}
       			if (mut.object instanceof RandomTypeSelection) {
       				val RandomTypeSelection selection = mut.object as RandomTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof CompleteTypeSelection) {
       				val CompleteTypeSelection selection = mut.object as CompleteTypeSelection
       				className = selection.type.name
       			}
       			if (mut.object instanceof TypedSelection) {
       				val TypedSelection selection = mut.object as TypedSelection
       				className = selection.type.name
       			}
       		}
			if (className !== null) {
				scopes.addAll( getEAttributes(definition, className) )
       		}
		}
		Scopes.scopeFor( scopes )
    }

	/**
	 * RandomNumberType.attribute must be of the type defined by com.type 
	 */
     def IScope scope_RandomNumberType_max(RandomNumberType com, EReference ref) {
		
		var ArrayList<EAttribute> scopes = new ArrayList<EAttribute>()
		var String className = null
		var Definition definition = null
       	
       	var Mutator mut = null
		var EObject container = com.eContainer
		while (container instanceof Mutator == false && container !== null) {
			container = container.eContainer
			mut = container as Mutator
			val MutatorEnvironment env = getMutatorEnvironment(mut) 
    	    definition = env.definition
		}

		if (com.object !== null) {
       		if (com.object instanceof SpecificObjectSelection) {
    	   		val SpecificObjectSelection selection = com.object as SpecificObjectSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
   				if (selection.objSel instanceof RetypeObjectMutator) {
   					className = selection.objSel.type.name
   				}
       		}
       		if (com.object instanceof SpecificClosureSelection) {
    	   		val SpecificClosureSelection selection = com.object as SpecificClosureSelection
       			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
   				if (selection.objSel instanceof RetypeObjectMutator) {
   					className = selection.objSel.type.name
   				}
       		}
       		if (com.object instanceof RandomTypeSelection) {
       			val RandomTypeSelection selection = com.object as RandomTypeSelection
       			className = selection.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			val CompleteTypeSelection selection = com.object as CompleteTypeSelection
       			className = selection.type.name
       		}
       		if (com.object instanceof TypedSelection) {
       			val TypedSelection selection = com.object as TypedSelection
       			className = selection.type.name
       		}
			scopes.addAll( getEAttributes(definition, className) )
		}
		Scopes.scopeFor( scopes )
    }
    
    /**
	 * SelectSampleMutator.features must be features of the type defined by com.type
	 */
    def IScope scope_SelectSampleMutator_features(SelectSampleMutator com, EReference ref) {
		val MutatorEnvironment env = getMutatorEnvironment(com) 
        val Definition  definition = env.definition
        val List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>()
        
        // the only possibility is that the container is a RandomTypeSelection
        if (com.object instanceof ObSelectionStrategy) {
        	var String className = null
        	if (com.object instanceof RandomTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof CompleteTypeSelection) {
       			className = com.object.type.name
       		}
       		if (com.object instanceof SpecificObjectSelection) {
       			val SpecificObjectSelection selection = com.object as SpecificObjectSelection
       			if (selection.refType === null) {
     				if (selection.objSel instanceof CreateObjectMutator) {
       					className = selection.objSel.type.name
       				}
       				if (selection.objSel instanceof SelectObjectMutator) {
       					className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       				}
       				if (selection.objSel instanceof SelectSampleMutator) {
						className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
					}
       				if (selection.objSel instanceof CloneObjectMutator) {
       					className = selection.objSel.type.name
       				}
					if (selection.objSel instanceof RetypeObjectMutator) {
   						className = selection.objSel.type.name
   					}
       			}
       			else {
       				className = selection.refType.EType.name
       			}
       		}
       		
       		if (com.object instanceof SpecificClosureSelection) {
       			val SpecificClosureSelection selection = com.object as SpecificClosureSelection
     			if (selection.objSel instanceof CreateObjectMutator) {
       				className = selection.objSel.type.name
       			}
       			if (selection.objSel instanceof SelectObjectMutator) {
       				className = MutatorUtils.selectObjectMutatorHelperName(selection.objSel as SelectObjectMutator)
       			}
       			if (selection.objSel instanceof SelectSampleMutator) {
					className = MutatorUtils.selectSampleMutatorHelperName(selection.objSel as SelectSampleMutator)
				}
       			if (selection.objSel instanceof CloneObjectMutator) {
       				className = selection.objSel.type.name
       			}
   				if (selection.objSel instanceof RetypeObjectMutator) {
   					className = selection.objSel.type.name
   				}
       		}
        	if (com.object instanceof TypedSelection) {
       			className = com.object.type.name
       		}
        	
	       	// 	add references to scope
   	   		scope.addAll(getEAttributes(definition, className))
   	   		scope.addAll(getEReferences(definition, className))
       	}
   		Scopes.scopeFor( scope )  
    }
    

    /**
     * PathElementCS.pathName can contain any EStructuralFeature defined by the
     * constraint.type.name
     */
    def IScope scope_PathElementCS_pathName(Constraint constraint, EReference ref) {
    	val List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>()
    	var EObject container = constraint.eContainer
    	while (container !== null && (container instanceof MutatorEnvironment) == false) {
    		container = container.eContainer
    	}
    	val MutatorEnvironment env = container as MutatorEnvironment
    	val Definition definition = env.definition
    	scope.addAll(getEStructuralFeatures(definition.metamodel, constraint.type.name))
    	Scopes.scopeFor( scope )
    }
    
    /**
     * PathElementCS.pathName can contain any EStructuralFeature defined by the
     * expression variable
     */
    def IScope scope_NavigationPathElementCS_pathName(InvariantCS invariant, EReference ref) {
    	val List<EStructuralFeature> scope = new ArrayList<EStructuralFeature>()
    	var EObject container = invariant.eContainer
    	while (container !== null && (container instanceof MutatorEnvironment) == false) {
    		container = container.eContainer
    	}
    	val MutatorEnvironment env = container as MutatorEnvironment
    	val Definition definition = env.definition
   		if (invariant.exp instanceof CallExpCS) {
   			val CallExpCS callExpCS = invariant.exp as CallExpCS
   			if (callExpCS.source instanceof NameExpCS) {
   				val NameExpCS nameExpCS = callExpCS.source as NameExpCS
	    		val PathElementCS pathElementCS = nameExpCS.expName.path.get(0) as PathElementCS
    			scope.addAll(getEStructuralFeatures(definition.metamodel, pathElementCS.pathName.EType.name))
   			}
    	}
    	Scopes.scopeFor( scope )
    }
    
 	//--------------------------------------------------------------------------------------
	// PRIVATE METHODS
	//--------------------------------------------------------------------------------------
	
	/**
	 * It returns the mutator environment that contains an object
	 */
	 def private MutatorEnvironment getMutatorEnvironment (ObjectEmitter oe) { EcoreUtil2.getContainerOfType(oe, MutatorEnvironment) }
	 def private MutatorEnvironment getMutatorEnvironment (ReferenceSet  oe) { EcoreUtil2.getContainerOfType(oe, MutatorEnvironment) }
	 def private MutatorEnvironment getMutatorEnvironment (Constraint oe) { EcoreUtil2.getContainerOfType(oe, MutatorEnvironment) }
	 
	/**
	 * It returns the list of commands in the scope of the received mutator. 
	 * The scope can be either the environment or a composite mutator.
	 * @param Mutator
	 * @return List<Mutator>
	 */
	def private List<Mutator> getCommands (Mutator com) {
		if (com.eContainer instanceof Block) return (com.eContainer as Block).commands
		if (com.eContainer instanceof CompositeMutator)   return (com.eContainer as CompositeMutator).commands
		if (com.eContainer instanceof MutatorEnvironment) return (com.eContainer as MutatorEnvironment).commands
		return new ArrayList<Mutator>()
	}
	
    /**
     * It returns the type to which a mutator applies.  
     */
    def private Set<String> getType (Mutator mutator) {
    	var Set<String> types = new HashSet<String>()
    	if (mutator instanceof SelectObjectMutator)
    		types.add((mutator as SelectObjectMutator).object?.type?.name)
    	if (mutator instanceof SelectSampleMutator) {
			if ((mutator as SelectSampleMutator).object instanceof RandomTypeSelection) {
				types.add((mutator as SelectSampleMutator).object?.type?.name)
			}
			if ((mutator as SelectSampleMutator).object instanceof SpecificObjectSelection) {
				if (((mutator as SelectSampleMutator).object as SpecificObjectSelection).refType === null) {
					val ObjectEmitter o = ((mutator as SelectSampleMutator).object as SpecificObjectSelection).objSel
					if (o instanceof SelectObjectMutator) {
						types.add((o as SelectObjectMutator).object?.type?.name)
					}
					if (o instanceof CreateObjectMutator) {
						types.add((o as CreateObjectMutator).type?.name)
					}
	       			if (o instanceof SelectSampleMutator) {
						types.add(MutatorUtils.selectSampleMutatorHelperName(o as SelectSampleMutator))
					}
					if (o instanceof CloneObjectMutator) {
						types.add((o as CloneObjectMutator).object?.type?.name)
					}
	   				if (o instanceof RetypeObjectMutator) {
   						types.add((o as RetypeObjectMutator).object?.type?.name)
   						types.add((o as RetypeObjectMutator).type?.name)
   						for (EClass type : (o as RetypeObjectMutator)?.types) {
   							types.add(type.name)
   						}
   					}
				}
				else {
					types.add(((mutator as SelectSampleMutator).object as SpecificObjectSelection).refType.EType.name)
				}
			}
			if ((mutator as SelectSampleMutator).object instanceof SpecificClosureSelection) {
				if (((mutator as SelectSampleMutator).object as SpecificObjectSelection).refType === null) {
					val ObjectEmitter o = ((mutator as SelectSampleMutator).object as SpecificClosureSelection).objSel
					if (o instanceof SelectObjectMutator) {
						types.add((o as SelectObjectMutator).object?.type?.name)
					}
					if (o instanceof CreateObjectMutator) {
						types.add((o as CreateObjectMutator).type?.name)
					}
					if (o instanceof SelectSampleMutator) {
						types.add(MutatorUtils.selectSampleMutatorHelperName(o as SelectSampleMutator))
					}
					if (o instanceof CloneObjectMutator) {
						types.add((o as CloneObjectMutator).object?.type?.name)
					}
	   				if (o instanceof RetypeObjectMutator) {
   						types.add((o as RetypeObjectMutator).object?.type?.name)
   						types.add((o as RetypeObjectMutator).type?.name)
   						for (EClass type : (o as RetypeObjectMutator)?.types) {
   							types.add(type.name)
   						}
   					}
				}
				else {
					types.add(((mutator as SelectSampleMutator).object as SpecificClosureSelection).refType.EType.name)
				}
			}
			if ((mutator as SelectSampleMutator).object instanceof TypedSelection) {
				types.add((mutator as SelectSampleMutator).object?.type?.name)
			}
		}
		if (mutator instanceof ModifyInformationMutator) {
			if ((mutator as ModifyInformationMutator).object instanceof RandomTypeSelection) {
				types.add((mutator as ModifyInformationMutator).object?.type?.name)
			}
			if ((mutator as ModifyInformationMutator).object instanceof SpecificObjectSelection) {
				val ObjectEmitter o = ((mutator as ModifyInformationMutator).object as SpecificObjectSelection).objSel
				if (o instanceof SelectObjectMutator) {
					types.add((o as SelectObjectMutator).object?.type?.name)
				}
				if (o instanceof CreateObjectMutator) {
					types.add((o as CreateObjectMutator).type?.name)
				}
				if (o instanceof SelectSampleMutator) {
					types.add(MutatorUtils.selectSampleMutatorHelperName(o as SelectSampleMutator))
				}
				if (o instanceof CloneObjectMutator) {
					types.add((o as CloneObjectMutator).object?.type?.name)
				}
   				if (o instanceof RetypeObjectMutator) {
   					types.add((o as RetypeObjectMutator).object?.type?.name)
   					types.add((o as RetypeObjectMutator).type?.name)
   					for (EClass type : (o as RetypeObjectMutator)?.types) {
   						types.add(type.name)
   					}
				}
			}
			if ((mutator as ModifyInformationMutator).object instanceof SpecificClosureSelection) {
				val ObjectEmitter o = ((mutator as ModifyInformationMutator).object as SpecificClosureSelection).objSel
				if (o instanceof SelectObjectMutator) {
					types.add((o as SelectObjectMutator).object?.type?.name)
				}
				if (o instanceof CreateObjectMutator) {
					types.add((o as CreateObjectMutator).type?.name)
				}
				if (o instanceof SelectSampleMutator) {
					types.add(MutatorUtils.selectSampleMutatorHelperName(o as SelectSampleMutator))
				}
				if (o instanceof CloneObjectMutator) {
					types.add((o as CloneObjectMutator).object?.type?.name)
				}
   				if (o instanceof RetypeObjectMutator) {
   					types.add((o as RetypeObjectMutator).object?.type?.name)
   					types.add((o as RetypeObjectMutator).type?.name)
   					for (EClass type : (o as RetypeObjectMutator)?.types) {
   						types.add(type.name)
   					}
				}
			}
			if ((mutator as ModifyInformationMutator).object instanceof TypedSelection) {
				types.add((mutator as ModifyInformationMutator).object?.type?.name)
			}
		}
		if (mutator instanceof RetypeObjectMutator) {
			types.add((mutator as RetypeObjectMutator).type?.name)
			for (EClass type : (mutator as RetypeObjectMutator).types) {
				types.add(type.name)
			}
			if ((mutator as RetypeObjectMutator).object instanceof RandomTypeSelection) {
				types.add((mutator as RetypeObjectMutator).object?.type?.name)
			}
			if ((mutator as RetypeObjectMutator).object instanceof SpecificObjectSelection) {
				types.add(((mutator as RetypeObjectMutator).object as SpecificObjectSelection).objSel?.type?.name)
			}
			if ((mutator as RetypeObjectMutator).object instanceof SpecificObjectSelection) {
				val ObjectEmitter o = ((mutator as RetypeObjectMutator).object as SpecificObjectSelection).objSel
				if (o instanceof SelectObjectMutator) {
					types.add((o as SelectObjectMutator).object?.type?.name)
				}
				if (o instanceof CreateObjectMutator) {
					types.add((o as CreateObjectMutator).type?.name)
				}
				if (o instanceof SelectSampleMutator) {
					types.add(MutatorUtils.selectSampleMutatorHelperName(o as SelectSampleMutator))
				}
				if (o instanceof CloneObjectMutator) {
					types.add((o as CloneObjectMutator).object?.type?.name)
				}
   				if (o instanceof RetypeObjectMutator) {
   					types.add((o as RetypeObjectMutator).object?.type?.name)
   					types.add((o as RetypeObjectMutator).type?.name)
   					for (EClass type : (o as RetypeObjectMutator)?.types) {
   						types.add(type.name)
   					}
				}
			}
			if ((mutator as RetypeObjectMutator).object instanceof SpecificClosureSelection) {
				val ObjectEmitter o = ((mutator as RetypeObjectMutator).object as SpecificClosureSelection).objSel
				if (o instanceof SelectObjectMutator) {
					types.add((o as SelectObjectMutator).object?.type?.name)
				}
				if (o instanceof CreateObjectMutator) {
					types.add((o as CreateObjectMutator).type?.name)
				}
				if (o instanceof SelectSampleMutator) {
					types.add(MutatorUtils.selectSampleMutatorHelperName(o as SelectSampleMutator))
				}
				if (o instanceof CloneObjectMutator) {
					types.add((o as CloneObjectMutator).object?.type?.name)
				}
   				if (o instanceof RetypeObjectMutator) {
   					types.add((o as RetypeObjectMutator).object?.type?.name)
   					types.add((o as RetypeObjectMutator).type?.name)
   					for (EClass type : (o as RetypeObjectMutator)?.types) {
   						types.add(type.name)
   					}
				}
			}
			if ((mutator as RetypeObjectMutator).object instanceof TypedSelection) {
				types.add((mutator as RetypeObjectMutator).object?.type?.name)
				types.add((mutator as RetypeObjectMutator).type?.name)
				for (EClass type : (mutator as RetypeObjectMutator).types) {
					types.add(type.name)
				}
			}
		}
		if (types.size() == 0) {
			types.add(mutator.type?.name)
		}
    	return types
    }
    
    /**
     * It receives a list of commands, and returns the command with the given name in commands[0..maxindex]. 
     */
     def private Mutator getCommand (String name, List<Mutator> commands, int maxindex) {
     	var Mutator command = null;
     	for (Mutator mutator : commands) {
     		if (mutator.name?.equals(name) && commands.indexOf(mutator) < maxindex) { 
				command = mutator
			}
		}
		return command;
    }
    
    /**
     * Gets the EClass list defined in the given meta-model
     */
    
    def private List<EClass> getEClassesHelper(List<EPackage> packages) {
    	var List<EClass> classes = new ArrayList<EClass>()
    	for (EPackage pck : packages) {
          for (EClassifier cl : pck.EClassifiers)
            if (cl instanceof EClass)
              classes.add(cl as EClass)
          if (pck.ESubpackages !== null) {
    	  	classes.addAll(getEClassesHelper(pck.ESubpackages))
    	  }
    	}
    	return classes
    }

	/** 
	 * It returns the list of classes defined in a meta-model.
	 * @param String file containing the metamodel
	 * @return List<EClass>
	 */
	 def private List<EClass> getEClasses (Definition definition) {
        val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	
    	val List<EClass> classes = new ArrayList<EClass>()
    	for (String mm : metamodels) {
	        val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
        	for (EPackage pck : metamodel) {
          	for (EClassifier cl : pck.EClassifiers)
            	if (cl instanceof EClass)
        	      	classes.add(cl as EClass)
	        	  	if (pck.ESubpackages !== null) {
    	      			classes.addAll(getEClassesHelper(pck.ESubpackages))
          			}
        	}
        }
        return classes
	 }
	 
	 
	/** 
	 * It returns the list of subclasses of the given class.
	 * @param String file containing the metamodel
	 * @param EClass given class
	 * @return List<EClass>
	 */
	 def private List<EClass> getESubClasses (Definition definition, EClass eclass) {
        val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	
    	val List<EClass> classes = new ArrayList<EClass>()
    	for (String mm : metamodels) {
        	val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
        	classes.addAll(ModelManager.getESubClasses(metamodel, eclass))
        }
        return classes
	 }
	 
	 /** 
	 * It returns the list of classes existing in a model.
	 * @param String file containing the model
	 * @return List<EClass>
	 */
	 def private List<EClass> getModelEClasses (Definition definition, String modelFile) {
	 	val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	for (String mm : metamodels) {
	        val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
	        try {
	    	    val Resource model = ModelManager.loadModel(metamodel, modelFile)
	    	    if (model !== null) {
	        		val List<EObject>   classes = ModelManager.getAllObjects(model)
        			val List<EClass>   ret   = new ArrayList<EClass>()
        			for(EObject o : classes){
        				if(!ret.contains(o.eClass())) ret.add(o.eClass())
        			}
        			val List<EClass> mmclasses = ModelManager.getEClasses(metamodel)
        			for(EClass cl : mmclasses){
        				if(!ret.contains(cl)) ret.add(cl)
	       			}
    	    		return ret
    	    	}
    	    } catch (Exception e) {
    	    }
    	}
    	return new ArrayList<EClass>()
	 }
	 
	/** 
	 * It returns the list of references defined in a meta-model.
	 * @param String file containing the metamodel
	 * @return List<EReference>
	 */
	 def private List<EReference> getEReferences (Definition definition) {
        val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	
    	val List<EReference> references = new ArrayList<EReference>()
    	for (String mm : metamodels) {
	  		val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
        	for (EPackage pck : metamodel) {
          	for (EClassifier cl : pck.EClassifiers)
            	if (cl instanceof EClass)
             		references.addAll((cl as EClass).EReferences)
          			for (EPackage spck : pck.ESubpackages)
				        for (EClassifier cl : spck.EClassifiers)
    	    				if (cl instanceof EClass)
        	    				references.addAll((cl as EClass).EReferences)
        	}
        }
        return references
	 }
	 
	 /**
	  * It returns the list of classes which can contain (through a containment relation) the given class.
	  * @param String file containing the metamodel
	  * @param String class name
	  * @return List<EClass> list of containers
	  */
	  def private List<EClass> getEContainers (String metamodelFile, EClass eclass) {
	  	// get all container eclassifiers
	  	val List<EPackage>    metamodel  = ModelManager.loadMetaModel(metamodelFile)
        val List<EClassifier> containers = ModelManager.getContainerTypes(metamodel, EcoreUtil.getURI(eclass))
        
        // filter to keep only eclasses
        val List<EClass> classes = new ArrayList<EClass>()
        for (EClassifier cl : containers)
          if (cl instanceof EClass)
            classes.add(cl as EClass)
        return classes    
	  } 
	  
	 /**
	  * It returns the list of classes which defines the given relation.
	  * @param String file containing the metamodel
	  * @param String class name
	  * @return List<EClass> list of containers
	  */
	  def private List<EClass> getESources (Definition definition, String ereferenceName) {
	  	val List<EClass> eclasses = getEClasses(definition)
	  	// filter to keep only eclasses which define the received reference
	  	val List<EClass> esources = new ArrayList<EClass>()
	  	for (EClass cl : eclasses) {
	  	  	if (cl.getEStructuralFeature(ereferenceName) !== null) {
	  	    	esources.add(cl)
		  		esources.addAll(getESubClasses(definition, cl))
	  		}
  	    }
	  	return esources    
	  }
	  
	  
	  /**
	  * It returns the list of classes which are pointed by the given relation.
	  * @param String file containing the metamodel
	  * @param String class name
	  * @return List<EClass> list of containments
	  */
	  def private List<EClass> getETargets (Definition definition, String ereferenceName) {
	  	val List<EClass> eclasses = getEClasses(definition)
	  	val List<EReference> ereferences = getEReferences(definition)
	  	
	  	// MODIFICAR ESTE METODO
	  	// filter to keep only eclasses contained by the received reference
	  	val List<EClass> etargets = new ArrayList<EClass>()
	  	for (EClass cl : eclasses){
	  		for(EReference rl : ereferences){
	  			if(cl.getName().equals(rl.getEType.getName()) && rl.getName().equals(ereferenceName)){
	  				etargets.add(cl)	  				
			  		etargets.addAll(getESubClasses(definition, cl))
	  			}
	  		}
	  	}
	  	return etargets    
	  }
	  
	  /**
	  * It returns the list of classes which defines the given relation.
	  * @param String file containing the metamodel
	  * @param String class name
	  * @return List<EClass> list of containers
	  */
	  def private List<EClass> getModelESources (Definition definition, String modelFile, String ereferenceName) {
	  	val List<EClass> eclasses = getModelEClasses(definition, modelFile)
	  	
	  	// filter to keep only eclasses which define the received reference
	  	val List<EClass> esources = new ArrayList<EClass>()
	  	for (EClass cl : eclasses)
	  	  if (cl.getEStructuralFeature(ereferenceName) !== null) {
	  	    esources.add(cl)
	  	    esources.addAll(getESubClasses(definition, cl))
	  	  }
	  	return esources    
	  } 	  

	 /**
	  * It returns the list of containment references from a source class to a target class.
	  * @param String file containing the metamodel
	  * @param String source class name
	  * @param String target class name
	  * @return List<EReference> list of references
	  */
	  def private List<EReference> getEContainmentReferences (Definition definition, String esourceclassName, String etargetclassName) {
	  	val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
	  	
	  	for (String mmsource : metamodels) {
	  		val List<EPackage> metamodelsource = ModelManager.loadMetaModel(mmsource)
	  		val sourceclass = ModelManager.getObjectOfType(esourceclassName, metamodelsource) as EClass
	  		if (sourceclass !== null) {
	  			for (String mmtarget : metamodels) {
		  			val List<EPackage> metamodeltarget = ModelManager.loadMetaModel(mmtarget)
			  		val targetclass = ModelManager.getObjectOfType(esourceclassName, metamodeltarget) as EClass
					val List<EReference> references = new ArrayList<EReference>()
					if (sourceclass !== null && targetclass !== null) {
		  				for (EReference ref : sourceclass.EAllReferences) {
			  				if (ref.EReferenceType.isSuperTypeOf(targetclass)) // the same target type, or a supertype 
					  			if (ref.containment && ref.changeable) // containment
	  		    					references.add(ref)	  		
		  				}	  		
				  		return references 
			  		}
	  			}
	  		} 
		}  	
	  }
	  
	 /**
	  * It returns the list of containment references from a source class to a target class.
	  * @param String file containing the metamodel
	  * @param String source class name
	  * @param String target class name
	  * @return List<EReference> list of references
	  */
	  def private List<EReference> getEReferences (Definition definition, String esourceclassName, String etargetclassName) {
	  	val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
	  	
		val List<EReference> references = new ArrayList<EReference>()
	  	for (String mmsource : metamodels) {
	  		val List<EPackage> metamodelsource = ModelManager.loadMetaModel(mmsource)
	  		val sourceclass = ModelManager.getObjectOfType(esourceclassName, metamodelsource) as EClass
	  		if (sourceclass !== null) {
	  			for (String mmtarget : metamodels) {
		  			val List<EPackage> metamodeltarget = ModelManager.loadMetaModel(mmtarget)
			  		val targetclass = ModelManager.getObjectOfType(etargetclassName, metamodeltarget) as EClass
					if (sourceclass !== null && targetclass !== null) {
		  				for (EReference ref : sourceclass.EAllReferences) {
		  					var EClass type = ModelManager.getEClassByName(metamodeltarget, ref.EReferenceType.name)
		  					if (type === null) {
		  						type = ref.EReferenceType
		  					}
			  				if (type.isSuperTypeOf(targetclass)) // the same target type, or a supertype 
		  			    		references.add(ref)
		  				}	  		
				  		return references 
			  		}
	  			}
	  		} 
		}  	
	  }

	  /**
	   * It return the list of attributes of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EAttribute> list of attributes
	   */ 
	   def private List<EAttribute> getEAttributes (Definition definition, String eclassName) {
	  	val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	
    	for (String mm : metamodels) {
	  		val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
		  	val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
		  	if (eclass !== null) {
	  			val List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass)
		  		var List<EAttribute> attributes = new ArrayList<EAttribute>()
		  		for (EClass subclass : subclasses) {
	  				attributes.addAll(subclass.EAllAttributes)
	  			}
	  			attributes.addAll(eclass.EAllAttributes)
	  			return attributes
			}
    	}
 		return new ArrayList<EAttribute>()
  	}
  	
	  /**
	   * It return the list of attributes of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EAttribute> list of attributes
	   */ 
	   def private List<EAttribute> getEAttributes (Definition definition, Set<String> eclassNames) {
	  	val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	
    	var List<EAttribute> attributes = new ArrayList<EAttribute>()
    	for (String mm : metamodels) {
	  		val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
	  		for (String eclassName : eclassNames) {
		  	val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
		  	if (eclass !== null) {
	  			val List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass)
		  		for (EClass subclass : subclasses) {
	  				attributes.addAll(subclass.EAllAttributes)
	  			}
	  			attributes.addAll(eclass.EAllAttributes)
			}
			}
    	}
 		return attributes
  	}
	  /**
	   * It return the list of attributes of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EAttribute> list of attributes
	   */ 
	   def private List<EReference> getEReferences (Definition definition, String eclassName) {
	  	val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	
    	for (String mm : metamodels) {
	  		val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
	  		val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
	  		if (eclass !== null) {
	  			val List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass)
	  			var List<EReference> references = new ArrayList<EReference>()
	  			for (EClass subclass : subclasses) {
	  				references.addAll(subclass.EAllReferences)
	  			}
	  			references.addAll(eclass.EAllReferences)
	  			return references
	  		}
		}
	  
	  	return new ArrayList<EReference>()
	  }

	  /**
	   * It return the list of attributes of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EAttribute> list of attributes
	   */ 
	   def private List<EReference> getEReferences (Definition definition, Set<String> eclassNames) {
	  	val List<String> resourceMM = getResourceMetamodels(definition)
    	var List<String> metamodels = new ArrayList<String>()
	    metamodels.add(definition.metamodel)
    	metamodels.addAll(resourceMM)
    	
		var List<EReference> references = new ArrayList<EReference>()
    	for (String mm : metamodels) {
	  		val List<EPackage> metamodel = ModelManager.loadMetaModel(mm)
	  		for (String eclassName : eclassNames) {
		  		val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
		  		if (eclass !== null) {
	  				val List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass)
	  				for (EClass subclass : subclasses) {
	  					references.addAll(subclass.EAllReferences)
	  				}
	  				references.addAll(eclass.EAllReferences)
	  			}
	  		}
		}
	  
	  	return references
	  }
	  /**
	   * It return the list of attributes of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EAttribute> list of attributes
	   */ 
	   def private EReference getEReference (String metamodelFile, String eclassName, String refName) {
	  	val List<EPackage>    metamodel  = ModelManager.loadMetaModel(metamodelFile)
	  	val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
	  	if (eclass !== null) {
	  		val List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass)
	  		var List<EReference> references = new ArrayList<EReference>()
	  		for (EClass subclass : subclasses) {
	  			references.addAll(subclass.EAllReferences)
	  		}
	  		references.addAll(eclass.EAllReferences)
	  		for (EReference ref : references) {
	  			if (ref.name.equals(refName)) {
	  				return ref
	  			}
	  		}
	  		return null
		}
	  }

	  /**
	   * It return the list of structural features of a class.
	   * @param String file containing the metamodel
	   * @param String class name
	   * @return List<EAttribute> list of attributes
	   */ 
	   def private List<EStructuralFeature> getEStructuralFeatures (String metamodelFile, String eclassName) {
	  	val List<EPackage>    metamodel  = ModelManager.loadMetaModel(metamodelFile)
	  	val EClass            eclass     = ModelManager.getObjectOfType(eclassName, metamodel) as EClass
	  	if (eclass !== null) {
	  	if (eclass !== null) {
	  		val List<EClass> subclasses = ModelManager.getESubClasses(metamodel, eclass)
	  		var List<EStructuralFeature> features = new ArrayList<EStructuralFeature>()
	  		for (EClass subclass : subclasses) {
	  			features.addAll(subclass.EAllStructuralFeatures)
	  		}
	  		features.addAll(eclass.EAllStructuralFeatures)
	  		return features
		}
	  	else {
	  		return new ArrayList<EStructuralFeature>()
  		}
  	}
  	}
  	def private String getMetamodel (Definition definition, String className) {
		var String      metamodel = definition?.metamodel
   		var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
   		var EClass eclass = ModelManager.getEClassByName(packages, className)
   		if (eclass === null) {
   			if (definition instanceof Program) {
   				val Program program = definition as Program
   				for (mutatorenvironment.Resource resource : program.resources) {
   					packages = ModelManager.loadMetaModel(resource.metamodel)
   					eclass = ModelManager.getEClassByName(packages, className)
   					if (eclass !== null) {
   						return resource.metamodel
   					}
   				}
   			}
   		}
   		return null
   	}
   	
   	def private List<String> getResourceMetamodels(Definition definition) {
   		var List<String> metamodels = new ArrayList<String>()
        if (definition === null) {
        	return metamodels
        }
        if (definition instanceof Program) { 
        	val Program program = definition as Program
        	for (mutatorenvironment.Resource resource : definition.resources) {
        		if (!metamodels.contains(resource.metamodel)) {
        			metamodels.add(resource.metamodel)
        		}
        	}
        }
   		return metamodels
   	}

   	def private void addResourceClasses (Definition definition, EClass type, List<EClass> classes) {
   		if (classes === null || definition === null) {
   			return
   		}
   		val List<String> metamodels = getResourceMetamodels(definition)
   		for (String metamodel : metamodels) {
   			var List<EClass> resourceClasses = ModelManager.getSiblingEClasses(metamodel, type)
   			for (EClass resourceClass : resourceClasses) {
   				if (!classes.contains(resourceClass)) {
   					classes.add(resourceClass)
   				}
   			}
   		} 
   	}
	/**
	 * @param name
	 *            Name of the reference
	 * @param object
	 *            Object one wants to explore
	 * @return EStructuralFeature Specified reference
	 */
	def private EStructuralFeature getReferenceByName(Definition definition, String name,
			String className) {
   		var String metamodel = definition?.metamodel
   		var List<EPackage> packages = ModelManager.loadMetaModel(metamodel)
		var EClass eClass = ModelManager.getEClassByName(packages, className)
		var EStructuralFeature sf = null
		if (eClass !== null) {
			sf = eClass.getEStructuralFeature(name)
		}
		return sf
	}
}