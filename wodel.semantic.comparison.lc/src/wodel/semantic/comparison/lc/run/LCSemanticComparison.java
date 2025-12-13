package wodel.semantic.comparison.lc.run;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import wodel.semantic.comparison.run.SemanticComparison;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.manager.CircuitUtils;
import wodel.utils.manager.CircuitUtils.LogicalCircuit;
import wodel.utils.manager.ModelManager;

public class LCSemanticComparison extends SemanticComparison {

	@Override
	public String getName() {
		return "Logic circuit semantic comparison";
	}

	@Override
	public String getURI() {
		return "http://lc/1.0";
	}

	@Override
	public boolean doCompare(List<String> metamodels, String model1, String model2, IProject project, boolean[] processed, Class<?> cls) {
		Resource resource1 = null;
		Resource resource2 = null;
		model1 = model1.replace("\\\\", "/");
		model2 = model2.replace("\\\\", "/");
		String boolExpC1 = null;
		String boolExpC2 = null;
		boolean ret = false;
		try {
			System.out.println("Warning:");
			System.out.println("This comparison extension can only be used in the tester instance.");
			System.out.println("Using default semantic comparison.");
			List<EPackage> packages = ModelManager.loadMetaModels(metamodels, cls);
			if (this.getSeedPath() == null) {
				this.setSeedPath(model1);
				resource1 = ModelManager.loadModel(packages, this.getSeedPath());
				LogicalCircuit c1 = CircuitUtils.convertToLC(packages, resource1);
				boolExpC1 = CircuitUtils.toBoolExp(c1);
				if (c1 != null) {
					this.setSeedCompiled(boolExpC1);
				}
				resource1.unload();
			}
			
			boolExpC1 = this.getSeedCompiled() != null ? (String) this.getSeedCompiled() : null;
			resource2 = ModelManager.loadModel(packages, model2);
			LogicalCircuit c2 = CircuitUtils.convertToLC(packages, resource2);
			resource2.unload();
			
			//If they are not valid logical circuits
			if (boolExpC1 == null || c2 == null) {
				System.out.println("Warning:");
				System.out.println("This comparison extension can only be used in the tester instance.");
				System.out.println("Using default syntactic comparison.");
				ret = ModelManager.compareModels(resource1, resource2);
			}
			boolExpC2 = CircuitUtils.toBoolExp(c2);
			ret = boolExpC1.equals(boolExpC2);
			processed[0] = true;
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
}
