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
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import tinytools.metamodel.staticfacade.CompileMetamodel.EAttributeWrapper;
import tinytools.metamodel.staticfacade.CompileMetamodel.EClassWrapper;
import tinytools.metamodel.staticfacade.CompileMetamodel.EFeatureWrapper;
import tinytools.metamodel.staticfacade.CompileMetamodel.EReferenceWrapper;
import tinytools.metamodel.staticfacade.CompileMetamodel.ManagerWrapper;

public class BaseCompiler {
	
	protected OutputStream createClassFile(String filename) throws IOException {
		File file = new File(filename);
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			file.createNewFile();
		}
		return new FileOutputStream(file, false);
	}

	protected void invokeTemplate(String templateName,
			HashMap<String, Object> scopes, OutputStream out) {
		Writer writer = new OutputStreamWriter(out);
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile(new StringReader(
				readTemplate(templateName)), templateName);

		mustache.execute(writer, scopes);
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String readTemplate(String templateName) {
		InputStream stream = this.getClass().getResourceAsStream(templateName);
		StringBuilder inputStringBuilder = new StringBuilder();
		try {
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(stream, "UTF-8"));
			String line = bufferedReader.readLine();
			while (line != null) {
				inputStringBuilder.append(line);
				inputStringBuilder.append('\n');
				line = bufferedReader.readLine();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return inputStringBuilder.toString();
	}

	///
	
	protected List<EPackage> getAllPackages(Resource r) {
		return getAllOfType(r, EPackage.class);
	}

	protected <T> List<T> getAllOfType(Resource r, Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		TreeIterator<EObject> it = r.getAllContents();
		while (it.hasNext()) {
			EObject o = it.next();
			if (clazz.isInstance(o)) {
				list.add(clazz.cast(o));
			}
		}
		return list;
	}

	protected <T> List<? extends T> filter(EList<? extends Object> original,
			Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		Iterator<? extends Object> it = original.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			if (clazz.isInstance(o)) {
				list.add(clazz.cast(o));
			}
		}
		return list;
	}
	
	///////
	
	public static class ManagerBase {
		HashMap<EClass, EClassBase> wrappers = new HashMap<EClass, EClassBase>();

		public EClassBase find(EClass eClass) {
			if ( ! wrappers.containsKey(eClass) ) throw new IllegalStateException();
			return wrappers.get(eClass);
		}

		public void addEClass(EClassBase wrapper) {
			this.wrappers.put(wrapper.eClass, wrapper);
		}
		
		public Collection<EClassBase> getEClasses() {
			return wrappers.values();
		}

		public Collection<EClassBase> getConcreteClasses() {
			ArrayList<EClassBase> result = new ArrayList<EClassBase>();
			for(EClassBase c : wrappers.values()) {
				if ( ! c.eClass.isAbstract() && ! isJavaInstance(c.eClass) ) 
					result.add(c);
			}
			return result;				
		}
		
		public Collection<EClassBase> getJavaInstances() {
			ArrayList<EClassBase> result = new ArrayList<EClassBase>();
			for(EClassBase c : wrappers.values()) {
				if ( ! c.eClass.isAbstract() && isJavaInstance(c.eClass) ) 
					result.add(c);
			}
			return result;				
		}

		
		private boolean isJavaInstance(EClass eClass) {
			return eClass.getInstanceClassName() != null &&
					eClass.getInstanceClassName().equals("java.util.Map$Entry");
		}


	}
	
	public static abstract class EClassBase {

		protected EClass eClass;
		protected ManagerBase manager;

		public EClassBase(EClass eClass, ManagerBase manager) {
			this.eClass = eClass;
			this.manager = manager;
		}
		
		/*
		public String getBaseClass() {
			return manager.getQualifiedBaseClassName();
		}
		
		public String getManagerType() {
			return manager.getQualifiedManagerClass();
		}
		*/
		
		public String getName() {
			return eClass.getName();
		}
		
		public String getImplementationName() {
			return this.getName() + "Impl";
		}

		/*
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
		*/
		public String getClassImplementsText() {
			return this.getName();
		}
		
		public String getMetamodelPackageName() {
			return eClass.getEPackage().getName();
		}
		
		public List<EFeatureBase> getFeatures() {
			List<EFeatureBase> features = new ArrayList<EFeatureBase>();
			for (EStructuralFeature f : eClass.getEAllStructuralFeatures()) {
				if (f instanceof EReference)
					features.add(createEReference((EReference) f));
				else
					features.add(createEAttribute((EAttribute) f));
			}
			return features;
		}


		public List<EAttributeBase> getAllAttributes() {
			List<EAttributeBase> features = new ArrayList<EAttributeBase>();
			for (EStructuralFeature f : eClass.getEAllStructuralFeatures()) {
				if (f instanceof EAttribute )
					features.add(createEAttribute((EAttribute) f));
			}
			return features;
		}


		public List<EReferenceBase> getAllReferences() {
			List<EReferenceBase> features = new ArrayList<EReferenceBase>();
			for (EStructuralFeature f : eClass.getEAllStructuralFeatures()) {
				if (f instanceof EReference )
					features.add(createEReference((EReference) f));
			}
			return features;
		}

		public List<EReferenceBase> getAllContainmentReferences() {
			List<EReferenceBase> features = new ArrayList<EReferenceBase>();
			for (EStructuralFeature f : eClass.getEAllStructuralFeatures()) {
				if (f instanceof EReference && ((EReference) f).isContainment())
					features.add(createEReference((EReference) f));
			}
			return features;
		}
		
		public List<EReferenceBase> getAllCrossReferences() {
			List<EReferenceBase> features = new ArrayList<EReferenceBase>();
			for (EStructuralFeature f : eClass.getEAllStructuralFeatures()) {
				if (f instanceof EReference && ! ((EReference) f).isContainment())
					features.add(createEReference((EReference) f));
			}
			return features;
		}
		
		protected abstract EReferenceBase createEReference(EReference f);
		protected abstract EAttributeBase createEAttribute(EAttribute f);
		
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
		
		public ManagerBase getManager() {
			return manager;
		}

	}

	public static abstract class EFeatureBase<T extends EStructuralFeature> {
		protected T feature;
		protected EClassBase clazz;

		public EFeatureBase(EClassBase clazz, T f) {
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

		public boolean isMany() {
			return feature.isMany();
		}
		
		public boolean isMono() {
			return ! feature.isMany();
		}
		
		public boolean isReference() {
			return false;
		}
		
	}

	public static abstract class EReferenceBase extends EFeatureBase<EReference> {

		public EReferenceBase(EClassBase clazz, EReference f) {
			super(clazz, f);
		}

		@Override
		public boolean isReference() {
			return true;
		}

	}

	public static class EAttributeBase extends EFeatureBase<EAttribute> {

		public EAttributeBase(EClassBase clazz, EAttribute f) {
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
