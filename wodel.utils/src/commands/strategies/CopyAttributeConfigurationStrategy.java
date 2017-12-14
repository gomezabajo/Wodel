package commands.strategies;

import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CopyAttributeConfigurationStrategy copies an attribute value
 * to the given attribute
 *  
 */

public class CopyAttributeConfigurationStrategy extends	AttributeConfigurationStrategy {

	protected EAttribute source;
	protected EAttribute target;
	protected EObject eobj;
	protected EObject eobjatt;
	
	@Override
	public boolean sameType(EClassifier c) {
		// checks objects are of the same type if the target object has already been created
		if (target != null) {
			return EcoreUtil.equals(source.getEType(), target.getEType());
		}
		else {
			return true;
		}
	}

	public CopyAttributeConfigurationStrategy(EObject o, String target, String source) {
		super("");
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(source)) {
				this.source = a;
				break;
			}
		}
		for (EAttribute a : o.eClass().getEAllAttributes()) {
			if (a.getName().equals(target)) {
				this.target = a;
				break;
			}
		}
		eobj = o;
		eobjatt = EcoreUtil.copy(o);
	}

	public CopyAttributeConfigurationStrategy(EObject obj_tar, String src_name, String target, String source, Resource model) {
		super("");
		//obtiene un objeto aleatorio del tipo src_name
		List<EObject> l = ModelManager.getObjectsOfType(src_name, model);
		if(l==null || l.size()==0) return;
		EObject obj_src = l.get(ModelManager.getRandomIndex(l));
		//obtiene los valores de los atributos
		for (EAttribute a : obj_src.eClass().getEAllAttributes()) {
			if (a.getName().equals(source)) {
				this.source = a;
				break;
			}
		}
		for (EAttribute a : obj_tar.eClass().getEAllAttributes()) {
			if (a.getName().equals(target)) {
				this.target = a;
				break;
			}
		}
		eobj = obj_src;
		eobjatt = EcoreUtil.copy(obj_src);
	}

	public CopyAttributeConfigurationStrategy(EObject obj_tar, EObject obj_src, String target, String source) {
		super("");
		if (obj_src != null) {
			for (EAttribute a : obj_src.eClass().getEAllAttributes()) {
				if (a.getName().equals(source)) {
					this.source = a;
					break;
				}
			}
		}
		if (obj_tar != null) {
			for (EAttribute a : obj_tar.eClass().getEAllAttributes()) {
				if (a.getName().equals(target)) {
					this.target = a;
					break;
				}
			}
		}
		eobj = obj_src;
		eobjatt = EcoreUtil.copy(obj_src);
	}

	public Object getValue(EObject o) {
		// checks if the target object has already been created
		if (target != null) {
			o.eSet(target, eobj.eGet(source));
		}
		return eobj.eGet(source);
	}
	
	public EObject getAttObject() {
		return eobjatt;
	}
}
