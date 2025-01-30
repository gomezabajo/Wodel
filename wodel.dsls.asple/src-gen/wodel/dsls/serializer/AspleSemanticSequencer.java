/*
 * generated by Xtext 2.37.0
 */
package wodel.dsls.serializer;

import asple.AsplePackage;
import asple.Assignment;
import asple.BinaryOperator;
import asple.Conditional;
import asple.Declaration;
import asple.Identifier;
import asple.Loop;
import asple.Program;
import asple.Transput;
import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import wodel.dsls.services.ASPLEGrammarAccess;

@SuppressWarnings("all")
public class ASPLESemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private ASPLEGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AsplePackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AsplePackage.ASSIGNMENT:
				sequence_Assignment(context, (Assignment) semanticObject); 
				return; 
			case AsplePackage.BINARY_OPERATOR:
				sequence_BinaryOperator(context, (BinaryOperator) semanticObject); 
				return; 
			case AsplePackage.BOOLEAN:
				sequence_Boolean(context, (asple.Boolean) semanticObject); 
				return; 
			case AsplePackage.CONDITIONAL:
				sequence_Conditional(context, (Conditional) semanticObject); 
				return; 
			case AsplePackage.DECLARATION:
				sequence_Declaration(context, (Declaration) semanticObject); 
				return; 
			case AsplePackage.DOUBLE:
				sequence_Double(context, (asple.Double) semanticObject); 
				return; 
			case AsplePackage.IDENTIFIER:
				sequence_Identifier(context, (Identifier) semanticObject); 
				return; 
			case AsplePackage.INTEGER:
				sequence_Integer(context, (asple.Integer) semanticObject); 
				return; 
			case AsplePackage.LOOP:
				sequence_Loop(context, (Loop) semanticObject); 
				return; 
			case AsplePackage.PROGRAM:
				sequence_Program(context, (Program) semanticObject); 
				return; 
			case AsplePackage.TRANSPUT:
				sequence_Transput(context, (Transput) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns Assignment
	 *     Assignment returns Assignment
	 *
	 * Constraint:
	 *     (var=[Identifier|ID] value=Expression)
	 * </pre>
	 */
	protected void sequence_Assignment(ISerializationContext context, Assignment semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.ASSIGNMENT__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.ASSIGNMENT__VAR));
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.ASSIGNMENT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.ASSIGNMENT__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAssignmentAccess().getVarIdentifierIDTerminalRuleCall_0_0_1(), semanticObject.eGet(AsplePackage.Literals.ASSIGNMENT__VAR, false));
		feeder.accept(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns BinaryOperator
	 *     BinaryOperator returns BinaryOperator
	 *
	 * Constraint:
	 *     (
	 *         left=Primary 
	 *         (
	 *             operator='+' | 
	 *             operator='-' | 
	 *             operator='*' | 
	 *             operator='/' | 
	 *             operator='%' | 
	 *             operator='==' | 
	 *             operator='!=' | 
	 *             operator='&gt;' | 
	 *             operator='&lt;'
	 *         ) 
	 *         right=Expression
	 *     )
	 * </pre>
	 */
	protected void sequence_BinaryOperator(ISerializationContext context, BinaryOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Literal returns Boolean
	 *     Boolean returns Boolean
	 *     Expression returns Boolean
	 *     Primary returns Boolean
	 *
	 * Constraint:
	 *     value=EBoolean
	 * </pre>
	 */
	protected void sequence_Boolean(ISerializationContext context, asple.Boolean semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.BOOLEAN__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.BOOLEAN__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBooleanAccess().getValueEBooleanParserRuleCall_1_0(), semanticObject.isValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns Conditional
	 *     Conditional returns Conditional
	 *
	 * Constraint:
	 *     (expression=Expression if+=Statement* else+=Statement*)
	 * </pre>
	 */
	protected void sequence_Conditional(ISerializationContext context, Conditional semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Declaration returns Declaration
	 *
	 * Constraint:
	 *     (ref?='ref'? mode=Mode? identifiers+=Identifier identifiers+=Identifier*)
	 * </pre>
	 */
	protected void sequence_Declaration(ISerializationContext context, Declaration semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Literal returns Double
	 *     Double returns Double
	 *     Expression returns Double
	 *     Primary returns Double
	 *
	 * Constraint:
	 *     value=EDouble
	 * </pre>
	 */
	protected void sequence_Double(ISerializationContext context, asple.Double semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.DOUBLE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.DOUBLE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDoubleAccess().getValueEDoubleParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Identifier returns Identifier
	 *     Expression returns Identifier
	 *     Primary returns Identifier
	 *
	 * Constraint:
	 *     name=EString
	 * </pre>
	 */
	protected void sequence_Identifier(ISerializationContext context, Identifier semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.IDENTIFIER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.IDENTIFIER__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIdentifierAccess().getNameEStringParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Literal returns Integer
	 *     Integer returns Integer
	 *     Expression returns Integer
	 *     Primary returns Integer
	 *
	 * Constraint:
	 *     value=EInt
	 * </pre>
	 */
	protected void sequence_Integer(ISerializationContext context, asple.Integer semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.INTEGER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.INTEGER__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntegerAccess().getValueEIntParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns Loop
	 *     Loop returns Loop
	 *
	 * Constraint:
	 *     ((expression=Expression statements+=Statement*) | (statements+=Statement* expression=Expression))
	 * </pre>
	 */
	protected void sequence_Loop(ISerializationContext context, Loop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Program returns Program
	 *
	 * Constraint:
	 *     (declarations+=Declaration* statements+=Statement*)
	 * </pre>
	 */
	protected void sequence_Program(ISerializationContext context, Program semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Statement returns Transput
	 *     Transput returns Transput
	 *
	 * Constraint:
	 *     (var=[Identifier|ID] expression=Expression)
	 * </pre>
	 */
	protected void sequence_Transput(ISerializationContext context, Transput semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.TRANSPUT__VAR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.TRANSPUT__VAR));
			if (transientValues.isValueTransient(semanticObject, AsplePackage.Literals.TRANSPUT__EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AsplePackage.Literals.TRANSPUT__EXPRESSION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTransputAccess().getVarIdentifierIDTerminalRuleCall_2_0_1(), semanticObject.eGet(AsplePackage.Literals.TRANSPUT__VAR, false));
		feeder.accept(grammarAccess.getTransputAccess().getExpressionExpressionParserRuleCall_4_0(), semanticObject.getExpression());
		feeder.finish();
	}
	
	
}
