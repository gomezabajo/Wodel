package tinytools.metamodel.staticfacade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class CompileMetamodel extends BaseCompiler {
	public void compile(Resource r, Options options) throws IOException {

		ManagerWrapper managerWrapper = new ManagerWrapper(options);

		List<EPackage> packages = getAllPackages(r);
		for (EPackage ePackage : packages) {
			List<? extends EClass> classes = filter(ePackage.getEClassifiers(),
					EClass.class);
			for (EClass eClass : classes) {
				EClassWrapper wrapper = new EClassWrapper(eClass, managerWrapper, options);

				managerWrapper.addEClass(wrapper);
			}
		}

		// Generate the manager
		String managerFile = options.getBaseDir() + File.separator
				+ options.getPackagePrefix().replaceAll("\\.", "/")
				+ File.separator + options.getManagerClass() + ".java";

		String baseClassFile = options.getBaseDir() + File.separator
				+ managerWrapper.getQualifiedBaseClassName().replaceAll("\\.", "/") + ".java";
		
		String baseClassInterfaceFile = options.getBaseDir() + File.separator
				+ managerWrapper.getQualifiedBaseClassName().replaceAll("\\.", "/") + "Interface.java";
		
		String visitableInterfaceFile = options.getBaseDir() + File.separator
				+ managerWrapper.getQualifiedVisitableInterfaceName().replaceAll("\\.", "/") + ".java";

		String visitorClassFile = options.getBaseDir() + File.separator
				+ managerWrapper.getQualifiedVisitorBaseClassName().replaceAll("\\.", "/") + ".java";

		
		HashMap<String, Object> scopes = new HashMap<String, Object>();
		scopes.put("manager", managerWrapper);
		invokeTemplate("manager.mustache", scopes, createClassFile(managerFile));

		invokeTemplate("baseclass.mustache", scopes, createClassFile(baseClassFile));
		invokeTemplate("baseclass_interface.mustache", scopes, createClassFile(baseClassInterfaceFile));
		invokeTemplate("visitable.mustache", scopes, createClassFile(visitableInterfaceFile));
		invokeTemplate("visitor.mustache", scopes, createClassFile(visitorClassFile));

		// Generate the classes
		for (EClassWrapper wrapper : managerWrapper.getEClasses()) {
			HashMap<String, Object> classScopes = new HashMap<String, Object>();
			classScopes.put("manager", managerWrapper);
			classScopes.put("options", options);
			classScopes.put("class", wrapper);

			String filename = getClassWrapperFilename(options, wrapper);
			invokeTemplate("eclass.mustache", classScopes, createClassFile(filename));
			
			String ifilename = getClassWrapperInterfaceFilename(options, wrapper);
			invokeTemplate("interface.mustache", classScopes, createClassFile(ifilename));
			
		}

	}

	private String getClassWrapperFilename(Options options,
			EClassWrapper wrapper) {
		String filename = options.getBaseDir() + File.separator
				+ wrapper.getQualifiedPackageName().replaceAll("\\.", File.separator)
				+ File.separator + wrapper.getImplementationName() + ".java";
		return filename;
	}
	
	private String getClassWrapperInterfaceFilename(Options options,
			EClassWrapper wrapper) {
		String filename = options.getBaseDir() + File.separator
				+ wrapper.getQualifiedPackageName().replaceAll("\\.", File.separator)
				+ File.separator + wrapper.getName() + ".java";
		return filename;
	}	


	public static class ManagerWrapper {
		HashMap<EClass, EClassWrapper> wrappers = new HashMap<EClass, CompileMetamodel.EClassWrapper>();
		private Options options;

		public ManagerWrapper(Options options) {
			this.options = options;
		}
		
		public String getClassName() {
			return options.getManagerClass();
		}

		public Collection<EClassWrapper> getEClasses() {
			return wrappers.values();
		}

		public void addEClass(EClassWrapper wrapper) {
			this.wrappers.put(wrapper.eClass, wrapper);
		}

		public String getPackageName() {
			return options.getPackagePrefix();
		}

		public EClassWrapper find(EClass eClass) {
			if ( ! wrappers.containsKey(eClass) ) throw new IllegalStateException();
			return wrappers.get(eClass);
		}

		public String getQualifiedBaseClassName() {
			return this.getPackageName() + "." + this.getClassName() + "BaseObject";
		}
		
		public String getBaseClassName() {
			return this.getClassName() + "BaseObject";
		}

		public String getQualifiedManagerClass() {
			return this.options.getPackagePrefix() + "." + options.getManagerClass();
		}

		public String getVisitableInterfaceName() {
			return options.getManagerClass() + "Visitable";
		}

		public String getQualifiedVisitableInterfaceName() {
			return this.options.getPackagePrefix() + "." + this.getVisitableInterfaceName();
		}

		public String getVisitorBaseClassName() {
			return options.getManagerClass() + "Visitor";
		}

		public String getQualifiedVisitorBaseClassName() {
			return this.options.getPackagePrefix() + "." + this.getVisitorBaseClassName();
		}

	}

	public static class EClassWrapper {

		private EClass eClass;
		private Options options;
		private ManagerWrapper manager;

		public EClassWrapper(EClass eClass, ManagerWrapper manager, Options options) {
			this.eClass = eClass;
			this.options = options;
			this.manager = manager;
		}

		public String getBaseClass() {
			return manager.getQualifiedBaseClassName();
		}
		
		public String getManagerType() {
			return manager.getQualifiedManagerClass();
		}

		public String getName() {
			return eClass.getName();
		}
		
		public String getImplementationName() {
			return this.getName() + "Impl";
		}

		public String getInterfaceInheritanceText() {
			String text = "extends " + getBaseClass() + "Interface";
			EList<EClass> supertypes = eClass.getESuperTypes();
			for (EClass eClass : supertypes) {
				text = text + ", " + manager.find(eClass).getQualifiedPackageName() + "." + manager.find(eClass).getName();
			}
			
			if ( options.isVisitable() ) {
				text += ", " + manager.getQualifiedVisitableInterfaceName();
			}

			return text;
		}
		
		public String getClassImplementsText() {
			return this.getName();
		}
		
		public String getMetamodelPackageName() {
			return eClass.getEPackage().getName();
		}
		
		public String getQualifiedPackageName() {
			return this.options.getPackagePrefix() + "."
					+ eClass.getEPackage().getName();
		}

		public List<EFeatureWrapper> getFeatures() {
			List<EFeatureWrapper> features = new ArrayList<EFeatureWrapper>();
			for (EStructuralFeature f : eClass.getEAllStructuralFeatures()) {
				if (f instanceof EReference)
					features.add(new EReferenceWrapper(this, (EReference) f));
				else
					features.add(new EAttributeWrapper(this, (EAttribute) f));
			}
			return features;
		}

		public String getContainmentRefsNames() {
			String result = "";
			int i = 0;
			for(EReference r : eClass.getEAllReferences()) {
				if ( ! r.isContainment() ) 
					continue;
				
				result += ((i > 0) ? " , " : "") + '"' + r.getName() + '"';
				i++;
			}
			return result + "";
		}
		
		public ManagerWrapper getManager() {
			return manager;
		}
	}

	public static abstract class EFeatureWrapper<T extends EStructuralFeature> {
		protected T feature;
		protected EClassWrapper clazz;

		public EFeatureWrapper(EClassWrapper clazz, T f) {
			this.feature = f;
			this.clazz = clazz;
		}

		public String getName() {
			return feature.getName();
		}

		public String getGetterName() {
			return "get" + Character.toUpperCase(feature.getName().charAt(0))
					+ feature.getName().substring(1);
		}

		public String getSetterName() {
			String prefix = "set";
			if ( feature.isMany() ) 
				prefix = "add";
			
			return prefix + Character.toUpperCase(feature.getName().charAt(0))
					+ feature.getName().substring(1);
		}

		protected String adjustType(String type) {
			if (feature.isMany()) {
				type = "List<" + type + ">";
			}
			return type;
		}

		public abstract String getFeatureType();
		public abstract String getFeatureParameterType();
		
		public boolean isReference() {
			return false;
		}
	}

	public static class EReferenceWrapper extends EFeatureWrapper<EReference> {

		public EReferenceWrapper(EClassWrapper clazz, EReference f) {
			super(clazz, f);
		}

		@Override
		public String getFeatureParameterType() {
			EClassWrapper refType = clazz.getManager().find(feature.getEReferenceType());
			String type = refType.getQualifiedPackageName() + "."
					+ refType.getName();
			return type;
		}

		@Override
		public String getFeatureType() {
			return adjustType(getFeatureParameterType());
		}

		@Override
		public boolean isReference() {
			return true;
		}

	}

	public static class EAttributeWrapper extends EFeatureWrapper<EAttribute> {

		public EAttributeWrapper(EClassWrapper clazz, EAttribute f) {
			super(clazz, f);
		}

		@Override
		public String getFeatureParameterType() {
			String type = feature.getEAttributeType().getInstanceTypeName();
			if ( type.equals("boolean") ) type = "Boolean";
			if ( type.equals("int") ) type = "Integer";
			if ( type.equals("double") ) type = "Double";
			
			return type;
		}

		@Override
		public String getFeatureType() {
			return adjustType(getFeatureParameterType());
		}
	}

}
