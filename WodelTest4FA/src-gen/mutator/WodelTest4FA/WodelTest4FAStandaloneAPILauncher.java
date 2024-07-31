package mutator.WodelTest4FA;

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
import mutator.testFA1.testFA1StandaloneAPI;
import mutator.testFA2.testFA2StandaloneAPI;

public class WodelTest4FAStandaloneAPILauncher {
	public static void createMutants(String inputFolder, String outputFolder)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		String ecoreURI = "C:/eclipse/runtime-EclipseApplication8/WodelTest4FA/data/model/DFAAutomaton.ecore";
		List<String> mutatorNames = new ArrayList<String>();
		mutatorNames.add("testFA1");
		mutatorNames.add("testFA2");
		List<List<String>> operatorNames = new ArrayList<List<String>>();
		List<String> mutatorOperatorNamestestFA1 = new ArrayList<String>();
		mutatorOperatorNamestestFA1.add("cfs");
		mutatorOperatorNamestestFA1.add("ccs");
		mutatorOperatorNamestestFA1.add("dtr");
		mutatorOperatorNamestestFA1.add("dst");
		mutatorOperatorNamestestFA1.add("mst");
		mutatorOperatorNamestestFA1.add("mfs");
		mutatorOperatorNamestestFA1.add("sst");
		mutatorOperatorNamestestFA1.add("rts");
		mutatorOperatorNamestestFA1.add("clt");
		mutatorOperatorNamestestFA1.add("cst");
		operatorNames.add(mutatorOperatorNamestestFA1);
		List<String> mutatorOperatorNamestestFA2 = new ArrayList<String>();
		mutatorOperatorNamestestFA2.add("ctr");
		mutatorOperatorNamestestFA2.add("mis");
		mutatorOperatorNamestestFA2.add("sdt");
		mutatorOperatorNamestestFA2.add("ctr_mis");
		operatorNames.add(mutatorOperatorNamestestFA2);
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
		String inputWodelFolder = "C:/eclipse/runtime-EclipseApplication8/WodelTest4FA/data/model";
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
				testFA2StandaloneAPI.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
		String outputWodelFolder = testFA2StandaloneAPI.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath() + "data/out";
		IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
		i = 0;
		testFA1StandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testFA2StandaloneAPI.createMutants(arrOperatorNames[i]);
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
