package wodeledu.model2text.py.run;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.Py2Code;
import wodeledu.model2text.run.Model2Text;

public class PyModel2Text extends Model2Text {
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	public String getName() {
		return "Generate python code from PythonAST 3.14 model";
	}

	@Override
	public String getURI() {
		return "http://www.python.org/pythonast/3.14";
	}
	
	@Override
	public String getId() {
		return "py-code";
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
		String pycode = Py2Code.toPython(ModelManager.getRoot(resource));
		return pycode;
	}
}
