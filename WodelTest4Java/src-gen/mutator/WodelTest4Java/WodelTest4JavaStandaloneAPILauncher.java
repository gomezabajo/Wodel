package mutator.WodelTest4Java;

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
import mutator.testJavaSO.testJavaSOStandaloneAPI;
import mutator.testJavaLO.testJavaLOStandaloneAPI;
import mutator.testJavaCO.testJavaCOStandaloneAPI;
import mutator.testJavaASO.testJavaASOStandaloneAPI;
import mutator.testJavaCOD.testJavaCODStandaloneAPI;
import mutator.testJavaAO.testJavaAOStandaloneAPI;
import mutator.testJavaRest.testJavaRestStandaloneAPI;
import mutator.testJavaRO.testJavaROStandaloneAPI;
import mutator.testJavaAP.testJavaAPStandaloneAPI;
import mutator.testJavaUCOD.testJavaUCODStandaloneAPI;
import mutator.testJavaIN.testJavaINStandaloneAPI;
import mutator.testJavaDLM.testJavaDLMStandaloneAPI;
import mutator.testJavaNLS.testJavaNLSStandaloneAPI;

public class WodelTest4JavaStandaloneAPILauncher {
	public static void createMutants(String inputFolder, String outputFolder)
			throws ReferenceNonExistingException, WrongAttributeTypeException, MaxSmallerThanMinException,
			AbstractCreationException, ObjectNoTargetableException, ObjectNotContainedException,
			MetaModelNotFoundException, ModelNotFoundException, IOException {
		String ecoreURI = "C:/eclipse/runtime-New_configuration16/WodelTest4Java/data/model/java.ecore";
		List<String> mutatorNames = new ArrayList<String>();
		mutatorNames.add("testJavaSO");
		mutatorNames.add("testJavaLO");
		mutatorNames.add("testJavaCO");
		mutatorNames.add("testJavaASO");
		mutatorNames.add("testJavaCOD");
		mutatorNames.add("testJavaAO");
		mutatorNames.add("testJavaRest");
		mutatorNames.add("testJavaRO");
		mutatorNames.add("testJavaAP");
		mutatorNames.add("testJavaUCOD");
		mutatorNames.add("testJavaIN");
		mutatorNames.add("testJavaDLM");
		mutatorNames.add("testJavaNLS");
		List<List<String>> operatorNames = new ArrayList<List<String>>();
		List<String> mutatorOperatorNamestestJavaSO = new ArrayList<String>();
		mutatorOperatorNamestestJavaSO.add("sor");
		mutatorOperatorNamestestJavaSO.add("sorr");
		mutatorOperatorNamestestJavaSO.add("sol");
		operatorNames.add(mutatorOperatorNamestestJavaSO);
		List<String> mutatorOperatorNamestestJavaLO = new ArrayList<String>();
		mutatorOperatorNamestestJavaLO.add("lora");
		mutatorOperatorNamestestJavaLO.add("loro");
		mutatorOperatorNamestestJavaLO.add("lorx");
		operatorNames.add(mutatorOperatorNamestestJavaLO);
		List<String> mutatorOperatorNamestestJavaCO = new ArrayList<String>();
		mutatorOperatorNamestestJavaCO.add("cora");
		mutatorOperatorNamestestJavaCO.add("coro");
		mutatorOperatorNamestestJavaCO.add("corx");
		operatorNames.add(mutatorOperatorNamestestJavaCO);
		List<String> mutatorOperatorNamestestJavaASO = new ArrayList<String>();
		mutatorOperatorNamestestJavaASO.add("asrsp");
		mutatorOperatorNamestestJavaASO.add("asrsm");
		mutatorOperatorNamestestJavaASO.add("asrst");
		mutatorOperatorNamestestJavaASO.add("asrsd");
		mutatorOperatorNamestestJavaASO.add("asrsr");
		mutatorOperatorNamestestJavaASO.add("asrsa");
		mutatorOperatorNamestestJavaASO.add("asrso");
		mutatorOperatorNamestestJavaASO.add("asrsx");
		mutatorOperatorNamestestJavaASO.add("asrssr");
		mutatorOperatorNamestestJavaASO.add("asrssrr");
		mutatorOperatorNamestestJavaASO.add("asrssl");
		operatorNames.add(mutatorOperatorNamestestJavaASO);
		List<String> mutatorOperatorNamestestJavaCOD = new ArrayList<String>();
		mutatorOperatorNamestestJavaCOD.add("cn1");
		mutatorOperatorNamestestJavaCOD.add("cn2");
		mutatorOperatorNamestestJavaCOD.add("cn3");
		mutatorOperatorNamestestJavaCOD.add("cn4");
		mutatorOperatorNamestestJavaCOD.add("rc");
		operatorNames.add(mutatorOperatorNamestestJavaCOD);
		List<String> mutatorOperatorNamestestJavaAO = new ArrayList<String>();
		mutatorOperatorNamestestJavaAO.add("aorbp");
		mutatorOperatorNamestestJavaAO.add("aorbm");
		mutatorOperatorNamestestJavaAO.add("aorbt");
		mutatorOperatorNamestestJavaAO.add("aorbd");
		mutatorOperatorNamestestJavaAO.add("aorbr");
		mutatorOperatorNamestestJavaAO.add("aorsi");
		mutatorOperatorNamestestJavaAO.add("aorsd");
		mutatorOperatorNamestestJavaAO.add("aorspi");
		mutatorOperatorNamestestJavaAO.add("aorspd");
		mutatorOperatorNamestestJavaAO.add("aoium");
		mutatorOperatorNamestestJavaAO.add("aoiup");
		mutatorOperatorNamestestJavaAO.add("aoisd");
		mutatorOperatorNamestestJavaAO.add("aoisi");
		mutatorOperatorNamestestJavaAO.add("aods");
		operatorNames.add(mutatorOperatorNamestestJavaAO);
		List<String> mutatorOperatorNamestestJavaRest = new ArrayList<String>();
		mutatorOperatorNamestestJavaRest.add("rtr");
		mutatorOperatorNamestestJavaRest.add("vmr");
		mutatorOperatorNamestestJavaRest.add("nvmr");
		mutatorOperatorNamestestJavaRest.add("cir");
		mutatorOperatorNamestestJavaRest.add("vra");
		mutatorOperatorNamestestJavaRest.add("rst");
		operatorNames.add(mutatorOperatorNamestestJavaRest);
		List<String> mutatorOperatorNamestestJavaRO = new ArrayList<String>();
		mutatorOperatorNamestestJavaRO.add("rorgt");
		mutatorOperatorNamestestJavaRO.add("rorget");
		mutatorOperatorNamestestJavaRO.add("rorlt");
		mutatorOperatorNamestestJavaRO.add("rorlet");
		mutatorOperatorNamestestJavaRO.add("rore");
		mutatorOperatorNamestestJavaRO.add("rord");
		operatorNames.add(mutatorOperatorNamestestJavaRO);
		List<String> mutatorOperatorNamestestJavaAP = new ArrayList<String>();
		mutatorOperatorNamestestJavaAP.add("apmrt");
		mutatorOperatorNamestestJavaAP.add("apmir");
		mutatorOperatorNamestestJavaAP.add("apmil");
		mutatorOperatorNamestestJavaAP.add("apmas");
		operatorNames.add(mutatorOperatorNamestestJavaAP);
		List<String> mutatorOperatorNamestestJavaUCOD = new ArrayList<String>();
		mutatorOperatorNamestestJavaUCOD.add("cod1");
		mutatorOperatorNamestestJavaUCOD.add("cod2");
		mutatorOperatorNamestestJavaUCOD.add("cod3");
		mutatorOperatorNamestestJavaUCOD.add("cod4");
		operatorNames.add(mutatorOperatorNamestestJavaUCOD);
		List<String> mutatorOperatorNamestestJavaIN = new ArrayList<String>();
		mutatorOperatorNamestestJavaIN.add("inr");
		mutatorOperatorNamestestJavaIN.add("inl");
		mutatorOperatorNamestestJavaIN.add("inst");
		mutatorOperatorNamestestJavaIN.add("ina");
		operatorNames.add(mutatorOperatorNamestestJavaIN);
		List<String> mutatorOperatorNamestestJavaDLM = new ArrayList<String>();
		mutatorOperatorNamestestJavaDLM.add("bt");
		mutatorOperatorNamestestJavaDLM.add("bf");
		mutatorOperatorNamestestJavaDLM.add("rnl");
		mutatorOperatorNamestestJavaDLM.add("nrst");
		mutatorOperatorNamestestJavaDLM.add("rn0");
		mutatorOperatorNamestestJavaDLM.add("rnn0");
		mutatorOperatorNamestestJavaDLM.add("rnn1");
		mutatorOperatorNamestestJavaDLM.add("rnn2");
		mutatorOperatorNamestestJavaDLM.add("rnn3");
		mutatorOperatorNamestestJavaDLM.add("rsl");
		operatorNames.add(mutatorOperatorNamestestJavaDLM);
		List<String> mutatorOperatorNamestestJavaNLS = new ArrayList<String>();
		mutatorOperatorNamestestJavaNLS.add("dnl");
		mutatorOperatorNamestestJavaNLS.add("dnr");
		mutatorOperatorNamestestJavaNLS.add("dnrst");
		mutatorOperatorNamestestJavaNLS.add("dna");
		operatorNames.add(mutatorOperatorNamestestJavaNLS);
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
		String inputWodelFolder = "C:/eclipse/runtime-New_configuration16/WodelTest4Java/data/model";
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
				testJavaDLMStandaloneAPI.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		List<String> mutatorList = MutatorUtils.getMutators(projectFolder.listFiles());
		String outputWodelFolder = testJavaDLMStandaloneAPI.class.getProtectionDomain().getCodeSource().getLocation()
				.getPath() + "data/out";
		IOUtils.deleteFolder(outputWodelFolder, "model", mutatorList);
		i = 0;
		testJavaSOStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaLOStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaCOStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaASOStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaCODStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaAOStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaRestStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaROStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaAPStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaUCODStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaINStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaDLMStandaloneAPI.createMutants(arrOperatorNames[i]);
		i++;
		testJavaNLSStandaloneAPI.createMutants(arrOperatorNames[i]);
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
