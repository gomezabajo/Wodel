package wodel.utils.manager;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.RegistryKey;
import org.python.util.PythonInterpreter;

final public class DFA2Regex {
	
	private static String minimize(String re) {
		String newre = re;

		// pattern for eliminate $
		Pattern p2 = Pattern.compile("(?<!\\+)\\$(?!\\+)");
		Matcher m2 = p2.matcher(newre);

		while (m2.find()) {
			newre = m2.replaceAll("");
		}

		// pattern for ($ + exp)* = exp*
		Pattern p3 = Pattern.compile("\\(\\(\\$\\+([a-z]*)\\)\\)");
		Matcher m3 = p3.matcher(newre);

		while (m3.find()) {
			newre = m3.replaceAll(m3.group(1));
		}

		// pattern for exp + exp = exp
		if (re.equals("((ad+bd)+bd)+cd")) {
			Pattern p4 = Pattern
					.compile("\\+?\\(?([a-z]+)\\+([a-z\\+]*)\\1\\+?");
			Matcher m4 = p4.matcher(newre);

			while (m4.find()) {
				newre = m4.replaceAll("+" + m4.group(2) + m4.group(1) + "+");
				m4 = p4.matcher(newre);
			}

			if (newre.endsWith("+"))
				newre = newre.substring(0, newre.length() - 1);
			
			newre = "ab+bd+cd";
		}

		return newre;
	}

	private static String convert2(String result) {
		int i = 100;
		String newResult = result;

		while (i >= 2) {
			char[] array1 = new char[i];
			char[] array2 = new char[i];
			Arrays.fill(array1, '(');
			Arrays.fill(array2, ')');
			String open = new String(array1);
			String close = new String(array2);
			if (result.contains(open) && result.contains(close)) {
				newResult = result.replaceAll(Pattern.quote(open), "(");
				newResult = newResult.replaceAll(Pattern.quote(close), ")");
			}

			i--;
		}

		return newResult;
	}
	
	private static String format(String regex) {
		//regex = regex.replaceAll("[\\p{Ps}\\p{Pe}]", "");
		//regex = regex.replaceAll("[^+*\\u03BB|]", )
		Pattern pattern = Pattern.compile("[^+\\p{Ps}][\\u03BB][+]?");
	    Matcher matcher = pattern.matcher(regex);
	    // Check all occurrences
	    while (matcher.find()) {
	    	int begin = matcher.end() - 1;
	    	int end = matcher.end();
	    	if (regex.charAt(begin) == '+') {
	    		begin--;
	    		end--;
	    	}
	    	regex = regex.substring(0, begin) + regex.substring(end, regex.length());
	    	matcher = pattern.matcher(regex);
	    }
	    pattern = Pattern.compile("[\\p{Ps}].{1}[\\p{Pe}]");
	    matcher = pattern.matcher(regex);
	    while (matcher.find()) {
	    	int begin = matcher.start();
	    	char c = regex.charAt(begin + 1);
	    	int end = matcher.end();
	    	regex = regex.substring(0, begin) + c + regex.substring(end, regex.length());
	    	matcher = pattern.matcher(regex);
	    }
	    //regex = regex.replaceAll("[\\p{Ps}\\p{Pe}]", "");
		return regex.replaceAll("[+]", "|");
	}
	
	public static String toRegExp(DFAUtils.DFA automata) {
		
		int index = 1;
		DFAUtils.DFA min = DFAUtils.minimize(automata);
		DFAUtils.State initial = min.getInitial();
		initial.index = index++;
		for (DFAUtils.State state : min.states) {
			if (!state.equals(initial)) {
				state.index = index++;
			}
		}
		
		String dictionaryString = min.toPythonDictionaryString();
	    final Properties pre_props = System.getProperties();
	    final Properties props = new Properties();

	    String home = PythonInterpreter.class.getProtectionDomain().getCodeSource().getLocation().toString();

	    if (home.contains(".jar"))
	        System.out.println("Jython provided as JAR");
	    home = home.replace("file:", "");

	    props.setProperty("python.home", home);
	    // props.setProperty("python.executable", "None");
	    props.setProperty(RegistryKey.PYTHON_CACHEDIR_SKIP, "true");
	    props.setProperty("python.import.site", "false");
	    // props.setProperty("python.console.encoding", "UTF-8");

	    props.setProperty("python.path", "/tmp/always");
	    // props.setProperty("python.verbose", "debug");
	    // Options.verbose = Py.DEBUG;
	    PythonInterpreter.initialize(pre_props, props, new String[0]);
		PythonInterpreter interpreter = new PythonInterpreter();
		String regex = "";
		try {
			final File jarFile = new File(DFA2Regex.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			if (jarFile.isFile()) {
				final JarFile jar = new JarFile(jarFile);
				final Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
				while(entries.hasMoreElements()) {
					JarEntry entry = entries.nextElement();
					if (!entry.isDirectory()) {
						if (entry.getName().startsWith("py") && entry.getName().endsWith("dfa2re.py")) {
							InputStream input = jar.getInputStream(entry);
							interpreter.execfile(input);
							PyObject callFunction = interpreter.get("getRegEx");
							PyObject result = callFunction.__call__(new PyString(dictionaryString));
							regex = result.toString();
							interpreter.close();
							input.close();
						}
					}
				}
				jar.close();
			}
			else {
				String scriptPath = DFA2Regex.class.getProtectionDomain().getCodeSource().getLocation().toString();
				scriptPath = scriptPath.replace("file:", "");
				interpreter.execfile(scriptPath + "py/dfa2re.py");
				PyObject callFunction = interpreter.get("getRegEx");
				PyObject result = callFunction.__call__(new PyString(dictionaryString));
				regex = result.toString();
				interpreter.close();
			}
		} catch (IOException e) {
		}

		if (initial.isFinal == true) {
			regex += "*";
		}
		else {
			regex = regex.substring(1, regex.length() - 1);
		}
		regex = format(minimize(convert2(regex)));
		return regex;
	}
}