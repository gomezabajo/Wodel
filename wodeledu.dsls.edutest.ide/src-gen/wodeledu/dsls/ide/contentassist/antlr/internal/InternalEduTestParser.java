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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'yes'", "'no'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'", "'metamodel'", "'solution'", "'AlternativeResponse'", "'{'", "'}'", "','", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'MatchPairs'", "'MissingWords'", "'MultiChoiceText'", "'AlternativeTextResponse'", "'DragAndDropText'", "'navigation'", "'='", "'retry'", "'mode'", "'statement'", "'answers'", "'weighted'", "'penalty'", "'order'", "'text'", "'description'", "'for'", "'('", "')'", "'-'", "'.'", "'%text'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
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
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
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


    // $ANTLR start "entryRuleMarkedBlock"
    // InternalEduTest.g:103:1: entryRuleMarkedBlock : ruleMarkedBlock EOF ;
    public final void entryRuleMarkedBlock() throws RecognitionException {
        try {
            // InternalEduTest.g:104:1: ( ruleMarkedBlock EOF )
            // InternalEduTest.g:105:1: ruleMarkedBlock EOF
            {
             before(grammarAccess.getMarkedBlockRule()); 
            pushFollow(FOLLOW_1);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMarkedBlockRule()); 
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
    // $ANTLR end "entryRuleMarkedBlock"


    // $ANTLR start "ruleMarkedBlock"
    // InternalEduTest.g:112:1: ruleMarkedBlock : ( ( rule__MarkedBlock__Group__0 ) ) ;
    public final void ruleMarkedBlock() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:116:2: ( ( ( rule__MarkedBlock__Group__0 ) ) )
            // InternalEduTest.g:117:2: ( ( rule__MarkedBlock__Group__0 ) )
            {
            // InternalEduTest.g:117:2: ( ( rule__MarkedBlock__Group__0 ) )
            // InternalEduTest.g:118:3: ( rule__MarkedBlock__Group__0 )
            {
             before(grammarAccess.getMarkedBlockAccess().getGroup()); 
            // InternalEduTest.g:119:3: ( rule__MarkedBlock__Group__0 )
            // InternalEduTest.g:119:4: rule__MarkedBlock__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MarkedBlock__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMarkedBlockAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMarkedBlock"


    // $ANTLR start "entryRuleAlternativeResponse"
    // InternalEduTest.g:128:1: entryRuleAlternativeResponse : ruleAlternativeResponse EOF ;
    public final void entryRuleAlternativeResponse() throws RecognitionException {
        try {
            // InternalEduTest.g:129:1: ( ruleAlternativeResponse EOF )
            // InternalEduTest.g:130:1: ruleAlternativeResponse EOF
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
    // InternalEduTest.g:137:1: ruleAlternativeResponse : ( ( rule__AlternativeResponse__Group__0 ) ) ;
    public final void ruleAlternativeResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:141:2: ( ( ( rule__AlternativeResponse__Group__0 ) ) )
            // InternalEduTest.g:142:2: ( ( rule__AlternativeResponse__Group__0 ) )
            {
            // InternalEduTest.g:142:2: ( ( rule__AlternativeResponse__Group__0 ) )
            // InternalEduTest.g:143:3: ( rule__AlternativeResponse__Group__0 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup()); 
            // InternalEduTest.g:144:3: ( rule__AlternativeResponse__Group__0 )
            // InternalEduTest.g:144:4: rule__AlternativeResponse__Group__0
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
    // InternalEduTest.g:153:1: entryRuleMultiChoiceDiagram : ruleMultiChoiceDiagram EOF ;
    public final void entryRuleMultiChoiceDiagram() throws RecognitionException {
        try {
            // InternalEduTest.g:154:1: ( ruleMultiChoiceDiagram EOF )
            // InternalEduTest.g:155:1: ruleMultiChoiceDiagram EOF
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
    // InternalEduTest.g:162:1: ruleMultiChoiceDiagram : ( ( rule__MultiChoiceDiagram__Group__0 ) ) ;
    public final void ruleMultiChoiceDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:166:2: ( ( ( rule__MultiChoiceDiagram__Group__0 ) ) )
            // InternalEduTest.g:167:2: ( ( rule__MultiChoiceDiagram__Group__0 ) )
            {
            // InternalEduTest.g:167:2: ( ( rule__MultiChoiceDiagram__Group__0 ) )
            // InternalEduTest.g:168:3: ( rule__MultiChoiceDiagram__Group__0 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup()); 
            // InternalEduTest.g:169:3: ( rule__MultiChoiceDiagram__Group__0 )
            // InternalEduTest.g:169:4: rule__MultiChoiceDiagram__Group__0
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
    // InternalEduTest.g:178:1: entryRuleMultiChoiceEmendation : ruleMultiChoiceEmendation EOF ;
    public final void entryRuleMultiChoiceEmendation() throws RecognitionException {
        try {
            // InternalEduTest.g:179:1: ( ruleMultiChoiceEmendation EOF )
            // InternalEduTest.g:180:1: ruleMultiChoiceEmendation EOF
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
    // InternalEduTest.g:187:1: ruleMultiChoiceEmendation : ( ( rule__MultiChoiceEmendation__Group__0 ) ) ;
    public final void ruleMultiChoiceEmendation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:191:2: ( ( ( rule__MultiChoiceEmendation__Group__0 ) ) )
            // InternalEduTest.g:192:2: ( ( rule__MultiChoiceEmendation__Group__0 ) )
            {
            // InternalEduTest.g:192:2: ( ( rule__MultiChoiceEmendation__Group__0 ) )
            // InternalEduTest.g:193:3: ( rule__MultiChoiceEmendation__Group__0 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup()); 
            // InternalEduTest.g:194:3: ( rule__MultiChoiceEmendation__Group__0 )
            // InternalEduTest.g:194:4: rule__MultiChoiceEmendation__Group__0
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
    // InternalEduTest.g:203:1: entryRuleMatchPairs : ruleMatchPairs EOF ;
    public final void entryRuleMatchPairs() throws RecognitionException {
        try {
            // InternalEduTest.g:204:1: ( ruleMatchPairs EOF )
            // InternalEduTest.g:205:1: ruleMatchPairs EOF
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
    // InternalEduTest.g:212:1: ruleMatchPairs : ( ( rule__MatchPairs__Group__0 ) ) ;
    public final void ruleMatchPairs() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:216:2: ( ( ( rule__MatchPairs__Group__0 ) ) )
            // InternalEduTest.g:217:2: ( ( rule__MatchPairs__Group__0 ) )
            {
            // InternalEduTest.g:217:2: ( ( rule__MatchPairs__Group__0 ) )
            // InternalEduTest.g:218:3: ( rule__MatchPairs__Group__0 )
            {
             before(grammarAccess.getMatchPairsAccess().getGroup()); 
            // InternalEduTest.g:219:3: ( rule__MatchPairs__Group__0 )
            // InternalEduTest.g:219:4: rule__MatchPairs__Group__0
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
    // InternalEduTest.g:228:1: entryRuleMissingWords : ruleMissingWords EOF ;
    public final void entryRuleMissingWords() throws RecognitionException {
        try {
            // InternalEduTest.g:229:1: ( ruleMissingWords EOF )
            // InternalEduTest.g:230:1: ruleMissingWords EOF
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
    // InternalEduTest.g:237:1: ruleMissingWords : ( ( rule__MissingWords__Group__0 ) ) ;
    public final void ruleMissingWords() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:241:2: ( ( ( rule__MissingWords__Group__0 ) ) )
            // InternalEduTest.g:242:2: ( ( rule__MissingWords__Group__0 ) )
            {
            // InternalEduTest.g:242:2: ( ( rule__MissingWords__Group__0 ) )
            // InternalEduTest.g:243:3: ( rule__MissingWords__Group__0 )
            {
             before(grammarAccess.getMissingWordsAccess().getGroup()); 
            // InternalEduTest.g:244:3: ( rule__MissingWords__Group__0 )
            // InternalEduTest.g:244:4: rule__MissingWords__Group__0
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


    // $ANTLR start "entryRuleMultiChoiceText"
    // InternalEduTest.g:253:1: entryRuleMultiChoiceText : ruleMultiChoiceText EOF ;
    public final void entryRuleMultiChoiceText() throws RecognitionException {
        try {
            // InternalEduTest.g:254:1: ( ruleMultiChoiceText EOF )
            // InternalEduTest.g:255:1: ruleMultiChoiceText EOF
            {
             before(grammarAccess.getMultiChoiceTextRule()); 
            pushFollow(FOLLOW_1);
            ruleMultiChoiceText();

            state._fsp--;

             after(grammarAccess.getMultiChoiceTextRule()); 
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
    // $ANTLR end "entryRuleMultiChoiceText"


    // $ANTLR start "ruleMultiChoiceText"
    // InternalEduTest.g:262:1: ruleMultiChoiceText : ( ( rule__MultiChoiceText__Group__0 ) ) ;
    public final void ruleMultiChoiceText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:266:2: ( ( ( rule__MultiChoiceText__Group__0 ) ) )
            // InternalEduTest.g:267:2: ( ( rule__MultiChoiceText__Group__0 ) )
            {
            // InternalEduTest.g:267:2: ( ( rule__MultiChoiceText__Group__0 ) )
            // InternalEduTest.g:268:3: ( rule__MultiChoiceText__Group__0 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getGroup()); 
            // InternalEduTest.g:269:3: ( rule__MultiChoiceText__Group__0 )
            // InternalEduTest.g:269:4: rule__MultiChoiceText__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceTextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMultiChoiceText"


    // $ANTLR start "entryRuleAlternativeText"
    // InternalEduTest.g:278:1: entryRuleAlternativeText : ruleAlternativeText EOF ;
    public final void entryRuleAlternativeText() throws RecognitionException {
        try {
            // InternalEduTest.g:279:1: ( ruleAlternativeText EOF )
            // InternalEduTest.g:280:1: ruleAlternativeText EOF
            {
             before(grammarAccess.getAlternativeTextRule()); 
            pushFollow(FOLLOW_1);
            ruleAlternativeText();

            state._fsp--;

             after(grammarAccess.getAlternativeTextRule()); 
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
    // $ANTLR end "entryRuleAlternativeText"


    // $ANTLR start "ruleAlternativeText"
    // InternalEduTest.g:287:1: ruleAlternativeText : ( ( rule__AlternativeText__Group__0 ) ) ;
    public final void ruleAlternativeText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:291:2: ( ( ( rule__AlternativeText__Group__0 ) ) )
            // InternalEduTest.g:292:2: ( ( rule__AlternativeText__Group__0 ) )
            {
            // InternalEduTest.g:292:2: ( ( rule__AlternativeText__Group__0 ) )
            // InternalEduTest.g:293:3: ( rule__AlternativeText__Group__0 )
            {
             before(grammarAccess.getAlternativeTextAccess().getGroup()); 
            // InternalEduTest.g:294:3: ( rule__AlternativeText__Group__0 )
            // InternalEduTest.g:294:4: rule__AlternativeText__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeTextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAlternativeText"


    // $ANTLR start "entryRuleDragAndDropText"
    // InternalEduTest.g:303:1: entryRuleDragAndDropText : ruleDragAndDropText EOF ;
    public final void entryRuleDragAndDropText() throws RecognitionException {
        try {
            // InternalEduTest.g:304:1: ( ruleDragAndDropText EOF )
            // InternalEduTest.g:305:1: ruleDragAndDropText EOF
            {
             before(grammarAccess.getDragAndDropTextRule()); 
            pushFollow(FOLLOW_1);
            ruleDragAndDropText();

            state._fsp--;

             after(grammarAccess.getDragAndDropTextRule()); 
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
    // $ANTLR end "entryRuleDragAndDropText"


    // $ANTLR start "ruleDragAndDropText"
    // InternalEduTest.g:312:1: ruleDragAndDropText : ( ( rule__DragAndDropText__Group__0 ) ) ;
    public final void ruleDragAndDropText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:316:2: ( ( ( rule__DragAndDropText__Group__0 ) ) )
            // InternalEduTest.g:317:2: ( ( rule__DragAndDropText__Group__0 ) )
            {
            // InternalEduTest.g:317:2: ( ( rule__DragAndDropText__Group__0 ) )
            // InternalEduTest.g:318:3: ( rule__DragAndDropText__Group__0 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getGroup()); 
            // InternalEduTest.g:319:3: ( rule__DragAndDropText__Group__0 )
            // InternalEduTest.g:319:4: rule__DragAndDropText__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getDragAndDropTextAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDragAndDropText"


    // $ANTLR start "entryRuleProgramConfiguration"
    // InternalEduTest.g:328:1: entryRuleProgramConfiguration : ruleProgramConfiguration EOF ;
    public final void entryRuleProgramConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:329:1: ( ruleProgramConfiguration EOF )
            // InternalEduTest.g:330:1: ruleProgramConfiguration EOF
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
    // InternalEduTest.g:337:1: ruleProgramConfiguration : ( ( rule__ProgramConfiguration__Group__0 ) ) ;
    public final void ruleProgramConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:341:2: ( ( ( rule__ProgramConfiguration__Group__0 ) ) )
            // InternalEduTest.g:342:2: ( ( rule__ProgramConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:342:2: ( ( rule__ProgramConfiguration__Group__0 ) )
            // InternalEduTest.g:343:3: ( rule__ProgramConfiguration__Group__0 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getGroup()); 
            // InternalEduTest.g:344:3: ( rule__ProgramConfiguration__Group__0 )
            // InternalEduTest.g:344:4: rule__ProgramConfiguration__Group__0
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
    // InternalEduTest.g:353:1: entryRuleTestConfiguration : ruleTestConfiguration EOF ;
    public final void entryRuleTestConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:354:1: ( ruleTestConfiguration EOF )
            // InternalEduTest.g:355:1: ruleTestConfiguration EOF
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
    // InternalEduTest.g:362:1: ruleTestConfiguration : ( ( rule__TestConfiguration__Group__0 ) ) ;
    public final void ruleTestConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:366:2: ( ( ( rule__TestConfiguration__Group__0 ) ) )
            // InternalEduTest.g:367:2: ( ( rule__TestConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:367:2: ( ( rule__TestConfiguration__Group__0 ) )
            // InternalEduTest.g:368:3: ( rule__TestConfiguration__Group__0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup()); 
            // InternalEduTest.g:369:3: ( rule__TestConfiguration__Group__0 )
            // InternalEduTest.g:369:4: rule__TestConfiguration__Group__0
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
    // InternalEduTest.g:378:1: entryRuleMultiChoiceEmConfig : ruleMultiChoiceEmConfig EOF ;
    public final void entryRuleMultiChoiceEmConfig() throws RecognitionException {
        try {
            // InternalEduTest.g:379:1: ( ruleMultiChoiceEmConfig EOF )
            // InternalEduTest.g:380:1: ruleMultiChoiceEmConfig EOF
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
    // InternalEduTest.g:387:1: ruleMultiChoiceEmConfig : ( ( rule__MultiChoiceEmConfig__Group__0 ) ) ;
    public final void ruleMultiChoiceEmConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:391:2: ( ( ( rule__MultiChoiceEmConfig__Group__0 ) ) )
            // InternalEduTest.g:392:2: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            {
            // InternalEduTest.g:392:2: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            // InternalEduTest.g:393:3: ( rule__MultiChoiceEmConfig__Group__0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup()); 
            // InternalEduTest.g:394:3: ( rule__MultiChoiceEmConfig__Group__0 )
            // InternalEduTest.g:394:4: rule__MultiChoiceEmConfig__Group__0
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


    // $ANTLR start "entryRuleTextConfiguration"
    // InternalEduTest.g:403:1: entryRuleTextConfiguration : ruleTextConfiguration EOF ;
    public final void entryRuleTextConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:404:1: ( ruleTextConfiguration EOF )
            // InternalEduTest.g:405:1: ruleTextConfiguration EOF
            {
             before(grammarAccess.getTextConfigurationRule()); 
            pushFollow(FOLLOW_1);
            ruleTextConfiguration();

            state._fsp--;

             after(grammarAccess.getTextConfigurationRule()); 
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
    // $ANTLR end "entryRuleTextConfiguration"


    // $ANTLR start "ruleTextConfiguration"
    // InternalEduTest.g:412:1: ruleTextConfiguration : ( ( rule__TextConfiguration__Group__0 ) ) ;
    public final void ruleTextConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:416:2: ( ( ( rule__TextConfiguration__Group__0 ) ) )
            // InternalEduTest.g:417:2: ( ( rule__TextConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:417:2: ( ( rule__TextConfiguration__Group__0 ) )
            // InternalEduTest.g:418:3: ( rule__TextConfiguration__Group__0 )
            {
             before(grammarAccess.getTextConfigurationAccess().getGroup()); 
            // InternalEduTest.g:419:3: ( rule__TextConfiguration__Group__0 )
            // InternalEduTest.g:419:4: rule__TextConfiguration__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTextConfigurationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTextConfiguration"


    // $ANTLR start "entryRuleTest"
    // InternalEduTest.g:428:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // InternalEduTest.g:429:1: ( ruleTest EOF )
            // InternalEduTest.g:430:1: ruleTest EOF
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
    // InternalEduTest.g:437:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
    public final void ruleTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:441:2: ( ( ( rule__Test__Group__0 ) ) )
            // InternalEduTest.g:442:2: ( ( rule__Test__Group__0 ) )
            {
            // InternalEduTest.g:442:2: ( ( rule__Test__Group__0 ) )
            // InternalEduTest.g:443:3: ( rule__Test__Group__0 )
            {
             before(grammarAccess.getTestAccess().getGroup()); 
            // InternalEduTest.g:444:3: ( rule__Test__Group__0 )
            // InternalEduTest.g:444:4: rule__Test__Group__0
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
    // InternalEduTest.g:453:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalEduTest.g:454:1: ( ruleEString EOF )
            // InternalEduTest.g:455:1: ruleEString EOF
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
    // InternalEduTest.g:462:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:466:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalEduTest.g:467:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalEduTest.g:467:2: ( ( rule__EString__Alternatives ) )
            // InternalEduTest.g:468:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalEduTest.g:469:3: ( rule__EString__Alternatives )
            // InternalEduTest.g:469:4: rule__EString__Alternatives
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
    // InternalEduTest.g:478:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalEduTest.g:479:1: ( ruleEDouble EOF )
            // InternalEduTest.g:480:1: ruleEDouble EOF
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
    // InternalEduTest.g:487:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:491:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalEduTest.g:492:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalEduTest.g:492:2: ( ( rule__EDouble__Group__0 ) )
            // InternalEduTest.g:493:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalEduTest.g:494:3: ( rule__EDouble__Group__0 )
            // InternalEduTest.g:494:4: rule__EDouble__Group__0
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
    // InternalEduTest.g:503:1: ruleOrder : ( ( rule__Order__Alternatives ) ) ;
    public final void ruleOrder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:507:1: ( ( ( rule__Order__Alternatives ) ) )
            // InternalEduTest.g:508:2: ( ( rule__Order__Alternatives ) )
            {
            // InternalEduTest.g:508:2: ( ( rule__Order__Alternatives ) )
            // InternalEduTest.g:509:3: ( rule__Order__Alternatives )
            {
             before(grammarAccess.getOrderAccess().getAlternatives()); 
            // InternalEduTest.g:510:3: ( rule__Order__Alternatives )
            // InternalEduTest.g:510:4: rule__Order__Alternatives
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
    // InternalEduTest.g:519:1: ruleMode : ( ( rule__Mode__Alternatives ) ) ;
    public final void ruleMode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:523:1: ( ( ( rule__Mode__Alternatives ) ) )
            // InternalEduTest.g:524:2: ( ( rule__Mode__Alternatives ) )
            {
            // InternalEduTest.g:524:2: ( ( rule__Mode__Alternatives ) )
            // InternalEduTest.g:525:3: ( rule__Mode__Alternatives )
            {
             before(grammarAccess.getModeAccess().getAlternatives()); 
            // InternalEduTest.g:526:3: ( rule__Mode__Alternatives )
            // InternalEduTest.g:526:4: rule__Mode__Alternatives
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
    // InternalEduTest.g:535:1: ruleNavigation : ( ( rule__Navigation__Alternatives ) ) ;
    public final void ruleNavigation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:539:1: ( ( ( rule__Navigation__Alternatives ) ) )
            // InternalEduTest.g:540:2: ( ( rule__Navigation__Alternatives ) )
            {
            // InternalEduTest.g:540:2: ( ( rule__Navigation__Alternatives ) )
            // InternalEduTest.g:541:3: ( rule__Navigation__Alternatives )
            {
             before(grammarAccess.getNavigationAccess().getAlternatives()); 
            // InternalEduTest.g:542:3: ( rule__Navigation__Alternatives )
            // InternalEduTest.g:542:4: rule__Navigation__Alternatives
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
    // InternalEduTest.g:550:1: rule__MutatorTests__Alternatives : ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) | ( ruleMatchPairs ) | ( ruleMissingWords ) | ( ruleMultiChoiceText ) | ( ruleAlternativeText ) | ( ruleDragAndDropText ) );
    public final void rule__MutatorTests__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:554:1: ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) | ( ruleMatchPairs ) | ( ruleMissingWords ) | ( ruleMultiChoiceText ) | ( ruleAlternativeText ) | ( ruleDragAndDropText ) )
            int alt1=8;
            switch ( input.LA(1) ) {
            case 25:
                {
                alt1=1;
                }
                break;
            case 29:
                {
                alt1=2;
                }
                break;
            case 30:
                {
                alt1=3;
                }
                break;
            case 31:
                {
                alt1=4;
                }
                break;
            case 32:
                {
                alt1=5;
                }
                break;
            case 33:
                {
                alt1=6;
                }
                break;
            case 34:
                {
                alt1=7;
                }
                break;
            case 35:
                {
                alt1=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalEduTest.g:555:2: ( ruleAlternativeResponse )
                    {
                    // InternalEduTest.g:555:2: ( ruleAlternativeResponse )
                    // InternalEduTest.g:556:3: ruleAlternativeResponse
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
                    // InternalEduTest.g:561:2: ( ruleMultiChoiceDiagram )
                    {
                    // InternalEduTest.g:561:2: ( ruleMultiChoiceDiagram )
                    // InternalEduTest.g:562:3: ruleMultiChoiceDiagram
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
                    // InternalEduTest.g:567:2: ( ruleMultiChoiceEmendation )
                    {
                    // InternalEduTest.g:567:2: ( ruleMultiChoiceEmendation )
                    // InternalEduTest.g:568:3: ruleMultiChoiceEmendation
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
                    // InternalEduTest.g:573:2: ( ruleMatchPairs )
                    {
                    // InternalEduTest.g:573:2: ( ruleMatchPairs )
                    // InternalEduTest.g:574:3: ruleMatchPairs
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
                    // InternalEduTest.g:579:2: ( ruleMissingWords )
                    {
                    // InternalEduTest.g:579:2: ( ruleMissingWords )
                    // InternalEduTest.g:580:3: ruleMissingWords
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMissingWordsParserRuleCall_4()); 
                    pushFollow(FOLLOW_2);
                    ruleMissingWords();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMissingWordsParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalEduTest.g:585:2: ( ruleMultiChoiceText )
                    {
                    // InternalEduTest.g:585:2: ( ruleMultiChoiceText )
                    // InternalEduTest.g:586:3: ruleMultiChoiceText
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMultiChoiceTextParserRuleCall_5()); 
                    pushFollow(FOLLOW_2);
                    ruleMultiChoiceText();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMultiChoiceTextParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalEduTest.g:591:2: ( ruleAlternativeText )
                    {
                    // InternalEduTest.g:591:2: ( ruleAlternativeText )
                    // InternalEduTest.g:592:3: ruleAlternativeText
                    {
                     before(grammarAccess.getMutatorTestsAccess().getAlternativeTextParserRuleCall_6()); 
                    pushFollow(FOLLOW_2);
                    ruleAlternativeText();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getAlternativeTextParserRuleCall_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalEduTest.g:597:2: ( ruleDragAndDropText )
                    {
                    // InternalEduTest.g:597:2: ( ruleDragAndDropText )
                    // InternalEduTest.g:598:3: ruleDragAndDropText
                    {
                     before(grammarAccess.getMutatorTestsAccess().getDragAndDropTextParserRuleCall_7()); 
                    pushFollow(FOLLOW_2);
                    ruleDragAndDropText();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getDragAndDropTextParserRuleCall_7()); 

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
    // InternalEduTest.g:607:1: rule__TestConfiguration__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__TestConfiguration__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:611:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:612:2: ( 'yes' )
                    {
                    // InternalEduTest.g:612:2: ( 'yes' )
                    // InternalEduTest.g:613:3: 'yes'
                    {
                     before(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:618:2: ( 'no' )
                    {
                    // InternalEduTest.g:618:2: ( 'no' )
                    // InternalEduTest.g:619:3: 'no'
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
    // InternalEduTest.g:628:1: rule__MultiChoiceEmConfig__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:632:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:633:2: ( 'yes' )
                    {
                    // InternalEduTest.g:633:2: ( 'yes' )
                    // InternalEduTest.g:634:3: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:639:2: ( 'no' )
                    {
                    // InternalEduTest.g:639:2: ( 'no' )
                    // InternalEduTest.g:640:3: 'no'
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
    // InternalEduTest.g:649:1: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__WeightedAlternatives_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:653:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:654:2: ( 'yes' )
                    {
                    // InternalEduTest.g:654:2: ( 'yes' )
                    // InternalEduTest.g:655:3: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:660:2: ( 'no' )
                    {
                    // InternalEduTest.g:660:2: ( 'no' )
                    // InternalEduTest.g:661:3: 'no'
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


    // $ANTLR start "rule__TextConfiguration__RetryAlternatives_3_0"
    // InternalEduTest.g:670:1: rule__TextConfiguration__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__TextConfiguration__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:674:1: ( ( 'yes' ) | ( 'no' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==11) ) {
                alt5=1;
            }
            else if ( (LA5_0==12) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalEduTest.g:675:2: ( 'yes' )
                    {
                    // InternalEduTest.g:675:2: ( 'yes' )
                    // InternalEduTest.g:676:3: 'yes'
                    {
                     before(grammarAccess.getTextConfigurationAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTextConfigurationAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:681:2: ( 'no' )
                    {
                    // InternalEduTest.g:681:2: ( 'no' )
                    // InternalEduTest.g:682:3: 'no'
                    {
                     before(grammarAccess.getTextConfigurationAccess().getRetryNoKeyword_3_0_1()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getTextConfigurationAccess().getRetryNoKeyword_3_0_1()); 

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
    // $ANTLR end "rule__TextConfiguration__RetryAlternatives_3_0"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalEduTest.g:691:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:695:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalEduTest.g:696:2: ( RULE_STRING )
                    {
                    // InternalEduTest.g:696:2: ( RULE_STRING )
                    // InternalEduTest.g:697:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:702:2: ( RULE_ID )
                    {
                    // InternalEduTest.g:702:2: ( RULE_ID )
                    // InternalEduTest.g:703:3: RULE_ID
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
    // InternalEduTest.g:712:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:716:1: ( ( 'E' ) | ( 'e' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            else if ( (LA7_0==14) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalEduTest.g:717:2: ( 'E' )
                    {
                    // InternalEduTest.g:717:2: ( 'E' )
                    // InternalEduTest.g:718:3: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:723:2: ( 'e' )
                    {
                    // InternalEduTest.g:723:2: ( 'e' )
                    // InternalEduTest.g:724:3: 'e'
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
    // InternalEduTest.g:733:1: rule__Order__Alternatives : ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) );
    public final void rule__Order__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:737:1: ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt8=1;
                }
                break;
            case 16:
                {
                alt8=2;
                }
                break;
            case 17:
                {
                alt8=3;
                }
                break;
            case 18:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalEduTest.g:738:2: ( ( 'fixed' ) )
                    {
                    // InternalEduTest.g:738:2: ( ( 'fixed' ) )
                    // InternalEduTest.g:739:3: ( 'fixed' )
                    {
                     before(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:740:3: ( 'fixed' )
                    // InternalEduTest.g:740:4: 'fixed'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:744:2: ( ( 'random' ) )
                    {
                    // InternalEduTest.g:744:2: ( ( 'random' ) )
                    // InternalEduTest.g:745:3: ( 'random' )
                    {
                     before(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:746:3: ( 'random' )
                    // InternalEduTest.g:746:4: 'random'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEduTest.g:750:2: ( ( 'options-ascending' ) )
                    {
                    // InternalEduTest.g:750:2: ( ( 'options-ascending' ) )
                    // InternalEduTest.g:751:3: ( 'options-ascending' )
                    {
                     before(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 
                    // InternalEduTest.g:752:3: ( 'options-ascending' )
                    // InternalEduTest.g:752:4: 'options-ascending'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalEduTest.g:756:2: ( ( 'options-descending' ) )
                    {
                    // InternalEduTest.g:756:2: ( ( 'options-descending' ) )
                    // InternalEduTest.g:757:3: ( 'options-descending' )
                    {
                     before(grammarAccess.getOrderAccess().getDescendingEnumLiteralDeclaration_3()); 
                    // InternalEduTest.g:758:3: ( 'options-descending' )
                    // InternalEduTest.g:758:4: 'options-descending'
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
    // InternalEduTest.g:766:1: rule__Mode__Alternatives : ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) );
    public final void rule__Mode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:770:1: ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==20) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalEduTest.g:771:2: ( ( 'radiobutton' ) )
                    {
                    // InternalEduTest.g:771:2: ( ( 'radiobutton' ) )
                    // InternalEduTest.g:772:3: ( 'radiobutton' )
                    {
                     before(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:773:3: ( 'radiobutton' )
                    // InternalEduTest.g:773:4: 'radiobutton'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:777:2: ( ( 'checkbox' ) )
                    {
                    // InternalEduTest.g:777:2: ( ( 'checkbox' ) )
                    // InternalEduTest.g:778:3: ( 'checkbox' )
                    {
                     before(grammarAccess.getModeAccess().getCheckboxEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:779:3: ( 'checkbox' )
                    // InternalEduTest.g:779:4: 'checkbox'
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
    // InternalEduTest.g:787:1: rule__Navigation__Alternatives : ( ( ( 'free' ) ) | ( ( 'locked' ) ) );
    public final void rule__Navigation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:791:1: ( ( ( 'free' ) ) | ( ( 'locked' ) ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            else if ( (LA10_0==22) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalEduTest.g:792:2: ( ( 'free' ) )
                    {
                    // InternalEduTest.g:792:2: ( ( 'free' ) )
                    // InternalEduTest.g:793:3: ( 'free' )
                    {
                     before(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:794:3: ( 'free' )
                    // InternalEduTest.g:794:4: 'free'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:798:2: ( ( 'locked' ) )
                    {
                    // InternalEduTest.g:798:2: ( ( 'locked' ) )
                    // InternalEduTest.g:799:3: ( 'locked' )
                    {
                     before(grammarAccess.getNavigationAccess().getLockedEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:800:3: ( 'locked' )
                    // InternalEduTest.g:800:4: 'locked'
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
    // InternalEduTest.g:808:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:812:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // InternalEduTest.g:813:2: rule__Program__Group__0__Impl rule__Program__Group__1
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
    // InternalEduTest.g:820:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:824:1: ( ( () ) )
            // InternalEduTest.g:825:1: ( () )
            {
            // InternalEduTest.g:825:1: ( () )
            // InternalEduTest.g:826:2: ()
            {
             before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            // InternalEduTest.g:827:2: ()
            // InternalEduTest.g:827:3: 
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
    // InternalEduTest.g:835:1: rule__Program__Group__1 : rule__Program__Group__1__Impl rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:839:1: ( rule__Program__Group__1__Impl rule__Program__Group__2 )
            // InternalEduTest.g:840:2: rule__Program__Group__1__Impl rule__Program__Group__2
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
    // InternalEduTest.g:847:1: rule__Program__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:851:1: ( ( 'metamodel' ) )
            // InternalEduTest.g:852:1: ( 'metamodel' )
            {
            // InternalEduTest.g:852:1: ( 'metamodel' )
            // InternalEduTest.g:853:2: 'metamodel'
            {
             before(grammarAccess.getProgramAccess().getMetamodelKeyword_1()); 
            match(input,23,FOLLOW_2); 
             after(grammarAccess.getProgramAccess().getMetamodelKeyword_1()); 

            }


            }

        }
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
    // InternalEduTest.g:862:1: rule__Program__Group__2 : rule__Program__Group__2__Impl rule__Program__Group__3 ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:866:1: ( rule__Program__Group__2__Impl rule__Program__Group__3 )
            // InternalEduTest.g:867:2: rule__Program__Group__2__Impl rule__Program__Group__3
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:874:1: rule__Program__Group__2__Impl : ( ( rule__Program__MetamodelAssignment_2 ) ) ;
    public final void rule__Program__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:878:1: ( ( ( rule__Program__MetamodelAssignment_2 ) ) )
            // InternalEduTest.g:879:1: ( ( rule__Program__MetamodelAssignment_2 ) )
            {
            // InternalEduTest.g:879:1: ( ( rule__Program__MetamodelAssignment_2 ) )
            // InternalEduTest.g:880:2: ( rule__Program__MetamodelAssignment_2 )
            {
             before(grammarAccess.getProgramAccess().getMetamodelAssignment_2()); 
            // InternalEduTest.g:881:2: ( rule__Program__MetamodelAssignment_2 )
            // InternalEduTest.g:881:3: rule__Program__MetamodelAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__Program__MetamodelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getMetamodelAssignment_2()); 

            }


            }

        }
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
    // InternalEduTest.g:889:1: rule__Program__Group__3 : rule__Program__Group__3__Impl rule__Program__Group__4 ;
    public final void rule__Program__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:893:1: ( rule__Program__Group__3__Impl rule__Program__Group__4 )
            // InternalEduTest.g:894:2: rule__Program__Group__3__Impl rule__Program__Group__4
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:901:1: rule__Program__Group__3__Impl : ( ( rule__Program__ConfigAssignment_3 )? ) ;
    public final void rule__Program__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:905:1: ( ( ( rule__Program__ConfigAssignment_3 )? ) )
            // InternalEduTest.g:906:1: ( ( rule__Program__ConfigAssignment_3 )? )
            {
            // InternalEduTest.g:906:1: ( ( rule__Program__ConfigAssignment_3 )? )
            // InternalEduTest.g:907:2: ( rule__Program__ConfigAssignment_3 )?
            {
             before(grammarAccess.getProgramAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:908:2: ( rule__Program__ConfigAssignment_3 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==36) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalEduTest.g:908:3: rule__Program__ConfigAssignment_3
                    {
                    pushFollow(FOLLOW_2);
                    rule__Program__ConfigAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getProgramAccess().getConfigAssignment_3()); 

            }


            }

        }
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
    // InternalEduTest.g:916:1: rule__Program__Group__4 : rule__Program__Group__4__Impl ;
    public final void rule__Program__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:920:1: ( rule__Program__Group__4__Impl )
            // InternalEduTest.g:921:2: rule__Program__Group__4__Impl
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
    // InternalEduTest.g:927:1: rule__Program__Group__4__Impl : ( ( ( rule__Program__ExercisesAssignment_4 ) ) ( ( rule__Program__ExercisesAssignment_4 )* ) ) ;
    public final void rule__Program__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:931:1: ( ( ( ( rule__Program__ExercisesAssignment_4 ) ) ( ( rule__Program__ExercisesAssignment_4 )* ) ) )
            // InternalEduTest.g:932:1: ( ( ( rule__Program__ExercisesAssignment_4 ) ) ( ( rule__Program__ExercisesAssignment_4 )* ) )
            {
            // InternalEduTest.g:932:1: ( ( ( rule__Program__ExercisesAssignment_4 ) ) ( ( rule__Program__ExercisesAssignment_4 )* ) )
            // InternalEduTest.g:933:2: ( ( rule__Program__ExercisesAssignment_4 ) ) ( ( rule__Program__ExercisesAssignment_4 )* )
            {
            // InternalEduTest.g:933:2: ( ( rule__Program__ExercisesAssignment_4 ) )
            // InternalEduTest.g:934:3: ( rule__Program__ExercisesAssignment_4 )
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_4()); 
            // InternalEduTest.g:935:3: ( rule__Program__ExercisesAssignment_4 )
            // InternalEduTest.g:935:4: rule__Program__ExercisesAssignment_4
            {
            pushFollow(FOLLOW_6);
            rule__Program__ExercisesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getExercisesAssignment_4()); 

            }

            // InternalEduTest.g:938:2: ( ( rule__Program__ExercisesAssignment_4 )* )
            // InternalEduTest.g:939:3: ( rule__Program__ExercisesAssignment_4 )*
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_4()); 
            // InternalEduTest.g:940:3: ( rule__Program__ExercisesAssignment_4 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25||(LA12_0>=29 && LA12_0<=35)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalEduTest.g:940:4: rule__Program__ExercisesAssignment_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Program__ExercisesAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getProgramAccess().getExercisesAssignment_4()); 

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
    // $ANTLR end "rule__Program__Group__4__Impl"


    // $ANTLR start "rule__MarkedBlock__Group__0"
    // InternalEduTest.g:950:1: rule__MarkedBlock__Group__0 : rule__MarkedBlock__Group__0__Impl rule__MarkedBlock__Group__1 ;
    public final void rule__MarkedBlock__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:954:1: ( rule__MarkedBlock__Group__0__Impl rule__MarkedBlock__Group__1 )
            // InternalEduTest.g:955:2: rule__MarkedBlock__Group__0__Impl rule__MarkedBlock__Group__1
            {
            pushFollow(FOLLOW_7);
            rule__MarkedBlock__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MarkedBlock__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group__0"


    // $ANTLR start "rule__MarkedBlock__Group__0__Impl"
    // InternalEduTest.g:962:1: rule__MarkedBlock__Group__0__Impl : ( () ) ;
    public final void rule__MarkedBlock__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:966:1: ( ( () ) )
            // InternalEduTest.g:967:1: ( () )
            {
            // InternalEduTest.g:967:1: ( () )
            // InternalEduTest.g:968:2: ()
            {
             before(grammarAccess.getMarkedBlockAccess().getMarkedBlockAction_0()); 
            // InternalEduTest.g:969:2: ()
            // InternalEduTest.g:969:3: 
            {
            }

             after(grammarAccess.getMarkedBlockAccess().getMarkedBlockAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group__0__Impl"


    // $ANTLR start "rule__MarkedBlock__Group__1"
    // InternalEduTest.g:977:1: rule__MarkedBlock__Group__1 : rule__MarkedBlock__Group__1__Impl rule__MarkedBlock__Group__2 ;
    public final void rule__MarkedBlock__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:981:1: ( rule__MarkedBlock__Group__1__Impl rule__MarkedBlock__Group__2 )
            // InternalEduTest.g:982:2: rule__MarkedBlock__Group__1__Impl rule__MarkedBlock__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__MarkedBlock__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MarkedBlock__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group__1"


    // $ANTLR start "rule__MarkedBlock__Group__1__Impl"
    // InternalEduTest.g:989:1: rule__MarkedBlock__Group__1__Impl : ( ( rule__MarkedBlock__BlockAssignment_1 ) ) ;
    public final void rule__MarkedBlock__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:993:1: ( ( ( rule__MarkedBlock__BlockAssignment_1 ) ) )
            // InternalEduTest.g:994:1: ( ( rule__MarkedBlock__BlockAssignment_1 ) )
            {
            // InternalEduTest.g:994:1: ( ( rule__MarkedBlock__BlockAssignment_1 ) )
            // InternalEduTest.g:995:2: ( rule__MarkedBlock__BlockAssignment_1 )
            {
             before(grammarAccess.getMarkedBlockAccess().getBlockAssignment_1()); 
            // InternalEduTest.g:996:2: ( rule__MarkedBlock__BlockAssignment_1 )
            // InternalEduTest.g:996:3: rule__MarkedBlock__BlockAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MarkedBlock__BlockAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMarkedBlockAccess().getBlockAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group__1__Impl"


    // $ANTLR start "rule__MarkedBlock__Group__2"
    // InternalEduTest.g:1004:1: rule__MarkedBlock__Group__2 : rule__MarkedBlock__Group__2__Impl ;
    public final void rule__MarkedBlock__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1008:1: ( rule__MarkedBlock__Group__2__Impl )
            // InternalEduTest.g:1009:2: rule__MarkedBlock__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MarkedBlock__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group__2"


    // $ANTLR start "rule__MarkedBlock__Group__2__Impl"
    // InternalEduTest.g:1015:1: rule__MarkedBlock__Group__2__Impl : ( ( rule__MarkedBlock__Group_2__0 )? ) ;
    public final void rule__MarkedBlock__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1019:1: ( ( ( rule__MarkedBlock__Group_2__0 )? ) )
            // InternalEduTest.g:1020:1: ( ( rule__MarkedBlock__Group_2__0 )? )
            {
            // InternalEduTest.g:1020:1: ( ( rule__MarkedBlock__Group_2__0 )? )
            // InternalEduTest.g:1021:2: ( rule__MarkedBlock__Group_2__0 )?
            {
             before(grammarAccess.getMarkedBlockAccess().getGroup_2()); 
            // InternalEduTest.g:1022:2: ( rule__MarkedBlock__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==37) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalEduTest.g:1022:3: rule__MarkedBlock__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MarkedBlock__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMarkedBlockAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group__2__Impl"


    // $ANTLR start "rule__MarkedBlock__Group_2__0"
    // InternalEduTest.g:1031:1: rule__MarkedBlock__Group_2__0 : rule__MarkedBlock__Group_2__0__Impl rule__MarkedBlock__Group_2__1 ;
    public final void rule__MarkedBlock__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1035:1: ( rule__MarkedBlock__Group_2__0__Impl rule__MarkedBlock__Group_2__1 )
            // InternalEduTest.g:1036:2: rule__MarkedBlock__Group_2__0__Impl rule__MarkedBlock__Group_2__1
            {
            pushFollow(FOLLOW_9);
            rule__MarkedBlock__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MarkedBlock__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group_2__0"


    // $ANTLR start "rule__MarkedBlock__Group_2__0__Impl"
    // InternalEduTest.g:1043:1: rule__MarkedBlock__Group_2__0__Impl : ( ( rule__MarkedBlock__SolutionAssignment_2_0 ) ) ;
    public final void rule__MarkedBlock__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1047:1: ( ( ( rule__MarkedBlock__SolutionAssignment_2_0 ) ) )
            // InternalEduTest.g:1048:1: ( ( rule__MarkedBlock__SolutionAssignment_2_0 ) )
            {
            // InternalEduTest.g:1048:1: ( ( rule__MarkedBlock__SolutionAssignment_2_0 ) )
            // InternalEduTest.g:1049:2: ( rule__MarkedBlock__SolutionAssignment_2_0 )
            {
             before(grammarAccess.getMarkedBlockAccess().getSolutionAssignment_2_0()); 
            // InternalEduTest.g:1050:2: ( rule__MarkedBlock__SolutionAssignment_2_0 )
            // InternalEduTest.g:1050:3: rule__MarkedBlock__SolutionAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__MarkedBlock__SolutionAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getMarkedBlockAccess().getSolutionAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group_2__0__Impl"


    // $ANTLR start "rule__MarkedBlock__Group_2__1"
    // InternalEduTest.g:1058:1: rule__MarkedBlock__Group_2__1 : rule__MarkedBlock__Group_2__1__Impl ;
    public final void rule__MarkedBlock__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1062:1: ( rule__MarkedBlock__Group_2__1__Impl )
            // InternalEduTest.g:1063:2: rule__MarkedBlock__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MarkedBlock__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group_2__1"


    // $ANTLR start "rule__MarkedBlock__Group_2__1__Impl"
    // InternalEduTest.g:1069:1: rule__MarkedBlock__Group_2__1__Impl : ( 'solution' ) ;
    public final void rule__MarkedBlock__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1073:1: ( ( 'solution' ) )
            // InternalEduTest.g:1074:1: ( 'solution' )
            {
            // InternalEduTest.g:1074:1: ( 'solution' )
            // InternalEduTest.g:1075:2: 'solution'
            {
             before(grammarAccess.getMarkedBlockAccess().getSolutionKeyword_2_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getMarkedBlockAccess().getSolutionKeyword_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__Group_2__1__Impl"


    // $ANTLR start "rule__AlternativeResponse__Group__0"
    // InternalEduTest.g:1085:1: rule__AlternativeResponse__Group__0 : rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 ;
    public final void rule__AlternativeResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1089:1: ( rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 )
            // InternalEduTest.g:1090:2: rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1097:1: rule__AlternativeResponse__Group__0__Impl : ( 'AlternativeResponse' ) ;
    public final void rule__AlternativeResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1101:1: ( ( 'AlternativeResponse' ) )
            // InternalEduTest.g:1102:1: ( 'AlternativeResponse' )
            {
            // InternalEduTest.g:1102:1: ( 'AlternativeResponse' )
            // InternalEduTest.g:1103:2: 'AlternativeResponse'
            {
             before(grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0()); 
            match(input,25,FOLLOW_2); 
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
    // InternalEduTest.g:1112:1: rule__AlternativeResponse__Group__1 : rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 ;
    public final void rule__AlternativeResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1116:1: ( rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 )
            // InternalEduTest.g:1117:2: rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1124:1: rule__AlternativeResponse__Group__1__Impl : ( ( rule__AlternativeResponse__Group_1__0 )? ) ;
    public final void rule__AlternativeResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1128:1: ( ( ( rule__AlternativeResponse__Group_1__0 )? ) )
            // InternalEduTest.g:1129:1: ( ( rule__AlternativeResponse__Group_1__0 )? )
            {
            // InternalEduTest.g:1129:1: ( ( rule__AlternativeResponse__Group_1__0 )? )
            // InternalEduTest.g:1130:2: ( rule__AlternativeResponse__Group_1__0 )?
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup_1()); 
            // InternalEduTest.g:1131:2: ( rule__AlternativeResponse__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalEduTest.g:1131:3: rule__AlternativeResponse__Group_1__0
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
    // InternalEduTest.g:1139:1: rule__AlternativeResponse__Group__2 : rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 ;
    public final void rule__AlternativeResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1143:1: ( rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 )
            // InternalEduTest.g:1144:2: rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:1151:1: rule__AlternativeResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__AlternativeResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1155:1: ( ( '{' ) )
            // InternalEduTest.g:1156:1: ( '{' )
            {
            // InternalEduTest.g:1156:1: ( '{' )
            // InternalEduTest.g:1157:2: '{'
            {
             before(grammarAccess.getAlternativeResponseAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:1166:1: rule__AlternativeResponse__Group__3 : rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 ;
    public final void rule__AlternativeResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1170:1: ( rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 )
            // InternalEduTest.g:1171:2: rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:1178:1: rule__AlternativeResponse__Group__3__Impl : ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) ;
    public final void rule__AlternativeResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1182:1: ( ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1183:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1183:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            // InternalEduTest.g:1184:2: ( rule__AlternativeResponse__ConfigAssignment_3 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1185:2: ( rule__AlternativeResponse__ConfigAssignment_3 )
            // InternalEduTest.g:1185:3: rule__AlternativeResponse__ConfigAssignment_3
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
    // InternalEduTest.g:1193:1: rule__AlternativeResponse__Group__4 : rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 ;
    public final void rule__AlternativeResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1197:1: ( rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 )
            // InternalEduTest.g:1198:2: rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:1205:1: rule__AlternativeResponse__Group__4__Impl : ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) ;
    public final void rule__AlternativeResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1209:1: ( ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1210:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1210:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            // InternalEduTest.g:1211:2: ( rule__AlternativeResponse__TestsAssignment_4 )*
            {
             before(grammarAccess.getAlternativeResponseAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1212:2: ( rule__AlternativeResponse__TestsAssignment_4 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==46) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalEduTest.g:1212:3: rule__AlternativeResponse__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__AlternativeResponse__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalEduTest.g:1220:1: rule__AlternativeResponse__Group__5 : rule__AlternativeResponse__Group__5__Impl ;
    public final void rule__AlternativeResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1224:1: ( rule__AlternativeResponse__Group__5__Impl )
            // InternalEduTest.g:1225:2: rule__AlternativeResponse__Group__5__Impl
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
    // InternalEduTest.g:1231:1: rule__AlternativeResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__AlternativeResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1235:1: ( ( '}' ) )
            // InternalEduTest.g:1236:1: ( '}' )
            {
            // InternalEduTest.g:1236:1: ( '}' )
            // InternalEduTest.g:1237:2: '}'
            {
             before(grammarAccess.getAlternativeResponseAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalEduTest.g:1247:1: rule__AlternativeResponse__Group_1__0 : rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1 ;
    public final void rule__AlternativeResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1251:1: ( rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1 )
            // InternalEduTest.g:1252:2: rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:1259:1: rule__AlternativeResponse__Group_1__0__Impl : ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__AlternativeResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1263:1: ( ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1264:1: ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1264:1: ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:1265:2: ( rule__AlternativeResponse__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:1266:2: ( rule__AlternativeResponse__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:1266:3: rule__AlternativeResponse__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:1274:1: rule__AlternativeResponse__Group_1__1 : rule__AlternativeResponse__Group_1__1__Impl ;
    public final void rule__AlternativeResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1278:1: ( rule__AlternativeResponse__Group_1__1__Impl )
            // InternalEduTest.g:1279:2: rule__AlternativeResponse__Group_1__1__Impl
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
    // InternalEduTest.g:1285:1: rule__AlternativeResponse__Group_1__1__Impl : ( ( rule__AlternativeResponse__Group_1_1__0 )* ) ;
    public final void rule__AlternativeResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1289:1: ( ( ( rule__AlternativeResponse__Group_1_1__0 )* ) )
            // InternalEduTest.g:1290:1: ( ( rule__AlternativeResponse__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1290:1: ( ( rule__AlternativeResponse__Group_1_1__0 )* )
            // InternalEduTest.g:1291:2: ( rule__AlternativeResponse__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup_1_1()); 
            // InternalEduTest.g:1292:2: ( rule__AlternativeResponse__Group_1_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==28) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalEduTest.g:1292:3: rule__AlternativeResponse__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__AlternativeResponse__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalEduTest.g:1301:1: rule__AlternativeResponse__Group_1_1__0 : rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1 ;
    public final void rule__AlternativeResponse__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1305:1: ( rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1 )
            // InternalEduTest.g:1306:2: rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:1313:1: rule__AlternativeResponse__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__AlternativeResponse__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1317:1: ( ( ',' ) )
            // InternalEduTest.g:1318:1: ( ',' )
            {
            // InternalEduTest.g:1318:1: ( ',' )
            // InternalEduTest.g:1319:2: ','
            {
             before(grammarAccess.getAlternativeResponseAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:1328:1: rule__AlternativeResponse__Group_1_1__1 : rule__AlternativeResponse__Group_1_1__1__Impl ;
    public final void rule__AlternativeResponse__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1332:1: ( rule__AlternativeResponse__Group_1_1__1__Impl )
            // InternalEduTest.g:1333:2: rule__AlternativeResponse__Group_1_1__1__Impl
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
    // InternalEduTest.g:1339:1: rule__AlternativeResponse__Group_1_1__1__Impl : ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__AlternativeResponse__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1343:1: ( ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1344:1: ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1344:1: ( ( rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1345:2: ( rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1346:2: ( rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:1346:3: rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalEduTest.g:1355:1: rule__MultiChoiceDiagram__Group__0 : rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 ;
    public final void rule__MultiChoiceDiagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1359:1: ( rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 )
            // InternalEduTest.g:1360:2: rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1367:1: rule__MultiChoiceDiagram__Group__0__Impl : ( 'MultiChoiceDiagram' ) ;
    public final void rule__MultiChoiceDiagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1371:1: ( ( 'MultiChoiceDiagram' ) )
            // InternalEduTest.g:1372:1: ( 'MultiChoiceDiagram' )
            {
            // InternalEduTest.g:1372:1: ( 'MultiChoiceDiagram' )
            // InternalEduTest.g:1373:2: 'MultiChoiceDiagram'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0()); 
            match(input,29,FOLLOW_2); 
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
    // InternalEduTest.g:1382:1: rule__MultiChoiceDiagram__Group__1 : rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 ;
    public final void rule__MultiChoiceDiagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1386:1: ( rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 )
            // InternalEduTest.g:1387:2: rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1394:1: rule__MultiChoiceDiagram__Group__1__Impl : ( ( rule__MultiChoiceDiagram__Group_1__0 )? ) ;
    public final void rule__MultiChoiceDiagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1398:1: ( ( ( rule__MultiChoiceDiagram__Group_1__0 )? ) )
            // InternalEduTest.g:1399:1: ( ( rule__MultiChoiceDiagram__Group_1__0 )? )
            {
            // InternalEduTest.g:1399:1: ( ( rule__MultiChoiceDiagram__Group_1__0 )? )
            // InternalEduTest.g:1400:2: ( rule__MultiChoiceDiagram__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1()); 
            // InternalEduTest.g:1401:2: ( rule__MultiChoiceDiagram__Group_1__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalEduTest.g:1401:3: rule__MultiChoiceDiagram__Group_1__0
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
    // InternalEduTest.g:1409:1: rule__MultiChoiceDiagram__Group__2 : rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 ;
    public final void rule__MultiChoiceDiagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1413:1: ( rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 )
            // InternalEduTest.g:1414:2: rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:1421:1: rule__MultiChoiceDiagram__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceDiagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1425:1: ( ( '{' ) )
            // InternalEduTest.g:1426:1: ( '{' )
            {
            // InternalEduTest.g:1426:1: ( '{' )
            // InternalEduTest.g:1427:2: '{'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:1436:1: rule__MultiChoiceDiagram__Group__3 : rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 ;
    public final void rule__MultiChoiceDiagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1440:1: ( rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 )
            // InternalEduTest.g:1441:2: rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:1448:1: rule__MultiChoiceDiagram__Group__3__Impl : ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceDiagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1452:1: ( ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1453:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1453:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            // InternalEduTest.g:1454:2: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1455:2: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            // InternalEduTest.g:1455:3: rule__MultiChoiceDiagram__ConfigAssignment_3
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
    // InternalEduTest.g:1463:1: rule__MultiChoiceDiagram__Group__4 : rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 ;
    public final void rule__MultiChoiceDiagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1467:1: ( rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 )
            // InternalEduTest.g:1468:2: rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:1475:1: rule__MultiChoiceDiagram__Group__4__Impl : ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceDiagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1479:1: ( ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1480:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1480:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            // InternalEduTest.g:1481:2: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1482:2: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==46) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalEduTest.g:1482:3: rule__MultiChoiceDiagram__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__MultiChoiceDiagram__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalEduTest.g:1490:1: rule__MultiChoiceDiagram__Group__5 : rule__MultiChoiceDiagram__Group__5__Impl ;
    public final void rule__MultiChoiceDiagram__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1494:1: ( rule__MultiChoiceDiagram__Group__5__Impl )
            // InternalEduTest.g:1495:2: rule__MultiChoiceDiagram__Group__5__Impl
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
    // InternalEduTest.g:1501:1: rule__MultiChoiceDiagram__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceDiagram__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1505:1: ( ( '}' ) )
            // InternalEduTest.g:1506:1: ( '}' )
            {
            // InternalEduTest.g:1506:1: ( '}' )
            // InternalEduTest.g:1507:2: '}'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalEduTest.g:1517:1: rule__MultiChoiceDiagram__Group_1__0 : rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1 ;
    public final void rule__MultiChoiceDiagram__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1521:1: ( rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1 )
            // InternalEduTest.g:1522:2: rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:1529:1: rule__MultiChoiceDiagram__Group_1__0__Impl : ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceDiagram__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1533:1: ( ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1534:1: ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1534:1: ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:1535:2: ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:1536:2: ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:1536:3: rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:1544:1: rule__MultiChoiceDiagram__Group_1__1 : rule__MultiChoiceDiagram__Group_1__1__Impl ;
    public final void rule__MultiChoiceDiagram__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1548:1: ( rule__MultiChoiceDiagram__Group_1__1__Impl )
            // InternalEduTest.g:1549:2: rule__MultiChoiceDiagram__Group_1__1__Impl
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
    // InternalEduTest.g:1555:1: rule__MultiChoiceDiagram__Group_1__1__Impl : ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceDiagram__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1559:1: ( ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* ) )
            // InternalEduTest.g:1560:1: ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1560:1: ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* )
            // InternalEduTest.g:1561:2: ( rule__MultiChoiceDiagram__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1_1()); 
            // InternalEduTest.g:1562:2: ( rule__MultiChoiceDiagram__Group_1_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==28) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalEduTest.g:1562:3: rule__MultiChoiceDiagram__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MultiChoiceDiagram__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // InternalEduTest.g:1571:1: rule__MultiChoiceDiagram__Group_1_1__0 : rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1 ;
    public final void rule__MultiChoiceDiagram__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1575:1: ( rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1 )
            // InternalEduTest.g:1576:2: rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:1583:1: rule__MultiChoiceDiagram__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceDiagram__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1587:1: ( ( ',' ) )
            // InternalEduTest.g:1588:1: ( ',' )
            {
            // InternalEduTest.g:1588:1: ( ',' )
            // InternalEduTest.g:1589:2: ','
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:1598:1: rule__MultiChoiceDiagram__Group_1_1__1 : rule__MultiChoiceDiagram__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceDiagram__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1602:1: ( rule__MultiChoiceDiagram__Group_1_1__1__Impl )
            // InternalEduTest.g:1603:2: rule__MultiChoiceDiagram__Group_1_1__1__Impl
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
    // InternalEduTest.g:1609:1: rule__MultiChoiceDiagram__Group_1_1__1__Impl : ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceDiagram__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1613:1: ( ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1614:1: ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1614:1: ( ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1615:2: ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1616:2: ( rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:1616:3: rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalEduTest.g:1625:1: rule__MultiChoiceEmendation__Group__0 : rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 ;
    public final void rule__MultiChoiceEmendation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1629:1: ( rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 )
            // InternalEduTest.g:1630:2: rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1637:1: rule__MultiChoiceEmendation__Group__0__Impl : ( 'MultiChoiceEmendation' ) ;
    public final void rule__MultiChoiceEmendation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1641:1: ( ( 'MultiChoiceEmendation' ) )
            // InternalEduTest.g:1642:1: ( 'MultiChoiceEmendation' )
            {
            // InternalEduTest.g:1642:1: ( 'MultiChoiceEmendation' )
            // InternalEduTest.g:1643:2: 'MultiChoiceEmendation'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalEduTest.g:1652:1: rule__MultiChoiceEmendation__Group__1 : rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 ;
    public final void rule__MultiChoiceEmendation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1656:1: ( rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 )
            // InternalEduTest.g:1657:2: rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1664:1: rule__MultiChoiceEmendation__Group__1__Impl : ( ( rule__MultiChoiceEmendation__Group_1__0 )? ) ;
    public final void rule__MultiChoiceEmendation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1668:1: ( ( ( rule__MultiChoiceEmendation__Group_1__0 )? ) )
            // InternalEduTest.g:1669:1: ( ( rule__MultiChoiceEmendation__Group_1__0 )? )
            {
            // InternalEduTest.g:1669:1: ( ( rule__MultiChoiceEmendation__Group_1__0 )? )
            // InternalEduTest.g:1670:2: ( rule__MultiChoiceEmendation__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1()); 
            // InternalEduTest.g:1671:2: ( rule__MultiChoiceEmendation__Group_1__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalEduTest.g:1671:3: rule__MultiChoiceEmendation__Group_1__0
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
    // InternalEduTest.g:1679:1: rule__MultiChoiceEmendation__Group__2 : rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 ;
    public final void rule__MultiChoiceEmendation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1683:1: ( rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 )
            // InternalEduTest.g:1684:2: rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:1691:1: rule__MultiChoiceEmendation__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceEmendation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1695:1: ( ( '{' ) )
            // InternalEduTest.g:1696:1: ( '{' )
            {
            // InternalEduTest.g:1696:1: ( '{' )
            // InternalEduTest.g:1697:2: '{'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:1706:1: rule__MultiChoiceEmendation__Group__3 : rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 ;
    public final void rule__MultiChoiceEmendation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1710:1: ( rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 )
            // InternalEduTest.g:1711:2: rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:1718:1: rule__MultiChoiceEmendation__Group__3__Impl : ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmendation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1722:1: ( ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1723:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1723:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            // InternalEduTest.g:1724:2: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1725:2: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            // InternalEduTest.g:1725:3: rule__MultiChoiceEmendation__ConfigAssignment_3
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
    // InternalEduTest.g:1733:1: rule__MultiChoiceEmendation__Group__4 : rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 ;
    public final void rule__MultiChoiceEmendation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1737:1: ( rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 )
            // InternalEduTest.g:1738:2: rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:1745:1: rule__MultiChoiceEmendation__Group__4__Impl : ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceEmendation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1749:1: ( ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1750:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1750:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            // InternalEduTest.g:1751:2: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1752:2: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==46) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalEduTest.g:1752:3: rule__MultiChoiceEmendation__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__MultiChoiceEmendation__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalEduTest.g:1760:1: rule__MultiChoiceEmendation__Group__5 : rule__MultiChoiceEmendation__Group__5__Impl ;
    public final void rule__MultiChoiceEmendation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1764:1: ( rule__MultiChoiceEmendation__Group__5__Impl )
            // InternalEduTest.g:1765:2: rule__MultiChoiceEmendation__Group__5__Impl
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
    // InternalEduTest.g:1771:1: rule__MultiChoiceEmendation__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceEmendation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1775:1: ( ( '}' ) )
            // InternalEduTest.g:1776:1: ( '}' )
            {
            // InternalEduTest.g:1776:1: ( '}' )
            // InternalEduTest.g:1777:2: '}'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalEduTest.g:1787:1: rule__MultiChoiceEmendation__Group_1__0 : rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1 ;
    public final void rule__MultiChoiceEmendation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1791:1: ( rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1 )
            // InternalEduTest.g:1792:2: rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:1799:1: rule__MultiChoiceEmendation__Group_1__0__Impl : ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceEmendation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1803:1: ( ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1804:1: ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1804:1: ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:1805:2: ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:1806:2: ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:1806:3: rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:1814:1: rule__MultiChoiceEmendation__Group_1__1 : rule__MultiChoiceEmendation__Group_1__1__Impl ;
    public final void rule__MultiChoiceEmendation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1818:1: ( rule__MultiChoiceEmendation__Group_1__1__Impl )
            // InternalEduTest.g:1819:2: rule__MultiChoiceEmendation__Group_1__1__Impl
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
    // InternalEduTest.g:1825:1: rule__MultiChoiceEmendation__Group_1__1__Impl : ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceEmendation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1829:1: ( ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* ) )
            // InternalEduTest.g:1830:1: ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1830:1: ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* )
            // InternalEduTest.g:1831:2: ( rule__MultiChoiceEmendation__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1_1()); 
            // InternalEduTest.g:1832:2: ( rule__MultiChoiceEmendation__Group_1_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==28) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalEduTest.g:1832:3: rule__MultiChoiceEmendation__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MultiChoiceEmendation__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // InternalEduTest.g:1841:1: rule__MultiChoiceEmendation__Group_1_1__0 : rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1 ;
    public final void rule__MultiChoiceEmendation__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1845:1: ( rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1 )
            // InternalEduTest.g:1846:2: rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:1853:1: rule__MultiChoiceEmendation__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmendation__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1857:1: ( ( ',' ) )
            // InternalEduTest.g:1858:1: ( ',' )
            {
            // InternalEduTest.g:1858:1: ( ',' )
            // InternalEduTest.g:1859:2: ','
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:1868:1: rule__MultiChoiceEmendation__Group_1_1__1 : rule__MultiChoiceEmendation__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceEmendation__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1872:1: ( rule__MultiChoiceEmendation__Group_1_1__1__Impl )
            // InternalEduTest.g:1873:2: rule__MultiChoiceEmendation__Group_1_1__1__Impl
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
    // InternalEduTest.g:1879:1: rule__MultiChoiceEmendation__Group_1_1__1__Impl : ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceEmendation__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1883:1: ( ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1884:1: ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1884:1: ( ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1885:2: ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1886:2: ( rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:1886:3: rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalEduTest.g:1895:1: rule__MatchPairs__Group__0 : rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1 ;
    public final void rule__MatchPairs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1899:1: ( rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1 )
            // InternalEduTest.g:1900:2: rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1907:1: rule__MatchPairs__Group__0__Impl : ( 'MatchPairs' ) ;
    public final void rule__MatchPairs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1911:1: ( ( 'MatchPairs' ) )
            // InternalEduTest.g:1912:1: ( 'MatchPairs' )
            {
            // InternalEduTest.g:1912:1: ( 'MatchPairs' )
            // InternalEduTest.g:1913:2: 'MatchPairs'
            {
             before(grammarAccess.getMatchPairsAccess().getMatchPairsKeyword_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalEduTest.g:1922:1: rule__MatchPairs__Group__1 : rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2 ;
    public final void rule__MatchPairs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1926:1: ( rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2 )
            // InternalEduTest.g:1927:2: rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:1934:1: rule__MatchPairs__Group__1__Impl : ( ( rule__MatchPairs__Group_1__0 )? ) ;
    public final void rule__MatchPairs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1938:1: ( ( ( rule__MatchPairs__Group_1__0 )? ) )
            // InternalEduTest.g:1939:1: ( ( rule__MatchPairs__Group_1__0 )? )
            {
            // InternalEduTest.g:1939:1: ( ( rule__MatchPairs__Group_1__0 )? )
            // InternalEduTest.g:1940:2: ( rule__MatchPairs__Group_1__0 )?
            {
             before(grammarAccess.getMatchPairsAccess().getGroup_1()); 
            // InternalEduTest.g:1941:2: ( rule__MatchPairs__Group_1__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==RULE_ID) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalEduTest.g:1941:3: rule__MatchPairs__Group_1__0
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
    // InternalEduTest.g:1949:1: rule__MatchPairs__Group__2 : rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3 ;
    public final void rule__MatchPairs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1953:1: ( rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3 )
            // InternalEduTest.g:1954:2: rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:1961:1: rule__MatchPairs__Group__2__Impl : ( '{' ) ;
    public final void rule__MatchPairs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1965:1: ( ( '{' ) )
            // InternalEduTest.g:1966:1: ( '{' )
            {
            // InternalEduTest.g:1966:1: ( '{' )
            // InternalEduTest.g:1967:2: '{'
            {
             before(grammarAccess.getMatchPairsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:1976:1: rule__MatchPairs__Group__3 : rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4 ;
    public final void rule__MatchPairs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1980:1: ( rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4 )
            // InternalEduTest.g:1981:2: rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:1988:1: rule__MatchPairs__Group__3__Impl : ( ( rule__MatchPairs__ConfigAssignment_3 ) ) ;
    public final void rule__MatchPairs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1992:1: ( ( ( rule__MatchPairs__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1993:1: ( ( rule__MatchPairs__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1993:1: ( ( rule__MatchPairs__ConfigAssignment_3 ) )
            // InternalEduTest.g:1994:2: ( rule__MatchPairs__ConfigAssignment_3 )
            {
             before(grammarAccess.getMatchPairsAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1995:2: ( rule__MatchPairs__ConfigAssignment_3 )
            // InternalEduTest.g:1995:3: rule__MatchPairs__ConfigAssignment_3
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
    // InternalEduTest.g:2003:1: rule__MatchPairs__Group__4 : rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5 ;
    public final void rule__MatchPairs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2007:1: ( rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5 )
            // InternalEduTest.g:2008:2: rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:2015:1: rule__MatchPairs__Group__4__Impl : ( ( rule__MatchPairs__TestsAssignment_4 )* ) ;
    public final void rule__MatchPairs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2019:1: ( ( ( rule__MatchPairs__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2020:1: ( ( rule__MatchPairs__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2020:1: ( ( rule__MatchPairs__TestsAssignment_4 )* )
            // InternalEduTest.g:2021:2: ( rule__MatchPairs__TestsAssignment_4 )*
            {
             before(grammarAccess.getMatchPairsAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2022:2: ( rule__MatchPairs__TestsAssignment_4 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==46) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalEduTest.g:2022:3: rule__MatchPairs__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__MatchPairs__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalEduTest.g:2030:1: rule__MatchPairs__Group__5 : rule__MatchPairs__Group__5__Impl ;
    public final void rule__MatchPairs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2034:1: ( rule__MatchPairs__Group__5__Impl )
            // InternalEduTest.g:2035:2: rule__MatchPairs__Group__5__Impl
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
    // InternalEduTest.g:2041:1: rule__MatchPairs__Group__5__Impl : ( '}' ) ;
    public final void rule__MatchPairs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2045:1: ( ( '}' ) )
            // InternalEduTest.g:2046:1: ( '}' )
            {
            // InternalEduTest.g:2046:1: ( '}' )
            // InternalEduTest.g:2047:2: '}'
            {
             before(grammarAccess.getMatchPairsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalEduTest.g:2057:1: rule__MatchPairs__Group_1__0 : rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1 ;
    public final void rule__MatchPairs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2061:1: ( rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1 )
            // InternalEduTest.g:2062:2: rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:2069:1: rule__MatchPairs__Group_1__0__Impl : ( ( rule__MatchPairs__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__MatchPairs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2073:1: ( ( ( rule__MatchPairs__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2074:1: ( ( rule__MatchPairs__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2074:1: ( ( rule__MatchPairs__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:2075:2: ( rule__MatchPairs__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getMatchPairsAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:2076:2: ( rule__MatchPairs__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:2076:3: rule__MatchPairs__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMatchPairsAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:2084:1: rule__MatchPairs__Group_1__1 : rule__MatchPairs__Group_1__1__Impl ;
    public final void rule__MatchPairs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2088:1: ( rule__MatchPairs__Group_1__1__Impl )
            // InternalEduTest.g:2089:2: rule__MatchPairs__Group_1__1__Impl
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
    // InternalEduTest.g:2095:1: rule__MatchPairs__Group_1__1__Impl : ( ( rule__MatchPairs__Group_1_1__0 )* ) ;
    public final void rule__MatchPairs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2099:1: ( ( ( rule__MatchPairs__Group_1_1__0 )* ) )
            // InternalEduTest.g:2100:1: ( ( rule__MatchPairs__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2100:1: ( ( rule__MatchPairs__Group_1_1__0 )* )
            // InternalEduTest.g:2101:2: ( rule__MatchPairs__Group_1_1__0 )*
            {
             before(grammarAccess.getMatchPairsAccess().getGroup_1_1()); 
            // InternalEduTest.g:2102:2: ( rule__MatchPairs__Group_1_1__0 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==28) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalEduTest.g:2102:3: rule__MatchPairs__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MatchPairs__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // InternalEduTest.g:2111:1: rule__MatchPairs__Group_1_1__0 : rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1 ;
    public final void rule__MatchPairs__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2115:1: ( rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1 )
            // InternalEduTest.g:2116:2: rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2123:1: rule__MatchPairs__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MatchPairs__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2127:1: ( ( ',' ) )
            // InternalEduTest.g:2128:1: ( ',' )
            {
            // InternalEduTest.g:2128:1: ( ',' )
            // InternalEduTest.g:2129:2: ','
            {
             before(grammarAccess.getMatchPairsAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:2138:1: rule__MatchPairs__Group_1_1__1 : rule__MatchPairs__Group_1_1__1__Impl ;
    public final void rule__MatchPairs__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2142:1: ( rule__MatchPairs__Group_1_1__1__Impl )
            // InternalEduTest.g:2143:2: rule__MatchPairs__Group_1_1__1__Impl
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
    // InternalEduTest.g:2149:1: rule__MatchPairs__Group_1_1__1__Impl : ( ( rule__MatchPairs__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__MatchPairs__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2153:1: ( ( ( rule__MatchPairs__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2154:1: ( ( rule__MatchPairs__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2154:1: ( ( rule__MatchPairs__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2155:2: ( rule__MatchPairs__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMatchPairsAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2156:2: ( rule__MatchPairs__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:2156:3: rule__MatchPairs__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MatchPairs__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMatchPairsAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalEduTest.g:2165:1: rule__MissingWords__Group__0 : rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1 ;
    public final void rule__MissingWords__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2169:1: ( rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1 )
            // InternalEduTest.g:2170:2: rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:2177:1: rule__MissingWords__Group__0__Impl : ( 'MissingWords' ) ;
    public final void rule__MissingWords__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2181:1: ( ( 'MissingWords' ) )
            // InternalEduTest.g:2182:1: ( 'MissingWords' )
            {
            // InternalEduTest.g:2182:1: ( 'MissingWords' )
            // InternalEduTest.g:2183:2: 'MissingWords'
            {
             before(grammarAccess.getMissingWordsAccess().getMissingWordsKeyword_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalEduTest.g:2192:1: rule__MissingWords__Group__1 : rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2 ;
    public final void rule__MissingWords__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2196:1: ( rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2 )
            // InternalEduTest.g:2197:2: rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2
            {
            pushFollow(FOLLOW_10);
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
    // InternalEduTest.g:2204:1: rule__MissingWords__Group__1__Impl : ( ( rule__MissingWords__Group_1__0 )? ) ;
    public final void rule__MissingWords__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2208:1: ( ( ( rule__MissingWords__Group_1__0 )? ) )
            // InternalEduTest.g:2209:1: ( ( rule__MissingWords__Group_1__0 )? )
            {
            // InternalEduTest.g:2209:1: ( ( rule__MissingWords__Group_1__0 )? )
            // InternalEduTest.g:2210:2: ( rule__MissingWords__Group_1__0 )?
            {
             before(grammarAccess.getMissingWordsAccess().getGroup_1()); 
            // InternalEduTest.g:2211:2: ( rule__MissingWords__Group_1__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalEduTest.g:2211:3: rule__MissingWords__Group_1__0
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
    // InternalEduTest.g:2219:1: rule__MissingWords__Group__2 : rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3 ;
    public final void rule__MissingWords__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2223:1: ( rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3 )
            // InternalEduTest.g:2224:2: rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:2231:1: rule__MissingWords__Group__2__Impl : ( '{' ) ;
    public final void rule__MissingWords__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2235:1: ( ( '{' ) )
            // InternalEduTest.g:2236:1: ( '{' )
            {
            // InternalEduTest.g:2236:1: ( '{' )
            // InternalEduTest.g:2237:2: '{'
            {
             before(grammarAccess.getMissingWordsAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:2246:1: rule__MissingWords__Group__3 : rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4 ;
    public final void rule__MissingWords__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2250:1: ( rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4 )
            // InternalEduTest.g:2251:2: rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:2258:1: rule__MissingWords__Group__3__Impl : ( ( rule__MissingWords__ConfigAssignment_3 ) ) ;
    public final void rule__MissingWords__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2262:1: ( ( ( rule__MissingWords__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:2263:1: ( ( rule__MissingWords__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:2263:1: ( ( rule__MissingWords__ConfigAssignment_3 ) )
            // InternalEduTest.g:2264:2: ( rule__MissingWords__ConfigAssignment_3 )
            {
             before(grammarAccess.getMissingWordsAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:2265:2: ( rule__MissingWords__ConfigAssignment_3 )
            // InternalEduTest.g:2265:3: rule__MissingWords__ConfigAssignment_3
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
    // InternalEduTest.g:2273:1: rule__MissingWords__Group__4 : rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5 ;
    public final void rule__MissingWords__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2277:1: ( rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5 )
            // InternalEduTest.g:2278:2: rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:2285:1: rule__MissingWords__Group__4__Impl : ( ( rule__MissingWords__TestsAssignment_4 )* ) ;
    public final void rule__MissingWords__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2289:1: ( ( ( rule__MissingWords__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2290:1: ( ( rule__MissingWords__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2290:1: ( ( rule__MissingWords__TestsAssignment_4 )* )
            // InternalEduTest.g:2291:2: ( rule__MissingWords__TestsAssignment_4 )*
            {
             before(grammarAccess.getMissingWordsAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2292:2: ( rule__MissingWords__TestsAssignment_4 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==46) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalEduTest.g:2292:3: rule__MissingWords__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__MissingWords__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalEduTest.g:2300:1: rule__MissingWords__Group__5 : rule__MissingWords__Group__5__Impl ;
    public final void rule__MissingWords__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2304:1: ( rule__MissingWords__Group__5__Impl )
            // InternalEduTest.g:2305:2: rule__MissingWords__Group__5__Impl
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
    // InternalEduTest.g:2311:1: rule__MissingWords__Group__5__Impl : ( '}' ) ;
    public final void rule__MissingWords__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2315:1: ( ( '}' ) )
            // InternalEduTest.g:2316:1: ( '}' )
            {
            // InternalEduTest.g:2316:1: ( '}' )
            // InternalEduTest.g:2317:2: '}'
            {
             before(grammarAccess.getMissingWordsAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
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
    // InternalEduTest.g:2327:1: rule__MissingWords__Group_1__0 : rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1 ;
    public final void rule__MissingWords__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2331:1: ( rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1 )
            // InternalEduTest.g:2332:2: rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:2339:1: rule__MissingWords__Group_1__0__Impl : ( ( rule__MissingWords__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__MissingWords__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2343:1: ( ( ( rule__MissingWords__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2344:1: ( ( rule__MissingWords__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2344:1: ( ( rule__MissingWords__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:2345:2: ( rule__MissingWords__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getMissingWordsAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:2346:2: ( rule__MissingWords__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:2346:3: rule__MissingWords__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMissingWordsAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:2354:1: rule__MissingWords__Group_1__1 : rule__MissingWords__Group_1__1__Impl ;
    public final void rule__MissingWords__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2358:1: ( rule__MissingWords__Group_1__1__Impl )
            // InternalEduTest.g:2359:2: rule__MissingWords__Group_1__1__Impl
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
    // InternalEduTest.g:2365:1: rule__MissingWords__Group_1__1__Impl : ( ( rule__MissingWords__Group_1_1__0 )* ) ;
    public final void rule__MissingWords__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2369:1: ( ( ( rule__MissingWords__Group_1_1__0 )* ) )
            // InternalEduTest.g:2370:1: ( ( rule__MissingWords__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2370:1: ( ( rule__MissingWords__Group_1_1__0 )* )
            // InternalEduTest.g:2371:2: ( rule__MissingWords__Group_1_1__0 )*
            {
             before(grammarAccess.getMissingWordsAccess().getGroup_1_1()); 
            // InternalEduTest.g:2372:2: ( rule__MissingWords__Group_1_1__0 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==28) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalEduTest.g:2372:3: rule__MissingWords__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MissingWords__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // InternalEduTest.g:2381:1: rule__MissingWords__Group_1_1__0 : rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1 ;
    public final void rule__MissingWords__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2385:1: ( rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1 )
            // InternalEduTest.g:2386:2: rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2393:1: rule__MissingWords__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MissingWords__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2397:1: ( ( ',' ) )
            // InternalEduTest.g:2398:1: ( ',' )
            {
            // InternalEduTest.g:2398:1: ( ',' )
            // InternalEduTest.g:2399:2: ','
            {
             before(grammarAccess.getMissingWordsAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:2408:1: rule__MissingWords__Group_1_1__1 : rule__MissingWords__Group_1_1__1__Impl ;
    public final void rule__MissingWords__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2412:1: ( rule__MissingWords__Group_1_1__1__Impl )
            // InternalEduTest.g:2413:2: rule__MissingWords__Group_1_1__1__Impl
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
    // InternalEduTest.g:2419:1: rule__MissingWords__Group_1_1__1__Impl : ( ( rule__MissingWords__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__MissingWords__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2423:1: ( ( ( rule__MissingWords__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2424:1: ( ( rule__MissingWords__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2424:1: ( ( rule__MissingWords__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2425:2: ( rule__MissingWords__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMissingWordsAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2426:2: ( rule__MissingWords__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:2426:3: rule__MissingWords__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MissingWords__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMissingWordsAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__MultiChoiceText__Group__0"
    // InternalEduTest.g:2435:1: rule__MultiChoiceText__Group__0 : rule__MultiChoiceText__Group__0__Impl rule__MultiChoiceText__Group__1 ;
    public final void rule__MultiChoiceText__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2439:1: ( rule__MultiChoiceText__Group__0__Impl rule__MultiChoiceText__Group__1 )
            // InternalEduTest.g:2440:2: rule__MultiChoiceText__Group__0__Impl rule__MultiChoiceText__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__MultiChoiceText__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__0"


    // $ANTLR start "rule__MultiChoiceText__Group__0__Impl"
    // InternalEduTest.g:2447:1: rule__MultiChoiceText__Group__0__Impl : ( 'MultiChoiceText' ) ;
    public final void rule__MultiChoiceText__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2451:1: ( ( 'MultiChoiceText' ) )
            // InternalEduTest.g:2452:1: ( 'MultiChoiceText' )
            {
            // InternalEduTest.g:2452:1: ( 'MultiChoiceText' )
            // InternalEduTest.g:2453:2: 'MultiChoiceText'
            {
             before(grammarAccess.getMultiChoiceTextAccess().getMultiChoiceTextKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceTextAccess().getMultiChoiceTextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__0__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group__1"
    // InternalEduTest.g:2462:1: rule__MultiChoiceText__Group__1 : rule__MultiChoiceText__Group__1__Impl rule__MultiChoiceText__Group__2 ;
    public final void rule__MultiChoiceText__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2466:1: ( rule__MultiChoiceText__Group__1__Impl rule__MultiChoiceText__Group__2 )
            // InternalEduTest.g:2467:2: rule__MultiChoiceText__Group__1__Impl rule__MultiChoiceText__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__MultiChoiceText__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__1"


    // $ANTLR start "rule__MultiChoiceText__Group__1__Impl"
    // InternalEduTest.g:2474:1: rule__MultiChoiceText__Group__1__Impl : ( ( rule__MultiChoiceText__Group_1__0 )? ) ;
    public final void rule__MultiChoiceText__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2478:1: ( ( ( rule__MultiChoiceText__Group_1__0 )? ) )
            // InternalEduTest.g:2479:1: ( ( rule__MultiChoiceText__Group_1__0 )? )
            {
            // InternalEduTest.g:2479:1: ( ( rule__MultiChoiceText__Group_1__0 )? )
            // InternalEduTest.g:2480:2: ( rule__MultiChoiceText__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceTextAccess().getGroup_1()); 
            // InternalEduTest.g:2481:2: ( rule__MultiChoiceText__Group_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalEduTest.g:2481:3: rule__MultiChoiceText__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiChoiceText__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiChoiceTextAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__1__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group__2"
    // InternalEduTest.g:2489:1: rule__MultiChoiceText__Group__2 : rule__MultiChoiceText__Group__2__Impl rule__MultiChoiceText__Group__3 ;
    public final void rule__MultiChoiceText__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2493:1: ( rule__MultiChoiceText__Group__2__Impl rule__MultiChoiceText__Group__3 )
            // InternalEduTest.g:2494:2: rule__MultiChoiceText__Group__2__Impl rule__MultiChoiceText__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__MultiChoiceText__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__2"


    // $ANTLR start "rule__MultiChoiceText__Group__2__Impl"
    // InternalEduTest.g:2501:1: rule__MultiChoiceText__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceText__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2505:1: ( ( '{' ) )
            // InternalEduTest.g:2506:1: ( '{' )
            {
            // InternalEduTest.g:2506:1: ( '{' )
            // InternalEduTest.g:2507:2: '{'
            {
             before(grammarAccess.getMultiChoiceTextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceTextAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__2__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group__3"
    // InternalEduTest.g:2516:1: rule__MultiChoiceText__Group__3 : rule__MultiChoiceText__Group__3__Impl rule__MultiChoiceText__Group__4 ;
    public final void rule__MultiChoiceText__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2520:1: ( rule__MultiChoiceText__Group__3__Impl rule__MultiChoiceText__Group__4 )
            // InternalEduTest.g:2521:2: rule__MultiChoiceText__Group__3__Impl rule__MultiChoiceText__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__MultiChoiceText__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__3"


    // $ANTLR start "rule__MultiChoiceText__Group__3__Impl"
    // InternalEduTest.g:2528:1: rule__MultiChoiceText__Group__3__Impl : ( ( rule__MultiChoiceText__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceText__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2532:1: ( ( ( rule__MultiChoiceText__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:2533:1: ( ( rule__MultiChoiceText__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:2533:1: ( ( rule__MultiChoiceText__ConfigAssignment_3 ) )
            // InternalEduTest.g:2534:2: ( rule__MultiChoiceText__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:2535:2: ( rule__MultiChoiceText__ConfigAssignment_3 )
            // InternalEduTest.g:2535:3: rule__MultiChoiceText__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceTextAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__3__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group__4"
    // InternalEduTest.g:2543:1: rule__MultiChoiceText__Group__4 : rule__MultiChoiceText__Group__4__Impl rule__MultiChoiceText__Group__5 ;
    public final void rule__MultiChoiceText__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2547:1: ( rule__MultiChoiceText__Group__4__Impl rule__MultiChoiceText__Group__5 )
            // InternalEduTest.g:2548:2: rule__MultiChoiceText__Group__4__Impl rule__MultiChoiceText__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__MultiChoiceText__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__4"


    // $ANTLR start "rule__MultiChoiceText__Group__4__Impl"
    // InternalEduTest.g:2555:1: rule__MultiChoiceText__Group__4__Impl : ( ( rule__MultiChoiceText__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceText__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2559:1: ( ( ( rule__MultiChoiceText__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2560:1: ( ( rule__MultiChoiceText__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2560:1: ( ( rule__MultiChoiceText__TestsAssignment_4 )* )
            // InternalEduTest.g:2561:2: ( rule__MultiChoiceText__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceTextAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2562:2: ( rule__MultiChoiceText__TestsAssignment_4 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==46) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalEduTest.g:2562:3: rule__MultiChoiceText__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__MultiChoiceText__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceTextAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__4__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group__5"
    // InternalEduTest.g:2570:1: rule__MultiChoiceText__Group__5 : rule__MultiChoiceText__Group__5__Impl ;
    public final void rule__MultiChoiceText__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2574:1: ( rule__MultiChoiceText__Group__5__Impl )
            // InternalEduTest.g:2575:2: rule__MultiChoiceText__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__5"


    // $ANTLR start "rule__MultiChoiceText__Group__5__Impl"
    // InternalEduTest.g:2581:1: rule__MultiChoiceText__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceText__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2585:1: ( ( '}' ) )
            // InternalEduTest.g:2586:1: ( '}' )
            {
            // InternalEduTest.g:2586:1: ( '}' )
            // InternalEduTest.g:2587:2: '}'
            {
             before(grammarAccess.getMultiChoiceTextAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceTextAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group__5__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group_1__0"
    // InternalEduTest.g:2597:1: rule__MultiChoiceText__Group_1__0 : rule__MultiChoiceText__Group_1__0__Impl rule__MultiChoiceText__Group_1__1 ;
    public final void rule__MultiChoiceText__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2601:1: ( rule__MultiChoiceText__Group_1__0__Impl rule__MultiChoiceText__Group_1__1 )
            // InternalEduTest.g:2602:2: rule__MultiChoiceText__Group_1__0__Impl rule__MultiChoiceText__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__MultiChoiceText__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1__0"


    // $ANTLR start "rule__MultiChoiceText__Group_1__0__Impl"
    // InternalEduTest.g:2609:1: rule__MultiChoiceText__Group_1__0__Impl : ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceText__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2613:1: ( ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2614:1: ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2614:1: ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:2615:2: ( rule__MultiChoiceText__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:2616:2: ( rule__MultiChoiceText__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:2616:3: rule__MultiChoiceText__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1__0__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group_1__1"
    // InternalEduTest.g:2624:1: rule__MultiChoiceText__Group_1__1 : rule__MultiChoiceText__Group_1__1__Impl ;
    public final void rule__MultiChoiceText__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2628:1: ( rule__MultiChoiceText__Group_1__1__Impl )
            // InternalEduTest.g:2629:2: rule__MultiChoiceText__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1__1"


    // $ANTLR start "rule__MultiChoiceText__Group_1__1__Impl"
    // InternalEduTest.g:2635:1: rule__MultiChoiceText__Group_1__1__Impl : ( ( rule__MultiChoiceText__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceText__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2639:1: ( ( ( rule__MultiChoiceText__Group_1_1__0 )* ) )
            // InternalEduTest.g:2640:1: ( ( rule__MultiChoiceText__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2640:1: ( ( rule__MultiChoiceText__Group_1_1__0 )* )
            // InternalEduTest.g:2641:2: ( rule__MultiChoiceText__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceTextAccess().getGroup_1_1()); 
            // InternalEduTest.g:2642:2: ( rule__MultiChoiceText__Group_1_1__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==28) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalEduTest.g:2642:3: rule__MultiChoiceText__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MultiChoiceText__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceTextAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1__1__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group_1_1__0"
    // InternalEduTest.g:2651:1: rule__MultiChoiceText__Group_1_1__0 : rule__MultiChoiceText__Group_1_1__0__Impl rule__MultiChoiceText__Group_1_1__1 ;
    public final void rule__MultiChoiceText__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2655:1: ( rule__MultiChoiceText__Group_1_1__0__Impl rule__MultiChoiceText__Group_1_1__1 )
            // InternalEduTest.g:2656:2: rule__MultiChoiceText__Group_1_1__0__Impl rule__MultiChoiceText__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceText__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1_1__0"


    // $ANTLR start "rule__MultiChoiceText__Group_1_1__0__Impl"
    // InternalEduTest.g:2663:1: rule__MultiChoiceText__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceText__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2667:1: ( ( ',' ) )
            // InternalEduTest.g:2668:1: ( ',' )
            {
            // InternalEduTest.g:2668:1: ( ',' )
            // InternalEduTest.g:2669:2: ','
            {
             before(grammarAccess.getMultiChoiceTextAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceTextAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1_1__0__Impl"


    // $ANTLR start "rule__MultiChoiceText__Group_1_1__1"
    // InternalEduTest.g:2678:1: rule__MultiChoiceText__Group_1_1__1 : rule__MultiChoiceText__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceText__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2682:1: ( rule__MultiChoiceText__Group_1_1__1__Impl )
            // InternalEduTest.g:2683:2: rule__MultiChoiceText__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1_1__1"


    // $ANTLR start "rule__MultiChoiceText__Group_1_1__1__Impl"
    // InternalEduTest.g:2689:1: rule__MultiChoiceText__Group_1_1__1__Impl : ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceText__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2693:1: ( ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2694:1: ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2694:1: ( ( rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2695:2: ( rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2696:2: ( rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:2696:3: rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__Group_1_1__1__Impl"


    // $ANTLR start "rule__AlternativeText__Group__0"
    // InternalEduTest.g:2705:1: rule__AlternativeText__Group__0 : rule__AlternativeText__Group__0__Impl rule__AlternativeText__Group__1 ;
    public final void rule__AlternativeText__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2709:1: ( rule__AlternativeText__Group__0__Impl rule__AlternativeText__Group__1 )
            // InternalEduTest.g:2710:2: rule__AlternativeText__Group__0__Impl rule__AlternativeText__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__AlternativeText__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__0"


    // $ANTLR start "rule__AlternativeText__Group__0__Impl"
    // InternalEduTest.g:2717:1: rule__AlternativeText__Group__0__Impl : ( 'AlternativeTextResponse' ) ;
    public final void rule__AlternativeText__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2721:1: ( ( 'AlternativeTextResponse' ) )
            // InternalEduTest.g:2722:1: ( 'AlternativeTextResponse' )
            {
            // InternalEduTest.g:2722:1: ( 'AlternativeTextResponse' )
            // InternalEduTest.g:2723:2: 'AlternativeTextResponse'
            {
             before(grammarAccess.getAlternativeTextAccess().getAlternativeTextResponseKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getAlternativeTextAccess().getAlternativeTextResponseKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__0__Impl"


    // $ANTLR start "rule__AlternativeText__Group__1"
    // InternalEduTest.g:2732:1: rule__AlternativeText__Group__1 : rule__AlternativeText__Group__1__Impl rule__AlternativeText__Group__2 ;
    public final void rule__AlternativeText__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2736:1: ( rule__AlternativeText__Group__1__Impl rule__AlternativeText__Group__2 )
            // InternalEduTest.g:2737:2: rule__AlternativeText__Group__1__Impl rule__AlternativeText__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__AlternativeText__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__1"


    // $ANTLR start "rule__AlternativeText__Group__1__Impl"
    // InternalEduTest.g:2744:1: rule__AlternativeText__Group__1__Impl : ( ( rule__AlternativeText__Group_1__0 )? ) ;
    public final void rule__AlternativeText__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2748:1: ( ( ( rule__AlternativeText__Group_1__0 )? ) )
            // InternalEduTest.g:2749:1: ( ( rule__AlternativeText__Group_1__0 )? )
            {
            // InternalEduTest.g:2749:1: ( ( rule__AlternativeText__Group_1__0 )? )
            // InternalEduTest.g:2750:2: ( rule__AlternativeText__Group_1__0 )?
            {
             before(grammarAccess.getAlternativeTextAccess().getGroup_1()); 
            // InternalEduTest.g:2751:2: ( rule__AlternativeText__Group_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalEduTest.g:2751:3: rule__AlternativeText__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__AlternativeText__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativeTextAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__1__Impl"


    // $ANTLR start "rule__AlternativeText__Group__2"
    // InternalEduTest.g:2759:1: rule__AlternativeText__Group__2 : rule__AlternativeText__Group__2__Impl rule__AlternativeText__Group__3 ;
    public final void rule__AlternativeText__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2763:1: ( rule__AlternativeText__Group__2__Impl rule__AlternativeText__Group__3 )
            // InternalEduTest.g:2764:2: rule__AlternativeText__Group__2__Impl rule__AlternativeText__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__AlternativeText__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__2"


    // $ANTLR start "rule__AlternativeText__Group__2__Impl"
    // InternalEduTest.g:2771:1: rule__AlternativeText__Group__2__Impl : ( '{' ) ;
    public final void rule__AlternativeText__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2775:1: ( ( '{' ) )
            // InternalEduTest.g:2776:1: ( '{' )
            {
            // InternalEduTest.g:2776:1: ( '{' )
            // InternalEduTest.g:2777:2: '{'
            {
             before(grammarAccess.getAlternativeTextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getAlternativeTextAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__2__Impl"


    // $ANTLR start "rule__AlternativeText__Group__3"
    // InternalEduTest.g:2786:1: rule__AlternativeText__Group__3 : rule__AlternativeText__Group__3__Impl rule__AlternativeText__Group__4 ;
    public final void rule__AlternativeText__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2790:1: ( rule__AlternativeText__Group__3__Impl rule__AlternativeText__Group__4 )
            // InternalEduTest.g:2791:2: rule__AlternativeText__Group__3__Impl rule__AlternativeText__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__AlternativeText__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__3"


    // $ANTLR start "rule__AlternativeText__Group__3__Impl"
    // InternalEduTest.g:2798:1: rule__AlternativeText__Group__3__Impl : ( ( rule__AlternativeText__ConfigAssignment_3 ) ) ;
    public final void rule__AlternativeText__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2802:1: ( ( ( rule__AlternativeText__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:2803:1: ( ( rule__AlternativeText__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:2803:1: ( ( rule__AlternativeText__ConfigAssignment_3 ) )
            // InternalEduTest.g:2804:2: ( rule__AlternativeText__ConfigAssignment_3 )
            {
             before(grammarAccess.getAlternativeTextAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:2805:2: ( rule__AlternativeText__ConfigAssignment_3 )
            // InternalEduTest.g:2805:3: rule__AlternativeText__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeTextAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__3__Impl"


    // $ANTLR start "rule__AlternativeText__Group__4"
    // InternalEduTest.g:2813:1: rule__AlternativeText__Group__4 : rule__AlternativeText__Group__4__Impl rule__AlternativeText__Group__5 ;
    public final void rule__AlternativeText__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2817:1: ( rule__AlternativeText__Group__4__Impl rule__AlternativeText__Group__5 )
            // InternalEduTest.g:2818:2: rule__AlternativeText__Group__4__Impl rule__AlternativeText__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__AlternativeText__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__4"


    // $ANTLR start "rule__AlternativeText__Group__4__Impl"
    // InternalEduTest.g:2825:1: rule__AlternativeText__Group__4__Impl : ( ( rule__AlternativeText__TestsAssignment_4 )* ) ;
    public final void rule__AlternativeText__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2829:1: ( ( ( rule__AlternativeText__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2830:1: ( ( rule__AlternativeText__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2830:1: ( ( rule__AlternativeText__TestsAssignment_4 )* )
            // InternalEduTest.g:2831:2: ( rule__AlternativeText__TestsAssignment_4 )*
            {
             before(grammarAccess.getAlternativeTextAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2832:2: ( rule__AlternativeText__TestsAssignment_4 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==46) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalEduTest.g:2832:3: rule__AlternativeText__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__AlternativeText__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getAlternativeTextAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__4__Impl"


    // $ANTLR start "rule__AlternativeText__Group__5"
    // InternalEduTest.g:2840:1: rule__AlternativeText__Group__5 : rule__AlternativeText__Group__5__Impl ;
    public final void rule__AlternativeText__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2844:1: ( rule__AlternativeText__Group__5__Impl )
            // InternalEduTest.g:2845:2: rule__AlternativeText__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__5"


    // $ANTLR start "rule__AlternativeText__Group__5__Impl"
    // InternalEduTest.g:2851:1: rule__AlternativeText__Group__5__Impl : ( '}' ) ;
    public final void rule__AlternativeText__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2855:1: ( ( '}' ) )
            // InternalEduTest.g:2856:1: ( '}' )
            {
            // InternalEduTest.g:2856:1: ( '}' )
            // InternalEduTest.g:2857:2: '}'
            {
             before(grammarAccess.getAlternativeTextAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getAlternativeTextAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group__5__Impl"


    // $ANTLR start "rule__AlternativeText__Group_1__0"
    // InternalEduTest.g:2867:1: rule__AlternativeText__Group_1__0 : rule__AlternativeText__Group_1__0__Impl rule__AlternativeText__Group_1__1 ;
    public final void rule__AlternativeText__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2871:1: ( rule__AlternativeText__Group_1__0__Impl rule__AlternativeText__Group_1__1 )
            // InternalEduTest.g:2872:2: rule__AlternativeText__Group_1__0__Impl rule__AlternativeText__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__AlternativeText__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1__0"


    // $ANTLR start "rule__AlternativeText__Group_1__0__Impl"
    // InternalEduTest.g:2879:1: rule__AlternativeText__Group_1__0__Impl : ( ( rule__AlternativeText__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__AlternativeText__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2883:1: ( ( ( rule__AlternativeText__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2884:1: ( ( rule__AlternativeText__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2884:1: ( ( rule__AlternativeText__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:2885:2: ( rule__AlternativeText__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getAlternativeTextAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:2886:2: ( rule__AlternativeText__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:2886:3: rule__AlternativeText__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeTextAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1__0__Impl"


    // $ANTLR start "rule__AlternativeText__Group_1__1"
    // InternalEduTest.g:2894:1: rule__AlternativeText__Group_1__1 : rule__AlternativeText__Group_1__1__Impl ;
    public final void rule__AlternativeText__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2898:1: ( rule__AlternativeText__Group_1__1__Impl )
            // InternalEduTest.g:2899:2: rule__AlternativeText__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1__1"


    // $ANTLR start "rule__AlternativeText__Group_1__1__Impl"
    // InternalEduTest.g:2905:1: rule__AlternativeText__Group_1__1__Impl : ( ( rule__AlternativeText__Group_1_1__0 )* ) ;
    public final void rule__AlternativeText__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2909:1: ( ( ( rule__AlternativeText__Group_1_1__0 )* ) )
            // InternalEduTest.g:2910:1: ( ( rule__AlternativeText__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2910:1: ( ( rule__AlternativeText__Group_1_1__0 )* )
            // InternalEduTest.g:2911:2: ( rule__AlternativeText__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativeTextAccess().getGroup_1_1()); 
            // InternalEduTest.g:2912:2: ( rule__AlternativeText__Group_1_1__0 )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==28) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalEduTest.g:2912:3: rule__AlternativeText__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__AlternativeText__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

             after(grammarAccess.getAlternativeTextAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1__1__Impl"


    // $ANTLR start "rule__AlternativeText__Group_1_1__0"
    // InternalEduTest.g:2921:1: rule__AlternativeText__Group_1_1__0 : rule__AlternativeText__Group_1_1__0__Impl rule__AlternativeText__Group_1_1__1 ;
    public final void rule__AlternativeText__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2925:1: ( rule__AlternativeText__Group_1_1__0__Impl rule__AlternativeText__Group_1_1__1 )
            // InternalEduTest.g:2926:2: rule__AlternativeText__Group_1_1__0__Impl rule__AlternativeText__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
            rule__AlternativeText__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1_1__0"


    // $ANTLR start "rule__AlternativeText__Group_1_1__0__Impl"
    // InternalEduTest.g:2933:1: rule__AlternativeText__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__AlternativeText__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2937:1: ( ( ',' ) )
            // InternalEduTest.g:2938:1: ( ',' )
            {
            // InternalEduTest.g:2938:1: ( ',' )
            // InternalEduTest.g:2939:2: ','
            {
             before(grammarAccess.getAlternativeTextAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getAlternativeTextAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1_1__0__Impl"


    // $ANTLR start "rule__AlternativeText__Group_1_1__1"
    // InternalEduTest.g:2948:1: rule__AlternativeText__Group_1_1__1 : rule__AlternativeText__Group_1_1__1__Impl ;
    public final void rule__AlternativeText__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2952:1: ( rule__AlternativeText__Group_1_1__1__Impl )
            // InternalEduTest.g:2953:2: rule__AlternativeText__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1_1__1"


    // $ANTLR start "rule__AlternativeText__Group_1_1__1__Impl"
    // InternalEduTest.g:2959:1: rule__AlternativeText__Group_1_1__1__Impl : ( ( rule__AlternativeText__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__AlternativeText__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2963:1: ( ( ( rule__AlternativeText__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2964:1: ( ( rule__AlternativeText__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2964:1: ( ( rule__AlternativeText__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2965:2: ( rule__AlternativeText__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativeTextAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2966:2: ( rule__AlternativeText__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:2966:3: rule__AlternativeText__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeTextAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__Group_1_1__1__Impl"


    // $ANTLR start "rule__DragAndDropText__Group__0"
    // InternalEduTest.g:2975:1: rule__DragAndDropText__Group__0 : rule__DragAndDropText__Group__0__Impl rule__DragAndDropText__Group__1 ;
    public final void rule__DragAndDropText__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2979:1: ( rule__DragAndDropText__Group__0__Impl rule__DragAndDropText__Group__1 )
            // InternalEduTest.g:2980:2: rule__DragAndDropText__Group__0__Impl rule__DragAndDropText__Group__1
            {
            pushFollow(FOLLOW_10);
            rule__DragAndDropText__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__0"


    // $ANTLR start "rule__DragAndDropText__Group__0__Impl"
    // InternalEduTest.g:2987:1: rule__DragAndDropText__Group__0__Impl : ( 'DragAndDropText' ) ;
    public final void rule__DragAndDropText__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2991:1: ( ( 'DragAndDropText' ) )
            // InternalEduTest.g:2992:1: ( 'DragAndDropText' )
            {
            // InternalEduTest.g:2992:1: ( 'DragAndDropText' )
            // InternalEduTest.g:2993:2: 'DragAndDropText'
            {
             before(grammarAccess.getDragAndDropTextAccess().getDragAndDropTextKeyword_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getDragAndDropTextAccess().getDragAndDropTextKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__0__Impl"


    // $ANTLR start "rule__DragAndDropText__Group__1"
    // InternalEduTest.g:3002:1: rule__DragAndDropText__Group__1 : rule__DragAndDropText__Group__1__Impl rule__DragAndDropText__Group__2 ;
    public final void rule__DragAndDropText__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3006:1: ( rule__DragAndDropText__Group__1__Impl rule__DragAndDropText__Group__2 )
            // InternalEduTest.g:3007:2: rule__DragAndDropText__Group__1__Impl rule__DragAndDropText__Group__2
            {
            pushFollow(FOLLOW_10);
            rule__DragAndDropText__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__1"


    // $ANTLR start "rule__DragAndDropText__Group__1__Impl"
    // InternalEduTest.g:3014:1: rule__DragAndDropText__Group__1__Impl : ( ( rule__DragAndDropText__Group_1__0 )? ) ;
    public final void rule__DragAndDropText__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3018:1: ( ( ( rule__DragAndDropText__Group_1__0 )? ) )
            // InternalEduTest.g:3019:1: ( ( rule__DragAndDropText__Group_1__0 )? )
            {
            // InternalEduTest.g:3019:1: ( ( rule__DragAndDropText__Group_1__0 )? )
            // InternalEduTest.g:3020:2: ( rule__DragAndDropText__Group_1__0 )?
            {
             before(grammarAccess.getDragAndDropTextAccess().getGroup_1()); 
            // InternalEduTest.g:3021:2: ( rule__DragAndDropText__Group_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalEduTest.g:3021:3: rule__DragAndDropText__Group_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__DragAndDropText__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getDragAndDropTextAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__1__Impl"


    // $ANTLR start "rule__DragAndDropText__Group__2"
    // InternalEduTest.g:3029:1: rule__DragAndDropText__Group__2 : rule__DragAndDropText__Group__2__Impl rule__DragAndDropText__Group__3 ;
    public final void rule__DragAndDropText__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3033:1: ( rule__DragAndDropText__Group__2__Impl rule__DragAndDropText__Group__3 )
            // InternalEduTest.g:3034:2: rule__DragAndDropText__Group__2__Impl rule__DragAndDropText__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__DragAndDropText__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__2"


    // $ANTLR start "rule__DragAndDropText__Group__2__Impl"
    // InternalEduTest.g:3041:1: rule__DragAndDropText__Group__2__Impl : ( '{' ) ;
    public final void rule__DragAndDropText__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3045:1: ( ( '{' ) )
            // InternalEduTest.g:3046:1: ( '{' )
            {
            // InternalEduTest.g:3046:1: ( '{' )
            // InternalEduTest.g:3047:2: '{'
            {
             before(grammarAccess.getDragAndDropTextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getDragAndDropTextAccess().getLeftCurlyBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__2__Impl"


    // $ANTLR start "rule__DragAndDropText__Group__3"
    // InternalEduTest.g:3056:1: rule__DragAndDropText__Group__3 : rule__DragAndDropText__Group__3__Impl rule__DragAndDropText__Group__4 ;
    public final void rule__DragAndDropText__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3060:1: ( rule__DragAndDropText__Group__3__Impl rule__DragAndDropText__Group__4 )
            // InternalEduTest.g:3061:2: rule__DragAndDropText__Group__3__Impl rule__DragAndDropText__Group__4
            {
            pushFollow(FOLLOW_12);
            rule__DragAndDropText__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__3"


    // $ANTLR start "rule__DragAndDropText__Group__3__Impl"
    // InternalEduTest.g:3068:1: rule__DragAndDropText__Group__3__Impl : ( ( rule__DragAndDropText__ConfigAssignment_3 ) ) ;
    public final void rule__DragAndDropText__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3072:1: ( ( ( rule__DragAndDropText__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:3073:1: ( ( rule__DragAndDropText__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:3073:1: ( ( rule__DragAndDropText__ConfigAssignment_3 ) )
            // InternalEduTest.g:3074:2: ( rule__DragAndDropText__ConfigAssignment_3 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:3075:2: ( rule__DragAndDropText__ConfigAssignment_3 )
            // InternalEduTest.g:3075:3: rule__DragAndDropText__ConfigAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__ConfigAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getDragAndDropTextAccess().getConfigAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__3__Impl"


    // $ANTLR start "rule__DragAndDropText__Group__4"
    // InternalEduTest.g:3083:1: rule__DragAndDropText__Group__4 : rule__DragAndDropText__Group__4__Impl rule__DragAndDropText__Group__5 ;
    public final void rule__DragAndDropText__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3087:1: ( rule__DragAndDropText__Group__4__Impl rule__DragAndDropText__Group__5 )
            // InternalEduTest.g:3088:2: rule__DragAndDropText__Group__4__Impl rule__DragAndDropText__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__DragAndDropText__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__4"


    // $ANTLR start "rule__DragAndDropText__Group__4__Impl"
    // InternalEduTest.g:3095:1: rule__DragAndDropText__Group__4__Impl : ( ( rule__DragAndDropText__TestsAssignment_4 )* ) ;
    public final void rule__DragAndDropText__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3099:1: ( ( ( rule__DragAndDropText__TestsAssignment_4 )* ) )
            // InternalEduTest.g:3100:1: ( ( rule__DragAndDropText__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:3100:1: ( ( rule__DragAndDropText__TestsAssignment_4 )* )
            // InternalEduTest.g:3101:2: ( rule__DragAndDropText__TestsAssignment_4 )*
            {
             before(grammarAccess.getDragAndDropTextAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:3102:2: ( rule__DragAndDropText__TestsAssignment_4 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==46) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalEduTest.g:3102:3: rule__DragAndDropText__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_13);
            	    rule__DragAndDropText__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getDragAndDropTextAccess().getTestsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__4__Impl"


    // $ANTLR start "rule__DragAndDropText__Group__5"
    // InternalEduTest.g:3110:1: rule__DragAndDropText__Group__5 : rule__DragAndDropText__Group__5__Impl ;
    public final void rule__DragAndDropText__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3114:1: ( rule__DragAndDropText__Group__5__Impl )
            // InternalEduTest.g:3115:2: rule__DragAndDropText__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__5"


    // $ANTLR start "rule__DragAndDropText__Group__5__Impl"
    // InternalEduTest.g:3121:1: rule__DragAndDropText__Group__5__Impl : ( '}' ) ;
    public final void rule__DragAndDropText__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3125:1: ( ( '}' ) )
            // InternalEduTest.g:3126:1: ( '}' )
            {
            // InternalEduTest.g:3126:1: ( '}' )
            // InternalEduTest.g:3127:2: '}'
            {
             before(grammarAccess.getDragAndDropTextAccess().getRightCurlyBracketKeyword_5()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getDragAndDropTextAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group__5__Impl"


    // $ANTLR start "rule__DragAndDropText__Group_1__0"
    // InternalEduTest.g:3137:1: rule__DragAndDropText__Group_1__0 : rule__DragAndDropText__Group_1__0__Impl rule__DragAndDropText__Group_1__1 ;
    public final void rule__DragAndDropText__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3141:1: ( rule__DragAndDropText__Group_1__0__Impl rule__DragAndDropText__Group_1__1 )
            // InternalEduTest.g:3142:2: rule__DragAndDropText__Group_1__0__Impl rule__DragAndDropText__Group_1__1
            {
            pushFollow(FOLLOW_14);
            rule__DragAndDropText__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1__0"


    // $ANTLR start "rule__DragAndDropText__Group_1__0__Impl"
    // InternalEduTest.g:3149:1: rule__DragAndDropText__Group_1__0__Impl : ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_0 ) ) ;
    public final void rule__DragAndDropText__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3153:1: ( ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:3154:1: ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:3154:1: ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_0 ) )
            // InternalEduTest.g:3155:2: ( rule__DragAndDropText__MarkedBlocksAssignment_1_0 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksAssignment_1_0()); 
            // InternalEduTest.g:3156:2: ( rule__DragAndDropText__MarkedBlocksAssignment_1_0 )
            // InternalEduTest.g:3156:3: rule__DragAndDropText__MarkedBlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__MarkedBlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1__0__Impl"


    // $ANTLR start "rule__DragAndDropText__Group_1__1"
    // InternalEduTest.g:3164:1: rule__DragAndDropText__Group_1__1 : rule__DragAndDropText__Group_1__1__Impl ;
    public final void rule__DragAndDropText__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3168:1: ( rule__DragAndDropText__Group_1__1__Impl )
            // InternalEduTest.g:3169:2: rule__DragAndDropText__Group_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1__1"


    // $ANTLR start "rule__DragAndDropText__Group_1__1__Impl"
    // InternalEduTest.g:3175:1: rule__DragAndDropText__Group_1__1__Impl : ( ( rule__DragAndDropText__Group_1_1__0 )* ) ;
    public final void rule__DragAndDropText__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3179:1: ( ( ( rule__DragAndDropText__Group_1_1__0 )* ) )
            // InternalEduTest.g:3180:1: ( ( rule__DragAndDropText__Group_1_1__0 )* )
            {
            // InternalEduTest.g:3180:1: ( ( rule__DragAndDropText__Group_1_1__0 )* )
            // InternalEduTest.g:3181:2: ( rule__DragAndDropText__Group_1_1__0 )*
            {
             before(grammarAccess.getDragAndDropTextAccess().getGroup_1_1()); 
            // InternalEduTest.g:3182:2: ( rule__DragAndDropText__Group_1_1__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==28) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalEduTest.g:3182:3: rule__DragAndDropText__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__DragAndDropText__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getDragAndDropTextAccess().getGroup_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1__1__Impl"


    // $ANTLR start "rule__DragAndDropText__Group_1_1__0"
    // InternalEduTest.g:3191:1: rule__DragAndDropText__Group_1_1__0 : rule__DragAndDropText__Group_1_1__0__Impl rule__DragAndDropText__Group_1_1__1 ;
    public final void rule__DragAndDropText__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3195:1: ( rule__DragAndDropText__Group_1_1__0__Impl rule__DragAndDropText__Group_1_1__1 )
            // InternalEduTest.g:3196:2: rule__DragAndDropText__Group_1_1__0__Impl rule__DragAndDropText__Group_1_1__1
            {
            pushFollow(FOLLOW_7);
            rule__DragAndDropText__Group_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1_1__0"


    // $ANTLR start "rule__DragAndDropText__Group_1_1__0__Impl"
    // InternalEduTest.g:3203:1: rule__DragAndDropText__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__DragAndDropText__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3207:1: ( ( ',' ) )
            // InternalEduTest.g:3208:1: ( ',' )
            {
            // InternalEduTest.g:3208:1: ( ',' )
            // InternalEduTest.g:3209:2: ','
            {
             before(grammarAccess.getDragAndDropTextAccess().getCommaKeyword_1_1_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getDragAndDropTextAccess().getCommaKeyword_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1_1__0__Impl"


    // $ANTLR start "rule__DragAndDropText__Group_1_1__1"
    // InternalEduTest.g:3218:1: rule__DragAndDropText__Group_1_1__1 : rule__DragAndDropText__Group_1_1__1__Impl ;
    public final void rule__DragAndDropText__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3222:1: ( rule__DragAndDropText__Group_1_1__1__Impl )
            // InternalEduTest.g:3223:2: rule__DragAndDropText__Group_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__Group_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1_1__1"


    // $ANTLR start "rule__DragAndDropText__Group_1_1__1__Impl"
    // InternalEduTest.g:3229:1: rule__DragAndDropText__Group_1_1__1__Impl : ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_1_1 ) ) ;
    public final void rule__DragAndDropText__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3233:1: ( ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:3234:1: ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:3234:1: ( ( rule__DragAndDropText__MarkedBlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:3235:2: ( rule__DragAndDropText__MarkedBlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:3236:2: ( rule__DragAndDropText__MarkedBlocksAssignment_1_1_1 )
            // InternalEduTest.g:3236:3: rule__DragAndDropText__MarkedBlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__MarkedBlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__Group_1_1__1__Impl"


    // $ANTLR start "rule__ProgramConfiguration__Group__0"
    // InternalEduTest.g:3245:1: rule__ProgramConfiguration__Group__0 : rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 ;
    public final void rule__ProgramConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3249:1: ( rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 )
            // InternalEduTest.g:3250:2: rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:3257:1: rule__ProgramConfiguration__Group__0__Impl : ( 'navigation' ) ;
    public final void rule__ProgramConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3261:1: ( ( 'navigation' ) )
            // InternalEduTest.g:3262:1: ( 'navigation' )
            {
            // InternalEduTest.g:3262:1: ( 'navigation' )
            // InternalEduTest.g:3263:2: 'navigation'
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0()); 
            match(input,36,FOLLOW_2); 
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
    // InternalEduTest.g:3272:1: rule__ProgramConfiguration__Group__1 : rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 ;
    public final void rule__ProgramConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3276:1: ( rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 )
            // InternalEduTest.g:3277:2: rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2
            {
            pushFollow(FOLLOW_16);
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
    // InternalEduTest.g:3284:1: rule__ProgramConfiguration__Group__1__Impl : ( '=' ) ;
    public final void rule__ProgramConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3288:1: ( ( '=' ) )
            // InternalEduTest.g:3289:1: ( '=' )
            {
            // InternalEduTest.g:3289:1: ( '=' )
            // InternalEduTest.g:3290:2: '='
            {
             before(grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:3299:1: rule__ProgramConfiguration__Group__2 : rule__ProgramConfiguration__Group__2__Impl ;
    public final void rule__ProgramConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3303:1: ( rule__ProgramConfiguration__Group__2__Impl )
            // InternalEduTest.g:3304:2: rule__ProgramConfiguration__Group__2__Impl
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
    // InternalEduTest.g:3310:1: rule__ProgramConfiguration__Group__2__Impl : ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) ;
    public final void rule__ProgramConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3314:1: ( ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) )
            // InternalEduTest.g:3315:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            {
            // InternalEduTest.g:3315:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            // InternalEduTest.g:3316:2: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationAssignment_2()); 
            // InternalEduTest.g:3317:2: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            // InternalEduTest.g:3317:3: rule__ProgramConfiguration__NavigationAssignment_2
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
    // InternalEduTest.g:3326:1: rule__TestConfiguration__Group__0 : rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 ;
    public final void rule__TestConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3330:1: ( rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 )
            // InternalEduTest.g:3331:2: rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:3338:1: rule__TestConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__TestConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3342:1: ( ( () ) )
            // InternalEduTest.g:3343:1: ( () )
            {
            // InternalEduTest.g:3343:1: ( () )
            // InternalEduTest.g:3344:2: ()
            {
             before(grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0()); 
            // InternalEduTest.g:3345:2: ()
            // InternalEduTest.g:3345:3: 
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
    // InternalEduTest.g:3353:1: rule__TestConfiguration__Group__1 : rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 ;
    public final void rule__TestConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3357:1: ( rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 )
            // InternalEduTest.g:3358:2: rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:3365:1: rule__TestConfiguration__Group__1__Impl : ( 'retry' ) ;
    public final void rule__TestConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3369:1: ( ( 'retry' ) )
            // InternalEduTest.g:3370:1: ( 'retry' )
            {
            // InternalEduTest.g:3370:1: ( 'retry' )
            // InternalEduTest.g:3371:2: 'retry'
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryKeyword_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalEduTest.g:3380:1: rule__TestConfiguration__Group__2 : rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 ;
    public final void rule__TestConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3384:1: ( rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 )
            // InternalEduTest.g:3385:2: rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3
            {
            pushFollow(FOLLOW_17);
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
    // InternalEduTest.g:3392:1: rule__TestConfiguration__Group__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3396:1: ( ( '=' ) )
            // InternalEduTest.g:3397:1: ( '=' )
            {
            // InternalEduTest.g:3397:1: ( '=' )
            // InternalEduTest.g:3398:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:3407:1: rule__TestConfiguration__Group__3 : rule__TestConfiguration__Group__3__Impl rule__TestConfiguration__Group__4 ;
    public final void rule__TestConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3411:1: ( rule__TestConfiguration__Group__3__Impl rule__TestConfiguration__Group__4 )
            // InternalEduTest.g:3412:2: rule__TestConfiguration__Group__3__Impl rule__TestConfiguration__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__TestConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__4();

            state._fsp--;


            }

        }
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
    // InternalEduTest.g:3419:1: rule__TestConfiguration__Group__3__Impl : ( ( rule__TestConfiguration__RetryAssignment_3 ) ) ;
    public final void rule__TestConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3423:1: ( ( ( rule__TestConfiguration__RetryAssignment_3 ) ) )
            // InternalEduTest.g:3424:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:3424:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            // InternalEduTest.g:3425:2: ( rule__TestConfiguration__RetryAssignment_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:3426:2: ( rule__TestConfiguration__RetryAssignment_3 )
            // InternalEduTest.g:3426:3: rule__TestConfiguration__RetryAssignment_3
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


    // $ANTLR start "rule__TestConfiguration__Group__4"
    // InternalEduTest.g:3434:1: rule__TestConfiguration__Group__4 : rule__TestConfiguration__Group__4__Impl rule__TestConfiguration__Group__5 ;
    public final void rule__TestConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3438:1: ( rule__TestConfiguration__Group__4__Impl rule__TestConfiguration__Group__5 )
            // InternalEduTest.g:3439:2: rule__TestConfiguration__Group__4__Impl rule__TestConfiguration__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__TestConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__4"


    // $ANTLR start "rule__TestConfiguration__Group__4__Impl"
    // InternalEduTest.g:3446:1: rule__TestConfiguration__Group__4__Impl : ( ( rule__TestConfiguration__Group_4__0 )? ) ;
    public final void rule__TestConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3450:1: ( ( ( rule__TestConfiguration__Group_4__0 )? ) )
            // InternalEduTest.g:3451:1: ( ( rule__TestConfiguration__Group_4__0 )? )
            {
            // InternalEduTest.g:3451:1: ( ( rule__TestConfiguration__Group_4__0 )? )
            // InternalEduTest.g:3452:2: ( rule__TestConfiguration__Group_4__0 )?
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_4()); 
            // InternalEduTest.g:3453:2: ( rule__TestConfiguration__Group_4__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==28) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==39) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalEduTest.g:3453:3: rule__TestConfiguration__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TestConfiguration__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTestConfigurationAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__4__Impl"


    // $ANTLR start "rule__TestConfiguration__Group__5"
    // InternalEduTest.g:3461:1: rule__TestConfiguration__Group__5 : rule__TestConfiguration__Group__5__Impl rule__TestConfiguration__Group__6 ;
    public final void rule__TestConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3465:1: ( rule__TestConfiguration__Group__5__Impl rule__TestConfiguration__Group__6 )
            // InternalEduTest.g:3466:2: rule__TestConfiguration__Group__5__Impl rule__TestConfiguration__Group__6
            {
            pushFollow(FOLLOW_14);
            rule__TestConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__5"


    // $ANTLR start "rule__TestConfiguration__Group__5__Impl"
    // InternalEduTest.g:3473:1: rule__TestConfiguration__Group__5__Impl : ( ( rule__TestConfiguration__Group_5__0 )? ) ;
    public final void rule__TestConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3477:1: ( ( ( rule__TestConfiguration__Group_5__0 )? ) )
            // InternalEduTest.g:3478:1: ( ( rule__TestConfiguration__Group_5__0 )? )
            {
            // InternalEduTest.g:3478:1: ( ( rule__TestConfiguration__Group_5__0 )? )
            // InternalEduTest.g:3479:2: ( rule__TestConfiguration__Group_5__0 )?
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_5()); 
            // InternalEduTest.g:3480:2: ( rule__TestConfiguration__Group_5__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==28) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==40) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // InternalEduTest.g:3480:3: rule__TestConfiguration__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TestConfiguration__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTestConfigurationAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__5__Impl"


    // $ANTLR start "rule__TestConfiguration__Group__6"
    // InternalEduTest.g:3488:1: rule__TestConfiguration__Group__6 : rule__TestConfiguration__Group__6__Impl ;
    public final void rule__TestConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3492:1: ( rule__TestConfiguration__Group__6__Impl )
            // InternalEduTest.g:3493:2: rule__TestConfiguration__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__6"


    // $ANTLR start "rule__TestConfiguration__Group__6__Impl"
    // InternalEduTest.g:3499:1: rule__TestConfiguration__Group__6__Impl : ( ( rule__TestConfiguration__Group_6__0 )? ) ;
    public final void rule__TestConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3503:1: ( ( ( rule__TestConfiguration__Group_6__0 )? ) )
            // InternalEduTest.g:3504:1: ( ( rule__TestConfiguration__Group_6__0 )? )
            {
            // InternalEduTest.g:3504:1: ( ( rule__TestConfiguration__Group_6__0 )? )
            // InternalEduTest.g:3505:2: ( rule__TestConfiguration__Group_6__0 )?
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_6()); 
            // InternalEduTest.g:3506:2: ( rule__TestConfiguration__Group_6__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==28) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalEduTest.g:3506:3: rule__TestConfiguration__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TestConfiguration__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTestConfigurationAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group__6__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_4__0"
    // InternalEduTest.g:3515:1: rule__TestConfiguration__Group_4__0 : rule__TestConfiguration__Group_4__0__Impl rule__TestConfiguration__Group_4__1 ;
    public final void rule__TestConfiguration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3519:1: ( rule__TestConfiguration__Group_4__0__Impl rule__TestConfiguration__Group_4__1 )
            // InternalEduTest.g:3520:2: rule__TestConfiguration__Group_4__0__Impl rule__TestConfiguration__Group_4__1
            {
            pushFollow(FOLLOW_18);
            rule__TestConfiguration__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__0"


    // $ANTLR start "rule__TestConfiguration__Group_4__0__Impl"
    // InternalEduTest.g:3527:1: rule__TestConfiguration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3531:1: ( ( ',' ) )
            // InternalEduTest.g:3532:1: ( ',' )
            {
            // InternalEduTest.g:3532:1: ( ',' )
            // InternalEduTest.g:3533:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_4_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__0__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_4__1"
    // InternalEduTest.g:3542:1: rule__TestConfiguration__Group_4__1 : rule__TestConfiguration__Group_4__1__Impl rule__TestConfiguration__Group_4__2 ;
    public final void rule__TestConfiguration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3546:1: ( rule__TestConfiguration__Group_4__1__Impl rule__TestConfiguration__Group_4__2 )
            // InternalEduTest.g:3547:2: rule__TestConfiguration__Group_4__1__Impl rule__TestConfiguration__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__TestConfiguration__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__1"


    // $ANTLR start "rule__TestConfiguration__Group_4__1__Impl"
    // InternalEduTest.g:3554:1: rule__TestConfiguration__Group_4__1__Impl : ( 'mode' ) ;
    public final void rule__TestConfiguration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3558:1: ( ( 'mode' ) )
            // InternalEduTest.g:3559:1: ( 'mode' )
            {
            // InternalEduTest.g:3559:1: ( 'mode' )
            // InternalEduTest.g:3560:2: 'mode'
            {
             before(grammarAccess.getTestConfigurationAccess().getModeKeyword_4_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getModeKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__1__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_4__2"
    // InternalEduTest.g:3569:1: rule__TestConfiguration__Group_4__2 : rule__TestConfiguration__Group_4__2__Impl rule__TestConfiguration__Group_4__3 ;
    public final void rule__TestConfiguration__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3573:1: ( rule__TestConfiguration__Group_4__2__Impl rule__TestConfiguration__Group_4__3 )
            // InternalEduTest.g:3574:2: rule__TestConfiguration__Group_4__2__Impl rule__TestConfiguration__Group_4__3
            {
            pushFollow(FOLLOW_19);
            rule__TestConfiguration__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__2"


    // $ANTLR start "rule__TestConfiguration__Group_4__2__Impl"
    // InternalEduTest.g:3581:1: rule__TestConfiguration__Group_4__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3585:1: ( ( '=' ) )
            // InternalEduTest.g:3586:1: ( '=' )
            {
            // InternalEduTest.g:3586:1: ( '=' )
            // InternalEduTest.g:3587:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_4_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__2__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_4__3"
    // InternalEduTest.g:3596:1: rule__TestConfiguration__Group_4__3 : rule__TestConfiguration__Group_4__3__Impl ;
    public final void rule__TestConfiguration__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3600:1: ( rule__TestConfiguration__Group_4__3__Impl )
            // InternalEduTest.g:3601:2: rule__TestConfiguration__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__3"


    // $ANTLR start "rule__TestConfiguration__Group_4__3__Impl"
    // InternalEduTest.g:3607:1: rule__TestConfiguration__Group_4__3__Impl : ( ( rule__TestConfiguration__ModeAssignment_4_3 ) ) ;
    public final void rule__TestConfiguration__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3611:1: ( ( ( rule__TestConfiguration__ModeAssignment_4_3 ) ) )
            // InternalEduTest.g:3612:1: ( ( rule__TestConfiguration__ModeAssignment_4_3 ) )
            {
            // InternalEduTest.g:3612:1: ( ( rule__TestConfiguration__ModeAssignment_4_3 ) )
            // InternalEduTest.g:3613:2: ( rule__TestConfiguration__ModeAssignment_4_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getModeAssignment_4_3()); 
            // InternalEduTest.g:3614:2: ( rule__TestConfiguration__ModeAssignment_4_3 )
            // InternalEduTest.g:3614:3: rule__TestConfiguration__ModeAssignment_4_3
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__ModeAssignment_4_3();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getModeAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_4__3__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_5__0"
    // InternalEduTest.g:3623:1: rule__TestConfiguration__Group_5__0 : rule__TestConfiguration__Group_5__0__Impl rule__TestConfiguration__Group_5__1 ;
    public final void rule__TestConfiguration__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3627:1: ( rule__TestConfiguration__Group_5__0__Impl rule__TestConfiguration__Group_5__1 )
            // InternalEduTest.g:3628:2: rule__TestConfiguration__Group_5__0__Impl rule__TestConfiguration__Group_5__1
            {
            pushFollow(FOLLOW_20);
            rule__TestConfiguration__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__0"


    // $ANTLR start "rule__TestConfiguration__Group_5__0__Impl"
    // InternalEduTest.g:3635:1: rule__TestConfiguration__Group_5__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3639:1: ( ( ',' ) )
            // InternalEduTest.g:3640:1: ( ',' )
            {
            // InternalEduTest.g:3640:1: ( ',' )
            // InternalEduTest.g:3641:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_5_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__0__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_5__1"
    // InternalEduTest.g:3650:1: rule__TestConfiguration__Group_5__1 : rule__TestConfiguration__Group_5__1__Impl rule__TestConfiguration__Group_5__2 ;
    public final void rule__TestConfiguration__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3654:1: ( rule__TestConfiguration__Group_5__1__Impl rule__TestConfiguration__Group_5__2 )
            // InternalEduTest.g:3655:2: rule__TestConfiguration__Group_5__1__Impl rule__TestConfiguration__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__TestConfiguration__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__1"


    // $ANTLR start "rule__TestConfiguration__Group_5__1__Impl"
    // InternalEduTest.g:3662:1: rule__TestConfiguration__Group_5__1__Impl : ( 'statement' ) ;
    public final void rule__TestConfiguration__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3666:1: ( ( 'statement' ) )
            // InternalEduTest.g:3667:1: ( 'statement' )
            {
            // InternalEduTest.g:3667:1: ( 'statement' )
            // InternalEduTest.g:3668:2: 'statement'
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementKeyword_5_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getStatementKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__1__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_5__2"
    // InternalEduTest.g:3677:1: rule__TestConfiguration__Group_5__2 : rule__TestConfiguration__Group_5__2__Impl rule__TestConfiguration__Group_5__3 ;
    public final void rule__TestConfiguration__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3681:1: ( rule__TestConfiguration__Group_5__2__Impl rule__TestConfiguration__Group_5__3 )
            // InternalEduTest.g:3682:2: rule__TestConfiguration__Group_5__2__Impl rule__TestConfiguration__Group_5__3
            {
            pushFollow(FOLLOW_7);
            rule__TestConfiguration__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__2"


    // $ANTLR start "rule__TestConfiguration__Group_5__2__Impl"
    // InternalEduTest.g:3689:1: rule__TestConfiguration__Group_5__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3693:1: ( ( '=' ) )
            // InternalEduTest.g:3694:1: ( '=' )
            {
            // InternalEduTest.g:3694:1: ( '=' )
            // InternalEduTest.g:3695:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_5_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__2__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_5__3"
    // InternalEduTest.g:3704:1: rule__TestConfiguration__Group_5__3 : rule__TestConfiguration__Group_5__3__Impl rule__TestConfiguration__Group_5__4 ;
    public final void rule__TestConfiguration__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3708:1: ( rule__TestConfiguration__Group_5__3__Impl rule__TestConfiguration__Group_5__4 )
            // InternalEduTest.g:3709:2: rule__TestConfiguration__Group_5__3__Impl rule__TestConfiguration__Group_5__4
            {
            pushFollow(FOLLOW_14);
            rule__TestConfiguration__Group_5__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__3"


    // $ANTLR start "rule__TestConfiguration__Group_5__3__Impl"
    // InternalEduTest.g:3716:1: rule__TestConfiguration__Group_5__3__Impl : ( ( rule__TestConfiguration__StatementAssignment_5_3 ) ) ;
    public final void rule__TestConfiguration__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3720:1: ( ( ( rule__TestConfiguration__StatementAssignment_5_3 ) ) )
            // InternalEduTest.g:3721:1: ( ( rule__TestConfiguration__StatementAssignment_5_3 ) )
            {
            // InternalEduTest.g:3721:1: ( ( rule__TestConfiguration__StatementAssignment_5_3 ) )
            // InternalEduTest.g:3722:2: ( rule__TestConfiguration__StatementAssignment_5_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementAssignment_5_3()); 
            // InternalEduTest.g:3723:2: ( rule__TestConfiguration__StatementAssignment_5_3 )
            // InternalEduTest.g:3723:3: rule__TestConfiguration__StatementAssignment_5_3
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__StatementAssignment_5_3();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getStatementAssignment_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__3__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_5__4"
    // InternalEduTest.g:3731:1: rule__TestConfiguration__Group_5__4 : rule__TestConfiguration__Group_5__4__Impl ;
    public final void rule__TestConfiguration__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3735:1: ( rule__TestConfiguration__Group_5__4__Impl )
            // InternalEduTest.g:3736:2: rule__TestConfiguration__Group_5__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__4"


    // $ANTLR start "rule__TestConfiguration__Group_5__4__Impl"
    // InternalEduTest.g:3742:1: rule__TestConfiguration__Group_5__4__Impl : ( ( rule__TestConfiguration__Group_5_4__0 )* ) ;
    public final void rule__TestConfiguration__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3746:1: ( ( ( rule__TestConfiguration__Group_5_4__0 )* ) )
            // InternalEduTest.g:3747:1: ( ( rule__TestConfiguration__Group_5_4__0 )* )
            {
            // InternalEduTest.g:3747:1: ( ( rule__TestConfiguration__Group_5_4__0 )* )
            // InternalEduTest.g:3748:2: ( rule__TestConfiguration__Group_5_4__0 )*
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_5_4()); 
            // InternalEduTest.g:3749:2: ( rule__TestConfiguration__Group_5_4__0 )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==28) ) {
                    int LA41_1 = input.LA(2);

                    if ( (LA41_1==RULE_ID) ) {
                        alt41=1;
                    }


                }


                switch (alt41) {
            	case 1 :
            	    // InternalEduTest.g:3749:3: rule__TestConfiguration__Group_5_4__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__TestConfiguration__Group_5_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

             after(grammarAccess.getTestConfigurationAccess().getGroup_5_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__4__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_5_4__0"
    // InternalEduTest.g:3758:1: rule__TestConfiguration__Group_5_4__0 : rule__TestConfiguration__Group_5_4__0__Impl rule__TestConfiguration__Group_5_4__1 ;
    public final void rule__TestConfiguration__Group_5_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3762:1: ( rule__TestConfiguration__Group_5_4__0__Impl rule__TestConfiguration__Group_5_4__1 )
            // InternalEduTest.g:3763:2: rule__TestConfiguration__Group_5_4__0__Impl rule__TestConfiguration__Group_5_4__1
            {
            pushFollow(FOLLOW_7);
            rule__TestConfiguration__Group_5_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5_4__0"


    // $ANTLR start "rule__TestConfiguration__Group_5_4__0__Impl"
    // InternalEduTest.g:3770:1: rule__TestConfiguration__Group_5_4__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_5_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3774:1: ( ( ',' ) )
            // InternalEduTest.g:3775:1: ( ',' )
            {
            // InternalEduTest.g:3775:1: ( ',' )
            // InternalEduTest.g:3776:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_5_4_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getCommaKeyword_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5_4__0__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_5_4__1"
    // InternalEduTest.g:3785:1: rule__TestConfiguration__Group_5_4__1 : rule__TestConfiguration__Group_5_4__1__Impl ;
    public final void rule__TestConfiguration__Group_5_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3789:1: ( rule__TestConfiguration__Group_5_4__1__Impl )
            // InternalEduTest.g:3790:2: rule__TestConfiguration__Group_5_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5_4__1"


    // $ANTLR start "rule__TestConfiguration__Group_5_4__1__Impl"
    // InternalEduTest.g:3796:1: rule__TestConfiguration__Group_5_4__1__Impl : ( ( rule__TestConfiguration__StatementAssignment_5_4_1 ) ) ;
    public final void rule__TestConfiguration__Group_5_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3800:1: ( ( ( rule__TestConfiguration__StatementAssignment_5_4_1 ) ) )
            // InternalEduTest.g:3801:1: ( ( rule__TestConfiguration__StatementAssignment_5_4_1 ) )
            {
            // InternalEduTest.g:3801:1: ( ( rule__TestConfiguration__StatementAssignment_5_4_1 ) )
            // InternalEduTest.g:3802:2: ( rule__TestConfiguration__StatementAssignment_5_4_1 )
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementAssignment_5_4_1()); 
            // InternalEduTest.g:3803:2: ( rule__TestConfiguration__StatementAssignment_5_4_1 )
            // InternalEduTest.g:3803:3: rule__TestConfiguration__StatementAssignment_5_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__StatementAssignment_5_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getStatementAssignment_5_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5_4__1__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6__0"
    // InternalEduTest.g:3812:1: rule__TestConfiguration__Group_6__0 : rule__TestConfiguration__Group_6__0__Impl rule__TestConfiguration__Group_6__1 ;
    public final void rule__TestConfiguration__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3816:1: ( rule__TestConfiguration__Group_6__0__Impl rule__TestConfiguration__Group_6__1 )
            // InternalEduTest.g:3817:2: rule__TestConfiguration__Group_6__0__Impl rule__TestConfiguration__Group_6__1
            {
            pushFollow(FOLLOW_21);
            rule__TestConfiguration__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__0"


    // $ANTLR start "rule__TestConfiguration__Group_6__0__Impl"
    // InternalEduTest.g:3824:1: rule__TestConfiguration__Group_6__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3828:1: ( ( ',' ) )
            // InternalEduTest.g:3829:1: ( ',' )
            {
            // InternalEduTest.g:3829:1: ( ',' )
            // InternalEduTest.g:3830:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_6_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__0__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6__1"
    // InternalEduTest.g:3839:1: rule__TestConfiguration__Group_6__1 : rule__TestConfiguration__Group_6__1__Impl rule__TestConfiguration__Group_6__2 ;
    public final void rule__TestConfiguration__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3843:1: ( rule__TestConfiguration__Group_6__1__Impl rule__TestConfiguration__Group_6__2 )
            // InternalEduTest.g:3844:2: rule__TestConfiguration__Group_6__1__Impl rule__TestConfiguration__Group_6__2
            {
            pushFollow(FOLLOW_8);
            rule__TestConfiguration__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__1"


    // $ANTLR start "rule__TestConfiguration__Group_6__1__Impl"
    // InternalEduTest.g:3851:1: rule__TestConfiguration__Group_6__1__Impl : ( 'answers' ) ;
    public final void rule__TestConfiguration__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3855:1: ( ( 'answers' ) )
            // InternalEduTest.g:3856:1: ( 'answers' )
            {
            // InternalEduTest.g:3856:1: ( 'answers' )
            // InternalEduTest.g:3857:2: 'answers'
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersKeyword_6_1()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getAnswersKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__1__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6__2"
    // InternalEduTest.g:3866:1: rule__TestConfiguration__Group_6__2 : rule__TestConfiguration__Group_6__2__Impl rule__TestConfiguration__Group_6__3 ;
    public final void rule__TestConfiguration__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3870:1: ( rule__TestConfiguration__Group_6__2__Impl rule__TestConfiguration__Group_6__3 )
            // InternalEduTest.g:3871:2: rule__TestConfiguration__Group_6__2__Impl rule__TestConfiguration__Group_6__3
            {
            pushFollow(FOLLOW_7);
            rule__TestConfiguration__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__2"


    // $ANTLR start "rule__TestConfiguration__Group_6__2__Impl"
    // InternalEduTest.g:3878:1: rule__TestConfiguration__Group_6__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3882:1: ( ( '=' ) )
            // InternalEduTest.g:3883:1: ( '=' )
            {
            // InternalEduTest.g:3883:1: ( '=' )
            // InternalEduTest.g:3884:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_6_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__2__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6__3"
    // InternalEduTest.g:3893:1: rule__TestConfiguration__Group_6__3 : rule__TestConfiguration__Group_6__3__Impl rule__TestConfiguration__Group_6__4 ;
    public final void rule__TestConfiguration__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3897:1: ( rule__TestConfiguration__Group_6__3__Impl rule__TestConfiguration__Group_6__4 )
            // InternalEduTest.g:3898:2: rule__TestConfiguration__Group_6__3__Impl rule__TestConfiguration__Group_6__4
            {
            pushFollow(FOLLOW_14);
            rule__TestConfiguration__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__3"


    // $ANTLR start "rule__TestConfiguration__Group_6__3__Impl"
    // InternalEduTest.g:3905:1: rule__TestConfiguration__Group_6__3__Impl : ( ( rule__TestConfiguration__AnswersAssignment_6_3 ) ) ;
    public final void rule__TestConfiguration__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3909:1: ( ( ( rule__TestConfiguration__AnswersAssignment_6_3 ) ) )
            // InternalEduTest.g:3910:1: ( ( rule__TestConfiguration__AnswersAssignment_6_3 ) )
            {
            // InternalEduTest.g:3910:1: ( ( rule__TestConfiguration__AnswersAssignment_6_3 ) )
            // InternalEduTest.g:3911:2: ( rule__TestConfiguration__AnswersAssignment_6_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersAssignment_6_3()); 
            // InternalEduTest.g:3912:2: ( rule__TestConfiguration__AnswersAssignment_6_3 )
            // InternalEduTest.g:3912:3: rule__TestConfiguration__AnswersAssignment_6_3
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__AnswersAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getAnswersAssignment_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__3__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6__4"
    // InternalEduTest.g:3920:1: rule__TestConfiguration__Group_6__4 : rule__TestConfiguration__Group_6__4__Impl ;
    public final void rule__TestConfiguration__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3924:1: ( rule__TestConfiguration__Group_6__4__Impl )
            // InternalEduTest.g:3925:2: rule__TestConfiguration__Group_6__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__4"


    // $ANTLR start "rule__TestConfiguration__Group_6__4__Impl"
    // InternalEduTest.g:3931:1: rule__TestConfiguration__Group_6__4__Impl : ( ( rule__TestConfiguration__Group_6_4__0 )* ) ;
    public final void rule__TestConfiguration__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3935:1: ( ( ( rule__TestConfiguration__Group_6_4__0 )* ) )
            // InternalEduTest.g:3936:1: ( ( rule__TestConfiguration__Group_6_4__0 )* )
            {
            // InternalEduTest.g:3936:1: ( ( rule__TestConfiguration__Group_6_4__0 )* )
            // InternalEduTest.g:3937:2: ( rule__TestConfiguration__Group_6_4__0 )*
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_6_4()); 
            // InternalEduTest.g:3938:2: ( rule__TestConfiguration__Group_6_4__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==28) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalEduTest.g:3938:3: rule__TestConfiguration__Group_6_4__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__TestConfiguration__Group_6_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getTestConfigurationAccess().getGroup_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__4__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6_4__0"
    // InternalEduTest.g:3947:1: rule__TestConfiguration__Group_6_4__0 : rule__TestConfiguration__Group_6_4__0__Impl rule__TestConfiguration__Group_6_4__1 ;
    public final void rule__TestConfiguration__Group_6_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3951:1: ( rule__TestConfiguration__Group_6_4__0__Impl rule__TestConfiguration__Group_6_4__1 )
            // InternalEduTest.g:3952:2: rule__TestConfiguration__Group_6_4__0__Impl rule__TestConfiguration__Group_6_4__1
            {
            pushFollow(FOLLOW_7);
            rule__TestConfiguration__Group_6_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6_4__0"


    // $ANTLR start "rule__TestConfiguration__Group_6_4__0__Impl"
    // InternalEduTest.g:3959:1: rule__TestConfiguration__Group_6_4__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_6_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3963:1: ( ( ',' ) )
            // InternalEduTest.g:3964:1: ( ',' )
            {
            // InternalEduTest.g:3964:1: ( ',' )
            // InternalEduTest.g:3965:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_6_4_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getCommaKeyword_6_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6_4__0__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6_4__1"
    // InternalEduTest.g:3974:1: rule__TestConfiguration__Group_6_4__1 : rule__TestConfiguration__Group_6_4__1__Impl ;
    public final void rule__TestConfiguration__Group_6_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3978:1: ( rule__TestConfiguration__Group_6_4__1__Impl )
            // InternalEduTest.g:3979:2: rule__TestConfiguration__Group_6_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6_4__1"


    // $ANTLR start "rule__TestConfiguration__Group_6_4__1__Impl"
    // InternalEduTest.g:3985:1: rule__TestConfiguration__Group_6_4__1__Impl : ( ( rule__TestConfiguration__AnswersAssignment_6_4_1 ) ) ;
    public final void rule__TestConfiguration__Group_6_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3989:1: ( ( ( rule__TestConfiguration__AnswersAssignment_6_4_1 ) ) )
            // InternalEduTest.g:3990:1: ( ( rule__TestConfiguration__AnswersAssignment_6_4_1 ) )
            {
            // InternalEduTest.g:3990:1: ( ( rule__TestConfiguration__AnswersAssignment_6_4_1 ) )
            // InternalEduTest.g:3991:2: ( rule__TestConfiguration__AnswersAssignment_6_4_1 )
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersAssignment_6_4_1()); 
            // InternalEduTest.g:3992:2: ( rule__TestConfiguration__AnswersAssignment_6_4_1 )
            // InternalEduTest.g:3992:3: rule__TestConfiguration__AnswersAssignment_6_4_1
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__AnswersAssignment_6_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getAnswersAssignment_6_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6_4__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__0"
    // InternalEduTest.g:4001:1: rule__MultiChoiceEmConfig__Group__0 : rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 ;
    public final void rule__MultiChoiceEmConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4005:1: ( rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 )
            // InternalEduTest.g:4006:2: rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:4013:1: rule__MultiChoiceEmConfig__Group__0__Impl : ( () ) ;
    public final void rule__MultiChoiceEmConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4017:1: ( ( () ) )
            // InternalEduTest.g:4018:1: ( () )
            {
            // InternalEduTest.g:4018:1: ( () )
            // InternalEduTest.g:4019:2: ()
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0()); 
            // InternalEduTest.g:4020:2: ()
            // InternalEduTest.g:4020:3: 
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
    // InternalEduTest.g:4028:1: rule__MultiChoiceEmConfig__Group__1 : rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 ;
    public final void rule__MultiChoiceEmConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4032:1: ( rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 )
            // InternalEduTest.g:4033:2: rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:4040:1: rule__MultiChoiceEmConfig__Group__1__Impl : ( 'retry' ) ;
    public final void rule__MultiChoiceEmConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4044:1: ( ( 'retry' ) )
            // InternalEduTest.g:4045:1: ( 'retry' )
            {
            // InternalEduTest.g:4045:1: ( 'retry' )
            // InternalEduTest.g:4046:2: 'retry'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalEduTest.g:4055:1: rule__MultiChoiceEmConfig__Group__2 : rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 ;
    public final void rule__MultiChoiceEmConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4059:1: ( rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 )
            // InternalEduTest.g:4060:2: rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3
            {
            pushFollow(FOLLOW_17);
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
    // InternalEduTest.g:4067:1: rule__MultiChoiceEmConfig__Group__2__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4071:1: ( ( '=' ) )
            // InternalEduTest.g:4072:1: ( '=' )
            {
            // InternalEduTest.g:4072:1: ( '=' )
            // InternalEduTest.g:4073:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:4082:1: rule__MultiChoiceEmConfig__Group__3 : rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 ;
    public final void rule__MultiChoiceEmConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4086:1: ( rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 )
            // InternalEduTest.g:4087:2: rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:4094:1: rule__MultiChoiceEmConfig__Group__3__Impl : ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4098:1: ( ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) )
            // InternalEduTest.g:4099:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:4099:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            // InternalEduTest.g:4100:2: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:4101:2: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            // InternalEduTest.g:4101:3: rule__MultiChoiceEmConfig__RetryAssignment_3
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
    // InternalEduTest.g:4109:1: rule__MultiChoiceEmConfig__Group__4 : rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 ;
    public final void rule__MultiChoiceEmConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4113:1: ( rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 )
            // InternalEduTest.g:4114:2: rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5
            {
            pushFollow(FOLLOW_22);
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
    // InternalEduTest.g:4121:1: rule__MultiChoiceEmConfig__Group__4__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4125:1: ( ( ',' ) )
            // InternalEduTest.g:4126:1: ( ',' )
            {
            // InternalEduTest.g:4126:1: ( ',' )
            // InternalEduTest.g:4127:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_4()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:4136:1: rule__MultiChoiceEmConfig__Group__5 : rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 ;
    public final void rule__MultiChoiceEmConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4140:1: ( rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 )
            // InternalEduTest.g:4141:2: rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:4148:1: rule__MultiChoiceEmConfig__Group__5__Impl : ( 'weighted' ) ;
    public final void rule__MultiChoiceEmConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4152:1: ( ( 'weighted' ) )
            // InternalEduTest.g:4153:1: ( 'weighted' )
            {
            // InternalEduTest.g:4153:1: ( 'weighted' )
            // InternalEduTest.g:4154:2: 'weighted'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5()); 
            match(input,42,FOLLOW_2); 
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
    // InternalEduTest.g:4163:1: rule__MultiChoiceEmConfig__Group__6 : rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 ;
    public final void rule__MultiChoiceEmConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4167:1: ( rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 )
            // InternalEduTest.g:4168:2: rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7
            {
            pushFollow(FOLLOW_17);
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
    // InternalEduTest.g:4175:1: rule__MultiChoiceEmConfig__Group__6__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4179:1: ( ( '=' ) )
            // InternalEduTest.g:4180:1: ( '=' )
            {
            // InternalEduTest.g:4180:1: ( '=' )
            // InternalEduTest.g:4181:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:4190:1: rule__MultiChoiceEmConfig__Group__7 : rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 ;
    public final void rule__MultiChoiceEmConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4194:1: ( rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 )
            // InternalEduTest.g:4195:2: rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:4202:1: rule__MultiChoiceEmConfig__Group__7__Impl : ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4206:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) )
            // InternalEduTest.g:4207:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            {
            // InternalEduTest.g:4207:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            // InternalEduTest.g:4208:2: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAssignment_7()); 
            // InternalEduTest.g:4209:2: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            // InternalEduTest.g:4209:3: rule__MultiChoiceEmConfig__WeightedAssignment_7
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
    // InternalEduTest.g:4217:1: rule__MultiChoiceEmConfig__Group__8 : rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 ;
    public final void rule__MultiChoiceEmConfig__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4221:1: ( rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 )
            // InternalEduTest.g:4222:2: rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9
            {
            pushFollow(FOLLOW_23);
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
    // InternalEduTest.g:4229:1: rule__MultiChoiceEmConfig__Group__8__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4233:1: ( ( ',' ) )
            // InternalEduTest.g:4234:1: ( ',' )
            {
            // InternalEduTest.g:4234:1: ( ',' )
            // InternalEduTest.g:4235:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_8()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:4244:1: rule__MultiChoiceEmConfig__Group__9 : rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 ;
    public final void rule__MultiChoiceEmConfig__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4248:1: ( rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 )
            // InternalEduTest.g:4249:2: rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:4256:1: rule__MultiChoiceEmConfig__Group__9__Impl : ( 'penalty' ) ;
    public final void rule__MultiChoiceEmConfig__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4260:1: ( ( 'penalty' ) )
            // InternalEduTest.g:4261:1: ( 'penalty' )
            {
            // InternalEduTest.g:4261:1: ( 'penalty' )
            // InternalEduTest.g:4262:2: 'penalty'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9()); 
            match(input,43,FOLLOW_2); 
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
    // InternalEduTest.g:4271:1: rule__MultiChoiceEmConfig__Group__10 : rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 ;
    public final void rule__MultiChoiceEmConfig__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4275:1: ( rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 )
            // InternalEduTest.g:4276:2: rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11
            {
            pushFollow(FOLLOW_24);
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
    // InternalEduTest.g:4283:1: rule__MultiChoiceEmConfig__Group__10__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4287:1: ( ( '=' ) )
            // InternalEduTest.g:4288:1: ( '=' )
            {
            // InternalEduTest.g:4288:1: ( '=' )
            // InternalEduTest.g:4289:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:4298:1: rule__MultiChoiceEmConfig__Group__11 : rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 ;
    public final void rule__MultiChoiceEmConfig__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4302:1: ( rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 )
            // InternalEduTest.g:4303:2: rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:4310:1: rule__MultiChoiceEmConfig__Group__11__Impl : ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4314:1: ( ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) )
            // InternalEduTest.g:4315:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            {
            // InternalEduTest.g:4315:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            // InternalEduTest.g:4316:2: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyAssignment_11()); 
            // InternalEduTest.g:4317:2: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            // InternalEduTest.g:4317:3: rule__MultiChoiceEmConfig__PenaltyAssignment_11
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
    // InternalEduTest.g:4325:1: rule__MultiChoiceEmConfig__Group__12 : rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 ;
    public final void rule__MultiChoiceEmConfig__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4329:1: ( rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 )
            // InternalEduTest.g:4330:2: rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13
            {
            pushFollow(FOLLOW_25);
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
    // InternalEduTest.g:4337:1: rule__MultiChoiceEmConfig__Group__12__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4341:1: ( ( ',' ) )
            // InternalEduTest.g:4342:1: ( ',' )
            {
            // InternalEduTest.g:4342:1: ( ',' )
            // InternalEduTest.g:4343:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_12()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:4352:1: rule__MultiChoiceEmConfig__Group__13 : rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 ;
    public final void rule__MultiChoiceEmConfig__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4356:1: ( rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 )
            // InternalEduTest.g:4357:2: rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:4364:1: rule__MultiChoiceEmConfig__Group__13__Impl : ( 'order' ) ;
    public final void rule__MultiChoiceEmConfig__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4368:1: ( ( 'order' ) )
            // InternalEduTest.g:4369:1: ( 'order' )
            {
            // InternalEduTest.g:4369:1: ( 'order' )
            // InternalEduTest.g:4370:2: 'order'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13()); 
            match(input,44,FOLLOW_2); 
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
    // InternalEduTest.g:4379:1: rule__MultiChoiceEmConfig__Group__14 : rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 ;
    public final void rule__MultiChoiceEmConfig__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4383:1: ( rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 )
            // InternalEduTest.g:4384:2: rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15
            {
            pushFollow(FOLLOW_26);
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
    // InternalEduTest.g:4391:1: rule__MultiChoiceEmConfig__Group__14__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4395:1: ( ( '=' ) )
            // InternalEduTest.g:4396:1: ( '=' )
            {
            // InternalEduTest.g:4396:1: ( '=' )
            // InternalEduTest.g:4397:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:4406:1: rule__MultiChoiceEmConfig__Group__15 : rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 ;
    public final void rule__MultiChoiceEmConfig__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4410:1: ( rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 )
            // InternalEduTest.g:4411:2: rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:4418:1: rule__MultiChoiceEmConfig__Group__15__Impl : ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4422:1: ( ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) )
            // InternalEduTest.g:4423:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            {
            // InternalEduTest.g:4423:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            // InternalEduTest.g:4424:2: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderAssignment_15()); 
            // InternalEduTest.g:4425:2: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            // InternalEduTest.g:4425:3: rule__MultiChoiceEmConfig__OrderAssignment_15
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
    // InternalEduTest.g:4433:1: rule__MultiChoiceEmConfig__Group__16 : rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 ;
    public final void rule__MultiChoiceEmConfig__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4437:1: ( rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 )
            // InternalEduTest.g:4438:2: rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17
            {
            pushFollow(FOLLOW_18);
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
    // InternalEduTest.g:4445:1: rule__MultiChoiceEmConfig__Group__16__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4449:1: ( ( ',' ) )
            // InternalEduTest.g:4450:1: ( ',' )
            {
            // InternalEduTest.g:4450:1: ( ',' )
            // InternalEduTest.g:4451:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_16()); 
            match(input,28,FOLLOW_2); 
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
    // InternalEduTest.g:4460:1: rule__MultiChoiceEmConfig__Group__17 : rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 ;
    public final void rule__MultiChoiceEmConfig__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4464:1: ( rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 )
            // InternalEduTest.g:4465:2: rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:4472:1: rule__MultiChoiceEmConfig__Group__17__Impl : ( 'mode' ) ;
    public final void rule__MultiChoiceEmConfig__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4476:1: ( ( 'mode' ) )
            // InternalEduTest.g:4477:1: ( 'mode' )
            {
            // InternalEduTest.g:4477:1: ( 'mode' )
            // InternalEduTest.g:4478:2: 'mode'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17()); 
            match(input,39,FOLLOW_2); 
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
    // InternalEduTest.g:4487:1: rule__MultiChoiceEmConfig__Group__18 : rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 ;
    public final void rule__MultiChoiceEmConfig__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4491:1: ( rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 )
            // InternalEduTest.g:4492:2: rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19
            {
            pushFollow(FOLLOW_19);
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
    // InternalEduTest.g:4499:1: rule__MultiChoiceEmConfig__Group__18__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4503:1: ( ( '=' ) )
            // InternalEduTest.g:4504:1: ( '=' )
            {
            // InternalEduTest.g:4504:1: ( '=' )
            // InternalEduTest.g:4505:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:4514:1: rule__MultiChoiceEmConfig__Group__19 : rule__MultiChoiceEmConfig__Group__19__Impl rule__MultiChoiceEmConfig__Group__20 ;
    public final void rule__MultiChoiceEmConfig__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4518:1: ( rule__MultiChoiceEmConfig__Group__19__Impl rule__MultiChoiceEmConfig__Group__20 )
            // InternalEduTest.g:4519:2: rule__MultiChoiceEmConfig__Group__19__Impl rule__MultiChoiceEmConfig__Group__20
            {
            pushFollow(FOLLOW_14);
            rule__MultiChoiceEmConfig__Group__19__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__20();

            state._fsp--;


            }

        }
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
    // InternalEduTest.g:4526:1: rule__MultiChoiceEmConfig__Group__19__Impl : ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4530:1: ( ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) )
            // InternalEduTest.g:4531:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            {
            // InternalEduTest.g:4531:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            // InternalEduTest.g:4532:2: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeAssignment_19()); 
            // InternalEduTest.g:4533:2: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            // InternalEduTest.g:4533:3: rule__MultiChoiceEmConfig__ModeAssignment_19
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


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__20"
    // InternalEduTest.g:4541:1: rule__MultiChoiceEmConfig__Group__20 : rule__MultiChoiceEmConfig__Group__20__Impl rule__MultiChoiceEmConfig__Group__21 ;
    public final void rule__MultiChoiceEmConfig__Group__20() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4545:1: ( rule__MultiChoiceEmConfig__Group__20__Impl rule__MultiChoiceEmConfig__Group__21 )
            // InternalEduTest.g:4546:2: rule__MultiChoiceEmConfig__Group__20__Impl rule__MultiChoiceEmConfig__Group__21
            {
            pushFollow(FOLLOW_14);
            rule__MultiChoiceEmConfig__Group__20__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__21();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__20"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__20__Impl"
    // InternalEduTest.g:4553:1: rule__MultiChoiceEmConfig__Group__20__Impl : ( ( rule__MultiChoiceEmConfig__Group_20__0 )? ) ;
    public final void rule__MultiChoiceEmConfig__Group__20__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4557:1: ( ( ( rule__MultiChoiceEmConfig__Group_20__0 )? ) )
            // InternalEduTest.g:4558:1: ( ( rule__MultiChoiceEmConfig__Group_20__0 )? )
            {
            // InternalEduTest.g:4558:1: ( ( rule__MultiChoiceEmConfig__Group_20__0 )? )
            // InternalEduTest.g:4559:2: ( rule__MultiChoiceEmConfig__Group_20__0 )?
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_20()); 
            // InternalEduTest.g:4560:2: ( rule__MultiChoiceEmConfig__Group_20__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==28) ) {
                int LA43_1 = input.LA(2);

                if ( (LA43_1==40) ) {
                    alt43=1;
                }
            }
            switch (alt43) {
                case 1 :
                    // InternalEduTest.g:4560:3: rule__MultiChoiceEmConfig__Group_20__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiChoiceEmConfig__Group_20__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_20()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__20__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__21"
    // InternalEduTest.g:4568:1: rule__MultiChoiceEmConfig__Group__21 : rule__MultiChoiceEmConfig__Group__21__Impl ;
    public final void rule__MultiChoiceEmConfig__Group__21() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4572:1: ( rule__MultiChoiceEmConfig__Group__21__Impl )
            // InternalEduTest.g:4573:2: rule__MultiChoiceEmConfig__Group__21__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group__21__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__21"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__21__Impl"
    // InternalEduTest.g:4579:1: rule__MultiChoiceEmConfig__Group__21__Impl : ( ( rule__MultiChoiceEmConfig__Group_21__0 )? ) ;
    public final void rule__MultiChoiceEmConfig__Group__21__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4583:1: ( ( ( rule__MultiChoiceEmConfig__Group_21__0 )? ) )
            // InternalEduTest.g:4584:1: ( ( rule__MultiChoiceEmConfig__Group_21__0 )? )
            {
            // InternalEduTest.g:4584:1: ( ( rule__MultiChoiceEmConfig__Group_21__0 )? )
            // InternalEduTest.g:4585:2: ( rule__MultiChoiceEmConfig__Group_21__0 )?
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_21()); 
            // InternalEduTest.g:4586:2: ( rule__MultiChoiceEmConfig__Group_21__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==28) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalEduTest.g:4586:3: rule__MultiChoiceEmConfig__Group_21__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MultiChoiceEmConfig__Group_21__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_21()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group__21__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__0"
    // InternalEduTest.g:4595:1: rule__MultiChoiceEmConfig__Group_20__0 : rule__MultiChoiceEmConfig__Group_20__0__Impl rule__MultiChoiceEmConfig__Group_20__1 ;
    public final void rule__MultiChoiceEmConfig__Group_20__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4599:1: ( rule__MultiChoiceEmConfig__Group_20__0__Impl rule__MultiChoiceEmConfig__Group_20__1 )
            // InternalEduTest.g:4600:2: rule__MultiChoiceEmConfig__Group_20__0__Impl rule__MultiChoiceEmConfig__Group_20__1
            {
            pushFollow(FOLLOW_20);
            rule__MultiChoiceEmConfig__Group_20__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_20__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__0"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__0__Impl"
    // InternalEduTest.g:4607:1: rule__MultiChoiceEmConfig__Group_20__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group_20__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4611:1: ( ( ',' ) )
            // InternalEduTest.g:4612:1: ( ',' )
            {
            // InternalEduTest.g:4612:1: ( ',' )
            // InternalEduTest.g:4613:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_20_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_20_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__1"
    // InternalEduTest.g:4622:1: rule__MultiChoiceEmConfig__Group_20__1 : rule__MultiChoiceEmConfig__Group_20__1__Impl rule__MultiChoiceEmConfig__Group_20__2 ;
    public final void rule__MultiChoiceEmConfig__Group_20__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4626:1: ( rule__MultiChoiceEmConfig__Group_20__1__Impl rule__MultiChoiceEmConfig__Group_20__2 )
            // InternalEduTest.g:4627:2: rule__MultiChoiceEmConfig__Group_20__1__Impl rule__MultiChoiceEmConfig__Group_20__2
            {
            pushFollow(FOLLOW_8);
            rule__MultiChoiceEmConfig__Group_20__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_20__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__1"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__1__Impl"
    // InternalEduTest.g:4634:1: rule__MultiChoiceEmConfig__Group_20__1__Impl : ( 'statement' ) ;
    public final void rule__MultiChoiceEmConfig__Group_20__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4638:1: ( ( 'statement' ) )
            // InternalEduTest.g:4639:1: ( 'statement' )
            {
            // InternalEduTest.g:4639:1: ( 'statement' )
            // InternalEduTest.g:4640:2: 'statement'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getStatementKeyword_20_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getStatementKeyword_20_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__2"
    // InternalEduTest.g:4649:1: rule__MultiChoiceEmConfig__Group_20__2 : rule__MultiChoiceEmConfig__Group_20__2__Impl rule__MultiChoiceEmConfig__Group_20__3 ;
    public final void rule__MultiChoiceEmConfig__Group_20__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4653:1: ( rule__MultiChoiceEmConfig__Group_20__2__Impl rule__MultiChoiceEmConfig__Group_20__3 )
            // InternalEduTest.g:4654:2: rule__MultiChoiceEmConfig__Group_20__2__Impl rule__MultiChoiceEmConfig__Group_20__3
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceEmConfig__Group_20__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_20__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__2"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__2__Impl"
    // InternalEduTest.g:4661:1: rule__MultiChoiceEmConfig__Group_20__2__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group_20__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4665:1: ( ( '=' ) )
            // InternalEduTest.g:4666:1: ( '=' )
            {
            // InternalEduTest.g:4666:1: ( '=' )
            // InternalEduTest.g:4667:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_20_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_20_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__2__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__3"
    // InternalEduTest.g:4676:1: rule__MultiChoiceEmConfig__Group_20__3 : rule__MultiChoiceEmConfig__Group_20__3__Impl rule__MultiChoiceEmConfig__Group_20__4 ;
    public final void rule__MultiChoiceEmConfig__Group_20__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4680:1: ( rule__MultiChoiceEmConfig__Group_20__3__Impl rule__MultiChoiceEmConfig__Group_20__4 )
            // InternalEduTest.g:4681:2: rule__MultiChoiceEmConfig__Group_20__3__Impl rule__MultiChoiceEmConfig__Group_20__4
            {
            pushFollow(FOLLOW_14);
            rule__MultiChoiceEmConfig__Group_20__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_20__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__3"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__3__Impl"
    // InternalEduTest.g:4688:1: rule__MultiChoiceEmConfig__Group_20__3__Impl : ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_3 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group_20__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4692:1: ( ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_3 ) ) )
            // InternalEduTest.g:4693:1: ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_3 ) )
            {
            // InternalEduTest.g:4693:1: ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_3 ) )
            // InternalEduTest.g:4694:2: ( rule__MultiChoiceEmConfig__StatementAssignment_20_3 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getStatementAssignment_20_3()); 
            // InternalEduTest.g:4695:2: ( rule__MultiChoiceEmConfig__StatementAssignment_20_3 )
            // InternalEduTest.g:4695:3: rule__MultiChoiceEmConfig__StatementAssignment_20_3
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__StatementAssignment_20_3();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getStatementAssignment_20_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__3__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__4"
    // InternalEduTest.g:4703:1: rule__MultiChoiceEmConfig__Group_20__4 : rule__MultiChoiceEmConfig__Group_20__4__Impl ;
    public final void rule__MultiChoiceEmConfig__Group_20__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4707:1: ( rule__MultiChoiceEmConfig__Group_20__4__Impl )
            // InternalEduTest.g:4708:2: rule__MultiChoiceEmConfig__Group_20__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_20__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__4"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20__4__Impl"
    // InternalEduTest.g:4714:1: rule__MultiChoiceEmConfig__Group_20__4__Impl : ( ( rule__MultiChoiceEmConfig__Group_20_4__0 )* ) ;
    public final void rule__MultiChoiceEmConfig__Group_20__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4718:1: ( ( ( rule__MultiChoiceEmConfig__Group_20_4__0 )* ) )
            // InternalEduTest.g:4719:1: ( ( rule__MultiChoiceEmConfig__Group_20_4__0 )* )
            {
            // InternalEduTest.g:4719:1: ( ( rule__MultiChoiceEmConfig__Group_20_4__0 )* )
            // InternalEduTest.g:4720:2: ( rule__MultiChoiceEmConfig__Group_20_4__0 )*
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_20_4()); 
            // InternalEduTest.g:4721:2: ( rule__MultiChoiceEmConfig__Group_20_4__0 )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==28) ) {
                    int LA45_1 = input.LA(2);

                    if ( (LA45_1==RULE_ID) ) {
                        alt45=1;
                    }


                }


                switch (alt45) {
            	case 1 :
            	    // InternalEduTest.g:4721:3: rule__MultiChoiceEmConfig__Group_20_4__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MultiChoiceEmConfig__Group_20_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_20_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20__4__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20_4__0"
    // InternalEduTest.g:4730:1: rule__MultiChoiceEmConfig__Group_20_4__0 : rule__MultiChoiceEmConfig__Group_20_4__0__Impl rule__MultiChoiceEmConfig__Group_20_4__1 ;
    public final void rule__MultiChoiceEmConfig__Group_20_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4734:1: ( rule__MultiChoiceEmConfig__Group_20_4__0__Impl rule__MultiChoiceEmConfig__Group_20_4__1 )
            // InternalEduTest.g:4735:2: rule__MultiChoiceEmConfig__Group_20_4__0__Impl rule__MultiChoiceEmConfig__Group_20_4__1
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceEmConfig__Group_20_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_20_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20_4__0"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20_4__0__Impl"
    // InternalEduTest.g:4742:1: rule__MultiChoiceEmConfig__Group_20_4__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group_20_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4746:1: ( ( ',' ) )
            // InternalEduTest.g:4747:1: ( ',' )
            {
            // InternalEduTest.g:4747:1: ( ',' )
            // InternalEduTest.g:4748:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_20_4_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_20_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20_4__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20_4__1"
    // InternalEduTest.g:4757:1: rule__MultiChoiceEmConfig__Group_20_4__1 : rule__MultiChoiceEmConfig__Group_20_4__1__Impl ;
    public final void rule__MultiChoiceEmConfig__Group_20_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4761:1: ( rule__MultiChoiceEmConfig__Group_20_4__1__Impl )
            // InternalEduTest.g:4762:2: rule__MultiChoiceEmConfig__Group_20_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_20_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20_4__1"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_20_4__1__Impl"
    // InternalEduTest.g:4768:1: rule__MultiChoiceEmConfig__Group_20_4__1__Impl : ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_4_1 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group_20_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4772:1: ( ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_4_1 ) ) )
            // InternalEduTest.g:4773:1: ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_4_1 ) )
            {
            // InternalEduTest.g:4773:1: ( ( rule__MultiChoiceEmConfig__StatementAssignment_20_4_1 ) )
            // InternalEduTest.g:4774:2: ( rule__MultiChoiceEmConfig__StatementAssignment_20_4_1 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getStatementAssignment_20_4_1()); 
            // InternalEduTest.g:4775:2: ( rule__MultiChoiceEmConfig__StatementAssignment_20_4_1 )
            // InternalEduTest.g:4775:3: rule__MultiChoiceEmConfig__StatementAssignment_20_4_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__StatementAssignment_20_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getStatementAssignment_20_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_20_4__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__0"
    // InternalEduTest.g:4784:1: rule__MultiChoiceEmConfig__Group_21__0 : rule__MultiChoiceEmConfig__Group_21__0__Impl rule__MultiChoiceEmConfig__Group_21__1 ;
    public final void rule__MultiChoiceEmConfig__Group_21__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4788:1: ( rule__MultiChoiceEmConfig__Group_21__0__Impl rule__MultiChoiceEmConfig__Group_21__1 )
            // InternalEduTest.g:4789:2: rule__MultiChoiceEmConfig__Group_21__0__Impl rule__MultiChoiceEmConfig__Group_21__1
            {
            pushFollow(FOLLOW_21);
            rule__MultiChoiceEmConfig__Group_21__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_21__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__0"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__0__Impl"
    // InternalEduTest.g:4796:1: rule__MultiChoiceEmConfig__Group_21__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group_21__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4800:1: ( ( ',' ) )
            // InternalEduTest.g:4801:1: ( ',' )
            {
            // InternalEduTest.g:4801:1: ( ',' )
            // InternalEduTest.g:4802:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_21_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_21_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__1"
    // InternalEduTest.g:4811:1: rule__MultiChoiceEmConfig__Group_21__1 : rule__MultiChoiceEmConfig__Group_21__1__Impl rule__MultiChoiceEmConfig__Group_21__2 ;
    public final void rule__MultiChoiceEmConfig__Group_21__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4815:1: ( rule__MultiChoiceEmConfig__Group_21__1__Impl rule__MultiChoiceEmConfig__Group_21__2 )
            // InternalEduTest.g:4816:2: rule__MultiChoiceEmConfig__Group_21__1__Impl rule__MultiChoiceEmConfig__Group_21__2
            {
            pushFollow(FOLLOW_8);
            rule__MultiChoiceEmConfig__Group_21__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_21__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__1"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__1__Impl"
    // InternalEduTest.g:4823:1: rule__MultiChoiceEmConfig__Group_21__1__Impl : ( 'answers' ) ;
    public final void rule__MultiChoiceEmConfig__Group_21__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4827:1: ( ( 'answers' ) )
            // InternalEduTest.g:4828:1: ( 'answers' )
            {
            // InternalEduTest.g:4828:1: ( 'answers' )
            // InternalEduTest.g:4829:2: 'answers'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersKeyword_21_1()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersKeyword_21_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__1__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__2"
    // InternalEduTest.g:4838:1: rule__MultiChoiceEmConfig__Group_21__2 : rule__MultiChoiceEmConfig__Group_21__2__Impl rule__MultiChoiceEmConfig__Group_21__3 ;
    public final void rule__MultiChoiceEmConfig__Group_21__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4842:1: ( rule__MultiChoiceEmConfig__Group_21__2__Impl rule__MultiChoiceEmConfig__Group_21__3 )
            // InternalEduTest.g:4843:2: rule__MultiChoiceEmConfig__Group_21__2__Impl rule__MultiChoiceEmConfig__Group_21__3
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceEmConfig__Group_21__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_21__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__2"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__2__Impl"
    // InternalEduTest.g:4850:1: rule__MultiChoiceEmConfig__Group_21__2__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group_21__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4854:1: ( ( '=' ) )
            // InternalEduTest.g:4855:1: ( '=' )
            {
            // InternalEduTest.g:4855:1: ( '=' )
            // InternalEduTest.g:4856:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_21_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_21_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__2__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__3"
    // InternalEduTest.g:4865:1: rule__MultiChoiceEmConfig__Group_21__3 : rule__MultiChoiceEmConfig__Group_21__3__Impl rule__MultiChoiceEmConfig__Group_21__4 ;
    public final void rule__MultiChoiceEmConfig__Group_21__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4869:1: ( rule__MultiChoiceEmConfig__Group_21__3__Impl rule__MultiChoiceEmConfig__Group_21__4 )
            // InternalEduTest.g:4870:2: rule__MultiChoiceEmConfig__Group_21__3__Impl rule__MultiChoiceEmConfig__Group_21__4
            {
            pushFollow(FOLLOW_14);
            rule__MultiChoiceEmConfig__Group_21__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_21__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__3"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__3__Impl"
    // InternalEduTest.g:4877:1: rule__MultiChoiceEmConfig__Group_21__3__Impl : ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_3 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group_21__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4881:1: ( ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_3 ) ) )
            // InternalEduTest.g:4882:1: ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_3 ) )
            {
            // InternalEduTest.g:4882:1: ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_3 ) )
            // InternalEduTest.g:4883:2: ( rule__MultiChoiceEmConfig__AnswersAssignment_21_3 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersAssignment_21_3()); 
            // InternalEduTest.g:4884:2: ( rule__MultiChoiceEmConfig__AnswersAssignment_21_3 )
            // InternalEduTest.g:4884:3: rule__MultiChoiceEmConfig__AnswersAssignment_21_3
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__AnswersAssignment_21_3();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersAssignment_21_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__3__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__4"
    // InternalEduTest.g:4892:1: rule__MultiChoiceEmConfig__Group_21__4 : rule__MultiChoiceEmConfig__Group_21__4__Impl ;
    public final void rule__MultiChoiceEmConfig__Group_21__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4896:1: ( rule__MultiChoiceEmConfig__Group_21__4__Impl )
            // InternalEduTest.g:4897:2: rule__MultiChoiceEmConfig__Group_21__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_21__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__4"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21__4__Impl"
    // InternalEduTest.g:4903:1: rule__MultiChoiceEmConfig__Group_21__4__Impl : ( ( rule__MultiChoiceEmConfig__Group_21_4__0 )* ) ;
    public final void rule__MultiChoiceEmConfig__Group_21__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4907:1: ( ( ( rule__MultiChoiceEmConfig__Group_21_4__0 )* ) )
            // InternalEduTest.g:4908:1: ( ( rule__MultiChoiceEmConfig__Group_21_4__0 )* )
            {
            // InternalEduTest.g:4908:1: ( ( rule__MultiChoiceEmConfig__Group_21_4__0 )* )
            // InternalEduTest.g:4909:2: ( rule__MultiChoiceEmConfig__Group_21_4__0 )*
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_21_4()); 
            // InternalEduTest.g:4910:2: ( rule__MultiChoiceEmConfig__Group_21_4__0 )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==28) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalEduTest.g:4910:3: rule__MultiChoiceEmConfig__Group_21_4__0
            	    {
            	    pushFollow(FOLLOW_15);
            	    rule__MultiChoiceEmConfig__Group_21_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

             after(grammarAccess.getMultiChoiceEmConfigAccess().getGroup_21_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21__4__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21_4__0"
    // InternalEduTest.g:4919:1: rule__MultiChoiceEmConfig__Group_21_4__0 : rule__MultiChoiceEmConfig__Group_21_4__0__Impl rule__MultiChoiceEmConfig__Group_21_4__1 ;
    public final void rule__MultiChoiceEmConfig__Group_21_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4923:1: ( rule__MultiChoiceEmConfig__Group_21_4__0__Impl rule__MultiChoiceEmConfig__Group_21_4__1 )
            // InternalEduTest.g:4924:2: rule__MultiChoiceEmConfig__Group_21_4__0__Impl rule__MultiChoiceEmConfig__Group_21_4__1
            {
            pushFollow(FOLLOW_7);
            rule__MultiChoiceEmConfig__Group_21_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_21_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21_4__0"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21_4__0__Impl"
    // InternalEduTest.g:4931:1: rule__MultiChoiceEmConfig__Group_21_4__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group_21_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4935:1: ( ( ',' ) )
            // InternalEduTest.g:4936:1: ( ',' )
            {
            // InternalEduTest.g:4936:1: ( ',' )
            // InternalEduTest.g:4937:2: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_21_4_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_21_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21_4__0__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21_4__1"
    // InternalEduTest.g:4946:1: rule__MultiChoiceEmConfig__Group_21_4__1 : rule__MultiChoiceEmConfig__Group_21_4__1__Impl ;
    public final void rule__MultiChoiceEmConfig__Group_21_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4950:1: ( rule__MultiChoiceEmConfig__Group_21_4__1__Impl )
            // InternalEduTest.g:4951:2: rule__MultiChoiceEmConfig__Group_21_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__Group_21_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21_4__1"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group_21_4__1__Impl"
    // InternalEduTest.g:4957:1: rule__MultiChoiceEmConfig__Group_21_4__1__Impl : ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group_21_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4961:1: ( ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1 ) ) )
            // InternalEduTest.g:4962:1: ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1 ) )
            {
            // InternalEduTest.g:4962:1: ( ( rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1 ) )
            // InternalEduTest.g:4963:2: ( rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersAssignment_21_4_1()); 
            // InternalEduTest.g:4964:2: ( rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1 )
            // InternalEduTest.g:4964:3: rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersAssignment_21_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__Group_21_4__1__Impl"


    // $ANTLR start "rule__TextConfiguration__Group__0"
    // InternalEduTest.g:4973:1: rule__TextConfiguration__Group__0 : rule__TextConfiguration__Group__0__Impl rule__TextConfiguration__Group__1 ;
    public final void rule__TextConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4977:1: ( rule__TextConfiguration__Group__0__Impl rule__TextConfiguration__Group__1 )
            // InternalEduTest.g:4978:2: rule__TextConfiguration__Group__0__Impl rule__TextConfiguration__Group__1
            {
            pushFollow(FOLLOW_11);
            rule__TextConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__0"


    // $ANTLR start "rule__TextConfiguration__Group__0__Impl"
    // InternalEduTest.g:4985:1: rule__TextConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__TextConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4989:1: ( ( () ) )
            // InternalEduTest.g:4990:1: ( () )
            {
            // InternalEduTest.g:4990:1: ( () )
            // InternalEduTest.g:4991:2: ()
            {
             before(grammarAccess.getTextConfigurationAccess().getTextConfigurationAction_0()); 
            // InternalEduTest.g:4992:2: ()
            // InternalEduTest.g:4992:3: 
            {
            }

             after(grammarAccess.getTextConfigurationAccess().getTextConfigurationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__0__Impl"


    // $ANTLR start "rule__TextConfiguration__Group__1"
    // InternalEduTest.g:5000:1: rule__TextConfiguration__Group__1 : rule__TextConfiguration__Group__1__Impl rule__TextConfiguration__Group__2 ;
    public final void rule__TextConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5004:1: ( rule__TextConfiguration__Group__1__Impl rule__TextConfiguration__Group__2 )
            // InternalEduTest.g:5005:2: rule__TextConfiguration__Group__1__Impl rule__TextConfiguration__Group__2
            {
            pushFollow(FOLLOW_8);
            rule__TextConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__1"


    // $ANTLR start "rule__TextConfiguration__Group__1__Impl"
    // InternalEduTest.g:5012:1: rule__TextConfiguration__Group__1__Impl : ( 'retry' ) ;
    public final void rule__TextConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5016:1: ( ( 'retry' ) )
            // InternalEduTest.g:5017:1: ( 'retry' )
            {
            // InternalEduTest.g:5017:1: ( 'retry' )
            // InternalEduTest.g:5018:2: 'retry'
            {
             before(grammarAccess.getTextConfigurationAccess().getRetryKeyword_1()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getRetryKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__1__Impl"


    // $ANTLR start "rule__TextConfiguration__Group__2"
    // InternalEduTest.g:5027:1: rule__TextConfiguration__Group__2 : rule__TextConfiguration__Group__2__Impl rule__TextConfiguration__Group__3 ;
    public final void rule__TextConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5031:1: ( rule__TextConfiguration__Group__2__Impl rule__TextConfiguration__Group__3 )
            // InternalEduTest.g:5032:2: rule__TextConfiguration__Group__2__Impl rule__TextConfiguration__Group__3
            {
            pushFollow(FOLLOW_17);
            rule__TextConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__2"


    // $ANTLR start "rule__TextConfiguration__Group__2__Impl"
    // InternalEduTest.g:5039:1: rule__TextConfiguration__Group__2__Impl : ( '=' ) ;
    public final void rule__TextConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5043:1: ( ( '=' ) )
            // InternalEduTest.g:5044:1: ( '=' )
            {
            // InternalEduTest.g:5044:1: ( '=' )
            // InternalEduTest.g:5045:2: '='
            {
             before(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__2__Impl"


    // $ANTLR start "rule__TextConfiguration__Group__3"
    // InternalEduTest.g:5054:1: rule__TextConfiguration__Group__3 : rule__TextConfiguration__Group__3__Impl rule__TextConfiguration__Group__4 ;
    public final void rule__TextConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5058:1: ( rule__TextConfiguration__Group__3__Impl rule__TextConfiguration__Group__4 )
            // InternalEduTest.g:5059:2: rule__TextConfiguration__Group__3__Impl rule__TextConfiguration__Group__4
            {
            pushFollow(FOLLOW_14);
            rule__TextConfiguration__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__3"


    // $ANTLR start "rule__TextConfiguration__Group__3__Impl"
    // InternalEduTest.g:5066:1: rule__TextConfiguration__Group__3__Impl : ( ( rule__TextConfiguration__RetryAssignment_3 ) ) ;
    public final void rule__TextConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5070:1: ( ( ( rule__TextConfiguration__RetryAssignment_3 ) ) )
            // InternalEduTest.g:5071:1: ( ( rule__TextConfiguration__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:5071:1: ( ( rule__TextConfiguration__RetryAssignment_3 ) )
            // InternalEduTest.g:5072:2: ( rule__TextConfiguration__RetryAssignment_3 )
            {
             before(grammarAccess.getTextConfigurationAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:5073:2: ( rule__TextConfiguration__RetryAssignment_3 )
            // InternalEduTest.g:5073:3: rule__TextConfiguration__RetryAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__RetryAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTextConfigurationAccess().getRetryAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__3__Impl"


    // $ANTLR start "rule__TextConfiguration__Group__4"
    // InternalEduTest.g:5081:1: rule__TextConfiguration__Group__4 : rule__TextConfiguration__Group__4__Impl rule__TextConfiguration__Group__5 ;
    public final void rule__TextConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5085:1: ( rule__TextConfiguration__Group__4__Impl rule__TextConfiguration__Group__5 )
            // InternalEduTest.g:5086:2: rule__TextConfiguration__Group__4__Impl rule__TextConfiguration__Group__5
            {
            pushFollow(FOLLOW_14);
            rule__TextConfiguration__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__4"


    // $ANTLR start "rule__TextConfiguration__Group__4__Impl"
    // InternalEduTest.g:5093:1: rule__TextConfiguration__Group__4__Impl : ( ( rule__TextConfiguration__Group_4__0 )? ) ;
    public final void rule__TextConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5097:1: ( ( ( rule__TextConfiguration__Group_4__0 )? ) )
            // InternalEduTest.g:5098:1: ( ( rule__TextConfiguration__Group_4__0 )? )
            {
            // InternalEduTest.g:5098:1: ( ( rule__TextConfiguration__Group_4__0 )? )
            // InternalEduTest.g:5099:2: ( rule__TextConfiguration__Group_4__0 )?
            {
             before(grammarAccess.getTextConfigurationAccess().getGroup_4()); 
            // InternalEduTest.g:5100:2: ( rule__TextConfiguration__Group_4__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==28) ) {
                int LA47_1 = input.LA(2);

                if ( (LA47_1==39) ) {
                    alt47=1;
                }
            }
            switch (alt47) {
                case 1 :
                    // InternalEduTest.g:5100:3: rule__TextConfiguration__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextConfiguration__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextConfigurationAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__4__Impl"


    // $ANTLR start "rule__TextConfiguration__Group__5"
    // InternalEduTest.g:5108:1: rule__TextConfiguration__Group__5 : rule__TextConfiguration__Group__5__Impl ;
    public final void rule__TextConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5112:1: ( rule__TextConfiguration__Group__5__Impl )
            // InternalEduTest.g:5113:2: rule__TextConfiguration__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__5"


    // $ANTLR start "rule__TextConfiguration__Group__5__Impl"
    // InternalEduTest.g:5119:1: rule__TextConfiguration__Group__5__Impl : ( ( rule__TextConfiguration__Group_5__0 )? ) ;
    public final void rule__TextConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5123:1: ( ( ( rule__TextConfiguration__Group_5__0 )? ) )
            // InternalEduTest.g:5124:1: ( ( rule__TextConfiguration__Group_5__0 )? )
            {
            // InternalEduTest.g:5124:1: ( ( rule__TextConfiguration__Group_5__0 )? )
            // InternalEduTest.g:5125:2: ( rule__TextConfiguration__Group_5__0 )?
            {
             before(grammarAccess.getTextConfigurationAccess().getGroup_5()); 
            // InternalEduTest.g:5126:2: ( rule__TextConfiguration__Group_5__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==28) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalEduTest.g:5126:3: rule__TextConfiguration__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__TextConfiguration__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTextConfigurationAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__5__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_4__0"
    // InternalEduTest.g:5135:1: rule__TextConfiguration__Group_4__0 : rule__TextConfiguration__Group_4__0__Impl rule__TextConfiguration__Group_4__1 ;
    public final void rule__TextConfiguration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5139:1: ( rule__TextConfiguration__Group_4__0__Impl rule__TextConfiguration__Group_4__1 )
            // InternalEduTest.g:5140:2: rule__TextConfiguration__Group_4__0__Impl rule__TextConfiguration__Group_4__1
            {
            pushFollow(FOLLOW_18);
            rule__TextConfiguration__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__0"


    // $ANTLR start "rule__TextConfiguration__Group_4__0__Impl"
    // InternalEduTest.g:5147:1: rule__TextConfiguration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TextConfiguration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5151:1: ( ( ',' ) )
            // InternalEduTest.g:5152:1: ( ',' )
            {
            // InternalEduTest.g:5152:1: ( ',' )
            // InternalEduTest.g:5153:2: ','
            {
             before(grammarAccess.getTextConfigurationAccess().getCommaKeyword_4_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getCommaKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__0__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_4__1"
    // InternalEduTest.g:5162:1: rule__TextConfiguration__Group_4__1 : rule__TextConfiguration__Group_4__1__Impl rule__TextConfiguration__Group_4__2 ;
    public final void rule__TextConfiguration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5166:1: ( rule__TextConfiguration__Group_4__1__Impl rule__TextConfiguration__Group_4__2 )
            // InternalEduTest.g:5167:2: rule__TextConfiguration__Group_4__1__Impl rule__TextConfiguration__Group_4__2
            {
            pushFollow(FOLLOW_8);
            rule__TextConfiguration__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__1"


    // $ANTLR start "rule__TextConfiguration__Group_4__1__Impl"
    // InternalEduTest.g:5174:1: rule__TextConfiguration__Group_4__1__Impl : ( 'mode' ) ;
    public final void rule__TextConfiguration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5178:1: ( ( 'mode' ) )
            // InternalEduTest.g:5179:1: ( 'mode' )
            {
            // InternalEduTest.g:5179:1: ( 'mode' )
            // InternalEduTest.g:5180:2: 'mode'
            {
             before(grammarAccess.getTextConfigurationAccess().getModeKeyword_4_1()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getModeKeyword_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__1__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_4__2"
    // InternalEduTest.g:5189:1: rule__TextConfiguration__Group_4__2 : rule__TextConfiguration__Group_4__2__Impl rule__TextConfiguration__Group_4__3 ;
    public final void rule__TextConfiguration__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5193:1: ( rule__TextConfiguration__Group_4__2__Impl rule__TextConfiguration__Group_4__3 )
            // InternalEduTest.g:5194:2: rule__TextConfiguration__Group_4__2__Impl rule__TextConfiguration__Group_4__3
            {
            pushFollow(FOLLOW_19);
            rule__TextConfiguration__Group_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__2"


    // $ANTLR start "rule__TextConfiguration__Group_4__2__Impl"
    // InternalEduTest.g:5201:1: rule__TextConfiguration__Group_4__2__Impl : ( '=' ) ;
    public final void rule__TextConfiguration__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5205:1: ( ( '=' ) )
            // InternalEduTest.g:5206:1: ( '=' )
            {
            // InternalEduTest.g:5206:1: ( '=' )
            // InternalEduTest.g:5207:2: '='
            {
             before(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_4_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__2__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_4__3"
    // InternalEduTest.g:5216:1: rule__TextConfiguration__Group_4__3 : rule__TextConfiguration__Group_4__3__Impl ;
    public final void rule__TextConfiguration__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5220:1: ( rule__TextConfiguration__Group_4__3__Impl )
            // InternalEduTest.g:5221:2: rule__TextConfiguration__Group_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__3"


    // $ANTLR start "rule__TextConfiguration__Group_4__3__Impl"
    // InternalEduTest.g:5227:1: rule__TextConfiguration__Group_4__3__Impl : ( ( rule__TextConfiguration__ModeAssignment_4_3 ) ) ;
    public final void rule__TextConfiguration__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5231:1: ( ( ( rule__TextConfiguration__ModeAssignment_4_3 ) ) )
            // InternalEduTest.g:5232:1: ( ( rule__TextConfiguration__ModeAssignment_4_3 ) )
            {
            // InternalEduTest.g:5232:1: ( ( rule__TextConfiguration__ModeAssignment_4_3 ) )
            // InternalEduTest.g:5233:2: ( rule__TextConfiguration__ModeAssignment_4_3 )
            {
             before(grammarAccess.getTextConfigurationAccess().getModeAssignment_4_3()); 
            // InternalEduTest.g:5234:2: ( rule__TextConfiguration__ModeAssignment_4_3 )
            // InternalEduTest.g:5234:3: rule__TextConfiguration__ModeAssignment_4_3
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__ModeAssignment_4_3();

            state._fsp--;


            }

             after(grammarAccess.getTextConfigurationAccess().getModeAssignment_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_4__3__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_5__0"
    // InternalEduTest.g:5243:1: rule__TextConfiguration__Group_5__0 : rule__TextConfiguration__Group_5__0__Impl rule__TextConfiguration__Group_5__1 ;
    public final void rule__TextConfiguration__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5247:1: ( rule__TextConfiguration__Group_5__0__Impl rule__TextConfiguration__Group_5__1 )
            // InternalEduTest.g:5248:2: rule__TextConfiguration__Group_5__0__Impl rule__TextConfiguration__Group_5__1
            {
            pushFollow(FOLLOW_27);
            rule__TextConfiguration__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__0"


    // $ANTLR start "rule__TextConfiguration__Group_5__0__Impl"
    // InternalEduTest.g:5255:1: rule__TextConfiguration__Group_5__0__Impl : ( ',' ) ;
    public final void rule__TextConfiguration__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5259:1: ( ( ',' ) )
            // InternalEduTest.g:5260:1: ( ',' )
            {
            // InternalEduTest.g:5260:1: ( ',' )
            // InternalEduTest.g:5261:2: ','
            {
             before(grammarAccess.getTextConfigurationAccess().getCommaKeyword_5_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__0__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_5__1"
    // InternalEduTest.g:5270:1: rule__TextConfiguration__Group_5__1 : rule__TextConfiguration__Group_5__1__Impl rule__TextConfiguration__Group_5__2 ;
    public final void rule__TextConfiguration__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5274:1: ( rule__TextConfiguration__Group_5__1__Impl rule__TextConfiguration__Group_5__2 )
            // InternalEduTest.g:5275:2: rule__TextConfiguration__Group_5__1__Impl rule__TextConfiguration__Group_5__2
            {
            pushFollow(FOLLOW_8);
            rule__TextConfiguration__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__1"


    // $ANTLR start "rule__TextConfiguration__Group_5__1__Impl"
    // InternalEduTest.g:5282:1: rule__TextConfiguration__Group_5__1__Impl : ( 'text' ) ;
    public final void rule__TextConfiguration__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5286:1: ( ( 'text' ) )
            // InternalEduTest.g:5287:1: ( 'text' )
            {
            // InternalEduTest.g:5287:1: ( 'text' )
            // InternalEduTest.g:5288:2: 'text'
            {
             before(grammarAccess.getTextConfigurationAccess().getTextKeyword_5_1()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getTextKeyword_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__1__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_5__2"
    // InternalEduTest.g:5297:1: rule__TextConfiguration__Group_5__2 : rule__TextConfiguration__Group_5__2__Impl rule__TextConfiguration__Group_5__3 ;
    public final void rule__TextConfiguration__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5301:1: ( rule__TextConfiguration__Group_5__2__Impl rule__TextConfiguration__Group_5__3 )
            // InternalEduTest.g:5302:2: rule__TextConfiguration__Group_5__2__Impl rule__TextConfiguration__Group_5__3
            {
            pushFollow(FOLLOW_4);
            rule__TextConfiguration__Group_5__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_5__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__2"


    // $ANTLR start "rule__TextConfiguration__Group_5__2__Impl"
    // InternalEduTest.g:5309:1: rule__TextConfiguration__Group_5__2__Impl : ( '=' ) ;
    public final void rule__TextConfiguration__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5313:1: ( ( '=' ) )
            // InternalEduTest.g:5314:1: ( '=' )
            {
            // InternalEduTest.g:5314:1: ( '=' )
            // InternalEduTest.g:5315:2: '='
            {
             before(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_5_2()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__2__Impl"


    // $ANTLR start "rule__TextConfiguration__Group_5__3"
    // InternalEduTest.g:5324:1: rule__TextConfiguration__Group_5__3 : rule__TextConfiguration__Group_5__3__Impl ;
    public final void rule__TextConfiguration__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5328:1: ( rule__TextConfiguration__Group_5__3__Impl )
            // InternalEduTest.g:5329:2: rule__TextConfiguration__Group_5__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group_5__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__3"


    // $ANTLR start "rule__TextConfiguration__Group_5__3__Impl"
    // InternalEduTest.g:5335:1: rule__TextConfiguration__Group_5__3__Impl : ( ( rule__TextConfiguration__IdentifierAssignment_5_3 ) ) ;
    public final void rule__TextConfiguration__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5339:1: ( ( ( rule__TextConfiguration__IdentifierAssignment_5_3 ) ) )
            // InternalEduTest.g:5340:1: ( ( rule__TextConfiguration__IdentifierAssignment_5_3 ) )
            {
            // InternalEduTest.g:5340:1: ( ( rule__TextConfiguration__IdentifierAssignment_5_3 ) )
            // InternalEduTest.g:5341:2: ( rule__TextConfiguration__IdentifierAssignment_5_3 )
            {
             before(grammarAccess.getTextConfigurationAccess().getIdentifierAssignment_5_3()); 
            // InternalEduTest.g:5342:2: ( rule__TextConfiguration__IdentifierAssignment_5_3 )
            // InternalEduTest.g:5342:3: rule__TextConfiguration__IdentifierAssignment_5_3
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__IdentifierAssignment_5_3();

            state._fsp--;


            }

             after(grammarAccess.getTextConfigurationAccess().getIdentifierAssignment_5_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group_5__3__Impl"


    // $ANTLR start "rule__Test__Group__0"
    // InternalEduTest.g:5351:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5355:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // InternalEduTest.g:5356:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_28);
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
    // InternalEduTest.g:5363:1: rule__Test__Group__0__Impl : ( 'description' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5367:1: ( ( 'description' ) )
            // InternalEduTest.g:5368:1: ( 'description' )
            {
            // InternalEduTest.g:5368:1: ( 'description' )
            // InternalEduTest.g:5369:2: 'description'
            {
             before(grammarAccess.getTestAccess().getDescriptionKeyword_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalEduTest.g:5378:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5382:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // InternalEduTest.g:5383:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_4);
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
    // InternalEduTest.g:5390:1: rule__Test__Group__1__Impl : ( 'for' ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5394:1: ( ( 'for' ) )
            // InternalEduTest.g:5395:1: ( 'for' )
            {
            // InternalEduTest.g:5395:1: ( 'for' )
            // InternalEduTest.g:5396:2: 'for'
            {
             before(grammarAccess.getTestAccess().getForKeyword_1()); 
            match(input,47,FOLLOW_2); 
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
    // InternalEduTest.g:5405:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5409:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // InternalEduTest.g:5410:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_8);
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
    // InternalEduTest.g:5417:1: rule__Test__Group__2__Impl : ( ( rule__Test__SourceAssignment_2 ) ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5421:1: ( ( ( rule__Test__SourceAssignment_2 ) ) )
            // InternalEduTest.g:5422:1: ( ( rule__Test__SourceAssignment_2 ) )
            {
            // InternalEduTest.g:5422:1: ( ( rule__Test__SourceAssignment_2 ) )
            // InternalEduTest.g:5423:2: ( rule__Test__SourceAssignment_2 )
            {
             before(grammarAccess.getTestAccess().getSourceAssignment_2()); 
            // InternalEduTest.g:5424:2: ( rule__Test__SourceAssignment_2 )
            // InternalEduTest.g:5424:3: rule__Test__SourceAssignment_2
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
    // InternalEduTest.g:5432:1: rule__Test__Group__3 : rule__Test__Group__3__Impl rule__Test__Group__4 ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5436:1: ( rule__Test__Group__3__Impl rule__Test__Group__4 )
            // InternalEduTest.g:5437:2: rule__Test__Group__3__Impl rule__Test__Group__4
            {
            pushFollow(FOLLOW_4);
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
    // InternalEduTest.g:5444:1: rule__Test__Group__3__Impl : ( '=' ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5448:1: ( ( '=' ) )
            // InternalEduTest.g:5449:1: ( '=' )
            {
            // InternalEduTest.g:5449:1: ( '=' )
            // InternalEduTest.g:5450:2: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_3()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:5459:1: rule__Test__Group__4 : rule__Test__Group__4__Impl rule__Test__Group__5 ;
    public final void rule__Test__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5463:1: ( rule__Test__Group__4__Impl rule__Test__Group__5 )
            // InternalEduTest.g:5464:2: rule__Test__Group__4__Impl rule__Test__Group__5
            {
            pushFollow(FOLLOW_29);
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
    // InternalEduTest.g:5471:1: rule__Test__Group__4__Impl : ( ( rule__Test__QuestionAssignment_4 ) ) ;
    public final void rule__Test__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5475:1: ( ( ( rule__Test__QuestionAssignment_4 ) ) )
            // InternalEduTest.g:5476:1: ( ( rule__Test__QuestionAssignment_4 ) )
            {
            // InternalEduTest.g:5476:1: ( ( rule__Test__QuestionAssignment_4 ) )
            // InternalEduTest.g:5477:2: ( rule__Test__QuestionAssignment_4 )
            {
             before(grammarAccess.getTestAccess().getQuestionAssignment_4()); 
            // InternalEduTest.g:5478:2: ( rule__Test__QuestionAssignment_4 )
            // InternalEduTest.g:5478:3: rule__Test__QuestionAssignment_4
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
    // InternalEduTest.g:5486:1: rule__Test__Group__5 : rule__Test__Group__5__Impl ;
    public final void rule__Test__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5490:1: ( rule__Test__Group__5__Impl )
            // InternalEduTest.g:5491:2: rule__Test__Group__5__Impl
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
    // InternalEduTest.g:5497:1: rule__Test__Group__5__Impl : ( ( rule__Test__Group_5__0 )? ) ;
    public final void rule__Test__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5501:1: ( ( ( rule__Test__Group_5__0 )? ) )
            // InternalEduTest.g:5502:1: ( ( rule__Test__Group_5__0 )? )
            {
            // InternalEduTest.g:5502:1: ( ( rule__Test__Group_5__0 )? )
            // InternalEduTest.g:5503:2: ( rule__Test__Group_5__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_5()); 
            // InternalEduTest.g:5504:2: ( rule__Test__Group_5__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==52) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalEduTest.g:5504:3: rule__Test__Group_5__0
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
    // InternalEduTest.g:5513:1: rule__Test__Group_5__0 : rule__Test__Group_5__0__Impl rule__Test__Group_5__1 ;
    public final void rule__Test__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5517:1: ( rule__Test__Group_5__0__Impl rule__Test__Group_5__1 )
            // InternalEduTest.g:5518:2: rule__Test__Group_5__0__Impl rule__Test__Group_5__1
            {
            pushFollow(FOLLOW_30);
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
    // InternalEduTest.g:5525:1: rule__Test__Group_5__0__Impl : ( ( rule__Test__ExpressionAssignment_5_0 ) ) ;
    public final void rule__Test__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5529:1: ( ( ( rule__Test__ExpressionAssignment_5_0 ) ) )
            // InternalEduTest.g:5530:1: ( ( rule__Test__ExpressionAssignment_5_0 ) )
            {
            // InternalEduTest.g:5530:1: ( ( rule__Test__ExpressionAssignment_5_0 ) )
            // InternalEduTest.g:5531:2: ( rule__Test__ExpressionAssignment_5_0 )
            {
             before(grammarAccess.getTestAccess().getExpressionAssignment_5_0()); 
            // InternalEduTest.g:5532:2: ( rule__Test__ExpressionAssignment_5_0 )
            // InternalEduTest.g:5532:3: rule__Test__ExpressionAssignment_5_0
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
    // InternalEduTest.g:5540:1: rule__Test__Group_5__1 : rule__Test__Group_5__1__Impl ;
    public final void rule__Test__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5544:1: ( rule__Test__Group_5__1__Impl )
            // InternalEduTest.g:5545:2: rule__Test__Group_5__1__Impl
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
    // InternalEduTest.g:5551:1: rule__Test__Group_5__1__Impl : ( ( rule__Test__Group_5_1__0 )? ) ;
    public final void rule__Test__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5555:1: ( ( ( rule__Test__Group_5_1__0 )? ) )
            // InternalEduTest.g:5556:1: ( ( rule__Test__Group_5_1__0 )? )
            {
            // InternalEduTest.g:5556:1: ( ( rule__Test__Group_5_1__0 )? )
            // InternalEduTest.g:5557:2: ( rule__Test__Group_5_1__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_5_1()); 
            // InternalEduTest.g:5558:2: ( rule__Test__Group_5_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==48) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalEduTest.g:5558:3: rule__Test__Group_5_1__0
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
    // InternalEduTest.g:5567:1: rule__Test__Group_5_1__0 : rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1 ;
    public final void rule__Test__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5571:1: ( rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1 )
            // InternalEduTest.g:5572:2: rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1
            {
            pushFollow(FOLLOW_4);
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
    // InternalEduTest.g:5579:1: rule__Test__Group_5_1__0__Impl : ( '(' ) ;
    public final void rule__Test__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5583:1: ( ( '(' ) )
            // InternalEduTest.g:5584:1: ( '(' )
            {
            // InternalEduTest.g:5584:1: ( '(' )
            // InternalEduTest.g:5585:2: '('
            {
             before(grammarAccess.getTestAccess().getLeftParenthesisKeyword_5_1_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalEduTest.g:5594:1: rule__Test__Group_5_1__1 : rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2 ;
    public final void rule__Test__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5598:1: ( rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2 )
            // InternalEduTest.g:5599:2: rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalEduTest.g:5606:1: rule__Test__Group_5_1__1__Impl : ( ( rule__Test__IdentifierAssignment_5_1_1 ) ) ;
    public final void rule__Test__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5610:1: ( ( ( rule__Test__IdentifierAssignment_5_1_1 ) ) )
            // InternalEduTest.g:5611:1: ( ( rule__Test__IdentifierAssignment_5_1_1 ) )
            {
            // InternalEduTest.g:5611:1: ( ( rule__Test__IdentifierAssignment_5_1_1 ) )
            // InternalEduTest.g:5612:2: ( rule__Test__IdentifierAssignment_5_1_1 )
            {
             before(grammarAccess.getTestAccess().getIdentifierAssignment_5_1_1()); 
            // InternalEduTest.g:5613:2: ( rule__Test__IdentifierAssignment_5_1_1 )
            // InternalEduTest.g:5613:3: rule__Test__IdentifierAssignment_5_1_1
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
    // InternalEduTest.g:5621:1: rule__Test__Group_5_1__2 : rule__Test__Group_5_1__2__Impl ;
    public final void rule__Test__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5625:1: ( rule__Test__Group_5_1__2__Impl )
            // InternalEduTest.g:5626:2: rule__Test__Group_5_1__2__Impl
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
    // InternalEduTest.g:5632:1: rule__Test__Group_5_1__2__Impl : ( ')' ) ;
    public final void rule__Test__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5636:1: ( ( ')' ) )
            // InternalEduTest.g:5637:1: ( ')' )
            {
            // InternalEduTest.g:5637:1: ( ')' )
            // InternalEduTest.g:5638:2: ')'
            {
             before(grammarAccess.getTestAccess().getRightParenthesisKeyword_5_1_2()); 
            match(input,49,FOLLOW_2); 
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
    // InternalEduTest.g:5648:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5652:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalEduTest.g:5653:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FOLLOW_24);
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
    // InternalEduTest.g:5660:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5664:1: ( ( ( '-' )? ) )
            // InternalEduTest.g:5665:1: ( ( '-' )? )
            {
            // InternalEduTest.g:5665:1: ( ( '-' )? )
            // InternalEduTest.g:5666:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // InternalEduTest.g:5667:2: ( '-' )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==50) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalEduTest.g:5667:3: '-'
                    {
                    match(input,50,FOLLOW_2); 

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
    // InternalEduTest.g:5675:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5679:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalEduTest.g:5680:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FOLLOW_24);
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
    // InternalEduTest.g:5687:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5691:1: ( ( ( RULE_INT )? ) )
            // InternalEduTest.g:5692:1: ( ( RULE_INT )? )
            {
            // InternalEduTest.g:5692:1: ( ( RULE_INT )? )
            // InternalEduTest.g:5693:2: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // InternalEduTest.g:5694:2: ( RULE_INT )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_INT) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalEduTest.g:5694:3: RULE_INT
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
    // InternalEduTest.g:5702:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5706:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // InternalEduTest.g:5707:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FOLLOW_32);
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
    // InternalEduTest.g:5714:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5718:1: ( ( '.' ) )
            // InternalEduTest.g:5719:1: ( '.' )
            {
            // InternalEduTest.g:5719:1: ( '.' )
            // InternalEduTest.g:5720:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,51,FOLLOW_2); 
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
    // InternalEduTest.g:5729:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5733:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // InternalEduTest.g:5734:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FOLLOW_33);
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
    // InternalEduTest.g:5741:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5745:1: ( ( RULE_INT ) )
            // InternalEduTest.g:5746:1: ( RULE_INT )
            {
            // InternalEduTest.g:5746:1: ( RULE_INT )
            // InternalEduTest.g:5747:2: RULE_INT
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
    // InternalEduTest.g:5756:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5760:1: ( rule__EDouble__Group__4__Impl )
            // InternalEduTest.g:5761:2: rule__EDouble__Group__4__Impl
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
    // InternalEduTest.g:5767:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5771:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // InternalEduTest.g:5772:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // InternalEduTest.g:5772:1: ( ( rule__EDouble__Group_4__0 )? )
            // InternalEduTest.g:5773:2: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // InternalEduTest.g:5774:2: ( rule__EDouble__Group_4__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( ((LA53_0>=13 && LA53_0<=14)) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalEduTest.g:5774:3: rule__EDouble__Group_4__0
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
    // InternalEduTest.g:5783:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5787:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // InternalEduTest.g:5788:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FOLLOW_34);
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
    // InternalEduTest.g:5795:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5799:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // InternalEduTest.g:5800:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // InternalEduTest.g:5800:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // InternalEduTest.g:5801:2: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // InternalEduTest.g:5802:2: ( rule__EDouble__Alternatives_4_0 )
            // InternalEduTest.g:5802:3: rule__EDouble__Alternatives_4_0
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
    // InternalEduTest.g:5810:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5814:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // InternalEduTest.g:5815:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalEduTest.g:5822:1: rule__EDouble__Group_4__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5826:1: ( ( ( '-' )? ) )
            // InternalEduTest.g:5827:1: ( ( '-' )? )
            {
            // InternalEduTest.g:5827:1: ( ( '-' )? )
            // InternalEduTest.g:5828:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
            // InternalEduTest.g:5829:2: ( '-' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==50) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalEduTest.g:5829:3: '-'
                    {
                    match(input,50,FOLLOW_2); 

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
    // InternalEduTest.g:5837:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5841:1: ( rule__EDouble__Group_4__2__Impl )
            // InternalEduTest.g:5842:2: rule__EDouble__Group_4__2__Impl
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
    // InternalEduTest.g:5848:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5852:1: ( ( RULE_INT ) )
            // InternalEduTest.g:5853:1: ( RULE_INT )
            {
            // InternalEduTest.g:5853:1: ( RULE_INT )
            // InternalEduTest.g:5854:2: RULE_INT
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


    // $ANTLR start "rule__Program__MetamodelAssignment_2"
    // InternalEduTest.g:5864:1: rule__Program__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__Program__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5868:1: ( ( ruleEString ) )
            // InternalEduTest.g:5869:2: ( ruleEString )
            {
            // InternalEduTest.g:5869:2: ( ruleEString )
            // InternalEduTest.g:5870:3: ruleEString
            {
             before(grammarAccess.getProgramAccess().getMetamodelEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getMetamodelEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__MetamodelAssignment_2"


    // $ANTLR start "rule__Program__ConfigAssignment_3"
    // InternalEduTest.g:5879:1: rule__Program__ConfigAssignment_3 : ( ruleProgramConfiguration ) ;
    public final void rule__Program__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5883:1: ( ( ruleProgramConfiguration ) )
            // InternalEduTest.g:5884:2: ( ruleProgramConfiguration )
            {
            // InternalEduTest.g:5884:2: ( ruleProgramConfiguration )
            // InternalEduTest.g:5885:3: ruleProgramConfiguration
            {
             before(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleProgramConfiguration();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ConfigAssignment_3"


    // $ANTLR start "rule__Program__ExercisesAssignment_4"
    // InternalEduTest.g:5894:1: rule__Program__ExercisesAssignment_4 : ( ruleMutatorTests ) ;
    public final void rule__Program__ExercisesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5898:1: ( ( ruleMutatorTests ) )
            // InternalEduTest.g:5899:2: ( ruleMutatorTests )
            {
            // InternalEduTest.g:5899:2: ( ruleMutatorTests )
            // InternalEduTest.g:5900:3: ruleMutatorTests
            {
             before(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleMutatorTests();

            state._fsp--;

             after(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Program__ExercisesAssignment_4"


    // $ANTLR start "rule__MarkedBlock__BlockAssignment_1"
    // InternalEduTest.g:5909:1: rule__MarkedBlock__BlockAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MarkedBlock__BlockAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5913:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5914:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5914:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5915:3: ( RULE_ID )
            {
             before(grammarAccess.getMarkedBlockAccess().getBlockBlockCrossReference_1_0()); 
            // InternalEduTest.g:5916:3: ( RULE_ID )
            // InternalEduTest.g:5917:4: RULE_ID
            {
             before(grammarAccess.getMarkedBlockAccess().getBlockBlockIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMarkedBlockAccess().getBlockBlockIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMarkedBlockAccess().getBlockBlockCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__BlockAssignment_1"


    // $ANTLR start "rule__MarkedBlock__SolutionAssignment_2_0"
    // InternalEduTest.g:5928:1: rule__MarkedBlock__SolutionAssignment_2_0 : ( ( '=' ) ) ;
    public final void rule__MarkedBlock__SolutionAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5932:1: ( ( ( '=' ) ) )
            // InternalEduTest.g:5933:2: ( ( '=' ) )
            {
            // InternalEduTest.g:5933:2: ( ( '=' ) )
            // InternalEduTest.g:5934:3: ( '=' )
            {
             before(grammarAccess.getMarkedBlockAccess().getSolutionEqualsSignKeyword_2_0_0()); 
            // InternalEduTest.g:5935:3: ( '=' )
            // InternalEduTest.g:5936:4: '='
            {
             before(grammarAccess.getMarkedBlockAccess().getSolutionEqualsSignKeyword_2_0_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getMarkedBlockAccess().getSolutionEqualsSignKeyword_2_0_0()); 

            }

             after(grammarAccess.getMarkedBlockAccess().getSolutionEqualsSignKeyword_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MarkedBlock__SolutionAssignment_2_0"


    // $ANTLR start "rule__AlternativeResponse__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:5947:1: rule__AlternativeResponse__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__AlternativeResponse__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5951:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:5952:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:5952:2: ( ruleMarkedBlock )
            // InternalEduTest.g:5953:3: ruleMarkedBlock
            {
             before(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:5962:1: rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5966:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:5967:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:5967:2: ( ruleMarkedBlock )
            // InternalEduTest.g:5968:3: ruleMarkedBlock
            {
             before(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getAlternativeResponseAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__AlternativeResponse__ConfigAssignment_3"
    // InternalEduTest.g:5977:1: rule__AlternativeResponse__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__AlternativeResponse__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5981:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:5982:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:5982:2: ( ruleTestConfiguration )
            // InternalEduTest.g:5983:3: ruleTestConfiguration
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
    // InternalEduTest.g:5992:1: rule__AlternativeResponse__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__AlternativeResponse__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5996:1: ( ( ruleTest ) )
            // InternalEduTest.g:5997:2: ( ruleTest )
            {
            // InternalEduTest.g:5997:2: ( ruleTest )
            // InternalEduTest.g:5998:3: ruleTest
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


    // $ANTLR start "rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:6007:1: rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6011:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6012:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6012:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6013:3: ruleMarkedBlock
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:6022:1: rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6026:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6027:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6027:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6028:3: ruleMarkedBlock
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMultiChoiceDiagramAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__MultiChoiceDiagram__ConfigAssignment_3"
    // InternalEduTest.g:6037:1: rule__MultiChoiceDiagram__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MultiChoiceDiagram__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6041:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:6042:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:6042:2: ( ruleTestConfiguration )
            // InternalEduTest.g:6043:3: ruleTestConfiguration
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
    // InternalEduTest.g:6052:1: rule__MultiChoiceDiagram__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceDiagram__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6056:1: ( ( ruleTest ) )
            // InternalEduTest.g:6057:2: ( ruleTest )
            {
            // InternalEduTest.g:6057:2: ( ruleTest )
            // InternalEduTest.g:6058:3: ruleTest
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


    // $ANTLR start "rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:6067:1: rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6071:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6072:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6072:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6073:3: ruleMarkedBlock
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:6082:1: rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6086:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6087:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6087:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6088:3: ruleMarkedBlock
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmendationAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__MultiChoiceEmendation__ConfigAssignment_3"
    // InternalEduTest.g:6097:1: rule__MultiChoiceEmendation__ConfigAssignment_3 : ( ruleMultiChoiceEmConfig ) ;
    public final void rule__MultiChoiceEmendation__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6101:1: ( ( ruleMultiChoiceEmConfig ) )
            // InternalEduTest.g:6102:2: ( ruleMultiChoiceEmConfig )
            {
            // InternalEduTest.g:6102:2: ( ruleMultiChoiceEmConfig )
            // InternalEduTest.g:6103:3: ruleMultiChoiceEmConfig
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
    // InternalEduTest.g:6112:1: rule__MultiChoiceEmendation__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceEmendation__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6116:1: ( ( ruleTest ) )
            // InternalEduTest.g:6117:2: ( ruleTest )
            {
            // InternalEduTest.g:6117:2: ( ruleTest )
            // InternalEduTest.g:6118:3: ruleTest
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


    // $ANTLR start "rule__MatchPairs__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:6127:1: rule__MatchPairs__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__MatchPairs__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6131:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6132:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6132:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6133:3: ruleMarkedBlock
            {
             before(grammarAccess.getMatchPairsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMatchPairsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__MatchPairs__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:6142:1: rule__MatchPairs__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__MatchPairs__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6146:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6147:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6147:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6148:3: ruleMarkedBlock
            {
             before(grammarAccess.getMatchPairsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMatchPairsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MatchPairs__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__MatchPairs__ConfigAssignment_3"
    // InternalEduTest.g:6157:1: rule__MatchPairs__ConfigAssignment_3 : ( ruleTextConfiguration ) ;
    public final void rule__MatchPairs__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6161:1: ( ( ruleTextConfiguration ) )
            // InternalEduTest.g:6162:2: ( ruleTextConfiguration )
            {
            // InternalEduTest.g:6162:2: ( ruleTextConfiguration )
            // InternalEduTest.g:6163:3: ruleTextConfiguration
            {
             before(grammarAccess.getMatchPairsAccess().getConfigTextConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTextConfiguration();

            state._fsp--;

             after(grammarAccess.getMatchPairsAccess().getConfigTextConfigurationParserRuleCall_3_0()); 

            }


            }

        }
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
    // InternalEduTest.g:6172:1: rule__MatchPairs__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MatchPairs__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6176:1: ( ( ruleTest ) )
            // InternalEduTest.g:6177:2: ( ruleTest )
            {
            // InternalEduTest.g:6177:2: ( ruleTest )
            // InternalEduTest.g:6178:3: ruleTest
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


    // $ANTLR start "rule__MissingWords__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:6187:1: rule__MissingWords__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__MissingWords__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6191:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6192:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6192:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6193:3: ruleMarkedBlock
            {
             before(grammarAccess.getMissingWordsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMissingWordsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__MissingWords__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:6202:1: rule__MissingWords__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__MissingWords__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6206:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6207:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6207:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6208:3: ruleMarkedBlock
            {
             before(grammarAccess.getMissingWordsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMissingWordsAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MissingWords__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__MissingWords__ConfigAssignment_3"
    // InternalEduTest.g:6217:1: rule__MissingWords__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MissingWords__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6221:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:6222:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:6222:2: ( ruleTestConfiguration )
            // InternalEduTest.g:6223:3: ruleTestConfiguration
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
    // InternalEduTest.g:6232:1: rule__MissingWords__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MissingWords__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6236:1: ( ( ruleTest ) )
            // InternalEduTest.g:6237:2: ( ruleTest )
            {
            // InternalEduTest.g:6237:2: ( ruleTest )
            // InternalEduTest.g:6238:3: ruleTest
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


    // $ANTLR start "rule__MultiChoiceText__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:6247:1: rule__MultiChoiceText__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__MultiChoiceText__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6251:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6252:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6252:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6253:3: ruleMarkedBlock
            {
             before(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:6262:1: rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6266:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6267:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6267:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6268:3: ruleMarkedBlock
            {
             before(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getMultiChoiceTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__MultiChoiceText__ConfigAssignment_3"
    // InternalEduTest.g:6277:1: rule__MultiChoiceText__ConfigAssignment_3 : ( ruleTextConfiguration ) ;
    public final void rule__MultiChoiceText__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6281:1: ( ( ruleTextConfiguration ) )
            // InternalEduTest.g:6282:2: ( ruleTextConfiguration )
            {
            // InternalEduTest.g:6282:2: ( ruleTextConfiguration )
            // InternalEduTest.g:6283:3: ruleTextConfiguration
            {
             before(grammarAccess.getMultiChoiceTextAccess().getConfigTextConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTextConfiguration();

            state._fsp--;

             after(grammarAccess.getMultiChoiceTextAccess().getConfigTextConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__ConfigAssignment_3"


    // $ANTLR start "rule__MultiChoiceText__TestsAssignment_4"
    // InternalEduTest.g:6292:1: rule__MultiChoiceText__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceText__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6296:1: ( ( ruleTest ) )
            // InternalEduTest.g:6297:2: ( ruleTest )
            {
            // InternalEduTest.g:6297:2: ( ruleTest )
            // InternalEduTest.g:6298:3: ruleTest
            {
             before(grammarAccess.getMultiChoiceTextAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getMultiChoiceTextAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__TestsAssignment_4"


    // $ANTLR start "rule__AlternativeText__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:6307:1: rule__AlternativeText__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__AlternativeText__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6311:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6312:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6312:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6313:3: ruleMarkedBlock
            {
             before(grammarAccess.getAlternativeTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getAlternativeTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__AlternativeText__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:6322:1: rule__AlternativeText__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__AlternativeText__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6326:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6327:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6327:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6328:3: ruleMarkedBlock
            {
             before(grammarAccess.getAlternativeTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getAlternativeTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__AlternativeText__ConfigAssignment_3"
    // InternalEduTest.g:6337:1: rule__AlternativeText__ConfigAssignment_3 : ( ruleTextConfiguration ) ;
    public final void rule__AlternativeText__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6341:1: ( ( ruleTextConfiguration ) )
            // InternalEduTest.g:6342:2: ( ruleTextConfiguration )
            {
            // InternalEduTest.g:6342:2: ( ruleTextConfiguration )
            // InternalEduTest.g:6343:3: ruleTextConfiguration
            {
             before(grammarAccess.getAlternativeTextAccess().getConfigTextConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTextConfiguration();

            state._fsp--;

             after(grammarAccess.getAlternativeTextAccess().getConfigTextConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__ConfigAssignment_3"


    // $ANTLR start "rule__AlternativeText__TestsAssignment_4"
    // InternalEduTest.g:6352:1: rule__AlternativeText__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__AlternativeText__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6356:1: ( ( ruleTest ) )
            // InternalEduTest.g:6357:2: ( ruleTest )
            {
            // InternalEduTest.g:6357:2: ( ruleTest )
            // InternalEduTest.g:6358:3: ruleTest
            {
             before(grammarAccess.getAlternativeTextAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getAlternativeTextAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__TestsAssignment_4"


    // $ANTLR start "rule__DragAndDropText__MarkedBlocksAssignment_1_0"
    // InternalEduTest.g:6367:1: rule__DragAndDropText__MarkedBlocksAssignment_1_0 : ( ruleMarkedBlock ) ;
    public final void rule__DragAndDropText__MarkedBlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6371:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6372:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6372:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6373:3: ruleMarkedBlock
            {
             before(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__MarkedBlocksAssignment_1_0"


    // $ANTLR start "rule__DragAndDropText__MarkedBlocksAssignment_1_1_1"
    // InternalEduTest.g:6382:1: rule__DragAndDropText__MarkedBlocksAssignment_1_1_1 : ( ruleMarkedBlock ) ;
    public final void rule__DragAndDropText__MarkedBlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6386:1: ( ( ruleMarkedBlock ) )
            // InternalEduTest.g:6387:2: ( ruleMarkedBlock )
            {
            // InternalEduTest.g:6387:2: ( ruleMarkedBlock )
            // InternalEduTest.g:6388:3: ruleMarkedBlock
            {
             before(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleMarkedBlock();

            state._fsp--;

             after(grammarAccess.getDragAndDropTextAccess().getMarkedBlocksMarkedBlockParserRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__MarkedBlocksAssignment_1_1_1"


    // $ANTLR start "rule__DragAndDropText__ConfigAssignment_3"
    // InternalEduTest.g:6397:1: rule__DragAndDropText__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__DragAndDropText__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6401:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:6402:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:6402:2: ( ruleTestConfiguration )
            // InternalEduTest.g:6403:3: ruleTestConfiguration
            {
             before(grammarAccess.getDragAndDropTextAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleTestConfiguration();

            state._fsp--;

             after(grammarAccess.getDragAndDropTextAccess().getConfigTestConfigurationParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__ConfigAssignment_3"


    // $ANTLR start "rule__DragAndDropText__TestsAssignment_4"
    // InternalEduTest.g:6412:1: rule__DragAndDropText__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__DragAndDropText__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6416:1: ( ( ruleTest ) )
            // InternalEduTest.g:6417:2: ( ruleTest )
            {
            // InternalEduTest.g:6417:2: ( ruleTest )
            // InternalEduTest.g:6418:3: ruleTest
            {
             before(grammarAccess.getDragAndDropTextAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getDragAndDropTextAccess().getTestsTestParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__TestsAssignment_4"


    // $ANTLR start "rule__ProgramConfiguration__NavigationAssignment_2"
    // InternalEduTest.g:6427:1: rule__ProgramConfiguration__NavigationAssignment_2 : ( ruleNavigation ) ;
    public final void rule__ProgramConfiguration__NavigationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6431:1: ( ( ruleNavigation ) )
            // InternalEduTest.g:6432:2: ( ruleNavigation )
            {
            // InternalEduTest.g:6432:2: ( ruleNavigation )
            // InternalEduTest.g:6433:3: ruleNavigation
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
    // InternalEduTest.g:6442:1: rule__TestConfiguration__RetryAssignment_3 : ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) ;
    public final void rule__TestConfiguration__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6446:1: ( ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:6447:2: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:6447:2: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:6448:3: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:6449:3: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            // InternalEduTest.g:6449:4: rule__TestConfiguration__RetryAlternatives_3_0
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


    // $ANTLR start "rule__TestConfiguration__ModeAssignment_4_3"
    // InternalEduTest.g:6457:1: rule__TestConfiguration__ModeAssignment_4_3 : ( ruleMode ) ;
    public final void rule__TestConfiguration__ModeAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6461:1: ( ( ruleMode ) )
            // InternalEduTest.g:6462:2: ( ruleMode )
            {
            // InternalEduTest.g:6462:2: ( ruleMode )
            // InternalEduTest.g:6463:3: ruleMode
            {
             before(grammarAccess.getTestConfigurationAccess().getModeModeEnumRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMode();

            state._fsp--;

             after(grammarAccess.getTestConfigurationAccess().getModeModeEnumRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__ModeAssignment_4_3"


    // $ANTLR start "rule__TestConfiguration__StatementAssignment_5_3"
    // InternalEduTest.g:6472:1: rule__TestConfiguration__StatementAssignment_5_3 : ( ( RULE_ID ) ) ;
    public final void rule__TestConfiguration__StatementAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6476:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6477:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6477:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6478:3: ( RULE_ID )
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementEClassCrossReference_5_3_0()); 
            // InternalEduTest.g:6479:3: ( RULE_ID )
            // InternalEduTest.g:6480:4: RULE_ID
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementEClassIDTerminalRuleCall_5_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getStatementEClassIDTerminalRuleCall_5_3_0_1()); 

            }

             after(grammarAccess.getTestConfigurationAccess().getStatementEClassCrossReference_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__StatementAssignment_5_3"


    // $ANTLR start "rule__TestConfiguration__StatementAssignment_5_4_1"
    // InternalEduTest.g:6491:1: rule__TestConfiguration__StatementAssignment_5_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__TestConfiguration__StatementAssignment_5_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6495:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6496:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6496:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6497:3: ( RULE_ID )
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementEClassCrossReference_5_4_1_0()); 
            // InternalEduTest.g:6498:3: ( RULE_ID )
            // InternalEduTest.g:6499:4: RULE_ID
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementEClassIDTerminalRuleCall_5_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getStatementEClassIDTerminalRuleCall_5_4_1_0_1()); 

            }

             after(grammarAccess.getTestConfigurationAccess().getStatementEClassCrossReference_5_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__StatementAssignment_5_4_1"


    // $ANTLR start "rule__TestConfiguration__AnswersAssignment_6_3"
    // InternalEduTest.g:6510:1: rule__TestConfiguration__AnswersAssignment_6_3 : ( ( RULE_ID ) ) ;
    public final void rule__TestConfiguration__AnswersAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6514:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6515:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6515:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6516:3: ( RULE_ID )
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersEClassCrossReference_6_3_0()); 
            // InternalEduTest.g:6517:3: ( RULE_ID )
            // InternalEduTest.g:6518:4: RULE_ID
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersEClassIDTerminalRuleCall_6_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getAnswersEClassIDTerminalRuleCall_6_3_0_1()); 

            }

             after(grammarAccess.getTestConfigurationAccess().getAnswersEClassCrossReference_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__AnswersAssignment_6_3"


    // $ANTLR start "rule__TestConfiguration__AnswersAssignment_6_4_1"
    // InternalEduTest.g:6529:1: rule__TestConfiguration__AnswersAssignment_6_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__TestConfiguration__AnswersAssignment_6_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6533:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6534:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6534:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6535:3: ( RULE_ID )
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersEClassCrossReference_6_4_1_0()); 
            // InternalEduTest.g:6536:3: ( RULE_ID )
            // InternalEduTest.g:6537:4: RULE_ID
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersEClassIDTerminalRuleCall_6_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getAnswersEClassIDTerminalRuleCall_6_4_1_0_1()); 

            }

             after(grammarAccess.getTestConfigurationAccess().getAnswersEClassCrossReference_6_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__AnswersAssignment_6_4_1"


    // $ANTLR start "rule__MultiChoiceEmConfig__RetryAssignment_3"
    // InternalEduTest.g:6548:1: rule__MultiChoiceEmConfig__RetryAssignment_3 : ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6552:1: ( ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:6553:2: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:6553:2: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:6554:3: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:6555:3: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            // InternalEduTest.g:6555:4: rule__MultiChoiceEmConfig__RetryAlternatives_3_0
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
    // InternalEduTest.g:6563:1: rule__MultiChoiceEmConfig__WeightedAssignment_7 : ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__WeightedAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6567:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) )
            // InternalEduTest.g:6568:2: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            {
            // InternalEduTest.g:6568:2: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            // InternalEduTest.g:6569:3: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAlternatives_7_0()); 
            // InternalEduTest.g:6570:3: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            // InternalEduTest.g:6570:4: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0
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
    // InternalEduTest.g:6578:1: rule__MultiChoiceEmConfig__PenaltyAssignment_11 : ( ruleEDouble ) ;
    public final void rule__MultiChoiceEmConfig__PenaltyAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6582:1: ( ( ruleEDouble ) )
            // InternalEduTest.g:6583:2: ( ruleEDouble )
            {
            // InternalEduTest.g:6583:2: ( ruleEDouble )
            // InternalEduTest.g:6584:3: ruleEDouble
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
    // InternalEduTest.g:6593:1: rule__MultiChoiceEmConfig__OrderAssignment_15 : ( ruleOrder ) ;
    public final void rule__MultiChoiceEmConfig__OrderAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6597:1: ( ( ruleOrder ) )
            // InternalEduTest.g:6598:2: ( ruleOrder )
            {
            // InternalEduTest.g:6598:2: ( ruleOrder )
            // InternalEduTest.g:6599:3: ruleOrder
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
    // InternalEduTest.g:6608:1: rule__MultiChoiceEmConfig__ModeAssignment_19 : ( ruleMode ) ;
    public final void rule__MultiChoiceEmConfig__ModeAssignment_19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6612:1: ( ( ruleMode ) )
            // InternalEduTest.g:6613:2: ( ruleMode )
            {
            // InternalEduTest.g:6613:2: ( ruleMode )
            // InternalEduTest.g:6614:3: ruleMode
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


    // $ANTLR start "rule__MultiChoiceEmConfig__StatementAssignment_20_3"
    // InternalEduTest.g:6623:1: rule__MultiChoiceEmConfig__StatementAssignment_20_3 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmConfig__StatementAssignment_20_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6627:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6628:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6628:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6629:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassCrossReference_20_3_0()); 
            // InternalEduTest.g:6630:3: ( RULE_ID )
            // InternalEduTest.g:6631:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassIDTerminalRuleCall_20_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassIDTerminalRuleCall_20_3_0_1()); 

            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassCrossReference_20_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__StatementAssignment_20_3"


    // $ANTLR start "rule__MultiChoiceEmConfig__StatementAssignment_20_4_1"
    // InternalEduTest.g:6642:1: rule__MultiChoiceEmConfig__StatementAssignment_20_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmConfig__StatementAssignment_20_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6646:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6647:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6647:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6648:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassCrossReference_20_4_1_0()); 
            // InternalEduTest.g:6649:3: ( RULE_ID )
            // InternalEduTest.g:6650:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassIDTerminalRuleCall_20_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassIDTerminalRuleCall_20_4_1_0_1()); 

            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getStatementEClassCrossReference_20_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__StatementAssignment_20_4_1"


    // $ANTLR start "rule__MultiChoiceEmConfig__AnswersAssignment_21_3"
    // InternalEduTest.g:6661:1: rule__MultiChoiceEmConfig__AnswersAssignment_21_3 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmConfig__AnswersAssignment_21_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6665:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6666:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6666:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6667:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassCrossReference_21_3_0()); 
            // InternalEduTest.g:6668:3: ( RULE_ID )
            // InternalEduTest.g:6669:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassIDTerminalRuleCall_21_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassIDTerminalRuleCall_21_3_0_1()); 

            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassCrossReference_21_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__AnswersAssignment_21_3"


    // $ANTLR start "rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1"
    // InternalEduTest.g:6680:1: rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6684:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:6685:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:6685:2: ( ( RULE_ID ) )
            // InternalEduTest.g:6686:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassCrossReference_21_4_1_0()); 
            // InternalEduTest.g:6687:3: ( RULE_ID )
            // InternalEduTest.g:6688:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassIDTerminalRuleCall_21_4_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassIDTerminalRuleCall_21_4_1_0_1()); 

            }

             after(grammarAccess.getMultiChoiceEmConfigAccess().getAnswersEClassCrossReference_21_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmConfig__AnswersAssignment_21_4_1"


    // $ANTLR start "rule__TextConfiguration__RetryAssignment_3"
    // InternalEduTest.g:6699:1: rule__TextConfiguration__RetryAssignment_3 : ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) ) ;
    public final void rule__TextConfiguration__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6703:1: ( ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:6704:2: ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:6704:2: ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:6705:3: ( rule__TextConfiguration__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getTextConfigurationAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:6706:3: ( rule__TextConfiguration__RetryAlternatives_3_0 )
            // InternalEduTest.g:6706:4: rule__TextConfiguration__RetryAlternatives_3_0
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__RetryAlternatives_3_0();

            state._fsp--;


            }

             after(grammarAccess.getTextConfigurationAccess().getRetryAlternatives_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__RetryAssignment_3"


    // $ANTLR start "rule__TextConfiguration__ModeAssignment_4_3"
    // InternalEduTest.g:6714:1: rule__TextConfiguration__ModeAssignment_4_3 : ( ruleMode ) ;
    public final void rule__TextConfiguration__ModeAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6718:1: ( ( ruleMode ) )
            // InternalEduTest.g:6719:2: ( ruleMode )
            {
            // InternalEduTest.g:6719:2: ( ruleMode )
            // InternalEduTest.g:6720:3: ruleMode
            {
             before(grammarAccess.getTextConfigurationAccess().getModeModeEnumRuleCall_4_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMode();

            state._fsp--;

             after(grammarAccess.getTextConfigurationAccess().getModeModeEnumRuleCall_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__ModeAssignment_4_3"


    // $ANTLR start "rule__TextConfiguration__IdentifierAssignment_5_3"
    // InternalEduTest.g:6729:1: rule__TextConfiguration__IdentifierAssignment_5_3 : ( ruleEString ) ;
    public final void rule__TextConfiguration__IdentifierAssignment_5_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6733:1: ( ( ruleEString ) )
            // InternalEduTest.g:6734:2: ( ruleEString )
            {
            // InternalEduTest.g:6734:2: ( ruleEString )
            // InternalEduTest.g:6735:3: ruleEString
            {
             before(grammarAccess.getTextConfigurationAccess().getIdentifierEStringParserRuleCall_5_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTextConfigurationAccess().getIdentifierEStringParserRuleCall_5_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__IdentifierAssignment_5_3"


    // $ANTLR start "rule__Test__SourceAssignment_2"
    // InternalEduTest.g:6744:1: rule__Test__SourceAssignment_2 : ( ruleEString ) ;
    public final void rule__Test__SourceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6748:1: ( ( ruleEString ) )
            // InternalEduTest.g:6749:2: ( ruleEString )
            {
            // InternalEduTest.g:6749:2: ( ruleEString )
            // InternalEduTest.g:6750:3: ruleEString
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
    // InternalEduTest.g:6759:1: rule__Test__QuestionAssignment_4 : ( ruleEString ) ;
    public final void rule__Test__QuestionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6763:1: ( ( ruleEString ) )
            // InternalEduTest.g:6764:2: ( ruleEString )
            {
            // InternalEduTest.g:6764:2: ( ruleEString )
            // InternalEduTest.g:6765:3: ruleEString
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
    // InternalEduTest.g:6774:1: rule__Test__ExpressionAssignment_5_0 : ( ( '%text' ) ) ;
    public final void rule__Test__ExpressionAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6778:1: ( ( ( '%text' ) ) )
            // InternalEduTest.g:6779:2: ( ( '%text' ) )
            {
            // InternalEduTest.g:6779:2: ( ( '%text' ) )
            // InternalEduTest.g:6780:3: ( '%text' )
            {
             before(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 
            // InternalEduTest.g:6781:3: ( '%text' )
            // InternalEduTest.g:6782:4: '%text'
            {
             before(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 
            match(input,52,FOLLOW_2); 
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
    // InternalEduTest.g:6793:1: rule__Test__IdentifierAssignment_5_1_1 : ( ruleEString ) ;
    public final void rule__Test__IdentifierAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:6797:1: ( ( ruleEString ) )
            // InternalEduTest.g:6798:2: ( ruleEString )
            {
            // InternalEduTest.g:6798:2: ( ruleEString )
            // InternalEduTest.g:6799:3: ruleEString
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000001FE2000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000001FE2000002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000400008000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x000C000000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0004000000000040L});

}