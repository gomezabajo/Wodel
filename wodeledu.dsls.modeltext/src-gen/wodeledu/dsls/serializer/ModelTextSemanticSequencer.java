/*
 * generated by Xtext 2.12.0
 */
package wodeledu.dsls.serializer;

import com.google.inject.Inject;
import java.util.Set;
import modeltext.Attribute;
import modeltext.Constant;
import modeltext.Element;
import modeltext.IdentifyElements;
import modeltext.ModeltextPackage;
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
			case ModeltextPackage.ATTRIBUTE:
				sequence_Attribute(context, (Attribute) semanticObject); 
				return; 
			case ModeltextPackage.CONSTANT:
				sequence_Constant(context, (Constant) semanticObject); 
				return; 
			case ModeltextPackage.ELEMENT:
				sequence_Element(context, (Element) semanticObject); 
				return; 
			case ModeltextPackage.IDENTIFY_ELEMENTS:
				sequence_IdentifyElements(context, (IdentifyElements) semanticObject); 
				return; 
			case ModeltextPackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Attribute returns Attribute
	 *
	 * Constraint:
	 *     (negation?='not'? att=[EAttribute|ID])
	 */
	protected void sequence_Attribute(ISerializationContext context, Attribute semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Word returns Constant
	 *     Constant returns Constant
	 *
	 * Constraint:
	 *     value=EString
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
	 * Contexts:
	 *     Element returns Element
	 *
	 * Constraint:
	 *     (type=[EClass|EString] ref=[EReference|ID]? (att+=Attribute att+=Attribute*)? (words+=Word words+=Word*)?)
	 */
	protected void sequence_Element(ISerializationContext context, Element semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     IdentifyElements returns IdentifyElements
	 *
	 * Constraint:
	 *     (metamodel=EString (elements+=Element elements+=Element*)?)
	 */
	protected void sequence_IdentifyElements(ISerializationContext context, IdentifyElements semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Word returns Variable
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     (ref=[EReference|ID]? id=[EAttribute|ID])
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
