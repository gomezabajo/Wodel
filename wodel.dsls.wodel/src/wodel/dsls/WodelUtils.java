package wodel.dsls;

import java.io.IOException;

import mutatorenvironment.MutatorenvironmentPackage;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.ISerializer;

import com.google.inject.Injector;

import mutatorenvironment.miniOCL.InvariantCS;

/**
 * @author Pablo Gomez-Abajo - Utils for serialize and deserialize Wodel programs
 * 
 */

public class WodelUtils {

	/**
	 * @param model
	 *            Model one wants to output
	 * @param outputURI
	 *            URI of the new created Model
	 */
	public static void serialize(String xTextURI, String outputURI) {
		EPackage.Registry.INSTANCE.put(MutatorenvironmentPackage.eNS_URI,  MutatorenvironmentPackage.eINSTANCE);
		
		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
		ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
		XtextResource xtextInput = (XtextResource)xTextRS.getResource(URI.createURI(xTextURI), true);
		EcoreUtil.resolveAll(xtextInput);
		
		//create an empty xmi resource
		ResourceSet xmiRS = new ResourceSetImpl();
		Resource xmiOutput = xmiRS.createResource(URI.createURI(outputURI));
		
		xmiOutput.getContents().add(xtextInput.getContents().get(0));
		try {
			xmiOutput.save(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
//	public static String deserialize(EObject eObject) {
//		Injector injector = Guice.createInjector(new  wodel.dsls.WodelRuntimeModule());  
//		Serializer serializer = injector.getInstance(Serializer.class);  
//		return serializer.serialize(eObject);
//	}
	
	public static String deserialize(String xTextURI, EObject eObject) {
		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
		ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
		XtextResource xtextOutput = (XtextResource)xTextRS.createResource(URI.createURI(xTextURI));
		xtextOutput.getContents().add(eObject);
		ISerializer serializer = xtextOutput.getSerializer();
		return format(serializer.serialize(xtextOutput.getContents().get(0)));
		//return serializer.serialize(xtextOutput.getContents().get(0));
	}
//	
//	public static String deserialize(String xTextURI, EObject eObject) {
//		Injector injector = new WodelStandaloneSetup().createInjectorAndDoEMFRegistration();
//		ResourceSet xTextRS = injector.getInstance(XtextResourceSet.class);
//		XtextResource xtextOutput = (XtextResource)xTextRS.createResource(URI.createURI(xTextURI));
//		xtextOutput.getContents().add(eObject);
//		try {
//			xtextOutput.save(null);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String ret = "";
//		try {
//			File outputFile = new File(xTextURI);
//			if (outputFile.exists()) {
//				FileReader reader = new FileReader(outputFile);
//				BufferedReader br = new BufferedReader(reader);
//				String line = "";
//				while ((line = br.readLine()) != null) {
//					ret += line + "\n";
//				}
//				br.close();
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ret;
//	}

	public static String getConstraintText(String xTextURI, InvariantCS expression) {
		return WodelUtils.deserialize(xTextURI, expression).
				replaceAll("(\\r|\\n)", "").
				replaceAll("\\$", "").
				replaceAll(";", "").
				trim();
	}
	
	private static String formatOperator(String operator) {
		String formatted = "";
		String[] operations = {"create", "clone", "modify", "select", "remove", "retype"};
		int index = -1;
		int begin = Integer.MAX_VALUE;
		int i = 0;
		for (int j = 0; j < operations.length; j++) {
			int current = operator.indexOf(operations[j]);
			if (current != -1 && begin > current) {
				begin = current;
				index = j;
			}
		}
		if (index == - 1) {
			return formatted;
		}
		formatted += "\t\t";
		if (i < begin) {
			while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
				i++;
			}
			while (i < begin && (Character.isAlphabetic(operator.charAt(i)) || Character.isDigit(operator.charAt(i)))) {
				formatted += operator.charAt(i);
				i++;
			}
			while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
				i++;
			}
			formatted += " = ";
		}
		formatted += operations[index];
		i += operations[index].length();
		index = -1;
		int end = Integer.MAX_VALUE;
		for (int j = 0; j < operations.length; j++) {
			int current = operator.substring(i, operator.length()).indexOf(operations[j]);
			if (current != -1 && end > current) {
				end = current + i;
				index = j;
			}
		}
		if (index == -1) {
			formatted += " " + operator.substring(i, operator.length()).trim() + "\n";
		}
		else {
			formatted += " ";
			while (index != -1) {
				int k = end - 1;
				boolean variable = false;
				if (operator.indexOf(operations[index]) != 0) {
					while (k > begin && !Character.isAlphabetic(operator.charAt(k)) && !Character.isDigit(operator.charAt(k)) && operator.charAt(k) != '=') {
						k--;
					}
					if (k > begin && operator.charAt(k) == '=') {
						variable = true;
						k--;
					}
					while (k > begin && !Character.isAlphabetic(operator.charAt(k)) && !Character.isDigit(operator.charAt(k))) {
						k--;
					}
					while (k > begin && (Character.isAlphabetic(operator.charAt(k)) || Character.isDigit(operator.charAt(k)))) {
						k--;
					}
				}
				if (variable == false) {
					k = end;
				}
				if (k > i) {
					formatted += operator.substring(i, k).trim() + "\n\t\t";
				}
				else {
					return formatted;
				}
				operator = operator.substring(k, operator.length()).trim();
				i = 0;
				begin = Integer.MAX_VALUE;
				for (int j = 0; j < operations.length; j++) {
					int current = operator.indexOf(operations[j]);
					if (current != -1 && begin > current) {
						begin = current;
						index = j;
					}
				}
				if (index == - 1) {
					return formatted;
				}
				if (i < begin) {
					while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
						i++;
					}
					while (i < begin && (Character.isAlphabetic(operator.charAt(i)) || Character.isDigit(operator.charAt(i)))) {
						i++;
					}
					while (i < begin && !Character.isAlphabetic(operator.charAt(i)) && !Character.isDigit(operator.charAt(i))) {
						i++;
					}
				}
				i += operations[index].length();
				index = -1;
				end = Integer.MAX_VALUE;
				for (int j = 0; j < operations.length; j++) {
					int current = operator.substring(i, operator.length()).indexOf(operations[j]);
					if (current != -1 && end > current) {
						end = current + i;
						index = j;
					}
				}
				i = 0;
				if (index == -1) {
					formatted += operator.substring(i, operator.length()).trim() + "\n";
				}
			}
		}
		return formatted;
	}
	
	private static String format(String program) {
		String formatted = "";
		int position = program.indexOf("in \"");
		int i = 0;
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n";
		position = program.indexOf("from \"");
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n";
		position = program.indexOf("metamodel \"");
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n";
		position = program.indexOf("with");
		for (; i < position; i++) {
			formatted += program.charAt(i);
		}
		formatted += "\n\n";
		position = program.indexOf("{");
		String mode = "";
		for (; i < position; i++) {
			formatted += program.charAt(i);
			mode += program.charAt(i);
		}
		mode = mode.trim();
		i++;
		formatted += "{\n";
		while (program.charAt(i) == ' '  || program.charAt(i) == '\t') {
			i++;
		}
		formatted += "\t";
		if (mode.equals("with blocks")) {
			while (i < program.length()) {
				String word = "";
				while (i < program.length() && program.charAt(i) != ' ' && program.charAt(i) != '{' && program.charAt(i) != '\t') {
					word += program.charAt(i);
					i++;
				}
				if (i == program.length()) {
					break;
				}
				i++;
				formatted += word + " " + "{" + "\n";
				int k = i + 1;
				int counter = 1;
				while (k < program.length() && counter != 0) {
					if (program.charAt(k) == '{') {
						counter++;
					}
					if (program.charAt(k) == '}') {
						counter--;
					}
					k++;
				}
				formatted += formatOperator(program.substring(i + 1, k - 1).trim()) + "\t}\n\t";
				i = k + 1;
			}
			formatted = formatted.substring(0, formatted.length() - 1) + "}\n";
		}
		else {
			formatted += formatOperator(program.substring(i + 1, program.lastIndexOf("}")).trim()) + "}\n";
		}
		return formatted;
	}
	
	//public static void main(String[] args) {
	//	String program = "generate 2 mutants in \"data/out/\" from \"data/model/\" metamodel \"D:/foot/runtime-Synthesis/bpmn.wodel/data/model/simplebpmn.ecore\" with blocks { delete { s0 = select one Sequence where { ^to is typed Activity } a = select one Activity in s0 -> ^to s1 = select one Sequence where { ^from = a } f = select one FlowObject in s1 -> ^to remove a remove s1 modify target ^to from s0 to f } b0 { modify one Message with { name = \"string\" } } }";
	//	System.out.println(format(program));
	//}
}
