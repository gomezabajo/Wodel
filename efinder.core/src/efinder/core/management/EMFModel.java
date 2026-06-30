package efinder.core.management;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;

public class EMFModel {

	private @NonNull Resource resource;
	private @NonNull EcoreMetamodel metamodel;

	public EMFModel(@NonNull Resource resource, @NonNull EcoreMetamodel metamodel) {
		this.resource = resource;
		this.metamodel = metamodel;
	}
	
	@NonNull
	public EcoreMetamodel getMetamodel() {
		return metamodel;
	}
	
	@NonNull
	public Resource getResource() {
		return resource;
	}
	
	@NonNull
	public TreeIterator<EObject> getAllContents() {
		return resource.getAllContents();
	}
	
	@NonNull
	public Collection<EObject> getAllObjectsOf(EClass c) {
		List<EObject> result = new ArrayList<>();
		TreeIterator<EObject> it = getAllContents();
		while (it.hasNext()) {
			EObject obj = it.next();
			if (c.isInstance(obj))
				result.add(obj);
		}
		return result;
	}
}
