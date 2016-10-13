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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'with'", "'blocks'", "'{'", "'}'", "'commands'", "'constraints'", "'library'", "'for'", "'metamodel'", "'generate'", "'mutants'", "'in'", "'from'", "','", "'repeat'", "'='", "'['", "'..'", "']'", "'context'", "':'", "'import'", "'-'", "'.'", "'E'", "'e'", "'true'", "'false'", "'self'", "'null'", "'remove'", "'one'", "'reference'", "'all'", "'create'", "'select'", "'modify'", "'to'", "'source'", "'target'", "'unset'", "'('", "')'", "'swap'", "'copy'", "'reverse'", "'swapref'", "'where'", "'other'", "'random-boolean'", "'random-string'", "'upper'", "'catstart'", "'catend'", "'lower'", "'replace'", "'random-double'", "'random-int'", "'random'", "'*'", "'and'", "'or'", "'<>'", "'yes'", "'no'"
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
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
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

                        if ( (LA3_0==RULE_ID||LA3_0==27||LA3_0==41||LA3_0==45||LA3_0==47) ) {
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

                if ( (LA12_0==RULE_ID||LA12_0==27||LA12_0==41||LA12_0==45||LA12_0==47) ) {
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

                            if ( (LA13_2==28) ) {
                                alt13=1;
                            }
                            else if ( (LA13_2==29) ) {
                                alt13=2;
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

                        if ( (LA13_2==28) ) {
                            alt13=1;
                        }
                        else if ( (LA13_2==29) ) {
                            alt13=2;
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:832:1: ruleMutator returns [EObject current=null] : (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator ) ;
    public final EObject ruleMutator() throws RecognitionException {
        EObject current = null;

        EObject this_CreateObjectMutator_0 = null;

        EObject this_SelectObjectMutator_1 = null;

        EObject this_CompositeMutator_2 = null;

        EObject this_ModifySourceReferenceMutator_3 = null;

        EObject this_ModifyTargetReferenceMutator_4 = null;

        EObject this_CreateReferenceMutator_5 = null;

        EObject this_RemoveObjectMutator_6 = null;

        EObject this_RemoveReferenceMutator_7 = null;

        EObject this_ModifyInformationMutator_8 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:835:28: ( (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator )
            int alt15=9;
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:857:5: this_CompositeMutator_2= ruleCompositeMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCompositeMutatorParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCompositeMutator_in_ruleMutator1693);
                    this_CompositeMutator_2=ruleCompositeMutator();

                    state._fsp--;

                     
                            current = this_CompositeMutator_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:867:5: this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifySourceReferenceMutatorParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifySourceReferenceMutator_in_ruleMutator1720);
                    this_ModifySourceReferenceMutator_3=ruleModifySourceReferenceMutator();

                    state._fsp--;

                     
                            current = this_ModifySourceReferenceMutator_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:877:5: this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifyTargetReferenceMutatorParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifyTargetReferenceMutator_in_ruleMutator1747);
                    this_ModifyTargetReferenceMutator_4=ruleModifyTargetReferenceMutator();

                    state._fsp--;

                     
                            current = this_ModifyTargetReferenceMutator_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:887:5: this_CreateReferenceMutator_5= ruleCreateReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCreateReferenceMutatorParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCreateReferenceMutator_in_ruleMutator1774);
                    this_CreateReferenceMutator_5=ruleCreateReferenceMutator();

                    state._fsp--;

                     
                            current = this_CreateReferenceMutator_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:897:5: this_RemoveObjectMutator_6= ruleRemoveObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getRemoveObjectMutatorParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveObjectMutator_in_ruleMutator1801);
                    this_RemoveObjectMutator_6=ruleRemoveObjectMutator();

                    state._fsp--;

                     
                            current = this_RemoveObjectMutator_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:907:5: this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getRemoveReferenceMutatorParserRuleCall_7()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveReferenceMutator_in_ruleMutator1828);
                    this_RemoveReferenceMutator_7=ruleRemoveReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveReferenceMutator_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:917:5: this_ModifyInformationMutator_8= ruleModifyInformationMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getModifyInformationMutatorParserRuleCall_8()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleModifyInformationMutator_in_ruleMutator1855);
                    this_ModifyInformationMutator_8=ruleModifyInformationMutator();

                    state._fsp--;

                     
                            current = this_ModifyInformationMutator_8; 
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:933:1: entryRuleObSelectionStrategy returns [EObject current=null] : iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF ;
    public final EObject entryRuleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObSelectionStrategy = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:934:2: (iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:935:2: iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF
            {
             newCompositeNode(grammarAccess.getObSelectionStrategyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1890);
            iv_ruleObSelectionStrategy=ruleObSelectionStrategy();

            state._fsp--;

             current =iv_ruleObSelectionStrategy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObSelectionStrategy1900); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:942:1: ruleObSelectionStrategy returns [EObject current=null] : (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection ) ;
    public final EObject ruleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject this_RandomSelection_0 = null;

        EObject this_SpecificSelection_1 = null;

        EObject this_CompleteSelection_2 = null;

        EObject this_OtherSelection_3 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:945:28: ( (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:946:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:946:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection )
            int alt16=4;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
                {
                alt16=2;
                }
                break;
            case 44:
                {
                alt16=3;
                }
                break;
            case 59:
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:947:5: this_RandomSelection_0= ruleRandomSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getRandomSelectionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy1947);
                    this_RandomSelection_0=ruleRandomSelection();

                    state._fsp--;

                     
                            current = this_RandomSelection_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:957:5: this_SpecificSelection_1= ruleSpecificSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getSpecificSelectionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy1974);
                    this_SpecificSelection_1=ruleSpecificSelection();

                    state._fsp--;

                     
                            current = this_SpecificSelection_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:967:5: this_CompleteSelection_2= ruleCompleteSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getCompleteSelectionParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy2001);
                    this_CompleteSelection_2=ruleCompleteSelection();

                    state._fsp--;

                     
                            current = this_CompleteSelection_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:977:5: this_OtherSelection_3= ruleOtherSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getOtherSelectionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy2028);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:993:1: entryRuleRandomSelection returns [EObject current=null] : iv_ruleRandomSelection= ruleRandomSelection EOF ;
    public final EObject entryRuleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:994:2: (iv_ruleRandomSelection= ruleRandomSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:995:2: iv_ruleRandomSelection= ruleRandomSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomSelection_in_entryRuleRandomSelection2063);
            iv_ruleRandomSelection=ruleRandomSelection();

            state._fsp--;

             current =iv_ruleRandomSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomSelection2073); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1002:1: ruleRandomSelection returns [EObject current=null] : this_RandomTypeSelection_0= ruleRandomTypeSelection ;
    public final EObject ruleRandomSelection() throws RecognitionException {
        EObject current = null;

        EObject this_RandomTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1005:28: (this_RandomTypeSelection_0= ruleRandomTypeSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1007:5: this_RandomTypeSelection_0= ruleRandomTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getRandomSelectionAccess().getRandomTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleRandomTypeSelection_in_ruleRandomSelection2119);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1023:1: entryRuleSpecificSelection returns [EObject current=null] : iv_ruleSpecificSelection= ruleSpecificSelection EOF ;
    public final EObject entryRuleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1024:2: (iv_ruleSpecificSelection= ruleSpecificSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1025:2: iv_ruleSpecificSelection= ruleSpecificSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificSelection_in_entryRuleSpecificSelection2153);
            iv_ruleSpecificSelection=ruleSpecificSelection();

            state._fsp--;

             current =iv_ruleSpecificSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificSelection2163); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1032:1: ruleSpecificSelection returns [EObject current=null] : this_SpecificObjectSelection_0= ruleSpecificObjectSelection ;
    public final EObject ruleSpecificSelection() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificObjectSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1035:28: (this_SpecificObjectSelection_0= ruleSpecificObjectSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1037:5: this_SpecificObjectSelection_0= ruleSpecificObjectSelection
            {
             
                    newCompositeNode(grammarAccess.getSpecificSelectionAccess().getSpecificObjectSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleSpecificObjectSelection_in_ruleSpecificSelection2209);
            this_SpecificObjectSelection_0=ruleSpecificObjectSelection();

            state._fsp--;

             
                    current = this_SpecificObjectSelection_0; 
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
    // $ANTLR end "ruleSpecificSelection"


    // $ANTLR start "entryRuleCompleteSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1053:1: entryRuleCompleteSelection returns [EObject current=null] : iv_ruleCompleteSelection= ruleCompleteSelection EOF ;
    public final EObject entryRuleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1054:2: (iv_ruleCompleteSelection= ruleCompleteSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1055:2: iv_ruleCompleteSelection= ruleCompleteSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompleteSelection_in_entryRuleCompleteSelection2243);
            iv_ruleCompleteSelection=ruleCompleteSelection();

            state._fsp--;

             current =iv_ruleCompleteSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompleteSelection2253); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1062:1: ruleCompleteSelection returns [EObject current=null] : this_CompleteTypeSelection_0= ruleCompleteTypeSelection ;
    public final EObject ruleCompleteSelection() throws RecognitionException {
        EObject current = null;

        EObject this_CompleteTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1065:28: (this_CompleteTypeSelection_0= ruleCompleteTypeSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1067:5: this_CompleteTypeSelection_0= ruleCompleteTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getCompleteSelectionAccess().getCompleteTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleCompleteTypeSelection_in_ruleCompleteSelection2299);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1083:1: entryRuleOtherSelection returns [EObject current=null] : iv_ruleOtherSelection= ruleOtherSelection EOF ;
    public final EObject entryRuleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1084:2: (iv_ruleOtherSelection= ruleOtherSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1085:2: iv_ruleOtherSelection= ruleOtherSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOtherSelection_in_entryRuleOtherSelection2333);
            iv_ruleOtherSelection=ruleOtherSelection();

            state._fsp--;

             current =iv_ruleOtherSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOtherSelection2343); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1092:1: ruleOtherSelection returns [EObject current=null] : this_OtherTypeSelection_0= ruleOtherTypeSelection ;
    public final EObject ruleOtherSelection() throws RecognitionException {
        EObject current = null;

        EObject this_OtherTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1095:28: (this_OtherTypeSelection_0= ruleOtherTypeSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1097:5: this_OtherTypeSelection_0= ruleOtherTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getOtherSelectionAccess().getOtherTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleOtherTypeSelection_in_ruleOtherSelection2389);
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


    // $ANTLR start "entryRuleAttributeType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1113:1: entryRuleAttributeType returns [EObject current=null] : iv_ruleAttributeType= ruleAttributeType EOF ;
    public final EObject entryRuleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1114:2: (iv_ruleAttributeType= ruleAttributeType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1115:2: iv_ruleAttributeType= ruleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_entryRuleAttributeType2423);
            iv_ruleAttributeType=ruleAttributeType();

            state._fsp--;

             current =iv_ruleAttributeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeType2433); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1122:1: ruleAttributeType returns [EObject current=null] : (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType | this_RandomType_5= ruleRandomType ) ;
    public final EObject ruleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerType_0 = null;

        EObject this_BooleanType_1 = null;

        EObject this_StringType_2 = null;

        EObject this_DoubleType_3 = null;

        EObject this_ListStringType_4 = null;

        EObject this_RandomType_5 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1125:28: ( (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType | this_RandomType_5= ruleRandomType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1126:1: (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType | this_RandomType_5= ruleRandomType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1126:1: (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType | this_RandomType_5= ruleRandomType )
            int alt17=6;
            alt17 = dfa17.predict(input);
            switch (alt17) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1127:5: this_IntegerType_0= ruleIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_ruleAttributeType2480);
                    this_IntegerType_0=ruleIntegerType();

                    state._fsp--;

                     
                            current = this_IntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1137:5: this_BooleanType_1= ruleBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_ruleAttributeType2507);
                    this_BooleanType_1=ruleBooleanType();

                    state._fsp--;

                     
                            current = this_BooleanType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1147:5: this_StringType_2= ruleStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringType_in_ruleAttributeType2534);
                    this_StringType_2=ruleStringType();

                    state._fsp--;

                     
                            current = this_StringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1157:5: this_DoubleType_3= ruleDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getDoubleTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_ruleAttributeType2561);
                    this_DoubleType_3=ruleDoubleType();

                    state._fsp--;

                     
                            current = this_DoubleType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1167:5: this_ListStringType_4= ruleListStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getListStringTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_ruleAttributeType2588);
                    this_ListStringType_4=ruleListStringType();

                    state._fsp--;

                     
                            current = this_ListStringType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1177:5: this_RandomType_5= ruleRandomType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getRandomTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomType_in_ruleAttributeType2615);
                    this_RandomType_5=ruleRandomType();

                    state._fsp--;

                     
                            current = this_RandomType_5; 
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


    // $ANTLR start "entryRuleLoad"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1193:1: entryRuleLoad returns [EObject current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final EObject entryRuleLoad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoad = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1194:2: (iv_ruleLoad= ruleLoad EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1195:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoad_in_entryRuleLoad2650);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoad2660); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1202:1: ruleLoad returns [EObject current=null] : ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) ;
    public final EObject ruleLoad() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_file_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1205:28: ( ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1206:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1206:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1206:2: () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1206:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1207:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLoadAccess().getLoadAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLoad2706); 

                	newLeafNode(otherlv_1, grammarAccess.getLoadAccess().getImportKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1216:1: ( (lv_file_2_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1217:1: (lv_file_2_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1217:1: (lv_file_2_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1218:3: lv_file_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getLoadAccess().getFileEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLoad2727);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1242:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1243:2: (iv_ruleEString= ruleEString EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1244:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString2764);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString2775); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1251:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1254:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1255:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1255:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_STRING) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1255:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString2815); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1263:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString2841); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1278:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1279:2: (iv_ruleEInt= ruleEInt EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1280:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt2887);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt2898); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1287:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1290:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1291:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1291:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1291:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1291:2: (kw= '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1292:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEInt2937); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt2954); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1312:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1313:2: (iv_ruleEDouble= ruleEDouble EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1314:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble3000);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble3011); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1321:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1324:28: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1325:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1325:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1325:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1325:2: (kw= '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1326:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEDouble3050); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1331:3: (this_INT_1= RULE_INT )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_INT) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1331:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3068); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEDouble3088); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3103); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1351:1: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=35 && LA24_0<=36)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1351:2: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1351:2: (kw= 'E' | kw= 'e' )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==35) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==36) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1352:2: kw= 'E'
                            {
                            kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEDouble3123); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1359:2: kw= 'e'
                            {
                            kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEDouble3142); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1364:2: (kw= '-' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==33) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1365:2: kw= '-'
                            {
                            kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEDouble3157); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
                                

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3174); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1385:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1386:2: (iv_ruleEBoolean= ruleEBoolean EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1387:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_entryRuleEBoolean3222);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEBoolean3233); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1394:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1397:28: ( (kw= 'true' | kw= 'false' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1398:1: (kw= 'true' | kw= 'false' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1398:1: (kw= 'true' | kw= 'false' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==37) ) {
                alt25=1;
            }
            else if ( (LA25_0==38) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1399:2: kw= 'true'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEBoolean3271); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1406:2: kw= 'false'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEBoolean3290); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1419:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1420:2: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1421:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator3330);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperator3340); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1428:1: ruleBinaryOperator returns [EObject current=null] : ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1431:28: ( ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1432:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1432:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1432:2: () ( (lv_type_1_0= ruleLogicOperator ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1432:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1433:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1438:2: ( (lv_type_1_0= ruleLogicOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1439:1: (lv_type_1_0= ruleLogicOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1439:1: (lv_type_1_0= ruleLogicOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1440:3: lv_type_1_0= ruleLogicOperator
            {
             
            	        newCompositeNode(grammarAccess.getBinaryOperatorAccess().getTypeLogicOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLogicOperator_in_ruleBinaryOperator3395);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1464:1: entryRuleAttributeEvaluation returns [EObject current=null] : iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF ;
    public final EObject entryRuleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1465:2: (iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1466:2: iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation3431);
            iv_ruleAttributeEvaluation=ruleAttributeEvaluation();

            state._fsp--;

             current =iv_ruleAttributeEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeEvaluation3441); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1473:1: ruleAttributeEvaluation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeType ) ) ) ;
    public final EObject ruleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1476:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1477:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1477:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1477:2: () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1477:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1478:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttributeEvaluationAccess().getAttributeEvaluationAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1483:2: ( (otherlv_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1484:1: (otherlv_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1484:1: (otherlv_1= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1485:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeEvaluationRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeEvaluation3495); 

            		newLeafNode(otherlv_1, grammarAccess.getAttributeEvaluationAccess().getNameEAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1496:2: ( (lv_value_2_0= ruleAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1497:1: (lv_value_2_0= ruleAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1497:1: (lv_value_2_0= ruleAttributeType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1498:3: lv_value_2_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeEvaluationAccess().getValueAttributeTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeEvaluation3516);
            lv_value_2_0=ruleAttributeType();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getAttributeEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
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
    // $ANTLR end "ruleAttributeEvaluation"


    // $ANTLR start "entryRuleReferenceEvaluation"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1522:1: entryRuleReferenceEvaluation returns [EObject current=null] : iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF ;
    public final EObject entryRuleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1523:2: (iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1524:2: iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF
            {
             newCompositeNode(grammarAccess.getReferenceEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation3552);
            iv_ruleReferenceEvaluation=ruleReferenceEvaluation();

            state._fsp--;

             current =iv_ruleReferenceEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceEvaluation3562); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1531:1: ruleReferenceEvaluation returns [EObject current=null] : ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) ) ;
    public final EObject ruleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Enumerator lv_operator_3_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1534:28: ( ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:2: () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) ( (lv_operator_3_0= ruleOperator ) ) ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1536:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReferenceEvaluationAccess().getReferenceEvaluationAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1541:2: ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==39) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1541:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1541:3: ( (otherlv_1= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1542:1: (otherlv_1= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1542:1: (otherlv_1= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1543:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation3617); 

                    		newLeafNode(otherlv_1, grammarAccess.getReferenceEvaluationAccess().getNameEReferenceCrossReference_1_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1555:7: otherlv_2= 'self'
                    {
                    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleReferenceEvaluation3635); 

                        	newLeafNode(otherlv_2, grammarAccess.getReferenceEvaluationAccess().getSelfKeyword_1_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1559:2: ( (lv_operator_3_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1560:1: (lv_operator_3_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1560:1: (lv_operator_3_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1561:3: lv_operator_3_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getOperatorOperatorEnumRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleReferenceEvaluation3657);
            lv_operator_3_0=ruleOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
            	        }
                   		set(
                   			current, 
                   			"operator",
                    		lv_operator_3_0, 
                    		"Operator");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1577:2: ( ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? ) | otherlv_7= 'null' )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID||LA28_0==42||LA28_0==44||LA28_0==59) ) {
                alt28=1;
            }
            else if ( (LA28_0==40) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1577:3: ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1577:3: ( ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )? )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1577:4: ( (lv_value_4_0= ruleObSelectionStrategy ) ) (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )?
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1577:4: ( (lv_value_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1578:1: (lv_value_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1578:1: (lv_value_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1579:3: lv_value_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getValueObSelectionStrategyParserRuleCall_3_0_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation3680);
                    lv_value_4_0=ruleObSelectionStrategy();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getReferenceEvaluationRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"ObSelectionStrategy");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1595:2: (otherlv_5= '.' ( (otherlv_6= RULE_ID ) ) )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==34) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1595:4: otherlv_5= '.' ( (otherlv_6= RULE_ID ) )
                            {
                            otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleReferenceEvaluation3693); 

                                	newLeafNode(otherlv_5, grammarAccess.getReferenceEvaluationAccess().getFullStopKeyword_3_0_1_0());
                                
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1599:1: ( (otherlv_6= RULE_ID ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1600:1: (otherlv_6= RULE_ID )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1600:1: (otherlv_6= RULE_ID )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1601:3: otherlv_6= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                            	        }
                                    
                            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation3713); 

                            		newLeafNode(otherlv_6, grammarAccess.getReferenceEvaluationAccess().getRefTypeEReferenceCrossReference_3_0_1_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1613:7: otherlv_7= 'null'
                    {
                    otherlv_7=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleReferenceEvaluation3734); 

                        	newLeafNode(otherlv_7, grammarAccess.getReferenceEvaluationAccess().getNullKeyword_3_1());
                        

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1625:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1626:2: (iv_ruleEvaluation= ruleEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1627:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_entryRuleEvaluation3771);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEvaluation3781); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1634:1: ruleEvaluation returns [EObject current=null] : (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeEvaluation_0 = null;

        EObject this_ReferenceEvaluation_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1637:28: ( (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1638:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1638:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 26:
                    {
                    int LA29_3 = input.LA(3);

                    if ( ((LA29_3>=RULE_STRING && LA29_3<=RULE_INT)||LA29_3==27||(LA29_3>=33 && LA29_3<=34)||(LA29_3>=37 && LA29_3<=38)||(LA29_3>=60 && LA29_3<=69)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_3==RULE_ID||LA29_3==40||LA29_3==42||LA29_3==44||LA29_3==59) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 73:
                    {
                    int LA29_4 = input.LA(3);

                    if ( ((LA29_4>=RULE_STRING && LA29_4<=RULE_INT)||LA29_4==27||(LA29_4>=33 && LA29_4<=34)||(LA29_4>=37 && LA29_4<=38)||(LA29_4>=60 && LA29_4<=69)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_4==RULE_ID||LA29_4==40||LA29_4==42||LA29_4==44||LA29_4==59) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 4, input);

                        throw nvae;
                    }
                    }
                    break;
                case 22:
                    {
                    int LA29_5 = input.LA(3);

                    if ( ((LA29_5>=RULE_STRING && LA29_5<=RULE_INT)||LA29_5==27||(LA29_5>=33 && LA29_5<=34)||(LA29_5>=37 && LA29_5<=38)||(LA29_5>=60 && LA29_5<=69)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_5==RULE_ID||LA29_5==40||LA29_5==42||LA29_5==44||LA29_5==59) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 5, input);

                        throw nvae;
                    }
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }

            }
            else if ( (LA29_0==39) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1639:5: this_AttributeEvaluation_0= ruleAttributeEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getAttributeEvaluationParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation3828);
                    this_AttributeEvaluation_0=ruleAttributeEvaluation();

                    state._fsp--;

                     
                            current = this_AttributeEvaluation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1649:5: this_ReferenceEvaluation_1= ruleReferenceEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getReferenceEvaluationParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation3855);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1665:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1666:2: (iv_ruleExpression= ruleExpression EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1667:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression3890);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression3900); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1674:1: ruleExpression returns [EObject current=null] : ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_operator_2_0 = null;

        EObject lv_second_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1677:28: ( ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1678:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1678:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1678:2: () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1678:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1679:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getExpressionAccess().getExpressionAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1684:2: ( (lv_first_1_0= ruleEvaluation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1685:1: (lv_first_1_0= ruleEvaluation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1685:1: (lv_first_1_0= ruleEvaluation )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1686:3: lv_first_1_0= ruleEvaluation
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getFirstEvaluationParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression3955);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1702:2: ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=71 && LA30_0<=72)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1702:3: ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1702:3: ( (lv_operator_2_0= ruleBinaryOperator ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1703:1: (lv_operator_2_0= ruleBinaryOperator )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1703:1: (lv_operator_2_0= ruleBinaryOperator )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1704:3: lv_operator_2_0= ruleBinaryOperator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getOperatorBinaryOperatorParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_ruleExpression3977);
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

            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1720:2: ( (lv_second_3_0= ruleEvaluation ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1721:1: (lv_second_3_0= ruleEvaluation )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1721:1: (lv_second_3_0= ruleEvaluation )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1722:3: lv_second_3_0= ruleEvaluation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getSecondEvaluationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression3998);
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
            	    break loop30;
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1746:1: entryRuleRemoveObjectMutator returns [EObject current=null] : iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF ;
    public final EObject entryRuleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1747:2: (iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1748:2: iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator4036);
            iv_ruleRemoveObjectMutator=ruleRemoveObjectMutator();

            state._fsp--;

             current =iv_ruleRemoveObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveObjectMutator4046); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1755:1: ruleRemoveObjectMutator returns [EObject current=null] : ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? ) ;
    public final EObject ruleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_object_2_0 = null;

        AntlrDatatypeRuleToken lv_min_4_0 = null;

        AntlrDatatypeRuleToken lv_max_6_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1758:28: ( ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1759:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1759:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1759:2: () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1759:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1760:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveObjectMutatorAccess().getRemoveObjectMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleRemoveObjectMutator4092); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveObjectMutatorAccess().getRemoveKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1769:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1770:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1770:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1771:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4113);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1787:2: (otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==27) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==RULE_INT||LA32_1==33||LA32_1==70) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1787:4: otherlv_3= '[' ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )? ( (lv_max_6_0= ruleMaxCardinality ) ) otherlv_7= ']'
                    {
                    otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveObjectMutator4126); 

                        	newLeafNode(otherlv_3, grammarAccess.getRemoveObjectMutatorAccess().getLeftSquareBracketKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1791:1: ( ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==33) ) {
                        int LA31_1 = input.LA(2);

                        if ( (LA31_1==RULE_INT) ) {
                            int LA31_2 = input.LA(3);

                            if ( (LA31_2==28) ) {
                                alt31=1;
                            }
                        }
                    }
                    else if ( (LA31_0==RULE_INT) ) {
                        int LA31_2 = input.LA(2);

                        if ( (LA31_2==28) ) {
                            alt31=1;
                        }
                    }
                    switch (alt31) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1791:2: ( (lv_min_4_0= ruleEInt ) ) otherlv_5= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1791:2: ( (lv_min_4_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1792:1: (lv_min_4_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1792:1: (lv_min_4_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1793:3: lv_min_4_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMinEIntParserRuleCall_3_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveObjectMutator4148);
                            lv_min_4_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_4_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_5=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveObjectMutator4160); 

                                	newLeafNode(otherlv_5, grammarAccess.getRemoveObjectMutatorAccess().getFullStopFullStopKeyword_3_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1813:3: ( (lv_max_6_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1814:1: (lv_max_6_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1814:1: (lv_max_6_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1815:3: lv_max_6_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator4183);
                    lv_max_6_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRemoveObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_6_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_7=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveObjectMutator4195); 

                        	newLeafNode(otherlv_7, grammarAccess.getRemoveObjectMutatorAccess().getRightSquareBracketKeyword_3_3());
                        

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1843:1: entryRuleRemoveReferenceMutator returns [EObject current=null] : iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF ;
    public final EObject entryRuleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1844:2: (iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1845:2: iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator4233);
            iv_ruleRemoveReferenceMutator=ruleRemoveReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveReferenceMutator4243); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1852:1: ruleRemoveReferenceMutator returns [EObject current=null] : (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) ;
    public final EObject ruleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject this_RemoveRandomReferenceMutator_0 = null;

        EObject this_RemoveSpecificReferenceMutator_1 = null;

        EObject this_RemoveCompleteReferenceMutator_2 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1855:28: ( (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1856:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1856:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            int alt33=3;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==41) ) {
                switch ( input.LA(2) ) {
                case 43:
                    {
                    alt33=2;
                    }
                    break;
                case 42:
                    {
                    alt33=1;
                    }
                    break;
                case 44:
                    {
                    alt33=3;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 1, input);

                    throw nvae;
                }

            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1857:5: this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveRandomReferenceMutatorParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator4290);
                    this_RemoveRandomReferenceMutator_0=ruleRemoveRandomReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveRandomReferenceMutator_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1867:5: this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveSpecificReferenceMutatorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator4317);
                    this_RemoveSpecificReferenceMutator_1=ruleRemoveSpecificReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveSpecificReferenceMutator_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1877:5: this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveCompleteReferenceMutatorParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator4344);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1893:1: entryRuleRemoveRandomReferenceMutator returns [EObject current=null] : iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF ;
    public final EObject entryRuleRemoveRandomReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveRandomReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1894:2: (iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1895:2: iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator4379);
            iv_ruleRemoveRandomReferenceMutator=ruleRemoveRandomReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveRandomReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator4389); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1902:1: ruleRemoveRandomReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1905:28: ( ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1906:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1906:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1906:2: () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1906:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1907:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveRandomReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleRemoveRandomReferenceMutator4435); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveRandomReferenceMutator4447); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveRandomReferenceMutatorAccess().getOneKeyword_2());
                
            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRemoveRandomReferenceMutator4459); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveRandomReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1924:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1925:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1925:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1926:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator4479); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveRandomReferenceMutator4491); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveRandomReferenceMutatorAccess().getInKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1941:1: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1942:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1942:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1943:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator4511); 

            		newLeafNode(otherlv_6, grammarAccess.getRemoveRandomReferenceMutatorAccess().getTypeEClassCrossReference_6_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1954:2: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==27) ) {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==RULE_INT||LA35_1==33||LA35_1==70) ) {
                    alt35=1;
                }
            }
            switch (alt35) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1954:4: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveRandomReferenceMutator4524); 

                        	newLeafNode(otherlv_7, grammarAccess.getRemoveRandomReferenceMutatorAccess().getLeftSquareBracketKeyword_7_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1958:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( (LA34_0==33) ) {
                        int LA34_1 = input.LA(2);

                        if ( (LA34_1==RULE_INT) ) {
                            int LA34_2 = input.LA(3);

                            if ( (LA34_2==28) ) {
                                alt34=1;
                            }
                        }
                    }
                    else if ( (LA34_0==RULE_INT) ) {
                        int LA34_2 = input.LA(2);

                        if ( (LA34_2==28) ) {
                            alt34=1;
                        }
                    }
                    switch (alt34) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1958:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1958:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1959:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1959:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1960:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMinEIntParserRuleCall_7_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator4546);
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

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveRandomReferenceMutator4558); 

                                	newLeafNode(otherlv_9, grammarAccess.getRemoveRandomReferenceMutatorAccess().getFullStopFullStopKeyword_7_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1980:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1981:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1981:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1982:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator4581);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveRandomReferenceMutator4593); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2010:1: entryRuleRemoveSpecificReferenceMutator returns [EObject current=null] : iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF ;
    public final EObject entryRuleRemoveSpecificReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveSpecificReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2011:2: (iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2012:2: iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator4631);
            iv_ruleRemoveSpecificReferenceMutator=ruleRemoveSpecificReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveSpecificReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator4641); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2019:1: ruleRemoveSpecificReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2022:28: ( ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2023:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2023:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2023:2: () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2023:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2024:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveSpecificReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleRemoveSpecificReferenceMutator4687); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRemoveSpecificReferenceMutator4699); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2037:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2038:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2038:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2039:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator4719); 

            		newLeafNode(otherlv_3, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveSpecificReferenceMutator4731); 

                	newLeafNode(otherlv_4, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getInKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2054:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2055:1: (lv_container_5_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2055:1: (lv_container_5_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2056:3: lv_container_5_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getContainerObSelectionStrategyParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator4752);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2072:2: (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==27) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==RULE_INT||LA37_1==33||LA37_1==70) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2072:4: otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']'
                    {
                    otherlv_6=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveSpecificReferenceMutator4765); 

                        	newLeafNode(otherlv_6, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2076:1: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )?
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2076:2: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2076:2: ( (lv_min_7_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2077:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2077:1: (lv_min_7_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2078:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator4787);
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

                            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveSpecificReferenceMutator4799); 

                                	newLeafNode(otherlv_8, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2098:3: ( (lv_max_9_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2099:1: (lv_max_9_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2099:1: (lv_max_9_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2100:3: lv_max_9_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator4822);
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

                    otherlv_10=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveSpecificReferenceMutator4834); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2128:1: entryRuleRemoveCompleteReferenceMutator returns [EObject current=null] : iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF ;
    public final EObject entryRuleRemoveCompleteReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveCompleteReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2129:2: (iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2130:2: iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveCompleteReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator4872);
            iv_ruleRemoveCompleteReferenceMutator=ruleRemoveCompleteReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveCompleteReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator4882); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2137:1: ruleRemoveCompleteReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2140:28: ( ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2141:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2141:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2141:2: () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2141:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2142:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveCompleteReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleRemoveCompleteReferenceMutator4928); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRemoveCompleteReferenceMutator4940); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getAllKeyword_2());
                
            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRemoveCompleteReferenceMutator4952); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2159:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2160:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2160:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2161:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator4972); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveCompleteReferenceMutator4984); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getInKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2176:1: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2177:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2177:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2178:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5004); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2197:1: entryRuleCreateObjectMutator returns [EObject current=null] : iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF ;
    public final EObject entryRuleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2198:2: (iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2199:2: iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator5040);
            iv_ruleCreateObjectMutator=ruleCreateObjectMutator();

            state._fsp--;

             current =iv_ruleCreateObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateObjectMutator5050); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2206:1: ruleCreateObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? ) ;
    public final EObject ruleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_15=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        EObject lv_container_5_0 = null;

        EObject lv_attributes_10_0 = null;

        EObject lv_references_11_0 = null;

        EObject lv_attributes_13_0 = null;

        EObject lv_references_14_0 = null;

        AntlrDatatypeRuleToken lv_min_17_0 = null;

        AntlrDatatypeRuleToken lv_max_19_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2209:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2210:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2210:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2210:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )? (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2210:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2210:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2210:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2211:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2211:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2212:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator5093); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCreateObjectMutator5110); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateObjectMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCreateObjectMutator5124); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateObjectMutatorAccess().getCreateKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2236:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2237:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2237:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2238:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator5144); 

            		newLeafNode(otherlv_3, grammarAccess.getCreateObjectMutatorAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2249:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==22) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2249:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCreateObjectMutator5157); 

                        	newLeafNode(otherlv_4, grammarAccess.getCreateObjectMutatorAccess().getInKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2253:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2254:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2254:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2255:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator5178);
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

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2271:2: (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( (LA39_0==34) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2271:4: otherlv_6= '.' ( (otherlv_7= RULE_ID ) )
                            {
                            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleCreateObjectMutator5191); 

                                	newLeafNode(otherlv_6, grammarAccess.getCreateObjectMutatorAccess().getFullStopKeyword_3_2_0());
                                
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2275:1: ( (otherlv_7= RULE_ID ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2276:1: (otherlv_7= RULE_ID )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2276:1: (otherlv_7= RULE_ID )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2277:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator5211); 

                            		newLeafNode(otherlv_7, grammarAccess.getCreateObjectMutatorAccess().getRefTypeEReferenceCrossReference_3_2_1_0()); 
                            	

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2288:6: (otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==11) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2288:8: otherlv_8= 'with' otherlv_9= '{' ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )? (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )* otherlv_15= '}'
                    {
                    otherlv_8=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleCreateObjectMutator5228); 

                        	newLeafNode(otherlv_8, grammarAccess.getCreateObjectMutatorAccess().getWithKeyword_4_0());
                        
                    otherlv_9=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCreateObjectMutator5240); 

                        	newLeafNode(otherlv_9, grammarAccess.getCreateObjectMutatorAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2296:1: ( ( (lv_attributes_10_0= ruleAttributeSet ) ) | ( (lv_references_11_0= ruleReferenceSet ) ) )?
                    int alt41=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA41_1 = input.LA(2);

                            if ( (LA41_1==26) ) {
                                int LA41_5 = input.LA(3);

                                if ( ((LA41_5>=RULE_STRING && LA41_5<=RULE_INT)||LA41_5==27||(LA41_5>=33 && LA41_5<=34)||(LA41_5>=37 && LA41_5<=38)||(LA41_5>=60 && LA41_5<=69)) ) {
                                    alt41=1;
                                }
                                else if ( (LA41_5==RULE_ID||LA41_5==42||LA41_5==44||LA41_5==59) ) {
                                    alt41=2;
                                }
                            }
                            else if ( (LA41_1==22||LA41_1==73) ) {
                                alt41=1;
                            }
                            }
                            break;
                        case 51:
                        case 54:
                        case 55:
                        case 56:
                            {
                            alt41=1;
                            }
                            break;
                        case 57:
                            {
                            alt41=2;
                            }
                            break;
                    }

                    switch (alt41) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2296:2: ( (lv_attributes_10_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2296:2: ( (lv_attributes_10_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2297:1: (lv_attributes_10_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2297:1: (lv_attributes_10_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2298:3: lv_attributes_10_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5262);
                            lv_attributes_10_0=ruleAttributeSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"attributes",
                                    		lv_attributes_10_0, 
                                    		"AttributeSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2315:6: ( (lv_references_11_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2315:6: ( (lv_references_11_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2316:1: (lv_references_11_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2316:1: (lv_references_11_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2317:3: lv_references_11_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5289);
                            lv_references_11_0=ruleReferenceSet();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"references",
                                    		lv_references_11_0, 
                                    		"ReferenceSet");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2333:4: (otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==24) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2333:6: otherlv_12= ',' ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_12=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleCreateObjectMutator5304); 

                    	        	newLeafNode(otherlv_12, grammarAccess.getCreateObjectMutatorAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2337:1: ( ( (lv_attributes_13_0= ruleAttributeSet ) ) | ( (lv_references_14_0= ruleReferenceSet ) ) )
                    	    int alt42=2;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        int LA42_1 = input.LA(2);

                    	        if ( (LA42_1==26) ) {
                    	            int LA42_4 = input.LA(3);

                    	            if ( ((LA42_4>=RULE_STRING && LA42_4<=RULE_INT)||LA42_4==27||(LA42_4>=33 && LA42_4<=34)||(LA42_4>=37 && LA42_4<=38)||(LA42_4>=60 && LA42_4<=69)) ) {
                    	                alt42=1;
                    	            }
                    	            else if ( (LA42_4==RULE_ID||LA42_4==42||LA42_4==44||LA42_4==59) ) {
                    	                alt42=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 42, 4, input);

                    	                throw nvae;
                    	            }
                    	        }
                    	        else if ( (LA42_1==22||LA42_1==73) ) {
                    	            alt42=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 42, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case 51:
                    	    case 54:
                    	    case 55:
                    	    case 56:
                    	        {
                    	        alt42=1;
                    	        }
                    	        break;
                    	    case 57:
                    	        {
                    	        alt42=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 42, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt42) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2337:2: ( (lv_attributes_13_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2337:2: ( (lv_attributes_13_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2338:1: (lv_attributes_13_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2338:1: (lv_attributes_13_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2339:3: lv_attributes_13_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5326);
                    	            lv_attributes_13_0=ruleAttributeSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"attributes",
                    	                    		lv_attributes_13_0, 
                    	                    		"AttributeSet");
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2356:6: ( (lv_references_14_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2356:6: ( (lv_references_14_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2357:1: (lv_references_14_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2357:1: (lv_references_14_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2358:3: lv_references_14_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5353);
                    	            lv_references_14_0=ruleReferenceSet();

                    	            state._fsp--;


                    	            	        if (current==null) {
                    	            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	            	        }
                    	                   		add(
                    	                   			current, 
                    	                   			"references",
                    	                    		lv_references_14_0, 
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
                    	    break loop43;
                        }
                    } while (true);

                    otherlv_15=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCreateObjectMutator5368); 

                        	newLeafNode(otherlv_15, grammarAccess.getCreateObjectMutatorAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2378:3: (otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==27) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==RULE_INT||LA46_1==33||LA46_1==70) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2378:5: otherlv_16= '[' ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )? ( (lv_max_19_0= ruleMaxCardinality ) ) otherlv_20= ']'
                    {
                    otherlv_16=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCreateObjectMutator5383); 

                        	newLeafNode(otherlv_16, grammarAccess.getCreateObjectMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2382:1: ( ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..' )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==33) ) {
                        int LA45_1 = input.LA(2);

                        if ( (LA45_1==RULE_INT) ) {
                            int LA45_2 = input.LA(3);

                            if ( (LA45_2==28) ) {
                                alt45=1;
                            }
                        }
                    }
                    else if ( (LA45_0==RULE_INT) ) {
                        int LA45_2 = input.LA(2);

                        if ( (LA45_2==28) ) {
                            alt45=1;
                        }
                    }
                    switch (alt45) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2382:2: ( (lv_min_17_0= ruleEInt ) ) otherlv_18= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2382:2: ( (lv_min_17_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2383:1: (lv_min_17_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2383:1: (lv_min_17_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2384:3: lv_min_17_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateObjectMutator5405);
                            lv_min_17_0=ruleEInt();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"min",
                                    		lv_min_17_0, 
                                    		"EInt");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_18=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCreateObjectMutator5417); 

                                	newLeafNode(otherlv_18, grammarAccess.getCreateObjectMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2404:3: ( (lv_max_19_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2405:1: (lv_max_19_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2405:1: (lv_max_19_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2406:3: lv_max_19_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator5440);
                    lv_max_19_0=ruleMaxCardinality();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCreateObjectMutatorRule());
                    	        }
                           		set(
                           			current, 
                           			"max",
                            		lv_max_19_0, 
                            		"MaxCardinality");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_20=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCreateObjectMutator5452); 

                        	newLeafNode(otherlv_20, grammarAccess.getCreateObjectMutatorAccess().getRightSquareBracketKeyword_5_3());
                        

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2434:1: entryRuleSelectObjectMutator returns [EObject current=null] : iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF ;
    public final EObject entryRuleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2435:2: (iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2436:2: iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getSelectObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator5490);
            iv_ruleSelectObjectMutator=ruleSelectObjectMutator();

            state._fsp--;

             current =iv_ruleSelectObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectObjectMutator5500); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2443:1: ruleSelectObjectMutator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? ) ;
    public final EObject ruleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_object_3_0 = null;

        EObject lv_container_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2446:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2447:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2447:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2447:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2447:2: ( (lv_name_0_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2448:1: (lv_name_0_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2448:1: (lv_name_0_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2449:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectObjectMutator5542); 

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

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleSelectObjectMutator5559); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectObjectMutatorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleSelectObjectMutator5571); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectObjectMutatorAccess().getSelectKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2473:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2474:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2474:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2475:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator5592);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2491:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )? )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==22) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2491:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSelectObjectMutator5605); 

                        	newLeafNode(otherlv_4, grammarAccess.getSelectObjectMutatorAccess().getInKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2495:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2496:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2496:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2497:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator5626);
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

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2513:2: (otherlv_6= '.' ( (otherlv_7= RULE_ID ) ) )?
                    int alt47=2;
                    int LA47_0 = input.LA(1);

                    if ( (LA47_0==34) ) {
                        alt47=1;
                    }
                    switch (alt47) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2513:4: otherlv_6= '.' ( (otherlv_7= RULE_ID ) )
                            {
                            otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleSelectObjectMutator5639); 

                                	newLeafNode(otherlv_6, grammarAccess.getSelectObjectMutatorAccess().getFullStopKeyword_4_2_0());
                                
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2517:1: ( (otherlv_7= RULE_ID ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2518:1: (otherlv_7= RULE_ID )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2518:1: (otherlv_7= RULE_ID )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2519:3: otherlv_7= RULE_ID
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getSelectObjectMutatorRule());
                            	        }
                                    
                            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectObjectMutator5659); 

                            		newLeafNode(otherlv_7, grammarAccess.getSelectObjectMutatorAccess().getRefTypeEReferenceCrossReference_4_2_1_0()); 
                            	

                            }


                            }


                            }
                            break;

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


    // $ANTLR start "entryRuleModifyInformationMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2538:1: entryRuleModifyInformationMutator returns [EObject current=null] : iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF ;
    public final EObject entryRuleModifyInformationMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyInformationMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2539:2: (iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2540:2: iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyInformationMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator5699);
            iv_ruleModifyInformationMutator=ruleModifyInformationMutator();

            state._fsp--;

             current =iv_ruleModifyInformationMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyInformationMutator5709); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2547:1: ruleModifyInformationMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2550:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2551:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2551:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2551:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2551:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==RULE_ID) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2551:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2551:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2552:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2552:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2553:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyInformationMutator5752); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleModifyInformationMutator5769); 

                        	newLeafNode(otherlv_1, grammarAccess.getModifyInformationMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleModifyInformationMutator5783); 

                	newLeafNode(otherlv_2, grammarAccess.getModifyInformationMutatorAccess().getModifyKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2577:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2578:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2578:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2579:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator5804);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2595:2: (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==11) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2595:4: otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}'
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModifyInformationMutator5817); 

                        	newLeafNode(otherlv_4, grammarAccess.getModifyInformationMutatorAccess().getWithKeyword_3_0());
                        
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModifyInformationMutator5829); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyInformationMutatorAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2603:1: ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )?
                    int alt50=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            int LA50_1 = input.LA(2);

                            if ( (LA50_1==26) ) {
                                int LA50_5 = input.LA(3);

                                if ( ((LA50_5>=RULE_STRING && LA50_5<=RULE_INT)||LA50_5==27||(LA50_5>=33 && LA50_5<=34)||(LA50_5>=37 && LA50_5<=38)||(LA50_5>=60 && LA50_5<=69)) ) {
                                    alt50=1;
                                }
                                else if ( (LA50_5==RULE_ID||LA50_5==42||LA50_5==44||LA50_5==59) ) {
                                    alt50=2;
                                }
                            }
                            else if ( (LA50_1==22||LA50_1==73) ) {
                                alt50=1;
                            }
                            }
                            break;
                        case 51:
                        case 54:
                        case 55:
                        case 56:
                            {
                            alt50=1;
                            }
                            break;
                        case 57:
                            {
                            alt50=2;
                            }
                            break;
                    }

                    switch (alt50) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2603:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2603:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2604:1: (lv_attributes_6_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2604:1: (lv_attributes_6_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2605:3: lv_attributes_6_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5851);
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2622:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2622:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2623:1: (lv_references_7_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2623:1: (lv_references_7_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2624:3: lv_references_7_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5878);
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

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2640:4: (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )*
                    loop52:
                    do {
                        int alt52=2;
                        int LA52_0 = input.LA(1);

                        if ( (LA52_0==24) ) {
                            alt52=1;
                        }


                        switch (alt52) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2640:6: otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_8=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleModifyInformationMutator5893); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getModifyInformationMutatorAccess().getCommaKeyword_3_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2644:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    int alt51=2;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        int LA51_1 = input.LA(2);

                    	        if ( (LA51_1==26) ) {
                    	            int LA51_4 = input.LA(3);

                    	            if ( ((LA51_4>=RULE_STRING && LA51_4<=RULE_INT)||LA51_4==27||(LA51_4>=33 && LA51_4<=34)||(LA51_4>=37 && LA51_4<=38)||(LA51_4>=60 && LA51_4<=69)) ) {
                    	                alt51=1;
                    	            }
                    	            else if ( (LA51_4==RULE_ID||LA51_4==42||LA51_4==44||LA51_4==59) ) {
                    	                alt51=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 51, 4, input);

                    	                throw nvae;
                    	            }
                    	        }
                    	        else if ( (LA51_1==22||LA51_1==73) ) {
                    	            alt51=1;
                    	        }
                    	        else {
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 51, 1, input);

                    	            throw nvae;
                    	        }
                    	        }
                    	        break;
                    	    case 51:
                    	    case 54:
                    	    case 55:
                    	    case 56:
                    	        {
                    	        alt51=1;
                    	        }
                    	        break;
                    	    case 57:
                    	        {
                    	        alt51=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 51, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt51) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2644:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2644:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2645:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2645:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2646:3: lv_attributes_9_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5915);
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
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2663:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2663:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2664:1: (lv_references_10_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2664:1: (lv_references_10_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2665:3: lv_references_10_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5942);
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
                    	    break loop52;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModifyInformationMutator5957); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifyInformationMutatorAccess().getRightCurlyBracketKeyword_3_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2685:3: (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==27) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==RULE_INT||LA55_1==33||LA55_1==70) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2685:5: otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']'
                    {
                    otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifyInformationMutator5972); 

                        	newLeafNode(otherlv_12, grammarAccess.getModifyInformationMutatorAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2689:1: ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )?
                    int alt54=2;
                    int LA54_0 = input.LA(1);

                    if ( (LA54_0==33) ) {
                        int LA54_1 = input.LA(2);

                        if ( (LA54_1==RULE_INT) ) {
                            int LA54_2 = input.LA(3);

                            if ( (LA54_2==28) ) {
                                alt54=1;
                            }
                        }
                    }
                    else if ( (LA54_0==RULE_INT) ) {
                        int LA54_2 = input.LA(2);

                        if ( (LA54_2==28) ) {
                            alt54=1;
                        }
                    }
                    switch (alt54) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2689:2: ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2689:2: ( (lv_min_13_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2690:1: (lv_min_13_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2690:1: (lv_min_13_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2691:3: lv_min_13_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMinEIntParserRuleCall_4_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyInformationMutator5994);
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

                            otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifyInformationMutator6006); 

                                	newLeafNode(otherlv_14, grammarAccess.getModifyInformationMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2711:3: ( (lv_max_15_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2712:1: (lv_max_15_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2712:1: (lv_max_15_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2713:3: lv_max_15_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator6029);
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

                    otherlv_16=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifyInformationMutator6041); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2741:1: entryRuleCreateReferenceMutator returns [EObject current=null] : iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF ;
    public final EObject entryRuleCreateReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2742:2: (iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2743:2: iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator6079);
            iv_ruleCreateReferenceMutator=ruleCreateReferenceMutator();

            state._fsp--;

             current =iv_ruleCreateReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateReferenceMutator6089); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2750:1: ruleCreateReferenceMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2753:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2754:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2755:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2755:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2756:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6132); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCreateReferenceMutator6149); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateReferenceMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCreateReferenceMutator6163); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateReferenceMutatorAccess().getCreateKeyword_1());
                
            otherlv_3=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleCreateReferenceMutator6175); 

                	newLeafNode(otherlv_3, grammarAccess.getCreateReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2784:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2785:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2785:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2786:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6195); 

            		newLeafNode(otherlv_4, grammarAccess.getCreateReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2797:2: (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==48) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2797:4: otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleCreateReferenceMutator6208); 

                        	newLeafNode(otherlv_5, grammarAccess.getCreateReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2801:1: ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2802:1: (lv_target_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2802:1: (lv_target_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2803:3: lv_target_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6229);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2819:4: (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==22) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2819:6: otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCreateReferenceMutator6244); 

                        	newLeafNode(otherlv_7, grammarAccess.getCreateReferenceMutatorAccess().getInKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2823:1: ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2824:1: (lv_source_8_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2824:1: (lv_source_8_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2825:3: lv_source_8_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6265);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2841:4: (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==27) ) {
                int LA60_1 = input.LA(2);

                if ( (LA60_1==RULE_INT||LA60_1==33||LA60_1==70) ) {
                    alt60=1;
                }
            }
            switch (alt60) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2841:6: otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']'
                    {
                    otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCreateReferenceMutator6280); 

                        	newLeafNode(otherlv_9, grammarAccess.getCreateReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2845:1: ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==33) ) {
                        int LA59_1 = input.LA(2);

                        if ( (LA59_1==RULE_INT) ) {
                            int LA59_2 = input.LA(3);

                            if ( (LA59_2==28) ) {
                                alt59=1;
                            }
                        }
                    }
                    else if ( (LA59_0==RULE_INT) ) {
                        int LA59_2 = input.LA(2);

                        if ( (LA59_2==28) ) {
                            alt59=1;
                        }
                    }
                    switch (alt59) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2845:2: ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2845:2: ( (lv_min_10_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2846:1: (lv_min_10_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2846:1: (lv_min_10_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2847:3: lv_min_10_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateReferenceMutator6302);
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

                            otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCreateReferenceMutator6314); 

                                	newLeafNode(otherlv_11, grammarAccess.getCreateReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2867:3: ( (lv_max_12_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2868:1: (lv_max_12_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2868:1: (lv_max_12_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2869:3: lv_max_12_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator6337);
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

                    otherlv_13=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCreateReferenceMutator6349); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2897:1: entryRuleModifySourceReferenceMutator returns [EObject current=null] : iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF ;
    public final EObject entryRuleModifySourceReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifySourceReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2898:2: (iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2899:2: iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifySourceReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator6387);
            iv_ruleModifySourceReferenceMutator=ruleModifySourceReferenceMutator();

            state._fsp--;

             current =iv_ruleModifySourceReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator6397); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2906:1: ruleModifySourceReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2909:28: ( (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2910:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2910:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2910:3: otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleModifySourceReferenceMutator6434); 

                	newLeafNode(otherlv_0, grammarAccess.getModifySourceReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModifySourceReferenceMutator6446); 

                	newLeafNode(otherlv_1, grammarAccess.getModifySourceReferenceMutatorAccess().getSourceKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2918:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2919:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2919:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2920:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifySourceReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator6466); 

            		newLeafNode(otherlv_2, grammarAccess.getModifySourceReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2931:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==23) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2931:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModifySourceReferenceMutator6479); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifySourceReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2935:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2936:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2936:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2937:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator6500);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2953:4: (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==48) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2953:6: otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleModifySourceReferenceMutator6515); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifySourceReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2957:1: ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2958:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2958:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2959:3: lv_newSource_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getNewSourceObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator6536);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2975:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==27) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RULE_INT||LA64_1==33||LA64_1==70) ) {
                    alt64=1;
                }
            }
            switch (alt64) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2975:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifySourceReferenceMutator6551); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifySourceReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2979:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==33) ) {
                        int LA63_1 = input.LA(2);

                        if ( (LA63_1==RULE_INT) ) {
                            int LA63_2 = input.LA(3);

                            if ( (LA63_2==28) ) {
                                alt63=1;
                            }
                        }
                    }
                    else if ( (LA63_0==RULE_INT) ) {
                        int LA63_2 = input.LA(2);

                        if ( (LA63_2==28) ) {
                            alt63=1;
                        }
                    }
                    switch (alt63) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2979:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2979:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2980:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2980:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2981:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator6573);
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

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifySourceReferenceMutator6585); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifySourceReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3001:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3002:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3002:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3003:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator6608);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifySourceReferenceMutator6620); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3031:1: entryRuleModifyTargetReferenceMutator returns [EObject current=null] : iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF ;
    public final EObject entryRuleModifyTargetReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyTargetReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3032:2: (iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3033:2: iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator6658);
            iv_ruleModifyTargetReferenceMutator=ruleModifyTargetReferenceMutator();

            state._fsp--;

             current =iv_ruleModifyTargetReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator6668); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3040:1: ruleModifyTargetReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3043:28: ( (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3044:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3044:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3044:3: otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleModifyTargetReferenceMutator6705); 

                	newLeafNode(otherlv_0, grammarAccess.getModifyTargetReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleModifyTargetReferenceMutator6717); 

                	newLeafNode(otherlv_1, grammarAccess.getModifyTargetReferenceMutatorAccess().getTargetKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3052:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3053:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3053:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3054:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifyTargetReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator6737); 

            		newLeafNode(otherlv_2, grammarAccess.getModifyTargetReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3065:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==23) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3065:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModifyTargetReferenceMutator6750); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifyTargetReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3069:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3070:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3070:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3071:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6771);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3087:4: (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==48) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3087:6: otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleModifyTargetReferenceMutator6786); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyTargetReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3091:1: ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3092:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3092:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3093:3: lv_newTarget_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getNewTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6807);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3109:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==27) ) {
                int LA68_1 = input.LA(2);

                if ( (LA68_1==RULE_INT||LA68_1==33||LA68_1==70) ) {
                    alt68=1;
                }
            }
            switch (alt68) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3109:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifyTargetReferenceMutator6822); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifyTargetReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3113:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt67=2;
                    int LA67_0 = input.LA(1);

                    if ( (LA67_0==33) ) {
                        int LA67_1 = input.LA(2);

                        if ( (LA67_1==RULE_INT) ) {
                            int LA67_2 = input.LA(3);

                            if ( (LA67_2==28) ) {
                                alt67=1;
                            }
                        }
                    }
                    else if ( (LA67_0==RULE_INT) ) {
                        int LA67_2 = input.LA(2);

                        if ( (LA67_2==28) ) {
                            alt67=1;
                        }
                    }
                    switch (alt67) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3113:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3113:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3114:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3114:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3115:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator6844);
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

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifyTargetReferenceMutator6856); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifyTargetReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3135:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3136:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3136:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3137:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator6879);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifyTargetReferenceMutator6891); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3165:1: entryRuleCompositeMutator returns [EObject current=null] : iv_ruleCompositeMutator= ruleCompositeMutator EOF ;
    public final EObject entryRuleCompositeMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3166:2: (iv_ruleCompositeMutator= ruleCompositeMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3167:2: iv_ruleCompositeMutator= ruleCompositeMutator EOF
            {
             newCompositeNode(grammarAccess.getCompositeMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator6929);
            iv_ruleCompositeMutator=ruleCompositeMutator();

            state._fsp--;

             current =iv_ruleCompositeMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeMutator6939); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3174:1: ruleCompositeMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3177:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==RULE_ID) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3179:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3179:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3180:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompositeMutator6982); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCompositeMutator6999); 

                        	newLeafNode(otherlv_1, grammarAccess.getCompositeMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCompositeMutator7013); 

                	newLeafNode(otherlv_2, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3204:1: ( (lv_commands_3_0= ruleMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3205:1: (lv_commands_3_0= ruleMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3205:1: (lv_commands_3_0= ruleMutator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3206:3: lv_commands_3_0= ruleMutator
            {
             
            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator7034);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3222:2: ( (lv_commands_4_0= ruleMutator ) )*
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==RULE_ID||LA70_0==27||LA70_0==41||LA70_0==45||LA70_0==47) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3223:1: (lv_commands_4_0= ruleMutator )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3223:1: (lv_commands_4_0= ruleMutator )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3224:3: lv_commands_4_0= ruleMutator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator7055);
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
            	    break loop70;
                }
            } while (true);

            otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCompositeMutator7068); 

                	newLeafNode(otherlv_5, grammarAccess.getCompositeMutatorAccess().getRightSquareBracketKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3244:1: (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==27) ) {
                int LA72_1 = input.LA(2);

                if ( (LA72_1==RULE_INT||LA72_1==33) ) {
                    alt72=1;
                }
            }
            switch (alt72) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3244:3: otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']'
                    {
                    otherlv_6=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCompositeMutator7081); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3248:1: ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) )
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==33) ) {
                        int LA71_1 = input.LA(2);

                        if ( (LA71_1==RULE_INT) ) {
                            int LA71_2 = input.LA(3);

                            if ( (LA71_2==29) ) {
                                alt71=2;
                            }
                            else if ( (LA71_2==28) ) {
                                alt71=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 71, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 71, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA71_0==RULE_INT) ) {
                        int LA71_2 = input.LA(2);

                        if ( (LA71_2==29) ) {
                            alt71=2;
                        }
                        else if ( (LA71_2==28) ) {
                            alt71=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 71, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 71, 0, input);

                        throw nvae;
                    }
                    switch (alt71) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3248:2: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3248:2: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3248:3: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3248:3: ( (lv_min_7_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3249:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3249:1: (lv_min_7_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3250:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMinEIntParserRuleCall_5_1_0_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCompositeMutator7104);
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

                            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCompositeMutator7116); 

                                	newLeafNode(otherlv_8, grammarAccess.getCompositeMutatorAccess().getFullStopFullStopKeyword_5_1_0_1());
                                
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3270:1: ( (lv_max_9_0= ruleMaxCardinality ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3271:1: (lv_max_9_0= ruleMaxCardinality )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3271:1: (lv_max_9_0= ruleMaxCardinality )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3272:3: lv_max_9_0= ruleMaxCardinality
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_1_0_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator7137);
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3289:6: ( (lv_fixed_10_0= ruleEInt ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3289:6: ( (lv_fixed_10_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3290:1: (lv_fixed_10_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3290:1: (lv_fixed_10_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3291:3: lv_fixed_10_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getFixedEIntParserRuleCall_5_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCompositeMutator7165);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCompositeMutator7178); 

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


    // $ANTLR start "entryRuleAttributeSet"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3319:1: entryRuleAttributeSet returns [EObject current=null] : iv_ruleAttributeSet= ruleAttributeSet EOF ;
    public final EObject entryRuleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSet = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3320:2: (iv_ruleAttributeSet= ruleAttributeSet EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3321:2: iv_ruleAttributeSet= ruleAttributeSet EOF
            {
             newCompositeNode(grammarAccess.getAttributeSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet7216);
            iv_ruleAttributeSet=ruleAttributeSet();

            state._fsp--;

             current =iv_ruleAttributeSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSet7226); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3328:1: ruleAttributeSet returns [EObject current=null] : (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse ) ;
    public final EObject ruleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeScalar_0 = null;

        EObject this_AttributeUnset_1 = null;

        EObject this_AttributeSwap_2 = null;

        EObject this_AttributeCopy_3 = null;

        EObject this_AttributeReverse_4 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3331:28: ( (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3332:1: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3332:1: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse )
            int alt73=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt73=1;
                }
                break;
            case 51:
                {
                alt73=2;
                }
                break;
            case 54:
                {
                alt73=3;
                }
                break;
            case 55:
                {
                alt73=4;
                }
                break;
            case 56:
                {
                alt73=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3333:5: this_AttributeScalar_0= ruleAttributeScalar
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeScalarParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeScalar_in_ruleAttributeSet7273);
                    this_AttributeScalar_0=ruleAttributeScalar();

                    state._fsp--;

                     
                            current = this_AttributeScalar_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3343:5: this_AttributeUnset_1= ruleAttributeUnset
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeUnsetParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_ruleAttributeSet7300);
                    this_AttributeUnset_1=ruleAttributeUnset();

                    state._fsp--;

                     
                            current = this_AttributeUnset_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3353:5: this_AttributeSwap_2= ruleAttributeSwap
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeSwapParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_ruleAttributeSet7327);
                    this_AttributeSwap_2=ruleAttributeSwap();

                    state._fsp--;

                     
                            current = this_AttributeSwap_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3363:5: this_AttributeCopy_3= ruleAttributeCopy
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeCopyParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_ruleAttributeSet7354);
                    this_AttributeCopy_3=ruleAttributeCopy();

                    state._fsp--;

                     
                            current = this_AttributeCopy_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3373:5: this_AttributeReverse_4= ruleAttributeReverse
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeReverseParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_ruleAttributeSet7381);
                    this_AttributeReverse_4=ruleAttributeReverse();

                    state._fsp--;

                     
                            current = this_AttributeReverse_4; 
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3389:1: entryRuleAttributeScalar returns [EObject current=null] : iv_ruleAttributeScalar= ruleAttributeScalar EOF ;
    public final EObject entryRuleAttributeScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeScalar = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3390:2: (iv_ruleAttributeScalar= ruleAttributeScalar EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3391:2: iv_ruleAttributeScalar= ruleAttributeScalar EOF
            {
             newCompositeNode(grammarAccess.getAttributeScalarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeScalar_in_entryRuleAttributeScalar7416);
            iv_ruleAttributeScalar=ruleAttributeScalar();

            state._fsp--;

             current =iv_ruleAttributeScalar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeScalar7426); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3398:1: ruleAttributeScalar returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) ;
    public final EObject ruleAttributeScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3401:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3402:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3402:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3402:2: ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3402:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3403:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3403:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3404:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeScalarRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeScalar7471); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeScalarAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3415:2: ( (lv_value_1_0= ruleAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3416:1: (lv_value_1_0= ruleAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3416:1: (lv_value_1_0= ruleAttributeType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3417:3: lv_value_1_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeScalarAccess().getValueAttributeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeScalar7492);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3441:1: entryRuleAttributeUnset returns [EObject current=null] : iv_ruleAttributeUnset= ruleAttributeUnset EOF ;
    public final EObject entryRuleAttributeUnset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeUnset = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3442:2: (iv_ruleAttributeUnset= ruleAttributeUnset EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3443:2: iv_ruleAttributeUnset= ruleAttributeUnset EOF
            {
             newCompositeNode(grammarAccess.getAttributeUnsetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset7528);
            iv_ruleAttributeUnset=ruleAttributeUnset();

            state._fsp--;

             current =iv_ruleAttributeUnset; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeUnset7538); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3450:1: ruleAttributeUnset returns [EObject current=null] : (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeUnset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3453:28: ( (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3454:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3454:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3454:3: otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleAttributeUnset7575); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeUnsetAccess().getUnsetKeyword_0());
                
            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleAttributeUnset7587); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeUnsetAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3462:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3463:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3463:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3464:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeUnsetRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeUnset7607); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeUnsetAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleAttributeUnset7619); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3487:1: entryRuleAttributeSwap returns [EObject current=null] : iv_ruleAttributeSwap= ruleAttributeSwap EOF ;
    public final EObject entryRuleAttributeSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSwap = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3488:2: (iv_ruleAttributeSwap= ruleAttributeSwap EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3489:2: iv_ruleAttributeSwap= ruleAttributeSwap EOF
            {
             newCompositeNode(grammarAccess.getAttributeSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap7655);
            iv_ruleAttributeSwap=ruleAttributeSwap();

            state._fsp--;

             current =iv_ruleAttributeSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSwap7665); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3496:1: ruleAttributeSwap returns [EObject current=null] : (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3499:28: ( (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3500:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3500:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3500:3: otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleAttributeSwap7702); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeSwapAccess().getSwapKeyword_0());
                
            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleAttributeSwap7714); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3508:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3509:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3509:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3510:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap7734); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAttributeSwap7746); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeSwapAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3525:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==42||LA74_0==44||LA74_0==59) ) {
                alt74=1;
            }
            else if ( (LA74_0==RULE_ID) ) {
                int LA74_2 = input.LA(2);

                if ( (LA74_2==34||LA74_2==58) ) {
                    alt74=1;
                }
            }
            switch (alt74) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3525:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3525:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3526:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3526:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3527:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap7768);
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

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAttributeSwap7780); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeSwapAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3547:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3548:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3548:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3549:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap7802); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleAttributeSwap7814); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3572:1: entryRuleAttributeCopy returns [EObject current=null] : iv_ruleAttributeCopy= ruleAttributeCopy EOF ;
    public final EObject entryRuleAttributeCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeCopy = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3573:2: (iv_ruleAttributeCopy= ruleAttributeCopy EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3574:2: iv_ruleAttributeCopy= ruleAttributeCopy EOF
            {
             newCompositeNode(grammarAccess.getAttributeCopyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy7850);
            iv_ruleAttributeCopy=ruleAttributeCopy();

            state._fsp--;

             current =iv_ruleAttributeCopy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeCopy7860); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3581:1: ruleAttributeCopy returns [EObject current=null] : (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3584:28: ( (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3585:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3585:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3585:3: otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleAttributeCopy7897); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeCopyAccess().getCopyKeyword_0());
                
            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleAttributeCopy7909); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeCopyAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3593:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3594:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3594:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3595:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy7929); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAttributeCopy7941); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeCopyAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3610:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==42||LA75_0==44||LA75_0==59) ) {
                alt75=1;
            }
            else if ( (LA75_0==RULE_ID) ) {
                int LA75_2 = input.LA(2);

                if ( (LA75_2==34||LA75_2==58) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3610:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3610:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3611:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3611:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3612:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeCopyAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy7963);
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

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAttributeCopy7975); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeCopyAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3632:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3633:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3634:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy7997); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleAttributeCopy8009); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3657:1: entryRuleAttributeReverse returns [EObject current=null] : iv_ruleAttributeReverse= ruleAttributeReverse EOF ;
    public final EObject entryRuleAttributeReverse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReverse = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3658:2: (iv_ruleAttributeReverse= ruleAttributeReverse EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3659:2: iv_ruleAttributeReverse= ruleAttributeReverse EOF
            {
             newCompositeNode(grammarAccess.getAttributeReverseRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse8045);
            iv_ruleAttributeReverse=ruleAttributeReverse();

            state._fsp--;

             current =iv_ruleAttributeReverse; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeReverse8055); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3666:1: ruleAttributeReverse returns [EObject current=null] : (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeReverse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3669:28: ( (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3670:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3670:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3670:3: otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeReverse8092); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeReverseAccess().getReverseKeyword_0());
                
            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleAttributeReverse8104); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeReverseAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3678:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3679:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3679:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3680:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeReverseRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeReverse8124); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeReverseAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleAttributeReverse8136); 

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


    // $ANTLR start "entryRuleReferenceSet"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3703:1: entryRuleReferenceSet returns [EObject current=null] : iv_ruleReferenceSet= ruleReferenceSet EOF ;
    public final EObject entryRuleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSet = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3704:2: (iv_ruleReferenceSet= ruleReferenceSet EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3705:2: iv_ruleReferenceSet= ruleReferenceSet EOF
            {
             newCompositeNode(grammarAccess.getReferenceSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet8172);
            iv_ruleReferenceSet=ruleReferenceSet();

            state._fsp--;

             current =iv_ruleReferenceSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSet8182); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3712:1: ruleReferenceSet returns [EObject current=null] : (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap ) ;
    public final EObject ruleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceInit_0 = null;

        EObject this_ReferenceSwap_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3715:28: ( (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3716:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3716:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==57) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3717:5: this_ReferenceInit_0= ruleReferenceInit
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceInitParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_ruleReferenceSet8229);
                    this_ReferenceInit_0=ruleReferenceInit();

                    state._fsp--;

                     
                            current = this_ReferenceInit_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3727:5: this_ReferenceSwap_1= ruleReferenceSwap
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceSwapParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_ruleReferenceSet8256);
                    this_ReferenceSwap_1=ruleReferenceSwap();

                    state._fsp--;

                     
                            current = this_ReferenceSwap_1; 
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3743:1: entryRuleReferenceInit returns [EObject current=null] : iv_ruleReferenceInit= ruleReferenceInit EOF ;
    public final EObject entryRuleReferenceInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceInit = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3744:2: (iv_ruleReferenceInit= ruleReferenceInit EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3745:2: iv_ruleReferenceInit= ruleReferenceInit EOF
            {
             newCompositeNode(grammarAccess.getReferenceInitRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit8291);
            iv_ruleReferenceInit=ruleReferenceInit();

            state._fsp--;

             current =iv_ruleReferenceInit; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceInit8301); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3752:1: ruleReferenceInit returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? ) ;
    public final EObject ruleReferenceInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        EObject lv_object_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3755:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3756:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3756:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3756:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3756:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3757:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3757:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3758:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceInitRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceInit8346); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceInitAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleReferenceInit8358); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceInitAccess().getEqualsSignKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3773:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3774:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3774:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3775:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getReferenceInitAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit8379);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3791:2: (otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==34) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3791:4: otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleReferenceInit8392); 

                        	newLeafNode(otherlv_3, grammarAccess.getReferenceInitAccess().getFullStopKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3795:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3796:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3796:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3797:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceInitRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceInit8412); 

                    		newLeafNode(otherlv_4, grammarAccess.getReferenceInitAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

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
    // $ANTLR end "ruleReferenceInit"


    // $ANTLR start "entryRuleReferenceSwap"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3816:1: entryRuleReferenceSwap returns [EObject current=null] : iv_ruleReferenceSwap= ruleReferenceSwap EOF ;
    public final EObject entryRuleReferenceSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSwap = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3817:2: (iv_ruleReferenceSwap= ruleReferenceSwap EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3818:2: iv_ruleReferenceSwap= ruleReferenceSwap EOF
            {
             newCompositeNode(grammarAccess.getReferenceSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap8450);
            iv_ruleReferenceSwap=ruleReferenceSwap();

            state._fsp--;

             current =iv_ruleReferenceSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSwap8460); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3825:1: ruleReferenceSwap returns [EObject current=null] : (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3828:28: ( (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3829:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3829:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3829:3: otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleReferenceSwap8497); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceSwapAccess().getSwaprefKeyword_0());
                
            otherlv_1=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleReferenceSwap8509); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3837:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3838:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3838:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3839:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap8529); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleReferenceSwap8541); 

                	newLeafNode(otherlv_3, grammarAccess.getReferenceSwapAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3854:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==42||LA78_0==44||LA78_0==59) ) {
                alt78=1;
            }
            else if ( (LA78_0==RULE_ID) ) {
                int LA78_2 = input.LA(2);

                if ( (LA78_2==34||LA78_2==58) ) {
                    alt78=1;
                }
            }
            switch (alt78) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3854:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3854:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3855:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3855:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3856:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap8563);
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

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleReferenceSwap8575); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceSwapAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3876:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3877:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3877:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3878:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap8597); 

            		newLeafNode(otherlv_6, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleReferenceSwap8609); 

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


    // $ANTLR start "entryRuleRandomTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3901:1: entryRuleRandomTypeSelection returns [EObject current=null] : iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF ;
    public final EObject entryRuleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3902:2: (iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3903:2: iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection8645);
            iv_ruleRandomTypeSelection=ruleRandomTypeSelection();

            state._fsp--;

             current =iv_ruleRandomTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomTypeSelection8655); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3910:1: ruleRandomTypeSelection returns [EObject current=null] : ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3913:28: ( ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3914:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3914:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3914:2: () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3914:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3915:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomTypeSelectionAccess().getRandomTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRandomTypeSelection8701); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomTypeSelectionAccess().getOneKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3924:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3925:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3925:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3926:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomTypeSelection8721); 

            		newLeafNode(otherlv_2, grammarAccess.getRandomTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3937:2: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==58) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3937:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleRandomTypeSelection8734); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomTypeSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRandomTypeSelection8746); 

                        	newLeafNode(otherlv_4, grammarAccess.getRandomTypeSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3945:1: ( (lv_expression_5_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3946:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3946:1: (lv_expression_5_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3947:3: lv_expression_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomTypeSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRandomTypeSelection8767);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRandomTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRandomTypeSelection8779); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomTypeSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3975:1: entryRuleSpecificObjectSelection returns [EObject current=null] : iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF ;
    public final EObject entryRuleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificObjectSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3976:2: (iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3977:2: iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificObjectSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection8817);
            iv_ruleSpecificObjectSelection=ruleSpecificObjectSelection();

            state._fsp--;

             current =iv_ruleSpecificObjectSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificObjectSelection8827); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3984:1: ruleSpecificObjectSelection returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? ) ;
    public final EObject ruleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3987:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3988:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3988:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3988:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3988:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3989:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificObjectSelectionAccess().getSpecificObjectSelectionAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3994:2: ( (otherlv_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3995:1: (otherlv_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3995:1: (otherlv_1= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3996:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificObjectSelection8881); 

            		newLeafNode(otherlv_1, grammarAccess.getSpecificObjectSelectionAccess().getObjSelObjectEmitterCrossReference_1_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4007:2: (otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}' )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==58) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4007:4: otherlv_2= 'where' otherlv_3= '{' ( (lv_expression_4_0= ruleExpression ) ) otherlv_5= '}'
                    {
                    otherlv_2=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleSpecificObjectSelection8894); 

                        	newLeafNode(otherlv_2, grammarAccess.getSpecificObjectSelectionAccess().getWhereKeyword_2_0());
                        
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpecificObjectSelection8906); 

                        	newLeafNode(otherlv_3, grammarAccess.getSpecificObjectSelectionAccess().getLeftCurlyBracketKeyword_2_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4015:1: ( (lv_expression_4_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4016:1: (lv_expression_4_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4016:1: (lv_expression_4_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4017:3: lv_expression_4_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificObjectSelectionAccess().getExpressionExpressionParserRuleCall_2_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSpecificObjectSelection8927);
                    lv_expression_4_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificObjectSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_4_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSpecificObjectSelection8939); 

                        	newLeafNode(otherlv_5, grammarAccess.getSpecificObjectSelectionAccess().getRightCurlyBracketKeyword_2_3());
                        

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


    // $ANTLR start "entryRuleCompleteTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4045:1: entryRuleCompleteTypeSelection returns [EObject current=null] : iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF ;
    public final EObject entryRuleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4046:2: (iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4047:2: iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection8977);
            iv_ruleCompleteTypeSelection=ruleCompleteTypeSelection();

            state._fsp--;

             current =iv_ruleCompleteTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompleteTypeSelection8987); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4054:1: ruleCompleteTypeSelection returns [EObject current=null] : ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4057:28: ( ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4058:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4058:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4058:2: () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4058:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4059:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCompleteTypeSelectionAccess().getCompleteTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCompleteTypeSelection9033); 

                	newLeafNode(otherlv_1, grammarAccess.getCompleteTypeSelectionAccess().getAllKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4068:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4069:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4069:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4070:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompleteTypeSelection9053); 

            		newLeafNode(otherlv_2, grammarAccess.getCompleteTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4081:2: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==58) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4081:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleCompleteTypeSelection9066); 

                        	newLeafNode(otherlv_3, grammarAccess.getCompleteTypeSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCompleteTypeSelection9078); 

                        	newLeafNode(otherlv_4, grammarAccess.getCompleteTypeSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4089:1: ( (lv_expression_5_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4090:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4090:1: (lv_expression_5_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4091:3: lv_expression_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompleteTypeSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleCompleteTypeSelection9099);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCompleteTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCompleteTypeSelection9111); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompleteTypeSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4119:1: entryRuleOtherTypeSelection returns [EObject current=null] : iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF ;
    public final EObject entryRuleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4120:2: (iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4121:2: iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection9149);
            iv_ruleOtherTypeSelection=ruleOtherTypeSelection();

            state._fsp--;

             current =iv_ruleOtherTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOtherTypeSelection9159); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4128:1: ruleOtherTypeSelection returns [EObject current=null] : ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4131:28: ( ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4132:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4132:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4132:2: () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4132:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4133:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOtherTypeSelectionAccess().getOtherTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleOtherTypeSelection9205); 

                	newLeafNode(otherlv_1, grammarAccess.getOtherTypeSelectionAccess().getOtherKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4142:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4143:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4143:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4144:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOtherTypeSelection9225); 

            		newLeafNode(otherlv_2, grammarAccess.getOtherTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4155:2: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==58) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4155:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleOtherTypeSelection9238); 

                        	newLeafNode(otherlv_3, grammarAccess.getOtherTypeSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOtherTypeSelection9250); 

                        	newLeafNode(otherlv_4, grammarAccess.getOtherTypeSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4163:1: ( (lv_expression_5_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4164:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4164:1: (lv_expression_5_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4165:3: lv_expression_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOtherTypeSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleOtherTypeSelection9271);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOtherTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOtherTypeSelection9283); 

                        	newLeafNode(otherlv_6, grammarAccess.getOtherTypeSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4193:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4194:2: (iv_ruleBooleanType= ruleBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4195:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_entryRuleBooleanType9321);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanType9331); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4202:1: ruleBooleanType returns [EObject current=null] : (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificBooleanType_0 = null;

        EObject this_RandomBooleanType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4205:28: ( (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4206:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4206:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            int alt83=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA83_1 = input.LA(2);

                if ( (LA83_1==60) ) {
                    alt83=2;
                }
                else if ( ((LA83_1>=37 && LA83_1<=38)) ) {
                    alt83=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 1, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                int LA83_2 = input.LA(2);

                if ( (LA83_2==60) ) {
                    alt83=2;
                }
                else if ( ((LA83_2>=37 && LA83_2<=38)) ) {
                    alt83=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA83_3 = input.LA(2);

                if ( ((LA83_3>=37 && LA83_3<=38)) ) {
                    alt83=1;
                }
                else if ( (LA83_3==60) ) {
                    alt83=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 83, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 83, 0, input);

                throw nvae;
            }

            switch (alt83) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4207:5: this_SpecificBooleanType_0= ruleSpecificBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getSpecificBooleanTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType9378);
                    this_SpecificBooleanType_0=ruleSpecificBooleanType();

                    state._fsp--;

                     
                            current = this_SpecificBooleanType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4217:5: this_RandomBooleanType_1= ruleRandomBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getRandomBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_ruleBooleanType9405);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4233:1: entryRuleRandomBooleanType returns [EObject current=null] : iv_ruleRandomBooleanType= ruleRandomBooleanType EOF ;
    public final EObject entryRuleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4234:2: (iv_ruleRandomBooleanType= ruleRandomBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4235:2: iv_ruleRandomBooleanType= ruleRandomBooleanType EOF
            {
             newCompositeNode(grammarAccess.getRandomBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType9440);
            iv_ruleRandomBooleanType=ruleRandomBooleanType();

            state._fsp--;

             current =iv_ruleRandomBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomBooleanType9450); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4242:1: ruleRandomBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) ;
    public final EObject ruleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4245:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4246:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4246:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4246:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4246:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4247:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomBooleanTypeAccess().getRandomBooleanTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4252:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4253:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4253:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4254:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomBooleanType9505);
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

            otherlv_2=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleRandomBooleanType9517); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4282:1: entryRuleSpecificBooleanType returns [EObject current=null] : iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF ;
    public final EObject entryRuleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4283:2: (iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4284:2: iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF
            {
             newCompositeNode(grammarAccess.getSpecificBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType9553);
            iv_ruleSpecificBooleanType=ruleSpecificBooleanType();

            state._fsp--;

             current =iv_ruleSpecificBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificBooleanType9563); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4291:1: ruleSpecificBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) ;
    public final EObject ruleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4294:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4295:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4295:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4295:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4295:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4296:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificBooleanTypeAccess().getSpecificBooleanTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4301:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4302:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4302:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4303:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificBooleanType9618);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4319:2: ( (lv_value_2_0= ruleEBoolean ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4320:1: (lv_value_2_0= ruleEBoolean )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4320:1: (lv_value_2_0= ruleEBoolean )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4321:3: lv_value_2_0= ruleEBoolean
            {
             
            	        newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getValueEBooleanParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType9639);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4345:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4346:2: (iv_ruleStringType= ruleStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4347:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringType_in_entryRuleStringType9675);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringType9685); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4354:1: ruleStringType returns [EObject current=null] : (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4357:28: ( (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4358:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4358:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            int alt84=7;
            alt84 = dfa84.predict(input);
            switch (alt84) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4359:5: this_SpecificStringType_0= ruleSpecificStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getSpecificStringTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_ruleStringType9732);
                    this_SpecificStringType_0=ruleSpecificStringType();

                    state._fsp--;

                     
                            current = this_SpecificStringType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4369:5: this_RandomStringType_1= ruleRandomStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getRandomStringTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_ruleStringType9759);
                    this_RandomStringType_1=ruleRandomStringType();

                    state._fsp--;

                     
                            current = this_RandomStringType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4379:5: this_UpperStringType_2= ruleUpperStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getUpperStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_ruleStringType9786);
                    this_UpperStringType_2=ruleUpperStringType();

                    state._fsp--;

                     
                            current = this_UpperStringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4389:5: this_LowerStringType_3= ruleLowerStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getLowerStringTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_ruleStringType9813);
                    this_LowerStringType_3=ruleLowerStringType();

                    state._fsp--;

                     
                            current = this_LowerStringType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4399:5: this_CatStartStringType_4= ruleCatStartStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatStartStringTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_ruleStringType9840);
                    this_CatStartStringType_4=ruleCatStartStringType();

                    state._fsp--;

                     
                            current = this_CatStartStringType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4409:5: this_CatEndStringType_5= ruleCatEndStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatEndStringTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_ruleStringType9867);
                    this_CatEndStringType_5=ruleCatEndStringType();

                    state._fsp--;

                     
                            current = this_CatEndStringType_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4419:5: this_ReplaceStringType_6= ruleReplaceStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getReplaceStringTypeParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_ruleStringType9894);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4435:1: entryRuleRandomStringType returns [EObject current=null] : iv_ruleRandomStringType= ruleRandomStringType EOF ;
    public final EObject entryRuleRandomStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4436:2: (iv_ruleRandomStringType= ruleRandomStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4437:2: iv_ruleRandomStringType= ruleRandomStringType EOF
            {
             newCompositeNode(grammarAccess.getRandomStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType9929);
            iv_ruleRandomStringType=ruleRandomStringType();

            state._fsp--;

             current =iv_ruleRandomStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomStringType9939); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4444:1: ruleRandomStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4447:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4448:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4448:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4448:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4448:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4449:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomStringTypeAccess().getRandomStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4454:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4455:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4455:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4456:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomStringType9994);
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

            otherlv_2=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleRandomStringType10006); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomStringTypeAccess().getRandomStringKeyword_2());
                
            otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleRandomStringType10018); 

                	newLeafNode(otherlv_3, grammarAccess.getRandomStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4480:1: ( (lv_min_4_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4481:1: (lv_min_4_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4481:1: (lv_min_4_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4482:3: lv_min_4_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMinEIntParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType10039);
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

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomStringType10051); 

                	newLeafNode(otherlv_5, grammarAccess.getRandomStringTypeAccess().getCommaKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4502:1: ( (lv_max_6_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4503:1: (lv_max_6_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4503:1: (lv_max_6_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4504:3: lv_max_6_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMaxEIntParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType10072);
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

            otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleRandomStringType10084); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4532:1: entryRuleSpecificStringType returns [EObject current=null] : iv_ruleSpecificStringType= ruleSpecificStringType EOF ;
    public final EObject entryRuleSpecificStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4533:2: (iv_ruleSpecificStringType= ruleSpecificStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4534:2: iv_ruleSpecificStringType= ruleSpecificStringType EOF
            {
             newCompositeNode(grammarAccess.getSpecificStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType10120);
            iv_ruleSpecificStringType=ruleSpecificStringType();

            state._fsp--;

             current =iv_ruleSpecificStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificStringType10130); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4541:1: ruleSpecificStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSpecificStringType() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4544:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4545:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4545:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4545:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4545:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4546:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificStringTypeAccess().getSpecificStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4551:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4552:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4552:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4553:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificStringType10185);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4569:2: ( (lv_value_2_0= RULE_STRING ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4570:1: (lv_value_2_0= RULE_STRING )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4570:1: (lv_value_2_0= RULE_STRING )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4571:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSpecificStringType10202); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4595:1: entryRuleUpperStringType returns [EObject current=null] : iv_ruleUpperStringType= ruleUpperStringType EOF ;
    public final EObject entryRuleUpperStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4596:2: (iv_ruleUpperStringType= ruleUpperStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4597:2: iv_ruleUpperStringType= ruleUpperStringType EOF
            {
             newCompositeNode(grammarAccess.getUpperStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType10243);
            iv_ruleUpperStringType=ruleUpperStringType();

            state._fsp--;

             current =iv_ruleUpperStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUpperStringType10253); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4604:1: ruleUpperStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) ;
    public final EObject ruleUpperStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4607:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4609:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUpperStringTypeAccess().getUpperStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4614:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4615:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4615:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4616:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getUpperStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleUpperStringType10308);
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

            otherlv_2=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleUpperStringType10320); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4644:1: entryRuleCatStartStringType returns [EObject current=null] : iv_ruleCatStartStringType= ruleCatStartStringType EOF ;
    public final EObject entryRuleCatStartStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatStartStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4645:2: (iv_ruleCatStartStringType= ruleCatStartStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4646:2: iv_ruleCatStartStringType= ruleCatStartStringType EOF
            {
             newCompositeNode(grammarAccess.getCatStartStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType10356);
            iv_ruleCatStartStringType=ruleCatStartStringType();

            state._fsp--;

             current =iv_ruleCatStartStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatStartStringType10366); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4653:1: ruleCatStartStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatStartStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4656:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4657:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4657:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4657:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4657:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4658:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatStartStringTypeAccess().getCatStartStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4663:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4664:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4664:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4665:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleCatStartStringType10421);
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

            otherlv_2=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleCatStartStringType10433); 

                	newLeafNode(otherlv_2, grammarAccess.getCatStartStringTypeAccess().getCatstartKeyword_2());
                
            otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCatStartStringType10445); 

                	newLeafNode(otherlv_3, grammarAccess.getCatStartStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4689:1: ( (lv_value_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4690:1: (lv_value_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4690:1: (lv_value_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4691:3: lv_value_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getValueEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatStartStringType10466);
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

            otherlv_5=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCatStartStringType10478); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4719:1: entryRuleCatEndStringType returns [EObject current=null] : iv_ruleCatEndStringType= ruleCatEndStringType EOF ;
    public final EObject entryRuleCatEndStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatEndStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4720:2: (iv_ruleCatEndStringType= ruleCatEndStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4721:2: iv_ruleCatEndStringType= ruleCatEndStringType EOF
            {
             newCompositeNode(grammarAccess.getCatEndStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType10514);
            iv_ruleCatEndStringType=ruleCatEndStringType();

            state._fsp--;

             current =iv_ruleCatEndStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatEndStringType10524); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4728:1: ruleCatEndStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatEndStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4731:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4732:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4732:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4732:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4732:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4733:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatEndStringTypeAccess().getCatEndStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4738:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4739:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4739:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4740:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleCatEndStringType10579);
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

            otherlv_2=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleCatEndStringType10591); 

                	newLeafNode(otherlv_2, grammarAccess.getCatEndStringTypeAccess().getCatendKeyword_2());
                
            otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCatEndStringType10603); 

                	newLeafNode(otherlv_3, grammarAccess.getCatEndStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4764:1: ( (lv_value_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4765:1: (lv_value_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4765:1: (lv_value_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4766:3: lv_value_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getValueEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatEndStringType10624);
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

            otherlv_5=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCatEndStringType10636); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4794:1: entryRuleListStringType returns [EObject current=null] : iv_ruleListStringType= ruleListStringType EOF ;
    public final EObject entryRuleListStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4795:2: (iv_ruleListStringType= ruleListStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4796:2: iv_ruleListStringType= ruleListStringType EOF
            {
             newCompositeNode(grammarAccess.getListStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_entryRuleListStringType10672);
            iv_ruleListStringType=ruleListStringType();

            state._fsp--;

             current =iv_ruleListStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListStringType10682); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4803:1: ruleListStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4806:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4807:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4807:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4807:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4807:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4808:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListStringTypeAccess().getListStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4813:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4814:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4814:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4815:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getListStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleListStringType10737);
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

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleListStringType10749); 

                	newLeafNode(otherlv_2, grammarAccess.getListStringTypeAccess().getLeftSquareBracketKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4835:1: ( (lv_value_3_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4836:1: (lv_value_3_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4836:1: (lv_value_3_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4837:3: lv_value_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType10770);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4853:2: (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )*
            loop85:
            do {
                int alt85=2;
                int LA85_0 = input.LA(1);

                if ( (LA85_0==24) ) {
                    alt85=1;
                }


                switch (alt85) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4853:4: otherlv_4= ',' ( (lv_value_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleListStringType10783); 

            	        	newLeafNode(otherlv_4, grammarAccess.getListStringTypeAccess().getCommaKeyword_4_0());
            	        
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4857:1: ( (lv_value_5_0= ruleEString ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4858:1: (lv_value_5_0= ruleEString )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4858:1: (lv_value_5_0= ruleEString )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4859:3: lv_value_5_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType10804);
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
            	    break loop85;
                }
            } while (true);

            otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListStringType10818); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4887:1: entryRuleLowerStringType returns [EObject current=null] : iv_ruleLowerStringType= ruleLowerStringType EOF ;
    public final EObject entryRuleLowerStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4888:2: (iv_ruleLowerStringType= ruleLowerStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4889:2: iv_ruleLowerStringType= ruleLowerStringType EOF
            {
             newCompositeNode(grammarAccess.getLowerStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType10854);
            iv_ruleLowerStringType=ruleLowerStringType();

            state._fsp--;

             current =iv_ruleLowerStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerStringType10864); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4896:1: ruleLowerStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) ;
    public final EObject ruleLowerStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4899:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4900:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4900:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4900:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4900:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4901:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLowerStringTypeAccess().getLowerStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4906:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4907:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4907:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4908:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getLowerStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleLowerStringType10919);
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

            otherlv_2=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleLowerStringType10931); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4936:1: entryRuleReplaceStringType returns [EObject current=null] : iv_ruleReplaceStringType= ruleReplaceStringType EOF ;
    public final EObject entryRuleReplaceStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplaceStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4937:2: (iv_ruleReplaceStringType= ruleReplaceStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4938:2: iv_ruleReplaceStringType= ruleReplaceStringType EOF
            {
             newCompositeNode(grammarAccess.getReplaceStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType10967);
            iv_ruleReplaceStringType=ruleReplaceStringType();

            state._fsp--;

             current =iv_ruleReplaceStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReplaceStringType10977); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4945:1: ruleReplaceStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4948:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4949:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4949:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4949:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4949:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4950:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReplaceStringTypeAccess().getReplaceStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4955:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4956:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4956:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4957:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleReplaceStringType11032);
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

            otherlv_2=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleReplaceStringType11044); 

                	newLeafNode(otherlv_2, grammarAccess.getReplaceStringTypeAccess().getReplaceKeyword_2());
                
            otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleReplaceStringType11056); 

                	newLeafNode(otherlv_3, grammarAccess.getReplaceStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4981:1: ( (lv_oldstring_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4982:1: (lv_oldstring_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4982:1: (lv_oldstring_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4983:3: lv_oldstring_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOldstringEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType11077);
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

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleReplaceStringType11089); 

                	newLeafNode(otherlv_5, grammarAccess.getReplaceStringTypeAccess().getCommaKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5003:1: ( (lv_newstring_6_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5004:1: (lv_newstring_6_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5004:1: (lv_newstring_6_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5005:3: lv_newstring_6_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getNewstringEStringParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType11110);
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

            otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleReplaceStringType11122); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5033:1: entryRuleDoubleType returns [EObject current=null] : iv_ruleDoubleType= ruleDoubleType EOF ;
    public final EObject entryRuleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5034:2: (iv_ruleDoubleType= ruleDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5035:2: iv_ruleDoubleType= ruleDoubleType EOF
            {
             newCompositeNode(grammarAccess.getDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_entryRuleDoubleType11158);
            iv_ruleDoubleType=ruleDoubleType();

            state._fsp--;

             current =iv_ruleDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleType11168); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5042:1: ruleDoubleType returns [EObject current=null] : (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) ;
    public final EObject ruleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificDoubleType_0 = null;

        EObject this_RandomDoubleType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5045:28: ( (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5046:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5046:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            int alt86=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA86_1 = input.LA(2);

                if ( (LA86_1==RULE_INT||(LA86_1>=33 && LA86_1<=34)) ) {
                    alt86=1;
                }
                else if ( (LA86_1==67) ) {
                    alt86=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 1, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                int LA86_2 = input.LA(2);

                if ( (LA86_2==67) ) {
                    alt86=2;
                }
                else if ( (LA86_2==RULE_INT||(LA86_2>=33 && LA86_2<=34)) ) {
                    alt86=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA86_3 = input.LA(2);

                if ( (LA86_3==67) ) {
                    alt86=2;
                }
                else if ( (LA86_3==RULE_INT||(LA86_3>=33 && LA86_3<=34)) ) {
                    alt86=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 86, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5047:5: this_SpecificDoubleType_0= ruleSpecificDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getSpecificDoubleTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType11215);
                    this_SpecificDoubleType_0=ruleSpecificDoubleType();

                    state._fsp--;

                     
                            current = this_SpecificDoubleType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5057:5: this_RandomDoubleType_1= ruleRandomDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getRandomDoubleTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_ruleDoubleType11242);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5073:1: entryRuleRandomDoubleType returns [EObject current=null] : iv_ruleRandomDoubleType= ruleRandomDoubleType EOF ;
    public final EObject entryRuleRandomDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5074:2: (iv_ruleRandomDoubleType= ruleRandomDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5075:2: iv_ruleRandomDoubleType= ruleRandomDoubleType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType11277);
            iv_ruleRandomDoubleType=ruleRandomDoubleType();

            state._fsp--;

             current =iv_ruleRandomDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomDoubleType11287); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5082:1: ruleRandomDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5085:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5086:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5086:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5086:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5086:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5087:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5092:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5093:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5093:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5094:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomDoubleType11342);
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

            otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleRandomDoubleType11354); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5114:1: (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==52) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5114:3: otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleRandomDoubleType11367); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomDoubleTypeAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5118:1: ( (lv_min_4_0= ruleEDouble ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5119:1: (lv_min_4_0= ruleEDouble )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5119:1: (lv_min_4_0= ruleEDouble )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5120:3: lv_min_4_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMinEDoubleParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType11388);
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

                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomDoubleType11400); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomDoubleTypeAccess().getCommaKeyword_3_2());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5140:1: ( (lv_max_6_0= ruleEDouble ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5141:1: (lv_max_6_0= ruleEDouble )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5141:1: (lv_max_6_0= ruleEDouble )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5142:3: lv_max_6_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMaxEDoubleParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType11421);
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

                    otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleRandomDoubleType11433); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5170:1: entryRuleSpecificDoubleType returns [EObject current=null] : iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF ;
    public final EObject entryRuleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5171:2: (iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5172:2: iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF
            {
             newCompositeNode(grammarAccess.getSpecificDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType11471);
            iv_ruleSpecificDoubleType=ruleSpecificDoubleType();

            state._fsp--;

             current =iv_ruleSpecificDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificDoubleType11481); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5179:1: ruleSpecificDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) ;
    public final EObject ruleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5182:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5183:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5183:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5183:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5183:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5184:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificDoubleTypeAccess().getSpecificDoubleTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5189:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5190:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5190:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5191:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificDoubleType11536);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5207:2: ( (lv_value_2_0= ruleEDouble ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5208:1: (lv_value_2_0= ruleEDouble )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5208:1: (lv_value_2_0= ruleEDouble )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5209:3: lv_value_2_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getValueEDoubleParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleSpecificDoubleType11557);
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


    // $ANTLR start "entryRuleIntegerType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5233:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5234:2: (iv_ruleIntegerType= ruleIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5235:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_entryRuleIntegerType11593);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;

             current =iv_ruleIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerType11603); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5242:1: ruleIntegerType returns [EObject current=null] : (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificIntegerType_0 = null;

        EObject this_RandomIntegerType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5245:28: ( (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5246:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5246:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            int alt88=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA88_1 = input.LA(2);

                if ( (LA88_1==RULE_INT||LA88_1==33) ) {
                    alt88=1;
                }
                else if ( (LA88_1==68) ) {
                    alt88=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 1, input);

                    throw nvae;
                }
                }
                break;
            case 73:
                {
                int LA88_2 = input.LA(2);

                if ( (LA88_2==68) ) {
                    alt88=2;
                }
                else if ( (LA88_2==RULE_INT||LA88_2==33) ) {
                    alt88=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA88_3 = input.LA(2);

                if ( (LA88_3==68) ) {
                    alt88=2;
                }
                else if ( (LA88_3==RULE_INT||LA88_3==33) ) {
                    alt88=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5247:5: this_SpecificIntegerType_0= ruleSpecificIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getSpecificIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType11650);
                    this_SpecificIntegerType_0=ruleSpecificIntegerType();

                    state._fsp--;

                     
                            current = this_SpecificIntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5257:5: this_RandomIntegerType_1= ruleRandomIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getRandomIntegerTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_ruleIntegerType11677);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5273:1: entryRuleSpecificIntegerType returns [EObject current=null] : iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF ;
    public final EObject entryRuleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5274:2: (iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5275:2: iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF
            {
             newCompositeNode(grammarAccess.getSpecificIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType11712);
            iv_ruleSpecificIntegerType=ruleSpecificIntegerType();

            state._fsp--;

             current =iv_ruleSpecificIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificIntegerType11722); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5282:1: ruleSpecificIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) ;
    public final EObject ruleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5285:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5286:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5286:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5286:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5286:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5287:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificIntegerTypeAccess().getSpecificIntegerTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5292:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5293:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5293:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5294:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificIntegerType11777);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5310:2: ( (lv_value_2_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5311:1: (lv_value_2_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5311:1: (lv_value_2_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5312:3: lv_value_2_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getValueEIntParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleSpecificIntegerType11798);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5336:1: entryRuleRandomIntegerType returns [EObject current=null] : iv_ruleRandomIntegerType= ruleRandomIntegerType EOF ;
    public final EObject entryRuleRandomIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5337:2: (iv_ruleRandomIntegerType= ruleRandomIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5338:2: iv_ruleRandomIntegerType= ruleRandomIntegerType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType11834);
            iv_ruleRandomIntegerType=ruleRandomIntegerType();

            state._fsp--;

             current =iv_ruleRandomIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomIntegerType11844); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5345:1: ruleRandomIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5348:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5349:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5349:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5349:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5349:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5350:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomIntegerTypeAccess().getRandomIntegerTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5355:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5356:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5356:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5357:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomIntegerType11899);
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

            otherlv_2=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleRandomIntegerType11911); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomIntegerTypeAccess().getRandomIntKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5377:1: (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==52) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5377:3: otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleRandomIntegerType11924); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomIntegerTypeAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5381:1: ( (lv_min_4_0= ruleEInt ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5382:1: (lv_min_4_0= ruleEInt )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5382:1: (lv_min_4_0= ruleEInt )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5383:3: lv_min_4_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMinEIntParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType11945);
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

                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomIntegerType11957); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomIntegerTypeAccess().getCommaKeyword_3_2());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5403:1: ( (lv_max_6_0= ruleEInt ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5404:1: (lv_max_6_0= ruleEInt )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5404:1: (lv_max_6_0= ruleEInt )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5405:3: lv_max_6_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMaxEIntParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType11978);
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

                    otherlv_7=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleRandomIntegerType11990); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5433:1: entryRuleRandomType returns [EObject current=null] : iv_ruleRandomType= ruleRandomType EOF ;
    public final EObject entryRuleRandomType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5434:2: (iv_ruleRandomType= ruleRandomType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5435:2: iv_ruleRandomType= ruleRandomType EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomType_in_entryRuleRandomType12028);
            iv_ruleRandomType=ruleRandomType();

            state._fsp--;

             current =iv_ruleRandomType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomType12038); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5442:1: ruleRandomType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) ;
    public final EObject ruleRandomType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5445:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5446:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5446:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5446:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5446:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5447:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomTypeAccess().getRandomTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5452:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5453:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5453:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5454:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomType12093);
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

            otherlv_2=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleRandomType12105); 

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


    // $ANTLR start "entryRuleMaxCardinality"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5482:1: entryRuleMaxCardinality returns [String current=null] : iv_ruleMaxCardinality= ruleMaxCardinality EOF ;
    public final String entryRuleMaxCardinality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMaxCardinality = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5483:2: (iv_ruleMaxCardinality= ruleMaxCardinality EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5484:2: iv_ruleMaxCardinality= ruleMaxCardinality EOF
            {
             newCompositeNode(grammarAccess.getMaxCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality12142);
            iv_ruleMaxCardinality=ruleMaxCardinality();

            state._fsp--;

             current =iv_ruleMaxCardinality.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxCardinality12153); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5491:1: ruleMaxCardinality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EInt_0= ruleEInt | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleMaxCardinality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EInt_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5494:28: ( (this_EInt_0= ruleEInt | kw= '*' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5495:1: (this_EInt_0= ruleEInt | kw= '*' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5495:1: (this_EInt_0= ruleEInt | kw= '*' )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==RULE_INT||LA90_0==33) ) {
                alt90=1;
            }
            else if ( (LA90_0==70) ) {
                alt90=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5496:5: this_EInt_0= ruleEInt
                    {
                     
                            newCompositeNode(grammarAccess.getMaxCardinalityAccess().getEIntParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleMaxCardinality12200);
                    this_EInt_0=ruleEInt();

                    state._fsp--;


                    		current.merge(this_EInt_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5508:2: kw= '*'
                    {
                    kw=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleMaxCardinality12224); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5521:1: ruleLogicOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) ;
    public final Enumerator ruleLogicOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5523:28: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5524:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5524:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==71) ) {
                alt91=1;
            }
            else if ( (LA91_0==72) ) {
                alt91=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }
            switch (alt91) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5524:2: (enumLiteral_0= 'and' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5524:2: (enumLiteral_0= 'and' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5524:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleLogicOperator12278); 

                            current = grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5530:6: (enumLiteral_1= 'or' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5530:6: (enumLiteral_1= 'or' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5530:8: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleLogicOperator12295); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5540:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5542:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5543:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5543:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) )
            int alt92=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt92=1;
                }
                break;
            case 73:
                {
                alt92=2;
                }
                break;
            case 22:
                {
                alt92=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5543:2: (enumLiteral_0= '=' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5543:2: (enumLiteral_0= '=' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5543:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOperator12340); 

                            current = grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5549:6: (enumLiteral_1= '<>' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5549:6: (enumLiteral_1= '<>' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5549:8: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleOperator12357); 

                            current = grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5555:6: (enumLiteral_2= 'in' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5555:6: (enumLiteral_2= 'in' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5555:8: enumLiteral_2= 'in'
                    {
                    enumLiteral_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleOperator12374); 

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


    // $ANTLR start "ruleRepeat"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5565:1: ruleRepeat returns [Enumerator current=null] : ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) ;
    public final Enumerator ruleRepeat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5567:28: ( ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5568:1: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5568:1: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==74) ) {
                alt93=1;
            }
            else if ( (LA93_0==75) ) {
                alt93=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }
            switch (alt93) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5568:2: (enumLiteral_0= 'yes' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5568:2: (enumLiteral_0= 'yes' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5568:4: enumLiteral_0= 'yes'
                    {
                    enumLiteral_0=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleRepeat12419); 

                            current = grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5574:6: (enumLiteral_1= 'no' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5574:6: (enumLiteral_1= 'no' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5574:8: enumLiteral_1= 'no'
                    {
                    enumLiteral_1=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleRepeat12436); 

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

    // Delegated rules


    protected DFA15 dfa15 = new DFA15(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA84 dfa84 = new DFA84(this);
    static final String DFA15_eotS =
        "\21\uffff";
    static final String DFA15_eofS =
        "\21\uffff";
    static final String DFA15_minS =
        "\1\4\1\32\1\4\1\uffff\2\4\1\33\5\uffff\1\4\1\uffff\1\4\2\uffff";
    static final String DFA15_maxS =
        "\1\57\1\32\1\53\1\uffff\2\73\1\57\5\uffff\1\53\1\uffff\1\53\2\uffff";
    static final String DFA15_acceptS =
        "\3\uffff\1\3\3\uffff\1\6\1\1\1\4\1\11\1\5\1\uffff\1\7\1\uffff\1"+
        "\10\1\2";
    static final String DFA15_specialS =
        "\21\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\26\uffff\1\3\15\uffff\1\5\3\uffff\1\2\1\uffff\1\4",
            "\1\6",
            "\1\10\46\uffff\1\7",
            "",
            "\1\12\45\uffff\1\12\1\uffff\1\12\4\uffff\1\11\1\13\10\uffff"+
            "\1\12",
            "\1\15\45\uffff\1\14\1\17\1\16\16\uffff\1\15",
            "\1\3\21\uffff\1\2\1\20\1\12",
            "",
            "",
            "",
            "",
            "",
            "\1\15\46\uffff\1\17",
            "",
            "\1\15\46\uffff\1\17",
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
            return "836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator )";
        }
    }
    static final String DFA17_eotS =
        "\14\uffff";
    static final String DFA17_eofS =
        "\6\uffff\1\12\5\uffff";
    static final String DFA17_minS =
        "\1\26\3\5\1\uffff\1\6\1\16\5\uffff";
    static final String DFA17_maxS =
        "\1\111\3\105\1\uffff\1\42\1\110\5\uffff";
    static final String DFA17_acceptS =
        "\4\uffff\1\5\2\uffff\1\3\1\4\1\6\1\1\1\2";
    static final String DFA17_specialS =
        "\14\uffff}>";
    static final String[] DFA17_transitionS = {
            "\1\3\3\uffff\1\1\56\uffff\1\2",
            "\1\7\1\6\24\uffff\1\4\5\uffff\1\5\1\10\2\uffff\2\13\25\uffff"+
            "\1\13\6\7\1\10\1\12\1\11",
            "\1\7\1\6\24\uffff\1\4\5\uffff\1\5\1\10\2\uffff\2\13\25\uffff"+
            "\1\13\6\7\1\10\1\12\1\11",
            "\1\7\1\6\24\uffff\1\4\5\uffff\1\5\1\10\2\uffff\2\13\25\uffff"+
            "\1\13\6\7\1\10\1\12\1\11",
            "",
            "\1\6\33\uffff\1\10",
            "\1\12\11\uffff\1\12\11\uffff\1\10\44\uffff\2\12",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "1126:1: (this_IntegerType_0= ruleIntegerType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_DoubleType_3= ruleDoubleType | this_ListStringType_4= ruleListStringType | this_RandomType_5= ruleRandomType )";
        }
    }
    static final String DFA84_eotS =
        "\13\uffff";
    static final String DFA84_eofS =
        "\13\uffff";
    static final String DFA84_minS =
        "\1\26\3\5\7\uffff";
    static final String DFA84_maxS =
        "\1\111\3\102\7\uffff";
    static final String DFA84_acceptS =
        "\4\uffff\1\5\1\6\1\2\1\3\1\1\1\4\1\7";
    static final String DFA84_specialS =
        "\13\uffff}>";
    static final String[] DFA84_transitionS = {
            "\1\3\3\uffff\1\1\56\uffff\1\2",
            "\1\10\67\uffff\1\6\1\7\1\4\1\5\1\11\1\12",
            "\1\10\67\uffff\1\6\1\7\1\4\1\5\1\11\1\12",
            "\1\10\67\uffff\1\6\1\7\1\4\1\5\1\11\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA84_eot = DFA.unpackEncodedString(DFA84_eotS);
    static final short[] DFA84_eof = DFA.unpackEncodedString(DFA84_eofS);
    static final char[] DFA84_min = DFA.unpackEncodedStringToUnsignedChars(DFA84_minS);
    static final char[] DFA84_max = DFA.unpackEncodedStringToUnsignedChars(DFA84_maxS);
    static final short[] DFA84_accept = DFA.unpackEncodedString(DFA84_acceptS);
    static final short[] DFA84_special = DFA.unpackEncodedString(DFA84_specialS);
    static final short[][] DFA84_transition;

    static {
        int numStates = DFA84_transitionS.length;
        DFA84_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA84_transition[i] = DFA.unpackEncodedString(DFA84_transitionS[i]);
        }
    }

    class DFA84 extends DFA {

        public DFA84(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 84;
            this.eot = DFA84_eot;
            this.eof = DFA84_eof;
            this.min = DFA84_min;
            this.max = DFA84_max;
            this.accept = DFA84_accept;
            this.special = DFA84_special;
            this.transition = DFA84_transition;
        }
        public String getDescription() {
            return "4358:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )";
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
        public static final BitSet FOLLOW_13_in_ruleMutatorEnvironment278 = new BitSet(new long[]{0x0000A20008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment299 = new BitSet(new long[]{0x0000A20008004010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment320 = new BitSet(new long[]{0x0000A20008004010L});
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
        public static final BitSet FOLLOW_26_in_ruleBlock1187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000C00L});
        public static final BitSet FOLLOW_ruleRepeat_in_ruleBlock1208 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleBlock1222 = new BitSet(new long[]{0x0000A20008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleBlock1243 = new BitSet(new long[]{0x0000A20008004010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleBlock1264 = new BitSet(new long[]{0x0000A20008004010L});
        public static final BitSet FOLLOW_14_in_ruleBlock1277 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleBlock1290 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleBlock1313 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleBlock1325 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
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
        public static final BitSet FOLLOW_ruleCompositeMutator_in_ruleMutator1693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifySourceReferenceMutator_in_ruleMutator1720 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyTargetReferenceMutator_in_ruleMutator1747 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateReferenceMutator_in_ruleMutator1774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveObjectMutator_in_ruleMutator1801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveReferenceMutator_in_ruleMutator1828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyInformationMutator_in_ruleMutator1855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObSelectionStrategy1900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy1947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy1974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy2001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy2028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomSelection_in_entryRuleRandomSelection2063 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomSelection2073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomTypeSelection_in_ruleRandomSelection2119 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificSelection_in_entryRuleSpecificSelection2153 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificSelection2163 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificObjectSelection_in_ruleSpecificSelection2209 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteSelection_in_entryRuleCompleteSelection2243 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompleteSelection2253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteTypeSelection_in_ruleCompleteSelection2299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherSelection_in_entryRuleOtherSelection2333 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOtherSelection2343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherTypeSelection_in_ruleOtherSelection2389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeType_in_entryRuleAttributeType2423 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeType2433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_ruleAttributeType2480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_ruleAttributeType2507 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_ruleAttributeType2534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_ruleAttributeType2561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_ruleAttributeType2588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomType_in_ruleAttributeType2615 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoad_in_entryRuleLoad2650 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoad2660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleLoad2706 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLoad2727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString2764 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString2775 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString2815 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString2841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt2887 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt2898 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleEInt2937 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt2954 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble3000 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble3011 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleEDouble3050 = new BitSet(new long[]{0x0000000400000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3068 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleEDouble3088 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3103 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_35_in_ruleEDouble3123 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_36_in_ruleEDouble3142 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_33_in_ruleEDouble3157 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_entryRuleEBoolean3222 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEBoolean3233 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleEBoolean3271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEBoolean3290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator3330 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperator3340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogicOperator_in_ruleBinaryOperator3395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation3431 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeEvaluation3441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeEvaluation3495 = new BitSet(new long[]{0x0000000004400000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeEvaluation3516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation3552 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceEvaluation3562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation3617 = new BitSet(new long[]{0x0000000004400000L,0x0000000000000200L});
        public static final BitSet FOLLOW_39_in_ruleReferenceEvaluation3635 = new BitSet(new long[]{0x0000000004400000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleReferenceEvaluation3657 = new BitSet(new long[]{0x0800150000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation3680 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleReferenceEvaluation3693 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation3713 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleReferenceEvaluation3734 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_entryRuleEvaluation3771 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEvaluation3781 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation3828 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation3855 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression3890 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression3900 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression3955 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_ruleExpression3977 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression3998 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
        public static final BitSet FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator4036 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveObjectMutator4046 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleRemoveObjectMutator4092 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4113 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveObjectMutator4126 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveObjectMutator4148 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveObjectMutator4160 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator4183 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveObjectMutator4195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator4233 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveReferenceMutator4243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator4290 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator4317 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator4344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator4379 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator4389 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleRemoveRandomReferenceMutator4435 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleRemoveRandomReferenceMutator4447 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleRemoveRandomReferenceMutator4459 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator4479 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveRandomReferenceMutator4491 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator4511 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveRandomReferenceMutator4524 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator4546 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveRandomReferenceMutator4558 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator4581 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveRandomReferenceMutator4593 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator4631 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator4641 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleRemoveSpecificReferenceMutator4687 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleRemoveSpecificReferenceMutator4699 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator4719 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveSpecificReferenceMutator4731 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator4752 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveSpecificReferenceMutator4765 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator4787 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveSpecificReferenceMutator4799 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator4822 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveSpecificReferenceMutator4834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator4872 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator4882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleRemoveCompleteReferenceMutator4928 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleRemoveCompleteReferenceMutator4940 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleRemoveCompleteReferenceMutator4952 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator4972 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveCompleteReferenceMutator4984 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator5040 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateObjectMutator5050 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator5093 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCreateObjectMutator5110 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleCreateObjectMutator5124 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator5144 = new BitSet(new long[]{0x0000000008400802L});
        public static final BitSet FOLLOW_22_in_ruleCreateObjectMutator5157 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator5178 = new BitSet(new long[]{0x0000000408000802L});
        public static final BitSet FOLLOW_34_in_ruleCreateObjectMutator5191 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator5211 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleCreateObjectMutator5228 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCreateObjectMutator5240 = new BitSet(new long[]{0x03C8000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5262 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5289 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleCreateObjectMutator5304 = new BitSet(new long[]{0x03C8000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5326 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5353 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleCreateObjectMutator5368 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCreateObjectMutator5383 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateObjectMutator5405 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCreateObjectMutator5417 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator5440 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCreateObjectMutator5452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator5490 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectObjectMutator5500 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectObjectMutator5542 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleSelectObjectMutator5559 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleSelectObjectMutator5571 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator5592 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleSelectObjectMutator5605 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator5626 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleSelectObjectMutator5639 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectObjectMutator5659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator5699 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyInformationMutator5709 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyInformationMutator5752 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleModifyInformationMutator5769 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleModifyInformationMutator5783 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator5804 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleModifyInformationMutator5817 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModifyInformationMutator5829 = new BitSet(new long[]{0x03C8000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5851 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5878 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleModifyInformationMutator5893 = new BitSet(new long[]{0x03C8000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator5915 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator5942 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleModifyInformationMutator5957 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifyInformationMutator5972 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyInformationMutator5994 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifyInformationMutator6006 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator6029 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifyInformationMutator6041 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator6079 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateReferenceMutator6089 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6132 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCreateReferenceMutator6149 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleCreateReferenceMutator6163 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleCreateReferenceMutator6175 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6195 = new BitSet(new long[]{0x0001000008400002L});
        public static final BitSet FOLLOW_48_in_ruleCreateReferenceMutator6208 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6229 = new BitSet(new long[]{0x0000000008400002L});
        public static final BitSet FOLLOW_22_in_ruleCreateReferenceMutator6244 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6265 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCreateReferenceMutator6280 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateReferenceMutator6302 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCreateReferenceMutator6314 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator6337 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCreateReferenceMutator6349 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator6387 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator6397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleModifySourceReferenceMutator6434 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleModifySourceReferenceMutator6446 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator6466 = new BitSet(new long[]{0x0001000008800002L});
        public static final BitSet FOLLOW_23_in_ruleModifySourceReferenceMutator6479 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator6500 = new BitSet(new long[]{0x0001000008000002L});
        public static final BitSet FOLLOW_48_in_ruleModifySourceReferenceMutator6515 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator6536 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifySourceReferenceMutator6551 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator6573 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifySourceReferenceMutator6585 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator6608 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifySourceReferenceMutator6620 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator6658 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator6668 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleModifyTargetReferenceMutator6705 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleModifyTargetReferenceMutator6717 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator6737 = new BitSet(new long[]{0x0001000008800002L});
        public static final BitSet FOLLOW_23_in_ruleModifyTargetReferenceMutator6750 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6771 = new BitSet(new long[]{0x0001000008000002L});
        public static final BitSet FOLLOW_48_in_ruleModifyTargetReferenceMutator6786 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator6807 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifyTargetReferenceMutator6822 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator6844 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifyTargetReferenceMutator6856 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator6879 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifyTargetReferenceMutator6891 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator6929 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeMutator6939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompositeMutator6982 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCompositeMutator6999 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleCompositeMutator7013 = new BitSet(new long[]{0x0000A20008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator7034 = new BitSet(new long[]{0x0000A20028000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator7055 = new BitSet(new long[]{0x0000A20028000010L});
        public static final BitSet FOLLOW_29_in_ruleCompositeMutator7068 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCompositeMutator7081 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCompositeMutator7104 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCompositeMutator7116 = new BitSet(new long[]{0x0000000200000040L,0x0000000000000040L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator7137 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCompositeMutator7165 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCompositeMutator7178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet7216 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSet7226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeScalar_in_ruleAttributeSet7273 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_ruleAttributeSet7300 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_ruleAttributeSet7327 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_ruleAttributeSet7354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_ruleAttributeSet7381 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeScalar_in_entryRuleAttributeScalar7416 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeScalar7426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeScalar7471 = new BitSet(new long[]{0x0000000004400000L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeScalar7492 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset7528 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeUnset7538 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleAttributeUnset7575 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleAttributeUnset7587 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeUnset7607 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleAttributeUnset7619 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap7655 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSwap7665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleAttributeSwap7702 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleAttributeSwap7714 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap7734 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleAttributeSwap7746 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap7768 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAttributeSwap7780 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap7802 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleAttributeSwap7814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy7850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeCopy7860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleAttributeCopy7897 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleAttributeCopy7909 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy7929 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleAttributeCopy7941 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy7963 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAttributeCopy7975 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy7997 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleAttributeCopy8009 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse8045 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeReverse8055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleAttributeReverse8092 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleAttributeReverse8104 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeReverse8124 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleAttributeReverse8136 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet8172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSet8182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_ruleReferenceSet8229 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_ruleReferenceSet8256 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit8291 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceInit8301 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceInit8346 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleReferenceInit8358 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit8379 = new BitSet(new long[]{0x0000000400000002L});
        public static final BitSet FOLLOW_34_in_ruleReferenceInit8392 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceInit8412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap8450 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSwap8460 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleReferenceSwap8497 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleReferenceSwap8509 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap8529 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleReferenceSwap8541 = new BitSet(new long[]{0x0800140000000010L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap8563 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleReferenceSwap8575 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap8597 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleReferenceSwap8609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection8645 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomTypeSelection8655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRandomTypeSelection8701 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTypeSelection8721 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_58_in_ruleRandomTypeSelection8734 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleRandomTypeSelection8746 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRandomTypeSelection8767 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleRandomTypeSelection8779 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection8817 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificObjectSelection8827 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificObjectSelection8881 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_58_in_ruleSpecificObjectSelection8894 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSpecificObjectSelection8906 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSpecificObjectSelection8927 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSpecificObjectSelection8939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection8977 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompleteTypeSelection8987 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleCompleteTypeSelection9033 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompleteTypeSelection9053 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_58_in_ruleCompleteTypeSelection9066 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCompleteTypeSelection9078 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleCompleteTypeSelection9099 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCompleteTypeSelection9111 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection9149 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOtherTypeSelection9159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleOtherTypeSelection9205 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOtherTypeSelection9225 = new BitSet(new long[]{0x0400000000000002L});
        public static final BitSet FOLLOW_58_in_ruleOtherTypeSelection9238 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOtherTypeSelection9250 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleOtherTypeSelection9271 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOtherTypeSelection9283 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_entryRuleBooleanType9321 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanType9331 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType9378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_ruleBooleanType9405 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType9440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomBooleanType9450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomBooleanType9505 = new BitSet(new long[]{0x1000000000000000L});
        public static final BitSet FOLLOW_60_in_ruleRandomBooleanType9517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType9553 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificBooleanType9563 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificBooleanType9618 = new BitSet(new long[]{0x0000006000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType9639 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_entryRuleStringType9675 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringType9685 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_ruleStringType9732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_ruleStringType9759 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_ruleStringType9786 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_ruleStringType9813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_ruleStringType9840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_ruleStringType9867 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_ruleStringType9894 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType9929 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomStringType9939 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomStringType9994 = new BitSet(new long[]{0x2000000000000000L});
        public static final BitSet FOLLOW_61_in_ruleRandomStringType10006 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleRandomStringType10018 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType10039 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomStringType10051 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType10072 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleRandomStringType10084 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType10120 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificStringType10130 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificStringType10185 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSpecificStringType10202 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType10243 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUpperStringType10253 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleUpperStringType10308 = new BitSet(new long[]{0x4000000000000000L});
        public static final BitSet FOLLOW_62_in_ruleUpperStringType10320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType10356 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatStartStringType10366 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleCatStartStringType10421 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_63_in_ruleCatStartStringType10433 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCatStartStringType10445 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatStartStringType10466 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleCatStartStringType10478 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType10514 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatEndStringType10524 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleCatEndStringType10579 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
        public static final BitSet FOLLOW_64_in_ruleCatEndStringType10591 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCatEndStringType10603 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatEndStringType10624 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleCatEndStringType10636 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_entryRuleListStringType10672 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListStringType10682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleListStringType10737 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleListStringType10749 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType10770 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_24_in_ruleListStringType10783 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType10804 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_29_in_ruleListStringType10818 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType10854 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerStringType10864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleLowerStringType10919 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleLowerStringType10931 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType10967 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReplaceStringType10977 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleReplaceStringType11032 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleReplaceStringType11044 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleReplaceStringType11056 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType11077 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleReplaceStringType11089 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType11110 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleReplaceStringType11122 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_entryRuleDoubleType11158 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleType11168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType11215 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_ruleDoubleType11242 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType11277 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomDoubleType11287 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomDoubleType11342 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleRandomDoubleType11354 = new BitSet(new long[]{0x0010000000000002L});
        public static final BitSet FOLLOW_52_in_ruleRandomDoubleType11367 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType11388 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomDoubleType11400 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType11421 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleRandomDoubleType11433 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType11471 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificDoubleType11481 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificDoubleType11536 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleSpecificDoubleType11557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_entryRuleIntegerType11593 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerType11603 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType11650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_ruleIntegerType11677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType11712 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificIntegerType11722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificIntegerType11777 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleSpecificIntegerType11798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType11834 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomIntegerType11844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomIntegerType11899 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleRandomIntegerType11911 = new BitSet(new long[]{0x0010000000000002L});
        public static final BitSet FOLLOW_52_in_ruleRandomIntegerType11924 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType11945 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomIntegerType11957 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType11978 = new BitSet(new long[]{0x0020000000000000L});
        public static final BitSet FOLLOW_53_in_ruleRandomIntegerType11990 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomType_in_entryRuleRandomType12028 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomType12038 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomType12093 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleRandomType12105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality12142 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxCardinality12153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleMaxCardinality12200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleMaxCardinality12224 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleLogicOperator12278 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleLogicOperator12295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleOperator12340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleOperator12357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleOperator12374 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_74_in_ruleRepeat12419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleRepeat12436 = new BitSet(new long[]{0x0000000000000002L});
    }


}