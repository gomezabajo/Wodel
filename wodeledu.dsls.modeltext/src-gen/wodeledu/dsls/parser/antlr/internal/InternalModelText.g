/*
 * generated by Xtext 2.38.0
 */
grammar InternalModelText;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package wodeledu.dsls.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package wodeledu.dsls.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import wodeledu.dsls.services.ModelTextGrammarAccess;

}

@parser::members {

 	private ModelTextGrammarAccess grammarAccess;

    public InternalModelTextParser(TokenStream input, ModelTextGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "IdentifyElements";
   	}

   	@Override
   	protected ModelTextGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleIdentifyElements
entryRuleIdentifyElements returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIdentifyElementsRule()); }
	iv_ruleIdentifyElements=ruleIdentifyElements
	{ $current=$iv_ruleIdentifyElements.current; }
	EOF;

// Rule IdentifyElements
ruleIdentifyElements returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0(),
					$current);
			}
		)
		otherlv_1='metamodel'
		{
			newLeafNode(otherlv_1, grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0());
				}
				lv_metamodel_2_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
					}
					set(
						$current,
						"metamodel",
						lv_metamodel_2_0,
						"wodeledu.dsls.ModelText.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIdentifyElementsAccess().getInstancesMutatorInstanceParserRuleCall_3_0());
				}
				lv_instances_3_0=ruleMutatorInstance
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIdentifyElementsRule());
					}
					add(
						$current,
						"instances",
						lv_instances_3_0,
						"wodeledu.dsls.ModelText.MutatorInstance");
					afterParserOrEnumRuleCall();
				}
			)
		)+
	)
;

// Entry rule entryRuleMutatorInstance
entryRuleMutatorInstance returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMutatorInstanceRule()); }
	iv_ruleMutatorInstance=ruleMutatorInstance
	{ $current=$iv_ruleMutatorInstance.current; }
	EOF;

// Rule MutatorInstance
ruleMutatorInstance returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getMutatorInstanceAccess().getMutatorInstanceAction_0(),
					$current);
			}
		)
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getMutatorInstanceRule());
					}
				}
				otherlv_1=RULE_ID
				{
					newLeafNode(otherlv_1, grammarAccess.getMutatorInstanceAccess().getNameEClassCrossReference_1_0());
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getMutatorInstanceAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getMutatorInstanceAccess().getElementsElementParserRuleCall_3_0_0());
					}
					lv_elements_3_0=ruleElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMutatorInstanceRule());
						}
						add(
							$current,
							"elements",
							lv_elements_3_0,
							"wodeledu.dsls.ModelText.Element");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getMutatorInstanceAccess().getElementsElementParserRuleCall_3_1_0());
					}
					lv_elements_4_0=ruleElement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getMutatorInstanceRule());
						}
						add(
							$current,
							"elements",
							lv_elements_4_0,
							"wodeledu.dsls.ModelText.Element");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)?
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getMutatorInstanceAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleEString
entryRuleEString returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEStringRule()); }
	iv_ruleEString=ruleEString
	{ $current=$iv_ruleEString.current.getText(); }
	EOF;

// Rule EString
ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_STRING_0=RULE_STRING
		{
			$current.merge(this_STRING_0);
		}
		{
			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
		}
		    |
		this_ID_1=RULE_ID
		{
			$current.merge(this_ID_1);
		}
		{
			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleElement
entryRuleElement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getElementRule()); }
	iv_ruleElement=ruleElement
	{ $current=$iv_ruleElement.current; }
	EOF;

// Rule Element
ruleElement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getElementAccess().getElementAction_0(),
					$current);
			}
		)
		otherlv_1='>'
		{
			newLeafNode(otherlv_1, grammarAccess.getElementAccess().getGreaterThanSignKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getElementRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0());
				}
				ruleEString
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_3='.'
			{
				newLeafNode(otherlv_3, grammarAccess.getElementAccess().getFullStopKeyword_3_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getElementRule());
						}
					}
					otherlv_4=RULE_ID
					{
						newLeafNode(otherlv_4, grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0());
					}
				)
			)
		)?
		(
			otherlv_5='('
			{
				newLeafNode(otherlv_5, grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_1_0());
					}
					lv_feature_6_0=ruleValuedFeature
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getElementRule());
						}
						add(
							$current,
							"feature",
							lv_feature_6_0,
							"wodeledu.dsls.ModelText.ValuedFeature");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				otherlv_7=','
				{
					newLeafNode(otherlv_7, grammarAccess.getElementAccess().getCommaKeyword_4_2_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_2_1_0());
						}
						lv_feature_8_0=ruleValuedFeature
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getElementRule());
							}
							add(
								$current,
								"feature",
								lv_feature_8_0,
								"wodeledu.dsls.ModelText.ValuedFeature");
							afterParserOrEnumRuleCall();
						}
					)
				)
			)*
			otherlv_9=')'
			{
				newLeafNode(otherlv_9, grammarAccess.getElementAccess().getRightParenthesisKeyword_4_3());
			}
		)?
		otherlv_10=':'
		{
			newLeafNode(otherlv_10, grammarAccess.getElementAccess().getColonKeyword_5());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0());
					}
					lv_words_11_0=ruleWord
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getElementRule());
						}
						add(
							$current,
							"words",
							lv_words_11_0,
							"wodeledu.dsls.ModelText.Word");
						afterParserOrEnumRuleCall();
					}
				)
			)
			(
				(
					{
						newCompositeNode(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0());
					}
					lv_words_12_0=ruleWord
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getElementRule());
						}
						add(
							$current,
							"words",
							lv_words_12_0,
							"wodeledu.dsls.ModelText.Word");
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)?
	)
;

// Entry rule entryRuleValuedFeature
entryRuleValuedFeature returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getValuedFeatureRule()); }
	iv_ruleValuedFeature=ruleValuedFeature
	{ $current=$iv_ruleValuedFeature.current; }
	EOF;

// Rule ValuedFeature
ruleValuedFeature returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0(),
					$current);
			}
		)
		(
			(
				lv_negation_1_0='not'
				{
					newLeafNode(lv_negation_1_0, grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getValuedFeatureRule());
					}
					setWithLastConsumed($current, "negation", lv_negation_1_0 != null, "not");
				}
			)
		)?
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getValuedFeatureRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0());
				}
			)
		)
		(
			otherlv_3='->'
			{
				newLeafNode(otherlv_3, grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValuedFeatureRule());
						}
					}
					otherlv_4=RULE_ID
					{
						newLeafNode(otherlv_4, grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0());
					}
				)
			)
		)?
		(
			otherlv_5='=='
			{
				newLeafNode(otherlv_5, grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0());
			}
			(
				(
					lv_value_6_0='null'
					{
						newLeafNode(lv_value_6_0, grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getValuedFeatureRule());
						}
						setWithLastConsumed($current, "value", lv_value_6_0, "null");
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleWord
entryRuleWord returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWordRule()); }
	iv_ruleWord=ruleWord
	{ $current=$iv_ruleWord.current; }
	EOF;

// Rule Word
ruleWord returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getWordAccess().getConstantParserRuleCall_0());
		}
		this_Constant_0=ruleConstant
		{
			$current = $this_Constant_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getWordAccess().getVariableParserRuleCall_1());
		}
		this_Variable_1=ruleVariable
		{
			$current = $this_Variable_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getWordAccess().getMacroParserRuleCall_2());
		}
		this_Macro_2=ruleMacro
		{
			$current = $this_Macro_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleConstant
entryRuleConstant returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConstantRule()); }
	iv_ruleConstant=ruleConstant
	{ $current=$iv_ruleConstant.current; }
	EOF;

// Rule Constant
ruleConstant returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getConstantAccess().getConstantAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConstantRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"wodeledu.dsls.ModelText.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleVariable
entryRuleVariable returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getVariableRule()); }
	iv_ruleVariable=ruleVariable
	{ $current=$iv_ruleVariable.current; }
	EOF;

// Rule Variable
ruleVariable returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getVariableAccess().getVariableAction_0(),
					$current);
			}
		)
		otherlv_1='%'
		{
			newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getPercentSignKeyword_1());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getVariableRule());
						}
					}
					otherlv_2=RULE_ID
					{
						newLeafNode(otherlv_2, grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0());
					}
				)
			)
			otherlv_3='.'
			{
				newLeafNode(otherlv_3, grammarAccess.getVariableAccess().getFullStopKeyword_2_1());
			}
		)?
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getVariableRule());
					}
				}
				otherlv_4=RULE_ID
				{
					newLeafNode(otherlv_4, grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0());
				}
			)
		)
	)
;

// Entry rule entryRuleMacro
entryRuleMacro returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMacroRule()); }
	iv_ruleMacro=ruleMacro
	{ $current=$iv_ruleMacro.current; }
	EOF;

// Rule Macro
ruleMacro returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getMacroAccess().getMacroAction_0(),
					$current);
			}
		)
		otherlv_1='%'
		{
			newLeafNode(otherlv_1, grammarAccess.getMacroAccess().getPercentSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getMacroAccess().getItemMacroItemEnumRuleCall_2_0());
				}
				lv_item_2_0=ruleMacroItem
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getMacroRule());
					}
					set(
						$current,
						"item",
						lv_item_2_0,
						"wodeledu.dsls.ModelText.MacroItem");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Rule MacroItem
ruleMacroItem returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		enumLiteral_0='type'
		{
			$current = grammarAccess.getMacroItemAccess().getTypeEnumLiteralDeclaration().getEnumLiteral().getInstance();
			newLeafNode(enumLiteral_0, grammarAccess.getMacroItemAccess().getTypeEnumLiteralDeclaration());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
