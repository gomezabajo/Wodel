package wodeledu.model2text.run;

import org.eclipse.core.runtime.IExecutableExtension;

public abstract class Model2Text implements IExecutableExtension {
	
	public abstract String getName();
	
	public abstract String getURI();
	
	public abstract String getId();

	public abstract String getText(String metamodel, String model);
}
