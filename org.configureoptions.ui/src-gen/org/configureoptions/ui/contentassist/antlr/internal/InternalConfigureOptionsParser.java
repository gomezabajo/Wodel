package org.configureoptions.ui.contentassist.antlr.internal; 

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
import org.configureoptions.services.ConfigureOptionsGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalConfigureOptionsParser extends AbstractInternalContentAssistParser {
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


        public InternalConfigureOptionsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalConfigureOptionsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalConfigureOptionsParser.tokenNames; }
    public String getGrammarFileName() { return "../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g"; }


     
     	private ConfigureOptionsGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(ConfigureOptionsGrammarAccess grammarAccess) {
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:60:1: entryRuleConfiguration : ruleConfiguration EOF ;
    public final void entryRuleConfiguration() throws RecognitionException {
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:61:1: ( ruleConfiguration EOF )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:62:1: ruleConfiguration EOF
            {
             before(grammarAccess.getConfigurationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConfiguration_in_entryRuleConfiguration61);
            ruleConfiguration();

            state._fsp--;

             after(grammarAccess.getConfigurationRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConfiguration68); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:69:1: ruleConfiguration : ( ( rule__Configuration__Group__0 ) ) ;
    public final void ruleConfiguration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:73:2: ( ( ( rule__Configuration__Group__0 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:74:1: ( ( rule__Configuration__Group__0 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:74:1: ( ( rule__Configuration__Group__0 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:75:1: ( rule__Configuration__Group__0 )
            {
             before(grammarAccess.getConfigurationAccess().getGroup()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:76:1: ( rule__Configuration__Group__0 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:76:2: rule__Configuration__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__0_in_ruleConfiguration94);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:88:1: entryRuleOption : ruleOption EOF ;
    public final void entryRuleOption() throws RecognitionException {
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:89:1: ( ruleOption EOF )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:90:1: ruleOption EOF
            {
             before(grammarAccess.getOptionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOption_in_entryRuleOption121);
            ruleOption();

            state._fsp--;

             after(grammarAccess.getOptionRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOption128); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:97:1: ruleOption : ( ( rule__Option__Group__0 ) ) ;
    public final void ruleOption() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:101:2: ( ( ( rule__Option__Group__0 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:102:1: ( ( rule__Option__Group__0 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:102:1: ( ( rule__Option__Group__0 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:103:1: ( rule__Option__Group__0 )
            {
             before(grammarAccess.getOptionAccess().getGroup()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:104:1: ( rule__Option__Group__0 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:104:2: rule__Option__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__0_in_ruleOption154);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:116:1: entryRuleText : ruleText EOF ;
    public final void entryRuleText() throws RecognitionException {
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:117:1: ( ruleText EOF )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:118:1: ruleText EOF
            {
             before(grammarAccess.getTextRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleText_in_entryRuleText181);
            ruleText();

            state._fsp--;

             after(grammarAccess.getTextRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleText188); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:125:1: ruleText : ( ( rule__Text__Group__0 ) ) ;
    public final void ruleText() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:129:2: ( ( ( rule__Text__Group__0 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:130:1: ( ( rule__Text__Group__0 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:130:1: ( ( rule__Text__Group__0 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:131:1: ( rule__Text__Group__0 )
            {
             before(grammarAccess.getTextAccess().getGroup()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:132:1: ( rule__Text__Group__0 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:132:2: rule__Text__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Text__Group__0_in_ruleText214);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:144:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:145:1: ( ruleWord EOF )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:146:1: ruleWord EOF
            {
             before(grammarAccess.getWordRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_entryRuleWord241);
            ruleWord();

            state._fsp--;

             after(grammarAccess.getWordRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleWord248); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:153:1: ruleWord : ( ( rule__Word__Alternatives ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:157:2: ( ( ( rule__Word__Alternatives ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:158:1: ( ( rule__Word__Alternatives ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:158:1: ( ( rule__Word__Alternatives ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:159:1: ( rule__Word__Alternatives )
            {
             before(grammarAccess.getWordAccess().getAlternatives()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:160:1: ( rule__Word__Alternatives )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:160:2: rule__Word__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Word__Alternatives_in_ruleWord274);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:172:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:173:1: ( ruleConstant EOF )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:174:1: ruleConstant EOF
            {
             before(grammarAccess.getConstantRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstant_in_entryRuleConstant301);
            ruleConstant();

            state._fsp--;

             after(grammarAccess.getConstantRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstant308); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:181:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:185:2: ( ( ( rule__Constant__Group__0 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:186:1: ( ( rule__Constant__Group__0 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:186:1: ( ( rule__Constant__Group__0 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:187:1: ( rule__Constant__Group__0 )
            {
             before(grammarAccess.getConstantAccess().getGroup()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:188:1: ( rule__Constant__Group__0 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:188:2: rule__Constant__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Constant__Group__0_in_ruleConstant334);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:200:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:201:1: ( ruleVariable EOF )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:202:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariable_in_entryRuleVariable361);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVariable368); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:209:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:213:2: ( ( ( rule__Variable__Group__0 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:214:1: ( ( rule__Variable__Group__0 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:214:1: ( ( rule__Variable__Group__0 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:215:1: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:216:1: ( rule__Variable__Group__0 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:216:2: rule__Variable__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__0_in_ruleVariable394);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:228:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:229:1: ( ruleEString EOF )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:230:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString421);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString428); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:237:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:241:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:242:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:242:1: ( ( rule__EString__Alternatives ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:243:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:244:1: ( rule__EString__Alternatives )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:244:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString454);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:257:1: ruleVariableType : ( ( rule__VariableType__Alternatives ) ) ;
    public final void ruleVariableType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:261:1: ( ( ( rule__VariableType__Alternatives ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:262:1: ( ( rule__VariableType__Alternatives ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:262:1: ( ( rule__VariableType__Alternatives ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:263:1: ( rule__VariableType__Alternatives )
            {
             before(grammarAccess.getVariableTypeAccess().getAlternatives()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:264:1: ( rule__VariableType__Alternatives )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:264:2: rule__VariableType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__VariableType__Alternatives_in_ruleVariableType491);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:275:1: rule__Word__Alternatives : ( ( ruleConstant ) | ( ruleVariable ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:279:1: ( ( ruleConstant ) | ( ruleVariable ) )
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
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:280:1: ( ruleConstant )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:280:1: ( ruleConstant )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:281:1: ruleConstant
                    {
                     before(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleConstant_in_rule__Word__Alternatives526);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:286:6: ( ruleVariable )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:286:6: ( ruleVariable )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:287:1: ruleVariable
                    {
                     before(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_rule__Word__Alternatives543);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:297:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:301:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:302:1: ( RULE_STRING )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:302:1: ( RULE_STRING )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:303:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives575); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:308:6: ( RULE_ID )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:308:6: ( RULE_ID )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:309:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives592); 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:319:1: rule__VariableType__Alternatives : ( ( ( '%object' ) ) | ( ( '%attName' ) ) | ( ( '%oldValue' ) ) | ( ( '%newValue' ) ) | ( ( '%refName' ) ) | ( ( '%fromObject' ) ) | ( ( '%oldFromObject' ) ) | ( ( '%srcRefName' ) ) | ( ( '%toObject' ) ) | ( ( '%oldToObject' ) ) | ( ( '%firstRefName' ) ) | ( ( '%firstObject' ) ) | ( ( '%firstFromObject' ) ) | ( ( '%firstToObject' ) ) | ( ( '%secondRefName' ) ) | ( ( '%secondObject' ) ) | ( ( '%secondFromObject' ) ) | ( ( '%secondToObject' ) ) | ( ( '%firstAttName' ) ) | ( ( '%firstValue' ) ) | ( ( '%secondAttName' ) ) | ( ( '%secondValue' ) ) );
    public final void rule__VariableType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:323:1: ( ( ( '%object' ) ) | ( ( '%attName' ) ) | ( ( '%oldValue' ) ) | ( ( '%newValue' ) ) | ( ( '%refName' ) ) | ( ( '%fromObject' ) ) | ( ( '%oldFromObject' ) ) | ( ( '%srcRefName' ) ) | ( ( '%toObject' ) ) | ( ( '%oldToObject' ) ) | ( ( '%firstRefName' ) ) | ( ( '%firstObject' ) ) | ( ( '%firstFromObject' ) ) | ( ( '%firstToObject' ) ) | ( ( '%secondRefName' ) ) | ( ( '%secondObject' ) ) | ( ( '%secondFromObject' ) ) | ( ( '%secondToObject' ) ) | ( ( '%firstAttName' ) ) | ( ( '%firstValue' ) ) | ( ( '%secondAttName' ) ) | ( ( '%secondValue' ) ) )
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
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:324:1: ( ( '%object' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:324:1: ( ( '%object' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:325:1: ( '%object' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:326:1: ( '%object' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:326:3: '%object'
                    {
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__VariableType__Alternatives625); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getObjectEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:331:6: ( ( '%attName' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:331:6: ( ( '%attName' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:332:1: ( '%attName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:333:1: ( '%attName' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:333:3: '%attName'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__VariableType__Alternatives646); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getAttNameEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:338:6: ( ( '%oldValue' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:338:6: ( ( '%oldValue' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:339:1: ( '%oldValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:340:1: ( '%oldValue' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:340:3: '%oldValue'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__VariableType__Alternatives667); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getOldValueEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:345:6: ( ( '%newValue' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:345:6: ( ( '%newValue' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:346:1: ( '%newValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:347:1: ( '%newValue' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:347:3: '%newValue'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__VariableType__Alternatives688); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getNewValueEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:352:6: ( ( '%refName' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:352:6: ( ( '%refName' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:353:1: ( '%refName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:354:1: ( '%refName' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:354:3: '%refName'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__VariableType__Alternatives709); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getRefNameEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:359:6: ( ( '%fromObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:359:6: ( ( '%fromObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:360:1: ( '%fromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:361:1: ( '%fromObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:361:3: '%fromObject'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__VariableType__Alternatives730); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFromObjectEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:366:6: ( ( '%oldFromObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:366:6: ( ( '%oldFromObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:367:1: ( '%oldFromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:368:1: ( '%oldFromObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:368:3: '%oldFromObject'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__VariableType__Alternatives751); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getOldFromObjectEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:373:6: ( ( '%srcRefName' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:373:6: ( ( '%srcRefName' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:374:1: ( '%srcRefName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:375:1: ( '%srcRefName' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:375:3: '%srcRefName'
                    {
                    match(input,18,FollowSets000.FOLLOW_18_in_rule__VariableType__Alternatives772); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSrcRefNameEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:380:6: ( ( '%toObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:380:6: ( ( '%toObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:381:1: ( '%toObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:382:1: ( '%toObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:382:3: '%toObject'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_rule__VariableType__Alternatives793); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getToObjectEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:387:6: ( ( '%oldToObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:387:6: ( ( '%oldToObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:388:1: ( '%oldToObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:389:1: ( '%oldToObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:389:3: '%oldToObject'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_rule__VariableType__Alternatives814); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getOldToObjectEnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:394:6: ( ( '%firstRefName' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:394:6: ( ( '%firstRefName' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:395:1: ( '%firstRefName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:396:1: ( '%firstRefName' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:396:3: '%firstRefName'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_rule__VariableType__Alternatives835); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstRefNameEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:401:6: ( ( '%firstObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:401:6: ( ( '%firstObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:402:1: ( '%firstObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:403:1: ( '%firstObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:403:3: '%firstObject'
                    {
                    match(input,22,FollowSets000.FOLLOW_22_in_rule__VariableType__Alternatives856); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstObjectEnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:408:6: ( ( '%firstFromObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:408:6: ( ( '%firstFromObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:409:1: ( '%firstFromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:410:1: ( '%firstFromObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:410:3: '%firstFromObject'
                    {
                    match(input,23,FollowSets000.FOLLOW_23_in_rule__VariableType__Alternatives877); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstFromObjectEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:415:6: ( ( '%firstToObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:415:6: ( ( '%firstToObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:416:1: ( '%firstToObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:417:1: ( '%firstToObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:417:3: '%firstToObject'
                    {
                    match(input,24,FollowSets000.FOLLOW_24_in_rule__VariableType__Alternatives898); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstToObjectEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:422:6: ( ( '%secondRefName' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:422:6: ( ( '%secondRefName' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:423:1: ( '%secondRefName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:424:1: ( '%secondRefName' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:424:3: '%secondRefName'
                    {
                    match(input,25,FollowSets000.FOLLOW_25_in_rule__VariableType__Alternatives919); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondRefNameEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;
                case 16 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:429:6: ( ( '%secondObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:429:6: ( ( '%secondObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:430:1: ( '%secondObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:431:1: ( '%secondObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:431:3: '%secondObject'
                    {
                    match(input,26,FollowSets000.FOLLOW_26_in_rule__VariableType__Alternatives940); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondObjectEnumLiteralDeclaration_15()); 

                    }


                    }
                    break;
                case 17 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:436:6: ( ( '%secondFromObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:436:6: ( ( '%secondFromObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:437:1: ( '%secondFromObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:438:1: ( '%secondFromObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:438:3: '%secondFromObject'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_rule__VariableType__Alternatives961); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondFromObjectEnumLiteralDeclaration_16()); 

                    }


                    }
                    break;
                case 18 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:443:6: ( ( '%secondToObject' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:443:6: ( ( '%secondToObject' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:444:1: ( '%secondToObject' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:445:1: ( '%secondToObject' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:445:3: '%secondToObject'
                    {
                    match(input,28,FollowSets000.FOLLOW_28_in_rule__VariableType__Alternatives982); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondToObjectEnumLiteralDeclaration_17()); 

                    }


                    }
                    break;
                case 19 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:450:6: ( ( '%firstAttName' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:450:6: ( ( '%firstAttName' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:451:1: ( '%firstAttName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:452:1: ( '%firstAttName' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:452:3: '%firstAttName'
                    {
                    match(input,29,FollowSets000.FOLLOW_29_in_rule__VariableType__Alternatives1003); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstAttNameEnumLiteralDeclaration_18()); 

                    }


                    }
                    break;
                case 20 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:457:6: ( ( '%firstValue' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:457:6: ( ( '%firstValue' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:458:1: ( '%firstValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:459:1: ( '%firstValue' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:459:3: '%firstValue'
                    {
                    match(input,30,FollowSets000.FOLLOW_30_in_rule__VariableType__Alternatives1024); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getFirstValueEnumLiteralDeclaration_19()); 

                    }


                    }
                    break;
                case 21 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:464:6: ( ( '%secondAttName' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:464:6: ( ( '%secondAttName' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:465:1: ( '%secondAttName' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:466:1: ( '%secondAttName' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:466:3: '%secondAttName'
                    {
                    match(input,31,FollowSets000.FOLLOW_31_in_rule__VariableType__Alternatives1045); 

                    }

                     after(grammarAccess.getVariableTypeAccess().getSecondAttNameEnumLiteralDeclaration_20()); 

                    }


                    }
                    break;
                case 22 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:471:6: ( ( '%secondValue' ) )
                    {
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:471:6: ( ( '%secondValue' ) )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:472:1: ( '%secondValue' )
                    {
                     before(grammarAccess.getVariableTypeAccess().getSecondValueEnumLiteralDeclaration_21()); 
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:473:1: ( '%secondValue' )
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:473:3: '%secondValue'
                    {
                    match(input,32,FollowSets000.FOLLOW_32_in_rule__VariableType__Alternatives1066); 

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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:485:1: rule__Configuration__Group__0 : rule__Configuration__Group__0__Impl rule__Configuration__Group__1 ;
    public final void rule__Configuration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:489:1: ( rule__Configuration__Group__0__Impl rule__Configuration__Group__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:490:2: rule__Configuration__Group__0__Impl rule__Configuration__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__0__Impl_in_rule__Configuration__Group__01099);
            rule__Configuration__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__1_in_rule__Configuration__Group__01102);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:497:1: rule__Configuration__Group__0__Impl : ( () ) ;
    public final void rule__Configuration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:501:1: ( ( () ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:502:1: ( () )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:502:1: ( () )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:503:1: ()
            {
             before(grammarAccess.getConfigurationAccess().getConfigurationAction_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:504:1: ()
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:506:1: 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:516:1: rule__Configuration__Group__1 : rule__Configuration__Group__1__Impl rule__Configuration__Group__2 ;
    public final void rule__Configuration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:520:1: ( rule__Configuration__Group__1__Impl rule__Configuration__Group__2 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:521:2: rule__Configuration__Group__1__Impl rule__Configuration__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__1__Impl_in_rule__Configuration__Group__11160);
            rule__Configuration__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__2_in_rule__Configuration__Group__11163);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:528:1: rule__Configuration__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__Configuration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:532:1: ( ( 'metamodel' ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:533:1: ( 'metamodel' )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:533:1: ( 'metamodel' )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:534:1: 'metamodel'
            {
             before(grammarAccess.getConfigurationAccess().getMetamodelKeyword_1()); 
            match(input,33,FollowSets000.FOLLOW_33_in_rule__Configuration__Group__1__Impl1191); 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:547:1: rule__Configuration__Group__2 : rule__Configuration__Group__2__Impl rule__Configuration__Group__3 ;
    public final void rule__Configuration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:551:1: ( rule__Configuration__Group__2__Impl rule__Configuration__Group__3 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:552:2: rule__Configuration__Group__2__Impl rule__Configuration__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__2__Impl_in_rule__Configuration__Group__21222);
            rule__Configuration__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__3_in_rule__Configuration__Group__21225);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:559:1: rule__Configuration__Group__2__Impl : ( ( rule__Configuration__MetamodelAssignment_2 ) ) ;
    public final void rule__Configuration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:563:1: ( ( ( rule__Configuration__MetamodelAssignment_2 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:564:1: ( ( rule__Configuration__MetamodelAssignment_2 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:564:1: ( ( rule__Configuration__MetamodelAssignment_2 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:565:1: ( rule__Configuration__MetamodelAssignment_2 )
            {
             before(grammarAccess.getConfigurationAccess().getMetamodelAssignment_2()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:566:1: ( rule__Configuration__MetamodelAssignment_2 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:566:2: rule__Configuration__MetamodelAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__MetamodelAssignment_2_in_rule__Configuration__Group__2__Impl1252);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:576:1: rule__Configuration__Group__3 : rule__Configuration__Group__3__Impl ;
    public final void rule__Configuration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:580:1: ( rule__Configuration__Group__3__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:581:2: rule__Configuration__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group__3__Impl_in_rule__Configuration__Group__31282);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:587:1: rule__Configuration__Group__3__Impl : ( ( rule__Configuration__Group_3__0 )? ) ;
    public final void rule__Configuration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:591:1: ( ( ( rule__Configuration__Group_3__0 )? ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:592:1: ( ( rule__Configuration__Group_3__0 )? )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:592:1: ( ( rule__Configuration__Group_3__0 )? )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:593:1: ( rule__Configuration__Group_3__0 )?
            {
             before(grammarAccess.getConfigurationAccess().getGroup_3()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:594:1: ( rule__Configuration__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==34) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:594:2: rule__Configuration__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__0_in_rule__Configuration__Group__3__Impl1309);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:612:1: rule__Configuration__Group_3__0 : rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1 ;
    public final void rule__Configuration__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:616:1: ( rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:617:2: rule__Configuration__Group_3__0__Impl rule__Configuration__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__0__Impl_in_rule__Configuration__Group_3__01348);
            rule__Configuration__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__1_in_rule__Configuration__Group_3__01351);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:624:1: rule__Configuration__Group_3__0__Impl : ( ( rule__Configuration__OptionsAssignment_3_0 ) ) ;
    public final void rule__Configuration__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:628:1: ( ( ( rule__Configuration__OptionsAssignment_3_0 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:629:1: ( ( rule__Configuration__OptionsAssignment_3_0 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:629:1: ( ( rule__Configuration__OptionsAssignment_3_0 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:630:1: ( rule__Configuration__OptionsAssignment_3_0 )
            {
             before(grammarAccess.getConfigurationAccess().getOptionsAssignment_3_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:631:1: ( rule__Configuration__OptionsAssignment_3_0 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:631:2: rule__Configuration__OptionsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__OptionsAssignment_3_0_in_rule__Configuration__Group_3__0__Impl1378);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:641:1: rule__Configuration__Group_3__1 : rule__Configuration__Group_3__1__Impl ;
    public final void rule__Configuration__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:645:1: ( rule__Configuration__Group_3__1__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:646:2: rule__Configuration__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Configuration__Group_3__1__Impl_in_rule__Configuration__Group_3__11408);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:652:1: rule__Configuration__Group_3__1__Impl : ( ( rule__Configuration__OptionsAssignment_3_1 )* ) ;
    public final void rule__Configuration__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:656:1: ( ( ( rule__Configuration__OptionsAssignment_3_1 )* ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:657:1: ( ( rule__Configuration__OptionsAssignment_3_1 )* )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:657:1: ( ( rule__Configuration__OptionsAssignment_3_1 )* )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:658:1: ( rule__Configuration__OptionsAssignment_3_1 )*
            {
             before(grammarAccess.getConfigurationAccess().getOptionsAssignment_3_1()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:659:1: ( rule__Configuration__OptionsAssignment_3_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==34) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:659:2: rule__Configuration__OptionsAssignment_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Configuration__OptionsAssignment_3_1_in_rule__Configuration__Group_3__1__Impl1435);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:673:1: rule__Option__Group__0 : rule__Option__Group__0__Impl rule__Option__Group__1 ;
    public final void rule__Option__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:677:1: ( rule__Option__Group__0__Impl rule__Option__Group__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:678:2: rule__Option__Group__0__Impl rule__Option__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__0__Impl_in_rule__Option__Group__01470);
            rule__Option__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__1_in_rule__Option__Group__01473);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:685:1: rule__Option__Group__0__Impl : ( () ) ;
    public final void rule__Option__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:689:1: ( ( () ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:690:1: ( () )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:690:1: ( () )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:691:1: ()
            {
             before(grammarAccess.getOptionAccess().getOptionAction_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:692:1: ()
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:694:1: 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:704:1: rule__Option__Group__1 : rule__Option__Group__1__Impl rule__Option__Group__2 ;
    public final void rule__Option__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:708:1: ( rule__Option__Group__1__Impl rule__Option__Group__2 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:709:2: rule__Option__Group__1__Impl rule__Option__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__1__Impl_in_rule__Option__Group__11531);
            rule__Option__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__2_in_rule__Option__Group__11534);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:716:1: rule__Option__Group__1__Impl : ( '>' ) ;
    public final void rule__Option__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:720:1: ( ( '>' ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:721:1: ( '>' )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:721:1: ( '>' )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:722:1: '>'
            {
             before(grammarAccess.getOptionAccess().getGreaterThanSignKeyword_1()); 
            match(input,34,FollowSets000.FOLLOW_34_in_rule__Option__Group__1__Impl1562); 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:735:1: rule__Option__Group__2 : rule__Option__Group__2__Impl rule__Option__Group__3 ;
    public final void rule__Option__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:739:1: ( rule__Option__Group__2__Impl rule__Option__Group__3 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:740:2: rule__Option__Group__2__Impl rule__Option__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__2__Impl_in_rule__Option__Group__21593);
            rule__Option__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__3_in_rule__Option__Group__21596);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:747:1: rule__Option__Group__2__Impl : ( ( rule__Option__TypeAssignment_2 ) ) ;
    public final void rule__Option__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:751:1: ( ( ( rule__Option__TypeAssignment_2 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:752:1: ( ( rule__Option__TypeAssignment_2 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:752:1: ( ( rule__Option__TypeAssignment_2 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:753:1: ( rule__Option__TypeAssignment_2 )
            {
             before(grammarAccess.getOptionAccess().getTypeAssignment_2()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:754:1: ( rule__Option__TypeAssignment_2 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:754:2: rule__Option__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__TypeAssignment_2_in_rule__Option__Group__2__Impl1623);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:764:1: rule__Option__Group__3 : rule__Option__Group__3__Impl rule__Option__Group__4 ;
    public final void rule__Option__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:768:1: ( rule__Option__Group__3__Impl rule__Option__Group__4 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:769:2: rule__Option__Group__3__Impl rule__Option__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__3__Impl_in_rule__Option__Group__31653);
            rule__Option__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__4_in_rule__Option__Group__31656);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:776:1: rule__Option__Group__3__Impl : ( ( rule__Option__Group_3__0 )? ) ;
    public final void rule__Option__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:780:1: ( ( ( rule__Option__Group_3__0 )? ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:781:1: ( ( rule__Option__Group_3__0 )? )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:781:1: ( ( rule__Option__Group_3__0 )? )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:782:1: ( rule__Option__Group_3__0 )?
            {
             before(grammarAccess.getOptionAccess().getGroup_3()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:783:1: ( rule__Option__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==37) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:783:2: rule__Option__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Option__Group_3__0_in_rule__Option__Group__3__Impl1683);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:793:1: rule__Option__Group__4 : rule__Option__Group__4__Impl rule__Option__Group__5 ;
    public final void rule__Option__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:797:1: ( rule__Option__Group__4__Impl rule__Option__Group__5 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:798:2: rule__Option__Group__4__Impl rule__Option__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__4__Impl_in_rule__Option__Group__41714);
            rule__Option__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__5_in_rule__Option__Group__41717);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:805:1: rule__Option__Group__4__Impl : ( ':' ) ;
    public final void rule__Option__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:809:1: ( ( ':' ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:810:1: ( ':' )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:810:1: ( ':' )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:811:1: ':'
            {
             before(grammarAccess.getOptionAccess().getColonKeyword_4()); 
            match(input,35,FollowSets000.FOLLOW_35_in_rule__Option__Group__4__Impl1745); 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:824:1: rule__Option__Group__5 : rule__Option__Group__5__Impl rule__Option__Group__6 ;
    public final void rule__Option__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:828:1: ( rule__Option__Group__5__Impl rule__Option__Group__6 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:829:2: rule__Option__Group__5__Impl rule__Option__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__5__Impl_in_rule__Option__Group__51776);
            rule__Option__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__6_in_rule__Option__Group__51779);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:836:1: rule__Option__Group__5__Impl : ( ( rule__Option__ValidAssignment_5 ) ) ;
    public final void rule__Option__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:840:1: ( ( ( rule__Option__ValidAssignment_5 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:841:1: ( ( rule__Option__ValidAssignment_5 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:841:1: ( ( rule__Option__ValidAssignment_5 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:842:1: ( rule__Option__ValidAssignment_5 )
            {
             before(grammarAccess.getOptionAccess().getValidAssignment_5()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:843:1: ( rule__Option__ValidAssignment_5 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:843:2: rule__Option__ValidAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__ValidAssignment_5_in_rule__Option__Group__5__Impl1806);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:853:1: rule__Option__Group__6 : rule__Option__Group__6__Impl rule__Option__Group__7 ;
    public final void rule__Option__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:857:1: ( rule__Option__Group__6__Impl rule__Option__Group__7 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:858:2: rule__Option__Group__6__Impl rule__Option__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__6__Impl_in_rule__Option__Group__61836);
            rule__Option__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__7_in_rule__Option__Group__61839);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:865:1: rule__Option__Group__6__Impl : ( '/' ) ;
    public final void rule__Option__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:869:1: ( ( '/' ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:870:1: ( '/' )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:870:1: ( '/' )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:871:1: '/'
            {
             before(grammarAccess.getOptionAccess().getSolidusKeyword_6()); 
            match(input,36,FollowSets000.FOLLOW_36_in_rule__Option__Group__6__Impl1867); 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:884:1: rule__Option__Group__7 : rule__Option__Group__7__Impl ;
    public final void rule__Option__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:888:1: ( rule__Option__Group__7__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:889:2: rule__Option__Group__7__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group__7__Impl_in_rule__Option__Group__71898);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:895:1: rule__Option__Group__7__Impl : ( ( rule__Option__InvalidAssignment_7 ) ) ;
    public final void rule__Option__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:899:1: ( ( ( rule__Option__InvalidAssignment_7 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:900:1: ( ( rule__Option__InvalidAssignment_7 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:900:1: ( ( rule__Option__InvalidAssignment_7 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:901:1: ( rule__Option__InvalidAssignment_7 )
            {
             before(grammarAccess.getOptionAccess().getInvalidAssignment_7()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:902:1: ( rule__Option__InvalidAssignment_7 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:902:2: rule__Option__InvalidAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__InvalidAssignment_7_in_rule__Option__Group__7__Impl1925);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:928:1: rule__Option__Group_3__0 : rule__Option__Group_3__0__Impl rule__Option__Group_3__1 ;
    public final void rule__Option__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:932:1: ( rule__Option__Group_3__0__Impl rule__Option__Group_3__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:933:2: rule__Option__Group_3__0__Impl rule__Option__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group_3__0__Impl_in_rule__Option__Group_3__01971);
            rule__Option__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group_3__1_in_rule__Option__Group_3__01974);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:940:1: rule__Option__Group_3__0__Impl : ( '(' ) ;
    public final void rule__Option__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:944:1: ( ( '(' ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:945:1: ( '(' )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:945:1: ( '(' )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:946:1: '('
            {
             before(grammarAccess.getOptionAccess().getLeftParenthesisKeyword_3_0()); 
            match(input,37,FollowSets000.FOLLOW_37_in_rule__Option__Group_3__0__Impl2002); 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:959:1: rule__Option__Group_3__1 : rule__Option__Group_3__1__Impl rule__Option__Group_3__2 ;
    public final void rule__Option__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:963:1: ( rule__Option__Group_3__1__Impl rule__Option__Group_3__2 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:964:2: rule__Option__Group_3__1__Impl rule__Option__Group_3__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group_3__1__Impl_in_rule__Option__Group_3__12033);
            rule__Option__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Option__Group_3__2_in_rule__Option__Group_3__12036);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:971:1: rule__Option__Group_3__1__Impl : ( ( rule__Option__ObjectAssignment_3_1 ) ) ;
    public final void rule__Option__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:975:1: ( ( ( rule__Option__ObjectAssignment_3_1 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:976:1: ( ( rule__Option__ObjectAssignment_3_1 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:976:1: ( ( rule__Option__ObjectAssignment_3_1 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:977:1: ( rule__Option__ObjectAssignment_3_1 )
            {
             before(grammarAccess.getOptionAccess().getObjectAssignment_3_1()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:978:1: ( rule__Option__ObjectAssignment_3_1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:978:2: rule__Option__ObjectAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__ObjectAssignment_3_1_in_rule__Option__Group_3__1__Impl2063);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:988:1: rule__Option__Group_3__2 : rule__Option__Group_3__2__Impl ;
    public final void rule__Option__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:992:1: ( rule__Option__Group_3__2__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:993:2: rule__Option__Group_3__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Option__Group_3__2__Impl_in_rule__Option__Group_3__22093);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:999:1: rule__Option__Group_3__2__Impl : ( ')' ) ;
    public final void rule__Option__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1003:1: ( ( ')' ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1004:1: ( ')' )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1004:1: ( ')' )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1005:1: ')'
            {
             before(grammarAccess.getOptionAccess().getRightParenthesisKeyword_3_2()); 
            match(input,38,FollowSets000.FOLLOW_38_in_rule__Option__Group_3__2__Impl2121); 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1024:1: rule__Text__Group__0 : rule__Text__Group__0__Impl rule__Text__Group__1 ;
    public final void rule__Text__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1028:1: ( rule__Text__Group__0__Impl rule__Text__Group__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1029:2: rule__Text__Group__0__Impl rule__Text__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Text__Group__0__Impl_in_rule__Text__Group__02158);
            rule__Text__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Text__Group__1_in_rule__Text__Group__02161);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1036:1: rule__Text__Group__0__Impl : ( () ) ;
    public final void rule__Text__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1040:1: ( ( () ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1041:1: ( () )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1041:1: ( () )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1042:1: ()
            {
             before(grammarAccess.getTextAccess().getTextAction_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1043:1: ()
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1045:1: 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1055:1: rule__Text__Group__1 : rule__Text__Group__1__Impl ;
    public final void rule__Text__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1059:1: ( rule__Text__Group__1__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1060:2: rule__Text__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Text__Group__1__Impl_in_rule__Text__Group__12219);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1066:1: rule__Text__Group__1__Impl : ( ( rule__Text__Group_1__0 )? ) ;
    public final void rule__Text__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1070:1: ( ( ( rule__Text__Group_1__0 )? ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1071:1: ( ( rule__Text__Group_1__0 )? )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1071:1: ( ( rule__Text__Group_1__0 )? )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1072:1: ( rule__Text__Group_1__0 )?
            {
             before(grammarAccess.getTextAccess().getGroup_1()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1073:1: ( rule__Text__Group_1__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)||(LA7_0>=11 && LA7_0<=32)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1073:2: rule__Text__Group_1__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Text__Group_1__0_in_rule__Text__Group__1__Impl2246);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1087:1: rule__Text__Group_1__0 : rule__Text__Group_1__0__Impl rule__Text__Group_1__1 ;
    public final void rule__Text__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1091:1: ( rule__Text__Group_1__0__Impl rule__Text__Group_1__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1092:2: rule__Text__Group_1__0__Impl rule__Text__Group_1__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Text__Group_1__0__Impl_in_rule__Text__Group_1__02281);
            rule__Text__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Text__Group_1__1_in_rule__Text__Group_1__02284);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1099:1: rule__Text__Group_1__0__Impl : ( ( rule__Text__WordsAssignment_1_0 ) ) ;
    public final void rule__Text__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1103:1: ( ( ( rule__Text__WordsAssignment_1_0 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1104:1: ( ( rule__Text__WordsAssignment_1_0 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1104:1: ( ( rule__Text__WordsAssignment_1_0 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1105:1: ( rule__Text__WordsAssignment_1_0 )
            {
             before(grammarAccess.getTextAccess().getWordsAssignment_1_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1106:1: ( rule__Text__WordsAssignment_1_0 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1106:2: rule__Text__WordsAssignment_1_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Text__WordsAssignment_1_0_in_rule__Text__Group_1__0__Impl2311);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1116:1: rule__Text__Group_1__1 : rule__Text__Group_1__1__Impl ;
    public final void rule__Text__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1120:1: ( rule__Text__Group_1__1__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1121:2: rule__Text__Group_1__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Text__Group_1__1__Impl_in_rule__Text__Group_1__12341);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1127:1: rule__Text__Group_1__1__Impl : ( ( rule__Text__WordsAssignment_1_1 )* ) ;
    public final void rule__Text__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1131:1: ( ( ( rule__Text__WordsAssignment_1_1 )* ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1132:1: ( ( rule__Text__WordsAssignment_1_1 )* )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1132:1: ( ( rule__Text__WordsAssignment_1_1 )* )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1133:1: ( rule__Text__WordsAssignment_1_1 )*
            {
             before(grammarAccess.getTextAccess().getWordsAssignment_1_1()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1134:1: ( rule__Text__WordsAssignment_1_1 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)||(LA8_0>=11 && LA8_0<=32)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1134:2: rule__Text__WordsAssignment_1_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Text__WordsAssignment_1_1_in_rule__Text__Group_1__1__Impl2368);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1148:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1152:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1153:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__02403);
            rule__Constant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__02406);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1160:1: rule__Constant__Group__0__Impl : ( () ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1164:1: ( ( () ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1165:1: ( () )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1165:1: ( () )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1166:1: ()
            {
             before(grammarAccess.getConstantAccess().getConstantAction_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1167:1: ()
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1169:1: 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1179:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1183:1: ( rule__Constant__Group__1__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1184:2: rule__Constant__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__12464);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1190:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__ValueAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1194:1: ( ( ( rule__Constant__ValueAssignment_1 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1195:1: ( ( rule__Constant__ValueAssignment_1 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1195:1: ( ( rule__Constant__ValueAssignment_1 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1196:1: ( rule__Constant__ValueAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1197:1: ( rule__Constant__ValueAssignment_1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1197:2: rule__Constant__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Constant__ValueAssignment_1_in_rule__Constant__Group__1__Impl2491);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1211:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1215:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1216:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02525);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02528);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1223:1: rule__Variable__Group__0__Impl : ( () ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1227:1: ( ( () ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1228:1: ( () )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1228:1: ( () )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1229:1: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1230:1: ()
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1232:1: 
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1242:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1246:1: ( rule__Variable__Group__1__Impl )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1247:2: rule__Variable__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12586);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1253:1: rule__Variable__Group__1__Impl : ( ( rule__Variable__TypeAssignment_1 ) ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1257:1: ( ( ( rule__Variable__TypeAssignment_1 ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1258:1: ( ( rule__Variable__TypeAssignment_1 ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1258:1: ( ( rule__Variable__TypeAssignment_1 ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1259:1: ( rule__Variable__TypeAssignment_1 )
            {
             before(grammarAccess.getVariableAccess().getTypeAssignment_1()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1260:1: ( rule__Variable__TypeAssignment_1 )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1260:2: rule__Variable__TypeAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__TypeAssignment_1_in_rule__Variable__Group__1__Impl2613);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1275:1: rule__Configuration__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__Configuration__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1279:1: ( ( ruleEString ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1280:1: ( ruleEString )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1280:1: ( ruleEString )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1281:1: ruleEString
            {
             before(grammarAccess.getConfigurationAccess().getMetamodelEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Configuration__MetamodelAssignment_22652);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1290:1: rule__Configuration__OptionsAssignment_3_0 : ( ruleOption ) ;
    public final void rule__Configuration__OptionsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1294:1: ( ( ruleOption ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1295:1: ( ruleOption )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1295:1: ( ruleOption )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1296:1: ruleOption
            {
             before(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOption_in_rule__Configuration__OptionsAssignment_3_02683);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1305:1: rule__Configuration__OptionsAssignment_3_1 : ( ruleOption ) ;
    public final void rule__Configuration__OptionsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1309:1: ( ( ruleOption ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1310:1: ( ruleOption )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1310:1: ( ruleOption )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1311:1: ruleOption
            {
             before(grammarAccess.getConfigurationAccess().getOptionsOptionParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleOption_in_rule__Configuration__OptionsAssignment_3_12714);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1320:1: rule__Option__TypeAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__Option__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1324:1: ( ( ( ruleEString ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1325:1: ( ( ruleEString ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1325:1: ( ( ruleEString ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1326:1: ( ruleEString )
            {
             before(grammarAccess.getOptionAccess().getTypeEClassCrossReference_2_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1327:1: ( ruleEString )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1328:1: ruleEString
            {
             before(grammarAccess.getOptionAccess().getTypeEClassEStringParserRuleCall_2_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Option__TypeAssignment_22749);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1339:1: rule__Option__ObjectAssignment_3_1 : ( ( ruleEString ) ) ;
    public final void rule__Option__ObjectAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1343:1: ( ( ( ruleEString ) ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1344:1: ( ( ruleEString ) )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1344:1: ( ( ruleEString ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1345:1: ( ruleEString )
            {
             before(grammarAccess.getOptionAccess().getObjectEObjectCrossReference_3_1_0()); 
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1346:1: ( ruleEString )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1347:1: ruleEString
            {
             before(grammarAccess.getOptionAccess().getObjectEObjectEStringParserRuleCall_3_1_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Option__ObjectAssignment_3_12788);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1358:1: rule__Option__ValidAssignment_5 : ( ruleText ) ;
    public final void rule__Option__ValidAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1362:1: ( ( ruleText ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1363:1: ( ruleText )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1363:1: ( ruleText )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1364:1: ruleText
            {
             before(grammarAccess.getOptionAccess().getValidTextParserRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleText_in_rule__Option__ValidAssignment_52823);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1373:1: rule__Option__InvalidAssignment_7 : ( ruleText ) ;
    public final void rule__Option__InvalidAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1377:1: ( ( ruleText ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1378:1: ( ruleText )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1378:1: ( ruleText )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1379:1: ruleText
            {
             before(grammarAccess.getOptionAccess().getInvalidTextParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleText_in_rule__Option__InvalidAssignment_72854);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1388:1: rule__Text__WordsAssignment_1_0 : ( ruleWord ) ;
    public final void rule__Text__WordsAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1392:1: ( ( ruleWord ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1393:1: ( ruleWord )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1393:1: ( ruleWord )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1394:1: ruleWord
            {
             before(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_rule__Text__WordsAssignment_1_02885);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1403:1: rule__Text__WordsAssignment_1_1 : ( ruleWord ) ;
    public final void rule__Text__WordsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1407:1: ( ( ruleWord ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1408:1: ( ruleWord )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1408:1: ( ruleWord )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1409:1: ruleWord
            {
             before(grammarAccess.getTextAccess().getWordsWordParserRuleCall_1_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_rule__Text__WordsAssignment_1_12916);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1418:1: rule__Constant__ValueAssignment_1 : ( ruleEString ) ;
    public final void rule__Constant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1422:1: ( ( ruleEString ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1423:1: ( ruleEString )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1423:1: ( ruleEString )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1424:1: ruleEString
            {
             before(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Constant__ValueAssignment_12947);
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
    // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1433:1: rule__Variable__TypeAssignment_1 : ( ruleVariableType ) ;
    public final void rule__Variable__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1437:1: ( ( ruleVariableType ) )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1438:1: ( ruleVariableType )
            {
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1438:1: ( ruleVariableType )
            // ../org.configureoptions.ui/src-gen/org/configureoptions/ui/contentassist/antlr/internal/InternalConfigureOptions.g:1439:1: ruleVariableType
            {
             before(grammarAccess.getVariableAccess().getTypeVariableTypeEnumRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleVariableType_in_rule__Variable__TypeAssignment_12978);
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleConfiguration_in_entryRuleConfiguration61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConfiguration68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__0_in_ruleConfiguration94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOption_in_entryRuleOption121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOption128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__0_in_ruleOption154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleText_in_entryRuleText181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleText188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__Group__0_in_ruleText214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_entryRuleWord241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleWord248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Word__Alternatives_in_ruleWord274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant301 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstant308 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Constant__Group__0_in_ruleConstant334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable361 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVariable368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group__0_in_ruleVariable394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString428 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString454 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__VariableType__Alternatives_in_ruleVariableType491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_rule__Word__Alternatives526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_rule__Word__Alternatives543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__VariableType__Alternatives625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__VariableType__Alternatives646 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__VariableType__Alternatives667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__VariableType__Alternatives688 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__VariableType__Alternatives709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__VariableType__Alternatives730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__VariableType__Alternatives751 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__VariableType__Alternatives772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__VariableType__Alternatives793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__VariableType__Alternatives814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__VariableType__Alternatives835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__VariableType__Alternatives856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__VariableType__Alternatives877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__VariableType__Alternatives898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__VariableType__Alternatives919 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__VariableType__Alternatives940 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__VariableType__Alternatives961 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__VariableType__Alternatives982 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_rule__VariableType__Alternatives1003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_rule__VariableType__Alternatives1024 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_rule__VariableType__Alternatives1045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_rule__VariableType__Alternatives1066 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__0__Impl_in_rule__Configuration__Group__01099 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_rule__Configuration__Group__1_in_rule__Configuration__Group__01102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__1__Impl_in_rule__Configuration__Group__11160 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Configuration__Group__2_in_rule__Configuration__Group__11163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_rule__Configuration__Group__1__Impl1191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__2__Impl_in_rule__Configuration__Group__21222 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__Configuration__Group__3_in_rule__Configuration__Group__21225 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__MetamodelAssignment_2_in_rule__Configuration__Group__2__Impl1252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group__3__Impl_in_rule__Configuration__Group__31282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__0_in_rule__Configuration__Group__3__Impl1309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__0__Impl_in_rule__Configuration__Group_3__01348 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__1_in_rule__Configuration__Group_3__01351 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__OptionsAssignment_3_0_in_rule__Configuration__Group_3__0__Impl1378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__Group_3__1__Impl_in_rule__Configuration__Group_3__11408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Configuration__OptionsAssignment_3_1_in_rule__Configuration__Group_3__1__Impl1435 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_rule__Option__Group__0__Impl_in_rule__Option__Group__01470 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_rule__Option__Group__1_in_rule__Option__Group__01473 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__1__Impl_in_rule__Option__Group__11531 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Option__Group__2_in_rule__Option__Group__11534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_rule__Option__Group__1__Impl1562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__2__Impl_in_rule__Option__Group__21593 = new BitSet(new long[]{0x0000002800000000L});
        public static final BitSet FOLLOW_rule__Option__Group__3_in_rule__Option__Group__21596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__TypeAssignment_2_in_rule__Option__Group__2__Impl1623 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__3__Impl_in_rule__Option__Group__31653 = new BitSet(new long[]{0x0000002800000000L});
        public static final BitSet FOLLOW_rule__Option__Group__4_in_rule__Option__Group__31656 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group_3__0_in_rule__Option__Group__3__Impl1683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__4__Impl_in_rule__Option__Group__41714 = new BitSet(new long[]{0x00000001FFFFF830L});
        public static final BitSet FOLLOW_rule__Option__Group__5_in_rule__Option__Group__41717 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_rule__Option__Group__4__Impl1745 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__5__Impl_in_rule__Option__Group__51776 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_rule__Option__Group__6_in_rule__Option__Group__51779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__ValidAssignment_5_in_rule__Option__Group__5__Impl1806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__6__Impl_in_rule__Option__Group__61836 = new BitSet(new long[]{0x00000001FFFFF830L});
        public static final BitSet FOLLOW_rule__Option__Group__7_in_rule__Option__Group__61839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_rule__Option__Group__6__Impl1867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group__7__Impl_in_rule__Option__Group__71898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__InvalidAssignment_7_in_rule__Option__Group__7__Impl1925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group_3__0__Impl_in_rule__Option__Group_3__01971 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Option__Group_3__1_in_rule__Option__Group_3__01974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_rule__Option__Group_3__0__Impl2002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group_3__1__Impl_in_rule__Option__Group_3__12033 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_rule__Option__Group_3__2_in_rule__Option__Group_3__12036 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__ObjectAssignment_3_1_in_rule__Option__Group_3__1__Impl2063 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Option__Group_3__2__Impl_in_rule__Option__Group_3__22093 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_rule__Option__Group_3__2__Impl2121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__Group__0__Impl_in_rule__Text__Group__02158 = new BitSet(new long[]{0x00000001FFFFF830L});
        public static final BitSet FOLLOW_rule__Text__Group__1_in_rule__Text__Group__02161 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__Group__1__Impl_in_rule__Text__Group__12219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__Group_1__0_in_rule__Text__Group__1__Impl2246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__Group_1__0__Impl_in_rule__Text__Group_1__02281 = new BitSet(new long[]{0x00000001FFFFF830L});
        public static final BitSet FOLLOW_rule__Text__Group_1__1_in_rule__Text__Group_1__02284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__WordsAssignment_1_0_in_rule__Text__Group_1__0__Impl2311 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__Group_1__1__Impl_in_rule__Text__Group_1__12341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Text__WordsAssignment_1_1_in_rule__Text__Group_1__1__Impl2368 = new BitSet(new long[]{0x00000001FFFFF832L});
        public static final BitSet FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__02403 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__02406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__12464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Constant__ValueAssignment_1_in_rule__Constant__Group__1__Impl2491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02525 = new BitSet(new long[]{0x00000001FFFFF830L});
        public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__TypeAssignment_1_in_rule__Variable__Group__1__Impl2613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Configuration__MetamodelAssignment_22652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOption_in_rule__Configuration__OptionsAssignment_3_02683 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOption_in_rule__Configuration__OptionsAssignment_3_12714 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Option__TypeAssignment_22749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Option__ObjectAssignment_3_12788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleText_in_rule__Option__ValidAssignment_52823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleText_in_rule__Option__InvalidAssignment_72854 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_rule__Text__WordsAssignment_1_02885 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_rule__Text__WordsAssignment_1_12916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Constant__ValueAssignment_12947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariableType_in_rule__Variable__TypeAssignment_12978 = new BitSet(new long[]{0x0000000000000002L});
    }


}