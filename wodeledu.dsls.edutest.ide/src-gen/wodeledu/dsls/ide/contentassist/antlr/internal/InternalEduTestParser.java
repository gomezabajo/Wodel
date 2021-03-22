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
import wodeledu.dsls.services.EduTestGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalEduTestParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'yes'", "'no'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'", "'AlternativeResponse'", "'{'", "'}'", "','", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'MatchPairs'", "'MissingWords'", "'navigation'", "'='", "'retry'", "'weighted'", "'penalty'", "'order'", "'mode'", "'description'", "'for'", "'('", "')'", "'-'", "'.'", "'%text'"
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


        public InternalEduTestParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalEduTestParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalEduTestParser.tokenNames; }
    public String getGrammarFileName() { return "InternalEduTest.g"; }


    	private EduTestGrammarAccess grammarAccess;

    	public void setGrammarAccess(EduTestGrammarAccess grammarAccess) {
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
    // InternalEduTest.g:53:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // InternalEduTest.g:54:1: ( ruleProgram EOF )
            // InternalEduTest.g:55:1: ruleProgram EOF
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
    // InternalEduTest.g:62:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:66:2: ( ( ( rule__Program__Group__0 ) ) )
            // InternalEduTest.g:67:2: ( ( rule__Program__Group__0 ) )
            {
            // InternalEduTest.g:67:2: ( ( rule__Program__Group__0 ) )
            // InternalEduTest.g:68:3: ( rule__Program__Group__0 )
            {
             before(grammarAccess.getProgramAccess().getGroup()); 
            // InternalEduTest.g:69:3: ( rule__Program__Group__0 )
            // InternalEduTest.g:69:4: rule__Program__Group__0
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


    // $ANTLR start "entryRuleMutatorTests"
    // InternalEduTest.g:78:1: entryRuleMutatorTests : ruleMutatorTests EOF ;
    public final void entryRuleMutatorTests() throws RecognitionException {
        try {
            // InternalEduTest.g:79:1: ( ruleMutatorTests EOF )
            // InternalEduTest.g:80:1: ruleMutatorTests EOF
            {
             before(grammarAccess.getMutatorTestsRule()); 
            pushFollow(FOLLOW_1);
            ruleMutatorTests();

            state._fsp--;

             after(grammarAccess.getMutatorTestsRule()); 
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
    // $ANTLR end "entryRuleMutatorTests"


    // $ANTLR start "ruleMutatorTests"
    // InternalEduTest.g:87:1: ruleMutatorTests : ( ( rule__MutatorTests__Alternatives ) ) ;
    public final void ruleMutatorTests() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:91:2: ( ( ( rule__MutatorTests__Alternatives ) ) )
            // InternalEduTest.g:92:2: ( ( rule__MutatorTests__Alternatives ) )
            {
            // InternalEduTest.g:92:2: ( ( rule__MutatorTests__Alternatives ) )
            // InternalEduTest.g:93:3: ( rule__MutatorTests__Alternatives )
            {
             before(grammarAccess.getMutatorTestsAccess().getAlternatives()); 
            // InternalEduTest.g:94:3: ( rule__MutatorTests__Alternatives )
            // InternalEduTest.g:94:4: rule__MutatorTests__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__MutatorTests__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getMutatorTestsAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMutatorTests"


    // $ANTLR start "entryRuleAlternativeResponse"
    // InternalEduTest.g:103:1: entryRuleAlternativeResponse : ruleAlternativeResponse EOF ;
    public final void entryRuleAlternativeResponse() throws RecognitionException {
        try {
            // InternalEduTest.g:104:1: ( ruleAlternativeResponse EOF )
            // InternalEduTest.g:105:1: ruleAlternativeResponse EOF
            {
             before(grammarAccess.getAlternativeResponseRule()); 
            pushFollow(FOLLOW_1);
            ruleAlternativeResponse();

            state._fsp--;

             after(grammarAccess.getAlternativeResponseRule()); 
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
    // $ANTLR end "entryRuleAlternativeResponse"


    // $ANTLR start "ruleAlternativeResponse"
    // InternalEduTest.g:112:1: ruleAlternativeResponse : ( ( rule__AlternativeResponse__Group__0 ) ) ;
    public final void ruleAlternativeResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:116:2: ( ( ( rule__AlternativeResponse__Group__0 ) ) )
            // InternalEduTest.g:117:2: ( ( rule__AlternativeResponse__Group__0 ) )
            {
            // InternalEduTest.g:117:2: ( ( rule__AlternativeResponse__Group__0 ) )
            // InternalEduTest.g:118:3: ( rule__AlternativeResponse__Group__0 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup()); 
            // InternalEduTest.g:119:3: ( rule__AlternativeResponse__Group__0 )
            // InternalEduTest.g:119:4: rule__AlternativeResponse__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeResponseAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternativeResponse"


    // $ANTLR start "entryRuleMultiChoiceDiagram"
    // InternalEduTest.g:128:1: entryRuleMultiChoiceDiagram : ruleMultiChoiceDiagram EOF ;
    public final void entryRuleMultiChoiceDiagram() throws RecognitionException {
        try {
            // InternalEduTest.g:129:1: ( ruleMultiChoiceDiagram EOF )
            // InternalEduTest.g:130:1: ruleMultiChoiceDiagram EOF
            {
             before(grammarAccess.getMultiChoiceDiagramRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiChoiceDiagram();

            state._fsp--;

             after(grammarAccess.getMultiChoiceDiagramRule()); 
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
    // $ANTLR end "entryRuleMultiChoiceDiagram"


    // $ANTLR start "ruleMultiChoiceDiagram"
    // InternalEduTest.g:137:1: ruleMultiChoiceDiagram : ( ( rule__MultiChoiceDiagram__Group__0 ) ) ;
    public final void ruleMultiChoiceDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:141:2: ( ( ( rule__MultiChoiceDiagram__Group__0 ) ) )
            // InternalEduTest.g:142:2: ( ( rule__MultiChoiceDiagram__Group__0 ) )
            {
            // InternalEduTest.g:142:2: ( ( rule__MultiChoiceDiagram__Group__0 ) )
            // InternalEduTest.g:143:3: ( rule__MultiChoiceDiagram__Group__0 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup()); 
            // InternalEduTest.g:144:3: ( rule__MultiChoiceDiagram__Group__0 )
            // InternalEduTest.g:144:4: rule__MultiChoiceDiagram__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiChoiceDiagram"


    // $ANTLR start "entryRuleMultiChoiceEmendation"
    // InternalEduTest.g:153:1: entryRuleMultiChoiceEmendation : ruleMultiChoiceEmendation EOF ;
    public final void entryRuleMultiChoiceEmendation() throws RecognitionException {
        try {
            // InternalEduTest.g:154:1: ( ruleMultiChoiceEmendation EOF )
            // InternalEduTest.g:155:1: ruleMultiChoiceEmendation EOF
            {
             before(grammarAccess.getMultiChoiceEmendationRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiChoiceEmendation();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmendationRule()); 
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
    // $ANTLR end "entryRuleMultiChoiceEmendation"


    // $ANTLR start "ruleMultiChoiceEmendation"
    // InternalEduTest.g:162:1: ruleMultiChoiceEmendation : ( ( rule__MultiChoiceEmendation__Group__0 ) ) ;
    public final void ruleMultiChoiceEmendation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:166:2: ( ( ( rule__MultiChoiceEmendation__Group__0 ) ) )
            // InternalEduTest.g:167:2: ( ( rule__MultiChoiceEmendation__Group__0 ) )
            {
            // InternalEduTest.g:167:2: ( ( rule__MultiChoiceEmendation__Group__0 ) )
            // InternalEduTest.g:168:3: ( rule__MultiChoiceEmendation__Group__0 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup()); 
            // InternalEduTest.g:169:3: ( rule__MultiChoiceEmendation__Group__0 )
            // InternalEduTest.g:169:4: rule__MultiChoiceEmendation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiChoiceEmendation"


    // $ANTLR start "entryRuleMatchPairs"
    // InternalEduTest.g:178:1: entryRuleMatchPairs : ruleMatchPairs EOF ;
    public final void entryRuleMatchPairs() throws RecognitionException {
        try {
            // InternalEduTest.g:179:1: ( ruleMatchPairs EOF )
            // InternalEduTest.g:180:1: ruleMatchPairs EOF
            {
             before(grammarAccess.getMatchPairsRule()); 
            pushFollow(FOLLOW_1);
            ruleMatchPairs();

            state._fsp--;

             after(grammarAccess.getMatchPairsRule()); 
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
    // $ANTLR end "entryRuleMatchPairs"


    // $ANTLR start "ruleMatchPairs"
    // InternalEduTest.g:187:1: ruleMatchPairs : ( ( rule__MatchPairs__Group__0 ) ) ;
    public final void ruleMatchPairs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:191:2: ( ( ( rule__MatchPairs__Group__0 ) ) )
            // InternalEduTest.g:192:2: ( ( rule__MatchPairs__Group__0 ) )
            {
            // InternalEduTest.g:192:2: ( ( rule__MatchPairs__Group__0 ) )
            // InternalEduTest.g:193:3: ( rule__MatchPairs__Group__0 )
            {
             before(grammarAccess.getMatchPairsAccess().getGroup()); 
            // InternalEduTest.g:194:3: ( rule__MatchPairs__Group__0 )
            // InternalEduTest.g:194:4: rule__MatchPairs__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMatchPairsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMatchPairs"


    // $ANTLR start "entryRuleMissingWords"
    // InternalEduTest.g:203:1: entryRuleMissingWords : ruleMissingWords EOF ;
    public final void entryRuleMissingWords() throws RecognitionException {
        try {
            // InternalEduTest.g:204:1: ( ruleMissingWords EOF )
            // InternalEduTest.g:205:1: ruleMissingWords EOF
            {
             before(grammarAccess.getMissingWordsRule()); 
            pushFollow(FOLLOW_1);
            ruleMissingWords();

            state._fsp--;

             after(grammarAccess.getMissingWordsRule()); 
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
    // $ANTLR end "entryRuleMissingWords"


    // $ANTLR start "ruleMissingWords"
    // InternalEduTest.g:212:1: ruleMissingWords : ( ( rule__MissingWords__Group__0 ) ) ;
    public final void ruleMissingWords() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:216:2: ( ( ( rule__MissingWords__Group__0 ) ) )
            // InternalEduTest.g:217:2: ( ( rule__MissingWords__Group__0 ) )
            {
            // InternalEduTest.g:217:2: ( ( rule__MissingWords__Group__0 ) )
            // InternalEduTest.g:218:3: ( rule__MissingWords__Group__0 )
            {
             before(grammarAccess.getMissingWordsAccess().getGroup()); 
            // InternalEduTest.g:219:3: ( rule__MissingWords__Group__0 )
            // InternalEduTest.g:219:4: rule__MissingWords__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMissingWordsAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMissingWords"


    // $ANTLR start "entryRuleProgramConfiguration"
    // InternalEduTest.g:228:1: entryRuleProgramConfiguration : ruleProgramConfiguration EOF ;
    public final void entryRuleProgramConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:229:1: ( ruleProgramConfiguration EOF )
            // InternalEduTest.g:230:1: ruleProgramConfiguration EOF
            {
             before(grammarAccess.getProgramConfigurationRule()); 
            pushFollow(FOLLOW_1);
            ruleProgramConfiguration();

            state._fsp--;

             after(grammarAccess.getProgramConfigurationRule()); 
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
    // $ANTLR end "entryRuleProgramConfiguration"


    // $ANTLR start "ruleProgramConfiguration"
    // InternalEduTest.g:237:1: ruleProgramConfiguration : ( ( rule__ProgramConfiguration__Group__0 ) ) ;
    public final void ruleProgramConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:241:2: ( ( ( rule__ProgramConfiguration__Group__0 ) ) )
            // InternalEduTest.g:242:2: ( ( rule__ProgramConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:242:2: ( ( rule__ProgramConfiguration__Group__0 ) )
            // InternalEduTest.g:243:3: ( rule__ProgramConfiguration__Group__0 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getGroup()); 
            // InternalEduTest.g:244:3: ( rule__ProgramConfiguration__Group__0 )
            // InternalEduTest.g:244:4: rule__ProgramConfiguration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ProgramConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getProgramConfigurationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleProgramConfiguration"


    // $ANTLR start "entryRuleTestConfiguration"
    // InternalEduTest.g:253:1: entryRuleTestConfiguration : ruleTestConfiguration EOF ;
    public final void entryRuleTestConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:254:1: ( ruleTestConfiguration EOF )
            // InternalEduTest.g:255:1: ruleTestConfiguration EOF
            {
             before(grammarAccess.getTestConfigurationRule()); 
            pushFollow(FOLLOW_1);
            ruleTestConfiguration();

            state._fsp--;

             after(grammarAccess.getTestConfigurationRule()); 
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
    // $ANTLR end "entryRuleTestConfiguration"


    // $ANTLR start "ruleTestConfiguration"
    // InternalEduTest.g:262:1: ruleTestConfiguration : ( ( rule__TestConfiguration__Group__0 ) ) ;
    public final void ruleTestConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:266:2: ( ( ( rule__TestConfiguration__Group__0 ) ) )
            // InternalEduTest.g:267:2: ( ( rule__TestConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:267:2: ( ( rule__TestConfiguration__Group__0 ) )
            // InternalEduTest.g:268:3: ( rule__TestConfiguration__Group__0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup()); 
            // InternalEduTest.g:269:3: ( rule__TestConfiguration__Group__0 )
            // InternalEduTest.g:269:4: rule__TestConfiguration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTestConfiguration"


    // $ANTLR start "entryRuleMultiChoiceEmConfig"
    // InternalEduTest.g:278:1: entryRuleMultiChoiceEmConfig : ruleMultiChoiceEmConfig EOF ;
    public final void entryRuleMultiChoiceEmConfig() throws RecognitionException {
        try {
            // InternalEduTest.g:279:1: ( ruleMultiChoiceEmConfig EOF )
            // InternalEduTest.g:280:1: ruleMultiChoiceEmConfig EOF
            {
             before(grammarAccess.getMultiChoiceEmConfigRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiChoiceEmConfig();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmConfigRule()); 
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
    // $ANTLR end "entryRuleMultiChoiceEmConfig"


    // $ANTLR start "ruleMultiChoiceEmConfig"
    // InternalEduTest.g:287:1: ruleMultiChoiceEmConfig : ( ( rule__MultiChoiceEmConfig__Group__0 ) ) ;
    public final void ruleMultiChoiceEmConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:291:2: ( ( ( rule__MultiChoiceEmConfig__Group__0 ) ) )
            // InternalEduTest.g:292:2: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            {
            // InternalEduTest.g:292:2: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            // InternalEduTest.g:293:3: ( rule__MultiChoiceEmConfig__Group__0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup()); 
            // InternalEduTest.g:294:3: ( rule__MultiChoiceEmConfig__Group__0 )
            // InternalEduTest.g:294:4: rule__MultiChoiceEmConfig__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiChoiceEmConfig"


    // $ANTLR start "entryRuleTest"
    // InternalEduTest.g:303:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // InternalEduTest.g:304:1: ( ruleTest EOF )
            // InternalEduTest.g:305:1: ruleTest EOF
            {
             before(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_1);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getTestRule()); 
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
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // InternalEduTest.g:312:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
    public final void ruleTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:316:2: ( ( ( rule__Test__Group__0 ) ) )
            // InternalEduTest.g:317:2: ( ( rule__Test__Group__0 ) )
            {
            // InternalEduTest.g:317:2: ( ( rule__Test__Group__0 ) )
            // InternalEduTest.g:318:3: ( rule__Test__Group__0 )
            {
             before(grammarAccess.getTestAccess().getGroup()); 
            // InternalEduTest.g:319:3: ( rule__Test__Group__0 )
            // InternalEduTest.g:319:4: rule__Test__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Test__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleEString"
    // InternalEduTest.g:328:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalEduTest.g:329:1: ( ruleEString EOF )
            // InternalEduTest.g:330:1: ruleEString EOF
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
    // InternalEduTest.g:337:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:341:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalEduTest.g:342:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalEduTest.g:342:2: ( ( rule__EString__Alternatives ) )
            // InternalEduTest.g:343:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalEduTest.g:344:3: ( rule__EString__Alternatives )
            // InternalEduTest.g:344:4: rule__EString__Alternatives
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


    // $ANTLR start "entryRuleEDouble"
    // InternalEduTest.g:353:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalEduTest.g:354:1: ( ruleEDouble EOF )
            // InternalEduTest.g:355:1: ruleEDouble EOF
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
    // InternalEduTest.g:362:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:366:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalEduTest.g:367:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalEduTest.g:367:2: ( ( rule__EDouble__Group__0 ) )
            // InternalEduTest.g:368:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalEduTest.g:369:3: ( rule__EDouble__Group__0 )
            // InternalEduTest.g:369:4: rule__EDouble__Group__0
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


    // $ANTLR start "ruleOrder"
    // InternalEduTest.g:378:1: ruleOrder : ( ( rule__Order__Alternatives ) ) ;
    public final void ruleOrder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:382:1: ( ( ( rule__Order__Alternatives ) ) )
            // InternalEduTest.g:383:2: ( ( rule__Order__Alternatives ) )
            {
            // InternalEduTest.g:383:2: ( ( rule__Order__Alternatives ) )
            // InternalEduTest.g:384:3: ( rule__Order__Alternatives )
            {
             before(grammarAccess.getOrderAccess().getAlternatives()); 
            // InternalEduTest.g:385:3: ( rule__Order__Alternatives )
            // InternalEduTest.g:385:4: rule__Order__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Order__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getOrderAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleOrder"


    // $ANTLR start "ruleMode"
    // InternalEduTest.g:394:1: ruleMode : ( ( rule__Mode__Alternatives ) ) ;
    public final void ruleMode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:398:1: ( ( ( rule__Mode__Alternatives ) ) )
            // InternalEduTest.g:399:2: ( ( rule__Mode__Alternatives ) )
            {
            // InternalEduTest.g:399:2: ( ( rule__Mode__Alternatives ) )
            // InternalEduTest.g:400:3: ( rule__Mode__Alternatives )
            {
             before(grammarAccess.getModeAccess().getAlternatives()); 
            // InternalEduTest.g:401:3: ( rule__Mode__Alternatives )
            // InternalEduTest.g:401:4: rule__Mode__Alternatives
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


    // $ANTLR start "ruleNavigation"
    // InternalEduTest.g:410:1: ruleNavigation : ( ( rule__Navigation__Alternatives ) ) ;
    public final void ruleNavigation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:414:1: ( ( ( rule__Navigation__Alternatives ) ) )
            // InternalEduTest.g:415:2: ( ( rule__Navigation__Alternatives ) )
            {
            // InternalEduTest.g:415:2: ( ( rule__Navigation__Alternatives ) )
            // InternalEduTest.g:416:3: ( rule__Navigation__Alternatives )
            {
             before(grammarAccess.getNavigationAccess().getAlternatives()); 
            // InternalEduTest.g:417:3: ( rule__Navigation__Alternatives )
            // InternalEduTest.g:417:4: rule__Navigation__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Navigation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNavigationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNavigation"


    // $ANTLR start "rule__MutatorTests__Alternatives"
    // InternalEduTest.g:425:1: rule__MutatorTests__Alternatives : ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) | ( ruleMatchPairs ) | ( ruleMissingWords ) );
    public final void rule__MutatorTests__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:429:1: ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) | ( ruleMatchPairs ) | ( ruleMissingWords ) )
            int alt1=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 27:
                {
                alt1=2;
                }
                break;
            case 28:
                {
                alt1=3;
                }
                break;
            case 29:
                {
                alt1=4;
                }
                break;
            case 30:
                {
                alt1=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalEduTest.g:430:2: ( ruleAlternativeResponse )
                    {
                    // InternalEduTest.g:430:2: ( ruleAlternativeResponse )
                    // InternalEduTest.g:431:3: ruleAlternativeResponse
                    {
                     before(grammarAccess.getMutatorTestsAccess().getAlternativeResponseParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleAlternativeResponse();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getAlternativeResponseParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:436:2: ( ruleMultiChoiceDiagram )
                    {
                    // InternalEduTest.g:436:2: ( ruleMultiChoiceDiagram )
                    // InternalEduTest.g:437:3: ruleMultiChoiceDiagram
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMultiChoiceDiagramParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMultiChoiceDiagram();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMultiChoiceDiagramParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEduTest.g:442:2: ( ruleMultiChoiceEmendation )
                    {
                    // InternalEduTest.g:442:2: ( ruleMultiChoiceEmendation )
                    // InternalEduTest.g:443:3: ruleMultiChoiceEmendation
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMultiChoiceEmendationParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleMultiChoiceEmendation();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMultiChoiceEmendationParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalEduTest.g:448:2: ( ruleMatchPairs )
                    {
                    // InternalEduTest.g:448:2: ( ruleMatchPairs )
                    // InternalEduTest.g:449:3: ruleMatchPairs
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMatchPairsParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleMatchPairs();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMatchPairsParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalEduTest.g:454:2: ( ruleMissingWords )
                    {
                    // InternalEduTest.g:454:2: ( ruleMissingWords )
                    // InternalEduTest.g:455:3: ruleMissingWords
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMissingWordsParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleMissingWords();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMissingWordsParserRuleCall_4()); 

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
    // $ANTLR end "rule__MutatorTests__Alternatives"


    // $ANTLR start "rule__TestConfiguration__RetryAlternatives_3_0"
    // InternalEduTest.g:464:1: rule__TestConfiguration__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__TestConfiguration__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:468:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:469:2: ( 'yes' )
                    {
                    // InternalEduTest.g:469:2: ( 'yes' )
                    // InternalEduTest.g:470:3: 'yes'
                    {
                     before(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:475:2: ( 'no' )
                    {
                    // InternalEduTest.g:475:2: ( 'no' )
                    // InternalEduTest.g:476:3: 'no'
                    {
                     before(grammarAccess.getTestConfigurationAccess().getRetryNoKeyword_3_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getTestConfigurationAccess().getRetryNoKeyword_3_0_1()); 

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
    // $ANTLR end "rule__TestConfiguration__RetryAlternatives_3_0"


    // $ANTLR start "rule__MultiChoiceEmConfig__RetryAlternatives_3_0"
    // InternalEduTest.g:485:1: rule__MultiChoiceEmConfig__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:489:1: ( ( 'yes' ) | ( 'no' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalEduTest.g:490:2: ( 'yes' )
                    {
                    // InternalEduTest.g:490:2: ( 'yes' )
                    // InternalEduTest.g:491:3: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:496:2: ( 'no' )
                    {
                    // InternalEduTest.g:496:2: ( 'no' )
                    // InternalEduTest.g:497:3: 'no'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryNoKeyword_3_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryNoKeyword_3_0_1()); 

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
    // $ANTLR end "rule__MultiChoiceEmConfig__RetryAlternatives_3_0"


    // $ANTLR start "rule__MultiChoiceEmConfig__WeightedAlternatives_7_0"
    // InternalEduTest.g:506:1: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__WeightedAlternatives_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:510:1: ( ( 'yes' ) | ( 'no' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalEduTest.g:511:2: ( 'yes' )
                    {
                    // InternalEduTest.g:511:2: ( 'yes' )
                    // InternalEduTest.g:512:3: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:517:2: ( 'no' )
                    {
                    // InternalEduTest.g:517:2: ( 'no' )
                    // InternalEduTest.g:518:3: 'no'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedNoKeyword_7_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedNoKeyword_7_0_1()); 

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
    // $ANTLR end "rule__MultiChoiceEmConfig__WeightedAlternatives_7_0"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalEduTest.g:527:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:531:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalEduTest.g:532:2: ( RULE_STRING )
                    {
                    // InternalEduTest.g:532:2: ( RULE_STRING )
                    // InternalEduTest.g:533:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:538:2: ( RULE_ID )
                    {
                    // InternalEduTest.g:538:2: ( RULE_ID )
                    // InternalEduTest.g:539:3: RULE_ID
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


    // $ANTLR start "rule__EDouble__Alternatives_4_0"
    // InternalEduTest.g:548:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:552:1: ( ( 'E' ) | ( 'e' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                alt6=1;
            }
            else if ( (LA6_0==14) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalEduTest.g:553:2: ( 'E' )
                    {
                    // InternalEduTest.g:553:2: ( 'E' )
                    // InternalEduTest.g:554:3: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:559:2: ( 'e' )
                    {
                    // InternalEduTest.g:559:2: ( 'e' )
                    // InternalEduTest.g:560:3: 'e'
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


    // $ANTLR start "rule__Order__Alternatives"
    // InternalEduTest.g:569:1: rule__Order__Alternatives : ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) );
    public final void rule__Order__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:573:1: ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt7=1;
                }
                break;
            case 16:
                {
                alt7=2;
                }
                break;
            case 17:
                {
                alt7=3;
                }
                break;
            case 18:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalEduTest.g:574:2: ( ( 'fixed' ) )
                    {
                    // InternalEduTest.g:574:2: ( ( 'fixed' ) )
                    // InternalEduTest.g:575:3: ( 'fixed' )
                    {
                     before(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:576:3: ( 'fixed' )
                    // InternalEduTest.g:576:4: 'fixed'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:580:2: ( ( 'random' ) )
                    {
                    // InternalEduTest.g:580:2: ( ( 'random' ) )
                    // InternalEduTest.g:581:3: ( 'random' )
                    {
                     before(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:582:3: ( 'random' )
                    // InternalEduTest.g:582:4: 'random'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEduTest.g:586:2: ( ( 'options-ascending' ) )
                    {
                    // InternalEduTest.g:586:2: ( ( 'options-ascending' ) )
                    // InternalEduTest.g:587:3: ( 'options-ascending' )
                    {
                     before(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 
                    // InternalEduTest.g:588:3: ( 'options-ascending' )
                    // InternalEduTest.g:588:4: 'options-ascending'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalEduTest.g:592:2: ( ( 'options-descending' ) )
                    {
                    // InternalEduTest.g:592:2: ( ( 'options-descending' ) )
                    // InternalEduTest.g:593:3: ( 'options-descending' )
                    {
                     before(grammarAccess.getOrderAccess().getDescendingEnumLiteralDeclaration_3()); 
                    // InternalEduTest.g:594:3: ( 'options-descending' )
                    // InternalEduTest.g:594:4: 'options-descending'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getDescendingEnumLiteralDeclaration_3()); 

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
    // $ANTLR end "rule__Order__Alternatives"


    // $ANTLR start "rule__Mode__Alternatives"
    // InternalEduTest.g:602:1: rule__Mode__Alternatives : ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) );
    public final void rule__Mode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:606:1: ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==19) ) {
                alt8=1;
            }
            else if ( (LA8_0==20) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalEduTest.g:607:2: ( ( 'radiobutton' ) )
                    {
                    // InternalEduTest.g:607:2: ( ( 'radiobutton' ) )
                    // InternalEduTest.g:608:3: ( 'radiobutton' )
                    {
                     before(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:609:3: ( 'radiobutton' )
                    // InternalEduTest.g:609:4: 'radiobutton'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:613:2: ( ( 'checkbox' ) )
                    {
                    // InternalEduTest.g:613:2: ( ( 'checkbox' ) )
                    // InternalEduTest.g:614:3: ( 'checkbox' )
                    {
                     before(grammarAccess.getModeAccess().getCheckboxEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:615:3: ( 'checkbox' )
                    // InternalEduTest.g:615:4: 'checkbox'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getModeAccess().getCheckboxEnumLiteralDeclaration_1()); 

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


    // $ANTLR start "rule__Navigation__Alternatives"
    // InternalEduTest.g:623:1: rule__Navigation__Alternatives : ( ( ( 'free' ) ) | ( ( 'locked' ) ) );
    public final void rule__Navigation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:627:1: ( ( ( 'free' ) ) | ( ( 'locked' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            else if ( (LA9_0==22) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalEduTest.g:628:2: ( ( 'free' ) )
                    {
                    // InternalEduTest.g:628:2: ( ( 'free' ) )
                    // InternalEduTest.g:629:3: ( 'free' )
                    {
                     before(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:630:3: ( 'free' )
                    // InternalEduTest.g:630:4: 'free'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:634:2: ( ( 'locked' ) )
                    {
                    // InternalEduTest.g:634:2: ( ( 'locked' ) )
                    // InternalEduTest.g:635:3: ( 'locked' )
                    {
                     before(grammarAccess.getNavigationAccess().getLockedEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:636:3: ( 'locked' )
                    // InternalEduTest.g:636:4: 'locked'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getNavigationAccess().getLockedEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__Navigation__Alternatives"


    // $ANTLR start "rule__Program__Group__0"
    // InternalEduTest.g:644:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:648:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // InternalEduTest.g:649:2: rule__Program__Group__0__Impl rule__Program__Group__1
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
    // InternalEduTest.g:656:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:660:1: ( ( () ) )
            // InternalEduTest.g:661:1: ( () )
            {
            // InternalEduTest.g:661:1: ( () )
            // InternalEduTest.g:662:2: ()
            {
             before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            // InternalEduTest.g:663:2: ()
            // InternalEduTest.g:663:3: 
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
    // InternalEduTest.g:671:1: rule__Program__Group__1 : rule__Program__Group__1__Impl rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:675:1: ( rule__Program__Group__1__Impl rule__Program__Group__2 )
            // InternalEduTest.g:676:2: rule__Program__Group__1__Impl rule__Program__Group__2
            {
            pushFollow(FOLLOW_3);
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
    // InternalEduTest.g:683:1: rule__Program__Group__1__Impl : ( ( rule__Program__ConfigAssignment_1 )? ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:687:1: ( ( ( rule__Program__ConfigAssignment_1 )? ) )
            // InternalEduTest.g:688:1: ( ( rule__Program__ConfigAssignment_1 )? )
            {
            // InternalEduTest.g:688:1: ( ( rule__Program__ConfigAssignment_1 )? )
            // InternalEduTest.g:689:2: ( rule__Program__ConfigAssignment_1 )?
            {
             before(grammarAccess.getProgramAccess().getConfigAssignment_1()); 
            // InternalEduTest.g:690:2: ( rule__Program__ConfigAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==31) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalEduTest.g:690:3: rule__Program__ConfigAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__Program__ConfigAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProgramAccess().getConfigAssignment_1()); 

            }


            }

        }
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
    // InternalEduTest.g:698:1: rule__Program__Group__2 : rule__Program__Group__2__Impl ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:702:1: ( rule__Program__Group__2__Impl )
            // InternalEduTest.g:703:2: rule__Program__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Program__Group__2__Impl();

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
    // InternalEduTest.g:709:1: rule__Program__Group__2__Impl : ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) ) ;
    public final void rule__Program__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:713:1: ( ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) ) )
            // InternalEduTest.g:714:1: ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) )
            {
            // InternalEduTest.g:714:1: ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) )
            // InternalEduTest.g:715:2: ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* )
            {
            // InternalEduTest.g:715:2: ( ( rule__Program__ExercisesAssignment_2 ) )
            // InternalEduTest.g:716:3: ( rule__Program__ExercisesAssignment_2 )
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 
            // InternalEduTest.g:717:3: ( rule__Program__ExercisesAssignment_2 )
            // InternalEduTest.g:717:4: rule__Program__ExercisesAssignment_2
            {
            pushFollow(FOLLOW_4);
            rule__Program__ExercisesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 

            }

            // InternalEduTest.g:720:2: ( ( rule__Program__ExercisesAssignment_2 )* )
            // InternalEduTest.g:721:3: ( rule__Program__ExercisesAssignment_2 )*
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 
            // InternalEduTest.g:722:3: ( rule__Program__ExercisesAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23||(LA11_0>=27 && LA11_0<=30)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalEduTest.g:722:4: rule__Program__ExercisesAssignment_2
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Program__ExercisesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 

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
    // $ANTLR end "rule__Program__Group__2__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group__0"
    // InternalEduTest.g:732:1: rule__AlternativeResponse__Group__0 : rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 ;
    public final void rule__AlternativeResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:736:1: ( rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 )
            // InternalEduTest.g:737:2: rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__AlternativeResponse__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group__1();

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
    // $ANTLR end "rule__AlternativeResponse__Group__0"


    // $ANTLR start "rule__AlternativeResponse__Group__0__Impl"
    // InternalEduTest.g:744:1: rule__AlternativeResponse__Group__0__Impl : ( 'AlternativeResponse' ) ;
    public final void rule__AlternativeResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:748:1: ( ( 'AlternativeResponse' ) )
            // InternalEduTest.g:749:1: ( 'AlternativeResponse' )
            {
            // InternalEduTest.g:749:1: ( 'AlternativeResponse' )
            // InternalEduTest.g:750:2: 'AlternativeResponse'
            {
             before(grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group__0__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group__1"
    // InternalEduTest.g:759:1: rule__AlternativeResponse__Group__1 : rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 ;
    public final void rule__AlternativeResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:763:1: ( rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 )
            // InternalEduTest.g:764:2: rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__AlternativeResponse__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group__2();

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
    // $ANTLR end "rule__AlternativeResponse__Group__1"


    // $ANTLR start "rule__AlternativeResponse__Group__1__Impl"
    // InternalEduTest.g:771:1: rule__AlternativeResponse__Group__1__Impl : ( ( rule__AlternativeResponse__Group_1__0 )? ) ;
    public final void rule__AlternativeResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:775:1: ( ( ( rule__AlternativeResponse__Group_1__0 )? ) )
            // InternalEduTest.g:776:1: ( ( rule__AlternativeResponse__Group_1__0 )? )
            {
            // InternalEduTest.g:776:1: ( ( rule__AlternativeResponse__Group_1__0 )? )
            // InternalEduTest.g:777:2: ( rule__AlternativeResponse__Group_1__0 )?
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup_1()); 
            // InternalEduTest.g:778:2: ( rule__AlternativeResponse__Group_1__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalEduTest.g:778:3: rule__AlternativeResponse__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AlternativeResponse__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativeResponseAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group__1__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group__2"
    // InternalEduTest.g:786:1: rule__AlternativeResponse__Group__2 : rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 ;
    public final void rule__AlternativeResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:790:1: ( rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 )
            // InternalEduTest.g:791:2: rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__AlternativeResponse__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group__3();

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
    // $ANTLR end "rule__AlternativeResponse__Group__2"


    // $ANTLR start "rule__AlternativeResponse__Group__2__Impl"
    // InternalEduTest.g:798:1: rule__AlternativeResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__AlternativeResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:802:1: ( ( '{' ) )
            // InternalEduTest.g:803:1: ( '{' )
            {
            // InternalEduTest.g:803:1: ( '{' )
            // InternalEduTest.g:804:2: '{'
            {
             before(grammarAccess.getAlternativeResponseAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getAlternativeResponseAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group__2__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group__3"
    // InternalEduTest.g:813:1: rule__AlternativeResponse__Group__3 : rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 ;
    public final void rule__AlternativeResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:817:1: ( rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 )
            // InternalEduTest.g:818:2: rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__AlternativeResponse__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group__4();

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
    // $ANTLR end "rule__AlternativeResponse__Group__3"


    // $ANTLR start "rule__AlternativeResponse__Group__3__Impl"
    // InternalEduTest.g:825:1: rule__AlternativeResponse__Group__3__Impl : ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) ;
    public final void rule__AlternativeResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:829:1: ( ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:830:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:830:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            // InternalEduTest.g:831:2: ( rule__AlternativeResponse__ConfigAssignment_3 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:832:2: ( rule__AlternativeResponse__ConfigAssignment_3 )
            // InternalEduTest.g:832:3: rule__AlternativeResponse__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeResponseAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group__3__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group__4"
    // InternalEduTest.g:840:1: rule__AlternativeResponse__Group__4 : rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 ;
    public final void rule__AlternativeResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:844:1: ( rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 )
            // InternalEduTest.g:845:2: rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__AlternativeResponse__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group__5();

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
    // $ANTLR end "rule__AlternativeResponse__Group__4"


    // $ANTLR start "rule__AlternativeResponse__Group__4__Impl"
    // InternalEduTest.g:852:1: rule__AlternativeResponse__Group__4__Impl : ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) ;
    public final void rule__AlternativeResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:856:1: ( ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) )
            // InternalEduTest.g:857:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:857:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            // InternalEduTest.g:858:2: ( rule__AlternativeResponse__TestsAssignment_4 )*
            {
             before(grammarAccess.getAlternativeResponseAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:859:2: ( rule__AlternativeResponse__TestsAssignment_4 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==38) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalEduTest.g:859:3: rule__AlternativeResponse__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__AlternativeResponse__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getAlternativeResponseAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group__4__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group__5"
    // InternalEduTest.g:867:1: rule__AlternativeResponse__Group__5 : rule__AlternativeResponse__Group__5__Impl ;
    public final void rule__AlternativeResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:871:1: ( rule__AlternativeResponse__Group__5__Impl )
            // InternalEduTest.g:872:2: rule__AlternativeResponse__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group__5__Impl();

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
    // $ANTLR end "rule__AlternativeResponse__Group__5"


    // $ANTLR start "rule__AlternativeResponse__Group__5__Impl"
    // InternalEduTest.g:878:1: rule__AlternativeResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__AlternativeResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:882:1: ( ( '}' ) )
            // InternalEduTest.g:883:1: ( '}' )
            {
            // InternalEduTest.g:883:1: ( '}' )
            // InternalEduTest.g:884:2: '}'
            {
             before(grammarAccess.getAlternativeResponseAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getAlternativeResponseAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group__5__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group_1__0"
    // InternalEduTest.g:894:1: rule__AlternativeResponse__Group_1__0 : rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1 ;
    public final void rule__AlternativeResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:898:1: ( rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1 )
            // InternalEduTest.g:899:2: rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__AlternativeResponse__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group_1__1();

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
    // $ANTLR end "rule__AlternativeResponse__Group_1__0"


    // $ANTLR start "rule__AlternativeResponse__Group_1__0__Impl"
    // InternalEduTest.g:906:1: rule__AlternativeResponse__Group_1__0__Impl : ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) ) ;
    public final void rule__AlternativeResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:910:1: ( ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:911:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:911:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:912:2: ( rule__AlternativeResponse__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:913:2: ( rule__AlternativeResponse__BlocksAssignment_1_0 )
            // InternalEduTest.g:913:3: rule__AlternativeResponse__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeResponseAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group_1__0__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group_1__1"
    // InternalEduTest.g:921:1: rule__AlternativeResponse__Group_1__1 : rule__AlternativeResponse__Group_1__1__Impl ;
    public final void rule__AlternativeResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:925:1: ( rule__AlternativeResponse__Group_1__1__Impl )
            // InternalEduTest.g:926:2: rule__AlternativeResponse__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group_1__1__Impl();

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
    // $ANTLR end "rule__AlternativeResponse__Group_1__1"


    // $ANTLR start "rule__AlternativeResponse__Group_1__1__Impl"
    // InternalEduTest.g:932:1: rule__AlternativeResponse__Group_1__1__Impl : ( ( rule__AlternativeResponse__Group_1_1__0 )* ) ;
    public final void rule__AlternativeResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:936:1: ( ( ( rule__AlternativeResponse__Group_1_1__0 )* ) )
            // InternalEduTest.g:937:1: ( ( rule__AlternativeResponse__Group_1_1__0 )* )
            {
            // InternalEduTest.g:937:1: ( ( rule__AlternativeResponse__Group_1_1__0 )* )
            // InternalEduTest.g:938:2: ( rule__AlternativeResponse__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup_1_1()); 
            // InternalEduTest.g:939:2: ( rule__AlternativeResponse__Group_1_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalEduTest.g:939:3: rule__AlternativeResponse__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__AlternativeResponse__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getAlternativeResponseAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group_1__1__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group_1_1__0"
    // InternalEduTest.g:948:1: rule__AlternativeResponse__Group_1_1__0 : rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1 ;
    public final void rule__AlternativeResponse__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:952:1: ( rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1 )
            // InternalEduTest.g:953:2: rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
            rule__AlternativeResponse__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group_1_1__1();

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
    // $ANTLR end "rule__AlternativeResponse__Group_1_1__0"


    // $ANTLR start "rule__AlternativeResponse__Group_1_1__0__Impl"
    // InternalEduTest.g:960:1: rule__AlternativeResponse__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__AlternativeResponse__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:964:1: ( ( ',' ) )
            // InternalEduTest.g:965:1: ( ',' )
            {
            // InternalEduTest.g:965:1: ( ',' )
            // InternalEduTest.g:966:2: ','
            {
             before(grammarAccess.getAlternativeResponseAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getAlternativeResponseAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group_1_1__0__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group_1_1__1"
    // InternalEduTest.g:975:1: rule__AlternativeResponse__Group_1_1__1 : rule__AlternativeResponse__Group_1_1__1__Impl ;
    public final void rule__AlternativeResponse__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:979:1: ( rule__AlternativeResponse__Group_1_1__1__Impl )
            // InternalEduTest.g:980:2: rule__AlternativeResponse__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__AlternativeResponse__Group_1_1__1"


    // $ANTLR start "rule__AlternativeResponse__Group_1_1__1__Impl"
    // InternalEduTest.g:986:1: rule__AlternativeResponse__Group_1_1__1__Impl : ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__AlternativeResponse__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:990:1: ( ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:991:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:991:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:992:2: ( rule__AlternativeResponse__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:993:2: ( rule__AlternativeResponse__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:993:3: rule__AlternativeResponse__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeResponseAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__Group_1_1__1__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__0"
    // InternalEduTest.g:1002:1: rule__MultiChoiceDiagram__Group__0 : rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 ;
    public final void rule__MultiChoiceDiagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1006:1: ( rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 )
            // InternalEduTest.g:1007:2: rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MultiChoiceDiagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group__1();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group__0"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__0__Impl"
    // InternalEduTest.g:1014:1: rule__MultiChoiceDiagram__Group__0__Impl : ( 'MultiChoiceDiagram' ) ;
    public final void rule__MultiChoiceDiagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1018:1: ( ( 'MultiChoiceDiagram' ) )
            // InternalEduTest.g:1019:1: ( 'MultiChoiceDiagram' )
            {
            // InternalEduTest.g:1019:1: ( 'MultiChoiceDiagram' )
            // InternalEduTest.g:1020:2: 'MultiChoiceDiagram'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group__0__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__1"
    // InternalEduTest.g:1029:1: rule__MultiChoiceDiagram__Group__1 : rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 ;
    public final void rule__MultiChoiceDiagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1033:1: ( rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 )
            // InternalEduTest.g:1034:2: rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__MultiChoiceDiagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group__2();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group__1"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__1__Impl"
    // InternalEduTest.g:1041:1: rule__MultiChoiceDiagram__Group__1__Impl : ( ( rule__MultiChoiceDiagram__Group_1__0 )? ) ;
    public final void rule__MultiChoiceDiagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1045:1: ( ( ( rule__MultiChoiceDiagram__Group_1__0 )? ) )
            // InternalEduTest.g:1046:1: ( ( rule__MultiChoiceDiagram__Group_1__0 )? )
            {
            // InternalEduTest.g:1046:1: ( ( rule__MultiChoiceDiagram__Group_1__0 )? )
            // InternalEduTest.g:1047:2: ( rule__MultiChoiceDiagram__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1()); 
            // InternalEduTest.g:1048:2: ( rule__MultiChoiceDiagram__Group_1__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ID) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalEduTest.g:1048:3: rule__MultiChoiceDiagram__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiChoiceDiagram__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group__1__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__2"
    // InternalEduTest.g:1056:1: rule__MultiChoiceDiagram__Group__2 : rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 ;
    public final void rule__MultiChoiceDiagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1060:1: ( rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 )
            // InternalEduTest.g:1061:2: rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__MultiChoiceDiagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group__3();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group__2"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__2__Impl"
    // InternalEduTest.g:1068:1: rule__MultiChoiceDiagram__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceDiagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1072:1: ( ( '{' ) )
            // InternalEduTest.g:1073:1: ( '{' )
            {
            // InternalEduTest.g:1073:1: ( '{' )
            // InternalEduTest.g:1074:2: '{'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceDiagramAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group__2__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__3"
    // InternalEduTest.g:1083:1: rule__MultiChoiceDiagram__Group__3 : rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 ;
    public final void rule__MultiChoiceDiagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1087:1: ( rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 )
            // InternalEduTest.g:1088:2: rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceDiagram__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group__4();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group__3"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__3__Impl"
    // InternalEduTest.g:1095:1: rule__MultiChoiceDiagram__Group__3__Impl : ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceDiagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1099:1: ( ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1100:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1100:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            // InternalEduTest.g:1101:2: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1102:2: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            // InternalEduTest.g:1102:3: rule__MultiChoiceDiagram__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group__3__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__4"
    // InternalEduTest.g:1110:1: rule__MultiChoiceDiagram__Group__4 : rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 ;
    public final void rule__MultiChoiceDiagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1114:1: ( rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 )
            // InternalEduTest.g:1115:2: rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceDiagram__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group__5();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group__4"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__4__Impl"
    // InternalEduTest.g:1122:1: rule__MultiChoiceDiagram__Group__4__Impl : ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceDiagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1126:1: ( ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1127:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1127:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            // InternalEduTest.g:1128:2: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1129:2: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==38) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalEduTest.g:1129:3: rule__MultiChoiceDiagram__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MultiChoiceDiagram__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceDiagramAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group__4__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__5"
    // InternalEduTest.g:1137:1: rule__MultiChoiceDiagram__Group__5 : rule__MultiChoiceDiagram__Group__5__Impl ;
    public final void rule__MultiChoiceDiagram__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1141:1: ( rule__MultiChoiceDiagram__Group__5__Impl )
            // InternalEduTest.g:1142:2: rule__MultiChoiceDiagram__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group__5__Impl();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group__5"


    // $ANTLR start "rule__MultiChoiceDiagram__Group__5__Impl"
    // InternalEduTest.g:1148:1: rule__MultiChoiceDiagram__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceDiagram__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1152:1: ( ( '}' ) )
            // InternalEduTest.g:1153:1: ( '}' )
            {
            // InternalEduTest.g:1153:1: ( '}' )
            // InternalEduTest.g:1154:2: '}'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceDiagramAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group__5__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1__0"
    // InternalEduTest.g:1164:1: rule__MultiChoiceDiagram__Group_1__0 : rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1 ;
    public final void rule__MultiChoiceDiagram__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1168:1: ( rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1 )
            // InternalEduTest.g:1169:2: rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__MultiChoiceDiagram__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group_1__1();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1__0"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1__0__Impl"
    // InternalEduTest.g:1176:1: rule__MultiChoiceDiagram__Group_1__0__Impl : ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceDiagram__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1180:1: ( ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1181:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1181:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1182:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1183:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 )
            // InternalEduTest.g:1183:3: rule__MultiChoiceDiagram__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1__0__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1__1"
    // InternalEduTest.g:1191:1: rule__MultiChoiceDiagram__Group_1__1 : rule__MultiChoiceDiagram__Group_1__1__Impl ;
    public final void rule__MultiChoiceDiagram__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1195:1: ( rule__MultiChoiceDiagram__Group_1__1__Impl )
            // InternalEduTest.g:1196:2: rule__MultiChoiceDiagram__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group_1__1__Impl();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1__1"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1__1__Impl"
    // InternalEduTest.g:1202:1: rule__MultiChoiceDiagram__Group_1__1__Impl : ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceDiagram__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1206:1: ( ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* ) )
            // InternalEduTest.g:1207:1: ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1207:1: ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* )
            // InternalEduTest.g:1208:2: ( rule__MultiChoiceDiagram__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1_1()); 
            // InternalEduTest.g:1209:2: ( rule__MultiChoiceDiagram__Group_1_1__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==26) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalEduTest.g:1209:3: rule__MultiChoiceDiagram__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MultiChoiceDiagram__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1__1__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1_1__0"
    // InternalEduTest.g:1218:1: rule__MultiChoiceDiagram__Group_1_1__0 : rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1 ;
    public final void rule__MultiChoiceDiagram__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1222:1: ( rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1 )
            // InternalEduTest.g:1223:2: rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
            rule__MultiChoiceDiagram__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group_1_1__1();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1_1__0"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1_1__0__Impl"
    // InternalEduTest.g:1230:1: rule__MultiChoiceDiagram__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceDiagram__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1234:1: ( ( ',' ) )
            // InternalEduTest.g:1235:1: ( ',' )
            {
            // InternalEduTest.g:1235:1: ( ',' )
            // InternalEduTest.g:1236:2: ','
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceDiagramAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1_1__0__Impl"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1_1__1"
    // InternalEduTest.g:1245:1: rule__MultiChoiceDiagram__Group_1_1__1 : rule__MultiChoiceDiagram__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceDiagram__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1249:1: ( rule__MultiChoiceDiagram__Group_1_1__1__Impl )
            // InternalEduTest.g:1250:2: rule__MultiChoiceDiagram__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1_1__1"


    // $ANTLR start "rule__MultiChoiceDiagram__Group_1_1__1__Impl"
    // InternalEduTest.g:1256:1: rule__MultiChoiceDiagram__Group_1_1__1__Impl : ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceDiagram__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1260:1: ( ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1261:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1261:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1262:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1263:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:1263:3: rule__MultiChoiceDiagram__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__Group_1_1__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__0"
    // InternalEduTest.g:1272:1: rule__MultiChoiceEmendation__Group__0 : rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 ;
    public final void rule__MultiChoiceEmendation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1276:1: ( rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 )
            // InternalEduTest.g:1277:2: rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MultiChoiceEmendation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group__1();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group__0"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__0__Impl"
    // InternalEduTest.g:1284:1: rule__MultiChoiceEmendation__Group__0__Impl : ( 'MultiChoiceEmendation' ) ;
    public final void rule__MultiChoiceEmendation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1288:1: ( ( 'MultiChoiceEmendation' ) )
            // InternalEduTest.g:1289:1: ( 'MultiChoiceEmendation' )
            {
            // InternalEduTest.g:1289:1: ( 'MultiChoiceEmendation' )
            // InternalEduTest.g:1290:2: 'MultiChoiceEmendation'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__1"
    // InternalEduTest.g:1299:1: rule__MultiChoiceEmendation__Group__1 : rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 ;
    public final void rule__MultiChoiceEmendation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1303:1: ( rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 )
            // InternalEduTest.g:1304:2: rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__MultiChoiceEmendation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group__2();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group__1"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__1__Impl"
    // InternalEduTest.g:1311:1: rule__MultiChoiceEmendation__Group__1__Impl : ( ( rule__MultiChoiceEmendation__Group_1__0 )? ) ;
    public final void rule__MultiChoiceEmendation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1315:1: ( ( ( rule__MultiChoiceEmendation__Group_1__0 )? ) )
            // InternalEduTest.g:1316:1: ( ( rule__MultiChoiceEmendation__Group_1__0 )? )
            {
            // InternalEduTest.g:1316:1: ( ( rule__MultiChoiceEmendation__Group_1__0 )? )
            // InternalEduTest.g:1317:2: ( rule__MultiChoiceEmendation__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1()); 
            // InternalEduTest.g:1318:2: ( rule__MultiChoiceEmendation__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ID) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalEduTest.g:1318:3: rule__MultiChoiceEmendation__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiChoiceEmendation__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__2"
    // InternalEduTest.g:1326:1: rule__MultiChoiceEmendation__Group__2 : rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 ;
    public final void rule__MultiChoiceEmendation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1330:1: ( rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 )
            // InternalEduTest.g:1331:2: rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__MultiChoiceEmendation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group__3();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group__2"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__2__Impl"
    // InternalEduTest.g:1338:1: rule__MultiChoiceEmendation__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceEmendation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1342:1: ( ( '{' ) )
            // InternalEduTest.g:1343:1: ( '{' )
            {
            // InternalEduTest.g:1343:1: ( '{' )
            // InternalEduTest.g:1344:2: '{'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmendationAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group__2__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__3"
    // InternalEduTest.g:1353:1: rule__MultiChoiceEmendation__Group__3 : rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 ;
    public final void rule__MultiChoiceEmendation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1357:1: ( rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 )
            // InternalEduTest.g:1358:2: rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceEmendation__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group__4();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group__3"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__3__Impl"
    // InternalEduTest.g:1365:1: rule__MultiChoiceEmendation__Group__3__Impl : ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmendation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1369:1: ( ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1370:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1370:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            // InternalEduTest.g:1371:2: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1372:2: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            // InternalEduTest.g:1372:3: rule__MultiChoiceEmendation__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group__3__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__4"
    // InternalEduTest.g:1380:1: rule__MultiChoiceEmendation__Group__4 : rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 ;
    public final void rule__MultiChoiceEmendation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1384:1: ( rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 )
            // InternalEduTest.g:1385:2: rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceEmendation__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group__5();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group__4"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__4__Impl"
    // InternalEduTest.g:1392:1: rule__MultiChoiceEmendation__Group__4__Impl : ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceEmendation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1396:1: ( ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1397:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1397:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            // InternalEduTest.g:1398:2: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1399:2: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==38) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalEduTest.g:1399:3: rule__MultiChoiceEmendation__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MultiChoiceEmendation__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceEmendationAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group__4__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__5"
    // InternalEduTest.g:1407:1: rule__MultiChoiceEmendation__Group__5 : rule__MultiChoiceEmendation__Group__5__Impl ;
    public final void rule__MultiChoiceEmendation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1411:1: ( rule__MultiChoiceEmendation__Group__5__Impl )
            // InternalEduTest.g:1412:2: rule__MultiChoiceEmendation__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group__5__Impl();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group__5"


    // $ANTLR start "rule__MultiChoiceEmendation__Group__5__Impl"
    // InternalEduTest.g:1418:1: rule__MultiChoiceEmendation__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceEmendation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1422:1: ( ( '}' ) )
            // InternalEduTest.g:1423:1: ( '}' )
            {
            // InternalEduTest.g:1423:1: ( '}' )
            // InternalEduTest.g:1424:2: '}'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmendationAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group__5__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1__0"
    // InternalEduTest.g:1434:1: rule__MultiChoiceEmendation__Group_1__0 : rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1 ;
    public final void rule__MultiChoiceEmendation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1438:1: ( rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1 )
            // InternalEduTest.g:1439:2: rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__MultiChoiceEmendation__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group_1__1();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1__0"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1__0__Impl"
    // InternalEduTest.g:1446:1: rule__MultiChoiceEmendation__Group_1__0__Impl : ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceEmendation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1450:1: ( ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1451:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1451:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1452:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1453:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 )
            // InternalEduTest.g:1453:3: rule__MultiChoiceEmendation__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1__1"
    // InternalEduTest.g:1461:1: rule__MultiChoiceEmendation__Group_1__1 : rule__MultiChoiceEmendation__Group_1__1__Impl ;
    public final void rule__MultiChoiceEmendation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1465:1: ( rule__MultiChoiceEmendation__Group_1__1__Impl )
            // InternalEduTest.g:1466:2: rule__MultiChoiceEmendation__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group_1__1__Impl();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1__1"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1__1__Impl"
    // InternalEduTest.g:1472:1: rule__MultiChoiceEmendation__Group_1__1__Impl : ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceEmendation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1476:1: ( ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* ) )
            // InternalEduTest.g:1477:1: ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1477:1: ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* )
            // InternalEduTest.g:1478:2: ( rule__MultiChoiceEmendation__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1_1()); 
            // InternalEduTest.g:1479:2: ( rule__MultiChoiceEmendation__Group_1_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==26) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalEduTest.g:1479:3: rule__MultiChoiceEmendation__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MultiChoiceEmendation__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1_1__0"
    // InternalEduTest.g:1488:1: rule__MultiChoiceEmendation__Group_1_1__0 : rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1 ;
    public final void rule__MultiChoiceEmendation__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1492:1: ( rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1 )
            // InternalEduTest.g:1493:2: rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
            rule__MultiChoiceEmendation__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group_1_1__1();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1_1__0"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1_1__0__Impl"
    // InternalEduTest.g:1500:1: rule__MultiChoiceEmendation__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmendation__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1504:1: ( ( ',' ) )
            // InternalEduTest.g:1505:1: ( ',' )
            {
            // InternalEduTest.g:1505:1: ( ',' )
            // InternalEduTest.g:1506:2: ','
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmendationAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1_1__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1_1__1"
    // InternalEduTest.g:1515:1: rule__MultiChoiceEmendation__Group_1_1__1 : rule__MultiChoiceEmendation__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceEmendation__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1519:1: ( rule__MultiChoiceEmendation__Group_1_1__1__Impl )
            // InternalEduTest.g:1520:2: rule__MultiChoiceEmendation__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1_1__1"


    // $ANTLR start "rule__MultiChoiceEmendation__Group_1_1__1__Impl"
    // InternalEduTest.g:1526:1: rule__MultiChoiceEmendation__Group_1_1__1__Impl : ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceEmendation__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1530:1: ( ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1531:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1531:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1532:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1533:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:1533:3: rule__MultiChoiceEmendation__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__Group_1_1__1__Impl"


    // $ANTLR start "rule__MatchPairs__Group__0"
    // InternalEduTest.g:1542:1: rule__MatchPairs__Group__0 : rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1 ;
    public final void rule__MatchPairs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1546:1: ( rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1 )
            // InternalEduTest.g:1547:2: rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MatchPairs__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group__1();

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
    // $ANTLR end "rule__MatchPairs__Group__0"


    // $ANTLR start "rule__MatchPairs__Group__0__Impl"
    // InternalEduTest.g:1554:1: rule__MatchPairs__Group__0__Impl : ( 'MatchPairs' ) ;
    public final void rule__MatchPairs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1558:1: ( ( 'MatchPairs' ) )
            // InternalEduTest.g:1559:1: ( 'MatchPairs' )
            {
            // InternalEduTest.g:1559:1: ( 'MatchPairs' )
            // InternalEduTest.g:1560:2: 'MatchPairs'
            {
             before(grammarAccess.getMatchPairsAccess().getMatchPairsKeyword_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getMatchPairsAccess().getMatchPairsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group__0__Impl"


    // $ANTLR start "rule__MatchPairs__Group__1"
    // InternalEduTest.g:1569:1: rule__MatchPairs__Group__1 : rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2 ;
    public final void rule__MatchPairs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1573:1: ( rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2 )
            // InternalEduTest.g:1574:2: rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__MatchPairs__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group__2();

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
    // $ANTLR end "rule__MatchPairs__Group__1"


    // $ANTLR start "rule__MatchPairs__Group__1__Impl"
    // InternalEduTest.g:1581:1: rule__MatchPairs__Group__1__Impl : ( ( rule__MatchPairs__Group_1__0 )? ) ;
    public final void rule__MatchPairs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1585:1: ( ( ( rule__MatchPairs__Group_1__0 )? ) )
            // InternalEduTest.g:1586:1: ( ( rule__MatchPairs__Group_1__0 )? )
            {
            // InternalEduTest.g:1586:1: ( ( rule__MatchPairs__Group_1__0 )? )
            // InternalEduTest.g:1587:2: ( rule__MatchPairs__Group_1__0 )?
            {
             before(grammarAccess.getMatchPairsAccess().getGroup_1()); 
            // InternalEduTest.g:1588:2: ( rule__MatchPairs__Group_1__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalEduTest.g:1588:3: rule__MatchPairs__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MatchPairs__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMatchPairsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group__1__Impl"


    // $ANTLR start "rule__MatchPairs__Group__2"
    // InternalEduTest.g:1596:1: rule__MatchPairs__Group__2 : rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3 ;
    public final void rule__MatchPairs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1600:1: ( rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3 )
            // InternalEduTest.g:1601:2: rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__MatchPairs__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group__3();

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
    // $ANTLR end "rule__MatchPairs__Group__2"


    // $ANTLR start "rule__MatchPairs__Group__2__Impl"
    // InternalEduTest.g:1608:1: rule__MatchPairs__Group__2__Impl : ( '{' ) ;
    public final void rule__MatchPairs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1612:1: ( ( '{' ) )
            // InternalEduTest.g:1613:1: ( '{' )
            {
            // InternalEduTest.g:1613:1: ( '{' )
            // InternalEduTest.g:1614:2: '{'
            {
             before(grammarAccess.getMatchPairsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getMatchPairsAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group__2__Impl"


    // $ANTLR start "rule__MatchPairs__Group__3"
    // InternalEduTest.g:1623:1: rule__MatchPairs__Group__3 : rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4 ;
    public final void rule__MatchPairs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1627:1: ( rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4 )
            // InternalEduTest.g:1628:2: rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__MatchPairs__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group__4();

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
    // $ANTLR end "rule__MatchPairs__Group__3"


    // $ANTLR start "rule__MatchPairs__Group__3__Impl"
    // InternalEduTest.g:1635:1: rule__MatchPairs__Group__3__Impl : ( ( rule__MatchPairs__ConfigAssignment_3 ) ) ;
    public final void rule__MatchPairs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1639:1: ( ( ( rule__MatchPairs__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1640:1: ( ( rule__MatchPairs__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1640:1: ( ( rule__MatchPairs__ConfigAssignment_3 ) )
            // InternalEduTest.g:1641:2: ( rule__MatchPairs__ConfigAssignment_3 )
            {
             before(grammarAccess.getMatchPairsAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1642:2: ( rule__MatchPairs__ConfigAssignment_3 )
            // InternalEduTest.g:1642:3: rule__MatchPairs__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMatchPairsAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group__3__Impl"


    // $ANTLR start "rule__MatchPairs__Group__4"
    // InternalEduTest.g:1650:1: rule__MatchPairs__Group__4 : rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5 ;
    public final void rule__MatchPairs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1654:1: ( rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5 )
            // InternalEduTest.g:1655:2: rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__MatchPairs__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group__5();

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
    // $ANTLR end "rule__MatchPairs__Group__4"


    // $ANTLR start "rule__MatchPairs__Group__4__Impl"
    // InternalEduTest.g:1662:1: rule__MatchPairs__Group__4__Impl : ( ( rule__MatchPairs__TestsAssignment_4 )* ) ;
    public final void rule__MatchPairs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1666:1: ( ( ( rule__MatchPairs__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1667:1: ( ( rule__MatchPairs__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1667:1: ( ( rule__MatchPairs__TestsAssignment_4 )* )
            // InternalEduTest.g:1668:2: ( rule__MatchPairs__TestsAssignment_4 )*
            {
             before(grammarAccess.getMatchPairsAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1669:2: ( rule__MatchPairs__TestsAssignment_4 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==38) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalEduTest.g:1669:3: rule__MatchPairs__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MatchPairs__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getMatchPairsAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group__4__Impl"


    // $ANTLR start "rule__MatchPairs__Group__5"
    // InternalEduTest.g:1677:1: rule__MatchPairs__Group__5 : rule__MatchPairs__Group__5__Impl ;
    public final void rule__MatchPairs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1681:1: ( rule__MatchPairs__Group__5__Impl )
            // InternalEduTest.g:1682:2: rule__MatchPairs__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group__5__Impl();

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
    // $ANTLR end "rule__MatchPairs__Group__5"


    // $ANTLR start "rule__MatchPairs__Group__5__Impl"
    // InternalEduTest.g:1688:1: rule__MatchPairs__Group__5__Impl : ( '}' ) ;
    public final void rule__MatchPairs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1692:1: ( ( '}' ) )
            // InternalEduTest.g:1693:1: ( '}' )
            {
            // InternalEduTest.g:1693:1: ( '}' )
            // InternalEduTest.g:1694:2: '}'
            {
             before(grammarAccess.getMatchPairsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getMatchPairsAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group__5__Impl"


    // $ANTLR start "rule__MatchPairs__Group_1__0"
    // InternalEduTest.g:1704:1: rule__MatchPairs__Group_1__0 : rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1 ;
    public final void rule__MatchPairs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1708:1: ( rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1 )
            // InternalEduTest.g:1709:2: rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__MatchPairs__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group_1__1();

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
    // $ANTLR end "rule__MatchPairs__Group_1__0"


    // $ANTLR start "rule__MatchPairs__Group_1__0__Impl"
    // InternalEduTest.g:1716:1: rule__MatchPairs__Group_1__0__Impl : ( ( rule__MatchPairs__BlocksAssignment_1_0 ) ) ;
    public final void rule__MatchPairs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1720:1: ( ( ( rule__MatchPairs__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1721:1: ( ( rule__MatchPairs__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1721:1: ( ( rule__MatchPairs__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1722:2: ( rule__MatchPairs__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1723:2: ( rule__MatchPairs__BlocksAssignment_1_0 )
            // InternalEduTest.g:1723:3: rule__MatchPairs__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMatchPairsAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group_1__0__Impl"


    // $ANTLR start "rule__MatchPairs__Group_1__1"
    // InternalEduTest.g:1731:1: rule__MatchPairs__Group_1__1 : rule__MatchPairs__Group_1__1__Impl ;
    public final void rule__MatchPairs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1735:1: ( rule__MatchPairs__Group_1__1__Impl )
            // InternalEduTest.g:1736:2: rule__MatchPairs__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group_1__1__Impl();

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
    // $ANTLR end "rule__MatchPairs__Group_1__1"


    // $ANTLR start "rule__MatchPairs__Group_1__1__Impl"
    // InternalEduTest.g:1742:1: rule__MatchPairs__Group_1__1__Impl : ( ( rule__MatchPairs__Group_1_1__0 )* ) ;
    public final void rule__MatchPairs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1746:1: ( ( ( rule__MatchPairs__Group_1_1__0 )* ) )
            // InternalEduTest.g:1747:1: ( ( rule__MatchPairs__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1747:1: ( ( rule__MatchPairs__Group_1_1__0 )* )
            // InternalEduTest.g:1748:2: ( rule__MatchPairs__Group_1_1__0 )*
            {
             before(grammarAccess.getMatchPairsAccess().getGroup_1_1()); 
            // InternalEduTest.g:1749:2: ( rule__MatchPairs__Group_1_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==26) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalEduTest.g:1749:3: rule__MatchPairs__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MatchPairs__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getMatchPairsAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group_1__1__Impl"


    // $ANTLR start "rule__MatchPairs__Group_1_1__0"
    // InternalEduTest.g:1758:1: rule__MatchPairs__Group_1_1__0 : rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1 ;
    public final void rule__MatchPairs__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1762:1: ( rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1 )
            // InternalEduTest.g:1763:2: rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
            rule__MatchPairs__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group_1_1__1();

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
    // $ANTLR end "rule__MatchPairs__Group_1_1__0"


    // $ANTLR start "rule__MatchPairs__Group_1_1__0__Impl"
    // InternalEduTest.g:1770:1: rule__MatchPairs__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MatchPairs__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1774:1: ( ( ',' ) )
            // InternalEduTest.g:1775:1: ( ',' )
            {
            // InternalEduTest.g:1775:1: ( ',' )
            // InternalEduTest.g:1776:2: ','
            {
             before(grammarAccess.getMatchPairsAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMatchPairsAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group_1_1__0__Impl"


    // $ANTLR start "rule__MatchPairs__Group_1_1__1"
    // InternalEduTest.g:1785:1: rule__MatchPairs__Group_1_1__1 : rule__MatchPairs__Group_1_1__1__Impl ;
    public final void rule__MatchPairs__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1789:1: ( rule__MatchPairs__Group_1_1__1__Impl )
            // InternalEduTest.g:1790:2: rule__MatchPairs__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__MatchPairs__Group_1_1__1"


    // $ANTLR start "rule__MatchPairs__Group_1_1__1__Impl"
    // InternalEduTest.g:1796:1: rule__MatchPairs__Group_1_1__1__Impl : ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MatchPairs__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1800:1: ( ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1801:1: ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1801:1: ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1802:2: ( rule__MatchPairs__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1803:2: ( rule__MatchPairs__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:1803:3: rule__MatchPairs__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMatchPairsAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__Group_1_1__1__Impl"


    // $ANTLR start "rule__MissingWords__Group__0"
    // InternalEduTest.g:1812:1: rule__MissingWords__Group__0 : rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1 ;
    public final void rule__MissingWords__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1816:1: ( rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1 )
            // InternalEduTest.g:1817:2: rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MissingWords__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissingWords__Group__1();

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
    // $ANTLR end "rule__MissingWords__Group__0"


    // $ANTLR start "rule__MissingWords__Group__0__Impl"
    // InternalEduTest.g:1824:1: rule__MissingWords__Group__0__Impl : ( 'MissingWords' ) ;
    public final void rule__MissingWords__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1828:1: ( ( 'MissingWords' ) )
            // InternalEduTest.g:1829:1: ( 'MissingWords' )
            {
            // InternalEduTest.g:1829:1: ( 'MissingWords' )
            // InternalEduTest.g:1830:2: 'MissingWords'
            {
             before(grammarAccess.getMissingWordsAccess().getMissingWordsKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getMissingWordsAccess().getMissingWordsKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group__0__Impl"


    // $ANTLR start "rule__MissingWords__Group__1"
    // InternalEduTest.g:1839:1: rule__MissingWords__Group__1 : rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2 ;
    public final void rule__MissingWords__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1843:1: ( rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2 )
            // InternalEduTest.g:1844:2: rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__MissingWords__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissingWords__Group__2();

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
    // $ANTLR end "rule__MissingWords__Group__1"


    // $ANTLR start "rule__MissingWords__Group__1__Impl"
    // InternalEduTest.g:1851:1: rule__MissingWords__Group__1__Impl : ( ( rule__MissingWords__Group_1__0 )? ) ;
    public final void rule__MissingWords__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1855:1: ( ( ( rule__MissingWords__Group_1__0 )? ) )
            // InternalEduTest.g:1856:1: ( ( rule__MissingWords__Group_1__0 )? )
            {
            // InternalEduTest.g:1856:1: ( ( rule__MissingWords__Group_1__0 )? )
            // InternalEduTest.g:1857:2: ( rule__MissingWords__Group_1__0 )?
            {
             before(grammarAccess.getMissingWordsAccess().getGroup_1()); 
            // InternalEduTest.g:1858:2: ( rule__MissingWords__Group_1__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalEduTest.g:1858:3: rule__MissingWords__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MissingWords__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMissingWordsAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group__1__Impl"


    // $ANTLR start "rule__MissingWords__Group__2"
    // InternalEduTest.g:1866:1: rule__MissingWords__Group__2 : rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3 ;
    public final void rule__MissingWords__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1870:1: ( rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3 )
            // InternalEduTest.g:1871:2: rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__MissingWords__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissingWords__Group__3();

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
    // $ANTLR end "rule__MissingWords__Group__2"


    // $ANTLR start "rule__MissingWords__Group__2__Impl"
    // InternalEduTest.g:1878:1: rule__MissingWords__Group__2__Impl : ( '{' ) ;
    public final void rule__MissingWords__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1882:1: ( ( '{' ) )
            // InternalEduTest.g:1883:1: ( '{' )
            {
            // InternalEduTest.g:1883:1: ( '{' )
            // InternalEduTest.g:1884:2: '{'
            {
             before(grammarAccess.getMissingWordsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getMissingWordsAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group__2__Impl"


    // $ANTLR start "rule__MissingWords__Group__3"
    // InternalEduTest.g:1893:1: rule__MissingWords__Group__3 : rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4 ;
    public final void rule__MissingWords__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1897:1: ( rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4 )
            // InternalEduTest.g:1898:2: rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__MissingWords__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissingWords__Group__4();

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
    // $ANTLR end "rule__MissingWords__Group__3"


    // $ANTLR start "rule__MissingWords__Group__3__Impl"
    // InternalEduTest.g:1905:1: rule__MissingWords__Group__3__Impl : ( ( rule__MissingWords__ConfigAssignment_3 ) ) ;
    public final void rule__MissingWords__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1909:1: ( ( ( rule__MissingWords__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1910:1: ( ( rule__MissingWords__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1910:1: ( ( rule__MissingWords__ConfigAssignment_3 ) )
            // InternalEduTest.g:1911:2: ( rule__MissingWords__ConfigAssignment_3 )
            {
             before(grammarAccess.getMissingWordsAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1912:2: ( rule__MissingWords__ConfigAssignment_3 )
            // InternalEduTest.g:1912:3: rule__MissingWords__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMissingWordsAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group__3__Impl"


    // $ANTLR start "rule__MissingWords__Group__4"
    // InternalEduTest.g:1920:1: rule__MissingWords__Group__4 : rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5 ;
    public final void rule__MissingWords__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1924:1: ( rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5 )
            // InternalEduTest.g:1925:2: rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__MissingWords__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissingWords__Group__5();

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
    // $ANTLR end "rule__MissingWords__Group__4"


    // $ANTLR start "rule__MissingWords__Group__4__Impl"
    // InternalEduTest.g:1932:1: rule__MissingWords__Group__4__Impl : ( ( rule__MissingWords__TestsAssignment_4 )* ) ;
    public final void rule__MissingWords__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1936:1: ( ( ( rule__MissingWords__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1937:1: ( ( rule__MissingWords__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1937:1: ( ( rule__MissingWords__TestsAssignment_4 )* )
            // InternalEduTest.g:1938:2: ( rule__MissingWords__TestsAssignment_4 )*
            {
             before(grammarAccess.getMissingWordsAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1939:2: ( rule__MissingWords__TestsAssignment_4 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==38) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalEduTest.g:1939:3: rule__MissingWords__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MissingWords__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getMissingWordsAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group__4__Impl"


    // $ANTLR start "rule__MissingWords__Group__5"
    // InternalEduTest.g:1947:1: rule__MissingWords__Group__5 : rule__MissingWords__Group__5__Impl ;
    public final void rule__MissingWords__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1951:1: ( rule__MissingWords__Group__5__Impl )
            // InternalEduTest.g:1952:2: rule__MissingWords__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__Group__5__Impl();

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
    // $ANTLR end "rule__MissingWords__Group__5"


    // $ANTLR start "rule__MissingWords__Group__5__Impl"
    // InternalEduTest.g:1958:1: rule__MissingWords__Group__5__Impl : ( '}' ) ;
    public final void rule__MissingWords__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1962:1: ( ( '}' ) )
            // InternalEduTest.g:1963:1: ( '}' )
            {
            // InternalEduTest.g:1963:1: ( '}' )
            // InternalEduTest.g:1964:2: '}'
            {
             before(grammarAccess.getMissingWordsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getMissingWordsAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group__5__Impl"


    // $ANTLR start "rule__MissingWords__Group_1__0"
    // InternalEduTest.g:1974:1: rule__MissingWords__Group_1__0 : rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1 ;
    public final void rule__MissingWords__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1978:1: ( rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1 )
            // InternalEduTest.g:1979:2: rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1
            {
            pushFollow(FOLLOW_9);
            rule__MissingWords__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissingWords__Group_1__1();

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
    // $ANTLR end "rule__MissingWords__Group_1__0"


    // $ANTLR start "rule__MissingWords__Group_1__0__Impl"
    // InternalEduTest.g:1986:1: rule__MissingWords__Group_1__0__Impl : ( ( rule__MissingWords__BlocksAssignment_1_0 ) ) ;
    public final void rule__MissingWords__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1990:1: ( ( ( rule__MissingWords__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1991:1: ( ( rule__MissingWords__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1991:1: ( ( rule__MissingWords__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1992:2: ( rule__MissingWords__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1993:2: ( rule__MissingWords__BlocksAssignment_1_0 )
            // InternalEduTest.g:1993:3: rule__MissingWords__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMissingWordsAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group_1__0__Impl"


    // $ANTLR start "rule__MissingWords__Group_1__1"
    // InternalEduTest.g:2001:1: rule__MissingWords__Group_1__1 : rule__MissingWords__Group_1__1__Impl ;
    public final void rule__MissingWords__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2005:1: ( rule__MissingWords__Group_1__1__Impl )
            // InternalEduTest.g:2006:2: rule__MissingWords__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__Group_1__1__Impl();

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
    // $ANTLR end "rule__MissingWords__Group_1__1"


    // $ANTLR start "rule__MissingWords__Group_1__1__Impl"
    // InternalEduTest.g:2012:1: rule__MissingWords__Group_1__1__Impl : ( ( rule__MissingWords__Group_1_1__0 )* ) ;
    public final void rule__MissingWords__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2016:1: ( ( ( rule__MissingWords__Group_1_1__0 )* ) )
            // InternalEduTest.g:2017:1: ( ( rule__MissingWords__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2017:1: ( ( rule__MissingWords__Group_1_1__0 )* )
            // InternalEduTest.g:2018:2: ( rule__MissingWords__Group_1_1__0 )*
            {
             before(grammarAccess.getMissingWordsAccess().getGroup_1_1()); 
            // InternalEduTest.g:2019:2: ( rule__MissingWords__Group_1_1__0 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==26) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalEduTest.g:2019:3: rule__MissingWords__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MissingWords__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getMissingWordsAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group_1__1__Impl"


    // $ANTLR start "rule__MissingWords__Group_1_1__0"
    // InternalEduTest.g:2028:1: rule__MissingWords__Group_1_1__0 : rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1 ;
    public final void rule__MissingWords__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2032:1: ( rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1 )
            // InternalEduTest.g:2033:2: rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
            rule__MissingWords__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MissingWords__Group_1_1__1();

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
    // $ANTLR end "rule__MissingWords__Group_1_1__0"


    // $ANTLR start "rule__MissingWords__Group_1_1__0__Impl"
    // InternalEduTest.g:2040:1: rule__MissingWords__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MissingWords__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2044:1: ( ( ',' ) )
            // InternalEduTest.g:2045:1: ( ',' )
            {
            // InternalEduTest.g:2045:1: ( ',' )
            // InternalEduTest.g:2046:2: ','
            {
             before(grammarAccess.getMissingWordsAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMissingWordsAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group_1_1__0__Impl"


    // $ANTLR start "rule__MissingWords__Group_1_1__1"
    // InternalEduTest.g:2055:1: rule__MissingWords__Group_1_1__1 : rule__MissingWords__Group_1_1__1__Impl ;
    public final void rule__MissingWords__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2059:1: ( rule__MissingWords__Group_1_1__1__Impl )
            // InternalEduTest.g:2060:2: rule__MissingWords__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__Group_1_1__1__Impl();

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
    // $ANTLR end "rule__MissingWords__Group_1_1__1"


    // $ANTLR start "rule__MissingWords__Group_1_1__1__Impl"
    // InternalEduTest.g:2066:1: rule__MissingWords__Group_1_1__1__Impl : ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MissingWords__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2070:1: ( ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2071:1: ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2071:1: ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2072:2: ( rule__MissingWords__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2073:2: ( rule__MissingWords__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:2073:3: rule__MissingWords__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMissingWordsAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__Group_1_1__1__Impl"


    // $ANTLR start "rule__ProgramConfiguration__Group__0"
    // InternalEduTest.g:2082:1: rule__ProgramConfiguration__Group__0 : rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 ;
    public final void rule__ProgramConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2086:1: ( rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 )
            // InternalEduTest.g:2087:2: rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1
            {
            pushFollow(FOLLOW_12);
            rule__ProgramConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProgramConfiguration__Group__1();

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
    // $ANTLR end "rule__ProgramConfiguration__Group__0"


    // $ANTLR start "rule__ProgramConfiguration__Group__0__Impl"
    // InternalEduTest.g:2094:1: rule__ProgramConfiguration__Group__0__Impl : ( 'navigation' ) ;
    public final void rule__ProgramConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2098:1: ( ( 'navigation' ) )
            // InternalEduTest.g:2099:1: ( 'navigation' )
            {
            // InternalEduTest.g:2099:1: ( 'navigation' )
            // InternalEduTest.g:2100:2: 'navigation'
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProgramConfiguration__Group__0__Impl"


    // $ANTLR start "rule__ProgramConfiguration__Group__1"
    // InternalEduTest.g:2109:1: rule__ProgramConfiguration__Group__1 : rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 ;
    public final void rule__ProgramConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2113:1: ( rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 )
            // InternalEduTest.g:2114:2: rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2
            {
            pushFollow(FOLLOW_13);
            rule__ProgramConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ProgramConfiguration__Group__2();

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
    // $ANTLR end "rule__ProgramConfiguration__Group__1"


    // $ANTLR start "rule__ProgramConfiguration__Group__1__Impl"
    // InternalEduTest.g:2121:1: rule__ProgramConfiguration__Group__1__Impl : ( '=' ) ;
    public final void rule__ProgramConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2125:1: ( ( '=' ) )
            // InternalEduTest.g:2126:1: ( '=' )
            {
            // InternalEduTest.g:2126:1: ( '=' )
            // InternalEduTest.g:2127:2: '='
            {
             before(grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProgramConfiguration__Group__1__Impl"


    // $ANTLR start "rule__ProgramConfiguration__Group__2"
    // InternalEduTest.g:2136:1: rule__ProgramConfiguration__Group__2 : rule__ProgramConfiguration__Group__2__Impl ;
    public final void rule__ProgramConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2140:1: ( rule__ProgramConfiguration__Group__2__Impl )
            // InternalEduTest.g:2141:2: rule__ProgramConfiguration__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ProgramConfiguration__Group__2__Impl();

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
    // $ANTLR end "rule__ProgramConfiguration__Group__2"


    // $ANTLR start "rule__ProgramConfiguration__Group__2__Impl"
    // InternalEduTest.g:2147:1: rule__ProgramConfiguration__Group__2__Impl : ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) ;
    public final void rule__ProgramConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2151:1: ( ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) )
            // InternalEduTest.g:2152:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            {
            // InternalEduTest.g:2152:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            // InternalEduTest.g:2153:2: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationAssignment_2()); 
            // InternalEduTest.g:2154:2: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            // InternalEduTest.g:2154:3: rule__ProgramConfiguration__NavigationAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ProgramConfiguration__NavigationAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getProgramConfigurationAccess().getNavigationAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProgramConfiguration__Group__2__Impl"


    // $ANTLR start "rule__TestConfiguration__Group__0"
    // InternalEduTest.g:2163:1: rule__TestConfiguration__Group__0 : rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 ;
    public final void rule__TestConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2167:1: ( rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 )
            // InternalEduTest.g:2168:2: rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__TestConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__1();

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
    // $ANTLR end "rule__TestConfiguration__Group__0"


    // $ANTLR start "rule__TestConfiguration__Group__0__Impl"
    // InternalEduTest.g:2175:1: rule__TestConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__TestConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2179:1: ( ( () ) )
            // InternalEduTest.g:2180:1: ( () )
            {
            // InternalEduTest.g:2180:1: ( () )
            // InternalEduTest.g:2181:2: ()
            {
             before(grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0()); 
            // InternalEduTest.g:2182:2: ()
            // InternalEduTest.g:2182:3: 
            {
            }

             after(grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__0__Impl"


    // $ANTLR start "rule__TestConfiguration__Group__1"
    // InternalEduTest.g:2190:1: rule__TestConfiguration__Group__1 : rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 ;
    public final void rule__TestConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2194:1: ( rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 )
            // InternalEduTest.g:2195:2: rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__TestConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__2();

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
    // $ANTLR end "rule__TestConfiguration__Group__1"


    // $ANTLR start "rule__TestConfiguration__Group__1__Impl"
    // InternalEduTest.g:2202:1: rule__TestConfiguration__Group__1__Impl : ( 'retry' ) ;
    public final void rule__TestConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2206:1: ( ( 'retry' ) )
            // InternalEduTest.g:2207:1: ( 'retry' )
            {
            // InternalEduTest.g:2207:1: ( 'retry' )
            // InternalEduTest.g:2208:2: 'retry'
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getRetryKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__1__Impl"


    // $ANTLR start "rule__TestConfiguration__Group__2"
    // InternalEduTest.g:2217:1: rule__TestConfiguration__Group__2 : rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 ;
    public final void rule__TestConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2221:1: ( rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 )
            // InternalEduTest.g:2222:2: rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__TestConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__3();

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
    // $ANTLR end "rule__TestConfiguration__Group__2"


    // $ANTLR start "rule__TestConfiguration__Group__2__Impl"
    // InternalEduTest.g:2229:1: rule__TestConfiguration__Group__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2233:1: ( ( '=' ) )
            // InternalEduTest.g:2234:1: ( '=' )
            {
            // InternalEduTest.g:2234:1: ( '=' )
            // InternalEduTest.g:2235:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__2__Impl"


    // $ANTLR start "rule__TestConfiguration__Group__3"
    // InternalEduTest.g:2244:1: rule__TestConfiguration__Group__3 : rule__TestConfiguration__Group__3__Impl ;
    public final void rule__TestConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2248:1: ( rule__TestConfiguration__Group__3__Impl )
            // InternalEduTest.g:2249:2: rule__TestConfiguration__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__3__Impl();

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
    // $ANTLR end "rule__TestConfiguration__Group__3"


    // $ANTLR start "rule__TestConfiguration__Group__3__Impl"
    // InternalEduTest.g:2255:1: rule__TestConfiguration__Group__3__Impl : ( ( rule__TestConfiguration__RetryAssignment_3 ) ) ;
    public final void rule__TestConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2259:1: ( ( ( rule__TestConfiguration__RetryAssignment_3 ) ) )
            // InternalEduTest.g:2260:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:2260:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            // InternalEduTest.g:2261:2: ( rule__TestConfiguration__RetryAssignment_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:2262:2: ( rule__TestConfiguration__RetryAssignment_3 )
            // InternalEduTest.g:2262:3: rule__TestConfiguration__RetryAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__RetryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getRetryAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__3__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__0"
    // InternalEduTest.g:2271:1: rule__MultiChoiceEmConfig__Group__0 : rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 ;
    public final void rule__MultiChoiceEmConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2275:1: ( rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 )
            // InternalEduTest.g:2276:2: rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__MultiChoiceEmConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__1();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__0"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__0__Impl"
    // InternalEduTest.g:2283:1: rule__MultiChoiceEmConfig__Group__0__Impl : ( () ) ;
    public final void rule__MultiChoiceEmConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2287:1: ( ( () ) )
            // InternalEduTest.g:2288:1: ( () )
            {
            // InternalEduTest.g:2288:1: ( () )
            // InternalEduTest.g:2289:2: ()
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0()); 
            // InternalEduTest.g:2290:2: ()
            // InternalEduTest.g:2290:3: 
            {
            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__1"
    // InternalEduTest.g:2298:1: rule__MultiChoiceEmConfig__Group__1 : rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 ;
    public final void rule__MultiChoiceEmConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2302:1: ( rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 )
            // InternalEduTest.g:2303:2: rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2
            {
            pushFollow(FOLLOW_12);
            rule__MultiChoiceEmConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__2();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__1"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__1__Impl"
    // InternalEduTest.g:2310:1: rule__MultiChoiceEmConfig__Group__1__Impl : ( 'retry' ) ;
    public final void rule__MultiChoiceEmConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2314:1: ( ( 'retry' ) )
            // InternalEduTest.g:2315:1: ( 'retry' )
            {
            // InternalEduTest.g:2315:1: ( 'retry' )
            // InternalEduTest.g:2316:2: 'retry'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__2"
    // InternalEduTest.g:2325:1: rule__MultiChoiceEmConfig__Group__2 : rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 ;
    public final void rule__MultiChoiceEmConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2329:1: ( rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 )
            // InternalEduTest.g:2330:2: rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__MultiChoiceEmConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__3();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__2"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__2__Impl"
    // InternalEduTest.g:2337:1: rule__MultiChoiceEmConfig__Group__2__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2341:1: ( ( '=' ) )
            // InternalEduTest.g:2342:1: ( '=' )
            {
            // InternalEduTest.g:2342:1: ( '=' )
            // InternalEduTest.g:2343:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__2__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__3"
    // InternalEduTest.g:2352:1: rule__MultiChoiceEmConfig__Group__3 : rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 ;
    public final void rule__MultiChoiceEmConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2356:1: ( rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 )
            // InternalEduTest.g:2357:2: rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__MultiChoiceEmConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__4();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__3"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__3__Impl"
    // InternalEduTest.g:2364:1: rule__MultiChoiceEmConfig__Group__3__Impl : ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2368:1: ( ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) )
            // InternalEduTest.g:2369:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:2369:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            // InternalEduTest.g:2370:2: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:2371:2: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            // InternalEduTest.g:2371:3: rule__MultiChoiceEmConfig__RetryAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__RetryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__3__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__4"
    // InternalEduTest.g:2379:1: rule__MultiChoiceEmConfig__Group__4 : rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 ;
    public final void rule__MultiChoiceEmConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2383:1: ( rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 )
            // InternalEduTest.g:2384:2: rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5
            {
            pushFollow(FOLLOW_15);
            rule__MultiChoiceEmConfig__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__5();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__4"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__4__Impl"
    // InternalEduTest.g:2391:1: rule__MultiChoiceEmConfig__Group__4__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2395:1: ( ( ',' ) )
            // InternalEduTest.g:2396:1: ( ',' )
            {
            // InternalEduTest.g:2396:1: ( ',' )
            // InternalEduTest.g:2397:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_4()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__4__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__5"
    // InternalEduTest.g:2406:1: rule__MultiChoiceEmConfig__Group__5 : rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 ;
    public final void rule__MultiChoiceEmConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2410:1: ( rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 )
            // InternalEduTest.g:2411:2: rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__MultiChoiceEmConfig__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__6();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__5"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__5__Impl"
    // InternalEduTest.g:2418:1: rule__MultiChoiceEmConfig__Group__5__Impl : ( 'weighted' ) ;
    public final void rule__MultiChoiceEmConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2422:1: ( ( 'weighted' ) )
            // InternalEduTest.g:2423:1: ( 'weighted' )
            {
            // InternalEduTest.g:2423:1: ( 'weighted' )
            // InternalEduTest.g:2424:2: 'weighted'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__5__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__6"
    // InternalEduTest.g:2433:1: rule__MultiChoiceEmConfig__Group__6 : rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 ;
    public final void rule__MultiChoiceEmConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2437:1: ( rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 )
            // InternalEduTest.g:2438:2: rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7
            {
            pushFollow(FOLLOW_14);
            rule__MultiChoiceEmConfig__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__7();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__6"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__6__Impl"
    // InternalEduTest.g:2445:1: rule__MultiChoiceEmConfig__Group__6__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2449:1: ( ( '=' ) )
            // InternalEduTest.g:2450:1: ( '=' )
            {
            // InternalEduTest.g:2450:1: ( '=' )
            // InternalEduTest.g:2451:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__6__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__7"
    // InternalEduTest.g:2460:1: rule__MultiChoiceEmConfig__Group__7 : rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 ;
    public final void rule__MultiChoiceEmConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2464:1: ( rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 )
            // InternalEduTest.g:2465:2: rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__MultiChoiceEmConfig__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__8();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__7"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__7__Impl"
    // InternalEduTest.g:2472:1: rule__MultiChoiceEmConfig__Group__7__Impl : ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2476:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) )
            // InternalEduTest.g:2477:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            {
            // InternalEduTest.g:2477:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            // InternalEduTest.g:2478:2: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAssignment_7()); 
            // InternalEduTest.g:2479:2: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            // InternalEduTest.g:2479:3: rule__MultiChoiceEmConfig__WeightedAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__WeightedAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__7__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__8"
    // InternalEduTest.g:2487:1: rule__MultiChoiceEmConfig__Group__8 : rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 ;
    public final void rule__MultiChoiceEmConfig__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2491:1: ( rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 )
            // InternalEduTest.g:2492:2: rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9
            {
            pushFollow(FOLLOW_16);
            rule__MultiChoiceEmConfig__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__9();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__8"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__8__Impl"
    // InternalEduTest.g:2499:1: rule__MultiChoiceEmConfig__Group__8__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2503:1: ( ( ',' ) )
            // InternalEduTest.g:2504:1: ( ',' )
            {
            // InternalEduTest.g:2504:1: ( ',' )
            // InternalEduTest.g:2505:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_8()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__8__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__9"
    // InternalEduTest.g:2514:1: rule__MultiChoiceEmConfig__Group__9 : rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 ;
    public final void rule__MultiChoiceEmConfig__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2518:1: ( rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 )
            // InternalEduTest.g:2519:2: rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10
            {
            pushFollow(FOLLOW_12);
            rule__MultiChoiceEmConfig__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__10();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__9"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__9__Impl"
    // InternalEduTest.g:2526:1: rule__MultiChoiceEmConfig__Group__9__Impl : ( 'penalty' ) ;
    public final void rule__MultiChoiceEmConfig__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2530:1: ( ( 'penalty' ) )
            // InternalEduTest.g:2531:1: ( 'penalty' )
            {
            // InternalEduTest.g:2531:1: ( 'penalty' )
            // InternalEduTest.g:2532:2: 'penalty'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__9__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__10"
    // InternalEduTest.g:2541:1: rule__MultiChoiceEmConfig__Group__10 : rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 ;
    public final void rule__MultiChoiceEmConfig__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2545:1: ( rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 )
            // InternalEduTest.g:2546:2: rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11
            {
            pushFollow(FOLLOW_17);
            rule__MultiChoiceEmConfig__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__11();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__10"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__10__Impl"
    // InternalEduTest.g:2553:1: rule__MultiChoiceEmConfig__Group__10__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2557:1: ( ( '=' ) )
            // InternalEduTest.g:2558:1: ( '=' )
            {
            // InternalEduTest.g:2558:1: ( '=' )
            // InternalEduTest.g:2559:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__10__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__11"
    // InternalEduTest.g:2568:1: rule__MultiChoiceEmConfig__Group__11 : rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 ;
    public final void rule__MultiChoiceEmConfig__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2572:1: ( rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 )
            // InternalEduTest.g:2573:2: rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12
            {
            pushFollow(FOLLOW_9);
            rule__MultiChoiceEmConfig__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__12();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__11"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__11__Impl"
    // InternalEduTest.g:2580:1: rule__MultiChoiceEmConfig__Group__11__Impl : ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2584:1: ( ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) )
            // InternalEduTest.g:2585:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            {
            // InternalEduTest.g:2585:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            // InternalEduTest.g:2586:2: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyAssignment_11()); 
            // InternalEduTest.g:2587:2: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            // InternalEduTest.g:2587:3: rule__MultiChoiceEmConfig__PenaltyAssignment_11
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__PenaltyAssignment_11();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyAssignment_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__11__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__12"
    // InternalEduTest.g:2595:1: rule__MultiChoiceEmConfig__Group__12 : rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 ;
    public final void rule__MultiChoiceEmConfig__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2599:1: ( rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 )
            // InternalEduTest.g:2600:2: rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13
            {
            pushFollow(FOLLOW_18);
            rule__MultiChoiceEmConfig__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__13();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__12"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__12__Impl"
    // InternalEduTest.g:2607:1: rule__MultiChoiceEmConfig__Group__12__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2611:1: ( ( ',' ) )
            // InternalEduTest.g:2612:1: ( ',' )
            {
            // InternalEduTest.g:2612:1: ( ',' )
            // InternalEduTest.g:2613:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_12()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__12__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__13"
    // InternalEduTest.g:2622:1: rule__MultiChoiceEmConfig__Group__13 : rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 ;
    public final void rule__MultiChoiceEmConfig__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2626:1: ( rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 )
            // InternalEduTest.g:2627:2: rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14
            {
            pushFollow(FOLLOW_12);
            rule__MultiChoiceEmConfig__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__14();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__13"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__13__Impl"
    // InternalEduTest.g:2634:1: rule__MultiChoiceEmConfig__Group__13__Impl : ( 'order' ) ;
    public final void rule__MultiChoiceEmConfig__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2638:1: ( ( 'order' ) )
            // InternalEduTest.g:2639:1: ( 'order' )
            {
            // InternalEduTest.g:2639:1: ( 'order' )
            // InternalEduTest.g:2640:2: 'order'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__13__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__14"
    // InternalEduTest.g:2649:1: rule__MultiChoiceEmConfig__Group__14 : rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 ;
    public final void rule__MultiChoiceEmConfig__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2653:1: ( rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 )
            // InternalEduTest.g:2654:2: rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15
            {
            pushFollow(FOLLOW_19);
            rule__MultiChoiceEmConfig__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__15();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__14"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__14__Impl"
    // InternalEduTest.g:2661:1: rule__MultiChoiceEmConfig__Group__14__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2665:1: ( ( '=' ) )
            // InternalEduTest.g:2666:1: ( '=' )
            {
            // InternalEduTest.g:2666:1: ( '=' )
            // InternalEduTest.g:2667:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__14__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__15"
    // InternalEduTest.g:2676:1: rule__MultiChoiceEmConfig__Group__15 : rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 ;
    public final void rule__MultiChoiceEmConfig__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2680:1: ( rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 )
            // InternalEduTest.g:2681:2: rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16
            {
            pushFollow(FOLLOW_9);
            rule__MultiChoiceEmConfig__Group__15__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__16();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__15"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__15__Impl"
    // InternalEduTest.g:2688:1: rule__MultiChoiceEmConfig__Group__15__Impl : ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2692:1: ( ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) )
            // InternalEduTest.g:2693:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            {
            // InternalEduTest.g:2693:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            // InternalEduTest.g:2694:2: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderAssignment_15()); 
            // InternalEduTest.g:2695:2: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            // InternalEduTest.g:2695:3: rule__MultiChoiceEmConfig__OrderAssignment_15
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__OrderAssignment_15();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getOrderAssignment_15()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__15__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__16"
    // InternalEduTest.g:2703:1: rule__MultiChoiceEmConfig__Group__16 : rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 ;
    public final void rule__MultiChoiceEmConfig__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2707:1: ( rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 )
            // InternalEduTest.g:2708:2: rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17
            {
            pushFollow(FOLLOW_20);
            rule__MultiChoiceEmConfig__Group__16__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__17();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__16"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__16__Impl"
    // InternalEduTest.g:2715:1: rule__MultiChoiceEmConfig__Group__16__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2719:1: ( ( ',' ) )
            // InternalEduTest.g:2720:1: ( ',' )
            {
            // InternalEduTest.g:2720:1: ( ',' )
            // InternalEduTest.g:2721:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_16()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_16()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__16__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__17"
    // InternalEduTest.g:2730:1: rule__MultiChoiceEmConfig__Group__17 : rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 ;
    public final void rule__MultiChoiceEmConfig__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2734:1: ( rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 )
            // InternalEduTest.g:2735:2: rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18
            {
            pushFollow(FOLLOW_12);
            rule__MultiChoiceEmConfig__Group__17__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__18();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__17"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__17__Impl"
    // InternalEduTest.g:2742:1: rule__MultiChoiceEmConfig__Group__17__Impl : ( 'mode' ) ;
    public final void rule__MultiChoiceEmConfig__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2746:1: ( ( 'mode' ) )
            // InternalEduTest.g:2747:1: ( 'mode' )
            {
            // InternalEduTest.g:2747:1: ( 'mode' )
            // InternalEduTest.g:2748:2: 'mode'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__17__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__18"
    // InternalEduTest.g:2757:1: rule__MultiChoiceEmConfig__Group__18 : rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 ;
    public final void rule__MultiChoiceEmConfig__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2761:1: ( rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 )
            // InternalEduTest.g:2762:2: rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19
            {
            pushFollow(FOLLOW_21);
            rule__MultiChoiceEmConfig__Group__18__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__19();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__18"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__18__Impl"
    // InternalEduTest.g:2769:1: rule__MultiChoiceEmConfig__Group__18__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2773:1: ( ( '=' ) )
            // InternalEduTest.g:2774:1: ( '=' )
            {
            // InternalEduTest.g:2774:1: ( '=' )
            // InternalEduTest.g:2775:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__18__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__19"
    // InternalEduTest.g:2784:1: rule__MultiChoiceEmConfig__Group__19 : rule__MultiChoiceEmConfig__Group__19__Impl ;
    public final void rule__MultiChoiceEmConfig__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2788:1: ( rule__MultiChoiceEmConfig__Group__19__Impl )
            // InternalEduTest.g:2789:2: rule__MultiChoiceEmConfig__Group__19__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__19__Impl();

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
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__19"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__19__Impl"
    // InternalEduTest.g:2795:1: rule__MultiChoiceEmConfig__Group__19__Impl : ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2799:1: ( ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) )
            // InternalEduTest.g:2800:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            {
            // InternalEduTest.g:2800:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            // InternalEduTest.g:2801:2: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeAssignment_19()); 
            // InternalEduTest.g:2802:2: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            // InternalEduTest.g:2802:3: rule__MultiChoiceEmConfig__ModeAssignment_19
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__ModeAssignment_19();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getModeAssignment_19()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__19__Impl"


    // $ANTLR start "rule__Test__Group__0"
    // InternalEduTest.g:2811:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2815:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // InternalEduTest.g:2816:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_22);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group__1();

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
    // $ANTLR end "rule__Test__Group__0"


    // $ANTLR start "rule__Test__Group__0__Impl"
    // InternalEduTest.g:2823:1: rule__Test__Group__0__Impl : ( 'description' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2827:1: ( ( 'description' ) )
            // InternalEduTest.g:2828:1: ( 'description' )
            {
            // InternalEduTest.g:2828:1: ( 'description' )
            // InternalEduTest.g:2829:2: 'description'
            {
             before(grammarAccess.getTestAccess().getDescriptionKeyword_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTestAccess().getDescriptionKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__0__Impl"


    // $ANTLR start "rule__Test__Group__1"
    // InternalEduTest.g:2838:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2842:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // InternalEduTest.g:2843:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_23);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group__2();

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
    // $ANTLR end "rule__Test__Group__1"


    // $ANTLR start "rule__Test__Group__1__Impl"
    // InternalEduTest.g:2850:1: rule__Test__Group__1__Impl : ( 'for' ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2854:1: ( ( 'for' ) )
            // InternalEduTest.g:2855:1: ( 'for' )
            {
            // InternalEduTest.g:2855:1: ( 'for' )
            // InternalEduTest.g:2856:2: 'for'
            {
             before(grammarAccess.getTestAccess().getForKeyword_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTestAccess().getForKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__1__Impl"


    // $ANTLR start "rule__Test__Group__2"
    // InternalEduTest.g:2865:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2869:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // InternalEduTest.g:2870:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_12);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group__3();

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
    // $ANTLR end "rule__Test__Group__2"


    // $ANTLR start "rule__Test__Group__2__Impl"
    // InternalEduTest.g:2877:1: rule__Test__Group__2__Impl : ( ( rule__Test__SourceAssignment_2 ) ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2881:1: ( ( ( rule__Test__SourceAssignment_2 ) ) )
            // InternalEduTest.g:2882:1: ( ( rule__Test__SourceAssignment_2 ) )
            {
            // InternalEduTest.g:2882:1: ( ( rule__Test__SourceAssignment_2 ) )
            // InternalEduTest.g:2883:2: ( rule__Test__SourceAssignment_2 )
            {
             before(grammarAccess.getTestAccess().getSourceAssignment_2()); 
            // InternalEduTest.g:2884:2: ( rule__Test__SourceAssignment_2 )
            // InternalEduTest.g:2884:3: rule__Test__SourceAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Test__SourceAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getSourceAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__2__Impl"


    // $ANTLR start "rule__Test__Group__3"
    // InternalEduTest.g:2892:1: rule__Test__Group__3 : rule__Test__Group__3__Impl rule__Test__Group__4 ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2896:1: ( rule__Test__Group__3__Impl rule__Test__Group__4 )
            // InternalEduTest.g:2897:2: rule__Test__Group__3__Impl rule__Test__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__Test__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group__4();

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
    // $ANTLR end "rule__Test__Group__3"


    // $ANTLR start "rule__Test__Group__3__Impl"
    // InternalEduTest.g:2904:1: rule__Test__Group__3__Impl : ( '=' ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2908:1: ( ( '=' ) )
            // InternalEduTest.g:2909:1: ( '=' )
            {
            // InternalEduTest.g:2909:1: ( '=' )
            // InternalEduTest.g:2910:2: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_3()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getTestAccess().getEqualsSignKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__3__Impl"


    // $ANTLR start "rule__Test__Group__4"
    // InternalEduTest.g:2919:1: rule__Test__Group__4 : rule__Test__Group__4__Impl rule__Test__Group__5 ;
    public final void rule__Test__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2923:1: ( rule__Test__Group__4__Impl rule__Test__Group__5 )
            // InternalEduTest.g:2924:2: rule__Test__Group__4__Impl rule__Test__Group__5
            {
            pushFollow(FOLLOW_24);
            rule__Test__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group__5();

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
    // $ANTLR end "rule__Test__Group__4"


    // $ANTLR start "rule__Test__Group__4__Impl"
    // InternalEduTest.g:2931:1: rule__Test__Group__4__Impl : ( ( rule__Test__QuestionAssignment_4 ) ) ;
    public final void rule__Test__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2935:1: ( ( ( rule__Test__QuestionAssignment_4 ) ) )
            // InternalEduTest.g:2936:1: ( ( rule__Test__QuestionAssignment_4 ) )
            {
            // InternalEduTest.g:2936:1: ( ( rule__Test__QuestionAssignment_4 ) )
            // InternalEduTest.g:2937:2: ( rule__Test__QuestionAssignment_4 )
            {
             before(grammarAccess.getTestAccess().getQuestionAssignment_4()); 
            // InternalEduTest.g:2938:2: ( rule__Test__QuestionAssignment_4 )
            // InternalEduTest.g:2938:3: rule__Test__QuestionAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Test__QuestionAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getQuestionAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__4__Impl"


    // $ANTLR start "rule__Test__Group__5"
    // InternalEduTest.g:2946:1: rule__Test__Group__5 : rule__Test__Group__5__Impl ;
    public final void rule__Test__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2950:1: ( rule__Test__Group__5__Impl )
            // InternalEduTest.g:2951:2: rule__Test__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Test__Group__5__Impl();

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
    // $ANTLR end "rule__Test__Group__5"


    // $ANTLR start "rule__Test__Group__5__Impl"
    // InternalEduTest.g:2957:1: rule__Test__Group__5__Impl : ( ( rule__Test__Group_5__0 )? ) ;
    public final void rule__Test__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2961:1: ( ( ( rule__Test__Group_5__0 )? ) )
            // InternalEduTest.g:2962:1: ( ( rule__Test__Group_5__0 )? )
            {
            // InternalEduTest.g:2962:1: ( ( rule__Test__Group_5__0 )? )
            // InternalEduTest.g:2963:2: ( rule__Test__Group_5__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_5()); 
            // InternalEduTest.g:2964:2: ( rule__Test__Group_5__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==44) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalEduTest.g:2964:3: rule__Test__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Test__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTestAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__5__Impl"


    // $ANTLR start "rule__Test__Group_5__0"
    // InternalEduTest.g:2973:1: rule__Test__Group_5__0 : rule__Test__Group_5__0__Impl rule__Test__Group_5__1 ;
    public final void rule__Test__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2977:1: ( rule__Test__Group_5__0__Impl rule__Test__Group_5__1 )
            // InternalEduTest.g:2978:2: rule__Test__Group_5__0__Impl rule__Test__Group_5__1
            {
            pushFollow(FOLLOW_25);
            rule__Test__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group_5__1();

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
    // $ANTLR end "rule__Test__Group_5__0"


    // $ANTLR start "rule__Test__Group_5__0__Impl"
    // InternalEduTest.g:2985:1: rule__Test__Group_5__0__Impl : ( ( rule__Test__ExpressionAssignment_5_0 ) ) ;
    public final void rule__Test__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2989:1: ( ( ( rule__Test__ExpressionAssignment_5_0 ) ) )
            // InternalEduTest.g:2990:1: ( ( rule__Test__ExpressionAssignment_5_0 ) )
            {
            // InternalEduTest.g:2990:1: ( ( rule__Test__ExpressionAssignment_5_0 ) )
            // InternalEduTest.g:2991:2: ( rule__Test__ExpressionAssignment_5_0 )
            {
             before(grammarAccess.getTestAccess().getExpressionAssignment_5_0()); 
            // InternalEduTest.g:2992:2: ( rule__Test__ExpressionAssignment_5_0 )
            // InternalEduTest.g:2992:3: rule__Test__ExpressionAssignment_5_0
            {
            pushFollow(FOLLOW_2);
            rule__Test__ExpressionAssignment_5_0();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getExpressionAssignment_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_5__0__Impl"


    // $ANTLR start "rule__Test__Group_5__1"
    // InternalEduTest.g:3000:1: rule__Test__Group_5__1 : rule__Test__Group_5__1__Impl ;
    public final void rule__Test__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3004:1: ( rule__Test__Group_5__1__Impl )
            // InternalEduTest.g:3005:2: rule__Test__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Test__Group_5__1__Impl();

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
    // $ANTLR end "rule__Test__Group_5__1"


    // $ANTLR start "rule__Test__Group_5__1__Impl"
    // InternalEduTest.g:3011:1: rule__Test__Group_5__1__Impl : ( ( rule__Test__Group_5_1__0 )? ) ;
    public final void rule__Test__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3015:1: ( ( ( rule__Test__Group_5_1__0 )? ) )
            // InternalEduTest.g:3016:1: ( ( rule__Test__Group_5_1__0 )? )
            {
            // InternalEduTest.g:3016:1: ( ( rule__Test__Group_5_1__0 )? )
            // InternalEduTest.g:3017:2: ( rule__Test__Group_5_1__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_5_1()); 
            // InternalEduTest.g:3018:2: ( rule__Test__Group_5_1__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==40) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalEduTest.g:3018:3: rule__Test__Group_5_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Test__Group_5_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTestAccess().getGroup_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_5__1__Impl"


    // $ANTLR start "rule__Test__Group_5_1__0"
    // InternalEduTest.g:3027:1: rule__Test__Group_5_1__0 : rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1 ;
    public final void rule__Test__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3031:1: ( rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1 )
            // InternalEduTest.g:3032:2: rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1
            {
            pushFollow(FOLLOW_23);
            rule__Test__Group_5_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group_5_1__1();

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
    // $ANTLR end "rule__Test__Group_5_1__0"


    // $ANTLR start "rule__Test__Group_5_1__0__Impl"
    // InternalEduTest.g:3039:1: rule__Test__Group_5_1__0__Impl : ( '(' ) ;
    public final void rule__Test__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3043:1: ( ( '(' ) )
            // InternalEduTest.g:3044:1: ( '(' )
            {
            // InternalEduTest.g:3044:1: ( '(' )
            // InternalEduTest.g:3045:2: '('
            {
             before(grammarAccess.getTestAccess().getLeftParenthesisKeyword_5_1_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTestAccess().getLeftParenthesisKeyword_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_5_1__0__Impl"


    // $ANTLR start "rule__Test__Group_5_1__1"
    // InternalEduTest.g:3054:1: rule__Test__Group_5_1__1 : rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2 ;
    public final void rule__Test__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3058:1: ( rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2 )
            // InternalEduTest.g:3059:2: rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2
            {
            pushFollow(FOLLOW_26);
            rule__Test__Group_5_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Test__Group_5_1__2();

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
    // $ANTLR end "rule__Test__Group_5_1__1"


    // $ANTLR start "rule__Test__Group_5_1__1__Impl"
    // InternalEduTest.g:3066:1: rule__Test__Group_5_1__1__Impl : ( ( rule__Test__IdentifierAssignment_5_1_1 ) ) ;
    public final void rule__Test__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3070:1: ( ( ( rule__Test__IdentifierAssignment_5_1_1 ) ) )
            // InternalEduTest.g:3071:1: ( ( rule__Test__IdentifierAssignment_5_1_1 ) )
            {
            // InternalEduTest.g:3071:1: ( ( rule__Test__IdentifierAssignment_5_1_1 ) )
            // InternalEduTest.g:3072:2: ( rule__Test__IdentifierAssignment_5_1_1 )
            {
             before(grammarAccess.getTestAccess().getIdentifierAssignment_5_1_1()); 
            // InternalEduTest.g:3073:2: ( rule__Test__IdentifierAssignment_5_1_1 )
            // InternalEduTest.g:3073:3: rule__Test__IdentifierAssignment_5_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Test__IdentifierAssignment_5_1_1();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getIdentifierAssignment_5_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_5_1__1__Impl"


    // $ANTLR start "rule__Test__Group_5_1__2"
    // InternalEduTest.g:3081:1: rule__Test__Group_5_1__2 : rule__Test__Group_5_1__2__Impl ;
    public final void rule__Test__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3085:1: ( rule__Test__Group_5_1__2__Impl )
            // InternalEduTest.g:3086:2: rule__Test__Group_5_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Test__Group_5_1__2__Impl();

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
    // $ANTLR end "rule__Test__Group_5_1__2"


    // $ANTLR start "rule__Test__Group_5_1__2__Impl"
    // InternalEduTest.g:3092:1: rule__Test__Group_5_1__2__Impl : ( ')' ) ;
    public final void rule__Test__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3096:1: ( ( ')' ) )
            // InternalEduTest.g:3097:1: ( ')' )
            {
            // InternalEduTest.g:3097:1: ( ')' )
            // InternalEduTest.g:3098:2: ')'
            {
             before(grammarAccess.getTestAccess().getRightParenthesisKeyword_5_1_2()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTestAccess().getRightParenthesisKeyword_5_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_5_1__2__Impl"


    // $ANTLR start "rule__EDouble__Group__0"
    // InternalEduTest.g:3108:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3112:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalEduTest.g:3113:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalEduTest.g:3120:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3124:1: ( ( ( '-' )? ) )
            // InternalEduTest.g:3125:1: ( ( '-' )? )
            {
            // InternalEduTest.g:3125:1: ( ( '-' )? )
            // InternalEduTest.g:3126:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // InternalEduTest.g:3127:2: ( '-' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==42) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalEduTest.g:3127:3: '-'
                    {
                    match(input,42,FOLLOW_2); 

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
    // InternalEduTest.g:3135:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3139:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalEduTest.g:3140:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalEduTest.g:3147:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3151:1: ( ( ( RULE_INT )? ) )
            // InternalEduTest.g:3152:1: ( ( RULE_INT )? )
            {
            // InternalEduTest.g:3152:1: ( ( RULE_INT )? )
            // InternalEduTest.g:3153:2: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // InternalEduTest.g:3154:2: ( RULE_INT )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_INT) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalEduTest.g:3154:3: RULE_INT
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
    // InternalEduTest.g:3162:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3166:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // InternalEduTest.g:3167:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FOLLOW_27);
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
    // InternalEduTest.g:3174:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3178:1: ( ( '.' ) )
            // InternalEduTest.g:3179:1: ( '.' )
            {
            // InternalEduTest.g:3179:1: ( '.' )
            // InternalEduTest.g:3180:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,43,FOLLOW_2); 
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
    // InternalEduTest.g:3189:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3193:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // InternalEduTest.g:3194:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FOLLOW_28);
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
    // InternalEduTest.g:3201:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3205:1: ( ( RULE_INT ) )
            // InternalEduTest.g:3206:1: ( RULE_INT )
            {
            // InternalEduTest.g:3206:1: ( RULE_INT )
            // InternalEduTest.g:3207:2: RULE_INT
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
    // InternalEduTest.g:3216:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3220:1: ( rule__EDouble__Group__4__Impl )
            // InternalEduTest.g:3221:2: rule__EDouble__Group__4__Impl
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
    // InternalEduTest.g:3227:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3231:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // InternalEduTest.g:3232:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // InternalEduTest.g:3232:1: ( ( rule__EDouble__Group_4__0 )? )
            // InternalEduTest.g:3233:2: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // InternalEduTest.g:3234:2: ( rule__EDouble__Group_4__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( ((LA31_0>=13 && LA31_0<=14)) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalEduTest.g:3234:3: rule__EDouble__Group_4__0
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
    // InternalEduTest.g:3243:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3247:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // InternalEduTest.g:3248:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalEduTest.g:3255:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3259:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // InternalEduTest.g:3260:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // InternalEduTest.g:3260:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // InternalEduTest.g:3261:2: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // InternalEduTest.g:3262:2: ( rule__EDouble__Alternatives_4_0 )
            // InternalEduTest.g:3262:3: rule__EDouble__Alternatives_4_0
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
    // InternalEduTest.g:3270:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3274:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // InternalEduTest.g:3275:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalEduTest.g:3282:1: rule__EDouble__Group_4__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3286:1: ( ( ( '-' )? ) )
            // InternalEduTest.g:3287:1: ( ( '-' )? )
            {
            // InternalEduTest.g:3287:1: ( ( '-' )? )
            // InternalEduTest.g:3288:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
            // InternalEduTest.g:3289:2: ( '-' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==42) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalEduTest.g:3289:3: '-'
                    {
                    match(input,42,FOLLOW_2); 

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
    // InternalEduTest.g:3297:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3301:1: ( rule__EDouble__Group_4__2__Impl )
            // InternalEduTest.g:3302:2: rule__EDouble__Group_4__2__Impl
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
    // InternalEduTest.g:3308:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3312:1: ( ( RULE_INT ) )
            // InternalEduTest.g:3313:1: ( RULE_INT )
            {
            // InternalEduTest.g:3313:1: ( RULE_INT )
            // InternalEduTest.g:3314:2: RULE_INT
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


    // $ANTLR start "rule__Program__ConfigAssignment_1"
    // InternalEduTest.g:3324:1: rule__Program__ConfigAssignment_1 : ( ruleProgramConfiguration ) ;
    public final void rule__Program__ConfigAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3328:1: ( ( ruleProgramConfiguration ) )
            // InternalEduTest.g:3329:2: ( ruleProgramConfiguration )
            {
            // InternalEduTest.g:3329:2: ( ruleProgramConfiguration )
            // InternalEduTest.g:3330:3: ruleProgramConfiguration
            {
             before(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_1_0()); 
            pushFollow(FOLLOW_2);
            ruleProgramConfiguration();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ConfigAssignment_1"


    // $ANTLR start "rule__Program__ExercisesAssignment_2"
    // InternalEduTest.g:3339:1: rule__Program__ExercisesAssignment_2 : ( ruleMutatorTests ) ;
    public final void rule__Program__ExercisesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3343:1: ( ( ruleMutatorTests ) )
            // InternalEduTest.g:3344:2: ( ruleMutatorTests )
            {
            // InternalEduTest.g:3344:2: ( ruleMutatorTests )
            // InternalEduTest.g:3345:3: ruleMutatorTests
            {
             before(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleMutatorTests();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ExercisesAssignment_2"


    // $ANTLR start "rule__AlternativeResponse__BlocksAssignment_1_0"
    // InternalEduTest.g:3354:1: rule__AlternativeResponse__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__AlternativeResponse__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3358:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3359:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3359:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3360:3: ( RULE_ID )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:3361:3: ( RULE_ID )
            // InternalEduTest.g:3362:4: RULE_ID
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAlternativeResponseAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__BlocksAssignment_1_0"


    // $ANTLR start "rule__AlternativeResponse__BlocksAssignment_1_1_1"
    // InternalEduTest.g:3373:1: rule__AlternativeResponse__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AlternativeResponse__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3377:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3378:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3378:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3379:3: ( RULE_ID )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:3380:3: ( RULE_ID )
            // InternalEduTest.g:3381:4: RULE_ID
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAlternativeResponseAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__AlternativeResponse__ConfigAssignment_3"
    // InternalEduTest.g:3392:1: rule__AlternativeResponse__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__AlternativeResponse__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3396:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:3397:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:3397:2: ( ruleTestConfiguration )
            // InternalEduTest.g:3398:3: ruleTestConfiguration
            {
             before(grammarAccess.getAlternativeResponseAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTestConfiguration();

            state._fsp--;

             after(grammarAccess.getAlternativeResponseAccess().getConfigTestConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__ConfigAssignment_3"


    // $ANTLR start "rule__AlternativeResponse__TestsAssignment_4"
    // InternalEduTest.g:3407:1: rule__AlternativeResponse__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__AlternativeResponse__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3411:1: ( ( ruleTest ) )
            // InternalEduTest.g:3412:2: ( ruleTest )
            {
            // InternalEduTest.g:3412:2: ( ruleTest )
            // InternalEduTest.g:3413:3: ruleTest
            {
             before(grammarAccess.getAlternativeResponseAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getAlternativeResponseAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__TestsAssignment_4"


    // $ANTLR start "rule__MultiChoiceDiagram__BlocksAssignment_1_0"
    // InternalEduTest.g:3422:1: rule__MultiChoiceDiagram__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceDiagram__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3426:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3427:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3427:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3428:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:3429:3: ( RULE_ID )
            // InternalEduTest.g:3430:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__BlocksAssignment_1_0"


    // $ANTLR start "rule__MultiChoiceDiagram__BlocksAssignment_1_1_1"
    // InternalEduTest.g:3441:1: rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceDiagram__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3445:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3446:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3446:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3447:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:3448:3: ( RULE_ID )
            // InternalEduTest.g:3449:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__MultiChoiceDiagram__ConfigAssignment_3"
    // InternalEduTest.g:3460:1: rule__MultiChoiceDiagram__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MultiChoiceDiagram__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3464:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:3465:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:3465:2: ( ruleTestConfiguration )
            // InternalEduTest.g:3466:3: ruleTestConfiguration
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTestConfiguration();

            state._fsp--;

             after(grammarAccess.getMultiChoiceDiagramAccess().getConfigTestConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__ConfigAssignment_3"


    // $ANTLR start "rule__MultiChoiceDiagram__TestsAssignment_4"
    // InternalEduTest.g:3475:1: rule__MultiChoiceDiagram__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceDiagram__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3479:1: ( ( ruleTest ) )
            // InternalEduTest.g:3480:2: ( ruleTest )
            {
            // InternalEduTest.g:3480:2: ( ruleTest )
            // InternalEduTest.g:3481:3: ruleTest
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getMultiChoiceDiagramAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__TestsAssignment_4"


    // $ANTLR start "rule__MultiChoiceEmendation__BlocksAssignment_1_0"
    // InternalEduTest.g:3490:1: rule__MultiChoiceEmendation__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmendation__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3494:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3495:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3495:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3496:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:3497:3: ( RULE_ID )
            // InternalEduTest.g:3498:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__BlocksAssignment_1_0"


    // $ANTLR start "rule__MultiChoiceEmendation__BlocksAssignment_1_1_1"
    // InternalEduTest.g:3509:1: rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmendation__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3513:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3514:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3514:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3515:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:3516:3: ( RULE_ID )
            // InternalEduTest.g:3517:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__MultiChoiceEmendation__ConfigAssignment_3"
    // InternalEduTest.g:3528:1: rule__MultiChoiceEmendation__ConfigAssignment_3 : ( ruleMultiChoiceEmConfig ) ;
    public final void rule__MultiChoiceEmendation__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3532:1: ( ( ruleMultiChoiceEmConfig ) )
            // InternalEduTest.g:3533:2: ( ruleMultiChoiceEmConfig )
            {
            // InternalEduTest.g:3533:2: ( ruleMultiChoiceEmConfig )
            // InternalEduTest.g:3534:3: ruleMultiChoiceEmConfig
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getConfigMultiChoiceEmConfigParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMultiChoiceEmConfig();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmendationAccess().getConfigMultiChoiceEmConfigParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__ConfigAssignment_3"


    // $ANTLR start "rule__MultiChoiceEmendation__TestsAssignment_4"
    // InternalEduTest.g:3543:1: rule__MultiChoiceEmendation__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceEmendation__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3547:1: ( ( ruleTest ) )
            // InternalEduTest.g:3548:2: ( ruleTest )
            {
            // InternalEduTest.g:3548:2: ( ruleTest )
            // InternalEduTest.g:3549:3: ruleTest
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmendationAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__TestsAssignment_4"


    // $ANTLR start "rule__MatchPairs__BlocksAssignment_1_0"
    // InternalEduTest.g:3558:1: rule__MatchPairs__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MatchPairs__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3562:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3563:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3563:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3564:3: ( RULE_ID )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:3565:3: ( RULE_ID )
            // InternalEduTest.g:3566:4: RULE_ID
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMatchPairsAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__BlocksAssignment_1_0"


    // $ANTLR start "rule__MatchPairs__BlocksAssignment_1_1_1"
    // InternalEduTest.g:3577:1: rule__MatchPairs__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MatchPairs__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3581:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3582:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3582:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3583:3: ( RULE_ID )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:3584:3: ( RULE_ID )
            // InternalEduTest.g:3585:4: RULE_ID
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMatchPairsAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__MatchPairs__ConfigAssignment_3"
    // InternalEduTest.g:3596:1: rule__MatchPairs__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MatchPairs__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3600:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:3601:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:3601:2: ( ruleTestConfiguration )
            // InternalEduTest.g:3602:3: ruleTestConfiguration
            {
             before(grammarAccess.getMatchPairsAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTestConfiguration();

            state._fsp--;

             after(grammarAccess.getMatchPairsAccess().getConfigTestConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__ConfigAssignment_3"


    // $ANTLR start "rule__MatchPairs__TestsAssignment_4"
    // InternalEduTest.g:3611:1: rule__MatchPairs__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MatchPairs__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3615:1: ( ( ruleTest ) )
            // InternalEduTest.g:3616:2: ( ruleTest )
            {
            // InternalEduTest.g:3616:2: ( ruleTest )
            // InternalEduTest.g:3617:3: ruleTest
            {
             before(grammarAccess.getMatchPairsAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getMatchPairsAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__TestsAssignment_4"


    // $ANTLR start "rule__MissingWords__BlocksAssignment_1_0"
    // InternalEduTest.g:3626:1: rule__MissingWords__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MissingWords__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3630:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3631:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3631:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3632:3: ( RULE_ID )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:3633:3: ( RULE_ID )
            // InternalEduTest.g:3634:4: RULE_ID
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMissingWordsAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__BlocksAssignment_1_0"


    // $ANTLR start "rule__MissingWords__BlocksAssignment_1_1_1"
    // InternalEduTest.g:3645:1: rule__MissingWords__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MissingWords__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3649:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:3650:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:3650:2: ( ( RULE_ID ) )
            // InternalEduTest.g:3651:3: ( RULE_ID )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:3652:3: ( RULE_ID )
            // InternalEduTest.g:3653:4: RULE_ID
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMissingWordsAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__MissingWords__ConfigAssignment_3"
    // InternalEduTest.g:3664:1: rule__MissingWords__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MissingWords__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3668:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:3669:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:3669:2: ( ruleTestConfiguration )
            // InternalEduTest.g:3670:3: ruleTestConfiguration
            {
             before(grammarAccess.getMissingWordsAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTestConfiguration();

            state._fsp--;

             after(grammarAccess.getMissingWordsAccess().getConfigTestConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__ConfigAssignment_3"


    // $ANTLR start "rule__MissingWords__TestsAssignment_4"
    // InternalEduTest.g:3679:1: rule__MissingWords__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MissingWords__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3683:1: ( ( ruleTest ) )
            // InternalEduTest.g:3684:2: ( ruleTest )
            {
            // InternalEduTest.g:3684:2: ( ruleTest )
            // InternalEduTest.g:3685:3: ruleTest
            {
             before(grammarAccess.getMissingWordsAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getMissingWordsAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__TestsAssignment_4"


    // $ANTLR start "rule__ProgramConfiguration__NavigationAssignment_2"
    // InternalEduTest.g:3694:1: rule__ProgramConfiguration__NavigationAssignment_2 : ( ruleNavigation ) ;
    public final void rule__ProgramConfiguration__NavigationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3698:1: ( ( ruleNavigation ) )
            // InternalEduTest.g:3699:2: ( ruleNavigation )
            {
            // InternalEduTest.g:3699:2: ( ruleNavigation )
            // InternalEduTest.g:3700:3: ruleNavigation
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationNavigationEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNavigation();

            state._fsp--;

             after(grammarAccess.getProgramConfigurationAccess().getNavigationNavigationEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ProgramConfiguration__NavigationAssignment_2"


    // $ANTLR start "rule__TestConfiguration__RetryAssignment_3"
    // InternalEduTest.g:3709:1: rule__TestConfiguration__RetryAssignment_3 : ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) ;
    public final void rule__TestConfiguration__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3713:1: ( ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:3714:2: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:3714:2: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:3715:3: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:3716:3: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            // InternalEduTest.g:3716:4: rule__TestConfiguration__RetryAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__RetryAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getRetryAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__RetryAssignment_3"


    // $ANTLR start "rule__MultiChoiceEmConfig__RetryAssignment_3"
    // InternalEduTest.g:3724:1: rule__MultiChoiceEmConfig__RetryAssignment_3 : ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3728:1: ( ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:3729:2: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:3729:2: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:3730:3: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:3731:3: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            // InternalEduTest.g:3731:4: rule__MultiChoiceEmConfig__RetryAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__RetryAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__RetryAssignment_3"


    // $ANTLR start "rule__MultiChoiceEmConfig__WeightedAssignment_7"
    // InternalEduTest.g:3739:1: rule__MultiChoiceEmConfig__WeightedAssignment_7 : ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__WeightedAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3743:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) )
            // InternalEduTest.g:3744:2: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            {
            // InternalEduTest.g:3744:2: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            // InternalEduTest.g:3745:3: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAlternatives_7_0()); 
            // InternalEduTest.g:3746:3: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            // InternalEduTest.g:3746:4: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__WeightedAlternatives_7_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAlternatives_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__WeightedAssignment_7"


    // $ANTLR start "rule__MultiChoiceEmConfig__PenaltyAssignment_11"
    // InternalEduTest.g:3754:1: rule__MultiChoiceEmConfig__PenaltyAssignment_11 : ( ruleEDouble ) ;
    public final void rule__MultiChoiceEmConfig__PenaltyAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3758:1: ( ( ruleEDouble ) )
            // InternalEduTest.g:3759:2: ( ruleEDouble )
            {
            // InternalEduTest.g:3759:2: ( ruleEDouble )
            // InternalEduTest.g:3760:3: ruleEDouble
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyEDoubleParserRuleCall_11_0()); 
            pushFollow(FOLLOW_2);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyEDoubleParserRuleCall_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__PenaltyAssignment_11"


    // $ANTLR start "rule__MultiChoiceEmConfig__OrderAssignment_15"
    // InternalEduTest.g:3769:1: rule__MultiChoiceEmConfig__OrderAssignment_15 : ( ruleOrder ) ;
    public final void rule__MultiChoiceEmConfig__OrderAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3773:1: ( ( ruleOrder ) )
            // InternalEduTest.g:3774:2: ( ruleOrder )
            {
            // InternalEduTest.g:3774:2: ( ruleOrder )
            // InternalEduTest.g:3775:3: ruleOrder
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderOrderEnumRuleCall_15_0()); 
            pushFollow(FOLLOW_2);
            ruleOrder();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmConfigAccess().getOrderOrderEnumRuleCall_15_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__OrderAssignment_15"


    // $ANTLR start "rule__MultiChoiceEmConfig__ModeAssignment_19"
    // InternalEduTest.g:3784:1: rule__MultiChoiceEmConfig__ModeAssignment_19 : ( ruleMode ) ;
    public final void rule__MultiChoiceEmConfig__ModeAssignment_19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3788:1: ( ( ruleMode ) )
            // InternalEduTest.g:3789:2: ( ruleMode )
            {
            // InternalEduTest.g:3789:2: ( ruleMode )
            // InternalEduTest.g:3790:3: ruleMode
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeModeEnumRuleCall_19_0()); 
            pushFollow(FOLLOW_2);
            ruleMode();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmConfigAccess().getModeModeEnumRuleCall_19_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__ModeAssignment_19"


    // $ANTLR start "rule__Test__SourceAssignment_2"
    // InternalEduTest.g:3799:1: rule__Test__SourceAssignment_2 : ( ruleEString ) ;
    public final void rule__Test__SourceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3803:1: ( ( ruleEString ) )
            // InternalEduTest.g:3804:2: ( ruleEString )
            {
            // InternalEduTest.g:3804:2: ( ruleEString )
            // InternalEduTest.g:3805:3: ruleEString
            {
             before(grammarAccess.getTestAccess().getSourceEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTestAccess().getSourceEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__SourceAssignment_2"


    // $ANTLR start "rule__Test__QuestionAssignment_4"
    // InternalEduTest.g:3814:1: rule__Test__QuestionAssignment_4 : ( ruleEString ) ;
    public final void rule__Test__QuestionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3818:1: ( ( ruleEString ) )
            // InternalEduTest.g:3819:2: ( ruleEString )
            {
            // InternalEduTest.g:3819:2: ( ruleEString )
            // InternalEduTest.g:3820:3: ruleEString
            {
             before(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__QuestionAssignment_4"


    // $ANTLR start "rule__Test__ExpressionAssignment_5_0"
    // InternalEduTest.g:3829:1: rule__Test__ExpressionAssignment_5_0 : ( ( '%text' ) ) ;
    public final void rule__Test__ExpressionAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3833:1: ( ( ( '%text' ) ) )
            // InternalEduTest.g:3834:2: ( ( '%text' ) )
            {
            // InternalEduTest.g:3834:2: ( ( '%text' ) )
            // InternalEduTest.g:3835:3: ( '%text' )
            {
             before(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 
            // InternalEduTest.g:3836:3: ( '%text' )
            // InternalEduTest.g:3837:4: '%text'
            {
             before(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 

            }

             after(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__ExpressionAssignment_5_0"


    // $ANTLR start "rule__Test__IdentifierAssignment_5_1_1"
    // InternalEduTest.g:3848:1: rule__Test__IdentifierAssignment_5_1_1 : ( ruleEString ) ;
    public final void rule__Test__IdentifierAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3852:1: ( ( ruleEString ) )
            // InternalEduTest.g:3853:2: ( ruleEString )
            {
            // InternalEduTest.g:3853:2: ( ruleEString )
            // InternalEduTest.g:3854:3: ruleEString
            {
             before(grammarAccess.getTestAccess().getIdentifierEStringParserRuleCall_5_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTestAccess().getIdentifierEStringParserRuleCall_5_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__IdentifierAssignment_5_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000000F8800000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000000F8800002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000004002000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000C0000000040L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000040000000040L});

}