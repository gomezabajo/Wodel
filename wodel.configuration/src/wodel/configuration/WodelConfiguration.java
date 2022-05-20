package wodel.configuration;

import wodel.runner.WodelRunnerConfiguration;

public class WodelConfiguration extends WodelRunnerConfiguration {
	
	private String inputPath = "D:\\models";
	private String outputPath = "D:\\mutants";

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
