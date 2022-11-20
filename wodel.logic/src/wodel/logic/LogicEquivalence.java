package wodel.logic;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;

import equivalence.run.Equivalence;
import exceptions.MetaModelNotFoundException;
import exceptions.ModelNotFoundException;
import manager.CircuitUtils;
import manager.CircuitUtils.LogicalCircuit;
import manager.ModelManager;

public class LogicEquivalence extends Equivalence {

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Logic Circuit Equivalence";
	}

	@Override
	public String getURI() {
		return "http://lc/1.0";
	}

	@Override
	public boolean doCompare(String metamodel, String model1, String model2, IProject project) {
		Resource resource1 = null;
		Resource resource2 = null;
		LogicalCircuit c1 = null;
		LogicalCircuit c2 = null;
		try {
			List<EPackage> packages = ModelManager.loadMetaModel(metamodel);
			resource1 = ModelManager.loadModel(packages, model1);
			resource2 = ModelManager.loadModel(packages, model2);
			c1 = CircuitUtils.convertToLC(packages, resource1);
			c2 = CircuitUtils.convertToLC(packages, resource2);
			//If they are not valid logical circuits
			if (c1 == null || c2 == null) {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using default syntactic comparison.");
				return ModelManager.compareModels(resource1, resource2);
			}
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String boolExpC1 = CircuitUtils.toBoolExp(c1);
		String boolExpC2 = CircuitUtils.toBoolExp(c2);
		return boolExpC1.equals(boolExpC2);
	}

}
