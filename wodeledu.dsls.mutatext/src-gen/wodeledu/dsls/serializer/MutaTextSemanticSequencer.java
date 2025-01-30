/*
 * generated by Xtext 2.36.0
 */
package wodeledu.dsls.serializer;

import com.google.inject.Inject;
import java.util.Set;
import mutatext.Configuration;
import mutatext.Constant;
import mutatext.MutatextPackage;
import mutatext.Option;
import mutatext.Text;
import mutatext.Variable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import wodeledu.dsls.services.MutaTextGrammarAccess;

@SuppressWarnings("all")
public class MutaTextSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MutaTextGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MutatextPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MutatextPackage.CONFIGURATION:
				sequence_Configuration(context, (Configuration) semanticObject); 
				return; 
			case MutatextPackage.CONSTANT:
				sequence_Constant(context, (Constant) semanticObject); 
				return; 
			case MutatextPackage.OPTION:
				sequence_Option(context, (Option) semanticObject); 
				return; 
			case MutatextPackage.TEXT:
				sequence_Text(context, (Text) semanticObject); 
				return; 
			case MutatextPackage.VARIABLE:
				sequence_Variable(context, (Variable) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Configuration returns Configuration
	 *
	 * Constraint:
	 *     (metamodel=EString (options+=Option options+=Option*)?)
	 * </pre>
	 */
	protected void sequence_Configuration(ISerializationContext context, Configuration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
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
			if (transientValues.isValueTransient(semanticObject, MutatextPackage.Literals.CONSTANT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatextPackage.Literals.CONSTANT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Option returns Option
	 *
	 * Constraint:
	 *     (type=[EClass|EString] object=[EObject|EString]? valid=Text invalid=Text)
	 * </pre>
	 */
	protected void sequence_Option(ISerializationContext context, Option semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Text returns Text
	 *
	 * Constraint:
	 *     (words+=Word words+=Word*)?
	 * </pre>
	 */
	protected void sequence_Text(ISerializationContext context, Text semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Word returns Variable
	 *     Variable returns Variable
	 *
	 * Constraint:
	 *     type=VariableType
	 * </pre>
	 */
	protected void sequence_Variable(ISerializationContext context, Variable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MutatextPackage.Literals.VARIABLE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MutatextPackage.Literals.VARIABLE__TYPE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getVariableAccess().getTypeVariableTypeEnumRuleCall_1_0(), semanticObject.getType());
		feeder.finish();
	}
	
	
}
