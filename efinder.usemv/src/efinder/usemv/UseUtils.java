package efinder.usemv;

import org.tzi.use.uml.sys.MObject;
import org.tzi.use.uml.sys.MObjectState;
import org.tzi.use.uml.sys.MSystem;
import org.tzi.use.uml.sys.MSystemState;

/**
 * Some utilities
 * 
 * @author jesus
 *
 */
public class UseUtils {

	public static void printModel() {
		
	}

	public static void printModel(MSystem system) {
		MSystemState state = system.state();
		for (MObject mObject : state.allObjects()) {
			System.out.println(mObject.name() + " - " + mObject.cls().name());
			MObjectState s = mObject.state(state);
			s.attributeValueMap().forEach((k, v) -> {
				System.out.println("  - " + k + " = " + v);
			});
		}
		
	}
	
}
