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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'diagram'", "'gray95'", "'node'", "'markednode'", "'circle'", "'doublecircle'", "'record'", "'italic'", "'underline'", "'none'", "'triangle'", "'diamond'", "'odiamond'", "'open'", "'empty'", "'metamodel'", "':'", "'{'", "'}'", "'('", "')'", "','", "'='", "'compartments'", "'shape'", "'color'", "'style'", "'edge'", "'label'", "'.'", "'src_decoration'", "'src_label'", "'tar_decoration'", "'tar_label'", "'text'", "'['", "']'", "'not'"
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

                if ( (LA2_1==30) ) {
                    alt2=1;
                }
                else if ( (LA2_1==40) ) {
                    alt2=2;
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


    // $ANTLR start "rule__NodeType__Alternatives"
    // InternalModelDraw.g:465:1: rule__NodeType__Alternatives : ( ( ( 'node' ) ) | ( ( 'markednode' ) ) );
    public final void rule__NodeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:469:1: ( ( ( 'node' ) ) | ( ( 'markednode' ) ) )
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
                    // InternalModelDraw.g:470:2: ( ( 'node' ) )
                    {
                    // InternalModelDraw.g:470:2: ( ( 'node' ) )
                    // InternalModelDraw.g:471:3: ( 'node' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:472:3: ( 'node' )
                    // InternalModelDraw.g:472:4: 'node'
                    {
                    match(input,13,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:476:2: ( ( 'markednode' ) )
                    {
                    // InternalModelDraw.g:476:2: ( ( 'markednode' ) )
                    // InternalModelDraw.g:477:3: ( 'markednode' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:478:3: ( 'markednode' )
                    // InternalModelDraw.g:478:4: 'markednode'
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
    // InternalModelDraw.g:486:1: rule__NodeShape__Alternatives : ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) );
    public final void rule__NodeShape__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:490:1: ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) | ( ( 'record' ) ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt4=1;
                }
                break;
            case 16:
                {
                alt4=2;
                }
                break;
            case 17:
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
                    // InternalModelDraw.g:491:2: ( ( 'circle' ) )
                    {
                    // InternalModelDraw.g:491:2: ( ( 'circle' ) )
                    // InternalModelDraw.g:492:3: ( 'circle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:493:3: ( 'circle' )
                    // InternalModelDraw.g:493:4: 'circle'
                    {
                    match(input,15,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:497:2: ( ( 'doublecircle' ) )
                    {
                    // InternalModelDraw.g:497:2: ( ( 'doublecircle' ) )
                    // InternalModelDraw.g:498:3: ( 'doublecircle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:499:3: ( 'doublecircle' )
                    // InternalModelDraw.g:499:4: 'doublecircle'
                    {
                    match(input,16,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:503:2: ( ( 'record' ) )
                    {
                    // InternalModelDraw.g:503:2: ( ( 'record' ) )
                    // InternalModelDraw.g:504:3: ( 'record' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getRecordEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:505:3: ( 'record' )
                    // InternalModelDraw.g:505:4: 'record'
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
    // InternalModelDraw.g:513:1: rule__NodeStyle__Alternatives : ( ( ( 'italic' ) ) | ( ( 'underline' ) ) );
    public final void rule__NodeStyle__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:517:1: ( ( ( 'italic' ) ) | ( ( 'underline' ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            else if ( (LA5_0==19) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalModelDraw.g:518:2: ( ( 'italic' ) )
                    {
                    // InternalModelDraw.g:518:2: ( ( 'italic' ) )
                    // InternalModelDraw.g:519:3: ( 'italic' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:520:3: ( 'italic' )
                    // InternalModelDraw.g:520:4: 'italic'
                    {
                    match(input,18,FOLLOW_2); 

                    }

                     after(grammarAccess.getNodeStyleAccess().getItalicEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:524:2: ( ( 'underline' ) )
                    {
                    // InternalModelDraw.g:524:2: ( ( 'underline' ) )
                    // InternalModelDraw.g:525:3: ( 'underline' )
                    {
                     before(grammarAccess.getNodeStyleAccess().getUnderlineEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:526:3: ( 'underline' )
                    // InternalModelDraw.g:526:4: 'underline'
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
    // InternalModelDraw.g:534:1: rule__Decoration__Alternatives : ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) );
    public final void rule__Decoration__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:538:1: ( ( ( 'none' ) ) | ( ( 'triangle' ) ) | ( ( 'diamond' ) ) | ( ( 'odiamond' ) ) | ( ( 'open' ) ) | ( ( 'empty' ) ) )
            int alt6=6;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt6=1;
                }
                break;
            case 21:
                {
                alt6=2;
                }
                break;
            case 22:
                {
                alt6=3;
                }
                break;
            case 23:
                {
                alt6=4;
                }
                break;
            case 24:
                {
                alt6=5;
                }
                break;
            case 25:
                {
                alt6=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalModelDraw.g:539:2: ( ( 'none' ) )
                    {
                    // InternalModelDraw.g:539:2: ( ( 'none' ) )
                    // InternalModelDraw.g:540:3: ( 'none' )
                    {
                     before(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 
                    // InternalModelDraw.g:541:3: ( 'none' )
                    // InternalModelDraw.g:541:4: 'none'
                    {
                    match(input,20,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getNoneEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalModelDraw.g:545:2: ( ( 'triangle' ) )
                    {
                    // InternalModelDraw.g:545:2: ( ( 'triangle' ) )
                    // InternalModelDraw.g:546:3: ( 'triangle' )
                    {
                     before(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 
                    // InternalModelDraw.g:547:3: ( 'triangle' )
                    // InternalModelDraw.g:547:4: 'triangle'
                    {
                    match(input,21,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getTriangleEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalModelDraw.g:551:2: ( ( 'diamond' ) )
                    {
                    // InternalModelDraw.g:551:2: ( ( 'diamond' ) )
                    // InternalModelDraw.g:552:3: ( 'diamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 
                    // InternalModelDraw.g:553:3: ( 'diamond' )
                    // InternalModelDraw.g:553:4: 'diamond'
                    {
                    match(input,22,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getDiamondEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalModelDraw.g:557:2: ( ( 'odiamond' ) )
                    {
                    // InternalModelDraw.g:557:2: ( ( 'odiamond' ) )
                    // InternalModelDraw.g:558:3: ( 'odiamond' )
                    {
                     before(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 
                    // InternalModelDraw.g:559:3: ( 'odiamond' )
                    // InternalModelDraw.g:559:4: 'odiamond'
                    {
                    match(input,23,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOdiamondEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalModelDraw.g:563:2: ( ( 'open' ) )
                    {
                    // InternalModelDraw.g:563:2: ( ( 'open' ) )
                    // InternalModelDraw.g:564:3: ( 'open' )
                    {
                     before(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 
                    // InternalModelDraw.g:565:3: ( 'open' )
                    // InternalModelDraw.g:565:4: 'open'
                    {
                    match(input,24,FOLLOW_2); 

                    }

                     after(grammarAccess.getDecorationAccess().getOpenEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalModelDraw.g:569:2: ( ( 'empty' ) )
                    {
                    // InternalModelDraw.g:569:2: ( ( 'empty' ) )
                    // InternalModelDraw.g:570:3: ( 'empty' )
                    {
                     before(grammarAccess.getDecorationAccess().getEmptyEnumLiteralDeclaration_5()); 
                    // InternalModelDraw.g:571:3: ( 'empty' )
                    // InternalModelDraw.g:571:4: 'empty'
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
    // InternalModelDraw.g:579:1: rule__MutatorDraw__Group__0 : rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 ;
    public final void rule__MutatorDraw__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:583:1: ( rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1 )
            // InternalModelDraw.g:584:2: rule__MutatorDraw__Group__0__Impl rule__MutatorDraw__Group__1
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
    // InternalModelDraw.g:591:1: rule__MutatorDraw__Group__0__Impl : ( () ) ;
    public final void rule__MutatorDraw__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:595:1: ( ( () ) )
            // InternalModelDraw.g:596:1: ( () )
            {
            // InternalModelDraw.g:596:1: ( () )
            // InternalModelDraw.g:597:2: ()
            {
             before(grammarAccess.getMutatorDrawAccess().getMutatorDrawAction_0()); 
            // InternalModelDraw.g:598:2: ()
            // InternalModelDraw.g:598:3: 
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
    // InternalModelDraw.g:606:1: rule__MutatorDraw__Group__1 : rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 ;
    public final void rule__MutatorDraw__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:610:1: ( rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2 )
            // InternalModelDraw.g:611:2: rule__MutatorDraw__Group__1__Impl rule__MutatorDraw__Group__2
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
    // InternalModelDraw.g:618:1: rule__MutatorDraw__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__MutatorDraw__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:622:1: ( ( 'metamodel' ) )
            // InternalModelDraw.g:623:1: ( 'metamodel' )
            {
            // InternalModelDraw.g:623:1: ( 'metamodel' )
            // InternalModelDraw.g:624:2: 'metamodel'
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
    // InternalModelDraw.g:633:1: rule__MutatorDraw__Group__2 : rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 ;
    public final void rule__MutatorDraw__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:637:1: ( rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3 )
            // InternalModelDraw.g:638:2: rule__MutatorDraw__Group__2__Impl rule__MutatorDraw__Group__3
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
    // InternalModelDraw.g:645:1: rule__MutatorDraw__Group__2__Impl : ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) ;
    public final void rule__MutatorDraw__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:649:1: ( ( ( rule__MutatorDraw__MetamodelAssignment_2 ) ) )
            // InternalModelDraw.g:650:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            {
            // InternalModelDraw.g:650:1: ( ( rule__MutatorDraw__MetamodelAssignment_2 ) )
            // InternalModelDraw.g:651:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            {
             before(grammarAccess.getMutatorDrawAccess().getMetamodelAssignment_2()); 
            // InternalModelDraw.g:652:2: ( rule__MutatorDraw__MetamodelAssignment_2 )
            // InternalModelDraw.g:652:3: rule__MutatorDraw__MetamodelAssignment_2
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
    // InternalModelDraw.g:660:1: rule__MutatorDraw__Group__3 : rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4 ;
    public final void rule__MutatorDraw__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:664:1: ( rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4 )
            // InternalModelDraw.g:665:2: rule__MutatorDraw__Group__3__Impl rule__MutatorDraw__Group__4
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
    // InternalModelDraw.g:672:1: rule__MutatorDraw__Group__3__Impl : ( ( rule__MutatorDraw__NameAssignment_3 ) ) ;
    public final void rule__MutatorDraw__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:676:1: ( ( ( rule__MutatorDraw__NameAssignment_3 ) ) )
            // InternalModelDraw.g:677:1: ( ( rule__MutatorDraw__NameAssignment_3 ) )
            {
            // InternalModelDraw.g:677:1: ( ( rule__MutatorDraw__NameAssignment_3 ) )
            // InternalModelDraw.g:678:2: ( rule__MutatorDraw__NameAssignment_3 )
            {
             before(grammarAccess.getMutatorDrawAccess().getNameAssignment_3()); 
            // InternalModelDraw.g:679:2: ( rule__MutatorDraw__NameAssignment_3 )
            // InternalModelDraw.g:679:3: rule__MutatorDraw__NameAssignment_3
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
    // InternalModelDraw.g:687:1: rule__MutatorDraw__Group__4 : rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5 ;
    public final void rule__MutatorDraw__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:691:1: ( rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5 )
            // InternalModelDraw.g:692:2: rule__MutatorDraw__Group__4__Impl rule__MutatorDraw__Group__5
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
    // InternalModelDraw.g:699:1: rule__MutatorDraw__Group__4__Impl : ( ':' ) ;
    public final void rule__MutatorDraw__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:703:1: ( ( ':' ) )
            // InternalModelDraw.g:704:1: ( ':' )
            {
            // InternalModelDraw.g:704:1: ( ':' )
            // InternalModelDraw.g:705:2: ':'
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
    // InternalModelDraw.g:714:1: rule__MutatorDraw__Group__5 : rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6 ;
    public final void rule__MutatorDraw__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:718:1: ( rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6 )
            // InternalModelDraw.g:719:2: rule__MutatorDraw__Group__5__Impl rule__MutatorDraw__Group__6
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
    // InternalModelDraw.g:726:1: rule__MutatorDraw__Group__5__Impl : ( ( rule__MutatorDraw__TypeAssignment_5 ) ) ;
    public final void rule__MutatorDraw__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:730:1: ( ( ( rule__MutatorDraw__TypeAssignment_5 ) ) )
            // InternalModelDraw.g:731:1: ( ( rule__MutatorDraw__TypeAssignment_5 ) )
            {
            // InternalModelDraw.g:731:1: ( ( rule__MutatorDraw__TypeAssignment_5 ) )
            // InternalModelDraw.g:732:2: ( rule__MutatorDraw__TypeAssignment_5 )
            {
             before(grammarAccess.getMutatorDrawAccess().getTypeAssignment_5()); 
            // InternalModelDraw.g:733:2: ( rule__MutatorDraw__TypeAssignment_5 )
            // InternalModelDraw.g:733:3: rule__MutatorDraw__TypeAssignment_5
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
    // InternalModelDraw.g:741:1: rule__MutatorDraw__Group__6 : rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7 ;
    public final void rule__MutatorDraw__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:745:1: ( rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7 )
            // InternalModelDraw.g:746:2: rule__MutatorDraw__Group__6__Impl rule__MutatorDraw__Group__7
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
    // InternalModelDraw.g:753:1: rule__MutatorDraw__Group__6__Impl : ( '{' ) ;
    public final void rule__MutatorDraw__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:757:1: ( ( '{' ) )
            // InternalModelDraw.g:758:1: ( '{' )
            {
            // InternalModelDraw.g:758:1: ( '{' )
            // InternalModelDraw.g:759:2: '{'
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
    // InternalModelDraw.g:768:1: rule__MutatorDraw__Group__7 : rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8 ;
    public final void rule__MutatorDraw__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:772:1: ( rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8 )
            // InternalModelDraw.g:773:2: rule__MutatorDraw__Group__7__Impl rule__MutatorDraw__Group__8
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
    // InternalModelDraw.g:780:1: rule__MutatorDraw__Group__7__Impl : ( ( rule__MutatorDraw__NodesAssignment_7 )* ) ;
    public final void rule__MutatorDraw__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:784:1: ( ( ( rule__MutatorDraw__NodesAssignment_7 )* ) )
            // InternalModelDraw.g:785:1: ( ( rule__MutatorDraw__NodesAssignment_7 )* )
            {
            // InternalModelDraw.g:785:1: ( ( rule__MutatorDraw__NodesAssignment_7 )* )
            // InternalModelDraw.g:786:2: ( rule__MutatorDraw__NodesAssignment_7 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getNodesAssignment_7()); 
            // InternalModelDraw.g:787:2: ( rule__MutatorDraw__NodesAssignment_7 )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // InternalModelDraw.g:787:3: rule__MutatorDraw__NodesAssignment_7
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__NodesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop7;
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
    // InternalModelDraw.g:795:1: rule__MutatorDraw__Group__8 : rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9 ;
    public final void rule__MutatorDraw__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:799:1: ( rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9 )
            // InternalModelDraw.g:800:2: rule__MutatorDraw__Group__8__Impl rule__MutatorDraw__Group__9
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
    // InternalModelDraw.g:807:1: rule__MutatorDraw__Group__8__Impl : ( ( rule__MutatorDraw__RelationsAssignment_8 )* ) ;
    public final void rule__MutatorDraw__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:811:1: ( ( ( rule__MutatorDraw__RelationsAssignment_8 )* ) )
            // InternalModelDraw.g:812:1: ( ( rule__MutatorDraw__RelationsAssignment_8 )* )
            {
            // InternalModelDraw.g:812:1: ( ( rule__MutatorDraw__RelationsAssignment_8 )* )
            // InternalModelDraw.g:813:2: ( rule__MutatorDraw__RelationsAssignment_8 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getRelationsAssignment_8()); 
            // InternalModelDraw.g:814:2: ( rule__MutatorDraw__RelationsAssignment_8 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==30||LA8_1==40) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // InternalModelDraw.g:814:3: rule__MutatorDraw__RelationsAssignment_8
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__RelationsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // InternalModelDraw.g:822:1: rule__MutatorDraw__Group__9 : rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10 ;
    public final void rule__MutatorDraw__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:826:1: ( rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10 )
            // InternalModelDraw.g:827:2: rule__MutatorDraw__Group__9__Impl rule__MutatorDraw__Group__10
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
    // InternalModelDraw.g:834:1: rule__MutatorDraw__Group__9__Impl : ( ( rule__MutatorDraw__ContentsAssignment_9 )* ) ;
    public final void rule__MutatorDraw__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:838:1: ( ( ( rule__MutatorDraw__ContentsAssignment_9 )* ) )
            // InternalModelDraw.g:839:1: ( ( rule__MutatorDraw__ContentsAssignment_9 )* )
            {
            // InternalModelDraw.g:839:1: ( ( rule__MutatorDraw__ContentsAssignment_9 )* )
            // InternalModelDraw.g:840:2: ( rule__MutatorDraw__ContentsAssignment_9 )*
            {
             before(grammarAccess.getMutatorDrawAccess().getContentsAssignment_9()); 
            // InternalModelDraw.g:841:2: ( rule__MutatorDraw__ContentsAssignment_9 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_ID) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalModelDraw.g:841:3: rule__MutatorDraw__ContentsAssignment_9
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__MutatorDraw__ContentsAssignment_9();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // InternalModelDraw.g:849:1: rule__MutatorDraw__Group__10 : rule__MutatorDraw__Group__10__Impl ;
    public final void rule__MutatorDraw__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:853:1: ( rule__MutatorDraw__Group__10__Impl )
            // InternalModelDraw.g:854:2: rule__MutatorDraw__Group__10__Impl
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
    // InternalModelDraw.g:860:1: rule__MutatorDraw__Group__10__Impl : ( '}' ) ;
    public final void rule__MutatorDraw__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:864:1: ( ( '}' ) )
            // InternalModelDraw.g:865:1: ( '}' )
            {
            // InternalModelDraw.g:865:1: ( '}' )
            // InternalModelDraw.g:866:2: '}'
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
    // InternalModelDraw.g:876:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:880:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // InternalModelDraw.g:881:2: rule__Node__Group__0__Impl rule__Node__Group__1
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
    // InternalModelDraw.g:888:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:892:1: ( ( () ) )
            // InternalModelDraw.g:893:1: ( () )
            {
            // InternalModelDraw.g:893:1: ( () )
            // InternalModelDraw.g:894:2: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // InternalModelDraw.g:895:2: ()
            // InternalModelDraw.g:895:3: 
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
    // InternalModelDraw.g:903:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:907:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // InternalModelDraw.g:908:2: rule__Node__Group__1__Impl rule__Node__Group__2
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
    // InternalModelDraw.g:915:1: rule__Node__Group__1__Impl : ( ( rule__Node__NameAssignment_1 ) ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:919:1: ( ( ( rule__Node__NameAssignment_1 ) ) )
            // InternalModelDraw.g:920:1: ( ( rule__Node__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:920:1: ( ( rule__Node__NameAssignment_1 ) )
            // InternalModelDraw.g:921:2: ( rule__Node__NameAssignment_1 )
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:922:2: ( rule__Node__NameAssignment_1 )
            // InternalModelDraw.g:922:3: rule__Node__NameAssignment_1
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
    // InternalModelDraw.g:930:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:934:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // InternalModelDraw.g:935:2: rule__Node__Group__2__Impl rule__Node__Group__3
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
    // InternalModelDraw.g:942:1: rule__Node__Group__2__Impl : ( ( rule__Node__Group_2__0 )? ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:946:1: ( ( ( rule__Node__Group_2__0 )? ) )
            // InternalModelDraw.g:947:1: ( ( rule__Node__Group_2__0 )? )
            {
            // InternalModelDraw.g:947:1: ( ( rule__Node__Group_2__0 )? )
            // InternalModelDraw.g:948:2: ( rule__Node__Group_2__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_2()); 
            // InternalModelDraw.g:949:2: ( rule__Node__Group_2__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==30) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalModelDraw.g:949:3: rule__Node__Group_2__0
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
    // InternalModelDraw.g:957:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:961:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // InternalModelDraw.g:962:2: rule__Node__Group__3__Impl rule__Node__Group__4
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
    // InternalModelDraw.g:969:1: rule__Node__Group__3__Impl : ( ':' ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:973:1: ( ( ':' ) )
            // InternalModelDraw.g:974:1: ( ':' )
            {
            // InternalModelDraw.g:974:1: ( ':' )
            // InternalModelDraw.g:975:2: ':'
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
    // InternalModelDraw.g:984:1: rule__Node__Group__4 : rule__Node__Group__4__Impl rule__Node__Group__5 ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:988:1: ( rule__Node__Group__4__Impl rule__Node__Group__5 )
            // InternalModelDraw.g:989:2: rule__Node__Group__4__Impl rule__Node__Group__5
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
    // InternalModelDraw.g:996:1: rule__Node__Group__4__Impl : ( ( rule__Node__TypeAssignment_4 ) ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1000:1: ( ( ( rule__Node__TypeAssignment_4 ) ) )
            // InternalModelDraw.g:1001:1: ( ( rule__Node__TypeAssignment_4 ) )
            {
            // InternalModelDraw.g:1001:1: ( ( rule__Node__TypeAssignment_4 ) )
            // InternalModelDraw.g:1002:2: ( rule__Node__TypeAssignment_4 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_4()); 
            // InternalModelDraw.g:1003:2: ( rule__Node__TypeAssignment_4 )
            // InternalModelDraw.g:1003:3: rule__Node__TypeAssignment_4
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
    // InternalModelDraw.g:1011:1: rule__Node__Group__5 : rule__Node__Group__5__Impl rule__Node__Group__6 ;
    public final void rule__Node__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1015:1: ( rule__Node__Group__5__Impl rule__Node__Group__6 )
            // InternalModelDraw.g:1016:2: rule__Node__Group__5__Impl rule__Node__Group__6
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
    // InternalModelDraw.g:1023:1: rule__Node__Group__5__Impl : ( ( rule__Node__Group_5__0 )? ) ;
    public final void rule__Node__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1027:1: ( ( ( rule__Node__Group_5__0 )? ) )
            // InternalModelDraw.g:1028:1: ( ( rule__Node__Group_5__0 )? )
            {
            // InternalModelDraw.g:1028:1: ( ( rule__Node__Group_5__0 )? )
            // InternalModelDraw.g:1029:2: ( rule__Node__Group_5__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_5()); 
            // InternalModelDraw.g:1030:2: ( rule__Node__Group_5__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==33) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalModelDraw.g:1030:3: rule__Node__Group_5__0
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
    // InternalModelDraw.g:1038:1: rule__Node__Group__6 : rule__Node__Group__6__Impl rule__Node__Group__7 ;
    public final void rule__Node__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1042:1: ( rule__Node__Group__6__Impl rule__Node__Group__7 )
            // InternalModelDraw.g:1043:2: rule__Node__Group__6__Impl rule__Node__Group__7
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
    // InternalModelDraw.g:1050:1: rule__Node__Group__6__Impl : ( ( rule__Node__Group_6__0 )? ) ;
    public final void rule__Node__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1054:1: ( ( ( rule__Node__Group_6__0 )? ) )
            // InternalModelDraw.g:1055:1: ( ( rule__Node__Group_6__0 )? )
            {
            // InternalModelDraw.g:1055:1: ( ( rule__Node__Group_6__0 )? )
            // InternalModelDraw.g:1056:2: ( rule__Node__Group_6__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_6()); 
            // InternalModelDraw.g:1057:2: ( rule__Node__Group_6__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==34) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalModelDraw.g:1057:3: rule__Node__Group_6__0
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
    // InternalModelDraw.g:1065:1: rule__Node__Group__7 : rule__Node__Group__7__Impl rule__Node__Group__8 ;
    public final void rule__Node__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1069:1: ( rule__Node__Group__7__Impl rule__Node__Group__8 )
            // InternalModelDraw.g:1070:2: rule__Node__Group__7__Impl rule__Node__Group__8
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
    // InternalModelDraw.g:1077:1: rule__Node__Group__7__Impl : ( ( rule__Node__Group_7__0 )? ) ;
    public final void rule__Node__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1081:1: ( ( ( rule__Node__Group_7__0 )? ) )
            // InternalModelDraw.g:1082:1: ( ( rule__Node__Group_7__0 )? )
            {
            // InternalModelDraw.g:1082:1: ( ( rule__Node__Group_7__0 )? )
            // InternalModelDraw.g:1083:2: ( rule__Node__Group_7__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_7()); 
            // InternalModelDraw.g:1084:2: ( rule__Node__Group_7__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==35) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalModelDraw.g:1084:3: rule__Node__Group_7__0
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
    // InternalModelDraw.g:1092:1: rule__Node__Group__8 : rule__Node__Group__8__Impl rule__Node__Group__9 ;
    public final void rule__Node__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1096:1: ( rule__Node__Group__8__Impl rule__Node__Group__9 )
            // InternalModelDraw.g:1097:2: rule__Node__Group__8__Impl rule__Node__Group__9
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
    // InternalModelDraw.g:1104:1: rule__Node__Group__8__Impl : ( ( rule__Node__Group_8__0 )? ) ;
    public final void rule__Node__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1108:1: ( ( ( rule__Node__Group_8__0 )? ) )
            // InternalModelDraw.g:1109:1: ( ( rule__Node__Group_8__0 )? )
            {
            // InternalModelDraw.g:1109:1: ( ( rule__Node__Group_8__0 )? )
            // InternalModelDraw.g:1110:2: ( rule__Node__Group_8__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_8()); 
            // InternalModelDraw.g:1111:2: ( rule__Node__Group_8__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==36) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalModelDraw.g:1111:3: rule__Node__Group_8__0
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
    // InternalModelDraw.g:1119:1: rule__Node__Group__9 : rule__Node__Group__9__Impl ;
    public final void rule__Node__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1123:1: ( rule__Node__Group__9__Impl )
            // InternalModelDraw.g:1124:2: rule__Node__Group__9__Impl
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
    // InternalModelDraw.g:1130:1: rule__Node__Group__9__Impl : ( ( rule__Node__Group_9__0 )? ) ;
    public final void rule__Node__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1134:1: ( ( ( rule__Node__Group_9__0 )? ) )
            // InternalModelDraw.g:1135:1: ( ( rule__Node__Group_9__0 )? )
            {
            // InternalModelDraw.g:1135:1: ( ( rule__Node__Group_9__0 )? )
            // InternalModelDraw.g:1136:2: ( rule__Node__Group_9__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_9()); 
            // InternalModelDraw.g:1137:2: ( rule__Node__Group_9__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==37) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalModelDraw.g:1137:3: rule__Node__Group_9__0
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
    // InternalModelDraw.g:1146:1: rule__Node__Group_2__0 : rule__Node__Group_2__0__Impl rule__Node__Group_2__1 ;
    public final void rule__Node__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1150:1: ( rule__Node__Group_2__0__Impl rule__Node__Group_2__1 )
            // InternalModelDraw.g:1151:2: rule__Node__Group_2__0__Impl rule__Node__Group_2__1
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
    // InternalModelDraw.g:1158:1: rule__Node__Group_2__0__Impl : ( '(' ) ;
    public final void rule__Node__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1162:1: ( ( '(' ) )
            // InternalModelDraw.g:1163:1: ( '(' )
            {
            // InternalModelDraw.g:1163:1: ( '(' )
            // InternalModelDraw.g:1164:2: '('
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
    // InternalModelDraw.g:1173:1: rule__Node__Group_2__1 : rule__Node__Group_2__1__Impl rule__Node__Group_2__2 ;
    public final void rule__Node__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1177:1: ( rule__Node__Group_2__1__Impl rule__Node__Group_2__2 )
            // InternalModelDraw.g:1178:2: rule__Node__Group_2__1__Impl rule__Node__Group_2__2
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
    // InternalModelDraw.g:1185:1: rule__Node__Group_2__1__Impl : ( ( rule__Node__AttributeAssignment_2_1 ) ) ;
    public final void rule__Node__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1189:1: ( ( ( rule__Node__AttributeAssignment_2_1 ) ) )
            // InternalModelDraw.g:1190:1: ( ( rule__Node__AttributeAssignment_2_1 ) )
            {
            // InternalModelDraw.g:1190:1: ( ( rule__Node__AttributeAssignment_2_1 ) )
            // InternalModelDraw.g:1191:2: ( rule__Node__AttributeAssignment_2_1 )
            {
             before(grammarAccess.getNodeAccess().getAttributeAssignment_2_1()); 
            // InternalModelDraw.g:1192:2: ( rule__Node__AttributeAssignment_2_1 )
            // InternalModelDraw.g:1192:3: rule__Node__AttributeAssignment_2_1
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
    // InternalModelDraw.g:1200:1: rule__Node__Group_2__2 : rule__Node__Group_2__2__Impl rule__Node__Group_2__3 ;
    public final void rule__Node__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1204:1: ( rule__Node__Group_2__2__Impl rule__Node__Group_2__3 )
            // InternalModelDraw.g:1205:2: rule__Node__Group_2__2__Impl rule__Node__Group_2__3
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
    // InternalModelDraw.g:1212:1: rule__Node__Group_2__2__Impl : ( ( rule__Node__Group_2_2__0 )* ) ;
    public final void rule__Node__Group_2__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1216:1: ( ( ( rule__Node__Group_2_2__0 )* ) )
            // InternalModelDraw.g:1217:1: ( ( rule__Node__Group_2_2__0 )* )
            {
            // InternalModelDraw.g:1217:1: ( ( rule__Node__Group_2_2__0 )* )
            // InternalModelDraw.g:1218:2: ( rule__Node__Group_2_2__0 )*
            {
             before(grammarAccess.getNodeAccess().getGroup_2_2()); 
            // InternalModelDraw.g:1219:2: ( rule__Node__Group_2_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==32) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalModelDraw.g:1219:3: rule__Node__Group_2_2__0
            	    {
            	    pushFollow(FOLLOW_16);
            	    rule__Node__Group_2_2__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // InternalModelDraw.g:1227:1: rule__Node__Group_2__3 : rule__Node__Group_2__3__Impl ;
    public final void rule__Node__Group_2__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1231:1: ( rule__Node__Group_2__3__Impl )
            // InternalModelDraw.g:1232:2: rule__Node__Group_2__3__Impl
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
    // InternalModelDraw.g:1238:1: rule__Node__Group_2__3__Impl : ( ')' ) ;
    public final void rule__Node__Group_2__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1242:1: ( ( ')' ) )
            // InternalModelDraw.g:1243:1: ( ')' )
            {
            // InternalModelDraw.g:1243:1: ( ')' )
            // InternalModelDraw.g:1244:2: ')'
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
    // InternalModelDraw.g:1254:1: rule__Node__Group_2_2__0 : rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 ;
    public final void rule__Node__Group_2_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1258:1: ( rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1 )
            // InternalModelDraw.g:1259:2: rule__Node__Group_2_2__0__Impl rule__Node__Group_2_2__1
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
    // InternalModelDraw.g:1266:1: rule__Node__Group_2_2__0__Impl : ( ',' ) ;
    public final void rule__Node__Group_2_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1270:1: ( ( ',' ) )
            // InternalModelDraw.g:1271:1: ( ',' )
            {
            // InternalModelDraw.g:1271:1: ( ',' )
            // InternalModelDraw.g:1272:2: ','
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
    // InternalModelDraw.g:1281:1: rule__Node__Group_2_2__1 : rule__Node__Group_2_2__1__Impl ;
    public final void rule__Node__Group_2_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1285:1: ( rule__Node__Group_2_2__1__Impl )
            // InternalModelDraw.g:1286:2: rule__Node__Group_2_2__1__Impl
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
    // InternalModelDraw.g:1292:1: rule__Node__Group_2_2__1__Impl : ( ( rule__Node__AttributeAssignment_2_2_1 ) ) ;
    public final void rule__Node__Group_2_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1296:1: ( ( ( rule__Node__AttributeAssignment_2_2_1 ) ) )
            // InternalModelDraw.g:1297:1: ( ( rule__Node__AttributeAssignment_2_2_1 ) )
            {
            // InternalModelDraw.g:1297:1: ( ( rule__Node__AttributeAssignment_2_2_1 ) )
            // InternalModelDraw.g:1298:2: ( rule__Node__AttributeAssignment_2_2_1 )
            {
             before(grammarAccess.getNodeAccess().getAttributeAssignment_2_2_1()); 
            // InternalModelDraw.g:1299:2: ( rule__Node__AttributeAssignment_2_2_1 )
            // InternalModelDraw.g:1299:3: rule__Node__AttributeAssignment_2_2_1
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
    // InternalModelDraw.g:1308:1: rule__Node__Group_5__0 : rule__Node__Group_5__0__Impl rule__Node__Group_5__1 ;
    public final void rule__Node__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1312:1: ( rule__Node__Group_5__0__Impl rule__Node__Group_5__1 )
            // InternalModelDraw.g:1313:2: rule__Node__Group_5__0__Impl rule__Node__Group_5__1
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
    // InternalModelDraw.g:1320:1: rule__Node__Group_5__0__Impl : ( '=' ) ;
    public final void rule__Node__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1324:1: ( ( '=' ) )
            // InternalModelDraw.g:1325:1: ( '=' )
            {
            // InternalModelDraw.g:1325:1: ( '=' )
            // InternalModelDraw.g:1326:2: '='
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
    // InternalModelDraw.g:1335:1: rule__Node__Group_5__1 : rule__Node__Group_5__1__Impl ;
    public final void rule__Node__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1339:1: ( rule__Node__Group_5__1__Impl )
            // InternalModelDraw.g:1340:2: rule__Node__Group_5__1__Impl
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
    // InternalModelDraw.g:1346:1: rule__Node__Group_5__1__Impl : ( ( rule__Node__AttNameAssignment_5_1 ) ) ;
    public final void rule__Node__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1350:1: ( ( ( rule__Node__AttNameAssignment_5_1 ) ) )
            // InternalModelDraw.g:1351:1: ( ( rule__Node__AttNameAssignment_5_1 ) )
            {
            // InternalModelDraw.g:1351:1: ( ( rule__Node__AttNameAssignment_5_1 ) )
            // InternalModelDraw.g:1352:2: ( rule__Node__AttNameAssignment_5_1 )
            {
             before(grammarAccess.getNodeAccess().getAttNameAssignment_5_1()); 
            // InternalModelDraw.g:1353:2: ( rule__Node__AttNameAssignment_5_1 )
            // InternalModelDraw.g:1353:3: rule__Node__AttNameAssignment_5_1
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
    // InternalModelDraw.g:1362:1: rule__Node__Group_6__0 : rule__Node__Group_6__0__Impl rule__Node__Group_6__1 ;
    public final void rule__Node__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1366:1: ( rule__Node__Group_6__0__Impl rule__Node__Group_6__1 )
            // InternalModelDraw.g:1367:2: rule__Node__Group_6__0__Impl rule__Node__Group_6__1
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
    // InternalModelDraw.g:1374:1: rule__Node__Group_6__0__Impl : ( 'compartments' ) ;
    public final void rule__Node__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1378:1: ( ( 'compartments' ) )
            // InternalModelDraw.g:1379:1: ( 'compartments' )
            {
            // InternalModelDraw.g:1379:1: ( 'compartments' )
            // InternalModelDraw.g:1380:2: 'compartments'
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
    // InternalModelDraw.g:1389:1: rule__Node__Group_6__1 : rule__Node__Group_6__1__Impl rule__Node__Group_6__2 ;
    public final void rule__Node__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1393:1: ( rule__Node__Group_6__1__Impl rule__Node__Group_6__2 )
            // InternalModelDraw.g:1394:2: rule__Node__Group_6__1__Impl rule__Node__Group_6__2
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
    // InternalModelDraw.g:1401:1: rule__Node__Group_6__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1405:1: ( ( '=' ) )
            // InternalModelDraw.g:1406:1: ( '=' )
            {
            // InternalModelDraw.g:1406:1: ( '=' )
            // InternalModelDraw.g:1407:2: '='
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
    // InternalModelDraw.g:1416:1: rule__Node__Group_6__2 : rule__Node__Group_6__2__Impl rule__Node__Group_6__3 ;
    public final void rule__Node__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1420:1: ( rule__Node__Group_6__2__Impl rule__Node__Group_6__3 )
            // InternalModelDraw.g:1421:2: rule__Node__Group_6__2__Impl rule__Node__Group_6__3
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
    // InternalModelDraw.g:1428:1: rule__Node__Group_6__2__Impl : ( '{' ) ;
    public final void rule__Node__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1432:1: ( ( '{' ) )
            // InternalModelDraw.g:1433:1: ( '{' )
            {
            // InternalModelDraw.g:1433:1: ( '{' )
            // InternalModelDraw.g:1434:2: '{'
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
    // InternalModelDraw.g:1443:1: rule__Node__Group_6__3 : rule__Node__Group_6__3__Impl rule__Node__Group_6__4 ;
    public final void rule__Node__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1447:1: ( rule__Node__Group_6__3__Impl rule__Node__Group_6__4 )
            // InternalModelDraw.g:1448:2: rule__Node__Group_6__3__Impl rule__Node__Group_6__4
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
    // InternalModelDraw.g:1455:1: rule__Node__Group_6__3__Impl : ( ( rule__Node__ReferenceAssignment_6_3 ) ) ;
    public final void rule__Node__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1459:1: ( ( ( rule__Node__ReferenceAssignment_6_3 ) ) )
            // InternalModelDraw.g:1460:1: ( ( rule__Node__ReferenceAssignment_6_3 ) )
            {
            // InternalModelDraw.g:1460:1: ( ( rule__Node__ReferenceAssignment_6_3 ) )
            // InternalModelDraw.g:1461:2: ( rule__Node__ReferenceAssignment_6_3 )
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_6_3()); 
            // InternalModelDraw.g:1462:2: ( rule__Node__ReferenceAssignment_6_3 )
            // InternalModelDraw.g:1462:3: rule__Node__ReferenceAssignment_6_3
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
    // InternalModelDraw.g:1470:1: rule__Node__Group_6__4 : rule__Node__Group_6__4__Impl rule__Node__Group_6__5 ;
    public final void rule__Node__Group_6__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1474:1: ( rule__Node__Group_6__4__Impl rule__Node__Group_6__5 )
            // InternalModelDraw.g:1475:2: rule__Node__Group_6__4__Impl rule__Node__Group_6__5
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
    // InternalModelDraw.g:1482:1: rule__Node__Group_6__4__Impl : ( ( rule__Node__ReferenceAssignment_6_4 )* ) ;
    public final void rule__Node__Group_6__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1486:1: ( ( ( rule__Node__ReferenceAssignment_6_4 )* ) )
            // InternalModelDraw.g:1487:1: ( ( rule__Node__ReferenceAssignment_6_4 )* )
            {
            // InternalModelDraw.g:1487:1: ( ( rule__Node__ReferenceAssignment_6_4 )* )
            // InternalModelDraw.g:1488:2: ( rule__Node__ReferenceAssignment_6_4 )*
            {
             before(grammarAccess.getNodeAccess().getReferenceAssignment_6_4()); 
            // InternalModelDraw.g:1489:2: ( rule__Node__ReferenceAssignment_6_4 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalModelDraw.g:1489:3: rule__Node__ReferenceAssignment_6_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Node__ReferenceAssignment_6_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // InternalModelDraw.g:1497:1: rule__Node__Group_6__5 : rule__Node__Group_6__5__Impl ;
    public final void rule__Node__Group_6__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1501:1: ( rule__Node__Group_6__5__Impl )
            // InternalModelDraw.g:1502:2: rule__Node__Group_6__5__Impl
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
    // InternalModelDraw.g:1508:1: rule__Node__Group_6__5__Impl : ( '}' ) ;
    public final void rule__Node__Group_6__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1512:1: ( ( '}' ) )
            // InternalModelDraw.g:1513:1: ( '}' )
            {
            // InternalModelDraw.g:1513:1: ( '}' )
            // InternalModelDraw.g:1514:2: '}'
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
    // InternalModelDraw.g:1524:1: rule__Node__Group_7__0 : rule__Node__Group_7__0__Impl rule__Node__Group_7__1 ;
    public final void rule__Node__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1528:1: ( rule__Node__Group_7__0__Impl rule__Node__Group_7__1 )
            // InternalModelDraw.g:1529:2: rule__Node__Group_7__0__Impl rule__Node__Group_7__1
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
    // InternalModelDraw.g:1536:1: rule__Node__Group_7__0__Impl : ( 'shape' ) ;
    public final void rule__Node__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1540:1: ( ( 'shape' ) )
            // InternalModelDraw.g:1541:1: ( 'shape' )
            {
            // InternalModelDraw.g:1541:1: ( 'shape' )
            // InternalModelDraw.g:1542:2: 'shape'
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
    // InternalModelDraw.g:1551:1: rule__Node__Group_7__1 : rule__Node__Group_7__1__Impl rule__Node__Group_7__2 ;
    public final void rule__Node__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1555:1: ( rule__Node__Group_7__1__Impl rule__Node__Group_7__2 )
            // InternalModelDraw.g:1556:2: rule__Node__Group_7__1__Impl rule__Node__Group_7__2
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
    // InternalModelDraw.g:1563:1: rule__Node__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1567:1: ( ( '=' ) )
            // InternalModelDraw.g:1568:1: ( '=' )
            {
            // InternalModelDraw.g:1568:1: ( '=' )
            // InternalModelDraw.g:1569:2: '='
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
    // InternalModelDraw.g:1578:1: rule__Node__Group_7__2 : rule__Node__Group_7__2__Impl ;
    public final void rule__Node__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1582:1: ( rule__Node__Group_7__2__Impl )
            // InternalModelDraw.g:1583:2: rule__Node__Group_7__2__Impl
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
    // InternalModelDraw.g:1589:1: rule__Node__Group_7__2__Impl : ( ( rule__Node__ShapeAssignment_7_2 ) ) ;
    public final void rule__Node__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1593:1: ( ( ( rule__Node__ShapeAssignment_7_2 ) ) )
            // InternalModelDraw.g:1594:1: ( ( rule__Node__ShapeAssignment_7_2 ) )
            {
            // InternalModelDraw.g:1594:1: ( ( rule__Node__ShapeAssignment_7_2 ) )
            // InternalModelDraw.g:1595:2: ( rule__Node__ShapeAssignment_7_2 )
            {
             before(grammarAccess.getNodeAccess().getShapeAssignment_7_2()); 
            // InternalModelDraw.g:1596:2: ( rule__Node__ShapeAssignment_7_2 )
            // InternalModelDraw.g:1596:3: rule__Node__ShapeAssignment_7_2
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
    // InternalModelDraw.g:1605:1: rule__Node__Group_8__0 : rule__Node__Group_8__0__Impl rule__Node__Group_8__1 ;
    public final void rule__Node__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1609:1: ( rule__Node__Group_8__0__Impl rule__Node__Group_8__1 )
            // InternalModelDraw.g:1610:2: rule__Node__Group_8__0__Impl rule__Node__Group_8__1
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
    // InternalModelDraw.g:1617:1: rule__Node__Group_8__0__Impl : ( 'color' ) ;
    public final void rule__Node__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1621:1: ( ( 'color' ) )
            // InternalModelDraw.g:1622:1: ( 'color' )
            {
            // InternalModelDraw.g:1622:1: ( 'color' )
            // InternalModelDraw.g:1623:2: 'color'
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
    // InternalModelDraw.g:1632:1: rule__Node__Group_8__1 : rule__Node__Group_8__1__Impl rule__Node__Group_8__2 ;
    public final void rule__Node__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1636:1: ( rule__Node__Group_8__1__Impl rule__Node__Group_8__2 )
            // InternalModelDraw.g:1637:2: rule__Node__Group_8__1__Impl rule__Node__Group_8__2
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
    // InternalModelDraw.g:1644:1: rule__Node__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1648:1: ( ( '=' ) )
            // InternalModelDraw.g:1649:1: ( '=' )
            {
            // InternalModelDraw.g:1649:1: ( '=' )
            // InternalModelDraw.g:1650:2: '='
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
    // InternalModelDraw.g:1659:1: rule__Node__Group_8__2 : rule__Node__Group_8__2__Impl ;
    public final void rule__Node__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1663:1: ( rule__Node__Group_8__2__Impl )
            // InternalModelDraw.g:1664:2: rule__Node__Group_8__2__Impl
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
    // InternalModelDraw.g:1670:1: rule__Node__Group_8__2__Impl : ( ( rule__Node__ColorAssignment_8_2 ) ) ;
    public final void rule__Node__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1674:1: ( ( ( rule__Node__ColorAssignment_8_2 ) ) )
            // InternalModelDraw.g:1675:1: ( ( rule__Node__ColorAssignment_8_2 ) )
            {
            // InternalModelDraw.g:1675:1: ( ( rule__Node__ColorAssignment_8_2 ) )
            // InternalModelDraw.g:1676:2: ( rule__Node__ColorAssignment_8_2 )
            {
             before(grammarAccess.getNodeAccess().getColorAssignment_8_2()); 
            // InternalModelDraw.g:1677:2: ( rule__Node__ColorAssignment_8_2 )
            // InternalModelDraw.g:1677:3: rule__Node__ColorAssignment_8_2
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
    // InternalModelDraw.g:1686:1: rule__Node__Group_9__0 : rule__Node__Group_9__0__Impl rule__Node__Group_9__1 ;
    public final void rule__Node__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1690:1: ( rule__Node__Group_9__0__Impl rule__Node__Group_9__1 )
            // InternalModelDraw.g:1691:2: rule__Node__Group_9__0__Impl rule__Node__Group_9__1
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
    // InternalModelDraw.g:1698:1: rule__Node__Group_9__0__Impl : ( 'style' ) ;
    public final void rule__Node__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1702:1: ( ( 'style' ) )
            // InternalModelDraw.g:1703:1: ( 'style' )
            {
            // InternalModelDraw.g:1703:1: ( 'style' )
            // InternalModelDraw.g:1704:2: 'style'
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
    // InternalModelDraw.g:1713:1: rule__Node__Group_9__1 : rule__Node__Group_9__1__Impl rule__Node__Group_9__2 ;
    public final void rule__Node__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1717:1: ( rule__Node__Group_9__1__Impl rule__Node__Group_9__2 )
            // InternalModelDraw.g:1718:2: rule__Node__Group_9__1__Impl rule__Node__Group_9__2
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
    // InternalModelDraw.g:1725:1: rule__Node__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Node__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1729:1: ( ( '=' ) )
            // InternalModelDraw.g:1730:1: ( '=' )
            {
            // InternalModelDraw.g:1730:1: ( '=' )
            // InternalModelDraw.g:1731:2: '='
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
    // InternalModelDraw.g:1740:1: rule__Node__Group_9__2 : rule__Node__Group_9__2__Impl ;
    public final void rule__Node__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1744:1: ( rule__Node__Group_9__2__Impl )
            // InternalModelDraw.g:1745:2: rule__Node__Group_9__2__Impl
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
    // InternalModelDraw.g:1751:1: rule__Node__Group_9__2__Impl : ( ( rule__Node__StyleAssignment_9_2 ) ) ;
    public final void rule__Node__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1755:1: ( ( ( rule__Node__StyleAssignment_9_2 ) ) )
            // InternalModelDraw.g:1756:1: ( ( rule__Node__StyleAssignment_9_2 ) )
            {
            // InternalModelDraw.g:1756:1: ( ( rule__Node__StyleAssignment_9_2 ) )
            // InternalModelDraw.g:1757:2: ( rule__Node__StyleAssignment_9_2 )
            {
             before(grammarAccess.getNodeAccess().getStyleAssignment_9_2()); 
            // InternalModelDraw.g:1758:2: ( rule__Node__StyleAssignment_9_2 )
            // InternalModelDraw.g:1758:3: rule__Node__StyleAssignment_9_2
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
    // InternalModelDraw.g:1767:1: rule__BooleanAttribute__Group__0 : rule__BooleanAttribute__Group__0__Impl rule__BooleanAttribute__Group__1 ;
    public final void rule__BooleanAttribute__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1771:1: ( rule__BooleanAttribute__Group__0__Impl rule__BooleanAttribute__Group__1 )
            // InternalModelDraw.g:1772:2: rule__BooleanAttribute__Group__0__Impl rule__BooleanAttribute__Group__1
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
    // InternalModelDraw.g:1779:1: rule__BooleanAttribute__Group__0__Impl : ( () ) ;
    public final void rule__BooleanAttribute__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1783:1: ( ( () ) )
            // InternalModelDraw.g:1784:1: ( () )
            {
            // InternalModelDraw.g:1784:1: ( () )
            // InternalModelDraw.g:1785:2: ()
            {
             before(grammarAccess.getBooleanAttributeAccess().getBooleanAttributeAction_0()); 
            // InternalModelDraw.g:1786:2: ()
            // InternalModelDraw.g:1786:3: 
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
    // InternalModelDraw.g:1794:1: rule__BooleanAttribute__Group__1 : rule__BooleanAttribute__Group__1__Impl rule__BooleanAttribute__Group__2 ;
    public final void rule__BooleanAttribute__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1798:1: ( rule__BooleanAttribute__Group__1__Impl rule__BooleanAttribute__Group__2 )
            // InternalModelDraw.g:1799:2: rule__BooleanAttribute__Group__1__Impl rule__BooleanAttribute__Group__2
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
    // InternalModelDraw.g:1806:1: rule__BooleanAttribute__Group__1__Impl : ( ( rule__BooleanAttribute__NegationAssignment_1 )? ) ;
    public final void rule__BooleanAttribute__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1810:1: ( ( ( rule__BooleanAttribute__NegationAssignment_1 )? ) )
            // InternalModelDraw.g:1811:1: ( ( rule__BooleanAttribute__NegationAssignment_1 )? )
            {
            // InternalModelDraw.g:1811:1: ( ( rule__BooleanAttribute__NegationAssignment_1 )? )
            // InternalModelDraw.g:1812:2: ( rule__BooleanAttribute__NegationAssignment_1 )?
            {
             before(grammarAccess.getBooleanAttributeAccess().getNegationAssignment_1()); 
            // InternalModelDraw.g:1813:2: ( rule__BooleanAttribute__NegationAssignment_1 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==48) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalModelDraw.g:1813:3: rule__BooleanAttribute__NegationAssignment_1
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
    // InternalModelDraw.g:1821:1: rule__BooleanAttribute__Group__2 : rule__BooleanAttribute__Group__2__Impl ;
    public final void rule__BooleanAttribute__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1825:1: ( rule__BooleanAttribute__Group__2__Impl )
            // InternalModelDraw.g:1826:2: rule__BooleanAttribute__Group__2__Impl
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
    // InternalModelDraw.g:1832:1: rule__BooleanAttribute__Group__2__Impl : ( ( rule__BooleanAttribute__AttAssignment_2 ) ) ;
    public final void rule__BooleanAttribute__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1836:1: ( ( ( rule__BooleanAttribute__AttAssignment_2 ) ) )
            // InternalModelDraw.g:1837:1: ( ( rule__BooleanAttribute__AttAssignment_2 ) )
            {
            // InternalModelDraw.g:1837:1: ( ( rule__BooleanAttribute__AttAssignment_2 ) )
            // InternalModelDraw.g:1838:2: ( rule__BooleanAttribute__AttAssignment_2 )
            {
             before(grammarAccess.getBooleanAttributeAccess().getAttAssignment_2()); 
            // InternalModelDraw.g:1839:2: ( rule__BooleanAttribute__AttAssignment_2 )
            // InternalModelDraw.g:1839:3: rule__BooleanAttribute__AttAssignment_2
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
    // InternalModelDraw.g:1848:1: rule__Edge__Group__0 : rule__Edge__Group__0__Impl rule__Edge__Group__1 ;
    public final void rule__Edge__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1852:1: ( rule__Edge__Group__0__Impl rule__Edge__Group__1 )
            // InternalModelDraw.g:1853:2: rule__Edge__Group__0__Impl rule__Edge__Group__1
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
    // InternalModelDraw.g:1860:1: rule__Edge__Group__0__Impl : ( () ) ;
    public final void rule__Edge__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1864:1: ( ( () ) )
            // InternalModelDraw.g:1865:1: ( () )
            {
            // InternalModelDraw.g:1865:1: ( () )
            // InternalModelDraw.g:1866:2: ()
            {
             before(grammarAccess.getEdgeAccess().getEdgeAction_0()); 
            // InternalModelDraw.g:1867:2: ()
            // InternalModelDraw.g:1867:3: 
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
    // InternalModelDraw.g:1875:1: rule__Edge__Group__1 : rule__Edge__Group__1__Impl rule__Edge__Group__2 ;
    public final void rule__Edge__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1879:1: ( rule__Edge__Group__1__Impl rule__Edge__Group__2 )
            // InternalModelDraw.g:1880:2: rule__Edge__Group__1__Impl rule__Edge__Group__2
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
    // InternalModelDraw.g:1887:1: rule__Edge__Group__1__Impl : ( ( rule__Edge__NameAssignment_1 ) ) ;
    public final void rule__Edge__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1891:1: ( ( ( rule__Edge__NameAssignment_1 ) ) )
            // InternalModelDraw.g:1892:1: ( ( rule__Edge__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:1892:1: ( ( rule__Edge__NameAssignment_1 ) )
            // InternalModelDraw.g:1893:2: ( rule__Edge__NameAssignment_1 )
            {
             before(grammarAccess.getEdgeAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:1894:2: ( rule__Edge__NameAssignment_1 )
            // InternalModelDraw.g:1894:3: rule__Edge__NameAssignment_1
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
    // InternalModelDraw.g:1902:1: rule__Edge__Group__2 : rule__Edge__Group__2__Impl rule__Edge__Group__3 ;
    public final void rule__Edge__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1906:1: ( rule__Edge__Group__2__Impl rule__Edge__Group__3 )
            // InternalModelDraw.g:1907:2: rule__Edge__Group__2__Impl rule__Edge__Group__3
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
    // InternalModelDraw.g:1914:1: rule__Edge__Group__2__Impl : ( '(' ) ;
    public final void rule__Edge__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1918:1: ( ( '(' ) )
            // InternalModelDraw.g:1919:1: ( '(' )
            {
            // InternalModelDraw.g:1919:1: ( '(' )
            // InternalModelDraw.g:1920:2: '('
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
    // InternalModelDraw.g:1929:1: rule__Edge__Group__3 : rule__Edge__Group__3__Impl rule__Edge__Group__4 ;
    public final void rule__Edge__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1933:1: ( rule__Edge__Group__3__Impl rule__Edge__Group__4 )
            // InternalModelDraw.g:1934:2: rule__Edge__Group__3__Impl rule__Edge__Group__4
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
    // InternalModelDraw.g:1941:1: rule__Edge__Group__3__Impl : ( ( rule__Edge__SourceAssignment_3 ) ) ;
    public final void rule__Edge__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1945:1: ( ( ( rule__Edge__SourceAssignment_3 ) ) )
            // InternalModelDraw.g:1946:1: ( ( rule__Edge__SourceAssignment_3 ) )
            {
            // InternalModelDraw.g:1946:1: ( ( rule__Edge__SourceAssignment_3 ) )
            // InternalModelDraw.g:1947:2: ( rule__Edge__SourceAssignment_3 )
            {
             before(grammarAccess.getEdgeAccess().getSourceAssignment_3()); 
            // InternalModelDraw.g:1948:2: ( rule__Edge__SourceAssignment_3 )
            // InternalModelDraw.g:1948:3: rule__Edge__SourceAssignment_3
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
    // InternalModelDraw.g:1956:1: rule__Edge__Group__4 : rule__Edge__Group__4__Impl rule__Edge__Group__5 ;
    public final void rule__Edge__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1960:1: ( rule__Edge__Group__4__Impl rule__Edge__Group__5 )
            // InternalModelDraw.g:1961:2: rule__Edge__Group__4__Impl rule__Edge__Group__5
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
    // InternalModelDraw.g:1968:1: rule__Edge__Group__4__Impl : ( ',' ) ;
    public final void rule__Edge__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1972:1: ( ( ',' ) )
            // InternalModelDraw.g:1973:1: ( ',' )
            {
            // InternalModelDraw.g:1973:1: ( ',' )
            // InternalModelDraw.g:1974:2: ','
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
    // InternalModelDraw.g:1983:1: rule__Edge__Group__5 : rule__Edge__Group__5__Impl rule__Edge__Group__6 ;
    public final void rule__Edge__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1987:1: ( rule__Edge__Group__5__Impl rule__Edge__Group__6 )
            // InternalModelDraw.g:1988:2: rule__Edge__Group__5__Impl rule__Edge__Group__6
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
    // InternalModelDraw.g:1995:1: rule__Edge__Group__5__Impl : ( ( rule__Edge__TargetAssignment_5 ) ) ;
    public final void rule__Edge__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:1999:1: ( ( ( rule__Edge__TargetAssignment_5 ) ) )
            // InternalModelDraw.g:2000:1: ( ( rule__Edge__TargetAssignment_5 ) )
            {
            // InternalModelDraw.g:2000:1: ( ( rule__Edge__TargetAssignment_5 ) )
            // InternalModelDraw.g:2001:2: ( rule__Edge__TargetAssignment_5 )
            {
             before(grammarAccess.getEdgeAccess().getTargetAssignment_5()); 
            // InternalModelDraw.g:2002:2: ( rule__Edge__TargetAssignment_5 )
            // InternalModelDraw.g:2002:3: rule__Edge__TargetAssignment_5
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
    // InternalModelDraw.g:2010:1: rule__Edge__Group__6 : rule__Edge__Group__6__Impl rule__Edge__Group__7 ;
    public final void rule__Edge__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2014:1: ( rule__Edge__Group__6__Impl rule__Edge__Group__7 )
            // InternalModelDraw.g:2015:2: rule__Edge__Group__6__Impl rule__Edge__Group__7
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
    // InternalModelDraw.g:2022:1: rule__Edge__Group__6__Impl : ( ')' ) ;
    public final void rule__Edge__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2026:1: ( ( ')' ) )
            // InternalModelDraw.g:2027:1: ( ')' )
            {
            // InternalModelDraw.g:2027:1: ( ')' )
            // InternalModelDraw.g:2028:2: ')'
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
    // InternalModelDraw.g:2037:1: rule__Edge__Group__7 : rule__Edge__Group__7__Impl rule__Edge__Group__8 ;
    public final void rule__Edge__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2041:1: ( rule__Edge__Group__7__Impl rule__Edge__Group__8 )
            // InternalModelDraw.g:2042:2: rule__Edge__Group__7__Impl rule__Edge__Group__8
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
    // InternalModelDraw.g:2049:1: rule__Edge__Group__7__Impl : ( ':' ) ;
    public final void rule__Edge__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2053:1: ( ( ':' ) )
            // InternalModelDraw.g:2054:1: ( ':' )
            {
            // InternalModelDraw.g:2054:1: ( ':' )
            // InternalModelDraw.g:2055:2: ':'
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
    // InternalModelDraw.g:2064:1: rule__Edge__Group__8 : rule__Edge__Group__8__Impl rule__Edge__Group__9 ;
    public final void rule__Edge__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2068:1: ( rule__Edge__Group__8__Impl rule__Edge__Group__9 )
            // InternalModelDraw.g:2069:2: rule__Edge__Group__8__Impl rule__Edge__Group__9
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
    // InternalModelDraw.g:2076:1: rule__Edge__Group__8__Impl : ( 'edge' ) ;
    public final void rule__Edge__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2080:1: ( ( 'edge' ) )
            // InternalModelDraw.g:2081:1: ( 'edge' )
            {
            // InternalModelDraw.g:2081:1: ( 'edge' )
            // InternalModelDraw.g:2082:2: 'edge'
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
    // InternalModelDraw.g:2091:1: rule__Edge__Group__9 : rule__Edge__Group__9__Impl rule__Edge__Group__10 ;
    public final void rule__Edge__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2095:1: ( rule__Edge__Group__9__Impl rule__Edge__Group__10 )
            // InternalModelDraw.g:2096:2: rule__Edge__Group__9__Impl rule__Edge__Group__10
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
    // InternalModelDraw.g:2103:1: rule__Edge__Group__9__Impl : ( ( rule__Edge__Group_9__0 )? ) ;
    public final void rule__Edge__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2107:1: ( ( ( rule__Edge__Group_9__0 )? ) )
            // InternalModelDraw.g:2108:1: ( ( rule__Edge__Group_9__0 )? )
            {
            // InternalModelDraw.g:2108:1: ( ( rule__Edge__Group_9__0 )? )
            // InternalModelDraw.g:2109:2: ( rule__Edge__Group_9__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_9()); 
            // InternalModelDraw.g:2110:2: ( rule__Edge__Group_9__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalModelDraw.g:2110:3: rule__Edge__Group_9__0
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
    // InternalModelDraw.g:2118:1: rule__Edge__Group__10 : rule__Edge__Group__10__Impl rule__Edge__Group__11 ;
    public final void rule__Edge__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2122:1: ( rule__Edge__Group__10__Impl rule__Edge__Group__11 )
            // InternalModelDraw.g:2123:2: rule__Edge__Group__10__Impl rule__Edge__Group__11
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
    // InternalModelDraw.g:2130:1: rule__Edge__Group__10__Impl : ( ( rule__Edge__Group_10__0 )? ) ;
    public final void rule__Edge__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2134:1: ( ( ( rule__Edge__Group_10__0 )? ) )
            // InternalModelDraw.g:2135:1: ( ( rule__Edge__Group_10__0 )? )
            {
            // InternalModelDraw.g:2135:1: ( ( rule__Edge__Group_10__0 )? )
            // InternalModelDraw.g:2136:2: ( rule__Edge__Group_10__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10()); 
            // InternalModelDraw.g:2137:2: ( rule__Edge__Group_10__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==39) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalModelDraw.g:2137:3: rule__Edge__Group_10__0
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
    // InternalModelDraw.g:2145:1: rule__Edge__Group__11 : rule__Edge__Group__11__Impl rule__Edge__Group__12 ;
    public final void rule__Edge__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2149:1: ( rule__Edge__Group__11__Impl rule__Edge__Group__12 )
            // InternalModelDraw.g:2150:2: rule__Edge__Group__11__Impl rule__Edge__Group__12
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
    // InternalModelDraw.g:2157:1: rule__Edge__Group__11__Impl : ( ( rule__Edge__Group_11__0 )? ) ;
    public final void rule__Edge__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2161:1: ( ( ( rule__Edge__Group_11__0 )? ) )
            // InternalModelDraw.g:2162:1: ( ( rule__Edge__Group_11__0 )? )
            {
            // InternalModelDraw.g:2162:1: ( ( rule__Edge__Group_11__0 )? )
            // InternalModelDraw.g:2163:2: ( rule__Edge__Group_11__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_11()); 
            // InternalModelDraw.g:2164:2: ( rule__Edge__Group_11__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==41) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalModelDraw.g:2164:3: rule__Edge__Group_11__0
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
    // InternalModelDraw.g:2172:1: rule__Edge__Group__12 : rule__Edge__Group__12__Impl rule__Edge__Group__13 ;
    public final void rule__Edge__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2176:1: ( rule__Edge__Group__12__Impl rule__Edge__Group__13 )
            // InternalModelDraw.g:2177:2: rule__Edge__Group__12__Impl rule__Edge__Group__13
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
    // InternalModelDraw.g:2184:1: rule__Edge__Group__12__Impl : ( ( rule__Edge__Group_12__0 )? ) ;
    public final void rule__Edge__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2188:1: ( ( ( rule__Edge__Group_12__0 )? ) )
            // InternalModelDraw.g:2189:1: ( ( rule__Edge__Group_12__0 )? )
            {
            // InternalModelDraw.g:2189:1: ( ( rule__Edge__Group_12__0 )? )
            // InternalModelDraw.g:2190:2: ( rule__Edge__Group_12__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_12()); 
            // InternalModelDraw.g:2191:2: ( rule__Edge__Group_12__0 )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==42) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalModelDraw.g:2191:3: rule__Edge__Group_12__0
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
    // InternalModelDraw.g:2199:1: rule__Edge__Group__13 : rule__Edge__Group__13__Impl rule__Edge__Group__14 ;
    public final void rule__Edge__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2203:1: ( rule__Edge__Group__13__Impl rule__Edge__Group__14 )
            // InternalModelDraw.g:2204:2: rule__Edge__Group__13__Impl rule__Edge__Group__14
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
    // InternalModelDraw.g:2211:1: rule__Edge__Group__13__Impl : ( ( rule__Edge__Group_13__0 )? ) ;
    public final void rule__Edge__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2215:1: ( ( ( rule__Edge__Group_13__0 )? ) )
            // InternalModelDraw.g:2216:1: ( ( rule__Edge__Group_13__0 )? )
            {
            // InternalModelDraw.g:2216:1: ( ( rule__Edge__Group_13__0 )? )
            // InternalModelDraw.g:2217:2: ( rule__Edge__Group_13__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_13()); 
            // InternalModelDraw.g:2218:2: ( rule__Edge__Group_13__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==43) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalModelDraw.g:2218:3: rule__Edge__Group_13__0
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
    // InternalModelDraw.g:2226:1: rule__Edge__Group__14 : rule__Edge__Group__14__Impl ;
    public final void rule__Edge__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2230:1: ( rule__Edge__Group__14__Impl )
            // InternalModelDraw.g:2231:2: rule__Edge__Group__14__Impl
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
    // InternalModelDraw.g:2237:1: rule__Edge__Group__14__Impl : ( ( rule__Edge__Group_14__0 )? ) ;
    public final void rule__Edge__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2241:1: ( ( ( rule__Edge__Group_14__0 )? ) )
            // InternalModelDraw.g:2242:1: ( ( rule__Edge__Group_14__0 )? )
            {
            // InternalModelDraw.g:2242:1: ( ( rule__Edge__Group_14__0 )? )
            // InternalModelDraw.g:2243:2: ( rule__Edge__Group_14__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_14()); 
            // InternalModelDraw.g:2244:2: ( rule__Edge__Group_14__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==44) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalModelDraw.g:2244:3: rule__Edge__Group_14__0
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
    // InternalModelDraw.g:2253:1: rule__Edge__Group_9__0 : rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 ;
    public final void rule__Edge__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2257:1: ( rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1 )
            // InternalModelDraw.g:2258:2: rule__Edge__Group_9__0__Impl rule__Edge__Group_9__1
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
    // InternalModelDraw.g:2265:1: rule__Edge__Group_9__0__Impl : ( '=' ) ;
    public final void rule__Edge__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2269:1: ( ( '=' ) )
            // InternalModelDraw.g:2270:1: ( '=' )
            {
            // InternalModelDraw.g:2270:1: ( '=' )
            // InternalModelDraw.g:2271:2: '='
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
    // InternalModelDraw.g:2280:1: rule__Edge__Group_9__1 : rule__Edge__Group_9__1__Impl ;
    public final void rule__Edge__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2284:1: ( rule__Edge__Group_9__1__Impl )
            // InternalModelDraw.g:2285:2: rule__Edge__Group_9__1__Impl
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
    // InternalModelDraw.g:2291:1: rule__Edge__Group_9__1__Impl : ( ( rule__Edge__AttNameAssignment_9_1 ) ) ;
    public final void rule__Edge__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2295:1: ( ( ( rule__Edge__AttNameAssignment_9_1 ) ) )
            // InternalModelDraw.g:2296:1: ( ( rule__Edge__AttNameAssignment_9_1 ) )
            {
            // InternalModelDraw.g:2296:1: ( ( rule__Edge__AttNameAssignment_9_1 ) )
            // InternalModelDraw.g:2297:2: ( rule__Edge__AttNameAssignment_9_1 )
            {
             before(grammarAccess.getEdgeAccess().getAttNameAssignment_9_1()); 
            // InternalModelDraw.g:2298:2: ( rule__Edge__AttNameAssignment_9_1 )
            // InternalModelDraw.g:2298:3: rule__Edge__AttNameAssignment_9_1
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
    // InternalModelDraw.g:2307:1: rule__Edge__Group_10__0 : rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 ;
    public final void rule__Edge__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2311:1: ( rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1 )
            // InternalModelDraw.g:2312:2: rule__Edge__Group_10__0__Impl rule__Edge__Group_10__1
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
    // InternalModelDraw.g:2319:1: rule__Edge__Group_10__0__Impl : ( 'label' ) ;
    public final void rule__Edge__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2323:1: ( ( 'label' ) )
            // InternalModelDraw.g:2324:1: ( 'label' )
            {
            // InternalModelDraw.g:2324:1: ( 'label' )
            // InternalModelDraw.g:2325:2: 'label'
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
    // InternalModelDraw.g:2334:1: rule__Edge__Group_10__1 : rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 ;
    public final void rule__Edge__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2338:1: ( rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2 )
            // InternalModelDraw.g:2339:2: rule__Edge__Group_10__1__Impl rule__Edge__Group_10__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalModelDraw.g:2346:1: rule__Edge__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2350:1: ( ( '=' ) )
            // InternalModelDraw.g:2351:1: ( '=' )
            {
            // InternalModelDraw.g:2351:1: ( '=' )
            // InternalModelDraw.g:2352:2: '='
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
    // InternalModelDraw.g:2361:1: rule__Edge__Group_10__2 : rule__Edge__Group_10__2__Impl rule__Edge__Group_10__3 ;
    public final void rule__Edge__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2365:1: ( rule__Edge__Group_10__2__Impl rule__Edge__Group_10__3 )
            // InternalModelDraw.g:2366:2: rule__Edge__Group_10__2__Impl rule__Edge__Group_10__3
            {
            pushFollow(FOLLOW_5);
            rule__Edge__Group_10__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10__3();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:2373:1: rule__Edge__Group_10__2__Impl : ( ( rule__Edge__Group_10_2__0 )? ) ;
    public final void rule__Edge__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2377:1: ( ( ( rule__Edge__Group_10_2__0 )? ) )
            // InternalModelDraw.g:2378:1: ( ( rule__Edge__Group_10_2__0 )? )
            {
            // InternalModelDraw.g:2378:1: ( ( rule__Edge__Group_10_2__0 )? )
            // InternalModelDraw.g:2379:2: ( rule__Edge__Group_10_2__0 )?
            {
             before(grammarAccess.getEdgeAccess().getGroup_10_2()); 
            // InternalModelDraw.g:2380:2: ( rule__Edge__Group_10_2__0 )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==40) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalModelDraw.g:2380:3: rule__Edge__Group_10_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Edge__Group_10_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEdgeAccess().getGroup_10_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Edge__Group_10__3"
    // InternalModelDraw.g:2388:1: rule__Edge__Group_10__3 : rule__Edge__Group_10__3__Impl ;
    public final void rule__Edge__Group_10__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2392:1: ( rule__Edge__Group_10__3__Impl )
            // InternalModelDraw.g:2393:2: rule__Edge__Group_10__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__3"


    // $ANTLR start "rule__Edge__Group_10__3__Impl"
    // InternalModelDraw.g:2399:1: rule__Edge__Group_10__3__Impl : ( ( rule__Edge__LabelAssignment_10_3 ) ) ;
    public final void rule__Edge__Group_10__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2403:1: ( ( ( rule__Edge__LabelAssignment_10_3 ) ) )
            // InternalModelDraw.g:2404:1: ( ( rule__Edge__LabelAssignment_10_3 ) )
            {
            // InternalModelDraw.g:2404:1: ( ( rule__Edge__LabelAssignment_10_3 ) )
            // InternalModelDraw.g:2405:2: ( rule__Edge__LabelAssignment_10_3 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_10_3()); 
            // InternalModelDraw.g:2406:2: ( rule__Edge__LabelAssignment_10_3 )
            // InternalModelDraw.g:2406:3: rule__Edge__LabelAssignment_10_3
            {
            pushFollow(FOLLOW_2);
            rule__Edge__LabelAssignment_10_3();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_10_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10__3__Impl"


    // $ANTLR start "rule__Edge__Group_10_2__0"
    // InternalModelDraw.g:2415:1: rule__Edge__Group_10_2__0 : rule__Edge__Group_10_2__0__Impl rule__Edge__Group_10_2__1 ;
    public final void rule__Edge__Group_10_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2419:1: ( rule__Edge__Group_10_2__0__Impl rule__Edge__Group_10_2__1 )
            // InternalModelDraw.g:2420:2: rule__Edge__Group_10_2__0__Impl rule__Edge__Group_10_2__1
            {
            pushFollow(FOLLOW_26);
            rule__Edge__Group_10_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2__0"


    // $ANTLR start "rule__Edge__Group_10_2__0__Impl"
    // InternalModelDraw.g:2427:1: rule__Edge__Group_10_2__0__Impl : ( ( rule__Edge__ReferenceAssignment_10_2_0 ) ) ;
    public final void rule__Edge__Group_10_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2431:1: ( ( ( rule__Edge__ReferenceAssignment_10_2_0 ) ) )
            // InternalModelDraw.g:2432:1: ( ( rule__Edge__ReferenceAssignment_10_2_0 ) )
            {
            // InternalModelDraw.g:2432:1: ( ( rule__Edge__ReferenceAssignment_10_2_0 ) )
            // InternalModelDraw.g:2433:2: ( rule__Edge__ReferenceAssignment_10_2_0 )
            {
             before(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_0()); 
            // InternalModelDraw.g:2434:2: ( rule__Edge__ReferenceAssignment_10_2_0 )
            // InternalModelDraw.g:2434:3: rule__Edge__ReferenceAssignment_10_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Edge__ReferenceAssignment_10_2_0();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getReferenceAssignment_10_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2__0__Impl"


    // $ANTLR start "rule__Edge__Group_10_2__1"
    // InternalModelDraw.g:2442:1: rule__Edge__Group_10_2__1 : rule__Edge__Group_10_2__1__Impl ;
    public final void rule__Edge__Group_10_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2446:1: ( rule__Edge__Group_10_2__1__Impl )
            // InternalModelDraw.g:2447:2: rule__Edge__Group_10_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Edge__Group_10_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2__1"


    // $ANTLR start "rule__Edge__Group_10_2__1__Impl"
    // InternalModelDraw.g:2453:1: rule__Edge__Group_10_2__1__Impl : ( '.' ) ;
    public final void rule__Edge__Group_10_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2457:1: ( ( '.' ) )
            // InternalModelDraw.g:2458:1: ( '.' )
            {
            // InternalModelDraw.g:2458:1: ( '.' )
            // InternalModelDraw.g:2459:2: '.'
            {
             before(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getFullStopKeyword_10_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__Group_10_2__1__Impl"


    // $ANTLR start "rule__Edge__Group_11__0"
    // InternalModelDraw.g:2469:1: rule__Edge__Group_11__0 : rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 ;
    public final void rule__Edge__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2473:1: ( rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1 )
            // InternalModelDraw.g:2474:2: rule__Edge__Group_11__0__Impl rule__Edge__Group_11__1
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
    // InternalModelDraw.g:2481:1: rule__Edge__Group_11__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Edge__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2485:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:2486:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:2486:1: ( 'src_decoration' )
            // InternalModelDraw.g:2487:2: 'src_decoration'
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationKeyword_11_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalModelDraw.g:2496:1: rule__Edge__Group_11__1 : rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 ;
    public final void rule__Edge__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2500:1: ( rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2 )
            // InternalModelDraw.g:2501:2: rule__Edge__Group_11__1__Impl rule__Edge__Group_11__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:2508:1: rule__Edge__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2512:1: ( ( '=' ) )
            // InternalModelDraw.g:2513:1: ( '=' )
            {
            // InternalModelDraw.g:2513:1: ( '=' )
            // InternalModelDraw.g:2514:2: '='
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
    // InternalModelDraw.g:2523:1: rule__Edge__Group_11__2 : rule__Edge__Group_11__2__Impl ;
    public final void rule__Edge__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2527:1: ( rule__Edge__Group_11__2__Impl )
            // InternalModelDraw.g:2528:2: rule__Edge__Group_11__2__Impl
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
    // InternalModelDraw.g:2534:1: rule__Edge__Group_11__2__Impl : ( ( rule__Edge__Src_decorationAssignment_11_2 ) ) ;
    public final void rule__Edge__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2538:1: ( ( ( rule__Edge__Src_decorationAssignment_11_2 ) ) )
            // InternalModelDraw.g:2539:1: ( ( rule__Edge__Src_decorationAssignment_11_2 ) )
            {
            // InternalModelDraw.g:2539:1: ( ( rule__Edge__Src_decorationAssignment_11_2 ) )
            // InternalModelDraw.g:2540:2: ( rule__Edge__Src_decorationAssignment_11_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_decorationAssignment_11_2()); 
            // InternalModelDraw.g:2541:2: ( rule__Edge__Src_decorationAssignment_11_2 )
            // InternalModelDraw.g:2541:3: rule__Edge__Src_decorationAssignment_11_2
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
    // InternalModelDraw.g:2550:1: rule__Edge__Group_12__0 : rule__Edge__Group_12__0__Impl rule__Edge__Group_12__1 ;
    public final void rule__Edge__Group_12__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2554:1: ( rule__Edge__Group_12__0__Impl rule__Edge__Group_12__1 )
            // InternalModelDraw.g:2555:2: rule__Edge__Group_12__0__Impl rule__Edge__Group_12__1
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
    // InternalModelDraw.g:2562:1: rule__Edge__Group_12__0__Impl : ( 'src_label' ) ;
    public final void rule__Edge__Group_12__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2566:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:2567:1: ( 'src_label' )
            {
            // InternalModelDraw.g:2567:1: ( 'src_label' )
            // InternalModelDraw.g:2568:2: 'src_label'
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelKeyword_12_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalModelDraw.g:2577:1: rule__Edge__Group_12__1 : rule__Edge__Group_12__1__Impl rule__Edge__Group_12__2 ;
    public final void rule__Edge__Group_12__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2581:1: ( rule__Edge__Group_12__1__Impl rule__Edge__Group_12__2 )
            // InternalModelDraw.g:2582:2: rule__Edge__Group_12__1__Impl rule__Edge__Group_12__2
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
    // InternalModelDraw.g:2589:1: rule__Edge__Group_12__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_12__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2593:1: ( ( '=' ) )
            // InternalModelDraw.g:2594:1: ( '=' )
            {
            // InternalModelDraw.g:2594:1: ( '=' )
            // InternalModelDraw.g:2595:2: '='
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
    // InternalModelDraw.g:2604:1: rule__Edge__Group_12__2 : rule__Edge__Group_12__2__Impl ;
    public final void rule__Edge__Group_12__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2608:1: ( rule__Edge__Group_12__2__Impl )
            // InternalModelDraw.g:2609:2: rule__Edge__Group_12__2__Impl
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
    // InternalModelDraw.g:2615:1: rule__Edge__Group_12__2__Impl : ( ( rule__Edge__Src_labelAssignment_12_2 ) ) ;
    public final void rule__Edge__Group_12__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2619:1: ( ( ( rule__Edge__Src_labelAssignment_12_2 ) ) )
            // InternalModelDraw.g:2620:1: ( ( rule__Edge__Src_labelAssignment_12_2 ) )
            {
            // InternalModelDraw.g:2620:1: ( ( rule__Edge__Src_labelAssignment_12_2 ) )
            // InternalModelDraw.g:2621:2: ( rule__Edge__Src_labelAssignment_12_2 )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelAssignment_12_2()); 
            // InternalModelDraw.g:2622:2: ( rule__Edge__Src_labelAssignment_12_2 )
            // InternalModelDraw.g:2622:3: rule__Edge__Src_labelAssignment_12_2
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
    // InternalModelDraw.g:2631:1: rule__Edge__Group_13__0 : rule__Edge__Group_13__0__Impl rule__Edge__Group_13__1 ;
    public final void rule__Edge__Group_13__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2635:1: ( rule__Edge__Group_13__0__Impl rule__Edge__Group_13__1 )
            // InternalModelDraw.g:2636:2: rule__Edge__Group_13__0__Impl rule__Edge__Group_13__1
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
    // InternalModelDraw.g:2643:1: rule__Edge__Group_13__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Edge__Group_13__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2647:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:2648:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:2648:1: ( 'tar_decoration' )
            // InternalModelDraw.g:2649:2: 'tar_decoration'
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationKeyword_13_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalModelDraw.g:2658:1: rule__Edge__Group_13__1 : rule__Edge__Group_13__1__Impl rule__Edge__Group_13__2 ;
    public final void rule__Edge__Group_13__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2662:1: ( rule__Edge__Group_13__1__Impl rule__Edge__Group_13__2 )
            // InternalModelDraw.g:2663:2: rule__Edge__Group_13__1__Impl rule__Edge__Group_13__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:2670:1: rule__Edge__Group_13__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_13__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2674:1: ( ( '=' ) )
            // InternalModelDraw.g:2675:1: ( '=' )
            {
            // InternalModelDraw.g:2675:1: ( '=' )
            // InternalModelDraw.g:2676:2: '='
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
    // InternalModelDraw.g:2685:1: rule__Edge__Group_13__2 : rule__Edge__Group_13__2__Impl ;
    public final void rule__Edge__Group_13__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2689:1: ( rule__Edge__Group_13__2__Impl )
            // InternalModelDraw.g:2690:2: rule__Edge__Group_13__2__Impl
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
    // InternalModelDraw.g:2696:1: rule__Edge__Group_13__2__Impl : ( ( rule__Edge__Tar_decorationAssignment_13_2 ) ) ;
    public final void rule__Edge__Group_13__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2700:1: ( ( ( rule__Edge__Tar_decorationAssignment_13_2 ) ) )
            // InternalModelDraw.g:2701:1: ( ( rule__Edge__Tar_decorationAssignment_13_2 ) )
            {
            // InternalModelDraw.g:2701:1: ( ( rule__Edge__Tar_decorationAssignment_13_2 ) )
            // InternalModelDraw.g:2702:2: ( rule__Edge__Tar_decorationAssignment_13_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_decorationAssignment_13_2()); 
            // InternalModelDraw.g:2703:2: ( rule__Edge__Tar_decorationAssignment_13_2 )
            // InternalModelDraw.g:2703:3: rule__Edge__Tar_decorationAssignment_13_2
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
    // InternalModelDraw.g:2712:1: rule__Edge__Group_14__0 : rule__Edge__Group_14__0__Impl rule__Edge__Group_14__1 ;
    public final void rule__Edge__Group_14__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2716:1: ( rule__Edge__Group_14__0__Impl rule__Edge__Group_14__1 )
            // InternalModelDraw.g:2717:2: rule__Edge__Group_14__0__Impl rule__Edge__Group_14__1
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
    // InternalModelDraw.g:2724:1: rule__Edge__Group_14__0__Impl : ( 'tar_label' ) ;
    public final void rule__Edge__Group_14__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2728:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:2729:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:2729:1: ( 'tar_label' )
            // InternalModelDraw.g:2730:2: 'tar_label'
            {
             before(grammarAccess.getEdgeAccess().getTar_labelKeyword_14_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalModelDraw.g:2739:1: rule__Edge__Group_14__1 : rule__Edge__Group_14__1__Impl rule__Edge__Group_14__2 ;
    public final void rule__Edge__Group_14__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2743:1: ( rule__Edge__Group_14__1__Impl rule__Edge__Group_14__2 )
            // InternalModelDraw.g:2744:2: rule__Edge__Group_14__1__Impl rule__Edge__Group_14__2
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
    // InternalModelDraw.g:2751:1: rule__Edge__Group_14__1__Impl : ( '=' ) ;
    public final void rule__Edge__Group_14__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2755:1: ( ( '=' ) )
            // InternalModelDraw.g:2756:1: ( '=' )
            {
            // InternalModelDraw.g:2756:1: ( '=' )
            // InternalModelDraw.g:2757:2: '='
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
    // InternalModelDraw.g:2766:1: rule__Edge__Group_14__2 : rule__Edge__Group_14__2__Impl ;
    public final void rule__Edge__Group_14__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2770:1: ( rule__Edge__Group_14__2__Impl )
            // InternalModelDraw.g:2771:2: rule__Edge__Group_14__2__Impl
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
    // InternalModelDraw.g:2777:1: rule__Edge__Group_14__2__Impl : ( ( rule__Edge__Tar_labelAssignment_14_2 ) ) ;
    public final void rule__Edge__Group_14__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2781:1: ( ( ( rule__Edge__Tar_labelAssignment_14_2 ) ) )
            // InternalModelDraw.g:2782:1: ( ( rule__Edge__Tar_labelAssignment_14_2 ) )
            {
            // InternalModelDraw.g:2782:1: ( ( rule__Edge__Tar_labelAssignment_14_2 ) )
            // InternalModelDraw.g:2783:2: ( rule__Edge__Tar_labelAssignment_14_2 )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelAssignment_14_2()); 
            // InternalModelDraw.g:2784:2: ( rule__Edge__Tar_labelAssignment_14_2 )
            // InternalModelDraw.g:2784:3: rule__Edge__Tar_labelAssignment_14_2
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
    // InternalModelDraw.g:2793:1: rule__Level__Group__0 : rule__Level__Group__0__Impl rule__Level__Group__1 ;
    public final void rule__Level__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2797:1: ( rule__Level__Group__0__Impl rule__Level__Group__1 )
            // InternalModelDraw.g:2798:2: rule__Level__Group__0__Impl rule__Level__Group__1
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
    // InternalModelDraw.g:2805:1: rule__Level__Group__0__Impl : ( () ) ;
    public final void rule__Level__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2809:1: ( ( () ) )
            // InternalModelDraw.g:2810:1: ( () )
            {
            // InternalModelDraw.g:2810:1: ( () )
            // InternalModelDraw.g:2811:2: ()
            {
             before(grammarAccess.getLevelAccess().getLevelAction_0()); 
            // InternalModelDraw.g:2812:2: ()
            // InternalModelDraw.g:2812:3: 
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
    // InternalModelDraw.g:2820:1: rule__Level__Group__1 : rule__Level__Group__1__Impl rule__Level__Group__2 ;
    public final void rule__Level__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2824:1: ( rule__Level__Group__1__Impl rule__Level__Group__2 )
            // InternalModelDraw.g:2825:2: rule__Level__Group__1__Impl rule__Level__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalModelDraw.g:2832:1: rule__Level__Group__1__Impl : ( ( rule__Level__NameAssignment_1 ) ) ;
    public final void rule__Level__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2836:1: ( ( ( rule__Level__NameAssignment_1 ) ) )
            // InternalModelDraw.g:2837:1: ( ( rule__Level__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:2837:1: ( ( rule__Level__NameAssignment_1 ) )
            // InternalModelDraw.g:2838:2: ( rule__Level__NameAssignment_1 )
            {
             before(grammarAccess.getLevelAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:2839:2: ( rule__Level__NameAssignment_1 )
            // InternalModelDraw.g:2839:3: rule__Level__NameAssignment_1
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
    // InternalModelDraw.g:2847:1: rule__Level__Group__2 : rule__Level__Group__2__Impl rule__Level__Group__3 ;
    public final void rule__Level__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2851:1: ( rule__Level__Group__2__Impl rule__Level__Group__3 )
            // InternalModelDraw.g:2852:2: rule__Level__Group__2__Impl rule__Level__Group__3
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
    // InternalModelDraw.g:2859:1: rule__Level__Group__2__Impl : ( '.' ) ;
    public final void rule__Level__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2863:1: ( ( '.' ) )
            // InternalModelDraw.g:2864:1: ( '.' )
            {
            // InternalModelDraw.g:2864:1: ( '.' )
            // InternalModelDraw.g:2865:2: '.'
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
    // InternalModelDraw.g:2874:1: rule__Level__Group__3 : rule__Level__Group__3__Impl rule__Level__Group__4 ;
    public final void rule__Level__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2878:1: ( rule__Level__Group__3__Impl rule__Level__Group__4 )
            // InternalModelDraw.g:2879:2: rule__Level__Group__3__Impl rule__Level__Group__4
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
    // InternalModelDraw.g:2886:1: rule__Level__Group__3__Impl : ( ( rule__Level__UpperAssignment_3 ) ) ;
    public final void rule__Level__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2890:1: ( ( ( rule__Level__UpperAssignment_3 ) ) )
            // InternalModelDraw.g:2891:1: ( ( rule__Level__UpperAssignment_3 ) )
            {
            // InternalModelDraw.g:2891:1: ( ( rule__Level__UpperAssignment_3 ) )
            // InternalModelDraw.g:2892:2: ( rule__Level__UpperAssignment_3 )
            {
             before(grammarAccess.getLevelAccess().getUpperAssignment_3()); 
            // InternalModelDraw.g:2893:2: ( rule__Level__UpperAssignment_3 )
            // InternalModelDraw.g:2893:3: rule__Level__UpperAssignment_3
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
    // InternalModelDraw.g:2901:1: rule__Level__Group__4 : rule__Level__Group__4__Impl rule__Level__Group__5 ;
    public final void rule__Level__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2905:1: ( rule__Level__Group__4__Impl rule__Level__Group__5 )
            // InternalModelDraw.g:2906:2: rule__Level__Group__4__Impl rule__Level__Group__5
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
    // InternalModelDraw.g:2913:1: rule__Level__Group__4__Impl : ( ':' ) ;
    public final void rule__Level__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2917:1: ( ( ':' ) )
            // InternalModelDraw.g:2918:1: ( ':' )
            {
            // InternalModelDraw.g:2918:1: ( ':' )
            // InternalModelDraw.g:2919:2: ':'
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
    // InternalModelDraw.g:2928:1: rule__Level__Group__5 : rule__Level__Group__5__Impl rule__Level__Group__6 ;
    public final void rule__Level__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2932:1: ( rule__Level__Group__5__Impl rule__Level__Group__6 )
            // InternalModelDraw.g:2933:2: rule__Level__Group__5__Impl rule__Level__Group__6
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
    // InternalModelDraw.g:2940:1: rule__Level__Group__5__Impl : ( 'edge' ) ;
    public final void rule__Level__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2944:1: ( ( 'edge' ) )
            // InternalModelDraw.g:2945:1: ( 'edge' )
            {
            // InternalModelDraw.g:2945:1: ( 'edge' )
            // InternalModelDraw.g:2946:2: 'edge'
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
    // InternalModelDraw.g:2955:1: rule__Level__Group__6 : rule__Level__Group__6__Impl rule__Level__Group__7 ;
    public final void rule__Level__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2959:1: ( rule__Level__Group__6__Impl rule__Level__Group__7 )
            // InternalModelDraw.g:2960:2: rule__Level__Group__6__Impl rule__Level__Group__7
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
    // InternalModelDraw.g:2967:1: rule__Level__Group__6__Impl : ( ( rule__Level__Group_6__0 )? ) ;
    public final void rule__Level__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2971:1: ( ( ( rule__Level__Group_6__0 )? ) )
            // InternalModelDraw.g:2972:1: ( ( rule__Level__Group_6__0 )? )
            {
            // InternalModelDraw.g:2972:1: ( ( rule__Level__Group_6__0 )? )
            // InternalModelDraw.g:2973:2: ( rule__Level__Group_6__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_6()); 
            // InternalModelDraw.g:2974:2: ( rule__Level__Group_6__0 )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalModelDraw.g:2974:3: rule__Level__Group_6__0
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
    // InternalModelDraw.g:2982:1: rule__Level__Group__7 : rule__Level__Group__7__Impl rule__Level__Group__8 ;
    public final void rule__Level__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2986:1: ( rule__Level__Group__7__Impl rule__Level__Group__8 )
            // InternalModelDraw.g:2987:2: rule__Level__Group__7__Impl rule__Level__Group__8
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
    // InternalModelDraw.g:2994:1: rule__Level__Group__7__Impl : ( ( rule__Level__Group_7__0 )? ) ;
    public final void rule__Level__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:2998:1: ( ( ( rule__Level__Group_7__0 )? ) )
            // InternalModelDraw.g:2999:1: ( ( rule__Level__Group_7__0 )? )
            {
            // InternalModelDraw.g:2999:1: ( ( rule__Level__Group_7__0 )? )
            // InternalModelDraw.g:3000:2: ( rule__Level__Group_7__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7()); 
            // InternalModelDraw.g:3001:2: ( rule__Level__Group_7__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==39) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalModelDraw.g:3001:3: rule__Level__Group_7__0
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
    // InternalModelDraw.g:3009:1: rule__Level__Group__8 : rule__Level__Group__8__Impl rule__Level__Group__9 ;
    public final void rule__Level__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3013:1: ( rule__Level__Group__8__Impl rule__Level__Group__9 )
            // InternalModelDraw.g:3014:2: rule__Level__Group__8__Impl rule__Level__Group__9
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
    // InternalModelDraw.g:3021:1: rule__Level__Group__8__Impl : ( ( rule__Level__Group_8__0 )? ) ;
    public final void rule__Level__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3025:1: ( ( ( rule__Level__Group_8__0 )? ) )
            // InternalModelDraw.g:3026:1: ( ( rule__Level__Group_8__0 )? )
            {
            // InternalModelDraw.g:3026:1: ( ( rule__Level__Group_8__0 )? )
            // InternalModelDraw.g:3027:2: ( rule__Level__Group_8__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_8()); 
            // InternalModelDraw.g:3028:2: ( rule__Level__Group_8__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==41) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalModelDraw.g:3028:3: rule__Level__Group_8__0
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
    // InternalModelDraw.g:3036:1: rule__Level__Group__9 : rule__Level__Group__9__Impl rule__Level__Group__10 ;
    public final void rule__Level__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3040:1: ( rule__Level__Group__9__Impl rule__Level__Group__10 )
            // InternalModelDraw.g:3041:2: rule__Level__Group__9__Impl rule__Level__Group__10
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
    // InternalModelDraw.g:3048:1: rule__Level__Group__9__Impl : ( ( rule__Level__Group_9__0 )? ) ;
    public final void rule__Level__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3052:1: ( ( ( rule__Level__Group_9__0 )? ) )
            // InternalModelDraw.g:3053:1: ( ( rule__Level__Group_9__0 )? )
            {
            // InternalModelDraw.g:3053:1: ( ( rule__Level__Group_9__0 )? )
            // InternalModelDraw.g:3054:2: ( rule__Level__Group_9__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_9()); 
            // InternalModelDraw.g:3055:2: ( rule__Level__Group_9__0 )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==42) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalModelDraw.g:3055:3: rule__Level__Group_9__0
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
    // InternalModelDraw.g:3063:1: rule__Level__Group__10 : rule__Level__Group__10__Impl rule__Level__Group__11 ;
    public final void rule__Level__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3067:1: ( rule__Level__Group__10__Impl rule__Level__Group__11 )
            // InternalModelDraw.g:3068:2: rule__Level__Group__10__Impl rule__Level__Group__11
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
    // InternalModelDraw.g:3075:1: rule__Level__Group__10__Impl : ( ( rule__Level__Group_10__0 )? ) ;
    public final void rule__Level__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3079:1: ( ( ( rule__Level__Group_10__0 )? ) )
            // InternalModelDraw.g:3080:1: ( ( rule__Level__Group_10__0 )? )
            {
            // InternalModelDraw.g:3080:1: ( ( rule__Level__Group_10__0 )? )
            // InternalModelDraw.g:3081:2: ( rule__Level__Group_10__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_10()); 
            // InternalModelDraw.g:3082:2: ( rule__Level__Group_10__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==43) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalModelDraw.g:3082:3: rule__Level__Group_10__0
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
    // InternalModelDraw.g:3090:1: rule__Level__Group__11 : rule__Level__Group__11__Impl ;
    public final void rule__Level__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3094:1: ( rule__Level__Group__11__Impl )
            // InternalModelDraw.g:3095:2: rule__Level__Group__11__Impl
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
    // InternalModelDraw.g:3101:1: rule__Level__Group__11__Impl : ( ( rule__Level__Group_11__0 )? ) ;
    public final void rule__Level__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3105:1: ( ( ( rule__Level__Group_11__0 )? ) )
            // InternalModelDraw.g:3106:1: ( ( rule__Level__Group_11__0 )? )
            {
            // InternalModelDraw.g:3106:1: ( ( rule__Level__Group_11__0 )? )
            // InternalModelDraw.g:3107:2: ( rule__Level__Group_11__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_11()); 
            // InternalModelDraw.g:3108:2: ( rule__Level__Group_11__0 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==44) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalModelDraw.g:3108:3: rule__Level__Group_11__0
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
    // InternalModelDraw.g:3117:1: rule__Level__Group_6__0 : rule__Level__Group_6__0__Impl rule__Level__Group_6__1 ;
    public final void rule__Level__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3121:1: ( rule__Level__Group_6__0__Impl rule__Level__Group_6__1 )
            // InternalModelDraw.g:3122:2: rule__Level__Group_6__0__Impl rule__Level__Group_6__1
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
    // InternalModelDraw.g:3129:1: rule__Level__Group_6__0__Impl : ( '=' ) ;
    public final void rule__Level__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3133:1: ( ( '=' ) )
            // InternalModelDraw.g:3134:1: ( '=' )
            {
            // InternalModelDraw.g:3134:1: ( '=' )
            // InternalModelDraw.g:3135:2: '='
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
    // InternalModelDraw.g:3144:1: rule__Level__Group_6__1 : rule__Level__Group_6__1__Impl ;
    public final void rule__Level__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3148:1: ( rule__Level__Group_6__1__Impl )
            // InternalModelDraw.g:3149:2: rule__Level__Group_6__1__Impl
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
    // InternalModelDraw.g:3155:1: rule__Level__Group_6__1__Impl : ( ( rule__Level__AttNameAssignment_6_1 ) ) ;
    public final void rule__Level__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3159:1: ( ( ( rule__Level__AttNameAssignment_6_1 ) ) )
            // InternalModelDraw.g:3160:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            {
            // InternalModelDraw.g:3160:1: ( ( rule__Level__AttNameAssignment_6_1 ) )
            // InternalModelDraw.g:3161:2: ( rule__Level__AttNameAssignment_6_1 )
            {
             before(grammarAccess.getLevelAccess().getAttNameAssignment_6_1()); 
            // InternalModelDraw.g:3162:2: ( rule__Level__AttNameAssignment_6_1 )
            // InternalModelDraw.g:3162:3: rule__Level__AttNameAssignment_6_1
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
    // InternalModelDraw.g:3171:1: rule__Level__Group_7__0 : rule__Level__Group_7__0__Impl rule__Level__Group_7__1 ;
    public final void rule__Level__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3175:1: ( rule__Level__Group_7__0__Impl rule__Level__Group_7__1 )
            // InternalModelDraw.g:3176:2: rule__Level__Group_7__0__Impl rule__Level__Group_7__1
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
    // InternalModelDraw.g:3183:1: rule__Level__Group_7__0__Impl : ( 'label' ) ;
    public final void rule__Level__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3187:1: ( ( 'label' ) )
            // InternalModelDraw.g:3188:1: ( 'label' )
            {
            // InternalModelDraw.g:3188:1: ( 'label' )
            // InternalModelDraw.g:3189:2: 'label'
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
    // InternalModelDraw.g:3198:1: rule__Level__Group_7__1 : rule__Level__Group_7__1__Impl rule__Level__Group_7__2 ;
    public final void rule__Level__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3202:1: ( rule__Level__Group_7__1__Impl rule__Level__Group_7__2 )
            // InternalModelDraw.g:3203:2: rule__Level__Group_7__1__Impl rule__Level__Group_7__2
            {
            pushFollow(FOLLOW_5);
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
    // InternalModelDraw.g:3210:1: rule__Level__Group_7__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3214:1: ( ( '=' ) )
            // InternalModelDraw.g:3215:1: ( '=' )
            {
            // InternalModelDraw.g:3215:1: ( '=' )
            // InternalModelDraw.g:3216:2: '='
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
    // InternalModelDraw.g:3225:1: rule__Level__Group_7__2 : rule__Level__Group_7__2__Impl rule__Level__Group_7__3 ;
    public final void rule__Level__Group_7__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3229:1: ( rule__Level__Group_7__2__Impl rule__Level__Group_7__3 )
            // InternalModelDraw.g:3230:2: rule__Level__Group_7__2__Impl rule__Level__Group_7__3
            {
            pushFollow(FOLLOW_5);
            rule__Level__Group_7__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7__3();

            state._fsp--;


            }

        }
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
    // InternalModelDraw.g:3237:1: rule__Level__Group_7__2__Impl : ( ( rule__Level__Group_7_2__0 )? ) ;
    public final void rule__Level__Group_7__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3241:1: ( ( ( rule__Level__Group_7_2__0 )? ) )
            // InternalModelDraw.g:3242:1: ( ( rule__Level__Group_7_2__0 )? )
            {
            // InternalModelDraw.g:3242:1: ( ( rule__Level__Group_7_2__0 )? )
            // InternalModelDraw.g:3243:2: ( rule__Level__Group_7_2__0 )?
            {
             before(grammarAccess.getLevelAccess().getGroup_7_2()); 
            // InternalModelDraw.g:3244:2: ( rule__Level__Group_7_2__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==40) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // InternalModelDraw.g:3244:3: rule__Level__Group_7_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Level__Group_7_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getLevelAccess().getGroup_7_2()); 

            }


            }

        }
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


    // $ANTLR start "rule__Level__Group_7__3"
    // InternalModelDraw.g:3252:1: rule__Level__Group_7__3 : rule__Level__Group_7__3__Impl ;
    public final void rule__Level__Group_7__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3256:1: ( rule__Level__Group_7__3__Impl )
            // InternalModelDraw.g:3257:2: rule__Level__Group_7__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__3"


    // $ANTLR start "rule__Level__Group_7__3__Impl"
    // InternalModelDraw.g:3263:1: rule__Level__Group_7__3__Impl : ( ( rule__Level__LabelAssignment_7_3 ) ) ;
    public final void rule__Level__Group_7__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3267:1: ( ( ( rule__Level__LabelAssignment_7_3 ) ) )
            // InternalModelDraw.g:3268:1: ( ( rule__Level__LabelAssignment_7_3 ) )
            {
            // InternalModelDraw.g:3268:1: ( ( rule__Level__LabelAssignment_7_3 ) )
            // InternalModelDraw.g:3269:2: ( rule__Level__LabelAssignment_7_3 )
            {
             before(grammarAccess.getLevelAccess().getLabelAssignment_7_3()); 
            // InternalModelDraw.g:3270:2: ( rule__Level__LabelAssignment_7_3 )
            // InternalModelDraw.g:3270:3: rule__Level__LabelAssignment_7_3
            {
            pushFollow(FOLLOW_2);
            rule__Level__LabelAssignment_7_3();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getLabelAssignment_7_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7__3__Impl"


    // $ANTLR start "rule__Level__Group_7_2__0"
    // InternalModelDraw.g:3279:1: rule__Level__Group_7_2__0 : rule__Level__Group_7_2__0__Impl rule__Level__Group_7_2__1 ;
    public final void rule__Level__Group_7_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3283:1: ( rule__Level__Group_7_2__0__Impl rule__Level__Group_7_2__1 )
            // InternalModelDraw.g:3284:2: rule__Level__Group_7_2__0__Impl rule__Level__Group_7_2__1
            {
            pushFollow(FOLLOW_26);
            rule__Level__Group_7_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2__0"


    // $ANTLR start "rule__Level__Group_7_2__0__Impl"
    // InternalModelDraw.g:3291:1: rule__Level__Group_7_2__0__Impl : ( ( rule__Level__ReferenceAssignment_7_2_0 ) ) ;
    public final void rule__Level__Group_7_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3295:1: ( ( ( rule__Level__ReferenceAssignment_7_2_0 ) ) )
            // InternalModelDraw.g:3296:1: ( ( rule__Level__ReferenceAssignment_7_2_0 ) )
            {
            // InternalModelDraw.g:3296:1: ( ( rule__Level__ReferenceAssignment_7_2_0 ) )
            // InternalModelDraw.g:3297:2: ( rule__Level__ReferenceAssignment_7_2_0 )
            {
             before(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_0()); 
            // InternalModelDraw.g:3298:2: ( rule__Level__ReferenceAssignment_7_2_0 )
            // InternalModelDraw.g:3298:3: rule__Level__ReferenceAssignment_7_2_0
            {
            pushFollow(FOLLOW_2);
            rule__Level__ReferenceAssignment_7_2_0();

            state._fsp--;


            }

             after(grammarAccess.getLevelAccess().getReferenceAssignment_7_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2__0__Impl"


    // $ANTLR start "rule__Level__Group_7_2__1"
    // InternalModelDraw.g:3306:1: rule__Level__Group_7_2__1 : rule__Level__Group_7_2__1__Impl ;
    public final void rule__Level__Group_7_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3310:1: ( rule__Level__Group_7_2__1__Impl )
            // InternalModelDraw.g:3311:2: rule__Level__Group_7_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Level__Group_7_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2__1"


    // $ANTLR start "rule__Level__Group_7_2__1__Impl"
    // InternalModelDraw.g:3317:1: rule__Level__Group_7_2__1__Impl : ( '.' ) ;
    public final void rule__Level__Group_7_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3321:1: ( ( '.' ) )
            // InternalModelDraw.g:3322:1: ( '.' )
            {
            // InternalModelDraw.g:3322:1: ( '.' )
            // InternalModelDraw.g:3323:2: '.'
            {
             before(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getFullStopKeyword_7_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__Group_7_2__1__Impl"


    // $ANTLR start "rule__Level__Group_8__0"
    // InternalModelDraw.g:3333:1: rule__Level__Group_8__0 : rule__Level__Group_8__0__Impl rule__Level__Group_8__1 ;
    public final void rule__Level__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3337:1: ( rule__Level__Group_8__0__Impl rule__Level__Group_8__1 )
            // InternalModelDraw.g:3338:2: rule__Level__Group_8__0__Impl rule__Level__Group_8__1
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
    // InternalModelDraw.g:3345:1: rule__Level__Group_8__0__Impl : ( 'src_decoration' ) ;
    public final void rule__Level__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3349:1: ( ( 'src_decoration' ) )
            // InternalModelDraw.g:3350:1: ( 'src_decoration' )
            {
            // InternalModelDraw.g:3350:1: ( 'src_decoration' )
            // InternalModelDraw.g:3351:2: 'src_decoration'
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationKeyword_8_0()); 
            match(input,41,FOLLOW_2); 
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
    // InternalModelDraw.g:3360:1: rule__Level__Group_8__1 : rule__Level__Group_8__1__Impl rule__Level__Group_8__2 ;
    public final void rule__Level__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3364:1: ( rule__Level__Group_8__1__Impl rule__Level__Group_8__2 )
            // InternalModelDraw.g:3365:2: rule__Level__Group_8__1__Impl rule__Level__Group_8__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:3372:1: rule__Level__Group_8__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3376:1: ( ( '=' ) )
            // InternalModelDraw.g:3377:1: ( '=' )
            {
            // InternalModelDraw.g:3377:1: ( '=' )
            // InternalModelDraw.g:3378:2: '='
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
    // InternalModelDraw.g:3387:1: rule__Level__Group_8__2 : rule__Level__Group_8__2__Impl ;
    public final void rule__Level__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3391:1: ( rule__Level__Group_8__2__Impl )
            // InternalModelDraw.g:3392:2: rule__Level__Group_8__2__Impl
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
    // InternalModelDraw.g:3398:1: rule__Level__Group_8__2__Impl : ( ( rule__Level__Src_decorationAssignment_8_2 ) ) ;
    public final void rule__Level__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3402:1: ( ( ( rule__Level__Src_decorationAssignment_8_2 ) ) )
            // InternalModelDraw.g:3403:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            {
            // InternalModelDraw.g:3403:1: ( ( rule__Level__Src_decorationAssignment_8_2 ) )
            // InternalModelDraw.g:3404:2: ( rule__Level__Src_decorationAssignment_8_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_decorationAssignment_8_2()); 
            // InternalModelDraw.g:3405:2: ( rule__Level__Src_decorationAssignment_8_2 )
            // InternalModelDraw.g:3405:3: rule__Level__Src_decorationAssignment_8_2
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
    // InternalModelDraw.g:3414:1: rule__Level__Group_9__0 : rule__Level__Group_9__0__Impl rule__Level__Group_9__1 ;
    public final void rule__Level__Group_9__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3418:1: ( rule__Level__Group_9__0__Impl rule__Level__Group_9__1 )
            // InternalModelDraw.g:3419:2: rule__Level__Group_9__0__Impl rule__Level__Group_9__1
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
    // InternalModelDraw.g:3426:1: rule__Level__Group_9__0__Impl : ( 'src_label' ) ;
    public final void rule__Level__Group_9__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3430:1: ( ( 'src_label' ) )
            // InternalModelDraw.g:3431:1: ( 'src_label' )
            {
            // InternalModelDraw.g:3431:1: ( 'src_label' )
            // InternalModelDraw.g:3432:2: 'src_label'
            {
             before(grammarAccess.getLevelAccess().getSrc_labelKeyword_9_0()); 
            match(input,42,FOLLOW_2); 
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
    // InternalModelDraw.g:3441:1: rule__Level__Group_9__1 : rule__Level__Group_9__1__Impl rule__Level__Group_9__2 ;
    public final void rule__Level__Group_9__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3445:1: ( rule__Level__Group_9__1__Impl rule__Level__Group_9__2 )
            // InternalModelDraw.g:3446:2: rule__Level__Group_9__1__Impl rule__Level__Group_9__2
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
    // InternalModelDraw.g:3453:1: rule__Level__Group_9__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_9__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3457:1: ( ( '=' ) )
            // InternalModelDraw.g:3458:1: ( '=' )
            {
            // InternalModelDraw.g:3458:1: ( '=' )
            // InternalModelDraw.g:3459:2: '='
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
    // InternalModelDraw.g:3468:1: rule__Level__Group_9__2 : rule__Level__Group_9__2__Impl ;
    public final void rule__Level__Group_9__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3472:1: ( rule__Level__Group_9__2__Impl )
            // InternalModelDraw.g:3473:2: rule__Level__Group_9__2__Impl
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
    // InternalModelDraw.g:3479:1: rule__Level__Group_9__2__Impl : ( ( rule__Level__Src_labelAssignment_9_2 ) ) ;
    public final void rule__Level__Group_9__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3483:1: ( ( ( rule__Level__Src_labelAssignment_9_2 ) ) )
            // InternalModelDraw.g:3484:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            {
            // InternalModelDraw.g:3484:1: ( ( rule__Level__Src_labelAssignment_9_2 ) )
            // InternalModelDraw.g:3485:2: ( rule__Level__Src_labelAssignment_9_2 )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelAssignment_9_2()); 
            // InternalModelDraw.g:3486:2: ( rule__Level__Src_labelAssignment_9_2 )
            // InternalModelDraw.g:3486:3: rule__Level__Src_labelAssignment_9_2
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
    // InternalModelDraw.g:3495:1: rule__Level__Group_10__0 : rule__Level__Group_10__0__Impl rule__Level__Group_10__1 ;
    public final void rule__Level__Group_10__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3499:1: ( rule__Level__Group_10__0__Impl rule__Level__Group_10__1 )
            // InternalModelDraw.g:3500:2: rule__Level__Group_10__0__Impl rule__Level__Group_10__1
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
    // InternalModelDraw.g:3507:1: rule__Level__Group_10__0__Impl : ( 'tar_decoration' ) ;
    public final void rule__Level__Group_10__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3511:1: ( ( 'tar_decoration' ) )
            // InternalModelDraw.g:3512:1: ( 'tar_decoration' )
            {
            // InternalModelDraw.g:3512:1: ( 'tar_decoration' )
            // InternalModelDraw.g:3513:2: 'tar_decoration'
            {
             before(grammarAccess.getLevelAccess().getTar_decorationKeyword_10_0()); 
            match(input,43,FOLLOW_2); 
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
    // InternalModelDraw.g:3522:1: rule__Level__Group_10__1 : rule__Level__Group_10__1__Impl rule__Level__Group_10__2 ;
    public final void rule__Level__Group_10__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3526:1: ( rule__Level__Group_10__1__Impl rule__Level__Group_10__2 )
            // InternalModelDraw.g:3527:2: rule__Level__Group_10__1__Impl rule__Level__Group_10__2
            {
            pushFollow(FOLLOW_27);
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
    // InternalModelDraw.g:3534:1: rule__Level__Group_10__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_10__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3538:1: ( ( '=' ) )
            // InternalModelDraw.g:3539:1: ( '=' )
            {
            // InternalModelDraw.g:3539:1: ( '=' )
            // InternalModelDraw.g:3540:2: '='
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
    // InternalModelDraw.g:3549:1: rule__Level__Group_10__2 : rule__Level__Group_10__2__Impl ;
    public final void rule__Level__Group_10__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3553:1: ( rule__Level__Group_10__2__Impl )
            // InternalModelDraw.g:3554:2: rule__Level__Group_10__2__Impl
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
    // InternalModelDraw.g:3560:1: rule__Level__Group_10__2__Impl : ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) ;
    public final void rule__Level__Group_10__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3564:1: ( ( ( rule__Level__Tar_decorationAssignment_10_2 ) ) )
            // InternalModelDraw.g:3565:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            {
            // InternalModelDraw.g:3565:1: ( ( rule__Level__Tar_decorationAssignment_10_2 ) )
            // InternalModelDraw.g:3566:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_decorationAssignment_10_2()); 
            // InternalModelDraw.g:3567:2: ( rule__Level__Tar_decorationAssignment_10_2 )
            // InternalModelDraw.g:3567:3: rule__Level__Tar_decorationAssignment_10_2
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
    // InternalModelDraw.g:3576:1: rule__Level__Group_11__0 : rule__Level__Group_11__0__Impl rule__Level__Group_11__1 ;
    public final void rule__Level__Group_11__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3580:1: ( rule__Level__Group_11__0__Impl rule__Level__Group_11__1 )
            // InternalModelDraw.g:3581:2: rule__Level__Group_11__0__Impl rule__Level__Group_11__1
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
    // InternalModelDraw.g:3588:1: rule__Level__Group_11__0__Impl : ( 'tar_label' ) ;
    public final void rule__Level__Group_11__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3592:1: ( ( 'tar_label' ) )
            // InternalModelDraw.g:3593:1: ( 'tar_label' )
            {
            // InternalModelDraw.g:3593:1: ( 'tar_label' )
            // InternalModelDraw.g:3594:2: 'tar_label'
            {
             before(grammarAccess.getLevelAccess().getTar_labelKeyword_11_0()); 
            match(input,44,FOLLOW_2); 
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
    // InternalModelDraw.g:3603:1: rule__Level__Group_11__1 : rule__Level__Group_11__1__Impl rule__Level__Group_11__2 ;
    public final void rule__Level__Group_11__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3607:1: ( rule__Level__Group_11__1__Impl rule__Level__Group_11__2 )
            // InternalModelDraw.g:3608:2: rule__Level__Group_11__1__Impl rule__Level__Group_11__2
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
    // InternalModelDraw.g:3615:1: rule__Level__Group_11__1__Impl : ( '=' ) ;
    public final void rule__Level__Group_11__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3619:1: ( ( '=' ) )
            // InternalModelDraw.g:3620:1: ( '=' )
            {
            // InternalModelDraw.g:3620:1: ( '=' )
            // InternalModelDraw.g:3621:2: '='
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
    // InternalModelDraw.g:3630:1: rule__Level__Group_11__2 : rule__Level__Group_11__2__Impl ;
    public final void rule__Level__Group_11__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3634:1: ( rule__Level__Group_11__2__Impl )
            // InternalModelDraw.g:3635:2: rule__Level__Group_11__2__Impl
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
    // InternalModelDraw.g:3641:1: rule__Level__Group_11__2__Impl : ( ( rule__Level__Tar_labelAssignment_11_2 ) ) ;
    public final void rule__Level__Group_11__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3645:1: ( ( ( rule__Level__Tar_labelAssignment_11_2 ) ) )
            // InternalModelDraw.g:3646:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            {
            // InternalModelDraw.g:3646:1: ( ( rule__Level__Tar_labelAssignment_11_2 ) )
            // InternalModelDraw.g:3647:2: ( rule__Level__Tar_labelAssignment_11_2 )
            {
             before(grammarAccess.getLevelAccess().getTar_labelAssignment_11_2()); 
            // InternalModelDraw.g:3648:2: ( rule__Level__Tar_labelAssignment_11_2 )
            // InternalModelDraw.g:3648:3: rule__Level__Tar_labelAssignment_11_2
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
    // InternalModelDraw.g:3657:1: rule__Content__Group__0 : rule__Content__Group__0__Impl rule__Content__Group__1 ;
    public final void rule__Content__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3661:1: ( rule__Content__Group__0__Impl rule__Content__Group__1 )
            // InternalModelDraw.g:3662:2: rule__Content__Group__0__Impl rule__Content__Group__1
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
    // InternalModelDraw.g:3669:1: rule__Content__Group__0__Impl : ( () ) ;
    public final void rule__Content__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3673:1: ( ( () ) )
            // InternalModelDraw.g:3674:1: ( () )
            {
            // InternalModelDraw.g:3674:1: ( () )
            // InternalModelDraw.g:3675:2: ()
            {
             before(grammarAccess.getContentAccess().getContentAction_0()); 
            // InternalModelDraw.g:3676:2: ()
            // InternalModelDraw.g:3676:3: 
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
    // InternalModelDraw.g:3684:1: rule__Content__Group__1 : rule__Content__Group__1__Impl rule__Content__Group__2 ;
    public final void rule__Content__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3688:1: ( rule__Content__Group__1__Impl rule__Content__Group__2 )
            // InternalModelDraw.g:3689:2: rule__Content__Group__1__Impl rule__Content__Group__2
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
    // InternalModelDraw.g:3696:1: rule__Content__Group__1__Impl : ( ( rule__Content__NameAssignment_1 ) ) ;
    public final void rule__Content__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3700:1: ( ( ( rule__Content__NameAssignment_1 ) ) )
            // InternalModelDraw.g:3701:1: ( ( rule__Content__NameAssignment_1 ) )
            {
            // InternalModelDraw.g:3701:1: ( ( rule__Content__NameAssignment_1 ) )
            // InternalModelDraw.g:3702:2: ( rule__Content__NameAssignment_1 )
            {
             before(grammarAccess.getContentAccess().getNameAssignment_1()); 
            // InternalModelDraw.g:3703:2: ( rule__Content__NameAssignment_1 )
            // InternalModelDraw.g:3703:3: rule__Content__NameAssignment_1
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
    // InternalModelDraw.g:3711:1: rule__Content__Group__2 : rule__Content__Group__2__Impl rule__Content__Group__3 ;
    public final void rule__Content__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3715:1: ( rule__Content__Group__2__Impl rule__Content__Group__3 )
            // InternalModelDraw.g:3716:2: rule__Content__Group__2__Impl rule__Content__Group__3
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:3723:1: rule__Content__Group__2__Impl : ( ':' ) ;
    public final void rule__Content__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3727:1: ( ( ':' ) )
            // InternalModelDraw.g:3728:1: ( ':' )
            {
            // InternalModelDraw.g:3728:1: ( ':' )
            // InternalModelDraw.g:3729:2: ':'
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
    // InternalModelDraw.g:3738:1: rule__Content__Group__3 : rule__Content__Group__3__Impl rule__Content__Group__4 ;
    public final void rule__Content__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3742:1: ( rule__Content__Group__3__Impl rule__Content__Group__4 )
            // InternalModelDraw.g:3743:2: rule__Content__Group__3__Impl rule__Content__Group__4
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:3750:1: rule__Content__Group__3__Impl : ( ( rule__Content__Group_3__0 )? ) ;
    public final void rule__Content__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3754:1: ( ( ( rule__Content__Group_3__0 )? ) )
            // InternalModelDraw.g:3755:1: ( ( rule__Content__Group_3__0 )? )
            {
            // InternalModelDraw.g:3755:1: ( ( rule__Content__Group_3__0 )? )
            // InternalModelDraw.g:3756:2: ( rule__Content__Group_3__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_3()); 
            // InternalModelDraw.g:3757:2: ( rule__Content__Group_3__0 )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==46) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // InternalModelDraw.g:3757:3: rule__Content__Group_3__0
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
    // InternalModelDraw.g:3765:1: rule__Content__Group__4 : rule__Content__Group__4__Impl rule__Content__Group__5 ;
    public final void rule__Content__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3769:1: ( rule__Content__Group__4__Impl rule__Content__Group__5 )
            // InternalModelDraw.g:3770:2: rule__Content__Group__4__Impl rule__Content__Group__5
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:3777:1: rule__Content__Group__4__Impl : ( ( rule__Content__Group_4__0 )? ) ;
    public final void rule__Content__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3781:1: ( ( ( rule__Content__Group_4__0 )? ) )
            // InternalModelDraw.g:3782:1: ( ( rule__Content__Group_4__0 )? )
            {
            // InternalModelDraw.g:3782:1: ( ( rule__Content__Group_4__0 )? )
            // InternalModelDraw.g:3783:2: ( rule__Content__Group_4__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_4()); 
            // InternalModelDraw.g:3784:2: ( rule__Content__Group_4__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==EOF||LA34_1==RULE_ID||(LA34_1>=28 && LA34_1<=29)||LA34_1==40||LA34_1==45) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // InternalModelDraw.g:3784:3: rule__Content__Group_4__0
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
    // InternalModelDraw.g:3792:1: rule__Content__Group__5 : rule__Content__Group__5__Impl rule__Content__Group__6 ;
    public final void rule__Content__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3796:1: ( rule__Content__Group__5__Impl rule__Content__Group__6 )
            // InternalModelDraw.g:3797:2: rule__Content__Group__5__Impl rule__Content__Group__6
            {
            pushFollow(FOLLOW_28);
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
    // InternalModelDraw.g:3804:1: rule__Content__Group__5__Impl : ( ( rule__Content__Group_5__0 )? ) ;
    public final void rule__Content__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3808:1: ( ( ( rule__Content__Group_5__0 )? ) )
            // InternalModelDraw.g:3809:1: ( ( rule__Content__Group_5__0 )? )
            {
            // InternalModelDraw.g:3809:1: ( ( rule__Content__Group_5__0 )? )
            // InternalModelDraw.g:3810:2: ( rule__Content__Group_5__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_5()); 
            // InternalModelDraw.g:3811:2: ( rule__Content__Group_5__0 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==28) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalModelDraw.g:3811:3: rule__Content__Group_5__0
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
    // InternalModelDraw.g:3819:1: rule__Content__Group__6 : rule__Content__Group__6__Impl ;
    public final void rule__Content__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3823:1: ( rule__Content__Group__6__Impl )
            // InternalModelDraw.g:3824:2: rule__Content__Group__6__Impl
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
    // InternalModelDraw.g:3830:1: rule__Content__Group__6__Impl : ( ( rule__Content__Group_6__0 )? ) ;
    public final void rule__Content__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3834:1: ( ( ( rule__Content__Group_6__0 )? ) )
            // InternalModelDraw.g:3835:1: ( ( rule__Content__Group_6__0 )? )
            {
            // InternalModelDraw.g:3835:1: ( ( rule__Content__Group_6__0 )? )
            // InternalModelDraw.g:3836:2: ( rule__Content__Group_6__0 )?
            {
             before(grammarAccess.getContentAccess().getGroup_6()); 
            // InternalModelDraw.g:3837:2: ( rule__Content__Group_6__0 )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==45) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalModelDraw.g:3837:3: rule__Content__Group_6__0
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
    // InternalModelDraw.g:3846:1: rule__Content__Group_3__0 : rule__Content__Group_3__0__Impl rule__Content__Group_3__1 ;
    public final void rule__Content__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3850:1: ( rule__Content__Group_3__0__Impl rule__Content__Group_3__1 )
            // InternalModelDraw.g:3851:2: rule__Content__Group_3__0__Impl rule__Content__Group_3__1
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
    // InternalModelDraw.g:3858:1: rule__Content__Group_3__0__Impl : ( ( rule__Content__NodenumAssignment_3_0 ) ) ;
    public final void rule__Content__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3862:1: ( ( ( rule__Content__NodenumAssignment_3_0 ) ) )
            // InternalModelDraw.g:3863:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            {
            // InternalModelDraw.g:3863:1: ( ( rule__Content__NodenumAssignment_3_0 ) )
            // InternalModelDraw.g:3864:2: ( rule__Content__NodenumAssignment_3_0 )
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_0()); 
            // InternalModelDraw.g:3865:2: ( rule__Content__NodenumAssignment_3_0 )
            // InternalModelDraw.g:3865:3: rule__Content__NodenumAssignment_3_0
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
    // InternalModelDraw.g:3873:1: rule__Content__Group_3__1 : rule__Content__Group_3__1__Impl ;
    public final void rule__Content__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3877:1: ( rule__Content__Group_3__1__Impl )
            // InternalModelDraw.g:3878:2: rule__Content__Group_3__1__Impl
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
    // InternalModelDraw.g:3884:1: rule__Content__Group_3__1__Impl : ( ( rule__Content__NodenumAssignment_3_1 )* ) ;
    public final void rule__Content__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3888:1: ( ( ( rule__Content__NodenumAssignment_3_1 )* ) )
            // InternalModelDraw.g:3889:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            {
            // InternalModelDraw.g:3889:1: ( ( rule__Content__NodenumAssignment_3_1 )* )
            // InternalModelDraw.g:3890:2: ( rule__Content__NodenumAssignment_3_1 )*
            {
             before(grammarAccess.getContentAccess().getNodenumAssignment_3_1()); 
            // InternalModelDraw.g:3891:2: ( rule__Content__NodenumAssignment_3_1 )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==RULE_ID) ) {
                    int LA37_1 = input.LA(2);

                    if ( (LA37_1==46) ) {
                        alt37=1;
                    }


                }


                switch (alt37) {
            	case 1 :
            	    // InternalModelDraw.g:3891:3: rule__Content__NodenumAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Content__NodenumAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop37;
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
    // InternalModelDraw.g:3900:1: rule__Content__Group_4__0 : rule__Content__Group_4__0__Impl rule__Content__Group_4__1 ;
    public final void rule__Content__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3904:1: ( rule__Content__Group_4__0__Impl rule__Content__Group_4__1 )
            // InternalModelDraw.g:3905:2: rule__Content__Group_4__0__Impl rule__Content__Group_4__1
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
    // InternalModelDraw.g:3912:1: rule__Content__Group_4__0__Impl : ( ( rule__Content__InfoAssignment_4_0 ) ) ;
    public final void rule__Content__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3916:1: ( ( ( rule__Content__InfoAssignment_4_0 ) ) )
            // InternalModelDraw.g:3917:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            {
            // InternalModelDraw.g:3917:1: ( ( rule__Content__InfoAssignment_4_0 ) )
            // InternalModelDraw.g:3918:2: ( rule__Content__InfoAssignment_4_0 )
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_0()); 
            // InternalModelDraw.g:3919:2: ( rule__Content__InfoAssignment_4_0 )
            // InternalModelDraw.g:3919:3: rule__Content__InfoAssignment_4_0
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
    // InternalModelDraw.g:3927:1: rule__Content__Group_4__1 : rule__Content__Group_4__1__Impl ;
    public final void rule__Content__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3931:1: ( rule__Content__Group_4__1__Impl )
            // InternalModelDraw.g:3932:2: rule__Content__Group_4__1__Impl
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
    // InternalModelDraw.g:3938:1: rule__Content__Group_4__1__Impl : ( ( rule__Content__InfoAssignment_4_1 )* ) ;
    public final void rule__Content__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3942:1: ( ( ( rule__Content__InfoAssignment_4_1 )* ) )
            // InternalModelDraw.g:3943:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            {
            // InternalModelDraw.g:3943:1: ( ( rule__Content__InfoAssignment_4_1 )* )
            // InternalModelDraw.g:3944:2: ( rule__Content__InfoAssignment_4_1 )*
            {
             before(grammarAccess.getContentAccess().getInfoAssignment_4_1()); 
            // InternalModelDraw.g:3945:2: ( rule__Content__InfoAssignment_4_1 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    int LA38_2 = input.LA(2);

                    if ( (LA38_2==EOF||LA38_2==RULE_ID||(LA38_2>=28 && LA38_2<=29)||LA38_2==40||LA38_2==45) ) {
                        alt38=1;
                    }


                }


                switch (alt38) {
            	case 1 :
            	    // InternalModelDraw.g:3945:3: rule__Content__InfoAssignment_4_1
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__Content__InfoAssignment_4_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // InternalModelDraw.g:3954:1: rule__Content__Group_5__0 : rule__Content__Group_5__0__Impl rule__Content__Group_5__1 ;
    public final void rule__Content__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3958:1: ( rule__Content__Group_5__0__Impl rule__Content__Group_5__1 )
            // InternalModelDraw.g:3959:2: rule__Content__Group_5__0__Impl rule__Content__Group_5__1
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
    // InternalModelDraw.g:3966:1: rule__Content__Group_5__0__Impl : ( '{' ) ;
    public final void rule__Content__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3970:1: ( ( '{' ) )
            // InternalModelDraw.g:3971:1: ( '{' )
            {
            // InternalModelDraw.g:3971:1: ( '{' )
            // InternalModelDraw.g:3972:2: '{'
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
    // InternalModelDraw.g:3981:1: rule__Content__Group_5__1 : rule__Content__Group_5__1__Impl rule__Content__Group_5__2 ;
    public final void rule__Content__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3985:1: ( rule__Content__Group_5__1__Impl rule__Content__Group_5__2 )
            // InternalModelDraw.g:3986:2: rule__Content__Group_5__1__Impl rule__Content__Group_5__2
            {
            pushFollow(FOLLOW_29);
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
    // InternalModelDraw.g:3993:1: rule__Content__Group_5__1__Impl : ( ( rule__Content__AttNameAssignment_5_1 ) ) ;
    public final void rule__Content__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:3997:1: ( ( ( rule__Content__AttNameAssignment_5_1 ) ) )
            // InternalModelDraw.g:3998:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            {
            // InternalModelDraw.g:3998:1: ( ( rule__Content__AttNameAssignment_5_1 ) )
            // InternalModelDraw.g:3999:2: ( rule__Content__AttNameAssignment_5_1 )
            {
             before(grammarAccess.getContentAccess().getAttNameAssignment_5_1()); 
            // InternalModelDraw.g:4000:2: ( rule__Content__AttNameAssignment_5_1 )
            // InternalModelDraw.g:4000:3: rule__Content__AttNameAssignment_5_1
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
    // InternalModelDraw.g:4008:1: rule__Content__Group_5__2 : rule__Content__Group_5__2__Impl ;
    public final void rule__Content__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4012:1: ( rule__Content__Group_5__2__Impl )
            // InternalModelDraw.g:4013:2: rule__Content__Group_5__2__Impl
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
    // InternalModelDraw.g:4019:1: rule__Content__Group_5__2__Impl : ( '}' ) ;
    public final void rule__Content__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4023:1: ( ( '}' ) )
            // InternalModelDraw.g:4024:1: ( '}' )
            {
            // InternalModelDraw.g:4024:1: ( '}' )
            // InternalModelDraw.g:4025:2: '}'
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
    // InternalModelDraw.g:4035:1: rule__Content__Group_6__0 : rule__Content__Group_6__0__Impl rule__Content__Group_6__1 ;
    public final void rule__Content__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4039:1: ( rule__Content__Group_6__0__Impl rule__Content__Group_6__1 )
            // InternalModelDraw.g:4040:2: rule__Content__Group_6__0__Impl rule__Content__Group_6__1
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
    // InternalModelDraw.g:4047:1: rule__Content__Group_6__0__Impl : ( 'text' ) ;
    public final void rule__Content__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4051:1: ( ( 'text' ) )
            // InternalModelDraw.g:4052:1: ( 'text' )
            {
            // InternalModelDraw.g:4052:1: ( 'text' )
            // InternalModelDraw.g:4053:2: 'text'
            {
             before(grammarAccess.getContentAccess().getTextKeyword_6_0()); 
            match(input,45,FOLLOW_2); 
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
    // InternalModelDraw.g:4062:1: rule__Content__Group_6__1 : rule__Content__Group_6__1__Impl rule__Content__Group_6__2 ;
    public final void rule__Content__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4066:1: ( rule__Content__Group_6__1__Impl rule__Content__Group_6__2 )
            // InternalModelDraw.g:4067:2: rule__Content__Group_6__1__Impl rule__Content__Group_6__2
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
    // InternalModelDraw.g:4074:1: rule__Content__Group_6__1__Impl : ( '=' ) ;
    public final void rule__Content__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4078:1: ( ( '=' ) )
            // InternalModelDraw.g:4079:1: ( '=' )
            {
            // InternalModelDraw.g:4079:1: ( '=' )
            // InternalModelDraw.g:4080:2: '='
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
    // InternalModelDraw.g:4089:1: rule__Content__Group_6__2 : rule__Content__Group_6__2__Impl ;
    public final void rule__Content__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4093:1: ( rule__Content__Group_6__2__Impl )
            // InternalModelDraw.g:4094:2: rule__Content__Group_6__2__Impl
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
    // InternalModelDraw.g:4100:1: rule__Content__Group_6__2__Impl : ( ( rule__Content__SymbolAssignment_6_2 ) ) ;
    public final void rule__Content__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4104:1: ( ( ( rule__Content__SymbolAssignment_6_2 ) ) )
            // InternalModelDraw.g:4105:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            {
            // InternalModelDraw.g:4105:1: ( ( rule__Content__SymbolAssignment_6_2 ) )
            // InternalModelDraw.g:4106:2: ( rule__Content__SymbolAssignment_6_2 )
            {
             before(grammarAccess.getContentAccess().getSymbolAssignment_6_2()); 
            // InternalModelDraw.g:4107:2: ( rule__Content__SymbolAssignment_6_2 )
            // InternalModelDraw.g:4107:3: rule__Content__SymbolAssignment_6_2
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
    // InternalModelDraw.g:4116:1: rule__NodeEnumerator__Group__0 : rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 ;
    public final void rule__NodeEnumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4120:1: ( rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1 )
            // InternalModelDraw.g:4121:2: rule__NodeEnumerator__Group__0__Impl rule__NodeEnumerator__Group__1
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
    // InternalModelDraw.g:4128:1: rule__NodeEnumerator__Group__0__Impl : ( () ) ;
    public final void rule__NodeEnumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4132:1: ( ( () ) )
            // InternalModelDraw.g:4133:1: ( () )
            {
            // InternalModelDraw.g:4133:1: ( () )
            // InternalModelDraw.g:4134:2: ()
            {
             before(grammarAccess.getNodeEnumeratorAccess().getNodeEnumeratorAction_0()); 
            // InternalModelDraw.g:4135:2: ()
            // InternalModelDraw.g:4135:3: 
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
    // InternalModelDraw.g:4143:1: rule__NodeEnumerator__Group__1 : rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 ;
    public final void rule__NodeEnumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4147:1: ( rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2 )
            // InternalModelDraw.g:4148:2: rule__NodeEnumerator__Group__1__Impl rule__NodeEnumerator__Group__2
            {
            pushFollow(FOLLOW_30);
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
    // InternalModelDraw.g:4155:1: rule__NodeEnumerator__Group__1__Impl : ( ( rule__NodeEnumerator__AttAssignment_1 ) ) ;
    public final void rule__NodeEnumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4159:1: ( ( ( rule__NodeEnumerator__AttAssignment_1 ) ) )
            // InternalModelDraw.g:4160:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            {
            // InternalModelDraw.g:4160:1: ( ( rule__NodeEnumerator__AttAssignment_1 ) )
            // InternalModelDraw.g:4161:2: ( rule__NodeEnumerator__AttAssignment_1 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttAssignment_1()); 
            // InternalModelDraw.g:4162:2: ( rule__NodeEnumerator__AttAssignment_1 )
            // InternalModelDraw.g:4162:3: rule__NodeEnumerator__AttAssignment_1
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
    // InternalModelDraw.g:4170:1: rule__NodeEnumerator__Group__2 : rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 ;
    public final void rule__NodeEnumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4174:1: ( rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3 )
            // InternalModelDraw.g:4175:2: rule__NodeEnumerator__Group__2__Impl rule__NodeEnumerator__Group__3
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
    // InternalModelDraw.g:4182:1: rule__NodeEnumerator__Group__2__Impl : ( '[' ) ;
    public final void rule__NodeEnumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4186:1: ( ( '[' ) )
            // InternalModelDraw.g:4187:1: ( '[' )
            {
            // InternalModelDraw.g:4187:1: ( '[' )
            // InternalModelDraw.g:4188:2: '['
            {
             before(grammarAccess.getNodeEnumeratorAccess().getLeftSquareBracketKeyword_2()); 
            match(input,46,FOLLOW_2); 
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
    // InternalModelDraw.g:4197:1: rule__NodeEnumerator__Group__3 : rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 ;
    public final void rule__NodeEnumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4201:1: ( rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4 )
            // InternalModelDraw.g:4202:2: rule__NodeEnumerator__Group__3__Impl rule__NodeEnumerator__Group__4
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:4209:1: rule__NodeEnumerator__Group__3__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) ;
    public final void rule__NodeEnumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4213:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) ) )
            // InternalModelDraw.g:4214:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            {
            // InternalModelDraw.g:4214:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_3 ) )
            // InternalModelDraw.g:4215:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_3()); 
            // InternalModelDraw.g:4216:2: ( rule__NodeEnumerator__EnumeratorAssignment_3 )
            // InternalModelDraw.g:4216:3: rule__NodeEnumerator__EnumeratorAssignment_3
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
    // InternalModelDraw.g:4224:1: rule__NodeEnumerator__Group__4 : rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 ;
    public final void rule__NodeEnumerator__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4228:1: ( rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5 )
            // InternalModelDraw.g:4229:2: rule__NodeEnumerator__Group__4__Impl rule__NodeEnumerator__Group__5
            {
            pushFollow(FOLLOW_31);
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
    // InternalModelDraw.g:4236:1: rule__NodeEnumerator__Group__4__Impl : ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) ;
    public final void rule__NodeEnumerator__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4240:1: ( ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* ) )
            // InternalModelDraw.g:4241:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            {
            // InternalModelDraw.g:4241:1: ( ( rule__NodeEnumerator__EnumeratorAssignment_4 )* )
            // InternalModelDraw.g:4242:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            {
             before(grammarAccess.getNodeEnumeratorAccess().getEnumeratorAssignment_4()); 
            // InternalModelDraw.g:4243:2: ( rule__NodeEnumerator__EnumeratorAssignment_4 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalModelDraw.g:4243:3: rule__NodeEnumerator__EnumeratorAssignment_4
            	    {
            	    pushFollow(FOLLOW_10);
            	    rule__NodeEnumerator__EnumeratorAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
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
    // InternalModelDraw.g:4251:1: rule__NodeEnumerator__Group__5 : rule__NodeEnumerator__Group__5__Impl ;
    public final void rule__NodeEnumerator__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4255:1: ( rule__NodeEnumerator__Group__5__Impl )
            // InternalModelDraw.g:4256:2: rule__NodeEnumerator__Group__5__Impl
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
    // InternalModelDraw.g:4262:1: rule__NodeEnumerator__Group__5__Impl : ( ']' ) ;
    public final void rule__NodeEnumerator__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4266:1: ( ( ']' ) )
            // InternalModelDraw.g:4267:1: ( ']' )
            {
            // InternalModelDraw.g:4267:1: ( ']' )
            // InternalModelDraw.g:4268:2: ']'
            {
             before(grammarAccess.getNodeEnumeratorAccess().getRightSquareBracketKeyword_5()); 
            match(input,47,FOLLOW_2); 
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
    // InternalModelDraw.g:4278:1: rule__Enumerator__Group__0 : rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 ;
    public final void rule__Enumerator__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4282:1: ( rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1 )
            // InternalModelDraw.g:4283:2: rule__Enumerator__Group__0__Impl rule__Enumerator__Group__1
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
    // InternalModelDraw.g:4290:1: rule__Enumerator__Group__0__Impl : ( () ) ;
    public final void rule__Enumerator__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4294:1: ( ( () ) )
            // InternalModelDraw.g:4295:1: ( () )
            {
            // InternalModelDraw.g:4295:1: ( () )
            // InternalModelDraw.g:4296:2: ()
            {
             before(grammarAccess.getEnumeratorAccess().getEnumeratorAction_0()); 
            // InternalModelDraw.g:4297:2: ()
            // InternalModelDraw.g:4297:3: 
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
    // InternalModelDraw.g:4305:1: rule__Enumerator__Group__1 : rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 ;
    public final void rule__Enumerator__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4309:1: ( rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2 )
            // InternalModelDraw.g:4310:2: rule__Enumerator__Group__1__Impl rule__Enumerator__Group__2
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
    // InternalModelDraw.g:4317:1: rule__Enumerator__Group__1__Impl : ( ( rule__Enumerator__LiteralAssignment_1 ) ) ;
    public final void rule__Enumerator__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4321:1: ( ( ( rule__Enumerator__LiteralAssignment_1 ) ) )
            // InternalModelDraw.g:4322:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            {
            // InternalModelDraw.g:4322:1: ( ( rule__Enumerator__LiteralAssignment_1 ) )
            // InternalModelDraw.g:4323:2: ( rule__Enumerator__LiteralAssignment_1 )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralAssignment_1()); 
            // InternalModelDraw.g:4324:2: ( rule__Enumerator__LiteralAssignment_1 )
            // InternalModelDraw.g:4324:3: rule__Enumerator__LiteralAssignment_1
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
    // InternalModelDraw.g:4332:1: rule__Enumerator__Group__2 : rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 ;
    public final void rule__Enumerator__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4336:1: ( rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3 )
            // InternalModelDraw.g:4337:2: rule__Enumerator__Group__2__Impl rule__Enumerator__Group__3
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
    // InternalModelDraw.g:4344:1: rule__Enumerator__Group__2__Impl : ( '=' ) ;
    public final void rule__Enumerator__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4348:1: ( ( '=' ) )
            // InternalModelDraw.g:4349:1: ( '=' )
            {
            // InternalModelDraw.g:4349:1: ( '=' )
            // InternalModelDraw.g:4350:2: '='
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
    // InternalModelDraw.g:4359:1: rule__Enumerator__Group__3 : rule__Enumerator__Group__3__Impl ;
    public final void rule__Enumerator__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4363:1: ( rule__Enumerator__Group__3__Impl )
            // InternalModelDraw.g:4364:2: rule__Enumerator__Group__3__Impl
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
    // InternalModelDraw.g:4370:1: rule__Enumerator__Group__3__Impl : ( ( rule__Enumerator__ValueAssignment_3 ) ) ;
    public final void rule__Enumerator__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4374:1: ( ( ( rule__Enumerator__ValueAssignment_3 ) ) )
            // InternalModelDraw.g:4375:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            {
            // InternalModelDraw.g:4375:1: ( ( rule__Enumerator__ValueAssignment_3 ) )
            // InternalModelDraw.g:4376:2: ( rule__Enumerator__ValueAssignment_3 )
            {
             before(grammarAccess.getEnumeratorAccess().getValueAssignment_3()); 
            // InternalModelDraw.g:4377:2: ( rule__Enumerator__ValueAssignment_3 )
            // InternalModelDraw.g:4377:3: rule__Enumerator__ValueAssignment_3
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
    // InternalModelDraw.g:4386:1: rule__Information__Group__0 : rule__Information__Group__0__Impl rule__Information__Group__1 ;
    public final void rule__Information__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4390:1: ( rule__Information__Group__0__Impl rule__Information__Group__1 )
            // InternalModelDraw.g:4391:2: rule__Information__Group__0__Impl rule__Information__Group__1
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
    // InternalModelDraw.g:4398:1: rule__Information__Group__0__Impl : ( () ) ;
    public final void rule__Information__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4402:1: ( ( () ) )
            // InternalModelDraw.g:4403:1: ( () )
            {
            // InternalModelDraw.g:4403:1: ( () )
            // InternalModelDraw.g:4404:2: ()
            {
             before(grammarAccess.getInformationAccess().getInformationAction_0()); 
            // InternalModelDraw.g:4405:2: ()
            // InternalModelDraw.g:4405:3: 
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
    // InternalModelDraw.g:4413:1: rule__Information__Group__1 : rule__Information__Group__1__Impl rule__Information__Group__2 ;
    public final void rule__Information__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4417:1: ( rule__Information__Group__1__Impl rule__Information__Group__2 )
            // InternalModelDraw.g:4418:2: rule__Information__Group__1__Impl rule__Information__Group__2
            {
            pushFollow(FOLLOW_26);
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
    // InternalModelDraw.g:4425:1: rule__Information__Group__1__Impl : ( ( rule__Information__TypeAssignment_1 ) ) ;
    public final void rule__Information__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4429:1: ( ( ( rule__Information__TypeAssignment_1 ) ) )
            // InternalModelDraw.g:4430:1: ( ( rule__Information__TypeAssignment_1 ) )
            {
            // InternalModelDraw.g:4430:1: ( ( rule__Information__TypeAssignment_1 ) )
            // InternalModelDraw.g:4431:2: ( rule__Information__TypeAssignment_1 )
            {
             before(grammarAccess.getInformationAccess().getTypeAssignment_1()); 
            // InternalModelDraw.g:4432:2: ( rule__Information__TypeAssignment_1 )
            // InternalModelDraw.g:4432:3: rule__Information__TypeAssignment_1
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
    // InternalModelDraw.g:4440:1: rule__Information__Group__2 : rule__Information__Group__2__Impl ;
    public final void rule__Information__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4444:1: ( rule__Information__Group__2__Impl )
            // InternalModelDraw.g:4445:2: rule__Information__Group__2__Impl
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
    // InternalModelDraw.g:4451:1: rule__Information__Group__2__Impl : ( ( rule__Information__Group_2__0 )? ) ;
    public final void rule__Information__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4455:1: ( ( ( rule__Information__Group_2__0 )? ) )
            // InternalModelDraw.g:4456:1: ( ( rule__Information__Group_2__0 )? )
            {
            // InternalModelDraw.g:4456:1: ( ( rule__Information__Group_2__0 )? )
            // InternalModelDraw.g:4457:2: ( rule__Information__Group_2__0 )?
            {
             before(grammarAccess.getInformationAccess().getGroup_2()); 
            // InternalModelDraw.g:4458:2: ( rule__Information__Group_2__0 )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==40) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalModelDraw.g:4458:3: rule__Information__Group_2__0
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
    // InternalModelDraw.g:4467:1: rule__Information__Group_2__0 : rule__Information__Group_2__0__Impl rule__Information__Group_2__1 ;
    public final void rule__Information__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4471:1: ( rule__Information__Group_2__0__Impl rule__Information__Group_2__1 )
            // InternalModelDraw.g:4472:2: rule__Information__Group_2__0__Impl rule__Information__Group_2__1
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
    // InternalModelDraw.g:4479:1: rule__Information__Group_2__0__Impl : ( '.' ) ;
    public final void rule__Information__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4483:1: ( ( '.' ) )
            // InternalModelDraw.g:4484:1: ( '.' )
            {
            // InternalModelDraw.g:4484:1: ( '.' )
            // InternalModelDraw.g:4485:2: '.'
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
    // InternalModelDraw.g:4494:1: rule__Information__Group_2__1 : rule__Information__Group_2__1__Impl ;
    public final void rule__Information__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4498:1: ( rule__Information__Group_2__1__Impl )
            // InternalModelDraw.g:4499:2: rule__Information__Group_2__1__Impl
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
    // InternalModelDraw.g:4505:1: rule__Information__Group_2__1__Impl : ( ( rule__Information__AttAssignment_2_1 ) ) ;
    public final void rule__Information__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4509:1: ( ( ( rule__Information__AttAssignment_2_1 ) ) )
            // InternalModelDraw.g:4510:1: ( ( rule__Information__AttAssignment_2_1 ) )
            {
            // InternalModelDraw.g:4510:1: ( ( rule__Information__AttAssignment_2_1 ) )
            // InternalModelDraw.g:4511:2: ( rule__Information__AttAssignment_2_1 )
            {
             before(grammarAccess.getInformationAccess().getAttAssignment_2_1()); 
            // InternalModelDraw.g:4512:2: ( rule__Information__AttAssignment_2_1 )
            // InternalModelDraw.g:4512:3: rule__Information__AttAssignment_2_1
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
    // InternalModelDraw.g:4521:1: rule__MutatorDraw__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__MutatorDraw__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4525:1: ( ( ruleEString ) )
            // InternalModelDraw.g:4526:2: ( ruleEString )
            {
            // InternalModelDraw.g:4526:2: ( ruleEString )
            // InternalModelDraw.g:4527:3: ruleEString
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
    // InternalModelDraw.g:4536:1: rule__MutatorDraw__NameAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MutatorDraw__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4540:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4541:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4541:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4542:3: ( RULE_ID )
            {
             before(grammarAccess.getMutatorDrawAccess().getNameEClassCrossReference_3_0()); 
            // InternalModelDraw.g:4543:3: ( RULE_ID )
            // InternalModelDraw.g:4544:4: RULE_ID
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
    // InternalModelDraw.g:4555:1: rule__MutatorDraw__TypeAssignment_5 : ( ruleDrawType ) ;
    public final void rule__MutatorDraw__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4559:1: ( ( ruleDrawType ) )
            // InternalModelDraw.g:4560:2: ( ruleDrawType )
            {
            // InternalModelDraw.g:4560:2: ( ruleDrawType )
            // InternalModelDraw.g:4561:3: ruleDrawType
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
    // InternalModelDraw.g:4570:1: rule__MutatorDraw__NodesAssignment_7 : ( ruleNode ) ;
    public final void rule__MutatorDraw__NodesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4574:1: ( ( ruleNode ) )
            // InternalModelDraw.g:4575:2: ( ruleNode )
            {
            // InternalModelDraw.g:4575:2: ( ruleNode )
            // InternalModelDraw.g:4576:3: ruleNode
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
    // InternalModelDraw.g:4585:1: rule__MutatorDraw__RelationsAssignment_8 : ( ruleRelation ) ;
    public final void rule__MutatorDraw__RelationsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4589:1: ( ( ruleRelation ) )
            // InternalModelDraw.g:4590:2: ( ruleRelation )
            {
            // InternalModelDraw.g:4590:2: ( ruleRelation )
            // InternalModelDraw.g:4591:3: ruleRelation
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
    // InternalModelDraw.g:4600:1: rule__MutatorDraw__ContentsAssignment_9 : ( ruleContent ) ;
    public final void rule__MutatorDraw__ContentsAssignment_9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4604:1: ( ( ruleContent ) )
            // InternalModelDraw.g:4605:2: ( ruleContent )
            {
            // InternalModelDraw.g:4605:2: ( ruleContent )
            // InternalModelDraw.g:4606:3: ruleContent
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
    // InternalModelDraw.g:4615:1: rule__Node__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4619:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4620:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4620:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4621:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:4622:3: ( RULE_ID )
            // InternalModelDraw.g:4623:4: RULE_ID
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
    // InternalModelDraw.g:4634:1: rule__Node__AttributeAssignment_2_1 : ( ruleBooleanAttribute ) ;
    public final void rule__Node__AttributeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4638:1: ( ( ruleBooleanAttribute ) )
            // InternalModelDraw.g:4639:2: ( ruleBooleanAttribute )
            {
            // InternalModelDraw.g:4639:2: ( ruleBooleanAttribute )
            // InternalModelDraw.g:4640:3: ruleBooleanAttribute
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
    // InternalModelDraw.g:4649:1: rule__Node__AttributeAssignment_2_2_1 : ( ruleBooleanAttribute ) ;
    public final void rule__Node__AttributeAssignment_2_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4653:1: ( ( ruleBooleanAttribute ) )
            // InternalModelDraw.g:4654:2: ( ruleBooleanAttribute )
            {
            // InternalModelDraw.g:4654:2: ( ruleBooleanAttribute )
            // InternalModelDraw.g:4655:3: ruleBooleanAttribute
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
    // InternalModelDraw.g:4664:1: rule__Node__TypeAssignment_4 : ( ruleNodeType ) ;
    public final void rule__Node__TypeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4668:1: ( ( ruleNodeType ) )
            // InternalModelDraw.g:4669:2: ( ruleNodeType )
            {
            // InternalModelDraw.g:4669:2: ( ruleNodeType )
            // InternalModelDraw.g:4670:3: ruleNodeType
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
    // InternalModelDraw.g:4679:1: rule__Node__AttNameAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__AttNameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4683:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4684:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4684:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4685:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getAttNameEAttributeCrossReference_5_1_0()); 
            // InternalModelDraw.g:4686:3: ( RULE_ID )
            // InternalModelDraw.g:4687:4: RULE_ID
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
    // InternalModelDraw.g:4698:1: rule__Node__ReferenceAssignment_6_3 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_6_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4702:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4703:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4703:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4704:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_3_0()); 
            // InternalModelDraw.g:4705:3: ( RULE_ID )
            // InternalModelDraw.g:4706:4: RULE_ID
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
    // InternalModelDraw.g:4717:1: rule__Node__ReferenceAssignment_6_4 : ( ( RULE_ID ) ) ;
    public final void rule__Node__ReferenceAssignment_6_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4721:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4722:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4722:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4723:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getReferenceEReferenceCrossReference_6_4_0()); 
            // InternalModelDraw.g:4724:3: ( RULE_ID )
            // InternalModelDraw.g:4725:4: RULE_ID
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
    // InternalModelDraw.g:4736:1: rule__Node__ShapeAssignment_7_2 : ( ruleNodeShape ) ;
    public final void rule__Node__ShapeAssignment_7_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4740:1: ( ( ruleNodeShape ) )
            // InternalModelDraw.g:4741:2: ( ruleNodeShape )
            {
            // InternalModelDraw.g:4741:2: ( ruleNodeShape )
            // InternalModelDraw.g:4742:3: ruleNodeShape
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
    // InternalModelDraw.g:4751:1: rule__Node__ColorAssignment_8_2 : ( ruleNodeColor ) ;
    public final void rule__Node__ColorAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4755:1: ( ( ruleNodeColor ) )
            // InternalModelDraw.g:4756:2: ( ruleNodeColor )
            {
            // InternalModelDraw.g:4756:2: ( ruleNodeColor )
            // InternalModelDraw.g:4757:3: ruleNodeColor
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
    // InternalModelDraw.g:4766:1: rule__Node__StyleAssignment_9_2 : ( ruleNodeStyle ) ;
    public final void rule__Node__StyleAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4770:1: ( ( ruleNodeStyle ) )
            // InternalModelDraw.g:4771:2: ( ruleNodeStyle )
            {
            // InternalModelDraw.g:4771:2: ( ruleNodeStyle )
            // InternalModelDraw.g:4772:3: ruleNodeStyle
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
    // InternalModelDraw.g:4781:1: rule__BooleanAttribute__NegationAssignment_1 : ( ( 'not' ) ) ;
    public final void rule__BooleanAttribute__NegationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4785:1: ( ( ( 'not' ) ) )
            // InternalModelDraw.g:4786:2: ( ( 'not' ) )
            {
            // InternalModelDraw.g:4786:2: ( ( 'not' ) )
            // InternalModelDraw.g:4787:3: ( 'not' )
            {
             before(grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0()); 
            // InternalModelDraw.g:4788:3: ( 'not' )
            // InternalModelDraw.g:4789:4: 'not'
            {
             before(grammarAccess.getBooleanAttributeAccess().getNegationNotKeyword_1_0()); 
            match(input,48,FOLLOW_2); 
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
    // InternalModelDraw.g:4800:1: rule__BooleanAttribute__AttAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__BooleanAttribute__AttAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4804:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4805:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4805:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4806:3: ( RULE_ID )
            {
             before(grammarAccess.getBooleanAttributeAccess().getAttEAttributeCrossReference_2_0()); 
            // InternalModelDraw.g:4807:3: ( RULE_ID )
            // InternalModelDraw.g:4808:4: RULE_ID
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
    // InternalModelDraw.g:4819:1: rule__Edge__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4823:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4824:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4824:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4825:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:4826:3: ( RULE_ID )
            // InternalModelDraw.g:4827:4: RULE_ID
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
    // InternalModelDraw.g:4838:1: rule__Edge__SourceAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__SourceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4842:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4843:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4843:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4844:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0()); 
            // InternalModelDraw.g:4845:3: ( RULE_ID )
            // InternalModelDraw.g:4846:4: RULE_ID
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
    // InternalModelDraw.g:4857:1: rule__Edge__TargetAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4861:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4862:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4862:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4863:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_5_0()); 
            // InternalModelDraw.g:4864:3: ( RULE_ID )
            // InternalModelDraw.g:4865:4: RULE_ID
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
    // InternalModelDraw.g:4876:1: rule__Edge__AttNameAssignment_9_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__AttNameAssignment_9_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4880:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4881:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4881:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4882:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getAttNameEAttributeCrossReference_9_1_0()); 
            // InternalModelDraw.g:4883:3: ( RULE_ID )
            // InternalModelDraw.g:4884:4: RULE_ID
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


    // $ANTLR start "rule__Edge__ReferenceAssignment_10_2_0"
    // InternalModelDraw.g:4895:1: rule__Edge__ReferenceAssignment_10_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__ReferenceAssignment_10_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4899:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4900:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4900:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4901:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_0_0()); 
            // InternalModelDraw.g:4902:3: ( RULE_ID )
            // InternalModelDraw.g:4903:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getReferenceEReferenceIDTerminalRuleCall_10_2_0_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getReferenceEReferenceCrossReference_10_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__ReferenceAssignment_10_2_0"


    // $ANTLR start "rule__Edge__LabelAssignment_10_3"
    // InternalModelDraw.g:4914:1: rule__Edge__LabelAssignment_10_3 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_10_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4918:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4919:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4919:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4920:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_3_0()); 
            // InternalModelDraw.g:4921:3: ( RULE_ID )
            // InternalModelDraw.g:4922:4: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getEdgeAccess().getLabelEAttributeIDTerminalRuleCall_10_3_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEAttributeCrossReference_10_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_10_3"


    // $ANTLR start "rule__Edge__Src_decorationAssignment_11_2"
    // InternalModelDraw.g:4933:1: rule__Edge__Src_decorationAssignment_11_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Src_decorationAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4937:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:4938:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:4938:2: ( ruleDecoration )
            // InternalModelDraw.g:4939:3: ruleDecoration
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
    // InternalModelDraw.g:4948:1: rule__Edge__Src_labelAssignment_12_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Src_labelAssignment_12_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4952:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4953:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4953:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4954:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSrc_labelEAttributeCrossReference_12_2_0()); 
            // InternalModelDraw.g:4955:3: ( RULE_ID )
            // InternalModelDraw.g:4956:4: RULE_ID
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
    // InternalModelDraw.g:4967:1: rule__Edge__Tar_decorationAssignment_13_2 : ( ruleDecoration ) ;
    public final void rule__Edge__Tar_decorationAssignment_13_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4971:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:4972:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:4972:2: ( ruleDecoration )
            // InternalModelDraw.g:4973:3: ruleDecoration
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
    // InternalModelDraw.g:4982:1: rule__Edge__Tar_labelAssignment_14_2 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__Tar_labelAssignment_14_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:4986:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:4987:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:4987:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:4988:3: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTar_labelEAttributeCrossReference_14_2_0()); 
            // InternalModelDraw.g:4989:3: ( RULE_ID )
            // InternalModelDraw.g:4990:4: RULE_ID
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
    // InternalModelDraw.g:5001:1: rule__Level__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5005:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5006:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5006:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5007:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:5008:3: ( RULE_ID )
            // InternalModelDraw.g:5009:4: RULE_ID
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
    // InternalModelDraw.g:5020:1: rule__Level__UpperAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Level__UpperAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5024:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5025:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5025:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5026:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getUpperEReferenceCrossReference_3_0()); 
            // InternalModelDraw.g:5027:3: ( RULE_ID )
            // InternalModelDraw.g:5028:4: RULE_ID
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
    // InternalModelDraw.g:5039:1: rule__Level__AttNameAssignment_6_1 : ( ( RULE_ID ) ) ;
    public final void rule__Level__AttNameAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5043:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5044:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5044:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5045:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getAttNameEAttributeCrossReference_6_1_0()); 
            // InternalModelDraw.g:5046:3: ( RULE_ID )
            // InternalModelDraw.g:5047:4: RULE_ID
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


    // $ANTLR start "rule__Level__ReferenceAssignment_7_2_0"
    // InternalModelDraw.g:5058:1: rule__Level__ReferenceAssignment_7_2_0 : ( ( RULE_ID ) ) ;
    public final void rule__Level__ReferenceAssignment_7_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5062:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5063:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5063:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5064:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0()); 
            // InternalModelDraw.g:5065:3: ( RULE_ID )
            // InternalModelDraw.g:5066:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_0_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getReferenceEReferenceIDTerminalRuleCall_7_2_0_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getReferenceEReferenceCrossReference_7_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__ReferenceAssignment_7_2_0"


    // $ANTLR start "rule__Level__LabelAssignment_7_3"
    // InternalModelDraw.g:5077:1: rule__Level__LabelAssignment_7_3 : ( ( RULE_ID ) ) ;
    public final void rule__Level__LabelAssignment_7_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5081:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5082:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5082:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5083:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_3_0()); 
            // InternalModelDraw.g:5084:3: ( RULE_ID )
            // InternalModelDraw.g:5085:4: RULE_ID
            {
             before(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_3_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getLevelAccess().getLabelEAttributeIDTerminalRuleCall_7_3_0_1()); 

            }

             after(grammarAccess.getLevelAccess().getLabelEAttributeCrossReference_7_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Level__LabelAssignment_7_3"


    // $ANTLR start "rule__Level__Src_decorationAssignment_8_2"
    // InternalModelDraw.g:5096:1: rule__Level__Src_decorationAssignment_8_2 : ( ruleDecoration ) ;
    public final void rule__Level__Src_decorationAssignment_8_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5100:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:5101:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:5101:2: ( ruleDecoration )
            // InternalModelDraw.g:5102:3: ruleDecoration
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
    // InternalModelDraw.g:5111:1: rule__Level__Src_labelAssignment_9_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Src_labelAssignment_9_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5115:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5116:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5116:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5117:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getSrc_labelEAttributeCrossReference_9_2_0()); 
            // InternalModelDraw.g:5118:3: ( RULE_ID )
            // InternalModelDraw.g:5119:4: RULE_ID
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
    // InternalModelDraw.g:5130:1: rule__Level__Tar_decorationAssignment_10_2 : ( ruleDecoration ) ;
    public final void rule__Level__Tar_decorationAssignment_10_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5134:1: ( ( ruleDecoration ) )
            // InternalModelDraw.g:5135:2: ( ruleDecoration )
            {
            // InternalModelDraw.g:5135:2: ( ruleDecoration )
            // InternalModelDraw.g:5136:3: ruleDecoration
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
    // InternalModelDraw.g:5145:1: rule__Level__Tar_labelAssignment_11_2 : ( ( RULE_ID ) ) ;
    public final void rule__Level__Tar_labelAssignment_11_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5149:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5150:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5150:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5151:3: ( RULE_ID )
            {
             before(grammarAccess.getLevelAccess().getTar_labelEAttributeCrossReference_11_2_0()); 
            // InternalModelDraw.g:5152:3: ( RULE_ID )
            // InternalModelDraw.g:5153:4: RULE_ID
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
    // InternalModelDraw.g:5164:1: rule__Content__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5168:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5169:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5169:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5170:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getNameEClassCrossReference_1_0()); 
            // InternalModelDraw.g:5171:3: ( RULE_ID )
            // InternalModelDraw.g:5172:4: RULE_ID
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
    // InternalModelDraw.g:5183:1: rule__Content__NodenumAssignment_3_0 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5187:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:5188:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:5188:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:5189:3: ruleNodeEnumerator
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
    // InternalModelDraw.g:5198:1: rule__Content__NodenumAssignment_3_1 : ( ruleNodeEnumerator ) ;
    public final void rule__Content__NodenumAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5202:1: ( ( ruleNodeEnumerator ) )
            // InternalModelDraw.g:5203:2: ( ruleNodeEnumerator )
            {
            // InternalModelDraw.g:5203:2: ( ruleNodeEnumerator )
            // InternalModelDraw.g:5204:3: ruleNodeEnumerator
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
    // InternalModelDraw.g:5213:1: rule__Content__InfoAssignment_4_0 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5217:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:5218:2: ( ruleInformation )
            {
            // InternalModelDraw.g:5218:2: ( ruleInformation )
            // InternalModelDraw.g:5219:3: ruleInformation
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
    // InternalModelDraw.g:5228:1: rule__Content__InfoAssignment_4_1 : ( ruleInformation ) ;
    public final void rule__Content__InfoAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5232:1: ( ( ruleInformation ) )
            // InternalModelDraw.g:5233:2: ( ruleInformation )
            {
            // InternalModelDraw.g:5233:2: ( ruleInformation )
            // InternalModelDraw.g:5234:3: ruleInformation
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
    // InternalModelDraw.g:5243:1: rule__Content__AttNameAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Content__AttNameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5247:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5248:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5248:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5249:3: ( RULE_ID )
            {
             before(grammarAccess.getContentAccess().getAttNameEAttributeCrossReference_5_1_0()); 
            // InternalModelDraw.g:5250:3: ( RULE_ID )
            // InternalModelDraw.g:5251:4: RULE_ID
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
    // InternalModelDraw.g:5262:1: rule__Content__SymbolAssignment_6_2 : ( ruleEString ) ;
    public final void rule__Content__SymbolAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5266:1: ( ( ruleEString ) )
            // InternalModelDraw.g:5267:2: ( ruleEString )
            {
            // InternalModelDraw.g:5267:2: ( ruleEString )
            // InternalModelDraw.g:5268:3: ruleEString
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
    // InternalModelDraw.g:5277:1: rule__NodeEnumerator__AttAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__NodeEnumerator__AttAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5281:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5282:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5282:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5283:3: ( RULE_ID )
            {
             before(grammarAccess.getNodeEnumeratorAccess().getAttEAttributeCrossReference_1_0()); 
            // InternalModelDraw.g:5284:3: ( RULE_ID )
            // InternalModelDraw.g:5285:4: RULE_ID
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
    // InternalModelDraw.g:5296:1: rule__NodeEnumerator__EnumeratorAssignment_3 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5300:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:5301:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:5301:2: ( ruleEnumerator )
            // InternalModelDraw.g:5302:3: ruleEnumerator
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
    // InternalModelDraw.g:5311:1: rule__NodeEnumerator__EnumeratorAssignment_4 : ( ruleEnumerator ) ;
    public final void rule__NodeEnumerator__EnumeratorAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5315:1: ( ( ruleEnumerator ) )
            // InternalModelDraw.g:5316:2: ( ruleEnumerator )
            {
            // InternalModelDraw.g:5316:2: ( ruleEnumerator )
            // InternalModelDraw.g:5317:3: ruleEnumerator
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
    // InternalModelDraw.g:5326:1: rule__Enumerator__LiteralAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Enumerator__LiteralAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5330:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5331:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5331:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5332:3: ( RULE_ID )
            {
             before(grammarAccess.getEnumeratorAccess().getLiteralEEnumLiteralCrossReference_1_0()); 
            // InternalModelDraw.g:5333:3: ( RULE_ID )
            // InternalModelDraw.g:5334:4: RULE_ID
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
    // InternalModelDraw.g:5345:1: rule__Enumerator__ValueAssignment_3 : ( ruleEString ) ;
    public final void rule__Enumerator__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5349:1: ( ( ruleEString ) )
            // InternalModelDraw.g:5350:2: ( ruleEString )
            {
            // InternalModelDraw.g:5350:2: ( ruleEString )
            // InternalModelDraw.g:5351:3: ruleEString
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
    // InternalModelDraw.g:5360:1: rule__Information__TypeAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__TypeAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5364:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5365:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5365:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5366:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getTypeEReferenceCrossReference_1_0()); 
            // InternalModelDraw.g:5367:3: ( RULE_ID )
            // InternalModelDraw.g:5368:4: RULE_ID
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
    // InternalModelDraw.g:5379:1: rule__Information__AttAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Information__AttAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalModelDraw.g:5383:1: ( ( ( RULE_ID ) ) )
            // InternalModelDraw.g:5384:2: ( ( RULE_ID ) )
            {
            // InternalModelDraw.g:5384:2: ( ( RULE_ID ) )
            // InternalModelDraw.g:5385:3: ( RULE_ID )
            {
             before(grammarAccess.getInformationAccess().getAttEAttributeCrossReference_2_1_0()); 
            // InternalModelDraw.g:5386:3: ( RULE_ID )
            // InternalModelDraw.g:5387:4: RULE_ID
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


    protected DFA7 dfa7 = new DFA7(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\5\1\33\1\uffff\2\5\1\uffff\1\37\1\5\1\37\1\33\1\15";
    static final String dfa_3s = "\1\35\1\50\1\uffff\1\55\1\60\1\uffff\1\40\1\60\1\40\1\33\1\46";
    static final String dfa_4s = "\2\uffff\1\2\2\uffff\1\1\5\uffff";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\27\uffff\1\2",
            "\1\3\2\uffff\1\4\11\uffff\1\2",
            "",
            "\1\2\7\uffff\2\5\15\uffff\2\2\17\uffff\1\2",
            "\1\6\52\uffff\1\5",
            "",
            "\1\5\1\7",
            "\1\10\52\uffff\1\5",
            "\1\11\1\5",
            "\1\12",
            "\2\5\27\uffff\1\2"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 787:2: ( rule__MutatorDraw__NodesAssignment_7 )*";
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
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0001000000000020L});
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
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00001E8200000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000003F00000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000200010000020L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000800000000020L});

}