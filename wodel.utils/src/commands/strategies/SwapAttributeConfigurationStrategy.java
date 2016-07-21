package commands.strategies;

import java.util.List;

import manager.ModelManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class SwapAttributeConfigurationStrategy extends AttributeConfigurationStrategy {
	/**
	 * @param value
	 * Normal constructor
	 */
	protected EAttribute source;
	protected EAttribute target;
	protected EObject eobj;
	protected EObject eobjatt;
	
	@Override
	public boolean sameType(EClassifier c) {
		Object src = eobj.eGet(source);
		Object tar = eobj.eGet(target);
		//System.out.println("c: " + c.getInstanceClassName().toLowerCase() + ", source: " + src.getClass().getSimpleName().toLowerCase() + ", target:" + tar.getClass().getSimpleName().toLowerCase());
		if ((c.getInstanceClassName().toLowerCase().equals(src.getClass().getSimpleName().toLowerCase())) && (c.getInstanceClassName().toLowerCase().equals(tar.getClass().getSimpleName().toLowerCase()))) {
			return true;
		}
		//System.out.println("c: " + c.getInstanceClass().toString() + ", source: " + src.getClass().toString() + ", target:" + tar.getClass().toString());
		//if ((c.getInstanceClass() == src.getClass()) && (c.getInstanceClass() == tar.getClass())) {
		//	return true;
		//}
		return false;
	}

	public SwapAttributeConfigurationStrategy(EObject o, String target, String source) {
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
		eobj = EcoreUtil.copy(o);
		eobjatt = EcoreUtil.copy(o);
		
		o.eSet(this.target, eobj.eGet(this.source));
		o.eSet(this.source, eobj.eGet(this.target));
		

	}
	
	public SwapAttributeConfigurationStrategy(EObject obj_tar, String src_name, String target, String source, Resource model) {
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
		eobj = EcoreUtil.copy(obj_src);
		eobjatt = EcoreUtil.copy(obj_tar);
		
		obj_src.eSet(this.source, obj_tar.eGet(this.target));
		obj_tar.eSet(this.target, eobj.eGet(this.source));

		
	}

	public SwapAttributeConfigurationStrategy(EObject obj_tar, EObject obj_src, String target, String source) {
		super("");
		for (EAttribute a : obj_src.eClass().getEAllAttributes()) {
			if (a.getName().equals(source)) {
				System.out.println("SOURCE: " + source + ", VALUE: " + obj_src.eGet(a));
				this.source = a;
				break;
			}
		}
		for (EAttribute a : obj_tar.eClass().getEAllAttributes()) {
			if (a.getName().equals(target)) {
				System.out.println("TARGET: " + target + ", VALUE: " + obj_tar.eGet(a));
				this.target = a;
				break;
			}
		}
		eobj = EcoreUtil.copy(obj_src);
		eobjatt = EcoreUtil.copy(obj_tar);
		
		obj_src.eSet(this.source, obj_tar.eGet(this.target));
		obj_tar.eSet(this.target, eobj.eGet(this.source));
		
	}

	
	public Object getValue(EObject o) {
		return o.eGet(target);
	}
	
	public Object getPrevious() {
		return eobjatt.eGet(target);
	}
	
	public EObject getOtherObject() {
		return eobj;
	}
	
	public EObject getAttObject() {
		return eobjatt;
	}
}
