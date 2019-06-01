package wodel.atl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Comparison;
import org.xmlunit.diff.DefaultNodeMatcher;
import org.xmlunit.diff.Diff;
import org.xmlunit.diff.Difference;
import org.xmlunit.diff.ElementSelectors;

public class AtlEquivalenceCheck {

	private static String getXML(File modelFile) {
		String xml = "";
		try {
			FileReader xmlReader = new FileReader(modelFile);
			BufferedReader bufferedReader = new BufferedReader(xmlReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				xml += line + "\n";
			}
			bufferedReader.close();
			xmlReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xml;
	}
	
//	public static Comparison compare(String xml1, String xml2) {
//		// Load the two input models
//		ResourceSet resourceSet1 = new ResourceSetImpl();
//		resourceSet1.getResourceFactoryRegistry().getExtensionToFactoryMap().put("asm", new GenericXMLResourceFactoryImpl());
//		ResourceSet resourceSet2 = new ResourceSetImpl();
//		resourceSet2.getResourceFactoryRegistry().getExtensionToFactoryMap().put("asm", new GenericXMLResourceFactoryImpl());
//		load(xml1, resourceSet1);
//		load(xml2, resourceSet2);
//
//		// Configure EMF Compare
//		IEObjectMatcher matcher = DefaultMatchEngine.createDefaultEObjectMatcher(UseIdentifiers.NEVER);
//		IComparisonFactory comparisonFactory = new DefaultComparisonFactory(new DefaultEqualityHelperFactory());
//		IMatchEngine matchEngine = new DefaultMatchEngine(matcher, comparisonFactory);
//		IMatchEngine.Factory.Registry matchEngineRegistry = EMFCompareRCPPlugin.getDefault().getMatchEngineFactoryRegistry();
//		IPostProcessor.Descriptor.Registry<String> postProcessorRegistry = EMFCompareRCPPlugin.getDefault().getPostProcessorRegistry();
//		EMFCompare comparator = EMFCompare.builder()
//	                                           .setMatchEngineFactoryRegistry(matchEngineRegistry)
//	                                           .setPostProcessorRegistry(postProcessorRegistry)
//	                                           .build();
//
//		// Compare the two models
//		IComparisonScope scope = EMFCompare.createDefaultScope(resourceSet1, resourceSet2);
//		return comparator.compare(scope);
//	}
//
//	private static void load(String absolutePath, ResourceSet resourceSet) {
//	  URI uri = URI.createFileURI(absolutePath);
//
//	  // Resource will be loaded within the resource set
//	  resourceSet.getResource(uri, true);
//	}
//
	
	private static boolean doCompare(String xml1, String xml2) {
		
//		return xml1.equals(xml2);
		
//		StringReader stringReader1 = new StringReader(xml1);
//	    Source source1 = new StreamSource(stringReader1);
//	    StringReader stringReader2 = new StringReader(xml2);
//	    Source source2 = new StreamSource(stringReader2);
//	    
//	    Diff diff = DiffBuilder.compare(source1).withTest(source2)
//	    	     .checkForSimilar()
//	    	     .ignoreWhitespace()
//	    	     .build();
//	    stringReader2.close();
//	    stringReader1.close();
//		return !diff.hasDifferences();
		
//		boolean isRepeated = false;
//		try {
//			ResourceSet resourceSet = new ResourceSetImpl();
//			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("asm", new GenericXMLResourceFactoryImpl());
//			Resource resource1 = resourceSet.getResource(URI.createFileURI(xml1), true);
//			resource1.load(Collections.EMPTY_MAP);
//			EObject obj1 = resource1.getContents().get(0);
//
//			Resource resource2 = resourceSet.getResource(URI.createFileURI(xml2), true);
//			resource2.load(Collections.EMPTY_MAP);
//			EObject obj2 = resource2.getContents().get(0);
//			isRepeated = EcoreUtil.equals(obj1, obj2);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		boolean isRepeated = false;
		StringReader stringReader1 = new StringReader(xml1);
		Source source1 = new StreamSource(stringReader1);
		StringReader stringReader2 = new StringReader(xml2);
		Source source2 = new StreamSource(stringReader2);

		Map<String, String> changes1 = new HashMap<String, String>();
		Diff diff = DiffBuilder.compare(source1).withTest(source2)
				.withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
				.checkForSimilar()
				.ignoreWhitespace()
				.ignoreComments()
				.build();
		if (diff.hasDifferences() == true) {
			Iterator<Difference> differences = diff.getDifferences().iterator();
			while (differences.hasNext()) {
				Difference difference = differences.next();
				Comparison comparison = difference.getComparison();
				changes1.put(comparison.getTestDetails().getXPath(),
						comparison.getTestDetails().getValue() != null ? comparison.getTestDetails().getValue().toString() : "");
			}

			Map<String, String> changes2 = new HashMap<String, String>();
			stringReader1 = new StringReader(xml2);
			source1 = new StreamSource(stringReader1);
			stringReader2 = new StringReader(xml1);
			source2 = new StreamSource(stringReader2);
			diff = DiffBuilder.compare(source1).withTest(source2)
					.withNodeMatcher(new DefaultNodeMatcher(ElementSelectors.byNameAndText))
					.checkForSimilar()
					.ignoreWhitespace()
					.ignoreComments()
					.build();
			differences = diff.getDifferences().iterator();
			int counter = 0;
			while (differences.hasNext()) {
				Difference difference = differences.next();
				Comparison comparison = difference.getComparison();
				changes2.put(comparison.getTestDetails().getXPath(),
						comparison.getTestDetails().getValue() != null ? comparison.getTestDetails().getValue().toString() : "");
				counter++;
			}
			int equivalences = 0;
			for (String key1 : changes1.keySet()) {
				String value2 = changes2.get(key1);
				if (value2 != null) {
					for (String key2 : changes2.keySet()) {
						if (!key1.equals(key2)) {
							String value1 = changes1.get(key2);
							if (value1 != null) {
								if (value1.equals(value2)) {
									equivalences++;
								}
							}
						}
					}
				}
			}
			isRepeated = counter == equivalences;
		}
		else {
			isRepeated = true;
		}
		stringReader2.close();
		stringReader1.close();
		return isRepeated;
	}
	public static boolean applyTCE(String model1, String model2) {
		boolean isRepeated = false;
		isRepeated = doCompare(getXML(new File(model1)), getXML(new File(model2)));
		return isRepeated;
	}

	public static void main(String[] args) {
		String model1 = "C:/eclipse/workspace/wodel.atl/models/atl2.asm";
		String model2 = "C:/eclipse/workspace/wodel.atl/models/atl3.asm";
		
		System.out.println(applyTCE(model1, model2));

	}
}
