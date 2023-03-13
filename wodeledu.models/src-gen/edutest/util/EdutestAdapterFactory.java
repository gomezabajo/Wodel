/**
 */
package edutest.util;

import edutest.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see edutest.EdutestPackage
 * @generated
 */
public class EdutestAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EdutestPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EdutestAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = EdutestPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EdutestSwitch<Adapter> modelSwitch = new EdutestSwitch<Adapter>() {
		@Override
		public Adapter caseProgram(Program object) {
			return createProgramAdapter();
		}

		@Override
		public Adapter caseMutatorTests(MutatorTests object) {
			return createMutatorTestsAdapter();
		}

		@Override
		public Adapter caseConfiguration(Configuration object) {
			return createConfigurationAdapter();
		}

		@Override
		public Adapter caseProgramConfiguration(ProgramConfiguration object) {
			return createProgramConfigurationAdapter();
		}

		@Override
		public Adapter caseTestConfiguration(TestConfiguration object) {
			return createTestConfigurationAdapter();
		}

		@Override
		public Adapter caseMultiChoiceEmConfig(MultiChoiceEmConfig object) {
			return createMultiChoiceEmConfigAdapter();
		}

		@Override
		public Adapter caseTextConfiguration(TextConfiguration object) {
			return createTextConfigurationAdapter();
		}

		@Override
		public Adapter caseAlternativeResponse(AlternativeResponse object) {
			return createAlternativeResponseAdapter();
		}

		@Override
		public Adapter caseMultiChoiceDiagram(MultiChoiceDiagram object) {
			return createMultiChoiceDiagramAdapter();
		}

		@Override
		public Adapter caseMultiChoiceEmendation(MultiChoiceEmendation object) {
			return createMultiChoiceEmendationAdapter();
		}

		@Override
		public Adapter caseMatchPairs(MatchPairs object) {
			return createMatchPairsAdapter();
		}

		@Override
		public Adapter caseMissingWords(MissingWords object) {
			return createMissingWordsAdapter();
		}

		@Override
		public Adapter caseMultiChoiceText(MultiChoiceText object) {
			return createMultiChoiceTextAdapter();
		}

		@Override
		public Adapter caseAlternativeText(AlternativeText object) {
			return createAlternativeTextAdapter();
		}

		@Override
		public Adapter caseDragAndDropText(DragAndDropText object) {
			return createDragAndDropTextAdapter();
		}

		@Override
		public Adapter caseTest(Test object) {
			return createTestAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.MutatorTests <em>Mutator Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.MutatorTests
	 * @generated
	 */
	public Adapter createMutatorTestsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.ProgramConfiguration <em>Program Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.ProgramConfiguration
	 * @generated
	 */
	public Adapter createProgramConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.TestConfiguration <em>Test Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.TestConfiguration
	 * @generated
	 */
	public Adapter createTestConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.MultiChoiceEmConfig <em>Multi Choice Em Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.MultiChoiceEmConfig
	 * @generated
	 */
	public Adapter createMultiChoiceEmConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.TextConfiguration <em>Text Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.TextConfiguration
	 * @generated
	 */
	public Adapter createTextConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.AlternativeResponse <em>Alternative Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.AlternativeResponse
	 * @generated
	 */
	public Adapter createAlternativeResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.MultiChoiceDiagram <em>Multi Choice Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.MultiChoiceDiagram
	 * @generated
	 */
	public Adapter createMultiChoiceDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.MultiChoiceEmendation <em>Multi Choice Emendation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.MultiChoiceEmendation
	 * @generated
	 */
	public Adapter createMultiChoiceEmendationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.MatchPairs <em>Match Pairs</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.MatchPairs
	 * @generated
	 */
	public Adapter createMatchPairsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.MissingWords <em>Missing Words</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.MissingWords
	 * @generated
	 */
	public Adapter createMissingWordsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.MultiChoiceText <em>Multi Choice Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.MultiChoiceText
	 * @generated
	 */
	public Adapter createMultiChoiceTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.AlternativeText <em>Alternative Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.AlternativeText
	 * @generated
	 */
	public Adapter createAlternativeTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.DragAndDropText <em>Drag And Drop Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.DragAndDropText
	 * @generated
	 */
	public Adapter createDragAndDropTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link edutest.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see edutest.Test
	 * @generated
	 */
	public Adapter createTestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //EdutestAdapterFactory
