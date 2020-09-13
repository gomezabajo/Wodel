package wodel.model2text.automata;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.DFA2Regex;
import manager.DFAUtils;
import manager.ModelManager;
import wodel.model2text.run.Model2Text;

public class AutomataModel2Text extends Model2Text {

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Generate regular expression from finite automata";
	}

	@Override
	public String getURI() {
		return "http://dfaAutomaton/1.0";
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
		return DFA2Regex.toRegExp(DFAUtils.convertToDFA(packages, resource));
	}
}
