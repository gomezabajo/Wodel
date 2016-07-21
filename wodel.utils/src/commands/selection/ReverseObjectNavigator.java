package commands.selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero
 * ReverseObjectNavigator navigates backward the references
 */
public class ReverseObjectNavigator extends ObjectNavigator{
	
	/**
	 * @param metaModel
	 * @param model
	 * @param reference
	 * @param object
	 * Normal constructor
	 */
	public ReverseObjectNavigator(ArrayList<EPackage> metaModel, Resource model,
			String reference, EObject object) {
		super(metaModel, model, reference, object);
	}
	
	@Override
	public EObject getObject() {
		
		EObject containment = this.getObject();
		EObject container = null;
		
		Iterator<EObject> it = this.getModel().getAllContents();
		while(it.hasNext()){
			EObject o = it.next();
			//If the object is contained in it
			for(EObject objs : o.eContents()){
				if(containment.equals(objs)){
					container = o;
				}
			}			
		}
		return container;
	}
	
	//@Override
	//public boolean sameType(EClassifier c) throws ReferenceNonExistingException {
	//	if(c.getInstanceClassName().equals(this.getObject().eClass().getInstanceClassName())) return true;
	//	return false;
	//}
}
