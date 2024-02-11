package wodel.utils.commands.strategies;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.manager.EMFCopier;
import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

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
		for (EReference r : o.eClass().getEAllReferences()) {
			if (r.getName().equals(source)) {
				this.source = r;
				break;
			}
		}
		for (EReference r : o.eClass().getEAllReferences()) {
			if (r.getName().equals(target)) {
				this.target = r;
				break;
			}
		}
		
		if (this.source != null) {
			if (o.eGet(this.source) != null) {
				if (EcoreUtil.equals(this.source.getEType(), (((EObject) o.eGet(this.source)).eClass()))) {
					othereobjsrc = (EObject) o.eGet(this.source, true);
					othereobjsrcname = this.source.getName();
				}
			}
		}

		if (this.target != null) {
			if (o.eGet(this.target) != null) {
				if (EcoreUtil.equals(this.target.getEType(), (((EObject) o.eGet(this.target)).eClass()))) {
					othereobjtar = (EObject) o.eGet(this.target, true);
					othereobjtarname = this.target.getName();
				}
			}
		}

		if (othereobjsrc != null) {
			eobjsrc = EMFCopier.copy(othereobjsrc);
		}
		if (othereobjtar != null) {
			eobjtar = EMFCopier.copy(othereobjtar);
		}
		
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
	
	public SwapReferenceConfigurationStrategy(EObject obj_source, String src_name, String target, String source, Resource model) {
		super("");
		//obtiene un objeto aleatorio de los objetos referidos por source y target
		Object obs = null;
		try {
			obs = ModelManager.getReferenced(source, obj_source);
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<EObject> l = new ArrayList<EObject>();
		if (obs instanceof List<?>) {
			l.addAll((List<EObject>) obs);
		}
		if (obs instanceof EObject) {
			l.add((EObject) obs);
		}
		if(l==null || l.size()==0) return;
		EObject obj_src = l.get(ModelManager.getRandomIndex(l));
		try {
			obs = ModelManager.getReferenced(target, obj_source);
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l = new ArrayList<EObject>();
		if (obs instanceof List<?>) {
			l.addAll((List<EObject>) obs);
		}
		if (obs instanceof EObject) {
			l.add((EObject) obs);
		}
		if(l==null || l.size()==0) return;
		EObject obj_tar = l.get(ModelManager.getRandomIndex(l));
		//obtiene los valores de los atributos
		for (EReference r : obj_source.eClass().getEAllReferences()) {
			if (r.getName().equals(source)) {
				this.source = r;
				break;
			}
		}
		for (EReference r : obj_source.eClass().getEAllReferences()) {
			if (r.getName().equals(target)) {
				this.target = r;
				break;
			}
		}
		
		if (this.source != null) {
			if (obj_source.eGet(this.source) != null) {
				if (EcoreUtil.equals(this.source.getEType(), (((EObject) obj_source.eGet(this.source)).eClass()))) {
					othereobjsrc = (EObject) obj_source.eGet(this.source, true);
					othereobjsrcname = this.source.getName();
				}
			}
		}

		if (this.target != null) {
			if (obj_source.eGet(this.target) != null) {
				if (EcoreUtil.equals(this.target.getEType(), (((EObject) obj_source.eGet(this.target)).eClass()))) {
					othereobjtar = (EObject) obj_source.eGet(this.target, true);
					othereobjtarname = this.target.getName();
				}
			}
		}

		eobjsrc = EMFCopier.copy(obj_src);
		eobjtar = EMFCopier.copy(obj_tar);

		Object src = obj_source.eGet(this.source, true);
		Object tar = obj_source.eGet(this.target, true);

		obj = EMFCopier.copy(obj_source);

		try {
			if (this.target.isMany() == false && this.source.isMany() == false) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.add((EObject) src);
				ModelManager.setReference(this.source.getName(), obj_source, (EObject) tar);
				ModelManager.setReference(this.target.getName(), obj_source, tmp.get(0));
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

	public SwapReferenceConfigurationStrategy(EObject obj_target, EObject obj_source, String target, String source) {
		super("");
		//obtiene un objeto aleatorio de los objetos referidos por source y target
		Object obs = null;
		try {
			obs = ModelManager.getReferenced(source, obj_source);
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<EObject> l = new ArrayList<EObject>();
		if (obs instanceof List<?>) {
			l.addAll((List<EObject>) obs);
		}
		if (obs instanceof EObject) {
			l.add((EObject) obs);
		}
		if(l==null || l.size()==0) return;
		EObject obj_src = l.get(ModelManager.getRandomIndex(l));
		try {
			obs = ModelManager.getReferenced(target, obj_target);
		} catch (ReferenceNonExistingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l = new ArrayList<EObject>();
		if (obs instanceof List<?>) {
			l.addAll((List<EObject>) obs);
		}
		if (obs instanceof EObject) {
			l.add((EObject) obs);
		}
		if(l==null || l.size()==0) return;
		EObject obj_tar = l.get(ModelManager.getRandomIndex(l));
		//obtiene los valores de los atributos
		for (EReference r : obj_source.eClass().getEAllReferences()) {
			if (r.getName().equals(source)) {
				this.source = r;
				break;
			}
		}
		for (EReference r : obj_source.eClass().getEAllReferences()) {
			if (r.getName().equals(target)) {
				this.target = r;
				break;
			}
		}
		
		if (this.source != null) {
			if (obj_source.eGet(this.source) != null) {
				if (EcoreUtil.equals(this.source.getEType(), (((EObject) obj_source.eGet(this.source)).eClass()))) {
					othereobjsrc = (EObject) obj_source.eGet(this.source, true);
					othereobjsrcname = this.source.getName();
				}
			}
		}

		if (this.target != null) {
			if (obj_source.eGet(this.target) != null) {
				if (EcoreUtil.equals(this.target.getEType(), (((EObject) obj_source.eGet(this.target)).eClass()))) {
					othereobjtar = (EObject) obj_source.eGet(this.target, true);
					othereobjtarname = this.target.getName();
				}
			}
		}

		eobjsrc = EMFCopier.copy(obj_src);
		eobjtar = EMFCopier.copy(obj_tar);

		Object src = obj_source.eGet(this.source, true);
		Object tar = obj_source.eGet(this.target, true);

		obj = EMFCopier.copy(obj_source);

		try {
			if (this.target.isMany() == false && this.source.isMany() == false) {
				List<EObject> tmp = new ArrayList<EObject>();
				tmp.add((EObject) src);
				ModelManager.setReference(this.source.getName(), obj_source, (EObject) tar);
				ModelManager.setReference(this.target.getName(), obj_source, tmp.get(0));
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
