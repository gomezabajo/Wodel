/**
 */
package edutest.util;

import edutest.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edutest.EdutestPackage
 * @generated
 */
public class EdutestSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EdutestPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdutestSwitch() {
		if (modelPackage == null) {
			modelPackage = EdutestPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case EdutestPackage.PROGRAM: {
				Program program = (Program)theEObject;
				T result = caseProgram(program);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.MUTATOR_TESTS: {
				MutatorTests mutatorTests = (MutatorTests)theEObject;
				T result = caseMutatorTests(mutatorTests);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.CONFIGURATION: {
				Configuration configuration = (Configuration)theEObject;
				T result = caseConfiguration(configuration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.PROGRAM_CONFIGURATION: {
				ProgramConfiguration programConfiguration = (ProgramConfiguration)theEObject;
				T result = caseProgramConfiguration(programConfiguration);
				if (result == null) result = caseConfiguration(programConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.TEST_CONFIGURATION: {
				TestConfiguration testConfiguration = (TestConfiguration)theEObject;
				T result = caseTestConfiguration(testConfiguration);
				if (result == null) result = caseConfiguration(testConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.MULTI_CHOICE_EM_CONFIG: {
				MultiChoiceEmConfig multiChoiceEmConfig = (MultiChoiceEmConfig)theEObject;
				T result = caseMultiChoiceEmConfig(multiChoiceEmConfig);
				if (result == null) result = caseTestConfiguration(multiChoiceEmConfig);
				if (result == null) result = caseConfiguration(multiChoiceEmConfig);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.ALTERNATIVE_RESPONSE: {
				AlternativeResponse alternativeResponse = (AlternativeResponse)theEObject;
				T result = caseAlternativeResponse(alternativeResponse);
				if (result == null) result = caseMutatorTests(alternativeResponse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.MULTI_CHOICE_DIAGRAM: {
				MultiChoiceDiagram multiChoiceDiagram = (MultiChoiceDiagram)theEObject;
				T result = caseMultiChoiceDiagram(multiChoiceDiagram);
				if (result == null) result = caseMutatorTests(multiChoiceDiagram);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.MULTI_CHOICE_EMENDATION: {
				MultiChoiceEmendation multiChoiceEmendation = (MultiChoiceEmendation)theEObject;
				T result = caseMultiChoiceEmendation(multiChoiceEmendation);
				if (result == null) result = caseMutatorTests(multiChoiceEmendation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.MATCH_PAIRS: {
				MatchPairs matchPairs = (MatchPairs)theEObject;
				T result = caseMatchPairs(matchPairs);
				if (result == null) result = caseMutatorTests(matchPairs);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.MISSING_WORDS: {
				MissingWords missingWords = (MissingWords)theEObject;
				T result = caseMissingWords(missingWords);
				if (result == null) result = caseMutatorTests(missingWords);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EdutestPackage.TEST: {
				Test test = (Test)theEObject;
				T result = caseTest(test);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutator Tests</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutator Tests</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutatorTests(MutatorTests object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgramConfiguration(ProgramConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTestConfiguration(TestConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Choice Em Config</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Choice Em Config</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiChoiceEmConfig(MultiChoiceEmConfig object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Alternative Response</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Alternative Response</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlternativeResponse(AlternativeResponse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Choice Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Choice Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiChoiceDiagram(MultiChoiceDiagram object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Choice Emendation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Choice Emendation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiChoiceEmendation(MultiChoiceEmendation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Pairs</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Pairs</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchPairs(MatchPairs object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Missing Words</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Missing Words</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMissingWords(MissingWords object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTest(Test object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //EdutestSwitch
