package commands.selection;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import commands.selection.strategies.ObSelectionStrategy;

/**
 * @author Victor Lopez Rivero
 * ObjectNavigator navigates through the pointed objects by a reference (in both ways)
 */
public abstract class ObjectNavigator extends ObSelectionStrategy{
	
	/**
	 * Type of the reference
	 */
	private String reference;
	/**
	 * Object that contains the reference or is contained by it
	 */
	private EObject object;

	/**
	 * @param metaModel
	 * @param model
	 * @param reference
	 * @param object
	 * Normal constructor
	 */
	public ObjectNavigator(ArrayList<EPackage> metaModel, Resource model, String reference, EObject object) {
		super(metaModel, model);
		this.reference = reference;
		this.object = object;
	}

	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public void setObject(EObject object) {
		this.object = object;
	}
	
	
}
