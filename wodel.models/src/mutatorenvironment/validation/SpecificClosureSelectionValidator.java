/**
 *
 * $Id$
 */
package mutatorenvironment.validation;

import mutatorenvironment.ObjectEmitter;

/**
 * A sample validator interface for {@link mutatorenvironment.SpecificClosureSelection}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SpecificClosureSelectionValidator {
	boolean validate();

	boolean validateObjSel(ObjectEmitter value);
}
