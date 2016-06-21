package commands.selection.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import exceptions.ReferenceNonExistingException;

public class OtherTypeSelection extends OtherSelection {
	/**
	 * Object type
	 */
	private String type;
	private Object obj;
	
	/**
	 * @param metaModel
	 * @param model
	 * @param type
	 * Normal constructor
	 */
	public OtherTypeSelection(ArrayList<EPackage> metaModel, Resource model, String type, Object obj){
		super(metaModel, model);
		this.type = type;
		this.obj = obj;
	}

	@Override
	public EObject getObject() {
		List<EObject> l = ModelManager.getObjectsOfType(type, this.getModel());
		l.remove(obj);
		if(l==null || l.size()==0) return null;
		return l.get(ModelManager.getRandomIndex(l));
	}
}
