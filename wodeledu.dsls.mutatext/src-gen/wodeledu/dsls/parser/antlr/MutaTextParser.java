/*
 * generated by Xtext 2.38.0
 */
package wodeledu.dsls.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import wodeledu.dsls.parser.antlr.internal.InternalMutaTextParser;
import wodeledu.dsls.services.MutaTextGrammarAccess;

public class MutaTextParser extends AbstractAntlrParser {

	@Inject
	private MutaTextGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalMutaTextParser createParser(XtextTokenStream stream) {
		return new InternalMutaTextParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Configuration";
	}

	public MutaTextGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(MutaTextGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
