package wodel.validation.emf;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.ModelManager;
import wodel.validation.Validation;

public class EMFValidation extends Validation {
	
	@Override
	public String getName() {
		return "EMF Model Validation";
	}
	
	@Override
	public boolean isValid(Resource model) {
		boolean isValid = true;
		
		try {
			isValid = ModelManager.validateModel(model);
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return isValid;
	}

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
	}

}
