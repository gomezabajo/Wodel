package wodel.dsls;

import wodel.dsls.WodelGenerator.ApplicationMode;
import wodel.dsls.WodelGenerator.AttributeSelectionMode;
import wodel.dsls.WodelGenerator.ClassSelectionMode;
import wodel.dsls.WodelGenerator.OperatorCoverage;
import wodel.dsls.WodelGenerator.CloningType;

public class WodelGeneratorExample {
	public static void main(String[] args) {

		WodelGenerator wodelGenerator = new WodelGenerator();
		
		wodelGenerator.setMetamodelPath("pathTo/arduino.ecore")
		              .setWodelProjectPath("pathTo/wodelProject")
		              .setCurrentPath("currentExecutionPath/")
		              .setEnvironmentPath("c:/GemocStudio")
		              .setCompilerName("GemocStudioc")
		              .setApplicationMode(ApplicationMode.EXHAUSTIVE)
		              .creationOperatorsClassMode(ClassSelectionMode.CONCRETE)
		              .creationOperatorsCoverage(OperatorCoverage.PARTIAL)
		              .cloningOperatorsType(CloningType.DEEP)
		              .cloningOperatorsCoverage(OperatorCoverage.FULL)
		              .cloningOperatorsFor("ModuleAssignment")
		              .modificationOperatorsClassMode(ClassSelectionMode.ALL)
		              .modificationOperatorsCoverage(OperatorCoverage.PARTIAL)
		              .modificationOperatorsAttributeMode(AttributeSelectionMode.INTEGER)
		              .modificationOperatorsIntRange(0, 10)
		              .generate()
		              .compile()
		              .generateMutants("inputPath/", "outputPath/");
	}
}
