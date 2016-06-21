/**
 */
package mutatortests.util;

import mutatortests.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see mutatortests.MutatortestsPackage
 * @generated
 */
public class MutatortestsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MutatortestsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatortestsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MutatortestsPackage.eINSTANCE;
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
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatortestsSwitch<Adapter> modelSwitch =
		new MutatortestsSwitch<Adapter>() {
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
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.MutatorTests <em>Mutator Tests</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.MutatorTests
	 * @generated
	 */
	public Adapter createMutatorTestsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.Configuration
	 * @generated
	 */
	public Adapter createConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.ProgramConfiguration <em>Program Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.ProgramConfiguration
	 * @generated
	 */
	public Adapter createProgramConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.TestConfiguration <em>Test Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.TestConfiguration
	 * @generated
	 */
	public Adapter createTestConfigurationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.MultiChoiceEmConfig <em>Multi Choice Em Config</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.MultiChoiceEmConfig
	 * @generated
	 */
	public Adapter createMultiChoiceEmConfigAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.AlternativeResponse <em>Alternative Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.AlternativeResponse
	 * @generated
	 */
	public Adapter createAlternativeResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.MultiChoiceDiagram <em>Multi Choice Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.MultiChoiceDiagram
	 * @generated
	 */
	public Adapter createMultiChoiceDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.MultiChoiceEmendation <em>Multi Choice Emendation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.MultiChoiceEmendation
	 * @generated
	 */
	public Adapter createMultiChoiceEmendationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatortests.Test <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatortests.Test
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

} //MutatortestsAdapterFactory
