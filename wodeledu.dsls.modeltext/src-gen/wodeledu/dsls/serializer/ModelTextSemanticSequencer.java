/*
 * generated by Xtext 2.30.0
 */
package wodeledu.dsls.serializer;

import com.google.inject.Inject;
import java.util.Set;
import modeltext.Constant;
import modeltext.Element;
import modeltext.IdentifyElements;
import modeltext.Macro;
import modeltext.ModeltextPackage;
import modeltext.ValuedFeature;
import modeltext.Variable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import wodeledu.dsls.services.ModelTextGrammarAccess;

@SuppressWarnings("all")
public class ModelTextSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ModelTextGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ModeltextPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ModeltextPackage.CONSTANT:
				sequence_Constant(context, (Constant) semanticObject); 
				return; 
			case ModeltextPackage.ELEMENT:
				sequence_Element(context, (Element) semanticObject); 
				return; 
			case ModeltextPackage.IDENTIFY_ELEMENTS:
				sequence_IdentifyElements(context, (IdentifyElements) semanticObject); 
				return; 
			case ModeltextPackage.MACRO:
				sequence_Macro(context, (Macro) semanticObject); 
				return; 
			case ModeltextPackage.VALUED_FEATURE:
				sequence_ValuedFeature(context, (ValuedFeature) semanticObject); 
				return; 
			case ModeltextPackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Word returns Constant
	 *     Constant returns Constant
	 *
	 * Constraint:
	 *     value=EString
	 * </pre>
	 */
	protected void sequence_Constant(ISerializationContext context, Constant semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ModeltextPackage.Literals.CONSTANT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModeltextPackage.Literals.CONSTANT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Element returns Element
	 *
	 * Constraint:
	 *     (type=[EClass|EString] ref=[EReference|ID]? (feature+=ValuedFeature feature+=ValuedFeature*)? (words+=Word words+=Word*)?)
	 * </pre>
	 */
	protected void sequence_Element(ISerializationContext context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IdentifyElements returns IdentifyElements
	 *
	 * Constraint:
	 *     (metamodel=EString (elements+=Element elements+=Element*)?)
	 * </pre>
	 */
	protected void sequence_IdentifyElements(ISerializationContext context, IdentifyElements semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Word returns Macro
	 *     Macro returns Macro
	 *
	 * Constraint:
	 *     item=MacroItem
	 * </pre>
	 */
	protected void sequence_Macro(ISerializationContext context, Macro semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, ModeltextPackage.Literals.MACRO__ITEM) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, ModeltextPackage.Literals.MACRO__ITEM));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMacroAccess().getItemMacroItemEnumRuleCall_2_0(), semanticObject.getItem());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     ValuedFeature returns ValuedFeature
	 *
	 * Constraint:
	 *     (negation?='not'? feat=[EStructuralFeature|ID] refFeature=[EStructuralFeature|ID]? value='null'?)
	 * </pre>
	 */
	protected void sequence_ValuedFeature(ISerializationContext context, ValuedFeature semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Word returns Variable
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     (ref=[EReference|ID]? id=[EAttribute|ID])
	 * </pre>
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
