package wodel.utils.commands.strategies;

import java.util.List;
import java.util.ArrayList;

import wodel.utils.manager.ModelManager;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * @author Pablo Gomez-Abajo
 * 
 * MaxValueConfigurationStrategy gets the maximum of the numeric value
 * 
 */

public class MaxValueConfigurationStrategy extends AttributeConfigurationStrategy {
	
	private int intValue = 0;
	private double doubleValue = 0;
	private float floatValue = 0;
	private EAttribute attribute = null;

	public MaxValueConfigurationStrategy(List<EPackage> packages, Resource model, String className, String attName) {
		super(attName);

		EClass eClass = ModelManager.getEClassByName(packages, className);
		for (EAttribute att : eClass.getEAllAttributes()) {
			if (att.getName().equals(attribute2mutate)) {
				attribute = att;
				break;
			}
		}
		
		List<EObject> candidates = ModelManager.getObjectsOfType(className, model);
		if (attribute.getEType().getName().equals("EInt")) {
			int max = Integer.MIN_VALUE;
			for (EObject candidate : candidates) {
				int value = ModelManager.getIntAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			intValue = max;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			double max = Double.MIN_VALUE;
			for (EObject candidate : candidates) {
				double value = ModelManager.getDoubleAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			doubleValue = max;
		}
		if (attribute.getEType().getName().equals("EFloat")) {
			float max = Float.MIN_VALUE;
			for (EObject candidate : candidates) {
				float value = ModelManager.getFloatAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			floatValue = max;
		}
	}

	public MaxValueConfigurationStrategy(List<EPackage> packages, List<Resource> models, String className, String attName) {
		super(attName);

		EClass eClass = ModelManager.getEClassByName(packages, className);
		for (EAttribute att : eClass.getEAllAttributes()) {
			if (att.getName().equals(attribute2mutate)) {
				attribute = att;
				break;
			}
		}
		
		List<EObject> candidates = new ArrayList<EObject>();
		for (Resource model : models) {
			candidates.addAll(ModelManager.getObjectsOfType(className, model));
		}
		if (attribute.getEType().getName().equals("EInt")) {
			int max = Integer.MIN_VALUE;
			for (EObject candidate : candidates) {
				int value = ModelManager.getIntAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			intValue = max;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			double max = Double.MIN_VALUE;
			for (EObject candidate : candidates) {
				double value = ModelManager.getDoubleAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			doubleValue = max;
		}
		if (attribute.getEType().getName().equals("EFloat")) {
			float max = Float.MIN_VALUE;
			for (EObject candidate : candidates) {
				float value = ModelManager.getFloatAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			floatValue = max;
		}
	}

	public MaxValueConfigurationStrategy(List<EPackage> packages, Resource model, String className, List<EObject> candidates, String attName) {
		super(attName);

		EClass eClass = ModelManager.getEClassByName(packages, className);
		for (EAttribute att : eClass.getEAllAttributes()) {
			if (att.getName().equals(attribute2mutate)) {
				attribute = att;
				break;
			}
		}
		
		if (attribute.getEType().getName().equals("EInt")) {
			int max = Integer.MIN_VALUE;
			for (EObject candidate : candidates) {
				int value = ModelManager.getIntAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			intValue = max;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			double max = Double.MIN_VALUE;
			for (EObject candidate : candidates) {
				double value = ModelManager.getDoubleAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			doubleValue = max;
		}
		if (attribute.getEType().getName().equals("EFloat")) {
			float max = Float.MIN_VALUE;
			for (EObject candidate : candidates) {
				float value = ModelManager.getFloatAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			floatValue = max;
		}
	}

	public MaxValueConfigurationStrategy(List<EPackage> packages, List<Resource> models, String className, List<EObject> candidates, String attName) {
		super(attName);

		EClass eClass = ModelManager.getEClassByName(packages, className);
		for (EAttribute att : eClass.getEAllAttributes()) {
			if (att.getName().equals(attribute2mutate)) {
				attribute = att;
				break;
			}
		}
		
		if (attribute.getEType().getName().equals("EInt")) {
			int max = Integer.MIN_VALUE;
			for (EObject candidate : candidates) {
				int value = ModelManager.getIntAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			intValue = max;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			double max = Double.MIN_VALUE;
			for (EObject candidate : candidates) {
				double value = ModelManager.getDoubleAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			doubleValue = max;
		}
		if (attribute.getEType().getName().equals("EFloat")) {
			float max = Float.MIN_VALUE;
			for (EObject candidate : candidates) {
				float value = ModelManager.getFloatAttribute(attName, candidate);
				if (max < value) {
					max = value;
				}
			}
			floatValue = max;
		}
	}

	@Override
	public boolean sameType(EClassifier c) {
		
		if (attribute != null) {
			String eTypeName = attribute.getEType().getName();
			if (c.getName().equals(eTypeName)) {
				return true;
			}
		}
		return true;
	}
	
	public Object getValue(){
		if (attribute.getEType().getName().equals("EInt")) {
			return intValue;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			return doubleValue;
		}
		if (attribute.getEType().getName().equals("EFloat")) {
			return floatValue;
		}
		return null;
	}

	public Object getValue(EObject object){
		if (attribute.getEType().getName().equals("EInt")) {
			return intValue;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			return doubleValue;
		}
		if (attribute.getEType().getName().equals("EFloat")) {
			return floatValue;
		}
		return null;
	}
}
