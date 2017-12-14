package commands.selection;

import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * DirectObjectNavigator gives us the child object of an object given a reference
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */
public class DirectObjectNavigator extends ObjectNavigator{

	/**
	 * @param metaModel
	 * @param model
	 * @param reference
	 * @param object
	 * Normal constructor
	 */
	public DirectObjectNavigator(List<EPackage> metaModel, Resource model,
			String reference, EObject object) {
		super(metaModel, model, reference, object);
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		EObject source = this.getObject();
		
		EStructuralFeature ref = ModelManager.getReferenceByName(this.getReference(), source);
		
		//Multivalued
		if(ref.getUpperBound() < 0 || ref.getUpperBound() > 1){
			List<EObject> targets = null;
			try{
				targets = (List<EObject>) source.eGet(ref, true);
			} catch(Exception e){
				throw new ReferenceNonExistingException("No reference "+ref.getName()+ " found in "+ source.eClass().getName());
			}
			
			return targets.get(ModelManager.getRandomIndex(targets));
		}
		
		//Monovalued
		else{
			EObject target = null;
			try{
				target = (EObject) source.eGet(ref, true);
			}catch(Exception e){
				throw new ReferenceNonExistingException("No reference "+ref.getName()+ " found in "+ source.eClass().getName());
			}
			
			return target;
		}		
	}

}
