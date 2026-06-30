package efinder.emfocl.tests;

import java.util.HashMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;

import efinder.core.IBoundsProvider;

public class TestBoundsProvider extends IBoundsProvider.Fixed {

	public TestBoundsProvider() {
		super(5, 20);
	}

	private HashMap<String, Interval> classBounds = new HashMap<>();
	
	public TestBoundsProvider withInterval(@NonNull String className, int min, int max) {
		this.classBounds.put(className, new Interval(min, max));
		return this;
	}
	
	@Override
	public Interval getScope(EClass klass) {
		if (classBounds.containsKey(klass.getName())) {
			return classBounds.get(klass.getName());
		}

		return super.getScope(klass);
	}
	
}
