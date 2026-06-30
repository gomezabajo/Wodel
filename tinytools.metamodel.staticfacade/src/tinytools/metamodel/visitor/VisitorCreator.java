package tinytools.metamodel.visitor;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import tinytools.metamodel.staticfacade.BaseCompiler;

public class VisitorCreator extends BaseCompiler {
	public void compile(Resource genMM, VisitorOptions options) throws IOException {

		VisitorWrapper managerWrapper = new VisitorWrapper(options);

		List<GenPackage> packagesGen = getAllOfType(genMM, GenPackage.class);
		for (GenPackage pkg : packagesGen) {
			for (GenClass genClass : pkg.getGenClasses()) {
				
				EClassVisitor wrapper = new EClassVisitor(genClass, managerWrapper, options);
				managerWrapper.addEClass(wrapper);								
			}
		}

		if ( options.getBaseMetamodel() != null )  {
			List<GenClass> classesGen = getAllOfType(options.getBaseMetamodel(), GenClass.class);
			managerWrapper.setBaseClasses(classesGen.stream().map(c -> new EClassVisitor(c, managerWrapper, options)).collect(Collectors.toList()));
			
		}		
		
		// Generate the manager
		String managerFile = options.getBaseDir() + File.separator
				+ options.getPackagePrefix().replaceAll("\\.", "/")
				+ File.separator + options.getVisitorClass() + ".java";

		
		HashMap<String, Object> scopes = new HashMap<String, Object>();
		scopes.put("manager", managerWrapper);
		invokeTemplate("visitor.mustache", scopes, createClassFile(managerFile));

	}

	public static class VisitorWrapper extends ManagerBase {
		private VisitorOptions options;
		private List<? extends EClassVisitor> baseEClasses;

		public VisitorWrapper(VisitorOptions options2) {
			this.options = options2;
		}
		
		public void setBaseClasses(List<? extends EClassVisitor> baseEClasses) {
			this.baseEClasses = baseEClasses;
		}

		public List<? extends EClassVisitor> getBaseEClasses() {
			return baseEClasses;
		}
		
		public String getPackageName() {
			return options.getPackagePrefix();
		}
		
		public String getVisitorClassName() {
			return options.getVisitorClass();
		}
		
		public String getQualifiedPackageName() {
			return options.getPackagePrefix();
		}
		
		public boolean hasBaseClass() {
			return options.getQualifiedBaseClass() != null;			
		}
		
		public String getExtendsText() {
			return options.getQualifiedBaseClass() == null ? "" : " extends " + options.getQualifiedBaseClass();
		}
		
		public String getQualifiedBaseClass() {
			return options.getQualifiedBaseClass();
		}
		
	}
	
	
	public static class EClassVisitor extends EClassBase {

		private VisitorOptions options;
		private GenClass genClass;

		public EClassVisitor(GenClass genClass2, ManagerBase manager, VisitorOptions options) {
			super(genClass2.getEcoreClass(), manager);
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
			boolean hasMatch = false;
			for(GenFeature gf : genClass.getAllGenFeatures()) {
				if ( gf.getName().equals(f.getName()) ) {
					hasMatch = true;
					break;
				}
			}
			
			return new EReferenceVisitor(this, f, hasMatch);
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
			
			return new EAttributeVisitor(this, f, hasMatch);
		}
	
		public String createCall() {
			return genClass.getGenPackage().getQualifiedFactoryInstanceAccessor() + ".create" + eClass.getName(); 
		}

	
	}
	
	public static class EReferenceVisitor extends EReferenceBase {

		private boolean hasMatch;

		public EReferenceVisitor(EClassBase clazz, EReference f, boolean hasMatch) {
			super(clazz, f);
			this.hasMatch = hasMatch;
		}

		public boolean hasMatch() {
			return hasMatch;
		}
		
		@Override
		public String getFeatureParameterType() {
			EClassVisitor refType = (EClassVisitor) clazz.getManager().find(feature.getEReferenceType());
			String type = refType.getQualifiedPackageName() + "."
					+ refType.getName();
			return type;
		}

		@Override
		public String getFeatureType() {
			return adjustType(getFeatureParameterType());
		}
	}

	public static class EAttributeVisitor extends EAttributeBase {

		private boolean hasMatch;

		public EAttributeVisitor(EClassBase clazz, EAttribute f, boolean hasMatch) {
			super(clazz, f);
			this.hasMatch = hasMatch;
		}

		public boolean hasMatch() {
			return hasMatch;
		}
	}
}
