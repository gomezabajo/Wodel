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
 * ModuleOperationConfigurationStrategy arithmetic module operation
 *  
 */

public class ModuleOperationConfigurationStrategy extends ArithmeticOperationConfigurationStrategy {
	
	private int intValue = 0;
	private EAttribute attribute = null;

	public ModuleOperationConfigurationStrategy(List<EPackage> packages, Resource model, String className, String a2m, EObject object, Object value) {
		super(a2m, object, value);
		EClass eClass = ModelManager.getEClassByName(packages, className);
		for (EAttribute att : eClass.getEAllAttributes()) {
			if (att.getName().equals(attribute2mutate)) {
				attribute = att;
				break;
			}
		}
		if (attribute.getEType().getName().equals("EInt")) {
			if (value instanceof Integer) {
				intValue = ModelManager.getIntAttribute(a2m, object) / (int) value;
			}
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
		return null;
	}
	
	public Object getValue(EObject object){
		if (attribute.getEType().getName().equals("EInt")) {
			return intValue;
		}
		return null;
	}
}
