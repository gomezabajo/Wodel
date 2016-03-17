/*
 * generated by Xtext
 */
package org.mutator.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.mutator.services.MutatorGrammarAccess;

public class MutatorParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private MutatorGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.mutator.parser.antlr.internal.InternalMutatorParser createParser(XtextTokenStream stream) {
		return new org.mutator.parser.antlr.internal.InternalMutatorParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "MutatorEnvironment";
	}
	
	public MutatorGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MutatorGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}
