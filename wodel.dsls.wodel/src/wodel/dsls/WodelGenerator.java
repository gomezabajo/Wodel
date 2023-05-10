package wodel.dsls;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import mutatorenvironment.MutatorEnvironment;
import wodel.utils.exceptions.MetaModelNotFoundException;

public class WodelGenerator {
	
	private List<String> creationClasses = new ArrayList<String>();
	private List<String> removalClasses = new ArrayList<String>();
	private List<String> cloningClasses = new ArrayList<String>();
	private List<String> modificationClasses = new ArrayList<String>();
	private List<String> retypingClasses = new ArrayList<String>();
	
	private int intMin = 0;
	private int intMax = 10;
	
	private int doubleMin = 0;
	private int doubleMax = 10;

	private int stringMin = 0;
	private int stringMax = 10;
	
	private String metamodelPath = "";
	private String wodelProjectPath = "";
	private String currentPath = "";
	private String environmentPath = "";
	private String compilerName = "";

	public enum ApplicationMode {
		EXHAUSTIVE,
		STOCHASTIC
	};

	public enum OperatorCoverage {
		FULL,
		PARTIAL
	};

	public enum ClassSelectionMode {
		NONE,
		ALL,
		RANDOM,
		CONCRETE,
		ABSTRACT
	};

	public enum CloningType {
		DEEP,
		SHALLOW
	};

	public enum AttributeSelectionMode {
		ALL,
		RANDOM,
		INTEGER,
		DOUBLE,
		BOOLEAN,
		STRING
	};
	
	private ApplicationMode applicationMode = ApplicationMode.EXHAUSTIVE;
	
	private OperatorCoverage creationOperatorCoverage = OperatorCoverage.FULL; 
	private OperatorCoverage removalOperatorCoverage = OperatorCoverage.FULL; 
	private OperatorCoverage cloningOperatorCoverage = OperatorCoverage.FULL; 
	private OperatorCoverage modificationOperatorCoverage = OperatorCoverage.FULL; 
	private OperatorCoverage retypingOperatorCoverage = OperatorCoverage.FULL;
	
	private CloningType cloningType = CloningType.DEEP;
	
	private ClassSelectionMode creationClassSelectionMode = ClassSelectionMode.NONE;
	private ClassSelectionMode removalClassSelectionMode = ClassSelectionMode.NONE;
	private ClassSelectionMode cloningClassSelectionMode = ClassSelectionMode.NONE;
	private ClassSelectionMode modificationClassSelectionMode = ClassSelectionMode.NONE;
	private ClassSelectionMode retypingClassSelectionMode = ClassSelectionMode.NONE;
	
	private AttributeSelectionMode attributeSelectionMode = AttributeSelectionMode.ALL;

	public WodelGenerator() {
		
	}
	
	public WodelGenerator setApplicationMode(ApplicationMode applicationMode) {
		this.applicationMode = applicationMode;
		return this;
	}
	
	public WodelGenerator setMetamodelPath(String metamodelPath) {
		this.metamodelPath = metamodelPath;
		return this;
	}

	public WodelGenerator setWodelProjectPath(String wodelProjectPath) {
		this.wodelProjectPath = wodelProjectPath;
		return this;
	}

	public WodelGenerator setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
		return this;
	}
	public WodelGenerator setEnvironmentPath(String environmentPath) {
		this.environmentPath = environmentPath;
		return this;
	}
	public WodelGenerator setCompilerName(String compilerName) {
		this.compilerName = compilerName;
		return this;
	}

	public WodelGenerator creationOperatorsFor(String... classes) {
		this.creationClasses.clear();
		this.creationClasses.addAll(Arrays.asList(classes));
		return this;
	}
	public WodelGenerator creationOperatorsCoverage(OperatorCoverage operatorCoverage) {
		this.creationOperatorCoverage = operatorCoverage;
		return this;
	}
	public WodelGenerator creationOperatorsClassMode(ClassSelectionMode classSelectionMode) {
		this.creationClassSelectionMode = classSelectionMode;
		return this;
	}
	public WodelGenerator removalOperatorsFor(String... classes) {
		this.removalClasses.clear();
		this.removalClasses.addAll(Arrays.asList(classes));
		return this;
	}
	public WodelGenerator removalOperatorsCoverage(OperatorCoverage operatorCoverage) {
		this.removalOperatorCoverage = operatorCoverage;
		return this;
	}
	public WodelGenerator removalOperatorsClassMode(ClassSelectionMode classSelectionMode) {
		this.removalClassSelectionMode = classSelectionMode;
		return this;
	}
	public WodelGenerator cloningOperatorsFor(String... classes) {
		this.cloningClasses.clear();
		this.cloningClasses.addAll(Arrays.asList(classes));
		return this;
	}
	public WodelGenerator cloningOperatorsCoverage(OperatorCoverage operatorCoverage) {
		this.cloningOperatorCoverage = operatorCoverage;
		return this;
	}
	public WodelGenerator cloningOperatorsType(CloningType cloningType) {
		this.cloningType = cloningType;
		return this;
	}
	public WodelGenerator cloningOperatorsClassMode(ClassSelectionMode classSelectionMode) {
		this.cloningClassSelectionMode = classSelectionMode;
		return this;
	}
	public WodelGenerator modificationOperatorsFor(String... classes) {
		this.modificationClasses.clear();
		this.modificationClasses.addAll(Arrays.asList(classes));
		return this;
	}
	public WodelGenerator modificationOperatorsCoverage(OperatorCoverage operatorCoverage) {
		this.modificationOperatorCoverage = operatorCoverage;
		return this;
	}
	public WodelGenerator modificationOperatorsClassMode(ClassSelectionMode classSelectionMode) {
		this.modificationClassSelectionMode = classSelectionMode;
		return this;
	}
	public WodelGenerator modificationOperatorsAttributeMode(AttributeSelectionMode attributeSelectionMode) {
		this.attributeSelectionMode = attributeSelectionMode;
		return this;
	}
	public WodelGenerator modificationOperatorsIntRange(int min, int max) {
		this.intMin = min;
		this.intMax = max;
		return this;
	}
	public WodelGenerator modificationOperatorsDoubleRange(int min, int max) {
		this.doubleMin = min;
		this.doubleMax = max;
		return this;
	}
	public WodelGenerator modificationOperatorsStringLength(int min, int max) {
		this.stringMin = min;
		this.stringMax = max;
		return this;
	}
	public WodelGenerator retypingOperatorsFor(String... classes) {
		this.retypingClasses.clear();
		this.retypingClasses.addAll(Arrays.asList(classes));
		return this;
	}
	public WodelGenerator retypingOperatorsCoverage(OperatorCoverage operatorCoverage) {
		this.retypingOperatorCoverage = operatorCoverage;
		return this;
	}
	public WodelGenerator retypingOperatorsClassMode(ClassSelectionMode classSelectionMode) {
		this.retypingClassSelectionMode = classSelectionMode;
		return this;
	}
	
	public WodelGenerator generate() {
		MutatorEnvironment wodel = WodelUtils.generateWodelProgram(metamodelPath);
		// to be completed with the new WodelUtils.methods
		try {
			WodelUtils.serializeWodelProgram(wodel, wodelProjectPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MetaModelNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

	public WodelGenerator compile() {
		WodelUtils.compileWodelProject(wodelProjectPath, environmentPath, compilerName);
		return this;
	}
	
	public WodelGenerator generateMutants(String inputPath, String outputPath) {
		WodelUtils.generateMutants(inputPath, outputPath, currentPath, wodelProjectPath, environmentPath);
		return this;
	}
}
