/*
 * generated by Xtext 2.30.0
 */
package wodel.dsls.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractWodelValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://mutatorenvironment/1.0"));
		result.add(EPackage.Registry.INSTANCE.getEPackage("http://www.ac.uk/york/cs/miniocl/MiniOCLCS"));
		return result;
	}
}
