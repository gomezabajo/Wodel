package wodel.syntactic.comparison.emf.run;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.syntactic.comparison.run.SyntacticComparison;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;

public class EMFComparison extends SyntacticComparison {
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "EMF model comparison";
	}
	
	@Override
	public String getURI() {
		return "";
	}

	@Override
	public boolean doCompare(String metamodel, String model1, String model2, IProject project, Class<?> cls) {
		boolean isRepeated = false;
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel, cls);
			Resource resource1 = ModelManager.loadModel(packages, model1);
			Resource resource2 = ModelManager.loadModel(packages, model2);
			isRepeated = ModelManager.compareModels(resource1, resource2);
			try {
				resource2.unload();
				resource1.unload();
			} catch (Exception e) {
			}
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
