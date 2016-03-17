/**
 *
 * $Id$
 */
package mutatorenvironment.validation;

import mutatorenvironment.ObSelectionStrategy;

import org.eclipse.emf.ecore.EReference;

/**
 * A sample validator interface for {@link mutatorenvironment.RemoveReferenceMutator}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RemoveReferenceMutatorValidator {
	boolean validate();

	boolean validateContainer(ObSelectionStrategy value);
	boolean validateRefType(EReference value);
}
