package wodel.validation.emf;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EPackage;
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
	public boolean isValid(String metamodel, String uri) {
		boolean isValid = false;
		
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			Resource model = ModelManager.loadModel(packages, uri);
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
