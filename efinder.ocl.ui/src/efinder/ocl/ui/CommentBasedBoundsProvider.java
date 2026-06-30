package efinder.ocl.ui;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.eclipse.ocl.xtext.completeoclcs.PackageDeclarationCS;

import efinder.core.IBoundsProvider;

public class CommentBasedBoundsProvider implements IBoundsProvider {

	private Map<String, Interval> bounds = new HashMap<>();
	
	public CommentBasedBoundsProvider(CompleteOCLDocumentCS doc) {
		for (PackageDeclarationCS pkg : doc.getOwnedPackages()) {
			extractBounds(pkg);
		}
	}

	public boolean hasBounds() {
		return ! bounds.isEmpty();
	}
	
	private void extractBounds(PackageDeclarationCS pkg) {
		String text = pkg.toString();
		BufferedReader reader = new BufferedReader(new StringReader(text));
		reader.lines().filter(l -> l.contains("@bounds")).forEach(l -> extractBounds(l));
	}

	private void extractBounds(String l) {
		Pattern regexp = Pattern.compile("bounds\\s+(\\w+)\\s+([0-9]+)\\.\\.([0-9]+)");
		Matcher matcher = regexp.matcher(l);
		if (matcher.find()) {
			String className = matcher.group(1);
			int min = Integer.parseInt(matcher.group(2));
			int max = Integer.parseInt(matcher.group(3));

			//EClassifier klass = packages.stream().filter(p -> p.getEClassifier(className) != null)
			//		.map(p -> p.getEClassifier(className)).findFirst()
			//		.orElseThrow(() -> new RuntimeException("Cannot find : " + className));

			addBound(className, min, max); 
		}
	}

	private void addBound(String className, int min, int max) {
		bounds.put(className, new Interval(min, max));
	}

	@Override
	public Interval getScope(EClass klass) {
		Interval interval = bounds.get(klass.getName());
		if (interval != null)
			return interval;
		
		return new Interval(0, 5);
	}

	@Override
	public Interval getScope(EReference feature) {
		return new Interval(0, 20);
	}

	@Override
	public int getDefaultMaxScope() {
		return 5;
	}

	@Override
	public boolean incrementScope() {
		return false;
	}
	
}
