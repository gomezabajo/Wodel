package wodeledu.dsls.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import wodeledu.dsls.services.ModelTextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModelTextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'metamodel'", "'{'", "'}'", "'>'", "':'", "'.'", "'('", "')'", "','", "'->'", "'=='", "'%'", "'not'", "'null'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int EOF=-1;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalModelTextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalModelTextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalModelTextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalModelText.g"; }


    	private ModelTextGrammarAccess grammarAccess;

    	public void setGrammarAccess(ModelTextGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleIdentifyElements"
    // InternalModelText.g:53:1: entryRuleIdentifyElements : ruleIdentifyElements EOF ;
    public final void entryRuleIdentifyElements() throws RecognitionException {
        try {
            // InternalModelText.g:54:1: ( ruleIdentifyElements EOF )
            // InternalModelText.g:55:1: ruleIdentifyElements EOF
            {
             before(grammarAccess.getIdentifyElementsRule()); 
            pushFollow(FOLLOW_1);
            ruleIdentifyElements();

            state._fsp--;

             after(grammarAccess.getIdentifyElementsRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdentifyElements"


    // $ANTLR start "ruleIdentifyElements"
    // InternalModelText.g:62:1: ruleIdentifyElements : ( ( rule__IdentifyElements__Group__0 ) ) ;
    public final void ruleIdentifyElements() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:66:2: ( ( ( rule__IdentifyElements__Group__0 ) ) )
            // InternalModelText.g:67:2: ( ( rule__IdentifyElements__Group__0 ) )
            {
            // InternalModelText.g:67:2: ( ( rule__IdentifyElements__Group__0 ) )
            // InternalModelText.g:68:3: ( rule__IdentifyElements__Group__0 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getGroup()); 
            // InternalModelText.g:69:3: ( rule__IdentifyElements__Group__0 )
            // InternalModelText.g:69:4: rule__IdentifyElements__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__IdentifyElements__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIdentifyElementsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifyElements"


    // $ANTLR start "entryRuleMutatorInstance"
    // InternalModelText.g:78:1: entryRuleMutatorInstance : ruleMutatorInstance EOF ;
    public final void entryRuleMutatorInstance() throws RecognitionException {
        try {
            // InternalModelText.g:79:1: ( ruleMutatorInstance EOF )
            // InternalModelText.g:80:1: ruleMutatorInstance EOF
            {
             before(grammarAccess.getMutatorInstanceRule()); 
            pushFollow(FOLLOW_1);
            ruleMutatorInstance();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMutatorInstance"


    // $ANTLR start "ruleMutatorInstance"
    // InternalModelText.g:87:1: ruleMutatorInstance : ( ( rule__MutatorInstance__Group__0 ) ) ;
    public final void ruleMutatorInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:91:2: ( ( ( rule__MutatorInstance__Group__0 ) ) )
            // InternalModelText.g:92:2: ( ( rule__MutatorInstance__Group__0 ) )
            {
            // InternalModelText.g:92:2: ( ( rule__MutatorInstance__Group__0 ) )
            // InternalModelText.g:93:3: ( rule__MutatorInstance__Group__0 )
            {
             before(grammarAccess.getMutatorInstanceAccess().getGroup()); 
            // InternalModelText.g:94:3: ( rule__MutatorInstance__Group__0 )
            // InternalModelText.g:94:4: rule__MutatorInstance__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMutatorInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMutatorInstance"


    // $ANTLR start "entryRuleEString"
    // InternalModelText.g:103:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalModelText.g:104:1: ( ruleEString EOF )
            // InternalModelText.g:105:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalModelText.g:112:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:116:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalModelText.g:117:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalModelText.g:117:2: ( ( rule__EString__Alternatives ) )
            // InternalModelText.g:118:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalModelText.g:119:3: ( rule__EString__Alternatives )
            // InternalModelText.g:119:4: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleElement"
    // InternalModelText.g:128:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalModelText.g:129:1: ( ruleElement EOF )
            // InternalModelText.g:130:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FOLLOW_1);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleElement"


    // $ANTLR start "ruleElement"
    // InternalModelText.g:137:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:141:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalModelText.g:142:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalModelText.g:142:2: ( ( rule__Element__Group__0 ) )
            // InternalModelText.g:143:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalModelText.g:144:3: ( rule__Element__Group__0 )
            // InternalModelText.g:144:4: rule__Element__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleElement"


    // $ANTLR start "entryRuleValuedFeature"
    // InternalModelText.g:153:1: entryRuleValuedFeature : ruleValuedFeature EOF ;
    public final void entryRuleValuedFeature() throws RecognitionException {
        try {
            // InternalModelText.g:154:1: ( ruleValuedFeature EOF )
            // InternalModelText.g:155:1: ruleValuedFeature EOF
            {
             before(grammarAccess.getValuedFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getValuedFeatureRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValuedFeature"


    // $ANTLR start "ruleValuedFeature"
    // InternalModelText.g:162:1: ruleValuedFeature : ( ( rule__ValuedFeature__Group__0 ) ) ;
    public final void ruleValuedFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:166:2: ( ( ( rule__ValuedFeature__Group__0 ) ) )
            // InternalModelText.g:167:2: ( ( rule__ValuedFeature__Group__0 ) )
            {
            // InternalModelText.g:167:2: ( ( rule__ValuedFeature__Group__0 ) )
            // InternalModelText.g:168:3: ( rule__ValuedFeature__Group__0 )
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup()); 
            // InternalModelText.g:169:3: ( rule__ValuedFeature__Group__0 )
            // InternalModelText.g:169:4: rule__ValuedFeature__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValuedFeature"


    // $ANTLR start "entryRuleWord"
    // InternalModelText.g:178:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalModelText.g:179:1: ( ruleWord EOF )
            // InternalModelText.g:180:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FOLLOW_1);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWord"


    // $ANTLR start "ruleWord"
    // InternalModelText.g:187:1: ruleWord : ( ( rule__Word__Alternatives ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:191:2: ( ( ( rule__Word__Alternatives ) ) )
            // InternalModelText.g:192:2: ( ( rule__Word__Alternatives ) )
            {
            // InternalModelText.g:192:2: ( ( rule__Word__Alternatives ) )
            // InternalModelText.g:193:3: ( rule__Word__Alternatives )
            {
             before(grammarAccess.getWordAccess().getAlternatives()); 
            // InternalModelText.g:194:3: ( rule__Word__Alternatives )
            // InternalModelText.g:194:4: rule__Word__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Word__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWordAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWord"


    // $ANTLR start "entryRuleConstant"
    // InternalModelText.g:203:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalModelText.g:204:1: ( ruleConstant EOF )
            // InternalModelText.g:205:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalModelText.g:212:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:216:2: ( ( ( rule__Constant__Group__0 ) ) )
            // InternalModelText.g:217:2: ( ( rule__Constant__Group__0 ) )
            {
            // InternalModelText.g:217:2: ( ( rule__Constant__Group__0 ) )
            // InternalModelText.g:218:3: ( rule__Constant__Group__0 )
            {
             before(grammarAccess.getConstantAccess().getGroup()); 
            // InternalModelText.g:219:3: ( rule__Constant__Group__0 )
            // InternalModelText.g:219:4: rule__Constant__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleVariable"
    // InternalModelText.g:228:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalModelText.g:229:1: ( ruleVariable EOF )
            // InternalModelText.g:230:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalModelText.g:237:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:241:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalModelText.g:242:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalModelText.g:242:2: ( ( rule__Variable__Group__0 ) )
            // InternalModelText.g:243:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalModelText.g:244:3: ( rule__Variable__Group__0 )
            // InternalModelText.g:244:4: rule__Variable__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleMacro"
    // InternalModelText.g:253:1: entryRuleMacro : ruleMacro EOF ;
    public final void entryRuleMacro() throws RecognitionException {
        try {
            // InternalModelText.g:254:1: ( ruleMacro EOF )
            // InternalModelText.g:255:1: ruleMacro EOF
            {
             before(grammarAccess.getMacroRule()); 
            pushFollow(FOLLOW_1);
            ruleMacro();

            state._fsp--;

             after(grammarAccess.getMacroRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMacro"


    // $ANTLR start "ruleMacro"
    // InternalModelText.g:262:1: ruleMacro : ( ( rule__Macro__Group__0 ) ) ;
    public final void ruleMacro() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:266:2: ( ( ( rule__Macro__Group__0 ) ) )
            // InternalModelText.g:267:2: ( ( rule__Macro__Group__0 ) )
            {
            // InternalModelText.g:267:2: ( ( rule__Macro__Group__0 ) )
            // InternalModelText.g:268:3: ( rule__Macro__Group__0 )
            {
             before(grammarAccess.getMacroAccess().getGroup()); 
            // InternalModelText.g:269:3: ( rule__Macro__Group__0 )
            // InternalModelText.g:269:4: rule__Macro__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Macro__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMacroAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMacro"


    // $ANTLR start "ruleMacroItem"
    // InternalModelText.g:278:1: ruleMacroItem : ( ( 'type' ) ) ;
    public final void ruleMacroItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:282:1: ( ( ( 'type' ) ) )
            // InternalModelText.g:283:2: ( ( 'type' ) )
            {
            // InternalModelText.g:283:2: ( ( 'type' ) )
            // InternalModelText.g:284:3: ( 'type' )
            {
             before(grammarAccess.getMacroItemAccess().getTypeEnumLiteralDeclaration()); 
            // InternalModelText.g:285:3: ( 'type' )
            // InternalModelText.g:285:4: 'type'
            {
            match(input,11,FOLLOW_2); 

            }

             after(grammarAccess.getMacroItemAccess().getTypeEnumLiteralDeclaration()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMacroItem"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalModelText.g:293:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:297:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_STRING) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalModelText.g:298:2: ( RULE_STRING )
                    {
                    // InternalModelText.g:298:2: ( RULE_STRING )
                    // InternalModelText.g:299:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelText.g:304:2: ( RULE_ID )
                    {
                    // InternalModelText.g:304:2: ( RULE_ID )
                    // InternalModelText.g:305:3: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__Word__Alternatives"
    // InternalModelText.g:314:1: rule__Word__Alternatives : ( ( ruleConstant ) | ( ruleVariable ) | ( ruleMacro ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:318:1: ( ( ruleConstant ) | ( ruleVariable ) | ( ruleMacro ) )
            int alt2=3;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)) ) {
                alt2=1;
            }
            else if ( (LA2_0==23) ) {
                int LA2_2 = input.LA(2);

                if ( (LA2_2==11) ) {
                    alt2=3;
                }
                else if ( (LA2_2==RULE_ID) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalModelText.g:319:2: ( ruleConstant )
                    {
                    // InternalModelText.g:319:2: ( ruleConstant )
                    // InternalModelText.g:320:3: ruleConstant
                    {
                     before(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelText.g:325:2: ( ruleVariable )
                    {
                    // InternalModelText.g:325:2: ( ruleVariable )
                    // InternalModelText.g:326:3: ruleVariable
                    {
                     before(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelText.g:331:2: ( ruleMacro )
                    {
                    // InternalModelText.g:331:2: ( ruleMacro )
                    // InternalModelText.g:332:3: ruleMacro
                    {
                     before(grammarAccess.getWordAccess().getMacroParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleMacro();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getMacroParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Word__Alternatives"


    // $ANTLR start "rule__IdentifyElements__Group__0"
    // InternalModelText.g:341:1: rule__IdentifyElements__Group__0 : rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 ;
    public final void rule__IdentifyElements__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:345:1: ( rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 )
            // InternalModelText.g:346:2: rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__IdentifyElements__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdentifyElements__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__0"


    // $ANTLR start "rule__IdentifyElements__Group__0__Impl"
    // InternalModelText.g:353:1: rule__IdentifyElements__Group__0__Impl : ( () ) ;
    public final void rule__IdentifyElements__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:357:1: ( ( () ) )
            // InternalModelText.g:358:1: ( () )
            {
            // InternalModelText.g:358:1: ( () )
            // InternalModelText.g:359:2: ()
            {
             before(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); 
            // InternalModelText.g:360:2: ()
            // InternalModelText.g:360:3: 
            {
            }

             after(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__0__Impl"


    // $ANTLR start "rule__IdentifyElements__Group__1"
    // InternalModelText.g:368:1: rule__IdentifyElements__Group__1 : rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 ;
    public final void rule__IdentifyElements__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:372:1: ( rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 )
            // InternalModelText.g:373:2: rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__IdentifyElements__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdentifyElements__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__1"


    // $ANTLR start "rule__IdentifyElements__Group__1__Impl"
    // InternalModelText.g:380:1: rule__IdentifyElements__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__IdentifyElements__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:384:1: ( ( 'metamodel' ) )
            // InternalModelText.g:385:1: ( 'metamodel' )
            {
            // InternalModelText.g:385:1: ( 'metamodel' )
            // InternalModelText.g:386:2: 'metamodel'
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1()); 
            match(input,12,FOLLOW_2); 
             after(grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__1__Impl"


    // $ANTLR start "rule__IdentifyElements__Group__2"
    // InternalModelText.g:395:1: rule__IdentifyElements__Group__2 : rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 ;
    public final void rule__IdentifyElements__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:399:1: ( rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 )
            // InternalModelText.g:400:2: rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__IdentifyElements__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdentifyElements__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__2"


    // $ANTLR start "rule__IdentifyElements__Group__2__Impl"
    // InternalModelText.g:407:1: rule__IdentifyElements__Group__2__Impl : ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) ;
    public final void rule__IdentifyElements__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:411:1: ( ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) )
            // InternalModelText.g:412:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            {
            // InternalModelText.g:412:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            // InternalModelText.g:413:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); 
            // InternalModelText.g:414:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            // InternalModelText.g:414:3: rule__IdentifyElements__MetamodelAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__IdentifyElements__MetamodelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__2__Impl"


    // $ANTLR start "rule__IdentifyElements__Group__3"
    // InternalModelText.g:422:1: rule__IdentifyElements__Group__3 : rule__IdentifyElements__Group__3__Impl ;
    public final void rule__IdentifyElements__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:426:1: ( rule__IdentifyElements__Group__3__Impl )
            // InternalModelText.g:427:2: rule__IdentifyElements__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IdentifyElements__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__3"


    // $ANTLR start "rule__IdentifyElements__Group__3__Impl"
    // InternalModelText.g:433:1: rule__IdentifyElements__Group__3__Impl : ( ( ( rule__IdentifyElements__InstancesAssignment_3 ) ) ( ( rule__IdentifyElements__InstancesAssignment_3 )* ) ) ;
    public final void rule__IdentifyElements__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:437:1: ( ( ( ( rule__IdentifyElements__InstancesAssignment_3 ) ) ( ( rule__IdentifyElements__InstancesAssignment_3 )* ) ) )
            // InternalModelText.g:438:1: ( ( ( rule__IdentifyElements__InstancesAssignment_3 ) ) ( ( rule__IdentifyElements__InstancesAssignment_3 )* ) )
            {
            // InternalModelText.g:438:1: ( ( ( rule__IdentifyElements__InstancesAssignment_3 ) ) ( ( rule__IdentifyElements__InstancesAssignment_3 )* ) )
            // InternalModelText.g:439:2: ( ( rule__IdentifyElements__InstancesAssignment_3 ) ) ( ( rule__IdentifyElements__InstancesAssignment_3 )* )
            {
            // InternalModelText.g:439:2: ( ( rule__IdentifyElements__InstancesAssignment_3 ) )
            // InternalModelText.g:440:3: ( rule__IdentifyElements__InstancesAssignment_3 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getInstancesAssignment_3()); 
            // InternalModelText.g:441:3: ( rule__IdentifyElements__InstancesAssignment_3 )
            // InternalModelText.g:441:4: rule__IdentifyElements__InstancesAssignment_3
            {
            pushFollow(FOLLOW_6);
            rule__IdentifyElements__InstancesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getIdentifyElementsAccess().getInstancesAssignment_3()); 

            }

            // InternalModelText.g:444:2: ( ( rule__IdentifyElements__InstancesAssignment_3 )* )
            // InternalModelText.g:445:3: ( rule__IdentifyElements__InstancesAssignment_3 )*
            {
             before(grammarAccess.getIdentifyElementsAccess().getInstancesAssignment_3()); 
            // InternalModelText.g:446:3: ( rule__IdentifyElements__InstancesAssignment_3 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalModelText.g:446:4: rule__IdentifyElements__InstancesAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__IdentifyElements__InstancesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getIdentifyElementsAccess().getInstancesAssignment_3()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__Group__3__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__0"
    // InternalModelText.g:456:1: rule__MutatorInstance__Group__0 : rule__MutatorInstance__Group__0__Impl rule__MutatorInstance__Group__1 ;
    public final void rule__MutatorInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:460:1: ( rule__MutatorInstance__Group__0__Impl rule__MutatorInstance__Group__1 )
            // InternalModelText.g:461:2: rule__MutatorInstance__Group__0__Impl rule__MutatorInstance__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MutatorInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__0"


    // $ANTLR start "rule__MutatorInstance__Group__0__Impl"
    // InternalModelText.g:468:1: rule__MutatorInstance__Group__0__Impl : ( () ) ;
    public final void rule__MutatorInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:472:1: ( ( () ) )
            // InternalModelText.g:473:1: ( () )
            {
            // InternalModelText.g:473:1: ( () )
            // InternalModelText.g:474:2: ()
            {
             before(grammarAccess.getMutatorInstanceAccess().getMutatorInstanceAction_0()); 
            // InternalModelText.g:475:2: ()
            // InternalModelText.g:475:3: 
            {
            }

             after(grammarAccess.getMutatorInstanceAccess().getMutatorInstanceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__0__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__1"
    // InternalModelText.g:483:1: rule__MutatorInstance__Group__1 : rule__MutatorInstance__Group__1__Impl rule__MutatorInstance__Group__2 ;
    public final void rule__MutatorInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:487:1: ( rule__MutatorInstance__Group__1__Impl rule__MutatorInstance__Group__2 )
            // InternalModelText.g:488:2: rule__MutatorInstance__Group__1__Impl rule__MutatorInstance__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__MutatorInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__1"


    // $ANTLR start "rule__MutatorInstance__Group__1__Impl"
    // InternalModelText.g:495:1: rule__MutatorInstance__Group__1__Impl : ( ( rule__MutatorInstance__NameAssignment_1 ) ) ;
    public final void rule__MutatorInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:499:1: ( ( ( rule__MutatorInstance__NameAssignment_1 ) ) )
            // InternalModelText.g:500:1: ( ( rule__MutatorInstance__NameAssignment_1 ) )
            {
            // InternalModelText.g:500:1: ( ( rule__MutatorInstance__NameAssignment_1 ) )
            // InternalModelText.g:501:2: ( rule__MutatorInstance__NameAssignment_1 )
            {
             before(grammarAccess.getMutatorInstanceAccess().getNameAssignment_1()); 
            // InternalModelText.g:502:2: ( rule__MutatorInstance__NameAssignment_1 )
            // InternalModelText.g:502:3: rule__MutatorInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMutatorInstanceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__1__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__2"
    // InternalModelText.g:510:1: rule__MutatorInstance__Group__2 : rule__MutatorInstance__Group__2__Impl rule__MutatorInstance__Group__3 ;
    public final void rule__MutatorInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:514:1: ( rule__MutatorInstance__Group__2__Impl rule__MutatorInstance__Group__3 )
            // InternalModelText.g:515:2: rule__MutatorInstance__Group__2__Impl rule__MutatorInstance__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__MutatorInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__2"


    // $ANTLR start "rule__MutatorInstance__Group__2__Impl"
    // InternalModelText.g:522:1: rule__MutatorInstance__Group__2__Impl : ( '{' ) ;
    public final void rule__MutatorInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:526:1: ( ( '{' ) )
            // InternalModelText.g:527:1: ( '{' )
            {
            // InternalModelText.g:527:1: ( '{' )
            // InternalModelText.g:528:2: '{'
            {
             before(grammarAccess.getMutatorInstanceAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,13,FOLLOW_2); 
             after(grammarAccess.getMutatorInstanceAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__2__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__3"
    // InternalModelText.g:537:1: rule__MutatorInstance__Group__3 : rule__MutatorInstance__Group__3__Impl rule__MutatorInstance__Group__4 ;
    public final void rule__MutatorInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:541:1: ( rule__MutatorInstance__Group__3__Impl rule__MutatorInstance__Group__4 )
            // InternalModelText.g:542:2: rule__MutatorInstance__Group__3__Impl rule__MutatorInstance__Group__4
            {
            pushFollow(FOLLOW_8);
            rule__MutatorInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__3"


    // $ANTLR start "rule__MutatorInstance__Group__3__Impl"
    // InternalModelText.g:549:1: rule__MutatorInstance__Group__3__Impl : ( ( rule__MutatorInstance__Group_3__0 )? ) ;
    public final void rule__MutatorInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:553:1: ( ( ( rule__MutatorInstance__Group_3__0 )? ) )
            // InternalModelText.g:554:1: ( ( rule__MutatorInstance__Group_3__0 )? )
            {
            // InternalModelText.g:554:1: ( ( rule__MutatorInstance__Group_3__0 )? )
            // InternalModelText.g:555:2: ( rule__MutatorInstance__Group_3__0 )?
            {
             before(grammarAccess.getMutatorInstanceAccess().getGroup_3()); 
            // InternalModelText.g:556:2: ( rule__MutatorInstance__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalModelText.g:556:3: rule__MutatorInstance__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MutatorInstance__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMutatorInstanceAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__3__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__4"
    // InternalModelText.g:564:1: rule__MutatorInstance__Group__4 : rule__MutatorInstance__Group__4__Impl ;
    public final void rule__MutatorInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:568:1: ( rule__MutatorInstance__Group__4__Impl )
            // InternalModelText.g:569:2: rule__MutatorInstance__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__4"


    // $ANTLR start "rule__MutatorInstance__Group__4__Impl"
    // InternalModelText.g:575:1: rule__MutatorInstance__Group__4__Impl : ( '}' ) ;
    public final void rule__MutatorInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:579:1: ( ( '}' ) )
            // InternalModelText.g:580:1: ( '}' )
            {
            // InternalModelText.g:580:1: ( '}' )
            // InternalModelText.g:581:2: '}'
            {
             before(grammarAccess.getMutatorInstanceAccess().getRightCurlyBracketKeyword_4()); 
            match(input,14,FOLLOW_2); 
             after(grammarAccess.getMutatorInstanceAccess().getRightCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__4__Impl"


    // $ANTLR start "rule__MutatorInstance__Group_3__0"
    // InternalModelText.g:591:1: rule__MutatorInstance__Group_3__0 : rule__MutatorInstance__Group_3__0__Impl rule__MutatorInstance__Group_3__1 ;
    public final void rule__MutatorInstance__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:595:1: ( rule__MutatorInstance__Group_3__0__Impl rule__MutatorInstance__Group_3__1 )
            // InternalModelText.g:596:2: rule__MutatorInstance__Group_3__0__Impl rule__MutatorInstance__Group_3__1
            {
            pushFollow(FOLLOW_9);
            rule__MutatorInstance__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group_3__0"


    // $ANTLR start "rule__MutatorInstance__Group_3__0__Impl"
    // InternalModelText.g:603:1: rule__MutatorInstance__Group_3__0__Impl : ( ( rule__MutatorInstance__ElementsAssignment_3_0 ) ) ;
    public final void rule__MutatorInstance__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:607:1: ( ( ( rule__MutatorInstance__ElementsAssignment_3_0 ) ) )
            // InternalModelText.g:608:1: ( ( rule__MutatorInstance__ElementsAssignment_3_0 ) )
            {
            // InternalModelText.g:608:1: ( ( rule__MutatorInstance__ElementsAssignment_3_0 ) )
            // InternalModelText.g:609:2: ( rule__MutatorInstance__ElementsAssignment_3_0 )
            {
             before(grammarAccess.getMutatorInstanceAccess().getElementsAssignment_3_0()); 
            // InternalModelText.g:610:2: ( rule__MutatorInstance__ElementsAssignment_3_0 )
            // InternalModelText.g:610:3: rule__MutatorInstance__ElementsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__ElementsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getMutatorInstanceAccess().getElementsAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group_3__0__Impl"


    // $ANTLR start "rule__MutatorInstance__Group_3__1"
    // InternalModelText.g:618:1: rule__MutatorInstance__Group_3__1 : rule__MutatorInstance__Group_3__1__Impl ;
    public final void rule__MutatorInstance__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:622:1: ( rule__MutatorInstance__Group_3__1__Impl )
            // InternalModelText.g:623:2: rule__MutatorInstance__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group_3__1"


    // $ANTLR start "rule__MutatorInstance__Group_3__1__Impl"
    // InternalModelText.g:629:1: rule__MutatorInstance__Group_3__1__Impl : ( ( rule__MutatorInstance__ElementsAssignment_3_1 )* ) ;
    public final void rule__MutatorInstance__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:633:1: ( ( ( rule__MutatorInstance__ElementsAssignment_3_1 )* ) )
            // InternalModelText.g:634:1: ( ( rule__MutatorInstance__ElementsAssignment_3_1 )* )
            {
            // InternalModelText.g:634:1: ( ( rule__MutatorInstance__ElementsAssignment_3_1 )* )
            // InternalModelText.g:635:2: ( rule__MutatorInstance__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getMutatorInstanceAccess().getElementsAssignment_3_1()); 
            // InternalModelText.g:636:2: ( rule__MutatorInstance__ElementsAssignment_3_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalModelText.g:636:3: rule__MutatorInstance__ElementsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorInstance__ElementsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getMutatorInstanceAccess().getElementsAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group_3__1__Impl"


    // $ANTLR start "rule__Element__Group__0"
    // InternalModelText.g:645:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:649:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalModelText.g:650:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FOLLOW_9);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__0"


    // $ANTLR start "rule__Element__Group__0__Impl"
    // InternalModelText.g:657:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:661:1: ( ( () ) )
            // InternalModelText.g:662:1: ( () )
            {
            // InternalModelText.g:662:1: ( () )
            // InternalModelText.g:663:2: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalModelText.g:664:2: ()
            // InternalModelText.g:664:3: 
            {
            }

             after(grammarAccess.getElementAccess().getElementAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__0__Impl"


    // $ANTLR start "rule__Element__Group__1"
    // InternalModelText.g:672:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:676:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalModelText.g:677:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__1"


    // $ANTLR start "rule__Element__Group__1__Impl"
    // InternalModelText.g:684:1: rule__Element__Group__1__Impl : ( '>' ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:688:1: ( ( '>' ) )
            // InternalModelText.g:689:1: ( '>' )
            {
            // InternalModelText.g:689:1: ( '>' )
            // InternalModelText.g:690:2: '>'
            {
             before(grammarAccess.getElementAccess().getGreaterThanSignKeyword_1()); 
            match(input,15,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__1__Impl"


    // $ANTLR start "rule__Element__Group__2"
    // InternalModelText.g:699:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:703:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalModelText.g:704:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__2"


    // $ANTLR start "rule__Element__Group__2__Impl"
    // InternalModelText.g:711:1: rule__Element__Group__2__Impl : ( ( rule__Element__TypeAssignment_2 ) ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:715:1: ( ( ( rule__Element__TypeAssignment_2 ) ) )
            // InternalModelText.g:716:1: ( ( rule__Element__TypeAssignment_2 ) )
            {
            // InternalModelText.g:716:1: ( ( rule__Element__TypeAssignment_2 ) )
            // InternalModelText.g:717:2: ( rule__Element__TypeAssignment_2 )
            {
             before(grammarAccess.getElementAccess().getTypeAssignment_2()); 
            // InternalModelText.g:718:2: ( rule__Element__TypeAssignment_2 )
            // InternalModelText.g:718:3: rule__Element__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Element__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__2__Impl"


    // $ANTLR start "rule__Element__Group__3"
    // InternalModelText.g:726:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:730:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalModelText.g:731:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__Element__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__3"


    // $ANTLR start "rule__Element__Group__3__Impl"
    // InternalModelText.g:738:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:742:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalModelText.g:743:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalModelText.g:743:1: ( ( rule__Element__Group_3__0 )? )
            // InternalModelText.g:744:2: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalModelText.g:745:2: ( rule__Element__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalModelText.g:745:3: rule__Element__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__3__Impl"


    // $ANTLR start "rule__Element__Group__4"
    // InternalModelText.g:753:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:757:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalModelText.g:758:2: rule__Element__Group__4__Impl rule__Element__Group__5
            {
            pushFollow(FOLLOW_11);
            rule__Element__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__4"


    // $ANTLR start "rule__Element__Group__4__Impl"
    // InternalModelText.g:765:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:769:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // InternalModelText.g:770:1: ( ( rule__Element__Group_4__0 )? )
            {
            // InternalModelText.g:770:1: ( ( rule__Element__Group_4__0 )? )
            // InternalModelText.g:771:2: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalModelText.g:772:2: ( rule__Element__Group_4__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelText.g:772:3: rule__Element__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__4__Impl"


    // $ANTLR start "rule__Element__Group__5"
    // InternalModelText.g:780:1: rule__Element__Group__5 : rule__Element__Group__5__Impl rule__Element__Group__6 ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:784:1: ( rule__Element__Group__5__Impl rule__Element__Group__6 )
            // InternalModelText.g:785:2: rule__Element__Group__5__Impl rule__Element__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__Element__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__5"


    // $ANTLR start "rule__Element__Group__5__Impl"
    // InternalModelText.g:792:1: rule__Element__Group__5__Impl : ( ':' ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:796:1: ( ( ':' ) )
            // InternalModelText.g:797:1: ( ':' )
            {
            // InternalModelText.g:797:1: ( ':' )
            // InternalModelText.g:798:2: ':'
            {
             before(grammarAccess.getElementAccess().getColonKeyword_5()); 
            match(input,16,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getColonKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__5__Impl"


    // $ANTLR start "rule__Element__Group__6"
    // InternalModelText.g:807:1: rule__Element__Group__6 : rule__Element__Group__6__Impl ;
    public final void rule__Element__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:811:1: ( rule__Element__Group__6__Impl )
            // InternalModelText.g:812:2: rule__Element__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__6"


    // $ANTLR start "rule__Element__Group__6__Impl"
    // InternalModelText.g:818:1: rule__Element__Group__6__Impl : ( ( rule__Element__Group_6__0 )? ) ;
    public final void rule__Element__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:822:1: ( ( ( rule__Element__Group_6__0 )? ) )
            // InternalModelText.g:823:1: ( ( rule__Element__Group_6__0 )? )
            {
            // InternalModelText.g:823:1: ( ( rule__Element__Group_6__0 )? )
            // InternalModelText.g:824:2: ( rule__Element__Group_6__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_6()); 
            // InternalModelText.g:825:2: ( rule__Element__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)||LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalModelText.g:825:3: rule__Element__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Element__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getElementAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group__6__Impl"


    // $ANTLR start "rule__Element__Group_3__0"
    // InternalModelText.g:834:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:838:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalModelText.g:839:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Element__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__0"


    // $ANTLR start "rule__Element__Group_3__0__Impl"
    // InternalModelText.g:846:1: rule__Element__Group_3__0__Impl : ( '.' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:850:1: ( ( '.' ) )
            // InternalModelText.g:851:1: ( '.' )
            {
            // InternalModelText.g:851:1: ( '.' )
            // InternalModelText.g:852:2: '.'
            {
             before(grammarAccess.getElementAccess().getFullStopKeyword_3_0()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getFullStopKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__0__Impl"


    // $ANTLR start "rule__Element__Group_3__1"
    // InternalModelText.g:861:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:865:1: ( rule__Element__Group_3__1__Impl )
            // InternalModelText.g:866:2: rule__Element__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__1"


    // $ANTLR start "rule__Element__Group_3__1__Impl"
    // InternalModelText.g:872:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__RefAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:876:1: ( ( ( rule__Element__RefAssignment_3_1 ) ) )
            // InternalModelText.g:877:1: ( ( rule__Element__RefAssignment_3_1 ) )
            {
            // InternalModelText.g:877:1: ( ( rule__Element__RefAssignment_3_1 ) )
            // InternalModelText.g:878:2: ( rule__Element__RefAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getRefAssignment_3_1()); 
            // InternalModelText.g:879:2: ( rule__Element__RefAssignment_3_1 )
            // InternalModelText.g:879:3: rule__Element__RefAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__RefAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getRefAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_3__1__Impl"


    // $ANTLR start "rule__Element__Group_4__0"
    // InternalModelText.g:888:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:892:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalModelText.g:893:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
            {
            pushFollow(FOLLOW_13);
            rule__Element__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__0"


    // $ANTLR start "rule__Element__Group_4__0__Impl"
    // InternalModelText.g:900:1: rule__Element__Group_4__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:904:1: ( ( '(' ) )
            // InternalModelText.g:905:1: ( '(' )
            {
            // InternalModelText.g:905:1: ( '(' )
            // InternalModelText.g:906:2: '('
            {
             before(grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0()); 
            match(input,18,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__0__Impl"


    // $ANTLR start "rule__Element__Group_4__1"
    // InternalModelText.g:915:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl rule__Element__Group_4__2 ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:919:1: ( rule__Element__Group_4__1__Impl rule__Element__Group_4__2 )
            // InternalModelText.g:920:2: rule__Element__Group_4__1__Impl rule__Element__Group_4__2
            {
            pushFollow(FOLLOW_14);
            rule__Element__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__1"


    // $ANTLR start "rule__Element__Group_4__1__Impl"
    // InternalModelText.g:927:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__FeatureAssignment_4_1 ) ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:931:1: ( ( ( rule__Element__FeatureAssignment_4_1 ) ) )
            // InternalModelText.g:932:1: ( ( rule__Element__FeatureAssignment_4_1 ) )
            {
            // InternalModelText.g:932:1: ( ( rule__Element__FeatureAssignment_4_1 ) )
            // InternalModelText.g:933:2: ( rule__Element__FeatureAssignment_4_1 )
            {
             before(grammarAccess.getElementAccess().getFeatureAssignment_4_1()); 
            // InternalModelText.g:934:2: ( rule__Element__FeatureAssignment_4_1 )
            // InternalModelText.g:934:3: rule__Element__FeatureAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__FeatureAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getFeatureAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__1__Impl"


    // $ANTLR start "rule__Element__Group_4__2"
    // InternalModelText.g:942:1: rule__Element__Group_4__2 : rule__Element__Group_4__2__Impl rule__Element__Group_4__3 ;
    public final void rule__Element__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:946:1: ( rule__Element__Group_4__2__Impl rule__Element__Group_4__3 )
            // InternalModelText.g:947:2: rule__Element__Group_4__2__Impl rule__Element__Group_4__3
            {
            pushFollow(FOLLOW_14);
            rule__Element__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__2"


    // $ANTLR start "rule__Element__Group_4__2__Impl"
    // InternalModelText.g:954:1: rule__Element__Group_4__2__Impl : ( ( rule__Element__Group_4_2__0 )* ) ;
    public final void rule__Element__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:958:1: ( ( ( rule__Element__Group_4_2__0 )* ) )
            // InternalModelText.g:959:1: ( ( rule__Element__Group_4_2__0 )* )
            {
            // InternalModelText.g:959:1: ( ( rule__Element__Group_4_2__0 )* )
            // InternalModelText.g:960:2: ( rule__Element__Group_4_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_4_2()); 
            // InternalModelText.g:961:2: ( rule__Element__Group_4_2__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalModelText.g:961:3: rule__Element__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__Element__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getGroup_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__2__Impl"


    // $ANTLR start "rule__Element__Group_4__3"
    // InternalModelText.g:969:1: rule__Element__Group_4__3 : rule__Element__Group_4__3__Impl ;
    public final void rule__Element__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:973:1: ( rule__Element__Group_4__3__Impl )
            // InternalModelText.g:974:2: rule__Element__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__3"


    // $ANTLR start "rule__Element__Group_4__3__Impl"
    // InternalModelText.g:980:1: rule__Element__Group_4__3__Impl : ( ')' ) ;
    public final void rule__Element__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:984:1: ( ( ')' ) )
            // InternalModelText.g:985:1: ( ')' )
            {
            // InternalModelText.g:985:1: ( ')' )
            // InternalModelText.g:986:2: ')'
            {
             before(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_3()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4__3__Impl"


    // $ANTLR start "rule__Element__Group_4_2__0"
    // InternalModelText.g:996:1: rule__Element__Group_4_2__0 : rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1 ;
    public final void rule__Element__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1000:1: ( rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1 )
            // InternalModelText.g:1001:2: rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1
            {
            pushFollow(FOLLOW_13);
            rule__Element__Group_4_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_4_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_2__0"


    // $ANTLR start "rule__Element__Group_4_2__0__Impl"
    // InternalModelText.g:1008:1: rule__Element__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1012:1: ( ( ',' ) )
            // InternalModelText.g:1013:1: ( ',' )
            {
            // InternalModelText.g:1013:1: ( ',' )
            // InternalModelText.g:1014:2: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_4_2_0()); 
            match(input,20,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getCommaKeyword_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_2__0__Impl"


    // $ANTLR start "rule__Element__Group_4_2__1"
    // InternalModelText.g:1023:1: rule__Element__Group_4_2__1 : rule__Element__Group_4_2__1__Impl ;
    public final void rule__Element__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1027:1: ( rule__Element__Group_4_2__1__Impl )
            // InternalModelText.g:1028:2: rule__Element__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_4_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_2__1"


    // $ANTLR start "rule__Element__Group_4_2__1__Impl"
    // InternalModelText.g:1034:1: rule__Element__Group_4_2__1__Impl : ( ( rule__Element__FeatureAssignment_4_2_1 ) ) ;
    public final void rule__Element__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1038:1: ( ( ( rule__Element__FeatureAssignment_4_2_1 ) ) )
            // InternalModelText.g:1039:1: ( ( rule__Element__FeatureAssignment_4_2_1 ) )
            {
            // InternalModelText.g:1039:1: ( ( rule__Element__FeatureAssignment_4_2_1 ) )
            // InternalModelText.g:1040:2: ( rule__Element__FeatureAssignment_4_2_1 )
            {
             before(grammarAccess.getElementAccess().getFeatureAssignment_4_2_1()); 
            // InternalModelText.g:1041:2: ( rule__Element__FeatureAssignment_4_2_1 )
            // InternalModelText.g:1041:3: rule__Element__FeatureAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__FeatureAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getFeatureAssignment_4_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_4_2__1__Impl"


    // $ANTLR start "rule__Element__Group_6__0"
    // InternalModelText.g:1050:1: rule__Element__Group_6__0 : rule__Element__Group_6__0__Impl rule__Element__Group_6__1 ;
    public final void rule__Element__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1054:1: ( rule__Element__Group_6__0__Impl rule__Element__Group_6__1 )
            // InternalModelText.g:1055:2: rule__Element__Group_6__0__Impl rule__Element__Group_6__1
            {
            pushFollow(FOLLOW_12);
            rule__Element__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Element__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_6__0"


    // $ANTLR start "rule__Element__Group_6__0__Impl"
    // InternalModelText.g:1062:1: rule__Element__Group_6__0__Impl : ( ( rule__Element__WordsAssignment_6_0 ) ) ;
    public final void rule__Element__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1066:1: ( ( ( rule__Element__WordsAssignment_6_0 ) ) )
            // InternalModelText.g:1067:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            {
            // InternalModelText.g:1067:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            // InternalModelText.g:1068:2: ( rule__Element__WordsAssignment_6_0 )
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_0()); 
            // InternalModelText.g:1069:2: ( rule__Element__WordsAssignment_6_0 )
            // InternalModelText.g:1069:3: rule__Element__WordsAssignment_6_0
            {
            pushFollow(FOLLOW_2);
            rule__Element__WordsAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getWordsAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_6__0__Impl"


    // $ANTLR start "rule__Element__Group_6__1"
    // InternalModelText.g:1077:1: rule__Element__Group_6__1 : rule__Element__Group_6__1__Impl ;
    public final void rule__Element__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1081:1: ( rule__Element__Group_6__1__Impl )
            // InternalModelText.g:1082:2: rule__Element__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_6__1"


    // $ANTLR start "rule__Element__Group_6__1__Impl"
    // InternalModelText.g:1088:1: rule__Element__Group_6__1__Impl : ( ( rule__Element__WordsAssignment_6_1 )* ) ;
    public final void rule__Element__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1092:1: ( ( ( rule__Element__WordsAssignment_6_1 )* ) )
            // InternalModelText.g:1093:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            {
            // InternalModelText.g:1093:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            // InternalModelText.g:1094:2: ( rule__Element__WordsAssignment_6_1 )*
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_1()); 
            // InternalModelText.g:1095:2: ( rule__Element__WordsAssignment_6_1 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)||LA10_0==23) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalModelText.g:1095:3: rule__Element__WordsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Element__WordsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getElementAccess().getWordsAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__Group_6__1__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__0"
    // InternalModelText.g:1104:1: rule__ValuedFeature__Group__0 : rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 ;
    public final void rule__ValuedFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1108:1: ( rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 )
            // InternalModelText.g:1109:2: rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__ValuedFeature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__0"


    // $ANTLR start "rule__ValuedFeature__Group__0__Impl"
    // InternalModelText.g:1116:1: rule__ValuedFeature__Group__0__Impl : ( () ) ;
    public final void rule__ValuedFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1120:1: ( ( () ) )
            // InternalModelText.g:1121:1: ( () )
            {
            // InternalModelText.g:1121:1: ( () )
            // InternalModelText.g:1122:2: ()
            {
             before(grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0()); 
            // InternalModelText.g:1123:2: ()
            // InternalModelText.g:1123:3: 
            {
            }

             after(grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__0__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__1"
    // InternalModelText.g:1131:1: rule__ValuedFeature__Group__1 : rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 ;
    public final void rule__ValuedFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1135:1: ( rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 )
            // InternalModelText.g:1136:2: rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__ValuedFeature__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__1"


    // $ANTLR start "rule__ValuedFeature__Group__1__Impl"
    // InternalModelText.g:1143:1: rule__ValuedFeature__Group__1__Impl : ( ( rule__ValuedFeature__NegationAssignment_1 )? ) ;
    public final void rule__ValuedFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1147:1: ( ( ( rule__ValuedFeature__NegationAssignment_1 )? ) )
            // InternalModelText.g:1148:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            {
            // InternalModelText.g:1148:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            // InternalModelText.g:1149:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationAssignment_1()); 
            // InternalModelText.g:1150:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalModelText.g:1150:3: rule__ValuedFeature__NegationAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ValuedFeature__NegationAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValuedFeatureAccess().getNegationAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__1__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__2"
    // InternalModelText.g:1158:1: rule__ValuedFeature__Group__2 : rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 ;
    public final void rule__ValuedFeature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1162:1: ( rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 )
            // InternalModelText.g:1163:2: rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__ValuedFeature__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__2"


    // $ANTLR start "rule__ValuedFeature__Group__2__Impl"
    // InternalModelText.g:1170:1: rule__ValuedFeature__Group__2__Impl : ( ( rule__ValuedFeature__FeatAssignment_2 ) ) ;
    public final void rule__ValuedFeature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1174:1: ( ( ( rule__ValuedFeature__FeatAssignment_2 ) ) )
            // InternalModelText.g:1175:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            {
            // InternalModelText.g:1175:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            // InternalModelText.g:1176:2: ( rule__ValuedFeature__FeatAssignment_2 )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatAssignment_2()); 
            // InternalModelText.g:1177:2: ( rule__ValuedFeature__FeatAssignment_2 )
            // InternalModelText.g:1177:3: rule__ValuedFeature__FeatAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__FeatAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getFeatAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__2__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__3"
    // InternalModelText.g:1185:1: rule__ValuedFeature__Group__3 : rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 ;
    public final void rule__ValuedFeature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1189:1: ( rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 )
            // InternalModelText.g:1190:2: rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4
            {
            pushFollow(FOLLOW_17);
            rule__ValuedFeature__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__3"


    // $ANTLR start "rule__ValuedFeature__Group__3__Impl"
    // InternalModelText.g:1197:1: rule__ValuedFeature__Group__3__Impl : ( ( rule__ValuedFeature__Group_3__0 )? ) ;
    public final void rule__ValuedFeature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1201:1: ( ( ( rule__ValuedFeature__Group_3__0 )? ) )
            // InternalModelText.g:1202:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            {
            // InternalModelText.g:1202:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            // InternalModelText.g:1203:2: ( rule__ValuedFeature__Group_3__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_3()); 
            // InternalModelText.g:1204:2: ( rule__ValuedFeature__Group_3__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalModelText.g:1204:3: rule__ValuedFeature__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ValuedFeature__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValuedFeatureAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__3__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__4"
    // InternalModelText.g:1212:1: rule__ValuedFeature__Group__4 : rule__ValuedFeature__Group__4__Impl ;
    public final void rule__ValuedFeature__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1216:1: ( rule__ValuedFeature__Group__4__Impl )
            // InternalModelText.g:1217:2: rule__ValuedFeature__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__4"


    // $ANTLR start "rule__ValuedFeature__Group__4__Impl"
    // InternalModelText.g:1223:1: rule__ValuedFeature__Group__4__Impl : ( ( rule__ValuedFeature__Group_4__0 )? ) ;
    public final void rule__ValuedFeature__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1227:1: ( ( ( rule__ValuedFeature__Group_4__0 )? ) )
            // InternalModelText.g:1228:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            {
            // InternalModelText.g:1228:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            // InternalModelText.g:1229:2: ( rule__ValuedFeature__Group_4__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_4()); 
            // InternalModelText.g:1230:2: ( rule__ValuedFeature__Group_4__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalModelText.g:1230:3: rule__ValuedFeature__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ValuedFeature__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValuedFeatureAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__4__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_3__0"
    // InternalModelText.g:1239:1: rule__ValuedFeature__Group_3__0 : rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 ;
    public final void rule__ValuedFeature__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1243:1: ( rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 )
            // InternalModelText.g:1244:2: rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__ValuedFeature__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__0"


    // $ANTLR start "rule__ValuedFeature__Group_3__0__Impl"
    // InternalModelText.g:1251:1: rule__ValuedFeature__Group_3__0__Impl : ( '->' ) ;
    public final void rule__ValuedFeature__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1255:1: ( ( '->' ) )
            // InternalModelText.g:1256:1: ( '->' )
            {
            // InternalModelText.g:1256:1: ( '->' )
            // InternalModelText.g:1257:2: '->'
            {
             before(grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0()); 
            match(input,21,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__0__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_3__1"
    // InternalModelText.g:1266:1: rule__ValuedFeature__Group_3__1 : rule__ValuedFeature__Group_3__1__Impl ;
    public final void rule__ValuedFeature__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1270:1: ( rule__ValuedFeature__Group_3__1__Impl )
            // InternalModelText.g:1271:2: rule__ValuedFeature__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__1"


    // $ANTLR start "rule__ValuedFeature__Group_3__1__Impl"
    // InternalModelText.g:1277:1: rule__ValuedFeature__Group_3__1__Impl : ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) ;
    public final void rule__ValuedFeature__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1281:1: ( ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) )
            // InternalModelText.g:1282:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            {
            // InternalModelText.g:1282:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            // InternalModelText.g:1283:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureAssignment_3_1()); 
            // InternalModelText.g:1284:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            // InternalModelText.g:1284:3: rule__ValuedFeature__RefFeatureAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__RefFeatureAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getRefFeatureAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__1__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_4__0"
    // InternalModelText.g:1293:1: rule__ValuedFeature__Group_4__0 : rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 ;
    public final void rule__ValuedFeature__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1297:1: ( rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 )
            // InternalModelText.g:1298:2: rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1
            {
            pushFollow(FOLLOW_18);
            rule__ValuedFeature__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__0"


    // $ANTLR start "rule__ValuedFeature__Group_4__0__Impl"
    // InternalModelText.g:1305:1: rule__ValuedFeature__Group_4__0__Impl : ( '==' ) ;
    public final void rule__ValuedFeature__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1309:1: ( ( '==' ) )
            // InternalModelText.g:1310:1: ( '==' )
            {
            // InternalModelText.g:1310:1: ( '==' )
            // InternalModelText.g:1311:2: '=='
            {
             before(grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0()); 
            match(input,22,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__0__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_4__1"
    // InternalModelText.g:1320:1: rule__ValuedFeature__Group_4__1 : rule__ValuedFeature__Group_4__1__Impl ;
    public final void rule__ValuedFeature__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1324:1: ( rule__ValuedFeature__Group_4__1__Impl )
            // InternalModelText.g:1325:2: rule__ValuedFeature__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__1"


    // $ANTLR start "rule__ValuedFeature__Group_4__1__Impl"
    // InternalModelText.g:1331:1: rule__ValuedFeature__Group_4__1__Impl : ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) ;
    public final void rule__ValuedFeature__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1335:1: ( ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) )
            // InternalModelText.g:1336:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            {
            // InternalModelText.g:1336:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            // InternalModelText.g:1337:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueAssignment_4_1()); 
            // InternalModelText.g:1338:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            // InternalModelText.g:1338:3: rule__ValuedFeature__ValueAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__ValueAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getValueAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__1__Impl"


    // $ANTLR start "rule__Constant__Group__0"
    // InternalModelText.g:1347:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1351:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // InternalModelText.g:1352:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FOLLOW_4);
            rule__Constant__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Constant__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__0"


    // $ANTLR start "rule__Constant__Group__0__Impl"
    // InternalModelText.g:1359:1: rule__Constant__Group__0__Impl : ( () ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1363:1: ( ( () ) )
            // InternalModelText.g:1364:1: ( () )
            {
            // InternalModelText.g:1364:1: ( () )
            // InternalModelText.g:1365:2: ()
            {
             before(grammarAccess.getConstantAccess().getConstantAction_0()); 
            // InternalModelText.g:1366:2: ()
            // InternalModelText.g:1366:3: 
            {
            }

             after(grammarAccess.getConstantAccess().getConstantAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__0__Impl"


    // $ANTLR start "rule__Constant__Group__1"
    // InternalModelText.g:1374:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1378:1: ( rule__Constant__Group__1__Impl )
            // InternalModelText.g:1379:2: rule__Constant__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Constant__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__1"


    // $ANTLR start "rule__Constant__Group__1__Impl"
    // InternalModelText.g:1385:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__ValueAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1389:1: ( ( ( rule__Constant__ValueAssignment_1 ) ) )
            // InternalModelText.g:1390:1: ( ( rule__Constant__ValueAssignment_1 ) )
            {
            // InternalModelText.g:1390:1: ( ( rule__Constant__ValueAssignment_1 ) )
            // InternalModelText.g:1391:2: ( rule__Constant__ValueAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1()); 
            // InternalModelText.g:1392:2: ( rule__Constant__ValueAssignment_1 )
            // InternalModelText.g:1392:3: rule__Constant__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Constant__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__Group__1__Impl"


    // $ANTLR start "rule__Variable__Group__0"
    // InternalModelText.g:1401:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1405:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalModelText.g:1406:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0"


    // $ANTLR start "rule__Variable__Group__0__Impl"
    // InternalModelText.g:1413:1: rule__Variable__Group__0__Impl : ( () ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1417:1: ( ( () ) )
            // InternalModelText.g:1418:1: ( () )
            {
            // InternalModelText.g:1418:1: ( () )
            // InternalModelText.g:1419:2: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0()); 
            // InternalModelText.g:1420:2: ()
            // InternalModelText.g:1420:3: 
            {
            }

             after(grammarAccess.getVariableAccess().getVariableAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__0__Impl"


    // $ANTLR start "rule__Variable__Group__1"
    // InternalModelText.g:1428:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1432:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalModelText.g:1433:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Variable__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1"


    // $ANTLR start "rule__Variable__Group__1__Impl"
    // InternalModelText.g:1440:1: rule__Variable__Group__1__Impl : ( '%' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1444:1: ( ( '%' ) )
            // InternalModelText.g:1445:1: ( '%' )
            {
            // InternalModelText.g:1445:1: ( '%' )
            // InternalModelText.g:1446:2: '%'
            {
             before(grammarAccess.getVariableAccess().getPercentSignKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getPercentSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__1__Impl"


    // $ANTLR start "rule__Variable__Group__2"
    // InternalModelText.g:1455:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1459:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalModelText.g:1460:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Variable__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2"


    // $ANTLR start "rule__Variable__Group__2__Impl"
    // InternalModelText.g:1467:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Group_2__0 )? ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1471:1: ( ( ( rule__Variable__Group_2__0 )? ) )
            // InternalModelText.g:1472:1: ( ( rule__Variable__Group_2__0 )? )
            {
            // InternalModelText.g:1472:1: ( ( rule__Variable__Group_2__0 )? )
            // InternalModelText.g:1473:2: ( rule__Variable__Group_2__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2()); 
            // InternalModelText.g:1474:2: ( rule__Variable__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==17) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // InternalModelText.g:1474:3: rule__Variable__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Variable__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__2__Impl"


    // $ANTLR start "rule__Variable__Group__3"
    // InternalModelText.g:1482:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1486:1: ( rule__Variable__Group__3__Impl )
            // InternalModelText.g:1487:2: rule__Variable__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__3"


    // $ANTLR start "rule__Variable__Group__3__Impl"
    // InternalModelText.g:1493:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__IdAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1497:1: ( ( ( rule__Variable__IdAssignment_3 ) ) )
            // InternalModelText.g:1498:1: ( ( rule__Variable__IdAssignment_3 ) )
            {
            // InternalModelText.g:1498:1: ( ( rule__Variable__IdAssignment_3 ) )
            // InternalModelText.g:1499:2: ( rule__Variable__IdAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getIdAssignment_3()); 
            // InternalModelText.g:1500:2: ( rule__Variable__IdAssignment_3 )
            // InternalModelText.g:1500:3: rule__Variable__IdAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Variable__IdAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getIdAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group__3__Impl"


    // $ANTLR start "rule__Variable__Group_2__0"
    // InternalModelText.g:1509:1: rule__Variable__Group_2__0 : rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 ;
    public final void rule__Variable__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1513:1: ( rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 )
            // InternalModelText.g:1514:2: rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1
            {
            pushFollow(FOLLOW_20);
            rule__Variable__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Variable__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2__0"


    // $ANTLR start "rule__Variable__Group_2__0__Impl"
    // InternalModelText.g:1521:1: rule__Variable__Group_2__0__Impl : ( ( rule__Variable__RefAssignment_2_0 ) ) ;
    public final void rule__Variable__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1525:1: ( ( ( rule__Variable__RefAssignment_2_0 ) ) )
            // InternalModelText.g:1526:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            {
            // InternalModelText.g:1526:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            // InternalModelText.g:1527:2: ( rule__Variable__RefAssignment_2_0 )
            {
             before(grammarAccess.getVariableAccess().getRefAssignment_2_0()); 
            // InternalModelText.g:1528:2: ( rule__Variable__RefAssignment_2_0 )
            // InternalModelText.g:1528:3: rule__Variable__RefAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Variable__RefAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getRefAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2__0__Impl"


    // $ANTLR start "rule__Variable__Group_2__1"
    // InternalModelText.g:1536:1: rule__Variable__Group_2__1 : rule__Variable__Group_2__1__Impl ;
    public final void rule__Variable__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1540:1: ( rule__Variable__Group_2__1__Impl )
            // InternalModelText.g:1541:2: rule__Variable__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2__1"


    // $ANTLR start "rule__Variable__Group_2__1__Impl"
    // InternalModelText.g:1547:1: rule__Variable__Group_2__1__Impl : ( '.' ) ;
    public final void rule__Variable__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1551:1: ( ( '.' ) )
            // InternalModelText.g:1552:1: ( '.' )
            {
            // InternalModelText.g:1552:1: ( '.' )
            // InternalModelText.g:1553:2: '.'
            {
             before(grammarAccess.getVariableAccess().getFullStopKeyword_2_1()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getFullStopKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__Group_2__1__Impl"


    // $ANTLR start "rule__Macro__Group__0"
    // InternalModelText.g:1563:1: rule__Macro__Group__0 : rule__Macro__Group__0__Impl rule__Macro__Group__1 ;
    public final void rule__Macro__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1567:1: ( rule__Macro__Group__0__Impl rule__Macro__Group__1 )
            // InternalModelText.g:1568:2: rule__Macro__Group__0__Impl rule__Macro__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__Macro__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Macro__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__0"


    // $ANTLR start "rule__Macro__Group__0__Impl"
    // InternalModelText.g:1575:1: rule__Macro__Group__0__Impl : ( () ) ;
    public final void rule__Macro__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1579:1: ( ( () ) )
            // InternalModelText.g:1580:1: ( () )
            {
            // InternalModelText.g:1580:1: ( () )
            // InternalModelText.g:1581:2: ()
            {
             before(grammarAccess.getMacroAccess().getMacroAction_0()); 
            // InternalModelText.g:1582:2: ()
            // InternalModelText.g:1582:3: 
            {
            }

             after(grammarAccess.getMacroAccess().getMacroAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__0__Impl"


    // $ANTLR start "rule__Macro__Group__1"
    // InternalModelText.g:1590:1: rule__Macro__Group__1 : rule__Macro__Group__1__Impl rule__Macro__Group__2 ;
    public final void rule__Macro__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1594:1: ( rule__Macro__Group__1__Impl rule__Macro__Group__2 )
            // InternalModelText.g:1595:2: rule__Macro__Group__1__Impl rule__Macro__Group__2
            {
            pushFollow(FOLLOW_21);
            rule__Macro__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Macro__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__1"


    // $ANTLR start "rule__Macro__Group__1__Impl"
    // InternalModelText.g:1602:1: rule__Macro__Group__1__Impl : ( '%' ) ;
    public final void rule__Macro__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1606:1: ( ( '%' ) )
            // InternalModelText.g:1607:1: ( '%' )
            {
            // InternalModelText.g:1607:1: ( '%' )
            // InternalModelText.g:1608:2: '%'
            {
             before(grammarAccess.getMacroAccess().getPercentSignKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getMacroAccess().getPercentSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__1__Impl"


    // $ANTLR start "rule__Macro__Group__2"
    // InternalModelText.g:1617:1: rule__Macro__Group__2 : rule__Macro__Group__2__Impl ;
    public final void rule__Macro__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1621:1: ( rule__Macro__Group__2__Impl )
            // InternalModelText.g:1622:2: rule__Macro__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Macro__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__2"


    // $ANTLR start "rule__Macro__Group__2__Impl"
    // InternalModelText.g:1628:1: rule__Macro__Group__2__Impl : ( ( rule__Macro__ItemAssignment_2 ) ) ;
    public final void rule__Macro__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1632:1: ( ( ( rule__Macro__ItemAssignment_2 ) ) )
            // InternalModelText.g:1633:1: ( ( rule__Macro__ItemAssignment_2 ) )
            {
            // InternalModelText.g:1633:1: ( ( rule__Macro__ItemAssignment_2 ) )
            // InternalModelText.g:1634:2: ( rule__Macro__ItemAssignment_2 )
            {
             before(grammarAccess.getMacroAccess().getItemAssignment_2()); 
            // InternalModelText.g:1635:2: ( rule__Macro__ItemAssignment_2 )
            // InternalModelText.g:1635:3: rule__Macro__ItemAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Macro__ItemAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMacroAccess().getItemAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__Group__2__Impl"


    // $ANTLR start "rule__IdentifyElements__MetamodelAssignment_2"
    // InternalModelText.g:1644:1: rule__IdentifyElements__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__IdentifyElements__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1648:1: ( ( ruleEString ) )
            // InternalModelText.g:1649:2: ( ruleEString )
            {
            // InternalModelText.g:1649:2: ( ruleEString )
            // InternalModelText.g:1650:3: ruleEString
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__MetamodelAssignment_2"


    // $ANTLR start "rule__IdentifyElements__InstancesAssignment_3"
    // InternalModelText.g:1659:1: rule__IdentifyElements__InstancesAssignment_3 : ( ruleMutatorInstance ) ;
    public final void rule__IdentifyElements__InstancesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1663:1: ( ( ruleMutatorInstance ) )
            // InternalModelText.g:1664:2: ( ruleMutatorInstance )
            {
            // InternalModelText.g:1664:2: ( ruleMutatorInstance )
            // InternalModelText.g:1665:3: ruleMutatorInstance
            {
             before(grammarAccess.getIdentifyElementsAccess().getInstancesMutatorInstanceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMutatorInstance();

            state._fsp--;

             after(grammarAccess.getIdentifyElementsAccess().getInstancesMutatorInstanceParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IdentifyElements__InstancesAssignment_3"


    // $ANTLR start "rule__MutatorInstance__NameAssignment_1"
    // InternalModelText.g:1674:1: rule__MutatorInstance__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MutatorInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1678:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1679:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1679:2: ( ( RULE_ID ) )
            // InternalModelText.g:1680:3: ( RULE_ID )
            {
             before(grammarAccess.getMutatorInstanceAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelText.g:1681:3: ( RULE_ID )
            // InternalModelText.g:1682:4: RULE_ID
            {
             before(grammarAccess.getMutatorInstanceAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMutatorInstanceAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMutatorInstanceAccess().getNameEClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__NameAssignment_1"


    // $ANTLR start "rule__MutatorInstance__ElementsAssignment_3_0"
    // InternalModelText.g:1693:1: rule__MutatorInstance__ElementsAssignment_3_0 : ( ruleElement ) ;
    public final void rule__MutatorInstance__ElementsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1697:1: ( ( ruleElement ) )
            // InternalModelText.g:1698:2: ( ruleElement )
            {
            // InternalModelText.g:1698:2: ( ruleElement )
            // InternalModelText.g:1699:3: ruleElement
            {
             before(grammarAccess.getMutatorInstanceAccess().getElementsElementParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceAccess().getElementsElementParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__ElementsAssignment_3_0"


    // $ANTLR start "rule__MutatorInstance__ElementsAssignment_3_1"
    // InternalModelText.g:1708:1: rule__MutatorInstance__ElementsAssignment_3_1 : ( ruleElement ) ;
    public final void rule__MutatorInstance__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1712:1: ( ( ruleElement ) )
            // InternalModelText.g:1713:2: ( ruleElement )
            {
            // InternalModelText.g:1713:2: ( ruleElement )
            // InternalModelText.g:1714:3: ruleElement
            {
             before(grammarAccess.getMutatorInstanceAccess().getElementsElementParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceAccess().getElementsElementParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__ElementsAssignment_3_1"


    // $ANTLR start "rule__Element__TypeAssignment_2"
    // InternalModelText.g:1723:1: rule__Element__TypeAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__Element__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1727:1: ( ( ( ruleEString ) ) )
            // InternalModelText.g:1728:2: ( ( ruleEString ) )
            {
            // InternalModelText.g:1728:2: ( ( ruleEString ) )
            // InternalModelText.g:1729:3: ( ruleEString )
            {
             before(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); 
            // InternalModelText.g:1730:3: ( ruleEString )
            // InternalModelText.g:1731:4: ruleEString
            {
             before(grammarAccess.getElementAccess().getTypeEClassEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getElementAccess().getTypeEClassEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__TypeAssignment_2"


    // $ANTLR start "rule__Element__RefAssignment_3_1"
    // InternalModelText.g:1742:1: rule__Element__RefAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__RefAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1746:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1747:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1747:2: ( ( RULE_ID ) )
            // InternalModelText.g:1748:3: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); 
            // InternalModelText.g:1749:3: ( RULE_ID )
            // InternalModelText.g:1750:4: RULE_ID
            {
             before(grammarAccess.getElementAccess().getRefEReferenceIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRefEReferenceIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__RefAssignment_3_1"


    // $ANTLR start "rule__Element__FeatureAssignment_4_1"
    // InternalModelText.g:1761:1: rule__Element__FeatureAssignment_4_1 : ( ruleValuedFeature ) ;
    public final void rule__Element__FeatureAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1765:1: ( ( ruleValuedFeature ) )
            // InternalModelText.g:1766:2: ( ruleValuedFeature )
            {
            // InternalModelText.g:1766:2: ( ruleValuedFeature )
            // InternalModelText.g:1767:3: ruleValuedFeature
            {
             before(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__FeatureAssignment_4_1"


    // $ANTLR start "rule__Element__FeatureAssignment_4_2_1"
    // InternalModelText.g:1776:1: rule__Element__FeatureAssignment_4_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Element__FeatureAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1780:1: ( ( ruleValuedFeature ) )
            // InternalModelText.g:1781:2: ( ruleValuedFeature )
            {
            // InternalModelText.g:1781:2: ( ruleValuedFeature )
            // InternalModelText.g:1782:3: ruleValuedFeature
            {
             before(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getElementAccess().getFeatureValuedFeatureParserRuleCall_4_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__FeatureAssignment_4_2_1"


    // $ANTLR start "rule__Element__WordsAssignment_6_0"
    // InternalModelText.g:1791:1: rule__Element__WordsAssignment_6_0 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1795:1: ( ( ruleWord ) )
            // InternalModelText.g:1796:2: ( ruleWord )
            {
            // InternalModelText.g:1796:2: ( ruleWord )
            // InternalModelText.g:1797:3: ruleWord
            {
             before(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0()); 
            pushFollow(FOLLOW_2);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__WordsAssignment_6_0"


    // $ANTLR start "rule__Element__WordsAssignment_6_1"
    // InternalModelText.g:1806:1: rule__Element__WordsAssignment_6_1 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1810:1: ( ( ruleWord ) )
            // InternalModelText.g:1811:2: ( ruleWord )
            {
            // InternalModelText.g:1811:2: ( ruleWord )
            // InternalModelText.g:1812:3: ruleWord
            {
             before(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Element__WordsAssignment_6_1"


    // $ANTLR start "rule__ValuedFeature__NegationAssignment_1"
    // InternalModelText.g:1821:1: rule__ValuedFeature__NegationAssignment_1 : ( ( 'not' ) ) ;
    public final void rule__ValuedFeature__NegationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1825:1: ( ( ( 'not' ) ) )
            // InternalModelText.g:1826:2: ( ( 'not' ) )
            {
            // InternalModelText.g:1826:2: ( ( 'not' ) )
            // InternalModelText.g:1827:3: ( 'not' )
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 
            // InternalModelText.g:1828:3: ( 'not' )
            // InternalModelText.g:1829:4: 'not'
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__NegationAssignment_1"


    // $ANTLR start "rule__ValuedFeature__FeatAssignment_2"
    // InternalModelText.g:1840:1: rule__ValuedFeature__FeatAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__FeatAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1844:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1845:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1845:2: ( ( RULE_ID ) )
            // InternalModelText.g:1846:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0()); 
            // InternalModelText.g:1847:3: ( RULE_ID )
            // InternalModelText.g:1848:4: RULE_ID
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__FeatAssignment_2"


    // $ANTLR start "rule__ValuedFeature__RefFeatureAssignment_3_1"
    // InternalModelText.g:1859:1: rule__ValuedFeature__RefFeatureAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__RefFeatureAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1863:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1864:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1864:2: ( ( RULE_ID ) )
            // InternalModelText.g:1865:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0()); 
            // InternalModelText.g:1866:3: ( RULE_ID )
            // InternalModelText.g:1867:4: RULE_ID
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__RefFeatureAssignment_3_1"


    // $ANTLR start "rule__ValuedFeature__ValueAssignment_4_1"
    // InternalModelText.g:1878:1: rule__ValuedFeature__ValueAssignment_4_1 : ( ( 'null' ) ) ;
    public final void rule__ValuedFeature__ValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1882:1: ( ( ( 'null' ) ) )
            // InternalModelText.g:1883:2: ( ( 'null' ) )
            {
            // InternalModelText.g:1883:2: ( ( 'null' ) )
            // InternalModelText.g:1884:3: ( 'null' )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 
            // InternalModelText.g:1885:3: ( 'null' )
            // InternalModelText.g:1886:4: 'null'
            {
             before(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__ValueAssignment_4_1"


    // $ANTLR start "rule__Constant__ValueAssignment_1"
    // InternalModelText.g:1897:1: rule__Constant__ValueAssignment_1 : ( ruleEString ) ;
    public final void rule__Constant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1901:1: ( ( ruleEString ) )
            // InternalModelText.g:1902:2: ( ruleEString )
            {
            // InternalModelText.g:1902:2: ( ruleEString )
            // InternalModelText.g:1903:3: ruleEString
            {
             before(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Constant__ValueAssignment_1"


    // $ANTLR start "rule__Variable__RefAssignment_2_0"
    // InternalModelText.g:1912:1: rule__Variable__RefAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__RefAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1916:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1917:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1917:2: ( ( RULE_ID ) )
            // InternalModelText.g:1918:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); 
            // InternalModelText.g:1919:3: ( RULE_ID )
            // InternalModelText.g:1920:4: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getRefEReferenceIDTerminalRuleCall_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getRefEReferenceIDTerminalRuleCall_2_0_0_1()); 

            }

             after(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__RefAssignment_2_0"


    // $ANTLR start "rule__Variable__IdAssignment_3"
    // InternalModelText.g:1931:1: rule__Variable__IdAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__IdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1935:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1936:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1936:2: ( ( RULE_ID ) )
            // InternalModelText.g:1937:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); 
            // InternalModelText.g:1938:3: ( RULE_ID )
            // InternalModelText.g:1939:4: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getIdEAttributeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getVariableAccess().getIdEAttributeIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__IdAssignment_3"


    // $ANTLR start "rule__Macro__ItemAssignment_2"
    // InternalModelText.g:1950:1: rule__Macro__ItemAssignment_2 : ( ruleMacroItem ) ;
    public final void rule__Macro__ItemAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1954:1: ( ( ruleMacroItem ) )
            // InternalModelText.g:1955:2: ( ruleMacroItem )
            {
            // InternalModelText.g:1955:2: ( ruleMacroItem )
            // InternalModelText.g:1956:3: ruleMacroItem
            {
             before(grammarAccess.getMacroAccess().getItemMacroItemEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMacroItem();

            state._fsp--;

             after(grammarAccess.getMacroAccess().getItemMacroItemEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Macro__ItemAssignment_2"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000070000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000800030L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800032L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000800L});

}