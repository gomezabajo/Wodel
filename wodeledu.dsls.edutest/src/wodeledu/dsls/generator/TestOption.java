package wodeledu.dsls.generator;

import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;

public class TestOption implements Cloneable {
	public String path;
	public Resource resource;
	public Resource seed;
	public Resource mutant;
	public SimpleEntry<Resource, Resource> entry;
	public List<SimpleEntry<Resource, Map<String, List<String>>>> reverse;
	public Map<String, List<String>> text;
	public boolean solution;
	public int total;
	
	public Map<String, List<ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>>>> options;
	
	public Map<String, List<ComparableSimpleEntry<String, SimpleEntry<EClass, SimpleEntry<String, SimpleEntry<Integer, Boolean>>>>>> sortedOptions;

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
