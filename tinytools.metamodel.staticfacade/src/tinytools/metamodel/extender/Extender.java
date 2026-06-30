package tinytools.metamodel.extender;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import tinytools.metamodel.staticfacade.BaseCompiler;

public class Extender extends BaseCompiler {
	
	private ExtenderOptions options;

	public Resource compile(Resource mm, ExtenderOptions options)
			throws IOException {
	
		this.options = options;
		
		Resource r = new XMIResourceImpl();
		List<? extends EPackage> pkgs = filter(mm.getContents(), EPackage.class);
		for (EPackage ePackage : pkgs) {
			EPackage newPkg = createExtension(ePackage);
			addElements(ePackage, newPkg);
			r.getContents().add(newPkg);
		}
		
		return r;
	}

	public void addElements(EPackage origin, EPackage target) {
		List<? extends EClass> classes = filter(origin.getEClassifiers(), EClass.class);
		for (EClass eClass : classes) {
			if ( eClass.isAbstract() )
				continue;
			
			EClass newClass = createExtension(eClass);
			target.getEClassifiers().add(newClass);
		}
		
		for(EPackage sub : origin.getESubpackages()) {
			EPackage newPkg = createExtension(sub);
			target.getESubpackages().add(newPkg);
			addElements(sub, newPkg);
		}
	}

	private EPackage createExtension(EPackage source) {
		EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
		pkg.setName(options.getPackageName(source.getName()));
		pkg.setNsPrefix(source.getNsPrefix());
		pkg.setNsURI(options.getPkgURI() + "/" + source.getName());
		return pkg;
	}

	private EClass createExtension(EClass eClass) {
		EClass newClass = EcoreFactory.eINSTANCE.createEClass();
		newClass.setName(options.getClassPrefix() + eClass.getName() + options.getClassPostfix());
		newClass.getESuperTypes().add(eClass);
		newClass.setAbstract(eClass.isAbstract());
		return newClass;
	}
}
