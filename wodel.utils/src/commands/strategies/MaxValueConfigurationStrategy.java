package commands.strategies;

import java.util.List;

import manager.ModelManager;

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
		return null;
	}

	public Object getValue(EObject object){
		if (attribute.getEType().getName().equals("EInt")) {
			return intValue;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			return doubleValue;
		}
		return null;
	}
}
