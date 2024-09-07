package wodel.semantic.comparison.run;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;

/**
 * @author Pablo Gomez-Abajo - Semantic equivalence extension point
 * 
 */

public abstract class SemanticComparison implements IExecutableExtension {
	
	private String seedPath;
	private Object seedCompiled;
	
	public String getSeedPath() {
		return this.seedPath;
	}
	
	public void setSeedPath(String seedPath) {
		this.seedPath = seedPath;
	}
	
	public Object getSeedCompiled() {
		return this.seedCompiled;
	}
	
	public void setSeedCompiled(Object seedCompiled) {
		this.seedCompiled = seedCompiled;
	}
	
	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	public abstract String getName();
	
	public abstract String getURI();

	public abstract boolean doCompare(List<String> metamodel, String model1, String model2, IProject project, Class<?> cls);
}
