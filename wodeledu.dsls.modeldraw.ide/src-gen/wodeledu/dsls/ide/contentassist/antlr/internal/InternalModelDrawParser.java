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


    // $ANTLR start "entryRuleMutatorInstance"
    // InternalModelDraw.g:78:1: entryRuleMutatorInstance : ruleMutatorInstance EOF ;
    public final void entryRuleMutatorInstance() throws RecognitionException {
        try {
            // InternalModelDraw.g:79:1: ( ruleMutatorInstance EOF )
            // InternalModelDraw.g:80:1: ruleMutatorInstance EOF
            {
             before(grammarAccess.getMutatorInstanceRule()); 
            pushFollow(FOLLOW_1);
            ruleMutatorInstance();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceRule()); 
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
    // $ANTLR end "entryRuleMutatorInstance"


    // $ANTLR start "ruleMutatorInstance"
    // InternalModelDraw.g:87:1: ruleMutatorInstance : ( ( rule__MutatorInstance__Group__0 ) ) ;
    public final void ruleMutatorInstance() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:91:2: ( ( ( rule__MutatorInstance__Group__0 ) ) )
            // InternalModelDraw.g:92:2: ( ( rule__MutatorInstance__Group__0 ) )
            {
            // InternalModelDraw.g:92:2: ( ( rule__MutatorInstance__Group__0 ) )
            // InternalModelDraw.g:93:3: ( rule__MutatorInstance__Group__0 )
            {
             before(grammarAccess.getMutatorInstanceAccess().getGroup()); 
            // InternalModelDraw.g:94:3: ( rule__MutatorInstance__Group__0 )
            // InternalModelDraw.g:94:4: rule__MutatorInstance__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMutatorInstanceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMutatorInstance"


    // $ANTLR start "entryRuleEString"
    // InternalModelDraw.g:103:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // InternalModelDraw.g:104:1: ( ruleEString EOF )
            // InternalModelDraw.g:105:1: ruleEString EOF
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
    // InternalModelDraw.g:112:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:116:2: ( ( ( rule__EString__Alternatives ) ) )
            // InternalModelDraw.g:117:2: ( ( rule__EString__Alternatives ) )
            {
            // InternalModelDraw.g:117:2: ( ( rule__EString__Alternatives ) )
            // InternalModelDraw.g:118:3: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // InternalModelDraw.g:119:3: ( rule__EString__Alternatives )
            // InternalModelDraw.g:119:4: rule__EString__Alternatives
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
    // InternalModelDraw.g:128:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // InternalModelDraw.g:129:1: ( ruleNode EOF )
            // InternalModelDraw.g:130:1: ruleNode EOF
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
    // InternalModelDraw.g:137:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:141:2: ( ( ( rule__Node__Group__0 ) ) )
            // InternalModelDraw.g:142:2: ( ( rule__Node__Group__0 ) )
            {
            // InternalModelDraw.g:142:2: ( ( rule__Node__Group__0 ) )
            // InternalModelDraw.g:143:3: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // InternalModelDraw.g:144:3: ( rule__Node__Group__0 )
            // InternalModelDraw.g:144:4: rule__Node__Group__0
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
    // InternalModelDraw.g:153:1: entryRuleValuedFeature : ruleValuedFeature EOF ;
    public final void entryRuleValuedFeature() throws RecognitionException {
        try {
            // InternalModelDraw.g:154:1: ( ruleValuedFeature EOF )
            // InternalModelDraw.g:155:1: ruleValuedFeature EOF
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
    // InternalModelDraw.g:162:1: ruleValuedFeature : ( ( rule__ValuedFeature__Group__0 ) ) ;
    public final void ruleValuedFeature() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:166:2: ( ( ( rule__ValuedFeature__Group__0 ) ) )
            // InternalModelDraw.g:167:2: ( ( rule__ValuedFeature__Group__0 ) )
            {
            // InternalModelDraw.g:167:2: ( ( rule__ValuedFeature__Group__0 ) )
            // InternalModelDraw.g:168:3: ( rule__ValuedFeature__Group__0 )
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup()); 
            // InternalModelDraw.g:169:3: ( rule__ValuedFeature__Group__0 )
            // InternalModelDraw.g:169:4: rule__ValuedFeature__Group__0
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
    // InternalModelDraw.g:178:1: entryRuleRelation : ruleRelation EOF ;
    public final void entryRuleRelation() throws RecognitionException {
        try {
            // InternalModelDraw.g:179:1: ( ruleRelation EOF )
            // InternalModelDraw.g:180:1: ruleRelation EOF
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
    // InternalModelDraw.g:187:1: ruleRelation : ( ( rule__Relation__Alternatives ) ) ;
    public final void ruleRelation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:191:2: ( ( ( rule__Relation__Alternatives ) ) )
            // InternalModelDraw.g:192:2: ( ( rule__Relation__Alternatives ) )
            {
            // InternalModelDraw.g:192:2: ( ( rule__Relation__Alternatives ) )
            // InternalModelDraw.g:193:3: ( rule__Relation__Alternatives )
            {
             before(grammarAccess.getRelationAccess().getAlternatives()); 
            // InternalModelDraw.g:194:3: ( rule__Relation__Alternatives )
            // InternalModelDraw.g:194:4: rule__Relation__Alternatives
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
    // InternalModelDraw.g:203:1: entryRuleEdge : ruleEdge EOF ;
    public final void entryRuleEdge() throws RecognitionException {
        try {
            // InternalModelDraw.g:204:1: ( ruleEdge EOF )
            // InternalModelDraw.g:205:1: ruleEdge EOF
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
    // InternalModelDraw.g:212:1: ruleEdge : ( ( rule__Edge__Group__0 ) ) ;
    public final void ruleEdge() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:216:2: ( ( ( rule__Edge__Group__0 ) ) )
            // InternalModelDraw.g:217:2: ( ( rule__Edge__Group__0 ) )
            {
            // InternalModelDraw.g:217:2: ( ( rule__Edge__Group__0 ) )
            // InternalModelDraw.g:218:3: ( rule__Edge__Group__0 )
            {
             before(grammarAccess.getEdgeAccess().getGroup()); 
            // InternalModelDraw.g:219:3: ( rule__Edge__Group__0 )
            // InternalModelDraw.g:219:4: rule__Edge__Group__0
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
    // InternalModelDraw.g:228:1: entryRuleLevel : ruleLevel EOF ;
    public final void entryRuleLevel() throws RecognitionException {
        try {
            // InternalModelDraw.g:229:1: ( ruleLevel EOF )
            // InternalModelDraw.g:230:1: ruleLevel EOF
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
    // InternalModelDraw.g:237:1: ruleLevel : ( ( rule__Level__Group__0 ) ) ;
    public final void ruleLevel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:241:2: ( ( ( rule__Level__Group__0 ) ) )
            // InternalModelDraw.g:242:2: ( ( rule__Level__Group__0 ) )
            {
            // InternalModelDraw.g:242:2: ( ( rule__Level__Group__0 ) )
            // InternalModelDraw.g:243:3: ( rule__Level__Group__0 )
            {
             before(grammarAccess.getLevelAccess().getGroup()); 
            // InternalModelDraw.g:244:3: ( rule__Level__Group__0 )
            // InternalModelDraw.g:244:4: rule__Level__Group__0
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
    // InternalModelDraw.g:253:1: entryRuleContent : ruleContent EOF ;
    public final void entryRuleContent() throws RecognitionException {
        try {
            // InternalModelDraw.g:254:1: ( ruleContent EOF )
            // InternalModelDraw.g:255:1: ruleContent EOF
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
    // InternalModelDraw.g:262:1: ruleContent : ( ( rule__Content__Group__0 ) ) ;
    public final void ruleContent() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:266:2: ( ( ( rule__Content__Group__0 ) ) )
            // InternalModelDraw.g:267:2: ( ( rule__Content__Group__0 ) )
            {
            // InternalModelDraw.g:267:2: ( ( rule__Content__Group__0 ) )
            // InternalModelDraw.g:268:3: ( rule__Content__Group__0 )
            {
             before(grammarAccess.getContentAccess().getGroup()); 
            // InternalModelDraw.g:269:3: ( rule__Content__Group__0 )
            // InternalModelDraw.g:269:4: rule__Content__Group__0
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
    // InternalModelDraw.g:278:1: entryRuleNodeEnumerator : ruleNodeEnumerator EOF ;
    public final void entryRuleNodeEnumerator() throws RecognitionException {
        try {
            // InternalModelDraw.g:279:1: ( ruleNodeEnumerator EOF )
            // InternalModelDraw.g:280:1: ruleNodeEnumerator EOF
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
    // InternalModelDraw.g:287:1: ruleNodeEnumerator : ( ( rule__NodeEnumerator__Group__0 ) ) ;
    public final void ruleNodeEnumerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:291:2: ( ( ( rule__NodeEnumerator__Group__0 ) ) )
            // InternalModelDraw.g:292:2: ( ( rule__NodeEnumerator__Group__0 ) )
            {
            // InternalModelDraw.g:292:2: ( ( rule__NodeEnumerator__Group__0 ) )
            // InternalModelDraw.g:293:3: ( rule__NodeEnumerator__Group__0 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getGroup()); 
            // InternalModelDraw.g:294:3: ( rule__NodeEnumerator__Group__0 )
            // InternalModelDraw.g:294:4: rule__NodeEnumerator__Group__0
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
    // InternalModelDraw.g:303:1: entryRuleEnumerator : ruleEnumerator EOF ;
    public final void entryRuleEnumerator() throws RecognitionException {
        try {
            // InternalModelDraw.g:304:1: ( ruleEnumerator EOF )
            // InternalModelDraw.g:305:1: ruleEnumerator EOF
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
    // InternalModelDraw.g:312:1: ruleEnumerator : ( ( rule__Enumerator__Group__0 ) ) ;
    public final void ruleEnumerator() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:316:2: ( ( ( rule__Enumerator__Group__0 ) ) )
            // InternalModelDraw.g:317:2: ( ( rule__Enumerator__Group__0 ) )
            {
            // InternalModelDraw.g:317:2: ( ( rule__Enumerator__Group__0 ) )
            // InternalModelDraw.g:318:3: ( rule__Enumerator__Group__0 )
            {
             before(grammarAccess.getEnumeratorAccess().getGroup()); 
            // InternalModelDraw.g:319:3: ( rule__Enumerator__Group__0 )
            // InternalModelDraw.g:319:4: rule__Enumerator__Group__0
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
    // InternalModelDraw.g:328:1: entryRuleInformation : ruleInformation EOF ;
    public final void entryRuleInformation() throws RecognitionException {
        try {
            // InternalModelDraw.g:329:1: ( ruleInformation EOF )
            // InternalModelDraw.g:330:1: ruleInformation EOF
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
    // InternalModelDraw.g:337:1: ruleInformation : ( ( rule__Information__Group__0 ) ) ;
    public final void ruleInformation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:341:2: ( ( ( rule__Information__Group__0 ) ) )
            // InternalModelDraw.g:342:2: ( ( rule__Information__Group__0 ) )
            {
            // InternalModelDraw.g:342:2: ( ( rule__Information__Group__0 ) )
            // InternalModelDraw.g:343:3: ( rule__Information__Group__0 )
            {
             before(grammarAccess.getInformationAccess().getGroup()); 
            // InternalModelDraw.g:344:3: ( rule__Information__Group__0 )
            // InternalModelDraw.g:344:4: rule__Information__Group__0
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
    // InternalModelDraw.g:353:1: ruleDrawType : ( ( 'diagram' ) ) ;
    public final void ruleDrawType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:357:1: ( ( ( 'diagram' ) ) )
            // InternalModelDraw.g:358:2: ( ( 'diagram' ) )
            {
            // InternalModelDraw.g:358:2: ( ( 'diagram' ) )
            // InternalModelDraw.g:359:3: ( 'diagram' )
            {
             before(grammarAccess.getDrawTypeAccess().getDiagramEnumLiteralDeclaration()); 
            // InternalModelDraw.g:360:3: ( 'diagram' )
            // InternalModelDraw.g:360:4: 'diagram'
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
    // InternalModelDraw.g:369:1: ruleNodeType : ( ( rule__NodeType__Alternatives ) ) ;
    public final void ruleNodeType() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:373:1: ( ( ( rule__NodeType__Alternatives ) ) )
            // InternalModelDraw.g:374:2: ( ( rule__NodeType__Alternatives ) )
            {
            // InternalModelDraw.g:374:2: ( ( rule__NodeType__Alternatives ) )
            // InternalModelDraw.g:375:3: ( rule__NodeType__Alternatives )
            {
             before(grammarAccess.getNodeTypeAccess().getAlternatives()); 
            // InternalModelDraw.g:376:3: ( rule__NodeType__Alternatives )
            // InternalModelDraw.g:376:4: rule__NodeType__Alternatives
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
    // InternalModelDraw.g:385:1: ruleNodeShape : ( ( rule__NodeShape__Alternatives ) ) ;
    public final void ruleNodeShape() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:389:1: ( ( ( rule__NodeShape__Alternatives ) ) )
            // InternalModelDraw.g:390:2: ( ( rule__NodeShape__Alternatives ) )
            {
            // InternalModelDraw.g:390:2: ( ( rule__NodeShape__Alternatives ) )
            // InternalModelDraw.g:391:3: ( rule__NodeShape__Alternatives )
            {
             before(grammarAccess.getNodeShapeAccess().getAlternatives()); 
            // InternalModelDraw.g:392:3: ( rule__NodeShape__Alternatives )
            // InternalModelDraw.g:392:4: rule__NodeShape__Alternatives
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
    // InternalModelDraw.g:401:1: ruleNodeColor : ( ( 'gray95' ) ) ;
    public final void ruleNodeColor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:405:1: ( ( ( 'gray95' ) ) )
            // InternalModelDraw.g:406:2: ( ( 'gray95' ) )
            {
            // InternalModelDraw.g:406:2: ( ( 'gray95' ) )
            // InternalModelDraw.g:407:3: ( 'gray95' )
            {
             before(grammarAccess.getNodeColorAccess().getGray95EnumLiteralDeclaration()); 
            // InternalModelDraw.g:408:3: ( 'gray95' )
            // InternalModelDraw.g:408:4: 'gray95'
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
    // InternalModelDraw.g:417:1: ruleNodeStyle : ( ( rule__NodeStyle__Alternatives ) ) ;
    public final void ruleNodeStyle() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:421:1: ( ( ( rule__NodeStyle__Alternatives ) ) )
            // InternalModelDraw.g:422:2: ( ( rule__NodeStyle__Alternatives ) )
            {
            // InternalModelDraw.g:422:2: ( ( rule__NodeStyle__Alternatives ) )
            // InternalModelDraw.g:423:3: ( rule__NodeStyle__Alternatives )
            {
             before(grammarAccess.getNodeStyleAccess().getAlternatives()); 
            // InternalModelDraw.g:424:3: ( rule__NodeStyle__Alternatives )
            // InternalModelDraw.g:424:4: rule__NodeStyle__Alternatives
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
    // InternalModelDraw.g:433:1: ruleDecoration : ( ( rule__Decoration__Alternatives ) ) ;
    public final void ruleDecoration() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:437:1: ( ( ( rule__Decoration__Alternatives ) ) )
            // InternalModelDraw.g:438:2: ( ( rule__Decoration__Alternatives ) )
            {
            // InternalModelDraw.g:438:2: ( ( rule__Decoration__Alternatives ) )
            // InternalModelDraw.g:439:3: ( rule__Decoration__Alternatives )
            {
             before(grammarAccess.getDecorationAccess().getAlternatives()); 
            // InternalModelDraw.g:440:3: ( rule__Decoration__Alternatives )
            // InternalModelDraw.g:440:4: rule__Decoration__Alternatives
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
    // InternalModelDraw.g:448:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:452:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // InternalModelDraw.g:453:2: ( RULE_STRING )
                    {
                    // InternalModelDraw.g:453:2: ( RULE_STRING )
                    // InternalModelDraw.g:454:3: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_2); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:459:2: ( RULE_ID )
                    {
                    // InternalModelDraw.g:459:2: ( RULE_ID )
                    // InternalModelDraw.g:460:3: RULE_ID
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
    // InternalModelDraw.g:469:1: rule__Relation__Alternatives : ( ( ruleEdge ) | ( ruleLevel ) );
    public final void rule__Relation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:473:1: ( ( ruleEdge ) | ( ruleLevel ) )
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
                    // InternalModelDraw.g:474:2: ( ruleEdge )
                    {
                    // InternalModelDraw.g:474:2: ( ruleEdge )
                    // InternalModelDraw.g:475:3: ruleEdge
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
                    // InternalModelDraw.g:480:2: ( ruleLevel )
                    {
                    // InternalModelDraw.g:480:2: ( ruleLevel )
                    // InternalModelDraw.g:481:3: ruleLevel
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
    // InternalModelDraw.g:490:1: rule__Edge__Alternatives_3 : ( ( ( rule__Edge__Group_3_0__0 ) ) | ( ( rule__Edge__Group_3_1__0 ) ) );
    public final void rule__Edge__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:494:1: ( ( ( rule__Edge__Group_3_0__0 ) ) | ( ( rule__Edge__Group_3_1__0 ) ) )
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
                    // InternalModelDraw.g:495:2: ( ( rule__Edge__Group_3_0__0 ) )
                    {
                    // InternalModelDraw.g:495:2: ( ( rule__Edge__Group_3_0__0 ) )
                    // InternalModelDraw.g:496:3: ( rule__Edge__Group_3_0__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_3_0()); 
                    // InternalModelDraw.g:497:3: ( rule__Edge__Group_3_0__0 )
                    // InternalModelDraw.g:497:4: rule__Edge__Group_3_0__0
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
                    // InternalModelDraw.g:501:2: ( ( rule__Edge__Group_3_1__0 ) )
                    {
                    // InternalModelDraw.g:501:2: ( ( rule__Edge__Group_3_1__0 ) )
                    // InternalModelDraw.g:502:3: ( rule__Edge__Group_3_1__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_3_1()); 
                    // InternalModelDraw.g:503:3: ( rule__Edge__Group_3_1__0 )
                    // InternalModelDraw.g:503:4: rule__Edge__Group_3_1__0
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
    // InternalModelDraw.g:511:1: rule__Edge__Alternatives_7_2 : ( ( ( rule__Edge__Group_7_2_0__0 ) ) | ( ( rule__Edge__Group_7_2_1__0 ) ) );
    public final void rule__Edge__Alternatives_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:515:1: ( ( ( rule__Edge__Group_7_2_0__0 ) ) | ( ( rule__Edge__Group_7_2_1__0 ) ) )
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
                    // InternalModelDraw.g:516:2: ( ( rule__Edge__Group_7_2_0__0 ) )
                    {
                    // InternalModelDraw.g:516:2: ( ( rule__Edge__Group_7_2_0__0 ) )
                    // InternalModelDraw.g:517:3: ( rule__Edge__Group_7_2_0__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_7_2_0()); 
                    // InternalModelDraw.g:518:3: ( rule__Edge__Group_7_2_0__0 )
                    // InternalModelDraw.g:518:4: rule__Edge__Group_7_2_0__0
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
                    // InternalModelDraw.g:522:2: ( ( rule__Edge__Group_7_2_1__0 ) )
                    {
                    // InternalModelDraw.g:522:2: ( ( rule__Edge__Group_7_2_1__0 ) )
                    // InternalModelDraw.g:523:3: ( rule__Edge__Group_7_2_1__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_7_2_1()); 
                    // InternalModelDraw.g:524:3: ( rule__Edge__Group_7_2_1__0 )
                    // InternalModelDraw.g:524:4: rule__Edge__Group_7_2_1__0
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
    // InternalModelDraw.g:532:1: rule__Level__Alternatives_7_2 : ( ( ( rule__Level__Group_7_2_0__0 ) ) | ( ( rule__Level__Group_7_2_1__0 ) ) );
    public final void rule__Level__Alternatives_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:536:1: ( ( ( rule__Level__Group_7_2_0__0 ) ) | ( ( rule__Level__Group_7_2_1__0 ) ) )
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
                    // InternalModelDraw.g:537:2: ( ( rule__Level__Group_7_2_0__0 ) )
                    {
                    // InternalModelDraw.g:537:2: ( ( rule__Level__Group_7_2_0__0 ) )
                    // InternalModelDraw.g:538:3: ( rule__Level__Group_7_2_0__0 )
                    {
                     before(grammarAccess.getLevelAccess().getGroup_7_2_0()); 
                    // InternalModelDraw.g:539:3: ( rule__Level__Group_7_2_0__0 )
                    // InternalModelDraw.g:539:4: rule__Level__Group_7_2_0__0
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
                    // InternalModelDraw.g:543:2: ( ( rule__Level__Group_7_2_1__0 ) )
                    {
                    // InternalModelDraw.g:543:2: ( ( rule__Level__Group_7_2_1__0 ) )
                    // InternalModelDraw.g:544:3: ( rule__Level__Group_7_2_1__0 )
                    {
                     before(grammarAccess.getLevelAccess().getGroup_7_2_1()); 
                    // InternalModelDraw.g:545:3: ( rule__Level__Group_7_2_1__0 )
                    // InternalModelDraw.g:545:4: rule__Level__Group_7_2_1__0
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
    // InternalModelDraw.g:553:1: rule__NodeType__Alternatives : ( ( ( 'node' ) ) | ( ( 'markednode' ) ) );
    public final void rule__NodeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:557:1: ( ( ( 'node' ) ) | ( ( 'markednode' ) ) )
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
                    // InternalModelDraw.g:558:2: ( ( 'node' ) )
                    {
                    // InternalModelDraw.g:558:2: ( ( 'node' ) )
                    // InternalModelDraw.g:559:3: ( 'node' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:560:3: ( 'node' )
                    // InternalModelDraw.g:560:4: 'node'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:564:2: ( ( 'markednode' ) )
                    {
                    // InternalModelDraw.g:564:2: ( ( 'markednode' ) )
                    // InternalModelDraw.g:565:3: ( 'markednode' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:566:3: ( 'markednode' )
                    // InternalModelDraw.g:566:4: 'markednode'
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
    // InternalModelDraw.g:574:1: rule__NodeShape__Alternatives : ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) | ( ( 'load' ) ) | ( ( 'logic' ) ) );
    public final void rule__NodeShape__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:578:1: ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) | ( ( 'load' ) ) | ( ( 'logic' ) ) )
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
                    // InternalModelDraw.g:579:2: ( ( 'circle' ) )
                    {
                    // InternalModelDraw.g:579:2: ( ( 'circle' ) )
                    // InternalModelDraw.g:580:3: ( 'circle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:581:3: ( 'circle' )
                    // InternalModelDraw.g:581:4: 'circle'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:585:2: ( ( 'doublecircle' ) )
                    {
                    // InternalModelDraw.g:585:2: ( ( 'doublecircle' ) )
                    // InternalModelDraw.g:586:3: ( 'doublecircle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:587:3: ( 'doublecircle' )
                    // InternalModelDraw.g:587:4: 'doublecircle'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:591:2: ( ( 'record' ) )
                    {
                    // InternalModelDraw.g:591:2: ( ( 'record' ) )
                    // InternalModelDraw.g:592:3: ( 'record' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:593:3: ( 'record' )
                    // InternalModelDraw.g:593:4: 'record'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:597:2: ( ( 'load' ) )
                    {
                    // InternalModelDraw.g:597:2: ( ( 'load' ) )
                    // InternalModelDraw.g:598:3: ( 'load' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3()); 
                    // InternalModelDraw.g:599:3: ( 'load' )
                    // InternalModelDraw.g:599:4: 'load'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getLoadEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:603:2: ( ( 'logic' ) )
                    {
                    // InternalModelDraw.g:603:2: ( ( 'logic' ) )
                    // InternalModelDraw.g:604:3: ( 'logic' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getLogicEnumLiteralDeclaration_4()); 
                    // InternalModelDraw.g:605:3: ( 'logic' )
                    // InternalModelDraw.g:605:4: 'logic'
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
    // InternalModelDraw.g:613:1: rule__NodeStyle__Alternatives : ( ( ( 'italic' ) ) | ( ( 'underline' ) ) );
    public final void rule__NodeStyle__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:617:1: ( ( ( 'italic' ) ) | ( ( 'underline' ) ) )
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
                    // InternalModelDraw.g:618:2: ( ( 'italic' ) )
                    {
                    // InternalModelDraw.g:618:2: ( ( 'italic' ) )
                    // InternalModelDraw.g:619:3: ( 'italic' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:620:3: ( 'italic' )
                    // InternalModelDraw.g:620:4: 'italic'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:624:2: ( ( 'underline' ) )
                    {
                    // InternalModelDraw.g:624:2: ( ( 'underline' ) )
                    // InternalModelDraw.g:625:3: ( 'underline' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getUnderlineEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:626:3: ( 'underline' )
                    // InternalModelDraw.g:626:4: 'underline'
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
    // InternalModelDraw.g:634:1: rule__Decoration__Alternatives : ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) );
    public final void rule__Decoration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:638:1: ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) )
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
                    // InternalModelDraw.g:639:2: ( ( 'none' ) )
                    {
                    // InternalModelDraw.g:639:2: ( ( 'none' ) )
                    // InternalModelDraw.g:640:3: ( 'none' )
                    {
                     before(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:641:3: ( 'none' )
                    // InternalModelDraw.g:641:4: 'none'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:645:2: ( ( 'triangle' ) )
                    {
                    // InternalModelDraw.g:645:2: ( ( 'triangle' ) )
                    // InternalModelDraw.g:646:3: ( 'triangle' )
                    {
                     before(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:647:3: ( 'triangle' )
                    // InternalModelDraw.g:647:4: 'triangle'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:651:2: ( ( 'diamond' ) )
                    {
                    // InternalModelDraw.g:651:2: ( ( 'diamond' ) )
                    // InternalModelDraw.g:652:3: ( 'diamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:653:3: ( 'diamond' )
                    // InternalModelDraw.g:653:4: 'diamond'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:657:2: ( ( 'odiamond' ) )
                    {
                    // InternalModelDraw.g:657:2: ( ( 'odiamond' ) )
                    // InternalModelDraw.g:658:3: ( 'odiamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 
                    // InternalModelDraw.g:659:3: ( 'odiamond' )
                    // InternalModelDraw.g:659:4: 'odiamond'
                    {
                    match(input,25,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:663:2: ( ( 'open' ) )
                    {
                    // InternalModelDraw.g:663:2: ( ( 'open' ) )
                    // InternalModelDraw.g:664:3: ( 'open' )
                    {
                     before(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 
                    // InternalModelDraw.g:665:3: ( 'open' )
                    // InternalModelDraw.g:665:4: 'open'
                    {
                    match(input,26,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:669:2: ( ( 'empty' ) )
                    {
                    // InternalModelDraw.g:669:2: ( ( 'empty' ) )
                    // InternalModelDraw.g:670:3: ( 'empty' )
                    {
                     before(grammarAccess.getDecorationAccess().getEmptyEnumLiteralDeclaration_5()); 
                    // InternalModelDraw.g:671:3: ( 'empty' )
                    // InternalModelDraw.g:671:4: 'empty'
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
    // InternalModelDraw.g:679:1: rule__MutatorDraw__Group__0 : rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 ;
    public final void rule__MutatorDraw__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:683:1: ( rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 )
            // InternalModelDraw.g:684:2: rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1
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
    // InternalModelDraw.g:691:1: rule__MutatorDraw__Group__0__Impl : ( () ) ;
    public final void rule__MutatorDraw__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:695:1: ( ( () ) )
            // InternalModelDraw.g:696:1: ( () )
            {
            // InternalModelDraw.g:696:1: ( () )
            // InternalModelDraw.g:697:2: ()
            {
             before(grammarAccess.getMutatorDrawAccess().getMutatorDrawAction_0()); 
            // InternalModelDraw.g:698:2: ()
            // InternalModelDraw.g:698:3: 
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
    // InternalModelDraw.g:706:1: rule__MutatorDraw__Group__1 : rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 ;
    public final void rule__MutatorDraw__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:710:1: ( rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 )
            // InternalModelDraw.g:711:2: rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2
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
    // InternalModelDraw.g:718:1: rule__MutatorDraw__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__MutatorDraw__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:722:1: ( ( 'metamodel' ) )
            // InternalModelDraw.g:723:1: ( 'metamodel' )
            {
            // InternalModelDraw.g:723:1: ( 'metamodel' )
            // InternalModelDraw.g:724:2: 'metamodel'
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
    // InternalModelDraw.g:733:1: rule__MutatorDraw__Group__2 : rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 ;
    public final void rule__MutatorDraw__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:737:1: ( rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 )
            // InternalModelDraw.g:738:2: rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3
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
    // InternalModelDraw.g:745:1: rule__MutatorDraw__Group__2__Impl : ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) ;
    public final void rule__MutatorDraw__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:749:1: ( ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) )
            // InternalModelDraw.g:750:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            {
            // InternalModelDraw.g:750:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            // InternalModelDraw.g:751:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            {
             before(grammarAccess.getMutatorDrawAccess().getMetamodelAssignment_2()); 
            // InternalModelDraw.g:752:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            // InternalModelDraw.g:752:3: rule__MutatorDraw__MetamodelAssignment_2
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
    // InternalModelDraw.g:760:1: rule__MutatorDraw__Group__3 : rule__MutatorDraw__Group__3__Impl ;
    public final void rule__MutatorDraw__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:764:1: ( rule__MutatorDraw__Group__3__Impl )
            // InternalModelDraw.g:765:2: rule__MutatorDraw__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MutatorDraw__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:771:1: rule__MutatorDraw__Group__3__Impl : ( ( ( rule__MutatorDraw__InstancesAssignment_3 ) ) ( ( rule__MutatorDraw__InstancesAssignment_3 )* ) ) ;
    public final void rule__MutatorDraw__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:775:1: ( ( ( ( rule__MutatorDraw__InstancesAssignment_3 ) ) ( ( rule__MutatorDraw__InstancesAssignment_3 )* ) ) )
            // InternalModelDraw.g:776:1: ( ( ( rule__MutatorDraw__InstancesAssignment_3 ) ) ( ( rule__MutatorDraw__InstancesAssignment_3 )* ) )
            {
            // InternalModelDraw.g:776:1: ( ( ( rule__MutatorDraw__InstancesAssignment_3 ) ) ( ( rule__MutatorDraw__InstancesAssignment_3 )* ) )
            // InternalModelDraw.g:777:2: ( ( rule__MutatorDraw__InstancesAssignment_3 ) ) ( ( rule__MutatorDraw__InstancesAssignment_3 )* )
            {
            // InternalModelDraw.g:777:2: ( ( rule__MutatorDraw__InstancesAssignment_3 ) )
            // InternalModelDraw.g:778:3: ( rule__MutatorDraw__InstancesAssignment_3 )
            {
             before(grammarAccess.getMutatorDrawAccess().getInstancesAssignment_3()); 
            // InternalModelDraw.g:779:3: ( rule__MutatorDraw__InstancesAssignment_3 )
            // InternalModelDraw.g:779:4: rule__MutatorDraw__InstancesAssignment_3
            {
            pushFollow(FOLLOW_6);
            rule__MutatorDraw__InstancesAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMutatorDrawAccess().getInstancesAssignment_3()); 

            }

            // InternalModelDraw.g:782:2: ( ( rule__MutatorDraw__InstancesAssignment_3 )* )
            // InternalModelDraw.g:783:3: ( rule__MutatorDraw__InstancesAssignment_3 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getInstancesAssignment_3()); 
            // InternalModelDraw.g:784:3: ( rule__MutatorDraw__InstancesAssignment_3 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalModelDraw.g:784:4: rule__MutatorDraw__InstancesAssignment_3
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__MutatorDraw__InstancesAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getMutatorDrawAccess().getInstancesAssignment_3()); 

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
    // $ANTLR end "rule__MutatorDraw__Group__3__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__0"
    // InternalModelDraw.g:794:1: rule__MutatorInstance__Group__0 : rule__MutatorInstance__Group__0__Impl rule__MutatorInstance__Group__1 ;
    public final void rule__MutatorInstance__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:798:1: ( rule__MutatorInstance__Group__0__Impl rule__MutatorInstance__Group__1 )
            // InternalModelDraw.g:799:2: rule__MutatorInstance__Group__0__Impl rule__MutatorInstance__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__MutatorInstance__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__0"


    // $ANTLR start "rule__MutatorInstance__Group__0__Impl"
    // InternalModelDraw.g:806:1: rule__MutatorInstance__Group__0__Impl : ( () ) ;
    public final void rule__MutatorInstance__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:810:1: ( ( () ) )
            // InternalModelDraw.g:811:1: ( () )
            {
            // InternalModelDraw.g:811:1: ( () )
            // InternalModelDraw.g:812:2: ()
            {
             before(grammarAccess.getMutatorInstanceAccess().getMutatorInstanceAction_0()); 
            // InternalModelDraw.g:813:2: ()
            // InternalModelDraw.g:813:3: 
            {
            }

             after(grammarAccess.getMutatorInstanceAccess().getMutatorInstanceAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__0__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__1"
    // InternalModelDraw.g:821:1: rule__MutatorInstance__Group__1 : rule__MutatorInstance__Group__1__Impl rule__MutatorInstance__Group__2 ;
    public final void rule__MutatorInstance__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:825:1: ( rule__MutatorInstance__Group__1__Impl rule__MutatorInstance__Group__2 )
            // InternalModelDraw.g:826:2: rule__MutatorInstance__Group__1__Impl rule__MutatorInstance__Group__2
            {
            pushFollow(FOLLOW_7);
            rule__MutatorInstance__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__1"


    // $ANTLR start "rule__MutatorInstance__Group__1__Impl"
    // InternalModelDraw.g:833:1: rule__MutatorInstance__Group__1__Impl : ( ( rule__MutatorInstance__NameAssignment_1 ) ) ;
    public final void rule__MutatorInstance__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:837:1: ( ( ( rule__MutatorInstance__NameAssignment_1 ) ) )
            // InternalModelDraw.g:838:1: ( ( rule__MutatorInstance__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:838:1: ( ( rule__MutatorInstance__NameAssignment_1 ) )
            // InternalModelDraw.g:839:2: ( rule__MutatorInstance__NameAssignment_1 )
            {
             before(grammarAccess.getMutatorInstanceAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:840:2: ( rule__MutatorInstance__NameAssignment_1 )
            // InternalModelDraw.g:840:3: rule__MutatorInstance__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMutatorInstanceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__1__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__2"
    // InternalModelDraw.g:848:1: rule__MutatorInstance__Group__2 : rule__MutatorInstance__Group__2__Impl rule__MutatorInstance__Group__3 ;
    public final void rule__MutatorInstance__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:852:1: ( rule__MutatorInstance__Group__2__Impl rule__MutatorInstance__Group__3 )
            // InternalModelDraw.g:853:2: rule__MutatorInstance__Group__2__Impl rule__MutatorInstance__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__MutatorInstance__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__2"


    // $ANTLR start "rule__MutatorInstance__Group__2__Impl"
    // InternalModelDraw.g:860:1: rule__MutatorInstance__Group__2__Impl : ( ':' ) ;
    public final void rule__MutatorInstance__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:864:1: ( ( ':' ) )
            // InternalModelDraw.g:865:1: ( ':' )
            {
            // InternalModelDraw.g:865:1: ( ':' )
            // InternalModelDraw.g:866:2: ':'
            {
             before(grammarAccess.getMutatorInstanceAccess().getColonKeyword_2()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getMutatorInstanceAccess().getColonKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__2__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__3"
    // InternalModelDraw.g:875:1: rule__MutatorInstance__Group__3 : rule__MutatorInstance__Group__3__Impl rule__MutatorInstance__Group__4 ;
    public final void rule__MutatorInstance__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:879:1: ( rule__MutatorInstance__Group__3__Impl rule__MutatorInstance__Group__4 )
            // InternalModelDraw.g:880:2: rule__MutatorInstance__Group__3__Impl rule__MutatorInstance__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__MutatorInstance__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__3"


    // $ANTLR start "rule__MutatorInstance__Group__3__Impl"
    // InternalModelDraw.g:887:1: rule__MutatorInstance__Group__3__Impl : ( ( rule__MutatorInstance__TypeAssignment_3 ) ) ;
    public final void rule__MutatorInstance__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:891:1: ( ( ( rule__MutatorInstance__TypeAssignment_3 ) ) )
            // InternalModelDraw.g:892:1: ( ( rule__MutatorInstance__TypeAssignment_3 ) )
            {
            // InternalModelDraw.g:892:1: ( ( rule__MutatorInstance__TypeAssignment_3 ) )
            // InternalModelDraw.g:893:2: ( rule__MutatorInstance__TypeAssignment_3 )
            {
             before(grammarAccess.getMutatorInstanceAccess().getTypeAssignment_3()); 
            // InternalModelDraw.g:894:2: ( rule__MutatorInstance__TypeAssignment_3 )
            // InternalModelDraw.g:894:3: rule__MutatorInstance__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMutatorInstanceAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__3__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__4"
    // InternalModelDraw.g:902:1: rule__MutatorInstance__Group__4 : rule__MutatorInstance__Group__4__Impl rule__MutatorInstance__Group__5 ;
    public final void rule__MutatorInstance__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:906:1: ( rule__MutatorInstance__Group__4__Impl rule__MutatorInstance__Group__5 )
            // InternalModelDraw.g:907:2: rule__MutatorInstance__Group__4__Impl rule__MutatorInstance__Group__5
            {
            pushFollow(FOLLOW_10);
            rule__MutatorInstance__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__4"


    // $ANTLR start "rule__MutatorInstance__Group__4__Impl"
    // InternalModelDraw.g:914:1: rule__MutatorInstance__Group__4__Impl : ( '{' ) ;
    public final void rule__MutatorInstance__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:918:1: ( ( '{' ) )
            // InternalModelDraw.g:919:1: ( '{' )
            {
            // InternalModelDraw.g:919:1: ( '{' )
            // InternalModelDraw.g:920:2: '{'
            {
             before(grammarAccess.getMutatorInstanceAccess().getLeftCurlyBracketKeyword_4()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getMutatorInstanceAccess().getLeftCurlyBracketKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__4__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__5"
    // InternalModelDraw.g:929:1: rule__MutatorInstance__Group__5 : rule__MutatorInstance__Group__5__Impl rule__MutatorInstance__Group__6 ;
    public final void rule__MutatorInstance__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:933:1: ( rule__MutatorInstance__Group__5__Impl rule__MutatorInstance__Group__6 )
            // InternalModelDraw.g:934:2: rule__MutatorInstance__Group__5__Impl rule__MutatorInstance__Group__6
            {
            pushFollow(FOLLOW_10);
            rule__MutatorInstance__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__5"


    // $ANTLR start "rule__MutatorInstance__Group__5__Impl"
    // InternalModelDraw.g:941:1: rule__MutatorInstance__Group__5__Impl : ( ( rule__MutatorInstance__NodesAssignment_5 )* ) ;
    public final void rule__MutatorInstance__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:945:1: ( ( ( rule__MutatorInstance__NodesAssignment_5 )* ) )
            // InternalModelDraw.g:946:1: ( ( rule__MutatorInstance__NodesAssignment_5 )* )
            {
            // InternalModelDraw.g:946:1: ( ( rule__MutatorInstance__NodesAssignment_5 )* )
            // InternalModelDraw.g:947:2: ( rule__MutatorInstance__NodesAssignment_5 )*
            {
             before(grammarAccess.getMutatorInstanceAccess().getNodesAssignment_5()); 
            // InternalModelDraw.g:948:2: ( rule__MutatorInstance__NodesAssignment_5 )*
            loop11:
            do {
                int alt11=2;
                alt11 = dfa11.predict(input);
                switch (alt11) {
            	case 1 :
            	    // InternalModelDraw.g:948:3: rule__MutatorInstance__NodesAssignment_5
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__MutatorInstance__NodesAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getMutatorInstanceAccess().getNodesAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__5__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__6"
    // InternalModelDraw.g:956:1: rule__MutatorInstance__Group__6 : rule__MutatorInstance__Group__6__Impl rule__MutatorInstance__Group__7 ;
    public final void rule__MutatorInstance__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:960:1: ( rule__MutatorInstance__Group__6__Impl rule__MutatorInstance__Group__7 )
            // InternalModelDraw.g:961:2: rule__MutatorInstance__Group__6__Impl rule__MutatorInstance__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__MutatorInstance__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__6"


    // $ANTLR start "rule__MutatorInstance__Group__6__Impl"
    // InternalModelDraw.g:968:1: rule__MutatorInstance__Group__6__Impl : ( ( rule__MutatorInstance__RelationsAssignment_6 )* ) ;
    public final void rule__MutatorInstance__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:972:1: ( ( ( rule__MutatorInstance__RelationsAssignment_6 )* ) )
            // InternalModelDraw.g:973:1: ( ( rule__MutatorInstance__RelationsAssignment_6 )* )
            {
            // InternalModelDraw.g:973:1: ( ( rule__MutatorInstance__RelationsAssignment_6 )* )
            // InternalModelDraw.g:974:2: ( rule__MutatorInstance__RelationsAssignment_6 )*
            {
             before(grammarAccess.getMutatorInstanceAccess().getRelationsAssignment_6()); 
            // InternalModelDraw.g:975:2: ( rule__MutatorInstance__RelationsAssignment_6 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID) ) {
                    int LA12_1 = input.LA(2);

                    if ( (LA12_1==32||LA12_1==35||LA12_1==44) ) {
                        alt12=1;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // InternalModelDraw.g:975:3: rule__MutatorInstance__RelationsAssignment_6
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__MutatorInstance__RelationsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getMutatorInstanceAccess().getRelationsAssignment_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__6__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__7"
    // InternalModelDraw.g:983:1: rule__MutatorInstance__Group__7 : rule__MutatorInstance__Group__7__Impl rule__MutatorInstance__Group__8 ;
    public final void rule__MutatorInstance__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:987:1: ( rule__MutatorInstance__Group__7__Impl rule__MutatorInstance__Group__8 )
            // InternalModelDraw.g:988:2: rule__MutatorInstance__Group__7__Impl rule__MutatorInstance__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__MutatorInstance__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__7"


    // $ANTLR start "rule__MutatorInstance__Group__7__Impl"
    // InternalModelDraw.g:995:1: rule__MutatorInstance__Group__7__Impl : ( ( rule__MutatorInstance__ContentsAssignment_7 )* ) ;
    public final void rule__MutatorInstance__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:999:1: ( ( ( rule__MutatorInstance__ContentsAssignment_7 )* ) )
            // InternalModelDraw.g:1000:1: ( ( rule__MutatorInstance__ContentsAssignment_7 )* )
            {
            // InternalModelDraw.g:1000:1: ( ( rule__MutatorInstance__ContentsAssignment_7 )* )
            // InternalModelDraw.g:1001:2: ( rule__MutatorInstance__ContentsAssignment_7 )*
            {
             before(grammarAccess.getMutatorInstanceAccess().getContentsAssignment_7()); 
            // InternalModelDraw.g:1002:2: ( rule__MutatorInstance__ContentsAssignment_7 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalModelDraw.g:1002:3: rule__MutatorInstance__ContentsAssignment_7
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__MutatorInstance__ContentsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getMutatorInstanceAccess().getContentsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__7__Impl"


    // $ANTLR start "rule__MutatorInstance__Group__8"
    // InternalModelDraw.g:1010:1: rule__MutatorInstance__Group__8 : rule__MutatorInstance__Group__8__Impl ;
    public final void rule__MutatorInstance__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1014:1: ( rule__MutatorInstance__Group__8__Impl )
            // InternalModelDraw.g:1015:2: rule__MutatorInstance__Group__8__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MutatorInstance__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__8"


    // $ANTLR start "rule__MutatorInstance__Group__8__Impl"
    // InternalModelDraw.g:1021:1: rule__MutatorInstance__Group__8__Impl : ( '}' ) ;
    public final void rule__MutatorInstance__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1025:1: ( ( '}' ) )
            // InternalModelDraw.g:1026:1: ( '}' )
            {
            // InternalModelDraw.g:1026:1: ( '}' )
            // InternalModelDraw.g:1027:2: '}'
            {
             before(grammarAccess.getMutatorInstanceAccess().getRightCurlyBracketKeyword_8()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getMutatorInstanceAccess().getRightCurlyBracketKeyword_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__Group__8__Impl"


    // $ANTLR start "rule__Node__Group__0"
    // InternalModelDraw.g:1037:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1041:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalModelDraw.g:1042:2: rule__Node__Group__0__Impl rule__Node__Group__1
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
    // InternalModelDraw.g:1049:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1053:1: ( ( () ) )
            // InternalModelDraw.g:1054:1: ( () )
            {
            // InternalModelDraw.g:1054:1: ( () )
            // InternalModelDraw.g:1055:2: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // InternalModelDraw.g:1056:2: ()
            // InternalModelDraw.g:1056:3: 
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
    // InternalModelDraw.g:1064:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1068:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalModelDraw.g:1069:2: rule__Node__Group__1__Impl rule__Node__Group__2
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
    // InternalModelDraw.g:1076:1: rule__Node__Group__1__Impl : ( ( rule__Node__NameAssignment_1 ) ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1080:1: ( ( ( rule__Node__NameAssignment_1 ) ) )
            // InternalModelDraw.g:1081:1: ( ( rule__Node__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:1081:1: ( ( rule__Node__NameAssignment_1 ) )
            // InternalModelDraw.g:1082:2: ( rule__Node__NameAssignment_1 )
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:1083:2: ( rule__Node__NameAssignment_1 )
            // InternalModelDraw.g:1083:3: rule__Node__NameAssignment_1
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
    // InternalModelDraw.g:1091:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1095:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalModelDraw.g:1096:2: rule__Node__Group__2__Impl rule__Node__Group__3
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
    // InternalModelDraw.g:1103:1: rule__Node__Group__2__Impl : ( ( rule__Node__Group_2__0 )? ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1107:1: ( ( ( rule__Node__Group_2__0 )? ) )
            // InternalModelDraw.g:1108:1: ( ( rule__Node__Group_2__0 )? )
            {
            // InternalModelDraw.g:1108:1: ( ( rule__Node__Group_2__0 )? )
            // InternalModelDraw.g:1109:2: ( rule__Node__Group_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_2()); 
            // InternalModelDraw.g:1110:2: ( rule__Node__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalModelDraw.g:1110:3: rule__Node__Group_2__0
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
    // InternalModelDraw.g:1118:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1122:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalModelDraw.g:1123:2: rule__Node__Group__3__Impl rule__Node__Group__4
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
    // InternalModelDraw.g:1130:1: rule__Node__Group__3__Impl : ( ( rule__Node__Group_3__0 )? ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1134:1: ( ( ( rule__Node__Group_3__0 )? ) )
            // InternalModelDraw.g:1135:1: ( ( rule__Node__Group_3__0 )? )
            {
            // InternalModelDraw.g:1135:1: ( ( rule__Node__Group_3__0 )? )
            // InternalModelDraw.g:1136:2: ( rule__Node__Group_3__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_3()); 
            // InternalModelDraw.g:1137:2: ( rule__Node__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalModelDraw.g:1137:3: rule__Node__Group_3__0
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
    // InternalModelDraw.g:1145:1: rule__Node__Group__4 : rule__Node__Group__4__Impl rule__Node__Group__5 ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1149:1: ( rule__Node__Group__4__Impl rule__Node__Group__5 )
            // InternalModelDraw.g:1150:2: rule__Node__Group__4__Impl rule__Node__Group__5
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
    // InternalModelDraw.g:1157:1: rule__Node__Group__4__Impl : ( ':' ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1161:1: ( ( ':' ) )
            // InternalModelDraw.g:1162:1: ( ':' )
            {
            // InternalModelDraw.g:1162:1: ( ':' )
            // InternalModelDraw.g:1163:2: ':'
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
    // InternalModelDraw.g:1172:1: rule__Node__Group__5 : rule__Node__Group__5__Impl rule__Node__Group__6 ;
    public final void rule__Node__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1176:1: ( rule__Node__Group__5__Impl rule__Node__Group__6 )
            // InternalModelDraw.g:1177:2: rule__Node__Group__5__Impl rule__Node__Group__6
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
    // InternalModelDraw.g:1184:1: rule__Node__Group__5__Impl : ( ( rule__Node__TypeAssignment_5 ) ) ;
    public final void rule__Node__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1188:1: ( ( ( rule__Node__TypeAssignment_5 ) ) )
            // InternalModelDraw.g:1189:1: ( ( rule__Node__TypeAssignment_5 ) )
            {
            // InternalModelDraw.g:1189:1: ( ( rule__Node__TypeAssignment_5 ) )
            // InternalModelDraw.g:1190:2: ( rule__Node__TypeAssignment_5 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_5()); 
            // InternalModelDraw.g:1191:2: ( rule__Node__TypeAssignment_5 )
            // InternalModelDraw.g:1191:3: rule__Node__TypeAssignment_5
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
    // InternalModelDraw.g:1199:1: rule__Node__Group__6 : rule__Node__Group__6__Impl rule__Node__Group__7 ;
    public final void rule__Node__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1203:1: ( rule__Node__Group__6__Impl rule__Node__Group__7 )
            // InternalModelDraw.g:1204:2: rule__Node__Group__6__Impl rule__Node__Group__7
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
    // InternalModelDraw.g:1211:1: rule__Node__Group__6__Impl : ( ( rule__Node__Group_6__0 )? ) ;
    public final void rule__Node__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1215:1: ( ( ( rule__Node__Group_6__0 )? ) )
            // InternalModelDraw.g:1216:1: ( ( rule__Node__Group_6__0 )? )
            {
            // InternalModelDraw.g:1216:1: ( ( rule__Node__Group_6__0 )? )
            // InternalModelDraw.g:1217:2: ( rule__Node__Group_6__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_6()); 
            // InternalModelDraw.g:1218:2: ( rule__Node__Group_6__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==36) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalModelDraw.g:1218:3: rule__Node__Group_6__0
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
    // InternalModelDraw.g:1226:1: rule__Node__Group__7 : rule__Node__Group__7__Impl rule__Node__Group__8 ;
    public final void rule__Node__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1230:1: ( rule__Node__Group__7__Impl rule__Node__Group__8 )
            // InternalModelDraw.g:1231:2: rule__Node__Group__7__Impl rule__Node__Group__8
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
    // InternalModelDraw.g:1238:1: rule__Node__Group__7__Impl : ( ( rule__Node__Group_7__0 )? ) ;
    public final void rule__Node__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1242:1: ( ( ( rule__Node__Group_7__0 )? ) )
            // InternalModelDraw.g:1243:1: ( ( rule__Node__Group_7__0 )? )
            {
            // InternalModelDraw.g:1243:1: ( ( rule__Node__Group_7__0 )? )
            // InternalModelDraw.g:1244:2: ( rule__Node__Group_7__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_7()); 
            // InternalModelDraw.g:1245:2: ( rule__Node__Group_7__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalModelDraw.g:1245:3: rule__Node__Group_7__0
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
    // InternalModelDraw.g:1253:1: rule__Node__Group__8 : rule__Node__Group__8__Impl rule__Node__Group__9 ;
    public final void rule__Node__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1257:1: ( rule__Node__Group__8__Impl rule__Node__Group__9 )
            // InternalModelDraw.g:1258:2: rule__Node__Group__8__Impl rule__Node__Group__9
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
    // InternalModelDraw.g:1265:1: rule__Node__Group__8__Impl : ( ( rule__Node__Group_8__0 )? ) ;
    public final void rule__Node__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1269:1: ( ( ( rule__Node__Group_8__0 )? ) )
            // InternalModelDraw.g:1270:1: ( ( rule__Node__Group_8__0 )? )
            {
            // InternalModelDraw.g:1270:1: ( ( rule__Node__Group_8__0 )? )
            // InternalModelDraw.g:1271:2: ( rule__Node__Group_8__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_8()); 
            // InternalModelDraw.g:1272:2: ( rule__Node__Group_8__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==38) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalModelDraw.g:1272:3: rule__Node__Group_8__0
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
    // InternalModelDraw.g:1280:1: rule__Node__Group__9 : rule__Node__Group__9__Impl rule__Node__Group__10 ;
    public final void rule__Node__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1284:1: ( rule__Node__Group__9__Impl rule__Node__Group__10 )
            // InternalModelDraw.g:1285:2: rule__Node__Group__9__Impl rule__Node__Group__10
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
    // InternalModelDraw.g:1292:1: rule__Node__Group__9__Impl : ( ( rule__Node__Group_9__0 )? ) ;
    public final void rule__Node__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1296:1: ( ( ( rule__Node__Group_9__0 )? ) )
            // InternalModelDraw.g:1297:1: ( ( rule__Node__Group_9__0 )? )
            {
            // InternalModelDraw.g:1297:1: ( ( rule__Node__Group_9__0 )? )
            // InternalModelDraw.g:1298:2: ( rule__Node__Group_9__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_9()); 
            // InternalModelDraw.g:1299:2: ( rule__Node__Group_9__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==39) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalModelDraw.g:1299:3: rule__Node__Group_9__0
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
    // InternalModelDraw.g:1307:1: rule__Node__Group__10 : rule__Node__Group__10__Impl ;
    public final void rule__Node__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1311:1: ( rule__Node__Group__10__Impl )
            // InternalModelDraw.g:1312:2: rule__Node__Group__10__Impl
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
    // InternalModelDraw.g:1318:1: rule__Node__Group__10__Impl : ( ( rule__Node__Group_10__0 )? ) ;
    public final void rule__Node__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1322:1: ( ( ( rule__Node__Group_10__0 )? ) )
            // InternalModelDraw.g:1323:1: ( ( rule__Node__Group_10__0 )? )
            {
            // InternalModelDraw.g:1323:1: ( ( rule__Node__Group_10__0 )? )
            // InternalModelDraw.g:1324:2: ( rule__Node__Group_10__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_10()); 
            // InternalModelDraw.g:1325:2: ( rule__Node__Group_10__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==40) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalModelDraw.g:1325:3: rule__Node__Group_10__0
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
    // InternalModelDraw.g:1334:1: rule__Node__Group_2__0 : rule__Node__Group_2__0__Impl rule__Node__Group_2__1 ;
    public final void rule__Node__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1338:1: ( rule__Node__Group_2__0__Impl rule__Node__Group_2__1 )
            // InternalModelDraw.g:1339:2: rule__Node__Group_2__0__Impl rule__Node__Group_2__1
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
    // InternalModelDraw.g:1346:1: rule__Node__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1350:1: ( ( '(' ) )
            // InternalModelDraw.g:1351:1: ( '(' )
            {
            // InternalModelDraw.g:1351:1: ( '(' )
            // InternalModelDraw.g:1352:2: '('
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
    // InternalModelDraw.g:1361:1: rule__Node__Group_2__1 : rule__Node__Group_2__1__Impl rule__Node__Group_2__2 ;
    public final void rule__Node__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1365:1: ( rule__Node__Group_2__1__Impl rule__Node__Group_2__2 )
            // InternalModelDraw.g:1366:2: rule__Node__Group_2__1__Impl rule__Node__Group_2__2
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
    // InternalModelDraw.g:1373:1: rule__Node__Group_2__1__Impl : ( ( rule__Node__FeatureAssignment_2_1 ) ) ;
    public final void rule__Node__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1377:1: ( ( ( rule__Node__FeatureAssignment_2_1 ) ) )
            // InternalModelDraw.g:1378:1: ( ( rule__Node__FeatureAssignment_2_1 ) )
            {
            // InternalModelDraw.g:1378:1: ( ( rule__Node__FeatureAssignment_2_1 ) )
            // InternalModelDraw.g:1379:2: ( rule__Node__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getNodeAccess().getFeatureAssignment_2_1()); 
            // InternalModelDraw.g:1380:2: ( rule__Node__FeatureAssignment_2_1 )
            // InternalModelDraw.g:1380:3: rule__Node__FeatureAssignment_2_1
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
    // InternalModelDraw.g:1388:1: rule__Node__Group_2__2 : rule__Node__Group_2__2__Impl rule__Node__Group_2__3 ;
    public final void rule__Node__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1392:1: ( rule__Node__Group_2__2__Impl rule__Node__Group_2__3 )
            // InternalModelDraw.g:1393:2: rule__Node__Group_2__2__Impl rule__Node__Group_2__3
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
    // InternalModelDraw.g:1400:1: rule__Node__Group_2__2__Impl : ( ( rule__Node__Group_2_2__0 )* ) ;
    public final void rule__Node__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1404:1: ( ( ( rule__Node__Group_2_2__0 )* ) )
            // InternalModelDraw.g:1405:1: ( ( rule__Node__Group_2_2__0 )* )
            {
            // InternalModelDraw.g:1405:1: ( ( rule__Node__Group_2_2__0 )* )
            // InternalModelDraw.g:1406:2: ( rule__Node__Group_2_2__0 )*
            {
             before(grammarAccess.getNodeAccess().getGroup_2_2()); 
            // InternalModelDraw.g:1407:2: ( rule__Node__Group_2_2__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalModelDraw.g:1407:3: rule__Node__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Node__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // InternalModelDraw.g:1415:1: rule__Node__Group_2__3 : rule__Node__Group_2__3__Impl ;
    public final void rule__Node__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1419:1: ( rule__Node__Group_2__3__Impl )
            // InternalModelDraw.g:1420:2: rule__Node__Group_2__3__Impl
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
    // InternalModelDraw.g:1426:1: rule__Node__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Node__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1430:1: ( ( ')' ) )
            // InternalModelDraw.g:1431:1: ( ')' )
            {
            // InternalModelDraw.g:1431:1: ( ')' )
            // InternalModelDraw.g:1432:2: ')'
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
    // InternalModelDraw.g:1442:1: rule__Node__Group_2_2__0 : rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 ;
    public final void rule__Node__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1446:1: ( rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 )
            // InternalModelDraw.g:1447:2: rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1
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
    // InternalModelDraw.g:1454:1: rule__Node__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Node__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1458:1: ( ( ',' ) )
            // InternalModelDraw.g:1459:1: ( ',' )
            {
            // InternalModelDraw.g:1459:1: ( ',' )
            // InternalModelDraw.g:1460:2: ','
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
    // InternalModelDraw.g:1469:1: rule__Node__Group_2_2__1 : rule__Node__Group_2_2__1__Impl ;
    public final void rule__Node__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1473:1: ( rule__Node__Group_2_2__1__Impl )
            // InternalModelDraw.g:1474:2: rule__Node__Group_2_2__1__Impl
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
    // InternalModelDraw.g:1480:1: rule__Node__Group_2_2__1__Impl : ( ( rule__Node__FeatureAssignment_2_2_1 ) ) ;
    public final void rule__Node__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1484:1: ( ( ( rule__Node__FeatureAssignment_2_2_1 ) ) )
            // InternalModelDraw.g:1485:1: ( ( rule__Node__FeatureAssignment_2_2_1 ) )
            {
            // InternalModelDraw.g:1485:1: ( ( rule__Node__FeatureAssignment_2_2_1 ) )
            // InternalModelDraw.g:1486:2: ( rule__Node__FeatureAssignment_2_2_1 )
            {
             before(grammarAccess.getNodeAccess().getFeatureAssignment_2_2_1()); 
            // InternalModelDraw.g:1487:2: ( rule__Node__FeatureAssignment_2_2_1 )
            // InternalModelDraw.g:1487:3: rule__Node__FeatureAssignment_2_2_1
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
    // InternalModelDraw.g:1496:1: rule__Node__Group_3__0 : rule__Node__Group_3__0__Impl rule__Node__Group_3__1 ;
    public final void rule__Node__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1500:1: ( rule__Node__Group_3__0__Impl rule__Node__Group_3__1 )
            // InternalModelDraw.g:1501:2: rule__Node__Group_3__0__Impl rule__Node__Group_3__1
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
    // InternalModelDraw.g:1508:1: rule__Node__Group_3__0__Impl : ( '->' ) ;
    public final void rule__Node__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1512:1: ( ( '->' ) )
            // InternalModelDraw.g:1513:1: ( '->' )
            {
            // InternalModelDraw.g:1513:1: ( '->' )
            // InternalModelDraw.g:1514:2: '->'
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
    // InternalModelDraw.g:1523:1: rule__Node__Group_3__1 : rule__Node__Group_3__1__Impl rule__Node__Group_3__2 ;
    public final void rule__Node__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1527:1: ( rule__Node__Group_3__1__Impl rule__Node__Group_3__2 )
            // InternalModelDraw.g:1528:2: rule__Node__Group_3__1__Impl rule__Node__Group_3__2
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
    // InternalModelDraw.g:1535:1: rule__Node__Group_3__1__Impl : ( ( rule__Node__TargetNodeAssignment_3_1 ) ) ;
    public final void rule__Node__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1539:1: ( ( ( rule__Node__TargetNodeAssignment_3_1 ) ) )
            // InternalModelDraw.g:1540:1: ( ( rule__Node__TargetNodeAssignment_3_1 ) )
            {
            // InternalModelDraw.g:1540:1: ( ( rule__Node__TargetNodeAssignment_3_1 ) )
            // InternalModelDraw.g:1541:2: ( rule__Node__TargetNodeAssignment_3_1 )
            {
             before(grammarAccess.getNodeAccess().getTargetNodeAssignment_3_1()); 
            // InternalModelDraw.g:1542:2: ( rule__Node__TargetNodeAssignment_3_1 )
            // InternalModelDraw.g:1542:3: rule__Node__TargetNodeAssignment_3_1
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
    // InternalModelDraw.g:1550:1: rule__Node__Group_3__2 : rule__Node__Group_3__2__Impl ;
    public final void rule__Node__Group_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1554:1: ( rule__Node__Group_3__2__Impl )
            // InternalModelDraw.g:1555:2: rule__Node__Group_3__2__Impl
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
    // InternalModelDraw.g:1561:1: rule__Node__Group_3__2__Impl : ( ( rule__Node__Group_3_2__0 )? ) ;
    public final void rule__Node__Group_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1565:1: ( ( ( rule__Node__Group_3_2__0 )? ) )
            // InternalModelDraw.g:1566:1: ( ( rule__Node__Group_3_2__0 )? )
            {
            // InternalModelDraw.g:1566:1: ( ( rule__Node__Group_3_2__0 )? )
            // InternalModelDraw.g:1567:2: ( rule__Node__Group_3_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_3_2()); 
            // InternalModelDraw.g:1568:2: ( rule__Node__Group_3_2__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==32) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalModelDraw.g:1568:3: rule__Node__Group_3_2__0
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
    // InternalModelDraw.g:1577:1: rule__Node__Group_3_2__0 : rule__Node__Group_3_2__0__Impl rule__Node__Group_3_2__1 ;
    public final void rule__Node__Group_3_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1581:1: ( rule__Node__Group_3_2__0__Impl rule__Node__Group_3_2__1 )
            // InternalModelDraw.g:1582:2: rule__Node__Group_3_2__0__Impl rule__Node__Group_3_2__1
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
    // InternalModelDraw.g:1589:1: rule__Node__Group_3_2__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_3_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1593:1: ( ( '(' ) )
            // InternalModelDraw.g:1594:1: ( '(' )
            {
            // InternalModelDraw.g:1594:1: ( '(' )
            // InternalModelDraw.g:1595:2: '('
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
    // InternalModelDraw.g:1604:1: rule__Node__Group_3_2__1 : rule__Node__Group_3_2__1__Impl rule__Node__Group_3_2__2 ;
    public final void rule__Node__Group_3_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1608:1: ( rule__Node__Group_3_2__1__Impl rule__Node__Group_3_2__2 )
            // InternalModelDraw.g:1609:2: rule__Node__Group_3_2__1__Impl rule__Node__Group_3_2__2
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
    // InternalModelDraw.g:1616:1: rule__Node__Group_3_2__1__Impl : ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) ) ;
    public final void rule__Node__Group_3_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1620:1: ( ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) ) )
            // InternalModelDraw.g:1621:1: ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) )
            {
            // InternalModelDraw.g:1621:1: ( ( rule__Node__TargetFeatureAssignment_3_2_1 ) )
            // InternalModelDraw.g:1622:2: ( rule__Node__TargetFeatureAssignment_3_2_1 )
            {
             before(grammarAccess.getNodeAccess().getTargetFeatureAssignment_3_2_1()); 
            // InternalModelDraw.g:1623:2: ( rule__Node__TargetFeatureAssignment_3_2_1 )
            // InternalModelDraw.g:1623:3: rule__Node__TargetFeatureAssignment_3_2_1
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
    // InternalModelDraw.g:1631:1: rule__Node__Group_3_2__2 : rule__Node__Group_3_2__2__Impl rule__Node__Group_3_2__3 ;
    public final void rule__Node__Group_3_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1635:1: ( rule__Node__Group_3_2__2__Impl rule__Node__Group_3_2__3 )
            // InternalModelDraw.g:1636:2: rule__Node__Group_3_2__2__Impl rule__Node__Group_3_2__3
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
    // InternalModelDraw.g:1643:1: rule__Node__Group_3_2__2__Impl : ( ( rule__Node__Group_3_2_2__0 )* ) ;
    public final void rule__Node__Group_3_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1647:1: ( ( ( rule__Node__Group_3_2_2__0 )* ) )
            // InternalModelDraw.g:1648:1: ( ( rule__Node__Group_3_2_2__0 )* )
            {
            // InternalModelDraw.g:1648:1: ( ( rule__Node__Group_3_2_2__0 )* )
            // InternalModelDraw.g:1649:2: ( rule__Node__Group_3_2_2__0 )*
            {
             before(grammarAccess.getNodeAccess().getGroup_3_2_2()); 
            // InternalModelDraw.g:1650:2: ( rule__Node__Group_3_2_2__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalModelDraw.g:1650:3: rule__Node__Group_3_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Node__Group_3_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // InternalModelDraw.g:1658:1: rule__Node__Group_3_2__3 : rule__Node__Group_3_2__3__Impl ;
    public final void rule__Node__Group_3_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1662:1: ( rule__Node__Group_3_2__3__Impl )
            // InternalModelDraw.g:1663:2: rule__Node__Group_3_2__3__Impl
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
    // InternalModelDraw.g:1669:1: rule__Node__Group_3_2__3__Impl : ( ')' ) ;
    public final void rule__Node__Group_3_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1673:1: ( ( ')' ) )
            // InternalModelDraw.g:1674:1: ( ')' )
            {
            // InternalModelDraw.g:1674:1: ( ')' )
            // InternalModelDraw.g:1675:2: ')'
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
    // InternalModelDraw.g:1685:1: rule__Node__Group_3_2_2__0 : rule__Node__Group_3_2_2__0__Impl rule__Node__Group_3_2_2__1 ;
    public final void rule__Node__Group_3_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1689:1: ( rule__Node__Group_3_2_2__0__Impl rule__Node__Group_3_2_2__1 )
            // InternalModelDraw.g:1690:2: rule__Node__Group_3_2_2__0__Impl rule__Node__Group_3_2_2__1
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
    // InternalModelDraw.g:1697:1: rule__Node__Group_3_2_2__0__Impl : ( ',' ) ;
    public final void rule__Node__Group_3_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1701:1: ( ( ',' ) )
            // InternalModelDraw.g:1702:1: ( ',' )
            {
            // InternalModelDraw.g:1702:1: ( ',' )
            // InternalModelDraw.g:1703:2: ','
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
    // InternalModelDraw.g:1712:1: rule__Node__Group_3_2_2__1 : rule__Node__Group_3_2_2__1__Impl ;
    public final void rule__Node__Group_3_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1716:1: ( rule__Node__Group_3_2_2__1__Impl )
            // InternalModelDraw.g:1717:2: rule__Node__Group_3_2_2__1__Impl
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
    // InternalModelDraw.g:1723:1: rule__Node__Group_3_2_2__1__Impl : ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) ) ;
    public final void rule__Node__Group_3_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1727:1: ( ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) ) )
            // InternalModelDraw.g:1728:1: ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) )
            {
            // InternalModelDraw.g:1728:1: ( ( rule__Node__TargetFeatureAssignment_3_2_2_1 ) )
            // InternalModelDraw.g:1729:2: ( rule__Node__TargetFeatureAssignment_3_2_2_1 )
            {
             before(grammarAccess.getNodeAccess().getTargetFeatureAssignment_3_2_2_1()); 
            // InternalModelDraw.g:1730:2: ( rule__Node__TargetFeatureAssignment_3_2_2_1 )
            // InternalModelDraw.g:1730:3: rule__Node__TargetFeatureAssignment_3_2_2_1
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
    // InternalModelDraw.g:1739:1: rule__Node__Group_6__0 : rule__Node__Group_6__0__Impl rule__Node__Group_6__1 ;
    public final void rule__Node__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1743:1: ( rule__Node__Group_6__0__Impl rule__Node__Group_6__1 )
            // InternalModelDraw.g:1744:2: rule__Node__Group_6__0__Impl rule__Node__Group_6__1
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
    // InternalModelDraw.g:1751:1: rule__Node__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Node__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1755:1: ( ( '=' ) )
            // InternalModelDraw.g:1756:1: ( '=' )
            {
            // InternalModelDraw.g:1756:1: ( '=' )
            // InternalModelDraw.g:1757:2: '='
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
    // InternalModelDraw.g:1766:1: rule__Node__Group_6__1 : rule__Node__Group_6__1__Impl ;
    public final void rule__Node__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1770:1: ( rule__Node__Group_6__1__Impl )
            // InternalModelDraw.g:1771:2: rule__Node__Group_6__1__Impl
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
    // InternalModelDraw.g:1777:1: rule__Node__Group_6__1__Impl : ( ( rule__Node__AttNameAssignment_6_1 ) ) ;
    public final void rule__Node__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1781:1: ( ( ( rule__Node__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:1782:1: ( ( rule__Node__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:1782:1: ( ( rule__Node__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:1783:2: ( rule__Node__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getNodeAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:1784:2: ( rule__Node__AttNameAssignment_6_1 )
            // InternalModelDraw.g:1784:3: rule__Node__AttNameAssignment_6_1
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
    // InternalModelDraw.g:1793:1: rule__Node__Group_7__0 : rule__Node__Group_7__0__Impl rule__Node__Group_7__1 ;
    public final void rule__Node__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1797:1: ( rule__Node__Group_7__0__Impl rule__Node__Group_7__1 )
            // InternalModelDraw.g:1798:2: rule__Node__Group_7__0__Impl rule__Node__Group_7__1
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
    // InternalModelDraw.g:1805:1: rule__Node__Group_7__0__Impl : ( 'compartments' ) ;
    public final void rule__Node__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1809:1: ( ( 'compartments' ) )
            // InternalModelDraw.g:1810:1: ( 'compartments' )
            {
            // InternalModelDraw.g:1810:1: ( 'compartments' )
            // InternalModelDraw.g:1811:2: 'compartments'
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
    // InternalModelDraw.g:1820:1: rule__Node__Group_7__1 : rule__Node__Group_7__1__Impl rule__Node__Group_7__2 ;
    public final void rule__Node__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1824:1: ( rule__Node__Group_7__1__Impl rule__Node__Group_7__2 )
            // InternalModelDraw.g:1825:2: rule__Node__Group_7__1__Impl rule__Node__Group_7__2
            {
            pushFollow(FOLLOW_9);
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
    // InternalModelDraw.g:1832:1: rule__Node__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1836:1: ( ( '=' ) )
            // InternalModelDraw.g:1837:1: ( '=' )
            {
            // InternalModelDraw.g:1837:1: ( '=' )
            // InternalModelDraw.g:1838:2: '='
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
    // InternalModelDraw.g:1847:1: rule__Node__Group_7__2 : rule__Node__Group_7__2__Impl rule__Node__Group_7__3 ;
    public final void rule__Node__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1851:1: ( rule__Node__Group_7__2__Impl rule__Node__Group_7__3 )
            // InternalModelDraw.g:1852:2: rule__Node__Group_7__2__Impl rule__Node__Group_7__3
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
    // InternalModelDraw.g:1859:1: rule__Node__Group_7__2__Impl : ( '{' ) ;
    public final void rule__Node__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1863:1: ( ( '{' ) )
            // InternalModelDraw.g:1864:1: ( '{' )
            {
            // InternalModelDraw.g:1864:1: ( '{' )
            // InternalModelDraw.g:1865:2: '{'
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
    // InternalModelDraw.g:1874:1: rule__Node__Group_7__3 : rule__Node__Group_7__3__Impl rule__Node__Group_7__4 ;
    public final void rule__Node__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1878:1: ( rule__Node__Group_7__3__Impl rule__Node__Group_7__4 )
            // InternalModelDraw.g:1879:2: rule__Node__Group_7__3__Impl rule__Node__Group_7__4
            {
            pushFollow(FOLLOW_10);
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
    // InternalModelDraw.g:1886:1: rule__Node__Group_7__3__Impl : ( ( rule__Node__ReferenceAssignment_7_3 ) ) ;
    public final void rule__Node__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1890:1: ( ( ( rule__Node__ReferenceAssignment_7_3 ) ) )
            // InternalModelDraw.g:1891:1: ( ( rule__Node__ReferenceAssignment_7_3 ) )
            {
            // InternalModelDraw.g:1891:1: ( ( rule__Node__ReferenceAssignment_7_3 ) )
            // InternalModelDraw.g:1892:2: ( rule__Node__ReferenceAssignment_7_3 )
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_7_3()); 
            // InternalModelDraw.g:1893:2: ( rule__Node__ReferenceAssignment_7_3 )
            // InternalModelDraw.g:1893:3: rule__Node__ReferenceAssignment_7_3
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
    // InternalModelDraw.g:1901:1: rule__Node__Group_7__4 : rule__Node__Group_7__4__Impl rule__Node__Group_7__5 ;
    public final void rule__Node__Group_7__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1905:1: ( rule__Node__Group_7__4__Impl rule__Node__Group_7__5 )
            // InternalModelDraw.g:1906:2: rule__Node__Group_7__4__Impl rule__Node__Group_7__5
            {
            pushFollow(FOLLOW_10);
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
    // InternalModelDraw.g:1913:1: rule__Node__Group_7__4__Impl : ( ( rule__Node__ReferenceAssignment_7_4 )* ) ;
    public final void rule__Node__Group_7__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1917:1: ( ( ( rule__Node__ReferenceAssignment_7_4 )* ) )
            // InternalModelDraw.g:1918:1: ( ( rule__Node__ReferenceAssignment_7_4 )* )
            {
            // InternalModelDraw.g:1918:1: ( ( rule__Node__ReferenceAssignment_7_4 )* )
            // InternalModelDraw.g:1919:2: ( rule__Node__ReferenceAssignment_7_4 )*
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_7_4()); 
            // InternalModelDraw.g:1920:2: ( rule__Node__ReferenceAssignment_7_4 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalModelDraw.g:1920:3: rule__Node__ReferenceAssignment_7_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Node__ReferenceAssignment_7_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // InternalModelDraw.g:1928:1: rule__Node__Group_7__5 : rule__Node__Group_7__5__Impl ;
    public final void rule__Node__Group_7__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1932:1: ( rule__Node__Group_7__5__Impl )
            // InternalModelDraw.g:1933:2: rule__Node__Group_7__5__Impl
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
    // InternalModelDraw.g:1939:1: rule__Node__Group_7__5__Impl : ( '}' ) ;
    public final void rule__Node__Group_7__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1943:1: ( ( '}' ) )
            // InternalModelDraw.g:1944:1: ( '}' )
            {
            // InternalModelDraw.g:1944:1: ( '}' )
            // InternalModelDraw.g:1945:2: '}'
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
    // InternalModelDraw.g:1955:1: rule__Node__Group_8__0 : rule__Node__Group_8__0__Impl rule__Node__Group_8__1 ;
    public final void rule__Node__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1959:1: ( rule__Node__Group_8__0__Impl rule__Node__Group_8__1 )
            // InternalModelDraw.g:1960:2: rule__Node__Group_8__0__Impl rule__Node__Group_8__1
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
    // InternalModelDraw.g:1967:1: rule__Node__Group_8__0__Impl : ( 'shape' ) ;
    public final void rule__Node__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1971:1: ( ( 'shape' ) )
            // InternalModelDraw.g:1972:1: ( 'shape' )
            {
            // InternalModelDraw.g:1972:1: ( 'shape' )
            // InternalModelDraw.g:1973:2: 'shape'
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
    // InternalModelDraw.g:1982:1: rule__Node__Group_8__1 : rule__Node__Group_8__1__Impl rule__Node__Group_8__2 ;
    public final void rule__Node__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1986:1: ( rule__Node__Group_8__1__Impl rule__Node__Group_8__2 )
            // InternalModelDraw.g:1987:2: rule__Node__Group_8__1__Impl rule__Node__Group_8__2
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
    // InternalModelDraw.g:1994:1: rule__Node__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1998:1: ( ( '=' ) )
            // InternalModelDraw.g:1999:1: ( '=' )
            {
            // InternalModelDraw.g:1999:1: ( '=' )
            // InternalModelDraw.g:2000:2: '='
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
    // InternalModelDraw.g:2009:1: rule__Node__Group_8__2 : rule__Node__Group_8__2__Impl rule__Node__Group_8__3 ;
    public final void rule__Node__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2013:1: ( rule__Node__Group_8__2__Impl rule__Node__Group_8__3 )
            // InternalModelDraw.g:2014:2: rule__Node__Group_8__2__Impl rule__Node__Group_8__3
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
    // InternalModelDraw.g:2021:1: rule__Node__Group_8__2__Impl : ( ( rule__Node__ShapeAssignment_8_2 ) ) ;
    public final void rule__Node__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2025:1: ( ( ( rule__Node__ShapeAssignment_8_2 ) ) )
            // InternalModelDraw.g:2026:1: ( ( rule__Node__ShapeAssignment_8_2 ) )
            {
            // InternalModelDraw.g:2026:1: ( ( rule__Node__ShapeAssignment_8_2 ) )
            // InternalModelDraw.g:2027:2: ( rule__Node__ShapeAssignment_8_2 )
            {
             before(grammarAccess.getNodeAccess().getShapeAssignment_8_2()); 
            // InternalModelDraw.g:2028:2: ( rule__Node__ShapeAssignment_8_2 )
            // InternalModelDraw.g:2028:3: rule__Node__ShapeAssignment_8_2
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
    // InternalModelDraw.g:2036:1: rule__Node__Group_8__3 : rule__Node__Group_8__3__Impl ;
    public final void rule__Node__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2040:1: ( rule__Node__Group_8__3__Impl )
            // InternalModelDraw.g:2041:2: rule__Node__Group_8__3__Impl
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
    // InternalModelDraw.g:2047:1: rule__Node__Group_8__3__Impl : ( ( rule__Node__Group_8_3__0 )? ) ;
    public final void rule__Node__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2051:1: ( ( ( rule__Node__Group_8_3__0 )? ) )
            // InternalModelDraw.g:2052:1: ( ( rule__Node__Group_8_3__0 )? )
            {
            // InternalModelDraw.g:2052:1: ( ( rule__Node__Group_8_3__0 )? )
            // InternalModelDraw.g:2053:2: ( rule__Node__Group_8_3__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_8_3()); 
            // InternalModelDraw.g:2054:2: ( rule__Node__Group_8_3__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==32) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalModelDraw.g:2054:3: rule__Node__Group_8_3__0
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
    // InternalModelDraw.g:2063:1: rule__Node__Group_8_3__0 : rule__Node__Group_8_3__0__Impl rule__Node__Group_8_3__1 ;
    public final void rule__Node__Group_8_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2067:1: ( rule__Node__Group_8_3__0__Impl rule__Node__Group_8_3__1 )
            // InternalModelDraw.g:2068:2: rule__Node__Group_8_3__0__Impl rule__Node__Group_8_3__1
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
    // InternalModelDraw.g:2075:1: rule__Node__Group_8_3__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_8_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2079:1: ( ( '(' ) )
            // InternalModelDraw.g:2080:1: ( '(' )
            {
            // InternalModelDraw.g:2080:1: ( '(' )
            // InternalModelDraw.g:2081:2: '('
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
    // InternalModelDraw.g:2090:1: rule__Node__Group_8_3__1 : rule__Node__Group_8_3__1__Impl rule__Node__Group_8_3__2 ;
    public final void rule__Node__Group_8_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2094:1: ( rule__Node__Group_8_3__1__Impl rule__Node__Group_8_3__2 )
            // InternalModelDraw.g:2095:2: rule__Node__Group_8_3__1__Impl rule__Node__Group_8_3__2
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
    // InternalModelDraw.g:2102:1: rule__Node__Group_8_3__1__Impl : ( ( rule__Node__PathShapeAssignment_8_3_1 ) ) ;
    public final void rule__Node__Group_8_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2106:1: ( ( ( rule__Node__PathShapeAssignment_8_3_1 ) ) )
            // InternalModelDraw.g:2107:1: ( ( rule__Node__PathShapeAssignment_8_3_1 ) )
            {
            // InternalModelDraw.g:2107:1: ( ( rule__Node__PathShapeAssignment_8_3_1 ) )
            // InternalModelDraw.g:2108:2: ( rule__Node__PathShapeAssignment_8_3_1 )
            {
             before(grammarAccess.getNodeAccess().getPathShapeAssignment_8_3_1()); 
            // InternalModelDraw.g:2109:2: ( rule__Node__PathShapeAssignment_8_3_1 )
            // InternalModelDraw.g:2109:3: rule__Node__PathShapeAssignment_8_3_1
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
    // InternalModelDraw.g:2117:1: rule__Node__Group_8_3__2 : rule__Node__Group_8_3__2__Impl ;
    public final void rule__Node__Group_8_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2121:1: ( rule__Node__Group_8_3__2__Impl )
            // InternalModelDraw.g:2122:2: rule__Node__Group_8_3__2__Impl
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
    // InternalModelDraw.g:2128:1: rule__Node__Group_8_3__2__Impl : ( ')' ) ;
    public final void rule__Node__Group_8_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2132:1: ( ( ')' ) )
            // InternalModelDraw.g:2133:1: ( ')' )
            {
            // InternalModelDraw.g:2133:1: ( ')' )
            // InternalModelDraw.g:2134:2: ')'
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
    // InternalModelDraw.g:2144:1: rule__Node__Group_9__0 : rule__Node__Group_9__0__Impl rule__Node__Group_9__1 ;
    public final void rule__Node__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2148:1: ( rule__Node__Group_9__0__Impl rule__Node__Group_9__1 )
            // InternalModelDraw.g:2149:2: rule__Node__Group_9__0__Impl rule__Node__Group_9__1
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
    // InternalModelDraw.g:2156:1: rule__Node__Group_9__0__Impl : ( 'color' ) ;
    public final void rule__Node__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2160:1: ( ( 'color' ) )
            // InternalModelDraw.g:2161:1: ( 'color' )
            {
            // InternalModelDraw.g:2161:1: ( 'color' )
            // InternalModelDraw.g:2162:2: 'color'
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
    // InternalModelDraw.g:2171:1: rule__Node__Group_9__1 : rule__Node__Group_9__1__Impl rule__Node__Group_9__2 ;
    public final void rule__Node__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2175:1: ( rule__Node__Group_9__1__Impl rule__Node__Group_9__2 )
            // InternalModelDraw.g:2176:2: rule__Node__Group_9__1__Impl rule__Node__Group_9__2
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
    // InternalModelDraw.g:2183:1: rule__Node__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2187:1: ( ( '=' ) )
            // InternalModelDraw.g:2188:1: ( '=' )
            {
            // InternalModelDraw.g:2188:1: ( '=' )
            // InternalModelDraw.g:2189:2: '='
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
    // InternalModelDraw.g:2198:1: rule__Node__Group_9__2 : rule__Node__Group_9__2__Impl ;
    public final void rule__Node__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2202:1: ( rule__Node__Group_9__2__Impl )
            // InternalModelDraw.g:2203:2: rule__Node__Group_9__2__Impl
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
    // InternalModelDraw.g:2209:1: rule__Node__Group_9__2__Impl : ( ( rule__Node__ColorAssignment_9_2 ) ) ;
    public final void rule__Node__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2213:1: ( ( ( rule__Node__ColorAssignment_9_2 ) ) )
            // InternalModelDraw.g:2214:1: ( ( rule__Node__ColorAssignment_9_2 ) )
            {
            // InternalModelDraw.g:2214:1: ( ( rule__Node__ColorAssignment_9_2 ) )
            // InternalModelDraw.g:2215:2: ( rule__Node__ColorAssignment_9_2 )
            {
             before(grammarAccess.getNodeAccess().getColorAssignment_9_2()); 
            // InternalModelDraw.g:2216:2: ( rule__Node__ColorAssignment_9_2 )
            // InternalModelDraw.g:2216:3: rule__Node__ColorAssignment_9_2
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
    // InternalModelDraw.g:2225:1: rule__Node__Group_10__0 : rule__Node__Group_10__0__Impl rule__Node__Group_10__1 ;
    public final void rule__Node__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2229:1: ( rule__Node__Group_10__0__Impl rule__Node__Group_10__1 )
            // InternalModelDraw.g:2230:2: rule__Node__Group_10__0__Impl rule__Node__Group_10__1
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
    // InternalModelDraw.g:2237:1: rule__Node__Group_10__0__Impl : ( 'style' ) ;
    public final void rule__Node__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2241:1: ( ( 'style' ) )
            // InternalModelDraw.g:2242:1: ( 'style' )
            {
            // InternalModelDraw.g:2242:1: ( 'style' )
            // InternalModelDraw.g:2243:2: 'style'
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
    // InternalModelDraw.g:2252:1: rule__Node__Group_10__1 : rule__Node__Group_10__1__Impl rule__Node__Group_10__2 ;
    public final void rule__Node__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2256:1: ( rule__Node__Group_10__1__Impl rule__Node__Group_10__2 )
            // InternalModelDraw.g:2257:2: rule__Node__Group_10__1__Impl rule__Node__Group_10__2
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
    // InternalModelDraw.g:2264:1: rule__Node__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2268:1: ( ( '=' ) )
            // InternalModelDraw.g:2269:1: ( '=' )
            {
            // InternalModelDraw.g:2269:1: ( '=' )
            // InternalModelDraw.g:2270:2: '='
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
    // InternalModelDraw.g:2279:1: rule__Node__Group_10__2 : rule__Node__Group_10__2__Impl ;
    public final void rule__Node__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2283:1: ( rule__Node__Group_10__2__Impl )
            // InternalModelDraw.g:2284:2: rule__Node__Group_10__2__Impl
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
    // InternalModelDraw.g:2290:1: rule__Node__Group_10__2__Impl : ( ( rule__Node__StyleAssignment_10_2 ) ) ;
    public final void rule__Node__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2294:1: ( ( ( rule__Node__StyleAssignment_10_2 ) ) )
            // InternalModelDraw.g:2295:1: ( ( rule__Node__StyleAssignment_10_2 ) )
            {
            // InternalModelDraw.g:2295:1: ( ( rule__Node__StyleAssignment_10_2 ) )
            // InternalModelDraw.g:2296:2: ( rule__Node__StyleAssignment_10_2 )
            {
             before(grammarAccess.getNodeAccess().getStyleAssignment_10_2()); 
            // InternalModelDraw.g:2297:2: ( rule__Node__StyleAssignment_10_2 )
            // InternalModelDraw.g:2297:3: rule__Node__StyleAssignment_10_2
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
    // InternalModelDraw.g:2306:1: rule__ValuedFeature__Group__0 : rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 ;
    public final void rule__ValuedFeature__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2310:1: ( rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1 )
            // InternalModelDraw.g:2311:2: rule__ValuedFeature__Group__0__Impl rule__ValuedFeature__Group__1
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
    // InternalModelDraw.g:2318:1: rule__ValuedFeature__Group__0__Impl : ( () ) ;
    public final void rule__ValuedFeature__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2322:1: ( ( () ) )
            // InternalModelDraw.g:2323:1: ( () )
            {
            // InternalModelDraw.g:2323:1: ( () )
            // InternalModelDraw.g:2324:2: ()
            {
             before(grammarAccess.getValuedFeatureAccess().getValuedFeatureAction_0()); 
            // InternalModelDraw.g:2325:2: ()
            // InternalModelDraw.g:2325:3: 
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
    // InternalModelDraw.g:2333:1: rule__ValuedFeature__Group__1 : rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 ;
    public final void rule__ValuedFeature__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2337:1: ( rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2 )
            // InternalModelDraw.g:2338:2: rule__ValuedFeature__Group__1__Impl rule__ValuedFeature__Group__2
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
    // InternalModelDraw.g:2345:1: rule__ValuedFeature__Group__1__Impl : ( ( rule__ValuedFeature__NegationAssignment_1 )? ) ;
    public final void rule__ValuedFeature__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2349:1: ( ( ( rule__ValuedFeature__NegationAssignment_1 )? ) )
            // InternalModelDraw.g:2350:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            {
            // InternalModelDraw.g:2350:1: ( ( rule__ValuedFeature__NegationAssignment_1 )? )
            // InternalModelDraw.g:2351:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationAssignment_1()); 
            // InternalModelDraw.g:2352:2: ( rule__ValuedFeature__NegationAssignment_1 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==52) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalModelDraw.g:2352:3: rule__ValuedFeature__NegationAssignment_1
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
    // InternalModelDraw.g:2360:1: rule__ValuedFeature__Group__2 : rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 ;
    public final void rule__ValuedFeature__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2364:1: ( rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3 )
            // InternalModelDraw.g:2365:2: rule__ValuedFeature__Group__2__Impl rule__ValuedFeature__Group__3
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
    // InternalModelDraw.g:2372:1: rule__ValuedFeature__Group__2__Impl : ( ( rule__ValuedFeature__FeatAssignment_2 ) ) ;
    public final void rule__ValuedFeature__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2376:1: ( ( ( rule__ValuedFeature__FeatAssignment_2 ) ) )
            // InternalModelDraw.g:2377:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            {
            // InternalModelDraw.g:2377:1: ( ( rule__ValuedFeature__FeatAssignment_2 ) )
            // InternalModelDraw.g:2378:2: ( rule__ValuedFeature__FeatAssignment_2 )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatAssignment_2()); 
            // InternalModelDraw.g:2379:2: ( rule__ValuedFeature__FeatAssignment_2 )
            // InternalModelDraw.g:2379:3: rule__ValuedFeature__FeatAssignment_2
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
    // InternalModelDraw.g:2387:1: rule__ValuedFeature__Group__3 : rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 ;
    public final void rule__ValuedFeature__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2391:1: ( rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4 )
            // InternalModelDraw.g:2392:2: rule__ValuedFeature__Group__3__Impl rule__ValuedFeature__Group__4
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
    // InternalModelDraw.g:2399:1: rule__ValuedFeature__Group__3__Impl : ( ( rule__ValuedFeature__Group_3__0 )? ) ;
    public final void rule__ValuedFeature__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2403:1: ( ( ( rule__ValuedFeature__Group_3__0 )? ) )
            // InternalModelDraw.g:2404:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            {
            // InternalModelDraw.g:2404:1: ( ( rule__ValuedFeature__Group_3__0 )? )
            // InternalModelDraw.g:2405:2: ( rule__ValuedFeature__Group_3__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_3()); 
            // InternalModelDraw.g:2406:2: ( rule__ValuedFeature__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==35) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalModelDraw.g:2406:3: rule__ValuedFeature__Group_3__0
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
    // InternalModelDraw.g:2414:1: rule__ValuedFeature__Group__4 : rule__ValuedFeature__Group__4__Impl ;
    public final void rule__ValuedFeature__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2418:1: ( rule__ValuedFeature__Group__4__Impl )
            // InternalModelDraw.g:2419:2: rule__ValuedFeature__Group__4__Impl
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
    // InternalModelDraw.g:2425:1: rule__ValuedFeature__Group__4__Impl : ( ( rule__ValuedFeature__Group_4__0 )? ) ;
    public final void rule__ValuedFeature__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2429:1: ( ( ( rule__ValuedFeature__Group_4__0 )? ) )
            // InternalModelDraw.g:2430:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            {
            // InternalModelDraw.g:2430:1: ( ( rule__ValuedFeature__Group_4__0 )? )
            // InternalModelDraw.g:2431:2: ( rule__ValuedFeature__Group_4__0 )?
            {
             before(grammarAccess.getValuedFeatureAccess().getGroup_4()); 
            // InternalModelDraw.g:2432:2: ( rule__ValuedFeature__Group_4__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==41) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalModelDraw.g:2432:3: rule__ValuedFeature__Group_4__0
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
    // InternalModelDraw.g:2441:1: rule__ValuedFeature__Group_3__0 : rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 ;
    public final void rule__ValuedFeature__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2445:1: ( rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1 )
            // InternalModelDraw.g:2446:2: rule__ValuedFeature__Group_3__0__Impl rule__ValuedFeature__Group_3__1
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
    // InternalModelDraw.g:2453:1: rule__ValuedFeature__Group_3__0__Impl : ( '->' ) ;
    public final void rule__ValuedFeature__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2457:1: ( ( '->' ) )
            // InternalModelDraw.g:2458:1: ( '->' )
            {
            // InternalModelDraw.g:2458:1: ( '->' )
            // InternalModelDraw.g:2459:2: '->'
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
    // InternalModelDraw.g:2468:1: rule__ValuedFeature__Group_3__1 : rule__ValuedFeature__Group_3__1__Impl ;
    public final void rule__ValuedFeature__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2472:1: ( rule__ValuedFeature__Group_3__1__Impl )
            // InternalModelDraw.g:2473:2: rule__ValuedFeature__Group_3__1__Impl
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
    // InternalModelDraw.g:2479:1: rule__ValuedFeature__Group_3__1__Impl : ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) ;
    public final void rule__ValuedFeature__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2483:1: ( ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) ) )
            // InternalModelDraw.g:2484:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            {
            // InternalModelDraw.g:2484:1: ( ( rule__ValuedFeature__RefFeatureAssignment_3_1 ) )
            // InternalModelDraw.g:2485:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureAssignment_3_1()); 
            // InternalModelDraw.g:2486:2: ( rule__ValuedFeature__RefFeatureAssignment_3_1 )
            // InternalModelDraw.g:2486:3: rule__ValuedFeature__RefFeatureAssignment_3_1
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
    // InternalModelDraw.g:2495:1: rule__ValuedFeature__Group_4__0 : rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 ;
    public final void rule__ValuedFeature__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2499:1: ( rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1 )
            // InternalModelDraw.g:2500:2: rule__ValuedFeature__Group_4__0__Impl rule__ValuedFeature__Group_4__1
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
    // InternalModelDraw.g:2507:1: rule__ValuedFeature__Group_4__0__Impl : ( '==' ) ;
    public final void rule__ValuedFeature__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2511:1: ( ( '==' ) )
            // InternalModelDraw.g:2512:1: ( '==' )
            {
            // InternalModelDraw.g:2512:1: ( '==' )
            // InternalModelDraw.g:2513:2: '=='
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
    // InternalModelDraw.g:2522:1: rule__ValuedFeature__Group_4__1 : rule__ValuedFeature__Group_4__1__Impl ;
    public final void rule__ValuedFeature__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2526:1: ( rule__ValuedFeature__Group_4__1__Impl )
            // InternalModelDraw.g:2527:2: rule__ValuedFeature__Group_4__1__Impl
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
    // InternalModelDraw.g:2533:1: rule__ValuedFeature__Group_4__1__Impl : ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) ;
    public final void rule__ValuedFeature__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2537:1: ( ( ( rule__ValuedFeature__ValueAssignment_4_1 ) ) )
            // InternalModelDraw.g:2538:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            {
            // InternalModelDraw.g:2538:1: ( ( rule__ValuedFeature__ValueAssignment_4_1 ) )
            // InternalModelDraw.g:2539:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueAssignment_4_1()); 
            // InternalModelDraw.g:2540:2: ( rule__ValuedFeature__ValueAssignment_4_1 )
            // InternalModelDraw.g:2540:3: rule__ValuedFeature__ValueAssignment_4_1
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
    // InternalModelDraw.g:2549:1: rule__Edge__Group__0 : rule__Edge__Group__0__Impl rule__Edge__Group__1 ;
    public final void rule__Edge__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2553:1: ( rule__Edge__Group__0__Impl rule__Edge__Group__1 )
            // InternalModelDraw.g:2554:2: rule__Edge__Group__0__Impl rule__Edge__Group__1
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
    // InternalModelDraw.g:2561:1: rule__Edge__Group__0__Impl : ( () ) ;
    public final void rule__Edge__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2565:1: ( ( () ) )
            // InternalModelDraw.g:2566:1: ( () )
            {
            // InternalModelDraw.g:2566:1: ( () )
            // InternalModelDraw.g:2567:2: ()
            {
             before(grammarAccess.getEdgeAccess().getEdgeAction_0()); 
            // InternalModelDraw.g:2568:2: ()
            // InternalModelDraw.g:2568:3: 
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
    // InternalModelDraw.g:2576:1: rule__Edge__Group__1 : rule__Edge__Group__1__Impl rule__Edge__Group__2 ;
    public final void rule__Edge__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2580:1: ( rule__Edge__Group__1__Impl rule__Edge__Group__2 )
            // InternalModelDraw.g:2581:2: rule__Edge__Group__1__Impl rule__Edge__Group__2
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
    // InternalModelDraw.g:2588:1: rule__Edge__Group__1__Impl : ( ( rule__Edge__NameAssignment_1 ) ) ;
    public final void rule__Edge__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2592:1: ( ( ( rule__Edge__NameAssignment_1 ) ) )
            // InternalModelDraw.g:2593:1: ( ( rule__Edge__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:2593:1: ( ( rule__Edge__NameAssignment_1 ) )
            // InternalModelDraw.g:2594:2: ( rule__Edge__NameAssignment_1 )
            {
             before(grammarAccess.getEdgeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:2595:2: ( rule__Edge__NameAssignment_1 )
            // InternalModelDraw.g:2595:3: rule__Edge__NameAssignment_1
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
    // InternalModelDraw.g:2603:1: rule__Edge__Group__2 : rule__Edge__Group__2__Impl rule__Edge__Group__3 ;
    public final void rule__Edge__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2607:1: ( rule__Edge__Group__2__Impl rule__Edge__Group__3 )
            // InternalModelDraw.g:2608:2: rule__Edge__Group__2__Impl rule__Edge__Group__3
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
    // InternalModelDraw.g:2615:1: rule__Edge__Group__2__Impl : ( ( rule__Edge__Group_2__0 )? ) ;
    public final void rule__Edge__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2619:1: ( ( ( rule__Edge__Group_2__0 )? ) )
            // InternalModelDraw.g:2620:1: ( ( rule__Edge__Group_2__0 )? )
            {
            // InternalModelDraw.g:2620:1: ( ( rule__Edge__Group_2__0 )? )
            // InternalModelDraw.g:2621:2: ( rule__Edge__Group_2__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_2()); 
            // InternalModelDraw.g:2622:2: ( rule__Edge__Group_2__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==32) ) {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==52) ) {
                    alt29=1;
                }
                else if ( (LA29_1==RULE_ID) ) {
                    switch ( input.LA(3) ) {
                        case 34:
                            {
                            int LA29_5 = input.LA(4);

                            if ( (LA29_5==RULE_ID) ) {
                                int LA29_7 = input.LA(5);

                                if ( (LA29_7==33) ) {
                                    int LA29_6 = input.LA(6);

                                    if ( (LA29_6==32||LA29_6==35) ) {
                                        alt29=1;
                                    }
                                }
                                else if ( ((LA29_7>=34 && LA29_7<=35)||LA29_7==41) ) {
                                    alt29=1;
                                }
                            }
                            else if ( (LA29_5==52) ) {
                                alt29=1;
                            }
                            }
                            break;
                        case 33:
                            {
                            int LA29_6 = input.LA(4);

                            if ( (LA29_6==32||LA29_6==35) ) {
                                alt29=1;
                            }
                            }
                            break;
                        case 35:
                        case 41:
                            {
                            alt29=1;
                            }
                            break;
                    }

                }
            }
            switch (alt29) {
                case 1 :
                    // InternalModelDraw.g:2622:3: rule__Edge__Group_2__0
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
    // InternalModelDraw.g:2630:1: rule__Edge__Group__3 : rule__Edge__Group__3__Impl rule__Edge__Group__4 ;
    public final void rule__Edge__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2634:1: ( rule__Edge__Group__3__Impl rule__Edge__Group__4 )
            // InternalModelDraw.g:2635:2: rule__Edge__Group__3__Impl rule__Edge__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalModelDraw.g:2642:1: rule__Edge__Group__3__Impl : ( ( rule__Edge__Alternatives_3 ) ) ;
    public final void rule__Edge__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2646:1: ( ( ( rule__Edge__Alternatives_3 ) ) )
            // InternalModelDraw.g:2647:1: ( ( rule__Edge__Alternatives_3 ) )
            {
            // InternalModelDraw.g:2647:1: ( ( rule__Edge__Alternatives_3 ) )
            // InternalModelDraw.g:2648:2: ( rule__Edge__Alternatives_3 )
            {
             before(grammarAccess.getEdgeAccess().getAlternatives_3()); 
            // InternalModelDraw.g:2649:2: ( rule__Edge__Alternatives_3 )
            // InternalModelDraw.g:2649:3: rule__Edge__Alternatives_3
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
    // InternalModelDraw.g:2657:1: rule__Edge__Group__4 : rule__Edge__Group__4__Impl rule__Edge__Group__5 ;
    public final void rule__Edge__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2661:1: ( rule__Edge__Group__4__Impl rule__Edge__Group__5 )
            // InternalModelDraw.g:2662:2: rule__Edge__Group__4__Impl rule__Edge__Group__5
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
    // InternalModelDraw.g:2669:1: rule__Edge__Group__4__Impl : ( ':' ) ;
    public final void rule__Edge__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2673:1: ( ( ':' ) )
            // InternalModelDraw.g:2674:1: ( ':' )
            {
            // InternalModelDraw.g:2674:1: ( ':' )
            // InternalModelDraw.g:2675:2: ':'
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
    // InternalModelDraw.g:2684:1: rule__Edge__Group__5 : rule__Edge__Group__5__Impl rule__Edge__Group__6 ;
    public final void rule__Edge__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2688:1: ( rule__Edge__Group__5__Impl rule__Edge__Group__6 )
            // InternalModelDraw.g:2689:2: rule__Edge__Group__5__Impl rule__Edge__Group__6
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
    // InternalModelDraw.g:2696:1: rule__Edge__Group__5__Impl : ( 'edge' ) ;
    public final void rule__Edge__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2700:1: ( ( 'edge' ) )
            // InternalModelDraw.g:2701:1: ( 'edge' )
            {
            // InternalModelDraw.g:2701:1: ( 'edge' )
            // InternalModelDraw.g:2702:2: 'edge'
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
    // InternalModelDraw.g:2711:1: rule__Edge__Group__6 : rule__Edge__Group__6__Impl rule__Edge__Group__7 ;
    public final void rule__Edge__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2715:1: ( rule__Edge__Group__6__Impl rule__Edge__Group__7 )
            // InternalModelDraw.g:2716:2: rule__Edge__Group__6__Impl rule__Edge__Group__7
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
    // InternalModelDraw.g:2723:1: rule__Edge__Group__6__Impl : ( ( rule__Edge__Group_6__0 )? ) ;
    public final void rule__Edge__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2727:1: ( ( ( rule__Edge__Group_6__0 )? ) )
            // InternalModelDraw.g:2728:1: ( ( rule__Edge__Group_6__0 )? )
            {
            // InternalModelDraw.g:2728:1: ( ( rule__Edge__Group_6__0 )? )
            // InternalModelDraw.g:2729:2: ( rule__Edge__Group_6__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_6()); 
            // InternalModelDraw.g:2730:2: ( rule__Edge__Group_6__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==36) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalModelDraw.g:2730:3: rule__Edge__Group_6__0
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
    // InternalModelDraw.g:2738:1: rule__Edge__Group__7 : rule__Edge__Group__7__Impl rule__Edge__Group__8 ;
    public final void rule__Edge__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2742:1: ( rule__Edge__Group__7__Impl rule__Edge__Group__8 )
            // InternalModelDraw.g:2743:2: rule__Edge__Group__7__Impl rule__Edge__Group__8
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
    // InternalModelDraw.g:2750:1: rule__Edge__Group__7__Impl : ( ( rule__Edge__Group_7__0 )? ) ;
    public final void rule__Edge__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2754:1: ( ( ( rule__Edge__Group_7__0 )? ) )
            // InternalModelDraw.g:2755:1: ( ( rule__Edge__Group_7__0 )? )
            {
            // InternalModelDraw.g:2755:1: ( ( rule__Edge__Group_7__0 )? )
            // InternalModelDraw.g:2756:2: ( rule__Edge__Group_7__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7()); 
            // InternalModelDraw.g:2757:2: ( rule__Edge__Group_7__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalModelDraw.g:2757:3: rule__Edge__Group_7__0
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
    // InternalModelDraw.g:2765:1: rule__Edge__Group__8 : rule__Edge__Group__8__Impl rule__Edge__Group__9 ;
    public final void rule__Edge__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2769:1: ( rule__Edge__Group__8__Impl rule__Edge__Group__9 )
            // InternalModelDraw.g:2770:2: rule__Edge__Group__8__Impl rule__Edge__Group__9
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
    // InternalModelDraw.g:2777:1: rule__Edge__Group__8__Impl : ( ( rule__Edge__Group_8__0 )? ) ;
    public final void rule__Edge__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2781:1: ( ( ( rule__Edge__Group_8__0 )? ) )
            // InternalModelDraw.g:2782:1: ( ( rule__Edge__Group_8__0 )? )
            {
            // InternalModelDraw.g:2782:1: ( ( rule__Edge__Group_8__0 )? )
            // InternalModelDraw.g:2783:2: ( rule__Edge__Group_8__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_8()); 
            // InternalModelDraw.g:2784:2: ( rule__Edge__Group_8__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==45) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalModelDraw.g:2784:3: rule__Edge__Group_8__0
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
    // InternalModelDraw.g:2792:1: rule__Edge__Group__9 : rule__Edge__Group__9__Impl rule__Edge__Group__10 ;
    public final void rule__Edge__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2796:1: ( rule__Edge__Group__9__Impl rule__Edge__Group__10 )
            // InternalModelDraw.g:2797:2: rule__Edge__Group__9__Impl rule__Edge__Group__10
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
    // InternalModelDraw.g:2804:1: rule__Edge__Group__9__Impl : ( ( rule__Edge__Group_9__0 )? ) ;
    public final void rule__Edge__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2808:1: ( ( ( rule__Edge__Group_9__0 )? ) )
            // InternalModelDraw.g:2809:1: ( ( rule__Edge__Group_9__0 )? )
            {
            // InternalModelDraw.g:2809:1: ( ( rule__Edge__Group_9__0 )? )
            // InternalModelDraw.g:2810:2: ( rule__Edge__Group_9__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_9()); 
            // InternalModelDraw.g:2811:2: ( rule__Edge__Group_9__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==46) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalModelDraw.g:2811:3: rule__Edge__Group_9__0
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
    // InternalModelDraw.g:2819:1: rule__Edge__Group__10 : rule__Edge__Group__10__Impl rule__Edge__Group__11 ;
    public final void rule__Edge__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2823:1: ( rule__Edge__Group__10__Impl rule__Edge__Group__11 )
            // InternalModelDraw.g:2824:2: rule__Edge__Group__10__Impl rule__Edge__Group__11
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
    // InternalModelDraw.g:2831:1: rule__Edge__Group__10__Impl : ( ( rule__Edge__Group_10__0 )? ) ;
    public final void rule__Edge__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2835:1: ( ( ( rule__Edge__Group_10__0 )? ) )
            // InternalModelDraw.g:2836:1: ( ( rule__Edge__Group_10__0 )? )
            {
            // InternalModelDraw.g:2836:1: ( ( rule__Edge__Group_10__0 )? )
            // InternalModelDraw.g:2837:2: ( rule__Edge__Group_10__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10()); 
            // InternalModelDraw.g:2838:2: ( rule__Edge__Group_10__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==47) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalModelDraw.g:2838:3: rule__Edge__Group_10__0
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
    // InternalModelDraw.g:2846:1: rule__Edge__Group__11 : rule__Edge__Group__11__Impl ;
    public final void rule__Edge__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2850:1: ( rule__Edge__Group__11__Impl )
            // InternalModelDraw.g:2851:2: rule__Edge__Group__11__Impl
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
    // InternalModelDraw.g:2857:1: rule__Edge__Group__11__Impl : ( ( rule__Edge__Group_11__0 )? ) ;
    public final void rule__Edge__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2861:1: ( ( ( rule__Edge__Group_11__0 )? ) )
            // InternalModelDraw.g:2862:1: ( ( rule__Edge__Group_11__0 )? )
            {
            // InternalModelDraw.g:2862:1: ( ( rule__Edge__Group_11__0 )? )
            // InternalModelDraw.g:2863:2: ( rule__Edge__Group_11__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_11()); 
            // InternalModelDraw.g:2864:2: ( rule__Edge__Group_11__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==48) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalModelDraw.g:2864:3: rule__Edge__Group_11__0
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
    // InternalModelDraw.g:2873:1: rule__Edge__Group_2__0 : rule__Edge__Group_2__0__Impl rule__Edge__Group_2__1 ;
    public final void rule__Edge__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2877:1: ( rule__Edge__Group_2__0__Impl rule__Edge__Group_2__1 )
            // InternalModelDraw.g:2878:2: rule__Edge__Group_2__0__Impl rule__Edge__Group_2__1
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
    // InternalModelDraw.g:2885:1: rule__Edge__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2889:1: ( ( '(' ) )
            // InternalModelDraw.g:2890:1: ( '(' )
            {
            // InternalModelDraw.g:2890:1: ( '(' )
            // InternalModelDraw.g:2891:2: '('
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
    // InternalModelDraw.g:2900:1: rule__Edge__Group_2__1 : rule__Edge__Group_2__1__Impl rule__Edge__Group_2__2 ;
    public final void rule__Edge__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2904:1: ( rule__Edge__Group_2__1__Impl rule__Edge__Group_2__2 )
            // InternalModelDraw.g:2905:2: rule__Edge__Group_2__1__Impl rule__Edge__Group_2__2
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
    // InternalModelDraw.g:2912:1: rule__Edge__Group_2__1__Impl : ( ( rule__Edge__FeatureAssignment_2_1 ) ) ;
    public final void rule__Edge__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2916:1: ( ( ( rule__Edge__FeatureAssignment_2_1 ) ) )
            // InternalModelDraw.g:2917:1: ( ( rule__Edge__FeatureAssignment_2_1 ) )
            {
            // InternalModelDraw.g:2917:1: ( ( rule__Edge__FeatureAssignment_2_1 ) )
            // InternalModelDraw.g:2918:2: ( rule__Edge__FeatureAssignment_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getFeatureAssignment_2_1()); 
            // InternalModelDraw.g:2919:2: ( rule__Edge__FeatureAssignment_2_1 )
            // InternalModelDraw.g:2919:3: rule__Edge__FeatureAssignment_2_1
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
    // InternalModelDraw.g:2927:1: rule__Edge__Group_2__2 : rule__Edge__Group_2__2__Impl rule__Edge__Group_2__3 ;
    public final void rule__Edge__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2931:1: ( rule__Edge__Group_2__2__Impl rule__Edge__Group_2__3 )
            // InternalModelDraw.g:2932:2: rule__Edge__Group_2__2__Impl rule__Edge__Group_2__3
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
    // InternalModelDraw.g:2939:1: rule__Edge__Group_2__2__Impl : ( ( rule__Edge__Group_2_2__0 )* ) ;
    public final void rule__Edge__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2943:1: ( ( ( rule__Edge__Group_2_2__0 )* ) )
            // InternalModelDraw.g:2944:1: ( ( rule__Edge__Group_2_2__0 )* )
            {
            // InternalModelDraw.g:2944:1: ( ( rule__Edge__Group_2_2__0 )* )
            // InternalModelDraw.g:2945:2: ( rule__Edge__Group_2_2__0 )*
            {
             before(grammarAccess.getEdgeAccess().getGroup_2_2()); 
            // InternalModelDraw.g:2946:2: ( rule__Edge__Group_2_2__0 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==34) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalModelDraw.g:2946:3: rule__Edge__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Edge__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
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
    // InternalModelDraw.g:2954:1: rule__Edge__Group_2__3 : rule__Edge__Group_2__3__Impl ;
    public final void rule__Edge__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2958:1: ( rule__Edge__Group_2__3__Impl )
            // InternalModelDraw.g:2959:2: rule__Edge__Group_2__3__Impl
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
    // InternalModelDraw.g:2965:1: rule__Edge__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2969:1: ( ( ')' ) )
            // InternalModelDraw.g:2970:1: ( ')' )
            {
            // InternalModelDraw.g:2970:1: ( ')' )
            // InternalModelDraw.g:2971:2: ')'
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
    // InternalModelDraw.g:2981:1: rule__Edge__Group_2_2__0 : rule__Edge__Group_2_2__0__Impl rule__Edge__Group_2_2__1 ;
    public final void rule__Edge__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2985:1: ( rule__Edge__Group_2_2__0__Impl rule__Edge__Group_2_2__1 )
            // InternalModelDraw.g:2986:2: rule__Edge__Group_2_2__0__Impl rule__Edge__Group_2_2__1
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
    // InternalModelDraw.g:2993:1: rule__Edge__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2997:1: ( ( ',' ) )
            // InternalModelDraw.g:2998:1: ( ',' )
            {
            // InternalModelDraw.g:2998:1: ( ',' )
            // InternalModelDraw.g:2999:2: ','
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
    // InternalModelDraw.g:3008:1: rule__Edge__Group_2_2__1 : rule__Edge__Group_2_2__1__Impl ;
    public final void rule__Edge__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3012:1: ( rule__Edge__Group_2_2__1__Impl )
            // InternalModelDraw.g:3013:2: rule__Edge__Group_2_2__1__Impl
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
    // InternalModelDraw.g:3019:1: rule__Edge__Group_2_2__1__Impl : ( ( rule__Edge__FeatureAssignment_2_2_1 ) ) ;
    public final void rule__Edge__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3023:1: ( ( ( rule__Edge__FeatureAssignment_2_2_1 ) ) )
            // InternalModelDraw.g:3024:1: ( ( rule__Edge__FeatureAssignment_2_2_1 ) )
            {
            // InternalModelDraw.g:3024:1: ( ( rule__Edge__FeatureAssignment_2_2_1 ) )
            // InternalModelDraw.g:3025:2: ( rule__Edge__FeatureAssignment_2_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getFeatureAssignment_2_2_1()); 
            // InternalModelDraw.g:3026:2: ( rule__Edge__FeatureAssignment_2_2_1 )
            // InternalModelDraw.g:3026:3: rule__Edge__FeatureAssignment_2_2_1
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
    // InternalModelDraw.g:3035:1: rule__Edge__Group_3_0__0 : rule__Edge__Group_3_0__0__Impl rule__Edge__Group_3_0__1 ;
    public final void rule__Edge__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3039:1: ( rule__Edge__Group_3_0__0__Impl rule__Edge__Group_3_0__1 )
            // InternalModelDraw.g:3040:2: rule__Edge__Group_3_0__0__Impl rule__Edge__Group_3_0__1
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
    // InternalModelDraw.g:3047:1: rule__Edge__Group_3_0__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3051:1: ( ( '(' ) )
            // InternalModelDraw.g:3052:1: ( '(' )
            {
            // InternalModelDraw.g:3052:1: ( '(' )
            // InternalModelDraw.g:3053:2: '('
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
    // InternalModelDraw.g:3062:1: rule__Edge__Group_3_0__1 : rule__Edge__Group_3_0__1__Impl rule__Edge__Group_3_0__2 ;
    public final void rule__Edge__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3066:1: ( rule__Edge__Group_3_0__1__Impl rule__Edge__Group_3_0__2 )
            // InternalModelDraw.g:3067:2: rule__Edge__Group_3_0__1__Impl rule__Edge__Group_3_0__2
            {
            pushFollow(FOLLOW_15);
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
    // InternalModelDraw.g:3074:1: rule__Edge__Group_3_0__1__Impl : ( ( rule__Edge__SourceAssignment_3_0_1 ) ) ;
    public final void rule__Edge__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3078:1: ( ( ( rule__Edge__SourceAssignment_3_0_1 ) ) )
            // InternalModelDraw.g:3079:1: ( ( rule__Edge__SourceAssignment_3_0_1 ) )
            {
            // InternalModelDraw.g:3079:1: ( ( rule__Edge__SourceAssignment_3_0_1 ) )
            // InternalModelDraw.g:3080:2: ( rule__Edge__SourceAssignment_3_0_1 )
            {
             before(grammarAccess.getEdgeAccess().getSourceAssignment_3_0_1()); 
            // InternalModelDraw.g:3081:2: ( rule__Edge__SourceAssignment_3_0_1 )
            // InternalModelDraw.g:3081:3: rule__Edge__SourceAssignment_3_0_1
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
    // InternalModelDraw.g:3089:1: rule__Edge__Group_3_0__2 : rule__Edge__Group_3_0__2__Impl rule__Edge__Group_3_0__3 ;
    public final void rule__Edge__Group_3_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3093:1: ( rule__Edge__Group_3_0__2__Impl rule__Edge__Group_3_0__3 )
            // InternalModelDraw.g:3094:2: rule__Edge__Group_3_0__2__Impl rule__Edge__Group_3_0__3
            {
            pushFollow(FOLLOW_15);
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
    // InternalModelDraw.g:3101:1: rule__Edge__Group_3_0__2__Impl : ( ( rule__Edge__Group_3_0_2__0 )? ) ;
    public final void rule__Edge__Group_3_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3105:1: ( ( ( rule__Edge__Group_3_0_2__0 )? ) )
            // InternalModelDraw.g:3106:1: ( ( rule__Edge__Group_3_0_2__0 )? )
            {
            // InternalModelDraw.g:3106:1: ( ( rule__Edge__Group_3_0_2__0 )? )
            // InternalModelDraw.g:3107:2: ( rule__Edge__Group_3_0_2__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_3_0_2()); 
            // InternalModelDraw.g:3108:2: ( rule__Edge__Group_3_0_2__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==34) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalModelDraw.g:3108:3: rule__Edge__Group_3_0_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_3_0_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_3_0_2()); 

            }


            }

        }
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
    // InternalModelDraw.g:3116:1: rule__Edge__Group_3_0__3 : rule__Edge__Group_3_0__3__Impl ;
    public final void rule__Edge__Group_3_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3120:1: ( rule__Edge__Group_3_0__3__Impl )
            // InternalModelDraw.g:3121:2: rule__Edge__Group_3_0__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0__3__Impl();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:3127:1: rule__Edge__Group_3_0__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_3_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3131:1: ( ( ')' ) )
            // InternalModelDraw.g:3132:1: ( ')' )
            {
            // InternalModelDraw.g:3132:1: ( ')' )
            // InternalModelDraw.g:3133:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_0_3()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_3_0_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Edge__Group_3_0_2__0"
    // InternalModelDraw.g:3143:1: rule__Edge__Group_3_0_2__0 : rule__Edge__Group_3_0_2__0__Impl rule__Edge__Group_3_0_2__1 ;
    public final void rule__Edge__Group_3_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3147:1: ( rule__Edge__Group_3_0_2__0__Impl rule__Edge__Group_3_0_2__1 )
            // InternalModelDraw.g:3148:2: rule__Edge__Group_3_0_2__0__Impl rule__Edge__Group_3_0_2__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_3_0_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0_2__0"


    // $ANTLR start "rule__Edge__Group_3_0_2__0__Impl"
    // InternalModelDraw.g:3155:1: rule__Edge__Group_3_0_2__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_3_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3159:1: ( ( ',' ) )
            // InternalModelDraw.g:3160:1: ( ',' )
            {
            // InternalModelDraw.g:3160:1: ( ',' )
            // InternalModelDraw.g:3161:2: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_3_0_2_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_3_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0_2__0__Impl"


    // $ANTLR start "rule__Edge__Group_3_0_2__1"
    // InternalModelDraw.g:3170:1: rule__Edge__Group_3_0_2__1 : rule__Edge__Group_3_0_2__1__Impl ;
    public final void rule__Edge__Group_3_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3174:1: ( rule__Edge__Group_3_0_2__1__Impl )
            // InternalModelDraw.g:3175:2: rule__Edge__Group_3_0_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_3_0_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0_2__1"


    // $ANTLR start "rule__Edge__Group_3_0_2__1__Impl"
    // InternalModelDraw.g:3181:1: rule__Edge__Group_3_0_2__1__Impl : ( ( rule__Edge__TargetAssignment_3_0_2_1 ) ) ;
    public final void rule__Edge__Group_3_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3185:1: ( ( ( rule__Edge__TargetAssignment_3_0_2_1 ) ) )
            // InternalModelDraw.g:3186:1: ( ( rule__Edge__TargetAssignment_3_0_2_1 ) )
            {
            // InternalModelDraw.g:3186:1: ( ( rule__Edge__TargetAssignment_3_0_2_1 ) )
            // InternalModelDraw.g:3187:2: ( rule__Edge__TargetAssignment_3_0_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getTargetAssignment_3_0_2_1()); 
            // InternalModelDraw.g:3188:2: ( rule__Edge__TargetAssignment_3_0_2_1 )
            // InternalModelDraw.g:3188:3: rule__Edge__TargetAssignment_3_0_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__TargetAssignment_3_0_2_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTargetAssignment_3_0_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_3_0_2__1__Impl"


    // $ANTLR start "rule__Edge__Group_3_1__0"
    // InternalModelDraw.g:3197:1: rule__Edge__Group_3_1__0 : rule__Edge__Group_3_1__0__Impl rule__Edge__Group_3_1__1 ;
    public final void rule__Edge__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3201:1: ( rule__Edge__Group_3_1__0__Impl rule__Edge__Group_3_1__1 )
            // InternalModelDraw.g:3202:2: rule__Edge__Group_3_1__0__Impl rule__Edge__Group_3_1__1
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
    // InternalModelDraw.g:3209:1: rule__Edge__Group_3_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3213:1: ( ( '->' ) )
            // InternalModelDraw.g:3214:1: ( '->' )
            {
            // InternalModelDraw.g:3214:1: ( '->' )
            // InternalModelDraw.g:3215:2: '->'
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
    // InternalModelDraw.g:3224:1: rule__Edge__Group_3_1__1 : rule__Edge__Group_3_1__1__Impl rule__Edge__Group_3_1__2 ;
    public final void rule__Edge__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3228:1: ( rule__Edge__Group_3_1__1__Impl rule__Edge__Group_3_1__2 )
            // InternalModelDraw.g:3229:2: rule__Edge__Group_3_1__1__Impl rule__Edge__Group_3_1__2
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
    // InternalModelDraw.g:3236:1: rule__Edge__Group_3_1__1__Impl : ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) ) ;
    public final void rule__Edge__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3240:1: ( ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) ) )
            // InternalModelDraw.g:3241:1: ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) )
            {
            // InternalModelDraw.g:3241:1: ( ( rule__Edge__TargetNodeAssignment_3_1_1 ) )
            // InternalModelDraw.g:3242:2: ( rule__Edge__TargetNodeAssignment_3_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getTargetNodeAssignment_3_1_1()); 
            // InternalModelDraw.g:3243:2: ( rule__Edge__TargetNodeAssignment_3_1_1 )
            // InternalModelDraw.g:3243:3: rule__Edge__TargetNodeAssignment_3_1_1
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
    // InternalModelDraw.g:3251:1: rule__Edge__Group_3_1__2 : rule__Edge__Group_3_1__2__Impl ;
    public final void rule__Edge__Group_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3255:1: ( rule__Edge__Group_3_1__2__Impl )
            // InternalModelDraw.g:3256:2: rule__Edge__Group_3_1__2__Impl
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
    // InternalModelDraw.g:3262:1: rule__Edge__Group_3_1__2__Impl : ( ( rule__Edge__Group_3_1_2__0 )? ) ;
    public final void rule__Edge__Group_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3266:1: ( ( ( rule__Edge__Group_3_1_2__0 )? ) )
            // InternalModelDraw.g:3267:1: ( ( rule__Edge__Group_3_1_2__0 )? )
            {
            // InternalModelDraw.g:3267:1: ( ( rule__Edge__Group_3_1_2__0 )? )
            // InternalModelDraw.g:3268:2: ( rule__Edge__Group_3_1_2__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_3_1_2()); 
            // InternalModelDraw.g:3269:2: ( rule__Edge__Group_3_1_2__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==32) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalModelDraw.g:3269:3: rule__Edge__Group_3_1_2__0
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
    // InternalModelDraw.g:3278:1: rule__Edge__Group_3_1_2__0 : rule__Edge__Group_3_1_2__0__Impl rule__Edge__Group_3_1_2__1 ;
    public final void rule__Edge__Group_3_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3282:1: ( rule__Edge__Group_3_1_2__0__Impl rule__Edge__Group_3_1_2__1 )
            // InternalModelDraw.g:3283:2: rule__Edge__Group_3_1_2__0__Impl rule__Edge__Group_3_1_2__1
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
    // InternalModelDraw.g:3290:1: rule__Edge__Group_3_1_2__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_3_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3294:1: ( ( '(' ) )
            // InternalModelDraw.g:3295:1: ( '(' )
            {
            // InternalModelDraw.g:3295:1: ( '(' )
            // InternalModelDraw.g:3296:2: '('
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
    // InternalModelDraw.g:3305:1: rule__Edge__Group_3_1_2__1 : rule__Edge__Group_3_1_2__1__Impl rule__Edge__Group_3_1_2__2 ;
    public final void rule__Edge__Group_3_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3309:1: ( rule__Edge__Group_3_1_2__1__Impl rule__Edge__Group_3_1_2__2 )
            // InternalModelDraw.g:3310:2: rule__Edge__Group_3_1_2__1__Impl rule__Edge__Group_3_1_2__2
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
    // InternalModelDraw.g:3317:1: rule__Edge__Group_3_1_2__1__Impl : ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) ) ;
    public final void rule__Edge__Group_3_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3321:1: ( ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) ) )
            // InternalModelDraw.g:3322:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) )
            {
            // InternalModelDraw.g:3322:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_1 ) )
            // InternalModelDraw.g:3323:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getTargetFeatureAssignment_3_1_2_1()); 
            // InternalModelDraw.g:3324:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_1 )
            // InternalModelDraw.g:3324:3: rule__Edge__TargetFeatureAssignment_3_1_2_1
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
    // InternalModelDraw.g:3332:1: rule__Edge__Group_3_1_2__2 : rule__Edge__Group_3_1_2__2__Impl rule__Edge__Group_3_1_2__3 ;
    public final void rule__Edge__Group_3_1_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3336:1: ( rule__Edge__Group_3_1_2__2__Impl rule__Edge__Group_3_1_2__3 )
            // InternalModelDraw.g:3337:2: rule__Edge__Group_3_1_2__2__Impl rule__Edge__Group_3_1_2__3
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
    // InternalModelDraw.g:3344:1: rule__Edge__Group_3_1_2__2__Impl : ( ( rule__Edge__Group_3_1_2_2__0 )* ) ;
    public final void rule__Edge__Group_3_1_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3348:1: ( ( ( rule__Edge__Group_3_1_2_2__0 )* ) )
            // InternalModelDraw.g:3349:1: ( ( rule__Edge__Group_3_1_2_2__0 )* )
            {
            // InternalModelDraw.g:3349:1: ( ( rule__Edge__Group_3_1_2_2__0 )* )
            // InternalModelDraw.g:3350:2: ( rule__Edge__Group_3_1_2_2__0 )*
            {
             before(grammarAccess.getEdgeAccess().getGroup_3_1_2_2()); 
            // InternalModelDraw.g:3351:2: ( rule__Edge__Group_3_1_2_2__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==34) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalModelDraw.g:3351:3: rule__Edge__Group_3_1_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Edge__Group_3_1_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalModelDraw.g:3359:1: rule__Edge__Group_3_1_2__3 : rule__Edge__Group_3_1_2__3__Impl ;
    public final void rule__Edge__Group_3_1_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3363:1: ( rule__Edge__Group_3_1_2__3__Impl )
            // InternalModelDraw.g:3364:2: rule__Edge__Group_3_1_2__3__Impl
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
    // InternalModelDraw.g:3370:1: rule__Edge__Group_3_1_2__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_3_1_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3374:1: ( ( ')' ) )
            // InternalModelDraw.g:3375:1: ( ')' )
            {
            // InternalModelDraw.g:3375:1: ( ')' )
            // InternalModelDraw.g:3376:2: ')'
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
    // InternalModelDraw.g:3386:1: rule__Edge__Group_3_1_2_2__0 : rule__Edge__Group_3_1_2_2__0__Impl rule__Edge__Group_3_1_2_2__1 ;
    public final void rule__Edge__Group_3_1_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3390:1: ( rule__Edge__Group_3_1_2_2__0__Impl rule__Edge__Group_3_1_2_2__1 )
            // InternalModelDraw.g:3391:2: rule__Edge__Group_3_1_2_2__0__Impl rule__Edge__Group_3_1_2_2__1
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
    // InternalModelDraw.g:3398:1: rule__Edge__Group_3_1_2_2__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_3_1_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3402:1: ( ( ',' ) )
            // InternalModelDraw.g:3403:1: ( ',' )
            {
            // InternalModelDraw.g:3403:1: ( ',' )
            // InternalModelDraw.g:3404:2: ','
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
    // InternalModelDraw.g:3413:1: rule__Edge__Group_3_1_2_2__1 : rule__Edge__Group_3_1_2_2__1__Impl ;
    public final void rule__Edge__Group_3_1_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3417:1: ( rule__Edge__Group_3_1_2_2__1__Impl )
            // InternalModelDraw.g:3418:2: rule__Edge__Group_3_1_2_2__1__Impl
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
    // InternalModelDraw.g:3424:1: rule__Edge__Group_3_1_2_2__1__Impl : ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) ) ;
    public final void rule__Edge__Group_3_1_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3428:1: ( ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) ) )
            // InternalModelDraw.g:3429:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) )
            {
            // InternalModelDraw.g:3429:1: ( ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 ) )
            // InternalModelDraw.g:3430:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 )
            {
             before(grammarAccess.getEdgeAccess().getTargetFeatureAssignment_3_1_2_2_1()); 
            // InternalModelDraw.g:3431:2: ( rule__Edge__TargetFeatureAssignment_3_1_2_2_1 )
            // InternalModelDraw.g:3431:3: rule__Edge__TargetFeatureAssignment_3_1_2_2_1
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
    // InternalModelDraw.g:3440:1: rule__Edge__Group_6__0 : rule__Edge__Group_6__0__Impl rule__Edge__Group_6__1 ;
    public final void rule__Edge__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3444:1: ( rule__Edge__Group_6__0__Impl rule__Edge__Group_6__1 )
            // InternalModelDraw.g:3445:2: rule__Edge__Group_6__0__Impl rule__Edge__Group_6__1
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
    // InternalModelDraw.g:3452:1: rule__Edge__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Edge__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3456:1: ( ( '=' ) )
            // InternalModelDraw.g:3457:1: ( '=' )
            {
            // InternalModelDraw.g:3457:1: ( '=' )
            // InternalModelDraw.g:3458:2: '='
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
    // InternalModelDraw.g:3467:1: rule__Edge__Group_6__1 : rule__Edge__Group_6__1__Impl ;
    public final void rule__Edge__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3471:1: ( rule__Edge__Group_6__1__Impl )
            // InternalModelDraw.g:3472:2: rule__Edge__Group_6__1__Impl
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
    // InternalModelDraw.g:3478:1: rule__Edge__Group_6__1__Impl : ( ( rule__Edge__AttNameAssignment_6_1 ) ) ;
    public final void rule__Edge__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3482:1: ( ( ( rule__Edge__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:3483:1: ( ( rule__Edge__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:3483:1: ( ( rule__Edge__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:3484:2: ( rule__Edge__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getEdgeAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:3485:2: ( rule__Edge__AttNameAssignment_6_1 )
            // InternalModelDraw.g:3485:3: rule__Edge__AttNameAssignment_6_1
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
    // InternalModelDraw.g:3494:1: rule__Edge__Group_7__0 : rule__Edge__Group_7__0__Impl rule__Edge__Group_7__1 ;
    public final void rule__Edge__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3498:1: ( rule__Edge__Group_7__0__Impl rule__Edge__Group_7__1 )
            // InternalModelDraw.g:3499:2: rule__Edge__Group_7__0__Impl rule__Edge__Group_7__1
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
    // InternalModelDraw.g:3506:1: rule__Edge__Group_7__0__Impl : ( 'label' ) ;
    public final void rule__Edge__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3510:1: ( ( 'label' ) )
            // InternalModelDraw.g:3511:1: ( 'label' )
            {
            // InternalModelDraw.g:3511:1: ( 'label' )
            // InternalModelDraw.g:3512:2: 'label'
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
    // InternalModelDraw.g:3521:1: rule__Edge__Group_7__1 : rule__Edge__Group_7__1__Impl rule__Edge__Group_7__2 ;
    public final void rule__Edge__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3525:1: ( rule__Edge__Group_7__1__Impl rule__Edge__Group_7__2 )
            // InternalModelDraw.g:3526:2: rule__Edge__Group_7__1__Impl rule__Edge__Group_7__2
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:3533:1: rule__Edge__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3537:1: ( ( '=' ) )
            // InternalModelDraw.g:3538:1: ( '=' )
            {
            // InternalModelDraw.g:3538:1: ( '=' )
            // InternalModelDraw.g:3539:2: '='
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
    // InternalModelDraw.g:3548:1: rule__Edge__Group_7__2 : rule__Edge__Group_7__2__Impl ;
    public final void rule__Edge__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3552:1: ( rule__Edge__Group_7__2__Impl )
            // InternalModelDraw.g:3553:2: rule__Edge__Group_7__2__Impl
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
    // InternalModelDraw.g:3559:1: rule__Edge__Group_7__2__Impl : ( ( rule__Edge__Alternatives_7_2 ) ) ;
    public final void rule__Edge__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3563:1: ( ( ( rule__Edge__Alternatives_7_2 ) ) )
            // InternalModelDraw.g:3564:1: ( ( rule__Edge__Alternatives_7_2 ) )
            {
            // InternalModelDraw.g:3564:1: ( ( rule__Edge__Alternatives_7_2 ) )
            // InternalModelDraw.g:3565:2: ( rule__Edge__Alternatives_7_2 )
            {
             before(grammarAccess.getEdgeAccess().getAlternatives_7_2()); 
            // InternalModelDraw.g:3566:2: ( rule__Edge__Alternatives_7_2 )
            // InternalModelDraw.g:3566:3: rule__Edge__Alternatives_7_2
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
    // InternalModelDraw.g:3575:1: rule__Edge__Group_7_2_0__0 : rule__Edge__Group_7_2_0__0__Impl rule__Edge__Group_7_2_0__1 ;
    public final void rule__Edge__Group_7_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3579:1: ( rule__Edge__Group_7_2_0__0__Impl rule__Edge__Group_7_2_0__1 )
            // InternalModelDraw.g:3580:2: rule__Edge__Group_7_2_0__0__Impl rule__Edge__Group_7_2_0__1
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
    // InternalModelDraw.g:3587:1: rule__Edge__Group_7_2_0__0__Impl : ( ( rule__Edge__Group_7_2_0_0__0 )? ) ;
    public final void rule__Edge__Group_7_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3591:1: ( ( ( rule__Edge__Group_7_2_0_0__0 )? ) )
            // InternalModelDraw.g:3592:1: ( ( rule__Edge__Group_7_2_0_0__0 )? )
            {
            // InternalModelDraw.g:3592:1: ( ( rule__Edge__Group_7_2_0_0__0 )? )
            // InternalModelDraw.g:3593:2: ( rule__Edge__Group_7_2_0_0__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_0_0()); 
            // InternalModelDraw.g:3594:2: ( rule__Edge__Group_7_2_0_0__0 )?
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
                    // InternalModelDraw.g:3594:3: rule__Edge__Group_7_2_0_0__0
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
    // InternalModelDraw.g:3602:1: rule__Edge__Group_7_2_0__1 : rule__Edge__Group_7_2_0__1__Impl ;
    public final void rule__Edge__Group_7_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3606:1: ( rule__Edge__Group_7_2_0__1__Impl )
            // InternalModelDraw.g:3607:2: rule__Edge__Group_7_2_0__1__Impl
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
    // InternalModelDraw.g:3613:1: rule__Edge__Group_7_2_0__1__Impl : ( ( rule__Edge__LabelAssignment_7_2_0_1 ) ) ;
    public final void rule__Edge__Group_7_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3617:1: ( ( ( rule__Edge__LabelAssignment_7_2_0_1 ) ) )
            // InternalModelDraw.g:3618:1: ( ( rule__Edge__LabelAssignment_7_2_0_1 ) )
            {
            // InternalModelDraw.g:3618:1: ( ( rule__Edge__LabelAssignment_7_2_0_1 ) )
            // InternalModelDraw.g:3619:2: ( rule__Edge__LabelAssignment_7_2_0_1 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_0_1()); 
            // InternalModelDraw.g:3620:2: ( rule__Edge__LabelAssignment_7_2_0_1 )
            // InternalModelDraw.g:3620:3: rule__Edge__LabelAssignment_7_2_0_1
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
    // InternalModelDraw.g:3629:1: rule__Edge__Group_7_2_0_0__0 : rule__Edge__Group_7_2_0_0__0__Impl rule__Edge__Group_7_2_0_0__1 ;
    public final void rule__Edge__Group_7_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3633:1: ( rule__Edge__Group_7_2_0_0__0__Impl rule__Edge__Group_7_2_0_0__1 )
            // InternalModelDraw.g:3634:2: rule__Edge__Group_7_2_0_0__0__Impl rule__Edge__Group_7_2_0_0__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:3641:1: rule__Edge__Group_7_2_0_0__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) ) ;
    public final void rule__Edge__Group_7_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3645:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) ) )
            // InternalModelDraw.g:3646:1: ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) )
            {
            // InternalModelDraw.g:3646:1: ( ( rule__Edge__ReferenceAssignment_7_2_0_0_0 ) )
            // InternalModelDraw.g:3647:2: ( rule__Edge__ReferenceAssignment_7_2_0_0_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_0_0_0()); 
            // InternalModelDraw.g:3648:2: ( rule__Edge__ReferenceAssignment_7_2_0_0_0 )
            // InternalModelDraw.g:3648:3: rule__Edge__ReferenceAssignment_7_2_0_0_0
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
    // InternalModelDraw.g:3656:1: rule__Edge__Group_7_2_0_0__1 : rule__Edge__Group_7_2_0_0__1__Impl rule__Edge__Group_7_2_0_0__2 ;
    public final void rule__Edge__Group_7_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3660:1: ( rule__Edge__Group_7_2_0_0__1__Impl rule__Edge__Group_7_2_0_0__2 )
            // InternalModelDraw.g:3661:2: rule__Edge__Group_7_2_0_0__1__Impl rule__Edge__Group_7_2_0_0__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:3668:1: rule__Edge__Group_7_2_0_0__1__Impl : ( ( rule__Edge__Group_7_2_0_0_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3672:1: ( ( ( rule__Edge__Group_7_2_0_0_1__0 )? ) )
            // InternalModelDraw.g:3673:1: ( ( rule__Edge__Group_7_2_0_0_1__0 )? )
            {
            // InternalModelDraw.g:3673:1: ( ( rule__Edge__Group_7_2_0_0_1__0 )? )
            // InternalModelDraw.g:3674:2: ( rule__Edge__Group_7_2_0_0_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_0_0_1()); 
            // InternalModelDraw.g:3675:2: ( rule__Edge__Group_7_2_0_0_1__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==35) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalModelDraw.g:3675:3: rule__Edge__Group_7_2_0_0_1__0
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
    // InternalModelDraw.g:3683:1: rule__Edge__Group_7_2_0_0__2 : rule__Edge__Group_7_2_0_0__2__Impl ;
    public final void rule__Edge__Group_7_2_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3687:1: ( rule__Edge__Group_7_2_0_0__2__Impl )
            // InternalModelDraw.g:3688:2: rule__Edge__Group_7_2_0_0__2__Impl
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
    // InternalModelDraw.g:3694:1: rule__Edge__Group_7_2_0_0__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3698:1: ( ( '.' ) )
            // InternalModelDraw.g:3699:1: ( '.' )
            {
            // InternalModelDraw.g:3699:1: ( '.' )
            // InternalModelDraw.g:3700:2: '.'
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
    // InternalModelDraw.g:3710:1: rule__Edge__Group_7_2_0_0_1__0 : rule__Edge__Group_7_2_0_0_1__0__Impl rule__Edge__Group_7_2_0_0_1__1 ;
    public final void rule__Edge__Group_7_2_0_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3714:1: ( rule__Edge__Group_7_2_0_0_1__0__Impl rule__Edge__Group_7_2_0_0_1__1 )
            // InternalModelDraw.g:3715:2: rule__Edge__Group_7_2_0_0_1__0__Impl rule__Edge__Group_7_2_0_0_1__1
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
    // InternalModelDraw.g:3722:1: rule__Edge__Group_7_2_0_0_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_0_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3726:1: ( ( '->' ) )
            // InternalModelDraw.g:3727:1: ( '->' )
            {
            // InternalModelDraw.g:3727:1: ( '->' )
            // InternalModelDraw.g:3728:2: '->'
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
    // InternalModelDraw.g:3737:1: rule__Edge__Group_7_2_0_0_1__1 : rule__Edge__Group_7_2_0_0_1__1__Impl ;
    public final void rule__Edge__Group_7_2_0_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3741:1: ( rule__Edge__Group_7_2_0_0_1__1__Impl )
            // InternalModelDraw.g:3742:2: rule__Edge__Group_7_2_0_0_1__1__Impl
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
    // InternalModelDraw.g:3748:1: rule__Edge__Group_7_2_0_0_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_0_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3752:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) ) )
            // InternalModelDraw.g:3753:1: ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) )
            {
            // InternalModelDraw.g:3753:1: ( ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 ) )
            // InternalModelDraw.g:3754:2: ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_0_0_1_1()); 
            // InternalModelDraw.g:3755:2: ( rule__Edge__RefTypeAssignment_7_2_0_0_1_1 )
            // InternalModelDraw.g:3755:3: rule__Edge__RefTypeAssignment_7_2_0_0_1_1
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
    // InternalModelDraw.g:3764:1: rule__Edge__Group_7_2_1__0 : rule__Edge__Group_7_2_1__0__Impl rule__Edge__Group_7_2_1__1 ;
    public final void rule__Edge__Group_7_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3768:1: ( rule__Edge__Group_7_2_1__0__Impl rule__Edge__Group_7_2_1__1 )
            // InternalModelDraw.g:3769:2: rule__Edge__Group_7_2_1__0__Impl rule__Edge__Group_7_2_1__1
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
    // InternalModelDraw.g:3776:1: rule__Edge__Group_7_2_1__0__Impl : ( '{' ) ;
    public final void rule__Edge__Group_7_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3780:1: ( ( '{' ) )
            // InternalModelDraw.g:3781:1: ( '{' )
            {
            // InternalModelDraw.g:3781:1: ( '{' )
            // InternalModelDraw.g:3782:2: '{'
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
    // InternalModelDraw.g:3791:1: rule__Edge__Group_7_2_1__1 : rule__Edge__Group_7_2_1__1__Impl rule__Edge__Group_7_2_1__2 ;
    public final void rule__Edge__Group_7_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3795:1: ( rule__Edge__Group_7_2_1__1__Impl rule__Edge__Group_7_2_1__2 )
            // InternalModelDraw.g:3796:2: rule__Edge__Group_7_2_1__1__Impl rule__Edge__Group_7_2_1__2
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
    // InternalModelDraw.g:3803:1: rule__Edge__Group_7_2_1__1__Impl : ( ( rule__Edge__Group_7_2_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3807:1: ( ( ( rule__Edge__Group_7_2_1_1__0 )? ) )
            // InternalModelDraw.g:3808:1: ( ( rule__Edge__Group_7_2_1_1__0 )? )
            {
            // InternalModelDraw.g:3808:1: ( ( rule__Edge__Group_7_2_1_1__0 )? )
            // InternalModelDraw.g:3809:2: ( rule__Edge__Group_7_2_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_1()); 
            // InternalModelDraw.g:3810:2: ( rule__Edge__Group_7_2_1_1__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==RULE_ID) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==35||LA42_1==44) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // InternalModelDraw.g:3810:3: rule__Edge__Group_7_2_1_1__0
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
    // InternalModelDraw.g:3818:1: rule__Edge__Group_7_2_1__2 : rule__Edge__Group_7_2_1__2__Impl rule__Edge__Group_7_2_1__3 ;
    public final void rule__Edge__Group_7_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3822:1: ( rule__Edge__Group_7_2_1__2__Impl rule__Edge__Group_7_2_1__3 )
            // InternalModelDraw.g:3823:2: rule__Edge__Group_7_2_1__2__Impl rule__Edge__Group_7_2_1__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:3830:1: rule__Edge__Group_7_2_1__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_2 ) ) ;
    public final void rule__Edge__Group_7_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3834:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_2 ) ) )
            // InternalModelDraw.g:3835:1: ( ( rule__Edge__LabelAssignment_7_2_1_2 ) )
            {
            // InternalModelDraw.g:3835:1: ( ( rule__Edge__LabelAssignment_7_2_1_2 ) )
            // InternalModelDraw.g:3836:2: ( rule__Edge__LabelAssignment_7_2_1_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_2()); 
            // InternalModelDraw.g:3837:2: ( rule__Edge__LabelAssignment_7_2_1_2 )
            // InternalModelDraw.g:3837:3: rule__Edge__LabelAssignment_7_2_1_2
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
    // InternalModelDraw.g:3845:1: rule__Edge__Group_7_2_1__3 : rule__Edge__Group_7_2_1__3__Impl rule__Edge__Group_7_2_1__4 ;
    public final void rule__Edge__Group_7_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3849:1: ( rule__Edge__Group_7_2_1__3__Impl rule__Edge__Group_7_2_1__4 )
            // InternalModelDraw.g:3850:2: rule__Edge__Group_7_2_1__3__Impl rule__Edge__Group_7_2_1__4
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:3857:1: rule__Edge__Group_7_2_1__3__Impl : ( ( rule__Edge__Group_7_2_1_3__0 )? ) ;
    public final void rule__Edge__Group_7_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3861:1: ( ( ( rule__Edge__Group_7_2_1_3__0 )? ) )
            // InternalModelDraw.g:3862:1: ( ( rule__Edge__Group_7_2_1_3__0 )? )
            {
            // InternalModelDraw.g:3862:1: ( ( rule__Edge__Group_7_2_1_3__0 )? )
            // InternalModelDraw.g:3863:2: ( rule__Edge__Group_7_2_1_3__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_3()); 
            // InternalModelDraw.g:3864:2: ( rule__Edge__Group_7_2_1_3__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==32) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalModelDraw.g:3864:3: rule__Edge__Group_7_2_1_3__0
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
    // InternalModelDraw.g:3872:1: rule__Edge__Group_7_2_1__4 : rule__Edge__Group_7_2_1__4__Impl rule__Edge__Group_7_2_1__5 ;
    public final void rule__Edge__Group_7_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3876:1: ( rule__Edge__Group_7_2_1__4__Impl rule__Edge__Group_7_2_1__5 )
            // InternalModelDraw.g:3877:2: rule__Edge__Group_7_2_1__4__Impl rule__Edge__Group_7_2_1__5
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:3884:1: rule__Edge__Group_7_2_1__4__Impl : ( ( rule__Edge__Group_7_2_1_4__0 )* ) ;
    public final void rule__Edge__Group_7_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3888:1: ( ( ( rule__Edge__Group_7_2_1_4__0 )* ) )
            // InternalModelDraw.g:3889:1: ( ( rule__Edge__Group_7_2_1_4__0 )* )
            {
            // InternalModelDraw.g:3889:1: ( ( rule__Edge__Group_7_2_1_4__0 )* )
            // InternalModelDraw.g:3890:2: ( rule__Edge__Group_7_2_1_4__0 )*
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4()); 
            // InternalModelDraw.g:3891:2: ( rule__Edge__Group_7_2_1_4__0 )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==34) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalModelDraw.g:3891:3: rule__Edge__Group_7_2_1_4__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Edge__Group_7_2_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop44;
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
    // InternalModelDraw.g:3899:1: rule__Edge__Group_7_2_1__5 : rule__Edge__Group_7_2_1__5__Impl ;
    public final void rule__Edge__Group_7_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3903:1: ( rule__Edge__Group_7_2_1__5__Impl )
            // InternalModelDraw.g:3904:2: rule__Edge__Group_7_2_1__5__Impl
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
    // InternalModelDraw.g:3910:1: rule__Edge__Group_7_2_1__5__Impl : ( '}' ) ;
    public final void rule__Edge__Group_7_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3914:1: ( ( '}' ) )
            // InternalModelDraw.g:3915:1: ( '}' )
            {
            // InternalModelDraw.g:3915:1: ( '}' )
            // InternalModelDraw.g:3916:2: '}'
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
    // InternalModelDraw.g:3926:1: rule__Edge__Group_7_2_1_1__0 : rule__Edge__Group_7_2_1_1__0__Impl rule__Edge__Group_7_2_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3930:1: ( rule__Edge__Group_7_2_1_1__0__Impl rule__Edge__Group_7_2_1_1__1 )
            // InternalModelDraw.g:3931:2: rule__Edge__Group_7_2_1_1__0__Impl rule__Edge__Group_7_2_1_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:3938:1: rule__Edge__Group_7_2_1_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3942:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) ) )
            // InternalModelDraw.g:3943:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) )
            {
            // InternalModelDraw.g:3943:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_1_0 ) )
            // InternalModelDraw.g:3944:2: ( rule__Edge__ReferenceAssignment_7_2_1_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_1_0()); 
            // InternalModelDraw.g:3945:2: ( rule__Edge__ReferenceAssignment_7_2_1_1_0 )
            // InternalModelDraw.g:3945:3: rule__Edge__ReferenceAssignment_7_2_1_1_0
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
    // InternalModelDraw.g:3953:1: rule__Edge__Group_7_2_1_1__1 : rule__Edge__Group_7_2_1_1__1__Impl rule__Edge__Group_7_2_1_1__2 ;
    public final void rule__Edge__Group_7_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3957:1: ( rule__Edge__Group_7_2_1_1__1__Impl rule__Edge__Group_7_2_1_1__2 )
            // InternalModelDraw.g:3958:2: rule__Edge__Group_7_2_1_1__1__Impl rule__Edge__Group_7_2_1_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:3965:1: rule__Edge__Group_7_2_1_1__1__Impl : ( ( rule__Edge__Group_7_2_1_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3969:1: ( ( ( rule__Edge__Group_7_2_1_1_1__0 )? ) )
            // InternalModelDraw.g:3970:1: ( ( rule__Edge__Group_7_2_1_1_1__0 )? )
            {
            // InternalModelDraw.g:3970:1: ( ( rule__Edge__Group_7_2_1_1_1__0 )? )
            // InternalModelDraw.g:3971:2: ( rule__Edge__Group_7_2_1_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_1_1()); 
            // InternalModelDraw.g:3972:2: ( rule__Edge__Group_7_2_1_1_1__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==35) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalModelDraw.g:3972:3: rule__Edge__Group_7_2_1_1_1__0
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
    // InternalModelDraw.g:3980:1: rule__Edge__Group_7_2_1_1__2 : rule__Edge__Group_7_2_1_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3984:1: ( rule__Edge__Group_7_2_1_1__2__Impl )
            // InternalModelDraw.g:3985:2: rule__Edge__Group_7_2_1_1__2__Impl
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
    // InternalModelDraw.g:3991:1: rule__Edge__Group_7_2_1_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3995:1: ( ( '.' ) )
            // InternalModelDraw.g:3996:1: ( '.' )
            {
            // InternalModelDraw.g:3996:1: ( '.' )
            // InternalModelDraw.g:3997:2: '.'
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
    // InternalModelDraw.g:4007:1: rule__Edge__Group_7_2_1_1_1__0 : rule__Edge__Group_7_2_1_1_1__0__Impl rule__Edge__Group_7_2_1_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4011:1: ( rule__Edge__Group_7_2_1_1_1__0__Impl rule__Edge__Group_7_2_1_1_1__1 )
            // InternalModelDraw.g:4012:2: rule__Edge__Group_7_2_1_1_1__0__Impl rule__Edge__Group_7_2_1_1_1__1
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
    // InternalModelDraw.g:4019:1: rule__Edge__Group_7_2_1_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4023:1: ( ( '->' ) )
            // InternalModelDraw.g:4024:1: ( '->' )
            {
            // InternalModelDraw.g:4024:1: ( '->' )
            // InternalModelDraw.g:4025:2: '->'
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
    // InternalModelDraw.g:4034:1: rule__Edge__Group_7_2_1_1_1__1 : rule__Edge__Group_7_2_1_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4038:1: ( rule__Edge__Group_7_2_1_1_1__1__Impl )
            // InternalModelDraw.g:4039:2: rule__Edge__Group_7_2_1_1_1__1__Impl
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
    // InternalModelDraw.g:4045:1: rule__Edge__Group_7_2_1_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4049:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) ) )
            // InternalModelDraw.g:4050:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) )
            {
            // InternalModelDraw.g:4050:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 ) )
            // InternalModelDraw.g:4051:2: ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_1_1_1()); 
            // InternalModelDraw.g:4052:2: ( rule__Edge__RefTypeAssignment_7_2_1_1_1_1 )
            // InternalModelDraw.g:4052:3: rule__Edge__RefTypeAssignment_7_2_1_1_1_1
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
    // InternalModelDraw.g:4061:1: rule__Edge__Group_7_2_1_3__0 : rule__Edge__Group_7_2_1_3__0__Impl rule__Edge__Group_7_2_1_3__1 ;
    public final void rule__Edge__Group_7_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4065:1: ( rule__Edge__Group_7_2_1_3__0__Impl rule__Edge__Group_7_2_1_3__1 )
            // InternalModelDraw.g:4066:2: rule__Edge__Group_7_2_1_3__0__Impl rule__Edge__Group_7_2_1_3__1
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
    // InternalModelDraw.g:4073:1: rule__Edge__Group_7_2_1_3__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_7_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4077:1: ( ( '(' ) )
            // InternalModelDraw.g:4078:1: ( '(' )
            {
            // InternalModelDraw.g:4078:1: ( '(' )
            // InternalModelDraw.g:4079:2: '('
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
    // InternalModelDraw.g:4088:1: rule__Edge__Group_7_2_1_3__1 : rule__Edge__Group_7_2_1_3__1__Impl rule__Edge__Group_7_2_1_3__2 ;
    public final void rule__Edge__Group_7_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4092:1: ( rule__Edge__Group_7_2_1_3__1__Impl rule__Edge__Group_7_2_1_3__2 )
            // InternalModelDraw.g:4093:2: rule__Edge__Group_7_2_1_3__1__Impl rule__Edge__Group_7_2_1_3__2
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
    // InternalModelDraw.g:4100:1: rule__Edge__Group_7_2_1_3__1__Impl : ( ( rule__Edge__Group_7_2_1_3_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4104:1: ( ( ( rule__Edge__Group_7_2_1_3_1__0 )? ) )
            // InternalModelDraw.g:4105:1: ( ( rule__Edge__Group_7_2_1_3_1__0 )? )
            {
            // InternalModelDraw.g:4105:1: ( ( rule__Edge__Group_7_2_1_3_1__0 )? )
            // InternalModelDraw.g:4106:2: ( rule__Edge__Group_7_2_1_3_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_3_1()); 
            // InternalModelDraw.g:4107:2: ( rule__Edge__Group_7_2_1_3_1__0 )?
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
                    // InternalModelDraw.g:4107:3: rule__Edge__Group_7_2_1_3_1__0
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
    // InternalModelDraw.g:4115:1: rule__Edge__Group_7_2_1_3__2 : rule__Edge__Group_7_2_1_3__2__Impl rule__Edge__Group_7_2_1_3__3 ;
    public final void rule__Edge__Group_7_2_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4119:1: ( rule__Edge__Group_7_2_1_3__2__Impl rule__Edge__Group_7_2_1_3__3 )
            // InternalModelDraw.g:4120:2: rule__Edge__Group_7_2_1_3__2__Impl rule__Edge__Group_7_2_1_3__3
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
    // InternalModelDraw.g:4127:1: rule__Edge__Group_7_2_1_3__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) ) ;
    public final void rule__Edge__Group_7_2_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4131:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) ) )
            // InternalModelDraw.g:4132:1: ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) )
            {
            // InternalModelDraw.g:4132:1: ( ( rule__Edge__LabelAssignment_7_2_1_3_2 ) )
            // InternalModelDraw.g:4133:2: ( rule__Edge__LabelAssignment_7_2_1_3_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_3_2()); 
            // InternalModelDraw.g:4134:2: ( rule__Edge__LabelAssignment_7_2_1_3_2 )
            // InternalModelDraw.g:4134:3: rule__Edge__LabelAssignment_7_2_1_3_2
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
    // InternalModelDraw.g:4142:1: rule__Edge__Group_7_2_1_3__3 : rule__Edge__Group_7_2_1_3__3__Impl ;
    public final void rule__Edge__Group_7_2_1_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4146:1: ( rule__Edge__Group_7_2_1_3__3__Impl )
            // InternalModelDraw.g:4147:2: rule__Edge__Group_7_2_1_3__3__Impl
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
    // InternalModelDraw.g:4153:1: rule__Edge__Group_7_2_1_3__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_7_2_1_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4157:1: ( ( ')' ) )
            // InternalModelDraw.g:4158:1: ( ')' )
            {
            // InternalModelDraw.g:4158:1: ( ')' )
            // InternalModelDraw.g:4159:2: ')'
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
    // InternalModelDraw.g:4169:1: rule__Edge__Group_7_2_1_3_1__0 : rule__Edge__Group_7_2_1_3_1__0__Impl rule__Edge__Group_7_2_1_3_1__1 ;
    public final void rule__Edge__Group_7_2_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4173:1: ( rule__Edge__Group_7_2_1_3_1__0__Impl rule__Edge__Group_7_2_1_3_1__1 )
            // InternalModelDraw.g:4174:2: rule__Edge__Group_7_2_1_3_1__0__Impl rule__Edge__Group_7_2_1_3_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:4181:1: rule__Edge__Group_7_2_1_3_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4185:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) ) )
            // InternalModelDraw.g:4186:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) )
            {
            // InternalModelDraw.g:4186:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 ) )
            // InternalModelDraw.g:4187:2: ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_3_1_0()); 
            // InternalModelDraw.g:4188:2: ( rule__Edge__ReferenceAssignment_7_2_1_3_1_0 )
            // InternalModelDraw.g:4188:3: rule__Edge__ReferenceAssignment_7_2_1_3_1_0
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
    // InternalModelDraw.g:4196:1: rule__Edge__Group_7_2_1_3_1__1 : rule__Edge__Group_7_2_1_3_1__1__Impl rule__Edge__Group_7_2_1_3_1__2 ;
    public final void rule__Edge__Group_7_2_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4200:1: ( rule__Edge__Group_7_2_1_3_1__1__Impl rule__Edge__Group_7_2_1_3_1__2 )
            // InternalModelDraw.g:4201:2: rule__Edge__Group_7_2_1_3_1__1__Impl rule__Edge__Group_7_2_1_3_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:4208:1: rule__Edge__Group_7_2_1_3_1__1__Impl : ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4212:1: ( ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? ) )
            // InternalModelDraw.g:4213:1: ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? )
            {
            // InternalModelDraw.g:4213:1: ( ( rule__Edge__Group_7_2_1_3_1_1__0 )? )
            // InternalModelDraw.g:4214:2: ( rule__Edge__Group_7_2_1_3_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_3_1_1()); 
            // InternalModelDraw.g:4215:2: ( rule__Edge__Group_7_2_1_3_1_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==35) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalModelDraw.g:4215:3: rule__Edge__Group_7_2_1_3_1_1__0
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
    // InternalModelDraw.g:4223:1: rule__Edge__Group_7_2_1_3_1__2 : rule__Edge__Group_7_2_1_3_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4227:1: ( rule__Edge__Group_7_2_1_3_1__2__Impl )
            // InternalModelDraw.g:4228:2: rule__Edge__Group_7_2_1_3_1__2__Impl
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
    // InternalModelDraw.g:4234:1: rule__Edge__Group_7_2_1_3_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4238:1: ( ( '.' ) )
            // InternalModelDraw.g:4239:1: ( '.' )
            {
            // InternalModelDraw.g:4239:1: ( '.' )
            // InternalModelDraw.g:4240:2: '.'
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
    // InternalModelDraw.g:4250:1: rule__Edge__Group_7_2_1_3_1_1__0 : rule__Edge__Group_7_2_1_3_1_1__0__Impl rule__Edge__Group_7_2_1_3_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4254:1: ( rule__Edge__Group_7_2_1_3_1_1__0__Impl rule__Edge__Group_7_2_1_3_1_1__1 )
            // InternalModelDraw.g:4255:2: rule__Edge__Group_7_2_1_3_1_1__0__Impl rule__Edge__Group_7_2_1_3_1_1__1
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
    // InternalModelDraw.g:4262:1: rule__Edge__Group_7_2_1_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4266:1: ( ( '->' ) )
            // InternalModelDraw.g:4267:1: ( '->' )
            {
            // InternalModelDraw.g:4267:1: ( '->' )
            // InternalModelDraw.g:4268:2: '->'
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
    // InternalModelDraw.g:4277:1: rule__Edge__Group_7_2_1_3_1_1__1 : rule__Edge__Group_7_2_1_3_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4281:1: ( rule__Edge__Group_7_2_1_3_1_1__1__Impl )
            // InternalModelDraw.g:4282:2: rule__Edge__Group_7_2_1_3_1_1__1__Impl
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
    // InternalModelDraw.g:4288:1: rule__Edge__Group_7_2_1_3_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4292:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) ) )
            // InternalModelDraw.g:4293:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            {
            // InternalModelDraw.g:4293:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            // InternalModelDraw.g:4294:2: ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_3_1_1_1()); 
            // InternalModelDraw.g:4295:2: ( rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 )
            // InternalModelDraw.g:4295:3: rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1
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
    // InternalModelDraw.g:4304:1: rule__Edge__Group_7_2_1_4__0 : rule__Edge__Group_7_2_1_4__0__Impl rule__Edge__Group_7_2_1_4__1 ;
    public final void rule__Edge__Group_7_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4308:1: ( rule__Edge__Group_7_2_1_4__0__Impl rule__Edge__Group_7_2_1_4__1 )
            // InternalModelDraw.g:4309:2: rule__Edge__Group_7_2_1_4__0__Impl rule__Edge__Group_7_2_1_4__1
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
    // InternalModelDraw.g:4316:1: rule__Edge__Group_7_2_1_4__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_7_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4320:1: ( ( ',' ) )
            // InternalModelDraw.g:4321:1: ( ',' )
            {
            // InternalModelDraw.g:4321:1: ( ',' )
            // InternalModelDraw.g:4322:2: ','
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
    // InternalModelDraw.g:4331:1: rule__Edge__Group_7_2_1_4__1 : rule__Edge__Group_7_2_1_4__1__Impl rule__Edge__Group_7_2_1_4__2 ;
    public final void rule__Edge__Group_7_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4335:1: ( rule__Edge__Group_7_2_1_4__1__Impl rule__Edge__Group_7_2_1_4__2 )
            // InternalModelDraw.g:4336:2: rule__Edge__Group_7_2_1_4__1__Impl rule__Edge__Group_7_2_1_4__2
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
    // InternalModelDraw.g:4343:1: rule__Edge__Group_7_2_1_4__1__Impl : ( ( rule__Edge__Group_7_2_1_4_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4347:1: ( ( ( rule__Edge__Group_7_2_1_4_1__0 )? ) )
            // InternalModelDraw.g:4348:1: ( ( rule__Edge__Group_7_2_1_4_1__0 )? )
            {
            // InternalModelDraw.g:4348:1: ( ( rule__Edge__Group_7_2_1_4_1__0 )? )
            // InternalModelDraw.g:4349:2: ( rule__Edge__Group_7_2_1_4_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_1()); 
            // InternalModelDraw.g:4350:2: ( rule__Edge__Group_7_2_1_4_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==35||LA48_1==44) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalModelDraw.g:4350:3: rule__Edge__Group_7_2_1_4_1__0
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
    // InternalModelDraw.g:4358:1: rule__Edge__Group_7_2_1_4__2 : rule__Edge__Group_7_2_1_4__2__Impl rule__Edge__Group_7_2_1_4__3 ;
    public final void rule__Edge__Group_7_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4362:1: ( rule__Edge__Group_7_2_1_4__2__Impl rule__Edge__Group_7_2_1_4__3 )
            // InternalModelDraw.g:4363:2: rule__Edge__Group_7_2_1_4__2__Impl rule__Edge__Group_7_2_1_4__3
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
    // InternalModelDraw.g:4370:1: rule__Edge__Group_7_2_1_4__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) ) ;
    public final void rule__Edge__Group_7_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4374:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) ) )
            // InternalModelDraw.g:4375:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) )
            {
            // InternalModelDraw.g:4375:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_2 ) )
            // InternalModelDraw.g:4376:2: ( rule__Edge__LabelAssignment_7_2_1_4_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_4_2()); 
            // InternalModelDraw.g:4377:2: ( rule__Edge__LabelAssignment_7_2_1_4_2 )
            // InternalModelDraw.g:4377:3: rule__Edge__LabelAssignment_7_2_1_4_2
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
    // InternalModelDraw.g:4385:1: rule__Edge__Group_7_2_1_4__3 : rule__Edge__Group_7_2_1_4__3__Impl ;
    public final void rule__Edge__Group_7_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4389:1: ( rule__Edge__Group_7_2_1_4__3__Impl )
            // InternalModelDraw.g:4390:2: rule__Edge__Group_7_2_1_4__3__Impl
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
    // InternalModelDraw.g:4396:1: rule__Edge__Group_7_2_1_4__3__Impl : ( ( rule__Edge__Group_7_2_1_4_3__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4400:1: ( ( ( rule__Edge__Group_7_2_1_4_3__0 )? ) )
            // InternalModelDraw.g:4401:1: ( ( rule__Edge__Group_7_2_1_4_3__0 )? )
            {
            // InternalModelDraw.g:4401:1: ( ( rule__Edge__Group_7_2_1_4_3__0 )? )
            // InternalModelDraw.g:4402:2: ( rule__Edge__Group_7_2_1_4_3__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3()); 
            // InternalModelDraw.g:4403:2: ( rule__Edge__Group_7_2_1_4_3__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==32) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalModelDraw.g:4403:3: rule__Edge__Group_7_2_1_4_3__0
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
    // InternalModelDraw.g:4412:1: rule__Edge__Group_7_2_1_4_1__0 : rule__Edge__Group_7_2_1_4_1__0__Impl rule__Edge__Group_7_2_1_4_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4416:1: ( rule__Edge__Group_7_2_1_4_1__0__Impl rule__Edge__Group_7_2_1_4_1__1 )
            // InternalModelDraw.g:4417:2: rule__Edge__Group_7_2_1_4_1__0__Impl rule__Edge__Group_7_2_1_4_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:4424:1: rule__Edge__Group_7_2_1_4_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4428:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) ) )
            // InternalModelDraw.g:4429:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) )
            {
            // InternalModelDraw.g:4429:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 ) )
            // InternalModelDraw.g:4430:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_4_1_0()); 
            // InternalModelDraw.g:4431:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_1_0 )
            // InternalModelDraw.g:4431:3: rule__Edge__ReferenceAssignment_7_2_1_4_1_0
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
    // InternalModelDraw.g:4439:1: rule__Edge__Group_7_2_1_4_1__1 : rule__Edge__Group_7_2_1_4_1__1__Impl rule__Edge__Group_7_2_1_4_1__2 ;
    public final void rule__Edge__Group_7_2_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4443:1: ( rule__Edge__Group_7_2_1_4_1__1__Impl rule__Edge__Group_7_2_1_4_1__2 )
            // InternalModelDraw.g:4444:2: rule__Edge__Group_7_2_1_4_1__1__Impl rule__Edge__Group_7_2_1_4_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:4451:1: rule__Edge__Group_7_2_1_4_1__1__Impl : ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4455:1: ( ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? ) )
            // InternalModelDraw.g:4456:1: ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? )
            {
            // InternalModelDraw.g:4456:1: ( ( rule__Edge__Group_7_2_1_4_1_1__0 )? )
            // InternalModelDraw.g:4457:2: ( rule__Edge__Group_7_2_1_4_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_1_1()); 
            // InternalModelDraw.g:4458:2: ( rule__Edge__Group_7_2_1_4_1_1__0 )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==35) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalModelDraw.g:4458:3: rule__Edge__Group_7_2_1_4_1_1__0
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
    // InternalModelDraw.g:4466:1: rule__Edge__Group_7_2_1_4_1__2 : rule__Edge__Group_7_2_1_4_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4470:1: ( rule__Edge__Group_7_2_1_4_1__2__Impl )
            // InternalModelDraw.g:4471:2: rule__Edge__Group_7_2_1_4_1__2__Impl
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
    // InternalModelDraw.g:4477:1: rule__Edge__Group_7_2_1_4_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4481:1: ( ( '.' ) )
            // InternalModelDraw.g:4482:1: ( '.' )
            {
            // InternalModelDraw.g:4482:1: ( '.' )
            // InternalModelDraw.g:4483:2: '.'
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
    // InternalModelDraw.g:4493:1: rule__Edge__Group_7_2_1_4_1_1__0 : rule__Edge__Group_7_2_1_4_1_1__0__Impl rule__Edge__Group_7_2_1_4_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4497:1: ( rule__Edge__Group_7_2_1_4_1_1__0__Impl rule__Edge__Group_7_2_1_4_1_1__1 )
            // InternalModelDraw.g:4498:2: rule__Edge__Group_7_2_1_4_1_1__0__Impl rule__Edge__Group_7_2_1_4_1_1__1
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
    // InternalModelDraw.g:4505:1: rule__Edge__Group_7_2_1_4_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4509:1: ( ( '->' ) )
            // InternalModelDraw.g:4510:1: ( '->' )
            {
            // InternalModelDraw.g:4510:1: ( '->' )
            // InternalModelDraw.g:4511:2: '->'
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
    // InternalModelDraw.g:4520:1: rule__Edge__Group_7_2_1_4_1_1__1 : rule__Edge__Group_7_2_1_4_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4524:1: ( rule__Edge__Group_7_2_1_4_1_1__1__Impl )
            // InternalModelDraw.g:4525:2: rule__Edge__Group_7_2_1_4_1_1__1__Impl
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
    // InternalModelDraw.g:4531:1: rule__Edge__Group_7_2_1_4_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4535:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) ) )
            // InternalModelDraw.g:4536:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            {
            // InternalModelDraw.g:4536:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            // InternalModelDraw.g:4537:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_4_1_1_1()); 
            // InternalModelDraw.g:4538:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 )
            // InternalModelDraw.g:4538:3: rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1
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
    // InternalModelDraw.g:4547:1: rule__Edge__Group_7_2_1_4_3__0 : rule__Edge__Group_7_2_1_4_3__0__Impl rule__Edge__Group_7_2_1_4_3__1 ;
    public final void rule__Edge__Group_7_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4551:1: ( rule__Edge__Group_7_2_1_4_3__0__Impl rule__Edge__Group_7_2_1_4_3__1 )
            // InternalModelDraw.g:4552:2: rule__Edge__Group_7_2_1_4_3__0__Impl rule__Edge__Group_7_2_1_4_3__1
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
    // InternalModelDraw.g:4559:1: rule__Edge__Group_7_2_1_4_3__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_7_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4563:1: ( ( '(' ) )
            // InternalModelDraw.g:4564:1: ( '(' )
            {
            // InternalModelDraw.g:4564:1: ( '(' )
            // InternalModelDraw.g:4565:2: '('
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
    // InternalModelDraw.g:4574:1: rule__Edge__Group_7_2_1_4_3__1 : rule__Edge__Group_7_2_1_4_3__1__Impl rule__Edge__Group_7_2_1_4_3__2 ;
    public final void rule__Edge__Group_7_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4578:1: ( rule__Edge__Group_7_2_1_4_3__1__Impl rule__Edge__Group_7_2_1_4_3__2 )
            // InternalModelDraw.g:4579:2: rule__Edge__Group_7_2_1_4_3__1__Impl rule__Edge__Group_7_2_1_4_3__2
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
    // InternalModelDraw.g:4586:1: rule__Edge__Group_7_2_1_4_3__1__Impl : ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4590:1: ( ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? ) )
            // InternalModelDraw.g:4591:1: ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? )
            {
            // InternalModelDraw.g:4591:1: ( ( rule__Edge__Group_7_2_1_4_3_1__0 )? )
            // InternalModelDraw.g:4592:2: ( rule__Edge__Group_7_2_1_4_3_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3_1()); 
            // InternalModelDraw.g:4593:2: ( rule__Edge__Group_7_2_1_4_3_1__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                int LA51_1 = input.LA(2);

                if ( (LA51_1==35||LA51_1==44) ) {
                    alt51=1;
                }
            }
            switch (alt51) {
                case 1 :
                    // InternalModelDraw.g:4593:3: rule__Edge__Group_7_2_1_4_3_1__0
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
    // InternalModelDraw.g:4601:1: rule__Edge__Group_7_2_1_4_3__2 : rule__Edge__Group_7_2_1_4_3__2__Impl rule__Edge__Group_7_2_1_4_3__3 ;
    public final void rule__Edge__Group_7_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4605:1: ( rule__Edge__Group_7_2_1_4_3__2__Impl rule__Edge__Group_7_2_1_4_3__3 )
            // InternalModelDraw.g:4606:2: rule__Edge__Group_7_2_1_4_3__2__Impl rule__Edge__Group_7_2_1_4_3__3
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
    // InternalModelDraw.g:4613:1: rule__Edge__Group_7_2_1_4_3__2__Impl : ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4617:1: ( ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) ) )
            // InternalModelDraw.g:4618:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) )
            {
            // InternalModelDraw.g:4618:1: ( ( rule__Edge__LabelAssignment_7_2_1_4_3_2 ) )
            // InternalModelDraw.g:4619:2: ( rule__Edge__LabelAssignment_7_2_1_4_3_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_7_2_1_4_3_2()); 
            // InternalModelDraw.g:4620:2: ( rule__Edge__LabelAssignment_7_2_1_4_3_2 )
            // InternalModelDraw.g:4620:3: rule__Edge__LabelAssignment_7_2_1_4_3_2
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
    // InternalModelDraw.g:4628:1: rule__Edge__Group_7_2_1_4_3__3 : rule__Edge__Group_7_2_1_4_3__3__Impl ;
    public final void rule__Edge__Group_7_2_1_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4632:1: ( rule__Edge__Group_7_2_1_4_3__3__Impl )
            // InternalModelDraw.g:4633:2: rule__Edge__Group_7_2_1_4_3__3__Impl
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
    // InternalModelDraw.g:4639:1: rule__Edge__Group_7_2_1_4_3__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_7_2_1_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4643:1: ( ( ')' ) )
            // InternalModelDraw.g:4644:1: ( ')' )
            {
            // InternalModelDraw.g:4644:1: ( ')' )
            // InternalModelDraw.g:4645:2: ')'
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
    // InternalModelDraw.g:4655:1: rule__Edge__Group_7_2_1_4_3_1__0 : rule__Edge__Group_7_2_1_4_3_1__0__Impl rule__Edge__Group_7_2_1_4_3_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4659:1: ( rule__Edge__Group_7_2_1_4_3_1__0__Impl rule__Edge__Group_7_2_1_4_3_1__1 )
            // InternalModelDraw.g:4660:2: rule__Edge__Group_7_2_1_4_3_1__0__Impl rule__Edge__Group_7_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:4667:1: rule__Edge__Group_7_2_1_4_3_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4671:1: ( ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) ) )
            // InternalModelDraw.g:4672:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            {
            // InternalModelDraw.g:4672:1: ( ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            // InternalModelDraw.g:4673:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_7_2_1_4_3_1_0()); 
            // InternalModelDraw.g:4674:2: ( rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 )
            // InternalModelDraw.g:4674:3: rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0
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
    // InternalModelDraw.g:4682:1: rule__Edge__Group_7_2_1_4_3_1__1 : rule__Edge__Group_7_2_1_4_3_1__1__Impl rule__Edge__Group_7_2_1_4_3_1__2 ;
    public final void rule__Edge__Group_7_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4686:1: ( rule__Edge__Group_7_2_1_4_3_1__1__Impl rule__Edge__Group_7_2_1_4_3_1__2 )
            // InternalModelDraw.g:4687:2: rule__Edge__Group_7_2_1_4_3_1__1__Impl rule__Edge__Group_7_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:4694:1: rule__Edge__Group_7_2_1_4_3_1__1__Impl : ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4698:1: ( ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? ) )
            // InternalModelDraw.g:4699:1: ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? )
            {
            // InternalModelDraw.g:4699:1: ( ( rule__Edge__Group_7_2_1_4_3_1_1__0 )? )
            // InternalModelDraw.g:4700:2: ( rule__Edge__Group_7_2_1_4_3_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_7_2_1_4_3_1_1()); 
            // InternalModelDraw.g:4701:2: ( rule__Edge__Group_7_2_1_4_3_1_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==35) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalModelDraw.g:4701:3: rule__Edge__Group_7_2_1_4_3_1_1__0
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
    // InternalModelDraw.g:4709:1: rule__Edge__Group_7_2_1_4_3_1__2 : rule__Edge__Group_7_2_1_4_3_1__2__Impl ;
    public final void rule__Edge__Group_7_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4713:1: ( rule__Edge__Group_7_2_1_4_3_1__2__Impl )
            // InternalModelDraw.g:4714:2: rule__Edge__Group_7_2_1_4_3_1__2__Impl
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
    // InternalModelDraw.g:4720:1: rule__Edge__Group_7_2_1_4_3_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4724:1: ( ( '.' ) )
            // InternalModelDraw.g:4725:1: ( '.' )
            {
            // InternalModelDraw.g:4725:1: ( '.' )
            // InternalModelDraw.g:4726:2: '.'
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
    // InternalModelDraw.g:4736:1: rule__Edge__Group_7_2_1_4_3_1_1__0 : rule__Edge__Group_7_2_1_4_3_1_1__0__Impl rule__Edge__Group_7_2_1_4_3_1_1__1 ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4740:1: ( rule__Edge__Group_7_2_1_4_3_1_1__0__Impl rule__Edge__Group_7_2_1_4_3_1_1__1 )
            // InternalModelDraw.g:4741:2: rule__Edge__Group_7_2_1_4_3_1_1__0__Impl rule__Edge__Group_7_2_1_4_3_1_1__1
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
    // InternalModelDraw.g:4748:1: rule__Edge__Group_7_2_1_4_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4752:1: ( ( '->' ) )
            // InternalModelDraw.g:4753:1: ( '->' )
            {
            // InternalModelDraw.g:4753:1: ( '->' )
            // InternalModelDraw.g:4754:2: '->'
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
    // InternalModelDraw.g:4763:1: rule__Edge__Group_7_2_1_4_3_1_1__1 : rule__Edge__Group_7_2_1_4_3_1_1__1__Impl ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4767:1: ( rule__Edge__Group_7_2_1_4_3_1_1__1__Impl )
            // InternalModelDraw.g:4768:2: rule__Edge__Group_7_2_1_4_3_1_1__1__Impl
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
    // InternalModelDraw.g:4774:1: rule__Edge__Group_7_2_1_4_3_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) ;
    public final void rule__Edge__Group_7_2_1_4_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4778:1: ( ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) )
            // InternalModelDraw.g:4779:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            {
            // InternalModelDraw.g:4779:1: ( ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            // InternalModelDraw.g:4780:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_7_2_1_4_3_1_1_1()); 
            // InternalModelDraw.g:4781:2: ( rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            // InternalModelDraw.g:4781:3: rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1
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
    // InternalModelDraw.g:4790:1: rule__Edge__Group_8__0 : rule__Edge__Group_8__0__Impl rule__Edge__Group_8__1 ;
    public final void rule__Edge__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4794:1: ( rule__Edge__Group_8__0__Impl rule__Edge__Group_8__1 )
            // InternalModelDraw.g:4795:2: rule__Edge__Group_8__0__Impl rule__Edge__Group_8__1
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
    // InternalModelDraw.g:4802:1: rule__Edge__Group_8__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Edge__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4806:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:4807:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:4807:1: ( 'src_decoration' )
            // InternalModelDraw.g:4808:2: 'src_decoration'
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
    // InternalModelDraw.g:4817:1: rule__Edge__Group_8__1 : rule__Edge__Group_8__1__Impl rule__Edge__Group_8__2 ;
    public final void rule__Edge__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4821:1: ( rule__Edge__Group_8__1__Impl rule__Edge__Group_8__2 )
            // InternalModelDraw.g:4822:2: rule__Edge__Group_8__1__Impl rule__Edge__Group_8__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:4829:1: rule__Edge__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4833:1: ( ( '=' ) )
            // InternalModelDraw.g:4834:1: ( '=' )
            {
            // InternalModelDraw.g:4834:1: ( '=' )
            // InternalModelDraw.g:4835:2: '='
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
    // InternalModelDraw.g:4844:1: rule__Edge__Group_8__2 : rule__Edge__Group_8__2__Impl ;
    public final void rule__Edge__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4848:1: ( rule__Edge__Group_8__2__Impl )
            // InternalModelDraw.g:4849:2: rule__Edge__Group_8__2__Impl
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
    // InternalModelDraw.g:4855:1: rule__Edge__Group_8__2__Impl : ( ( rule__Edge__Src_decorationAssignment_8_2 ) ) ;
    public final void rule__Edge__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4859:1: ( ( ( rule__Edge__Src_decorationAssignment_8_2 ) ) )
            // InternalModelDraw.g:4860:1: ( ( rule__Edge__Src_decorationAssignment_8_2 ) )
            {
            // InternalModelDraw.g:4860:1: ( ( rule__Edge__Src_decorationAssignment_8_2 ) )
            // InternalModelDraw.g:4861:2: ( rule__Edge__Src_decorationAssignment_8_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationAssignment_8_2()); 
            // InternalModelDraw.g:4862:2: ( rule__Edge__Src_decorationAssignment_8_2 )
            // InternalModelDraw.g:4862:3: rule__Edge__Src_decorationAssignment_8_2
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
    // InternalModelDraw.g:4871:1: rule__Edge__Group_9__0 : rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 ;
    public final void rule__Edge__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4875:1: ( rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 )
            // InternalModelDraw.g:4876:2: rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1
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
    // InternalModelDraw.g:4883:1: rule__Edge__Group_9__0__Impl : ( 'src_label' ) ;
    public final void rule__Edge__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4887:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:4888:1: ( 'src_label' )
            {
            // InternalModelDraw.g:4888:1: ( 'src_label' )
            // InternalModelDraw.g:4889:2: 'src_label'
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
    // InternalModelDraw.g:4898:1: rule__Edge__Group_9__1 : rule__Edge__Group_9__1__Impl rule__Edge__Group_9__2 ;
    public final void rule__Edge__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4902:1: ( rule__Edge__Group_9__1__Impl rule__Edge__Group_9__2 )
            // InternalModelDraw.g:4903:2: rule__Edge__Group_9__1__Impl rule__Edge__Group_9__2
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
    // InternalModelDraw.g:4910:1: rule__Edge__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4914:1: ( ( '=' ) )
            // InternalModelDraw.g:4915:1: ( '=' )
            {
            // InternalModelDraw.g:4915:1: ( '=' )
            // InternalModelDraw.g:4916:2: '='
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
    // InternalModelDraw.g:4925:1: rule__Edge__Group_9__2 : rule__Edge__Group_9__2__Impl ;
    public final void rule__Edge__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4929:1: ( rule__Edge__Group_9__2__Impl )
            // InternalModelDraw.g:4930:2: rule__Edge__Group_9__2__Impl
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
    // InternalModelDraw.g:4936:1: rule__Edge__Group_9__2__Impl : ( ( rule__Edge__Src_labelAssignment_9_2 ) ) ;
    public final void rule__Edge__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4940:1: ( ( ( rule__Edge__Src_labelAssignment_9_2 ) ) )
            // InternalModelDraw.g:4941:1: ( ( rule__Edge__Src_labelAssignment_9_2 ) )
            {
            // InternalModelDraw.g:4941:1: ( ( rule__Edge__Src_labelAssignment_9_2 ) )
            // InternalModelDraw.g:4942:2: ( rule__Edge__Src_labelAssignment_9_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelAssignment_9_2()); 
            // InternalModelDraw.g:4943:2: ( rule__Edge__Src_labelAssignment_9_2 )
            // InternalModelDraw.g:4943:3: rule__Edge__Src_labelAssignment_9_2
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
    // InternalModelDraw.g:4952:1: rule__Edge__Group_10__0 : rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 ;
    public final void rule__Edge__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4956:1: ( rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 )
            // InternalModelDraw.g:4957:2: rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1
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
    // InternalModelDraw.g:4964:1: rule__Edge__Group_10__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Edge__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4968:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:4969:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:4969:1: ( 'tar_decoration' )
            // InternalModelDraw.g:4970:2: 'tar_decoration'
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
    // InternalModelDraw.g:4979:1: rule__Edge__Group_10__1 : rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 ;
    public final void rule__Edge__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4983:1: ( rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 )
            // InternalModelDraw.g:4984:2: rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:4991:1: rule__Edge__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4995:1: ( ( '=' ) )
            // InternalModelDraw.g:4996:1: ( '=' )
            {
            // InternalModelDraw.g:4996:1: ( '=' )
            // InternalModelDraw.g:4997:2: '='
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
    // InternalModelDraw.g:5006:1: rule__Edge__Group_10__2 : rule__Edge__Group_10__2__Impl ;
    public final void rule__Edge__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5010:1: ( rule__Edge__Group_10__2__Impl )
            // InternalModelDraw.g:5011:2: rule__Edge__Group_10__2__Impl
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
    // InternalModelDraw.g:5017:1: rule__Edge__Group_10__2__Impl : ( ( rule__Edge__Tar_decorationAssignment_10_2 ) ) ;
    public final void rule__Edge__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5021:1: ( ( ( rule__Edge__Tar_decorationAssignment_10_2 ) ) )
            // InternalModelDraw.g:5022:1: ( ( rule__Edge__Tar_decorationAssignment_10_2 ) )
            {
            // InternalModelDraw.g:5022:1: ( ( rule__Edge__Tar_decorationAssignment_10_2 ) )
            // InternalModelDraw.g:5023:2: ( rule__Edge__Tar_decorationAssignment_10_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationAssignment_10_2()); 
            // InternalModelDraw.g:5024:2: ( rule__Edge__Tar_decorationAssignment_10_2 )
            // InternalModelDraw.g:5024:3: rule__Edge__Tar_decorationAssignment_10_2
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
    // InternalModelDraw.g:5033:1: rule__Edge__Group_11__0 : rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 ;
    public final void rule__Edge__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5037:1: ( rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 )
            // InternalModelDraw.g:5038:2: rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1
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
    // InternalModelDraw.g:5045:1: rule__Edge__Group_11__0__Impl : ( 'tar_label' ) ;
    public final void rule__Edge__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5049:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:5050:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:5050:1: ( 'tar_label' )
            // InternalModelDraw.g:5051:2: 'tar_label'
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
    // InternalModelDraw.g:5060:1: rule__Edge__Group_11__1 : rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 ;
    public final void rule__Edge__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5064:1: ( rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 )
            // InternalModelDraw.g:5065:2: rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2
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
    // InternalModelDraw.g:5072:1: rule__Edge__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5076:1: ( ( '=' ) )
            // InternalModelDraw.g:5077:1: ( '=' )
            {
            // InternalModelDraw.g:5077:1: ( '=' )
            // InternalModelDraw.g:5078:2: '='
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
    // InternalModelDraw.g:5087:1: rule__Edge__Group_11__2 : rule__Edge__Group_11__2__Impl ;
    public final void rule__Edge__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5091:1: ( rule__Edge__Group_11__2__Impl )
            // InternalModelDraw.g:5092:2: rule__Edge__Group_11__2__Impl
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
    // InternalModelDraw.g:5098:1: rule__Edge__Group_11__2__Impl : ( ( rule__Edge__Tar_labelAssignment_11_2 ) ) ;
    public final void rule__Edge__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5102:1: ( ( ( rule__Edge__Tar_labelAssignment_11_2 ) ) )
            // InternalModelDraw.g:5103:1: ( ( rule__Edge__Tar_labelAssignment_11_2 ) )
            {
            // InternalModelDraw.g:5103:1: ( ( rule__Edge__Tar_labelAssignment_11_2 ) )
            // InternalModelDraw.g:5104:2: ( rule__Edge__Tar_labelAssignment_11_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelAssignment_11_2()); 
            // InternalModelDraw.g:5105:2: ( rule__Edge__Tar_labelAssignment_11_2 )
            // InternalModelDraw.g:5105:3: rule__Edge__Tar_labelAssignment_11_2
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
    // InternalModelDraw.g:5114:1: rule__Level__Group__0 : rule__Level__Group__0__Impl rule__Level__Group__1 ;
    public final void rule__Level__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5118:1: ( rule__Level__Group__0__Impl rule__Level__Group__1 )
            // InternalModelDraw.g:5119:2: rule__Level__Group__0__Impl rule__Level__Group__1
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
    // InternalModelDraw.g:5126:1: rule__Level__Group__0__Impl : ( () ) ;
    public final void rule__Level__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5130:1: ( ( () ) )
            // InternalModelDraw.g:5131:1: ( () )
            {
            // InternalModelDraw.g:5131:1: ( () )
            // InternalModelDraw.g:5132:2: ()
            {
             before(grammarAccess.getLevelAccess().getLevelAction_0()); 
            // InternalModelDraw.g:5133:2: ()
            // InternalModelDraw.g:5133:3: 
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
    // InternalModelDraw.g:5141:1: rule__Level__Group__1 : rule__Level__Group__1__Impl rule__Level__Group__2 ;
    public final void rule__Level__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5145:1: ( rule__Level__Group__1__Impl rule__Level__Group__2 )
            // InternalModelDraw.g:5146:2: rule__Level__Group__1__Impl rule__Level__Group__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalModelDraw.g:5153:1: rule__Level__Group__1__Impl : ( ( rule__Level__NameAssignment_1 ) ) ;
    public final void rule__Level__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5157:1: ( ( ( rule__Level__NameAssignment_1 ) ) )
            // InternalModelDraw.g:5158:1: ( ( rule__Level__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:5158:1: ( ( rule__Level__NameAssignment_1 ) )
            // InternalModelDraw.g:5159:2: ( rule__Level__NameAssignment_1 )
            {
             before(grammarAccess.getLevelAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:5160:2: ( rule__Level__NameAssignment_1 )
            // InternalModelDraw.g:5160:3: rule__Level__NameAssignment_1
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
    // InternalModelDraw.g:5168:1: rule__Level__Group__2 : rule__Level__Group__2__Impl rule__Level__Group__3 ;
    public final void rule__Level__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5172:1: ( rule__Level__Group__2__Impl rule__Level__Group__3 )
            // InternalModelDraw.g:5173:2: rule__Level__Group__2__Impl rule__Level__Group__3
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
    // InternalModelDraw.g:5180:1: rule__Level__Group__2__Impl : ( '.' ) ;
    public final void rule__Level__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5184:1: ( ( '.' ) )
            // InternalModelDraw.g:5185:1: ( '.' )
            {
            // InternalModelDraw.g:5185:1: ( '.' )
            // InternalModelDraw.g:5186:2: '.'
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
    // InternalModelDraw.g:5195:1: rule__Level__Group__3 : rule__Level__Group__3__Impl rule__Level__Group__4 ;
    public final void rule__Level__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5199:1: ( rule__Level__Group__3__Impl rule__Level__Group__4 )
            // InternalModelDraw.g:5200:2: rule__Level__Group__3__Impl rule__Level__Group__4
            {
            pushFollow(FOLLOW_7);
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
    // InternalModelDraw.g:5207:1: rule__Level__Group__3__Impl : ( ( rule__Level__UpperAssignment_3 ) ) ;
    public final void rule__Level__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5211:1: ( ( ( rule__Level__UpperAssignment_3 ) ) )
            // InternalModelDraw.g:5212:1: ( ( rule__Level__UpperAssignment_3 ) )
            {
            // InternalModelDraw.g:5212:1: ( ( rule__Level__UpperAssignment_3 ) )
            // InternalModelDraw.g:5213:2: ( rule__Level__UpperAssignment_3 )
            {
             before(grammarAccess.getLevelAccess().getUpperAssignment_3()); 
            // InternalModelDraw.g:5214:2: ( rule__Level__UpperAssignment_3 )
            // InternalModelDraw.g:5214:3: rule__Level__UpperAssignment_3
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
    // InternalModelDraw.g:5222:1: rule__Level__Group__4 : rule__Level__Group__4__Impl rule__Level__Group__5 ;
    public final void rule__Level__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5226:1: ( rule__Level__Group__4__Impl rule__Level__Group__5 )
            // InternalModelDraw.g:5227:2: rule__Level__Group__4__Impl rule__Level__Group__5
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
    // InternalModelDraw.g:5234:1: rule__Level__Group__4__Impl : ( ':' ) ;
    public final void rule__Level__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5238:1: ( ( ':' ) )
            // InternalModelDraw.g:5239:1: ( ':' )
            {
            // InternalModelDraw.g:5239:1: ( ':' )
            // InternalModelDraw.g:5240:2: ':'
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
    // InternalModelDraw.g:5249:1: rule__Level__Group__5 : rule__Level__Group__5__Impl rule__Level__Group__6 ;
    public final void rule__Level__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5253:1: ( rule__Level__Group__5__Impl rule__Level__Group__6 )
            // InternalModelDraw.g:5254:2: rule__Level__Group__5__Impl rule__Level__Group__6
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
    // InternalModelDraw.g:5261:1: rule__Level__Group__5__Impl : ( 'edge' ) ;
    public final void rule__Level__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5265:1: ( ( 'edge' ) )
            // InternalModelDraw.g:5266:1: ( 'edge' )
            {
            // InternalModelDraw.g:5266:1: ( 'edge' )
            // InternalModelDraw.g:5267:2: 'edge'
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
    // InternalModelDraw.g:5276:1: rule__Level__Group__6 : rule__Level__Group__6__Impl rule__Level__Group__7 ;
    public final void rule__Level__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5280:1: ( rule__Level__Group__6__Impl rule__Level__Group__7 )
            // InternalModelDraw.g:5281:2: rule__Level__Group__6__Impl rule__Level__Group__7
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
    // InternalModelDraw.g:5288:1: rule__Level__Group__6__Impl : ( ( rule__Level__Group_6__0 )? ) ;
    public final void rule__Level__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5292:1: ( ( ( rule__Level__Group_6__0 )? ) )
            // InternalModelDraw.g:5293:1: ( ( rule__Level__Group_6__0 )? )
            {
            // InternalModelDraw.g:5293:1: ( ( rule__Level__Group_6__0 )? )
            // InternalModelDraw.g:5294:2: ( rule__Level__Group_6__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_6()); 
            // InternalModelDraw.g:5295:2: ( rule__Level__Group_6__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==36) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalModelDraw.g:5295:3: rule__Level__Group_6__0
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
    // InternalModelDraw.g:5303:1: rule__Level__Group__7 : rule__Level__Group__7__Impl rule__Level__Group__8 ;
    public final void rule__Level__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5307:1: ( rule__Level__Group__7__Impl rule__Level__Group__8 )
            // InternalModelDraw.g:5308:2: rule__Level__Group__7__Impl rule__Level__Group__8
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
    // InternalModelDraw.g:5315:1: rule__Level__Group__7__Impl : ( ( rule__Level__Group_7__0 )? ) ;
    public final void rule__Level__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5319:1: ( ( ( rule__Level__Group_7__0 )? ) )
            // InternalModelDraw.g:5320:1: ( ( rule__Level__Group_7__0 )? )
            {
            // InternalModelDraw.g:5320:1: ( ( rule__Level__Group_7__0 )? )
            // InternalModelDraw.g:5321:2: ( rule__Level__Group_7__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7()); 
            // InternalModelDraw.g:5322:2: ( rule__Level__Group_7__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==43) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // InternalModelDraw.g:5322:3: rule__Level__Group_7__0
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
    // InternalModelDraw.g:5330:1: rule__Level__Group__8 : rule__Level__Group__8__Impl rule__Level__Group__9 ;
    public final void rule__Level__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5334:1: ( rule__Level__Group__8__Impl rule__Level__Group__9 )
            // InternalModelDraw.g:5335:2: rule__Level__Group__8__Impl rule__Level__Group__9
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
    // InternalModelDraw.g:5342:1: rule__Level__Group__8__Impl : ( ( rule__Level__Group_8__0 )? ) ;
    public final void rule__Level__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5346:1: ( ( ( rule__Level__Group_8__0 )? ) )
            // InternalModelDraw.g:5347:1: ( ( rule__Level__Group_8__0 )? )
            {
            // InternalModelDraw.g:5347:1: ( ( rule__Level__Group_8__0 )? )
            // InternalModelDraw.g:5348:2: ( rule__Level__Group_8__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_8()); 
            // InternalModelDraw.g:5349:2: ( rule__Level__Group_8__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==45) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalModelDraw.g:5349:3: rule__Level__Group_8__0
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
    // InternalModelDraw.g:5357:1: rule__Level__Group__9 : rule__Level__Group__9__Impl rule__Level__Group__10 ;
    public final void rule__Level__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5361:1: ( rule__Level__Group__9__Impl rule__Level__Group__10 )
            // InternalModelDraw.g:5362:2: rule__Level__Group__9__Impl rule__Level__Group__10
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
    // InternalModelDraw.g:5369:1: rule__Level__Group__9__Impl : ( ( rule__Level__Group_9__0 )? ) ;
    public final void rule__Level__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5373:1: ( ( ( rule__Level__Group_9__0 )? ) )
            // InternalModelDraw.g:5374:1: ( ( rule__Level__Group_9__0 )? )
            {
            // InternalModelDraw.g:5374:1: ( ( rule__Level__Group_9__0 )? )
            // InternalModelDraw.g:5375:2: ( rule__Level__Group_9__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_9()); 
            // InternalModelDraw.g:5376:2: ( rule__Level__Group_9__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==46) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalModelDraw.g:5376:3: rule__Level__Group_9__0
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
    // InternalModelDraw.g:5384:1: rule__Level__Group__10 : rule__Level__Group__10__Impl rule__Level__Group__11 ;
    public final void rule__Level__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5388:1: ( rule__Level__Group__10__Impl rule__Level__Group__11 )
            // InternalModelDraw.g:5389:2: rule__Level__Group__10__Impl rule__Level__Group__11
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
    // InternalModelDraw.g:5396:1: rule__Level__Group__10__Impl : ( ( rule__Level__Group_10__0 )? ) ;
    public final void rule__Level__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5400:1: ( ( ( rule__Level__Group_10__0 )? ) )
            // InternalModelDraw.g:5401:1: ( ( rule__Level__Group_10__0 )? )
            {
            // InternalModelDraw.g:5401:1: ( ( rule__Level__Group_10__0 )? )
            // InternalModelDraw.g:5402:2: ( rule__Level__Group_10__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_10()); 
            // InternalModelDraw.g:5403:2: ( rule__Level__Group_10__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==47) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalModelDraw.g:5403:3: rule__Level__Group_10__0
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
    // InternalModelDraw.g:5411:1: rule__Level__Group__11 : rule__Level__Group__11__Impl ;
    public final void rule__Level__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5415:1: ( rule__Level__Group__11__Impl )
            // InternalModelDraw.g:5416:2: rule__Level__Group__11__Impl
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
    // InternalModelDraw.g:5422:1: rule__Level__Group__11__Impl : ( ( rule__Level__Group_11__0 )? ) ;
    public final void rule__Level__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5426:1: ( ( ( rule__Level__Group_11__0 )? ) )
            // InternalModelDraw.g:5427:1: ( ( rule__Level__Group_11__0 )? )
            {
            // InternalModelDraw.g:5427:1: ( ( rule__Level__Group_11__0 )? )
            // InternalModelDraw.g:5428:2: ( rule__Level__Group_11__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_11()); 
            // InternalModelDraw.g:5429:2: ( rule__Level__Group_11__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==48) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalModelDraw.g:5429:3: rule__Level__Group_11__0
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
    // InternalModelDraw.g:5438:1: rule__Level__Group_6__0 : rule__Level__Group_6__0__Impl rule__Level__Group_6__1 ;
    public final void rule__Level__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5442:1: ( rule__Level__Group_6__0__Impl rule__Level__Group_6__1 )
            // InternalModelDraw.g:5443:2: rule__Level__Group_6__0__Impl rule__Level__Group_6__1
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
    // InternalModelDraw.g:5450:1: rule__Level__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Level__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5454:1: ( ( '=' ) )
            // InternalModelDraw.g:5455:1: ( '=' )
            {
            // InternalModelDraw.g:5455:1: ( '=' )
            // InternalModelDraw.g:5456:2: '='
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
    // InternalModelDraw.g:5465:1: rule__Level__Group_6__1 : rule__Level__Group_6__1__Impl ;
    public final void rule__Level__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5469:1: ( rule__Level__Group_6__1__Impl )
            // InternalModelDraw.g:5470:2: rule__Level__Group_6__1__Impl
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
    // InternalModelDraw.g:5476:1: rule__Level__Group_6__1__Impl : ( ( rule__Level__AttNameAssignment_6_1 ) ) ;
    public final void rule__Level__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5480:1: ( ( ( rule__Level__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:5481:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:5481:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:5482:2: ( rule__Level__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getLevelAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:5483:2: ( rule__Level__AttNameAssignment_6_1 )
            // InternalModelDraw.g:5483:3: rule__Level__AttNameAssignment_6_1
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
    // InternalModelDraw.g:5492:1: rule__Level__Group_7__0 : rule__Level__Group_7__0__Impl rule__Level__Group_7__1 ;
    public final void rule__Level__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5496:1: ( rule__Level__Group_7__0__Impl rule__Level__Group_7__1 )
            // InternalModelDraw.g:5497:2: rule__Level__Group_7__0__Impl rule__Level__Group_7__1
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
    // InternalModelDraw.g:5504:1: rule__Level__Group_7__0__Impl : ( 'label' ) ;
    public final void rule__Level__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5508:1: ( ( 'label' ) )
            // InternalModelDraw.g:5509:1: ( 'label' )
            {
            // InternalModelDraw.g:5509:1: ( 'label' )
            // InternalModelDraw.g:5510:2: 'label'
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
    // InternalModelDraw.g:5519:1: rule__Level__Group_7__1 : rule__Level__Group_7__1__Impl rule__Level__Group_7__2 ;
    public final void rule__Level__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5523:1: ( rule__Level__Group_7__1__Impl rule__Level__Group_7__2 )
            // InternalModelDraw.g:5524:2: rule__Level__Group_7__1__Impl rule__Level__Group_7__2
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:5531:1: rule__Level__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5535:1: ( ( '=' ) )
            // InternalModelDraw.g:5536:1: ( '=' )
            {
            // InternalModelDraw.g:5536:1: ( '=' )
            // InternalModelDraw.g:5537:2: '='
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
    // InternalModelDraw.g:5546:1: rule__Level__Group_7__2 : rule__Level__Group_7__2__Impl ;
    public final void rule__Level__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5550:1: ( rule__Level__Group_7__2__Impl )
            // InternalModelDraw.g:5551:2: rule__Level__Group_7__2__Impl
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
    // InternalModelDraw.g:5557:1: rule__Level__Group_7__2__Impl : ( ( rule__Level__Alternatives_7_2 ) ) ;
    public final void rule__Level__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5561:1: ( ( ( rule__Level__Alternatives_7_2 ) ) )
            // InternalModelDraw.g:5562:1: ( ( rule__Level__Alternatives_7_2 ) )
            {
            // InternalModelDraw.g:5562:1: ( ( rule__Level__Alternatives_7_2 ) )
            // InternalModelDraw.g:5563:2: ( rule__Level__Alternatives_7_2 )
            {
             before(grammarAccess.getLevelAccess().getAlternatives_7_2()); 
            // InternalModelDraw.g:5564:2: ( rule__Level__Alternatives_7_2 )
            // InternalModelDraw.g:5564:3: rule__Level__Alternatives_7_2
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
    // InternalModelDraw.g:5573:1: rule__Level__Group_7_2_0__0 : rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1 ;
    public final void rule__Level__Group_7_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5577:1: ( rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1 )
            // InternalModelDraw.g:5578:2: rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1
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
    // InternalModelDraw.g:5585:1: rule__Level__Group_7_2_0__0__Impl : ( ( rule__Level__Group_7_2_0_0__0 )? ) ;
    public final void rule__Level__Group_7_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5589:1: ( ( ( rule__Level__Group_7_2_0_0__0 )? ) )
            // InternalModelDraw.g:5590:1: ( ( rule__Level__Group_7_2_0_0__0 )? )
            {
            // InternalModelDraw.g:5590:1: ( ( rule__Level__Group_7_2_0_0__0 )? )
            // InternalModelDraw.g:5591:2: ( rule__Level__Group_7_2_0_0__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_0_0()); 
            // InternalModelDraw.g:5592:2: ( rule__Level__Group_7_2_0_0__0 )?
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
                    // InternalModelDraw.g:5592:3: rule__Level__Group_7_2_0_0__0
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
    // InternalModelDraw.g:5600:1: rule__Level__Group_7_2_0__1 : rule__Level__Group_7_2_0__1__Impl ;
    public final void rule__Level__Group_7_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5604:1: ( rule__Level__Group_7_2_0__1__Impl )
            // InternalModelDraw.g:5605:2: rule__Level__Group_7_2_0__1__Impl
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
    // InternalModelDraw.g:5611:1: rule__Level__Group_7_2_0__1__Impl : ( ( rule__Level__LabelAssignment_7_2_0_1 ) ) ;
    public final void rule__Level__Group_7_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5615:1: ( ( ( rule__Level__LabelAssignment_7_2_0_1 ) ) )
            // InternalModelDraw.g:5616:1: ( ( rule__Level__LabelAssignment_7_2_0_1 ) )
            {
            // InternalModelDraw.g:5616:1: ( ( rule__Level__LabelAssignment_7_2_0_1 ) )
            // InternalModelDraw.g:5617:2: ( rule__Level__LabelAssignment_7_2_0_1 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_0_1()); 
            // InternalModelDraw.g:5618:2: ( rule__Level__LabelAssignment_7_2_0_1 )
            // InternalModelDraw.g:5618:3: rule__Level__LabelAssignment_7_2_0_1
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
    // InternalModelDraw.g:5627:1: rule__Level__Group_7_2_0_0__0 : rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1 ;
    public final void rule__Level__Group_7_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5631:1: ( rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1 )
            // InternalModelDraw.g:5632:2: rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:5639:1: rule__Level__Group_7_2_0_0__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) ) ;
    public final void rule__Level__Group_7_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5643:1: ( ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) ) )
            // InternalModelDraw.g:5644:1: ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) )
            {
            // InternalModelDraw.g:5644:1: ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) )
            // InternalModelDraw.g:5645:2: ( rule__Level__ReferenceAssignment_7_2_0_0_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_0_0_0()); 
            // InternalModelDraw.g:5646:2: ( rule__Level__ReferenceAssignment_7_2_0_0_0 )
            // InternalModelDraw.g:5646:3: rule__Level__ReferenceAssignment_7_2_0_0_0
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
    // InternalModelDraw.g:5654:1: rule__Level__Group_7_2_0_0__1 : rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2 ;
    public final void rule__Level__Group_7_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5658:1: ( rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2 )
            // InternalModelDraw.g:5659:2: rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:5666:1: rule__Level__Group_7_2_0_0__1__Impl : ( ( rule__Level__Group_7_2_0_0_1__0 )? ) ;
    public final void rule__Level__Group_7_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5670:1: ( ( ( rule__Level__Group_7_2_0_0_1__0 )? ) )
            // InternalModelDraw.g:5671:1: ( ( rule__Level__Group_7_2_0_0_1__0 )? )
            {
            // InternalModelDraw.g:5671:1: ( ( rule__Level__Group_7_2_0_0_1__0 )? )
            // InternalModelDraw.g:5672:2: ( rule__Level__Group_7_2_0_0_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_0_0_1()); 
            // InternalModelDraw.g:5673:2: ( rule__Level__Group_7_2_0_0_1__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==35) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalModelDraw.g:5673:3: rule__Level__Group_7_2_0_0_1__0
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
    // InternalModelDraw.g:5681:1: rule__Level__Group_7_2_0_0__2 : rule__Level__Group_7_2_0_0__2__Impl ;
    public final void rule__Level__Group_7_2_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5685:1: ( rule__Level__Group_7_2_0_0__2__Impl )
            // InternalModelDraw.g:5686:2: rule__Level__Group_7_2_0_0__2__Impl
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
    // InternalModelDraw.g:5692:1: rule__Level__Group_7_2_0_0__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5696:1: ( ( '.' ) )
            // InternalModelDraw.g:5697:1: ( '.' )
            {
            // InternalModelDraw.g:5697:1: ( '.' )
            // InternalModelDraw.g:5698:2: '.'
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
    // InternalModelDraw.g:5708:1: rule__Level__Group_7_2_0_0_1__0 : rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1 ;
    public final void rule__Level__Group_7_2_0_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5712:1: ( rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1 )
            // InternalModelDraw.g:5713:2: rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1
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
    // InternalModelDraw.g:5720:1: rule__Level__Group_7_2_0_0_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_0_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5724:1: ( ( '->' ) )
            // InternalModelDraw.g:5725:1: ( '->' )
            {
            // InternalModelDraw.g:5725:1: ( '->' )
            // InternalModelDraw.g:5726:2: '->'
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
    // InternalModelDraw.g:5735:1: rule__Level__Group_7_2_0_0_1__1 : rule__Level__Group_7_2_0_0_1__1__Impl ;
    public final void rule__Level__Group_7_2_0_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5739:1: ( rule__Level__Group_7_2_0_0_1__1__Impl )
            // InternalModelDraw.g:5740:2: rule__Level__Group_7_2_0_0_1__1__Impl
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
    // InternalModelDraw.g:5746:1: rule__Level__Group_7_2_0_0_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) ) ;
    public final void rule__Level__Group_7_2_0_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5750:1: ( ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) ) )
            // InternalModelDraw.g:5751:1: ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) )
            {
            // InternalModelDraw.g:5751:1: ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) )
            // InternalModelDraw.g:5752:2: ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_0_0_1_1()); 
            // InternalModelDraw.g:5753:2: ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 )
            // InternalModelDraw.g:5753:3: rule__Level__RefTypeAssignment_7_2_0_0_1_1
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
    // InternalModelDraw.g:5762:1: rule__Level__Group_7_2_1__0 : rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1 ;
    public final void rule__Level__Group_7_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5766:1: ( rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1 )
            // InternalModelDraw.g:5767:2: rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1
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
    // InternalModelDraw.g:5774:1: rule__Level__Group_7_2_1__0__Impl : ( '{' ) ;
    public final void rule__Level__Group_7_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5778:1: ( ( '{' ) )
            // InternalModelDraw.g:5779:1: ( '{' )
            {
            // InternalModelDraw.g:5779:1: ( '{' )
            // InternalModelDraw.g:5780:2: '{'
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
    // InternalModelDraw.g:5789:1: rule__Level__Group_7_2_1__1 : rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2 ;
    public final void rule__Level__Group_7_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5793:1: ( rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2 )
            // InternalModelDraw.g:5794:2: rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2
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
    // InternalModelDraw.g:5801:1: rule__Level__Group_7_2_1__1__Impl : ( ( rule__Level__Group_7_2_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5805:1: ( ( ( rule__Level__Group_7_2_1_1__0 )? ) )
            // InternalModelDraw.g:5806:1: ( ( rule__Level__Group_7_2_1_1__0 )? )
            {
            // InternalModelDraw.g:5806:1: ( ( rule__Level__Group_7_2_1_1__0 )? )
            // InternalModelDraw.g:5807:2: ( rule__Level__Group_7_2_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_1()); 
            // InternalModelDraw.g:5808:2: ( rule__Level__Group_7_2_1_1__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_ID) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==35||LA61_1==44) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // InternalModelDraw.g:5808:3: rule__Level__Group_7_2_1_1__0
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
    // InternalModelDraw.g:5816:1: rule__Level__Group_7_2_1__2 : rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3 ;
    public final void rule__Level__Group_7_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5820:1: ( rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3 )
            // InternalModelDraw.g:5821:2: rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:5828:1: rule__Level__Group_7_2_1__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_2 ) ) ;
    public final void rule__Level__Group_7_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5832:1: ( ( ( rule__Level__LabelAssignment_7_2_1_2 ) ) )
            // InternalModelDraw.g:5833:1: ( ( rule__Level__LabelAssignment_7_2_1_2 ) )
            {
            // InternalModelDraw.g:5833:1: ( ( rule__Level__LabelAssignment_7_2_1_2 ) )
            // InternalModelDraw.g:5834:2: ( rule__Level__LabelAssignment_7_2_1_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_2()); 
            // InternalModelDraw.g:5835:2: ( rule__Level__LabelAssignment_7_2_1_2 )
            // InternalModelDraw.g:5835:3: rule__Level__LabelAssignment_7_2_1_2
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
    // InternalModelDraw.g:5843:1: rule__Level__Group_7_2_1__3 : rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4 ;
    public final void rule__Level__Group_7_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5847:1: ( rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4 )
            // InternalModelDraw.g:5848:2: rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:5855:1: rule__Level__Group_7_2_1__3__Impl : ( ( rule__Level__Group_7_2_1_3__0 )? ) ;
    public final void rule__Level__Group_7_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5859:1: ( ( ( rule__Level__Group_7_2_1_3__0 )? ) )
            // InternalModelDraw.g:5860:1: ( ( rule__Level__Group_7_2_1_3__0 )? )
            {
            // InternalModelDraw.g:5860:1: ( ( rule__Level__Group_7_2_1_3__0 )? )
            // InternalModelDraw.g:5861:2: ( rule__Level__Group_7_2_1_3__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3()); 
            // InternalModelDraw.g:5862:2: ( rule__Level__Group_7_2_1_3__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==32) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalModelDraw.g:5862:3: rule__Level__Group_7_2_1_3__0
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
    // InternalModelDraw.g:5870:1: rule__Level__Group_7_2_1__4 : rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5 ;
    public final void rule__Level__Group_7_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5874:1: ( rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5 )
            // InternalModelDraw.g:5875:2: rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:5882:1: rule__Level__Group_7_2_1__4__Impl : ( ( rule__Level__Group_7_2_1_4__0 )* ) ;
    public final void rule__Level__Group_7_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5886:1: ( ( ( rule__Level__Group_7_2_1_4__0 )* ) )
            // InternalModelDraw.g:5887:1: ( ( rule__Level__Group_7_2_1_4__0 )* )
            {
            // InternalModelDraw.g:5887:1: ( ( rule__Level__Group_7_2_1_4__0 )* )
            // InternalModelDraw.g:5888:2: ( rule__Level__Group_7_2_1_4__0 )*
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4()); 
            // InternalModelDraw.g:5889:2: ( rule__Level__Group_7_2_1_4__0 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==34) ) {
                    alt63=1;
                }


                switch (alt63) {
            	case 1 :
            	    // InternalModelDraw.g:5889:3: rule__Level__Group_7_2_1_4__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Level__Group_7_2_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // InternalModelDraw.g:5897:1: rule__Level__Group_7_2_1__5 : rule__Level__Group_7_2_1__5__Impl ;
    public final void rule__Level__Group_7_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5901:1: ( rule__Level__Group_7_2_1__5__Impl )
            // InternalModelDraw.g:5902:2: rule__Level__Group_7_2_1__5__Impl
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
    // InternalModelDraw.g:5908:1: rule__Level__Group_7_2_1__5__Impl : ( '}' ) ;
    public final void rule__Level__Group_7_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5912:1: ( ( '}' ) )
            // InternalModelDraw.g:5913:1: ( '}' )
            {
            // InternalModelDraw.g:5913:1: ( '}' )
            // InternalModelDraw.g:5914:2: '}'
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
    // InternalModelDraw.g:5924:1: rule__Level__Group_7_2_1_1__0 : rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1 ;
    public final void rule__Level__Group_7_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5928:1: ( rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1 )
            // InternalModelDraw.g:5929:2: rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:5936:1: rule__Level__Group_7_2_1_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5940:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) ) )
            // InternalModelDraw.g:5941:1: ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) )
            {
            // InternalModelDraw.g:5941:1: ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) )
            // InternalModelDraw.g:5942:2: ( rule__Level__ReferenceAssignment_7_2_1_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_1_0()); 
            // InternalModelDraw.g:5943:2: ( rule__Level__ReferenceAssignment_7_2_1_1_0 )
            // InternalModelDraw.g:5943:3: rule__Level__ReferenceAssignment_7_2_1_1_0
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
    // InternalModelDraw.g:5951:1: rule__Level__Group_7_2_1_1__1 : rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2 ;
    public final void rule__Level__Group_7_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5955:1: ( rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2 )
            // InternalModelDraw.g:5956:2: rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:5963:1: rule__Level__Group_7_2_1_1__1__Impl : ( ( rule__Level__Group_7_2_1_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5967:1: ( ( ( rule__Level__Group_7_2_1_1_1__0 )? ) )
            // InternalModelDraw.g:5968:1: ( ( rule__Level__Group_7_2_1_1_1__0 )? )
            {
            // InternalModelDraw.g:5968:1: ( ( rule__Level__Group_7_2_1_1_1__0 )? )
            // InternalModelDraw.g:5969:2: ( rule__Level__Group_7_2_1_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_1_1()); 
            // InternalModelDraw.g:5970:2: ( rule__Level__Group_7_2_1_1_1__0 )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==35) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalModelDraw.g:5970:3: rule__Level__Group_7_2_1_1_1__0
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
    // InternalModelDraw.g:5978:1: rule__Level__Group_7_2_1_1__2 : rule__Level__Group_7_2_1_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5982:1: ( rule__Level__Group_7_2_1_1__2__Impl )
            // InternalModelDraw.g:5983:2: rule__Level__Group_7_2_1_1__2__Impl
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
    // InternalModelDraw.g:5989:1: rule__Level__Group_7_2_1_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5993:1: ( ( '.' ) )
            // InternalModelDraw.g:5994:1: ( '.' )
            {
            // InternalModelDraw.g:5994:1: ( '.' )
            // InternalModelDraw.g:5995:2: '.'
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
    // InternalModelDraw.g:6005:1: rule__Level__Group_7_2_1_1_1__0 : rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1 ;
    public final void rule__Level__Group_7_2_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6009:1: ( rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1 )
            // InternalModelDraw.g:6010:2: rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1
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
    // InternalModelDraw.g:6017:1: rule__Level__Group_7_2_1_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6021:1: ( ( '->' ) )
            // InternalModelDraw.g:6022:1: ( '->' )
            {
            // InternalModelDraw.g:6022:1: ( '->' )
            // InternalModelDraw.g:6023:2: '->'
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
    // InternalModelDraw.g:6032:1: rule__Level__Group_7_2_1_1_1__1 : rule__Level__Group_7_2_1_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6036:1: ( rule__Level__Group_7_2_1_1_1__1__Impl )
            // InternalModelDraw.g:6037:2: rule__Level__Group_7_2_1_1_1__1__Impl
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
    // InternalModelDraw.g:6043:1: rule__Level__Group_7_2_1_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6047:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) ) )
            // InternalModelDraw.g:6048:1: ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) )
            {
            // InternalModelDraw.g:6048:1: ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) )
            // InternalModelDraw.g:6049:2: ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_1_1_1()); 
            // InternalModelDraw.g:6050:2: ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 )
            // InternalModelDraw.g:6050:3: rule__Level__RefTypeAssignment_7_2_1_1_1_1
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
    // InternalModelDraw.g:6059:1: rule__Level__Group_7_2_1_3__0 : rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1 ;
    public final void rule__Level__Group_7_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6063:1: ( rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1 )
            // InternalModelDraw.g:6064:2: rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1
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
    // InternalModelDraw.g:6071:1: rule__Level__Group_7_2_1_3__0__Impl : ( '(' ) ;
    public final void rule__Level__Group_7_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6075:1: ( ( '(' ) )
            // InternalModelDraw.g:6076:1: ( '(' )
            {
            // InternalModelDraw.g:6076:1: ( '(' )
            // InternalModelDraw.g:6077:2: '('
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
    // InternalModelDraw.g:6086:1: rule__Level__Group_7_2_1_3__1 : rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2 ;
    public final void rule__Level__Group_7_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6090:1: ( rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2 )
            // InternalModelDraw.g:6091:2: rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2
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
    // InternalModelDraw.g:6098:1: rule__Level__Group_7_2_1_3__1__Impl : ( ( rule__Level__Group_7_2_1_3_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6102:1: ( ( ( rule__Level__Group_7_2_1_3_1__0 )? ) )
            // InternalModelDraw.g:6103:1: ( ( rule__Level__Group_7_2_1_3_1__0 )? )
            {
            // InternalModelDraw.g:6103:1: ( ( rule__Level__Group_7_2_1_3_1__0 )? )
            // InternalModelDraw.g:6104:2: ( rule__Level__Group_7_2_1_3_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1()); 
            // InternalModelDraw.g:6105:2: ( rule__Level__Group_7_2_1_3_1__0 )?
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
                    // InternalModelDraw.g:6105:3: rule__Level__Group_7_2_1_3_1__0
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
    // InternalModelDraw.g:6113:1: rule__Level__Group_7_2_1_3__2 : rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3 ;
    public final void rule__Level__Group_7_2_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6117:1: ( rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3 )
            // InternalModelDraw.g:6118:2: rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3
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
    // InternalModelDraw.g:6125:1: rule__Level__Group_7_2_1_3__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) ) ;
    public final void rule__Level__Group_7_2_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6129:1: ( ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) ) )
            // InternalModelDraw.g:6130:1: ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) )
            {
            // InternalModelDraw.g:6130:1: ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) )
            // InternalModelDraw.g:6131:2: ( rule__Level__LabelAssignment_7_2_1_3_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_3_2()); 
            // InternalModelDraw.g:6132:2: ( rule__Level__LabelAssignment_7_2_1_3_2 )
            // InternalModelDraw.g:6132:3: rule__Level__LabelAssignment_7_2_1_3_2
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
    // InternalModelDraw.g:6140:1: rule__Level__Group_7_2_1_3__3 : rule__Level__Group_7_2_1_3__3__Impl ;
    public final void rule__Level__Group_7_2_1_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6144:1: ( rule__Level__Group_7_2_1_3__3__Impl )
            // InternalModelDraw.g:6145:2: rule__Level__Group_7_2_1_3__3__Impl
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
    // InternalModelDraw.g:6151:1: rule__Level__Group_7_2_1_3__3__Impl : ( ')' ) ;
    public final void rule__Level__Group_7_2_1_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6155:1: ( ( ')' ) )
            // InternalModelDraw.g:6156:1: ( ')' )
            {
            // InternalModelDraw.g:6156:1: ( ')' )
            // InternalModelDraw.g:6157:2: ')'
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
    // InternalModelDraw.g:6167:1: rule__Level__Group_7_2_1_3_1__0 : rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1 ;
    public final void rule__Level__Group_7_2_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6171:1: ( rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1 )
            // InternalModelDraw.g:6172:2: rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:6179:1: rule__Level__Group_7_2_1_3_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6183:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) ) )
            // InternalModelDraw.g:6184:1: ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) )
            {
            // InternalModelDraw.g:6184:1: ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) )
            // InternalModelDraw.g:6185:2: ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_3_1_0()); 
            // InternalModelDraw.g:6186:2: ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 )
            // InternalModelDraw.g:6186:3: rule__Level__ReferenceAssignment_7_2_1_3_1_0
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
    // InternalModelDraw.g:6194:1: rule__Level__Group_7_2_1_3_1__1 : rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2 ;
    public final void rule__Level__Group_7_2_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6198:1: ( rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2 )
            // InternalModelDraw.g:6199:2: rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:6206:1: rule__Level__Group_7_2_1_3_1__1__Impl : ( ( rule__Level__Group_7_2_1_3_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6210:1: ( ( ( rule__Level__Group_7_2_1_3_1_1__0 )? ) )
            // InternalModelDraw.g:6211:1: ( ( rule__Level__Group_7_2_1_3_1_1__0 )? )
            {
            // InternalModelDraw.g:6211:1: ( ( rule__Level__Group_7_2_1_3_1_1__0 )? )
            // InternalModelDraw.g:6212:2: ( rule__Level__Group_7_2_1_3_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1_1()); 
            // InternalModelDraw.g:6213:2: ( rule__Level__Group_7_2_1_3_1_1__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==35) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalModelDraw.g:6213:3: rule__Level__Group_7_2_1_3_1_1__0
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
    // InternalModelDraw.g:6221:1: rule__Level__Group_7_2_1_3_1__2 : rule__Level__Group_7_2_1_3_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6225:1: ( rule__Level__Group_7_2_1_3_1__2__Impl )
            // InternalModelDraw.g:6226:2: rule__Level__Group_7_2_1_3_1__2__Impl
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
    // InternalModelDraw.g:6232:1: rule__Level__Group_7_2_1_3_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6236:1: ( ( '.' ) )
            // InternalModelDraw.g:6237:1: ( '.' )
            {
            // InternalModelDraw.g:6237:1: ( '.' )
            // InternalModelDraw.g:6238:2: '.'
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
    // InternalModelDraw.g:6248:1: rule__Level__Group_7_2_1_3_1_1__0 : rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1 ;
    public final void rule__Level__Group_7_2_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6252:1: ( rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1 )
            // InternalModelDraw.g:6253:2: rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1
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
    // InternalModelDraw.g:6260:1: rule__Level__Group_7_2_1_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6264:1: ( ( '->' ) )
            // InternalModelDraw.g:6265:1: ( '->' )
            {
            // InternalModelDraw.g:6265:1: ( '->' )
            // InternalModelDraw.g:6266:2: '->'
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
    // InternalModelDraw.g:6275:1: rule__Level__Group_7_2_1_3_1_1__1 : rule__Level__Group_7_2_1_3_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6279:1: ( rule__Level__Group_7_2_1_3_1_1__1__Impl )
            // InternalModelDraw.g:6280:2: rule__Level__Group_7_2_1_3_1_1__1__Impl
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
    // InternalModelDraw.g:6286:1: rule__Level__Group_7_2_1_3_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6290:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) ) )
            // InternalModelDraw.g:6291:1: ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            {
            // InternalModelDraw.g:6291:1: ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            // InternalModelDraw.g:6292:2: ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_3_1_1_1()); 
            // InternalModelDraw.g:6293:2: ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 )
            // InternalModelDraw.g:6293:3: rule__Level__RefTypeAssignment_7_2_1_3_1_1_1
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
    // InternalModelDraw.g:6302:1: rule__Level__Group_7_2_1_4__0 : rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1 ;
    public final void rule__Level__Group_7_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6306:1: ( rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1 )
            // InternalModelDraw.g:6307:2: rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1
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
    // InternalModelDraw.g:6314:1: rule__Level__Group_7_2_1_4__0__Impl : ( ',' ) ;
    public final void rule__Level__Group_7_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6318:1: ( ( ',' ) )
            // InternalModelDraw.g:6319:1: ( ',' )
            {
            // InternalModelDraw.g:6319:1: ( ',' )
            // InternalModelDraw.g:6320:2: ','
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
    // InternalModelDraw.g:6329:1: rule__Level__Group_7_2_1_4__1 : rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2 ;
    public final void rule__Level__Group_7_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6333:1: ( rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2 )
            // InternalModelDraw.g:6334:2: rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2
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
    // InternalModelDraw.g:6341:1: rule__Level__Group_7_2_1_4__1__Impl : ( ( rule__Level__Group_7_2_1_4_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6345:1: ( ( ( rule__Level__Group_7_2_1_4_1__0 )? ) )
            // InternalModelDraw.g:6346:1: ( ( rule__Level__Group_7_2_1_4_1__0 )? )
            {
            // InternalModelDraw.g:6346:1: ( ( rule__Level__Group_7_2_1_4_1__0 )? )
            // InternalModelDraw.g:6347:2: ( rule__Level__Group_7_2_1_4_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1()); 
            // InternalModelDraw.g:6348:2: ( rule__Level__Group_7_2_1_4_1__0 )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==35||LA67_1==44) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // InternalModelDraw.g:6348:3: rule__Level__Group_7_2_1_4_1__0
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
    // InternalModelDraw.g:6356:1: rule__Level__Group_7_2_1_4__2 : rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3 ;
    public final void rule__Level__Group_7_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6360:1: ( rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3 )
            // InternalModelDraw.g:6361:2: rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3
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
    // InternalModelDraw.g:6368:1: rule__Level__Group_7_2_1_4__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) ) ;
    public final void rule__Level__Group_7_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6372:1: ( ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) ) )
            // InternalModelDraw.g:6373:1: ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) )
            {
            // InternalModelDraw.g:6373:1: ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) )
            // InternalModelDraw.g:6374:2: ( rule__Level__LabelAssignment_7_2_1_4_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_2()); 
            // InternalModelDraw.g:6375:2: ( rule__Level__LabelAssignment_7_2_1_4_2 )
            // InternalModelDraw.g:6375:3: rule__Level__LabelAssignment_7_2_1_4_2
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
    // InternalModelDraw.g:6383:1: rule__Level__Group_7_2_1_4__3 : rule__Level__Group_7_2_1_4__3__Impl ;
    public final void rule__Level__Group_7_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6387:1: ( rule__Level__Group_7_2_1_4__3__Impl )
            // InternalModelDraw.g:6388:2: rule__Level__Group_7_2_1_4__3__Impl
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
    // InternalModelDraw.g:6394:1: rule__Level__Group_7_2_1_4__3__Impl : ( ( rule__Level__Group_7_2_1_4_3__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6398:1: ( ( ( rule__Level__Group_7_2_1_4_3__0 )? ) )
            // InternalModelDraw.g:6399:1: ( ( rule__Level__Group_7_2_1_4_3__0 )? )
            {
            // InternalModelDraw.g:6399:1: ( ( rule__Level__Group_7_2_1_4_3__0 )? )
            // InternalModelDraw.g:6400:2: ( rule__Level__Group_7_2_1_4_3__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3()); 
            // InternalModelDraw.g:6401:2: ( rule__Level__Group_7_2_1_4_3__0 )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==32) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalModelDraw.g:6401:3: rule__Level__Group_7_2_1_4_3__0
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
    // InternalModelDraw.g:6410:1: rule__Level__Group_7_2_1_4_1__0 : rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1 ;
    public final void rule__Level__Group_7_2_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6414:1: ( rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1 )
            // InternalModelDraw.g:6415:2: rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:6422:1: rule__Level__Group_7_2_1_4_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6426:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) ) )
            // InternalModelDraw.g:6427:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) )
            {
            // InternalModelDraw.g:6427:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) )
            // InternalModelDraw.g:6428:2: ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_1_0()); 
            // InternalModelDraw.g:6429:2: ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 )
            // InternalModelDraw.g:6429:3: rule__Level__ReferenceAssignment_7_2_1_4_1_0
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
    // InternalModelDraw.g:6437:1: rule__Level__Group_7_2_1_4_1__1 : rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2 ;
    public final void rule__Level__Group_7_2_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6441:1: ( rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2 )
            // InternalModelDraw.g:6442:2: rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:6449:1: rule__Level__Group_7_2_1_4_1__1__Impl : ( ( rule__Level__Group_7_2_1_4_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6453:1: ( ( ( rule__Level__Group_7_2_1_4_1_1__0 )? ) )
            // InternalModelDraw.g:6454:1: ( ( rule__Level__Group_7_2_1_4_1_1__0 )? )
            {
            // InternalModelDraw.g:6454:1: ( ( rule__Level__Group_7_2_1_4_1_1__0 )? )
            // InternalModelDraw.g:6455:2: ( rule__Level__Group_7_2_1_4_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1_1()); 
            // InternalModelDraw.g:6456:2: ( rule__Level__Group_7_2_1_4_1_1__0 )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==35) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // InternalModelDraw.g:6456:3: rule__Level__Group_7_2_1_4_1_1__0
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
    // InternalModelDraw.g:6464:1: rule__Level__Group_7_2_1_4_1__2 : rule__Level__Group_7_2_1_4_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6468:1: ( rule__Level__Group_7_2_1_4_1__2__Impl )
            // InternalModelDraw.g:6469:2: rule__Level__Group_7_2_1_4_1__2__Impl
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
    // InternalModelDraw.g:6475:1: rule__Level__Group_7_2_1_4_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6479:1: ( ( '.' ) )
            // InternalModelDraw.g:6480:1: ( '.' )
            {
            // InternalModelDraw.g:6480:1: ( '.' )
            // InternalModelDraw.g:6481:2: '.'
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
    // InternalModelDraw.g:6491:1: rule__Level__Group_7_2_1_4_1_1__0 : rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1 ;
    public final void rule__Level__Group_7_2_1_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6495:1: ( rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1 )
            // InternalModelDraw.g:6496:2: rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1
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
    // InternalModelDraw.g:6503:1: rule__Level__Group_7_2_1_4_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6507:1: ( ( '->' ) )
            // InternalModelDraw.g:6508:1: ( '->' )
            {
            // InternalModelDraw.g:6508:1: ( '->' )
            // InternalModelDraw.g:6509:2: '->'
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
    // InternalModelDraw.g:6518:1: rule__Level__Group_7_2_1_4_1_1__1 : rule__Level__Group_7_2_1_4_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6522:1: ( rule__Level__Group_7_2_1_4_1_1__1__Impl )
            // InternalModelDraw.g:6523:2: rule__Level__Group_7_2_1_4_1_1__1__Impl
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
    // InternalModelDraw.g:6529:1: rule__Level__Group_7_2_1_4_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6533:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) ) )
            // InternalModelDraw.g:6534:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            {
            // InternalModelDraw.g:6534:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            // InternalModelDraw.g:6535:2: ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_1_1_1()); 
            // InternalModelDraw.g:6536:2: ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 )
            // InternalModelDraw.g:6536:3: rule__Level__RefTypeAssignment_7_2_1_4_1_1_1
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
    // InternalModelDraw.g:6545:1: rule__Level__Group_7_2_1_4_3__0 : rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1 ;
    public final void rule__Level__Group_7_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6549:1: ( rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1 )
            // InternalModelDraw.g:6550:2: rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1
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
    // InternalModelDraw.g:6557:1: rule__Level__Group_7_2_1_4_3__0__Impl : ( '(' ) ;
    public final void rule__Level__Group_7_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6561:1: ( ( '(' ) )
            // InternalModelDraw.g:6562:1: ( '(' )
            {
            // InternalModelDraw.g:6562:1: ( '(' )
            // InternalModelDraw.g:6563:2: '('
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
    // InternalModelDraw.g:6572:1: rule__Level__Group_7_2_1_4_3__1 : rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2 ;
    public final void rule__Level__Group_7_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6576:1: ( rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2 )
            // InternalModelDraw.g:6577:2: rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2
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
    // InternalModelDraw.g:6584:1: rule__Level__Group_7_2_1_4_3__1__Impl : ( ( rule__Level__Group_7_2_1_4_3_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6588:1: ( ( ( rule__Level__Group_7_2_1_4_3_1__0 )? ) )
            // InternalModelDraw.g:6589:1: ( ( rule__Level__Group_7_2_1_4_3_1__0 )? )
            {
            // InternalModelDraw.g:6589:1: ( ( rule__Level__Group_7_2_1_4_3_1__0 )? )
            // InternalModelDraw.g:6590:2: ( rule__Level__Group_7_2_1_4_3_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1()); 
            // InternalModelDraw.g:6591:2: ( rule__Level__Group_7_2_1_4_3_1__0 )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==35||LA70_1==44) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // InternalModelDraw.g:6591:3: rule__Level__Group_7_2_1_4_3_1__0
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
    // InternalModelDraw.g:6599:1: rule__Level__Group_7_2_1_4_3__2 : rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3 ;
    public final void rule__Level__Group_7_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6603:1: ( rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3 )
            // InternalModelDraw.g:6604:2: rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3
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
    // InternalModelDraw.g:6611:1: rule__Level__Group_7_2_1_4_3__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6615:1: ( ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) ) )
            // InternalModelDraw.g:6616:1: ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) )
            {
            // InternalModelDraw.g:6616:1: ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) )
            // InternalModelDraw.g:6617:2: ( rule__Level__LabelAssignment_7_2_1_4_3_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_3_2()); 
            // InternalModelDraw.g:6618:2: ( rule__Level__LabelAssignment_7_2_1_4_3_2 )
            // InternalModelDraw.g:6618:3: rule__Level__LabelAssignment_7_2_1_4_3_2
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
    // InternalModelDraw.g:6626:1: rule__Level__Group_7_2_1_4_3__3 : rule__Level__Group_7_2_1_4_3__3__Impl ;
    public final void rule__Level__Group_7_2_1_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6630:1: ( rule__Level__Group_7_2_1_4_3__3__Impl )
            // InternalModelDraw.g:6631:2: rule__Level__Group_7_2_1_4_3__3__Impl
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
    // InternalModelDraw.g:6637:1: rule__Level__Group_7_2_1_4_3__3__Impl : ( ')' ) ;
    public final void rule__Level__Group_7_2_1_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6641:1: ( ( ')' ) )
            // InternalModelDraw.g:6642:1: ( ')' )
            {
            // InternalModelDraw.g:6642:1: ( ')' )
            // InternalModelDraw.g:6643:2: ')'
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
    // InternalModelDraw.g:6653:1: rule__Level__Group_7_2_1_4_3_1__0 : rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1 ;
    public final void rule__Level__Group_7_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6657:1: ( rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1 )
            // InternalModelDraw.g:6658:2: rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:6665:1: rule__Level__Group_7_2_1_4_3_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6669:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) ) )
            // InternalModelDraw.g:6670:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            {
            // InternalModelDraw.g:6670:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            // InternalModelDraw.g:6671:2: ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_3_1_0()); 
            // InternalModelDraw.g:6672:2: ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 )
            // InternalModelDraw.g:6672:3: rule__Level__ReferenceAssignment_7_2_1_4_3_1_0
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
    // InternalModelDraw.g:6680:1: rule__Level__Group_7_2_1_4_3_1__1 : rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2 ;
    public final void rule__Level__Group_7_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6684:1: ( rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2 )
            // InternalModelDraw.g:6685:2: rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:6692:1: rule__Level__Group_7_2_1_4_3_1__1__Impl : ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6696:1: ( ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? ) )
            // InternalModelDraw.g:6697:1: ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? )
            {
            // InternalModelDraw.g:6697:1: ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? )
            // InternalModelDraw.g:6698:2: ( rule__Level__Group_7_2_1_4_3_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1_1()); 
            // InternalModelDraw.g:6699:2: ( rule__Level__Group_7_2_1_4_3_1_1__0 )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==35) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalModelDraw.g:6699:3: rule__Level__Group_7_2_1_4_3_1_1__0
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
    // InternalModelDraw.g:6707:1: rule__Level__Group_7_2_1_4_3_1__2 : rule__Level__Group_7_2_1_4_3_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6711:1: ( rule__Level__Group_7_2_1_4_3_1__2__Impl )
            // InternalModelDraw.g:6712:2: rule__Level__Group_7_2_1_4_3_1__2__Impl
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
    // InternalModelDraw.g:6718:1: rule__Level__Group_7_2_1_4_3_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6722:1: ( ( '.' ) )
            // InternalModelDraw.g:6723:1: ( '.' )
            {
            // InternalModelDraw.g:6723:1: ( '.' )
            // InternalModelDraw.g:6724:2: '.'
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
    // InternalModelDraw.g:6734:1: rule__Level__Group_7_2_1_4_3_1_1__0 : rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1 ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6738:1: ( rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1 )
            // InternalModelDraw.g:6739:2: rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1
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
    // InternalModelDraw.g:6746:1: rule__Level__Group_7_2_1_4_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6750:1: ( ( '->' ) )
            // InternalModelDraw.g:6751:1: ( '->' )
            {
            // InternalModelDraw.g:6751:1: ( '->' )
            // InternalModelDraw.g:6752:2: '->'
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
    // InternalModelDraw.g:6761:1: rule__Level__Group_7_2_1_4_3_1_1__1 : rule__Level__Group_7_2_1_4_3_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6765:1: ( rule__Level__Group_7_2_1_4_3_1_1__1__Impl )
            // InternalModelDraw.g:6766:2: rule__Level__Group_7_2_1_4_3_1_1__1__Impl
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
    // InternalModelDraw.g:6772:1: rule__Level__Group_7_2_1_4_3_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6776:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) )
            // InternalModelDraw.g:6777:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            {
            // InternalModelDraw.g:6777:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            // InternalModelDraw.g:6778:2: ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_3_1_1_1()); 
            // InternalModelDraw.g:6779:2: ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            // InternalModelDraw.g:6779:3: rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1
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
    // InternalModelDraw.g:6788:1: rule__Level__Group_8__0 : rule__Level__Group_8__0__Impl rule__Level__Group_8__1 ;
    public final void rule__Level__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6792:1: ( rule__Level__Group_8__0__Impl rule__Level__Group_8__1 )
            // InternalModelDraw.g:6793:2: rule__Level__Group_8__0__Impl rule__Level__Group_8__1
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
    // InternalModelDraw.g:6800:1: rule__Level__Group_8__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Level__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6804:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:6805:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:6805:1: ( 'src_decoration' )
            // InternalModelDraw.g:6806:2: 'src_decoration'
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
    // InternalModelDraw.g:6815:1: rule__Level__Group_8__1 : rule__Level__Group_8__1__Impl rule__Level__Group_8__2 ;
    public final void rule__Level__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6819:1: ( rule__Level__Group_8__1__Impl rule__Level__Group_8__2 )
            // InternalModelDraw.g:6820:2: rule__Level__Group_8__1__Impl rule__Level__Group_8__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:6827:1: rule__Level__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6831:1: ( ( '=' ) )
            // InternalModelDraw.g:6832:1: ( '=' )
            {
            // InternalModelDraw.g:6832:1: ( '=' )
            // InternalModelDraw.g:6833:2: '='
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
    // InternalModelDraw.g:6842:1: rule__Level__Group_8__2 : rule__Level__Group_8__2__Impl ;
    public final void rule__Level__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6846:1: ( rule__Level__Group_8__2__Impl )
            // InternalModelDraw.g:6847:2: rule__Level__Group_8__2__Impl
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
    // InternalModelDraw.g:6853:1: rule__Level__Group_8__2__Impl : ( ( rule__Level__Src_decorationAssignment_8_2 ) ) ;
    public final void rule__Level__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6857:1: ( ( ( rule__Level__Src_decorationAssignment_8_2 ) ) )
            // InternalModelDraw.g:6858:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            {
            // InternalModelDraw.g:6858:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            // InternalModelDraw.g:6859:2: ( rule__Level__Src_decorationAssignment_8_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationAssignment_8_2()); 
            // InternalModelDraw.g:6860:2: ( rule__Level__Src_decorationAssignment_8_2 )
            // InternalModelDraw.g:6860:3: rule__Level__Src_decorationAssignment_8_2
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
    // InternalModelDraw.g:6869:1: rule__Level__Group_9__0 : rule__Level__Group_9__0__Impl rule__Level__Group_9__1 ;
    public final void rule__Level__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6873:1: ( rule__Level__Group_9__0__Impl rule__Level__Group_9__1 )
            // InternalModelDraw.g:6874:2: rule__Level__Group_9__0__Impl rule__Level__Group_9__1
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
    // InternalModelDraw.g:6881:1: rule__Level__Group_9__0__Impl : ( 'src_label' ) ;
    public final void rule__Level__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6885:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:6886:1: ( 'src_label' )
            {
            // InternalModelDraw.g:6886:1: ( 'src_label' )
            // InternalModelDraw.g:6887:2: 'src_label'
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
    // InternalModelDraw.g:6896:1: rule__Level__Group_9__1 : rule__Level__Group_9__1__Impl rule__Level__Group_9__2 ;
    public final void rule__Level__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6900:1: ( rule__Level__Group_9__1__Impl rule__Level__Group_9__2 )
            // InternalModelDraw.g:6901:2: rule__Level__Group_9__1__Impl rule__Level__Group_9__2
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
    // InternalModelDraw.g:6908:1: rule__Level__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6912:1: ( ( '=' ) )
            // InternalModelDraw.g:6913:1: ( '=' )
            {
            // InternalModelDraw.g:6913:1: ( '=' )
            // InternalModelDraw.g:6914:2: '='
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
    // InternalModelDraw.g:6923:1: rule__Level__Group_9__2 : rule__Level__Group_9__2__Impl ;
    public final void rule__Level__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6927:1: ( rule__Level__Group_9__2__Impl )
            // InternalModelDraw.g:6928:2: rule__Level__Group_9__2__Impl
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
    // InternalModelDraw.g:6934:1: rule__Level__Group_9__2__Impl : ( ( rule__Level__Src_labelAssignment_9_2 ) ) ;
    public final void rule__Level__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6938:1: ( ( ( rule__Level__Src_labelAssignment_9_2 ) ) )
            // InternalModelDraw.g:6939:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            {
            // InternalModelDraw.g:6939:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            // InternalModelDraw.g:6940:2: ( rule__Level__Src_labelAssignment_9_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelAssignment_9_2()); 
            // InternalModelDraw.g:6941:2: ( rule__Level__Src_labelAssignment_9_2 )
            // InternalModelDraw.g:6941:3: rule__Level__Src_labelAssignment_9_2
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
    // InternalModelDraw.g:6950:1: rule__Level__Group_10__0 : rule__Level__Group_10__0__Impl rule__Level__Group_10__1 ;
    public final void rule__Level__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6954:1: ( rule__Level__Group_10__0__Impl rule__Level__Group_10__1 )
            // InternalModelDraw.g:6955:2: rule__Level__Group_10__0__Impl rule__Level__Group_10__1
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
    // InternalModelDraw.g:6962:1: rule__Level__Group_10__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Level__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6966:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:6967:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:6967:1: ( 'tar_decoration' )
            // InternalModelDraw.g:6968:2: 'tar_decoration'
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
    // InternalModelDraw.g:6977:1: rule__Level__Group_10__1 : rule__Level__Group_10__1__Impl rule__Level__Group_10__2 ;
    public final void rule__Level__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6981:1: ( rule__Level__Group_10__1__Impl rule__Level__Group_10__2 )
            // InternalModelDraw.g:6982:2: rule__Level__Group_10__1__Impl rule__Level__Group_10__2
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:6989:1: rule__Level__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6993:1: ( ( '=' ) )
            // InternalModelDraw.g:6994:1: ( '=' )
            {
            // InternalModelDraw.g:6994:1: ( '=' )
            // InternalModelDraw.g:6995:2: '='
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
    // InternalModelDraw.g:7004:1: rule__Level__Group_10__2 : rule__Level__Group_10__2__Impl ;
    public final void rule__Level__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7008:1: ( rule__Level__Group_10__2__Impl )
            // InternalModelDraw.g:7009:2: rule__Level__Group_10__2__Impl
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
    // InternalModelDraw.g:7015:1: rule__Level__Group_10__2__Impl : ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) ;
    public final void rule__Level__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7019:1: ( ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) )
            // InternalModelDraw.g:7020:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            {
            // InternalModelDraw.g:7020:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            // InternalModelDraw.g:7021:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_decorationAssignment_10_2()); 
            // InternalModelDraw.g:7022:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            // InternalModelDraw.g:7022:3: rule__Level__Tar_decorationAssignment_10_2
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
    // InternalModelDraw.g:7031:1: rule__Level__Group_11__0 : rule__Level__Group_11__0__Impl rule__Level__Group_11__1 ;
    public final void rule__Level__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7035:1: ( rule__Level__Group_11__0__Impl rule__Level__Group_11__1 )
            // InternalModelDraw.g:7036:2: rule__Level__Group_11__0__Impl rule__Level__Group_11__1
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
    // InternalModelDraw.g:7043:1: rule__Level__Group_11__0__Impl : ( 'tar_label' ) ;
    public final void rule__Level__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7047:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:7048:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:7048:1: ( 'tar_label' )
            // InternalModelDraw.g:7049:2: 'tar_label'
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
    // InternalModelDraw.g:7058:1: rule__Level__Group_11__1 : rule__Level__Group_11__1__Impl rule__Level__Group_11__2 ;
    public final void rule__Level__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7062:1: ( rule__Level__Group_11__1__Impl rule__Level__Group_11__2 )
            // InternalModelDraw.g:7063:2: rule__Level__Group_11__1__Impl rule__Level__Group_11__2
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
    // InternalModelDraw.g:7070:1: rule__Level__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7074:1: ( ( '=' ) )
            // InternalModelDraw.g:7075:1: ( '=' )
            {
            // InternalModelDraw.g:7075:1: ( '=' )
            // InternalModelDraw.g:7076:2: '='
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
    // InternalModelDraw.g:7085:1: rule__Level__Group_11__2 : rule__Level__Group_11__2__Impl ;
    public final void rule__Level__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7089:1: ( rule__Level__Group_11__2__Impl )
            // InternalModelDraw.g:7090:2: rule__Level__Group_11__2__Impl
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
    // InternalModelDraw.g:7096:1: rule__Level__Group_11__2__Impl : ( ( rule__Level__Tar_labelAssignment_11_2 ) ) ;
    public final void rule__Level__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7100:1: ( ( ( rule__Level__Tar_labelAssignment_11_2 ) ) )
            // InternalModelDraw.g:7101:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            {
            // InternalModelDraw.g:7101:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            // InternalModelDraw.g:7102:2: ( rule__Level__Tar_labelAssignment_11_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_labelAssignment_11_2()); 
            // InternalModelDraw.g:7103:2: ( rule__Level__Tar_labelAssignment_11_2 )
            // InternalModelDraw.g:7103:3: rule__Level__Tar_labelAssignment_11_2
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
    // InternalModelDraw.g:7112:1: rule__Content__Group__0 : rule__Content__Group__0__Impl rule__Content__Group__1 ;
    public final void rule__Content__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7116:1: ( rule__Content__Group__0__Impl rule__Content__Group__1 )
            // InternalModelDraw.g:7117:2: rule__Content__Group__0__Impl rule__Content__Group__1
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
    // InternalModelDraw.g:7124:1: rule__Content__Group__0__Impl : ( () ) ;
    public final void rule__Content__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7128:1: ( ( () ) )
            // InternalModelDraw.g:7129:1: ( () )
            {
            // InternalModelDraw.g:7129:1: ( () )
            // InternalModelDraw.g:7130:2: ()
            {
             before(grammarAccess.getContentAccess().getContentAction_0()); 
            // InternalModelDraw.g:7131:2: ()
            // InternalModelDraw.g:7131:3: 
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
    // InternalModelDraw.g:7139:1: rule__Content__Group__1 : rule__Content__Group__1__Impl rule__Content__Group__2 ;
    public final void rule__Content__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7143:1: ( rule__Content__Group__1__Impl rule__Content__Group__2 )
            // InternalModelDraw.g:7144:2: rule__Content__Group__1__Impl rule__Content__Group__2
            {
            pushFollow(FOLLOW_7);
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
    // InternalModelDraw.g:7151:1: rule__Content__Group__1__Impl : ( ( rule__Content__NameAssignment_1 ) ) ;
    public final void rule__Content__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7155:1: ( ( ( rule__Content__NameAssignment_1 ) ) )
            // InternalModelDraw.g:7156:1: ( ( rule__Content__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:7156:1: ( ( rule__Content__NameAssignment_1 ) )
            // InternalModelDraw.g:7157:2: ( rule__Content__NameAssignment_1 )
            {
             before(grammarAccess.getContentAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:7158:2: ( rule__Content__NameAssignment_1 )
            // InternalModelDraw.g:7158:3: rule__Content__NameAssignment_1
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
    // InternalModelDraw.g:7166:1: rule__Content__Group__2 : rule__Content__Group__2__Impl rule__Content__Group__3 ;
    public final void rule__Content__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7170:1: ( rule__Content__Group__2__Impl rule__Content__Group__3 )
            // InternalModelDraw.g:7171:2: rule__Content__Group__2__Impl rule__Content__Group__3
            {
            pushFollow(FOLLOW_33);
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
    // InternalModelDraw.g:7178:1: rule__Content__Group__2__Impl : ( ':' ) ;
    public final void rule__Content__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7182:1: ( ( ':' ) )
            // InternalModelDraw.g:7183:1: ( ':' )
            {
            // InternalModelDraw.g:7183:1: ( ':' )
            // InternalModelDraw.g:7184:2: ':'
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
    // InternalModelDraw.g:7193:1: rule__Content__Group__3 : rule__Content__Group__3__Impl rule__Content__Group__4 ;
    public final void rule__Content__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7197:1: ( rule__Content__Group__3__Impl rule__Content__Group__4 )
            // InternalModelDraw.g:7198:2: rule__Content__Group__3__Impl rule__Content__Group__4
            {
            pushFollow(FOLLOW_33);
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
    // InternalModelDraw.g:7205:1: rule__Content__Group__3__Impl : ( ( rule__Content__Group_3__0 )? ) ;
    public final void rule__Content__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7209:1: ( ( ( rule__Content__Group_3__0 )? ) )
            // InternalModelDraw.g:7210:1: ( ( rule__Content__Group_3__0 )? )
            {
            // InternalModelDraw.g:7210:1: ( ( rule__Content__Group_3__0 )? )
            // InternalModelDraw.g:7211:2: ( rule__Content__Group_3__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_3()); 
            // InternalModelDraw.g:7212:2: ( rule__Content__Group_3__0 )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID) ) {
                int LA72_1 = input.LA(2);

                if ( (LA72_1==50) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // InternalModelDraw.g:7212:3: rule__Content__Group_3__0
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
    // InternalModelDraw.g:7220:1: rule__Content__Group__4 : rule__Content__Group__4__Impl rule__Content__Group__5 ;
    public final void rule__Content__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7224:1: ( rule__Content__Group__4__Impl rule__Content__Group__5 )
            // InternalModelDraw.g:7225:2: rule__Content__Group__4__Impl rule__Content__Group__5
            {
            pushFollow(FOLLOW_33);
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
    // InternalModelDraw.g:7232:1: rule__Content__Group__4__Impl : ( ( rule__Content__Group_4__0 )? ) ;
    public final void rule__Content__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7236:1: ( ( ( rule__Content__Group_4__0 )? ) )
            // InternalModelDraw.g:7237:1: ( ( rule__Content__Group_4__0 )? )
            {
            // InternalModelDraw.g:7237:1: ( ( rule__Content__Group_4__0 )? )
            // InternalModelDraw.g:7238:2: ( rule__Content__Group_4__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_4()); 
            // InternalModelDraw.g:7239:2: ( rule__Content__Group_4__0 )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==RULE_ID) ) {
                int LA73_1 = input.LA(2);

                if ( (LA73_1==EOF||LA73_1==RULE_ID||(LA73_1>=30 && LA73_1<=31)||LA73_1==44||LA73_1==49) ) {
                    alt73=1;
                }
            }
            switch (alt73) {
                case 1 :
                    // InternalModelDraw.g:7239:3: rule__Content__Group_4__0
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
    // InternalModelDraw.g:7247:1: rule__Content__Group__5 : rule__Content__Group__5__Impl rule__Content__Group__6 ;
    public final void rule__Content__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7251:1: ( rule__Content__Group__5__Impl rule__Content__Group__6 )
            // InternalModelDraw.g:7252:2: rule__Content__Group__5__Impl rule__Content__Group__6
            {
            pushFollow(FOLLOW_33);
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
    // InternalModelDraw.g:7259:1: rule__Content__Group__5__Impl : ( ( rule__Content__Group_5__0 )? ) ;
    public final void rule__Content__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7263:1: ( ( ( rule__Content__Group_5__0 )? ) )
            // InternalModelDraw.g:7264:1: ( ( rule__Content__Group_5__0 )? )
            {
            // InternalModelDraw.g:7264:1: ( ( rule__Content__Group_5__0 )? )
            // InternalModelDraw.g:7265:2: ( rule__Content__Group_5__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_5()); 
            // InternalModelDraw.g:7266:2: ( rule__Content__Group_5__0 )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==30) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalModelDraw.g:7266:3: rule__Content__Group_5__0
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
    // InternalModelDraw.g:7274:1: rule__Content__Group__6 : rule__Content__Group__6__Impl ;
    public final void rule__Content__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7278:1: ( rule__Content__Group__6__Impl )
            // InternalModelDraw.g:7279:2: rule__Content__Group__6__Impl
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
    // InternalModelDraw.g:7285:1: rule__Content__Group__6__Impl : ( ( rule__Content__Group_6__0 )? ) ;
    public final void rule__Content__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7289:1: ( ( ( rule__Content__Group_6__0 )? ) )
            // InternalModelDraw.g:7290:1: ( ( rule__Content__Group_6__0 )? )
            {
            // InternalModelDraw.g:7290:1: ( ( rule__Content__Group_6__0 )? )
            // InternalModelDraw.g:7291:2: ( rule__Content__Group_6__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_6()); 
            // InternalModelDraw.g:7292:2: ( rule__Content__Group_6__0 )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==49) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalModelDraw.g:7292:3: rule__Content__Group_6__0
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
    // InternalModelDraw.g:7301:1: rule__Content__Group_3__0 : rule__Content__Group_3__0__Impl rule__Content__Group_3__1 ;
    public final void rule__Content__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7305:1: ( rule__Content__Group_3__0__Impl rule__Content__Group_3__1 )
            // InternalModelDraw.g:7306:2: rule__Content__Group_3__0__Impl rule__Content__Group_3__1
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
    // InternalModelDraw.g:7313:1: rule__Content__Group_3__0__Impl : ( ( rule__Content__NodenumAssignment_3_0 ) ) ;
    public final void rule__Content__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7317:1: ( ( ( rule__Content__NodenumAssignment_3_0 ) ) )
            // InternalModelDraw.g:7318:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            {
            // InternalModelDraw.g:7318:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            // InternalModelDraw.g:7319:2: ( rule__Content__NodenumAssignment_3_0 )
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_0()); 
            // InternalModelDraw.g:7320:2: ( rule__Content__NodenumAssignment_3_0 )
            // InternalModelDraw.g:7320:3: rule__Content__NodenumAssignment_3_0
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
    // InternalModelDraw.g:7328:1: rule__Content__Group_3__1 : rule__Content__Group_3__1__Impl ;
    public final void rule__Content__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7332:1: ( rule__Content__Group_3__1__Impl )
            // InternalModelDraw.g:7333:2: rule__Content__Group_3__1__Impl
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
    // InternalModelDraw.g:7339:1: rule__Content__Group_3__1__Impl : ( ( rule__Content__NodenumAssignment_3_1 )* ) ;
    public final void rule__Content__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7343:1: ( ( ( rule__Content__NodenumAssignment_3_1 )* ) )
            // InternalModelDraw.g:7344:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            {
            // InternalModelDraw.g:7344:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            // InternalModelDraw.g:7345:2: ( rule__Content__NodenumAssignment_3_1 )*
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_1()); 
            // InternalModelDraw.g:7346:2: ( rule__Content__NodenumAssignment_3_1 )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_ID) ) {
                    int LA76_1 = input.LA(2);

                    if ( (LA76_1==50) ) {
                        alt76=1;
                    }


                }


                switch (alt76) {
            	case 1 :
            	    // InternalModelDraw.g:7346:3: rule__Content__NodenumAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Content__NodenumAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop76;
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
    // InternalModelDraw.g:7355:1: rule__Content__Group_4__0 : rule__Content__Group_4__0__Impl rule__Content__Group_4__1 ;
    public final void rule__Content__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7359:1: ( rule__Content__Group_4__0__Impl rule__Content__Group_4__1 )
            // InternalModelDraw.g:7360:2: rule__Content__Group_4__0__Impl rule__Content__Group_4__1
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
    // InternalModelDraw.g:7367:1: rule__Content__Group_4__0__Impl : ( ( rule__Content__InfoAssignment_4_0 ) ) ;
    public final void rule__Content__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7371:1: ( ( ( rule__Content__InfoAssignment_4_0 ) ) )
            // InternalModelDraw.g:7372:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            {
            // InternalModelDraw.g:7372:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            // InternalModelDraw.g:7373:2: ( rule__Content__InfoAssignment_4_0 )
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_0()); 
            // InternalModelDraw.g:7374:2: ( rule__Content__InfoAssignment_4_0 )
            // InternalModelDraw.g:7374:3: rule__Content__InfoAssignment_4_0
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
    // InternalModelDraw.g:7382:1: rule__Content__Group_4__1 : rule__Content__Group_4__1__Impl ;
    public final void rule__Content__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7386:1: ( rule__Content__Group_4__1__Impl )
            // InternalModelDraw.g:7387:2: rule__Content__Group_4__1__Impl
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
    // InternalModelDraw.g:7393:1: rule__Content__Group_4__1__Impl : ( ( rule__Content__InfoAssignment_4_1 )* ) ;
    public final void rule__Content__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7397:1: ( ( ( rule__Content__InfoAssignment_4_1 )* ) )
            // InternalModelDraw.g:7398:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            {
            // InternalModelDraw.g:7398:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            // InternalModelDraw.g:7399:2: ( rule__Content__InfoAssignment_4_1 )*
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_1()); 
            // InternalModelDraw.g:7400:2: ( rule__Content__InfoAssignment_4_1 )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==RULE_ID) ) {
                    int LA77_2 = input.LA(2);

                    if ( (LA77_2==EOF||LA77_2==RULE_ID||(LA77_2>=30 && LA77_2<=31)||LA77_2==44||LA77_2==49) ) {
                        alt77=1;
                    }


                }


                switch (alt77) {
            	case 1 :
            	    // InternalModelDraw.g:7400:3: rule__Content__InfoAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__Content__InfoAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop77;
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
    // InternalModelDraw.g:7409:1: rule__Content__Group_5__0 : rule__Content__Group_5__0__Impl rule__Content__Group_5__1 ;
    public final void rule__Content__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7413:1: ( rule__Content__Group_5__0__Impl rule__Content__Group_5__1 )
            // InternalModelDraw.g:7414:2: rule__Content__Group_5__0__Impl rule__Content__Group_5__1
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
    // InternalModelDraw.g:7421:1: rule__Content__Group_5__0__Impl : ( '{' ) ;
    public final void rule__Content__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7425:1: ( ( '{' ) )
            // InternalModelDraw.g:7426:1: ( '{' )
            {
            // InternalModelDraw.g:7426:1: ( '{' )
            // InternalModelDraw.g:7427:2: '{'
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
    // InternalModelDraw.g:7436:1: rule__Content__Group_5__1 : rule__Content__Group_5__1__Impl rule__Content__Group_5__2 ;
    public final void rule__Content__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7440:1: ( rule__Content__Group_5__1__Impl rule__Content__Group_5__2 )
            // InternalModelDraw.g:7441:2: rule__Content__Group_5__1__Impl rule__Content__Group_5__2
            {
            pushFollow(FOLLOW_34);
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
    // InternalModelDraw.g:7448:1: rule__Content__Group_5__1__Impl : ( ( rule__Content__AttNameAssignment_5_1 ) ) ;
    public final void rule__Content__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7452:1: ( ( ( rule__Content__AttNameAssignment_5_1 ) ) )
            // InternalModelDraw.g:7453:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            {
            // InternalModelDraw.g:7453:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            // InternalModelDraw.g:7454:2: ( rule__Content__AttNameAssignment_5_1 )
            {
             before(grammarAccess.getContentAccess().getAttNameAssignment_5_1()); 
            // InternalModelDraw.g:7455:2: ( rule__Content__AttNameAssignment_5_1 )
            // InternalModelDraw.g:7455:3: rule__Content__AttNameAssignment_5_1
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
    // InternalModelDraw.g:7463:1: rule__Content__Group_5__2 : rule__Content__Group_5__2__Impl ;
    public final void rule__Content__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7467:1: ( rule__Content__Group_5__2__Impl )
            // InternalModelDraw.g:7468:2: rule__Content__Group_5__2__Impl
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
    // InternalModelDraw.g:7474:1: rule__Content__Group_5__2__Impl : ( '}' ) ;
    public final void rule__Content__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7478:1: ( ( '}' ) )
            // InternalModelDraw.g:7479:1: ( '}' )
            {
            // InternalModelDraw.g:7479:1: ( '}' )
            // InternalModelDraw.g:7480:2: '}'
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
    // InternalModelDraw.g:7490:1: rule__Content__Group_6__0 : rule__Content__Group_6__0__Impl rule__Content__Group_6__1 ;
    public final void rule__Content__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7494:1: ( rule__Content__Group_6__0__Impl rule__Content__Group_6__1 )
            // InternalModelDraw.g:7495:2: rule__Content__Group_6__0__Impl rule__Content__Group_6__1
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
    // InternalModelDraw.g:7502:1: rule__Content__Group_6__0__Impl : ( 'text' ) ;
    public final void rule__Content__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7506:1: ( ( 'text' ) )
            // InternalModelDraw.g:7507:1: ( 'text' )
            {
            // InternalModelDraw.g:7507:1: ( 'text' )
            // InternalModelDraw.g:7508:2: 'text'
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
    // InternalModelDraw.g:7517:1: rule__Content__Group_6__1 : rule__Content__Group_6__1__Impl rule__Content__Group_6__2 ;
    public final void rule__Content__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7521:1: ( rule__Content__Group_6__1__Impl rule__Content__Group_6__2 )
            // InternalModelDraw.g:7522:2: rule__Content__Group_6__1__Impl rule__Content__Group_6__2
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
    // InternalModelDraw.g:7529:1: rule__Content__Group_6__1__Impl : ( '=' ) ;
    public final void rule__Content__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7533:1: ( ( '=' ) )
            // InternalModelDraw.g:7534:1: ( '=' )
            {
            // InternalModelDraw.g:7534:1: ( '=' )
            // InternalModelDraw.g:7535:2: '='
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
    // InternalModelDraw.g:7544:1: rule__Content__Group_6__2 : rule__Content__Group_6__2__Impl ;
    public final void rule__Content__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7548:1: ( rule__Content__Group_6__2__Impl )
            // InternalModelDraw.g:7549:2: rule__Content__Group_6__2__Impl
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
    // InternalModelDraw.g:7555:1: rule__Content__Group_6__2__Impl : ( ( rule__Content__SymbolAssignment_6_2 ) ) ;
    public final void rule__Content__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7559:1: ( ( ( rule__Content__SymbolAssignment_6_2 ) ) )
            // InternalModelDraw.g:7560:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            {
            // InternalModelDraw.g:7560:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            // InternalModelDraw.g:7561:2: ( rule__Content__SymbolAssignment_6_2 )
            {
             before(grammarAccess.getContentAccess().getSymbolAssignment_6_2()); 
            // InternalModelDraw.g:7562:2: ( rule__Content__SymbolAssignment_6_2 )
            // InternalModelDraw.g:7562:3: rule__Content__SymbolAssignment_6_2
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
    // InternalModelDraw.g:7571:1: rule__NodeEnumerator__Group__0 : rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 ;
    public final void rule__NodeEnumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7575:1: ( rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 )
            // InternalModelDraw.g:7576:2: rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1
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
    // InternalModelDraw.g:7583:1: rule__NodeEnumerator__Group__0__Impl : ( () ) ;
    public final void rule__NodeEnumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7587:1: ( ( () ) )
            // InternalModelDraw.g:7588:1: ( () )
            {
            // InternalModelDraw.g:7588:1: ( () )
            // InternalModelDraw.g:7589:2: ()
            {
             before(grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0()); 
            // InternalModelDraw.g:7590:2: ()
            // InternalModelDraw.g:7590:3: 
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
    // InternalModelDraw.g:7598:1: rule__NodeEnumerator__Group__1 : rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 ;
    public final void rule__NodeEnumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7602:1: ( rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 )
            // InternalModelDraw.g:7603:2: rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2
            {
            pushFollow(FOLLOW_35);
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
    // InternalModelDraw.g:7610:1: rule__NodeEnumerator__Group__1__Impl : ( ( rule__NodeEnumerator__AttAssignment_1 ) ) ;
    public final void rule__NodeEnumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7614:1: ( ( ( rule__NodeEnumerator__AttAssignment_1 ) ) )
            // InternalModelDraw.g:7615:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            {
            // InternalModelDraw.g:7615:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            // InternalModelDraw.g:7616:2: ( rule__NodeEnumerator__AttAssignment_1 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttAssignment_1()); 
            // InternalModelDraw.g:7617:2: ( rule__NodeEnumerator__AttAssignment_1 )
            // InternalModelDraw.g:7617:3: rule__NodeEnumerator__AttAssignment_1
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
    // InternalModelDraw.g:7625:1: rule__NodeEnumerator__Group__2 : rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 ;
    public final void rule__NodeEnumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7629:1: ( rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 )
            // InternalModelDraw.g:7630:2: rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3
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
    // InternalModelDraw.g:7637:1: rule__NodeEnumerator__Group__2__Impl : ( '[' ) ;
    public final void rule__NodeEnumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7641:1: ( ( '[' ) )
            // InternalModelDraw.g:7642:1: ( '[' )
            {
            // InternalModelDraw.g:7642:1: ( '[' )
            // InternalModelDraw.g:7643:2: '['
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
    // InternalModelDraw.g:7652:1: rule__NodeEnumerator__Group__3 : rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 ;
    public final void rule__NodeEnumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7656:1: ( rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 )
            // InternalModelDraw.g:7657:2: rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4
            {
            pushFollow(FOLLOW_36);
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
    // InternalModelDraw.g:7664:1: rule__NodeEnumerator__Group__3__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) ;
    public final void rule__NodeEnumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7668:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) )
            // InternalModelDraw.g:7669:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            {
            // InternalModelDraw.g:7669:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            // InternalModelDraw.g:7670:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_3()); 
            // InternalModelDraw.g:7671:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            // InternalModelDraw.g:7671:3: rule__NodeEnumerator__EnumeratorAssignment_3
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
    // InternalModelDraw.g:7679:1: rule__NodeEnumerator__Group__4 : rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 ;
    public final void rule__NodeEnumerator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7683:1: ( rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 )
            // InternalModelDraw.g:7684:2: rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5
            {
            pushFollow(FOLLOW_36);
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
    // InternalModelDraw.g:7691:1: rule__NodeEnumerator__Group__4__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) ;
    public final void rule__NodeEnumerator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7695:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) )
            // InternalModelDraw.g:7696:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            {
            // InternalModelDraw.g:7696:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            // InternalModelDraw.g:7697:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_4()); 
            // InternalModelDraw.g:7698:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==RULE_ID) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalModelDraw.g:7698:3: rule__NodeEnumerator__EnumeratorAssignment_4
            	    {
            	    pushFollow(FOLLOW_6);
            	    rule__NodeEnumerator__EnumeratorAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop78;
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
    // InternalModelDraw.g:7706:1: rule__NodeEnumerator__Group__5 : rule__NodeEnumerator__Group__5__Impl ;
    public final void rule__NodeEnumerator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7710:1: ( rule__NodeEnumerator__Group__5__Impl )
            // InternalModelDraw.g:7711:2: rule__NodeEnumerator__Group__5__Impl
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
    // InternalModelDraw.g:7717:1: rule__NodeEnumerator__Group__5__Impl : ( ']' ) ;
    public final void rule__NodeEnumerator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7721:1: ( ( ']' ) )
            // InternalModelDraw.g:7722:1: ( ']' )
            {
            // InternalModelDraw.g:7722:1: ( ']' )
            // InternalModelDraw.g:7723:2: ']'
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
    // InternalModelDraw.g:7733:1: rule__Enumerator__Group__0 : rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 ;
    public final void rule__Enumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7737:1: ( rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 )
            // InternalModelDraw.g:7738:2: rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1
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
    // InternalModelDraw.g:7745:1: rule__Enumerator__Group__0__Impl : ( () ) ;
    public final void rule__Enumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7749:1: ( ( () ) )
            // InternalModelDraw.g:7750:1: ( () )
            {
            // InternalModelDraw.g:7750:1: ( () )
            // InternalModelDraw.g:7751:2: ()
            {
             before(grammarAccess.getEnumeratorAccess().getEnumeratorAction_0()); 
            // InternalModelDraw.g:7752:2: ()
            // InternalModelDraw.g:7752:3: 
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
    // InternalModelDraw.g:7760:1: rule__Enumerator__Group__1 : rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 ;
    public final void rule__Enumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7764:1: ( rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 )
            // InternalModelDraw.g:7765:2: rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2
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
    // InternalModelDraw.g:7772:1: rule__Enumerator__Group__1__Impl : ( ( rule__Enumerator__LiteralAssignment_1 ) ) ;
    public final void rule__Enumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7776:1: ( ( ( rule__Enumerator__LiteralAssignment_1 ) ) )
            // InternalModelDraw.g:7777:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            {
            // InternalModelDraw.g:7777:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            // InternalModelDraw.g:7778:2: ( rule__Enumerator__LiteralAssignment_1 )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralAssignment_1()); 
            // InternalModelDraw.g:7779:2: ( rule__Enumerator__LiteralAssignment_1 )
            // InternalModelDraw.g:7779:3: rule__Enumerator__LiteralAssignment_1
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
    // InternalModelDraw.g:7787:1: rule__Enumerator__Group__2 : rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 ;
    public final void rule__Enumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7791:1: ( rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 )
            // InternalModelDraw.g:7792:2: rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3
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
    // InternalModelDraw.g:7799:1: rule__Enumerator__Group__2__Impl : ( '=' ) ;
    public final void rule__Enumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7803:1: ( ( '=' ) )
            // InternalModelDraw.g:7804:1: ( '=' )
            {
            // InternalModelDraw.g:7804:1: ( '=' )
            // InternalModelDraw.g:7805:2: '='
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
    // InternalModelDraw.g:7814:1: rule__Enumerator__Group__3 : rule__Enumerator__Group__3__Impl ;
    public final void rule__Enumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7818:1: ( rule__Enumerator__Group__3__Impl )
            // InternalModelDraw.g:7819:2: rule__Enumerator__Group__3__Impl
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
    // InternalModelDraw.g:7825:1: rule__Enumerator__Group__3__Impl : ( ( rule__Enumerator__ValueAssignment_3 ) ) ;
    public final void rule__Enumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7829:1: ( ( ( rule__Enumerator__ValueAssignment_3 ) ) )
            // InternalModelDraw.g:7830:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            {
            // InternalModelDraw.g:7830:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            // InternalModelDraw.g:7831:2: ( rule__Enumerator__ValueAssignment_3 )
            {
             before(grammarAccess.getEnumeratorAccess().getValueAssignment_3()); 
            // InternalModelDraw.g:7832:2: ( rule__Enumerator__ValueAssignment_3 )
            // InternalModelDraw.g:7832:3: rule__Enumerator__ValueAssignment_3
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
    // InternalModelDraw.g:7841:1: rule__Information__Group__0 : rule__Information__Group__0__Impl rule__Information__Group__1 ;
    public final void rule__Information__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7845:1: ( rule__Information__Group__0__Impl rule__Information__Group__1 )
            // InternalModelDraw.g:7846:2: rule__Information__Group__0__Impl rule__Information__Group__1
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
    // InternalModelDraw.g:7853:1: rule__Information__Group__0__Impl : ( () ) ;
    public final void rule__Information__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7857:1: ( ( () ) )
            // InternalModelDraw.g:7858:1: ( () )
            {
            // InternalModelDraw.g:7858:1: ( () )
            // InternalModelDraw.g:7859:2: ()
            {
             before(grammarAccess.getInformationAccess().getInformationAction_0()); 
            // InternalModelDraw.g:7860:2: ()
            // InternalModelDraw.g:7860:3: 
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
    // InternalModelDraw.g:7868:1: rule__Information__Group__1 : rule__Information__Group__1__Impl rule__Information__Group__2 ;
    public final void rule__Information__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7872:1: ( rule__Information__Group__1__Impl rule__Information__Group__2 )
            // InternalModelDraw.g:7873:2: rule__Information__Group__1__Impl rule__Information__Group__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalModelDraw.g:7880:1: rule__Information__Group__1__Impl : ( ( rule__Information__TypeAssignment_1 ) ) ;
    public final void rule__Information__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7884:1: ( ( ( rule__Information__TypeAssignment_1 ) ) )
            // InternalModelDraw.g:7885:1: ( ( rule__Information__TypeAssignment_1 ) )
            {
            // InternalModelDraw.g:7885:1: ( ( rule__Information__TypeAssignment_1 ) )
            // InternalModelDraw.g:7886:2: ( rule__Information__TypeAssignment_1 )
            {
             before(grammarAccess.getInformationAccess().getTypeAssignment_1()); 
            // InternalModelDraw.g:7887:2: ( rule__Information__TypeAssignment_1 )
            // InternalModelDraw.g:7887:3: rule__Information__TypeAssignment_1
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
    // InternalModelDraw.g:7895:1: rule__Information__Group__2 : rule__Information__Group__2__Impl ;
    public final void rule__Information__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7899:1: ( rule__Information__Group__2__Impl )
            // InternalModelDraw.g:7900:2: rule__Information__Group__2__Impl
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
    // InternalModelDraw.g:7906:1: rule__Information__Group__2__Impl : ( ( rule__Information__Group_2__0 )? ) ;
    public final void rule__Information__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7910:1: ( ( ( rule__Information__Group_2__0 )? ) )
            // InternalModelDraw.g:7911:1: ( ( rule__Information__Group_2__0 )? )
            {
            // InternalModelDraw.g:7911:1: ( ( rule__Information__Group_2__0 )? )
            // InternalModelDraw.g:7912:2: ( rule__Information__Group_2__0 )?
            {
             before(grammarAccess.getInformationAccess().getGroup_2()); 
            // InternalModelDraw.g:7913:2: ( rule__Information__Group_2__0 )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==44) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalModelDraw.g:7913:3: rule__Information__Group_2__0
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
    // InternalModelDraw.g:7922:1: rule__Information__Group_2__0 : rule__Information__Group_2__0__Impl rule__Information__Group_2__1 ;
    public final void rule__Information__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7926:1: ( rule__Information__Group_2__0__Impl rule__Information__Group_2__1 )
            // InternalModelDraw.g:7927:2: rule__Information__Group_2__0__Impl rule__Information__Group_2__1
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
    // InternalModelDraw.g:7934:1: rule__Information__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Information__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7938:1: ( ( '.' ) )
            // InternalModelDraw.g:7939:1: ( '.' )
            {
            // InternalModelDraw.g:7939:1: ( '.' )
            // InternalModelDraw.g:7940:2: '.'
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
    // InternalModelDraw.g:7949:1: rule__Information__Group_2__1 : rule__Information__Group_2__1__Impl ;
    public final void rule__Information__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7953:1: ( rule__Information__Group_2__1__Impl )
            // InternalModelDraw.g:7954:2: rule__Information__Group_2__1__Impl
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
    // InternalModelDraw.g:7960:1: rule__Information__Group_2__1__Impl : ( ( rule__Information__AttAssignment_2_1 ) ) ;
    public final void rule__Information__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7964:1: ( ( ( rule__Information__AttAssignment_2_1 ) ) )
            // InternalModelDraw.g:7965:1: ( ( rule__Information__AttAssignment_2_1 ) )
            {
            // InternalModelDraw.g:7965:1: ( ( rule__Information__AttAssignment_2_1 ) )
            // InternalModelDraw.g:7966:2: ( rule__Information__AttAssignment_2_1 )
            {
             before(grammarAccess.getInformationAccess().getAttAssignment_2_1()); 
            // InternalModelDraw.g:7967:2: ( rule__Information__AttAssignment_2_1 )
            // InternalModelDraw.g:7967:3: rule__Information__AttAssignment_2_1
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
    // InternalModelDraw.g:7976:1: rule__MutatorDraw__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__MutatorDraw__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7980:1: ( ( ruleEString ) )
            // InternalModelDraw.g:7981:2: ( ruleEString )
            {
            // InternalModelDraw.g:7981:2: ( ruleEString )
            // InternalModelDraw.g:7982:3: ruleEString
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


    // $ANTLR start "rule__MutatorDraw__InstancesAssignment_3"
    // InternalModelDraw.g:7991:1: rule__MutatorDraw__InstancesAssignment_3 : ( ruleMutatorInstance ) ;
    public final void rule__MutatorDraw__InstancesAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7995:1: ( ( ruleMutatorInstance ) )
            // InternalModelDraw.g:7996:2: ( ruleMutatorInstance )
            {
            // InternalModelDraw.g:7996:2: ( ruleMutatorInstance )
            // InternalModelDraw.g:7997:3: ruleMutatorInstance
            {
             before(grammarAccess.getMutatorDrawAccess().getInstancesMutatorInstanceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleMutatorInstance();

            state._fsp--;

             after(grammarAccess.getMutatorDrawAccess().getInstancesMutatorInstanceParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorDraw__InstancesAssignment_3"


    // $ANTLR start "rule__MutatorInstance__NameAssignment_1"
    // InternalModelDraw.g:8006:1: rule__MutatorInstance__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__MutatorInstance__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8010:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8011:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8011:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8012:3: ( RULE_ID )
            {
             before(grammarAccess.getMutatorInstanceAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:8013:3: ( RULE_ID )
            // InternalModelDraw.g:8014:4: RULE_ID
            {
             before(grammarAccess.getMutatorInstanceAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getMutatorInstanceAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 

            }

             after(grammarAccess.getMutatorInstanceAccess().getNameEClassCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__NameAssignment_1"


    // $ANTLR start "rule__MutatorInstance__TypeAssignment_3"
    // InternalModelDraw.g:8025:1: rule__MutatorInstance__TypeAssignment_3 : ( ruleDrawType ) ;
    public final void rule__MutatorInstance__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8029:1: ( ( ruleDrawType ) )
            // InternalModelDraw.g:8030:2: ( ruleDrawType )
            {
            // InternalModelDraw.g:8030:2: ( ruleDrawType )
            // InternalModelDraw.g:8031:3: ruleDrawType
            {
             before(grammarAccess.getMutatorInstanceAccess().getTypeDrawTypeEnumRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleDrawType();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceAccess().getTypeDrawTypeEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__TypeAssignment_3"


    // $ANTLR start "rule__MutatorInstance__NodesAssignment_5"
    // InternalModelDraw.g:8040:1: rule__MutatorInstance__NodesAssignment_5 : ( ruleNode ) ;
    public final void rule__MutatorInstance__NodesAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8044:1: ( ( ruleNode ) )
            // InternalModelDraw.g:8045:2: ( ruleNode )
            {
            // InternalModelDraw.g:8045:2: ( ruleNode )
            // InternalModelDraw.g:8046:3: ruleNode
            {
             before(grammarAccess.getMutatorInstanceAccess().getNodesNodeParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceAccess().getNodesNodeParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__NodesAssignment_5"


    // $ANTLR start "rule__MutatorInstance__RelationsAssignment_6"
    // InternalModelDraw.g:8055:1: rule__MutatorInstance__RelationsAssignment_6 : ( ruleRelation ) ;
    public final void rule__MutatorInstance__RelationsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8059:1: ( ( ruleRelation ) )
            // InternalModelDraw.g:8060:2: ( ruleRelation )
            {
            // InternalModelDraw.g:8060:2: ( ruleRelation )
            // InternalModelDraw.g:8061:3: ruleRelation
            {
             before(grammarAccess.getMutatorInstanceAccess().getRelationsRelationParserRuleCall_6_0()); 
            pushFollow(FOLLOW_2);
            ruleRelation();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceAccess().getRelationsRelationParserRuleCall_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__RelationsAssignment_6"


    // $ANTLR start "rule__MutatorInstance__ContentsAssignment_7"
    // InternalModelDraw.g:8070:1: rule__MutatorInstance__ContentsAssignment_7 : ( ruleContent ) ;
    public final void rule__MutatorInstance__ContentsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8074:1: ( ( ruleContent ) )
            // InternalModelDraw.g:8075:2: ( ruleContent )
            {
            // InternalModelDraw.g:8075:2: ( ruleContent )
            // InternalModelDraw.g:8076:3: ruleContent
            {
             before(grammarAccess.getMutatorInstanceAccess().getContentsContentParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleContent();

            state._fsp--;

             after(grammarAccess.getMutatorInstanceAccess().getContentsContentParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorInstance__ContentsAssignment_7"


    // $ANTLR start "rule__Node__NameAssignment_1"
    // InternalModelDraw.g:8085:1: rule__Node__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8089:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8090:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8090:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8091:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:8092:3: ( RULE_ID )
            // InternalModelDraw.g:8093:4: RULE_ID
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
    // InternalModelDraw.g:8104:1: rule__Node__FeatureAssignment_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8108:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8109:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8109:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8110:3: ruleValuedFeature
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
    // InternalModelDraw.g:8119:1: rule__Node__FeatureAssignment_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__FeatureAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8123:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8124:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8124:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8125:3: ruleValuedFeature
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
    // InternalModelDraw.g:8134:1: rule__Node__TargetNodeAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__TargetNodeAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8138:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8139:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8139:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8140:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getTargetNodeEClassCrossReference_3_1_0()); 
            // InternalModelDraw.g:8141:3: ( RULE_ID )
            // InternalModelDraw.g:8142:4: RULE_ID
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
    // InternalModelDraw.g:8153:1: rule__Node__TargetFeatureAssignment_3_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__TargetFeatureAssignment_3_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8157:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8158:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8158:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8159:3: ruleValuedFeature
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
    // InternalModelDraw.g:8168:1: rule__Node__TargetFeatureAssignment_3_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Node__TargetFeatureAssignment_3_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8172:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8173:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8173:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8174:3: ruleValuedFeature
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
    // InternalModelDraw.g:8183:1: rule__Node__TypeAssignment_5 : ( ruleNodeType ) ;
    public final void rule__Node__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8187:1: ( ( ruleNodeType ) )
            // InternalModelDraw.g:8188:2: ( ruleNodeType )
            {
            // InternalModelDraw.g:8188:2: ( ruleNodeType )
            // InternalModelDraw.g:8189:3: ruleNodeType
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
    // InternalModelDraw.g:8198:1: rule__Node__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8202:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8203:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8203:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8204:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:8205:3: ( RULE_ID )
            // InternalModelDraw.g:8206:4: RULE_ID
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
    // InternalModelDraw.g:8217:1: rule__Node__ReferenceAssignment_7_3 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8221:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8222:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8222:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8223:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_3_0()); 
            // InternalModelDraw.g:8224:3: ( RULE_ID )
            // InternalModelDraw.g:8225:4: RULE_ID
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
    // InternalModelDraw.g:8236:1: rule__Node__ReferenceAssignment_7_4 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_7_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8240:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8241:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8241:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8242:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_7_4_0()); 
            // InternalModelDraw.g:8243:3: ( RULE_ID )
            // InternalModelDraw.g:8244:4: RULE_ID
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
    // InternalModelDraw.g:8255:1: rule__Node__ShapeAssignment_8_2 : ( ruleNodeShape ) ;
    public final void rule__Node__ShapeAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8259:1: ( ( ruleNodeShape ) )
            // InternalModelDraw.g:8260:2: ( ruleNodeShape )
            {
            // InternalModelDraw.g:8260:2: ( ruleNodeShape )
            // InternalModelDraw.g:8261:3: ruleNodeShape
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
    // InternalModelDraw.g:8270:1: rule__Node__PathShapeAssignment_8_3_1 : ( ruleEString ) ;
    public final void rule__Node__PathShapeAssignment_8_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8274:1: ( ( ruleEString ) )
            // InternalModelDraw.g:8275:2: ( ruleEString )
            {
            // InternalModelDraw.g:8275:2: ( ruleEString )
            // InternalModelDraw.g:8276:3: ruleEString
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
    // InternalModelDraw.g:8285:1: rule__Node__ColorAssignment_9_2 : ( ruleNodeColor ) ;
    public final void rule__Node__ColorAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8289:1: ( ( ruleNodeColor ) )
            // InternalModelDraw.g:8290:2: ( ruleNodeColor )
            {
            // InternalModelDraw.g:8290:2: ( ruleNodeColor )
            // InternalModelDraw.g:8291:3: ruleNodeColor
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
    // InternalModelDraw.g:8300:1: rule__Node__StyleAssignment_10_2 : ( ruleNodeStyle ) ;
    public final void rule__Node__StyleAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8304:1: ( ( ruleNodeStyle ) )
            // InternalModelDraw.g:8305:2: ( ruleNodeStyle )
            {
            // InternalModelDraw.g:8305:2: ( ruleNodeStyle )
            // InternalModelDraw.g:8306:3: ruleNodeStyle
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
    // InternalModelDraw.g:8315:1: rule__ValuedFeature__NegationAssignment_1 : ( ( 'not' ) ) ;
    public final void rule__ValuedFeature__NegationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8319:1: ( ( ( 'not' ) ) )
            // InternalModelDraw.g:8320:2: ( ( 'not' ) )
            {
            // InternalModelDraw.g:8320:2: ( ( 'not' ) )
            // InternalModelDraw.g:8321:3: ( 'not' )
            {
             before(grammarAccess.getValuedFeatureAccess().getNegationNotKeyword_1_0()); 
            // InternalModelDraw.g:8322:3: ( 'not' )
            // InternalModelDraw.g:8323:4: 'not'
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
    // InternalModelDraw.g:8334:1: rule__ValuedFeature__FeatAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__FeatAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8338:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8339:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8339:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8340:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getFeatEStructuralFeatureCrossReference_2_0()); 
            // InternalModelDraw.g:8341:3: ( RULE_ID )
            // InternalModelDraw.g:8342:4: RULE_ID
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
    // InternalModelDraw.g:8353:1: rule__ValuedFeature__RefFeatureAssignment_3_1 : ( ( RULE_ID ) ) ;
    public final void rule__ValuedFeature__RefFeatureAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8357:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8358:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8358:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8359:3: ( RULE_ID )
            {
             before(grammarAccess.getValuedFeatureAccess().getRefFeatureEStructuralFeatureCrossReference_3_1_0()); 
            // InternalModelDraw.g:8360:3: ( RULE_ID )
            // InternalModelDraw.g:8361:4: RULE_ID
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
    // InternalModelDraw.g:8372:1: rule__ValuedFeature__ValueAssignment_4_1 : ( ( 'null' ) ) ;
    public final void rule__ValuedFeature__ValueAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8376:1: ( ( ( 'null' ) ) )
            // InternalModelDraw.g:8377:2: ( ( 'null' ) )
            {
            // InternalModelDraw.g:8377:2: ( ( 'null' ) )
            // InternalModelDraw.g:8378:3: ( 'null' )
            {
             before(grammarAccess.getValuedFeatureAccess().getValueNullKeyword_4_1_0()); 
            // InternalModelDraw.g:8379:3: ( 'null' )
            // InternalModelDraw.g:8380:4: 'null'
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
    // InternalModelDraw.g:8391:1: rule__Edge__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8395:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8396:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8396:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8397:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:8398:3: ( RULE_ID )
            // InternalModelDraw.g:8399:4: RULE_ID
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
    // InternalModelDraw.g:8410:1: rule__Edge__FeatureAssignment_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__FeatureAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8414:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8415:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8415:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8416:3: ruleValuedFeature
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
    // InternalModelDraw.g:8425:1: rule__Edge__FeatureAssignment_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__FeatureAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8429:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8430:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8430:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8431:3: ruleValuedFeature
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
    // InternalModelDraw.g:8440:1: rule__Edge__SourceAssignment_3_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__SourceAssignment_3_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8444:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8445:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8445:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8446:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0_1_0()); 
            // InternalModelDraw.g:8447:3: ( RULE_ID )
            // InternalModelDraw.g:8448:4: RULE_ID
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


    // $ANTLR start "rule__Edge__TargetAssignment_3_0_2_1"
    // InternalModelDraw.g:8459:1: rule__Edge__TargetAssignment_3_0_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__TargetAssignment_3_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8463:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8464:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8464:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8465:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_3_0_2_1_0()); 
            // InternalModelDraw.g:8466:3: ( RULE_ID )
            // InternalModelDraw.g:8467:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceIDTerminalRuleCall_3_0_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTargetEReferenceIDTerminalRuleCall_3_0_2_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_3_0_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__TargetAssignment_3_0_2_1"


    // $ANTLR start "rule__Edge__TargetNodeAssignment_3_1_1"
    // InternalModelDraw.g:8478:1: rule__Edge__TargetNodeAssignment_3_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__TargetNodeAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8482:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8483:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8483:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8484:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTargetNodeEClassCrossReference_3_1_1_0()); 
            // InternalModelDraw.g:8485:3: ( RULE_ID )
            // InternalModelDraw.g:8486:4: RULE_ID
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
    // InternalModelDraw.g:8497:1: rule__Edge__TargetFeatureAssignment_3_1_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__TargetFeatureAssignment_3_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8501:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8502:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8502:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8503:3: ruleValuedFeature
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
    // InternalModelDraw.g:8512:1: rule__Edge__TargetFeatureAssignment_3_1_2_2_1 : ( ruleValuedFeature ) ;
    public final void rule__Edge__TargetFeatureAssignment_3_1_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8516:1: ( ( ruleValuedFeature ) )
            // InternalModelDraw.g:8517:2: ( ruleValuedFeature )
            {
            // InternalModelDraw.g:8517:2: ( ruleValuedFeature )
            // InternalModelDraw.g:8518:3: ruleValuedFeature
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
    // InternalModelDraw.g:8527:1: rule__Edge__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8531:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8532:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8532:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8533:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:8534:3: ( RULE_ID )
            // InternalModelDraw.g:8535:4: RULE_ID
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
    // InternalModelDraw.g:8546:1: rule__Edge__ReferenceAssignment_7_2_0_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8550:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8551:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8551:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8552:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0()); 
            // InternalModelDraw.g:8553:3: ( RULE_ID )
            // InternalModelDraw.g:8554:4: RULE_ID
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
    // InternalModelDraw.g:8565:1: rule__Edge__RefTypeAssignment_7_2_0_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_0_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8569:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8570:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8570:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8571:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0()); 
            // InternalModelDraw.g:8572:3: ( RULE_ID )
            // InternalModelDraw.g:8573:4: RULE_ID
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
    // InternalModelDraw.g:8584:1: rule__Edge__LabelAssignment_7_2_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8588:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8589:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8589:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8590:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_0_1_0()); 
            // InternalModelDraw.g:8591:3: ( RULE_ID )
            // InternalModelDraw.g:8592:4: RULE_ID
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
    // InternalModelDraw.g:8603:1: rule__Edge__ReferenceAssignment_7_2_1_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8607:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8608:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8608:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8609:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0()); 
            // InternalModelDraw.g:8610:3: ( RULE_ID )
            // InternalModelDraw.g:8611:4: RULE_ID
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
    // InternalModelDraw.g:8622:1: rule__Edge__RefTypeAssignment_7_2_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8626:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8627:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8627:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8628:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0()); 
            // InternalModelDraw.g:8629:3: ( RULE_ID )
            // InternalModelDraw.g:8630:4: RULE_ID
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
    // InternalModelDraw.g:8641:1: rule__Edge__LabelAssignment_7_2_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8645:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8646:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8646:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8647:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_2_0()); 
            // InternalModelDraw.g:8648:3: ( RULE_ID )
            // InternalModelDraw.g:8649:4: RULE_ID
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
    // InternalModelDraw.g:8660:1: rule__Edge__ReferenceAssignment_7_2_1_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8664:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8665:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8665:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8666:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0()); 
            // InternalModelDraw.g:8667:3: ( RULE_ID )
            // InternalModelDraw.g:8668:4: RULE_ID
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
    // InternalModelDraw.g:8679:1: rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8683:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8684:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8684:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8685:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0()); 
            // InternalModelDraw.g:8686:3: ( RULE_ID )
            // InternalModelDraw.g:8687:4: RULE_ID
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
    // InternalModelDraw.g:8698:1: rule__Edge__LabelAssignment_7_2_1_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8702:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8703:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8703:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8704:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0()); 
            // InternalModelDraw.g:8705:3: ( RULE_ID )
            // InternalModelDraw.g:8706:4: RULE_ID
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
    // InternalModelDraw.g:8717:1: rule__Edge__ReferenceAssignment_7_2_1_4_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8721:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8722:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8722:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8723:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0()); 
            // InternalModelDraw.g:8724:3: ( RULE_ID )
            // InternalModelDraw.g:8725:4: RULE_ID
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
    // InternalModelDraw.g:8736:1: rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8740:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8741:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8741:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8742:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0()); 
            // InternalModelDraw.g:8743:3: ( RULE_ID )
            // InternalModelDraw.g:8744:4: RULE_ID
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
    // InternalModelDraw.g:8755:1: rule__Edge__LabelAssignment_7_2_1_4_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8759:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8760:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8760:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8761:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0()); 
            // InternalModelDraw.g:8762:3: ( RULE_ID )
            // InternalModelDraw.g:8763:4: RULE_ID
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
    // InternalModelDraw.g:8774:1: rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_7_2_1_4_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8778:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8779:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8779:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8780:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0()); 
            // InternalModelDraw.g:8781:3: ( RULE_ID )
            // InternalModelDraw.g:8782:4: RULE_ID
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
    // InternalModelDraw.g:8793:1: rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_7_2_1_4_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8797:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8798:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8798:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8799:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0()); 
            // InternalModelDraw.g:8800:3: ( RULE_ID )
            // InternalModelDraw.g:8801:4: RULE_ID
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
    // InternalModelDraw.g:8812:1: rule__Edge__LabelAssignment_7_2_1_4_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_7_2_1_4_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8816:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8817:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8817:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8818:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0()); 
            // InternalModelDraw.g:8819:3: ( RULE_ID )
            // InternalModelDraw.g:8820:4: RULE_ID
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
    // InternalModelDraw.g:8831:1: rule__Edge__Src_decorationAssignment_8_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Src_decorationAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8835:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:8836:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:8836:2: ( ruleDecoration )
            // InternalModelDraw.g:8837:3: ruleDecoration
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
    // InternalModelDraw.g:8846:1: rule__Edge__Src_labelAssignment_9_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Src_labelAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8850:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8851:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8851:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8852:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 
            // InternalModelDraw.g:8853:3: ( RULE_ID )
            // InternalModelDraw.g:8854:4: RULE_ID
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
    // InternalModelDraw.g:8865:1: rule__Edge__Tar_decorationAssignment_10_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Tar_decorationAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8869:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:8870:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:8870:2: ( ruleDecoration )
            // InternalModelDraw.g:8871:3: ruleDecoration
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
    // InternalModelDraw.g:8880:1: rule__Edge__Tar_labelAssignment_11_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Tar_labelAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8884:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8885:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8885:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8886:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_11_2_0()); 
            // InternalModelDraw.g:8887:3: ( RULE_ID )
            // InternalModelDraw.g:8888:4: RULE_ID
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
    // InternalModelDraw.g:8899:1: rule__Level__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8903:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8904:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8904:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8905:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:8906:3: ( RULE_ID )
            // InternalModelDraw.g:8907:4: RULE_ID
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
    // InternalModelDraw.g:8918:1: rule__Level__UpperAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Level__UpperAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8922:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8923:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8923:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8924:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0()); 
            // InternalModelDraw.g:8925:3: ( RULE_ID )
            // InternalModelDraw.g:8926:4: RULE_ID
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
    // InternalModelDraw.g:8937:1: rule__Level__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8941:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8942:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8942:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8943:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:8944:3: ( RULE_ID )
            // InternalModelDraw.g:8945:4: RULE_ID
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
    // InternalModelDraw.g:8956:1: rule__Level__ReferenceAssignment_7_2_0_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8960:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8961:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8961:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8962:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0()); 
            // InternalModelDraw.g:8963:3: ( RULE_ID )
            // InternalModelDraw.g:8964:4: RULE_ID
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
    // InternalModelDraw.g:8975:1: rule__Level__RefTypeAssignment_7_2_0_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_0_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8979:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8980:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8980:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8981:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0()); 
            // InternalModelDraw.g:8982:3: ( RULE_ID )
            // InternalModelDraw.g:8983:4: RULE_ID
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
    // InternalModelDraw.g:8994:1: rule__Level__LabelAssignment_7_2_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8998:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8999:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8999:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9000:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_0_1_0()); 
            // InternalModelDraw.g:9001:3: ( RULE_ID )
            // InternalModelDraw.g:9002:4: RULE_ID
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
    // InternalModelDraw.g:9013:1: rule__Level__ReferenceAssignment_7_2_1_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9017:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9018:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9018:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9019:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0()); 
            // InternalModelDraw.g:9020:3: ( RULE_ID )
            // InternalModelDraw.g:9021:4: RULE_ID
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
    // InternalModelDraw.g:9032:1: rule__Level__RefTypeAssignment_7_2_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9036:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9037:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9037:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9038:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0()); 
            // InternalModelDraw.g:9039:3: ( RULE_ID )
            // InternalModelDraw.g:9040:4: RULE_ID
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
    // InternalModelDraw.g:9051:1: rule__Level__LabelAssignment_7_2_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9055:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9056:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9056:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9057:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_2_0()); 
            // InternalModelDraw.g:9058:3: ( RULE_ID )
            // InternalModelDraw.g:9059:4: RULE_ID
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
    // InternalModelDraw.g:9070:1: rule__Level__ReferenceAssignment_7_2_1_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9074:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9075:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9075:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9076:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0()); 
            // InternalModelDraw.g:9077:3: ( RULE_ID )
            // InternalModelDraw.g:9078:4: RULE_ID
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
    // InternalModelDraw.g:9089:1: rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9093:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9094:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9094:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9095:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0()); 
            // InternalModelDraw.g:9096:3: ( RULE_ID )
            // InternalModelDraw.g:9097:4: RULE_ID
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
    // InternalModelDraw.g:9108:1: rule__Level__LabelAssignment_7_2_1_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9112:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9113:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9113:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9114:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0()); 
            // InternalModelDraw.g:9115:3: ( RULE_ID )
            // InternalModelDraw.g:9116:4: RULE_ID
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
    // InternalModelDraw.g:9127:1: rule__Level__ReferenceAssignment_7_2_1_4_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9131:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9132:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9132:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9133:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0()); 
            // InternalModelDraw.g:9134:3: ( RULE_ID )
            // InternalModelDraw.g:9135:4: RULE_ID
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
    // InternalModelDraw.g:9146:1: rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9150:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9151:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9151:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9152:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0()); 
            // InternalModelDraw.g:9153:3: ( RULE_ID )
            // InternalModelDraw.g:9154:4: RULE_ID
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
    // InternalModelDraw.g:9165:1: rule__Level__LabelAssignment_7_2_1_4_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9169:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9170:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9170:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9171:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0()); 
            // InternalModelDraw.g:9172:3: ( RULE_ID )
            // InternalModelDraw.g:9173:4: RULE_ID
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
    // InternalModelDraw.g:9184:1: rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_4_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9188:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9189:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9189:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9190:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0()); 
            // InternalModelDraw.g:9191:3: ( RULE_ID )
            // InternalModelDraw.g:9192:4: RULE_ID
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
    // InternalModelDraw.g:9203:1: rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9207:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9208:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9208:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9209:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0()); 
            // InternalModelDraw.g:9210:3: ( RULE_ID )
            // InternalModelDraw.g:9211:4: RULE_ID
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
    // InternalModelDraw.g:9222:1: rule__Level__LabelAssignment_7_2_1_4_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_4_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9226:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9227:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9227:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9228:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0()); 
            // InternalModelDraw.g:9229:3: ( RULE_ID )
            // InternalModelDraw.g:9230:4: RULE_ID
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
    // InternalModelDraw.g:9241:1: rule__Level__Src_decorationAssignment_8_2 : ( ruleDecoration ) ;
    public final void rule__Level__Src_decorationAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9245:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:9246:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:9246:2: ( ruleDecoration )
            // InternalModelDraw.g:9247:3: ruleDecoration
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
    // InternalModelDraw.g:9256:1: rule__Level__Src_labelAssignment_9_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Src_labelAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9260:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9261:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9261:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9262:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 
            // InternalModelDraw.g:9263:3: ( RULE_ID )
            // InternalModelDraw.g:9264:4: RULE_ID
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
    // InternalModelDraw.g:9275:1: rule__Level__Tar_decorationAssignment_10_2 : ( ruleDecoration ) ;
    public final void rule__Level__Tar_decorationAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9279:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:9280:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:9280:2: ( ruleDecoration )
            // InternalModelDraw.g:9281:3: ruleDecoration
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
    // InternalModelDraw.g:9290:1: rule__Level__Tar_labelAssignment_11_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Tar_labelAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9294:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9295:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9295:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9296:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getTar_labelEAttributeCrossReference_11_2_0()); 
            // InternalModelDraw.g:9297:3: ( RULE_ID )
            // InternalModelDraw.g:9298:4: RULE_ID
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
    // InternalModelDraw.g:9309:1: rule__Content__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9313:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9314:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9314:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9315:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:9316:3: ( RULE_ID )
            // InternalModelDraw.g:9317:4: RULE_ID
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
    // InternalModelDraw.g:9328:1: rule__Content__NodenumAssignment_3_0 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9332:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:9333:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:9333:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:9334:3: ruleNodeEnumerator
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
    // InternalModelDraw.g:9343:1: rule__Content__NodenumAssignment_3_1 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9347:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:9348:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:9348:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:9349:3: ruleNodeEnumerator
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
    // InternalModelDraw.g:9358:1: rule__Content__InfoAssignment_4_0 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9362:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:9363:2: ( ruleInformation )
            {
            // InternalModelDraw.g:9363:2: ( ruleInformation )
            // InternalModelDraw.g:9364:3: ruleInformation
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
    // InternalModelDraw.g:9373:1: rule__Content__InfoAssignment_4_1 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9377:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:9378:2: ( ruleInformation )
            {
            // InternalModelDraw.g:9378:2: ( ruleInformation )
            // InternalModelDraw.g:9379:3: ruleInformation
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
    // InternalModelDraw.g:9388:1: rule__Content__AttNameAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__AttNameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9392:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9393:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9393:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9394:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0()); 
            // InternalModelDraw.g:9395:3: ( RULE_ID )
            // InternalModelDraw.g:9396:4: RULE_ID
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
    // InternalModelDraw.g:9407:1: rule__Content__SymbolAssignment_6_2 : ( ruleEString ) ;
    public final void rule__Content__SymbolAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9411:1: ( ( ruleEString ) )
            // InternalModelDraw.g:9412:2: ( ruleEString )
            {
            // InternalModelDraw.g:9412:2: ( ruleEString )
            // InternalModelDraw.g:9413:3: ruleEString
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
    // InternalModelDraw.g:9422:1: rule__NodeEnumerator__AttAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NodeEnumerator__AttAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9426:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9427:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9427:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9428:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0()); 
            // InternalModelDraw.g:9429:3: ( RULE_ID )
            // InternalModelDraw.g:9430:4: RULE_ID
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
    // InternalModelDraw.g:9441:1: rule__NodeEnumerator__EnumeratorAssignment_3 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9445:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:9446:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:9446:2: ( ruleEnumerator )
            // InternalModelDraw.g:9447:3: ruleEnumerator
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
    // InternalModelDraw.g:9456:1: rule__NodeEnumerator__EnumeratorAssignment_4 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9460:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:9461:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:9461:2: ( ruleEnumerator )
            // InternalModelDraw.g:9462:3: ruleEnumerator
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
    // InternalModelDraw.g:9471:1: rule__Enumerator__LiteralAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Enumerator__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9475:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9476:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9476:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9477:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0()); 
            // InternalModelDraw.g:9478:3: ( RULE_ID )
            // InternalModelDraw.g:9479:4: RULE_ID
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
    // InternalModelDraw.g:9490:1: rule__Enumerator__ValueAssignment_3 : ( ruleEString ) ;
    public final void rule__Enumerator__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9494:1: ( ( ruleEString ) )
            // InternalModelDraw.g:9495:2: ( ruleEString )
            {
            // InternalModelDraw.g:9495:2: ( ruleEString )
            // InternalModelDraw.g:9496:3: ruleEString
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
    // InternalModelDraw.g:9505:1: rule__Information__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9509:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9510:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9510:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9511:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0()); 
            // InternalModelDraw.g:9512:3: ( RULE_ID )
            // InternalModelDraw.g:9513:4: RULE_ID
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
    // InternalModelDraw.g:9524:1: rule__Information__AttAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__AttAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:9528:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:9529:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:9529:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:9530:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getAttEAttributeCrossReference_2_1_0()); 
            // InternalModelDraw.g:9531:3: ( RULE_ID )
            // InternalModelDraw.g:9532:4: RULE_ID
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


    protected DFA11 dfa11 = new DFA11(this);
    static final String dfa_1s = "\52\uffff";
    static final String dfa_2s = "\1\5\1\35\1\uffff\3\5\1\41\1\5\1\35\1\uffff\1\5\1\35\1\5\1\65\1\41\1\5\1\15\1\5\3\41\1\5\1\35\1\5\2\41\1\5\1\65\1\5\1\65\1\5\1\35\4\41\1\5\1\41\1\5\1\65\2\41";
    static final String dfa_3s = "\1\37\1\54\1\uffff\1\64\1\5\1\61\1\51\1\5\1\40\1\uffff\1\64\1\43\1\5\1\65\1\51\1\64\1\52\1\5\2\51\1\42\1\64\1\43\1\5\2\51\1\5\1\65\1\5\1\65\1\64\1\35\1\51\1\42\1\51\1\42\1\5\1\51\1\5\1\65\1\51\1\42";
    static final String dfa_4s = "\2\uffff\1\2\6\uffff\1\1\40\uffff";
    static final String dfa_5s = "\52\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\31\uffff\1\2",
            "\1\5\2\uffff\1\3\2\uffff\1\4\10\uffff\1\2",
            "",
            "\1\6\56\uffff\1\7",
            "\1\10",
            "\1\2\7\uffff\2\11\17\uffff\2\2\21\uffff\1\2",
            "\1\13\1\12\1\14\5\uffff\1\15",
            "\1\16",
            "\1\20\2\uffff\1\17",
            "",
            "\1\22\56\uffff\1\21",
            "\1\20\2\uffff\1\2\2\uffff\1\4",
            "\1\23",
            "\1\24",
            "\1\26\1\25\1\14\5\uffff\1\15",
            "\1\30\56\uffff\1\27",
            "\2\11\33\uffff\1\2",
            "\1\31",
            "\1\13\1\25\1\32\5\uffff\1\33",
            "\1\26\1\25\6\uffff\1\15",
            "\1\26\1\25",
            "\1\31\56\uffff\1\21",
            "\1\11\2\uffff\1\2\2\uffff\1\4",
            "\1\30",
            "\1\37\1\36\1\34\5\uffff\1\35",
            "\1\26\1\25\1\32\5\uffff\1\33",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\45\56\uffff\1\44",
            "\1\20",
            "\1\26\1\25\6\uffff\1\33",
            "\1\26\1\25",
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

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 948:2: ( rule__MutatorInstance__NodesAssignment_5 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000080000020L});
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
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000040000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000100800000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000580000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x000000000FC00000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0002000040000020L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0008000000000020L});

}