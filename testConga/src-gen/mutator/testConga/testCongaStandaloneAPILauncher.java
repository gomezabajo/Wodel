package mutator.testConga;

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
import mutator.testBotGenerator.testBotGeneratorStandaloneAPI;

public class testCongaStandaloneAPILauncher {
	public static void createMutants(String inputFolder, String outputFolder)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		String ecoreURI = "C:/eclipse/runtime-EclipseApplication41/testConga/data/model/Annotation.ecore";
		List<String> mutatorNames = new ArrayList<String>();
		mutatorNames.add("testBotGenerator");
		List<List<String>> operatorNames = new ArrayList<List<String>>();
		List<String> mutatorOperatorNamestestBotGenerator = new ArrayList<String>();
		mutatorOperatorNamestestBotGenerator.add("dp_max");
		mutatorOperatorNamestestBotGenerator.add("dp_min");
		mutatorOperatorNamestestBotGenerator.add("dpwp");
		mutatorOperatorNamestestBotGenerator.add("dpwl");
		mutatorOperatorNamestestBotGenerator.add("k2p_max");
		mutatorOperatorNamestestBotGenerator.add("k2p_min");
		mutatorOperatorNamestestBotGenerator.add("mp_max");
		mutatorOperatorNamestestBotGenerator.add("mp_min");
		mutatorOperatorNamestestBotGenerator.add("dip");
		mutatorOperatorNamestestBotGenerator.add("dpp");
		mutatorOperatorNamestestBotGenerator.add("spo");
		mutatorOperatorNamestestBotGenerator.add("cre");
		mutatorOperatorNamestestBotGenerator.add("dle");
		mutatorOperatorNamestestBotGenerator.add("dfi");
		mutatorOperatorNamestestBotGenerator.add("da");
		mutatorOperatorNamestestBotGenerator.add("dpr");
		mutatorOperatorNamestestBotGenerator.add("so");
		mutatorOperatorNamestestBotGenerator.add("dcs");
		mutatorOperatorNamestestBotGenerator.add("dcb");
		operatorNames.add(mutatorOperatorNamestestBotGenerator);
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
		String inputWodelFolder = "C:/eclipse/runtime-EclipseApplication41/testConga/data/model";
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
				testBotGeneratorStandaloneAPI.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
		String outputWodelFolder = testBotGeneratorStandaloneAPI.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath() + "data/out";
		IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
		i = 0;
		testBotGeneratorStandaloneAPI.createMutants(arrOperatorNames[i]);
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
