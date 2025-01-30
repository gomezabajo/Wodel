/*
 * generated by Xtext 2.37.0
 */
grammar InternalASPLE;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package wodel.dsls.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package wodel.dsls.parser.antlr.internal;

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
import wodel.dsls.services.ASPLEGrammarAccess;

}

@parser::members {

 	private ASPLEGrammarAccess grammarAccess;

    public InternalASPLEParser(TokenStream input, ASPLEGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Program";
   	}

   	@Override
   	protected ASPLEGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleProgram
entryRuleProgram returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getProgramRule()); }
	iv_ruleProgram=ruleProgram
	{ $current=$iv_ruleProgram.current; }
	EOF;

// Rule Program
ruleProgram returns [EObject current=null]
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
					grammarAccess.getProgramAccess().getProgramAction_0(),
					$current);
			}
		)
		otherlv_1='begin'
		{
			newLeafNode(otherlv_1, grammarAccess.getProgramAccess().getBeginKeyword_1());
		}
		(
			(
				(
					{
						newCompositeNode(grammarAccess.getProgramAccess().getDeclarationsDeclarationParserRuleCall_2_0_0());
					}
					lv_declarations_2_0=ruleDeclaration
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getProgramRule());
						}
						add(
							$current,
							"declarations",
							lv_declarations_2_0,
							"wodel.dsls.ASPLE.Declaration");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_3=';'
			{
				newLeafNode(otherlv_3, grammarAccess.getProgramAccess().getSemicolonKeyword_2_1());
			}
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getProgramAccess().getStatementsStatementParserRuleCall_3_0());
				}
				lv_statements_4_0=ruleStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getProgramRule());
					}
					add(
						$current,
						"statements",
						lv_statements_4_0,
						"wodel.dsls.ASPLE.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_5='end'
		{
			newLeafNode(otherlv_5, grammarAccess.getProgramAccess().getEndKeyword_4());
		}
	)
;

// Entry rule entryRuleDeclaration
entryRuleDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeclarationRule()); }
	iv_ruleDeclaration=ruleDeclaration
	{ $current=$iv_ruleDeclaration.current; }
	EOF;

// Rule Declaration
ruleDeclaration returns [EObject current=null]
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
					grammarAccess.getDeclarationAccess().getDeclarationAction_0(),
					$current);
			}
		)
		(
			(
				lv_ref_1_0='ref'
				{
					newLeafNode(lv_ref_1_0, grammarAccess.getDeclarationAccess().getRefRefKeyword_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getDeclarationRule());
					}
					setWithLastConsumed($current, "ref", lv_ref_1_0 != null, "ref");
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getDeclarationAccess().getModeModeEnumRuleCall_2_0());
				}
				lv_mode_2_0=ruleMode
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeclarationRule());
					}
					set(
						$current,
						"mode",
						lv_mode_2_0,
						"wodel.dsls.ASPLE.Mode");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_3_0());
				}
				lv_identifiers_3_0=ruleIdentifier
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDeclarationRule());
					}
					add(
						$current,
						"identifiers",
						lv_identifiers_3_0,
						"wodel.dsls.ASPLE.Identifier");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_4=','
			{
				newLeafNode(otherlv_4, grammarAccess.getDeclarationAccess().getCommaKeyword_4_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_4_1_0());
					}
					lv_identifiers_5_0=ruleIdentifier
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getDeclarationRule());
						}
						add(
							$current,
							"identifiers",
							lv_identifiers_5_0,
							"wodel.dsls.ASPLE.Identifier");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
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

// Entry rule entryRuleEInt
entryRuleEInt returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEIntRule()); }
	iv_ruleEInt=ruleEInt
	{ $current=$iv_ruleEInt.current.getText(); }
	EOF;

// Rule EInt
ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0());
			}
		)?
		this_INT_1=RULE_INT
		{
			$current.merge(this_INT_1);
		}
		{
			newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1());
		}
	)
;

// Entry rule entryRuleEBoolean
entryRuleEBoolean returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEBooleanRule()); }
	iv_ruleEBoolean=ruleEBoolean
	{ $current=$iv_ruleEBoolean.current.getText(); }
	EOF;

// Rule EBoolean
ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='true'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0());
		}
		    |
		kw='false'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1());
		}
	)
;

// Entry rule entryRuleEDouble
entryRuleEDouble returns [String current=null]:
	{ newCompositeNode(grammarAccess.getEDoubleRule()); }
	iv_ruleEDouble=ruleEDouble
	{ $current=$iv_ruleEDouble.current.getText(); }
	EOF;

// Rule EDouble
ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			kw='-'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0());
			}
		)?
		(
			this_INT_1=RULE_INT
			{
				$current.merge(this_INT_1);
			}
			{
				newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1());
			}
		)?
		kw='.'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2());
		}
		this_INT_3=RULE_INT
		{
			$current.merge(this_INT_3);
		}
		{
			newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3());
		}
		(
			(
				kw='E'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0());
				}
				    |
				kw='e'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1());
				}
			)
			(
				kw='-'
				{
					$current.merge(kw);
					newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1());
				}
			)?
			this_INT_7=RULE_INT
			{
				$current.merge(this_INT_7);
			}
			{
				newLeafNode(this_INT_7, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2());
			}
		)?
	)
;

// Entry rule entryRuleIdentifier
entryRuleIdentifier returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIdentifierRule()); }
	iv_ruleIdentifier=ruleIdentifier
	{ $current=$iv_ruleIdentifier.current; }
	EOF;

// Rule Identifier
ruleIdentifier returns [EObject current=null]
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
					grammarAccess.getIdentifierAccess().getIdentifierAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIdentifierAccess().getNameEStringParserRuleCall_1_0());
				}
				lv_name_1_0=ruleEString
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIdentifierRule());
					}
					set(
						$current,
						"name",
						lv_name_1_0,
						"wodel.dsls.ASPLE.EString");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleLiteral
entryRuleLiteral returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLiteralRule()); }
	iv_ruleLiteral=ruleLiteral
	{ $current=$iv_ruleLiteral.current; }
	EOF;

// Rule Literal
ruleLiteral returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getIntegerParserRuleCall_0());
		}
		this_Integer_0=ruleInteger
		{
			$current = $this_Integer_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getBooleanParserRuleCall_1());
		}
		this_Boolean_1=ruleBoolean
		{
			$current = $this_Boolean_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getLiteralAccess().getDoubleParserRuleCall_2());
		}
		this_Double_2=ruleDouble
		{
			$current = $this_Double_2.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleInteger
entryRuleInteger returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getIntegerRule()); }
	iv_ruleInteger=ruleInteger
	{ $current=$iv_ruleInteger.current; }
	EOF;

// Rule Integer
ruleInteger returns [EObject current=null]
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
					grammarAccess.getIntegerAccess().getIntegerAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getIntegerAccess().getValueEIntParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEInt
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getIntegerRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"wodel.dsls.ASPLE.EInt");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleBoolean
entryRuleBoolean returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBooleanRule()); }
	iv_ruleBoolean=ruleBoolean
	{ $current=$iv_ruleBoolean.current; }
	EOF;

// Rule Boolean
ruleBoolean returns [EObject current=null]
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
					grammarAccess.getBooleanAccess().getBooleanAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBooleanAccess().getValueEBooleanParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEBoolean
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBooleanRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"wodel.dsls.ASPLE.EBoolean");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleDouble
entryRuleDouble returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDoubleRule()); }
	iv_ruleDouble=ruleDouble
	{ $current=$iv_ruleDouble.current; }
	EOF;

// Rule Double
ruleDouble returns [EObject current=null]
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
					grammarAccess.getDoubleAccess().getDoubleAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getDoubleAccess().getValueEDoubleParserRuleCall_1_0());
				}
				lv_value_1_0=ruleEDouble
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getDoubleRule());
					}
					set(
						$current,
						"value",
						lv_value_1_0,
						"wodel.dsls.ASPLE.EDouble");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleStatement
entryRuleStatement returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getStatementRule()); }
	iv_ruleStatement=ruleStatement
	{ $current=$iv_ruleStatement.current; }
	EOF;

// Rule Statement
ruleStatement returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0());
		}
		this_Assignment_0=ruleAssignment
		{
			$current = $this_Assignment_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getStatementAccess().getConditionalParserRuleCall_1());
		}
		this_Conditional_1=ruleConditional
		{
			$current = $this_Conditional_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getStatementAccess().getLoopParserRuleCall_2());
		}
		this_Loop_2=ruleLoop
		{
			$current = $this_Loop_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getStatementAccess().getTransputParserRuleCall_3());
		}
		this_Transput_3=ruleTransput
		{
			$current = $this_Transput_3.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleAssignment
entryRuleAssignment returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAssignmentRule()); }
	iv_ruleAssignment=ruleAssignment
	{ $current=$iv_ruleAssignment.current; }
	EOF;

// Rule Assignment
ruleAssignment returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getAssignmentRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getAssignmentAccess().getVarIdentifierCrossReference_0_0());
				}
			)
		)
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0());
				}
				lv_value_2_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getAssignmentRule());
					}
					set(
						$current,
						"value",
						lv_value_2_0,
						"wodel.dsls.ASPLE.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_3=';'
		{
			newLeafNode(otherlv_3, grammarAccess.getAssignmentAccess().getSemicolonKeyword_3());
		}
	)
;

// Entry rule entryRuleConditional
entryRuleConditional returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getConditionalRule()); }
	iv_ruleConditional=ruleConditional
	{ $current=$iv_ruleConditional.current; }
	EOF;

// Rule Conditional
ruleConditional returns [EObject current=null]
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
					grammarAccess.getConditionalAccess().getConditionalAction_0(),
					$current);
			}
		)
		otherlv_1='if'
		{
			newLeafNode(otherlv_1, grammarAccess.getConditionalAccess().getIfKeyword_1());
		}
		otherlv_2='('
		{
			newLeafNode(otherlv_2, grammarAccess.getConditionalAccess().getLeftParenthesisKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConditionalAccess().getExpressionExpressionParserRuleCall_3_0());
				}
				lv_expression_3_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConditionalRule());
					}
					set(
						$current,
						"expression",
						lv_expression_3_0,
						"wodel.dsls.ASPLE.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_4=')'
		{
			newLeafNode(otherlv_4, grammarAccess.getConditionalAccess().getRightParenthesisKeyword_4());
		}
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getConditionalAccess().getIfStatementParserRuleCall_6_0());
				}
				lv_if_6_0=ruleStatement
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getConditionalRule());
					}
					add(
						$current,
						"if",
						lv_if_6_0,
						"wodel.dsls.ASPLE.Statement");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_7='}'
		{
			newLeafNode(otherlv_7, grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_7());
		}
		(
			otherlv_8='else'
			{
				newLeafNode(otherlv_8, grammarAccess.getConditionalAccess().getElseKeyword_8_0());
			}
			otherlv_9='{'
			{
				newLeafNode(otherlv_9, grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_8_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getConditionalAccess().getElseStatementParserRuleCall_8_2_0());
					}
					lv_else_10_0=ruleStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getConditionalRule());
						}
						add(
							$current,
							"else",
							lv_else_10_0,
							"wodel.dsls.ASPLE.Statement");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_11='}'
			{
				newLeafNode(otherlv_11, grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_8_3());
			}
		)?
	)
;

// Entry rule entryRuleLoop
entryRuleLoop returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getLoopRule()); }
	iv_ruleLoop=ruleLoop
	{ $current=$iv_ruleLoop.current; }
	EOF;

// Rule Loop
ruleLoop returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					$current = forceCreateModelElement(
						grammarAccess.getLoopAccess().getLoopAction_0_0(),
						$current);
				}
			)
			otherlv_1='while'
			{
				newLeafNode(otherlv_1, grammarAccess.getLoopAccess().getWhileKeyword_0_1());
			}
			otherlv_2='('
			{
				newLeafNode(otherlv_2, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_0_2());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_0_3_0());
					}
					lv_expression_3_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLoopRule());
						}
						set(
							$current,
							"expression",
							lv_expression_3_0,
							"wodel.dsls.ASPLE.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_4=')'
			{
				newLeafNode(otherlv_4, grammarAccess.getLoopAccess().getRightParenthesisKeyword_0_4());
			}
			otherlv_5='{'
			{
				newLeafNode(otherlv_5, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_0_5());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_0_6_0());
					}
					lv_statements_6_0=ruleStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLoopRule());
						}
						add(
							$current,
							"statements",
							lv_statements_6_0,
							"wodel.dsls.ASPLE.Statement");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_7='}'
			{
				newLeafNode(otherlv_7, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_0_7());
			}
		)
		    |
		(
			otherlv_8='repeat'
			{
				newLeafNode(otherlv_8, grammarAccess.getLoopAccess().getRepeatKeyword_1_0());
			}
			otherlv_9='{'
			{
				newLeafNode(otherlv_9, grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1_1());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_1_2_0());
					}
					lv_statements_10_0=ruleStatement
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLoopRule());
						}
						add(
							$current,
							"statements",
							lv_statements_10_0,
							"wodel.dsls.ASPLE.Statement");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			otherlv_11='}'
			{
				newLeafNode(otherlv_11, grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_1_3());
			}
			otherlv_12='until'
			{
				newLeafNode(otherlv_12, grammarAccess.getLoopAccess().getUntilKeyword_1_4());
			}
			otherlv_13='('
			{
				newLeafNode(otherlv_13, grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1_5());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_1_6_0());
					}
					lv_expression_14_0=ruleExpression
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getLoopRule());
						}
						set(
							$current,
							"expression",
							lv_expression_14_0,
							"wodel.dsls.ASPLE.Expression");
						afterParserOrEnumRuleCall();
					}
				)
			)
			otherlv_15=')'
			{
				newLeafNode(otherlv_15, grammarAccess.getLoopAccess().getRightParenthesisKeyword_1_7());
			}
		)
	)
;

// Entry rule entryRuleTransput
entryRuleTransput returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTransputRule()); }
	iv_ruleTransput=ruleTransput
	{ $current=$iv_ruleTransput.current; }
	EOF;

// Rule Transput
ruleTransput returns [EObject current=null]
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
					grammarAccess.getTransputAccess().getTransputAction_0(),
					$current);
			}
		)
		otherlv_1='input'
		{
			newLeafNode(otherlv_1, grammarAccess.getTransputAccess().getInputKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTransputRule());
					}
				}
				otherlv_2=RULE_ID
				{
					newLeafNode(otherlv_2, grammarAccess.getTransputAccess().getVarIdentifierCrossReference_2_0());
				}
			)
		)
		otherlv_3='output'
		{
			newLeafNode(otherlv_3, grammarAccess.getTransputAccess().getOutputKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTransputAccess().getExpressionExpressionParserRuleCall_4_0());
				}
				lv_expression_4_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTransputRule());
					}
					set(
						$current,
						"expression",
						lv_expression_4_0,
						"wodel.dsls.ASPLE.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleExpression
entryRuleExpression returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getExpressionRule()); }
	iv_ruleExpression=ruleExpression
	{ $current=$iv_ruleExpression.current; }
	EOF;

// Rule Expression
ruleExpression returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0());
		}
		this_Primary_0=rulePrimary
		{
			$current = $this_Primary_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getExpressionAccess().getBinaryOperatorParserRuleCall_1());
		}
		this_BinaryOperator_1=ruleBinaryOperator
		{
			$current = $this_BinaryOperator_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRulePrimary
entryRulePrimary returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimaryRule()); }
	iv_rulePrimary=rulePrimary
	{ $current=$iv_rulePrimary.current; }
	EOF;

// Rule Primary
rulePrimary returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getIdentifierParserRuleCall_0());
		}
		this_Identifier_0=ruleIdentifier
		{
			$current = $this_Identifier_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1());
		}
		this_Literal_1=ruleLiteral
		{
			$current = $this_Literal_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleBinaryOperator
entryRuleBinaryOperator returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBinaryOperatorRule()); }
	iv_ruleBinaryOperator=ruleBinaryOperator
	{ $current=$iv_ruleBinaryOperator.current; }
	EOF;

// Rule BinaryOperator
ruleBinaryOperator returns [EObject current=null]
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
					grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBinaryOperatorAccess().getLeftPrimaryParserRuleCall_1_0());
				}
				lv_left_1_0=rulePrimary
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
					}
					set(
						$current,
						"left",
						lv_left_1_0,
						"wodel.dsls.ASPLE.Primary");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				(
					lv_operator_2_1='+'
					{
						newLeafNode(lv_operator_2_1, grammarAccess.getBinaryOperatorAccess().getOperatorPlusSignKeyword_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_1, null);
					}
					    |
					lv_operator_2_2='-'
					{
						newLeafNode(lv_operator_2_2, grammarAccess.getBinaryOperatorAccess().getOperatorHyphenMinusKeyword_2_0_1());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_2, null);
					}
					    |
					lv_operator_2_3='*'
					{
						newLeafNode(lv_operator_2_3, grammarAccess.getBinaryOperatorAccess().getOperatorAsteriskKeyword_2_0_2());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_3, null);
					}
					    |
					lv_operator_2_4='/'
					{
						newLeafNode(lv_operator_2_4, grammarAccess.getBinaryOperatorAccess().getOperatorSolidusKeyword_2_0_3());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_4, null);
					}
					    |
					lv_operator_2_5='%'
					{
						newLeafNode(lv_operator_2_5, grammarAccess.getBinaryOperatorAccess().getOperatorPercentSignKeyword_2_0_4());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_5, null);
					}
					    |
					lv_operator_2_6='=='
					{
						newLeafNode(lv_operator_2_6, grammarAccess.getBinaryOperatorAccess().getOperatorEqualsSignEqualsSignKeyword_2_0_5());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_6, null);
					}
					    |
					lv_operator_2_7='!='
					{
						newLeafNode(lv_operator_2_7, grammarAccess.getBinaryOperatorAccess().getOperatorExclamationMarkEqualsSignKeyword_2_0_6());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_7, null);
					}
					    |
					lv_operator_2_8='>'
					{
						newLeafNode(lv_operator_2_8, grammarAccess.getBinaryOperatorAccess().getOperatorGreaterThanSignKeyword_2_0_7());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_8, null);
					}
					    |
					lv_operator_2_9='<'
					{
						newLeafNode(lv_operator_2_9, grammarAccess.getBinaryOperatorAccess().getOperatorLessThanSignKeyword_2_0_8());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBinaryOperatorRule());
						}
						setWithLastConsumed($current, "operator", lv_operator_2_9, null);
					}
				)
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getBinaryOperatorAccess().getRightExpressionParserRuleCall_3_0());
				}
				lv_right_3_0=ruleExpression
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
					}
					set(
						$current,
						"right",
						lv_right_3_0,
						"wodel.dsls.ASPLE.Expression");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Rule Mode
ruleMode returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='int'
			{
				$current = grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='bool'
			{
				$current = grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='double'
			{
				$current = grammarAccess.getModeAccess().getDoubleEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getModeAccess().getDoubleEnumLiteralDeclaration_2());
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
