package commands;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import commands.selection.strategies.ObSelectionStrategy;
import exceptions.ReferenceNonExistingException;

/**
 * @author Victor Lopez Rivero ModifySourceReferenceMutator Modify the source of
 *         references
 */
public class ModifySourceReferenceMutator extends Mutator {

	/**
	 * Original source
	 */
	private ObSelectionStrategy source;
	/**
	 * New source
	 */
	private ObSelectionStrategy newSource;
	/**
	 * Type of the reference
	 */
	private String refType;
	/**
	 * New source
	 */
	private EObject result;

	/**
	 * @param model
	 * @param metaModel
	 * @param source
	 * @param newSource
	 * @param refType
	 *            Normal constructor
	 */
	public ModifySourceReferenceMutator(Resource model,
			ArrayList<EPackage> metaModel, ObSelectionStrategy source,
			ObSelectionStrategy newSource, String refType) {
		super(model, metaModel, "SourceReferenceChanged");
		this.source = source;
		this.newSource = newSource;
		this.refType = refType;
	}

	@Override
	public Object mutate() throws ReferenceNonExistingException {
		if (this.source == null) {
			return null;
		}
		if (this.newSource == null) {
			return null;
		}
		EObject source = this.source.getObject();
		EObject newSource = this.newSource.getObject();

		// We get the specified references
		ArrayList<EStructuralFeature> refs = ModelManager
				.getAllReferencesByName(refType, this.getModel());

		if (refs == null) {
			result = null;
			return null;
		}

		// We select a random source
		if (source == null) {
			ArrayList<EObject> sources = new ArrayList<EObject>();
			for (EObject o : ModelManager.getAllObjects(this.getModel())) {
				if (ModelManager.getReferenceByName(refType, o) != null) {
					sources.add(o);
				}
			}
			// Random object
			source = sources.get(ModelManager.getRandomIndex(sources));
		}

		// We select a random new Source
		if (newSource == null) {
			ArrayList<EObject> newSources = new ArrayList<EObject>();
			for (EObject o : ModelManager.getAllObjects(this.getModel())) {
				if (ModelManager.getReferenceByName(refType, o) != null
						&& o.eClass().getName()
								.equals(source.eClass().getName())) {
					newSources.add(o);
				}
			}
			// Random object
			newSource = newSources.get(ModelManager.getRandomIndex(newSources));
		}

		if (source == null || newSource == null) {
			result = null;
			return null;
		}

		// We get the firstone (does not matter whichone)
		EStructuralFeature ref = refs.get(0);

		// Multivalued
		if (ref.getUpperBound() > 1 || ref.getUpperBound() < 0) {
			List<EObject> aux = null;
			List<EObject> aux2 = null;
			try {
				// We get the referenced objects of the old container
				aux = (List<EObject>) source.eGet(ref, true);
			} catch (Exception e) {
				result = null;
				throw new ReferenceNonExistingException("No reference '"
						+ ref.getName() + "' found in '"
						+ source.eClass().getName() + "'");
			}

			try {
				// We get the referenced objects of the new source
				aux2 = (List<EObject>) newSource.eGet(ref, true);
			} catch (Exception e) {
				result = null;
				throw new ReferenceNonExistingException("No reference "
						+ ref.getName() + " found in "
						+ newSource.eClass().getName());
			}

			// Nothing to add
			if (aux.size() == 0) {
				result = null;
				return null;
			}

			ArrayList<EObject> al = new ArrayList<EObject>();
			// We save the new referenced objects of the new container
			for (EObject o : aux) {
				al.add(o);
			}

			// We assign the objects
			aux2.addAll(al);

			result = newSource;
		}

		// Monovalued
		else {
			Object o = null;

			try {
				o = source.eGet(ref);
			} catch (Exception e) {
				result = null;
				throw new ReferenceNonExistingException("No reference "
						+ ref.getName() + " found in "
						+ source.eClass().getName());
			}

			// We override
			try {
				newSource.eSet(ref, o);
			} catch (Exception e) {
				result = null;
				throw new ReferenceNonExistingException("No reference "
						+ ref.getName() + " found in "
						+ newSource.eClass().getName());
			}

			source.eSet(ref, null);
			result = newSource;
		}
		return this.result;
	}

	// GETTERS AND SETTERS
	public EObject getSource() {
		if (source != null) {
			try {
				return source.getObject();
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public EObject getNewSource() {
		if (newSource != null) {
			try {
				return newSource.getObject();
			} catch (ReferenceNonExistingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public String getRefType() {
		return refType;
	}
	// END GETTERS AND SETTERS
}
