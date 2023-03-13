package wodel.utils.commands.strategies;

import java.util.List;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SwapAttributeConfigurationStrategy attribute swap
 *  
 */

public class SwapAttributeConfigurationStrategy extends AttributeConfigurationStrategy {
	protected EAttribute source;
	protected EAttribute target;
	protected EObject eobj;
	protected EObject eobjatt;
	
	@Override
	public boolean sameType(EClassifier c) {
		if (EcoreUtil.equals(source.getEType(), target.getEType())) {
			return true;
		}
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
