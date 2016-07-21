package wodeledu.dsls.ui.contentassist.antlr.internal; 

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
    public String getGrammarFileName() { return "../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g"; }


     
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:60:1: entryRuleIdentifyElements : ruleIdentifyElements EOF ;
    public final void entryRuleIdentifyElements() throws RecognitionException {
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:61:1: ( ruleIdentifyElements EOF )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:62:1: ruleIdentifyElements EOF
            {
             before(grammarAccess.getIdentifyElementsRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIdentifyElements_in_entryRuleIdentifyElements61);
            ruleIdentifyElements();

            state._fsp--;

             after(grammarAccess.getIdentifyElementsRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIdentifyElements68); 

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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:69:1: ruleIdentifyElements : ( ( rule__IdentifyElements__Group__0 ) ) ;
    public final void ruleIdentifyElements() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:73:2: ( ( ( rule__IdentifyElements__Group__0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:74:1: ( ( rule__IdentifyElements__Group__0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:74:1: ( ( rule__IdentifyElements__Group__0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:75:1: ( rule__IdentifyElements__Group__0 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getGroup()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:76:1: ( rule__IdentifyElements__Group__0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:76:2: rule__IdentifyElements__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__0_in_ruleIdentifyElements94);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:88:1: entryRuleElement : ruleElement EOF ;
    public final void entryRuleElement() throws RecognitionException {
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:89:1: ( ruleElement EOF )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:90:1: ruleElement EOF
            {
             before(grammarAccess.getElementRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_entryRuleElement121);
            ruleElement();

            state._fsp--;

             after(grammarAccess.getElementRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleElement128); 

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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:97:1: ruleElement : ( ( rule__Element__Group__0 ) ) ;
    public final void ruleElement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:101:2: ( ( ( rule__Element__Group__0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:102:1: ( ( rule__Element__Group__0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:102:1: ( ( rule__Element__Group__0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:103:1: ( rule__Element__Group__0 )
            {
             before(grammarAccess.getElementAccess().getGroup()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:104:1: ( rule__Element__Group__0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:104:2: rule__Element__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0_in_ruleElement154);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:116:1: entryRuleAttribute : ruleAttribute EOF ;
    public final void entryRuleAttribute() throws RecognitionException {
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:117:1: ( ruleAttribute EOF )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:118:1: ruleAttribute EOF
            {
             before(grammarAccess.getAttributeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_entryRuleAttribute181);
            ruleAttribute();

            state._fsp--;

             after(grammarAccess.getAttributeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttribute188); 

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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:125:1: ruleAttribute : ( ( rule__Attribute__Group__0 ) ) ;
    public final void ruleAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:129:2: ( ( ( rule__Attribute__Group__0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:130:1: ( ( rule__Attribute__Group__0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:130:1: ( ( rule__Attribute__Group__0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:131:1: ( rule__Attribute__Group__0 )
            {
             before(grammarAccess.getAttributeAccess().getGroup()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:132:1: ( rule__Attribute__Group__0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:132:2: rule__Attribute__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0_in_ruleAttribute214);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:144:1: entryRuleWord : ruleWord EOF ;
    public final void entryRuleWord() throws RecognitionException {
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:145:1: ( ruleWord EOF )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:146:1: ruleWord EOF
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:153:1: ruleWord : ( ( rule__Word__Alternatives ) ) ;
    public final void ruleWord() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:157:2: ( ( ( rule__Word__Alternatives ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:158:1: ( ( rule__Word__Alternatives ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:158:1: ( ( rule__Word__Alternatives ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:159:1: ( rule__Word__Alternatives )
            {
             before(grammarAccess.getWordAccess().getAlternatives()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:160:1: ( rule__Word__Alternatives )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:160:2: rule__Word__Alternatives
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:172:1: entryRuleConstant : ruleConstant EOF ;
    public final void entryRuleConstant() throws RecognitionException {
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:173:1: ( ruleConstant EOF )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:174:1: ruleConstant EOF
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:181:1: ruleConstant : ( ( rule__Constant__Group__0 ) ) ;
    public final void ruleConstant() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:185:2: ( ( ( rule__Constant__Group__0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:186:1: ( ( rule__Constant__Group__0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:186:1: ( ( rule__Constant__Group__0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:187:1: ( rule__Constant__Group__0 )
            {
             before(grammarAccess.getConstantAccess().getGroup()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:188:1: ( rule__Constant__Group__0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:188:2: rule__Constant__Group__0
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:200:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:201:1: ( ruleVariable EOF )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:202:1: ruleVariable EOF
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:209:1: ruleVariable : ( ( rule__Variable__Group__0 ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:213:2: ( ( ( rule__Variable__Group__0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:214:1: ( ( rule__Variable__Group__0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:214:1: ( ( rule__Variable__Group__0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:215:1: ( rule__Variable__Group__0 )
            {
             before(grammarAccess.getVariableAccess().getGroup()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:216:1: ( rule__Variable__Group__0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:216:2: rule__Variable__Group__0
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:228:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:229:1: ( ruleEString EOF )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:230:1: ruleEString EOF
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:237:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:241:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:242:1: ( ( rule__EString__Alternatives ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:242:1: ( ( rule__EString__Alternatives ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:243:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:244:1: ( rule__EString__Alternatives )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:244:2: rule__EString__Alternatives
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


    // $ANTLR start "rule__Attribute__Alternatives_1"
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:256:1: rule__Attribute__Alternatives_1 : ( ( ( rule__Attribute__NegationAssignment_1_0 ) ) | ( 'not' ) );
    public final void rule__Attribute__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:260:1: ( ( ( rule__Attribute__NegationAssignment_1_0 ) ) | ( 'not' ) )
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
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:261:1: ( ( rule__Attribute__NegationAssignment_1_0 ) )
                    {
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:261:1: ( ( rule__Attribute__NegationAssignment_1_0 ) )
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:262:1: ( rule__Attribute__NegationAssignment_1_0 )
                    {
                     before(grammarAccess.getAttributeAccess().getNegationAssignment_1_0()); 
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:263:1: ( rule__Attribute__NegationAssignment_1_0 )
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:263:2: rule__Attribute__NegationAssignment_1_0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute__NegationAssignment_1_0_in_rule__Attribute__Alternatives_1490);
                    rule__Attribute__NegationAssignment_1_0();

                    state._fsp--;


                    }

                     after(grammarAccess.getAttributeAccess().getNegationAssignment_1_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:267:6: ( 'not' )
                    {
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:267:6: ( 'not' )
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:268:1: 'not'
                    {
                     before(grammarAccess.getAttributeAccess().getNotKeyword_1_1()); 
                    match(input,11,FollowSets000.FOLLOW_11_in_rule__Attribute__Alternatives_1509); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:280:1: rule__Word__Alternatives : ( ( ruleConstant ) | ( ruleVariable ) );
    public final void rule__Word__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:284:1: ( ( ruleConstant ) | ( ruleVariable ) )
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
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:285:1: ( ruleConstant )
                    {
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:285:1: ( ruleConstant )
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:286:1: ruleConstant
                    {
                     before(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 
                    pushFollow(FollowSets000.FOLLOW_ruleConstant_in_rule__Word__Alternatives543);
                    ruleConstant();

                    state._fsp--;

                     after(grammarAccess.getWordAccess().getConstantParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:291:6: ( ruleVariable )
                    {
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:291:6: ( ruleVariable )
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:292:1: ruleVariable
                    {
                     before(grammarAccess.getWordAccess().getVariableParserRuleCall_1()); 
                    pushFollow(FollowSets000.FOLLOW_ruleVariable_in_rule__Word__Alternatives560);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:302:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:306:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:307:1: ( RULE_STRING )
                    {
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:307:1: ( RULE_STRING )
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:308:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives592); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:313:6: ( RULE_ID )
                    {
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:313:6: ( RULE_ID )
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:314:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives609); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:326:1: rule__IdentifyElements__Group__0 : rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 ;
    public final void rule__IdentifyElements__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:330:1: ( rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:331:2: rule__IdentifyElements__Group__0__Impl rule__IdentifyElements__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__0__Impl_in_rule__IdentifyElements__Group__0639);
            rule__IdentifyElements__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__1_in_rule__IdentifyElements__Group__0642);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:338:1: rule__IdentifyElements__Group__0__Impl : ( () ) ;
    public final void rule__IdentifyElements__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:342:1: ( ( () ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:343:1: ( () )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:343:1: ( () )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:344:1: ()
            {
             before(grammarAccess.getIdentifyElementsAccess().getIdentifyElementsAction_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:345:1: ()
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:347:1: 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:357:1: rule__IdentifyElements__Group__1 : rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 ;
    public final void rule__IdentifyElements__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:361:1: ( rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:362:2: rule__IdentifyElements__Group__1__Impl rule__IdentifyElements__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__1__Impl_in_rule__IdentifyElements__Group__1700);
            rule__IdentifyElements__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__2_in_rule__IdentifyElements__Group__1703);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:369:1: rule__IdentifyElements__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__IdentifyElements__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:373:1: ( ( 'metamodel' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:374:1: ( 'metamodel' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:374:1: ( 'metamodel' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:375:1: 'metamodel'
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelKeyword_1()); 
            match(input,12,FollowSets000.FOLLOW_12_in_rule__IdentifyElements__Group__1__Impl731); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:388:1: rule__IdentifyElements__Group__2 : rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 ;
    public final void rule__IdentifyElements__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:392:1: ( rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:393:2: rule__IdentifyElements__Group__2__Impl rule__IdentifyElements__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__2__Impl_in_rule__IdentifyElements__Group__2762);
            rule__IdentifyElements__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__3_in_rule__IdentifyElements__Group__2765);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:400:1: rule__IdentifyElements__Group__2__Impl : ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) ;
    public final void rule__IdentifyElements__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:404:1: ( ( ( rule__IdentifyElements__MetamodelAssignment_2 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:405:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:405:1: ( ( rule__IdentifyElements__MetamodelAssignment_2 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:406:1: ( rule__IdentifyElements__MetamodelAssignment_2 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelAssignment_2()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:407:1: ( rule__IdentifyElements__MetamodelAssignment_2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:407:2: rule__IdentifyElements__MetamodelAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__MetamodelAssignment_2_in_rule__IdentifyElements__Group__2__Impl792);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:417:1: rule__IdentifyElements__Group__3 : rule__IdentifyElements__Group__3__Impl ;
    public final void rule__IdentifyElements__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:421:1: ( rule__IdentifyElements__Group__3__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:422:2: rule__IdentifyElements__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group__3__Impl_in_rule__IdentifyElements__Group__3822);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:428:1: rule__IdentifyElements__Group__3__Impl : ( ( rule__IdentifyElements__Group_3__0 )? ) ;
    public final void rule__IdentifyElements__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:432:1: ( ( ( rule__IdentifyElements__Group_3__0 )? ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:433:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:433:1: ( ( rule__IdentifyElements__Group_3__0 )? )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:434:1: ( rule__IdentifyElements__Group_3__0 )?
            {
             before(grammarAccess.getIdentifyElementsAccess().getGroup_3()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:435:1: ( rule__IdentifyElements__Group_3__0 )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==13) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:435:2: rule__IdentifyElements__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group_3__0_in_rule__IdentifyElements__Group__3__Impl849);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:453:1: rule__IdentifyElements__Group_3__0 : rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 ;
    public final void rule__IdentifyElements__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:457:1: ( rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:458:2: rule__IdentifyElements__Group_3__0__Impl rule__IdentifyElements__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group_3__0__Impl_in_rule__IdentifyElements__Group_3__0888);
            rule__IdentifyElements__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group_3__1_in_rule__IdentifyElements__Group_3__0891);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:465:1: rule__IdentifyElements__Group_3__0__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) ;
    public final void rule__IdentifyElements__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:469:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:470:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:470:1: ( ( rule__IdentifyElements__ElementsAssignment_3_0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:471:1: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:472:1: ( rule__IdentifyElements__ElementsAssignment_3_0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:472:2: rule__IdentifyElements__ElementsAssignment_3_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__ElementsAssignment_3_0_in_rule__IdentifyElements__Group_3__0__Impl918);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:482:1: rule__IdentifyElements__Group_3__1 : rule__IdentifyElements__Group_3__1__Impl ;
    public final void rule__IdentifyElements__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:486:1: ( rule__IdentifyElements__Group_3__1__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:487:2: rule__IdentifyElements__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__Group_3__1__Impl_in_rule__IdentifyElements__Group_3__1948);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:493:1: rule__IdentifyElements__Group_3__1__Impl : ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) ;
    public final void rule__IdentifyElements__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:497:1: ( ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:498:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:498:1: ( ( rule__IdentifyElements__ElementsAssignment_3_1 )* )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:499:1: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsAssignment_3_1()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:500:1: ( rule__IdentifyElements__ElementsAssignment_3_1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==13) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:500:2: rule__IdentifyElements__ElementsAssignment_3_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__IdentifyElements__ElementsAssignment_3_1_in_rule__IdentifyElements__Group_3__1__Impl975);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:514:1: rule__Element__Group__0 : rule__Element__Group__0__Impl rule__Element__Group__1 ;
    public final void rule__Element__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:518:1: ( rule__Element__Group__0__Impl rule__Element__Group__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:519:2: rule__Element__Group__0__Impl rule__Element__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__01010);
            rule__Element__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1_in_rule__Element__Group__01013);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:526:1: rule__Element__Group__0__Impl : ( () ) ;
    public final void rule__Element__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:530:1: ( ( () ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:531:1: ( () )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:531:1: ( () )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:532:1: ()
            {
             before(grammarAccess.getElementAccess().getElementAction_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:533:1: ()
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:535:1: 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:545:1: rule__Element__Group__1 : rule__Element__Group__1__Impl rule__Element__Group__2 ;
    public final void rule__Element__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:549:1: ( rule__Element__Group__1__Impl rule__Element__Group__2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:550:2: rule__Element__Group__1__Impl rule__Element__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__11071);
            rule__Element__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2_in_rule__Element__Group__11074);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:557:1: rule__Element__Group__1__Impl : ( '>' ) ;
    public final void rule__Element__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:561:1: ( ( '>' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:562:1: ( '>' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:562:1: ( '>' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:563:1: '>'
            {
             before(grammarAccess.getElementAccess().getGreaterThanSignKeyword_1()); 
            match(input,13,FollowSets000.FOLLOW_13_in_rule__Element__Group__1__Impl1102); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:576:1: rule__Element__Group__2 : rule__Element__Group__2__Impl rule__Element__Group__3 ;
    public final void rule__Element__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:580:1: ( rule__Element__Group__2__Impl rule__Element__Group__3 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:581:2: rule__Element__Group__2__Impl rule__Element__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__21133);
            rule__Element__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3_in_rule__Element__Group__21136);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:588:1: rule__Element__Group__2__Impl : ( ( rule__Element__TypeAssignment_2 ) ) ;
    public final void rule__Element__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:592:1: ( ( ( rule__Element__TypeAssignment_2 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:593:1: ( ( rule__Element__TypeAssignment_2 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:593:1: ( ( rule__Element__TypeAssignment_2 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:594:1: ( rule__Element__TypeAssignment_2 )
            {
             before(grammarAccess.getElementAccess().getTypeAssignment_2()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:595:1: ( rule__Element__TypeAssignment_2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:595:2: rule__Element__TypeAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__TypeAssignment_2_in_rule__Element__Group__2__Impl1163);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:605:1: rule__Element__Group__3 : rule__Element__Group__3__Impl rule__Element__Group__4 ;
    public final void rule__Element__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:609:1: ( rule__Element__Group__3__Impl rule__Element__Group__4 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:610:2: rule__Element__Group__3__Impl rule__Element__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__31193);
            rule__Element__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__4_in_rule__Element__Group__31196);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:617:1: rule__Element__Group__3__Impl : ( ( rule__Element__Group_3__0 )? ) ;
    public final void rule__Element__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:621:1: ( ( ( rule__Element__Group_3__0 )? ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:622:1: ( ( rule__Element__Group_3__0 )? )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:622:1: ( ( rule__Element__Group_3__0 )? )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:623:1: ( rule__Element__Group_3__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_3()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:624:1: ( rule__Element__Group_3__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:624:2: rule__Element__Group_3__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3__Impl1223);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:634:1: rule__Element__Group__4 : rule__Element__Group__4__Impl rule__Element__Group__5 ;
    public final void rule__Element__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:638:1: ( rule__Element__Group__4__Impl rule__Element__Group__5 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:639:2: rule__Element__Group__4__Impl rule__Element__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__4__Impl_in_rule__Element__Group__41254);
            rule__Element__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__5_in_rule__Element__Group__41257);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:646:1: rule__Element__Group__4__Impl : ( ( rule__Element__Group_4__0 )? ) ;
    public final void rule__Element__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:650:1: ( ( ( rule__Element__Group_4__0 )? ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:651:1: ( ( rule__Element__Group_4__0 )? )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:651:1: ( ( rule__Element__Group_4__0 )? )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:652:1: ( rule__Element__Group_4__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_4()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:653:1: ( rule__Element__Group_4__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:653:2: rule__Element__Group_4__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_4__0_in_rule__Element__Group__4__Impl1284);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:663:1: rule__Element__Group__5 : rule__Element__Group__5__Impl rule__Element__Group__6 ;
    public final void rule__Element__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:667:1: ( rule__Element__Group__5__Impl rule__Element__Group__6 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:668:2: rule__Element__Group__5__Impl rule__Element__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__5__Impl_in_rule__Element__Group__51315);
            rule__Element__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__6_in_rule__Element__Group__51318);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:675:1: rule__Element__Group__5__Impl : ( ':' ) ;
    public final void rule__Element__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:679:1: ( ( ':' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:680:1: ( ':' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:680:1: ( ':' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:681:1: ':'
            {
             before(grammarAccess.getElementAccess().getColonKeyword_5()); 
            match(input,14,FollowSets000.FOLLOW_14_in_rule__Element__Group__5__Impl1346); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:694:1: rule__Element__Group__6 : rule__Element__Group__6__Impl ;
    public final void rule__Element__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:698:1: ( rule__Element__Group__6__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:699:2: rule__Element__Group__6__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group__6__Impl_in_rule__Element__Group__61377);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:705:1: rule__Element__Group__6__Impl : ( ( rule__Element__Group_6__0 )? ) ;
    public final void rule__Element__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:709:1: ( ( ( rule__Element__Group_6__0 )? ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:710:1: ( ( rule__Element__Group_6__0 )? )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:710:1: ( ( rule__Element__Group_6__0 )? )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:711:1: ( rule__Element__Group_6__0 )?
            {
             before(grammarAccess.getElementAccess().getGroup_6()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:712:1: ( rule__Element__Group_6__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_STRING && LA8_0<=RULE_ID)||LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:712:2: rule__Element__Group_6__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Element__Group_6__0_in_rule__Element__Group__6__Impl1404);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:736:1: rule__Element__Group_3__0 : rule__Element__Group_3__0__Impl rule__Element__Group_3__1 ;
    public final void rule__Element__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:740:1: ( rule__Element__Group_3__0__Impl rule__Element__Group_3__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:741:2: rule__Element__Group_3__0__Impl rule__Element__Group_3__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__0__Impl_in_rule__Element__Group_3__01449);
            rule__Element__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__01452);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:748:1: rule__Element__Group_3__0__Impl : ( '.' ) ;
    public final void rule__Element__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:752:1: ( ( '.' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:753:1: ( '.' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:753:1: ( '.' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:754:1: '.'
            {
             before(grammarAccess.getElementAccess().getFullStopKeyword_3_0()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Element__Group_3__0__Impl1480); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:767:1: rule__Element__Group_3__1 : rule__Element__Group_3__1__Impl ;
    public final void rule__Element__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:771:1: ( rule__Element__Group_3__1__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:772:2: rule__Element__Group_3__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__11511);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:778:1: rule__Element__Group_3__1__Impl : ( ( rule__Element__RefAssignment_3_1 ) ) ;
    public final void rule__Element__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:782:1: ( ( ( rule__Element__RefAssignment_3_1 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:783:1: ( ( rule__Element__RefAssignment_3_1 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:783:1: ( ( rule__Element__RefAssignment_3_1 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:784:1: ( rule__Element__RefAssignment_3_1 )
            {
             before(grammarAccess.getElementAccess().getRefAssignment_3_1()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:785:1: ( rule__Element__RefAssignment_3_1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:785:2: rule__Element__RefAssignment_3_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__RefAssignment_3_1_in_rule__Element__Group_3__1__Impl1538);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:799:1: rule__Element__Group_4__0 : rule__Element__Group_4__0__Impl rule__Element__Group_4__1 ;
    public final void rule__Element__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:803:1: ( rule__Element__Group_4__0__Impl rule__Element__Group_4__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:804:2: rule__Element__Group_4__0__Impl rule__Element__Group_4__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_4__0__Impl_in_rule__Element__Group_4__01572);
            rule__Element__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_4__1_in_rule__Element__Group_4__01575);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:811:1: rule__Element__Group_4__0__Impl : ( '(' ) ;
    public final void rule__Element__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:815:1: ( ( '(' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:816:1: ( '(' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:816:1: ( '(' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:817:1: '('
            {
             before(grammarAccess.getElementAccess().getLeftParenthesisKeyword_4_0()); 
            match(input,16,FollowSets000.FOLLOW_16_in_rule__Element__Group_4__0__Impl1603); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:830:1: rule__Element__Group_4__1 : rule__Element__Group_4__1__Impl rule__Element__Group_4__2 ;
    public final void rule__Element__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:834:1: ( rule__Element__Group_4__1__Impl rule__Element__Group_4__2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:835:2: rule__Element__Group_4__1__Impl rule__Element__Group_4__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_4__1__Impl_in_rule__Element__Group_4__11634);
            rule__Element__Group_4__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_4__2_in_rule__Element__Group_4__11637);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:842:1: rule__Element__Group_4__1__Impl : ( ( rule__Element__AttAssignment_4_1 ) ) ;
    public final void rule__Element__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:846:1: ( ( ( rule__Element__AttAssignment_4_1 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:847:1: ( ( rule__Element__AttAssignment_4_1 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:847:1: ( ( rule__Element__AttAssignment_4_1 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:848:1: ( rule__Element__AttAssignment_4_1 )
            {
             before(grammarAccess.getElementAccess().getAttAssignment_4_1()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:849:1: ( rule__Element__AttAssignment_4_1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:849:2: rule__Element__AttAssignment_4_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__AttAssignment_4_1_in_rule__Element__Group_4__1__Impl1664);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:859:1: rule__Element__Group_4__2 : rule__Element__Group_4__2__Impl ;
    public final void rule__Element__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:863:1: ( rule__Element__Group_4__2__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:864:2: rule__Element__Group_4__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_4__2__Impl_in_rule__Element__Group_4__21694);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:870:1: rule__Element__Group_4__2__Impl : ( ')' ) ;
    public final void rule__Element__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:874:1: ( ( ')' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:875:1: ( ')' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:875:1: ( ')' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:876:1: ')'
            {
             before(grammarAccess.getElementAccess().getRightParenthesisKeyword_4_2()); 
            match(input,17,FollowSets000.FOLLOW_17_in_rule__Element__Group_4__2__Impl1722); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:895:1: rule__Element__Group_6__0 : rule__Element__Group_6__0__Impl rule__Element__Group_6__1 ;
    public final void rule__Element__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:899:1: ( rule__Element__Group_6__0__Impl rule__Element__Group_6__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:900:2: rule__Element__Group_6__0__Impl rule__Element__Group_6__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_6__0__Impl_in_rule__Element__Group_6__01759);
            rule__Element__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_6__1_in_rule__Element__Group_6__01762);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:907:1: rule__Element__Group_6__0__Impl : ( ( rule__Element__WordsAssignment_6_0 ) ) ;
    public final void rule__Element__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:911:1: ( ( ( rule__Element__WordsAssignment_6_0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:912:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:912:1: ( ( rule__Element__WordsAssignment_6_0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:913:1: ( rule__Element__WordsAssignment_6_0 )
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:914:1: ( rule__Element__WordsAssignment_6_0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:914:2: rule__Element__WordsAssignment_6_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__WordsAssignment_6_0_in_rule__Element__Group_6__0__Impl1789);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:924:1: rule__Element__Group_6__1 : rule__Element__Group_6__1__Impl ;
    public final void rule__Element__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:928:1: ( rule__Element__Group_6__1__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:929:2: rule__Element__Group_6__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Element__Group_6__1__Impl_in_rule__Element__Group_6__11819);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:935:1: rule__Element__Group_6__1__Impl : ( ( rule__Element__WordsAssignment_6_1 )* ) ;
    public final void rule__Element__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:939:1: ( ( ( rule__Element__WordsAssignment_6_1 )* ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:940:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:940:1: ( ( rule__Element__WordsAssignment_6_1 )* )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:941:1: ( rule__Element__WordsAssignment_6_1 )*
            {
             before(grammarAccess.getElementAccess().getWordsAssignment_6_1()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:942:1: ( rule__Element__WordsAssignment_6_1 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)||LA9_0==18) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:942:2: rule__Element__WordsAssignment_6_1
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__Element__WordsAssignment_6_1_in_rule__Element__Group_6__1__Impl1846);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:956:1: rule__Attribute__Group__0 : rule__Attribute__Group__0__Impl rule__Attribute__Group__1 ;
    public final void rule__Attribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:960:1: ( rule__Attribute__Group__0__Impl rule__Attribute__Group__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:961:2: rule__Attribute__Group__0__Impl rule__Attribute__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__01881);
            rule__Attribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01884);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:968:1: rule__Attribute__Group__0__Impl : ( () ) ;
    public final void rule__Attribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:972:1: ( ( () ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:973:1: ( () )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:973:1: ( () )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:974:1: ()
            {
             before(grammarAccess.getAttributeAccess().getAttributeAction_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:975:1: ()
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:977:1: 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:987:1: rule__Attribute__Group__1 : rule__Attribute__Group__1__Impl rule__Attribute__Group__2 ;
    public final void rule__Attribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:991:1: ( rule__Attribute__Group__1__Impl rule__Attribute__Group__2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:992:2: rule__Attribute__Group__1__Impl rule__Attribute__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__11942);
            rule__Attribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11945);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:999:1: rule__Attribute__Group__1__Impl : ( ( rule__Attribute__Alternatives_1 )? ) ;
    public final void rule__Attribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1003:1: ( ( ( rule__Attribute__Alternatives_1 )? ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1004:1: ( ( rule__Attribute__Alternatives_1 )? )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1004:1: ( ( rule__Attribute__Alternatives_1 )? )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1005:1: ( rule__Attribute__Alternatives_1 )?
            {
             before(grammarAccess.getAttributeAccess().getAlternatives_1()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1006:1: ( rule__Attribute__Alternatives_1 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==11||LA10_0==19) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1006:2: rule__Attribute__Alternatives_1
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Attribute__Alternatives_1_in_rule__Attribute__Group__1__Impl1972);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1016:1: rule__Attribute__Group__2 : rule__Attribute__Group__2__Impl ;
    public final void rule__Attribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1020:1: ( rule__Attribute__Group__2__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1021:2: rule__Attribute__Group__2__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__22003);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1027:1: rule__Attribute__Group__2__Impl : ( ( rule__Attribute__AttAssignment_2 ) ) ;
    public final void rule__Attribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1031:1: ( ( ( rule__Attribute__AttAssignment_2 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1032:1: ( ( rule__Attribute__AttAssignment_2 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1032:1: ( ( rule__Attribute__AttAssignment_2 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1033:1: ( rule__Attribute__AttAssignment_2 )
            {
             before(grammarAccess.getAttributeAccess().getAttAssignment_2()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1034:1: ( rule__Attribute__AttAssignment_2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1034:2: rule__Attribute__AttAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Attribute__AttAssignment_2_in_rule__Attribute__Group__2__Impl2030);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1050:1: rule__Constant__Group__0 : rule__Constant__Group__0__Impl rule__Constant__Group__1 ;
    public final void rule__Constant__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1054:1: ( rule__Constant__Group__0__Impl rule__Constant__Group__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1055:2: rule__Constant__Group__0__Impl rule__Constant__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__02066);
            rule__Constant__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__02069);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1062:1: rule__Constant__Group__0__Impl : ( () ) ;
    public final void rule__Constant__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1066:1: ( ( () ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1067:1: ( () )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1067:1: ( () )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1068:1: ()
            {
             before(grammarAccess.getConstantAccess().getConstantAction_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1069:1: ()
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1071:1: 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1081:1: rule__Constant__Group__1 : rule__Constant__Group__1__Impl ;
    public final void rule__Constant__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1085:1: ( rule__Constant__Group__1__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1086:2: rule__Constant__Group__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__12127);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1092:1: rule__Constant__Group__1__Impl : ( ( rule__Constant__ValueAssignment_1 ) ) ;
    public final void rule__Constant__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1096:1: ( ( ( rule__Constant__ValueAssignment_1 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1097:1: ( ( rule__Constant__ValueAssignment_1 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1097:1: ( ( rule__Constant__ValueAssignment_1 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1098:1: ( rule__Constant__ValueAssignment_1 )
            {
             before(grammarAccess.getConstantAccess().getValueAssignment_1()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1099:1: ( rule__Constant__ValueAssignment_1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1099:2: rule__Constant__ValueAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Constant__ValueAssignment_1_in_rule__Constant__Group__1__Impl2154);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1113:1: rule__Variable__Group__0 : rule__Variable__Group__0__Impl rule__Variable__Group__1 ;
    public final void rule__Variable__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1117:1: ( rule__Variable__Group__0__Impl rule__Variable__Group__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1118:2: rule__Variable__Group__0__Impl rule__Variable__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02188);
            rule__Variable__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02191);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1125:1: rule__Variable__Group__0__Impl : ( () ) ;
    public final void rule__Variable__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1129:1: ( ( () ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1130:1: ( () )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1130:1: ( () )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1131:1: ()
            {
             before(grammarAccess.getVariableAccess().getVariableAction_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1132:1: ()
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1134:1: 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1144:1: rule__Variable__Group__1 : rule__Variable__Group__1__Impl rule__Variable__Group__2 ;
    public final void rule__Variable__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1148:1: ( rule__Variable__Group__1__Impl rule__Variable__Group__2 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1149:2: rule__Variable__Group__1__Impl rule__Variable__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12249);
            rule__Variable__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__12252);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1156:1: rule__Variable__Group__1__Impl : ( '%' ) ;
    public final void rule__Variable__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1160:1: ( ( '%' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1161:1: ( '%' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1161:1: ( '%' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1162:1: '%'
            {
             before(grammarAccess.getVariableAccess().getPercentSignKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__Variable__Group__1__Impl2280); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1175:1: rule__Variable__Group__2 : rule__Variable__Group__2__Impl rule__Variable__Group__3 ;
    public final void rule__Variable__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1179:1: ( rule__Variable__Group__2__Impl rule__Variable__Group__3 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1180:2: rule__Variable__Group__2__Impl rule__Variable__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__22311);
            rule__Variable__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__22314);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1187:1: rule__Variable__Group__2__Impl : ( ( rule__Variable__Group_2__0 )? ) ;
    public final void rule__Variable__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1191:1: ( ( ( rule__Variable__Group_2__0 )? ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1192:1: ( ( rule__Variable__Group_2__0 )? )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1192:1: ( ( rule__Variable__Group_2__0 )? )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1193:1: ( rule__Variable__Group_2__0 )?
            {
             before(grammarAccess.getVariableAccess().getGroup_2()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1194:1: ( rule__Variable__Group_2__0 )?
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
                    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1194:2: rule__Variable__Group_2__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Variable__Group_2__0_in_rule__Variable__Group__2__Impl2341);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1204:1: rule__Variable__Group__3 : rule__Variable__Group__3__Impl ;
    public final void rule__Variable__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1208:1: ( rule__Variable__Group__3__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1209:2: rule__Variable__Group__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group__3__Impl_in_rule__Variable__Group__32372);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1215:1: rule__Variable__Group__3__Impl : ( ( rule__Variable__IdAssignment_3 ) ) ;
    public final void rule__Variable__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1219:1: ( ( ( rule__Variable__IdAssignment_3 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1220:1: ( ( rule__Variable__IdAssignment_3 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1220:1: ( ( rule__Variable__IdAssignment_3 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1221:1: ( rule__Variable__IdAssignment_3 )
            {
             before(grammarAccess.getVariableAccess().getIdAssignment_3()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1222:1: ( rule__Variable__IdAssignment_3 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1222:2: rule__Variable__IdAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__IdAssignment_3_in_rule__Variable__Group__3__Impl2399);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1240:1: rule__Variable__Group_2__0 : rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 ;
    public final void rule__Variable__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1244:1: ( rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1245:2: rule__Variable__Group_2__0__Impl rule__Variable__Group_2__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group_2__0__Impl_in_rule__Variable__Group_2__02437);
            rule__Variable__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group_2__1_in_rule__Variable__Group_2__02440);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1252:1: rule__Variable__Group_2__0__Impl : ( ( rule__Variable__RefAssignment_2_0 ) ) ;
    public final void rule__Variable__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1256:1: ( ( ( rule__Variable__RefAssignment_2_0 ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1257:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1257:1: ( ( rule__Variable__RefAssignment_2_0 ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1258:1: ( rule__Variable__RefAssignment_2_0 )
            {
             before(grammarAccess.getVariableAccess().getRefAssignment_2_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1259:1: ( rule__Variable__RefAssignment_2_0 )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1259:2: rule__Variable__RefAssignment_2_0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__RefAssignment_2_0_in_rule__Variable__Group_2__0__Impl2467);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1269:1: rule__Variable__Group_2__1 : rule__Variable__Group_2__1__Impl ;
    public final void rule__Variable__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1273:1: ( rule__Variable__Group_2__1__Impl )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1274:2: rule__Variable__Group_2__1__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Variable__Group_2__1__Impl_in_rule__Variable__Group_2__12497);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1280:1: rule__Variable__Group_2__1__Impl : ( '.' ) ;
    public final void rule__Variable__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1284:1: ( ( '.' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1285:1: ( '.' )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1285:1: ( '.' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1286:1: '.'
            {
             before(grammarAccess.getVariableAccess().getFullStopKeyword_2_1()); 
            match(input,15,FollowSets000.FOLLOW_15_in_rule__Variable__Group_2__1__Impl2525); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1304:1: rule__IdentifyElements__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__IdentifyElements__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1308:1: ( ( ruleEString ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1309:1: ( ruleEString )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1309:1: ( ruleEString )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1310:1: ruleEString
            {
             before(grammarAccess.getIdentifyElementsAccess().getMetamodelEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__IdentifyElements__MetamodelAssignment_22565);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1319:1: rule__IdentifyElements__ElementsAssignment_3_0 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1323:1: ( ( ruleElement ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1324:1: ( ruleElement )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1324:1: ( ruleElement )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1325:1: ruleElement
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__IdentifyElements__ElementsAssignment_3_02596);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1334:1: rule__IdentifyElements__ElementsAssignment_3_1 : ( ruleElement ) ;
    public final void rule__IdentifyElements__ElementsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1338:1: ( ( ruleElement ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1339:1: ( ruleElement )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1339:1: ( ruleElement )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1340:1: ruleElement
            {
             before(grammarAccess.getIdentifyElementsAccess().getElementsElementParserRuleCall_3_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleElement_in_rule__IdentifyElements__ElementsAssignment_3_12627);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1349:1: rule__Element__TypeAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__Element__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1353:1: ( ( ( ruleEString ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1354:1: ( ( ruleEString ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1354:1: ( ( ruleEString ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1355:1: ( ruleEString )
            {
             before(grammarAccess.getElementAccess().getTypeEClassCrossReference_2_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1356:1: ( ruleEString )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1357:1: ruleEString
            {
             before(grammarAccess.getElementAccess().getTypeEClassEStringParserRuleCall_2_0_1()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Element__TypeAssignment_22662);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1368:1: rule__Element__RefAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Element__RefAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1372:1: ( ( ( RULE_ID ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1373:1: ( ( RULE_ID ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1373:1: ( ( RULE_ID ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1374:1: ( RULE_ID )
            {
             before(grammarAccess.getElementAccess().getRefEReferenceCrossReference_3_1_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1375:1: ( RULE_ID )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1376:1: RULE_ID
            {
             before(grammarAccess.getElementAccess().getRefEReferenceIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Element__RefAssignment_3_12701); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1387:1: rule__Element__AttAssignment_4_1 : ( ruleAttribute ) ;
    public final void rule__Element__AttAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1391:1: ( ( ruleAttribute ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1392:1: ( ruleAttribute )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1392:1: ( ruleAttribute )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1393:1: ruleAttribute
            {
             before(grammarAccess.getElementAccess().getAttAttributeParserRuleCall_4_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttribute_in_rule__Element__AttAssignment_4_12736);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1402:1: rule__Element__WordsAssignment_6_0 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1406:1: ( ( ruleWord ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1407:1: ( ruleWord )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1407:1: ( ruleWord )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1408:1: ruleWord
            {
             before(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_0_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_rule__Element__WordsAssignment_6_02767);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1417:1: rule__Element__WordsAssignment_6_1 : ( ruleWord ) ;
    public final void rule__Element__WordsAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1421:1: ( ( ruleWord ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1422:1: ( ruleWord )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1422:1: ( ruleWord )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1423:1: ruleWord
            {
             before(grammarAccess.getElementAccess().getWordsWordParserRuleCall_6_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleWord_in_rule__Element__WordsAssignment_6_12798);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1432:1: rule__Attribute__NegationAssignment_1_0 : ( ( 'yes' ) ) ;
    public final void rule__Attribute__NegationAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1436:1: ( ( ( 'yes' ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1437:1: ( ( 'yes' ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1437:1: ( ( 'yes' ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1438:1: ( 'yes' )
            {
             before(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1439:1: ( 'yes' )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1440:1: 'yes'
            {
             before(grammarAccess.getAttributeAccess().getNegationYesKeyword_1_0_0()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Attribute__NegationAssignment_1_02834); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1455:1: rule__Attribute__AttAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__Attribute__AttAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1459:1: ( ( ( RULE_ID ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1460:1: ( ( RULE_ID ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1460:1: ( ( RULE_ID ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1461:1: ( RULE_ID )
            {
             before(grammarAccess.getAttributeAccess().getAttEAttributeCrossReference_2_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1462:1: ( RULE_ID )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1463:1: RULE_ID
            {
             before(grammarAccess.getAttributeAccess().getAttEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Attribute__AttAssignment_22877); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1474:1: rule__Constant__ValueAssignment_1 : ( ruleEString ) ;
    public final void rule__Constant__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1478:1: ( ( ruleEString ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1479:1: ( ruleEString )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1479:1: ( ruleEString )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1480:1: ruleEString
            {
             before(grammarAccess.getConstantAccess().getValueEStringParserRuleCall_1_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__Constant__ValueAssignment_12912);
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1489:1: rule__Variable__RefAssignment_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__RefAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1493:1: ( ( ( RULE_ID ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1494:1: ( ( RULE_ID ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1494:1: ( ( RULE_ID ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1495:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getRefEReferenceCrossReference_2_0_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1496:1: ( RULE_ID )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1497:1: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getRefEReferenceIDTerminalRuleCall_2_0_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Variable__RefAssignment_2_02947); 
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
    // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1508:1: rule__Variable__IdAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Variable__IdAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1512:1: ( ( ( RULE_ID ) ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1513:1: ( ( RULE_ID ) )
            {
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1513:1: ( ( RULE_ID ) )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1514:1: ( RULE_ID )
            {
             before(grammarAccess.getVariableAccess().getIdEAttributeCrossReference_3_0()); 
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1515:1: ( RULE_ID )
            // ../wodeledu.dsls.modeltext.ui/src-gen/wodeledu/dsls/ui/contentassist/antlr/internal/InternalModelText.g:1516:1: RULE_ID
            {
             before(grammarAccess.getVariableAccess().getIdEAttributeIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Variable__IdAssignment_32986); 
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


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleIdentifyElements_in_entryRuleIdentifyElements61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIdentifyElements68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__0_in_ruleIdentifyElements94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_entryRuleElement121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleElement128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__0_in_ruleElement154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_entryRuleAttribute181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttribute188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0_in_ruleAttribute214 = new BitSet(new long[]{0x0000000000000002L});
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
        public static final BitSet FOLLOW_rule__Attribute__NegationAssignment_1_0_in_rule__Attribute__Alternatives_1490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_rule__Attribute__Alternatives_1509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstant_in_rule__Word__Alternatives543 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVariable_in_rule__Word__Alternatives560 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__0__Impl_in_rule__IdentifyElements__Group__0639 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__1_in_rule__IdentifyElements__Group__0642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__1__Impl_in_rule__IdentifyElements__Group__1700 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__2_in_rule__IdentifyElements__Group__1703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__IdentifyElements__Group__1__Impl731 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__2__Impl_in_rule__IdentifyElements__Group__2762 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__3_in_rule__IdentifyElements__Group__2765 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__MetamodelAssignment_2_in_rule__IdentifyElements__Group__2__Impl792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group__3__Impl_in_rule__IdentifyElements__Group__3822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group_3__0_in_rule__IdentifyElements__Group__3__Impl849 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group_3__0__Impl_in_rule__IdentifyElements__Group_3__0888 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group_3__1_in_rule__IdentifyElements__Group_3__0891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__ElementsAssignment_3_0_in_rule__IdentifyElements__Group_3__0__Impl918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__Group_3__1__Impl_in_rule__IdentifyElements__Group_3__1948 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__IdentifyElements__ElementsAssignment_3_1_in_rule__IdentifyElements__Group_3__1__Impl975 = new BitSet(new long[]{0x0000000000002002L});
        public static final BitSet FOLLOW_rule__Element__Group__0__Impl_in_rule__Element__Group__01010 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_rule__Element__Group__1_in_rule__Element__Group__01013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__1__Impl_in_rule__Element__Group__11071 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Element__Group__2_in_rule__Element__Group__11074 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Element__Group__1__Impl1102 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__2__Impl_in_rule__Element__Group__21133 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Element__Group__3_in_rule__Element__Group__21136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__TypeAssignment_2_in_rule__Element__Group__2__Impl1163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__3__Impl_in_rule__Element__Group__31193 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Element__Group__4_in_rule__Element__Group__31196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0_in_rule__Element__Group__3__Impl1223 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__4__Impl_in_rule__Element__Group__41254 = new BitSet(new long[]{0x000000000001C000L});
        public static final BitSet FOLLOW_rule__Element__Group__5_in_rule__Element__Group__41257 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_4__0_in_rule__Element__Group__4__Impl1284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__5__Impl_in_rule__Element__Group__51315 = new BitSet(new long[]{0x0000000000040030L});
        public static final BitSet FOLLOW_rule__Element__Group__6_in_rule__Element__Group__51318 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__Element__Group__5__Impl1346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group__6__Impl_in_rule__Element__Group__61377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_6__0_in_rule__Element__Group__6__Impl1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__0__Impl_in_rule__Element__Group_3__01449 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1_in_rule__Element__Group_3__01452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Element__Group_3__0__Impl1480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_3__1__Impl_in_rule__Element__Group_3__11511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__RefAssignment_3_1_in_rule__Element__Group_3__1__Impl1538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_4__0__Impl_in_rule__Element__Group_4__01572 = new BitSet(new long[]{0x0000000000080820L});
        public static final BitSet FOLLOW_rule__Element__Group_4__1_in_rule__Element__Group_4__01575 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__Element__Group_4__0__Impl1603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_4__1__Impl_in_rule__Element__Group_4__11634 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_rule__Element__Group_4__2_in_rule__Element__Group_4__11637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__AttAssignment_4_1_in_rule__Element__Group_4__1__Impl1664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_4__2__Impl_in_rule__Element__Group_4__21694 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__Element__Group_4__2__Impl1722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_6__0__Impl_in_rule__Element__Group_6__01759 = new BitSet(new long[]{0x0000000000040030L});
        public static final BitSet FOLLOW_rule__Element__Group_6__1_in_rule__Element__Group_6__01762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__WordsAssignment_6_0_in_rule__Element__Group_6__0__Impl1789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__Group_6__1__Impl_in_rule__Element__Group_6__11819 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Element__WordsAssignment_6_1_in_rule__Element__Group_6__1__Impl1846 = new BitSet(new long[]{0x0000000000040032L});
        public static final BitSet FOLLOW_rule__Attribute__Group__0__Impl_in_rule__Attribute__Group__01881 = new BitSet(new long[]{0x0000000000080820L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1_in_rule__Attribute__Group__01884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__1__Impl_in_rule__Attribute__Group__11942 = new BitSet(new long[]{0x0000000000080820L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2_in_rule__Attribute__Group__11945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Alternatives_1_in_rule__Attribute__Group__1__Impl1972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__Group__2__Impl_in_rule__Attribute__Group__22003 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Attribute__AttAssignment_2_in_rule__Attribute__Group__2__Impl2030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Constant__Group__0__Impl_in_rule__Constant__Group__02066 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__Constant__Group__1_in_rule__Constant__Group__02069 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Constant__Group__1__Impl_in_rule__Constant__Group__12127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Constant__ValueAssignment_1_in_rule__Constant__Group__1__Impl2154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group__0__Impl_in_rule__Variable__Group__02188 = new BitSet(new long[]{0x0000000000040030L});
        public static final BitSet FOLLOW_rule__Variable__Group__1_in_rule__Variable__Group__02191 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group__1__Impl_in_rule__Variable__Group__12249 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Variable__Group__2_in_rule__Variable__Group__12252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__Variable__Group__1__Impl2280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group__2__Impl_in_rule__Variable__Group__22311 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Variable__Group__3_in_rule__Variable__Group__22314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group_2__0_in_rule__Variable__Group__2__Impl2341 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group__3__Impl_in_rule__Variable__Group__32372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__IdAssignment_3_in_rule__Variable__Group__3__Impl2399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group_2__0__Impl_in_rule__Variable__Group_2__02437 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_rule__Variable__Group_2__1_in_rule__Variable__Group_2__02440 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__RefAssignment_2_0_in_rule__Variable__Group_2__0__Impl2467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Variable__Group_2__1__Impl_in_rule__Variable__Group_2__12497 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__Variable__Group_2__1__Impl2525 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__IdentifyElements__MetamodelAssignment_22565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__IdentifyElements__ElementsAssignment_3_02596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleElement_in_rule__IdentifyElements__ElementsAssignment_3_12627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Element__TypeAssignment_22662 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Element__RefAssignment_3_12701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttribute_in_rule__Element__AttAssignment_4_12736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_rule__Element__WordsAssignment_6_02767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleWord_in_rule__Element__WordsAssignment_6_12798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Attribute__NegationAssignment_1_02834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Attribute__AttAssignment_22877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__Constant__ValueAssignment_12912 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Variable__RefAssignment_2_02947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Variable__IdAssignment_32986 = new BitSet(new long[]{0x0000000000000002L});
    }


}