package wodel.utils.commands.strategies;

import java.util.List;

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
 * MinValueConfigurationStrategy gets the minimum of the numeric value
 * 
 */

public class MinValueConfigurationStrategy extends AttributeConfigurationStrategy {
	
	private int intValue = 0;
	private double doubleValue = 0;
	private EAttribute attribute = null;

	public MinValueConfigurationStrategy(List<EPackage> packages, Resource model, String className, String attName) {
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
			int min = Integer.MAX_VALUE;
			for (EObject candidate : candidates) {
				int value = ModelManager.getIntAttribute(attName, candidate);
				if (min > value) {
					min = value;
				}
			}
			intValue = min;
		}
		if (attribute.getEType().getName().equals("EDouble")) {
			double min = Double.MAX_VALUE;
			for (EObject candidate : candidates) {
				double value = ModelManager.getDoubleAttribute(attName, candidate);
				if (min > value) {
					min = value;
				}
			}
			doubleValue = min;
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
		return false;
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
