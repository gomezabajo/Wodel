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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'diagram'", "'gray95'", "'node'", "'markednode'", "'circle'", "'doublecircle'", "'record'", "'italic'", "'underline'", "'none'", "'triangle'", "'diamond'", "'odiamond'", "'open'", "'empty'", "'metamodel'", "':'", "'{'", "'}'", "'('", "')'", "','", "'='", "'compartments'", "'shape'", "'color'", "'style'", "'edge'", "'label'", "'.'", "'->'", "'src_decoration'", "'src_label'", "'tar_decoration'", "'tar_label'", "'text'", "'['", "']'", "'not'"
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


    // $ANTLR start "entryRuleBooleanAttribute"
    // InternalModelDraw.g:128:1: entryRuleBooleanAttribute : ruleBooleanAttribute EOF ;
    public final void entryRuleBooleanAttribute() throws RecognitionException {
        try {
            // InternalModelDraw.g:129:1: ( ruleBooleanAttribute EOF )
            // InternalModelDraw.g:130:1: ruleBooleanAttribute EOF
            {
             before(grammarAccess.getBooleanAttributeRule()); 
            pushFollow(FOLLOW_1);
            ruleBooleanAttribute();

            state._fsp--;

             after(grammarAccess.getBooleanAttributeRule()); 
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
    // $ANTLR end "entryRuleBooleanAttribute"


    // $ANTLR start "ruleBooleanAttribute"
    // InternalModelDraw.g:137:1: ruleBooleanAttribute : ( ( rule__BooleanAttribute__Group__0 ) ) ;
    public final void ruleBooleanAttribute() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:141:2: ( ( ( rule__BooleanAttribute__Group__0 ) ) )
            // InternalModelDraw.g:142:2: ( ( rule__BooleanAttribute__Group__0 ) )
            {
            // InternalModelDraw.g:142:2: ( ( rule__BooleanAttribute__Group__0 ) )
            // InternalModelDraw.g:143:3: ( rule__BooleanAttribute__Group__0 )
            {
             before(grammarAccess.getBooleanAttributeAccess().getGroup()); 
            // InternalModelDraw.g:144:3: ( rule__BooleanAttribute__Group__0 )
            // InternalModelDraw.g:144:4: rule__BooleanAttribute__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__BooleanAttribute__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAttributeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanAttribute"


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

                if ( (LA2_1==40) ) {
                    alt2=2;
                }
                else if ( (LA2_1==30) ) {
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


    // $ANTLR start "rule__Edge__Alternatives_10_2"
    // InternalModelDraw.g:465:1: rule__Edge__Alternatives_10_2 : ( ( ( rule__Edge__Group_10_2_0__0 ) ) | ( ( rule__Edge__Group_10_2_1__0 ) ) );
    public final void rule__Edge__Alternatives_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:469:1: ( ( ( rule__Edge__Group_10_2_0__0 ) ) | ( ( rule__Edge__Group_10_2_1__0 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==28) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalModelDraw.g:470:2: ( ( rule__Edge__Group_10_2_0__0 ) )
                    {
                    // InternalModelDraw.g:470:2: ( ( rule__Edge__Group_10_2_0__0 ) )
                    // InternalModelDraw.g:471:3: ( rule__Edge__Group_10_2_0__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_10_2_0()); 
                    // InternalModelDraw.g:472:3: ( rule__Edge__Group_10_2_0__0 )
                    // InternalModelDraw.g:472:4: rule__Edge__Group_10_2_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEdgeAccess().getGroup_10_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:476:2: ( ( rule__Edge__Group_10_2_1__0 ) )
                    {
                    // InternalModelDraw.g:476:2: ( ( rule__Edge__Group_10_2_1__0 ) )
                    // InternalModelDraw.g:477:3: ( rule__Edge__Group_10_2_1__0 )
                    {
                     before(grammarAccess.getEdgeAccess().getGroup_10_2_1()); 
                    // InternalModelDraw.g:478:3: ( rule__Edge__Group_10_2_1__0 )
                    // InternalModelDraw.g:478:4: rule__Edge__Group_10_2_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getEdgeAccess().getGroup_10_2_1()); 

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
    // $ANTLR end "rule__Edge__Alternatives_10_2"


    // $ANTLR start "rule__Level__Alternatives_7_2"
    // InternalModelDraw.g:486:1: rule__Level__Alternatives_7_2 : ( ( ( rule__Level__Group_7_2_0__0 ) ) | ( ( rule__Level__Group_7_2_1__0 ) ) );
    public final void rule__Level__Alternatives_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:490:1: ( ( ( rule__Level__Group_7_2_0__0 ) ) | ( ( rule__Level__Group_7_2_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==28) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // InternalModelDraw.g:491:2: ( ( rule__Level__Group_7_2_0__0 ) )
                    {
                    // InternalModelDraw.g:491:2: ( ( rule__Level__Group_7_2_0__0 ) )
                    // InternalModelDraw.g:492:3: ( rule__Level__Group_7_2_0__0 )
                    {
                     before(grammarAccess.getLevelAccess().getGroup_7_2_0()); 
                    // InternalModelDraw.g:493:3: ( rule__Level__Group_7_2_0__0 )
                    // InternalModelDraw.g:493:4: rule__Level__Group_7_2_0__0
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
                    // InternalModelDraw.g:497:2: ( ( rule__Level__Group_7_2_1__0 ) )
                    {
                    // InternalModelDraw.g:497:2: ( ( rule__Level__Group_7_2_1__0 ) )
                    // InternalModelDraw.g:498:3: ( rule__Level__Group_7_2_1__0 )
                    {
                     before(grammarAccess.getLevelAccess().getGroup_7_2_1()); 
                    // InternalModelDraw.g:499:3: ( rule__Level__Group_7_2_1__0 )
                    // InternalModelDraw.g:499:4: rule__Level__Group_7_2_1__0
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
    // InternalModelDraw.g:507:1: rule__NodeType__Alternatives : ( ( ( 'node' ) ) | ( ( 'markednode' ) ) );
    public final void rule__NodeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:511:1: ( ( ( 'node' ) ) | ( ( 'markednode' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==13) ) {
                alt5=1;
            }
            else if ( (LA5_0==14) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelDraw.g:512:2: ( ( 'node' ) )
                    {
                    // InternalModelDraw.g:512:2: ( ( 'node' ) )
                    // InternalModelDraw.g:513:3: ( 'node' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:514:3: ( 'node' )
                    // InternalModelDraw.g:514:4: 'node'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:518:2: ( ( 'markednode' ) )
                    {
                    // InternalModelDraw.g:518:2: ( ( 'markednode' ) )
                    // InternalModelDraw.g:519:3: ( 'markednode' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:520:3: ( 'markednode' )
                    // InternalModelDraw.g:520:4: 'markednode'
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
    // InternalModelDraw.g:528:1: rule__NodeShape__Alternatives : ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) );
    public final void rule__NodeShape__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:532:1: ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                alt6=2;
                }
                break;
            case 17:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalModelDraw.g:533:2: ( ( 'circle' ) )
                    {
                    // InternalModelDraw.g:533:2: ( ( 'circle' ) )
                    // InternalModelDraw.g:534:3: ( 'circle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:535:3: ( 'circle' )
                    // InternalModelDraw.g:535:4: 'circle'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:539:2: ( ( 'doublecircle' ) )
                    {
                    // InternalModelDraw.g:539:2: ( ( 'doublecircle' ) )
                    // InternalModelDraw.g:540:3: ( 'doublecircle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:541:3: ( 'doublecircle' )
                    // InternalModelDraw.g:541:4: 'doublecircle'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:545:2: ( ( 'record' ) )
                    {
                    // InternalModelDraw.g:545:2: ( ( 'record' ) )
                    // InternalModelDraw.g:546:3: ( 'record' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:547:3: ( 'record' )
                    // InternalModelDraw.g:547:4: 'record'
                    {
                    match(input,17,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2()); 

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
    // InternalModelDraw.g:555:1: rule__NodeStyle__Alternatives : ( ( ( 'italic' ) ) | ( ( 'underline' ) ) );
    public final void rule__NodeStyle__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:559:1: ( ( ( 'italic' ) ) | ( ( 'underline' ) ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalModelDraw.g:560:2: ( ( 'italic' ) )
                    {
                    // InternalModelDraw.g:560:2: ( ( 'italic' ) )
                    // InternalModelDraw.g:561:3: ( 'italic' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:562:3: ( 'italic' )
                    // InternalModelDraw.g:562:4: 'italic'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:566:2: ( ( 'underline' ) )
                    {
                    // InternalModelDraw.g:566:2: ( ( 'underline' ) )
                    // InternalModelDraw.g:567:3: ( 'underline' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getUnderlineEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:568:3: ( 'underline' )
                    // InternalModelDraw.g:568:4: 'underline'
                    {
                    match(input,19,FOLLOW_2); 

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
    // InternalModelDraw.g:576:1: rule__Decoration__Alternatives : ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) );
    public final void rule__Decoration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:580:1: ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) )
            int alt8=6;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt8=1;
                }
                break;
            case 21:
                {
                alt8=2;
                }
                break;
            case 22:
                {
                alt8=3;
                }
                break;
            case 23:
                {
                alt8=4;
                }
                break;
            case 24:
                {
                alt8=5;
                }
                break;
            case 25:
                {
                alt8=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalModelDraw.g:581:2: ( ( 'none' ) )
                    {
                    // InternalModelDraw.g:581:2: ( ( 'none' ) )
                    // InternalModelDraw.g:582:3: ( 'none' )
                    {
                     before(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:583:3: ( 'none' )
                    // InternalModelDraw.g:583:4: 'none'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:587:2: ( ( 'triangle' ) )
                    {
                    // InternalModelDraw.g:587:2: ( ( 'triangle' ) )
                    // InternalModelDraw.g:588:3: ( 'triangle' )
                    {
                     before(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:589:3: ( 'triangle' )
                    // InternalModelDraw.g:589:4: 'triangle'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:593:2: ( ( 'diamond' ) )
                    {
                    // InternalModelDraw.g:593:2: ( ( 'diamond' ) )
                    // InternalModelDraw.g:594:3: ( 'diamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:595:3: ( 'diamond' )
                    // InternalModelDraw.g:595:4: 'diamond'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:599:2: ( ( 'odiamond' ) )
                    {
                    // InternalModelDraw.g:599:2: ( ( 'odiamond' ) )
                    // InternalModelDraw.g:600:3: ( 'odiamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 
                    // InternalModelDraw.g:601:3: ( 'odiamond' )
                    // InternalModelDraw.g:601:4: 'odiamond'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:605:2: ( ( 'open' ) )
                    {
                    // InternalModelDraw.g:605:2: ( ( 'open' ) )
                    // InternalModelDraw.g:606:3: ( 'open' )
                    {
                     before(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 
                    // InternalModelDraw.g:607:3: ( 'open' )
                    // InternalModelDraw.g:607:4: 'open'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:611:2: ( ( 'empty' ) )
                    {
                    // InternalModelDraw.g:611:2: ( ( 'empty' ) )
                    // InternalModelDraw.g:612:3: ( 'empty' )
                    {
                     before(grammarAccess.getDecorationAccess().getEmptyEnumLiteralDeclaration_5()); 
                    // InternalModelDraw.g:613:3: ( 'empty' )
                    // InternalModelDraw.g:613:4: 'empty'
                    {
                    match(input,25,FOLLOW_2); 

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
    // InternalModelDraw.g:621:1: rule__MutatorDraw__Group__0 : rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 ;
    public final void rule__MutatorDraw__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:625:1: ( rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 )
            // InternalModelDraw.g:626:2: rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1
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
    // InternalModelDraw.g:633:1: rule__MutatorDraw__Group__0__Impl : ( () ) ;
    public final void rule__MutatorDraw__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:637:1: ( ( () ) )
            // InternalModelDraw.g:638:1: ( () )
            {
            // InternalModelDraw.g:638:1: ( () )
            // InternalModelDraw.g:639:2: ()
            {
             before(grammarAccess.getMutatorDrawAccess().getMutatorDrawAction_0()); 
            // InternalModelDraw.g:640:2: ()
            // InternalModelDraw.g:640:3: 
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
    // InternalModelDraw.g:648:1: rule__MutatorDraw__Group__1 : rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 ;
    public final void rule__MutatorDraw__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:652:1: ( rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 )
            // InternalModelDraw.g:653:2: rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2
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
    // InternalModelDraw.g:660:1: rule__MutatorDraw__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__MutatorDraw__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:664:1: ( ( 'metamodel' ) )
            // InternalModelDraw.g:665:1: ( 'metamodel' )
            {
            // InternalModelDraw.g:665:1: ( 'metamodel' )
            // InternalModelDraw.g:666:2: 'metamodel'
            {
             before(grammarAccess.getMutatorDrawAccess().getMetamodelKeyword_1()); 
            match(input,26,FOLLOW_2); 
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
    // InternalModelDraw.g:675:1: rule__MutatorDraw__Group__2 : rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 ;
    public final void rule__MutatorDraw__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:679:1: ( rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 )
            // InternalModelDraw.g:680:2: rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3
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
    // InternalModelDraw.g:687:1: rule__MutatorDraw__Group__2__Impl : ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) ;
    public final void rule__MutatorDraw__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:691:1: ( ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) )
            // InternalModelDraw.g:692:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            {
            // InternalModelDraw.g:692:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            // InternalModelDraw.g:693:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            {
             before(grammarAccess.getMutatorDrawAccess().getMetamodelAssignment_2()); 
            // InternalModelDraw.g:694:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            // InternalModelDraw.g:694:3: rule__MutatorDraw__MetamodelAssignment_2
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
    // InternalModelDraw.g:702:1: rule__MutatorDraw__Group__3 : rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4 ;
    public final void rule__MutatorDraw__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:706:1: ( rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4 )
            // InternalModelDraw.g:707:2: rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4
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
    // InternalModelDraw.g:714:1: rule__MutatorDraw__Group__3__Impl : ( ( rule__MutatorDraw__NameAssignment_3 ) ) ;
    public final void rule__MutatorDraw__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:718:1: ( ( ( rule__MutatorDraw__NameAssignment_3 ) ) )
            // InternalModelDraw.g:719:1: ( ( rule__MutatorDraw__NameAssignment_3 ) )
            {
            // InternalModelDraw.g:719:1: ( ( rule__MutatorDraw__NameAssignment_3 ) )
            // InternalModelDraw.g:720:2: ( rule__MutatorDraw__NameAssignment_3 )
            {
             before(grammarAccess.getMutatorDrawAccess().getNameAssignment_3()); 
            // InternalModelDraw.g:721:2: ( rule__MutatorDraw__NameAssignment_3 )
            // InternalModelDraw.g:721:3: rule__MutatorDraw__NameAssignment_3
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
    // InternalModelDraw.g:729:1: rule__MutatorDraw__Group__4 : rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5 ;
    public final void rule__MutatorDraw__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:733:1: ( rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5 )
            // InternalModelDraw.g:734:2: rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5
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
    // InternalModelDraw.g:741:1: rule__MutatorDraw__Group__4__Impl : ( ':' ) ;
    public final void rule__MutatorDraw__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:745:1: ( ( ':' ) )
            // InternalModelDraw.g:746:1: ( ':' )
            {
            // InternalModelDraw.g:746:1: ( ':' )
            // InternalModelDraw.g:747:2: ':'
            {
             before(grammarAccess.getMutatorDrawAccess().getColonKeyword_4()); 
            match(input,27,FOLLOW_2); 
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
    // InternalModelDraw.g:756:1: rule__MutatorDraw__Group__5 : rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6 ;
    public final void rule__MutatorDraw__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:760:1: ( rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6 )
            // InternalModelDraw.g:761:2: rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6
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
    // InternalModelDraw.g:768:1: rule__MutatorDraw__Group__5__Impl : ( ( rule__MutatorDraw__TypeAssignment_5 ) ) ;
    public final void rule__MutatorDraw__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:772:1: ( ( ( rule__MutatorDraw__TypeAssignment_5 ) ) )
            // InternalModelDraw.g:773:1: ( ( rule__MutatorDraw__TypeAssignment_5 ) )
            {
            // InternalModelDraw.g:773:1: ( ( rule__MutatorDraw__TypeAssignment_5 ) )
            // InternalModelDraw.g:774:2: ( rule__MutatorDraw__TypeAssignment_5 )
            {
             before(grammarAccess.getMutatorDrawAccess().getTypeAssignment_5()); 
            // InternalModelDraw.g:775:2: ( rule__MutatorDraw__TypeAssignment_5 )
            // InternalModelDraw.g:775:3: rule__MutatorDraw__TypeAssignment_5
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
    // InternalModelDraw.g:783:1: rule__MutatorDraw__Group__6 : rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7 ;
    public final void rule__MutatorDraw__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:787:1: ( rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7 )
            // InternalModelDraw.g:788:2: rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7
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
    // InternalModelDraw.g:795:1: rule__MutatorDraw__Group__6__Impl : ( '{' ) ;
    public final void rule__MutatorDraw__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:799:1: ( ( '{' ) )
            // InternalModelDraw.g:800:1: ( '{' )
            {
            // InternalModelDraw.g:800:1: ( '{' )
            // InternalModelDraw.g:801:2: '{'
            {
             before(grammarAccess.getMutatorDrawAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,28,FOLLOW_2); 
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
    // InternalModelDraw.g:810:1: rule__MutatorDraw__Group__7 : rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8 ;
    public final void rule__MutatorDraw__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:814:1: ( rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8 )
            // InternalModelDraw.g:815:2: rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8
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
    // InternalModelDraw.g:822:1: rule__MutatorDraw__Group__7__Impl : ( ( rule__MutatorDraw__NodesAssignment_7 )* ) ;
    public final void rule__MutatorDraw__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:826:1: ( ( ( rule__MutatorDraw__NodesAssignment_7 )* ) )
            // InternalModelDraw.g:827:1: ( ( rule__MutatorDraw__NodesAssignment_7 )* )
            {
            // InternalModelDraw.g:827:1: ( ( rule__MutatorDraw__NodesAssignment_7 )* )
            // InternalModelDraw.g:828:2: ( rule__MutatorDraw__NodesAssignment_7 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getNodesAssignment_7()); 
            // InternalModelDraw.g:829:2: ( rule__MutatorDraw__NodesAssignment_7 )*
            loop9:
            do {
                int alt9=2;
                alt9 = dfa9.predict(input);
                switch (alt9) {
            	case 1 :
            	    // InternalModelDraw.g:829:3: rule__MutatorDraw__NodesAssignment_7
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__NodesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalModelDraw.g:837:1: rule__MutatorDraw__Group__8 : rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9 ;
    public final void rule__MutatorDraw__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:841:1: ( rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9 )
            // InternalModelDraw.g:842:2: rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9
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
    // InternalModelDraw.g:849:1: rule__MutatorDraw__Group__8__Impl : ( ( rule__MutatorDraw__RelationsAssignment_8 )* ) ;
    public final void rule__MutatorDraw__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:853:1: ( ( ( rule__MutatorDraw__RelationsAssignment_8 )* ) )
            // InternalModelDraw.g:854:1: ( ( rule__MutatorDraw__RelationsAssignment_8 )* )
            {
            // InternalModelDraw.g:854:1: ( ( rule__MutatorDraw__RelationsAssignment_8 )* )
            // InternalModelDraw.g:855:2: ( rule__MutatorDraw__RelationsAssignment_8 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getRelationsAssignment_8()); 
            // InternalModelDraw.g:856:2: ( rule__MutatorDraw__RelationsAssignment_8 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==30||LA10_1==40) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // InternalModelDraw.g:856:3: rule__MutatorDraw__RelationsAssignment_8
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__RelationsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
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
    // InternalModelDraw.g:864:1: rule__MutatorDraw__Group__9 : rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10 ;
    public final void rule__MutatorDraw__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:868:1: ( rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10 )
            // InternalModelDraw.g:869:2: rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10
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
    // InternalModelDraw.g:876:1: rule__MutatorDraw__Group__9__Impl : ( ( rule__MutatorDraw__ContentsAssignment_9 )* ) ;
    public final void rule__MutatorDraw__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:880:1: ( ( ( rule__MutatorDraw__ContentsAssignment_9 )* ) )
            // InternalModelDraw.g:881:1: ( ( rule__MutatorDraw__ContentsAssignment_9 )* )
            {
            // InternalModelDraw.g:881:1: ( ( rule__MutatorDraw__ContentsAssignment_9 )* )
            // InternalModelDraw.g:882:2: ( rule__MutatorDraw__ContentsAssignment_9 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getContentsAssignment_9()); 
            // InternalModelDraw.g:883:2: ( rule__MutatorDraw__ContentsAssignment_9 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalModelDraw.g:883:3: rule__MutatorDraw__ContentsAssignment_9
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__ContentsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalModelDraw.g:891:1: rule__MutatorDraw__Group__10 : rule__MutatorDraw__Group__10__Impl ;
    public final void rule__MutatorDraw__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:895:1: ( rule__MutatorDraw__Group__10__Impl )
            // InternalModelDraw.g:896:2: rule__MutatorDraw__Group__10__Impl
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
    // InternalModelDraw.g:902:1: rule__MutatorDraw__Group__10__Impl : ( '}' ) ;
    public final void rule__MutatorDraw__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:906:1: ( ( '}' ) )
            // InternalModelDraw.g:907:1: ( '}' )
            {
            // InternalModelDraw.g:907:1: ( '}' )
            // InternalModelDraw.g:908:2: '}'
            {
             before(grammarAccess.getMutatorDrawAccess().getRightCurlyBracketKeyword_10()); 
            match(input,29,FOLLOW_2); 
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
    // InternalModelDraw.g:918:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:922:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalModelDraw.g:923:2: rule__Node__Group__0__Impl rule__Node__Group__1
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
    // InternalModelDraw.g:930:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:934:1: ( ( () ) )
            // InternalModelDraw.g:935:1: ( () )
            {
            // InternalModelDraw.g:935:1: ( () )
            // InternalModelDraw.g:936:2: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // InternalModelDraw.g:937:2: ()
            // InternalModelDraw.g:937:3: 
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
    // InternalModelDraw.g:945:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:949:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalModelDraw.g:950:2: rule__Node__Group__1__Impl rule__Node__Group__2
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
    // InternalModelDraw.g:957:1: rule__Node__Group__1__Impl : ( ( rule__Node__NameAssignment_1 ) ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:961:1: ( ( ( rule__Node__NameAssignment_1 ) ) )
            // InternalModelDraw.g:962:1: ( ( rule__Node__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:962:1: ( ( rule__Node__NameAssignment_1 ) )
            // InternalModelDraw.g:963:2: ( rule__Node__NameAssignment_1 )
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:964:2: ( rule__Node__NameAssignment_1 )
            // InternalModelDraw.g:964:3: rule__Node__NameAssignment_1
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
    // InternalModelDraw.g:972:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:976:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalModelDraw.g:977:2: rule__Node__Group__2__Impl rule__Node__Group__3
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
    // InternalModelDraw.g:984:1: rule__Node__Group__2__Impl : ( ( rule__Node__Group_2__0 )? ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:988:1: ( ( ( rule__Node__Group_2__0 )? ) )
            // InternalModelDraw.g:989:1: ( ( rule__Node__Group_2__0 )? )
            {
            // InternalModelDraw.g:989:1: ( ( rule__Node__Group_2__0 )? )
            // InternalModelDraw.g:990:2: ( rule__Node__Group_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_2()); 
            // InternalModelDraw.g:991:2: ( rule__Node__Group_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==30) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalModelDraw.g:991:3: rule__Node__Group_2__0
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
    // InternalModelDraw.g:999:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1003:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalModelDraw.g:1004:2: rule__Node__Group__3__Impl rule__Node__Group__4
            {
            pushFollow(FOLLOW_12);
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
    // InternalModelDraw.g:1011:1: rule__Node__Group__3__Impl : ( ':' ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1015:1: ( ( ':' ) )
            // InternalModelDraw.g:1016:1: ( ':' )
            {
            // InternalModelDraw.g:1016:1: ( ':' )
            // InternalModelDraw.g:1017:2: ':'
            {
             before(grammarAccess.getNodeAccess().getColonKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getColonKeyword_3()); 

            }


            }

        }
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
    // InternalModelDraw.g:1026:1: rule__Node__Group__4 : rule__Node__Group__4__Impl rule__Node__Group__5 ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1030:1: ( rule__Node__Group__4__Impl rule__Node__Group__5 )
            // InternalModelDraw.g:1031:2: rule__Node__Group__4__Impl rule__Node__Group__5
            {
            pushFollow(FOLLOW_13);
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
    // InternalModelDraw.g:1038:1: rule__Node__Group__4__Impl : ( ( rule__Node__TypeAssignment_4 ) ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1042:1: ( ( ( rule__Node__TypeAssignment_4 ) ) )
            // InternalModelDraw.g:1043:1: ( ( rule__Node__TypeAssignment_4 ) )
            {
            // InternalModelDraw.g:1043:1: ( ( rule__Node__TypeAssignment_4 ) )
            // InternalModelDraw.g:1044:2: ( rule__Node__TypeAssignment_4 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_4()); 
            // InternalModelDraw.g:1045:2: ( rule__Node__TypeAssignment_4 )
            // InternalModelDraw.g:1045:3: rule__Node__TypeAssignment_4
            {
            pushFollow(FOLLOW_2);
            rule__Node__TypeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getTypeAssignment_4()); 

            }


            }

        }
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
    // InternalModelDraw.g:1053:1: rule__Node__Group__5 : rule__Node__Group__5__Impl rule__Node__Group__6 ;
    public final void rule__Node__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1057:1: ( rule__Node__Group__5__Impl rule__Node__Group__6 )
            // InternalModelDraw.g:1058:2: rule__Node__Group__5__Impl rule__Node__Group__6
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
    // InternalModelDraw.g:1065:1: rule__Node__Group__5__Impl : ( ( rule__Node__Group_5__0 )? ) ;
    public final void rule__Node__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1069:1: ( ( ( rule__Node__Group_5__0 )? ) )
            // InternalModelDraw.g:1070:1: ( ( rule__Node__Group_5__0 )? )
            {
            // InternalModelDraw.g:1070:1: ( ( rule__Node__Group_5__0 )? )
            // InternalModelDraw.g:1071:2: ( rule__Node__Group_5__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_5()); 
            // InternalModelDraw.g:1072:2: ( rule__Node__Group_5__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==33) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalModelDraw.g:1072:3: rule__Node__Group_5__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Node__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getGroup_5()); 

            }


            }

        }
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
    // InternalModelDraw.g:1080:1: rule__Node__Group__6 : rule__Node__Group__6__Impl rule__Node__Group__7 ;
    public final void rule__Node__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1084:1: ( rule__Node__Group__6__Impl rule__Node__Group__7 )
            // InternalModelDraw.g:1085:2: rule__Node__Group__6__Impl rule__Node__Group__7
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
    // InternalModelDraw.g:1092:1: rule__Node__Group__6__Impl : ( ( rule__Node__Group_6__0 )? ) ;
    public final void rule__Node__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1096:1: ( ( ( rule__Node__Group_6__0 )? ) )
            // InternalModelDraw.g:1097:1: ( ( rule__Node__Group_6__0 )? )
            {
            // InternalModelDraw.g:1097:1: ( ( rule__Node__Group_6__0 )? )
            // InternalModelDraw.g:1098:2: ( rule__Node__Group_6__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_6()); 
            // InternalModelDraw.g:1099:2: ( rule__Node__Group_6__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==34) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalModelDraw.g:1099:3: rule__Node__Group_6__0
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
    // InternalModelDraw.g:1107:1: rule__Node__Group__7 : rule__Node__Group__7__Impl rule__Node__Group__8 ;
    public final void rule__Node__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1111:1: ( rule__Node__Group__7__Impl rule__Node__Group__8 )
            // InternalModelDraw.g:1112:2: rule__Node__Group__7__Impl rule__Node__Group__8
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
    // InternalModelDraw.g:1119:1: rule__Node__Group__7__Impl : ( ( rule__Node__Group_7__0 )? ) ;
    public final void rule__Node__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1123:1: ( ( ( rule__Node__Group_7__0 )? ) )
            // InternalModelDraw.g:1124:1: ( ( rule__Node__Group_7__0 )? )
            {
            // InternalModelDraw.g:1124:1: ( ( rule__Node__Group_7__0 )? )
            // InternalModelDraw.g:1125:2: ( rule__Node__Group_7__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_7()); 
            // InternalModelDraw.g:1126:2: ( rule__Node__Group_7__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==35) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalModelDraw.g:1126:3: rule__Node__Group_7__0
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
    // InternalModelDraw.g:1134:1: rule__Node__Group__8 : rule__Node__Group__8__Impl rule__Node__Group__9 ;
    public final void rule__Node__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1138:1: ( rule__Node__Group__8__Impl rule__Node__Group__9 )
            // InternalModelDraw.g:1139:2: rule__Node__Group__8__Impl rule__Node__Group__9
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
    // InternalModelDraw.g:1146:1: rule__Node__Group__8__Impl : ( ( rule__Node__Group_8__0 )? ) ;
    public final void rule__Node__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1150:1: ( ( ( rule__Node__Group_8__0 )? ) )
            // InternalModelDraw.g:1151:1: ( ( rule__Node__Group_8__0 )? )
            {
            // InternalModelDraw.g:1151:1: ( ( rule__Node__Group_8__0 )? )
            // InternalModelDraw.g:1152:2: ( rule__Node__Group_8__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_8()); 
            // InternalModelDraw.g:1153:2: ( rule__Node__Group_8__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==36) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalModelDraw.g:1153:3: rule__Node__Group_8__0
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
    // InternalModelDraw.g:1161:1: rule__Node__Group__9 : rule__Node__Group__9__Impl ;
    public final void rule__Node__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1165:1: ( rule__Node__Group__9__Impl )
            // InternalModelDraw.g:1166:2: rule__Node__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group__9__Impl();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:1172:1: rule__Node__Group__9__Impl : ( ( rule__Node__Group_9__0 )? ) ;
    public final void rule__Node__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1176:1: ( ( ( rule__Node__Group_9__0 )? ) )
            // InternalModelDraw.g:1177:1: ( ( rule__Node__Group_9__0 )? )
            {
            // InternalModelDraw.g:1177:1: ( ( rule__Node__Group_9__0 )? )
            // InternalModelDraw.g:1178:2: ( rule__Node__Group_9__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_9()); 
            // InternalModelDraw.g:1179:2: ( rule__Node__Group_9__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==37) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalModelDraw.g:1179:3: rule__Node__Group_9__0
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


    // $ANTLR start "rule__Node__Group_2__0"
    // InternalModelDraw.g:1188:1: rule__Node__Group_2__0 : rule__Node__Group_2__0__Impl rule__Node__Group_2__1 ;
    public final void rule__Node__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1192:1: ( rule__Node__Group_2__0__Impl rule__Node__Group_2__1 )
            // InternalModelDraw.g:1193:2: rule__Node__Group_2__0__Impl rule__Node__Group_2__1
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
    // InternalModelDraw.g:1200:1: rule__Node__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1204:1: ( ( '(' ) )
            // InternalModelDraw.g:1205:1: ( '(' )
            {
            // InternalModelDraw.g:1205:1: ( '(' )
            // InternalModelDraw.g:1206:2: '('
            {
             before(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalModelDraw.g:1215:1: rule__Node__Group_2__1 : rule__Node__Group_2__1__Impl rule__Node__Group_2__2 ;
    public final void rule__Node__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1219:1: ( rule__Node__Group_2__1__Impl rule__Node__Group_2__2 )
            // InternalModelDraw.g:1220:2: rule__Node__Group_2__1__Impl rule__Node__Group_2__2
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
    // InternalModelDraw.g:1227:1: rule__Node__Group_2__1__Impl : ( ( rule__Node__AttributeAssignment_2_1 ) ) ;
    public final void rule__Node__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1231:1: ( ( ( rule__Node__AttributeAssignment_2_1 ) ) )
            // InternalModelDraw.g:1232:1: ( ( rule__Node__AttributeAssignment_2_1 ) )
            {
            // InternalModelDraw.g:1232:1: ( ( rule__Node__AttributeAssignment_2_1 ) )
            // InternalModelDraw.g:1233:2: ( rule__Node__AttributeAssignment_2_1 )
            {
             before(grammarAccess.getNodeAccess().getAttributeAssignment_2_1()); 
            // InternalModelDraw.g:1234:2: ( rule__Node__AttributeAssignment_2_1 )
            // InternalModelDraw.g:1234:3: rule__Node__AttributeAssignment_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__AttributeAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAttributeAssignment_2_1()); 

            }


            }

        }
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
    // InternalModelDraw.g:1242:1: rule__Node__Group_2__2 : rule__Node__Group_2__2__Impl rule__Node__Group_2__3 ;
    public final void rule__Node__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1246:1: ( rule__Node__Group_2__2__Impl rule__Node__Group_2__3 )
            // InternalModelDraw.g:1247:2: rule__Node__Group_2__2__Impl rule__Node__Group_2__3
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
    // InternalModelDraw.g:1254:1: rule__Node__Group_2__2__Impl : ( ( rule__Node__Group_2_2__0 )* ) ;
    public final void rule__Node__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1258:1: ( ( ( rule__Node__Group_2_2__0 )* ) )
            // InternalModelDraw.g:1259:1: ( ( rule__Node__Group_2_2__0 )* )
            {
            // InternalModelDraw.g:1259:1: ( ( rule__Node__Group_2_2__0 )* )
            // InternalModelDraw.g:1260:2: ( rule__Node__Group_2_2__0 )*
            {
             before(grammarAccess.getNodeAccess().getGroup_2_2()); 
            // InternalModelDraw.g:1261:2: ( rule__Node__Group_2_2__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==32) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalModelDraw.g:1261:3: rule__Node__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Node__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // InternalModelDraw.g:1269:1: rule__Node__Group_2__3 : rule__Node__Group_2__3__Impl ;
    public final void rule__Node__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1273:1: ( rule__Node__Group_2__3__Impl )
            // InternalModelDraw.g:1274:2: rule__Node__Group_2__3__Impl
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
    // InternalModelDraw.g:1280:1: rule__Node__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Node__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1284:1: ( ( ')' ) )
            // InternalModelDraw.g:1285:1: ( ')' )
            {
            // InternalModelDraw.g:1285:1: ( ')' )
            // InternalModelDraw.g:1286:2: ')'
            {
             before(grammarAccess.getNodeAccess().getRightParenthesisKeyword_2_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalModelDraw.g:1296:1: rule__Node__Group_2_2__0 : rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 ;
    public final void rule__Node__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1300:1: ( rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 )
            // InternalModelDraw.g:1301:2: rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1
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
    // InternalModelDraw.g:1308:1: rule__Node__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Node__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1312:1: ( ( ',' ) )
            // InternalModelDraw.g:1313:1: ( ',' )
            {
            // InternalModelDraw.g:1313:1: ( ',' )
            // InternalModelDraw.g:1314:2: ','
            {
             before(grammarAccess.getNodeAccess().getCommaKeyword_2_2_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalModelDraw.g:1323:1: rule__Node__Group_2_2__1 : rule__Node__Group_2_2__1__Impl ;
    public final void rule__Node__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1327:1: ( rule__Node__Group_2_2__1__Impl )
            // InternalModelDraw.g:1328:2: rule__Node__Group_2_2__1__Impl
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
    // InternalModelDraw.g:1334:1: rule__Node__Group_2_2__1__Impl : ( ( rule__Node__AttributeAssignment_2_2_1 ) ) ;
    public final void rule__Node__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1338:1: ( ( ( rule__Node__AttributeAssignment_2_2_1 ) ) )
            // InternalModelDraw.g:1339:1: ( ( rule__Node__AttributeAssignment_2_2_1 ) )
            {
            // InternalModelDraw.g:1339:1: ( ( rule__Node__AttributeAssignment_2_2_1 ) )
            // InternalModelDraw.g:1340:2: ( rule__Node__AttributeAssignment_2_2_1 )
            {
             before(grammarAccess.getNodeAccess().getAttributeAssignment_2_2_1()); 
            // InternalModelDraw.g:1341:2: ( rule__Node__AttributeAssignment_2_2_1 )
            // InternalModelDraw.g:1341:3: rule__Node__AttributeAssignment_2_2_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__AttributeAssignment_2_2_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAttributeAssignment_2_2_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Node__Group_5__0"
    // InternalModelDraw.g:1350:1: rule__Node__Group_5__0 : rule__Node__Group_5__0__Impl rule__Node__Group_5__1 ;
    public final void rule__Node__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1354:1: ( rule__Node__Group_5__0__Impl rule__Node__Group_5__1 )
            // InternalModelDraw.g:1355:2: rule__Node__Group_5__0__Impl rule__Node__Group_5__1
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_5__0"


    // $ANTLR start "rule__Node__Group_5__0__Impl"
    // InternalModelDraw.g:1362:1: rule__Node__Group_5__0__Impl : ( '=' ) ;
    public final void rule__Node__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1366:1: ( ( '=' ) )
            // InternalModelDraw.g:1367:1: ( '=' )
            {
            // InternalModelDraw.g:1367:1: ( '=' )
            // InternalModelDraw.g:1368:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_5_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_5__0__Impl"


    // $ANTLR start "rule__Node__Group_5__1"
    // InternalModelDraw.g:1377:1: rule__Node__Group_5__1 : rule__Node__Group_5__1__Impl ;
    public final void rule__Node__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1381:1: ( rule__Node__Group_5__1__Impl )
            // InternalModelDraw.g:1382:2: rule__Node__Group_5__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_5__1"


    // $ANTLR start "rule__Node__Group_5__1__Impl"
    // InternalModelDraw.g:1388:1: rule__Node__Group_5__1__Impl : ( ( rule__Node__AttNameAssignment_5_1 ) ) ;
    public final void rule__Node__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1392:1: ( ( ( rule__Node__AttNameAssignment_5_1 ) ) )
            // InternalModelDraw.g:1393:1: ( ( rule__Node__AttNameAssignment_5_1 ) )
            {
            // InternalModelDraw.g:1393:1: ( ( rule__Node__AttNameAssignment_5_1 ) )
            // InternalModelDraw.g:1394:2: ( rule__Node__AttNameAssignment_5_1 )
            {
             before(grammarAccess.getNodeAccess().getAttNameAssignment_5_1()); 
            // InternalModelDraw.g:1395:2: ( rule__Node__AttNameAssignment_5_1 )
            // InternalModelDraw.g:1395:3: rule__Node__AttNameAssignment_5_1
            {
            pushFollow(FOLLOW_2);
            rule__Node__AttNameAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAttNameAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_5__1__Impl"


    // $ANTLR start "rule__Node__Group_6__0"
    // InternalModelDraw.g:1404:1: rule__Node__Group_6__0 : rule__Node__Group_6__0__Impl rule__Node__Group_6__1 ;
    public final void rule__Node__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1408:1: ( rule__Node__Group_6__0__Impl rule__Node__Group_6__1 )
            // InternalModelDraw.g:1409:2: rule__Node__Group_6__0__Impl rule__Node__Group_6__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:1416:1: rule__Node__Group_6__0__Impl : ( 'compartments' ) ;
    public final void rule__Node__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1420:1: ( ( 'compartments' ) )
            // InternalModelDraw.g:1421:1: ( 'compartments' )
            {
            // InternalModelDraw.g:1421:1: ( 'compartments' )
            // InternalModelDraw.g:1422:2: 'compartments'
            {
             before(grammarAccess.getNodeAccess().getCompartmentsKeyword_6_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getCompartmentsKeyword_6_0()); 

            }


            }

        }
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
    // InternalModelDraw.g:1431:1: rule__Node__Group_6__1 : rule__Node__Group_6__1__Impl rule__Node__Group_6__2 ;
    public final void rule__Node__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1435:1: ( rule__Node__Group_6__1__Impl rule__Node__Group_6__2 )
            // InternalModelDraw.g:1436:2: rule__Node__Group_6__1__Impl rule__Node__Group_6__2
            {
            pushFollow(FOLLOW_8);
            rule__Node__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_6__2();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:1443:1: rule__Node__Group_6__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1447:1: ( ( '=' ) )
            // InternalModelDraw.g:1448:1: ( '=' )
            {
            // InternalModelDraw.g:1448:1: ( '=' )
            // InternalModelDraw.g:1449:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_6_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_6_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Node__Group_6__2"
    // InternalModelDraw.g:1458:1: rule__Node__Group_6__2 : rule__Node__Group_6__2__Impl rule__Node__Group_6__3 ;
    public final void rule__Node__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1462:1: ( rule__Node__Group_6__2__Impl rule__Node__Group_6__3 )
            // InternalModelDraw.g:1463:2: rule__Node__Group_6__2__Impl rule__Node__Group_6__3
            {
            pushFollow(FOLLOW_5);
            rule__Node__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_6__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__2"


    // $ANTLR start "rule__Node__Group_6__2__Impl"
    // InternalModelDraw.g:1470:1: rule__Node__Group_6__2__Impl : ( '{' ) ;
    public final void rule__Node__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1474:1: ( ( '{' ) )
            // InternalModelDraw.g:1475:1: ( '{' )
            {
            // InternalModelDraw.g:1475:1: ( '{' )
            // InternalModelDraw.g:1476:2: '{'
            {
             before(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_6_2()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_6_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__2__Impl"


    // $ANTLR start "rule__Node__Group_6__3"
    // InternalModelDraw.g:1485:1: rule__Node__Group_6__3 : rule__Node__Group_6__3__Impl rule__Node__Group_6__4 ;
    public final void rule__Node__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1489:1: ( rule__Node__Group_6__3__Impl rule__Node__Group_6__4 )
            // InternalModelDraw.g:1490:2: rule__Node__Group_6__3__Impl rule__Node__Group_6__4
            {
            pushFollow(FOLLOW_9);
            rule__Node__Group_6__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_6__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__3"


    // $ANTLR start "rule__Node__Group_6__3__Impl"
    // InternalModelDraw.g:1497:1: rule__Node__Group_6__3__Impl : ( ( rule__Node__ReferenceAssignment_6_3 ) ) ;
    public final void rule__Node__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1501:1: ( ( ( rule__Node__ReferenceAssignment_6_3 ) ) )
            // InternalModelDraw.g:1502:1: ( ( rule__Node__ReferenceAssignment_6_3 ) )
            {
            // InternalModelDraw.g:1502:1: ( ( rule__Node__ReferenceAssignment_6_3 ) )
            // InternalModelDraw.g:1503:2: ( rule__Node__ReferenceAssignment_6_3 )
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_6_3()); 
            // InternalModelDraw.g:1504:2: ( rule__Node__ReferenceAssignment_6_3 )
            // InternalModelDraw.g:1504:3: rule__Node__ReferenceAssignment_6_3
            {
            pushFollow(FOLLOW_2);
            rule__Node__ReferenceAssignment_6_3();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getReferenceAssignment_6_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__3__Impl"


    // $ANTLR start "rule__Node__Group_6__4"
    // InternalModelDraw.g:1512:1: rule__Node__Group_6__4 : rule__Node__Group_6__4__Impl rule__Node__Group_6__5 ;
    public final void rule__Node__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1516:1: ( rule__Node__Group_6__4__Impl rule__Node__Group_6__5 )
            // InternalModelDraw.g:1517:2: rule__Node__Group_6__4__Impl rule__Node__Group_6__5
            {
            pushFollow(FOLLOW_9);
            rule__Node__Group_6__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Node__Group_6__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__4"


    // $ANTLR start "rule__Node__Group_6__4__Impl"
    // InternalModelDraw.g:1524:1: rule__Node__Group_6__4__Impl : ( ( rule__Node__ReferenceAssignment_6_4 )* ) ;
    public final void rule__Node__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1528:1: ( ( ( rule__Node__ReferenceAssignment_6_4 )* ) )
            // InternalModelDraw.g:1529:1: ( ( rule__Node__ReferenceAssignment_6_4 )* )
            {
            // InternalModelDraw.g:1529:1: ( ( rule__Node__ReferenceAssignment_6_4 )* )
            // InternalModelDraw.g:1530:2: ( rule__Node__ReferenceAssignment_6_4 )*
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_6_4()); 
            // InternalModelDraw.g:1531:2: ( rule__Node__ReferenceAssignment_6_4 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalModelDraw.g:1531:3: rule__Node__ReferenceAssignment_6_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Node__ReferenceAssignment_6_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getNodeAccess().getReferenceAssignment_6_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__4__Impl"


    // $ANTLR start "rule__Node__Group_6__5"
    // InternalModelDraw.g:1539:1: rule__Node__Group_6__5 : rule__Node__Group_6__5__Impl ;
    public final void rule__Node__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1543:1: ( rule__Node__Group_6__5__Impl )
            // InternalModelDraw.g:1544:2: rule__Node__Group_6__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_6__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__5"


    // $ANTLR start "rule__Node__Group_6__5__Impl"
    // InternalModelDraw.g:1550:1: rule__Node__Group_6__5__Impl : ( '}' ) ;
    public final void rule__Node__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1554:1: ( ( '}' ) )
            // InternalModelDraw.g:1555:1: ( '}' )
            {
            // InternalModelDraw.g:1555:1: ( '}' )
            // InternalModelDraw.g:1556:2: '}'
            {
             before(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_6_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_6_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__Group_6__5__Impl"


    // $ANTLR start "rule__Node__Group_7__0"
    // InternalModelDraw.g:1566:1: rule__Node__Group_7__0 : rule__Node__Group_7__0__Impl rule__Node__Group_7__1 ;
    public final void rule__Node__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1570:1: ( rule__Node__Group_7__0__Impl rule__Node__Group_7__1 )
            // InternalModelDraw.g:1571:2: rule__Node__Group_7__0__Impl rule__Node__Group_7__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:1578:1: rule__Node__Group_7__0__Impl : ( 'shape' ) ;
    public final void rule__Node__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1582:1: ( ( 'shape' ) )
            // InternalModelDraw.g:1583:1: ( 'shape' )
            {
            // InternalModelDraw.g:1583:1: ( 'shape' )
            // InternalModelDraw.g:1584:2: 'shape'
            {
             before(grammarAccess.getNodeAccess().getShapeKeyword_7_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getShapeKeyword_7_0()); 

            }


            }

        }
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
    // InternalModelDraw.g:1593:1: rule__Node__Group_7__1 : rule__Node__Group_7__1__Impl rule__Node__Group_7__2 ;
    public final void rule__Node__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1597:1: ( rule__Node__Group_7__1__Impl rule__Node__Group_7__2 )
            // InternalModelDraw.g:1598:2: rule__Node__Group_7__1__Impl rule__Node__Group_7__2
            {
            pushFollow(FOLLOW_18);
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
    // InternalModelDraw.g:1605:1: rule__Node__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1609:1: ( ( '=' ) )
            // InternalModelDraw.g:1610:1: ( '=' )
            {
            // InternalModelDraw.g:1610:1: ( '=' )
            // InternalModelDraw.g:1611:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_7_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:1620:1: rule__Node__Group_7__2 : rule__Node__Group_7__2__Impl ;
    public final void rule__Node__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1624:1: ( rule__Node__Group_7__2__Impl )
            // InternalModelDraw.g:1625:2: rule__Node__Group_7__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_7__2__Impl();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:1631:1: rule__Node__Group_7__2__Impl : ( ( rule__Node__ShapeAssignment_7_2 ) ) ;
    public final void rule__Node__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1635:1: ( ( ( rule__Node__ShapeAssignment_7_2 ) ) )
            // InternalModelDraw.g:1636:1: ( ( rule__Node__ShapeAssignment_7_2 ) )
            {
            // InternalModelDraw.g:1636:1: ( ( rule__Node__ShapeAssignment_7_2 ) )
            // InternalModelDraw.g:1637:2: ( rule__Node__ShapeAssignment_7_2 )
            {
             before(grammarAccess.getNodeAccess().getShapeAssignment_7_2()); 
            // InternalModelDraw.g:1638:2: ( rule__Node__ShapeAssignment_7_2 )
            // InternalModelDraw.g:1638:3: rule__Node__ShapeAssignment_7_2
            {
            pushFollow(FOLLOW_2);
            rule__Node__ShapeAssignment_7_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getShapeAssignment_7_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Node__Group_8__0"
    // InternalModelDraw.g:1647:1: rule__Node__Group_8__0 : rule__Node__Group_8__0__Impl rule__Node__Group_8__1 ;
    public final void rule__Node__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1651:1: ( rule__Node__Group_8__0__Impl rule__Node__Group_8__1 )
            // InternalModelDraw.g:1652:2: rule__Node__Group_8__0__Impl rule__Node__Group_8__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:1659:1: rule__Node__Group_8__0__Impl : ( 'color' ) ;
    public final void rule__Node__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1663:1: ( ( 'color' ) )
            // InternalModelDraw.g:1664:1: ( 'color' )
            {
            // InternalModelDraw.g:1664:1: ( 'color' )
            // InternalModelDraw.g:1665:2: 'color'
            {
             before(grammarAccess.getNodeAccess().getColorKeyword_8_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getColorKeyword_8_0()); 

            }


            }

        }
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
    // InternalModelDraw.g:1674:1: rule__Node__Group_8__1 : rule__Node__Group_8__1__Impl rule__Node__Group_8__2 ;
    public final void rule__Node__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1678:1: ( rule__Node__Group_8__1__Impl rule__Node__Group_8__2 )
            // InternalModelDraw.g:1679:2: rule__Node__Group_8__1__Impl rule__Node__Group_8__2
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
    // InternalModelDraw.g:1686:1: rule__Node__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1690:1: ( ( '=' ) )
            // InternalModelDraw.g:1691:1: ( '=' )
            {
            // InternalModelDraw.g:1691:1: ( '=' )
            // InternalModelDraw.g:1692:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_8_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:1701:1: rule__Node__Group_8__2 : rule__Node__Group_8__2__Impl ;
    public final void rule__Node__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1705:1: ( rule__Node__Group_8__2__Impl )
            // InternalModelDraw.g:1706:2: rule__Node__Group_8__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Node__Group_8__2__Impl();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:1712:1: rule__Node__Group_8__2__Impl : ( ( rule__Node__ColorAssignment_8_2 ) ) ;
    public final void rule__Node__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1716:1: ( ( ( rule__Node__ColorAssignment_8_2 ) ) )
            // InternalModelDraw.g:1717:1: ( ( rule__Node__ColorAssignment_8_2 ) )
            {
            // InternalModelDraw.g:1717:1: ( ( rule__Node__ColorAssignment_8_2 ) )
            // InternalModelDraw.g:1718:2: ( rule__Node__ColorAssignment_8_2 )
            {
             before(grammarAccess.getNodeAccess().getColorAssignment_8_2()); 
            // InternalModelDraw.g:1719:2: ( rule__Node__ColorAssignment_8_2 )
            // InternalModelDraw.g:1719:3: rule__Node__ColorAssignment_8_2
            {
            pushFollow(FOLLOW_2);
            rule__Node__ColorAssignment_8_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getColorAssignment_8_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Node__Group_9__0"
    // InternalModelDraw.g:1728:1: rule__Node__Group_9__0 : rule__Node__Group_9__0__Impl rule__Node__Group_9__1 ;
    public final void rule__Node__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1732:1: ( rule__Node__Group_9__0__Impl rule__Node__Group_9__1 )
            // InternalModelDraw.g:1733:2: rule__Node__Group_9__0__Impl rule__Node__Group_9__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:1740:1: rule__Node__Group_9__0__Impl : ( 'style' ) ;
    public final void rule__Node__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1744:1: ( ( 'style' ) )
            // InternalModelDraw.g:1745:1: ( 'style' )
            {
            // InternalModelDraw.g:1745:1: ( 'style' )
            // InternalModelDraw.g:1746:2: 'style'
            {
             before(grammarAccess.getNodeAccess().getStyleKeyword_9_0()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getStyleKeyword_9_0()); 

            }


            }

        }
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
    // InternalModelDraw.g:1755:1: rule__Node__Group_9__1 : rule__Node__Group_9__1__Impl rule__Node__Group_9__2 ;
    public final void rule__Node__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1759:1: ( rule__Node__Group_9__1__Impl rule__Node__Group_9__2 )
            // InternalModelDraw.g:1760:2: rule__Node__Group_9__1__Impl rule__Node__Group_9__2
            {
            pushFollow(FOLLOW_20);
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
    // InternalModelDraw.g:1767:1: rule__Node__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1771:1: ( ( '=' ) )
            // InternalModelDraw.g:1772:1: ( '=' )
            {
            // InternalModelDraw.g:1772:1: ( '=' )
            // InternalModelDraw.g:1773:2: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_9_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:1782:1: rule__Node__Group_9__2 : rule__Node__Group_9__2__Impl ;
    public final void rule__Node__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1786:1: ( rule__Node__Group_9__2__Impl )
            // InternalModelDraw.g:1787:2: rule__Node__Group_9__2__Impl
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
    // InternalModelDraw.g:1793:1: rule__Node__Group_9__2__Impl : ( ( rule__Node__StyleAssignment_9_2 ) ) ;
    public final void rule__Node__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1797:1: ( ( ( rule__Node__StyleAssignment_9_2 ) ) )
            // InternalModelDraw.g:1798:1: ( ( rule__Node__StyleAssignment_9_2 ) )
            {
            // InternalModelDraw.g:1798:1: ( ( rule__Node__StyleAssignment_9_2 ) )
            // InternalModelDraw.g:1799:2: ( rule__Node__StyleAssignment_9_2 )
            {
             before(grammarAccess.getNodeAccess().getStyleAssignment_9_2()); 
            // InternalModelDraw.g:1800:2: ( rule__Node__StyleAssignment_9_2 )
            // InternalModelDraw.g:1800:3: rule__Node__StyleAssignment_9_2
            {
            pushFollow(FOLLOW_2);
            rule__Node__StyleAssignment_9_2();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getStyleAssignment_9_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__BooleanAttribute__Group__0"
    // InternalModelDraw.g:1809:1: rule__BooleanAttribute__Group__0 : rule__BooleanAttribute__Group__0__Impl rule__BooleanAttribute__Group__1 ;
    public final void rule__BooleanAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1813:1: ( rule__BooleanAttribute__Group__0__Impl rule__BooleanAttribute__Group__1 )
            // InternalModelDraw.g:1814:2: rule__BooleanAttribute__Group__0__Impl rule__BooleanAttribute__Group__1
            {
            pushFollow(FOLLOW_14);
            rule__BooleanAttribute__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanAttribute__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__Group__0"


    // $ANTLR start "rule__BooleanAttribute__Group__0__Impl"
    // InternalModelDraw.g:1821:1: rule__BooleanAttribute__Group__0__Impl : ( () ) ;
    public final void rule__BooleanAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1825:1: ( ( () ) )
            // InternalModelDraw.g:1826:1: ( () )
            {
            // InternalModelDraw.g:1826:1: ( () )
            // InternalModelDraw.g:1827:2: ()
            {
             before(grammarAccess.getBooleanAttributeAccess().getBooleanAttributeAction_0()); 
            // InternalModelDraw.g:1828:2: ()
            // InternalModelDraw.g:1828:3: 
            {
            }

             after(grammarAccess.getBooleanAttributeAccess().getBooleanAttributeAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__Group__0__Impl"


    // $ANTLR start "rule__BooleanAttribute__Group__1"
    // InternalModelDraw.g:1836:1: rule__BooleanAttribute__Group__1 : rule__BooleanAttribute__Group__1__Impl rule__BooleanAttribute__Group__2 ;
    public final void rule__BooleanAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1840:1: ( rule__BooleanAttribute__Group__1__Impl rule__BooleanAttribute__Group__2 )
            // InternalModelDraw.g:1841:2: rule__BooleanAttribute__Group__1__Impl rule__BooleanAttribute__Group__2
            {
            pushFollow(FOLLOW_14);
            rule__BooleanAttribute__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__BooleanAttribute__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__Group__1"


    // $ANTLR start "rule__BooleanAttribute__Group__1__Impl"
    // InternalModelDraw.g:1848:1: rule__BooleanAttribute__Group__1__Impl : ( ( rule__BooleanAttribute__NegationAssignment_1 )? ) ;
    public final void rule__BooleanAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1852:1: ( ( ( rule__BooleanAttribute__NegationAssignment_1 )? ) )
            // InternalModelDraw.g:1853:1: ( ( rule__BooleanAttribute__NegationAssignment_1 )? )
            {
            // InternalModelDraw.g:1853:1: ( ( rule__BooleanAttribute__NegationAssignment_1 )? )
            // InternalModelDraw.g:1854:2: ( rule__BooleanAttribute__NegationAssignment_1 )?
            {
             before(grammarAccess.getBooleanAttributeAccess().getNegationAssignment_1()); 
            // InternalModelDraw.g:1855:2: ( rule__BooleanAttribute__NegationAssignment_1 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==49) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalModelDraw.g:1855:3: rule__BooleanAttribute__NegationAssignment_1
                    {
                    pushFollow(FOLLOW_2);
                    rule__BooleanAttribute__NegationAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getBooleanAttributeAccess().getNegationAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__Group__1__Impl"


    // $ANTLR start "rule__BooleanAttribute__Group__2"
    // InternalModelDraw.g:1863:1: rule__BooleanAttribute__Group__2 : rule__BooleanAttribute__Group__2__Impl ;
    public final void rule__BooleanAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1867:1: ( rule__BooleanAttribute__Group__2__Impl )
            // InternalModelDraw.g:1868:2: rule__BooleanAttribute__Group__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__BooleanAttribute__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__Group__2"


    // $ANTLR start "rule__BooleanAttribute__Group__2__Impl"
    // InternalModelDraw.g:1874:1: rule__BooleanAttribute__Group__2__Impl : ( ( rule__BooleanAttribute__AttAssignment_2 ) ) ;
    public final void rule__BooleanAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1878:1: ( ( ( rule__BooleanAttribute__AttAssignment_2 ) ) )
            // InternalModelDraw.g:1879:1: ( ( rule__BooleanAttribute__AttAssignment_2 ) )
            {
            // InternalModelDraw.g:1879:1: ( ( rule__BooleanAttribute__AttAssignment_2 ) )
            // InternalModelDraw.g:1880:2: ( rule__BooleanAttribute__AttAssignment_2 )
            {
             before(grammarAccess.getBooleanAttributeAccess().getAttAssignment_2()); 
            // InternalModelDraw.g:1881:2: ( rule__BooleanAttribute__AttAssignment_2 )
            // InternalModelDraw.g:1881:3: rule__BooleanAttribute__AttAssignment_2
            {
            pushFollow(FOLLOW_2);
            rule__BooleanAttribute__AttAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getBooleanAttributeAccess().getAttAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__Group__2__Impl"


    // $ANTLR start "rule__Edge__Group__0"
    // InternalModelDraw.g:1890:1: rule__Edge__Group__0 : rule__Edge__Group__0__Impl rule__Edge__Group__1 ;
    public final void rule__Edge__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1894:1: ( rule__Edge__Group__0__Impl rule__Edge__Group__1 )
            // InternalModelDraw.g:1895:2: rule__Edge__Group__0__Impl rule__Edge__Group__1
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
    // InternalModelDraw.g:1902:1: rule__Edge__Group__0__Impl : ( () ) ;
    public final void rule__Edge__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1906:1: ( ( () ) )
            // InternalModelDraw.g:1907:1: ( () )
            {
            // InternalModelDraw.g:1907:1: ( () )
            // InternalModelDraw.g:1908:2: ()
            {
             before(grammarAccess.getEdgeAccess().getEdgeAction_0()); 
            // InternalModelDraw.g:1909:2: ()
            // InternalModelDraw.g:1909:3: 
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
    // InternalModelDraw.g:1917:1: rule__Edge__Group__1 : rule__Edge__Group__1__Impl rule__Edge__Group__2 ;
    public final void rule__Edge__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1921:1: ( rule__Edge__Group__1__Impl rule__Edge__Group__2 )
            // InternalModelDraw.g:1922:2: rule__Edge__Group__1__Impl rule__Edge__Group__2
            {
            pushFollow(FOLLOW_21);
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
    // InternalModelDraw.g:1929:1: rule__Edge__Group__1__Impl : ( ( rule__Edge__NameAssignment_1 ) ) ;
    public final void rule__Edge__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1933:1: ( ( ( rule__Edge__NameAssignment_1 ) ) )
            // InternalModelDraw.g:1934:1: ( ( rule__Edge__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:1934:1: ( ( rule__Edge__NameAssignment_1 ) )
            // InternalModelDraw.g:1935:2: ( rule__Edge__NameAssignment_1 )
            {
             before(grammarAccess.getEdgeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:1936:2: ( rule__Edge__NameAssignment_1 )
            // InternalModelDraw.g:1936:3: rule__Edge__NameAssignment_1
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
    // InternalModelDraw.g:1944:1: rule__Edge__Group__2 : rule__Edge__Group__2__Impl rule__Edge__Group__3 ;
    public final void rule__Edge__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1948:1: ( rule__Edge__Group__2__Impl rule__Edge__Group__3 )
            // InternalModelDraw.g:1949:2: rule__Edge__Group__2__Impl rule__Edge__Group__3
            {
            pushFollow(FOLLOW_5);
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
    // InternalModelDraw.g:1956:1: rule__Edge__Group__2__Impl : ( '(' ) ;
    public final void rule__Edge__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1960:1: ( ( '(' ) )
            // InternalModelDraw.g:1961:1: ( '(' )
            {
            // InternalModelDraw.g:1961:1: ( '(' )
            // InternalModelDraw.g:1962:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
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
    // InternalModelDraw.g:1971:1: rule__Edge__Group__3 : rule__Edge__Group__3__Impl rule__Edge__Group__4 ;
    public final void rule__Edge__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1975:1: ( rule__Edge__Group__3__Impl rule__Edge__Group__4 )
            // InternalModelDraw.g:1976:2: rule__Edge__Group__3__Impl rule__Edge__Group__4
            {
            pushFollow(FOLLOW_22);
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
    // InternalModelDraw.g:1983:1: rule__Edge__Group__3__Impl : ( ( rule__Edge__SourceAssignment_3 ) ) ;
    public final void rule__Edge__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1987:1: ( ( ( rule__Edge__SourceAssignment_3 ) ) )
            // InternalModelDraw.g:1988:1: ( ( rule__Edge__SourceAssignment_3 ) )
            {
            // InternalModelDraw.g:1988:1: ( ( rule__Edge__SourceAssignment_3 ) )
            // InternalModelDraw.g:1989:2: ( rule__Edge__SourceAssignment_3 )
            {
             before(grammarAccess.getEdgeAccess().getSourceAssignment_3()); 
            // InternalModelDraw.g:1990:2: ( rule__Edge__SourceAssignment_3 )
            // InternalModelDraw.g:1990:3: rule__Edge__SourceAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Edge__SourceAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getSourceAssignment_3()); 

            }


            }

        }
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
    // InternalModelDraw.g:1998:1: rule__Edge__Group__4 : rule__Edge__Group__4__Impl rule__Edge__Group__5 ;
    public final void rule__Edge__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2002:1: ( rule__Edge__Group__4__Impl rule__Edge__Group__5 )
            // InternalModelDraw.g:2003:2: rule__Edge__Group__4__Impl rule__Edge__Group__5
            {
            pushFollow(FOLLOW_5);
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
    // InternalModelDraw.g:2010:1: rule__Edge__Group__4__Impl : ( ',' ) ;
    public final void rule__Edge__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2014:1: ( ( ',' ) )
            // InternalModelDraw.g:2015:1: ( ',' )
            {
            // InternalModelDraw.g:2015:1: ( ',' )
            // InternalModelDraw.g:2016:2: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_4()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_4()); 

            }


            }

        }
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
    // InternalModelDraw.g:2025:1: rule__Edge__Group__5 : rule__Edge__Group__5__Impl rule__Edge__Group__6 ;
    public final void rule__Edge__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2029:1: ( rule__Edge__Group__5__Impl rule__Edge__Group__6 )
            // InternalModelDraw.g:2030:2: rule__Edge__Group__5__Impl rule__Edge__Group__6
            {
            pushFollow(FOLLOW_23);
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
    // InternalModelDraw.g:2037:1: rule__Edge__Group__5__Impl : ( ( rule__Edge__TargetAssignment_5 ) ) ;
    public final void rule__Edge__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2041:1: ( ( ( rule__Edge__TargetAssignment_5 ) ) )
            // InternalModelDraw.g:2042:1: ( ( rule__Edge__TargetAssignment_5 ) )
            {
            // InternalModelDraw.g:2042:1: ( ( rule__Edge__TargetAssignment_5 ) )
            // InternalModelDraw.g:2043:2: ( rule__Edge__TargetAssignment_5 )
            {
             before(grammarAccess.getEdgeAccess().getTargetAssignment_5()); 
            // InternalModelDraw.g:2044:2: ( rule__Edge__TargetAssignment_5 )
            // InternalModelDraw.g:2044:3: rule__Edge__TargetAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Edge__TargetAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTargetAssignment_5()); 

            }


            }

        }
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
    // InternalModelDraw.g:2052:1: rule__Edge__Group__6 : rule__Edge__Group__6__Impl rule__Edge__Group__7 ;
    public final void rule__Edge__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2056:1: ( rule__Edge__Group__6__Impl rule__Edge__Group__7 )
            // InternalModelDraw.g:2057:2: rule__Edge__Group__6__Impl rule__Edge__Group__7
            {
            pushFollow(FOLLOW_6);
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
    // InternalModelDraw.g:2064:1: rule__Edge__Group__6__Impl : ( ')' ) ;
    public final void rule__Edge__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2068:1: ( ( ')' ) )
            // InternalModelDraw.g:2069:1: ( ')' )
            {
            // InternalModelDraw.g:2069:1: ( ')' )
            // InternalModelDraw.g:2070:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_6()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
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
    // InternalModelDraw.g:2079:1: rule__Edge__Group__7 : rule__Edge__Group__7__Impl rule__Edge__Group__8 ;
    public final void rule__Edge__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2083:1: ( rule__Edge__Group__7__Impl rule__Edge__Group__8 )
            // InternalModelDraw.g:2084:2: rule__Edge__Group__7__Impl rule__Edge__Group__8
            {
            pushFollow(FOLLOW_24);
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
    // InternalModelDraw.g:2091:1: rule__Edge__Group__7__Impl : ( ':' ) ;
    public final void rule__Edge__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2095:1: ( ( ':' ) )
            // InternalModelDraw.g:2096:1: ( ':' )
            {
            // InternalModelDraw.g:2096:1: ( ':' )
            // InternalModelDraw.g:2097:2: ':'
            {
             before(grammarAccess.getEdgeAccess().getColonKeyword_7()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getColonKeyword_7()); 

            }


            }

        }
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
    // InternalModelDraw.g:2106:1: rule__Edge__Group__8 : rule__Edge__Group__8__Impl rule__Edge__Group__9 ;
    public final void rule__Edge__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2110:1: ( rule__Edge__Group__8__Impl rule__Edge__Group__9 )
            // InternalModelDraw.g:2111:2: rule__Edge__Group__8__Impl rule__Edge__Group__9
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:2118:1: rule__Edge__Group__8__Impl : ( 'edge' ) ;
    public final void rule__Edge__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2122:1: ( ( 'edge' ) )
            // InternalModelDraw.g:2123:1: ( 'edge' )
            {
            // InternalModelDraw.g:2123:1: ( 'edge' )
            // InternalModelDraw.g:2124:2: 'edge'
            {
             before(grammarAccess.getEdgeAccess().getEdgeKeyword_8()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEdgeKeyword_8()); 

            }


            }

        }
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
    // InternalModelDraw.g:2133:1: rule__Edge__Group__9 : rule__Edge__Group__9__Impl rule__Edge__Group__10 ;
    public final void rule__Edge__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2137:1: ( rule__Edge__Group__9__Impl rule__Edge__Group__10 )
            // InternalModelDraw.g:2138:2: rule__Edge__Group__9__Impl rule__Edge__Group__10
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:2145:1: rule__Edge__Group__9__Impl : ( ( rule__Edge__Group_9__0 )? ) ;
    public final void rule__Edge__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2149:1: ( ( ( rule__Edge__Group_9__0 )? ) )
            // InternalModelDraw.g:2150:1: ( ( rule__Edge__Group_9__0 )? )
            {
            // InternalModelDraw.g:2150:1: ( ( rule__Edge__Group_9__0 )? )
            // InternalModelDraw.g:2151:2: ( rule__Edge__Group_9__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_9()); 
            // InternalModelDraw.g:2152:2: ( rule__Edge__Group_9__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==33) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalModelDraw.g:2152:3: rule__Edge__Group_9__0
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
    // InternalModelDraw.g:2160:1: rule__Edge__Group__10 : rule__Edge__Group__10__Impl rule__Edge__Group__11 ;
    public final void rule__Edge__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2164:1: ( rule__Edge__Group__10__Impl rule__Edge__Group__11 )
            // InternalModelDraw.g:2165:2: rule__Edge__Group__10__Impl rule__Edge__Group__11
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:2172:1: rule__Edge__Group__10__Impl : ( ( rule__Edge__Group_10__0 )? ) ;
    public final void rule__Edge__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2176:1: ( ( ( rule__Edge__Group_10__0 )? ) )
            // InternalModelDraw.g:2177:1: ( ( rule__Edge__Group_10__0 )? )
            {
            // InternalModelDraw.g:2177:1: ( ( rule__Edge__Group_10__0 )? )
            // InternalModelDraw.g:2178:2: ( rule__Edge__Group_10__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10()); 
            // InternalModelDraw.g:2179:2: ( rule__Edge__Group_10__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==39) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalModelDraw.g:2179:3: rule__Edge__Group_10__0
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
    // InternalModelDraw.g:2187:1: rule__Edge__Group__11 : rule__Edge__Group__11__Impl rule__Edge__Group__12 ;
    public final void rule__Edge__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2191:1: ( rule__Edge__Group__11__Impl rule__Edge__Group__12 )
            // InternalModelDraw.g:2192:2: rule__Edge__Group__11__Impl rule__Edge__Group__12
            {
            pushFollow(FOLLOW_25);
            rule__Edge__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__12();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:2199:1: rule__Edge__Group__11__Impl : ( ( rule__Edge__Group_11__0 )? ) ;
    public final void rule__Edge__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2203:1: ( ( ( rule__Edge__Group_11__0 )? ) )
            // InternalModelDraw.g:2204:1: ( ( rule__Edge__Group_11__0 )? )
            {
            // InternalModelDraw.g:2204:1: ( ( rule__Edge__Group_11__0 )? )
            // InternalModelDraw.g:2205:2: ( rule__Edge__Group_11__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_11()); 
            // InternalModelDraw.g:2206:2: ( rule__Edge__Group_11__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==42) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalModelDraw.g:2206:3: rule__Edge__Group_11__0
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


    // $ANTLR start "rule__Edge__Group__12"
    // InternalModelDraw.g:2214:1: rule__Edge__Group__12 : rule__Edge__Group__12__Impl rule__Edge__Group__13 ;
    public final void rule__Edge__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2218:1: ( rule__Edge__Group__12__Impl rule__Edge__Group__13 )
            // InternalModelDraw.g:2219:2: rule__Edge__Group__12__Impl rule__Edge__Group__13
            {
            pushFollow(FOLLOW_25);
            rule__Edge__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__13();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__12"


    // $ANTLR start "rule__Edge__Group__12__Impl"
    // InternalModelDraw.g:2226:1: rule__Edge__Group__12__Impl : ( ( rule__Edge__Group_12__0 )? ) ;
    public final void rule__Edge__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2230:1: ( ( ( rule__Edge__Group_12__0 )? ) )
            // InternalModelDraw.g:2231:1: ( ( rule__Edge__Group_12__0 )? )
            {
            // InternalModelDraw.g:2231:1: ( ( rule__Edge__Group_12__0 )? )
            // InternalModelDraw.g:2232:2: ( rule__Edge__Group_12__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_12()); 
            // InternalModelDraw.g:2233:2: ( rule__Edge__Group_12__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==43) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalModelDraw.g:2233:3: rule__Edge__Group_12__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_12__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_12()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__12__Impl"


    // $ANTLR start "rule__Edge__Group__13"
    // InternalModelDraw.g:2241:1: rule__Edge__Group__13 : rule__Edge__Group__13__Impl rule__Edge__Group__14 ;
    public final void rule__Edge__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2245:1: ( rule__Edge__Group__13__Impl rule__Edge__Group__14 )
            // InternalModelDraw.g:2246:2: rule__Edge__Group__13__Impl rule__Edge__Group__14
            {
            pushFollow(FOLLOW_25);
            rule__Edge__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group__14();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__13"


    // $ANTLR start "rule__Edge__Group__13__Impl"
    // InternalModelDraw.g:2253:1: rule__Edge__Group__13__Impl : ( ( rule__Edge__Group_13__0 )? ) ;
    public final void rule__Edge__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2257:1: ( ( ( rule__Edge__Group_13__0 )? ) )
            // InternalModelDraw.g:2258:1: ( ( rule__Edge__Group_13__0 )? )
            {
            // InternalModelDraw.g:2258:1: ( ( rule__Edge__Group_13__0 )? )
            // InternalModelDraw.g:2259:2: ( rule__Edge__Group_13__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_13()); 
            // InternalModelDraw.g:2260:2: ( rule__Edge__Group_13__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==44) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalModelDraw.g:2260:3: rule__Edge__Group_13__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_13__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_13()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__13__Impl"


    // $ANTLR start "rule__Edge__Group__14"
    // InternalModelDraw.g:2268:1: rule__Edge__Group__14 : rule__Edge__Group__14__Impl ;
    public final void rule__Edge__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2272:1: ( rule__Edge__Group__14__Impl )
            // InternalModelDraw.g:2273:2: rule__Edge__Group__14__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group__14__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__14"


    // $ANTLR start "rule__Edge__Group__14__Impl"
    // InternalModelDraw.g:2279:1: rule__Edge__Group__14__Impl : ( ( rule__Edge__Group_14__0 )? ) ;
    public final void rule__Edge__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2283:1: ( ( ( rule__Edge__Group_14__0 )? ) )
            // InternalModelDraw.g:2284:1: ( ( rule__Edge__Group_14__0 )? )
            {
            // InternalModelDraw.g:2284:1: ( ( rule__Edge__Group_14__0 )? )
            // InternalModelDraw.g:2285:2: ( rule__Edge__Group_14__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_14()); 
            // InternalModelDraw.g:2286:2: ( rule__Edge__Group_14__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==45) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalModelDraw.g:2286:3: rule__Edge__Group_14__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_14__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_14()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group__14__Impl"


    // $ANTLR start "rule__Edge__Group_9__0"
    // InternalModelDraw.g:2295:1: rule__Edge__Group_9__0 : rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 ;
    public final void rule__Edge__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2299:1: ( rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 )
            // InternalModelDraw.g:2300:2: rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1
            {
            pushFollow(FOLLOW_5);
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
    // InternalModelDraw.g:2307:1: rule__Edge__Group_9__0__Impl : ( '=' ) ;
    public final void rule__Edge__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2311:1: ( ( '=' ) )
            // InternalModelDraw.g:2312:1: ( '=' )
            {
            // InternalModelDraw.g:2312:1: ( '=' )
            // InternalModelDraw.g:2313:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_9_0()); 

            }


            }

        }
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
    // InternalModelDraw.g:2322:1: rule__Edge__Group_9__1 : rule__Edge__Group_9__1__Impl ;
    public final void rule__Edge__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2326:1: ( rule__Edge__Group_9__1__Impl )
            // InternalModelDraw.g:2327:2: rule__Edge__Group_9__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_9__1__Impl();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:2333:1: rule__Edge__Group_9__1__Impl : ( ( rule__Edge__AttNameAssignment_9_1 ) ) ;
    public final void rule__Edge__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2337:1: ( ( ( rule__Edge__AttNameAssignment_9_1 ) ) )
            // InternalModelDraw.g:2338:1: ( ( rule__Edge__AttNameAssignment_9_1 ) )
            {
            // InternalModelDraw.g:2338:1: ( ( rule__Edge__AttNameAssignment_9_1 ) )
            // InternalModelDraw.g:2339:2: ( rule__Edge__AttNameAssignment_9_1 )
            {
             before(grammarAccess.getEdgeAccess().getAttNameAssignment_9_1()); 
            // InternalModelDraw.g:2340:2: ( rule__Edge__AttNameAssignment_9_1 )
            // InternalModelDraw.g:2340:3: rule__Edge__AttNameAssignment_9_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__AttNameAssignment_9_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getAttNameAssignment_9_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Edge__Group_10__0"
    // InternalModelDraw.g:2349:1: rule__Edge__Group_10__0 : rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 ;
    public final void rule__Edge__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2353:1: ( rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 )
            // InternalModelDraw.g:2354:2: rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:2361:1: rule__Edge__Group_10__0__Impl : ( 'label' ) ;
    public final void rule__Edge__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2365:1: ( ( 'label' ) )
            // InternalModelDraw.g:2366:1: ( 'label' )
            {
            // InternalModelDraw.g:2366:1: ( 'label' )
            // InternalModelDraw.g:2367:2: 'label'
            {
             before(grammarAccess.getEdgeAccess().getLabelKeyword_10_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelKeyword_10_0()); 

            }


            }

        }
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
    // InternalModelDraw.g:2376:1: rule__Edge__Group_10__1 : rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 ;
    public final void rule__Edge__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2380:1: ( rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 )
            // InternalModelDraw.g:2381:2: rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalModelDraw.g:2388:1: rule__Edge__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2392:1: ( ( '=' ) )
            // InternalModelDraw.g:2393:1: ( '=' )
            {
            // InternalModelDraw.g:2393:1: ( '=' )
            // InternalModelDraw.g:2394:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_10_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:2403:1: rule__Edge__Group_10__2 : rule__Edge__Group_10__2__Impl ;
    public final void rule__Edge__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2407:1: ( rule__Edge__Group_10__2__Impl )
            // InternalModelDraw.g:2408:2: rule__Edge__Group_10__2__Impl
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
    // InternalModelDraw.g:2414:1: rule__Edge__Group_10__2__Impl : ( ( rule__Edge__Alternatives_10_2 ) ) ;
    public final void rule__Edge__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2418:1: ( ( ( rule__Edge__Alternatives_10_2 ) ) )
            // InternalModelDraw.g:2419:1: ( ( rule__Edge__Alternatives_10_2 ) )
            {
            // InternalModelDraw.g:2419:1: ( ( rule__Edge__Alternatives_10_2 ) )
            // InternalModelDraw.g:2420:2: ( rule__Edge__Alternatives_10_2 )
            {
             before(grammarAccess.getEdgeAccess().getAlternatives_10_2()); 
            // InternalModelDraw.g:2421:2: ( rule__Edge__Alternatives_10_2 )
            // InternalModelDraw.g:2421:3: rule__Edge__Alternatives_10_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Alternatives_10_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getAlternatives_10_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Edge__Group_10_2_0__0"
    // InternalModelDraw.g:2430:1: rule__Edge__Group_10_2_0__0 : rule__Edge__Group_10_2_0__0__Impl rule__Edge__Group_10_2_0__1 ;
    public final void rule__Edge__Group_10_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2434:1: ( rule__Edge__Group_10_2_0__0__Impl rule__Edge__Group_10_2_0__1 )
            // InternalModelDraw.g:2435:2: rule__Edge__Group_10_2_0__0__Impl rule__Edge__Group_10_2_0__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0__0"


    // $ANTLR start "rule__Edge__Group_10_2_0__0__Impl"
    // InternalModelDraw.g:2442:1: rule__Edge__Group_10_2_0__0__Impl : ( ( rule__Edge__Group_10_2_0_0__0 )? ) ;
    public final void rule__Edge__Group_10_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2446:1: ( ( ( rule__Edge__Group_10_2_0_0__0 )? ) )
            // InternalModelDraw.g:2447:1: ( ( rule__Edge__Group_10_2_0_0__0 )? )
            {
            // InternalModelDraw.g:2447:1: ( ( rule__Edge__Group_10_2_0_0__0 )? )
            // InternalModelDraw.g:2448:2: ( rule__Edge__Group_10_2_0_0__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_0_0()); 
            // InternalModelDraw.g:2449:2: ( rule__Edge__Group_10_2_0_0__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                int LA27_1 = input.LA(2);

                if ( ((LA27_1>=40 && LA27_1<=41)) ) {
                    alt27=1;
                }
            }
            switch (alt27) {
                case 1 :
                    // InternalModelDraw.g:2449:3: rule__Edge__Group_10_2_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_0_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_0__1"
    // InternalModelDraw.g:2457:1: rule__Edge__Group_10_2_0__1 : rule__Edge__Group_10_2_0__1__Impl ;
    public final void rule__Edge__Group_10_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2461:1: ( rule__Edge__Group_10_2_0__1__Impl )
            // InternalModelDraw.g:2462:2: rule__Edge__Group_10_2_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0__1"


    // $ANTLR start "rule__Edge__Group_10_2_0__1__Impl"
    // InternalModelDraw.g:2468:1: rule__Edge__Group_10_2_0__1__Impl : ( ( rule__Edge__LabelAssignment_10_2_0_1 ) ) ;
    public final void rule__Edge__Group_10_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2472:1: ( ( ( rule__Edge__LabelAssignment_10_2_0_1 ) ) )
            // InternalModelDraw.g:2473:1: ( ( rule__Edge__LabelAssignment_10_2_0_1 ) )
            {
            // InternalModelDraw.g:2473:1: ( ( rule__Edge__LabelAssignment_10_2_0_1 ) )
            // InternalModelDraw.g:2474:2: ( rule__Edge__LabelAssignment_10_2_0_1 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_0_1()); 
            // InternalModelDraw.g:2475:2: ( rule__Edge__LabelAssignment_10_2_0_1 )
            // InternalModelDraw.g:2475:3: rule__Edge__LabelAssignment_10_2_0_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_10_2_0_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_0_0__0"
    // InternalModelDraw.g:2484:1: rule__Edge__Group_10_2_0_0__0 : rule__Edge__Group_10_2_0_0__0__Impl rule__Edge__Group_10_2_0_0__1 ;
    public final void rule__Edge__Group_10_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2488:1: ( rule__Edge__Group_10_2_0_0__0__Impl rule__Edge__Group_10_2_0_0__1 )
            // InternalModelDraw.g:2489:2: rule__Edge__Group_10_2_0_0__0__Impl rule__Edge__Group_10_2_0_0__1
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0__0"


    // $ANTLR start "rule__Edge__Group_10_2_0_0__0__Impl"
    // InternalModelDraw.g:2496:1: rule__Edge__Group_10_2_0_0__0__Impl : ( ( rule__Edge__ReferenceAssignment_10_2_0_0_0 ) ) ;
    public final void rule__Edge__Group_10_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2500:1: ( ( ( rule__Edge__ReferenceAssignment_10_2_0_0_0 ) ) )
            // InternalModelDraw.g:2501:1: ( ( rule__Edge__ReferenceAssignment_10_2_0_0_0 ) )
            {
            // InternalModelDraw.g:2501:1: ( ( rule__Edge__ReferenceAssignment_10_2_0_0_0 ) )
            // InternalModelDraw.g:2502:2: ( rule__Edge__ReferenceAssignment_10_2_0_0_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_0_0_0()); 
            // InternalModelDraw.g:2503:2: ( rule__Edge__ReferenceAssignment_10_2_0_0_0 )
            // InternalModelDraw.g:2503:3: rule__Edge__ReferenceAssignment_10_2_0_0_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_10_2_0_0_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_0_0__1"
    // InternalModelDraw.g:2511:1: rule__Edge__Group_10_2_0_0__1 : rule__Edge__Group_10_2_0_0__1__Impl rule__Edge__Group_10_2_0_0__2 ;
    public final void rule__Edge__Group_10_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2515:1: ( rule__Edge__Group_10_2_0_0__1__Impl rule__Edge__Group_10_2_0_0__2 )
            // InternalModelDraw.g:2516:2: rule__Edge__Group_10_2_0_0__1__Impl rule__Edge__Group_10_2_0_0__2
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_0_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_0_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0__1"


    // $ANTLR start "rule__Edge__Group_10_2_0_0__1__Impl"
    // InternalModelDraw.g:2523:1: rule__Edge__Group_10_2_0_0__1__Impl : ( ( rule__Edge__Group_10_2_0_0_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2527:1: ( ( ( rule__Edge__Group_10_2_0_0_1__0 )? ) )
            // InternalModelDraw.g:2528:1: ( ( rule__Edge__Group_10_2_0_0_1__0 )? )
            {
            // InternalModelDraw.g:2528:1: ( ( rule__Edge__Group_10_2_0_0_1__0 )? )
            // InternalModelDraw.g:2529:2: ( rule__Edge__Group_10_2_0_0_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_0_0_1()); 
            // InternalModelDraw.g:2530:2: ( rule__Edge__Group_10_2_0_0_1__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==41) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalModelDraw.g:2530:3: rule__Edge__Group_10_2_0_0_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_0_0_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_0_0__2"
    // InternalModelDraw.g:2538:1: rule__Edge__Group_10_2_0_0__2 : rule__Edge__Group_10_2_0_0__2__Impl ;
    public final void rule__Edge__Group_10_2_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2542:1: ( rule__Edge__Group_10_2_0_0__2__Impl )
            // InternalModelDraw.g:2543:2: rule__Edge__Group_10_2_0_0__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_0_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0__2"


    // $ANTLR start "rule__Edge__Group_10_2_0_0__2__Impl"
    // InternalModelDraw.g:2549:1: rule__Edge__Group_10_2_0_0__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_10_2_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2553:1: ( ( '.' ) )
            // InternalModelDraw.g:2554:1: ( '.' )
            {
            // InternalModelDraw.g:2554:1: ( '.' )
            // InternalModelDraw.g:2555:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_0_0_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_0_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_0_0_1__0"
    // InternalModelDraw.g:2565:1: rule__Edge__Group_10_2_0_0_1__0 : rule__Edge__Group_10_2_0_0_1__0__Impl rule__Edge__Group_10_2_0_0_1__1 ;
    public final void rule__Edge__Group_10_2_0_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2569:1: ( rule__Edge__Group_10_2_0_0_1__0__Impl rule__Edge__Group_10_2_0_0_1__1 )
            // InternalModelDraw.g:2570:2: rule__Edge__Group_10_2_0_0_1__0__Impl rule__Edge__Group_10_2_0_0_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_0_0_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_0_0_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_0_0_1__0__Impl"
    // InternalModelDraw.g:2577:1: rule__Edge__Group_10_2_0_0_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_10_2_0_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2581:1: ( ( '->' ) )
            // InternalModelDraw.g:2582:1: ( '->' )
            {
            // InternalModelDraw.g:2582:1: ( '->' )
            // InternalModelDraw.g:2583:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_0_0_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_0_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_0_0_1__1"
    // InternalModelDraw.g:2592:1: rule__Edge__Group_10_2_0_0_1__1 : rule__Edge__Group_10_2_0_0_1__1__Impl ;
    public final void rule__Edge__Group_10_2_0_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2596:1: ( rule__Edge__Group_10_2_0_0_1__1__Impl )
            // InternalModelDraw.g:2597:2: rule__Edge__Group_10_2_0_0_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_0_0_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_0_0_1__1__Impl"
    // InternalModelDraw.g:2603:1: rule__Edge__Group_10_2_0_0_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_10_2_0_0_1_1 ) ) ;
    public final void rule__Edge__Group_10_2_0_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2607:1: ( ( ( rule__Edge__RefTypeAssignment_10_2_0_0_1_1 ) ) )
            // InternalModelDraw.g:2608:1: ( ( rule__Edge__RefTypeAssignment_10_2_0_0_1_1 ) )
            {
            // InternalModelDraw.g:2608:1: ( ( rule__Edge__RefTypeAssignment_10_2_0_0_1_1 ) )
            // InternalModelDraw.g:2609:2: ( rule__Edge__RefTypeAssignment_10_2_0_0_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_0_0_1_1()); 
            // InternalModelDraw.g:2610:2: ( rule__Edge__RefTypeAssignment_10_2_0_0_1_1 )
            // InternalModelDraw.g:2610:3: rule__Edge__RefTypeAssignment_10_2_0_0_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_10_2_0_0_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_0_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_0_0_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1__0"
    // InternalModelDraw.g:2619:1: rule__Edge__Group_10_2_1__0 : rule__Edge__Group_10_2_1__0__Impl rule__Edge__Group_10_2_1__1 ;
    public final void rule__Edge__Group_10_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2623:1: ( rule__Edge__Group_10_2_1__0__Impl rule__Edge__Group_10_2_1__1 )
            // InternalModelDraw.g:2624:2: rule__Edge__Group_10_2_1__0__Impl rule__Edge__Group_10_2_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1__0__Impl"
    // InternalModelDraw.g:2631:1: rule__Edge__Group_10_2_1__0__Impl : ( '{' ) ;
    public final void rule__Edge__Group_10_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2635:1: ( ( '{' ) )
            // InternalModelDraw.g:2636:1: ( '{' )
            {
            // InternalModelDraw.g:2636:1: ( '{' )
            // InternalModelDraw.g:2637:2: '{'
            {
             before(grammarAccess.getEdgeAccess().getLeftCurlyBracketKeyword_10_2_1_0()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftCurlyBracketKeyword_10_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1__1"
    // InternalModelDraw.g:2646:1: rule__Edge__Group_10_2_1__1 : rule__Edge__Group_10_2_1__1__Impl rule__Edge__Group_10_2_1__2 ;
    public final void rule__Edge__Group_10_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2650:1: ( rule__Edge__Group_10_2_1__1__Impl rule__Edge__Group_10_2_1__2 )
            // InternalModelDraw.g:2651:2: rule__Edge__Group_10_2_1__1__Impl rule__Edge__Group_10_2_1__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1__1__Impl"
    // InternalModelDraw.g:2658:1: rule__Edge__Group_10_2_1__1__Impl : ( ( rule__Edge__Group_10_2_1_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2662:1: ( ( ( rule__Edge__Group_10_2_1_1__0 )? ) )
            // InternalModelDraw.g:2663:1: ( ( rule__Edge__Group_10_2_1_1__0 )? )
            {
            // InternalModelDraw.g:2663:1: ( ( rule__Edge__Group_10_2_1_1__0 )? )
            // InternalModelDraw.g:2664:2: ( rule__Edge__Group_10_2_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_1()); 
            // InternalModelDraw.g:2665:2: ( rule__Edge__Group_10_2_1_1__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                int LA29_1 = input.LA(2);

                if ( ((LA29_1>=40 && LA29_1<=41)) ) {
                    alt29=1;
                }
            }
            switch (alt29) {
                case 1 :
                    // InternalModelDraw.g:2665:3: rule__Edge__Group_10_2_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1__2"
    // InternalModelDraw.g:2673:1: rule__Edge__Group_10_2_1__2 : rule__Edge__Group_10_2_1__2__Impl rule__Edge__Group_10_2_1__3 ;
    public final void rule__Edge__Group_10_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2677:1: ( rule__Edge__Group_10_2_1__2__Impl rule__Edge__Group_10_2_1__3 )
            // InternalModelDraw.g:2678:2: rule__Edge__Group_10_2_1__2__Impl rule__Edge__Group_10_2_1__3
            {
            pushFollow(FOLLOW_28);
            rule__Edge__Group_10_2_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__2"


    // $ANTLR start "rule__Edge__Group_10_2_1__2__Impl"
    // InternalModelDraw.g:2685:1: rule__Edge__Group_10_2_1__2__Impl : ( ( rule__Edge__LabelAssignment_10_2_1_2 ) ) ;
    public final void rule__Edge__Group_10_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2689:1: ( ( ( rule__Edge__LabelAssignment_10_2_1_2 ) ) )
            // InternalModelDraw.g:2690:1: ( ( rule__Edge__LabelAssignment_10_2_1_2 ) )
            {
            // InternalModelDraw.g:2690:1: ( ( rule__Edge__LabelAssignment_10_2_1_2 ) )
            // InternalModelDraw.g:2691:2: ( rule__Edge__LabelAssignment_10_2_1_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_2()); 
            // InternalModelDraw.g:2692:2: ( rule__Edge__LabelAssignment_10_2_1_2 )
            // InternalModelDraw.g:2692:3: rule__Edge__LabelAssignment_10_2_1_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_10_2_1_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1__3"
    // InternalModelDraw.g:2700:1: rule__Edge__Group_10_2_1__3 : rule__Edge__Group_10_2_1__3__Impl rule__Edge__Group_10_2_1__4 ;
    public final void rule__Edge__Group_10_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2704:1: ( rule__Edge__Group_10_2_1__3__Impl rule__Edge__Group_10_2_1__4 )
            // InternalModelDraw.g:2705:2: rule__Edge__Group_10_2_1__3__Impl rule__Edge__Group_10_2_1__4
            {
            pushFollow(FOLLOW_28);
            rule__Edge__Group_10_2_1__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__3"


    // $ANTLR start "rule__Edge__Group_10_2_1__3__Impl"
    // InternalModelDraw.g:2712:1: rule__Edge__Group_10_2_1__3__Impl : ( ( rule__Edge__Group_10_2_1_3__0 )? ) ;
    public final void rule__Edge__Group_10_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2716:1: ( ( ( rule__Edge__Group_10_2_1_3__0 )? ) )
            // InternalModelDraw.g:2717:1: ( ( rule__Edge__Group_10_2_1_3__0 )? )
            {
            // InternalModelDraw.g:2717:1: ( ( rule__Edge__Group_10_2_1_3__0 )? )
            // InternalModelDraw.g:2718:2: ( rule__Edge__Group_10_2_1_3__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_3()); 
            // InternalModelDraw.g:2719:2: ( rule__Edge__Group_10_2_1_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==30) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalModelDraw.g:2719:3: rule__Edge__Group_10_2_1_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__3__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1__4"
    // InternalModelDraw.g:2727:1: rule__Edge__Group_10_2_1__4 : rule__Edge__Group_10_2_1__4__Impl rule__Edge__Group_10_2_1__5 ;
    public final void rule__Edge__Group_10_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2731:1: ( rule__Edge__Group_10_2_1__4__Impl rule__Edge__Group_10_2_1__5 )
            // InternalModelDraw.g:2732:2: rule__Edge__Group_10_2_1__4__Impl rule__Edge__Group_10_2_1__5
            {
            pushFollow(FOLLOW_28);
            rule__Edge__Group_10_2_1__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__4"


    // $ANTLR start "rule__Edge__Group_10_2_1__4__Impl"
    // InternalModelDraw.g:2739:1: rule__Edge__Group_10_2_1__4__Impl : ( ( rule__Edge__Group_10_2_1_4__0 )* ) ;
    public final void rule__Edge__Group_10_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2743:1: ( ( ( rule__Edge__Group_10_2_1_4__0 )* ) )
            // InternalModelDraw.g:2744:1: ( ( rule__Edge__Group_10_2_1_4__0 )* )
            {
            // InternalModelDraw.g:2744:1: ( ( rule__Edge__Group_10_2_1_4__0 )* )
            // InternalModelDraw.g:2745:2: ( rule__Edge__Group_10_2_1_4__0 )*
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_4()); 
            // InternalModelDraw.g:2746:2: ( rule__Edge__Group_10_2_1_4__0 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==32) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalModelDraw.g:2746:3: rule__Edge__Group_10_2_1_4__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Edge__Group_10_2_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__4__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1__5"
    // InternalModelDraw.g:2754:1: rule__Edge__Group_10_2_1__5 : rule__Edge__Group_10_2_1__5__Impl ;
    public final void rule__Edge__Group_10_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2758:1: ( rule__Edge__Group_10_2_1__5__Impl )
            // InternalModelDraw.g:2759:2: rule__Edge__Group_10_2_1__5__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__5"


    // $ANTLR start "rule__Edge__Group_10_2_1__5__Impl"
    // InternalModelDraw.g:2765:1: rule__Edge__Group_10_2_1__5__Impl : ( '}' ) ;
    public final void rule__Edge__Group_10_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2769:1: ( ( '}' ) )
            // InternalModelDraw.g:2770:1: ( '}' )
            {
            // InternalModelDraw.g:2770:1: ( '}' )
            // InternalModelDraw.g:2771:2: '}'
            {
             before(grammarAccess.getEdgeAccess().getRightCurlyBracketKeyword_10_2_1_5()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightCurlyBracketKeyword_10_2_1_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1__5__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_1__0"
    // InternalModelDraw.g:2781:1: rule__Edge__Group_10_2_1_1__0 : rule__Edge__Group_10_2_1_1__0__Impl rule__Edge__Group_10_2_1_1__1 ;
    public final void rule__Edge__Group_10_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2785:1: ( rule__Edge__Group_10_2_1_1__0__Impl rule__Edge__Group_10_2_1_1__1 )
            // InternalModelDraw.g:2786:2: rule__Edge__Group_10_2_1_1__0__Impl rule__Edge__Group_10_2_1_1__1
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_1__0__Impl"
    // InternalModelDraw.g:2793:1: rule__Edge__Group_10_2_1_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_10_2_1_1_0 ) ) ;
    public final void rule__Edge__Group_10_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2797:1: ( ( ( rule__Edge__ReferenceAssignment_10_2_1_1_0 ) ) )
            // InternalModelDraw.g:2798:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_1_0 ) )
            {
            // InternalModelDraw.g:2798:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_1_0 ) )
            // InternalModelDraw.g:2799:2: ( rule__Edge__ReferenceAssignment_10_2_1_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_1_0()); 
            // InternalModelDraw.g:2800:2: ( rule__Edge__ReferenceAssignment_10_2_1_1_0 )
            // InternalModelDraw.g:2800:3: rule__Edge__ReferenceAssignment_10_2_1_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_10_2_1_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_1__1"
    // InternalModelDraw.g:2808:1: rule__Edge__Group_10_2_1_1__1 : rule__Edge__Group_10_2_1_1__1__Impl rule__Edge__Group_10_2_1_1__2 ;
    public final void rule__Edge__Group_10_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2812:1: ( rule__Edge__Group_10_2_1_1__1__Impl rule__Edge__Group_10_2_1_1__2 )
            // InternalModelDraw.g:2813:2: rule__Edge__Group_10_2_1_1__1__Impl rule__Edge__Group_10_2_1_1__2
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_1__1__Impl"
    // InternalModelDraw.g:2820:1: rule__Edge__Group_10_2_1_1__1__Impl : ( ( rule__Edge__Group_10_2_1_1_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2824:1: ( ( ( rule__Edge__Group_10_2_1_1_1__0 )? ) )
            // InternalModelDraw.g:2825:1: ( ( rule__Edge__Group_10_2_1_1_1__0 )? )
            {
            // InternalModelDraw.g:2825:1: ( ( rule__Edge__Group_10_2_1_1_1__0 )? )
            // InternalModelDraw.g:2826:2: ( rule__Edge__Group_10_2_1_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_1_1()); 
            // InternalModelDraw.g:2827:2: ( rule__Edge__Group_10_2_1_1_1__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==41) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalModelDraw.g:2827:3: rule__Edge__Group_10_2_1_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_1__2"
    // InternalModelDraw.g:2835:1: rule__Edge__Group_10_2_1_1__2 : rule__Edge__Group_10_2_1_1__2__Impl ;
    public final void rule__Edge__Group_10_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2839:1: ( rule__Edge__Group_10_2_1_1__2__Impl )
            // InternalModelDraw.g:2840:2: rule__Edge__Group_10_2_1_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1__2"


    // $ANTLR start "rule__Edge__Group_10_2_1_1__2__Impl"
    // InternalModelDraw.g:2846:1: rule__Edge__Group_10_2_1_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_10_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2850:1: ( ( '.' ) )
            // InternalModelDraw.g:2851:1: ( '.' )
            {
            // InternalModelDraw.g:2851:1: ( '.' )
            // InternalModelDraw.g:2852:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_1_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_1_1__0"
    // InternalModelDraw.g:2862:1: rule__Edge__Group_10_2_1_1_1__0 : rule__Edge__Group_10_2_1_1_1__0__Impl rule__Edge__Group_10_2_1_1_1__1 ;
    public final void rule__Edge__Group_10_2_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2866:1: ( rule__Edge__Group_10_2_1_1_1__0__Impl rule__Edge__Group_10_2_1_1_1__1 )
            // InternalModelDraw.g:2867:2: rule__Edge__Group_10_2_1_1_1__0__Impl rule__Edge__Group_10_2_1_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_1_1__0__Impl"
    // InternalModelDraw.g:2874:1: rule__Edge__Group_10_2_1_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_10_2_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2878:1: ( ( '->' ) )
            // InternalModelDraw.g:2879:1: ( '->' )
            {
            // InternalModelDraw.g:2879:1: ( '->' )
            // InternalModelDraw.g:2880:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_1_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_1_1__1"
    // InternalModelDraw.g:2889:1: rule__Edge__Group_10_2_1_1_1__1 : rule__Edge__Group_10_2_1_1_1__1__Impl ;
    public final void rule__Edge__Group_10_2_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2893:1: ( rule__Edge__Group_10_2_1_1_1__1__Impl )
            // InternalModelDraw.g:2894:2: rule__Edge__Group_10_2_1_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_1_1__1__Impl"
    // InternalModelDraw.g:2900:1: rule__Edge__Group_10_2_1_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_10_2_1_1_1_1 ) ) ;
    public final void rule__Edge__Group_10_2_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2904:1: ( ( ( rule__Edge__RefTypeAssignment_10_2_1_1_1_1 ) ) )
            // InternalModelDraw.g:2905:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_1_1_1 ) )
            {
            // InternalModelDraw.g:2905:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_1_1_1 ) )
            // InternalModelDraw.g:2906:2: ( rule__Edge__RefTypeAssignment_10_2_1_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_1_1_1()); 
            // InternalModelDraw.g:2907:2: ( rule__Edge__RefTypeAssignment_10_2_1_1_1_1 )
            // InternalModelDraw.g:2907:3: rule__Edge__RefTypeAssignment_10_2_1_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_10_2_1_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__0"
    // InternalModelDraw.g:2916:1: rule__Edge__Group_10_2_1_3__0 : rule__Edge__Group_10_2_1_3__0__Impl rule__Edge__Group_10_2_1_3__1 ;
    public final void rule__Edge__Group_10_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2920:1: ( rule__Edge__Group_10_2_1_3__0__Impl rule__Edge__Group_10_2_1_3__1 )
            // InternalModelDraw.g:2921:2: rule__Edge__Group_10_2_1_3__0__Impl rule__Edge__Group_10_2_1_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__0__Impl"
    // InternalModelDraw.g:2928:1: rule__Edge__Group_10_2_1_3__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_10_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2932:1: ( ( '(' ) )
            // InternalModelDraw.g:2933:1: ( '(' )
            {
            // InternalModelDraw.g:2933:1: ( '(' )
            // InternalModelDraw.g:2934:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_10_2_1_3_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_10_2_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__1"
    // InternalModelDraw.g:2943:1: rule__Edge__Group_10_2_1_3__1 : rule__Edge__Group_10_2_1_3__1__Impl rule__Edge__Group_10_2_1_3__2 ;
    public final void rule__Edge__Group_10_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2947:1: ( rule__Edge__Group_10_2_1_3__1__Impl rule__Edge__Group_10_2_1_3__2 )
            // InternalModelDraw.g:2948:2: rule__Edge__Group_10_2_1_3__1__Impl rule__Edge__Group_10_2_1_3__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__1__Impl"
    // InternalModelDraw.g:2955:1: rule__Edge__Group_10_2_1_3__1__Impl : ( ( rule__Edge__Group_10_2_1_3_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2959:1: ( ( ( rule__Edge__Group_10_2_1_3_1__0 )? ) )
            // InternalModelDraw.g:2960:1: ( ( rule__Edge__Group_10_2_1_3_1__0 )? )
            {
            // InternalModelDraw.g:2960:1: ( ( rule__Edge__Group_10_2_1_3_1__0 )? )
            // InternalModelDraw.g:2961:2: ( rule__Edge__Group_10_2_1_3_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_3_1()); 
            // InternalModelDraw.g:2962:2: ( rule__Edge__Group_10_2_1_3_1__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( ((LA33_1>=40 && LA33_1<=41)) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // InternalModelDraw.g:2962:3: rule__Edge__Group_10_2_1_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__2"
    // InternalModelDraw.g:2970:1: rule__Edge__Group_10_2_1_3__2 : rule__Edge__Group_10_2_1_3__2__Impl rule__Edge__Group_10_2_1_3__3 ;
    public final void rule__Edge__Group_10_2_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2974:1: ( rule__Edge__Group_10_2_1_3__2__Impl rule__Edge__Group_10_2_1_3__3 )
            // InternalModelDraw.g:2975:2: rule__Edge__Group_10_2_1_3__2__Impl rule__Edge__Group_10_2_1_3__3
            {
            pushFollow(FOLLOW_23);
            rule__Edge__Group_10_2_1_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__2"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__2__Impl"
    // InternalModelDraw.g:2982:1: rule__Edge__Group_10_2_1_3__2__Impl : ( ( rule__Edge__LabelAssignment_10_2_1_3_2 ) ) ;
    public final void rule__Edge__Group_10_2_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2986:1: ( ( ( rule__Edge__LabelAssignment_10_2_1_3_2 ) ) )
            // InternalModelDraw.g:2987:1: ( ( rule__Edge__LabelAssignment_10_2_1_3_2 ) )
            {
            // InternalModelDraw.g:2987:1: ( ( rule__Edge__LabelAssignment_10_2_1_3_2 ) )
            // InternalModelDraw.g:2988:2: ( rule__Edge__LabelAssignment_10_2_1_3_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_3_2()); 
            // InternalModelDraw.g:2989:2: ( rule__Edge__LabelAssignment_10_2_1_3_2 )
            // InternalModelDraw.g:2989:3: rule__Edge__LabelAssignment_10_2_1_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_10_2_1_3_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__3"
    // InternalModelDraw.g:2997:1: rule__Edge__Group_10_2_1_3__3 : rule__Edge__Group_10_2_1_3__3__Impl ;
    public final void rule__Edge__Group_10_2_1_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3001:1: ( rule__Edge__Group_10_2_1_3__3__Impl )
            // InternalModelDraw.g:3002:2: rule__Edge__Group_10_2_1_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__3"


    // $ANTLR start "rule__Edge__Group_10_2_1_3__3__Impl"
    // InternalModelDraw.g:3008:1: rule__Edge__Group_10_2_1_3__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_10_2_1_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3012:1: ( ( ')' ) )
            // InternalModelDraw.g:3013:1: ( ')' )
            {
            // InternalModelDraw.g:3013:1: ( ')' )
            // InternalModelDraw.g:3014:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_10_2_1_3_3()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_10_2_1_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3__3__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1__0"
    // InternalModelDraw.g:3024:1: rule__Edge__Group_10_2_1_3_1__0 : rule__Edge__Group_10_2_1_3_1__0__Impl rule__Edge__Group_10_2_1_3_1__1 ;
    public final void rule__Edge__Group_10_2_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3028:1: ( rule__Edge__Group_10_2_1_3_1__0__Impl rule__Edge__Group_10_2_1_3_1__1 )
            // InternalModelDraw.g:3029:2: rule__Edge__Group_10_2_1_3_1__0__Impl rule__Edge__Group_10_2_1_3_1__1
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1__0__Impl"
    // InternalModelDraw.g:3036:1: rule__Edge__Group_10_2_1_3_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_10_2_1_3_1_0 ) ) ;
    public final void rule__Edge__Group_10_2_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3040:1: ( ( ( rule__Edge__ReferenceAssignment_10_2_1_3_1_0 ) ) )
            // InternalModelDraw.g:3041:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_3_1_0 ) )
            {
            // InternalModelDraw.g:3041:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_3_1_0 ) )
            // InternalModelDraw.g:3042:2: ( rule__Edge__ReferenceAssignment_10_2_1_3_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_3_1_0()); 
            // InternalModelDraw.g:3043:2: ( rule__Edge__ReferenceAssignment_10_2_1_3_1_0 )
            // InternalModelDraw.g:3043:3: rule__Edge__ReferenceAssignment_10_2_1_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_10_2_1_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1__1"
    // InternalModelDraw.g:3051:1: rule__Edge__Group_10_2_1_3_1__1 : rule__Edge__Group_10_2_1_3_1__1__Impl rule__Edge__Group_10_2_1_3_1__2 ;
    public final void rule__Edge__Group_10_2_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3055:1: ( rule__Edge__Group_10_2_1_3_1__1__Impl rule__Edge__Group_10_2_1_3_1__2 )
            // InternalModelDraw.g:3056:2: rule__Edge__Group_10_2_1_3_1__1__Impl rule__Edge__Group_10_2_1_3_1__2
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1__1__Impl"
    // InternalModelDraw.g:3063:1: rule__Edge__Group_10_2_1_3_1__1__Impl : ( ( rule__Edge__Group_10_2_1_3_1_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3067:1: ( ( ( rule__Edge__Group_10_2_1_3_1_1__0 )? ) )
            // InternalModelDraw.g:3068:1: ( ( rule__Edge__Group_10_2_1_3_1_1__0 )? )
            {
            // InternalModelDraw.g:3068:1: ( ( rule__Edge__Group_10_2_1_3_1_1__0 )? )
            // InternalModelDraw.g:3069:2: ( rule__Edge__Group_10_2_1_3_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_3_1_1()); 
            // InternalModelDraw.g:3070:2: ( rule__Edge__Group_10_2_1_3_1_1__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==41) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalModelDraw.g:3070:3: rule__Edge__Group_10_2_1_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_3_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1__2"
    // InternalModelDraw.g:3078:1: rule__Edge__Group_10_2_1_3_1__2 : rule__Edge__Group_10_2_1_3_1__2__Impl ;
    public final void rule__Edge__Group_10_2_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3082:1: ( rule__Edge__Group_10_2_1_3_1__2__Impl )
            // InternalModelDraw.g:3083:2: rule__Edge__Group_10_2_1_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1__2"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1__2__Impl"
    // InternalModelDraw.g:3089:1: rule__Edge__Group_10_2_1_3_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_10_2_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3093:1: ( ( '.' ) )
            // InternalModelDraw.g:3094:1: ( '.' )
            {
            // InternalModelDraw.g:3094:1: ( '.' )
            // InternalModelDraw.g:3095:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_3_1_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1_1__0"
    // InternalModelDraw.g:3105:1: rule__Edge__Group_10_2_1_3_1_1__0 : rule__Edge__Group_10_2_1_3_1_1__0__Impl rule__Edge__Group_10_2_1_3_1_1__1 ;
    public final void rule__Edge__Group_10_2_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3109:1: ( rule__Edge__Group_10_2_1_3_1_1__0__Impl rule__Edge__Group_10_2_1_3_1_1__1 )
            // InternalModelDraw.g:3110:2: rule__Edge__Group_10_2_1_3_1_1__0__Impl rule__Edge__Group_10_2_1_3_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1_1__0__Impl"
    // InternalModelDraw.g:3117:1: rule__Edge__Group_10_2_1_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_10_2_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3121:1: ( ( '->' ) )
            // InternalModelDraw.g:3122:1: ( '->' )
            {
            // InternalModelDraw.g:3122:1: ( '->' )
            // InternalModelDraw.g:3123:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_3_1_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1_1__1"
    // InternalModelDraw.g:3132:1: rule__Edge__Group_10_2_1_3_1_1__1 : rule__Edge__Group_10_2_1_3_1_1__1__Impl ;
    public final void rule__Edge__Group_10_2_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3136:1: ( rule__Edge__Group_10_2_1_3_1_1__1__Impl )
            // InternalModelDraw.g:3137:2: rule__Edge__Group_10_2_1_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_3_1_1__1__Impl"
    // InternalModelDraw.g:3143:1: rule__Edge__Group_10_2_1_3_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1 ) ) ;
    public final void rule__Edge__Group_10_2_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3147:1: ( ( ( rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1 ) ) )
            // InternalModelDraw.g:3148:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1 ) )
            {
            // InternalModelDraw.g:3148:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1 ) )
            // InternalModelDraw.g:3149:2: ( rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_3_1_1_1()); 
            // InternalModelDraw.g:3150:2: ( rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1 )
            // InternalModelDraw.g:3150:3: rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_3_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__0"
    // InternalModelDraw.g:3159:1: rule__Edge__Group_10_2_1_4__0 : rule__Edge__Group_10_2_1_4__0__Impl rule__Edge__Group_10_2_1_4__1 ;
    public final void rule__Edge__Group_10_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3163:1: ( rule__Edge__Group_10_2_1_4__0__Impl rule__Edge__Group_10_2_1_4__1 )
            // InternalModelDraw.g:3164:2: rule__Edge__Group_10_2_1_4__0__Impl rule__Edge__Group_10_2_1_4__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__0__Impl"
    // InternalModelDraw.g:3171:1: rule__Edge__Group_10_2_1_4__0__Impl : ( ',' ) ;
    public final void rule__Edge__Group_10_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3175:1: ( ( ',' ) )
            // InternalModelDraw.g:3176:1: ( ',' )
            {
            // InternalModelDraw.g:3176:1: ( ',' )
            // InternalModelDraw.g:3177:2: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_10_2_1_4_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_10_2_1_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__1"
    // InternalModelDraw.g:3186:1: rule__Edge__Group_10_2_1_4__1 : rule__Edge__Group_10_2_1_4__1__Impl rule__Edge__Group_10_2_1_4__2 ;
    public final void rule__Edge__Group_10_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3190:1: ( rule__Edge__Group_10_2_1_4__1__Impl rule__Edge__Group_10_2_1_4__2 )
            // InternalModelDraw.g:3191:2: rule__Edge__Group_10_2_1_4__1__Impl rule__Edge__Group_10_2_1_4__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_4__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__1__Impl"
    // InternalModelDraw.g:3198:1: rule__Edge__Group_10_2_1_4__1__Impl : ( ( rule__Edge__Group_10_2_1_4_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3202:1: ( ( ( rule__Edge__Group_10_2_1_4_1__0 )? ) )
            // InternalModelDraw.g:3203:1: ( ( rule__Edge__Group_10_2_1_4_1__0 )? )
            {
            // InternalModelDraw.g:3203:1: ( ( rule__Edge__Group_10_2_1_4_1__0 )? )
            // InternalModelDraw.g:3204:2: ( rule__Edge__Group_10_2_1_4_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_1()); 
            // InternalModelDraw.g:3205:2: ( rule__Edge__Group_10_2_1_4_1__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                int LA35_1 = input.LA(2);

                if ( ((LA35_1>=40 && LA35_1<=41)) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // InternalModelDraw.g:3205:3: rule__Edge__Group_10_2_1_4_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_4_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__2"
    // InternalModelDraw.g:3213:1: rule__Edge__Group_10_2_1_4__2 : rule__Edge__Group_10_2_1_4__2__Impl rule__Edge__Group_10_2_1_4__3 ;
    public final void rule__Edge__Group_10_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3217:1: ( rule__Edge__Group_10_2_1_4__2__Impl rule__Edge__Group_10_2_1_4__3 )
            // InternalModelDraw.g:3218:2: rule__Edge__Group_10_2_1_4__2__Impl rule__Edge__Group_10_2_1_4__3
            {
            pushFollow(FOLLOW_21);
            rule__Edge__Group_10_2_1_4__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__2"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__2__Impl"
    // InternalModelDraw.g:3225:1: rule__Edge__Group_10_2_1_4__2__Impl : ( ( rule__Edge__LabelAssignment_10_2_1_4_2 ) ) ;
    public final void rule__Edge__Group_10_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3229:1: ( ( ( rule__Edge__LabelAssignment_10_2_1_4_2 ) ) )
            // InternalModelDraw.g:3230:1: ( ( rule__Edge__LabelAssignment_10_2_1_4_2 ) )
            {
            // InternalModelDraw.g:3230:1: ( ( rule__Edge__LabelAssignment_10_2_1_4_2 ) )
            // InternalModelDraw.g:3231:2: ( rule__Edge__LabelAssignment_10_2_1_4_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_4_2()); 
            // InternalModelDraw.g:3232:2: ( rule__Edge__LabelAssignment_10_2_1_4_2 )
            // InternalModelDraw.g:3232:3: rule__Edge__LabelAssignment_10_2_1_4_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_10_2_1_4_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_4_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__3"
    // InternalModelDraw.g:3240:1: rule__Edge__Group_10_2_1_4__3 : rule__Edge__Group_10_2_1_4__3__Impl ;
    public final void rule__Edge__Group_10_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3244:1: ( rule__Edge__Group_10_2_1_4__3__Impl )
            // InternalModelDraw.g:3245:2: rule__Edge__Group_10_2_1_4__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__3"


    // $ANTLR start "rule__Edge__Group_10_2_1_4__3__Impl"
    // InternalModelDraw.g:3251:1: rule__Edge__Group_10_2_1_4__3__Impl : ( ( rule__Edge__Group_10_2_1_4_3__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3255:1: ( ( ( rule__Edge__Group_10_2_1_4_3__0 )? ) )
            // InternalModelDraw.g:3256:1: ( ( rule__Edge__Group_10_2_1_4_3__0 )? )
            {
            // InternalModelDraw.g:3256:1: ( ( rule__Edge__Group_10_2_1_4_3__0 )? )
            // InternalModelDraw.g:3257:2: ( rule__Edge__Group_10_2_1_4_3__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_3()); 
            // InternalModelDraw.g:3258:2: ( rule__Edge__Group_10_2_1_4_3__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==30) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalModelDraw.g:3258:3: rule__Edge__Group_10_2_1_4_3__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_4_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4__3__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1__0"
    // InternalModelDraw.g:3267:1: rule__Edge__Group_10_2_1_4_1__0 : rule__Edge__Group_10_2_1_4_1__0__Impl rule__Edge__Group_10_2_1_4_1__1 ;
    public final void rule__Edge__Group_10_2_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3271:1: ( rule__Edge__Group_10_2_1_4_1__0__Impl rule__Edge__Group_10_2_1_4_1__1 )
            // InternalModelDraw.g:3272:2: rule__Edge__Group_10_2_1_4_1__0__Impl rule__Edge__Group_10_2_1_4_1__1
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_4_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1__0__Impl"
    // InternalModelDraw.g:3279:1: rule__Edge__Group_10_2_1_4_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_10_2_1_4_1_0 ) ) ;
    public final void rule__Edge__Group_10_2_1_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3283:1: ( ( ( rule__Edge__ReferenceAssignment_10_2_1_4_1_0 ) ) )
            // InternalModelDraw.g:3284:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_4_1_0 ) )
            {
            // InternalModelDraw.g:3284:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_4_1_0 ) )
            // InternalModelDraw.g:3285:2: ( rule__Edge__ReferenceAssignment_10_2_1_4_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_4_1_0()); 
            // InternalModelDraw.g:3286:2: ( rule__Edge__ReferenceAssignment_10_2_1_4_1_0 )
            // InternalModelDraw.g:3286:3: rule__Edge__ReferenceAssignment_10_2_1_4_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_10_2_1_4_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1__1"
    // InternalModelDraw.g:3294:1: rule__Edge__Group_10_2_1_4_1__1 : rule__Edge__Group_10_2_1_4_1__1__Impl rule__Edge__Group_10_2_1_4_1__2 ;
    public final void rule__Edge__Group_10_2_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3298:1: ( rule__Edge__Group_10_2_1_4_1__1__Impl rule__Edge__Group_10_2_1_4_1__2 )
            // InternalModelDraw.g:3299:2: rule__Edge__Group_10_2_1_4_1__1__Impl rule__Edge__Group_10_2_1_4_1__2
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_4_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1__1__Impl"
    // InternalModelDraw.g:3306:1: rule__Edge__Group_10_2_1_4_1__1__Impl : ( ( rule__Edge__Group_10_2_1_4_1_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3310:1: ( ( ( rule__Edge__Group_10_2_1_4_1_1__0 )? ) )
            // InternalModelDraw.g:3311:1: ( ( rule__Edge__Group_10_2_1_4_1_1__0 )? )
            {
            // InternalModelDraw.g:3311:1: ( ( rule__Edge__Group_10_2_1_4_1_1__0 )? )
            // InternalModelDraw.g:3312:2: ( rule__Edge__Group_10_2_1_4_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_1_1()); 
            // InternalModelDraw.g:3313:2: ( rule__Edge__Group_10_2_1_4_1_1__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==41) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalModelDraw.g:3313:3: rule__Edge__Group_10_2_1_4_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_4_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1__2"
    // InternalModelDraw.g:3321:1: rule__Edge__Group_10_2_1_4_1__2 : rule__Edge__Group_10_2_1_4_1__2__Impl ;
    public final void rule__Edge__Group_10_2_1_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3325:1: ( rule__Edge__Group_10_2_1_4_1__2__Impl )
            // InternalModelDraw.g:3326:2: rule__Edge__Group_10_2_1_4_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1__2"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1__2__Impl"
    // InternalModelDraw.g:3332:1: rule__Edge__Group_10_2_1_4_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_10_2_1_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3336:1: ( ( '.' ) )
            // InternalModelDraw.g:3337:1: ( '.' )
            {
            // InternalModelDraw.g:3337:1: ( '.' )
            // InternalModelDraw.g:3338:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_4_1_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_4_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1_1__0"
    // InternalModelDraw.g:3348:1: rule__Edge__Group_10_2_1_4_1_1__0 : rule__Edge__Group_10_2_1_4_1_1__0__Impl rule__Edge__Group_10_2_1_4_1_1__1 ;
    public final void rule__Edge__Group_10_2_1_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3352:1: ( rule__Edge__Group_10_2_1_4_1_1__0__Impl rule__Edge__Group_10_2_1_4_1_1__1 )
            // InternalModelDraw.g:3353:2: rule__Edge__Group_10_2_1_4_1_1__0__Impl rule__Edge__Group_10_2_1_4_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_4_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1_1__0__Impl"
    // InternalModelDraw.g:3360:1: rule__Edge__Group_10_2_1_4_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_10_2_1_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3364:1: ( ( '->' ) )
            // InternalModelDraw.g:3365:1: ( '->' )
            {
            // InternalModelDraw.g:3365:1: ( '->' )
            // InternalModelDraw.g:3366:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_4_1_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_4_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1_1__1"
    // InternalModelDraw.g:3375:1: rule__Edge__Group_10_2_1_4_1_1__1 : rule__Edge__Group_10_2_1_4_1_1__1__Impl ;
    public final void rule__Edge__Group_10_2_1_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3379:1: ( rule__Edge__Group_10_2_1_4_1_1__1__Impl )
            // InternalModelDraw.g:3380:2: rule__Edge__Group_10_2_1_4_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_1_1__1__Impl"
    // InternalModelDraw.g:3386:1: rule__Edge__Group_10_2_1_4_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1 ) ) ;
    public final void rule__Edge__Group_10_2_1_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3390:1: ( ( ( rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1 ) ) )
            // InternalModelDraw.g:3391:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1 ) )
            {
            // InternalModelDraw.g:3391:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1 ) )
            // InternalModelDraw.g:3392:2: ( rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_4_1_1_1()); 
            // InternalModelDraw.g:3393:2: ( rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1 )
            // InternalModelDraw.g:3393:3: rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_4_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__0"
    // InternalModelDraw.g:3402:1: rule__Edge__Group_10_2_1_4_3__0 : rule__Edge__Group_10_2_1_4_3__0__Impl rule__Edge__Group_10_2_1_4_3__1 ;
    public final void rule__Edge__Group_10_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3406:1: ( rule__Edge__Group_10_2_1_4_3__0__Impl rule__Edge__Group_10_2_1_4_3__1 )
            // InternalModelDraw.g:3407:2: rule__Edge__Group_10_2_1_4_3__0__Impl rule__Edge__Group_10_2_1_4_3__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_4_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__0__Impl"
    // InternalModelDraw.g:3414:1: rule__Edge__Group_10_2_1_4_3__0__Impl : ( '(' ) ;
    public final void rule__Edge__Group_10_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3418:1: ( ( '(' ) )
            // InternalModelDraw.g:3419:1: ( '(' )
            {
            // InternalModelDraw.g:3419:1: ( '(' )
            // InternalModelDraw.g:3420:2: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_10_2_1_4_3_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_10_2_1_4_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__1"
    // InternalModelDraw.g:3429:1: rule__Edge__Group_10_2_1_4_3__1 : rule__Edge__Group_10_2_1_4_3__1__Impl rule__Edge__Group_10_2_1_4_3__2 ;
    public final void rule__Edge__Group_10_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3433:1: ( rule__Edge__Group_10_2_1_4_3__1__Impl rule__Edge__Group_10_2_1_4_3__2 )
            // InternalModelDraw.g:3434:2: rule__Edge__Group_10_2_1_4_3__1__Impl rule__Edge__Group_10_2_1_4_3__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_4_3__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__1__Impl"
    // InternalModelDraw.g:3441:1: rule__Edge__Group_10_2_1_4_3__1__Impl : ( ( rule__Edge__Group_10_2_1_4_3_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3445:1: ( ( ( rule__Edge__Group_10_2_1_4_3_1__0 )? ) )
            // InternalModelDraw.g:3446:1: ( ( rule__Edge__Group_10_2_1_4_3_1__0 )? )
            {
            // InternalModelDraw.g:3446:1: ( ( rule__Edge__Group_10_2_1_4_3_1__0 )? )
            // InternalModelDraw.g:3447:2: ( rule__Edge__Group_10_2_1_4_3_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_3_1()); 
            // InternalModelDraw.g:3448:2: ( rule__Edge__Group_10_2_1_4_3_1__0 )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                int LA38_1 = input.LA(2);

                if ( ((LA38_1>=40 && LA38_1<=41)) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // InternalModelDraw.g:3448:3: rule__Edge__Group_10_2_1_4_3_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_4_3_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__2"
    // InternalModelDraw.g:3456:1: rule__Edge__Group_10_2_1_4_3__2 : rule__Edge__Group_10_2_1_4_3__2__Impl rule__Edge__Group_10_2_1_4_3__3 ;
    public final void rule__Edge__Group_10_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3460:1: ( rule__Edge__Group_10_2_1_4_3__2__Impl rule__Edge__Group_10_2_1_4_3__3 )
            // InternalModelDraw.g:3461:2: rule__Edge__Group_10_2_1_4_3__2__Impl rule__Edge__Group_10_2_1_4_3__3
            {
            pushFollow(FOLLOW_23);
            rule__Edge__Group_10_2_1_4_3__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__2"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__2__Impl"
    // InternalModelDraw.g:3468:1: rule__Edge__Group_10_2_1_4_3__2__Impl : ( ( rule__Edge__LabelAssignment_10_2_1_4_3_2 ) ) ;
    public final void rule__Edge__Group_10_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3472:1: ( ( ( rule__Edge__LabelAssignment_10_2_1_4_3_2 ) ) )
            // InternalModelDraw.g:3473:1: ( ( rule__Edge__LabelAssignment_10_2_1_4_3_2 ) )
            {
            // InternalModelDraw.g:3473:1: ( ( rule__Edge__LabelAssignment_10_2_1_4_3_2 ) )
            // InternalModelDraw.g:3474:2: ( rule__Edge__LabelAssignment_10_2_1_4_3_2 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_4_3_2()); 
            // InternalModelDraw.g:3475:2: ( rule__Edge__LabelAssignment_10_2_1_4_3_2 )
            // InternalModelDraw.g:3475:3: rule__Edge__LabelAssignment_10_2_1_4_3_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_10_2_1_4_3_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_10_2_1_4_3_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__3"
    // InternalModelDraw.g:3483:1: rule__Edge__Group_10_2_1_4_3__3 : rule__Edge__Group_10_2_1_4_3__3__Impl ;
    public final void rule__Edge__Group_10_2_1_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3487:1: ( rule__Edge__Group_10_2_1_4_3__3__Impl )
            // InternalModelDraw.g:3488:2: rule__Edge__Group_10_2_1_4_3__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__3"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3__3__Impl"
    // InternalModelDraw.g:3494:1: rule__Edge__Group_10_2_1_4_3__3__Impl : ( ')' ) ;
    public final void rule__Edge__Group_10_2_1_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3498:1: ( ( ')' ) )
            // InternalModelDraw.g:3499:1: ( ')' )
            {
            // InternalModelDraw.g:3499:1: ( ')' )
            // InternalModelDraw.g:3500:2: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_10_2_1_4_3_3()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_10_2_1_4_3_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3__3__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1__0"
    // InternalModelDraw.g:3510:1: rule__Edge__Group_10_2_1_4_3_1__0 : rule__Edge__Group_10_2_1_4_3_1__0__Impl rule__Edge__Group_10_2_1_4_3_1__1 ;
    public final void rule__Edge__Group_10_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3514:1: ( rule__Edge__Group_10_2_1_4_3_1__0__Impl rule__Edge__Group_10_2_1_4_3_1__1 )
            // InternalModelDraw.g:3515:2: rule__Edge__Group_10_2_1_4_3_1__0__Impl rule__Edge__Group_10_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_4_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1__0__Impl"
    // InternalModelDraw.g:3522:1: rule__Edge__Group_10_2_1_4_3_1__0__Impl : ( ( rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0 ) ) ;
    public final void rule__Edge__Group_10_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3526:1: ( ( ( rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0 ) ) )
            // InternalModelDraw.g:3527:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0 ) )
            {
            // InternalModelDraw.g:3527:1: ( ( rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0 ) )
            // InternalModelDraw.g:3528:2: ( rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_4_3_1_0()); 
            // InternalModelDraw.g:3529:2: ( rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0 )
            // InternalModelDraw.g:3529:3: rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_1_4_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1__1"
    // InternalModelDraw.g:3537:1: rule__Edge__Group_10_2_1_4_3_1__1 : rule__Edge__Group_10_2_1_4_3_1__1__Impl rule__Edge__Group_10_2_1_4_3_1__2 ;
    public final void rule__Edge__Group_10_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3541:1: ( rule__Edge__Group_10_2_1_4_3_1__1__Impl rule__Edge__Group_10_2_1_4_3_1__2 )
            // InternalModelDraw.g:3542:2: rule__Edge__Group_10_2_1_4_3_1__1__Impl rule__Edge__Group_10_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_27);
            rule__Edge__Group_10_2_1_4_3_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1__1__Impl"
    // InternalModelDraw.g:3549:1: rule__Edge__Group_10_2_1_4_3_1__1__Impl : ( ( rule__Edge__Group_10_2_1_4_3_1_1__0 )? ) ;
    public final void rule__Edge__Group_10_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3553:1: ( ( ( rule__Edge__Group_10_2_1_4_3_1_1__0 )? ) )
            // InternalModelDraw.g:3554:1: ( ( rule__Edge__Group_10_2_1_4_3_1_1__0 )? )
            {
            // InternalModelDraw.g:3554:1: ( ( rule__Edge__Group_10_2_1_4_3_1_1__0 )? )
            // InternalModelDraw.g:3555:2: ( rule__Edge__Group_10_2_1_4_3_1_1__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_3_1_1()); 
            // InternalModelDraw.g:3556:2: ( rule__Edge__Group_10_2_1_4_3_1_1__0 )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==41) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalModelDraw.g:3556:3: rule__Edge__Group_10_2_1_4_3_1_1__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2_1_4_3_1_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2_1_4_3_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1__2"
    // InternalModelDraw.g:3564:1: rule__Edge__Group_10_2_1_4_3_1__2 : rule__Edge__Group_10_2_1_4_3_1__2__Impl ;
    public final void rule__Edge__Group_10_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3568:1: ( rule__Edge__Group_10_2_1_4_3_1__2__Impl )
            // InternalModelDraw.g:3569:2: rule__Edge__Group_10_2_1_4_3_1__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3_1__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1__2"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1__2__Impl"
    // InternalModelDraw.g:3575:1: rule__Edge__Group_10_2_1_4_3_1__2__Impl : ( '.' ) ;
    public final void rule__Edge__Group_10_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3579:1: ( ( '.' ) )
            // InternalModelDraw.g:3580:1: ( '.' )
            {
            // InternalModelDraw.g:3580:1: ( '.' )
            // InternalModelDraw.g:3581:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_4_3_1_2()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1_4_3_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1__2__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1_1__0"
    // InternalModelDraw.g:3591:1: rule__Edge__Group_10_2_1_4_3_1_1__0 : rule__Edge__Group_10_2_1_4_3_1_1__0__Impl rule__Edge__Group_10_2_1_4_3_1_1__1 ;
    public final void rule__Edge__Group_10_2_1_4_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3595:1: ( rule__Edge__Group_10_2_1_4_3_1_1__0__Impl rule__Edge__Group_10_2_1_4_3_1_1__1 )
            // InternalModelDraw.g:3596:2: rule__Edge__Group_10_2_1_4_3_1_1__0__Impl rule__Edge__Group_10_2_1_4_3_1_1__1
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10_2_1_4_3_1_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3_1_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1_1__0"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1_1__0__Impl"
    // InternalModelDraw.g:3603:1: rule__Edge__Group_10_2_1_4_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Edge__Group_10_2_1_4_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3607:1: ( ( '->' ) )
            // InternalModelDraw.g:3608:1: ( '->' )
            {
            // InternalModelDraw.g:3608:1: ( '->' )
            // InternalModelDraw.g:3609:2: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_4_3_1_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_10_2_1_4_3_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1_1__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1_1__1"
    // InternalModelDraw.g:3618:1: rule__Edge__Group_10_2_1_4_3_1_1__1 : rule__Edge__Group_10_2_1_4_3_1_1__1__Impl ;
    public final void rule__Edge__Group_10_2_1_4_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3622:1: ( rule__Edge__Group_10_2_1_4_3_1_1__1__Impl )
            // InternalModelDraw.g:3623:2: rule__Edge__Group_10_2_1_4_3_1_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2_1_4_3_1_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1_1__1"


    // $ANTLR start "rule__Edge__Group_10_2_1_4_3_1_1__1__Impl"
    // InternalModelDraw.g:3629:1: rule__Edge__Group_10_2_1_4_3_1_1__1__Impl : ( ( rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1 ) ) ;
    public final void rule__Edge__Group_10_2_1_4_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3633:1: ( ( ( rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1 ) ) )
            // InternalModelDraw.g:3634:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1 ) )
            {
            // InternalModelDraw.g:3634:1: ( ( rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1 ) )
            // InternalModelDraw.g:3635:2: ( rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1 )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_4_3_1_1_1()); 
            // InternalModelDraw.g:3636:2: ( rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1 )
            // InternalModelDraw.g:3636:3: rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1
            {
            pushFollow(FOLLOW_2);
            rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getRefTypeAssignment_10_2_1_4_3_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2_1_4_3_1_1__1__Impl"


    // $ANTLR start "rule__Edge__Group_11__0"
    // InternalModelDraw.g:3645:1: rule__Edge__Group_11__0 : rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 ;
    public final void rule__Edge__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3649:1: ( rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 )
            // InternalModelDraw.g:3650:2: rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:3657:1: rule__Edge__Group_11__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Edge__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3661:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:3662:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:3662:1: ( 'src_decoration' )
            // InternalModelDraw.g:3663:2: 'src_decoration'
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationKeyword_11_0()); 
            match(input,42,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSrc_decorationKeyword_11_0()); 

            }


            }

        }
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
    // InternalModelDraw.g:3672:1: rule__Edge__Group_11__1 : rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 ;
    public final void rule__Edge__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3676:1: ( rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 )
            // InternalModelDraw.g:3677:2: rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:3684:1: rule__Edge__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3688:1: ( ( '=' ) )
            // InternalModelDraw.g:3689:1: ( '=' )
            {
            // InternalModelDraw.g:3689:1: ( '=' )
            // InternalModelDraw.g:3690:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_11_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:3699:1: rule__Edge__Group_11__2 : rule__Edge__Group_11__2__Impl ;
    public final void rule__Edge__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3703:1: ( rule__Edge__Group_11__2__Impl )
            // InternalModelDraw.g:3704:2: rule__Edge__Group_11__2__Impl
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
    // InternalModelDraw.g:3710:1: rule__Edge__Group_11__2__Impl : ( ( rule__Edge__Src_decorationAssignment_11_2 ) ) ;
    public final void rule__Edge__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3714:1: ( ( ( rule__Edge__Src_decorationAssignment_11_2 ) ) )
            // InternalModelDraw.g:3715:1: ( ( rule__Edge__Src_decorationAssignment_11_2 ) )
            {
            // InternalModelDraw.g:3715:1: ( ( rule__Edge__Src_decorationAssignment_11_2 ) )
            // InternalModelDraw.g:3716:2: ( rule__Edge__Src_decorationAssignment_11_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationAssignment_11_2()); 
            // InternalModelDraw.g:3717:2: ( rule__Edge__Src_decorationAssignment_11_2 )
            // InternalModelDraw.g:3717:3: rule__Edge__Src_decorationAssignment_11_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Src_decorationAssignment_11_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getSrc_decorationAssignment_11_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Edge__Group_12__0"
    // InternalModelDraw.g:3726:1: rule__Edge__Group_12__0 : rule__Edge__Group_12__0__Impl rule__Edge__Group_12__1 ;
    public final void rule__Edge__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3730:1: ( rule__Edge__Group_12__0__Impl rule__Edge__Group_12__1 )
            // InternalModelDraw.g:3731:2: rule__Edge__Group_12__0__Impl rule__Edge__Group_12__1
            {
            pushFollow(FOLLOW_17);
            rule__Edge__Group_12__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_12__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_12__0"


    // $ANTLR start "rule__Edge__Group_12__0__Impl"
    // InternalModelDraw.g:3738:1: rule__Edge__Group_12__0__Impl : ( 'src_label' ) ;
    public final void rule__Edge__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3742:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:3743:1: ( 'src_label' )
            {
            // InternalModelDraw.g:3743:1: ( 'src_label' )
            // InternalModelDraw.g:3744:2: 'src_label'
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelKeyword_12_0()); 
            match(input,43,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSrc_labelKeyword_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_12__0__Impl"


    // $ANTLR start "rule__Edge__Group_12__1"
    // InternalModelDraw.g:3753:1: rule__Edge__Group_12__1 : rule__Edge__Group_12__1__Impl rule__Edge__Group_12__2 ;
    public final void rule__Edge__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3757:1: ( rule__Edge__Group_12__1__Impl rule__Edge__Group_12__2 )
            // InternalModelDraw.g:3758:2: rule__Edge__Group_12__1__Impl rule__Edge__Group_12__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_12__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_12__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_12__1"


    // $ANTLR start "rule__Edge__Group_12__1__Impl"
    // InternalModelDraw.g:3765:1: rule__Edge__Group_12__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3769:1: ( ( '=' ) )
            // InternalModelDraw.g:3770:1: ( '=' )
            {
            // InternalModelDraw.g:3770:1: ( '=' )
            // InternalModelDraw.g:3771:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_12_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_12_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_12__1__Impl"


    // $ANTLR start "rule__Edge__Group_12__2"
    // InternalModelDraw.g:3780:1: rule__Edge__Group_12__2 : rule__Edge__Group_12__2__Impl ;
    public final void rule__Edge__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3784:1: ( rule__Edge__Group_12__2__Impl )
            // InternalModelDraw.g:3785:2: rule__Edge__Group_12__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_12__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_12__2"


    // $ANTLR start "rule__Edge__Group_12__2__Impl"
    // InternalModelDraw.g:3791:1: rule__Edge__Group_12__2__Impl : ( ( rule__Edge__Src_labelAssignment_12_2 ) ) ;
    public final void rule__Edge__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3795:1: ( ( ( rule__Edge__Src_labelAssignment_12_2 ) ) )
            // InternalModelDraw.g:3796:1: ( ( rule__Edge__Src_labelAssignment_12_2 ) )
            {
            // InternalModelDraw.g:3796:1: ( ( rule__Edge__Src_labelAssignment_12_2 ) )
            // InternalModelDraw.g:3797:2: ( rule__Edge__Src_labelAssignment_12_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelAssignment_12_2()); 
            // InternalModelDraw.g:3798:2: ( rule__Edge__Src_labelAssignment_12_2 )
            // InternalModelDraw.g:3798:3: rule__Edge__Src_labelAssignment_12_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Src_labelAssignment_12_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getSrc_labelAssignment_12_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_12__2__Impl"


    // $ANTLR start "rule__Edge__Group_13__0"
    // InternalModelDraw.g:3807:1: rule__Edge__Group_13__0 : rule__Edge__Group_13__0__Impl rule__Edge__Group_13__1 ;
    public final void rule__Edge__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3811:1: ( rule__Edge__Group_13__0__Impl rule__Edge__Group_13__1 )
            // InternalModelDraw.g:3812:2: rule__Edge__Group_13__0__Impl rule__Edge__Group_13__1
            {
            pushFollow(FOLLOW_17);
            rule__Edge__Group_13__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_13__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_13__0"


    // $ANTLR start "rule__Edge__Group_13__0__Impl"
    // InternalModelDraw.g:3819:1: rule__Edge__Group_13__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Edge__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3823:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:3824:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:3824:1: ( 'tar_decoration' )
            // InternalModelDraw.g:3825:2: 'tar_decoration'
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationKeyword_13_0()); 
            match(input,44,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTar_decorationKeyword_13_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_13__0__Impl"


    // $ANTLR start "rule__Edge__Group_13__1"
    // InternalModelDraw.g:3834:1: rule__Edge__Group_13__1 : rule__Edge__Group_13__1__Impl rule__Edge__Group_13__2 ;
    public final void rule__Edge__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3838:1: ( rule__Edge__Group_13__1__Impl rule__Edge__Group_13__2 )
            // InternalModelDraw.g:3839:2: rule__Edge__Group_13__1__Impl rule__Edge__Group_13__2
            {
            pushFollow(FOLLOW_29);
            rule__Edge__Group_13__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_13__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_13__1"


    // $ANTLR start "rule__Edge__Group_13__1__Impl"
    // InternalModelDraw.g:3846:1: rule__Edge__Group_13__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3850:1: ( ( '=' ) )
            // InternalModelDraw.g:3851:1: ( '=' )
            {
            // InternalModelDraw.g:3851:1: ( '=' )
            // InternalModelDraw.g:3852:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_13_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_13_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_13__1__Impl"


    // $ANTLR start "rule__Edge__Group_13__2"
    // InternalModelDraw.g:3861:1: rule__Edge__Group_13__2 : rule__Edge__Group_13__2__Impl ;
    public final void rule__Edge__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3865:1: ( rule__Edge__Group_13__2__Impl )
            // InternalModelDraw.g:3866:2: rule__Edge__Group_13__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_13__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_13__2"


    // $ANTLR start "rule__Edge__Group_13__2__Impl"
    // InternalModelDraw.g:3872:1: rule__Edge__Group_13__2__Impl : ( ( rule__Edge__Tar_decorationAssignment_13_2 ) ) ;
    public final void rule__Edge__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3876:1: ( ( ( rule__Edge__Tar_decorationAssignment_13_2 ) ) )
            // InternalModelDraw.g:3877:1: ( ( rule__Edge__Tar_decorationAssignment_13_2 ) )
            {
            // InternalModelDraw.g:3877:1: ( ( rule__Edge__Tar_decorationAssignment_13_2 ) )
            // InternalModelDraw.g:3878:2: ( rule__Edge__Tar_decorationAssignment_13_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationAssignment_13_2()); 
            // InternalModelDraw.g:3879:2: ( rule__Edge__Tar_decorationAssignment_13_2 )
            // InternalModelDraw.g:3879:3: rule__Edge__Tar_decorationAssignment_13_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Tar_decorationAssignment_13_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTar_decorationAssignment_13_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_13__2__Impl"


    // $ANTLR start "rule__Edge__Group_14__0"
    // InternalModelDraw.g:3888:1: rule__Edge__Group_14__0 : rule__Edge__Group_14__0__Impl rule__Edge__Group_14__1 ;
    public final void rule__Edge__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3892:1: ( rule__Edge__Group_14__0__Impl rule__Edge__Group_14__1 )
            // InternalModelDraw.g:3893:2: rule__Edge__Group_14__0__Impl rule__Edge__Group_14__1
            {
            pushFollow(FOLLOW_17);
            rule__Edge__Group_14__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_14__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_14__0"


    // $ANTLR start "rule__Edge__Group_14__0__Impl"
    // InternalModelDraw.g:3900:1: rule__Edge__Group_14__0__Impl : ( 'tar_label' ) ;
    public final void rule__Edge__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3904:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:3905:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:3905:1: ( 'tar_label' )
            // InternalModelDraw.g:3906:2: 'tar_label'
            {
             before(grammarAccess.getEdgeAccess().getTar_labelKeyword_14_0()); 
            match(input,45,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTar_labelKeyword_14_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_14__0__Impl"


    // $ANTLR start "rule__Edge__Group_14__1"
    // InternalModelDraw.g:3915:1: rule__Edge__Group_14__1 : rule__Edge__Group_14__1__Impl rule__Edge__Group_14__2 ;
    public final void rule__Edge__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3919:1: ( rule__Edge__Group_14__1__Impl rule__Edge__Group_14__2 )
            // InternalModelDraw.g:3920:2: rule__Edge__Group_14__1__Impl rule__Edge__Group_14__2
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_14__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_14__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_14__1"


    // $ANTLR start "rule__Edge__Group_14__1__Impl"
    // InternalModelDraw.g:3927:1: rule__Edge__Group_14__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3931:1: ( ( '=' ) )
            // InternalModelDraw.g:3932:1: ( '=' )
            {
            // InternalModelDraw.g:3932:1: ( '=' )
            // InternalModelDraw.g:3933:2: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_14_1()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_14_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_14__1__Impl"


    // $ANTLR start "rule__Edge__Group_14__2"
    // InternalModelDraw.g:3942:1: rule__Edge__Group_14__2 : rule__Edge__Group_14__2__Impl ;
    public final void rule__Edge__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3946:1: ( rule__Edge__Group_14__2__Impl )
            // InternalModelDraw.g:3947:2: rule__Edge__Group_14__2__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_14__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_14__2"


    // $ANTLR start "rule__Edge__Group_14__2__Impl"
    // InternalModelDraw.g:3953:1: rule__Edge__Group_14__2__Impl : ( ( rule__Edge__Tar_labelAssignment_14_2 ) ) ;
    public final void rule__Edge__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3957:1: ( ( ( rule__Edge__Tar_labelAssignment_14_2 ) ) )
            // InternalModelDraw.g:3958:1: ( ( rule__Edge__Tar_labelAssignment_14_2 ) )
            {
            // InternalModelDraw.g:3958:1: ( ( rule__Edge__Tar_labelAssignment_14_2 ) )
            // InternalModelDraw.g:3959:2: ( rule__Edge__Tar_labelAssignment_14_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelAssignment_14_2()); 
            // InternalModelDraw.g:3960:2: ( rule__Edge__Tar_labelAssignment_14_2 )
            // InternalModelDraw.g:3960:3: rule__Edge__Tar_labelAssignment_14_2
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Tar_labelAssignment_14_2();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getTar_labelAssignment_14_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_14__2__Impl"


    // $ANTLR start "rule__Level__Group__0"
    // InternalModelDraw.g:3969:1: rule__Level__Group__0 : rule__Level__Group__0__Impl rule__Level__Group__1 ;
    public final void rule__Level__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3973:1: ( rule__Level__Group__0__Impl rule__Level__Group__1 )
            // InternalModelDraw.g:3974:2: rule__Level__Group__0__Impl rule__Level__Group__1
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
    // InternalModelDraw.g:3981:1: rule__Level__Group__0__Impl : ( () ) ;
    public final void rule__Level__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3985:1: ( ( () ) )
            // InternalModelDraw.g:3986:1: ( () )
            {
            // InternalModelDraw.g:3986:1: ( () )
            // InternalModelDraw.g:3987:2: ()
            {
             before(grammarAccess.getLevelAccess().getLevelAction_0()); 
            // InternalModelDraw.g:3988:2: ()
            // InternalModelDraw.g:3988:3: 
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
    // InternalModelDraw.g:3996:1: rule__Level__Group__1 : rule__Level__Group__1__Impl rule__Level__Group__2 ;
    public final void rule__Level__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4000:1: ( rule__Level__Group__1__Impl rule__Level__Group__2 )
            // InternalModelDraw.g:4001:2: rule__Level__Group__1__Impl rule__Level__Group__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:4008:1: rule__Level__Group__1__Impl : ( ( rule__Level__NameAssignment_1 ) ) ;
    public final void rule__Level__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4012:1: ( ( ( rule__Level__NameAssignment_1 ) ) )
            // InternalModelDraw.g:4013:1: ( ( rule__Level__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:4013:1: ( ( rule__Level__NameAssignment_1 ) )
            // InternalModelDraw.g:4014:2: ( rule__Level__NameAssignment_1 )
            {
             before(grammarAccess.getLevelAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:4015:2: ( rule__Level__NameAssignment_1 )
            // InternalModelDraw.g:4015:3: rule__Level__NameAssignment_1
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
    // InternalModelDraw.g:4023:1: rule__Level__Group__2 : rule__Level__Group__2__Impl rule__Level__Group__3 ;
    public final void rule__Level__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4027:1: ( rule__Level__Group__2__Impl rule__Level__Group__3 )
            // InternalModelDraw.g:4028:2: rule__Level__Group__2__Impl rule__Level__Group__3
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
    // InternalModelDraw.g:4035:1: rule__Level__Group__2__Impl : ( '.' ) ;
    public final void rule__Level__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4039:1: ( ( '.' ) )
            // InternalModelDraw.g:4040:1: ( '.' )
            {
            // InternalModelDraw.g:4040:1: ( '.' )
            // InternalModelDraw.g:4041:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalModelDraw.g:4050:1: rule__Level__Group__3 : rule__Level__Group__3__Impl rule__Level__Group__4 ;
    public final void rule__Level__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4054:1: ( rule__Level__Group__3__Impl rule__Level__Group__4 )
            // InternalModelDraw.g:4055:2: rule__Level__Group__3__Impl rule__Level__Group__4
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
    // InternalModelDraw.g:4062:1: rule__Level__Group__3__Impl : ( ( rule__Level__UpperAssignment_3 ) ) ;
    public final void rule__Level__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4066:1: ( ( ( rule__Level__UpperAssignment_3 ) ) )
            // InternalModelDraw.g:4067:1: ( ( rule__Level__UpperAssignment_3 ) )
            {
            // InternalModelDraw.g:4067:1: ( ( rule__Level__UpperAssignment_3 ) )
            // InternalModelDraw.g:4068:2: ( rule__Level__UpperAssignment_3 )
            {
             before(grammarAccess.getLevelAccess().getUpperAssignment_3()); 
            // InternalModelDraw.g:4069:2: ( rule__Level__UpperAssignment_3 )
            // InternalModelDraw.g:4069:3: rule__Level__UpperAssignment_3
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
    // InternalModelDraw.g:4077:1: rule__Level__Group__4 : rule__Level__Group__4__Impl rule__Level__Group__5 ;
    public final void rule__Level__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4081:1: ( rule__Level__Group__4__Impl rule__Level__Group__5 )
            // InternalModelDraw.g:4082:2: rule__Level__Group__4__Impl rule__Level__Group__5
            {
            pushFollow(FOLLOW_24);
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
    // InternalModelDraw.g:4089:1: rule__Level__Group__4__Impl : ( ':' ) ;
    public final void rule__Level__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4093:1: ( ( ':' ) )
            // InternalModelDraw.g:4094:1: ( ':' )
            {
            // InternalModelDraw.g:4094:1: ( ':' )
            // InternalModelDraw.g:4095:2: ':'
            {
             before(grammarAccess.getLevelAccess().getColonKeyword_4()); 
            match(input,27,FOLLOW_2); 
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
    // InternalModelDraw.g:4104:1: rule__Level__Group__5 : rule__Level__Group__5__Impl rule__Level__Group__6 ;
    public final void rule__Level__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4108:1: ( rule__Level__Group__5__Impl rule__Level__Group__6 )
            // InternalModelDraw.g:4109:2: rule__Level__Group__5__Impl rule__Level__Group__6
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:4116:1: rule__Level__Group__5__Impl : ( 'edge' ) ;
    public final void rule__Level__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4120:1: ( ( 'edge' ) )
            // InternalModelDraw.g:4121:1: ( 'edge' )
            {
            // InternalModelDraw.g:4121:1: ( 'edge' )
            // InternalModelDraw.g:4122:2: 'edge'
            {
             before(grammarAccess.getLevelAccess().getEdgeKeyword_5()); 
            match(input,38,FOLLOW_2); 
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
    // InternalModelDraw.g:4131:1: rule__Level__Group__6 : rule__Level__Group__6__Impl rule__Level__Group__7 ;
    public final void rule__Level__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4135:1: ( rule__Level__Group__6__Impl rule__Level__Group__7 )
            // InternalModelDraw.g:4136:2: rule__Level__Group__6__Impl rule__Level__Group__7
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:4143:1: rule__Level__Group__6__Impl : ( ( rule__Level__Group_6__0 )? ) ;
    public final void rule__Level__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4147:1: ( ( ( rule__Level__Group_6__0 )? ) )
            // InternalModelDraw.g:4148:1: ( ( rule__Level__Group_6__0 )? )
            {
            // InternalModelDraw.g:4148:1: ( ( rule__Level__Group_6__0 )? )
            // InternalModelDraw.g:4149:2: ( rule__Level__Group_6__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_6()); 
            // InternalModelDraw.g:4150:2: ( rule__Level__Group_6__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==33) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalModelDraw.g:4150:3: rule__Level__Group_6__0
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
    // InternalModelDraw.g:4158:1: rule__Level__Group__7 : rule__Level__Group__7__Impl rule__Level__Group__8 ;
    public final void rule__Level__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4162:1: ( rule__Level__Group__7__Impl rule__Level__Group__8 )
            // InternalModelDraw.g:4163:2: rule__Level__Group__7__Impl rule__Level__Group__8
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:4170:1: rule__Level__Group__7__Impl : ( ( rule__Level__Group_7__0 )? ) ;
    public final void rule__Level__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4174:1: ( ( ( rule__Level__Group_7__0 )? ) )
            // InternalModelDraw.g:4175:1: ( ( rule__Level__Group_7__0 )? )
            {
            // InternalModelDraw.g:4175:1: ( ( rule__Level__Group_7__0 )? )
            // InternalModelDraw.g:4176:2: ( rule__Level__Group_7__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7()); 
            // InternalModelDraw.g:4177:2: ( rule__Level__Group_7__0 )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==39) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalModelDraw.g:4177:3: rule__Level__Group_7__0
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
    // InternalModelDraw.g:4185:1: rule__Level__Group__8 : rule__Level__Group__8__Impl rule__Level__Group__9 ;
    public final void rule__Level__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4189:1: ( rule__Level__Group__8__Impl rule__Level__Group__9 )
            // InternalModelDraw.g:4190:2: rule__Level__Group__8__Impl rule__Level__Group__9
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:4197:1: rule__Level__Group__8__Impl : ( ( rule__Level__Group_8__0 )? ) ;
    public final void rule__Level__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4201:1: ( ( ( rule__Level__Group_8__0 )? ) )
            // InternalModelDraw.g:4202:1: ( ( rule__Level__Group_8__0 )? )
            {
            // InternalModelDraw.g:4202:1: ( ( rule__Level__Group_8__0 )? )
            // InternalModelDraw.g:4203:2: ( rule__Level__Group_8__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_8()); 
            // InternalModelDraw.g:4204:2: ( rule__Level__Group_8__0 )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==42) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalModelDraw.g:4204:3: rule__Level__Group_8__0
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
    // InternalModelDraw.g:4212:1: rule__Level__Group__9 : rule__Level__Group__9__Impl rule__Level__Group__10 ;
    public final void rule__Level__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4216:1: ( rule__Level__Group__9__Impl rule__Level__Group__10 )
            // InternalModelDraw.g:4217:2: rule__Level__Group__9__Impl rule__Level__Group__10
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:4224:1: rule__Level__Group__9__Impl : ( ( rule__Level__Group_9__0 )? ) ;
    public final void rule__Level__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4228:1: ( ( ( rule__Level__Group_9__0 )? ) )
            // InternalModelDraw.g:4229:1: ( ( rule__Level__Group_9__0 )? )
            {
            // InternalModelDraw.g:4229:1: ( ( rule__Level__Group_9__0 )? )
            // InternalModelDraw.g:4230:2: ( rule__Level__Group_9__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_9()); 
            // InternalModelDraw.g:4231:2: ( rule__Level__Group_9__0 )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==43) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalModelDraw.g:4231:3: rule__Level__Group_9__0
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
    // InternalModelDraw.g:4239:1: rule__Level__Group__10 : rule__Level__Group__10__Impl rule__Level__Group__11 ;
    public final void rule__Level__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4243:1: ( rule__Level__Group__10__Impl rule__Level__Group__11 )
            // InternalModelDraw.g:4244:2: rule__Level__Group__10__Impl rule__Level__Group__11
            {
            pushFollow(FOLLOW_25);
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
    // InternalModelDraw.g:4251:1: rule__Level__Group__10__Impl : ( ( rule__Level__Group_10__0 )? ) ;
    public final void rule__Level__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4255:1: ( ( ( rule__Level__Group_10__0 )? ) )
            // InternalModelDraw.g:4256:1: ( ( rule__Level__Group_10__0 )? )
            {
            // InternalModelDraw.g:4256:1: ( ( rule__Level__Group_10__0 )? )
            // InternalModelDraw.g:4257:2: ( rule__Level__Group_10__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_10()); 
            // InternalModelDraw.g:4258:2: ( rule__Level__Group_10__0 )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==44) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalModelDraw.g:4258:3: rule__Level__Group_10__0
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
    // InternalModelDraw.g:4266:1: rule__Level__Group__11 : rule__Level__Group__11__Impl ;
    public final void rule__Level__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4270:1: ( rule__Level__Group__11__Impl )
            // InternalModelDraw.g:4271:2: rule__Level__Group__11__Impl
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
    // InternalModelDraw.g:4277:1: rule__Level__Group__11__Impl : ( ( rule__Level__Group_11__0 )? ) ;
    public final void rule__Level__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4281:1: ( ( ( rule__Level__Group_11__0 )? ) )
            // InternalModelDraw.g:4282:1: ( ( rule__Level__Group_11__0 )? )
            {
            // InternalModelDraw.g:4282:1: ( ( rule__Level__Group_11__0 )? )
            // InternalModelDraw.g:4283:2: ( rule__Level__Group_11__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_11()); 
            // InternalModelDraw.g:4284:2: ( rule__Level__Group_11__0 )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==45) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalModelDraw.g:4284:3: rule__Level__Group_11__0
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
    // InternalModelDraw.g:4293:1: rule__Level__Group_6__0 : rule__Level__Group_6__0__Impl rule__Level__Group_6__1 ;
    public final void rule__Level__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4297:1: ( rule__Level__Group_6__0__Impl rule__Level__Group_6__1 )
            // InternalModelDraw.g:4298:2: rule__Level__Group_6__0__Impl rule__Level__Group_6__1
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
    // InternalModelDraw.g:4305:1: rule__Level__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Level__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4309:1: ( ( '=' ) )
            // InternalModelDraw.g:4310:1: ( '=' )
            {
            // InternalModelDraw.g:4310:1: ( '=' )
            // InternalModelDraw.g:4311:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_6_0()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:4320:1: rule__Level__Group_6__1 : rule__Level__Group_6__1__Impl ;
    public final void rule__Level__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4324:1: ( rule__Level__Group_6__1__Impl )
            // InternalModelDraw.g:4325:2: rule__Level__Group_6__1__Impl
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
    // InternalModelDraw.g:4331:1: rule__Level__Group_6__1__Impl : ( ( rule__Level__AttNameAssignment_6_1 ) ) ;
    public final void rule__Level__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4335:1: ( ( ( rule__Level__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:4336:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:4336:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:4337:2: ( rule__Level__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getLevelAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:4338:2: ( rule__Level__AttNameAssignment_6_1 )
            // InternalModelDraw.g:4338:3: rule__Level__AttNameAssignment_6_1
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
    // InternalModelDraw.g:4347:1: rule__Level__Group_7__0 : rule__Level__Group_7__0__Impl rule__Level__Group_7__1 ;
    public final void rule__Level__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4351:1: ( rule__Level__Group_7__0__Impl rule__Level__Group_7__1 )
            // InternalModelDraw.g:4352:2: rule__Level__Group_7__0__Impl rule__Level__Group_7__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:4359:1: rule__Level__Group_7__0__Impl : ( 'label' ) ;
    public final void rule__Level__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4363:1: ( ( 'label' ) )
            // InternalModelDraw.g:4364:1: ( 'label' )
            {
            // InternalModelDraw.g:4364:1: ( 'label' )
            // InternalModelDraw.g:4365:2: 'label'
            {
             before(grammarAccess.getLevelAccess().getLabelKeyword_7_0()); 
            match(input,39,FOLLOW_2); 
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
    // InternalModelDraw.g:4374:1: rule__Level__Group_7__1 : rule__Level__Group_7__1__Impl rule__Level__Group_7__2 ;
    public final void rule__Level__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4378:1: ( rule__Level__Group_7__1__Impl rule__Level__Group_7__2 )
            // InternalModelDraw.g:4379:2: rule__Level__Group_7__1__Impl rule__Level__Group_7__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalModelDraw.g:4386:1: rule__Level__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4390:1: ( ( '=' ) )
            // InternalModelDraw.g:4391:1: ( '=' )
            {
            // InternalModelDraw.g:4391:1: ( '=' )
            // InternalModelDraw.g:4392:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_7_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:4401:1: rule__Level__Group_7__2 : rule__Level__Group_7__2__Impl ;
    public final void rule__Level__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4405:1: ( rule__Level__Group_7__2__Impl )
            // InternalModelDraw.g:4406:2: rule__Level__Group_7__2__Impl
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
    // InternalModelDraw.g:4412:1: rule__Level__Group_7__2__Impl : ( ( rule__Level__Alternatives_7_2 ) ) ;
    public final void rule__Level__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4416:1: ( ( ( rule__Level__Alternatives_7_2 ) ) )
            // InternalModelDraw.g:4417:1: ( ( rule__Level__Alternatives_7_2 ) )
            {
            // InternalModelDraw.g:4417:1: ( ( rule__Level__Alternatives_7_2 ) )
            // InternalModelDraw.g:4418:2: ( rule__Level__Alternatives_7_2 )
            {
             before(grammarAccess.getLevelAccess().getAlternatives_7_2()); 
            // InternalModelDraw.g:4419:2: ( rule__Level__Alternatives_7_2 )
            // InternalModelDraw.g:4419:3: rule__Level__Alternatives_7_2
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
    // InternalModelDraw.g:4428:1: rule__Level__Group_7_2_0__0 : rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1 ;
    public final void rule__Level__Group_7_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4432:1: ( rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1 )
            // InternalModelDraw.g:4433:2: rule__Level__Group_7_2_0__0__Impl rule__Level__Group_7_2_0__1
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
    // InternalModelDraw.g:4440:1: rule__Level__Group_7_2_0__0__Impl : ( ( rule__Level__Group_7_2_0_0__0 )? ) ;
    public final void rule__Level__Group_7_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4444:1: ( ( ( rule__Level__Group_7_2_0_0__0 )? ) )
            // InternalModelDraw.g:4445:1: ( ( rule__Level__Group_7_2_0_0__0 )? )
            {
            // InternalModelDraw.g:4445:1: ( ( rule__Level__Group_7_2_0_0__0 )? )
            // InternalModelDraw.g:4446:2: ( rule__Level__Group_7_2_0_0__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_0_0()); 
            // InternalModelDraw.g:4447:2: ( rule__Level__Group_7_2_0_0__0 )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==RULE_ID) ) {
                int LA46_1 = input.LA(2);

                if ( ((LA46_1>=40 && LA46_1<=41)) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalModelDraw.g:4447:3: rule__Level__Group_7_2_0_0__0
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
    // InternalModelDraw.g:4455:1: rule__Level__Group_7_2_0__1 : rule__Level__Group_7_2_0__1__Impl ;
    public final void rule__Level__Group_7_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4459:1: ( rule__Level__Group_7_2_0__1__Impl )
            // InternalModelDraw.g:4460:2: rule__Level__Group_7_2_0__1__Impl
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
    // InternalModelDraw.g:4466:1: rule__Level__Group_7_2_0__1__Impl : ( ( rule__Level__LabelAssignment_7_2_0_1 ) ) ;
    public final void rule__Level__Group_7_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4470:1: ( ( ( rule__Level__LabelAssignment_7_2_0_1 ) ) )
            // InternalModelDraw.g:4471:1: ( ( rule__Level__LabelAssignment_7_2_0_1 ) )
            {
            // InternalModelDraw.g:4471:1: ( ( rule__Level__LabelAssignment_7_2_0_1 ) )
            // InternalModelDraw.g:4472:2: ( rule__Level__LabelAssignment_7_2_0_1 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_0_1()); 
            // InternalModelDraw.g:4473:2: ( rule__Level__LabelAssignment_7_2_0_1 )
            // InternalModelDraw.g:4473:3: rule__Level__LabelAssignment_7_2_0_1
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
    // InternalModelDraw.g:4482:1: rule__Level__Group_7_2_0_0__0 : rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1 ;
    public final void rule__Level__Group_7_2_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4486:1: ( rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1 )
            // InternalModelDraw.g:4487:2: rule__Level__Group_7_2_0_0__0__Impl rule__Level__Group_7_2_0_0__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:4494:1: rule__Level__Group_7_2_0_0__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) ) ;
    public final void rule__Level__Group_7_2_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4498:1: ( ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) ) )
            // InternalModelDraw.g:4499:1: ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) )
            {
            // InternalModelDraw.g:4499:1: ( ( rule__Level__ReferenceAssignment_7_2_0_0_0 ) )
            // InternalModelDraw.g:4500:2: ( rule__Level__ReferenceAssignment_7_2_0_0_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_0_0_0()); 
            // InternalModelDraw.g:4501:2: ( rule__Level__ReferenceAssignment_7_2_0_0_0 )
            // InternalModelDraw.g:4501:3: rule__Level__ReferenceAssignment_7_2_0_0_0
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
    // InternalModelDraw.g:4509:1: rule__Level__Group_7_2_0_0__1 : rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2 ;
    public final void rule__Level__Group_7_2_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4513:1: ( rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2 )
            // InternalModelDraw.g:4514:2: rule__Level__Group_7_2_0_0__1__Impl rule__Level__Group_7_2_0_0__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:4521:1: rule__Level__Group_7_2_0_0__1__Impl : ( ( rule__Level__Group_7_2_0_0_1__0 )? ) ;
    public final void rule__Level__Group_7_2_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4525:1: ( ( ( rule__Level__Group_7_2_0_0_1__0 )? ) )
            // InternalModelDraw.g:4526:1: ( ( rule__Level__Group_7_2_0_0_1__0 )? )
            {
            // InternalModelDraw.g:4526:1: ( ( rule__Level__Group_7_2_0_0_1__0 )? )
            // InternalModelDraw.g:4527:2: ( rule__Level__Group_7_2_0_0_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_0_0_1()); 
            // InternalModelDraw.g:4528:2: ( rule__Level__Group_7_2_0_0_1__0 )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==41) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalModelDraw.g:4528:3: rule__Level__Group_7_2_0_0_1__0
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
    // InternalModelDraw.g:4536:1: rule__Level__Group_7_2_0_0__2 : rule__Level__Group_7_2_0_0__2__Impl ;
    public final void rule__Level__Group_7_2_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4540:1: ( rule__Level__Group_7_2_0_0__2__Impl )
            // InternalModelDraw.g:4541:2: rule__Level__Group_7_2_0_0__2__Impl
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
    // InternalModelDraw.g:4547:1: rule__Level__Group_7_2_0_0__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4551:1: ( ( '.' ) )
            // InternalModelDraw.g:4552:1: ( '.' )
            {
            // InternalModelDraw.g:4552:1: ( '.' )
            // InternalModelDraw.g:4553:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_0_0_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalModelDraw.g:4563:1: rule__Level__Group_7_2_0_0_1__0 : rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1 ;
    public final void rule__Level__Group_7_2_0_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4567:1: ( rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1 )
            // InternalModelDraw.g:4568:2: rule__Level__Group_7_2_0_0_1__0__Impl rule__Level__Group_7_2_0_0_1__1
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
    // InternalModelDraw.g:4575:1: rule__Level__Group_7_2_0_0_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_0_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4579:1: ( ( '->' ) )
            // InternalModelDraw.g:4580:1: ( '->' )
            {
            // InternalModelDraw.g:4580:1: ( '->' )
            // InternalModelDraw.g:4581:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_0_0_1_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalModelDraw.g:4590:1: rule__Level__Group_7_2_0_0_1__1 : rule__Level__Group_7_2_0_0_1__1__Impl ;
    public final void rule__Level__Group_7_2_0_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4594:1: ( rule__Level__Group_7_2_0_0_1__1__Impl )
            // InternalModelDraw.g:4595:2: rule__Level__Group_7_2_0_0_1__1__Impl
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
    // InternalModelDraw.g:4601:1: rule__Level__Group_7_2_0_0_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) ) ;
    public final void rule__Level__Group_7_2_0_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4605:1: ( ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) ) )
            // InternalModelDraw.g:4606:1: ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) )
            {
            // InternalModelDraw.g:4606:1: ( ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 ) )
            // InternalModelDraw.g:4607:2: ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_0_0_1_1()); 
            // InternalModelDraw.g:4608:2: ( rule__Level__RefTypeAssignment_7_2_0_0_1_1 )
            // InternalModelDraw.g:4608:3: rule__Level__RefTypeAssignment_7_2_0_0_1_1
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
    // InternalModelDraw.g:4617:1: rule__Level__Group_7_2_1__0 : rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1 ;
    public final void rule__Level__Group_7_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4621:1: ( rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1 )
            // InternalModelDraw.g:4622:2: rule__Level__Group_7_2_1__0__Impl rule__Level__Group_7_2_1__1
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
    // InternalModelDraw.g:4629:1: rule__Level__Group_7_2_1__0__Impl : ( '{' ) ;
    public final void rule__Level__Group_7_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4633:1: ( ( '{' ) )
            // InternalModelDraw.g:4634:1: ( '{' )
            {
            // InternalModelDraw.g:4634:1: ( '{' )
            // InternalModelDraw.g:4635:2: '{'
            {
             before(grammarAccess.getLevelAccess().getLeftCurlyBracketKeyword_7_2_1_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalModelDraw.g:4644:1: rule__Level__Group_7_2_1__1 : rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2 ;
    public final void rule__Level__Group_7_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4648:1: ( rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2 )
            // InternalModelDraw.g:4649:2: rule__Level__Group_7_2_1__1__Impl rule__Level__Group_7_2_1__2
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
    // InternalModelDraw.g:4656:1: rule__Level__Group_7_2_1__1__Impl : ( ( rule__Level__Group_7_2_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4660:1: ( ( ( rule__Level__Group_7_2_1_1__0 )? ) )
            // InternalModelDraw.g:4661:1: ( ( rule__Level__Group_7_2_1_1__0 )? )
            {
            // InternalModelDraw.g:4661:1: ( ( rule__Level__Group_7_2_1_1__0 )? )
            // InternalModelDraw.g:4662:2: ( rule__Level__Group_7_2_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_1()); 
            // InternalModelDraw.g:4663:2: ( rule__Level__Group_7_2_1_1__0 )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( ((LA48_1>=40 && LA48_1<=41)) ) {
                    alt48=1;
                }
            }
            switch (alt48) {
                case 1 :
                    // InternalModelDraw.g:4663:3: rule__Level__Group_7_2_1_1__0
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
    // InternalModelDraw.g:4671:1: rule__Level__Group_7_2_1__2 : rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3 ;
    public final void rule__Level__Group_7_2_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4675:1: ( rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3 )
            // InternalModelDraw.g:4676:2: rule__Level__Group_7_2_1__2__Impl rule__Level__Group_7_2_1__3
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:4683:1: rule__Level__Group_7_2_1__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_2 ) ) ;
    public final void rule__Level__Group_7_2_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4687:1: ( ( ( rule__Level__LabelAssignment_7_2_1_2 ) ) )
            // InternalModelDraw.g:4688:1: ( ( rule__Level__LabelAssignment_7_2_1_2 ) )
            {
            // InternalModelDraw.g:4688:1: ( ( rule__Level__LabelAssignment_7_2_1_2 ) )
            // InternalModelDraw.g:4689:2: ( rule__Level__LabelAssignment_7_2_1_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_2()); 
            // InternalModelDraw.g:4690:2: ( rule__Level__LabelAssignment_7_2_1_2 )
            // InternalModelDraw.g:4690:3: rule__Level__LabelAssignment_7_2_1_2
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
    // InternalModelDraw.g:4698:1: rule__Level__Group_7_2_1__3 : rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4 ;
    public final void rule__Level__Group_7_2_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4702:1: ( rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4 )
            // InternalModelDraw.g:4703:2: rule__Level__Group_7_2_1__3__Impl rule__Level__Group_7_2_1__4
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:4710:1: rule__Level__Group_7_2_1__3__Impl : ( ( rule__Level__Group_7_2_1_3__0 )? ) ;
    public final void rule__Level__Group_7_2_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4714:1: ( ( ( rule__Level__Group_7_2_1_3__0 )? ) )
            // InternalModelDraw.g:4715:1: ( ( rule__Level__Group_7_2_1_3__0 )? )
            {
            // InternalModelDraw.g:4715:1: ( ( rule__Level__Group_7_2_1_3__0 )? )
            // InternalModelDraw.g:4716:2: ( rule__Level__Group_7_2_1_3__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3()); 
            // InternalModelDraw.g:4717:2: ( rule__Level__Group_7_2_1_3__0 )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==30) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalModelDraw.g:4717:3: rule__Level__Group_7_2_1_3__0
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
    // InternalModelDraw.g:4725:1: rule__Level__Group_7_2_1__4 : rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5 ;
    public final void rule__Level__Group_7_2_1__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4729:1: ( rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5 )
            // InternalModelDraw.g:4730:2: rule__Level__Group_7_2_1__4__Impl rule__Level__Group_7_2_1__5
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:4737:1: rule__Level__Group_7_2_1__4__Impl : ( ( rule__Level__Group_7_2_1_4__0 )* ) ;
    public final void rule__Level__Group_7_2_1__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4741:1: ( ( ( rule__Level__Group_7_2_1_4__0 )* ) )
            // InternalModelDraw.g:4742:1: ( ( rule__Level__Group_7_2_1_4__0 )* )
            {
            // InternalModelDraw.g:4742:1: ( ( rule__Level__Group_7_2_1_4__0 )* )
            // InternalModelDraw.g:4743:2: ( rule__Level__Group_7_2_1_4__0 )*
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4()); 
            // InternalModelDraw.g:4744:2: ( rule__Level__Group_7_2_1_4__0 )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==32) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalModelDraw.g:4744:3: rule__Level__Group_7_2_1_4__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Level__Group_7_2_1_4__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // InternalModelDraw.g:4752:1: rule__Level__Group_7_2_1__5 : rule__Level__Group_7_2_1__5__Impl ;
    public final void rule__Level__Group_7_2_1__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4756:1: ( rule__Level__Group_7_2_1__5__Impl )
            // InternalModelDraw.g:4757:2: rule__Level__Group_7_2_1__5__Impl
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
    // InternalModelDraw.g:4763:1: rule__Level__Group_7_2_1__5__Impl : ( '}' ) ;
    public final void rule__Level__Group_7_2_1__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4767:1: ( ( '}' ) )
            // InternalModelDraw.g:4768:1: ( '}' )
            {
            // InternalModelDraw.g:4768:1: ( '}' )
            // InternalModelDraw.g:4769:2: '}'
            {
             before(grammarAccess.getLevelAccess().getRightCurlyBracketKeyword_7_2_1_5()); 
            match(input,29,FOLLOW_2); 
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
    // InternalModelDraw.g:4779:1: rule__Level__Group_7_2_1_1__0 : rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1 ;
    public final void rule__Level__Group_7_2_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4783:1: ( rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1 )
            // InternalModelDraw.g:4784:2: rule__Level__Group_7_2_1_1__0__Impl rule__Level__Group_7_2_1_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:4791:1: rule__Level__Group_7_2_1_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4795:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) ) )
            // InternalModelDraw.g:4796:1: ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) )
            {
            // InternalModelDraw.g:4796:1: ( ( rule__Level__ReferenceAssignment_7_2_1_1_0 ) )
            // InternalModelDraw.g:4797:2: ( rule__Level__ReferenceAssignment_7_2_1_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_1_0()); 
            // InternalModelDraw.g:4798:2: ( rule__Level__ReferenceAssignment_7_2_1_1_0 )
            // InternalModelDraw.g:4798:3: rule__Level__ReferenceAssignment_7_2_1_1_0
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
    // InternalModelDraw.g:4806:1: rule__Level__Group_7_2_1_1__1 : rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2 ;
    public final void rule__Level__Group_7_2_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4810:1: ( rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2 )
            // InternalModelDraw.g:4811:2: rule__Level__Group_7_2_1_1__1__Impl rule__Level__Group_7_2_1_1__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:4818:1: rule__Level__Group_7_2_1_1__1__Impl : ( ( rule__Level__Group_7_2_1_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4822:1: ( ( ( rule__Level__Group_7_2_1_1_1__0 )? ) )
            // InternalModelDraw.g:4823:1: ( ( rule__Level__Group_7_2_1_1_1__0 )? )
            {
            // InternalModelDraw.g:4823:1: ( ( rule__Level__Group_7_2_1_1_1__0 )? )
            // InternalModelDraw.g:4824:2: ( rule__Level__Group_7_2_1_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_1_1()); 
            // InternalModelDraw.g:4825:2: ( rule__Level__Group_7_2_1_1_1__0 )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==41) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalModelDraw.g:4825:3: rule__Level__Group_7_2_1_1_1__0
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
    // InternalModelDraw.g:4833:1: rule__Level__Group_7_2_1_1__2 : rule__Level__Group_7_2_1_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4837:1: ( rule__Level__Group_7_2_1_1__2__Impl )
            // InternalModelDraw.g:4838:2: rule__Level__Group_7_2_1_1__2__Impl
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
    // InternalModelDraw.g:4844:1: rule__Level__Group_7_2_1_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4848:1: ( ( '.' ) )
            // InternalModelDraw.g:4849:1: ( '.' )
            {
            // InternalModelDraw.g:4849:1: ( '.' )
            // InternalModelDraw.g:4850:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_1_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalModelDraw.g:4860:1: rule__Level__Group_7_2_1_1_1__0 : rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1 ;
    public final void rule__Level__Group_7_2_1_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4864:1: ( rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1 )
            // InternalModelDraw.g:4865:2: rule__Level__Group_7_2_1_1_1__0__Impl rule__Level__Group_7_2_1_1_1__1
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
    // InternalModelDraw.g:4872:1: rule__Level__Group_7_2_1_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4876:1: ( ( '->' ) )
            // InternalModelDraw.g:4877:1: ( '->' )
            {
            // InternalModelDraw.g:4877:1: ( '->' )
            // InternalModelDraw.g:4878:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_1_1_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalModelDraw.g:4887:1: rule__Level__Group_7_2_1_1_1__1 : rule__Level__Group_7_2_1_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4891:1: ( rule__Level__Group_7_2_1_1_1__1__Impl )
            // InternalModelDraw.g:4892:2: rule__Level__Group_7_2_1_1_1__1__Impl
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
    // InternalModelDraw.g:4898:1: rule__Level__Group_7_2_1_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4902:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) ) )
            // InternalModelDraw.g:4903:1: ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) )
            {
            // InternalModelDraw.g:4903:1: ( ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 ) )
            // InternalModelDraw.g:4904:2: ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_1_1_1()); 
            // InternalModelDraw.g:4905:2: ( rule__Level__RefTypeAssignment_7_2_1_1_1_1 )
            // InternalModelDraw.g:4905:3: rule__Level__RefTypeAssignment_7_2_1_1_1_1
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
    // InternalModelDraw.g:4914:1: rule__Level__Group_7_2_1_3__0 : rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1 ;
    public final void rule__Level__Group_7_2_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4918:1: ( rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1 )
            // InternalModelDraw.g:4919:2: rule__Level__Group_7_2_1_3__0__Impl rule__Level__Group_7_2_1_3__1
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
    // InternalModelDraw.g:4926:1: rule__Level__Group_7_2_1_3__0__Impl : ( '(' ) ;
    public final void rule__Level__Group_7_2_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4930:1: ( ( '(' ) )
            // InternalModelDraw.g:4931:1: ( '(' )
            {
            // InternalModelDraw.g:4931:1: ( '(' )
            // InternalModelDraw.g:4932:2: '('
            {
             before(grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_3_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalModelDraw.g:4941:1: rule__Level__Group_7_2_1_3__1 : rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2 ;
    public final void rule__Level__Group_7_2_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4945:1: ( rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2 )
            // InternalModelDraw.g:4946:2: rule__Level__Group_7_2_1_3__1__Impl rule__Level__Group_7_2_1_3__2
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
    // InternalModelDraw.g:4953:1: rule__Level__Group_7_2_1_3__1__Impl : ( ( rule__Level__Group_7_2_1_3_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4957:1: ( ( ( rule__Level__Group_7_2_1_3_1__0 )? ) )
            // InternalModelDraw.g:4958:1: ( ( rule__Level__Group_7_2_1_3_1__0 )? )
            {
            // InternalModelDraw.g:4958:1: ( ( rule__Level__Group_7_2_1_3_1__0 )? )
            // InternalModelDraw.g:4959:2: ( rule__Level__Group_7_2_1_3_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1()); 
            // InternalModelDraw.g:4960:2: ( rule__Level__Group_7_2_1_3_1__0 )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                int LA52_1 = input.LA(2);

                if ( ((LA52_1>=40 && LA52_1<=41)) ) {
                    alt52=1;
                }
            }
            switch (alt52) {
                case 1 :
                    // InternalModelDraw.g:4960:3: rule__Level__Group_7_2_1_3_1__0
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
    // InternalModelDraw.g:4968:1: rule__Level__Group_7_2_1_3__2 : rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3 ;
    public final void rule__Level__Group_7_2_1_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4972:1: ( rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3 )
            // InternalModelDraw.g:4973:2: rule__Level__Group_7_2_1_3__2__Impl rule__Level__Group_7_2_1_3__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalModelDraw.g:4980:1: rule__Level__Group_7_2_1_3__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) ) ;
    public final void rule__Level__Group_7_2_1_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4984:1: ( ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) ) )
            // InternalModelDraw.g:4985:1: ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) )
            {
            // InternalModelDraw.g:4985:1: ( ( rule__Level__LabelAssignment_7_2_1_3_2 ) )
            // InternalModelDraw.g:4986:2: ( rule__Level__LabelAssignment_7_2_1_3_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_3_2()); 
            // InternalModelDraw.g:4987:2: ( rule__Level__LabelAssignment_7_2_1_3_2 )
            // InternalModelDraw.g:4987:3: rule__Level__LabelAssignment_7_2_1_3_2
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
    // InternalModelDraw.g:4995:1: rule__Level__Group_7_2_1_3__3 : rule__Level__Group_7_2_1_3__3__Impl ;
    public final void rule__Level__Group_7_2_1_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4999:1: ( rule__Level__Group_7_2_1_3__3__Impl )
            // InternalModelDraw.g:5000:2: rule__Level__Group_7_2_1_3__3__Impl
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
    // InternalModelDraw.g:5006:1: rule__Level__Group_7_2_1_3__3__Impl : ( ')' ) ;
    public final void rule__Level__Group_7_2_1_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5010:1: ( ( ')' ) )
            // InternalModelDraw.g:5011:1: ( ')' )
            {
            // InternalModelDraw.g:5011:1: ( ')' )
            // InternalModelDraw.g:5012:2: ')'
            {
             before(grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_3_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalModelDraw.g:5022:1: rule__Level__Group_7_2_1_3_1__0 : rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1 ;
    public final void rule__Level__Group_7_2_1_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5026:1: ( rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1 )
            // InternalModelDraw.g:5027:2: rule__Level__Group_7_2_1_3_1__0__Impl rule__Level__Group_7_2_1_3_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:5034:1: rule__Level__Group_7_2_1_3_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5038:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) ) )
            // InternalModelDraw.g:5039:1: ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) )
            {
            // InternalModelDraw.g:5039:1: ( ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 ) )
            // InternalModelDraw.g:5040:2: ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_3_1_0()); 
            // InternalModelDraw.g:5041:2: ( rule__Level__ReferenceAssignment_7_2_1_3_1_0 )
            // InternalModelDraw.g:5041:3: rule__Level__ReferenceAssignment_7_2_1_3_1_0
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
    // InternalModelDraw.g:5049:1: rule__Level__Group_7_2_1_3_1__1 : rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2 ;
    public final void rule__Level__Group_7_2_1_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5053:1: ( rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2 )
            // InternalModelDraw.g:5054:2: rule__Level__Group_7_2_1_3_1__1__Impl rule__Level__Group_7_2_1_3_1__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:5061:1: rule__Level__Group_7_2_1_3_1__1__Impl : ( ( rule__Level__Group_7_2_1_3_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5065:1: ( ( ( rule__Level__Group_7_2_1_3_1_1__0 )? ) )
            // InternalModelDraw.g:5066:1: ( ( rule__Level__Group_7_2_1_3_1_1__0 )? )
            {
            // InternalModelDraw.g:5066:1: ( ( rule__Level__Group_7_2_1_3_1_1__0 )? )
            // InternalModelDraw.g:5067:2: ( rule__Level__Group_7_2_1_3_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_3_1_1()); 
            // InternalModelDraw.g:5068:2: ( rule__Level__Group_7_2_1_3_1_1__0 )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==41) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalModelDraw.g:5068:3: rule__Level__Group_7_2_1_3_1_1__0
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
    // InternalModelDraw.g:5076:1: rule__Level__Group_7_2_1_3_1__2 : rule__Level__Group_7_2_1_3_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5080:1: ( rule__Level__Group_7_2_1_3_1__2__Impl )
            // InternalModelDraw.g:5081:2: rule__Level__Group_7_2_1_3_1__2__Impl
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
    // InternalModelDraw.g:5087:1: rule__Level__Group_7_2_1_3_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5091:1: ( ( '.' ) )
            // InternalModelDraw.g:5092:1: ( '.' )
            {
            // InternalModelDraw.g:5092:1: ( '.' )
            // InternalModelDraw.g:5093:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_3_1_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalModelDraw.g:5103:1: rule__Level__Group_7_2_1_3_1_1__0 : rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1 ;
    public final void rule__Level__Group_7_2_1_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5107:1: ( rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1 )
            // InternalModelDraw.g:5108:2: rule__Level__Group_7_2_1_3_1_1__0__Impl rule__Level__Group_7_2_1_3_1_1__1
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
    // InternalModelDraw.g:5115:1: rule__Level__Group_7_2_1_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5119:1: ( ( '->' ) )
            // InternalModelDraw.g:5120:1: ( '->' )
            {
            // InternalModelDraw.g:5120:1: ( '->' )
            // InternalModelDraw.g:5121:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_3_1_1_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalModelDraw.g:5130:1: rule__Level__Group_7_2_1_3_1_1__1 : rule__Level__Group_7_2_1_3_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5134:1: ( rule__Level__Group_7_2_1_3_1_1__1__Impl )
            // InternalModelDraw.g:5135:2: rule__Level__Group_7_2_1_3_1_1__1__Impl
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
    // InternalModelDraw.g:5141:1: rule__Level__Group_7_2_1_3_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5145:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) ) )
            // InternalModelDraw.g:5146:1: ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            {
            // InternalModelDraw.g:5146:1: ( ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 ) )
            // InternalModelDraw.g:5147:2: ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_3_1_1_1()); 
            // InternalModelDraw.g:5148:2: ( rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 )
            // InternalModelDraw.g:5148:3: rule__Level__RefTypeAssignment_7_2_1_3_1_1_1
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
    // InternalModelDraw.g:5157:1: rule__Level__Group_7_2_1_4__0 : rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1 ;
    public final void rule__Level__Group_7_2_1_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5161:1: ( rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1 )
            // InternalModelDraw.g:5162:2: rule__Level__Group_7_2_1_4__0__Impl rule__Level__Group_7_2_1_4__1
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
    // InternalModelDraw.g:5169:1: rule__Level__Group_7_2_1_4__0__Impl : ( ',' ) ;
    public final void rule__Level__Group_7_2_1_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5173:1: ( ( ',' ) )
            // InternalModelDraw.g:5174:1: ( ',' )
            {
            // InternalModelDraw.g:5174:1: ( ',' )
            // InternalModelDraw.g:5175:2: ','
            {
             before(grammarAccess.getLevelAccess().getCommaKeyword_7_2_1_4_0()); 
            match(input,32,FOLLOW_2); 
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
    // InternalModelDraw.g:5184:1: rule__Level__Group_7_2_1_4__1 : rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2 ;
    public final void rule__Level__Group_7_2_1_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5188:1: ( rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2 )
            // InternalModelDraw.g:5189:2: rule__Level__Group_7_2_1_4__1__Impl rule__Level__Group_7_2_1_4__2
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
    // InternalModelDraw.g:5196:1: rule__Level__Group_7_2_1_4__1__Impl : ( ( rule__Level__Group_7_2_1_4_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5200:1: ( ( ( rule__Level__Group_7_2_1_4_1__0 )? ) )
            // InternalModelDraw.g:5201:1: ( ( rule__Level__Group_7_2_1_4_1__0 )? )
            {
            // InternalModelDraw.g:5201:1: ( ( rule__Level__Group_7_2_1_4_1__0 )? )
            // InternalModelDraw.g:5202:2: ( rule__Level__Group_7_2_1_4_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1()); 
            // InternalModelDraw.g:5203:2: ( rule__Level__Group_7_2_1_4_1__0 )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==RULE_ID) ) {
                int LA54_1 = input.LA(2);

                if ( ((LA54_1>=40 && LA54_1<=41)) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalModelDraw.g:5203:3: rule__Level__Group_7_2_1_4_1__0
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
    // InternalModelDraw.g:5211:1: rule__Level__Group_7_2_1_4__2 : rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3 ;
    public final void rule__Level__Group_7_2_1_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5215:1: ( rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3 )
            // InternalModelDraw.g:5216:2: rule__Level__Group_7_2_1_4__2__Impl rule__Level__Group_7_2_1_4__3
            {
            pushFollow(FOLLOW_21);
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
    // InternalModelDraw.g:5223:1: rule__Level__Group_7_2_1_4__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) ) ;
    public final void rule__Level__Group_7_2_1_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5227:1: ( ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) ) )
            // InternalModelDraw.g:5228:1: ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) )
            {
            // InternalModelDraw.g:5228:1: ( ( rule__Level__LabelAssignment_7_2_1_4_2 ) )
            // InternalModelDraw.g:5229:2: ( rule__Level__LabelAssignment_7_2_1_4_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_2()); 
            // InternalModelDraw.g:5230:2: ( rule__Level__LabelAssignment_7_2_1_4_2 )
            // InternalModelDraw.g:5230:3: rule__Level__LabelAssignment_7_2_1_4_2
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
    // InternalModelDraw.g:5238:1: rule__Level__Group_7_2_1_4__3 : rule__Level__Group_7_2_1_4__3__Impl ;
    public final void rule__Level__Group_7_2_1_4__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5242:1: ( rule__Level__Group_7_2_1_4__3__Impl )
            // InternalModelDraw.g:5243:2: rule__Level__Group_7_2_1_4__3__Impl
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
    // InternalModelDraw.g:5249:1: rule__Level__Group_7_2_1_4__3__Impl : ( ( rule__Level__Group_7_2_1_4_3__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5253:1: ( ( ( rule__Level__Group_7_2_1_4_3__0 )? ) )
            // InternalModelDraw.g:5254:1: ( ( rule__Level__Group_7_2_1_4_3__0 )? )
            {
            // InternalModelDraw.g:5254:1: ( ( rule__Level__Group_7_2_1_4_3__0 )? )
            // InternalModelDraw.g:5255:2: ( rule__Level__Group_7_2_1_4_3__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3()); 
            // InternalModelDraw.g:5256:2: ( rule__Level__Group_7_2_1_4_3__0 )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==30) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalModelDraw.g:5256:3: rule__Level__Group_7_2_1_4_3__0
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
    // InternalModelDraw.g:5265:1: rule__Level__Group_7_2_1_4_1__0 : rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1 ;
    public final void rule__Level__Group_7_2_1_4_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5269:1: ( rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1 )
            // InternalModelDraw.g:5270:2: rule__Level__Group_7_2_1_4_1__0__Impl rule__Level__Group_7_2_1_4_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:5277:1: rule__Level__Group_7_2_1_4_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_4_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5281:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) ) )
            // InternalModelDraw.g:5282:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) )
            {
            // InternalModelDraw.g:5282:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 ) )
            // InternalModelDraw.g:5283:2: ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_1_0()); 
            // InternalModelDraw.g:5284:2: ( rule__Level__ReferenceAssignment_7_2_1_4_1_0 )
            // InternalModelDraw.g:5284:3: rule__Level__ReferenceAssignment_7_2_1_4_1_0
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
    // InternalModelDraw.g:5292:1: rule__Level__Group_7_2_1_4_1__1 : rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2 ;
    public final void rule__Level__Group_7_2_1_4_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5296:1: ( rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2 )
            // InternalModelDraw.g:5297:2: rule__Level__Group_7_2_1_4_1__1__Impl rule__Level__Group_7_2_1_4_1__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:5304:1: rule__Level__Group_7_2_1_4_1__1__Impl : ( ( rule__Level__Group_7_2_1_4_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5308:1: ( ( ( rule__Level__Group_7_2_1_4_1_1__0 )? ) )
            // InternalModelDraw.g:5309:1: ( ( rule__Level__Group_7_2_1_4_1_1__0 )? )
            {
            // InternalModelDraw.g:5309:1: ( ( rule__Level__Group_7_2_1_4_1_1__0 )? )
            // InternalModelDraw.g:5310:2: ( rule__Level__Group_7_2_1_4_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_1_1()); 
            // InternalModelDraw.g:5311:2: ( rule__Level__Group_7_2_1_4_1_1__0 )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==41) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalModelDraw.g:5311:3: rule__Level__Group_7_2_1_4_1_1__0
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
    // InternalModelDraw.g:5319:1: rule__Level__Group_7_2_1_4_1__2 : rule__Level__Group_7_2_1_4_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_4_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5323:1: ( rule__Level__Group_7_2_1_4_1__2__Impl )
            // InternalModelDraw.g:5324:2: rule__Level__Group_7_2_1_4_1__2__Impl
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
    // InternalModelDraw.g:5330:1: rule__Level__Group_7_2_1_4_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_4_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5334:1: ( ( '.' ) )
            // InternalModelDraw.g:5335:1: ( '.' )
            {
            // InternalModelDraw.g:5335:1: ( '.' )
            // InternalModelDraw.g:5336:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_1_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalModelDraw.g:5346:1: rule__Level__Group_7_2_1_4_1_1__0 : rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1 ;
    public final void rule__Level__Group_7_2_1_4_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5350:1: ( rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1 )
            // InternalModelDraw.g:5351:2: rule__Level__Group_7_2_1_4_1_1__0__Impl rule__Level__Group_7_2_1_4_1_1__1
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
    // InternalModelDraw.g:5358:1: rule__Level__Group_7_2_1_4_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_4_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5362:1: ( ( '->' ) )
            // InternalModelDraw.g:5363:1: ( '->' )
            {
            // InternalModelDraw.g:5363:1: ( '->' )
            // InternalModelDraw.g:5364:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_1_1_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalModelDraw.g:5373:1: rule__Level__Group_7_2_1_4_1_1__1 : rule__Level__Group_7_2_1_4_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_4_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5377:1: ( rule__Level__Group_7_2_1_4_1_1__1__Impl )
            // InternalModelDraw.g:5378:2: rule__Level__Group_7_2_1_4_1_1__1__Impl
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
    // InternalModelDraw.g:5384:1: rule__Level__Group_7_2_1_4_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_4_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5388:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) ) )
            // InternalModelDraw.g:5389:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            {
            // InternalModelDraw.g:5389:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 ) )
            // InternalModelDraw.g:5390:2: ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_1_1_1()); 
            // InternalModelDraw.g:5391:2: ( rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 )
            // InternalModelDraw.g:5391:3: rule__Level__RefTypeAssignment_7_2_1_4_1_1_1
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
    // InternalModelDraw.g:5400:1: rule__Level__Group_7_2_1_4_3__0 : rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1 ;
    public final void rule__Level__Group_7_2_1_4_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5404:1: ( rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1 )
            // InternalModelDraw.g:5405:2: rule__Level__Group_7_2_1_4_3__0__Impl rule__Level__Group_7_2_1_4_3__1
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
    // InternalModelDraw.g:5412:1: rule__Level__Group_7_2_1_4_3__0__Impl : ( '(' ) ;
    public final void rule__Level__Group_7_2_1_4_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5416:1: ( ( '(' ) )
            // InternalModelDraw.g:5417:1: ( '(' )
            {
            // InternalModelDraw.g:5417:1: ( '(' )
            // InternalModelDraw.g:5418:2: '('
            {
             before(grammarAccess.getLevelAccess().getLeftParenthesisKeyword_7_2_1_4_3_0()); 
            match(input,30,FOLLOW_2); 
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
    // InternalModelDraw.g:5427:1: rule__Level__Group_7_2_1_4_3__1 : rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2 ;
    public final void rule__Level__Group_7_2_1_4_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5431:1: ( rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2 )
            // InternalModelDraw.g:5432:2: rule__Level__Group_7_2_1_4_3__1__Impl rule__Level__Group_7_2_1_4_3__2
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
    // InternalModelDraw.g:5439:1: rule__Level__Group_7_2_1_4_3__1__Impl : ( ( rule__Level__Group_7_2_1_4_3_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5443:1: ( ( ( rule__Level__Group_7_2_1_4_3_1__0 )? ) )
            // InternalModelDraw.g:5444:1: ( ( rule__Level__Group_7_2_1_4_3_1__0 )? )
            {
            // InternalModelDraw.g:5444:1: ( ( rule__Level__Group_7_2_1_4_3_1__0 )? )
            // InternalModelDraw.g:5445:2: ( rule__Level__Group_7_2_1_4_3_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1()); 
            // InternalModelDraw.g:5446:2: ( rule__Level__Group_7_2_1_4_3_1__0 )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==RULE_ID) ) {
                int LA57_1 = input.LA(2);

                if ( ((LA57_1>=40 && LA57_1<=41)) ) {
                    alt57=1;
                }
            }
            switch (alt57) {
                case 1 :
                    // InternalModelDraw.g:5446:3: rule__Level__Group_7_2_1_4_3_1__0
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
    // InternalModelDraw.g:5454:1: rule__Level__Group_7_2_1_4_3__2 : rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3 ;
    public final void rule__Level__Group_7_2_1_4_3__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5458:1: ( rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3 )
            // InternalModelDraw.g:5459:2: rule__Level__Group_7_2_1_4_3__2__Impl rule__Level__Group_7_2_1_4_3__3
            {
            pushFollow(FOLLOW_23);
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
    // InternalModelDraw.g:5466:1: rule__Level__Group_7_2_1_4_3__2__Impl : ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5470:1: ( ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) ) )
            // InternalModelDraw.g:5471:1: ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) )
            {
            // InternalModelDraw.g:5471:1: ( ( rule__Level__LabelAssignment_7_2_1_4_3_2 ) )
            // InternalModelDraw.g:5472:2: ( rule__Level__LabelAssignment_7_2_1_4_3_2 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_2_1_4_3_2()); 
            // InternalModelDraw.g:5473:2: ( rule__Level__LabelAssignment_7_2_1_4_3_2 )
            // InternalModelDraw.g:5473:3: rule__Level__LabelAssignment_7_2_1_4_3_2
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
    // InternalModelDraw.g:5481:1: rule__Level__Group_7_2_1_4_3__3 : rule__Level__Group_7_2_1_4_3__3__Impl ;
    public final void rule__Level__Group_7_2_1_4_3__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5485:1: ( rule__Level__Group_7_2_1_4_3__3__Impl )
            // InternalModelDraw.g:5486:2: rule__Level__Group_7_2_1_4_3__3__Impl
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
    // InternalModelDraw.g:5492:1: rule__Level__Group_7_2_1_4_3__3__Impl : ( ')' ) ;
    public final void rule__Level__Group_7_2_1_4_3__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5496:1: ( ( ')' ) )
            // InternalModelDraw.g:5497:1: ( ')' )
            {
            // InternalModelDraw.g:5497:1: ( ')' )
            // InternalModelDraw.g:5498:2: ')'
            {
             before(grammarAccess.getLevelAccess().getRightParenthesisKeyword_7_2_1_4_3_3()); 
            match(input,31,FOLLOW_2); 
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
    // InternalModelDraw.g:5508:1: rule__Level__Group_7_2_1_4_3_1__0 : rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1 ;
    public final void rule__Level__Group_7_2_1_4_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5512:1: ( rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1 )
            // InternalModelDraw.g:5513:2: rule__Level__Group_7_2_1_4_3_1__0__Impl rule__Level__Group_7_2_1_4_3_1__1
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:5520:1: rule__Level__Group_7_2_1_4_3_1__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5524:1: ( ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) ) )
            // InternalModelDraw.g:5525:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            {
            // InternalModelDraw.g:5525:1: ( ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 ) )
            // InternalModelDraw.g:5526:2: ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_1_4_3_1_0()); 
            // InternalModelDraw.g:5527:2: ( rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 )
            // InternalModelDraw.g:5527:3: rule__Level__ReferenceAssignment_7_2_1_4_3_1_0
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
    // InternalModelDraw.g:5535:1: rule__Level__Group_7_2_1_4_3_1__1 : rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2 ;
    public final void rule__Level__Group_7_2_1_4_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5539:1: ( rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2 )
            // InternalModelDraw.g:5540:2: rule__Level__Group_7_2_1_4_3_1__1__Impl rule__Level__Group_7_2_1_4_3_1__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:5547:1: rule__Level__Group_7_2_1_4_3_1__1__Impl : ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5551:1: ( ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? ) )
            // InternalModelDraw.g:5552:1: ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? )
            {
            // InternalModelDraw.g:5552:1: ( ( rule__Level__Group_7_2_1_4_3_1_1__0 )? )
            // InternalModelDraw.g:5553:2: ( rule__Level__Group_7_2_1_4_3_1_1__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2_1_4_3_1_1()); 
            // InternalModelDraw.g:5554:2: ( rule__Level__Group_7_2_1_4_3_1_1__0 )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==41) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalModelDraw.g:5554:3: rule__Level__Group_7_2_1_4_3_1_1__0
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
    // InternalModelDraw.g:5562:1: rule__Level__Group_7_2_1_4_3_1__2 : rule__Level__Group_7_2_1_4_3_1__2__Impl ;
    public final void rule__Level__Group_7_2_1_4_3_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5566:1: ( rule__Level__Group_7_2_1_4_3_1__2__Impl )
            // InternalModelDraw.g:5567:2: rule__Level__Group_7_2_1_4_3_1__2__Impl
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
    // InternalModelDraw.g:5573:1: rule__Level__Group_7_2_1_4_3_1__2__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2_1_4_3_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5577:1: ( ( '.' ) )
            // InternalModelDraw.g:5578:1: ( '.' )
            {
            // InternalModelDraw.g:5578:1: ( '.' )
            // InternalModelDraw.g:5579:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1_4_3_1_2()); 
            match(input,40,FOLLOW_2); 
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
    // InternalModelDraw.g:5589:1: rule__Level__Group_7_2_1_4_3_1_1__0 : rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1 ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5593:1: ( rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1 )
            // InternalModelDraw.g:5594:2: rule__Level__Group_7_2_1_4_3_1_1__0__Impl rule__Level__Group_7_2_1_4_3_1_1__1
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
    // InternalModelDraw.g:5601:1: rule__Level__Group_7_2_1_4_3_1_1__0__Impl : ( '->' ) ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5605:1: ( ( '->' ) )
            // InternalModelDraw.g:5606:1: ( '->' )
            {
            // InternalModelDraw.g:5606:1: ( '->' )
            // InternalModelDraw.g:5607:2: '->'
            {
             before(grammarAccess.getLevelAccess().getHyphenMinusGreaterThanSignKeyword_7_2_1_4_3_1_1_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalModelDraw.g:5616:1: rule__Level__Group_7_2_1_4_3_1_1__1 : rule__Level__Group_7_2_1_4_3_1_1__1__Impl ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5620:1: ( rule__Level__Group_7_2_1_4_3_1_1__1__Impl )
            // InternalModelDraw.g:5621:2: rule__Level__Group_7_2_1_4_3_1_1__1__Impl
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
    // InternalModelDraw.g:5627:1: rule__Level__Group_7_2_1_4_3_1_1__1__Impl : ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) ;
    public final void rule__Level__Group_7_2_1_4_3_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5631:1: ( ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) ) )
            // InternalModelDraw.g:5632:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            {
            // InternalModelDraw.g:5632:1: ( ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 ) )
            // InternalModelDraw.g:5633:2: ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            {
             before(grammarAccess.getLevelAccess().getRefTypeAssignment_7_2_1_4_3_1_1_1()); 
            // InternalModelDraw.g:5634:2: ( rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 )
            // InternalModelDraw.g:5634:3: rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1
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
    // InternalModelDraw.g:5643:1: rule__Level__Group_8__0 : rule__Level__Group_8__0__Impl rule__Level__Group_8__1 ;
    public final void rule__Level__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5647:1: ( rule__Level__Group_8__0__Impl rule__Level__Group_8__1 )
            // InternalModelDraw.g:5648:2: rule__Level__Group_8__0__Impl rule__Level__Group_8__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:5655:1: rule__Level__Group_8__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Level__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5659:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:5660:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:5660:1: ( 'src_decoration' )
            // InternalModelDraw.g:5661:2: 'src_decoration'
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalModelDraw.g:5670:1: rule__Level__Group_8__1 : rule__Level__Group_8__1__Impl rule__Level__Group_8__2 ;
    public final void rule__Level__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5674:1: ( rule__Level__Group_8__1__Impl rule__Level__Group_8__2 )
            // InternalModelDraw.g:5675:2: rule__Level__Group_8__1__Impl rule__Level__Group_8__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:5682:1: rule__Level__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5686:1: ( ( '=' ) )
            // InternalModelDraw.g:5687:1: ( '=' )
            {
            // InternalModelDraw.g:5687:1: ( '=' )
            // InternalModelDraw.g:5688:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_8_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:5697:1: rule__Level__Group_8__2 : rule__Level__Group_8__2__Impl ;
    public final void rule__Level__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5701:1: ( rule__Level__Group_8__2__Impl )
            // InternalModelDraw.g:5702:2: rule__Level__Group_8__2__Impl
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
    // InternalModelDraw.g:5708:1: rule__Level__Group_8__2__Impl : ( ( rule__Level__Src_decorationAssignment_8_2 ) ) ;
    public final void rule__Level__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5712:1: ( ( ( rule__Level__Src_decorationAssignment_8_2 ) ) )
            // InternalModelDraw.g:5713:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            {
            // InternalModelDraw.g:5713:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            // InternalModelDraw.g:5714:2: ( rule__Level__Src_decorationAssignment_8_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationAssignment_8_2()); 
            // InternalModelDraw.g:5715:2: ( rule__Level__Src_decorationAssignment_8_2 )
            // InternalModelDraw.g:5715:3: rule__Level__Src_decorationAssignment_8_2
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
    // InternalModelDraw.g:5724:1: rule__Level__Group_9__0 : rule__Level__Group_9__0__Impl rule__Level__Group_9__1 ;
    public final void rule__Level__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5728:1: ( rule__Level__Group_9__0__Impl rule__Level__Group_9__1 )
            // InternalModelDraw.g:5729:2: rule__Level__Group_9__0__Impl rule__Level__Group_9__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:5736:1: rule__Level__Group_9__0__Impl : ( 'src_label' ) ;
    public final void rule__Level__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5740:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:5741:1: ( 'src_label' )
            {
            // InternalModelDraw.g:5741:1: ( 'src_label' )
            // InternalModelDraw.g:5742:2: 'src_label'
            {
             before(grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalModelDraw.g:5751:1: rule__Level__Group_9__1 : rule__Level__Group_9__1__Impl rule__Level__Group_9__2 ;
    public final void rule__Level__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5755:1: ( rule__Level__Group_9__1__Impl rule__Level__Group_9__2 )
            // InternalModelDraw.g:5756:2: rule__Level__Group_9__1__Impl rule__Level__Group_9__2
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
    // InternalModelDraw.g:5763:1: rule__Level__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5767:1: ( ( '=' ) )
            // InternalModelDraw.g:5768:1: ( '=' )
            {
            // InternalModelDraw.g:5768:1: ( '=' )
            // InternalModelDraw.g:5769:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_9_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:5778:1: rule__Level__Group_9__2 : rule__Level__Group_9__2__Impl ;
    public final void rule__Level__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5782:1: ( rule__Level__Group_9__2__Impl )
            // InternalModelDraw.g:5783:2: rule__Level__Group_9__2__Impl
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
    // InternalModelDraw.g:5789:1: rule__Level__Group_9__2__Impl : ( ( rule__Level__Src_labelAssignment_9_2 ) ) ;
    public final void rule__Level__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5793:1: ( ( ( rule__Level__Src_labelAssignment_9_2 ) ) )
            // InternalModelDraw.g:5794:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            {
            // InternalModelDraw.g:5794:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            // InternalModelDraw.g:5795:2: ( rule__Level__Src_labelAssignment_9_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelAssignment_9_2()); 
            // InternalModelDraw.g:5796:2: ( rule__Level__Src_labelAssignment_9_2 )
            // InternalModelDraw.g:5796:3: rule__Level__Src_labelAssignment_9_2
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
    // InternalModelDraw.g:5805:1: rule__Level__Group_10__0 : rule__Level__Group_10__0__Impl rule__Level__Group_10__1 ;
    public final void rule__Level__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5809:1: ( rule__Level__Group_10__0__Impl rule__Level__Group_10__1 )
            // InternalModelDraw.g:5810:2: rule__Level__Group_10__0__Impl rule__Level__Group_10__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:5817:1: rule__Level__Group_10__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Level__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5821:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:5822:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:5822:1: ( 'tar_decoration' )
            // InternalModelDraw.g:5823:2: 'tar_decoration'
            {
             before(grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalModelDraw.g:5832:1: rule__Level__Group_10__1 : rule__Level__Group_10__1__Impl rule__Level__Group_10__2 ;
    public final void rule__Level__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5836:1: ( rule__Level__Group_10__1__Impl rule__Level__Group_10__2 )
            // InternalModelDraw.g:5837:2: rule__Level__Group_10__1__Impl rule__Level__Group_10__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:5844:1: rule__Level__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5848:1: ( ( '=' ) )
            // InternalModelDraw.g:5849:1: ( '=' )
            {
            // InternalModelDraw.g:5849:1: ( '=' )
            // InternalModelDraw.g:5850:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_10_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:5859:1: rule__Level__Group_10__2 : rule__Level__Group_10__2__Impl ;
    public final void rule__Level__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5863:1: ( rule__Level__Group_10__2__Impl )
            // InternalModelDraw.g:5864:2: rule__Level__Group_10__2__Impl
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
    // InternalModelDraw.g:5870:1: rule__Level__Group_10__2__Impl : ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) ;
    public final void rule__Level__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5874:1: ( ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) )
            // InternalModelDraw.g:5875:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            {
            // InternalModelDraw.g:5875:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            // InternalModelDraw.g:5876:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_decorationAssignment_10_2()); 
            // InternalModelDraw.g:5877:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            // InternalModelDraw.g:5877:3: rule__Level__Tar_decorationAssignment_10_2
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
    // InternalModelDraw.g:5886:1: rule__Level__Group_11__0 : rule__Level__Group_11__0__Impl rule__Level__Group_11__1 ;
    public final void rule__Level__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5890:1: ( rule__Level__Group_11__0__Impl rule__Level__Group_11__1 )
            // InternalModelDraw.g:5891:2: rule__Level__Group_11__0__Impl rule__Level__Group_11__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:5898:1: rule__Level__Group_11__0__Impl : ( 'tar_label' ) ;
    public final void rule__Level__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5902:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:5903:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:5903:1: ( 'tar_label' )
            // InternalModelDraw.g:5904:2: 'tar_label'
            {
             before(grammarAccess.getLevelAccess().getTar_labelKeyword_11_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalModelDraw.g:5913:1: rule__Level__Group_11__1 : rule__Level__Group_11__1__Impl rule__Level__Group_11__2 ;
    public final void rule__Level__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5917:1: ( rule__Level__Group_11__1__Impl rule__Level__Group_11__2 )
            // InternalModelDraw.g:5918:2: rule__Level__Group_11__1__Impl rule__Level__Group_11__2
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
    // InternalModelDraw.g:5925:1: rule__Level__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5929:1: ( ( '=' ) )
            // InternalModelDraw.g:5930:1: ( '=' )
            {
            // InternalModelDraw.g:5930:1: ( '=' )
            // InternalModelDraw.g:5931:2: '='
            {
             before(grammarAccess.getLevelAccess().getEqualsSignKeyword_11_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:5940:1: rule__Level__Group_11__2 : rule__Level__Group_11__2__Impl ;
    public final void rule__Level__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5944:1: ( rule__Level__Group_11__2__Impl )
            // InternalModelDraw.g:5945:2: rule__Level__Group_11__2__Impl
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
    // InternalModelDraw.g:5951:1: rule__Level__Group_11__2__Impl : ( ( rule__Level__Tar_labelAssignment_11_2 ) ) ;
    public final void rule__Level__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5955:1: ( ( ( rule__Level__Tar_labelAssignment_11_2 ) ) )
            // InternalModelDraw.g:5956:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            {
            // InternalModelDraw.g:5956:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            // InternalModelDraw.g:5957:2: ( rule__Level__Tar_labelAssignment_11_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_labelAssignment_11_2()); 
            // InternalModelDraw.g:5958:2: ( rule__Level__Tar_labelAssignment_11_2 )
            // InternalModelDraw.g:5958:3: rule__Level__Tar_labelAssignment_11_2
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
    // InternalModelDraw.g:5967:1: rule__Content__Group__0 : rule__Content__Group__0__Impl rule__Content__Group__1 ;
    public final void rule__Content__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5971:1: ( rule__Content__Group__0__Impl rule__Content__Group__1 )
            // InternalModelDraw.g:5972:2: rule__Content__Group__0__Impl rule__Content__Group__1
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
    // InternalModelDraw.g:5979:1: rule__Content__Group__0__Impl : ( () ) ;
    public final void rule__Content__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5983:1: ( ( () ) )
            // InternalModelDraw.g:5984:1: ( () )
            {
            // InternalModelDraw.g:5984:1: ( () )
            // InternalModelDraw.g:5985:2: ()
            {
             before(grammarAccess.getContentAccess().getContentAction_0()); 
            // InternalModelDraw.g:5986:2: ()
            // InternalModelDraw.g:5986:3: 
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
    // InternalModelDraw.g:5994:1: rule__Content__Group__1 : rule__Content__Group__1__Impl rule__Content__Group__2 ;
    public final void rule__Content__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5998:1: ( rule__Content__Group__1__Impl rule__Content__Group__2 )
            // InternalModelDraw.g:5999:2: rule__Content__Group__1__Impl rule__Content__Group__2
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
    // InternalModelDraw.g:6006:1: rule__Content__Group__1__Impl : ( ( rule__Content__NameAssignment_1 ) ) ;
    public final void rule__Content__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6010:1: ( ( ( rule__Content__NameAssignment_1 ) ) )
            // InternalModelDraw.g:6011:1: ( ( rule__Content__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:6011:1: ( ( rule__Content__NameAssignment_1 ) )
            // InternalModelDraw.g:6012:2: ( rule__Content__NameAssignment_1 )
            {
             before(grammarAccess.getContentAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:6013:2: ( rule__Content__NameAssignment_1 )
            // InternalModelDraw.g:6013:3: rule__Content__NameAssignment_1
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
    // InternalModelDraw.g:6021:1: rule__Content__Group__2 : rule__Content__Group__2__Impl rule__Content__Group__3 ;
    public final void rule__Content__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6025:1: ( rule__Content__Group__2__Impl rule__Content__Group__3 )
            // InternalModelDraw.g:6026:2: rule__Content__Group__2__Impl rule__Content__Group__3
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:6033:1: rule__Content__Group__2__Impl : ( ':' ) ;
    public final void rule__Content__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6037:1: ( ( ':' ) )
            // InternalModelDraw.g:6038:1: ( ':' )
            {
            // InternalModelDraw.g:6038:1: ( ':' )
            // InternalModelDraw.g:6039:2: ':'
            {
             before(grammarAccess.getContentAccess().getColonKeyword_2()); 
            match(input,27,FOLLOW_2); 
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
    // InternalModelDraw.g:6048:1: rule__Content__Group__3 : rule__Content__Group__3__Impl rule__Content__Group__4 ;
    public final void rule__Content__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6052:1: ( rule__Content__Group__3__Impl rule__Content__Group__4 )
            // InternalModelDraw.g:6053:2: rule__Content__Group__3__Impl rule__Content__Group__4
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:6060:1: rule__Content__Group__3__Impl : ( ( rule__Content__Group_3__0 )? ) ;
    public final void rule__Content__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6064:1: ( ( ( rule__Content__Group_3__0 )? ) )
            // InternalModelDraw.g:6065:1: ( ( rule__Content__Group_3__0 )? )
            {
            // InternalModelDraw.g:6065:1: ( ( rule__Content__Group_3__0 )? )
            // InternalModelDraw.g:6066:2: ( rule__Content__Group_3__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_3()); 
            // InternalModelDraw.g:6067:2: ( rule__Content__Group_3__0 )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                int LA59_1 = input.LA(2);

                if ( (LA59_1==47) ) {
                    alt59=1;
                }
            }
            switch (alt59) {
                case 1 :
                    // InternalModelDraw.g:6067:3: rule__Content__Group_3__0
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
    // InternalModelDraw.g:6075:1: rule__Content__Group__4 : rule__Content__Group__4__Impl rule__Content__Group__5 ;
    public final void rule__Content__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6079:1: ( rule__Content__Group__4__Impl rule__Content__Group__5 )
            // InternalModelDraw.g:6080:2: rule__Content__Group__4__Impl rule__Content__Group__5
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:6087:1: rule__Content__Group__4__Impl : ( ( rule__Content__Group_4__0 )? ) ;
    public final void rule__Content__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6091:1: ( ( ( rule__Content__Group_4__0 )? ) )
            // InternalModelDraw.g:6092:1: ( ( rule__Content__Group_4__0 )? )
            {
            // InternalModelDraw.g:6092:1: ( ( rule__Content__Group_4__0 )? )
            // InternalModelDraw.g:6093:2: ( rule__Content__Group_4__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_4()); 
            // InternalModelDraw.g:6094:2: ( rule__Content__Group_4__0 )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_ID) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==EOF||LA60_1==RULE_ID||(LA60_1>=28 && LA60_1<=29)||LA60_1==40||LA60_1==46) ) {
                    alt60=1;
                }
            }
            switch (alt60) {
                case 1 :
                    // InternalModelDraw.g:6094:3: rule__Content__Group_4__0
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
    // InternalModelDraw.g:6102:1: rule__Content__Group__5 : rule__Content__Group__5__Impl rule__Content__Group__6 ;
    public final void rule__Content__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6106:1: ( rule__Content__Group__5__Impl rule__Content__Group__6 )
            // InternalModelDraw.g:6107:2: rule__Content__Group__5__Impl rule__Content__Group__6
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:6114:1: rule__Content__Group__5__Impl : ( ( rule__Content__Group_5__0 )? ) ;
    public final void rule__Content__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6118:1: ( ( ( rule__Content__Group_5__0 )? ) )
            // InternalModelDraw.g:6119:1: ( ( rule__Content__Group_5__0 )? )
            {
            // InternalModelDraw.g:6119:1: ( ( rule__Content__Group_5__0 )? )
            // InternalModelDraw.g:6120:2: ( rule__Content__Group_5__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_5()); 
            // InternalModelDraw.g:6121:2: ( rule__Content__Group_5__0 )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==28) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalModelDraw.g:6121:3: rule__Content__Group_5__0
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
    // InternalModelDraw.g:6129:1: rule__Content__Group__6 : rule__Content__Group__6__Impl ;
    public final void rule__Content__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6133:1: ( rule__Content__Group__6__Impl )
            // InternalModelDraw.g:6134:2: rule__Content__Group__6__Impl
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
    // InternalModelDraw.g:6140:1: rule__Content__Group__6__Impl : ( ( rule__Content__Group_6__0 )? ) ;
    public final void rule__Content__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6144:1: ( ( ( rule__Content__Group_6__0 )? ) )
            // InternalModelDraw.g:6145:1: ( ( rule__Content__Group_6__0 )? )
            {
            // InternalModelDraw.g:6145:1: ( ( rule__Content__Group_6__0 )? )
            // InternalModelDraw.g:6146:2: ( rule__Content__Group_6__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_6()); 
            // InternalModelDraw.g:6147:2: ( rule__Content__Group_6__0 )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==46) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalModelDraw.g:6147:3: rule__Content__Group_6__0
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
    // InternalModelDraw.g:6156:1: rule__Content__Group_3__0 : rule__Content__Group_3__0__Impl rule__Content__Group_3__1 ;
    public final void rule__Content__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6160:1: ( rule__Content__Group_3__0__Impl rule__Content__Group_3__1 )
            // InternalModelDraw.g:6161:2: rule__Content__Group_3__0__Impl rule__Content__Group_3__1
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
    // InternalModelDraw.g:6168:1: rule__Content__Group_3__0__Impl : ( ( rule__Content__NodenumAssignment_3_0 ) ) ;
    public final void rule__Content__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6172:1: ( ( ( rule__Content__NodenumAssignment_3_0 ) ) )
            // InternalModelDraw.g:6173:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            {
            // InternalModelDraw.g:6173:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            // InternalModelDraw.g:6174:2: ( rule__Content__NodenumAssignment_3_0 )
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_0()); 
            // InternalModelDraw.g:6175:2: ( rule__Content__NodenumAssignment_3_0 )
            // InternalModelDraw.g:6175:3: rule__Content__NodenumAssignment_3_0
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
    // InternalModelDraw.g:6183:1: rule__Content__Group_3__1 : rule__Content__Group_3__1__Impl ;
    public final void rule__Content__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6187:1: ( rule__Content__Group_3__1__Impl )
            // InternalModelDraw.g:6188:2: rule__Content__Group_3__1__Impl
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
    // InternalModelDraw.g:6194:1: rule__Content__Group_3__1__Impl : ( ( rule__Content__NodenumAssignment_3_1 )* ) ;
    public final void rule__Content__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6198:1: ( ( ( rule__Content__NodenumAssignment_3_1 )* ) )
            // InternalModelDraw.g:6199:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            {
            // InternalModelDraw.g:6199:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            // InternalModelDraw.g:6200:2: ( rule__Content__NodenumAssignment_3_1 )*
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_1()); 
            // InternalModelDraw.g:6201:2: ( rule__Content__NodenumAssignment_3_1 )*
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==RULE_ID) ) {
                    int LA63_1 = input.LA(2);

                    if ( (LA63_1==47) ) {
                        alt63=1;
                    }


                }


                switch (alt63) {
            	case 1 :
            	    // InternalModelDraw.g:6201:3: rule__Content__NodenumAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Content__NodenumAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop63;
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
    // InternalModelDraw.g:6210:1: rule__Content__Group_4__0 : rule__Content__Group_4__0__Impl rule__Content__Group_4__1 ;
    public final void rule__Content__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6214:1: ( rule__Content__Group_4__0__Impl rule__Content__Group_4__1 )
            // InternalModelDraw.g:6215:2: rule__Content__Group_4__0__Impl rule__Content__Group_4__1
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
    // InternalModelDraw.g:6222:1: rule__Content__Group_4__0__Impl : ( ( rule__Content__InfoAssignment_4_0 ) ) ;
    public final void rule__Content__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6226:1: ( ( ( rule__Content__InfoAssignment_4_0 ) ) )
            // InternalModelDraw.g:6227:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            {
            // InternalModelDraw.g:6227:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            // InternalModelDraw.g:6228:2: ( rule__Content__InfoAssignment_4_0 )
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_0()); 
            // InternalModelDraw.g:6229:2: ( rule__Content__InfoAssignment_4_0 )
            // InternalModelDraw.g:6229:3: rule__Content__InfoAssignment_4_0
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
    // InternalModelDraw.g:6237:1: rule__Content__Group_4__1 : rule__Content__Group_4__1__Impl ;
    public final void rule__Content__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6241:1: ( rule__Content__Group_4__1__Impl )
            // InternalModelDraw.g:6242:2: rule__Content__Group_4__1__Impl
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
    // InternalModelDraw.g:6248:1: rule__Content__Group_4__1__Impl : ( ( rule__Content__InfoAssignment_4_1 )* ) ;
    public final void rule__Content__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6252:1: ( ( ( rule__Content__InfoAssignment_4_1 )* ) )
            // InternalModelDraw.g:6253:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            {
            // InternalModelDraw.g:6253:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            // InternalModelDraw.g:6254:2: ( rule__Content__InfoAssignment_4_1 )*
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_1()); 
            // InternalModelDraw.g:6255:2: ( rule__Content__InfoAssignment_4_1 )*
            loop64:
            do {
                int alt64=2;
                int LA64_0 = input.LA(1);

                if ( (LA64_0==RULE_ID) ) {
                    int LA64_2 = input.LA(2);

                    if ( (LA64_2==EOF||LA64_2==RULE_ID||(LA64_2>=28 && LA64_2<=29)||LA64_2==40||LA64_2==46) ) {
                        alt64=1;
                    }


                }


                switch (alt64) {
            	case 1 :
            	    // InternalModelDraw.g:6255:3: rule__Content__InfoAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Content__InfoAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop64;
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
    // InternalModelDraw.g:6264:1: rule__Content__Group_5__0 : rule__Content__Group_5__0__Impl rule__Content__Group_5__1 ;
    public final void rule__Content__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6268:1: ( rule__Content__Group_5__0__Impl rule__Content__Group_5__1 )
            // InternalModelDraw.g:6269:2: rule__Content__Group_5__0__Impl rule__Content__Group_5__1
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
    // InternalModelDraw.g:6276:1: rule__Content__Group_5__0__Impl : ( '{' ) ;
    public final void rule__Content__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6280:1: ( ( '{' ) )
            // InternalModelDraw.g:6281:1: ( '{' )
            {
            // InternalModelDraw.g:6281:1: ( '{' )
            // InternalModelDraw.g:6282:2: '{'
            {
             before(grammarAccess.getContentAccess().getLeftCurlyBracketKeyword_5_0()); 
            match(input,28,FOLLOW_2); 
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
    // InternalModelDraw.g:6291:1: rule__Content__Group_5__1 : rule__Content__Group_5__1__Impl rule__Content__Group_5__2 ;
    public final void rule__Content__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6295:1: ( rule__Content__Group_5__1__Impl rule__Content__Group_5__2 )
            // InternalModelDraw.g:6296:2: rule__Content__Group_5__1__Impl rule__Content__Group_5__2
            {
            pushFollow(FOLLOW_32);
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
    // InternalModelDraw.g:6303:1: rule__Content__Group_5__1__Impl : ( ( rule__Content__AttNameAssignment_5_1 ) ) ;
    public final void rule__Content__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6307:1: ( ( ( rule__Content__AttNameAssignment_5_1 ) ) )
            // InternalModelDraw.g:6308:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            {
            // InternalModelDraw.g:6308:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            // InternalModelDraw.g:6309:2: ( rule__Content__AttNameAssignment_5_1 )
            {
             before(grammarAccess.getContentAccess().getAttNameAssignment_5_1()); 
            // InternalModelDraw.g:6310:2: ( rule__Content__AttNameAssignment_5_1 )
            // InternalModelDraw.g:6310:3: rule__Content__AttNameAssignment_5_1
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
    // InternalModelDraw.g:6318:1: rule__Content__Group_5__2 : rule__Content__Group_5__2__Impl ;
    public final void rule__Content__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6322:1: ( rule__Content__Group_5__2__Impl )
            // InternalModelDraw.g:6323:2: rule__Content__Group_5__2__Impl
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
    // InternalModelDraw.g:6329:1: rule__Content__Group_5__2__Impl : ( '}' ) ;
    public final void rule__Content__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6333:1: ( ( '}' ) )
            // InternalModelDraw.g:6334:1: ( '}' )
            {
            // InternalModelDraw.g:6334:1: ( '}' )
            // InternalModelDraw.g:6335:2: '}'
            {
             before(grammarAccess.getContentAccess().getRightCurlyBracketKeyword_5_2()); 
            match(input,29,FOLLOW_2); 
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
    // InternalModelDraw.g:6345:1: rule__Content__Group_6__0 : rule__Content__Group_6__0__Impl rule__Content__Group_6__1 ;
    public final void rule__Content__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6349:1: ( rule__Content__Group_6__0__Impl rule__Content__Group_6__1 )
            // InternalModelDraw.g:6350:2: rule__Content__Group_6__0__Impl rule__Content__Group_6__1
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:6357:1: rule__Content__Group_6__0__Impl : ( 'text' ) ;
    public final void rule__Content__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6361:1: ( ( 'text' ) )
            // InternalModelDraw.g:6362:1: ( 'text' )
            {
            // InternalModelDraw.g:6362:1: ( 'text' )
            // InternalModelDraw.g:6363:2: 'text'
            {
             before(grammarAccess.getContentAccess().getTextKeyword_6_0()); 
            match(input,46,FOLLOW_2); 
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
    // InternalModelDraw.g:6372:1: rule__Content__Group_6__1 : rule__Content__Group_6__1__Impl rule__Content__Group_6__2 ;
    public final void rule__Content__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6376:1: ( rule__Content__Group_6__1__Impl rule__Content__Group_6__2 )
            // InternalModelDraw.g:6377:2: rule__Content__Group_6__1__Impl rule__Content__Group_6__2
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
    // InternalModelDraw.g:6384:1: rule__Content__Group_6__1__Impl : ( '=' ) ;
    public final void rule__Content__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6388:1: ( ( '=' ) )
            // InternalModelDraw.g:6389:1: ( '=' )
            {
            // InternalModelDraw.g:6389:1: ( '=' )
            // InternalModelDraw.g:6390:2: '='
            {
             before(grammarAccess.getContentAccess().getEqualsSignKeyword_6_1()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:6399:1: rule__Content__Group_6__2 : rule__Content__Group_6__2__Impl ;
    public final void rule__Content__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6403:1: ( rule__Content__Group_6__2__Impl )
            // InternalModelDraw.g:6404:2: rule__Content__Group_6__2__Impl
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
    // InternalModelDraw.g:6410:1: rule__Content__Group_6__2__Impl : ( ( rule__Content__SymbolAssignment_6_2 ) ) ;
    public final void rule__Content__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6414:1: ( ( ( rule__Content__SymbolAssignment_6_2 ) ) )
            // InternalModelDraw.g:6415:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            {
            // InternalModelDraw.g:6415:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            // InternalModelDraw.g:6416:2: ( rule__Content__SymbolAssignment_6_2 )
            {
             before(grammarAccess.getContentAccess().getSymbolAssignment_6_2()); 
            // InternalModelDraw.g:6417:2: ( rule__Content__SymbolAssignment_6_2 )
            // InternalModelDraw.g:6417:3: rule__Content__SymbolAssignment_6_2
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
    // InternalModelDraw.g:6426:1: rule__NodeEnumerator__Group__0 : rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 ;
    public final void rule__NodeEnumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6430:1: ( rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 )
            // InternalModelDraw.g:6431:2: rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1
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
    // InternalModelDraw.g:6438:1: rule__NodeEnumerator__Group__0__Impl : ( () ) ;
    public final void rule__NodeEnumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6442:1: ( ( () ) )
            // InternalModelDraw.g:6443:1: ( () )
            {
            // InternalModelDraw.g:6443:1: ( () )
            // InternalModelDraw.g:6444:2: ()
            {
             before(grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0()); 
            // InternalModelDraw.g:6445:2: ()
            // InternalModelDraw.g:6445:3: 
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
    // InternalModelDraw.g:6453:1: rule__NodeEnumerator__Group__1 : rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 ;
    public final void rule__NodeEnumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6457:1: ( rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 )
            // InternalModelDraw.g:6458:2: rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2
            {
            pushFollow(FOLLOW_33);
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
    // InternalModelDraw.g:6465:1: rule__NodeEnumerator__Group__1__Impl : ( ( rule__NodeEnumerator__AttAssignment_1 ) ) ;
    public final void rule__NodeEnumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6469:1: ( ( ( rule__NodeEnumerator__AttAssignment_1 ) ) )
            // InternalModelDraw.g:6470:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            {
            // InternalModelDraw.g:6470:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            // InternalModelDraw.g:6471:2: ( rule__NodeEnumerator__AttAssignment_1 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttAssignment_1()); 
            // InternalModelDraw.g:6472:2: ( rule__NodeEnumerator__AttAssignment_1 )
            // InternalModelDraw.g:6472:3: rule__NodeEnumerator__AttAssignment_1
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
    // InternalModelDraw.g:6480:1: rule__NodeEnumerator__Group__2 : rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 ;
    public final void rule__NodeEnumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6484:1: ( rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 )
            // InternalModelDraw.g:6485:2: rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3
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
    // InternalModelDraw.g:6492:1: rule__NodeEnumerator__Group__2__Impl : ( '[' ) ;
    public final void rule__NodeEnumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6496:1: ( ( '[' ) )
            // InternalModelDraw.g:6497:1: ( '[' )
            {
            // InternalModelDraw.g:6497:1: ( '[' )
            // InternalModelDraw.g:6498:2: '['
            {
             before(grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2()); 
            match(input,47,FOLLOW_2); 
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
    // InternalModelDraw.g:6507:1: rule__NodeEnumerator__Group__3 : rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 ;
    public final void rule__NodeEnumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6511:1: ( rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 )
            // InternalModelDraw.g:6512:2: rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4
            {
            pushFollow(FOLLOW_34);
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
    // InternalModelDraw.g:6519:1: rule__NodeEnumerator__Group__3__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) ;
    public final void rule__NodeEnumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6523:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) )
            // InternalModelDraw.g:6524:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            {
            // InternalModelDraw.g:6524:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            // InternalModelDraw.g:6525:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_3()); 
            // InternalModelDraw.g:6526:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            // InternalModelDraw.g:6526:3: rule__NodeEnumerator__EnumeratorAssignment_3
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
    // InternalModelDraw.g:6534:1: rule__NodeEnumerator__Group__4 : rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 ;
    public final void rule__NodeEnumerator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6538:1: ( rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 )
            // InternalModelDraw.g:6539:2: rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5
            {
            pushFollow(FOLLOW_34);
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
    // InternalModelDraw.g:6546:1: rule__NodeEnumerator__Group__4__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) ;
    public final void rule__NodeEnumerator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6550:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) )
            // InternalModelDraw.g:6551:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            {
            // InternalModelDraw.g:6551:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            // InternalModelDraw.g:6552:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_4()); 
            // InternalModelDraw.g:6553:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==RULE_ID) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // InternalModelDraw.g:6553:3: rule__NodeEnumerator__EnumeratorAssignment_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__NodeEnumerator__EnumeratorAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop65;
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
    // InternalModelDraw.g:6561:1: rule__NodeEnumerator__Group__5 : rule__NodeEnumerator__Group__5__Impl ;
    public final void rule__NodeEnumerator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6565:1: ( rule__NodeEnumerator__Group__5__Impl )
            // InternalModelDraw.g:6566:2: rule__NodeEnumerator__Group__5__Impl
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
    // InternalModelDraw.g:6572:1: rule__NodeEnumerator__Group__5__Impl : ( ']' ) ;
    public final void rule__NodeEnumerator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6576:1: ( ( ']' ) )
            // InternalModelDraw.g:6577:1: ( ']' )
            {
            // InternalModelDraw.g:6577:1: ( ']' )
            // InternalModelDraw.g:6578:2: ']'
            {
             before(grammarAccess.getNodeEnumeratorAccess().getRightSquareBracketKeyword_5()); 
            match(input,48,FOLLOW_2); 
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
    // InternalModelDraw.g:6588:1: rule__Enumerator__Group__0 : rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 ;
    public final void rule__Enumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6592:1: ( rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 )
            // InternalModelDraw.g:6593:2: rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1
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
    // InternalModelDraw.g:6600:1: rule__Enumerator__Group__0__Impl : ( () ) ;
    public final void rule__Enumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6604:1: ( ( () ) )
            // InternalModelDraw.g:6605:1: ( () )
            {
            // InternalModelDraw.g:6605:1: ( () )
            // InternalModelDraw.g:6606:2: ()
            {
             before(grammarAccess.getEnumeratorAccess().getEnumeratorAction_0()); 
            // InternalModelDraw.g:6607:2: ()
            // InternalModelDraw.g:6607:3: 
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
    // InternalModelDraw.g:6615:1: rule__Enumerator__Group__1 : rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 ;
    public final void rule__Enumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6619:1: ( rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 )
            // InternalModelDraw.g:6620:2: rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2
            {
            pushFollow(FOLLOW_17);
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
    // InternalModelDraw.g:6627:1: rule__Enumerator__Group__1__Impl : ( ( rule__Enumerator__LiteralAssignment_1 ) ) ;
    public final void rule__Enumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6631:1: ( ( ( rule__Enumerator__LiteralAssignment_1 ) ) )
            // InternalModelDraw.g:6632:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            {
            // InternalModelDraw.g:6632:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            // InternalModelDraw.g:6633:2: ( rule__Enumerator__LiteralAssignment_1 )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralAssignment_1()); 
            // InternalModelDraw.g:6634:2: ( rule__Enumerator__LiteralAssignment_1 )
            // InternalModelDraw.g:6634:3: rule__Enumerator__LiteralAssignment_1
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
    // InternalModelDraw.g:6642:1: rule__Enumerator__Group__2 : rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 ;
    public final void rule__Enumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6646:1: ( rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 )
            // InternalModelDraw.g:6647:2: rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3
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
    // InternalModelDraw.g:6654:1: rule__Enumerator__Group__2__Impl : ( '=' ) ;
    public final void rule__Enumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6658:1: ( ( '=' ) )
            // InternalModelDraw.g:6659:1: ( '=' )
            {
            // InternalModelDraw.g:6659:1: ( '=' )
            // InternalModelDraw.g:6660:2: '='
            {
             before(grammarAccess.getEnumeratorAccess().getEqualsSignKeyword_2()); 
            match(input,33,FOLLOW_2); 
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
    // InternalModelDraw.g:6669:1: rule__Enumerator__Group__3 : rule__Enumerator__Group__3__Impl ;
    public final void rule__Enumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6673:1: ( rule__Enumerator__Group__3__Impl )
            // InternalModelDraw.g:6674:2: rule__Enumerator__Group__3__Impl
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
    // InternalModelDraw.g:6680:1: rule__Enumerator__Group__3__Impl : ( ( rule__Enumerator__ValueAssignment_3 ) ) ;
    public final void rule__Enumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6684:1: ( ( ( rule__Enumerator__ValueAssignment_3 ) ) )
            // InternalModelDraw.g:6685:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            {
            // InternalModelDraw.g:6685:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            // InternalModelDraw.g:6686:2: ( rule__Enumerator__ValueAssignment_3 )
            {
             before(grammarAccess.getEnumeratorAccess().getValueAssignment_3()); 
            // InternalModelDraw.g:6687:2: ( rule__Enumerator__ValueAssignment_3 )
            // InternalModelDraw.g:6687:3: rule__Enumerator__ValueAssignment_3
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
    // InternalModelDraw.g:6696:1: rule__Information__Group__0 : rule__Information__Group__0__Impl rule__Information__Group__1 ;
    public final void rule__Information__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6700:1: ( rule__Information__Group__0__Impl rule__Information__Group__1 )
            // InternalModelDraw.g:6701:2: rule__Information__Group__0__Impl rule__Information__Group__1
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
    // InternalModelDraw.g:6708:1: rule__Information__Group__0__Impl : ( () ) ;
    public final void rule__Information__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6712:1: ( ( () ) )
            // InternalModelDraw.g:6713:1: ( () )
            {
            // InternalModelDraw.g:6713:1: ( () )
            // InternalModelDraw.g:6714:2: ()
            {
             before(grammarAccess.getInformationAccess().getInformationAction_0()); 
            // InternalModelDraw.g:6715:2: ()
            // InternalModelDraw.g:6715:3: 
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
    // InternalModelDraw.g:6723:1: rule__Information__Group__1 : rule__Information__Group__1__Impl rule__Information__Group__2 ;
    public final void rule__Information__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6727:1: ( rule__Information__Group__1__Impl rule__Information__Group__2 )
            // InternalModelDraw.g:6728:2: rule__Information__Group__1__Impl rule__Information__Group__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:6735:1: rule__Information__Group__1__Impl : ( ( rule__Information__TypeAssignment_1 ) ) ;
    public final void rule__Information__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6739:1: ( ( ( rule__Information__TypeAssignment_1 ) ) )
            // InternalModelDraw.g:6740:1: ( ( rule__Information__TypeAssignment_1 ) )
            {
            // InternalModelDraw.g:6740:1: ( ( rule__Information__TypeAssignment_1 ) )
            // InternalModelDraw.g:6741:2: ( rule__Information__TypeAssignment_1 )
            {
             before(grammarAccess.getInformationAccess().getTypeAssignment_1()); 
            // InternalModelDraw.g:6742:2: ( rule__Information__TypeAssignment_1 )
            // InternalModelDraw.g:6742:3: rule__Information__TypeAssignment_1
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
    // InternalModelDraw.g:6750:1: rule__Information__Group__2 : rule__Information__Group__2__Impl ;
    public final void rule__Information__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6754:1: ( rule__Information__Group__2__Impl )
            // InternalModelDraw.g:6755:2: rule__Information__Group__2__Impl
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
    // InternalModelDraw.g:6761:1: rule__Information__Group__2__Impl : ( ( rule__Information__Group_2__0 )? ) ;
    public final void rule__Information__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6765:1: ( ( ( rule__Information__Group_2__0 )? ) )
            // InternalModelDraw.g:6766:1: ( ( rule__Information__Group_2__0 )? )
            {
            // InternalModelDraw.g:6766:1: ( ( rule__Information__Group_2__0 )? )
            // InternalModelDraw.g:6767:2: ( rule__Information__Group_2__0 )?
            {
             before(grammarAccess.getInformationAccess().getGroup_2()); 
            // InternalModelDraw.g:6768:2: ( rule__Information__Group_2__0 )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==40) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalModelDraw.g:6768:3: rule__Information__Group_2__0
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
    // InternalModelDraw.g:6777:1: rule__Information__Group_2__0 : rule__Information__Group_2__0__Impl rule__Information__Group_2__1 ;
    public final void rule__Information__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6781:1: ( rule__Information__Group_2__0__Impl rule__Information__Group_2__1 )
            // InternalModelDraw.g:6782:2: rule__Information__Group_2__0__Impl rule__Information__Group_2__1
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
    // InternalModelDraw.g:6789:1: rule__Information__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Information__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6793:1: ( ( '.' ) )
            // InternalModelDraw.g:6794:1: ( '.' )
            {
            // InternalModelDraw.g:6794:1: ( '.' )
            // InternalModelDraw.g:6795:2: '.'
            {
             before(grammarAccess.getInformationAccess().getFullStopKeyword_2_0()); 
            match(input,40,FOLLOW_2); 
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
    // InternalModelDraw.g:6804:1: rule__Information__Group_2__1 : rule__Information__Group_2__1__Impl ;
    public final void rule__Information__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6808:1: ( rule__Information__Group_2__1__Impl )
            // InternalModelDraw.g:6809:2: rule__Information__Group_2__1__Impl
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
    // InternalModelDraw.g:6815:1: rule__Information__Group_2__1__Impl : ( ( rule__Information__AttAssignment_2_1 ) ) ;
    public final void rule__Information__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6819:1: ( ( ( rule__Information__AttAssignment_2_1 ) ) )
            // InternalModelDraw.g:6820:1: ( ( rule__Information__AttAssignment_2_1 ) )
            {
            // InternalModelDraw.g:6820:1: ( ( rule__Information__AttAssignment_2_1 ) )
            // InternalModelDraw.g:6821:2: ( rule__Information__AttAssignment_2_1 )
            {
             before(grammarAccess.getInformationAccess().getAttAssignment_2_1()); 
            // InternalModelDraw.g:6822:2: ( rule__Information__AttAssignment_2_1 )
            // InternalModelDraw.g:6822:3: rule__Information__AttAssignment_2_1
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
    // InternalModelDraw.g:6831:1: rule__MutatorDraw__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__MutatorDraw__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6835:1: ( ( ruleEString ) )
            // InternalModelDraw.g:6836:2: ( ruleEString )
            {
            // InternalModelDraw.g:6836:2: ( ruleEString )
            // InternalModelDraw.g:6837:3: ruleEString
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
    // InternalModelDraw.g:6846:1: rule__MutatorDraw__NameAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MutatorDraw__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6850:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:6851:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:6851:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:6852:3: ( RULE_ID )
            {
             before(grammarAccess.getMutatorDrawAccess().getNameEClassCrossReference_3_0()); 
            // InternalModelDraw.g:6853:3: ( RULE_ID )
            // InternalModelDraw.g:6854:4: RULE_ID
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
    // InternalModelDraw.g:6865:1: rule__MutatorDraw__TypeAssignment_5 : ( ruleDrawType ) ;
    public final void rule__MutatorDraw__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6869:1: ( ( ruleDrawType ) )
            // InternalModelDraw.g:6870:2: ( ruleDrawType )
            {
            // InternalModelDraw.g:6870:2: ( ruleDrawType )
            // InternalModelDraw.g:6871:3: ruleDrawType
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
    // InternalModelDraw.g:6880:1: rule__MutatorDraw__NodesAssignment_7 : ( ruleNode ) ;
    public final void rule__MutatorDraw__NodesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6884:1: ( ( ruleNode ) )
            // InternalModelDraw.g:6885:2: ( ruleNode )
            {
            // InternalModelDraw.g:6885:2: ( ruleNode )
            // InternalModelDraw.g:6886:3: ruleNode
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
    // InternalModelDraw.g:6895:1: rule__MutatorDraw__RelationsAssignment_8 : ( ruleRelation ) ;
    public final void rule__MutatorDraw__RelationsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6899:1: ( ( ruleRelation ) )
            // InternalModelDraw.g:6900:2: ( ruleRelation )
            {
            // InternalModelDraw.g:6900:2: ( ruleRelation )
            // InternalModelDraw.g:6901:3: ruleRelation
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
    // InternalModelDraw.g:6910:1: rule__MutatorDraw__ContentsAssignment_9 : ( ruleContent ) ;
    public final void rule__MutatorDraw__ContentsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6914:1: ( ( ruleContent ) )
            // InternalModelDraw.g:6915:2: ( ruleContent )
            {
            // InternalModelDraw.g:6915:2: ( ruleContent )
            // InternalModelDraw.g:6916:3: ruleContent
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
    // InternalModelDraw.g:6925:1: rule__Node__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6929:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:6930:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:6930:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:6931:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:6932:3: ( RULE_ID )
            // InternalModelDraw.g:6933:4: RULE_ID
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


    // $ANTLR start "rule__Node__AttributeAssignment_2_1"
    // InternalModelDraw.g:6944:1: rule__Node__AttributeAssignment_2_1 : ( ruleBooleanAttribute ) ;
    public final void rule__Node__AttributeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6948:1: ( ( ruleBooleanAttribute ) )
            // InternalModelDraw.g:6949:2: ( ruleBooleanAttribute )
            {
            // InternalModelDraw.g:6949:2: ( ruleBooleanAttribute )
            // InternalModelDraw.g:6950:3: ruleBooleanAttribute
            {
             before(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanAttribute();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__AttributeAssignment_2_1"


    // $ANTLR start "rule__Node__AttributeAssignment_2_2_1"
    // InternalModelDraw.g:6959:1: rule__Node__AttributeAssignment_2_2_1 : ( ruleBooleanAttribute ) ;
    public final void rule__Node__AttributeAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6963:1: ( ( ruleBooleanAttribute ) )
            // InternalModelDraw.g:6964:2: ( ruleBooleanAttribute )
            {
            // InternalModelDraw.g:6964:2: ( ruleBooleanAttribute )
            // InternalModelDraw.g:6965:3: ruleBooleanAttribute
            {
             before(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_2_1_0()); 
            pushFollow(FOLLOW_2);
            ruleBooleanAttribute();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getAttributeBooleanAttributeParserRuleCall_2_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__AttributeAssignment_2_2_1"


    // $ANTLR start "rule__Node__TypeAssignment_4"
    // InternalModelDraw.g:6974:1: rule__Node__TypeAssignment_4 : ( ruleNodeType ) ;
    public final void rule__Node__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6978:1: ( ( ruleNodeType ) )
            // InternalModelDraw.g:6979:2: ( ruleNodeType )
            {
            // InternalModelDraw.g:6979:2: ( ruleNodeType )
            // InternalModelDraw.g:6980:3: ruleNodeType
            {
             before(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_4_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeType();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__TypeAssignment_4"


    // $ANTLR start "rule__Node__AttNameAssignment_5_1"
    // InternalModelDraw.g:6989:1: rule__Node__AttNameAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__AttNameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:6993:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:6994:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:6994:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:6995:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_5_1_0()); 
            // InternalModelDraw.g:6996:3: ( RULE_ID )
            // InternalModelDraw.g:6997:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getAttNameEAttributeIDTerminalRuleCall_5_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getAttNameEAttributeIDTerminalRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__AttNameAssignment_5_1"


    // $ANTLR start "rule__Node__ReferenceAssignment_6_3"
    // InternalModelDraw.g:7008:1: rule__Node__ReferenceAssignment_6_3 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7012:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7013:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7013:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7014:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_3_0()); 
            // InternalModelDraw.g:7015:3: ( RULE_ID )
            // InternalModelDraw.g:7016:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_6_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_6_3_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ReferenceAssignment_6_3"


    // $ANTLR start "rule__Node__ReferenceAssignment_6_4"
    // InternalModelDraw.g:7027:1: rule__Node__ReferenceAssignment_6_4 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7031:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7032:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7032:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7033:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_4_0()); 
            // InternalModelDraw.g:7034:3: ( RULE_ID )
            // InternalModelDraw.g:7035:4: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_6_4_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getNodeAccess().getReferenceEReferenceIDTerminalRuleCall_6_4_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ReferenceAssignment_6_4"


    // $ANTLR start "rule__Node__ShapeAssignment_7_2"
    // InternalModelDraw.g:7046:1: rule__Node__ShapeAssignment_7_2 : ( ruleNodeShape ) ;
    public final void rule__Node__ShapeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7050:1: ( ( ruleNodeShape ) )
            // InternalModelDraw.g:7051:2: ( ruleNodeShape )
            {
            // InternalModelDraw.g:7051:2: ( ruleNodeShape )
            // InternalModelDraw.g:7052:3: ruleNodeShape
            {
             before(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_7_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeShape();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ShapeAssignment_7_2"


    // $ANTLR start "rule__Node__ColorAssignment_8_2"
    // InternalModelDraw.g:7061:1: rule__Node__ColorAssignment_8_2 : ( ruleNodeColor ) ;
    public final void rule__Node__ColorAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7065:1: ( ( ruleNodeColor ) )
            // InternalModelDraw.g:7066:2: ( ruleNodeColor )
            {
            // InternalModelDraw.g:7066:2: ( ruleNodeColor )
            // InternalModelDraw.g:7067:3: ruleNodeColor
            {
             before(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_8_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeColor();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getColorNodeColorEnumRuleCall_8_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ColorAssignment_8_2"


    // $ANTLR start "rule__Node__StyleAssignment_9_2"
    // InternalModelDraw.g:7076:1: rule__Node__StyleAssignment_9_2 : ( ruleNodeStyle ) ;
    public final void rule__Node__StyleAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7080:1: ( ( ruleNodeStyle ) )
            // InternalModelDraw.g:7081:2: ( ruleNodeStyle )
            {
            // InternalModelDraw.g:7081:2: ( ruleNodeStyle )
            // InternalModelDraw.g:7082:3: ruleNodeStyle
            {
             before(grammarAccess.getNodeAccess().getStyleNodeStyleEnumRuleCall_9_2_0()); 
            pushFollow(FOLLOW_2);
            ruleNodeStyle();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getStyleNodeStyleEnumRuleCall_9_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__StyleAssignment_9_2"


    // $ANTLR start "rule__BooleanAttribute__NegationAssignment_1"
    // InternalModelDraw.g:7091:1: rule__BooleanAttribute__NegationAssignment_1 : ( ( 'not' ) ) ;
    public final void rule__BooleanAttribute__NegationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7095:1: ( ( ( 'not' ) ) )
            // InternalModelDraw.g:7096:2: ( ( 'not' ) )
            {
            // InternalModelDraw.g:7096:2: ( ( 'not' ) )
            // InternalModelDraw.g:7097:3: ( 'not' )
            {
             before(grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0()); 
            // InternalModelDraw.g:7098:3: ( 'not' )
            // InternalModelDraw.g:7099:4: 'not'
            {
             before(grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0()); 
            match(input,49,FOLLOW_2); 
             after(grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0()); 

            }

             after(grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__NegationAssignment_1"


    // $ANTLR start "rule__BooleanAttribute__AttAssignment_2"
    // InternalModelDraw.g:7110:1: rule__BooleanAttribute__AttAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttribute__AttAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7114:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7115:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7115:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7116:3: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeAccess().getAttEAttributeCrossReference_2_0()); 
            // InternalModelDraw.g:7117:3: ( RULE_ID )
            // InternalModelDraw.g:7118:4: RULE_ID
            {
             before(grammarAccess.getBooleanAttributeAccess().getAttEAttributeIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getBooleanAttributeAccess().getAttEAttributeIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getBooleanAttributeAccess().getAttEAttributeCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanAttribute__AttAssignment_2"


    // $ANTLR start "rule__Edge__NameAssignment_1"
    // InternalModelDraw.g:7129:1: rule__Edge__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7133:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7134:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7134:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7135:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:7136:3: ( RULE_ID )
            // InternalModelDraw.g:7137:4: RULE_ID
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


    // $ANTLR start "rule__Edge__SourceAssignment_3"
    // InternalModelDraw.g:7148:1: rule__Edge__SourceAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__SourceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7152:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7153:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7153:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7154:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0()); 
            // InternalModelDraw.g:7155:3: ( RULE_ID )
            // InternalModelDraw.g:7156:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSourceEReferenceIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__SourceAssignment_3"


    // $ANTLR start "rule__Edge__TargetAssignment_5"
    // InternalModelDraw.g:7167:1: rule__Edge__TargetAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7171:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7172:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7172:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7173:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_5_0()); 
            // InternalModelDraw.g:7174:3: ( RULE_ID )
            // InternalModelDraw.g:7175:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTargetEReferenceIDTerminalRuleCall_5_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__TargetAssignment_5"


    // $ANTLR start "rule__Edge__AttNameAssignment_9_1"
    // InternalModelDraw.g:7186:1: rule__Edge__AttNameAssignment_9_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__AttNameAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7190:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7191:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7191:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7192:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_9_1_0()); 
            // InternalModelDraw.g:7193:3: ( RULE_ID )
            // InternalModelDraw.g:7194:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getAttNameEAttributeIDTerminalRuleCall_9_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getAttNameEAttributeIDTerminalRuleCall_9_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_9_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__AttNameAssignment_9_1"


    // $ANTLR start "rule__Edge__ReferenceAssignment_10_2_0_0_0"
    // InternalModelDraw.g:7205:1: rule__Edge__ReferenceAssignment_10_2_0_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_10_2_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7209:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7210:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7210:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7211:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_0_0_0_0()); 
            // InternalModelDraw.g:7212:3: ( RULE_ID )
            // InternalModelDraw.g:7213:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_0_0_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_0_0_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_0_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_10_2_0_0_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_10_2_0_0_1_1"
    // InternalModelDraw.g:7224:1: rule__Edge__RefTypeAssignment_10_2_0_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_10_2_0_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7228:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7229:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7229:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7230:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_0_0_1_1_0()); 
            // InternalModelDraw.g:7231:3: ( RULE_ID )
            // InternalModelDraw.g:7232:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_0_0_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_0_0_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_0_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_10_2_0_0_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_10_2_0_1"
    // InternalModelDraw.g:7243:1: rule__Edge__LabelAssignment_10_2_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_10_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7247:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7248:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7248:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7249:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_0_1_0()); 
            // InternalModelDraw.g:7250:3: ( RULE_ID )
            // InternalModelDraw.g:7251:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_0_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_10_2_0_1"


    // $ANTLR start "rule__Edge__ReferenceAssignment_10_2_1_1_0"
    // InternalModelDraw.g:7262:1: rule__Edge__ReferenceAssignment_10_2_1_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_10_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7266:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7267:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7267:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7268:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_1_0_0()); 
            // InternalModelDraw.g:7269:3: ( RULE_ID )
            // InternalModelDraw.g:7270:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_10_2_1_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_10_2_1_1_1_1"
    // InternalModelDraw.g:7281:1: rule__Edge__RefTypeAssignment_10_2_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_10_2_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7285:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7286:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7286:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7287:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_1_1_1_0()); 
            // InternalModelDraw.g:7288:3: ( RULE_ID )
            // InternalModelDraw.g:7289:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_10_2_1_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_10_2_1_2"
    // InternalModelDraw.g:7300:1: rule__Edge__LabelAssignment_10_2_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_10_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7304:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7305:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7305:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7306:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_2_0()); 
            // InternalModelDraw.g:7307:3: ( RULE_ID )
            // InternalModelDraw.g:7308:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_10_2_1_2"


    // $ANTLR start "rule__Edge__ReferenceAssignment_10_2_1_3_1_0"
    // InternalModelDraw.g:7319:1: rule__Edge__ReferenceAssignment_10_2_1_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_10_2_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7323:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7324:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7324:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7325:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_3_1_0_0()); 
            // InternalModelDraw.g:7326:3: ( RULE_ID )
            // InternalModelDraw.g:7327:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_3_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_3_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_10_2_1_3_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1"
    // InternalModelDraw.g:7338:1: rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7342:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7343:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7343:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7344:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_3_1_1_1_0()); 
            // InternalModelDraw.g:7345:3: ( RULE_ID )
            // InternalModelDraw.g:7346:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_3_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_3_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_10_2_1_3_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_10_2_1_3_2"
    // InternalModelDraw.g:7357:1: rule__Edge__LabelAssignment_10_2_1_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_10_2_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7361:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7362:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7362:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7363:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_3_2_0()); 
            // InternalModelDraw.g:7364:3: ( RULE_ID )
            // InternalModelDraw.g:7365:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_3_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_3_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_10_2_1_3_2"


    // $ANTLR start "rule__Edge__ReferenceAssignment_10_2_1_4_1_0"
    // InternalModelDraw.g:7376:1: rule__Edge__ReferenceAssignment_10_2_1_4_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_10_2_1_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7380:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7381:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7381:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7382:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_4_1_0_0()); 
            // InternalModelDraw.g:7383:3: ( RULE_ID )
            // InternalModelDraw.g:7384:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_4_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_4_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_4_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_10_2_1_4_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1"
    // InternalModelDraw.g:7395:1: rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7399:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7400:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7400:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7401:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_4_1_1_1_0()); 
            // InternalModelDraw.g:7402:3: ( RULE_ID )
            // InternalModelDraw.g:7403:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_4_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_4_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_4_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_10_2_1_4_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_10_2_1_4_2"
    // InternalModelDraw.g:7414:1: rule__Edge__LabelAssignment_10_2_1_4_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_10_2_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7418:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7419:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7419:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7420:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_4_2_0()); 
            // InternalModelDraw.g:7421:3: ( RULE_ID )
            // InternalModelDraw.g:7422:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_4_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_4_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_4_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_10_2_1_4_2"


    // $ANTLR start "rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0"
    // InternalModelDraw.g:7433:1: rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7437:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7438:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7438:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7439:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_4_3_1_0_0()); 
            // InternalModelDraw.g:7440:3: ( RULE_ID )
            // InternalModelDraw.g:7441:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_4_3_1_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_1_4_3_1_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_1_4_3_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_10_2_1_4_3_1_0"


    // $ANTLR start "rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1"
    // InternalModelDraw.g:7452:1: rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7456:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7457:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7457:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7458:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_4_3_1_1_1_0()); 
            // InternalModelDraw.g:7459:3: ( RULE_ID )
            // InternalModelDraw.g:7460:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_4_3_1_1_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceIDTerminalRuleCall_10_2_1_4_3_1_1_1_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getRefTypeEReferenceCrossReference_10_2_1_4_3_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__RefTypeAssignment_10_2_1_4_3_1_1_1"


    // $ANTLR start "rule__Edge__LabelAssignment_10_2_1_4_3_2"
    // InternalModelDraw.g:7471:1: rule__Edge__LabelAssignment_10_2_1_4_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_10_2_1_4_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7475:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7476:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7476:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7477:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_4_3_2_0()); 
            // InternalModelDraw.g:7478:3: ( RULE_ID )
            // InternalModelDraw.g:7479:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_4_3_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_2_1_4_3_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_2_1_4_3_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_10_2_1_4_3_2"


    // $ANTLR start "rule__Edge__Src_decorationAssignment_11_2"
    // InternalModelDraw.g:7490:1: rule__Edge__Src_decorationAssignment_11_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Src_decorationAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7494:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:7495:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:7495:2: ( ruleDecoration )
            // InternalModelDraw.g:7496:3: ruleDecoration
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_11_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDecoration();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getSrc_decorationDecorationEnumRuleCall_11_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Src_decorationAssignment_11_2"


    // $ANTLR start "rule__Edge__Src_labelAssignment_12_2"
    // InternalModelDraw.g:7505:1: rule__Edge__Src_labelAssignment_12_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Src_labelAssignment_12_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7509:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7510:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7510:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7511:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_12_2_0()); 
            // InternalModelDraw.g:7512:3: ( RULE_ID )
            // InternalModelDraw.g:7513:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelEAttributeIDTerminalRuleCall_12_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getSrc_labelEAttributeIDTerminalRuleCall_12_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_12_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Src_labelAssignment_12_2"


    // $ANTLR start "rule__Edge__Tar_decorationAssignment_13_2"
    // InternalModelDraw.g:7524:1: rule__Edge__Tar_decorationAssignment_13_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Tar_decorationAssignment_13_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7528:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:7529:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:7529:2: ( ruleDecoration )
            // InternalModelDraw.g:7530:3: ruleDecoration
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_13_2_0()); 
            pushFollow(FOLLOW_2);
            ruleDecoration();

            state._fsp--;

             after(grammarAccess.getEdgeAccess().getTar_decorationDecorationEnumRuleCall_13_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Tar_decorationAssignment_13_2"


    // $ANTLR start "rule__Edge__Tar_labelAssignment_14_2"
    // InternalModelDraw.g:7539:1: rule__Edge__Tar_labelAssignment_14_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Tar_labelAssignment_14_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7543:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7544:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7544:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7545:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_14_2_0()); 
            // InternalModelDraw.g:7546:3: ( RULE_ID )
            // InternalModelDraw.g:7547:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getTar_labelEAttributeIDTerminalRuleCall_14_2_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getTar_labelEAttributeIDTerminalRuleCall_14_2_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_14_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Tar_labelAssignment_14_2"


    // $ANTLR start "rule__Level__NameAssignment_1"
    // InternalModelDraw.g:7558:1: rule__Level__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7562:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7563:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7563:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7564:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:7565:3: ( RULE_ID )
            // InternalModelDraw.g:7566:4: RULE_ID
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
    // InternalModelDraw.g:7577:1: rule__Level__UpperAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Level__UpperAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7581:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7582:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7582:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7583:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0()); 
            // InternalModelDraw.g:7584:3: ( RULE_ID )
            // InternalModelDraw.g:7585:4: RULE_ID
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
    // InternalModelDraw.g:7596:1: rule__Level__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7600:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7601:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7601:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7602:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:7603:3: ( RULE_ID )
            // InternalModelDraw.g:7604:4: RULE_ID
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
    // InternalModelDraw.g:7615:1: rule__Level__ReferenceAssignment_7_2_0_0_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_0_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7619:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7620:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7620:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7621:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0_0_0()); 
            // InternalModelDraw.g:7622:3: ( RULE_ID )
            // InternalModelDraw.g:7623:4: RULE_ID
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
    // InternalModelDraw.g:7634:1: rule__Level__RefTypeAssignment_7_2_0_0_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_0_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7638:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7639:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7639:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7640:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_0_0_1_1_0()); 
            // InternalModelDraw.g:7641:3: ( RULE_ID )
            // InternalModelDraw.g:7642:4: RULE_ID
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
    // InternalModelDraw.g:7653:1: rule__Level__LabelAssignment_7_2_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7657:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7658:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7658:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7659:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_0_1_0()); 
            // InternalModelDraw.g:7660:3: ( RULE_ID )
            // InternalModelDraw.g:7661:4: RULE_ID
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
    // InternalModelDraw.g:7672:1: rule__Level__ReferenceAssignment_7_2_1_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7676:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7677:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7677:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7678:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_1_0_0()); 
            // InternalModelDraw.g:7679:3: ( RULE_ID )
            // InternalModelDraw.g:7680:4: RULE_ID
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
    // InternalModelDraw.g:7691:1: rule__Level__RefTypeAssignment_7_2_1_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7695:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7696:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7696:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7697:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_1_1_1_0()); 
            // InternalModelDraw.g:7698:3: ( RULE_ID )
            // InternalModelDraw.g:7699:4: RULE_ID
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
    // InternalModelDraw.g:7710:1: rule__Level__LabelAssignment_7_2_1_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7714:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7715:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7715:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7716:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_2_0()); 
            // InternalModelDraw.g:7717:3: ( RULE_ID )
            // InternalModelDraw.g:7718:4: RULE_ID
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
    // InternalModelDraw.g:7729:1: rule__Level__ReferenceAssignment_7_2_1_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7733:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7734:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7734:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7735:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_3_1_0_0()); 
            // InternalModelDraw.g:7736:3: ( RULE_ID )
            // InternalModelDraw.g:7737:4: RULE_ID
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
    // InternalModelDraw.g:7748:1: rule__Level__RefTypeAssignment_7_2_1_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7752:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7753:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7753:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7754:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_3_1_1_1_0()); 
            // InternalModelDraw.g:7755:3: ( RULE_ID )
            // InternalModelDraw.g:7756:4: RULE_ID
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
    // InternalModelDraw.g:7767:1: rule__Level__LabelAssignment_7_2_1_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7771:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7772:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7772:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7773:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_3_2_0()); 
            // InternalModelDraw.g:7774:3: ( RULE_ID )
            // InternalModelDraw.g:7775:4: RULE_ID
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
    // InternalModelDraw.g:7786:1: rule__Level__ReferenceAssignment_7_2_1_4_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_4_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7790:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7791:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7791:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7792:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_1_0_0()); 
            // InternalModelDraw.g:7793:3: ( RULE_ID )
            // InternalModelDraw.g:7794:4: RULE_ID
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
    // InternalModelDraw.g:7805:1: rule__Level__RefTypeAssignment_7_2_1_4_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_4_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7809:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7810:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7810:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7811:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_1_1_1_0()); 
            // InternalModelDraw.g:7812:3: ( RULE_ID )
            // InternalModelDraw.g:7813:4: RULE_ID
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
    // InternalModelDraw.g:7824:1: rule__Level__LabelAssignment_7_2_1_4_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_4_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7828:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7829:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7829:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7830:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_2_0()); 
            // InternalModelDraw.g:7831:3: ( RULE_ID )
            // InternalModelDraw.g:7832:4: RULE_ID
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
    // InternalModelDraw.g:7843:1: rule__Level__ReferenceAssignment_7_2_1_4_3_1_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_1_4_3_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7847:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7848:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7848:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7849:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_1_4_3_1_0_0()); 
            // InternalModelDraw.g:7850:3: ( RULE_ID )
            // InternalModelDraw.g:7851:4: RULE_ID
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
    // InternalModelDraw.g:7862:1: rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__RefTypeAssignment_7_2_1_4_3_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7866:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7867:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7867:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7868:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getRefTypeEReferenceCrossReference_7_2_1_4_3_1_1_1_0()); 
            // InternalModelDraw.g:7869:3: ( RULE_ID )
            // InternalModelDraw.g:7870:4: RULE_ID
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
    // InternalModelDraw.g:7881:1: rule__Level__LabelAssignment_7_2_1_4_3_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_2_1_4_3_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7885:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7886:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7886:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7887:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_2_1_4_3_2_0()); 
            // InternalModelDraw.g:7888:3: ( RULE_ID )
            // InternalModelDraw.g:7889:4: RULE_ID
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
    // InternalModelDraw.g:7900:1: rule__Level__Src_decorationAssignment_8_2 : ( ruleDecoration ) ;
    public final void rule__Level__Src_decorationAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7904:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:7905:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:7905:2: ( ruleDecoration )
            // InternalModelDraw.g:7906:3: ruleDecoration
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
    // InternalModelDraw.g:7915:1: rule__Level__Src_labelAssignment_9_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Src_labelAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7919:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7920:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7920:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7921:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 
            // InternalModelDraw.g:7922:3: ( RULE_ID )
            // InternalModelDraw.g:7923:4: RULE_ID
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
    // InternalModelDraw.g:7934:1: rule__Level__Tar_decorationAssignment_10_2 : ( ruleDecoration ) ;
    public final void rule__Level__Tar_decorationAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7938:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:7939:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:7939:2: ( ruleDecoration )
            // InternalModelDraw.g:7940:3: ruleDecoration
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
    // InternalModelDraw.g:7949:1: rule__Level__Tar_labelAssignment_11_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Tar_labelAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7953:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7954:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7954:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7955:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getTar_labelEAttributeCrossReference_11_2_0()); 
            // InternalModelDraw.g:7956:3: ( RULE_ID )
            // InternalModelDraw.g:7957:4: RULE_ID
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
    // InternalModelDraw.g:7968:1: rule__Content__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7972:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:7973:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:7973:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:7974:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:7975:3: ( RULE_ID )
            // InternalModelDraw.g:7976:4: RULE_ID
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
    // InternalModelDraw.g:7987:1: rule__Content__NodenumAssignment_3_0 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:7991:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:7992:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:7992:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:7993:3: ruleNodeEnumerator
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
    // InternalModelDraw.g:8002:1: rule__Content__NodenumAssignment_3_1 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8006:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:8007:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:8007:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:8008:3: ruleNodeEnumerator
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
    // InternalModelDraw.g:8017:1: rule__Content__InfoAssignment_4_0 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8021:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:8022:2: ( ruleInformation )
            {
            // InternalModelDraw.g:8022:2: ( ruleInformation )
            // InternalModelDraw.g:8023:3: ruleInformation
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
    // InternalModelDraw.g:8032:1: rule__Content__InfoAssignment_4_1 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8036:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:8037:2: ( ruleInformation )
            {
            // InternalModelDraw.g:8037:2: ( ruleInformation )
            // InternalModelDraw.g:8038:3: ruleInformation
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
    // InternalModelDraw.g:8047:1: rule__Content__AttNameAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__AttNameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8051:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8052:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8052:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8053:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0()); 
            // InternalModelDraw.g:8054:3: ( RULE_ID )
            // InternalModelDraw.g:8055:4: RULE_ID
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
    // InternalModelDraw.g:8066:1: rule__Content__SymbolAssignment_6_2 : ( ruleEString ) ;
    public final void rule__Content__SymbolAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8070:1: ( ( ruleEString ) )
            // InternalModelDraw.g:8071:2: ( ruleEString )
            {
            // InternalModelDraw.g:8071:2: ( ruleEString )
            // InternalModelDraw.g:8072:3: ruleEString
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
    // InternalModelDraw.g:8081:1: rule__NodeEnumerator__AttAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NodeEnumerator__AttAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8085:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8086:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8086:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8087:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0()); 
            // InternalModelDraw.g:8088:3: ( RULE_ID )
            // InternalModelDraw.g:8089:4: RULE_ID
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
    // InternalModelDraw.g:8100:1: rule__NodeEnumerator__EnumeratorAssignment_3 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8104:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:8105:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:8105:2: ( ruleEnumerator )
            // InternalModelDraw.g:8106:3: ruleEnumerator
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
    // InternalModelDraw.g:8115:1: rule__NodeEnumerator__EnumeratorAssignment_4 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8119:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:8120:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:8120:2: ( ruleEnumerator )
            // InternalModelDraw.g:8121:3: ruleEnumerator
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
    // InternalModelDraw.g:8130:1: rule__Enumerator__LiteralAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Enumerator__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8134:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8135:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8135:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8136:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0()); 
            // InternalModelDraw.g:8137:3: ( RULE_ID )
            // InternalModelDraw.g:8138:4: RULE_ID
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
    // InternalModelDraw.g:8149:1: rule__Enumerator__ValueAssignment_3 : ( ruleEString ) ;
    public final void rule__Enumerator__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8153:1: ( ( ruleEString ) )
            // InternalModelDraw.g:8154:2: ( ruleEString )
            {
            // InternalModelDraw.g:8154:2: ( ruleEString )
            // InternalModelDraw.g:8155:3: ruleEString
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
    // InternalModelDraw.g:8164:1: rule__Information__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8168:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8169:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8169:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8170:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0()); 
            // InternalModelDraw.g:8171:3: ( RULE_ID )
            // InternalModelDraw.g:8172:4: RULE_ID
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
    // InternalModelDraw.g:8183:1: rule__Information__AttAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__AttAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:8187:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:8188:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:8188:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:8189:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getAttEAttributeCrossReference_2_1_0()); 
            // InternalModelDraw.g:8190:3: ( RULE_ID )
            // InternalModelDraw.g:8191:4: RULE_ID
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


    protected DFA9 dfa9 = new DFA9(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\5\1\33\1\uffff\2\5\1\37\1\uffff\1\5\1\37\1\33\1\15";
    static final String dfa_3s = "\1\35\1\50\1\uffff\1\61\1\56\1\40\1\uffff\1\61\1\40\1\33\1\46";
    static final String dfa_4s = "\2\uffff\1\2\3\uffff\1\1\4\uffff";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\27\uffff\1\2",
            "\1\4\2\uffff\1\3\11\uffff\1\2",
            "",
            "\1\5\53\uffff\1\6",
            "\1\2\7\uffff\2\6\15\uffff\2\2\20\uffff\1\2",
            "\1\6\1\7",
            "",
            "\1\10\53\uffff\1\6",
            "\1\11\1\6",
            "\1\12",
            "\2\6\27\uffff\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA9 extends DFA {

        public DFA9(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 9;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 829:2: ( rule__MutatorDraw__NodesAssignment_7 )*";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000020000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000022L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000003E00000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0002000000000020L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000038000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x00000000000C0000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00003C8200000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000030000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000160000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000003F00000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000400010000020L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001000000000020L});

}