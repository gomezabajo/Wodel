package mutator.WodelTest4ATL;

import java.util.ArrayList;
import java.util.List;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import java.io.IOException;
import java.io.File;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.MutatorUtils;
import mutator.testATLF.testATLFStandaloneAPI;
import mutator.testATLIPE.testATLIPEStandaloneAPI;
import mutator.testATLB.testATLBStandaloneAPI;
import mutator.testATLOPE.testATLOPEStandaloneAPI;
import mutator.testATLMR.testATLMRStandaloneAPI;

public class WodelTest4ATLStandaloneAPILauncher {
	public static void createMutants(String inputFolder, String outputFolder)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		String ecoreURI = "C:/eclipse/runtime-New_configuration50/WodelTest4ATL/data/model/ATL.ecore";
		List<String> mutatorNames = new ArrayList<String>();
		mutatorNames.add("testATLF");
		mutatorNames.add("testATLIPE");
		mutatorNames.add("testATLB");
		mutatorNames.add("testATLOPE");
		mutatorNames.add("testATLMR");
		List<List<String>> operatorNames = new ArrayList<List<String>>();
		List<String> mutatorOperatorNamestestATLF = new ArrayList<String>();
		mutatorOperatorNamestestATLF.add("cf");
		mutatorOperatorNamestestATLF.add("rf");
		mutatorOperatorNamestestATLF.add("ccf");
		operatorNames.add(mutatorOperatorNamestestATLF);
		List<String> mutatorOperatorNamestestATLIPE = new ArrayList<String>();
		mutatorOperatorNamestestATLIPE.add("cipe");
		mutatorOperatorNamestestATLIPE.add("ripe");
		mutatorOperatorNamestestATLIPE.add("ccipe");
		mutatorOperatorNamestestATLIPE.add("ncipe");
		operatorNames.add(mutatorOperatorNamestestATLIPE);
		List<String> mutatorOperatorNamestestATLB = new ArrayList<String>();
		mutatorOperatorNamestestATLB.add("cb");
		mutatorOperatorNamestestATLB.add("rb");
		mutatorOperatorNamestestATLB.add("vcb");
		mutatorOperatorNamestestATLB.add("fc");
		operatorNames.add(mutatorOperatorNamestestATLB);
		List<String> mutatorOperatorNamestestATLOPE = new ArrayList<String>();
		mutatorOperatorNamestestATLOPE.add("cope");
		mutatorOperatorNamestestATLOPE.add("rope");
		mutatorOperatorNamestestATLOPE.add("ccope");
		mutatorOperatorNamestestATLOPE.add("ncope");
		operatorNames.add(mutatorOperatorNamestestATLOPE);
		List<String> mutatorOperatorNamestestATLMR = new ArrayList<String>();
		mutatorOperatorNamestestATLMR.add("cmr");
		mutatorOperatorNamestestATLMR.add("rmr");
		mutatorOperatorNamestestATLMR.add("ncmr");
		operatorNames.add(mutatorOperatorNamestestATLMR);
		String[] arrMutatorNames = new String[mutatorNames.size()];
		mutatorNames.toArray(arrMutatorNames);
		String[][] arrOperatorNames = new String[mutatorNames.size()][];
		int i = 0;
		for (List<String> mutOpNames : operatorNames) {
			String[] arrMutatorOperatorNames = new String[mutOpNames.size()];
			mutOpNames.toArray(arrMutatorOperatorNames);
			arrOperatorNames[i] = arrMutatorOperatorNames;
			i++;
		}
		String inputWodelFolder = "C:/eclipse/runtime-New_configuration50/WodelTest4ATL/data/model";
		if (!inputFolder.equals(inputWodelFolder)) {
			IOUtils.deleteFolder(inputWodelFolder, "model");
		}
		File seedWodelFolder = new File(inputWodelFolder);
		File inputCustomizedFolder = new File(inputFolder);
		try {
			IOUtils.copyFolder(inputCustomizedFolder, seedWodelFolder, "model");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		File projectFolder = new File(
				testATLMRStandaloneAPI.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
		String outputWodelFolder = testATLMRStandaloneAPI.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath() + "data/out";
		IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
		i = 0;
		testATLFStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testATLIPEStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testATLBStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testATLOPEStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testATLMRStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		File mutantWodelFolder = new File(outputWodelFolder);
		File outputCustomizedFolder = new File(outputFolder);
		try {
			IOUtils.copyFolder(mutantWodelFolder, outputCustomizedFolder, "model", mutatorList);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("Complete mutant generation process finished.");
	}

	public static void main(String[] args) throws ReferenceNonExistingException, WrongAttributeTypeException,
			MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException,
			ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		if (args.length != 2) {
			System.out.println("Use: args[0] = inputFolder; args[1] = outputFolder");
			return;
		}
		createMutants(args[0], args[1]);
	}
}
