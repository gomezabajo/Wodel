package org.mutatorgraph.ui.contentassist.antlr.internal; 

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
import org.mutatorgraph.services.MutatorGraphGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMutatorGraphParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'diagram'", "'not'", "'yes'", "'node'", "'markednode'", "'circle'", "'doublecircle'", "'metamodel'", "'->'", "'{'", "'}'", "'('", "')'", "','", "'shape'", "'='", "'edge'", "'label'"
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
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMutatorGraphParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMutatorGraphParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMutatorGraphParser.tokenNames; }
    public String getGrammarFileName() { return "../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g"; }


     
     	private MutatorGraphGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(MutatorGraphGrammarAccess grammarAccess) {
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




    // $ANTLR start "entryRuleMutatorGraph"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:60:1: entryRuleMutatorGraph : ruleMutatorGraph EOF ;
    public final void entryRuleMutatorGraph() throws RecognitionException {
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:61:1: ( ruleMutatorGraph EOF )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:62:1: ruleMutatorGraph EOF
            {
             before(grammarAccess.getMutatorGraphRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorGraph_in_entryRuleMutatorGraph61);
            ruleMutatorGraph();

            state._fsp--;

             after(grammarAccess.getMutatorGraphRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutatorGraph68); 

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
    // $ANTLR end "entryRuleMutatorGraph"


    // $ANTLR start "ruleMutatorGraph"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:69:1: ruleMutatorGraph : ( ( rule__MutatorGraph__Group__0 ) ) ;
    public final void ruleMutatorGraph() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:73:2: ( ( ( rule__MutatorGraph__Group__0 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:74:1: ( ( rule__MutatorGraph__Group__0 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:74:1: ( ( rule__MutatorGraph__Group__0 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:75:1: ( rule__MutatorGraph__Group__0 )
            {
             before(grammarAccess.getMutatorGraphAccess().getGroup()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:76:1: ( rule__MutatorGraph__Group__0 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:76:2: rule__MutatorGraph__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__0_in_ruleMutatorGraph94);
            rule__MutatorGraph__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMutatorGraphAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMutatorGraph"


    // $ANTLR start "entryRuleEString"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:88:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:89:1: ( ruleEString EOF )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:90:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString121);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString128); 

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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:97:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:101:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:102:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:102:1: ( ( rule__EString__Alternatives ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:103:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:104:1: ( rule__EString__Alternatives )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:104:2: rule__EString__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__EString__Alternatives_in_ruleEString154);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:116:1: entryRuleNode : ruleNode EOF ;
    public final void entryRuleNode() throws RecognitionException {
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:117:1: ( ruleNode EOF )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:118:1: ruleNode EOF
            {
             before(grammarAccess.getNodeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_entryRuleNode181);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getNodeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNode188); 

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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:125:1: ruleNode : ( ( rule__Node__Group__0 ) ) ;
    public final void ruleNode() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:129:2: ( ( ( rule__Node__Group__0 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:130:1: ( ( rule__Node__Group__0 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:130:1: ( ( rule__Node__Group__0 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:131:1: ( rule__Node__Group__0 )
            {
             before(grammarAccess.getNodeAccess().getGroup()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:132:1: ( rule__Node__Group__0 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:132:2: rule__Node__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__0_in_ruleNode214);
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


    // $ANTLR start "entryRuleEdge"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:144:1: entryRuleEdge : ruleEdge EOF ;
    public final void entryRuleEdge() throws RecognitionException {
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:145:1: ( ruleEdge EOF )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:146:1: ruleEdge EOF
            {
             before(grammarAccess.getEdgeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEdge_in_entryRuleEdge241);
            ruleEdge();

            state._fsp--;

             after(grammarAccess.getEdgeRule()); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEdge248); 

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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:153:1: ruleEdge : ( ( rule__Edge__Group__0 ) ) ;
    public final void ruleEdge() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:157:2: ( ( ( rule__Edge__Group__0 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:158:1: ( ( rule__Edge__Group__0 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:158:1: ( ( rule__Edge__Group__0 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:159:1: ( rule__Edge__Group__0 )
            {
             before(grammarAccess.getEdgeAccess().getGroup()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:160:1: ( rule__Edge__Group__0 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:160:2: rule__Edge__Group__0
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__0_in_ruleEdge274);
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


    // $ANTLR start "ruleGraphType"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:173:1: ruleGraphType : ( ( 'diagram' ) ) ;
    public final void ruleGraphType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:177:1: ( ( ( 'diagram' ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:178:1: ( ( 'diagram' ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:178:1: ( ( 'diagram' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:179:1: ( 'diagram' )
            {
             before(grammarAccess.getGraphTypeAccess().getDiagramEnumLiteralDeclaration()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:180:1: ( 'diagram' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:180:3: 'diagram'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleGraphType312); 

            }

             after(grammarAccess.getGraphTypeAccess().getDiagramEnumLiteralDeclaration()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleGraphType"


    // $ANTLR start "ruleNegation"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:193:1: ruleNegation : ( ( rule__Negation__Alternatives ) ) ;
    public final void ruleNegation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:197:1: ( ( ( rule__Negation__Alternatives ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:198:1: ( ( rule__Negation__Alternatives ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:198:1: ( ( rule__Negation__Alternatives ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:199:1: ( rule__Negation__Alternatives )
            {
             before(grammarAccess.getNegationAccess().getAlternatives()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:200:1: ( rule__Negation__Alternatives )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:200:2: rule__Negation__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__Negation__Alternatives_in_ruleNegation350);
            rule__Negation__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getNegationAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNegation"


    // $ANTLR start "ruleNodeType"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:212:1: ruleNodeType : ( ( rule__NodeType__Alternatives ) ) ;
    public final void ruleNodeType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:216:1: ( ( ( rule__NodeType__Alternatives ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:217:1: ( ( rule__NodeType__Alternatives ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:217:1: ( ( rule__NodeType__Alternatives ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:218:1: ( rule__NodeType__Alternatives )
            {
             before(grammarAccess.getNodeTypeAccess().getAlternatives()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:219:1: ( rule__NodeType__Alternatives )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:219:2: rule__NodeType__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__NodeType__Alternatives_in_ruleNodeType386);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:231:1: ruleNodeShape : ( ( rule__NodeShape__Alternatives ) ) ;
    public final void ruleNodeShape() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:235:1: ( ( ( rule__NodeShape__Alternatives ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:236:1: ( ( rule__NodeShape__Alternatives ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:236:1: ( ( rule__NodeShape__Alternatives ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:237:1: ( rule__NodeShape__Alternatives )
            {
             before(grammarAccess.getNodeShapeAccess().getAlternatives()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:238:1: ( rule__NodeShape__Alternatives )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:238:2: rule__NodeShape__Alternatives
            {
            pushFollow(FollowSets000.FOLLOW_rule__NodeShape__Alternatives_in_ruleNodeShape422);
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


    // $ANTLR start "rule__EString__Alternatives"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:249:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:253:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:254:1: ( RULE_STRING )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:254:1: ( RULE_STRING )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:255:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_rule__EString__Alternatives457); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:260:6: ( RULE_ID )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:260:6: ( RULE_ID )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:261:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__EString__Alternatives474); 
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


    // $ANTLR start "rule__Negation__Alternatives"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:271:1: rule__Negation__Alternatives : ( ( ( 'not' ) ) | ( ( 'yes' ) ) );
    public final void rule__Negation__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:275:1: ( ( ( 'not' ) ) | ( ( 'yes' ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            else if ( (LA2_0==13) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:276:1: ( ( 'not' ) )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:276:1: ( ( 'not' ) )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:277:1: ( 'not' )
                    {
                     before(grammarAccess.getNegationAccess().getNotEnumLiteralDeclaration_0()); 
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:278:1: ( 'not' )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:278:3: 'not'
                    {
                    match(input,12,FollowSets000.FOLLOW_12_in_rule__Negation__Alternatives507); 

                    }

                     after(grammarAccess.getNegationAccess().getNotEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:283:6: ( ( 'yes' ) )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:283:6: ( ( 'yes' ) )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:284:1: ( 'yes' )
                    {
                     before(grammarAccess.getNegationAccess().getYesEnumLiteralDeclaration_1()); 
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:285:1: ( 'yes' )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:285:3: 'yes'
                    {
                    match(input,13,FollowSets000.FOLLOW_13_in_rule__Negation__Alternatives528); 

                    }

                     after(grammarAccess.getNegationAccess().getYesEnumLiteralDeclaration_1()); 

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
    // $ANTLR end "rule__Negation__Alternatives"


    // $ANTLR start "rule__NodeType__Alternatives"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:295:1: rule__NodeType__Alternatives : ( ( ( 'node' ) ) | ( ( 'markednode' ) ) );
    public final void rule__NodeType__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:299:1: ( ( ( 'node' ) ) | ( ( 'markednode' ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==15) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:300:1: ( ( 'node' ) )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:300:1: ( ( 'node' ) )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:301:1: ( 'node' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:302:1: ( 'node' )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:302:3: 'node'
                    {
                    match(input,14,FollowSets000.FOLLOW_14_in_rule__NodeType__Alternatives564); 

                    }

                     after(grammarAccess.getNodeTypeAccess().getNodeEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:307:6: ( ( 'markednode' ) )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:307:6: ( ( 'markednode' ) )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:308:1: ( 'markednode' )
                    {
                     before(grammarAccess.getNodeTypeAccess().getMarkednodeEnumLiteralDeclaration_1()); 
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:309:1: ( 'markednode' )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:309:3: 'markednode'
                    {
                    match(input,15,FollowSets000.FOLLOW_15_in_rule__NodeType__Alternatives585); 

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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:319:1: rule__NodeShape__Alternatives : ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) );
    public final void rule__NodeShape__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:323:1: ( ( ( 'circle' ) ) | ( ( 'doublecircle' ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==16) ) {
                alt4=1;
            }
            else if ( (LA4_0==17) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:324:1: ( ( 'circle' ) )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:324:1: ( ( 'circle' ) )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:325:1: ( 'circle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:326:1: ( 'circle' )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:326:3: 'circle'
                    {
                    match(input,16,FollowSets000.FOLLOW_16_in_rule__NodeShape__Alternatives621); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getCircleEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:331:6: ( ( 'doublecircle' ) )
                    {
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:331:6: ( ( 'doublecircle' ) )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:332:1: ( 'doublecircle' )
                    {
                     before(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:333:1: ( 'doublecircle' )
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:333:3: 'doublecircle'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_rule__NodeShape__Alternatives642); 

                    }

                     after(grammarAccess.getNodeShapeAccess().getDoublecircleEnumLiteralDeclaration_1()); 

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


    // $ANTLR start "rule__MutatorGraph__Group__0"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:345:1: rule__MutatorGraph__Group__0 : rule__MutatorGraph__Group__0__Impl rule__MutatorGraph__Group__1 ;
    public final void rule__MutatorGraph__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:349:1: ( rule__MutatorGraph__Group__0__Impl rule__MutatorGraph__Group__1 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:350:2: rule__MutatorGraph__Group__0__Impl rule__MutatorGraph__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__0__Impl_in_rule__MutatorGraph__Group__0675);
            rule__MutatorGraph__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__1_in_rule__MutatorGraph__Group__0678);
            rule__MutatorGraph__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__0"


    // $ANTLR start "rule__MutatorGraph__Group__0__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:357:1: rule__MutatorGraph__Group__0__Impl : ( () ) ;
    public final void rule__MutatorGraph__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:361:1: ( ( () ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:362:1: ( () )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:362:1: ( () )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:363:1: ()
            {
             before(grammarAccess.getMutatorGraphAccess().getMutatorGraphAction_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:364:1: ()
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:366:1: 
            {
            }

             after(grammarAccess.getMutatorGraphAccess().getMutatorGraphAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__0__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__1"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:376:1: rule__MutatorGraph__Group__1 : rule__MutatorGraph__Group__1__Impl rule__MutatorGraph__Group__2 ;
    public final void rule__MutatorGraph__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:380:1: ( rule__MutatorGraph__Group__1__Impl rule__MutatorGraph__Group__2 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:381:2: rule__MutatorGraph__Group__1__Impl rule__MutatorGraph__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__1__Impl_in_rule__MutatorGraph__Group__1736);
            rule__MutatorGraph__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__2_in_rule__MutatorGraph__Group__1739);
            rule__MutatorGraph__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__1"


    // $ANTLR start "rule__MutatorGraph__Group__1__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:388:1: rule__MutatorGraph__Group__1__Impl : ( 'metamodel' ) ;
    public final void rule__MutatorGraph__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:392:1: ( ( 'metamodel' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:393:1: ( 'metamodel' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:393:1: ( 'metamodel' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:394:1: 'metamodel'
            {
             before(grammarAccess.getMutatorGraphAccess().getMetamodelKeyword_1()); 
            match(input,18,FollowSets000.FOLLOW_18_in_rule__MutatorGraph__Group__1__Impl767); 
             after(grammarAccess.getMutatorGraphAccess().getMetamodelKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__1__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__2"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:407:1: rule__MutatorGraph__Group__2 : rule__MutatorGraph__Group__2__Impl rule__MutatorGraph__Group__3 ;
    public final void rule__MutatorGraph__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:411:1: ( rule__MutatorGraph__Group__2__Impl rule__MutatorGraph__Group__3 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:412:2: rule__MutatorGraph__Group__2__Impl rule__MutatorGraph__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__2__Impl_in_rule__MutatorGraph__Group__2798);
            rule__MutatorGraph__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__3_in_rule__MutatorGraph__Group__2801);
            rule__MutatorGraph__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__2"


    // $ANTLR start "rule__MutatorGraph__Group__2__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:419:1: rule__MutatorGraph__Group__2__Impl : ( ( rule__MutatorGraph__MetamodelAssignment_2 ) ) ;
    public final void rule__MutatorGraph__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:423:1: ( ( ( rule__MutatorGraph__MetamodelAssignment_2 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:424:1: ( ( rule__MutatorGraph__MetamodelAssignment_2 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:424:1: ( ( rule__MutatorGraph__MetamodelAssignment_2 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:425:1: ( rule__MutatorGraph__MetamodelAssignment_2 )
            {
             before(grammarAccess.getMutatorGraphAccess().getMetamodelAssignment_2()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:426:1: ( rule__MutatorGraph__MetamodelAssignment_2 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:426:2: rule__MutatorGraph__MetamodelAssignment_2
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__MetamodelAssignment_2_in_rule__MutatorGraph__Group__2__Impl828);
            rule__MutatorGraph__MetamodelAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMutatorGraphAccess().getMetamodelAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__2__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__3"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:436:1: rule__MutatorGraph__Group__3 : rule__MutatorGraph__Group__3__Impl rule__MutatorGraph__Group__4 ;
    public final void rule__MutatorGraph__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:440:1: ( rule__MutatorGraph__Group__3__Impl rule__MutatorGraph__Group__4 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:441:2: rule__MutatorGraph__Group__3__Impl rule__MutatorGraph__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__3__Impl_in_rule__MutatorGraph__Group__3858);
            rule__MutatorGraph__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__4_in_rule__MutatorGraph__Group__3861);
            rule__MutatorGraph__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__3"


    // $ANTLR start "rule__MutatorGraph__Group__3__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:448:1: rule__MutatorGraph__Group__3__Impl : ( ( rule__MutatorGraph__NameAssignment_3 ) ) ;
    public final void rule__MutatorGraph__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:452:1: ( ( ( rule__MutatorGraph__NameAssignment_3 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:453:1: ( ( rule__MutatorGraph__NameAssignment_3 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:453:1: ( ( rule__MutatorGraph__NameAssignment_3 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:454:1: ( rule__MutatorGraph__NameAssignment_3 )
            {
             before(grammarAccess.getMutatorGraphAccess().getNameAssignment_3()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:455:1: ( rule__MutatorGraph__NameAssignment_3 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:455:2: rule__MutatorGraph__NameAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__NameAssignment_3_in_rule__MutatorGraph__Group__3__Impl888);
            rule__MutatorGraph__NameAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getMutatorGraphAccess().getNameAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__3__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__4"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:465:1: rule__MutatorGraph__Group__4 : rule__MutatorGraph__Group__4__Impl rule__MutatorGraph__Group__5 ;
    public final void rule__MutatorGraph__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:469:1: ( rule__MutatorGraph__Group__4__Impl rule__MutatorGraph__Group__5 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:470:2: rule__MutatorGraph__Group__4__Impl rule__MutatorGraph__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__4__Impl_in_rule__MutatorGraph__Group__4918);
            rule__MutatorGraph__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__5_in_rule__MutatorGraph__Group__4921);
            rule__MutatorGraph__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__4"


    // $ANTLR start "rule__MutatorGraph__Group__4__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:477:1: rule__MutatorGraph__Group__4__Impl : ( '->' ) ;
    public final void rule__MutatorGraph__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:481:1: ( ( '->' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:482:1: ( '->' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:482:1: ( '->' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:483:1: '->'
            {
             before(grammarAccess.getMutatorGraphAccess().getHyphenMinusGreaterThanSignKeyword_4()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__MutatorGraph__Group__4__Impl949); 
             after(grammarAccess.getMutatorGraphAccess().getHyphenMinusGreaterThanSignKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__4__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__5"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:496:1: rule__MutatorGraph__Group__5 : rule__MutatorGraph__Group__5__Impl rule__MutatorGraph__Group__6 ;
    public final void rule__MutatorGraph__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:500:1: ( rule__MutatorGraph__Group__5__Impl rule__MutatorGraph__Group__6 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:501:2: rule__MutatorGraph__Group__5__Impl rule__MutatorGraph__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__5__Impl_in_rule__MutatorGraph__Group__5980);
            rule__MutatorGraph__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__6_in_rule__MutatorGraph__Group__5983);
            rule__MutatorGraph__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__5"


    // $ANTLR start "rule__MutatorGraph__Group__5__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:508:1: rule__MutatorGraph__Group__5__Impl : ( ( rule__MutatorGraph__TypeAssignment_5 ) ) ;
    public final void rule__MutatorGraph__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:512:1: ( ( ( rule__MutatorGraph__TypeAssignment_5 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:513:1: ( ( rule__MutatorGraph__TypeAssignment_5 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:513:1: ( ( rule__MutatorGraph__TypeAssignment_5 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:514:1: ( rule__MutatorGraph__TypeAssignment_5 )
            {
             before(grammarAccess.getMutatorGraphAccess().getTypeAssignment_5()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:515:1: ( rule__MutatorGraph__TypeAssignment_5 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:515:2: rule__MutatorGraph__TypeAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__TypeAssignment_5_in_rule__MutatorGraph__Group__5__Impl1010);
            rule__MutatorGraph__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getMutatorGraphAccess().getTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__5__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__6"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:525:1: rule__MutatorGraph__Group__6 : rule__MutatorGraph__Group__6__Impl rule__MutatorGraph__Group__7 ;
    public final void rule__MutatorGraph__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:529:1: ( rule__MutatorGraph__Group__6__Impl rule__MutatorGraph__Group__7 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:530:2: rule__MutatorGraph__Group__6__Impl rule__MutatorGraph__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__6__Impl_in_rule__MutatorGraph__Group__61040);
            rule__MutatorGraph__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__7_in_rule__MutatorGraph__Group__61043);
            rule__MutatorGraph__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__6"


    // $ANTLR start "rule__MutatorGraph__Group__6__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:537:1: rule__MutatorGraph__Group__6__Impl : ( '{' ) ;
    public final void rule__MutatorGraph__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:541:1: ( ( '{' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:542:1: ( '{' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:542:1: ( '{' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:543:1: '{'
            {
             before(grammarAccess.getMutatorGraphAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,20,FollowSets000.FOLLOW_20_in_rule__MutatorGraph__Group__6__Impl1071); 
             after(grammarAccess.getMutatorGraphAccess().getLeftCurlyBracketKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__6__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__7"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:556:1: rule__MutatorGraph__Group__7 : rule__MutatorGraph__Group__7__Impl rule__MutatorGraph__Group__8 ;
    public final void rule__MutatorGraph__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:560:1: ( rule__MutatorGraph__Group__7__Impl rule__MutatorGraph__Group__8 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:561:2: rule__MutatorGraph__Group__7__Impl rule__MutatorGraph__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__7__Impl_in_rule__MutatorGraph__Group__71102);
            rule__MutatorGraph__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__8_in_rule__MutatorGraph__Group__71105);
            rule__MutatorGraph__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__7"


    // $ANTLR start "rule__MutatorGraph__Group__7__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:568:1: rule__MutatorGraph__Group__7__Impl : ( ( rule__MutatorGraph__NodesAssignment_7 )* ) ;
    public final void rule__MutatorGraph__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:572:1: ( ( ( rule__MutatorGraph__NodesAssignment_7 )* ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:573:1: ( ( rule__MutatorGraph__NodesAssignment_7 )* )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:573:1: ( ( rule__MutatorGraph__NodesAssignment_7 )* )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:574:1: ( rule__MutatorGraph__NodesAssignment_7 )*
            {
             before(grammarAccess.getMutatorGraphAccess().getNodesAssignment_7()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:575:1: ( rule__MutatorGraph__NodesAssignment_7 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==RULE_ID) ) {
                    int LA5_1 = input.LA(2);

                    if ( (LA5_1==22) ) {
                        int LA5_3 = input.LA(3);

                        if ( ((LA5_3>=12 && LA5_3<=13)) ) {
                            alt5=1;
                        }
                        else if ( (LA5_3==RULE_ID) ) {
                            int LA5_5 = input.LA(4);

                            if ( (LA5_5==23) ) {
                                alt5=1;
                            }


                        }


                    }


                }


                switch (alt5) {
            	case 1 :
            	    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:575:2: rule__MutatorGraph__NodesAssignment_7
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__NodesAssignment_7_in_rule__MutatorGraph__Group__7__Impl1132);
            	    rule__MutatorGraph__NodesAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

             after(grammarAccess.getMutatorGraphAccess().getNodesAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__7__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__8"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:585:1: rule__MutatorGraph__Group__8 : rule__MutatorGraph__Group__8__Impl rule__MutatorGraph__Group__9 ;
    public final void rule__MutatorGraph__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:589:1: ( rule__MutatorGraph__Group__8__Impl rule__MutatorGraph__Group__9 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:590:2: rule__MutatorGraph__Group__8__Impl rule__MutatorGraph__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__8__Impl_in_rule__MutatorGraph__Group__81163);
            rule__MutatorGraph__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__9_in_rule__MutatorGraph__Group__81166);
            rule__MutatorGraph__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__8"


    // $ANTLR start "rule__MutatorGraph__Group__8__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:597:1: rule__MutatorGraph__Group__8__Impl : ( ( rule__MutatorGraph__EdgesAssignment_8 )* ) ;
    public final void rule__MutatorGraph__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:601:1: ( ( ( rule__MutatorGraph__EdgesAssignment_8 )* ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:602:1: ( ( rule__MutatorGraph__EdgesAssignment_8 )* )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:602:1: ( ( rule__MutatorGraph__EdgesAssignment_8 )* )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:603:1: ( rule__MutatorGraph__EdgesAssignment_8 )*
            {
             before(grammarAccess.getMutatorGraphAccess().getEdgesAssignment_8()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:604:1: ( rule__MutatorGraph__EdgesAssignment_8 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:604:2: rule__MutatorGraph__EdgesAssignment_8
            	    {
            	    pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__EdgesAssignment_8_in_rule__MutatorGraph__Group__8__Impl1193);
            	    rule__MutatorGraph__EdgesAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getMutatorGraphAccess().getEdgesAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__8__Impl"


    // $ANTLR start "rule__MutatorGraph__Group__9"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:614:1: rule__MutatorGraph__Group__9 : rule__MutatorGraph__Group__9__Impl ;
    public final void rule__MutatorGraph__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:618:1: ( rule__MutatorGraph__Group__9__Impl )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:619:2: rule__MutatorGraph__Group__9__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__MutatorGraph__Group__9__Impl_in_rule__MutatorGraph__Group__91224);
            rule__MutatorGraph__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__9"


    // $ANTLR start "rule__MutatorGraph__Group__9__Impl"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:625:1: rule__MutatorGraph__Group__9__Impl : ( '}' ) ;
    public final void rule__MutatorGraph__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:629:1: ( ( '}' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:630:1: ( '}' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:630:1: ( '}' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:631:1: '}'
            {
             before(grammarAccess.getMutatorGraphAccess().getRightCurlyBracketKeyword_9()); 
            match(input,21,FollowSets000.FOLLOW_21_in_rule__MutatorGraph__Group__9__Impl1252); 
             after(grammarAccess.getMutatorGraphAccess().getRightCurlyBracketKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__Group__9__Impl"


    // $ANTLR start "rule__Node__Group__0"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:664:1: rule__Node__Group__0 : rule__Node__Group__0__Impl rule__Node__Group__1 ;
    public final void rule__Node__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:668:1: ( rule__Node__Group__0__Impl rule__Node__Group__1 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:669:2: rule__Node__Group__0__Impl rule__Node__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__01303);
            rule__Node__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__1_in_rule__Node__Group__01306);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:676:1: rule__Node__Group__0__Impl : ( () ) ;
    public final void rule__Node__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:680:1: ( ( () ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:681:1: ( () )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:681:1: ( () )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:682:1: ()
            {
             before(grammarAccess.getNodeAccess().getNodeAction_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:683:1: ()
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:685:1: 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:695:1: rule__Node__Group__1 : rule__Node__Group__1__Impl rule__Node__Group__2 ;
    public final void rule__Node__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:699:1: ( rule__Node__Group__1__Impl rule__Node__Group__2 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:700:2: rule__Node__Group__1__Impl rule__Node__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__11364);
            rule__Node__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__2_in_rule__Node__Group__11367);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:707:1: rule__Node__Group__1__Impl : ( ( rule__Node__NameAssignment_1 ) ) ;
    public final void rule__Node__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:711:1: ( ( ( rule__Node__NameAssignment_1 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:712:1: ( ( rule__Node__NameAssignment_1 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:712:1: ( ( rule__Node__NameAssignment_1 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:713:1: ( rule__Node__NameAssignment_1 )
            {
             before(grammarAccess.getNodeAccess().getNameAssignment_1()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:714:1: ( rule__Node__NameAssignment_1 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:714:2: rule__Node__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__NameAssignment_1_in_rule__Node__Group__1__Impl1394);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:724:1: rule__Node__Group__2 : rule__Node__Group__2__Impl rule__Node__Group__3 ;
    public final void rule__Node__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:728:1: ( rule__Node__Group__2__Impl rule__Node__Group__3 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:729:2: rule__Node__Group__2__Impl rule__Node__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__21424);
            rule__Node__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__3_in_rule__Node__Group__21427);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:736:1: rule__Node__Group__2__Impl : ( '(' ) ;
    public final void rule__Node__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:740:1: ( ( '(' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:741:1: ( '(' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:741:1: ( '(' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:742:1: '('
            {
             before(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Node__Group__2__Impl1455); 
             after(grammarAccess.getNodeAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:755:1: rule__Node__Group__3 : rule__Node__Group__3__Impl rule__Node__Group__4 ;
    public final void rule__Node__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:759:1: ( rule__Node__Group__3__Impl rule__Node__Group__4 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:760:2: rule__Node__Group__3__Impl rule__Node__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__3__Impl_in_rule__Node__Group__31486);
            rule__Node__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__4_in_rule__Node__Group__31489);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:767:1: rule__Node__Group__3__Impl : ( ( rule__Node__NegationAssignment_3 )? ) ;
    public final void rule__Node__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:771:1: ( ( ( rule__Node__NegationAssignment_3 )? ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:772:1: ( ( rule__Node__NegationAssignment_3 )? )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:772:1: ( ( rule__Node__NegationAssignment_3 )? )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:773:1: ( rule__Node__NegationAssignment_3 )?
            {
             before(grammarAccess.getNodeAccess().getNegationAssignment_3()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:774:1: ( rule__Node__NegationAssignment_3 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=12 && LA7_0<=13)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:774:2: rule__Node__NegationAssignment_3
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Node__NegationAssignment_3_in_rule__Node__Group__3__Impl1516);
                    rule__Node__NegationAssignment_3();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getNodeAccess().getNegationAssignment_3()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:784:1: rule__Node__Group__4 : rule__Node__Group__4__Impl rule__Node__Group__5 ;
    public final void rule__Node__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:788:1: ( rule__Node__Group__4__Impl rule__Node__Group__5 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:789:2: rule__Node__Group__4__Impl rule__Node__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__4__Impl_in_rule__Node__Group__41547);
            rule__Node__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__5_in_rule__Node__Group__41550);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:796:1: rule__Node__Group__4__Impl : ( ( rule__Node__AttributeAssignment_4 ) ) ;
    public final void rule__Node__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:800:1: ( ( ( rule__Node__AttributeAssignment_4 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:801:1: ( ( rule__Node__AttributeAssignment_4 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:801:1: ( ( rule__Node__AttributeAssignment_4 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:802:1: ( rule__Node__AttributeAssignment_4 )
            {
             before(grammarAccess.getNodeAccess().getAttributeAssignment_4()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:803:1: ( rule__Node__AttributeAssignment_4 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:803:2: rule__Node__AttributeAssignment_4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__AttributeAssignment_4_in_rule__Node__Group__4__Impl1577);
            rule__Node__AttributeAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getAttributeAssignment_4()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:813:1: rule__Node__Group__5 : rule__Node__Group__5__Impl rule__Node__Group__6 ;
    public final void rule__Node__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:817:1: ( rule__Node__Group__5__Impl rule__Node__Group__6 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:818:2: rule__Node__Group__5__Impl rule__Node__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__5__Impl_in_rule__Node__Group__51607);
            rule__Node__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__6_in_rule__Node__Group__51610);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:825:1: rule__Node__Group__5__Impl : ( ')' ) ;
    public final void rule__Node__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:829:1: ( ( ')' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:830:1: ( ')' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:830:1: ( ')' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:831:1: ')'
            {
             before(grammarAccess.getNodeAccess().getRightParenthesisKeyword_5()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Node__Group__5__Impl1638); 
             after(grammarAccess.getNodeAccess().getRightParenthesisKeyword_5()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:844:1: rule__Node__Group__6 : rule__Node__Group__6__Impl rule__Node__Group__7 ;
    public final void rule__Node__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:848:1: ( rule__Node__Group__6__Impl rule__Node__Group__7 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:849:2: rule__Node__Group__6__Impl rule__Node__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__6__Impl_in_rule__Node__Group__61669);
            rule__Node__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__7_in_rule__Node__Group__61672);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:856:1: rule__Node__Group__6__Impl : ( '->' ) ;
    public final void rule__Node__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:860:1: ( ( '->' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:861:1: ( '->' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:861:1: ( '->' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:862:1: '->'
            {
             before(grammarAccess.getNodeAccess().getHyphenMinusGreaterThanSignKeyword_6()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Node__Group__6__Impl1700); 
             after(grammarAccess.getNodeAccess().getHyphenMinusGreaterThanSignKeyword_6()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:875:1: rule__Node__Group__7 : rule__Node__Group__7__Impl rule__Node__Group__8 ;
    public final void rule__Node__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:879:1: ( rule__Node__Group__7__Impl rule__Node__Group__8 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:880:2: rule__Node__Group__7__Impl rule__Node__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__7__Impl_in_rule__Node__Group__71731);
            rule__Node__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__8_in_rule__Node__Group__71734);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:887:1: rule__Node__Group__7__Impl : ( ( rule__Node__TypeAssignment_7 ) ) ;
    public final void rule__Node__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:891:1: ( ( ( rule__Node__TypeAssignment_7 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:892:1: ( ( rule__Node__TypeAssignment_7 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:892:1: ( ( rule__Node__TypeAssignment_7 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:893:1: ( rule__Node__TypeAssignment_7 )
            {
             before(grammarAccess.getNodeAccess().getTypeAssignment_7()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:894:1: ( rule__Node__TypeAssignment_7 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:894:2: rule__Node__TypeAssignment_7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__TypeAssignment_7_in_rule__Node__Group__7__Impl1761);
            rule__Node__TypeAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getTypeAssignment_7()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:904:1: rule__Node__Group__8 : rule__Node__Group__8__Impl ;
    public final void rule__Node__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:908:1: ( rule__Node__Group__8__Impl )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:909:2: rule__Node__Group__8__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group__8__Impl_in_rule__Node__Group__81791);
            rule__Node__Group__8__Impl();

            state._fsp--;


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:915:1: rule__Node__Group__8__Impl : ( ( rule__Node__Group_8__0 )? ) ;
    public final void rule__Node__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:919:1: ( ( ( rule__Node__Group_8__0 )? ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:920:1: ( ( rule__Node__Group_8__0 )? )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:920:1: ( ( rule__Node__Group_8__0 )? )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:921:1: ( rule__Node__Group_8__0 )?
            {
             before(grammarAccess.getNodeAccess().getGroup_8()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:922:1: ( rule__Node__Group_8__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==24) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:922:2: rule__Node__Group_8__0
                    {
                    pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__0_in_rule__Node__Group__8__Impl1818);
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


    // $ANTLR start "rule__Node__Group_8__0"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:950:1: rule__Node__Group_8__0 : rule__Node__Group_8__0__Impl rule__Node__Group_8__1 ;
    public final void rule__Node__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:954:1: ( rule__Node__Group_8__0__Impl rule__Node__Group_8__1 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:955:2: rule__Node__Group_8__0__Impl rule__Node__Group_8__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__0__Impl_in_rule__Node__Group_8__01867);
            rule__Node__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__1_in_rule__Node__Group_8__01870);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:962:1: rule__Node__Group_8__0__Impl : ( ',' ) ;
    public final void rule__Node__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:966:1: ( ( ',' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:967:1: ( ',' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:967:1: ( ',' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:968:1: ','
            {
             before(grammarAccess.getNodeAccess().getCommaKeyword_8_0()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Node__Group_8__0__Impl1898); 
             after(grammarAccess.getNodeAccess().getCommaKeyword_8_0()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:981:1: rule__Node__Group_8__1 : rule__Node__Group_8__1__Impl rule__Node__Group_8__2 ;
    public final void rule__Node__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:985:1: ( rule__Node__Group_8__1__Impl rule__Node__Group_8__2 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:986:2: rule__Node__Group_8__1__Impl rule__Node__Group_8__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__1__Impl_in_rule__Node__Group_8__11929);
            rule__Node__Group_8__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__2_in_rule__Node__Group_8__11932);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:993:1: rule__Node__Group_8__1__Impl : ( 'shape' ) ;
    public final void rule__Node__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:997:1: ( ( 'shape' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:998:1: ( 'shape' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:998:1: ( 'shape' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:999:1: 'shape'
            {
             before(grammarAccess.getNodeAccess().getShapeKeyword_8_1()); 
            match(input,25,FollowSets000.FOLLOW_25_in_rule__Node__Group_8__1__Impl1960); 
             after(grammarAccess.getNodeAccess().getShapeKeyword_8_1()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1012:1: rule__Node__Group_8__2 : rule__Node__Group_8__2__Impl rule__Node__Group_8__3 ;
    public final void rule__Node__Group_8__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1016:1: ( rule__Node__Group_8__2__Impl rule__Node__Group_8__3 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1017:2: rule__Node__Group_8__2__Impl rule__Node__Group_8__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__2__Impl_in_rule__Node__Group_8__21991);
            rule__Node__Group_8__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__3_in_rule__Node__Group_8__21994);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1024:1: rule__Node__Group_8__2__Impl : ( '=' ) ;
    public final void rule__Node__Group_8__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1028:1: ( ( '=' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1029:1: ( '=' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1029:1: ( '=' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1030:1: '='
            {
             before(grammarAccess.getNodeAccess().getEqualsSignKeyword_8_2()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Node__Group_8__2__Impl2022); 
             after(grammarAccess.getNodeAccess().getEqualsSignKeyword_8_2()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1043:1: rule__Node__Group_8__3 : rule__Node__Group_8__3__Impl ;
    public final void rule__Node__Group_8__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1047:1: ( rule__Node__Group_8__3__Impl )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1048:2: rule__Node__Group_8__3__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__Group_8__3__Impl_in_rule__Node__Group_8__32053);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1054:1: rule__Node__Group_8__3__Impl : ( ( rule__Node__ShapeAssignment_8_3 ) ) ;
    public final void rule__Node__Group_8__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1058:1: ( ( ( rule__Node__ShapeAssignment_8_3 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1059:1: ( ( rule__Node__ShapeAssignment_8_3 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1059:1: ( ( rule__Node__ShapeAssignment_8_3 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1060:1: ( rule__Node__ShapeAssignment_8_3 )
            {
             before(grammarAccess.getNodeAccess().getShapeAssignment_8_3()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1061:1: ( rule__Node__ShapeAssignment_8_3 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1061:2: rule__Node__ShapeAssignment_8_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Node__ShapeAssignment_8_3_in_rule__Node__Group_8__3__Impl2080);
            rule__Node__ShapeAssignment_8_3();

            state._fsp--;


            }

             after(grammarAccess.getNodeAccess().getShapeAssignment_8_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Edge__Group__0"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1079:1: rule__Edge__Group__0 : rule__Edge__Group__0__Impl rule__Edge__Group__1 ;
    public final void rule__Edge__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1083:1: ( rule__Edge__Group__0__Impl rule__Edge__Group__1 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1084:2: rule__Edge__Group__0__Impl rule__Edge__Group__1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__0__Impl_in_rule__Edge__Group__02118);
            rule__Edge__Group__0__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__1_in_rule__Edge__Group__02121);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1091:1: rule__Edge__Group__0__Impl : ( () ) ;
    public final void rule__Edge__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1095:1: ( ( () ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1096:1: ( () )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1096:1: ( () )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1097:1: ()
            {
             before(grammarAccess.getEdgeAccess().getEdgeAction_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1098:1: ()
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1100:1: 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1110:1: rule__Edge__Group__1 : rule__Edge__Group__1__Impl rule__Edge__Group__2 ;
    public final void rule__Edge__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1114:1: ( rule__Edge__Group__1__Impl rule__Edge__Group__2 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1115:2: rule__Edge__Group__1__Impl rule__Edge__Group__2
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__1__Impl_in_rule__Edge__Group__12179);
            rule__Edge__Group__1__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__2_in_rule__Edge__Group__12182);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1122:1: rule__Edge__Group__1__Impl : ( ( rule__Edge__NameAssignment_1 ) ) ;
    public final void rule__Edge__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1126:1: ( ( ( rule__Edge__NameAssignment_1 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1127:1: ( ( rule__Edge__NameAssignment_1 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1127:1: ( ( rule__Edge__NameAssignment_1 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1128:1: ( rule__Edge__NameAssignment_1 )
            {
             before(grammarAccess.getEdgeAccess().getNameAssignment_1()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1129:1: ( rule__Edge__NameAssignment_1 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1129:2: rule__Edge__NameAssignment_1
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__NameAssignment_1_in_rule__Edge__Group__1__Impl2209);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1139:1: rule__Edge__Group__2 : rule__Edge__Group__2__Impl rule__Edge__Group__3 ;
    public final void rule__Edge__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1143:1: ( rule__Edge__Group__2__Impl rule__Edge__Group__3 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1144:2: rule__Edge__Group__2__Impl rule__Edge__Group__3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__2__Impl_in_rule__Edge__Group__22239);
            rule__Edge__Group__2__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__3_in_rule__Edge__Group__22242);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1151:1: rule__Edge__Group__2__Impl : ( '(' ) ;
    public final void rule__Edge__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1155:1: ( ( '(' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1156:1: ( '(' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1156:1: ( '(' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1157:1: '('
            {
             before(grammarAccess.getEdgeAccess().getLeftParenthesisKeyword_2()); 
            match(input,22,FollowSets000.FOLLOW_22_in_rule__Edge__Group__2__Impl2270); 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1170:1: rule__Edge__Group__3 : rule__Edge__Group__3__Impl rule__Edge__Group__4 ;
    public final void rule__Edge__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1174:1: ( rule__Edge__Group__3__Impl rule__Edge__Group__4 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1175:2: rule__Edge__Group__3__Impl rule__Edge__Group__4
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__3__Impl_in_rule__Edge__Group__32301);
            rule__Edge__Group__3__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__4_in_rule__Edge__Group__32304);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1182:1: rule__Edge__Group__3__Impl : ( ( rule__Edge__SourceAssignment_3 ) ) ;
    public final void rule__Edge__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1186:1: ( ( ( rule__Edge__SourceAssignment_3 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1187:1: ( ( rule__Edge__SourceAssignment_3 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1187:1: ( ( rule__Edge__SourceAssignment_3 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1188:1: ( rule__Edge__SourceAssignment_3 )
            {
             before(grammarAccess.getEdgeAccess().getSourceAssignment_3()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1189:1: ( rule__Edge__SourceAssignment_3 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1189:2: rule__Edge__SourceAssignment_3
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__SourceAssignment_3_in_rule__Edge__Group__3__Impl2331);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1199:1: rule__Edge__Group__4 : rule__Edge__Group__4__Impl rule__Edge__Group__5 ;
    public final void rule__Edge__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1203:1: ( rule__Edge__Group__4__Impl rule__Edge__Group__5 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1204:2: rule__Edge__Group__4__Impl rule__Edge__Group__5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__4__Impl_in_rule__Edge__Group__42361);
            rule__Edge__Group__4__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__5_in_rule__Edge__Group__42364);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1211:1: rule__Edge__Group__4__Impl : ( ',' ) ;
    public final void rule__Edge__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1215:1: ( ( ',' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1216:1: ( ',' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1216:1: ( ',' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1217:1: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_4()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Edge__Group__4__Impl2392); 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1230:1: rule__Edge__Group__5 : rule__Edge__Group__5__Impl rule__Edge__Group__6 ;
    public final void rule__Edge__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1234:1: ( rule__Edge__Group__5__Impl rule__Edge__Group__6 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1235:2: rule__Edge__Group__5__Impl rule__Edge__Group__6
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__5__Impl_in_rule__Edge__Group__52423);
            rule__Edge__Group__5__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__6_in_rule__Edge__Group__52426);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1242:1: rule__Edge__Group__5__Impl : ( ( rule__Edge__TargetAssignment_5 ) ) ;
    public final void rule__Edge__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1246:1: ( ( ( rule__Edge__TargetAssignment_5 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1247:1: ( ( rule__Edge__TargetAssignment_5 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1247:1: ( ( rule__Edge__TargetAssignment_5 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1248:1: ( rule__Edge__TargetAssignment_5 )
            {
             before(grammarAccess.getEdgeAccess().getTargetAssignment_5()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1249:1: ( rule__Edge__TargetAssignment_5 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1249:2: rule__Edge__TargetAssignment_5
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__TargetAssignment_5_in_rule__Edge__Group__5__Impl2453);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1259:1: rule__Edge__Group__6 : rule__Edge__Group__6__Impl rule__Edge__Group__7 ;
    public final void rule__Edge__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1263:1: ( rule__Edge__Group__6__Impl rule__Edge__Group__7 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1264:2: rule__Edge__Group__6__Impl rule__Edge__Group__7
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__6__Impl_in_rule__Edge__Group__62483);
            rule__Edge__Group__6__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__7_in_rule__Edge__Group__62486);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1271:1: rule__Edge__Group__6__Impl : ( ')' ) ;
    public final void rule__Edge__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1275:1: ( ( ')' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1276:1: ( ')' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1276:1: ( ')' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1277:1: ')'
            {
             before(grammarAccess.getEdgeAccess().getRightParenthesisKeyword_6()); 
            match(input,23,FollowSets000.FOLLOW_23_in_rule__Edge__Group__6__Impl2514); 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1290:1: rule__Edge__Group__7 : rule__Edge__Group__7__Impl rule__Edge__Group__8 ;
    public final void rule__Edge__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1294:1: ( rule__Edge__Group__7__Impl rule__Edge__Group__8 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1295:2: rule__Edge__Group__7__Impl rule__Edge__Group__8
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__7__Impl_in_rule__Edge__Group__72545);
            rule__Edge__Group__7__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__8_in_rule__Edge__Group__72548);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1302:1: rule__Edge__Group__7__Impl : ( '->' ) ;
    public final void rule__Edge__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1306:1: ( ( '->' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1307:1: ( '->' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1307:1: ( '->' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1308:1: '->'
            {
             before(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7()); 
            match(input,19,FollowSets000.FOLLOW_19_in_rule__Edge__Group__7__Impl2576); 
             after(grammarAccess.getEdgeAccess().getHyphenMinusGreaterThanSignKeyword_7()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1321:1: rule__Edge__Group__8 : rule__Edge__Group__8__Impl rule__Edge__Group__9 ;
    public final void rule__Edge__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1325:1: ( rule__Edge__Group__8__Impl rule__Edge__Group__9 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1326:2: rule__Edge__Group__8__Impl rule__Edge__Group__9
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__8__Impl_in_rule__Edge__Group__82607);
            rule__Edge__Group__8__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__9_in_rule__Edge__Group__82610);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1333:1: rule__Edge__Group__8__Impl : ( 'edge' ) ;
    public final void rule__Edge__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1337:1: ( ( 'edge' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1338:1: ( 'edge' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1338:1: ( 'edge' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1339:1: 'edge'
            {
             before(grammarAccess.getEdgeAccess().getEdgeKeyword_8()); 
            match(input,27,FollowSets000.FOLLOW_27_in_rule__Edge__Group__8__Impl2638); 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1352:1: rule__Edge__Group__9 : rule__Edge__Group__9__Impl rule__Edge__Group__10 ;
    public final void rule__Edge__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1356:1: ( rule__Edge__Group__9__Impl rule__Edge__Group__10 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1357:2: rule__Edge__Group__9__Impl rule__Edge__Group__10
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__9__Impl_in_rule__Edge__Group__92669);
            rule__Edge__Group__9__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__10_in_rule__Edge__Group__92672);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1364:1: rule__Edge__Group__9__Impl : ( ',' ) ;
    public final void rule__Edge__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1368:1: ( ( ',' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1369:1: ( ',' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1369:1: ( ',' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1370:1: ','
            {
             before(grammarAccess.getEdgeAccess().getCommaKeyword_9()); 
            match(input,24,FollowSets000.FOLLOW_24_in_rule__Edge__Group__9__Impl2700); 
             after(grammarAccess.getEdgeAccess().getCommaKeyword_9()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1383:1: rule__Edge__Group__10 : rule__Edge__Group__10__Impl rule__Edge__Group__11 ;
    public final void rule__Edge__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1387:1: ( rule__Edge__Group__10__Impl rule__Edge__Group__11 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1388:2: rule__Edge__Group__10__Impl rule__Edge__Group__11
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__10__Impl_in_rule__Edge__Group__102731);
            rule__Edge__Group__10__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__11_in_rule__Edge__Group__102734);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1395:1: rule__Edge__Group__10__Impl : ( 'label' ) ;
    public final void rule__Edge__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1399:1: ( ( 'label' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1400:1: ( 'label' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1400:1: ( 'label' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1401:1: 'label'
            {
             before(grammarAccess.getEdgeAccess().getLabelKeyword_10()); 
            match(input,28,FollowSets000.FOLLOW_28_in_rule__Edge__Group__10__Impl2762); 
             after(grammarAccess.getEdgeAccess().getLabelKeyword_10()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1414:1: rule__Edge__Group__11 : rule__Edge__Group__11__Impl rule__Edge__Group__12 ;
    public final void rule__Edge__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1418:1: ( rule__Edge__Group__11__Impl rule__Edge__Group__12 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1419:2: rule__Edge__Group__11__Impl rule__Edge__Group__12
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__11__Impl_in_rule__Edge__Group__112793);
            rule__Edge__Group__11__Impl();

            state._fsp--;

            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__12_in_rule__Edge__Group__112796);
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1426:1: rule__Edge__Group__11__Impl : ( '=' ) ;
    public final void rule__Edge__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1430:1: ( ( '=' ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1431:1: ( '=' )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1431:1: ( '=' )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1432:1: '='
            {
             before(grammarAccess.getEdgeAccess().getEqualsSignKeyword_11()); 
            match(input,26,FollowSets000.FOLLOW_26_in_rule__Edge__Group__11__Impl2824); 
             after(grammarAccess.getEdgeAccess().getEqualsSignKeyword_11()); 

            }


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1445:1: rule__Edge__Group__12 : rule__Edge__Group__12__Impl ;
    public final void rule__Edge__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1449:1: ( rule__Edge__Group__12__Impl )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1450:2: rule__Edge__Group__12__Impl
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__Group__12__Impl_in_rule__Edge__Group__122855);
            rule__Edge__Group__12__Impl();

            state._fsp--;


            }

        }
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1456:1: rule__Edge__Group__12__Impl : ( ( rule__Edge__LabelAssignment_12 ) ) ;
    public final void rule__Edge__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1460:1: ( ( ( rule__Edge__LabelAssignment_12 ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1461:1: ( ( rule__Edge__LabelAssignment_12 ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1461:1: ( ( rule__Edge__LabelAssignment_12 ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1462:1: ( rule__Edge__LabelAssignment_12 )
            {
             before(grammarAccess.getEdgeAccess().getLabelAssignment_12()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1463:1: ( rule__Edge__LabelAssignment_12 )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1463:2: rule__Edge__LabelAssignment_12
            {
            pushFollow(FollowSets000.FOLLOW_rule__Edge__LabelAssignment_12_in_rule__Edge__Group__12__Impl2882);
            rule__Edge__LabelAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getEdgeAccess().getLabelAssignment_12()); 

            }


            }

        }
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


    // $ANTLR start "rule__MutatorGraph__MetamodelAssignment_2"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1500:1: rule__MutatorGraph__MetamodelAssignment_2 : ( ruleEString ) ;
    public final void rule__MutatorGraph__MetamodelAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1504:1: ( ( ruleEString ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1505:1: ( ruleEString )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1505:1: ( ruleEString )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1506:1: ruleEString
            {
             before(grammarAccess.getMutatorGraphAccess().getMetamodelEStringParserRuleCall_2_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_rule__MutatorGraph__MetamodelAssignment_22943);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getMutatorGraphAccess().getMetamodelEStringParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__MetamodelAssignment_2"


    // $ANTLR start "rule__MutatorGraph__NameAssignment_3"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1515:1: rule__MutatorGraph__NameAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__MutatorGraph__NameAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1519:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1520:1: ( ( RULE_ID ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1520:1: ( ( RULE_ID ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1521:1: ( RULE_ID )
            {
             before(grammarAccess.getMutatorGraphAccess().getNameEClassCrossReference_3_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1522:1: ( RULE_ID )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1523:1: RULE_ID
            {
             before(grammarAccess.getMutatorGraphAccess().getNameEClassIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__MutatorGraph__NameAssignment_32978); 
             after(grammarAccess.getMutatorGraphAccess().getNameEClassIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getMutatorGraphAccess().getNameEClassCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__NameAssignment_3"


    // $ANTLR start "rule__MutatorGraph__TypeAssignment_5"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1534:1: rule__MutatorGraph__TypeAssignment_5 : ( ruleGraphType ) ;
    public final void rule__MutatorGraph__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1538:1: ( ( ruleGraphType ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1539:1: ( ruleGraphType )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1539:1: ( ruleGraphType )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1540:1: ruleGraphType
            {
             before(grammarAccess.getMutatorGraphAccess().getTypeGraphTypeEnumRuleCall_5_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleGraphType_in_rule__MutatorGraph__TypeAssignment_53013);
            ruleGraphType();

            state._fsp--;

             after(grammarAccess.getMutatorGraphAccess().getTypeGraphTypeEnumRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__TypeAssignment_5"


    // $ANTLR start "rule__MutatorGraph__NodesAssignment_7"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1549:1: rule__MutatorGraph__NodesAssignment_7 : ( ruleNode ) ;
    public final void rule__MutatorGraph__NodesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1553:1: ( ( ruleNode ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1554:1: ( ruleNode )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1554:1: ( ruleNode )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1555:1: ruleNode
            {
             before(grammarAccess.getMutatorGraphAccess().getNodesNodeParserRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNode_in_rule__MutatorGraph__NodesAssignment_73044);
            ruleNode();

            state._fsp--;

             after(grammarAccess.getMutatorGraphAccess().getNodesNodeParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__NodesAssignment_7"


    // $ANTLR start "rule__MutatorGraph__EdgesAssignment_8"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1564:1: rule__MutatorGraph__EdgesAssignment_8 : ( ruleEdge ) ;
    public final void rule__MutatorGraph__EdgesAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1568:1: ( ( ruleEdge ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1569:1: ( ruleEdge )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1569:1: ( ruleEdge )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1570:1: ruleEdge
            {
             before(grammarAccess.getMutatorGraphAccess().getEdgesEdgeParserRuleCall_8_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleEdge_in_rule__MutatorGraph__EdgesAssignment_83075);
            ruleEdge();

            state._fsp--;

             after(grammarAccess.getMutatorGraphAccess().getEdgesEdgeParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MutatorGraph__EdgesAssignment_8"


    // $ANTLR start "rule__Node__NameAssignment_1"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1579:1: rule__Node__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Node__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1583:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1584:1: ( ( RULE_ID ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1584:1: ( ( RULE_ID ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1585:1: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getNameEClassCrossReference_1_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1586:1: ( RULE_ID )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1587:1: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Node__NameAssignment_13110); 
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


    // $ANTLR start "rule__Node__NegationAssignment_3"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1598:1: rule__Node__NegationAssignment_3 : ( ruleNegation ) ;
    public final void rule__Node__NegationAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1602:1: ( ( ruleNegation ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1603:1: ( ruleNegation )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1603:1: ( ruleNegation )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1604:1: ruleNegation
            {
             before(grammarAccess.getNodeAccess().getNegationNegationEnumRuleCall_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNegation_in_rule__Node__NegationAssignment_33145);
            ruleNegation();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getNegationNegationEnumRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__NegationAssignment_3"


    // $ANTLR start "rule__Node__AttributeAssignment_4"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1613:1: rule__Node__AttributeAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Node__AttributeAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1617:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1618:1: ( ( RULE_ID ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1618:1: ( ( RULE_ID ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1619:1: ( RULE_ID )
            {
             before(grammarAccess.getNodeAccess().getAttributeEAttributeCrossReference_4_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1620:1: ( RULE_ID )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1621:1: RULE_ID
            {
             before(grammarAccess.getNodeAccess().getAttributeEAttributeIDTerminalRuleCall_4_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Node__AttributeAssignment_43180); 
             after(grammarAccess.getNodeAccess().getAttributeEAttributeIDTerminalRuleCall_4_0_1()); 

            }

             after(grammarAccess.getNodeAccess().getAttributeEAttributeCrossReference_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__AttributeAssignment_4"


    // $ANTLR start "rule__Node__TypeAssignment_7"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1632:1: rule__Node__TypeAssignment_7 : ( ruleNodeType ) ;
    public final void rule__Node__TypeAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1636:1: ( ( ruleNodeType ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1637:1: ( ruleNodeType )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1637:1: ( ruleNodeType )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1638:1: ruleNodeType
            {
             before(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_7_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeType_in_rule__Node__TypeAssignment_73215);
            ruleNodeType();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getTypeNodeTypeEnumRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__TypeAssignment_7"


    // $ANTLR start "rule__Node__ShapeAssignment_8_3"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1647:1: rule__Node__ShapeAssignment_8_3 : ( ruleNodeShape ) ;
    public final void rule__Node__ShapeAssignment_8_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1651:1: ( ( ruleNodeShape ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1652:1: ( ruleNodeShape )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1652:1: ( ruleNodeShape )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1653:1: ruleNodeShape
            {
             before(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_8_3_0()); 
            pushFollow(FollowSets000.FOLLOW_ruleNodeShape_in_rule__Node__ShapeAssignment_8_33246);
            ruleNodeShape();

            state._fsp--;

             after(grammarAccess.getNodeAccess().getShapeNodeShapeEnumRuleCall_8_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Node__ShapeAssignment_8_3"


    // $ANTLR start "rule__Edge__NameAssignment_1"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1662:1: rule__Edge__NameAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1666:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1667:1: ( ( RULE_ID ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1667:1: ( ( RULE_ID ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1668:1: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getNameEClassCrossReference_1_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1669:1: ( RULE_ID )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1670:1: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getNameEClassIDTerminalRuleCall_1_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Edge__NameAssignment_13281); 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1681:1: rule__Edge__SourceAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__SourceAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1685:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1686:1: ( ( RULE_ID ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1686:1: ( ( RULE_ID ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1687:1: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceCrossReference_3_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1688:1: ( RULE_ID )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1689:1: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getSourceEReferenceIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Edge__SourceAssignment_33320); 
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
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1700:1: rule__Edge__TargetAssignment_5 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__TargetAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1704:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1705:1: ( ( RULE_ID ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1705:1: ( ( RULE_ID ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1706:1: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceCrossReference_5_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1707:1: ( RULE_ID )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1708:1: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getTargetEReferenceIDTerminalRuleCall_5_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Edge__TargetAssignment_53359); 
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


    // $ANTLR start "rule__Edge__LabelAssignment_12"
    // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1719:1: rule__Edge__LabelAssignment_12 : ( ( RULE_ID ) ) ;
    public final void rule__Edge__LabelAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1723:1: ( ( ( RULE_ID ) ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1724:1: ( ( RULE_ID ) )
            {
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1724:1: ( ( RULE_ID ) )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1725:1: ( RULE_ID )
            {
             before(grammarAccess.getEdgeAccess().getLabelEReferenceCrossReference_12_0()); 
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1726:1: ( RULE_ID )
            // ../org.mutatorgraph.ui/src-gen/org/mutatorgraph/ui/contentassist/antlr/internal/InternalMutatorGraph.g:1727:1: RULE_ID
            {
             before(grammarAccess.getEdgeAccess().getLabelEReferenceIDTerminalRuleCall_12_0_1()); 
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_rule__Edge__LabelAssignment_123398); 
             after(grammarAccess.getEdgeAccess().getLabelEReferenceIDTerminalRuleCall_12_0_1()); 

            }

             after(grammarAccess.getEdgeAccess().getLabelEReferenceCrossReference_12_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Edge__LabelAssignment_12"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMutatorGraph_in_entryRuleMutatorGraph61 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorGraph68 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__0_in_ruleMutatorGraph94 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString121 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString154 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNode_in_entryRuleNode181 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNode188 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__0_in_ruleNode214 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEdge_in_entryRuleEdge241 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEdge248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__0_in_ruleEdge274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleGraphType312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Negation__Alternatives_in_ruleNegation350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NodeType__Alternatives_in_ruleNodeType386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__NodeShape__Alternatives_in_ruleNodeShape422 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_12_in_rule__Negation__Alternatives507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_13_in_rule__Negation__Alternatives528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_14_in_rule__NodeType__Alternatives564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_15_in_rule__NodeType__Alternatives585 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_16_in_rule__NodeShape__Alternatives621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_rule__NodeShape__Alternatives642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__0__Impl_in_rule__MutatorGraph__Group__0675 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__1_in_rule__MutatorGraph__Group__0678 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__1__Impl_in_rule__MutatorGraph__Group__1736 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__2_in_rule__MutatorGraph__Group__1739 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_18_in_rule__MutatorGraph__Group__1__Impl767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__2__Impl_in_rule__MutatorGraph__Group__2798 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__3_in_rule__MutatorGraph__Group__2801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__MetamodelAssignment_2_in_rule__MutatorGraph__Group__2__Impl828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__3__Impl_in_rule__MutatorGraph__Group__3858 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__4_in_rule__MutatorGraph__Group__3861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__NameAssignment_3_in_rule__MutatorGraph__Group__3__Impl888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__4__Impl_in_rule__MutatorGraph__Group__4918 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__5_in_rule__MutatorGraph__Group__4921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__MutatorGraph__Group__4__Impl949 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__5__Impl_in_rule__MutatorGraph__Group__5980 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__6_in_rule__MutatorGraph__Group__5983 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__TypeAssignment_5_in_rule__MutatorGraph__Group__5__Impl1010 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__6__Impl_in_rule__MutatorGraph__Group__61040 = new BitSet(new long[]{0x0000000000200020L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__7_in_rule__MutatorGraph__Group__61043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_rule__MutatorGraph__Group__6__Impl1071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__7__Impl_in_rule__MutatorGraph__Group__71102 = new BitSet(new long[]{0x0000000000200020L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__8_in_rule__MutatorGraph__Group__71105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__NodesAssignment_7_in_rule__MutatorGraph__Group__7__Impl1132 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__8__Impl_in_rule__MutatorGraph__Group__81163 = new BitSet(new long[]{0x0000000000200020L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__9_in_rule__MutatorGraph__Group__81166 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__MutatorGraph__EdgesAssignment_8_in_rule__MutatorGraph__Group__8__Impl1193 = new BitSet(new long[]{0x0000000000000022L});
        public static final BitSet FOLLOW_rule__MutatorGraph__Group__9__Impl_in_rule__MutatorGraph__Group__91224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_21_in_rule__MutatorGraph__Group__9__Impl1252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__0__Impl_in_rule__Node__Group__01303 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Node__Group__1_in_rule__Node__Group__01306 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__1__Impl_in_rule__Node__Group__11364 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Node__Group__2_in_rule__Node__Group__11367 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__NameAssignment_1_in_rule__Node__Group__1__Impl1394 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__2__Impl_in_rule__Node__Group__21424 = new BitSet(new long[]{0x0000000000003020L});
        public static final BitSet FOLLOW_rule__Node__Group__3_in_rule__Node__Group__21427 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Node__Group__2__Impl1455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__3__Impl_in_rule__Node__Group__31486 = new BitSet(new long[]{0x0000000000003020L});
        public static final BitSet FOLLOW_rule__Node__Group__4_in_rule__Node__Group__31489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__NegationAssignment_3_in_rule__Node__Group__3__Impl1516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__4__Impl_in_rule__Node__Group__41547 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Node__Group__5_in_rule__Node__Group__41550 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__AttributeAssignment_4_in_rule__Node__Group__4__Impl1577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__5__Impl_in_rule__Node__Group__51607 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Node__Group__6_in_rule__Node__Group__51610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Node__Group__5__Impl1638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__6__Impl_in_rule__Node__Group__61669 = new BitSet(new long[]{0x000000000000C000L});
        public static final BitSet FOLLOW_rule__Node__Group__7_in_rule__Node__Group__61672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Node__Group__6__Impl1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__7__Impl_in_rule__Node__Group__71731 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Node__Group__8_in_rule__Node__Group__71734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__TypeAssignment_7_in_rule__Node__Group__7__Impl1761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group__8__Impl_in_rule__Node__Group__81791 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group_8__0_in_rule__Node__Group__8__Impl1818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group_8__0__Impl_in_rule__Node__Group_8__01867 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_rule__Node__Group_8__1_in_rule__Node__Group_8__01870 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Node__Group_8__0__Impl1898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group_8__1__Impl_in_rule__Node__Group_8__11929 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Node__Group_8__2_in_rule__Node__Group_8__11932 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_rule__Node__Group_8__1__Impl1960 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group_8__2__Impl_in_rule__Node__Group_8__21991 = new BitSet(new long[]{0x0000000000030000L});
        public static final BitSet FOLLOW_rule__Node__Group_8__3_in_rule__Node__Group_8__21994 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Node__Group_8__2__Impl2022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__Group_8__3__Impl_in_rule__Node__Group_8__32053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Node__ShapeAssignment_8_3_in_rule__Node__Group_8__3__Impl2080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__0__Impl_in_rule__Edge__Group__02118 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Edge__Group__1_in_rule__Edge__Group__02121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__1__Impl_in_rule__Edge__Group__12179 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_rule__Edge__Group__2_in_rule__Edge__Group__12182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__NameAssignment_1_in_rule__Edge__Group__1__Impl2209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__2__Impl_in_rule__Edge__Group__22239 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Edge__Group__3_in_rule__Edge__Group__22242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_rule__Edge__Group__2__Impl2270 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__3__Impl_in_rule__Edge__Group__32301 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Edge__Group__4_in_rule__Edge__Group__32304 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__SourceAssignment_3_in_rule__Edge__Group__3__Impl2331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__4__Impl_in_rule__Edge__Group__42361 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Edge__Group__5_in_rule__Edge__Group__42364 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Edge__Group__4__Impl2392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__5__Impl_in_rule__Edge__Group__52423 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_rule__Edge__Group__6_in_rule__Edge__Group__52426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__TargetAssignment_5_in_rule__Edge__Group__5__Impl2453 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__6__Impl_in_rule__Edge__Group__62483 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_rule__Edge__Group__7_in_rule__Edge__Group__62486 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_23_in_rule__Edge__Group__6__Impl2514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__7__Impl_in_rule__Edge__Group__72545 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_rule__Edge__Group__8_in_rule__Edge__Group__72548 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_rule__Edge__Group__7__Impl2576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__8__Impl_in_rule__Edge__Group__82607 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_rule__Edge__Group__9_in_rule__Edge__Group__82610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_rule__Edge__Group__8__Impl2638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__9__Impl_in_rule__Edge__Group__92669 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_rule__Edge__Group__10_in_rule__Edge__Group__92672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rule__Edge__Group__9__Impl2700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__10__Impl_in_rule__Edge__Group__102731 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_rule__Edge__Group__11_in_rule__Edge__Group__102734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_rule__Edge__Group__10__Impl2762 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__11__Impl_in_rule__Edge__Group__112793 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_rule__Edge__Group__12_in_rule__Edge__Group__112796 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_rule__Edge__Group__11__Impl2824 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__Group__12__Impl_in_rule__Edge__Group__122855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rule__Edge__LabelAssignment_12_in_rule__Edge__Group__12__Impl2882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_rule__MutatorGraph__MetamodelAssignment_22943 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__MutatorGraph__NameAssignment_32978 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleGraphType_in_rule__MutatorGraph__TypeAssignment_53013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNode_in_rule__MutatorGraph__NodesAssignment_73044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEdge_in_rule__MutatorGraph__EdgesAssignment_83075 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Node__NameAssignment_13110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNegation_in_rule__Node__NegationAssignment_33145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Node__AttributeAssignment_43180 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeType_in_rule__Node__TypeAssignment_73215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNodeShape_in_rule__Node__ShapeAssignment_8_33246 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Edge__NameAssignment_13281 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Edge__SourceAssignment_33320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Edge__TargetAssignment_53359 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_rule__Edge__LabelAssignment_123398 = new BitSet(new long[]{0x0000000000000002L});
    }


}