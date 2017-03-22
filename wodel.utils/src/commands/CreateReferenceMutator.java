package commands;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import exceptions.ObjectNoTargetableException;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * CreateReferenceMutator creates new references over the diagram. 
 */
public class CreateReferenceMutator extends Mutator {
	
	/**
	 * Source object
	 */
	private ObSelectionStrategy sourceSelection;
	/**
	 * Target object
	 */
	private ObSelectionStrategy targetSelection;
	/**
	 * Type of the reference of the source
	 */
	private String refType;
	/**
	 * New reference
	 */
	private EReference result;
	/**
	 * Modified object
	 */
	private EObject source;
	

	/**
	 * @param model
	 * @param metaModel
	 * @param sourceSelection
	 * @param targetSelection
	 * @param refType
	 * Normal constructor
	 */
	public CreateReferenceMutator(Resource model, ArrayList<EPackage> metaModel,
			ObSelectionStrategy sourceSelection, ObSelectionStrategy targetSelection, String refType){
		super(model, metaModel, "ReferenceCreated");
		this.sourceSelection = sourceSelection;
		this.targetSelection = targetSelection;
		this.refType = refType;
	}
	
	@Override
	public Object mutate() throws ReferenceNonExistingException, ObjectNoTargetableException {		

		//We select the source
		source = sourceSelection.getObject();
		//We select the target
		EObject target = targetSelection.getObject();
		//We save the referenced here
		EReference reference = null;
		//We get the new Reference
		EObject r = ModelManager.getObjectOfType(refType, this.getMetaModel());
		
		if(r==null){
			result = null;
			return null;
		}						
		
		//If an exception is thrown means that what we wrote in refType is
		//a Class name or something else in the metamodel.
		try{
			reference = (EReference) r;
		} catch(Exception e){
			result=null;
			return null;
		}
		
		//We select a random source
		if(source == null){
			ArrayList<EObject> sources = new ArrayList<EObject>();
			for(EObject o : ModelManager.getAllObjects(this.getModel())){
				if(ModelManager.getReferenceByName(refType, o)!=null){
					sources.add(o);
				}
			}
			//Random object
			source = sources.get(ModelManager.getRandomIndex(sources));
		}
				
		//We select a random new Target
		if(target == null){
			ArrayList<EObject> newTargets = new ArrayList<EObject>();
			for(EObject o : ModelManager.getAllObjects(this.getModel())){
				if(reference.getEType().getName().equals(o.eClass().getName())){
					newTargets.add(o);
				}
			}
			//Random object
			target = newTargets.get(ModelManager.getRandomIndex(newTargets));
		}
		
		if(!reference.getEType().getName().equals(target.eClass().getName())){
			result = null;
			throw new ObjectNoTargetableException("The reference '"+reference.getName()+"' cannot contain the object '"+target.eClass().getName()+"'.");
		}
		
		//Multivalued
		if(reference.getUpperBound() < 0 || reference.getUpperBound() > 1){
			List<EObject> o = null;
			
			try{
				o = (List<EObject>) source.eGet(reference, true);
			} catch(Exception e){
				result=null;
				throw new ReferenceNonExistingException("No reference "+reference.getName()+ " found in "+ source.eClass().getName());
			}
			
			// We clone the target because the addition would delete the that
			// object in its original container
			EObject clonedTarget = EcoreUtil.copy(target);
			
			// We add the reference			
			o.add(clonedTarget);		
			this.result = reference;
		}
		//Monovalued
		else{
			EObject o = null;
			try{
				o = (EObject) source.eGet(reference, true);
			} catch(Exception e){
				result=null;
				throw new ReferenceNonExistingException("No reference "+reference.getName()+ " found in "+ source.eClass().getName());
			}
			
			//If the reference is not null there is something already created
			if(o!=null){
				result = null;
				return null;
				//this.result = reference;
				//return this.result;
			}						
			source.eSet(reference, target); 
			this.result = reference;
		}
		return this.result;
	}
	//GETTERS AND SETTERS
	public EReference getReference() {
		return result;
	}
	
	public String getRefName() {
		return result.getName();
	}

	//GETTERS AND SETTERS
	public EObject getObject() {
		return source;
	}
}
