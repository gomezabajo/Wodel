/*
 * generated by Xtext 2.38.0
 */
package wodel.dsls.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import wodel.dsls.ide.contentassist.antlr.internal.InternalASPLEParser;
import wodel.dsls.services.ASPLEGrammarAccess;

public class ASPLEParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(ASPLEGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, ASPLEGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getEStringAccess().getAlternatives(), "rule__EString__Alternatives");
			builder.put(grammarAccess.getEBooleanAccess().getAlternatives(), "rule__EBoolean__Alternatives");
			builder.put(grammarAccess.getEDoubleAccess().getAlternatives_4_0(), "rule__EDouble__Alternatives_4_0");
			builder.put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
			builder.put(grammarAccess.getStatementAccess().getAlternatives(), "rule__Statement__Alternatives");
			builder.put(grammarAccess.getLoopAccess().getAlternatives(), "rule__Loop__Alternatives");
			builder.put(grammarAccess.getExpressionAccess().getAlternatives(), "rule__Expression__Alternatives");
			builder.put(grammarAccess.getPrimaryAccess().getAlternatives(), "rule__Primary__Alternatives");
			builder.put(grammarAccess.getBinaryOperatorAccess().getOperatorAlternatives_2_0(), "rule__BinaryOperator__OperatorAlternatives_2_0");
			builder.put(grammarAccess.getModeAccess().getAlternatives(), "rule__Mode__Alternatives");
			builder.put(grammarAccess.getProgramAccess().getGroup(), "rule__Program__Group__0");
			builder.put(grammarAccess.getProgramAccess().getGroup_2(), "rule__Program__Group_2__0");
			builder.put(grammarAccess.getDeclarationAccess().getGroup(), "rule__Declaration__Group__0");
			builder.put(grammarAccess.getDeclarationAccess().getGroup_4(), "rule__Declaration__Group_4__0");
			builder.put(grammarAccess.getEIntAccess().getGroup(), "rule__EInt__Group__0");
			builder.put(grammarAccess.getEDoubleAccess().getGroup(), "rule__EDouble__Group__0");
			builder.put(grammarAccess.getEDoubleAccess().getGroup_4(), "rule__EDouble__Group_4__0");
			builder.put(grammarAccess.getIdentifierAccess().getGroup(), "rule__Identifier__Group__0");
			builder.put(grammarAccess.getIntegerAccess().getGroup(), "rule__Integer__Group__0");
			builder.put(grammarAccess.getBooleanAccess().getGroup(), "rule__Boolean__Group__0");
			builder.put(grammarAccess.getDoubleAccess().getGroup(), "rule__Double__Group__0");
			builder.put(grammarAccess.getAssignmentAccess().getGroup(), "rule__Assignment__Group__0");
			builder.put(grammarAccess.getConditionalAccess().getGroup(), "rule__Conditional__Group__0");
			builder.put(grammarAccess.getConditionalAccess().getGroup_8(), "rule__Conditional__Group_8__0");
			builder.put(grammarAccess.getLoopAccess().getGroup_0(), "rule__Loop__Group_0__0");
			builder.put(grammarAccess.getLoopAccess().getGroup_1(), "rule__Loop__Group_1__0");
			builder.put(grammarAccess.getTransputAccess().getGroup(), "rule__Transput__Group__0");
			builder.put(grammarAccess.getBinaryOperatorAccess().getGroup(), "rule__BinaryOperator__Group__0");
			builder.put(grammarAccess.getProgramAccess().getDeclarationsAssignment_2_0(), "rule__Program__DeclarationsAssignment_2_0");
			builder.put(grammarAccess.getProgramAccess().getStatementsAssignment_3(), "rule__Program__StatementsAssignment_3");
			builder.put(grammarAccess.getDeclarationAccess().getRefAssignment_1(), "rule__Declaration__RefAssignment_1");
			builder.put(grammarAccess.getDeclarationAccess().getModeAssignment_2(), "rule__Declaration__ModeAssignment_2");
			builder.put(grammarAccess.getDeclarationAccess().getIdentifiersAssignment_3(), "rule__Declaration__IdentifiersAssignment_3");
			builder.put(grammarAccess.getDeclarationAccess().getIdentifiersAssignment_4_1(), "rule__Declaration__IdentifiersAssignment_4_1");
			builder.put(grammarAccess.getIdentifierAccess().getNameAssignment_1(), "rule__Identifier__NameAssignment_1");
			builder.put(grammarAccess.getIntegerAccess().getValueAssignment_1(), "rule__Integer__ValueAssignment_1");
			builder.put(grammarAccess.getBooleanAccess().getValueAssignment_1(), "rule__Boolean__ValueAssignment_1");
			builder.put(grammarAccess.getDoubleAccess().getValueAssignment_1(), "rule__Double__ValueAssignment_1");
			builder.put(grammarAccess.getAssignmentAccess().getVarAssignment_0(), "rule__Assignment__VarAssignment_0");
			builder.put(grammarAccess.getAssignmentAccess().getValueAssignment_2(), "rule__Assignment__ValueAssignment_2");
			builder.put(grammarAccess.getConditionalAccess().getExpressionAssignment_3(), "rule__Conditional__ExpressionAssignment_3");
			builder.put(grammarAccess.getConditionalAccess().getIfAssignment_6(), "rule__Conditional__IfAssignment_6");
			builder.put(grammarAccess.getConditionalAccess().getElseAssignment_8_2(), "rule__Conditional__ElseAssignment_8_2");
			builder.put(grammarAccess.getLoopAccess().getExpressionAssignment_0_3(), "rule__Loop__ExpressionAssignment_0_3");
			builder.put(grammarAccess.getLoopAccess().getStatementsAssignment_0_6(), "rule__Loop__StatementsAssignment_0_6");
			builder.put(grammarAccess.getLoopAccess().getStatementsAssignment_1_2(), "rule__Loop__StatementsAssignment_1_2");
			builder.put(grammarAccess.getLoopAccess().getExpressionAssignment_1_6(), "rule__Loop__ExpressionAssignment_1_6");
			builder.put(grammarAccess.getTransputAccess().getVarAssignment_2(), "rule__Transput__VarAssignment_2");
			builder.put(grammarAccess.getTransputAccess().getExpressionAssignment_4(), "rule__Transput__ExpressionAssignment_4");
			builder.put(grammarAccess.getBinaryOperatorAccess().getLeftAssignment_1(), "rule__BinaryOperator__LeftAssignment_1");
			builder.put(grammarAccess.getBinaryOperatorAccess().getOperatorAssignment_2(), "rule__BinaryOperator__OperatorAssignment_2");
			builder.put(grammarAccess.getBinaryOperatorAccess().getRightAssignment_3(), "rule__BinaryOperator__RightAssignment_3");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private ASPLEGrammarAccess grammarAccess;

	@Override
	protected InternalASPLEParser createParser() {
		InternalASPLEParser result = new InternalASPLEParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public ASPLEGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ASPLEGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
