package efinder.usemv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.tzi.use.uml.mm.MAttribute;
import org.tzi.use.uml.ocl.type.StringType;
import org.tzi.use.uml.ocl.value.Value;
import org.tzi.use.uml.sys.MLink;
import org.tzi.use.uml.sys.MObject;
import org.tzi.use.uml.sys.MSystemState;

import com.google.common.base.Preconditions;

import efinder.core.management.EMFModel;
import efinder.core.management.EcoreMetamodel;
import efinder.usemv.ir.UseMapping;
import efinder.usemv.ir.UseMapping.AssociationData;
import efinder.usemv.ir.UseMapping.AssociationEndData;
import efinder.usemv.utils.EMFUtils;

/**
 * Represents an USE model. It is based on the textual representation.
 * 
 * @author jesus
 *
 */
public class UseModel {

	private @NonNull String useSpec;
	private @NonNull EcoreMetamodel metamodel;
	private @NonNull UseMapping mapping;

	public UseModel(@NonNull String useSpec, @NonNull UseMapping mapping, @NonNull EcoreMetamodel mm) {
		this.useSpec = useSpec;
		this.mapping = mapping;
		this.metamodel = mm;
	}
	
	@NonNull
	public String getText() {
		return useSpec;
	}
	
	@NonNull
	public UseMapping getMapping() {
		return mapping;
	}
	
	/**
	 * Transforms a model into an EMF Resource
	 * @return 
	 **/	
	public EMFModel toEMF(@NonNull MSystemState state) {
		ResourceSet rs = new ResourceSetImpl();
		Resource model = rs.createResource(URI.createURI("temporary-in-memory.xmi"));		
		
		int i = 0;
		HashMap<String,EObject> eobjects  = new HashMap<String,EObject>();

//		if (metamodel.getPackages().size() != 1)
//			throw new UnsupportedOperationException("TODO: Multiple packages");
//		EPackage pkg = metamodel.getPackages().get(0);
		
		Set<MObject> useObjects = state.allObjects();
		List<EObject> emfObjects = new ArrayList<>(useObjects.size());
		
		// parse objects
		for (MObject useObject : useObjects) {
			EClass klass = (EClass) mapping.getInverseType(useObject.cls().name());
			
			if (mapping.isTemporary(klass)) 
				continue;
			
			// EObject object = createEObject(pkg, className);
			EPackage pkg = klass.getEPackage();
			EObject object = createEObject(pkg, klass.getName());
			// TODO: asignar id
			eobjects.put(useObject.name(), object);
			emfObjects.add(object);

			// parse attributes
			Map<MAttribute, Value> attributes = useObject.state(state).attributeValueMap();
			for (MAttribute attribute : attributes.keySet()) {
				if ( attribute.isDerived() )
					continue;
				
				// TODO: This probably should go through mapping to make sure that we undo name clashes solved with _
				String field = attribute.name();
				String value = trim( attributes.get(attribute).toString() );
				if (!value.equals("Undefined")) {
					String values[] = {value};
					if      (value.startsWith("Set{")) values = value.substring(4,value.length()-1).split(",");
					else if (value.startsWith("Bag{")) values = value.substring(4,value.length()-1).split(",");
					
					if  (EMFUtils.hasAttribute(object, field))
						for (String v : values) {
							if (v.equals("null"))
								continue;
							
							if (attribute.type() instanceof StringType)
								v = mapping.undoStringConstant(v);
								
							EMFUtils.setAttribute(object, field, v);
						}
					else for (String v : values) {
						if (!v.isEmpty()) {
							// EObject object2 = eobjects.get(v.substring(1));
							EObject object2 = eobjects.get(v);
							if ( object2 == null )
								throw new NullPointerException("Null object for " + v + ". Available: " + eobjects.keySet().stream().collect(Collectors.joining(", ")));
							EMFUtils.setReference(pkg, object, field, object2);
							if (EMFUtils.isContainment(object, field)) model.getContents().remove(object2);
						}
					}
				}
				// we assign a random string value
				// else EMFUtils.setAttribute(pkg, object, field, /*"s"+*/""+(i++));
			}
		}
					
		for (MLink useLink : state.allLinks()) {
			EObject object1 = eobjects.get(useLink.linkedObjects().get(0).name()); // TODO: check whether this works in general
			EObject object2 = eobjects.get(useLink.linkedObjects().get(1).name());

			if (mapping.isTemporary(object1.eClass()) || mapping.isTemporary(object2.eClass()))
				continue;
			
			EPackage pkg = object1.eClass().getEPackage();
			
			AssociationData association = mapping.getAssociationByName(useLink.association().name());
			AssociationEndData targetEnd = association.getEnd2();
			EReference target = targetEnd.getEReference();
			Preconditions.checkNotNull(target);
			
			EMFUtils.setReference(pkg, object1, target.getName(), object2);
		}

		for (EObject obj : emfObjects) {
			if (obj.eContainer() == null)
				model.getContents().add(obj);
		}
		
		return new EMFModel(model, metamodel);
	}

	@NonNull
    private EObject createEObject(@NonNull EPackage pkg, @NonNull String className) {
        EClass c = (EClass) pkg.getEClassifier(className);
        return pkg.getEFactoryInstance().create(c);
	}
	
	private String trim (String phrase) {
		while (phrase.startsWith("'")) phrase = phrase.substring(1);
		while (phrase.endsWith("'"))   phrase = phrase.substring(0, phrase.length()-1);
		return phrase;
	}

	private static boolean isContainment (EObject object, String refname) {
		return EMFUtils.hasReference(object, refname)? ((EReference) object.eClass().getEStructuralFeature(refname)).isContainment() : false;
	}	
	

}
