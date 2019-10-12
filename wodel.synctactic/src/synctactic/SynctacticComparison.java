package synctactic;

import java.util.List;

import manager.ModelManager;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import comparison.run.Comparison;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;

/**
 * @author Pablo Gomez-Abajo - Wodel synctactic comparison equivalence extension
 * 
 */

public class SynctacticComparison extends Comparison {

	@Override
	public void setInitializationData(IConfigurationElement config,
			String propertyName, Object data) throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Synctactic Comparison";
	}
	
	@Override
	public String getURI() {
		return "";
	}

	@Override
	public boolean doCompare(String metamodel, String model1, String model2, IProject project) {
		boolean isRepeated = false;
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			Resource resource1 = ModelManager.loadModel(packages, model1);
			Resource resource2 = ModelManager.loadModel(packages, model2);
			isRepeated = ModelManager.compareModels(resource1, resource2);
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isRepeated;
	}
}
