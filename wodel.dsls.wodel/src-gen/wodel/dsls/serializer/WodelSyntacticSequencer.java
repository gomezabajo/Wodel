/*
 * generated by Xtext 2.37.0
 */
package wodel.dsls.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import wodel.dsls.services.WodelGrammarAccess;

@SuppressWarnings("all")
public class WodelSyntacticSequencer extends AbstractSyntacticSequencer {

	protected WodelGrammarAccess grammarAccess;
	protected AbstractElementAlias match_CloneObjectMutator___WithKeyword_5_0_LeftCurlyBracketKeyword_5_1_RightCurlyBracketKeyword_5_4__q;
	protected AbstractElementAlias match_CreateObjectMutator___WithKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_4__q;
	protected AbstractElementAlias match_ModifyInformationMutator___WithKeyword_3_0_LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_4__q;
	protected AbstractElementAlias match_MutatorEnvironment___BlocksKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___CommandsKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__;
	protected AbstractElementAlias match_MutatorEnvironment___ConstraintsKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_3__q;
	protected AbstractElementAlias match_RetypeObjectMutator___WithKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_4__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (WodelGrammarAccess) access;
		match_CloneObjectMutator___WithKeyword_5_0_LeftCurlyBracketKeyword_5_1_RightCurlyBracketKeyword_5_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getCloneObjectMutatorAccess().getWithKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getCloneObjectMutatorAccess().getLeftCurlyBracketKeyword_5_1()), new TokenAlias(false, false, grammarAccess.getCloneObjectMutatorAccess().getRightCurlyBracketKeyword_5_4()));
		match_CreateObjectMutator___WithKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getCreateObjectMutatorAccess().getWithKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getCreateObjectMutatorAccess().getLeftCurlyBracketKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getCreateObjectMutatorAccess().getRightCurlyBracketKeyword_4_4()));
		match_ModifyInformationMutator___WithKeyword_3_0_LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getModifyInformationMutatorAccess().getWithKeyword_3_0()), new TokenAlias(false, false, grammarAccess.getModifyInformationMutatorAccess().getLeftCurlyBracketKeyword_3_1()), new TokenAlias(false, false, grammarAccess.getModifyInformationMutatorAccess().getRightCurlyBracketKeyword_3_4()));
		match_MutatorEnvironment___BlocksKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___CommandsKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__ = new AlternativeAlias(false, false, new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getBlocksKeyword_3_0_0()), new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_3_0_1()), new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_3_0_3())), new GroupAlias(false, false, new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getCommandsKeyword_3_1_0()), new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_3_1_1()), new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_3_1_3())));
		match_MutatorEnvironment___ConstraintsKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_3__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getConstraintsKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_4_1()), new TokenAlias(false, false, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_4_3()));
		match_RetypeObjectMutator___WithKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_4__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getRetypeObjectMutatorAccess().getWithKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getRetypeObjectMutatorAccess().getLeftCurlyBracketKeyword_6_1()), new TokenAlias(false, false, grammarAccess.getRetypeObjectMutatorAccess().getRightCurlyBracketKeyword_6_4()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_CloneObjectMutator___WithKeyword_5_0_LeftCurlyBracketKeyword_5_1_RightCurlyBracketKeyword_5_4__q.equals(syntax))
				emit_CloneObjectMutator___WithKeyword_5_0_LeftCurlyBracketKeyword_5_1_RightCurlyBracketKeyword_5_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_CreateObjectMutator___WithKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_4__q.equals(syntax))
				emit_CreateObjectMutator___WithKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ModifyInformationMutator___WithKeyword_3_0_LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_4__q.equals(syntax))
				emit_ModifyInformationMutator___WithKeyword_3_0_LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_MutatorEnvironment___BlocksKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___CommandsKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__.equals(syntax))
				emit_MutatorEnvironment___BlocksKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___CommandsKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_MutatorEnvironment___ConstraintsKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_3__q.equals(syntax))
				emit_MutatorEnvironment___ConstraintsKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_3__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_RetypeObjectMutator___WithKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_4__q.equals(syntax))
				emit_RetypeObjectMutator___WithKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_4__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('with' '{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     container=ObSelectionStrategy (ambiguity) '[' max=MaxCardinality
	 *     container=ObSelectionStrategy (ambiguity) '[' min=EInt
	 *     container=ObSelectionStrategy (ambiguity) (rule end)
	 *     object=ObSelectionStrategy (ambiguity) '[' max=MaxCardinality
	 *     object=ObSelectionStrategy (ambiguity) '[' min=EInt
	 *     object=ObSelectionStrategy (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_CloneObjectMutator___WithKeyword_5_0_LeftCurlyBracketKeyword_5_1_RightCurlyBracketKeyword_5_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('with' '{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     container=ObSelectionStrategy (ambiguity) '[' max=MaxCardinality
	 *     container=ObSelectionStrategy (ambiguity) '[' min=EInt
	 *     container=ObSelectionStrategy (ambiguity) (rule end)
	 *     type=[EClass|ID] (ambiguity) '[' max=MaxCardinality
	 *     type=[EClass|ID] (ambiguity) '[' min=EInt
	 *     type=[EClass|ID] (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_CreateObjectMutator___WithKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('with' '{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     object=ObSelectionStrategy (ambiguity) '[' max=MaxCardinality
	 *     object=ObSelectionStrategy (ambiguity) '[' min=EInt
	 *     object=ObSelectionStrategy (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ModifyInformationMutator___WithKeyword_3_0_LeftCurlyBracketKeyword_3_1_RightCurlyBracketKeyword_3_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('blocks' '{' '}') | ('commands' '{' '}')
	 *
	 * This ambiguous syntax occurs at:
	 *     definition=Definition 'with' (ambiguity) 'constraints' '{' constraints+=Constraint
	 *     definition=Definition 'with' (ambiguity) ('constraints' '{' '}')? (rule end)
	 
	 * </pre>
	 */
	protected void emit_MutatorEnvironment___BlocksKeyword_3_0_0_LeftCurlyBracketKeyword_3_0_1_RightCurlyBracketKeyword_3_0_3___or___CommandsKeyword_3_1_0_LeftCurlyBracketKeyword_3_1_1_RightCurlyBracketKeyword_3_1_3__(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('constraints' '{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     blocks+=Block '}' (ambiguity) (rule end)
	 *     commands+=Mutator '}' (ambiguity) (rule end)
	 *     definition=Definition 'with' (('blocks' '{' '}') | ('commands' '{' '}')) (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_MutatorEnvironment___ConstraintsKeyword_4_0_LeftCurlyBracketKeyword_4_1_RightCurlyBracketKeyword_4_3__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('with' '{' '}')?
	 *
	 * This ambiguous syntax occurs at:
	 *     type=[EClass|ID] (ambiguity) '[' max=MaxCardinality
	 *     type=[EClass|ID] (ambiguity) '[' min=EInt
	 *     type=[EClass|ID] (ambiguity) (rule end)
	 *     types+=[EClass|ID] ']' (ambiguity) '[' max=MaxCardinality
	 *     types+=[EClass|ID] ']' (ambiguity) '[' min=EInt
	 *     types+=[EClass|ID] ']' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_RetypeObjectMutator___WithKeyword_6_0_LeftCurlyBracketKeyword_6_1_RightCurlyBracketKeyword_6_4__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
