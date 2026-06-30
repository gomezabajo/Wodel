package efinder.core.management;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An Ecore meta-model
 * 
 * @author jesus
 *
 */
public class EcoreMetamodel {

	private static final EcoreMetamodel ECORE = new EcoreMetamodel(EcorePackage.eINSTANCE);
	
	private final @NonNull List<? extends EPackage> packages; 
		
	public EcoreMetamodel(@NonNull Collection<? extends EPackage> packages) {
		this.packages = new ArrayList<EPackage>(packages);
	}

	@NonNull
	public List<? extends EPackage> getPackages() {
		return packages;
	}
	
	public EcoreMetamodel(@NonNull EPackage single) {
		this(Collections.singletonList(single));
	}

	@Nullable
	public EClass getEClass(@NonNull String type) {
		for (EPackage ePackage : packages) {
			EClassifier c = ePackage.getEClassifier(type);
			if (c instanceof EClass)
				return (EClass) c;
		}
		return null;
	}
}
