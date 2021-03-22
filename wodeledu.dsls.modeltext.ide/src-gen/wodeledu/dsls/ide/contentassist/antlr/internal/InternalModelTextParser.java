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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'metamodel'", "'>'", "':'", "'.'", "'('", "')'", "','", "'%'", "'not'"
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


    // $ANTLR start "rule__Word__Alternatives"
    // InternalModelText.g:227:1: rule__Word__Alternatives : ( ( ruleConstant ) | ( ruleVariable ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:231:1: ( ( ruleConstant ) | ( ruleVariable ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( (LA1_0==18) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalModelText.g:232:2: ( ruleConstant )
                    {
                    // InternalModelText.g:232:2: ( ruleConstant )
                    // InternalModelText.g:233:3: ruleConstant
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
                    // InternalModelText.g:238:2: ( ruleVariable )
                    {
                    // InternalModelText.g:238:2: ( ruleVariable )
                    // InternalModelText.g:239:3: ruleVariable
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
    // InternalModelText.g:248:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:252:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalModelText.g:253:2: ( RULE_STRING )
                    {
                    // InternalModelText.g:253:2: ( RULE_STRING )
                    // InternalModelText.g:254:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelText.g:259:2: ( RULE_ID )
                    {
                    // InternalModelText.g:259:2: ( RULE_ID )
                    // InternalModelText.g:260:3: RULE_ID
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
    // InternalModelText.g:269:1: rule__IdentifyElements__Group__0 : rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 ;
    public final void rule__IdentifyElements__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:273:1: ( rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 )
            // InternalModelText.g:274:2: rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1
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
    // InternalModelText.g:281:1: rule__IdentifyElements__Group__0__Impl : ( () ) ;
    public final void rule__IdentifyElements__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:285:1: ( ( () ) )
            // InternalModelText.g:286:1: ( () )
            {
            // InternalModelText.g:286:1: ( () )
            // InternalModelText.g:287:2: ()
            {
             before(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); 
            // InternalModelText.g:288:2: ()
            // InternalModelText.g:288:3: 
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
    // InternalModelText.g:296:1: rule__IdentifyElements__Group__1 : rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 ;
    public final void rule__IdentifyElements__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:300:1: ( rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 )
            // InternalModelText.g:301:2: rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2
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
    // InternalModelText.g:308:1: rule__IdentifyElements__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__IdentifyElements__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:312:1: ( ( 'metamodel' ) )
            // InternalModelText.g:313:1: ( 'metamodel' )
            {
            // InternalModelText.g:313:1: ( 'metamodel' )
            // InternalModelText.g:314:2: 'metamodel'
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1()); 
            match(input,11,FOLLOW_2); 
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
    // InternalModelText.g:323:1: rule__IdentifyElements__Group__2 : rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 ;
    public final void rule__IdentifyElements__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:327:1: ( rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 )
            // InternalModelText.g:328:2: rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3
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
    // InternalModelText.g:335:1: rule__IdentifyElements__Group__2__Impl : ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) ;
    public final void rule__IdentifyElements__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:339:1: ( ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) )
            // InternalModelText.g:340:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            {
            // InternalModelText.g:340:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            // InternalModelText.g:341:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); 
            // InternalModelText.g:342:2: ( rule__IdentifyElements__MetamodelAssignment_2 )
            // InternalModelText.g:342:3: rule__IdentifyElements__MetamodelAssignment_2
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
    // InternalModelText.g:350:1: rule__IdentifyElements__Group__3 : rule__IdentifyElements__Group__3__Impl ;
    public final void rule__IdentifyElements__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:354:1: ( rule__IdentifyElements__Group__3__Impl )
            // InternalModelText.g:355:2: rule__IdentifyElements__Group__3__Impl
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
    // InternalModelText.g:361:1: rule__IdentifyElements__Group__3__Impl : ( ( rule__IdentifyElements__Group_3__0 )? ) ;
    public final void rule__IdentifyElements__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:365:1: ( ( ( rule__IdentifyElements__Group_3__0 )? ) )
            // InternalModelText.g:366:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            {
            // InternalModelText.g:366:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            // InternalModelText.g:367:2: ( rule__IdentifyElements__Group_3__0 )?
            {
             before(grammarAccess.getIdentifyElementsAccess().getGroup_3()); 
            // InternalModelText.g:368:2: ( rule__IdentifyElements__Group_3__0 )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalModelText.g:368:3: rule__IdentifyElements__Group_3__0
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
    // InternalModelText.g:377:1: rule__IdentifyElements__Group_3__0 : rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 ;
    public final void rule__IdentifyElements__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:381:1: ( rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 )
            // InternalModelText.g:382:2: rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1
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
    // InternalModelText.g:389:1: rule__IdentifyElements__Group_3__0__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) ;
    public final void rule__IdentifyElements__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:393:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) )
            // InternalModelText.g:394:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            {
            // InternalModelText.g:394:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            // InternalModelText.g:395:2: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_0()); 
            // InternalModelText.g:396:2: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            // InternalModelText.g:396:3: rule__IdentifyElements__ElementsAssignment_3_0
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
    // InternalModelText.g:404:1: rule__IdentifyElements__Group_3__1 : rule__IdentifyElements__Group_3__1__Impl ;
    public final void rule__IdentifyElements__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:408:1: ( rule__IdentifyElements__Group_3__1__Impl )
            // InternalModelText.g:409:2: rule__IdentifyElements__Group_3__1__Impl
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
    // InternalModelText.g:415:1: rule__IdentifyElements__Group_3__1__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) ;
    public final void rule__IdentifyElements__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:419:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) )
            // InternalModelText.g:420:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            {
            // InternalModelText.g:420:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            // InternalModelText.g:421:2: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_1()); 
            // InternalModelText.g:422:2: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==12) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalModelText.g:422:3: rule__IdentifyElements__ElementsAssignment_3_1
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
    // InternalModelText.g:431:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:435:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // InternalModelText.g:436:2: rule__Element__Group__0__Impl rule__Element__Group__1
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
    // InternalModelText.g:443:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:447:1: ( ( () ) )
            // InternalModelText.g:448:1: ( () )
            {
            // InternalModelText.g:448:1: ( () )
            // InternalModelText.g:449:2: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // InternalModelText.g:450:2: ()
            // InternalModelText.g:450:3: 
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
    // InternalModelText.g:458:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:462:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // InternalModelText.g:463:2: rule__Element__Group__1__Impl rule__Element__Group__2
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
    // InternalModelText.g:470:1: rule__Element__Group__1__Impl : ( '>' ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:474:1: ( ( '>' ) )
            // InternalModelText.g:475:1: ( '>' )
            {
            // InternalModelText.g:475:1: ( '>' )
            // InternalModelText.g:476:2: '>'
            {
             before(grammarAccess.getElementAccess().getGreaterThanSignKeyword_1()); 
            match(input,12,FOLLOW_2); 
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
    // InternalModelText.g:485:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:489:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // InternalModelText.g:490:2: rule__Element__Group__2__Impl rule__Element__Group__3
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
    // InternalModelText.g:497:1: rule__Element__Group__2__Impl : ( ( rule__Element__TypeAssignment_2 ) ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:501:1: ( ( ( rule__Element__TypeAssignment_2 ) ) )
            // InternalModelText.g:502:1: ( ( rule__Element__TypeAssignment_2 ) )
            {
            // InternalModelText.g:502:1: ( ( rule__Element__TypeAssignment_2 ) )
            // InternalModelText.g:503:2: ( rule__Element__TypeAssignment_2 )
            {
             before(grammarAccess.getElementAccess().getTypeAssignment_2()); 
            // InternalModelText.g:504:2: ( rule__Element__TypeAssignment_2 )
            // InternalModelText.g:504:3: rule__Element__TypeAssignment_2
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
    // InternalModelText.g:512:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:516:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // InternalModelText.g:517:2: rule__Element__Group__3__Impl rule__Element__Group__4
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
    // InternalModelText.g:524:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:528:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // InternalModelText.g:529:1: ( ( rule__Element__Group_3__0 )? )
            {
            // InternalModelText.g:529:1: ( ( rule__Element__Group_3__0 )? )
            // InternalModelText.g:530:2: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // InternalModelText.g:531:2: ( rule__Element__Group_3__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==14) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelText.g:531:3: rule__Element__Group_3__0
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
    // InternalModelText.g:539:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:543:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // InternalModelText.g:544:2: rule__Element__Group__4__Impl rule__Element__Group__5
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
    // InternalModelText.g:551:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:555:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // InternalModelText.g:556:1: ( ( rule__Element__Group_4__0 )? )
            {
            // InternalModelText.g:556:1: ( ( rule__Element__Group_4__0 )? )
            // InternalModelText.g:557:2: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // InternalModelText.g:558:2: ( rule__Element__Group_4__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalModelText.g:558:3: rule__Element__Group_4__0
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
    // InternalModelText.g:566:1: rule__Element__Group__5 : rule__Element__Group__5__Impl rule__Element__Group__6 ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:570:1: ( rule__Element__Group__5__Impl rule__Element__Group__6 )
            // InternalModelText.g:571:2: rule__Element__Group__5__Impl rule__Element__Group__6
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
    // InternalModelText.g:578:1: rule__Element__Group__5__Impl : ( ':' ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:582:1: ( ( ':' ) )
            // InternalModelText.g:583:1: ( ':' )
            {
            // InternalModelText.g:583:1: ( ':' )
            // InternalModelText.g:584:2: ':'
            {
             before(grammarAccess.getElementAccess().getColonKeyword_5()); 
            match(input,13,FOLLOW_2); 
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
    // InternalModelText.g:593:1: rule__Element__Group__6 : rule__Element__Group__6__Impl ;
    public final void rule__Element__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:597:1: ( rule__Element__Group__6__Impl )
            // InternalModelText.g:598:2: rule__Element__Group__6__Impl
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
    // InternalModelText.g:604:1: rule__Element__Group__6__Impl : ( ( rule__Element__Group_6__0 )? ) ;
    public final void rule__Element__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:608:1: ( ( ( rule__Element__Group_6__0 )? ) )
            // InternalModelText.g:609:1: ( ( rule__Element__Group_6__0 )? )
            {
            // InternalModelText.g:609:1: ( ( rule__Element__Group_6__0 )? )
            // InternalModelText.g:610:2: ( rule__Element__Group_6__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_6()); 
            // InternalModelText.g:611:2: ( rule__Element__Group_6__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelText.g:611:3: rule__Element__Group_6__0
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
    // InternalModelText.g:620:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:624:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // InternalModelText.g:625:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
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
    // InternalModelText.g:632:1: rule__Element__Group_3__0__Impl : ( '.' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:636:1: ( ( '.' ) )
            // InternalModelText.g:637:1: ( '.' )
            {
            // InternalModelText.g:637:1: ( '.' )
            // InternalModelText.g:638:2: '.'
            {
             before(grammarAccess.getElementAccess().getFullStopKeyword_3_0()); 
            match(input,14,FOLLOW_2); 
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
    // InternalModelText.g:647:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:651:1: ( rule__Element__Group_3__1__Impl )
            // InternalModelText.g:652:2: rule__Element__Group_3__1__Impl
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
    // InternalModelText.g:658:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__RefAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:662:1: ( ( ( rule__Element__RefAssignment_3_1 ) ) )
            // InternalModelText.g:663:1: ( ( rule__Element__RefAssignment_3_1 ) )
            {
            // InternalModelText.g:663:1: ( ( rule__Element__RefAssignment_3_1 ) )
            // InternalModelText.g:664:2: ( rule__Element__RefAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getRefAssignment_3_1()); 
            // InternalModelText.g:665:2: ( rule__Element__RefAssignment_3_1 )
            // InternalModelText.g:665:3: rule__Element__RefAssignment_3_1
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
    // InternalModelText.g:674:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:678:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // InternalModelText.g:679:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
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
    // InternalModelText.g:686:1: rule__Element__Group_4__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:690:1: ( ( '(' ) )
            // InternalModelText.g:691:1: ( '(' )
            {
            // InternalModelText.g:691:1: ( '(' )
            // InternalModelText.g:692:2: '('
            {
             before(grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0()); 
            match(input,15,FOLLOW_2); 
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
    // InternalModelText.g:701:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl rule__Element__Group_4__2 ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:705:1: ( rule__Element__Group_4__1__Impl rule__Element__Group_4__2 )
            // InternalModelText.g:706:2: rule__Element__Group_4__1__Impl rule__Element__Group_4__2
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
    // InternalModelText.g:713:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__AttAssignment_4_1 ) ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:717:1: ( ( ( rule__Element__AttAssignment_4_1 ) ) )
            // InternalModelText.g:718:1: ( ( rule__Element__AttAssignment_4_1 ) )
            {
            // InternalModelText.g:718:1: ( ( rule__Element__AttAssignment_4_1 ) )
            // InternalModelText.g:719:2: ( rule__Element__AttAssignment_4_1 )
            {
             before(grammarAccess.getElementAccess().getAttAssignment_4_1()); 
            // InternalModelText.g:720:2: ( rule__Element__AttAssignment_4_1 )
            // InternalModelText.g:720:3: rule__Element__AttAssignment_4_1
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
    // InternalModelText.g:728:1: rule__Element__Group_4__2 : rule__Element__Group_4__2__Impl rule__Element__Group_4__3 ;
    public final void rule__Element__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:732:1: ( rule__Element__Group_4__2__Impl rule__Element__Group_4__3 )
            // InternalModelText.g:733:2: rule__Element__Group_4__2__Impl rule__Element__Group_4__3
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
    // InternalModelText.g:740:1: rule__Element__Group_4__2__Impl : ( ( rule__Element__Group_4_2__0 )* ) ;
    public final void rule__Element__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:744:1: ( ( ( rule__Element__Group_4_2__0 )* ) )
            // InternalModelText.g:745:1: ( ( rule__Element__Group_4_2__0 )* )
            {
            // InternalModelText.g:745:1: ( ( rule__Element__Group_4_2__0 )* )
            // InternalModelText.g:746:2: ( rule__Element__Group_4_2__0 )*
            {
             before(grammarAccess.getElementAccess().getGroup_4_2()); 
            // InternalModelText.g:747:2: ( rule__Element__Group_4_2__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalModelText.g:747:3: rule__Element__Group_4_2__0
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
    // InternalModelText.g:755:1: rule__Element__Group_4__3 : rule__Element__Group_4__3__Impl ;
    public final void rule__Element__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:759:1: ( rule__Element__Group_4__3__Impl )
            // InternalModelText.g:760:2: rule__Element__Group_4__3__Impl
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
    // InternalModelText.g:766:1: rule__Element__Group_4__3__Impl : ( ')' ) ;
    public final void rule__Element__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:770:1: ( ( ')' ) )
            // InternalModelText.g:771:1: ( ')' )
            {
            // InternalModelText.g:771:1: ( ')' )
            // InternalModelText.g:772:2: ')'
            {
             before(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_3()); 
            match(input,16,FOLLOW_2); 
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
    // InternalModelText.g:782:1: rule__Element__Group_4_2__0 : rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1 ;
    public final void rule__Element__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:786:1: ( rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1 )
            // InternalModelText.g:787:2: rule__Element__Group_4_2__0__Impl rule__Element__Group_4_2__1
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
    // InternalModelText.g:794:1: rule__Element__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Element__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:798:1: ( ( ',' ) )
            // InternalModelText.g:799:1: ( ',' )
            {
            // InternalModelText.g:799:1: ( ',' )
            // InternalModelText.g:800:2: ','
            {
             before(grammarAccess.getElementAccess().getCommaKeyword_4_2_0()); 
            match(input,17,FOLLOW_2); 
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
    // InternalModelText.g:809:1: rule__Element__Group_4_2__1 : rule__Element__Group_4_2__1__Impl ;
    public final void rule__Element__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:813:1: ( rule__Element__Group_4_2__1__Impl )
            // InternalModelText.g:814:2: rule__Element__Group_4_2__1__Impl
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
    // InternalModelText.g:820:1: rule__Element__Group_4_2__1__Impl : ( ( rule__Element__AttAssignment_4_2_1 ) ) ;
    public final void rule__Element__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:824:1: ( ( ( rule__Element__AttAssignment_4_2_1 ) ) )
            // InternalModelText.g:825:1: ( ( rule__Element__AttAssignment_4_2_1 ) )
            {
            // InternalModelText.g:825:1: ( ( rule__Element__AttAssignment_4_2_1 ) )
            // InternalModelText.g:826:2: ( rule__Element__AttAssignment_4_2_1 )
            {
             before(grammarAccess.getElementAccess().getAttAssignment_4_2_1()); 
            // InternalModelText.g:827:2: ( rule__Element__AttAssignment_4_2_1 )
            // InternalModelText.g:827:3: rule__Element__AttAssignment_4_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Element__AttAssignment_4_2_1();

            state._fsp--;


            }

             after(grammarAccess.getElementAccess().getAttAssignment_4_2_1()); 

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
    // InternalModelText.g:836:1: rule__Element__Group_6__0 : rule__Element__Group_6__0__Impl rule__Element__Group_6__1 ;
    public final void rule__Element__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:840:1: ( rule__Element__Group_6__0__Impl rule__Element__Group_6__1 )
            // InternalModelText.g:841:2: rule__Element__Group_6__0__Impl rule__Element__Group_6__1
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
    // InternalModelText.g:848:1: rule__Element__Group_6__0__Impl : ( ( rule__Element__WordsAssignment_6_0 ) ) ;
    public final void rule__Element__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:852:1: ( ( ( rule__Element__WordsAssignment_6_0 ) ) )
            // InternalModelText.g:853:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            {
            // InternalModelText.g:853:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            // InternalModelText.g:854:2: ( rule__Element__WordsAssignment_6_0 )
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_0()); 
            // InternalModelText.g:855:2: ( rule__Element__WordsAssignment_6_0 )
            // InternalModelText.g:855:3: rule__Element__WordsAssignment_6_0
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
    // InternalModelText.g:863:1: rule__Element__Group_6__1 : rule__Element__Group_6__1__Impl ;
    public final void rule__Element__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:867:1: ( rule__Element__Group_6__1__Impl )
            // InternalModelText.g:868:2: rule__Element__Group_6__1__Impl
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
    // InternalModelText.g:874:1: rule__Element__Group_6__1__Impl : ( ( rule__Element__WordsAssignment_6_1 )* ) ;
    public final void rule__Element__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:878:1: ( ( ( rule__Element__WordsAssignment_6_1 )* ) )
            // InternalModelText.g:879:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            {
            // InternalModelText.g:879:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            // InternalModelText.g:880:2: ( rule__Element__WordsAssignment_6_1 )*
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_1()); 
            // InternalModelText.g:881:2: ( rule__Element__WordsAssignment_6_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)||LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalModelText.g:881:3: rule__Element__WordsAssignment_6_1
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


    // $ANTLR start "rule__Attribute__Group__0"
    // InternalModelText.g:890:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:894:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // InternalModelText.g:895:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
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
    // InternalModelText.g:902:1: rule__Attribute__Group__0__Impl : ( () ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:906:1: ( ( () ) )
            // InternalModelText.g:907:1: ( () )
            {
            // InternalModelText.g:907:1: ( () )
            // InternalModelText.g:908:2: ()
            {
             before(grammarAccess.getAttributeAccess().getAttributeAction_0()); 
            // InternalModelText.g:909:2: ()
            // InternalModelText.g:909:3: 
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
    // InternalModelText.g:917:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:921:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // InternalModelText.g:922:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
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
    // InternalModelText.g:929:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__NegationAssignment_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:933:1: ( ( ( rule__Attribute__NegationAssignment_1 )? ) )
            // InternalModelText.g:934:1: ( ( rule__Attribute__NegationAssignment_1 )? )
            {
            // InternalModelText.g:934:1: ( ( rule__Attribute__NegationAssignment_1 )? )
            // InternalModelText.g:935:2: ( rule__Attribute__NegationAssignment_1 )?
            {
             before(grammarAccess.getAttributeAccess().getNegationAssignment_1()); 
            // InternalModelText.g:936:2: ( rule__Attribute__NegationAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelText.g:936:3: rule__Attribute__NegationAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Attribute__NegationAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAttributeAccess().getNegationAssignment_1()); 

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
    // InternalModelText.g:944:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:948:1: ( rule__Attribute__Group__2__Impl )
            // InternalModelText.g:949:2: rule__Attribute__Group__2__Impl
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
    // InternalModelText.g:955:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__AttAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:959:1: ( ( ( rule__Attribute__AttAssignment_2 ) ) )
            // InternalModelText.g:960:1: ( ( rule__Attribute__AttAssignment_2 ) )
            {
            // InternalModelText.g:960:1: ( ( rule__Attribute__AttAssignment_2 ) )
            // InternalModelText.g:961:2: ( rule__Attribute__AttAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getAttAssignment_2()); 
            // InternalModelText.g:962:2: ( rule__Attribute__AttAssignment_2 )
            // InternalModelText.g:962:3: rule__Attribute__AttAssignment_2
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
    // InternalModelText.g:971:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:975:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // InternalModelText.g:976:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
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
    // InternalModelText.g:983:1: rule__Constant__Group__0__Impl : ( () ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:987:1: ( ( () ) )
            // InternalModelText.g:988:1: ( () )
            {
            // InternalModelText.g:988:1: ( () )
            // InternalModelText.g:989:2: ()
            {
             before(grammarAccess.getConstantAccess().getConstantAction_0()); 
            // InternalModelText.g:990:2: ()
            // InternalModelText.g:990:3: 
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
    // InternalModelText.g:998:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1002:1: ( rule__Constant__Group__1__Impl )
            // InternalModelText.g:1003:2: rule__Constant__Group__1__Impl
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
    // InternalModelText.g:1009:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__ValueAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1013:1: ( ( ( rule__Constant__ValueAssignment_1 ) ) )
            // InternalModelText.g:1014:1: ( ( rule__Constant__ValueAssignment_1 ) )
            {
            // InternalModelText.g:1014:1: ( ( rule__Constant__ValueAssignment_1 ) )
            // InternalModelText.g:1015:2: ( rule__Constant__ValueAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1()); 
            // InternalModelText.g:1016:2: ( rule__Constant__ValueAssignment_1 )
            // InternalModelText.g:1016:3: rule__Constant__ValueAssignment_1
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
    // InternalModelText.g:1025:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1029:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalModelText.g:1030:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalModelText.g:1037:1: rule__Variable__Group__0__Impl : ( () ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1041:1: ( ( () ) )
            // InternalModelText.g:1042:1: ( () )
            {
            // InternalModelText.g:1042:1: ( () )
            // InternalModelText.g:1043:2: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0()); 
            // InternalModelText.g:1044:2: ()
            // InternalModelText.g:1044:3: 
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
    // InternalModelText.g:1052:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1056:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // InternalModelText.g:1057:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
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
    // InternalModelText.g:1064:1: rule__Variable__Group__1__Impl : ( '%' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1068:1: ( ( '%' ) )
            // InternalModelText.g:1069:1: ( '%' )
            {
            // InternalModelText.g:1069:1: ( '%' )
            // InternalModelText.g:1070:2: '%'
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
    // InternalModelText.g:1079:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1083:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // InternalModelText.g:1084:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
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
    // InternalModelText.g:1091:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Group_2__0 )? ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1095:1: ( ( ( rule__Variable__Group_2__0 )? ) )
            // InternalModelText.g:1096:1: ( ( rule__Variable__Group_2__0 )? )
            {
            // InternalModelText.g:1096:1: ( ( rule__Variable__Group_2__0 )? )
            // InternalModelText.g:1097:2: ( rule__Variable__Group_2__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2()); 
            // InternalModelText.g:1098:2: ( rule__Variable__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==14) ) {
                    alt11=1;
                }
            }
            switch (alt11) {
                case 1 :
                    // InternalModelText.g:1098:3: rule__Variable__Group_2__0
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
    // InternalModelText.g:1106:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1110:1: ( rule__Variable__Group__3__Impl )
            // InternalModelText.g:1111:2: rule__Variable__Group__3__Impl
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
    // InternalModelText.g:1117:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__IdAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1121:1: ( ( ( rule__Variable__IdAssignment_3 ) ) )
            // InternalModelText.g:1122:1: ( ( rule__Variable__IdAssignment_3 ) )
            {
            // InternalModelText.g:1122:1: ( ( rule__Variable__IdAssignment_3 ) )
            // InternalModelText.g:1123:2: ( rule__Variable__IdAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getIdAssignment_3()); 
            // InternalModelText.g:1124:2: ( rule__Variable__IdAssignment_3 )
            // InternalModelText.g:1124:3: rule__Variable__IdAssignment_3
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
    // InternalModelText.g:1133:1: rule__Variable__Group_2__0 : rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 ;
    public final void rule__Variable__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1137:1: ( rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 )
            // InternalModelText.g:1138:2: rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalModelText.g:1145:1: rule__Variable__Group_2__0__Impl : ( ( rule__Variable__RefAssignment_2_0 ) ) ;
    public final void rule__Variable__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1149:1: ( ( ( rule__Variable__RefAssignment_2_0 ) ) )
            // InternalModelText.g:1150:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            {
            // InternalModelText.g:1150:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            // InternalModelText.g:1151:2: ( rule__Variable__RefAssignment_2_0 )
            {
             before(grammarAccess.getVariableAccess().getRefAssignment_2_0()); 
            // InternalModelText.g:1152:2: ( rule__Variable__RefAssignment_2_0 )
            // InternalModelText.g:1152:3: rule__Variable__RefAssignment_2_0
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
    // InternalModelText.g:1160:1: rule__Variable__Group_2__1 : rule__Variable__Group_2__1__Impl ;
    public final void rule__Variable__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1164:1: ( rule__Variable__Group_2__1__Impl )
            // InternalModelText.g:1165:2: rule__Variable__Group_2__1__Impl
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
    // InternalModelText.g:1171:1: rule__Variable__Group_2__1__Impl : ( '.' ) ;
    public final void rule__Variable__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1175:1: ( ( '.' ) )
            // InternalModelText.g:1176:1: ( '.' )
            {
            // InternalModelText.g:1176:1: ( '.' )
            // InternalModelText.g:1177:2: '.'
            {
             before(grammarAccess.getVariableAccess().getFullStopKeyword_2_1()); 
            match(input,14,FOLLOW_2); 
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
    // InternalModelText.g:1187:1: rule__IdentifyElements__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__IdentifyElements__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1191:1: ( ( ruleEString ) )
            // InternalModelText.g:1192:2: ( ruleEString )
            {
            // InternalModelText.g:1192:2: ( ruleEString )
            // InternalModelText.g:1193:3: ruleEString
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
    // InternalModelText.g:1202:1: rule__IdentifyElements__ElementsAssignment_3_0 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1206:1: ( ( ruleElement ) )
            // InternalModelText.g:1207:2: ( ruleElement )
            {
            // InternalModelText.g:1207:2: ( ruleElement )
            // InternalModelText.g:1208:3: ruleElement
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
    // InternalModelText.g:1217:1: rule__IdentifyElements__ElementsAssignment_3_1 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1221:1: ( ( ruleElement ) )
            // InternalModelText.g:1222:2: ( ruleElement )
            {
            // InternalModelText.g:1222:2: ( ruleElement )
            // InternalModelText.g:1223:3: ruleElement
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
    // InternalModelText.g:1232:1: rule__Element__TypeAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__Element__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1236:1: ( ( ( ruleEString ) ) )
            // InternalModelText.g:1237:2: ( ( ruleEString ) )
            {
            // InternalModelText.g:1237:2: ( ( ruleEString ) )
            // InternalModelText.g:1238:3: ( ruleEString )
            {
             before(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); 
            // InternalModelText.g:1239:3: ( ruleEString )
            // InternalModelText.g:1240:4: ruleEString
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
    // InternalModelText.g:1251:1: rule__Element__RefAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__RefAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1255:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1256:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1256:2: ( ( RULE_ID ) )
            // InternalModelText.g:1257:3: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); 
            // InternalModelText.g:1258:3: ( RULE_ID )
            // InternalModelText.g:1259:4: RULE_ID
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
    // InternalModelText.g:1270:1: rule__Element__AttAssignment_4_1 : ( ruleAttribute ) ;
    public final void rule__Element__AttAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1274:1: ( ( ruleAttribute ) )
            // InternalModelText.g:1275:2: ( ruleAttribute )
            {
            // InternalModelText.g:1275:2: ( ruleAttribute )
            // InternalModelText.g:1276:3: ruleAttribute
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


    // $ANTLR start "rule__Element__AttAssignment_4_2_1"
    // InternalModelText.g:1285:1: rule__Element__AttAssignment_4_2_1 : ( ruleAttribute ) ;
    public final void rule__Element__AttAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1289:1: ( ( ruleAttribute ) )
            // InternalModelText.g:1290:2: ( ruleAttribute )
            {
            // InternalModelText.g:1290:2: ( ruleAttribute )
            // InternalModelText.g:1291:3: ruleAttribute
            {
             before(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_2_1_0()); 

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
    // $ANTLR end "rule__Element__AttAssignment_4_2_1"


    // $ANTLR start "rule__Element__WordsAssignment_6_0"
    // InternalModelText.g:1300:1: rule__Element__WordsAssignment_6_0 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1304:1: ( ( ruleWord ) )
            // InternalModelText.g:1305:2: ( ruleWord )
            {
            // InternalModelText.g:1305:2: ( ruleWord )
            // InternalModelText.g:1306:3: ruleWord
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
    // InternalModelText.g:1315:1: rule__Element__WordsAssignment_6_1 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1319:1: ( ( ruleWord ) )
            // InternalModelText.g:1320:2: ( ruleWord )
            {
            // InternalModelText.g:1320:2: ( ruleWord )
            // InternalModelText.g:1321:3: ruleWord
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


    // $ANTLR start "rule__Attribute__NegationAssignment_1"
    // InternalModelText.g:1330:1: rule__Attribute__NegationAssignment_1 : ( ( 'not' ) ) ;
    public final void rule__Attribute__NegationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1334:1: ( ( ( 'not' ) ) )
            // InternalModelText.g:1335:2: ( ( 'not' ) )
            {
            // InternalModelText.g:1335:2: ( ( 'not' ) )
            // InternalModelText.g:1336:3: ( 'not' )
            {
             before(grammarAccess.getAttributeAccess().getNegationNotKeyword_1_0()); 
            // InternalModelText.g:1337:3: ( 'not' )
            // InternalModelText.g:1338:4: 'not'
            {
             before(grammarAccess.getAttributeAccess().getNegationNotKeyword_1_0()); 
            match(input,19,FOLLOW_2); 
             after(grammarAccess.getAttributeAccess().getNegationNotKeyword_1_0()); 

            }

             after(grammarAccess.getAttributeAccess().getNegationNotKeyword_1_0()); 

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
    // $ANTLR end "rule__Attribute__NegationAssignment_1"


    // $ANTLR start "rule__Attribute__AttAssignment_2"
    // InternalModelText.g:1349:1: rule__Attribute__AttAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__AttAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1353:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1354:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1354:2: ( ( RULE_ID ) )
            // InternalModelText.g:1355:3: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0()); 
            // InternalModelText.g:1356:3: ( RULE_ID )
            // InternalModelText.g:1357:4: RULE_ID
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
    // InternalModelText.g:1368:1: rule__Constant__ValueAssignment_1 : ( ruleEString ) ;
    public final void rule__Constant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1372:1: ( ( ruleEString ) )
            // InternalModelText.g:1373:2: ( ruleEString )
            {
            // InternalModelText.g:1373:2: ( ruleEString )
            // InternalModelText.g:1374:3: ruleEString
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
    // InternalModelText.g:1383:1: rule__Variable__RefAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__RefAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1387:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1388:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1388:2: ( ( RULE_ID ) )
            // InternalModelText.g:1389:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); 
            // InternalModelText.g:1390:3: ( RULE_ID )
            // InternalModelText.g:1391:4: RULE_ID
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
    // InternalModelText.g:1402:1: rule__Variable__IdAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__IdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelText.g:1406:1: ( ( ( RULE_ID ) ) )
            // InternalModelText.g:1407:2: ( ( RULE_ID ) )
            {
            // InternalModelText.g:1407:2: ( ( RULE_ID ) )
            // InternalModelText.g:1408:3: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); 
            // InternalModelText.g:1409:3: ( RULE_ID )
            // InternalModelText.g:1410:4: RULE_ID
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000000000E000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040032L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000004000L});

}