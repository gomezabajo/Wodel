package wodeledu.model2text.lc.run;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.CircuitUtils;
import wodel.utils.manager.ModelManager;
import wodeledu.model2text.run.Model2Text;

public class LCModel2Text extends Model2Text {

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Generate boolean expression from logic circuit";
	}

	@Override
	public String getURI() {
		return "http://lc/1.0";
	}
	
	@Override
	public String getId() {
		return "bool-exp";
	}

	@Override
	public String getText(String metamodel, String model) {
		List<EPackage> packages = null;
		Resource resource = null;
		try {
			packages = ModelManager.loadMetaModel(metamodel);
			resource = ModelManager.loadModel(packages, model);
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Resource model = ModelManager.loadModel(packages, URI.createURI("file://" + ModelManager.getModelsFolder() + "/" + fileName).toFileString());
		String booleanExpression = CircuitUtils.toBoolExp(CircuitUtils.convertToLC(packages, resource));
		return booleanExpression;
	}
}
