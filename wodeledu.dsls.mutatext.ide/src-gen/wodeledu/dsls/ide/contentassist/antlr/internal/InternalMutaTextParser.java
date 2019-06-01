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
import wodeledu.dsls.services.MutaTextGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMutaTextParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'%object'", "'%attName'", "'%oldValue'", "'%newValue'", "'%refName'", "'%fromObject'", "'%oldFromObject'", "'%srcRefName'", "'%toObject'", "'%oldToObject'", "'%firstRefName'", "'%firstObject'", "'%firstFromObject'", "'%firstToObject'", "'%secondRefName'", "'%secondObject'", "'%secondFromObject'", "'%secondToObject'", "'%firstAttName'", "'%firstValue'", "'%secondAttName'", "'%secondValue'", "'metamodel'", "'>'", "':'", "'/'", "'('", "')'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_ID=5;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMutaTextParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMutaTextParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMutaTextParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMutaText.g"; }


    	private MutaTextGrammarAccess grammarAccess;

    	public void setGrammarAccess(MutaTextGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleConfiguration"
    // InternalMutaText.g:53:1: entryRuleConfiguration : ruleConfiguration EOF ;
    public final void entryRuleConfiguration() throws RecognitionException {
        try {
            // InternalMutaText.g:54:1: ( ruleConfiguration EOF )
            // InternalMutaText.g:55:1: ruleConfiguration EOF
            {
             before(grammarAccess.getConfigurationRule()); 
            pushFollow(FOLLOW_1);
            ruleConfiguration();

            state._fsp--;

             after(grammarAccess.getConfigurationRule()); 
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
    // $ANTLR end "entryRuleConfiguration"


    // $ANTLR start "ruleConfiguration"
    // InternalMutaText.g:62:1: ruleConfiguration : ( ( rule__Configuration__Group__0 ) ) ;
    public final void ruleConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:66:2: ( ( ( rule__Configuration__Group__0 ) ) )
            // InternalMutaText.g:67:2: ( ( rule__Configuration__Group__0 ) )
            {
            // InternalMutaText.g:67:2: ( ( rule__Configuration__Group__0 ) )
            // InternalMutaText.g:68:3: ( rule__Configuration__Group__0 )
            {
             before(grammarAccess.getConfigurationAccess().getGroup()); 
            // InternalMutaText.g:69:3: ( rule__Configuration__Group__0 )
            // InternalMutaText.g:69:4: rule__Configuration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getGroup()); 

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
    // $ANTLR end "ruleConfiguration"


    // $ANTLR start "entryRuleOption"
    // InternalMutaText.g:78:1: entryRuleOption : ruleOption EOF ;
    public final void entryRuleOption() throws RecognitionException {
        try {
            // InternalMutaText.g:79:1: ( ruleOption EOF )
            // InternalMutaText.g:80:1: ruleOption EOF
            {
             before(grammarAccess.getOptionRule()); 
            pushFollow(FOLLOW_1);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getOptionRule()); 
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
    // $ANTLR end "entryRuleOption"


    // $ANTLR start "ruleOption"
    // InternalMutaText.g:87:1: ruleOption : ( ( rule__Option__Group__0 ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:91:2: ( ( ( rule__Option__Group__0 ) ) )
            // InternalMutaText.g:92:2: ( ( rule__Option__Group__0 ) )
            {
            // InternalMutaText.g:92:2: ( ( rule__Option__Group__0 ) )
            // InternalMutaText.g:93:3: ( rule__Option__Group__0 )
            {
             before(grammarAccess.getOptionAccess().getGroup()); 
            // InternalMutaText.g:94:3: ( rule__Option__Group__0 )
            // InternalMutaText.g:94:4: rule__Option__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Option__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getGroup()); 

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
    // $ANTLR end "ruleOption"


    // $ANTLR start "entryRuleText"
    // InternalMutaText.g:103:1: entryRuleText : ruleText EOF ;
    public final void entryRuleText() throws RecognitionException {
        try {
            // InternalMutaText.g:104:1: ( ruleText EOF )
            // InternalMutaText.g:105:1: ruleText EOF
            {
             before(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            ruleText();

            state._fsp--;

             after(grammarAccess.getTextRule()); 
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
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalMutaText.g:112:1: ruleText : ( ( rule__Text__Group__0 ) ) ;
    public final void ruleText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:116:2: ( ( ( rule__Text__Group__0 ) ) )
            // InternalMutaText.g:117:2: ( ( rule__Text__Group__0 ) )
            {
            // InternalMutaText.g:117:2: ( ( rule__Text__Group__0 ) )
            // InternalMutaText.g:118:3: ( rule__Text__Group__0 )
            {
             before(grammarAccess.getTextAccess().getGroup()); 
            // InternalMutaText.g:119:3: ( rule__Text__Group__0 )
            // InternalMutaText.g:119:4: rule__Text__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getGroup()); 

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
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleWord"
    // InternalMutaText.g:128:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // InternalMutaText.g:129:1: ( ruleWord EOF )
            // InternalMutaText.g:130:1: ruleWord EOF
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
    // InternalMutaText.g:137:1: ruleWord : ( ( rule__Word__Alternatives ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:141:2: ( ( ( rule__Word__Alternatives ) ) )
            // InternalMutaText.g:142:2: ( ( rule__Word__Alternatives ) )
            {
            // InternalMutaText.g:142:2: ( ( rule__Word__Alternatives ) )
            // InternalMutaText.g:143:3: ( rule__Word__Alternatives )
            {
             before(grammarAccess.getWordAccess().getAlternatives()); 
            // InternalMutaText.g:144:3: ( rule__Word__Alternatives )
            // InternalMutaText.g:144:4: rule__Word__Alternatives
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
    // InternalMutaText.g:153:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // InternalMutaText.g:154:1: ( ruleConstant EOF )
            // InternalMutaText.g:155:1: ruleConstant EOF
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
    // InternalMutaText.g:162:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:166:2: ( ( ( rule__Constant__Group__0 ) ) )
            // InternalMutaText.g:167:2: ( ( rule__Constant__Group__0 ) )
            {
            // InternalMutaText.g:167:2: ( ( rule__Constant__Group__0 ) )
            // InternalMutaText.g:168:3: ( rule__Constant__Group__0 )
            {
             before(grammarAccess.getConstantAccess().getGroup()); 
            // InternalMutaText.g:169:3: ( rule__Constant__Group__0 )
            // InternalMutaText.g:169:4: rule__Constant__Group__0
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
    // InternalMutaText.g:178:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // InternalMutaText.g:179:1: ( ruleVariable EOF )
            // InternalMutaText.g:180:1: ruleVariable EOF
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
    // InternalMutaText.g:187:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:191:2: ( ( ( rule__Variable__Group__0 ) ) )
            // InternalMutaText.g:192:2: ( ( rule__Variable__Group__0 ) )
            {
            // InternalMutaText.g:192:2: ( ( rule__Variable__Group__0 ) )
            // InternalMutaText.g:193:3: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // InternalMutaText.g:194:3: ( rule__Variable__Group__0 )
            // InternalMutaText.g:194:4: rule__Variable__Group__0
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
    // InternalMutaText.g:203:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalMutaText.g:204:1: ( ruleEString EOF )
            // InternalMutaText.g:205:1: ruleEString EOF
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
    // InternalMutaText.g:212:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:216:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalMutaText.g:217:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalMutaText.g:217:2: ( ( rule__EString__Alternatives ) )
            // InternalMutaText.g:218:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalMutaText.g:219:3: ( rule__EString__Alternatives )
            // InternalMutaText.g:219:4: rule__EString__Alternatives
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


    // $ANTLR start "ruleVariableType"
    // InternalMutaText.g:228:1: ruleVariableType : ( ( rule__VariableType__Alternatives ) ) ;
    public final void ruleVariableType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:232:1: ( ( ( rule__VariableType__Alternatives ) ) )
            // InternalMutaText.g:233:2: ( ( rule__VariableType__Alternatives ) )
            {
            // InternalMutaText.g:233:2: ( ( rule__VariableType__Alternatives ) )
            // InternalMutaText.g:234:3: ( rule__VariableType__Alternatives )
            {
             before(grammarAccess.getVariableTypeAccess().getAlternatives()); 
            // InternalMutaText.g:235:3: ( rule__VariableType__Alternatives )
            // InternalMutaText.g:235:4: rule__VariableType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__VariableType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getVariableTypeAccess().getAlternatives()); 

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
    // $ANTLR end "ruleVariableType"


    // $ANTLR start "rule__Word__Alternatives"
    // InternalMutaText.g:243:1: rule__Word__Alternatives : ( ( ruleConstant ) | ( ruleVariable ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:247:1: ( ( ruleConstant ) | ( ruleVariable ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( ((LA1_0>=RULE_STRING && LA1_0<=RULE_ID)) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=11 && LA1_0<=32)) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalMutaText.g:248:2: ( ruleConstant )
                    {
                    // InternalMutaText.g:248:2: ( ruleConstant )
                    // InternalMutaText.g:249:3: ruleConstant
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
                    // InternalMutaText.g:254:2: ( ruleVariable )
                    {
                    // InternalMutaText.g:254:2: ( ruleVariable )
                    // InternalMutaText.g:255:3: ruleVariable
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
    // InternalMutaText.g:264:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:268:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalMutaText.g:269:2: ( RULE_STRING )
                    {
                    // InternalMutaText.g:269:2: ( RULE_STRING )
                    // InternalMutaText.g:270:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMutaText.g:275:2: ( RULE_ID )
                    {
                    // InternalMutaText.g:275:2: ( RULE_ID )
                    // InternalMutaText.g:276:3: RULE_ID
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


    // $ANTLR start "rule__VariableType__Alternatives"
    // InternalMutaText.g:285:1: rule__VariableType__Alternatives : ( ( ( '%object' ) ) | ( ( '%attName' ) ) | ( ( '%oldValue' ) ) | ( ( '%newValue' ) ) | ( ( '%refName' ) ) | ( ( '%fromObject' ) ) | ( ( '%oldFromObject' ) ) | ( ( '%srcRefName' ) ) | ( ( '%toObject' ) ) | ( ( '%oldToObject' ) ) | ( ( '%firstRefName' ) ) | ( ( '%firstObject' ) ) | ( ( '%firstFromObject' ) ) | ( ( '%firstToObject' ) ) | ( ( '%secondRefName' ) ) | ( ( '%secondObject' ) ) | ( ( '%secondFromObject' ) ) | ( ( '%secondToObject' ) ) | ( ( '%firstAttName' ) ) | ( ( '%firstValue' ) ) | ( ( '%secondAttName' ) ) | ( ( '%secondValue' ) ) );
    public final void rule__VariableType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:289:1: ( ( ( '%object' ) ) | ( ( '%attName' ) ) | ( ( '%oldValue' ) ) | ( ( '%newValue' ) ) | ( ( '%refName' ) ) | ( ( '%fromObject' ) ) | ( ( '%oldFromObject' ) ) | ( ( '%srcRefName' ) ) | ( ( '%toObject' ) ) | ( ( '%oldToObject' ) ) | ( ( '%firstRefName' ) ) | ( ( '%firstObject' ) ) | ( ( '%firstFromObject' ) ) | ( ( '%firstToObject' ) ) | ( ( '%secondRefName' ) ) | ( ( '%secondObject' ) ) | ( ( '%secondFromObject' ) ) | ( ( '%secondToObject' ) ) | ( ( '%firstAttName' ) ) | ( ( '%firstValue' ) ) | ( ( '%secondAttName' ) ) | ( ( '%secondValue' ) ) )
            int alt3=22;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt3=1;
                }
                break;
            case 12:
                {
                alt3=2;
                }
                break;
            case 13:
                {
                alt3=3;
                }
                break;
            case 14:
                {
                alt3=4;
                }
                break;
            case 15:
                {
                alt3=5;
                }
                break;
            case 16:
                {
                alt3=6;
                }
                break;
            case 17:
                {
                alt3=7;
                }
                break;
            case 18:
                {
                alt3=8;
                }
                break;
            case 19:
                {
                alt3=9;
                }
                break;
            case 20:
                {
                alt3=10;
                }
                break;
            case 21:
                {
                alt3=11;
                }
                break;
            case 22:
                {
                alt3=12;
                }
                break;
            case 23:
                {
                alt3=13;
                }
                break;
            case 24:
                {
                alt3=14;
                }
                break;
            case 25:
                {
                alt3=15;
                }
                break;
            case 26:
                {
                alt3=16;
                }
                break;
            case 27:
                {
                alt3=17;
                }
                break;
            case 28:
                {
                alt3=18;
                }
                break;
            case 29:
                {
                alt3=19;
                }
                break;
            case 30:
                {
                alt3=20;
                }
                break;
            case 31:
                {
                alt3=21;
                }
                break;
            case 32:
                {
                alt3=22;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalMutaText.g:290:2: ( ( '%object' ) )
                    {
                    // InternalMutaText.g:290:2: ( ( '%object' ) )
                    // InternalMutaText.g:291:3: ( '%object' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0()); 
                    // InternalMutaText.g:292:3: ( '%object' )
                    // InternalMutaText.g:292:4: '%object'
                    {
                    match(input,11,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMutaText.g:296:2: ( ( '%attName' ) )
                    {
                    // InternalMutaText.g:296:2: ( ( '%attName' ) )
                    // InternalMutaText.g:297:3: ( '%attName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1()); 
                    // InternalMutaText.g:298:3: ( '%attName' )
                    // InternalMutaText.g:298:4: '%attName'
                    {
                    match(input,12,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMutaText.g:302:2: ( ( '%oldValue' ) )
                    {
                    // InternalMutaText.g:302:2: ( ( '%oldValue' ) )
                    // InternalMutaText.g:303:3: ( '%oldValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2()); 
                    // InternalMutaText.g:304:3: ( '%oldValue' )
                    // InternalMutaText.g:304:4: '%oldValue'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMutaText.g:308:2: ( ( '%newValue' ) )
                    {
                    // InternalMutaText.g:308:2: ( ( '%newValue' ) )
                    // InternalMutaText.g:309:3: ( '%newValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3()); 
                    // InternalMutaText.g:310:3: ( '%newValue' )
                    // InternalMutaText.g:310:4: '%newValue'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMutaText.g:314:2: ( ( '%refName' ) )
                    {
                    // InternalMutaText.g:314:2: ( ( '%refName' ) )
                    // InternalMutaText.g:315:3: ( '%refName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4()); 
                    // InternalMutaText.g:316:3: ( '%refName' )
                    // InternalMutaText.g:316:4: '%refName'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMutaText.g:320:2: ( ( '%fromObject' ) )
                    {
                    // InternalMutaText.g:320:2: ( ( '%fromObject' ) )
                    // InternalMutaText.g:321:3: ( '%fromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5()); 
                    // InternalMutaText.g:322:3: ( '%fromObject' )
                    // InternalMutaText.g:322:4: '%fromObject'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMutaText.g:326:2: ( ( '%oldFromObject' ) )
                    {
                    // InternalMutaText.g:326:2: ( ( '%oldFromObject' ) )
                    // InternalMutaText.g:327:3: ( '%oldFromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6()); 
                    // InternalMutaText.g:328:3: ( '%oldFromObject' )
                    // InternalMutaText.g:328:4: '%oldFromObject'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalMutaText.g:332:2: ( ( '%srcRefName' ) )
                    {
                    // InternalMutaText.g:332:2: ( ( '%srcRefName' ) )
                    // InternalMutaText.g:333:3: ( '%srcRefName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7()); 
                    // InternalMutaText.g:334:3: ( '%srcRefName' )
                    // InternalMutaText.g:334:4: '%srcRefName'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalMutaText.g:338:2: ( ( '%toObject' ) )
                    {
                    // InternalMutaText.g:338:2: ( ( '%toObject' ) )
                    // InternalMutaText.g:339:3: ( '%toObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8()); 
                    // InternalMutaText.g:340:3: ( '%toObject' )
                    // InternalMutaText.g:340:4: '%toObject'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalMutaText.g:344:2: ( ( '%oldToObject' ) )
                    {
                    // InternalMutaText.g:344:2: ( ( '%oldToObject' ) )
                    // InternalMutaText.g:345:3: ( '%oldToObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9()); 
                    // InternalMutaText.g:346:3: ( '%oldToObject' )
                    // InternalMutaText.g:346:4: '%oldToObject'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalMutaText.g:350:2: ( ( '%firstRefName' ) )
                    {
                    // InternalMutaText.g:350:2: ( ( '%firstRefName' ) )
                    // InternalMutaText.g:351:3: ( '%firstRefName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10()); 
                    // InternalMutaText.g:352:3: ( '%firstRefName' )
                    // InternalMutaText.g:352:4: '%firstRefName'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalMutaText.g:356:2: ( ( '%firstObject' ) )
                    {
                    // InternalMutaText.g:356:2: ( ( '%firstObject' ) )
                    // InternalMutaText.g:357:3: ( '%firstObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11()); 
                    // InternalMutaText.g:358:3: ( '%firstObject' )
                    // InternalMutaText.g:358:4: '%firstObject'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalMutaText.g:362:2: ( ( '%firstFromObject' ) )
                    {
                    // InternalMutaText.g:362:2: ( ( '%firstFromObject' ) )
                    // InternalMutaText.g:363:3: ( '%firstFromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12()); 
                    // InternalMutaText.g:364:3: ( '%firstFromObject' )
                    // InternalMutaText.g:364:4: '%firstFromObject'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalMutaText.g:368:2: ( ( '%firstToObject' ) )
                    {
                    // InternalMutaText.g:368:2: ( ( '%firstToObject' ) )
                    // InternalMutaText.g:369:3: ( '%firstToObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13()); 
                    // InternalMutaText.g:370:3: ( '%firstToObject' )
                    // InternalMutaText.g:370:4: '%firstToObject'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // InternalMutaText.g:374:2: ( ( '%secondRefName' ) )
                    {
                    // InternalMutaText.g:374:2: ( ( '%secondRefName' ) )
                    // InternalMutaText.g:375:3: ( '%secondRefName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14()); 
                    // InternalMutaText.g:376:3: ( '%secondRefName' )
                    // InternalMutaText.g:376:4: '%secondRefName'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // InternalMutaText.g:380:2: ( ( '%secondObject' ) )
                    {
                    // InternalMutaText.g:380:2: ( ( '%secondObject' ) )
                    // InternalMutaText.g:381:3: ( '%secondObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15()); 
                    // InternalMutaText.g:382:3: ( '%secondObject' )
                    // InternalMutaText.g:382:4: '%secondObject'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // InternalMutaText.g:386:2: ( ( '%secondFromObject' ) )
                    {
                    // InternalMutaText.g:386:2: ( ( '%secondFromObject' ) )
                    // InternalMutaText.g:387:3: ( '%secondFromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16()); 
                    // InternalMutaText.g:388:3: ( '%secondFromObject' )
                    // InternalMutaText.g:388:4: '%secondFromObject'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // InternalMutaText.g:392:2: ( ( '%secondToObject' ) )
                    {
                    // InternalMutaText.g:392:2: ( ( '%secondToObject' ) )
                    // InternalMutaText.g:393:3: ( '%secondToObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17()); 
                    // InternalMutaText.g:394:3: ( '%secondToObject' )
                    // InternalMutaText.g:394:4: '%secondToObject'
                    {
                    match(input,28,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // InternalMutaText.g:398:2: ( ( '%firstAttName' ) )
                    {
                    // InternalMutaText.g:398:2: ( ( '%firstAttName' ) )
                    // InternalMutaText.g:399:3: ( '%firstAttName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18()); 
                    // InternalMutaText.g:400:3: ( '%firstAttName' )
                    // InternalMutaText.g:400:4: '%firstAttName'
                    {
                    match(input,29,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // InternalMutaText.g:404:2: ( ( '%firstValue' ) )
                    {
                    // InternalMutaText.g:404:2: ( ( '%firstValue' ) )
                    // InternalMutaText.g:405:3: ( '%firstValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19()); 
                    // InternalMutaText.g:406:3: ( '%firstValue' )
                    // InternalMutaText.g:406:4: '%firstValue'
                    {
                    match(input,30,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // InternalMutaText.g:410:2: ( ( '%secondAttName' ) )
                    {
                    // InternalMutaText.g:410:2: ( ( '%secondAttName' ) )
                    // InternalMutaText.g:411:3: ( '%secondAttName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20()); 
                    // InternalMutaText.g:412:3: ( '%secondAttName' )
                    // InternalMutaText.g:412:4: '%secondAttName'
                    {
                    match(input,31,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // InternalMutaText.g:416:2: ( ( '%secondValue' ) )
                    {
                    // InternalMutaText.g:416:2: ( ( '%secondValue' ) )
                    // InternalMutaText.g:417:3: ( '%secondValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondValueEnumLiteralDeclaration_21()); 
                    // InternalMutaText.g:418:3: ( '%secondValue' )
                    // InternalMutaText.g:418:4: '%secondValue'
                    {
                    match(input,32,FOLLOW_2); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondValueEnumLiteralDeclaration_21()); 

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
    // $ANTLR end "rule__VariableType__Alternatives"


    // $ANTLR start "rule__Configuration__Group__0"
    // InternalMutaText.g:426:1: rule__Configuration__Group__0 : rule__Configuration__Group__0__Impl rule__Configuration__Group__1 ;
    public final void rule__Configuration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:430:1: ( rule__Configuration__Group__0__Impl rule__Configuration__Group__1 )
            // InternalMutaText.g:431:2: rule__Configuration__Group__0__Impl rule__Configuration__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Configuration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__1();

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
    // $ANTLR end "rule__Configuration__Group__0"


    // $ANTLR start "rule__Configuration__Group__0__Impl"
    // InternalMutaText.g:438:1: rule__Configuration__Group__0__Impl : ( () ) ;
    public final void rule__Configuration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:442:1: ( ( () ) )
            // InternalMutaText.g:443:1: ( () )
            {
            // InternalMutaText.g:443:1: ( () )
            // InternalMutaText.g:444:2: ()
            {
             before(grammarAccess.getConfigurationAccess().getConfigurationAction_0()); 
            // InternalMutaText.g:445:2: ()
            // InternalMutaText.g:445:3: 
            {
            }

             after(grammarAccess.getConfigurationAccess().getConfigurationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Configuration__Group__0__Impl"


    // $ANTLR start "rule__Configuration__Group__1"
    // InternalMutaText.g:453:1: rule__Configuration__Group__1 : rule__Configuration__Group__1__Impl rule__Configuration__Group__2 ;
    public final void rule__Configuration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:457:1: ( rule__Configuration__Group__1__Impl rule__Configuration__Group__2 )
            // InternalMutaText.g:458:2: rule__Configuration__Group__1__Impl rule__Configuration__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Configuration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__2();

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
    // $ANTLR end "rule__Configuration__Group__1"


    // $ANTLR start "rule__Configuration__Group__1__Impl"
    // InternalMutaText.g:465:1: rule__Configuration__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__Configuration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:469:1: ( ( 'metamodel' ) )
            // InternalMutaText.g:470:1: ( 'metamodel' )
            {
            // InternalMutaText.g:470:1: ( 'metamodel' )
            // InternalMutaText.g:471:2: 'metamodel'
            {
             before(grammarAccess.getConfigurationAccess().getMetamodelKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getConfigurationAccess().getMetamodelKeyword_1()); 

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
    // $ANTLR end "rule__Configuration__Group__1__Impl"


    // $ANTLR start "rule__Configuration__Group__2"
    // InternalMutaText.g:480:1: rule__Configuration__Group__2 : rule__Configuration__Group__2__Impl rule__Configuration__Group__3 ;
    public final void rule__Configuration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:484:1: ( rule__Configuration__Group__2__Impl rule__Configuration__Group__3 )
            // InternalMutaText.g:485:2: rule__Configuration__Group__2__Impl rule__Configuration__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Configuration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group__3();

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
    // $ANTLR end "rule__Configuration__Group__2"


    // $ANTLR start "rule__Configuration__Group__2__Impl"
    // InternalMutaText.g:492:1: rule__Configuration__Group__2__Impl : ( ( rule__Configuration__MetamodelAssignment_2 ) ) ;
    public final void rule__Configuration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:496:1: ( ( ( rule__Configuration__MetamodelAssignment_2 ) ) )
            // InternalMutaText.g:497:1: ( ( rule__Configuration__MetamodelAssignment_2 ) )
            {
            // InternalMutaText.g:497:1: ( ( rule__Configuration__MetamodelAssignment_2 ) )
            // InternalMutaText.g:498:2: ( rule__Configuration__MetamodelAssignment_2 )
            {
             before(grammarAccess.getConfigurationAccess().getMetamodelAssignment_2()); 
            // InternalMutaText.g:499:2: ( rule__Configuration__MetamodelAssignment_2 )
            // InternalMutaText.g:499:3: rule__Configuration__MetamodelAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__MetamodelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getMetamodelAssignment_2()); 

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
    // $ANTLR end "rule__Configuration__Group__2__Impl"


    // $ANTLR start "rule__Configuration__Group__3"
    // InternalMutaText.g:507:1: rule__Configuration__Group__3 : rule__Configuration__Group__3__Impl ;
    public final void rule__Configuration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:511:1: ( rule__Configuration__Group__3__Impl )
            // InternalMutaText.g:512:2: rule__Configuration__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__Group__3__Impl();

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
    // $ANTLR end "rule__Configuration__Group__3"


    // $ANTLR start "rule__Configuration__Group__3__Impl"
    // InternalMutaText.g:518:1: rule__Configuration__Group__3__Impl : ( ( rule__Configuration__Group_3__0 )? ) ;
    public final void rule__Configuration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:522:1: ( ( ( rule__Configuration__Group_3__0 )? ) )
            // InternalMutaText.g:523:1: ( ( rule__Configuration__Group_3__0 )? )
            {
            // InternalMutaText.g:523:1: ( ( rule__Configuration__Group_3__0 )? )
            // InternalMutaText.g:524:2: ( rule__Configuration__Group_3__0 )?
            {
             before(grammarAccess.getConfigurationAccess().getGroup_3()); 
            // InternalMutaText.g:525:2: ( rule__Configuration__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==34) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMutaText.g:525:3: rule__Configuration__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Configuration__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConfigurationAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Configuration__Group__3__Impl"


    // $ANTLR start "rule__Configuration__Group_3__0"
    // InternalMutaText.g:534:1: rule__Configuration__Group_3__0 : rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1 ;
    public final void rule__Configuration__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:538:1: ( rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1 )
            // InternalMutaText.g:539:2: rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Configuration__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Configuration__Group_3__1();

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
    // $ANTLR end "rule__Configuration__Group_3__0"


    // $ANTLR start "rule__Configuration__Group_3__0__Impl"
    // InternalMutaText.g:546:1: rule__Configuration__Group_3__0__Impl : ( ( rule__Configuration__OptionsAssignment_3_0 ) ) ;
    public final void rule__Configuration__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:550:1: ( ( ( rule__Configuration__OptionsAssignment_3_0 ) ) )
            // InternalMutaText.g:551:1: ( ( rule__Configuration__OptionsAssignment_3_0 ) )
            {
            // InternalMutaText.g:551:1: ( ( rule__Configuration__OptionsAssignment_3_0 ) )
            // InternalMutaText.g:552:2: ( rule__Configuration__OptionsAssignment_3_0 )
            {
             before(grammarAccess.getConfigurationAccess().getOptionsAssignment_3_0()); 
            // InternalMutaText.g:553:2: ( rule__Configuration__OptionsAssignment_3_0 )
            // InternalMutaText.g:553:3: rule__Configuration__OptionsAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__OptionsAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getConfigurationAccess().getOptionsAssignment_3_0()); 

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
    // $ANTLR end "rule__Configuration__Group_3__0__Impl"


    // $ANTLR start "rule__Configuration__Group_3__1"
    // InternalMutaText.g:561:1: rule__Configuration__Group_3__1 : rule__Configuration__Group_3__1__Impl ;
    public final void rule__Configuration__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:565:1: ( rule__Configuration__Group_3__1__Impl )
            // InternalMutaText.g:566:2: rule__Configuration__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Configuration__Group_3__1__Impl();

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
    // $ANTLR end "rule__Configuration__Group_3__1"


    // $ANTLR start "rule__Configuration__Group_3__1__Impl"
    // InternalMutaText.g:572:1: rule__Configuration__Group_3__1__Impl : ( ( rule__Configuration__OptionsAssignment_3_1 )* ) ;
    public final void rule__Configuration__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:576:1: ( ( ( rule__Configuration__OptionsAssignment_3_1 )* ) )
            // InternalMutaText.g:577:1: ( ( rule__Configuration__OptionsAssignment_3_1 )* )
            {
            // InternalMutaText.g:577:1: ( ( rule__Configuration__OptionsAssignment_3_1 )* )
            // InternalMutaText.g:578:2: ( rule__Configuration__OptionsAssignment_3_1 )*
            {
             before(grammarAccess.getConfigurationAccess().getOptionsAssignment_3_1()); 
            // InternalMutaText.g:579:2: ( rule__Configuration__OptionsAssignment_3_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==34) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMutaText.g:579:3: rule__Configuration__OptionsAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Configuration__OptionsAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getConfigurationAccess().getOptionsAssignment_3_1()); 

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
    // $ANTLR end "rule__Configuration__Group_3__1__Impl"


    // $ANTLR start "rule__Option__Group__0"
    // InternalMutaText.g:588:1: rule__Option__Group__0 : rule__Option__Group__0__Impl rule__Option__Group__1 ;
    public final void rule__Option__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:592:1: ( rule__Option__Group__0__Impl rule__Option__Group__1 )
            // InternalMutaText.g:593:2: rule__Option__Group__0__Impl rule__Option__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Option__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__1();

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
    // $ANTLR end "rule__Option__Group__0"


    // $ANTLR start "rule__Option__Group__0__Impl"
    // InternalMutaText.g:600:1: rule__Option__Group__0__Impl : ( () ) ;
    public final void rule__Option__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:604:1: ( ( () ) )
            // InternalMutaText.g:605:1: ( () )
            {
            // InternalMutaText.g:605:1: ( () )
            // InternalMutaText.g:606:2: ()
            {
             before(grammarAccess.getOptionAccess().getOptionAction_0()); 
            // InternalMutaText.g:607:2: ()
            // InternalMutaText.g:607:3: 
            {
            }

             after(grammarAccess.getOptionAccess().getOptionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Option__Group__0__Impl"


    // $ANTLR start "rule__Option__Group__1"
    // InternalMutaText.g:615:1: rule__Option__Group__1 : rule__Option__Group__1__Impl rule__Option__Group__2 ;
    public final void rule__Option__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:619:1: ( rule__Option__Group__1__Impl rule__Option__Group__2 )
            // InternalMutaText.g:620:2: rule__Option__Group__1__Impl rule__Option__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Option__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__2();

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
    // $ANTLR end "rule__Option__Group__1"


    // $ANTLR start "rule__Option__Group__1__Impl"
    // InternalMutaText.g:627:1: rule__Option__Group__1__Impl : ( '>' ) ;
    public final void rule__Option__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:631:1: ( ( '>' ) )
            // InternalMutaText.g:632:1: ( '>' )
            {
            // InternalMutaText.g:632:1: ( '>' )
            // InternalMutaText.g:633:2: '>'
            {
             before(grammarAccess.getOptionAccess().getGreaterThanSignKeyword_1()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getGreaterThanSignKeyword_1()); 

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
    // $ANTLR end "rule__Option__Group__1__Impl"


    // $ANTLR start "rule__Option__Group__2"
    // InternalMutaText.g:642:1: rule__Option__Group__2 : rule__Option__Group__2__Impl rule__Option__Group__3 ;
    public final void rule__Option__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:646:1: ( rule__Option__Group__2__Impl rule__Option__Group__3 )
            // InternalMutaText.g:647:2: rule__Option__Group__2__Impl rule__Option__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Option__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__3();

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
    // $ANTLR end "rule__Option__Group__2"


    // $ANTLR start "rule__Option__Group__2__Impl"
    // InternalMutaText.g:654:1: rule__Option__Group__2__Impl : ( ( rule__Option__TypeAssignment_2 ) ) ;
    public final void rule__Option__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:658:1: ( ( ( rule__Option__TypeAssignment_2 ) ) )
            // InternalMutaText.g:659:1: ( ( rule__Option__TypeAssignment_2 ) )
            {
            // InternalMutaText.g:659:1: ( ( rule__Option__TypeAssignment_2 ) )
            // InternalMutaText.g:660:2: ( rule__Option__TypeAssignment_2 )
            {
             before(grammarAccess.getOptionAccess().getTypeAssignment_2()); 
            // InternalMutaText.g:661:2: ( rule__Option__TypeAssignment_2 )
            // InternalMutaText.g:661:3: rule__Option__TypeAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Option__TypeAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getTypeAssignment_2()); 

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
    // $ANTLR end "rule__Option__Group__2__Impl"


    // $ANTLR start "rule__Option__Group__3"
    // InternalMutaText.g:669:1: rule__Option__Group__3 : rule__Option__Group__3__Impl rule__Option__Group__4 ;
    public final void rule__Option__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:673:1: ( rule__Option__Group__3__Impl rule__Option__Group__4 )
            // InternalMutaText.g:674:2: rule__Option__Group__3__Impl rule__Option__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Option__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__4();

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
    // $ANTLR end "rule__Option__Group__3"


    // $ANTLR start "rule__Option__Group__3__Impl"
    // InternalMutaText.g:681:1: rule__Option__Group__3__Impl : ( ( rule__Option__Group_3__0 )? ) ;
    public final void rule__Option__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:685:1: ( ( ( rule__Option__Group_3__0 )? ) )
            // InternalMutaText.g:686:1: ( ( rule__Option__Group_3__0 )? )
            {
            // InternalMutaText.g:686:1: ( ( rule__Option__Group_3__0 )? )
            // InternalMutaText.g:687:2: ( rule__Option__Group_3__0 )?
            {
             before(grammarAccess.getOptionAccess().getGroup_3()); 
            // InternalMutaText.g:688:2: ( rule__Option__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==37) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMutaText.g:688:3: rule__Option__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Option__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getOptionAccess().getGroup_3()); 

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
    // $ANTLR end "rule__Option__Group__3__Impl"


    // $ANTLR start "rule__Option__Group__4"
    // InternalMutaText.g:696:1: rule__Option__Group__4 : rule__Option__Group__4__Impl rule__Option__Group__5 ;
    public final void rule__Option__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:700:1: ( rule__Option__Group__4__Impl rule__Option__Group__5 )
            // InternalMutaText.g:701:2: rule__Option__Group__4__Impl rule__Option__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Option__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__5();

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
    // $ANTLR end "rule__Option__Group__4"


    // $ANTLR start "rule__Option__Group__4__Impl"
    // InternalMutaText.g:708:1: rule__Option__Group__4__Impl : ( ':' ) ;
    public final void rule__Option__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:712:1: ( ( ':' ) )
            // InternalMutaText.g:713:1: ( ':' )
            {
            // InternalMutaText.g:713:1: ( ':' )
            // InternalMutaText.g:714:2: ':'
            {
             before(grammarAccess.getOptionAccess().getColonKeyword_4()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getColonKeyword_4()); 

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
    // $ANTLR end "rule__Option__Group__4__Impl"


    // $ANTLR start "rule__Option__Group__5"
    // InternalMutaText.g:723:1: rule__Option__Group__5 : rule__Option__Group__5__Impl rule__Option__Group__6 ;
    public final void rule__Option__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:727:1: ( rule__Option__Group__5__Impl rule__Option__Group__6 )
            // InternalMutaText.g:728:2: rule__Option__Group__5__Impl rule__Option__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Option__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__6();

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
    // $ANTLR end "rule__Option__Group__5"


    // $ANTLR start "rule__Option__Group__5__Impl"
    // InternalMutaText.g:735:1: rule__Option__Group__5__Impl : ( ( rule__Option__ValidAssignment_5 ) ) ;
    public final void rule__Option__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:739:1: ( ( ( rule__Option__ValidAssignment_5 ) ) )
            // InternalMutaText.g:740:1: ( ( rule__Option__ValidAssignment_5 ) )
            {
            // InternalMutaText.g:740:1: ( ( rule__Option__ValidAssignment_5 ) )
            // InternalMutaText.g:741:2: ( rule__Option__ValidAssignment_5 )
            {
             before(grammarAccess.getOptionAccess().getValidAssignment_5()); 
            // InternalMutaText.g:742:2: ( rule__Option__ValidAssignment_5 )
            // InternalMutaText.g:742:3: rule__Option__ValidAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Option__ValidAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getValidAssignment_5()); 

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
    // $ANTLR end "rule__Option__Group__5__Impl"


    // $ANTLR start "rule__Option__Group__6"
    // InternalMutaText.g:750:1: rule__Option__Group__6 : rule__Option__Group__6__Impl rule__Option__Group__7 ;
    public final void rule__Option__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:754:1: ( rule__Option__Group__6__Impl rule__Option__Group__7 )
            // InternalMutaText.g:755:2: rule__Option__Group__6__Impl rule__Option__Group__7
            {
            pushFollow(FOLLOW_8);
            rule__Option__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group__7();

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
    // $ANTLR end "rule__Option__Group__6"


    // $ANTLR start "rule__Option__Group__6__Impl"
    // InternalMutaText.g:762:1: rule__Option__Group__6__Impl : ( '/' ) ;
    public final void rule__Option__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:766:1: ( ( '/' ) )
            // InternalMutaText.g:767:1: ( '/' )
            {
            // InternalMutaText.g:767:1: ( '/' )
            // InternalMutaText.g:768:2: '/'
            {
             before(grammarAccess.getOptionAccess().getSolidusKeyword_6()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getSolidusKeyword_6()); 

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
    // $ANTLR end "rule__Option__Group__6__Impl"


    // $ANTLR start "rule__Option__Group__7"
    // InternalMutaText.g:777:1: rule__Option__Group__7 : rule__Option__Group__7__Impl ;
    public final void rule__Option__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:781:1: ( rule__Option__Group__7__Impl )
            // InternalMutaText.g:782:2: rule__Option__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Option__Group__7__Impl();

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
    // $ANTLR end "rule__Option__Group__7"


    // $ANTLR start "rule__Option__Group__7__Impl"
    // InternalMutaText.g:788:1: rule__Option__Group__7__Impl : ( ( rule__Option__InvalidAssignment_7 ) ) ;
    public final void rule__Option__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:792:1: ( ( ( rule__Option__InvalidAssignment_7 ) ) )
            // InternalMutaText.g:793:1: ( ( rule__Option__InvalidAssignment_7 ) )
            {
            // InternalMutaText.g:793:1: ( ( rule__Option__InvalidAssignment_7 ) )
            // InternalMutaText.g:794:2: ( rule__Option__InvalidAssignment_7 )
            {
             before(grammarAccess.getOptionAccess().getInvalidAssignment_7()); 
            // InternalMutaText.g:795:2: ( rule__Option__InvalidAssignment_7 )
            // InternalMutaText.g:795:3: rule__Option__InvalidAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__Option__InvalidAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getInvalidAssignment_7()); 

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
    // $ANTLR end "rule__Option__Group__7__Impl"


    // $ANTLR start "rule__Option__Group_3__0"
    // InternalMutaText.g:804:1: rule__Option__Group_3__0 : rule__Option__Group_3__0__Impl rule__Option__Group_3__1 ;
    public final void rule__Option__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:808:1: ( rule__Option__Group_3__0__Impl rule__Option__Group_3__1 )
            // InternalMutaText.g:809:2: rule__Option__Group_3__0__Impl rule__Option__Group_3__1
            {
            pushFollow(FOLLOW_4);
            rule__Option__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group_3__1();

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
    // $ANTLR end "rule__Option__Group_3__0"


    // $ANTLR start "rule__Option__Group_3__0__Impl"
    // InternalMutaText.g:816:1: rule__Option__Group_3__0__Impl : ( '(' ) ;
    public final void rule__Option__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:820:1: ( ( '(' ) )
            // InternalMutaText.g:821:1: ( '(' )
            {
            // InternalMutaText.g:821:1: ( '(' )
            // InternalMutaText.g:822:2: '('
            {
             before(grammarAccess.getOptionAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getLeftParenthesisKeyword_3_0()); 

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
    // $ANTLR end "rule__Option__Group_3__0__Impl"


    // $ANTLR start "rule__Option__Group_3__1"
    // InternalMutaText.g:831:1: rule__Option__Group_3__1 : rule__Option__Group_3__1__Impl rule__Option__Group_3__2 ;
    public final void rule__Option__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:835:1: ( rule__Option__Group_3__1__Impl rule__Option__Group_3__2 )
            // InternalMutaText.g:836:2: rule__Option__Group_3__1__Impl rule__Option__Group_3__2
            {
            pushFollow(FOLLOW_10);
            rule__Option__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Option__Group_3__2();

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
    // $ANTLR end "rule__Option__Group_3__1"


    // $ANTLR start "rule__Option__Group_3__1__Impl"
    // InternalMutaText.g:843:1: rule__Option__Group_3__1__Impl : ( ( rule__Option__ObjectAssignment_3_1 ) ) ;
    public final void rule__Option__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:847:1: ( ( ( rule__Option__ObjectAssignment_3_1 ) ) )
            // InternalMutaText.g:848:1: ( ( rule__Option__ObjectAssignment_3_1 ) )
            {
            // InternalMutaText.g:848:1: ( ( rule__Option__ObjectAssignment_3_1 ) )
            // InternalMutaText.g:849:2: ( rule__Option__ObjectAssignment_3_1 )
            {
             before(grammarAccess.getOptionAccess().getObjectAssignment_3_1()); 
            // InternalMutaText.g:850:2: ( rule__Option__ObjectAssignment_3_1 )
            // InternalMutaText.g:850:3: rule__Option__ObjectAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Option__ObjectAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getOptionAccess().getObjectAssignment_3_1()); 

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
    // $ANTLR end "rule__Option__Group_3__1__Impl"


    // $ANTLR start "rule__Option__Group_3__2"
    // InternalMutaText.g:858:1: rule__Option__Group_3__2 : rule__Option__Group_3__2__Impl ;
    public final void rule__Option__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:862:1: ( rule__Option__Group_3__2__Impl )
            // InternalMutaText.g:863:2: rule__Option__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Option__Group_3__2__Impl();

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
    // $ANTLR end "rule__Option__Group_3__2"


    // $ANTLR start "rule__Option__Group_3__2__Impl"
    // InternalMutaText.g:869:1: rule__Option__Group_3__2__Impl : ( ')' ) ;
    public final void rule__Option__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:873:1: ( ( ')' ) )
            // InternalMutaText.g:874:1: ( ')' )
            {
            // InternalMutaText.g:874:1: ( ')' )
            // InternalMutaText.g:875:2: ')'
            {
             before(grammarAccess.getOptionAccess().getRightParenthesisKeyword_3_2()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getOptionAccess().getRightParenthesisKeyword_3_2()); 

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
    // $ANTLR end "rule__Option__Group_3__2__Impl"


    // $ANTLR start "rule__Text__Group__0"
    // InternalMutaText.g:885:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:889:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // InternalMutaText.g:890:2: rule__Text__Group__0__Impl rule__Text__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Text__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group__1();

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
    // $ANTLR end "rule__Text__Group__0"


    // $ANTLR start "rule__Text__Group__0__Impl"
    // InternalMutaText.g:897:1: rule__Text__Group__0__Impl : ( () ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:901:1: ( ( () ) )
            // InternalMutaText.g:902:1: ( () )
            {
            // InternalMutaText.g:902:1: ( () )
            // InternalMutaText.g:903:2: ()
            {
             before(grammarAccess.getTextAccess().getTextAction_0()); 
            // InternalMutaText.g:904:2: ()
            // InternalMutaText.g:904:3: 
            {
            }

             after(grammarAccess.getTextAccess().getTextAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Text__Group__0__Impl"


    // $ANTLR start "rule__Text__Group__1"
    // InternalMutaText.g:912:1: rule__Text__Group__1 : rule__Text__Group__1__Impl ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:916:1: ( rule__Text__Group__1__Impl )
            // InternalMutaText.g:917:2: rule__Text__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group__1__Impl();

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
    // $ANTLR end "rule__Text__Group__1"


    // $ANTLR start "rule__Text__Group__1__Impl"
    // InternalMutaText.g:923:1: rule__Text__Group__1__Impl : ( ( rule__Text__Group_1__0 )? ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:927:1: ( ( ( rule__Text__Group_1__0 )? ) )
            // InternalMutaText.g:928:1: ( ( rule__Text__Group_1__0 )? )
            {
            // InternalMutaText.g:928:1: ( ( rule__Text__Group_1__0 )? )
            // InternalMutaText.g:929:2: ( rule__Text__Group_1__0 )?
            {
             before(grammarAccess.getTextAccess().getGroup_1()); 
            // InternalMutaText.g:930:2: ( rule__Text__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||(LA7_0>=11 && LA7_0<=32)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMutaText.g:930:3: rule__Text__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Text__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Text__Group__1__Impl"


    // $ANTLR start "rule__Text__Group_1__0"
    // InternalMutaText.g:939:1: rule__Text__Group_1__0 : rule__Text__Group_1__0__Impl rule__Text__Group_1__1 ;
    public final void rule__Text__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:943:1: ( rule__Text__Group_1__0__Impl rule__Text__Group_1__1 )
            // InternalMutaText.g:944:2: rule__Text__Group_1__0__Impl rule__Text__Group_1__1
            {
            pushFollow(FOLLOW_8);
            rule__Text__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Text__Group_1__1();

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
    // $ANTLR end "rule__Text__Group_1__0"


    // $ANTLR start "rule__Text__Group_1__0__Impl"
    // InternalMutaText.g:951:1: rule__Text__Group_1__0__Impl : ( ( rule__Text__WordsAssignment_1_0 ) ) ;
    public final void rule__Text__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:955:1: ( ( ( rule__Text__WordsAssignment_1_0 ) ) )
            // InternalMutaText.g:956:1: ( ( rule__Text__WordsAssignment_1_0 ) )
            {
            // InternalMutaText.g:956:1: ( ( rule__Text__WordsAssignment_1_0 ) )
            // InternalMutaText.g:957:2: ( rule__Text__WordsAssignment_1_0 )
            {
             before(grammarAccess.getTextAccess().getWordsAssignment_1_0()); 
            // InternalMutaText.g:958:2: ( rule__Text__WordsAssignment_1_0 )
            // InternalMutaText.g:958:3: rule__Text__WordsAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Text__WordsAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTextAccess().getWordsAssignment_1_0()); 

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
    // $ANTLR end "rule__Text__Group_1__0__Impl"


    // $ANTLR start "rule__Text__Group_1__1"
    // InternalMutaText.g:966:1: rule__Text__Group_1__1 : rule__Text__Group_1__1__Impl ;
    public final void rule__Text__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:970:1: ( rule__Text__Group_1__1__Impl )
            // InternalMutaText.g:971:2: rule__Text__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Text__Group_1__1__Impl();

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
    // $ANTLR end "rule__Text__Group_1__1"


    // $ANTLR start "rule__Text__Group_1__1__Impl"
    // InternalMutaText.g:977:1: rule__Text__Group_1__1__Impl : ( ( rule__Text__WordsAssignment_1_1 )* ) ;
    public final void rule__Text__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:981:1: ( ( ( rule__Text__WordsAssignment_1_1 )* ) )
            // InternalMutaText.g:982:1: ( ( rule__Text__WordsAssignment_1_1 )* )
            {
            // InternalMutaText.g:982:1: ( ( rule__Text__WordsAssignment_1_1 )* )
            // InternalMutaText.g:983:2: ( rule__Text__WordsAssignment_1_1 )*
            {
             before(grammarAccess.getTextAccess().getWordsAssignment_1_1()); 
            // InternalMutaText.g:984:2: ( rule__Text__WordsAssignment_1_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)||(LA8_0>=11 && LA8_0<=32)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMutaText.g:984:3: rule__Text__WordsAssignment_1_1
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Text__WordsAssignment_1_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getTextAccess().getWordsAssignment_1_1()); 

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
    // $ANTLR end "rule__Text__Group_1__1__Impl"


    // $ANTLR start "rule__Constant__Group__0"
    // InternalMutaText.g:993:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:997:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // InternalMutaText.g:998:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
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
    // InternalMutaText.g:1005:1: rule__Constant__Group__0__Impl : ( () ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1009:1: ( ( () ) )
            // InternalMutaText.g:1010:1: ( () )
            {
            // InternalMutaText.g:1010:1: ( () )
            // InternalMutaText.g:1011:2: ()
            {
             before(grammarAccess.getConstantAccess().getConstantAction_0()); 
            // InternalMutaText.g:1012:2: ()
            // InternalMutaText.g:1012:3: 
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
    // InternalMutaText.g:1020:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1024:1: ( rule__Constant__Group__1__Impl )
            // InternalMutaText.g:1025:2: rule__Constant__Group__1__Impl
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
    // InternalMutaText.g:1031:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__ValueAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1035:1: ( ( ( rule__Constant__ValueAssignment_1 ) ) )
            // InternalMutaText.g:1036:1: ( ( rule__Constant__ValueAssignment_1 ) )
            {
            // InternalMutaText.g:1036:1: ( ( rule__Constant__ValueAssignment_1 ) )
            // InternalMutaText.g:1037:2: ( rule__Constant__ValueAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1()); 
            // InternalMutaText.g:1038:2: ( rule__Constant__ValueAssignment_1 )
            // InternalMutaText.g:1038:3: rule__Constant__ValueAssignment_1
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
    // InternalMutaText.g:1047:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1051:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // InternalMutaText.g:1052:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
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
    // InternalMutaText.g:1059:1: rule__Variable__Group__0__Impl : ( () ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1063:1: ( ( () ) )
            // InternalMutaText.g:1064:1: ( () )
            {
            // InternalMutaText.g:1064:1: ( () )
            // InternalMutaText.g:1065:2: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0()); 
            // InternalMutaText.g:1066:2: ()
            // InternalMutaText.g:1066:3: 
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
    // InternalMutaText.g:1074:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1078:1: ( rule__Variable__Group__1__Impl )
            // InternalMutaText.g:1079:2: rule__Variable__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Variable__Group__1__Impl();

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
    // InternalMutaText.g:1085:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__TypeAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1089:1: ( ( ( rule__Variable__TypeAssignment_1 ) ) )
            // InternalMutaText.g:1090:1: ( ( rule__Variable__TypeAssignment_1 ) )
            {
            // InternalMutaText.g:1090:1: ( ( rule__Variable__TypeAssignment_1 ) )
            // InternalMutaText.g:1091:2: ( rule__Variable__TypeAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_1()); 
            // InternalMutaText.g:1092:2: ( rule__Variable__TypeAssignment_1 )
            // InternalMutaText.g:1092:3: rule__Variable__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Variable__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getTypeAssignment_1()); 

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


    // $ANTLR start "rule__Configuration__MetamodelAssignment_2"
    // InternalMutaText.g:1101:1: rule__Configuration__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__Configuration__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1105:1: ( ( ruleEString ) )
            // InternalMutaText.g:1106:2: ( ruleEString )
            {
            // InternalMutaText.g:1106:2: ( ruleEString )
            // InternalMutaText.g:1107:3: ruleEString
            {
             before(grammarAccess.getConfigurationAccess().getMetamodelEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getMetamodelEStringParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Configuration__MetamodelAssignment_2"


    // $ANTLR start "rule__Configuration__OptionsAssignment_3_0"
    // InternalMutaText.g:1116:1: rule__Configuration__OptionsAssignment_3_0 : ( ruleOption ) ;
    public final void rule__Configuration__OptionsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1120:1: ( ( ruleOption ) )
            // InternalMutaText.g:1121:2: ( ruleOption )
            {
            // InternalMutaText.g:1121:2: ( ruleOption )
            // InternalMutaText.g:1122:3: ruleOption
            {
             before(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_0_0()); 

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
    // $ANTLR end "rule__Configuration__OptionsAssignment_3_0"


    // $ANTLR start "rule__Configuration__OptionsAssignment_3_1"
    // InternalMutaText.g:1131:1: rule__Configuration__OptionsAssignment_3_1 : ( ruleOption ) ;
    public final void rule__Configuration__OptionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1135:1: ( ( ruleOption ) )
            // InternalMutaText.g:1136:2: ( ruleOption )
            {
            // InternalMutaText.g:1136:2: ( ruleOption )
            // InternalMutaText.g:1137:3: ruleOption
            {
             before(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_1_0()); 

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
    // $ANTLR end "rule__Configuration__OptionsAssignment_3_1"


    // $ANTLR start "rule__Option__TypeAssignment_2"
    // InternalMutaText.g:1146:1: rule__Option__TypeAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__Option__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1150:1: ( ( ( ruleEString ) ) )
            // InternalMutaText.g:1151:2: ( ( ruleEString ) )
            {
            // InternalMutaText.g:1151:2: ( ( ruleEString ) )
            // InternalMutaText.g:1152:3: ( ruleEString )
            {
             before(grammarAccess.getOptionAccess().getTypeEClassCrossReference_2_0()); 
            // InternalMutaText.g:1153:3: ( ruleEString )
            // InternalMutaText.g:1154:4: ruleEString
            {
             before(grammarAccess.getOptionAccess().getTypeEClassEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getOptionAccess().getTypeEClassEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getOptionAccess().getTypeEClassCrossReference_2_0()); 

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
    // $ANTLR end "rule__Option__TypeAssignment_2"


    // $ANTLR start "rule__Option__ObjectAssignment_3_1"
    // InternalMutaText.g:1165:1: rule__Option__ObjectAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__Option__ObjectAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1169:1: ( ( ( ruleEString ) ) )
            // InternalMutaText.g:1170:2: ( ( ruleEString ) )
            {
            // InternalMutaText.g:1170:2: ( ( ruleEString ) )
            // InternalMutaText.g:1171:3: ( ruleEString )
            {
             before(grammarAccess.getOptionAccess().getObjectEObjectCrossReference_3_1_0()); 
            // InternalMutaText.g:1172:3: ( ruleEString )
            // InternalMutaText.g:1173:4: ruleEString
            {
             before(grammarAccess.getOptionAccess().getObjectEObjectEStringParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getOptionAccess().getObjectEObjectEStringParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getOptionAccess().getObjectEObjectCrossReference_3_1_0()); 

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
    // $ANTLR end "rule__Option__ObjectAssignment_3_1"


    // $ANTLR start "rule__Option__ValidAssignment_5"
    // InternalMutaText.g:1184:1: rule__Option__ValidAssignment_5 : ( ruleText ) ;
    public final void rule__Option__ValidAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1188:1: ( ( ruleText ) )
            // InternalMutaText.g:1189:2: ( ruleText )
            {
            // InternalMutaText.g:1189:2: ( ruleText )
            // InternalMutaText.g:1190:3: ruleText
            {
             before(grammarAccess.getOptionAccess().getValidTextParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleText();

            state._fsp--;

             after(grammarAccess.getOptionAccess().getValidTextParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__Option__ValidAssignment_5"


    // $ANTLR start "rule__Option__InvalidAssignment_7"
    // InternalMutaText.g:1199:1: rule__Option__InvalidAssignment_7 : ( ruleText ) ;
    public final void rule__Option__InvalidAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1203:1: ( ( ruleText ) )
            // InternalMutaText.g:1204:2: ( ruleText )
            {
            // InternalMutaText.g:1204:2: ( ruleText )
            // InternalMutaText.g:1205:3: ruleText
            {
             before(grammarAccess.getOptionAccess().getInvalidTextParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleText();

            state._fsp--;

             after(grammarAccess.getOptionAccess().getInvalidTextParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__Option__InvalidAssignment_7"


    // $ANTLR start "rule__Text__WordsAssignment_1_0"
    // InternalMutaText.g:1214:1: rule__Text__WordsAssignment_1_0 : ( ruleWord ) ;
    public final void rule__Text__WordsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1218:1: ( ( ruleWord ) )
            // InternalMutaText.g:1219:2: ( ruleWord )
            {
            // InternalMutaText.g:1219:2: ( ruleWord )
            // InternalMutaText.g:1220:3: ruleWord
            {
             before(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_0_0()); 

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
    // $ANTLR end "rule__Text__WordsAssignment_1_0"


    // $ANTLR start "rule__Text__WordsAssignment_1_1"
    // InternalMutaText.g:1229:1: rule__Text__WordsAssignment_1_1 : ( ruleWord ) ;
    public final void rule__Text__WordsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1233:1: ( ( ruleWord ) )
            // InternalMutaText.g:1234:2: ( ruleWord )
            {
            // InternalMutaText.g:1234:2: ( ruleWord )
            // InternalMutaText.g:1235:3: ruleWord
            {
             before(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__Text__WordsAssignment_1_1"


    // $ANTLR start "rule__Constant__ValueAssignment_1"
    // InternalMutaText.g:1244:1: rule__Constant__ValueAssignment_1 : ( ruleEString ) ;
    public final void rule__Constant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1248:1: ( ( ruleEString ) )
            // InternalMutaText.g:1249:2: ( ruleEString )
            {
            // InternalMutaText.g:1249:2: ( ruleEString )
            // InternalMutaText.g:1250:3: ruleEString
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


    // $ANTLR start "rule__Variable__TypeAssignment_1"
    // InternalMutaText.g:1259:1: rule__Variable__TypeAssignment_1 : ( ruleVariableType ) ;
    public final void rule__Variable__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMutaText.g:1263:1: ( ( ruleVariableType ) )
            // InternalMutaText.g:1264:2: ( ruleVariableType )
            {
            // InternalMutaText.g:1264:2: ( ruleVariableType )
            // InternalMutaText.g:1265:3: ruleVariableType
            {
             before(grammarAccess.getVariableAccess().getTypeVariableTypeEnumRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleVariableType();

            state._fsp--;

             after(grammarAccess.getVariableAccess().getTypeVariableTypeEnumRuleCall_1_0()); 

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
    // $ANTLR end "rule__Variable__TypeAssignment_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x00000001FFFFF830L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000001FFFFF832L});

}