package wodel.dsls.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import wodel.dsls.services.WodelGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalWodelParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'with'", "'blocks'", "'{'", "'}'", "'commands'", "'constraints'", "'library'", "'for'", "'metamodel'", "'generate'", "'mutants'", "'in'", "'from'", "','", "'repeat'", "'='", "'['", "'..'", "']'", "'context'", "':'", "'import'", "'-'", "'.'", "'E'", "'e'", "'true'", "'false'", "'self'", "'->'", "'null'", "'remove'", "'one'", "'reference'", "'all'", "'create'", "'select'", "'sample'", "'modify'", "'to'", "'source'", "'target'", "'clone'", "'contents'", "'unset'", "'('", "')'", "'swap'", "'copy'", "'reverse'", "'+'", "'swapref'", "'where'", "'closure'", "'other'", "'random-boolean'", "'random-string'", "'upper'", "'catstart'", "'catend'", "'lower'", "'replace'", "'random-double'", "'min'", "'max'", "'random-int'", "'random'", "'*'", "'and'", "'or'", "'<>'", "'/'", "'%'", "'yes'", "'no'", "'equals'", "'distinct'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

    // delegates
    // delegators


        public InternalWodelParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalWodelParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalWodelParser.tokenNames; }
    public String getGrammarFileName() { return "../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g"; }



     	private WodelGrammarAccess grammarAccess;
     	
        public InternalWodelParser(TokenStream input, WodelGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "MutatorEnvironment";	
       	}
       	
       	@Override
       	protected WodelGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleMutatorEnvironment"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:68:1: entryRuleMutatorEnvironment returns [EObject current=null] : iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF ;
    public final EObject entryRuleMutatorEnvironment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutatorEnvironment = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:69:2: (iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:70:2: iv_ruleMutatorEnvironment= ruleMutatorEnvironment EOF
            {
             newCompositeNode(grammarAccess.getMutatorEnvironmentRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutatorEnvironment_in_entryRuleMutatorEnvironment75);
            iv_ruleMutatorEnvironment=ruleMutatorEnvironment();

            state._fsp--;

             current =iv_ruleMutatorEnvironment; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutatorEnvironment85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMutatorEnvironment"


    // $ANTLR start "ruleMutatorEnvironment"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:77:1: ruleMutatorEnvironment returns [EObject current=null] : ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? ) ;
    public final EObject ruleMutatorEnvironment() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        EObject lv_load_0_0 = null;

        EObject lv_definition_1_0 = null;

        EObject lv_blocks_5_0 = null;

        EObject lv_blocks_6_0 = null;

        EObject lv_commands_10_0 = null;

        EObject lv_commands_11_0 = null;

        EObject lv_constraints_15_0 = null;

        EObject lv_constraints_16_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:80:28: ( ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:81:1: ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:81:1: ( ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:81:2: ( (lv_load_0_0= ruleLoad ) )* ( (lv_definition_1_0= ruleDefinition ) ) otherlv_2= 'with' ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) ) (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:81:2: ( (lv_load_0_0= ruleLoad ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==32) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:82:1: (lv_load_0_0= ruleLoad )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:82:1: (lv_load_0_0= ruleLoad )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:83:3: lv_load_0_0= ruleLoad
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getLoadLoadParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleLoad_in_ruleMutatorEnvironment131);
            	    lv_load_0_0=ruleLoad();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"load",
            	            		lv_load_0_0, 
            	            		"Load");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:99:3: ( (lv_definition_1_0= ruleDefinition ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:100:1: (lv_definition_1_0= ruleDefinition )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:100:1: (lv_definition_1_0= ruleDefinition )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:101:3: lv_definition_1_0= ruleDefinition
            {
             
            	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getDefinitionDefinitionParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_ruleMutatorEnvironment153);
            lv_definition_1_0=ruleDefinition();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
            	        }
                   		set(
                   			current, 
                   			"definition",
                    		lv_definition_1_0, 
                    		"Definition");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleMutatorEnvironment165); 

                	newLeafNode(otherlv_2, grammarAccess.getMutatorEnvironmentAccess().getWithKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:121:1: ( (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' ) | (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==12) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:121:2: (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:121:2: (otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:121:4: otherlv_3= 'blocks' otherlv_4= '{' ( (lv_blocks_5_0= ruleBlock ) ) ( (lv_blocks_6_0= ruleBlock ) )* otherlv_7= '}'
                    {
                    otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleMutatorEnvironment179); 

                        	newLeafNode(otherlv_3, grammarAccess.getMutatorEnvironmentAccess().getBlocksKeyword_3_0_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMutatorEnvironment191); 

                        	newLeafNode(otherlv_4, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_3_0_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:129:1: ( (lv_blocks_5_0= ruleBlock ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:130:1: (lv_blocks_5_0= ruleBlock )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:130:1: (lv_blocks_5_0= ruleBlock )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:131:3: lv_blocks_5_0= ruleBlock
                    {
                     
                    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getBlocksBlockParserRuleCall_3_0_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleBlock_in_ruleMutatorEnvironment212);
                    lv_blocks_5_0=ruleBlock();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	        }
                           		add(
                           			current, 
                           			"blocks",
                            		lv_blocks_5_0, 
                            		"Block");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:147:2: ( (lv_blocks_6_0= ruleBlock ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==RULE_ID) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:148:1: (lv_blocks_6_0= ruleBlock )
                    	    {
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:148:1: (lv_blocks_6_0= ruleBlock )
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:149:3: lv_blocks_6_0= ruleBlock
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getBlocksBlockParserRuleCall_3_0_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleBlock_in_ruleMutatorEnvironment233);
                    	    lv_blocks_6_0=ruleBlock();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"blocks",
                    	            		lv_blocks_6_0, 
                    	            		"Block");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMutatorEnvironment246); 

                        	newLeafNode(otherlv_7, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_3_0_4());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:170:6: (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:170:6: (otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:170:8: otherlv_8= 'commands' otherlv_9= '{' ( (lv_commands_10_0= ruleMutator ) ) ( (lv_commands_11_0= ruleMutator ) )* otherlv_12= '}'
                    {
                    otherlv_8=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleMutatorEnvironment266); 

                        	newLeafNode(otherlv_8, grammarAccess.getMutatorEnvironmentAccess().getCommandsKeyword_3_1_0());
                        
                    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMutatorEnvironment278); 

                        	newLeafNode(otherlv_9, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_3_1_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:178:1: ( (lv_commands_10_0= ruleMutator ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:179:1: (lv_commands_10_0= ruleMutator )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:179:1: (lv_commands_10_0= ruleMutator )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:180:3: lv_commands_10_0= ruleMutator
                    {
                     
                    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getCommandsMutatorParserRuleCall_3_1_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleMutatorEnvironment299);
                    lv_commands_10_0=ruleMutator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	        }
                           		add(
                           			current, 
                           			"commands",
                            		lv_commands_10_0, 
                            		"Mutator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:196:2: ( (lv_commands_11_0= ruleMutator ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==RULE_ID||LA3_0==27||LA3_0==42||LA3_0==46||LA3_0==49||LA3_0==53) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:197:1: (lv_commands_11_0= ruleMutator )
                    	    {
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:197:1: (lv_commands_11_0= ruleMutator )
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:198:3: lv_commands_11_0= ruleMutator
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getCommandsMutatorParserRuleCall_3_1_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleMutatorEnvironment320);
                    	    lv_commands_11_0=ruleMutator();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"commands",
                    	            		lv_commands_11_0, 
                    	            		"Mutator");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMutatorEnvironment333); 

                        	newLeafNode(otherlv_12, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_3_1_4());
                        

                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:218:3: (otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:218:5: otherlv_13= 'constraints' otherlv_14= '{' ( (lv_constraints_15_0= ruleConstraint ) ) ( (lv_constraints_16_0= ruleConstraint ) )* otherlv_17= '}'
                    {
                    otherlv_13=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleMutatorEnvironment348); 

                        	newLeafNode(otherlv_13, grammarAccess.getMutatorEnvironmentAccess().getConstraintsKeyword_4_0());
                        
                    otherlv_14=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleMutatorEnvironment360); 

                        	newLeafNode(otherlv_14, grammarAccess.getMutatorEnvironmentAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:226:1: ( (lv_constraints_15_0= ruleConstraint ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:227:1: (lv_constraints_15_0= ruleConstraint )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:227:1: (lv_constraints_15_0= ruleConstraint )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:228:3: lv_constraints_15_0= ruleConstraint
                    {
                     
                    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getConstraintsConstraintParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleConstraint_in_ruleMutatorEnvironment381);
                    lv_constraints_15_0=ruleConstraint();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	        }
                           		add(
                           			current, 
                           			"constraints",
                            		lv_constraints_15_0, 
                            		"Constraint");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:244:2: ( (lv_constraints_16_0= ruleConstraint ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==30) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:245:1: (lv_constraints_16_0= ruleConstraint )
                    	    {
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:245:1: (lv_constraints_16_0= ruleConstraint )
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:246:3: lv_constraints_16_0= ruleConstraint
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getMutatorEnvironmentAccess().getConstraintsConstraintParserRuleCall_4_3_0()); 
                    	    	    
                    	    pushFollow(FollowSets000.FOLLOW_ruleConstraint_in_ruleMutatorEnvironment402);
                    	    lv_constraints_16_0=ruleConstraint();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getMutatorEnvironmentRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"constraints",
                    	            		lv_constraints_16_0, 
                    	            		"Constraint");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    otherlv_17=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleMutatorEnvironment415); 

                        	newLeafNode(otherlv_17, grammarAccess.getMutatorEnvironmentAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMutatorEnvironment"


    // $ANTLR start "entryRuleDefinition"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:274:1: entryRuleDefinition returns [EObject current=null] : iv_ruleDefinition= ruleDefinition EOF ;
    public final EObject entryRuleDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefinition = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:275:2: (iv_ruleDefinition= ruleDefinition EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:276:2: iv_ruleDefinition= ruleDefinition EOF
            {
             newCompositeNode(grammarAccess.getDefinitionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDefinition_in_entryRuleDefinition453);
            iv_ruleDefinition=ruleDefinition();

            state._fsp--;

             current =iv_ruleDefinition; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDefinition463); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefinition"


    // $ANTLR start "ruleDefinition"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:283:1: ruleDefinition returns [EObject current=null] : (this_Library_0= ruleLibrary | this_Program_1= ruleProgram ) ;
    public final EObject ruleDefinition() throws RecognitionException {
        EObject current = null;

        EObject this_Library_0 = null;

        EObject this_Program_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:286:28: ( (this_Library_0= ruleLibrary | this_Program_1= ruleProgram ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:287:1: (this_Library_0= ruleLibrary | this_Program_1= ruleProgram )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:287:1: (this_Library_0= ruleLibrary | this_Program_1= ruleProgram )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==17) ) {
                alt7=1;
            }
            else if ( (LA7_0==20) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:288:5: this_Library_0= ruleLibrary
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getLibraryParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLibrary_in_ruleDefinition510);
                    this_Library_0=ruleLibrary();

                    state._fsp--;

                     
                            current = this_Library_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:298:5: this_Program_1= ruleProgram
                    {
                     
                            newCompositeNode(grammarAccess.getDefinitionAccess().getProgramParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleProgram_in_ruleDefinition537);
                    this_Program_1=ruleProgram();

                    state._fsp--;

                     
                            current = this_Program_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefinition"


    // $ANTLR start "entryRuleLibrary"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:314:1: entryRuleLibrary returns [EObject current=null] : iv_ruleLibrary= ruleLibrary EOF ;
    public final EObject entryRuleLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLibrary = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:315:2: (iv_ruleLibrary= ruleLibrary EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:316:2: iv_ruleLibrary= ruleLibrary EOF
            {
             newCompositeNode(grammarAccess.getLibraryRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLibrary_in_entryRuleLibrary572);
            iv_ruleLibrary=ruleLibrary();

            state._fsp--;

             current =iv_ruleLibrary; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLibrary582); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLibrary"


    // $ANTLR start "ruleLibrary"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:323:1: ruleLibrary returns [EObject current=null] : ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) ) ;
    public final EObject ruleLibrary() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_metamodel_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:326:28: ( ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:327:1: ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:327:1: ( () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:327:2: () otherlv_1= 'library' otherlv_2= 'for' otherlv_3= 'metamodel' ( (lv_metamodel_4_0= ruleEString ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:327:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:328:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLibraryAccess().getLibraryAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleLibrary628); 

                	newLeafNode(otherlv_1, grammarAccess.getLibraryAccess().getLibraryKeyword_1());
                
            otherlv_2=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleLibrary640); 

                	newLeafNode(otherlv_2, grammarAccess.getLibraryAccess().getForKeyword_2());
                
            otherlv_3=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleLibrary652); 

                	newLeafNode(otherlv_3, grammarAccess.getLibraryAccess().getMetamodelKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:345:1: ( (lv_metamodel_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:346:1: (lv_metamodel_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:346:1: (lv_metamodel_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:347:3: lv_metamodel_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getLibraryAccess().getMetamodelEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLibrary673);
            lv_metamodel_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLibraryRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLibrary"


    // $ANTLR start "entryRuleProgram"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:371:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:372:2: (iv_ruleProgram= ruleProgram EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:373:2: iv_ruleProgram= ruleProgram EOF
            {
             newCompositeNode(grammarAccess.getProgramRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleProgram_in_entryRuleProgram709);
            iv_ruleProgram=ruleProgram();

            state._fsp--;

             current =iv_ruleProgram; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProgram719); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:380:1: ruleProgram returns [EObject current=null] : ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) )? otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_num_2_0 = null;

        AntlrDatatypeRuleToken lv_output_5_0 = null;

        EObject lv_source_7_0 = null;

        AntlrDatatypeRuleToken lv_metamodel_9_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:383:28: ( ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) )? otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:384:1: ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) )? otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:384:1: ( () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) )? otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:384:2: () otherlv_1= 'generate' ( (lv_num_2_0= ruleEInt ) )? otherlv_3= 'mutants' otherlv_4= 'in' ( (lv_output_5_0= ruleEString ) ) otherlv_6= 'from' ( (lv_source_7_0= ruleSource ) ) otherlv_8= 'metamodel' ( (lv_metamodel_9_0= ruleEString ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:384:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:385:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getProgramAccess().getProgramAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleProgram765); 

                	newLeafNode(otherlv_1, grammarAccess.getProgramAccess().getGenerateKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:394:1: ( (lv_num_2_0= ruleEInt ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_INT||LA8_0==33) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:395:1: (lv_num_2_0= ruleEInt )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:395:1: (lv_num_2_0= ruleEInt )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:396:3: lv_num_2_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getProgramAccess().getNumEIntParserRuleCall_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleProgram786);
                    lv_num_2_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getProgramRule());
                    	        }
                           		set(
                           			current, 
                           			"num",
                            		lv_num_2_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleProgram799); 

                	newLeafNode(otherlv_3, grammarAccess.getProgramAccess().getMutantsKeyword_3());
                
            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleProgram811); 

                	newLeafNode(otherlv_4, grammarAccess.getProgramAccess().getInKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:420:1: ( (lv_output_5_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:421:1: (lv_output_5_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:421:1: (lv_output_5_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:422:3: lv_output_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getOutputEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleProgram832);
            lv_output_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"output",
                    		lv_output_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleProgram844); 

                	newLeafNode(otherlv_6, grammarAccess.getProgramAccess().getFromKeyword_6());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:442:1: ( (lv_source_7_0= ruleSource ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:443:1: (lv_source_7_0= ruleSource )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:443:1: (lv_source_7_0= ruleSource )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:444:3: lv_source_7_0= ruleSource
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getSourceSourceParserRuleCall_7_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleSource_in_ruleProgram865);
            lv_source_7_0=ruleSource();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"source",
                    		lv_source_7_0, 
                    		"Source");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleProgram877); 

                	newLeafNode(otherlv_8, grammarAccess.getProgramAccess().getMetamodelKeyword_8());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:464:1: ( (lv_metamodel_9_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:465:1: (lv_metamodel_9_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:465:1: (lv_metamodel_9_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:466:3: lv_metamodel_9_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getProgramAccess().getMetamodelEStringParserRuleCall_9_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleProgram898);
            lv_metamodel_9_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getProgramRule());
            	        }
                   		set(
                   			current, 
                   			"metamodel",
                    		lv_metamodel_9_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleSource"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:490:1: entryRuleSource returns [EObject current=null] : iv_ruleSource= ruleSource EOF ;
    public final EObject entryRuleSource() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSource = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:491:2: (iv_ruleSource= ruleSource EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:492:2: iv_ruleSource= ruleSource EOF
            {
             newCompositeNode(grammarAccess.getSourceRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSource_in_entryRuleSource934);
            iv_ruleSource=ruleSource();

            state._fsp--;

             current =iv_ruleSource; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSource944); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSource"


    // $ANTLR start "ruleSource"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:499:1: ruleSource returns [EObject current=null] : ( () ( (lv_path_1_0= ruleEString ) ) ) ;
    public final EObject ruleSource() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_path_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:502:28: ( ( () ( (lv_path_1_0= ruleEString ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:503:1: ( () ( (lv_path_1_0= ruleEString ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:503:1: ( () ( (lv_path_1_0= ruleEString ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:503:2: () ( (lv_path_1_0= ruleEString ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:503:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:504:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSourceAccess().getSourceAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:509:2: ( (lv_path_1_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:510:1: (lv_path_1_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:510:1: (lv_path_1_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:511:3: lv_path_1_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getSourceAccess().getPathEStringParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleSource999);
            lv_path_1_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSourceRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_1_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSource"


    // $ANTLR start "entryRuleBlock"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:535:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:536:2: (iv_ruleBlock= ruleBlock EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:537:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBlock_in_entryRuleBlock1035);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBlock1045); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:544:1: ruleBlock returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'from' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? (otherlv_5= 'repeat' otherlv_6= '=' ( (lv_repeat_7_0= ruleRepeat ) ) )? otherlv_8= '{' ( (lv_commands_9_0= ruleMutator ) ) ( (lv_commands_10_0= ruleMutator ) )* otherlv_11= '}' (otherlv_12= '[' ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) ) otherlv_17= ']' )? ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_17=null;
        Enumerator lv_repeat_7_0 = null;

        EObject lv_commands_9_0 = null;

        EObject lv_commands_10_0 = null;

        AntlrDatatypeRuleToken lv_min_13_0 = null;

        AntlrDatatypeRuleToken lv_max_15_0 = null;

        AntlrDatatypeRuleToken lv_fixed_16_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:547:28: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'from' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? (otherlv_5= 'repeat' otherlv_6= '=' ( (lv_repeat_7_0= ruleRepeat ) ) )? otherlv_8= '{' ( (lv_commands_9_0= ruleMutator ) ) ( (lv_commands_10_0= ruleMutator ) )* otherlv_11= '}' (otherlv_12= '[' ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) ) otherlv_17= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:548:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'from' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? (otherlv_5= 'repeat' otherlv_6= '=' ( (lv_repeat_7_0= ruleRepeat ) ) )? otherlv_8= '{' ( (lv_commands_9_0= ruleMutator ) ) ( (lv_commands_10_0= ruleMutator ) )* otherlv_11= '}' (otherlv_12= '[' ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) ) otherlv_17= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:548:1: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'from' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? (otherlv_5= 'repeat' otherlv_6= '=' ( (lv_repeat_7_0= ruleRepeat ) ) )? otherlv_8= '{' ( (lv_commands_9_0= ruleMutator ) ) ( (lv_commands_10_0= ruleMutator ) )* otherlv_11= '}' (otherlv_12= '[' ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) ) otherlv_17= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:548:2: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'from' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )? (otherlv_5= 'repeat' otherlv_6= '=' ( (lv_repeat_7_0= ruleRepeat ) ) )? otherlv_8= '{' ( (lv_commands_9_0= ruleMutator ) ) ( (lv_commands_10_0= ruleMutator ) )* otherlv_11= '}' (otherlv_12= '[' ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) ) otherlv_17= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:548:2: ( (lv_name_0_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:549:1: (lv_name_0_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:549:1: (lv_name_0_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:550:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBlock1087); 

            			newLeafNode(lv_name_0_0, grammarAccess.getBlockAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getBlockRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:566:2: (otherlv_1= 'from' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )* )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:566:4: otherlv_1= 'from' ( (otherlv_2= RULE_ID ) ) (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    {
                    otherlv_1=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleBlock1105); 

                        	newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getFromKeyword_1_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:570:1: ( (otherlv_2= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:571:1: (otherlv_2= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:571:1: (otherlv_2= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:572:3: otherlv_2= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getBlockRule());
                    	        }
                            
                    otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBlock1125); 

                    		newLeafNode(otherlv_2, grammarAccess.getBlockAccess().getFromBlockCrossReference_1_1_0()); 
                    	

                    }


                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:583:2: (otherlv_3= ',' ( (otherlv_4= RULE_ID ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==24) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:583:4: otherlv_3= ',' ( (otherlv_4= RULE_ID ) )
                    	    {
                    	    otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleBlock1138); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getCommaKeyword_1_2_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:587:1: ( (otherlv_4= RULE_ID ) )
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:588:1: (otherlv_4= RULE_ID )
                    	    {
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:588:1: (otherlv_4= RULE_ID )
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:589:3: otherlv_4= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getBlockRule());
                    	    	        }
                    	            
                    	    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleBlock1158); 

                    	    		newLeafNode(otherlv_4, grammarAccess.getBlockAccess().getFromBlockCrossReference_1_2_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:600:6: (otherlv_5= 'repeat' otherlv_6= '=' ( (lv_repeat_7_0= ruleRepeat ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==25) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:600:8: otherlv_5= 'repeat' otherlv_6= '=' ( (lv_repeat_7_0= ruleRepeat ) )
                    {
                    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleBlock1175); 

                        	newLeafNode(otherlv_5, grammarAccess.getBlockAccess().getRepeatKeyword_2_0());
                        
                    otherlv_6=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleBlock1187); 

                        	newLeafNode(otherlv_6, grammarAccess.getBlockAccess().getEqualsSignKeyword_2_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:608:1: ( (lv_repeat_7_0= ruleRepeat ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:609:1: (lv_repeat_7_0= ruleRepeat )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:609:1: (lv_repeat_7_0= ruleRepeat )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:610:3: lv_repeat_7_0= ruleRepeat
                    {
                     
                    	        newCompositeNode(grammarAccess.getBlockAccess().getRepeatRepeatEnumRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleRepeat_in_ruleBlock1208);
                    lv_repeat_7_0=ruleRepeat();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getBlockRule());
                    	        }
                           		set(
                           			current, 
                           			"repeat",
                            		lv_repeat_7_0, 
                            		"Repeat");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleBlock1222); 

                	newLeafNode(otherlv_8, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:630:1: ( (lv_commands_9_0= ruleMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:631:1: (lv_commands_9_0= ruleMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:631:1: (lv_commands_9_0= ruleMutator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:632:3: lv_commands_9_0= ruleMutator
            {
             
            	        newCompositeNode(grammarAccess.getBlockAccess().getCommandsMutatorParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleBlock1243);
            lv_commands_9_0=ruleMutator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	        }
                   		add(
                   			current, 
                   			"commands",
                    		lv_commands_9_0, 
                    		"Mutator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:648:2: ( (lv_commands_10_0= ruleMutator ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_ID||LA12_0==27||LA12_0==42||LA12_0==46||LA12_0==49||LA12_0==53) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:649:1: (lv_commands_10_0= ruleMutator )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:649:1: (lv_commands_10_0= ruleMutator )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:650:3: lv_commands_10_0= ruleMutator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getBlockAccess().getCommandsMutatorParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleBlock1264);
            	    lv_commands_10_0=ruleMutator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getBlockRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_10_0, 
            	            		"Mutator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleBlock1277); 

                	newLeafNode(otherlv_11, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_6());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:670:1: (otherlv_12= '[' ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) ) otherlv_17= ']' )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:670:3: otherlv_12= '[' ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) ) otherlv_17= ']'
                    {
                    otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleBlock1290); 

                        	newLeafNode(otherlv_12, grammarAccess.getBlockAccess().getLeftSquareBracketKeyword_7_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:674:1: ( ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_16_0= ruleEInt ) ) )
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==33) ) {
                        int LA13_1 = input.LA(2);

                        if ( (LA13_1==RULE_INT) ) {
                            int LA13_2 = input.LA(3);

                            if ( (LA13_2==29) ) {
                                alt13=2;
                            }
                            else if ( (LA13_2==28) ) {
                                alt13=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 13, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA13_0==RULE_INT) ) {
                        int LA13_2 = input.LA(2);

                        if ( (LA13_2==29) ) {
                            alt13=2;
                        }
                        else if ( (LA13_2==28) ) {
                            alt13=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 13, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }
                    switch (alt13) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:674:2: ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:674:2: ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:674:3: ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' ( (lv_max_15_0= ruleMaxCardinality ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:674:3: ( (lv_min_13_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:675:1: (lv_min_13_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:675:1: (lv_min_13_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:676:3: lv_min_13_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getBlockAccess().getMinEIntParserRuleCall_7_1_0_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleBlock1313);
                            lv_min_13_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBlockRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_13_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleBlock1325); 

                                	newLeafNode(otherlv_14, grammarAccess.getBlockAccess().getFullStopFullStopKeyword_7_1_0_1());
                                
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:696:1: ( (lv_max_15_0= ruleMaxCardinality ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:697:1: (lv_max_15_0= ruleMaxCardinality )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:697:1: (lv_max_15_0= ruleMaxCardinality )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:698:3: lv_max_15_0= ruleMaxCardinality
                            {
                             
                            	        newCompositeNode(grammarAccess.getBlockAccess().getMaxMaxCardinalityParserRuleCall_7_1_0_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleBlock1346);
                            lv_max_15_0=ruleMaxCardinality();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBlockRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"max",
                                    		lv_max_15_0, 
                                    		"MaxCardinality");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:715:6: ( (lv_fixed_16_0= ruleEInt ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:715:6: ( (lv_fixed_16_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:716:1: (lv_fixed_16_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:716:1: (lv_fixed_16_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:717:3: lv_fixed_16_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getBlockAccess().getFixedEIntParserRuleCall_7_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleBlock1374);
                            lv_fixed_16_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getBlockRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"fixed",
                                    		lv_fixed_16_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_17=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleBlock1387); 

                        	newLeafNode(otherlv_17, grammarAccess.getBlockAccess().getRightSquareBracketKeyword_7_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleConstraint"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:745:1: entryRuleConstraint returns [EObject current=null] : iv_ruleConstraint= ruleConstraint EOF ;
    public final EObject entryRuleConstraint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraint = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:746:2: (iv_ruleConstraint= ruleConstraint EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:747:2: iv_ruleConstraint= ruleConstraint EOF
            {
             newCompositeNode(grammarAccess.getConstraintRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleConstraint_in_entryRuleConstraint1425);
            iv_ruleConstraint=ruleConstraint();

            state._fsp--;

             current =iv_ruleConstraint; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleConstraint1435); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstraint"


    // $ANTLR start "ruleConstraint"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:754:1: ruleConstraint returns [EObject current=null] : (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_rule_4_0= ruleEString ) ) ) ;
    public final EObject ruleConstraint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_id_2_0 = null;

        AntlrDatatypeRuleToken lv_rule_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:757:28: ( (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_rule_4_0= ruleEString ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:758:1: (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_rule_4_0= ruleEString ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:758:1: (otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_rule_4_0= ruleEString ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:758:3: otherlv_0= 'context' ( (otherlv_1= RULE_ID ) ) ( (lv_id_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_rule_4_0= ruleEString ) )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleConstraint1472); 

                	newLeafNode(otherlv_0, grammarAccess.getConstraintAccess().getContextKeyword_0());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:762:1: ( (otherlv_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:763:1: (otherlv_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:763:1: (otherlv_1= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:764:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstraintRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleConstraint1492); 

            		newLeafNode(otherlv_1, grammarAccess.getConstraintAccess().getTypeEClassCrossReference_1_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:775:2: ( (lv_id_2_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:776:1: (lv_id_2_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:776:1: (lv_id_2_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:777:3: lv_id_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getIdEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConstraint1513);
            lv_id_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintRule());
            	        }
                   		set(
                   			current, 
                   			"id",
                    		lv_id_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleConstraint1525); 

                	newLeafNode(otherlv_3, grammarAccess.getConstraintAccess().getColonKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:797:1: ( (lv_rule_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:798:1: (lv_rule_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:798:1: (lv_rule_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:799:3: lv_rule_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getConstraintAccess().getRuleEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleConstraint1546);
            lv_rule_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintRule());
            	        }
                   		set(
                   			current, 
                   			"rule",
                    		lv_rule_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstraint"


    // $ANTLR start "entryRuleMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:823:1: entryRuleMutator returns [EObject current=null] : iv_ruleMutator= ruleMutator EOF ;
    public final EObject entryRuleMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:824:2: (iv_ruleMutator= ruleMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:825:2: iv_ruleMutator= ruleMutator EOF
            {
             newCompositeNode(grammarAccess.getMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_entryRuleMutator1582);
            iv_ruleMutator=ruleMutator();

            state._fsp--;

             current =iv_ruleMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMutator1592); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMutator"


    // $ANTLR start "ruleMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:832:1: ruleMutator returns [EObject current=null] : (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator ) ;
    public final EObject ruleMutator() throws RecognitionException {
        EObject current = null;

        EObject this_CreateObjectMutator_0 = null;

        EObject this_SelectObjectMutator_1 = null;

        EObject this_SelectSampleMutator_2 = null;

        EObject this_CompositeMutator_3 = null;

        EObject this_ModifySourceReferenceMutator_4 = null;

        EObject this_ModifyTargetReferenceMutator_5 = null;

        EObject this_CreateReferenceMutator_6 = null;

        EObject this_RemoveObjectMutator_7 = null;

        EObject this_RemoveReferenceMutator_8 = null;

        EObject this_ModifyInformationMutator_9 = null;

        EObject this_CloneObjectMutator_10 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:835:28: ( (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator )
            int alt15=11;
            alt15 = dfa15.predict(input);
            switch (alt15) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:837:5: this_CreateObjectMutator_0= ruleCreateObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCreateObjectMutatorParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCreateObjectMutator_in_ruleMutator1639);
                    this_CreateObjectMutator_0=ruleCreateObjectMutator();

                    state._fsp--;

                     
                            current = this_CreateObjectMutator_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:847:5: this_SelectObjectMutator_1= ruleSelectObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getSelectObjectMutatorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSelectObjectMutator_in_ruleMutator1666);
                    this_SelectObjectMutator_1=ruleSelectObjectMutator();

                    state._fsp--;

                     
                            current = this_SelectObjectMutator_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:857:5: this_SelectSampleMutator_2= ruleSelectSampleMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getSelectSampleMutatorParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSelectSampleMutator_in_ruleMutator1693);
                    this_SelectSampleMutator_2=ruleSelectSampleMutator();

                    state._fsp--;

                     
                            current = this_SelectSampleMutator_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:867:5: this_CompositeMutator_3= ruleCompositeMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCompositeMutatorParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCompositeMutator_in_ruleMutator1720);
                    this_CompositeMutator_3=ruleCompositeMutator();

                    state._fsp--;

                     
                            current = this_CompositeMutator_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:877:5: this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifySourceReferenceMutatorParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifySourceReferenceMutator_in_ruleMutator1747);
                    this_ModifySourceReferenceMutator_4=ruleModifySourceReferenceMutator();

                    state._fsp--;

                     
                            current = this_ModifySourceReferenceMutator_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:887:5: this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifyTargetReferenceMutatorParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifyTargetReferenceMutator_in_ruleMutator1774);
                    this_ModifyTargetReferenceMutator_5=ruleModifyTargetReferenceMutator();

                    state._fsp--;

                     
                            current = this_ModifyTargetReferenceMutator_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:897:5: this_CreateReferenceMutator_6= ruleCreateReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCreateReferenceMutatorParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCreateReferenceMutator_in_ruleMutator1801);
                    this_CreateReferenceMutator_6=ruleCreateReferenceMutator();

                    state._fsp--;

                     
                            current = this_CreateReferenceMutator_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:907:5: this_RemoveObjectMutator_7= ruleRemoveObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getRemoveObjectMutatorParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveObjectMutator_in_ruleMutator1828);
                    this_RemoveObjectMutator_7=ruleRemoveObjectMutator();

                    state._fsp--;

                     
                            current = this_RemoveObjectMutator_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:917:5: this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getRemoveReferenceMutatorParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveReferenceMutator_in_ruleMutator1855);
                    this_RemoveReferenceMutator_8=ruleRemoveReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveReferenceMutator_8; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 10 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:927:5: this_ModifyInformationMutator_9= ruleModifyInformationMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifyInformationMutatorParserRuleCall_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifyInformationMutator_in_ruleMutator1882);
                    this_ModifyInformationMutator_9=ruleModifyInformationMutator();

                    state._fsp--;

                     
                            current = this_ModifyInformationMutator_9; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 11 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:937:5: this_CloneObjectMutator_10= ruleCloneObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCloneObjectMutatorParserRuleCall_10()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCloneObjectMutator_in_ruleMutator1909);
                    this_CloneObjectMutator_10=ruleCloneObjectMutator();

                    state._fsp--;

                     
                            current = this_CloneObjectMutator_10; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMutator"


    // $ANTLR start "entryRuleObSelectionStrategy"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:953:1: entryRuleObSelectionStrategy returns [EObject current=null] : iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF ;
    public final EObject entryRuleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObSelectionStrategy = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:954:2: (iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:955:2: iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF
            {
             newCompositeNode(grammarAccess.getObSelectionStrategyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1944);
            iv_ruleObSelectionStrategy=ruleObSelectionStrategy();

            state._fsp--;

             current =iv_ruleObSelectionStrategy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObSelectionStrategy1954); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObSelectionStrategy"


    // $ANTLR start "ruleObSelectionStrategy"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:962:1: ruleObSelectionStrategy returns [EObject current=null] : (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection ) ;
    public final EObject ruleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject this_RandomSelection_0 = null;

        EObject this_SpecificSelection_1 = null;

        EObject this_CompleteSelection_2 = null;

        EObject this_OtherSelection_3 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:965:28: ( (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:966:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:966:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
            case 64:
                {
                alt16=2;
                }
                break;
            case 45:
                {
                alt16=3;
                }
                break;
            case 65:
                {
                alt16=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:967:5: this_RandomSelection_0= ruleRandomSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getRandomSelectionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy2001);
                    this_RandomSelection_0=ruleRandomSelection();

                    state._fsp--;

                     
                            current = this_RandomSelection_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:977:5: this_SpecificSelection_1= ruleSpecificSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getSpecificSelectionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy2028);
                    this_SpecificSelection_1=ruleSpecificSelection();

                    state._fsp--;

                     
                            current = this_SpecificSelection_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:987:5: this_CompleteSelection_2= ruleCompleteSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getCompleteSelectionParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy2055);
                    this_CompleteSelection_2=ruleCompleteSelection();

                    state._fsp--;

                     
                            current = this_CompleteSelection_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:997:5: this_OtherSelection_3= ruleOtherSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getOtherSelectionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy2082);
                    this_OtherSelection_3=ruleOtherSelection();

                    state._fsp--;

                     
                            current = this_OtherSelection_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObSelectionStrategy"


    // $ANTLR start "entryRuleRandomSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1013:1: entryRuleRandomSelection returns [EObject current=null] : iv_ruleRandomSelection= ruleRandomSelection EOF ;
    public final EObject entryRuleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1014:2: (iv_ruleRandomSelection= ruleRandomSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1015:2: iv_ruleRandomSelection= ruleRandomSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomSelection_in_entryRuleRandomSelection2117);
            iv_ruleRandomSelection=ruleRandomSelection();

            state._fsp--;

             current =iv_ruleRandomSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomSelection2127); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomSelection"


    // $ANTLR start "ruleRandomSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1022:1: ruleRandomSelection returns [EObject current=null] : this_RandomTypeSelection_0= ruleRandomTypeSelection ;
    public final EObject ruleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject this_RandomTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1025:28: (this_RandomTypeSelection_0= ruleRandomTypeSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1027:5: this_RandomTypeSelection_0= ruleRandomTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getRandomSelectionAccess().getRandomTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRandomTypeSelection_in_ruleRandomSelection2173);
            this_RandomTypeSelection_0=ruleRandomTypeSelection();

            state._fsp--;

             
                    current = this_RandomTypeSelection_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomSelection"


    // $ANTLR start "entryRuleSpecificSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1043:1: entryRuleSpecificSelection returns [EObject current=null] : iv_ruleSpecificSelection= ruleSpecificSelection EOF ;
    public final EObject entryRuleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1044:2: (iv_ruleSpecificSelection= ruleSpecificSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1045:2: iv_ruleSpecificSelection= ruleSpecificSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificSelection_in_entryRuleSpecificSelection2207);
            iv_ruleSpecificSelection=ruleSpecificSelection();

            state._fsp--;

             current =iv_ruleSpecificSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificSelection2217); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificSelection"


    // $ANTLR start "ruleSpecificSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1052:1: ruleSpecificSelection returns [EObject current=null] : (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection ) ;
    public final EObject ruleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificObjectSelection_0 = null;

        EObject this_SpecificClosureSelection_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1055:28: ( (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1056:1: (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1056:1: (this_SpecificObjectSelection_0= ruleSpecificObjectSelection | this_SpecificClosureSelection_1= ruleSpecificClosureSelection )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ID) ) {
                alt17=1;
            }
            else if ( (LA17_0==64) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1057:5: this_SpecificObjectSelection_0= ruleSpecificObjectSelection
                    {
                     
                            newCompositeNode(grammarAccess.getSpecificSelectionAccess().getSpecificObjectSelectionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificObjectSelection_in_ruleSpecificSelection2264);
                    this_SpecificObjectSelection_0=ruleSpecificObjectSelection();

                    state._fsp--;

                     
                            current = this_SpecificObjectSelection_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1067:5: this_SpecificClosureSelection_1= ruleSpecificClosureSelection
                    {
                     
                            newCompositeNode(grammarAccess.getSpecificSelectionAccess().getSpecificClosureSelectionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificClosureSelection_in_ruleSpecificSelection2291);
                    this_SpecificClosureSelection_1=ruleSpecificClosureSelection();

                    state._fsp--;

                     
                            current = this_SpecificClosureSelection_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificSelection"


    // $ANTLR start "entryRuleCompleteSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1083:1: entryRuleCompleteSelection returns [EObject current=null] : iv_ruleCompleteSelection= ruleCompleteSelection EOF ;
    public final EObject entryRuleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1084:2: (iv_ruleCompleteSelection= ruleCompleteSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1085:2: iv_ruleCompleteSelection= ruleCompleteSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompleteSelection_in_entryRuleCompleteSelection2326);
            iv_ruleCompleteSelection=ruleCompleteSelection();

            state._fsp--;

             current =iv_ruleCompleteSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompleteSelection2336); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompleteSelection"


    // $ANTLR start "ruleCompleteSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1092:1: ruleCompleteSelection returns [EObject current=null] : this_CompleteTypeSelection_0= ruleCompleteTypeSelection ;
    public final EObject ruleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject this_CompleteTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1095:28: (this_CompleteTypeSelection_0= ruleCompleteTypeSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1097:5: this_CompleteTypeSelection_0= ruleCompleteTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getCompleteSelectionAccess().getCompleteTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCompleteTypeSelection_in_ruleCompleteSelection2382);
            this_CompleteTypeSelection_0=ruleCompleteTypeSelection();

            state._fsp--;

             
                    current = this_CompleteTypeSelection_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompleteSelection"


    // $ANTLR start "entryRuleOtherSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1113:1: entryRuleOtherSelection returns [EObject current=null] : iv_ruleOtherSelection= ruleOtherSelection EOF ;
    public final EObject entryRuleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1114:2: (iv_ruleOtherSelection= ruleOtherSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1115:2: iv_ruleOtherSelection= ruleOtherSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOtherSelection_in_entryRuleOtherSelection2416);
            iv_ruleOtherSelection=ruleOtherSelection();

            state._fsp--;

             current =iv_ruleOtherSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOtherSelection2426); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherSelection"


    // $ANTLR start "ruleOtherSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1122:1: ruleOtherSelection returns [EObject current=null] : this_OtherTypeSelection_0= ruleOtherTypeSelection ;
    public final EObject ruleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject this_OtherTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1125:28: (this_OtherTypeSelection_0= ruleOtherTypeSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1127:5: this_OtherTypeSelection_0= ruleOtherTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getOtherSelectionAccess().getOtherTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleOtherTypeSelection_in_ruleOtherSelection2472);
            this_OtherTypeSelection_0=ruleOtherTypeSelection();

            state._fsp--;

             
                    current = this_OtherTypeSelection_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherSelection"


    // $ANTLR start "entryRuleAttributeEvaluationType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1143:1: entryRuleAttributeEvaluationType returns [EObject current=null] : iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF ;
    public final EObject entryRuleAttributeEvaluationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluationType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1144:2: (iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1145:2: iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluationType_in_entryRuleAttributeEvaluationType2506);
            iv_ruleAttributeEvaluationType=ruleAttributeEvaluationType();

            state._fsp--;

             current =iv_ruleAttributeEvaluationType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeEvaluationType2516); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeEvaluationType"


    // $ANTLR start "ruleAttributeEvaluationType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1152:1: ruleAttributeEvaluationType returns [EObject current=null] : (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType ) ;
    public final EObject ruleAttributeEvaluationType() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeType_0 = null;

        EObject this_ObjectAttributeType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1155:28: ( (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1156:1: (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1156:1: (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType )
            int alt18=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA18_1 = input.LA(2);

                if ( ((LA18_1>=RULE_STRING && LA18_1<=RULE_INT)||LA18_1==13||LA18_1==27||(LA18_1>=33 && LA18_1<=34)||(LA18_1>=37 && LA18_1<=38)||(LA18_1>=66 && LA18_1<=77)) ) {
                    alt18=1;
                }
                else if ( (LA18_1==RULE_ID) ) {
                    alt18=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==RULE_ID) ) {
                    alt18=2;
                }
                else if ( ((LA18_2>=RULE_STRING && LA18_2<=RULE_INT)||LA18_2==13||LA18_2==27||(LA18_2>=33 && LA18_2<=34)||(LA18_2>=37 && LA18_2<=38)||(LA18_2>=66 && LA18_2<=77)) ) {
                    alt18=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA18_3 = input.LA(2);

                if ( ((LA18_3>=RULE_STRING && LA18_3<=RULE_INT)||LA18_3==13||LA18_3==27||(LA18_3>=33 && LA18_3<=34)||(LA18_3>=37 && LA18_3<=38)||(LA18_3>=66 && LA18_3<=77)) ) {
                    alt18=1;
                }
                else if ( (LA18_3==RULE_ID) ) {
                    alt18=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1157:5: this_AttributeType_0= ruleAttributeType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeEvaluationTypeAccess().getAttributeTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeEvaluationType2563);
                    this_AttributeType_0=ruleAttributeType();

                    state._fsp--;

                     
                            current = this_AttributeType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1167:5: this_ObjectAttributeType_1= ruleObjectAttributeType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeEvaluationTypeAccess().getObjectAttributeTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleObjectAttributeType_in_ruleAttributeEvaluationType2590);
                    this_ObjectAttributeType_1=ruleObjectAttributeType();

                    state._fsp--;

                     
                            current = this_ObjectAttributeType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeEvaluationType"


    // $ANTLR start "entryRuleAttributeType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1183:1: entryRuleAttributeType returns [EObject current=null] : iv_ruleAttributeType= ruleAttributeType EOF ;
    public final EObject entryRuleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1184:2: (iv_ruleAttributeType= ruleAttributeType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1185:2: iv_ruleAttributeType= ruleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_entryRuleAttributeType2625);
            iv_ruleAttributeType=ruleAttributeType();

            state._fsp--;

             current =iv_ruleAttributeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeType2635); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeType"


    // $ANTLR start "ruleAttributeType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1192:1: ruleAttributeType returns [EObject current=null] : (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType ) ;
    public final EObject ruleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject this_NumberType_0 = null;

        EObject this_BooleanType_1 = null;

        EObject this_StringType_2 = null;

        EObject this_ListStringType_3 = null;

        EObject this_RandomType_4 = null;

        EObject this_ListType_5 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1195:28: ( (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1196:1: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1196:1: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )
            int alt19=6;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1197:5: this_NumberType_0= ruleNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getNumberTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNumberType_in_ruleAttributeType2682);
                    this_NumberType_0=ruleNumberType();

                    state._fsp--;

                     
                            current = this_NumberType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1207:5: this_BooleanType_1= ruleBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_ruleAttributeType2709);
                    this_BooleanType_1=ruleBooleanType();

                    state._fsp--;

                     
                            current = this_BooleanType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1217:5: this_StringType_2= ruleStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringType_in_ruleAttributeType2736);
                    this_StringType_2=ruleStringType();

                    state._fsp--;

                     
                            current = this_StringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1227:5: this_ListStringType_3= ruleListStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getListStringTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_ruleAttributeType2763);
                    this_ListStringType_3=ruleListStringType();

                    state._fsp--;

                     
                            current = this_ListStringType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1237:5: this_RandomType_4= ruleRandomType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getRandomTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomType_in_ruleAttributeType2790);
                    this_RandomType_4=ruleRandomType();

                    state._fsp--;

                     
                            current = this_RandomType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1247:5: this_ListType_5= ruleListType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getListTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListType_in_ruleAttributeType2817);
                    this_ListType_5=ruleListType();

                    state._fsp--;

                     
                            current = this_ListType_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeType"


    // $ANTLR start "entryRuleNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1263:1: entryRuleNumberType returns [EObject current=null] : iv_ruleNumberType= ruleNumberType EOF ;
    public final EObject entryRuleNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1264:2: (iv_ruleNumberType= ruleNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1265:2: iv_ruleNumberType= ruleNumberType EOF
            {
             newCompositeNode(grammarAccess.getNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumberType_in_entryRuleNumberType2852);
            iv_ruleNumberType=ruleNumberType();

            state._fsp--;

             current =iv_ruleNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberType2862); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberType"


    // $ANTLR start "ruleNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1272:1: ruleNumberType returns [EObject current=null] : (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType ) ;
    public final EObject ruleNumberType() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerType_0 = null;

        EObject this_DoubleType_1 = null;

        EObject this_MinValueType_2 = null;

        EObject this_MaxValueType_3 = null;

        EObject this_RandomNumberType_4 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1275:28: ( (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1276:1: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1276:1: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1277:5: this_IntegerType_0= ruleIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_ruleNumberType2909);
                    this_IntegerType_0=ruleIntegerType();

                    state._fsp--;

                     
                            current = this_IntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1287:5: this_DoubleType_1= ruleDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getDoubleTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_ruleNumberType2936);
                    this_DoubleType_1=ruleDoubleType();

                    state._fsp--;

                     
                            current = this_DoubleType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1297:5: this_MinValueType_2= ruleMinValueType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getMinValueTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMinValueType_in_ruleNumberType2963);
                    this_MinValueType_2=ruleMinValueType();

                    state._fsp--;

                     
                            current = this_MinValueType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1307:5: this_MaxValueType_3= ruleMaxValueType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getMaxValueTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMaxValueType_in_ruleNumberType2990);
                    this_MaxValueType_3=ruleMaxValueType();

                    state._fsp--;

                     
                            current = this_MaxValueType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1317:5: this_RandomNumberType_4= ruleRandomNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getRandomNumberTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomNumberType_in_ruleNumberType3017);
                    this_RandomNumberType_4=ruleRandomNumberType();

                    state._fsp--;

                     
                            current = this_RandomNumberType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberType"


    // $ANTLR start "entryRuleRandomNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1333:1: entryRuleRandomNumberType returns [EObject current=null] : iv_ruleRandomNumberType= ruleRandomNumberType EOF ;
    public final EObject entryRuleRandomNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1334:2: (iv_ruleRandomNumberType= ruleRandomNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1335:2: iv_ruleRandomNumberType= ruleRandomNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomNumberType_in_entryRuleRandomNumberType3052);
            iv_ruleRandomNumberType=ruleRandomNumberType();

            state._fsp--;

             current =iv_ruleRandomNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomNumberType3062); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomNumberType"


    // $ANTLR start "ruleRandomNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1342:1: ruleRandomNumberType returns [EObject current=null] : (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType ) ;
    public final EObject ruleRandomNumberType() throws RecognitionException {
        EObject current = null;

        EObject this_RandomDoubleNumberType_0 = null;

        EObject this_RandomIntegerNumberType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1345:28: ( (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1346:1: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1346:1: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1347:5: this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getRandomNumberTypeAccess().getRandomDoubleNumberTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleNumberType_in_ruleRandomNumberType3109);
                    this_RandomDoubleNumberType_0=ruleRandomDoubleNumberType();

                    state._fsp--;

                     
                            current = this_RandomDoubleNumberType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1357:5: this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getRandomNumberTypeAccess().getRandomIntegerNumberTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerNumberType_in_ruleRandomNumberType3136);
                    this_RandomIntegerNumberType_1=ruleRandomIntegerNumberType();

                    state._fsp--;

                     
                            current = this_RandomIntegerNumberType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomNumberType"


    // $ANTLR start "entryRuleLoad"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1373:1: entryRuleLoad returns [EObject current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final EObject entryRuleLoad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoad = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1374:2: (iv_ruleLoad= ruleLoad EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1375:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoad_in_entryRuleLoad3171);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoad3181); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLoad"


    // $ANTLR start "ruleLoad"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1382:1: ruleLoad returns [EObject current=null] : ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) ;
    public final EObject ruleLoad() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_file_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1385:28: ( ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1386:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1386:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1386:2: () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1386:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1387:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLoadAccess().getLoadAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLoad3227); 

                	newLeafNode(otherlv_1, grammarAccess.getLoadAccess().getImportKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1396:1: ( (lv_file_2_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1397:1: (lv_file_2_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1397:1: (lv_file_2_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1398:3: lv_file_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getLoadAccess().getFileEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLoad3248);
            lv_file_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLoadRule());
            	        }
                   		set(
                   			current, 
                   			"file",
                    		lv_file_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLoad"


    // $ANTLR start "entryRuleEString"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1422:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1423:2: (iv_ruleEString= ruleEString EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1424:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString3285);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString3296); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1431:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1434:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1435:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1435:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_STRING) ) {
                alt22=1;
            }
            else if ( (LA22_0==RULE_ID) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1435:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString3336); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1443:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString3362); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEInt"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1458:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1459:2: (iv_ruleEInt= ruleEInt EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1460:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt3408);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt3419); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1467:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1470:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1471:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1471:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1471:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1471:2: (kw= '-' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1472:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEInt3458); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt3475); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEDouble"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1492:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1493:2: (iv_ruleEDouble= ruleEDouble EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1494:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble3521);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble3532); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEDouble"


    // $ANTLR start "ruleEDouble"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1501:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1504:28: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1505:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1505:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1505:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1505:2: (kw= '-' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1506:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEDouble3571); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1511:3: (this_INT_1= RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1511:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3589); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEDouble3609); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3624); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1531:1: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=35 && LA28_0<=36)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1531:2: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1531:2: (kw= 'E' | kw= 'e' )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==35) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==36) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1532:2: kw= 'E'
                            {
                            kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEDouble3644); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1539:2: kw= 'e'
                            {
                            kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEDouble3663); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1544:2: (kw= '-' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==33) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1545:2: kw= '-'
                            {
                            kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEDouble3678); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
                                

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3695); 

                    		current.merge(this_INT_7);
                        
                     
                        newLeafNode(this_INT_7, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_4_2()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEDouble"


    // $ANTLR start "entryRuleEBoolean"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1565:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1566:2: (iv_ruleEBoolean= ruleEBoolean EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1567:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_entryRuleEBoolean3743);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEBoolean3754); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1574:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1577:28: ( (kw= 'true' | kw= 'false' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1578:1: (kw= 'true' | kw= 'false' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1578:1: (kw= 'true' | kw= 'false' )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==37) ) {
                alt29=1;
            }
            else if ( (LA29_0==38) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1579:2: kw= 'true'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEBoolean3792); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1586:2: kw= 'false'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEBoolean3811); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleBinaryOperator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1599:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1600:2: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1601:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator3851);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperator3861); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinaryOperator"


    // $ANTLR start "ruleBinaryOperator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1608:1: ruleBinaryOperator returns [EObject current=null] : ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1611:28: ( ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1612:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1612:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1612:2: () ( (lv_type_1_0= ruleLogicOperator ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1612:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1613:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1618:2: ( (lv_type_1_0= ruleLogicOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1619:1: (lv_type_1_0= ruleLogicOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1619:1: (lv_type_1_0= ruleLogicOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1620:3: lv_type_1_0= ruleLogicOperator
            {
             
            	        newCompositeNode(grammarAccess.getBinaryOperatorAccess().getTypeLogicOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLogicOperator_in_ruleBinaryOperator3916);
            lv_type_1_0=ruleLogicOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getBinaryOperatorRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"LogicOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOperator"


    // $ANTLR start "entryRuleAttributeEvaluation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1644:1: entryRuleAttributeEvaluation returns [EObject current=null] : iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF ;
    public final EObject entryRuleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1645:2: (iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1646:2: iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation3952);
            iv_ruleAttributeEvaluation=ruleAttributeEvaluation();

            state._fsp--;

             current =iv_ruleAttributeEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeEvaluation3962); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeEvaluation"


    // $ANTLR start "ruleAttributeEvaluation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1653:1: ruleAttributeEvaluation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) ;
    public final EObject ruleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1656:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1657:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1657:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1657:2: () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1657:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1658:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttributeEvaluationAccess().getAttributeEvaluationAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1663:2: ( (otherlv_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1664:1: (otherlv_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1664:1: (otherlv_1= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1665:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeEvaluationRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeEvaluation4016); 

            		newLeafNode(otherlv_1, grammarAccess.getAttributeEvaluationAccess().getNameEAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1676:2: ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1677:1: (lv_value_2_0= ruleAttributeEvaluationType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1677:1: (lv_value_2_0= ruleAttributeEvaluationType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1678:3: lv_value_2_0= ruleAttributeEvaluationType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeEvaluationAccess().getValueAttributeEvaluationTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeEvaluation4037);
            lv_value_2_0=ruleAttributeEvaluationType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"AttributeEvaluationType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeEvaluation"


    // $ANTLR start "entryRuleReferenceEvaluation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1702:1: entryRuleReferenceEvaluation returns [EObject current=null] : iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF ;
    public final EObject entryRuleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1703:2: (iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1704:2: iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF
            {
             newCompositeNode(grammarAccess.getReferenceEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation4073);
            iv_ruleReferenceEvaluation=ruleReferenceEvaluation();

            state._fsp--;

             current =iv_ruleReferenceEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceEvaluation4083); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceEvaluation"


    // $ANTLR start "ruleReferenceEvaluation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1711:1: ruleReferenceEvaluation returns [EObject current=null] : ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) ) ;
    public final EObject ruleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Enumerator lv_operator_5_0 = null;

        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1714:28: ( ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1715:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1715:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1715:2: () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1715:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1716:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReferenceEvaluationAccess().getReferenceEvaluationAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1721:2: ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            else if ( (LA30_0==39) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1721:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1721:3: ( (otherlv_1= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1722:1: (otherlv_1= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1722:1: (otherlv_1= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1723:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation4138); 

                    		newLeafNode(otherlv_1, grammarAccess.getReferenceEvaluationAccess().getNameEReferenceCrossReference_1_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1735:7: otherlv_2= 'self'
                    {
                    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleReferenceEvaluation4156); 

                        	newLeafNode(otherlv_2, grammarAccess.getReferenceEvaluationAccess().getSelfKeyword_1_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1739:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==40) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1739:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleReferenceEvaluation4170); 

                        	newLeafNode(otherlv_3, grammarAccess.getReferenceEvaluationAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1743:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1744:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1744:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1745:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation4190); 

                    		newLeafNode(otherlv_4, grammarAccess.getReferenceEvaluationAccess().getRefNameEReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1756:4: ( (lv_operator_5_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1757:1: (lv_operator_5_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1757:1: (lv_operator_5_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1758:3: lv_operator_5_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getOperatorOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleReferenceEvaluation4213);
            lv_operator_5_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_5_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1774:2: ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID||LA32_0==43||LA32_0==45||(LA32_0>=64 && LA32_0<=65)) ) {
                alt32=1;
            }
            else if ( (LA32_0==41) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1774:3: ( (lv_value_6_0= ruleObSelectionStrategy ) )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1774:3: ( (lv_value_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1775:1: (lv_value_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1775:1: (lv_value_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1776:3: lv_value_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getValueObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation4235);
                    lv_value_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1793:7: otherlv_7= 'null'
                    {
                    otherlv_7=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleReferenceEvaluation4253); 

                        	newLeafNode(otherlv_7, grammarAccess.getReferenceEvaluationAccess().getNullKeyword_4_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceEvaluation"


    // $ANTLR start "entryRuleEvaluation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1805:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1806:2: (iv_ruleEvaluation= ruleEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1807:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_entryRuleEvaluation4290);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEvaluation4300); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1814:1: ruleEvaluation returns [EObject current=null] : (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeEvaluation_0 = null;

        EObject this_ReferenceEvaluation_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1817:28: ( (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1818:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1818:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 40:
                    {
                    alt33=2;
                    }
                    break;
                case 26:
                    {
                    switch ( input.LA(3) ) {
                    case RULE_STRING:
                    case RULE_INT:
                    case 13:
                    case 27:
                    case 33:
                    case 34:
                    case 37:
                    case 38:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        {
                        alt33=1;
                        }
                        break;
                    case 41:
                    case 43:
                    case 45:
                    case 64:
                    case 65:
                        {
                        alt33=2;
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA33_7 = input.LA(4);

                        if ( (LA33_7==34) ) {
                            alt33=1;
                        }
                        else if ( (LA33_7==EOF||LA33_7==14||LA33_7==40||LA33_7==63||(LA33_7>=79 && LA33_7<=80)) ) {
                            alt33=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 33, 7, input);

                            throw nvae;
                        }
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                case 81:
                    {
                    switch ( input.LA(3) ) {
                    case RULE_STRING:
                    case RULE_INT:
                    case 13:
                    case 27:
                    case 33:
                    case 34:
                    case 37:
                    case 38:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        {
                        alt33=1;
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA33_7 = input.LA(4);

                        if ( (LA33_7==34) ) {
                            alt33=1;
                        }
                        else if ( (LA33_7==EOF||LA33_7==14||LA33_7==40||LA33_7==63||(LA33_7>=79 && LA33_7<=80)) ) {
                            alt33=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 33, 7, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 41:
                    case 43:
                    case 45:
                    case 64:
                    case 65:
                        {
                        alt33=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 4, input);

                        throw nvae;
                    }

                    }
                    break;
                case 22:
                    {
                    switch ( input.LA(3) ) {
                    case RULE_STRING:
                    case RULE_INT:
                    case 13:
                    case 27:
                    case 33:
                    case 34:
                    case 37:
                    case 38:
                    case 66:
                    case 67:
                    case 68:
                    case 69:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        {
                        alt33=1;
                        }
                        break;
                    case RULE_ID:
                        {
                        int LA33_7 = input.LA(4);

                        if ( (LA33_7==34) ) {
                            alt33=1;
                        }
                        else if ( (LA33_7==EOF||LA33_7==14||LA33_7==40||LA33_7==63||(LA33_7>=79 && LA33_7<=80)) ) {
                            alt33=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 33, 7, input);

                            throw nvae;
                        }
                        }
                        break;
                    case 41:
                    case 43:
                    case 45:
                    case 64:
                    case 65:
                        {
                        alt33=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 5, input);

                        throw nvae;
                    }

                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA33_0==39) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1819:5: this_AttributeEvaluation_0= ruleAttributeEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getAttributeEvaluationParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation4347);
                    this_AttributeEvaluation_0=ruleAttributeEvaluation();

                    state._fsp--;

                     
                            current = this_AttributeEvaluation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1829:5: this_ReferenceEvaluation_1= ruleReferenceEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getReferenceEvaluationParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation4374);
                    this_ReferenceEvaluation_1=ruleReferenceEvaluation();

                    state._fsp--;

                     
                            current = this_ReferenceEvaluation_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleExpression"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1845:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1846:2: (iv_ruleExpression= ruleExpression EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1847:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression4409);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression4419); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1854:1: ruleExpression returns [EObject current=null] : ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_operator_2_0 = null;

        EObject lv_second_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1857:28: ( ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1858:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1858:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1858:2: () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1858:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1859:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getExpressionAccess().getExpressionAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1864:2: ( (lv_first_1_0= ruleEvaluation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1865:1: (lv_first_1_0= ruleEvaluation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1865:1: (lv_first_1_0= ruleEvaluation )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1866:3: lv_first_1_0= ruleEvaluation
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getFirstEvaluationParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression4474);
            lv_first_1_0=ruleEvaluation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	        }
                   		set(
                   			current, 
                   			"first",
                    		lv_first_1_0, 
                    		"Evaluation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1882:2: ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=79 && LA34_0<=80)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1882:3: ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1882:3: ( (lv_operator_2_0= ruleBinaryOperator ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1883:1: (lv_operator_2_0= ruleBinaryOperator )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1883:1: (lv_operator_2_0= ruleBinaryOperator )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1884:3: lv_operator_2_0= ruleBinaryOperator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getOperatorBinaryOperatorParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_ruleExpression4496);
            	    lv_operator_2_0=ruleBinaryOperator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"operator",
            	            		lv_operator_2_0, 
            	            		"BinaryOperator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1900:2: ( (lv_second_3_0= ruleEvaluation ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1901:1: (lv_second_3_0= ruleEvaluation )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1901:1: (lv_second_3_0= ruleEvaluation )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1902:3: lv_second_3_0= ruleEvaluation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getSecondEvaluationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression4517);
            	    lv_second_3_0=ruleEvaluation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getExpressionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"second",
            	            		lv_second_3_0, 
            	            		"Evaluation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleRemoveObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1926:1: entryRuleRemoveObjectMutator returns [EObject current=null] : iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF ;
    public final EObject entryRuleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1927:2: (iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1928:2: iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator4555);
            iv_ruleRemoveObjectMutator=ruleRemoveObjectMutator();

            state._fsp--;

             current =iv_ruleRemoveObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveObjectMutator4565); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveObjectMutator"


    // $ANTLR start "ruleRemoveObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1935:1: ruleRemoveObjectMutator returns [EObject current=null] : ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? ) ;
    public final EObject ruleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_object_2_0 = null;

        EObject lv_container_4_0 = null;

        AntlrDatatypeRuleToken lv_min_6_0 = null;

        AntlrDatatypeRuleToken lv_max_8_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1938:28: ( ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1939:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1939:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1939:2: () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1939:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1940:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveObjectMutatorAccess().getRemoveObjectMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveObjectMutator4611); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveObjectMutatorAccess().getRemoveKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1949:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1950:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1950:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1951:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4632);
            lv_object_2_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_2_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1967:2: (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==23) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1967:4: otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRemoveObjectMutator4645); 

                        	newLeafNode(otherlv_3, grammarAccess.getRemoveObjectMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1971:1: ( (lv_container_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1972:1: (lv_container_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1972:1: (lv_container_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1973:3: lv_container_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4666);
                    lv_container_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"container",
                            		lv_container_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1989:4: (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==27) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==RULE_INT||LA37_1==33||LA37_1==78) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1989:6: otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']'
                    {
                    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveObjectMutator4681); 

                        	newLeafNode(otherlv_5, grammarAccess.getRemoveObjectMutatorAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1993:1: ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( (LA36_0==33) ) {
                        int LA36_1 = input.LA(2);

                        if ( (LA36_1==RULE_INT) ) {
                            int LA36_2 = input.LA(3);

                            if ( (LA36_2==28) ) {
                                alt36=1;
                            }
                        }
                    }
                    else if ( (LA36_0==RULE_INT) ) {
                        int LA36_2 = input.LA(2);

                        if ( (LA36_2==28) ) {
                            alt36=1;
                        }
                    }
                    switch (alt36) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1993:2: ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1993:2: ( (lv_min_6_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1994:1: (lv_min_6_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1994:1: (lv_min_6_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1995:3: lv_min_6_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMinEIntParserRuleCall_4_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveObjectMutator4703);
                            lv_min_6_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_6_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveObjectMutator4715); 

                                	newLeafNode(otherlv_7, grammarAccess.getRemoveObjectMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2015:3: ( (lv_max_8_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2016:1: (lv_max_8_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2016:1: (lv_max_8_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2017:3: lv_max_8_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator4738);
                    lv_max_8_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_8_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveObjectMutator4750); 

                        	newLeafNode(otherlv_9, grammarAccess.getRemoveObjectMutatorAccess().getRightSquareBracketKeyword_4_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveObjectMutator"


    // $ANTLR start "entryRuleRemoveReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2045:1: entryRuleRemoveReferenceMutator returns [EObject current=null] : iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF ;
    public final EObject entryRuleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2046:2: (iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2047:2: iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator4788);
            iv_ruleRemoveReferenceMutator=ruleRemoveReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveReferenceMutator4798); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveReferenceMutator"


    // $ANTLR start "ruleRemoveReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2054:1: ruleRemoveReferenceMutator returns [EObject current=null] : (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) ;
    public final EObject ruleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject this_RemoveRandomReferenceMutator_0 = null;

        EObject this_RemoveSpecificReferenceMutator_1 = null;

        EObject this_RemoveCompleteReferenceMutator_2 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2057:28: ( (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2058:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2058:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            int alt38=3;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==42) ) {
                switch ( input.LA(2) ) {
                case 43:
                    {
                    alt38=1;
                    }
                    break;
                case 45:
                    {
                    alt38=3;
                    }
                    break;
                case 44:
                    {
                    alt38=2;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2059:5: this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveRandomReferenceMutatorParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator4845);
                    this_RemoveRandomReferenceMutator_0=ruleRemoveRandomReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveRandomReferenceMutator_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2069:5: this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveSpecificReferenceMutatorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator4872);
                    this_RemoveSpecificReferenceMutator_1=ruleRemoveSpecificReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveSpecificReferenceMutator_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2079:5: this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveCompleteReferenceMutatorParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator4899);
                    this_RemoveCompleteReferenceMutator_2=ruleRemoveCompleteReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveCompleteReferenceMutator_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveReferenceMutator"


    // $ANTLR start "entryRuleRemoveRandomReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2095:1: entryRuleRemoveRandomReferenceMutator returns [EObject current=null] : iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF ;
    public final EObject entryRuleRemoveRandomReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveRandomReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2096:2: (iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2097:2: iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator4934);
            iv_ruleRemoveRandomReferenceMutator=ruleRemoveRandomReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveRandomReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator4944); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveRandomReferenceMutator"


    // $ANTLR start "ruleRemoveRandomReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2104:1: ruleRemoveRandomReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
    public final EObject ruleRemoveRandomReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_min_8_0 = null;

        AntlrDatatypeRuleToken lv_max_10_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2107:28: ( ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2108:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2108:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2108:2: () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2108:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2109:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveRandomReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveRandomReferenceMutator4990); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRemoveRandomReferenceMutator5002); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveRandomReferenceMutatorAccess().getOneKeyword_2());
                
            otherlv_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRemoveRandomReferenceMutator5014); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveRandomReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2126:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2127:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2127:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2128:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5034); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveRandomReferenceMutator5046); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveRandomReferenceMutatorAccess().getInKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2143:1: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2144:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2144:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2145:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5066); 

            		newLeafNode(otherlv_6, grammarAccess.getRemoveRandomReferenceMutatorAccess().getTypeEClassCrossReference_6_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2156:2: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==27) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==RULE_INT||LA40_1==33||LA40_1==78) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2156:4: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveRandomReferenceMutator5079); 

                        	newLeafNode(otherlv_7, grammarAccess.getRemoveRandomReferenceMutatorAccess().getLeftSquareBracketKeyword_7_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2160:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==33) ) {
                        int LA39_1 = input.LA(2);

                        if ( (LA39_1==RULE_INT) ) {
                            int LA39_2 = input.LA(3);

                            if ( (LA39_2==28) ) {
                                alt39=1;
                            }
                        }
                    }
                    else if ( (LA39_0==RULE_INT) ) {
                        int LA39_2 = input.LA(2);

                        if ( (LA39_2==28) ) {
                            alt39=1;
                        }
                    }
                    switch (alt39) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2160:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2160:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2161:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2161:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2162:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMinEIntParserRuleCall_7_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator5101);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRemoveRandomReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_8_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveRandomReferenceMutator5113); 

                                	newLeafNode(otherlv_9, grammarAccess.getRemoveRandomReferenceMutatorAccess().getFullStopFullStopKeyword_7_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2182:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2183:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2183:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2184:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator5136);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveRandomReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_10_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveRandomReferenceMutator5148); 

                        	newLeafNode(otherlv_11, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRightSquareBracketKeyword_7_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveRandomReferenceMutator"


    // $ANTLR start "entryRuleRemoveSpecificReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2212:1: entryRuleRemoveSpecificReferenceMutator returns [EObject current=null] : iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF ;
    public final EObject entryRuleRemoveSpecificReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveSpecificReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2213:2: (iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2214:2: iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator5186);
            iv_ruleRemoveSpecificReferenceMutator=ruleRemoveSpecificReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveSpecificReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator5196); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveSpecificReferenceMutator"


    // $ANTLR start "ruleRemoveSpecificReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2221:1: ruleRemoveSpecificReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) ;
    public final EObject ruleRemoveSpecificReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_container_5_0 = null;

        AntlrDatatypeRuleToken lv_min_7_0 = null;

        AntlrDatatypeRuleToken lv_max_9_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2224:28: ( ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2225:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2225:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2225:2: () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2225:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2226:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveSpecificReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveSpecificReferenceMutator5242); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRemoveSpecificReferenceMutator5254); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2239:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2240:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2240:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2241:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator5274); 

            		newLeafNode(otherlv_3, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveSpecificReferenceMutator5286); 

                	newLeafNode(otherlv_4, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getInKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2256:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2257:1: (lv_container_5_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2257:1: (lv_container_5_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2258:3: lv_container_5_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getContainerObSelectionStrategyParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator5307);
            lv_container_5_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"container",
                    		lv_container_5_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2274:2: (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==27) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==RULE_INT||LA42_1==33||LA42_1==78) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2274:4: otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']'
                    {
                    otherlv_6=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveSpecificReferenceMutator5320); 

                        	newLeafNode(otherlv_6, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2278:1: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==33) ) {
                        int LA41_1 = input.LA(2);

                        if ( (LA41_1==RULE_INT) ) {
                            int LA41_2 = input.LA(3);

                            if ( (LA41_2==28) ) {
                                alt41=1;
                            }
                        }
                    }
                    else if ( (LA41_0==RULE_INT) ) {
                        int LA41_2 = input.LA(2);

                        if ( (LA41_2==28) ) {
                            alt41=1;
                        }
                    }
                    switch (alt41) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2278:2: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2278:2: ( (lv_min_7_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2279:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2279:1: (lv_min_7_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2280:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator5342);
                            lv_min_7_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_7_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveSpecificReferenceMutator5354); 

                                	newLeafNode(otherlv_8, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2300:3: ( (lv_max_9_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2301:1: (lv_max_9_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2301:1: (lv_max_9_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2302:3: lv_max_9_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator5377);
                    lv_max_9_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveSpecificReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_9_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveSpecificReferenceMutator5389); 

                        	newLeafNode(otherlv_10, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRightSquareBracketKeyword_6_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveSpecificReferenceMutator"


    // $ANTLR start "entryRuleRemoveCompleteReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2330:1: entryRuleRemoveCompleteReferenceMutator returns [EObject current=null] : iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF ;
    public final EObject entryRuleRemoveCompleteReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveCompleteReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2331:2: (iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2332:2: iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveCompleteReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator5427);
            iv_ruleRemoveCompleteReferenceMutator=ruleRemoveCompleteReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveCompleteReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator5437); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRemoveCompleteReferenceMutator"


    // $ANTLR start "ruleRemoveCompleteReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2339:1: ruleRemoveCompleteReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleRemoveCompleteReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2342:28: ( ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2343:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2343:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2343:2: () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2343:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2344:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveCompleteReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveCompleteReferenceMutator5483); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleRemoveCompleteReferenceMutator5495); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getAllKeyword_2());
                
            otherlv_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRemoveCompleteReferenceMutator5507); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2361:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2362:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2362:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2363:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5527); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveCompleteReferenceMutator5539); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getInKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2378:1: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2379:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2379:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2380:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5559); 

            		newLeafNode(otherlv_6, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getTypeEClassCrossReference_6_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRemoveCompleteReferenceMutator"


    // $ANTLR start "entryRuleCreateObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2399:1: entryRuleCreateObjectMutator returns [EObject current=null] : iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF ;
    public final EObject entryRuleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2400:2: (iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2401:2: iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator5595);
            iv_ruleCreateObjectMutator=ruleCreateObjectMutator();

            state._fsp--;

             current =iv_ruleCreateObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateObjectMutator5605); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreateObjectMutator"


    // $ANTLR start "ruleCreateObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2408:1: ruleCreateObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? ) ;
    public final EObject ruleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        EObject lv_container_5_0 = null;

        EObject lv_attributes_8_0 = null;

        EObject lv_references_9_0 = null;

        EObject lv_attributes_11_0 = null;

        EObject lv_references_12_0 = null;

        AntlrDatatypeRuleToken lv_min_15_0 = null;

        AntlrDatatypeRuleToken lv_max_17_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2411:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2412:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2412:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2412:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2412:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2412:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2412:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2413:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2413:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2414:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator5648); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getCreateObjectMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCreateObjectMutator5665); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateObjectMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCreateObjectMutator5679); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateObjectMutatorAccess().getCreateKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2438:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2439:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2439:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2440:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator5699); 

            		newLeafNode(otherlv_3, grammarAccess.getCreateObjectMutatorAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2451:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==22) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2451:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCreateObjectMutator5712); 

                        	newLeafNode(otherlv_4, grammarAccess.getCreateObjectMutatorAccess().getInKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2455:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2456:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2456:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2457:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator5733);
                    lv_container_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"container",
                            		lv_container_5_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2473:4: (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==11) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2473:6: otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}'
                    {
                    otherlv_6=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleCreateObjectMutator5748); 

                        	newLeafNode(otherlv_6, grammarAccess.getCreateObjectMutatorAccess().getWithKeyword_4_0());
                        
                    otherlv_7=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCreateObjectMutator5760); 

                        	newLeafNode(otherlv_7, grammarAccess.getCreateObjectMutatorAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2481:1: ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )?
                    int alt45=3;
                    alt45 = dfa45.predict(input);
                    switch (alt45) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2481:2: ( (lv_attributes_8_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2481:2: ( (lv_attributes_8_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2482:1: (lv_attributes_8_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2482:1: (lv_attributes_8_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2483:3: lv_attributes_8_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5782);
                            lv_attributes_8_0=ruleAttributeSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"attributes",
                                    		lv_attributes_8_0, 
                                    		"AttributeSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2500:6: ( (lv_references_9_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2500:6: ( (lv_references_9_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2501:1: (lv_references_9_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2501:1: (lv_references_9_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2502:3: lv_references_9_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5809);
                            lv_references_9_0=ruleReferenceSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"references",
                                    		lv_references_9_0, 
                                    		"ReferenceSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2518:4: (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==24) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2518:6: otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleCreateObjectMutator5824); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getCreateObjectMutatorAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2522:1: ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )
                    	    int alt46=2;
                    	    alt46 = dfa46.predict(input);
                    	    switch (alt46) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2522:2: ( (lv_attributes_11_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2522:2: ( (lv_attributes_11_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2523:1: (lv_attributes_11_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2523:1: (lv_attributes_11_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2524:3: lv_attributes_11_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5846);
                    	            lv_attributes_11_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"attributes",
                    	                    		lv_attributes_11_0, 
                    	                    		"AttributeSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2541:6: ( (lv_references_12_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2541:6: ( (lv_references_12_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2542:1: (lv_references_12_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2542:1: (lv_references_12_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2543:3: lv_references_12_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5873);
                    	            lv_references_12_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"references",
                    	                    		lv_references_12_0, 
                    	                    		"ReferenceSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop47;
                        }
                    } while (true);

                    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCreateObjectMutator5888); 

                        	newLeafNode(otherlv_13, grammarAccess.getCreateObjectMutatorAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2563:3: (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==27) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==RULE_INT||LA50_1==33||LA50_1==78) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2563:5: otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']'
                    {
                    otherlv_14=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCreateObjectMutator5903); 

                        	newLeafNode(otherlv_14, grammarAccess.getCreateObjectMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2567:1: ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==33) ) {
                        int LA49_1 = input.LA(2);

                        if ( (LA49_1==RULE_INT) ) {
                            int LA49_2 = input.LA(3);

                            if ( (LA49_2==28) ) {
                                alt49=1;
                            }
                        }
                    }
                    else if ( (LA49_0==RULE_INT) ) {
                        int LA49_2 = input.LA(2);

                        if ( (LA49_2==28) ) {
                            alt49=1;
                        }
                    }
                    switch (alt49) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2567:2: ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2567:2: ( (lv_min_15_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2568:1: (lv_min_15_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2568:1: (lv_min_15_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2569:3: lv_min_15_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateObjectMutator5925);
                            lv_min_15_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_15_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_16=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCreateObjectMutator5937); 

                                	newLeafNode(otherlv_16, grammarAccess.getCreateObjectMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2589:3: ( (lv_max_17_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2590:1: (lv_max_17_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2590:1: (lv_max_17_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2591:3: lv_max_17_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator5960);
                    lv_max_17_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_17_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_18=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCreateObjectMutator5972); 

                        	newLeafNode(otherlv_18, grammarAccess.getCreateObjectMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreateObjectMutator"


    // $ANTLR start "entryRuleSelectObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2619:1: entryRuleSelectObjectMutator returns [EObject current=null] : iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF ;
    public final EObject entryRuleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2620:2: (iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2621:2: iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getSelectObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator6010);
            iv_ruleSelectObjectMutator=ruleSelectObjectMutator();

            state._fsp--;

             current =iv_ruleSelectObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectObjectMutator6020); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectObjectMutator"


    // $ANTLR start "ruleSelectObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2628:1: ruleSelectObjectMutator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? ) ;
    public final EObject ruleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_object_3_0 = null;

        EObject lv_container_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2631:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2632:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2632:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2632:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2632:2: ( (lv_name_0_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2633:1: (lv_name_0_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2633:1: (lv_name_0_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2634:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectObjectMutator6062); 

            			newLeafNode(lv_name_0_0, grammarAccess.getSelectObjectMutatorAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSelectObjectMutatorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleSelectObjectMutator6079); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectObjectMutatorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSelectObjectMutator6091); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectObjectMutatorAccess().getSelectKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2658:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2659:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2659:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2660:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6112);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectObjectMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_3_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2676:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==22) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2676:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSelectObjectMutator6125); 

                        	newLeafNode(otherlv_4, grammarAccess.getSelectObjectMutatorAccess().getInKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2680:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2681:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2681:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2682:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6146);
                    lv_container_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSelectObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"container",
                            		lv_container_5_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectObjectMutator"


    // $ANTLR start "entryRuleSelectSampleMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2706:1: entryRuleSelectSampleMutator returns [EObject current=null] : iv_ruleSelectSampleMutator= ruleSelectSampleMutator EOF ;
    public final EObject entryRuleSelectSampleMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectSampleMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2707:2: (iv_ruleSelectSampleMutator= ruleSelectSampleMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2708:2: iv_ruleSelectSampleMutator= ruleSelectSampleMutator EOF
            {
             newCompositeNode(grammarAccess.getSelectSampleMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectSampleMutator_in_entryRuleSelectSampleMutator6184);
            iv_ruleSelectSampleMutator=ruleSelectSampleMutator();

            state._fsp--;

             current =iv_ruleSelectSampleMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectSampleMutator6194); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSelectSampleMutator"


    // $ANTLR start "ruleSelectSampleMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2715:1: ruleSelectSampleMutator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? ) ;
    public final EObject ruleSelectSampleMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_object_5_0 = null;

        Enumerator lv_clause_7_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2718:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2719:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2719:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2719:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' otherlv_3= 'sample' otherlv_4= 'from' ( (lv_object_5_0= ruleObSelectionStrategy ) ) (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2719:2: ( (lv_name_0_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2720:1: (lv_name_0_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2720:1: (lv_name_0_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2721:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectSampleMutator6236); 

            			newLeafNode(lv_name_0_0, grammarAccess.getSelectSampleMutatorAccess().getNameIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSelectSampleMutatorRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ID");
            	    

            }


            }

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleSelectSampleMutator6253); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectSampleMutatorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSelectSampleMutator6265); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectSampleMutatorAccess().getSelectKeyword_2());
                
            otherlv_3=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleSelectSampleMutator6277); 

                	newLeafNode(otherlv_3, grammarAccess.getSelectSampleMutatorAccess().getSampleKeyword_3());
                
            otherlv_4=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSelectSampleMutator6289); 

                	newLeafNode(otherlv_4, grammarAccess.getSelectSampleMutatorAccess().getFromKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2753:1: ( (lv_object_5_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:1: (lv_object_5_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:1: (lv_object_5_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2755:3: lv_object_5_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getSelectSampleMutatorAccess().getObjectObSelectionStrategyParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectSampleMutator6310);
            lv_object_5_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSelectSampleMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_5_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2771:2: (otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==11) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2771:4: otherlv_6= 'with' ( (lv_clause_7_0= ruleSampleClause ) ) otherlv_8= '{' ( (otherlv_9= RULE_ID ) )? (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= '}'
                    {
                    otherlv_6=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSelectSampleMutator6323); 

                        	newLeafNode(otherlv_6, grammarAccess.getSelectSampleMutatorAccess().getWithKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2775:1: ( (lv_clause_7_0= ruleSampleClause ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2776:1: (lv_clause_7_0= ruleSampleClause )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2776:1: (lv_clause_7_0= ruleSampleClause )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2777:3: lv_clause_7_0= ruleSampleClause
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectSampleMutatorAccess().getClauseSampleClauseEnumRuleCall_6_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleSampleClause_in_ruleSelectSampleMutator6344);
                    lv_clause_7_0=ruleSampleClause();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSelectSampleMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"clause",
                            		lv_clause_7_0, 
                            		"SampleClause");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSelectSampleMutator6356); 

                        	newLeafNode(otherlv_8, grammarAccess.getSelectSampleMutatorAccess().getLeftCurlyBracketKeyword_6_2());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2797:1: ( (otherlv_9= RULE_ID ) )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==RULE_ID) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2798:1: (otherlv_9= RULE_ID )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2798:1: (otherlv_9= RULE_ID )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2799:3: otherlv_9= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getSelectSampleMutatorRule());
                            	        }
                                    
                            otherlv_9=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectSampleMutator6376); 

                            		newLeafNode(otherlv_9, grammarAccess.getSelectSampleMutatorAccess().getFeaturesEStructuralFeatureCrossReference_6_3_0()); 
                            	

                            }


                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2810:3: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==24) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2810:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleSelectSampleMutator6390); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getSelectSampleMutatorAccess().getCommaKeyword_6_4_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2814:1: ( (otherlv_11= RULE_ID ) )
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2815:1: (otherlv_11= RULE_ID )
                    	    {
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2815:1: (otherlv_11= RULE_ID )
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2816:3: otherlv_11= RULE_ID
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSelectSampleMutatorRule());
                    	    	        }
                    	            
                    	    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectSampleMutator6410); 

                    	    		newLeafNode(otherlv_11, grammarAccess.getSelectSampleMutatorAccess().getFeaturesEStructuralFeatureCrossReference_6_4_1_0()); 
                    	    	

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSelectSampleMutator6424); 

                        	newLeafNode(otherlv_12, grammarAccess.getSelectSampleMutatorAccess().getRightCurlyBracketKeyword_6_5());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSelectSampleMutator"


    // $ANTLR start "entryRuleModifyInformationMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2839:1: entryRuleModifyInformationMutator returns [EObject current=null] : iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF ;
    public final EObject entryRuleModifyInformationMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyInformationMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2840:2: (iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2841:2: iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyInformationMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator6462);
            iv_ruleModifyInformationMutator=ruleModifyInformationMutator();

            state._fsp--;

             current =iv_ruleModifyInformationMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyInformationMutator6472); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifyInformationMutator"


    // $ANTLR start "ruleModifyInformationMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2848:1: ruleModifyInformationMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) ;
    public final EObject ruleModifyInformationMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        EObject lv_object_3_0 = null;

        EObject lv_attributes_6_0 = null;

        EObject lv_references_7_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_references_10_0 = null;

        AntlrDatatypeRuleToken lv_min_13_0 = null;

        AntlrDatatypeRuleToken lv_max_15_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2851:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2852:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2852:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2852:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2852:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==RULE_ID) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2852:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2852:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2853:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2853:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2854:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyInformationMutator6515); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getModifyInformationMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getModifyInformationMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleModifyInformationMutator6532); 

                        	newLeafNode(otherlv_1, grammarAccess.getModifyInformationMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModifyInformationMutator6546); 

                	newLeafNode(otherlv_2, grammarAccess.getModifyInformationMutatorAccess().getModifyKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2878:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2879:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2879:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2880:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator6567);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_3_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2896:2: (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==11) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2896:4: otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}'
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModifyInformationMutator6580); 

                        	newLeafNode(otherlv_4, grammarAccess.getModifyInformationMutatorAccess().getWithKeyword_3_0());
                        
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModifyInformationMutator6592); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyInformationMutatorAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2904:1: ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )?
                    int alt56=3;
                    alt56 = dfa56.predict(input);
                    switch (alt56) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2904:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2904:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2905:1: (lv_attributes_6_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2905:1: (lv_attributes_6_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2906:3: lv_attributes_6_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6614);
                            lv_attributes_6_0=ruleAttributeSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"attributes",
                                    		lv_attributes_6_0, 
                                    		"AttributeSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2923:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2923:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2924:1: (lv_references_7_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2924:1: (lv_references_7_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2925:3: lv_references_7_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6641);
                            lv_references_7_0=ruleReferenceSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"references",
                                    		lv_references_7_0, 
                                    		"ReferenceSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2941:4: (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )*
                    loop58:
                    do {
                        int alt58=2;
                        int LA58_0 = input.LA(1);

                        if ( (LA58_0==24) ) {
                            alt58=1;
                        }


                        switch (alt58) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2941:6: otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_8=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleModifyInformationMutator6656); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getModifyInformationMutatorAccess().getCommaKeyword_3_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2945:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    int alt57=2;
                    	    alt57 = dfa57.predict(input);
                    	    switch (alt57) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2945:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2945:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2946:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2946:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2947:3: lv_attributes_9_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6678);
                    	            lv_attributes_9_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"attributes",
                    	                    		lv_attributes_9_0, 
                    	                    		"AttributeSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2964:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2964:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2965:1: (lv_references_10_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2965:1: (lv_references_10_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2966:3: lv_references_10_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6705);
                    	            lv_references_10_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"references",
                    	                    		lv_references_10_0, 
                    	                    		"ReferenceSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop58;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModifyInformationMutator6720); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifyInformationMutatorAccess().getRightCurlyBracketKeyword_3_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2986:3: (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==27) ) {
                int LA61_1 = input.LA(2);

                if ( (LA61_1==RULE_INT||LA61_1==33||LA61_1==78) ) {
                    alt61=1;
                }
            }
            switch (alt61) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2986:5: otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']'
                    {
                    otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifyInformationMutator6735); 

                        	newLeafNode(otherlv_12, grammarAccess.getModifyInformationMutatorAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2990:1: ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==33) ) {
                        int LA60_1 = input.LA(2);

                        if ( (LA60_1==RULE_INT) ) {
                            int LA60_2 = input.LA(3);

                            if ( (LA60_2==28) ) {
                                alt60=1;
                            }
                        }
                    }
                    else if ( (LA60_0==RULE_INT) ) {
                        int LA60_2 = input.LA(2);

                        if ( (LA60_2==28) ) {
                            alt60=1;
                        }
                    }
                    switch (alt60) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2990:2: ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2990:2: ( (lv_min_13_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2991:1: (lv_min_13_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2991:1: (lv_min_13_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2992:3: lv_min_13_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMinEIntParserRuleCall_4_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyInformationMutator6757);
                            lv_min_13_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_13_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifyInformationMutator6769); 

                                	newLeafNode(otherlv_14, grammarAccess.getModifyInformationMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3012:3: ( (lv_max_15_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3013:1: (lv_max_15_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3013:1: (lv_max_15_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3014:3: lv_max_15_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator6792);
                    lv_max_15_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyInformationMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_15_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_16=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifyInformationMutator6804); 

                        	newLeafNode(otherlv_16, grammarAccess.getModifyInformationMutatorAccess().getRightSquareBracketKeyword_4_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifyInformationMutator"


    // $ANTLR start "entryRuleCreateReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3042:1: entryRuleCreateReferenceMutator returns [EObject current=null] : iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF ;
    public final EObject entryRuleCreateReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3043:2: (iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3044:2: iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator6842);
            iv_ruleCreateReferenceMutator=ruleCreateReferenceMutator();

            state._fsp--;

             current =iv_ruleCreateReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateReferenceMutator6852); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCreateReferenceMutator"


    // $ANTLR start "ruleCreateReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3051:1: ruleCreateReferenceMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) ;
    public final EObject ruleCreateReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_target_6_0 = null;

        EObject lv_source_8_0 = null;

        AntlrDatatypeRuleToken lv_min_10_0 = null;

        AntlrDatatypeRuleToken lv_max_12_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3054:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3055:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3055:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3055:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3055:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_ID) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3055:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3055:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3056:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3056:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3057:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6895); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getCreateReferenceMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCreateReferenceMutator6912); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateReferenceMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCreateReferenceMutator6926); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateReferenceMutatorAccess().getCreateKeyword_1());
                
            otherlv_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCreateReferenceMutator6938); 

                	newLeafNode(otherlv_3, grammarAccess.getCreateReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3085:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3086:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3086:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3087:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6958); 

            		newLeafNode(otherlv_4, grammarAccess.getCreateReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3098:2: (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==50) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3098:4: otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleCreateReferenceMutator6971); 

                        	newLeafNode(otherlv_5, grammarAccess.getCreateReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3102:1: ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3103:1: (lv_target_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3103:1: (lv_target_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3104:3: lv_target_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6992);
                    lv_target_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"target",
                            		lv_target_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3120:4: (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==22) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3120:6: otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCreateReferenceMutator7007); 

                        	newLeafNode(otherlv_7, grammarAccess.getCreateReferenceMutatorAccess().getInKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3124:1: ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3125:1: (lv_source_8_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3125:1: (lv_source_8_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3126:3: lv_source_8_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator7028);
                    lv_source_8_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"source",
                            		lv_source_8_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3142:4: (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==27) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==RULE_INT||LA66_1==33||LA66_1==78) ) {
                    alt66=1;
                }
            }
            switch (alt66) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3142:6: otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']'
                    {
                    otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCreateReferenceMutator7043); 

                        	newLeafNode(otherlv_9, grammarAccess.getCreateReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3146:1: ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==33) ) {
                        int LA65_1 = input.LA(2);

                        if ( (LA65_1==RULE_INT) ) {
                            int LA65_2 = input.LA(3);

                            if ( (LA65_2==28) ) {
                                alt65=1;
                            }
                        }
                    }
                    else if ( (LA65_0==RULE_INT) ) {
                        int LA65_2 = input.LA(2);

                        if ( (LA65_2==28) ) {
                            alt65=1;
                        }
                    }
                    switch (alt65) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3146:2: ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3146:2: ( (lv_min_10_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3147:1: (lv_min_10_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3147:1: (lv_min_10_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3148:3: lv_min_10_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateReferenceMutator7065);
                            lv_min_10_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_10_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCreateReferenceMutator7077); 

                                	newLeafNode(otherlv_11, grammarAccess.getCreateReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3168:3: ( (lv_max_12_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3169:1: (lv_max_12_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3169:1: (lv_max_12_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3170:3: lv_max_12_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator7100);
                    lv_max_12_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_12_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_13=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCreateReferenceMutator7112); 

                        	newLeafNode(otherlv_13, grammarAccess.getCreateReferenceMutatorAccess().getRightSquareBracketKeyword_6_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCreateReferenceMutator"


    // $ANTLR start "entryRuleModifySourceReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3198:1: entryRuleModifySourceReferenceMutator returns [EObject current=null] : iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF ;
    public final EObject entryRuleModifySourceReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifySourceReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3199:2: (iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3200:2: iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifySourceReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator7150);
            iv_ruleModifySourceReferenceMutator=ruleModifySourceReferenceMutator();

            state._fsp--;

             current =iv_ruleModifySourceReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator7160); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifySourceReferenceMutator"


    // $ANTLR start "ruleModifySourceReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3207:1: ruleModifySourceReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
    public final EObject ruleModifySourceReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_source_4_0 = null;

        EObject lv_newSource_6_0 = null;

        AntlrDatatypeRuleToken lv_min_8_0 = null;

        AntlrDatatypeRuleToken lv_max_10_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3210:28: ( (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3211:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3211:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3211:3: otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModifySourceReferenceMutator7197); 

                	newLeafNode(otherlv_0, grammarAccess.getModifySourceReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleModifySourceReferenceMutator7209); 

                	newLeafNode(otherlv_1, grammarAccess.getModifySourceReferenceMutatorAccess().getSourceKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3219:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3220:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3220:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3221:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifySourceReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator7229); 

            		newLeafNode(otherlv_2, grammarAccess.getModifySourceReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3232:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==23) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3232:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModifySourceReferenceMutator7242); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifySourceReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3236:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3237:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3237:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3238:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7263);
                    lv_source_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"source",
                            		lv_source_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3254:4: (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==50) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3254:6: otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleModifySourceReferenceMutator7278); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifySourceReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3258:1: ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3259:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3259:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3260:3: lv_newSource_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getNewSourceObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7299);
                    lv_newSource_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"newSource",
                            		lv_newSource_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3276:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==27) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==RULE_INT||LA70_1==33||LA70_1==78) ) {
                    alt70=1;
                }
            }
            switch (alt70) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3276:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifySourceReferenceMutator7314); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifySourceReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3280:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==33) ) {
                        int LA69_1 = input.LA(2);

                        if ( (LA69_1==RULE_INT) ) {
                            int LA69_2 = input.LA(3);

                            if ( (LA69_2==28) ) {
                                alt69=1;
                            }
                        }
                    }
                    else if ( (LA69_0==RULE_INT) ) {
                        int LA69_2 = input.LA(2);

                        if ( (LA69_2==28) ) {
                            alt69=1;
                        }
                    }
                    switch (alt69) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3280:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3280:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3281:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3281:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3282:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator7336);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_8_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifySourceReferenceMutator7348); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifySourceReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3302:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3303:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3303:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3304:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator7371);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifySourceReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_10_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifySourceReferenceMutator7383); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifySourceReferenceMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifySourceReferenceMutator"


    // $ANTLR start "entryRuleModifyTargetReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3332:1: entryRuleModifyTargetReferenceMutator returns [EObject current=null] : iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF ;
    public final EObject entryRuleModifyTargetReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyTargetReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3333:2: (iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3334:2: iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator7421);
            iv_ruleModifyTargetReferenceMutator=ruleModifyTargetReferenceMutator();

            state._fsp--;

             current =iv_ruleModifyTargetReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator7431); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModifyTargetReferenceMutator"


    // $ANTLR start "ruleModifyTargetReferenceMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3341:1: ruleModifyTargetReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
    public final EObject ruleModifyTargetReferenceMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_source_4_0 = null;

        EObject lv_newTarget_6_0 = null;

        AntlrDatatypeRuleToken lv_min_8_0 = null;

        AntlrDatatypeRuleToken lv_max_10_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3344:28: ( (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3345:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3345:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3345:3: otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModifyTargetReferenceMutator7468); 

                	newLeafNode(otherlv_0, grammarAccess.getModifyTargetReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleModifyTargetReferenceMutator7480); 

                	newLeafNode(otherlv_1, grammarAccess.getModifyTargetReferenceMutatorAccess().getTargetKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3353:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3354:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3354:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3355:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifyTargetReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator7500); 

            		newLeafNode(otherlv_2, grammarAccess.getModifyTargetReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3366:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==23) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3366:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModifyTargetReferenceMutator7513); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifyTargetReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3370:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3371:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3371:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3372:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7534);
                    lv_source_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"source",
                            		lv_source_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3388:4: (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==50) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3388:6: otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleModifyTargetReferenceMutator7549); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyTargetReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3392:1: ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3393:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3393:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3394:3: lv_newTarget_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getNewTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7570);
                    lv_newTarget_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"newTarget",
                            		lv_newTarget_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3410:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==27) ) {
                int LA74_1 = input.LA(2);

                if ( (LA74_1==RULE_INT||LA74_1==33||LA74_1==78) ) {
                    alt74=1;
                }
            }
            switch (alt74) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3410:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifyTargetReferenceMutator7585); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifyTargetReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3414:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt73=2;
                    int LA73_0 = input.LA(1);

                    if ( (LA73_0==33) ) {
                        int LA73_1 = input.LA(2);

                        if ( (LA73_1==RULE_INT) ) {
                            int LA73_2 = input.LA(3);

                            if ( (LA73_2==28) ) {
                                alt73=1;
                            }
                        }
                    }
                    else if ( (LA73_0==RULE_INT) ) {
                        int LA73_2 = input.LA(2);

                        if ( (LA73_2==28) ) {
                            alt73=1;
                        }
                    }
                    switch (alt73) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3414:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3414:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3415:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3415:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3416:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator7607);
                            lv_min_8_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_8_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifyTargetReferenceMutator7619); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifyTargetReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3436:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3437:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3437:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3438:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator7642);
                    lv_max_10_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModifyTargetReferenceMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_10_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifyTargetReferenceMutator7654); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifyTargetReferenceMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModifyTargetReferenceMutator"


    // $ANTLR start "entryRuleCompositeMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3466:1: entryRuleCompositeMutator returns [EObject current=null] : iv_ruleCompositeMutator= ruleCompositeMutator EOF ;
    public final EObject entryRuleCompositeMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3467:2: (iv_ruleCompositeMutator= ruleCompositeMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3468:2: iv_ruleCompositeMutator= ruleCompositeMutator EOF
            {
             newCompositeNode(grammarAccess.getCompositeMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator7692);
            iv_ruleCompositeMutator=ruleCompositeMutator();

            state._fsp--;

             current =iv_ruleCompositeMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeMutator7702); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompositeMutator"


    // $ANTLR start "ruleCompositeMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3475:1: ruleCompositeMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) ;
    public final EObject ruleCompositeMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject lv_commands_3_0 = null;

        EObject lv_commands_4_0 = null;

        AntlrDatatypeRuleToken lv_min_7_0 = null;

        AntlrDatatypeRuleToken lv_max_9_0 = null;

        AntlrDatatypeRuleToken lv_fixed_10_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3478:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3479:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3479:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3479:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3479:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==RULE_ID) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3479:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3479:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3480:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3480:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3481:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompositeMutator7745); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getCompositeMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCompositeMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCompositeMutator7762); 

                        	newLeafNode(otherlv_1, grammarAccess.getCompositeMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCompositeMutator7776); 

                	newLeafNode(otherlv_2, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3505:1: ( (lv_commands_3_0= ruleMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3506:1: (lv_commands_3_0= ruleMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3506:1: (lv_commands_3_0= ruleMutator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3507:3: lv_commands_3_0= ruleMutator
            {
             
            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator7797);
            lv_commands_3_0=ruleMutator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
            	        }
                   		add(
                   			current, 
                   			"commands",
                    		lv_commands_3_0, 
                    		"Mutator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3523:2: ( (lv_commands_4_0= ruleMutator ) )*
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==RULE_ID||LA76_0==27||LA76_0==42||LA76_0==46||LA76_0==49||LA76_0==53) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3524:1: (lv_commands_4_0= ruleMutator )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3524:1: (lv_commands_4_0= ruleMutator )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3525:3: lv_commands_4_0= ruleMutator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator7818);
            	    lv_commands_4_0=ruleMutator();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"commands",
            	            		lv_commands_4_0, 
            	            		"Mutator");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop76;
                }
            } while (true);

            otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCompositeMutator7831); 

                	newLeafNode(otherlv_5, grammarAccess.getCompositeMutatorAccess().getRightSquareBracketKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3545:1: (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==27) ) {
                int LA78_1 = input.LA(2);

                if ( (LA78_1==RULE_INT||LA78_1==33) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3545:3: otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']'
                    {
                    otherlv_6=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCompositeMutator7844); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3549:1: ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) )
                    int alt77=2;
                    int LA77_0 = input.LA(1);

                    if ( (LA77_0==33) ) {
                        int LA77_1 = input.LA(2);

                        if ( (LA77_1==RULE_INT) ) {
                            int LA77_2 = input.LA(3);

                            if ( (LA77_2==28) ) {
                                alt77=1;
                            }
                            else if ( (LA77_2==29) ) {
                                alt77=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 77, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 77, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA77_0==RULE_INT) ) {
                        int LA77_2 = input.LA(2);

                        if ( (LA77_2==28) ) {
                            alt77=1;
                        }
                        else if ( (LA77_2==29) ) {
                            alt77=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 77, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 77, 0, input);

                        throw nvae;
                    }
                    switch (alt77) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3549:2: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3549:2: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3549:3: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3549:3: ( (lv_min_7_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3550:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3550:1: (lv_min_7_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3551:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMinEIntParserRuleCall_5_1_0_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCompositeMutator7867);
                            lv_min_7_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_7_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCompositeMutator7879); 

                                	newLeafNode(otherlv_8, grammarAccess.getCompositeMutatorAccess().getFullStopFullStopKeyword_5_1_0_1());
                                
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3571:1: ( (lv_max_9_0= ruleMaxCardinality ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3572:1: (lv_max_9_0= ruleMaxCardinality )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3572:1: (lv_max_9_0= ruleMaxCardinality )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3573:3: lv_max_9_0= ruleMaxCardinality
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_1_0_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator7900);
                            lv_max_9_0=ruleMaxCardinality();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"max",
                                    		lv_max_9_0, 
                                    		"MaxCardinality");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3590:6: ( (lv_fixed_10_0= ruleEInt ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3590:6: ( (lv_fixed_10_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3591:1: (lv_fixed_10_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3591:1: (lv_fixed_10_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3592:3: lv_fixed_10_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getFixedEIntParserRuleCall_5_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCompositeMutator7928);
                            lv_fixed_10_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCompositeMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"fixed",
                                    		lv_fixed_10_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCompositeMutator7941); 

                        	newLeafNode(otherlv_11, grammarAccess.getCompositeMutatorAccess().getRightSquareBracketKeyword_5_2());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompositeMutator"


    // $ANTLR start "entryRuleCloneObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3620:1: entryRuleCloneObjectMutator returns [EObject current=null] : iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF ;
    public final EObject entryRuleCloneObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCloneObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3621:2: (iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3622:2: iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCloneObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCloneObjectMutator_in_entryRuleCloneObjectMutator7979);
            iv_ruleCloneObjectMutator=ruleCloneObjectMutator();

            state._fsp--;

             current =iv_ruleCloneObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCloneObjectMutator7989); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCloneObjectMutator"


    // $ANTLR start "ruleCloneObjectMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3629:1: ruleCloneObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? ) ;
    public final EObject ruleCloneObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_contents_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        EObject lv_object_4_0 = null;

        EObject lv_container_6_0 = null;

        EObject lv_attributes_9_0 = null;

        EObject lv_references_10_0 = null;

        EObject lv_attributes_12_0 = null;

        EObject lv_references_13_0 = null;

        AntlrDatatypeRuleToken lv_min_16_0 = null;

        AntlrDatatypeRuleToken lv_max_18_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3632:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==RULE_ID) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3634:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3634:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3635:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCloneObjectMutator8032); 

                    			newLeafNode(lv_name_0_0, grammarAccess.getCloneObjectMutatorAccess().getNameIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCloneObjectMutatorRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"ID");
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCloneObjectMutator8049); 

                        	newLeafNode(otherlv_1, grammarAccess.getCloneObjectMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCloneObjectMutator8063); 

                	newLeafNode(otherlv_2, grammarAccess.getCloneObjectMutatorAccess().getCloneKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3659:1: ( (lv_contents_3_0= 'contents' ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==54) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3660:1: (lv_contents_3_0= 'contents' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3660:1: (lv_contents_3_0= 'contents' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3661:3: lv_contents_3_0= 'contents'
                    {
                    lv_contents_3_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleCloneObjectMutator8081); 

                            newLeafNode(lv_contents_3_0, grammarAccess.getCloneObjectMutatorAccess().getContentsContentsKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCloneObjectMutatorRule());
                    	        }
                           		setWithLastConsumed(current, "contents", true, "contents");
                    	    

                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3674:3: ( (lv_object_4_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3675:1: (lv_object_4_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3675:1: (lv_object_4_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3676:3: lv_object_4_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator8116);
            lv_object_4_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_4_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3692:2: (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==22) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3692:4: otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCloneObjectMutator8129); 

                        	newLeafNode(otherlv_5, grammarAccess.getCloneObjectMutatorAccess().getInKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3696:1: ( (lv_container_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3697:1: (lv_container_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3697:1: (lv_container_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3698:3: lv_container_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator8150);
                    lv_container_6_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"container",
                            		lv_container_6_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3714:4: (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==11) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3714:6: otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}'
                    {
                    otherlv_7=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleCloneObjectMutator8165); 

                        	newLeafNode(otherlv_7, grammarAccess.getCloneObjectMutatorAccess().getWithKeyword_5_0());
                        
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCloneObjectMutator8177); 

                        	newLeafNode(otherlv_8, grammarAccess.getCloneObjectMutatorAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3722:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )?
                    int alt82=3;
                    alt82 = dfa82.predict(input);
                    switch (alt82) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3722:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3722:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3723:1: (lv_attributes_9_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3723:1: (lv_attributes_9_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3724:3: lv_attributes_9_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_5_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8199);
                            lv_attributes_9_0=ruleAttributeSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"attributes",
                                    		lv_attributes_9_0, 
                                    		"AttributeSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3741:6: ( (lv_references_10_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3741:6: ( (lv_references_10_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3742:1: (lv_references_10_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3742:1: (lv_references_10_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3743:3: lv_references_10_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_5_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8226);
                            lv_references_10_0=ruleReferenceSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"references",
                                    		lv_references_10_0, 
                                    		"ReferenceSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3759:4: (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )*
                    loop84:
                    do {
                        int alt84=2;
                        int LA84_0 = input.LA(1);

                        if ( (LA84_0==24) ) {
                            alt84=1;
                        }


                        switch (alt84) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3759:6: otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_11=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleCloneObjectMutator8241); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getCloneObjectMutatorAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3763:1: ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )
                    	    int alt83=2;
                    	    alt83 = dfa83.predict(input);
                    	    switch (alt83) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3763:2: ( (lv_attributes_12_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3763:2: ( (lv_attributes_12_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3764:1: (lv_attributes_12_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3764:1: (lv_attributes_12_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3765:3: lv_attributes_12_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_5_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8263);
                    	            lv_attributes_12_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"attributes",
                    	                    		lv_attributes_12_0, 
                    	                    		"AttributeSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3782:6: ( (lv_references_13_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3782:6: ( (lv_references_13_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3783:1: (lv_references_13_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3783:1: (lv_references_13_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3784:3: lv_references_13_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_5_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8290);
                    	            lv_references_13_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"references",
                    	                    		lv_references_13_0, 
                    	                    		"ReferenceSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop84;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCloneObjectMutator8305); 

                        	newLeafNode(otherlv_14, grammarAccess.getCloneObjectMutatorAccess().getRightCurlyBracketKeyword_5_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3804:3: (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==27) ) {
                int LA87_1 = input.LA(2);

                if ( (LA87_1==RULE_INT||LA87_1==33||LA87_1==78) ) {
                    alt87=1;
                }
            }
            switch (alt87) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3804:5: otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']'
                    {
                    otherlv_15=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCloneObjectMutator8320); 

                        	newLeafNode(otherlv_15, grammarAccess.getCloneObjectMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3808:1: ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )?
                    int alt86=2;
                    int LA86_0 = input.LA(1);

                    if ( (LA86_0==33) ) {
                        int LA86_1 = input.LA(2);

                        if ( (LA86_1==RULE_INT) ) {
                            int LA86_2 = input.LA(3);

                            if ( (LA86_2==28) ) {
                                alt86=1;
                            }
                        }
                    }
                    else if ( (LA86_0==RULE_INT) ) {
                        int LA86_2 = input.LA(2);

                        if ( (LA86_2==28) ) {
                            alt86=1;
                        }
                    }
                    switch (alt86) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3808:2: ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3808:2: ( (lv_min_16_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3809:1: (lv_min_16_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3809:1: (lv_min_16_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3810:3: lv_min_16_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCloneObjectMutator8342);
                            lv_min_16_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_16_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_17=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCloneObjectMutator8354); 

                                	newLeafNode(otherlv_17, grammarAccess.getCloneObjectMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3830:3: ( (lv_max_18_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3831:1: (lv_max_18_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3831:1: (lv_max_18_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3832:3: lv_max_18_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCloneObjectMutator8377);
                    lv_max_18_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCloneObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_18_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_19=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCloneObjectMutator8389); 

                        	newLeafNode(otherlv_19, grammarAccess.getCloneObjectMutatorAccess().getRightSquareBracketKeyword_6_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCloneObjectMutator"


    // $ANTLR start "entryRuleAttributeSet"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3860:1: entryRuleAttributeSet returns [EObject current=null] : iv_ruleAttributeSet= ruleAttributeSet EOF ;
    public final EObject entryRuleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSet = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3861:2: (iv_ruleAttributeSet= ruleAttributeSet EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3862:2: iv_ruleAttributeSet= ruleAttributeSet EOF
            {
             newCompositeNode(grammarAccess.getAttributeSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet8427);
            iv_ruleAttributeSet=ruleAttributeSet();

            state._fsp--;

             current =iv_ruleAttributeSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSet8437); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeSet"


    // $ANTLR start "ruleAttributeSet"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3869:1: ruleAttributeSet returns [EObject current=null] : (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation ) ;
    public final EObject ruleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeScalar_0 = null;

        EObject this_AttributeUnset_1 = null;

        EObject this_AttributeSwap_2 = null;

        EObject this_AttributeCopy_3 = null;

        EObject this_AttributeReverse_4 = null;

        EObject this_AttributeOperation_5 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3872:28: ( (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3873:1: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3873:1: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation )
            int alt88=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA88_1 = input.LA(2);

                if ( (LA88_1==33||LA88_1==61||LA88_1==78||(LA88_1>=82 && LA88_1<=83)) ) {
                    alt88=6;
                }
                else if ( (LA88_1==22||LA88_1==26||LA88_1==81) ) {
                    alt88=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 1, input);

                    throw nvae;
                }
                }
                break;
            case 55:
                {
                alt88=2;
                }
                break;
            case 58:
                {
                alt88=3;
                }
                break;
            case 59:
                {
                alt88=4;
                }
                break;
            case 60:
                {
                alt88=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3874:5: this_AttributeScalar_0= ruleAttributeScalar
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeScalarParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeScalar_in_ruleAttributeSet8484);
                    this_AttributeScalar_0=ruleAttributeScalar();

                    state._fsp--;

                     
                            current = this_AttributeScalar_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3884:5: this_AttributeUnset_1= ruleAttributeUnset
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeUnsetParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_ruleAttributeSet8511);
                    this_AttributeUnset_1=ruleAttributeUnset();

                    state._fsp--;

                     
                            current = this_AttributeUnset_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3894:5: this_AttributeSwap_2= ruleAttributeSwap
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeSwapParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_ruleAttributeSet8538);
                    this_AttributeSwap_2=ruleAttributeSwap();

                    state._fsp--;

                     
                            current = this_AttributeSwap_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3904:5: this_AttributeCopy_3= ruleAttributeCopy
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeCopyParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_ruleAttributeSet8565);
                    this_AttributeCopy_3=ruleAttributeCopy();

                    state._fsp--;

                     
                            current = this_AttributeCopy_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3914:5: this_AttributeReverse_4= ruleAttributeReverse
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeReverseParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_ruleAttributeSet8592);
                    this_AttributeReverse_4=ruleAttributeReverse();

                    state._fsp--;

                     
                            current = this_AttributeReverse_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3924:5: this_AttributeOperation_5= ruleAttributeOperation
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeOperationParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeOperation_in_ruleAttributeSet8619);
                    this_AttributeOperation_5=ruleAttributeOperation();

                    state._fsp--;

                     
                            current = this_AttributeOperation_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeSet"


    // $ANTLR start "entryRuleAttributeScalar"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3940:1: entryRuleAttributeScalar returns [EObject current=null] : iv_ruleAttributeScalar= ruleAttributeScalar EOF ;
    public final EObject entryRuleAttributeScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeScalar = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3941:2: (iv_ruleAttributeScalar= ruleAttributeScalar EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3942:2: iv_ruleAttributeScalar= ruleAttributeScalar EOF
            {
             newCompositeNode(grammarAccess.getAttributeScalarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeScalar_in_entryRuleAttributeScalar8654);
            iv_ruleAttributeScalar=ruleAttributeScalar();

            state._fsp--;

             current =iv_ruleAttributeScalar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeScalar8664); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeScalar"


    // $ANTLR start "ruleAttributeScalar"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3949:1: ruleAttributeScalar returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) ;
    public final EObject ruleAttributeScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3952:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3953:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3953:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3953:2: ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3953:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3954:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3954:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3955:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeScalarRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeScalar8709); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeScalarAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3966:2: ( (lv_value_1_0= ruleAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3967:1: (lv_value_1_0= ruleAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3967:1: (lv_value_1_0= ruleAttributeType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3968:3: lv_value_1_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeScalarAccess().getValueAttributeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeScalar8730);
            lv_value_1_0=ruleAttributeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeScalarRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"AttributeType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeScalar"


    // $ANTLR start "entryRuleAttributeUnset"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3992:1: entryRuleAttributeUnset returns [EObject current=null] : iv_ruleAttributeUnset= ruleAttributeUnset EOF ;
    public final EObject entryRuleAttributeUnset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeUnset = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3993:2: (iv_ruleAttributeUnset= ruleAttributeUnset EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3994:2: iv_ruleAttributeUnset= ruleAttributeUnset EOF
            {
             newCompositeNode(grammarAccess.getAttributeUnsetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset8766);
            iv_ruleAttributeUnset=ruleAttributeUnset();

            state._fsp--;

             current =iv_ruleAttributeUnset; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeUnset8776); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeUnset"


    // $ANTLR start "ruleAttributeUnset"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4001:1: ruleAttributeUnset returns [EObject current=null] : (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeUnset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4004:28: ( (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4005:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4005:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4005:3: otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleAttributeUnset8813); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeUnsetAccess().getUnsetKeyword_0());
                
            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeUnset8825); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeUnsetAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4013:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4014:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4014:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4015:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeUnsetRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeUnset8845); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeUnsetAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleAttributeUnset8857); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeUnsetAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeUnset"


    // $ANTLR start "entryRuleAttributeSwap"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4038:1: entryRuleAttributeSwap returns [EObject current=null] : iv_ruleAttributeSwap= ruleAttributeSwap EOF ;
    public final EObject entryRuleAttributeSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSwap = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4039:2: (iv_ruleAttributeSwap= ruleAttributeSwap EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4040:2: iv_ruleAttributeSwap= ruleAttributeSwap EOF
            {
             newCompositeNode(grammarAccess.getAttributeSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap8893);
            iv_ruleAttributeSwap=ruleAttributeSwap();

            state._fsp--;

             current =iv_ruleAttributeSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSwap8903); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeSwap"


    // $ANTLR start "ruleAttributeSwap"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4047:1: ruleAttributeSwap returns [EObject current=null] : (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
    public final EObject ruleAttributeSwap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4050:28: ( (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4051:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4051:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4051:3: otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleAttributeSwap8940); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeSwapAccess().getSwapKeyword_0());
                
            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeSwap8952); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4059:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4060:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4060:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4061:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap8972); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAttributeSwap8984); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeSwapAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4076:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==43||LA89_0==45||(LA89_0>=64 && LA89_0<=65)) ) {
                alt89=1;
            }
            else if ( (LA89_0==RULE_ID) ) {
                int LA89_2 = input.LA(2);

                if ( (LA89_2==34||LA89_2==40||LA89_2==63) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4076:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4076:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4077:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4077:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4078:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap9006);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeSwapRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAttributeSwap9018); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeSwapAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4098:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4099:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4099:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4100:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap9040); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleAttributeSwap9052); 

                	newLeafNode(otherlv_7, grammarAccess.getAttributeSwapAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeSwap"


    // $ANTLR start "entryRuleAttributeCopy"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4123:1: entryRuleAttributeCopy returns [EObject current=null] : iv_ruleAttributeCopy= ruleAttributeCopy EOF ;
    public final EObject entryRuleAttributeCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeCopy = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4124:2: (iv_ruleAttributeCopy= ruleAttributeCopy EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4125:2: iv_ruleAttributeCopy= ruleAttributeCopy EOF
            {
             newCompositeNode(grammarAccess.getAttributeCopyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy9088);
            iv_ruleAttributeCopy=ruleAttributeCopy();

            state._fsp--;

             current =iv_ruleAttributeCopy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeCopy9098); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeCopy"


    // $ANTLR start "ruleAttributeCopy"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4132:1: ruleAttributeCopy returns [EObject current=null] : (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
    public final EObject ruleAttributeCopy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4135:28: ( (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4136:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4136:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4136:3: otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleAttributeCopy9135); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeCopyAccess().getCopyKeyword_0());
                
            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeCopy9147); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeCopyAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4144:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4145:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4145:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4146:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy9167); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAttributeCopy9179); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeCopyAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4161:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==43||LA90_0==45||(LA90_0>=64 && LA90_0<=65)) ) {
                alt90=1;
            }
            else if ( (LA90_0==RULE_ID) ) {
                int LA90_2 = input.LA(2);

                if ( (LA90_2==34||LA90_2==40||LA90_2==63) ) {
                    alt90=1;
                }
            }
            switch (alt90) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4161:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4161:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4162:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4162:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4163:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeCopyAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy9201);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getAttributeCopyRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAttributeCopy9213); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeCopyAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4183:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4184:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4184:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4185:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy9235); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleAttributeCopy9247); 

                	newLeafNode(otherlv_7, grammarAccess.getAttributeCopyAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeCopy"


    // $ANTLR start "entryRuleAttributeReverse"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4208:1: entryRuleAttributeReverse returns [EObject current=null] : iv_ruleAttributeReverse= ruleAttributeReverse EOF ;
    public final EObject entryRuleAttributeReverse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReverse = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4209:2: (iv_ruleAttributeReverse= ruleAttributeReverse EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4210:2: iv_ruleAttributeReverse= ruleAttributeReverse EOF
            {
             newCompositeNode(grammarAccess.getAttributeReverseRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse9283);
            iv_ruleAttributeReverse=ruleAttributeReverse();

            state._fsp--;

             current =iv_ruleAttributeReverse; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeReverse9293); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeReverse"


    // $ANTLR start "ruleAttributeReverse"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4217:1: ruleAttributeReverse returns [EObject current=null] : (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeReverse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4220:28: ( (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4221:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4221:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4221:3: otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleAttributeReverse9330); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeReverseAccess().getReverseKeyword_0());
                
            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeReverse9342); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeReverseAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4229:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4230:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4230:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4231:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeReverseRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeReverse9362); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeReverseAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleAttributeReverse9374); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeReverseAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeReverse"


    // $ANTLR start "entryRuleAttributeOperation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4254:1: entryRuleAttributeOperation returns [EObject current=null] : iv_ruleAttributeOperation= ruleAttributeOperation EOF ;
    public final EObject entryRuleAttributeOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeOperation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4255:2: (iv_ruleAttributeOperation= ruleAttributeOperation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4256:2: iv_ruleAttributeOperation= ruleAttributeOperation EOF
            {
             newCompositeNode(grammarAccess.getAttributeOperationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeOperation_in_entryRuleAttributeOperation9410);
            iv_ruleAttributeOperation=ruleAttributeOperation();

            state._fsp--;

             current =iv_ruleAttributeOperation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeOperation9420); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttributeOperation"


    // $ANTLR start "ruleAttributeOperation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4263:1: ruleAttributeOperation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) ;
    public final EObject ruleAttributeOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_operator_1_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4266:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4267:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4267:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4267:2: ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4267:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4268:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4268:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4269:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeOperationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeOperation9465); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeOperationAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4280:2: ( (lv_operator_1_0= ruleArithmeticOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4281:1: (lv_operator_1_0= ruleArithmeticOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4281:1: (lv_operator_1_0= ruleArithmeticOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4282:3: lv_operator_1_0= ruleArithmeticOperator
            {
             
            	        newCompositeNode(grammarAccess.getAttributeOperationAccess().getOperatorArithmeticOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleArithmeticOperator_in_ruleAttributeOperation9486);
            lv_operator_1_0=ruleArithmeticOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeOperationRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"ArithmeticOperator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4298:2: ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4299:1: (lv_value_2_0= ruleAttributeEvaluationType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4299:1: (lv_value_2_0= ruleAttributeEvaluationType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4300:3: lv_value_2_0= ruleAttributeEvaluationType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeOperationAccess().getValueAttributeEvaluationTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeOperation9507);
            lv_value_2_0=ruleAttributeEvaluationType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeOperationRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"AttributeEvaluationType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttributeOperation"


    // $ANTLR start "entryRuleReferenceSet"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4324:1: entryRuleReferenceSet returns [EObject current=null] : iv_ruleReferenceSet= ruleReferenceSet EOF ;
    public final EObject entryRuleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSet = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4325:2: (iv_ruleReferenceSet= ruleReferenceSet EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4326:2: iv_ruleReferenceSet= ruleReferenceSet EOF
            {
             newCompositeNode(grammarAccess.getReferenceSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet9543);
            iv_ruleReferenceSet=ruleReferenceSet();

            state._fsp--;

             current =iv_ruleReferenceSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSet9553); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceSet"


    // $ANTLR start "ruleReferenceSet"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4333:1: ruleReferenceSet returns [EObject current=null] : (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove ) ;
    public final EObject ruleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceInit_0 = null;

        EObject this_ReferenceSwap_1 = null;

        EObject this_ReferenceAtt_2 = null;

        EObject this_ReferenceAdd_3 = null;

        EObject this_ReferenceRemove_4 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4336:28: ( (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4337:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4337:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt | this_ReferenceAdd_3= ruleReferenceAdd | this_ReferenceRemove_4= ruleReferenceRemove )
            int alt91=5;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    alt91=1;
                    }
                    break;
                case 33:
                    {
                    alt91=5;
                    }
                    break;
                case 34:
                    {
                    alt91=3;
                    }
                    break;
                case 61:
                    {
                    alt91=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 91, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA91_0==62) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4338:5: this_ReferenceInit_0= ruleReferenceInit
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceInitParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_ruleReferenceSet9600);
                    this_ReferenceInit_0=ruleReferenceInit();

                    state._fsp--;

                     
                            current = this_ReferenceInit_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4348:5: this_ReferenceSwap_1= ruleReferenceSwap
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceSwapParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_ruleReferenceSet9627);
                    this_ReferenceSwap_1=ruleReferenceSwap();

                    state._fsp--;

                     
                            current = this_ReferenceSwap_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4358:5: this_ReferenceAtt_2= ruleReferenceAtt
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceAttParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceAtt_in_ruleReferenceSet9654);
                    this_ReferenceAtt_2=ruleReferenceAtt();

                    state._fsp--;

                     
                            current = this_ReferenceAtt_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4368:5: this_ReferenceAdd_3= ruleReferenceAdd
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceAddParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceAdd_in_ruleReferenceSet9681);
                    this_ReferenceAdd_3=ruleReferenceAdd();

                    state._fsp--;

                     
                            current = this_ReferenceAdd_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4378:5: this_ReferenceRemove_4= ruleReferenceRemove
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceRemoveParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceRemove_in_ruleReferenceSet9708);
                    this_ReferenceRemove_4=ruleReferenceRemove();

                    state._fsp--;

                     
                            current = this_ReferenceRemove_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceSet"


    // $ANTLR start "entryRuleReferenceInit"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4394:1: entryRuleReferenceInit returns [EObject current=null] : iv_ruleReferenceInit= ruleReferenceInit EOF ;
    public final EObject entryRuleReferenceInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceInit = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4395:2: (iv_ruleReferenceInit= ruleReferenceInit EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4396:2: iv_ruleReferenceInit= ruleReferenceInit EOF
            {
             newCompositeNode(grammarAccess.getReferenceInitRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit9743);
            iv_ruleReferenceInit=ruleReferenceInit();

            state._fsp--;

             current =iv_ruleReferenceInit; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceInit9753); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceInit"


    // $ANTLR start "ruleReferenceInit"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4403:1: ruleReferenceInit returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) ) ;
    public final EObject ruleReferenceInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_object_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4406:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4407:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4407:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4407:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4407:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4408:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4408:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4409:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceInitRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceInit9798); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceInitAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleReferenceInit9810); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceInitAccess().getEqualsSignKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4424:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4425:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4425:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4426:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getReferenceInitAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit9831);
            lv_object_2_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceInitRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_2_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceInit"


    // $ANTLR start "entryRuleReferenceAdd"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4450:1: entryRuleReferenceAdd returns [EObject current=null] : iv_ruleReferenceAdd= ruleReferenceAdd EOF ;
    public final EObject entryRuleReferenceAdd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAdd = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4451:2: (iv_ruleReferenceAdd= ruleReferenceAdd EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4452:2: iv_ruleReferenceAdd= ruleReferenceAdd EOF
            {
             newCompositeNode(grammarAccess.getReferenceAddRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceAdd_in_entryRuleReferenceAdd9867);
            iv_ruleReferenceAdd=ruleReferenceAdd();

            state._fsp--;

             current =iv_ruleReferenceAdd; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceAdd9877); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceAdd"


    // $ANTLR start "ruleReferenceAdd"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4459:1: ruleReferenceAdd returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) ;
    public final EObject ruleReferenceAdd() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_object_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4462:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4463:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4463:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4463:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '+' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4463:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4464:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4464:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4465:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAddRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAdd9922); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceAddAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleReferenceAdd9934); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAddAccess().getPlusSignKeyword_1());
                
            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleReferenceAdd9946); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceAddAccess().getEqualsSignKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4484:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4485:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4485:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4486:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getReferenceAddAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceAdd9967);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceAddRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_3_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceAdd"


    // $ANTLR start "entryRuleReferenceRemove"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4510:1: entryRuleReferenceRemove returns [EObject current=null] : iv_ruleReferenceRemove= ruleReferenceRemove EOF ;
    public final EObject entryRuleReferenceRemove() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceRemove = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4511:2: (iv_ruleReferenceRemove= ruleReferenceRemove EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4512:2: iv_ruleReferenceRemove= ruleReferenceRemove EOF
            {
             newCompositeNode(grammarAccess.getReferenceRemoveRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceRemove_in_entryRuleReferenceRemove10003);
            iv_ruleReferenceRemove=ruleReferenceRemove();

            state._fsp--;

             current =iv_ruleReferenceRemove; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceRemove10013); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceRemove"


    // $ANTLR start "ruleReferenceRemove"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4519:1: ruleReferenceRemove returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) ;
    public final EObject ruleReferenceRemove() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_object_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4522:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4523:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4523:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4523:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '-' otherlv_2= '=' ( (lv_object_3_0= ruleObSelectionStrategy ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4523:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4524:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4524:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4525:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceRemoveRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceRemove10058); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceRemoveAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleReferenceRemove10070); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceRemoveAccess().getHyphenMinusKeyword_1());
                
            otherlv_2=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleReferenceRemove10082); 

                	newLeafNode(otherlv_2, grammarAccess.getReferenceRemoveAccess().getEqualsSignKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4544:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4545:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4545:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4546:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getReferenceRemoveAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceRemove10103);
            lv_object_3_0=ruleObSelectionStrategy();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceRemoveRule());
            	        }
                   		set(
                   			current, 
                   			"object",
                    		lv_object_3_0, 
                    		"ObSelectionStrategy");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceRemove"


    // $ANTLR start "entryRuleReferenceSwap"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4570:1: entryRuleReferenceSwap returns [EObject current=null] : iv_ruleReferenceSwap= ruleReferenceSwap EOF ;
    public final EObject entryRuleReferenceSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSwap = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4571:2: (iv_ruleReferenceSwap= ruleReferenceSwap EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4572:2: iv_ruleReferenceSwap= ruleReferenceSwap EOF
            {
             newCompositeNode(grammarAccess.getReferenceSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap10139);
            iv_ruleReferenceSwap=ruleReferenceSwap();

            state._fsp--;

             current =iv_ruleReferenceSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSwap10149); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceSwap"


    // $ANTLR start "ruleReferenceSwap"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4579:1: ruleReferenceSwap returns [EObject current=null] : (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
    public final EObject ruleReferenceSwap() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4582:28: ( (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4583:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4583:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4583:3: otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleReferenceSwap10186); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceSwapAccess().getSwaprefKeyword_0());
                
            otherlv_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleReferenceSwap10198); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4591:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4592:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4592:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4593:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap10218); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleReferenceSwap10230); 

                	newLeafNode(otherlv_3, grammarAccess.getReferenceSwapAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==43||LA92_0==45||(LA92_0>=64 && LA92_0<=65)) ) {
                alt92=1;
            }
            else if ( (LA92_0==RULE_ID) ) {
                int LA92_2 = input.LA(2);

                if ( (LA92_2==40||LA92_2==63) ) {
                    alt92=1;
                }
            }
            switch (alt92) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4609:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4609:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4610:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap10252);
                    lv_object_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceSwapRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleReferenceSwap10264); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceSwapAccess().getHyphenMinusGreaterThanSignKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4630:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4631:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4631:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4632:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap10286); 

            		newLeafNode(otherlv_6, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleReferenceSwap10298); 

                	newLeafNode(otherlv_7, grammarAccess.getReferenceSwapAccess().getRightParenthesisKeyword_6());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceSwap"


    // $ANTLR start "entryRuleReferenceAtt"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4655:1: entryRuleReferenceAtt returns [EObject current=null] : iv_ruleReferenceAtt= ruleReferenceAtt EOF ;
    public final EObject entryRuleReferenceAtt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAtt = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4656:2: (iv_ruleReferenceAtt= ruleReferenceAtt EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4657:2: iv_ruleReferenceAtt= ruleReferenceAtt EOF
            {
             newCompositeNode(grammarAccess.getReferenceAttRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceAtt_in_entryRuleReferenceAtt10334);
            iv_ruleReferenceAtt=ruleReferenceAtt();

            state._fsp--;

             current =iv_ruleReferenceAtt; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceAtt10344); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceAtt"


    // $ANTLR start "ruleReferenceAtt"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4664:1: ruleReferenceAtt returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) ;
    public final EObject ruleReferenceAtt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4667:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4668:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4668:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4668:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4668:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4669:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4669:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4670:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAttRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAtt10389); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceAttAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleReferenceAtt10401); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAttAccess().getFullStopKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4685:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4686:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4686:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4687:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAttRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAtt10421); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAttAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4698:2: ( (lv_value_3_0= ruleAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4699:1: (lv_value_3_0= ruleAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4699:1: (lv_value_3_0= ruleAttributeType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4700:3: lv_value_3_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getReferenceAttAccess().getValueAttributeTypeParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleReferenceAtt10442);
            lv_value_3_0=ruleAttributeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceAttRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"AttributeType");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceAtt"


    // $ANTLR start "entryRuleRandomTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4724:1: entryRuleRandomTypeSelection returns [EObject current=null] : iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF ;
    public final EObject entryRuleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4725:2: (iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4726:2: iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection10478);
            iv_ruleRandomTypeSelection=ruleRandomTypeSelection();

            state._fsp--;

             current =iv_ruleRandomTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomTypeSelection10488); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomTypeSelection"


    // $ANTLR start "ruleRandomTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4733:1: ruleRandomTypeSelection returns [EObject current=null] : ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) ;
    public final EObject ruleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_expression_7_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4736:28: ( ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4737:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4737:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4737:2: () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4737:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4738:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomTypeSelectionAccess().getRandomTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRandomTypeSelection10534); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomTypeSelectionAccess().getOneKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4747:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4748:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4748:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4749:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomTypeSelection10554); 

            		newLeafNode(otherlv_2, grammarAccess.getRandomTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4760:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==40) ) {
                int LA93_1 = input.LA(2);

                if ( (LA93_1==RULE_ID) ) {
                    int LA93_3 = input.LA(3);

                    if ( (LA93_3==EOF||LA93_3==RULE_ID||LA93_3==11||LA93_3==14||(LA93_3>=22 && LA93_3<=24)||LA93_3==27||LA93_3==29||LA93_3==34||LA93_3==40||LA93_3==42||LA93_3==46||(LA93_3>=49 && LA93_3<=50)||LA93_3==53||LA93_3==63||(LA93_3>=79 && LA93_3<=80)) ) {
                        alt93=1;
                    }
                }
            }
            switch (alt93) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4760:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRandomTypeSelection10567); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4764:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4765:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4765:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4766:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomTypeSelection10587); 

                    		newLeafNode(otherlv_4, grammarAccess.getRandomTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4777:4: (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==63) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4777:6: otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleRandomTypeSelection10602); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomTypeSelectionAccess().getWhereKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRandomTypeSelection10614); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4785:1: ( (lv_expression_7_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4786:1: (lv_expression_7_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4786:1: (lv_expression_7_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4787:3: lv_expression_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRandomTypeSelection10635);
                    lv_expression_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_7_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRandomTypeSelection10647); 

                        	newLeafNode(otherlv_8, grammarAccess.getRandomTypeSelectionAccess().getRightCurlyBracketKeyword_4_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomTypeSelection"


    // $ANTLR start "entryRuleSpecificObjectSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4815:1: entryRuleSpecificObjectSelection returns [EObject current=null] : iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF ;
    public final EObject entryRuleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificObjectSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4816:2: (iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4817:2: iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificObjectSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection10685);
            iv_ruleSpecificObjectSelection=ruleSpecificObjectSelection();

            state._fsp--;

             current =iv_ruleSpecificObjectSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificObjectSelection10695); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificObjectSelection"


    // $ANTLR start "ruleSpecificObjectSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4824:1: ruleSpecificObjectSelection returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? ) ;
    public final EObject ruleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_expression_6_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4827:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4828:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4828:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4828:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4828:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4829:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificObjectSelectionAccess().getSpecificObjectSelectionAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4834:2: ( (otherlv_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4835:1: (otherlv_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4835:1: (otherlv_1= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4836:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10749); 

            		newLeafNode(otherlv_1, grammarAccess.getSpecificObjectSelectionAccess().getObjSelObjectEmitterCrossReference_1_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4847:2: (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==40) ) {
                int LA95_1 = input.LA(2);

                if ( (LA95_1==RULE_ID) ) {
                    int LA95_3 = input.LA(3);

                    if ( (LA95_3==EOF||LA95_3==RULE_ID||LA95_3==11||LA95_3==14||(LA95_3>=22 && LA95_3<=24)||LA95_3==27||LA95_3==29||LA95_3==34||LA95_3==40||LA95_3==42||LA95_3==46||(LA95_3>=49 && LA95_3<=50)||LA95_3==53||LA95_3==63||(LA95_3>=79 && LA95_3<=80)) ) {
                        alt95=1;
                    }
                }
            }
            switch (alt95) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4847:4: otherlv_2= '->' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSpecificObjectSelection10762); 

                        	newLeafNode(otherlv_2, grammarAccess.getSpecificObjectSelectionAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4851:1: ( (otherlv_3= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4852:1: (otherlv_3= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4852:1: (otherlv_3= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4853:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10782); 

                    		newLeafNode(otherlv_3, grammarAccess.getSpecificObjectSelectionAccess().getRefTypeEReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4864:4: (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==63) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4864:6: otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleSpecificObjectSelection10797); 

                        	newLeafNode(otherlv_4, grammarAccess.getSpecificObjectSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpecificObjectSelection10809); 

                        	newLeafNode(otherlv_5, grammarAccess.getSpecificObjectSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4872:1: ( (lv_expression_6_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4873:1: (lv_expression_6_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4873:1: (lv_expression_6_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4874:3: lv_expression_6_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificObjectSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSpecificObjectSelection10830);
                    lv_expression_6_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificObjectSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_6_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSpecificObjectSelection10842); 

                        	newLeafNode(otherlv_7, grammarAccess.getSpecificObjectSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificObjectSelection"


    // $ANTLR start "entryRuleSpecificClosureSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4902:1: entryRuleSpecificClosureSelection returns [EObject current=null] : iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF ;
    public final EObject entryRuleSpecificClosureSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificClosureSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4903:2: (iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4904:2: iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificClosureSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificClosureSelection_in_entryRuleSpecificClosureSelection10880);
            iv_ruleSpecificClosureSelection=ruleSpecificClosureSelection();

            state._fsp--;

             current =iv_ruleSpecificClosureSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificClosureSelection10890); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificClosureSelection"


    // $ANTLR start "ruleSpecificClosureSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4911:1: ruleSpecificClosureSelection returns [EObject current=null] : ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? ) ;
    public final EObject ruleSpecificClosureSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_expression_9_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4914:28: ( ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4915:1: ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4915:1: ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4915:2: () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4915:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4916:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificClosureSelectionAccess().getSpecificClosureSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleSpecificClosureSelection10936); 

                	newLeafNode(otherlv_1, grammarAccess.getSpecificClosureSelectionAccess().getClosureKeyword_1());
                
            otherlv_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSpecificClosureSelection10948); 

                	newLeafNode(otherlv_2, grammarAccess.getSpecificClosureSelectionAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4929:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4930:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4930:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4931:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificClosureSelection10968); 

            		newLeafNode(otherlv_3, grammarAccess.getSpecificClosureSelectionAccess().getObjSelObjectEmitterCrossReference_3_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4942:2: (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==40) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4942:4: otherlv_4= '->' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSpecificClosureSelection10981); 

                        	newLeafNode(otherlv_4, grammarAccess.getSpecificClosureSelectionAccess().getHyphenMinusGreaterThanSignKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4946:1: ( (otherlv_5= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4947:1: (otherlv_5= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4947:1: (otherlv_5= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4948:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificClosureSelection11001); 

                    		newLeafNode(otherlv_5, grammarAccess.getSpecificClosureSelectionAccess().getRefTypeEReferenceCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleSpecificClosureSelection11015); 

                	newLeafNode(otherlv_6, grammarAccess.getSpecificClosureSelectionAccess().getRightParenthesisKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4963:1: (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==63) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4963:3: otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleSpecificClosureSelection11028); 

                        	newLeafNode(otherlv_7, grammarAccess.getSpecificClosureSelectionAccess().getWhereKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpecificClosureSelection11040); 

                        	newLeafNode(otherlv_8, grammarAccess.getSpecificClosureSelectionAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4971:1: ( (lv_expression_9_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4972:1: (lv_expression_9_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4972:1: (lv_expression_9_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4973:3: lv_expression_9_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificClosureSelectionAccess().getExpressionExpressionParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSpecificClosureSelection11061);
                    lv_expression_9_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificClosureSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_9_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSpecificClosureSelection11073); 

                        	newLeafNode(otherlv_10, grammarAccess.getSpecificClosureSelectionAccess().getRightCurlyBracketKeyword_6_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificClosureSelection"


    // $ANTLR start "entryRuleCompleteTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5001:1: entryRuleCompleteTypeSelection returns [EObject current=null] : iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF ;
    public final EObject entryRuleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5002:2: (iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5003:2: iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection11111);
            iv_ruleCompleteTypeSelection=ruleCompleteTypeSelection();

            state._fsp--;

             current =iv_ruleCompleteTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompleteTypeSelection11121); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompleteTypeSelection"


    // $ANTLR start "ruleCompleteTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5010:1: ruleCompleteTypeSelection returns [EObject current=null] : ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) ;
    public final EObject ruleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_expression_7_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5013:28: ( ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5014:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5014:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5014:2: () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5014:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5015:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCompleteTypeSelectionAccess().getCompleteTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCompleteTypeSelection11167); 

                	newLeafNode(otherlv_1, grammarAccess.getCompleteTypeSelectionAccess().getAllKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5024:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5025:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5025:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5026:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompleteTypeSelection11187); 

            		newLeafNode(otherlv_2, grammarAccess.getCompleteTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5037:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==40) ) {
                int LA99_1 = input.LA(2);

                if ( (LA99_1==RULE_ID) ) {
                    int LA99_3 = input.LA(3);

                    if ( (LA99_3==EOF||LA99_3==RULE_ID||LA99_3==11||LA99_3==14||(LA99_3>=22 && LA99_3<=24)||LA99_3==27||LA99_3==29||LA99_3==34||LA99_3==40||LA99_3==42||LA99_3==46||(LA99_3>=49 && LA99_3<=50)||LA99_3==53||LA99_3==63||(LA99_3>=79 && LA99_3<=80)) ) {
                        alt99=1;
                    }
                }
            }
            switch (alt99) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5037:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleCompleteTypeSelection11200); 

                        	newLeafNode(otherlv_3, grammarAccess.getCompleteTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5041:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5042:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5042:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5043:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompleteTypeSelection11220); 

                    		newLeafNode(otherlv_4, grammarAccess.getCompleteTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5054:4: (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==63) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5054:6: otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleCompleteTypeSelection11235); 

                        	newLeafNode(otherlv_5, grammarAccess.getCompleteTypeSelectionAccess().getWhereKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCompleteTypeSelection11247); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompleteTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5062:1: ( (lv_expression_7_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5063:1: (lv_expression_7_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5063:1: (lv_expression_7_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5064:3: lv_expression_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompleteTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleCompleteTypeSelection11268);
                    lv_expression_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCompleteTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_7_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCompleteTypeSelection11280); 

                        	newLeafNode(otherlv_8, grammarAccess.getCompleteTypeSelectionAccess().getRightCurlyBracketKeyword_4_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompleteTypeSelection"


    // $ANTLR start "entryRuleOtherTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5092:1: entryRuleOtherTypeSelection returns [EObject current=null] : iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF ;
    public final EObject entryRuleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5093:2: (iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5094:2: iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection11318);
            iv_ruleOtherTypeSelection=ruleOtherTypeSelection();

            state._fsp--;

             current =iv_ruleOtherTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOtherTypeSelection11328); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherTypeSelection"


    // $ANTLR start "ruleOtherTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5101:1: ruleOtherTypeSelection returns [EObject current=null] : ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) ;
    public final EObject ruleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        EObject lv_expression_7_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5104:28: ( ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5105:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5105:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5105:2: () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5105:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5106:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOtherTypeSelectionAccess().getOtherTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleOtherTypeSelection11374); 

                	newLeafNode(otherlv_1, grammarAccess.getOtherTypeSelectionAccess().getOtherKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5115:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5116:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5116:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5117:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOtherTypeSelection11394); 

            		newLeafNode(otherlv_2, grammarAccess.getOtherTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5128:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==40) ) {
                int LA101_1 = input.LA(2);

                if ( (LA101_1==RULE_ID) ) {
                    int LA101_3 = input.LA(3);

                    if ( (LA101_3==EOF||LA101_3==RULE_ID||LA101_3==11||LA101_3==14||(LA101_3>=22 && LA101_3<=24)||LA101_3==27||LA101_3==29||LA101_3==34||LA101_3==40||LA101_3==42||LA101_3==46||(LA101_3>=49 && LA101_3<=50)||LA101_3==53||LA101_3==63||(LA101_3>=79 && LA101_3<=80)) ) {
                        alt101=1;
                    }
                }
            }
            switch (alt101) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5128:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleOtherTypeSelection11407); 

                        	newLeafNode(otherlv_3, grammarAccess.getOtherTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5132:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5133:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5133:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5134:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOtherTypeSelection11427); 

                    		newLeafNode(otherlv_4, grammarAccess.getOtherTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5145:4: (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==63) ) {
                alt102=1;
            }
            switch (alt102) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5145:6: otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleOtherTypeSelection11442); 

                        	newLeafNode(otherlv_5, grammarAccess.getOtherTypeSelectionAccess().getWhereKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOtherTypeSelection11454); 

                        	newLeafNode(otherlv_6, grammarAccess.getOtherTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5153:1: ( (lv_expression_7_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5154:1: (lv_expression_7_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5154:1: (lv_expression_7_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5155:3: lv_expression_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOtherTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleOtherTypeSelection11475);
                    lv_expression_7_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOtherTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_7_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOtherTypeSelection11487); 

                        	newLeafNode(otherlv_8, grammarAccess.getOtherTypeSelectionAccess().getRightCurlyBracketKeyword_4_3());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherTypeSelection"


    // $ANTLR start "entryRuleBooleanType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5183:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5184:2: (iv_ruleBooleanType= ruleBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5185:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_entryRuleBooleanType11525);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanType11535); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanType"


    // $ANTLR start "ruleBooleanType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5192:1: ruleBooleanType returns [EObject current=null] : (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificBooleanType_0 = null;

        EObject this_RandomBooleanType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5195:28: ( (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5196:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5196:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            int alt103=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA103_1 = input.LA(2);

                if ( (LA103_1==66) ) {
                    alt103=2;
                }
                else if ( ((LA103_1>=37 && LA103_1<=38)) ) {
                    alt103=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 1, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA103_2 = input.LA(2);

                if ( ((LA103_2>=37 && LA103_2<=38)) ) {
                    alt103=1;
                }
                else if ( (LA103_2==66) ) {
                    alt103=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA103_3 = input.LA(2);

                if ( (LA103_3==66) ) {
                    alt103=2;
                }
                else if ( ((LA103_3>=37 && LA103_3<=38)) ) {
                    alt103=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 103, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5197:5: this_SpecificBooleanType_0= ruleSpecificBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getSpecificBooleanTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType11582);
                    this_SpecificBooleanType_0=ruleSpecificBooleanType();

                    state._fsp--;

                     
                            current = this_SpecificBooleanType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5207:5: this_RandomBooleanType_1= ruleRandomBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getRandomBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_ruleBooleanType11609);
                    this_RandomBooleanType_1=ruleRandomBooleanType();

                    state._fsp--;

                     
                            current = this_RandomBooleanType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanType"


    // $ANTLR start "entryRuleRandomBooleanType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5223:1: entryRuleRandomBooleanType returns [EObject current=null] : iv_ruleRandomBooleanType= ruleRandomBooleanType EOF ;
    public final EObject entryRuleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5224:2: (iv_ruleRandomBooleanType= ruleRandomBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5225:2: iv_ruleRandomBooleanType= ruleRandomBooleanType EOF
            {
             newCompositeNode(grammarAccess.getRandomBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType11644);
            iv_ruleRandomBooleanType=ruleRandomBooleanType();

            state._fsp--;

             current =iv_ruleRandomBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomBooleanType11654); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomBooleanType"


    // $ANTLR start "ruleRandomBooleanType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5232:1: ruleRandomBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) ;
    public final EObject ruleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5235:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5236:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5236:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5236:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5236:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5237:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomBooleanTypeAccess().getRandomBooleanTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5242:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5243:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5243:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5244:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomBooleanType11709);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomBooleanTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleRandomBooleanType11721); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomBooleanTypeAccess().getRandomBooleanKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomBooleanType"


    // $ANTLR start "entryRuleSpecificBooleanType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5272:1: entryRuleSpecificBooleanType returns [EObject current=null] : iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF ;
    public final EObject entryRuleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5273:2: (iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5274:2: iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF
            {
             newCompositeNode(grammarAccess.getSpecificBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType11757);
            iv_ruleSpecificBooleanType=ruleSpecificBooleanType();

            state._fsp--;

             current =iv_ruleSpecificBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificBooleanType11767); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificBooleanType"


    // $ANTLR start "ruleSpecificBooleanType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5281:1: ruleSpecificBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) ;
    public final EObject ruleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5284:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5285:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5285:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5285:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5285:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5286:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificBooleanTypeAccess().getSpecificBooleanTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5291:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5292:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5292:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5293:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificBooleanType11822);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificBooleanTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5309:2: ( (lv_value_2_0= ruleEBoolean ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5310:1: (lv_value_2_0= ruleEBoolean )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5310:1: (lv_value_2_0= ruleEBoolean )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5311:3: lv_value_2_0= ruleEBoolean
            {
             
            	        newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getValueEBooleanParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType11843);
            lv_value_2_0=ruleEBoolean();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificBooleanTypeRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"EBoolean");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificBooleanType"


    // $ANTLR start "entryRuleStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5335:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5336:2: (iv_ruleStringType= ruleStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5337:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringType_in_entryRuleStringType11879);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringType11889); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringType"


    // $ANTLR start "ruleStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5344:1: ruleStringType returns [EObject current=null] : (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) ;
    public final EObject ruleStringType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificStringType_0 = null;

        EObject this_RandomStringType_1 = null;

        EObject this_UpperStringType_2 = null;

        EObject this_LowerStringType_3 = null;

        EObject this_CatStartStringType_4 = null;

        EObject this_CatEndStringType_5 = null;

        EObject this_ReplaceStringType_6 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5347:28: ( (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5348:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5348:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            int alt104=7;
            alt104 = dfa104.predict(input);
            switch (alt104) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5349:5: this_SpecificStringType_0= ruleSpecificStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getSpecificStringTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_ruleStringType11936);
                    this_SpecificStringType_0=ruleSpecificStringType();

                    state._fsp--;

                     
                            current = this_SpecificStringType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5359:5: this_RandomStringType_1= ruleRandomStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getRandomStringTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_ruleStringType11963);
                    this_RandomStringType_1=ruleRandomStringType();

                    state._fsp--;

                     
                            current = this_RandomStringType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5369:5: this_UpperStringType_2= ruleUpperStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getUpperStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_ruleStringType11990);
                    this_UpperStringType_2=ruleUpperStringType();

                    state._fsp--;

                     
                            current = this_UpperStringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5379:5: this_LowerStringType_3= ruleLowerStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getLowerStringTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_ruleStringType12017);
                    this_LowerStringType_3=ruleLowerStringType();

                    state._fsp--;

                     
                            current = this_LowerStringType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5389:5: this_CatStartStringType_4= ruleCatStartStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatStartStringTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_ruleStringType12044);
                    this_CatStartStringType_4=ruleCatStartStringType();

                    state._fsp--;

                     
                            current = this_CatStartStringType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5399:5: this_CatEndStringType_5= ruleCatEndStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatEndStringTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_ruleStringType12071);
                    this_CatEndStringType_5=ruleCatEndStringType();

                    state._fsp--;

                     
                            current = this_CatEndStringType_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5409:5: this_ReplaceStringType_6= ruleReplaceStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getReplaceStringTypeParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_ruleStringType12098);
                    this_ReplaceStringType_6=ruleReplaceStringType();

                    state._fsp--;

                     
                            current = this_ReplaceStringType_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringType"


    // $ANTLR start "entryRuleRandomStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5425:1: entryRuleRandomStringType returns [EObject current=null] : iv_ruleRandomStringType= ruleRandomStringType EOF ;
    public final EObject entryRuleRandomStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5426:2: (iv_ruleRandomStringType= ruleRandomStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5427:2: iv_ruleRandomStringType= ruleRandomStringType EOF
            {
             newCompositeNode(grammarAccess.getRandomStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType12133);
            iv_ruleRandomStringType=ruleRandomStringType();

            state._fsp--;

             current =iv_ruleRandomStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomStringType12143); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomStringType"


    // $ANTLR start "ruleRandomStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5434:1: ruleRandomStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) ;
    public final EObject ruleRandomStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_min_4_0 = null;

        AntlrDatatypeRuleToken lv_max_6_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5437:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5438:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5438:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5438:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5438:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5439:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomStringTypeAccess().getRandomStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5444:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5445:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5445:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5446:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomStringType12198);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleRandomStringType12210); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomStringTypeAccess().getRandomStringKeyword_2());
                
            otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomStringType12222); 

                	newLeafNode(otherlv_3, grammarAccess.getRandomStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5470:1: ( (lv_min_4_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5471:1: (lv_min_4_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5471:1: (lv_min_4_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5472:3: lv_min_4_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMinEIntParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType12243);
            lv_min_4_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"min",
                    		lv_min_4_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomStringType12255); 

                	newLeafNode(otherlv_5, grammarAccess.getRandomStringTypeAccess().getCommaKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5492:1: ( (lv_max_6_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5493:1: (lv_max_6_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5493:1: (lv_max_6_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5494:3: lv_max_6_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMaxEIntParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType12276);
            lv_max_6_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"max",
                    		lv_max_6_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleRandomStringType12288); 

                	newLeafNode(otherlv_7, grammarAccess.getRandomStringTypeAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomStringType"


    // $ANTLR start "entryRuleSpecificStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5522:1: entryRuleSpecificStringType returns [EObject current=null] : iv_ruleSpecificStringType= ruleSpecificStringType EOF ;
    public final EObject entryRuleSpecificStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5523:2: (iv_ruleSpecificStringType= ruleSpecificStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5524:2: iv_ruleSpecificStringType= ruleSpecificStringType EOF
            {
             newCompositeNode(grammarAccess.getSpecificStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType12324);
            iv_ruleSpecificStringType=ruleSpecificStringType();

            state._fsp--;

             current =iv_ruleSpecificStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificStringType12334); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificStringType"


    // $ANTLR start "ruleSpecificStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5531:1: ruleSpecificStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSpecificStringType() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5534:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5535:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5535:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5535:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5535:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5536:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificStringTypeAccess().getSpecificStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5541:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5542:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5542:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5543:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificStringType12389);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5559:2: ( (lv_value_2_0= RULE_STRING ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5560:1: (lv_value_2_0= RULE_STRING )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5560:1: (lv_value_2_0= RULE_STRING )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5561:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSpecificStringType12406); 

            			newLeafNode(lv_value_2_0, grammarAccess.getSpecificStringTypeAccess().getValueSTRINGTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificStringTypeRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"STRING");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificStringType"


    // $ANTLR start "entryRuleUpperStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5585:1: entryRuleUpperStringType returns [EObject current=null] : iv_ruleUpperStringType= ruleUpperStringType EOF ;
    public final EObject entryRuleUpperStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5586:2: (iv_ruleUpperStringType= ruleUpperStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5587:2: iv_ruleUpperStringType= ruleUpperStringType EOF
            {
             newCompositeNode(grammarAccess.getUpperStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType12447);
            iv_ruleUpperStringType=ruleUpperStringType();

            state._fsp--;

             current =iv_ruleUpperStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUpperStringType12457); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUpperStringType"


    // $ANTLR start "ruleUpperStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5594:1: ruleUpperStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) ;
    public final EObject ruleUpperStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5597:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5598:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5598:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5598:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5598:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5599:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUpperStringTypeAccess().getUpperStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5604:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5605:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5605:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5606:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getUpperStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleUpperStringType12512);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getUpperStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleUpperStringType12524); 

                	newLeafNode(otherlv_2, grammarAccess.getUpperStringTypeAccess().getUpperKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUpperStringType"


    // $ANTLR start "entryRuleCatStartStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5634:1: entryRuleCatStartStringType returns [EObject current=null] : iv_ruleCatStartStringType= ruleCatStartStringType EOF ;
    public final EObject entryRuleCatStartStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatStartStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5635:2: (iv_ruleCatStartStringType= ruleCatStartStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5636:2: iv_ruleCatStartStringType= ruleCatStartStringType EOF
            {
             newCompositeNode(grammarAccess.getCatStartStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType12560);
            iv_ruleCatStartStringType=ruleCatStartStringType();

            state._fsp--;

             current =iv_ruleCatStartStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatStartStringType12570); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCatStartStringType"


    // $ANTLR start "ruleCatStartStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5643:1: ruleCatStartStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatStartStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5646:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5647:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5647:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5647:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5647:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5648:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatStartStringTypeAccess().getCatStartStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5653:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5654:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5654:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5655:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleCatStartStringType12625);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCatStartStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCatStartStringType12637); 

                	newLeafNode(otherlv_2, grammarAccess.getCatStartStringTypeAccess().getCatstartKeyword_2());
                
            otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCatStartStringType12649); 

                	newLeafNode(otherlv_3, grammarAccess.getCatStartStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5679:1: ( (lv_value_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5680:1: (lv_value_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5680:1: (lv_value_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5681:3: lv_value_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getValueEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatStartStringType12670);
            lv_value_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCatStartStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleCatStartStringType12682); 

                	newLeafNode(otherlv_5, grammarAccess.getCatStartStringTypeAccess().getRightParenthesisKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCatStartStringType"


    // $ANTLR start "entryRuleCatEndStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5709:1: entryRuleCatEndStringType returns [EObject current=null] : iv_ruleCatEndStringType= ruleCatEndStringType EOF ;
    public final EObject entryRuleCatEndStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatEndStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5710:2: (iv_ruleCatEndStringType= ruleCatEndStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5711:2: iv_ruleCatEndStringType= ruleCatEndStringType EOF
            {
             newCompositeNode(grammarAccess.getCatEndStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType12718);
            iv_ruleCatEndStringType=ruleCatEndStringType();

            state._fsp--;

             current =iv_ruleCatEndStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatEndStringType12728); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCatEndStringType"


    // $ANTLR start "ruleCatEndStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5718:1: ruleCatEndStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatEndStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5721:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5722:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5722:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5722:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5722:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5723:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatEndStringTypeAccess().getCatEndStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5728:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5729:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5729:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5730:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleCatEndStringType12783);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCatEndStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleCatEndStringType12795); 

                	newLeafNode(otherlv_2, grammarAccess.getCatEndStringTypeAccess().getCatendKeyword_2());
                
            otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCatEndStringType12807); 

                	newLeafNode(otherlv_3, grammarAccess.getCatEndStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5754:1: ( (lv_value_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5755:1: (lv_value_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5755:1: (lv_value_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5756:3: lv_value_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getValueEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatEndStringType12828);
            lv_value_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCatEndStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleCatEndStringType12840); 

                	newLeafNode(otherlv_5, grammarAccess.getCatEndStringTypeAccess().getRightParenthesisKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCatEndStringType"


    // $ANTLR start "entryRuleListStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5784:1: entryRuleListStringType returns [EObject current=null] : iv_ruleListStringType= ruleListStringType EOF ;
    public final EObject entryRuleListStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5785:2: (iv_ruleListStringType= ruleListStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5786:2: iv_ruleListStringType= ruleListStringType EOF
            {
             newCompositeNode(grammarAccess.getListStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_entryRuleListStringType12876);
            iv_ruleListStringType=ruleListStringType();

            state._fsp--;

             current =iv_ruleListStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListStringType12886); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListStringType"


    // $ANTLR start "ruleListStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5793:1: ruleListStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) ;
    public final EObject ruleListStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_3_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5796:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5797:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5797:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5797:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5797:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5798:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListStringTypeAccess().getListStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5803:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5804:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5804:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5805:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getListStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleListStringType12941);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleListStringType12953); 

                	newLeafNode(otherlv_2, grammarAccess.getListStringTypeAccess().getLeftSquareBracketKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5825:1: ( (lv_value_3_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5826:1: (lv_value_3_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5826:1: (lv_value_3_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5827:3: lv_value_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType12974);
            lv_value_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            	        }
                   		add(
                   			current, 
                   			"value",
                    		lv_value_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5843:2: (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )*
            loop105:
            do {
                int alt105=2;
                int LA105_0 = input.LA(1);

                if ( (LA105_0==24) ) {
                    alt105=1;
                }


                switch (alt105) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5843:4: otherlv_4= ',' ( (lv_value_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleListStringType12987); 

            	        	newLeafNode(otherlv_4, grammarAccess.getListStringTypeAccess().getCommaKeyword_4_0());
            	        
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5847:1: ( (lv_value_5_0= ruleEString ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5848:1: (lv_value_5_0= ruleEString )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5848:1: (lv_value_5_0= ruleEString )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5849:3: lv_value_5_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType13008);
            	    lv_value_5_0=ruleEString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getListStringTypeRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"value",
            	            		lv_value_5_0, 
            	            		"EString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop105;
                }
            } while (true);

            otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListStringType13022); 

                	newLeafNode(otherlv_6, grammarAccess.getListStringTypeAccess().getRightSquareBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListStringType"


    // $ANTLR start "entryRuleLowerStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5877:1: entryRuleLowerStringType returns [EObject current=null] : iv_ruleLowerStringType= ruleLowerStringType EOF ;
    public final EObject entryRuleLowerStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5878:2: (iv_ruleLowerStringType= ruleLowerStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5879:2: iv_ruleLowerStringType= ruleLowerStringType EOF
            {
             newCompositeNode(grammarAccess.getLowerStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType13058);
            iv_ruleLowerStringType=ruleLowerStringType();

            state._fsp--;

             current =iv_ruleLowerStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerStringType13068); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLowerStringType"


    // $ANTLR start "ruleLowerStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5886:1: ruleLowerStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) ;
    public final EObject ruleLowerStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5889:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5890:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5890:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5890:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5890:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5891:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLowerStringTypeAccess().getLowerStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5896:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5897:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5897:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5898:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getLowerStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleLowerStringType13123);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLowerStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleLowerStringType13135); 

                	newLeafNode(otherlv_2, grammarAccess.getLowerStringTypeAccess().getLowerKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLowerStringType"


    // $ANTLR start "entryRuleReplaceStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5926:1: entryRuleReplaceStringType returns [EObject current=null] : iv_ruleReplaceStringType= ruleReplaceStringType EOF ;
    public final EObject entryRuleReplaceStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplaceStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5927:2: (iv_ruleReplaceStringType= ruleReplaceStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5928:2: iv_ruleReplaceStringType= ruleReplaceStringType EOF
            {
             newCompositeNode(grammarAccess.getReplaceStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType13171);
            iv_ruleReplaceStringType=ruleReplaceStringType();

            state._fsp--;

             current =iv_ruleReplaceStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReplaceStringType13181); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReplaceStringType"


    // $ANTLR start "ruleReplaceStringType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5935:1: ruleReplaceStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) ;
    public final EObject ruleReplaceStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_oldstring_4_0 = null;

        AntlrDatatypeRuleToken lv_newstring_6_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5938:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5939:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5939:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5939:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5939:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5940:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReplaceStringTypeAccess().getReplaceStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5945:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5946:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5946:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5947:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleReplaceStringType13236);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleReplaceStringType13248); 

                	newLeafNode(otherlv_2, grammarAccess.getReplaceStringTypeAccess().getReplaceKeyword_2());
                
            otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleReplaceStringType13260); 

                	newLeafNode(otherlv_3, grammarAccess.getReplaceStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5971:1: ( (lv_oldstring_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5972:1: (lv_oldstring_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5972:1: (lv_oldstring_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5973:3: lv_oldstring_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOldstringEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType13281);
            lv_oldstring_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"oldstring",
                    		lv_oldstring_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleReplaceStringType13293); 

                	newLeafNode(otherlv_5, grammarAccess.getReplaceStringTypeAccess().getCommaKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5993:1: ( (lv_newstring_6_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5994:1: (lv_newstring_6_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5994:1: (lv_newstring_6_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5995:3: lv_newstring_6_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getNewstringEStringParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType13314);
            lv_newstring_6_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReplaceStringTypeRule());
            	        }
                   		set(
                   			current, 
                   			"newstring",
                    		lv_newstring_6_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleReplaceStringType13326); 

                	newLeafNode(otherlv_7, grammarAccess.getReplaceStringTypeAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReplaceStringType"


    // $ANTLR start "entryRuleDoubleType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6023:1: entryRuleDoubleType returns [EObject current=null] : iv_ruleDoubleType= ruleDoubleType EOF ;
    public final EObject entryRuleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6024:2: (iv_ruleDoubleType= ruleDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6025:2: iv_ruleDoubleType= ruleDoubleType EOF
            {
             newCompositeNode(grammarAccess.getDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_entryRuleDoubleType13362);
            iv_ruleDoubleType=ruleDoubleType();

            state._fsp--;

             current =iv_ruleDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleType13372); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDoubleType"


    // $ANTLR start "ruleDoubleType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6032:1: ruleDoubleType returns [EObject current=null] : (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) ;
    public final EObject ruleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificDoubleType_0 = null;

        EObject this_RandomDoubleType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6035:28: ( (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6036:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6036:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            int alt106=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA106_1 = input.LA(2);

                if ( (LA106_1==RULE_INT||(LA106_1>=33 && LA106_1<=34)) ) {
                    alt106=1;
                }
                else if ( (LA106_1==73) ) {
                    alt106=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 1, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA106_2 = input.LA(2);

                if ( (LA106_2==73) ) {
                    alt106=2;
                }
                else if ( (LA106_2==RULE_INT||(LA106_2>=33 && LA106_2<=34)) ) {
                    alt106=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA106_3 = input.LA(2);

                if ( (LA106_3==73) ) {
                    alt106=2;
                }
                else if ( (LA106_3==RULE_INT||(LA106_3>=33 && LA106_3<=34)) ) {
                    alt106=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }

            switch (alt106) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6037:5: this_SpecificDoubleType_0= ruleSpecificDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getSpecificDoubleTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType13419);
                    this_SpecificDoubleType_0=ruleSpecificDoubleType();

                    state._fsp--;

                     
                            current = this_SpecificDoubleType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6047:5: this_RandomDoubleType_1= ruleRandomDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getRandomDoubleTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_ruleDoubleType13446);
                    this_RandomDoubleType_1=ruleRandomDoubleType();

                    state._fsp--;

                     
                            current = this_RandomDoubleType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDoubleType"


    // $ANTLR start "entryRuleRandomDoubleType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6063:1: entryRuleRandomDoubleType returns [EObject current=null] : iv_ruleRandomDoubleType= ruleRandomDoubleType EOF ;
    public final EObject entryRuleRandomDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6064:2: (iv_ruleRandomDoubleType= ruleRandomDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6065:2: iv_ruleRandomDoubleType= ruleRandomDoubleType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType13481);
            iv_ruleRandomDoubleType=ruleRandomDoubleType();

            state._fsp--;

             current =iv_ruleRandomDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomDoubleType13491); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomDoubleType"


    // $ANTLR start "ruleRandomDoubleType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6072:1: ruleRandomDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) ;
    public final EObject ruleRandomDoubleType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_min_4_0 = null;

        AntlrDatatypeRuleToken lv_max_6_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6075:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6076:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6076:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6076:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6076:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6077:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6082:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6083:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6083:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6084:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomDoubleType13546);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleRandomDoubleType13558); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6104:1: (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==56) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6104:3: otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomDoubleType13571); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomDoubleTypeAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6108:1: ( (lv_min_4_0= ruleEDouble ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6109:1: (lv_min_4_0= ruleEDouble )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6109:1: (lv_min_4_0= ruleEDouble )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6110:3: lv_min_4_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMinEDoubleParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType13592);
                    lv_min_4_0=ruleEDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"min",
                            		lv_min_4_0, 
                            		"EDouble");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomDoubleType13604); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomDoubleTypeAccess().getCommaKeyword_3_2());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6130:1: ( (lv_max_6_0= ruleEDouble ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6131:1: (lv_max_6_0= ruleEDouble )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6131:1: (lv_max_6_0= ruleEDouble )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6132:3: lv_max_6_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMaxEDoubleParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType13625);
                    lv_max_6_0=ruleEDouble();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomDoubleTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_6_0, 
                            		"EDouble");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleRandomDoubleType13637); 

                        	newLeafNode(otherlv_7, grammarAccess.getRandomDoubleTypeAccess().getRightParenthesisKeyword_3_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomDoubleType"


    // $ANTLR start "entryRuleSpecificDoubleType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6160:1: entryRuleSpecificDoubleType returns [EObject current=null] : iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF ;
    public final EObject entryRuleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6161:2: (iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6162:2: iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF
            {
             newCompositeNode(grammarAccess.getSpecificDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType13675);
            iv_ruleSpecificDoubleType=ruleSpecificDoubleType();

            state._fsp--;

             current =iv_ruleSpecificDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificDoubleType13685); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificDoubleType"


    // $ANTLR start "ruleSpecificDoubleType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6169:1: ruleSpecificDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) ;
    public final EObject ruleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6172:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6173:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6173:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6173:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6173:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6174:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificDoubleTypeAccess().getSpecificDoubleTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6179:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6180:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6180:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6181:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificDoubleType13740);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificDoubleTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6197:2: ( (lv_value_2_0= ruleEDouble ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6198:1: (lv_value_2_0= ruleEDouble )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6198:1: (lv_value_2_0= ruleEDouble )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6199:3: lv_value_2_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getValueEDoubleParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleSpecificDoubleType13761);
            lv_value_2_0=ruleEDouble();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificDoubleTypeRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"EDouble");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificDoubleType"


    // $ANTLR start "entryRuleMinValueType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6223:1: entryRuleMinValueType returns [EObject current=null] : iv_ruleMinValueType= ruleMinValueType EOF ;
    public final EObject entryRuleMinValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinValueType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6224:2: (iv_ruleMinValueType= ruleMinValueType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6225:2: iv_ruleMinValueType= ruleMinValueType EOF
            {
             newCompositeNode(grammarAccess.getMinValueTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMinValueType_in_entryRuleMinValueType13797);
            iv_ruleMinValueType=ruleMinValueType();

            state._fsp--;

             current =iv_ruleMinValueType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinValueType13807); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMinValueType"


    // $ANTLR start "ruleMinValueType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6232:1: ruleMinValueType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleMinValueType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_0_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6235:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6236:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6236:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6236:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6236:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6237:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6237:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6238:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getMinValueTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleMinValueType13853);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMinValueTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleMinValueType13865); 

                	newLeafNode(otherlv_1, grammarAccess.getMinValueTypeAccess().getMinKeyword_1());
                
            otherlv_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMinValueType13877); 

                	newLeafNode(otherlv_2, grammarAccess.getMinValueTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6262:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6263:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6263:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6264:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMinValueTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMinValueType13897); 

            		newLeafNode(otherlv_3, grammarAccess.getMinValueTypeAccess().getAttributeEAttributeCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleMinValueType13909); 

                	newLeafNode(otherlv_4, grammarAccess.getMinValueTypeAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMinValueType"


    // $ANTLR start "entryRuleMaxValueType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6287:1: entryRuleMaxValueType returns [EObject current=null] : iv_ruleMaxValueType= ruleMaxValueType EOF ;
    public final EObject entryRuleMaxValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxValueType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6288:2: (iv_ruleMaxValueType= ruleMaxValueType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6289:2: iv_ruleMaxValueType= ruleMaxValueType EOF
            {
             newCompositeNode(grammarAccess.getMaxValueTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMaxValueType_in_entryRuleMaxValueType13945);
            iv_ruleMaxValueType=ruleMaxValueType();

            state._fsp--;

             current =iv_ruleMaxValueType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxValueType13955); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxValueType"


    // $ANTLR start "ruleMaxValueType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6296:1: ruleMaxValueType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleMaxValueType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_0_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6299:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6300:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6300:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6300:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6300:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6301:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6301:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6302:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getMaxValueTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleMaxValueType14001);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMaxValueTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleMaxValueType14013); 

                	newLeafNode(otherlv_1, grammarAccess.getMaxValueTypeAccess().getMaxKeyword_1());
                
            otherlv_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMaxValueType14025); 

                	newLeafNode(otherlv_2, grammarAccess.getMaxValueTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6326:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6327:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6327:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6328:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMaxValueTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMaxValueType14045); 

            		newLeafNode(otherlv_3, grammarAccess.getMaxValueTypeAccess().getAttributeEAttributeCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleMaxValueType14057); 

                	newLeafNode(otherlv_4, grammarAccess.getMaxValueTypeAccess().getRightParenthesisKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxValueType"


    // $ANTLR start "entryRuleIntegerType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6351:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6352:2: (iv_ruleIntegerType= ruleIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6353:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_entryRuleIntegerType14093);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;

             current =iv_ruleIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerType14103); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerType"


    // $ANTLR start "ruleIntegerType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6360:1: ruleIntegerType returns [EObject current=null] : (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificIntegerType_0 = null;

        EObject this_RandomIntegerType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6363:28: ( (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6364:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6364:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            int alt108=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA108_1 = input.LA(2);

                if ( (LA108_1==76) ) {
                    alt108=2;
                }
                else if ( (LA108_1==RULE_INT||LA108_1==33) ) {
                    alt108=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 1, input);

                    throw nvae;
                }
                }
                break;
            case 81:
                {
                int LA108_2 = input.LA(2);

                if ( (LA108_2==RULE_INT||LA108_2==33) ) {
                    alt108=1;
                }
                else if ( (LA108_2==76) ) {
                    alt108=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA108_3 = input.LA(2);

                if ( (LA108_3==RULE_INT||LA108_3==33) ) {
                    alt108=1;
                }
                else if ( (LA108_3==76) ) {
                    alt108=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 108, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 108, 0, input);

                throw nvae;
            }

            switch (alt108) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6365:5: this_SpecificIntegerType_0= ruleSpecificIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getSpecificIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType14150);
                    this_SpecificIntegerType_0=ruleSpecificIntegerType();

                    state._fsp--;

                     
                            current = this_SpecificIntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6375:5: this_RandomIntegerType_1= ruleRandomIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getRandomIntegerTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_ruleIntegerType14177);
                    this_RandomIntegerType_1=ruleRandomIntegerType();

                    state._fsp--;

                     
                            current = this_RandomIntegerType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerType"


    // $ANTLR start "entryRuleSpecificIntegerType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6391:1: entryRuleSpecificIntegerType returns [EObject current=null] : iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF ;
    public final EObject entryRuleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6392:2: (iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6393:2: iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF
            {
             newCompositeNode(grammarAccess.getSpecificIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType14212);
            iv_ruleSpecificIntegerType=ruleSpecificIntegerType();

            state._fsp--;

             current =iv_ruleSpecificIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificIntegerType14222); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSpecificIntegerType"


    // $ANTLR start "ruleSpecificIntegerType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6400:1: ruleSpecificIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) ;
    public final EObject ruleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6403:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6404:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6404:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6404:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6404:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6405:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificIntegerTypeAccess().getSpecificIntegerTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6410:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6411:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6411:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6412:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificIntegerType14277);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificIntegerTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6428:2: ( (lv_value_2_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6429:1: (lv_value_2_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6429:1: (lv_value_2_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6430:3: lv_value_2_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getValueEIntParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleSpecificIntegerType14298);
            lv_value_2_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSpecificIntegerTypeRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSpecificIntegerType"


    // $ANTLR start "entryRuleRandomIntegerType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6454:1: entryRuleRandomIntegerType returns [EObject current=null] : iv_ruleRandomIntegerType= ruleRandomIntegerType EOF ;
    public final EObject entryRuleRandomIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6455:2: (iv_ruleRandomIntegerType= ruleRandomIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6456:2: iv_ruleRandomIntegerType= ruleRandomIntegerType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType14334);
            iv_ruleRandomIntegerType=ruleRandomIntegerType();

            state._fsp--;

             current =iv_ruleRandomIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomIntegerType14344); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomIntegerType"


    // $ANTLR start "ruleRandomIntegerType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6463:1: ruleRandomIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) ;
    public final EObject ruleRandomIntegerType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_min_4_0 = null;

        AntlrDatatypeRuleToken lv_max_6_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6466:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6467:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6467:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6467:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6467:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6468:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomIntegerTypeAccess().getRandomIntegerTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6473:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6474:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6474:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6475:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomIntegerType14399);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleRandomIntegerType14411); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomIntegerTypeAccess().getRandomIntKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6495:1: (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==56) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6495:3: otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomIntegerType14424); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomIntegerTypeAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6499:1: ( (lv_min_4_0= ruleEInt ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6500:1: (lv_min_4_0= ruleEInt )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6500:1: (lv_min_4_0= ruleEInt )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6501:3: lv_min_4_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMinEIntParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType14445);
                    lv_min_4_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"min",
                            		lv_min_4_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomIntegerType14457); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomIntegerTypeAccess().getCommaKeyword_3_2());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6521:1: ( (lv_max_6_0= ruleEInt ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6522:1: (lv_max_6_0= ruleEInt )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6522:1: (lv_max_6_0= ruleEInt )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6523:3: lv_max_6_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMaxEIntParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType14478);
                    lv_max_6_0=ruleEInt();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomIntegerTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_6_0, 
                            		"EInt");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleRandomIntegerType14490); 

                        	newLeafNode(otherlv_7, grammarAccess.getRandomIntegerTypeAccess().getRightParenthesisKeyword_3_4());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomIntegerType"


    // $ANTLR start "entryRuleRandomType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6551:1: entryRuleRandomType returns [EObject current=null] : iv_ruleRandomType= ruleRandomType EOF ;
    public final EObject entryRuleRandomType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6552:2: (iv_ruleRandomType= ruleRandomType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6553:2: iv_ruleRandomType= ruleRandomType EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomType_in_entryRuleRandomType14528);
            iv_ruleRandomType=ruleRandomType();

            state._fsp--;

             current =iv_ruleRandomType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomType14538); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomType"


    // $ANTLR start "ruleRandomType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6560:1: ruleRandomType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) ;
    public final EObject ruleRandomType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6563:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6564:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6564:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6564:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6564:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6565:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomTypeAccess().getRandomTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6570:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6571:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6571:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6572:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomType14593);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleRandomType14605); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomTypeAccess().getRandomKeyword_2());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomType"


    // $ANTLR start "entryRuleRandomDoubleNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6600:1: entryRuleRandomDoubleNumberType returns [EObject current=null] : iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF ;
    public final EObject entryRuleRandomDoubleNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6601:2: (iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6602:2: iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleNumberType_in_entryRuleRandomDoubleNumberType14641);
            iv_ruleRandomDoubleNumberType=ruleRandomDoubleNumberType();

            state._fsp--;

             current =iv_ruleRandomDoubleNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomDoubleNumberType14651); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomDoubleNumberType"


    // $ANTLR start "ruleRandomDoubleNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6609:1: ruleRandomDoubleNumberType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) ;
    public final EObject ruleRandomDoubleNumberType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Enumerator lv_operator_0_0 = null;

        AntlrDatatypeRuleToken lv_min_3_0 = null;

        EObject lv_object_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6612:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6613:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6613:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6613:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6613:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6614:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6614:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6615:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomDoubleNumberType14697);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomDoubleNumberTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleRandomDoubleNumberType14709); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomDoubleNumberTypeAccess().getRandomKeyword_1());
                
            otherlv_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomDoubleNumberType14721); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomDoubleNumberTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6639:1: ( (lv_min_3_0= ruleEDouble ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6640:1: (lv_min_3_0= ruleEDouble )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6640:1: (lv_min_3_0= ruleEDouble )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6641:3: lv_min_3_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getMinEDoubleParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleNumberType14742);
            lv_min_3_0=ruleEDouble();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomDoubleNumberTypeRule());
            	        }
                   		set(
                   			current, 
                   			"min",
                    		lv_min_3_0, 
                    		"EDouble");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomDoubleNumberType14754); 

                	newLeafNode(otherlv_4, grammarAccess.getRandomDoubleNumberTypeAccess().getCommaKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6661:1: ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==43||LA110_0==45||(LA110_0>=64 && LA110_0<=65)) ) {
                alt110=1;
            }
            else if ( (LA110_0==RULE_ID) ) {
                int LA110_2 = input.LA(2);

                if ( (LA110_2==34||LA110_2==40||LA110_2==63) ) {
                    alt110=1;
                }
            }
            switch (alt110) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6661:2: ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6661:2: ( (lv_object_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6662:1: (lv_object_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6662:1: (lv_object_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6663:3: lv_object_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getObjectObSelectionStrategyParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRandomDoubleNumberType14776);
                    lv_object_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomDoubleNumberTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_5_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRandomDoubleNumberType14788); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomDoubleNumberTypeAccess().getFullStopKeyword_5_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6683:3: ( (otherlv_7= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6684:1: (otherlv_7= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6684:1: (otherlv_7= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6685:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomDoubleNumberTypeRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomDoubleNumberType14810); 

            		newLeafNode(otherlv_7, grammarAccess.getRandomDoubleNumberTypeAccess().getMaxEAttributeCrossReference_6_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleRandomDoubleNumberType14822); 

                	newLeafNode(otherlv_8, grammarAccess.getRandomDoubleNumberTypeAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomDoubleNumberType"


    // $ANTLR start "entryRuleRandomIntegerNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6708:1: entryRuleRandomIntegerNumberType returns [EObject current=null] : iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF ;
    public final EObject entryRuleRandomIntegerNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6709:2: (iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6710:2: iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerNumberType_in_entryRuleRandomIntegerNumberType14858);
            iv_ruleRandomIntegerNumberType=ruleRandomIntegerNumberType();

            state._fsp--;

             current =iv_ruleRandomIntegerNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomIntegerNumberType14868); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRandomIntegerNumberType"


    // $ANTLR start "ruleRandomIntegerNumberType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6717:1: ruleRandomIntegerNumberType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) ;
    public final EObject ruleRandomIntegerNumberType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Enumerator lv_operator_0_0 = null;

        AntlrDatatypeRuleToken lv_min_3_0 = null;

        EObject lv_object_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6720:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6721:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6721:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6721:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6721:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6722:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6722:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6723:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomIntegerNumberType14914);
            lv_operator_0_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomIntegerNumberTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_0_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleRandomIntegerNumberType14926); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomIntegerNumberTypeAccess().getRandomKeyword_1());
                
            otherlv_2=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomIntegerNumberType14938); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomIntegerNumberTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6747:1: ( (lv_min_3_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6748:1: (lv_min_3_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6748:1: (lv_min_3_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6749:3: lv_min_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getMinEIntParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerNumberType14959);
            lv_min_3_0=ruleEInt();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRandomIntegerNumberTypeRule());
            	        }
                   		set(
                   			current, 
                   			"min",
                    		lv_min_3_0, 
                    		"EInt");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomIntegerNumberType14971); 

                	newLeafNode(otherlv_4, grammarAccess.getRandomIntegerNumberTypeAccess().getCommaKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6769:1: ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )?
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==43||LA111_0==45||(LA111_0>=64 && LA111_0<=65)) ) {
                alt111=1;
            }
            else if ( (LA111_0==RULE_ID) ) {
                int LA111_2 = input.LA(2);

                if ( (LA111_2==34||LA111_2==40||LA111_2==63) ) {
                    alt111=1;
                }
            }
            switch (alt111) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6769:2: ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6769:2: ( (lv_object_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6770:1: (lv_object_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6770:1: (lv_object_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6771:3: lv_object_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getObjectObSelectionStrategyParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRandomIntegerNumberType14993);
                    lv_object_5_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomIntegerNumberTypeRule());
                    	        }
                           		set(
                           			current, 
                           			"object",
                            		lv_object_5_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRandomIntegerNumberType15005); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomIntegerNumberTypeAccess().getFullStopKeyword_5_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6791:3: ( (otherlv_7= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6792:1: (otherlv_7= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6792:1: (otherlv_7= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6793:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomIntegerNumberTypeRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomIntegerNumberType15027); 

            		newLeafNode(otherlv_7, grammarAccess.getRandomIntegerNumberTypeAccess().getMaxEAttributeCrossReference_6_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleRandomIntegerNumberType15039); 

                	newLeafNode(otherlv_8, grammarAccess.getRandomIntegerNumberTypeAccess().getRightParenthesisKeyword_7());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRandomIntegerNumberType"


    // $ANTLR start "entryRuleListType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6816:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6817:2: (iv_ruleListType= ruleListType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6818:2: iv_ruleListType= ruleListType EOF
            {
             newCompositeNode(grammarAccess.getListTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListType_in_entryRuleListType15075);
            iv_ruleListType=ruleListType();

            state._fsp--;

             current =iv_ruleListType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListType15085); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6825:1: ruleListType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6828:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6829:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6829:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6829:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6829:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6830:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListTypeAccess().getListTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6835:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6836:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6836:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6837:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getListTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleListType15140);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getListTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleListType15152); 

                	newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6857:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6858:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6858:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6859:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getListTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListType15172); 

            		newLeafNode(otherlv_3, grammarAccess.getListTypeAccess().getValueEObjectCrossReference_3_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6870:2: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
            loop112:
            do {
                int alt112=2;
                int LA112_0 = input.LA(1);

                if ( (LA112_0==24) ) {
                    alt112=1;
                }


                switch (alt112) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6870:4: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleListType15185); 

            	        	newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_4_0());
            	        
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6874:1: ( (otherlv_5= RULE_ID ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6875:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6875:1: (otherlv_5= RULE_ID )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6876:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getListTypeRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListType15205); 

            	    		newLeafNode(otherlv_5, grammarAccess.getListTypeAccess().getValueEObjectCrossReference_4_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop112;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleListType15219); 

                	newLeafNode(otherlv_6, grammarAccess.getListTypeAccess().getRightCurlyBracketKeyword_5());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleObjectAttributeType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6899:1: entryRuleObjectAttributeType returns [EObject current=null] : iv_ruleObjectAttributeType= ruleObjectAttributeType EOF ;
    public final EObject entryRuleObjectAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectAttributeType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6900:2: (iv_ruleObjectAttributeType= ruleObjectAttributeType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6901:2: iv_ruleObjectAttributeType= ruleObjectAttributeType EOF
            {
             newCompositeNode(grammarAccess.getObjectAttributeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectAttributeType_in_entryRuleObjectAttributeType15255);
            iv_ruleObjectAttributeType=ruleObjectAttributeType();

            state._fsp--;

             current =iv_ruleObjectAttributeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectAttributeType15265); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectAttributeType"


    // $ANTLR start "ruleObjectAttributeType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6908:1: ruleObjectAttributeType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleObjectAttributeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6911:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6912:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6912:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6912:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6912:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6913:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectAttributeTypeAccess().getObjectAttributeTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6918:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6919:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6919:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6920:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getObjectAttributeTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleObjectAttributeType15320);
            lv_operator_1_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getObjectAttributeTypeRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_1_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6936:2: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6937:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6937:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6938:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectAttributeTypeRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectAttributeType15340); 

            		newLeafNode(otherlv_2, grammarAccess.getObjectAttributeTypeAccess().getObjSelObjectEmitterCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleObjectAttributeType15352); 

                	newLeafNode(otherlv_3, grammarAccess.getObjectAttributeTypeAccess().getFullStopKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6953:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6954:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6954:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6955:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectAttributeTypeRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectAttributeType15372); 

            		newLeafNode(otherlv_4, grammarAccess.getObjectAttributeTypeAccess().getAttributeEAttributeCrossReference_4_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectAttributeType"


    // $ANTLR start "entryRuleMaxCardinality"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6974:1: entryRuleMaxCardinality returns [String current=null] : iv_ruleMaxCardinality= ruleMaxCardinality EOF ;
    public final String entryRuleMaxCardinality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMaxCardinality = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6975:2: (iv_ruleMaxCardinality= ruleMaxCardinality EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6976:2: iv_ruleMaxCardinality= ruleMaxCardinality EOF
            {
             newCompositeNode(grammarAccess.getMaxCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality15409);
            iv_ruleMaxCardinality=ruleMaxCardinality();

            state._fsp--;

             current =iv_ruleMaxCardinality.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxCardinality15420); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMaxCardinality"


    // $ANTLR start "ruleMaxCardinality"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6983:1: ruleMaxCardinality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EInt_0= ruleEInt | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleMaxCardinality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EInt_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6986:28: ( (this_EInt_0= ruleEInt | kw= '*' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6987:1: (this_EInt_0= ruleEInt | kw= '*' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6987:1: (this_EInt_0= ruleEInt | kw= '*' )
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==RULE_INT||LA113_0==33) ) {
                alt113=1;
            }
            else if ( (LA113_0==78) ) {
                alt113=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }
            switch (alt113) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6988:5: this_EInt_0= ruleEInt
                    {
                     
                            newCompositeNode(grammarAccess.getMaxCardinalityAccess().getEIntParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleMaxCardinality15467);
                    this_EInt_0=ruleEInt();

                    state._fsp--;


                    		current.merge(this_EInt_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7000:2: kw= '*'
                    {
                    kw=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleMaxCardinality15491); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getMaxCardinalityAccess().getAsteriskKeyword_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMaxCardinality"


    // $ANTLR start "ruleLogicOperator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7013:1: ruleLogicOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) ;
    public final Enumerator ruleLogicOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7015:28: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7016:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7016:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==79) ) {
                alt114=1;
            }
            else if ( (LA114_0==80) ) {
                alt114=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }
            switch (alt114) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7016:2: (enumLiteral_0= 'and' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7016:2: (enumLiteral_0= 'and' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7016:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleLogicOperator15545); 

                            current = grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7022:6: (enumLiteral_1= 'or' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7022:6: (enumLiteral_1= 'or' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7022:8: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleLogicOperator15562); 

                            current = grammarAccess.getLogicOperatorAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getLogicOperatorAccess().getOrEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicOperator"


    // $ANTLR start "ruleOperator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7032:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7034:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7035:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7035:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) )
            int alt115=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt115=1;
                }
                break;
            case 81:
                {
                alt115=2;
                }
                break;
            case 22:
                {
                alt115=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }

            switch (alt115) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7035:2: (enumLiteral_0= '=' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7035:2: (enumLiteral_0= '=' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7035:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOperator15607); 

                            current = grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7041:6: (enumLiteral_1= '<>' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7041:6: (enumLiteral_1= '<>' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7041:8: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleOperator15624); 

                            current = grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7047:6: (enumLiteral_2= 'in' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7047:6: (enumLiteral_2= 'in' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7047:8: enumLiteral_2= 'in'
                    {
                    enumLiteral_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleOperator15641); 

                            current = grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getOperatorAccess().getInEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperator"


    // $ANTLR start "ruleArithmeticOperator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7057:1: ruleArithmeticOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) ;
    public final Enumerator ruleArithmeticOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7059:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7060:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7060:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            int alt116=5;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt116=1;
                }
                break;
            case 33:
                {
                alt116=2;
                }
                break;
            case 78:
                {
                alt116=3;
                }
                break;
            case 82:
                {
                alt116=4;
                }
                break;
            case 83:
                {
                alt116=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7060:2: (enumLiteral_0= '+' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7060:2: (enumLiteral_0= '+' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7060:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleArithmeticOperator15686); 

                            current = grammarAccess.getArithmeticOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getArithmeticOperatorAccess().getAddEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7066:6: (enumLiteral_1= '-' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7066:6: (enumLiteral_1= '-' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7066:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleArithmeticOperator15703); 

                            current = grammarAccess.getArithmeticOperatorAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getArithmeticOperatorAccess().getSubtractEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7072:6: (enumLiteral_2= '*' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7072:6: (enumLiteral_2= '*' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7072:8: enumLiteral_2= '*'
                    {
                    enumLiteral_2=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleArithmeticOperator15720); 

                            current = grammarAccess.getArithmeticOperatorAccess().getMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getArithmeticOperatorAccess().getMultiplyEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7078:6: (enumLiteral_3= '/' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7078:6: (enumLiteral_3= '/' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7078:8: enumLiteral_3= '/'
                    {
                    enumLiteral_3=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleArithmeticOperator15737); 

                            current = grammarAccess.getArithmeticOperatorAccess().getDivideEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getArithmeticOperatorAccess().getDivideEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7084:6: (enumLiteral_4= '%' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7084:6: (enumLiteral_4= '%' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7084:8: enumLiteral_4= '%'
                    {
                    enumLiteral_4=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleArithmeticOperator15754); 

                            current = grammarAccess.getArithmeticOperatorAccess().getModuleEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_4, grammarAccess.getArithmeticOperatorAccess().getModuleEnumLiteralDeclaration_4()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArithmeticOperator"


    // $ANTLR start "ruleRepeat"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7094:1: ruleRepeat returns [Enumerator current=null] : ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) ;
    public final Enumerator ruleRepeat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7096:28: ( ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7097:1: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7097:1: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            int alt117=2;
            int LA117_0 = input.LA(1);

            if ( (LA117_0==84) ) {
                alt117=1;
            }
            else if ( (LA117_0==85) ) {
                alt117=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 117, 0, input);

                throw nvae;
            }
            switch (alt117) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7097:2: (enumLiteral_0= 'yes' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7097:2: (enumLiteral_0= 'yes' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7097:4: enumLiteral_0= 'yes'
                    {
                    enumLiteral_0=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleRepeat15799); 

                            current = grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7103:6: (enumLiteral_1= 'no' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7103:6: (enumLiteral_1= 'no' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7103:8: enumLiteral_1= 'no'
                    {
                    enumLiteral_1=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleRepeat15816); 

                            current = grammarAccess.getRepeatAccess().getNoEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getRepeatAccess().getNoEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRepeat"


    // $ANTLR start "ruleSampleClause"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7113:1: ruleSampleClause returns [Enumerator current=null] : ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) ) ;
    public final Enumerator ruleSampleClause() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7115:28: ( ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7116:1: ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7116:1: ( (enumLiteral_0= 'equals' ) | (enumLiteral_1= 'distinct' ) )
            int alt118=2;
            int LA118_0 = input.LA(1);

            if ( (LA118_0==86) ) {
                alt118=1;
            }
            else if ( (LA118_0==87) ) {
                alt118=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }
            switch (alt118) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7116:2: (enumLiteral_0= 'equals' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7116:2: (enumLiteral_0= 'equals' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7116:4: enumLiteral_0= 'equals'
                    {
                    enumLiteral_0=(Token)match(input,86,FollowSets000.FOLLOW_86_in_ruleSampleClause15861); 

                            current = grammarAccess.getSampleClauseAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getSampleClauseAccess().getEqualsEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7122:6: (enumLiteral_1= 'distinct' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7122:6: (enumLiteral_1= 'distinct' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:7122:8: enumLiteral_1= 'distinct'
                    {
                    enumLiteral_1=(Token)match(input,87,FollowSets000.FOLLOW_87_in_ruleSampleClause15878); 

                            current = grammarAccess.getSampleClauseAccess().getDistinctEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getSampleClauseAccess().getDistinctEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSampleClause"

    // Delegated rules


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA104 dfa104 = new DFA104(this);
    static final String DFA15_eotS =
        "\24\uffff";
    static final String DFA15_eofS =
        "\24\uffff";
    static final String DFA15_minS =
        "\1\4\1\32\1\4\1\uffff\2\4\1\uffff\1\33\6\uffff\2\4\1\uffff\1\4"+
        "\2\uffff";
    static final String DFA15_maxS =
        "\1\65\1\32\1\54\1\uffff\2\101\1\uffff\1\65\6\uffff\2\54\1\uffff"+
        "\1\101\2\uffff";
    static final String DFA15_acceptS =
        "\3\uffff\1\4\2\uffff\1\13\1\uffff\1\1\1\7\1\12\1\6\1\5\1\11\2\uffff"+
        "\1\10\1\uffff\1\3\1\2";
    static final String DFA15_specialS =
        "\24\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\26\uffff\1\3\16\uffff\1\5\3\uffff\1\2\2\uffff\1\4\3\uffff"+
            "\1\6",
            "\1\7",
            "\1\10\47\uffff\1\11",
            "",
            "\1\12\46\uffff\1\12\1\uffff\1\12\5\uffff\1\14\1\13\13\uffff"+
            "\2\12",
            "\1\20\46\uffff\1\17\1\15\1\16\22\uffff\2\20",
            "",
            "\1\3\22\uffff\1\2\1\21\1\uffff\1\12\3\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\20\47\uffff\1\15",
            "\1\20\47\uffff\1\15",
            "",
            "\1\23\46\uffff\1\23\1\uffff\1\23\2\uffff\1\22\17\uffff\2\23",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_SelectSampleMutator_2= ruleSelectSampleMutator | this_CompositeMutator_3= ruleCompositeMutator | this_ModifySourceReferenceMutator_4= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_5= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_6= ruleCreateReferenceMutator | this_RemoveObjectMutator_7= ruleRemoveObjectMutator | this_RemoveReferenceMutator_8= ruleRemoveReferenceMutator | this_ModifyInformationMutator_9= ruleModifyInformationMutator | this_CloneObjectMutator_10= ruleCloneObjectMutator )";
        }
    }
    static final String DFA19_eotS =
        "\13\uffff";
    static final String DFA19_eofS =
        "\4\uffff\1\12\6\uffff";
    static final String DFA19_minS =
        "\1\26\3\5\1\16\6\uffff";
    static final String DFA19_maxS =
        "\1\121\3\115\1\120\6\uffff";
    static final String DFA19_acceptS =
        "\5\uffff\1\3\1\1\1\2\1\4\1\6\1\5";
    static final String DFA19_specialS =
        "\13\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\3\3\uffff\1\1\66\uffff\1\2",
            "\1\5\1\6\6\uffff\1\11\15\uffff\1\10\5\uffff\2\6\2\uffff\2"+
            "\7\33\uffff\1\7\6\5\4\6\1\4",
            "\1\5\1\6\6\uffff\1\11\15\uffff\1\10\5\uffff\2\6\2\uffff\2"+
            "\7\33\uffff\1\7\6\5\4\6\1\4",
            "\1\5\1\6\6\uffff\1\11\15\uffff\1\10\5\uffff\2\6\2\uffff\2"+
            "\7\33\uffff\1\7\6\5\4\6\1\4",
            "\1\12\11\uffff\1\12\37\uffff\1\6\26\uffff\2\12",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "1196:1: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )";
        }
    }
    static final String DFA20_eotS =
        "\13\uffff";
    static final String DFA20_eofS =
        "\6\uffff\1\12\4\uffff";
    static final String DFA20_minS =
        "\1\26\3\6\1\uffff\1\6\1\16\4\uffff";
    static final String DFA20_maxS =
        "\1\121\3\115\1\uffff\1\42\1\120\4\uffff";
    static final String DFA20_acceptS =
        "\4\uffff\1\5\2\uffff\1\2\1\3\1\4\1\1";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\3\uffff\1\1\66\uffff\1\2",
            "\1\6\32\uffff\1\5\1\7\46\uffff\1\7\1\10\1\11\1\12\1\4",
            "\1\6\32\uffff\1\5\1\7\46\uffff\1\7\1\10\1\11\1\12\1\4",
            "\1\6\32\uffff\1\5\1\7\46\uffff\1\7\1\10\1\11\1\12\1\4",
            "",
            "\1\6\33\uffff\1\7",
            "\1\12\11\uffff\1\12\11\uffff\1\7\54\uffff\2\12",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1276:1: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )";
        }
    }
    static final String DFA21_eotS =
        "\12\uffff";
    static final String DFA21_eofS =
        "\12\uffff";
    static final String DFA21_minS =
        "\1\26\3\115\1\70\2\6\1\30\2\uffff";
    static final String DFA21_maxS =
        "\1\121\3\115\1\70\3\42\2\uffff";
    static final String DFA21_acceptS =
        "\10\uffff\1\1\1\2";
    static final String DFA21_specialS =
        "\12\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\3\uffff\1\1\66\uffff\1\2",
            "\1\4",
            "\1\4",
            "\1\4",
            "\1\5",
            "\1\7\32\uffff\1\6\1\10",
            "\1\7\33\uffff\1\10",
            "\1\11\11\uffff\1\10",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "1346:1: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )";
        }
    }
    static final String DFA45_eotS =
        "\14\uffff";
    static final String DFA45_eofS =
        "\14\uffff";
    static final String DFA45_minS =
        "\1\4\1\26\3\uffff\1\26\1\4\1\26\2\4\2\16";
    static final String DFA45_maxS =
        "\1\76\1\123\3\uffff\1\121\1\115\1\121\2\115\2\77";
    static final String DFA45_acceptS =
        "\2\uffff\1\1\1\2\1\3\7\uffff";
    static final String DFA45_specialS =
        "\14\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\11\uffff\1\4\11\uffff\1\4\36\uffff\1\2\2\uffff\3\2\1\uffff"+
            "\1\3",
            "\1\2\3\uffff\1\6\6\uffff\1\7\1\3\32\uffff\1\5\20\uffff\1\2"+
            "\2\uffff\3\2",
            "",
            "",
            "",
            "\1\2\3\uffff\1\10\66\uffff\1\2",
            "\1\3\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\2\3\uffff\1\11\66\uffff\1\2",
            "\1\12\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\13\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3"
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "2481:1: ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )?";
        }
    }
    static final String DFA46_eotS =
        "\13\uffff";
    static final String DFA46_eofS =
        "\13\uffff";
    static final String DFA46_minS =
        "\1\4\1\26\2\uffff\1\4\2\26\2\4\2\16";
    static final String DFA46_maxS =
        "\1\76\1\123\2\uffff\1\115\2\121\2\115\2\77";
    static final String DFA46_acceptS =
        "\2\uffff\1\1\1\2\7\uffff";
    static final String DFA46_specialS =
        "\13\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\1\62\uffff\1\2\2\uffff\3\2\1\uffff\1\3",
            "\1\2\3\uffff\1\4\6\uffff\1\5\1\3\32\uffff\1\6\20\uffff\1\2"+
            "\2\uffff\3\2",
            "",
            "",
            "\1\3\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\2\3\uffff\1\7\66\uffff\1\2",
            "\1\2\3\uffff\1\10\66\uffff\1\2",
            "\1\11\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\12\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3"
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "2522:1: ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )";
        }
    }
    static final String DFA56_eotS =
        "\14\uffff";
    static final String DFA56_eofS =
        "\14\uffff";
    static final String DFA56_minS =
        "\1\4\1\26\3\uffff\1\26\1\4\1\26\2\4\2\16";
    static final String DFA56_maxS =
        "\1\76\1\123\3\uffff\1\121\1\115\1\121\2\115\2\77";
    static final String DFA56_acceptS =
        "\2\uffff\1\1\1\2\1\3\7\uffff";
    static final String DFA56_specialS =
        "\14\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\1\11\uffff\1\4\11\uffff\1\4\36\uffff\1\2\2\uffff\3\2\1\uffff"+
            "\1\3",
            "\1\2\3\uffff\1\6\6\uffff\1\7\1\3\32\uffff\1\5\20\uffff\1\2"+
            "\2\uffff\3\2",
            "",
            "",
            "",
            "\1\2\3\uffff\1\10\66\uffff\1\2",
            "\1\3\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\2\3\uffff\1\11\66\uffff\1\2",
            "\1\12\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\13\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3"
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "2904:1: ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )?";
        }
    }
    static final String DFA57_eotS =
        "\13\uffff";
    static final String DFA57_eofS =
        "\13\uffff";
    static final String DFA57_minS =
        "\1\4\1\26\2\uffff\1\4\2\26\2\4\2\16";
    static final String DFA57_maxS =
        "\1\76\1\123\2\uffff\1\115\2\121\2\115\2\77";
    static final String DFA57_acceptS =
        "\2\uffff\1\1\1\2\7\uffff";
    static final String DFA57_specialS =
        "\13\uffff}>";
    static final String[] DFA57_transitionS = {
            "\1\1\62\uffff\1\2\2\uffff\3\2\1\uffff\1\3",
            "\1\2\3\uffff\1\4\6\uffff\1\5\1\3\32\uffff\1\6\20\uffff\1\2"+
            "\2\uffff\3\2",
            "",
            "",
            "\1\3\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\2\3\uffff\1\7\66\uffff\1\2",
            "\1\2\3\uffff\1\10\66\uffff\1\2",
            "\1\11\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\12\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3"
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "2945:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )";
        }
    }
    static final String DFA82_eotS =
        "\14\uffff";
    static final String DFA82_eofS =
        "\14\uffff";
    static final String DFA82_minS =
        "\1\4\1\26\3\uffff\1\4\2\26\2\4\2\16";
    static final String DFA82_maxS =
        "\1\76\1\123\3\uffff\1\115\2\121\2\115\2\77";
    static final String DFA82_acceptS =
        "\2\uffff\1\1\1\2\1\3\7\uffff";
    static final String DFA82_specialS =
        "\14\uffff}>";
    static final String[] DFA82_transitionS = {
            "\1\1\11\uffff\1\4\11\uffff\1\4\36\uffff\1\2\2\uffff\3\2\1\uffff"+
            "\1\3",
            "\1\2\3\uffff\1\5\6\uffff\1\6\1\3\32\uffff\1\7\20\uffff\1\2"+
            "\2\uffff\3\2",
            "",
            "",
            "",
            "\1\3\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\2\3\uffff\1\10\66\uffff\1\2",
            "\1\2\3\uffff\1\11\66\uffff\1\2",
            "\1\12\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\13\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3"
    };

    static final short[] DFA82_eot = DFA.unpackEncodedString(DFA82_eotS);
    static final short[] DFA82_eof = DFA.unpackEncodedString(DFA82_eofS);
    static final char[] DFA82_min = DFA.unpackEncodedStringToUnsignedChars(DFA82_minS);
    static final char[] DFA82_max = DFA.unpackEncodedStringToUnsignedChars(DFA82_maxS);
    static final short[] DFA82_accept = DFA.unpackEncodedString(DFA82_acceptS);
    static final short[] DFA82_special = DFA.unpackEncodedString(DFA82_specialS);
    static final short[][] DFA82_transition;

    static {
        int numStates = DFA82_transitionS.length;
        DFA82_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA82_transition[i] = DFA.unpackEncodedString(DFA82_transitionS[i]);
        }
    }

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = DFA82_eot;
            this.eof = DFA82_eof;
            this.min = DFA82_min;
            this.max = DFA82_max;
            this.accept = DFA82_accept;
            this.special = DFA82_special;
            this.transition = DFA82_transition;
        }
        public String getDescription() {
            return "3722:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )?";
        }
    }
    static final String DFA83_eotS =
        "\13\uffff";
    static final String DFA83_eofS =
        "\13\uffff";
    static final String DFA83_minS =
        "\1\4\1\26\2\uffff\1\4\2\26\2\4\2\16";
    static final String DFA83_maxS =
        "\1\76\1\123\2\uffff\1\115\2\121\2\115\2\77";
    static final String DFA83_acceptS =
        "\2\uffff\1\1\1\2\7\uffff";
    static final String DFA83_specialS =
        "\13\uffff}>";
    static final String[] DFA83_transitionS = {
            "\1\1\62\uffff\1\2\2\uffff\3\2\1\uffff\1\3",
            "\1\2\3\uffff\1\4\6\uffff\1\5\1\3\32\uffff\1\6\20\uffff\1\2"+
            "\2\uffff\3\2",
            "",
            "",
            "\1\3\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\2\3\uffff\1\7\66\uffff\1\2",
            "\1\2\3\uffff\1\10\66\uffff\1\2",
            "\1\11\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\12\2\2\6\uffff\1\2\15\uffff\1\2\5\uffff\2\2\2\uffff\2\2"+
            "\4\uffff\1\3\1\uffff\1\3\22\uffff\2\3\14\2",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3",
            "\1\3\11\uffff\1\3\11\uffff\1\2\5\uffff\1\3\26\uffff\1\3"
    };

    static final short[] DFA83_eot = DFA.unpackEncodedString(DFA83_eotS);
    static final short[] DFA83_eof = DFA.unpackEncodedString(DFA83_eofS);
    static final char[] DFA83_min = DFA.unpackEncodedStringToUnsignedChars(DFA83_minS);
    static final char[] DFA83_max = DFA.unpackEncodedStringToUnsignedChars(DFA83_maxS);
    static final short[] DFA83_accept = DFA.unpackEncodedString(DFA83_acceptS);
    static final short[] DFA83_special = DFA.unpackEncodedString(DFA83_specialS);
    static final short[][] DFA83_transition;

    static {
        int numStates = DFA83_transitionS.length;
        DFA83_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA83_transition[i] = DFA.unpackEncodedString(DFA83_transitionS[i]);
        }
    }

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = DFA83_eot;
            this.eof = DFA83_eof;
            this.min = DFA83_min;
            this.max = DFA83_max;
            this.accept = DFA83_accept;
            this.special = DFA83_special;
            this.transition = DFA83_transition;
        }
        public String getDescription() {
            return "3763:1: ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )";
        }
    }
    static final String DFA104_eotS =
        "\13\uffff";
    static final String DFA104_eofS =
        "\13\uffff";
    static final String DFA104_minS =
        "\1\26\3\5\7\uffff";
    static final String DFA104_maxS =
        "\1\121\3\110\7\uffff";
    static final String DFA104_acceptS =
        "\4\uffff\1\7\1\5\1\6\1\2\1\3\1\1\1\4";
    static final String DFA104_specialS =
        "\13\uffff}>";
    static final String[] DFA104_transitionS = {
            "\1\3\3\uffff\1\1\66\uffff\1\2",
            "\1\11\75\uffff\1\7\1\10\1\5\1\6\1\12\1\4",
            "\1\11\75\uffff\1\7\1\10\1\5\1\6\1\12\1\4",
            "\1\11\75\uffff\1\7\1\10\1\5\1\6\1\12\1\4",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA104_eot = DFA.unpackEncodedString(DFA104_eotS);
    static final short[] DFA104_eof = DFA.unpackEncodedString(DFA104_eofS);
    static final char[] DFA104_min = DFA.unpackEncodedStringToUnsignedChars(DFA104_minS);
    static final char[] DFA104_max = DFA.unpackEncodedStringToUnsignedChars(DFA104_maxS);
    static final short[] DFA104_accept = DFA.unpackEncodedString(DFA104_acceptS);
    static final short[] DFA104_special = DFA.unpackEncodedString(DFA104_specialS);
    static final short[][] DFA104_transition;

    static {
        int numStates = DFA104_transitionS.length;
        DFA104_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA104_transition[i] = DFA.unpackEncodedString(DFA104_transitionS[i]);
        }
    }

    class DFA104 extends DFA {

        public DFA104(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 104;
            this.eot = DFA104_eot;
            this.eof = DFA104_eof;
            this.min = DFA104_min;
            this.max = DFA104_max;
            this.accept = DFA104_accept;
            this.special = DFA104_special;
            this.transition = DFA104_transition;
        }
        public String getDescription() {
            return "5348:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )";
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleMutatorEnvironment_in_entryRuleMutatorEnvironment75 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutatorEnvironment85 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoad_in_ruleMutatorEnvironment131 = new BitSet(new long[]{0x0000000100120000L});
        public static final BitSet FOLLOW_ruleDefinition_in_ruleMutatorEnvironment153 = new BitSet(new long[]{0x0000000000000800L});
        public static final BitSet FOLLOW_11_in_ruleMutatorEnvironment165 = new BitSet(new long[]{0x0000000000009000L});
        public static final BitSet FOLLOW_12_in_ruleMutatorEnvironment179 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMutatorEnvironment191 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleBlock_in_ruleMutatorEnvironment212 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_ruleBlock_in_ruleMutatorEnvironment233 = new BitSet(new long[]{0x0000000000004010L});
        public static final BitSet FOLLOW_14_in_ruleMutatorEnvironment246 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_15_in_ruleMutatorEnvironment266 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMutatorEnvironment278 = new BitSet(new long[]{0x0022440008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment299 = new BitSet(new long[]{0x0022440008004010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment320 = new BitSet(new long[]{0x0022440008004010L});
        public static final BitSet FOLLOW_14_in_ruleMutatorEnvironment333 = new BitSet(new long[]{0x0000000000010002L});
        public static final BitSet FOLLOW_16_in_ruleMutatorEnvironment348 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleMutatorEnvironment360 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_ruleConstraint_in_ruleMutatorEnvironment381 = new BitSet(new long[]{0x0000000040004000L});
        public static final BitSet FOLLOW_ruleConstraint_in_ruleMutatorEnvironment402 = new BitSet(new long[]{0x0000000040004000L});
        public static final BitSet FOLLOW_14_in_ruleMutatorEnvironment415 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDefinition_in_entryRuleDefinition453 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDefinition463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibrary_in_ruleDefinition510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgram_in_ruleDefinition537 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLibrary_in_entryRuleLibrary572 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLibrary582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleLibrary628 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleLibrary640 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleLibrary652 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLibrary673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProgram_in_entryRuleProgram709 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProgram719 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_20_in_ruleProgram765 = new BitSet(new long[]{0x0000000200200040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleProgram786 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleProgram799 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleProgram811 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleProgram832 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleProgram844 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleSource_in_ruleProgram865 = new BitSet(new long[]{0x0000000000080000L});
        public static final BitSet FOLLOW_19_in_ruleProgram877 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleProgram898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSource_in_entryRuleSource934 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSource944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_ruleSource999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBlock_in_entryRuleBlock1035 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBlock1045 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBlock1087 = new BitSet(new long[]{0x0000000002802000L});
        public static final BitSet FOLLOW_23_in_ruleBlock1105 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBlock1125 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_24_in_ruleBlock1138 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleBlock1158 = new BitSet(new long[]{0x0000000003002000L});
        public static final BitSet FOLLOW_25_in_ruleBlock1175 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleBlock1187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000300000L});
        public static final BitSet FOLLOW_ruleRepeat_in_ruleBlock1208 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleBlock1222 = new BitSet(new long[]{0x0022440008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleBlock1243 = new BitSet(new long[]{0x0022440008004010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleBlock1264 = new BitSet(new long[]{0x0022440008004010L});
        public static final BitSet FOLLOW_14_in_ruleBlock1277 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleBlock1290 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleBlock1313 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleBlock1325 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleBlock1346 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleBlock1374 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleBlock1387 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleConstraint_in_entryRuleConstraint1425 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleConstraint1435 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleConstraint1472 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleConstraint1492 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConstraint1513 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleConstraint1525 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleConstraint1546 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMutator_in_entryRuleMutator1582 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMutator1592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateObjectMutator_in_ruleMutator1639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectObjectMutator_in_ruleMutator1666 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectSampleMutator_in_ruleMutator1693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeMutator_in_ruleMutator1720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifySourceReferenceMutator_in_ruleMutator1747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyTargetReferenceMutator_in_ruleMutator1774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateReferenceMutator_in_ruleMutator1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveObjectMutator_in_ruleMutator1828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveReferenceMutator_in_ruleMutator1855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyInformationMutator_in_ruleMutator1882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCloneObjectMutator_in_ruleMutator1909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1944 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObSelectionStrategy1954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy2001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy2028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy2055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy2082 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomSelection_in_entryRuleRandomSelection2117 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomSelection2127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomTypeSelection_in_ruleRandomSelection2173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificSelection_in_entryRuleSpecificSelection2207 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificSelection2217 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificObjectSelection_in_ruleSpecificSelection2264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificClosureSelection_in_ruleSpecificSelection2291 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteSelection_in_entryRuleCompleteSelection2326 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompleteSelection2336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteTypeSelection_in_ruleCompleteSelection2382 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherSelection_in_entryRuleOtherSelection2416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOtherSelection2426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherTypeSelection_in_ruleOtherSelection2472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluationType_in_entryRuleAttributeEvaluationType2506 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeEvaluationType2516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeEvaluationType2563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectAttributeType_in_ruleAttributeEvaluationType2590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeType_in_entryRuleAttributeType2625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeType2635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberType_in_ruleAttributeType2682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_ruleAttributeType2709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_ruleAttributeType2736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_ruleAttributeType2763 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomType_in_ruleAttributeType2790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListType_in_ruleAttributeType2817 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberType_in_entryRuleNumberType2852 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberType2862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_ruleNumberType2909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_ruleNumberType2936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinValueType_in_ruleNumberType2963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxValueType_in_ruleNumberType2990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomNumberType_in_ruleNumberType3017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomNumberType_in_entryRuleRandomNumberType3052 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomNumberType3062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleNumberType_in_ruleRandomNumberType3109 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerNumberType_in_ruleRandomNumberType3136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoad_in_entryRuleLoad3171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoad3181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleLoad3227 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLoad3248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString3285 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString3296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString3336 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString3362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt3408 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt3419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleEInt3458 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt3475 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble3521 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble3532 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleEDouble3571 = new BitSet(new long[]{0x0000000400000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3589 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleEDouble3609 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3624 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_35_in_ruleEDouble3644 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_36_in_ruleEDouble3663 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_33_in_ruleEDouble3678 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_entryRuleEBoolean3743 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEBoolean3754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleEBoolean3792 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEBoolean3811 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator3851 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperator3861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogicOperator_in_ruleBinaryOperator3916 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation3952 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeEvaluation3962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeEvaluation4016 = new BitSet(new long[]{0x0000000004400000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeEvaluation4037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation4073 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceEvaluation4083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation4138 = new BitSet(new long[]{0x0000010004400000L,0x0000000000020000L});
        public static final BitSet FOLLOW_39_in_ruleReferenceEvaluation4156 = new BitSet(new long[]{0x0000010004400000L,0x0000000000020000L});
        public static final BitSet FOLLOW_40_in_ruleReferenceEvaluation4170 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation4190 = new BitSet(new long[]{0x0000000004400000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleReferenceEvaluation4213 = new BitSet(new long[]{0x00002A0000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation4235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleReferenceEvaluation4253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_entryRuleEvaluation4290 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEvaluation4300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation4347 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation4374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4409 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression4419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression4474 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_ruleExpression4496 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression4517 = new BitSet(new long[]{0x0000000000000002L,0x0000000000018000L});
        public static final BitSet FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator4555 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveObjectMutator4565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveObjectMutator4611 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4632 = new BitSet(new long[]{0x0000000008800002L});
        public static final BitSet FOLLOW_23_in_ruleRemoveObjectMutator4645 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4666 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveObjectMutator4681 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveObjectMutator4703 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveObjectMutator4715 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator4738 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveObjectMutator4750 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator4788 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveReferenceMutator4798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator4845 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator4872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator4899 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator4934 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator4944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveRandomReferenceMutator4990 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleRemoveRandomReferenceMutator5002 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleRemoveRandomReferenceMutator5014 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5034 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveRandomReferenceMutator5046 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5066 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveRandomReferenceMutator5079 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator5101 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveRandomReferenceMutator5113 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator5136 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveRandomReferenceMutator5148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator5186 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator5196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveSpecificReferenceMutator5242 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleRemoveSpecificReferenceMutator5254 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator5274 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveSpecificReferenceMutator5286 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator5307 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveSpecificReferenceMutator5320 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator5342 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveSpecificReferenceMutator5354 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator5377 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveSpecificReferenceMutator5389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator5427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator5437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveCompleteReferenceMutator5483 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleRemoveCompleteReferenceMutator5495 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleRemoveCompleteReferenceMutator5507 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5527 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveCompleteReferenceMutator5539 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator5595 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateObjectMutator5605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator5648 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCreateObjectMutator5665 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleCreateObjectMutator5679 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator5699 = new BitSet(new long[]{0x0000000008400802L});
        public static final BitSet FOLLOW_22_in_ruleCreateObjectMutator5712 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator5733 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleCreateObjectMutator5748 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCreateObjectMutator5760 = new BitSet(new long[]{0x5C80000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5782 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5809 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleCreateObjectMutator5824 = new BitSet(new long[]{0x5C80000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5846 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5873 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleCreateObjectMutator5888 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCreateObjectMutator5903 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateObjectMutator5925 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCreateObjectMutator5937 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator5960 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCreateObjectMutator5972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator6010 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectObjectMutator6020 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectObjectMutator6062 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleSelectObjectMutator6079 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleSelectObjectMutator6091 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6112 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleSelectObjectMutator6125 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6146 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectSampleMutator_in_entryRuleSelectSampleMutator6184 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectSampleMutator6194 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectSampleMutator6236 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleSelectSampleMutator6253 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleSelectSampleMutator6265 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleSelectSampleMutator6277 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSelectSampleMutator6289 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectSampleMutator6310 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_11_in_ruleSelectSampleMutator6323 = new BitSet(new long[]{0x0000000000000000L,0x0000000000C00000L});
        public static final BitSet FOLLOW_ruleSampleClause_in_ruleSelectSampleMutator6344 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSelectSampleMutator6356 = new BitSet(new long[]{0x0000000001004010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectSampleMutator6376 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleSelectSampleMutator6390 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectSampleMutator6410 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleSelectSampleMutator6424 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator6462 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyInformationMutator6472 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyInformationMutator6515 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleModifyInformationMutator6532 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleModifyInformationMutator6546 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator6567 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleModifyInformationMutator6580 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModifyInformationMutator6592 = new BitSet(new long[]{0x5C80000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6614 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6641 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleModifyInformationMutator6656 = new BitSet(new long[]{0x5C80000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6678 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6705 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleModifyInformationMutator6720 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifyInformationMutator6735 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyInformationMutator6757 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifyInformationMutator6769 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator6792 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifyInformationMutator6804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator6842 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateReferenceMutator6852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6895 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCreateReferenceMutator6912 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleCreateReferenceMutator6926 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleCreateReferenceMutator6938 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6958 = new BitSet(new long[]{0x0004000008400002L});
        public static final BitSet FOLLOW_50_in_ruleCreateReferenceMutator6971 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6992 = new BitSet(new long[]{0x0000000008400002L});
        public static final BitSet FOLLOW_22_in_ruleCreateReferenceMutator7007 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator7028 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCreateReferenceMutator7043 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateReferenceMutator7065 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCreateReferenceMutator7077 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator7100 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCreateReferenceMutator7112 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator7150 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator7160 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleModifySourceReferenceMutator7197 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleModifySourceReferenceMutator7209 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator7229 = new BitSet(new long[]{0x0004000008800002L});
        public static final BitSet FOLLOW_23_in_ruleModifySourceReferenceMutator7242 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7263 = new BitSet(new long[]{0x0004000008000002L});
        public static final BitSet FOLLOW_50_in_ruleModifySourceReferenceMutator7278 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7299 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifySourceReferenceMutator7314 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator7336 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifySourceReferenceMutator7348 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator7371 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifySourceReferenceMutator7383 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator7421 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator7431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleModifyTargetReferenceMutator7468 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleModifyTargetReferenceMutator7480 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator7500 = new BitSet(new long[]{0x0004000008800002L});
        public static final BitSet FOLLOW_23_in_ruleModifyTargetReferenceMutator7513 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7534 = new BitSet(new long[]{0x0004000008000002L});
        public static final BitSet FOLLOW_50_in_ruleModifyTargetReferenceMutator7549 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7570 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifyTargetReferenceMutator7585 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator7607 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifyTargetReferenceMutator7619 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator7642 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifyTargetReferenceMutator7654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator7692 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeMutator7702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompositeMutator7745 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCompositeMutator7762 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleCompositeMutator7776 = new BitSet(new long[]{0x0022440008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator7797 = new BitSet(new long[]{0x0022440028000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator7818 = new BitSet(new long[]{0x0022440028000010L});
        public static final BitSet FOLLOW_29_in_ruleCompositeMutator7831 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCompositeMutator7844 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCompositeMutator7867 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCompositeMutator7879 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator7900 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCompositeMutator7928 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCompositeMutator7941 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCloneObjectMutator_in_entryRuleCloneObjectMutator7979 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCloneObjectMutator7989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCloneObjectMutator8032 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCloneObjectMutator8049 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleCloneObjectMutator8063 = new BitSet(new long[]{0x0040280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_54_in_ruleCloneObjectMutator8081 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator8116 = new BitSet(new long[]{0x0000000008400802L});
        public static final BitSet FOLLOW_22_in_ruleCloneObjectMutator8129 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator8150 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleCloneObjectMutator8165 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCloneObjectMutator8177 = new BitSet(new long[]{0x5C80000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8199 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8226 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleCloneObjectMutator8241 = new BitSet(new long[]{0x5C80000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8263 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8290 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleCloneObjectMutator8305 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCloneObjectMutator8320 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCloneObjectMutator8342 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCloneObjectMutator8354 = new BitSet(new long[]{0x0000000200000040L,0x0000000000004000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCloneObjectMutator8377 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCloneObjectMutator8389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet8427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSet8437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeScalar_in_ruleAttributeSet8484 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_ruleAttributeSet8511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_ruleAttributeSet8538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_ruleAttributeSet8565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_ruleAttributeSet8592 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeOperation_in_ruleAttributeSet8619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeScalar_in_entryRuleAttributeScalar8654 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeScalar8664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeScalar8709 = new BitSet(new long[]{0x0000000004400000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeScalar8730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset8766 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeUnset8776 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleAttributeUnset8813 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeUnset8825 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeUnset8845 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleAttributeUnset8857 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap8893 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSwap8903 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleAttributeSwap8940 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeSwap8952 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap8972 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleAttributeSwap8984 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap9006 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAttributeSwap9018 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap9040 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleAttributeSwap9052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy9088 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeCopy9098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleAttributeCopy9135 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeCopy9147 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy9167 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleAttributeCopy9179 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy9201 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAttributeCopy9213 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy9235 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleAttributeCopy9247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse9283 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeReverse9293 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleAttributeReverse9330 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeReverse9342 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeReverse9362 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleAttributeReverse9374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeOperation_in_entryRuleAttributeOperation9410 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeOperation9420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeOperation9465 = new BitSet(new long[]{0x2000000200000000L,0x00000000000C4000L});
        public static final BitSet FOLLOW_ruleArithmeticOperator_in_ruleAttributeOperation9486 = new BitSet(new long[]{0x0000000004400000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeOperation9507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet9543 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSet9553 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_ruleReferenceSet9600 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_ruleReferenceSet9627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAtt_in_ruleReferenceSet9654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAdd_in_ruleReferenceSet9681 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceRemove_in_ruleReferenceSet9708 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit9743 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceInit9753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceInit9798 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleReferenceInit9810 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit9831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAdd_in_entryRuleReferenceAdd9867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAdd9877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAdd9922 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_61_in_ruleReferenceAdd9934 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleReferenceAdd9946 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceAdd9967 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceRemove_in_entryRuleReferenceRemove10003 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceRemove10013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceRemove10058 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleReferenceRemove10070 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleReferenceRemove10082 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceRemove10103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap10139 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSwap10149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleReferenceSwap10186 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleReferenceSwap10198 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap10218 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleReferenceSwap10230 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap10252 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleReferenceSwap10264 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap10286 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleReferenceSwap10298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAtt_in_entryRuleReferenceAtt10334 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAtt10344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAtt10389 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleReferenceAtt10401 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAtt10421 = new BitSet(new long[]{0x0000000004400000L,0x0000000000020000L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleReferenceAtt10442 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection10478 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomTypeSelection10488 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleRandomTypeSelection10534 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTypeSelection10554 = new BitSet(new long[]{0x8000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleRandomTypeSelection10567 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTypeSelection10587 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleRandomTypeSelection10602 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleRandomTypeSelection10614 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRandomTypeSelection10635 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleRandomTypeSelection10647 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection10685 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificObjectSelection10695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10749 = new BitSet(new long[]{0x8000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleSpecificObjectSelection10762 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10782 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleSpecificObjectSelection10797 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSpecificObjectSelection10809 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSpecificObjectSelection10830 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSpecificObjectSelection10842 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificClosureSelection_in_entryRuleSpecificClosureSelection10880 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificClosureSelection10890 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleSpecificClosureSelection10936 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleSpecificClosureSelection10948 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificClosureSelection10968 = new BitSet(new long[]{0x0200010000000000L});
        public static final BitSet FOLLOW_40_in_ruleSpecificClosureSelection10981 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificClosureSelection11001 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleSpecificClosureSelection11015 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleSpecificClosureSelection11028 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSpecificClosureSelection11040 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSpecificClosureSelection11061 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSpecificClosureSelection11073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection11111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompleteTypeSelection11121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleCompleteTypeSelection11167 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompleteTypeSelection11187 = new BitSet(new long[]{0x8000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleCompleteTypeSelection11200 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompleteTypeSelection11220 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleCompleteTypeSelection11235 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCompleteTypeSelection11247 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleCompleteTypeSelection11268 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCompleteTypeSelection11280 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection11318 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOtherTypeSelection11328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleOtherTypeSelection11374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOtherTypeSelection11394 = new BitSet(new long[]{0x8000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleOtherTypeSelection11407 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOtherTypeSelection11427 = new BitSet(new long[]{0x8000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleOtherTypeSelection11442 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOtherTypeSelection11454 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleOtherTypeSelection11475 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOtherTypeSelection11487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_entryRuleBooleanType11525 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanType11535 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType11582 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_ruleBooleanType11609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType11644 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomBooleanType11654 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomBooleanType11709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleRandomBooleanType11721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType11757 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificBooleanType11767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificBooleanType11822 = new BitSet(new long[]{0x0000006000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType11843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_entryRuleStringType11879 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringType11889 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_ruleStringType11936 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_ruleStringType11963 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_ruleStringType11990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_ruleStringType12017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_ruleStringType12044 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_ruleStringType12071 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_ruleStringType12098 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType12133 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomStringType12143 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomStringType12198 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleRandomStringType12210 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomStringType12222 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType12243 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomStringType12255 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType12276 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleRandomStringType12288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType12324 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificStringType12334 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificStringType12389 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSpecificStringType12406 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType12447 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUpperStringType12457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleUpperStringType12512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleUpperStringType12524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType12560 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatStartStringType12570 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleCatStartStringType12625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleCatStartStringType12637 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCatStartStringType12649 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatStartStringType12670 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleCatStartStringType12682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType12718 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatEndStringType12728 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleCatEndStringType12783 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleCatEndStringType12795 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCatEndStringType12807 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatEndStringType12828 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleCatEndStringType12840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_entryRuleListStringType12876 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListStringType12886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleListStringType12941 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleListStringType12953 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType12974 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_24_in_ruleListStringType12987 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType13008 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_29_in_ruleListStringType13022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType13058 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerStringType13068 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleLowerStringType13123 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleLowerStringType13135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType13171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReplaceStringType13181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleReplaceStringType13236 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleReplaceStringType13248 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleReplaceStringType13260 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType13281 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleReplaceStringType13293 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType13314 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleReplaceStringType13326 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_entryRuleDoubleType13362 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleType13372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType13419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_ruleDoubleType13446 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType13481 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomDoubleType13491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomDoubleType13546 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleRandomDoubleType13558 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_56_in_ruleRandomDoubleType13571 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType13592 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomDoubleType13604 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType13625 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleRandomDoubleType13637 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType13675 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificDoubleType13685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificDoubleType13740 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleSpecificDoubleType13761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinValueType_in_entryRuleMinValueType13797 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinValueType13807 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleMinValueType13853 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleMinValueType13865 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleMinValueType13877 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMinValueType13897 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleMinValueType13909 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxValueType_in_entryRuleMaxValueType13945 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxValueType13955 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleMaxValueType14001 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_75_in_ruleMaxValueType14013 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleMaxValueType14025 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMaxValueType14045 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleMaxValueType14057 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_entryRuleIntegerType14093 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerType14103 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType14150 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_ruleIntegerType14177 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType14212 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificIntegerType14222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificIntegerType14277 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleSpecificIntegerType14298 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType14334 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomIntegerType14344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomIntegerType14399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_76_in_ruleRandomIntegerType14411 = new BitSet(new long[]{0x0100000000000002L});
        public static final BitSet FOLLOW_56_in_ruleRandomIntegerType14424 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType14445 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomIntegerType14457 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType14478 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleRandomIntegerType14490 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomType_in_entryRuleRandomType14528 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomType14538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomType14593 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleRandomType14605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleNumberType_in_entryRuleRandomDoubleNumberType14641 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomDoubleNumberType14651 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomDoubleNumberType14697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleRandomDoubleNumberType14709 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomDoubleNumberType14721 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleNumberType14742 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomDoubleNumberType14754 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRandomDoubleNumberType14776 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleRandomDoubleNumberType14788 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomDoubleNumberType14810 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleRandomDoubleNumberType14822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerNumberType_in_entryRuleRandomIntegerNumberType14858 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomIntegerNumberType14868 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomIntegerNumberType14914 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleRandomIntegerNumberType14926 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomIntegerNumberType14938 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerNumberType14959 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomIntegerNumberType14971 = new BitSet(new long[]{0x0000280000000010L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRandomIntegerNumberType14993 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleRandomIntegerNumberType15005 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomIntegerNumberType15027 = new BitSet(new long[]{0x0200000000000000L});
        public static final BitSet FOLLOW_57_in_ruleRandomIntegerNumberType15039 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListType_in_entryRuleListType15075 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListType15085 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleListType15140 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleListType15152 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListType15172 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleListType15185 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListType15205 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleListType15219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectAttributeType_in_entryRuleObjectAttributeType15255 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectAttributeType15265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleObjectAttributeType15320 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectAttributeType15340 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleObjectAttributeType15352 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectAttributeType15372 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality15409 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxCardinality15420 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleMaxCardinality15467 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleMaxCardinality15491 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleLogicOperator15545 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleLogicOperator15562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleOperator15607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleOperator15624 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleOperator15641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleArithmeticOperator15686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleArithmeticOperator15703 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleArithmeticOperator15720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_82_in_ruleArithmeticOperator15737 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleArithmeticOperator15754 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleRepeat15799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleRepeat15816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleSampleClause15861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleSampleClause15878 = new BitSet(new long[]{0x0000000000000002L});
    }


}