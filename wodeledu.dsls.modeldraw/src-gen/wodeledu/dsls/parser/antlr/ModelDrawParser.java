/*
 * generated by Xtext 2.38.0
 */
package wodeledu.dsls.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import wodeledu.dsls.parser.antlr.internal.InternalModelDrawParser;
import wodeledu.dsls.services.ModelDrawGrammarAccess;

public class ModelDrawParser extends AbstractAntlrParser {

	@Inject
	private ModelDrawGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalModelDrawParser createParser(XtextTokenStream stream) {
		return new InternalModelDrawParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "MutatorDraw";
	}

	public ModelDrawGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ModelDrawGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
