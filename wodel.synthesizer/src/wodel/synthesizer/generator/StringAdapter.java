package wodel.synthesizer.generator;

/**
 * USE is not able to solve conditions on arbitrary constant-strings (e.g. 'John'), but 
 * it solves equalities involving constant-strings of the form 'string1', 'string2' and 
 * so on. This adapter builds a mapping between the constant-strings appearing in a set
 * of ocl expressions, and the formatted ones that USE is able to solve (e.g. {'John'->'string1'}). 
 */

import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdapter {
	private Hashtable<String,String> string_adapter;
	
	public StringAdapter () {
		this.reset();
	}
	
	public StringAdapter (List<String> ocl_expressions) {
		this.reset();
		this.init(ocl_expressions);
	}
	
	/**
	 * Resets the adapter
	 */
	public void reset () {
		string_adapter = new Hashtable<String,String>();
	}
	
	/**
	 * Builds a mapping between the constant-strings appearing in a list of ocl expressions,
     * and the formatted ones that USE is able to solve (e.g. {'John'->'string1'}). 
	 */
	public void init (List<String> ocl_expressions) {
		this.reset();
		
		Pattern pattern = Pattern.compile("'([^']*)'");
		for (String ocl_expression : ocl_expressions) {
			Matcher matcher = pattern.matcher(ocl_expression);
			int index = 1;
			while (matcher.find()) {
				String string_adapted = matcher.group();
				if (!string_adapter.contains(string_adapted)) {
					string_adapter.put(string_adapted, "'string"+index+"'");
					index++;
				}
			}
		}
	}
	
	/**
	 * It adapts the ocl expression, substituting any constant-string as specified by the established mapping.
	 */
	public String adapt_ocl_expression(String ocl_expression) {
		for (Entry<String,String> adaptation : string_adapter.entrySet()) 
			ocl_expression = ocl_expression.replaceAll(adaptation.getKey(), adaptation.getValue());
		return ocl_expression;
	}
	
	/**
	 * It returns the constant-string mapped to a use-string (i.e. the opposite to adapt_ocl_expression).
	 */
	public String adapt_use_string(String use_string) {
		// by default, we return the same string
		String ocl_string = use_string;
		
		// search the ocl constant-string mapped to the use-string
		if (string_adapter.containsValue(use_string)) return use_string;
			for (Entry<String,String> adaptation : string_adapter.entrySet()) {
				if (adaptation.getValue().equals("'"+use_string+"'")) {
					ocl_string = adaptation.getKey();
					ocl_string = ocl_string.substring(1, ocl_string.length()-1);
					break;
				}
			}
			
		return ocl_string;
	}
	
	/**
	 * It returns the number of adaptations (or mappings) established.
	 * @return
	 */
	public int getNumberAdaptations() {
		return string_adapter==null? 0 : string_adapter.keySet().size(); 
	}
}
