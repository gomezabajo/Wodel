package wodel.syntactic.validation.emf.run;

import java.util.List;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.ModelManager;
import wodel.syntactic.validation.run.SyntacticValidation;

public class EMFValidation extends SyntacticValidation {
	
	@Override
	public String getName() {
		return "EMF model validation";
	}
	
	@Override
	public String getURI()  {
		return "";
	}
	
	@Override
	public boolean isValid(String metamodel, String uri, Class<?> cls) {
		boolean isValid = false;
		
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel, cls);
			Resource model = ModelManager.loadModel(packages, uri);
			isValid = ModelManager.validateModel(model);
			try {
				model.unload();
			} catch (Exception e) {
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			return false;
		}
		return isValid;
	}
}
