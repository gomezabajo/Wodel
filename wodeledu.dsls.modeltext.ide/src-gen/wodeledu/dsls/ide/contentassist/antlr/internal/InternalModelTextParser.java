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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'type'", "'metamodel'", "'>'", "':'", "'.'", "'('", "')'", "','", "'->'", "'=='", "'%'", "'not'", "'null'"
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


    // $ANTLR start "entryRuleElement"
    // InternalModelText.g:78:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // InternalModelText.g:79:1: ( ruleElement EOF )
            // InternalModelText.g:80:1: ruleElement EOF
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
    // InternalModelText.g:87:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:91:2: ( ( ( rule__Element__Group__0 ) ) )
            // InternalModelText.g:92:2: ( ( rule__Element__Group__0 ) )
            {
            // InternalModelText.g:92:2: ( ( rule__Element__Group__0 ) )
            // InternalModelText.g:93:3: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // InternalModelText.g:94:3: ( rule__Element__Group__0 )
            // InternalModelText.g:94:4: rule__Element__Group__0
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
    // InternalModelText.g:103:1: entryRuleValuedFeature : ruleValuedFeature EOF ;
    public final void entryRuleValuedFeature() throws RecognitionException {
        try {
            // InternalModelText.g:104:1: ( ruleValuedFeature EOF )
            // InternalModelText.g:105:1: ruleValuedFeature EOF
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
    // InternalModelText.g:112:1: ruleValuedFeature : ( ( rule__ValuedFeature__Group__0 ) ) ;
    public final void ruleValuedFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:116:2: ( ( ( rule__ValuedFeature__Group__0 ) ) )
            // InternalModelText.g:117:2: ( ( rule__ValuedFeature__Group__0 ) )
            {
            // InternalModelText.g:117:2: ( ( rule__ValuedFeature__Group__0 ) )
            // InternalModelText.g:118:3: ( rule__ValuedFeature__Group__0 )
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup()); 
            // InternalModelText.g:119:3: ( rule__ValuedFeature__Group__0 )
            // InternalModelText.g:119:4: rule__ValuedFeature__Group__0
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
    // InternalModelText.g:128:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalModelText.g:129:1: ( ruleWord EOF )
            // InternalModelText.g:130:1: ruleWord EOF
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
    // InternalModelText.g:137:1: ruleWord : ( ( rule__Word__Alternatives ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:141:2: ( ( ( rule__Word__Alternatives ) ) )
            // InternalModelText.g:142:2: ( ( rule__Word__Alternatives ) )
            {
            // InternalModelText.g:142:2: ( ( rule__Word__Alternatives ) )
            // InternalModelText.g:143:3: ( rule__Word__Alternatives )
            {
             before(grammarAccess.getWordAccess().getAlternatives()); 
            // InternalModelText.g:144:3: ( rule__Word__Alternatives )
            // InternalModelText.g:144:4: rule__Word__Alternatives
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
    // InternalModelText.g:153:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalModelText.g:154:1: ( ruleConstant EOF )
            // InternalModelText.g:155:1: ruleConstant EOF
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
    // InternalModelText.g:162:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:166:2: ( ( ( rule__Constant__Group__0 ) ) )
            // InternalModelText.g:167:2: ( ( rule__Constant__Group__0 ) )
            {
            // InternalModelText.g:167:2: ( ( rule__Constant__Group__0 ) )
            // InternalModelText.g:168:3: ( rule__Constant__Group__0 )
            {
             before(grammarAccess.getConstantAccess().getGroup()); 
            // InternalModelText.g:169:3: ( rule__Constant__Group__0 )
            // InternalModelText.g:169:4: rule__Constant__Group__0
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
    // InternalModelText.g:178:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalModelText.g:179:1: ( ruleVariable EOF )
            // InternalModelText.g:180:1: ruleVariable EOF
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
    // InternalModelText.g:187:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:191:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalModelText.g:192:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalModelText.g:192:2: ( ( rule__Variable__Group__0 ) )
            // InternalModelText.g:193:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalModelText.g:194:3: ( rule__Variable__Group__0 )
            // InternalModelText.g:194:4: rule__Variable__Group__0
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
    // InternalModelText.g:203:1: entryRuleMacro : ruleMacro EOF ;
    public final void entryRuleMacro() throws RecognitionException {
        try {
            // InternalModelText.g:204:1: ( ruleMacro EOF )
            // InternalModelText.g:205:1: ruleMacro EOF
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
    // InternalModelText.g:212:1: ruleMacro : ( ( rule__Macro__Group__0 ) ) ;
    public final void ruleMacro() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:216:2: ( ( ( rule__Macro__Group__0 ) ) )
            // InternalModelText.g:217:2: ( ( rule__Macro__Group__0 ) )
            {
            // InternalModelText.g:217:2: ( ( rule__Macro__Group__0 ) )
            // InternalModelText.g:218:3: ( rule__Macro__Group__0 )
            {
             before(grammarAccess.getMacroAccess().getGroup()); 
            // InternalModelText.g:219:3: ( rule__Macro__Group__0 )
            // InternalModelText.g:219:4: rule__Macro__Group__0
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


    // $ANTLR start "entryRuleEString"
    // InternalModelText.g:228:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalModelText.g:229:1: ( ruleEString EOF )
            // InternalModelText.g:230:1: ruleEString EOF
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
    // InternalModelText.g:237:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:241:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalModelText.g:242:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalModelText.g:242:2: ( ( rule__EString__Alternatives ) )
            // InternalModelText.g:243:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalModelText.g:244:3: ( rule__EString__Alternatives )
            // InternalModelText.g:244:4: rule__EString__Alternatives
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


    // $ANTLR start "ruleMacroItem"
    // InternalModelText.g:253:1: ruleMacroItem : ( ( 'type' ) ) ;
    public final void ruleMacroItem() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:257:1: ( ( ( 'type' ) ) )
            // InternalModelText.g:258:2: ( ( 'type' ) )
            {
            // InternalModelText.g:258:2: ( ( 'type' ) )
            // InternalModelText.g:259:3: ( 'type' )
            {
             before(grammarAccess.getMacroItemAccess().getTypeEnumLiteralDeclaration()); 
            // InternalModelText.g:260:3: ( 'type' )
            // InternalModelText.g:260:4: 'type'
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


    // $ANTLR start "rule__Word__Alternatives"
    // InternalModelText.g:268:1: rule__Word__Alternatives : ( ( ruleConstant ) | ( ruleVariable ) | ( ruleMacro ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:272:1: ( ( ruleConstant ) | ( ruleVariable ) | ( ruleMacro ) )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( (LA1_0==21) ) {
                int LA1_2 = input.LA(2);

                if ( (LA1_2==11) ) {
                    alt1=3;
                }
                else if ( (LA1_2==RULE_ID) ) {
                    alt1=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalModelText.g:273:2: ( ruleConstant )
                    {
                    // InternalModelText.g:273:2: ( ruleConstant )
                    // InternalModelText.g:274:3: ruleConstant
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
                    // InternalModelText.g:279:2: ( ruleVariable )
                    {
                    // InternalModelText.g:279:2: ( ruleVariable )
                    // InternalModelText.g:280:3: ruleVariable
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
                    // InternalModelText.g:285:2: ( ruleMacro )
                    {
                    // InternalModelText.g:285:2: ( ruleMacro )
                    // InternalModelText.g:286:3: ruleMacro
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


    // $ANTLR start "rule__EString__Alternatives"
    // InternalModelText.g:295:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:299:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_STRING) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_ID) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalModelText.g:300:2: ( RULE_STRING )
                    {
                    // InternalModelText.g:300:2: ( RULE_STRING )
                    // InternalModelText.g:301:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelText.g:306:2: ( RULE_ID )
                    {
                    // InternalModelText.g:306:2: ( RULE_ID )
                    // InternalModelText.g:307:3: RULE_ID
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


    // $ANTLR start "rule__IdentifyElements__Group__0"
    // InternalModelText.g:316:1: rule__IdentifyElements__Group__0 : rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 ;
    public final void rule__IdentifyElements__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:320:1: ( rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 )
            // InternalModelText.g:321:2: rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1
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
    // InternalModelText.g:328:1: rule__IdentifyElements__Group__0__Impl : ( () ) ;
    public final void rule__IdentifyElements__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:332:1: ( ( () ) )
            // InternalModelText.g:333:1: ( () )
            {
            // InternalModelText.g:333:1: ( () )
            // InternalModelText.g:334:2: ()
            {
             before(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); 
            // InternalModelText.g:335:2: ()
            // InternalModelText.g:335:3: 
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
    // InternalModelText.g:343:1: rule__IdentifyElements__Group__1 : rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 ;
    public final void rule__IdentifyElements__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:347:1: ( rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 )
            // InternalModelText.g:348:2: rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2
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
    // InternalModelText.g:355:1: rule__IdentifyElements__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__IdentifyElements__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:359:1: ( ( 'metamodel' ) )
            // InternalModelText.g:360:1: ( 'metamodel' )
            {
            // InternalModelText.g:360:1: ( 'metamodel' )
            // InternalModelText.g:361:2: 'metamodel'
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
    // InternalModelText.g:370:1: rule__IdentifyElements__Group__2 : rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 ;
    public final void rule__IdentifyElements__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:374:1: ( rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 )
            // InternalModelText.g:375:2: rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3
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
    // InternalModelText.g:382:1: rule__IdentifyElements__Group__2__Impl : ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) ;
    public final void rule__IdentifyElements__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:386:1: ( ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) )
            // InternalModelText.g:387:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            {
            // InternalModelText.g:387:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            // InternalModelText.g:388:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); 
            // InternalModelText.g:389:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            // InternalModelText.g:389:3: rule__IdentifyElements__MetamodelAssignment_2
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
    // InternalModelText.g:397:1: rule__IdentifyElements__Group__3 : rule__IdentifyElements__Group__3__Impl ;
    public final void rule__IdentifyElements__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:401:1: ( rule__IdentifyElements__Group__3__Impl )
            // InternalModelText.g:402:2: rule__IdentifyElements__Group__3__Impl
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
    // InternalModelText.g:408:1: rule__IdentifyElements__Group__3__Impl : ( ( rule__IdentifyElements__Group_3__0 )? ) ;
    public final void rule__IdentifyElements__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:412:1: ( ( ( rule__IdentifyElements__Group_3__0 )? ) )
            // InternalModelText.g:413:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            {
            // InternalModelText.g:413:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            // InternalModelText.g:414:2: ( rule__IdentifyElements__Group_3__0 )?
            {
             before(grammarAccess.getIdentifyElementsAccess().getGroup_3()); 
            // InternalModelText.g:415:2: ( rule__IdentifyElements__Group_3__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalModelText.g:415:3: rule__IdentifyElements__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__IdentifyElements__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getIdentifyElementsAccess().getGroup_3()); 

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


    // $ANTLR start "rule__IdentifyElements__Group_3__0"
    // InternalModelText.g:424:1: rule__IdentifyElements__Group_3__0 : rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 ;
    public final void rule__IdentifyElements__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:428:1: ( rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 )
            // InternalModelText.g:429:2: rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__IdentifyElements__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__IdentifyElements__Group_3__1();

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
    // $ANTLR end "rule__IdentifyElements__Group_3__0"


    // $ANTLR start "rule__IdentifyElements__Group_3__0__Impl"
    // InternalModelText.g:436:1: rule__IdentifyElements__Group_3__0__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) ;
    public final void rule__IdentifyElements__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:440:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) )
            // InternalModelText.g:441:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            {
            // InternalModelText.g:441:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            // InternalModelText.g:442:2: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_0()); 
            // InternalModelText.g:443:2: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            // InternalModelText.g:443:3: rule__IdentifyElements__ElementsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__IdentifyElements__ElementsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_0()); 

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
    // $ANTLR end "rule__IdentifyElements__Group_3__0__Impl"


    // $ANTLR start "rule__IdentifyElements__Group_3__1"
    // InternalModelText.g:451:1: rule__IdentifyElements__Group_3__1 : rule__IdentifyElements__Group_3__1__Impl ;
    public final void rule__IdentifyElements__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:455:1: ( rule__IdentifyElements__Group_3__1__Impl )
            // InternalModelText.g:456:2: rule__IdentifyElements__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__IdentifyElements__Group_3__1__Impl();

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
    // $ANTLR end "rule__IdentifyElements__Group_3__1"


    // $ANTLR start "rule__IdentifyElements__Group_3__1__Impl"
    // InternalModelText.g:462:1: rule__IdentifyElements__Group_3__1__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) ;
    public final void rule__IdentifyElements__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:466:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) )
            // InternalModelText.g:467:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            {
            // InternalModelText.g:467:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            // InternalModelText.g:468:2: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_1()); 
            // InternalModelText.g:469:2: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==13) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalModelText.g:469:3: rule__IdentifyElements__ElementsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__IdentifyElements__ElementsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_1()); 

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
    // $ANTLR end "rule__IdentifyElements__Group_3__1__Impl"


    // $ANTLR start "rule__Element__Group__0"
    // InternalModelText.g:478:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:482:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalModelText.g:483:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalModelText.g:490:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:494:1: ( ( () ) )
            // InternalModelText.g:495:1: ( () )
            {
            // InternalModelText.g:495:1: ( () )
            // InternalModelText.g:496:2: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalModelText.g:497:2: ()
            // InternalModelText.g:497:3: 
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
    // InternalModelText.g:505:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:509:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalModelText.g:510:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalModelText.g:517:1: rule__Element__Group__1__Impl : ( '>' ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:521:1: ( ( '>' ) )
            // InternalModelText.g:522:1: ( '>' )
            {
            // InternalModelText.g:522:1: ( '>' )
            // InternalModelText.g:523:2: '>'
            {
             before(grammarAccess.getElementAccess().getGreaterThanSignKeyword_1()); 
            match(input,13,FOLLOW_2); 
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
    // InternalModelText.g:532:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:536:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalModelText.g:537:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FOLLOW_7);
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
    // InternalModelText.g:544:1: rule__Element__Group__2__Impl : ( ( rule__Element__TypeAssignment_2 ) ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:548:1: ( ( ( rule__Element__TypeAssignment_2 ) ) )
            // InternalModelText.g:549:1: ( ( rule__Element__TypeAssignment_2 ) )
            {
            // InternalModelText.g:549:1: ( ( rule__Element__TypeAssignment_2 ) )
            // InternalModelText.g:550:2: ( rule__Element__TypeAssignment_2 )
            {
             before(grammarAccess.getElementAccess().getTypeAssignment_2()); 
            // InternalModelText.g:551:2: ( rule__Element__TypeAssignment_2 )
            // InternalModelText.g:551:3: rule__Element__TypeAssignment_2
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
    // InternalModelText.g:559:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:563:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalModelText.g:564:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalModelText.g:571:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:575:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalModelText.g:576:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalModelText.g:576:1: ( ( rule__Element__Group_3__0 )? )
            // InternalModelText.g:577:2: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalModelText.g:578:2: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelText.g:578:3: rule__Element__Group_3__0
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
    // InternalModelText.g:586:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:590:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalModelText.g:591:2: rule__Element__Group__4__Impl rule__Element__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalModelText.g:598:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:602:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // InternalModelText.g:603:1: ( ( rule__Element__Group_4__0 )? )
            {
            // InternalModelText.g:603:1: ( ( rule__Element__Group_4__0 )? )
            // InternalModelText.g:604:2: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalModelText.g:605:2: ( rule__Element__Group_4__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalModelText.g:605:3: rule__Element__Group_4__0
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
    // InternalModelText.g:613:1: rule__Element__Group__5 : rule__Element__Group__5__Impl rule__Element__Group__6 ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:617:1: ( rule__Element__Group__5__Impl rule__Element__Group__6 )
            // InternalModelText.g:618:2: rule__Element__Group__5__Impl rule__Element__Group__6
            {
            pushFollow(FOLLOW_8);
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
    // InternalModelText.g:625:1: rule__Element__Group__5__Impl : ( ':' ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:629:1: ( ( ':' ) )
            // InternalModelText.g:630:1: ( ':' )
            {
            // InternalModelText.g:630:1: ( ':' )
            // InternalModelText.g:631:2: ':'
            {
             before(grammarAccess.getElementAccess().getColonKeyword_5()); 
            match(input,14,FOLLOW_2); 
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
    // InternalModelText.g:640:1: rule__Element__Group__6 : rule__Element__Group__6__Impl ;
    public final void rule__Element__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:644:1: ( rule__Element__Group__6__Impl )
            // InternalModelText.g:645:2: rule__Element__Group__6__Impl
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
    // InternalModelText.g:651:1: rule__Element__Group__6__Impl : ( ( rule__Element__Group_6__0 )? ) ;
    public final void rule__Element__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:655:1: ( ( ( rule__Element__Group_6__0 )? ) )
            // InternalModelText.g:656:1: ( ( rule__Element__Group_6__0 )? )
            {
            // InternalModelText.g:656:1: ( ( rule__Element__Group_6__0 )? )
            // InternalModelText.g:657:2: ( rule__Element__Group_6__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_6()); 
            // InternalModelText.g:658:2: ( rule__Element__Group_6__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelText.g:658:3: rule__Element__Group_6__0
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
    // InternalModelText.g:667:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:671:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalModelText.g:672:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalModelText.g:679:1: rule__Element__Group_3__0__Impl : ( '.' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:683:1: ( ( '.' ) )
            // InternalModelText.g:684:1: ( '.' )
            {
            // InternalModelText.g:684:1: ( '.' )
            // InternalModelText.g:685:2: '.'
            {
             before(grammarAccess.getElementAccess().getFullStopKeyword_3_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalModelText.g:694:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:698:1: ( rule__Element__Group_3__1__Impl )
            // InternalModelText.g:699:2: rule__Element__Group_3__1__Impl
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
    // InternalModelText.g:705:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__RefAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:709:1: ( ( ( rule__Element__RefAssignment_3_1 ) ) )
            // InternalModelText.g:710:1: ( ( rule__Element__RefAssignment_3_1 ) )
            {
            // InternalModelText.g:710:1: ( ( rule__Element__RefAssignment_3_1 ) )
            // InternalModelText.g:711:2: ( rule__Element__RefAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getRefAssignment_3_1()); 
            // InternalModelText.g:712:2: ( rule__Element__RefAssignment_3_1 )
            // InternalModelText.g:712:3: rule__Element__RefAssignment_3_1
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
    // InternalModelText.g:721:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:725:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalModelText.g:726:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalModelText.g:733:1: rule__Element__Group_4__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:737:1: ( ( '(' ) )
            // InternalModelText.g:738:1: ( '(' )
            {
            // InternalModelText.g:738:1: ( '(' )
            // InternalModelText.g:739:2: '('
            {
             before(grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0()); 
            match(input,16,FOLLOW_2); 
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
    // InternalModelText.g:748:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl rule__Element__Group_4__2 ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:752:1: ( rule__Element__Group_4__1__Impl rule__Element__Group_4__2 )
            // InternalModelText.g:753:2: rule__Element__Group_4__1__Impl rule__Element__Group_4__2
            {
            pushFollow(FOLLOW_11);
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
    // InternalModelText.g:760:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__FeatureAssignment_4_1 ) ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:764:1: ( ( ( rule__Element__FeatureAssignment_4_1 ) ) )
            // InternalModelText.g:765:1: ( ( rule__Element__FeatureAssignment_4_1 ) )
            {
            // InternalModelText.g:765:1: ( ( rule__Element__FeatureAssignment_4_1 ) )
            // InternalModelText.g:766:2: ( rule__Element__FeatureAssignment_4_1 )
            {
             before(grammarAccess.getElementAccess().getFeatureAssignment_4_1()); 
            // InternalModelText.g:767:2: ( rule__Element__FeatureAssignment_4_1 )
            // InternalModelText.g:767:3: rule__Element__FeatureAssignment_4_1
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
    // InternalModelText.g:775:1: rule__Element__Group_4__2 : rule__Element__Group_4__2__Impl rule__Element__Group_4__3 ;
    public final void rule__Element__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:779:1: ( rule__Element__Group_4__2__Impl rule__Element__Group_4__3 )
            // InternalModelText.g:780:2: rule__Element__Group_4__2__Impl rule__Element__Group_4__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalModelText.g:787:1: rule__Element__Group_4__2__Impl : ( ( rule__Element__Group_4_2__0 )* ) ;
    public final void rule__Element__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:791:1: ( ( ( rule__Element__Group_4_2__0 )* ) )
            // InternalModelText.g:792:1: ( ( rule__Element__Group_4_2__0 )* )
            {
            // InternalModelText.g:792:1: ( ( rule__Element__Group_4_2__0 )* )
            // InternalModelText.g:793:2: ( rule__Element__Group_4_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_4_2()); 
            // InternalModelText.g:794:2: ( rule__Element__Group_4_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==18) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalModelText.g:794:3: rule__Element__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Element__Group_4_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // InternalModelText.g:802:1: rule__Element__Group_4__3 : rule__Element__Group_4__3__Impl ;
    public final void rule__Element__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:806:1: ( rule__Element__Group_4__3__Impl )
            // InternalModelText.g:807:2: rule__Element__Group_4__3__Impl
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
    // InternalModelText.g:813:1: rule__Element__Group_4__3__Impl : ( ')' ) ;
    public final void rule__Element__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:817:1: ( ( ')' ) )
            // InternalModelText.g:818:1: ( ')' )
            {
            // InternalModelText.g:818:1: ( ')' )
            // InternalModelText.g:819:2: ')'
            {
             before(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_3()); 
            match(input,17,FOLLOW_2); 
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
    // InternalModelText.g:829:1: rule__Element__Group_4_2__0 : rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1 ;
    public final void rule__Element__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:833:1: ( rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1 )
            // InternalModelText.g:834:2: rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalModelText.g:841:1: rule__Element__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:845:1: ( ( ',' ) )
            // InternalModelText.g:846:1: ( ',' )
            {
            // InternalModelText.g:846:1: ( ',' )
            // InternalModelText.g:847:2: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_4_2_0()); 
            match(input,18,FOLLOW_2); 
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
    // InternalModelText.g:856:1: rule__Element__Group_4_2__1 : rule__Element__Group_4_2__1__Impl ;
    public final void rule__Element__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:860:1: ( rule__Element__Group_4_2__1__Impl )
            // InternalModelText.g:861:2: rule__Element__Group_4_2__1__Impl
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
    // InternalModelText.g:867:1: rule__Element__Group_4_2__1__Impl : ( ( rule__Element__FeatureAssignment_4_2_1 ) ) ;
    public final void rule__Element__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:871:1: ( ( ( rule__Element__FeatureAssignment_4_2_1 ) ) )
            // InternalModelText.g:872:1: ( ( rule__Element__FeatureAssignment_4_2_1 ) )
            {
            // InternalModelText.g:872:1: ( ( rule__Element__FeatureAssignment_4_2_1 ) )
            // InternalModelText.g:873:2: ( rule__Element__FeatureAssignment_4_2_1 )
            {
             before(grammarAccess.getElementAccess().getFeatureAssignment_4_2_1()); 
            // InternalModelText.g:874:2: ( rule__Element__FeatureAssignment_4_2_1 )
            // InternalModelText.g:874:3: rule__Element__FeatureAssignment_4_2_1
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
    // InternalModelText.g:883:1: rule__Element__Group_6__0 : rule__Element__Group_6__0__Impl rule__Element__Group_6__1 ;
    public final void rule__Element__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:887:1: ( rule__Element__Group_6__0__Impl rule__Element__Group_6__1 )
            // InternalModelText.g:888:2: rule__Element__Group_6__0__Impl rule__Element__Group_6__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalModelText.g:895:1: rule__Element__Group_6__0__Impl : ( ( rule__Element__WordsAssignment_6_0 ) ) ;
    public final void rule__Element__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:899:1: ( ( ( rule__Element__WordsAssignment_6_0 ) ) )
            // InternalModelText.g:900:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            {
            // InternalModelText.g:900:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            // InternalModelText.g:901:2: ( rule__Element__WordsAssignment_6_0 )
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_0()); 
            // InternalModelText.g:902:2: ( rule__Element__WordsAssignment_6_0 )
            // InternalModelText.g:902:3: rule__Element__WordsAssignment_6_0
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
    // InternalModelText.g:910:1: rule__Element__Group_6__1 : rule__Element__Group_6__1__Impl ;
    public final void rule__Element__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:914:1: ( rule__Element__Group_6__1__Impl )
            // InternalModelText.g:915:2: rule__Element__Group_6__1__Impl
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
    // InternalModelText.g:921:1: rule__Element__Group_6__1__Impl : ( ( rule__Element__WordsAssignment_6_1 )* ) ;
    public final void rule__Element__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:925:1: ( ( ( rule__Element__WordsAssignment_6_1 )* ) )
            // InternalModelText.g:926:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            {
            // InternalModelText.g:926:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            // InternalModelText.g:927:2: ( rule__Element__WordsAssignment_6_1 )*
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_1()); 
            // InternalModelText.g:928:2: ( rule__Element__WordsAssignment_6_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)||LA9_0==21) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalModelText.g:928:3: rule__Element__WordsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__Element__WordsAssignment_6_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalModelText.g:937:1: rule__ValuedFeature__Group__0 : rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 ;
    public final void rule__ValuedFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:941:1: ( rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 )
            // InternalModelText.g:942:2: rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalModelText.g:949:1: rule__ValuedFeature__Group__0__Impl : ( () ) ;
    public final void rule__ValuedFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:953:1: ( ( () ) )
            // InternalModelText.g:954:1: ( () )
            {
            // InternalModelText.g:954:1: ( () )
            // InternalModelText.g:955:2: ()
            {
             before(grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0()); 
            // InternalModelText.g:956:2: ()
            // InternalModelText.g:956:3: 
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
    // InternalModelText.g:964:1: rule__ValuedFeature__Group__1 : rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 ;
    public final void rule__ValuedFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:968:1: ( rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 )
            // InternalModelText.g:969:2: rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalModelText.g:976:1: rule__ValuedFeature__Group__1__Impl : ( ( rule__ValuedFeature__NegationAssignment_1 )? ) ;
    public final void rule__ValuedFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:980:1: ( ( ( rule__ValuedFeature__NegationAssignment_1 )? ) )
            // InternalModelText.g:981:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            {
            // InternalModelText.g:981:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            // InternalModelText.g:982:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationAssignment_1()); 
            // InternalModelText.g:983:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelText.g:983:3: rule__ValuedFeature__NegationAssignment_1
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
    // InternalModelText.g:991:1: rule__ValuedFeature__Group__2 : rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 ;
    public final void rule__ValuedFeature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:995:1: ( rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 )
            // InternalModelText.g:996:2: rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3
            {
            pushFollow(FOLLOW_14);
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
    // InternalModelText.g:1003:1: rule__ValuedFeature__Group__2__Impl : ( ( rule__ValuedFeature__FeatAssignment_2 ) ) ;
    public final void rule__ValuedFeature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1007:1: ( ( ( rule__ValuedFeature__FeatAssignment_2 ) ) )
            // InternalModelText.g:1008:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            {
            // InternalModelText.g:1008:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            // InternalModelText.g:1009:2: ( rule__ValuedFeature__FeatAssignment_2 )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatAssignment_2()); 
            // InternalModelText.g:1010:2: ( rule__ValuedFeature__FeatAssignment_2 )
            // InternalModelText.g:1010:3: rule__ValuedFeature__FeatAssignment_2
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
    // InternalModelText.g:1018:1: rule__ValuedFeature__Group__3 : rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 ;
    public final void rule__ValuedFeature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1022:1: ( rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 )
            // InternalModelText.g:1023:2: rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalModelText.g:1030:1: rule__ValuedFeature__Group__3__Impl : ( ( rule__ValuedFeature__Group_3__0 )? ) ;
    public final void rule__ValuedFeature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1034:1: ( ( ( rule__ValuedFeature__Group_3__0 )? ) )
            // InternalModelText.g:1035:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            {
            // InternalModelText.g:1035:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            // InternalModelText.g:1036:2: ( rule__ValuedFeature__Group_3__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_3()); 
            // InternalModelText.g:1037:2: ( rule__ValuedFeature__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==19) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalModelText.g:1037:3: rule__ValuedFeature__Group_3__0
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
    // InternalModelText.g:1045:1: rule__ValuedFeature__Group__4 : rule__ValuedFeature__Group__4__Impl ;
    public final void rule__ValuedFeature__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1049:1: ( rule__ValuedFeature__Group__4__Impl )
            // InternalModelText.g:1050:2: rule__ValuedFeature__Group__4__Impl
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
    // InternalModelText.g:1056:1: rule__ValuedFeature__Group__4__Impl : ( ( rule__ValuedFeature__Group_4__0 )? ) ;
    public final void rule__ValuedFeature__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1060:1: ( ( ( rule__ValuedFeature__Group_4__0 )? ) )
            // InternalModelText.g:1061:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            {
            // InternalModelText.g:1061:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            // InternalModelText.g:1062:2: ( rule__ValuedFeature__Group_4__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_4()); 
            // InternalModelText.g:1063:2: ( rule__ValuedFeature__Group_4__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==20) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalModelText.g:1063:3: rule__ValuedFeature__Group_4__0
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
    // InternalModelText.g:1072:1: rule__ValuedFeature__Group_3__0 : rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 ;
    public final void rule__ValuedFeature__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1076:1: ( rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 )
            // InternalModelText.g:1077:2: rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalModelText.g:1084:1: rule__ValuedFeature__Group_3__0__Impl : ( '->' ) ;
    public final void rule__ValuedFeature__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1088:1: ( ( '->' ) )
            // InternalModelText.g:1089:1: ( '->' )
            {
            // InternalModelText.g:1089:1: ( '->' )
            // InternalModelText.g:1090:2: '->'
            {
             before(grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0()); 
            match(input,19,FOLLOW_2); 
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
    // InternalModelText.g:1099:1: rule__ValuedFeature__Group_3__1 : rule__ValuedFeature__Group_3__1__Impl ;
    public final void rule__ValuedFeature__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1103:1: ( rule__ValuedFeature__Group_3__1__Impl )
            // InternalModelText.g:1104:2: rule__ValuedFeature__Group_3__1__Impl
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
    // InternalModelText.g:1110:1: rule__ValuedFeature__Group_3__1__Impl : ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) ;
    public final void rule__ValuedFeature__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1114:1: ( ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) )
            // InternalModelText.g:1115:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            {
            // InternalModelText.g:1115:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            // InternalModelText.g:1116:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureAssignment_3_1()); 
            // InternalModelText.g:1117:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            // InternalModelText.g:1117:3: rule__ValuedFeature__RefFeatureAssignment_3_1
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
    // InternalModelText.g:1126:1: rule__ValuedFeature__Group_4__0 : rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 ;
    public final void rule__ValuedFeature__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1130:1: ( rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 )
            // InternalModelText.g:1131:2: rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalModelText.g:1138:1: rule__ValuedFeature__Group_4__0__Impl : ( '==' ) ;
    public final void rule__ValuedFeature__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1142:1: ( ( '==' ) )
            // InternalModelText.g:1143:1: ( '==' )
            {
            // InternalModelText.g:1143:1: ( '==' )
            // InternalModelText.g:1144:2: '=='
            {
             before(grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0()); 
            match(input,20,FOLLOW_2); 
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
    // InternalModelText.g:1153:1: rule__ValuedFeature__Group_4__1 : rule__ValuedFeature__Group_4__1__Impl ;
    public final void rule__ValuedFeature__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1157:1: ( rule__ValuedFeature__Group_4__1__Impl )
            // InternalModelText.g:1158:2: rule__ValuedFeature__Group_4__1__Impl
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
    // InternalModelText.g:1164:1: rule__ValuedFeature__Group_4__1__Impl : ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) ;
    public final void rule__ValuedFeature__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1168:1: ( ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) )
            // InternalModelText.g:1169:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            {
            // InternalModelText.g:1169:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            // InternalModelText.g:1170:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueAssignment_4_1()); 
            // InternalModelText.g:1171:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            // InternalModelText.g:1171:3: rule__ValuedFeature__ValueAssignment_4_1
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
    // InternalModelText.g:1180:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1184:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // InternalModelText.g:1185:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
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
    // InternalModelText.g:1192:1: rule__Constant__Group__0__Impl : ( () ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1196:1: ( ( () ) )
            // InternalModelText.g:1197:1: ( () )
            {
            // InternalModelText.g:1197:1: ( () )
            // InternalModelText.g:1198:2: ()
            {
             before(grammarAccess.getConstantAccess().getConstantAction_0()); 
            // InternalModelText.g:1199:2: ()
            // InternalModelText.g:1199:3: 
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
    // InternalModelText.g:1207:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1211:1: ( rule__Constant__Group__1__Impl )
            // InternalModelText.g:1212:2: rule__Constant__Group__1__Impl
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
    // InternalModelText.g:1218:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__ValueAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1222:1: ( ( ( rule__Constant__ValueAssignment_1 ) ) )
            // InternalModelText.g:1223:1: ( ( rule__Constant__ValueAssignment_1 ) )
            {
            // InternalModelText.g:1223:1: ( ( rule__Constant__ValueAssignment_1 ) )
            // InternalModelText.g:1224:2: ( rule__Constant__ValueAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1()); 
            // InternalModelText.g:1225:2: ( rule__Constant__ValueAssignment_1 )
            // InternalModelText.g:1225:3: rule__Constant__ValueAssignment_1
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
    // InternalModelText.g:1234:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1238:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalModelText.g:1239:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_16);
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
    // InternalModelText.g:1246:1: rule__Variable__Group__0__Impl : ( () ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1250:1: ( ( () ) )
            // InternalModelText.g:1251:1: ( () )
            {
            // InternalModelText.g:1251:1: ( () )
            // InternalModelText.g:1252:2: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0()); 
            // InternalModelText.g:1253:2: ()
            // InternalModelText.g:1253:3: 
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
    // InternalModelText.g:1261:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1265:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalModelText.g:1266:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalModelText.g:1273:1: rule__Variable__Group__1__Impl : ( '%' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1277:1: ( ( '%' ) )
            // InternalModelText.g:1278:1: ( '%' )
            {
            // InternalModelText.g:1278:1: ( '%' )
            // InternalModelText.g:1279:2: '%'
            {
             before(grammarAccess.getVariableAccess().getPercentSignKeyword_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalModelText.g:1288:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1292:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalModelText.g:1293:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FOLLOW_9);
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
    // InternalModelText.g:1300:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Group_2__0 )? ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1304:1: ( ( ( rule__Variable__Group_2__0 )? ) )
            // InternalModelText.g:1305:1: ( ( rule__Variable__Group_2__0 )? )
            {
            // InternalModelText.g:1305:1: ( ( rule__Variable__Group_2__0 )? )
            // InternalModelText.g:1306:2: ( rule__Variable__Group_2__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2()); 
            // InternalModelText.g:1307:2: ( rule__Variable__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1==15) ) {
                    alt13=1;
                }
            }
            switch (alt13) {
                case 1 :
                    // InternalModelText.g:1307:3: rule__Variable__Group_2__0
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
    // InternalModelText.g:1315:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1319:1: ( rule__Variable__Group__3__Impl )
            // InternalModelText.g:1320:2: rule__Variable__Group__3__Impl
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
    // InternalModelText.g:1326:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__IdAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1330:1: ( ( ( rule__Variable__IdAssignment_3 ) ) )
            // InternalModelText.g:1331:1: ( ( rule__Variable__IdAssignment_3 ) )
            {
            // InternalModelText.g:1331:1: ( ( rule__Variable__IdAssignment_3 ) )
            // InternalModelText.g:1332:2: ( rule__Variable__IdAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getIdAssignment_3()); 
            // InternalModelText.g:1333:2: ( rule__Variable__IdAssignment_3 )
            // InternalModelText.g:1333:3: rule__Variable__IdAssignment_3
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
    // InternalModelText.g:1342:1: rule__Variable__Group_2__0 : rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 ;
    public final void rule__Variable__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1346:1: ( rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 )
            // InternalModelText.g:1347:2: rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelText.g:1354:1: rule__Variable__Group_2__0__Impl : ( ( rule__Variable__RefAssignment_2_0 ) ) ;
    public final void rule__Variable__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1358:1: ( ( ( rule__Variable__RefAssignment_2_0 ) ) )
            // InternalModelText.g:1359:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            {
            // InternalModelText.g:1359:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            // InternalModelText.g:1360:2: ( rule__Variable__RefAssignment_2_0 )
            {
             before(grammarAccess.getVariableAccess().getRefAssignment_2_0()); 
            // InternalModelText.g:1361:2: ( rule__Variable__RefAssignment_2_0 )
            // InternalModelText.g:1361:3: rule__Variable__RefAssignment_2_0
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
    // InternalModelText.g:1369:1: rule__Variable__Group_2__1 : rule__Variable__Group_2__1__Impl ;
    public final void rule__Variable__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1373:1: ( rule__Variable__Group_2__1__Impl )
            // InternalModelText.g:1374:2: rule__Variable__Group_2__1__Impl
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
    // InternalModelText.g:1380:1: rule__Variable__Group_2__1__Impl : ( '.' ) ;
    public final void rule__Variable__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1384:1: ( ( '.' ) )
            // InternalModelText.g:1385:1: ( '.' )
            {
            // InternalModelText.g:1385:1: ( '.' )
            // InternalModelText.g:1386:2: '.'
            {
             before(grammarAccess.getVariableAccess().getFullStopKeyword_2_1()); 
            match(input,15,FOLLOW_2); 
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
    // InternalModelText.g:1396:1: rule__Macro__Group__0 : rule__Macro__Group__0__Impl rule__Macro__Group__1 ;
    public final void rule__Macro__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1400:1: ( rule__Macro__Group__0__Impl rule__Macro__Group__1 )
            // InternalModelText.g:1401:2: rule__Macro__Group__0__Impl rule__Macro__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalModelText.g:1408:1: rule__Macro__Group__0__Impl : ( () ) ;
    public final void rule__Macro__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1412:1: ( ( () ) )
            // InternalModelText.g:1413:1: ( () )
            {
            // InternalModelText.g:1413:1: ( () )
            // InternalModelText.g:1414:2: ()
            {
             before(grammarAccess.getMacroAccess().getMacroAction_0()); 
            // InternalModelText.g:1415:2: ()
            // InternalModelText.g:1415:3: 
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
    // InternalModelText.g:1423:1: rule__Macro__Group__1 : rule__Macro__Group__1__Impl rule__Macro__Group__2 ;
    public final void rule__Macro__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1427:1: ( rule__Macro__Group__1__Impl rule__Macro__Group__2 )
            // InternalModelText.g:1428:2: rule__Macro__Group__1__Impl rule__Macro__Group__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalModelText.g:1435:1: rule__Macro__Group__1__Impl : ( '%' ) ;
    public final void rule__Macro__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1439:1: ( ( '%' ) )
            // InternalModelText.g:1440:1: ( '%' )
            {
            // InternalModelText.g:1440:1: ( '%' )
            // InternalModelText.g:1441:2: '%'
            {
             before(grammarAccess.getMacroAccess().getPercentSignKeyword_1()); 
            match(input,21,FOLLOW_2); 
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
    // InternalModelText.g:1450:1: rule__Macro__Group__2 : rule__Macro__Group__2__Impl ;
    public final void rule__Macro__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1454:1: ( rule__Macro__Group__2__Impl )
            // InternalModelText.g:1455:2: rule__Macro__Group__2__Impl
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
    // InternalModelText.g:1461:1: rule__Macro__Group__2__Impl : ( ( rule__Macro__ItemAssignment_2 ) ) ;
    public final void rule__Macro__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1465:1: ( ( ( rule__Macro__ItemAssignment_2 ) ) )
            // InternalModelText.g:1466:1: ( ( rule__Macro__ItemAssignment_2 ) )
            {
            // InternalModelText.g:1466:1: ( ( rule__Macro__ItemAssignment_2 ) )
            // InternalModelText.g:1467:2: ( rule__Macro__ItemAssignment_2 )
            {
             before(grammarAccess.getMacroAccess().getItemAssignment_2()); 
            // InternalModelText.g:1468:2: ( rule__Macro__ItemAssignment_2 )
            // InternalModelText.g:1468:3: rule__Macro__ItemAssignment_2
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
    // InternalModelText.g:1477:1: rule__IdentifyElements__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__IdentifyElements__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1481:1: ( ( ruleEString ) )
            // InternalModelText.g:1482:2: ( ruleEString )
            {
            // InternalModelText.g:1482:2: ( ruleEString )
            // InternalModelText.g:1483:3: ruleEString
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


    // $ANTLR start "rule__IdentifyElements__ElementsAssignment_3_0"
    // InternalModelText.g:1492:1: rule__IdentifyElements__ElementsAssignment_3_0 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1496:1: ( ( ruleElement ) )
            // InternalModelText.g:1497:2: ( ruleElement )
            {
            // InternalModelText.g:1497:2: ( ruleElement )
            // InternalModelText.g:1498:3: ruleElement
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_0_0()); 

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
    // $ANTLR end "rule__IdentifyElements__ElementsAssignment_3_0"


    // $ANTLR start "rule__IdentifyElements__ElementsAssignment_3_1"
    // InternalModelText.g:1507:1: rule__IdentifyElements__ElementsAssignment_3_1 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1511:1: ( ( ruleElement ) )
            // InternalModelText.g:1512:2: ( ruleElement )
            {
            // InternalModelText.g:1512:2: ( ruleElement )
            // InternalModelText.g:1513:3: ruleElement
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__IdentifyElements__ElementsAssignment_3_1"


    // $ANTLR start "rule__Element__TypeAssignment_2"
    // InternalModelText.g:1522:1: rule__Element__TypeAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__Element__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1526:1: ( ( ( ruleEString ) ) )
            // InternalModelText.g:1527:2: ( ( ruleEString ) )
            {
            // InternalModelText.g:1527:2: ( ( ruleEString ) )
            // InternalModelText.g:1528:3: ( ruleEString )
            {
             before(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); 
            // InternalModelText.g:1529:3: ( ruleEString )
            // InternalModelText.g:1530:4: ruleEString
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
    // InternalModelText.g:1541:1: rule__Element__RefAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__RefAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1545:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1546:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1546:2: ( ( RULE_ID ) )
            // InternalModelText.g:1547:3: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); 
            // InternalModelText.g:1548:3: ( RULE_ID )
            // InternalModelText.g:1549:4: RULE_ID
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
    // InternalModelText.g:1560:1: rule__Element__FeatureAssignment_4_1 : ( ruleValuedFeature ) ;
    public final void rule__Element__FeatureAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1564:1: ( ( ruleValuedFeature ) )
            // InternalModelText.g:1565:2: ( ruleValuedFeature )
            {
            // InternalModelText.g:1565:2: ( ruleValuedFeature )
            // InternalModelText.g:1566:3: ruleValuedFeature
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
    // InternalModelText.g:1575:1: rule__Element__FeatureAssignment_4_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Element__FeatureAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1579:1: ( ( ruleValuedFeature ) )
            // InternalModelText.g:1580:2: ( ruleValuedFeature )
            {
            // InternalModelText.g:1580:2: ( ruleValuedFeature )
            // InternalModelText.g:1581:3: ruleValuedFeature
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
    // InternalModelText.g:1590:1: rule__Element__WordsAssignment_6_0 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1594:1: ( ( ruleWord ) )
            // InternalModelText.g:1595:2: ( ruleWord )
            {
            // InternalModelText.g:1595:2: ( ruleWord )
            // InternalModelText.g:1596:3: ruleWord
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
    // InternalModelText.g:1605:1: rule__Element__WordsAssignment_6_1 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1609:1: ( ( ruleWord ) )
            // InternalModelText.g:1610:2: ( ruleWord )
            {
            // InternalModelText.g:1610:2: ( ruleWord )
            // InternalModelText.g:1611:3: ruleWord
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
    // InternalModelText.g:1620:1: rule__ValuedFeature__NegationAssignment_1 : ( ( 'not' ) ) ;
    public final void rule__ValuedFeature__NegationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1624:1: ( ( ( 'not' ) ) )
            // InternalModelText.g:1625:2: ( ( 'not' ) )
            {
            // InternalModelText.g:1625:2: ( ( 'not' ) )
            // InternalModelText.g:1626:3: ( 'not' )
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 
            // InternalModelText.g:1627:3: ( 'not' )
            // InternalModelText.g:1628:4: 'not'
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 
            match(input,22,FOLLOW_2); 
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
    // InternalModelText.g:1639:1: rule__ValuedFeature__FeatAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__FeatAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1643:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1644:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1644:2: ( ( RULE_ID ) )
            // InternalModelText.g:1645:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0()); 
            // InternalModelText.g:1646:3: ( RULE_ID )
            // InternalModelText.g:1647:4: RULE_ID
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
    // InternalModelText.g:1658:1: rule__ValuedFeature__RefFeatureAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__RefFeatureAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1662:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1663:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1663:2: ( ( RULE_ID ) )
            // InternalModelText.g:1664:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0()); 
            // InternalModelText.g:1665:3: ( RULE_ID )
            // InternalModelText.g:1666:4: RULE_ID
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
    // InternalModelText.g:1677:1: rule__ValuedFeature__ValueAssignment_4_1 : ( ( 'null' ) ) ;
    public final void rule__ValuedFeature__ValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1681:1: ( ( ( 'null' ) ) )
            // InternalModelText.g:1682:2: ( ( 'null' ) )
            {
            // InternalModelText.g:1682:2: ( ( 'null' ) )
            // InternalModelText.g:1683:3: ( 'null' )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 
            // InternalModelText.g:1684:3: ( 'null' )
            // InternalModelText.g:1685:4: 'null'
            {
             before(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 
            match(input,23,FOLLOW_2); 
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
    // InternalModelText.g:1696:1: rule__Constant__ValueAssignment_1 : ( ruleEString ) ;
    public final void rule__Constant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1700:1: ( ( ruleEString ) )
            // InternalModelText.g:1701:2: ( ruleEString )
            {
            // InternalModelText.g:1701:2: ( ruleEString )
            // InternalModelText.g:1702:3: ruleEString
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
    // InternalModelText.g:1711:1: rule__Variable__RefAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__RefAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1715:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1716:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1716:2: ( ( RULE_ID ) )
            // InternalModelText.g:1717:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); 
            // InternalModelText.g:1718:3: ( RULE_ID )
            // InternalModelText.g:1719:4: RULE_ID
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
    // InternalModelText.g:1730:1: rule__Variable__IdAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__IdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1734:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1735:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1735:2: ( ( RULE_ID ) )
            // InternalModelText.g:1736:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); 
            // InternalModelText.g:1737:3: ( RULE_ID )
            // InternalModelText.g:1738:4: RULE_ID
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
    // InternalModelText.g:1749:1: rule__Macro__ItemAssignment_2 : ( ruleMacroItem ) ;
    public final void rule__Macro__ItemAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1753:1: ( ( ruleMacroItem ) )
            // InternalModelText.g:1754:2: ( ruleMacroItem )
            {
            // InternalModelText.g:1754:2: ( ruleMacroItem )
            // InternalModelText.g:1755:3: ruleMacroItem
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
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000200030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000400020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200032L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000000800L});

}