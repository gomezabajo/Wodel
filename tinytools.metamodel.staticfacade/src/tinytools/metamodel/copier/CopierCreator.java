package tinytools.metamodel.copier;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

import tinytools.metamodel.staticfacade.BaseCompiler;

public class CopierCreator extends BaseCompiler {
	private CopierOptions options;

	public void compile(Resource r, Resource genMM, CopierOptions options) throws IOException {
		this.options = options;
		CopierWrapper managerWrapper = new CopierWrapper(options);

		List<EPackage> packages = getAllPackages(r);
		List<GenPackage> packagesGen = getAllOfType(genMM, GenPackage.class);
		for (EPackage ePackage : packages) {
			List<? extends EClass> classes = filter(ePackage.getEClassifiers(), EClass.class);
			for (EClass eClass : classes) {
				GenClass genClass = findCorresponding(eClass, packagesGen);
				
				EClassCopier wrapper = new EClassCopier(eClass, genClass, managerWrapper, options);
				managerWrapper.addEClass(wrapper);												
			}
		}

		// Generate the manager
		String managerFile = options.getBaseDir() + File.separator
				+ options.getPackagePrefix().replaceAll("\\.", "/")
				+ File.separator + options.getCopierClass() + ".java";

		
		HashMap<String, Object> scopes = new HashMap<String, Object>();
		scopes.put("manager", managerWrapper);
		invokeTemplate("copier.mustache", scopes, createClassFile(managerFile));

	}

	private GenClass findCorresponding(EClass eClass, List<GenPackage> packagesGen) {
		for (GenPackage gp : packagesGen) {
			List<? extends GenClass> classes = filter(gp.getGenClasses(),
					GenClass.class);
			for (GenClass gen : classes) {
				if ( options.getMatcher().match(eClass.getName(), gen.getName()) ) {
					return gen;
				}
			}
		}
		throw new IllegalStateException("Not found " + eClass.getName());
	}

	public static class CopierWrapper extends ManagerBase {
		private CopierOptions options;

		public CopierWrapper(CopierOptions options2) {
			this.options = options2;
		}
		
		public String getPackageName() {
			return options.getPackagePrefix();
		}
		
		public String getCopierClassName() {
			return options.getCopierClass();
		}
		
		public String getQualifiedPackageName() {
			return options.getPackagePrefix();
		}
		
	}
	
	
	public static class EClassCopier extends EClassBase {

		private CopierOptions options;
		private GenClass genClass;

		public EClassCopier(EClass eClass, GenClass genClass2, ManagerBase manager, CopierOptions options) {
			super(eClass, manager);
			this.genClass = genClass2;
			this.options = options;
		}
		
		public String getQualifiedPackageName() {
			return genClass.getGenPackage().getQualifiedPackageName();
		}

		public String getQualifiedClassName() {
			return genClass.getQualifiedInterfaceName();
		}
		@Override
		protected EReferenceBase createEReference(EReference f) {
			GenFeature hasMatch = null;
			for(GenFeature gf : genClass.getAllGenFeatures()) {
				if ( gf.getName().equals(f.getName()) ) {
					hasMatch = gf;
					break;
				}
			}
			
			return new EReferenceCopier(this, f, hasMatch);
		}
	
		@Override
		protected EAttributeBase createEAttribute(EAttribute f) {
			boolean hasMatch = false;
			for(GenFeature gf : genClass.getAllGenFeatures()) {
				if ( gf.getName().equals(f.getName()) ) {
					hasMatch = true;
					break;
				}
			}
			
			return new EAttributeCopier(this, f, hasMatch);
		}
	
		public String defaulCreateExpression() {
			if ( genClass.isAbstract() ) {
				return "throw new UnsupportedOperationException(\"Implmented by subclass\");";
			}
			return "return " + genClass.getGenPackage().getQualifiedFactoryInstanceAccessor() + ".create" + genClass.getName() + "();"; 
		}
		
		public String getGenClassName() {
			return genClass.getName();
		}
	
	}
	
	public static class EReferenceCopier extends EReferenceBase {

		private GenFeature matchedFeature;

		public EReferenceCopier(EClassBase clazz, EReference f, GenFeature matchedFeature) {
			super(clazz, f);
			this.matchedFeature = matchedFeature;
		}

		public boolean hasMatch() {
			return matchedFeature != null;
		}
		
		@Override
		public String getFeatureParameterType() {
			EClassCopier refType = (EClassCopier) clazz.getManager().find(feature.getEReferenceType());
			String type = refType.getQualifiedPackageName() + "."
					+ refType.getName();
			return type;
		}

		public String getGenFeatureParameterType() {
			if ( matchedFeature == null)
				throw new IllegalStateException();
			String type = matchedFeature.getTypeGenClass().getQualifiedInterfaceName();
			return type;
		}

		@Override
		public String getFeatureType() {
			return adjustType(getFeatureParameterType());
		}
	}

	public static class EAttributeCopier extends EAttributeBase {

		private boolean hasMatch;

		public EAttributeCopier(EClassBase clazz, EAttribute f, boolean hasMatch) {
			super(clazz, f);
			this.hasMatch = hasMatch;
		}

		public boolean hasMatch() {
			return hasMatch;
		}
	}
}
