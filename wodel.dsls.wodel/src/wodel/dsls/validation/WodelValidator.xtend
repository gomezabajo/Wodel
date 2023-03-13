package wodel.dsls.validation

import wodel.dsls.validation.AbstractWodelValidator
import java.util.List
import org.eclipse.emf.ecore.EPackage
import mutatorenvironment.Program
import org.eclipse.xtext.validation.Check
import wodel.utils.manager.ModelManager
import java.io.File
import wodel.utils.exceptions.MetaModelNotFoundException
import mutatorenvironment.CreateObjectMutator
import mutatorenvironment.Mutator
import org.eclipse.emf.common.util.EList
import mutatorenvironment.AttributeSet
import mutatorenvironment.AttributeUnset
import org.eclipse.emf.ecore.EAttribute
import mutatorenvironment.AttributeSwap
import mutatorenvironment.AttributeCopy
import mutatorenvironment.AttributeScalar
import mutatorenvironment.AttributeType
import mutatorenvironment.IntegerType
import mutatorenvironment.BooleanType
import mutatorenvironment.StringType
import mutatorenvironment.DoubleType
import mutatorenvironment.ListStringType
import mutatorenvironment.ModifyInformationMutator
import mutatorenvironment.AttributeReverse

/**
 * @author Pablo Gomez-Abajo - Wodel editor validator.
 * 
 * Validates the Wodel code.
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */


class WodelValidator extends AbstractWodelValidator {
//	public static final String INVALID_NAME = "invalidName";
//
//	@Check
//	public void checkGreetingStartsWithCapital(Greeting greeting) {
//		if (!Character.isUpperCase(greeting.getName().charAt(0))) {
//			warning("Name should start with a capital",
//					WodelPackage.Literals.GREETING__NAME,
//					INVALID_NAME);
//		}
//	}
    public static val INVALID_NAME = 'invalidName'
    public static val INVALID_METAMODEL = 'invalidMetamodel'
    public static val INVALID_MODEL = 'invalidModel'
    public static val INVALID_UNSET = 'invalidUnset'
    public static val INVALID_SWAP = 'invalidSwap'
    public static val INVALID_COPY = 'invalidCopy'
    public static val INVALID_TYPE = 'invalidType'
    public static val WARNING_MODIFY_SOURCE = 'warningModifySource'
    public static val INVALID_EXPRESSION = 'invalidExpression'
    public static val INVALID_REVERSE = 'invalidReverse'
    List<EPackage> packages
    String lastMetamodel = '' 
    
    @Check
    def checkProgramModel(Program p) {
    	if (!p.source.path.endsWith('/')) {
    	/*if (p.source.multiple == false) {*/
    		if (! ModelManager.checkModel(p.source.path))
    	   		error("Cannot find model"+p.source.path, null, INVALID_MODEL);
   	    }
   	    if (p.source.path.endsWith('/')) {
   	    /*if (p.source.multiple == true) {*/
   	    	val File[] files = new File(p.source.path).listFiles();
        	for (file : files) {
				if (file.isFile() == true) {
					if (file.getPath().endsWith(".model") == true) {
						if (! ModelManager.checkModel(file.getPath()))
    	   					error("Cannot find model " + file.getPath(), null, INVALID_MODEL);
					}
				}
			}
   	    }
    	/*if (this.packages != null && this.packages.size()>0)
	    	try {
				this.model = ModelManager.loadModel(this.packages, p.model)			
			} catch ( ModelNotFoundException e ) {
				error(e.toString(), null, INVALID_MODEL)
			}*/
    }
    
    @Check // checks the meta-model
    def checkProgramMetaModel(Program p) {
    	var String path = p.metamodel;
    	try {    		    		
    		if (!lastMetamodel.equals(path)) {
    			lastMetamodel = path
				packages = ModelManager.loadMetaModel(path)				
			}			
		} catch ( MetaModelNotFoundException e ) {
			error(e.toString(), null, INVALID_METAMODEL)
		}
//		var String path = ModelManager.getWorkspaceAbsolutePath+'/'+manager.WodelContext.getProject + '/'
//		try {    		    		
//    		if (!lastMetamodel.equals(path + p.metamodel.substring(1, p.metamodel.length-1))) {
//    			lastMetamodel = path + p.metamodel.substring(1, p.metamodel.length-1)
//				packages = ModelManager.loadMetaModel(path + p.metamodel.substring(1, p.metamodel.length-1))				
//			}			
//		} catch ( MetaModelNotFoundException e ) {
//			error(e.toString(), null, INVALID_METAMODEL)
//		}
    }
    
    @Check //Init: CreateObjectMutator
    def checkCreateObjectMutatorMin(CreateObjectMutator com) {
    	if((com as Mutator).min > (com as Mutator).max){
    		error('The min value must me lower or equal than the max value.', null, INVALID_NAME)    	
    	}
    	var EList<AttributeSet> attributes = com.getAttributes();
    	for (AttributeSet attset : attributes) {
    		if (attset instanceof AttributeUnset) {
    			var EAttribute att = attset.getAttribute().get(0);
    			if ((att.isUnsettable() == false) && (att.getLowerBound() != 0)) {
    				error('The attribute is not unsettable and the lower bound is not 0', null, INVALID_UNSET);
    			}
    			if (att.isUnsettable() == false) {
    				error('The attribute is not unsettable', null, INVALID_UNSET);
    			}
    			if (att.getLowerBound() != 0) {
    				error('The lower bound is not 0', null, INVALID_UNSET);
    			}
    		}
    		if (attset instanceof AttributeSwap) {
    			var EAttribute att0 = attset.getAttribute().get(0);
    			var EAttribute att1 = attset.getAttribute().get(1);
    			
    			if (att0.getEType().getInstanceClass() != att1.getEType().getInstanceClass()) {
    				error('The attributes are not of the same type', null, INVALID_SWAP);
    			}
    		}
    		
    		if (attset instanceof AttributeCopy) {
    			var EAttribute att0 = attset.getAttribute().get(0);
    			var EAttribute att1 = attset.getAttribute().get(1);
    			
    			if (att0.getEType().getInstanceClass() != att1.getEType().getInstanceClass()) {
    				error('The attributes are not of the same type', null, INVALID_COPY);
    			}
    		}
    		if (attset instanceof AttributeScalar) {
    			var EAttribute att0 = attset.getAttribute().get(0);
    			var AttributeType att_type = attset.getValue();
    			if (att_type instanceof IntegerType) {
    				if (!att0.getEType().getInstanceClassName().equals("int") && (!att0.getEType().getInstanceClassName().equals("java.lang.Integer"))) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof BooleanType) {
    				if (!att0.getEType().getInstanceClassName().equals("boolean") && (!att0.getEType().getInstanceClassName().equals("java.lang.Boolean"))) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof StringType) {
    				if (!att0.getEType().getInstanceClassName().equals("java.lang.String")) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof DoubleType) {
    				if (!att0.getEType().getInstanceClassName().equals("double") && (!att0.getEType().getInstanceClassName().equals("java.lang.Double"))) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof ListStringType) {
    				if (!att0.getEType().getInstanceClassName().equals("java.lang.String")) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    		}
    	}
    }
    
    @Check
    def checkModifyInformationMutatorUnset(ModifyInformationMutator com) {
    	var EList<AttributeSet> attributes = com.getAttributes();
    	for (AttributeSet attset : attributes) {
    		if (attset instanceof AttributeUnset) {
    			var EAttribute att = attset.getAttribute().get(0);
    			if ((att.isUnsettable() == false) && (att.getLowerBound() != 0)) {
    				error('The attribute is not unsettable and the lower bound is not 0', null, INVALID_UNSET);
    			}
    			if (att.isUnsettable() == false) {
    				error('The attribute is not unsettable', null, INVALID_UNSET);
    			}
    			if (att.getLowerBound() != 0) {
    				error('The lower bound is not 0', null, INVALID_UNSET);
    			}
    		}
    		if (attset instanceof AttributeSwap) {
    			var EAttribute att0 = attset.getAttribute().get(0);
    			var EAttribute att1 = attset.getAttribute().get(1);
    			
    			if (att0.getEType().getInstanceClass() != att1.getEType().getInstanceClass()) {
    				error('The attributes are not of the same type', null, INVALID_SWAP);
    			}
    		}
    		
    		if (attset instanceof AttributeCopy) {
    			var EAttribute att0 = attset.getAttribute().get(0);
    			var EAttribute att1 = attset.getAttribute().get(1);
    			
    			if (att0.getEType().getInstanceClass() != att1.getEType().getInstanceClass()) {
    				error('The attributes are not of the same type', null, INVALID_COPY);
    			}
    		}
    		if (attset instanceof AttributeScalar) {
    			var EAttribute att0 = attset.getAttribute().get(0);
    			var AttributeType att_type = attset.getValue();
    			if (att_type instanceof IntegerType) {
    				if (!att0.getEType().getInstanceClassName().equals("int") && (!att0.getEType().getInstanceClassName().equals("java.lang.Integer"))) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof BooleanType) {
    				var String className = att0.getEType().getInstanceClassName()
    				if (!att0.getEType().getInstanceClassName().equals("boolean") && (!att0.getEType().getInstanceClassName().equals("java.lang.Boolean"))) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof StringType) {
    				if (!att0.getEType().getInstanceClassName().equals("java.lang.String")) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof DoubleType) {
    				if (!att0.getEType().getInstanceClassName().equals("double") && (!att0.getEType().getInstanceClassName().equals("java.lang.Double"))) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    			if (att_type instanceof ListStringType) {
    				if (!att0.getEType().getInstanceClassName().equals("java.lang.String")) {
    					error('The attributes are not of the same type', null, INVALID_TYPE);
    				}
    			}
    		}
    	}
    }

//    @Check
//    def checkModifySourceReference(ModifySourceReferenceMutator com) {
//    	var EReference ref = com.getRefType();
//    	if (ref != null) {
//    		if (ref.getLowerBound() != 0) {
//    			warning('The lower bound of the source reference is not 0', null, WARNING_MODIFY_SOURCE)
//    		}
//    	}
//    }
    
//    @Check //Init: CreateObjectMutator
//    def checkExpression(Expression exp) {
//   		if (exp.operator != null) {
//   			if (exp.operator.size > 0) {
//   				if (exp.operator.get(0) != null) {
//   					if (exp.operator.get(0).type.equals('and')) {
//    					for (BinaryOperator op : exp.operator) {
//   							if (op.type.equals('and') != true) {
//	    						error('Wodel is not able to process this mixture of conjunctions "and" and disjunctions "or"', null, INVALID_EXPRESSION);
//    						}
//   						}
//   					}
//   					if (exp.operator.get(0).type.equals('or')) {
//    					for (BinaryOperator op : exp.operator) {
//    						if (op.type.equals('or') != true) {
//   								error('Wodel is not able to process this mixture of conjunctions "and" and disjunctions "or"', null, INVALID_EXPRESSION);
//    						}
//   						}
//   					}
//   				}
//   			}
//   		}
//    }
    
    @Check //AttributeSet
    def checkAttributeSet(AttributeSet attset) {
    	if (attset instanceof AttributeReverse) {
    		if (!(attset.attribute.get(0).getEType().getInstanceClassName().equals('boolean'))) {
    			error('The reverse operator is only valid for boolean arguments, not for ' + attset.attribute.get(0).getEType().getInstanceClassName(), null, INVALID_REVERSE);
    		}
    	}
    }
    
//    @Check //Init: CreateObjectMutator
//    def checkCreateObjectMutatorInit(CreateObjectMutator com) {
//    	if(com.eContainer instanceof CompositeMutator){
//			env = com.eContainer.eContainer as MutatorEnvironment
//		}
//		else{
//			env = com.eContainer as MutatorEnvironment			
//		}
//		
//		definition = env.definition
//		try {
//			packages = ModelManager.loadMetaModel(definition.metamodel)			
//		} catch ( MetaModelNotFoundException e ) {
//			error(e.toString(), null, INVALID_METAMODEL)
//		}
//		if(definition instanceof Program){
//			try {
//				model = ModelManager.loadModel(packages, (definition as Program).model)
//			} catch ( ModelNotFoundException e ) {
//				error(e.toString(), null, INVALID_MODEL)
//			}
//			
//		}
//		else{
//			model = null			
//		}	
//    	
//    }
//    
//    @Check //Type: CreateObjectMutator
//	def checkCreateObjectMutatorType(CreateObjectMutator com) {	
//		if(ModelManager.getObjectOfType(com.type.name, packages)==null){
//			warning('1 What you want to create does not exist.', null, INVALID_NAME)
//		}
//		else if(model!=null && ModelManager.getRoot(model).eClass.getName.equals(com.type.name)){
//			warning('2 You are not allowed to create a root object.', null, INVALID_NAME)
//		}
//	}
//	
//	@Check //Reference: CreateObjectMutator
//	def checkCreateObjectMutatorReference(CreateObjectMutator com) {
//		//RandomType
//		if(com.container instanceof RandomTypeSelection){
//			val RandomTypeSelection rts = com.container as RandomTypeSelection					
//
//			if (ModelManager.getObjectsOfType(rts.type.name, model)!=null){
//				val List<EObject> objects = ModelManager.getObjectsOfType(rts.type.name, model)
//				if (objects!=null){
//					val EObject cont = objects.get(0)
//					if(com.refType!=null){
//						//The reference does not exist in the container
//						if(ModelManager.getReferenceByName(com.refType.name, cont)==null){
//							warning('5 The container does not have this reference.', null, INVALID_NAME)
//						}
//						//The reference points to a different object
//						if(!ModelManager.getReferenceByName(com.refType.name, cont).getEType().getName().equals(com.type.name)){
//							warning('6 The reference cannot contain the created object.', null, INVALID_NAME)
//					    }
//					}	
//				}				
//			}
//		}
//		//SpecificObject from command
//		else if(com.container instanceof SpecificObjectSelection){
//			if((com.container as SpecificObjectSelection).objSel instanceof CreateObjectMutator){
//				if (ModelManager.getObjectsOfType(((com.container as SpecificObjectSelection).objSel as CreateObjectMutator).type.name, model)!=null){
//					val EObject cont = ModelManager.getObjectsOfType(((com.container as SpecificObjectSelection).objSel as CreateObjectMutator).type.name, model).get(0)
//					if(com.refType!=null){
//						//The reference does not exist in the container
//						if(ModelManager.getReferenceByName(com.refType.name, cont)==null){
//							warning('9 The container does not have this reference.', null, INVALID_NAME)
//						}
//						//The reference points to a different object
//						if(!ModelManager.getReferenceByName(com.refType.name, cont).getEType().getName().equals(com.type.name)){
//							warning('10 The reference cannot contain the created object.', null, INVALID_NAME)
//						}	
//					}				
//				}
//			}
//			//TODO else if((com.container as SpecificObjectSelection).objSel instanceof ModifyInformationmutator){}
//		}
//	}

//	@Check //Container: CreateObjectMutator
//	def checkCreateObjectMutatorGrammar(CreateObjectMutator com) {	
//		val ArrayList<EObject> parObj = ModelManager.getParentObjects(model, com.type.name)
//		val ArrayList<String> parents = new ArrayList<String>()
//		for(EObject o : parObj){
//			parents.add(o.eClass.getName())
//		}
//			
//		if(com.container instanceof RandomTypeSelection){
//			val RandomTypeSelection rts = com.container as RandomTypeSelection			
//			
//			//The container does not exist
//			if(ModelManager.getObjectOfType(com.type.name, packages)==null){
//				warning('3 The container does not exist.', null, INVALID_NAME)
//			}
//			//Cannot contain
//			if(!parents.contains(rts.type.name)){
//				warning('4 The container cannot contain the new object.', null, INVALID_NAME)
//			}						
//		}
//		else if(com.container instanceof SpecificObjectSelection){
//			if((com.container as SpecificObjectSelection).objSel instanceof CreateObjectMutator){
//				//The container does not exist
//				if(ModelManager.getObjectOfType(((com.container as SpecificObjectSelection).objSel as CreateObjectMutator).type.name, packages)==null){
//					warning('7 The container does not exist.', null, INVALID_NAME)
//				}
//				//Cannot contain
//				if(!parents.contains(((com.container as SpecificObjectSelection).objSel as CreateObjectMutator).type.name)){
//					warning('8 The container cannot contain the new object.', null, INVALID_NAME)
//				}								
//			}
//			//TODO else if((com.container as SpecificObjectSelection).objSel instanceof ModifyInformationmutator){}
//		}
//	}

	
}