package efinder.emfocl.runner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

import efinder.core.IDialectAdaptation;

public class TransformRegistry {

	private Map<String, List<IDialectAdaptation>> transforms = new HashMap<>();
	
	public void add(@NonNull String backend, IDialectAdaptation... adaptations) {
		transforms.computeIfAbsent(backend, (k) -> new ArrayList<>());
		Collections.addAll(transforms.get(backend), adaptations);
	}
	
	@NonNull
	public List<? extends IDialectAdaptation> get(@NonNull String backend) {
		return transforms.getOrDefault(backend, Collections.emptyList());
	}
	
}
