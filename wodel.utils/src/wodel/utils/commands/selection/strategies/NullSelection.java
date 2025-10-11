package wodel.utils.commands.selection.strategies;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.ReferenceNonExistingException;

public abstract class NullSelection extends ObSelectionStrategy {

	public NullSelection(List<EPackage> metaModel, Resource model) {
		super(metaModel, model);
		// TODO Auto-generated constructor stub
	}

	public NullSelection(List<EPackage> metaModel, List<Resource> models) {
		super(metaModel, models);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EObject getObject() throws ReferenceNonExistingException {
		// TODO Auto-generated method stub
		return null;
	}

}
