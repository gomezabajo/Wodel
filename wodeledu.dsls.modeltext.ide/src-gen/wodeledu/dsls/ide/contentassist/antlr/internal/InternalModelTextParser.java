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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'not'", "'metamodel'", "'>'", "':'", "'.'", "'('", "')'", "'%'", "'yes'"
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
    public static final int RULE_ML_COMMENT=7;

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


    // $ANTLR start "entryRuleAttribute"
    // InternalModelText.g:103:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // InternalModelText.g:104:1: ( ruleAttribute EOF )
            // InternalModelText.g:105:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalModelText.g:112:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:116:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // InternalModelText.g:117:2: ( ( rule__Attribute__Group__0 ) )
            {
            // InternalModelText.g:117:2: ( ( rule__Attribute__Group__0 ) )
            // InternalModelText.g:118:3: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // InternalModelText.g:119:3: ( rule__Attribute__Group__0 )
            // InternalModelText.g:119:4: rule__Attribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getGroup()); 

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
    // $ANTLR end "ruleAttribute"


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


    // $ANTLR start "entryRuleEString"
    // InternalModelText.g:203:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalModelText.g:204:1: ( ruleEString EOF )
            // InternalModelText.g:205:1: ruleEString EOF
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
    // InternalModelText.g:212:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:216:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalModelText.g:217:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalModelText.g:217:2: ( ( rule__EString__Alternatives ) )
            // InternalModelText.g:218:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalModelText.g:219:3: ( rule__EString__Alternatives )
            // InternalModelText.g:219:4: rule__EString__Alternatives
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


    // $ANTLR start "rule__Attribute__Alternatives_1"
    // InternalModelText.g:227:1: rule__Attribute__Alternatives_1 : ( ( ( rule__Attribute__NegationAssignment_1_0 ) ) | ( 'not' ) );
    public final void rule__Attribute__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:231:1: ( ( ( rule__Attribute__NegationAssignment_1_0 ) ) | ( 'not' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            else if ( (LA1_0==11) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalModelText.g:232:2: ( ( rule__Attribute__NegationAssignment_1_0 ) )
                    {
                    // InternalModelText.g:232:2: ( ( rule__Attribute__NegationAssignment_1_0 ) )
                    // InternalModelText.g:233:3: ( rule__Attribute__NegationAssignment_1_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getNegationAssignment_1_0()); 
                    // InternalModelText.g:234:3: ( rule__Attribute__NegationAssignment_1_0 )
                    // InternalModelText.g:234:4: rule__Attribute__NegationAssignment_1_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__NegationAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getNegationAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelText.g:238:2: ( 'not' )
                    {
                    // InternalModelText.g:238:2: ( 'not' )
                    // InternalModelText.g:239:3: 'not'
                    {
                     before(grammarAccess.getAttributeAccess().getNotKeyword_1_1()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getAttributeAccess().getNotKeyword_1_1()); 

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
    // $ANTLR end "rule__Attribute__Alternatives_1"


    // $ANTLR start "rule__Word__Alternatives"
    // InternalModelText.g:248:1: rule__Word__Alternatives : ( ( ruleConstant ) | ( ruleVariable ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:252:1: ( ( ruleConstant ) | ( ruleVariable ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_STRING && LA2_0<=RULE_ID)) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalModelText.g:253:2: ( ruleConstant )
                    {
                    // InternalModelText.g:253:2: ( ruleConstant )
                    // InternalModelText.g:254:3: ruleConstant
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
                    // InternalModelText.g:259:2: ( ruleVariable )
                    {
                    // InternalModelText.g:259:2: ( ruleVariable )
                    // InternalModelText.g:260:3: ruleVariable
                    {
                     before(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 

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
    // InternalModelText.g:269:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:273:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalModelText.g:274:2: ( RULE_STRING )
                    {
                    // InternalModelText.g:274:2: ( RULE_STRING )
                    // InternalModelText.g:275:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelText.g:280:2: ( RULE_ID )
                    {
                    // InternalModelText.g:280:2: ( RULE_ID )
                    // InternalModelText.g:281:3: RULE_ID
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
    // InternalModelText.g:290:1: rule__IdentifyElements__Group__0 : rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 ;
    public final void rule__IdentifyElements__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:294:1: ( rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 )
            // InternalModelText.g:295:2: rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1
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
    // InternalModelText.g:302:1: rule__IdentifyElements__Group__0__Impl : ( () ) ;
    public final void rule__IdentifyElements__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:306:1: ( ( () ) )
            // InternalModelText.g:307:1: ( () )
            {
            // InternalModelText.g:307:1: ( () )
            // InternalModelText.g:308:2: ()
            {
             before(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); 
            // InternalModelText.g:309:2: ()
            // InternalModelText.g:309:3: 
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
    // InternalModelText.g:317:1: rule__IdentifyElements__Group__1 : rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 ;
    public final void rule__IdentifyElements__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:321:1: ( rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 )
            // InternalModelText.g:322:2: rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2
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
    // InternalModelText.g:329:1: rule__IdentifyElements__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__IdentifyElements__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:333:1: ( ( 'metamodel' ) )
            // InternalModelText.g:334:1: ( 'metamodel' )
            {
            // InternalModelText.g:334:1: ( 'metamodel' )
            // InternalModelText.g:335:2: 'metamodel'
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
    // InternalModelText.g:344:1: rule__IdentifyElements__Group__2 : rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 ;
    public final void rule__IdentifyElements__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:348:1: ( rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 )
            // InternalModelText.g:349:2: rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3
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
    // InternalModelText.g:356:1: rule__IdentifyElements__Group__2__Impl : ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) ;
    public final void rule__IdentifyElements__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:360:1: ( ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) )
            // InternalModelText.g:361:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            {
            // InternalModelText.g:361:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            // InternalModelText.g:362:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); 
            // InternalModelText.g:363:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            // InternalModelText.g:363:3: rule__IdentifyElements__MetamodelAssignment_2
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
    // InternalModelText.g:371:1: rule__IdentifyElements__Group__3 : rule__IdentifyElements__Group__3__Impl ;
    public final void rule__IdentifyElements__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:375:1: ( rule__IdentifyElements__Group__3__Impl )
            // InternalModelText.g:376:2: rule__IdentifyElements__Group__3__Impl
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
    // InternalModelText.g:382:1: rule__IdentifyElements__Group__3__Impl : ( ( rule__IdentifyElements__Group_3__0 )? ) ;
    public final void rule__IdentifyElements__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:386:1: ( ( ( rule__IdentifyElements__Group_3__0 )? ) )
            // InternalModelText.g:387:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            {
            // InternalModelText.g:387:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            // InternalModelText.g:388:2: ( rule__IdentifyElements__Group_3__0 )?
            {
             before(grammarAccess.getIdentifyElementsAccess().getGroup_3()); 
            // InternalModelText.g:389:2: ( rule__IdentifyElements__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalModelText.g:389:3: rule__IdentifyElements__Group_3__0
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
    // InternalModelText.g:398:1: rule__IdentifyElements__Group_3__0 : rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 ;
    public final void rule__IdentifyElements__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:402:1: ( rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 )
            // InternalModelText.g:403:2: rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1
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
    // InternalModelText.g:410:1: rule__IdentifyElements__Group_3__0__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) ;
    public final void rule__IdentifyElements__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:414:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) )
            // InternalModelText.g:415:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            {
            // InternalModelText.g:415:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            // InternalModelText.g:416:2: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_0()); 
            // InternalModelText.g:417:2: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            // InternalModelText.g:417:3: rule__IdentifyElements__ElementsAssignment_3_0
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
    // InternalModelText.g:425:1: rule__IdentifyElements__Group_3__1 : rule__IdentifyElements__Group_3__1__Impl ;
    public final void rule__IdentifyElements__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:429:1: ( rule__IdentifyElements__Group_3__1__Impl )
            // InternalModelText.g:430:2: rule__IdentifyElements__Group_3__1__Impl
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
    // InternalModelText.g:436:1: rule__IdentifyElements__Group_3__1__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) ;
    public final void rule__IdentifyElements__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:440:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) )
            // InternalModelText.g:441:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            {
            // InternalModelText.g:441:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            // InternalModelText.g:442:2: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_1()); 
            // InternalModelText.g:443:2: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalModelText.g:443:3: rule__IdentifyElements__ElementsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__IdentifyElements__ElementsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
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
    // InternalModelText.g:452:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:456:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalModelText.g:457:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalModelText.g:464:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:468:1: ( ( () ) )
            // InternalModelText.g:469:1: ( () )
            {
            // InternalModelText.g:469:1: ( () )
            // InternalModelText.g:470:2: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalModelText.g:471:2: ()
            // InternalModelText.g:471:3: 
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
    // InternalModelText.g:479:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:483:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalModelText.g:484:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalModelText.g:491:1: rule__Element__Group__1__Impl : ( '>' ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:495:1: ( ( '>' ) )
            // InternalModelText.g:496:1: ( '>' )
            {
            // InternalModelText.g:496:1: ( '>' )
            // InternalModelText.g:497:2: '>'
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
    // InternalModelText.g:506:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:510:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalModelText.g:511:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalModelText.g:518:1: rule__Element__Group__2__Impl : ( ( rule__Element__TypeAssignment_2 ) ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:522:1: ( ( ( rule__Element__TypeAssignment_2 ) ) )
            // InternalModelText.g:523:1: ( ( rule__Element__TypeAssignment_2 ) )
            {
            // InternalModelText.g:523:1: ( ( rule__Element__TypeAssignment_2 ) )
            // InternalModelText.g:524:2: ( rule__Element__TypeAssignment_2 )
            {
             before(grammarAccess.getElementAccess().getTypeAssignment_2()); 
            // InternalModelText.g:525:2: ( rule__Element__TypeAssignment_2 )
            // InternalModelText.g:525:3: rule__Element__TypeAssignment_2
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
    // InternalModelText.g:533:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:537:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalModelText.g:538:2: rule__Element__Group__3__Impl rule__Element__Group__4
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
    // InternalModelText.g:545:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:549:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalModelText.g:550:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalModelText.g:550:1: ( ( rule__Element__Group_3__0 )? )
            // InternalModelText.g:551:2: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalModelText.g:552:2: ( rule__Element__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalModelText.g:552:3: rule__Element__Group_3__0
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
    // InternalModelText.g:560:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:564:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalModelText.g:565:2: rule__Element__Group__4__Impl rule__Element__Group__5
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
    // InternalModelText.g:572:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:576:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // InternalModelText.g:577:1: ( ( rule__Element__Group_4__0 )? )
            {
            // InternalModelText.g:577:1: ( ( rule__Element__Group_4__0 )? )
            // InternalModelText.g:578:2: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalModelText.g:579:2: ( rule__Element__Group_4__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelText.g:579:3: rule__Element__Group_4__0
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
    // InternalModelText.g:587:1: rule__Element__Group__5 : rule__Element__Group__5__Impl rule__Element__Group__6 ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:591:1: ( rule__Element__Group__5__Impl rule__Element__Group__6 )
            // InternalModelText.g:592:2: rule__Element__Group__5__Impl rule__Element__Group__6
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
    // InternalModelText.g:599:1: rule__Element__Group__5__Impl : ( ':' ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:603:1: ( ( ':' ) )
            // InternalModelText.g:604:1: ( ':' )
            {
            // InternalModelText.g:604:1: ( ':' )
            // InternalModelText.g:605:2: ':'
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
    // InternalModelText.g:614:1: rule__Element__Group__6 : rule__Element__Group__6__Impl ;
    public final void rule__Element__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:618:1: ( rule__Element__Group__6__Impl )
            // InternalModelText.g:619:2: rule__Element__Group__6__Impl
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
    // InternalModelText.g:625:1: rule__Element__Group__6__Impl : ( ( rule__Element__Group_6__0 )? ) ;
    public final void rule__Element__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:629:1: ( ( ( rule__Element__Group_6__0 )? ) )
            // InternalModelText.g:630:1: ( ( rule__Element__Group_6__0 )? )
            {
            // InternalModelText.g:630:1: ( ( rule__Element__Group_6__0 )? )
            // InternalModelText.g:631:2: ( rule__Element__Group_6__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_6()); 
            // InternalModelText.g:632:2: ( rule__Element__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)||LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalModelText.g:632:3: rule__Element__Group_6__0
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
    // InternalModelText.g:641:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:645:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalModelText.g:646:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
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
    // InternalModelText.g:653:1: rule__Element__Group_3__0__Impl : ( '.' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:657:1: ( ( '.' ) )
            // InternalModelText.g:658:1: ( '.' )
            {
            // InternalModelText.g:658:1: ( '.' )
            // InternalModelText.g:659:2: '.'
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
    // InternalModelText.g:668:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:672:1: ( rule__Element__Group_3__1__Impl )
            // InternalModelText.g:673:2: rule__Element__Group_3__1__Impl
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
    // InternalModelText.g:679:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__RefAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:683:1: ( ( ( rule__Element__RefAssignment_3_1 ) ) )
            // InternalModelText.g:684:1: ( ( rule__Element__RefAssignment_3_1 ) )
            {
            // InternalModelText.g:684:1: ( ( rule__Element__RefAssignment_3_1 ) )
            // InternalModelText.g:685:2: ( rule__Element__RefAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getRefAssignment_3_1()); 
            // InternalModelText.g:686:2: ( rule__Element__RefAssignment_3_1 )
            // InternalModelText.g:686:3: rule__Element__RefAssignment_3_1
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
    // InternalModelText.g:695:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:699:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalModelText.g:700:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
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
    // InternalModelText.g:707:1: rule__Element__Group_4__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:711:1: ( ( '(' ) )
            // InternalModelText.g:712:1: ( '(' )
            {
            // InternalModelText.g:712:1: ( '(' )
            // InternalModelText.g:713:2: '('
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
    // InternalModelText.g:722:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl rule__Element__Group_4__2 ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:726:1: ( rule__Element__Group_4__1__Impl rule__Element__Group_4__2 )
            // InternalModelText.g:727:2: rule__Element__Group_4__1__Impl rule__Element__Group_4__2
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
    // InternalModelText.g:734:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__AttAssignment_4_1 ) ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:738:1: ( ( ( rule__Element__AttAssignment_4_1 ) ) )
            // InternalModelText.g:739:1: ( ( rule__Element__AttAssignment_4_1 ) )
            {
            // InternalModelText.g:739:1: ( ( rule__Element__AttAssignment_4_1 ) )
            // InternalModelText.g:740:2: ( rule__Element__AttAssignment_4_1 )
            {
             before(grammarAccess.getElementAccess().getAttAssignment_4_1()); 
            // InternalModelText.g:741:2: ( rule__Element__AttAssignment_4_1 )
            // InternalModelText.g:741:3: rule__Element__AttAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__AttAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAttAssignment_4_1()); 

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
    // InternalModelText.g:749:1: rule__Element__Group_4__2 : rule__Element__Group_4__2__Impl ;
    public final void rule__Element__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:753:1: ( rule__Element__Group_4__2__Impl )
            // InternalModelText.g:754:2: rule__Element__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Element__Group_4__2__Impl();

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
    // InternalModelText.g:760:1: rule__Element__Group_4__2__Impl : ( ')' ) ;
    public final void rule__Element__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:764:1: ( ( ')' ) )
            // InternalModelText.g:765:1: ( ')' )
            {
            // InternalModelText.g:765:1: ( ')' )
            // InternalModelText.g:766:2: ')'
            {
             before(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_2()); 
            match(input,17,FOLLOW_2); 
             after(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_2()); 

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


    // $ANTLR start "rule__Element__Group_6__0"
    // InternalModelText.g:776:1: rule__Element__Group_6__0 : rule__Element__Group_6__0__Impl rule__Element__Group_6__1 ;
    public final void rule__Element__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:780:1: ( rule__Element__Group_6__0__Impl rule__Element__Group_6__1 )
            // InternalModelText.g:781:2: rule__Element__Group_6__0__Impl rule__Element__Group_6__1
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
    // InternalModelText.g:788:1: rule__Element__Group_6__0__Impl : ( ( rule__Element__WordsAssignment_6_0 ) ) ;
    public final void rule__Element__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:792:1: ( ( ( rule__Element__WordsAssignment_6_0 ) ) )
            // InternalModelText.g:793:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            {
            // InternalModelText.g:793:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            // InternalModelText.g:794:2: ( rule__Element__WordsAssignment_6_0 )
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_0()); 
            // InternalModelText.g:795:2: ( rule__Element__WordsAssignment_6_0 )
            // InternalModelText.g:795:3: rule__Element__WordsAssignment_6_0
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
    // InternalModelText.g:803:1: rule__Element__Group_6__1 : rule__Element__Group_6__1__Impl ;
    public final void rule__Element__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:807:1: ( rule__Element__Group_6__1__Impl )
            // InternalModelText.g:808:2: rule__Element__Group_6__1__Impl
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
    // InternalModelText.g:814:1: rule__Element__Group_6__1__Impl : ( ( rule__Element__WordsAssignment_6_1 )* ) ;
    public final void rule__Element__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:818:1: ( ( ( rule__Element__WordsAssignment_6_1 )* ) )
            // InternalModelText.g:819:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            {
            // InternalModelText.g:819:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            // InternalModelText.g:820:2: ( rule__Element__WordsAssignment_6_1 )*
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_1()); 
            // InternalModelText.g:821:2: ( rule__Element__WordsAssignment_6_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)||LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalModelText.g:821:3: rule__Element__WordsAssignment_6_1
            	    {
            	    pushFollow(FOLLOW_12);
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


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalModelText.g:830:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:834:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalModelText.g:835:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__1();

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
    // $ANTLR end "rule__Attribute__Group__0"


    // $ANTLR start "rule__Attribute__Group__0__Impl"
    // InternalModelText.g:842:1: rule__Attribute__Group__0__Impl : ( () ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:846:1: ( ( () ) )
            // InternalModelText.g:847:1: ( () )
            {
            // InternalModelText.g:847:1: ( () )
            // InternalModelText.g:848:2: ()
            {
             before(grammarAccess.getAttributeAccess().getAttributeAction_0()); 
            // InternalModelText.g:849:2: ()
            // InternalModelText.g:849:3: 
            {
            }

             after(grammarAccess.getAttributeAccess().getAttributeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Attribute__Group__0__Impl"


    // $ANTLR start "rule__Attribute__Group__1"
    // InternalModelText.g:857:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:861:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalModelText.g:862:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2();

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
    // $ANTLR end "rule__Attribute__Group__1"


    // $ANTLR start "rule__Attribute__Group__1__Impl"
    // InternalModelText.g:869:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__Alternatives_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:873:1: ( ( ( rule__Attribute__Alternatives_1 )? ) )
            // InternalModelText.g:874:1: ( ( rule__Attribute__Alternatives_1 )? )
            {
            // InternalModelText.g:874:1: ( ( rule__Attribute__Alternatives_1 )? )
            // InternalModelText.g:875:2: ( rule__Attribute__Alternatives_1 )?
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_1()); 
            // InternalModelText.g:876:2: ( rule__Attribute__Alternatives_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==11||LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelText.g:876:3: rule__Attribute__Alternatives_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__Alternatives_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getAlternatives_1()); 

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
    // $ANTLR end "rule__Attribute__Group__1__Impl"


    // $ANTLR start "rule__Attribute__Group__2"
    // InternalModelText.g:884:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:888:1: ( rule__Attribute__Group__2__Impl )
            // InternalModelText.g:889:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__Group__2__Impl();

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
    // $ANTLR end "rule__Attribute__Group__2"


    // $ANTLR start "rule__Attribute__Group__2__Impl"
    // InternalModelText.g:895:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__AttAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:899:1: ( ( ( rule__Attribute__AttAssignment_2 ) ) )
            // InternalModelText.g:900:1: ( ( rule__Attribute__AttAssignment_2 ) )
            {
            // InternalModelText.g:900:1: ( ( rule__Attribute__AttAssignment_2 ) )
            // InternalModelText.g:901:2: ( rule__Attribute__AttAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getAttAssignment_2()); 
            // InternalModelText.g:902:2: ( rule__Attribute__AttAssignment_2 )
            // InternalModelText.g:902:3: rule__Attribute__AttAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Attribute__AttAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAttributeAccess().getAttAssignment_2()); 

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
    // $ANTLR end "rule__Attribute__Group__2__Impl"


    // $ANTLR start "rule__Constant__Group__0"
    // InternalModelText.g:911:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:915:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // InternalModelText.g:916:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
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
    // InternalModelText.g:923:1: rule__Constant__Group__0__Impl : ( () ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:927:1: ( ( () ) )
            // InternalModelText.g:928:1: ( () )
            {
            // InternalModelText.g:928:1: ( () )
            // InternalModelText.g:929:2: ()
            {
             before(grammarAccess.getConstantAccess().getConstantAction_0()); 
            // InternalModelText.g:930:2: ()
            // InternalModelText.g:930:3: 
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
    // InternalModelText.g:938:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:942:1: ( rule__Constant__Group__1__Impl )
            // InternalModelText.g:943:2: rule__Constant__Group__1__Impl
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
    // InternalModelText.g:949:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__ValueAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:953:1: ( ( ( rule__Constant__ValueAssignment_1 ) ) )
            // InternalModelText.g:954:1: ( ( rule__Constant__ValueAssignment_1 ) )
            {
            // InternalModelText.g:954:1: ( ( rule__Constant__ValueAssignment_1 ) )
            // InternalModelText.g:955:2: ( rule__Constant__ValueAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1()); 
            // InternalModelText.g:956:2: ( rule__Constant__ValueAssignment_1 )
            // InternalModelText.g:956:3: rule__Constant__ValueAssignment_1
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
    // InternalModelText.g:965:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:969:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalModelText.g:970:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalModelText.g:977:1: rule__Variable__Group__0__Impl : ( () ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:981:1: ( ( () ) )
            // InternalModelText.g:982:1: ( () )
            {
            // InternalModelText.g:982:1: ( () )
            // InternalModelText.g:983:2: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0()); 
            // InternalModelText.g:984:2: ()
            // InternalModelText.g:984:3: 
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
    // InternalModelText.g:992:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:996:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalModelText.g:997:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
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
    // InternalModelText.g:1004:1: rule__Variable__Group__1__Impl : ( '%' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1008:1: ( ( '%' ) )
            // InternalModelText.g:1009:1: ( '%' )
            {
            // InternalModelText.g:1009:1: ( '%' )
            // InternalModelText.g:1010:2: '%'
            {
             before(grammarAccess.getVariableAccess().getPercentSignKeyword_1()); 
            match(input,18,FOLLOW_2); 
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
    // InternalModelText.g:1019:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1023:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalModelText.g:1024:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
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
    // InternalModelText.g:1031:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Group_2__0 )? ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1035:1: ( ( ( rule__Variable__Group_2__0 )? ) )
            // InternalModelText.g:1036:1: ( ( rule__Variable__Group_2__0 )? )
            {
            // InternalModelText.g:1036:1: ( ( rule__Variable__Group_2__0 )? )
            // InternalModelText.g:1037:2: ( rule__Variable__Group_2__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2()); 
            // InternalModelText.g:1038:2: ( rule__Variable__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==15) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // InternalModelText.g:1038:3: rule__Variable__Group_2__0
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
    // InternalModelText.g:1046:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1050:1: ( rule__Variable__Group__3__Impl )
            // InternalModelText.g:1051:2: rule__Variable__Group__3__Impl
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
    // InternalModelText.g:1057:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__IdAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1061:1: ( ( ( rule__Variable__IdAssignment_3 ) ) )
            // InternalModelText.g:1062:1: ( ( rule__Variable__IdAssignment_3 ) )
            {
            // InternalModelText.g:1062:1: ( ( rule__Variable__IdAssignment_3 ) )
            // InternalModelText.g:1063:2: ( rule__Variable__IdAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getIdAssignment_3()); 
            // InternalModelText.g:1064:2: ( rule__Variable__IdAssignment_3 )
            // InternalModelText.g:1064:3: rule__Variable__IdAssignment_3
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
    // InternalModelText.g:1073:1: rule__Variable__Group_2__0 : rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 ;
    public final void rule__Variable__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1077:1: ( rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 )
            // InternalModelText.g:1078:2: rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1
            {
            pushFollow(FOLLOW_13);
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
    // InternalModelText.g:1085:1: rule__Variable__Group_2__0__Impl : ( ( rule__Variable__RefAssignment_2_0 ) ) ;
    public final void rule__Variable__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1089:1: ( ( ( rule__Variable__RefAssignment_2_0 ) ) )
            // InternalModelText.g:1090:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            {
            // InternalModelText.g:1090:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            // InternalModelText.g:1091:2: ( rule__Variable__RefAssignment_2_0 )
            {
             before(grammarAccess.getVariableAccess().getRefAssignment_2_0()); 
            // InternalModelText.g:1092:2: ( rule__Variable__RefAssignment_2_0 )
            // InternalModelText.g:1092:3: rule__Variable__RefAssignment_2_0
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
    // InternalModelText.g:1100:1: rule__Variable__Group_2__1 : rule__Variable__Group_2__1__Impl ;
    public final void rule__Variable__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1104:1: ( rule__Variable__Group_2__1__Impl )
            // InternalModelText.g:1105:2: rule__Variable__Group_2__1__Impl
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
    // InternalModelText.g:1111:1: rule__Variable__Group_2__1__Impl : ( '.' ) ;
    public final void rule__Variable__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1115:1: ( ( '.' ) )
            // InternalModelText.g:1116:1: ( '.' )
            {
            // InternalModelText.g:1116:1: ( '.' )
            // InternalModelText.g:1117:2: '.'
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


    // $ANTLR start "rule__IdentifyElements__MetamodelAssignment_2"
    // InternalModelText.g:1127:1: rule__IdentifyElements__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__IdentifyElements__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1131:1: ( ( ruleEString ) )
            // InternalModelText.g:1132:2: ( ruleEString )
            {
            // InternalModelText.g:1132:2: ( ruleEString )
            // InternalModelText.g:1133:3: ruleEString
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
    // InternalModelText.g:1142:1: rule__IdentifyElements__ElementsAssignment_3_0 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1146:1: ( ( ruleElement ) )
            // InternalModelText.g:1147:2: ( ruleElement )
            {
            // InternalModelText.g:1147:2: ( ruleElement )
            // InternalModelText.g:1148:3: ruleElement
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
    // InternalModelText.g:1157:1: rule__IdentifyElements__ElementsAssignment_3_1 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1161:1: ( ( ruleElement ) )
            // InternalModelText.g:1162:2: ( ruleElement )
            {
            // InternalModelText.g:1162:2: ( ruleElement )
            // InternalModelText.g:1163:3: ruleElement
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
    // InternalModelText.g:1172:1: rule__Element__TypeAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__Element__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1176:1: ( ( ( ruleEString ) ) )
            // InternalModelText.g:1177:2: ( ( ruleEString ) )
            {
            // InternalModelText.g:1177:2: ( ( ruleEString ) )
            // InternalModelText.g:1178:3: ( ruleEString )
            {
             before(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); 
            // InternalModelText.g:1179:3: ( ruleEString )
            // InternalModelText.g:1180:4: ruleEString
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
    // InternalModelText.g:1191:1: rule__Element__RefAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__RefAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1195:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1196:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1196:2: ( ( RULE_ID ) )
            // InternalModelText.g:1197:3: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); 
            // InternalModelText.g:1198:3: ( RULE_ID )
            // InternalModelText.g:1199:4: RULE_ID
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


    // $ANTLR start "rule__Element__AttAssignment_4_1"
    // InternalModelText.g:1210:1: rule__Element__AttAssignment_4_1 : ( ruleAttribute ) ;
    public final void rule__Element__AttAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1214:1: ( ( ruleAttribute ) )
            // InternalModelText.g:1215:2: ( ruleAttribute )
            {
            // InternalModelText.g:1215:2: ( ruleAttribute )
            // InternalModelText.g:1216:3: ruleAttribute
            {
             before(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_1_0()); 

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
    // $ANTLR end "rule__Element__AttAssignment_4_1"


    // $ANTLR start "rule__Element__WordsAssignment_6_0"
    // InternalModelText.g:1225:1: rule__Element__WordsAssignment_6_0 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1229:1: ( ( ruleWord ) )
            // InternalModelText.g:1230:2: ( ruleWord )
            {
            // InternalModelText.g:1230:2: ( ruleWord )
            // InternalModelText.g:1231:3: ruleWord
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
    // InternalModelText.g:1240:1: rule__Element__WordsAssignment_6_1 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1244:1: ( ( ruleWord ) )
            // InternalModelText.g:1245:2: ( ruleWord )
            {
            // InternalModelText.g:1245:2: ( ruleWord )
            // InternalModelText.g:1246:3: ruleWord
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


    // $ANTLR start "rule__Attribute__NegationAssignment_1_0"
    // InternalModelText.g:1255:1: rule__Attribute__NegationAssignment_1_0 : ( ( 'yes' ) ) ;
    public final void rule__Attribute__NegationAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1259:1: ( ( ( 'yes' ) ) )
            // InternalModelText.g:1260:2: ( ( 'yes' ) )
            {
            // InternalModelText.g:1260:2: ( ( 'yes' ) )
            // InternalModelText.g:1261:3: ( 'yes' )
            {
             before(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); 
            // InternalModelText.g:1262:3: ( 'yes' )
            // InternalModelText.g:1263:4: 'yes'
            {
             before(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); 

            }

             after(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); 

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
    // $ANTLR end "rule__Attribute__NegationAssignment_1_0"


    // $ANTLR start "rule__Attribute__AttAssignment_2"
    // InternalModelText.g:1274:1: rule__Attribute__AttAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__AttAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1278:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1279:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1279:2: ( ( RULE_ID ) )
            // InternalModelText.g:1280:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0()); 
            // InternalModelText.g:1281:3: ( RULE_ID )
            // InternalModelText.g:1282:4: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getAttEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getAttEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0()); 

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
    // $ANTLR end "rule__Attribute__AttAssignment_2"


    // $ANTLR start "rule__Constant__ValueAssignment_1"
    // InternalModelText.g:1293:1: rule__Constant__ValueAssignment_1 : ( ruleEString ) ;
    public final void rule__Constant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1297:1: ( ( ruleEString ) )
            // InternalModelText.g:1298:2: ( ruleEString )
            {
            // InternalModelText.g:1298:2: ( ruleEString )
            // InternalModelText.g:1299:3: ruleEString
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
    // InternalModelText.g:1308:1: rule__Variable__RefAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__RefAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1312:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1313:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1313:2: ( ( RULE_ID ) )
            // InternalModelText.g:1314:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); 
            // InternalModelText.g:1315:3: ( RULE_ID )
            // InternalModelText.g:1316:4: RULE_ID
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
    // InternalModelText.g:1327:1: rule__Variable__IdAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__IdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1331:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1332:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1332:2: ( ( RULE_ID ) )
            // InternalModelText.g:1333:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); 
            // InternalModelText.g:1334:3: ( RULE_ID )
            // InternalModelText.g:1335:4: RULE_ID
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

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000001C000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080820L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000040032L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000008000L});

}