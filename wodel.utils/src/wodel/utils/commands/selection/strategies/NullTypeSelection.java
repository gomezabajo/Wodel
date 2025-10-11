package wodel.utils.commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

public class NullTypeSelection extends NullSelection {

	public NullTypeSelection(List<EPackage> metaModel, Resource model) {
		super(metaModel, model);
		// TODO Auto-generated constructor stub
	}
	
	public NullTypeSelection(List<EPackage> metaModel, List<Resource> models) {
		super(metaModel, models);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public EObject getObject() {
		return null;
	}
	
	@Override
	public List<EObject> getObjects() {
		List<EObject> l = new ArrayList<EObject>();
		return l;
	}
}
