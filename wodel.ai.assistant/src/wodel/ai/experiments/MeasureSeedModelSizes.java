package wodel.ai.experiments;

import static wodel.ai.assistant.utils.AssistantUtils.buildPath;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import wodel.ai.assistant.utils.AssistantUtils;

record ModelStat(int numObjects, int numAttributes, int numReferences) { }
record StatSummary(
	    double average,
	    double stdDev,
	    int min,
	    int max
	) {}

public class MeasureSeedModelSizes {
	private ResourceSetImpl resourceSet;
	private Map<String, ModelStat> stats = new LinkedHashMap<>();

	public void genMetrics() throws Exception{
		List<String> modelSizes = List.of("01_racks", "05_racks", "10_racks", "20_racks", "50_racks");
		//List<String> modelSizes = List.of("0_nano", "1_small", "2_mid", "3_large", "4_xlarge");
		//List<String> modelSizes = List.of("01_tiny", "02_small", "03_average", "04_big", "05_huge");
		int numSeeds = 4;

		String ecoreModelPath = new File(buildPath("experiments", "datac_repair", "datac.ecore")).getAbsolutePath();
		this.registerEcore(ecoreModelPath);

		for (String size: modelSizes) {
			for (int n = 1; n<=numSeeds; n++) {
				String basePath = buildPath("experiments", "datac_repair", size, String.valueOf(n));
				String xmiModelPath = new File(buildPath(basePath,"datac_"+n+".xmi")).getAbsolutePath();
				ModelStat ms = processXMIFile(xmiModelPath);
				this.stats.put(xmiModelPath, ms);
			}
		}		
		printModelStatSummary();
	}

	public void printModelStatSummary() {
	    List<Integer> objects = this.stats.values().stream()
	        .map(ModelStat::numObjects)
	        .collect(Collectors.toList());

	    List<Integer> attributes = this.stats.values().stream()
	        .map(ModelStat::numAttributes)
	        .collect(Collectors.toList());

	    List<Integer> references = this.stats.values().stream()
	        .map(ModelStat::numReferences)
	        .collect(Collectors.toList());

	    StatSummary objStats = calculateStats(objects);
	    StatSummary attrStats = calculateStats(attributes);
	    StatSummary refStats = calculateStats(references);

	    System.out.println("ModelStat Summary:");
	    System.out.printf("Objects:  avg=%.2f, stdDev=%.2f, min=%d, max=%d%n",
	                      objStats.average(), objStats.stdDev(), objStats.min(), objStats.max());
	    System.out.printf("Attributes: avg=%.2f, stdDev=%.2f, min=%d, max=%d%n",
	                      attrStats.average(), attrStats.stdDev(), attrStats.min(), attrStats.max());
	    System.out.printf("References: avg=%.2f, stdDev=%.2f, min=%d, max=%d%n",
	                      refStats.average(), refStats.stdDev(), refStats.min(), refStats.max());
	}

	public StatSummary calculateStats(Collection<Integer> values) {
		int count = values.size();
		if (count == 0) {
			return new StatSummary(0, 0, 0, 0); // or throw exception if preferred
		}

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		double sum = 0;

		for (int v : values) {
			if (v < min) min = v;
			if (v > max) max = v;
			sum += v;
		}

		double avg = sum / count;

		// Calculate variance
		double varianceSum = 0;
		for (int v : values) {
			varianceSum += (v - avg) * (v - avg);
		}
		double stdDev = Math.sqrt(varianceSum / count);

		return new StatSummary(avg, stdDev, min, max);
	}

	private void registerEcore(String ecoreModelPath) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		this.resourceSet = new ResourceSetImpl();
		Resource resource = this.resourceSet.getResource(URI.createFileURI(ecoreModelPath), true);

		// Register the package
		EPackage ePackage = (EPackage) resource.getContents().get(0);
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);

		Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
		Map<String, Object> m = reg.getExtensionToFactoryMap();
		m.put("xmi", new XMIResourceFactoryImpl());		
		m.put("model", new XMIResourceFactoryImpl());	
	}

	private ModelStat processXMIFile(String xmiFilePath) throws Exception{
		File xmiFile = new File(xmiFilePath);
		Resource resource = AssistantUtils.loadModel(this.resourceSet, xmiFile);
		int objectCount = 0;
		int attributeCount = 0;
		int referenceCount = 0;

		// We use a Set to avoid counting the same EObject twice
		Set<EObject> visited = new HashSet<>(resource.getContents());

		for (EObject root : resource.getContents()) {
			visited.add(root);

			TreeIterator<EObject> it = root.eAllContents();
			while (it.hasNext()) {
				visited.add(it.next());
			}
		}

		// Count
		for (EObject eObject : visited) {
			objectCount++;

			EClass eClass = eObject.eClass();

			// --- Count attribute values ---
			for (EAttribute attr : eClass.getEAllAttributes()) {
				if (!attr.isDerived() && !attr.isTransient()) {
					Object value = eObject.eGet(attr);
					if (value != null) {
						if (attr.isMany()) {
							attributeCount += ((java.util.Collection<?>) value).size();
						} else {
							attributeCount++;
						}
					}
				}
			}

			// --- Count actual referenced EObjects ---
			for (EReference ref : eClass.getEAllReferences()) {
				if (!ref.isDerived() && !ref.isTransient()) {
					Object value = eObject.eGet(ref);
					if (value != null) {
						if (ref.isMany()) {
							referenceCount += ((java.util.Collection<?>) value).size();
						} else {
							referenceCount++;
						}
					}
				}
			}
		}

		// Print summary
		System.out.println("==== EMF Resource Statistics for +"+xmiFilePath+"====");		
		System.out.println("Number of objects:    " + objectCount);
		System.out.println("Number of attributes: " + attributeCount);
		System.out.println("Number of references: " + referenceCount);	 
		return new ModelStat(objectCount, attributeCount, referenceCount);
	}

	public static void main(String... args) throws Exception{
		MeasureSeedModelSizes mms = new MeasureSeedModelSizes();
		mms.genMetrics();
	}
}
