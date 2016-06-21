package org.mutatortests.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.mutatortests.services.TestsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTestsParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'yes'", "'no'", "'E'", "'e'", "'fixed'", "'random'", "'options-ascending'", "'options-descending'", "'radiobutton'", "'checkbox'", "'free'", "'locked'", "'AlternativeResponse'", "'{'", "'}'", "'MultiChoiceDiagram'", "'MultiChoiceEmendation'", "'navigation'", "'='", "'retry'", "','", "'weighted'", "'penalty'", "'order'", "'mode'", "'description'", "'for'", "'-'", "'.'"
    };
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
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


        public InternalTestsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTestsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTestsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g"; }


     
     	private TestsGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TestsGrammarAccess grammarAccess) {
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:60:1: entryRuleProgram : ruleProgram EOF ;
    public final void entryRuleProgram() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:61:1: ( ruleProgram EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:62:1: ruleProgram EOF
            {
             before(grammarAccess.getProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram61);
            ruleProgram();

            state._fsp--;

             after(grammarAccess.getProgramRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram68); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:69:1: ruleProgram : ( ( rule__Program__Group__0 ) ) ;
    public final void ruleProgram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:73:2: ( ( ( rule__Program__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:74:1: ( ( rule__Program__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:74:1: ( ( rule__Program__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:75:1: ( rule__Program__Group__0 )
            {
             before(grammarAccess.getProgramAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:76:1: ( rule__Program__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:76:2: rule__Program__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__0_in_ruleProgram94);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:88:1: entryRuleMutatorTests : ruleMutatorTests EOF ;
    public final void entryRuleMutatorTests() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:89:1: ( ruleMutatorTests EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:90:1: ruleMutatorTests EOF
            {
             before(grammarAccess.getMutatorTestsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorTests_in_entryRuleMutatorTests121);
            ruleMutatorTests();

            state._fsp--;

             after(grammarAccess.getMutatorTestsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutatorTests128); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:97:1: ruleMutatorTests : ( ( rule__MutatorTests__Alternatives ) ) ;
    public final void ruleMutatorTests() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:101:2: ( ( ( rule__MutatorTests__Alternatives ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:102:1: ( ( rule__MutatorTests__Alternatives ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:102:1: ( ( rule__MutatorTests__Alternatives ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:103:1: ( rule__MutatorTests__Alternatives )
            {
             before(grammarAccess.getMutatorTestsAccess().getAlternatives()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:104:1: ( rule__MutatorTests__Alternatives )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:104:2: rule__MutatorTests__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorTests__Alternatives_in_ruleMutatorTests154);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:116:1: entryRuleAlternativeResponse : ruleAlternativeResponse EOF ;
    public final void entryRuleAlternativeResponse() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:117:1: ( ruleAlternativeResponse EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:118:1: ruleAlternativeResponse EOF
            {
             before(grammarAccess.getAlternativeResponseRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAlternativeResponse_in_entryRuleAlternativeResponse181);
            ruleAlternativeResponse();

            state._fsp--;

             after(grammarAccess.getAlternativeResponseRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAlternativeResponse188); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:125:1: ruleAlternativeResponse : ( ( rule__AlternativeResponse__Group__0 ) ) ;
    public final void ruleAlternativeResponse() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:129:2: ( ( ( rule__AlternativeResponse__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:130:1: ( ( rule__AlternativeResponse__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:130:1: ( ( rule__AlternativeResponse__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:131:1: ( rule__AlternativeResponse__Group__0 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:132:1: ( rule__AlternativeResponse__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:132:2: rule__AlternativeResponse__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__0_in_ruleAlternativeResponse214);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:144:1: entryRuleMultiChoiceDiagram : ruleMultiChoiceDiagram EOF ;
    public final void entryRuleMultiChoiceDiagram() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:145:1: ( ruleMultiChoiceDiagram EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:146:1: ruleMultiChoiceDiagram EOF
            {
             before(grammarAccess.getMultiChoiceDiagramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceDiagram_in_entryRuleMultiChoiceDiagram241);
            ruleMultiChoiceDiagram();

            state._fsp--;

             after(grammarAccess.getMultiChoiceDiagramRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiChoiceDiagram248); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:153:1: ruleMultiChoiceDiagram : ( ( rule__MultiChoiceDiagram__Group__0 ) ) ;
    public final void ruleMultiChoiceDiagram() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:157:2: ( ( ( rule__MultiChoiceDiagram__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:158:1: ( ( rule__MultiChoiceDiagram__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:158:1: ( ( rule__MultiChoiceDiagram__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:159:1: ( rule__MultiChoiceDiagram__Group__0 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:160:1: ( rule__MultiChoiceDiagram__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:160:2: rule__MultiChoiceDiagram__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__0_in_ruleMultiChoiceDiagram274);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:172:1: entryRuleMultiChoiceEmendation : ruleMultiChoiceEmendation EOF ;
    public final void entryRuleMultiChoiceEmendation() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:173:1: ( ruleMultiChoiceEmendation EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:174:1: ruleMultiChoiceEmendation EOF
            {
             before(grammarAccess.getMultiChoiceEmendationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmendation_in_entryRuleMultiChoiceEmendation301);
            ruleMultiChoiceEmendation();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmendationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiChoiceEmendation308); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:181:1: ruleMultiChoiceEmendation : ( ( rule__MultiChoiceEmendation__Group__0 ) ) ;
    public final void ruleMultiChoiceEmendation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:185:2: ( ( ( rule__MultiChoiceEmendation__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:186:1: ( ( rule__MultiChoiceEmendation__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:186:1: ( ( rule__MultiChoiceEmendation__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:187:1: ( rule__MultiChoiceEmendation__Group__0 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:188:1: ( rule__MultiChoiceEmendation__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:188:2: rule__MultiChoiceEmendation__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__0_in_ruleMultiChoiceEmendation334);
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


    // $ANTLR start "entryRuleProgramConfiguration"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:200:1: entryRuleProgramConfiguration : ruleProgramConfiguration EOF ;
    public final void entryRuleProgramConfiguration() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:201:1: ( ruleProgramConfiguration EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:202:1: ruleProgramConfiguration EOF
            {
             before(grammarAccess.getProgramConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgramConfiguration_in_entryRuleProgramConfiguration361);
            ruleProgramConfiguration();

            state._fsp--;

             after(grammarAccess.getProgramConfigurationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgramConfiguration368); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:209:1: ruleProgramConfiguration : ( ( rule__ProgramConfiguration__Group__0 ) ) ;
    public final void ruleProgramConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:213:2: ( ( ( rule__ProgramConfiguration__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:214:1: ( ( rule__ProgramConfiguration__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:214:1: ( ( rule__ProgramConfiguration__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:215:1: ( rule__ProgramConfiguration__Group__0 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:216:1: ( rule__ProgramConfiguration__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:216:2: rule__ProgramConfiguration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProgramConfiguration__Group__0_in_ruleProgramConfiguration394);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:228:1: entryRuleTestConfiguration : ruleTestConfiguration EOF ;
    public final void entryRuleTestConfiguration() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:229:1: ( ruleTestConfiguration EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:230:1: ruleTestConfiguration EOF
            {
             before(grammarAccess.getTestConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestConfiguration_in_entryRuleTestConfiguration421);
            ruleTestConfiguration();

            state._fsp--;

             after(grammarAccess.getTestConfigurationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTestConfiguration428); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:237:1: ruleTestConfiguration : ( ( rule__TestConfiguration__Group__0 ) ) ;
    public final void ruleTestConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:241:2: ( ( ( rule__TestConfiguration__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:242:1: ( ( rule__TestConfiguration__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:242:1: ( ( rule__TestConfiguration__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:243:1: ( rule__TestConfiguration__Group__0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:244:1: ( rule__TestConfiguration__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:244:2: rule__TestConfiguration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__0_in_ruleTestConfiguration454);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:256:1: entryRuleMultiChoiceEmConfig : ruleMultiChoiceEmConfig EOF ;
    public final void entryRuleMultiChoiceEmConfig() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:257:1: ( ruleMultiChoiceEmConfig EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:258:1: ruleMultiChoiceEmConfig EOF
            {
             before(grammarAccess.getMultiChoiceEmConfigRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmConfig_in_entryRuleMultiChoiceEmConfig481);
            ruleMultiChoiceEmConfig();

            state._fsp--;

             after(grammarAccess.getMultiChoiceEmConfigRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMultiChoiceEmConfig488); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:265:1: ruleMultiChoiceEmConfig : ( ( rule__MultiChoiceEmConfig__Group__0 ) ) ;
    public final void ruleMultiChoiceEmConfig() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:269:2: ( ( ( rule__MultiChoiceEmConfig__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:270:1: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:270:1: ( ( rule__MultiChoiceEmConfig__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:271:1: ( rule__MultiChoiceEmConfig__Group__0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:272:1: ( rule__MultiChoiceEmConfig__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:272:2: rule__MultiChoiceEmConfig__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__0_in_ruleMultiChoiceEmConfig514);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:284:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:285:1: ( ruleTest EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:286:1: ruleTest EOF
            {
             before(grammarAccess.getTestRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_entryRuleTest541);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getTestRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTest548); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:293:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
    public final void ruleTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:297:2: ( ( ( rule__Test__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:298:1: ( ( rule__Test__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:298:1: ( ( rule__Test__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:299:1: ( rule__Test__Group__0 )
            {
             before(grammarAccess.getTestAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:300:1: ( rule__Test__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:300:2: rule__Test__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__0_in_ruleTest574);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:312:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:313:1: ( ruleEString EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:314:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString601);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString608); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:321:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:325:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:326:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:326:1: ( ( rule__EString__Alternatives ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:327:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:328:1: ( rule__EString__Alternatives )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:328:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString634);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:340:1: entryRuleEDouble : ruleEDouble EOF ;
    public final void entryRuleEDouble() throws RecognitionException {
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:341:1: ( ruleEDouble EOF )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:342:1: ruleEDouble EOF
            {
             before(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble661);
            ruleEDouble();

            state._fsp--;

             after(grammarAccess.getEDoubleRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble668); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:349:1: ruleEDouble : ( ( rule__EDouble__Group__0 ) ) ;
    public final void ruleEDouble() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:353:2: ( ( ( rule__EDouble__Group__0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:354:1: ( ( rule__EDouble__Group__0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:354:1: ( ( rule__EDouble__Group__0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:355:1: ( rule__EDouble__Group__0 )
            {
             before(grammarAccess.getEDoubleAccess().getGroup()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:356:1: ( rule__EDouble__Group__0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:356:2: rule__EDouble__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__0_in_ruleEDouble694);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:369:1: ruleOrder : ( ( rule__Order__Alternatives ) ) ;
    public final void ruleOrder() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:373:1: ( ( ( rule__Order__Alternatives ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:374:1: ( ( rule__Order__Alternatives ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:374:1: ( ( rule__Order__Alternatives ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:375:1: ( rule__Order__Alternatives )
            {
             before(grammarAccess.getOrderAccess().getAlternatives()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:376:1: ( rule__Order__Alternatives )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:376:2: rule__Order__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Order__Alternatives_in_ruleOrder731);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:388:1: ruleMode : ( ( rule__Mode__Alternatives ) ) ;
    public final void ruleMode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:392:1: ( ( ( rule__Mode__Alternatives ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:393:1: ( ( rule__Mode__Alternatives ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:393:1: ( ( rule__Mode__Alternatives ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:394:1: ( rule__Mode__Alternatives )
            {
             before(grammarAccess.getModeAccess().getAlternatives()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:395:1: ( rule__Mode__Alternatives )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:395:2: rule__Mode__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Mode__Alternatives_in_ruleMode767);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:407:1: ruleNavigation : ( ( rule__Navigation__Alternatives ) ) ;
    public final void ruleNavigation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:411:1: ( ( ( rule__Navigation__Alternatives ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:412:1: ( ( rule__Navigation__Alternatives ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:412:1: ( ( rule__Navigation__Alternatives ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:413:1: ( rule__Navigation__Alternatives )
            {
             before(grammarAccess.getNavigationAccess().getAlternatives()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:414:1: ( rule__Navigation__Alternatives )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:414:2: rule__Navigation__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Navigation__Alternatives_in_ruleNavigation803);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:425:1: rule__MutatorTests__Alternatives : ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) );
    public final void rule__MutatorTests__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:429:1: ( ( ruleAlternativeResponse ) | ( ruleMultiChoiceDiagram ) | ( ruleMultiChoiceEmendation ) )
            int alt1=3;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 26:
                {
                alt1=2;
                }
                break;
            case 27:
                {
                alt1=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:430:1: ( ruleAlternativeResponse )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:430:1: ( ruleAlternativeResponse )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:431:1: ruleAlternativeResponse
                    {
                     before(grammarAccess.getMutatorTestsAccess().getAlternativeResponseParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleAlternativeResponse_in_rule__MutatorTests__Alternatives838);
                    ruleAlternativeResponse();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getAlternativeResponseParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:436:6: ( ruleMultiChoiceDiagram )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:436:6: ( ruleMultiChoiceDiagram )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:437:1: ruleMultiChoiceDiagram
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMultiChoiceDiagramParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceDiagram_in_rule__MutatorTests__Alternatives855);
                    ruleMultiChoiceDiagram();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMultiChoiceDiagramParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:442:6: ( ruleMultiChoiceEmendation )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:442:6: ( ruleMultiChoiceEmendation )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:443:1: ruleMultiChoiceEmendation
                    {
                     before(grammarAccess.getMutatorTestsAccess().getMultiChoiceEmendationParserRuleCall_2()); 
                    pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmendation_in_rule__MutatorTests__Alternatives872);
                    ruleMultiChoiceEmendation();

                    state._fsp--;

                     after(grammarAccess.getMutatorTestsAccess().getMultiChoiceEmendationParserRuleCall_2()); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:453:1: rule__TestConfiguration__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__TestConfiguration__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:457:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:458:1: ( 'yes' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:458:1: ( 'yes' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:459:1: 'yes'
                    {
                     before(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__TestConfiguration__RetryAlternatives_3_0905); 
                     after(grammarAccess.getTestConfigurationAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:466:6: ( 'no' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:466:6: ( 'no' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:467:1: 'no'
                    {
                     before(grammarAccess.getTestConfigurationAccess().getRetryNoKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__TestConfiguration__RetryAlternatives_3_0925); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:479:1: rule__MultiChoiceEmConfig__RetryAlternatives_3_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__RetryAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:483:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:484:1: ( 'yes' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:484:1: ( 'yes' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:485:1: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__MultiChoiceEmConfig__RetryAlternatives_3_0960); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getRetryYesKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:492:6: ( 'no' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:492:6: ( 'no' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:493:1: 'no'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryNoKeyword_3_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__MultiChoiceEmConfig__RetryAlternatives_3_0980); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:505:1: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 : ( ( 'yes' ) | ( 'no' ) );
    public final void rule__MultiChoiceEmConfig__WeightedAlternatives_7_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:509:1: ( ( 'yes' ) | ( 'no' ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:510:1: ( 'yes' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:510:1: ( 'yes' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:511:1: 'yes'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__MultiChoiceEmConfig__WeightedAlternatives_7_01015); 
                     after(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedYesKeyword_7_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:518:6: ( 'no' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:518:6: ( 'no' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:519:1: 'no'
                    {
                     before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedNoKeyword_7_0_1()); 
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__MultiChoiceEmConfig__WeightedAlternatives_7_01035); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:531:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:535:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:536:1: ( RULE_STRING )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:536:1: ( RULE_STRING )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:537:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives1069); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:542:6: ( RULE_ID )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:542:6: ( RULE_ID )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:543:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives1086); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:553:1: rule__EDouble__Alternatives_4_0 : ( ( 'E' ) | ( 'e' ) );
    public final void rule__EDouble__Alternatives_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:557:1: ( ( 'E' ) | ( 'e' ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:558:1: ( 'E' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:558:1: ( 'E' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:559:1: 'E'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__EDouble__Alternatives_4_01119); 
                     after(grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:566:6: ( 'e' )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:566:6: ( 'e' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:567:1: 'e'
                    {
                     before(grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__EDouble__Alternatives_4_01139); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:579:1: rule__Order__Alternatives : ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) );
    public final void rule__Order__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:583:1: ( ( ( 'fixed' ) ) | ( ( 'random' ) ) | ( ( 'options-ascending' ) ) | ( ( 'options-descending' ) ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:584:1: ( ( 'fixed' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:584:1: ( ( 'fixed' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:585:1: ( 'fixed' )
                    {
                     before(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:586:1: ( 'fixed' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:586:3: 'fixed'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__Order__Alternatives1174); 

                    }

                     after(grammarAccess.getOrderAccess().getFixedEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:591:6: ( ( 'random' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:591:6: ( ( 'random' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:592:1: ( 'random' )
                    {
                     before(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:593:1: ( 'random' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:593:3: 'random'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__Order__Alternatives1195); 

                    }

                     after(grammarAccess.getOrderAccess().getRandomEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:598:6: ( ( 'options-ascending' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:598:6: ( ( 'options-ascending' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:599:1: ( 'options-ascending' )
                    {
                     before(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:600:1: ( 'options-ascending' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:600:3: 'options-ascending'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__Order__Alternatives1216); 

                    }

                     after(grammarAccess.getOrderAccess().getAscendingEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:605:6: ( ( 'options-descending' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:605:6: ( ( 'options-descending' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:606:1: ( 'options-descending' )
                    {
                     before(grammarAccess.getOrderAccess().getDescendingEnumLiteralDeclaration_3()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:607:1: ( 'options-descending' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:607:3: 'options-descending'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__Order__Alternatives1237); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:617:1: rule__Mode__Alternatives : ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) );
    public final void rule__Mode__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:621:1: ( ( ( 'radiobutton' ) ) | ( ( 'checkbox' ) ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:622:1: ( ( 'radiobutton' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:622:1: ( ( 'radiobutton' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:623:1: ( 'radiobutton' )
                    {
                     before(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:624:1: ( 'radiobutton' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:624:3: 'radiobutton'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__Mode__Alternatives1273); 

                    }

                     after(grammarAccess.getModeAccess().getRadiobuttonEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:629:6: ( ( 'checkbox' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:629:6: ( ( 'checkbox' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:630:1: ( 'checkbox' )
                    {
                     before(grammarAccess.getModeAccess().getCheckboxEnumLiteralDeclaration_1()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:631:1: ( 'checkbox' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:631:3: 'checkbox'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__Mode__Alternatives1294); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:641:1: rule__Navigation__Alternatives : ( ( ( 'free' ) ) | ( ( 'locked' ) ) );
    public final void rule__Navigation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:645:1: ( ( ( 'free' ) ) | ( ( 'locked' ) ) )
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
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:646:1: ( ( 'free' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:646:1: ( ( 'free' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:647:1: ( 'free' )
                    {
                     before(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:648:1: ( 'free' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:648:3: 'free'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__Navigation__Alternatives1330); 

                    }

                     after(grammarAccess.getNavigationAccess().getFreeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:653:6: ( ( 'locked' ) )
                    {
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:653:6: ( ( 'locked' ) )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:654:1: ( 'locked' )
                    {
                     before(grammarAccess.getNavigationAccess().getLockedEnumLiteralDeclaration_1()); 
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:655:1: ( 'locked' )
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:655:3: 'locked'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__Navigation__Alternatives1351); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:667:1: rule__Program__Group__0 : rule__Program__Group__0__Impl rule__Program__Group__1 ;
    public final void rule__Program__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:671:1: ( rule__Program__Group__0__Impl rule__Program__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:672:2: rule__Program__Group__0__Impl rule__Program__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01384);
            rule__Program__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01387);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:679:1: rule__Program__Group__0__Impl : ( () ) ;
    public final void rule__Program__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:683:1: ( ( () ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:684:1: ( () )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:684:1: ( () )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:685:1: ()
            {
             before(grammarAccess.getProgramAccess().getProgramAction_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:686:1: ()
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:688:1: 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:698:1: rule__Program__Group__1 : rule__Program__Group__1__Impl rule__Program__Group__2 ;
    public final void rule__Program__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:702:1: ( rule__Program__Group__1__Impl rule__Program__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:703:2: rule__Program__Group__1__Impl rule__Program__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11445);
            rule__Program__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__2_in_rule__Program__Group__11448);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:710:1: rule__Program__Group__1__Impl : ( ( rule__Program__ConfigAssignment_1 )? ) ;
    public final void rule__Program__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:714:1: ( ( ( rule__Program__ConfigAssignment_1 )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:715:1: ( ( rule__Program__ConfigAssignment_1 )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:715:1: ( ( rule__Program__ConfigAssignment_1 )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:716:1: ( rule__Program__ConfigAssignment_1 )?
            {
             before(grammarAccess.getProgramAccess().getConfigAssignment_1()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:717:1: ( rule__Program__ConfigAssignment_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==28) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:717:2: rule__Program__ConfigAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Program__ConfigAssignment_1_in_rule__Program__Group__1__Impl1475);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:727:1: rule__Program__Group__2 : rule__Program__Group__2__Impl ;
    public final void rule__Program__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:731:1: ( rule__Program__Group__2__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:732:2: rule__Program__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__Group__2__Impl_in_rule__Program__Group__21506);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:738:1: rule__Program__Group__2__Impl : ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) ) ;
    public final void rule__Program__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:742:1: ( ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:743:1: ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:743:1: ( ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:744:1: ( ( rule__Program__ExercisesAssignment_2 ) ) ( ( rule__Program__ExercisesAssignment_2 )* )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:744:1: ( ( rule__Program__ExercisesAssignment_2 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:745:1: ( rule__Program__ExercisesAssignment_2 )
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:746:1: ( rule__Program__ExercisesAssignment_2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:746:2: rule__Program__ExercisesAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Program__ExercisesAssignment_2_in_rule__Program__Group__2__Impl1535);
            rule__Program__ExercisesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 

            }

            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:749:1: ( ( rule__Program__ExercisesAssignment_2 )* )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:750:1: ( rule__Program__ExercisesAssignment_2 )*
            {
             before(grammarAccess.getProgramAccess().getExercisesAssignment_2()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:751:1: ( rule__Program__ExercisesAssignment_2 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==23||(LA11_0>=26 && LA11_0<=27)) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:751:2: rule__Program__ExercisesAssignment_2
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Program__ExercisesAssignment_2_in_rule__Program__Group__2__Impl1547);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:768:1: rule__AlternativeResponse__Group__0 : rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 ;
    public final void rule__AlternativeResponse__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:772:1: ( rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:773:2: rule__AlternativeResponse__Group__0__Impl rule__AlternativeResponse__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__0__Impl_in_rule__AlternativeResponse__Group__01586);
            rule__AlternativeResponse__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__1_in_rule__AlternativeResponse__Group__01589);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:780:1: rule__AlternativeResponse__Group__0__Impl : ( 'AlternativeResponse' ) ;
    public final void rule__AlternativeResponse__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:784:1: ( ( 'AlternativeResponse' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:785:1: ( 'AlternativeResponse' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:785:1: ( 'AlternativeResponse' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:786:1: 'AlternativeResponse'
            {
             before(grammarAccess.getAlternativeResponseAccess().getAlternativeResponseKeyword_0()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__AlternativeResponse__Group__0__Impl1617); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:799:1: rule__AlternativeResponse__Group__1 : rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 ;
    public final void rule__AlternativeResponse__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:803:1: ( rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:804:2: rule__AlternativeResponse__Group__1__Impl rule__AlternativeResponse__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__1__Impl_in_rule__AlternativeResponse__Group__11648);
            rule__AlternativeResponse__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__2_in_rule__AlternativeResponse__Group__11651);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:811:1: rule__AlternativeResponse__Group__1__Impl : ( ( rule__AlternativeResponse__BlockAssignment_1 )? ) ;
    public final void rule__AlternativeResponse__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:815:1: ( ( ( rule__AlternativeResponse__BlockAssignment_1 )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:816:1: ( ( rule__AlternativeResponse__BlockAssignment_1 )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:816:1: ( ( rule__AlternativeResponse__BlockAssignment_1 )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:817:1: ( rule__AlternativeResponse__BlockAssignment_1 )?
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlockAssignment_1()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:818:1: ( rule__AlternativeResponse__BlockAssignment_1 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:818:2: rule__AlternativeResponse__BlockAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__BlockAssignment_1_in_rule__AlternativeResponse__Group__1__Impl1678);
                    rule__AlternativeResponse__BlockAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getAlternativeResponseAccess().getBlockAssignment_1()); 

            }


            }

        }
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:828:1: rule__AlternativeResponse__Group__2 : rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 ;
    public final void rule__AlternativeResponse__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:832:1: ( rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:833:2: rule__AlternativeResponse__Group__2__Impl rule__AlternativeResponse__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__2__Impl_in_rule__AlternativeResponse__Group__21709);
            rule__AlternativeResponse__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__3_in_rule__AlternativeResponse__Group__21712);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:840:1: rule__AlternativeResponse__Group__2__Impl : ( '{' ) ;
    public final void rule__AlternativeResponse__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:844:1: ( ( '{' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:845:1: ( '{' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:845:1: ( '{' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:846:1: '{'
            {
             before(grammarAccess.getAlternativeResponseAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__AlternativeResponse__Group__2__Impl1740); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:859:1: rule__AlternativeResponse__Group__3 : rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 ;
    public final void rule__AlternativeResponse__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:863:1: ( rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:864:2: rule__AlternativeResponse__Group__3__Impl rule__AlternativeResponse__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__3__Impl_in_rule__AlternativeResponse__Group__31771);
            rule__AlternativeResponse__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__4_in_rule__AlternativeResponse__Group__31774);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:871:1: rule__AlternativeResponse__Group__3__Impl : ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) ;
    public final void rule__AlternativeResponse__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:875:1: ( ( ( rule__AlternativeResponse__ConfigAssignment_3 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:876:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:876:1: ( ( rule__AlternativeResponse__ConfigAssignment_3 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:877:1: ( rule__AlternativeResponse__ConfigAssignment_3 )
            {
             before(grammarAccess.getAlternativeResponseAccess().getConfigAssignment_3()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:878:1: ( rule__AlternativeResponse__ConfigAssignment_3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:878:2: rule__AlternativeResponse__ConfigAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__ConfigAssignment_3_in_rule__AlternativeResponse__Group__3__Impl1801);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:888:1: rule__AlternativeResponse__Group__4 : rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 ;
    public final void rule__AlternativeResponse__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:892:1: ( rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:893:2: rule__AlternativeResponse__Group__4__Impl rule__AlternativeResponse__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__4__Impl_in_rule__AlternativeResponse__Group__41831);
            rule__AlternativeResponse__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__5_in_rule__AlternativeResponse__Group__41834);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:900:1: rule__AlternativeResponse__Group__4__Impl : ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) ;
    public final void rule__AlternativeResponse__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:904:1: ( ( ( rule__AlternativeResponse__TestsAssignment_4 )* ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:905:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:905:1: ( ( rule__AlternativeResponse__TestsAssignment_4 )* )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:906:1: ( rule__AlternativeResponse__TestsAssignment_4 )*
            {
             before(grammarAccess.getAlternativeResponseAccess().getTestsAssignment_4()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:907:1: ( rule__AlternativeResponse__TestsAssignment_4 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==36) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:907:2: rule__AlternativeResponse__TestsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__TestsAssignment_4_in_rule__AlternativeResponse__Group__4__Impl1861);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:917:1: rule__AlternativeResponse__Group__5 : rule__AlternativeResponse__Group__5__Impl ;
    public final void rule__AlternativeResponse__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:921:1: ( rule__AlternativeResponse__Group__5__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:922:2: rule__AlternativeResponse__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__AlternativeResponse__Group__5__Impl_in_rule__AlternativeResponse__Group__51892);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:928:1: rule__AlternativeResponse__Group__5__Impl : ( '}' ) ;
    public final void rule__AlternativeResponse__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:932:1: ( ( '}' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:933:1: ( '}' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:933:1: ( '}' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:934:1: '}'
            {
             before(grammarAccess.getAlternativeResponseAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__AlternativeResponse__Group__5__Impl1920); 
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


    // $ANTLR start "rule__MultiChoiceDiagram__Group__0"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:959:1: rule__MultiChoiceDiagram__Group__0 : rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 ;
    public final void rule__MultiChoiceDiagram__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:963:1: ( rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:964:2: rule__MultiChoiceDiagram__Group__0__Impl rule__MultiChoiceDiagram__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__0__Impl_in_rule__MultiChoiceDiagram__Group__01963);
            rule__MultiChoiceDiagram__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__1_in_rule__MultiChoiceDiagram__Group__01966);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:971:1: rule__MultiChoiceDiagram__Group__0__Impl : ( 'MultiChoiceDiagram' ) ;
    public final void rule__MultiChoiceDiagram__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:975:1: ( ( 'MultiChoiceDiagram' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:976:1: ( 'MultiChoiceDiagram' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:976:1: ( 'MultiChoiceDiagram' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:977:1: 'MultiChoiceDiagram'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getMultiChoiceDiagramKeyword_0()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__MultiChoiceDiagram__Group__0__Impl1994); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:990:1: rule__MultiChoiceDiagram__Group__1 : rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 ;
    public final void rule__MultiChoiceDiagram__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:994:1: ( rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:995:2: rule__MultiChoiceDiagram__Group__1__Impl rule__MultiChoiceDiagram__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__1__Impl_in_rule__MultiChoiceDiagram__Group__12025);
            rule__MultiChoiceDiagram__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__2_in_rule__MultiChoiceDiagram__Group__12028);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1002:1: rule__MultiChoiceDiagram__Group__1__Impl : ( ( rule__MultiChoiceDiagram__BlockAssignment_1 )? ) ;
    public final void rule__MultiChoiceDiagram__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1006:1: ( ( ( rule__MultiChoiceDiagram__BlockAssignment_1 )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1007:1: ( ( rule__MultiChoiceDiagram__BlockAssignment_1 )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1007:1: ( ( rule__MultiChoiceDiagram__BlockAssignment_1 )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1008:1: ( rule__MultiChoiceDiagram__BlockAssignment_1 )?
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlockAssignment_1()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1009:1: ( rule__MultiChoiceDiagram__BlockAssignment_1 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1009:2: rule__MultiChoiceDiagram__BlockAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__BlockAssignment_1_in_rule__MultiChoiceDiagram__Group__1__Impl2055);
                    rule__MultiChoiceDiagram__BlockAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getBlockAssignment_1()); 

            }


            }

        }
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1019:1: rule__MultiChoiceDiagram__Group__2 : rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 ;
    public final void rule__MultiChoiceDiagram__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1023:1: ( rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1024:2: rule__MultiChoiceDiagram__Group__2__Impl rule__MultiChoiceDiagram__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__2__Impl_in_rule__MultiChoiceDiagram__Group__22086);
            rule__MultiChoiceDiagram__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__3_in_rule__MultiChoiceDiagram__Group__22089);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1031:1: rule__MultiChoiceDiagram__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceDiagram__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1035:1: ( ( '{' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1036:1: ( '{' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1036:1: ( '{' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1037:1: '{'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__MultiChoiceDiagram__Group__2__Impl2117); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1050:1: rule__MultiChoiceDiagram__Group__3 : rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 ;
    public final void rule__MultiChoiceDiagram__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1054:1: ( rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1055:2: rule__MultiChoiceDiagram__Group__3__Impl rule__MultiChoiceDiagram__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__3__Impl_in_rule__MultiChoiceDiagram__Group__32148);
            rule__MultiChoiceDiagram__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__4_in_rule__MultiChoiceDiagram__Group__32151);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1062:1: rule__MultiChoiceDiagram__Group__3__Impl : ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceDiagram__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1066:1: ( ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1067:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1067:1: ( ( rule__MultiChoiceDiagram__ConfigAssignment_3 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1068:1: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getConfigAssignment_3()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1069:1: ( rule__MultiChoiceDiagram__ConfigAssignment_3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1069:2: rule__MultiChoiceDiagram__ConfigAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__ConfigAssignment_3_in_rule__MultiChoiceDiagram__Group__3__Impl2178);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1079:1: rule__MultiChoiceDiagram__Group__4 : rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 ;
    public final void rule__MultiChoiceDiagram__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1083:1: ( rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1084:2: rule__MultiChoiceDiagram__Group__4__Impl rule__MultiChoiceDiagram__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__4__Impl_in_rule__MultiChoiceDiagram__Group__42208);
            rule__MultiChoiceDiagram__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__5_in_rule__MultiChoiceDiagram__Group__42211);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1091:1: rule__MultiChoiceDiagram__Group__4__Impl : ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceDiagram__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1095:1: ( ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1096:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1096:1: ( ( rule__MultiChoiceDiagram__TestsAssignment_4 )* )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1097:1: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getTestsAssignment_4()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1098:1: ( rule__MultiChoiceDiagram__TestsAssignment_4 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==36) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1098:2: rule__MultiChoiceDiagram__TestsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__TestsAssignment_4_in_rule__MultiChoiceDiagram__Group__4__Impl2238);
            	    rule__MultiChoiceDiagram__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1108:1: rule__MultiChoiceDiagram__Group__5 : rule__MultiChoiceDiagram__Group__5__Impl ;
    public final void rule__MultiChoiceDiagram__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1112:1: ( rule__MultiChoiceDiagram__Group__5__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1113:2: rule__MultiChoiceDiagram__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceDiagram__Group__5__Impl_in_rule__MultiChoiceDiagram__Group__52269);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1119:1: rule__MultiChoiceDiagram__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceDiagram__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1123:1: ( ( '}' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1124:1: ( '}' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1124:1: ( '}' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1125:1: '}'
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__MultiChoiceDiagram__Group__5__Impl2297); 
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


    // $ANTLR start "rule__MultiChoiceEmendation__Group__0"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1150:1: rule__MultiChoiceEmendation__Group__0 : rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 ;
    public final void rule__MultiChoiceEmendation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1154:1: ( rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1155:2: rule__MultiChoiceEmendation__Group__0__Impl rule__MultiChoiceEmendation__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__0__Impl_in_rule__MultiChoiceEmendation__Group__02340);
            rule__MultiChoiceEmendation__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__1_in_rule__MultiChoiceEmendation__Group__02343);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1162:1: rule__MultiChoiceEmendation__Group__0__Impl : ( 'MultiChoiceEmendation' ) ;
    public final void rule__MultiChoiceEmendation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1166:1: ( ( 'MultiChoiceEmendation' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1167:1: ( 'MultiChoiceEmendation' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1167:1: ( 'MultiChoiceEmendation' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1168:1: 'MultiChoiceEmendation'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getMultiChoiceEmendationKeyword_0()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__MultiChoiceEmendation__Group__0__Impl2371); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1181:1: rule__MultiChoiceEmendation__Group__1 : rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 ;
    public final void rule__MultiChoiceEmendation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1185:1: ( rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1186:2: rule__MultiChoiceEmendation__Group__1__Impl rule__MultiChoiceEmendation__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__1__Impl_in_rule__MultiChoiceEmendation__Group__12402);
            rule__MultiChoiceEmendation__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__2_in_rule__MultiChoiceEmendation__Group__12405);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1193:1: rule__MultiChoiceEmendation__Group__1__Impl : ( ( rule__MultiChoiceEmendation__BlockAssignment_1 )? ) ;
    public final void rule__MultiChoiceEmendation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1197:1: ( ( ( rule__MultiChoiceEmendation__BlockAssignment_1 )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1198:1: ( ( rule__MultiChoiceEmendation__BlockAssignment_1 )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1198:1: ( ( rule__MultiChoiceEmendation__BlockAssignment_1 )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1199:1: ( rule__MultiChoiceEmendation__BlockAssignment_1 )?
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlockAssignment_1()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1200:1: ( rule__MultiChoiceEmendation__BlockAssignment_1 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1200:2: rule__MultiChoiceEmendation__BlockAssignment_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__BlockAssignment_1_in_rule__MultiChoiceEmendation__Group__1__Impl2432);
                    rule__MultiChoiceEmendation__BlockAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getBlockAssignment_1()); 

            }


            }

        }
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1210:1: rule__MultiChoiceEmendation__Group__2 : rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 ;
    public final void rule__MultiChoiceEmendation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1214:1: ( rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1215:2: rule__MultiChoiceEmendation__Group__2__Impl rule__MultiChoiceEmendation__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__2__Impl_in_rule__MultiChoiceEmendation__Group__22463);
            rule__MultiChoiceEmendation__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__3_in_rule__MultiChoiceEmendation__Group__22466);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1222:1: rule__MultiChoiceEmendation__Group__2__Impl : ( '{' ) ;
    public final void rule__MultiChoiceEmendation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1226:1: ( ( '{' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1227:1: ( '{' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1227:1: ( '{' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1228:1: '{'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__MultiChoiceEmendation__Group__2__Impl2494); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1241:1: rule__MultiChoiceEmendation__Group__3 : rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 ;
    public final void rule__MultiChoiceEmendation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1245:1: ( rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1246:2: rule__MultiChoiceEmendation__Group__3__Impl rule__MultiChoiceEmendation__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__3__Impl_in_rule__MultiChoiceEmendation__Group__32525);
            rule__MultiChoiceEmendation__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__4_in_rule__MultiChoiceEmendation__Group__32528);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1253:1: rule__MultiChoiceEmendation__Group__3__Impl : ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmendation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1257:1: ( ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1258:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1258:1: ( ( rule__MultiChoiceEmendation__ConfigAssignment_3 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1259:1: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getConfigAssignment_3()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1260:1: ( rule__MultiChoiceEmendation__ConfigAssignment_3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1260:2: rule__MultiChoiceEmendation__ConfigAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__ConfigAssignment_3_in_rule__MultiChoiceEmendation__Group__3__Impl2555);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1270:1: rule__MultiChoiceEmendation__Group__4 : rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 ;
    public final void rule__MultiChoiceEmendation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1274:1: ( rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1275:2: rule__MultiChoiceEmendation__Group__4__Impl rule__MultiChoiceEmendation__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__4__Impl_in_rule__MultiChoiceEmendation__Group__42585);
            rule__MultiChoiceEmendation__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__5_in_rule__MultiChoiceEmendation__Group__42588);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1282:1: rule__MultiChoiceEmendation__Group__4__Impl : ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) ;
    public final void rule__MultiChoiceEmendation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1286:1: ( ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1287:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1287:1: ( ( rule__MultiChoiceEmendation__TestsAssignment_4 )* )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1288:1: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getTestsAssignment_4()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1289:1: ( rule__MultiChoiceEmendation__TestsAssignment_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==36) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1289:2: rule__MultiChoiceEmendation__TestsAssignment_4
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__TestsAssignment_4_in_rule__MultiChoiceEmendation__Group__4__Impl2615);
            	    rule__MultiChoiceEmendation__TestsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1299:1: rule__MultiChoiceEmendation__Group__5 : rule__MultiChoiceEmendation__Group__5__Impl ;
    public final void rule__MultiChoiceEmendation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1303:1: ( rule__MultiChoiceEmendation__Group__5__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1304:2: rule__MultiChoiceEmendation__Group__5__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmendation__Group__5__Impl_in_rule__MultiChoiceEmendation__Group__52646);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1310:1: rule__MultiChoiceEmendation__Group__5__Impl : ( '}' ) ;
    public final void rule__MultiChoiceEmendation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1314:1: ( ( '}' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1315:1: ( '}' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1315:1: ( '}' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1316:1: '}'
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getRightCurlyBracketKeyword_5()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__MultiChoiceEmendation__Group__5__Impl2674); 
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


    // $ANTLR start "rule__ProgramConfiguration__Group__0"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1341:1: rule__ProgramConfiguration__Group__0 : rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 ;
    public final void rule__ProgramConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1345:1: ( rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1346:2: rule__ProgramConfiguration__Group__0__Impl rule__ProgramConfiguration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProgramConfiguration__Group__0__Impl_in_rule__ProgramConfiguration__Group__02717);
            rule__ProgramConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProgramConfiguration__Group__1_in_rule__ProgramConfiguration__Group__02720);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1353:1: rule__ProgramConfiguration__Group__0__Impl : ( 'navigation' ) ;
    public final void rule__ProgramConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1357:1: ( ( 'navigation' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1358:1: ( 'navigation' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1358:1: ( 'navigation' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1359:1: 'navigation'
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationKeyword_0()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__ProgramConfiguration__Group__0__Impl2748); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1372:1: rule__ProgramConfiguration__Group__1 : rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 ;
    public final void rule__ProgramConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1376:1: ( rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1377:2: rule__ProgramConfiguration__Group__1__Impl rule__ProgramConfiguration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProgramConfiguration__Group__1__Impl_in_rule__ProgramConfiguration__Group__12779);
            rule__ProgramConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__ProgramConfiguration__Group__2_in_rule__ProgramConfiguration__Group__12782);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1384:1: rule__ProgramConfiguration__Group__1__Impl : ( '=' ) ;
    public final void rule__ProgramConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1388:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1389:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1389:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1390:1: '='
            {
             before(grammarAccess.getProgramConfigurationAccess().getEqualsSignKeyword_1()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__ProgramConfiguration__Group__1__Impl2810); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1403:1: rule__ProgramConfiguration__Group__2 : rule__ProgramConfiguration__Group__2__Impl ;
    public final void rule__ProgramConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1407:1: ( rule__ProgramConfiguration__Group__2__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1408:2: rule__ProgramConfiguration__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProgramConfiguration__Group__2__Impl_in_rule__ProgramConfiguration__Group__22841);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1414:1: rule__ProgramConfiguration__Group__2__Impl : ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) ;
    public final void rule__ProgramConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1418:1: ( ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1419:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1419:1: ( ( rule__ProgramConfiguration__NavigationAssignment_2 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1420:1: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationAssignment_2()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1421:1: ( rule__ProgramConfiguration__NavigationAssignment_2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1421:2: rule__ProgramConfiguration__NavigationAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__ProgramConfiguration__NavigationAssignment_2_in_rule__ProgramConfiguration__Group__2__Impl2868);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1437:1: rule__TestConfiguration__Group__0 : rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 ;
    public final void rule__TestConfiguration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1441:1: ( rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1442:2: rule__TestConfiguration__Group__0__Impl rule__TestConfiguration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__0__Impl_in_rule__TestConfiguration__Group__02904);
            rule__TestConfiguration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__1_in_rule__TestConfiguration__Group__02907);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1449:1: rule__TestConfiguration__Group__0__Impl : ( () ) ;
    public final void rule__TestConfiguration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1453:1: ( ( () ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1454:1: ( () )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1454:1: ( () )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1455:1: ()
            {
             before(grammarAccess.getTestConfigurationAccess().getTestConfigurationAction_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1456:1: ()
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1458:1: 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1468:1: rule__TestConfiguration__Group__1 : rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 ;
    public final void rule__TestConfiguration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1472:1: ( rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1473:2: rule__TestConfiguration__Group__1__Impl rule__TestConfiguration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__1__Impl_in_rule__TestConfiguration__Group__12965);
            rule__TestConfiguration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__2_in_rule__TestConfiguration__Group__12968);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1480:1: rule__TestConfiguration__Group__1__Impl : ( 'retry' ) ;
    public final void rule__TestConfiguration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1484:1: ( ( 'retry' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1485:1: ( 'retry' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1485:1: ( 'retry' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1486:1: 'retry'
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryKeyword_1()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__TestConfiguration__Group__1__Impl2996); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1499:1: rule__TestConfiguration__Group__2 : rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 ;
    public final void rule__TestConfiguration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1503:1: ( rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1504:2: rule__TestConfiguration__Group__2__Impl rule__TestConfiguration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__2__Impl_in_rule__TestConfiguration__Group__23027);
            rule__TestConfiguration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__3_in_rule__TestConfiguration__Group__23030);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1511:1: rule__TestConfiguration__Group__2__Impl : ( '=' ) ;
    public final void rule__TestConfiguration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1515:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1516:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1516:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1517:1: '='
            {
             before(grammarAccess.getTestConfigurationAccess().getEqualsSignKeyword_2()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__TestConfiguration__Group__2__Impl3058); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1530:1: rule__TestConfiguration__Group__3 : rule__TestConfiguration__Group__3__Impl ;
    public final void rule__TestConfiguration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1534:1: ( rule__TestConfiguration__Group__3__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1535:2: rule__TestConfiguration__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__Group__3__Impl_in_rule__TestConfiguration__Group__33089);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1541:1: rule__TestConfiguration__Group__3__Impl : ( ( rule__TestConfiguration__RetryAssignment_3 ) ) ;
    public final void rule__TestConfiguration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1545:1: ( ( ( rule__TestConfiguration__RetryAssignment_3 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1546:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1546:1: ( ( rule__TestConfiguration__RetryAssignment_3 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1547:1: ( rule__TestConfiguration__RetryAssignment_3 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAssignment_3()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1548:1: ( rule__TestConfiguration__RetryAssignment_3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1548:2: rule__TestConfiguration__RetryAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__RetryAssignment_3_in_rule__TestConfiguration__Group__3__Impl3116);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1566:1: rule__MultiChoiceEmConfig__Group__0 : rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 ;
    public final void rule__MultiChoiceEmConfig__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1570:1: ( rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1571:2: rule__MultiChoiceEmConfig__Group__0__Impl rule__MultiChoiceEmConfig__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__0__Impl_in_rule__MultiChoiceEmConfig__Group__03154);
            rule__MultiChoiceEmConfig__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__1_in_rule__MultiChoiceEmConfig__Group__03157);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1578:1: rule__MultiChoiceEmConfig__Group__0__Impl : ( () ) ;
    public final void rule__MultiChoiceEmConfig__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1582:1: ( ( () ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1583:1: ( () )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1583:1: ( () )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1584:1: ()
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getMultiChoiceEmConfigAction_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1585:1: ()
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1587:1: 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1597:1: rule__MultiChoiceEmConfig__Group__1 : rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 ;
    public final void rule__MultiChoiceEmConfig__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1601:1: ( rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1602:2: rule__MultiChoiceEmConfig__Group__1__Impl rule__MultiChoiceEmConfig__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__1__Impl_in_rule__MultiChoiceEmConfig__Group__13215);
            rule__MultiChoiceEmConfig__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__2_in_rule__MultiChoiceEmConfig__Group__13218);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1609:1: rule__MultiChoiceEmConfig__Group__1__Impl : ( 'retry' ) ;
    public final void rule__MultiChoiceEmConfig__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1613:1: ( ( 'retry' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1614:1: ( 'retry' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1614:1: ( 'retry' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1615:1: 'retry'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryKeyword_1()); 
            match(input,30,FollowSets000.FOLLOW_30_in_rule__MultiChoiceEmConfig__Group__1__Impl3246); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1628:1: rule__MultiChoiceEmConfig__Group__2 : rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 ;
    public final void rule__MultiChoiceEmConfig__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1632:1: ( rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1633:2: rule__MultiChoiceEmConfig__Group__2__Impl rule__MultiChoiceEmConfig__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__2__Impl_in_rule__MultiChoiceEmConfig__Group__23277);
            rule__MultiChoiceEmConfig__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__3_in_rule__MultiChoiceEmConfig__Group__23280);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1640:1: rule__MultiChoiceEmConfig__Group__2__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1644:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1645:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1645:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1646:1: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_2()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__2__Impl3308); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1659:1: rule__MultiChoiceEmConfig__Group__3 : rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 ;
    public final void rule__MultiChoiceEmConfig__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1663:1: ( rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1664:2: rule__MultiChoiceEmConfig__Group__3__Impl rule__MultiChoiceEmConfig__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__3__Impl_in_rule__MultiChoiceEmConfig__Group__33339);
            rule__MultiChoiceEmConfig__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__4_in_rule__MultiChoiceEmConfig__Group__33342);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1671:1: rule__MultiChoiceEmConfig__Group__3__Impl : ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1675:1: ( ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1676:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1676:1: ( ( rule__MultiChoiceEmConfig__RetryAssignment_3 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1677:1: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAssignment_3()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1678:1: ( rule__MultiChoiceEmConfig__RetryAssignment_3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1678:2: rule__MultiChoiceEmConfig__RetryAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__RetryAssignment_3_in_rule__MultiChoiceEmConfig__Group__3__Impl3369);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1688:1: rule__MultiChoiceEmConfig__Group__4 : rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 ;
    public final void rule__MultiChoiceEmConfig__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1692:1: ( rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1693:2: rule__MultiChoiceEmConfig__Group__4__Impl rule__MultiChoiceEmConfig__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__4__Impl_in_rule__MultiChoiceEmConfig__Group__43399);
            rule__MultiChoiceEmConfig__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__5_in_rule__MultiChoiceEmConfig__Group__43402);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1700:1: rule__MultiChoiceEmConfig__Group__4__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1704:1: ( ( ',' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1705:1: ( ',' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1705:1: ( ',' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1706:1: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_4()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__4__Impl3430); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1719:1: rule__MultiChoiceEmConfig__Group__5 : rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 ;
    public final void rule__MultiChoiceEmConfig__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1723:1: ( rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1724:2: rule__MultiChoiceEmConfig__Group__5__Impl rule__MultiChoiceEmConfig__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__5__Impl_in_rule__MultiChoiceEmConfig__Group__53461);
            rule__MultiChoiceEmConfig__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__6_in_rule__MultiChoiceEmConfig__Group__53464);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1731:1: rule__MultiChoiceEmConfig__Group__5__Impl : ( 'weighted' ) ;
    public final void rule__MultiChoiceEmConfig__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1735:1: ( ( 'weighted' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1736:1: ( 'weighted' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1736:1: ( 'weighted' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1737:1: 'weighted'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedKeyword_5()); 
            match(input,32,FollowSets000.FOLLOW_32_in_rule__MultiChoiceEmConfig__Group__5__Impl3492); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1750:1: rule__MultiChoiceEmConfig__Group__6 : rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 ;
    public final void rule__MultiChoiceEmConfig__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1754:1: ( rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1755:2: rule__MultiChoiceEmConfig__Group__6__Impl rule__MultiChoiceEmConfig__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__6__Impl_in_rule__MultiChoiceEmConfig__Group__63523);
            rule__MultiChoiceEmConfig__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__7_in_rule__MultiChoiceEmConfig__Group__63526);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1762:1: rule__MultiChoiceEmConfig__Group__6__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1766:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1767:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1767:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1768:1: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_6()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__6__Impl3554); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1781:1: rule__MultiChoiceEmConfig__Group__7 : rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 ;
    public final void rule__MultiChoiceEmConfig__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1785:1: ( rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1786:2: rule__MultiChoiceEmConfig__Group__7__Impl rule__MultiChoiceEmConfig__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__7__Impl_in_rule__MultiChoiceEmConfig__Group__73585);
            rule__MultiChoiceEmConfig__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__8_in_rule__MultiChoiceEmConfig__Group__73588);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1793:1: rule__MultiChoiceEmConfig__Group__7__Impl : ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1797:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1798:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1798:1: ( ( rule__MultiChoiceEmConfig__WeightedAssignment_7 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1799:1: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAssignment_7()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1800:1: ( rule__MultiChoiceEmConfig__WeightedAssignment_7 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1800:2: rule__MultiChoiceEmConfig__WeightedAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__WeightedAssignment_7_in_rule__MultiChoiceEmConfig__Group__7__Impl3615);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1810:1: rule__MultiChoiceEmConfig__Group__8 : rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 ;
    public final void rule__MultiChoiceEmConfig__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1814:1: ( rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1815:2: rule__MultiChoiceEmConfig__Group__8__Impl rule__MultiChoiceEmConfig__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__8__Impl_in_rule__MultiChoiceEmConfig__Group__83645);
            rule__MultiChoiceEmConfig__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__9_in_rule__MultiChoiceEmConfig__Group__83648);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1822:1: rule__MultiChoiceEmConfig__Group__8__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1826:1: ( ( ',' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1827:1: ( ',' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1827:1: ( ',' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1828:1: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_8()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__8__Impl3676); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1841:1: rule__MultiChoiceEmConfig__Group__9 : rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 ;
    public final void rule__MultiChoiceEmConfig__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1845:1: ( rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1846:2: rule__MultiChoiceEmConfig__Group__9__Impl rule__MultiChoiceEmConfig__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__9__Impl_in_rule__MultiChoiceEmConfig__Group__93707);
            rule__MultiChoiceEmConfig__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__10_in_rule__MultiChoiceEmConfig__Group__93710);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1853:1: rule__MultiChoiceEmConfig__Group__9__Impl : ( 'penalty' ) ;
    public final void rule__MultiChoiceEmConfig__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1857:1: ( ( 'penalty' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1858:1: ( 'penalty' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1858:1: ( 'penalty' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1859:1: 'penalty'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyKeyword_9()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__MultiChoiceEmConfig__Group__9__Impl3738); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1872:1: rule__MultiChoiceEmConfig__Group__10 : rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 ;
    public final void rule__MultiChoiceEmConfig__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1876:1: ( rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1877:2: rule__MultiChoiceEmConfig__Group__10__Impl rule__MultiChoiceEmConfig__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__10__Impl_in_rule__MultiChoiceEmConfig__Group__103769);
            rule__MultiChoiceEmConfig__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__11_in_rule__MultiChoiceEmConfig__Group__103772);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1884:1: rule__MultiChoiceEmConfig__Group__10__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1888:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1889:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1889:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1890:1: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_10()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__10__Impl3800); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1903:1: rule__MultiChoiceEmConfig__Group__11 : rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 ;
    public final void rule__MultiChoiceEmConfig__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1907:1: ( rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1908:2: rule__MultiChoiceEmConfig__Group__11__Impl rule__MultiChoiceEmConfig__Group__12
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__11__Impl_in_rule__MultiChoiceEmConfig__Group__113831);
            rule__MultiChoiceEmConfig__Group__11__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__12_in_rule__MultiChoiceEmConfig__Group__113834);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1915:1: rule__MultiChoiceEmConfig__Group__11__Impl : ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1919:1: ( ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1920:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1920:1: ( ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1921:1: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyAssignment_11()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1922:1: ( rule__MultiChoiceEmConfig__PenaltyAssignment_11 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1922:2: rule__MultiChoiceEmConfig__PenaltyAssignment_11
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__PenaltyAssignment_11_in_rule__MultiChoiceEmConfig__Group__11__Impl3861);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1932:1: rule__MultiChoiceEmConfig__Group__12 : rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 ;
    public final void rule__MultiChoiceEmConfig__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1936:1: ( rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1937:2: rule__MultiChoiceEmConfig__Group__12__Impl rule__MultiChoiceEmConfig__Group__13
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__12__Impl_in_rule__MultiChoiceEmConfig__Group__123891);
            rule__MultiChoiceEmConfig__Group__12__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__13_in_rule__MultiChoiceEmConfig__Group__123894);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1944:1: rule__MultiChoiceEmConfig__Group__12__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1948:1: ( ( ',' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1949:1: ( ',' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1949:1: ( ',' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1950:1: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_12()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__12__Impl3922); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1963:1: rule__MultiChoiceEmConfig__Group__13 : rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 ;
    public final void rule__MultiChoiceEmConfig__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1967:1: ( rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1968:2: rule__MultiChoiceEmConfig__Group__13__Impl rule__MultiChoiceEmConfig__Group__14
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__13__Impl_in_rule__MultiChoiceEmConfig__Group__133953);
            rule__MultiChoiceEmConfig__Group__13__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__14_in_rule__MultiChoiceEmConfig__Group__133956);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1975:1: rule__MultiChoiceEmConfig__Group__13__Impl : ( 'order' ) ;
    public final void rule__MultiChoiceEmConfig__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1979:1: ( ( 'order' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1980:1: ( 'order' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1980:1: ( 'order' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1981:1: 'order'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderKeyword_13()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__MultiChoiceEmConfig__Group__13__Impl3984); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1994:1: rule__MultiChoiceEmConfig__Group__14 : rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 ;
    public final void rule__MultiChoiceEmConfig__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1998:1: ( rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:1999:2: rule__MultiChoiceEmConfig__Group__14__Impl rule__MultiChoiceEmConfig__Group__15
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__14__Impl_in_rule__MultiChoiceEmConfig__Group__144015);
            rule__MultiChoiceEmConfig__Group__14__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__15_in_rule__MultiChoiceEmConfig__Group__144018);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2006:1: rule__MultiChoiceEmConfig__Group__14__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2010:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2011:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2011:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2012:1: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_14()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__14__Impl4046); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2025:1: rule__MultiChoiceEmConfig__Group__15 : rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 ;
    public final void rule__MultiChoiceEmConfig__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2029:1: ( rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2030:2: rule__MultiChoiceEmConfig__Group__15__Impl rule__MultiChoiceEmConfig__Group__16
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__15__Impl_in_rule__MultiChoiceEmConfig__Group__154077);
            rule__MultiChoiceEmConfig__Group__15__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__16_in_rule__MultiChoiceEmConfig__Group__154080);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2037:1: rule__MultiChoiceEmConfig__Group__15__Impl : ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2041:1: ( ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2042:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2042:1: ( ( rule__MultiChoiceEmConfig__OrderAssignment_15 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2043:1: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderAssignment_15()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2044:1: ( rule__MultiChoiceEmConfig__OrderAssignment_15 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2044:2: rule__MultiChoiceEmConfig__OrderAssignment_15
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__OrderAssignment_15_in_rule__MultiChoiceEmConfig__Group__15__Impl4107);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2054:1: rule__MultiChoiceEmConfig__Group__16 : rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 ;
    public final void rule__MultiChoiceEmConfig__Group__16() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2058:1: ( rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2059:2: rule__MultiChoiceEmConfig__Group__16__Impl rule__MultiChoiceEmConfig__Group__17
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__16__Impl_in_rule__MultiChoiceEmConfig__Group__164137);
            rule__MultiChoiceEmConfig__Group__16__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__17_in_rule__MultiChoiceEmConfig__Group__164140);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2066:1: rule__MultiChoiceEmConfig__Group__16__Impl : ( ',' ) ;
    public final void rule__MultiChoiceEmConfig__Group__16__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2070:1: ( ( ',' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2071:1: ( ',' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2071:1: ( ',' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2072:1: ','
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getCommaKeyword_16()); 
            match(input,31,FollowSets000.FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__16__Impl4168); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2085:1: rule__MultiChoiceEmConfig__Group__17 : rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 ;
    public final void rule__MultiChoiceEmConfig__Group__17() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2089:1: ( rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2090:2: rule__MultiChoiceEmConfig__Group__17__Impl rule__MultiChoiceEmConfig__Group__18
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__17__Impl_in_rule__MultiChoiceEmConfig__Group__174199);
            rule__MultiChoiceEmConfig__Group__17__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__18_in_rule__MultiChoiceEmConfig__Group__174202);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2097:1: rule__MultiChoiceEmConfig__Group__17__Impl : ( 'mode' ) ;
    public final void rule__MultiChoiceEmConfig__Group__17__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2101:1: ( ( 'mode' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2102:1: ( 'mode' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2102:1: ( 'mode' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2103:1: 'mode'
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeKeyword_17()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__MultiChoiceEmConfig__Group__17__Impl4230); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2116:1: rule__MultiChoiceEmConfig__Group__18 : rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 ;
    public final void rule__MultiChoiceEmConfig__Group__18() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2120:1: ( rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2121:2: rule__MultiChoiceEmConfig__Group__18__Impl rule__MultiChoiceEmConfig__Group__19
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__18__Impl_in_rule__MultiChoiceEmConfig__Group__184261);
            rule__MultiChoiceEmConfig__Group__18__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__19_in_rule__MultiChoiceEmConfig__Group__184264);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2128:1: rule__MultiChoiceEmConfig__Group__18__Impl : ( '=' ) ;
    public final void rule__MultiChoiceEmConfig__Group__18__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2132:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2133:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2133:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2134:1: '='
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getEqualsSignKeyword_18()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__18__Impl4292); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2147:1: rule__MultiChoiceEmConfig__Group__19 : rule__MultiChoiceEmConfig__Group__19__Impl ;
    public final void rule__MultiChoiceEmConfig__Group__19() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2151:1: ( rule__MultiChoiceEmConfig__Group__19__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2152:2: rule__MultiChoiceEmConfig__Group__19__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__Group__19__Impl_in_rule__MultiChoiceEmConfig__Group__194323);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2158:1: rule__MultiChoiceEmConfig__Group__19__Impl : ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) ;
    public final void rule__MultiChoiceEmConfig__Group__19__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2162:1: ( ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2163:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2163:1: ( ( rule__MultiChoiceEmConfig__ModeAssignment_19 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2164:1: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeAssignment_19()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2165:1: ( rule__MultiChoiceEmConfig__ModeAssignment_19 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2165:2: rule__MultiChoiceEmConfig__ModeAssignment_19
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__ModeAssignment_19_in_rule__MultiChoiceEmConfig__Group__19__Impl4350);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2215:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2219:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2220:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04420);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04423);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2227:1: rule__Test__Group__0__Impl : ( 'description' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2231:1: ( ( 'description' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2232:1: ( 'description' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2232:1: ( 'description' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2233:1: 'description'
            {
             before(grammarAccess.getTestAccess().getDescriptionKeyword_0()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__Test__Group__0__Impl4451); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2246:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2250:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2251:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14482);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14485);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2258:1: rule__Test__Group__1__Impl : ( 'for' ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2262:1: ( ( 'for' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2263:1: ( 'for' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2263:1: ( 'for' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2264:1: 'for'
            {
             before(grammarAccess.getTestAccess().getForKeyword_1()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__Test__Group__1__Impl4513); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2277:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2281:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2282:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24544);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24547);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2289:1: rule__Test__Group__2__Impl : ( ( rule__Test__SourceAssignment_2 ) ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2293:1: ( ( ( rule__Test__SourceAssignment_2 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2294:1: ( ( rule__Test__SourceAssignment_2 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2294:1: ( ( rule__Test__SourceAssignment_2 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2295:1: ( rule__Test__SourceAssignment_2 )
            {
             before(grammarAccess.getTestAccess().getSourceAssignment_2()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2296:1: ( rule__Test__SourceAssignment_2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2296:2: rule__Test__SourceAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__SourceAssignment_2_in_rule__Test__Group__2__Impl4574);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2306:1: rule__Test__Group__3 : rule__Test__Group__3__Impl rule__Test__Group__4 ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2310:1: ( rule__Test__Group__3__Impl rule__Test__Group__4 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2311:2: rule__Test__Group__3__Impl rule__Test__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__34604);
            rule__Test__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__4_in_rule__Test__Group__34607);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2318:1: rule__Test__Group__3__Impl : ( '=' ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2322:1: ( ( '=' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2323:1: ( '=' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2323:1: ( '=' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2324:1: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_3()); 
            match(input,29,FollowSets000.FOLLOW_29_in_rule__Test__Group__3__Impl4635); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2337:1: rule__Test__Group__4 : rule__Test__Group__4__Impl ;
    public final void rule__Test__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2341:1: ( rule__Test__Group__4__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2342:2: rule__Test__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__44666);
            rule__Test__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2348:1: rule__Test__Group__4__Impl : ( ( rule__Test__QuestionAssignment_4 ) ) ;
    public final void rule__Test__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2352:1: ( ( ( rule__Test__QuestionAssignment_4 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2353:1: ( ( rule__Test__QuestionAssignment_4 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2353:1: ( ( rule__Test__QuestionAssignment_4 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2354:1: ( rule__Test__QuestionAssignment_4 )
            {
             before(grammarAccess.getTestAccess().getQuestionAssignment_4()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2355:1: ( rule__Test__QuestionAssignment_4 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2355:2: rule__Test__QuestionAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Test__QuestionAssignment_4_in_rule__Test__Group__4__Impl4693);
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


    // $ANTLR start "rule__EDouble__Group__0"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2375:1: rule__EDouble__Group__0 : rule__EDouble__Group__0__Impl rule__EDouble__Group__1 ;
    public final void rule__EDouble__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2379:1: ( rule__EDouble__Group__0__Impl rule__EDouble__Group__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2380:2: rule__EDouble__Group__0__Impl rule__EDouble__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__0__Impl_in_rule__EDouble__Group__04733);
            rule__EDouble__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__1_in_rule__EDouble__Group__04736);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2387:1: rule__EDouble__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2391:1: ( ( ( '-' )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2392:1: ( ( '-' )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2392:1: ( ( '-' )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2393:1: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2394:1: ( '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2395:2: '-'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__EDouble__Group__0__Impl4765); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2406:1: rule__EDouble__Group__1 : rule__EDouble__Group__1__Impl rule__EDouble__Group__2 ;
    public final void rule__EDouble__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2410:1: ( rule__EDouble__Group__1__Impl rule__EDouble__Group__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2411:2: rule__EDouble__Group__1__Impl rule__EDouble__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__1__Impl_in_rule__EDouble__Group__14798);
            rule__EDouble__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__2_in_rule__EDouble__Group__14801);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2418:1: rule__EDouble__Group__1__Impl : ( ( RULE_INT )? ) ;
    public final void rule__EDouble__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2422:1: ( ( ( RULE_INT )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2423:1: ( ( RULE_INT )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2423:1: ( ( RULE_INT )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2424:1: ( RULE_INT )?
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2425:1: ( RULE_INT )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2425:3: RULE_INT
                    {
                    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EDouble__Group__1__Impl4829); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2435:1: rule__EDouble__Group__2 : rule__EDouble__Group__2__Impl rule__EDouble__Group__3 ;
    public final void rule__EDouble__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2439:1: ( rule__EDouble__Group__2__Impl rule__EDouble__Group__3 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2440:2: rule__EDouble__Group__2__Impl rule__EDouble__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__2__Impl_in_rule__EDouble__Group__24860);
            rule__EDouble__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__3_in_rule__EDouble__Group__24863);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2447:1: rule__EDouble__Group__2__Impl : ( '.' ) ;
    public final void rule__EDouble__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2451:1: ( ( '.' ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2452:1: ( '.' )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2452:1: ( '.' )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2453:1: '.'
            {
             before(grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
            match(input,39,FollowSets000.FOLLOW_39_in_rule__EDouble__Group__2__Impl4891); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2466:1: rule__EDouble__Group__3 : rule__EDouble__Group__3__Impl rule__EDouble__Group__4 ;
    public final void rule__EDouble__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2470:1: ( rule__EDouble__Group__3__Impl rule__EDouble__Group__4 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2471:2: rule__EDouble__Group__3__Impl rule__EDouble__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__3__Impl_in_rule__EDouble__Group__34922);
            rule__EDouble__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__4_in_rule__EDouble__Group__34925);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2478:1: rule__EDouble__Group__3__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2482:1: ( ( RULE_INT ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2483:1: ( RULE_INT )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2483:1: ( RULE_INT )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2484:1: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EDouble__Group__3__Impl4952); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2495:1: rule__EDouble__Group__4 : rule__EDouble__Group__4__Impl ;
    public final void rule__EDouble__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2499:1: ( rule__EDouble__Group__4__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2500:2: rule__EDouble__Group__4__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group__4__Impl_in_rule__EDouble__Group__44981);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2506:1: rule__EDouble__Group__4__Impl : ( ( rule__EDouble__Group_4__0 )? ) ;
    public final void rule__EDouble__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2510:1: ( ( ( rule__EDouble__Group_4__0 )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2511:1: ( ( rule__EDouble__Group_4__0 )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2511:1: ( ( rule__EDouble__Group_4__0 )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2512:1: ( rule__EDouble__Group_4__0 )?
            {
             before(grammarAccess.getEDoubleAccess().getGroup_4()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2513:1: ( rule__EDouble__Group_4__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=13 && LA20_0<=14)) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2513:2: rule__EDouble__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_4__0_in_rule__EDouble__Group__4__Impl5008);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2533:1: rule__EDouble__Group_4__0 : rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 ;
    public final void rule__EDouble__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2537:1: ( rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2538:2: rule__EDouble__Group_4__0__Impl rule__EDouble__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_4__0__Impl_in_rule__EDouble__Group_4__05049);
            rule__EDouble__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_4__1_in_rule__EDouble__Group_4__05052);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2545:1: rule__EDouble__Group_4__0__Impl : ( ( rule__EDouble__Alternatives_4_0 ) ) ;
    public final void rule__EDouble__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2549:1: ( ( ( rule__EDouble__Alternatives_4_0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2550:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2550:1: ( ( rule__EDouble__Alternatives_4_0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2551:1: ( rule__EDouble__Alternatives_4_0 )
            {
             before(grammarAccess.getEDoubleAccess().getAlternatives_4_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2552:1: ( rule__EDouble__Alternatives_4_0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2552:2: rule__EDouble__Alternatives_4_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Alternatives_4_0_in_rule__EDouble__Group_4__0__Impl5079);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2562:1: rule__EDouble__Group_4__1 : rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 ;
    public final void rule__EDouble__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2566:1: ( rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2567:2: rule__EDouble__Group_4__1__Impl rule__EDouble__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_4__1__Impl_in_rule__EDouble__Group_4__15109);
            rule__EDouble__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_4__2_in_rule__EDouble__Group_4__15112);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2574:1: rule__EDouble__Group_4__1__Impl : ( ( '-' )? ) ;
    public final void rule__EDouble__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2578:1: ( ( ( '-' )? ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2579:1: ( ( '-' )? )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2579:1: ( ( '-' )? )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2580:1: ( '-' )?
            {
             before(grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2581:1: ( '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==38) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2582:2: '-'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_rule__EDouble__Group_4__1__Impl5141); 

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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2593:1: rule__EDouble__Group_4__2 : rule__EDouble__Group_4__2__Impl ;
    public final void rule__EDouble__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2597:1: ( rule__EDouble__Group_4__2__Impl )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2598:2: rule__EDouble__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__EDouble__Group_4__2__Impl_in_rule__EDouble__Group_4__25174);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2604:1: rule__EDouble__Group_4__2__Impl : ( RULE_INT ) ;
    public final void rule__EDouble__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2608:1: ( ( RULE_INT ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2609:1: ( RULE_INT )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2609:1: ( RULE_INT )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2610:1: RULE_INT
            {
             before(grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_rule__EDouble__Group_4__2__Impl5201); 
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2628:1: rule__Program__ConfigAssignment_1 : ( ruleProgramConfiguration ) ;
    public final void rule__Program__ConfigAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2632:1: ( ( ruleProgramConfiguration ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2633:1: ( ruleProgramConfiguration )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2633:1: ( ruleProgramConfiguration )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2634:1: ruleProgramConfiguration
            {
             before(grammarAccess.getProgramAccess().getConfigProgramConfigurationParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgramConfiguration_in_rule__Program__ConfigAssignment_15241);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2643:1: rule__Program__ExercisesAssignment_2 : ( ruleMutatorTests ) ;
    public final void rule__Program__ExercisesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2647:1: ( ( ruleMutatorTests ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2648:1: ( ruleMutatorTests )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2648:1: ( ruleMutatorTests )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2649:1: ruleMutatorTests
            {
             before(grammarAccess.getProgramAccess().getExercisesMutatorTestsParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorTests_in_rule__Program__ExercisesAssignment_25272);
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


    // $ANTLR start "rule__AlternativeResponse__BlockAssignment_1"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2658:1: rule__AlternativeResponse__BlockAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__AlternativeResponse__BlockAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2662:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2663:1: ( ( RULE_ID ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2663:1: ( ( RULE_ID ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2664:1: ( RULE_ID )
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlockEObjectCrossReference_1_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2665:1: ( RULE_ID )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2666:1: RULE_ID
            {
             before(grammarAccess.getAlternativeResponseAccess().getBlockEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__AlternativeResponse__BlockAssignment_15307); 
             after(grammarAccess.getAlternativeResponseAccess().getBlockEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getAlternativeResponseAccess().getBlockEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AlternativeResponse__BlockAssignment_1"


    // $ANTLR start "rule__AlternativeResponse__ConfigAssignment_3"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2677:1: rule__AlternativeResponse__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__AlternativeResponse__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2681:1: ( ( ruleTestConfiguration ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2682:1: ( ruleTestConfiguration )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2682:1: ( ruleTestConfiguration )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2683:1: ruleTestConfiguration
            {
             before(grammarAccess.getAlternativeResponseAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestConfiguration_in_rule__AlternativeResponse__ConfigAssignment_35342);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2692:1: rule__AlternativeResponse__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__AlternativeResponse__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2696:1: ( ( ruleTest ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2697:1: ( ruleTest )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2697:1: ( ruleTest )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2698:1: ruleTest
            {
             before(grammarAccess.getAlternativeResponseAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_rule__AlternativeResponse__TestsAssignment_45373);
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


    // $ANTLR start "rule__MultiChoiceDiagram__BlockAssignment_1"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2707:1: rule__MultiChoiceDiagram__BlockAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceDiagram__BlockAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2711:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2712:1: ( ( RULE_ID ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2712:1: ( ( RULE_ID ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2713:1: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlockEObjectCrossReference_1_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2714:1: ( RULE_ID )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2715:1: RULE_ID
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getBlockEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MultiChoiceDiagram__BlockAssignment_15408); 
             after(grammarAccess.getMultiChoiceDiagramAccess().getBlockEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMultiChoiceDiagramAccess().getBlockEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceDiagram__BlockAssignment_1"


    // $ANTLR start "rule__MultiChoiceDiagram__ConfigAssignment_3"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2726:1: rule__MultiChoiceDiagram__ConfigAssignment_3 : ( ruleTestConfiguration ) ;
    public final void rule__MultiChoiceDiagram__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2730:1: ( ( ruleTestConfiguration ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2731:1: ( ruleTestConfiguration )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2731:1: ( ruleTestConfiguration )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2732:1: ruleTestConfiguration
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getConfigTestConfigurationParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTestConfiguration_in_rule__MultiChoiceDiagram__ConfigAssignment_35443);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2741:1: rule__MultiChoiceDiagram__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceDiagram__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2745:1: ( ( ruleTest ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2746:1: ( ruleTest )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2746:1: ( ruleTest )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2747:1: ruleTest
            {
             before(grammarAccess.getMultiChoiceDiagramAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_rule__MultiChoiceDiagram__TestsAssignment_45474);
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


    // $ANTLR start "rule__MultiChoiceEmendation__BlockAssignment_1"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2756:1: rule__MultiChoiceEmendation__BlockAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MultiChoiceEmendation__BlockAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2760:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2761:1: ( ( RULE_ID ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2761:1: ( ( RULE_ID ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2762:1: ( RULE_ID )
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlockEObjectCrossReference_1_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2763:1: ( RULE_ID )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2764:1: RULE_ID
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getBlockEObjectIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MultiChoiceEmendation__BlockAssignment_15509); 
             after(grammarAccess.getMultiChoiceEmendationAccess().getBlockEObjectIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMultiChoiceEmendationAccess().getBlockEObjectCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MultiChoiceEmendation__BlockAssignment_1"


    // $ANTLR start "rule__MultiChoiceEmendation__ConfigAssignment_3"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2775:1: rule__MultiChoiceEmendation__ConfigAssignment_3 : ( ruleMultiChoiceEmConfig ) ;
    public final void rule__MultiChoiceEmendation__ConfigAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2779:1: ( ( ruleMultiChoiceEmConfig ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2780:1: ( ruleMultiChoiceEmConfig )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2780:1: ( ruleMultiChoiceEmConfig )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2781:1: ruleMultiChoiceEmConfig
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getConfigMultiChoiceEmConfigParserRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMultiChoiceEmConfig_in_rule__MultiChoiceEmendation__ConfigAssignment_35544);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2790:1: rule__MultiChoiceEmendation__TestsAssignment_4 : ( ruleTest ) ;
    public final void rule__MultiChoiceEmendation__TestsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2794:1: ( ( ruleTest ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2795:1: ( ruleTest )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2795:1: ( ruleTest )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2796:1: ruleTest
            {
             before(grammarAccess.getMultiChoiceEmendationAccess().getTestsTestParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleTest_in_rule__MultiChoiceEmendation__TestsAssignment_45575);
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


    // $ANTLR start "rule__ProgramConfiguration__NavigationAssignment_2"
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2805:1: rule__ProgramConfiguration__NavigationAssignment_2 : ( ruleNavigation ) ;
    public final void rule__ProgramConfiguration__NavigationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2809:1: ( ( ruleNavigation ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2810:1: ( ruleNavigation )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2810:1: ( ruleNavigation )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2811:1: ruleNavigation
            {
             before(grammarAccess.getProgramConfigurationAccess().getNavigationNavigationEnumRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNavigation_in_rule__ProgramConfiguration__NavigationAssignment_25606);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2820:1: rule__TestConfiguration__RetryAssignment_3 : ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) ;
    public final void rule__TestConfiguration__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2824:1: ( ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2825:1: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2825:1: ( ( rule__TestConfiguration__RetryAlternatives_3_0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2826:1: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getTestConfigurationAccess().getRetryAlternatives_3_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2827:1: ( rule__TestConfiguration__RetryAlternatives_3_0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2827:2: rule__TestConfiguration__RetryAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__TestConfiguration__RetryAlternatives_3_0_in_rule__TestConfiguration__RetryAssignment_35637);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2836:1: rule__MultiChoiceEmConfig__RetryAssignment_3 : ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__RetryAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2840:1: ( ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2841:1: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2841:1: ( ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2842:1: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getRetryAlternatives_3_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2843:1: ( rule__MultiChoiceEmConfig__RetryAlternatives_3_0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2843:2: rule__MultiChoiceEmConfig__RetryAlternatives_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__RetryAlternatives_3_0_in_rule__MultiChoiceEmConfig__RetryAssignment_35670);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2852:1: rule__MultiChoiceEmConfig__WeightedAssignment_7 : ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) ;
    public final void rule__MultiChoiceEmConfig__WeightedAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2856:1: ( ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2857:1: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2857:1: ( ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2858:1: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getWeightedAlternatives_7_0()); 
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2859:1: ( rule__MultiChoiceEmConfig__WeightedAlternatives_7_0 )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2859:2: rule__MultiChoiceEmConfig__WeightedAlternatives_7_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MultiChoiceEmConfig__WeightedAlternatives_7_0_in_rule__MultiChoiceEmConfig__WeightedAssignment_75703);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2868:1: rule__MultiChoiceEmConfig__PenaltyAssignment_11 : ( ruleEDouble ) ;
    public final void rule__MultiChoiceEmConfig__PenaltyAssignment_11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2872:1: ( ( ruleEDouble ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2873:1: ( ruleEDouble )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2873:1: ( ruleEDouble )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2874:1: ruleEDouble
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getPenaltyEDoubleParserRuleCall_11_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_rule__MultiChoiceEmConfig__PenaltyAssignment_115736);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2883:1: rule__MultiChoiceEmConfig__OrderAssignment_15 : ( ruleOrder ) ;
    public final void rule__MultiChoiceEmConfig__OrderAssignment_15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2887:1: ( ( ruleOrder ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2888:1: ( ruleOrder )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2888:1: ( ruleOrder )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2889:1: ruleOrder
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getOrderOrderEnumRuleCall_15_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOrder_in_rule__MultiChoiceEmConfig__OrderAssignment_155767);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2898:1: rule__MultiChoiceEmConfig__ModeAssignment_19 : ( ruleMode ) ;
    public final void rule__MultiChoiceEmConfig__ModeAssignment_19() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2902:1: ( ( ruleMode ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2903:1: ( ruleMode )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2903:1: ( ruleMode )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2904:1: ruleMode
            {
             before(grammarAccess.getMultiChoiceEmConfigAccess().getModeModeEnumRuleCall_19_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleMode_in_rule__MultiChoiceEmConfig__ModeAssignment_195798);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2913:1: rule__Test__SourceAssignment_2 : ( ruleEString ) ;
    public final void rule__Test__SourceAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2917:1: ( ( ruleEString ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2918:1: ( ruleEString )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2918:1: ( ruleEString )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2919:1: ruleEString
            {
             before(grammarAccess.getTestAccess().getSourceEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Test__SourceAssignment_25829);
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
    // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2928:1: rule__Test__QuestionAssignment_4 : ( ruleEString ) ;
    public final void rule__Test__QuestionAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2932:1: ( ( ruleEString ) )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2933:1: ( ruleEString )
            {
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2933:1: ( ruleEString )
            // ../org.mutatortests.ui/src-gen/org/mutatortests/ui/contentassist/antlr/internal/InternalTests.g:2934:1: ruleEString
            {
             before(grammarAccess.getTestAccess().getQuestionEStringParserRuleCall_4_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Test__QuestionAssignment_45860);
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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group__0_in_ruleProgram94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMutatorTests_in_entryRuleMutatorTests121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorTests128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorTests__Alternatives_in_ruleMutatorTests154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeResponse_in_entryRuleAlternativeResponse181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAlternativeResponse188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__0_in_ruleAlternativeResponse214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceDiagram_in_entryRuleMultiChoiceDiagram241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiChoiceDiagram248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__0_in_ruleMultiChoiceDiagram274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmendation_in_entryRuleMultiChoiceEmendation301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiChoiceEmendation308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__0_in_ruleMultiChoiceEmendation334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgramConfiguration_in_entryRuleProgramConfiguration361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgramConfiguration368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProgramConfiguration__Group__0_in_ruleProgramConfiguration394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestConfiguration_in_entryRuleTestConfiguration421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTestConfiguration428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__0_in_ruleTestConfiguration454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmConfig_in_entryRuleMultiChoiceEmConfig481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMultiChoiceEmConfig488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__0_in_ruleMultiChoiceEmConfig514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_entryRuleTest541 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTest548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__Group__0_in_ruleTest574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString601 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString634 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__0_in_ruleEDouble694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Order__Alternatives_in_ruleOrder731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Mode__Alternatives_in_ruleMode767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Navigation__Alternatives_in_ruleNavigation803 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAlternativeResponse_in_rule__MutatorTests__Alternatives838 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceDiagram_in_rule__MutatorTests__Alternatives855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmendation_in_rule__MutatorTests__Alternatives872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__TestConfiguration__RetryAlternatives_3_0905 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__TestConfiguration__RetryAlternatives_3_0925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__MultiChoiceEmConfig__RetryAlternatives_3_0960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__MultiChoiceEmConfig__RetryAlternatives_3_0980 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__MultiChoiceEmConfig__WeightedAlternatives_7_01015 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__MultiChoiceEmConfig__WeightedAlternatives_7_01035 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives1069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives1086 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__EDouble__Alternatives_4_01119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__EDouble__Alternatives_4_01139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Order__Alternatives1174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Order__Alternatives1195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Order__Alternatives1216 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Order__Alternatives1237 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Mode__Alternatives1273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__Mode__Alternatives1294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__Navigation__Alternatives1330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Navigation__Alternatives1351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group__0__Impl_in_rule__Program__Group__01384 = new BitSet(new long[]{0x000000001C800000L});
        public static final BitSet FOLLOW_rule__Program__Group__1_in_rule__Program__Group__01387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group__1__Impl_in_rule__Program__Group__11445 = new BitSet(new long[]{0x000000001C800000L});
        public static final BitSet FOLLOW_rule__Program__Group__2_in_rule__Program__Group__11448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__ConfigAssignment_1_in_rule__Program__Group__1__Impl1475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__Group__2__Impl_in_rule__Program__Group__21506 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Program__ExercisesAssignment_2_in_rule__Program__Group__2__Impl1535 = new BitSet(new long[]{0x000000001C800002L});
        public static final BitSet FOLLOW_rule__Program__ExercisesAssignment_2_in_rule__Program__Group__2__Impl1547 = new BitSet(new long[]{0x000000001C800002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__0__Impl_in_rule__AlternativeResponse__Group__01586 = new BitSet(new long[]{0x0000000001000020L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__1_in_rule__AlternativeResponse__Group__01589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__AlternativeResponse__Group__0__Impl1617 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__1__Impl_in_rule__AlternativeResponse__Group__11648 = new BitSet(new long[]{0x0000000001000020L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__2_in_rule__AlternativeResponse__Group__11651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__BlockAssignment_1_in_rule__AlternativeResponse__Group__1__Impl1678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__2__Impl_in_rule__AlternativeResponse__Group__21709 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__3_in_rule__AlternativeResponse__Group__21712 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__AlternativeResponse__Group__2__Impl1740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__3__Impl_in_rule__AlternativeResponse__Group__31771 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__4_in_rule__AlternativeResponse__Group__31774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__ConfigAssignment_3_in_rule__AlternativeResponse__Group__3__Impl1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__4__Impl_in_rule__AlternativeResponse__Group__41831 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__5_in_rule__AlternativeResponse__Group__41834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__TestsAssignment_4_in_rule__AlternativeResponse__Group__4__Impl1861 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__AlternativeResponse__Group__5__Impl_in_rule__AlternativeResponse__Group__51892 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__AlternativeResponse__Group__5__Impl1920 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__0__Impl_in_rule__MultiChoiceDiagram__Group__01963 = new BitSet(new long[]{0x0000000001000020L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__1_in_rule__MultiChoiceDiagram__Group__01966 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__MultiChoiceDiagram__Group__0__Impl1994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__1__Impl_in_rule__MultiChoiceDiagram__Group__12025 = new BitSet(new long[]{0x0000000001000020L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__2_in_rule__MultiChoiceDiagram__Group__12028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__BlockAssignment_1_in_rule__MultiChoiceDiagram__Group__1__Impl2055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__2__Impl_in_rule__MultiChoiceDiagram__Group__22086 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__3_in_rule__MultiChoiceDiagram__Group__22089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__MultiChoiceDiagram__Group__2__Impl2117 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__3__Impl_in_rule__MultiChoiceDiagram__Group__32148 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__4_in_rule__MultiChoiceDiagram__Group__32151 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__ConfigAssignment_3_in_rule__MultiChoiceDiagram__Group__3__Impl2178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__4__Impl_in_rule__MultiChoiceDiagram__Group__42208 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__5_in_rule__MultiChoiceDiagram__Group__42211 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__TestsAssignment_4_in_rule__MultiChoiceDiagram__Group__4__Impl2238 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceDiagram__Group__5__Impl_in_rule__MultiChoiceDiagram__Group__52269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__MultiChoiceDiagram__Group__5__Impl2297 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__0__Impl_in_rule__MultiChoiceEmendation__Group__02340 = new BitSet(new long[]{0x0000000001000020L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__1_in_rule__MultiChoiceEmendation__Group__02343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__MultiChoiceEmendation__Group__0__Impl2371 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__1__Impl_in_rule__MultiChoiceEmendation__Group__12402 = new BitSet(new long[]{0x0000000001000020L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__2_in_rule__MultiChoiceEmendation__Group__12405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__BlockAssignment_1_in_rule__MultiChoiceEmendation__Group__1__Impl2432 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__2__Impl_in_rule__MultiChoiceEmendation__Group__22463 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__3_in_rule__MultiChoiceEmendation__Group__22466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__MultiChoiceEmendation__Group__2__Impl2494 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__3__Impl_in_rule__MultiChoiceEmendation__Group__32525 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__4_in_rule__MultiChoiceEmendation__Group__32528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__ConfigAssignment_3_in_rule__MultiChoiceEmendation__Group__3__Impl2555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__4__Impl_in_rule__MultiChoiceEmendation__Group__42585 = new BitSet(new long[]{0x0000001002000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__5_in_rule__MultiChoiceEmendation__Group__42588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__TestsAssignment_4_in_rule__MultiChoiceEmendation__Group__4__Impl2615 = new BitSet(new long[]{0x0000001000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmendation__Group__5__Impl_in_rule__MultiChoiceEmendation__Group__52646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__MultiChoiceEmendation__Group__5__Impl2674 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProgramConfiguration__Group__0__Impl_in_rule__ProgramConfiguration__Group__02717 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__ProgramConfiguration__Group__1_in_rule__ProgramConfiguration__Group__02720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__ProgramConfiguration__Group__0__Impl2748 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProgramConfiguration__Group__1__Impl_in_rule__ProgramConfiguration__Group__12779 = new BitSet(new long[]{0x0000000000600000L});
        public static final BitSet FOLLOW_rule__ProgramConfiguration__Group__2_in_rule__ProgramConfiguration__Group__12782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__ProgramConfiguration__Group__1__Impl2810 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProgramConfiguration__Group__2__Impl_in_rule__ProgramConfiguration__Group__22841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__ProgramConfiguration__NavigationAssignment_2_in_rule__ProgramConfiguration__Group__2__Impl2868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__0__Impl_in_rule__TestConfiguration__Group__02904 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__1_in_rule__TestConfiguration__Group__02907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__1__Impl_in_rule__TestConfiguration__Group__12965 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__2_in_rule__TestConfiguration__Group__12968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__TestConfiguration__Group__1__Impl2996 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__2__Impl_in_rule__TestConfiguration__Group__23027 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__3_in_rule__TestConfiguration__Group__23030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__TestConfiguration__Group__2__Impl3058 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TestConfiguration__Group__3__Impl_in_rule__TestConfiguration__Group__33089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TestConfiguration__RetryAssignment_3_in_rule__TestConfiguration__Group__3__Impl3116 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__0__Impl_in_rule__MultiChoiceEmConfig__Group__03154 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__1_in_rule__MultiChoiceEmConfig__Group__03157 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__1__Impl_in_rule__MultiChoiceEmConfig__Group__13215 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__2_in_rule__MultiChoiceEmConfig__Group__13218 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__MultiChoiceEmConfig__Group__1__Impl3246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__2__Impl_in_rule__MultiChoiceEmConfig__Group__23277 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__3_in_rule__MultiChoiceEmConfig__Group__23280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__2__Impl3308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__3__Impl_in_rule__MultiChoiceEmConfig__Group__33339 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__4_in_rule__MultiChoiceEmConfig__Group__33342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__RetryAssignment_3_in_rule__MultiChoiceEmConfig__Group__3__Impl3369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__4__Impl_in_rule__MultiChoiceEmConfig__Group__43399 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__5_in_rule__MultiChoiceEmConfig__Group__43402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__4__Impl3430 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__5__Impl_in_rule__MultiChoiceEmConfig__Group__53461 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__6_in_rule__MultiChoiceEmConfig__Group__53464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__MultiChoiceEmConfig__Group__5__Impl3492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__6__Impl_in_rule__MultiChoiceEmConfig__Group__63523 = new BitSet(new long[]{0x0000000000001800L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__7_in_rule__MultiChoiceEmConfig__Group__63526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__6__Impl3554 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__7__Impl_in_rule__MultiChoiceEmConfig__Group__73585 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__8_in_rule__MultiChoiceEmConfig__Group__73588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__WeightedAssignment_7_in_rule__MultiChoiceEmConfig__Group__7__Impl3615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__8__Impl_in_rule__MultiChoiceEmConfig__Group__83645 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__9_in_rule__MultiChoiceEmConfig__Group__83648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__8__Impl3676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__9__Impl_in_rule__MultiChoiceEmConfig__Group__93707 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__10_in_rule__MultiChoiceEmConfig__Group__93710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__MultiChoiceEmConfig__Group__9__Impl3738 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__10__Impl_in_rule__MultiChoiceEmConfig__Group__103769 = new BitSet(new long[]{0x000000C000000040L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__11_in_rule__MultiChoiceEmConfig__Group__103772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__10__Impl3800 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__11__Impl_in_rule__MultiChoiceEmConfig__Group__113831 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__12_in_rule__MultiChoiceEmConfig__Group__113834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__PenaltyAssignment_11_in_rule__MultiChoiceEmConfig__Group__11__Impl3861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__12__Impl_in_rule__MultiChoiceEmConfig__Group__123891 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__13_in_rule__MultiChoiceEmConfig__Group__123894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__12__Impl3922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__13__Impl_in_rule__MultiChoiceEmConfig__Group__133953 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__14_in_rule__MultiChoiceEmConfig__Group__133956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__MultiChoiceEmConfig__Group__13__Impl3984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__14__Impl_in_rule__MultiChoiceEmConfig__Group__144015 = new BitSet(new long[]{0x0000000000078000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__15_in_rule__MultiChoiceEmConfig__Group__144018 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__14__Impl4046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__15__Impl_in_rule__MultiChoiceEmConfig__Group__154077 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__16_in_rule__MultiChoiceEmConfig__Group__154080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__OrderAssignment_15_in_rule__MultiChoiceEmConfig__Group__15__Impl4107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__16__Impl_in_rule__MultiChoiceEmConfig__Group__164137 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__17_in_rule__MultiChoiceEmConfig__Group__164140 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__MultiChoiceEmConfig__Group__16__Impl4168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__17__Impl_in_rule__MultiChoiceEmConfig__Group__174199 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__18_in_rule__MultiChoiceEmConfig__Group__174202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__MultiChoiceEmConfig__Group__17__Impl4230 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__18__Impl_in_rule__MultiChoiceEmConfig__Group__184261 = new BitSet(new long[]{0x0000000000180000L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__19_in_rule__MultiChoiceEmConfig__Group__184264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__MultiChoiceEmConfig__Group__18__Impl4292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__Group__19__Impl_in_rule__MultiChoiceEmConfig__Group__194323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__ModeAssignment_19_in_rule__MultiChoiceEmConfig__Group__19__Impl4350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04420 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04423 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__Test__Group__0__Impl4451 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14482 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14485 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__Test__Group__1__Impl4513 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24544 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__SourceAssignment_2_in_rule__Test__Group__2__Impl4574 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__34604 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Test__Group__4_in_rule__Test__Group__34607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__Test__Group__3__Impl4635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__44666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Test__QuestionAssignment_4_in_rule__Test__Group__4__Impl4693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__0__Impl_in_rule__EDouble__Group__04733 = new BitSet(new long[]{0x000000C000000040L});
        public static final BitSet FOLLOW_rule__EDouble__Group__1_in_rule__EDouble__Group__04736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__EDouble__Group__0__Impl4765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__1__Impl_in_rule__EDouble__Group__14798 = new BitSet(new long[]{0x000000C000000040L});
        public static final BitSet FOLLOW_rule__EDouble__Group__2_in_rule__EDouble__Group__14801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EDouble__Group__1__Impl4829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__2__Impl_in_rule__EDouble__Group__24860 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_rule__EDouble__Group__3_in_rule__EDouble__Group__24863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_rule__EDouble__Group__2__Impl4891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__3__Impl_in_rule__EDouble__Group__34922 = new BitSet(new long[]{0x0000000000006000L});
        public static final BitSet FOLLOW_rule__EDouble__Group__4_in_rule__EDouble__Group__34925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EDouble__Group__3__Impl4952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group__4__Impl_in_rule__EDouble__Group__44981 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_4__0_in_rule__EDouble__Group__4__Impl5008 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_4__0__Impl_in_rule__EDouble__Group_4__05049 = new BitSet(new long[]{0x0000004000000040L});
        public static final BitSet FOLLOW_rule__EDouble__Group_4__1_in_rule__EDouble__Group_4__05052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Alternatives_4_0_in_rule__EDouble__Group_4__0__Impl5079 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_4__1__Impl_in_rule__EDouble__Group_4__15109 = new BitSet(new long[]{0x0000004000000040L});
        public static final BitSet FOLLOW_rule__EDouble__Group_4__2_in_rule__EDouble__Group_4__15112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__EDouble__Group_4__1__Impl5141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EDouble__Group_4__2__Impl_in_rule__EDouble__Group_4__25174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_rule__EDouble__Group_4__2__Impl5201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgramConfiguration_in_rule__Program__ConfigAssignment_15241 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMutatorTests_in_rule__Program__ExercisesAssignment_25272 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__AlternativeResponse__BlockAssignment_15307 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestConfiguration_in_rule__AlternativeResponse__ConfigAssignment_35342 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_rule__AlternativeResponse__TestsAssignment_45373 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MultiChoiceDiagram__BlockAssignment_15408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTestConfiguration_in_rule__MultiChoiceDiagram__ConfigAssignment_35443 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_rule__MultiChoiceDiagram__TestsAssignment_45474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MultiChoiceEmendation__BlockAssignment_15509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMultiChoiceEmConfig_in_rule__MultiChoiceEmendation__ConfigAssignment_35544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTest_in_rule__MultiChoiceEmendation__TestsAssignment_45575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNavigation_in_rule__ProgramConfiguration__NavigationAssignment_25606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__TestConfiguration__RetryAlternatives_3_0_in_rule__TestConfiguration__RetryAssignment_35637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__RetryAlternatives_3_0_in_rule__MultiChoiceEmConfig__RetryAssignment_35670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MultiChoiceEmConfig__WeightedAlternatives_7_0_in_rule__MultiChoiceEmConfig__WeightedAssignment_75703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_rule__MultiChoiceEmConfig__PenaltyAssignment_115736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOrder_in_rule__MultiChoiceEmConfig__OrderAssignment_155767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMode_in_rule__MultiChoiceEmConfig__ModeAssignment_195798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Test__SourceAssignment_25829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Test__QuestionAssignment_45860 = new BitSet(new long[]{0x0000000000000002L});
    }


}