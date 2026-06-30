package efinder.core.utils;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;

import efinder.core.management.EMFModel;
import efinder.core.management.EcoreMetamodel;

/**
 * Utilities related to handling EMF resources.
 * 
 * @author jesus
 *
 */
public class ResourceUtils {

	@NonNull
	public static EMFModel fromFile(@NonNull String model, @NonNull String metamodel) {
		ResourceSet rs = new ResourceSetImpl();
		Resource mm = rs.getResource(URI.createFileURI(new File(metamodel).getAbsolutePath()), true);
		EPackage pkg = (EPackage) mm.getContents().get(0);
		rs.getPackageRegistry().put(pkg.getNsURI(), pkg);
		
		Resource m = rs.getResource(URI.createFileURI(new File(model).getAbsolutePath()), true);
		
		// TODO: Handle multiple packages?
		return new EMFModel(m, new EcoreMetamodel(pkg));		 
	}
	
}
