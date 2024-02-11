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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'yes'", "'no'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'", "'AlternativeResponse'", "'{'", "'}'", "','", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'MatchPairs'", "'MissingWords'", "'MultiChoiceText'", "'AlternativeTextResponse'", "'DragAndDropText'", "'navigation'", "'='", "'retry'", "'mode'", "'statement'", "'('", "')'", "'answers'", "'weighted'", "'penalty'", "'order'", "'text'", "'description'", "'for'", "'-'", "'.'", "'%text'"
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


    // $ANTLR start "entryRuleMultiChoiceText"
    // InternalEduTest.g:228:1: entryRuleMultiChoiceText : ruleMultiChoiceText EOF ;
    public final void entryRuleMultiChoiceText() throws RecognitionException {
        try {
            // InternalEduTest.g:229:1: ( ruleMultiChoiceText EOF )
            // InternalEduTest.g:230:1: ruleMultiChoiceText EOF
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
    // InternalEduTest.g:237:1: ruleMultiChoiceText : ( ( rule__MultiChoiceText__Group__0 ) ) ;
    public final void ruleMultiChoiceText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:241:2: ( ( ( rule__MultiChoiceText__Group__0 ) ) )
            // InternalEduTest.g:242:2: ( ( rule__MultiChoiceText__Group__0 ) )
            {
            // InternalEduTest.g:242:2: ( ( rule__MultiChoiceText__Group__0 ) )
            // InternalEduTest.g:243:3: ( rule__MultiChoiceText__Group__0 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getGroup()); 
            // InternalEduTest.g:244:3: ( rule__MultiChoiceText__Group__0 )
            // InternalEduTest.g:244:4: rule__MultiChoiceText__Group__0
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
    // InternalEduTest.g:253:1: entryRuleAlternativeText : ruleAlternativeText EOF ;
    public final void entryRuleAlternativeText() throws RecognitionException {
        try {
            // InternalEduTest.g:254:1: ( ruleAlternativeText EOF )
            // InternalEduTest.g:255:1: ruleAlternativeText EOF
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
    // InternalEduTest.g:262:1: ruleAlternativeText : ( ( rule__AlternativeText__Group__0 ) ) ;
    public final void ruleAlternativeText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:266:2: ( ( ( rule__AlternativeText__Group__0 ) ) )
            // InternalEduTest.g:267:2: ( ( rule__AlternativeText__Group__0 ) )
            {
            // InternalEduTest.g:267:2: ( ( rule__AlternativeText__Group__0 ) )
            // InternalEduTest.g:268:3: ( rule__AlternativeText__Group__0 )
            {
             before(grammarAccess.getAlternativeTextAccess().getGroup()); 
            // InternalEduTest.g:269:3: ( rule__AlternativeText__Group__0 )
            // InternalEduTest.g:269:4: rule__AlternativeText__Group__0
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
    // InternalEduTest.g:278:1: entryRuleDragAndDropText : ruleDragAndDropText EOF ;
    public final void entryRuleDragAndDropText() throws RecognitionException {
        try {
            // InternalEduTest.g:279:1: ( ruleDragAndDropText EOF )
            // InternalEduTest.g:280:1: ruleDragAndDropText EOF
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
    // InternalEduTest.g:287:1: ruleDragAndDropText : ( ( rule__DragAndDropText__Group__0 ) ) ;
    public final void ruleDragAndDropText() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:291:2: ( ( ( rule__DragAndDropText__Group__0 ) ) )
            // InternalEduTest.g:292:2: ( ( rule__DragAndDropText__Group__0 ) )
            {
            // InternalEduTest.g:292:2: ( ( rule__DragAndDropText__Group__0 ) )
            // InternalEduTest.g:293:3: ( rule__DragAndDropText__Group__0 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getGroup()); 
            // InternalEduTest.g:294:3: ( rule__DragAndDropText__Group__0 )
            // InternalEduTest.g:294:4: rule__DragAndDropText__Group__0
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
    // InternalEduTest.g:303:1: entryRuleProgramConfiguration : ruleProgramConfiguration EOF ;
    public final void entryRuleProgramConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:304:1: ( ruleProgramConfiguration EOF )
            // InternalEduTest.g:305:1: ruleProgramConfiguration EOF
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
    // InternalEduTest.g:312:1: ruleProgramConfiguration : ( ( rule__ProgramConfiguration__Group__0 ) ) ;
    public final void ruleProgramConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:316:2: ( ( ( rule__ProgramConfiguration__Group__0 ) ) )
            // InternalEduTest.g:317:2: ( ( rule__ProgramConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:317:2: ( ( rule__ProgramConfiguration__Group__0 ) )
            // InternalEduTest.g:318:3: ( rule__ProgramConfiguration__Group__0 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getGroup()); 
            // InternalEduTest.g:319:3: ( rule__ProgramConfiguration__Group__0 )
            // InternalEduTest.g:319:4: rule__ProgramConfiguration__Group__0
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
    // InternalEduTest.g:328:1: entryRuleTestConfiguration : ruleTestConfiguration EOF ;
    public final void entryRuleTestConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:329:1: ( ruleTestConfiguration EOF )
            // InternalEduTest.g:330:1: ruleTestConfiguration EOF
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
    // InternalEduTest.g:337:1: ruleTestConfiguration : ( ( rule__TestConfiguration__Group__0 ) ) ;
    public final void ruleTestConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:341:2: ( ( ( rule__TestConfiguration__Group__0 ) ) )
            // InternalEduTest.g:342:2: ( ( rule__TestConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:342:2: ( ( rule__TestConfiguration__Group__0 ) )
            // InternalEduTest.g:343:3: ( rule__TestConfiguration__Group__0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup()); 
            // InternalEduTest.g:344:3: ( rule__TestConfiguration__Group__0 )
            // InternalEduTest.g:344:4: rule__TestConfiguration__Group__0
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
    // InternalEduTest.g:353:1: entryRuleMultiChoiceEmConfig : ruleMultiChoiceEmConfig EOF ;
    public final void entryRuleMultiChoiceEmConfig() throws RecognitionException {
        try {
            // InternalEduTest.g:354:1: ( ruleMultiChoiceEmConfig EOF )
            // InternalEduTest.g:355:1: ruleMultiChoiceEmConfig EOF
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
    // InternalEduTest.g:362:1: ruleMultiChoiceEmConfig : ( ( rule__MultiChoiceEmConfig__Group__0 ) ) ;
    public final void ruleMultiChoiceEmConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:366:2: ( ( ( rule__MultiChoiceEmConfig__Group__0 ) ) )
            // InternalEduTest.g:367:2: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            {
            // InternalEduTest.g:367:2: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            // InternalEduTest.g:368:3: ( rule__MultiChoiceEmConfig__Group__0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup()); 
            // InternalEduTest.g:369:3: ( rule__MultiChoiceEmConfig__Group__0 )
            // InternalEduTest.g:369:4: rule__MultiChoiceEmConfig__Group__0
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
    // InternalEduTest.g:378:1: entryRuleTextConfiguration : ruleTextConfiguration EOF ;
    public final void entryRuleTextConfiguration() throws RecognitionException {
        try {
            // InternalEduTest.g:379:1: ( ruleTextConfiguration EOF )
            // InternalEduTest.g:380:1: ruleTextConfiguration EOF
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
    // InternalEduTest.g:387:1: ruleTextConfiguration : ( ( rule__TextConfiguration__Group__0 ) ) ;
    public final void ruleTextConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:391:2: ( ( ( rule__TextConfiguration__Group__0 ) ) )
            // InternalEduTest.g:392:2: ( ( rule__TextConfiguration__Group__0 ) )
            {
            // InternalEduTest.g:392:2: ( ( rule__TextConfiguration__Group__0 ) )
            // InternalEduTest.g:393:3: ( rule__TextConfiguration__Group__0 )
            {
             before(grammarAccess.getTextConfigurationAccess().getGroup()); 
            // InternalEduTest.g:394:3: ( rule__TextConfiguration__Group__0 )
            // InternalEduTest.g:394:4: rule__TextConfiguration__Group__0
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
    // InternalEduTest.g:403:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // InternalEduTest.g:404:1: ( ruleTest EOF )
            // InternalEduTest.g:405:1: ruleTest EOF
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
    // InternalEduTest.g:412:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
    public final void ruleTest() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:416:2: ( ( ( rule__Test__Group__0 ) ) )
            // InternalEduTest.g:417:2: ( ( rule__Test__Group__0 ) )
            {
            // InternalEduTest.g:417:2: ( ( rule__Test__Group__0 ) )
            // InternalEduTest.g:418:3: ( rule__Test__Group__0 )
            {
             before(grammarAccess.getTestAccess().getGroup()); 
            // InternalEduTest.g:419:3: ( rule__Test__Group__0 )
            // InternalEduTest.g:419:4: rule__Test__Group__0
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
    // InternalEduTest.g:428:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalEduTest.g:429:1: ( ruleEString EOF )
            // InternalEduTest.g:430:1: ruleEString EOF
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
    // InternalEduTest.g:437:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:441:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalEduTest.g:442:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalEduTest.g:442:2: ( ( rule__EString__Alternatives ) )
            // InternalEduTest.g:443:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalEduTest.g:444:3: ( rule__EString__Alternatives )
            // InternalEduTest.g:444:4: rule__EString__Alternatives
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
    // InternalEduTest.g:453:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // InternalEduTest.g:454:1: ( ruleEDouble EOF )
            // InternalEduTest.g:455:1: ruleEDouble EOF
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
    // InternalEduTest.g:462:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:466:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // InternalEduTest.g:467:2: ( ( rule__EDouble__Group__0 ) )
            {
            // InternalEduTest.g:467:2: ( ( rule__EDouble__Group__0 ) )
            // InternalEduTest.g:468:3: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // InternalEduTest.g:469:3: ( rule__EDouble__Group__0 )
            // InternalEduTest.g:469:4: rule__EDouble__Group__0
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
    // InternalEduTest.g:478:1: ruleOrder : ( ( rule__Order__Alternatives ) ) ;
    public final void ruleOrder() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:482:1: ( ( ( rule__Order__Alternatives ) ) )
            // InternalEduTest.g:483:2: ( ( rule__Order__Alternatives ) )
            {
            // InternalEduTest.g:483:2: ( ( rule__Order__Alternatives ) )
            // InternalEduTest.g:484:3: ( rule__Order__Alternatives )
            {
             before(grammarAccess.getOrderAccess().getAlternatives()); 
            // InternalEduTest.g:485:3: ( rule__Order__Alternatives )
            // InternalEduTest.g:485:4: rule__Order__Alternatives
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
    // InternalEduTest.g:494:1: ruleMode : ( ( rule__Mode__Alternatives ) ) ;
    public final void ruleMode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:498:1: ( ( ( rule__Mode__Alternatives ) ) )
            // InternalEduTest.g:499:2: ( ( rule__Mode__Alternatives ) )
            {
            // InternalEduTest.g:499:2: ( ( rule__Mode__Alternatives ) )
            // InternalEduTest.g:500:3: ( rule__Mode__Alternatives )
            {
             before(grammarAccess.getModeAccess().getAlternatives()); 
            // InternalEduTest.g:501:3: ( rule__Mode__Alternatives )
            // InternalEduTest.g:501:4: rule__Mode__Alternatives
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
    // InternalEduTest.g:510:1: ruleNavigation : ( ( rule__Navigation__Alternatives ) ) ;
    public final void ruleNavigation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:514:1: ( ( ( rule__Navigation__Alternatives ) ) )
            // InternalEduTest.g:515:2: ( ( rule__Navigation__Alternatives ) )
            {
            // InternalEduTest.g:515:2: ( ( rule__Navigation__Alternatives ) )
            // InternalEduTest.g:516:3: ( rule__Navigation__Alternatives )
            {
             before(grammarAccess.getNavigationAccess().getAlternatives()); 
            // InternalEduTest.g:517:3: ( rule__Navigation__Alternatives )
            // InternalEduTest.g:517:4: rule__Navigation__Alternatives
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
    // InternalEduTest.g:525:1: rule__MutatorTests__Alternatives : ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) | ( ruleMatchPairs ) | ( ruleMissingWords ) | ( ruleMultiChoiceText ) | ( ruleAlternativeText ) | ( ruleDragAndDropText ) );
    public final void rule__MutatorTests__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:529:1: ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) | ( ruleMatchPairs ) | ( ruleMissingWords ) | ( ruleMultiChoiceText ) | ( ruleAlternativeText ) | ( ruleDragAndDropText ) )
            int alt1=8;
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
            case 31:
                {
                alt1=6;
                }
                break;
            case 32:
                {
                alt1=7;
                }
                break;
            case 33:
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
                    // InternalEduTest.g:530:2: ( ruleAlternativeResponse )
                    {
                    // InternalEduTest.g:530:2: ( ruleAlternativeResponse )
                    // InternalEduTest.g:531:3: ruleAlternativeResponse
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
                    // InternalEduTest.g:536:2: ( ruleMultiChoiceDiagram )
                    {
                    // InternalEduTest.g:536:2: ( ruleMultiChoiceDiagram )
                    // InternalEduTest.g:537:3: ruleMultiChoiceDiagram
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
                    // InternalEduTest.g:542:2: ( ruleMultiChoiceEmendation )
                    {
                    // InternalEduTest.g:542:2: ( ruleMultiChoiceEmendation )
                    // InternalEduTest.g:543:3: ruleMultiChoiceEmendation
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
                    // InternalEduTest.g:548:2: ( ruleMatchPairs )
                    {
                    // InternalEduTest.g:548:2: ( ruleMatchPairs )
                    // InternalEduTest.g:549:3: ruleMatchPairs
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
                    // InternalEduTest.g:554:2: ( ruleMissingWords )
                    {
                    // InternalEduTest.g:554:2: ( ruleMissingWords )
                    // InternalEduTest.g:555:3: ruleMissingWords
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
                    // InternalEduTest.g:560:2: ( ruleMultiChoiceText )
                    {
                    // InternalEduTest.g:560:2: ( ruleMultiChoiceText )
                    // InternalEduTest.g:561:3: ruleMultiChoiceText
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
                    // InternalEduTest.g:566:2: ( ruleAlternativeText )
                    {
                    // InternalEduTest.g:566:2: ( ruleAlternativeText )
                    // InternalEduTest.g:567:3: ruleAlternativeText
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
                    // InternalEduTest.g:572:2: ( ruleDragAndDropText )
                    {
                    // InternalEduTest.g:572:2: ( ruleDragAndDropText )
                    // InternalEduTest.g:573:3: ruleDragAndDropText
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
    // InternalEduTest.g:582:1: rule__TestConfiguration__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__TestConfiguration__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:586:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:587:2: ( 'yes' )
                    {
                    // InternalEduTest.g:587:2: ( 'yes' )
                    // InternalEduTest.g:588:3: 'yes'
                    {
                     before(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:593:2: ( 'no' )
                    {
                    // InternalEduTest.g:593:2: ( 'no' )
                    // InternalEduTest.g:594:3: 'no'
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
    // InternalEduTest.g:603:1: rule__MultiChoiceEmConfig__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:607:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:608:2: ( 'yes' )
                    {
                    // InternalEduTest.g:608:2: ( 'yes' )
                    // InternalEduTest.g:609:3: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:614:2: ( 'no' )
                    {
                    // InternalEduTest.g:614:2: ( 'no' )
                    // InternalEduTest.g:615:3: 'no'
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
    // InternalEduTest.g:624:1: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__WeightedAlternatives_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:628:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:629:2: ( 'yes' )
                    {
                    // InternalEduTest.g:629:2: ( 'yes' )
                    // InternalEduTest.g:630:3: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:635:2: ( 'no' )
                    {
                    // InternalEduTest.g:635:2: ( 'no' )
                    // InternalEduTest.g:636:3: 'no'
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
    // InternalEduTest.g:645:1: rule__TextConfiguration__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__TextConfiguration__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:649:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // InternalEduTest.g:650:2: ( 'yes' )
                    {
                    // InternalEduTest.g:650:2: ( 'yes' )
                    // InternalEduTest.g:651:3: 'yes'
                    {
                     before(grammarAccess.getTextConfigurationAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTextConfigurationAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:656:2: ( 'no' )
                    {
                    // InternalEduTest.g:656:2: ( 'no' )
                    // InternalEduTest.g:657:3: 'no'
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
    // InternalEduTest.g:666:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:670:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalEduTest.g:671:2: ( RULE_STRING )
                    {
                    // InternalEduTest.g:671:2: ( RULE_STRING )
                    // InternalEduTest.g:672:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:677:2: ( RULE_ID )
                    {
                    // InternalEduTest.g:677:2: ( RULE_ID )
                    // InternalEduTest.g:678:3: RULE_ID
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
    // InternalEduTest.g:687:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:691:1: ( ( 'E' ) | ( 'e' ) )
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
                    // InternalEduTest.g:692:2: ( 'E' )
                    {
                    // InternalEduTest.g:692:2: ( 'E' )
                    // InternalEduTest.g:693:3: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:698:2: ( 'e' )
                    {
                    // InternalEduTest.g:698:2: ( 'e' )
                    // InternalEduTest.g:699:3: 'e'
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
    // InternalEduTest.g:708:1: rule__Order__Alternatives : ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) );
    public final void rule__Order__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:712:1: ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) )
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
                    // InternalEduTest.g:713:2: ( ( 'fixed' ) )
                    {
                    // InternalEduTest.g:713:2: ( ( 'fixed' ) )
                    // InternalEduTest.g:714:3: ( 'fixed' )
                    {
                     before(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:715:3: ( 'fixed' )
                    // InternalEduTest.g:715:4: 'fixed'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:719:2: ( ( 'random' ) )
                    {
                    // InternalEduTest.g:719:2: ( ( 'random' ) )
                    // InternalEduTest.g:720:3: ( 'random' )
                    {
                     before(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:721:3: ( 'random' )
                    // InternalEduTest.g:721:4: 'random'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalEduTest.g:725:2: ( ( 'options-ascending' ) )
                    {
                    // InternalEduTest.g:725:2: ( ( 'options-ascending' ) )
                    // InternalEduTest.g:726:3: ( 'options-ascending' )
                    {
                     before(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 
                    // InternalEduTest.g:727:3: ( 'options-ascending' )
                    // InternalEduTest.g:727:4: 'options-ascending'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalEduTest.g:731:2: ( ( 'options-descending' ) )
                    {
                    // InternalEduTest.g:731:2: ( ( 'options-descending' ) )
                    // InternalEduTest.g:732:3: ( 'options-descending' )
                    {
                     before(grammarAccess.getOrderAccess().getDescendingEnumLiteralDeclaration_3()); 
                    // InternalEduTest.g:733:3: ( 'options-descending' )
                    // InternalEduTest.g:733:4: 'options-descending'
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
    // InternalEduTest.g:741:1: rule__Mode__Alternatives : ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) );
    public final void rule__Mode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:745:1: ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) )
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
                    // InternalEduTest.g:746:2: ( ( 'radiobutton' ) )
                    {
                    // InternalEduTest.g:746:2: ( ( 'radiobutton' ) )
                    // InternalEduTest.g:747:3: ( 'radiobutton' )
                    {
                     before(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:748:3: ( 'radiobutton' )
                    // InternalEduTest.g:748:4: 'radiobutton'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:752:2: ( ( 'checkbox' ) )
                    {
                    // InternalEduTest.g:752:2: ( ( 'checkbox' ) )
                    // InternalEduTest.g:753:3: ( 'checkbox' )
                    {
                     before(grammarAccess.getModeAccess().getCheckboxEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:754:3: ( 'checkbox' )
                    // InternalEduTest.g:754:4: 'checkbox'
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
    // InternalEduTest.g:762:1: rule__Navigation__Alternatives : ( ( ( 'free' ) ) | ( ( 'locked' ) ) );
    public final void rule__Navigation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:766:1: ( ( ( 'free' ) ) | ( ( 'locked' ) ) )
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
                    // InternalEduTest.g:767:2: ( ( 'free' ) )
                    {
                    // InternalEduTest.g:767:2: ( ( 'free' ) )
                    // InternalEduTest.g:768:3: ( 'free' )
                    {
                     before(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 
                    // InternalEduTest.g:769:3: ( 'free' )
                    // InternalEduTest.g:769:4: 'free'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalEduTest.g:773:2: ( ( 'locked' ) )
                    {
                    // InternalEduTest.g:773:2: ( ( 'locked' ) )
                    // InternalEduTest.g:774:3: ( 'locked' )
                    {
                     before(grammarAccess.getNavigationAccess().getLockedEnumLiteralDeclaration_1()); 
                    // InternalEduTest.g:775:3: ( 'locked' )
                    // InternalEduTest.g:775:4: 'locked'
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
    // InternalEduTest.g:783:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:787:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // InternalEduTest.g:788:2: rule__Program__Group__0__Impl rule__Program__Group__1
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
    // InternalEduTest.g:795:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:799:1: ( ( () ) )
            // InternalEduTest.g:800:1: ( () )
            {
            // InternalEduTest.g:800:1: ( () )
            // InternalEduTest.g:801:2: ()
            {
             before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            // InternalEduTest.g:802:2: ()
            // InternalEduTest.g:802:3: 
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
    // InternalEduTest.g:810:1: rule__Program__Group__1 : rule__Program__Group__1__Impl rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:814:1: ( rule__Program__Group__1__Impl rule__Program__Group__2 )
            // InternalEduTest.g:815:2: rule__Program__Group__1__Impl rule__Program__Group__2
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
    // InternalEduTest.g:822:1: rule__Program__Group__1__Impl : ( ( rule__Program__ConfigAssignment_1 )? ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:826:1: ( ( ( rule__Program__ConfigAssignment_1 )? ) )
            // InternalEduTest.g:827:1: ( ( rule__Program__ConfigAssignment_1 )? )
            {
            // InternalEduTest.g:827:1: ( ( rule__Program__ConfigAssignment_1 )? )
            // InternalEduTest.g:828:2: ( rule__Program__ConfigAssignment_1 )?
            {
             before(grammarAccess.getProgramAccess().getConfigAssignment_1()); 
            // InternalEduTest.g:829:2: ( rule__Program__ConfigAssignment_1 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==34) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalEduTest.g:829:3: rule__Program__ConfigAssignment_1
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
    // InternalEduTest.g:837:1: rule__Program__Group__2 : rule__Program__Group__2__Impl ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:841:1: ( rule__Program__Group__2__Impl )
            // InternalEduTest.g:842:2: rule__Program__Group__2__Impl
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
    // InternalEduTest.g:848:1: rule__Program__Group__2__Impl : ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) ) ;
    public final void rule__Program__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:852:1: ( ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) ) )
            // InternalEduTest.g:853:1: ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) )
            {
            // InternalEduTest.g:853:1: ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) )
            // InternalEduTest.g:854:2: ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* )
            {
            // InternalEduTest.g:854:2: ( ( rule__Program__ExercisesAssignment_2 ) )
            // InternalEduTest.g:855:3: ( rule__Program__ExercisesAssignment_2 )
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 
            // InternalEduTest.g:856:3: ( rule__Program__ExercisesAssignment_2 )
            // InternalEduTest.g:856:4: rule__Program__ExercisesAssignment_2
            {
            pushFollow(FOLLOW_4);
            rule__Program__ExercisesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 

            }

            // InternalEduTest.g:859:2: ( ( rule__Program__ExercisesAssignment_2 )* )
            // InternalEduTest.g:860:3: ( rule__Program__ExercisesAssignment_2 )*
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 
            // InternalEduTest.g:861:3: ( rule__Program__ExercisesAssignment_2 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==23||(LA12_0>=27 && LA12_0<=33)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalEduTest.g:861:4: rule__Program__ExercisesAssignment_2
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Program__ExercisesAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // InternalEduTest.g:871:1: rule__AlternativeResponse__Group__0 : rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 ;
    public final void rule__AlternativeResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:875:1: ( rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 )
            // InternalEduTest.g:876:2: rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1
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
    // InternalEduTest.g:883:1: rule__AlternativeResponse__Group__0__Impl : ( 'AlternativeResponse' ) ;
    public final void rule__AlternativeResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:887:1: ( ( 'AlternativeResponse' ) )
            // InternalEduTest.g:888:1: ( 'AlternativeResponse' )
            {
            // InternalEduTest.g:888:1: ( 'AlternativeResponse' )
            // InternalEduTest.g:889:2: 'AlternativeResponse'
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
    // InternalEduTest.g:898:1: rule__AlternativeResponse__Group__1 : rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 ;
    public final void rule__AlternativeResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:902:1: ( rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 )
            // InternalEduTest.g:903:2: rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2
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
    // InternalEduTest.g:910:1: rule__AlternativeResponse__Group__1__Impl : ( ( rule__AlternativeResponse__Group_1__0 )? ) ;
    public final void rule__AlternativeResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:914:1: ( ( ( rule__AlternativeResponse__Group_1__0 )? ) )
            // InternalEduTest.g:915:1: ( ( rule__AlternativeResponse__Group_1__0 )? )
            {
            // InternalEduTest.g:915:1: ( ( rule__AlternativeResponse__Group_1__0 )? )
            // InternalEduTest.g:916:2: ( rule__AlternativeResponse__Group_1__0 )?
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup_1()); 
            // InternalEduTest.g:917:2: ( rule__AlternativeResponse__Group_1__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalEduTest.g:917:3: rule__AlternativeResponse__Group_1__0
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
    // InternalEduTest.g:925:1: rule__AlternativeResponse__Group__2 : rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 ;
    public final void rule__AlternativeResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:929:1: ( rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 )
            // InternalEduTest.g:930:2: rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3
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
    // InternalEduTest.g:937:1: rule__AlternativeResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__AlternativeResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:941:1: ( ( '{' ) )
            // InternalEduTest.g:942:1: ( '{' )
            {
            // InternalEduTest.g:942:1: ( '{' )
            // InternalEduTest.g:943:2: '{'
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
    // InternalEduTest.g:952:1: rule__AlternativeResponse__Group__3 : rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 ;
    public final void rule__AlternativeResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:956:1: ( rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 )
            // InternalEduTest.g:957:2: rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4
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
    // InternalEduTest.g:964:1: rule__AlternativeResponse__Group__3__Impl : ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) ;
    public final void rule__AlternativeResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:968:1: ( ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:969:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:969:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            // InternalEduTest.g:970:2: ( rule__AlternativeResponse__ConfigAssignment_3 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:971:2: ( rule__AlternativeResponse__ConfigAssignment_3 )
            // InternalEduTest.g:971:3: rule__AlternativeResponse__ConfigAssignment_3
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
    // InternalEduTest.g:979:1: rule__AlternativeResponse__Group__4 : rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 ;
    public final void rule__AlternativeResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:983:1: ( rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 )
            // InternalEduTest.g:984:2: rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5
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
    // InternalEduTest.g:991:1: rule__AlternativeResponse__Group__4__Impl : ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) ;
    public final void rule__AlternativeResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:995:1: ( ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) )
            // InternalEduTest.g:996:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:996:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            // InternalEduTest.g:997:2: ( rule__AlternativeResponse__TestsAssignment_4 )*
            {
             before(grammarAccess.getAlternativeResponseAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:998:2: ( rule__AlternativeResponse__TestsAssignment_4 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==46) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalEduTest.g:998:3: rule__AlternativeResponse__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__AlternativeResponse__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // InternalEduTest.g:1006:1: rule__AlternativeResponse__Group__5 : rule__AlternativeResponse__Group__5__Impl ;
    public final void rule__AlternativeResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1010:1: ( rule__AlternativeResponse__Group__5__Impl )
            // InternalEduTest.g:1011:2: rule__AlternativeResponse__Group__5__Impl
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
    // InternalEduTest.g:1017:1: rule__AlternativeResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__AlternativeResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1021:1: ( ( '}' ) )
            // InternalEduTest.g:1022:1: ( '}' )
            {
            // InternalEduTest.g:1022:1: ( '}' )
            // InternalEduTest.g:1023:2: '}'
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
    // InternalEduTest.g:1033:1: rule__AlternativeResponse__Group_1__0 : rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1 ;
    public final void rule__AlternativeResponse__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1037:1: ( rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1 )
            // InternalEduTest.g:1038:2: rule__AlternativeResponse__Group_1__0__Impl rule__AlternativeResponse__Group_1__1
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
    // InternalEduTest.g:1045:1: rule__AlternativeResponse__Group_1__0__Impl : ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) ) ;
    public final void rule__AlternativeResponse__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1049:1: ( ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1050:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1050:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1051:2: ( rule__AlternativeResponse__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1052:2: ( rule__AlternativeResponse__BlocksAssignment_1_0 )
            // InternalEduTest.g:1052:3: rule__AlternativeResponse__BlocksAssignment_1_0
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
    // InternalEduTest.g:1060:1: rule__AlternativeResponse__Group_1__1 : rule__AlternativeResponse__Group_1__1__Impl ;
    public final void rule__AlternativeResponse__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1064:1: ( rule__AlternativeResponse__Group_1__1__Impl )
            // InternalEduTest.g:1065:2: rule__AlternativeResponse__Group_1__1__Impl
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
    // InternalEduTest.g:1071:1: rule__AlternativeResponse__Group_1__1__Impl : ( ( rule__AlternativeResponse__Group_1_1__0 )* ) ;
    public final void rule__AlternativeResponse__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1075:1: ( ( ( rule__AlternativeResponse__Group_1_1__0 )* ) )
            // InternalEduTest.g:1076:1: ( ( rule__AlternativeResponse__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1076:1: ( ( rule__AlternativeResponse__Group_1_1__0 )* )
            // InternalEduTest.g:1077:2: ( rule__AlternativeResponse__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup_1_1()); 
            // InternalEduTest.g:1078:2: ( rule__AlternativeResponse__Group_1_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==26) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalEduTest.g:1078:3: rule__AlternativeResponse__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__AlternativeResponse__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // InternalEduTest.g:1087:1: rule__AlternativeResponse__Group_1_1__0 : rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1 ;
    public final void rule__AlternativeResponse__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1091:1: ( rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1 )
            // InternalEduTest.g:1092:2: rule__AlternativeResponse__Group_1_1__0__Impl rule__AlternativeResponse__Group_1_1__1
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
    // InternalEduTest.g:1099:1: rule__AlternativeResponse__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__AlternativeResponse__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1103:1: ( ( ',' ) )
            // InternalEduTest.g:1104:1: ( ',' )
            {
            // InternalEduTest.g:1104:1: ( ',' )
            // InternalEduTest.g:1105:2: ','
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
    // InternalEduTest.g:1114:1: rule__AlternativeResponse__Group_1_1__1 : rule__AlternativeResponse__Group_1_1__1__Impl ;
    public final void rule__AlternativeResponse__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1118:1: ( rule__AlternativeResponse__Group_1_1__1__Impl )
            // InternalEduTest.g:1119:2: rule__AlternativeResponse__Group_1_1__1__Impl
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
    // InternalEduTest.g:1125:1: rule__AlternativeResponse__Group_1_1__1__Impl : ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__AlternativeResponse__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1129:1: ( ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1130:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1130:1: ( ( rule__AlternativeResponse__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1131:2: ( rule__AlternativeResponse__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1132:2: ( rule__AlternativeResponse__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:1132:3: rule__AlternativeResponse__BlocksAssignment_1_1_1
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
    // InternalEduTest.g:1141:1: rule__MultiChoiceDiagram__Group__0 : rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 ;
    public final void rule__MultiChoiceDiagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1145:1: ( rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 )
            // InternalEduTest.g:1146:2: rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1
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
    // InternalEduTest.g:1153:1: rule__MultiChoiceDiagram__Group__0__Impl : ( 'MultiChoiceDiagram' ) ;
    public final void rule__MultiChoiceDiagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1157:1: ( ( 'MultiChoiceDiagram' ) )
            // InternalEduTest.g:1158:1: ( 'MultiChoiceDiagram' )
            {
            // InternalEduTest.g:1158:1: ( 'MultiChoiceDiagram' )
            // InternalEduTest.g:1159:2: 'MultiChoiceDiagram'
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
    // InternalEduTest.g:1168:1: rule__MultiChoiceDiagram__Group__1 : rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 ;
    public final void rule__MultiChoiceDiagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1172:1: ( rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 )
            // InternalEduTest.g:1173:2: rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2
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
    // InternalEduTest.g:1180:1: rule__MultiChoiceDiagram__Group__1__Impl : ( ( rule__MultiChoiceDiagram__Group_1__0 )? ) ;
    public final void rule__MultiChoiceDiagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1184:1: ( ( ( rule__MultiChoiceDiagram__Group_1__0 )? ) )
            // InternalEduTest.g:1185:1: ( ( rule__MultiChoiceDiagram__Group_1__0 )? )
            {
            // InternalEduTest.g:1185:1: ( ( rule__MultiChoiceDiagram__Group_1__0 )? )
            // InternalEduTest.g:1186:2: ( rule__MultiChoiceDiagram__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1()); 
            // InternalEduTest.g:1187:2: ( rule__MultiChoiceDiagram__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalEduTest.g:1187:3: rule__MultiChoiceDiagram__Group_1__0
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
    // InternalEduTest.g:1195:1: rule__MultiChoiceDiagram__Group__2 : rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 ;
    public final void rule__MultiChoiceDiagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1199:1: ( rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 )
            // InternalEduTest.g:1200:2: rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3
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
    // InternalEduTest.g:1207:1: rule__MultiChoiceDiagram__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceDiagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1211:1: ( ( '{' ) )
            // InternalEduTest.g:1212:1: ( '{' )
            {
            // InternalEduTest.g:1212:1: ( '{' )
            // InternalEduTest.g:1213:2: '{'
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
    // InternalEduTest.g:1222:1: rule__MultiChoiceDiagram__Group__3 : rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 ;
    public final void rule__MultiChoiceDiagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1226:1: ( rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 )
            // InternalEduTest.g:1227:2: rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4
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
    // InternalEduTest.g:1234:1: rule__MultiChoiceDiagram__Group__3__Impl : ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceDiagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1238:1: ( ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1239:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1239:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            // InternalEduTest.g:1240:2: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1241:2: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            // InternalEduTest.g:1241:3: rule__MultiChoiceDiagram__ConfigAssignment_3
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
    // InternalEduTest.g:1249:1: rule__MultiChoiceDiagram__Group__4 : rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 ;
    public final void rule__MultiChoiceDiagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1253:1: ( rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 )
            // InternalEduTest.g:1254:2: rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5
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
    // InternalEduTest.g:1261:1: rule__MultiChoiceDiagram__Group__4__Impl : ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceDiagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1265:1: ( ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1266:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1266:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            // InternalEduTest.g:1267:2: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1268:2: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==46) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalEduTest.g:1268:3: rule__MultiChoiceDiagram__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MultiChoiceDiagram__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalEduTest.g:1276:1: rule__MultiChoiceDiagram__Group__5 : rule__MultiChoiceDiagram__Group__5__Impl ;
    public final void rule__MultiChoiceDiagram__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1280:1: ( rule__MultiChoiceDiagram__Group__5__Impl )
            // InternalEduTest.g:1281:2: rule__MultiChoiceDiagram__Group__5__Impl
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
    // InternalEduTest.g:1287:1: rule__MultiChoiceDiagram__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceDiagram__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1291:1: ( ( '}' ) )
            // InternalEduTest.g:1292:1: ( '}' )
            {
            // InternalEduTest.g:1292:1: ( '}' )
            // InternalEduTest.g:1293:2: '}'
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
    // InternalEduTest.g:1303:1: rule__MultiChoiceDiagram__Group_1__0 : rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1 ;
    public final void rule__MultiChoiceDiagram__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1307:1: ( rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1 )
            // InternalEduTest.g:1308:2: rule__MultiChoiceDiagram__Group_1__0__Impl rule__MultiChoiceDiagram__Group_1__1
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
    // InternalEduTest.g:1315:1: rule__MultiChoiceDiagram__Group_1__0__Impl : ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceDiagram__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1319:1: ( ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1320:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1320:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1321:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1322:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_0 )
            // InternalEduTest.g:1322:3: rule__MultiChoiceDiagram__BlocksAssignment_1_0
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
    // InternalEduTest.g:1330:1: rule__MultiChoiceDiagram__Group_1__1 : rule__MultiChoiceDiagram__Group_1__1__Impl ;
    public final void rule__MultiChoiceDiagram__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1334:1: ( rule__MultiChoiceDiagram__Group_1__1__Impl )
            // InternalEduTest.g:1335:2: rule__MultiChoiceDiagram__Group_1__1__Impl
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
    // InternalEduTest.g:1341:1: rule__MultiChoiceDiagram__Group_1__1__Impl : ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceDiagram__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1345:1: ( ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* ) )
            // InternalEduTest.g:1346:1: ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1346:1: ( ( rule__MultiChoiceDiagram__Group_1_1__0 )* )
            // InternalEduTest.g:1347:2: ( rule__MultiChoiceDiagram__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup_1_1()); 
            // InternalEduTest.g:1348:2: ( rule__MultiChoiceDiagram__Group_1_1__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==26) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalEduTest.g:1348:3: rule__MultiChoiceDiagram__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MultiChoiceDiagram__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalEduTest.g:1357:1: rule__MultiChoiceDiagram__Group_1_1__0 : rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1 ;
    public final void rule__MultiChoiceDiagram__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1361:1: ( rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1 )
            // InternalEduTest.g:1362:2: rule__MultiChoiceDiagram__Group_1_1__0__Impl rule__MultiChoiceDiagram__Group_1_1__1
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
    // InternalEduTest.g:1369:1: rule__MultiChoiceDiagram__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceDiagram__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1373:1: ( ( ',' ) )
            // InternalEduTest.g:1374:1: ( ',' )
            {
            // InternalEduTest.g:1374:1: ( ',' )
            // InternalEduTest.g:1375:2: ','
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
    // InternalEduTest.g:1384:1: rule__MultiChoiceDiagram__Group_1_1__1 : rule__MultiChoiceDiagram__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceDiagram__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1388:1: ( rule__MultiChoiceDiagram__Group_1_1__1__Impl )
            // InternalEduTest.g:1389:2: rule__MultiChoiceDiagram__Group_1_1__1__Impl
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
    // InternalEduTest.g:1395:1: rule__MultiChoiceDiagram__Group_1_1__1__Impl : ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceDiagram__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1399:1: ( ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1400:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1400:1: ( ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1401:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1402:2: ( rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:1402:3: rule__MultiChoiceDiagram__BlocksAssignment_1_1_1
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
    // InternalEduTest.g:1411:1: rule__MultiChoiceEmendation__Group__0 : rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 ;
    public final void rule__MultiChoiceEmendation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1415:1: ( rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 )
            // InternalEduTest.g:1416:2: rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1
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
    // InternalEduTest.g:1423:1: rule__MultiChoiceEmendation__Group__0__Impl : ( 'MultiChoiceEmendation' ) ;
    public final void rule__MultiChoiceEmendation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1427:1: ( ( 'MultiChoiceEmendation' ) )
            // InternalEduTest.g:1428:1: ( 'MultiChoiceEmendation' )
            {
            // InternalEduTest.g:1428:1: ( 'MultiChoiceEmendation' )
            // InternalEduTest.g:1429:2: 'MultiChoiceEmendation'
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
    // InternalEduTest.g:1438:1: rule__MultiChoiceEmendation__Group__1 : rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 ;
    public final void rule__MultiChoiceEmendation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1442:1: ( rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 )
            // InternalEduTest.g:1443:2: rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2
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
    // InternalEduTest.g:1450:1: rule__MultiChoiceEmendation__Group__1__Impl : ( ( rule__MultiChoiceEmendation__Group_1__0 )? ) ;
    public final void rule__MultiChoiceEmendation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1454:1: ( ( ( rule__MultiChoiceEmendation__Group_1__0 )? ) )
            // InternalEduTest.g:1455:1: ( ( rule__MultiChoiceEmendation__Group_1__0 )? )
            {
            // InternalEduTest.g:1455:1: ( ( rule__MultiChoiceEmendation__Group_1__0 )? )
            // InternalEduTest.g:1456:2: ( rule__MultiChoiceEmendation__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1()); 
            // InternalEduTest.g:1457:2: ( rule__MultiChoiceEmendation__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ID) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalEduTest.g:1457:3: rule__MultiChoiceEmendation__Group_1__0
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
    // InternalEduTest.g:1465:1: rule__MultiChoiceEmendation__Group__2 : rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 ;
    public final void rule__MultiChoiceEmendation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1469:1: ( rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 )
            // InternalEduTest.g:1470:2: rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3
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
    // InternalEduTest.g:1477:1: rule__MultiChoiceEmendation__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceEmendation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1481:1: ( ( '{' ) )
            // InternalEduTest.g:1482:1: ( '{' )
            {
            // InternalEduTest.g:1482:1: ( '{' )
            // InternalEduTest.g:1483:2: '{'
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
    // InternalEduTest.g:1492:1: rule__MultiChoiceEmendation__Group__3 : rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 ;
    public final void rule__MultiChoiceEmendation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1496:1: ( rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 )
            // InternalEduTest.g:1497:2: rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4
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
    // InternalEduTest.g:1504:1: rule__MultiChoiceEmendation__Group__3__Impl : ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmendation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1508:1: ( ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1509:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1509:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            // InternalEduTest.g:1510:2: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1511:2: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            // InternalEduTest.g:1511:3: rule__MultiChoiceEmendation__ConfigAssignment_3
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
    // InternalEduTest.g:1519:1: rule__MultiChoiceEmendation__Group__4 : rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 ;
    public final void rule__MultiChoiceEmendation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1523:1: ( rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 )
            // InternalEduTest.g:1524:2: rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5
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
    // InternalEduTest.g:1531:1: rule__MultiChoiceEmendation__Group__4__Impl : ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceEmendation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1535:1: ( ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1536:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1536:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            // InternalEduTest.g:1537:2: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1538:2: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==46) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalEduTest.g:1538:3: rule__MultiChoiceEmendation__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MultiChoiceEmendation__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // InternalEduTest.g:1546:1: rule__MultiChoiceEmendation__Group__5 : rule__MultiChoiceEmendation__Group__5__Impl ;
    public final void rule__MultiChoiceEmendation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1550:1: ( rule__MultiChoiceEmendation__Group__5__Impl )
            // InternalEduTest.g:1551:2: rule__MultiChoiceEmendation__Group__5__Impl
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
    // InternalEduTest.g:1557:1: rule__MultiChoiceEmendation__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceEmendation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1561:1: ( ( '}' ) )
            // InternalEduTest.g:1562:1: ( '}' )
            {
            // InternalEduTest.g:1562:1: ( '}' )
            // InternalEduTest.g:1563:2: '}'
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
    // InternalEduTest.g:1573:1: rule__MultiChoiceEmendation__Group_1__0 : rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1 ;
    public final void rule__MultiChoiceEmendation__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1577:1: ( rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1 )
            // InternalEduTest.g:1578:2: rule__MultiChoiceEmendation__Group_1__0__Impl rule__MultiChoiceEmendation__Group_1__1
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
    // InternalEduTest.g:1585:1: rule__MultiChoiceEmendation__Group_1__0__Impl : ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceEmendation__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1589:1: ( ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1590:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1590:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1591:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1592:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_0 )
            // InternalEduTest.g:1592:3: rule__MultiChoiceEmendation__BlocksAssignment_1_0
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
    // InternalEduTest.g:1600:1: rule__MultiChoiceEmendation__Group_1__1 : rule__MultiChoiceEmendation__Group_1__1__Impl ;
    public final void rule__MultiChoiceEmendation__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1604:1: ( rule__MultiChoiceEmendation__Group_1__1__Impl )
            // InternalEduTest.g:1605:2: rule__MultiChoiceEmendation__Group_1__1__Impl
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
    // InternalEduTest.g:1611:1: rule__MultiChoiceEmendation__Group_1__1__Impl : ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceEmendation__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1615:1: ( ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* ) )
            // InternalEduTest.g:1616:1: ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1616:1: ( ( rule__MultiChoiceEmendation__Group_1_1__0 )* )
            // InternalEduTest.g:1617:2: ( rule__MultiChoiceEmendation__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup_1_1()); 
            // InternalEduTest.g:1618:2: ( rule__MultiChoiceEmendation__Group_1_1__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==26) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalEduTest.g:1618:3: rule__MultiChoiceEmendation__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MultiChoiceEmendation__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalEduTest.g:1627:1: rule__MultiChoiceEmendation__Group_1_1__0 : rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1 ;
    public final void rule__MultiChoiceEmendation__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1631:1: ( rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1 )
            // InternalEduTest.g:1632:2: rule__MultiChoiceEmendation__Group_1_1__0__Impl rule__MultiChoiceEmendation__Group_1_1__1
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
    // InternalEduTest.g:1639:1: rule__MultiChoiceEmendation__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmendation__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1643:1: ( ( ',' ) )
            // InternalEduTest.g:1644:1: ( ',' )
            {
            // InternalEduTest.g:1644:1: ( ',' )
            // InternalEduTest.g:1645:2: ','
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
    // InternalEduTest.g:1654:1: rule__MultiChoiceEmendation__Group_1_1__1 : rule__MultiChoiceEmendation__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceEmendation__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1658:1: ( rule__MultiChoiceEmendation__Group_1_1__1__Impl )
            // InternalEduTest.g:1659:2: rule__MultiChoiceEmendation__Group_1_1__1__Impl
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
    // InternalEduTest.g:1665:1: rule__MultiChoiceEmendation__Group_1_1__1__Impl : ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceEmendation__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1669:1: ( ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1670:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1670:1: ( ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1671:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1672:2: ( rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:1672:3: rule__MultiChoiceEmendation__BlocksAssignment_1_1_1
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
    // InternalEduTest.g:1681:1: rule__MatchPairs__Group__0 : rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1 ;
    public final void rule__MatchPairs__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1685:1: ( rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1 )
            // InternalEduTest.g:1686:2: rule__MatchPairs__Group__0__Impl rule__MatchPairs__Group__1
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
    // InternalEduTest.g:1693:1: rule__MatchPairs__Group__0__Impl : ( 'MatchPairs' ) ;
    public final void rule__MatchPairs__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1697:1: ( ( 'MatchPairs' ) )
            // InternalEduTest.g:1698:1: ( 'MatchPairs' )
            {
            // InternalEduTest.g:1698:1: ( 'MatchPairs' )
            // InternalEduTest.g:1699:2: 'MatchPairs'
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
    // InternalEduTest.g:1708:1: rule__MatchPairs__Group__1 : rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2 ;
    public final void rule__MatchPairs__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1712:1: ( rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2 )
            // InternalEduTest.g:1713:2: rule__MatchPairs__Group__1__Impl rule__MatchPairs__Group__2
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
    // InternalEduTest.g:1720:1: rule__MatchPairs__Group__1__Impl : ( ( rule__MatchPairs__Group_1__0 )? ) ;
    public final void rule__MatchPairs__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1724:1: ( ( ( rule__MatchPairs__Group_1__0 )? ) )
            // InternalEduTest.g:1725:1: ( ( rule__MatchPairs__Group_1__0 )? )
            {
            // InternalEduTest.g:1725:1: ( ( rule__MatchPairs__Group_1__0 )? )
            // InternalEduTest.g:1726:2: ( rule__MatchPairs__Group_1__0 )?
            {
             before(grammarAccess.getMatchPairsAccess().getGroup_1()); 
            // InternalEduTest.g:1727:2: ( rule__MatchPairs__Group_1__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalEduTest.g:1727:3: rule__MatchPairs__Group_1__0
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
    // InternalEduTest.g:1735:1: rule__MatchPairs__Group__2 : rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3 ;
    public final void rule__MatchPairs__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1739:1: ( rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3 )
            // InternalEduTest.g:1740:2: rule__MatchPairs__Group__2__Impl rule__MatchPairs__Group__3
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
    // InternalEduTest.g:1747:1: rule__MatchPairs__Group__2__Impl : ( '{' ) ;
    public final void rule__MatchPairs__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1751:1: ( ( '{' ) )
            // InternalEduTest.g:1752:1: ( '{' )
            {
            // InternalEduTest.g:1752:1: ( '{' )
            // InternalEduTest.g:1753:2: '{'
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
    // InternalEduTest.g:1762:1: rule__MatchPairs__Group__3 : rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4 ;
    public final void rule__MatchPairs__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1766:1: ( rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4 )
            // InternalEduTest.g:1767:2: rule__MatchPairs__Group__3__Impl rule__MatchPairs__Group__4
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
    // InternalEduTest.g:1774:1: rule__MatchPairs__Group__3__Impl : ( ( rule__MatchPairs__ConfigAssignment_3 ) ) ;
    public final void rule__MatchPairs__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1778:1: ( ( ( rule__MatchPairs__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:1779:1: ( ( rule__MatchPairs__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:1779:1: ( ( rule__MatchPairs__ConfigAssignment_3 ) )
            // InternalEduTest.g:1780:2: ( rule__MatchPairs__ConfigAssignment_3 )
            {
             before(grammarAccess.getMatchPairsAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:1781:2: ( rule__MatchPairs__ConfigAssignment_3 )
            // InternalEduTest.g:1781:3: rule__MatchPairs__ConfigAssignment_3
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
    // InternalEduTest.g:1789:1: rule__MatchPairs__Group__4 : rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5 ;
    public final void rule__MatchPairs__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1793:1: ( rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5 )
            // InternalEduTest.g:1794:2: rule__MatchPairs__Group__4__Impl rule__MatchPairs__Group__5
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
    // InternalEduTest.g:1801:1: rule__MatchPairs__Group__4__Impl : ( ( rule__MatchPairs__TestsAssignment_4 )* ) ;
    public final void rule__MatchPairs__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1805:1: ( ( ( rule__MatchPairs__TestsAssignment_4 )* ) )
            // InternalEduTest.g:1806:1: ( ( rule__MatchPairs__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:1806:1: ( ( rule__MatchPairs__TestsAssignment_4 )* )
            // InternalEduTest.g:1807:2: ( rule__MatchPairs__TestsAssignment_4 )*
            {
             before(grammarAccess.getMatchPairsAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:1808:2: ( rule__MatchPairs__TestsAssignment_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==46) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalEduTest.g:1808:3: rule__MatchPairs__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MatchPairs__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalEduTest.g:1816:1: rule__MatchPairs__Group__5 : rule__MatchPairs__Group__5__Impl ;
    public final void rule__MatchPairs__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1820:1: ( rule__MatchPairs__Group__5__Impl )
            // InternalEduTest.g:1821:2: rule__MatchPairs__Group__5__Impl
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
    // InternalEduTest.g:1827:1: rule__MatchPairs__Group__5__Impl : ( '}' ) ;
    public final void rule__MatchPairs__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1831:1: ( ( '}' ) )
            // InternalEduTest.g:1832:1: ( '}' )
            {
            // InternalEduTest.g:1832:1: ( '}' )
            // InternalEduTest.g:1833:2: '}'
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
    // InternalEduTest.g:1843:1: rule__MatchPairs__Group_1__0 : rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1 ;
    public final void rule__MatchPairs__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1847:1: ( rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1 )
            // InternalEduTest.g:1848:2: rule__MatchPairs__Group_1__0__Impl rule__MatchPairs__Group_1__1
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
    // InternalEduTest.g:1855:1: rule__MatchPairs__Group_1__0__Impl : ( ( rule__MatchPairs__BlocksAssignment_1_0 ) ) ;
    public final void rule__MatchPairs__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1859:1: ( ( ( rule__MatchPairs__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:1860:1: ( ( rule__MatchPairs__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:1860:1: ( ( rule__MatchPairs__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:1861:2: ( rule__MatchPairs__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:1862:2: ( rule__MatchPairs__BlocksAssignment_1_0 )
            // InternalEduTest.g:1862:3: rule__MatchPairs__BlocksAssignment_1_0
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
    // InternalEduTest.g:1870:1: rule__MatchPairs__Group_1__1 : rule__MatchPairs__Group_1__1__Impl ;
    public final void rule__MatchPairs__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1874:1: ( rule__MatchPairs__Group_1__1__Impl )
            // InternalEduTest.g:1875:2: rule__MatchPairs__Group_1__1__Impl
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
    // InternalEduTest.g:1881:1: rule__MatchPairs__Group_1__1__Impl : ( ( rule__MatchPairs__Group_1_1__0 )* ) ;
    public final void rule__MatchPairs__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1885:1: ( ( ( rule__MatchPairs__Group_1_1__0 )* ) )
            // InternalEduTest.g:1886:1: ( ( rule__MatchPairs__Group_1_1__0 )* )
            {
            // InternalEduTest.g:1886:1: ( ( rule__MatchPairs__Group_1_1__0 )* )
            // InternalEduTest.g:1887:2: ( rule__MatchPairs__Group_1_1__0 )*
            {
             before(grammarAccess.getMatchPairsAccess().getGroup_1_1()); 
            // InternalEduTest.g:1888:2: ( rule__MatchPairs__Group_1_1__0 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==26) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalEduTest.g:1888:3: rule__MatchPairs__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MatchPairs__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalEduTest.g:1897:1: rule__MatchPairs__Group_1_1__0 : rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1 ;
    public final void rule__MatchPairs__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1901:1: ( rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1 )
            // InternalEduTest.g:1902:2: rule__MatchPairs__Group_1_1__0__Impl rule__MatchPairs__Group_1_1__1
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
    // InternalEduTest.g:1909:1: rule__MatchPairs__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MatchPairs__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1913:1: ( ( ',' ) )
            // InternalEduTest.g:1914:1: ( ',' )
            {
            // InternalEduTest.g:1914:1: ( ',' )
            // InternalEduTest.g:1915:2: ','
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
    // InternalEduTest.g:1924:1: rule__MatchPairs__Group_1_1__1 : rule__MatchPairs__Group_1_1__1__Impl ;
    public final void rule__MatchPairs__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1928:1: ( rule__MatchPairs__Group_1_1__1__Impl )
            // InternalEduTest.g:1929:2: rule__MatchPairs__Group_1_1__1__Impl
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
    // InternalEduTest.g:1935:1: rule__MatchPairs__Group_1_1__1__Impl : ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MatchPairs__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1939:1: ( ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:1940:1: ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:1940:1: ( ( rule__MatchPairs__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:1941:2: ( rule__MatchPairs__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:1942:2: ( rule__MatchPairs__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:1942:3: rule__MatchPairs__BlocksAssignment_1_1_1
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
    // InternalEduTest.g:1951:1: rule__MissingWords__Group__0 : rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1 ;
    public final void rule__MissingWords__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1955:1: ( rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1 )
            // InternalEduTest.g:1956:2: rule__MissingWords__Group__0__Impl rule__MissingWords__Group__1
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
    // InternalEduTest.g:1963:1: rule__MissingWords__Group__0__Impl : ( 'MissingWords' ) ;
    public final void rule__MissingWords__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1967:1: ( ( 'MissingWords' ) )
            // InternalEduTest.g:1968:1: ( 'MissingWords' )
            {
            // InternalEduTest.g:1968:1: ( 'MissingWords' )
            // InternalEduTest.g:1969:2: 'MissingWords'
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
    // InternalEduTest.g:1978:1: rule__MissingWords__Group__1 : rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2 ;
    public final void rule__MissingWords__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1982:1: ( rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2 )
            // InternalEduTest.g:1983:2: rule__MissingWords__Group__1__Impl rule__MissingWords__Group__2
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
    // InternalEduTest.g:1990:1: rule__MissingWords__Group__1__Impl : ( ( rule__MissingWords__Group_1__0 )? ) ;
    public final void rule__MissingWords__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:1994:1: ( ( ( rule__MissingWords__Group_1__0 )? ) )
            // InternalEduTest.g:1995:1: ( ( rule__MissingWords__Group_1__0 )? )
            {
            // InternalEduTest.g:1995:1: ( ( rule__MissingWords__Group_1__0 )? )
            // InternalEduTest.g:1996:2: ( rule__MissingWords__Group_1__0 )?
            {
             before(grammarAccess.getMissingWordsAccess().getGroup_1()); 
            // InternalEduTest.g:1997:2: ( rule__MissingWords__Group_1__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalEduTest.g:1997:3: rule__MissingWords__Group_1__0
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
    // InternalEduTest.g:2005:1: rule__MissingWords__Group__2 : rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3 ;
    public final void rule__MissingWords__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2009:1: ( rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3 )
            // InternalEduTest.g:2010:2: rule__MissingWords__Group__2__Impl rule__MissingWords__Group__3
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
    // InternalEduTest.g:2017:1: rule__MissingWords__Group__2__Impl : ( '{' ) ;
    public final void rule__MissingWords__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2021:1: ( ( '{' ) )
            // InternalEduTest.g:2022:1: ( '{' )
            {
            // InternalEduTest.g:2022:1: ( '{' )
            // InternalEduTest.g:2023:2: '{'
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
    // InternalEduTest.g:2032:1: rule__MissingWords__Group__3 : rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4 ;
    public final void rule__MissingWords__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2036:1: ( rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4 )
            // InternalEduTest.g:2037:2: rule__MissingWords__Group__3__Impl rule__MissingWords__Group__4
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
    // InternalEduTest.g:2044:1: rule__MissingWords__Group__3__Impl : ( ( rule__MissingWords__ConfigAssignment_3 ) ) ;
    public final void rule__MissingWords__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2048:1: ( ( ( rule__MissingWords__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:2049:1: ( ( rule__MissingWords__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:2049:1: ( ( rule__MissingWords__ConfigAssignment_3 ) )
            // InternalEduTest.g:2050:2: ( rule__MissingWords__ConfigAssignment_3 )
            {
             before(grammarAccess.getMissingWordsAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:2051:2: ( rule__MissingWords__ConfigAssignment_3 )
            // InternalEduTest.g:2051:3: rule__MissingWords__ConfigAssignment_3
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
    // InternalEduTest.g:2059:1: rule__MissingWords__Group__4 : rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5 ;
    public final void rule__MissingWords__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2063:1: ( rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5 )
            // InternalEduTest.g:2064:2: rule__MissingWords__Group__4__Impl rule__MissingWords__Group__5
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
    // InternalEduTest.g:2071:1: rule__MissingWords__Group__4__Impl : ( ( rule__MissingWords__TestsAssignment_4 )* ) ;
    public final void rule__MissingWords__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2075:1: ( ( ( rule__MissingWords__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2076:1: ( ( rule__MissingWords__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2076:1: ( ( rule__MissingWords__TestsAssignment_4 )* )
            // InternalEduTest.g:2077:2: ( rule__MissingWords__TestsAssignment_4 )*
            {
             before(grammarAccess.getMissingWordsAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2078:2: ( rule__MissingWords__TestsAssignment_4 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==46) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalEduTest.g:2078:3: rule__MissingWords__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MissingWords__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // InternalEduTest.g:2086:1: rule__MissingWords__Group__5 : rule__MissingWords__Group__5__Impl ;
    public final void rule__MissingWords__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2090:1: ( rule__MissingWords__Group__5__Impl )
            // InternalEduTest.g:2091:2: rule__MissingWords__Group__5__Impl
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
    // InternalEduTest.g:2097:1: rule__MissingWords__Group__5__Impl : ( '}' ) ;
    public final void rule__MissingWords__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2101:1: ( ( '}' ) )
            // InternalEduTest.g:2102:1: ( '}' )
            {
            // InternalEduTest.g:2102:1: ( '}' )
            // InternalEduTest.g:2103:2: '}'
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
    // InternalEduTest.g:2113:1: rule__MissingWords__Group_1__0 : rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1 ;
    public final void rule__MissingWords__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2117:1: ( rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1 )
            // InternalEduTest.g:2118:2: rule__MissingWords__Group_1__0__Impl rule__MissingWords__Group_1__1
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
    // InternalEduTest.g:2125:1: rule__MissingWords__Group_1__0__Impl : ( ( rule__MissingWords__BlocksAssignment_1_0 ) ) ;
    public final void rule__MissingWords__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2129:1: ( ( ( rule__MissingWords__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2130:1: ( ( rule__MissingWords__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2130:1: ( ( rule__MissingWords__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:2131:2: ( rule__MissingWords__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:2132:2: ( rule__MissingWords__BlocksAssignment_1_0 )
            // InternalEduTest.g:2132:3: rule__MissingWords__BlocksAssignment_1_0
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
    // InternalEduTest.g:2140:1: rule__MissingWords__Group_1__1 : rule__MissingWords__Group_1__1__Impl ;
    public final void rule__MissingWords__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2144:1: ( rule__MissingWords__Group_1__1__Impl )
            // InternalEduTest.g:2145:2: rule__MissingWords__Group_1__1__Impl
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
    // InternalEduTest.g:2151:1: rule__MissingWords__Group_1__1__Impl : ( ( rule__MissingWords__Group_1_1__0 )* ) ;
    public final void rule__MissingWords__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2155:1: ( ( ( rule__MissingWords__Group_1_1__0 )* ) )
            // InternalEduTest.g:2156:1: ( ( rule__MissingWords__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2156:1: ( ( rule__MissingWords__Group_1_1__0 )* )
            // InternalEduTest.g:2157:2: ( rule__MissingWords__Group_1_1__0 )*
            {
             before(grammarAccess.getMissingWordsAccess().getGroup_1_1()); 
            // InternalEduTest.g:2158:2: ( rule__MissingWords__Group_1_1__0 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==26) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalEduTest.g:2158:3: rule__MissingWords__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MissingWords__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // InternalEduTest.g:2167:1: rule__MissingWords__Group_1_1__0 : rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1 ;
    public final void rule__MissingWords__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2171:1: ( rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1 )
            // InternalEduTest.g:2172:2: rule__MissingWords__Group_1_1__0__Impl rule__MissingWords__Group_1_1__1
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
    // InternalEduTest.g:2179:1: rule__MissingWords__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MissingWords__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2183:1: ( ( ',' ) )
            // InternalEduTest.g:2184:1: ( ',' )
            {
            // InternalEduTest.g:2184:1: ( ',' )
            // InternalEduTest.g:2185:2: ','
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
    // InternalEduTest.g:2194:1: rule__MissingWords__Group_1_1__1 : rule__MissingWords__Group_1_1__1__Impl ;
    public final void rule__MissingWords__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2198:1: ( rule__MissingWords__Group_1_1__1__Impl )
            // InternalEduTest.g:2199:2: rule__MissingWords__Group_1_1__1__Impl
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
    // InternalEduTest.g:2205:1: rule__MissingWords__Group_1_1__1__Impl : ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MissingWords__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2209:1: ( ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2210:1: ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2210:1: ( ( rule__MissingWords__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2211:2: ( rule__MissingWords__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2212:2: ( rule__MissingWords__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:2212:3: rule__MissingWords__BlocksAssignment_1_1_1
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


    // $ANTLR start "rule__MultiChoiceText__Group__0"
    // InternalEduTest.g:2221:1: rule__MultiChoiceText__Group__0 : rule__MultiChoiceText__Group__0__Impl rule__MultiChoiceText__Group__1 ;
    public final void rule__MultiChoiceText__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2225:1: ( rule__MultiChoiceText__Group__0__Impl rule__MultiChoiceText__Group__1 )
            // InternalEduTest.g:2226:2: rule__MultiChoiceText__Group__0__Impl rule__MultiChoiceText__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:2233:1: rule__MultiChoiceText__Group__0__Impl : ( 'MultiChoiceText' ) ;
    public final void rule__MultiChoiceText__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2237:1: ( ( 'MultiChoiceText' ) )
            // InternalEduTest.g:2238:1: ( 'MultiChoiceText' )
            {
            // InternalEduTest.g:2238:1: ( 'MultiChoiceText' )
            // InternalEduTest.g:2239:2: 'MultiChoiceText'
            {
             before(grammarAccess.getMultiChoiceTextAccess().getMultiChoiceTextKeyword_0()); 
            match(input,31,FOLLOW_2); 
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
    // InternalEduTest.g:2248:1: rule__MultiChoiceText__Group__1 : rule__MultiChoiceText__Group__1__Impl rule__MultiChoiceText__Group__2 ;
    public final void rule__MultiChoiceText__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2252:1: ( rule__MultiChoiceText__Group__1__Impl rule__MultiChoiceText__Group__2 )
            // InternalEduTest.g:2253:2: rule__MultiChoiceText__Group__1__Impl rule__MultiChoiceText__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:2260:1: rule__MultiChoiceText__Group__1__Impl : ( ( rule__MultiChoiceText__Group_1__0 )? ) ;
    public final void rule__MultiChoiceText__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2264:1: ( ( ( rule__MultiChoiceText__Group_1__0 )? ) )
            // InternalEduTest.g:2265:1: ( ( rule__MultiChoiceText__Group_1__0 )? )
            {
            // InternalEduTest.g:2265:1: ( ( rule__MultiChoiceText__Group_1__0 )? )
            // InternalEduTest.g:2266:2: ( rule__MultiChoiceText__Group_1__0 )?
            {
             before(grammarAccess.getMultiChoiceTextAccess().getGroup_1()); 
            // InternalEduTest.g:2267:2: ( rule__MultiChoiceText__Group_1__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalEduTest.g:2267:3: rule__MultiChoiceText__Group_1__0
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
    // InternalEduTest.g:2275:1: rule__MultiChoiceText__Group__2 : rule__MultiChoiceText__Group__2__Impl rule__MultiChoiceText__Group__3 ;
    public final void rule__MultiChoiceText__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2279:1: ( rule__MultiChoiceText__Group__2__Impl rule__MultiChoiceText__Group__3 )
            // InternalEduTest.g:2280:2: rule__MultiChoiceText__Group__2__Impl rule__MultiChoiceText__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalEduTest.g:2287:1: rule__MultiChoiceText__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceText__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2291:1: ( ( '{' ) )
            // InternalEduTest.g:2292:1: ( '{' )
            {
            // InternalEduTest.g:2292:1: ( '{' )
            // InternalEduTest.g:2293:2: '{'
            {
             before(grammarAccess.getMultiChoiceTextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
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
    // InternalEduTest.g:2302:1: rule__MultiChoiceText__Group__3 : rule__MultiChoiceText__Group__3__Impl rule__MultiChoiceText__Group__4 ;
    public final void rule__MultiChoiceText__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2306:1: ( rule__MultiChoiceText__Group__3__Impl rule__MultiChoiceText__Group__4 )
            // InternalEduTest.g:2307:2: rule__MultiChoiceText__Group__3__Impl rule__MultiChoiceText__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2314:1: rule__MultiChoiceText__Group__3__Impl : ( ( rule__MultiChoiceText__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceText__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2318:1: ( ( ( rule__MultiChoiceText__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:2319:1: ( ( rule__MultiChoiceText__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:2319:1: ( ( rule__MultiChoiceText__ConfigAssignment_3 ) )
            // InternalEduTest.g:2320:2: ( rule__MultiChoiceText__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:2321:2: ( rule__MultiChoiceText__ConfigAssignment_3 )
            // InternalEduTest.g:2321:3: rule__MultiChoiceText__ConfigAssignment_3
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
    // InternalEduTest.g:2329:1: rule__MultiChoiceText__Group__4 : rule__MultiChoiceText__Group__4__Impl rule__MultiChoiceText__Group__5 ;
    public final void rule__MultiChoiceText__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2333:1: ( rule__MultiChoiceText__Group__4__Impl rule__MultiChoiceText__Group__5 )
            // InternalEduTest.g:2334:2: rule__MultiChoiceText__Group__4__Impl rule__MultiChoiceText__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2341:1: rule__MultiChoiceText__Group__4__Impl : ( ( rule__MultiChoiceText__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceText__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2345:1: ( ( ( rule__MultiChoiceText__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2346:1: ( ( rule__MultiChoiceText__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2346:1: ( ( rule__MultiChoiceText__TestsAssignment_4 )* )
            // InternalEduTest.g:2347:2: ( rule__MultiChoiceText__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceTextAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2348:2: ( rule__MultiChoiceText__TestsAssignment_4 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==46) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalEduTest.g:2348:3: rule__MultiChoiceText__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__MultiChoiceText__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // InternalEduTest.g:2356:1: rule__MultiChoiceText__Group__5 : rule__MultiChoiceText__Group__5__Impl ;
    public final void rule__MultiChoiceText__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2360:1: ( rule__MultiChoiceText__Group__5__Impl )
            // InternalEduTest.g:2361:2: rule__MultiChoiceText__Group__5__Impl
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
    // InternalEduTest.g:2367:1: rule__MultiChoiceText__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceText__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2371:1: ( ( '}' ) )
            // InternalEduTest.g:2372:1: ( '}' )
            {
            // InternalEduTest.g:2372:1: ( '}' )
            // InternalEduTest.g:2373:2: '}'
            {
             before(grammarAccess.getMultiChoiceTextAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
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
    // InternalEduTest.g:2383:1: rule__MultiChoiceText__Group_1__0 : rule__MultiChoiceText__Group_1__0__Impl rule__MultiChoiceText__Group_1__1 ;
    public final void rule__MultiChoiceText__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2387:1: ( rule__MultiChoiceText__Group_1__0__Impl rule__MultiChoiceText__Group_1__1 )
            // InternalEduTest.g:2388:2: rule__MultiChoiceText__Group_1__0__Impl rule__MultiChoiceText__Group_1__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalEduTest.g:2395:1: rule__MultiChoiceText__Group_1__0__Impl : ( ( rule__MultiChoiceText__BlocksAssignment_1_0 ) ) ;
    public final void rule__MultiChoiceText__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2399:1: ( ( ( rule__MultiChoiceText__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2400:1: ( ( rule__MultiChoiceText__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2400:1: ( ( rule__MultiChoiceText__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:2401:2: ( rule__MultiChoiceText__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:2402:2: ( rule__MultiChoiceText__BlocksAssignment_1_0 )
            // InternalEduTest.g:2402:3: rule__MultiChoiceText__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceTextAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:2410:1: rule__MultiChoiceText__Group_1__1 : rule__MultiChoiceText__Group_1__1__Impl ;
    public final void rule__MultiChoiceText__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2414:1: ( rule__MultiChoiceText__Group_1__1__Impl )
            // InternalEduTest.g:2415:2: rule__MultiChoiceText__Group_1__1__Impl
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
    // InternalEduTest.g:2421:1: rule__MultiChoiceText__Group_1__1__Impl : ( ( rule__MultiChoiceText__Group_1_1__0 )* ) ;
    public final void rule__MultiChoiceText__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2425:1: ( ( ( rule__MultiChoiceText__Group_1_1__0 )* ) )
            // InternalEduTest.g:2426:1: ( ( rule__MultiChoiceText__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2426:1: ( ( rule__MultiChoiceText__Group_1_1__0 )* )
            // InternalEduTest.g:2427:2: ( rule__MultiChoiceText__Group_1_1__0 )*
            {
             before(grammarAccess.getMultiChoiceTextAccess().getGroup_1_1()); 
            // InternalEduTest.g:2428:2: ( rule__MultiChoiceText__Group_1_1__0 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==26) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalEduTest.g:2428:3: rule__MultiChoiceText__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MultiChoiceText__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
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
    // InternalEduTest.g:2437:1: rule__MultiChoiceText__Group_1_1__0 : rule__MultiChoiceText__Group_1_1__0__Impl rule__MultiChoiceText__Group_1_1__1 ;
    public final void rule__MultiChoiceText__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2441:1: ( rule__MultiChoiceText__Group_1_1__0__Impl rule__MultiChoiceText__Group_1_1__1 )
            // InternalEduTest.g:2442:2: rule__MultiChoiceText__Group_1_1__0__Impl rule__MultiChoiceText__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:2449:1: rule__MultiChoiceText__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__MultiChoiceText__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2453:1: ( ( ',' ) )
            // InternalEduTest.g:2454:1: ( ',' )
            {
            // InternalEduTest.g:2454:1: ( ',' )
            // InternalEduTest.g:2455:2: ','
            {
             before(grammarAccess.getMultiChoiceTextAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:2464:1: rule__MultiChoiceText__Group_1_1__1 : rule__MultiChoiceText__Group_1_1__1__Impl ;
    public final void rule__MultiChoiceText__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2468:1: ( rule__MultiChoiceText__Group_1_1__1__Impl )
            // InternalEduTest.g:2469:2: rule__MultiChoiceText__Group_1_1__1__Impl
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
    // InternalEduTest.g:2475:1: rule__MultiChoiceText__Group_1_1__1__Impl : ( ( rule__MultiChoiceText__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__MultiChoiceText__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2479:1: ( ( ( rule__MultiChoiceText__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2480:1: ( ( rule__MultiChoiceText__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2480:1: ( ( rule__MultiChoiceText__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2481:2: ( rule__MultiChoiceText__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2482:2: ( rule__MultiChoiceText__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:2482:3: rule__MultiChoiceText__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__MultiChoiceText__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getMultiChoiceTextAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalEduTest.g:2491:1: rule__AlternativeText__Group__0 : rule__AlternativeText__Group__0__Impl rule__AlternativeText__Group__1 ;
    public final void rule__AlternativeText__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2495:1: ( rule__AlternativeText__Group__0__Impl rule__AlternativeText__Group__1 )
            // InternalEduTest.g:2496:2: rule__AlternativeText__Group__0__Impl rule__AlternativeText__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:2503:1: rule__AlternativeText__Group__0__Impl : ( 'AlternativeTextResponse' ) ;
    public final void rule__AlternativeText__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2507:1: ( ( 'AlternativeTextResponse' ) )
            // InternalEduTest.g:2508:1: ( 'AlternativeTextResponse' )
            {
            // InternalEduTest.g:2508:1: ( 'AlternativeTextResponse' )
            // InternalEduTest.g:2509:2: 'AlternativeTextResponse'
            {
             before(grammarAccess.getAlternativeTextAccess().getAlternativeTextResponseKeyword_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalEduTest.g:2518:1: rule__AlternativeText__Group__1 : rule__AlternativeText__Group__1__Impl rule__AlternativeText__Group__2 ;
    public final void rule__AlternativeText__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2522:1: ( rule__AlternativeText__Group__1__Impl rule__AlternativeText__Group__2 )
            // InternalEduTest.g:2523:2: rule__AlternativeText__Group__1__Impl rule__AlternativeText__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:2530:1: rule__AlternativeText__Group__1__Impl : ( ( rule__AlternativeText__Group_1__0 )? ) ;
    public final void rule__AlternativeText__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2534:1: ( ( ( rule__AlternativeText__Group_1__0 )? ) )
            // InternalEduTest.g:2535:1: ( ( rule__AlternativeText__Group_1__0 )? )
            {
            // InternalEduTest.g:2535:1: ( ( rule__AlternativeText__Group_1__0 )? )
            // InternalEduTest.g:2536:2: ( rule__AlternativeText__Group_1__0 )?
            {
             before(grammarAccess.getAlternativeTextAccess().getGroup_1()); 
            // InternalEduTest.g:2537:2: ( rule__AlternativeText__Group_1__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalEduTest.g:2537:3: rule__AlternativeText__Group_1__0
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
    // InternalEduTest.g:2545:1: rule__AlternativeText__Group__2 : rule__AlternativeText__Group__2__Impl rule__AlternativeText__Group__3 ;
    public final void rule__AlternativeText__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2549:1: ( rule__AlternativeText__Group__2__Impl rule__AlternativeText__Group__3 )
            // InternalEduTest.g:2550:2: rule__AlternativeText__Group__2__Impl rule__AlternativeText__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalEduTest.g:2557:1: rule__AlternativeText__Group__2__Impl : ( '{' ) ;
    public final void rule__AlternativeText__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2561:1: ( ( '{' ) )
            // InternalEduTest.g:2562:1: ( '{' )
            {
            // InternalEduTest.g:2562:1: ( '{' )
            // InternalEduTest.g:2563:2: '{'
            {
             before(grammarAccess.getAlternativeTextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
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
    // InternalEduTest.g:2572:1: rule__AlternativeText__Group__3 : rule__AlternativeText__Group__3__Impl rule__AlternativeText__Group__4 ;
    public final void rule__AlternativeText__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2576:1: ( rule__AlternativeText__Group__3__Impl rule__AlternativeText__Group__4 )
            // InternalEduTest.g:2577:2: rule__AlternativeText__Group__3__Impl rule__AlternativeText__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2584:1: rule__AlternativeText__Group__3__Impl : ( ( rule__AlternativeText__ConfigAssignment_3 ) ) ;
    public final void rule__AlternativeText__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2588:1: ( ( ( rule__AlternativeText__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:2589:1: ( ( rule__AlternativeText__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:2589:1: ( ( rule__AlternativeText__ConfigAssignment_3 ) )
            // InternalEduTest.g:2590:2: ( rule__AlternativeText__ConfigAssignment_3 )
            {
             before(grammarAccess.getAlternativeTextAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:2591:2: ( rule__AlternativeText__ConfigAssignment_3 )
            // InternalEduTest.g:2591:3: rule__AlternativeText__ConfigAssignment_3
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
    // InternalEduTest.g:2599:1: rule__AlternativeText__Group__4 : rule__AlternativeText__Group__4__Impl rule__AlternativeText__Group__5 ;
    public final void rule__AlternativeText__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2603:1: ( rule__AlternativeText__Group__4__Impl rule__AlternativeText__Group__5 )
            // InternalEduTest.g:2604:2: rule__AlternativeText__Group__4__Impl rule__AlternativeText__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2611:1: rule__AlternativeText__Group__4__Impl : ( ( rule__AlternativeText__TestsAssignment_4 )* ) ;
    public final void rule__AlternativeText__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2615:1: ( ( ( rule__AlternativeText__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2616:1: ( ( rule__AlternativeText__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2616:1: ( ( rule__AlternativeText__TestsAssignment_4 )* )
            // InternalEduTest.g:2617:2: ( rule__AlternativeText__TestsAssignment_4 )*
            {
             before(grammarAccess.getAlternativeTextAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2618:2: ( rule__AlternativeText__TestsAssignment_4 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==46) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalEduTest.g:2618:3: rule__AlternativeText__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__AlternativeText__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // InternalEduTest.g:2626:1: rule__AlternativeText__Group__5 : rule__AlternativeText__Group__5__Impl ;
    public final void rule__AlternativeText__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2630:1: ( rule__AlternativeText__Group__5__Impl )
            // InternalEduTest.g:2631:2: rule__AlternativeText__Group__5__Impl
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
    // InternalEduTest.g:2637:1: rule__AlternativeText__Group__5__Impl : ( '}' ) ;
    public final void rule__AlternativeText__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2641:1: ( ( '}' ) )
            // InternalEduTest.g:2642:1: ( '}' )
            {
            // InternalEduTest.g:2642:1: ( '}' )
            // InternalEduTest.g:2643:2: '}'
            {
             before(grammarAccess.getAlternativeTextAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
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
    // InternalEduTest.g:2653:1: rule__AlternativeText__Group_1__0 : rule__AlternativeText__Group_1__0__Impl rule__AlternativeText__Group_1__1 ;
    public final void rule__AlternativeText__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2657:1: ( rule__AlternativeText__Group_1__0__Impl rule__AlternativeText__Group_1__1 )
            // InternalEduTest.g:2658:2: rule__AlternativeText__Group_1__0__Impl rule__AlternativeText__Group_1__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalEduTest.g:2665:1: rule__AlternativeText__Group_1__0__Impl : ( ( rule__AlternativeText__BlocksAssignment_1_0 ) ) ;
    public final void rule__AlternativeText__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2669:1: ( ( ( rule__AlternativeText__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2670:1: ( ( rule__AlternativeText__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2670:1: ( ( rule__AlternativeText__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:2671:2: ( rule__AlternativeText__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getAlternativeTextAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:2672:2: ( rule__AlternativeText__BlocksAssignment_1_0 )
            // InternalEduTest.g:2672:3: rule__AlternativeText__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeTextAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:2680:1: rule__AlternativeText__Group_1__1 : rule__AlternativeText__Group_1__1__Impl ;
    public final void rule__AlternativeText__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2684:1: ( rule__AlternativeText__Group_1__1__Impl )
            // InternalEduTest.g:2685:2: rule__AlternativeText__Group_1__1__Impl
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
    // InternalEduTest.g:2691:1: rule__AlternativeText__Group_1__1__Impl : ( ( rule__AlternativeText__Group_1_1__0 )* ) ;
    public final void rule__AlternativeText__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2695:1: ( ( ( rule__AlternativeText__Group_1_1__0 )* ) )
            // InternalEduTest.g:2696:1: ( ( rule__AlternativeText__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2696:1: ( ( rule__AlternativeText__Group_1_1__0 )* )
            // InternalEduTest.g:2697:2: ( rule__AlternativeText__Group_1_1__0 )*
            {
             before(grammarAccess.getAlternativeTextAccess().getGroup_1_1()); 
            // InternalEduTest.g:2698:2: ( rule__AlternativeText__Group_1_1__0 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==26) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalEduTest.g:2698:3: rule__AlternativeText__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__AlternativeText__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
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
    // InternalEduTest.g:2707:1: rule__AlternativeText__Group_1_1__0 : rule__AlternativeText__Group_1_1__0__Impl rule__AlternativeText__Group_1_1__1 ;
    public final void rule__AlternativeText__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2711:1: ( rule__AlternativeText__Group_1_1__0__Impl rule__AlternativeText__Group_1_1__1 )
            // InternalEduTest.g:2712:2: rule__AlternativeText__Group_1_1__0__Impl rule__AlternativeText__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:2719:1: rule__AlternativeText__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__AlternativeText__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2723:1: ( ( ',' ) )
            // InternalEduTest.g:2724:1: ( ',' )
            {
            // InternalEduTest.g:2724:1: ( ',' )
            // InternalEduTest.g:2725:2: ','
            {
             before(grammarAccess.getAlternativeTextAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:2734:1: rule__AlternativeText__Group_1_1__1 : rule__AlternativeText__Group_1_1__1__Impl ;
    public final void rule__AlternativeText__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2738:1: ( rule__AlternativeText__Group_1_1__1__Impl )
            // InternalEduTest.g:2739:2: rule__AlternativeText__Group_1_1__1__Impl
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
    // InternalEduTest.g:2745:1: rule__AlternativeText__Group_1_1__1__Impl : ( ( rule__AlternativeText__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__AlternativeText__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2749:1: ( ( ( rule__AlternativeText__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:2750:1: ( ( rule__AlternativeText__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:2750:1: ( ( rule__AlternativeText__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:2751:2: ( rule__AlternativeText__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getAlternativeTextAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:2752:2: ( rule__AlternativeText__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:2752:3: rule__AlternativeText__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__AlternativeText__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getAlternativeTextAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalEduTest.g:2761:1: rule__DragAndDropText__Group__0 : rule__DragAndDropText__Group__0__Impl rule__DragAndDropText__Group__1 ;
    public final void rule__DragAndDropText__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2765:1: ( rule__DragAndDropText__Group__0__Impl rule__DragAndDropText__Group__1 )
            // InternalEduTest.g:2766:2: rule__DragAndDropText__Group__0__Impl rule__DragAndDropText__Group__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:2773:1: rule__DragAndDropText__Group__0__Impl : ( 'DragAndDropText' ) ;
    public final void rule__DragAndDropText__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2777:1: ( ( 'DragAndDropText' ) )
            // InternalEduTest.g:2778:1: ( 'DragAndDropText' )
            {
            // InternalEduTest.g:2778:1: ( 'DragAndDropText' )
            // InternalEduTest.g:2779:2: 'DragAndDropText'
            {
             before(grammarAccess.getDragAndDropTextAccess().getDragAndDropTextKeyword_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalEduTest.g:2788:1: rule__DragAndDropText__Group__1 : rule__DragAndDropText__Group__1__Impl rule__DragAndDropText__Group__2 ;
    public final void rule__DragAndDropText__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2792:1: ( rule__DragAndDropText__Group__1__Impl rule__DragAndDropText__Group__2 )
            // InternalEduTest.g:2793:2: rule__DragAndDropText__Group__1__Impl rule__DragAndDropText__Group__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalEduTest.g:2800:1: rule__DragAndDropText__Group__1__Impl : ( ( rule__DragAndDropText__Group_1__0 )? ) ;
    public final void rule__DragAndDropText__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2804:1: ( ( ( rule__DragAndDropText__Group_1__0 )? ) )
            // InternalEduTest.g:2805:1: ( ( rule__DragAndDropText__Group_1__0 )? )
            {
            // InternalEduTest.g:2805:1: ( ( rule__DragAndDropText__Group_1__0 )? )
            // InternalEduTest.g:2806:2: ( rule__DragAndDropText__Group_1__0 )?
            {
             before(grammarAccess.getDragAndDropTextAccess().getGroup_1()); 
            // InternalEduTest.g:2807:2: ( rule__DragAndDropText__Group_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalEduTest.g:2807:3: rule__DragAndDropText__Group_1__0
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
    // InternalEduTest.g:2815:1: rule__DragAndDropText__Group__2 : rule__DragAndDropText__Group__2__Impl rule__DragAndDropText__Group__3 ;
    public final void rule__DragAndDropText__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2819:1: ( rule__DragAndDropText__Group__2__Impl rule__DragAndDropText__Group__3 )
            // InternalEduTest.g:2820:2: rule__DragAndDropText__Group__2__Impl rule__DragAndDropText__Group__3
            {
            pushFollow(FOLLOW_6);
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
    // InternalEduTest.g:2827:1: rule__DragAndDropText__Group__2__Impl : ( '{' ) ;
    public final void rule__DragAndDropText__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2831:1: ( ( '{' ) )
            // InternalEduTest.g:2832:1: ( '{' )
            {
            // InternalEduTest.g:2832:1: ( '{' )
            // InternalEduTest.g:2833:2: '{'
            {
             before(grammarAccess.getDragAndDropTextAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FOLLOW_2); 
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
    // InternalEduTest.g:2842:1: rule__DragAndDropText__Group__3 : rule__DragAndDropText__Group__3__Impl rule__DragAndDropText__Group__4 ;
    public final void rule__DragAndDropText__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2846:1: ( rule__DragAndDropText__Group__3__Impl rule__DragAndDropText__Group__4 )
            // InternalEduTest.g:2847:2: rule__DragAndDropText__Group__3__Impl rule__DragAndDropText__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2854:1: rule__DragAndDropText__Group__3__Impl : ( ( rule__DragAndDropText__ConfigAssignment_3 ) ) ;
    public final void rule__DragAndDropText__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2858:1: ( ( ( rule__DragAndDropText__ConfigAssignment_3 ) ) )
            // InternalEduTest.g:2859:1: ( ( rule__DragAndDropText__ConfigAssignment_3 ) )
            {
            // InternalEduTest.g:2859:1: ( ( rule__DragAndDropText__ConfigAssignment_3 ) )
            // InternalEduTest.g:2860:2: ( rule__DragAndDropText__ConfigAssignment_3 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getConfigAssignment_3()); 
            // InternalEduTest.g:2861:2: ( rule__DragAndDropText__ConfigAssignment_3 )
            // InternalEduTest.g:2861:3: rule__DragAndDropText__ConfigAssignment_3
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
    // InternalEduTest.g:2869:1: rule__DragAndDropText__Group__4 : rule__DragAndDropText__Group__4__Impl rule__DragAndDropText__Group__5 ;
    public final void rule__DragAndDropText__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2873:1: ( rule__DragAndDropText__Group__4__Impl rule__DragAndDropText__Group__5 )
            // InternalEduTest.g:2874:2: rule__DragAndDropText__Group__4__Impl rule__DragAndDropText__Group__5
            {
            pushFollow(FOLLOW_7);
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
    // InternalEduTest.g:2881:1: rule__DragAndDropText__Group__4__Impl : ( ( rule__DragAndDropText__TestsAssignment_4 )* ) ;
    public final void rule__DragAndDropText__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2885:1: ( ( ( rule__DragAndDropText__TestsAssignment_4 )* ) )
            // InternalEduTest.g:2886:1: ( ( rule__DragAndDropText__TestsAssignment_4 )* )
            {
            // InternalEduTest.g:2886:1: ( ( rule__DragAndDropText__TestsAssignment_4 )* )
            // InternalEduTest.g:2887:2: ( rule__DragAndDropText__TestsAssignment_4 )*
            {
             before(grammarAccess.getDragAndDropTextAccess().getTestsAssignment_4()); 
            // InternalEduTest.g:2888:2: ( rule__DragAndDropText__TestsAssignment_4 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==46) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalEduTest.g:2888:3: rule__DragAndDropText__TestsAssignment_4
            	    {
            	    pushFollow(FOLLOW_8);
            	    rule__DragAndDropText__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // InternalEduTest.g:2896:1: rule__DragAndDropText__Group__5 : rule__DragAndDropText__Group__5__Impl ;
    public final void rule__DragAndDropText__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2900:1: ( rule__DragAndDropText__Group__5__Impl )
            // InternalEduTest.g:2901:2: rule__DragAndDropText__Group__5__Impl
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
    // InternalEduTest.g:2907:1: rule__DragAndDropText__Group__5__Impl : ( '}' ) ;
    public final void rule__DragAndDropText__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2911:1: ( ( '}' ) )
            // InternalEduTest.g:2912:1: ( '}' )
            {
            // InternalEduTest.g:2912:1: ( '}' )
            // InternalEduTest.g:2913:2: '}'
            {
             before(grammarAccess.getDragAndDropTextAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FOLLOW_2); 
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
    // InternalEduTest.g:2923:1: rule__DragAndDropText__Group_1__0 : rule__DragAndDropText__Group_1__0__Impl rule__DragAndDropText__Group_1__1 ;
    public final void rule__DragAndDropText__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2927:1: ( rule__DragAndDropText__Group_1__0__Impl rule__DragAndDropText__Group_1__1 )
            // InternalEduTest.g:2928:2: rule__DragAndDropText__Group_1__0__Impl rule__DragAndDropText__Group_1__1
            {
            pushFollow(FOLLOW_9);
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
    // InternalEduTest.g:2935:1: rule__DragAndDropText__Group_1__0__Impl : ( ( rule__DragAndDropText__BlocksAssignment_1_0 ) ) ;
    public final void rule__DragAndDropText__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2939:1: ( ( ( rule__DragAndDropText__BlocksAssignment_1_0 ) ) )
            // InternalEduTest.g:2940:1: ( ( rule__DragAndDropText__BlocksAssignment_1_0 ) )
            {
            // InternalEduTest.g:2940:1: ( ( rule__DragAndDropText__BlocksAssignment_1_0 ) )
            // InternalEduTest.g:2941:2: ( rule__DragAndDropText__BlocksAssignment_1_0 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getBlocksAssignment_1_0()); 
            // InternalEduTest.g:2942:2: ( rule__DragAndDropText__BlocksAssignment_1_0 )
            // InternalEduTest.g:2942:3: rule__DragAndDropText__BlocksAssignment_1_0
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__BlocksAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getDragAndDropTextAccess().getBlocksAssignment_1_0()); 

            }


            }

        }
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
    // InternalEduTest.g:2950:1: rule__DragAndDropText__Group_1__1 : rule__DragAndDropText__Group_1__1__Impl ;
    public final void rule__DragAndDropText__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2954:1: ( rule__DragAndDropText__Group_1__1__Impl )
            // InternalEduTest.g:2955:2: rule__DragAndDropText__Group_1__1__Impl
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
    // InternalEduTest.g:2961:1: rule__DragAndDropText__Group_1__1__Impl : ( ( rule__DragAndDropText__Group_1_1__0 )* ) ;
    public final void rule__DragAndDropText__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2965:1: ( ( ( rule__DragAndDropText__Group_1_1__0 )* ) )
            // InternalEduTest.g:2966:1: ( ( rule__DragAndDropText__Group_1_1__0 )* )
            {
            // InternalEduTest.g:2966:1: ( ( rule__DragAndDropText__Group_1_1__0 )* )
            // InternalEduTest.g:2967:2: ( rule__DragAndDropText__Group_1_1__0 )*
            {
             before(grammarAccess.getDragAndDropTextAccess().getGroup_1_1()); 
            // InternalEduTest.g:2968:2: ( rule__DragAndDropText__Group_1_1__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==26) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalEduTest.g:2968:3: rule__DragAndDropText__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__DragAndDropText__Group_1_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalEduTest.g:2977:1: rule__DragAndDropText__Group_1_1__0 : rule__DragAndDropText__Group_1_1__0__Impl rule__DragAndDropText__Group_1_1__1 ;
    public final void rule__DragAndDropText__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2981:1: ( rule__DragAndDropText__Group_1_1__0__Impl rule__DragAndDropText__Group_1_1__1 )
            // InternalEduTest.g:2982:2: rule__DragAndDropText__Group_1_1__0__Impl rule__DragAndDropText__Group_1_1__1
            {
            pushFollow(FOLLOW_11);
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
    // InternalEduTest.g:2989:1: rule__DragAndDropText__Group_1_1__0__Impl : ( ',' ) ;
    public final void rule__DragAndDropText__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:2993:1: ( ( ',' ) )
            // InternalEduTest.g:2994:1: ( ',' )
            {
            // InternalEduTest.g:2994:1: ( ',' )
            // InternalEduTest.g:2995:2: ','
            {
             before(grammarAccess.getDragAndDropTextAccess().getCommaKeyword_1_1_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:3004:1: rule__DragAndDropText__Group_1_1__1 : rule__DragAndDropText__Group_1_1__1__Impl ;
    public final void rule__DragAndDropText__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3008:1: ( rule__DragAndDropText__Group_1_1__1__Impl )
            // InternalEduTest.g:3009:2: rule__DragAndDropText__Group_1_1__1__Impl
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
    // InternalEduTest.g:3015:1: rule__DragAndDropText__Group_1_1__1__Impl : ( ( rule__DragAndDropText__BlocksAssignment_1_1_1 ) ) ;
    public final void rule__DragAndDropText__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3019:1: ( ( ( rule__DragAndDropText__BlocksAssignment_1_1_1 ) ) )
            // InternalEduTest.g:3020:1: ( ( rule__DragAndDropText__BlocksAssignment_1_1_1 ) )
            {
            // InternalEduTest.g:3020:1: ( ( rule__DragAndDropText__BlocksAssignment_1_1_1 ) )
            // InternalEduTest.g:3021:2: ( rule__DragAndDropText__BlocksAssignment_1_1_1 )
            {
             before(grammarAccess.getDragAndDropTextAccess().getBlocksAssignment_1_1_1()); 
            // InternalEduTest.g:3022:2: ( rule__DragAndDropText__BlocksAssignment_1_1_1 )
            // InternalEduTest.g:3022:3: rule__DragAndDropText__BlocksAssignment_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__DragAndDropText__BlocksAssignment_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getDragAndDropTextAccess().getBlocksAssignment_1_1_1()); 

            }


            }

        }
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
    // InternalEduTest.g:3031:1: rule__ProgramConfiguration__Group__0 : rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 ;
    public final void rule__ProgramConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3035:1: ( rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 )
            // InternalEduTest.g:3036:2: rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1
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
    // InternalEduTest.g:3043:1: rule__ProgramConfiguration__Group__0__Impl : ( 'navigation' ) ;
    public final void rule__ProgramConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3047:1: ( ( 'navigation' ) )
            // InternalEduTest.g:3048:1: ( 'navigation' )
            {
            // InternalEduTest.g:3048:1: ( 'navigation' )
            // InternalEduTest.g:3049:2: 'navigation'
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0()); 
            match(input,34,FOLLOW_2); 
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
    // InternalEduTest.g:3058:1: rule__ProgramConfiguration__Group__1 : rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 ;
    public final void rule__ProgramConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3062:1: ( rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 )
            // InternalEduTest.g:3063:2: rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2
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
    // InternalEduTest.g:3070:1: rule__ProgramConfiguration__Group__1__Impl : ( '=' ) ;
    public final void rule__ProgramConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3074:1: ( ( '=' ) )
            // InternalEduTest.g:3075:1: ( '=' )
            {
            // InternalEduTest.g:3075:1: ( '=' )
            // InternalEduTest.g:3076:2: '='
            {
             before(grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:3085:1: rule__ProgramConfiguration__Group__2 : rule__ProgramConfiguration__Group__2__Impl ;
    public final void rule__ProgramConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3089:1: ( rule__ProgramConfiguration__Group__2__Impl )
            // InternalEduTest.g:3090:2: rule__ProgramConfiguration__Group__2__Impl
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
    // InternalEduTest.g:3096:1: rule__ProgramConfiguration__Group__2__Impl : ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) ;
    public final void rule__ProgramConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3100:1: ( ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) )
            // InternalEduTest.g:3101:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            {
            // InternalEduTest.g:3101:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            // InternalEduTest.g:3102:2: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationAssignment_2()); 
            // InternalEduTest.g:3103:2: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            // InternalEduTest.g:3103:3: rule__ProgramConfiguration__NavigationAssignment_2
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
    // InternalEduTest.g:3112:1: rule__TestConfiguration__Group__0 : rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 ;
    public final void rule__TestConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3116:1: ( rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 )
            // InternalEduTest.g:3117:2: rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1
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
    // InternalEduTest.g:3124:1: rule__TestConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__TestConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3128:1: ( ( () ) )
            // InternalEduTest.g:3129:1: ( () )
            {
            // InternalEduTest.g:3129:1: ( () )
            // InternalEduTest.g:3130:2: ()
            {
             before(grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0()); 
            // InternalEduTest.g:3131:2: ()
            // InternalEduTest.g:3131:3: 
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
    // InternalEduTest.g:3139:1: rule__TestConfiguration__Group__1 : rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 ;
    public final void rule__TestConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3143:1: ( rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 )
            // InternalEduTest.g:3144:2: rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2
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
    // InternalEduTest.g:3151:1: rule__TestConfiguration__Group__1__Impl : ( 'retry' ) ;
    public final void rule__TestConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3155:1: ( ( 'retry' ) )
            // InternalEduTest.g:3156:1: ( 'retry' )
            {
            // InternalEduTest.g:3156:1: ( 'retry' )
            // InternalEduTest.g:3157:2: 'retry'
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryKeyword_1()); 
            match(input,36,FOLLOW_2); 
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
    // InternalEduTest.g:3166:1: rule__TestConfiguration__Group__2 : rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 ;
    public final void rule__TestConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3170:1: ( rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 )
            // InternalEduTest.g:3171:2: rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3
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
    // InternalEduTest.g:3178:1: rule__TestConfiguration__Group__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3182:1: ( ( '=' ) )
            // InternalEduTest.g:3183:1: ( '=' )
            {
            // InternalEduTest.g:3183:1: ( '=' )
            // InternalEduTest.g:3184:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:3193:1: rule__TestConfiguration__Group__3 : rule__TestConfiguration__Group__3__Impl rule__TestConfiguration__Group__4 ;
    public final void rule__TestConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3197:1: ( rule__TestConfiguration__Group__3__Impl rule__TestConfiguration__Group__4 )
            // InternalEduTest.g:3198:2: rule__TestConfiguration__Group__3__Impl rule__TestConfiguration__Group__4
            {
            pushFollow(FOLLOW_9);
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
    // InternalEduTest.g:3205:1: rule__TestConfiguration__Group__3__Impl : ( ( rule__TestConfiguration__RetryAssignment_3 ) ) ;
    public final void rule__TestConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3209:1: ( ( ( rule__TestConfiguration__RetryAssignment_3 ) ) )
            // InternalEduTest.g:3210:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:3210:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            // InternalEduTest.g:3211:2: ( rule__TestConfiguration__RetryAssignment_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:3212:2: ( rule__TestConfiguration__RetryAssignment_3 )
            // InternalEduTest.g:3212:3: rule__TestConfiguration__RetryAssignment_3
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
    // InternalEduTest.g:3220:1: rule__TestConfiguration__Group__4 : rule__TestConfiguration__Group__4__Impl rule__TestConfiguration__Group__5 ;
    public final void rule__TestConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3224:1: ( rule__TestConfiguration__Group__4__Impl rule__TestConfiguration__Group__5 )
            // InternalEduTest.g:3225:2: rule__TestConfiguration__Group__4__Impl rule__TestConfiguration__Group__5
            {
            pushFollow(FOLLOW_9);
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
    // InternalEduTest.g:3232:1: rule__TestConfiguration__Group__4__Impl : ( ( rule__TestConfiguration__Group_4__0 )? ) ;
    public final void rule__TestConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3236:1: ( ( ( rule__TestConfiguration__Group_4__0 )? ) )
            // InternalEduTest.g:3237:1: ( ( rule__TestConfiguration__Group_4__0 )? )
            {
            // InternalEduTest.g:3237:1: ( ( rule__TestConfiguration__Group_4__0 )? )
            // InternalEduTest.g:3238:2: ( rule__TestConfiguration__Group_4__0 )?
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_4()); 
            // InternalEduTest.g:3239:2: ( rule__TestConfiguration__Group_4__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==26) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==37) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // InternalEduTest.g:3239:3: rule__TestConfiguration__Group_4__0
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
    // InternalEduTest.g:3247:1: rule__TestConfiguration__Group__5 : rule__TestConfiguration__Group__5__Impl rule__TestConfiguration__Group__6 ;
    public final void rule__TestConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3251:1: ( rule__TestConfiguration__Group__5__Impl rule__TestConfiguration__Group__6 )
            // InternalEduTest.g:3252:2: rule__TestConfiguration__Group__5__Impl rule__TestConfiguration__Group__6
            {
            pushFollow(FOLLOW_9);
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
    // InternalEduTest.g:3259:1: rule__TestConfiguration__Group__5__Impl : ( ( rule__TestConfiguration__Group_5__0 )? ) ;
    public final void rule__TestConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3263:1: ( ( ( rule__TestConfiguration__Group_5__0 )? ) )
            // InternalEduTest.g:3264:1: ( ( rule__TestConfiguration__Group_5__0 )? )
            {
            // InternalEduTest.g:3264:1: ( ( rule__TestConfiguration__Group_5__0 )? )
            // InternalEduTest.g:3265:2: ( rule__TestConfiguration__Group_5__0 )?
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_5()); 
            // InternalEduTest.g:3266:2: ( rule__TestConfiguration__Group_5__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==26) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==38) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalEduTest.g:3266:3: rule__TestConfiguration__Group_5__0
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
    // InternalEduTest.g:3274:1: rule__TestConfiguration__Group__6 : rule__TestConfiguration__Group__6__Impl ;
    public final void rule__TestConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3278:1: ( rule__TestConfiguration__Group__6__Impl )
            // InternalEduTest.g:3279:2: rule__TestConfiguration__Group__6__Impl
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
    // InternalEduTest.g:3285:1: rule__TestConfiguration__Group__6__Impl : ( ( rule__TestConfiguration__Group_6__0 )? ) ;
    public final void rule__TestConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3289:1: ( ( ( rule__TestConfiguration__Group_6__0 )? ) )
            // InternalEduTest.g:3290:1: ( ( rule__TestConfiguration__Group_6__0 )? )
            {
            // InternalEduTest.g:3290:1: ( ( rule__TestConfiguration__Group_6__0 )? )
            // InternalEduTest.g:3291:2: ( rule__TestConfiguration__Group_6__0 )?
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup_6()); 
            // InternalEduTest.g:3292:2: ( rule__TestConfiguration__Group_6__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==26) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalEduTest.g:3292:3: rule__TestConfiguration__Group_6__0
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
    // InternalEduTest.g:3301:1: rule__TestConfiguration__Group_4__0 : rule__TestConfiguration__Group_4__0__Impl rule__TestConfiguration__Group_4__1 ;
    public final void rule__TestConfiguration__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3305:1: ( rule__TestConfiguration__Group_4__0__Impl rule__TestConfiguration__Group_4__1 )
            // InternalEduTest.g:3306:2: rule__TestConfiguration__Group_4__0__Impl rule__TestConfiguration__Group_4__1
            {
            pushFollow(FOLLOW_15);
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
    // InternalEduTest.g:3313:1: rule__TestConfiguration__Group_4__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3317:1: ( ( ',' ) )
            // InternalEduTest.g:3318:1: ( ',' )
            {
            // InternalEduTest.g:3318:1: ( ',' )
            // InternalEduTest.g:3319:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_4_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:3328:1: rule__TestConfiguration__Group_4__1 : rule__TestConfiguration__Group_4__1__Impl rule__TestConfiguration__Group_4__2 ;
    public final void rule__TestConfiguration__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3332:1: ( rule__TestConfiguration__Group_4__1__Impl rule__TestConfiguration__Group_4__2 )
            // InternalEduTest.g:3333:2: rule__TestConfiguration__Group_4__1__Impl rule__TestConfiguration__Group_4__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:3340:1: rule__TestConfiguration__Group_4__1__Impl : ( 'mode' ) ;
    public final void rule__TestConfiguration__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3344:1: ( ( 'mode' ) )
            // InternalEduTest.g:3345:1: ( 'mode' )
            {
            // InternalEduTest.g:3345:1: ( 'mode' )
            // InternalEduTest.g:3346:2: 'mode'
            {
             before(grammarAccess.getTestConfigurationAccess().getModeKeyword_4_1()); 
            match(input,37,FOLLOW_2); 
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
    // InternalEduTest.g:3355:1: rule__TestConfiguration__Group_4__2 : rule__TestConfiguration__Group_4__2__Impl rule__TestConfiguration__Group_4__3 ;
    public final void rule__TestConfiguration__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3359:1: ( rule__TestConfiguration__Group_4__2__Impl rule__TestConfiguration__Group_4__3 )
            // InternalEduTest.g:3360:2: rule__TestConfiguration__Group_4__2__Impl rule__TestConfiguration__Group_4__3
            {
            pushFollow(FOLLOW_16);
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
    // InternalEduTest.g:3367:1: rule__TestConfiguration__Group_4__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3371:1: ( ( '=' ) )
            // InternalEduTest.g:3372:1: ( '=' )
            {
            // InternalEduTest.g:3372:1: ( '=' )
            // InternalEduTest.g:3373:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_4_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:3382:1: rule__TestConfiguration__Group_4__3 : rule__TestConfiguration__Group_4__3__Impl ;
    public final void rule__TestConfiguration__Group_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3386:1: ( rule__TestConfiguration__Group_4__3__Impl )
            // InternalEduTest.g:3387:2: rule__TestConfiguration__Group_4__3__Impl
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
    // InternalEduTest.g:3393:1: rule__TestConfiguration__Group_4__3__Impl : ( ( rule__TestConfiguration__ModeAssignment_4_3 ) ) ;
    public final void rule__TestConfiguration__Group_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3397:1: ( ( ( rule__TestConfiguration__ModeAssignment_4_3 ) ) )
            // InternalEduTest.g:3398:1: ( ( rule__TestConfiguration__ModeAssignment_4_3 ) )
            {
            // InternalEduTest.g:3398:1: ( ( rule__TestConfiguration__ModeAssignment_4_3 ) )
            // InternalEduTest.g:3399:2: ( rule__TestConfiguration__ModeAssignment_4_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getModeAssignment_4_3()); 
            // InternalEduTest.g:3400:2: ( rule__TestConfiguration__ModeAssignment_4_3 )
            // InternalEduTest.g:3400:3: rule__TestConfiguration__ModeAssignment_4_3
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
    // InternalEduTest.g:3409:1: rule__TestConfiguration__Group_5__0 : rule__TestConfiguration__Group_5__0__Impl rule__TestConfiguration__Group_5__1 ;
    public final void rule__TestConfiguration__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3413:1: ( rule__TestConfiguration__Group_5__0__Impl rule__TestConfiguration__Group_5__1 )
            // InternalEduTest.g:3414:2: rule__TestConfiguration__Group_5__0__Impl rule__TestConfiguration__Group_5__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalEduTest.g:3421:1: rule__TestConfiguration__Group_5__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3425:1: ( ( ',' ) )
            // InternalEduTest.g:3426:1: ( ',' )
            {
            // InternalEduTest.g:3426:1: ( ',' )
            // InternalEduTest.g:3427:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_5_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:3436:1: rule__TestConfiguration__Group_5__1 : rule__TestConfiguration__Group_5__1__Impl rule__TestConfiguration__Group_5__2 ;
    public final void rule__TestConfiguration__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3440:1: ( rule__TestConfiguration__Group_5__1__Impl rule__TestConfiguration__Group_5__2 )
            // InternalEduTest.g:3441:2: rule__TestConfiguration__Group_5__1__Impl rule__TestConfiguration__Group_5__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:3448:1: rule__TestConfiguration__Group_5__1__Impl : ( 'statement' ) ;
    public final void rule__TestConfiguration__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3452:1: ( ( 'statement' ) )
            // InternalEduTest.g:3453:1: ( 'statement' )
            {
            // InternalEduTest.g:3453:1: ( 'statement' )
            // InternalEduTest.g:3454:2: 'statement'
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementKeyword_5_1()); 
            match(input,38,FOLLOW_2); 
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
    // InternalEduTest.g:3463:1: rule__TestConfiguration__Group_5__2 : rule__TestConfiguration__Group_5__2__Impl rule__TestConfiguration__Group_5__3 ;
    public final void rule__TestConfiguration__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3467:1: ( rule__TestConfiguration__Group_5__2__Impl rule__TestConfiguration__Group_5__3 )
            // InternalEduTest.g:3468:2: rule__TestConfiguration__Group_5__2__Impl rule__TestConfiguration__Group_5__3
            {
            pushFollow(FOLLOW_18);
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
    // InternalEduTest.g:3475:1: rule__TestConfiguration__Group_5__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3479:1: ( ( '=' ) )
            // InternalEduTest.g:3480:1: ( '=' )
            {
            // InternalEduTest.g:3480:1: ( '=' )
            // InternalEduTest.g:3481:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_5_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:3490:1: rule__TestConfiguration__Group_5__3 : rule__TestConfiguration__Group_5__3__Impl rule__TestConfiguration__Group_5__4 ;
    public final void rule__TestConfiguration__Group_5__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3494:1: ( rule__TestConfiguration__Group_5__3__Impl rule__TestConfiguration__Group_5__4 )
            // InternalEduTest.g:3495:2: rule__TestConfiguration__Group_5__3__Impl rule__TestConfiguration__Group_5__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalEduTest.g:3502:1: rule__TestConfiguration__Group_5__3__Impl : ( '(' ) ;
    public final void rule__TestConfiguration__Group_5__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3506:1: ( ( '(' ) )
            // InternalEduTest.g:3507:1: ( '(' )
            {
            // InternalEduTest.g:3507:1: ( '(' )
            // InternalEduTest.g:3508:2: '('
            {
             before(grammarAccess.getTestConfigurationAccess().getLeftParenthesisKeyword_5_3()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getLeftParenthesisKeyword_5_3()); 

            }


            }

        }
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
    // InternalEduTest.g:3517:1: rule__TestConfiguration__Group_5__4 : rule__TestConfiguration__Group_5__4__Impl rule__TestConfiguration__Group_5__5 ;
    public final void rule__TestConfiguration__Group_5__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3521:1: ( rule__TestConfiguration__Group_5__4__Impl rule__TestConfiguration__Group_5__5 )
            // InternalEduTest.g:3522:2: rule__TestConfiguration__Group_5__4__Impl rule__TestConfiguration__Group_5__5
            {
            pushFollow(FOLLOW_20);
            rule__TestConfiguration__Group_5__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5__5();

            state._fsp--;


            }

        }
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
    // InternalEduTest.g:3529:1: rule__TestConfiguration__Group_5__4__Impl : ( ( rule__TestConfiguration__StatementAssignment_5_4 ) ) ;
    public final void rule__TestConfiguration__Group_5__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3533:1: ( ( ( rule__TestConfiguration__StatementAssignment_5_4 ) ) )
            // InternalEduTest.g:3534:1: ( ( rule__TestConfiguration__StatementAssignment_5_4 ) )
            {
            // InternalEduTest.g:3534:1: ( ( rule__TestConfiguration__StatementAssignment_5_4 ) )
            // InternalEduTest.g:3535:2: ( rule__TestConfiguration__StatementAssignment_5_4 )
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementAssignment_5_4()); 
            // InternalEduTest.g:3536:2: ( rule__TestConfiguration__StatementAssignment_5_4 )
            // InternalEduTest.g:3536:3: rule__TestConfiguration__StatementAssignment_5_4
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__StatementAssignment_5_4();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getStatementAssignment_5_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__TestConfiguration__Group_5__5"
    // InternalEduTest.g:3544:1: rule__TestConfiguration__Group_5__5 : rule__TestConfiguration__Group_5__5__Impl ;
    public final void rule__TestConfiguration__Group_5__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3548:1: ( rule__TestConfiguration__Group_5__5__Impl )
            // InternalEduTest.g:3549:2: rule__TestConfiguration__Group_5__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_5__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__5"


    // $ANTLR start "rule__TestConfiguration__Group_5__5__Impl"
    // InternalEduTest.g:3555:1: rule__TestConfiguration__Group_5__5__Impl : ( ')' ) ;
    public final void rule__TestConfiguration__Group_5__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3559:1: ( ( ')' ) )
            // InternalEduTest.g:3560:1: ( ')' )
            {
            // InternalEduTest.g:3560:1: ( ')' )
            // InternalEduTest.g:3561:2: ')'
            {
             before(grammarAccess.getTestConfigurationAccess().getRightParenthesisKeyword_5_5()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getRightParenthesisKeyword_5_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_5__5__Impl"


    // $ANTLR start "rule__TestConfiguration__Group_6__0"
    // InternalEduTest.g:3571:1: rule__TestConfiguration__Group_6__0 : rule__TestConfiguration__Group_6__0__Impl rule__TestConfiguration__Group_6__1 ;
    public final void rule__TestConfiguration__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3575:1: ( rule__TestConfiguration__Group_6__0__Impl rule__TestConfiguration__Group_6__1 )
            // InternalEduTest.g:3576:2: rule__TestConfiguration__Group_6__0__Impl rule__TestConfiguration__Group_6__1
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
    // InternalEduTest.g:3583:1: rule__TestConfiguration__Group_6__0__Impl : ( ',' ) ;
    public final void rule__TestConfiguration__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3587:1: ( ( ',' ) )
            // InternalEduTest.g:3588:1: ( ',' )
            {
            // InternalEduTest.g:3588:1: ( ',' )
            // InternalEduTest.g:3589:2: ','
            {
             before(grammarAccess.getTestConfigurationAccess().getCommaKeyword_6_0()); 
            match(input,26,FOLLOW_2); 
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
    // InternalEduTest.g:3598:1: rule__TestConfiguration__Group_6__1 : rule__TestConfiguration__Group_6__1__Impl rule__TestConfiguration__Group_6__2 ;
    public final void rule__TestConfiguration__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3602:1: ( rule__TestConfiguration__Group_6__1__Impl rule__TestConfiguration__Group_6__2 )
            // InternalEduTest.g:3603:2: rule__TestConfiguration__Group_6__1__Impl rule__TestConfiguration__Group_6__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:3610:1: rule__TestConfiguration__Group_6__1__Impl : ( 'answers' ) ;
    public final void rule__TestConfiguration__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3614:1: ( ( 'answers' ) )
            // InternalEduTest.g:3615:1: ( 'answers' )
            {
            // InternalEduTest.g:3615:1: ( 'answers' )
            // InternalEduTest.g:3616:2: 'answers'
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
    // InternalEduTest.g:3625:1: rule__TestConfiguration__Group_6__2 : rule__TestConfiguration__Group_6__2__Impl rule__TestConfiguration__Group_6__3 ;
    public final void rule__TestConfiguration__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3629:1: ( rule__TestConfiguration__Group_6__2__Impl rule__TestConfiguration__Group_6__3 )
            // InternalEduTest.g:3630:2: rule__TestConfiguration__Group_6__2__Impl rule__TestConfiguration__Group_6__3
            {
            pushFollow(FOLLOW_18);
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
    // InternalEduTest.g:3637:1: rule__TestConfiguration__Group_6__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3641:1: ( ( '=' ) )
            // InternalEduTest.g:3642:1: ( '=' )
            {
            // InternalEduTest.g:3642:1: ( '=' )
            // InternalEduTest.g:3643:2: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_6_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:3652:1: rule__TestConfiguration__Group_6__3 : rule__TestConfiguration__Group_6__3__Impl rule__TestConfiguration__Group_6__4 ;
    public final void rule__TestConfiguration__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3656:1: ( rule__TestConfiguration__Group_6__3__Impl rule__TestConfiguration__Group_6__4 )
            // InternalEduTest.g:3657:2: rule__TestConfiguration__Group_6__3__Impl rule__TestConfiguration__Group_6__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalEduTest.g:3664:1: rule__TestConfiguration__Group_6__3__Impl : ( '(' ) ;
    public final void rule__TestConfiguration__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3668:1: ( ( '(' ) )
            // InternalEduTest.g:3669:1: ( '(' )
            {
            // InternalEduTest.g:3669:1: ( '(' )
            // InternalEduTest.g:3670:2: '('
            {
             before(grammarAccess.getTestConfigurationAccess().getLeftParenthesisKeyword_6_3()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getLeftParenthesisKeyword_6_3()); 

            }


            }

        }
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
    // InternalEduTest.g:3679:1: rule__TestConfiguration__Group_6__4 : rule__TestConfiguration__Group_6__4__Impl rule__TestConfiguration__Group_6__5 ;
    public final void rule__TestConfiguration__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3683:1: ( rule__TestConfiguration__Group_6__4__Impl rule__TestConfiguration__Group_6__5 )
            // InternalEduTest.g:3684:2: rule__TestConfiguration__Group_6__4__Impl rule__TestConfiguration__Group_6__5
            {
            pushFollow(FOLLOW_20);
            rule__TestConfiguration__Group_6__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6__5();

            state._fsp--;


            }

        }
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
    // InternalEduTest.g:3691:1: rule__TestConfiguration__Group_6__4__Impl : ( ( rule__TestConfiguration__AnswersAssignment_6_4 ) ) ;
    public final void rule__TestConfiguration__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3695:1: ( ( ( rule__TestConfiguration__AnswersAssignment_6_4 ) ) )
            // InternalEduTest.g:3696:1: ( ( rule__TestConfiguration__AnswersAssignment_6_4 ) )
            {
            // InternalEduTest.g:3696:1: ( ( rule__TestConfiguration__AnswersAssignment_6_4 ) )
            // InternalEduTest.g:3697:2: ( rule__TestConfiguration__AnswersAssignment_6_4 )
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersAssignment_6_4()); 
            // InternalEduTest.g:3698:2: ( rule__TestConfiguration__AnswersAssignment_6_4 )
            // InternalEduTest.g:3698:3: rule__TestConfiguration__AnswersAssignment_6_4
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__AnswersAssignment_6_4();

            state._fsp--;


            }

             after(grammarAccess.getTestConfigurationAccess().getAnswersAssignment_6_4()); 

            }


            }

        }
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


    // $ANTLR start "rule__TestConfiguration__Group_6__5"
    // InternalEduTest.g:3706:1: rule__TestConfiguration__Group_6__5 : rule__TestConfiguration__Group_6__5__Impl ;
    public final void rule__TestConfiguration__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3710:1: ( rule__TestConfiguration__Group_6__5__Impl )
            // InternalEduTest.g:3711:2: rule__TestConfiguration__Group_6__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TestConfiguration__Group_6__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__5"


    // $ANTLR start "rule__TestConfiguration__Group_6__5__Impl"
    // InternalEduTest.g:3717:1: rule__TestConfiguration__Group_6__5__Impl : ( ')' ) ;
    public final void rule__TestConfiguration__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3721:1: ( ( ')' ) )
            // InternalEduTest.g:3722:1: ( ')' )
            {
            // InternalEduTest.g:3722:1: ( ')' )
            // InternalEduTest.g:3723:2: ')'
            {
             before(grammarAccess.getTestConfigurationAccess().getRightParenthesisKeyword_6_5()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getTestConfigurationAccess().getRightParenthesisKeyword_6_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__Group_6__5__Impl"


    // $ANTLR start "rule__MultiChoiceEmConfig__Group__0"
    // InternalEduTest.g:3733:1: rule__MultiChoiceEmConfig__Group__0 : rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 ;
    public final void rule__MultiChoiceEmConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3737:1: ( rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 )
            // InternalEduTest.g:3738:2: rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1
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
    // InternalEduTest.g:3745:1: rule__MultiChoiceEmConfig__Group__0__Impl : ( () ) ;
    public final void rule__MultiChoiceEmConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3749:1: ( ( () ) )
            // InternalEduTest.g:3750:1: ( () )
            {
            // InternalEduTest.g:3750:1: ( () )
            // InternalEduTest.g:3751:2: ()
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0()); 
            // InternalEduTest.g:3752:2: ()
            // InternalEduTest.g:3752:3: 
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
    // InternalEduTest.g:3760:1: rule__MultiChoiceEmConfig__Group__1 : rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 ;
    public final void rule__MultiChoiceEmConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3764:1: ( rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 )
            // InternalEduTest.g:3765:2: rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2
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
    // InternalEduTest.g:3772:1: rule__MultiChoiceEmConfig__Group__1__Impl : ( 'retry' ) ;
    public final void rule__MultiChoiceEmConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3776:1: ( ( 'retry' ) )
            // InternalEduTest.g:3777:1: ( 'retry' )
            {
            // InternalEduTest.g:3777:1: ( 'retry' )
            // InternalEduTest.g:3778:2: 'retry'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1()); 
            match(input,36,FOLLOW_2); 
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
    // InternalEduTest.g:3787:1: rule__MultiChoiceEmConfig__Group__2 : rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 ;
    public final void rule__MultiChoiceEmConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3791:1: ( rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 )
            // InternalEduTest.g:3792:2: rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3
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
    // InternalEduTest.g:3799:1: rule__MultiChoiceEmConfig__Group__2__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3803:1: ( ( '=' ) )
            // InternalEduTest.g:3804:1: ( '=' )
            {
            // InternalEduTest.g:3804:1: ( '=' )
            // InternalEduTest.g:3805:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:3814:1: rule__MultiChoiceEmConfig__Group__3 : rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 ;
    public final void rule__MultiChoiceEmConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3818:1: ( rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 )
            // InternalEduTest.g:3819:2: rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4
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
    // InternalEduTest.g:3826:1: rule__MultiChoiceEmConfig__Group__3__Impl : ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3830:1: ( ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) )
            // InternalEduTest.g:3831:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:3831:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            // InternalEduTest.g:3832:2: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:3833:2: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            // InternalEduTest.g:3833:3: rule__MultiChoiceEmConfig__RetryAssignment_3
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
    // InternalEduTest.g:3841:1: rule__MultiChoiceEmConfig__Group__4 : rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 ;
    public final void rule__MultiChoiceEmConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3845:1: ( rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 )
            // InternalEduTest.g:3846:2: rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5
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
    // InternalEduTest.g:3853:1: rule__MultiChoiceEmConfig__Group__4__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3857:1: ( ( ',' ) )
            // InternalEduTest.g:3858:1: ( ',' )
            {
            // InternalEduTest.g:3858:1: ( ',' )
            // InternalEduTest.g:3859:2: ','
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
    // InternalEduTest.g:3868:1: rule__MultiChoiceEmConfig__Group__5 : rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 ;
    public final void rule__MultiChoiceEmConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3872:1: ( rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 )
            // InternalEduTest.g:3873:2: rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6
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
    // InternalEduTest.g:3880:1: rule__MultiChoiceEmConfig__Group__5__Impl : ( 'weighted' ) ;
    public final void rule__MultiChoiceEmConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3884:1: ( ( 'weighted' ) )
            // InternalEduTest.g:3885:1: ( 'weighted' )
            {
            // InternalEduTest.g:3885:1: ( 'weighted' )
            // InternalEduTest.g:3886:2: 'weighted'
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
    // InternalEduTest.g:3895:1: rule__MultiChoiceEmConfig__Group__6 : rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 ;
    public final void rule__MultiChoiceEmConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3899:1: ( rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 )
            // InternalEduTest.g:3900:2: rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7
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
    // InternalEduTest.g:3907:1: rule__MultiChoiceEmConfig__Group__6__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3911:1: ( ( '=' ) )
            // InternalEduTest.g:3912:1: ( '=' )
            {
            // InternalEduTest.g:3912:1: ( '=' )
            // InternalEduTest.g:3913:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:3922:1: rule__MultiChoiceEmConfig__Group__7 : rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 ;
    public final void rule__MultiChoiceEmConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3926:1: ( rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 )
            // InternalEduTest.g:3927:2: rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8
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
    // InternalEduTest.g:3934:1: rule__MultiChoiceEmConfig__Group__7__Impl : ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3938:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) )
            // InternalEduTest.g:3939:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            {
            // InternalEduTest.g:3939:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            // InternalEduTest.g:3940:2: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAssignment_7()); 
            // InternalEduTest.g:3941:2: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            // InternalEduTest.g:3941:3: rule__MultiChoiceEmConfig__WeightedAssignment_7
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
    // InternalEduTest.g:3949:1: rule__MultiChoiceEmConfig__Group__8 : rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 ;
    public final void rule__MultiChoiceEmConfig__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3953:1: ( rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 )
            // InternalEduTest.g:3954:2: rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9
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
    // InternalEduTest.g:3961:1: rule__MultiChoiceEmConfig__Group__8__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3965:1: ( ( ',' ) )
            // InternalEduTest.g:3966:1: ( ',' )
            {
            // InternalEduTest.g:3966:1: ( ',' )
            // InternalEduTest.g:3967:2: ','
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
    // InternalEduTest.g:3976:1: rule__MultiChoiceEmConfig__Group__9 : rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 ;
    public final void rule__MultiChoiceEmConfig__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3980:1: ( rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 )
            // InternalEduTest.g:3981:2: rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10
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
    // InternalEduTest.g:3988:1: rule__MultiChoiceEmConfig__Group__9__Impl : ( 'penalty' ) ;
    public final void rule__MultiChoiceEmConfig__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:3992:1: ( ( 'penalty' ) )
            // InternalEduTest.g:3993:1: ( 'penalty' )
            {
            // InternalEduTest.g:3993:1: ( 'penalty' )
            // InternalEduTest.g:3994:2: 'penalty'
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
    // InternalEduTest.g:4003:1: rule__MultiChoiceEmConfig__Group__10 : rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 ;
    public final void rule__MultiChoiceEmConfig__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4007:1: ( rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 )
            // InternalEduTest.g:4008:2: rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11
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
    // InternalEduTest.g:4015:1: rule__MultiChoiceEmConfig__Group__10__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4019:1: ( ( '=' ) )
            // InternalEduTest.g:4020:1: ( '=' )
            {
            // InternalEduTest.g:4020:1: ( '=' )
            // InternalEduTest.g:4021:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:4030:1: rule__MultiChoiceEmConfig__Group__11 : rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 ;
    public final void rule__MultiChoiceEmConfig__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4034:1: ( rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 )
            // InternalEduTest.g:4035:2: rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12
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
    // InternalEduTest.g:4042:1: rule__MultiChoiceEmConfig__Group__11__Impl : ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4046:1: ( ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) )
            // InternalEduTest.g:4047:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            {
            // InternalEduTest.g:4047:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            // InternalEduTest.g:4048:2: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyAssignment_11()); 
            // InternalEduTest.g:4049:2: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            // InternalEduTest.g:4049:3: rule__MultiChoiceEmConfig__PenaltyAssignment_11
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
    // InternalEduTest.g:4057:1: rule__MultiChoiceEmConfig__Group__12 : rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 ;
    public final void rule__MultiChoiceEmConfig__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4061:1: ( rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 )
            // InternalEduTest.g:4062:2: rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13
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
    // InternalEduTest.g:4069:1: rule__MultiChoiceEmConfig__Group__12__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4073:1: ( ( ',' ) )
            // InternalEduTest.g:4074:1: ( ',' )
            {
            // InternalEduTest.g:4074:1: ( ',' )
            // InternalEduTest.g:4075:2: ','
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
    // InternalEduTest.g:4084:1: rule__MultiChoiceEmConfig__Group__13 : rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 ;
    public final void rule__MultiChoiceEmConfig__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4088:1: ( rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 )
            // InternalEduTest.g:4089:2: rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14
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
    // InternalEduTest.g:4096:1: rule__MultiChoiceEmConfig__Group__13__Impl : ( 'order' ) ;
    public final void rule__MultiChoiceEmConfig__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4100:1: ( ( 'order' ) )
            // InternalEduTest.g:4101:1: ( 'order' )
            {
            // InternalEduTest.g:4101:1: ( 'order' )
            // InternalEduTest.g:4102:2: 'order'
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
    // InternalEduTest.g:4111:1: rule__MultiChoiceEmConfig__Group__14 : rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 ;
    public final void rule__MultiChoiceEmConfig__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4115:1: ( rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 )
            // InternalEduTest.g:4116:2: rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15
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
    // InternalEduTest.g:4123:1: rule__MultiChoiceEmConfig__Group__14__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4127:1: ( ( '=' ) )
            // InternalEduTest.g:4128:1: ( '=' )
            {
            // InternalEduTest.g:4128:1: ( '=' )
            // InternalEduTest.g:4129:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:4138:1: rule__MultiChoiceEmConfig__Group__15 : rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 ;
    public final void rule__MultiChoiceEmConfig__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4142:1: ( rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 )
            // InternalEduTest.g:4143:2: rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16
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
    // InternalEduTest.g:4150:1: rule__MultiChoiceEmConfig__Group__15__Impl : ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4154:1: ( ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) )
            // InternalEduTest.g:4155:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            {
            // InternalEduTest.g:4155:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            // InternalEduTest.g:4156:2: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderAssignment_15()); 
            // InternalEduTest.g:4157:2: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            // InternalEduTest.g:4157:3: rule__MultiChoiceEmConfig__OrderAssignment_15
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
    // InternalEduTest.g:4165:1: rule__MultiChoiceEmConfig__Group__16 : rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 ;
    public final void rule__MultiChoiceEmConfig__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4169:1: ( rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 )
            // InternalEduTest.g:4170:2: rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17
            {
            pushFollow(FOLLOW_15);
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
    // InternalEduTest.g:4177:1: rule__MultiChoiceEmConfig__Group__16__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4181:1: ( ( ',' ) )
            // InternalEduTest.g:4182:1: ( ',' )
            {
            // InternalEduTest.g:4182:1: ( ',' )
            // InternalEduTest.g:4183:2: ','
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
    // InternalEduTest.g:4192:1: rule__MultiChoiceEmConfig__Group__17 : rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 ;
    public final void rule__MultiChoiceEmConfig__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4196:1: ( rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 )
            // InternalEduTest.g:4197:2: rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18
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
    // InternalEduTest.g:4204:1: rule__MultiChoiceEmConfig__Group__17__Impl : ( 'mode' ) ;
    public final void rule__MultiChoiceEmConfig__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4208:1: ( ( 'mode' ) )
            // InternalEduTest.g:4209:1: ( 'mode' )
            {
            // InternalEduTest.g:4209:1: ( 'mode' )
            // InternalEduTest.g:4210:2: 'mode'
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
    // InternalEduTest.g:4219:1: rule__MultiChoiceEmConfig__Group__18 : rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 ;
    public final void rule__MultiChoiceEmConfig__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4223:1: ( rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 )
            // InternalEduTest.g:4224:2: rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19
            {
            pushFollow(FOLLOW_16);
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
    // InternalEduTest.g:4231:1: rule__MultiChoiceEmConfig__Group__18__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4235:1: ( ( '=' ) )
            // InternalEduTest.g:4236:1: ( '=' )
            {
            // InternalEduTest.g:4236:1: ( '=' )
            // InternalEduTest.g:4237:2: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:4246:1: rule__MultiChoiceEmConfig__Group__19 : rule__MultiChoiceEmConfig__Group__19__Impl ;
    public final void rule__MultiChoiceEmConfig__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4250:1: ( rule__MultiChoiceEmConfig__Group__19__Impl )
            // InternalEduTest.g:4251:2: rule__MultiChoiceEmConfig__Group__19__Impl
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
    // InternalEduTest.g:4257:1: rule__MultiChoiceEmConfig__Group__19__Impl : ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4261:1: ( ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) )
            // InternalEduTest.g:4262:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            {
            // InternalEduTest.g:4262:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            // InternalEduTest.g:4263:2: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeAssignment_19()); 
            // InternalEduTest.g:4264:2: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            // InternalEduTest.g:4264:3: rule__MultiChoiceEmConfig__ModeAssignment_19
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


    // $ANTLR start "rule__TextConfiguration__Group__0"
    // InternalEduTest.g:4273:1: rule__TextConfiguration__Group__0 : rule__TextConfiguration__Group__0__Impl rule__TextConfiguration__Group__1 ;
    public final void rule__TextConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4277:1: ( rule__TextConfiguration__Group__0__Impl rule__TextConfiguration__Group__1 )
            // InternalEduTest.g:4278:2: rule__TextConfiguration__Group__0__Impl rule__TextConfiguration__Group__1
            {
            pushFollow(FOLLOW_6);
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
    // InternalEduTest.g:4285:1: rule__TextConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__TextConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4289:1: ( ( () ) )
            // InternalEduTest.g:4290:1: ( () )
            {
            // InternalEduTest.g:4290:1: ( () )
            // InternalEduTest.g:4291:2: ()
            {
             before(grammarAccess.getTextConfigurationAccess().getTextConfigurationAction_0()); 
            // InternalEduTest.g:4292:2: ()
            // InternalEduTest.g:4292:3: 
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
    // InternalEduTest.g:4300:1: rule__TextConfiguration__Group__1 : rule__TextConfiguration__Group__1__Impl rule__TextConfiguration__Group__2 ;
    public final void rule__TextConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4304:1: ( rule__TextConfiguration__Group__1__Impl rule__TextConfiguration__Group__2 )
            // InternalEduTest.g:4305:2: rule__TextConfiguration__Group__1__Impl rule__TextConfiguration__Group__2
            {
            pushFollow(FOLLOW_12);
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
    // InternalEduTest.g:4312:1: rule__TextConfiguration__Group__1__Impl : ( 'retry' ) ;
    public final void rule__TextConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4316:1: ( ( 'retry' ) )
            // InternalEduTest.g:4317:1: ( 'retry' )
            {
            // InternalEduTest.g:4317:1: ( 'retry' )
            // InternalEduTest.g:4318:2: 'retry'
            {
             before(grammarAccess.getTextConfigurationAccess().getRetryKeyword_1()); 
            match(input,36,FOLLOW_2); 
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
    // InternalEduTest.g:4327:1: rule__TextConfiguration__Group__2 : rule__TextConfiguration__Group__2__Impl rule__TextConfiguration__Group__3 ;
    public final void rule__TextConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4331:1: ( rule__TextConfiguration__Group__2__Impl rule__TextConfiguration__Group__3 )
            // InternalEduTest.g:4332:2: rule__TextConfiguration__Group__2__Impl rule__TextConfiguration__Group__3
            {
            pushFollow(FOLLOW_14);
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
    // InternalEduTest.g:4339:1: rule__TextConfiguration__Group__2__Impl : ( '=' ) ;
    public final void rule__TextConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4343:1: ( ( '=' ) )
            // InternalEduTest.g:4344:1: ( '=' )
            {
            // InternalEduTest.g:4344:1: ( '=' )
            // InternalEduTest.g:4345:2: '='
            {
             before(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_2()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:4354:1: rule__TextConfiguration__Group__3 : rule__TextConfiguration__Group__3__Impl rule__TextConfiguration__Group__4 ;
    public final void rule__TextConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4358:1: ( rule__TextConfiguration__Group__3__Impl rule__TextConfiguration__Group__4 )
            // InternalEduTest.g:4359:2: rule__TextConfiguration__Group__3__Impl rule__TextConfiguration__Group__4
            {
            pushFollow(FOLLOW_9);
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
    // InternalEduTest.g:4366:1: rule__TextConfiguration__Group__3__Impl : ( ( rule__TextConfiguration__RetryAssignment_3 ) ) ;
    public final void rule__TextConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4370:1: ( ( ( rule__TextConfiguration__RetryAssignment_3 ) ) )
            // InternalEduTest.g:4371:1: ( ( rule__TextConfiguration__RetryAssignment_3 ) )
            {
            // InternalEduTest.g:4371:1: ( ( rule__TextConfiguration__RetryAssignment_3 ) )
            // InternalEduTest.g:4372:2: ( rule__TextConfiguration__RetryAssignment_3 )
            {
             before(grammarAccess.getTextConfigurationAccess().getRetryAssignment_3()); 
            // InternalEduTest.g:4373:2: ( rule__TextConfiguration__RetryAssignment_3 )
            // InternalEduTest.g:4373:3: rule__TextConfiguration__RetryAssignment_3
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
    // InternalEduTest.g:4381:1: rule__TextConfiguration__Group__4 : rule__TextConfiguration__Group__4__Impl rule__TextConfiguration__Group__5 ;
    public final void rule__TextConfiguration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4385:1: ( rule__TextConfiguration__Group__4__Impl rule__TextConfiguration__Group__5 )
            // InternalEduTest.g:4386:2: rule__TextConfiguration__Group__4__Impl rule__TextConfiguration__Group__5
            {
            pushFollow(FOLLOW_27);
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
    // InternalEduTest.g:4393:1: rule__TextConfiguration__Group__4__Impl : ( ',' ) ;
    public final void rule__TextConfiguration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4397:1: ( ( ',' ) )
            // InternalEduTest.g:4398:1: ( ',' )
            {
            // InternalEduTest.g:4398:1: ( ',' )
            // InternalEduTest.g:4399:2: ','
            {
             before(grammarAccess.getTextConfigurationAccess().getCommaKeyword_4()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getCommaKeyword_4()); 

            }


            }

        }
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
    // InternalEduTest.g:4408:1: rule__TextConfiguration__Group__5 : rule__TextConfiguration__Group__5__Impl rule__TextConfiguration__Group__6 ;
    public final void rule__TextConfiguration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4412:1: ( rule__TextConfiguration__Group__5__Impl rule__TextConfiguration__Group__6 )
            // InternalEduTest.g:4413:2: rule__TextConfiguration__Group__5__Impl rule__TextConfiguration__Group__6
            {
            pushFollow(FOLLOW_12);
            rule__TextConfiguration__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__6();

            state._fsp--;


            }

        }
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
    // InternalEduTest.g:4420:1: rule__TextConfiguration__Group__5__Impl : ( 'text' ) ;
    public final void rule__TextConfiguration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4424:1: ( ( 'text' ) )
            // InternalEduTest.g:4425:1: ( 'text' )
            {
            // InternalEduTest.g:4425:1: ( 'text' )
            // InternalEduTest.g:4426:2: 'text'
            {
             before(grammarAccess.getTextConfigurationAccess().getTextKeyword_5()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getTextKeyword_5()); 

            }


            }

        }
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


    // $ANTLR start "rule__TextConfiguration__Group__6"
    // InternalEduTest.g:4435:1: rule__TextConfiguration__Group__6 : rule__TextConfiguration__Group__6__Impl rule__TextConfiguration__Group__7 ;
    public final void rule__TextConfiguration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4439:1: ( rule__TextConfiguration__Group__6__Impl rule__TextConfiguration__Group__7 )
            // InternalEduTest.g:4440:2: rule__TextConfiguration__Group__6__Impl rule__TextConfiguration__Group__7
            {
            pushFollow(FOLLOW_19);
            rule__TextConfiguration__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__6"


    // $ANTLR start "rule__TextConfiguration__Group__6__Impl"
    // InternalEduTest.g:4447:1: rule__TextConfiguration__Group__6__Impl : ( '=' ) ;
    public final void rule__TextConfiguration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4451:1: ( ( '=' ) )
            // InternalEduTest.g:4452:1: ( '=' )
            {
            // InternalEduTest.g:4452:1: ( '=' )
            // InternalEduTest.g:4453:2: '='
            {
             before(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_6()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getTextConfigurationAccess().getEqualsSignKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__6__Impl"


    // $ANTLR start "rule__TextConfiguration__Group__7"
    // InternalEduTest.g:4462:1: rule__TextConfiguration__Group__7 : rule__TextConfiguration__Group__7__Impl ;
    public final void rule__TextConfiguration__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4466:1: ( rule__TextConfiguration__Group__7__Impl )
            // InternalEduTest.g:4467:2: rule__TextConfiguration__Group__7__Impl
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__7"


    // $ANTLR start "rule__TextConfiguration__Group__7__Impl"
    // InternalEduTest.g:4473:1: rule__TextConfiguration__Group__7__Impl : ( ( rule__TextConfiguration__IdentifierAssignment_7 ) ) ;
    public final void rule__TextConfiguration__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4477:1: ( ( ( rule__TextConfiguration__IdentifierAssignment_7 ) ) )
            // InternalEduTest.g:4478:1: ( ( rule__TextConfiguration__IdentifierAssignment_7 ) )
            {
            // InternalEduTest.g:4478:1: ( ( rule__TextConfiguration__IdentifierAssignment_7 ) )
            // InternalEduTest.g:4479:2: ( rule__TextConfiguration__IdentifierAssignment_7 )
            {
             before(grammarAccess.getTextConfigurationAccess().getIdentifierAssignment_7()); 
            // InternalEduTest.g:4480:2: ( rule__TextConfiguration__IdentifierAssignment_7 )
            // InternalEduTest.g:4480:3: rule__TextConfiguration__IdentifierAssignment_7
            {
            pushFollow(FOLLOW_2);
            rule__TextConfiguration__IdentifierAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getTextConfigurationAccess().getIdentifierAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__Group__7__Impl"


    // $ANTLR start "rule__Test__Group__0"
    // InternalEduTest.g:4489:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4493:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // InternalEduTest.g:4494:2: rule__Test__Group__0__Impl rule__Test__Group__1
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
    // InternalEduTest.g:4501:1: rule__Test__Group__0__Impl : ( 'description' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4505:1: ( ( 'description' ) )
            // InternalEduTest.g:4506:1: ( 'description' )
            {
            // InternalEduTest.g:4506:1: ( 'description' )
            // InternalEduTest.g:4507:2: 'description'
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
    // InternalEduTest.g:4516:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4520:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // InternalEduTest.g:4521:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_19);
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
    // InternalEduTest.g:4528:1: rule__Test__Group__1__Impl : ( 'for' ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4532:1: ( ( 'for' ) )
            // InternalEduTest.g:4533:1: ( 'for' )
            {
            // InternalEduTest.g:4533:1: ( 'for' )
            // InternalEduTest.g:4534:2: 'for'
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
    // InternalEduTest.g:4543:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4547:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // InternalEduTest.g:4548:2: rule__Test__Group__2__Impl rule__Test__Group__3
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
    // InternalEduTest.g:4555:1: rule__Test__Group__2__Impl : ( ( rule__Test__SourceAssignment_2 ) ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4559:1: ( ( ( rule__Test__SourceAssignment_2 ) ) )
            // InternalEduTest.g:4560:1: ( ( rule__Test__SourceAssignment_2 ) )
            {
            // InternalEduTest.g:4560:1: ( ( rule__Test__SourceAssignment_2 ) )
            // InternalEduTest.g:4561:2: ( rule__Test__SourceAssignment_2 )
            {
             before(grammarAccess.getTestAccess().getSourceAssignment_2()); 
            // InternalEduTest.g:4562:2: ( rule__Test__SourceAssignment_2 )
            // InternalEduTest.g:4562:3: rule__Test__SourceAssignment_2
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
    // InternalEduTest.g:4570:1: rule__Test__Group__3 : rule__Test__Group__3__Impl rule__Test__Group__4 ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4574:1: ( rule__Test__Group__3__Impl rule__Test__Group__4 )
            // InternalEduTest.g:4575:2: rule__Test__Group__3__Impl rule__Test__Group__4
            {
            pushFollow(FOLLOW_19);
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
    // InternalEduTest.g:4582:1: rule__Test__Group__3__Impl : ( '=' ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4586:1: ( ( '=' ) )
            // InternalEduTest.g:4587:1: ( '=' )
            {
            // InternalEduTest.g:4587:1: ( '=' )
            // InternalEduTest.g:4588:2: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_3()); 
            match(input,35,FOLLOW_2); 
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
    // InternalEduTest.g:4597:1: rule__Test__Group__4 : rule__Test__Group__4__Impl rule__Test__Group__5 ;
    public final void rule__Test__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4601:1: ( rule__Test__Group__4__Impl rule__Test__Group__5 )
            // InternalEduTest.g:4602:2: rule__Test__Group__4__Impl rule__Test__Group__5
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
    // InternalEduTest.g:4609:1: rule__Test__Group__4__Impl : ( ( rule__Test__QuestionAssignment_4 ) ) ;
    public final void rule__Test__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4613:1: ( ( ( rule__Test__QuestionAssignment_4 ) ) )
            // InternalEduTest.g:4614:1: ( ( rule__Test__QuestionAssignment_4 ) )
            {
            // InternalEduTest.g:4614:1: ( ( rule__Test__QuestionAssignment_4 ) )
            // InternalEduTest.g:4615:2: ( rule__Test__QuestionAssignment_4 )
            {
             before(grammarAccess.getTestAccess().getQuestionAssignment_4()); 
            // InternalEduTest.g:4616:2: ( rule__Test__QuestionAssignment_4 )
            // InternalEduTest.g:4616:3: rule__Test__QuestionAssignment_4
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
    // InternalEduTest.g:4624:1: rule__Test__Group__5 : rule__Test__Group__5__Impl ;
    public final void rule__Test__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4628:1: ( rule__Test__Group__5__Impl )
            // InternalEduTest.g:4629:2: rule__Test__Group__5__Impl
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
    // InternalEduTest.g:4635:1: rule__Test__Group__5__Impl : ( ( rule__Test__Group_5__0 )? ) ;
    public final void rule__Test__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4639:1: ( ( ( rule__Test__Group_5__0 )? ) )
            // InternalEduTest.g:4640:1: ( ( rule__Test__Group_5__0 )? )
            {
            // InternalEduTest.g:4640:1: ( ( rule__Test__Group_5__0 )? )
            // InternalEduTest.g:4641:2: ( rule__Test__Group_5__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_5()); 
            // InternalEduTest.g:4642:2: ( rule__Test__Group_5__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==50) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalEduTest.g:4642:3: rule__Test__Group_5__0
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
    // InternalEduTest.g:4651:1: rule__Test__Group_5__0 : rule__Test__Group_5__0__Impl rule__Test__Group_5__1 ;
    public final void rule__Test__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4655:1: ( rule__Test__Group_5__0__Impl rule__Test__Group_5__1 )
            // InternalEduTest.g:4656:2: rule__Test__Group_5__0__Impl rule__Test__Group_5__1
            {
            pushFollow(FOLLOW_18);
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
    // InternalEduTest.g:4663:1: rule__Test__Group_5__0__Impl : ( ( rule__Test__ExpressionAssignment_5_0 ) ) ;
    public final void rule__Test__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4667:1: ( ( ( rule__Test__ExpressionAssignment_5_0 ) ) )
            // InternalEduTest.g:4668:1: ( ( rule__Test__ExpressionAssignment_5_0 ) )
            {
            // InternalEduTest.g:4668:1: ( ( rule__Test__ExpressionAssignment_5_0 ) )
            // InternalEduTest.g:4669:2: ( rule__Test__ExpressionAssignment_5_0 )
            {
             before(grammarAccess.getTestAccess().getExpressionAssignment_5_0()); 
            // InternalEduTest.g:4670:2: ( rule__Test__ExpressionAssignment_5_0 )
            // InternalEduTest.g:4670:3: rule__Test__ExpressionAssignment_5_0
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
    // InternalEduTest.g:4678:1: rule__Test__Group_5__1 : rule__Test__Group_5__1__Impl ;
    public final void rule__Test__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4682:1: ( rule__Test__Group_5__1__Impl )
            // InternalEduTest.g:4683:2: rule__Test__Group_5__1__Impl
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
    // InternalEduTest.g:4689:1: rule__Test__Group_5__1__Impl : ( ( rule__Test__Group_5_1__0 )? ) ;
    public final void rule__Test__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4693:1: ( ( ( rule__Test__Group_5_1__0 )? ) )
            // InternalEduTest.g:4694:1: ( ( rule__Test__Group_5_1__0 )? )
            {
            // InternalEduTest.g:4694:1: ( ( rule__Test__Group_5_1__0 )? )
            // InternalEduTest.g:4695:2: ( rule__Test__Group_5_1__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_5_1()); 
            // InternalEduTest.g:4696:2: ( rule__Test__Group_5_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==39) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalEduTest.g:4696:3: rule__Test__Group_5_1__0
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
    // InternalEduTest.g:4705:1: rule__Test__Group_5_1__0 : rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1 ;
    public final void rule__Test__Group_5_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4709:1: ( rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1 )
            // InternalEduTest.g:4710:2: rule__Test__Group_5_1__0__Impl rule__Test__Group_5_1__1
            {
            pushFollow(FOLLOW_19);
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
    // InternalEduTest.g:4717:1: rule__Test__Group_5_1__0__Impl : ( '(' ) ;
    public final void rule__Test__Group_5_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4721:1: ( ( '(' ) )
            // InternalEduTest.g:4722:1: ( '(' )
            {
            // InternalEduTest.g:4722:1: ( '(' )
            // InternalEduTest.g:4723:2: '('
            {
             before(grammarAccess.getTestAccess().getLeftParenthesisKeyword_5_1_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalEduTest.g:4732:1: rule__Test__Group_5_1__1 : rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2 ;
    public final void rule__Test__Group_5_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4736:1: ( rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2 )
            // InternalEduTest.g:4737:2: rule__Test__Group_5_1__1__Impl rule__Test__Group_5_1__2
            {
            pushFollow(FOLLOW_20);
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
    // InternalEduTest.g:4744:1: rule__Test__Group_5_1__1__Impl : ( ( rule__Test__IdentifierAssignment_5_1_1 ) ) ;
    public final void rule__Test__Group_5_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4748:1: ( ( ( rule__Test__IdentifierAssignment_5_1_1 ) ) )
            // InternalEduTest.g:4749:1: ( ( rule__Test__IdentifierAssignment_5_1_1 ) )
            {
            // InternalEduTest.g:4749:1: ( ( rule__Test__IdentifierAssignment_5_1_1 ) )
            // InternalEduTest.g:4750:2: ( rule__Test__IdentifierAssignment_5_1_1 )
            {
             before(grammarAccess.getTestAccess().getIdentifierAssignment_5_1_1()); 
            // InternalEduTest.g:4751:2: ( rule__Test__IdentifierAssignment_5_1_1 )
            // InternalEduTest.g:4751:3: rule__Test__IdentifierAssignment_5_1_1
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
    // InternalEduTest.g:4759:1: rule__Test__Group_5_1__2 : rule__Test__Group_5_1__2__Impl ;
    public final void rule__Test__Group_5_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4763:1: ( rule__Test__Group_5_1__2__Impl )
            // InternalEduTest.g:4764:2: rule__Test__Group_5_1__2__Impl
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
    // InternalEduTest.g:4770:1: rule__Test__Group_5_1__2__Impl : ( ')' ) ;
    public final void rule__Test__Group_5_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4774:1: ( ( ')' ) )
            // InternalEduTest.g:4775:1: ( ')' )
            {
            // InternalEduTest.g:4775:1: ( ')' )
            // InternalEduTest.g:4776:2: ')'
            {
             before(grammarAccess.getTestAccess().getRightParenthesisKeyword_5_1_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalEduTest.g:4786:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4790:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // InternalEduTest.g:4791:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
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
    // InternalEduTest.g:4798:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4802:1: ( ( ( '-' )? ) )
            // InternalEduTest.g:4803:1: ( ( '-' )? )
            {
            // InternalEduTest.g:4803:1: ( ( '-' )? )
            // InternalEduTest.g:4804:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // InternalEduTest.g:4805:2: ( '-' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==48) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalEduTest.g:4805:3: '-'
                    {
                    match(input,48,FOLLOW_2); 

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
    // InternalEduTest.g:4813:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4817:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // InternalEduTest.g:4818:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
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
    // InternalEduTest.g:4825:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4829:1: ( ( ( RULE_INT )? ) )
            // InternalEduTest.g:4830:1: ( ( RULE_INT )? )
            {
            // InternalEduTest.g:4830:1: ( ( RULE_INT )? )
            // InternalEduTest.g:4831:2: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // InternalEduTest.g:4832:2: ( RULE_INT )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_INT) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalEduTest.g:4832:3: RULE_INT
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
    // InternalEduTest.g:4840:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4844:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // InternalEduTest.g:4845:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalEduTest.g:4852:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4856:1: ( ( '.' ) )
            // InternalEduTest.g:4857:1: ( '.' )
            {
            // InternalEduTest.g:4857:1: ( '.' )
            // InternalEduTest.g:4858:2: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,49,FOLLOW_2); 
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
    // InternalEduTest.g:4867:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4871:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // InternalEduTest.g:4872:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FOLLOW_31);
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
    // InternalEduTest.g:4879:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4883:1: ( ( RULE_INT ) )
            // InternalEduTest.g:4884:1: ( RULE_INT )
            {
            // InternalEduTest.g:4884:1: ( RULE_INT )
            // InternalEduTest.g:4885:2: RULE_INT
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
    // InternalEduTest.g:4894:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4898:1: ( rule__EDouble__Group__4__Impl )
            // InternalEduTest.g:4899:2: rule__EDouble__Group__4__Impl
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
    // InternalEduTest.g:4905:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4909:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // InternalEduTest.g:4910:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // InternalEduTest.g:4910:1: ( ( rule__EDouble__Group_4__0 )? )
            // InternalEduTest.g:4911:2: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // InternalEduTest.g:4912:2: ( rule__EDouble__Group_4__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( ((LA44_0>=13 && LA44_0<=14)) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalEduTest.g:4912:3: rule__EDouble__Group_4__0
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
    // InternalEduTest.g:4921:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4925:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // InternalEduTest.g:4926:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FOLLOW_32);
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
    // InternalEduTest.g:4933:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4937:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // InternalEduTest.g:4938:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // InternalEduTest.g:4938:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // InternalEduTest.g:4939:2: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // InternalEduTest.g:4940:2: ( rule__EDouble__Alternatives_4_0 )
            // InternalEduTest.g:4940:3: rule__EDouble__Alternatives_4_0
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
    // InternalEduTest.g:4948:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4952:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // InternalEduTest.g:4953:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalEduTest.g:4960:1: rule__EDouble__Group_4__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4964:1: ( ( ( '-' )? ) )
            // InternalEduTest.g:4965:1: ( ( '-' )? )
            {
            // InternalEduTest.g:4965:1: ( ( '-' )? )
            // InternalEduTest.g:4966:2: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
            // InternalEduTest.g:4967:2: ( '-' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==48) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalEduTest.g:4967:3: '-'
                    {
                    match(input,48,FOLLOW_2); 

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
    // InternalEduTest.g:4975:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4979:1: ( rule__EDouble__Group_4__2__Impl )
            // InternalEduTest.g:4980:2: rule__EDouble__Group_4__2__Impl
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
    // InternalEduTest.g:4986:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:4990:1: ( ( RULE_INT ) )
            // InternalEduTest.g:4991:1: ( RULE_INT )
            {
            // InternalEduTest.g:4991:1: ( RULE_INT )
            // InternalEduTest.g:4992:2: RULE_INT
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
    // InternalEduTest.g:5002:1: rule__Program__ConfigAssignment_1 : ( ruleProgramConfiguration ) ;
    public final void rule__Program__ConfigAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5006:1: ( ( ruleProgramConfiguration ) )
            // InternalEduTest.g:5007:2: ( ruleProgramConfiguration )
            {
            // InternalEduTest.g:5007:2: ( ruleProgramConfiguration )
            // InternalEduTest.g:5008:3: ruleProgramConfiguration
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
    // InternalEduTest.g:5017:1: rule__Program__ExercisesAssignment_2 : ( ruleMutatorTests ) ;
    public final void rule__Program__ExercisesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5021:1: ( ( ruleMutatorTests ) )
            // InternalEduTest.g:5022:2: ( ruleMutatorTests )
            {
            // InternalEduTest.g:5022:2: ( ruleMutatorTests )
            // InternalEduTest.g:5023:3: ruleMutatorTests
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
    // InternalEduTest.g:5032:1: rule__AlternativeResponse__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__AlternativeResponse__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5036:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5037:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5037:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5038:3: ( RULE_ID )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5039:3: ( RULE_ID )
            // InternalEduTest.g:5040:4: RULE_ID
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
    // InternalEduTest.g:5051:1: rule__AlternativeResponse__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AlternativeResponse__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5055:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5056:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5056:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5057:3: ( RULE_ID )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5058:3: ( RULE_ID )
            // InternalEduTest.g:5059:4: RULE_ID
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
    // InternalEduTest.g:5070:1: rule__AlternativeResponse__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__AlternativeResponse__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5074:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:5075:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:5075:2: ( ruleTestConfiguration )
            // InternalEduTest.g:5076:3: ruleTestConfiguration
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
    // InternalEduTest.g:5085:1: rule__AlternativeResponse__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__AlternativeResponse__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5089:1: ( ( ruleTest ) )
            // InternalEduTest.g:5090:2: ( ruleTest )
            {
            // InternalEduTest.g:5090:2: ( ruleTest )
            // InternalEduTest.g:5091:3: ruleTest
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
    // InternalEduTest.g:5100:1: rule__MultiChoiceDiagram__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceDiagram__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5104:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5105:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5105:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5106:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5107:3: ( RULE_ID )
            // InternalEduTest.g:5108:4: RULE_ID
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
    // InternalEduTest.g:5119:1: rule__MultiChoiceDiagram__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceDiagram__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5123:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5124:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5124:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5125:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5126:3: ( RULE_ID )
            // InternalEduTest.g:5127:4: RULE_ID
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
    // InternalEduTest.g:5138:1: rule__MultiChoiceDiagram__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MultiChoiceDiagram__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5142:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:5143:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:5143:2: ( ruleTestConfiguration )
            // InternalEduTest.g:5144:3: ruleTestConfiguration
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
    // InternalEduTest.g:5153:1: rule__MultiChoiceDiagram__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceDiagram__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5157:1: ( ( ruleTest ) )
            // InternalEduTest.g:5158:2: ( ruleTest )
            {
            // InternalEduTest.g:5158:2: ( ruleTest )
            // InternalEduTest.g:5159:3: ruleTest
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
    // InternalEduTest.g:5168:1: rule__MultiChoiceEmendation__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmendation__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5172:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5173:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5173:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5174:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5175:3: ( RULE_ID )
            // InternalEduTest.g:5176:4: RULE_ID
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
    // InternalEduTest.g:5187:1: rule__MultiChoiceEmendation__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmendation__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5191:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5192:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5192:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5193:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5194:3: ( RULE_ID )
            // InternalEduTest.g:5195:4: RULE_ID
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
    // InternalEduTest.g:5206:1: rule__MultiChoiceEmendation__ConfigAssignment_3 : ( ruleMultiChoiceEmConfig ) ;
    public final void rule__MultiChoiceEmendation__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5210:1: ( ( ruleMultiChoiceEmConfig ) )
            // InternalEduTest.g:5211:2: ( ruleMultiChoiceEmConfig )
            {
            // InternalEduTest.g:5211:2: ( ruleMultiChoiceEmConfig )
            // InternalEduTest.g:5212:3: ruleMultiChoiceEmConfig
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
    // InternalEduTest.g:5221:1: rule__MultiChoiceEmendation__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceEmendation__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5225:1: ( ( ruleTest ) )
            // InternalEduTest.g:5226:2: ( ruleTest )
            {
            // InternalEduTest.g:5226:2: ( ruleTest )
            // InternalEduTest.g:5227:3: ruleTest
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
    // InternalEduTest.g:5236:1: rule__MatchPairs__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MatchPairs__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5240:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5241:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5241:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5242:3: ( RULE_ID )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5243:3: ( RULE_ID )
            // InternalEduTest.g:5244:4: RULE_ID
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
    // InternalEduTest.g:5255:1: rule__MatchPairs__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MatchPairs__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5259:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5260:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5260:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5261:3: ( RULE_ID )
            {
             before(grammarAccess.getMatchPairsAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5262:3: ( RULE_ID )
            // InternalEduTest.g:5263:4: RULE_ID
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
    // InternalEduTest.g:5274:1: rule__MatchPairs__ConfigAssignment_3 : ( ruleTextConfiguration ) ;
    public final void rule__MatchPairs__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5278:1: ( ( ruleTextConfiguration ) )
            // InternalEduTest.g:5279:2: ( ruleTextConfiguration )
            {
            // InternalEduTest.g:5279:2: ( ruleTextConfiguration )
            // InternalEduTest.g:5280:3: ruleTextConfiguration
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
    // InternalEduTest.g:5289:1: rule__MatchPairs__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MatchPairs__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5293:1: ( ( ruleTest ) )
            // InternalEduTest.g:5294:2: ( ruleTest )
            {
            // InternalEduTest.g:5294:2: ( ruleTest )
            // InternalEduTest.g:5295:3: ruleTest
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
    // InternalEduTest.g:5304:1: rule__MissingWords__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MissingWords__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5308:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5309:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5309:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5310:3: ( RULE_ID )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5311:3: ( RULE_ID )
            // InternalEduTest.g:5312:4: RULE_ID
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
    // InternalEduTest.g:5323:1: rule__MissingWords__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MissingWords__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5327:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5328:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5328:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5329:3: ( RULE_ID )
            {
             before(grammarAccess.getMissingWordsAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5330:3: ( RULE_ID )
            // InternalEduTest.g:5331:4: RULE_ID
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
    // InternalEduTest.g:5342:1: rule__MissingWords__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MissingWords__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5346:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:5347:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:5347:2: ( ruleTestConfiguration )
            // InternalEduTest.g:5348:3: ruleTestConfiguration
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
    // InternalEduTest.g:5357:1: rule__MissingWords__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MissingWords__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5361:1: ( ( ruleTest ) )
            // InternalEduTest.g:5362:2: ( ruleTest )
            {
            // InternalEduTest.g:5362:2: ( ruleTest )
            // InternalEduTest.g:5363:3: ruleTest
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


    // $ANTLR start "rule__MultiChoiceText__BlocksAssignment_1_0"
    // InternalEduTest.g:5372:1: rule__MultiChoiceText__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceText__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5376:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5377:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5377:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5378:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5379:3: ( RULE_ID )
            // InternalEduTest.g:5380:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__BlocksAssignment_1_0"


    // $ANTLR start "rule__MultiChoiceText__BlocksAssignment_1_1_1"
    // InternalEduTest.g:5391:1: rule__MultiChoiceText__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceText__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5395:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5396:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5396:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5397:3: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5398:3: ( RULE_ID )
            // InternalEduTest.g:5399:4: RULE_ID
            {
             before(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getMultiChoiceTextAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceText__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__MultiChoiceText__ConfigAssignment_3"
    // InternalEduTest.g:5410:1: rule__MultiChoiceText__ConfigAssignment_3 : ( ruleTextConfiguration ) ;
    public final void rule__MultiChoiceText__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5414:1: ( ( ruleTextConfiguration ) )
            // InternalEduTest.g:5415:2: ( ruleTextConfiguration )
            {
            // InternalEduTest.g:5415:2: ( ruleTextConfiguration )
            // InternalEduTest.g:5416:3: ruleTextConfiguration
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
    // InternalEduTest.g:5425:1: rule__MultiChoiceText__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceText__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5429:1: ( ( ruleTest ) )
            // InternalEduTest.g:5430:2: ( ruleTest )
            {
            // InternalEduTest.g:5430:2: ( ruleTest )
            // InternalEduTest.g:5431:3: ruleTest
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


    // $ANTLR start "rule__AlternativeText__BlocksAssignment_1_0"
    // InternalEduTest.g:5440:1: rule__AlternativeText__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__AlternativeText__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5444:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5445:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5445:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5446:3: ( RULE_ID )
            {
             before(grammarAccess.getAlternativeTextAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5447:3: ( RULE_ID )
            // InternalEduTest.g:5448:4: RULE_ID
            {
             before(grammarAccess.getAlternativeTextAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAlternativeTextAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getAlternativeTextAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__BlocksAssignment_1_0"


    // $ANTLR start "rule__AlternativeText__BlocksAssignment_1_1_1"
    // InternalEduTest.g:5459:1: rule__AlternativeText__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__AlternativeText__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5463:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5464:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5464:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5465:3: ( RULE_ID )
            {
             before(grammarAccess.getAlternativeTextAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5466:3: ( RULE_ID )
            // InternalEduTest.g:5467:4: RULE_ID
            {
             before(grammarAccess.getAlternativeTextAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getAlternativeTextAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getAlternativeTextAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeText__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__AlternativeText__ConfigAssignment_3"
    // InternalEduTest.g:5478:1: rule__AlternativeText__ConfigAssignment_3 : ( ruleTextConfiguration ) ;
    public final void rule__AlternativeText__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5482:1: ( ( ruleTextConfiguration ) )
            // InternalEduTest.g:5483:2: ( ruleTextConfiguration )
            {
            // InternalEduTest.g:5483:2: ( ruleTextConfiguration )
            // InternalEduTest.g:5484:3: ruleTextConfiguration
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
    // InternalEduTest.g:5493:1: rule__AlternativeText__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__AlternativeText__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5497:1: ( ( ruleTest ) )
            // InternalEduTest.g:5498:2: ( ruleTest )
            {
            // InternalEduTest.g:5498:2: ( ruleTest )
            // InternalEduTest.g:5499:3: ruleTest
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


    // $ANTLR start "rule__DragAndDropText__BlocksAssignment_1_0"
    // InternalEduTest.g:5508:1: rule__DragAndDropText__BlocksAssignment_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__DragAndDropText__BlocksAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5512:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5513:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5513:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5514:3: ( RULE_ID )
            {
             before(grammarAccess.getDragAndDropTextAccess().getBlocksBlockCrossReference_1_0_0()); 
            // InternalEduTest.g:5515:3: ( RULE_ID )
            // InternalEduTest.g:5516:4: RULE_ID
            {
             before(grammarAccess.getDragAndDropTextAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDragAndDropTextAccess().getBlocksBlockIDTerminalRuleCall_1_0_0_1()); 

            }

             after(grammarAccess.getDragAndDropTextAccess().getBlocksBlockCrossReference_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__BlocksAssignment_1_0"


    // $ANTLR start "rule__DragAndDropText__BlocksAssignment_1_1_1"
    // InternalEduTest.g:5527:1: rule__DragAndDropText__BlocksAssignment_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__DragAndDropText__BlocksAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5531:1: ( ( ( RULE_ID ) ) )
            // InternalEduTest.g:5532:2: ( ( RULE_ID ) )
            {
            // InternalEduTest.g:5532:2: ( ( RULE_ID ) )
            // InternalEduTest.g:5533:3: ( RULE_ID )
            {
             before(grammarAccess.getDragAndDropTextAccess().getBlocksBlockCrossReference_1_1_1_0()); 
            // InternalEduTest.g:5534:3: ( RULE_ID )
            // InternalEduTest.g:5535:4: RULE_ID
            {
             before(grammarAccess.getDragAndDropTextAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getDragAndDropTextAccess().getBlocksBlockIDTerminalRuleCall_1_1_1_0_1()); 

            }

             after(grammarAccess.getDragAndDropTextAccess().getBlocksBlockCrossReference_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DragAndDropText__BlocksAssignment_1_1_1"


    // $ANTLR start "rule__DragAndDropText__ConfigAssignment_3"
    // InternalEduTest.g:5546:1: rule__DragAndDropText__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__DragAndDropText__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5550:1: ( ( ruleTestConfiguration ) )
            // InternalEduTest.g:5551:2: ( ruleTestConfiguration )
            {
            // InternalEduTest.g:5551:2: ( ruleTestConfiguration )
            // InternalEduTest.g:5552:3: ruleTestConfiguration
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
    // InternalEduTest.g:5561:1: rule__DragAndDropText__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__DragAndDropText__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5565:1: ( ( ruleTest ) )
            // InternalEduTest.g:5566:2: ( ruleTest )
            {
            // InternalEduTest.g:5566:2: ( ruleTest )
            // InternalEduTest.g:5567:3: ruleTest
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
    // InternalEduTest.g:5576:1: rule__ProgramConfiguration__NavigationAssignment_2 : ( ruleNavigation ) ;
    public final void rule__ProgramConfiguration__NavigationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5580:1: ( ( ruleNavigation ) )
            // InternalEduTest.g:5581:2: ( ruleNavigation )
            {
            // InternalEduTest.g:5581:2: ( ruleNavigation )
            // InternalEduTest.g:5582:3: ruleNavigation
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
    // InternalEduTest.g:5591:1: rule__TestConfiguration__RetryAssignment_3 : ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) ;
    public final void rule__TestConfiguration__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5595:1: ( ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:5596:2: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:5596:2: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:5597:3: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:5598:3: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            // InternalEduTest.g:5598:4: rule__TestConfiguration__RetryAlternatives_3_0
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
    // InternalEduTest.g:5606:1: rule__TestConfiguration__ModeAssignment_4_3 : ( ruleMode ) ;
    public final void rule__TestConfiguration__ModeAssignment_4_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5610:1: ( ( ruleMode ) )
            // InternalEduTest.g:5611:2: ( ruleMode )
            {
            // InternalEduTest.g:5611:2: ( ruleMode )
            // InternalEduTest.g:5612:3: ruleMode
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


    // $ANTLR start "rule__TestConfiguration__StatementAssignment_5_4"
    // InternalEduTest.g:5621:1: rule__TestConfiguration__StatementAssignment_5_4 : ( ruleEString ) ;
    public final void rule__TestConfiguration__StatementAssignment_5_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5625:1: ( ( ruleEString ) )
            // InternalEduTest.g:5626:2: ( ruleEString )
            {
            // InternalEduTest.g:5626:2: ( ruleEString )
            // InternalEduTest.g:5627:3: ruleEString
            {
             before(grammarAccess.getTestConfigurationAccess().getStatementEStringParserRuleCall_5_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTestConfigurationAccess().getStatementEStringParserRuleCall_5_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__StatementAssignment_5_4"


    // $ANTLR start "rule__TestConfiguration__AnswersAssignment_6_4"
    // InternalEduTest.g:5636:1: rule__TestConfiguration__AnswersAssignment_6_4 : ( ruleEString ) ;
    public final void rule__TestConfiguration__AnswersAssignment_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5640:1: ( ( ruleEString ) )
            // InternalEduTest.g:5641:2: ( ruleEString )
            {
            // InternalEduTest.g:5641:2: ( ruleEString )
            // InternalEduTest.g:5642:3: ruleEString
            {
             before(grammarAccess.getTestConfigurationAccess().getAnswersEStringParserRuleCall_6_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTestConfigurationAccess().getAnswersEStringParserRuleCall_6_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestConfiguration__AnswersAssignment_6_4"


    // $ANTLR start "rule__MultiChoiceEmConfig__RetryAssignment_3"
    // InternalEduTest.g:5651:1: rule__MultiChoiceEmConfig__RetryAssignment_3 : ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5655:1: ( ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:5656:2: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:5656:2: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:5657:3: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:5658:3: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            // InternalEduTest.g:5658:4: rule__MultiChoiceEmConfig__RetryAlternatives_3_0
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
    // InternalEduTest.g:5666:1: rule__MultiChoiceEmConfig__WeightedAssignment_7 : ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__WeightedAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5670:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) )
            // InternalEduTest.g:5671:2: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            {
            // InternalEduTest.g:5671:2: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            // InternalEduTest.g:5672:3: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAlternatives_7_0()); 
            // InternalEduTest.g:5673:3: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            // InternalEduTest.g:5673:4: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0
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
    // InternalEduTest.g:5681:1: rule__MultiChoiceEmConfig__PenaltyAssignment_11 : ( ruleEDouble ) ;
    public final void rule__MultiChoiceEmConfig__PenaltyAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5685:1: ( ( ruleEDouble ) )
            // InternalEduTest.g:5686:2: ( ruleEDouble )
            {
            // InternalEduTest.g:5686:2: ( ruleEDouble )
            // InternalEduTest.g:5687:3: ruleEDouble
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
    // InternalEduTest.g:5696:1: rule__MultiChoiceEmConfig__OrderAssignment_15 : ( ruleOrder ) ;
    public final void rule__MultiChoiceEmConfig__OrderAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5700:1: ( ( ruleOrder ) )
            // InternalEduTest.g:5701:2: ( ruleOrder )
            {
            // InternalEduTest.g:5701:2: ( ruleOrder )
            // InternalEduTest.g:5702:3: ruleOrder
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
    // InternalEduTest.g:5711:1: rule__MultiChoiceEmConfig__ModeAssignment_19 : ( ruleMode ) ;
    public final void rule__MultiChoiceEmConfig__ModeAssignment_19() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5715:1: ( ( ruleMode ) )
            // InternalEduTest.g:5716:2: ( ruleMode )
            {
            // InternalEduTest.g:5716:2: ( ruleMode )
            // InternalEduTest.g:5717:3: ruleMode
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


    // $ANTLR start "rule__TextConfiguration__RetryAssignment_3"
    // InternalEduTest.g:5726:1: rule__TextConfiguration__RetryAssignment_3 : ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) ) ;
    public final void rule__TextConfiguration__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5730:1: ( ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) ) )
            // InternalEduTest.g:5731:2: ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) )
            {
            // InternalEduTest.g:5731:2: ( ( rule__TextConfiguration__RetryAlternatives_3_0 ) )
            // InternalEduTest.g:5732:3: ( rule__TextConfiguration__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getTextConfigurationAccess().getRetryAlternatives_3_0()); 
            // InternalEduTest.g:5733:3: ( rule__TextConfiguration__RetryAlternatives_3_0 )
            // InternalEduTest.g:5733:4: rule__TextConfiguration__RetryAlternatives_3_0
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


    // $ANTLR start "rule__TextConfiguration__IdentifierAssignment_7"
    // InternalEduTest.g:5741:1: rule__TextConfiguration__IdentifierAssignment_7 : ( ruleEString ) ;
    public final void rule__TextConfiguration__IdentifierAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5745:1: ( ( ruleEString ) )
            // InternalEduTest.g:5746:2: ( ruleEString )
            {
            // InternalEduTest.g:5746:2: ( ruleEString )
            // InternalEduTest.g:5747:3: ruleEString
            {
             before(grammarAccess.getTextConfigurationAccess().getIdentifierEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTextConfigurationAccess().getIdentifierEStringParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TextConfiguration__IdentifierAssignment_7"


    // $ANTLR start "rule__Test__SourceAssignment_2"
    // InternalEduTest.g:5756:1: rule__Test__SourceAssignment_2 : ( ruleEString ) ;
    public final void rule__Test__SourceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5760:1: ( ( ruleEString ) )
            // InternalEduTest.g:5761:2: ( ruleEString )
            {
            // InternalEduTest.g:5761:2: ( ruleEString )
            // InternalEduTest.g:5762:3: ruleEString
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
    // InternalEduTest.g:5771:1: rule__Test__QuestionAssignment_4 : ( ruleEString ) ;
    public final void rule__Test__QuestionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5775:1: ( ( ruleEString ) )
            // InternalEduTest.g:5776:2: ( ruleEString )
            {
            // InternalEduTest.g:5776:2: ( ruleEString )
            // InternalEduTest.g:5777:3: ruleEString
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
    // InternalEduTest.g:5786:1: rule__Test__ExpressionAssignment_5_0 : ( ( '%text' ) ) ;
    public final void rule__Test__ExpressionAssignment_5_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5790:1: ( ( ( '%text' ) ) )
            // InternalEduTest.g:5791:2: ( ( '%text' ) )
            {
            // InternalEduTest.g:5791:2: ( ( '%text' ) )
            // InternalEduTest.g:5792:3: ( '%text' )
            {
             before(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 
            // InternalEduTest.g:5793:3: ( '%text' )
            // InternalEduTest.g:5794:4: '%text'
            {
             before(grammarAccess.getTestAccess().getExpressionTextKeyword_5_0_0()); 
            match(input,50,FOLLOW_2); 
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
    // InternalEduTest.g:5805:1: rule__Test__IdentifierAssignment_5_1_1 : ( ruleEString ) ;
    public final void rule__Test__IdentifierAssignment_5_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalEduTest.g:5809:1: ( ( ruleEString ) )
            // InternalEduTest.g:5810:2: ( ruleEString )
            {
            // InternalEduTest.g:5810:2: ( ruleEString )
            // InternalEduTest.g:5811:3: ruleEString
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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x00000007F8800000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x00000007F8800002L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000001000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000400002000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000600000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000001800L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0003000000000040L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000078000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0001000000000040L});

}