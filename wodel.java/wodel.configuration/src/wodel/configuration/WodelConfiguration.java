package wodel.configuration;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;

import wodel.runner.WodelRunnerConfiguration;

public class WodelConfiguration extends WodelRunnerConfiguration {
	
	private String inputPath = "D:\\models";
	private String outputPath = "D:\\mutants";

	@Override
	public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
			throws CoreException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInputPath() {
		return this.inputPath;
	}

	@Override
	public String getOutputPath() {
		// TODO Auto-generated method stub
		return this.outputPath;
	}
}
