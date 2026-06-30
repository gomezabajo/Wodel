package efinder.emfocl.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Preconditions;

import efinder.core.IModelFinder.Result;
import efinder.core.management.EMFModel;
import efinder.core.management.EcoreMetamodel;

public class OclTestOracle {

	private @NonNull Map<String, Object> data;

	private OclTestOracle(@NonNull Map<String, Object> data) {
		this.data = data;
	}

	public static OclTestOracle newTestOracle(@NonNull String fileName) throws IOException {
		Yaml yaml = new Yaml();
		InputStream inputStream = new FileInputStream(new File(fileName)); 
		Map<String, Object> obj = yaml.load(inputStream);
		return new OclTestOracle(obj);
	}

	public void assertResult(Result result) {
		String value = (String) data.get("status");
		if ("SAT".equalsIgnoreCase(value)) { 
			assertTrue("Expected SAT", result.isSat());
		} else if ("UNSAT".equalsIgnoreCase(value)) {
			assertTrue("Expected UNSAT", result.isUnsat());
		} else {
			throw new UnsupportedOperationException("Status " + value + " not supported.");
		}
		
		@SuppressWarnings("unchecked")
		Map<String, Object> witness = (Map<String, Object>) data.get("witness");
		if (witness != null) {
			assertWitness(witness, result);
		}
	}
	
	private void assertWitness(@NonNull Map<String, Object> expected, @NonNull Result result) {		
		EMFModel model = result.getWitness();
		EcoreMetamodel metamodel = model.getMetamodel();

		// Construct an EMF model
		ResourceSet rs = new ResourceSetImpl();
		Resource r = rs.createResource(URI.createURI("test.xmi"));
		
		Map<String, EObject> id2objects = new HashMap<String, EObject>();		
		
		for (Entry<String, Object> entry : expected.entrySet()) {
			String id = entry.getKey();
			assertFalse("Duplicated id", id2objects.containsKey(id));
			
			@SuppressWarnings("unchecked")
			Map<String, Object> slots = (Map<String, Object>) entry.getValue();
			String type = (String) slots.get("type_");
			assertNotNull("type_ property is compulsory", type);
			
			EClass c = metamodel.getEClass(type);
			assertNotNull("Class " + type + " not found", c);

			EObject newObject = EcoreUtil.create(c);			
			id2objects.put(id, newObject);
		}

		for (Entry<String, Object> entry : expected.entrySet()) {
			String id = entry.getKey();
			Map<String, Object> slots = (Map<String, Object>) entry.getValue();
			
			for (Entry<String, Object> feature : slots.entrySet()) {
				String name = feature.getKey();
				Object value = feature.getValue();
				if ("type_".equals(name))
					continue;
				
				EObject obj = id2objects.get(id);
				EClass c = obj.eClass();
				
				EStructuralFeature f = c.getEStructuralFeature(name);
				assertNotNull("Feature " + name + " not found", f);
				
				if (f instanceof EAttribute) {
					EAttribute attribute = (EAttribute) f;
					// TODO: Convert datatypes, etc. there should be a library for this
					obj.eSet(attribute,  value);
				} else if (f instanceof EReference) {
					EReference reference = (EReference) f;
					if (reference.isMany()) {
						assertTrue("Value expected to be a list", value instanceof Collection);						
						for (Object o : (Collection<Object>) value) {
							EObject target = id2objects.get(o);
							assertNotNull("Object " + o + " not found", target);
							((Collection<Object>) obj.eGet(reference)).add(target);
						}						
					} else {
						EObject target = id2objects.get(value);
						assertNotNull("Object " + value + " not found", target);
						obj.eSet(reference,  target);
					}
				}
			}
		}		
		
		for (EObject obj : id2objects.values()) {
			if (obj.eContainer() == null)
				r.getContents().add(obj);
		}
		
		try {
			r.save(new FileOutputStream("outputs/expected.xmi"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//JGraphtSubgraphFinder finder = new JGraphtSubgraphFinder();
		//boolean found = finder.findSubgraph(result.getWitness().getResource(), r);
		//assertTrue(found);
	}

		
	
}
