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
import wodeledu.dsls.services.ModelDrawGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalModelDrawParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'diagram'", "'gray95'", "'node'", "'markednode'", "'circle'", "'doublecircle'", "'record'", "'load'", "'logic'", "'italic'", "'underline'", "'none'", "'triangle'", "'diamond'", "'odiamond'", "'open'", "'empty'", "'metamodel'", "':'", "'{'", "'}'", "'('", "')'", "','", "'->'", "'='", "'compartments'", "'shape'", "'color'", "'style'", "'=='", "'edge'", "'label'", "'.'", "'src_decoration'", "'src_label'", "'tar_decoration'", "'tar_label'", "'text'", "'['", "']'", "'not'", "'null'"
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
    public static final int T__53=53;
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


        public InternalModelDrawParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalModelDrawParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalModelDrawParser.tokenNames; }
    public String getGrammarFileName() { return "InternalModelDraw.g"; }


    	private ModelDrawGrammarAccess grammarAccess;

    	public void setGrammarAccess(ModelDrawGrammarAccess grammarAccess) {
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



    // $ANTLR start "entryRuleMutatorDraw"
    // InternalModelDraw.g:53:1: entryRuleMutatorDraw : ruleMutatorDraw EOF ;
    public final void entryRuleMutatorDraw() throws RecognitionException {
        try {
            // InternalModelDraw.g:54:1: ( ruleMutatorDraw EOF )
            // InternalModelDraw.g:55:1: ruleMutatorDraw EOF
            {
             before(grammarAccess.getMutatorDrawRule()); 
            pushFollow(FOLLOW_1);
            ruleMutatorDraw();

            state._fsp--;

             after(grammarAccess.getMutatorDrawRule()); 
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
    // $ANTLR end "entryRuleMutatorDraw"


    // $ANTLR start "ruleMutatorDraw"
    // InternalModelDraw.g:62:1: ruleMutatorDraw : ( ( rule__MutatorDraw__Group__0 ) ) ;
    public final void ruleMutatorDraw() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:66:2: ( ( ( rule__MutatorDraw__Group__0 ) ) )
            // InternalModelDraw.g:67:2: ( ( rule__MutatorDraw__Group__0 ) )
            {
            // InternalModelDraw.g:67:2: ( ( rule__MutatorDraw__Group__0 ) )
            // InternalModelDraw.g:68:3: ( rule__MutatorDraw__Group__0 )
            {
             before(grammarAccess.getMutatorDrawAccess().getGroup()); 
            // InternalModelDraw.g:69:3: ( rule__MutatorDraw__Group__0 )
            // InternalModelDraw.g:69:4: rule__MutatorDraw__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMutatorDrawAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMutatorDraw"


    // $ANTLR start "entryRuleEString"
    // InternalModelDraw.g:78:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalModelDraw.g:79:1: ( ruleEString EOF )
            // InternalModelDraw.g:80:1: ruleEString EOF
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
    // InternalModelDraw.g:87:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:91:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalModelDraw.g:92:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalModelDraw.g:92:2: ( ( rule__EString__Alternatives ) )
            // InternalModelDraw.g:93:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalModelDraw.g:94:3: ( rule__EString__Alternatives )
            // InternalModelDraw.g:94:4: rule__EString__Alternatives
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


    // $ANTLR start "entryRuleNode"
    // InternalModelDraw.g:103:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalModelDraw.g:104:1: ( ruleNode EOF )
            // InternalModelDraw.g:105:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FOLLOW_1);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
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
    // $ANTLR end "entryRuleNode"


    // $ANTLR start "ruleNode"
    // InternalModelDraw.g:112:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:116:2: ( ( ( rule__Node__Group__0 ) ) )
            // InternalModelDraw.g:117:2: ( ( rule__Node__Group__0 ) )
            {
            // InternalModelDraw.g:117:2: ( ( rule__Node__Group__0 ) )
            // InternalModelDraw.g:118:3: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // InternalModelDraw.g:119:3: ( rule__Node__Group__0 )
            // InternalModelDraw.g:119:4: rule__Node__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNode"


    // $ANTLR start "entryRuleValuedFeature"
    // InternalModelDraw.g:128:1: entryRuleValuedFeature : ruleValuedFeature EOF ;
    public final void entryRuleValuedFeature() throws RecognitionException {
        try {
            // InternalModelDraw.g:129:1: ( ruleValuedFeature EOF )
            // InternalModelDraw.g:130:1: ruleValuedFeature EOF
            {
             before(grammarAccess.getValuedFeatureRule()); 
            pushFollow(FOLLOW_1);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getValuedFeatureRule()); 
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
    // $ANTLR end "entryRuleValuedFeature"


    // $ANTLR start "ruleValuedFeature"
    // InternalModelDraw.g:137:1: ruleValuedFeature : ( ( rule__ValuedFeature__Group__0 ) ) ;
    public final void ruleValuedFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:141:2: ( ( ( rule__ValuedFeature__Group__0 ) ) )
            // InternalModelDraw.g:142:2: ( ( rule__ValuedFeature__Group__0 ) )
            {
            // InternalModelDraw.g:142:2: ( ( rule__ValuedFeature__Group__0 ) )
            // InternalModelDraw.g:143:3: ( rule__ValuedFeature__Group__0 )
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup()); 
            // InternalModelDraw.g:144:3: ( rule__ValuedFeature__Group__0 )
            // InternalModelDraw.g:144:4: rule__ValuedFeature__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValuedFeature"


    // $ANTLR start "entryRuleRelation"
    // InternalModelDraw.g:153:1: entryRuleRelation : ruleRelation EOF ;
    public final void entryRuleRelation() throws RecognitionException {
        try {
            // InternalModelDraw.g:154:1: ( ruleRelation EOF )
            // InternalModelDraw.g:155:1: ruleRelation EOF
            {
             before(grammarAccess.getRelationRule()); 
            pushFollow(FOLLOW_1);
            ruleRelation();

            state._fsp--;

             after(grammarAccess.getRelationRule()); 
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
    // $ANTLR end "entryRuleRelation"


    // $ANTLR start "ruleRelation"
    // InternalModelDraw.g:162:1: ruleRelation : ( ( rule__Relation__Alternatives ) ) ;
    public final void ruleRelation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:166:2: ( ( ( rule__Relation__Alternatives ) ) )
            // InternalModelDraw.g:167:2: ( ( rule__Relation__Alternatives ) )
            {
            // InternalModelDraw.g:167:2: ( ( rule__Relation__Alternatives ) )
            // InternalModelDraw.g:168:3: ( rule__Relation__Alternatives )
            {
             before(grammarAccess.getRelationAccess().getAlternatives()); 
            // InternalModelDraw.g:169:3: ( rule__Relation__Alternatives )
            // InternalModelDraw.g:169:4: rule__Relation__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Relation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRelationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRelation"


    // $ANTLR start "entryRuleEdge"
    // InternalModelDraw.g:178:1: entryRuleEdge : ruleEdge EOF ;
    public final void entryRuleEdge() throws RecognitionException {
        try {
            // InternalModelDraw.g:179:1: ( ruleEdge EOF )
            // InternalModelDraw.g:180:1: ruleEdge EOF
            {
             before(grammarAccess.getEdgeRule()); 
            pushFollow(FOLLOW_1);
            ruleEdge();

            state._fsp--;

             after(grammarAccess.getEdgeRule()); 
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
    // $ANTLR end "entryRuleEdge"


    // $ANTLR start "ruleEdge"
    // InternalModelDraw.g:187:1: ruleEdge : ( ( rule__Edge__Group__0 ) ) ;
    public final void ruleEdge() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:191:2: ( ( ( rule__Edge__Group__0 ) ) )
            // InternalModelDraw.g:192:2: ( ( rule__Edge__Group__0 ) )
            {
            // InternalModelDraw.g:192:2: ( ( rule__Edge__Group__0 ) )
            // InternalModelDraw.g:193:3: ( rule__Edge__Group__0 )
            {
             before(grammarAccess.getEdgeAccess().getGroup()); 
            // InternalModelDraw.g:194:3: ( rule__Edge__Group__0 )
            // InternalModelDraw.g:194:4: rule__Edge__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEdge"


    // $ANTLR start "entryRuleLevel"
    // InternalModelDraw.g:203:1: entryRuleLevel : ruleLevel EOF ;
    public final void entryRuleLevel() throws RecognitionException {
        try {
            // InternalModelDraw.g:204:1: ( ruleLevel EOF )
            // InternalModelDraw.g:205:1: ruleLevel EOF
            {
             before(grammarAccess.getLevelRule()); 
            pushFollow(FOLLOW_1);
            ruleLevel();

            state._fsp--;

             after(grammarAccess.getLevelRule()); 
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
    // $ANTLR end "entryRuleLevel"


    // $ANTLR start "ruleLevel"
    // InternalModelDraw.g:212:1: ruleLevel : ( ( rule__Level__Group__0 ) ) ;
    public final void ruleLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:216:2: ( ( ( rule__Level__Group__0 ) ) )
            // InternalModelDraw.g:217:2: ( ( rule__Level__Group__0 ) )
            {
            // InternalModelDraw.g:217:2: ( ( rule__Level__Group__0 ) )
            // InternalModelDraw.g:218:3: ( rule__Level__Group__0 )
            {
             before(grammarAccess.getLevelAccess().getGroup()); 
            // InternalModelDraw.g:219:3: ( rule__Level__Group__0 )
            // InternalModelDraw.g:219:4: rule__Level__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleLevel"


    // $ANTLR start "entryRuleContent"
    // InternalModelDraw.g:228:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // InternalModelDraw.g:229:1: ( ruleContent EOF )
            // InternalModelDraw.g:230:1: ruleContent EOF
            {
             before(grammarAccess.getContentRule()); 
            pushFollow(FOLLOW_1);
            ruleContent();

            state._fsp--;

             after(grammarAccess.getContentRule()); 
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
    // $ANTLR end "entryRuleContent"


    // $ANTLR start "ruleContent"
    // InternalModelDraw.g:237:1: ruleContent : ( ( rule__Content__Group__0 ) ) ;
    public final void ruleContent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:241:2: ( ( ( rule__Content__Group__0 ) ) )
            // InternalModelDraw.g:242:2: ( ( rule__Content__Group__0 ) )
            {
            // InternalModelDraw.g:242:2: ( ( rule__Content__Group__0 ) )
            // InternalModelDraw.g:243:3: ( rule__Content__Group__0 )
            {
             before(grammarAccess.getContentAccess().getGroup()); 
            // InternalModelDraw.g:244:3: ( rule__Content__Group__0 )
            // InternalModelDraw.g:244:4: rule__Content__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Content__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getContentAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleContent"


    // $ANTLR start "entryRuleNodeEnumerator"
    // InternalModelDraw.g:253:1: entryRuleNodeEnumerator : ruleNodeEnumerator EOF ;
    public final void entryRuleNodeEnumerator() throws RecognitionException {
        try {
            // InternalModelDraw.g:254:1: ( ruleNodeEnumerator EOF )
            // InternalModelDraw.g:255:1: ruleNodeEnumerator EOF
            {
             before(grammarAccess.getNodeEnumeratorRule()); 
            pushFollow(FOLLOW_1);
            ruleNodeEnumerator();

            state._fsp--;

             after(grammarAccess.getNodeEnumeratorRule()); 
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
    // $ANTLR end "entryRuleNodeEnumerator"


    // $ANTLR start "ruleNodeEnumerator"
    // InternalModelDraw.g:262:1: ruleNodeEnumerator : ( ( rule__NodeEnumerator__Group__0 ) ) ;
    public final void ruleNodeEnumerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:266:2: ( ( ( rule__NodeEnumerator__Group__0 ) ) )
            // InternalModelDraw.g:267:2: ( ( rule__NodeEnumerator__Group__0 ) )
            {
            // InternalModelDraw.g:267:2: ( ( rule__NodeEnumerator__Group__0 ) )
            // InternalModelDraw.g:268:3: ( rule__NodeEnumerator__Group__0 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getGroup()); 
            // InternalModelDraw.g:269:3: ( rule__NodeEnumerator__Group__0 )
            // InternalModelDraw.g:269:4: rule__NodeEnumerator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNodeEnumeratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeEnumerator"


    // $ANTLR start "entryRuleEnumerator"
    // InternalModelDraw.g:278:1: entryRuleEnumerator : ruleEnumerator EOF ;
    public final void entryRuleEnumerator() throws RecognitionException {
        try {
            // InternalModelDraw.g:279:1: ( ruleEnumerator EOF )
            // InternalModelDraw.g:280:1: ruleEnumerator EOF
            {
             before(grammarAccess.getEnumeratorRule()); 
            pushFollow(FOLLOW_1);
            ruleEnumerator();

            state._fsp--;

             after(grammarAccess.getEnumeratorRule()); 
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
    // $ANTLR end "entryRuleEnumerator"


    // $ANTLR start "ruleEnumerator"
    // InternalModelDraw.g:287:1: ruleEnumerator : ( ( rule__Enumerator__Group__0 ) ) ;
    public final void ruleEnumerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:291:2: ( ( ( rule__Enumerator__Group__0 ) ) )
            // InternalModelDraw.g:292:2: ( ( rule__Enumerator__Group__0 ) )
            {
            // InternalModelDraw.g:292:2: ( ( rule__Enumerator__Group__0 ) )
            // InternalModelDraw.g:293:3: ( rule__Enumerator__Group__0 )
            {
             before(grammarAccess.getEnumeratorAccess().getGroup()); 
            // InternalModelDraw.g:294:3: ( rule__Enumerator__Group__0 )
            // InternalModelDraw.g:294:4: rule__Enumerator__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Enumerator__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEnumeratorAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumerator"


    // $ANTLR start "entryRuleInformation"
    // InternalModelDraw.g:303:1: entryRuleInformation : ruleInformation EOF ;
    public final void entryRuleInformation() throws RecognitionException {
        try {
            // InternalModelDraw.g:304:1: ( ruleInformation EOF )
            // InternalModelDraw.g:305:1: ruleInformation EOF
            {
             before(grammarAccess.getInformationRule()); 
            pushFollow(FOLLOW_1);
            ruleInformation();

            state._fsp--;

             after(grammarAccess.getInformationRule()); 
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
    // $ANTLR end "entryRuleInformation"


    // $ANTLR start "ruleInformation"
    // InternalModelDraw.g:312:1: ruleInformation : ( ( rule__Information__Group__0 ) ) ;
    public final void ruleInformation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:316:2: ( ( ( rule__Information__Group__0 ) ) )
            // InternalModelDraw.g:317:2: ( ( rule__Information__Group__0 ) )
            {
            // InternalModelDraw.g:317:2: ( ( rule__Information__Group__0 ) )
            // InternalModelDraw.g:318:3: ( rule__Information__Group__0 )
            {
             before(grammarAccess.getInformationAccess().getGroup()); 
            // InternalModelDraw.g:319:3: ( rule__Information__Group__0 )
            // InternalModelDraw.g:319:4: rule__Information__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Information__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getInformationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInformation"


    // $ANTLR start "ruleDrawType"
    // InternalModelDraw.g:328:1: ruleDrawType : ( ( 'diagram' ) ) ;
    public final void ruleDrawType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:332:1: ( ( ( 'diagram' ) ) )
            // InternalModelDraw.g:333:2: ( ( 'diagram' ) )
            {
            // InternalModelDraw.g:333:2: ( ( 'diagram' ) )
            // InternalModelDraw.g:334:3: ( 'diagram' )
            {
             before(grammarAccess.getDrawTypeAccess().getDiagramEnumLiteralDeclaration()); 
            // InternalModelDraw.g:335:3: ( 'diagram' )
            // InternalModelDraw.g:335:4: 'diagram'
            {
            match(input,11,FOLLOW_2); 

            }

             after(grammarAccess.getDrawTypeAccess().getDiagramEnumLiteralDeclaration()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDrawType"


    // $ANTLR start "ruleNodeType"
    // InternalModelDraw.g:344:1: ruleNodeType : ( ( rule__NodeType__Alternatives ) ) ;
    public final void ruleNodeType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:348:1: ( ( ( rule__NodeType__Alternatives ) ) )
            // InternalModelDraw.g:349:2: ( ( rule__NodeType__Alternatives ) )
            {
            // InternalModelDraw.g:349:2: ( ( rule__NodeType__Alternatives ) )
            // InternalModelDraw.g:350:3: ( rule__NodeType__Alternatives )
            {
             before(grammarAccess.getNodeTypeAccess().getAlternatives()); 
            // InternalModelDraw.g:351:3: ( rule__NodeType__Alternatives )
            // InternalModelDraw.g:351:4: rule__NodeType__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NodeType__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNodeTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeType"


    // $ANTLR start "ruleNodeShape"
    // InternalModelDraw.g:360:1: ruleNodeShape : ( ( rule__NodeShape__Alternatives ) ) ;
    public final void ruleNodeShape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:364:1: ( ( ( rule__NodeShape__Alternatives ) ) )
            // InternalModelDraw.g:365:2: ( ( rule__NodeShape__Alternatives ) )
            {
            // InternalModelDraw.g:365:2: ( ( rule__NodeShape__Alternatives ) )
            // InternalModelDraw.g:366:3: ( rule__NodeShape__Alternatives )
            {
             before(grammarAccess.getNodeShapeAccess().getAlternatives()); 
            // InternalModelDraw.g:367:3: ( rule__NodeShape__Alternatives )
            // InternalModelDraw.g:367:4: rule__NodeShape__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NodeShape__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNodeShapeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeShape"


    // $ANTLR start "ruleNodeColor"
    // InternalModelDraw.g:376:1: ruleNodeColor : ( ( 'gray95' ) ) ;
    public final void ruleNodeColor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:380:1: ( ( ( 'gray95' ) ) )
            // InternalModelDraw.g:381:2: ( ( 'gray95' ) )
            {
            // InternalModelDraw.g:381:2: ( ( 'gray95' ) )
            // InternalModelDraw.g:382:3: ( 'gray95' )
            {
             before(grammarAccess.getNodeColorAccess().getGray95EnumLiteralDeclaration()); 
            // InternalModelDraw.g:383:3: ( 'gray95' )
            // InternalModelDraw.g:383:4: 'gray95'
            {
            match(input,12,FOLLOW_2); 

            }

             after(grammarAccess.getNodeColorAccess().getGray95EnumLiteralDeclaration()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeColor"


    // $ANTLR start "ruleNodeStyle"
    // InternalModelDraw.g:392:1: ruleNodeStyle : ( ( rule__NodeStyle__Alternatives ) ) ;
    public final void ruleNodeStyle() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:396:1: ( ( ( rule__NodeStyle__Alternatives ) ) )
            // InternalModelDraw.g:397:2: ( ( rule__NodeStyle__Alternatives ) )
            {
            // InternalModelDraw.g:397:2: ( ( rule__NodeStyle__Alternatives ) )
            // InternalModelDraw.g:398:3: ( rule__NodeStyle__Alternatives )
            {
             before(grammarAccess.getNodeStyleAccess().getAlternatives()); 
            // InternalModelDraw.g:399:3: ( rule__NodeStyle__Alternatives )
            // InternalModelDraw.g:399:4: rule__NodeStyle__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__NodeStyle__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNodeStyleAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNodeStyle"


    // $ANTLR start "ruleDecoration"
    // InternalModelDraw.g:408:1: ruleDecoration : ( ( rule__Decoration__Alternatives ) ) ;
    public final void ruleDecoration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:412:1: ( ( ( rule__Decoration__Alternatives ) ) )
            // InternalModelDraw.g:413:2: ( ( rule__Decoration__Alternatives ) )
            {
            // InternalModelDraw.g:413:2: ( ( rule__Decoration__Alternatives ) )
            // InternalModelDraw.g:414:3: ( rule__Decoration__Alternatives )
            {
             before(grammarAccess.getDecorationAccess().getAlternatives()); 
            // InternalModelDraw.g:415:3: ( rule__Decoration__Alternatives )
            // InternalModelDraw.g:415:4: rule__Decoration__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Decoration__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getDecorationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecoration"


    // $ANTLR start "rule__EString__Alternatives"
    // InternalModelDraw.g:423:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:427:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalModelDraw.g:428:2: ( RULE_STRING )
                    {
                    // InternalModelDraw.g:428:2: ( RULE_STRING )
                    // InternalModelDraw.g:429:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:434:2: ( RULE_ID )
                    {
                    // InternalModelDraw.g:434:2: ( RULE_ID )
                    // InternalModelDraw.g:435:3: RULE_ID
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


    // $ANTLR start "rule__Relation__Alternatives"
    // InternalModelDraw.g:444:1: rule__Relation__Alternatives : ( ( ruleEdge ) | ( ruleLevel ) );
    public final void rule__Relation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:448:1: ( ( ruleEdge ) | ( ruleLevel ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==44) ) {
                    alt2=2;
                }
                else if ( (LA2_1==32||LA2_1==35) ) {
                    alt2=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalModelDraw.g:449:2: ( ruleEdge )
                    {
                    // InternalModelDraw.g:449:2: ( ruleEdge )
                    // InternalModelDraw.g:450:3: ruleEdge
                    {
                     before(grammarAccess.getRelationAccess().getEdgeParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleEdge();

                    state._fsp--;

                     after(grammarAccess.getRelationAccess().getEdgeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:455:2: ( ruleLevel )
                    {
                    // InternalModelDraw.g:455:2: ( ruleLevel )
                    // InternalModelDraw.g:456:3: ruleLevel
                    {
                     before(grammarAccess.getRelationAccess().getLevelParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleLevel();

                    state._fsp--;

                     after(grammarAccess.getRelationAccess().getLevelParserRuleCall_1()); 

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
    // $ANTLR end "rule__Relation__Alternatives"


    // $ANTLR start "rule__Edge__Alternatives_3"
    // InternalModelDraw.g:465:1: rule__Edge__Alternatives_3 : ( ( ( rule__Edge__Group_3_0__0 ) ) | ( ( rule__Edge__Group_3_1__0 ) ) );
    public final void rule__Edge__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:469:1: ( ( ( rule__Edge__Group_3_0__0 ) ) | ( ( rule__Edge__Group_3_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==32) ) {
                alt3=1;
            }
            else if ( (LA3_0==35) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalModelDraw.g:470:2: ( ( rule__Edge__Group_3_0__0 ) )
                    {
                    // InternalModelDraw.g:470:2: ( ( rule__Edge__Group_3_0__0 ) )
                    // InternalModelDraw.g:471:3: ( rule__Edge__Group_3_0__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_3_0()); 
                    // InternalModelDraw.g:472:3: ( rule__Edge__Group_3_0__0 )
                    // InternalModelDraw.g:472:4: rule__Edge__Group_3_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_3_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEdgeAccess().getGroup_3_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:476:2: ( ( rule__Edge__Group_3_1__0 ) )
                    {
                    // InternalModelDraw.g:476:2: ( ( rule__Edge__Group_3_1__0 ) )
                    // InternalModelDraw.g:477:3: ( rule__Edge__Group_3_1__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_3_1()); 
                    // InternalModelDraw.g:478:3: ( rule__Edge__Group_3_1__0 )
                    // InternalModelDraw.g:478:4: rule__Edge__Group_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_3_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEdgeAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__Edge__Alternatives_3"


    // $ANTLR start "rule__Edge__Alternatives_7_2"
    // InternalModelDraw.g:486:1: rule__Edge__Alternatives_7_2 : ( ( ( rule__Edge__Group_7_2_0__0 ) ) | ( ( rule__Edge__Group_7_2_1__0 ) ) );
    public final void rule__Edge__Alternatives_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:490:1: ( ( ( rule__Edge__Group_7_2_0__0 ) ) | ( ( rule__Edge__Group_7_2_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==30) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalModelDraw.g:491:2: ( ( rule__Edge__Group_7_2_0__0 ) )
                    {
                    // InternalModelDraw.g:491:2: ( ( rule__Edge__Group_7_2_0__0 ) )
                    // InternalModelDraw.g:492:3: ( rule__Edge__Group_7_2_0__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_7_2_0()); 
                    // InternalModelDraw.g:493:3: ( rule__Edge__Group_7_2_0__0 )
                    // InternalModelDraw.g:493:4: rule__Edge__Group_7_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEdgeAccess().getGroup_7_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:497:2: ( ( rule__Edge__Group_7_2_1__0 ) )
                    {
                    // InternalModelDraw.g:497:2: ( ( rule__Edge__Group_7_2_1__0 ) )
                    // InternalModelDraw.g:498:3: ( rule__Edge__Group_7_2_1__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_7_2_1()); 
                    // InternalModelDraw.g:499:3: ( rule__Edge__Group_7_2_1__0 )
                    // InternalModelDraw.g:499:4: rule__Edge__Group_7_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEdgeAccess().getGroup_7_2_1()); 

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
    // $ANTLR end "rule__Edge__Alternatives_7_2"


    // $ANTLR start "rule__Level__Alternatives_7_2"
    // InternalModelDraw.g:507:1: rule__Level__Alternatives_7_2 : ( ( ( rule__Level__Group_7_2_0__0 ) ) | ( ( rule__Level__Group_7_2_1__0 ) ) );
    public final void rule__Level__Alternatives_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:511:1: ( ( ( rule__Level__Group_7_2_0__0 ) ) | ( ( rule__Level__Group_7_2_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==30) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelDraw.g:512:2: ( ( rule__Level__Group_7_2_0__0 ) )
                    {
                    // InternalModelDraw.g:512:2: ( ( rule__Level__Group_7_2_0__0 ) )
                    // InternalModelDraw.g:513:3: ( rule__Level__Group_7_2_0__0 )
                    {
                     before(grammarAccess.getLevelAccess().getGroup_7_2_0()); 
                    // InternalModelDraw.g:514:3: ( rule__Level__Group_7_2_0__0 )
                    // InternalModelDraw.g:514:4: rule__Level__Group_7_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLevelAccess().getGroup_7_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:518:2: ( ( rule__Level__Group_7_2_1__0 ) )
                    {
                    // InternalModelDraw.g:518:2: ( ( rule__Level__Group_7_2_1__0 ) )
                    // InternalModelDraw.g:519:3: ( rule__Level__Group_7_2_1__0 )
                    {
                     before(grammarAccess.getLevelAccess().getGroup_7_2_1()); 
                    // InternalModelDraw.g:520:3: ( rule__Level__Group_7_2_1__0 )
                    // InternalModelDraw.g:520:4: rule__Level__Group_7_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getLevelAccess().getGroup_7_2_1()); 

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
    // $ANTLR end "rule__Level__Alternatives_7_2"


    // $ANTLR start "rule__NodeType__Alternatives"
    // InternalModelDraw.g:528:1: rule__NodeType__Alternatives : ( ( ( 'node' ) ) | ( ( 'markednode' ) ) );
    public final void rule__NodeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:532:1: ( ( ( 'node' ) ) | ( ( 'markednode' ) ) )
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
                    // InternalModelDraw.g:533:2: ( ( 'node' ) )
                    {
                    // InternalModelDraw.g:533:2: ( ( 'node' ) )
                    // InternalModelDraw.g:534:3: ( 'node' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:535:3: ( 'node' )
                    // InternalModelDraw.g:535:4: 'node'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:539:2: ( ( 'markednode' ) )
                    {
                    // InternalModelDraw.g:539:2: ( ( 'markednode' ) )
                    // InternalModelDraw.g:540:3: ( 'markednode' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:541:3: ( 'markednode' )
                    // InternalModelDraw.g:541:4: 'markednode'
                    {
                    match(input,14,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__NodeType__Alternatives"


    // $ANTLR start "rule__NodeShape__Alternatives"
    // InternalModelDraw.g:549:1: rule__NodeShape__Alternatives : ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) | ( ( 'load' ) ) | ( ( 'logic' ) ) );
    public final void rule__NodeShape__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:553:1: ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) | ( ( 'load' ) ) | ( ( 'logic' ) ) )
            int alt7=5;
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
            case 19:
                {
                alt7=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalModelDraw.g:554:2: ( ( 'circle' ) )
                    {
                    // InternalModelDraw.g:554:2: ( ( 'circle' ) )
                    // InternalModelDraw.g:555:3: ( 'circle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:556:3: ( 'circle' )
                    // InternalModelDraw.g:556:4: 'circle'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:560:2: ( ( 'doublecircle' ) )
                    {
                    // InternalModelDraw.g:560:2: ( ( 'doublecircle' ) )
                    // InternalModelDraw.g:561:3: ( 'doublecircle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:562:3: ( 'doublecircle' )
                    // InternalModelDraw.g:562:4: 'doublecircle'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:566:2: ( ( 'record' ) )
                    {
                    // InternalModelDraw.g:566:2: ( ( 'record' ) )
                    // InternalModelDraw.g:567:3: ( 'record' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:568:3: ( 'record' )
                    // InternalModelDraw.g:568:4: 'record'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:572:2: ( ( 'load' ) )
                    {
                    // InternalModelDraw.g:572:2: ( ( 'load' ) )
                    // InternalModelDraw.g:573:3: ( 'load' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3()); 
                    // InternalModelDraw.g:574:3: ( 'load' )
                    // InternalModelDraw.g:574:4: 'load'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:578:2: ( ( 'logic' ) )
                    {
                    // InternalModelDraw.g:578:2: ( ( 'logic' ) )
                    // InternalModelDraw.g:579:3: ( 'logic' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getLogicEnumLiteralDeclaration_4()); 
                    // InternalModelDraw.g:580:3: ( 'logic' )
                    // InternalModelDraw.g:580:4: 'logic'
                    {
                    match(input,19,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getLogicEnumLiteralDeclaration_4()); 

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
    // $ANTLR end "rule__NodeShape__Alternatives"


    // $ANTLR start "rule__NodeStyle__Alternatives"
    // InternalModelDraw.g:588:1: rule__NodeStyle__Alternatives : ( ( ( 'italic' ) ) | ( ( 'underline' ) ) );
    public final void rule__NodeStyle__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:592:1: ( ( ( 'italic' ) ) | ( ( 'underline' ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            else if ( (LA8_0==21) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalModelDraw.g:593:2: ( ( 'italic' ) )
                    {
                    // InternalModelDraw.g:593:2: ( ( 'italic' ) )
                    // InternalModelDraw.g:594:3: ( 'italic' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:595:3: ( 'italic' )
                    // InternalModelDraw.g:595:4: 'italic'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:599:2: ( ( 'underline' ) )
                    {
                    // InternalModelDraw.g:599:2: ( ( 'underline' ) )
                    // InternalModelDraw.g:600:3: ( 'underline' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getUnderlineEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:601:3: ( 'underline' )
                    // InternalModelDraw.g:601:4: 'underline'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeStyleAccess().getUnderlineEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__NodeStyle__Alternatives"


    // $ANTLR start "rule__Decoration__Alternatives"
    // InternalModelDraw.g:609:1: rule__Decoration__Alternatives : ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) );
    public final void rule__Decoration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:613:1: ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) )
            int alt9=6;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 25:
                {
                alt9=4;
                }
                break;
            case 26:
                {
                alt9=5;
                }
                break;
            case 27:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // InternalModelDraw.g:614:2: ( ( 'none' ) )
                    {
                    // InternalModelDraw.g:614:2: ( ( 'none' ) )
                    // InternalModelDraw.g:615:3: ( 'none' )
                    {
                     before(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:616:3: ( 'none' )
                    // InternalModelDraw.g:616:4: 'none'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:620:2: ( ( 'triangle' ) )
                    {
                    // InternalModelDraw.g:620:2: ( ( 'triangle' ) )
                    // InternalModelDraw.g:621:3: ( 'triangle' )
                    {
                     before(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:622:3: ( 'triangle' )
                    // InternalModelDraw.g:622:4: 'triangle'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:626:2: ( ( 'diamond' ) )
                    {
                    // InternalModelDraw.g:626:2: ( ( 'diamond' ) )
                    // InternalModelDraw.g:627:3: ( 'diamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:628:3: ( 'diamond' )
                    // InternalModelDraw.g:628:4: 'diamond'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:632:2: ( ( 'odiamond' ) )
                    {
                    // InternalModelDraw.g:632:2: ( ( 'odiamond' ) )
                    // InternalModelDraw.g:633:3: ( 'odiamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 
                    // InternalModelDraw.g:634:3: ( 'odiamond' )
                    // InternalModelDraw.g:634:4: 'odiamond'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:638:2: ( ( 'open' ) )
                    {
                    // InternalModelDraw.g:638:2: ( ( 'open' ) )
                    // InternalModelDraw.g:639:3: ( 'open' )
                    {
                     before(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 
                    // InternalModelDraw.g:640:3: ( 'open' )
                    // InternalModelDraw.g:640:4: 'open'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:644:2: ( ( 'empty' ) )
                    {
                    // InternalModelDraw.g:644:2: ( ( 'empty' ) )
                    // InternalModelDraw.g:645:3: ( 'empty' )
                    {
                     before(grammarAccess.getDecorationAccess().getEmptyEnumLiteralDeclaration_5()); 
                    // InternalModelDraw.g:646:3: ( 'empty' )
                    // InternalModelDraw.g:646:4: 'empty'
                    {
                    match(input,27,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getEmptyEnumLiteralDeclaration_5()); 

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
    // $ANTLR end "rule__Decoration__Alternatives"


    // $ANTLR start "rule__MutatorDraw__Group__0"
    // InternalModelDraw.g:654:1: rule__MutatorDraw__Group__0 : rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 ;
    public final void rule__MutatorDraw__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:658:1: ( rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 )
            // InternalModelDraw.g:659:2: rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__MutatorDraw__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__0"


    // $ANTLR start "rule__MutatorDraw__Group__0__Impl"
    // InternalModelDraw.g:666:1: rule__MutatorDraw__Group__0__Impl : ( () ) ;
    public final void rule__MutatorDraw__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:670:1: ( ( () ) )
            // InternalModelDraw.g:671:1: ( () )
            {
            // InternalModelDraw.g:671:1: ( () )
            // InternalModelDraw.g:672:2: ()
            {
             before(grammarAccess.getMutatorDrawAccess().getMutatorDrawAction_0()); 
            // InternalModelDraw.g:673:2: ()
            // InternalModelDraw.g:673:3: 
            {
            }

             after(grammarAccess.getMutatorDrawAccess().getMutatorDrawAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__0__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__1"
    // InternalModelDraw.g:681:1: rule__MutatorDraw__Group__1 : rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 ;
    public final void rule__MutatorDraw__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:685:1: ( rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 )
            // InternalModelDraw.g:686:2: rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2
            {
            pushFollow(FOLLOW_4);
            rule__MutatorDraw__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__1"


    // $ANTLR start "rule__MutatorDraw__Group__1__Impl"
    // InternalModelDraw.g:693:1: rule__MutatorDraw__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__MutatorDraw__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:697:1: ( ( 'metamodel' ) )
            // InternalModelDraw.g:698:1: ( 'metamodel' )
            {
            // InternalModelDraw.g:698:1: ( 'metamodel' )
            // InternalModelDraw.g:699:2: 'metamodel'
            {
             before(grammarAccess.getMutatorDrawAccess().getMetamodelKeyword_1()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getMutatorDrawAccess().getMetamodelKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__1__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__2"
    // InternalModelDraw.g:708:1: rule__MutatorDraw__Group__2 : rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 ;
    public final void rule__MutatorDraw__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:712:1: ( rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 )
            // InternalModelDraw.g:713:2: rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__MutatorDraw__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__2"


    // $ANTLR start "rule__MutatorDraw__Group__2__Impl"
    // InternalModelDraw.g:720:1: rule__MutatorDraw__Group__2__Impl : ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) ;
    public final void rule__MutatorDraw__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:724:1: ( ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) )
            // InternalModelDraw.g:725:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            {
            // InternalModelDraw.g:725:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            // InternalModelDraw.g:726:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            {
             before(grammarAccess.getMutatorDrawAccess().getMetamodelAssignment_2()); 
            // InternalModelDraw.g:727:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            // InternalModelDraw.g:727:3: rule__MutatorDraw__MetamodelAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__MutatorDraw__MetamodelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMutatorDrawAccess().getMetamodelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__2__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__3"
    // InternalModelDraw.g:735:1: rule__MutatorDraw__Group__3 : rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4 ;
    public final void rule__MutatorDraw__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:739:1: ( rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4 )
            // InternalModelDraw.g:740:2: rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__MutatorDraw__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__3"


    // $ANTLR start "rule__MutatorDraw__Group__3__Impl"
    // InternalModelDraw.g:747:1: rule__MutatorDraw__Group__3__Impl : ( ( rule__MutatorDraw__NameAssignment_3 ) ) ;
    public final void rule__MutatorDraw__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:751:1: ( ( ( rule__MutatorDraw__NameAssignment_3 ) ) )
            // InternalModelDraw.g:752:1: ( ( rule__MutatorDraw__NameAssignment_3 ) )
            {
            // InternalModelDraw.g:752:1: ( ( rule__MutatorDraw__NameAssignment_3 ) )
            // InternalModelDraw.g:753:2: ( rule__MutatorDraw__NameAssignment_3 )
            {
             before(grammarAccess.getMutatorDrawAccess().getNameAssignment_3()); 
            // InternalModelDraw.g:754:2: ( rule__MutatorDraw__NameAssignment_3 )
            // InternalModelDraw.g:754:3: rule__MutatorDraw__NameAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MutatorDraw__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMutatorDrawAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__3__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__4"
    // InternalModelDraw.g:762:1: rule__MutatorDraw__Group__4 : rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5 ;
    public final void rule__MutatorDraw__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:766:1: ( rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5 )
            // InternalModelDraw.g:767:2: rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5
            {
            pushFollow(FOLLOW_7);
            rule__MutatorDraw__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__4"


    // $ANTLR start "rule__MutatorDraw__Group__4__Impl"
    // InternalModelDraw.g:774:1: rule__MutatorDraw__Group__4__Impl : ( ':' ) ;
    public final void rule__MutatorDraw__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:778:1: ( ( ':' ) )
            // InternalModelDraw.g:779:1: ( ':' )
            {
            // InternalModelDraw.g:779:1: ( ':' )
            // InternalModelDraw.g:780:2: ':'
            {
             before(grammarAccess.getMutatorDrawAccess().getColonKeyword_4()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getMutatorDrawAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__4__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__5"
    // InternalModelDraw.g:789:1: rule__MutatorDraw__Group__5 : rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6 ;
    public final void rule__MutatorDraw__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:793:1: ( rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6 )
            // InternalModelDraw.g:794:2: rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6
            {
            pushFollow(FOLLOW_8);
            rule__MutatorDraw__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__5"


    // $ANTLR start "rule__MutatorDraw__Group__5__Impl"
    // InternalModelDraw.g:801:1: rule__MutatorDraw__Group__5__Impl : ( ( rule__MutatorDraw__TypeAssignment_5 ) ) ;
    public final void rule__MutatorDraw__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:805:1: ( ( ( rule__MutatorDraw__TypeAssignment_5 ) ) )
            // InternalModelDraw.g:806:1: ( ( rule__MutatorDraw__TypeAssignment_5 ) )
            {
            // InternalModelDraw.g:806:1: ( ( rule__MutatorDraw__TypeAssignment_5 ) )
            // InternalModelDraw.g:807:2: ( rule__MutatorDraw__TypeAssignment_5 )
            {
             before(grammarAccess.getMutatorDrawAccess().getTypeAssignment_5()); 
            // InternalModelDraw.g:808:2: ( rule__MutatorDraw__TypeAssignment_5 )
            // InternalModelDraw.g:808:3: rule__MutatorDraw__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__MutatorDraw__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMutatorDrawAccess().getTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__5__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__6"
    // InternalModelDraw.g:816:1: rule__MutatorDraw__Group__6 : rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7 ;
    public final void rule__MutatorDraw__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:820:1: ( rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7 )
            // InternalModelDraw.g:821:2: rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7
            {
            pushFollow(FOLLOW_9);
            rule__MutatorDraw__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__6"


    // $ANTLR start "rule__MutatorDraw__Group__6__Impl"
    // InternalModelDraw.g:828:1: rule__MutatorDraw__Group__6__Impl : ( '{' ) ;
    public final void rule__MutatorDraw__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:832:1: ( ( '{' ) )
            // InternalModelDraw.g:833:1: ( '{' )
            {
            // InternalModelDraw.g:833:1: ( '{' )
            // InternalModelDraw.g:834:2: '{'
            {
             before(grammarAccess.getMutatorDrawAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getMutatorDrawAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__6__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__7"
    // InternalModelDraw.g:843:1: rule__MutatorDraw__Group__7 : rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8 ;
    public final void rule__MutatorDraw__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:847:1: ( rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8 )
            // InternalModelDraw.g:848:2: rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8
            {
            pushFollow(FOLLOW_9);
            rule__MutatorDraw__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__7"


    // $ANTLR start "rule__MutatorDraw__Group__7__Impl"
    // InternalModelDraw.g:855:1: rule__MutatorDraw__Group__7__Impl : ( ( rule__MutatorDraw__NodesAssignment_7 )* ) ;
    public final void rule__MutatorDraw__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:859:1: ( ( ( rule__MutatorDraw__NodesAssignment_7 )* ) )
            // InternalModelDraw.g:860:1: ( ( rule__MutatorDraw__NodesAssignment_7 )* )
            {
            // InternalModelDraw.g:860:1: ( ( rule__MutatorDraw__NodesAssignment_7 )* )
            // InternalModelDraw.g:861:2: ( rule__MutatorDraw__NodesAssignment_7 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getNodesAssignment_7()); 
            // InternalModelDraw.g:862:2: ( rule__MutatorDraw__NodesAssignment_7 )*
            loop10:
            do {
                int alt10=2;
                alt10 = dfa10.predict(input);
                switch (alt10) {
            	case 1 :
            	    // InternalModelDraw.g:862:3: rule__MutatorDraw__NodesAssignment_7
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__NodesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMutatorDrawAccess().getNodesAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__7__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__8"
    // InternalModelDraw.g:870:1: rule__MutatorDraw__Group__8 : rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9 ;
    public final void rule__MutatorDraw__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:874:1: ( rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9 )
            // InternalModelDraw.g:875:2: rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9
            {
            pushFollow(FOLLOW_9);
            rule__MutatorDraw__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__8"


    // $ANTLR start "rule__MutatorDraw__Group__8__Impl"
    // InternalModelDraw.g:882:1: rule__MutatorDraw__Group__8__Impl : ( ( rule__MutatorDraw__RelationsAssignment_8 )* ) ;
    public final void rule__MutatorDraw__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:886:1: ( ( ( rule__MutatorDraw__RelationsAssignment_8 )* ) )
            // InternalModelDraw.g:887:1: ( ( rule__MutatorDraw__RelationsAssignment_8 )* )
            {
            // InternalModelDraw.g:887:1: ( ( rule__MutatorDraw__RelationsAssignment_8 )* )
            // InternalModelDraw.g:888:2: ( rule__MutatorDraw__RelationsAssignment_8 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getRelationsAssignment_8()); 
            // InternalModelDraw.g:889:2: ( rule__MutatorDraw__RelationsAssignment_8 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    int LA11_1 = input.LA(2);

                    if ( (LA11_1==32||LA11_1==35||LA11_1==44) ) {
                        alt11=1;
                    }


                }


                switch (alt11) {
            	case 1 :
            	    // InternalModelDraw.g:889:3: rule__MutatorDraw__RelationsAssignment_8
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__RelationsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getMutatorDrawAccess().getRelationsAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__8__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__9"
    // InternalModelDraw.g:897:1: rule__MutatorDraw__Group__9 : rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10 ;
    public final void rule__MutatorDraw__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:901:1: ( rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10 )
            // InternalModelDraw.g:902:2: rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10
            {
            pushFollow(FOLLOW_9);
            rule__MutatorDraw__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__9"


    // $ANTLR start "rule__MutatorDraw__Group__9__Impl"
    // InternalModelDraw.g:909:1: rule__MutatorDraw__Group__9__Impl : ( ( rule__MutatorDraw__ContentsAssignment_9 )* ) ;
    public final void rule__MutatorDraw__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:913:1: ( ( ( rule__MutatorDraw__ContentsAssignment_9 )* ) )
            // InternalModelDraw.g:914:1: ( ( rule__MutatorDraw__ContentsAssignment_9 )* )
            {
            // InternalModelDraw.g:914:1: ( ( rule__MutatorDraw__ContentsAssignment_9 )* )
            // InternalModelDraw.g:915:2: ( rule__MutatorDraw__ContentsAssignment_9 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getContentsAssignment_9()); 
            // InternalModelDraw.g:916:2: ( rule__MutatorDraw__ContentsAssignment_9 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalModelDraw.g:916:3: rule__MutatorDraw__ContentsAssignment_9
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__ContentsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getMutatorDrawAccess().getContentsAssignment_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__9__Impl"


    // $ANTLR start "rule__MutatorDraw__Group__10"
    // InternalModelDraw.g:924:1: rule__MutatorDraw__Group__10 : rule__MutatorDraw__Group__10__Impl ;
    public final void rule__MutatorDraw__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:928:1: ( rule__MutatorDraw__Group__10__Impl )
            // InternalModelDraw.g:929:2: rule__MutatorDraw__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__10"


    // $ANTLR start "rule__MutatorDraw__Group__10__Impl"
    // InternalModelDraw.g:935:1: rule__MutatorDraw__Group__10__Impl : ( '}' ) ;
    public final void rule__MutatorDraw__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:939:1: ( ( '}' ) )
            // InternalModelDraw.g:940:1: ( '}' )
            {
            // InternalModelDraw.g:940:1: ( '}' )
            // InternalModelDraw.g:941:2: '}'
            {
             before(grammarAccess.getMutatorDrawAccess().getRightCurlyBracketKeyword_10()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getMutatorDrawAccess().getRightCurlyBracketKeyword_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__Group__10__Impl"


    // $ANTLR start "rule__Node__Group__0"
    // InternalModelDraw.g:951:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:955:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalModelDraw.g:956:2: rule__Node__Group__0__Impl rule__Node__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0"


    // $ANTLR start "rule__Node__Group__0__Impl"
    // InternalModelDraw.g:963:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:967:1: ( ( () ) )
            // InternalModelDraw.g:968:1: ( () )
            {
            // InternalModelDraw.g:968:1: ( () )
            // InternalModelDraw.g:969:2: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // InternalModelDraw.g:970:2: ()
            // InternalModelDraw.g:970:3: 
            {
            }

             after(grammarAccess.getNodeAccess().getNodeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__0__Impl"


    // $ANTLR start "rule__Node__Group__1"
    // InternalModelDraw.g:978:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:982:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalModelDraw.g:983:2: rule__Node__Group__1__Impl rule__Node__Group__2
            {
            pushFollow(FOLLOW_11);
            rule__Node__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1"


    // $ANTLR start "rule__Node__Group__1__Impl"
    // InternalModelDraw.g:990:1: rule__Node__Group__1__Impl : ( ( rule__Node__NameAssignment_1 ) ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:994:1: ( ( ( rule__Node__NameAssignment_1 ) ) )
            // InternalModelDraw.g:995:1: ( ( rule__Node__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:995:1: ( ( rule__Node__NameAssignment_1 ) )
            // InternalModelDraw.g:996:2: ( rule__Node__NameAssignment_1 )
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:997:2: ( rule__Node__NameAssignment_1 )
            // InternalModelDraw.g:997:3: rule__Node__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__1__Impl"


    // $ANTLR start "rule__Node__Group__2"
    // InternalModelDraw.g:1005:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1009:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalModelDraw.g:1010:2: rule__Node__Group__2__Impl rule__Node__Group__3
            {
            pushFollow(FOLLOW_11);
            rule__Node__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2"


    // $ANTLR start "rule__Node__Group__2__Impl"
    // InternalModelDraw.g:1017:1: rule__Node__Group__2__Impl : ( ( rule__Node__Group_2__0 )? ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1021:1: ( ( ( rule__Node__Group_2__0 )? ) )
            // InternalModelDraw.g:1022:1: ( ( rule__Node__Group_2__0 )? )
            {
            // InternalModelDraw.g:1022:1: ( ( rule__Node__Group_2__0 )? )
            // InternalModelDraw.g:1023:2: ( rule__Node__Group_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_2()); 
            // InternalModelDraw.g:1024:2: ( rule__Node__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalModelDraw.g:1024:3: rule__Node__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__2__Impl"


    // $ANTLR start "rule__Node__Group__3"
    // InternalModelDraw.g:1032:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1036:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalModelDraw.g:1037:2: rule__Node__Group__3__Impl rule__Node__Group__4
            {
            pushFollow(FOLLOW_11);
            rule__Node__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__3"


    // $ANTLR start "rule__Node__Group__3__Impl"
    // InternalModelDraw.g:1044:1: rule__Node__Group__3__Impl : ( ( rule__Node__Group_3__0 )? ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1048:1: ( ( ( rule__Node__Group_3__0 )? ) )
            // InternalModelDraw.g:1049:1: ( ( rule__Node__Group_3__0 )? )
            {
            // InternalModelDraw.g:1049:1: ( ( rule__Node__Group_3__0 )? )
            // InternalModelDraw.g:1050:2: ( rule__Node__Group_3__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_3()); 
            // InternalModelDraw.g:1051:2: ( rule__Node__Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==35) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalModelDraw.g:1051:3: rule__Node__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__3__Impl"


    // $ANTLR start "rule__Node__Group__4"
    // InternalModelDraw.g:1059:1: rule__Node__Group__4 : rule__Node__Group__4__Impl rule__Node__Group__5 ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1063:1: ( rule__Node__Group__4__Impl rule__Node__Group__5 )
            // InternalModelDraw.g:1064:2: rule__Node__Group__4__Impl rule__Node__Group__5
            {
            pushFollow(FOLLOW_12);
            rule__Node__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__4"


    // $ANTLR start "rule__Node__Group__4__Impl"
    // InternalModelDraw.g:1071:1: rule__Node__Group__4__Impl : ( ':' ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1075:1: ( ( ':' ) )
            // InternalModelDraw.g:1076:1: ( ':' )
            {
            // InternalModelDraw.g:1076:1: ( ':' )
            // InternalModelDraw.g:1077:2: ':'
            {
             before(grammarAccess.getNodeAccess().getColonKeyword_4()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__4__Impl"


    // $ANTLR start "rule__Node__Group__5"
    // InternalModelDraw.g:1086:1: rule__Node__Group__5 : rule__Node__Group__5__Impl rule__Node__Group__6 ;
    public final void rule__Node__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1090:1: ( rule__Node__Group__5__Impl rule__Node__Group__6 )
            // InternalModelDraw.g:1091:2: rule__Node__Group__5__Impl rule__Node__Group__6
            {
            pushFollow(FOLLOW_13);
            rule__Node__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__5"


    // $ANTLR start "rule__Node__Group__5__Impl"
    // InternalModelDraw.g:1098:1: rule__Node__Group__5__Impl : ( ( rule__Node__TypeAssignment_5 ) ) ;
    public final void rule__Node__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1102:1: ( ( ( rule__Node__TypeAssignment_5 ) ) )
            // InternalModelDraw.g:1103:1: ( ( rule__Node__TypeAssignment_5 ) )
            {
            // InternalModelDraw.g:1103:1: ( ( rule__Node__TypeAssignment_5 ) )
            // InternalModelDraw.g:1104:2: ( rule__Node__TypeAssignment_5 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_5()); 
            // InternalModelDraw.g:1105:2: ( rule__Node__TypeAssignment_5 )
            // InternalModelDraw.g:1105:3: rule__Node__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Node__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__5__Impl"


    // $ANTLR start "rule__Node__Group__6"
    // InternalModelDraw.g:1113:1: rule__Node__Group__6 : rule__Node__Group__6__Impl rule__Node__Group__7 ;
    public final void rule__Node__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1117:1: ( rule__Node__Group__6__Impl rule__Node__Group__7 )
            // InternalModelDraw.g:1118:2: rule__Node__Group__6__Impl rule__Node__Group__7
            {
            pushFollow(FOLLOW_13);
            rule__Node__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__6"


    // $ANTLR start "rule__Node__Group__6__Impl"
    // InternalModelDraw.g:1125:1: rule__Node__Group__6__Impl : ( ( rule__Node__Group_6__0 )? ) ;
    public final void rule__Node__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1129:1: ( ( ( rule__Node__Group_6__0 )? ) )
            // InternalModelDraw.g:1130:1: ( ( rule__Node__Group_6__0 )? )
            {
            // InternalModelDraw.g:1130:1: ( ( rule__Node__Group_6__0 )? )
            // InternalModelDraw.g:1131:2: ( rule__Node__Group_6__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_6()); 
            // InternalModelDraw.g:1132:2: ( rule__Node__Group_6__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==36) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalModelDraw.g:1132:3: rule__Node__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__6__Impl"


    // $ANTLR start "rule__Node__Group__7"
    // InternalModelDraw.g:1140:1: rule__Node__Group__7 : rule__Node__Group__7__Impl rule__Node__Group__8 ;
    public final void rule__Node__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1144:1: ( rule__Node__Group__7__Impl rule__Node__Group__8 )
            // InternalModelDraw.g:1145:2: rule__Node__Group__7__Impl rule__Node__Group__8
            {
            pushFollow(FOLLOW_13);
            rule__Node__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__7"


    // $ANTLR start "rule__Node__Group__7__Impl"
    // InternalModelDraw.g:1152:1: rule__Node__Group__7__Impl : ( ( rule__Node__Group_7__0 )? ) ;
    public final void rule__Node__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1156:1: ( ( ( rule__Node__Group_7__0 )? ) )
            // InternalModelDraw.g:1157:1: ( ( rule__Node__Group_7__0 )? )
            {
            // InternalModelDraw.g:1157:1: ( ( rule__Node__Group_7__0 )? )
            // InternalModelDraw.g:1158:2: ( rule__Node__Group_7__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_7()); 
            // InternalModelDraw.g:1159:2: ( rule__Node__Group_7__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==37) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalModelDraw.g:1159:3: rule__Node__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__7__Impl"


    // $ANTLR start "rule__Node__Group__8"
    // InternalModelDraw.g:1167:1: rule__Node__Group__8 : rule__Node__Group__8__Impl rule__Node__Group__9 ;
    public final void rule__Node__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1171:1: ( rule__Node__Group__8__Impl rule__Node__Group__9 )
            // InternalModelDraw.g:1172:2: rule__Node__Group__8__Impl rule__Node__Group__9
            {
            pushFollow(FOLLOW_13);
            rule__Node__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__8"


    // $ANTLR start "rule__Node__Group__8__Impl"
    // InternalModelDraw.g:1179:1: rule__Node__Group__8__Impl : ( ( rule__Node__Group_8__0 )? ) ;
    public final void rule__Node__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1183:1: ( ( ( rule__Node__Group_8__0 )? ) )
            // InternalModelDraw.g:1184:1: ( ( rule__Node__Group_8__0 )? )
            {
            // InternalModelDraw.g:1184:1: ( ( rule__Node__Group_8__0 )? )
            // InternalModelDraw.g:1185:2: ( rule__Node__Group_8__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_8()); 
            // InternalModelDraw.g:1186:2: ( rule__Node__Group_8__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==38) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalModelDraw.g:1186:3: rule__Node__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__8__Impl"


    // $ANTLR start "rule__Node__Group__9"
    // InternalModelDraw.g:1194:1: rule__Node__Group__9 : rule__Node__Group__9__Impl rule__Node__Group__10 ;
    public final void rule__Node__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1198:1: ( rule__Node__Group__9__Impl rule__Node__Group__10 )
            // InternalModelDraw.g:1199:2: rule__Node__Group__9__Impl rule__Node__Group__10
            {
            pushFollow(FOLLOW_13);
            rule__Node__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__9"


    // $ANTLR start "rule__Node__Group__9__Impl"
    // InternalModelDraw.g:1206:1: rule__Node__Group__9__Impl : ( ( rule__Node__Group_9__0 )? ) ;
    public final void rule__Node__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1210:1: ( ( ( rule__Node__Group_9__0 )? ) )
            // InternalModelDraw.g:1211:1: ( ( rule__Node__Group_9__0 )? )
            {
            // InternalModelDraw.g:1211:1: ( ( rule__Node__Group_9__0 )? )
            // InternalModelDraw.g:1212:2: ( rule__Node__Group_9__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_9()); 
            // InternalModelDraw.g:1213:2: ( rule__Node__Group_9__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==39) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalModelDraw.g:1213:3: rule__Node__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__9__Impl"


    // $ANTLR start "rule__Node__Group__10"
    // InternalModelDraw.g:1221:1: rule__Node__Group__10 : rule__Node__Group__10__Impl ;
    public final void rule__Node__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1225:1: ( rule__Node__Group__10__Impl )
            // InternalModelDraw.g:1226:2: rule__Node__Group__10__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group__10__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__10"


    // $ANTLR start "rule__Node__Group__10__Impl"
    // InternalModelDraw.g:1232:1: rule__Node__Group__10__Impl : ( ( rule__Node__Group_10__0 )? ) ;
    public final void rule__Node__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1236:1: ( ( ( rule__Node__Group_10__0 )? ) )
            // InternalModelDraw.g:1237:1: ( ( rule__Node__Group_10__0 )? )
            {
            // InternalModelDraw.g:1237:1: ( ( rule__Node__Group_10__0 )? )
            // InternalModelDraw.g:1238:2: ( rule__Node__Group_10__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_10()); 
            // InternalModelDraw.g:1239:2: ( rule__Node__Group_10__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==40) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalModelDraw.g:1239:3: rule__Node__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group__10__Impl"


    // $ANTLR start "rule__Node__Group_2__0"
    // InternalModelDraw.g:1248:1: rule__Node__Group_2__0 : rule__Node__Group_2__0__Impl rule__Node__Group_2__1 ;
    public final void rule__Node__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1252:1: ( rule__Node__Group_2__0__Impl rule__Node__Group_2__1 )
            // InternalModelDraw.g:1253:2: rule__Node__Group_2__0__Impl rule__Node__Group_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Node__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__0"


    // $ANTLR start "rule__Node__Group_2__0__Impl"
    // InternalModelDraw.g:1260:1: rule__Node__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1264:1: ( ( '(' ) )
            // InternalModelDraw.g:1265:1: ( '(' )
            {
            // InternalModelDraw.g:1265:1: ( '(' )
            // InternalModelDraw.g:1266:2: '('
            {
             before(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__0__Impl"


    // $ANTLR start "rule__Node__Group_2__1"
    // InternalModelDraw.g:1275:1: rule__Node__Group_2__1 : rule__Node__Group_2__1__Impl rule__Node__Group_2__2 ;
    public final void rule__Node__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1279:1: ( rule__Node__Group_2__1__Impl rule__Node__Group_2__2 )
            // InternalModelDraw.g:1280:2: rule__Node__Group_2__1__Impl rule__Node__Group_2__2
            {
            pushFollow(FOLLOW_15);
            rule__Node__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__1"


    // $ANTLR start "rule__Node__Group_2__1__Impl"
    // InternalModelDraw.g:1287:1: rule__Node__Group_2__1__Impl : ( ( rule__Node__FeatureAssignment_2_1 ) ) ;
    public final void rule__Node__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1291:1: ( ( ( rule__Node__FeatureAssignment_2_1 ) ) )
            // InternalModelDraw.g:1292:1: ( ( rule__Node__FeatureAssignment_2_1 ) )
            {
            // InternalModelDraw.g:1292:1: ( ( rule__Node__FeatureAssignment_2_1 ) )
            // InternalModelDraw.g:1293:2: ( rule__Node__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getNodeAccess().getFeatureAssignment_2_1()); 
            // InternalModelDraw.g:1294:2: ( rule__Node__FeatureAssignment_2_1 )
            // InternalModelDraw.g:1294:3: rule__Node__FeatureAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__FeatureAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getFeatureAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__1__Impl"


    // $ANTLR start "rule__Node__Group_2__2"
    // InternalModelDraw.g:1302:1: rule__Node__Group_2__2 : rule__Node__Group_2__2__Impl rule__Node__Group_2__3 ;
    public final void rule__Node__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1306:1: ( rule__Node__Group_2__2__Impl rule__Node__Group_2__3 )
            // InternalModelDraw.g:1307:2: rule__Node__Group_2__2__Impl rule__Node__Group_2__3
            {
            pushFollow(FOLLOW_15);
            rule__Node__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__2"


    // $ANTLR start "rule__Node__Group_2__2__Impl"
    // InternalModelDraw.g:1314:1: rule__Node__Group_2__2__Impl : ( ( rule__Node__Group_2_2__0 )* ) ;
    public final void rule__Node__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1318:1: ( ( ( rule__Node__Group_2_2__0 )* ) )
            // InternalModelDraw.g:1319:1: ( ( rule__Node__Group_2_2__0 )* )
            {
            // InternalModelDraw.g:1319:1: ( ( rule__Node__Group_2_2__0 )* )
            // InternalModelDraw.g:1320:2: ( rule__Node__Group_2_2__0 )*
            {
             before(grammarAccess.getNodeAccess().getGroup_2_2()); 
            // InternalModelDraw.g:1321:2: ( rule__Node__Group_2_2__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalModelDraw.g:1321:3: rule__Node__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Node__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__2__Impl"


    // $ANTLR start "rule__Node__Group_2__3"
    // InternalModelDraw.g:1329:1: rule__Node__Group_2__3 : rule__Node__Group_2__3__Impl ;
    public final void rule__Node__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1333:1: ( rule__Node__Group_2__3__Impl )
            // InternalModelDraw.g:1334:2: rule__Node__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__3"


    // $ANTLR start "rule__Node__Group_2__3__Impl"
    // InternalModelDraw.g:1340:1: rule__Node__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Node__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1344:1: ( ( ')' ) )
            // InternalModelDraw.g:1345:1: ( ')' )
            {
            // InternalModelDraw.g:1345:1: ( ')' )
            // InternalModelDraw.g:1346:2: ')'
            {
             before(grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2__3__Impl"


    // $ANTLR start "rule__Node__Group_2_2__0"
    // InternalModelDraw.g:1356:1: rule__Node__Group_2_2__0 : rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 ;
    public final void rule__Node__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1360:1: ( rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 )
            // InternalModelDraw.g:1361:2: rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Node__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2_2__0"


    // $ANTLR start "rule__Node__Group_2_2__0__Impl"
    // InternalModelDraw.g:1368:1: rule__Node__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Node__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1372:1: ( ( ',' ) )
            // InternalModelDraw.g:1373:1: ( ',' )
            {
            // InternalModelDraw.g:1373:1: ( ',' )
            // InternalModelDraw.g:1374:2: ','
            {
             before(grammarAccess.getNodeAccess().getCommaKeyword_2_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2_2__0__Impl"


    // $ANTLR start "rule__Node__Group_2_2__1"
    // InternalModelDraw.g:1383:1: rule__Node__Group_2_2__1 : rule__Node__Group_2_2__1__Impl ;
    public final void rule__Node__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1387:1: ( rule__Node__Group_2_2__1__Impl )
            // InternalModelDraw.g:1388:2: rule__Node__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2_2__1"


    // $ANTLR start "rule__Node__Group_2_2__1__Impl"
    // InternalModelDraw.g:1394:1: rule__Node__Group_2_2__1__Impl : ( ( rule__Node__FeatureAssignment_2_2_1 ) ) ;
    public final void rule__Node__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1398:1: ( ( ( rule__Node__FeatureAssignment_2_2_1 ) ) )
            // InternalModelDraw.g:1399:1: ( ( rule__Node__FeatureAssignment_2_2_1 ) )
            {
            // InternalModelDraw.g:1399:1: ( ( rule__Node__FeatureAssignment_2_2_1 ) )
            // InternalModelDraw.g:1400:2: ( rule__Node__FeatureAssignment_2_2_1 )
            {
             before(grammarAccess.getNodeAccess().getFeatureAssignment_2_2_1()); 
            // InternalModelDraw.g:1401:2: ( rule__Node__FeatureAssignment_2_2_1 )
            // InternalModelDraw.g:1401:3: rule__Node__FeatureAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__FeatureAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getFeatureAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_2_2__1__Impl"


    // $ANTLR start "rule__Node__Group_3__0"
    // InternalModelDraw.g:1410:1: rule__Node__Group_3__0 : rule__Node__Group_3__0__Impl rule__Node__Group_3__1 ;
    public final void rule__Node__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1414:1: ( rule__Node__Group_3__0__Impl rule__Node__Group_3__1 )
            // InternalModelDraw.g:1415:2: rule__Node__Group_3__0__Impl rule__Node__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__0"


    // $ANTLR start "rule__Node__Group_3__0__Impl"
    // InternalModelDraw.g:1422:1: rule__Node__Group_3__0__Impl : ( '->' ) ;
    public final void rule__Node__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1426:1: ( ( '->' ) )
            // InternalModelDraw.g:1427:1: ( '->' )
            {
            // InternalModelDraw.g:1427:1: ( '->' )
            // InternalModelDraw.g:1428:2: '->'
            {
             before(grammarAccess.getNodeAccess().getHyphenMinusGreaterThanSignKeyword_3_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getHyphenMinusGreaterThanSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__0__Impl"


    // $ANTLR start "rule__Node__Group_3__1"
    // InternalModelDraw.g:1437:1: rule__Node__Group_3__1 : rule__Node__Group_3__1__Impl rule__Node__Group_3__2 ;
    public final void rule__Node__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1441:1: ( rule__Node__Group_3__1__Impl rule__Node__Group_3__2 )
            // InternalModelDraw.g:1442:2: rule__Node__Group_3__1__Impl rule__Node__Group_3__2
            {
            pushFollow(FOLLOW_17);
            rule__Node__Group_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__1"


    // $ANTLR start "rule__Node__Group_3__1__Impl"
    // InternalModelDraw.g:1449:1: rule__Node__Group_3__1__Impl : ( ( rule__Node__TargetNodeAssignment_3_1 ) ) ;
    public final void rule__Node__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1453:1: ( ( ( rule__Node__TargetNodeAssignment_3_1 ) ) )
            // InternalModelDraw.g:1454:1: ( ( rule__Node__TargetNodeAssignment_3_1 ) )
            {
            // InternalModelDraw.g:1454:1: ( ( rule__Node__TargetNodeAssignment_3_1 ) )
            // InternalModelDraw.g:1455:2: ( rule__Node__TargetNodeAssignment_3_1 )
            {
             before(grammarAccess.getNodeAccess().getTargetNodeAssignment_3_1()); 
            // InternalModelDraw.g:1456:2: ( rule__Node__TargetNodeAssignment_3_1 )
            // InternalModelDraw.g:1456:3: rule__Node__TargetNodeAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__TargetNodeAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getTargetNodeAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__1__Impl"


    // $ANTLR start "rule__Node__Group_3__2"
    // InternalModelDraw.g:1464:1: rule__Node__Group_3__2 : rule__Node__Group_3__2__Impl ;
    public final void rule__Node__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1468:1: ( rule__Node__Group_3__2__Impl )
            // InternalModelDraw.g:1469:2: rule__Node__Group_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__2"


    // $ANTLR start "rule__Node__Group_3__2__Impl"
    // InternalModelDraw.g:1475:1: rule__Node__Group_3__2__Impl : ( ( rule__Node__Group_3_2__0 )? ) ;
    public final void rule__Node__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1479:1: ( ( ( rule__Node__Group_3_2__0 )? ) )
            // InternalModelDraw.g:1480:1: ( ( rule__Node__Group_3_2__0 )? )
            {
            // InternalModelDraw.g:1480:1: ( ( rule__Node__Group_3_2__0 )? )
            // InternalModelDraw.g:1481:2: ( rule__Node__Group_3_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_3_2()); 
            // InternalModelDraw.g:1482:2: ( rule__Node__Group_3_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==32) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalModelDraw.g:1482:3: rule__Node__Group_3_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_3_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3__2__Impl"


    // $ANTLR start "rule__Node__Group_3_2__0"
    // InternalModelDraw.g:1491:1: rule__Node__Group_3_2__0 : rule__Node__Group_3_2__0__Impl rule__Node__Group_3_2__1 ;
    public final void rule__Node__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1495:1: ( rule__Node__Group_3_2__0__Impl rule__Node__Group_3_2__1 )
            // InternalModelDraw.g:1496:2: rule__Node__Group_3_2__0__Impl rule__Node__Group_3_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Node__Group_3_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_3_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__0"


    // $ANTLR start "rule__Node__Group_3_2__0__Impl"
    // InternalModelDraw.g:1503:1: rule__Node__Group_3_2__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1507:1: ( ( '(' ) )
            // InternalModelDraw.g:1508:1: ( '(' )
            {
            // InternalModelDraw.g:1508:1: ( '(' )
            // InternalModelDraw.g:1509:2: '('
            {
             before(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_3_2_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__0__Impl"


    // $ANTLR start "rule__Node__Group_3_2__1"
    // InternalModelDraw.g:1518:1: rule__Node__Group_3_2__1 : rule__Node__Group_3_2__1__Impl rule__Node__Group_3_2__2 ;
    public final void rule__Node__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1522:1: ( rule__Node__Group_3_2__1__Impl rule__Node__Group_3_2__2 )
            // InternalModelDraw.g:1523:2: rule__Node__Group_3_2__1__Impl rule__Node__Group_3_2__2
            {
            pushFollow(FOLLOW_15);
            rule__Node__Group_3_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_3_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__1"


    // $ANTLR start "rule__Node__Group_3_2__1__Impl"
    // InternalModelDraw.g:1530:1: rule__Node__Group_3_2__1__Impl : ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) ) ;
    public final void rule__Node__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1534:1: ( ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) ) )
            // InternalModelDraw.g:1535:1: ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) )
            {
            // InternalModelDraw.g:1535:1: ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) )
            // InternalModelDraw.g:1536:2: ( rule__Node__TargetFeatureAssignment_3_2_1 )
            {
             before(grammarAccess.getNodeAccess().getTargetFeatureAssignment_3_2_1()); 
            // InternalModelDraw.g:1537:2: ( rule__Node__TargetFeatureAssignment_3_2_1 )
            // InternalModelDraw.g:1537:3: rule__Node__TargetFeatureAssignment_3_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__TargetFeatureAssignment_3_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getTargetFeatureAssignment_3_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__1__Impl"


    // $ANTLR start "rule__Node__Group_3_2__2"
    // InternalModelDraw.g:1545:1: rule__Node__Group_3_2__2 : rule__Node__Group_3_2__2__Impl rule__Node__Group_3_2__3 ;
    public final void rule__Node__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1549:1: ( rule__Node__Group_3_2__2__Impl rule__Node__Group_3_2__3 )
            // InternalModelDraw.g:1550:2: rule__Node__Group_3_2__2__Impl rule__Node__Group_3_2__3
            {
            pushFollow(FOLLOW_15);
            rule__Node__Group_3_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_3_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__2"


    // $ANTLR start "rule__Node__Group_3_2__2__Impl"
    // InternalModelDraw.g:1557:1: rule__Node__Group_3_2__2__Impl : ( ( rule__Node__Group_3_2_2__0 )* ) ;
    public final void rule__Node__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1561:1: ( ( ( rule__Node__Group_3_2_2__0 )* ) )
            // InternalModelDraw.g:1562:1: ( ( rule__Node__Group_3_2_2__0 )* )
            {
            // InternalModelDraw.g:1562:1: ( ( rule__Node__Group_3_2_2__0 )* )
            // InternalModelDraw.g:1563:2: ( rule__Node__Group_3_2_2__0 )*
            {
             before(grammarAccess.getNodeAccess().getGroup_3_2_2()); 
            // InternalModelDraw.g:1564:2: ( rule__Node__Group_3_2_2__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==34) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalModelDraw.g:1564:3: rule__Node__Group_3_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Node__Group_3_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getGroup_3_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__2__Impl"


    // $ANTLR start "rule__Node__Group_3_2__3"
    // InternalModelDraw.g:1572:1: rule__Node__Group_3_2__3 : rule__Node__Group_3_2__3__Impl ;
    public final void rule__Node__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1576:1: ( rule__Node__Group_3_2__3__Impl )
            // InternalModelDraw.g:1577:2: rule__Node__Group_3_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_3_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__3"


    // $ANTLR start "rule__Node__Group_3_2__3__Impl"
    // InternalModelDraw.g:1583:1: rule__Node__Group_3_2__3__Impl : ( ')' ) ;
    public final void rule__Node__Group_3_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1587:1: ( ( ')' ) )
            // InternalModelDraw.g:1588:1: ( ')' )
            {
            // InternalModelDraw.g:1588:1: ( ')' )
            // InternalModelDraw.g:1589:2: ')'
            {
             before(grammarAccess.getNodeAccess().getRightParenthesisKeyword_3_2_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRightParenthesisKeyword_3_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2__3__Impl"


    // $ANTLR start "rule__Node__Group_3_2_2__0"
    // InternalModelDraw.g:1599:1: rule__Node__Group_3_2_2__0 : rule__Node__Group_3_2_2__0__Impl rule__Node__Group_3_2_2__1 ;
    public final void rule__Node__Group_3_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1603:1: ( rule__Node__Group_3_2_2__0__Impl rule__Node__Group_3_2_2__1 )
            // InternalModelDraw.g:1604:2: rule__Node__Group_3_2_2__0__Impl rule__Node__Group_3_2_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Node__Group_3_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_3_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2_2__0"


    // $ANTLR start "rule__Node__Group_3_2_2__0__Impl"
    // InternalModelDraw.g:1611:1: rule__Node__Group_3_2_2__0__Impl : ( ',' ) ;
    public final void rule__Node__Group_3_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1615:1: ( ( ',' ) )
            // InternalModelDraw.g:1616:1: ( ',' )
            {
            // InternalModelDraw.g:1616:1: ( ',' )
            // InternalModelDraw.g:1617:2: ','
            {
             before(grammarAccess.getNodeAccess().getCommaKeyword_3_2_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getCommaKeyword_3_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2_2__0__Impl"


    // $ANTLR start "rule__Node__Group_3_2_2__1"
    // InternalModelDraw.g:1626:1: rule__Node__Group_3_2_2__1 : rule__Node__Group_3_2_2__1__Impl ;
    public final void rule__Node__Group_3_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1630:1: ( rule__Node__Group_3_2_2__1__Impl )
            // InternalModelDraw.g:1631:2: rule__Node__Group_3_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_3_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2_2__1"


    // $ANTLR start "rule__Node__Group_3_2_2__1__Impl"
    // InternalModelDraw.g:1637:1: rule__Node__Group_3_2_2__1__Impl : ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) ) ;
    public final void rule__Node__Group_3_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1641:1: ( ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) ) )
            // InternalModelDraw.g:1642:1: ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) )
            {
            // InternalModelDraw.g:1642:1: ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) )
            // InternalModelDraw.g:1643:2: ( rule__Node__TargetFeatureAssignment_3_2_2_1 )
            {
             before(grammarAccess.getNodeAccess().getTargetFeatureAssignment_3_2_2_1()); 
            // InternalModelDraw.g:1644:2: ( rule__Node__TargetFeatureAssignment_3_2_2_1 )
            // InternalModelDraw.g:1644:3: rule__Node__TargetFeatureAssignment_3_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__TargetFeatureAssignment_3_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getTargetFeatureAssignment_3_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_3_2_2__1__Impl"


    // $ANTLR start "rule__Node__Group_6__0"
    // InternalModelDraw.g:1653:1: rule__Node__Group_6__0 : rule__Node__Group_6__0__Impl rule__Node__Group_6__1 ;
    public final void rule__Node__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1657:1: ( rule__Node__Group_6__0__Impl rule__Node__Group_6__1 )
            // InternalModelDraw.g:1658:2: rule__Node__Group_6__0__Impl rule__Node__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__0"


    // $ANTLR start "rule__Node__Group_6__0__Impl"
    // InternalModelDraw.g:1665:1: rule__Node__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Node__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1669:1: ( ( '=' ) )
            // InternalModelDraw.g:1670:1: ( '=' )
            {
            // InternalModelDraw.g:1670:1: ( '=' )
            // InternalModelDraw.g:1671:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_6_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__0__Impl"


    // $ANTLR start "rule__Node__Group_6__1"
    // InternalModelDraw.g:1680:1: rule__Node__Group_6__1 : rule__Node__Group_6__1__Impl ;
    public final void rule__Node__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1684:1: ( rule__Node__Group_6__1__Impl )
            // InternalModelDraw.g:1685:2: rule__Node__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__1"


    // $ANTLR start "rule__Node__Group_6__1__Impl"
    // InternalModelDraw.g:1691:1: rule__Node__Group_6__1__Impl : ( ( rule__Node__AttNameAssignment_6_1 ) ) ;
    public final void rule__Node__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1695:1: ( ( ( rule__Node__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:1696:1: ( ( rule__Node__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:1696:1: ( ( rule__Node__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:1697:2: ( rule__Node__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getNodeAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:1698:2: ( rule__Node__AttNameAssignment_6_1 )
            // InternalModelDraw.g:1698:3: rule__Node__AttNameAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__AttNameAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAttNameAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__1__Impl"


    // $ANTLR start "rule__Node__Group_7__0"
    // InternalModelDraw.g:1707:1: rule__Node__Group_7__0 : rule__Node__Group_7__0__Impl rule__Node__Group_7__1 ;
    public final void rule__Node__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1711:1: ( rule__Node__Group_7__0__Impl rule__Node__Group_7__1 )
            // InternalModelDraw.g:1712:2: rule__Node__Group_7__0__Impl rule__Node__Group_7__1
            {
            pushFollow(FOLLOW_18);
            rule__Node__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__0"


    // $ANTLR start "rule__Node__Group_7__0__Impl"
    // InternalModelDraw.g:1719:1: rule__Node__Group_7__0__Impl : ( 'compartments' ) ;
    public final void rule__Node__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1723:1: ( ( 'compartments' ) )
            // InternalModelDraw.g:1724:1: ( 'compartments' )
            {
            // InternalModelDraw.g:1724:1: ( 'compartments' )
            // InternalModelDraw.g:1725:2: 'compartments'
            {
             before(grammarAccess.getNodeAccess().getCompartmentsKeyword_7_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getCompartmentsKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__0__Impl"


    // $ANTLR start "rule__Node__Group_7__1"
    // InternalModelDraw.g:1734:1: rule__Node__Group_7__1 : rule__Node__Group_7__1__Impl rule__Node__Group_7__2 ;
    public final void rule__Node__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1738:1: ( rule__Node__Group_7__1__Impl rule__Node__Group_7__2 )
            // InternalModelDraw.g:1739:2: rule__Node__Group_7__1__Impl rule__Node__Group_7__2
            {
            pushFollow(FOLLOW_8);
            rule__Node__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__1"


    // $ANTLR start "rule__Node__Group_7__1__Impl"
    // InternalModelDraw.g:1746:1: rule__Node__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1750:1: ( ( '=' ) )
            // InternalModelDraw.g:1751:1: ( '=' )
            {
            // InternalModelDraw.g:1751:1: ( '=' )
            // InternalModelDraw.g:1752:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_7_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__1__Impl"


    // $ANTLR start "rule__Node__Group_7__2"
    // InternalModelDraw.g:1761:1: rule__Node__Group_7__2 : rule__Node__Group_7__2__Impl rule__Node__Group_7__3 ;
    public final void rule__Node__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1765:1: ( rule__Node__Group_7__2__Impl rule__Node__Group_7__3 )
            // InternalModelDraw.g:1766:2: rule__Node__Group_7__2__Impl rule__Node__Group_7__3
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_7__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__2"


    // $ANTLR start "rule__Node__Group_7__2__Impl"
    // InternalModelDraw.g:1773:1: rule__Node__Group_7__2__Impl : ( '{' ) ;
    public final void rule__Node__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1777:1: ( ( '{' ) )
            // InternalModelDraw.g:1778:1: ( '{' )
            {
            // InternalModelDraw.g:1778:1: ( '{' )
            // InternalModelDraw.g:1779:2: '{'
            {
             before(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_7_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__2__Impl"


    // $ANTLR start "rule__Node__Group_7__3"
    // InternalModelDraw.g:1788:1: rule__Node__Group_7__3 : rule__Node__Group_7__3__Impl rule__Node__Group_7__4 ;
    public final void rule__Node__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1792:1: ( rule__Node__Group_7__3__Impl rule__Node__Group_7__4 )
            // InternalModelDraw.g:1793:2: rule__Node__Group_7__3__Impl rule__Node__Group_7__4
            {
            pushFollow(FOLLOW_9);
            rule__Node__Group_7__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_7__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__3"


    // $ANTLR start "rule__Node__Group_7__3__Impl"
    // InternalModelDraw.g:1800:1: rule__Node__Group_7__3__Impl : ( ( rule__Node__ReferenceAssignment_7_3 ) ) ;
    public final void rule__Node__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1804:1: ( ( ( rule__Node__ReferenceAssignment_7_3 ) ) )
            // InternalModelDraw.g:1805:1: ( ( rule__Node__ReferenceAssignment_7_3 ) )
            {
            // InternalModelDraw.g:1805:1: ( ( rule__Node__ReferenceAssignment_7_3 ) )
            // InternalModelDraw.g:1806:2: ( rule__Node__ReferenceAssignment_7_3 )
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_7_3()); 
            // InternalModelDraw.g:1807:2: ( rule__Node__ReferenceAssignment_7_3 )
            // InternalModelDraw.g:1807:3: rule__Node__ReferenceAssignment_7_3
            {
            pushFollow(FOLLOW_2);
            rule__Node__ReferenceAssignment_7_3();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getReferenceAssignment_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__3__Impl"


    // $ANTLR start "rule__Node__Group_7__4"
    // InternalModelDraw.g:1815:1: rule__Node__Group_7__4 : rule__Node__Group_7__4__Impl rule__Node__Group_7__5 ;
    public final void rule__Node__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1819:1: ( rule__Node__Group_7__4__Impl rule__Node__Group_7__5 )
            // InternalModelDraw.g:1820:2: rule__Node__Group_7__4__Impl rule__Node__Group_7__5
            {
            pushFollow(FOLLOW_9);
            rule__Node__Group_7__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_7__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__4"


    // $ANTLR start "rule__Node__Group_7__4__Impl"
    // InternalModelDraw.g:1827:1: rule__Node__Group_7__4__Impl : ( ( rule__Node__ReferenceAssignment_7_4 )* ) ;
    public final void rule__Node__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1831:1: ( ( ( rule__Node__ReferenceAssignment_7_4 )* ) )
            // InternalModelDraw.g:1832:1: ( ( rule__Node__ReferenceAssignment_7_4 )* )
            {
            // InternalModelDraw.g:1832:1: ( ( rule__Node__ReferenceAssignment_7_4 )* )
            // InternalModelDraw.g:1833:2: ( rule__Node__ReferenceAssignment_7_4 )*
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_7_4()); 
            // InternalModelDraw.g:1834:2: ( rule__Node__ReferenceAssignment_7_4 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalModelDraw.g:1834:3: rule__Node__ReferenceAssignment_7_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Node__ReferenceAssignment_7_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getReferenceAssignment_7_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__4__Impl"


    // $ANTLR start "rule__Node__Group_7__5"
    // InternalModelDraw.g:1842:1: rule__Node__Group_7__5 : rule__Node__Group_7__5__Impl ;
    public final void rule__Node__Group_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1846:1: ( rule__Node__Group_7__5__Impl )
            // InternalModelDraw.g:1847:2: rule__Node__Group_7__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_7__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__5"


    // $ANTLR start "rule__Node__Group_7__5__Impl"
    // InternalModelDraw.g:1853:1: rule__Node__Group_7__5__Impl : ( '}' ) ;
    public final void rule__Node__Group_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1857:1: ( ( '}' ) )
            // InternalModelDraw.g:1858:1: ( '}' )
            {
            // InternalModelDraw.g:1858:1: ( '}' )
            // InternalModelDraw.g:1859:2: '}'
            {
             before(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_7_5()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_7_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_7__5__Impl"


    // $ANTLR start "rule__Node__Group_8__0"
    // InternalModelDraw.g:1869:1: rule__Node__Group_8__0 : rule__Node__Group_8__0__Impl rule__Node__Group_8__1 ;
    public final void rule__Node__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1873:1: ( rule__Node__Group_8__0__Impl rule__Node__Group_8__1 )
            // InternalModelDraw.g:1874:2: rule__Node__Group_8__0__Impl rule__Node__Group_8__1
            {
            pushFollow(FOLLOW_18);
            rule__Node__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__0"


    // $ANTLR start "rule__Node__Group_8__0__Impl"
    // InternalModelDraw.g:1881:1: rule__Node__Group_8__0__Impl : ( 'shape' ) ;
    public final void rule__Node__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1885:1: ( ( 'shape' ) )
            // InternalModelDraw.g:1886:1: ( 'shape' )
            {
            // InternalModelDraw.g:1886:1: ( 'shape' )
            // InternalModelDraw.g:1887:2: 'shape'
            {
             before(grammarAccess.getNodeAccess().getShapeKeyword_8_0()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getShapeKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__0__Impl"


    // $ANTLR start "rule__Node__Group_8__1"
    // InternalModelDraw.g:1896:1: rule__Node__Group_8__1 : rule__Node__Group_8__1__Impl rule__Node__Group_8__2 ;
    public final void rule__Node__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1900:1: ( rule__Node__Group_8__1__Impl rule__Node__Group_8__2 )
            // InternalModelDraw.g:1901:2: rule__Node__Group_8__1__Impl rule__Node__Group_8__2
            {
            pushFollow(FOLLOW_19);
            rule__Node__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__1"


    // $ANTLR start "rule__Node__Group_8__1__Impl"
    // InternalModelDraw.g:1908:1: rule__Node__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1912:1: ( ( '=' ) )
            // InternalModelDraw.g:1913:1: ( '=' )
            {
            // InternalModelDraw.g:1913:1: ( '=' )
            // InternalModelDraw.g:1914:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_8_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__1__Impl"


    // $ANTLR start "rule__Node__Group_8__2"
    // InternalModelDraw.g:1923:1: rule__Node__Group_8__2 : rule__Node__Group_8__2__Impl rule__Node__Group_8__3 ;
    public final void rule__Node__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1927:1: ( rule__Node__Group_8__2__Impl rule__Node__Group_8__3 )
            // InternalModelDraw.g:1928:2: rule__Node__Group_8__2__Impl rule__Node__Group_8__3
            {
            pushFollow(FOLLOW_17);
            rule__Node__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_8__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__2"


    // $ANTLR start "rule__Node__Group_8__2__Impl"
    // InternalModelDraw.g:1935:1: rule__Node__Group_8__2__Impl : ( ( rule__Node__ShapeAssignment_8_2 ) ) ;
    public final void rule__Node__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1939:1: ( ( ( rule__Node__ShapeAssignment_8_2 ) ) )
            // InternalModelDraw.g:1940:1: ( ( rule__Node__ShapeAssignment_8_2 ) )
            {
            // InternalModelDraw.g:1940:1: ( ( rule__Node__ShapeAssignment_8_2 ) )
            // InternalModelDraw.g:1941:2: ( rule__Node__ShapeAssignment_8_2 )
            {
             before(grammarAccess.getNodeAccess().getShapeAssignment_8_2()); 
            // InternalModelDraw.g:1942:2: ( rule__Node__ShapeAssignment_8_2 )
            // InternalModelDraw.g:1942:3: rule__Node__ShapeAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__Node__ShapeAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getShapeAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__2__Impl"


    // $ANTLR start "rule__Node__Group_8__3"
    // InternalModelDraw.g:1950:1: rule__Node__Group_8__3 : rule__Node__Group_8__3__Impl ;
    public final void rule__Node__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1954:1: ( rule__Node__Group_8__3__Impl )
            // InternalModelDraw.g:1955:2: rule__Node__Group_8__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_8__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__3"


    // $ANTLR start "rule__Node__Group_8__3__Impl"
    // InternalModelDraw.g:1961:1: rule__Node__Group_8__3__Impl : ( ( rule__Node__Group_8_3__0 )? ) ;
    public final void rule__Node__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1965:1: ( ( ( rule__Node__Group_8_3__0 )? ) )
            // InternalModelDraw.g:1966:1: ( ( rule__Node__Group_8_3__0 )? )
            {
            // InternalModelDraw.g:1966:1: ( ( rule__Node__Group_8_3__0 )? )
            // InternalModelDraw.g:1967:2: ( rule__Node__Group_8_3__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_8_3()); 
            // InternalModelDraw.g:1968:2: ( rule__Node__Group_8_3__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==32) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalModelDraw.g:1968:3: rule__Node__Group_8_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_8_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_8_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8__3__Impl"


    // $ANTLR start "rule__Node__Group_8_3__0"
    // InternalModelDraw.g:1977:1: rule__Node__Group_8_3__0 : rule__Node__Group_8_3__0__Impl rule__Node__Group_8_3__1 ;
    public final void rule__Node__Group_8_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1981:1: ( rule__Node__Group_8_3__0__Impl rule__Node__Group_8_3__1 )
            // InternalModelDraw.g:1982:2: rule__Node__Group_8_3__0__Impl rule__Node__Group_8_3__1
            {
            pushFollow(FOLLOW_4);
            rule__Node__Group_8_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_8_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8_3__0"


    // $ANTLR start "rule__Node__Group_8_3__0__Impl"
    // InternalModelDraw.g:1989:1: rule__Node__Group_8_3__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_8_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1993:1: ( ( '(' ) )
            // InternalModelDraw.g:1994:1: ( '(' )
            {
            // InternalModelDraw.g:1994:1: ( '(' )
            // InternalModelDraw.g:1995:2: '('
            {
             before(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_8_3_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8_3__0__Impl"


    // $ANTLR start "rule__Node__Group_8_3__1"
    // InternalModelDraw.g:2004:1: rule__Node__Group_8_3__1 : rule__Node__Group_8_3__1__Impl rule__Node__Group_8_3__2 ;
    public final void rule__Node__Group_8_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2008:1: ( rule__Node__Group_8_3__1__Impl rule__Node__Group_8_3__2 )
            // InternalModelDraw.g:2009:2: rule__Node__Group_8_3__1__Impl rule__Node__Group_8_3__2
            {
            pushFollow(FOLLOW_20);
            rule__Node__Group_8_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_8_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8_3__1"


    // $ANTLR start "rule__Node__Group_8_3__1__Impl"
    // InternalModelDraw.g:2016:1: rule__Node__Group_8_3__1__Impl : ( ( rule__Node__PathShapeAssignment_8_3_1 ) ) ;
    public final void rule__Node__Group_8_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2020:1: ( ( ( rule__Node__PathShapeAssignment_8_3_1 ) ) )
            // InternalModelDraw.g:2021:1: ( ( rule__Node__PathShapeAssignment_8_3_1 ) )
            {
            // InternalModelDraw.g:2021:1: ( ( rule__Node__PathShapeAssignment_8_3_1 ) )
            // InternalModelDraw.g:2022:2: ( rule__Node__PathShapeAssignment_8_3_1 )
            {
             before(grammarAccess.getNodeAccess().getPathShapeAssignment_8_3_1()); 
            // InternalModelDraw.g:2023:2: ( rule__Node__PathShapeAssignment_8_3_1 )
            // InternalModelDraw.g:2023:3: rule__Node__PathShapeAssignment_8_3_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__PathShapeAssignment_8_3_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getPathShapeAssignment_8_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8_3__1__Impl"


    // $ANTLR start "rule__Node__Group_8_3__2"
    // InternalModelDraw.g:2031:1: rule__Node__Group_8_3__2 : rule__Node__Group_8_3__2__Impl ;
    public final void rule__Node__Group_8_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2035:1: ( rule__Node__Group_8_3__2__Impl )
            // InternalModelDraw.g:2036:2: rule__Node__Group_8_3__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_8_3__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8_3__2"


    // $ANTLR start "rule__Node__Group_8_3__2__Impl"
    // InternalModelDraw.g:2042:1: rule__Node__Group_8_3__2__Impl : ( ')' ) ;
    public final void rule__Node__Group_8_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2046:1: ( ( ')' ) )
            // InternalModelDraw.g:2047:1: ( ')' )
            {
            // InternalModelDraw.g:2047:1: ( ')' )
            // InternalModelDraw.g:2048:2: ')'
            {
             before(grammarAccess.getNodeAccess().getRightParenthesisKeyword_8_3_2()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRightParenthesisKeyword_8_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_8_3__2__Impl"


    // $ANTLR start "rule__Node__Group_9__0"
    // InternalModelDraw.g:2058:1: rule__Node__Group_9__0 : rule__Node__Group_9__0__Impl rule__Node__Group_9__1 ;
    public final void rule__Node__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2062:1: ( rule__Node__Group_9__0__Impl rule__Node__Group_9__1 )
            // InternalModelDraw.g:2063:2: rule__Node__Group_9__0__Impl rule__Node__Group_9__1
            {
            pushFollow(FOLLOW_18);
            rule__Node__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_9__0"


    // $ANTLR start "rule__Node__Group_9__0__Impl"
    // InternalModelDraw.g:2070:1: rule__Node__Group_9__0__Impl : ( 'color' ) ;
    public final void rule__Node__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2074:1: ( ( 'color' ) )
            // InternalModelDraw.g:2075:1: ( 'color' )
            {
            // InternalModelDraw.g:2075:1: ( 'color' )
            // InternalModelDraw.g:2076:2: 'color'
            {
             before(grammarAccess.getNodeAccess().getColorKeyword_9_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getColorKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_9__0__Impl"


    // $ANTLR start "rule__Node__Group_9__1"
    // InternalModelDraw.g:2085:1: rule__Node__Group_9__1 : rule__Node__Group_9__1__Impl rule__Node__Group_9__2 ;
    public final void rule__Node__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2089:1: ( rule__Node__Group_9__1__Impl rule__Node__Group_9__2 )
            // InternalModelDraw.g:2090:2: rule__Node__Group_9__1__Impl rule__Node__Group_9__2
            {
            pushFollow(FOLLOW_21);
            rule__Node__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_9__1"


    // $ANTLR start "rule__Node__Group_9__1__Impl"
    // InternalModelDraw.g:2097:1: rule__Node__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2101:1: ( ( '=' ) )
            // InternalModelDraw.g:2102:1: ( '=' )
            {
            // InternalModelDraw.g:2102:1: ( '=' )
            // InternalModelDraw.g:2103:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_9_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_9__1__Impl"


    // $ANTLR start "rule__Node__Group_9__2"
    // InternalModelDraw.g:2112:1: rule__Node__Group_9__2 : rule__Node__Group_9__2__Impl ;
    public final void rule__Node__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2116:1: ( rule__Node__Group_9__2__Impl )
            // InternalModelDraw.g:2117:2: rule__Node__Group_9__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_9__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_9__2"


    // $ANTLR start "rule__Node__Group_9__2__Impl"
    // InternalModelDraw.g:2123:1: rule__Node__Group_9__2__Impl : ( ( rule__Node__ColorAssignment_9_2 ) ) ;
    public final void rule__Node__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2127:1: ( ( ( rule__Node__ColorAssignment_9_2 ) ) )
            // InternalModelDraw.g:2128:1: ( ( rule__Node__ColorAssignment_9_2 ) )
            {
            // InternalModelDraw.g:2128:1: ( ( rule__Node__ColorAssignment_9_2 ) )
            // InternalModelDraw.g:2129:2: ( rule__Node__ColorAssignment_9_2 )
            {
             before(grammarAccess.getNodeAccess().getColorAssignment_9_2()); 
            // InternalModelDraw.g:2130:2: ( rule__Node__ColorAssignment_9_2 )
            // InternalModelDraw.g:2130:3: rule__Node__ColorAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Node__ColorAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getColorAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_9__2__Impl"


    // $ANTLR start "rule__Node__Group_10__0"
    // InternalModelDraw.g:2139:1: rule__Node__Group_10__0 : rule__Node__Group_10__0__Impl rule__Node__Group_10__1 ;
    public final void rule__Node__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2143:1: ( rule__Node__Group_10__0__Impl rule__Node__Group_10__1 )
            // InternalModelDraw.g:2144:2: rule__Node__Group_10__0__Impl rule__Node__Group_10__1
            {
            pushFollow(FOLLOW_18);
            rule__Node__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_10__0"


    // $ANTLR start "rule__Node__Group_10__0__Impl"
    // InternalModelDraw.g:2151:1: rule__Node__Group_10__0__Impl : ( 'style' ) ;
    public final void rule__Node__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2155:1: ( ( 'style' ) )
            // InternalModelDraw.g:2156:1: ( 'style' )
            {
            // InternalModelDraw.g:2156:1: ( 'style' )
            // InternalModelDraw.g:2157:2: 'style'
            {
             before(grammarAccess.getNodeAccess().getStyleKeyword_10_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getStyleKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_10__0__Impl"


    // $ANTLR start "rule__Node__Group_10__1"
    // InternalModelDraw.g:2166:1: rule__Node__Group_10__1 : rule__Node__Group_10__1__Impl rule__Node__Group_10__2 ;
    public final void rule__Node__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2170:1: ( rule__Node__Group_10__1__Impl rule__Node__Group_10__2 )
            // InternalModelDraw.g:2171:2: rule__Node__Group_10__1__Impl rule__Node__Group_10__2
            {
            pushFollow(FOLLOW_22);
            rule__Node__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_10__1"


    // $ANTLR start "rule__Node__Group_10__1__Impl"
    // InternalModelDraw.g:2178:1: rule__Node__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2182:1: ( ( '=' ) )
            // InternalModelDraw.g:2183:1: ( '=' )
            {
            // InternalModelDraw.g:2183:1: ( '=' )
            // InternalModelDraw.g:2184:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_10_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_10__1__Impl"


    // $ANTLR start "rule__Node__Group_10__2"
    // InternalModelDraw.g:2193:1: rule__Node__Group_10__2 : rule__Node__Group_10__2__Impl ;
    public final void rule__Node__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2197:1: ( rule__Node__Group_10__2__Impl )
            // InternalModelDraw.g:2198:2: rule__Node__Group_10__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_10__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_10__2"


    // $ANTLR start "rule__Node__Group_10__2__Impl"
    // InternalModelDraw.g:2204:1: rule__Node__Group_10__2__Impl : ( ( rule__Node__StyleAssignment_10_2 ) ) ;
    public final void rule__Node__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2208:1: ( ( ( rule__Node__StyleAssignment_10_2 ) ) )
            // InternalModelDraw.g:2209:1: ( ( rule__Node__StyleAssignment_10_2 ) )
            {
            // InternalModelDraw.g:2209:1: ( ( rule__Node__StyleAssignment_10_2 ) )
            // InternalModelDraw.g:2210:2: ( rule__Node__StyleAssignment_10_2 )
            {
             before(grammarAccess.getNodeAccess().getStyleAssignment_10_2()); 
            // InternalModelDraw.g:2211:2: ( rule__Node__StyleAssignment_10_2 )
            // InternalModelDraw.g:2211:3: rule__Node__StyleAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__Node__StyleAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getStyleAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_10__2__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__0"
    // InternalModelDraw.g:2220:1: rule__ValuedFeature__Group__0 : rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 ;
    public final void rule__ValuedFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2224:1: ( rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 )
            // InternalModelDraw.g:2225:2: rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__ValuedFeature__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__0"


    // $ANTLR start "rule__ValuedFeature__Group__0__Impl"
    // InternalModelDraw.g:2232:1: rule__ValuedFeature__Group__0__Impl : ( () ) ;
    public final void rule__ValuedFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2236:1: ( ( () ) )
            // InternalModelDraw.g:2237:1: ( () )
            {
            // InternalModelDraw.g:2237:1: ( () )
            // InternalModelDraw.g:2238:2: ()
            {
             before(grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0()); 
            // InternalModelDraw.g:2239:2: ()
            // InternalModelDraw.g:2239:3: 
            {
            }

             after(grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__0__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__1"
    // InternalModelDraw.g:2247:1: rule__ValuedFeature__Group__1 : rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 ;
    public final void rule__ValuedFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2251:1: ( rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 )
            // InternalModelDraw.g:2252:2: rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__ValuedFeature__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__1"


    // $ANTLR start "rule__ValuedFeature__Group__1__Impl"
    // InternalModelDraw.g:2259:1: rule__ValuedFeature__Group__1__Impl : ( ( rule__ValuedFeature__NegationAssignment_1 )? ) ;
    public final void rule__ValuedFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2263:1: ( ( ( rule__ValuedFeature__NegationAssignment_1 )? ) )
            // InternalModelDraw.g:2264:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            {
            // InternalModelDraw.g:2264:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            // InternalModelDraw.g:2265:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationAssignment_1()); 
            // InternalModelDraw.g:2266:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==52) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalModelDraw.g:2266:3: rule__ValuedFeature__NegationAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__ValuedFeature__NegationAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValuedFeatureAccess().getNegationAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__1__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__2"
    // InternalModelDraw.g:2274:1: rule__ValuedFeature__Group__2 : rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 ;
    public final void rule__ValuedFeature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2278:1: ( rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 )
            // InternalModelDraw.g:2279:2: rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3
            {
            pushFollow(FOLLOW_23);
            rule__ValuedFeature__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__2"


    // $ANTLR start "rule__ValuedFeature__Group__2__Impl"
    // InternalModelDraw.g:2286:1: rule__ValuedFeature__Group__2__Impl : ( ( rule__ValuedFeature__FeatAssignment_2 ) ) ;
    public final void rule__ValuedFeature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2290:1: ( ( ( rule__ValuedFeature__FeatAssignment_2 ) ) )
            // InternalModelDraw.g:2291:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            {
            // InternalModelDraw.g:2291:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            // InternalModelDraw.g:2292:2: ( rule__ValuedFeature__FeatAssignment_2 )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatAssignment_2()); 
            // InternalModelDraw.g:2293:2: ( rule__ValuedFeature__FeatAssignment_2 )
            // InternalModelDraw.g:2293:3: rule__ValuedFeature__FeatAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__FeatAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getFeatAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__2__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__3"
    // InternalModelDraw.g:2301:1: rule__ValuedFeature__Group__3 : rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 ;
    public final void rule__ValuedFeature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2305:1: ( rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 )
            // InternalModelDraw.g:2306:2: rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4
            {
            pushFollow(FOLLOW_23);
            rule__ValuedFeature__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__3"


    // $ANTLR start "rule__ValuedFeature__Group__3__Impl"
    // InternalModelDraw.g:2313:1: rule__ValuedFeature__Group__3__Impl : ( ( rule__ValuedFeature__Group_3__0 )? ) ;
    public final void rule__ValuedFeature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2317:1: ( ( ( rule__ValuedFeature__Group_3__0 )? ) )
            // InternalModelDraw.g:2318:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            {
            // InternalModelDraw.g:2318:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            // InternalModelDraw.g:2319:2: ( rule__ValuedFeature__Group_3__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_3()); 
            // InternalModelDraw.g:2320:2: ( rule__ValuedFeature__Group_3__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==35) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalModelDraw.g:2320:3: rule__ValuedFeature__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ValuedFeature__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValuedFeatureAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__3__Impl"


    // $ANTLR start "rule__ValuedFeature__Group__4"
    // InternalModelDraw.g:2328:1: rule__ValuedFeature__Group__4 : rule__ValuedFeature__Group__4__Impl ;
    public final void rule__ValuedFeature__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2332:1: ( rule__ValuedFeature__Group__4__Impl )
            // InternalModelDraw.g:2333:2: rule__ValuedFeature__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__4"


    // $ANTLR start "rule__ValuedFeature__Group__4__Impl"
    // InternalModelDraw.g:2339:1: rule__ValuedFeature__Group__4__Impl : ( ( rule__ValuedFeature__Group_4__0 )? ) ;
    public final void rule__ValuedFeature__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2343:1: ( ( ( rule__ValuedFeature__Group_4__0 )? ) )
            // InternalModelDraw.g:2344:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            {
            // InternalModelDraw.g:2344:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            // InternalModelDraw.g:2345:2: ( rule__ValuedFeature__Group_4__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_4()); 
            // InternalModelDraw.g:2346:2: ( rule__ValuedFeature__Group_4__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==41) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalModelDraw.g:2346:3: rule__ValuedFeature__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ValuedFeature__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getValuedFeatureAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group__4__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_3__0"
    // InternalModelDraw.g:2355:1: rule__ValuedFeature__Group_3__0 : rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 ;
    public final void rule__ValuedFeature__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2359:1: ( rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 )
            // InternalModelDraw.g:2360:2: rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__ValuedFeature__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__0"


    // $ANTLR start "rule__ValuedFeature__Group_3__0__Impl"
    // InternalModelDraw.g:2367:1: rule__ValuedFeature__Group_3__0__Impl : ( '->' ) ;
    public final void rule__ValuedFeature__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2371:1: ( ( '->' ) )
            // InternalModelDraw.g:2372:1: ( '->' )
            {
            // InternalModelDraw.g:2372:1: ( '->' )
            // InternalModelDraw.g:2373:2: '->'
            {
             before(grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getHyphenMinusGreaterThanSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__0__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_3__1"
    // InternalModelDraw.g:2382:1: rule__ValuedFeature__Group_3__1 : rule__ValuedFeature__Group_3__1__Impl ;
    public final void rule__ValuedFeature__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2386:1: ( rule__ValuedFeature__Group_3__1__Impl )
            // InternalModelDraw.g:2387:2: rule__ValuedFeature__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__1"


    // $ANTLR start "rule__ValuedFeature__Group_3__1__Impl"
    // InternalModelDraw.g:2393:1: rule__ValuedFeature__Group_3__1__Impl : ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) ;
    public final void rule__ValuedFeature__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2397:1: ( ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) )
            // InternalModelDraw.g:2398:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            {
            // InternalModelDraw.g:2398:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            // InternalModelDraw.g:2399:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureAssignment_3_1()); 
            // InternalModelDraw.g:2400:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            // InternalModelDraw.g:2400:3: rule__ValuedFeature__RefFeatureAssignment_3_1
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__RefFeatureAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getRefFeatureAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_3__1__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_4__0"
    // InternalModelDraw.g:2409:1: rule__ValuedFeature__Group_4__0 : rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 ;
    public final void rule__ValuedFeature__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2413:1: ( rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 )
            // InternalModelDraw.g:2414:2: rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1
            {
            pushFollow(FOLLOW_24);
            rule__ValuedFeature__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__0"


    // $ANTLR start "rule__ValuedFeature__Group_4__0__Impl"
    // InternalModelDraw.g:2421:1: rule__ValuedFeature__Group_4__0__Impl : ( '==' ) ;
    public final void rule__ValuedFeature__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2425:1: ( ( '==' ) )
            // InternalModelDraw.g:2426:1: ( '==' )
            {
            // InternalModelDraw.g:2426:1: ( '==' )
            // InternalModelDraw.g:2427:2: '=='
            {
             before(grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getEqualsSignEqualsSignKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__0__Impl"


    // $ANTLR start "rule__ValuedFeature__Group_4__1"
    // InternalModelDraw.g:2436:1: rule__ValuedFeature__Group_4__1 : rule__ValuedFeature__Group_4__1__Impl ;
    public final void rule__ValuedFeature__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2440:1: ( rule__ValuedFeature__Group_4__1__Impl )
            // InternalModelDraw.g:2441:2: rule__ValuedFeature__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__1"


    // $ANTLR start "rule__ValuedFeature__Group_4__1__Impl"
    // InternalModelDraw.g:2447:1: rule__ValuedFeature__Group_4__1__Impl : ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) ;
    public final void rule__ValuedFeature__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2451:1: ( ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) )
            // InternalModelDraw.g:2452:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            {
            // InternalModelDraw.g:2452:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            // InternalModelDraw.g:2453:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueAssignment_4_1()); 
            // InternalModelDraw.g:2454:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            // InternalModelDraw.g:2454:3: rule__ValuedFeature__ValueAssignment_4_1
            {
            pushFollow(FOLLOW_2);
            rule__ValuedFeature__ValueAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getValuedFeatureAccess().getValueAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__Group_4__1__Impl"


    // $ANTLR start "rule__Edge__Group__0"
    // InternalModelDraw.g:2463:1: rule__Edge__Group__0 : rule__Edge__Group__0__Impl rule__Edge__Group__1 ;
    public final void rule__Edge__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2467:1: ( rule__Edge__Group__0__Impl rule__Edge__Group__1 )
            // InternalModelDraw.g:2468:2: rule__Edge__Group__0__Impl rule__Edge__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__0"


    // $ANTLR start "rule__Edge__Group__0__Impl"
    // InternalModelDraw.g:2475:1: rule__Edge__Group__0__Impl : ( () ) ;
    public final void rule__Edge__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2479:1: ( ( () ) )
            // InternalModelDraw.g:2480:1: ( () )
            {
            // InternalModelDraw.g:2480:1: ( () )
            // InternalModelDraw.g:2481:2: ()
            {
             before(grammarAccess.getEdgeAccess().getEdgeAction_0()); 
            // InternalModelDraw.g:2482:2: ()
            // InternalModelDraw.g:2482:3: 
            {
            }

             after(grammarAccess.getEdgeAccess().getEdgeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__0__Impl"


    // $ANTLR start "rule__Edge__Group__1"
    // InternalModelDraw.g:2490:1: rule__Edge__Group__1 : rule__Edge__Group__1__Impl rule__Edge__Group__2 ;
    public final void rule__Edge__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2494:1: ( rule__Edge__Group__1__Impl rule__Edge__Group__2 )
            // InternalModelDraw.g:2495:2: rule__Edge__Group__1__Impl rule__Edge__Group__2
            {
            pushFollow(FOLLOW_25);
            rule__Edge__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__1"


    // $ANTLR start "rule__Edge__Group__1__Impl"
    // InternalModelDraw.g:2502:1: rule__Edge__Group__1__Impl : ( ( rule__Edge__NameAssignment_1 ) ) ;
    public final void rule__Edge__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2506:1: ( ( ( rule__Edge__NameAssignment_1 ) ) )
            // InternalModelDraw.g:2507:1: ( ( rule__Edge__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:2507:1: ( ( rule__Edge__NameAssignment_1 ) )
            // InternalModelDraw.g:2508:2: ( rule__Edge__NameAssignment_1 )
            {
             before(grammarAccess.getEdgeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:2509:2: ( rule__Edge__NameAssignment_1 )
            // InternalModelDraw.g:2509:3: rule__Edge__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__1__Impl"


    // $ANTLR start "rule__Edge__Group__2"
    // InternalModelDraw.g:2517:1: rule__Edge__Group__2 : rule__Edge__Group__2__Impl rule__Edge__Group__3 ;
    public final void rule__Edge__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2521:1: ( rule__Edge__Group__2__Impl rule__Edge__Group__3 )
            // InternalModelDraw.g:2522:2: rule__Edge__Group__2__Impl rule__Edge__Group__3
            {
            pushFollow(FOLLOW_25);
            rule__Edge__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__2"


    // $ANTLR start "rule__Edge__Group__2__Impl"
    // InternalModelDraw.g:2529:1: rule__Edge__Group__2__Impl : ( ( rule__Edge__Group_2__0 )? ) ;
    public final void rule__Edge__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2533:1: ( ( ( rule__Edge__Group_2__0 )? ) )
            // InternalModelDraw.g:2534:1: ( ( rule__Edge__Group_2__0 )? )
            {
            // InternalModelDraw.g:2534:1: ( ( rule__Edge__Group_2__0 )? )
            // InternalModelDraw.g:2535:2: ( rule__Edge__Group_2__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_2()); 
            // InternalModelDraw.g:2536:2: ( rule__Edge__Group_2__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==32) ) {
                int LA28_1 = input.LA(2);

                if ( (LA28_1==52) ) {
                    alt28=1;
                }
                else if ( (LA28_1==RULE_ID) ) {
                    int LA28_4 = input.LA(3);

                    if ( (LA28_4==34) ) {
                        int LA28_5 = input.LA(4);

                        if ( (LA28_5==52) ) {
                            alt28=1;
                        }
                        else if ( (LA28_5==RULE_ID) ) {
                            int LA28_6 = input.LA(5);

                            if ( ((LA28_6>=34 && LA28_6<=35)||LA28_6==41) ) {
                                alt28=1;
                            }
                            else if ( (LA28_6==33) ) {
                                int LA28_7 = input.LA(6);

                                if ( (LA28_7==32||LA28_7==35) ) {
                                    alt28=1;
                                }
                            }
                        }
                    }
                    else if ( (LA28_4==33||LA28_4==35||LA28_4==41) ) {
                        alt28=1;
                    }
                }
            }
            switch (alt28) {
                case 1 :
                    // InternalModelDraw.g:2536:3: rule__Edge__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__2__Impl"


    // $ANTLR start "rule__Edge__Group__3"
    // InternalModelDraw.g:2544:1: rule__Edge__Group__3 : rule__Edge__Group__3__Impl rule__Edge__Group__4 ;
    public final void rule__Edge__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2548:1: ( rule__Edge__Group__3__Impl rule__Edge__Group__4 )
            // InternalModelDraw.g:2549:2: rule__Edge__Group__3__Impl rule__Edge__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Edge__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__3"


    // $ANTLR start "rule__Edge__Group__3__Impl"
    // InternalModelDraw.g:2556:1: rule__Edge__Group__3__Impl : ( ( rule__Edge__Alternatives_3 ) ) ;
    public final void rule__Edge__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2560:1: ( ( ( rule__Edge__Alternatives_3 ) ) )
            // InternalModelDraw.g:2561:1: ( ( rule__Edge__Alternatives_3 ) )
            {
            // InternalModelDraw.g:2561:1: ( ( rule__Edge__Alternatives_3 ) )
            // InternalModelDraw.g:2562:2: ( rule__Edge__Alternatives_3 )
            {
             before(grammarAccess.getEdgeAccess().getAlternatives_3()); 
            // InternalModelDraw.g:2563:2: ( rule__Edge__Alternatives_3 )
            // InternalModelDraw.g:2563:3: rule__Edge__Alternatives_3
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Alternatives_3();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getAlternatives_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__3__Impl"


    // $ANTLR start "rule__Edge__Group__4"
    // InternalModelDraw.g:2571:1: rule__Edge__Group__4 : rule__Edge__Group__4__Impl rule__Edge__Group__5 ;
    public final void rule__Edge__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2575:1: ( rule__Edge__Group__4__Impl rule__Edge__Group__5 )
            // InternalModelDraw.g:2576:2: rule__Edge__Group__4__Impl rule__Edge__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__Edge__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__4"


    // $ANTLR start "rule__Edge__Group__4__Impl"
    // InternalModelDraw.g:2583:1: rule__Edge__Group__4__Impl : ( ':' ) ;
    public final void rule__Edge__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2587:1: ( ( ':' ) )
            // InternalModelDraw.g:2588:1: ( ':' )
            {
            // InternalModelDraw.g:2588:1: ( ':' )
            // InternalModelDraw.g:2589:2: ':'
            {
             before(grammarAccess.getEdgeAccess().getColonKeyword_4()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__4__Impl"


    // $ANTLR start "rule__Edge__Group__5"
    // InternalModelDraw.g:2598:1: rule__Edge__Group__5 : rule__Edge__Group__5__Impl rule__Edge__Group__6 ;
    public final void rule__Edge__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2602:1: ( rule__Edge__Group__5__Impl rule__Edge__Group__6 )
            // InternalModelDraw.g:2603:2: rule__Edge__Group__5__Impl rule__Edge__Group__6
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__5"


    // $ANTLR start "rule__Edge__Group__5__Impl"
    // InternalModelDraw.g:2610:1: rule__Edge__Group__5__Impl : ( 'edge' ) ;
    public final void rule__Edge__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2614:1: ( ( 'edge' ) )
            // InternalModelDraw.g:2615:1: ( 'edge' )
            {
            // InternalModelDraw.g:2615:1: ( 'edge' )
            // InternalModelDraw.g:2616:2: 'edge'
            {
             before(grammarAccess.getEdgeAccess().getEdgeKeyword_5()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEdgeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__5__Impl"


    // $ANTLR start "rule__Edge__Group__6"
    // InternalModelDraw.g:2625:1: rule__Edge__Group__6 : rule__Edge__Group__6__Impl rule__Edge__Group__7 ;
    public final void rule__Edge__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2629:1: ( rule__Edge__Group__6__Impl rule__Edge__Group__7 )
            // InternalModelDraw.g:2630:2: rule__Edge__Group__6__Impl rule__Edge__Group__7
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__6"


    // $ANTLR start "rule__Edge__Group__6__Impl"
    // InternalModelDraw.g:2637:1: rule__Edge__Group__6__Impl : ( ( rule__Edge__Group_6__0 )? ) ;
    public final void rule__Edge__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2641:1: ( ( ( rule__Edge__Group_6__0 )? ) )
            // InternalModelDraw.g:2642:1: ( ( rule__Edge__Group_6__0 )? )
            {
            // InternalModelDraw.g:2642:1: ( ( rule__Edge__Group_6__0 )? )
            // InternalModelDraw.g:2643:2: ( rule__Edge__Group_6__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_6()); 
            // InternalModelDraw.g:2644:2: ( rule__Edge__Group_6__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==36) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalModelDraw.g:2644:3: rule__Edge__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__6__Impl"


    // $ANTLR start "rule__Edge__Group__7"
    // InternalModelDraw.g:2652:1: rule__Edge__Group__7 : rule__Edge__Group__7__Impl rule__Edge__Group__8 ;
    public final void rule__Edge__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2656:1: ( rule__Edge__Group__7__Impl rule__Edge__Group__8 )
            // InternalModelDraw.g:2657:2: rule__Edge__Group__7__Impl rule__Edge__Group__8
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__7"


    // $ANTLR start "rule__Edge__Group__7__Impl"
    // InternalModelDraw.g:2664:1: rule__Edge__Group__7__Impl : ( ( rule__Edge__Group_7__0 )? ) ;
    public final void rule__Edge__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2668:1: ( ( ( rule__Edge__Group_7__0 )? ) )
            // InternalModelDraw.g:2669:1: ( ( rule__Edge__Group_7__0 )? )
            {
            // InternalModelDraw.g:2669:1: ( ( rule__Edge__Group_7__0 )? )
            // InternalModelDraw.g:2670:2: ( rule__Edge__Group_7__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7()); 
            // InternalModelDraw.g:2671:2: ( rule__Edge__Group_7__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==43) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalModelDraw.g:2671:3: rule__Edge__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__7__Impl"


    // $ANTLR start "rule__Edge__Group__8"
    // InternalModelDraw.g:2679:1: rule__Edge__Group__8 : rule__Edge__Group__8__Impl rule__Edge__Group__9 ;
    public final void rule__Edge__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2683:1: ( rule__Edge__Group__8__Impl rule__Edge__Group__9 )
            // InternalModelDraw.g:2684:2: rule__Edge__Group__8__Impl rule__Edge__Group__9
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__8"


    // $ANTLR start "rule__Edge__Group__8__Impl"
    // InternalModelDraw.g:2691:1: rule__Edge__Group__8__Impl : ( ( rule__Edge__Group_8__0 )? ) ;
    public final void rule__Edge__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2695:1: ( ( ( rule__Edge__Group_8__0 )? ) )
            // InternalModelDraw.g:2696:1: ( ( rule__Edge__Group_8__0 )? )
            {
            // InternalModelDraw.g:2696:1: ( ( rule__Edge__Group_8__0 )? )
            // InternalModelDraw.g:2697:2: ( rule__Edge__Group_8__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_8()); 
            // InternalModelDraw.g:2698:2: ( rule__Edge__Group_8__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==45) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalModelDraw.g:2698:3: rule__Edge__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__8__Impl"


    // $ANTLR start "rule__Edge__Group__9"
    // InternalModelDraw.g:2706:1: rule__Edge__Group__9 : rule__Edge__Group__9__Impl rule__Edge__Group__10 ;
    public final void rule__Edge__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2710:1: ( rule__Edge__Group__9__Impl rule__Edge__Group__10 )
            // InternalModelDraw.g:2711:2: rule__Edge__Group__9__Impl rule__Edge__Group__10
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__9"


    // $ANTLR start "rule__Edge__Group__9__Impl"
    // InternalModelDraw.g:2718:1: rule__Edge__Group__9__Impl : ( ( rule__Edge__Group_9__0 )? ) ;
    public final void rule__Edge__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2722:1: ( ( ( rule__Edge__Group_9__0 )? ) )
            // InternalModelDraw.g:2723:1: ( ( rule__Edge__Group_9__0 )? )
            {
            // InternalModelDraw.g:2723:1: ( ( rule__Edge__Group_9__0 )? )
            // InternalModelDraw.g:2724:2: ( rule__Edge__Group_9__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_9()); 
            // InternalModelDraw.g:2725:2: ( rule__Edge__Group_9__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==46) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalModelDraw.g:2725:3: rule__Edge__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__9__Impl"


    // $ANTLR start "rule__Edge__Group__10"
    // InternalModelDraw.g:2733:1: rule__Edge__Group__10 : rule__Edge__Group__10__Impl rule__Edge__Group__11 ;
    public final void rule__Edge__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2737:1: ( rule__Edge__Group__10__Impl rule__Edge__Group__11 )
            // InternalModelDraw.g:2738:2: rule__Edge__Group__10__Impl rule__Edge__Group__11
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__10"


    // $ANTLR start "rule__Edge__Group__10__Impl"
    // InternalModelDraw.g:2745:1: rule__Edge__Group__10__Impl : ( ( rule__Edge__Group_10__0 )? ) ;
    public final void rule__Edge__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2749:1: ( ( ( rule__Edge__Group_10__0 )? ) )
            // InternalModelDraw.g:2750:1: ( ( rule__Edge__Group_10__0 )? )
            {
            // InternalModelDraw.g:2750:1: ( ( rule__Edge__Group_10__0 )? )
            // InternalModelDraw.g:2751:2: ( rule__Edge__Group_10__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10()); 
            // InternalModelDraw.g:2752:2: ( rule__Edge__Group_10__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==47) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalModelDraw.g:2752:3: rule__Edge__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__10__Impl"


    // $ANTLR start "rule__Edge__Group__11"
    // InternalModelDraw.g:2760:1: rule__Edge__Group__11 : rule__Edge__Group__11__Impl ;
    public final void rule__Edge__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2764:1: ( rule__Edge__Group__11__Impl )
            // InternalModelDraw.g:2765:2: rule__Edge__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__11"


    // $ANTLR start "rule__Edge__Group__11__Impl"
    // InternalModelDraw.g:2771:1: rule__Edge__Group__11__Impl : ( ( rule__Edge__Group_11__0 )? ) ;
    public final void rule__Edge__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2775:1: ( ( ( rule__Edge__Group_11__0 )? ) )
            // InternalModelDraw.g:2776:1: ( ( rule__Edge__Group_11__0 )? )
            {
            // InternalModelDraw.g:2776:1: ( ( rule__Edge__Group_11__0 )? )
            // InternalModelDraw.g:2777:2: ( rule__Edge__Group_11__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_11()); 
            // InternalModelDraw.g:2778:2: ( rule__Edge__Group_11__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==48) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalModelDraw.g:2778:3: rule__Edge__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__11__Impl"


    // $ANTLR start "rule__Edge__Group_2__0"
    // InternalModelDraw.g:2787:1: rule__Edge__Group_2__0 : rule__Edge__Group_2__0__Impl rule__Edge__Group_2__1 ;
    public final void rule__Edge__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2791:1: ( rule__Edge__Group_2__0__Impl rule__Edge__Group_2__1 )
            // InternalModelDraw.g:2792:2: rule__Edge__Group_2__0__Impl rule__Edge__Group_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Edge__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__0"


    // $ANTLR start "rule__Edge__Group_2__0__Impl"
    // InternalModelDraw.g:2799:1: rule__Edge__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2803:1: ( ( '(' ) )
            // InternalModelDraw.g:2804:1: ( '(' )
            {
            // InternalModelDraw.g:2804:1: ( '(' )
            // InternalModelDraw.g:2805:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__0__Impl"


    // $ANTLR start "rule__Edge__Group_2__1"
    // InternalModelDraw.g:2814:1: rule__Edge__Group_2__1 : rule__Edge__Group_2__1__Impl rule__Edge__Group_2__2 ;
    public final void rule__Edge__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2818:1: ( rule__Edge__Group_2__1__Impl rule__Edge__Group_2__2 )
            // InternalModelDraw.g:2819:2: rule__Edge__Group_2__1__Impl rule__Edge__Group_2__2
            {
            pushFollow(FOLLOW_15);
            rule__Edge__Group_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__1"


    // $ANTLR start "rule__Edge__Group_2__1__Impl"
    // InternalModelDraw.g:2826:1: rule__Edge__Group_2__1__Impl : ( ( rule__Edge__FeatureAssignment_2_1 ) ) ;
    public final void rule__Edge__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2830:1: ( ( ( rule__Edge__FeatureAssignment_2_1 ) ) )
            // InternalModelDraw.g:2831:1: ( ( rule__Edge__FeatureAssignment_2_1 ) )
            {
            // InternalModelDraw.g:2831:1: ( ( rule__Edge__FeatureAssignment_2_1 ) )
            // InternalModelDraw.g:2832:2: ( rule__Edge__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getFeatureAssignment_2_1()); 
            // InternalModelDraw.g:2833:2: ( rule__Edge__FeatureAssignment_2_1 )
            // InternalModelDraw.g:2833:3: rule__Edge__FeatureAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__FeatureAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getFeatureAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__1__Impl"


    // $ANTLR start "rule__Edge__Group_2__2"
    // InternalModelDraw.g:2841:1: rule__Edge__Group_2__2 : rule__Edge__Group_2__2__Impl rule__Edge__Group_2__3 ;
    public final void rule__Edge__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2845:1: ( rule__Edge__Group_2__2__Impl rule__Edge__Group_2__3 )
            // InternalModelDraw.g:2846:2: rule__Edge__Group_2__2__Impl rule__Edge__Group_2__3
            {
            pushFollow(FOLLOW_15);
            rule__Edge__Group_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__2"


    // $ANTLR start "rule__Edge__Group_2__2__Impl"
    // InternalModelDraw.g:2853:1: rule__Edge__Group_2__2__Impl : ( ( rule__Edge__Group_2_2__0 )* ) ;
    public final void rule__Edge__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2857:1: ( ( ( rule__Edge__Group_2_2__0 )* ) )
            // InternalModelDraw.g:2858:1: ( ( rule__Edge__Group_2_2__0 )* )
            {
            // InternalModelDraw.g:2858:1: ( ( rule__Edge__Group_2_2__0 )* )
            // InternalModelDraw.g:2859:2: ( rule__Edge__Group_2_2__0 )*
            {
             before(grammarAccess.getEdgeAccess().getGroup_2_2()); 
            // InternalModelDraw.g:2860:2: ( rule__Edge__Group_2_2__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==34) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalModelDraw.g:2860:3: rule__Edge__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Edge__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

             after(grammarAccess.getEdgeAccess().getGroup_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__2__Impl"


    // $ANTLR start "rule__Edge__Group_2__3"
    // InternalModelDraw.g:2868:1: rule__Edge__Group_2__3 : rule__Edge__Group_2__3__Impl ;
    public final void rule__Edge__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2872:1: ( rule__Edge__Group_2__3__Impl )
            // InternalModelDraw.g:2873:2: rule__Edge__Group_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__3"


    // $ANTLR start "rule__Edge__Group_2__3__Impl"
    // InternalModelDraw.g:2879:1: rule__Edge__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2883:1: ( ( ')' ) )
            // InternalModelDraw.g:2884:1: ( ')' )
            {
            // InternalModelDraw.g:2884:1: ( ')' )
            // InternalModelDraw.g:2885:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_2_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2__3__Impl"


    // $ANTLR start "rule__Edge__Group_2_2__0"
    // InternalModelDraw.g:2895:1: rule__Edge__Group_2_2__0 : rule__Edge__Group_2_2__0__Impl rule__Edge__Group_2_2__1 ;
    public final void rule__Edge__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2899:1: ( rule__Edge__Group_2_2__0__Impl rule__Edge__Group_2_2__1 )
            // InternalModelDraw.g:2900:2: rule__Edge__Group_2_2__0__Impl rule__Edge__Group_2_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Edge__Group_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2_2__0"


    // $ANTLR start "rule__Edge__Group_2_2__0__Impl"
    // InternalModelDraw.g:2907:1: rule__Edge__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2911:1: ( ( ',' ) )
            // InternalModelDraw.g:2912:1: ( ',' )
            {
            // InternalModelDraw.g:2912:1: ( ',' )
            // InternalModelDraw.g:2913:2: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_2_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2_2__0__Impl"


    // $ANTLR start "rule__Edge__Group_2_2__1"
    // InternalModelDraw.g:2922:1: rule__Edge__Group_2_2__1 : rule__Edge__Group_2_2__1__Impl ;
    public final void rule__Edge__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2926:1: ( rule__Edge__Group_2_2__1__Impl )
            // InternalModelDraw.g:2927:2: rule__Edge__Group_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2_2__1"


    // $ANTLR start "rule__Edge__Group_2_2__1__Impl"
    // InternalModelDraw.g:2933:1: rule__Edge__Group_2_2__1__Impl : ( ( rule__Edge__FeatureAssignment_2_2_1 ) ) ;
    public final void rule__Edge__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2937:1: ( ( ( rule__Edge__FeatureAssignment_2_2_1 ) ) )
            // InternalModelDraw.g:2938:1: ( ( rule__Edge__FeatureAssignment_2_2_1 ) )
            {
            // InternalModelDraw.g:2938:1: ( ( rule__Edge__FeatureAssignment_2_2_1 ) )
            // InternalModelDraw.g:2939:2: ( rule__Edge__FeatureAssignment_2_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getFeatureAssignment_2_2_1()); 
            // InternalModelDraw.g:2940:2: ( rule__Edge__FeatureAssignment_2_2_1 )
            // InternalModelDraw.g:2940:3: rule__Edge__FeatureAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__FeatureAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getFeatureAssignment_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_2_2__1__Impl"


    // $ANTLR start "rule__Edge__Group_3_0__0"
    // InternalModelDraw.g:2949:1: rule__Edge__Group_3_0__0 : rule__Edge__Group_3_0__0__Impl rule__Edge__Group_3_0__1 ;
    public final void rule__Edge__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2953:1: ( rule__Edge__Group_3_0__0__Impl rule__Edge__Group_3_0__1 )
            // InternalModelDraw.g:2954:2: rule__Edge__Group_3_0__0__Impl rule__Edge__Group_3_0__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_3_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__0"


    // $ANTLR start "rule__Edge__Group_3_0__0__Impl"
    // InternalModelDraw.g:2961:1: rule__Edge__Group_3_0__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2965:1: ( ( '(' ) )
            // InternalModelDraw.g:2966:1: ( '(' )
            {
            // InternalModelDraw.g:2966:1: ( '(' )
            // InternalModelDraw.g:2967:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_0_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__0__Impl"


    // $ANTLR start "rule__Edge__Group_3_0__1"
    // InternalModelDraw.g:2976:1: rule__Edge__Group_3_0__1 : rule__Edge__Group_3_0__1__Impl rule__Edge__Group_3_0__2 ;
    public final void rule__Edge__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2980:1: ( rule__Edge__Group_3_0__1__Impl rule__Edge__Group_3_0__2 )
            // InternalModelDraw.g:2981:2: rule__Edge__Group_3_0__1__Impl rule__Edge__Group_3_0__2
            {
            pushFollow(FOLLOW_28);
            rule__Edge__Group_3_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__1"


    // $ANTLR start "rule__Edge__Group_3_0__1__Impl"
    // InternalModelDraw.g:2988:1: rule__Edge__Group_3_0__1__Impl : ( ( rule__Edge__SourceAssignment_3_0_1 ) ) ;
    public final void rule__Edge__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2992:1: ( ( ( rule__Edge__SourceAssignment_3_0_1 ) ) )
            // InternalModelDraw.g:2993:1: ( ( rule__Edge__SourceAssignment_3_0_1 ) )
            {
            // InternalModelDraw.g:2993:1: ( ( rule__Edge__SourceAssignment_3_0_1 ) )
            // InternalModelDraw.g:2994:2: ( rule__Edge__SourceAssignment_3_0_1 )
            {
             before(grammarAccess.getEdgeAccess().getSourceAssignment_3_0_1()); 
            // InternalModelDraw.g:2995:2: ( rule__Edge__SourceAssignment_3_0_1 )
            // InternalModelDraw.g:2995:3: rule__Edge__SourceAssignment_3_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__SourceAssignment_3_0_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getSourceAssignment_3_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__1__Impl"


    // $ANTLR start "rule__Edge__Group_3_0__2"
    // InternalModelDraw.g:3003:1: rule__Edge__Group_3_0__2 : rule__Edge__Group_3_0__2__Impl rule__Edge__Group_3_0__3 ;
    public final void rule__Edge__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3007:1: ( rule__Edge__Group_3_0__2__Impl rule__Edge__Group_3_0__3 )
            // InternalModelDraw.g:3008:2: rule__Edge__Group_3_0__2__Impl rule__Edge__Group_3_0__3
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_3_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__2"


    // $ANTLR start "rule__Edge__Group_3_0__2__Impl"
    // InternalModelDraw.g:3015:1: rule__Edge__Group_3_0__2__Impl : ( ',' ) ;
    public final void rule__Edge__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3019:1: ( ( ',' ) )
            // InternalModelDraw.g:3020:1: ( ',' )
            {
            // InternalModelDraw.g:3020:1: ( ',' )
            // InternalModelDraw.g:3021:2: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_3_0_2()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_3_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__2__Impl"


    // $ANTLR start "rule__Edge__Group_3_0__3"
    // InternalModelDraw.g:3030:1: rule__Edge__Group_3_0__3 : rule__Edge__Group_3_0__3__Impl rule__Edge__Group_3_0__4 ;
    public final void rule__Edge__Group_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3034:1: ( rule__Edge__Group_3_0__3__Impl rule__Edge__Group_3_0__4 )
            // InternalModelDraw.g:3035:2: rule__Edge__Group_3_0__3__Impl rule__Edge__Group_3_0__4
            {
            pushFollow(FOLLOW_20);
            rule__Edge__Group_3_0__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__3"


    // $ANTLR start "rule__Edge__Group_3_0__3__Impl"
    // InternalModelDraw.g:3042:1: rule__Edge__Group_3_0__3__Impl : ( ( rule__Edge__TargetAssignment_3_0_3 ) ) ;
    public final void rule__Edge__Group_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3046:1: ( ( ( rule__Edge__TargetAssignment_3_0_3 ) ) )
            // InternalModelDraw.g:3047:1: ( ( rule__Edge__TargetAssignment_3_0_3 ) )
            {
            // InternalModelDraw.g:3047:1: ( ( rule__Edge__TargetAssignment_3_0_3 ) )
            // InternalModelDraw.g:3048:2: ( rule__Edge__TargetAssignment_3_0_3 )
            {
             before(grammarAccess.getEdgeAccess().getTargetAssignment_3_0_3()); 
            // InternalModelDraw.g:3049:2: ( rule__Edge__TargetAssignment_3_0_3 )
            // InternalModelDraw.g:3049:3: rule__Edge__TargetAssignment_3_0_3
            {
            pushFollow(FOLLOW_2);
            rule__Edge__TargetAssignment_3_0_3();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTargetAssignment_3_0_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__3__Impl"


    // $ANTLR start "rule__Edge__Group_3_0__4"
    // InternalModelDraw.g:3057:1: rule__Edge__Group_3_0__4 : rule__Edge__Group_3_0__4__Impl ;
    public final void rule__Edge__Group_3_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3061:1: ( rule__Edge__Group_3_0__4__Impl )
            // InternalModelDraw.g:3062:2: rule__Edge__Group_3_0__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__4"


    // $ANTLR start "rule__Edge__Group_3_0__4__Impl"
    // InternalModelDraw.g:3068:1: rule__Edge__Group_3_0__4__Impl : ( ')' ) ;
    public final void rule__Edge__Group_3_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3072:1: ( ( ')' ) )
            // InternalModelDraw.g:3073:1: ( ')' )
            {
            // InternalModelDraw.g:3073:1: ( ')' )
            // InternalModelDraw.g:3074:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_0_4()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_0_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0__4__Impl"


    // $ANTLR start "rule__Edge__Group_3_1__0"
    // InternalModelDraw.g:3084:1: rule__Edge__Group_3_1__0 : rule__Edge__Group_3_1__0__Impl rule__Edge__Group_3_1__1 ;
    public final void rule__Edge__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3088:1: ( rule__Edge__Group_3_1__0__Impl rule__Edge__Group_3_1__1 )
            // InternalModelDraw.g:3089:2: rule__Edge__Group_3_1__0__Impl rule__Edge__Group_3_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1__0"


    // $ANTLR start "rule__Edge__Group_3_1__0__Impl"
    // InternalModelDraw.g:3096:1: rule__Edge__Group_3_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3100:1: ( ( '->' ) )
            // InternalModelDraw.g:3101:1: ( '->' )
            {
            // InternalModelDraw.g:3101:1: ( '->' )
            // InternalModelDraw.g:3102:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_3_1__1"
    // InternalModelDraw.g:3111:1: rule__Edge__Group_3_1__1 : rule__Edge__Group_3_1__1__Impl rule__Edge__Group_3_1__2 ;
    public final void rule__Edge__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3115:1: ( rule__Edge__Group_3_1__1__Impl rule__Edge__Group_3_1__2 )
            // InternalModelDraw.g:3116:2: rule__Edge__Group_3_1__1__Impl rule__Edge__Group_3_1__2
            {
            pushFollow(FOLLOW_17);
            rule__Edge__Group_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1__1"


    // $ANTLR start "rule__Edge__Group_3_1__1__Impl"
    // InternalModelDraw.g:3123:1: rule__Edge__Group_3_1__1__Impl : ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) ) ;
    public final void rule__Edge__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3127:1: ( ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) ) )
            // InternalModelDraw.g:3128:1: ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) )
            {
            // InternalModelDraw.g:3128:1: ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) )
            // InternalModelDraw.g:3129:2: ( rule__Edge__TargetNodeAssignment_3_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getTargetNodeAssignment_3_1_1()); 
            // InternalModelDraw.g:3130:2: ( rule__Edge__TargetNodeAssignment_3_1_1 )
            // InternalModelDraw.g:3130:3: rule__Edge__TargetNodeAssignment_3_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__TargetNodeAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTargetNodeAssignment_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_3_1__2"
    // InternalModelDraw.g:3138:1: rule__Edge__Group_3_1__2 : rule__Edge__Group_3_1__2__Impl ;
    public final void rule__Edge__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3142:1: ( rule__Edge__Group_3_1__2__Impl )
            // InternalModelDraw.g:3143:2: rule__Edge__Group_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1__2"


    // $ANTLR start "rule__Edge__Group_3_1__2__Impl"
    // InternalModelDraw.g:3149:1: rule__Edge__Group_3_1__2__Impl : ( ( rule__Edge__Group_3_1_2__0 )? ) ;
    public final void rule__Edge__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3153:1: ( ( ( rule__Edge__Group_3_1_2__0 )? ) )
            // InternalModelDraw.g:3154:1: ( ( rule__Edge__Group_3_1_2__0 )? )
            {
            // InternalModelDraw.g:3154:1: ( ( rule__Edge__Group_3_1_2__0 )? )
            // InternalModelDraw.g:3155:2: ( rule__Edge__Group_3_1_2__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_3_1_2()); 
            // InternalModelDraw.g:3156:2: ( rule__Edge__Group_3_1_2__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==32) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalModelDraw.g:3156:3: rule__Edge__Group_3_1_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_3_1_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_3_1_2__0"
    // InternalModelDraw.g:3165:1: rule__Edge__Group_3_1_2__0 : rule__Edge__Group_3_1_2__0__Impl rule__Edge__Group_3_1_2__1 ;
    public final void rule__Edge__Group_3_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3169:1: ( rule__Edge__Group_3_1_2__0__Impl rule__Edge__Group_3_1_2__1 )
            // InternalModelDraw.g:3170:2: rule__Edge__Group_3_1_2__0__Impl rule__Edge__Group_3_1_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Edge__Group_3_1_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__0"


    // $ANTLR start "rule__Edge__Group_3_1_2__0__Impl"
    // InternalModelDraw.g:3177:1: rule__Edge__Group_3_1_2__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_3_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3181:1: ( ( '(' ) )
            // InternalModelDraw.g:3182:1: ( '(' )
            {
            // InternalModelDraw.g:3182:1: ( '(' )
            // InternalModelDraw.g:3183:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_1_2_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_3_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__0__Impl"


    // $ANTLR start "rule__Edge__Group_3_1_2__1"
    // InternalModelDraw.g:3192:1: rule__Edge__Group_3_1_2__1 : rule__Edge__Group_3_1_2__1__Impl rule__Edge__Group_3_1_2__2 ;
    public final void rule__Edge__Group_3_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3196:1: ( rule__Edge__Group_3_1_2__1__Impl rule__Edge__Group_3_1_2__2 )
            // InternalModelDraw.g:3197:2: rule__Edge__Group_3_1_2__1__Impl rule__Edge__Group_3_1_2__2
            {
            pushFollow(FOLLOW_15);
            rule__Edge__Group_3_1_2__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1_2__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__1"


    // $ANTLR start "rule__Edge__Group_3_1_2__1__Impl"
    // InternalModelDraw.g:3204:1: rule__Edge__Group_3_1_2__1__Impl : ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) ) ;
    public final void rule__Edge__Group_3_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3208:1: ( ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) ) )
            // InternalModelDraw.g:3209:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) )
            {
            // InternalModelDraw.g:3209:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) )
            // InternalModelDraw.g:3210:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getTargetFeatureAssignment_3_1_2_1()); 
            // InternalModelDraw.g:3211:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_1 )
            // InternalModelDraw.g:3211:3: rule__Edge__TargetFeatureAssignment_3_1_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__TargetFeatureAssignment_3_1_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTargetFeatureAssignment_3_1_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__1__Impl"


    // $ANTLR start "rule__Edge__Group_3_1_2__2"
    // InternalModelDraw.g:3219:1: rule__Edge__Group_3_1_2__2 : rule__Edge__Group_3_1_2__2__Impl rule__Edge__Group_3_1_2__3 ;
    public final void rule__Edge__Group_3_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3223:1: ( rule__Edge__Group_3_1_2__2__Impl rule__Edge__Group_3_1_2__3 )
            // InternalModelDraw.g:3224:2: rule__Edge__Group_3_1_2__2__Impl rule__Edge__Group_3_1_2__3
            {
            pushFollow(FOLLOW_15);
            rule__Edge__Group_3_1_2__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1_2__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__2"


    // $ANTLR start "rule__Edge__Group_3_1_2__2__Impl"
    // InternalModelDraw.g:3231:1: rule__Edge__Group_3_1_2__2__Impl : ( ( rule__Edge__Group_3_1_2_2__0 )* ) ;
    public final void rule__Edge__Group_3_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3235:1: ( ( ( rule__Edge__Group_3_1_2_2__0 )* ) )
            // InternalModelDraw.g:3236:1: ( ( rule__Edge__Group_3_1_2_2__0 )* )
            {
            // InternalModelDraw.g:3236:1: ( ( rule__Edge__Group_3_1_2_2__0 )* )
            // InternalModelDraw.g:3237:2: ( rule__Edge__Group_3_1_2_2__0 )*
            {
             before(grammarAccess.getEdgeAccess().getGroup_3_1_2_2()); 
            // InternalModelDraw.g:3238:2: ( rule__Edge__Group_3_1_2_2__0 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==34) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalModelDraw.g:3238:3: rule__Edge__Group_3_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Edge__Group_3_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

             after(grammarAccess.getEdgeAccess().getGroup_3_1_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__2__Impl"


    // $ANTLR start "rule__Edge__Group_3_1_2__3"
    // InternalModelDraw.g:3246:1: rule__Edge__Group_3_1_2__3 : rule__Edge__Group_3_1_2__3__Impl ;
    public final void rule__Edge__Group_3_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3250:1: ( rule__Edge__Group_3_1_2__3__Impl )
            // InternalModelDraw.g:3251:2: rule__Edge__Group_3_1_2__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1_2__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__3"


    // $ANTLR start "rule__Edge__Group_3_1_2__3__Impl"
    // InternalModelDraw.g:3257:1: rule__Edge__Group_3_1_2__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_3_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3261:1: ( ( ')' ) )
            // InternalModelDraw.g:3262:1: ( ')' )
            {
            // InternalModelDraw.g:3262:1: ( ')' )
            // InternalModelDraw.g:3263:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_1_2_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_1_2_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2__3__Impl"


    // $ANTLR start "rule__Edge__Group_3_1_2_2__0"
    // InternalModelDraw.g:3273:1: rule__Edge__Group_3_1_2_2__0 : rule__Edge__Group_3_1_2_2__0__Impl rule__Edge__Group_3_1_2_2__1 ;
    public final void rule__Edge__Group_3_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3277:1: ( rule__Edge__Group_3_1_2_2__0__Impl rule__Edge__Group_3_1_2_2__1 )
            // InternalModelDraw.g:3278:2: rule__Edge__Group_3_1_2_2__0__Impl rule__Edge__Group_3_1_2_2__1
            {
            pushFollow(FOLLOW_14);
            rule__Edge__Group_3_1_2_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1_2_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2_2__0"


    // $ANTLR start "rule__Edge__Group_3_1_2_2__0__Impl"
    // InternalModelDraw.g:3285:1: rule__Edge__Group_3_1_2_2__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_3_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3289:1: ( ( ',' ) )
            // InternalModelDraw.g:3290:1: ( ',' )
            {
            // InternalModelDraw.g:3290:1: ( ',' )
            // InternalModelDraw.g:3291:2: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_3_1_2_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_3_1_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2_2__0__Impl"


    // $ANTLR start "rule__Edge__Group_3_1_2_2__1"
    // InternalModelDraw.g:3300:1: rule__Edge__Group_3_1_2_2__1 : rule__Edge__Group_3_1_2_2__1__Impl ;
    public final void rule__Edge__Group_3_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3304:1: ( rule__Edge__Group_3_1_2_2__1__Impl )
            // InternalModelDraw.g:3305:2: rule__Edge__Group_3_1_2_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_1_2_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2_2__1"


    // $ANTLR start "rule__Edge__Group_3_1_2_2__1__Impl"
    // InternalModelDraw.g:3311:1: rule__Edge__Group_3_1_2_2__1__Impl : ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) ) ;
    public final void rule__Edge__Group_3_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3315:1: ( ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) ) )
            // InternalModelDraw.g:3316:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) )
            {
            // InternalModelDraw.g:3316:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) )
            // InternalModelDraw.g:3317:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getTargetFeatureAssignment_3_1_2_2_1()); 
            // InternalModelDraw.g:3318:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 )
            // InternalModelDraw.g:3318:3: rule__Edge__TargetFeatureAssignment_3_1_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__TargetFeatureAssignment_3_1_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTargetFeatureAssignment_3_1_2_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_1_2_2__1__Impl"


    // $ANTLR start "rule__Edge__Group_6__0"
    // InternalModelDraw.g:3327:1: rule__Edge__Group_6__0 : rule__Edge__Group_6__0__Impl rule__Edge__Group_6__1 ;
    public final void rule__Edge__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3331:1: ( rule__Edge__Group_6__0__Impl rule__Edge__Group_6__1 )
            // InternalModelDraw.g:3332:2: rule__Edge__Group_6__0__Impl rule__Edge__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_6__0"


    // $ANTLR start "rule__Edge__Group_6__0__Impl"
    // InternalModelDraw.g:3339:1: rule__Edge__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Edge__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3343:1: ( ( '=' ) )
            // InternalModelDraw.g:3344:1: ( '=' )
            {
            // InternalModelDraw.g:3344:1: ( '=' )
            // InternalModelDraw.g:3345:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_6_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_6__0__Impl"


    // $ANTLR start "rule__Edge__Group_6__1"
    // InternalModelDraw.g:3354:1: rule__Edge__Group_6__1 : rule__Edge__Group_6__1__Impl ;
    public final void rule__Edge__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3358:1: ( rule__Edge__Group_6__1__Impl )
            // InternalModelDraw.g:3359:2: rule__Edge__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_6__1"


    // $ANTLR start "rule__Edge__Group_6__1__Impl"
    // InternalModelDraw.g:3365:1: rule__Edge__Group_6__1__Impl : ( ( rule__Edge__AttNameAssignment_6_1 ) ) ;
    public final void rule__Edge__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3369:1: ( ( ( rule__Edge__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:3370:1: ( ( rule__Edge__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:3370:1: ( ( rule__Edge__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:3371:2: ( rule__Edge__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getEdgeAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:3372:2: ( rule__Edge__AttNameAssignment_6_1 )
            // InternalModelDraw.g:3372:3: rule__Edge__AttNameAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__AttNameAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getAttNameAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_6__1__Impl"


    // $ANTLR start "rule__Edge__Group_7__0"
    // InternalModelDraw.g:3381:1: rule__Edge__Group_7__0 : rule__Edge__Group_7__0__Impl rule__Edge__Group_7__1 ;
    public final void rule__Edge__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3385:1: ( rule__Edge__Group_7__0__Impl rule__Edge__Group_7__1 )
            // InternalModelDraw.g:3386:2: rule__Edge__Group_7__0__Impl rule__Edge__Group_7__1
            {
            pushFollow(FOLLOW_18);
            rule__Edge__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7__0"


    // $ANTLR start "rule__Edge__Group_7__0__Impl"
    // InternalModelDraw.g:3393:1: rule__Edge__Group_7__0__Impl : ( 'label' ) ;
    public final void rule__Edge__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3397:1: ( ( 'label' ) )
            // InternalModelDraw.g:3398:1: ( 'label' )
            {
            // InternalModelDraw.g:3398:1: ( 'label' )
            // InternalModelDraw.g:3399:2: 'label'
            {
             before(grammarAccess.getEdgeAccess().getLabelKeyword_7_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7__0__Impl"


    // $ANTLR start "rule__Edge__Group_7__1"
    // InternalModelDraw.g:3408:1: rule__Edge__Group_7__1 : rule__Edge__Group_7__1__Impl rule__Edge__Group_7__2 ;
    public final void rule__Edge__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3412:1: ( rule__Edge__Group_7__1__Impl rule__Edge__Group_7__2 )
            // InternalModelDraw.g:3413:2: rule__Edge__Group_7__1__Impl rule__Edge__Group_7__2
            {
            pushFollow(FOLLOW_29);
            rule__Edge__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7__1"


    // $ANTLR start "rule__Edge__Group_7__1__Impl"
    // InternalModelDraw.g:3420:1: rule__Edge__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3424:1: ( ( '=' ) )
            // InternalModelDraw.g:3425:1: ( '=' )
            {
            // InternalModelDraw.g:3425:1: ( '=' )
            // InternalModelDraw.g:3426:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_7_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7__1__Impl"


    // $ANTLR start "rule__Edge__Group_7__2"
    // InternalModelDraw.g:3435:1: rule__Edge__Group_7__2 : rule__Edge__Group_7__2__Impl ;
    public final void rule__Edge__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3439:1: ( rule__Edge__Group_7__2__Impl )
            // InternalModelDraw.g:3440:2: rule__Edge__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7__2"


    // $ANTLR start "rule__Edge__Group_7__2__Impl"
    // InternalModelDraw.g:3446:1: rule__Edge__Group_7__2__Impl : ( ( rule__Edge__Alternatives_7_2 ) ) ;
    public final void rule__Edge__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3450:1: ( ( ( rule__Edge__Alternatives_7_2 ) ) )
            // InternalModelDraw.g:3451:1: ( ( rule__Edge__Alternatives_7_2 ) )
            {
            // InternalModelDraw.g:3451:1: ( ( rule__Edge__Alternatives_7_2 ) )
            // InternalModelDraw.g:3452:2: ( rule__Edge__Alternatives_7_2 )
            {
             before(grammarAccess.getEdgeAccess().getAlternatives_7_2()); 
            // InternalModelDraw.g:3453:2: ( rule__Edge__Alternatives_7_2 )
            // InternalModelDraw.g:3453:3: rule__Edge__Alternatives_7_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Alternatives_7_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getAlternatives_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_0__0"
    // InternalModelDraw.g:3462:1: rule__Edge__Group_7_2_0__0 : rule__Edge__Group_7_2_0__0__Impl rule__Edge__Group_7_2_0__1 ;
    public final void rule__Edge__Group_7_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3466:1: ( rule__Edge__Group_7_2_0__0__Impl rule__Edge__Group_7_2_0__1 )
            // InternalModelDraw.g:3467:2: rule__Edge__Group_7_2_0__0__Impl rule__Edge__Group_7_2_0__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0__0"


    // $ANTLR start "rule__Edge__Group_7_2_0__0__Impl"
    // InternalModelDraw.g:3474:1: rule__Edge__Group_7_2_0__0__Impl : ( ( rule__Edge__Group_7_2_0_0__0 )? ) ;
    public final void rule__Edge__Group_7_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3478:1: ( ( ( rule__Edge__Group_7_2_0_0__0 )? ) )
            // InternalModelDraw.g:3479:1: ( ( rule__Edge__Group_7_2_0_0__0 )? )
            {
            // InternalModelDraw.g:3479:1: ( ( rule__Edge__Group_7_2_0_0__0 )? )
            // InternalModelDraw.g:3480:2: ( rule__Edge__Group_7_2_0_0__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_0_0()); 
            // InternalModelDraw.g:3481:2: ( rule__Edge__Group_7_2_0_0__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==35||LA38_1==44) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalModelDraw.g:3481:3: rule__Edge__Group_7_2_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_0_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_0__1"
    // InternalModelDraw.g:3489:1: rule__Edge__Group_7_2_0__1 : rule__Edge__Group_7_2_0__1__Impl ;
    public final void rule__Edge__Group_7_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3493:1: ( rule__Edge__Group_7_2_0__1__Impl )
            // InternalModelDraw.g:3494:2: rule__Edge__Group_7_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0__1"


    // $ANTLR start "rule__Edge__Group_7_2_0__1__Impl"
    // InternalModelDraw.g:3500:1: rule__Edge__Group_7_2_0__1__Impl : ( ( rule__Edge__LabelAssignment_7_2_0_1 ) ) ;
    public final void rule__Edge__Group_7_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3504:1: ( ( ( rule__Edge__LabelAssignment_7_2_0_1 ) ) )
            // InternalModelDraw.g:3505:1: ( ( rule__Edge__LabelAssignment_7_2_0_1 ) )
            {
            // InternalModelDraw.g:3505:1: ( ( rule__Edge__LabelAssignment_7_2_0_1 ) )
            // InternalModelDraw.g:3506:2: ( rule__Edge__LabelAssignment_7_2_0_1 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_0_1()); 
            // InternalModelDraw.g:3507:2: ( rule__Edge__LabelAssignment_7_2_0_1 )
            // InternalModelDraw.g:3507:3: rule__Edge__LabelAssignment_7_2_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_7_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_0_0__0"
    // InternalModelDraw.g:3516:1: rule__Edge__Group_7_2_0_0__0 : rule__Edge__Group_7_2_0_0__0__Impl rule__Edge__Group_7_2_0_0__1 ;
    public final void rule__Edge__Group_7_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3520:1: ( rule__Edge__Group_7_2_0_0__0__Impl rule__Edge__Group_7_2_0_0__1 )
            // InternalModelDraw.g:3521:2: rule__Edge__Group_7_2_0_0__0__Impl rule__Edge__Group_7_2_0_0__1
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0__0"


    // $ANTLR start "rule__Edge__Group_7_2_0_0__0__Impl"
    // InternalModelDraw.g:3528:1: rule__Edge__Group_7_2_0_0__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) ) ;
    public final void rule__Edge__Group_7_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3532:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) ) )
            // InternalModelDraw.g:3533:1: ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) )
            {
            // InternalModelDraw.g:3533:1: ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) )
            // InternalModelDraw.g:3534:2: ( rule__Edge__ReferenceAssignment_7_2_0_0_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_0_0_0()); 
            // InternalModelDraw.g:3535:2: ( rule__Edge__ReferenceAssignment_7_2_0_0_0 )
            // InternalModelDraw.g:3535:3: rule__Edge__ReferenceAssignment_7_2_0_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_7_2_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_0_0__1"
    // InternalModelDraw.g:3543:1: rule__Edge__Group_7_2_0_0__1 : rule__Edge__Group_7_2_0_0__1__Impl rule__Edge__Group_7_2_0_0__2 ;
    public final void rule__Edge__Group_7_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3547:1: ( rule__Edge__Group_7_2_0_0__1__Impl rule__Edge__Group_7_2_0_0__2 )
            // InternalModelDraw.g:3548:2: rule__Edge__Group_7_2_0_0__1__Impl rule__Edge__Group_7_2_0_0__2
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_0_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_0_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0__1"


    // $ANTLR start "rule__Edge__Group_7_2_0_0__1__Impl"
    // InternalModelDraw.g:3555:1: rule__Edge__Group_7_2_0_0__1__Impl : ( ( rule__Edge__Group_7_2_0_0_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3559:1: ( ( ( rule__Edge__Group_7_2_0_0_1__0 )? ) )
            // InternalModelDraw.g:3560:1: ( ( rule__Edge__Group_7_2_0_0_1__0 )? )
            {
            // InternalModelDraw.g:3560:1: ( ( rule__Edge__Group_7_2_0_0_1__0 )? )
            // InternalModelDraw.g:3561:2: ( rule__Edge__Group_7_2_0_0_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_0_0_1()); 
            // InternalModelDraw.g:3562:2: ( rule__Edge__Group_7_2_0_0_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==35) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalModelDraw.g:3562:3: rule__Edge__Group_7_2_0_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_0_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_0_0__2"
    // InternalModelDraw.g:3570:1: rule__Edge__Group_7_2_0_0__2 : rule__Edge__Group_7_2_0_0__2__Impl ;
    public final void rule__Edge__Group_7_2_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3574:1: ( rule__Edge__Group_7_2_0_0__2__Impl )
            // InternalModelDraw.g:3575:2: rule__Edge__Group_7_2_0_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_0_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0__2"


    // $ANTLR start "rule__Edge__Group_7_2_0_0__2__Impl"
    // InternalModelDraw.g:3581:1: rule__Edge__Group_7_2_0_0__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3585:1: ( ( '.' ) )
            // InternalModelDraw.g:3586:1: ( '.' )
            {
            // InternalModelDraw.g:3586:1: ( '.' )
            // InternalModelDraw.g:3587:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_0_0_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_0_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_0_0_1__0"
    // InternalModelDraw.g:3597:1: rule__Edge__Group_7_2_0_0_1__0 : rule__Edge__Group_7_2_0_0_1__0__Impl rule__Edge__Group_7_2_0_0_1__1 ;
    public final void rule__Edge__Group_7_2_0_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3601:1: ( rule__Edge__Group_7_2_0_0_1__0__Impl rule__Edge__Group_7_2_0_0_1__1 )
            // InternalModelDraw.g:3602:2: rule__Edge__Group_7_2_0_0_1__0__Impl rule__Edge__Group_7_2_0_0_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_0_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_0_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_0_0_1__0__Impl"
    // InternalModelDraw.g:3609:1: rule__Edge__Group_7_2_0_0_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_0_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3613:1: ( ( '->' ) )
            // InternalModelDraw.g:3614:1: ( '->' )
            {
            // InternalModelDraw.g:3614:1: ( '->' )
            // InternalModelDraw.g:3615:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_0_0_1__1"
    // InternalModelDraw.g:3624:1: rule__Edge__Group_7_2_0_0_1__1 : rule__Edge__Group_7_2_0_0_1__1__Impl ;
    public final void rule__Edge__Group_7_2_0_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3628:1: ( rule__Edge__Group_7_2_0_0_1__1__Impl )
            // InternalModelDraw.g:3629:2: rule__Edge__Group_7_2_0_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_0_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_0_0_1__1__Impl"
    // InternalModelDraw.g:3635:1: rule__Edge__Group_7_2_0_0_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_0_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3639:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) ) )
            // InternalModelDraw.g:3640:1: ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) )
            {
            // InternalModelDraw.g:3640:1: ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) )
            // InternalModelDraw.g:3641:2: ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_0_0_1_1()); 
            // InternalModelDraw.g:3642:2: ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 )
            // InternalModelDraw.g:3642:3: rule__Edge__RefTypeAssignment_7_2_0_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_7_2_0_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_0_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_0_0_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1__0"
    // InternalModelDraw.g:3651:1: rule__Edge__Group_7_2_1__0 : rule__Edge__Group_7_2_1__0__Impl rule__Edge__Group_7_2_1__1 ;
    public final void rule__Edge__Group_7_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3655:1: ( rule__Edge__Group_7_2_1__0__Impl rule__Edge__Group_7_2_1__1 )
            // InternalModelDraw.g:3656:2: rule__Edge__Group_7_2_1__0__Impl rule__Edge__Group_7_2_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1__0__Impl"
    // InternalModelDraw.g:3663:1: rule__Edge__Group_7_2_1__0__Impl : ( '{' ) ;
    public final void rule__Edge__Group_7_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3667:1: ( ( '{' ) )
            // InternalModelDraw.g:3668:1: ( '{' )
            {
            // InternalModelDraw.g:3668:1: ( '{' )
            // InternalModelDraw.g:3669:2: '{'
            {
             before(grammarAccess.getEdgeAccess().getLeftCurlyBracketKeyword_7_2_1_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftCurlyBracketKeyword_7_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1__1"
    // InternalModelDraw.g:3678:1: rule__Edge__Group_7_2_1__1 : rule__Edge__Group_7_2_1__1__Impl rule__Edge__Group_7_2_1__2 ;
    public final void rule__Edge__Group_7_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3682:1: ( rule__Edge__Group_7_2_1__1__Impl rule__Edge__Group_7_2_1__2 )
            // InternalModelDraw.g:3683:2: rule__Edge__Group_7_2_1__1__Impl rule__Edge__Group_7_2_1__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1__1__Impl"
    // InternalModelDraw.g:3690:1: rule__Edge__Group_7_2_1__1__Impl : ( ( rule__Edge__Group_7_2_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3694:1: ( ( ( rule__Edge__Group_7_2_1_1__0 )? ) )
            // InternalModelDraw.g:3695:1: ( ( rule__Edge__Group_7_2_1_1__0 )? )
            {
            // InternalModelDraw.g:3695:1: ( ( rule__Edge__Group_7_2_1_1__0 )? )
            // InternalModelDraw.g:3696:2: ( rule__Edge__Group_7_2_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_1()); 
            // InternalModelDraw.g:3697:2: ( rule__Edge__Group_7_2_1_1__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==35||LA40_1==44) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // InternalModelDraw.g:3697:3: rule__Edge__Group_7_2_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1__2"
    // InternalModelDraw.g:3705:1: rule__Edge__Group_7_2_1__2 : rule__Edge__Group_7_2_1__2__Impl rule__Edge__Group_7_2_1__3 ;
    public final void rule__Edge__Group_7_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3709:1: ( rule__Edge__Group_7_2_1__2__Impl rule__Edge__Group_7_2_1__3 )
            // InternalModelDraw.g:3710:2: rule__Edge__Group_7_2_1__2__Impl rule__Edge__Group_7_2_1__3
            {
            pushFollow(FOLLOW_31);
            rule__Edge__Group_7_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__2"


    // $ANTLR start "rule__Edge__Group_7_2_1__2__Impl"
    // InternalModelDraw.g:3717:1: rule__Edge__Group_7_2_1__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_2 ) ) ;
    public final void rule__Edge__Group_7_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3721:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_2 ) ) )
            // InternalModelDraw.g:3722:1: ( ( rule__Edge__LabelAssignment_7_2_1_2 ) )
            {
            // InternalModelDraw.g:3722:1: ( ( rule__Edge__LabelAssignment_7_2_1_2 ) )
            // InternalModelDraw.g:3723:2: ( rule__Edge__LabelAssignment_7_2_1_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_2()); 
            // InternalModelDraw.g:3724:2: ( rule__Edge__LabelAssignment_7_2_1_2 )
            // InternalModelDraw.g:3724:3: rule__Edge__LabelAssignment_7_2_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_7_2_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1__3"
    // InternalModelDraw.g:3732:1: rule__Edge__Group_7_2_1__3 : rule__Edge__Group_7_2_1__3__Impl rule__Edge__Group_7_2_1__4 ;
    public final void rule__Edge__Group_7_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3736:1: ( rule__Edge__Group_7_2_1__3__Impl rule__Edge__Group_7_2_1__4 )
            // InternalModelDraw.g:3737:2: rule__Edge__Group_7_2_1__3__Impl rule__Edge__Group_7_2_1__4
            {
            pushFollow(FOLLOW_31);
            rule__Edge__Group_7_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__3"


    // $ANTLR start "rule__Edge__Group_7_2_1__3__Impl"
    // InternalModelDraw.g:3744:1: rule__Edge__Group_7_2_1__3__Impl : ( ( rule__Edge__Group_7_2_1_3__0 )? ) ;
    public final void rule__Edge__Group_7_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3748:1: ( ( ( rule__Edge__Group_7_2_1_3__0 )? ) )
            // InternalModelDraw.g:3749:1: ( ( rule__Edge__Group_7_2_1_3__0 )? )
            {
            // InternalModelDraw.g:3749:1: ( ( rule__Edge__Group_7_2_1_3__0 )? )
            // InternalModelDraw.g:3750:2: ( rule__Edge__Group_7_2_1_3__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_3()); 
            // InternalModelDraw.g:3751:2: ( rule__Edge__Group_7_2_1_3__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==32) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalModelDraw.g:3751:3: rule__Edge__Group_7_2_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__3__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1__4"
    // InternalModelDraw.g:3759:1: rule__Edge__Group_7_2_1__4 : rule__Edge__Group_7_2_1__4__Impl rule__Edge__Group_7_2_1__5 ;
    public final void rule__Edge__Group_7_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3763:1: ( rule__Edge__Group_7_2_1__4__Impl rule__Edge__Group_7_2_1__5 )
            // InternalModelDraw.g:3764:2: rule__Edge__Group_7_2_1__4__Impl rule__Edge__Group_7_2_1__5
            {
            pushFollow(FOLLOW_31);
            rule__Edge__Group_7_2_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__4"


    // $ANTLR start "rule__Edge__Group_7_2_1__4__Impl"
    // InternalModelDraw.g:3771:1: rule__Edge__Group_7_2_1__4__Impl : ( ( rule__Edge__Group_7_2_1_4__0 )* ) ;
    public final void rule__Edge__Group_7_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3775:1: ( ( ( rule__Edge__Group_7_2_1_4__0 )* ) )
            // InternalModelDraw.g:3776:1: ( ( rule__Edge__Group_7_2_1_4__0 )* )
            {
            // InternalModelDraw.g:3776:1: ( ( rule__Edge__Group_7_2_1_4__0 )* )
            // InternalModelDraw.g:3777:2: ( rule__Edge__Group_7_2_1_4__0 )*
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4()); 
            // InternalModelDraw.g:3778:2: ( rule__Edge__Group_7_2_1_4__0 )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==34) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalModelDraw.g:3778:3: rule__Edge__Group_7_2_1_4__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Edge__Group_7_2_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__4__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1__5"
    // InternalModelDraw.g:3786:1: rule__Edge__Group_7_2_1__5 : rule__Edge__Group_7_2_1__5__Impl ;
    public final void rule__Edge__Group_7_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3790:1: ( rule__Edge__Group_7_2_1__5__Impl )
            // InternalModelDraw.g:3791:2: rule__Edge__Group_7_2_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__5"


    // $ANTLR start "rule__Edge__Group_7_2_1__5__Impl"
    // InternalModelDraw.g:3797:1: rule__Edge__Group_7_2_1__5__Impl : ( '}' ) ;
    public final void rule__Edge__Group_7_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3801:1: ( ( '}' ) )
            // InternalModelDraw.g:3802:1: ( '}' )
            {
            // InternalModelDraw.g:3802:1: ( '}' )
            // InternalModelDraw.g:3803:2: '}'
            {
             before(grammarAccess.getEdgeAccess().getRightCurlyBracketKeyword_7_2_1_5()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightCurlyBracketKeyword_7_2_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1__5__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_1__0"
    // InternalModelDraw.g:3813:1: rule__Edge__Group_7_2_1_1__0 : rule__Edge__Group_7_2_1_1__0__Impl rule__Edge__Group_7_2_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3817:1: ( rule__Edge__Group_7_2_1_1__0__Impl rule__Edge__Group_7_2_1_1__1 )
            // InternalModelDraw.g:3818:2: rule__Edge__Group_7_2_1_1__0__Impl rule__Edge__Group_7_2_1_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_1__0__Impl"
    // InternalModelDraw.g:3825:1: rule__Edge__Group_7_2_1_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3829:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) ) )
            // InternalModelDraw.g:3830:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) )
            {
            // InternalModelDraw.g:3830:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) )
            // InternalModelDraw.g:3831:2: ( rule__Edge__ReferenceAssignment_7_2_1_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_1_0()); 
            // InternalModelDraw.g:3832:2: ( rule__Edge__ReferenceAssignment_7_2_1_1_0 )
            // InternalModelDraw.g:3832:3: rule__Edge__ReferenceAssignment_7_2_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_7_2_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_1__1"
    // InternalModelDraw.g:3840:1: rule__Edge__Group_7_2_1_1__1 : rule__Edge__Group_7_2_1_1__1__Impl rule__Edge__Group_7_2_1_1__2 ;
    public final void rule__Edge__Group_7_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3844:1: ( rule__Edge__Group_7_2_1_1__1__Impl rule__Edge__Group_7_2_1_1__2 )
            // InternalModelDraw.g:3845:2: rule__Edge__Group_7_2_1_1__1__Impl rule__Edge__Group_7_2_1_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_1__1__Impl"
    // InternalModelDraw.g:3852:1: rule__Edge__Group_7_2_1_1__1__Impl : ( ( rule__Edge__Group_7_2_1_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3856:1: ( ( ( rule__Edge__Group_7_2_1_1_1__0 )? ) )
            // InternalModelDraw.g:3857:1: ( ( rule__Edge__Group_7_2_1_1_1__0 )? )
            {
            // InternalModelDraw.g:3857:1: ( ( rule__Edge__Group_7_2_1_1_1__0 )? )
            // InternalModelDraw.g:3858:2: ( rule__Edge__Group_7_2_1_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_1_1()); 
            // InternalModelDraw.g:3859:2: ( rule__Edge__Group_7_2_1_1_1__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==35) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalModelDraw.g:3859:3: rule__Edge__Group_7_2_1_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_1__2"
    // InternalModelDraw.g:3867:1: rule__Edge__Group_7_2_1_1__2 : rule__Edge__Group_7_2_1_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3871:1: ( rule__Edge__Group_7_2_1_1__2__Impl )
            // InternalModelDraw.g:3872:2: rule__Edge__Group_7_2_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1__2"


    // $ANTLR start "rule__Edge__Group_7_2_1_1__2__Impl"
    // InternalModelDraw.g:3878:1: rule__Edge__Group_7_2_1_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3882:1: ( ( '.' ) )
            // InternalModelDraw.g:3883:1: ( '.' )
            {
            // InternalModelDraw.g:3883:1: ( '.' )
            // InternalModelDraw.g:3884:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_1_1__0"
    // InternalModelDraw.g:3894:1: rule__Edge__Group_7_2_1_1_1__0 : rule__Edge__Group_7_2_1_1_1__0__Impl rule__Edge__Group_7_2_1_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3898:1: ( rule__Edge__Group_7_2_1_1_1__0__Impl rule__Edge__Group_7_2_1_1_1__1 )
            // InternalModelDraw.g:3899:2: rule__Edge__Group_7_2_1_1_1__0__Impl rule__Edge__Group_7_2_1_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_1_1__0__Impl"
    // InternalModelDraw.g:3906:1: rule__Edge__Group_7_2_1_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3910:1: ( ( '->' ) )
            // InternalModelDraw.g:3911:1: ( '->' )
            {
            // InternalModelDraw.g:3911:1: ( '->' )
            // InternalModelDraw.g:3912:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_1_1__1"
    // InternalModelDraw.g:3921:1: rule__Edge__Group_7_2_1_1_1__1 : rule__Edge__Group_7_2_1_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3925:1: ( rule__Edge__Group_7_2_1_1_1__1__Impl )
            // InternalModelDraw.g:3926:2: rule__Edge__Group_7_2_1_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_1_1__1__Impl"
    // InternalModelDraw.g:3932:1: rule__Edge__Group_7_2_1_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3936:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) ) )
            // InternalModelDraw.g:3937:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) )
            {
            // InternalModelDraw.g:3937:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) )
            // InternalModelDraw.g:3938:2: ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_1_1_1()); 
            // InternalModelDraw.g:3939:2: ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 )
            // InternalModelDraw.g:3939:3: rule__Edge__RefTypeAssignment_7_2_1_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_7_2_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__0"
    // InternalModelDraw.g:3948:1: rule__Edge__Group_7_2_1_3__0 : rule__Edge__Group_7_2_1_3__0__Impl rule__Edge__Group_7_2_1_3__1 ;
    public final void rule__Edge__Group_7_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3952:1: ( rule__Edge__Group_7_2_1_3__0__Impl rule__Edge__Group_7_2_1_3__1 )
            // InternalModelDraw.g:3953:2: rule__Edge__Group_7_2_1_3__0__Impl rule__Edge__Group_7_2_1_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__0__Impl"
    // InternalModelDraw.g:3960:1: rule__Edge__Group_7_2_1_3__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_7_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3964:1: ( ( '(' ) )
            // InternalModelDraw.g:3965:1: ( '(' )
            {
            // InternalModelDraw.g:3965:1: ( '(' )
            // InternalModelDraw.g:3966:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_3_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__1"
    // InternalModelDraw.g:3975:1: rule__Edge__Group_7_2_1_3__1 : rule__Edge__Group_7_2_1_3__1__Impl rule__Edge__Group_7_2_1_3__2 ;
    public final void rule__Edge__Group_7_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3979:1: ( rule__Edge__Group_7_2_1_3__1__Impl rule__Edge__Group_7_2_1_3__2 )
            // InternalModelDraw.g:3980:2: rule__Edge__Group_7_2_1_3__1__Impl rule__Edge__Group_7_2_1_3__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__1__Impl"
    // InternalModelDraw.g:3987:1: rule__Edge__Group_7_2_1_3__1__Impl : ( ( rule__Edge__Group_7_2_1_3_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3991:1: ( ( ( rule__Edge__Group_7_2_1_3_1__0 )? ) )
            // InternalModelDraw.g:3992:1: ( ( rule__Edge__Group_7_2_1_3_1__0 )? )
            {
            // InternalModelDraw.g:3992:1: ( ( rule__Edge__Group_7_2_1_3_1__0 )? )
            // InternalModelDraw.g:3993:2: ( rule__Edge__Group_7_2_1_3_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_3_1()); 
            // InternalModelDraw.g:3994:2: ( rule__Edge__Group_7_2_1_3_1__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_ID) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==35||LA44_1==44) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalModelDraw.g:3994:3: rule__Edge__Group_7_2_1_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__2"
    // InternalModelDraw.g:4002:1: rule__Edge__Group_7_2_1_3__2 : rule__Edge__Group_7_2_1_3__2__Impl rule__Edge__Group_7_2_1_3__3 ;
    public final void rule__Edge__Group_7_2_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4006:1: ( rule__Edge__Group_7_2_1_3__2__Impl rule__Edge__Group_7_2_1_3__3 )
            // InternalModelDraw.g:4007:2: rule__Edge__Group_7_2_1_3__2__Impl rule__Edge__Group_7_2_1_3__3
            {
            pushFollow(FOLLOW_20);
            rule__Edge__Group_7_2_1_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__2"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__2__Impl"
    // InternalModelDraw.g:4014:1: rule__Edge__Group_7_2_1_3__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) ) ;
    public final void rule__Edge__Group_7_2_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4018:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) ) )
            // InternalModelDraw.g:4019:1: ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) )
            {
            // InternalModelDraw.g:4019:1: ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) )
            // InternalModelDraw.g:4020:2: ( rule__Edge__LabelAssignment_7_2_1_3_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_3_2()); 
            // InternalModelDraw.g:4021:2: ( rule__Edge__LabelAssignment_7_2_1_3_2 )
            // InternalModelDraw.g:4021:3: rule__Edge__LabelAssignment_7_2_1_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_7_2_1_3_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__3"
    // InternalModelDraw.g:4029:1: rule__Edge__Group_7_2_1_3__3 : rule__Edge__Group_7_2_1_3__3__Impl ;
    public final void rule__Edge__Group_7_2_1_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4033:1: ( rule__Edge__Group_7_2_1_3__3__Impl )
            // InternalModelDraw.g:4034:2: rule__Edge__Group_7_2_1_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__3"


    // $ANTLR start "rule__Edge__Group_7_2_1_3__3__Impl"
    // InternalModelDraw.g:4040:1: rule__Edge__Group_7_2_1_3__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_7_2_1_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4044:1: ( ( ')' ) )
            // InternalModelDraw.g:4045:1: ( ')' )
            {
            // InternalModelDraw.g:4045:1: ( ')' )
            // InternalModelDraw.g:4046:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_7_2_1_3_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_7_2_1_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3__3__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1__0"
    // InternalModelDraw.g:4056:1: rule__Edge__Group_7_2_1_3_1__0 : rule__Edge__Group_7_2_1_3_1__0__Impl rule__Edge__Group_7_2_1_3_1__1 ;
    public final void rule__Edge__Group_7_2_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4060:1: ( rule__Edge__Group_7_2_1_3_1__0__Impl rule__Edge__Group_7_2_1_3_1__1 )
            // InternalModelDraw.g:4061:2: rule__Edge__Group_7_2_1_3_1__0__Impl rule__Edge__Group_7_2_1_3_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1__0__Impl"
    // InternalModelDraw.g:4068:1: rule__Edge__Group_7_2_1_3_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4072:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) ) )
            // InternalModelDraw.g:4073:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) )
            {
            // InternalModelDraw.g:4073:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) )
            // InternalModelDraw.g:4074:2: ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_3_1_0()); 
            // InternalModelDraw.g:4075:2: ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 )
            // InternalModelDraw.g:4075:3: rule__Edge__ReferenceAssignment_7_2_1_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_7_2_1_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1__1"
    // InternalModelDraw.g:4083:1: rule__Edge__Group_7_2_1_3_1__1 : rule__Edge__Group_7_2_1_3_1__1__Impl rule__Edge__Group_7_2_1_3_1__2 ;
    public final void rule__Edge__Group_7_2_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4087:1: ( rule__Edge__Group_7_2_1_3_1__1__Impl rule__Edge__Group_7_2_1_3_1__2 )
            // InternalModelDraw.g:4088:2: rule__Edge__Group_7_2_1_3_1__1__Impl rule__Edge__Group_7_2_1_3_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1__1__Impl"
    // InternalModelDraw.g:4095:1: rule__Edge__Group_7_2_1_3_1__1__Impl : ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4099:1: ( ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? ) )
            // InternalModelDraw.g:4100:1: ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? )
            {
            // InternalModelDraw.g:4100:1: ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? )
            // InternalModelDraw.g:4101:2: ( rule__Edge__Group_7_2_1_3_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_3_1_1()); 
            // InternalModelDraw.g:4102:2: ( rule__Edge__Group_7_2_1_3_1_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==35) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalModelDraw.g:4102:3: rule__Edge__Group_7_2_1_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_3_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1__2"
    // InternalModelDraw.g:4110:1: rule__Edge__Group_7_2_1_3_1__2 : rule__Edge__Group_7_2_1_3_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4114:1: ( rule__Edge__Group_7_2_1_3_1__2__Impl )
            // InternalModelDraw.g:4115:2: rule__Edge__Group_7_2_1_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1__2"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1__2__Impl"
    // InternalModelDraw.g:4121:1: rule__Edge__Group_7_2_1_3_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4125:1: ( ( '.' ) )
            // InternalModelDraw.g:4126:1: ( '.' )
            {
            // InternalModelDraw.g:4126:1: ( '.' )
            // InternalModelDraw.g:4127:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_3_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1_1__0"
    // InternalModelDraw.g:4137:1: rule__Edge__Group_7_2_1_3_1_1__0 : rule__Edge__Group_7_2_1_3_1_1__0__Impl rule__Edge__Group_7_2_1_3_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4141:1: ( rule__Edge__Group_7_2_1_3_1_1__0__Impl rule__Edge__Group_7_2_1_3_1_1__1 )
            // InternalModelDraw.g:4142:2: rule__Edge__Group_7_2_1_3_1_1__0__Impl rule__Edge__Group_7_2_1_3_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1_1__0__Impl"
    // InternalModelDraw.g:4149:1: rule__Edge__Group_7_2_1_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4153:1: ( ( '->' ) )
            // InternalModelDraw.g:4154:1: ( '->' )
            {
            // InternalModelDraw.g:4154:1: ( '->' )
            // InternalModelDraw.g:4155:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1_1__1"
    // InternalModelDraw.g:4164:1: rule__Edge__Group_7_2_1_3_1_1__1 : rule__Edge__Group_7_2_1_3_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4168:1: ( rule__Edge__Group_7_2_1_3_1_1__1__Impl )
            // InternalModelDraw.g:4169:2: rule__Edge__Group_7_2_1_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_3_1_1__1__Impl"
    // InternalModelDraw.g:4175:1: rule__Edge__Group_7_2_1_3_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4179:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) ) )
            // InternalModelDraw.g:4180:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            {
            // InternalModelDraw.g:4180:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            // InternalModelDraw.g:4181:2: ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_3_1_1_1()); 
            // InternalModelDraw.g:4182:2: ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 )
            // InternalModelDraw.g:4182:3: rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_3_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__0"
    // InternalModelDraw.g:4191:1: rule__Edge__Group_7_2_1_4__0 : rule__Edge__Group_7_2_1_4__0__Impl rule__Edge__Group_7_2_1_4__1 ;
    public final void rule__Edge__Group_7_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4195:1: ( rule__Edge__Group_7_2_1_4__0__Impl rule__Edge__Group_7_2_1_4__1 )
            // InternalModelDraw.g:4196:2: rule__Edge__Group_7_2_1_4__0__Impl rule__Edge__Group_7_2_1_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__0__Impl"
    // InternalModelDraw.g:4203:1: rule__Edge__Group_7_2_1_4__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_7_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4207:1: ( ( ',' ) )
            // InternalModelDraw.g:4208:1: ( ',' )
            {
            // InternalModelDraw.g:4208:1: ( ',' )
            // InternalModelDraw.g:4209:2: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_7_2_1_4_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_7_2_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__1"
    // InternalModelDraw.g:4218:1: rule__Edge__Group_7_2_1_4__1 : rule__Edge__Group_7_2_1_4__1__Impl rule__Edge__Group_7_2_1_4__2 ;
    public final void rule__Edge__Group_7_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4222:1: ( rule__Edge__Group_7_2_1_4__1__Impl rule__Edge__Group_7_2_1_4__2 )
            // InternalModelDraw.g:4223:2: rule__Edge__Group_7_2_1_4__1__Impl rule__Edge__Group_7_2_1_4__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__1__Impl"
    // InternalModelDraw.g:4230:1: rule__Edge__Group_7_2_1_4__1__Impl : ( ( rule__Edge__Group_7_2_1_4_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4234:1: ( ( ( rule__Edge__Group_7_2_1_4_1__0 )? ) )
            // InternalModelDraw.g:4235:1: ( ( rule__Edge__Group_7_2_1_4_1__0 )? )
            {
            // InternalModelDraw.g:4235:1: ( ( rule__Edge__Group_7_2_1_4_1__0 )? )
            // InternalModelDraw.g:4236:2: ( rule__Edge__Group_7_2_1_4_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_1()); 
            // InternalModelDraw.g:4237:2: ( rule__Edge__Group_7_2_1_4_1__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==35||LA46_1==44) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalModelDraw.g:4237:3: rule__Edge__Group_7_2_1_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_4_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__2"
    // InternalModelDraw.g:4245:1: rule__Edge__Group_7_2_1_4__2 : rule__Edge__Group_7_2_1_4__2__Impl rule__Edge__Group_7_2_1_4__3 ;
    public final void rule__Edge__Group_7_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4249:1: ( rule__Edge__Group_7_2_1_4__2__Impl rule__Edge__Group_7_2_1_4__3 )
            // InternalModelDraw.g:4250:2: rule__Edge__Group_7_2_1_4__2__Impl rule__Edge__Group_7_2_1_4__3
            {
            pushFollow(FOLLOW_17);
            rule__Edge__Group_7_2_1_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__2"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__2__Impl"
    // InternalModelDraw.g:4257:1: rule__Edge__Group_7_2_1_4__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) ) ;
    public final void rule__Edge__Group_7_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4261:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) ) )
            // InternalModelDraw.g:4262:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) )
            {
            // InternalModelDraw.g:4262:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) )
            // InternalModelDraw.g:4263:2: ( rule__Edge__LabelAssignment_7_2_1_4_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_4_2()); 
            // InternalModelDraw.g:4264:2: ( rule__Edge__LabelAssignment_7_2_1_4_2 )
            // InternalModelDraw.g:4264:3: rule__Edge__LabelAssignment_7_2_1_4_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_7_2_1_4_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__3"
    // InternalModelDraw.g:4272:1: rule__Edge__Group_7_2_1_4__3 : rule__Edge__Group_7_2_1_4__3__Impl ;
    public final void rule__Edge__Group_7_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4276:1: ( rule__Edge__Group_7_2_1_4__3__Impl )
            // InternalModelDraw.g:4277:2: rule__Edge__Group_7_2_1_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__3"


    // $ANTLR start "rule__Edge__Group_7_2_1_4__3__Impl"
    // InternalModelDraw.g:4283:1: rule__Edge__Group_7_2_1_4__3__Impl : ( ( rule__Edge__Group_7_2_1_4_3__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4287:1: ( ( ( rule__Edge__Group_7_2_1_4_3__0 )? ) )
            // InternalModelDraw.g:4288:1: ( ( rule__Edge__Group_7_2_1_4_3__0 )? )
            {
            // InternalModelDraw.g:4288:1: ( ( rule__Edge__Group_7_2_1_4_3__0 )? )
            // InternalModelDraw.g:4289:2: ( rule__Edge__Group_7_2_1_4_3__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3()); 
            // InternalModelDraw.g:4290:2: ( rule__Edge__Group_7_2_1_4_3__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==32) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalModelDraw.g:4290:3: rule__Edge__Group_7_2_1_4_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_4_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4__3__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1__0"
    // InternalModelDraw.g:4299:1: rule__Edge__Group_7_2_1_4_1__0 : rule__Edge__Group_7_2_1_4_1__0__Impl rule__Edge__Group_7_2_1_4_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4303:1: ( rule__Edge__Group_7_2_1_4_1__0__Impl rule__Edge__Group_7_2_1_4_1__1 )
            // InternalModelDraw.g:4304:2: rule__Edge__Group_7_2_1_4_1__0__Impl rule__Edge__Group_7_2_1_4_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1__0__Impl"
    // InternalModelDraw.g:4311:1: rule__Edge__Group_7_2_1_4_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4315:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) ) )
            // InternalModelDraw.g:4316:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) )
            {
            // InternalModelDraw.g:4316:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) )
            // InternalModelDraw.g:4317:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_4_1_0()); 
            // InternalModelDraw.g:4318:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 )
            // InternalModelDraw.g:4318:3: rule__Edge__ReferenceAssignment_7_2_1_4_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_7_2_1_4_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1__1"
    // InternalModelDraw.g:4326:1: rule__Edge__Group_7_2_1_4_1__1 : rule__Edge__Group_7_2_1_4_1__1__Impl rule__Edge__Group_7_2_1_4_1__2 ;
    public final void rule__Edge__Group_7_2_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4330:1: ( rule__Edge__Group_7_2_1_4_1__1__Impl rule__Edge__Group_7_2_1_4_1__2 )
            // InternalModelDraw.g:4331:2: rule__Edge__Group_7_2_1_4_1__1__Impl rule__Edge__Group_7_2_1_4_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1__1__Impl"
    // InternalModelDraw.g:4338:1: rule__Edge__Group_7_2_1_4_1__1__Impl : ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4342:1: ( ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? ) )
            // InternalModelDraw.g:4343:1: ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? )
            {
            // InternalModelDraw.g:4343:1: ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? )
            // InternalModelDraw.g:4344:2: ( rule__Edge__Group_7_2_1_4_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_1_1()); 
            // InternalModelDraw.g:4345:2: ( rule__Edge__Group_7_2_1_4_1_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==35) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalModelDraw.g:4345:3: rule__Edge__Group_7_2_1_4_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_4_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1__2"
    // InternalModelDraw.g:4353:1: rule__Edge__Group_7_2_1_4_1__2 : rule__Edge__Group_7_2_1_4_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4357:1: ( rule__Edge__Group_7_2_1_4_1__2__Impl )
            // InternalModelDraw.g:4358:2: rule__Edge__Group_7_2_1_4_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1__2"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1__2__Impl"
    // InternalModelDraw.g:4364:1: rule__Edge__Group_7_2_1_4_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4368:1: ( ( '.' ) )
            // InternalModelDraw.g:4369:1: ( '.' )
            {
            // InternalModelDraw.g:4369:1: ( '.' )
            // InternalModelDraw.g:4370:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_4_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1_1__0"
    // InternalModelDraw.g:4380:1: rule__Edge__Group_7_2_1_4_1_1__0 : rule__Edge__Group_7_2_1_4_1_1__0__Impl rule__Edge__Group_7_2_1_4_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4384:1: ( rule__Edge__Group_7_2_1_4_1_1__0__Impl rule__Edge__Group_7_2_1_4_1_1__1 )
            // InternalModelDraw.g:4385:2: rule__Edge__Group_7_2_1_4_1_1__0__Impl rule__Edge__Group_7_2_1_4_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_4_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1_1__0__Impl"
    // InternalModelDraw.g:4392:1: rule__Edge__Group_7_2_1_4_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4396:1: ( ( '->' ) )
            // InternalModelDraw.g:4397:1: ( '->' )
            {
            // InternalModelDraw.g:4397:1: ( '->' )
            // InternalModelDraw.g:4398:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1_1__1"
    // InternalModelDraw.g:4407:1: rule__Edge__Group_7_2_1_4_1_1__1 : rule__Edge__Group_7_2_1_4_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4411:1: ( rule__Edge__Group_7_2_1_4_1_1__1__Impl )
            // InternalModelDraw.g:4412:2: rule__Edge__Group_7_2_1_4_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_1_1__1__Impl"
    // InternalModelDraw.g:4418:1: rule__Edge__Group_7_2_1_4_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4422:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) ) )
            // InternalModelDraw.g:4423:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            {
            // InternalModelDraw.g:4423:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            // InternalModelDraw.g:4424:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_4_1_1_1()); 
            // InternalModelDraw.g:4425:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 )
            // InternalModelDraw.g:4425:3: rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_4_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__0"
    // InternalModelDraw.g:4434:1: rule__Edge__Group_7_2_1_4_3__0 : rule__Edge__Group_7_2_1_4_3__0__Impl rule__Edge__Group_7_2_1_4_3__1 ;
    public final void rule__Edge__Group_7_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4438:1: ( rule__Edge__Group_7_2_1_4_3__0__Impl rule__Edge__Group_7_2_1_4_3__1 )
            // InternalModelDraw.g:4439:2: rule__Edge__Group_7_2_1_4_3__0__Impl rule__Edge__Group_7_2_1_4_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_4_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__0__Impl"
    // InternalModelDraw.g:4446:1: rule__Edge__Group_7_2_1_4_3__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_7_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4450:1: ( ( '(' ) )
            // InternalModelDraw.g:4451:1: ( '(' )
            {
            // InternalModelDraw.g:4451:1: ( '(' )
            // InternalModelDraw.g:4452:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_4_3_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_7_2_1_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__1"
    // InternalModelDraw.g:4461:1: rule__Edge__Group_7_2_1_4_3__1 : rule__Edge__Group_7_2_1_4_3__1__Impl rule__Edge__Group_7_2_1_4_3__2 ;
    public final void rule__Edge__Group_7_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4465:1: ( rule__Edge__Group_7_2_1_4_3__1__Impl rule__Edge__Group_7_2_1_4_3__2 )
            // InternalModelDraw.g:4466:2: rule__Edge__Group_7_2_1_4_3__1__Impl rule__Edge__Group_7_2_1_4_3__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_4_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__1__Impl"
    // InternalModelDraw.g:4473:1: rule__Edge__Group_7_2_1_4_3__1__Impl : ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4477:1: ( ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? ) )
            // InternalModelDraw.g:4478:1: ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? )
            {
            // InternalModelDraw.g:4478:1: ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? )
            // InternalModelDraw.g:4479:2: ( rule__Edge__Group_7_2_1_4_3_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3_1()); 
            // InternalModelDraw.g:4480:2: ( rule__Edge__Group_7_2_1_4_3_1__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                int LA49_1 = input.LA(2);

                if ( (LA49_1==35||LA49_1==44) ) {
                    alt49=1;
                }
            }
            switch (alt49) {
                case 1 :
                    // InternalModelDraw.g:4480:3: rule__Edge__Group_7_2_1_4_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_4_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__2"
    // InternalModelDraw.g:4488:1: rule__Edge__Group_7_2_1_4_3__2 : rule__Edge__Group_7_2_1_4_3__2__Impl rule__Edge__Group_7_2_1_4_3__3 ;
    public final void rule__Edge__Group_7_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4492:1: ( rule__Edge__Group_7_2_1_4_3__2__Impl rule__Edge__Group_7_2_1_4_3__3 )
            // InternalModelDraw.g:4493:2: rule__Edge__Group_7_2_1_4_3__2__Impl rule__Edge__Group_7_2_1_4_3__3
            {
            pushFollow(FOLLOW_20);
            rule__Edge__Group_7_2_1_4_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__2"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__2__Impl"
    // InternalModelDraw.g:4500:1: rule__Edge__Group_7_2_1_4_3__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4504:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) ) )
            // InternalModelDraw.g:4505:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) )
            {
            // InternalModelDraw.g:4505:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) )
            // InternalModelDraw.g:4506:2: ( rule__Edge__LabelAssignment_7_2_1_4_3_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_4_3_2()); 
            // InternalModelDraw.g:4507:2: ( rule__Edge__LabelAssignment_7_2_1_4_3_2 )
            // InternalModelDraw.g:4507:3: rule__Edge__LabelAssignment_7_2_1_4_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_7_2_1_4_3_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_4_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__3"
    // InternalModelDraw.g:4515:1: rule__Edge__Group_7_2_1_4_3__3 : rule__Edge__Group_7_2_1_4_3__3__Impl ;
    public final void rule__Edge__Group_7_2_1_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4519:1: ( rule__Edge__Group_7_2_1_4_3__3__Impl )
            // InternalModelDraw.g:4520:2: rule__Edge__Group_7_2_1_4_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__3"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3__3__Impl"
    // InternalModelDraw.g:4526:1: rule__Edge__Group_7_2_1_4_3__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_7_2_1_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4530:1: ( ( ')' ) )
            // InternalModelDraw.g:4531:1: ( ')' )
            {
            // InternalModelDraw.g:4531:1: ( ')' )
            // InternalModelDraw.g:4532:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_7_2_1_4_3_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_7_2_1_4_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3__3__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1__0"
    // InternalModelDraw.g:4542:1: rule__Edge__Group_7_2_1_4_3_1__0 : rule__Edge__Group_7_2_1_4_3_1__0__Impl rule__Edge__Group_7_2_1_4_3_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4546:1: ( rule__Edge__Group_7_2_1_4_3_1__0__Impl rule__Edge__Group_7_2_1_4_3_1__1 )
            // InternalModelDraw.g:4547:2: rule__Edge__Group_7_2_1_4_3_1__0__Impl rule__Edge__Group_7_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_4_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1__0__Impl"
    // InternalModelDraw.g:4554:1: rule__Edge__Group_7_2_1_4_3_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4558:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) ) )
            // InternalModelDraw.g:4559:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            {
            // InternalModelDraw.g:4559:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            // InternalModelDraw.g:4560:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_4_3_1_0()); 
            // InternalModelDraw.g:4561:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 )
            // InternalModelDraw.g:4561:3: rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_4_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1__1"
    // InternalModelDraw.g:4569:1: rule__Edge__Group_7_2_1_4_3_1__1 : rule__Edge__Group_7_2_1_4_3_1__1__Impl rule__Edge__Group_7_2_1_4_3_1__2 ;
    public final void rule__Edge__Group_7_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4573:1: ( rule__Edge__Group_7_2_1_4_3_1__1__Impl rule__Edge__Group_7_2_1_4_3_1__2 )
            // InternalModelDraw.g:4574:2: rule__Edge__Group_7_2_1_4_3_1__1__Impl rule__Edge__Group_7_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Edge__Group_7_2_1_4_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1__1__Impl"
    // InternalModelDraw.g:4581:1: rule__Edge__Group_7_2_1_4_3_1__1__Impl : ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4585:1: ( ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? ) )
            // InternalModelDraw.g:4586:1: ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? )
            {
            // InternalModelDraw.g:4586:1: ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? )
            // InternalModelDraw.g:4587:2: ( rule__Edge__Group_7_2_1_4_3_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3_1_1()); 
            // InternalModelDraw.g:4588:2: ( rule__Edge__Group_7_2_1_4_3_1_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==35) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalModelDraw.g:4588:3: rule__Edge__Group_7_2_1_4_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_7_2_1_4_3_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1__2"
    // InternalModelDraw.g:4596:1: rule__Edge__Group_7_2_1_4_3_1__2 : rule__Edge__Group_7_2_1_4_3_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4600:1: ( rule__Edge__Group_7_2_1_4_3_1__2__Impl )
            // InternalModelDraw.g:4601:2: rule__Edge__Group_7_2_1_4_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1__2"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1__2__Impl"
    // InternalModelDraw.g:4607:1: rule__Edge__Group_7_2_1_4_3_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4611:1: ( ( '.' ) )
            // InternalModelDraw.g:4612:1: ( '.' )
            {
            // InternalModelDraw.g:4612:1: ( '.' )
            // InternalModelDraw.g:4613:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_4_3_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_7_2_1_4_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1_1__0"
    // InternalModelDraw.g:4623:1: rule__Edge__Group_7_2_1_4_3_1_1__0 : rule__Edge__Group_7_2_1_4_3_1_1__0__Impl rule__Edge__Group_7_2_1_4_3_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4627:1: ( rule__Edge__Group_7_2_1_4_3_1_1__0__Impl rule__Edge__Group_7_2_1_4_3_1_1__1 )
            // InternalModelDraw.g:4628:2: rule__Edge__Group_7_2_1_4_3_1_1__0__Impl rule__Edge__Group_7_2_1_4_3_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_7_2_1_4_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1_1__0"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1_1__0__Impl"
    // InternalModelDraw.g:4635:1: rule__Edge__Group_7_2_1_4_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4639:1: ( ( '->' ) )
            // InternalModelDraw.g:4640:1: ( '->' )
            {
            // InternalModelDraw.g:4640:1: ( '->' )
            // InternalModelDraw.g:4641:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1_1__1"
    // InternalModelDraw.g:4650:1: rule__Edge__Group_7_2_1_4_3_1_1__1 : rule__Edge__Group_7_2_1_4_3_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4654:1: ( rule__Edge__Group_7_2_1_4_3_1_1__1__Impl )
            // InternalModelDraw.g:4655:2: rule__Edge__Group_7_2_1_4_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_7_2_1_4_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1_1__1"


    // $ANTLR start "rule__Edge__Group_7_2_1_4_3_1_1__1__Impl"
    // InternalModelDraw.g:4661:1: rule__Edge__Group_7_2_1_4_3_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4665:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) )
            // InternalModelDraw.g:4666:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            {
            // InternalModelDraw.g:4666:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            // InternalModelDraw.g:4667:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_4_3_1_1_1()); 
            // InternalModelDraw.g:4668:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            // InternalModelDraw.g:4668:3: rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_4_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_7_2_1_4_3_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_8__0"
    // InternalModelDraw.g:4677:1: rule__Edge__Group_8__0 : rule__Edge__Group_8__0__Impl rule__Edge__Group_8__1 ;
    public final void rule__Edge__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4681:1: ( rule__Edge__Group_8__0__Impl rule__Edge__Group_8__1 )
            // InternalModelDraw.g:4682:2: rule__Edge__Group_8__0__Impl rule__Edge__Group_8__1
            {
            pushFollow(FOLLOW_18);
            rule__Edge__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_8__0"


    // $ANTLR start "rule__Edge__Group_8__0__Impl"
    // InternalModelDraw.g:4689:1: rule__Edge__Group_8__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Edge__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4693:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:4694:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:4694:1: ( 'src_decoration' )
            // InternalModelDraw.g:4695:2: 'src_decoration'
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationKeyword_8_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSrc_decorationKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_8__0__Impl"


    // $ANTLR start "rule__Edge__Group_8__1"
    // InternalModelDraw.g:4704:1: rule__Edge__Group_8__1 : rule__Edge__Group_8__1__Impl rule__Edge__Group_8__2 ;
    public final void rule__Edge__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4708:1: ( rule__Edge__Group_8__1__Impl rule__Edge__Group_8__2 )
            // InternalModelDraw.g:4709:2: rule__Edge__Group_8__1__Impl rule__Edge__Group_8__2
            {
            pushFollow(FOLLOW_32);
            rule__Edge__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_8__1"


    // $ANTLR start "rule__Edge__Group_8__1__Impl"
    // InternalModelDraw.g:4716:1: rule__Edge__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4720:1: ( ( '=' ) )
            // InternalModelDraw.g:4721:1: ( '=' )
            {
            // InternalModelDraw.g:4721:1: ( '=' )
            // InternalModelDraw.g:4722:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_8_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_8__1__Impl"


    // $ANTLR start "rule__Edge__Group_8__2"
    // InternalModelDraw.g:4731:1: rule__Edge__Group_8__2 : rule__Edge__Group_8__2__Impl ;
    public final void rule__Edge__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4735:1: ( rule__Edge__Group_8__2__Impl )
            // InternalModelDraw.g:4736:2: rule__Edge__Group_8__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_8__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_8__2"


    // $ANTLR start "rule__Edge__Group_8__2__Impl"
    // InternalModelDraw.g:4742:1: rule__Edge__Group_8__2__Impl : ( ( rule__Edge__Src_decorationAssignment_8_2 ) ) ;
    public final void rule__Edge__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4746:1: ( ( ( rule__Edge__Src_decorationAssignment_8_2 ) ) )
            // InternalModelDraw.g:4747:1: ( ( rule__Edge__Src_decorationAssignment_8_2 ) )
            {
            // InternalModelDraw.g:4747:1: ( ( rule__Edge__Src_decorationAssignment_8_2 ) )
            // InternalModelDraw.g:4748:2: ( rule__Edge__Src_decorationAssignment_8_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationAssignment_8_2()); 
            // InternalModelDraw.g:4749:2: ( rule__Edge__Src_decorationAssignment_8_2 )
            // InternalModelDraw.g:4749:3: rule__Edge__Src_decorationAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Src_decorationAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getSrc_decorationAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_8__2__Impl"


    // $ANTLR start "rule__Edge__Group_9__0"
    // InternalModelDraw.g:4758:1: rule__Edge__Group_9__0 : rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 ;
    public final void rule__Edge__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4762:1: ( rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 )
            // InternalModelDraw.g:4763:2: rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1
            {
            pushFollow(FOLLOW_18);
            rule__Edge__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_9__0"


    // $ANTLR start "rule__Edge__Group_9__0__Impl"
    // InternalModelDraw.g:4770:1: rule__Edge__Group_9__0__Impl : ( 'src_label' ) ;
    public final void rule__Edge__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4774:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:4775:1: ( 'src_label' )
            {
            // InternalModelDraw.g:4775:1: ( 'src_label' )
            // InternalModelDraw.g:4776:2: 'src_label'
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelKeyword_9_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSrc_labelKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_9__0__Impl"


    // $ANTLR start "rule__Edge__Group_9__1"
    // InternalModelDraw.g:4785:1: rule__Edge__Group_9__1 : rule__Edge__Group_9__1__Impl rule__Edge__Group_9__2 ;
    public final void rule__Edge__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4789:1: ( rule__Edge__Group_9__1__Impl rule__Edge__Group_9__2 )
            // InternalModelDraw.g:4790:2: rule__Edge__Group_9__1__Impl rule__Edge__Group_9__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_9__1"


    // $ANTLR start "rule__Edge__Group_9__1__Impl"
    // InternalModelDraw.g:4797:1: rule__Edge__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4801:1: ( ( '=' ) )
            // InternalModelDraw.g:4802:1: ( '=' )
            {
            // InternalModelDraw.g:4802:1: ( '=' )
            // InternalModelDraw.g:4803:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_9__1__Impl"


    // $ANTLR start "rule__Edge__Group_9__2"
    // InternalModelDraw.g:4812:1: rule__Edge__Group_9__2 : rule__Edge__Group_9__2__Impl ;
    public final void rule__Edge__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4816:1: ( rule__Edge__Group_9__2__Impl )
            // InternalModelDraw.g:4817:2: rule__Edge__Group_9__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_9__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_9__2"


    // $ANTLR start "rule__Edge__Group_9__2__Impl"
    // InternalModelDraw.g:4823:1: rule__Edge__Group_9__2__Impl : ( ( rule__Edge__Src_labelAssignment_9_2 ) ) ;
    public final void rule__Edge__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4827:1: ( ( ( rule__Edge__Src_labelAssignment_9_2 ) ) )
            // InternalModelDraw.g:4828:1: ( ( rule__Edge__Src_labelAssignment_9_2 ) )
            {
            // InternalModelDraw.g:4828:1: ( ( rule__Edge__Src_labelAssignment_9_2 ) )
            // InternalModelDraw.g:4829:2: ( rule__Edge__Src_labelAssignment_9_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelAssignment_9_2()); 
            // InternalModelDraw.g:4830:2: ( rule__Edge__Src_labelAssignment_9_2 )
            // InternalModelDraw.g:4830:3: rule__Edge__Src_labelAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Src_labelAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getSrc_labelAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_9__2__Impl"


    // $ANTLR start "rule__Edge__Group_10__0"
    // InternalModelDraw.g:4839:1: rule__Edge__Group_10__0 : rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 ;
    public final void rule__Edge__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4843:1: ( rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 )
            // InternalModelDraw.g:4844:2: rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1
            {
            pushFollow(FOLLOW_18);
            rule__Edge__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__0"


    // $ANTLR start "rule__Edge__Group_10__0__Impl"
    // InternalModelDraw.g:4851:1: rule__Edge__Group_10__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Edge__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4855:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:4856:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:4856:1: ( 'tar_decoration' )
            // InternalModelDraw.g:4857:2: 'tar_decoration'
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationKeyword_10_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTar_decorationKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__0__Impl"


    // $ANTLR start "rule__Edge__Group_10__1"
    // InternalModelDraw.g:4866:1: rule__Edge__Group_10__1 : rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 ;
    public final void rule__Edge__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4870:1: ( rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 )
            // InternalModelDraw.g:4871:2: rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2
            {
            pushFollow(FOLLOW_32);
            rule__Edge__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__1"


    // $ANTLR start "rule__Edge__Group_10__1__Impl"
    // InternalModelDraw.g:4878:1: rule__Edge__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4882:1: ( ( '=' ) )
            // InternalModelDraw.g:4883:1: ( '=' )
            {
            // InternalModelDraw.g:4883:1: ( '=' )
            // InternalModelDraw.g:4884:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__1__Impl"


    // $ANTLR start "rule__Edge__Group_10__2"
    // InternalModelDraw.g:4893:1: rule__Edge__Group_10__2 : rule__Edge__Group_10__2__Impl ;
    public final void rule__Edge__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4897:1: ( rule__Edge__Group_10__2__Impl )
            // InternalModelDraw.g:4898:2: rule__Edge__Group_10__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__2"


    // $ANTLR start "rule__Edge__Group_10__2__Impl"
    // InternalModelDraw.g:4904:1: rule__Edge__Group_10__2__Impl : ( ( rule__Edge__Tar_decorationAssignment_10_2 ) ) ;
    public final void rule__Edge__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4908:1: ( ( ( rule__Edge__Tar_decorationAssignment_10_2 ) ) )
            // InternalModelDraw.g:4909:1: ( ( rule__Edge__Tar_decorationAssignment_10_2 ) )
            {
            // InternalModelDraw.g:4909:1: ( ( rule__Edge__Tar_decorationAssignment_10_2 ) )
            // InternalModelDraw.g:4910:2: ( rule__Edge__Tar_decorationAssignment_10_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationAssignment_10_2()); 
            // InternalModelDraw.g:4911:2: ( rule__Edge__Tar_decorationAssignment_10_2 )
            // InternalModelDraw.g:4911:3: rule__Edge__Tar_decorationAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Tar_decorationAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTar_decorationAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__2__Impl"


    // $ANTLR start "rule__Edge__Group_11__0"
    // InternalModelDraw.g:4920:1: rule__Edge__Group_11__0 : rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 ;
    public final void rule__Edge__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4924:1: ( rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 )
            // InternalModelDraw.g:4925:2: rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1
            {
            pushFollow(FOLLOW_18);
            rule__Edge__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_11__0"


    // $ANTLR start "rule__Edge__Group_11__0__Impl"
    // InternalModelDraw.g:4932:1: rule__Edge__Group_11__0__Impl : ( 'tar_label' ) ;
    public final void rule__Edge__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4936:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:4937:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:4937:1: ( 'tar_label' )
            // InternalModelDraw.g:4938:2: 'tar_label'
            {
             before(grammarAccess.getEdgeAccess().getTar_labelKeyword_11_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTar_labelKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_11__0__Impl"


    // $ANTLR start "rule__Edge__Group_11__1"
    // InternalModelDraw.g:4947:1: rule__Edge__Group_11__1 : rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 ;
    public final void rule__Edge__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4951:1: ( rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 )
            // InternalModelDraw.g:4952:2: rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_11__1"


    // $ANTLR start "rule__Edge__Group_11__1__Impl"
    // InternalModelDraw.g:4959:1: rule__Edge__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4963:1: ( ( '=' ) )
            // InternalModelDraw.g:4964:1: ( '=' )
            {
            // InternalModelDraw.g:4964:1: ( '=' )
            // InternalModelDraw.g:4965:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_11__1__Impl"


    // $ANTLR start "rule__Edge__Group_11__2"
    // InternalModelDraw.g:4974:1: rule__Edge__Group_11__2 : rule__Edge__Group_11__2__Impl ;
    public final void rule__Edge__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4978:1: ( rule__Edge__Group_11__2__Impl )
            // InternalModelDraw.g:4979:2: rule__Edge__Group_11__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_11__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_11__2"


    // $ANTLR start "rule__Edge__Group_11__2__Impl"
    // InternalModelDraw.g:4985:1: rule__Edge__Group_11__2__Impl : ( ( rule__Edge__Tar_labelAssignment_11_2 ) ) ;
    public final void rule__Edge__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4989:1: ( ( ( rule__Edge__Tar_labelAssignment_11_2 ) ) )
            // InternalModelDraw.g:4990:1: ( ( rule__Edge__Tar_labelAssignment_11_2 ) )
            {
            // InternalModelDraw.g:4990:1: ( ( rule__Edge__Tar_labelAssignment_11_2 ) )
            // InternalModelDraw.g:4991:2: ( rule__Edge__Tar_labelAssignment_11_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelAssignment_11_2()); 
            // InternalModelDraw.g:4992:2: ( rule__Edge__Tar_labelAssignment_11_2 )
            // InternalModelDraw.g:4992:3: rule__Edge__Tar_labelAssignment_11_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Tar_labelAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTar_labelAssignment_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_11__2__Impl"


    // $ANTLR start "rule__Level__Group__0"
    // InternalModelDraw.g:5001:1: rule__Level__Group__0 : rule__Level__Group__0__Impl rule__Level__Group__1 ;
    public final void rule__Level__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5005:1: ( rule__Level__Group__0__Impl rule__Level__Group__1 )
            // InternalModelDraw.g:5006:2: rule__Level__Group__0__Impl rule__Level__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__0"


    // $ANTLR start "rule__Level__Group__0__Impl"
    // InternalModelDraw.g:5013:1: rule__Level__Group__0__Impl : ( () ) ;
    public final void rule__Level__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5017:1: ( ( () ) )
            // InternalModelDraw.g:5018:1: ( () )
            {
            // InternalModelDraw.g:5018:1: ( () )
            // InternalModelDraw.g:5019:2: ()
            {
             before(grammarAccess.getLevelAccess().getLevelAction_0()); 
            // InternalModelDraw.g:5020:2: ()
            // InternalModelDraw.g:5020:3: 
            {
            }

             after(grammarAccess.getLevelAccess().getLevelAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__0__Impl"


    // $ANTLR start "rule__Level__Group__1"
    // InternalModelDraw.g:5028:1: rule__Level__Group__1 : rule__Level__Group__1__Impl rule__Level__Group__2 ;
    public final void rule__Level__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5032:1: ( rule__Level__Group__1__Impl rule__Level__Group__2 )
            // InternalModelDraw.g:5033:2: rule__Level__Group__1__Impl rule__Level__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Level__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__1"


    // $ANTLR start "rule__Level__Group__1__Impl"
    // InternalModelDraw.g:5040:1: rule__Level__Group__1__Impl : ( ( rule__Level__NameAssignment_1 ) ) ;
    public final void rule__Level__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5044:1: ( ( ( rule__Level__NameAssignment_1 ) ) )
            // InternalModelDraw.g:5045:1: ( ( rule__Level__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:5045:1: ( ( rule__Level__NameAssignment_1 ) )
            // InternalModelDraw.g:5046:2: ( rule__Level__NameAssignment_1 )
            {
             before(grammarAccess.getLevelAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:5047:2: ( rule__Level__NameAssignment_1 )
            // InternalModelDraw.g:5047:3: rule__Level__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__1__Impl"


    // $ANTLR start "rule__Level__Group__2"
    // InternalModelDraw.g:5055:1: rule__Level__Group__2 : rule__Level__Group__2__Impl rule__Level__Group__3 ;
    public final void rule__Level__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5059:1: ( rule__Level__Group__2__Impl rule__Level__Group__3 )
            // InternalModelDraw.g:5060:2: rule__Level__Group__2__Impl rule__Level__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__2"


    // $ANTLR start "rule__Level__Group__2__Impl"
    // InternalModelDraw.g:5067:1: rule__Level__Group__2__Impl : ( '.' ) ;
    public final void rule__Level__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5071:1: ( ( '.' ) )
            // InternalModelDraw.g:5072:1: ( '.' )
            {
            // InternalModelDraw.g:5072:1: ( '.' )
            // InternalModelDraw.g:5073:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getFullStopKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__2__Impl"


    // $ANTLR start "rule__Level__Group__3"
    // InternalModelDraw.g:5082:1: rule__Level__Group__3 : rule__Level__Group__3__Impl rule__Level__Group__4 ;
    public final void rule__Level__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5086:1: ( rule__Level__Group__3__Impl rule__Level__Group__4 )
            // InternalModelDraw.g:5087:2: rule__Level__Group__3__Impl rule__Level__Group__4
            {
            pushFollow(FOLLOW_6);
            rule__Level__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__3"


    // $ANTLR start "rule__Level__Group__3__Impl"
    // InternalModelDraw.g:5094:1: rule__Level__Group__3__Impl : ( ( rule__Level__UpperAssignment_3 ) ) ;
    public final void rule__Level__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5098:1: ( ( ( rule__Level__UpperAssignment_3 ) ) )
            // InternalModelDraw.g:5099:1: ( ( rule__Level__UpperAssignment_3 ) )
            {
            // InternalModelDraw.g:5099:1: ( ( rule__Level__UpperAssignment_3 ) )
            // InternalModelDraw.g:5100:2: ( rule__Level__UpperAssignment_3 )
            {
             before(grammarAccess.getLevelAccess().getUpperAssignment_3()); 
            // InternalModelDraw.g:5101:2: ( rule__Level__UpperAssignment_3 )
            // InternalModelDraw.g:5101:3: rule__Level__UpperAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Level__UpperAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getUpperAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__3__Impl"


    // $ANTLR start "rule__Level__Group__4"
    // InternalModelDraw.g:5109:1: rule__Level__Group__4 : rule__Level__Group__4__Impl rule__Level__Group__5 ;
    public final void rule__Level__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5113:1: ( rule__Level__Group__4__Impl rule__Level__Group__5 )
            // InternalModelDraw.g:5114:2: rule__Level__Group__4__Impl rule__Level__Group__5
            {
            pushFollow(FOLLOW_26);
            rule__Level__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__4"


    // $ANTLR start "rule__Level__Group__4__Impl"
    // InternalModelDraw.g:5121:1: rule__Level__Group__4__Impl : ( ':' ) ;
    public final void rule__Level__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5125:1: ( ( ':' ) )
            // InternalModelDraw.g:5126:1: ( ':' )
            {
            // InternalModelDraw.g:5126:1: ( ':' )
            // InternalModelDraw.g:5127:2: ':'
            {
             before(grammarAccess.getLevelAccess().getColonKeyword_4()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getColonKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__4__Impl"


    // $ANTLR start "rule__Level__Group__5"
    // InternalModelDraw.g:5136:1: rule__Level__Group__5 : rule__Level__Group__5__Impl rule__Level__Group__6 ;
    public final void rule__Level__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5140:1: ( rule__Level__Group__5__Impl rule__Level__Group__6 )
            // InternalModelDraw.g:5141:2: rule__Level__Group__5__Impl rule__Level__Group__6
            {
            pushFollow(FOLLOW_27);
            rule__Level__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__5"


    // $ANTLR start "rule__Level__Group__5__Impl"
    // InternalModelDraw.g:5148:1: rule__Level__Group__5__Impl : ( 'edge' ) ;
    public final void rule__Level__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5152:1: ( ( 'edge' ) )
            // InternalModelDraw.g:5153:1: ( 'edge' )
            {
            // InternalModelDraw.g:5153:1: ( 'edge' )
            // InternalModelDraw.g:5154:2: 'edge'
            {
             before(grammarAccess.getLevelAccess().getEdgeKeyword_5()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEdgeKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__5__Impl"


    // $ANTLR start "rule__Level__Group__6"
    // InternalModelDraw.g:5163:1: rule__Level__Group__6 : rule__Level__Group__6__Impl rule__Level__Group__7 ;
    public final void rule__Level__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5167:1: ( rule__Level__Group__6__Impl rule__Level__Group__7 )
            // InternalModelDraw.g:5168:2: rule__Level__Group__6__Impl rule__Level__Group__7
            {
            pushFollow(FOLLOW_27);
            rule__Level__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__6"


    // $ANTLR start "rule__Level__Group__6__Impl"
    // InternalModelDraw.g:5175:1: rule__Level__Group__6__Impl : ( ( rule__Level__Group_6__0 )? ) ;
    public final void rule__Level__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5179:1: ( ( ( rule__Level__Group_6__0 )? ) )
            // InternalModelDraw.g:5180:1: ( ( rule__Level__Group_6__0 )? )
            {
            // InternalModelDraw.g:5180:1: ( ( rule__Level__Group_6__0 )? )
            // InternalModelDraw.g:5181:2: ( rule__Level__Group_6__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_6()); 
            // InternalModelDraw.g:5182:2: ( rule__Level__Group_6__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==36) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalModelDraw.g:5182:3: rule__Level__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__6__Impl"


    // $ANTLR start "rule__Level__Group__7"
    // InternalModelDraw.g:5190:1: rule__Level__Group__7 : rule__Level__Group__7__Impl rule__Level__Group__8 ;
    public final void rule__Level__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5194:1: ( rule__Level__Group__7__Impl rule__Level__Group__8 )
            // InternalModelDraw.g:5195:2: rule__Level__Group__7__Impl rule__Level__Group__8
            {
            pushFollow(FOLLOW_27);
            rule__Level__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__7"


    // $ANTLR start "rule__Level__Group__7__Impl"
    // InternalModelDraw.g:5202:1: rule__Level__Group__7__Impl : ( ( rule__Level__Group_7__0 )? ) ;
    public final void rule__Level__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5206:1: ( ( ( rule__Level__Group_7__0 )? ) )
            // InternalModelDraw.g:5207:1: ( ( rule__Level__Group_7__0 )? )
            {
            // InternalModelDraw.g:5207:1: ( ( rule__Level__Group_7__0 )? )
            // InternalModelDraw.g:5208:2: ( rule__Level__Group_7__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7()); 
            // InternalModelDraw.g:5209:2: ( rule__Level__Group_7__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==43) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalModelDraw.g:5209:3: rule__Level__Group_7__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__7__Impl"


    // $ANTLR start "rule__Level__Group__8"
    // InternalModelDraw.g:5217:1: rule__Level__Group__8 : rule__Level__Group__8__Impl rule__Level__Group__9 ;
    public final void rule__Level__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5221:1: ( rule__Level__Group__8__Impl rule__Level__Group__9 )
            // InternalModelDraw.g:5222:2: rule__Level__Group__8__Impl rule__Level__Group__9
            {
            pushFollow(FOLLOW_27);
            rule__Level__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__8"


    // $ANTLR start "rule__Level__Group__8__Impl"
    // InternalModelDraw.g:5229:1: rule__Level__Group__8__Impl : ( ( rule__Level__Group_8__0 )? ) ;
    public final void rule__Level__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5233:1: ( ( ( rule__Level__Group_8__0 )? ) )
            // InternalModelDraw.g:5234:1: ( ( rule__Level__Group_8__0 )? )
            {
            // InternalModelDraw.g:5234:1: ( ( rule__Level__Group_8__0 )? )
            // InternalModelDraw.g:5235:2: ( rule__Level__Group_8__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_8()); 
            // InternalModelDraw.g:5236:2: ( rule__Level__Group_8__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==45) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalModelDraw.g:5236:3: rule__Level__Group_8__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_8__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__8__Impl"


    // $ANTLR start "rule__Level__Group__9"
    // InternalModelDraw.g:5244:1: rule__Level__Group__9 : rule__Level__Group__9__Impl rule__Level__Group__10 ;
    public final void rule__Level__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5248:1: ( rule__Level__Group__9__Impl rule__Level__Group__10 )
            // InternalModelDraw.g:5249:2: rule__Level__Group__9__Impl rule__Level__Group__10
            {
            pushFollow(FOLLOW_27);
            rule__Level__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__10();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__9"


    // $ANTLR start "rule__Level__Group__9__Impl"
    // InternalModelDraw.g:5256:1: rule__Level__Group__9__Impl : ( ( rule__Level__Group_9__0 )? ) ;
    public final void rule__Level__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5260:1: ( ( ( rule__Level__Group_9__0 )? ) )
            // InternalModelDraw.g:5261:1: ( ( rule__Level__Group_9__0 )? )
            {
            // InternalModelDraw.g:5261:1: ( ( rule__Level__Group_9__0 )? )
            // InternalModelDraw.g:5262:2: ( rule__Level__Group_9__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_9()); 
            // InternalModelDraw.g:5263:2: ( rule__Level__Group_9__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==46) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalModelDraw.g:5263:3: rule__Level__Group_9__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_9__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__9__Impl"


    // $ANTLR start "rule__Level__Group__10"
    // InternalModelDraw.g:5271:1: rule__Level__Group__10 : rule__Level__Group__10__Impl rule__Level__Group__11 ;
    public final void rule__Level__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5275:1: ( rule__Level__Group__10__Impl rule__Level__Group__11 )
            // InternalModelDraw.g:5276:2: rule__Level__Group__10__Impl rule__Level__Group__11
            {
            pushFollow(FOLLOW_27);
            rule__Level__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group__11();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__10"


    // $ANTLR start "rule__Level__Group__10__Impl"
    // InternalModelDraw.g:5283:1: rule__Level__Group__10__Impl : ( ( rule__Level__Group_10__0 )? ) ;
    public final void rule__Level__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5287:1: ( ( ( rule__Level__Group_10__0 )? ) )
            // InternalModelDraw.g:5288:1: ( ( rule__Level__Group_10__0 )? )
            {
            // InternalModelDraw.g:5288:1: ( ( rule__Level__Group_10__0 )? )
            // InternalModelDraw.g:5289:2: ( rule__Level__Group_10__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_10()); 
            // InternalModelDraw.g:5290:2: ( rule__Level__Group_10__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==47) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalModelDraw.g:5290:3: rule__Level__Group_10__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_10__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_10()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__10__Impl"


    // $ANTLR start "rule__Level__Group__11"
    // InternalModelDraw.g:5298:1: rule__Level__Group__11 : rule__Level__Group__11__Impl ;
    public final void rule__Level__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5302:1: ( rule__Level__Group__11__Impl )
            // InternalModelDraw.g:5303:2: rule__Level__Group__11__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group__11__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__11"


    // $ANTLR start "rule__Level__Group__11__Impl"
    // InternalModelDraw.g:5309:1: rule__Level__Group__11__Impl : ( ( rule__Level__Group_11__0 )? ) ;
    public final void rule__Level__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5313:1: ( ( ( rule__Level__Group_11__0 )? ) )
            // InternalModelDraw.g:5314:1: ( ( rule__Level__Group_11__0 )? )
            {
            // InternalModelDraw.g:5314:1: ( ( rule__Level__Group_11__0 )? )
            // InternalModelDraw.g:5315:2: ( rule__Level__Group_11__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_11()); 
            // InternalModelDraw.g:5316:2: ( rule__Level__Group_11__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==48) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalModelDraw.g:5316:3: rule__Level__Group_11__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_11__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_11()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group__11__Impl"


    // $ANTLR start "rule__Level__Group_6__0"
    // InternalModelDraw.g:5325:1: rule__Level__Group_6__0 : rule__Level__Group_6__0__Impl rule__Level__Group_6__1 ;
    public final void rule__Level__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5329:1: ( rule__Level__Group_6__0__Impl rule__Level__Group_6__1 )
            // InternalModelDraw.g:5330:2: rule__Level__Group_6__0__Impl rule__Level__Group_6__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_6__0"


    // $ANTLR start "rule__Level__Group_6__0__Impl"
    // InternalModelDraw.g:5337:1: rule__Level__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Level__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5341:1: ( ( '=' ) )
            // InternalModelDraw.g:5342:1: ( '=' )
            {
            // InternalModelDraw.g:5342:1: ( '=' )
            // InternalModelDraw.g:5343:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_6__0__Impl"


    // $ANTLR start "rule__Level__Group_6__1"
    // InternalModelDraw.g:5352:1: rule__Level__Group_6__1 : rule__Level__Group_6__1__Impl ;
    public final void rule__Level__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5356:1: ( rule__Level__Group_6__1__Impl )
            // InternalModelDraw.g:5357:2: rule__Level__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_6__1"


    // $ANTLR start "rule__Level__Group_6__1__Impl"
    // InternalModelDraw.g:5363:1: rule__Level__Group_6__1__Impl : ( ( rule__Level__AttNameAssignment_6_1 ) ) ;
    public final void rule__Level__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5367:1: ( ( ( rule__Level__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:5368:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:5368:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:5369:2: ( rule__Level__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getLevelAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:5370:2: ( rule__Level__AttNameAssignment_6_1 )
            // InternalModelDraw.g:5370:3: rule__Level__AttNameAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__AttNameAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getAttNameAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_6__1__Impl"


    // $ANTLR start "rule__Level__Group_7__0"
    // InternalModelDraw.g:5379:1: rule__Level__Group_7__0 : rule__Level__Group_7__0__Impl rule__Level__Group_7__1 ;
    public final void rule__Level__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5383:1: ( rule__Level__Group_7__0__Impl rule__Level__Group_7__1 )
            // InternalModelDraw.g:5384:2: rule__Level__Group_7__0__Impl rule__Level__Group_7__1
            {
            pushFollow(FOLLOW_18);
            rule__Level__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__0"


    // $ANTLR start "rule__Level__Group_7__0__Impl"
    // InternalModelDraw.g:5391:1: rule__Level__Group_7__0__Impl : ( 'label' ) ;
    public final void rule__Level__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5395:1: ( ( 'label' ) )
            // InternalModelDraw.g:5396:1: ( 'label' )
            {
            // InternalModelDraw.g:5396:1: ( 'label' )
            // InternalModelDraw.g:5397:2: 'label'
            {
             before(grammarAccess.getLevelAccess().getLabelKeyword_7_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLabelKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__0__Impl"


    // $ANTLR start "rule__Level__Group_7__1"
    // InternalModelDraw.g:5406:1: rule__Level__Group_7__1 : rule__Level__Group_7__1__Impl rule__Level__Group_7__2 ;
    public final void rule__Level__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5410:1: ( rule__Level__Group_7__1__Impl rule__Level__Group_7__2 )
            // InternalModelDraw.g:5411:2: rule__Level__Group_7__1__Impl rule__Level__Group_7__2
            {
            pushFollow(FOLLOW_29);
            rule__Level__Group_7__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__1"


    // $ANTLR start "rule__Level__Group_7__1__Impl"
    // InternalModelDraw.g:5418:1: rule__Level__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5422:1: ( ( '=' ) )
            // InternalModelDraw.g:5423:1: ( '=' )
            {
            // InternalModelDraw.g:5423:1: ( '=' )
            // InternalModelDraw.g:5424:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__1__Impl"


    // $ANTLR start "rule__Level__Group_7__2"
    // InternalModelDraw.g:5433:1: rule__Level__Group_7__2 : rule__Level__Group_7__2__Impl ;
    public final void rule__Level__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5437:1: ( rule__Level__Group_7__2__Impl )
            // InternalModelDraw.g:5438:2: rule__Level__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__2"


    // $ANTLR start "rule__Level__Group_7__2__Impl"
    // InternalModelDraw.g:5444:1: rule__Level__Group_7__2__Impl : ( ( rule__Level__Alternatives_7_2 ) ) ;
    public final void rule__Level__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5448:1: ( ( ( rule__Level__Alternatives_7_2 ) ) )
            // InternalModelDraw.g:5449:1: ( ( rule__Level__Alternatives_7_2 ) )
            {
            // InternalModelDraw.g:5449:1: ( ( rule__Level__Alternatives_7_2 ) )
            // InternalModelDraw.g:5450:2: ( rule__Level__Alternatives_7_2 )
            {
             before(grammarAccess.getLevelAccess().getAlternatives_7_2()); 
            // InternalModelDraw.g:5451:2: ( rule__Level__Alternatives_7_2 )
            // InternalModelDraw.g:5451:3: rule__Level__Alternatives_7_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__Alternatives_7_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getAlternatives_7_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_0__0"
    // InternalModelDraw.g:5460:1: rule__Level__Group_7_2_0__0 : rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1 ;
    public final void rule__Level__Group_7_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5464:1: ( rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1 )
            // InternalModelDraw.g:5465:2: rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0__0"


    // $ANTLR start "rule__Level__Group_7_2_0__0__Impl"
    // InternalModelDraw.g:5472:1: rule__Level__Group_7_2_0__0__Impl : ( ( rule__Level__Group_7_2_0_0__0 )? ) ;
    public final void rule__Level__Group_7_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5476:1: ( ( ( rule__Level__Group_7_2_0_0__0 )? ) )
            // InternalModelDraw.g:5477:1: ( ( rule__Level__Group_7_2_0_0__0 )? )
            {
            // InternalModelDraw.g:5477:1: ( ( rule__Level__Group_7_2_0_0__0 )? )
            // InternalModelDraw.g:5478:2: ( rule__Level__Group_7_2_0_0__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_0_0()); 
            // InternalModelDraw.g:5479:2: ( rule__Level__Group_7_2_0_0__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( (LA57_1==35||LA57_1==44) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalModelDraw.g:5479:3: rule__Level__Group_7_2_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_0_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_0__1"
    // InternalModelDraw.g:5487:1: rule__Level__Group_7_2_0__1 : rule__Level__Group_7_2_0__1__Impl ;
    public final void rule__Level__Group_7_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5491:1: ( rule__Level__Group_7_2_0__1__Impl )
            // InternalModelDraw.g:5492:2: rule__Level__Group_7_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0__1"


    // $ANTLR start "rule__Level__Group_7_2_0__1__Impl"
    // InternalModelDraw.g:5498:1: rule__Level__Group_7_2_0__1__Impl : ( ( rule__Level__LabelAssignment_7_2_0_1 ) ) ;
    public final void rule__Level__Group_7_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5502:1: ( ( ( rule__Level__LabelAssignment_7_2_0_1 ) ) )
            // InternalModelDraw.g:5503:1: ( ( rule__Level__LabelAssignment_7_2_0_1 ) )
            {
            // InternalModelDraw.g:5503:1: ( ( rule__Level__LabelAssignment_7_2_0_1 ) )
            // InternalModelDraw.g:5504:2: ( rule__Level__LabelAssignment_7_2_0_1 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_0_1()); 
            // InternalModelDraw.g:5505:2: ( rule__Level__LabelAssignment_7_2_0_1 )
            // InternalModelDraw.g:5505:3: rule__Level__LabelAssignment_7_2_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__LabelAssignment_7_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getLabelAssignment_7_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_0_0__0"
    // InternalModelDraw.g:5514:1: rule__Level__Group_7_2_0_0__0 : rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1 ;
    public final void rule__Level__Group_7_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5518:1: ( rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1 )
            // InternalModelDraw.g:5519:2: rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0__0"


    // $ANTLR start "rule__Level__Group_7_2_0_0__0__Impl"
    // InternalModelDraw.g:5526:1: rule__Level__Group_7_2_0_0__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) ) ;
    public final void rule__Level__Group_7_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5530:1: ( ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) ) )
            // InternalModelDraw.g:5531:1: ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) )
            {
            // InternalModelDraw.g:5531:1: ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) )
            // InternalModelDraw.g:5532:2: ( rule__Level__ReferenceAssignment_7_2_0_0_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_0_0_0()); 
            // InternalModelDraw.g:5533:2: ( rule__Level__ReferenceAssignment_7_2_0_0_0 )
            // InternalModelDraw.g:5533:3: rule__Level__ReferenceAssignment_7_2_0_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Level__ReferenceAssignment_7_2_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_0_0__1"
    // InternalModelDraw.g:5541:1: rule__Level__Group_7_2_0_0__1 : rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2 ;
    public final void rule__Level__Group_7_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5545:1: ( rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2 )
            // InternalModelDraw.g:5546:2: rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_0_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_0_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0__1"


    // $ANTLR start "rule__Level__Group_7_2_0_0__1__Impl"
    // InternalModelDraw.g:5553:1: rule__Level__Group_7_2_0_0__1__Impl : ( ( rule__Level__Group_7_2_0_0_1__0 )? ) ;
    public final void rule__Level__Group_7_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5557:1: ( ( ( rule__Level__Group_7_2_0_0_1__0 )? ) )
            // InternalModelDraw.g:5558:1: ( ( rule__Level__Group_7_2_0_0_1__0 )? )
            {
            // InternalModelDraw.g:5558:1: ( ( rule__Level__Group_7_2_0_0_1__0 )? )
            // InternalModelDraw.g:5559:2: ( rule__Level__Group_7_2_0_0_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_0_0_1()); 
            // InternalModelDraw.g:5560:2: ( rule__Level__Group_7_2_0_0_1__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==35) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalModelDraw.g:5560:3: rule__Level__Group_7_2_0_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_0_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_0_0__2"
    // InternalModelDraw.g:5568:1: rule__Level__Group_7_2_0_0__2 : rule__Level__Group_7_2_0_0__2__Impl ;
    public final void rule__Level__Group_7_2_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5572:1: ( rule__Level__Group_7_2_0_0__2__Impl )
            // InternalModelDraw.g:5573:2: rule__Level__Group_7_2_0_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_0_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0__2"


    // $ANTLR start "rule__Level__Group_7_2_0_0__2__Impl"
    // InternalModelDraw.g:5579:1: rule__Level__Group_7_2_0_0__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5583:1: ( ( '.' ) )
            // InternalModelDraw.g:5584:1: ( '.' )
            {
            // InternalModelDraw.g:5584:1: ( '.' )
            // InternalModelDraw.g:5585:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_0_0_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_0_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_0_0_1__0"
    // InternalModelDraw.g:5595:1: rule__Level__Group_7_2_0_0_1__0 : rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1 ;
    public final void rule__Level__Group_7_2_0_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5599:1: ( rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1 )
            // InternalModelDraw.g:5600:2: rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_0_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_0_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0_1__0"


    // $ANTLR start "rule__Level__Group_7_2_0_0_1__0__Impl"
    // InternalModelDraw.g:5607:1: rule__Level__Group_7_2_0_0_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_0_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5611:1: ( ( '->' ) )
            // InternalModelDraw.g:5612:1: ( '->' )
            {
            // InternalModelDraw.g:5612:1: ( '->' )
            // InternalModelDraw.g:5613:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_0_0_1__1"
    // InternalModelDraw.g:5622:1: rule__Level__Group_7_2_0_0_1__1 : rule__Level__Group_7_2_0_0_1__1__Impl ;
    public final void rule__Level__Group_7_2_0_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5626:1: ( rule__Level__Group_7_2_0_0_1__1__Impl )
            // InternalModelDraw.g:5627:2: rule__Level__Group_7_2_0_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_0_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0_1__1"


    // $ANTLR start "rule__Level__Group_7_2_0_0_1__1__Impl"
    // InternalModelDraw.g:5633:1: rule__Level__Group_7_2_0_0_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) ) ;
    public final void rule__Level__Group_7_2_0_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5637:1: ( ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) ) )
            // InternalModelDraw.g:5638:1: ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) )
            {
            // InternalModelDraw.g:5638:1: ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) )
            // InternalModelDraw.g:5639:2: ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_0_0_1_1()); 
            // InternalModelDraw.g:5640:2: ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 )
            // InternalModelDraw.g:5640:3: rule__Level__RefTypeAssignment_7_2_0_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__RefTypeAssignment_7_2_0_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_0_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_0_0_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1__0"
    // InternalModelDraw.g:5649:1: rule__Level__Group_7_2_1__0 : rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1 ;
    public final void rule__Level__Group_7_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5653:1: ( rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1 )
            // InternalModelDraw.g:5654:2: rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1__0__Impl"
    // InternalModelDraw.g:5661:1: rule__Level__Group_7_2_1__0__Impl : ( '{' ) ;
    public final void rule__Level__Group_7_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5665:1: ( ( '{' ) )
            // InternalModelDraw.g:5666:1: ( '{' )
            {
            // InternalModelDraw.g:5666:1: ( '{' )
            // InternalModelDraw.g:5667:2: '{'
            {
             before(grammarAccess.getLevelAccess().getLeftCurlyBracketKeyword_7_2_1_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLeftCurlyBracketKeyword_7_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1__1"
    // InternalModelDraw.g:5676:1: rule__Level__Group_7_2_1__1 : rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2 ;
    public final void rule__Level__Group_7_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5680:1: ( rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2 )
            // InternalModelDraw.g:5681:2: rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1__1__Impl"
    // InternalModelDraw.g:5688:1: rule__Level__Group_7_2_1__1__Impl : ( ( rule__Level__Group_7_2_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5692:1: ( ( ( rule__Level__Group_7_2_1_1__0 )? ) )
            // InternalModelDraw.g:5693:1: ( ( rule__Level__Group_7_2_1_1__0 )? )
            {
            // InternalModelDraw.g:5693:1: ( ( rule__Level__Group_7_2_1_1__0 )? )
            // InternalModelDraw.g:5694:2: ( rule__Level__Group_7_2_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_1()); 
            // InternalModelDraw.g:5695:2: ( rule__Level__Group_7_2_1_1__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==35||LA59_1==44) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalModelDraw.g:5695:3: rule__Level__Group_7_2_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1__2"
    // InternalModelDraw.g:5703:1: rule__Level__Group_7_2_1__2 : rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3 ;
    public final void rule__Level__Group_7_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5707:1: ( rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3 )
            // InternalModelDraw.g:5708:2: rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3
            {
            pushFollow(FOLLOW_31);
            rule__Level__Group_7_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__2"


    // $ANTLR start "rule__Level__Group_7_2_1__2__Impl"
    // InternalModelDraw.g:5715:1: rule__Level__Group_7_2_1__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_2 ) ) ;
    public final void rule__Level__Group_7_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5719:1: ( ( ( rule__Level__LabelAssignment_7_2_1_2 ) ) )
            // InternalModelDraw.g:5720:1: ( ( rule__Level__LabelAssignment_7_2_1_2 ) )
            {
            // InternalModelDraw.g:5720:1: ( ( rule__Level__LabelAssignment_7_2_1_2 ) )
            // InternalModelDraw.g:5721:2: ( rule__Level__LabelAssignment_7_2_1_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_2()); 
            // InternalModelDraw.g:5722:2: ( rule__Level__LabelAssignment_7_2_1_2 )
            // InternalModelDraw.g:5722:3: rule__Level__LabelAssignment_7_2_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__LabelAssignment_7_2_1_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1__3"
    // InternalModelDraw.g:5730:1: rule__Level__Group_7_2_1__3 : rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4 ;
    public final void rule__Level__Group_7_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5734:1: ( rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4 )
            // InternalModelDraw.g:5735:2: rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4
            {
            pushFollow(FOLLOW_31);
            rule__Level__Group_7_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__3"


    // $ANTLR start "rule__Level__Group_7_2_1__3__Impl"
    // InternalModelDraw.g:5742:1: rule__Level__Group_7_2_1__3__Impl : ( ( rule__Level__Group_7_2_1_3__0 )? ) ;
    public final void rule__Level__Group_7_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5746:1: ( ( ( rule__Level__Group_7_2_1_3__0 )? ) )
            // InternalModelDraw.g:5747:1: ( ( rule__Level__Group_7_2_1_3__0 )? )
            {
            // InternalModelDraw.g:5747:1: ( ( rule__Level__Group_7_2_1_3__0 )? )
            // InternalModelDraw.g:5748:2: ( rule__Level__Group_7_2_1_3__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3()); 
            // InternalModelDraw.g:5749:2: ( rule__Level__Group_7_2_1_3__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==32) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalModelDraw.g:5749:3: rule__Level__Group_7_2_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__3__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1__4"
    // InternalModelDraw.g:5757:1: rule__Level__Group_7_2_1__4 : rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5 ;
    public final void rule__Level__Group_7_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5761:1: ( rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5 )
            // InternalModelDraw.g:5762:2: rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5
            {
            pushFollow(FOLLOW_31);
            rule__Level__Group_7_2_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__4"


    // $ANTLR start "rule__Level__Group_7_2_1__4__Impl"
    // InternalModelDraw.g:5769:1: rule__Level__Group_7_2_1__4__Impl : ( ( rule__Level__Group_7_2_1_4__0 )* ) ;
    public final void rule__Level__Group_7_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5773:1: ( ( ( rule__Level__Group_7_2_1_4__0 )* ) )
            // InternalModelDraw.g:5774:1: ( ( rule__Level__Group_7_2_1_4__0 )* )
            {
            // InternalModelDraw.g:5774:1: ( ( rule__Level__Group_7_2_1_4__0 )* )
            // InternalModelDraw.g:5775:2: ( rule__Level__Group_7_2_1_4__0 )*
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4()); 
            // InternalModelDraw.g:5776:2: ( rule__Level__Group_7_2_1_4__0 )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==34) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalModelDraw.g:5776:3: rule__Level__Group_7_2_1_4__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Level__Group_7_2_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__4__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1__5"
    // InternalModelDraw.g:5784:1: rule__Level__Group_7_2_1__5 : rule__Level__Group_7_2_1__5__Impl ;
    public final void rule__Level__Group_7_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5788:1: ( rule__Level__Group_7_2_1__5__Impl )
            // InternalModelDraw.g:5789:2: rule__Level__Group_7_2_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__5"


    // $ANTLR start "rule__Level__Group_7_2_1__5__Impl"
    // InternalModelDraw.g:5795:1: rule__Level__Group_7_2_1__5__Impl : ( '}' ) ;
    public final void rule__Level__Group_7_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5799:1: ( ( '}' ) )
            // InternalModelDraw.g:5800:1: ( '}' )
            {
            // InternalModelDraw.g:5800:1: ( '}' )
            // InternalModelDraw.g:5801:2: '}'
            {
             before(grammarAccess.getLevelAccess().getRightCurlyBracketKeyword_7_2_1_5()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRightCurlyBracketKeyword_7_2_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1__5__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_1__0"
    // InternalModelDraw.g:5811:1: rule__Level__Group_7_2_1_1__0 : rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1 ;
    public final void rule__Level__Group_7_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5815:1: ( rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1 )
            // InternalModelDraw.g:5816:2: rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_1__0__Impl"
    // InternalModelDraw.g:5823:1: rule__Level__Group_7_2_1_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5827:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) ) )
            // InternalModelDraw.g:5828:1: ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) )
            {
            // InternalModelDraw.g:5828:1: ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) )
            // InternalModelDraw.g:5829:2: ( rule__Level__ReferenceAssignment_7_2_1_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_1_0()); 
            // InternalModelDraw.g:5830:2: ( rule__Level__ReferenceAssignment_7_2_1_1_0 )
            // InternalModelDraw.g:5830:3: rule__Level__ReferenceAssignment_7_2_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Level__ReferenceAssignment_7_2_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_1__1"
    // InternalModelDraw.g:5838:1: rule__Level__Group_7_2_1_1__1 : rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2 ;
    public final void rule__Level__Group_7_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5842:1: ( rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2 )
            // InternalModelDraw.g:5843:2: rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_1__1__Impl"
    // InternalModelDraw.g:5850:1: rule__Level__Group_7_2_1_1__1__Impl : ( ( rule__Level__Group_7_2_1_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5854:1: ( ( ( rule__Level__Group_7_2_1_1_1__0 )? ) )
            // InternalModelDraw.g:5855:1: ( ( rule__Level__Group_7_2_1_1_1__0 )? )
            {
            // InternalModelDraw.g:5855:1: ( ( rule__Level__Group_7_2_1_1_1__0 )? )
            // InternalModelDraw.g:5856:2: ( rule__Level__Group_7_2_1_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_1_1()); 
            // InternalModelDraw.g:5857:2: ( rule__Level__Group_7_2_1_1_1__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==35) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalModelDraw.g:5857:3: rule__Level__Group_7_2_1_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_1__2"
    // InternalModelDraw.g:5865:1: rule__Level__Group_7_2_1_1__2 : rule__Level__Group_7_2_1_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5869:1: ( rule__Level__Group_7_2_1_1__2__Impl )
            // InternalModelDraw.g:5870:2: rule__Level__Group_7_2_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1__2"


    // $ANTLR start "rule__Level__Group_7_2_1_1__2__Impl"
    // InternalModelDraw.g:5876:1: rule__Level__Group_7_2_1_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5880:1: ( ( '.' ) )
            // InternalModelDraw.g:5881:1: ( '.' )
            {
            // InternalModelDraw.g:5881:1: ( '.' )
            // InternalModelDraw.g:5882:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_1_1__0"
    // InternalModelDraw.g:5892:1: rule__Level__Group_7_2_1_1_1__0 : rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1 ;
    public final void rule__Level__Group_7_2_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5896:1: ( rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1 )
            // InternalModelDraw.g:5897:2: rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_1_1__0__Impl"
    // InternalModelDraw.g:5904:1: rule__Level__Group_7_2_1_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5908:1: ( ( '->' ) )
            // InternalModelDraw.g:5909:1: ( '->' )
            {
            // InternalModelDraw.g:5909:1: ( '->' )
            // InternalModelDraw.g:5910:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_1_1__1"
    // InternalModelDraw.g:5919:1: rule__Level__Group_7_2_1_1_1__1 : rule__Level__Group_7_2_1_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5923:1: ( rule__Level__Group_7_2_1_1_1__1__Impl )
            // InternalModelDraw.g:5924:2: rule__Level__Group_7_2_1_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_1_1__1__Impl"
    // InternalModelDraw.g:5930:1: rule__Level__Group_7_2_1_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5934:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) ) )
            // InternalModelDraw.g:5935:1: ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) )
            {
            // InternalModelDraw.g:5935:1: ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) )
            // InternalModelDraw.g:5936:2: ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_1_1_1()); 
            // InternalModelDraw.g:5937:2: ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 )
            // InternalModelDraw.g:5937:3: rule__Level__RefTypeAssignment_7_2_1_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__RefTypeAssignment_7_2_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_1_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3__0"
    // InternalModelDraw.g:5946:1: rule__Level__Group_7_2_1_3__0 : rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1 ;
    public final void rule__Level__Group_7_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5950:1: ( rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1 )
            // InternalModelDraw.g:5951:2: rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__0"


    // $ANTLR start "rule__Level__Group_7_2_1_3__0__Impl"
    // InternalModelDraw.g:5958:1: rule__Level__Group_7_2_1_3__0__Impl : ( '(' ) ;
    public final void rule__Level__Group_7_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5962:1: ( ( '(' ) )
            // InternalModelDraw.g:5963:1: ( '(' )
            {
            // InternalModelDraw.g:5963:1: ( '(' )
            // InternalModelDraw.g:5964:2: '('
            {
             before(grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_3_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3__1"
    // InternalModelDraw.g:5973:1: rule__Level__Group_7_2_1_3__1 : rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2 ;
    public final void rule__Level__Group_7_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5977:1: ( rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2 )
            // InternalModelDraw.g:5978:2: rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__1"


    // $ANTLR start "rule__Level__Group_7_2_1_3__1__Impl"
    // InternalModelDraw.g:5985:1: rule__Level__Group_7_2_1_3__1__Impl : ( ( rule__Level__Group_7_2_1_3_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5989:1: ( ( ( rule__Level__Group_7_2_1_3_1__0 )? ) )
            // InternalModelDraw.g:5990:1: ( ( rule__Level__Group_7_2_1_3_1__0 )? )
            {
            // InternalModelDraw.g:5990:1: ( ( rule__Level__Group_7_2_1_3_1__0 )? )
            // InternalModelDraw.g:5991:2: ( rule__Level__Group_7_2_1_3_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1()); 
            // InternalModelDraw.g:5992:2: ( rule__Level__Group_7_2_1_3_1__0 )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==RULE_ID) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==35||LA63_1==44) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // InternalModelDraw.g:5992:3: rule__Level__Group_7_2_1_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3__2"
    // InternalModelDraw.g:6000:1: rule__Level__Group_7_2_1_3__2 : rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3 ;
    public final void rule__Level__Group_7_2_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6004:1: ( rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3 )
            // InternalModelDraw.g:6005:2: rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3
            {
            pushFollow(FOLLOW_20);
            rule__Level__Group_7_2_1_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__2"


    // $ANTLR start "rule__Level__Group_7_2_1_3__2__Impl"
    // InternalModelDraw.g:6012:1: rule__Level__Group_7_2_1_3__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) ) ;
    public final void rule__Level__Group_7_2_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6016:1: ( ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) ) )
            // InternalModelDraw.g:6017:1: ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) )
            {
            // InternalModelDraw.g:6017:1: ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) )
            // InternalModelDraw.g:6018:2: ( rule__Level__LabelAssignment_7_2_1_3_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_3_2()); 
            // InternalModelDraw.g:6019:2: ( rule__Level__LabelAssignment_7_2_1_3_2 )
            // InternalModelDraw.g:6019:3: rule__Level__LabelAssignment_7_2_1_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__LabelAssignment_7_2_1_3_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3__3"
    // InternalModelDraw.g:6027:1: rule__Level__Group_7_2_1_3__3 : rule__Level__Group_7_2_1_3__3__Impl ;
    public final void rule__Level__Group_7_2_1_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6031:1: ( rule__Level__Group_7_2_1_3__3__Impl )
            // InternalModelDraw.g:6032:2: rule__Level__Group_7_2_1_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__3"


    // $ANTLR start "rule__Level__Group_7_2_1_3__3__Impl"
    // InternalModelDraw.g:6038:1: rule__Level__Group_7_2_1_3__3__Impl : ( ')' ) ;
    public final void rule__Level__Group_7_2_1_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6042:1: ( ( ')' ) )
            // InternalModelDraw.g:6043:1: ( ')' )
            {
            // InternalModelDraw.g:6043:1: ( ')' )
            // InternalModelDraw.g:6044:2: ')'
            {
             before(grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_3_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3__3__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1__0"
    // InternalModelDraw.g:6054:1: rule__Level__Group_7_2_1_3_1__0 : rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1 ;
    public final void rule__Level__Group_7_2_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6058:1: ( rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1 )
            // InternalModelDraw.g:6059:2: rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1__0__Impl"
    // InternalModelDraw.g:6066:1: rule__Level__Group_7_2_1_3_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6070:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) ) )
            // InternalModelDraw.g:6071:1: ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) )
            {
            // InternalModelDraw.g:6071:1: ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) )
            // InternalModelDraw.g:6072:2: ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_3_1_0()); 
            // InternalModelDraw.g:6073:2: ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 )
            // InternalModelDraw.g:6073:3: rule__Level__ReferenceAssignment_7_2_1_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Level__ReferenceAssignment_7_2_1_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1__1"
    // InternalModelDraw.g:6081:1: rule__Level__Group_7_2_1_3_1__1 : rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2 ;
    public final void rule__Level__Group_7_2_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6085:1: ( rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2 )
            // InternalModelDraw.g:6086:2: rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1__1__Impl"
    // InternalModelDraw.g:6093:1: rule__Level__Group_7_2_1_3_1__1__Impl : ( ( rule__Level__Group_7_2_1_3_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6097:1: ( ( ( rule__Level__Group_7_2_1_3_1_1__0 )? ) )
            // InternalModelDraw.g:6098:1: ( ( rule__Level__Group_7_2_1_3_1_1__0 )? )
            {
            // InternalModelDraw.g:6098:1: ( ( rule__Level__Group_7_2_1_3_1_1__0 )? )
            // InternalModelDraw.g:6099:2: ( rule__Level__Group_7_2_1_3_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1_1()); 
            // InternalModelDraw.g:6100:2: ( rule__Level__Group_7_2_1_3_1_1__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==35) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalModelDraw.g:6100:3: rule__Level__Group_7_2_1_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_3_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1__2"
    // InternalModelDraw.g:6108:1: rule__Level__Group_7_2_1_3_1__2 : rule__Level__Group_7_2_1_3_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6112:1: ( rule__Level__Group_7_2_1_3_1__2__Impl )
            // InternalModelDraw.g:6113:2: rule__Level__Group_7_2_1_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1__2"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1__2__Impl"
    // InternalModelDraw.g:6119:1: rule__Level__Group_7_2_1_3_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6123:1: ( ( '.' ) )
            // InternalModelDraw.g:6124:1: ( '.' )
            {
            // InternalModelDraw.g:6124:1: ( '.' )
            // InternalModelDraw.g:6125:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_3_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1_1__0"
    // InternalModelDraw.g:6135:1: rule__Level__Group_7_2_1_3_1_1__0 : rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1 ;
    public final void rule__Level__Group_7_2_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6139:1: ( rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1 )
            // InternalModelDraw.g:6140:2: rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1_1__0__Impl"
    // InternalModelDraw.g:6147:1: rule__Level__Group_7_2_1_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6151:1: ( ( '->' ) )
            // InternalModelDraw.g:6152:1: ( '->' )
            {
            // InternalModelDraw.g:6152:1: ( '->' )
            // InternalModelDraw.g:6153:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1_1__1"
    // InternalModelDraw.g:6162:1: rule__Level__Group_7_2_1_3_1_1__1 : rule__Level__Group_7_2_1_3_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6166:1: ( rule__Level__Group_7_2_1_3_1_1__1__Impl )
            // InternalModelDraw.g:6167:2: rule__Level__Group_7_2_1_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_3_1_1__1__Impl"
    // InternalModelDraw.g:6173:1: rule__Level__Group_7_2_1_3_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6177:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) ) )
            // InternalModelDraw.g:6178:1: ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            {
            // InternalModelDraw.g:6178:1: ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            // InternalModelDraw.g:6179:2: ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_3_1_1_1()); 
            // InternalModelDraw.g:6180:2: ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 )
            // InternalModelDraw.g:6180:3: rule__Level__RefTypeAssignment_7_2_1_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__RefTypeAssignment_7_2_1_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_3_1_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4__0"
    // InternalModelDraw.g:6189:1: rule__Level__Group_7_2_1_4__0 : rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1 ;
    public final void rule__Level__Group_7_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6193:1: ( rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1 )
            // InternalModelDraw.g:6194:2: rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__0"


    // $ANTLR start "rule__Level__Group_7_2_1_4__0__Impl"
    // InternalModelDraw.g:6201:1: rule__Level__Group_7_2_1_4__0__Impl : ( ',' ) ;
    public final void rule__Level__Group_7_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6205:1: ( ( ',' ) )
            // InternalModelDraw.g:6206:1: ( ',' )
            {
            // InternalModelDraw.g:6206:1: ( ',' )
            // InternalModelDraw.g:6207:2: ','
            {
             before(grammarAccess.getLevelAccess().getCommaKeyword_7_2_1_4_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getCommaKeyword_7_2_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4__1"
    // InternalModelDraw.g:6216:1: rule__Level__Group_7_2_1_4__1 : rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2 ;
    public final void rule__Level__Group_7_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6220:1: ( rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2 )
            // InternalModelDraw.g:6221:2: rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__1"


    // $ANTLR start "rule__Level__Group_7_2_1_4__1__Impl"
    // InternalModelDraw.g:6228:1: rule__Level__Group_7_2_1_4__1__Impl : ( ( rule__Level__Group_7_2_1_4_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6232:1: ( ( ( rule__Level__Group_7_2_1_4_1__0 )? ) )
            // InternalModelDraw.g:6233:1: ( ( rule__Level__Group_7_2_1_4_1__0 )? )
            {
            // InternalModelDraw.g:6233:1: ( ( rule__Level__Group_7_2_1_4_1__0 )? )
            // InternalModelDraw.g:6234:2: ( rule__Level__Group_7_2_1_4_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1()); 
            // InternalModelDraw.g:6235:2: ( rule__Level__Group_7_2_1_4_1__0 )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==RULE_ID) ) {
                int LA65_1 = input.LA(2);

                if ( (LA65_1==35||LA65_1==44) ) {
                    alt65=1;
                }
            }
            switch (alt65) {
                case 1 :
                    // InternalModelDraw.g:6235:3: rule__Level__Group_7_2_1_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_4_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4__2"
    // InternalModelDraw.g:6243:1: rule__Level__Group_7_2_1_4__2 : rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3 ;
    public final void rule__Level__Group_7_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6247:1: ( rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3 )
            // InternalModelDraw.g:6248:2: rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3
            {
            pushFollow(FOLLOW_17);
            rule__Level__Group_7_2_1_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__2"


    // $ANTLR start "rule__Level__Group_7_2_1_4__2__Impl"
    // InternalModelDraw.g:6255:1: rule__Level__Group_7_2_1_4__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) ) ;
    public final void rule__Level__Group_7_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6259:1: ( ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) ) )
            // InternalModelDraw.g:6260:1: ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) )
            {
            // InternalModelDraw.g:6260:1: ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) )
            // InternalModelDraw.g:6261:2: ( rule__Level__LabelAssignment_7_2_1_4_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_2()); 
            // InternalModelDraw.g:6262:2: ( rule__Level__LabelAssignment_7_2_1_4_2 )
            // InternalModelDraw.g:6262:3: rule__Level__LabelAssignment_7_2_1_4_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__LabelAssignment_7_2_1_4_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4__3"
    // InternalModelDraw.g:6270:1: rule__Level__Group_7_2_1_4__3 : rule__Level__Group_7_2_1_4__3__Impl ;
    public final void rule__Level__Group_7_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6274:1: ( rule__Level__Group_7_2_1_4__3__Impl )
            // InternalModelDraw.g:6275:2: rule__Level__Group_7_2_1_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__3"


    // $ANTLR start "rule__Level__Group_7_2_1_4__3__Impl"
    // InternalModelDraw.g:6281:1: rule__Level__Group_7_2_1_4__3__Impl : ( ( rule__Level__Group_7_2_1_4_3__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6285:1: ( ( ( rule__Level__Group_7_2_1_4_3__0 )? ) )
            // InternalModelDraw.g:6286:1: ( ( rule__Level__Group_7_2_1_4_3__0 )? )
            {
            // InternalModelDraw.g:6286:1: ( ( rule__Level__Group_7_2_1_4_3__0 )? )
            // InternalModelDraw.g:6287:2: ( rule__Level__Group_7_2_1_4_3__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3()); 
            // InternalModelDraw.g:6288:2: ( rule__Level__Group_7_2_1_4_3__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==32) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalModelDraw.g:6288:3: rule__Level__Group_7_2_1_4_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_4_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4__3__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1__0"
    // InternalModelDraw.g:6297:1: rule__Level__Group_7_2_1_4_1__0 : rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1 ;
    public final void rule__Level__Group_7_2_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6301:1: ( rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1 )
            // InternalModelDraw.g:6302:2: rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1__0__Impl"
    // InternalModelDraw.g:6309:1: rule__Level__Group_7_2_1_4_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6313:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) ) )
            // InternalModelDraw.g:6314:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) )
            {
            // InternalModelDraw.g:6314:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) )
            // InternalModelDraw.g:6315:2: ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_1_0()); 
            // InternalModelDraw.g:6316:2: ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 )
            // InternalModelDraw.g:6316:3: rule__Level__ReferenceAssignment_7_2_1_4_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Level__ReferenceAssignment_7_2_1_4_1_0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1__1"
    // InternalModelDraw.g:6324:1: rule__Level__Group_7_2_1_4_1__1 : rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2 ;
    public final void rule__Level__Group_7_2_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6328:1: ( rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2 )
            // InternalModelDraw.g:6329:2: rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1__1__Impl"
    // InternalModelDraw.g:6336:1: rule__Level__Group_7_2_1_4_1__1__Impl : ( ( rule__Level__Group_7_2_1_4_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6340:1: ( ( ( rule__Level__Group_7_2_1_4_1_1__0 )? ) )
            // InternalModelDraw.g:6341:1: ( ( rule__Level__Group_7_2_1_4_1_1__0 )? )
            {
            // InternalModelDraw.g:6341:1: ( ( rule__Level__Group_7_2_1_4_1_1__0 )? )
            // InternalModelDraw.g:6342:2: ( rule__Level__Group_7_2_1_4_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1_1()); 
            // InternalModelDraw.g:6343:2: ( rule__Level__Group_7_2_1_4_1_1__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==35) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalModelDraw.g:6343:3: rule__Level__Group_7_2_1_4_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_4_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1__2"
    // InternalModelDraw.g:6351:1: rule__Level__Group_7_2_1_4_1__2 : rule__Level__Group_7_2_1_4_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6355:1: ( rule__Level__Group_7_2_1_4_1__2__Impl )
            // InternalModelDraw.g:6356:2: rule__Level__Group_7_2_1_4_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1__2"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1__2__Impl"
    // InternalModelDraw.g:6362:1: rule__Level__Group_7_2_1_4_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6366:1: ( ( '.' ) )
            // InternalModelDraw.g:6367:1: ( '.' )
            {
            // InternalModelDraw.g:6367:1: ( '.' )
            // InternalModelDraw.g:6368:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1_1__0"
    // InternalModelDraw.g:6378:1: rule__Level__Group_7_2_1_4_1_1__0 : rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1 ;
    public final void rule__Level__Group_7_2_1_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6382:1: ( rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1 )
            // InternalModelDraw.g:6383:2: rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_4_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1_1__0__Impl"
    // InternalModelDraw.g:6390:1: rule__Level__Group_7_2_1_4_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6394:1: ( ( '->' ) )
            // InternalModelDraw.g:6395:1: ( '->' )
            {
            // InternalModelDraw.g:6395:1: ( '->' )
            // InternalModelDraw.g:6396:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1_1__1"
    // InternalModelDraw.g:6405:1: rule__Level__Group_7_2_1_4_1_1__1 : rule__Level__Group_7_2_1_4_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6409:1: ( rule__Level__Group_7_2_1_4_1_1__1__Impl )
            // InternalModelDraw.g:6410:2: rule__Level__Group_7_2_1_4_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_4_1_1__1__Impl"
    // InternalModelDraw.g:6416:1: rule__Level__Group_7_2_1_4_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6420:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) ) )
            // InternalModelDraw.g:6421:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            {
            // InternalModelDraw.g:6421:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            // InternalModelDraw.g:6422:2: ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_1_1_1()); 
            // InternalModelDraw.g:6423:2: ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 )
            // InternalModelDraw.g:6423:3: rule__Level__RefTypeAssignment_7_2_1_4_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__RefTypeAssignment_7_2_1_4_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_1_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__0"
    // InternalModelDraw.g:6432:1: rule__Level__Group_7_2_1_4_3__0 : rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1 ;
    public final void rule__Level__Group_7_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6436:1: ( rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1 )
            // InternalModelDraw.g:6437:2: rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_4_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__0"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__0__Impl"
    // InternalModelDraw.g:6444:1: rule__Level__Group_7_2_1_4_3__0__Impl : ( '(' ) ;
    public final void rule__Level__Group_7_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6448:1: ( ( '(' ) )
            // InternalModelDraw.g:6449:1: ( '(' )
            {
            // InternalModelDraw.g:6449:1: ( '(' )
            // InternalModelDraw.g:6450:2: '('
            {
             before(grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_4_3_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__1"
    // InternalModelDraw.g:6459:1: rule__Level__Group_7_2_1_4_3__1 : rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2 ;
    public final void rule__Level__Group_7_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6463:1: ( rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2 )
            // InternalModelDraw.g:6464:2: rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_4_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__1"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__1__Impl"
    // InternalModelDraw.g:6471:1: rule__Level__Group_7_2_1_4_3__1__Impl : ( ( rule__Level__Group_7_2_1_4_3_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6475:1: ( ( ( rule__Level__Group_7_2_1_4_3_1__0 )? ) )
            // InternalModelDraw.g:6476:1: ( ( rule__Level__Group_7_2_1_4_3_1__0 )? )
            {
            // InternalModelDraw.g:6476:1: ( ( rule__Level__Group_7_2_1_4_3_1__0 )? )
            // InternalModelDraw.g:6477:2: ( rule__Level__Group_7_2_1_4_3_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1()); 
            // InternalModelDraw.g:6478:2: ( rule__Level__Group_7_2_1_4_3_1__0 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_ID) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==35||LA68_1==44) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // InternalModelDraw.g:6478:3: rule__Level__Group_7_2_1_4_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_4_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__2"
    // InternalModelDraw.g:6486:1: rule__Level__Group_7_2_1_4_3__2 : rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3 ;
    public final void rule__Level__Group_7_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6490:1: ( rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3 )
            // InternalModelDraw.g:6491:2: rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3
            {
            pushFollow(FOLLOW_20);
            rule__Level__Group_7_2_1_4_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__2"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__2__Impl"
    // InternalModelDraw.g:6498:1: rule__Level__Group_7_2_1_4_3__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6502:1: ( ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) ) )
            // InternalModelDraw.g:6503:1: ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) )
            {
            // InternalModelDraw.g:6503:1: ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) )
            // InternalModelDraw.g:6504:2: ( rule__Level__LabelAssignment_7_2_1_4_3_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_3_2()); 
            // InternalModelDraw.g:6505:2: ( rule__Level__LabelAssignment_7_2_1_4_3_2 )
            // InternalModelDraw.g:6505:3: rule__Level__LabelAssignment_7_2_1_4_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__LabelAssignment_7_2_1_4_3_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__3"
    // InternalModelDraw.g:6513:1: rule__Level__Group_7_2_1_4_3__3 : rule__Level__Group_7_2_1_4_3__3__Impl ;
    public final void rule__Level__Group_7_2_1_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6517:1: ( rule__Level__Group_7_2_1_4_3__3__Impl )
            // InternalModelDraw.g:6518:2: rule__Level__Group_7_2_1_4_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__3"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3__3__Impl"
    // InternalModelDraw.g:6524:1: rule__Level__Group_7_2_1_4_3__3__Impl : ( ')' ) ;
    public final void rule__Level__Group_7_2_1_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6528:1: ( ( ')' ) )
            // InternalModelDraw.g:6529:1: ( ')' )
            {
            // InternalModelDraw.g:6529:1: ( ')' )
            // InternalModelDraw.g:6530:2: ')'
            {
             before(grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_4_3_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_4_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3__3__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1__0"
    // InternalModelDraw.g:6540:1: rule__Level__Group_7_2_1_4_3_1__0 : rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1 ;
    public final void rule__Level__Group_7_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6544:1: ( rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1 )
            // InternalModelDraw.g:6545:2: rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_4_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1__0__Impl"
    // InternalModelDraw.g:6552:1: rule__Level__Group_7_2_1_4_3_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6556:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) ) )
            // InternalModelDraw.g:6557:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            {
            // InternalModelDraw.g:6557:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            // InternalModelDraw.g:6558:2: ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_3_1_0()); 
            // InternalModelDraw.g:6559:2: ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 )
            // InternalModelDraw.g:6559:3: rule__Level__ReferenceAssignment_7_2_1_4_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Level__ReferenceAssignment_7_2_1_4_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1__1"
    // InternalModelDraw.g:6567:1: rule__Level__Group_7_2_1_4_3_1__1 : rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2 ;
    public final void rule__Level__Group_7_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6571:1: ( rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2 )
            // InternalModelDraw.g:6572:2: rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_30);
            rule__Level__Group_7_2_1_4_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1__1__Impl"
    // InternalModelDraw.g:6579:1: rule__Level__Group_7_2_1_4_3_1__1__Impl : ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6583:1: ( ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? ) )
            // InternalModelDraw.g:6584:1: ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? )
            {
            // InternalModelDraw.g:6584:1: ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? )
            // InternalModelDraw.g:6585:2: ( rule__Level__Group_7_2_1_4_3_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1_1()); 
            // InternalModelDraw.g:6586:2: ( rule__Level__Group_7_2_1_4_3_1_1__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==35) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalModelDraw.g:6586:3: rule__Level__Group_7_2_1_4_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2_1_4_3_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1__1__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1__2"
    // InternalModelDraw.g:6594:1: rule__Level__Group_7_2_1_4_3_1__2 : rule__Level__Group_7_2_1_4_3_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6598:1: ( rule__Level__Group_7_2_1_4_3_1__2__Impl )
            // InternalModelDraw.g:6599:2: rule__Level__Group_7_2_1_4_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1__2"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1__2__Impl"
    // InternalModelDraw.g:6605:1: rule__Level__Group_7_2_1_4_3_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6609:1: ( ( '.' ) )
            // InternalModelDraw.g:6610:1: ( '.' )
            {
            // InternalModelDraw.g:6610:1: ( '.' )
            // InternalModelDraw.g:6611:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_3_1_2()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1__2__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1_1__0"
    // InternalModelDraw.g:6621:1: rule__Level__Group_7_2_1_4_3_1_1__0 : rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1 ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6625:1: ( rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1 )
            // InternalModelDraw.g:6626:2: rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7_2_1_4_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1_1__0"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1_1__0__Impl"
    // InternalModelDraw.g:6633:1: rule__Level__Group_7_2_1_4_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6637:1: ( ( '->' ) )
            // InternalModelDraw.g:6638:1: ( '->' )
            {
            // InternalModelDraw.g:6638:1: ( '->' )
            // InternalModelDraw.g:6639:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1_1__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1_1__1"
    // InternalModelDraw.g:6648:1: rule__Level__Group_7_2_1_4_3_1_1__1 : rule__Level__Group_7_2_1_4_3_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6652:1: ( rule__Level__Group_7_2_1_4_3_1_1__1__Impl )
            // InternalModelDraw.g:6653:2: rule__Level__Group_7_2_1_4_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2_1_4_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1_1__1"


    // $ANTLR start "rule__Level__Group_7_2_1_4_3_1_1__1__Impl"
    // InternalModelDraw.g:6659:1: rule__Level__Group_7_2_1_4_3_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6663:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) )
            // InternalModelDraw.g:6664:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            {
            // InternalModelDraw.g:6664:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            // InternalModelDraw.g:6665:2: ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_3_1_1_1()); 
            // InternalModelDraw.g:6666:2: ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            // InternalModelDraw.g:6666:3: rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2_1_4_3_1_1__1__Impl"


    // $ANTLR start "rule__Level__Group_8__0"
    // InternalModelDraw.g:6675:1: rule__Level__Group_8__0 : rule__Level__Group_8__0__Impl rule__Level__Group_8__1 ;
    public final void rule__Level__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6679:1: ( rule__Level__Group_8__0__Impl rule__Level__Group_8__1 )
            // InternalModelDraw.g:6680:2: rule__Level__Group_8__0__Impl rule__Level__Group_8__1
            {
            pushFollow(FOLLOW_18);
            rule__Level__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_8__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_8__0"


    // $ANTLR start "rule__Level__Group_8__0__Impl"
    // InternalModelDraw.g:6687:1: rule__Level__Group_8__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Level__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6691:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:6692:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:6692:1: ( 'src_decoration' )
            // InternalModelDraw.g:6693:2: 'src_decoration'
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_8__0__Impl"


    // $ANTLR start "rule__Level__Group_8__1"
    // InternalModelDraw.g:6702:1: rule__Level__Group_8__1 : rule__Level__Group_8__1__Impl rule__Level__Group_8__2 ;
    public final void rule__Level__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6706:1: ( rule__Level__Group_8__1__Impl rule__Level__Group_8__2 )
            // InternalModelDraw.g:6707:2: rule__Level__Group_8__1__Impl rule__Level__Group_8__2
            {
            pushFollow(FOLLOW_32);
            rule__Level__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_8__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_8__1"


    // $ANTLR start "rule__Level__Group_8__1__Impl"
    // InternalModelDraw.g:6714:1: rule__Level__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6718:1: ( ( '=' ) )
            // InternalModelDraw.g:6719:1: ( '=' )
            {
            // InternalModelDraw.g:6719:1: ( '=' )
            // InternalModelDraw.g:6720:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_8__1__Impl"


    // $ANTLR start "rule__Level__Group_8__2"
    // InternalModelDraw.g:6729:1: rule__Level__Group_8__2 : rule__Level__Group_8__2__Impl ;
    public final void rule__Level__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6733:1: ( rule__Level__Group_8__2__Impl )
            // InternalModelDraw.g:6734:2: rule__Level__Group_8__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_8__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_8__2"


    // $ANTLR start "rule__Level__Group_8__2__Impl"
    // InternalModelDraw.g:6740:1: rule__Level__Group_8__2__Impl : ( ( rule__Level__Src_decorationAssignment_8_2 ) ) ;
    public final void rule__Level__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6744:1: ( ( ( rule__Level__Src_decorationAssignment_8_2 ) ) )
            // InternalModelDraw.g:6745:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            {
            // InternalModelDraw.g:6745:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            // InternalModelDraw.g:6746:2: ( rule__Level__Src_decorationAssignment_8_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationAssignment_8_2()); 
            // InternalModelDraw.g:6747:2: ( rule__Level__Src_decorationAssignment_8_2 )
            // InternalModelDraw.g:6747:3: rule__Level__Src_decorationAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__Src_decorationAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getSrc_decorationAssignment_8_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_8__2__Impl"


    // $ANTLR start "rule__Level__Group_9__0"
    // InternalModelDraw.g:6756:1: rule__Level__Group_9__0 : rule__Level__Group_9__0__Impl rule__Level__Group_9__1 ;
    public final void rule__Level__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6760:1: ( rule__Level__Group_9__0__Impl rule__Level__Group_9__1 )
            // InternalModelDraw.g:6761:2: rule__Level__Group_9__0__Impl rule__Level__Group_9__1
            {
            pushFollow(FOLLOW_18);
            rule__Level__Group_9__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_9__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_9__0"


    // $ANTLR start "rule__Level__Group_9__0__Impl"
    // InternalModelDraw.g:6768:1: rule__Level__Group_9__0__Impl : ( 'src_label' ) ;
    public final void rule__Level__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6772:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:6773:1: ( 'src_label' )
            {
            // InternalModelDraw.g:6773:1: ( 'src_label' )
            // InternalModelDraw.g:6774:2: 'src_label'
            {
             before(grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0()); 
            match(input,46,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_9__0__Impl"


    // $ANTLR start "rule__Level__Group_9__1"
    // InternalModelDraw.g:6783:1: rule__Level__Group_9__1 : rule__Level__Group_9__1__Impl rule__Level__Group_9__2 ;
    public final void rule__Level__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6787:1: ( rule__Level__Group_9__1__Impl rule__Level__Group_9__2 )
            // InternalModelDraw.g:6788:2: rule__Level__Group_9__1__Impl rule__Level__Group_9__2
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_9__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_9__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_9__1"


    // $ANTLR start "rule__Level__Group_9__1__Impl"
    // InternalModelDraw.g:6795:1: rule__Level__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6799:1: ( ( '=' ) )
            // InternalModelDraw.g:6800:1: ( '=' )
            {
            // InternalModelDraw.g:6800:1: ( '=' )
            // InternalModelDraw.g:6801:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_9__1__Impl"


    // $ANTLR start "rule__Level__Group_9__2"
    // InternalModelDraw.g:6810:1: rule__Level__Group_9__2 : rule__Level__Group_9__2__Impl ;
    public final void rule__Level__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6814:1: ( rule__Level__Group_9__2__Impl )
            // InternalModelDraw.g:6815:2: rule__Level__Group_9__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_9__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_9__2"


    // $ANTLR start "rule__Level__Group_9__2__Impl"
    // InternalModelDraw.g:6821:1: rule__Level__Group_9__2__Impl : ( ( rule__Level__Src_labelAssignment_9_2 ) ) ;
    public final void rule__Level__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6825:1: ( ( ( rule__Level__Src_labelAssignment_9_2 ) ) )
            // InternalModelDraw.g:6826:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            {
            // InternalModelDraw.g:6826:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            // InternalModelDraw.g:6827:2: ( rule__Level__Src_labelAssignment_9_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelAssignment_9_2()); 
            // InternalModelDraw.g:6828:2: ( rule__Level__Src_labelAssignment_9_2 )
            // InternalModelDraw.g:6828:3: rule__Level__Src_labelAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__Src_labelAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getSrc_labelAssignment_9_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_9__2__Impl"


    // $ANTLR start "rule__Level__Group_10__0"
    // InternalModelDraw.g:6837:1: rule__Level__Group_10__0 : rule__Level__Group_10__0__Impl rule__Level__Group_10__1 ;
    public final void rule__Level__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6841:1: ( rule__Level__Group_10__0__Impl rule__Level__Group_10__1 )
            // InternalModelDraw.g:6842:2: rule__Level__Group_10__0__Impl rule__Level__Group_10__1
            {
            pushFollow(FOLLOW_18);
            rule__Level__Group_10__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_10__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_10__0"


    // $ANTLR start "rule__Level__Group_10__0__Impl"
    // InternalModelDraw.g:6849:1: rule__Level__Group_10__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Level__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6853:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:6854:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:6854:1: ( 'tar_decoration' )
            // InternalModelDraw.g:6855:2: 'tar_decoration'
            {
             before(grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0()); 
            match(input,47,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_10__0__Impl"


    // $ANTLR start "rule__Level__Group_10__1"
    // InternalModelDraw.g:6864:1: rule__Level__Group_10__1 : rule__Level__Group_10__1__Impl rule__Level__Group_10__2 ;
    public final void rule__Level__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6868:1: ( rule__Level__Group_10__1__Impl rule__Level__Group_10__2 )
            // InternalModelDraw.g:6869:2: rule__Level__Group_10__1__Impl rule__Level__Group_10__2
            {
            pushFollow(FOLLOW_32);
            rule__Level__Group_10__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_10__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_10__1"


    // $ANTLR start "rule__Level__Group_10__1__Impl"
    // InternalModelDraw.g:6876:1: rule__Level__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6880:1: ( ( '=' ) )
            // InternalModelDraw.g:6881:1: ( '=' )
            {
            // InternalModelDraw.g:6881:1: ( '=' )
            // InternalModelDraw.g:6882:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_10__1__Impl"


    // $ANTLR start "rule__Level__Group_10__2"
    // InternalModelDraw.g:6891:1: rule__Level__Group_10__2 : rule__Level__Group_10__2__Impl ;
    public final void rule__Level__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6895:1: ( rule__Level__Group_10__2__Impl )
            // InternalModelDraw.g:6896:2: rule__Level__Group_10__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_10__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_10__2"


    // $ANTLR start "rule__Level__Group_10__2__Impl"
    // InternalModelDraw.g:6902:1: rule__Level__Group_10__2__Impl : ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) ;
    public final void rule__Level__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6906:1: ( ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) )
            // InternalModelDraw.g:6907:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            {
            // InternalModelDraw.g:6907:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            // InternalModelDraw.g:6908:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_decorationAssignment_10_2()); 
            // InternalModelDraw.g:6909:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            // InternalModelDraw.g:6909:3: rule__Level__Tar_decorationAssignment_10_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__Tar_decorationAssignment_10_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getTar_decorationAssignment_10_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_10__2__Impl"


    // $ANTLR start "rule__Level__Group_11__0"
    // InternalModelDraw.g:6918:1: rule__Level__Group_11__0 : rule__Level__Group_11__0__Impl rule__Level__Group_11__1 ;
    public final void rule__Level__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6922:1: ( rule__Level__Group_11__0__Impl rule__Level__Group_11__1 )
            // InternalModelDraw.g:6923:2: rule__Level__Group_11__0__Impl rule__Level__Group_11__1
            {
            pushFollow(FOLLOW_18);
            rule__Level__Group_11__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_11__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_11__0"


    // $ANTLR start "rule__Level__Group_11__0__Impl"
    // InternalModelDraw.g:6930:1: rule__Level__Group_11__0__Impl : ( 'tar_label' ) ;
    public final void rule__Level__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6934:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:6935:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:6935:1: ( 'tar_label' )
            // InternalModelDraw.g:6936:2: 'tar_label'
            {
             before(grammarAccess.getLevelAccess().getTar_labelKeyword_11_0()); 
            match(input,48,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getTar_labelKeyword_11_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_11__0__Impl"


    // $ANTLR start "rule__Level__Group_11__1"
    // InternalModelDraw.g:6945:1: rule__Level__Group_11__1 : rule__Level__Group_11__1__Impl rule__Level__Group_11__2 ;
    public final void rule__Level__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6949:1: ( rule__Level__Group_11__1__Impl rule__Level__Group_11__2 )
            // InternalModelDraw.g:6950:2: rule__Level__Group_11__1__Impl rule__Level__Group_11__2
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_11__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_11__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_11__1"


    // $ANTLR start "rule__Level__Group_11__1__Impl"
    // InternalModelDraw.g:6957:1: rule__Level__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6961:1: ( ( '=' ) )
            // InternalModelDraw.g:6962:1: ( '=' )
            {
            // InternalModelDraw.g:6962:1: ( '=' )
            // InternalModelDraw.g:6963:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_11__1__Impl"


    // $ANTLR start "rule__Level__Group_11__2"
    // InternalModelDraw.g:6972:1: rule__Level__Group_11__2 : rule__Level__Group_11__2__Impl ;
    public final void rule__Level__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6976:1: ( rule__Level__Group_11__2__Impl )
            // InternalModelDraw.g:6977:2: rule__Level__Group_11__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_11__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_11__2"


    // $ANTLR start "rule__Level__Group_11__2__Impl"
    // InternalModelDraw.g:6983:1: rule__Level__Group_11__2__Impl : ( ( rule__Level__Tar_labelAssignment_11_2 ) ) ;
    public final void rule__Level__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6987:1: ( ( ( rule__Level__Tar_labelAssignment_11_2 ) ) )
            // InternalModelDraw.g:6988:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            {
            // InternalModelDraw.g:6988:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            // InternalModelDraw.g:6989:2: ( rule__Level__Tar_labelAssignment_11_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_labelAssignment_11_2()); 
            // InternalModelDraw.g:6990:2: ( rule__Level__Tar_labelAssignment_11_2 )
            // InternalModelDraw.g:6990:3: rule__Level__Tar_labelAssignment_11_2
            {
            pushFollow(FOLLOW_2);
            rule__Level__Tar_labelAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getTar_labelAssignment_11_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_11__2__Impl"


    // $ANTLR start "rule__Content__Group__0"
    // InternalModelDraw.g:6999:1: rule__Content__Group__0 : rule__Content__Group__0__Impl rule__Content__Group__1 ;
    public final void rule__Content__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7003:1: ( rule__Content__Group__0__Impl rule__Content__Group__1 )
            // InternalModelDraw.g:7004:2: rule__Content__Group__0__Impl rule__Content__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Content__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__0"


    // $ANTLR start "rule__Content__Group__0__Impl"
    // InternalModelDraw.g:7011:1: rule__Content__Group__0__Impl : ( () ) ;
    public final void rule__Content__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7015:1: ( ( () ) )
            // InternalModelDraw.g:7016:1: ( () )
            {
            // InternalModelDraw.g:7016:1: ( () )
            // InternalModelDraw.g:7017:2: ()
            {
             before(grammarAccess.getContentAccess().getContentAction_0()); 
            // InternalModelDraw.g:7018:2: ()
            // InternalModelDraw.g:7018:3: 
            {
            }

             after(grammarAccess.getContentAccess().getContentAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__0__Impl"


    // $ANTLR start "rule__Content__Group__1"
    // InternalModelDraw.g:7026:1: rule__Content__Group__1 : rule__Content__Group__1__Impl rule__Content__Group__2 ;
    public final void rule__Content__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7030:1: ( rule__Content__Group__1__Impl rule__Content__Group__2 )
            // InternalModelDraw.g:7031:2: rule__Content__Group__1__Impl rule__Content__Group__2
            {
            pushFollow(FOLLOW_6);
            rule__Content__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__1"


    // $ANTLR start "rule__Content__Group__1__Impl"
    // InternalModelDraw.g:7038:1: rule__Content__Group__1__Impl : ( ( rule__Content__NameAssignment_1 ) ) ;
    public final void rule__Content__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7042:1: ( ( ( rule__Content__NameAssignment_1 ) ) )
            // InternalModelDraw.g:7043:1: ( ( rule__Content__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:7043:1: ( ( rule__Content__NameAssignment_1 ) )
            // InternalModelDraw.g:7044:2: ( rule__Content__NameAssignment_1 )
            {
             before(grammarAccess.getContentAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:7045:2: ( rule__Content__NameAssignment_1 )
            // InternalModelDraw.g:7045:3: rule__Content__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Content__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getContentAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__1__Impl"


    // $ANTLR start "rule__Content__Group__2"
    // InternalModelDraw.g:7053:1: rule__Content__Group__2 : rule__Content__Group__2__Impl rule__Content__Group__3 ;
    public final void rule__Content__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7057:1: ( rule__Content__Group__2__Impl rule__Content__Group__3 )
            // InternalModelDraw.g:7058:2: rule__Content__Group__2__Impl rule__Content__Group__3
            {
            pushFollow(FOLLOW_34);
            rule__Content__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__2"


    // $ANTLR start "rule__Content__Group__2__Impl"
    // InternalModelDraw.g:7065:1: rule__Content__Group__2__Impl : ( ':' ) ;
    public final void rule__Content__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7069:1: ( ( ':' ) )
            // InternalModelDraw.g:7070:1: ( ':' )
            {
            // InternalModelDraw.g:7070:1: ( ':' )
            // InternalModelDraw.g:7071:2: ':'
            {
             before(grammarAccess.getContentAccess().getColonKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__2__Impl"


    // $ANTLR start "rule__Content__Group__3"
    // InternalModelDraw.g:7080:1: rule__Content__Group__3 : rule__Content__Group__3__Impl rule__Content__Group__4 ;
    public final void rule__Content__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7084:1: ( rule__Content__Group__3__Impl rule__Content__Group__4 )
            // InternalModelDraw.g:7085:2: rule__Content__Group__3__Impl rule__Content__Group__4
            {
            pushFollow(FOLLOW_34);
            rule__Content__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__3"


    // $ANTLR start "rule__Content__Group__3__Impl"
    // InternalModelDraw.g:7092:1: rule__Content__Group__3__Impl : ( ( rule__Content__Group_3__0 )? ) ;
    public final void rule__Content__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7096:1: ( ( ( rule__Content__Group_3__0 )? ) )
            // InternalModelDraw.g:7097:1: ( ( rule__Content__Group_3__0 )? )
            {
            // InternalModelDraw.g:7097:1: ( ( rule__Content__Group_3__0 )? )
            // InternalModelDraw.g:7098:2: ( rule__Content__Group_3__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_3()); 
            // InternalModelDraw.g:7099:2: ( rule__Content__Group_3__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==50) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalModelDraw.g:7099:3: rule__Content__Group_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Content__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getContentAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__3__Impl"


    // $ANTLR start "rule__Content__Group__4"
    // InternalModelDraw.g:7107:1: rule__Content__Group__4 : rule__Content__Group__4__Impl rule__Content__Group__5 ;
    public final void rule__Content__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7111:1: ( rule__Content__Group__4__Impl rule__Content__Group__5 )
            // InternalModelDraw.g:7112:2: rule__Content__Group__4__Impl rule__Content__Group__5
            {
            pushFollow(FOLLOW_34);
            rule__Content__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__4"


    // $ANTLR start "rule__Content__Group__4__Impl"
    // InternalModelDraw.g:7119:1: rule__Content__Group__4__Impl : ( ( rule__Content__Group_4__0 )? ) ;
    public final void rule__Content__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7123:1: ( ( ( rule__Content__Group_4__0 )? ) )
            // InternalModelDraw.g:7124:1: ( ( rule__Content__Group_4__0 )? )
            {
            // InternalModelDraw.g:7124:1: ( ( rule__Content__Group_4__0 )? )
            // InternalModelDraw.g:7125:2: ( rule__Content__Group_4__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_4()); 
            // InternalModelDraw.g:7126:2: ( rule__Content__Group_4__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==RULE_ID) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==EOF||LA71_1==RULE_ID||(LA71_1>=30 && LA71_1<=31)||LA71_1==44||LA71_1==49) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // InternalModelDraw.g:7126:3: rule__Content__Group_4__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Content__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getContentAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__4__Impl"


    // $ANTLR start "rule__Content__Group__5"
    // InternalModelDraw.g:7134:1: rule__Content__Group__5 : rule__Content__Group__5__Impl rule__Content__Group__6 ;
    public final void rule__Content__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7138:1: ( rule__Content__Group__5__Impl rule__Content__Group__6 )
            // InternalModelDraw.g:7139:2: rule__Content__Group__5__Impl rule__Content__Group__6
            {
            pushFollow(FOLLOW_34);
            rule__Content__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__5"


    // $ANTLR start "rule__Content__Group__5__Impl"
    // InternalModelDraw.g:7146:1: rule__Content__Group__5__Impl : ( ( rule__Content__Group_5__0 )? ) ;
    public final void rule__Content__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7150:1: ( ( ( rule__Content__Group_5__0 )? ) )
            // InternalModelDraw.g:7151:1: ( ( rule__Content__Group_5__0 )? )
            {
            // InternalModelDraw.g:7151:1: ( ( rule__Content__Group_5__0 )? )
            // InternalModelDraw.g:7152:2: ( rule__Content__Group_5__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_5()); 
            // InternalModelDraw.g:7153:2: ( rule__Content__Group_5__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==30) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalModelDraw.g:7153:3: rule__Content__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Content__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getContentAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__5__Impl"


    // $ANTLR start "rule__Content__Group__6"
    // InternalModelDraw.g:7161:1: rule__Content__Group__6 : rule__Content__Group__6__Impl ;
    public final void rule__Content__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7165:1: ( rule__Content__Group__6__Impl )
            // InternalModelDraw.g:7166:2: rule__Content__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Content__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__6"


    // $ANTLR start "rule__Content__Group__6__Impl"
    // InternalModelDraw.g:7172:1: rule__Content__Group__6__Impl : ( ( rule__Content__Group_6__0 )? ) ;
    public final void rule__Content__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7176:1: ( ( ( rule__Content__Group_6__0 )? ) )
            // InternalModelDraw.g:7177:1: ( ( rule__Content__Group_6__0 )? )
            {
            // InternalModelDraw.g:7177:1: ( ( rule__Content__Group_6__0 )? )
            // InternalModelDraw.g:7178:2: ( rule__Content__Group_6__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_6()); 
            // InternalModelDraw.g:7179:2: ( rule__Content__Group_6__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==49) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalModelDraw.g:7179:3: rule__Content__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Content__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getContentAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group__6__Impl"


    // $ANTLR start "rule__Content__Group_3__0"
    // InternalModelDraw.g:7188:1: rule__Content__Group_3__0 : rule__Content__Group_3__0__Impl rule__Content__Group_3__1 ;
    public final void rule__Content__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7192:1: ( rule__Content__Group_3__0__Impl rule__Content__Group_3__1 )
            // InternalModelDraw.g:7193:2: rule__Content__Group_3__0__Impl rule__Content__Group_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Content__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_3__0"


    // $ANTLR start "rule__Content__Group_3__0__Impl"
    // InternalModelDraw.g:7200:1: rule__Content__Group_3__0__Impl : ( ( rule__Content__NodenumAssignment_3_0 ) ) ;
    public final void rule__Content__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7204:1: ( ( ( rule__Content__NodenumAssignment_3_0 ) ) )
            // InternalModelDraw.g:7205:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            {
            // InternalModelDraw.g:7205:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            // InternalModelDraw.g:7206:2: ( rule__Content__NodenumAssignment_3_0 )
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_0()); 
            // InternalModelDraw.g:7207:2: ( rule__Content__NodenumAssignment_3_0 )
            // InternalModelDraw.g:7207:3: rule__Content__NodenumAssignment_3_0
            {
            pushFollow(FOLLOW_2);
            rule__Content__NodenumAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getContentAccess().getNodenumAssignment_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_3__0__Impl"


    // $ANTLR start "rule__Content__Group_3__1"
    // InternalModelDraw.g:7215:1: rule__Content__Group_3__1 : rule__Content__Group_3__1__Impl ;
    public final void rule__Content__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7219:1: ( rule__Content__Group_3__1__Impl )
            // InternalModelDraw.g:7220:2: rule__Content__Group_3__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Content__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_3__1"


    // $ANTLR start "rule__Content__Group_3__1__Impl"
    // InternalModelDraw.g:7226:1: rule__Content__Group_3__1__Impl : ( ( rule__Content__NodenumAssignment_3_1 )* ) ;
    public final void rule__Content__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7230:1: ( ( ( rule__Content__NodenumAssignment_3_1 )* ) )
            // InternalModelDraw.g:7231:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            {
            // InternalModelDraw.g:7231:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            // InternalModelDraw.g:7232:2: ( rule__Content__NodenumAssignment_3_1 )*
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_1()); 
            // InternalModelDraw.g:7233:2: ( rule__Content__NodenumAssignment_3_1 )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==RULE_ID) ) {
                    int LA74_1 = input.LA(2);

                    if ( (LA74_1==50) ) {
                        alt74=1;
                    }


                }


                switch (alt74) {
            	case 1 :
            	    // InternalModelDraw.g:7233:3: rule__Content__NodenumAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Content__NodenumAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);

             after(grammarAccess.getContentAccess().getNodenumAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_3__1__Impl"


    // $ANTLR start "rule__Content__Group_4__0"
    // InternalModelDraw.g:7242:1: rule__Content__Group_4__0 : rule__Content__Group_4__0__Impl rule__Content__Group_4__1 ;
    public final void rule__Content__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7246:1: ( rule__Content__Group_4__0__Impl rule__Content__Group_4__1 )
            // InternalModelDraw.g:7247:2: rule__Content__Group_4__0__Impl rule__Content__Group_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Content__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_4__0"


    // $ANTLR start "rule__Content__Group_4__0__Impl"
    // InternalModelDraw.g:7254:1: rule__Content__Group_4__0__Impl : ( ( rule__Content__InfoAssignment_4_0 ) ) ;
    public final void rule__Content__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7258:1: ( ( ( rule__Content__InfoAssignment_4_0 ) ) )
            // InternalModelDraw.g:7259:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            {
            // InternalModelDraw.g:7259:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            // InternalModelDraw.g:7260:2: ( rule__Content__InfoAssignment_4_0 )
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_0()); 
            // InternalModelDraw.g:7261:2: ( rule__Content__InfoAssignment_4_0 )
            // InternalModelDraw.g:7261:3: rule__Content__InfoAssignment_4_0
            {
            pushFollow(FOLLOW_2);
            rule__Content__InfoAssignment_4_0();

            state._fsp--;


            }

             after(grammarAccess.getContentAccess().getInfoAssignment_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_4__0__Impl"


    // $ANTLR start "rule__Content__Group_4__1"
    // InternalModelDraw.g:7269:1: rule__Content__Group_4__1 : rule__Content__Group_4__1__Impl ;
    public final void rule__Content__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7273:1: ( rule__Content__Group_4__1__Impl )
            // InternalModelDraw.g:7274:2: rule__Content__Group_4__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Content__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_4__1"


    // $ANTLR start "rule__Content__Group_4__1__Impl"
    // InternalModelDraw.g:7280:1: rule__Content__Group_4__1__Impl : ( ( rule__Content__InfoAssignment_4_1 )* ) ;
    public final void rule__Content__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7284:1: ( ( ( rule__Content__InfoAssignment_4_1 )* ) )
            // InternalModelDraw.g:7285:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            {
            // InternalModelDraw.g:7285:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            // InternalModelDraw.g:7286:2: ( rule__Content__InfoAssignment_4_1 )*
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_1()); 
            // InternalModelDraw.g:7287:2: ( rule__Content__InfoAssignment_4_1 )*
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( (LA75_0==RULE_ID) ) {
                    int LA75_2 = input.LA(2);

                    if ( (LA75_2==EOF||LA75_2==RULE_ID||(LA75_2>=30 && LA75_2<=31)||LA75_2==44||LA75_2==49) ) {
                        alt75=1;
                    }


                }


                switch (alt75) {
            	case 1 :
            	    // InternalModelDraw.g:7287:3: rule__Content__InfoAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Content__InfoAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop75;
                }
            } while (true);

             after(grammarAccess.getContentAccess().getInfoAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_4__1__Impl"


    // $ANTLR start "rule__Content__Group_5__0"
    // InternalModelDraw.g:7296:1: rule__Content__Group_5__0 : rule__Content__Group_5__0__Impl rule__Content__Group_5__1 ;
    public final void rule__Content__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7300:1: ( rule__Content__Group_5__0__Impl rule__Content__Group_5__1 )
            // InternalModelDraw.g:7301:2: rule__Content__Group_5__0__Impl rule__Content__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Content__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_5__0"


    // $ANTLR start "rule__Content__Group_5__0__Impl"
    // InternalModelDraw.g:7308:1: rule__Content__Group_5__0__Impl : ( '{' ) ;
    public final void rule__Content__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7312:1: ( ( '{' ) )
            // InternalModelDraw.g:7313:1: ( '{' )
            {
            // InternalModelDraw.g:7313:1: ( '{' )
            // InternalModelDraw.g:7314:2: '{'
            {
             before(grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_5__0__Impl"


    // $ANTLR start "rule__Content__Group_5__1"
    // InternalModelDraw.g:7323:1: rule__Content__Group_5__1 : rule__Content__Group_5__1__Impl rule__Content__Group_5__2 ;
    public final void rule__Content__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7327:1: ( rule__Content__Group_5__1__Impl rule__Content__Group_5__2 )
            // InternalModelDraw.g:7328:2: rule__Content__Group_5__1__Impl rule__Content__Group_5__2
            {
            pushFollow(FOLLOW_35);
            rule__Content__Group_5__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group_5__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_5__1"


    // $ANTLR start "rule__Content__Group_5__1__Impl"
    // InternalModelDraw.g:7335:1: rule__Content__Group_5__1__Impl : ( ( rule__Content__AttNameAssignment_5_1 ) ) ;
    public final void rule__Content__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7339:1: ( ( ( rule__Content__AttNameAssignment_5_1 ) ) )
            // InternalModelDraw.g:7340:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            {
            // InternalModelDraw.g:7340:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            // InternalModelDraw.g:7341:2: ( rule__Content__AttNameAssignment_5_1 )
            {
             before(grammarAccess.getContentAccess().getAttNameAssignment_5_1()); 
            // InternalModelDraw.g:7342:2: ( rule__Content__AttNameAssignment_5_1 )
            // InternalModelDraw.g:7342:3: rule__Content__AttNameAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Content__AttNameAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getContentAccess().getAttNameAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_5__1__Impl"


    // $ANTLR start "rule__Content__Group_5__2"
    // InternalModelDraw.g:7350:1: rule__Content__Group_5__2 : rule__Content__Group_5__2__Impl ;
    public final void rule__Content__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7354:1: ( rule__Content__Group_5__2__Impl )
            // InternalModelDraw.g:7355:2: rule__Content__Group_5__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Content__Group_5__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_5__2"


    // $ANTLR start "rule__Content__Group_5__2__Impl"
    // InternalModelDraw.g:7361:1: rule__Content__Group_5__2__Impl : ( '}' ) ;
    public final void rule__Content__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7365:1: ( ( '}' ) )
            // InternalModelDraw.g:7366:1: ( '}' )
            {
            // InternalModelDraw.g:7366:1: ( '}' )
            // InternalModelDraw.g:7367:2: '}'
            {
             before(grammarAccess.getContentAccess().getRightCurlyBracketKeyword_5_2()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getRightCurlyBracketKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_5__2__Impl"


    // $ANTLR start "rule__Content__Group_6__0"
    // InternalModelDraw.g:7377:1: rule__Content__Group_6__0 : rule__Content__Group_6__0__Impl rule__Content__Group_6__1 ;
    public final void rule__Content__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7381:1: ( rule__Content__Group_6__0__Impl rule__Content__Group_6__1 )
            // InternalModelDraw.g:7382:2: rule__Content__Group_6__0__Impl rule__Content__Group_6__1
            {
            pushFollow(FOLLOW_18);
            rule__Content__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_6__0"


    // $ANTLR start "rule__Content__Group_6__0__Impl"
    // InternalModelDraw.g:7389:1: rule__Content__Group_6__0__Impl : ( 'text' ) ;
    public final void rule__Content__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7393:1: ( ( 'text' ) )
            // InternalModelDraw.g:7394:1: ( 'text' )
            {
            // InternalModelDraw.g:7394:1: ( 'text' )
            // InternalModelDraw.g:7395:2: 'text'
            {
             before(grammarAccess.getContentAccess().getTextKeyword_6_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getTextKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_6__0__Impl"


    // $ANTLR start "rule__Content__Group_6__1"
    // InternalModelDraw.g:7404:1: rule__Content__Group_6__1 : rule__Content__Group_6__1__Impl rule__Content__Group_6__2 ;
    public final void rule__Content__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7408:1: ( rule__Content__Group_6__1__Impl rule__Content__Group_6__2 )
            // InternalModelDraw.g:7409:2: rule__Content__Group_6__1__Impl rule__Content__Group_6__2
            {
            pushFollow(FOLLOW_4);
            rule__Content__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Content__Group_6__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_6__1"


    // $ANTLR start "rule__Content__Group_6__1__Impl"
    // InternalModelDraw.g:7416:1: rule__Content__Group_6__1__Impl : ( '=' ) ;
    public final void rule__Content__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7420:1: ( ( '=' ) )
            // InternalModelDraw.g:7421:1: ( '=' )
            {
            // InternalModelDraw.g:7421:1: ( '=' )
            // InternalModelDraw.g:7422:2: '='
            {
             before(grammarAccess.getContentAccess().getEqualsSignKeyword_6_1()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getEqualsSignKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_6__1__Impl"


    // $ANTLR start "rule__Content__Group_6__2"
    // InternalModelDraw.g:7431:1: rule__Content__Group_6__2 : rule__Content__Group_6__2__Impl ;
    public final void rule__Content__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7435:1: ( rule__Content__Group_6__2__Impl )
            // InternalModelDraw.g:7436:2: rule__Content__Group_6__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Content__Group_6__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_6__2"


    // $ANTLR start "rule__Content__Group_6__2__Impl"
    // InternalModelDraw.g:7442:1: rule__Content__Group_6__2__Impl : ( ( rule__Content__SymbolAssignment_6_2 ) ) ;
    public final void rule__Content__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7446:1: ( ( ( rule__Content__SymbolAssignment_6_2 ) ) )
            // InternalModelDraw.g:7447:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            {
            // InternalModelDraw.g:7447:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            // InternalModelDraw.g:7448:2: ( rule__Content__SymbolAssignment_6_2 )
            {
             before(grammarAccess.getContentAccess().getSymbolAssignment_6_2()); 
            // InternalModelDraw.g:7449:2: ( rule__Content__SymbolAssignment_6_2 )
            // InternalModelDraw.g:7449:3: rule__Content__SymbolAssignment_6_2
            {
            pushFollow(FOLLOW_2);
            rule__Content__SymbolAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getContentAccess().getSymbolAssignment_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__Group_6__2__Impl"


    // $ANTLR start "rule__NodeEnumerator__Group__0"
    // InternalModelDraw.g:7458:1: rule__NodeEnumerator__Group__0 : rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 ;
    public final void rule__NodeEnumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7462:1: ( rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 )
            // InternalModelDraw.g:7463:2: rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__NodeEnumerator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__0"


    // $ANTLR start "rule__NodeEnumerator__Group__0__Impl"
    // InternalModelDraw.g:7470:1: rule__NodeEnumerator__Group__0__Impl : ( () ) ;
    public final void rule__NodeEnumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7474:1: ( ( () ) )
            // InternalModelDraw.g:7475:1: ( () )
            {
            // InternalModelDraw.g:7475:1: ( () )
            // InternalModelDraw.g:7476:2: ()
            {
             before(grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0()); 
            // InternalModelDraw.g:7477:2: ()
            // InternalModelDraw.g:7477:3: 
            {
            }

             after(grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__0__Impl"


    // $ANTLR start "rule__NodeEnumerator__Group__1"
    // InternalModelDraw.g:7485:1: rule__NodeEnumerator__Group__1 : rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 ;
    public final void rule__NodeEnumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7489:1: ( rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 )
            // InternalModelDraw.g:7490:2: rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2
            {
            pushFollow(FOLLOW_36);
            rule__NodeEnumerator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__1"


    // $ANTLR start "rule__NodeEnumerator__Group__1__Impl"
    // InternalModelDraw.g:7497:1: rule__NodeEnumerator__Group__1__Impl : ( ( rule__NodeEnumerator__AttAssignment_1 ) ) ;
    public final void rule__NodeEnumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7501:1: ( ( ( rule__NodeEnumerator__AttAssignment_1 ) ) )
            // InternalModelDraw.g:7502:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            {
            // InternalModelDraw.g:7502:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            // InternalModelDraw.g:7503:2: ( rule__NodeEnumerator__AttAssignment_1 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttAssignment_1()); 
            // InternalModelDraw.g:7504:2: ( rule__NodeEnumerator__AttAssignment_1 )
            // InternalModelDraw.g:7504:3: rule__NodeEnumerator__AttAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__AttAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeEnumeratorAccess().getAttAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__1__Impl"


    // $ANTLR start "rule__NodeEnumerator__Group__2"
    // InternalModelDraw.g:7512:1: rule__NodeEnumerator__Group__2 : rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 ;
    public final void rule__NodeEnumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7516:1: ( rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 )
            // InternalModelDraw.g:7517:2: rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3
            {
            pushFollow(FOLLOW_5);
            rule__NodeEnumerator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__2"


    // $ANTLR start "rule__NodeEnumerator__Group__2__Impl"
    // InternalModelDraw.g:7524:1: rule__NodeEnumerator__Group__2__Impl : ( '[' ) ;
    public final void rule__NodeEnumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7528:1: ( ( '[' ) )
            // InternalModelDraw.g:7529:1: ( '[' )
            {
            // InternalModelDraw.g:7529:1: ( '[' )
            // InternalModelDraw.g:7530:2: '['
            {
             before(grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2()); 
            match(input,50,FOLLOW_2); 
             after(grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__2__Impl"


    // $ANTLR start "rule__NodeEnumerator__Group__3"
    // InternalModelDraw.g:7539:1: rule__NodeEnumerator__Group__3 : rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 ;
    public final void rule__NodeEnumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7543:1: ( rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 )
            // InternalModelDraw.g:7544:2: rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4
            {
            pushFollow(FOLLOW_37);
            rule__NodeEnumerator__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__3"


    // $ANTLR start "rule__NodeEnumerator__Group__3__Impl"
    // InternalModelDraw.g:7551:1: rule__NodeEnumerator__Group__3__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) ;
    public final void rule__NodeEnumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7555:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) )
            // InternalModelDraw.g:7556:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            {
            // InternalModelDraw.g:7556:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            // InternalModelDraw.g:7557:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_3()); 
            // InternalModelDraw.g:7558:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            // InternalModelDraw.g:7558:3: rule__NodeEnumerator__EnumeratorAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__EnumeratorAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__3__Impl"


    // $ANTLR start "rule__NodeEnumerator__Group__4"
    // InternalModelDraw.g:7566:1: rule__NodeEnumerator__Group__4 : rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 ;
    public final void rule__NodeEnumerator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7570:1: ( rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 )
            // InternalModelDraw.g:7571:2: rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5
            {
            pushFollow(FOLLOW_37);
            rule__NodeEnumerator__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__4"


    // $ANTLR start "rule__NodeEnumerator__Group__4__Impl"
    // InternalModelDraw.g:7578:1: rule__NodeEnumerator__Group__4__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) ;
    public final void rule__NodeEnumerator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7582:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) )
            // InternalModelDraw.g:7583:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            {
            // InternalModelDraw.g:7583:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            // InternalModelDraw.g:7584:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_4()); 
            // InternalModelDraw.g:7585:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_ID) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // InternalModelDraw.g:7585:3: rule__NodeEnumerator__EnumeratorAssignment_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__NodeEnumerator__EnumeratorAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

             after(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__4__Impl"


    // $ANTLR start "rule__NodeEnumerator__Group__5"
    // InternalModelDraw.g:7593:1: rule__NodeEnumerator__Group__5 : rule__NodeEnumerator__Group__5__Impl ;
    public final void rule__NodeEnumerator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7597:1: ( rule__NodeEnumerator__Group__5__Impl )
            // InternalModelDraw.g:7598:2: rule__NodeEnumerator__Group__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__NodeEnumerator__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__5"


    // $ANTLR start "rule__NodeEnumerator__Group__5__Impl"
    // InternalModelDraw.g:7604:1: rule__NodeEnumerator__Group__5__Impl : ( ']' ) ;
    public final void rule__NodeEnumerator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7608:1: ( ( ']' ) )
            // InternalModelDraw.g:7609:1: ( ']' )
            {
            // InternalModelDraw.g:7609:1: ( ']' )
            // InternalModelDraw.g:7610:2: ']'
            {
             before(grammarAccess.getNodeEnumeratorAccess().getRightSquareBracketKeyword_5()); 
            match(input,51,FOLLOW_2); 
             after(grammarAccess.getNodeEnumeratorAccess().getRightSquareBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__Group__5__Impl"


    // $ANTLR start "rule__Enumerator__Group__0"
    // InternalModelDraw.g:7620:1: rule__Enumerator__Group__0 : rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 ;
    public final void rule__Enumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7624:1: ( rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 )
            // InternalModelDraw.g:7625:2: rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Enumerator__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumerator__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__0"


    // $ANTLR start "rule__Enumerator__Group__0__Impl"
    // InternalModelDraw.g:7632:1: rule__Enumerator__Group__0__Impl : ( () ) ;
    public final void rule__Enumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7636:1: ( ( () ) )
            // InternalModelDraw.g:7637:1: ( () )
            {
            // InternalModelDraw.g:7637:1: ( () )
            // InternalModelDraw.g:7638:2: ()
            {
             before(grammarAccess.getEnumeratorAccess().getEnumeratorAction_0()); 
            // InternalModelDraw.g:7639:2: ()
            // InternalModelDraw.g:7639:3: 
            {
            }

             after(grammarAccess.getEnumeratorAccess().getEnumeratorAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__0__Impl"


    // $ANTLR start "rule__Enumerator__Group__1"
    // InternalModelDraw.g:7647:1: rule__Enumerator__Group__1 : rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 ;
    public final void rule__Enumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7651:1: ( rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 )
            // InternalModelDraw.g:7652:2: rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2
            {
            pushFollow(FOLLOW_18);
            rule__Enumerator__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumerator__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__1"


    // $ANTLR start "rule__Enumerator__Group__1__Impl"
    // InternalModelDraw.g:7659:1: rule__Enumerator__Group__1__Impl : ( ( rule__Enumerator__LiteralAssignment_1 ) ) ;
    public final void rule__Enumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7663:1: ( ( ( rule__Enumerator__LiteralAssignment_1 ) ) )
            // InternalModelDraw.g:7664:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            {
            // InternalModelDraw.g:7664:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            // InternalModelDraw.g:7665:2: ( rule__Enumerator__LiteralAssignment_1 )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralAssignment_1()); 
            // InternalModelDraw.g:7666:2: ( rule__Enumerator__LiteralAssignment_1 )
            // InternalModelDraw.g:7666:3: rule__Enumerator__LiteralAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Enumerator__LiteralAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getEnumeratorAccess().getLiteralAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__1__Impl"


    // $ANTLR start "rule__Enumerator__Group__2"
    // InternalModelDraw.g:7674:1: rule__Enumerator__Group__2 : rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 ;
    public final void rule__Enumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7678:1: ( rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 )
            // InternalModelDraw.g:7679:2: rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3
            {
            pushFollow(FOLLOW_4);
            rule__Enumerator__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Enumerator__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__2"


    // $ANTLR start "rule__Enumerator__Group__2__Impl"
    // InternalModelDraw.g:7686:1: rule__Enumerator__Group__2__Impl : ( '=' ) ;
    public final void rule__Enumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7690:1: ( ( '=' ) )
            // InternalModelDraw.g:7691:1: ( '=' )
            {
            // InternalModelDraw.g:7691:1: ( '=' )
            // InternalModelDraw.g:7692:2: '='
            {
             before(grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_2()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__2__Impl"


    // $ANTLR start "rule__Enumerator__Group__3"
    // InternalModelDraw.g:7701:1: rule__Enumerator__Group__3 : rule__Enumerator__Group__3__Impl ;
    public final void rule__Enumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7705:1: ( rule__Enumerator__Group__3__Impl )
            // InternalModelDraw.g:7706:2: rule__Enumerator__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Enumerator__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__3"


    // $ANTLR start "rule__Enumerator__Group__3__Impl"
    // InternalModelDraw.g:7712:1: rule__Enumerator__Group__3__Impl : ( ( rule__Enumerator__ValueAssignment_3 ) ) ;
    public final void rule__Enumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7716:1: ( ( ( rule__Enumerator__ValueAssignment_3 ) ) )
            // InternalModelDraw.g:7717:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            {
            // InternalModelDraw.g:7717:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            // InternalModelDraw.g:7718:2: ( rule__Enumerator__ValueAssignment_3 )
            {
             before(grammarAccess.getEnumeratorAccess().getValueAssignment_3()); 
            // InternalModelDraw.g:7719:2: ( rule__Enumerator__ValueAssignment_3 )
            // InternalModelDraw.g:7719:3: rule__Enumerator__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Enumerator__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEnumeratorAccess().getValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__Group__3__Impl"


    // $ANTLR start "rule__Information__Group__0"
    // InternalModelDraw.g:7728:1: rule__Information__Group__0 : rule__Information__Group__0__Impl rule__Information__Group__1 ;
    public final void rule__Information__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7732:1: ( rule__Information__Group__0__Impl rule__Information__Group__1 )
            // InternalModelDraw.g:7733:2: rule__Information__Group__0__Impl rule__Information__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__Information__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Information__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group__0"


    // $ANTLR start "rule__Information__Group__0__Impl"
    // InternalModelDraw.g:7740:1: rule__Information__Group__0__Impl : ( () ) ;
    public final void rule__Information__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7744:1: ( ( () ) )
            // InternalModelDraw.g:7745:1: ( () )
            {
            // InternalModelDraw.g:7745:1: ( () )
            // InternalModelDraw.g:7746:2: ()
            {
             before(grammarAccess.getInformationAccess().getInformationAction_0()); 
            // InternalModelDraw.g:7747:2: ()
            // InternalModelDraw.g:7747:3: 
            {
            }

             after(grammarAccess.getInformationAccess().getInformationAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group__0__Impl"


    // $ANTLR start "rule__Information__Group__1"
    // InternalModelDraw.g:7755:1: rule__Information__Group__1 : rule__Information__Group__1__Impl rule__Information__Group__2 ;
    public final void rule__Information__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7759:1: ( rule__Information__Group__1__Impl rule__Information__Group__2 )
            // InternalModelDraw.g:7760:2: rule__Information__Group__1__Impl rule__Information__Group__2
            {
            pushFollow(FOLLOW_33);
            rule__Information__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Information__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group__1"


    // $ANTLR start "rule__Information__Group__1__Impl"
    // InternalModelDraw.g:7767:1: rule__Information__Group__1__Impl : ( ( rule__Information__TypeAssignment_1 ) ) ;
    public final void rule__Information__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7771:1: ( ( ( rule__Information__TypeAssignment_1 ) ) )
            // InternalModelDraw.g:7772:1: ( ( rule__Information__TypeAssignment_1 ) )
            {
            // InternalModelDraw.g:7772:1: ( ( rule__Information__TypeAssignment_1 ) )
            // InternalModelDraw.g:7773:2: ( rule__Information__TypeAssignment_1 )
            {
             before(grammarAccess.getInformationAccess().getTypeAssignment_1()); 
            // InternalModelDraw.g:7774:2: ( rule__Information__TypeAssignment_1 )
            // InternalModelDraw.g:7774:3: rule__Information__TypeAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__Information__TypeAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getInformationAccess().getTypeAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group__1__Impl"


    // $ANTLR start "rule__Information__Group__2"
    // InternalModelDraw.g:7782:1: rule__Information__Group__2 : rule__Information__Group__2__Impl ;
    public final void rule__Information__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7786:1: ( rule__Information__Group__2__Impl )
            // InternalModelDraw.g:7787:2: rule__Information__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Information__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group__2"


    // $ANTLR start "rule__Information__Group__2__Impl"
    // InternalModelDraw.g:7793:1: rule__Information__Group__2__Impl : ( ( rule__Information__Group_2__0 )? ) ;
    public final void rule__Information__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7797:1: ( ( ( rule__Information__Group_2__0 )? ) )
            // InternalModelDraw.g:7798:1: ( ( rule__Information__Group_2__0 )? )
            {
            // InternalModelDraw.g:7798:1: ( ( rule__Information__Group_2__0 )? )
            // InternalModelDraw.g:7799:2: ( rule__Information__Group_2__0 )?
            {
             before(grammarAccess.getInformationAccess().getGroup_2()); 
            // InternalModelDraw.g:7800:2: ( rule__Information__Group_2__0 )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==44) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalModelDraw.g:7800:3: rule__Information__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Information__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getInformationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group__2__Impl"


    // $ANTLR start "rule__Information__Group_2__0"
    // InternalModelDraw.g:7809:1: rule__Information__Group_2__0 : rule__Information__Group_2__0__Impl rule__Information__Group_2__1 ;
    public final void rule__Information__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7813:1: ( rule__Information__Group_2__0__Impl rule__Information__Group_2__1 )
            // InternalModelDraw.g:7814:2: rule__Information__Group_2__0__Impl rule__Information__Group_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Information__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Information__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group_2__0"


    // $ANTLR start "rule__Information__Group_2__0__Impl"
    // InternalModelDraw.g:7821:1: rule__Information__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Information__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7825:1: ( ( '.' ) )
            // InternalModelDraw.g:7826:1: ( '.' )
            {
            // InternalModelDraw.g:7826:1: ( '.' )
            // InternalModelDraw.g:7827:2: '.'
            {
             before(grammarAccess.getInformationAccess().getFullStopKeyword_2_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getInformationAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group_2__0__Impl"


    // $ANTLR start "rule__Information__Group_2__1"
    // InternalModelDraw.g:7836:1: rule__Information__Group_2__1 : rule__Information__Group_2__1__Impl ;
    public final void rule__Information__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7840:1: ( rule__Information__Group_2__1__Impl )
            // InternalModelDraw.g:7841:2: rule__Information__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Information__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group_2__1"


    // $ANTLR start "rule__Information__Group_2__1__Impl"
    // InternalModelDraw.g:7847:1: rule__Information__Group_2__1__Impl : ( ( rule__Information__AttAssignment_2_1 ) ) ;
    public final void rule__Information__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7851:1: ( ( ( rule__Information__AttAssignment_2_1 ) ) )
            // InternalModelDraw.g:7852:1: ( ( rule__Information__AttAssignment_2_1 ) )
            {
            // InternalModelDraw.g:7852:1: ( ( rule__Information__AttAssignment_2_1 ) )
            // InternalModelDraw.g:7853:2: ( rule__Information__AttAssignment_2_1 )
            {
             before(grammarAccess.getInformationAccess().getAttAssignment_2_1()); 
            // InternalModelDraw.g:7854:2: ( rule__Information__AttAssignment_2_1 )
            // InternalModelDraw.g:7854:3: rule__Information__AttAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Information__AttAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getInformationAccess().getAttAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__Group_2__1__Impl"


    // $ANTLR start "rule__MutatorDraw__MetamodelAssignment_2"
    // InternalModelDraw.g:7863:1: rule__MutatorDraw__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__MutatorDraw__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7867:1: ( ( ruleEString ) )
            // InternalModelDraw.g:7868:2: ( ruleEString )
            {
            // InternalModelDraw.g:7868:2: ( ruleEString )
            // InternalModelDraw.g:7869:3: ruleEString
            {
             before(grammarAccess.getMutatorDrawAccess().getMetamodelEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMutatorDrawAccess().getMetamodelEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__MetamodelAssignment_2"


    // $ANTLR start "rule__MutatorDraw__NameAssignment_3"
    // InternalModelDraw.g:7878:1: rule__MutatorDraw__NameAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MutatorDraw__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7882:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7883:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7883:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7884:3: ( RULE_ID )
            {
             before(grammarAccess.getMutatorDrawAccess().getNameEClassCrossReference_3_0()); 
            // InternalModelDraw.g:7885:3: ( RULE_ID )
            // InternalModelDraw.g:7886:4: RULE_ID
            {
             before(grammarAccess.getMutatorDrawAccess().getNameEClassIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMutatorDrawAccess().getNameEClassIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getMutatorDrawAccess().getNameEClassCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__NameAssignment_3"


    // $ANTLR start "rule__MutatorDraw__TypeAssignment_5"
    // InternalModelDraw.g:7897:1: rule__MutatorDraw__TypeAssignment_5 : ( ruleDrawType ) ;
    public final void rule__MutatorDraw__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7901:1: ( ( ruleDrawType ) )
            // InternalModelDraw.g:7902:2: ( ruleDrawType )
            {
            // InternalModelDraw.g:7902:2: ( ruleDrawType )
            // InternalModelDraw.g:7903:3: ruleDrawType
            {
             before(grammarAccess.getMutatorDrawAccess().getTypeDrawTypeEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleDrawType();

            state._fsp--;

             after(grammarAccess.getMutatorDrawAccess().getTypeDrawTypeEnumRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__TypeAssignment_5"


    // $ANTLR start "rule__MutatorDraw__NodesAssignment_7"
    // InternalModelDraw.g:7912:1: rule__MutatorDraw__NodesAssignment_7 : ( ruleNode ) ;
    public final void rule__MutatorDraw__NodesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7916:1: ( ( ruleNode ) )
            // InternalModelDraw.g:7917:2: ( ruleNode )
            {
            // InternalModelDraw.g:7917:2: ( ruleNode )
            // InternalModelDraw.g:7918:3: ruleNode
            {
             before(grammarAccess.getMutatorDrawAccess().getNodesNodeParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getMutatorDrawAccess().getNodesNodeParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__NodesAssignment_7"


    // $ANTLR start "rule__MutatorDraw__RelationsAssignment_8"
    // InternalModelDraw.g:7927:1: rule__MutatorDraw__RelationsAssignment_8 : ( ruleRelation ) ;
    public final void rule__MutatorDraw__RelationsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7931:1: ( ( ruleRelation ) )
            // InternalModelDraw.g:7932:2: ( ruleRelation )
            {
            // InternalModelDraw.g:7932:2: ( ruleRelation )
            // InternalModelDraw.g:7933:3: ruleRelation
            {
             before(grammarAccess.getMutatorDrawAccess().getRelationsRelationParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleRelation();

            state._fsp--;

             after(grammarAccess.getMutatorDrawAccess().getRelationsRelationParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__RelationsAssignment_8"


    // $ANTLR start "rule__MutatorDraw__ContentsAssignment_9"
    // InternalModelDraw.g:7942:1: rule__MutatorDraw__ContentsAssignment_9 : ( ruleContent ) ;
    public final void rule__MutatorDraw__ContentsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7946:1: ( ( ruleContent ) )
            // InternalModelDraw.g:7947:2: ( ruleContent )
            {
            // InternalModelDraw.g:7947:2: ( ruleContent )
            // InternalModelDraw.g:7948:3: ruleContent
            {
             before(grammarAccess.getMutatorDrawAccess().getContentsContentParserRuleCall_9_0()); 
            pushFollow(FOLLOW_2);
            ruleContent();

            state._fsp--;

             after(grammarAccess.getMutatorDrawAccess().getContentsContentParserRuleCall_9_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__ContentsAssignment_9"


    // $ANTLR start "rule__Node__NameAssignment_1"
    // InternalModelDraw.g:7957:1: rule__Node__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7961:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7962:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7962:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7963:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:7964:3: ( RULE_ID )
            // InternalModelDraw.g:7965:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__NameAssignment_1"


    // $ANTLR start "rule__Node__FeatureAssignment_2_1"
    // InternalModelDraw.g:7976:1: rule__Node__FeatureAssignment_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7980:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:7981:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:7981:2: ( ruleValuedFeature )
            // InternalModelDraw.g:7982:3: ruleValuedFeature
            {
             before(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__FeatureAssignment_2_1"


    // $ANTLR start "rule__Node__FeatureAssignment_2_2_1"
    // InternalModelDraw.g:7991:1: rule__Node__FeatureAssignment_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__FeatureAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7995:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:7996:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:7996:2: ( ruleValuedFeature )
            // InternalModelDraw.g:7997:3: ruleValuedFeature
            {
             before(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__FeatureAssignment_2_2_1"


    // $ANTLR start "rule__Node__TargetNodeAssignment_3_1"
    // InternalModelDraw.g:8006:1: rule__Node__TargetNodeAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__TargetNodeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8010:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8011:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8011:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8012:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getTargetNodeEClassCrossReference_3_1_0()); 
            // InternalModelDraw.g:8013:3: ( RULE_ID )
            // InternalModelDraw.g:8014:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getTargetNodeEClassIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getTargetNodeEClassIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getTargetNodeEClassCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__TargetNodeAssignment_3_1"


    // $ANTLR start "rule__Node__TargetFeatureAssignment_3_2_1"
    // InternalModelDraw.g:8025:1: rule__Node__TargetFeatureAssignment_3_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__TargetFeatureAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8029:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8030:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8030:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8031:3: ruleValuedFeature
            {
             before(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__TargetFeatureAssignment_3_2_1"


    // $ANTLR start "rule__Node__TargetFeatureAssignment_3_2_2_1"
    // InternalModelDraw.g:8040:1: rule__Node__TargetFeatureAssignment_3_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__TargetFeatureAssignment_3_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8044:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8045:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8045:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8046:3: ruleValuedFeature
            {
             before(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__TargetFeatureAssignment_3_2_2_1"


    // $ANTLR start "rule__Node__TypeAssignment_5"
    // InternalModelDraw.g:8055:1: rule__Node__TypeAssignment_5 : ( ruleNodeType ) ;
    public final void rule__Node__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8059:1: ( ( ruleNodeType ) )
            // InternalModelDraw.g:8060:2: ( ruleNodeType )
            {
            // InternalModelDraw.g:8060:2: ( ruleNodeType )
            // InternalModelDraw.g:8061:3: ruleNodeType
            {
             before(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeType();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__TypeAssignment_5"


    // $ANTLR start "rule__Node__AttNameAssignment_6_1"
    // InternalModelDraw.g:8070:1: rule__Node__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8074:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8075:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8075:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8076:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:8077:3: ( RULE_ID )
            // InternalModelDraw.g:8078:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getAttNameEAttributeIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getAttNameEAttributeIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__AttNameAssignment_6_1"


    // $ANTLR start "rule__Node__ReferenceAssignment_7_3"
    // InternalModelDraw.g:8089:1: rule__Node__ReferenceAssignment_7_3 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8093:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8094:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8094:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8095:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_3_0()); 
            // InternalModelDraw.g:8096:3: ( RULE_ID )
            // InternalModelDraw.g:8097:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_7_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_7_3_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ReferenceAssignment_7_3"


    // $ANTLR start "rule__Node__ReferenceAssignment_7_4"
    // InternalModelDraw.g:8108:1: rule__Node__ReferenceAssignment_7_4 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_7_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8112:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8113:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8113:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8114:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_4_0()); 
            // InternalModelDraw.g:8115:3: ( RULE_ID )
            // InternalModelDraw.g:8116:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_7_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_7_4_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ReferenceAssignment_7_4"


    // $ANTLR start "rule__Node__ShapeAssignment_8_2"
    // InternalModelDraw.g:8127:1: rule__Node__ShapeAssignment_8_2 : ( ruleNodeShape ) ;
    public final void rule__Node__ShapeAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8131:1: ( ( ruleNodeShape ) )
            // InternalModelDraw.g:8132:2: ( ruleNodeShape )
            {
            // InternalModelDraw.g:8132:2: ( ruleNodeShape )
            // InternalModelDraw.g:8133:3: ruleNodeShape
            {
             before(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeShape();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ShapeAssignment_8_2"


    // $ANTLR start "rule__Node__PathShapeAssignment_8_3_1"
    // InternalModelDraw.g:8142:1: rule__Node__PathShapeAssignment_8_3_1 : ( ruleEString ) ;
    public final void rule__Node__PathShapeAssignment_8_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8146:1: ( ( ruleEString ) )
            // InternalModelDraw.g:8147:2: ( ruleEString )
            {
            // InternalModelDraw.g:8147:2: ( ruleEString )
            // InternalModelDraw.g:8148:3: ruleEString
            {
             before(grammarAccess.getNodeAccess().getPathShapeEStringParserRuleCall_8_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getPathShapeEStringParserRuleCall_8_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__PathShapeAssignment_8_3_1"


    // $ANTLR start "rule__Node__ColorAssignment_9_2"
    // InternalModelDraw.g:8157:1: rule__Node__ColorAssignment_9_2 : ( ruleNodeColor ) ;
    public final void rule__Node__ColorAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8161:1: ( ( ruleNodeColor ) )
            // InternalModelDraw.g:8162:2: ( ruleNodeColor )
            {
            // InternalModelDraw.g:8162:2: ( ruleNodeColor )
            // InternalModelDraw.g:8163:3: ruleNodeColor
            {
             before(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeColor();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ColorAssignment_9_2"


    // $ANTLR start "rule__Node__StyleAssignment_10_2"
    // InternalModelDraw.g:8172:1: rule__Node__StyleAssignment_10_2 : ( ruleNodeStyle ) ;
    public final void rule__Node__StyleAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8176:1: ( ( ruleNodeStyle ) )
            // InternalModelDraw.g:8177:2: ( ruleNodeStyle )
            {
            // InternalModelDraw.g:8177:2: ( ruleNodeStyle )
            // InternalModelDraw.g:8178:3: ruleNodeStyle
            {
             before(grammarAccess.getNodeAccess().getStyleNodeStyleEnumRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeStyle();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getStyleNodeStyleEnumRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__StyleAssignment_10_2"


    // $ANTLR start "rule__ValuedFeature__NegationAssignment_1"
    // InternalModelDraw.g:8187:1: rule__ValuedFeature__NegationAssignment_1 : ( ( 'not' ) ) ;
    public final void rule__ValuedFeature__NegationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8191:1: ( ( ( 'not' ) ) )
            // InternalModelDraw.g:8192:2: ( ( 'not' ) )
            {
            // InternalModelDraw.g:8192:2: ( ( 'not' ) )
            // InternalModelDraw.g:8193:3: ( 'not' )
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 
            // InternalModelDraw.g:8194:3: ( 'not' )
            // InternalModelDraw.g:8195:4: 'not'
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 
            match(input,52,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__NegationAssignment_1"


    // $ANTLR start "rule__ValuedFeature__FeatAssignment_2"
    // InternalModelDraw.g:8206:1: rule__ValuedFeature__FeatAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__FeatAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8210:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8211:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8211:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8212:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0()); 
            // InternalModelDraw.g:8213:3: ( RULE_ID )
            // InternalModelDraw.g:8214:4: RULE_ID
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__FeatAssignment_2"


    // $ANTLR start "rule__ValuedFeature__RefFeatureAssignment_3_1"
    // InternalModelDraw.g:8225:1: rule__ValuedFeature__RefFeatureAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__RefFeatureAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8229:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8230:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8230:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8231:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0()); 
            // InternalModelDraw.g:8232:3: ( RULE_ID )
            // InternalModelDraw.g:8233:4: RULE_ID
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureIDTerminalRuleCall_3_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureIDTerminalRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__RefFeatureAssignment_3_1"


    // $ANTLR start "rule__ValuedFeature__ValueAssignment_4_1"
    // InternalModelDraw.g:8244:1: rule__ValuedFeature__ValueAssignment_4_1 : ( ( 'null' ) ) ;
    public final void rule__ValuedFeature__ValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8248:1: ( ( ( 'null' ) ) )
            // InternalModelDraw.g:8249:2: ( ( 'null' ) )
            {
            // InternalModelDraw.g:8249:2: ( ( 'null' ) )
            // InternalModelDraw.g:8250:3: ( 'null' )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 
            // InternalModelDraw.g:8251:3: ( 'null' )
            // InternalModelDraw.g:8252:4: 'null'
            {
             before(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 
            match(input,53,FOLLOW_2); 
             after(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 

            }

             after(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValuedFeature__ValueAssignment_4_1"


    // $ANTLR start "rule__Edge__NameAssignment_1"
    // InternalModelDraw.g:8263:1: rule__Edge__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8267:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8268:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8268:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8269:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:8270:3: ( RULE_ID )
            // InternalModelDraw.g:8271:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__NameAssignment_1"


    // $ANTLR start "rule__Edge__FeatureAssignment_2_1"
    // InternalModelDraw.g:8282:1: rule__Edge__FeatureAssignment_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8286:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8287:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8287:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8288:3: ruleValuedFeature
            {
             before(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__FeatureAssignment_2_1"


    // $ANTLR start "rule__Edge__FeatureAssignment_2_2_1"
    // InternalModelDraw.g:8297:1: rule__Edge__FeatureAssignment_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__FeatureAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8301:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8302:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8302:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8303:3: ruleValuedFeature
            {
             before(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getFeatureValuedFeatureParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__FeatureAssignment_2_2_1"


    // $ANTLR start "rule__Edge__SourceAssignment_3_0_1"
    // InternalModelDraw.g:8312:1: rule__Edge__SourceAssignment_3_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__SourceAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8316:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8317:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8317:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8318:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0_1_0()); 
            // InternalModelDraw.g:8319:3: ( RULE_ID )
            // InternalModelDraw.g:8320:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceIDTerminalRuleCall_3_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSourceEReferenceIDTerminalRuleCall_3_0_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__SourceAssignment_3_0_1"


    // $ANTLR start "rule__Edge__TargetAssignment_3_0_3"
    // InternalModelDraw.g:8331:1: rule__Edge__TargetAssignment_3_0_3 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__TargetAssignment_3_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8335:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8336:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8336:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8337:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_3_0_3_0()); 
            // InternalModelDraw.g:8338:3: ( RULE_ID )
            // InternalModelDraw.g:8339:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceIDTerminalRuleCall_3_0_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTargetEReferenceIDTerminalRuleCall_3_0_3_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_3_0_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__TargetAssignment_3_0_3"


    // $ANTLR start "rule__Edge__TargetNodeAssignment_3_1_1"
    // InternalModelDraw.g:8350:1: rule__Edge__TargetNodeAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__TargetNodeAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8354:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8355:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8355:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8356:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTargetNodeEClassCrossReference_3_1_1_0()); 
            // InternalModelDraw.g:8357:3: ( RULE_ID )
            // InternalModelDraw.g:8358:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getTargetNodeEClassIDTerminalRuleCall_3_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTargetNodeEClassIDTerminalRuleCall_3_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getTargetNodeEClassCrossReference_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__TargetNodeAssignment_3_1_1"


    // $ANTLR start "rule__Edge__TargetFeatureAssignment_3_1_2_1"
    // InternalModelDraw.g:8369:1: rule__Edge__TargetFeatureAssignment_3_1_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__TargetFeatureAssignment_3_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8373:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8374:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8374:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8375:3: ruleValuedFeature
            {
             before(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__TargetFeatureAssignment_3_1_2_1"


    // $ANTLR start "rule__Edge__TargetFeatureAssignment_3_1_2_2_1"
    // InternalModelDraw.g:8384:1: rule__Edge__TargetFeatureAssignment_3_1_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__TargetFeatureAssignment_3_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8388:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8389:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8389:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8390:3: ruleValuedFeature
            {
             before(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleValuedFeature();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getTargetFeatureValuedFeatureParserRuleCall_3_1_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__TargetFeatureAssignment_3_1_2_2_1"


    // $ANTLR start "rule__Edge__AttNameAssignment_6_1"
    // InternalModelDraw.g:8399:1: rule__Edge__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8403:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8404:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8404:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8405:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:8406:3: ( RULE_ID )
            // InternalModelDraw.g:8407:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getAttNameEAttributeIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getAttNameEAttributeIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__AttNameAssignment_6_1"


    // $ANTLR start "rule__Edge__ReferenceAssignment_7_2_0_0_0"
    // InternalModelDraw.g:8418:1: rule__Edge__ReferenceAssignment_7_2_0_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8422:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8423:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8423:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8424:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0()); 
            // InternalModelDraw.g:8425:3: ( RULE_ID )
            // InternalModelDraw.g:8426:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_0_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_0_0_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_7_2_0_0_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_7_2_0_0_1_1"
    // InternalModelDraw.g:8437:1: rule__Edge__RefTypeAssignment_7_2_0_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_0_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8441:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8442:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8442:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8443:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0()); 
            // InternalModelDraw.g:8444:3: ( RULE_ID )
            // InternalModelDraw.g:8445:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_0_0_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_0_0_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_7_2_0_0_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_7_2_0_1"
    // InternalModelDraw.g:8456:1: rule__Edge__LabelAssignment_7_2_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8460:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8461:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8461:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8462:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_0_1_0()); 
            // InternalModelDraw.g:8463:3: ( RULE_ID )
            // InternalModelDraw.g:8464:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_0_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_7_2_0_1"


    // $ANTLR start "rule__Edge__ReferenceAssignment_7_2_1_1_0"
    // InternalModelDraw.g:8475:1: rule__Edge__ReferenceAssignment_7_2_1_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8479:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8480:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8480:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8481:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0()); 
            // InternalModelDraw.g:8482:3: ( RULE_ID )
            // InternalModelDraw.g:8483:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_7_2_1_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_7_2_1_1_1_1"
    // InternalModelDraw.g:8494:1: rule__Edge__RefTypeAssignment_7_2_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8498:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8499:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8499:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8500:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0()); 
            // InternalModelDraw.g:8501:3: ( RULE_ID )
            // InternalModelDraw.g:8502:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_7_2_1_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_7_2_1_2"
    // InternalModelDraw.g:8513:1: rule__Edge__LabelAssignment_7_2_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8517:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8518:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8518:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8519:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_2_0()); 
            // InternalModelDraw.g:8520:3: ( RULE_ID )
            // InternalModelDraw.g:8521:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_7_2_1_2"


    // $ANTLR start "rule__Edge__ReferenceAssignment_7_2_1_3_1_0"
    // InternalModelDraw.g:8532:1: rule__Edge__ReferenceAssignment_7_2_1_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8536:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8537:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8537:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8538:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0()); 
            // InternalModelDraw.g:8539:3: ( RULE_ID )
            // InternalModelDraw.g:8540:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_3_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_3_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_7_2_1_3_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1"
    // InternalModelDraw.g:8551:1: rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8555:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8556:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8556:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8557:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0()); 
            // InternalModelDraw.g:8558:3: ( RULE_ID )
            // InternalModelDraw.g:8559:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_3_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_3_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_7_2_1_3_2"
    // InternalModelDraw.g:8570:1: rule__Edge__LabelAssignment_7_2_1_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8574:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8575:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8575:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8576:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0()); 
            // InternalModelDraw.g:8577:3: ( RULE_ID )
            // InternalModelDraw.g:8578:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_3_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_3_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_7_2_1_3_2"


    // $ANTLR start "rule__Edge__ReferenceAssignment_7_2_1_4_1_0"
    // InternalModelDraw.g:8589:1: rule__Edge__ReferenceAssignment_7_2_1_4_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8593:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8594:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8594:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8595:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0()); 
            // InternalModelDraw.g:8596:3: ( RULE_ID )
            // InternalModelDraw.g:8597:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_7_2_1_4_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1"
    // InternalModelDraw.g:8608:1: rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8612:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8613:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8613:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8614:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0()); 
            // InternalModelDraw.g:8615:3: ( RULE_ID )
            // InternalModelDraw.g:8616:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_7_2_1_4_2"
    // InternalModelDraw.g:8627:1: rule__Edge__LabelAssignment_7_2_1_4_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8631:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8632:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8632:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8633:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0()); 
            // InternalModelDraw.g:8634:3: ( RULE_ID )
            // InternalModelDraw.g:8635:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_7_2_1_4_2"


    // $ANTLR start "rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0"
    // InternalModelDraw.g:8646:1: rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8650:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8651:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8651:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8652:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0()); 
            // InternalModelDraw.g:8653:3: ( RULE_ID )
            // InternalModelDraw.g:8654:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_3_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_3_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1"
    // InternalModelDraw.g:8665:1: rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8669:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8670:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8670:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8671:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0()); 
            // InternalModelDraw.g:8672:3: ( RULE_ID )
            // InternalModelDraw.g:8673:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_3_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_3_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_7_2_1_4_3_2"
    // InternalModelDraw.g:8684:1: rule__Edge__LabelAssignment_7_2_1_4_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_4_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8688:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8689:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8689:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8690:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0()); 
            // InternalModelDraw.g:8691:3: ( RULE_ID )
            // InternalModelDraw.g:8692:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_3_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_3_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_7_2_1_4_3_2"


    // $ANTLR start "rule__Edge__Src_decorationAssignment_8_2"
    // InternalModelDraw.g:8703:1: rule__Edge__Src_decorationAssignment_8_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Src_decorationAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8707:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:8708:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:8708:2: ( ruleDecoration )
            // InternalModelDraw.g:8709:3: ruleDecoration
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDecoration();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Src_decorationAssignment_8_2"


    // $ANTLR start "rule__Edge__Src_labelAssignment_9_2"
    // InternalModelDraw.g:8718:1: rule__Edge__Src_labelAssignment_9_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Src_labelAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8722:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8723:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8723:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8724:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 
            // InternalModelDraw.g:8725:3: ( RULE_ID )
            // InternalModelDraw.g:8726:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelEAttributeIDTerminalRuleCall_9_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSrc_labelEAttributeIDTerminalRuleCall_9_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Src_labelAssignment_9_2"


    // $ANTLR start "rule__Edge__Tar_decorationAssignment_10_2"
    // InternalModelDraw.g:8737:1: rule__Edge__Tar_decorationAssignment_10_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Tar_decorationAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8741:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:8742:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:8742:2: ( ruleDecoration )
            // InternalModelDraw.g:8743:3: ruleDecoration
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDecoration();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Tar_decorationAssignment_10_2"


    // $ANTLR start "rule__Edge__Tar_labelAssignment_11_2"
    // InternalModelDraw.g:8752:1: rule__Edge__Tar_labelAssignment_11_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Tar_labelAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8756:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8757:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8757:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8758:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_11_2_0()); 
            // InternalModelDraw.g:8759:3: ( RULE_ID )
            // InternalModelDraw.g:8760:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getTar_labelEAttributeIDTerminalRuleCall_11_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTar_labelEAttributeIDTerminalRuleCall_11_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Tar_labelAssignment_11_2"


    // $ANTLR start "rule__Level__NameAssignment_1"
    // InternalModelDraw.g:8771:1: rule__Level__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8775:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8776:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8776:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8777:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:8778:3: ( RULE_ID )
            // InternalModelDraw.g:8779:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__NameAssignment_1"


    // $ANTLR start "rule__Level__UpperAssignment_3"
    // InternalModelDraw.g:8790:1: rule__Level__UpperAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Level__UpperAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8794:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8795:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8795:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8796:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0()); 
            // InternalModelDraw.g:8797:3: ( RULE_ID )
            // InternalModelDraw.g:8798:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getUpperEReferenceIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getUpperEReferenceIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__UpperAssignment_3"


    // $ANTLR start "rule__Level__AttNameAssignment_6_1"
    // InternalModelDraw.g:8809:1: rule__Level__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8813:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8814:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8814:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8815:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:8816:3: ( RULE_ID )
            // InternalModelDraw.g:8817:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getAttNameEAttributeIDTerminalRuleCall_6_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getAttNameEAttributeIDTerminalRuleCall_6_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__AttNameAssignment_6_1"


    // $ANTLR start "rule__Level__ReferenceAssignment_7_2_0_0_0"
    // InternalModelDraw.g:8828:1: rule__Level__ReferenceAssignment_7_2_0_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8832:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8833:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8833:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8834:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0()); 
            // InternalModelDraw.g:8835:3: ( RULE_ID )
            // InternalModelDraw.g:8836:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_0_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_0_0_0_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__ReferenceAssignment_7_2_0_0_0"


    // $ANTLR start "rule__Level__RefTypeAssignment_7_2_0_0_1_1"
    // InternalModelDraw.g:8847:1: rule__Level__RefTypeAssignment_7_2_0_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_0_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8851:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8852:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8852:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8853:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0()); 
            // InternalModelDraw.g:8854:3: ( RULE_ID )
            // InternalModelDraw.g:8855:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_0_0_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_0_0_1_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__RefTypeAssignment_7_2_0_0_1_1"


    // $ANTLR start "rule__Level__LabelAssignment_7_2_0_1"
    // InternalModelDraw.g:8866:1: rule__Level__LabelAssignment_7_2_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8870:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8871:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8871:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8872:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_0_1_0()); 
            // InternalModelDraw.g:8873:3: ( RULE_ID )
            // InternalModelDraw.g:8874:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_0_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__LabelAssignment_7_2_0_1"


    // $ANTLR start "rule__Level__ReferenceAssignment_7_2_1_1_0"
    // InternalModelDraw.g:8885:1: rule__Level__ReferenceAssignment_7_2_1_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8889:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8890:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8890:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8891:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0()); 
            // InternalModelDraw.g:8892:3: ( RULE_ID )
            // InternalModelDraw.g:8893:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_1_0_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__ReferenceAssignment_7_2_1_1_0"


    // $ANTLR start "rule__Level__RefTypeAssignment_7_2_1_1_1_1"
    // InternalModelDraw.g:8904:1: rule__Level__RefTypeAssignment_7_2_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8908:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8909:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8909:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8910:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0()); 
            // InternalModelDraw.g:8911:3: ( RULE_ID )
            // InternalModelDraw.g:8912:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__RefTypeAssignment_7_2_1_1_1_1"


    // $ANTLR start "rule__Level__LabelAssignment_7_2_1_2"
    // InternalModelDraw.g:8923:1: rule__Level__LabelAssignment_7_2_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8927:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8928:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8928:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8929:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_2_0()); 
            // InternalModelDraw.g:8930:3: ( RULE_ID )
            // InternalModelDraw.g:8931:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_2_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__LabelAssignment_7_2_1_2"


    // $ANTLR start "rule__Level__ReferenceAssignment_7_2_1_3_1_0"
    // InternalModelDraw.g:8942:1: rule__Level__ReferenceAssignment_7_2_1_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8946:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8947:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8947:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8948:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0()); 
            // InternalModelDraw.g:8949:3: ( RULE_ID )
            // InternalModelDraw.g:8950:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_3_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_3_1_0_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__ReferenceAssignment_7_2_1_3_1_0"


    // $ANTLR start "rule__Level__RefTypeAssignment_7_2_1_3_1_1_1"
    // InternalModelDraw.g:8961:1: rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8965:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8966:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8966:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8967:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0()); 
            // InternalModelDraw.g:8968:3: ( RULE_ID )
            // InternalModelDraw.g:8969:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_3_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_3_1_1_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__RefTypeAssignment_7_2_1_3_1_1_1"


    // $ANTLR start "rule__Level__LabelAssignment_7_2_1_3_2"
    // InternalModelDraw.g:8980:1: rule__Level__LabelAssignment_7_2_1_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8984:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8985:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8985:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8986:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0()); 
            // InternalModelDraw.g:8987:3: ( RULE_ID )
            // InternalModelDraw.g:8988:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_3_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_3_2_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__LabelAssignment_7_2_1_3_2"


    // $ANTLR start "rule__Level__ReferenceAssignment_7_2_1_4_1_0"
    // InternalModelDraw.g:8999:1: rule__Level__ReferenceAssignment_7_2_1_4_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9003:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9004:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9004:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9005:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0()); 
            // InternalModelDraw.g:9006:3: ( RULE_ID )
            // InternalModelDraw.g:9007:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_1_0_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__ReferenceAssignment_7_2_1_4_1_0"


    // $ANTLR start "rule__Level__RefTypeAssignment_7_2_1_4_1_1_1"
    // InternalModelDraw.g:9018:1: rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9022:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9023:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9023:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9024:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0()); 
            // InternalModelDraw.g:9025:3: ( RULE_ID )
            // InternalModelDraw.g:9026:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_1_1_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__RefTypeAssignment_7_2_1_4_1_1_1"


    // $ANTLR start "rule__Level__LabelAssignment_7_2_1_4_2"
    // InternalModelDraw.g:9037:1: rule__Level__LabelAssignment_7_2_1_4_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9041:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9042:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9042:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9043:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0()); 
            // InternalModelDraw.g:9044:3: ( RULE_ID )
            // InternalModelDraw.g:9045:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_2_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__LabelAssignment_7_2_1_4_2"


    // $ANTLR start "rule__Level__ReferenceAssignment_7_2_1_4_3_1_0"
    // InternalModelDraw.g:9056:1: rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_4_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9060:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9061:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9061:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9062:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0()); 
            // InternalModelDraw.g:9063:3: ( RULE_ID )
            // InternalModelDraw.g:9064:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_3_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_1_4_3_1_0_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__ReferenceAssignment_7_2_1_4_3_1_0"


    // $ANTLR start "rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1"
    // InternalModelDraw.g:9075:1: rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9079:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9080:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9080:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9081:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0()); 
            // InternalModelDraw.g:9082:3: ( RULE_ID )
            // InternalModelDraw.g:9083:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_3_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getRefTypeEReferenceIDTerminalRuleCall_7_2_1_4_3_1_1_1_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1"


    // $ANTLR start "rule__Level__LabelAssignment_7_2_1_4_3_2"
    // InternalModelDraw.g:9094:1: rule__Level__LabelAssignment_7_2_1_4_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_4_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9098:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9099:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9099:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9100:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0()); 
            // InternalModelDraw.g:9101:3: ( RULE_ID )
            // InternalModelDraw.g:9102:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_3_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_2_1_4_3_2_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__LabelAssignment_7_2_1_4_3_2"


    // $ANTLR start "rule__Level__Src_decorationAssignment_8_2"
    // InternalModelDraw.g:9113:1: rule__Level__Src_decorationAssignment_8_2 : ( ruleDecoration ) ;
    public final void rule__Level__Src_decorationAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9117:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:9118:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:9118:2: ( ruleDecoration )
            // InternalModelDraw.g:9119:3: ruleDecoration
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDecoration();

            state._fsp--;

             after(grammarAccess.getLevelAccess().getSrc_decorationDecorationEnumRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Src_decorationAssignment_8_2"


    // $ANTLR start "rule__Level__Src_labelAssignment_9_2"
    // InternalModelDraw.g:9128:1: rule__Level__Src_labelAssignment_9_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Src_labelAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9132:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9133:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9133:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9134:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 
            // InternalModelDraw.g:9135:3: ( RULE_ID )
            // InternalModelDraw.g:9136:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getSrc_labelEAttributeIDTerminalRuleCall_9_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getSrc_labelEAttributeIDTerminalRuleCall_9_2_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Src_labelAssignment_9_2"


    // $ANTLR start "rule__Level__Tar_decorationAssignment_10_2"
    // InternalModelDraw.g:9147:1: rule__Level__Tar_decorationAssignment_10_2 : ( ruleDecoration ) ;
    public final void rule__Level__Tar_decorationAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9151:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:9152:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:9152:2: ( ruleDecoration )
            // InternalModelDraw.g:9153:3: ruleDecoration
            {
             before(grammarAccess.getLevelAccess().getTar_decorationDecorationEnumRuleCall_10_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDecoration();

            state._fsp--;

             after(grammarAccess.getLevelAccess().getTar_decorationDecorationEnumRuleCall_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Tar_decorationAssignment_10_2"


    // $ANTLR start "rule__Level__Tar_labelAssignment_11_2"
    // InternalModelDraw.g:9162:1: rule__Level__Tar_labelAssignment_11_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Tar_labelAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9166:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9167:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9167:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9168:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getTar_labelEAttributeCrossReference_11_2_0()); 
            // InternalModelDraw.g:9169:3: ( RULE_ID )
            // InternalModelDraw.g:9170:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getTar_labelEAttributeIDTerminalRuleCall_11_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getTar_labelEAttributeIDTerminalRuleCall_11_2_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getTar_labelEAttributeCrossReference_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Tar_labelAssignment_11_2"


    // $ANTLR start "rule__Content__NameAssignment_1"
    // InternalModelDraw.g:9181:1: rule__Content__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9185:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9186:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9186:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9187:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:9188:3: ( RULE_ID )
            // InternalModelDraw.g:9189:4: RULE_ID
            {
             before(grammarAccess.getContentAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getContentAccess().getNameEClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__NameAssignment_1"


    // $ANTLR start "rule__Content__NodenumAssignment_3_0"
    // InternalModelDraw.g:9200:1: rule__Content__NodenumAssignment_3_0 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9204:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:9205:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:9205:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:9206:3: ruleNodeEnumerator
            {
             before(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeEnumerator();

            state._fsp--;

             after(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__NodenumAssignment_3_0"


    // $ANTLR start "rule__Content__NodenumAssignment_3_1"
    // InternalModelDraw.g:9215:1: rule__Content__NodenumAssignment_3_1 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9219:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:9220:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:9220:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:9221:3: ruleNodeEnumerator
            {
             before(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeEnumerator();

            state._fsp--;

             after(grammarAccess.getContentAccess().getNodenumNodeEnumeratorParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__NodenumAssignment_3_1"


    // $ANTLR start "rule__Content__InfoAssignment_4_0"
    // InternalModelDraw.g:9230:1: rule__Content__InfoAssignment_4_0 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9234:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:9235:2: ( ruleInformation )
            {
            // InternalModelDraw.g:9235:2: ( ruleInformation )
            // InternalModelDraw.g:9236:3: ruleInformation
            {
             before(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_0_0()); 
            pushFollow(FOLLOW_2);
            ruleInformation();

            state._fsp--;

             after(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__InfoAssignment_4_0"


    // $ANTLR start "rule__Content__InfoAssignment_4_1"
    // InternalModelDraw.g:9245:1: rule__Content__InfoAssignment_4_1 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9249:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:9250:2: ( ruleInformation )
            {
            // InternalModelDraw.g:9250:2: ( ruleInformation )
            // InternalModelDraw.g:9251:3: ruleInformation
            {
             before(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_2);
            ruleInformation();

            state._fsp--;

             after(grammarAccess.getContentAccess().getInfoInformationParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__InfoAssignment_4_1"


    // $ANTLR start "rule__Content__AttNameAssignment_5_1"
    // InternalModelDraw.g:9260:1: rule__Content__AttNameAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__AttNameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9264:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9265:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9265:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9266:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0()); 
            // InternalModelDraw.g:9267:3: ( RULE_ID )
            // InternalModelDraw.g:9268:4: RULE_ID
            {
             before(grammarAccess.getContentAccess().getAttNameEAttributeIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getContentAccess().getAttNameEAttributeIDTerminalRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__AttNameAssignment_5_1"


    // $ANTLR start "rule__Content__SymbolAssignment_6_2"
    // InternalModelDraw.g:9279:1: rule__Content__SymbolAssignment_6_2 : ( ruleEString ) ;
    public final void rule__Content__SymbolAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9283:1: ( ( ruleEString ) )
            // InternalModelDraw.g:9284:2: ( ruleEString )
            {
            // InternalModelDraw.g:9284:2: ( ruleEString )
            // InternalModelDraw.g:9285:3: ruleEString
            {
             before(grammarAccess.getContentAccess().getSymbolEStringParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getContentAccess().getSymbolEStringParserRuleCall_6_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Content__SymbolAssignment_6_2"


    // $ANTLR start "rule__NodeEnumerator__AttAssignment_1"
    // InternalModelDraw.g:9294:1: rule__NodeEnumerator__AttAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NodeEnumerator__AttAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9298:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9299:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9299:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9300:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0()); 
            // InternalModelDraw.g:9301:3: ( RULE_ID )
            // InternalModelDraw.g:9302:4: RULE_ID
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttEAttributeIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeEnumeratorAccess().getAttEAttributeIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__AttAssignment_1"


    // $ANTLR start "rule__NodeEnumerator__EnumeratorAssignment_3"
    // InternalModelDraw.g:9313:1: rule__NodeEnumerator__EnumeratorAssignment_3 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9317:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:9318:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:9318:2: ( ruleEnumerator )
            // InternalModelDraw.g:9319:3: ruleEnumerator
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerator();

            state._fsp--;

             after(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__EnumeratorAssignment_3"


    // $ANTLR start "rule__NodeEnumerator__EnumeratorAssignment_4"
    // InternalModelDraw.g:9328:1: rule__NodeEnumerator__EnumeratorAssignment_4 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9332:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:9333:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:9333:2: ( ruleEnumerator )
            // InternalModelDraw.g:9334:3: ruleEnumerator
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleEnumerator();

            state._fsp--;

             after(grammarAccess.getNodeEnumeratorAccess().getEnumeratorEnumeratorParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NodeEnumerator__EnumeratorAssignment_4"


    // $ANTLR start "rule__Enumerator__LiteralAssignment_1"
    // InternalModelDraw.g:9343:1: rule__Enumerator__LiteralAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Enumerator__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9347:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9348:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9348:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9349:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0()); 
            // InternalModelDraw.g:9350:3: ( RULE_ID )
            // InternalModelDraw.g:9351:4: RULE_ID
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__LiteralAssignment_1"


    // $ANTLR start "rule__Enumerator__ValueAssignment_3"
    // InternalModelDraw.g:9362:1: rule__Enumerator__ValueAssignment_3 : ( ruleEString ) ;
    public final void rule__Enumerator__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9366:1: ( ( ruleEString ) )
            // InternalModelDraw.g:9367:2: ( ruleEString )
            {
            // InternalModelDraw.g:9367:2: ( ruleEString )
            // InternalModelDraw.g:9368:3: ruleEString
            {
             before(grammarAccess.getEnumeratorAccess().getValueEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEnumeratorAccess().getValueEStringParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Enumerator__ValueAssignment_3"


    // $ANTLR start "rule__Information__TypeAssignment_1"
    // InternalModelDraw.g:9377:1: rule__Information__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9381:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9382:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9382:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9383:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0()); 
            // InternalModelDraw.g:9384:3: ( RULE_ID )
            // InternalModelDraw.g:9385:4: RULE_ID
            {
             before(grammarAccess.getInformationAccess().getTypeEReferenceIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getInformationAccess().getTypeEReferenceIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__TypeAssignment_1"


    // $ANTLR start "rule__Information__AttAssignment_2_1"
    // InternalModelDraw.g:9396:1: rule__Information__AttAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__AttAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9400:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9401:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9401:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9402:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getAttEAttributeCrossReference_2_1_0()); 
            // InternalModelDraw.g:9403:3: ( RULE_ID )
            // InternalModelDraw.g:9404:4: RULE_ID
            {
             before(grammarAccess.getInformationAccess().getAttEAttributeIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getInformationAccess().getAttEAttributeIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getInformationAccess().getAttEAttributeCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Information__AttAssignment_2_1"

    // Delegated rules


    protected DFA10 dfa10 = new DFA10(this);
    static final String dfa_1s = "\52\uffff";
    static final String dfa_2s = "\1\5\1\35\1\uffff\3\5\1\41\1\5\1\35\1\uffff\1\5\1\65\1\5\1\35\1\41\1\5\1\15\2\41\1\5\1\41\2\5\2\41\1\5\1\65\1\35\1\5\1\65\1\5\1\35\4\41\1\5\1\41\1\5\1\65\2\41";
    static final String dfa_3s = "\1\37\1\54\1\uffff\1\64\1\5\1\61\1\51\1\5\1\40\1\uffff\1\5\1\65\1\64\1\43\1\51\1\64\1\52\1\51\1\42\1\5\1\51\1\64\1\5\2\51\1\5\1\65\1\43\1\5\1\65\1\64\1\35\1\51\1\42\1\51\1\42\1\5\1\51\1\5\1\65\1\51\1\42";
    static final String dfa_4s = "\2\uffff\1\2\6\uffff\1\1\40\uffff";
    static final String dfa_5s = "\52\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\31\uffff\1\2",
            "\1\5\2\uffff\1\3\2\uffff\1\4\10\uffff\1\2",
            "",
            "\1\6\56\uffff\1\7",
            "\1\10",
            "\1\2\7\uffff\2\11\17\uffff\2\2\21\uffff\1\2",
            "\1\15\1\14\1\12\5\uffff\1\13",
            "\1\16",
            "\1\20\2\uffff\1\17",
            "",
            "\1\21",
            "\1\22",
            "\1\24\56\uffff\1\23",
            "\1\11\2\uffff\1\2\2\uffff\1\4",
            "\1\15\1\25\1\12\5\uffff\1\13",
            "\1\27\56\uffff\1\26",
            "\2\11\33\uffff\1\2",
            "\1\15\1\25\6\uffff\1\13",
            "\1\15\1\25",
            "\1\30",
            "\1\33\1\25\1\31\5\uffff\1\32",
            "\1\30\56\uffff\1\23",
            "\1\27",
            "\1\37\1\36\1\34\5\uffff\1\35",
            "\1\15\1\25\1\31\5\uffff\1\32",
            "\1\40",
            "\1\41",
            "\1\20\2\uffff\1\2\2\uffff\1\4",
            "\1\42",
            "\1\43",
            "\1\45\56\uffff\1\44",
            "\1\20",
            "\1\15\1\25\6\uffff\1\32",
            "\1\15\1\25",
            "\1\37\1\36\6\uffff\1\35",
            "\1\37\1\36",
            "\1\45",
            "\1\37\1\36\1\46\5\uffff\1\47",
            "\1\50",
            "\1\51",
            "\1\37\1\36\6\uffff\1\47",
            "\1\37\1\36"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 862:2: ( rule__MutatorDraw__NodesAssignment_7 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000080000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000920000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x000001F000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0010000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000000000F8000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000020800000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000900000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0001E81000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000100800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000580000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x000000000FC00000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0002000040000020L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0008000000000020L});

}