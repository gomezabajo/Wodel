package wodel.utils.commands.strategies;

import java.util.List;

import wodel.utils.manager.EMFCopier;
import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * @author Pablo Gomez-Abajo
 * 
 * CopyReferenceConfigurationStrategy copies a reference value
 * to the given reference
 *  
 */

public class CopyReferenceConfigurationStrategy extends	ReferenceConfigurationStrategy{

	/**
	 * @param value
	 * Normal constructor
	 */
	protected EReference source;
	protected EReference target;
	protected EObject obj;
	protected EObject eobjsrc;
	protected EObject eobjtar;
	protected EObject othereobjsrc;
	protected String othereobjsrcname;
	protected EObject othereobjtar;
	protected String othereobjtarname;
	
	@Override
	public boolean sameType() {
		if (EcoreUtil.equals(source.getEReferenceType(), target.getEReferenceType())) {
			return true;
		}
		return false;
	}

	public CopyReferenceConfigurationStrategy(EObject o, String targetName, String sourceName) {
		super("");
		for (EReference a : o.eClass().getEAllReferences()) {
			if (a.getName().equals(sourceName)) {
				this.source = a;
				break;
			}
		}
		for (EReference a : o.eClass().getEAllReferences()) {
			if (a.getName().equals(targetName)) {
				this.target = a;
				break;
			}
		}
		
		for (EReference r : ModelManager.getReferences(o)) {
			if (r.getName().equals(sourceName)) {
				continue;
			}
			if (EcoreUtil.equals(r.getEReferenceType(), this.source)) {
				othereobjsrc = (EObject) o.eGet(r, true);
				othereobjsrcname = r.getName();
			}
		}
				
		for (EReference r : ModelManager.getReferences(o)) {
			if (r.getName().equals(targetName)) {
				continue;
			}
			if (EcoreUtil.equals(r.getEReferenceType(), this.target)) {
				othereobjtar = (EObject) o.eGet(r, true);
				othereobjtarname = r.getName();
			}
		}

		eobjsrc = EMFCopier.copy(o);
		eobjtar = EMFCopier.copy(o);
		obj = EMFCopier.copy(o);
		
		o.eSet(this.source, eobjsrc.eGet(this.target));
	}
	
	public CopyReferenceConfigurationStrategy(EObject obj_tar, String src_name, String target, String source, Resource model) {
		super("");
		//obtiene un objeto aleatorio del tipo src_name
		List<EObject> l = ModelManager.getObjectsOfType(src_name, model);
		if(l==null || l.size()==0) return;
		EObject obj_src = l.get(ModelManager.getRandomIndex(l));
		//obtiene los valores de los atributos
		for (EReference a : obj_src.eClass().getEAllReferences()) {
			if (a.getName().equals(source)) {
				this.source = a;
				break;
			}
		}
		for (EReference a : obj_tar.eClass().getEAllReferences()) {
			if (a.getName().equals(target)) {
				this.target = a;
				break;
			}
		}
		
		for (EReference r : ModelManager.getReferences(obj_src)) {
			if (r.getName().equals(source)) {
				continue;
			}
			if (EcoreUtil.equals(r.getEReferenceType(), this.source)) {
				othereobjsrc = (EObject) obj_src.eGet(r, true);
				othereobjsrcname = r.getName();
			}
		}
				
		for (EReference r : ModelManager.getReferences(obj_tar)) {
			if (r.getName().equals(target)) {
				continue;
			}
			if (EcoreUtil.equals(r.getEReferenceType(), this.target)) {
				othereobjtar = (EObject) obj_tar.eGet(r, true);
				othereobjtarname = r.getName();
			}
		}

		eobjsrc = EMFCopier.copy(obj_src);
		eobjtar = EMFCopier.copy(obj_tar);
		obj = EMFCopier.copy(obj_tar);

		obj_tar.eSet(this.target, eobjsrc.eGet(this.source));
	}

	public CopyReferenceConfigurationStrategy(EObject obj_tar, EObject obj_src, String targetName, String sourceName) {
		super("");
		for (EReference a : obj_src.eClass().getEAllReferences()) {
			if (a.getName().equals(sourceName)) {
				this.source = a;
				break;
			}
		}
		for (EReference a : obj_tar.eClass().getEAllReferences()) {
			if (a.getName().equals(targetName)) {
				this.target = a;
				break;
			}
		}
		
		for (EReference r : ModelManager.getReferences(obj_src)) {
			if (r.getName().equals(sourceName)) {
				continue;
			}
			if (EcoreUtil.equals(r.getEReferenceType(), this.source)) {
				othereobjsrc = (EObject) obj_src.eGet(r, true);
				othereobjsrcname = r.getName();
			}
		}
				
		for (EReference r : ModelManager.getReferences(obj_tar)) {
			if (r.getName().equals(targetName)) {
				continue;
			}
			if (EcoreUtil.equals(r.getEReferenceType(), this.target)) {
				othereobjtar = (EObject) obj_tar.eGet(r, true);
				othereobjtarname = r.getName();
			}
		}
		
		eobjsrc = EMFCopier.copy(obj_src);
		eobjtar = EMFCopier.copy(obj_tar);
		obj = EMFCopier.copy(obj_tar);

		obj_tar.eSet(this.target, eobjsrc.eGet(this.source));
	}

	
	public Object getValue(EObject o) {
		return o.eGet(target);
	}
	
	public Object getPrevious() {
		if (obj != null) {
			return obj.eGet(this.target);
		}
		return null;
	}
	
	public Object getNext(EObject o) {
		return o.eGet(this.target);
	}
	
	public EObject getRefObject() {
		return eobjtar;
	}
	
	public EObject getOtherSource() {
		return othereobjsrc;
	}
	
	public String getOtherSourceName() {
		return othereobjsrcname;
	}

	public EObject getOtherTarget() {
		return othereobjtar;
	}
	
	public String getOtherTargetName() {
		return othereobjtarname;
	}
}
