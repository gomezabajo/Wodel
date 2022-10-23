package commands.strategies;

import java.util.ArrayList;
import java.util.List;

import manager.EMFCopier;
import manager.ModelManager;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import exceptions.ReferenceNonExistingException;
import exceptions.WrongAttributeTypeException;

/**
 * @author Pablo Gomez-Abajo
 * 
 * SwapReferenceConfigurationStrategy reference swap
 *  
 */

public class SwapReferenceConfigurationStrategy extends ReferenceConfigurationStrategy {
	
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
		Object src = eobjsrc.eGet(source);
		Object tar = eobjsrc.eGet(target);
		if (src != null && tar != null) {
			if (src.getClass().equals(tar.getClass())) {
				return true;
			}
		}
		if (source != null && target != null) {
			if (EcoreUtil.equals(source.getEReferenceType(), target.getEReferenceType())) {
				return true;
			}
		}
		return false;
	}

	public SwapReferenceConfigurationStrategy(EObject o, String target, String source) {
		super("");
		for (EReference a : o.eClass().getEAllReferences()) {
			if (a.getName().equals(source)) {
				this.source = a;
				break;
			}
		}
		for (EReference a : o.eClass().getEAllReferences()) {
			if (a.getName().equals(target)) {
				this.target = a;
				break;
			}
		}
		
		for (EReference r : ModelManager.getReferences(o)) {
			if (r.getName().equals(source)) {
				continue;
			}
			if (r.getEType().getName().equals(((EObject) o.eGet(this.source)).eClass().getName())) {
				othereobjsrc = (EObject) o.eGet(r, true);
				othereobjsrcname = r.getName();
			}
		}
				
		for (EReference r : ModelManager.getReferences(o)) {
			if (r.getName().equals(target)) {
				continue;
			}
			if (r.getEType().getName().equals(((EObject) o.eGet(this.target)).eClass().getName())) {
				othereobjtar = (EObject) o.eGet(r, true);
				othereobjtarname = r.getName();
			}
		}
		
		eobjsrc = EMFCopier.copy(o);
		eobjtar = EMFCopier.copy(o);
		
		Object src = o.eGet(this.source, true);
		Object tar = o.eGet(this.target, true);

		obj = EMFCopier.copy(o);

		try {
			if (this.target.isMany() == false && this.source.isMany() == false) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.add((EObject) src);
				ModelManager.setReference(this.source.getName(), o, (EObject) tar);
				ModelManager.setReference(this.target.getName(), o, tmp.get(0));
			}
			if (this.target.isMany() == true && this.source.isMany() == true) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.addAll((List<EObject>) tar);
				((List<EObject>) tar).clear();
				((List<EObject>) tar).addAll((List<EObject>) src);
				((List<EObject>) src).clear();
				((List<EObject>) src).addAll(tmp);
			}
		}
		catch (ReferenceNonExistingException ex) {
		}
		catch (WrongAttributeTypeException ex) {
		}
	}
	
	public SwapReferenceConfigurationStrategy(EObject obj_tar, String src_name, String target, String source, Resource model) {
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
			if (obj_src.eGet(this.source) != null) {
				if (r.getEType().getName().equals(((EObject) obj_src.eGet(this.source)).eClass().getName())) {
					othereobjsrc = (EObject) obj_src.eGet(r, true);
					othereobjsrcname = r.getName();
				}
			}
		}
				
		for (EReference r : ModelManager.getReferences(obj_tar)) {
			if (r.getName().equals(target)) {
				continue;
			}
			if (obj_tar.eGet(this.target) != null) {
				if (r.getEType().getName().equals(((EObject) obj_tar.eGet(this.target)).eClass().getName())) {
					othereobjtar = (EObject) obj_tar.eGet(r, true);
					othereobjtarname = r.getName();
				}
			}
		}

		eobjsrc = EMFCopier.copy(obj_src);
		eobjtar = EMFCopier.copy(obj_tar);

		Object src = obj_src.eGet(this.source, true);
		Object tar = obj_tar.eGet(this.target, true);

		obj = EMFCopier.copy(obj_tar);

		try {
			if (this.target.isMany() == false && this.source.isMany() == false) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.add((EObject) src);
				ModelManager.setReference(this.source.getName(), obj_src, (EObject) tar);
				ModelManager.setReference(this.target.getName(), obj_tar, tmp.get(0));
			}
			if (this.target.isMany() == true && this.source.isMany() == true) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.addAll((List<EObject>) tar);
				((List<EObject>) tar).clear();
				((List<EObject>) tar).addAll((List<EObject>) src);
				((List<EObject>) src).clear();
				((List<EObject>) src).addAll(tmp);
			}
		}
		catch (ReferenceNonExistingException ex) {
		}
		catch (WrongAttributeTypeException ex) {
		}
	}

	public SwapReferenceConfigurationStrategy(EObject obj_tar, EObject obj_src, String target, String source) {
		super("");
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
			if (obj_src.eGet(this.source) != null) {
				Object o = obj_src.eGet(this.source);
				if (o instanceof EObject) {
					EObject eObject = (EObject) o;
					if (r.getEType().getName().equals(eObject.eClass().getName())) {
						othereobjsrc = (EObject) obj_src.eGet(r, true);
						othereobjsrcname = r.getName();
					}
				}
				if (o instanceof List<?>) {
					List<EObject> eObjects = (List<EObject>) o;
					if (r.getEType().getName().equals(eObjects.get(0).eClass().getName())) {
						othereobjsrc = ((List<EObject>) obj_src.eGet(r, true)).get(0);
						othereobjsrcname = r.getName();
					}
				}
			}
		}
				
		for (EReference r : ModelManager.getReferences(obj_tar)) {
			if (r.getName().equals(target)) {
				continue;
			}
			if (obj_tar.eGet(this.target) != null) {
				Object o = obj_src.eGet(this.target);
				if (o instanceof EObject) {
					EObject eObject = (EObject) o;
					if (r.getEType().getName().equals(eObject.eClass().getName())) {
						othereobjtar = (EObject) obj_tar.eGet(r, true);
						othereobjtarname = r.getName();
					}
				}
				if (o instanceof List<?>) {
					List<EObject> eObjects = (List<EObject>) o;
					if (r.getEType().getName().equals(eObjects.get(0).eClass().getName())) {
						othereobjtar = ((List<EObject>) obj_tar.eGet(r, true)).get(0);
						othereobjtarname = r.getName();
					}
				}
			}
		}
		
		eobjsrc = EMFCopier.copy(obj_src);
		eobjtar = EMFCopier.copy(obj_tar);

		Object src = obj_src.eGet(this.source, true);
		Object tar = obj_tar.eGet(this.target, true);

		obj = EMFCopier.copy(obj_tar);

		try {
			if (this.target.isMany() == false && this.source.isMany() == false) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.add((EObject) src);
				ModelManager.setReference(this.source.getName(), obj_src, (EObject) tar);
				ModelManager.setReference(this.target.getName(), obj_tar, tmp.get(0));
			}
			if (this.target.isMany() == true && this.source.isMany() == true) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.addAll((List<EObject>) tar);
				((List<EObject>) tar).clear();
				((List<EObject>) tar).addAll((List<EObject>) src);
				((List<EObject>) src).clear();
				((List<EObject>) src).addAll(tmp);
			}
		}
		catch (ReferenceNonExistingException ex) {
		}
		catch (WrongAttributeTypeException ex) {
		}
	}

	
	public Object getValue(EObject o) {
		return o.eGet(this.target);
	}
	
	public Object getPrevious() {
		if (obj != null) {
			return obj.eGet(this.target);
		}
		return null;
	}
	
	public Object getNext(EObject o) {
		if (o == null) {
			return null;
		}
		return o.eGet(this.target);
	}
	
	public EObject getSourceObject() {
		return eobjsrc;
	}

	public EObject getTargetObject() {
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
