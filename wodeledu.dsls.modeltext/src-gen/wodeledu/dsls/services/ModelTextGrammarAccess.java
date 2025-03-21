/*
 * generated by Xtext 2.38.0
 */
package wodeledu.dsls.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class ModelTextGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class IdentifyElementsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.IdentifyElements");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cIdentifyElementsAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cMetamodelKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cMetamodelAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMetamodelEStringParserRuleCall_2_0 = (RuleCall)cMetamodelAssignment_2.eContents().get(0);
		private final Assignment cInstancesAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final RuleCall cInstancesMutatorInstanceParserRuleCall_3_0 = (RuleCall)cInstancesAssignment_3.eContents().get(0);
		
		//IdentifyElements returns IdentifyElements:
		//    {IdentifyElements}
		//    'metamodel' metamodel=EString
		//    (instances+=MutatorInstance)+
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{IdentifyElements}
		//'metamodel' metamodel=EString
		//(instances+=MutatorInstance)+
		public Group getGroup() { return cGroup; }
		
		//{IdentifyElements}
		public Action getIdentifyElementsAction_0() { return cIdentifyElementsAction_0; }
		
		//'metamodel'
		public Keyword getMetamodelKeyword_1() { return cMetamodelKeyword_1; }
		
		//metamodel=EString
		public Assignment getMetamodelAssignment_2() { return cMetamodelAssignment_2; }
		
		//EString
		public RuleCall getMetamodelEStringParserRuleCall_2_0() { return cMetamodelEStringParserRuleCall_2_0; }
		
		//(instances+=MutatorInstance)+
		public Assignment getInstancesAssignment_3() { return cInstancesAssignment_3; }
		
		//MutatorInstance
		public RuleCall getInstancesMutatorInstanceParserRuleCall_3_0() { return cInstancesMutatorInstanceParserRuleCall_3_0; }
	}
	public class MutatorInstanceElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.MutatorInstance");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMutatorInstanceAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final CrossReference cNameEClassCrossReference_1_0 = (CrossReference)cNameAssignment_1.eContents().get(0);
		private final RuleCall cNameEClassIDTerminalRuleCall_1_0_1 = (RuleCall)cNameEClassCrossReference_1_0.eContents().get(1);
		private final Keyword cLeftCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Assignment cElementsAssignment_3_0 = (Assignment)cGroup_3.eContents().get(0);
		private final RuleCall cElementsElementParserRuleCall_3_0_0 = (RuleCall)cElementsAssignment_3_0.eContents().get(0);
		private final Assignment cElementsAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final RuleCall cElementsElementParserRuleCall_3_1_0 = (RuleCall)cElementsAssignment_3_1.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_4 = (Keyword)cGroup.eContents().get(4);
		
		//MutatorInstance returns MutatorInstance:
		//    {MutatorInstance}
		//    name=[ecore::EClass|ID]
		//    '{'
		//    (elements+=Element (elements+=Element)*)?
		//    '}'
		//    ;
		@Override public ParserRule getRule() { return rule; }
		
		//{MutatorInstance}
		//name=[ecore::EClass|ID]
		//'{'
		//(elements+=Element (elements+=Element)*)?
		//'}'
		public Group getGroup() { return cGroup; }
		
		//{MutatorInstance}
		public Action getMutatorInstanceAction_0() { return cMutatorInstanceAction_0; }
		
		//name=[ecore::EClass|ID]
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }
		
		//[ecore::EClass|ID]
		public CrossReference getNameEClassCrossReference_1_0() { return cNameEClassCrossReference_1_0; }
		
		//ID
		public RuleCall getNameEClassIDTerminalRuleCall_1_0_1() { return cNameEClassIDTerminalRuleCall_1_0_1; }
		
		//'{'
		public Keyword getLeftCurlyBracketKeyword_2() { return cLeftCurlyBracketKeyword_2; }
		
		//(elements+=Element (elements+=Element)*)?
		public Group getGroup_3() { return cGroup_3; }
		
		//elements+=Element
		public Assignment getElementsAssignment_3_0() { return cElementsAssignment_3_0; }
		
		//Element
		public RuleCall getElementsElementParserRuleCall_3_0_0() { return cElementsElementParserRuleCall_3_0_0; }
		
		//(elements+=Element)*
		public Assignment getElementsAssignment_3_1() { return cElementsAssignment_3_1; }
		
		//Element
		public RuleCall getElementsElementParserRuleCall_3_1_0() { return cElementsElementParserRuleCall_3_1_0; }
		
		//'}'
		public Keyword getRightCurlyBracketKeyword_4() { return cRightCurlyBracketKeyword_4; }
	}
	public class EStringElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.EString");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//EString returns ecore::EString:
		//    STRING | ID;
		@Override public ParserRule getRule() { return rule; }
		
		//STRING | ID
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//STRING
		public RuleCall getSTRINGTerminalRuleCall_0() { return cSTRINGTerminalRuleCall_0; }
		
		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }
	}
	public class ElementElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.Element");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cElementAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cGreaterThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cTypeAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cTypeEClassCrossReference_2_0 = (CrossReference)cTypeAssignment_2.eContents().get(0);
		private final RuleCall cTypeEClassEStringParserRuleCall_2_0_1 = (RuleCall)cTypeEClassCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cFullStopKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cRefAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cRefEReferenceCrossReference_3_1_0 = (CrossReference)cRefAssignment_3_1.eContents().get(0);
		private final RuleCall cRefEReferenceIDTerminalRuleCall_3_1_0_1 = (RuleCall)cRefEReferenceCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cLeftParenthesisKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cFeatureAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final RuleCall cFeatureValuedFeatureParserRuleCall_4_1_0 = (RuleCall)cFeatureAssignment_4_1.eContents().get(0);
		private final Group cGroup_4_2 = (Group)cGroup_4.eContents().get(2);
		private final Keyword cCommaKeyword_4_2_0 = (Keyword)cGroup_4_2.eContents().get(0);
		private final Assignment cFeatureAssignment_4_2_1 = (Assignment)cGroup_4_2.eContents().get(1);
		private final RuleCall cFeatureValuedFeatureParserRuleCall_4_2_1_0 = (RuleCall)cFeatureAssignment_4_2_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_4_3 = (Keyword)cGroup_4.eContents().get(3);
		private final Keyword cColonKeyword_5 = (Keyword)cGroup.eContents().get(5);
		private final Group cGroup_6 = (Group)cGroup.eContents().get(6);
		private final Assignment cWordsAssignment_6_0 = (Assignment)cGroup_6.eContents().get(0);
		private final RuleCall cWordsWordParserRuleCall_6_0_0 = (RuleCall)cWordsAssignment_6_0.eContents().get(0);
		private final Assignment cWordsAssignment_6_1 = (Assignment)cGroup_6.eContents().get(1);
		private final RuleCall cWordsWordParserRuleCall_6_1_0 = (RuleCall)cWordsAssignment_6_1.eContents().get(0);
		
		//Element returns Element:
		//    {Element}
		//    '>' type=[ecore::EClass|EString] ('.' ref=[ecore::EReference|ID])? ('(' feature+=ValuedFeature (',' feature+=ValuedFeature)* ')')? ':' ((words+=Word) (words+=Word)*)?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{Element}
		//'>' type=[ecore::EClass|EString] ('.' ref=[ecore::EReference|ID])? ('(' feature+=ValuedFeature (',' feature+=ValuedFeature)* ')')? ':' ((words+=Word) (words+=Word)*)?
		public Group getGroup() { return cGroup; }
		
		//{Element}
		public Action getElementAction_0() { return cElementAction_0; }
		
		//'>'
		public Keyword getGreaterThanSignKeyword_1() { return cGreaterThanSignKeyword_1; }
		
		//type=[ecore::EClass|EString]
		public Assignment getTypeAssignment_2() { return cTypeAssignment_2; }
		
		//[ecore::EClass|EString]
		public CrossReference getTypeEClassCrossReference_2_0() { return cTypeEClassCrossReference_2_0; }
		
		//EString
		public RuleCall getTypeEClassEStringParserRuleCall_2_0_1() { return cTypeEClassEStringParserRuleCall_2_0_1; }
		
		//('.' ref=[ecore::EReference|ID])?
		public Group getGroup_3() { return cGroup_3; }
		
		//'.'
		public Keyword getFullStopKeyword_3_0() { return cFullStopKeyword_3_0; }
		
		//ref=[ecore::EReference|ID]
		public Assignment getRefAssignment_3_1() { return cRefAssignment_3_1; }
		
		//[ecore::EReference|ID]
		public CrossReference getRefEReferenceCrossReference_3_1_0() { return cRefEReferenceCrossReference_3_1_0; }
		
		//ID
		public RuleCall getRefEReferenceIDTerminalRuleCall_3_1_0_1() { return cRefEReferenceIDTerminalRuleCall_3_1_0_1; }
		
		//('(' feature+=ValuedFeature (',' feature+=ValuedFeature)* ')')?
		public Group getGroup_4() { return cGroup_4; }
		
		//'('
		public Keyword getLeftParenthesisKeyword_4_0() { return cLeftParenthesisKeyword_4_0; }
		
		//feature+=ValuedFeature
		public Assignment getFeatureAssignment_4_1() { return cFeatureAssignment_4_1; }
		
		//ValuedFeature
		public RuleCall getFeatureValuedFeatureParserRuleCall_4_1_0() { return cFeatureValuedFeatureParserRuleCall_4_1_0; }
		
		//(',' feature+=ValuedFeature)*
		public Group getGroup_4_2() { return cGroup_4_2; }
		
		//','
		public Keyword getCommaKeyword_4_2_0() { return cCommaKeyword_4_2_0; }
		
		//feature+=ValuedFeature
		public Assignment getFeatureAssignment_4_2_1() { return cFeatureAssignment_4_2_1; }
		
		//ValuedFeature
		public RuleCall getFeatureValuedFeatureParserRuleCall_4_2_1_0() { return cFeatureValuedFeatureParserRuleCall_4_2_1_0; }
		
		//')'
		public Keyword getRightParenthesisKeyword_4_3() { return cRightParenthesisKeyword_4_3; }
		
		//':'
		public Keyword getColonKeyword_5() { return cColonKeyword_5; }
		
		//((words+=Word) (words+=Word)*)?
		public Group getGroup_6() { return cGroup_6; }
		
		//(words+=Word)
		public Assignment getWordsAssignment_6_0() { return cWordsAssignment_6_0; }
		
		//Word
		public RuleCall getWordsWordParserRuleCall_6_0_0() { return cWordsWordParserRuleCall_6_0_0; }
		
		//(words+=Word)*
		public Assignment getWordsAssignment_6_1() { return cWordsAssignment_6_1; }
		
		//Word
		public RuleCall getWordsWordParserRuleCall_6_1_0() { return cWordsWordParserRuleCall_6_1_0; }
	}
	public class ValuedFeatureElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.ValuedFeature");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cValuedFeatureAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNegationAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Keyword cNegationNotKeyword_1_0 = (Keyword)cNegationAssignment_1.eContents().get(0);
		private final Assignment cFeatAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final CrossReference cFeatEStructuralFeatureCrossReference_2_0 = (CrossReference)cFeatAssignment_2.eContents().get(0);
		private final RuleCall cFeatEStructuralFeatureIDTerminalRuleCall_2_0_1 = (RuleCall)cFeatEStructuralFeatureCrossReference_2_0.eContents().get(1);
		private final Group cGroup_3 = (Group)cGroup.eContents().get(3);
		private final Keyword cHyphenMinusGreaterThanSignKeyword_3_0 = (Keyword)cGroup_3.eContents().get(0);
		private final Assignment cRefFeatureAssignment_3_1 = (Assignment)cGroup_3.eContents().get(1);
		private final CrossReference cRefFeatureEStructuralFeatureCrossReference_3_1_0 = (CrossReference)cRefFeatureAssignment_3_1.eContents().get(0);
		private final RuleCall cRefFeatureEStructuralFeatureIDTerminalRuleCall_3_1_0_1 = (RuleCall)cRefFeatureEStructuralFeatureCrossReference_3_1_0.eContents().get(1);
		private final Group cGroup_4 = (Group)cGroup.eContents().get(4);
		private final Keyword cEqualsSignEqualsSignKeyword_4_0 = (Keyword)cGroup_4.eContents().get(0);
		private final Assignment cValueAssignment_4_1 = (Assignment)cGroup_4.eContents().get(1);
		private final Keyword cValueNullKeyword_4_1_0 = (Keyword)cValueAssignment_4_1.eContents().get(0);
		
		//ValuedFeature returns ValuedFeature:
		//    {ValuedFeature}
		//    (negation?='not')? feat=[ecore::EStructuralFeature|ID] ('->' refFeature=[ecore::EStructuralFeature|ID])? ('==' value='null')?
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{ValuedFeature}
		//(negation?='not')? feat=[ecore::EStructuralFeature|ID] ('->' refFeature=[ecore::EStructuralFeature|ID])? ('==' value='null')?
		public Group getGroup() { return cGroup; }
		
		//{ValuedFeature}
		public Action getValuedFeatureAction_0() { return cValuedFeatureAction_0; }
		
		//(negation?='not')?
		public Assignment getNegationAssignment_1() { return cNegationAssignment_1; }
		
		//'not'
		public Keyword getNegationNotKeyword_1_0() { return cNegationNotKeyword_1_0; }
		
		//feat=[ecore::EStructuralFeature|ID]
		public Assignment getFeatAssignment_2() { return cFeatAssignment_2; }
		
		//[ecore::EStructuralFeature|ID]
		public CrossReference getFeatEStructuralFeatureCrossReference_2_0() { return cFeatEStructuralFeatureCrossReference_2_0; }
		
		//ID
		public RuleCall getFeatEStructuralFeatureIDTerminalRuleCall_2_0_1() { return cFeatEStructuralFeatureIDTerminalRuleCall_2_0_1; }
		
		//('->' refFeature=[ecore::EStructuralFeature|ID])?
		public Group getGroup_3() { return cGroup_3; }
		
		//'->'
		public Keyword getHyphenMinusGreaterThanSignKeyword_3_0() { return cHyphenMinusGreaterThanSignKeyword_3_0; }
		
		//refFeature=[ecore::EStructuralFeature|ID]
		public Assignment getRefFeatureAssignment_3_1() { return cRefFeatureAssignment_3_1; }
		
		//[ecore::EStructuralFeature|ID]
		public CrossReference getRefFeatureEStructuralFeatureCrossReference_3_1_0() { return cRefFeatureEStructuralFeatureCrossReference_3_1_0; }
		
		//ID
		public RuleCall getRefFeatureEStructuralFeatureIDTerminalRuleCall_3_1_0_1() { return cRefFeatureEStructuralFeatureIDTerminalRuleCall_3_1_0_1; }
		
		//('==' value='null')?
		public Group getGroup_4() { return cGroup_4; }
		
		//'=='
		public Keyword getEqualsSignEqualsSignKeyword_4_0() { return cEqualsSignEqualsSignKeyword_4_0; }
		
		//value='null'
		public Assignment getValueAssignment_4_1() { return cValueAssignment_4_1; }
		
		//'null'
		public Keyword getValueNullKeyword_4_1_0() { return cValueNullKeyword_4_1_0; }
	}
	public class WordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.Word");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cConstantParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cVariableParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cMacroParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		
		//Word returns Word:
		//    Constant | Variable | Macro
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//Constant | Variable | Macro
		public Alternatives getAlternatives() { return cAlternatives; }
		
		//Constant
		public RuleCall getConstantParserRuleCall_0() { return cConstantParserRuleCall_0; }
		
		//Variable
		public RuleCall getVariableParserRuleCall_1() { return cVariableParserRuleCall_1; }
		
		//Macro
		public RuleCall getMacroParserRuleCall_2() { return cMacroParserRuleCall_2; }
	}
	public class ConstantElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.Constant");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cConstantAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueEStringParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//Constant returns Constant:
		//    {Constant}
		//    value=EString
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{Constant}
		//value=EString
		public Group getGroup() { return cGroup; }
		
		//{Constant}
		public Action getConstantAction_0() { return cConstantAction_0; }
		
		//value=EString
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }
		
		//EString
		public RuleCall getValueEStringParserRuleCall_1_0() { return cValueEStringParserRuleCall_1_0; }
	}
	public class VariableElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.Variable");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cVariableAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cPercentSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Group cGroup_2 = (Group)cGroup.eContents().get(2);
		private final Assignment cRefAssignment_2_0 = (Assignment)cGroup_2.eContents().get(0);
		private final CrossReference cRefEReferenceCrossReference_2_0_0 = (CrossReference)cRefAssignment_2_0.eContents().get(0);
		private final RuleCall cRefEReferenceIDTerminalRuleCall_2_0_0_1 = (RuleCall)cRefEReferenceCrossReference_2_0_0.eContents().get(1);
		private final Keyword cFullStopKeyword_2_1 = (Keyword)cGroup_2.eContents().get(1);
		private final Assignment cIdAssignment_3 = (Assignment)cGroup.eContents().get(3);
		private final CrossReference cIdEAttributeCrossReference_3_0 = (CrossReference)cIdAssignment_3.eContents().get(0);
		private final RuleCall cIdEAttributeIDTerminalRuleCall_3_0_1 = (RuleCall)cIdEAttributeCrossReference_3_0.eContents().get(1);
		
		//Variable returns Variable:
		//    {Variable}
		//    '%'(ref=[ecore::EReference]'.')?id=[ecore::EAttribute]
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{Variable}
		//'%'(ref=[ecore::EReference]'.')?id=[ecore::EAttribute]
		public Group getGroup() { return cGroup; }
		
		//{Variable}
		public Action getVariableAction_0() { return cVariableAction_0; }
		
		//'%'
		public Keyword getPercentSignKeyword_1() { return cPercentSignKeyword_1; }
		
		//(ref=[ecore::EReference]'.')?
		public Group getGroup_2() { return cGroup_2; }
		
		//ref=[ecore::EReference]
		public Assignment getRefAssignment_2_0() { return cRefAssignment_2_0; }
		
		//[ecore::EReference]
		public CrossReference getRefEReferenceCrossReference_2_0_0() { return cRefEReferenceCrossReference_2_0_0; }
		
		//ID
		public RuleCall getRefEReferenceIDTerminalRuleCall_2_0_0_1() { return cRefEReferenceIDTerminalRuleCall_2_0_0_1; }
		
		//'.'
		public Keyword getFullStopKeyword_2_1() { return cFullStopKeyword_2_1; }
		
		//id=[ecore::EAttribute]
		public Assignment getIdAssignment_3() { return cIdAssignment_3; }
		
		//[ecore::EAttribute]
		public CrossReference getIdEAttributeCrossReference_3_0() { return cIdEAttributeCrossReference_3_0; }
		
		//ID
		public RuleCall getIdEAttributeIDTerminalRuleCall_3_0_1() { return cIdEAttributeIDTerminalRuleCall_3_0_1; }
	}
	public class MacroElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.Macro");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cMacroAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cPercentSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cItemAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cItemMacroItemEnumRuleCall_2_0 = (RuleCall)cItemAssignment_2.eContents().get(0);
		
		//Macro returns Macro:
		//    {Macro}
		//    '%' item = MacroItem
		//;
		@Override public ParserRule getRule() { return rule; }
		
		//{Macro}
		//'%' item = MacroItem
		public Group getGroup() { return cGroup; }
		
		//{Macro}
		public Action getMacroAction_0() { return cMacroAction_0; }
		
		//'%'
		public Keyword getPercentSignKeyword_1() { return cPercentSignKeyword_1; }
		
		//item = MacroItem
		public Assignment getItemAssignment_2() { return cItemAssignment_2; }
		
		//MacroItem
		public RuleCall getItemMacroItemEnumRuleCall_2_0() { return cItemMacroItemEnumRuleCall_2_0; }
	}
	
	public class MacroItemElements extends AbstractElementFinder.AbstractEnumRuleElementFinder {
		private final EnumRule rule = (EnumRule) GrammarUtil.findRuleForName(getGrammar(), "wodeledu.dsls.ModelText.MacroItem");
		private final EnumLiteralDeclaration cTypeEnumLiteralDeclaration = (EnumLiteralDeclaration)rule.eContents().get(1);
		private final Keyword cTypeTypeKeyword_0 = (Keyword)cTypeEnumLiteralDeclaration.eContents().get(0);
		
		//enum MacroItem returns MacroItem:
		//    type = 'type';
		public EnumRule getRule() { return rule; }
		
		//type = 'type'
		public EnumLiteralDeclaration getTypeEnumLiteralDeclaration() { return cTypeEnumLiteralDeclaration; }
		
		//'type'
		public Keyword getTypeTypeKeyword_0() { return cTypeTypeKeyword_0; }
	}
	
	private final IdentifyElementsElements pIdentifyElements;
	private final MutatorInstanceElements pMutatorInstance;
	private final EStringElements pEString;
	private final ElementElements pElement;
	private final ValuedFeatureElements pValuedFeature;
	private final WordElements pWord;
	private final ConstantElements pConstant;
	private final VariableElements pVariable;
	private final MacroElements pMacro;
	private final MacroItemElements eMacroItem;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public ModelTextGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pIdentifyElements = new IdentifyElementsElements();
		this.pMutatorInstance = new MutatorInstanceElements();
		this.pEString = new EStringElements();
		this.pElement = new ElementElements();
		this.pValuedFeature = new ValuedFeatureElements();
		this.pWord = new WordElements();
		this.pConstant = new ConstantElements();
		this.pVariable = new VariableElements();
		this.pMacro = new MacroElements();
		this.eMacroItem = new MacroItemElements();
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("wodeledu.dsls.ModelText".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//IdentifyElements returns IdentifyElements:
	//    {IdentifyElements}
	//    'metamodel' metamodel=EString
	//    (instances+=MutatorInstance)+
	//;
	public IdentifyElementsElements getIdentifyElementsAccess() {
		return pIdentifyElements;
	}
	
	public ParserRule getIdentifyElementsRule() {
		return getIdentifyElementsAccess().getRule();
	}
	
	//MutatorInstance returns MutatorInstance:
	//    {MutatorInstance}
	//    name=[ecore::EClass|ID]
	//    '{'
	//    (elements+=Element (elements+=Element)*)?
	//    '}'
	//    ;
	public MutatorInstanceElements getMutatorInstanceAccess() {
		return pMutatorInstance;
	}
	
	public ParserRule getMutatorInstanceRule() {
		return getMutatorInstanceAccess().getRule();
	}
	
	//EString returns ecore::EString:
	//    STRING | ID;
	public EStringElements getEStringAccess() {
		return pEString;
	}
	
	public ParserRule getEStringRule() {
		return getEStringAccess().getRule();
	}
	
	//Element returns Element:
	//    {Element}
	//    '>' type=[ecore::EClass|EString] ('.' ref=[ecore::EReference|ID])? ('(' feature+=ValuedFeature (',' feature+=ValuedFeature)* ')')? ':' ((words+=Word) (words+=Word)*)?
	//;
	public ElementElements getElementAccess() {
		return pElement;
	}
	
	public ParserRule getElementRule() {
		return getElementAccess().getRule();
	}
	
	//ValuedFeature returns ValuedFeature:
	//    {ValuedFeature}
	//    (negation?='not')? feat=[ecore::EStructuralFeature|ID] ('->' refFeature=[ecore::EStructuralFeature|ID])? ('==' value='null')?
	//;
	public ValuedFeatureElements getValuedFeatureAccess() {
		return pValuedFeature;
	}
	
	public ParserRule getValuedFeatureRule() {
		return getValuedFeatureAccess().getRule();
	}
	
	//Word returns Word:
	//    Constant | Variable | Macro
	//;
	public WordElements getWordAccess() {
		return pWord;
	}
	
	public ParserRule getWordRule() {
		return getWordAccess().getRule();
	}
	
	//Constant returns Constant:
	//    {Constant}
	//    value=EString
	//;
	public ConstantElements getConstantAccess() {
		return pConstant;
	}
	
	public ParserRule getConstantRule() {
		return getConstantAccess().getRule();
	}
	
	//Variable returns Variable:
	//    {Variable}
	//    '%'(ref=[ecore::EReference]'.')?id=[ecore::EAttribute]
	//;
	public VariableElements getVariableAccess() {
		return pVariable;
	}
	
	public ParserRule getVariableRule() {
		return getVariableAccess().getRule();
	}
	
	//Macro returns Macro:
	//    {Macro}
	//    '%' item = MacroItem
	//;
	public MacroElements getMacroAccess() {
		return pMacro;
	}
	
	public ParserRule getMacroRule() {
		return getMacroAccess().getRule();
	}
	
	//enum MacroItem returns MacroItem:
	//    type = 'type';
	public MacroItemElements getMacroItemAccess() {
		return eMacroItem;
	}
	
	public EnumRule getMacroItemRule() {
		return getMacroItemAccess().getRule();
	}
	
	//terminal ID: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt: ('0'..'9')+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//            '"' ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|'"') )* '"' |
	//            "'" ( '\\' . /* 'b'|'t'|'n'|'f'|'r'|'u'|'"'|"'"|'\\' */ | !('\\'|"'") )* "'"
	//        ;
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT : '/*' -> '*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal SL_COMMENT : '//' !('\n'|'\r')* ('\r'? '\n')?;
	public TerminalRule getSL_COMMENTRule() {
		return gaTerminals.getSL_COMMENTRule();
	}
	
	//terminal WS         : (' '|'\t'|'\r'|'\n')+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER: .;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
