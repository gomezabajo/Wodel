package commands;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import commands.selection.strategies.ObSelectionStrategy;
import exceptions.ReferenceNonExistingException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * RemoveReferenceMutator removes references from
 * the diagram
 *  
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

public class RemoveReferenceMutator extends Mutator {

	/**
	 * Type of the reference
	 */
	private String refType;
	/**
	 * Reference to delete
	 */
	private ObSelectionStrategy containerSelection;

	/**
	 * Reference to delete
	 */
	private EObject obj;

	/**
	 * Deleted reference
	 */
	private EReference result;
	
	/**
	 * Saved objects
	 */
	private List<EObject> saved;
	
	/**
	 * Identification
	 */
	private List<String> identification;
	
	/**
	 * URI
	 */
	private List<URI> uri;

	/**
	 * @param model
	 * @param metaModel
	 * @param containerSelection
	 * @param refType
	 *            Normal constructor
	 */
	public RemoveReferenceMutator(Resource model,
			List<EPackage> metaModel,
			ObSelectionStrategy containerSelection, String refType) {
		super(model, metaModel, "ReferenceRemoved");
		this.containerSelection = containerSelection;
		this.refType = refType;
		this.identification = new ArrayList<String>();
		this.uri = new ArrayList<URI>();
	}

	/**
	 * @param model
	 * @param metaModel
	 * @param containerSelection
	 * @param refType
	 *            Normal constructor
	 */
	public RemoveReferenceMutator(Resource model,
			List<EPackage> metaModel, EObject obj, String refType) {
		super(model, metaModel, "ReferenceRemoved");
		this.obj = obj;
		this.refType = refType;
		this.identification = new ArrayList<String>();
		this.uri = new ArrayList<URI>();
	}

	@Override
	public Object mutate() throws ReferenceNonExistingException {
		// We save the referenced here
		EObject container = null;

		if (this.obj == null) {
			if (containerSelection == null) {
				return null;
			}
			container = containerSelection.getObject();
		} else {
			container = obj;
		}
		
		saved = new ArrayList<EObject>();

		// We get the specified references
		EStructuralFeature rf = ModelManager
				.getReferenceByName(refType, container);

		if (rf == null || container == null) {
			result = null;
			return null;
		}
		// We get the firstone (does not matter whichone)
		EReference ref = (EReference) rf; //(EReference) refs.get(0);

		// Multivalued
		if (ref.getUpperBound() < 0 || ref.getUpperBound() > 1) {
			List<EObject> o = null;
			try {
				o = (List<EObject>) container.eGet(ref, true);
			}
			// The container has not that kind of reference
			catch (Exception e) {
				result = null;
				throw new ReferenceNonExistingException("No reference "
						+ ref.getName() + " found in "
						+ container.eClass().getName());
			}

			// Nothing to delete
			if (o.size() == 0) {
				result = null;
				return null;
			}
			for (EObject oo : o) {
				identification.add(EcoreUtil.getIdentification(oo));
			}
			saved.addAll(EcoreUtil.copyAll(o));

			o.clear();
			this.result = ref;
		}
		// Monovalued
		else {
			EObject o = null;
			try {
				o = (EObject) container.eGet(ref, true);
			}
			// The container has not that kind of reference
			catch (Exception e) {
				result = null;
				throw new ReferenceNonExistingException("No reference "
						+ ref.getName() + " found in "
						+ container.eClass().getName());
			}

			// Nothing to delete
			if (o == null) {
				result = null;
				return null;
			}
			saved.add(EcoreUtil.copy(container));
			container.eSet(ref, null);
			this.result = ref;
		}
		return this.result;
	}

	// GETTERS AND SETTERS
	public EReference getReference() {
		return result;
	}
	
	public String getRefName() {
		return result.getName();
	}

	// GETTERS AND SETTERS
	public List<EObject> getObjects() {
		return saved;
	}
	// END GETTERS AND SETTERS

	public List<EObject> getObjectsByID() {
		List<EObject> objects = new ArrayList<EObject>();
		for (String id : identification) {
			EObject o = ModelManager.getObjectByID(this.getModel(), id);
			if (o != null) {
				objects.add(o);
			}
		}
		return objects;
	}
	
	public List<EObject> getObjectsByURI() {
		List<EObject> objects = new ArrayList<EObject>();
		for (URI u : uri) {
			EObject o = ModelManager.getObjectByURI(this.getModel(), u);
			if (o != null) {
				objects.add(o);
			}
		}
		return objects;
	}
}
