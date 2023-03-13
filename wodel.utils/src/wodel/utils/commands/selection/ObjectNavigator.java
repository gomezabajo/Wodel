package wodel.utils.commands.selection;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.commands.selection.strategies.ObSelectionStrategy;

/**
 * @author Pablo Gomez-Abajo
 * 
 * ObjectNavigator navigates through the pointed objects by a reference (in both ways)
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
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
	public ObjectNavigator(List<EPackage> metaModel, Resource model, String reference, EObject object) {
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
