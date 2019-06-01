package wodel.dsls.ide.contentassist.antlr.internal;

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
import wodel.dsls.services.AspleGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalAspleParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'true'", "'false'", "'E'", "'e'", "'+'", "'-'", "'*'", "'/'", "'%'", "'=='", "'!='", "'>'", "'<'", "'int'", "'bool'", "'double'", "'begin'", "'end'", "';'", "','", "'.'", "'='", "'if'", "'('", "')'", "'{'", "'}'", "'else'", "'while'", "'repeat'", "'until'", "'input'", "'output'", "'ref'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=5;
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
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__44=44;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalAspleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalAspleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalAspleParser.tokenNames; }
    public String getGrammarFileName() { return "InternalAsple.g"; }


    	private AspleGrammarAccess grammarAccess;

    	public void setGrammarAccess(AspleGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleProgram"
    // InternalAsple.g:53:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // InternalAsple.g:54:1: ( ruleProgram EOF )
            // InternalAsple.g:55:1: ruleProgram EOF
            {
             before(grammarAccess.getProgramRule()); 
            pushFollow(FOLLOW_1);
            ruleProgram();

            state._fsp--;

             after(grammarAccess.getProgramRule()); 
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
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalAsple.g:62:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:66:2: ( ( ( rule__Program__Group__0 ) ) )
            // InternalAsple.g:67:2: ( ( rule__Program__Group__0 ) )
            {
            // InternalAsple.g:67:2: ( ( rule__Program__Group__0 ) )
            // InternalAsple.g:68:3: ( rule__Program__Group__0 )
            {
             before(grammarAccess.getProgramAccess().getGroup()); 
            // InternalAsple.g:69:3: ( rule__Program__Group__0 )
            // InternalAsple.g:69:4: rule__Program__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleDeclaration"
    // InternalAsple.g:78:1: entryRuleDeclaration : ruleDeclaration EOF ;
    public final void entryRuleDeclaration() throws RecognitionException {
        try {
            // InternalAsple.g:79:1: ( ruleDeclaration EOF )
            // InternalAsple.g:80:1: ruleDeclaration EOF
            {
             before(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getDeclarationRule()); 
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
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalAsple.g:87:1: ruleDeclaration : ( ( rule__Declaration__Group__0 ) ) ;
    public final void ruleDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:91:2: ( ( ( rule__Declaration__Group__0 ) ) )
            // InternalAsple.g:92:2: ( ( rule__Declaration__Group__0 ) )
            {
            // InternalAsple.g:92:2: ( ( rule__Declaration__Group__0 ) )
            // InternalAsple.g:93:3: ( rule__Declaration__Group__0 )
            {
             before(grammarAccess.getDeclarationAccess().getGroup()); 
            // InternalAsple.g:94:3: ( rule__Declaration__Group__0 )
            // InternalAsple.g:94:4: rule__Declaration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDeclarationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleEString"
    // InternalAsple.g:103:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalAsple.g:104:1: ( ruleEString EOF )
            // InternalAsple.g:105:1: ruleEString EOF
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
    // InternalAsple.g:112:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:116:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalAsple.g:117:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalAsple.g:117:2: ( ( rule__EString__Alternatives ) )
            // InternalAsple.g:118:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalAsple.g:119:3: ( rule__EString__Alternatives )
            // InternalAsple.g:119:4: rule__EString__Alternatives
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


    // $ANTLR start "entryRuleEInt"
    // InternalAsple.g:128:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // InternalAsple.g:129:1: ( ruleEInt EOF )
            // InternalAsple.g:130:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_1);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
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
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // InternalAsple.g:137:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:141:2: ( ( ( rule__EInt__Group__0 ) ) )
            // InternalAsple.g:142:2: ( ( rule__EInt__Group__0 ) )
            {
            // InternalAsple.g:142:2: ( ( rule__EInt__Group__0 ) )
            // InternalAsple.g:143:3: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // InternalAsple.g:144:3: ( rule__EInt__Group__0 )
            // InternalAsple.g:144:4: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEBoolean"
    // InternalAsple.g:153:1: entryRuleEBoolean : ruleEBoolean EOF ;
    public final void entryRuleEBoolean() throws RecognitionException {
        try {
            // InternalAsple.g:154:1: ( ruleEBoolean EOF )
            // InternalAsple.g:155:1: ruleEBoolean EOF
            {
             before(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getEBooleanRule()); 
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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // InternalAsple.g:162:1: ruleEBoolean : ( ( rule__EBoolean__Alternatives ) ) ;
    public final void ruleEBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:166:2: ( ( ( rule__EBoolean__Alternatives ) ) )
            // InternalAsple.g:167:2: ( ( rule__EBoolean__Alternatives ) )
            {
            // InternalAsple.g:167:2: ( ( rule__EBoolean__Alternatives ) )
            // InternalAsple.g:168:3: ( rule__EBoolean__Alternatives )
            {
             before(grammarAccess.getEBooleanAccess().getAlternatives()); 
            // InternalAsple.g:169:3: ( rule__EBoolean__Alternatives )
            // InternalAsple.g:169:4: rule__EBoolean__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__EBoolean__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEBooleanAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleEDouble"
    // InternalAsple.g:178:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalAsple.g:179:1: ( ruleEDouble EOF )
            // InternalAsple.g:180:1: ruleEDouble EOF
            {
             before(grammarAccess.getEDoubleRule()); 
            pushFollow(FOLLOW_1);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getEDoubleRule()); 
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
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // InternalAsple.g:187:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:191:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalAsple.g:192:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalAsple.g:192:2: ( ( rule__EDouble__Group__0 ) )
            // InternalAsple.g:193:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalAsple.g:194:3: ( rule__EDouble__Group__0 )
            // InternalAsple.g:194:4: rule__EDouble__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleIdentifier"
    // InternalAsple.g:203:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // InternalAsple.g:204:1: ( ruleIdentifier EOF )
            // InternalAsple.g:205:1: ruleIdentifier EOF
            {
             before(grammarAccess.getIdentifierRule()); 
            pushFollow(FOLLOW_1);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getIdentifierRule()); 
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
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // InternalAsple.g:212:1: ruleIdentifier : ( ( rule__Identifier__Group__0 ) ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:216:2: ( ( ( rule__Identifier__Group__0 ) ) )
            // InternalAsple.g:217:2: ( ( rule__Identifier__Group__0 ) )
            {
            // InternalAsple.g:217:2: ( ( rule__Identifier__Group__0 ) )
            // InternalAsple.g:218:3: ( rule__Identifier__Group__0 )
            {
             before(grammarAccess.getIdentifierAccess().getGroup()); 
            // InternalAsple.g:219:3: ( rule__Identifier__Group__0 )
            // InternalAsple.g:219:4: rule__Identifier__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Identifier__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIdentifierAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleLiteral"
    // InternalAsple.g:228:1: entryRuleLiteral : ruleLiteral EOF ;
    public final void entryRuleLiteral() throws RecognitionException {
        try {
            // InternalAsple.g:229:1: ( ruleLiteral EOF )
            // InternalAsple.g:230:1: ruleLiteral EOF
            {
             before(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_1);
            ruleLiteral();

            state._fsp--;

             after(grammarAccess.getLiteralRule()); 
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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalAsple.g:237:1: ruleLiteral : ( ( rule__Literal__Alternatives ) ) ;
    public final void ruleLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:241:2: ( ( ( rule__Literal__Alternatives ) ) )
            // InternalAsple.g:242:2: ( ( rule__Literal__Alternatives ) )
            {
            // InternalAsple.g:242:2: ( ( rule__Literal__Alternatives ) )
            // InternalAsple.g:243:3: ( rule__Literal__Alternatives )
            {
             before(grammarAccess.getLiteralAccess().getAlternatives()); 
            // InternalAsple.g:244:3: ( rule__Literal__Alternatives )
            // InternalAsple.g:244:4: rule__Literal__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Literal__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLiteralAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleInteger"
    // InternalAsple.g:253:1: entryRuleInteger : ruleInteger EOF ;
    public final void entryRuleInteger() throws RecognitionException {
        try {
            // InternalAsple.g:254:1: ( ruleInteger EOF )
            // InternalAsple.g:255:1: ruleInteger EOF
            {
             before(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_1);
            ruleInteger();

            state._fsp--;

             after(grammarAccess.getIntegerRule()); 
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
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // InternalAsple.g:262:1: ruleInteger : ( ( rule__Integer__Group__0 ) ) ;
    public final void ruleInteger() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:266:2: ( ( ( rule__Integer__Group__0 ) ) )
            // InternalAsple.g:267:2: ( ( rule__Integer__Group__0 ) )
            {
            // InternalAsple.g:267:2: ( ( rule__Integer__Group__0 ) )
            // InternalAsple.g:268:3: ( rule__Integer__Group__0 )
            {
             before(grammarAccess.getIntegerAccess().getGroup()); 
            // InternalAsple.g:269:3: ( rule__Integer__Group__0 )
            // InternalAsple.g:269:4: rule__Integer__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Integer__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getIntegerAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleBoolean"
    // InternalAsple.g:278:1: entryRuleBoolean : ruleBoolean EOF ;
    public final void entryRuleBoolean() throws RecognitionException {
        try {
            // InternalAsple.g:279:1: ( ruleBoolean EOF )
            // InternalAsple.g:280:1: ruleBoolean EOF
            {
             before(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            ruleBoolean();

            state._fsp--;

             after(grammarAccess.getBooleanRule()); 
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
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalAsple.g:287:1: ruleBoolean : ( ( rule__Boolean__Group__0 ) ) ;
    public final void ruleBoolean() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:291:2: ( ( ( rule__Boolean__Group__0 ) ) )
            // InternalAsple.g:292:2: ( ( rule__Boolean__Group__0 ) )
            {
            // InternalAsple.g:292:2: ( ( rule__Boolean__Group__0 ) )
            // InternalAsple.g:293:3: ( rule__Boolean__Group__0 )
            {
             before(grammarAccess.getBooleanAccess().getGroup()); 
            // InternalAsple.g:294:3: ( rule__Boolean__Group__0 )
            // InternalAsple.g:294:4: rule__Boolean__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Boolean__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleDouble"
    // InternalAsple.g:303:1: entryRuleDouble : ruleDouble EOF ;
    public final void entryRuleDouble() throws RecognitionException {
        try {
            // InternalAsple.g:304:1: ( ruleDouble EOF )
            // InternalAsple.g:305:1: ruleDouble EOF
            {
             before(grammarAccess.getDoubleRule()); 
            pushFollow(FOLLOW_1);
            ruleDouble();

            state._fsp--;

             after(grammarAccess.getDoubleRule()); 
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
    // $ANTLR end "entryRuleDouble"


    // $ANTLR start "ruleDouble"
    // InternalAsple.g:312:1: ruleDouble : ( ( rule__Double__Group__0 ) ) ;
    public final void ruleDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:316:2: ( ( ( rule__Double__Group__0 ) ) )
            // InternalAsple.g:317:2: ( ( rule__Double__Group__0 ) )
            {
            // InternalAsple.g:317:2: ( ( rule__Double__Group__0 ) )
            // InternalAsple.g:318:3: ( rule__Double__Group__0 )
            {
             before(grammarAccess.getDoubleAccess().getGroup()); 
            // InternalAsple.g:319:3: ( rule__Double__Group__0 )
            // InternalAsple.g:319:4: rule__Double__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Double__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDoubleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDouble"


    // $ANTLR start "entryRuleStatement"
    // InternalAsple.g:328:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // InternalAsple.g:329:1: ( ruleStatement EOF )
            // InternalAsple.g:330:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalAsple.g:337:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:341:2: ( ( ( rule__Statement__Alternatives ) ) )
            // InternalAsple.g:342:2: ( ( rule__Statement__Alternatives ) )
            {
            // InternalAsple.g:342:2: ( ( rule__Statement__Alternatives ) )
            // InternalAsple.g:343:3: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // InternalAsple.g:344:3: ( rule__Statement__Alternatives )
            // InternalAsple.g:344:4: rule__Statement__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Statement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleAssignment"
    // InternalAsple.g:353:1: entryRuleAssignment : ruleAssignment EOF ;
    public final void entryRuleAssignment() throws RecognitionException {
        try {
            // InternalAsple.g:354:1: ( ruleAssignment EOF )
            // InternalAsple.g:355:1: ruleAssignment EOF
            {
             before(grammarAccess.getAssignmentRule()); 
            pushFollow(FOLLOW_1);
            ruleAssignment();

            state._fsp--;

             after(grammarAccess.getAssignmentRule()); 
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
    // $ANTLR end "entryRuleAssignment"


    // $ANTLR start "ruleAssignment"
    // InternalAsple.g:362:1: ruleAssignment : ( ( rule__Assignment__Group__0 ) ) ;
    public final void ruleAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:366:2: ( ( ( rule__Assignment__Group__0 ) ) )
            // InternalAsple.g:367:2: ( ( rule__Assignment__Group__0 ) )
            {
            // InternalAsple.g:367:2: ( ( rule__Assignment__Group__0 ) )
            // InternalAsple.g:368:3: ( rule__Assignment__Group__0 )
            {
             before(grammarAccess.getAssignmentAccess().getGroup()); 
            // InternalAsple.g:369:3: ( rule__Assignment__Group__0 )
            // InternalAsple.g:369:4: rule__Assignment__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAssignment"


    // $ANTLR start "entryRuleConditional"
    // InternalAsple.g:378:1: entryRuleConditional : ruleConditional EOF ;
    public final void entryRuleConditional() throws RecognitionException {
        try {
            // InternalAsple.g:379:1: ( ruleConditional EOF )
            // InternalAsple.g:380:1: ruleConditional EOF
            {
             before(grammarAccess.getConditionalRule()); 
            pushFollow(FOLLOW_1);
            ruleConditional();

            state._fsp--;

             after(grammarAccess.getConditionalRule()); 
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
    // $ANTLR end "entryRuleConditional"


    // $ANTLR start "ruleConditional"
    // InternalAsple.g:387:1: ruleConditional : ( ( rule__Conditional__Group__0 ) ) ;
    public final void ruleConditional() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:391:2: ( ( ( rule__Conditional__Group__0 ) ) )
            // InternalAsple.g:392:2: ( ( rule__Conditional__Group__0 ) )
            {
            // InternalAsple.g:392:2: ( ( rule__Conditional__Group__0 ) )
            // InternalAsple.g:393:3: ( rule__Conditional__Group__0 )
            {
             before(grammarAccess.getConditionalAccess().getGroup()); 
            // InternalAsple.g:394:3: ( rule__Conditional__Group__0 )
            // InternalAsple.g:394:4: rule__Conditional__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConditionalAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConditional"


    // $ANTLR start "entryRuleLoop"
    // InternalAsple.g:403:1: entryRuleLoop : ruleLoop EOF ;
    public final void entryRuleLoop() throws RecognitionException {
        try {
            // InternalAsple.g:404:1: ( ruleLoop EOF )
            // InternalAsple.g:405:1: ruleLoop EOF
            {
             before(grammarAccess.getLoopRule()); 
            pushFollow(FOLLOW_1);
            ruleLoop();

            state._fsp--;

             after(grammarAccess.getLoopRule()); 
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
    // $ANTLR end "entryRuleLoop"


    // $ANTLR start "ruleLoop"
    // InternalAsple.g:412:1: ruleLoop : ( ( rule__Loop__Alternatives ) ) ;
    public final void ruleLoop() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:416:2: ( ( ( rule__Loop__Alternatives ) ) )
            // InternalAsple.g:417:2: ( ( rule__Loop__Alternatives ) )
            {
            // InternalAsple.g:417:2: ( ( rule__Loop__Alternatives ) )
            // InternalAsple.g:418:3: ( rule__Loop__Alternatives )
            {
             before(grammarAccess.getLoopAccess().getAlternatives()); 
            // InternalAsple.g:419:3: ( rule__Loop__Alternatives )
            // InternalAsple.g:419:4: rule__Loop__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLoop"


    // $ANTLR start "entryRuleTransput"
    // InternalAsple.g:428:1: entryRuleTransput : ruleTransput EOF ;
    public final void entryRuleTransput() throws RecognitionException {
        try {
            // InternalAsple.g:429:1: ( ruleTransput EOF )
            // InternalAsple.g:430:1: ruleTransput EOF
            {
             before(grammarAccess.getTransputRule()); 
            pushFollow(FOLLOW_1);
            ruleTransput();

            state._fsp--;

             after(grammarAccess.getTransputRule()); 
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
    // $ANTLR end "entryRuleTransput"


    // $ANTLR start "ruleTransput"
    // InternalAsple.g:437:1: ruleTransput : ( ( rule__Transput__Group__0 ) ) ;
    public final void ruleTransput() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:441:2: ( ( ( rule__Transput__Group__0 ) ) )
            // InternalAsple.g:442:2: ( ( rule__Transput__Group__0 ) )
            {
            // InternalAsple.g:442:2: ( ( rule__Transput__Group__0 ) )
            // InternalAsple.g:443:3: ( rule__Transput__Group__0 )
            {
             before(grammarAccess.getTransputAccess().getGroup()); 
            // InternalAsple.g:444:3: ( rule__Transput__Group__0 )
            // InternalAsple.g:444:4: rule__Transput__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Transput__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransputAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransput"


    // $ANTLR start "entryRuleExpression"
    // InternalAsple.g:453:1: entryRuleExpression : ruleExpression EOF ;
    public final void entryRuleExpression() throws RecognitionException {
        try {
            // InternalAsple.g:454:1: ( ruleExpression EOF )
            // InternalAsple.g:455:1: ruleExpression EOF
            {
             before(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getExpressionRule()); 
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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalAsple.g:462:1: ruleExpression : ( ( rule__Expression__Alternatives ) ) ;
    public final void ruleExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:466:2: ( ( ( rule__Expression__Alternatives ) ) )
            // InternalAsple.g:467:2: ( ( rule__Expression__Alternatives ) )
            {
            // InternalAsple.g:467:2: ( ( rule__Expression__Alternatives ) )
            // InternalAsple.g:468:3: ( rule__Expression__Alternatives )
            {
             before(grammarAccess.getExpressionAccess().getAlternatives()); 
            // InternalAsple.g:469:3: ( rule__Expression__Alternatives )
            // InternalAsple.g:469:4: rule__Expression__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Expression__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRulePrimary"
    // InternalAsple.g:478:1: entryRulePrimary : rulePrimary EOF ;
    public final void entryRulePrimary() throws RecognitionException {
        try {
            // InternalAsple.g:479:1: ( rulePrimary EOF )
            // InternalAsple.g:480:1: rulePrimary EOF
            {
             before(grammarAccess.getPrimaryRule()); 
            pushFollow(FOLLOW_1);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getPrimaryRule()); 
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
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalAsple.g:487:1: rulePrimary : ( ( rule__Primary__Alternatives ) ) ;
    public final void rulePrimary() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:491:2: ( ( ( rule__Primary__Alternatives ) ) )
            // InternalAsple.g:492:2: ( ( rule__Primary__Alternatives ) )
            {
            // InternalAsple.g:492:2: ( ( rule__Primary__Alternatives ) )
            // InternalAsple.g:493:3: ( rule__Primary__Alternatives )
            {
             before(grammarAccess.getPrimaryAccess().getAlternatives()); 
            // InternalAsple.g:494:3: ( rule__Primary__Alternatives )
            // InternalAsple.g:494:4: rule__Primary__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Primary__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPrimaryAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleBinaryOperator"
    // InternalAsple.g:503:1: entryRuleBinaryOperator : ruleBinaryOperator EOF ;
    public final void entryRuleBinaryOperator() throws RecognitionException {
        try {
            // InternalAsple.g:504:1: ( ruleBinaryOperator EOF )
            // InternalAsple.g:505:1: ruleBinaryOperator EOF
            {
             before(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FOLLOW_1);
            ruleBinaryOperator();

            state._fsp--;

             after(grammarAccess.getBinaryOperatorRule()); 
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
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // InternalAsple.g:512:1: ruleBinaryOperator : ( ( rule__BinaryOperator__Group__0 ) ) ;
    public final void ruleBinaryOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:516:2: ( ( ( rule__BinaryOperator__Group__0 ) ) )
            // InternalAsple.g:517:2: ( ( rule__BinaryOperator__Group__0 ) )
            {
            // InternalAsple.g:517:2: ( ( rule__BinaryOperator__Group__0 ) )
            // InternalAsple.g:518:3: ( rule__BinaryOperator__Group__0 )
            {
             before(grammarAccess.getBinaryOperatorAccess().getGroup()); 
            // InternalAsple.g:519:3: ( rule__BinaryOperator__Group__0 )
            // InternalAsple.g:519:4: rule__BinaryOperator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryOperator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryOperatorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBinaryOperator"


    // $ANTLR start "ruleMode"
    // InternalAsple.g:528:1: ruleMode : ( ( rule__Mode__Alternatives ) ) ;
    public final void ruleMode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:532:1: ( ( ( rule__Mode__Alternatives ) ) )
            // InternalAsple.g:533:2: ( ( rule__Mode__Alternatives ) )
            {
            // InternalAsple.g:533:2: ( ( rule__Mode__Alternatives ) )
            // InternalAsple.g:534:3: ( rule__Mode__Alternatives )
            {
             before(grammarAccess.getModeAccess().getAlternatives()); 
            // InternalAsple.g:535:3: ( rule__Mode__Alternatives )
            // InternalAsple.g:535:4: rule__Mode__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Mode__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getModeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMode"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalAsple.g:543:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:547:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalAsple.g:548:2: ( RULE_STRING )
                    {
                    // InternalAsple.g:548:2: ( RULE_STRING )
                    // InternalAsple.g:549:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:554:2: ( RULE_ID )
                    {
                    // InternalAsple.g:554:2: ( RULE_ID )
                    // InternalAsple.g:555:3: RULE_ID
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


    // $ANTLR start "rule__EBoolean__Alternatives"
    // InternalAsple.g:564:1: rule__EBoolean__Alternatives : ( ( 'true' ) | ( 'false' ) );
    public final void rule__EBoolean__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:568:1: ( ( 'true' ) | ( 'false' ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==11) ) {
                alt2=1;
            }
            else if ( (LA2_0==12) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalAsple.g:569:2: ( 'true' )
                    {
                    // InternalAsple.g:569:2: ( 'true' )
                    // InternalAsple.g:570:3: 'true'
                    {
                     before(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:575:2: ( 'false' )
                    {
                    // InternalAsple.g:575:2: ( 'false' )
                    // InternalAsple.g:576:3: 'false'
                    {
                     before(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 

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
    // $ANTLR end "rule__EBoolean__Alternatives"


    // $ANTLR start "rule__EDouble__Alternatives_4_0"
    // InternalAsple.g:585:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:589:1: ( ( 'E' ) | ( 'e' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            else if ( (LA3_0==14) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalAsple.g:590:2: ( 'E' )
                    {
                    // InternalAsple.g:590:2: ( 'E' )
                    // InternalAsple.g:591:3: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:596:2: ( 'e' )
                    {
                    // InternalAsple.g:596:2: ( 'e' )
                    // InternalAsple.g:597:3: 'e'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 

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
    // $ANTLR end "rule__EDouble__Alternatives_4_0"


    // $ANTLR start "rule__Literal__Alternatives"
    // InternalAsple.g:606:1: rule__Literal__Alternatives : ( ( ruleInteger ) | ( ruleBoolean ) | ( ruleDouble ) );
    public final void rule__Literal__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:610:1: ( ( ruleInteger ) | ( ruleBoolean ) | ( ruleDouble ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==RULE_INT) ) {
                    int LA4_2 = input.LA(3);

                    if ( (LA4_2==EOF||LA4_2==RULE_ID||(LA4_2>=15 && LA4_2<=23)||(LA4_2>=28 && LA4_2<=29)||LA4_2==33||LA4_2==35||LA4_2==37||(LA4_2>=39 && LA4_2<=40)||LA4_2==42) ) {
                        alt4=1;
                    }
                    else if ( (LA4_2==31) ) {
                        alt4=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA4_1==31) ) {
                    alt4=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_INT:
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==EOF||LA4_2==RULE_ID||(LA4_2>=15 && LA4_2<=23)||(LA4_2>=28 && LA4_2<=29)||LA4_2==33||LA4_2==35||LA4_2==37||(LA4_2>=39 && LA4_2<=40)||LA4_2==42) ) {
                    alt4=1;
                }
                else if ( (LA4_2==31) ) {
                    alt4=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
                }
                break;
            case 11:
            case 12:
                {
                alt4=2;
                }
                break;
            case 31:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalAsple.g:611:2: ( ruleInteger )
                    {
                    // InternalAsple.g:611:2: ( ruleInteger )
                    // InternalAsple.g:612:3: ruleInteger
                    {
                     before(grammarAccess.getLiteralAccess().getIntegerParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleInteger();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getIntegerParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:617:2: ( ruleBoolean )
                    {
                    // InternalAsple.g:617:2: ( ruleBoolean )
                    // InternalAsple.g:618:3: ruleBoolean
                    {
                     before(grammarAccess.getLiteralAccess().getBooleanParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBoolean();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getBooleanParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAsple.g:623:2: ( ruleDouble )
                    {
                    // InternalAsple.g:623:2: ( ruleDouble )
                    // InternalAsple.g:624:3: ruleDouble
                    {
                     before(grammarAccess.getLiteralAccess().getDoubleParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleDouble();

                    state._fsp--;

                     after(grammarAccess.getLiteralAccess().getDoubleParserRuleCall_2()); 

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
    // $ANTLR end "rule__Literal__Alternatives"


    // $ANTLR start "rule__Statement__Alternatives"
    // InternalAsple.g:633:1: rule__Statement__Alternatives : ( ( ruleAssignment ) | ( ruleConditional ) | ( ruleLoop ) | ( ruleTransput ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:637:1: ( ( ruleAssignment ) | ( ruleConditional ) | ( ruleLoop ) | ( ruleTransput ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 33:
                {
                alt5=2;
                }
                break;
            case 39:
            case 40:
                {
                alt5=3;
                }
                break;
            case 42:
                {
                alt5=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // InternalAsple.g:638:2: ( ruleAssignment )
                    {
                    // InternalAsple.g:638:2: ( ruleAssignment )
                    // InternalAsple.g:639:3: ruleAssignment
                    {
                     before(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAssignment();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getAssignmentParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:644:2: ( ruleConditional )
                    {
                    // InternalAsple.g:644:2: ( ruleConditional )
                    // InternalAsple.g:645:3: ruleConditional
                    {
                     before(grammarAccess.getStatementAccess().getConditionalParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleConditional();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getConditionalParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAsple.g:650:2: ( ruleLoop )
                    {
                    // InternalAsple.g:650:2: ( ruleLoop )
                    // InternalAsple.g:651:3: ruleLoop
                    {
                     before(grammarAccess.getStatementAccess().getLoopParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleLoop();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getLoopParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAsple.g:656:2: ( ruleTransput )
                    {
                    // InternalAsple.g:656:2: ( ruleTransput )
                    // InternalAsple.g:657:3: ruleTransput
                    {
                     before(grammarAccess.getStatementAccess().getTransputParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleTransput();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getTransputParserRuleCall_3()); 

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
    // $ANTLR end "rule__Statement__Alternatives"


    // $ANTLR start "rule__Loop__Alternatives"
    // InternalAsple.g:666:1: rule__Loop__Alternatives : ( ( ( rule__Loop__Group_0__0 ) ) | ( ( rule__Loop__Group_1__0 ) ) );
    public final void rule__Loop__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:670:1: ( ( ( rule__Loop__Group_0__0 ) ) | ( ( rule__Loop__Group_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==39) ) {
                alt6=1;
            }
            else if ( (LA6_0==40) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalAsple.g:671:2: ( ( rule__Loop__Group_0__0 ) )
                    {
                    // InternalAsple.g:671:2: ( ( rule__Loop__Group_0__0 ) )
                    // InternalAsple.g:672:3: ( rule__Loop__Group_0__0 )
                    {
                     before(grammarAccess.getLoopAccess().getGroup_0()); 
                    // InternalAsple.g:673:3: ( rule__Loop__Group_0__0 )
                    // InternalAsple.g:673:4: rule__Loop__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Loop__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLoopAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:677:2: ( ( rule__Loop__Group_1__0 ) )
                    {
                    // InternalAsple.g:677:2: ( ( rule__Loop__Group_1__0 ) )
                    // InternalAsple.g:678:3: ( rule__Loop__Group_1__0 )
                    {
                     before(grammarAccess.getLoopAccess().getGroup_1()); 
                    // InternalAsple.g:679:3: ( rule__Loop__Group_1__0 )
                    // InternalAsple.g:679:4: rule__Loop__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Loop__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLoopAccess().getGroup_1()); 

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
    // $ANTLR end "rule__Loop__Alternatives"


    // $ANTLR start "rule__Expression__Alternatives"
    // InternalAsple.g:687:1: rule__Expression__Alternatives : ( ( rulePrimary ) | ( ruleBinaryOperator ) );
    public final void rule__Expression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:691:1: ( ( rulePrimary ) | ( ruleBinaryOperator ) )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalAsple.g:692:2: ( rulePrimary )
                    {
                    // InternalAsple.g:692:2: ( rulePrimary )
                    // InternalAsple.g:693:3: rulePrimary
                    {
                     before(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    rulePrimary();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getPrimaryParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:698:2: ( ruleBinaryOperator )
                    {
                    // InternalAsple.g:698:2: ( ruleBinaryOperator )
                    // InternalAsple.g:699:3: ruleBinaryOperator
                    {
                     before(grammarAccess.getExpressionAccess().getBinaryOperatorParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleBinaryOperator();

                    state._fsp--;

                     after(grammarAccess.getExpressionAccess().getBinaryOperatorParserRuleCall_1()); 

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
    // $ANTLR end "rule__Expression__Alternatives"


    // $ANTLR start "rule__Primary__Alternatives"
    // InternalAsple.g:708:1: rule__Primary__Alternatives : ( ( ruleIdentifier ) | ( ruleLiteral ) );
    public final void rule__Primary__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:712:1: ( ( ruleIdentifier ) | ( ruleLiteral ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_INT||(LA8_0>=11 && LA8_0<=12)||LA8_0==16||LA8_0==31) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalAsple.g:713:2: ( ruleIdentifier )
                    {
                    // InternalAsple.g:713:2: ( ruleIdentifier )
                    // InternalAsple.g:714:3: ruleIdentifier
                    {
                     before(grammarAccess.getPrimaryAccess().getIdentifierParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleIdentifier();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getIdentifierParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:719:2: ( ruleLiteral )
                    {
                    // InternalAsple.g:719:2: ( ruleLiteral )
                    // InternalAsple.g:720:3: ruleLiteral
                    {
                     before(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLiteral();

                    state._fsp--;

                     after(grammarAccess.getPrimaryAccess().getLiteralParserRuleCall_1()); 

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
    // $ANTLR end "rule__Primary__Alternatives"


    // $ANTLR start "rule__BinaryOperator__OperatorAlternatives_2_0"
    // InternalAsple.g:729:1: rule__BinaryOperator__OperatorAlternatives_2_0 : ( ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '<' ) );
    public final void rule__BinaryOperator__OperatorAlternatives_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:733:1: ( ( '+' ) | ( '-' ) | ( '*' ) | ( '/' ) | ( '%' ) | ( '==' ) | ( '!=' ) | ( '>' ) | ( '<' ) )
            int alt9=9;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt9=1;
                }
                break;
            case 16:
                {
                alt9=2;
                }
                break;
            case 17:
                {
                alt9=3;
                }
                break;
            case 18:
                {
                alt9=4;
                }
                break;
            case 19:
                {
                alt9=5;
                }
                break;
            case 20:
                {
                alt9=6;
                }
                break;
            case 21:
                {
                alt9=7;
                }
                break;
            case 22:
                {
                alt9=8;
                }
                break;
            case 23:
                {
                alt9=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalAsple.g:734:2: ( '+' )
                    {
                    // InternalAsple.g:734:2: ( '+' )
                    // InternalAsple.g:735:3: '+'
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorPlusSignKeyword_2_0_0()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorPlusSignKeyword_2_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:740:2: ( '-' )
                    {
                    // InternalAsple.g:740:2: ( '-' )
                    // InternalAsple.g:741:3: '-'
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorHyphenMinusKeyword_2_0_1()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorHyphenMinusKeyword_2_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAsple.g:746:2: ( '*' )
                    {
                    // InternalAsple.g:746:2: ( '*' )
                    // InternalAsple.g:747:3: '*'
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorAsteriskKeyword_2_0_2()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorAsteriskKeyword_2_0_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalAsple.g:752:2: ( '/' )
                    {
                    // InternalAsple.g:752:2: ( '/' )
                    // InternalAsple.g:753:3: '/'
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorSolidusKeyword_2_0_3()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorSolidusKeyword_2_0_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalAsple.g:758:2: ( '%' )
                    {
                    // InternalAsple.g:758:2: ( '%' )
                    // InternalAsple.g:759:3: '%'
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorPercentSignKeyword_2_0_4()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorPercentSignKeyword_2_0_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalAsple.g:764:2: ( '==' )
                    {
                    // InternalAsple.g:764:2: ( '==' )
                    // InternalAsple.g:765:3: '=='
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorEqualsSignEqualsSignKeyword_2_0_5()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorEqualsSignEqualsSignKeyword_2_0_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalAsple.g:770:2: ( '!=' )
                    {
                    // InternalAsple.g:770:2: ( '!=' )
                    // InternalAsple.g:771:3: '!='
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorExclamationMarkEqualsSignKeyword_2_0_6()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorExclamationMarkEqualsSignKeyword_2_0_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalAsple.g:776:2: ( '>' )
                    {
                    // InternalAsple.g:776:2: ( '>' )
                    // InternalAsple.g:777:3: '>'
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorGreaterThanSignKeyword_2_0_7()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorGreaterThanSignKeyword_2_0_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalAsple.g:782:2: ( '<' )
                    {
                    // InternalAsple.g:782:2: ( '<' )
                    // InternalAsple.g:783:3: '<'
                    {
                     before(grammarAccess.getBinaryOperatorAccess().getOperatorLessThanSignKeyword_2_0_8()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getBinaryOperatorAccess().getOperatorLessThanSignKeyword_2_0_8()); 

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
    // $ANTLR end "rule__BinaryOperator__OperatorAlternatives_2_0"


    // $ANTLR start "rule__Mode__Alternatives"
    // InternalAsple.g:792:1: rule__Mode__Alternatives : ( ( ( 'int' ) ) | ( ( 'bool' ) ) | ( ( 'double' ) ) );
    public final void rule__Mode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:796:1: ( ( ( 'int' ) ) | ( ( 'bool' ) ) | ( ( 'double' ) ) )
            int alt10=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt10=1;
                }
                break;
            case 25:
                {
                alt10=2;
                }
                break;
            case 26:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalAsple.g:797:2: ( ( 'int' ) )
                    {
                    // InternalAsple.g:797:2: ( ( 'int' ) )
                    // InternalAsple.g:798:3: ( 'int' )
                    {
                     before(grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0()); 
                    // InternalAsple.g:799:3: ( 'int' )
                    // InternalAsple.g:799:4: 'int'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getModeAccess().getIntEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalAsple.g:803:2: ( ( 'bool' ) )
                    {
                    // InternalAsple.g:803:2: ( ( 'bool' ) )
                    // InternalAsple.g:804:3: ( 'bool' )
                    {
                     before(grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1()); 
                    // InternalAsple.g:805:3: ( 'bool' )
                    // InternalAsple.g:805:4: 'bool'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getModeAccess().getBoolEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalAsple.g:809:2: ( ( 'double' ) )
                    {
                    // InternalAsple.g:809:2: ( ( 'double' ) )
                    // InternalAsple.g:810:3: ( 'double' )
                    {
                     before(grammarAccess.getModeAccess().getDoubleEnumLiteralDeclaration_2()); 
                    // InternalAsple.g:811:3: ( 'double' )
                    // InternalAsple.g:811:4: 'double'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getModeAccess().getDoubleEnumLiteralDeclaration_2()); 

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
    // $ANTLR end "rule__Mode__Alternatives"


    // $ANTLR start "rule__Program__Group__0"
    // InternalAsple.g:819:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:823:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // InternalAsple.g:824:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Program__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Program__Group__1();

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
    // $ANTLR end "rule__Program__Group__0"


    // $ANTLR start "rule__Program__Group__0__Impl"
    // InternalAsple.g:831:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:835:1: ( ( () ) )
            // InternalAsple.g:836:1: ( () )
            {
            // InternalAsple.g:836:1: ( () )
            // InternalAsple.g:837:2: ()
            {
             before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            // InternalAsple.g:838:2: ()
            // InternalAsple.g:838:3: 
            {
            }

             after(grammarAccess.getProgramAccess().getProgramAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__0__Impl"


    // $ANTLR start "rule__Program__Group__1"
    // InternalAsple.g:846:1: rule__Program__Group__1 : rule__Program__Group__1__Impl rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:850:1: ( rule__Program__Group__1__Impl rule__Program__Group__2 )
            // InternalAsple.g:851:2: rule__Program__Group__1__Impl rule__Program__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__Program__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Program__Group__2();

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
    // $ANTLR end "rule__Program__Group__1"


    // $ANTLR start "rule__Program__Group__1__Impl"
    // InternalAsple.g:858:1: rule__Program__Group__1__Impl : ( 'begin' ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:862:1: ( ( 'begin' ) )
            // InternalAsple.g:863:1: ( 'begin' )
            {
            // InternalAsple.g:863:1: ( 'begin' )
            // InternalAsple.g:864:2: 'begin'
            {
             before(grammarAccess.getProgramAccess().getBeginKeyword_1()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getProgramAccess().getBeginKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__1__Impl"


    // $ANTLR start "rule__Program__Group__2"
    // InternalAsple.g:873:1: rule__Program__Group__2 : rule__Program__Group__2__Impl rule__Program__Group__3 ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:877:1: ( rule__Program__Group__2__Impl rule__Program__Group__3 )
            // InternalAsple.g:878:2: rule__Program__Group__2__Impl rule__Program__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Program__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Program__Group__3();

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
    // $ANTLR end "rule__Program__Group__2"


    // $ANTLR start "rule__Program__Group__2__Impl"
    // InternalAsple.g:885:1: rule__Program__Group__2__Impl : ( ( rule__Program__Group_2__0 )* ) ;
    public final void rule__Program__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:889:1: ( ( ( rule__Program__Group_2__0 )* ) )
            // InternalAsple.g:890:1: ( ( rule__Program__Group_2__0 )* )
            {
            // InternalAsple.g:890:1: ( ( rule__Program__Group_2__0 )* )
            // InternalAsple.g:891:2: ( rule__Program__Group_2__0 )*
            {
             before(grammarAccess.getProgramAccess().getGroup_2()); 
            // InternalAsple.g:892:2: ( rule__Program__Group_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    int LA11_1 = input.LA(2);

                    if ( ((LA11_1>=29 && LA11_1<=30)) ) {
                        alt11=1;
                    }


                }
                else if ( (LA11_0==RULE_STRING||(LA11_0>=24 && LA11_0<=26)||LA11_0==44) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalAsple.g:892:3: rule__Program__Group_2__0
            	    {
            	    pushFollow(FOLLOW_5);
            	    rule__Program__Group_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getProgramAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__2__Impl"


    // $ANTLR start "rule__Program__Group__3"
    // InternalAsple.g:900:1: rule__Program__Group__3 : rule__Program__Group__3__Impl rule__Program__Group__4 ;
    public final void rule__Program__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:904:1: ( rule__Program__Group__3__Impl rule__Program__Group__4 )
            // InternalAsple.g:905:2: rule__Program__Group__3__Impl rule__Program__Group__4
            {
            pushFollow(FOLLOW_4);
            rule__Program__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Program__Group__4();

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
    // $ANTLR end "rule__Program__Group__3"


    // $ANTLR start "rule__Program__Group__3__Impl"
    // InternalAsple.g:912:1: rule__Program__Group__3__Impl : ( ( rule__Program__StatementsAssignment_3 )* ) ;
    public final void rule__Program__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:916:1: ( ( ( rule__Program__StatementsAssignment_3 )* ) )
            // InternalAsple.g:917:1: ( ( rule__Program__StatementsAssignment_3 )* )
            {
            // InternalAsple.g:917:1: ( ( rule__Program__StatementsAssignment_3 )* )
            // InternalAsple.g:918:2: ( rule__Program__StatementsAssignment_3 )*
            {
             before(grammarAccess.getProgramAccess().getStatementsAssignment_3()); 
            // InternalAsple.g:919:2: ( rule__Program__StatementsAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||LA12_0==33||(LA12_0>=39 && LA12_0<=40)||LA12_0==42) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalAsple.g:919:3: rule__Program__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Program__StatementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getProgramAccess().getStatementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__3__Impl"


    // $ANTLR start "rule__Program__Group__4"
    // InternalAsple.g:927:1: rule__Program__Group__4 : rule__Program__Group__4__Impl ;
    public final void rule__Program__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:931:1: ( rule__Program__Group__4__Impl )
            // InternalAsple.g:932:2: rule__Program__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group__4__Impl();

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
    // $ANTLR end "rule__Program__Group__4"


    // $ANTLR start "rule__Program__Group__4__Impl"
    // InternalAsple.g:938:1: rule__Program__Group__4__Impl : ( 'end' ) ;
    public final void rule__Program__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:942:1: ( ( 'end' ) )
            // InternalAsple.g:943:1: ( 'end' )
            {
            // InternalAsple.g:943:1: ( 'end' )
            // InternalAsple.g:944:2: 'end'
            {
             before(grammarAccess.getProgramAccess().getEndKeyword_4()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getProgramAccess().getEndKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group__4__Impl"


    // $ANTLR start "rule__Program__Group_2__0"
    // InternalAsple.g:954:1: rule__Program__Group_2__0 : rule__Program__Group_2__0__Impl rule__Program__Group_2__1 ;
    public final void rule__Program__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:958:1: ( rule__Program__Group_2__0__Impl rule__Program__Group_2__1 )
            // InternalAsple.g:959:2: rule__Program__Group_2__0__Impl rule__Program__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__Program__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Program__Group_2__1();

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
    // $ANTLR end "rule__Program__Group_2__0"


    // $ANTLR start "rule__Program__Group_2__0__Impl"
    // InternalAsple.g:966:1: rule__Program__Group_2__0__Impl : ( ( rule__Program__DeclarationsAssignment_2_0 ) ) ;
    public final void rule__Program__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:970:1: ( ( ( rule__Program__DeclarationsAssignment_2_0 ) ) )
            // InternalAsple.g:971:1: ( ( rule__Program__DeclarationsAssignment_2_0 ) )
            {
            // InternalAsple.g:971:1: ( ( rule__Program__DeclarationsAssignment_2_0 ) )
            // InternalAsple.g:972:2: ( rule__Program__DeclarationsAssignment_2_0 )
            {
             before(grammarAccess.getProgramAccess().getDeclarationsAssignment_2_0()); 
            // InternalAsple.g:973:2: ( rule__Program__DeclarationsAssignment_2_0 )
            // InternalAsple.g:973:3: rule__Program__DeclarationsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Program__DeclarationsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getDeclarationsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_2__0__Impl"


    // $ANTLR start "rule__Program__Group_2__1"
    // InternalAsple.g:981:1: rule__Program__Group_2__1 : rule__Program__Group_2__1__Impl ;
    public final void rule__Program__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:985:1: ( rule__Program__Group_2__1__Impl )
            // InternalAsple.g:986:2: rule__Program__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group_2__1__Impl();

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
    // $ANTLR end "rule__Program__Group_2__1"


    // $ANTLR start "rule__Program__Group_2__1__Impl"
    // InternalAsple.g:992:1: rule__Program__Group_2__1__Impl : ( ';' ) ;
    public final void rule__Program__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:996:1: ( ( ';' ) )
            // InternalAsple.g:997:1: ( ';' )
            {
            // InternalAsple.g:997:1: ( ';' )
            // InternalAsple.g:998:2: ';'
            {
             before(grammarAccess.getProgramAccess().getSemicolonKeyword_2_1()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getProgramAccess().getSemicolonKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__Group_2__1__Impl"


    // $ANTLR start "rule__Declaration__Group__0"
    // InternalAsple.g:1008:1: rule__Declaration__Group__0 : rule__Declaration__Group__0__Impl rule__Declaration__Group__1 ;
    public final void rule__Declaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1012:1: ( rule__Declaration__Group__0__Impl rule__Declaration__Group__1 )
            // InternalAsple.g:1013:2: rule__Declaration__Group__0__Impl rule__Declaration__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Declaration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declaration__Group__1();

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
    // $ANTLR end "rule__Declaration__Group__0"


    // $ANTLR start "rule__Declaration__Group__0__Impl"
    // InternalAsple.g:1020:1: rule__Declaration__Group__0__Impl : ( () ) ;
    public final void rule__Declaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1024:1: ( ( () ) )
            // InternalAsple.g:1025:1: ( () )
            {
            // InternalAsple.g:1025:1: ( () )
            // InternalAsple.g:1026:2: ()
            {
             before(grammarAccess.getDeclarationAccess().getDeclarationAction_0()); 
            // InternalAsple.g:1027:2: ()
            // InternalAsple.g:1027:3: 
            {
            }

             after(grammarAccess.getDeclarationAccess().getDeclarationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Group__0__Impl"


    // $ANTLR start "rule__Declaration__Group__1"
    // InternalAsple.g:1035:1: rule__Declaration__Group__1 : rule__Declaration__Group__1__Impl rule__Declaration__Group__2 ;
    public final void rule__Declaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1039:1: ( rule__Declaration__Group__1__Impl rule__Declaration__Group__2 )
            // InternalAsple.g:1040:2: rule__Declaration__Group__1__Impl rule__Declaration__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__Declaration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declaration__Group__2();

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
    // $ANTLR end "rule__Declaration__Group__1"


    // $ANTLR start "rule__Declaration__Group__1__Impl"
    // InternalAsple.g:1047:1: rule__Declaration__Group__1__Impl : ( ( rule__Declaration__RefAssignment_1 )? ) ;
    public final void rule__Declaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1051:1: ( ( ( rule__Declaration__RefAssignment_1 )? ) )
            // InternalAsple.g:1052:1: ( ( rule__Declaration__RefAssignment_1 )? )
            {
            // InternalAsple.g:1052:1: ( ( rule__Declaration__RefAssignment_1 )? )
            // InternalAsple.g:1053:2: ( rule__Declaration__RefAssignment_1 )?
            {
             before(grammarAccess.getDeclarationAccess().getRefAssignment_1()); 
            // InternalAsple.g:1054:2: ( rule__Declaration__RefAssignment_1 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==44) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalAsple.g:1054:3: rule__Declaration__RefAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Declaration__RefAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDeclarationAccess().getRefAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Group__1__Impl"


    // $ANTLR start "rule__Declaration__Group__2"
    // InternalAsple.g:1062:1: rule__Declaration__Group__2 : rule__Declaration__Group__2__Impl rule__Declaration__Group__3 ;
    public final void rule__Declaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1066:1: ( rule__Declaration__Group__2__Impl rule__Declaration__Group__3 )
            // InternalAsple.g:1067:2: rule__Declaration__Group__2__Impl rule__Declaration__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Declaration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declaration__Group__3();

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
    // $ANTLR end "rule__Declaration__Group__2"


    // $ANTLR start "rule__Declaration__Group__2__Impl"
    // InternalAsple.g:1074:1: rule__Declaration__Group__2__Impl : ( ( rule__Declaration__ModeAssignment_2 )? ) ;
    public final void rule__Declaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1078:1: ( ( ( rule__Declaration__ModeAssignment_2 )? ) )
            // InternalAsple.g:1079:1: ( ( rule__Declaration__ModeAssignment_2 )? )
            {
            // InternalAsple.g:1079:1: ( ( rule__Declaration__ModeAssignment_2 )? )
            // InternalAsple.g:1080:2: ( rule__Declaration__ModeAssignment_2 )?
            {
             before(grammarAccess.getDeclarationAccess().getModeAssignment_2()); 
            // InternalAsple.g:1081:2: ( rule__Declaration__ModeAssignment_2 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=24 && LA14_0<=26)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalAsple.g:1081:3: rule__Declaration__ModeAssignment_2
                    {
                    pushFollow(FOLLOW_2);
                    rule__Declaration__ModeAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDeclarationAccess().getModeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Group__2__Impl"


    // $ANTLR start "rule__Declaration__Group__3"
    // InternalAsple.g:1089:1: rule__Declaration__Group__3 : rule__Declaration__Group__3__Impl rule__Declaration__Group__4 ;
    public final void rule__Declaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1093:1: ( rule__Declaration__Group__3__Impl rule__Declaration__Group__4 )
            // InternalAsple.g:1094:2: rule__Declaration__Group__3__Impl rule__Declaration__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__Declaration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declaration__Group__4();

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
    // $ANTLR end "rule__Declaration__Group__3"


    // $ANTLR start "rule__Declaration__Group__3__Impl"
    // InternalAsple.g:1101:1: rule__Declaration__Group__3__Impl : ( ( rule__Declaration__IdentifiersAssignment_3 ) ) ;
    public final void rule__Declaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1105:1: ( ( ( rule__Declaration__IdentifiersAssignment_3 ) ) )
            // InternalAsple.g:1106:1: ( ( rule__Declaration__IdentifiersAssignment_3 ) )
            {
            // InternalAsple.g:1106:1: ( ( rule__Declaration__IdentifiersAssignment_3 ) )
            // InternalAsple.g:1107:2: ( rule__Declaration__IdentifiersAssignment_3 )
            {
             before(grammarAccess.getDeclarationAccess().getIdentifiersAssignment_3()); 
            // InternalAsple.g:1108:2: ( rule__Declaration__IdentifiersAssignment_3 )
            // InternalAsple.g:1108:3: rule__Declaration__IdentifiersAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__IdentifiersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDeclarationAccess().getIdentifiersAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Group__3__Impl"


    // $ANTLR start "rule__Declaration__Group__4"
    // InternalAsple.g:1116:1: rule__Declaration__Group__4 : rule__Declaration__Group__4__Impl ;
    public final void rule__Declaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1120:1: ( rule__Declaration__Group__4__Impl )
            // InternalAsple.g:1121:2: rule__Declaration__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__Group__4__Impl();

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
    // $ANTLR end "rule__Declaration__Group__4"


    // $ANTLR start "rule__Declaration__Group__4__Impl"
    // InternalAsple.g:1127:1: rule__Declaration__Group__4__Impl : ( ( rule__Declaration__Group_4__0 )* ) ;
    public final void rule__Declaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1131:1: ( ( ( rule__Declaration__Group_4__0 )* ) )
            // InternalAsple.g:1132:1: ( ( rule__Declaration__Group_4__0 )* )
            {
            // InternalAsple.g:1132:1: ( ( rule__Declaration__Group_4__0 )* )
            // InternalAsple.g:1133:2: ( rule__Declaration__Group_4__0 )*
            {
             before(grammarAccess.getDeclarationAccess().getGroup_4()); 
            // InternalAsple.g:1134:2: ( rule__Declaration__Group_4__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==30) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalAsple.g:1134:3: rule__Declaration__Group_4__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Declaration__Group_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getDeclarationAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Group__4__Impl"


    // $ANTLR start "rule__Declaration__Group_4__0"
    // InternalAsple.g:1143:1: rule__Declaration__Group_4__0 : rule__Declaration__Group_4__0__Impl rule__Declaration__Group_4__1 ;
    public final void rule__Declaration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1147:1: ( rule__Declaration__Group_4__0__Impl rule__Declaration__Group_4__1 )
            // InternalAsple.g:1148:2: rule__Declaration__Group_4__0__Impl rule__Declaration__Group_4__1
            {
            pushFollow(FOLLOW_8);
            rule__Declaration__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Declaration__Group_4__1();

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
    // $ANTLR end "rule__Declaration__Group_4__0"


    // $ANTLR start "rule__Declaration__Group_4__0__Impl"
    // InternalAsple.g:1155:1: rule__Declaration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__Declaration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1159:1: ( ( ',' ) )
            // InternalAsple.g:1160:1: ( ',' )
            {
            // InternalAsple.g:1160:1: ( ',' )
            // InternalAsple.g:1161:2: ','
            {
             before(grammarAccess.getDeclarationAccess().getCommaKeyword_4_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getDeclarationAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Group_4__0__Impl"


    // $ANTLR start "rule__Declaration__Group_4__1"
    // InternalAsple.g:1170:1: rule__Declaration__Group_4__1 : rule__Declaration__Group_4__1__Impl ;
    public final void rule__Declaration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1174:1: ( rule__Declaration__Group_4__1__Impl )
            // InternalAsple.g:1175:2: rule__Declaration__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__Group_4__1__Impl();

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
    // $ANTLR end "rule__Declaration__Group_4__1"


    // $ANTLR start "rule__Declaration__Group_4__1__Impl"
    // InternalAsple.g:1181:1: rule__Declaration__Group_4__1__Impl : ( ( rule__Declaration__IdentifiersAssignment_4_1 ) ) ;
    public final void rule__Declaration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1185:1: ( ( ( rule__Declaration__IdentifiersAssignment_4_1 ) ) )
            // InternalAsple.g:1186:1: ( ( rule__Declaration__IdentifiersAssignment_4_1 ) )
            {
            // InternalAsple.g:1186:1: ( ( rule__Declaration__IdentifiersAssignment_4_1 ) )
            // InternalAsple.g:1187:2: ( rule__Declaration__IdentifiersAssignment_4_1 )
            {
             before(grammarAccess.getDeclarationAccess().getIdentifiersAssignment_4_1()); 
            // InternalAsple.g:1188:2: ( rule__Declaration__IdentifiersAssignment_4_1 )
            // InternalAsple.g:1188:3: rule__Declaration__IdentifiersAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__Declaration__IdentifiersAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getDeclarationAccess().getIdentifiersAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__Group_4__1__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // InternalAsple.g:1197:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1201:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // InternalAsple.g:1202:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EInt__Group__1();

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
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // InternalAsple.g:1209:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1213:1: ( ( ( '-' )? ) )
            // InternalAsple.g:1214:1: ( ( '-' )? )
            {
            // InternalAsple.g:1214:1: ( ( '-' )? )
            // InternalAsple.g:1215:2: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // InternalAsple.g:1216:2: ( '-' )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==16) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalAsple.g:1216:3: '-'
                    {
                    match(input,16,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // InternalAsple.g:1224:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1228:1: ( rule__EInt__Group__1__Impl )
            // InternalAsple.g:1229:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EInt__Group__1__Impl();

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
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // InternalAsple.g:1235:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1239:1: ( ( RULE_INT ) )
            // InternalAsple.g:1240:1: ( RULE_INT )
            {
            // InternalAsple.g:1240:1: ( RULE_INT )
            // InternalAsple.g:1241:2: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__0"
    // InternalAsple.g:1251:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1255:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalAsple.g:1256:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__EDouble__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__1();

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
    // $ANTLR end "rule__EDouble__Group__0"


    // $ANTLR start "rule__EDouble__Group__0__Impl"
    // InternalAsple.g:1263:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1267:1: ( ( ( '-' )? ) )
            // InternalAsple.g:1268:1: ( ( '-' )? )
            {
            // InternalAsple.g:1268:1: ( ( '-' )? )
            // InternalAsple.g:1269:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // InternalAsple.g:1270:2: ( '-' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==16) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalAsple.g:1270:3: '-'
                    {
                    match(input,16,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__0__Impl"


    // $ANTLR start "rule__EDouble__Group__1"
    // InternalAsple.g:1278:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1282:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalAsple.g:1283:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__EDouble__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__2();

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
    // $ANTLR end "rule__EDouble__Group__1"


    // $ANTLR start "rule__EDouble__Group__1__Impl"
    // InternalAsple.g:1290:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1294:1: ( ( ( RULE_INT )? ) )
            // InternalAsple.g:1295:1: ( ( RULE_INT )? )
            {
            // InternalAsple.g:1295:1: ( ( RULE_INT )? )
            // InternalAsple.g:1296:2: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // InternalAsple.g:1297:2: ( RULE_INT )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_INT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalAsple.g:1297:3: RULE_INT
                    {
                    match(input,RULE_INT,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__1__Impl"


    // $ANTLR start "rule__EDouble__Group__2"
    // InternalAsple.g:1305:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1309:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // InternalAsple.g:1310:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__EDouble__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__3();

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
    // $ANTLR end "rule__EDouble__Group__2"


    // $ANTLR start "rule__EDouble__Group__2__Impl"
    // InternalAsple.g:1317:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1321:1: ( ( '.' ) )
            // InternalAsple.g:1322:1: ( '.' )
            {
            // InternalAsple.g:1322:1: ( '.' )
            // InternalAsple.g:1323:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__2__Impl"


    // $ANTLR start "rule__EDouble__Group__3"
    // InternalAsple.g:1332:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1336:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // InternalAsple.g:1337:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FOLLOW_13);
            rule__EDouble__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4();

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
    // $ANTLR end "rule__EDouble__Group__3"


    // $ANTLR start "rule__EDouble__Group__3__Impl"
    // InternalAsple.g:1344:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1348:1: ( ( RULE_INT ) )
            // InternalAsple.g:1349:1: ( RULE_INT )
            {
            // InternalAsple.g:1349:1: ( RULE_INT )
            // InternalAsple.g:1350:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__3__Impl"


    // $ANTLR start "rule__EDouble__Group__4"
    // InternalAsple.g:1359:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1363:1: ( rule__EDouble__Group__4__Impl )
            // InternalAsple.g:1364:2: rule__EDouble__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group__4__Impl();

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
    // $ANTLR end "rule__EDouble__Group__4"


    // $ANTLR start "rule__EDouble__Group__4__Impl"
    // InternalAsple.g:1370:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1374:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // InternalAsple.g:1375:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // InternalAsple.g:1375:1: ( ( rule__EDouble__Group_4__0 )? )
            // InternalAsple.g:1376:2: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // InternalAsple.g:1377:2: ( rule__EDouble__Group_4__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=13 && LA19_0<=14)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalAsple.g:1377:3: rule__EDouble__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__EDouble__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group__4__Impl"


    // $ANTLR start "rule__EDouble__Group_4__0"
    // InternalAsple.g:1386:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1390:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // InternalAsple.g:1391:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FOLLOW_14);
            rule__EDouble__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__1();

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
    // $ANTLR end "rule__EDouble__Group_4__0"


    // $ANTLR start "rule__EDouble__Group_4__0__Impl"
    // InternalAsple.g:1398:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1402:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // InternalAsple.g:1403:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // InternalAsple.g:1403:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // InternalAsple.g:1404:2: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // InternalAsple.g:1405:2: ( rule__EDouble__Alternatives_4_0 )
            // InternalAsple.g:1405:3: rule__EDouble__Alternatives_4_0
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Alternatives_4_0();

            state._fsp--;


            }

             after(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__0__Impl"


    // $ANTLR start "rule__EDouble__Group_4__1"
    // InternalAsple.g:1413:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1417:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // InternalAsple.g:1418:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FOLLOW_14);
            rule__EDouble__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2();

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
    // $ANTLR end "rule__EDouble__Group_4__1"


    // $ANTLR start "rule__EDouble__Group_4__1__Impl"
    // InternalAsple.g:1425:1: rule__EDouble__Group_4__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1429:1: ( ( ( '-' )? ) )
            // InternalAsple.g:1430:1: ( ( '-' )? )
            {
            // InternalAsple.g:1430:1: ( ( '-' )? )
            // InternalAsple.g:1431:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
            // InternalAsple.g:1432:2: ( '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==16) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalAsple.g:1432:3: '-'
                    {
                    match(input,16,FOLLOW_2); 

                    }
                    break;

            }

             after(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__1__Impl"


    // $ANTLR start "rule__EDouble__Group_4__2"
    // InternalAsple.g:1440:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1444:1: ( rule__EDouble__Group_4__2__Impl )
            // InternalAsple.g:1445:2: rule__EDouble__Group_4__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__EDouble__Group_4__2__Impl();

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
    // $ANTLR end "rule__EDouble__Group_4__2"


    // $ANTLR start "rule__EDouble__Group_4__2__Impl"
    // InternalAsple.g:1451:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1455:1: ( ( RULE_INT ) )
            // InternalAsple.g:1456:1: ( RULE_INT )
            {
            // InternalAsple.g:1456:1: ( RULE_INT )
            // InternalAsple.g:1457:2: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EDouble__Group_4__2__Impl"


    // $ANTLR start "rule__Identifier__Group__0"
    // InternalAsple.g:1467:1: rule__Identifier__Group__0 : rule__Identifier__Group__0__Impl rule__Identifier__Group__1 ;
    public final void rule__Identifier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1471:1: ( rule__Identifier__Group__0__Impl rule__Identifier__Group__1 )
            // InternalAsple.g:1472:2: rule__Identifier__Group__0__Impl rule__Identifier__Group__1
            {
            pushFollow(FOLLOW_8);
            rule__Identifier__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Identifier__Group__1();

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
    // $ANTLR end "rule__Identifier__Group__0"


    // $ANTLR start "rule__Identifier__Group__0__Impl"
    // InternalAsple.g:1479:1: rule__Identifier__Group__0__Impl : ( () ) ;
    public final void rule__Identifier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1483:1: ( ( () ) )
            // InternalAsple.g:1484:1: ( () )
            {
            // InternalAsple.g:1484:1: ( () )
            // InternalAsple.g:1485:2: ()
            {
             before(grammarAccess.getIdentifierAccess().getIdentifierAction_0()); 
            // InternalAsple.g:1486:2: ()
            // InternalAsple.g:1486:3: 
            {
            }

             after(grammarAccess.getIdentifierAccess().getIdentifierAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Identifier__Group__0__Impl"


    // $ANTLR start "rule__Identifier__Group__1"
    // InternalAsple.g:1494:1: rule__Identifier__Group__1 : rule__Identifier__Group__1__Impl ;
    public final void rule__Identifier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1498:1: ( rule__Identifier__Group__1__Impl )
            // InternalAsple.g:1499:2: rule__Identifier__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Identifier__Group__1__Impl();

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
    // $ANTLR end "rule__Identifier__Group__1"


    // $ANTLR start "rule__Identifier__Group__1__Impl"
    // InternalAsple.g:1505:1: rule__Identifier__Group__1__Impl : ( ( rule__Identifier__NameAssignment_1 ) ) ;
    public final void rule__Identifier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1509:1: ( ( ( rule__Identifier__NameAssignment_1 ) ) )
            // InternalAsple.g:1510:1: ( ( rule__Identifier__NameAssignment_1 ) )
            {
            // InternalAsple.g:1510:1: ( ( rule__Identifier__NameAssignment_1 ) )
            // InternalAsple.g:1511:2: ( rule__Identifier__NameAssignment_1 )
            {
             before(grammarAccess.getIdentifierAccess().getNameAssignment_1()); 
            // InternalAsple.g:1512:2: ( rule__Identifier__NameAssignment_1 )
            // InternalAsple.g:1512:3: rule__Identifier__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Identifier__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIdentifierAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Identifier__Group__1__Impl"


    // $ANTLR start "rule__Integer__Group__0"
    // InternalAsple.g:1521:1: rule__Integer__Group__0 : rule__Integer__Group__0__Impl rule__Integer__Group__1 ;
    public final void rule__Integer__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1525:1: ( rule__Integer__Group__0__Impl rule__Integer__Group__1 )
            // InternalAsple.g:1526:2: rule__Integer__Group__0__Impl rule__Integer__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__Integer__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Integer__Group__1();

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
    // $ANTLR end "rule__Integer__Group__0"


    // $ANTLR start "rule__Integer__Group__0__Impl"
    // InternalAsple.g:1533:1: rule__Integer__Group__0__Impl : ( () ) ;
    public final void rule__Integer__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1537:1: ( ( () ) )
            // InternalAsple.g:1538:1: ( () )
            {
            // InternalAsple.g:1538:1: ( () )
            // InternalAsple.g:1539:2: ()
            {
             before(grammarAccess.getIntegerAccess().getIntegerAction_0()); 
            // InternalAsple.g:1540:2: ()
            // InternalAsple.g:1540:3: 
            {
            }

             after(grammarAccess.getIntegerAccess().getIntegerAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Group__0__Impl"


    // $ANTLR start "rule__Integer__Group__1"
    // InternalAsple.g:1548:1: rule__Integer__Group__1 : rule__Integer__Group__1__Impl ;
    public final void rule__Integer__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1552:1: ( rule__Integer__Group__1__Impl )
            // InternalAsple.g:1553:2: rule__Integer__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Integer__Group__1__Impl();

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
    // $ANTLR end "rule__Integer__Group__1"


    // $ANTLR start "rule__Integer__Group__1__Impl"
    // InternalAsple.g:1559:1: rule__Integer__Group__1__Impl : ( ( rule__Integer__ValueAssignment_1 ) ) ;
    public final void rule__Integer__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1563:1: ( ( ( rule__Integer__ValueAssignment_1 ) ) )
            // InternalAsple.g:1564:1: ( ( rule__Integer__ValueAssignment_1 ) )
            {
            // InternalAsple.g:1564:1: ( ( rule__Integer__ValueAssignment_1 ) )
            // InternalAsple.g:1565:2: ( rule__Integer__ValueAssignment_1 )
            {
             before(grammarAccess.getIntegerAccess().getValueAssignment_1()); 
            // InternalAsple.g:1566:2: ( rule__Integer__ValueAssignment_1 )
            // InternalAsple.g:1566:3: rule__Integer__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Integer__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getIntegerAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__Group__1__Impl"


    // $ANTLR start "rule__Boolean__Group__0"
    // InternalAsple.g:1575:1: rule__Boolean__Group__0 : rule__Boolean__Group__0__Impl rule__Boolean__Group__1 ;
    public final void rule__Boolean__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1579:1: ( rule__Boolean__Group__0__Impl rule__Boolean__Group__1 )
            // InternalAsple.g:1580:2: rule__Boolean__Group__0__Impl rule__Boolean__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Boolean__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Boolean__Group__1();

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
    // $ANTLR end "rule__Boolean__Group__0"


    // $ANTLR start "rule__Boolean__Group__0__Impl"
    // InternalAsple.g:1587:1: rule__Boolean__Group__0__Impl : ( () ) ;
    public final void rule__Boolean__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1591:1: ( ( () ) )
            // InternalAsple.g:1592:1: ( () )
            {
            // InternalAsple.g:1592:1: ( () )
            // InternalAsple.g:1593:2: ()
            {
             before(grammarAccess.getBooleanAccess().getBooleanAction_0()); 
            // InternalAsple.g:1594:2: ()
            // InternalAsple.g:1594:3: 
            {
            }

             after(grammarAccess.getBooleanAccess().getBooleanAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__Group__0__Impl"


    // $ANTLR start "rule__Boolean__Group__1"
    // InternalAsple.g:1602:1: rule__Boolean__Group__1 : rule__Boolean__Group__1__Impl ;
    public final void rule__Boolean__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1606:1: ( rule__Boolean__Group__1__Impl )
            // InternalAsple.g:1607:2: rule__Boolean__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Boolean__Group__1__Impl();

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
    // $ANTLR end "rule__Boolean__Group__1"


    // $ANTLR start "rule__Boolean__Group__1__Impl"
    // InternalAsple.g:1613:1: rule__Boolean__Group__1__Impl : ( ( rule__Boolean__ValueAssignment_1 ) ) ;
    public final void rule__Boolean__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1617:1: ( ( ( rule__Boolean__ValueAssignment_1 ) ) )
            // InternalAsple.g:1618:1: ( ( rule__Boolean__ValueAssignment_1 ) )
            {
            // InternalAsple.g:1618:1: ( ( rule__Boolean__ValueAssignment_1 ) )
            // InternalAsple.g:1619:2: ( rule__Boolean__ValueAssignment_1 )
            {
             before(grammarAccess.getBooleanAccess().getValueAssignment_1()); 
            // InternalAsple.g:1620:2: ( rule__Boolean__ValueAssignment_1 )
            // InternalAsple.g:1620:3: rule__Boolean__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Boolean__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__Group__1__Impl"


    // $ANTLR start "rule__Double__Group__0"
    // InternalAsple.g:1629:1: rule__Double__Group__0 : rule__Double__Group__0__Impl rule__Double__Group__1 ;
    public final void rule__Double__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1633:1: ( rule__Double__Group__0__Impl rule__Double__Group__1 )
            // InternalAsple.g:1634:2: rule__Double__Group__0__Impl rule__Double__Group__1
            {
            pushFollow(FOLLOW_16);
            rule__Double__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Double__Group__1();

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
    // $ANTLR end "rule__Double__Group__0"


    // $ANTLR start "rule__Double__Group__0__Impl"
    // InternalAsple.g:1641:1: rule__Double__Group__0__Impl : ( () ) ;
    public final void rule__Double__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1645:1: ( ( () ) )
            // InternalAsple.g:1646:1: ( () )
            {
            // InternalAsple.g:1646:1: ( () )
            // InternalAsple.g:1647:2: ()
            {
             before(grammarAccess.getDoubleAccess().getDoubleAction_0()); 
            // InternalAsple.g:1648:2: ()
            // InternalAsple.g:1648:3: 
            {
            }

             after(grammarAccess.getDoubleAccess().getDoubleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group__0__Impl"


    // $ANTLR start "rule__Double__Group__1"
    // InternalAsple.g:1656:1: rule__Double__Group__1 : rule__Double__Group__1__Impl ;
    public final void rule__Double__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1660:1: ( rule__Double__Group__1__Impl )
            // InternalAsple.g:1661:2: rule__Double__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Double__Group__1__Impl();

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
    // $ANTLR end "rule__Double__Group__1"


    // $ANTLR start "rule__Double__Group__1__Impl"
    // InternalAsple.g:1667:1: rule__Double__Group__1__Impl : ( ( rule__Double__ValueAssignment_1 ) ) ;
    public final void rule__Double__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1671:1: ( ( ( rule__Double__ValueAssignment_1 ) ) )
            // InternalAsple.g:1672:1: ( ( rule__Double__ValueAssignment_1 ) )
            {
            // InternalAsple.g:1672:1: ( ( rule__Double__ValueAssignment_1 ) )
            // InternalAsple.g:1673:2: ( rule__Double__ValueAssignment_1 )
            {
             before(grammarAccess.getDoubleAccess().getValueAssignment_1()); 
            // InternalAsple.g:1674:2: ( rule__Double__ValueAssignment_1 )
            // InternalAsple.g:1674:3: rule__Double__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Double__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getDoubleAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__0"
    // InternalAsple.g:1683:1: rule__Assignment__Group__0 : rule__Assignment__Group__0__Impl rule__Assignment__Group__1 ;
    public final void rule__Assignment__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1687:1: ( rule__Assignment__Group__0__Impl rule__Assignment__Group__1 )
            // InternalAsple.g:1688:2: rule__Assignment__Group__0__Impl rule__Assignment__Group__1
            {
            pushFollow(FOLLOW_17);
            rule__Assignment__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assignment__Group__1();

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
    // $ANTLR end "rule__Assignment__Group__0"


    // $ANTLR start "rule__Assignment__Group__0__Impl"
    // InternalAsple.g:1695:1: rule__Assignment__Group__0__Impl : ( ( rule__Assignment__VarAssignment_0 ) ) ;
    public final void rule__Assignment__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1699:1: ( ( ( rule__Assignment__VarAssignment_0 ) ) )
            // InternalAsple.g:1700:1: ( ( rule__Assignment__VarAssignment_0 ) )
            {
            // InternalAsple.g:1700:1: ( ( rule__Assignment__VarAssignment_0 ) )
            // InternalAsple.g:1701:2: ( rule__Assignment__VarAssignment_0 )
            {
             before(grammarAccess.getAssignmentAccess().getVarAssignment_0()); 
            // InternalAsple.g:1702:2: ( rule__Assignment__VarAssignment_0 )
            // InternalAsple.g:1702:3: rule__Assignment__VarAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__VarAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getVarAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__0__Impl"


    // $ANTLR start "rule__Assignment__Group__1"
    // InternalAsple.g:1710:1: rule__Assignment__Group__1 : rule__Assignment__Group__1__Impl rule__Assignment__Group__2 ;
    public final void rule__Assignment__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1714:1: ( rule__Assignment__Group__1__Impl rule__Assignment__Group__2 )
            // InternalAsple.g:1715:2: rule__Assignment__Group__1__Impl rule__Assignment__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Assignment__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assignment__Group__2();

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
    // $ANTLR end "rule__Assignment__Group__1"


    // $ANTLR start "rule__Assignment__Group__1__Impl"
    // InternalAsple.g:1722:1: rule__Assignment__Group__1__Impl : ( '=' ) ;
    public final void rule__Assignment__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1726:1: ( ( '=' ) )
            // InternalAsple.g:1727:1: ( '=' )
            {
            // InternalAsple.g:1727:1: ( '=' )
            // InternalAsple.g:1728:2: '='
            {
             before(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__1__Impl"


    // $ANTLR start "rule__Assignment__Group__2"
    // InternalAsple.g:1737:1: rule__Assignment__Group__2 : rule__Assignment__Group__2__Impl rule__Assignment__Group__3 ;
    public final void rule__Assignment__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1741:1: ( rule__Assignment__Group__2__Impl rule__Assignment__Group__3 )
            // InternalAsple.g:1742:2: rule__Assignment__Group__2__Impl rule__Assignment__Group__3
            {
            pushFollow(FOLLOW_7);
            rule__Assignment__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Assignment__Group__3();

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
    // $ANTLR end "rule__Assignment__Group__2"


    // $ANTLR start "rule__Assignment__Group__2__Impl"
    // InternalAsple.g:1749:1: rule__Assignment__Group__2__Impl : ( ( rule__Assignment__ValueAssignment_2 ) ) ;
    public final void rule__Assignment__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1753:1: ( ( ( rule__Assignment__ValueAssignment_2 ) ) )
            // InternalAsple.g:1754:1: ( ( rule__Assignment__ValueAssignment_2 ) )
            {
            // InternalAsple.g:1754:1: ( ( rule__Assignment__ValueAssignment_2 ) )
            // InternalAsple.g:1755:2: ( rule__Assignment__ValueAssignment_2 )
            {
             before(grammarAccess.getAssignmentAccess().getValueAssignment_2()); 
            // InternalAsple.g:1756:2: ( rule__Assignment__ValueAssignment_2 )
            // InternalAsple.g:1756:3: rule__Assignment__ValueAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getAssignmentAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__2__Impl"


    // $ANTLR start "rule__Assignment__Group__3"
    // InternalAsple.g:1764:1: rule__Assignment__Group__3 : rule__Assignment__Group__3__Impl ;
    public final void rule__Assignment__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1768:1: ( rule__Assignment__Group__3__Impl )
            // InternalAsple.g:1769:2: rule__Assignment__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Assignment__Group__3__Impl();

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
    // $ANTLR end "rule__Assignment__Group__3"


    // $ANTLR start "rule__Assignment__Group__3__Impl"
    // InternalAsple.g:1775:1: rule__Assignment__Group__3__Impl : ( ';' ) ;
    public final void rule__Assignment__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1779:1: ( ( ';' ) )
            // InternalAsple.g:1780:1: ( ';' )
            {
            // InternalAsple.g:1780:1: ( ';' )
            // InternalAsple.g:1781:2: ';'
            {
             before(grammarAccess.getAssignmentAccess().getSemicolonKeyword_3()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getSemicolonKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__Group__3__Impl"


    // $ANTLR start "rule__Conditional__Group__0"
    // InternalAsple.g:1791:1: rule__Conditional__Group__0 : rule__Conditional__Group__0__Impl rule__Conditional__Group__1 ;
    public final void rule__Conditional__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1795:1: ( rule__Conditional__Group__0__Impl rule__Conditional__Group__1 )
            // InternalAsple.g:1796:2: rule__Conditional__Group__0__Impl rule__Conditional__Group__1
            {
            pushFollow(FOLLOW_19);
            rule__Conditional__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__1();

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
    // $ANTLR end "rule__Conditional__Group__0"


    // $ANTLR start "rule__Conditional__Group__0__Impl"
    // InternalAsple.g:1803:1: rule__Conditional__Group__0__Impl : ( () ) ;
    public final void rule__Conditional__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1807:1: ( ( () ) )
            // InternalAsple.g:1808:1: ( () )
            {
            // InternalAsple.g:1808:1: ( () )
            // InternalAsple.g:1809:2: ()
            {
             before(grammarAccess.getConditionalAccess().getConditionalAction_0()); 
            // InternalAsple.g:1810:2: ()
            // InternalAsple.g:1810:3: 
            {
            }

             after(grammarAccess.getConditionalAccess().getConditionalAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__0__Impl"


    // $ANTLR start "rule__Conditional__Group__1"
    // InternalAsple.g:1818:1: rule__Conditional__Group__1 : rule__Conditional__Group__1__Impl rule__Conditional__Group__2 ;
    public final void rule__Conditional__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1822:1: ( rule__Conditional__Group__1__Impl rule__Conditional__Group__2 )
            // InternalAsple.g:1823:2: rule__Conditional__Group__1__Impl rule__Conditional__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__Conditional__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__2();

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
    // $ANTLR end "rule__Conditional__Group__1"


    // $ANTLR start "rule__Conditional__Group__1__Impl"
    // InternalAsple.g:1830:1: rule__Conditional__Group__1__Impl : ( 'if' ) ;
    public final void rule__Conditional__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1834:1: ( ( 'if' ) )
            // InternalAsple.g:1835:1: ( 'if' )
            {
            // InternalAsple.g:1835:1: ( 'if' )
            // InternalAsple.g:1836:2: 'if'
            {
             before(grammarAccess.getConditionalAccess().getIfKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getIfKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__1__Impl"


    // $ANTLR start "rule__Conditional__Group__2"
    // InternalAsple.g:1845:1: rule__Conditional__Group__2 : rule__Conditional__Group__2__Impl rule__Conditional__Group__3 ;
    public final void rule__Conditional__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1849:1: ( rule__Conditional__Group__2__Impl rule__Conditional__Group__3 )
            // InternalAsple.g:1850:2: rule__Conditional__Group__2__Impl rule__Conditional__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__Conditional__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__3();

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
    // $ANTLR end "rule__Conditional__Group__2"


    // $ANTLR start "rule__Conditional__Group__2__Impl"
    // InternalAsple.g:1857:1: rule__Conditional__Group__2__Impl : ( '(' ) ;
    public final void rule__Conditional__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1861:1: ( ( '(' ) )
            // InternalAsple.g:1862:1: ( '(' )
            {
            // InternalAsple.g:1862:1: ( '(' )
            // InternalAsple.g:1863:2: '('
            {
             before(grammarAccess.getConditionalAccess().getLeftParenthesisKeyword_2()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__2__Impl"


    // $ANTLR start "rule__Conditional__Group__3"
    // InternalAsple.g:1872:1: rule__Conditional__Group__3 : rule__Conditional__Group__3__Impl rule__Conditional__Group__4 ;
    public final void rule__Conditional__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1876:1: ( rule__Conditional__Group__3__Impl rule__Conditional__Group__4 )
            // InternalAsple.g:1877:2: rule__Conditional__Group__3__Impl rule__Conditional__Group__4
            {
            pushFollow(FOLLOW_21);
            rule__Conditional__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__4();

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
    // $ANTLR end "rule__Conditional__Group__3"


    // $ANTLR start "rule__Conditional__Group__3__Impl"
    // InternalAsple.g:1884:1: rule__Conditional__Group__3__Impl : ( ( rule__Conditional__ExpressionAssignment_3 ) ) ;
    public final void rule__Conditional__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1888:1: ( ( ( rule__Conditional__ExpressionAssignment_3 ) ) )
            // InternalAsple.g:1889:1: ( ( rule__Conditional__ExpressionAssignment_3 ) )
            {
            // InternalAsple.g:1889:1: ( ( rule__Conditional__ExpressionAssignment_3 ) )
            // InternalAsple.g:1890:2: ( rule__Conditional__ExpressionAssignment_3 )
            {
             before(grammarAccess.getConditionalAccess().getExpressionAssignment_3()); 
            // InternalAsple.g:1891:2: ( rule__Conditional__ExpressionAssignment_3 )
            // InternalAsple.g:1891:3: rule__Conditional__ExpressionAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__ExpressionAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getConditionalAccess().getExpressionAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__3__Impl"


    // $ANTLR start "rule__Conditional__Group__4"
    // InternalAsple.g:1899:1: rule__Conditional__Group__4 : rule__Conditional__Group__4__Impl rule__Conditional__Group__5 ;
    public final void rule__Conditional__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1903:1: ( rule__Conditional__Group__4__Impl rule__Conditional__Group__5 )
            // InternalAsple.g:1904:2: rule__Conditional__Group__4__Impl rule__Conditional__Group__5
            {
            pushFollow(FOLLOW_22);
            rule__Conditional__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__5();

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
    // $ANTLR end "rule__Conditional__Group__4"


    // $ANTLR start "rule__Conditional__Group__4__Impl"
    // InternalAsple.g:1911:1: rule__Conditional__Group__4__Impl : ( ')' ) ;
    public final void rule__Conditional__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1915:1: ( ( ')' ) )
            // InternalAsple.g:1916:1: ( ')' )
            {
            // InternalAsple.g:1916:1: ( ')' )
            // InternalAsple.g:1917:2: ')'
            {
             before(grammarAccess.getConditionalAccess().getRightParenthesisKeyword_4()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__4__Impl"


    // $ANTLR start "rule__Conditional__Group__5"
    // InternalAsple.g:1926:1: rule__Conditional__Group__5 : rule__Conditional__Group__5__Impl rule__Conditional__Group__6 ;
    public final void rule__Conditional__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1930:1: ( rule__Conditional__Group__5__Impl rule__Conditional__Group__6 )
            // InternalAsple.g:1931:2: rule__Conditional__Group__5__Impl rule__Conditional__Group__6
            {
            pushFollow(FOLLOW_23);
            rule__Conditional__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__6();

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
    // $ANTLR end "rule__Conditional__Group__5"


    // $ANTLR start "rule__Conditional__Group__5__Impl"
    // InternalAsple.g:1938:1: rule__Conditional__Group__5__Impl : ( '{' ) ;
    public final void rule__Conditional__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1942:1: ( ( '{' ) )
            // InternalAsple.g:1943:1: ( '{' )
            {
            // InternalAsple.g:1943:1: ( '{' )
            // InternalAsple.g:1944:2: '{'
            {
             before(grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__5__Impl"


    // $ANTLR start "rule__Conditional__Group__6"
    // InternalAsple.g:1953:1: rule__Conditional__Group__6 : rule__Conditional__Group__6__Impl rule__Conditional__Group__7 ;
    public final void rule__Conditional__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1957:1: ( rule__Conditional__Group__6__Impl rule__Conditional__Group__7 )
            // InternalAsple.g:1958:2: rule__Conditional__Group__6__Impl rule__Conditional__Group__7
            {
            pushFollow(FOLLOW_23);
            rule__Conditional__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__7();

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
    // $ANTLR end "rule__Conditional__Group__6"


    // $ANTLR start "rule__Conditional__Group__6__Impl"
    // InternalAsple.g:1965:1: rule__Conditional__Group__6__Impl : ( ( rule__Conditional__IfAssignment_6 )* ) ;
    public final void rule__Conditional__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1969:1: ( ( ( rule__Conditional__IfAssignment_6 )* ) )
            // InternalAsple.g:1970:1: ( ( rule__Conditional__IfAssignment_6 )* )
            {
            // InternalAsple.g:1970:1: ( ( rule__Conditional__IfAssignment_6 )* )
            // InternalAsple.g:1971:2: ( rule__Conditional__IfAssignment_6 )*
            {
             before(grammarAccess.getConditionalAccess().getIfAssignment_6()); 
            // InternalAsple.g:1972:2: ( rule__Conditional__IfAssignment_6 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID||LA21_0==33||(LA21_0>=39 && LA21_0<=40)||LA21_0==42) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalAsple.g:1972:3: rule__Conditional__IfAssignment_6
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Conditional__IfAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

             after(grammarAccess.getConditionalAccess().getIfAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__6__Impl"


    // $ANTLR start "rule__Conditional__Group__7"
    // InternalAsple.g:1980:1: rule__Conditional__Group__7 : rule__Conditional__Group__7__Impl rule__Conditional__Group__8 ;
    public final void rule__Conditional__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1984:1: ( rule__Conditional__Group__7__Impl rule__Conditional__Group__8 )
            // InternalAsple.g:1985:2: rule__Conditional__Group__7__Impl rule__Conditional__Group__8
            {
            pushFollow(FOLLOW_24);
            rule__Conditional__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group__8();

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
    // $ANTLR end "rule__Conditional__Group__7"


    // $ANTLR start "rule__Conditional__Group__7__Impl"
    // InternalAsple.g:1992:1: rule__Conditional__Group__7__Impl : ( '}' ) ;
    public final void rule__Conditional__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:1996:1: ( ( '}' ) )
            // InternalAsple.g:1997:1: ( '}' )
            {
            // InternalAsple.g:1997:1: ( '}' )
            // InternalAsple.g:1998:2: '}'
            {
             before(grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_7()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__7__Impl"


    // $ANTLR start "rule__Conditional__Group__8"
    // InternalAsple.g:2007:1: rule__Conditional__Group__8 : rule__Conditional__Group__8__Impl ;
    public final void rule__Conditional__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2011:1: ( rule__Conditional__Group__8__Impl )
            // InternalAsple.g:2012:2: rule__Conditional__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__Group__8__Impl();

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
    // $ANTLR end "rule__Conditional__Group__8"


    // $ANTLR start "rule__Conditional__Group__8__Impl"
    // InternalAsple.g:2018:1: rule__Conditional__Group__8__Impl : ( ( rule__Conditional__Group_8__0 )? ) ;
    public final void rule__Conditional__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2022:1: ( ( ( rule__Conditional__Group_8__0 )? ) )
            // InternalAsple.g:2023:1: ( ( rule__Conditional__Group_8__0 )? )
            {
            // InternalAsple.g:2023:1: ( ( rule__Conditional__Group_8__0 )? )
            // InternalAsple.g:2024:2: ( rule__Conditional__Group_8__0 )?
            {
             before(grammarAccess.getConditionalAccess().getGroup_8()); 
            // InternalAsple.g:2025:2: ( rule__Conditional__Group_8__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==38) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalAsple.g:2025:3: rule__Conditional__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Conditional__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getConditionalAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group__8__Impl"


    // $ANTLR start "rule__Conditional__Group_8__0"
    // InternalAsple.g:2034:1: rule__Conditional__Group_8__0 : rule__Conditional__Group_8__0__Impl rule__Conditional__Group_8__1 ;
    public final void rule__Conditional__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2038:1: ( rule__Conditional__Group_8__0__Impl rule__Conditional__Group_8__1 )
            // InternalAsple.g:2039:2: rule__Conditional__Group_8__0__Impl rule__Conditional__Group_8__1
            {
            pushFollow(FOLLOW_22);
            rule__Conditional__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group_8__1();

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
    // $ANTLR end "rule__Conditional__Group_8__0"


    // $ANTLR start "rule__Conditional__Group_8__0__Impl"
    // InternalAsple.g:2046:1: rule__Conditional__Group_8__0__Impl : ( 'else' ) ;
    public final void rule__Conditional__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2050:1: ( ( 'else' ) )
            // InternalAsple.g:2051:1: ( 'else' )
            {
            // InternalAsple.g:2051:1: ( 'else' )
            // InternalAsple.g:2052:2: 'else'
            {
             before(grammarAccess.getConditionalAccess().getElseKeyword_8_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getElseKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group_8__0__Impl"


    // $ANTLR start "rule__Conditional__Group_8__1"
    // InternalAsple.g:2061:1: rule__Conditional__Group_8__1 : rule__Conditional__Group_8__1__Impl rule__Conditional__Group_8__2 ;
    public final void rule__Conditional__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2065:1: ( rule__Conditional__Group_8__1__Impl rule__Conditional__Group_8__2 )
            // InternalAsple.g:2066:2: rule__Conditional__Group_8__1__Impl rule__Conditional__Group_8__2
            {
            pushFollow(FOLLOW_23);
            rule__Conditional__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group_8__2();

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
    // $ANTLR end "rule__Conditional__Group_8__1"


    // $ANTLR start "rule__Conditional__Group_8__1__Impl"
    // InternalAsple.g:2073:1: rule__Conditional__Group_8__1__Impl : ( '{' ) ;
    public final void rule__Conditional__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2077:1: ( ( '{' ) )
            // InternalAsple.g:2078:1: ( '{' )
            {
            // InternalAsple.g:2078:1: ( '{' )
            // InternalAsple.g:2079:2: '{'
            {
             before(grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_8_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getLeftCurlyBracketKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group_8__1__Impl"


    // $ANTLR start "rule__Conditional__Group_8__2"
    // InternalAsple.g:2088:1: rule__Conditional__Group_8__2 : rule__Conditional__Group_8__2__Impl rule__Conditional__Group_8__3 ;
    public final void rule__Conditional__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2092:1: ( rule__Conditional__Group_8__2__Impl rule__Conditional__Group_8__3 )
            // InternalAsple.g:2093:2: rule__Conditional__Group_8__2__Impl rule__Conditional__Group_8__3
            {
            pushFollow(FOLLOW_23);
            rule__Conditional__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Conditional__Group_8__3();

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
    // $ANTLR end "rule__Conditional__Group_8__2"


    // $ANTLR start "rule__Conditional__Group_8__2__Impl"
    // InternalAsple.g:2100:1: rule__Conditional__Group_8__2__Impl : ( ( rule__Conditional__ElseAssignment_8_2 )* ) ;
    public final void rule__Conditional__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2104:1: ( ( ( rule__Conditional__ElseAssignment_8_2 )* ) )
            // InternalAsple.g:2105:1: ( ( rule__Conditional__ElseAssignment_8_2 )* )
            {
            // InternalAsple.g:2105:1: ( ( rule__Conditional__ElseAssignment_8_2 )* )
            // InternalAsple.g:2106:2: ( rule__Conditional__ElseAssignment_8_2 )*
            {
             before(grammarAccess.getConditionalAccess().getElseAssignment_8_2()); 
            // InternalAsple.g:2107:2: ( rule__Conditional__ElseAssignment_8_2 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID||LA23_0==33||(LA23_0>=39 && LA23_0<=40)||LA23_0==42) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalAsple.g:2107:3: rule__Conditional__ElseAssignment_8_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Conditional__ElseAssignment_8_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getConditionalAccess().getElseAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group_8__2__Impl"


    // $ANTLR start "rule__Conditional__Group_8__3"
    // InternalAsple.g:2115:1: rule__Conditional__Group_8__3 : rule__Conditional__Group_8__3__Impl ;
    public final void rule__Conditional__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2119:1: ( rule__Conditional__Group_8__3__Impl )
            // InternalAsple.g:2120:2: rule__Conditional__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Conditional__Group_8__3__Impl();

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
    // $ANTLR end "rule__Conditional__Group_8__3"


    // $ANTLR start "rule__Conditional__Group_8__3__Impl"
    // InternalAsple.g:2126:1: rule__Conditional__Group_8__3__Impl : ( '}' ) ;
    public final void rule__Conditional__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2130:1: ( ( '}' ) )
            // InternalAsple.g:2131:1: ( '}' )
            {
            // InternalAsple.g:2131:1: ( '}' )
            // InternalAsple.g:2132:2: '}'
            {
             before(grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_8_3()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getConditionalAccess().getRightCurlyBracketKeyword_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__Group_8__3__Impl"


    // $ANTLR start "rule__Loop__Group_0__0"
    // InternalAsple.g:2142:1: rule__Loop__Group_0__0 : rule__Loop__Group_0__0__Impl rule__Loop__Group_0__1 ;
    public final void rule__Loop__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2146:1: ( rule__Loop__Group_0__0__Impl rule__Loop__Group_0__1 )
            // InternalAsple.g:2147:2: rule__Loop__Group_0__0__Impl rule__Loop__Group_0__1
            {
            pushFollow(FOLLOW_25);
            rule__Loop__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__1();

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
    // $ANTLR end "rule__Loop__Group_0__0"


    // $ANTLR start "rule__Loop__Group_0__0__Impl"
    // InternalAsple.g:2154:1: rule__Loop__Group_0__0__Impl : ( () ) ;
    public final void rule__Loop__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2158:1: ( ( () ) )
            // InternalAsple.g:2159:1: ( () )
            {
            // InternalAsple.g:2159:1: ( () )
            // InternalAsple.g:2160:2: ()
            {
             before(grammarAccess.getLoopAccess().getLoopAction_0_0()); 
            // InternalAsple.g:2161:2: ()
            // InternalAsple.g:2161:3: 
            {
            }

             after(grammarAccess.getLoopAccess().getLoopAction_0_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__0__Impl"


    // $ANTLR start "rule__Loop__Group_0__1"
    // InternalAsple.g:2169:1: rule__Loop__Group_0__1 : rule__Loop__Group_0__1__Impl rule__Loop__Group_0__2 ;
    public final void rule__Loop__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2173:1: ( rule__Loop__Group_0__1__Impl rule__Loop__Group_0__2 )
            // InternalAsple.g:2174:2: rule__Loop__Group_0__1__Impl rule__Loop__Group_0__2
            {
            pushFollow(FOLLOW_20);
            rule__Loop__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__2();

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
    // $ANTLR end "rule__Loop__Group_0__1"


    // $ANTLR start "rule__Loop__Group_0__1__Impl"
    // InternalAsple.g:2181:1: rule__Loop__Group_0__1__Impl : ( 'while' ) ;
    public final void rule__Loop__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2185:1: ( ( 'while' ) )
            // InternalAsple.g:2186:1: ( 'while' )
            {
            // InternalAsple.g:2186:1: ( 'while' )
            // InternalAsple.g:2187:2: 'while'
            {
             before(grammarAccess.getLoopAccess().getWhileKeyword_0_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getWhileKeyword_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__1__Impl"


    // $ANTLR start "rule__Loop__Group_0__2"
    // InternalAsple.g:2196:1: rule__Loop__Group_0__2 : rule__Loop__Group_0__2__Impl rule__Loop__Group_0__3 ;
    public final void rule__Loop__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2200:1: ( rule__Loop__Group_0__2__Impl rule__Loop__Group_0__3 )
            // InternalAsple.g:2201:2: rule__Loop__Group_0__2__Impl rule__Loop__Group_0__3
            {
            pushFollow(FOLLOW_18);
            rule__Loop__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__3();

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
    // $ANTLR end "rule__Loop__Group_0__2"


    // $ANTLR start "rule__Loop__Group_0__2__Impl"
    // InternalAsple.g:2208:1: rule__Loop__Group_0__2__Impl : ( '(' ) ;
    public final void rule__Loop__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2212:1: ( ( '(' ) )
            // InternalAsple.g:2213:1: ( '(' )
            {
            // InternalAsple.g:2213:1: ( '(' )
            // InternalAsple.g:2214:2: '('
            {
             before(grammarAccess.getLoopAccess().getLeftParenthesisKeyword_0_2()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLeftParenthesisKeyword_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__2__Impl"


    // $ANTLR start "rule__Loop__Group_0__3"
    // InternalAsple.g:2223:1: rule__Loop__Group_0__3 : rule__Loop__Group_0__3__Impl rule__Loop__Group_0__4 ;
    public final void rule__Loop__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2227:1: ( rule__Loop__Group_0__3__Impl rule__Loop__Group_0__4 )
            // InternalAsple.g:2228:2: rule__Loop__Group_0__3__Impl rule__Loop__Group_0__4
            {
            pushFollow(FOLLOW_21);
            rule__Loop__Group_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__4();

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
    // $ANTLR end "rule__Loop__Group_0__3"


    // $ANTLR start "rule__Loop__Group_0__3__Impl"
    // InternalAsple.g:2235:1: rule__Loop__Group_0__3__Impl : ( ( rule__Loop__ExpressionAssignment_0_3 ) ) ;
    public final void rule__Loop__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2239:1: ( ( ( rule__Loop__ExpressionAssignment_0_3 ) ) )
            // InternalAsple.g:2240:1: ( ( rule__Loop__ExpressionAssignment_0_3 ) )
            {
            // InternalAsple.g:2240:1: ( ( rule__Loop__ExpressionAssignment_0_3 ) )
            // InternalAsple.g:2241:2: ( rule__Loop__ExpressionAssignment_0_3 )
            {
             before(grammarAccess.getLoopAccess().getExpressionAssignment_0_3()); 
            // InternalAsple.g:2242:2: ( rule__Loop__ExpressionAssignment_0_3 )
            // InternalAsple.g:2242:3: rule__Loop__ExpressionAssignment_0_3
            {
            pushFollow(FOLLOW_2);
            rule__Loop__ExpressionAssignment_0_3();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getExpressionAssignment_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__3__Impl"


    // $ANTLR start "rule__Loop__Group_0__4"
    // InternalAsple.g:2250:1: rule__Loop__Group_0__4 : rule__Loop__Group_0__4__Impl rule__Loop__Group_0__5 ;
    public final void rule__Loop__Group_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2254:1: ( rule__Loop__Group_0__4__Impl rule__Loop__Group_0__5 )
            // InternalAsple.g:2255:2: rule__Loop__Group_0__4__Impl rule__Loop__Group_0__5
            {
            pushFollow(FOLLOW_22);
            rule__Loop__Group_0__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__5();

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
    // $ANTLR end "rule__Loop__Group_0__4"


    // $ANTLR start "rule__Loop__Group_0__4__Impl"
    // InternalAsple.g:2262:1: rule__Loop__Group_0__4__Impl : ( ')' ) ;
    public final void rule__Loop__Group_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2266:1: ( ( ')' ) )
            // InternalAsple.g:2267:1: ( ')' )
            {
            // InternalAsple.g:2267:1: ( ')' )
            // InternalAsple.g:2268:2: ')'
            {
             before(grammarAccess.getLoopAccess().getRightParenthesisKeyword_0_4()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getRightParenthesisKeyword_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__4__Impl"


    // $ANTLR start "rule__Loop__Group_0__5"
    // InternalAsple.g:2277:1: rule__Loop__Group_0__5 : rule__Loop__Group_0__5__Impl rule__Loop__Group_0__6 ;
    public final void rule__Loop__Group_0__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2281:1: ( rule__Loop__Group_0__5__Impl rule__Loop__Group_0__6 )
            // InternalAsple.g:2282:2: rule__Loop__Group_0__5__Impl rule__Loop__Group_0__6
            {
            pushFollow(FOLLOW_23);
            rule__Loop__Group_0__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__6();

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
    // $ANTLR end "rule__Loop__Group_0__5"


    // $ANTLR start "rule__Loop__Group_0__5__Impl"
    // InternalAsple.g:2289:1: rule__Loop__Group_0__5__Impl : ( '{' ) ;
    public final void rule__Loop__Group_0__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2293:1: ( ( '{' ) )
            // InternalAsple.g:2294:1: ( '{' )
            {
            // InternalAsple.g:2294:1: ( '{' )
            // InternalAsple.g:2295:2: '{'
            {
             before(grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_0_5()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_0_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__5__Impl"


    // $ANTLR start "rule__Loop__Group_0__6"
    // InternalAsple.g:2304:1: rule__Loop__Group_0__6 : rule__Loop__Group_0__6__Impl rule__Loop__Group_0__7 ;
    public final void rule__Loop__Group_0__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2308:1: ( rule__Loop__Group_0__6__Impl rule__Loop__Group_0__7 )
            // InternalAsple.g:2309:2: rule__Loop__Group_0__6__Impl rule__Loop__Group_0__7
            {
            pushFollow(FOLLOW_23);
            rule__Loop__Group_0__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__7();

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
    // $ANTLR end "rule__Loop__Group_0__6"


    // $ANTLR start "rule__Loop__Group_0__6__Impl"
    // InternalAsple.g:2316:1: rule__Loop__Group_0__6__Impl : ( ( rule__Loop__StatementsAssignment_0_6 )* ) ;
    public final void rule__Loop__Group_0__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2320:1: ( ( ( rule__Loop__StatementsAssignment_0_6 )* ) )
            // InternalAsple.g:2321:1: ( ( rule__Loop__StatementsAssignment_0_6 )* )
            {
            // InternalAsple.g:2321:1: ( ( rule__Loop__StatementsAssignment_0_6 )* )
            // InternalAsple.g:2322:2: ( rule__Loop__StatementsAssignment_0_6 )*
            {
             before(grammarAccess.getLoopAccess().getStatementsAssignment_0_6()); 
            // InternalAsple.g:2323:2: ( rule__Loop__StatementsAssignment_0_6 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||LA24_0==33||(LA24_0>=39 && LA24_0<=40)||LA24_0==42) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalAsple.g:2323:3: rule__Loop__StatementsAssignment_0_6
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Loop__StatementsAssignment_0_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getLoopAccess().getStatementsAssignment_0_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__6__Impl"


    // $ANTLR start "rule__Loop__Group_0__7"
    // InternalAsple.g:2331:1: rule__Loop__Group_0__7 : rule__Loop__Group_0__7__Impl ;
    public final void rule__Loop__Group_0__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2335:1: ( rule__Loop__Group_0__7__Impl )
            // InternalAsple.g:2336:2: rule__Loop__Group_0__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group_0__7__Impl();

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
    // $ANTLR end "rule__Loop__Group_0__7"


    // $ANTLR start "rule__Loop__Group_0__7__Impl"
    // InternalAsple.g:2342:1: rule__Loop__Group_0__7__Impl : ( '}' ) ;
    public final void rule__Loop__Group_0__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2346:1: ( ( '}' ) )
            // InternalAsple.g:2347:1: ( '}' )
            {
            // InternalAsple.g:2347:1: ( '}' )
            // InternalAsple.g:2348:2: '}'
            {
             before(grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_0_7()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_0_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_0__7__Impl"


    // $ANTLR start "rule__Loop__Group_1__0"
    // InternalAsple.g:2358:1: rule__Loop__Group_1__0 : rule__Loop__Group_1__0__Impl rule__Loop__Group_1__1 ;
    public final void rule__Loop__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2362:1: ( rule__Loop__Group_1__0__Impl rule__Loop__Group_1__1 )
            // InternalAsple.g:2363:2: rule__Loop__Group_1__0__Impl rule__Loop__Group_1__1
            {
            pushFollow(FOLLOW_22);
            rule__Loop__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__1();

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
    // $ANTLR end "rule__Loop__Group_1__0"


    // $ANTLR start "rule__Loop__Group_1__0__Impl"
    // InternalAsple.g:2370:1: rule__Loop__Group_1__0__Impl : ( 'repeat' ) ;
    public final void rule__Loop__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2374:1: ( ( 'repeat' ) )
            // InternalAsple.g:2375:1: ( 'repeat' )
            {
            // InternalAsple.g:2375:1: ( 'repeat' )
            // InternalAsple.g:2376:2: 'repeat'
            {
             before(grammarAccess.getLoopAccess().getRepeatKeyword_1_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getRepeatKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__0__Impl"


    // $ANTLR start "rule__Loop__Group_1__1"
    // InternalAsple.g:2385:1: rule__Loop__Group_1__1 : rule__Loop__Group_1__1__Impl rule__Loop__Group_1__2 ;
    public final void rule__Loop__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2389:1: ( rule__Loop__Group_1__1__Impl rule__Loop__Group_1__2 )
            // InternalAsple.g:2390:2: rule__Loop__Group_1__1__Impl rule__Loop__Group_1__2
            {
            pushFollow(FOLLOW_23);
            rule__Loop__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__2();

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
    // $ANTLR end "rule__Loop__Group_1__1"


    // $ANTLR start "rule__Loop__Group_1__1__Impl"
    // InternalAsple.g:2397:1: rule__Loop__Group_1__1__Impl : ( '{' ) ;
    public final void rule__Loop__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2401:1: ( ( '{' ) )
            // InternalAsple.g:2402:1: ( '{' )
            {
            // InternalAsple.g:2402:1: ( '{' )
            // InternalAsple.g:2403:2: '{'
            {
             before(grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLeftCurlyBracketKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__1__Impl"


    // $ANTLR start "rule__Loop__Group_1__2"
    // InternalAsple.g:2412:1: rule__Loop__Group_1__2 : rule__Loop__Group_1__2__Impl rule__Loop__Group_1__3 ;
    public final void rule__Loop__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2416:1: ( rule__Loop__Group_1__2__Impl rule__Loop__Group_1__3 )
            // InternalAsple.g:2417:2: rule__Loop__Group_1__2__Impl rule__Loop__Group_1__3
            {
            pushFollow(FOLLOW_23);
            rule__Loop__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__3();

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
    // $ANTLR end "rule__Loop__Group_1__2"


    // $ANTLR start "rule__Loop__Group_1__2__Impl"
    // InternalAsple.g:2424:1: rule__Loop__Group_1__2__Impl : ( ( rule__Loop__StatementsAssignment_1_2 )* ) ;
    public final void rule__Loop__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2428:1: ( ( ( rule__Loop__StatementsAssignment_1_2 )* ) )
            // InternalAsple.g:2429:1: ( ( rule__Loop__StatementsAssignment_1_2 )* )
            {
            // InternalAsple.g:2429:1: ( ( rule__Loop__StatementsAssignment_1_2 )* )
            // InternalAsple.g:2430:2: ( rule__Loop__StatementsAssignment_1_2 )*
            {
             before(grammarAccess.getLoopAccess().getStatementsAssignment_1_2()); 
            // InternalAsple.g:2431:2: ( rule__Loop__StatementsAssignment_1_2 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID||LA25_0==33||(LA25_0>=39 && LA25_0<=40)||LA25_0==42) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalAsple.g:2431:3: rule__Loop__StatementsAssignment_1_2
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Loop__StatementsAssignment_1_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getLoopAccess().getStatementsAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__2__Impl"


    // $ANTLR start "rule__Loop__Group_1__3"
    // InternalAsple.g:2439:1: rule__Loop__Group_1__3 : rule__Loop__Group_1__3__Impl rule__Loop__Group_1__4 ;
    public final void rule__Loop__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2443:1: ( rule__Loop__Group_1__3__Impl rule__Loop__Group_1__4 )
            // InternalAsple.g:2444:2: rule__Loop__Group_1__3__Impl rule__Loop__Group_1__4
            {
            pushFollow(FOLLOW_26);
            rule__Loop__Group_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__4();

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
    // $ANTLR end "rule__Loop__Group_1__3"


    // $ANTLR start "rule__Loop__Group_1__3__Impl"
    // InternalAsple.g:2451:1: rule__Loop__Group_1__3__Impl : ( '}' ) ;
    public final void rule__Loop__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2455:1: ( ( '}' ) )
            // InternalAsple.g:2456:1: ( '}' )
            {
            // InternalAsple.g:2456:1: ( '}' )
            // InternalAsple.g:2457:2: '}'
            {
             before(grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_1_3()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getRightCurlyBracketKeyword_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__3__Impl"


    // $ANTLR start "rule__Loop__Group_1__4"
    // InternalAsple.g:2466:1: rule__Loop__Group_1__4 : rule__Loop__Group_1__4__Impl rule__Loop__Group_1__5 ;
    public final void rule__Loop__Group_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2470:1: ( rule__Loop__Group_1__4__Impl rule__Loop__Group_1__5 )
            // InternalAsple.g:2471:2: rule__Loop__Group_1__4__Impl rule__Loop__Group_1__5
            {
            pushFollow(FOLLOW_20);
            rule__Loop__Group_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__5();

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
    // $ANTLR end "rule__Loop__Group_1__4"


    // $ANTLR start "rule__Loop__Group_1__4__Impl"
    // InternalAsple.g:2478:1: rule__Loop__Group_1__4__Impl : ( 'until' ) ;
    public final void rule__Loop__Group_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2482:1: ( ( 'until' ) )
            // InternalAsple.g:2483:1: ( 'until' )
            {
            // InternalAsple.g:2483:1: ( 'until' )
            // InternalAsple.g:2484:2: 'until'
            {
             before(grammarAccess.getLoopAccess().getUntilKeyword_1_4()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getUntilKeyword_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__4__Impl"


    // $ANTLR start "rule__Loop__Group_1__5"
    // InternalAsple.g:2493:1: rule__Loop__Group_1__5 : rule__Loop__Group_1__5__Impl rule__Loop__Group_1__6 ;
    public final void rule__Loop__Group_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2497:1: ( rule__Loop__Group_1__5__Impl rule__Loop__Group_1__6 )
            // InternalAsple.g:2498:2: rule__Loop__Group_1__5__Impl rule__Loop__Group_1__6
            {
            pushFollow(FOLLOW_18);
            rule__Loop__Group_1__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__6();

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
    // $ANTLR end "rule__Loop__Group_1__5"


    // $ANTLR start "rule__Loop__Group_1__5__Impl"
    // InternalAsple.g:2505:1: rule__Loop__Group_1__5__Impl : ( '(' ) ;
    public final void rule__Loop__Group_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2509:1: ( ( '(' ) )
            // InternalAsple.g:2510:1: ( '(' )
            {
            // InternalAsple.g:2510:1: ( '(' )
            // InternalAsple.g:2511:2: '('
            {
             before(grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1_5()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getLeftParenthesisKeyword_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__5__Impl"


    // $ANTLR start "rule__Loop__Group_1__6"
    // InternalAsple.g:2520:1: rule__Loop__Group_1__6 : rule__Loop__Group_1__6__Impl rule__Loop__Group_1__7 ;
    public final void rule__Loop__Group_1__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2524:1: ( rule__Loop__Group_1__6__Impl rule__Loop__Group_1__7 )
            // InternalAsple.g:2525:2: rule__Loop__Group_1__6__Impl rule__Loop__Group_1__7
            {
            pushFollow(FOLLOW_21);
            rule__Loop__Group_1__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__7();

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
    // $ANTLR end "rule__Loop__Group_1__6"


    // $ANTLR start "rule__Loop__Group_1__6__Impl"
    // InternalAsple.g:2532:1: rule__Loop__Group_1__6__Impl : ( ( rule__Loop__ExpressionAssignment_1_6 ) ) ;
    public final void rule__Loop__Group_1__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2536:1: ( ( ( rule__Loop__ExpressionAssignment_1_6 ) ) )
            // InternalAsple.g:2537:1: ( ( rule__Loop__ExpressionAssignment_1_6 ) )
            {
            // InternalAsple.g:2537:1: ( ( rule__Loop__ExpressionAssignment_1_6 ) )
            // InternalAsple.g:2538:2: ( rule__Loop__ExpressionAssignment_1_6 )
            {
             before(grammarAccess.getLoopAccess().getExpressionAssignment_1_6()); 
            // InternalAsple.g:2539:2: ( rule__Loop__ExpressionAssignment_1_6 )
            // InternalAsple.g:2539:3: rule__Loop__ExpressionAssignment_1_6
            {
            pushFollow(FOLLOW_2);
            rule__Loop__ExpressionAssignment_1_6();

            state._fsp--;


            }

             after(grammarAccess.getLoopAccess().getExpressionAssignment_1_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__6__Impl"


    // $ANTLR start "rule__Loop__Group_1__7"
    // InternalAsple.g:2547:1: rule__Loop__Group_1__7 : rule__Loop__Group_1__7__Impl ;
    public final void rule__Loop__Group_1__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2551:1: ( rule__Loop__Group_1__7__Impl )
            // InternalAsple.g:2552:2: rule__Loop__Group_1__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Loop__Group_1__7__Impl();

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
    // $ANTLR end "rule__Loop__Group_1__7"


    // $ANTLR start "rule__Loop__Group_1__7__Impl"
    // InternalAsple.g:2558:1: rule__Loop__Group_1__7__Impl : ( ')' ) ;
    public final void rule__Loop__Group_1__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2562:1: ( ( ')' ) )
            // InternalAsple.g:2563:1: ( ')' )
            {
            // InternalAsple.g:2563:1: ( ')' )
            // InternalAsple.g:2564:2: ')'
            {
             before(grammarAccess.getLoopAccess().getRightParenthesisKeyword_1_7()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLoopAccess().getRightParenthesisKeyword_1_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__Group_1__7__Impl"


    // $ANTLR start "rule__Transput__Group__0"
    // InternalAsple.g:2574:1: rule__Transput__Group__0 : rule__Transput__Group__0__Impl rule__Transput__Group__1 ;
    public final void rule__Transput__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2578:1: ( rule__Transput__Group__0__Impl rule__Transput__Group__1 )
            // InternalAsple.g:2579:2: rule__Transput__Group__0__Impl rule__Transput__Group__1
            {
            pushFollow(FOLLOW_27);
            rule__Transput__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transput__Group__1();

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
    // $ANTLR end "rule__Transput__Group__0"


    // $ANTLR start "rule__Transput__Group__0__Impl"
    // InternalAsple.g:2586:1: rule__Transput__Group__0__Impl : ( () ) ;
    public final void rule__Transput__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2590:1: ( ( () ) )
            // InternalAsple.g:2591:1: ( () )
            {
            // InternalAsple.g:2591:1: ( () )
            // InternalAsple.g:2592:2: ()
            {
             before(grammarAccess.getTransputAccess().getTransputAction_0()); 
            // InternalAsple.g:2593:2: ()
            // InternalAsple.g:2593:3: 
            {
            }

             after(grammarAccess.getTransputAccess().getTransputAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transput__Group__0__Impl"


    // $ANTLR start "rule__Transput__Group__1"
    // InternalAsple.g:2601:1: rule__Transput__Group__1 : rule__Transput__Group__1__Impl rule__Transput__Group__2 ;
    public final void rule__Transput__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2605:1: ( rule__Transput__Group__1__Impl rule__Transput__Group__2 )
            // InternalAsple.g:2606:2: rule__Transput__Group__1__Impl rule__Transput__Group__2
            {
            pushFollow(FOLLOW_28);
            rule__Transput__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transput__Group__2();

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
    // $ANTLR end "rule__Transput__Group__1"


    // $ANTLR start "rule__Transput__Group__1__Impl"
    // InternalAsple.g:2613:1: rule__Transput__Group__1__Impl : ( 'input' ) ;
    public final void rule__Transput__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2617:1: ( ( 'input' ) )
            // InternalAsple.g:2618:1: ( 'input' )
            {
            // InternalAsple.g:2618:1: ( 'input' )
            // InternalAsple.g:2619:2: 'input'
            {
             before(grammarAccess.getTransputAccess().getInputKeyword_1()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getTransputAccess().getInputKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transput__Group__1__Impl"


    // $ANTLR start "rule__Transput__Group__2"
    // InternalAsple.g:2628:1: rule__Transput__Group__2 : rule__Transput__Group__2__Impl rule__Transput__Group__3 ;
    public final void rule__Transput__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2632:1: ( rule__Transput__Group__2__Impl rule__Transput__Group__3 )
            // InternalAsple.g:2633:2: rule__Transput__Group__2__Impl rule__Transput__Group__3
            {
            pushFollow(FOLLOW_29);
            rule__Transput__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transput__Group__3();

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
    // $ANTLR end "rule__Transput__Group__2"


    // $ANTLR start "rule__Transput__Group__2__Impl"
    // InternalAsple.g:2640:1: rule__Transput__Group__2__Impl : ( ( rule__Transput__VarAssignment_2 ) ) ;
    public final void rule__Transput__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2644:1: ( ( ( rule__Transput__VarAssignment_2 ) ) )
            // InternalAsple.g:2645:1: ( ( rule__Transput__VarAssignment_2 ) )
            {
            // InternalAsple.g:2645:1: ( ( rule__Transput__VarAssignment_2 ) )
            // InternalAsple.g:2646:2: ( rule__Transput__VarAssignment_2 )
            {
             before(grammarAccess.getTransputAccess().getVarAssignment_2()); 
            // InternalAsple.g:2647:2: ( rule__Transput__VarAssignment_2 )
            // InternalAsple.g:2647:3: rule__Transput__VarAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Transput__VarAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransputAccess().getVarAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transput__Group__2__Impl"


    // $ANTLR start "rule__Transput__Group__3"
    // InternalAsple.g:2655:1: rule__Transput__Group__3 : rule__Transput__Group__3__Impl rule__Transput__Group__4 ;
    public final void rule__Transput__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2659:1: ( rule__Transput__Group__3__Impl rule__Transput__Group__4 )
            // InternalAsple.g:2660:2: rule__Transput__Group__3__Impl rule__Transput__Group__4
            {
            pushFollow(FOLLOW_18);
            rule__Transput__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Transput__Group__4();

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
    // $ANTLR end "rule__Transput__Group__3"


    // $ANTLR start "rule__Transput__Group__3__Impl"
    // InternalAsple.g:2667:1: rule__Transput__Group__3__Impl : ( 'output' ) ;
    public final void rule__Transput__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2671:1: ( ( 'output' ) )
            // InternalAsple.g:2672:1: ( 'output' )
            {
            // InternalAsple.g:2672:1: ( 'output' )
            // InternalAsple.g:2673:2: 'output'
            {
             before(grammarAccess.getTransputAccess().getOutputKeyword_3()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getTransputAccess().getOutputKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transput__Group__3__Impl"


    // $ANTLR start "rule__Transput__Group__4"
    // InternalAsple.g:2682:1: rule__Transput__Group__4 : rule__Transput__Group__4__Impl ;
    public final void rule__Transput__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2686:1: ( rule__Transput__Group__4__Impl )
            // InternalAsple.g:2687:2: rule__Transput__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Transput__Group__4__Impl();

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
    // $ANTLR end "rule__Transput__Group__4"


    // $ANTLR start "rule__Transput__Group__4__Impl"
    // InternalAsple.g:2693:1: rule__Transput__Group__4__Impl : ( ( rule__Transput__ExpressionAssignment_4 ) ) ;
    public final void rule__Transput__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2697:1: ( ( ( rule__Transput__ExpressionAssignment_4 ) ) )
            // InternalAsple.g:2698:1: ( ( rule__Transput__ExpressionAssignment_4 ) )
            {
            // InternalAsple.g:2698:1: ( ( rule__Transput__ExpressionAssignment_4 ) )
            // InternalAsple.g:2699:2: ( rule__Transput__ExpressionAssignment_4 )
            {
             before(grammarAccess.getTransputAccess().getExpressionAssignment_4()); 
            // InternalAsple.g:2700:2: ( rule__Transput__ExpressionAssignment_4 )
            // InternalAsple.g:2700:3: rule__Transput__ExpressionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Transput__ExpressionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTransputAccess().getExpressionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transput__Group__4__Impl"


    // $ANTLR start "rule__BinaryOperator__Group__0"
    // InternalAsple.g:2709:1: rule__BinaryOperator__Group__0 : rule__BinaryOperator__Group__0__Impl rule__BinaryOperator__Group__1 ;
    public final void rule__BinaryOperator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2713:1: ( rule__BinaryOperator__Group__0__Impl rule__BinaryOperator__Group__1 )
            // InternalAsple.g:2714:2: rule__BinaryOperator__Group__0__Impl rule__BinaryOperator__Group__1
            {
            pushFollow(FOLLOW_18);
            rule__BinaryOperator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryOperator__Group__1();

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
    // $ANTLR end "rule__BinaryOperator__Group__0"


    // $ANTLR start "rule__BinaryOperator__Group__0__Impl"
    // InternalAsple.g:2721:1: rule__BinaryOperator__Group__0__Impl : ( () ) ;
    public final void rule__BinaryOperator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2725:1: ( ( () ) )
            // InternalAsple.g:2726:1: ( () )
            {
            // InternalAsple.g:2726:1: ( () )
            // InternalAsple.g:2727:2: ()
            {
             before(grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0()); 
            // InternalAsple.g:2728:2: ()
            // InternalAsple.g:2728:3: 
            {
            }

             after(grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryOperator__Group__0__Impl"


    // $ANTLR start "rule__BinaryOperator__Group__1"
    // InternalAsple.g:2736:1: rule__BinaryOperator__Group__1 : rule__BinaryOperator__Group__1__Impl rule__BinaryOperator__Group__2 ;
    public final void rule__BinaryOperator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2740:1: ( rule__BinaryOperator__Group__1__Impl rule__BinaryOperator__Group__2 )
            // InternalAsple.g:2741:2: rule__BinaryOperator__Group__1__Impl rule__BinaryOperator__Group__2
            {
            pushFollow(FOLLOW_30);
            rule__BinaryOperator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryOperator__Group__2();

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
    // $ANTLR end "rule__BinaryOperator__Group__1"


    // $ANTLR start "rule__BinaryOperator__Group__1__Impl"
    // InternalAsple.g:2748:1: rule__BinaryOperator__Group__1__Impl : ( ( rule__BinaryOperator__LeftAssignment_1 ) ) ;
    public final void rule__BinaryOperator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2752:1: ( ( ( rule__BinaryOperator__LeftAssignment_1 ) ) )
            // InternalAsple.g:2753:1: ( ( rule__BinaryOperator__LeftAssignment_1 ) )
            {
            // InternalAsple.g:2753:1: ( ( rule__BinaryOperator__LeftAssignment_1 ) )
            // InternalAsple.g:2754:2: ( rule__BinaryOperator__LeftAssignment_1 )
            {
             before(grammarAccess.getBinaryOperatorAccess().getLeftAssignment_1()); 
            // InternalAsple.g:2755:2: ( rule__BinaryOperator__LeftAssignment_1 )
            // InternalAsple.g:2755:3: rule__BinaryOperator__LeftAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__BinaryOperator__LeftAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getBinaryOperatorAccess().getLeftAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryOperator__Group__1__Impl"


    // $ANTLR start "rule__BinaryOperator__Group__2"
    // InternalAsple.g:2763:1: rule__BinaryOperator__Group__2 : rule__BinaryOperator__Group__2__Impl rule__BinaryOperator__Group__3 ;
    public final void rule__BinaryOperator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2767:1: ( rule__BinaryOperator__Group__2__Impl rule__BinaryOperator__Group__3 )
            // InternalAsple.g:2768:2: rule__BinaryOperator__Group__2__Impl rule__BinaryOperator__Group__3
            {
            pushFollow(FOLLOW_18);
            rule__BinaryOperator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BinaryOperator__Group__3();

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
    // $ANTLR end "rule__BinaryOperator__Group__2"


    // $ANTLR start "rule__BinaryOperator__Group__2__Impl"
    // InternalAsple.g:2775:1: rule__BinaryOperator__Group__2__Impl : ( ( rule__BinaryOperator__OperatorAssignment_2 ) ) ;
    public final void rule__BinaryOperator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2779:1: ( ( ( rule__BinaryOperator__OperatorAssignment_2 ) ) )
            // InternalAsple.g:2780:1: ( ( rule__BinaryOperator__OperatorAssignment_2 ) )
            {
            // InternalAsple.g:2780:1: ( ( rule__BinaryOperator__OperatorAssignment_2 ) )
            // InternalAsple.g:2781:2: ( rule__BinaryOperator__OperatorAssignment_2 )
            {
             before(grammarAccess.getBinaryOperatorAccess().getOperatorAssignment_2()); 
            // InternalAsple.g:2782:2: ( rule__BinaryOperator__OperatorAssignment_2 )
            // InternalAsple.g:2782:3: rule__BinaryOperator__OperatorAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BinaryOperator__OperatorAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBinaryOperatorAccess().getOperatorAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryOperator__Group__2__Impl"


    // $ANTLR start "rule__BinaryOperator__Group__3"
    // InternalAsple.g:2790:1: rule__BinaryOperator__Group__3 : rule__BinaryOperator__Group__3__Impl ;
    public final void rule__BinaryOperator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2794:1: ( rule__BinaryOperator__Group__3__Impl )
            // InternalAsple.g:2795:2: rule__BinaryOperator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BinaryOperator__Group__3__Impl();

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
    // $ANTLR end "rule__BinaryOperator__Group__3"


    // $ANTLR start "rule__BinaryOperator__Group__3__Impl"
    // InternalAsple.g:2801:1: rule__BinaryOperator__Group__3__Impl : ( ( rule__BinaryOperator__RightAssignment_3 ) ) ;
    public final void rule__BinaryOperator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2805:1: ( ( ( rule__BinaryOperator__RightAssignment_3 ) ) )
            // InternalAsple.g:2806:1: ( ( rule__BinaryOperator__RightAssignment_3 ) )
            {
            // InternalAsple.g:2806:1: ( ( rule__BinaryOperator__RightAssignment_3 ) )
            // InternalAsple.g:2807:2: ( rule__BinaryOperator__RightAssignment_3 )
            {
             before(grammarAccess.getBinaryOperatorAccess().getRightAssignment_3()); 
            // InternalAsple.g:2808:2: ( rule__BinaryOperator__RightAssignment_3 )
            // InternalAsple.g:2808:3: rule__BinaryOperator__RightAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__BinaryOperator__RightAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getBinaryOperatorAccess().getRightAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryOperator__Group__3__Impl"


    // $ANTLR start "rule__Program__DeclarationsAssignment_2_0"
    // InternalAsple.g:2817:1: rule__Program__DeclarationsAssignment_2_0 : ( ruleDeclaration ) ;
    public final void rule__Program__DeclarationsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2821:1: ( ( ruleDeclaration ) )
            // InternalAsple.g:2822:2: ( ruleDeclaration )
            {
            // InternalAsple.g:2822:2: ( ruleDeclaration )
            // InternalAsple.g:2823:3: ruleDeclaration
            {
             before(grammarAccess.getProgramAccess().getDeclarationsDeclarationParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleDeclaration();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getDeclarationsDeclarationParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__DeclarationsAssignment_2_0"


    // $ANTLR start "rule__Program__StatementsAssignment_3"
    // InternalAsple.g:2832:1: rule__Program__StatementsAssignment_3 : ( ruleStatement ) ;
    public final void rule__Program__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2836:1: ( ( ruleStatement ) )
            // InternalAsple.g:2837:2: ( ruleStatement )
            {
            // InternalAsple.g:2837:2: ( ruleStatement )
            // InternalAsple.g:2838:3: ruleStatement
            {
             before(grammarAccess.getProgramAccess().getStatementsStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getStatementsStatementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__StatementsAssignment_3"


    // $ANTLR start "rule__Declaration__RefAssignment_1"
    // InternalAsple.g:2847:1: rule__Declaration__RefAssignment_1 : ( ( 'ref' ) ) ;
    public final void rule__Declaration__RefAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2851:1: ( ( ( 'ref' ) ) )
            // InternalAsple.g:2852:2: ( ( 'ref' ) )
            {
            // InternalAsple.g:2852:2: ( ( 'ref' ) )
            // InternalAsple.g:2853:3: ( 'ref' )
            {
             before(grammarAccess.getDeclarationAccess().getRefRefKeyword_1_0()); 
            // InternalAsple.g:2854:3: ( 'ref' )
            // InternalAsple.g:2855:4: 'ref'
            {
             before(grammarAccess.getDeclarationAccess().getRefRefKeyword_1_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getDeclarationAccess().getRefRefKeyword_1_0()); 

            }

             after(grammarAccess.getDeclarationAccess().getRefRefKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__RefAssignment_1"


    // $ANTLR start "rule__Declaration__ModeAssignment_2"
    // InternalAsple.g:2866:1: rule__Declaration__ModeAssignment_2 : ( ruleMode ) ;
    public final void rule__Declaration__ModeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2870:1: ( ( ruleMode ) )
            // InternalAsple.g:2871:2: ( ruleMode )
            {
            // InternalAsple.g:2871:2: ( ruleMode )
            // InternalAsple.g:2872:3: ruleMode
            {
             before(grammarAccess.getDeclarationAccess().getModeModeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMode();

            state._fsp--;

             after(grammarAccess.getDeclarationAccess().getModeModeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__ModeAssignment_2"


    // $ANTLR start "rule__Declaration__IdentifiersAssignment_3"
    // InternalAsple.g:2881:1: rule__Declaration__IdentifiersAssignment_3 : ( ruleIdentifier ) ;
    public final void rule__Declaration__IdentifiersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2885:1: ( ( ruleIdentifier ) )
            // InternalAsple.g:2886:2: ( ruleIdentifier )
            {
            // InternalAsple.g:2886:2: ( ruleIdentifier )
            // InternalAsple.g:2887:3: ruleIdentifier
            {
             before(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__IdentifiersAssignment_3"


    // $ANTLR start "rule__Declaration__IdentifiersAssignment_4_1"
    // InternalAsple.g:2896:1: rule__Declaration__IdentifiersAssignment_4_1 : ( ruleIdentifier ) ;
    public final void rule__Declaration__IdentifiersAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2900:1: ( ( ruleIdentifier ) )
            // InternalAsple.g:2901:2: ( ruleIdentifier )
            {
            // InternalAsple.g:2901:2: ( ruleIdentifier )
            // InternalAsple.g:2902:3: ruleIdentifier
            {
             before(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleIdentifier();

            state._fsp--;

             after(grammarAccess.getDeclarationAccess().getIdentifiersIdentifierParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Declaration__IdentifiersAssignment_4_1"


    // $ANTLR start "rule__Identifier__NameAssignment_1"
    // InternalAsple.g:2911:1: rule__Identifier__NameAssignment_1 : ( ruleEString ) ;
    public final void rule__Identifier__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2915:1: ( ( ruleEString ) )
            // InternalAsple.g:2916:2: ( ruleEString )
            {
            // InternalAsple.g:2916:2: ( ruleEString )
            // InternalAsple.g:2917:3: ruleEString
            {
             before(grammarAccess.getIdentifierAccess().getNameEStringParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getIdentifierAccess().getNameEStringParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Identifier__NameAssignment_1"


    // $ANTLR start "rule__Integer__ValueAssignment_1"
    // InternalAsple.g:2926:1: rule__Integer__ValueAssignment_1 : ( ruleEInt ) ;
    public final void rule__Integer__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2930:1: ( ( ruleEInt ) )
            // InternalAsple.g:2931:2: ( ruleEInt )
            {
            // InternalAsple.g:2931:2: ( ruleEInt )
            // InternalAsple.g:2932:3: ruleEInt
            {
             before(grammarAccess.getIntegerAccess().getValueEIntParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getIntegerAccess().getValueEIntParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Integer__ValueAssignment_1"


    // $ANTLR start "rule__Boolean__ValueAssignment_1"
    // InternalAsple.g:2941:1: rule__Boolean__ValueAssignment_1 : ( ruleEBoolean ) ;
    public final void rule__Boolean__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2945:1: ( ( ruleEBoolean ) )
            // InternalAsple.g:2946:2: ( ruleEBoolean )
            {
            // InternalAsple.g:2946:2: ( ruleEBoolean )
            // InternalAsple.g:2947:3: ruleEBoolean
            {
             before(grammarAccess.getBooleanAccess().getValueEBooleanParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEBoolean();

            state._fsp--;

             after(grammarAccess.getBooleanAccess().getValueEBooleanParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Boolean__ValueAssignment_1"


    // $ANTLR start "rule__Double__ValueAssignment_1"
    // InternalAsple.g:2956:1: rule__Double__ValueAssignment_1 : ( ruleEDouble ) ;
    public final void rule__Double__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2960:1: ( ( ruleEDouble ) )
            // InternalAsple.g:2961:2: ( ruleEDouble )
            {
            // InternalAsple.g:2961:2: ( ruleEDouble )
            // InternalAsple.g:2962:3: ruleEDouble
            {
             before(grammarAccess.getDoubleAccess().getValueEDoubleParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getDoubleAccess().getValueEDoubleParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Double__ValueAssignment_1"


    // $ANTLR start "rule__Assignment__VarAssignment_0"
    // InternalAsple.g:2971:1: rule__Assignment__VarAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Assignment__VarAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2975:1: ( ( ( RULE_ID ) ) )
            // InternalAsple.g:2976:2: ( ( RULE_ID ) )
            {
            // InternalAsple.g:2976:2: ( ( RULE_ID ) )
            // InternalAsple.g:2977:3: ( RULE_ID )
            {
             before(grammarAccess.getAssignmentAccess().getVarIdentifierCrossReference_0_0()); 
            // InternalAsple.g:2978:3: ( RULE_ID )
            // InternalAsple.g:2979:4: RULE_ID
            {
             before(grammarAccess.getAssignmentAccess().getVarIdentifierIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAssignmentAccess().getVarIdentifierIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getAssignmentAccess().getVarIdentifierCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__VarAssignment_0"


    // $ANTLR start "rule__Assignment__ValueAssignment_2"
    // InternalAsple.g:2990:1: rule__Assignment__ValueAssignment_2 : ( ruleExpression ) ;
    public final void rule__Assignment__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:2994:1: ( ( ruleExpression ) )
            // InternalAsple.g:2995:2: ( ruleExpression )
            {
            // InternalAsple.g:2995:2: ( ruleExpression )
            // InternalAsple.g:2996:3: ruleExpression
            {
             before(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getAssignmentAccess().getValueExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Assignment__ValueAssignment_2"


    // $ANTLR start "rule__Conditional__ExpressionAssignment_3"
    // InternalAsple.g:3005:1: rule__Conditional__ExpressionAssignment_3 : ( ruleExpression ) ;
    public final void rule__Conditional__ExpressionAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3009:1: ( ( ruleExpression ) )
            // InternalAsple.g:3010:2: ( ruleExpression )
            {
            // InternalAsple.g:3010:2: ( ruleExpression )
            // InternalAsple.g:3011:3: ruleExpression
            {
             before(grammarAccess.getConditionalAccess().getExpressionExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getConditionalAccess().getExpressionExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__ExpressionAssignment_3"


    // $ANTLR start "rule__Conditional__IfAssignment_6"
    // InternalAsple.g:3020:1: rule__Conditional__IfAssignment_6 : ( ruleStatement ) ;
    public final void rule__Conditional__IfAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3024:1: ( ( ruleStatement ) )
            // InternalAsple.g:3025:2: ( ruleStatement )
            {
            // InternalAsple.g:3025:2: ( ruleStatement )
            // InternalAsple.g:3026:3: ruleStatement
            {
             before(grammarAccess.getConditionalAccess().getIfStatementParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getConditionalAccess().getIfStatementParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__IfAssignment_6"


    // $ANTLR start "rule__Conditional__ElseAssignment_8_2"
    // InternalAsple.g:3035:1: rule__Conditional__ElseAssignment_8_2 : ( ruleStatement ) ;
    public final void rule__Conditional__ElseAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3039:1: ( ( ruleStatement ) )
            // InternalAsple.g:3040:2: ( ruleStatement )
            {
            // InternalAsple.g:3040:2: ( ruleStatement )
            // InternalAsple.g:3041:3: ruleStatement
            {
             before(grammarAccess.getConditionalAccess().getElseStatementParserRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getConditionalAccess().getElseStatementParserRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Conditional__ElseAssignment_8_2"


    // $ANTLR start "rule__Loop__ExpressionAssignment_0_3"
    // InternalAsple.g:3050:1: rule__Loop__ExpressionAssignment_0_3 : ( ruleExpression ) ;
    public final void rule__Loop__ExpressionAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3054:1: ( ( ruleExpression ) )
            // InternalAsple.g:3055:2: ( ruleExpression )
            {
            // InternalAsple.g:3055:2: ( ruleExpression )
            // InternalAsple.g:3056:3: ruleExpression
            {
             before(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__ExpressionAssignment_0_3"


    // $ANTLR start "rule__Loop__StatementsAssignment_0_6"
    // InternalAsple.g:3065:1: rule__Loop__StatementsAssignment_0_6 : ( ruleStatement ) ;
    public final void rule__Loop__StatementsAssignment_0_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3069:1: ( ( ruleStatement ) )
            // InternalAsple.g:3070:2: ( ruleStatement )
            {
            // InternalAsple.g:3070:2: ( ruleStatement )
            // InternalAsple.g:3071:3: ruleStatement
            {
             before(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_0_6_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_0_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__StatementsAssignment_0_6"


    // $ANTLR start "rule__Loop__StatementsAssignment_1_2"
    // InternalAsple.g:3080:1: rule__Loop__StatementsAssignment_1_2 : ( ruleStatement ) ;
    public final void rule__Loop__StatementsAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3084:1: ( ( ruleStatement ) )
            // InternalAsple.g:3085:2: ( ruleStatement )
            {
            // InternalAsple.g:3085:2: ( ruleStatement )
            // InternalAsple.g:3086:3: ruleStatement
            {
             before(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_2);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getLoopAccess().getStatementsStatementParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__StatementsAssignment_1_2"


    // $ANTLR start "rule__Loop__ExpressionAssignment_1_6"
    // InternalAsple.g:3095:1: rule__Loop__ExpressionAssignment_1_6 : ( ruleExpression ) ;
    public final void rule__Loop__ExpressionAssignment_1_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3099:1: ( ( ruleExpression ) )
            // InternalAsple.g:3100:2: ( ruleExpression )
            {
            // InternalAsple.g:3100:2: ( ruleExpression )
            // InternalAsple.g:3101:3: ruleExpression
            {
             before(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_1_6_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getLoopAccess().getExpressionExpressionParserRuleCall_1_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Loop__ExpressionAssignment_1_6"


    // $ANTLR start "rule__Transput__VarAssignment_2"
    // InternalAsple.g:3110:1: rule__Transput__VarAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Transput__VarAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3114:1: ( ( ( RULE_ID ) ) )
            // InternalAsple.g:3115:2: ( ( RULE_ID ) )
            {
            // InternalAsple.g:3115:2: ( ( RULE_ID ) )
            // InternalAsple.g:3116:3: ( RULE_ID )
            {
             before(grammarAccess.getTransputAccess().getVarIdentifierCrossReference_2_0()); 
            // InternalAsple.g:3117:3: ( RULE_ID )
            // InternalAsple.g:3118:4: RULE_ID
            {
             before(grammarAccess.getTransputAccess().getVarIdentifierIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTransputAccess().getVarIdentifierIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getTransputAccess().getVarIdentifierCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transput__VarAssignment_2"


    // $ANTLR start "rule__Transput__ExpressionAssignment_4"
    // InternalAsple.g:3129:1: rule__Transput__ExpressionAssignment_4 : ( ruleExpression ) ;
    public final void rule__Transput__ExpressionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3133:1: ( ( ruleExpression ) )
            // InternalAsple.g:3134:2: ( ruleExpression )
            {
            // InternalAsple.g:3134:2: ( ruleExpression )
            // InternalAsple.g:3135:3: ruleExpression
            {
             before(grammarAccess.getTransputAccess().getExpressionExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getTransputAccess().getExpressionExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transput__ExpressionAssignment_4"


    // $ANTLR start "rule__BinaryOperator__LeftAssignment_1"
    // InternalAsple.g:3144:1: rule__BinaryOperator__LeftAssignment_1 : ( rulePrimary ) ;
    public final void rule__BinaryOperator__LeftAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3148:1: ( ( rulePrimary ) )
            // InternalAsple.g:3149:2: ( rulePrimary )
            {
            // InternalAsple.g:3149:2: ( rulePrimary )
            // InternalAsple.g:3150:3: rulePrimary
            {
             before(grammarAccess.getBinaryOperatorAccess().getLeftPrimaryParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            rulePrimary();

            state._fsp--;

             after(grammarAccess.getBinaryOperatorAccess().getLeftPrimaryParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryOperator__LeftAssignment_1"


    // $ANTLR start "rule__BinaryOperator__OperatorAssignment_2"
    // InternalAsple.g:3159:1: rule__BinaryOperator__OperatorAssignment_2 : ( ( rule__BinaryOperator__OperatorAlternatives_2_0 ) ) ;
    public final void rule__BinaryOperator__OperatorAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3163:1: ( ( ( rule__BinaryOperator__OperatorAlternatives_2_0 ) ) )
            // InternalAsple.g:3164:2: ( ( rule__BinaryOperator__OperatorAlternatives_2_0 ) )
            {
            // InternalAsple.g:3164:2: ( ( rule__BinaryOperator__OperatorAlternatives_2_0 ) )
            // InternalAsple.g:3165:3: ( rule__BinaryOperator__OperatorAlternatives_2_0 )
            {
             before(grammarAccess.getBinaryOperatorAccess().getOperatorAlternatives_2_0()); 
            // InternalAsple.g:3166:3: ( rule__BinaryOperator__OperatorAlternatives_2_0 )
            // InternalAsple.g:3166:4: rule__BinaryOperator__OperatorAlternatives_2_0
            {
            pushFollow(FOLLOW_2);
            rule__BinaryOperator__OperatorAlternatives_2_0();

            state._fsp--;


            }

             after(grammarAccess.getBinaryOperatorAccess().getOperatorAlternatives_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryOperator__OperatorAssignment_2"


    // $ANTLR start "rule__BinaryOperator__RightAssignment_3"
    // InternalAsple.g:3174:1: rule__BinaryOperator__RightAssignment_3 : ( ruleExpression ) ;
    public final void rule__BinaryOperator__RightAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalAsple.g:3178:1: ( ( ruleExpression ) )
            // InternalAsple.g:3179:2: ( ruleExpression )
            {
            // InternalAsple.g:3179:2: ( ruleExpression )
            // InternalAsple.g:3180:3: ruleExpression
            {
             before(grammarAccess.getBinaryOperatorAccess().getRightExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleExpression();

            state._fsp--;

             after(grammarAccess.getBinaryOperatorAccess().getRightExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BinaryOperator__RightAssignment_3"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String dfa_1s = "\17\uffff";
    static final String dfa_2s = "\1\uffff\2\11\1\uffff\3\11\3\uffff\1\11\3\uffff\1\11";
    static final String dfa_3s = "\1\4\2\5\1\6\3\5\1\6\2\uffff\1\5\3\6\1\5";
    static final String dfa_4s = "\1\37\2\52\1\37\3\52\1\6\2\uffff\1\52\2\20\1\6\1\52";
    static final String dfa_5s = "\10\uffff\1\2\1\1\5\uffff";
    static final String dfa_6s = "\17\uffff}>";
    static final String[] dfa_7s = {
            "\1\1\1\2\1\4\4\uffff\1\5\1\6\3\uffff\1\3\16\uffff\1\7",
            "\1\11\11\uffff\11\10\4\uffff\2\11\3\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11",
            "\1\11\11\uffff\11\10\4\uffff\2\11\3\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11",
            "\1\4\30\uffff\1\7",
            "\1\11\11\uffff\11\10\4\uffff\2\11\1\uffff\1\7\1\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11",
            "\1\11\11\uffff\11\10\4\uffff\2\11\3\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11",
            "\1\11\11\uffff\11\10\4\uffff\2\11\3\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11",
            "\1\12",
            "",
            "",
            "\1\11\7\uffff\1\13\1\14\11\10\4\uffff\2\11\3\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11",
            "\1\16\11\uffff\1\15",
            "\1\16\11\uffff\1\15",
            "\1\16",
            "\1\11\11\uffff\11\10\4\uffff\2\11\3\uffff\1\11\1\uffff\1\11\1\uffff\1\11\1\uffff\2\11\1\uffff\1\11"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "687:1: rule__Expression__Alternatives : ( ( rulePrimary ) | ( ruleBinaryOperator ) );";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000158217000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000100007000032L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000058200000022L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000100007000030L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000080000040L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000010040L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000080010040L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000100087011870L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x000005A200000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000058200000020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000FF8000L});

}