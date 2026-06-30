package efinder.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.ImmutableMap;

import efinder.ir.EFMetamodel;
import efinder.ir.EFPackage;
import efinder.ir.Specification;

/**
 * Represents an IR model
 * 
 * @author jesus
 *
 */
public class EFinderModel {

	private @NonNull Specification specification;
	
	public EFinderModel(@NonNull Specification specification) {
		this.specification = specification;
	}
	
	/**
	 * Puts the current specification into the given resource.
	 *  
	 * @return The same resource given as argument
	 */
	@NonNull
	public Resource asResource(@NonNull Resource r) {
		if (specification.eResource() != null)
			throw new IllegalStateException();
		
		r.getContents().add(specification);
		return r;
	}

	@NonNull
	public Specification getSpecification() {
		return specification;
	}

	@NonNull
	public Collection<Resource> getMetamodelResources() {
		Set<Resource> resources = new HashSet<>();
		for (EFMetamodel m: getSpecification().getMetamodels()) {
			for (EFPackage r : m.getRoots()) {
				resources.add(r.getPkg().eResource());
			}
		}
		return resources;
	}
	
}
