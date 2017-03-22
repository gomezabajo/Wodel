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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'with'", "'blocks'", "'{'", "'}'", "'commands'", "'constraints'", "'library'", "'for'", "'metamodel'", "'generate'", "'mutants'", "'in'", "'from'", "','", "'repeat'", "'='", "'['", "'..'", "']'", "'context'", "':'", "'import'", "'-'", "'.'", "'E'", "'e'", "'true'", "'false'", "'self'", "'->'", "'null'", "'remove'", "'one'", "'reference'", "'all'", "'create'", "'select'", "'modify'", "'to'", "'source'", "'target'", "'clone'", "'contents'", "'unset'", "'('", "')'", "'swap'", "'copy'", "'reverse'", "'swapref'", "'where'", "'closure'", "'other'", "'each'", "'random-boolean'", "'random-string'", "'upper'", "'catstart'", "'catend'", "'lower'", "'replace'", "'random-double'", "'min'", "'max'", "'random-int'", "'random'", "'*'", "'and'", "'or'", "'<>'", "'+'", "'/'", "'%'", "'yes'", "'no'"
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

                        if ( (LA3_0==RULE_ID||LA3_0==27||LA3_0==42||LA3_0==46||LA3_0==48||LA3_0==52) ) {
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

                if ( (LA12_0==RULE_ID||LA12_0==27||LA12_0==42||LA12_0==46||LA12_0==48||LA12_0==52) ) {
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:832:1: ruleMutator returns [EObject current=null] : (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator | this_CloneObjectMutator_9= ruleCloneObjectMutator ) ;
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

        EObject this_CloneObjectMutator_9 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:835:28: ( (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator | this_CloneObjectMutator_9= ruleCloneObjectMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator | this_CloneObjectMutator_9= ruleCloneObjectMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator | this_CloneObjectMutator_9= ruleCloneObjectMutator )
            int alt15=10;
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
                case 10 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:927:5: this_CloneObjectMutator_9= ruleCloneObjectMutator
                    {
                     
                            newCompositeNode(grammarAccess.getMutatorAccess().getCloneObjectMutatorParserRuleCall_9()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCloneObjectMutator_in_ruleMutator1882);
                    this_CloneObjectMutator_9=ruleCloneObjectMutator();

                    state._fsp--;

                     
                            current = this_CloneObjectMutator_9; 
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:943:1: entryRuleObSelectionStrategy returns [EObject current=null] : iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF ;
    public final EObject entryRuleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObSelectionStrategy = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:944:2: (iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:945:2: iv_ruleObSelectionStrategy= ruleObSelectionStrategy EOF
            {
             newCompositeNode(grammarAccess.getObSelectionStrategyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1917);
            iv_ruleObSelectionStrategy=ruleObSelectionStrategy();

            state._fsp--;

             current =iv_ruleObSelectionStrategy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObSelectionStrategy1927); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:952:1: ruleObSelectionStrategy returns [EObject current=null] : (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_SubsetSelection_4= ruleSubsetSelection ) ;
    public final EObject ruleObSelectionStrategy() throws RecognitionException {
        EObject current = null;

        EObject this_RandomSelection_0 = null;

        EObject this_SpecificSelection_1 = null;

        EObject this_CompleteSelection_2 = null;

        EObject this_OtherSelection_3 = null;

        EObject this_SubsetSelection_4 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:955:28: ( (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_SubsetSelection_4= ruleSubsetSelection ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:956:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_SubsetSelection_4= ruleSubsetSelection )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:956:1: (this_RandomSelection_0= ruleRandomSelection | this_SpecificSelection_1= ruleSpecificSelection | this_CompleteSelection_2= ruleCompleteSelection | this_OtherSelection_3= ruleOtherSelection | this_SubsetSelection_4= ruleSubsetSelection )
            int alt16=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt16=1;
                }
                break;
            case RULE_ID:
            case 62:
                {
                alt16=2;
                }
                break;
            case 45:
                {
                alt16=3;
                }
                break;
            case 63:
                {
                alt16=4;
                }
                break;
            case 64:
                {
                alt16=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:957:5: this_RandomSelection_0= ruleRandomSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getRandomSelectionParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy1974);
                    this_RandomSelection_0=ruleRandomSelection();

                    state._fsp--;

                     
                            current = this_RandomSelection_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:967:5: this_SpecificSelection_1= ruleSpecificSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getSpecificSelectionParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy2001);
                    this_SpecificSelection_1=ruleSpecificSelection();

                    state._fsp--;

                     
                            current = this_SpecificSelection_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:977:5: this_CompleteSelection_2= ruleCompleteSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getCompleteSelectionParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy2028);
                    this_CompleteSelection_2=ruleCompleteSelection();

                    state._fsp--;

                     
                            current = this_CompleteSelection_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:987:5: this_OtherSelection_3= ruleOtherSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getOtherSelectionParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy2055);
                    this_OtherSelection_3=ruleOtherSelection();

                    state._fsp--;

                     
                            current = this_OtherSelection_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:997:5: this_SubsetSelection_4= ruleSubsetSelection
                    {
                     
                            newCompositeNode(grammarAccess.getObSelectionStrategyAccess().getSubsetSelectionParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSubsetSelection_in_ruleObSelectionStrategy2082);
                    this_SubsetSelection_4=ruleSubsetSelection();

                    state._fsp--;

                     
                            current = this_SubsetSelection_4; 
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
            else if ( (LA17_0==62) ) {
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


    // $ANTLR start "entryRuleSubsetSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1143:1: entryRuleSubsetSelection returns [EObject current=null] : iv_ruleSubsetSelection= ruleSubsetSelection EOF ;
    public final EObject entryRuleSubsetSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubsetSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1144:2: (iv_ruleSubsetSelection= ruleSubsetSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1145:2: iv_ruleSubsetSelection= ruleSubsetSelection EOF
            {
             newCompositeNode(grammarAccess.getSubsetSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSubsetSelection_in_entryRuleSubsetSelection2506);
            iv_ruleSubsetSelection=ruleSubsetSelection();

            state._fsp--;

             current =iv_ruleSubsetSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSubsetSelection2516); 

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
    // $ANTLR end "entryRuleSubsetSelection"


    // $ANTLR start "ruleSubsetSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1152:1: ruleSubsetSelection returns [EObject current=null] : this_EachTypeSelection_0= ruleEachTypeSelection ;
    public final EObject ruleSubsetSelection() throws RecognitionException {
        EObject current = null;

        EObject this_EachTypeSelection_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1155:28: (this_EachTypeSelection_0= ruleEachTypeSelection )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1157:5: this_EachTypeSelection_0= ruleEachTypeSelection
            {
             
                    newCompositeNode(grammarAccess.getSubsetSelectionAccess().getEachTypeSelectionParserRuleCall()); 
                
            pushFollow(FollowSets000.FOLLOW_ruleEachTypeSelection_in_ruleSubsetSelection2562);
            this_EachTypeSelection_0=ruleEachTypeSelection();

            state._fsp--;

             
                    current = this_EachTypeSelection_0; 
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
    // $ANTLR end "ruleSubsetSelection"


    // $ANTLR start "entryRuleAttributeEvaluationType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1173:1: entryRuleAttributeEvaluationType returns [EObject current=null] : iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF ;
    public final EObject entryRuleAttributeEvaluationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluationType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1174:2: (iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1175:2: iv_ruleAttributeEvaluationType= ruleAttributeEvaluationType EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluationType_in_entryRuleAttributeEvaluationType2596);
            iv_ruleAttributeEvaluationType=ruleAttributeEvaluationType();

            state._fsp--;

             current =iv_ruleAttributeEvaluationType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeEvaluationType2606); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1182:1: ruleAttributeEvaluationType returns [EObject current=null] : (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType ) ;
    public final EObject ruleAttributeEvaluationType() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeType_0 = null;

        EObject this_ObjectAttributeType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1185:28: ( (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1186:1: (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1186:1: (this_AttributeType_0= ruleAttributeType | this_ObjectAttributeType_1= ruleObjectAttributeType )
            int alt18=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA18_1 = input.LA(2);

                if ( ((LA18_1>=RULE_STRING && LA18_1<=RULE_INT)||LA18_1==13||LA18_1==27||(LA18_1>=33 && LA18_1<=34)||(LA18_1>=37 && LA18_1<=38)||(LA18_1>=65 && LA18_1<=76)) ) {
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
            case 80:
                {
                int LA18_2 = input.LA(2);

                if ( ((LA18_2>=RULE_STRING && LA18_2<=RULE_INT)||LA18_2==13||LA18_2==27||(LA18_2>=33 && LA18_2<=34)||(LA18_2>=37 && LA18_2<=38)||(LA18_2>=65 && LA18_2<=76)) ) {
                    alt18=1;
                }
                else if ( (LA18_2==RULE_ID) ) {
                    alt18=2;
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

                if ( (LA18_3==RULE_ID) ) {
                    alt18=2;
                }
                else if ( ((LA18_3>=RULE_STRING && LA18_3<=RULE_INT)||LA18_3==13||LA18_3==27||(LA18_3>=33 && LA18_3<=34)||(LA18_3>=37 && LA18_3<=38)||(LA18_3>=65 && LA18_3<=76)) ) {
                    alt18=1;
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1187:5: this_AttributeType_0= ruleAttributeType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeEvaluationTypeAccess().getAttributeTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeEvaluationType2653);
                    this_AttributeType_0=ruleAttributeType();

                    state._fsp--;

                     
                            current = this_AttributeType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1197:5: this_ObjectAttributeType_1= ruleObjectAttributeType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeEvaluationTypeAccess().getObjectAttributeTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleObjectAttributeType_in_ruleAttributeEvaluationType2680);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1213:1: entryRuleAttributeType returns [EObject current=null] : iv_ruleAttributeType= ruleAttributeType EOF ;
    public final EObject entryRuleAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1214:2: (iv_ruleAttributeType= ruleAttributeType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1215:2: iv_ruleAttributeType= ruleAttributeType EOF
            {
             newCompositeNode(grammarAccess.getAttributeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_entryRuleAttributeType2715);
            iv_ruleAttributeType=ruleAttributeType();

            state._fsp--;

             current =iv_ruleAttributeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeType2725); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1222:1: ruleAttributeType returns [EObject current=null] : (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1225:28: ( (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1226:1: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1226:1: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )
            int alt19=6;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1227:5: this_NumberType_0= ruleNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getNumberTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleNumberType_in_ruleAttributeType2772);
                    this_NumberType_0=ruleNumberType();

                    state._fsp--;

                     
                            current = this_NumberType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1237:5: this_BooleanType_1= ruleBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_ruleAttributeType2799);
                    this_BooleanType_1=ruleBooleanType();

                    state._fsp--;

                     
                            current = this_BooleanType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1247:5: this_StringType_2= ruleStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleStringType_in_ruleAttributeType2826);
                    this_StringType_2=ruleStringType();

                    state._fsp--;

                     
                            current = this_StringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1257:5: this_ListStringType_3= ruleListStringType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getListStringTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_ruleAttributeType2853);
                    this_ListStringType_3=ruleListStringType();

                    state._fsp--;

                     
                            current = this_ListStringType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1267:5: this_RandomType_4= ruleRandomType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getRandomTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomType_in_ruleAttributeType2880);
                    this_RandomType_4=ruleRandomType();

                    state._fsp--;

                     
                            current = this_RandomType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1277:5: this_ListType_5= ruleListType
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeTypeAccess().getListTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleListType_in_ruleAttributeType2907);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1293:1: entryRuleNumberType returns [EObject current=null] : iv_ruleNumberType= ruleNumberType EOF ;
    public final EObject entryRuleNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1294:2: (iv_ruleNumberType= ruleNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1295:2: iv_ruleNumberType= ruleNumberType EOF
            {
             newCompositeNode(grammarAccess.getNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleNumberType_in_entryRuleNumberType2942);
            iv_ruleNumberType=ruleNumberType();

            state._fsp--;

             current =iv_ruleNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleNumberType2952); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1302:1: ruleNumberType returns [EObject current=null] : (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType ) ;
    public final EObject ruleNumberType() throws RecognitionException {
        EObject current = null;

        EObject this_IntegerType_0 = null;

        EObject this_DoubleType_1 = null;

        EObject this_MinValueType_2 = null;

        EObject this_MaxValueType_3 = null;

        EObject this_RandomNumberType_4 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1305:28: ( (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1306:1: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1306:1: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )
            int alt20=5;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1307:5: this_IntegerType_0= ruleIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_ruleNumberType2999);
                    this_IntegerType_0=ruleIntegerType();

                    state._fsp--;

                     
                            current = this_IntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1317:5: this_DoubleType_1= ruleDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getDoubleTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_ruleNumberType3026);
                    this_DoubleType_1=ruleDoubleType();

                    state._fsp--;

                     
                            current = this_DoubleType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1327:5: this_MinValueType_2= ruleMinValueType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getMinValueTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMinValueType_in_ruleNumberType3053);
                    this_MinValueType_2=ruleMinValueType();

                    state._fsp--;

                     
                            current = this_MinValueType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1337:5: this_MaxValueType_3= ruleMaxValueType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getMaxValueTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleMaxValueType_in_ruleNumberType3080);
                    this_MaxValueType_3=ruleMaxValueType();

                    state._fsp--;

                     
                            current = this_MaxValueType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1347:5: this_RandomNumberType_4= ruleRandomNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getNumberTypeAccess().getRandomNumberTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomNumberType_in_ruleNumberType3107);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1363:1: entryRuleRandomNumberType returns [EObject current=null] : iv_ruleRandomNumberType= ruleRandomNumberType EOF ;
    public final EObject entryRuleRandomNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1364:2: (iv_ruleRandomNumberType= ruleRandomNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1365:2: iv_ruleRandomNumberType= ruleRandomNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomNumberType_in_entryRuleRandomNumberType3142);
            iv_ruleRandomNumberType=ruleRandomNumberType();

            state._fsp--;

             current =iv_ruleRandomNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomNumberType3152); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1372:1: ruleRandomNumberType returns [EObject current=null] : (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType ) ;
    public final EObject ruleRandomNumberType() throws RecognitionException {
        EObject current = null;

        EObject this_RandomDoubleNumberType_0 = null;

        EObject this_RandomIntegerNumberType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1375:28: ( (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1376:1: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1376:1: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )
            int alt21=2;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1377:5: this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getRandomNumberTypeAccess().getRandomDoubleNumberTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleNumberType_in_ruleRandomNumberType3199);
                    this_RandomDoubleNumberType_0=ruleRandomDoubleNumberType();

                    state._fsp--;

                     
                            current = this_RandomDoubleNumberType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1387:5: this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType
                    {
                     
                            newCompositeNode(grammarAccess.getRandomNumberTypeAccess().getRandomIntegerNumberTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerNumberType_in_ruleRandomNumberType3226);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1403:1: entryRuleLoad returns [EObject current=null] : iv_ruleLoad= ruleLoad EOF ;
    public final EObject entryRuleLoad() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoad = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1404:2: (iv_ruleLoad= ruleLoad EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1405:2: iv_ruleLoad= ruleLoad EOF
            {
             newCompositeNode(grammarAccess.getLoadRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLoad_in_entryRuleLoad3261);
            iv_ruleLoad=ruleLoad();

            state._fsp--;

             current =iv_ruleLoad; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLoad3271); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1412:1: ruleLoad returns [EObject current=null] : ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) ;
    public final EObject ruleLoad() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_file_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1415:28: ( ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1416:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1416:1: ( () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1416:2: () otherlv_1= 'import' ( (lv_file_2_0= ruleEString ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1416:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1417:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLoadAccess().getLoadAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLoad3317); 

                	newLeafNode(otherlv_1, grammarAccess.getLoadAccess().getImportKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1426:1: ( (lv_file_2_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1427:1: (lv_file_2_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1427:1: (lv_file_2_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1428:3: lv_file_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getLoadAccess().getFileEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleLoad3338);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1452:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1453:2: (iv_ruleEString= ruleEString EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1454:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_entryRuleEString3375);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEString3386); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1461:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1464:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1465:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1465:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1465:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEString3426); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1473:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEString3452); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1488:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1489:2: (iv_ruleEInt= ruleEInt EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1490:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_entryRuleEInt3498);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEInt3509); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1497:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1500:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1501:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1501:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1501:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1501:2: (kw= '-' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1502:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEInt3548); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEInt3565); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1522:1: entryRuleEDouble returns [String current=null] : iv_ruleEDouble= ruleEDouble EOF ;
    public final String entryRuleEDouble() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEDouble = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1523:2: (iv_ruleEDouble= ruleEDouble EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1524:2: iv_ruleEDouble= ruleEDouble EOF
            {
             newCompositeNode(grammarAccess.getEDoubleRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_entryRuleEDouble3611);
            iv_ruleEDouble=ruleEDouble();

            state._fsp--;

             current =iv_ruleEDouble.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEDouble3622); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1531:1: ruleEDouble returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleEDouble() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;
        Token this_INT_3=null;
        Token this_INT_7=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1534:28: ( ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:1: ( (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:2: (kw= '-' )? (this_INT_1= RULE_INT )? kw= '.' this_INT_3= RULE_INT ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1535:2: (kw= '-' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1536:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEDouble3661); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1541:3: (this_INT_1= RULE_INT )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_INT) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1541:8: this_INT_1= RULE_INT
                    {
                    this_INT_1=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3679); 

                    		current.merge(this_INT_1);
                        
                     
                        newLeafNode(this_INT_1, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

            kw=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleEDouble3699); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getFullStopKeyword_2()); 
                
            this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3714); 

            		current.merge(this_INT_3);
                
             
                newLeafNode(this_INT_3, grammarAccess.getEDoubleAccess().getINTTerminalRuleCall_3()); 
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1561:1: ( (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( ((LA28_0>=35 && LA28_0<=36)) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1561:2: (kw= 'E' | kw= 'e' ) (kw= '-' )? this_INT_7= RULE_INT
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1561:2: (kw= 'E' | kw= 'e' )
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1562:2: kw= 'E'
                            {
                            kw=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleEDouble3734); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_0()); 
                                

                            }
                            break;
                        case 2 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1569:2: kw= 'e'
                            {
                            kw=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleEDouble3753); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getEKeyword_4_0_1()); 
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1574:2: (kw= '-' )?
                    int alt27=2;
                    int LA27_0 = input.LA(1);

                    if ( (LA27_0==33) ) {
                        alt27=1;
                    }
                    switch (alt27) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1575:2: kw= '-'
                            {
                            kw=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleEDouble3768); 

                                    current.merge(kw);
                                    newLeafNode(kw, grammarAccess.getEDoubleAccess().getHyphenMinusKeyword_4_1()); 
                                

                            }
                            break;

                    }

                    this_INT_7=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleEDouble3785); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1595:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1596:2: (iv_ruleEBoolean= ruleEBoolean EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1597:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_entryRuleEBoolean3833);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEBoolean3844); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1604:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1607:28: ( (kw= 'true' | kw= 'false' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1608:1: (kw= 'true' | kw= 'false' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1608:1: (kw= 'true' | kw= 'false' )
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1609:2: kw= 'true'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleEBoolean3882); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1616:2: kw= 'false'
                    {
                    kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleEBoolean3901); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1629:1: entryRuleBinaryOperator returns [EObject current=null] : iv_ruleBinaryOperator= ruleBinaryOperator EOF ;
    public final EObject entryRuleBinaryOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1630:2: (iv_ruleBinaryOperator= ruleBinaryOperator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1631:2: iv_ruleBinaryOperator= ruleBinaryOperator EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator3941);
            iv_ruleBinaryOperator=ruleBinaryOperator();

            state._fsp--;

             current =iv_ruleBinaryOperator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBinaryOperator3951); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1638:1: ruleBinaryOperator returns [EObject current=null] : ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) ;
    public final EObject ruleBinaryOperator() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1641:28: ( ( () ( (lv_type_1_0= ruleLogicOperator ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1642:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1642:1: ( () ( (lv_type_1_0= ruleLogicOperator ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1642:2: () ( (lv_type_1_0= ruleLogicOperator ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1642:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1643:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getBinaryOperatorAccess().getBinaryOperatorAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1648:2: ( (lv_type_1_0= ruleLogicOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1649:1: (lv_type_1_0= ruleLogicOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1649:1: (lv_type_1_0= ruleLogicOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1650:3: lv_type_1_0= ruleLogicOperator
            {
             
            	        newCompositeNode(grammarAccess.getBinaryOperatorAccess().getTypeLogicOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleLogicOperator_in_ruleBinaryOperator4006);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1674:1: entryRuleAttributeEvaluation returns [EObject current=null] : iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF ;
    public final EObject entryRuleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1675:2: (iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1676:2: iv_ruleAttributeEvaluation= ruleAttributeEvaluation EOF
            {
             newCompositeNode(grammarAccess.getAttributeEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation4042);
            iv_ruleAttributeEvaluation=ruleAttributeEvaluation();

            state._fsp--;

             current =iv_ruleAttributeEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeEvaluation4052); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1683:1: ruleAttributeEvaluation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) ;
    public final EObject ruleAttributeEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1686:28: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1687:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1687:1: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1687:2: () ( (otherlv_1= RULE_ID ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1687:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1688:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getAttributeEvaluationAccess().getAttributeEvaluationAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1693:2: ( (otherlv_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1694:1: (otherlv_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1694:1: (otherlv_1= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1695:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeEvaluationRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeEvaluation4106); 

            		newLeafNode(otherlv_1, grammarAccess.getAttributeEvaluationAccess().getNameEAttributeCrossReference_1_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1706:2: ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1707:1: (lv_value_2_0= ruleAttributeEvaluationType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1707:1: (lv_value_2_0= ruleAttributeEvaluationType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1708:3: lv_value_2_0= ruleAttributeEvaluationType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeEvaluationAccess().getValueAttributeEvaluationTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeEvaluation4127);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1732:1: entryRuleReferenceEvaluation returns [EObject current=null] : iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF ;
    public final EObject entryRuleReferenceEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1733:2: (iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1734:2: iv_ruleReferenceEvaluation= ruleReferenceEvaluation EOF
            {
             newCompositeNode(grammarAccess.getReferenceEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation4163);
            iv_ruleReferenceEvaluation=ruleReferenceEvaluation();

            state._fsp--;

             current =iv_ruleReferenceEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceEvaluation4173); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1741:1: ruleReferenceEvaluation returns [EObject current=null] : ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1744:28: ( ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1745:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1745:1: ( () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1745:2: () ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? ( (lv_operator_5_0= ruleOperator ) ) ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1745:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1746:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReferenceEvaluationAccess().getReferenceEvaluationAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1751:2: ( ( (otherlv_1= RULE_ID ) ) | otherlv_2= 'self' )
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1751:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1751:3: ( (otherlv_1= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1752:1: (otherlv_1= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1752:1: (otherlv_1= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1753:3: otherlv_1= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    	        }
                            
                    otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation4228); 

                    		newLeafNode(otherlv_1, grammarAccess.getReferenceEvaluationAccess().getNameEReferenceCrossReference_1_0_0()); 
                    	

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1765:7: otherlv_2= 'self'
                    {
                    otherlv_2=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleReferenceEvaluation4246); 

                        	newLeafNode(otherlv_2, grammarAccess.getReferenceEvaluationAccess().getSelfKeyword_1_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1769:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==40) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1769:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleReferenceEvaluation4260); 

                        	newLeafNode(otherlv_3, grammarAccess.getReferenceEvaluationAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1773:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1774:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1774:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1775:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getReferenceEvaluationRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceEvaluation4280); 

                    		newLeafNode(otherlv_4, grammarAccess.getReferenceEvaluationAccess().getRefNameEReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1786:4: ( (lv_operator_5_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1787:1: (lv_operator_5_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1787:1: (lv_operator_5_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1788:3: lv_operator_5_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getOperatorOperatorEnumRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleReferenceEvaluation4303);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1804:2: ( ( (lv_value_6_0= ruleObSelectionStrategy ) ) | otherlv_7= 'null' )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_ID||LA32_0==43||LA32_0==45||(LA32_0>=62 && LA32_0<=64)) ) {
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1804:3: ( (lv_value_6_0= ruleObSelectionStrategy ) )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1804:3: ( (lv_value_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1805:1: (lv_value_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1805:1: (lv_value_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1806:3: lv_value_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceEvaluationAccess().getValueObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation4325);
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1823:7: otherlv_7= 'null'
                    {
                    otherlv_7=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleReferenceEvaluation4343); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1835:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1836:2: (iv_ruleEvaluation= ruleEvaluation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1837:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_entryRuleEvaluation4380);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEvaluation4390); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1844:1: ruleEvaluation returns [EObject current=null] : (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject this_AttributeEvaluation_0 = null;

        EObject this_ReferenceEvaluation_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1847:28: ( (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1848:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1848:1: (this_AttributeEvaluation_0= ruleAttributeEvaluation | this_ReferenceEvaluation_1= ruleReferenceEvaluation )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
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
                    case 65:
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
                        else if ( (LA33_7==EOF||LA33_7==14||LA33_7==40||LA33_7==61||(LA33_7>=78 && LA33_7<=79)) ) {
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
                    case 62:
                    case 63:
                    case 64:
                        {
                        alt33=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 33, 3, input);

                        throw nvae;
                    }

                    }
                    break;
                case 80:
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
                    case 65:
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
                        else if ( (LA33_7==EOF||LA33_7==14||LA33_7==40||LA33_7==61||(LA33_7>=78 && LA33_7<=79)) ) {
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
                    case 62:
                    case 63:
                    case 64:
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
                    case 65:
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
                        else if ( (LA33_7==EOF||LA33_7==14||LA33_7==40||LA33_7==61||(LA33_7>=78 && LA33_7<=79)) ) {
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
                    case 62:
                    case 63:
                    case 64:
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
                case 40:
                    {
                    alt33=2;
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1849:5: this_AttributeEvaluation_0= ruleAttributeEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getAttributeEvaluationParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation4437);
                    this_AttributeEvaluation_0=ruleAttributeEvaluation();

                    state._fsp--;

                     
                            current = this_AttributeEvaluation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1859:5: this_ReferenceEvaluation_1= ruleReferenceEvaluation
                    {
                     
                            newCompositeNode(grammarAccess.getEvaluationAccess().getReferenceEvaluationParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation4464);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1875:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1876:2: (iv_ruleExpression= ruleExpression EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1877:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleExpression_in_entryRuleExpression4499);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleExpression4509); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1884:1: ruleExpression returns [EObject current=null] : ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_first_1_0 = null;

        EObject lv_operator_2_0 = null;

        EObject lv_second_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1887:28: ( ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1888:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1888:1: ( () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )* )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1888:2: () ( (lv_first_1_0= ruleEvaluation ) ) ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1888:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1889:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getExpressionAccess().getExpressionAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1894:2: ( (lv_first_1_0= ruleEvaluation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1895:1: (lv_first_1_0= ruleEvaluation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1895:1: (lv_first_1_0= ruleEvaluation )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1896:3: lv_first_1_0= ruleEvaluation
            {
             
            	        newCompositeNode(grammarAccess.getExpressionAccess().getFirstEvaluationParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression4564);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1912:2: ( ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=78 && LA34_0<=79)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1912:3: ( (lv_operator_2_0= ruleBinaryOperator ) ) ( (lv_second_3_0= ruleEvaluation ) )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1912:3: ( (lv_operator_2_0= ruleBinaryOperator ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1913:1: (lv_operator_2_0= ruleBinaryOperator )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1913:1: (lv_operator_2_0= ruleBinaryOperator )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1914:3: lv_operator_2_0= ruleBinaryOperator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getOperatorBinaryOperatorParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleBinaryOperator_in_ruleExpression4586);
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

            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1930:2: ( (lv_second_3_0= ruleEvaluation ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1931:1: (lv_second_3_0= ruleEvaluation )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1931:1: (lv_second_3_0= ruleEvaluation )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1932:3: lv_second_3_0= ruleEvaluation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getExpressionAccess().getSecondEvaluationParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEvaluation_in_ruleExpression4607);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1956:1: entryRuleRemoveObjectMutator returns [EObject current=null] : iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF ;
    public final EObject entryRuleRemoveObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1957:2: (iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1958:2: iv_ruleRemoveObjectMutator= ruleRemoveObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator4645);
            iv_ruleRemoveObjectMutator=ruleRemoveObjectMutator();

            state._fsp--;

             current =iv_ruleRemoveObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveObjectMutator4655); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1965:1: ruleRemoveObjectMutator returns [EObject current=null] : ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1968:28: ( ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1969:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1969:1: ( () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1969:2: () otherlv_1= 'remove' ( (lv_object_2_0= ruleObSelectionStrategy ) ) (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1969:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1970:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveObjectMutatorAccess().getRemoveObjectMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveObjectMutator4701); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveObjectMutatorAccess().getRemoveKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1979:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1980:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1980:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1981:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4722);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1997:2: (otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==23) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:1997:4: otherlv_3= 'from' ( (lv_container_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleRemoveObjectMutator4735); 

                        	newLeafNode(otherlv_3, grammarAccess.getRemoveObjectMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2001:1: ( (lv_container_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2002:1: (lv_container_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2002:1: (lv_container_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2003:3: lv_container_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4756);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2019:4: (otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==27) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==RULE_INT||LA37_1==33||LA37_1==77) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2019:6: otherlv_5= '[' ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )? ( (lv_max_8_0= ruleMaxCardinality ) ) otherlv_9= ']'
                    {
                    otherlv_5=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveObjectMutator4771); 

                        	newLeafNode(otherlv_5, grammarAccess.getRemoveObjectMutatorAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2023:1: ( ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..' )?
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2023:2: ( (lv_min_6_0= ruleEInt ) ) otherlv_7= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2023:2: ( (lv_min_6_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2024:1: (lv_min_6_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2024:1: (lv_min_6_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2025:3: lv_min_6_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMinEIntParserRuleCall_4_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveObjectMutator4793);
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

                            otherlv_7=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveObjectMutator4805); 

                                	newLeafNode(otherlv_7, grammarAccess.getRemoveObjectMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2045:3: ( (lv_max_8_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2046:1: (lv_max_8_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2046:1: (lv_max_8_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2047:3: lv_max_8_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator4828);
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

                    otherlv_9=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveObjectMutator4840); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2075:1: entryRuleRemoveReferenceMutator returns [EObject current=null] : iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF ;
    public final EObject entryRuleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2076:2: (iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2077:2: iv_ruleRemoveReferenceMutator= ruleRemoveReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator4878);
            iv_ruleRemoveReferenceMutator=ruleRemoveReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveReferenceMutator4888); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2084:1: ruleRemoveReferenceMutator returns [EObject current=null] : (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) ;
    public final EObject ruleRemoveReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject this_RemoveRandomReferenceMutator_0 = null;

        EObject this_RemoveSpecificReferenceMutator_1 = null;

        EObject this_RemoveCompleteReferenceMutator_2 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2087:28: ( (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2088:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2088:1: (this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator | this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator | this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator )
            int alt38=3;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==42) ) {
                switch ( input.LA(2) ) {
                case 44:
                    {
                    alt38=2;
                    }
                    break;
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2089:5: this_RemoveRandomReferenceMutator_0= ruleRemoveRandomReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveRandomReferenceMutatorParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator4935);
                    this_RemoveRandomReferenceMutator_0=ruleRemoveRandomReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveRandomReferenceMutator_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2099:5: this_RemoveSpecificReferenceMutator_1= ruleRemoveSpecificReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveSpecificReferenceMutatorParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator4962);
                    this_RemoveSpecificReferenceMutator_1=ruleRemoveSpecificReferenceMutator();

                    state._fsp--;

                     
                            current = this_RemoveSpecificReferenceMutator_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2109:5: this_RemoveCompleteReferenceMutator_2= ruleRemoveCompleteReferenceMutator
                    {
                     
                            newCompositeNode(grammarAccess.getRemoveReferenceMutatorAccess().getRemoveCompleteReferenceMutatorParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator4989);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2125:1: entryRuleRemoveRandomReferenceMutator returns [EObject current=null] : iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF ;
    public final EObject entryRuleRemoveRandomReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveRandomReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2126:2: (iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2127:2: iv_ruleRemoveRandomReferenceMutator= ruleRemoveRandomReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator5024);
            iv_ruleRemoveRandomReferenceMutator=ruleRemoveRandomReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveRandomReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator5034); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2134:1: ruleRemoveRandomReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2137:28: ( ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2138:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2138:1: ( () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2138:2: () otherlv_1= 'remove' otherlv_2= 'one' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2138:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2139:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveRandomReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveRandomReferenceMutator5080); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRemoveRandomReferenceMutator5092); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveRandomReferenceMutatorAccess().getOneKeyword_2());
                
            otherlv_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRemoveRandomReferenceMutator5104); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveRandomReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2156:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2157:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2157:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2158:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5124); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveRandomReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveRandomReferenceMutator5136); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveRandomReferenceMutatorAccess().getInKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2173:1: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2174:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2174:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2175:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveRandomReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5156); 

            		newLeafNode(otherlv_6, grammarAccess.getRemoveRandomReferenceMutatorAccess().getTypeEClassCrossReference_6_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2186:2: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==27) ) {
                int LA40_1 = input.LA(2);

                if ( (LA40_1==RULE_INT||LA40_1==33||LA40_1==77) ) {
                    alt40=1;
                }
            }
            switch (alt40) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2186:4: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveRandomReferenceMutator5169); 

                        	newLeafNode(otherlv_7, grammarAccess.getRemoveRandomReferenceMutatorAccess().getLeftSquareBracketKeyword_7_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2190:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2190:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2190:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2191:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2191:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2192:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMinEIntParserRuleCall_7_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator5191);
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

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveRandomReferenceMutator5203); 

                                	newLeafNode(otherlv_9, grammarAccess.getRemoveRandomReferenceMutatorAccess().getFullStopFullStopKeyword_7_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2212:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2213:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2213:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2214:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveRandomReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_7_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator5226);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveRandomReferenceMutator5238); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2242:1: entryRuleRemoveSpecificReferenceMutator returns [EObject current=null] : iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF ;
    public final EObject entryRuleRemoveSpecificReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveSpecificReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2243:2: (iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2244:2: iv_ruleRemoveSpecificReferenceMutator= ruleRemoveSpecificReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator5276);
            iv_ruleRemoveSpecificReferenceMutator=ruleRemoveSpecificReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveSpecificReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator5286); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2251:1: ruleRemoveSpecificReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2254:28: ( ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2255:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2255:1: ( () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2255:2: () otherlv_1= 'remove' otherlv_2= 'reference' ( (otherlv_3= RULE_ID ) ) otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2255:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2256:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveSpecificReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveSpecificReferenceMutator5332); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRemoveSpecificReferenceMutator5344); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2269:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2270:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2270:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2271:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveSpecificReferenceMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator5364); 

            		newLeafNode(otherlv_3, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveSpecificReferenceMutator5376); 

                	newLeafNode(otherlv_4, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getInKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2286:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2287:1: (lv_container_5_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2287:1: (lv_container_5_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2288:3: lv_container_5_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getContainerObSelectionStrategyParserRuleCall_5_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator5397);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2304:2: (otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']' )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==27) ) {
                int LA42_1 = input.LA(2);

                if ( (LA42_1==RULE_INT||LA42_1==33||LA42_1==77) ) {
                    alt42=1;
                }
            }
            switch (alt42) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2304:4: otherlv_6= '[' ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )? ( (lv_max_9_0= ruleMaxCardinality ) ) otherlv_10= ']'
                    {
                    otherlv_6=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleRemoveSpecificReferenceMutator5410); 

                        	newLeafNode(otherlv_6, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2308:1: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' )?
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2308:2: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2308:2: ( (lv_min_7_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2309:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2309:1: (lv_min_7_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2310:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator5432);
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

                            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleRemoveSpecificReferenceMutator5444); 

                                	newLeafNode(otherlv_8, grammarAccess.getRemoveSpecificReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2330:3: ( (lv_max_9_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2331:1: (lv_max_9_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2331:1: (lv_max_9_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2332:3: lv_max_9_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getRemoveSpecificReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator5467);
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

                    otherlv_10=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleRemoveSpecificReferenceMutator5479); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2360:1: entryRuleRemoveCompleteReferenceMutator returns [EObject current=null] : iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF ;
    public final EObject entryRuleRemoveCompleteReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRemoveCompleteReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2361:2: (iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2362:2: iv_ruleRemoveCompleteReferenceMutator= ruleRemoveCompleteReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getRemoveCompleteReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator5517);
            iv_ruleRemoveCompleteReferenceMutator=ruleRemoveCompleteReferenceMutator();

            state._fsp--;

             current =iv_ruleRemoveCompleteReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator5527); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2369:1: ruleRemoveCompleteReferenceMutator returns [EObject current=null] : ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2372:28: ( ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2373:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2373:1: ( () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2373:2: () otherlv_1= 'remove' otherlv_2= 'all' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) otherlv_5= 'in' ( (otherlv_6= RULE_ID ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2373:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2374:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveCompleteReferenceMutatorAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleRemoveCompleteReferenceMutator5573); 

                	newLeafNode(otherlv_1, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRemoveKeyword_1());
                
            otherlv_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleRemoveCompleteReferenceMutator5585); 

                	newLeafNode(otherlv_2, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getAllKeyword_2());
                
            otherlv_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleRemoveCompleteReferenceMutator5597); 

                	newLeafNode(otherlv_3, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getReferenceKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2391:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2392:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2392:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2393:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5617); 

            		newLeafNode(otherlv_4, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getRefTypeEReferenceCrossReference_4_0()); 
            	

            }


            }

            otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleRemoveCompleteReferenceMutator5629); 

                	newLeafNode(otherlv_5, grammarAccess.getRemoveCompleteReferenceMutatorAccess().getInKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2408:1: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2409:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2409:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2410:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRemoveCompleteReferenceMutatorRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5649); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2429:1: entryRuleCreateObjectMutator returns [EObject current=null] : iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF ;
    public final EObject entryRuleCreateObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2430:2: (iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2431:2: iv_ruleCreateObjectMutator= ruleCreateObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator5685);
            iv_ruleCreateObjectMutator=ruleCreateObjectMutator();

            state._fsp--;

             current =iv_ruleCreateObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateObjectMutator5695); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2438:1: ruleCreateObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2441:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2442:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2442:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2442:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )? (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2442:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==RULE_ID) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2442:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2442:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2443:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2443:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2444:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator5738); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCreateObjectMutator5755); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateObjectMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCreateObjectMutator5769); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateObjectMutatorAccess().getCreateKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2468:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2469:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2469:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2470:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateObjectMutatorRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateObjectMutator5789); 

            		newLeafNode(otherlv_3, grammarAccess.getCreateObjectMutatorAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2481:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==22) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2481:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCreateObjectMutator5802); 

                        	newLeafNode(otherlv_4, grammarAccess.getCreateObjectMutatorAccess().getInKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2485:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2486:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2486:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2487:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator5823);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2503:4: (otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==11) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2503:6: otherlv_6= 'with' otherlv_7= '{' ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )? (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )* otherlv_13= '}'
                    {
                    otherlv_6=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleCreateObjectMutator5838); 

                        	newLeafNode(otherlv_6, grammarAccess.getCreateObjectMutatorAccess().getWithKeyword_4_0());
                        
                    otherlv_7=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCreateObjectMutator5850); 

                        	newLeafNode(otherlv_7, grammarAccess.getCreateObjectMutatorAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2511:1: ( ( (lv_attributes_8_0= ruleAttributeSet ) ) | ( (lv_references_9_0= ruleReferenceSet ) ) )?
                    int alt45=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            switch ( input.LA(2) ) {
                                case 26:
                                    {
                                    int LA45_5 = input.LA(3);

                                    if ( ((LA45_5>=RULE_STRING && LA45_5<=RULE_INT)||LA45_5==13||LA45_5==27||(LA45_5>=33 && LA45_5<=34)||(LA45_5>=37 && LA45_5<=38)||(LA45_5>=65 && LA45_5<=76)) ) {
                                        alt45=1;
                                    }
                                    else if ( (LA45_5==RULE_ID||LA45_5==43||LA45_5==45||(LA45_5>=62 && LA45_5<=64)) ) {
                                        alt45=2;
                                    }
                                    }
                                    break;
                                case 22:
                                case 33:
                                case 77:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                    {
                                    alt45=1;
                                    }
                                    break;
                                case 34:
                                    {
                                    alt45=2;
                                    }
                                    break;
                            }

                            }
                            break;
                        case 54:
                        case 57:
                        case 58:
                        case 59:
                            {
                            alt45=1;
                            }
                            break;
                        case 60:
                            {
                            alt45=2;
                            }
                            break;
                    }

                    switch (alt45) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2511:2: ( (lv_attributes_8_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2511:2: ( (lv_attributes_8_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2512:1: (lv_attributes_8_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2512:1: (lv_attributes_8_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2513:3: lv_attributes_8_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5872);
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2530:6: ( (lv_references_9_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2530:6: ( (lv_references_9_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2531:1: (lv_references_9_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2531:1: (lv_references_9_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2532:3: lv_references_9_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5899);
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

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2548:4: (otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) ) )*
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==24) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2548:6: otherlv_10= ',' ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_10=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleCreateObjectMutator5914); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getCreateObjectMutatorAccess().getCommaKeyword_4_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2552:1: ( ( (lv_attributes_11_0= ruleAttributeSet ) ) | ( (lv_references_12_0= ruleReferenceSet ) ) )
                    	    int alt46=2;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        switch ( input.LA(2) ) {
                    	        case 34:
                    	            {
                    	            alt46=2;
                    	            }
                    	            break;
                    	        case 26:
                    	            {
                    	            int LA46_4 = input.LA(3);

                    	            if ( ((LA46_4>=RULE_STRING && LA46_4<=RULE_INT)||LA46_4==13||LA46_4==27||(LA46_4>=33 && LA46_4<=34)||(LA46_4>=37 && LA46_4<=38)||(LA46_4>=65 && LA46_4<=76)) ) {
                    	                alt46=1;
                    	            }
                    	            else if ( (LA46_4==RULE_ID||LA46_4==43||LA46_4==45||(LA46_4>=62 && LA46_4<=64)) ) {
                    	                alt46=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 46, 4, input);

                    	                throw nvae;
                    	            }
                    	            }
                    	            break;
                    	        case 22:
                    	        case 33:
                    	        case 77:
                    	        case 80:
                    	        case 81:
                    	        case 82:
                    	        case 83:
                    	            {
                    	            alt46=1;
                    	            }
                    	            break;
                    	        default:
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 46, 1, input);

                    	            throw nvae;
                    	        }

                    	        }
                    	        break;
                    	    case 54:
                    	    case 57:
                    	    case 58:
                    	    case 59:
                    	        {
                    	        alt46=1;
                    	        }
                    	        break;
                    	    case 60:
                    	        {
                    	        alt46=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 46, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt46) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2552:2: ( (lv_attributes_11_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2552:2: ( (lv_attributes_11_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2553:1: (lv_attributes_11_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2553:1: (lv_attributes_11_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2554:3: lv_attributes_11_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_4_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5936);
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
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2571:6: ( (lv_references_12_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2571:6: ( (lv_references_12_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2572:1: (lv_references_12_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2572:1: (lv_references_12_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2573:3: lv_references_12_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_4_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5963);
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

                    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCreateObjectMutator5978); 

                        	newLeafNode(otherlv_13, grammarAccess.getCreateObjectMutatorAccess().getRightCurlyBracketKeyword_4_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2593:3: (otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==27) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==RULE_INT||LA50_1==33||LA50_1==77) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2593:5: otherlv_14= '[' ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )? ( (lv_max_17_0= ruleMaxCardinality ) ) otherlv_18= ']'
                    {
                    otherlv_14=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCreateObjectMutator5993); 

                        	newLeafNode(otherlv_14, grammarAccess.getCreateObjectMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2597:1: ( ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..' )?
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2597:2: ( (lv_min_15_0= ruleEInt ) ) otherlv_16= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2597:2: ( (lv_min_15_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2598:1: (lv_min_15_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2598:1: (lv_min_15_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2599:3: lv_min_15_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateObjectMutator6015);
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

                            otherlv_16=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCreateObjectMutator6027); 

                                	newLeafNode(otherlv_16, grammarAccess.getCreateObjectMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2619:3: ( (lv_max_17_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2620:1: (lv_max_17_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2620:1: (lv_max_17_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2621:3: lv_max_17_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator6050);
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

                    otherlv_18=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCreateObjectMutator6062); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2649:1: entryRuleSelectObjectMutator returns [EObject current=null] : iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF ;
    public final EObject entryRuleSelectObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelectObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2650:2: (iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2651:2: iv_ruleSelectObjectMutator= ruleSelectObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getSelectObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator6100);
            iv_ruleSelectObjectMutator=ruleSelectObjectMutator();

            state._fsp--;

             current =iv_ruleSelectObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSelectObjectMutator6110); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2658:1: ruleSelectObjectMutator returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2661:28: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2662:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2662:1: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2662:2: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' otherlv_2= 'select' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2662:2: ( (lv_name_0_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2663:1: (lv_name_0_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2663:1: (lv_name_0_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2664:3: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSelectObjectMutator6152); 

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

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleSelectObjectMutator6169); 

                	newLeafNode(otherlv_1, grammarAccess.getSelectObjectMutatorAccess().getEqualsSignKeyword_1());
                
            otherlv_2=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleSelectObjectMutator6181); 

                	newLeafNode(otherlv_2, grammarAccess.getSelectObjectMutatorAccess().getSelectKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2688:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2689:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2689:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2690:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6202);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2706:2: (otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==22) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2706:4: otherlv_4= 'in' ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_4=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSelectObjectMutator6215); 

                        	newLeafNode(otherlv_4, grammarAccess.getSelectObjectMutatorAccess().getInKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2710:1: ( (lv_container_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2711:1: (lv_container_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2711:1: (lv_container_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2712:3: lv_container_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getSelectObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6236);
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


    // $ANTLR start "entryRuleModifyInformationMutator"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2736:1: entryRuleModifyInformationMutator returns [EObject current=null] : iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF ;
    public final EObject entryRuleModifyInformationMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyInformationMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2737:2: (iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2738:2: iv_ruleModifyInformationMutator= ruleModifyInformationMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyInformationMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator6274);
            iv_ruleModifyInformationMutator=ruleModifyInformationMutator();

            state._fsp--;

             current =iv_ruleModifyInformationMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyInformationMutator6284); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2745:1: ruleModifyInformationMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2748:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2749:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2749:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2749:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'modify' ( (lv_object_3_0= ruleObSelectionStrategy ) ) (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )? (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2749:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_ID) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2749:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2749:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2750:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2750:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2751:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyInformationMutator6327); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleModifyInformationMutator6344); 

                        	newLeafNode(otherlv_1, grammarAccess.getModifyInformationMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleModifyInformationMutator6358); 

                	newLeafNode(otherlv_2, grammarAccess.getModifyInformationMutatorAccess().getModifyKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2775:1: ( (lv_object_3_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2776:1: (lv_object_3_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2776:1: (lv_object_3_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2777:3: lv_object_3_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator6379);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2793:2: (otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==11) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2793:4: otherlv_4= 'with' otherlv_5= '{' ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )? (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )* otherlv_11= '}'
                    {
                    otherlv_4=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleModifyInformationMutator6392); 

                        	newLeafNode(otherlv_4, grammarAccess.getModifyInformationMutatorAccess().getWithKeyword_3_0());
                        
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleModifyInformationMutator6404); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyInformationMutatorAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2801:1: ( ( (lv_attributes_6_0= ruleAttributeSet ) ) | ( (lv_references_7_0= ruleReferenceSet ) ) )?
                    int alt53=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            switch ( input.LA(2) ) {
                                case 34:
                                    {
                                    alt53=2;
                                    }
                                    break;
                                case 26:
                                    {
                                    int LA53_5 = input.LA(3);

                                    if ( ((LA53_5>=RULE_STRING && LA53_5<=RULE_INT)||LA53_5==13||LA53_5==27||(LA53_5>=33 && LA53_5<=34)||(LA53_5>=37 && LA53_5<=38)||(LA53_5>=65 && LA53_5<=76)) ) {
                                        alt53=1;
                                    }
                                    else if ( (LA53_5==RULE_ID||LA53_5==43||LA53_5==45||(LA53_5>=62 && LA53_5<=64)) ) {
                                        alt53=2;
                                    }
                                    }
                                    break;
                                case 22:
                                case 33:
                                case 77:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                    {
                                    alt53=1;
                                    }
                                    break;
                            }

                            }
                            break;
                        case 54:
                        case 57:
                        case 58:
                        case 59:
                            {
                            alt53=1;
                            }
                            break;
                        case 60:
                            {
                            alt53=2;
                            }
                            break;
                    }

                    switch (alt53) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2801:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2801:2: ( (lv_attributes_6_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2802:1: (lv_attributes_6_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2802:1: (lv_attributes_6_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2803:3: lv_attributes_6_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6426);
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2820:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2820:6: ( (lv_references_7_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2821:1: (lv_references_7_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2821:1: (lv_references_7_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2822:3: lv_references_7_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6453);
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

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2838:4: (otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==24) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2838:6: otherlv_8= ',' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_8=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleModifyInformationMutator6468); 

                    	        	newLeafNode(otherlv_8, grammarAccess.getModifyInformationMutatorAccess().getCommaKeyword_3_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2842:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )
                    	    int alt54=2;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        switch ( input.LA(2) ) {
                    	        case 26:
                    	            {
                    	            int LA54_4 = input.LA(3);

                    	            if ( ((LA54_4>=RULE_STRING && LA54_4<=RULE_INT)||LA54_4==13||LA54_4==27||(LA54_4>=33 && LA54_4<=34)||(LA54_4>=37 && LA54_4<=38)||(LA54_4>=65 && LA54_4<=76)) ) {
                    	                alt54=1;
                    	            }
                    	            else if ( (LA54_4==RULE_ID||LA54_4==43||LA54_4==45||(LA54_4>=62 && LA54_4<=64)) ) {
                    	                alt54=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 54, 4, input);

                    	                throw nvae;
                    	            }
                    	            }
                    	            break;
                    	        case 34:
                    	            {
                    	            alt54=2;
                    	            }
                    	            break;
                    	        case 22:
                    	        case 33:
                    	        case 77:
                    	        case 80:
                    	        case 81:
                    	        case 82:
                    	        case 83:
                    	            {
                    	            alt54=1;
                    	            }
                    	            break;
                    	        default:
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 54, 1, input);

                    	            throw nvae;
                    	        }

                    	        }
                    	        break;
                    	    case 54:
                    	    case 57:
                    	    case 58:
                    	    case 59:
                    	        {
                    	        alt54=1;
                    	        }
                    	        break;
                    	    case 60:
                    	        {
                    	        alt54=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 54, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt54) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2842:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2842:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2843:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2843:1: (lv_attributes_9_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2844:3: lv_attributes_9_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getAttributesAttributeSetParserRuleCall_3_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6490);
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
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2861:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2861:6: ( (lv_references_10_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2862:1: (lv_references_10_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2862:1: (lv_references_10_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2863:3: lv_references_10_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getReferencesReferenceSetParserRuleCall_3_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6517);
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
                    	    break loop55;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModifyInformationMutator6532); 

                        	newLeafNode(otherlv_11, grammarAccess.getModifyInformationMutatorAccess().getRightCurlyBracketKeyword_3_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2883:3: (otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==27) ) {
                int LA58_1 = input.LA(2);

                if ( (LA58_1==RULE_INT||LA58_1==33||LA58_1==77) ) {
                    alt58=1;
                }
            }
            switch (alt58) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2883:5: otherlv_12= '[' ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )? ( (lv_max_15_0= ruleMaxCardinality ) ) otherlv_16= ']'
                    {
                    otherlv_12=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifyInformationMutator6547); 

                        	newLeafNode(otherlv_12, grammarAccess.getModifyInformationMutatorAccess().getLeftSquareBracketKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2887:1: ( ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..' )?
                    int alt57=2;
                    int LA57_0 = input.LA(1);

                    if ( (LA57_0==33) ) {
                        int LA57_1 = input.LA(2);

                        if ( (LA57_1==RULE_INT) ) {
                            int LA57_2 = input.LA(3);

                            if ( (LA57_2==28) ) {
                                alt57=1;
                            }
                        }
                    }
                    else if ( (LA57_0==RULE_INT) ) {
                        int LA57_2 = input.LA(2);

                        if ( (LA57_2==28) ) {
                            alt57=1;
                        }
                    }
                    switch (alt57) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2887:2: ( (lv_min_13_0= ruleEInt ) ) otherlv_14= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2887:2: ( (lv_min_13_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2888:1: (lv_min_13_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2888:1: (lv_min_13_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2889:3: lv_min_13_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMinEIntParserRuleCall_4_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyInformationMutator6569);
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

                            otherlv_14=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifyInformationMutator6581); 

                                	newLeafNode(otherlv_14, grammarAccess.getModifyInformationMutatorAccess().getFullStopFullStopKeyword_4_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2909:3: ( (lv_max_15_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2910:1: (lv_max_15_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2910:1: (lv_max_15_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2911:3: lv_max_15_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyInformationMutatorAccess().getMaxMaxCardinalityParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator6604);
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

                    otherlv_16=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifyInformationMutator6616); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2939:1: entryRuleCreateReferenceMutator returns [EObject current=null] : iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF ;
    public final EObject entryRuleCreateReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCreateReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2940:2: (iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2941:2: iv_ruleCreateReferenceMutator= ruleCreateReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getCreateReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator6654);
            iv_ruleCreateReferenceMutator=ruleCreateReferenceMutator();

            state._fsp--;

             current =iv_ruleCreateReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCreateReferenceMutator6664); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2948:1: ruleCreateReferenceMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2951:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2952:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2952:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2952:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'create' otherlv_3= 'reference' ( (otherlv_4= RULE_ID ) ) (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )? (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2952:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2952:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2952:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2953:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2953:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2954:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6707); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCreateReferenceMutator6724); 

                        	newLeafNode(otherlv_1, grammarAccess.getCreateReferenceMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleCreateReferenceMutator6738); 

                	newLeafNode(otherlv_2, grammarAccess.getCreateReferenceMutatorAccess().getCreateKeyword_1());
                
            otherlv_3=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleCreateReferenceMutator6750); 

                	newLeafNode(otherlv_3, grammarAccess.getCreateReferenceMutatorAccess().getReferenceKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2982:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2983:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2983:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2984:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCreateReferenceMutatorRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6770); 

            		newLeafNode(otherlv_4, grammarAccess.getCreateReferenceMutatorAccess().getRefTypeEReferenceCrossReference_3_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2995:2: (otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==49) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2995:4: otherlv_5= 'to' ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleCreateReferenceMutator6783); 

                        	newLeafNode(otherlv_5, grammarAccess.getCreateReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:2999:1: ( (lv_target_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3000:1: (lv_target_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3000:1: (lv_target_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3001:3: lv_target_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6804);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3017:4: (otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==22) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3017:6: otherlv_7= 'in' ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_7=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCreateReferenceMutator6819); 

                        	newLeafNode(otherlv_7, grammarAccess.getCreateReferenceMutatorAccess().getInKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3021:1: ( (lv_source_8_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3022:1: (lv_source_8_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3022:1: (lv_source_8_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3023:3: lv_source_8_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_5_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6840);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3039:4: (otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==27) ) {
                int LA63_1 = input.LA(2);

                if ( (LA63_1==RULE_INT||LA63_1==33||LA63_1==77) ) {
                    alt63=1;
                }
            }
            switch (alt63) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3039:6: otherlv_9= '[' ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )? ( (lv_max_12_0= ruleMaxCardinality ) ) otherlv_13= ']'
                    {
                    otherlv_9=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCreateReferenceMutator6855); 

                        	newLeafNode(otherlv_9, grammarAccess.getCreateReferenceMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3043:1: ( ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..' )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==33) ) {
                        int LA62_1 = input.LA(2);

                        if ( (LA62_1==RULE_INT) ) {
                            int LA62_2 = input.LA(3);

                            if ( (LA62_2==28) ) {
                                alt62=1;
                            }
                        }
                    }
                    else if ( (LA62_0==RULE_INT) ) {
                        int LA62_2 = input.LA(2);

                        if ( (LA62_2==28) ) {
                            alt62=1;
                        }
                    }
                    switch (alt62) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3043:2: ( (lv_min_10_0= ruleEInt ) ) otherlv_11= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3043:2: ( (lv_min_10_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3044:1: (lv_min_10_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3044:1: (lv_min_10_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3045:3: lv_min_10_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCreateReferenceMutator6877);
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

                            otherlv_11=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCreateReferenceMutator6889); 

                                	newLeafNode(otherlv_11, grammarAccess.getCreateReferenceMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3065:3: ( (lv_max_12_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3066:1: (lv_max_12_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3066:1: (lv_max_12_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3067:3: lv_max_12_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCreateReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator6912);
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

                    otherlv_13=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCreateReferenceMutator6924); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3095:1: entryRuleModifySourceReferenceMutator returns [EObject current=null] : iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF ;
    public final EObject entryRuleModifySourceReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifySourceReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3096:2: (iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3097:2: iv_ruleModifySourceReferenceMutator= ruleModifySourceReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifySourceReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator6962);
            iv_ruleModifySourceReferenceMutator=ruleModifySourceReferenceMutator();

            state._fsp--;

             current =iv_ruleModifySourceReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator6972); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3104:1: ruleModifySourceReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3107:28: ( (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3108:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3108:1: (otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3108:3: otherlv_0= 'modify' otherlv_1= 'source' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleModifySourceReferenceMutator7009); 

                	newLeafNode(otherlv_0, grammarAccess.getModifySourceReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleModifySourceReferenceMutator7021); 

                	newLeafNode(otherlv_1, grammarAccess.getModifySourceReferenceMutatorAccess().getSourceKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3116:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3117:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3117:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3118:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifySourceReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator7041); 

            		newLeafNode(otherlv_2, grammarAccess.getModifySourceReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3129:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==23) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3129:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModifySourceReferenceMutator7054); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifySourceReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3133:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3134:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3134:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3135:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7075);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3151:4: (otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==49) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3151:6: otherlv_5= 'to' ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModifySourceReferenceMutator7090); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifySourceReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3155:1: ( (lv_newSource_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3156:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3156:1: (lv_newSource_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3157:3: lv_newSource_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getNewSourceObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7111);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3173:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==27) ) {
                int LA67_1 = input.LA(2);

                if ( (LA67_1==RULE_INT||LA67_1==33||LA67_1==77) ) {
                    alt67=1;
                }
            }
            switch (alt67) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3173:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifySourceReferenceMutator7126); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifySourceReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3177:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==33) ) {
                        int LA66_1 = input.LA(2);

                        if ( (LA66_1==RULE_INT) ) {
                            int LA66_2 = input.LA(3);

                            if ( (LA66_2==28) ) {
                                alt66=1;
                            }
                        }
                    }
                    else if ( (LA66_0==RULE_INT) ) {
                        int LA66_2 = input.LA(2);

                        if ( (LA66_2==28) ) {
                            alt66=1;
                        }
                    }
                    switch (alt66) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3177:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3177:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3178:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3179:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator7148);
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

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifySourceReferenceMutator7160); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifySourceReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3199:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3200:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3200:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3201:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifySourceReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator7183);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifySourceReferenceMutator7195); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3229:1: entryRuleModifyTargetReferenceMutator returns [EObject current=null] : iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF ;
    public final EObject entryRuleModifyTargetReferenceMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModifyTargetReferenceMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3230:2: (iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3231:2: iv_ruleModifyTargetReferenceMutator= ruleModifyTargetReferenceMutator EOF
            {
             newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator7233);
            iv_ruleModifyTargetReferenceMutator=ruleModifyTargetReferenceMutator();

            state._fsp--;

             current =iv_ruleModifyTargetReferenceMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator7243); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3238:1: ruleModifyTargetReferenceMutator returns [EObject current=null] : (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3241:28: ( (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3242:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3242:1: (otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3242:3: otherlv_0= 'modify' otherlv_1= 'target' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )? (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            {
            otherlv_0=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleModifyTargetReferenceMutator7280); 

                	newLeafNode(otherlv_0, grammarAccess.getModifyTargetReferenceMutatorAccess().getModifyKeyword_0());
                
            otherlv_1=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleModifyTargetReferenceMutator7292); 

                	newLeafNode(otherlv_1, grammarAccess.getModifyTargetReferenceMutatorAccess().getTargetKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3250:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3251:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3251:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3252:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getModifyTargetReferenceMutatorRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator7312); 

            		newLeafNode(otherlv_2, grammarAccess.getModifyTargetReferenceMutatorAccess().getRefTypeEReferenceCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3263:2: (otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==23) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3263:4: otherlv_3= 'from' ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_3=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModifyTargetReferenceMutator7325); 

                        	newLeafNode(otherlv_3, grammarAccess.getModifyTargetReferenceMutatorAccess().getFromKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3267:1: ( (lv_source_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3268:1: (lv_source_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3268:1: (lv_source_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3269:3: lv_source_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getSourceObSelectionStrategyParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7346);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3285:4: (otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) ) )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==49) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3285:6: otherlv_5= 'to' ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModifyTargetReferenceMutator7361); 

                        	newLeafNode(otherlv_5, grammarAccess.getModifyTargetReferenceMutatorAccess().getToKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3289:1: ( (lv_newTarget_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3290:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3290:1: (lv_newTarget_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3291:3: lv_newTarget_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getNewTargetObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7382);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3307:4: (otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==27) ) {
                int LA71_1 = input.LA(2);

                if ( (LA71_1==RULE_INT||LA71_1==33||LA71_1==77) ) {
                    alt71=1;
                }
            }
            switch (alt71) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3307:6: otherlv_7= '[' ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )? ( (lv_max_10_0= ruleMaxCardinality ) ) otherlv_11= ']'
                    {
                    otherlv_7=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleModifyTargetReferenceMutator7397); 

                        	newLeafNode(otherlv_7, grammarAccess.getModifyTargetReferenceMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3311:1: ( ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..' )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==33) ) {
                        int LA70_1 = input.LA(2);

                        if ( (LA70_1==RULE_INT) ) {
                            int LA70_2 = input.LA(3);

                            if ( (LA70_2==28) ) {
                                alt70=1;
                            }
                        }
                    }
                    else if ( (LA70_0==RULE_INT) ) {
                        int LA70_2 = input.LA(2);

                        if ( (LA70_2==28) ) {
                            alt70=1;
                        }
                    }
                    switch (alt70) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3311:2: ( (lv_min_8_0= ruleEInt ) ) otherlv_9= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3311:2: ( (lv_min_8_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3312:1: (lv_min_8_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3312:1: (lv_min_8_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3313:3: lv_min_8_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMinEIntParserRuleCall_5_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator7419);
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

                            otherlv_9=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleModifyTargetReferenceMutator7431); 

                                	newLeafNode(otherlv_9, grammarAccess.getModifyTargetReferenceMutatorAccess().getFullStopFullStopKeyword_5_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3333:3: ( (lv_max_10_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3334:1: (lv_max_10_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3334:1: (lv_max_10_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3335:3: lv_max_10_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getModifyTargetReferenceMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator7454);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleModifyTargetReferenceMutator7466); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3363:1: entryRuleCompositeMutator returns [EObject current=null] : iv_ruleCompositeMutator= ruleCompositeMutator EOF ;
    public final EObject entryRuleCompositeMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompositeMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3364:2: (iv_ruleCompositeMutator= ruleCompositeMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3365:2: iv_ruleCompositeMutator= ruleCompositeMutator EOF
            {
             newCompositeNode(grammarAccess.getCompositeMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator7504);
            iv_ruleCompositeMutator=ruleCompositeMutator();

            state._fsp--;

             current =iv_ruleCompositeMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompositeMutator7514); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3372:1: ruleCompositeMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3375:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3376:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3376:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3376:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= '[' ( (lv_commands_3_0= ruleMutator ) ) ( (lv_commands_4_0= ruleMutator ) )* otherlv_5= ']' (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3376:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_ID) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3376:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3376:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3377:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3377:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3378:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompositeMutator7557); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCompositeMutator7574); 

                        	newLeafNode(otherlv_1, grammarAccess.getCompositeMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCompositeMutator7588); 

                	newLeafNode(otherlv_2, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3402:1: ( (lv_commands_3_0= ruleMutator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3403:1: (lv_commands_3_0= ruleMutator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3403:1: (lv_commands_3_0= ruleMutator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3404:3: lv_commands_3_0= ruleMutator
            {
             
            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator7609);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3420:2: ( (lv_commands_4_0= ruleMutator ) )*
            loop73:
            do {
                int alt73=2;
                int LA73_0 = input.LA(1);

                if ( (LA73_0==RULE_ID||LA73_0==27||LA73_0==42||LA73_0==46||LA73_0==48||LA73_0==52) ) {
                    alt73=1;
                }


                switch (alt73) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3421:1: (lv_commands_4_0= ruleMutator )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3421:1: (lv_commands_4_0= ruleMutator )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3422:3: lv_commands_4_0= ruleMutator
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getCommandsMutatorParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleMutator_in_ruleCompositeMutator7630);
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
            	    break loop73;
                }
            } while (true);

            otherlv_5=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCompositeMutator7643); 

                	newLeafNode(otherlv_5, grammarAccess.getCompositeMutatorAccess().getRightSquareBracketKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3442:1: (otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']' )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==27) ) {
                int LA75_1 = input.LA(2);

                if ( (LA75_1==RULE_INT||LA75_1==33) ) {
                    alt75=1;
                }
            }
            switch (alt75) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3442:3: otherlv_6= '[' ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) ) otherlv_11= ']'
                    {
                    otherlv_6=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCompositeMutator7656); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompositeMutatorAccess().getLeftSquareBracketKeyword_5_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3446:1: ( ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) ) | ( (lv_fixed_10_0= ruleEInt ) ) )
                    int alt74=2;
                    int LA74_0 = input.LA(1);

                    if ( (LA74_0==33) ) {
                        int LA74_1 = input.LA(2);

                        if ( (LA74_1==RULE_INT) ) {
                            int LA74_2 = input.LA(3);

                            if ( (LA74_2==29) ) {
                                alt74=2;
                            }
                            else if ( (LA74_2==28) ) {
                                alt74=1;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 74, 2, input);

                                throw nvae;
                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 74, 1, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA74_0==RULE_INT) ) {
                        int LA74_2 = input.LA(2);

                        if ( (LA74_2==29) ) {
                            alt74=2;
                        }
                        else if ( (LA74_2==28) ) {
                            alt74=1;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 74, 2, input);

                            throw nvae;
                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 74, 0, input);

                        throw nvae;
                    }
                    switch (alt74) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3446:2: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3446:2: ( ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3446:3: ( (lv_min_7_0= ruleEInt ) ) otherlv_8= '..' ( (lv_max_9_0= ruleMaxCardinality ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3446:3: ( (lv_min_7_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3447:1: (lv_min_7_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3447:1: (lv_min_7_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3448:3: lv_min_7_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMinEIntParserRuleCall_5_1_0_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCompositeMutator7679);
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

                            otherlv_8=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCompositeMutator7691); 

                                	newLeafNode(otherlv_8, grammarAccess.getCompositeMutatorAccess().getFullStopFullStopKeyword_5_1_0_1());
                                
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3468:1: ( (lv_max_9_0= ruleMaxCardinality ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3469:1: (lv_max_9_0= ruleMaxCardinality )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3469:1: (lv_max_9_0= ruleMaxCardinality )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3470:3: lv_max_9_0= ruleMaxCardinality
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getMaxMaxCardinalityParserRuleCall_5_1_0_2_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator7712);
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3487:6: ( (lv_fixed_10_0= ruleEInt ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3487:6: ( (lv_fixed_10_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3488:1: (lv_fixed_10_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3488:1: (lv_fixed_10_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3489:3: lv_fixed_10_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCompositeMutatorAccess().getFixedEIntParserRuleCall_5_1_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCompositeMutator7740);
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

                    otherlv_11=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCompositeMutator7753); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3517:1: entryRuleCloneObjectMutator returns [EObject current=null] : iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF ;
    public final EObject entryRuleCloneObjectMutator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCloneObjectMutator = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3518:2: (iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3519:2: iv_ruleCloneObjectMutator= ruleCloneObjectMutator EOF
            {
             newCompositeNode(grammarAccess.getCloneObjectMutatorRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCloneObjectMutator_in_entryRuleCloneObjectMutator7791);
            iv_ruleCloneObjectMutator=ruleCloneObjectMutator();

            state._fsp--;

             current =iv_ruleCloneObjectMutator; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCloneObjectMutator7801); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3526:1: ruleCloneObjectMutator returns [EObject current=null] : ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3529:28: ( ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3530:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3530:1: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3530:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )? otherlv_2= 'clone' ( (lv_contents_3_0= 'contents' ) )? ( (lv_object_4_0= ruleObSelectionStrategy ) ) (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )? (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )? (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3530:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '=' )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3530:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= '='
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3530:3: ( (lv_name_0_0= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3531:1: (lv_name_0_0= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3531:1: (lv_name_0_0= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3532:3: lv_name_0_0= RULE_ID
                    {
                    lv_name_0_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCloneObjectMutator7844); 

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

                    otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleCloneObjectMutator7861); 

                        	newLeafNode(otherlv_1, grammarAccess.getCloneObjectMutatorAccess().getEqualsSignKeyword_0_1());
                        

                    }
                    break;

            }

            otherlv_2=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleCloneObjectMutator7875); 

                	newLeafNode(otherlv_2, grammarAccess.getCloneObjectMutatorAccess().getCloneKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3556:1: ( (lv_contents_3_0= 'contents' ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==53) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3557:1: (lv_contents_3_0= 'contents' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3557:1: (lv_contents_3_0= 'contents' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3558:3: lv_contents_3_0= 'contents'
                    {
                    lv_contents_3_0=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleCloneObjectMutator7893); 

                            newLeafNode(lv_contents_3_0, grammarAccess.getCloneObjectMutatorAccess().getContentsContentsKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCloneObjectMutatorRule());
                    	        }
                           		setWithLastConsumed(current, "contents", true, "contents");
                    	    

                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3571:3: ( (lv_object_4_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3572:1: (lv_object_4_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3572:1: (lv_object_4_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3573:3: lv_object_4_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getObjectObSelectionStrategyParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator7928);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3589:2: (otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==22) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3589:4: otherlv_5= 'in' ( (lv_container_6_0= ruleObSelectionStrategy ) )
                    {
                    otherlv_5=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleCloneObjectMutator7941); 

                        	newLeafNode(otherlv_5, grammarAccess.getCloneObjectMutatorAccess().getInKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3593:1: ( (lv_container_6_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3594:1: (lv_container_6_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3594:1: (lv_container_6_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3595:3: lv_container_6_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getContainerObSelectionStrategyParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator7962);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3611:4: (otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}' )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==11) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3611:6: otherlv_7= 'with' otherlv_8= '{' ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )? (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )* otherlv_14= '}'
                    {
                    otherlv_7=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleCloneObjectMutator7977); 

                        	newLeafNode(otherlv_7, grammarAccess.getCloneObjectMutatorAccess().getWithKeyword_5_0());
                        
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCloneObjectMutator7989); 

                        	newLeafNode(otherlv_8, grammarAccess.getCloneObjectMutatorAccess().getLeftCurlyBracketKeyword_5_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3619:1: ( ( (lv_attributes_9_0= ruleAttributeSet ) ) | ( (lv_references_10_0= ruleReferenceSet ) ) )?
                    int alt79=3;
                    switch ( input.LA(1) ) {
                        case RULE_ID:
                            {
                            switch ( input.LA(2) ) {
                                case 22:
                                case 33:
                                case 77:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                    {
                                    alt79=1;
                                    }
                                    break;
                                case 26:
                                    {
                                    int LA79_5 = input.LA(3);

                                    if ( ((LA79_5>=RULE_STRING && LA79_5<=RULE_INT)||LA79_5==13||LA79_5==27||(LA79_5>=33 && LA79_5<=34)||(LA79_5>=37 && LA79_5<=38)||(LA79_5>=65 && LA79_5<=76)) ) {
                                        alt79=1;
                                    }
                                    else if ( (LA79_5==RULE_ID||LA79_5==43||LA79_5==45||(LA79_5>=62 && LA79_5<=64)) ) {
                                        alt79=2;
                                    }
                                    }
                                    break;
                                case 34:
                                    {
                                    alt79=2;
                                    }
                                    break;
                            }

                            }
                            break;
                        case 54:
                        case 57:
                        case 58:
                        case 59:
                            {
                            alt79=1;
                            }
                            break;
                        case 60:
                            {
                            alt79=2;
                            }
                            break;
                    }

                    switch (alt79) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3619:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3619:2: ( (lv_attributes_9_0= ruleAttributeSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3620:1: (lv_attributes_9_0= ruleAttributeSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3620:1: (lv_attributes_9_0= ruleAttributeSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3621:3: lv_attributes_9_0= ruleAttributeSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_5_2_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8011);
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
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3638:6: ( (lv_references_10_0= ruleReferenceSet ) )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3638:6: ( (lv_references_10_0= ruleReferenceSet ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3639:1: (lv_references_10_0= ruleReferenceSet )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3639:1: (lv_references_10_0= ruleReferenceSet )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3640:3: lv_references_10_0= ruleReferenceSet
                            {
                             
                            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_5_2_1_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8038);
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

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3656:4: (otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) ) )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==24) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3656:6: otherlv_11= ',' ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )
                    	    {
                    	    otherlv_11=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleCloneObjectMutator8053); 

                    	        	newLeafNode(otherlv_11, grammarAccess.getCloneObjectMutatorAccess().getCommaKeyword_5_3_0());
                    	        
                    	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3660:1: ( ( (lv_attributes_12_0= ruleAttributeSet ) ) | ( (lv_references_13_0= ruleReferenceSet ) ) )
                    	    int alt80=2;
                    	    switch ( input.LA(1) ) {
                    	    case RULE_ID:
                    	        {
                    	        switch ( input.LA(2) ) {
                    	        case 34:
                    	            {
                    	            alt80=2;
                    	            }
                    	            break;
                    	        case 26:
                    	            {
                    	            int LA80_4 = input.LA(3);

                    	            if ( ((LA80_4>=RULE_STRING && LA80_4<=RULE_INT)||LA80_4==13||LA80_4==27||(LA80_4>=33 && LA80_4<=34)||(LA80_4>=37 && LA80_4<=38)||(LA80_4>=65 && LA80_4<=76)) ) {
                    	                alt80=1;
                    	            }
                    	            else if ( (LA80_4==RULE_ID||LA80_4==43||LA80_4==45||(LA80_4>=62 && LA80_4<=64)) ) {
                    	                alt80=2;
                    	            }
                    	            else {
                    	                NoViableAltException nvae =
                    	                    new NoViableAltException("", 80, 4, input);

                    	                throw nvae;
                    	            }
                    	            }
                    	            break;
                    	        case 22:
                    	        case 33:
                    	        case 77:
                    	        case 80:
                    	        case 81:
                    	        case 82:
                    	        case 83:
                    	            {
                    	            alt80=1;
                    	            }
                    	            break;
                    	        default:
                    	            NoViableAltException nvae =
                    	                new NoViableAltException("", 80, 1, input);

                    	            throw nvae;
                    	        }

                    	        }
                    	        break;
                    	    case 54:
                    	    case 57:
                    	    case 58:
                    	    case 59:
                    	        {
                    	        alt80=1;
                    	        }
                    	        break;
                    	    case 60:
                    	        {
                    	        alt80=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 80, 0, input);

                    	        throw nvae;
                    	    }

                    	    switch (alt80) {
                    	        case 1 :
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3660:2: ( (lv_attributes_12_0= ruleAttributeSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3660:2: ( (lv_attributes_12_0= ruleAttributeSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3661:1: (lv_attributes_12_0= ruleAttributeSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3661:1: (lv_attributes_12_0= ruleAttributeSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3662:3: lv_attributes_12_0= ruleAttributeSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getAttributesAttributeSetParserRuleCall_5_3_1_0_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8075);
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
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3679:6: ( (lv_references_13_0= ruleReferenceSet ) )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3679:6: ( (lv_references_13_0= ruleReferenceSet ) )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3680:1: (lv_references_13_0= ruleReferenceSet )
                    	            {
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3680:1: (lv_references_13_0= ruleReferenceSet )
                    	            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3681:3: lv_references_13_0= ruleReferenceSet
                    	            {
                    	             
                    	            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getReferencesReferenceSetParserRuleCall_5_3_1_1_0()); 
                    	            	    
                    	            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8102);
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
                    	    break loop81;
                        }
                    } while (true);

                    otherlv_14=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCloneObjectMutator8117); 

                        	newLeafNode(otherlv_14, grammarAccess.getCloneObjectMutatorAccess().getRightCurlyBracketKeyword_5_4());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3701:3: (otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']' )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==27) ) {
                int LA84_1 = input.LA(2);

                if ( (LA84_1==RULE_INT||LA84_1==33||LA84_1==77) ) {
                    alt84=1;
                }
            }
            switch (alt84) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3701:5: otherlv_15= '[' ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )? ( (lv_max_18_0= ruleMaxCardinality ) ) otherlv_19= ']'
                    {
                    otherlv_15=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleCloneObjectMutator8132); 

                        	newLeafNode(otherlv_15, grammarAccess.getCloneObjectMutatorAccess().getLeftSquareBracketKeyword_6_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3705:1: ( ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..' )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==33) ) {
                        int LA83_1 = input.LA(2);

                        if ( (LA83_1==RULE_INT) ) {
                            int LA83_2 = input.LA(3);

                            if ( (LA83_2==28) ) {
                                alt83=1;
                            }
                        }
                    }
                    else if ( (LA83_0==RULE_INT) ) {
                        int LA83_2 = input.LA(2);

                        if ( (LA83_2==28) ) {
                            alt83=1;
                        }
                    }
                    switch (alt83) {
                        case 1 :
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3705:2: ( (lv_min_16_0= ruleEInt ) ) otherlv_17= '..'
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3705:2: ( (lv_min_16_0= ruleEInt ) )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3706:1: (lv_min_16_0= ruleEInt )
                            {
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3706:1: (lv_min_16_0= ruleEInt )
                            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3707:3: lv_min_16_0= ruleEInt
                            {
                             
                            	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getMinEIntParserRuleCall_6_1_0_0()); 
                            	    
                            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleCloneObjectMutator8154);
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

                            otherlv_17=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleCloneObjectMutator8166); 

                                	newLeafNode(otherlv_17, grammarAccess.getCloneObjectMutatorAccess().getFullStopFullStopKeyword_6_1_1());
                                

                            }
                            break;

                    }

                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3727:3: ( (lv_max_18_0= ruleMaxCardinality ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3728:1: (lv_max_18_0= ruleMaxCardinality )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3728:1: (lv_max_18_0= ruleMaxCardinality )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3729:3: lv_max_18_0= ruleMaxCardinality
                    {
                     
                    	        newCompositeNode(grammarAccess.getCloneObjectMutatorAccess().getMaxMaxCardinalityParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_ruleCloneObjectMutator8189);
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

                    otherlv_19=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleCloneObjectMutator8201); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3757:1: entryRuleAttributeSet returns [EObject current=null] : iv_ruleAttributeSet= ruleAttributeSet EOF ;
    public final EObject entryRuleAttributeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSet = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3758:2: (iv_ruleAttributeSet= ruleAttributeSet EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3759:2: iv_ruleAttributeSet= ruleAttributeSet EOF
            {
             newCompositeNode(grammarAccess.getAttributeSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet8239);
            iv_ruleAttributeSet=ruleAttributeSet();

            state._fsp--;

             current =iv_ruleAttributeSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSet8249); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3766:1: ruleAttributeSet returns [EObject current=null] : (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3769:28: ( (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3770:1: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3770:1: (this_AttributeScalar_0= ruleAttributeScalar | this_AttributeUnset_1= ruleAttributeUnset | this_AttributeSwap_2= ruleAttributeSwap | this_AttributeCopy_3= ruleAttributeCopy | this_AttributeReverse_4= ruleAttributeReverse | this_AttributeOperation_5= ruleAttributeOperation )
            int alt85=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                int LA85_1 = input.LA(2);

                if ( (LA85_1==33||LA85_1==77||(LA85_1>=81 && LA85_1<=83)) ) {
                    alt85=6;
                }
                else if ( (LA85_1==22||LA85_1==26||LA85_1==80) ) {
                    alt85=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 1, input);

                    throw nvae;
                }
                }
                break;
            case 54:
                {
                alt85=2;
                }
                break;
            case 57:
                {
                alt85=3;
                }
                break;
            case 58:
                {
                alt85=4;
                }
                break;
            case 59:
                {
                alt85=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3771:5: this_AttributeScalar_0= ruleAttributeScalar
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeScalarParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeScalar_in_ruleAttributeSet8296);
                    this_AttributeScalar_0=ruleAttributeScalar();

                    state._fsp--;

                     
                            current = this_AttributeScalar_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3781:5: this_AttributeUnset_1= ruleAttributeUnset
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeUnsetParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_ruleAttributeSet8323);
                    this_AttributeUnset_1=ruleAttributeUnset();

                    state._fsp--;

                     
                            current = this_AttributeUnset_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3791:5: this_AttributeSwap_2= ruleAttributeSwap
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeSwapParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_ruleAttributeSet8350);
                    this_AttributeSwap_2=ruleAttributeSwap();

                    state._fsp--;

                     
                            current = this_AttributeSwap_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3801:5: this_AttributeCopy_3= ruleAttributeCopy
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeCopyParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_ruleAttributeSet8377);
                    this_AttributeCopy_3=ruleAttributeCopy();

                    state._fsp--;

                     
                            current = this_AttributeCopy_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3811:5: this_AttributeReverse_4= ruleAttributeReverse
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeReverseParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_ruleAttributeSet8404);
                    this_AttributeReverse_4=ruleAttributeReverse();

                    state._fsp--;

                     
                            current = this_AttributeReverse_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3821:5: this_AttributeOperation_5= ruleAttributeOperation
                    {
                     
                            newCompositeNode(grammarAccess.getAttributeSetAccess().getAttributeOperationParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleAttributeOperation_in_ruleAttributeSet8431);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3837:1: entryRuleAttributeScalar returns [EObject current=null] : iv_ruleAttributeScalar= ruleAttributeScalar EOF ;
    public final EObject entryRuleAttributeScalar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeScalar = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3838:2: (iv_ruleAttributeScalar= ruleAttributeScalar EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3839:2: iv_ruleAttributeScalar= ruleAttributeScalar EOF
            {
             newCompositeNode(grammarAccess.getAttributeScalarRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeScalar_in_entryRuleAttributeScalar8466);
            iv_ruleAttributeScalar=ruleAttributeScalar();

            state._fsp--;

             current =iv_ruleAttributeScalar; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeScalar8476); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3846:1: ruleAttributeScalar returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) ;
    public final EObject ruleAttributeScalar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3849:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3850:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3850:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3850:2: ( (otherlv_0= RULE_ID ) ) ( (lv_value_1_0= ruleAttributeType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3850:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3851:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3851:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3852:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeScalarRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeScalar8521); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeScalarAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3863:2: ( (lv_value_1_0= ruleAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3864:1: (lv_value_1_0= ruleAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3864:1: (lv_value_1_0= ruleAttributeType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3865:3: lv_value_1_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeScalarAccess().getValueAttributeTypeParserRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleAttributeScalar8542);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3889:1: entryRuleAttributeUnset returns [EObject current=null] : iv_ruleAttributeUnset= ruleAttributeUnset EOF ;
    public final EObject entryRuleAttributeUnset() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeUnset = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3890:2: (iv_ruleAttributeUnset= ruleAttributeUnset EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3891:2: iv_ruleAttributeUnset= ruleAttributeUnset EOF
            {
             newCompositeNode(grammarAccess.getAttributeUnsetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset8578);
            iv_ruleAttributeUnset=ruleAttributeUnset();

            state._fsp--;

             current =iv_ruleAttributeUnset; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeUnset8588); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3898:1: ruleAttributeUnset returns [EObject current=null] : (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeUnset() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3901:28: ( (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3902:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3902:1: (otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3902:3: otherlv_0= 'unset' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleAttributeUnset8625); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeUnsetAccess().getUnsetKeyword_0());
                
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleAttributeUnset8637); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeUnsetAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3910:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3911:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3911:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3912:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeUnsetRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeUnset8657); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeUnsetAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeUnset8669); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3935:1: entryRuleAttributeSwap returns [EObject current=null] : iv_ruleAttributeSwap= ruleAttributeSwap EOF ;
    public final EObject entryRuleAttributeSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeSwap = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3936:2: (iv_ruleAttributeSwap= ruleAttributeSwap EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3937:2: iv_ruleAttributeSwap= ruleAttributeSwap EOF
            {
             newCompositeNode(grammarAccess.getAttributeSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap8705);
            iv_ruleAttributeSwap=ruleAttributeSwap();

            state._fsp--;

             current =iv_ruleAttributeSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeSwap8715); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3944:1: ruleAttributeSwap returns [EObject current=null] : (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3947:28: ( (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3948:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3948:1: (otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3948:3: otherlv_0= 'swap' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleAttributeSwap8752); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeSwapAccess().getSwapKeyword_0());
                
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleAttributeSwap8764); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3956:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3957:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3957:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3958:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap8784); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAttributeSwap8796); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeSwapAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3973:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==43||LA86_0==45||(LA86_0>=62 && LA86_0<=64)) ) {
                alt86=1;
            }
            else if ( (LA86_0==RULE_ID) ) {
                int LA86_2 = input.LA(2);

                if ( (LA86_2==34||LA86_2==40||LA86_2==61) ) {
                    alt86=1;
                }
            }
            switch (alt86) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3973:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3973:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3974:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3974:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3975:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap8818);
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

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAttributeSwap8830); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeSwapAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3995:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3996:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3996:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:3997:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeSwap8852); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeSwapAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeSwap8864); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4020:1: entryRuleAttributeCopy returns [EObject current=null] : iv_ruleAttributeCopy= ruleAttributeCopy EOF ;
    public final EObject entryRuleAttributeCopy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeCopy = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4021:2: (iv_ruleAttributeCopy= ruleAttributeCopy EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4022:2: iv_ruleAttributeCopy= ruleAttributeCopy EOF
            {
             newCompositeNode(grammarAccess.getAttributeCopyRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy8900);
            iv_ruleAttributeCopy=ruleAttributeCopy();

            state._fsp--;

             current =iv_ruleAttributeCopy; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeCopy8910); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4029:1: ruleAttributeCopy returns [EObject current=null] : (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4032:28: ( (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4033:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4033:1: (otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4033:3: otherlv_0= 'copy' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleAttributeCopy8947); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeCopyAccess().getCopyKeyword_0());
                
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleAttributeCopy8959); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeCopyAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4041:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4042:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4042:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4043:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy8979); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleAttributeCopy8991); 

                	newLeafNode(otherlv_3, grammarAccess.getAttributeCopyAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4058:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.' )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==43||LA87_0==45||(LA87_0>=62 && LA87_0<=64)) ) {
                alt87=1;
            }
            else if ( (LA87_0==RULE_ID) ) {
                int LA87_2 = input.LA(2);

                if ( (LA87_2==34||LA87_2==40||LA87_2==61) ) {
                    alt87=1;
                }
            }
            switch (alt87) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4058:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4058:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4059:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4059:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4060:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getAttributeCopyAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy9013);
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

                    otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleAttributeCopy9025); 

                        	newLeafNode(otherlv_5, grammarAccess.getAttributeCopyAccess().getFullStopKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4080:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4081:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4081:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4082:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeCopyRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeCopy9047); 

            		newLeafNode(otherlv_6, grammarAccess.getAttributeCopyAccess().getAttributeEAttributeCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeCopy9059); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4105:1: entryRuleAttributeReverse returns [EObject current=null] : iv_ruleAttributeReverse= ruleAttributeReverse EOF ;
    public final EObject entryRuleAttributeReverse() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeReverse = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4106:2: (iv_ruleAttributeReverse= ruleAttributeReverse EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4107:2: iv_ruleAttributeReverse= ruleAttributeReverse EOF
            {
             newCompositeNode(grammarAccess.getAttributeReverseRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse9095);
            iv_ruleAttributeReverse=ruleAttributeReverse();

            state._fsp--;

             current =iv_ruleAttributeReverse; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeReverse9105); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4114:1: ruleAttributeReverse returns [EObject current=null] : (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) ;
    public final EObject ruleAttributeReverse() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;

         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4117:28: ( (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4118:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4118:1: (otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4118:3: otherlv_0= 'reverse' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ')'
            {
            otherlv_0=(Token)match(input,59,FollowSets000.FOLLOW_59_in_ruleAttributeReverse9142); 

                	newLeafNode(otherlv_0, grammarAccess.getAttributeReverseAccess().getReverseKeyword_0());
                
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleAttributeReverse9154); 

                	newLeafNode(otherlv_1, grammarAccess.getAttributeReverseAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4126:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4127:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4127:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4128:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeReverseRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeReverse9174); 

            		newLeafNode(otherlv_2, grammarAccess.getAttributeReverseAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleAttributeReverse9186); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4151:1: entryRuleAttributeOperation returns [EObject current=null] : iv_ruleAttributeOperation= ruleAttributeOperation EOF ;
    public final EObject entryRuleAttributeOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttributeOperation = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4152:2: (iv_ruleAttributeOperation= ruleAttributeOperation EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4153:2: iv_ruleAttributeOperation= ruleAttributeOperation EOF
            {
             newCompositeNode(grammarAccess.getAttributeOperationRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleAttributeOperation_in_entryRuleAttributeOperation9222);
            iv_ruleAttributeOperation=ruleAttributeOperation();

            state._fsp--;

             current =iv_ruleAttributeOperation; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAttributeOperation9232); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4160:1: ruleAttributeOperation returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) ;
    public final EObject ruleAttributeOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_operator_1_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4163:28: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4164:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4164:1: ( ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4164:2: ( (otherlv_0= RULE_ID ) ) ( (lv_operator_1_0= ruleArithmeticOperator ) ) ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4164:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4165:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4165:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4166:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getAttributeOperationRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAttributeOperation9277); 

            		newLeafNode(otherlv_0, grammarAccess.getAttributeOperationAccess().getAttributeEAttributeCrossReference_0_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4177:2: ( (lv_operator_1_0= ruleArithmeticOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4178:1: (lv_operator_1_0= ruleArithmeticOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4178:1: (lv_operator_1_0= ruleArithmeticOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4179:3: lv_operator_1_0= ruleArithmeticOperator
            {
             
            	        newCompositeNode(grammarAccess.getAttributeOperationAccess().getOperatorArithmeticOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleArithmeticOperator_in_ruleAttributeOperation9298);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4195:2: ( (lv_value_2_0= ruleAttributeEvaluationType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4196:1: (lv_value_2_0= ruleAttributeEvaluationType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4196:1: (lv_value_2_0= ruleAttributeEvaluationType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4197:3: lv_value_2_0= ruleAttributeEvaluationType
            {
             
            	        newCompositeNode(grammarAccess.getAttributeOperationAccess().getValueAttributeEvaluationTypeParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeOperation9319);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4221:1: entryRuleReferenceSet returns [EObject current=null] : iv_ruleReferenceSet= ruleReferenceSet EOF ;
    public final EObject entryRuleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSet = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4222:2: (iv_ruleReferenceSet= ruleReferenceSet EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4223:2: iv_ruleReferenceSet= ruleReferenceSet EOF
            {
             newCompositeNode(grammarAccess.getReferenceSetRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet9355);
            iv_ruleReferenceSet=ruleReferenceSet();

            state._fsp--;

             current =iv_ruleReferenceSet; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSet9365); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4230:1: ruleReferenceSet returns [EObject current=null] : (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt ) ;
    public final EObject ruleReferenceSet() throws RecognitionException {
        EObject current = null;

        EObject this_ReferenceInit_0 = null;

        EObject this_ReferenceSwap_1 = null;

        EObject this_ReferenceAtt_2 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4233:28: ( (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4234:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4234:1: (this_ReferenceInit_0= ruleReferenceInit | this_ReferenceSwap_1= ruleReferenceSwap | this_ReferenceAtt_2= ruleReferenceAtt )
            int alt88=3;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID) ) {
                int LA88_1 = input.LA(2);

                if ( (LA88_1==26) ) {
                    alt88=1;
                }
                else if ( (LA88_1==34) ) {
                    alt88=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 88, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA88_0==60) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4235:5: this_ReferenceInit_0= ruleReferenceInit
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceInitParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_ruleReferenceSet9412);
                    this_ReferenceInit_0=ruleReferenceInit();

                    state._fsp--;

                     
                            current = this_ReferenceInit_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4245:5: this_ReferenceSwap_1= ruleReferenceSwap
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceSwapParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_ruleReferenceSet9439);
                    this_ReferenceSwap_1=ruleReferenceSwap();

                    state._fsp--;

                     
                            current = this_ReferenceSwap_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4255:5: this_ReferenceAtt_2= ruleReferenceAtt
                    {
                     
                            newCompositeNode(grammarAccess.getReferenceSetAccess().getReferenceAttParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReferenceAtt_in_ruleReferenceSet9466);
                    this_ReferenceAtt_2=ruleReferenceAtt();

                    state._fsp--;

                     
                            current = this_ReferenceAtt_2; 
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4271:1: entryRuleReferenceInit returns [EObject current=null] : iv_ruleReferenceInit= ruleReferenceInit EOF ;
    public final EObject entryRuleReferenceInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceInit = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4272:2: (iv_ruleReferenceInit= ruleReferenceInit EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4273:2: iv_ruleReferenceInit= ruleReferenceInit EOF
            {
             newCompositeNode(grammarAccess.getReferenceInitRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit9501);
            iv_ruleReferenceInit=ruleReferenceInit();

            state._fsp--;

             current =iv_ruleReferenceInit; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceInit9511); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4280:1: ruleReferenceInit returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) ) ;
    public final EObject ruleReferenceInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_object_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4283:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4284:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4284:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4284:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_object_2_0= ruleObSelectionStrategy ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4284:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4285:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4285:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4286:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceInitRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceInit9556); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceInitAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleReferenceInit9568); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceInitAccess().getEqualsSignKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4301:1: ( (lv_object_2_0= ruleObSelectionStrategy ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4302:1: (lv_object_2_0= ruleObSelectionStrategy )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4302:1: (lv_object_2_0= ruleObSelectionStrategy )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4303:3: lv_object_2_0= ruleObSelectionStrategy
            {
             
            	        newCompositeNode(grammarAccess.getReferenceInitAccess().getObjectObSelectionStrategyParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit9589);
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


    // $ANTLR start "entryRuleReferenceSwap"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4327:1: entryRuleReferenceSwap returns [EObject current=null] : iv_ruleReferenceSwap= ruleReferenceSwap EOF ;
    public final EObject entryRuleReferenceSwap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceSwap = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4328:2: (iv_ruleReferenceSwap= ruleReferenceSwap EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4329:2: iv_ruleReferenceSwap= ruleReferenceSwap EOF
            {
             newCompositeNode(grammarAccess.getReferenceSwapRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap9625);
            iv_ruleReferenceSwap=ruleReferenceSwap();

            state._fsp--;

             current =iv_ruleReferenceSwap; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceSwap9635); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4336:1: ruleReferenceSwap returns [EObject current=null] : (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4339:28: ( (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4340:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4340:1: (otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4340:3: otherlv_0= 'swapref' otherlv_1= '(' ( (otherlv_2= RULE_ID ) ) otherlv_3= ',' ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )? ( (otherlv_6= RULE_ID ) ) otherlv_7= ')'
            {
            otherlv_0=(Token)match(input,60,FollowSets000.FOLLOW_60_in_ruleReferenceSwap9672); 

                	newLeafNode(otherlv_0, grammarAccess.getReferenceSwapAccess().getSwaprefKeyword_0());
                
            otherlv_1=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleReferenceSwap9684); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceSwapAccess().getLeftParenthesisKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4348:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4349:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4349:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4350:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap9704); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleReferenceSwap9716); 

                	newLeafNode(otherlv_3, grammarAccess.getReferenceSwapAccess().getCommaKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4365:1: ( ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->' )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==43||LA89_0==45||(LA89_0>=62 && LA89_0<=64)) ) {
                alt89=1;
            }
            else if ( (LA89_0==RULE_ID) ) {
                int LA89_2 = input.LA(2);

                if ( (LA89_2==40||LA89_2==61) ) {
                    alt89=1;
                }
            }
            switch (alt89) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4365:2: ( (lv_object_4_0= ruleObSelectionStrategy ) ) otherlv_5= '->'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4365:2: ( (lv_object_4_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4366:1: (lv_object_4_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4366:1: (lv_object_4_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4367:3: lv_object_4_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getReferenceSwapAccess().getObjectObSelectionStrategyParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap9738);
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

                    otherlv_5=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleReferenceSwap9750); 

                        	newLeafNode(otherlv_5, grammarAccess.getReferenceSwapAccess().getHyphenMinusGreaterThanSignKeyword_4_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4387:3: ( (otherlv_6= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4388:1: (otherlv_6= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4388:1: (otherlv_6= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4389:3: otherlv_6= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceSwapRule());
            	        }
                    
            otherlv_6=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceSwap9772); 

            		newLeafNode(otherlv_6, grammarAccess.getReferenceSwapAccess().getReferenceEReferenceCrossReference_5_0()); 
            	

            }


            }

            otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleReferenceSwap9784); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4412:1: entryRuleReferenceAtt returns [EObject current=null] : iv_ruleReferenceAtt= ruleReferenceAtt EOF ;
    public final EObject entryRuleReferenceAtt() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceAtt = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4413:2: (iv_ruleReferenceAtt= ruleReferenceAtt EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4414:2: iv_ruleReferenceAtt= ruleReferenceAtt EOF
            {
             newCompositeNode(grammarAccess.getReferenceAttRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReferenceAtt_in_entryRuleReferenceAtt9820);
            iv_ruleReferenceAtt=ruleReferenceAtt();

            state._fsp--;

             current =iv_ruleReferenceAtt; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReferenceAtt9830); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4421:1: ruleReferenceAtt returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) ;
    public final EObject ruleReferenceAtt() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4424:28: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4425:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4425:1: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4425:2: ( (otherlv_0= RULE_ID ) ) otherlv_1= '.' ( (otherlv_2= RULE_ID ) ) ( (lv_value_3_0= ruleAttributeType ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4425:2: ( (otherlv_0= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4426:1: (otherlv_0= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4426:1: (otherlv_0= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4427:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAttRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAtt9875); 

            		newLeafNode(otherlv_0, grammarAccess.getReferenceAttAccess().getReferenceEReferenceCrossReference_0_0()); 
            	

            }


            }

            otherlv_1=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleReferenceAtt9887); 

                	newLeafNode(otherlv_1, grammarAccess.getReferenceAttAccess().getFullStopKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4442:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4443:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4443:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4444:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getReferenceAttRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleReferenceAtt9907); 

            		newLeafNode(otherlv_2, grammarAccess.getReferenceAttAccess().getAttributeEAttributeCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4455:2: ( (lv_value_3_0= ruleAttributeType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4456:1: (lv_value_3_0= ruleAttributeType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4456:1: (lv_value_3_0= ruleAttributeType )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4457:3: lv_value_3_0= ruleAttributeType
            {
             
            	        newCompositeNode(grammarAccess.getReferenceAttAccess().getValueAttributeTypeParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleAttributeType_in_ruleReferenceAtt9928);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4481:1: entryRuleRandomTypeSelection returns [EObject current=null] : iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF ;
    public final EObject entryRuleRandomTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4482:2: (iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4483:2: iv_ruleRandomTypeSelection= ruleRandomTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection9964);
            iv_ruleRandomTypeSelection=ruleRandomTypeSelection();

            state._fsp--;

             current =iv_ruleRandomTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomTypeSelection9974); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4490:1: ruleRandomTypeSelection returns [EObject current=null] : ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4493:28: ( ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4494:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4494:1: ( () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4494:2: () otherlv_1= 'one' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4494:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4495:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomTypeSelectionAccess().getRandomTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleRandomTypeSelection10020); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomTypeSelectionAccess().getOneKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4504:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4505:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4505:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4506:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomTypeSelection10040); 

            		newLeafNode(otherlv_2, grammarAccess.getRandomTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4517:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==40) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==RULE_ID) ) {
                    int LA90_3 = input.LA(3);

                    if ( (LA90_3==EOF||LA90_3==RULE_ID||LA90_3==11||LA90_3==14||(LA90_3>=22 && LA90_3<=24)||LA90_3==27||LA90_3==29||LA90_3==34||LA90_3==40||LA90_3==42||LA90_3==46||(LA90_3>=48 && LA90_3<=49)||LA90_3==52||LA90_3==61||(LA90_3>=78 && LA90_3<=79)) ) {
                        alt90=1;
                    }
                }
            }
            switch (alt90) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4517:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleRandomTypeSelection10053); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4521:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4522:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4522:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4523:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getRandomTypeSelectionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomTypeSelection10073); 

                    		newLeafNode(otherlv_4, grammarAccess.getRandomTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4534:4: (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==61) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4534:6: otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleRandomTypeSelection10088); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomTypeSelectionAccess().getWhereKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleRandomTypeSelection10100); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4542:1: ( (lv_expression_7_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4543:1: (lv_expression_7_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4543:1: (lv_expression_7_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4544:3: lv_expression_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleRandomTypeSelection10121);
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

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleRandomTypeSelection10133); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4572:1: entryRuleSpecificObjectSelection returns [EObject current=null] : iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF ;
    public final EObject entryRuleSpecificObjectSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificObjectSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4573:2: (iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4574:2: iv_ruleSpecificObjectSelection= ruleSpecificObjectSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificObjectSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection10171);
            iv_ruleSpecificObjectSelection=ruleSpecificObjectSelection();

            state._fsp--;

             current =iv_ruleSpecificObjectSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificObjectSelection10181); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4581:1: ruleSpecificObjectSelection returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4584:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4585:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4585:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4585:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4585:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4586:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificObjectSelectionAccess().getSpecificObjectSelectionAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4591:2: ( (otherlv_1= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4592:1: (otherlv_1= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4592:1: (otherlv_1= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4593:3: otherlv_1= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
            	        }
                    
            otherlv_1=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10235); 

            		newLeafNode(otherlv_1, grammarAccess.getSpecificObjectSelectionAccess().getObjSelObjectEmitterCrossReference_1_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4604:2: (otherlv_2= '->' ( (otherlv_3= RULE_ID ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==40) ) {
                int LA92_1 = input.LA(2);

                if ( (LA92_1==RULE_ID) ) {
                    int LA92_3 = input.LA(3);

                    if ( (LA92_3==EOF||LA92_3==RULE_ID||LA92_3==11||LA92_3==14||(LA92_3>=22 && LA92_3<=24)||LA92_3==27||LA92_3==29||LA92_3==34||LA92_3==40||LA92_3==42||LA92_3==46||(LA92_3>=48 && LA92_3<=49)||LA92_3==52||LA92_3==61||(LA92_3>=78 && LA92_3<=79)) ) {
                        alt92=1;
                    }
                }
            }
            switch (alt92) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4604:4: otherlv_2= '->' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSpecificObjectSelection10248); 

                        	newLeafNode(otherlv_2, grammarAccess.getSpecificObjectSelectionAccess().getHyphenMinusGreaterThanSignKeyword_2_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4608:1: ( (otherlv_3= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4609:1: (otherlv_3= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4609:1: (otherlv_3= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4610:3: otherlv_3= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSpecificObjectSelectionRule());
                    	        }
                            
                    otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10268); 

                    		newLeafNode(otherlv_3, grammarAccess.getSpecificObjectSelectionAccess().getRefTypeEReferenceCrossReference_2_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4621:4: (otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}' )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==61) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4621:6: otherlv_4= 'where' otherlv_5= '{' ( (lv_expression_6_0= ruleExpression ) ) otherlv_7= '}'
                    {
                    otherlv_4=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleSpecificObjectSelection10283); 

                        	newLeafNode(otherlv_4, grammarAccess.getSpecificObjectSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_5=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpecificObjectSelection10295); 

                        	newLeafNode(otherlv_5, grammarAccess.getSpecificObjectSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4629:1: ( (lv_expression_6_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4630:1: (lv_expression_6_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4630:1: (lv_expression_6_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4631:3: lv_expression_6_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificObjectSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSpecificObjectSelection10316);
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

                    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSpecificObjectSelection10328); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4659:1: entryRuleSpecificClosureSelection returns [EObject current=null] : iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF ;
    public final EObject entryRuleSpecificClosureSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificClosureSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4660:2: (iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4661:2: iv_ruleSpecificClosureSelection= ruleSpecificClosureSelection EOF
            {
             newCompositeNode(grammarAccess.getSpecificClosureSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificClosureSelection_in_entryRuleSpecificClosureSelection10366);
            iv_ruleSpecificClosureSelection=ruleSpecificClosureSelection();

            state._fsp--;

             current =iv_ruleSpecificClosureSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificClosureSelection10376); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4668:1: ruleSpecificClosureSelection returns [EObject current=null] : ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4671:28: ( ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4672:1: ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4672:1: ( () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4672:2: () otherlv_1= 'closure' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ')' (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4672:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4673:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificClosureSelectionAccess().getSpecificClosureSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,62,FollowSets000.FOLLOW_62_in_ruleSpecificClosureSelection10422); 

                	newLeafNode(otherlv_1, grammarAccess.getSpecificClosureSelectionAccess().getClosureKeyword_1());
                
            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleSpecificClosureSelection10434); 

                	newLeafNode(otherlv_2, grammarAccess.getSpecificClosureSelectionAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4686:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4687:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4687:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4688:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificClosureSelection10454); 

            		newLeafNode(otherlv_3, grammarAccess.getSpecificClosureSelectionAccess().getObjSelObjectEmitterCrossReference_3_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4699:2: (otherlv_4= '->' ( (otherlv_5= RULE_ID ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==40) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4699:4: otherlv_4= '->' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleSpecificClosureSelection10467); 

                        	newLeafNode(otherlv_4, grammarAccess.getSpecificClosureSelectionAccess().getHyphenMinusGreaterThanSignKeyword_4_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4703:1: ( (otherlv_5= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4704:1: (otherlv_5= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4704:1: (otherlv_5= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4705:3: otherlv_5= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSpecificClosureSelectionRule());
                    	        }
                            
                    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSpecificClosureSelection10487); 

                    		newLeafNode(otherlv_5, grammarAccess.getSpecificClosureSelectionAccess().getRefTypeEReferenceCrossReference_4_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleSpecificClosureSelection10501); 

                	newLeafNode(otherlv_6, grammarAccess.getSpecificClosureSelectionAccess().getRightParenthesisKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4720:1: (otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}' )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( (LA95_0==61) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4720:3: otherlv_7= 'where' otherlv_8= '{' ( (lv_expression_9_0= ruleExpression ) ) otherlv_10= '}'
                    {
                    otherlv_7=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleSpecificClosureSelection10514); 

                        	newLeafNode(otherlv_7, grammarAccess.getSpecificClosureSelectionAccess().getWhereKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSpecificClosureSelection10526); 

                        	newLeafNode(otherlv_8, grammarAccess.getSpecificClosureSelectionAccess().getLeftCurlyBracketKeyword_6_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4728:1: ( (lv_expression_9_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4729:1: (lv_expression_9_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4729:1: (lv_expression_9_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4730:3: lv_expression_9_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificClosureSelectionAccess().getExpressionExpressionParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleSpecificClosureSelection10547);
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

                    otherlv_10=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSpecificClosureSelection10559); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4758:1: entryRuleCompleteTypeSelection returns [EObject current=null] : iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF ;
    public final EObject entryRuleCompleteTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompleteTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4759:2: (iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4760:2: iv_ruleCompleteTypeSelection= ruleCompleteTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getCompleteTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection10597);
            iv_ruleCompleteTypeSelection=ruleCompleteTypeSelection();

            state._fsp--;

             current =iv_ruleCompleteTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCompleteTypeSelection10607); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4767:1: ruleCompleteTypeSelection returns [EObject current=null] : ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4770:28: ( ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4771:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4771:1: ( () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4771:2: () otherlv_1= 'all' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4771:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4772:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCompleteTypeSelectionAccess().getCompleteTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleCompleteTypeSelection10653); 

                	newLeafNode(otherlv_1, grammarAccess.getCompleteTypeSelectionAccess().getAllKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4781:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4782:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4782:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4783:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompleteTypeSelection10673); 

            		newLeafNode(otherlv_2, grammarAccess.getCompleteTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4794:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==40) ) {
                int LA96_1 = input.LA(2);

                if ( (LA96_1==RULE_ID) ) {
                    int LA96_3 = input.LA(3);

                    if ( (LA96_3==EOF||LA96_3==RULE_ID||LA96_3==11||LA96_3==14||(LA96_3>=22 && LA96_3<=24)||LA96_3==27||LA96_3==29||LA96_3==34||LA96_3==40||LA96_3==42||LA96_3==46||(LA96_3>=48 && LA96_3<=49)||LA96_3==52||LA96_3==61||(LA96_3>=78 && LA96_3<=79)) ) {
                        alt96=1;
                    }
                }
            }
            switch (alt96) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4794:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleCompleteTypeSelection10686); 

                        	newLeafNode(otherlv_3, grammarAccess.getCompleteTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4798:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4799:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4799:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4800:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCompleteTypeSelectionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleCompleteTypeSelection10706); 

                    		newLeafNode(otherlv_4, grammarAccess.getCompleteTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4811:4: (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            int alt97=2;
            int LA97_0 = input.LA(1);

            if ( (LA97_0==61) ) {
                alt97=1;
            }
            switch (alt97) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4811:6: otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleCompleteTypeSelection10721); 

                        	newLeafNode(otherlv_5, grammarAccess.getCompleteTypeSelectionAccess().getWhereKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleCompleteTypeSelection10733); 

                        	newLeafNode(otherlv_6, grammarAccess.getCompleteTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4819:1: ( (lv_expression_7_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4820:1: (lv_expression_7_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4820:1: (lv_expression_7_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4821:3: lv_expression_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getCompleteTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleCompleteTypeSelection10754);
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

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleCompleteTypeSelection10766); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4849:1: entryRuleOtherTypeSelection returns [EObject current=null] : iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF ;
    public final EObject entryRuleOtherTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4850:2: (iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4851:2: iv_ruleOtherTypeSelection= ruleOtherTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getOtherTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection10804);
            iv_ruleOtherTypeSelection=ruleOtherTypeSelection();

            state._fsp--;

             current =iv_ruleOtherTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOtherTypeSelection10814); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4858:1: ruleOtherTypeSelection returns [EObject current=null] : ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4861:28: ( ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4862:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4862:1: ( () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4862:2: () otherlv_1= 'other' ( (otherlv_2= RULE_ID ) ) (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )? (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4862:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4863:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getOtherTypeSelectionAccess().getOtherTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,63,FollowSets000.FOLLOW_63_in_ruleOtherTypeSelection10860); 

                	newLeafNode(otherlv_1, grammarAccess.getOtherTypeSelectionAccess().getOtherKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4872:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4873:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4873:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4874:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOtherTypeSelection10880); 

            		newLeafNode(otherlv_2, grammarAccess.getOtherTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4885:2: (otherlv_3= '->' ( (otherlv_4= RULE_ID ) ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==40) ) {
                int LA98_1 = input.LA(2);

                if ( (LA98_1==RULE_ID) ) {
                    int LA98_3 = input.LA(3);

                    if ( (LA98_3==EOF||LA98_3==RULE_ID||LA98_3==11||LA98_3==14||(LA98_3>=22 && LA98_3<=24)||LA98_3==27||LA98_3==29||LA98_3==34||LA98_3==40||LA98_3==42||LA98_3==46||(LA98_3>=48 && LA98_3<=49)||LA98_3==52||LA98_3==61||(LA98_3>=78 && LA98_3<=79)) ) {
                        alt98=1;
                    }
                }
            }
            switch (alt98) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4885:4: otherlv_3= '->' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleOtherTypeSelection10893); 

                        	newLeafNode(otherlv_3, grammarAccess.getOtherTypeSelectionAccess().getHyphenMinusGreaterThanSignKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4889:1: ( (otherlv_4= RULE_ID ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4890:1: (otherlv_4= RULE_ID )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4890:1: (otherlv_4= RULE_ID )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4891:3: otherlv_4= RULE_ID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getOtherTypeSelectionRule());
                    	        }
                            
                    otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleOtherTypeSelection10913); 

                    		newLeafNode(otherlv_4, grammarAccess.getOtherTypeSelectionAccess().getRefTypeEReferenceCrossReference_3_1_0()); 
                    	

                    }


                    }


                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4902:4: (otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}' )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==61) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4902:6: otherlv_5= 'where' otherlv_6= '{' ( (lv_expression_7_0= ruleExpression ) ) otherlv_8= '}'
                    {
                    otherlv_5=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleOtherTypeSelection10928); 

                        	newLeafNode(otherlv_5, grammarAccess.getOtherTypeSelectionAccess().getWhereKeyword_4_0());
                        
                    otherlv_6=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleOtherTypeSelection10940); 

                        	newLeafNode(otherlv_6, grammarAccess.getOtherTypeSelectionAccess().getLeftCurlyBracketKeyword_4_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4910:1: ( (lv_expression_7_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4911:1: (lv_expression_7_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4911:1: (lv_expression_7_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4912:3: lv_expression_7_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getOtherTypeSelectionAccess().getExpressionExpressionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleOtherTypeSelection10961);
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

                    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleOtherTypeSelection10973); 

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


    // $ANTLR start "entryRuleEachTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4940:1: entryRuleEachTypeSelection returns [EObject current=null] : iv_ruleEachTypeSelection= ruleEachTypeSelection EOF ;
    public final EObject entryRuleEachTypeSelection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEachTypeSelection = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4941:2: (iv_ruleEachTypeSelection= ruleEachTypeSelection EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4942:2: iv_ruleEachTypeSelection= ruleEachTypeSelection EOF
            {
             newCompositeNode(grammarAccess.getEachTypeSelectionRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleEachTypeSelection_in_entryRuleEachTypeSelection11011);
            iv_ruleEachTypeSelection=ruleEachTypeSelection();

            state._fsp--;

             current =iv_ruleEachTypeSelection; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEachTypeSelection11021); 

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
    // $ANTLR end "entryRuleEachTypeSelection"


    // $ANTLR start "ruleEachTypeSelection"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4949:1: ruleEachTypeSelection returns [EObject current=null] : ( () otherlv_1= 'each' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) ;
    public final EObject ruleEachTypeSelection() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expression_5_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4952:28: ( ( () otherlv_1= 'each' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4953:1: ( () otherlv_1= 'each' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4953:1: ( () otherlv_1= 'each' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4953:2: () otherlv_1= 'each' ( (otherlv_2= RULE_ID ) ) (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4953:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4954:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEachTypeSelectionAccess().getEachTypeSelectionAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,64,FollowSets000.FOLLOW_64_in_ruleEachTypeSelection11067); 

                	newLeafNode(otherlv_1, grammarAccess.getEachTypeSelectionAccess().getEachKeyword_1());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4963:1: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4964:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4964:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4965:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEachTypeSelectionRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleEachTypeSelection11087); 

            		newLeafNode(otherlv_2, grammarAccess.getEachTypeSelectionAccess().getTypeEClassCrossReference_2_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4976:2: (otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==61) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4976:4: otherlv_3= 'where' otherlv_4= '{' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
                    {
                    otherlv_3=(Token)match(input,61,FollowSets000.FOLLOW_61_in_ruleEachTypeSelection11100); 

                        	newLeafNode(otherlv_3, grammarAccess.getEachTypeSelectionAccess().getWhereKeyword_3_0());
                        
                    otherlv_4=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleEachTypeSelection11112); 

                        	newLeafNode(otherlv_4, grammarAccess.getEachTypeSelectionAccess().getLeftCurlyBracketKeyword_3_1());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4984:1: ( (lv_expression_5_0= ruleExpression ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4985:1: (lv_expression_5_0= ruleExpression )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4985:1: (lv_expression_5_0= ruleExpression )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:4986:3: lv_expression_5_0= ruleExpression
                    {
                     
                    	        newCompositeNode(grammarAccess.getEachTypeSelectionAccess().getExpressionExpressionParserRuleCall_3_2_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleExpression_in_ruleEachTypeSelection11133);
                    lv_expression_5_0=ruleExpression();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getEachTypeSelectionRule());
                    	        }
                           		set(
                           			current, 
                           			"expression",
                            		lv_expression_5_0, 
                            		"Expression");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleEachTypeSelection11145); 

                        	newLeafNode(otherlv_6, grammarAccess.getEachTypeSelectionAccess().getRightCurlyBracketKeyword_3_3());
                        

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
    // $ANTLR end "ruleEachTypeSelection"


    // $ANTLR start "entryRuleBooleanType"
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5014:1: entryRuleBooleanType returns [EObject current=null] : iv_ruleBooleanType= ruleBooleanType EOF ;
    public final EObject entryRuleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5015:2: (iv_ruleBooleanType= ruleBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5016:2: iv_ruleBooleanType= ruleBooleanType EOF
            {
             newCompositeNode(grammarAccess.getBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleBooleanType_in_entryRuleBooleanType11183);
            iv_ruleBooleanType=ruleBooleanType();

            state._fsp--;

             current =iv_ruleBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBooleanType11193); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5023:1: ruleBooleanType returns [EObject current=null] : (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) ;
    public final EObject ruleBooleanType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificBooleanType_0 = null;

        EObject this_RandomBooleanType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5026:28: ( (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5027:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5027:1: (this_SpecificBooleanType_0= ruleSpecificBooleanType | this_RandomBooleanType_1= ruleRandomBooleanType )
            int alt101=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA101_1 = input.LA(2);

                if ( ((LA101_1>=37 && LA101_1<=38)) ) {
                    alt101=1;
                }
                else if ( (LA101_1==65) ) {
                    alt101=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 1, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA101_2 = input.LA(2);

                if ( (LA101_2==65) ) {
                    alt101=2;
                }
                else if ( ((LA101_2>=37 && LA101_2<=38)) ) {
                    alt101=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA101_3 = input.LA(2);

                if ( (LA101_3==65) ) {
                    alt101=2;
                }
                else if ( ((LA101_3>=37 && LA101_3<=38)) ) {
                    alt101=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 101, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 101, 0, input);

                throw nvae;
            }

            switch (alt101) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5028:5: this_SpecificBooleanType_0= ruleSpecificBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getSpecificBooleanTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType11240);
                    this_SpecificBooleanType_0=ruleSpecificBooleanType();

                    state._fsp--;

                     
                            current = this_SpecificBooleanType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5038:5: this_RandomBooleanType_1= ruleRandomBooleanType
                    {
                     
                            newCompositeNode(grammarAccess.getBooleanTypeAccess().getRandomBooleanTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_ruleBooleanType11267);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5054:1: entryRuleRandomBooleanType returns [EObject current=null] : iv_ruleRandomBooleanType= ruleRandomBooleanType EOF ;
    public final EObject entryRuleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5055:2: (iv_ruleRandomBooleanType= ruleRandomBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5056:2: iv_ruleRandomBooleanType= ruleRandomBooleanType EOF
            {
             newCompositeNode(grammarAccess.getRandomBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType11302);
            iv_ruleRandomBooleanType=ruleRandomBooleanType();

            state._fsp--;

             current =iv_ruleRandomBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomBooleanType11312); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5063:1: ruleRandomBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) ;
    public final EObject ruleRandomBooleanType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5066:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5067:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5067:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5067:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-boolean'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5067:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5068:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomBooleanTypeAccess().getRandomBooleanTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5073:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5074:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5074:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5075:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomBooleanType11367);
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

            otherlv_2=(Token)match(input,65,FollowSets000.FOLLOW_65_in_ruleRandomBooleanType11379); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5103:1: entryRuleSpecificBooleanType returns [EObject current=null] : iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF ;
    public final EObject entryRuleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificBooleanType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5104:2: (iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5105:2: iv_ruleSpecificBooleanType= ruleSpecificBooleanType EOF
            {
             newCompositeNode(grammarAccess.getSpecificBooleanTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType11415);
            iv_ruleSpecificBooleanType=ruleSpecificBooleanType();

            state._fsp--;

             current =iv_ruleSpecificBooleanType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificBooleanType11425); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5112:1: ruleSpecificBooleanType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) ;
    public final EObject ruleSpecificBooleanType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5115:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5116:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5116:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5116:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEBoolean ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5116:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5117:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificBooleanTypeAccess().getSpecificBooleanTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5122:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5123:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5123:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5124:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificBooleanType11480);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5140:2: ( (lv_value_2_0= ruleEBoolean ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5141:1: (lv_value_2_0= ruleEBoolean )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5141:1: (lv_value_2_0= ruleEBoolean )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5142:3: lv_value_2_0= ruleEBoolean
            {
             
            	        newCompositeNode(grammarAccess.getSpecificBooleanTypeAccess().getValueEBooleanParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType11501);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5166:1: entryRuleStringType returns [EObject current=null] : iv_ruleStringType= ruleStringType EOF ;
    public final EObject entryRuleStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5167:2: (iv_ruleStringType= ruleStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5168:2: iv_ruleStringType= ruleStringType EOF
            {
             newCompositeNode(grammarAccess.getStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleStringType_in_entryRuleStringType11537);
            iv_ruleStringType=ruleStringType();

            state._fsp--;

             current =iv_ruleStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleStringType11547); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5175:1: ruleStringType returns [EObject current=null] : (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5178:28: ( (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5179:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5179:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )
            int alt102=7;
            alt102 = dfa102.predict(input);
            switch (alt102) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5180:5: this_SpecificStringType_0= ruleSpecificStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getSpecificStringTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_ruleStringType11594);
                    this_SpecificStringType_0=ruleSpecificStringType();

                    state._fsp--;

                     
                            current = this_SpecificStringType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5190:5: this_RandomStringType_1= ruleRandomStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getRandomStringTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_ruleStringType11621);
                    this_RandomStringType_1=ruleRandomStringType();

                    state._fsp--;

                     
                            current = this_RandomStringType_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5200:5: this_UpperStringType_2= ruleUpperStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getUpperStringTypeParserRuleCall_2()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_ruleStringType11648);
                    this_UpperStringType_2=ruleUpperStringType();

                    state._fsp--;

                     
                            current = this_UpperStringType_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5210:5: this_LowerStringType_3= ruleLowerStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getLowerStringTypeParserRuleCall_3()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_ruleStringType11675);
                    this_LowerStringType_3=ruleLowerStringType();

                    state._fsp--;

                     
                            current = this_LowerStringType_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5220:5: this_CatStartStringType_4= ruleCatStartStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatStartStringTypeParserRuleCall_4()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_ruleStringType11702);
                    this_CatStartStringType_4=ruleCatStartStringType();

                    state._fsp--;

                     
                            current = this_CatStartStringType_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5230:5: this_CatEndStringType_5= ruleCatEndStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getCatEndStringTypeParserRuleCall_5()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_ruleStringType11729);
                    this_CatEndStringType_5=ruleCatEndStringType();

                    state._fsp--;

                     
                            current = this_CatEndStringType_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5240:5: this_ReplaceStringType_6= ruleReplaceStringType
                    {
                     
                            newCompositeNode(grammarAccess.getStringTypeAccess().getReplaceStringTypeParserRuleCall_6()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_ruleStringType11756);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5256:1: entryRuleRandomStringType returns [EObject current=null] : iv_ruleRandomStringType= ruleRandomStringType EOF ;
    public final EObject entryRuleRandomStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5257:2: (iv_ruleRandomStringType= ruleRandomStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5258:2: iv_ruleRandomStringType= ruleRandomStringType EOF
            {
             newCompositeNode(grammarAccess.getRandomStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType11791);
            iv_ruleRandomStringType=ruleRandomStringType();

            state._fsp--;

             current =iv_ruleRandomStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomStringType11801); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5265:1: ruleRandomStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5268:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5269:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5269:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5269:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-string' otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5269:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5270:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomStringTypeAccess().getRandomStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5275:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5276:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5276:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5277:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomStringType11856);
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

            otherlv_2=(Token)match(input,66,FollowSets000.FOLLOW_66_in_ruleRandomStringType11868); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomStringTypeAccess().getRandomStringKeyword_2());
                
            otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleRandomStringType11880); 

                	newLeafNode(otherlv_3, grammarAccess.getRandomStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5301:1: ( (lv_min_4_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5302:1: (lv_min_4_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5302:1: (lv_min_4_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5303:3: lv_min_4_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMinEIntParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType11901);
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

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomStringType11913); 

                	newLeafNode(otherlv_5, grammarAccess.getRandomStringTypeAccess().getCommaKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5323:1: ( (lv_max_6_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5324:1: (lv_max_6_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5324:1: (lv_max_6_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5325:3: lv_max_6_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomStringTypeAccess().getMaxEIntParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomStringType11934);
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

            otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomStringType11946); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5353:1: entryRuleSpecificStringType returns [EObject current=null] : iv_ruleSpecificStringType= ruleSpecificStringType EOF ;
    public final EObject entryRuleSpecificStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5354:2: (iv_ruleSpecificStringType= ruleSpecificStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5355:2: iv_ruleSpecificStringType= ruleSpecificStringType EOF
            {
             newCompositeNode(grammarAccess.getSpecificStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType11982);
            iv_ruleSpecificStringType=ruleSpecificStringType();

            state._fsp--;

             current =iv_ruleSpecificStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificStringType11992); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5362:1: ruleSpecificStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) ;
    public final EObject ruleSpecificStringType() throws RecognitionException {
        EObject current = null;

        Token lv_value_2_0=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5365:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5366:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5366:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5366:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= RULE_STRING ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5366:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5367:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificStringTypeAccess().getSpecificStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5372:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5373:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5373:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5374:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificStringType12047);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5390:2: ( (lv_value_2_0= RULE_STRING ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5391:1: (lv_value_2_0= RULE_STRING )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5391:1: (lv_value_2_0= RULE_STRING )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5392:3: lv_value_2_0= RULE_STRING
            {
            lv_value_2_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSpecificStringType12064); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5416:1: entryRuleUpperStringType returns [EObject current=null] : iv_ruleUpperStringType= ruleUpperStringType EOF ;
    public final EObject entryRuleUpperStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUpperStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5417:2: (iv_ruleUpperStringType= ruleUpperStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5418:2: iv_ruleUpperStringType= ruleUpperStringType EOF
            {
             newCompositeNode(grammarAccess.getUpperStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType12105);
            iv_ruleUpperStringType=ruleUpperStringType();

            state._fsp--;

             current =iv_ruleUpperStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleUpperStringType12115); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5425:1: ruleUpperStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) ;
    public final EObject ruleUpperStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5428:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5429:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5429:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5429:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'upper'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5429:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5430:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUpperStringTypeAccess().getUpperStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5435:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5436:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5436:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5437:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getUpperStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleUpperStringType12170);
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

            otherlv_2=(Token)match(input,67,FollowSets000.FOLLOW_67_in_ruleUpperStringType12182); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5465:1: entryRuleCatStartStringType returns [EObject current=null] : iv_ruleCatStartStringType= ruleCatStartStringType EOF ;
    public final EObject entryRuleCatStartStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatStartStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5466:2: (iv_ruleCatStartStringType= ruleCatStartStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5467:2: iv_ruleCatStartStringType= ruleCatStartStringType EOF
            {
             newCompositeNode(grammarAccess.getCatStartStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType12218);
            iv_ruleCatStartStringType=ruleCatStartStringType();

            state._fsp--;

             current =iv_ruleCatStartStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatStartStringType12228); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5474:1: ruleCatStartStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatStartStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5477:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5478:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5478:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5478:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catstart' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5478:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5479:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatStartStringTypeAccess().getCatStartStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5484:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5485:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5485:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5486:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleCatStartStringType12283);
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

            otherlv_2=(Token)match(input,68,FollowSets000.FOLLOW_68_in_ruleCatStartStringType12295); 

                	newLeafNode(otherlv_2, grammarAccess.getCatStartStringTypeAccess().getCatstartKeyword_2());
                
            otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCatStartStringType12307); 

                	newLeafNode(otherlv_3, grammarAccess.getCatStartStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5510:1: ( (lv_value_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5511:1: (lv_value_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5511:1: (lv_value_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5512:3: lv_value_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatStartStringTypeAccess().getValueEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatStartStringType12328);
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

            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCatStartStringType12340); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5540:1: entryRuleCatEndStringType returns [EObject current=null] : iv_ruleCatEndStringType= ruleCatEndStringType EOF ;
    public final EObject entryRuleCatEndStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCatEndStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5541:2: (iv_ruleCatEndStringType= ruleCatEndStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5542:2: iv_ruleCatEndStringType= ruleCatEndStringType EOF
            {
             newCompositeNode(grammarAccess.getCatEndStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType12376);
            iv_ruleCatEndStringType=ruleCatEndStringType();

            state._fsp--;

             current =iv_ruleCatEndStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCatEndStringType12386); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5549:1: ruleCatEndStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) ;
    public final EObject ruleCatEndStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5552:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5553:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5553:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5553:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'catend' otherlv_3= '(' ( (lv_value_4_0= ruleEString ) ) otherlv_5= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5553:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5554:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getCatEndStringTypeAccess().getCatEndStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5559:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5560:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5560:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5561:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleCatEndStringType12441);
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

            otherlv_2=(Token)match(input,69,FollowSets000.FOLLOW_69_in_ruleCatEndStringType12453); 

                	newLeafNode(otherlv_2, grammarAccess.getCatEndStringTypeAccess().getCatendKeyword_2());
                
            otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleCatEndStringType12465); 

                	newLeafNode(otherlv_3, grammarAccess.getCatEndStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5585:1: ( (lv_value_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5586:1: (lv_value_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5586:1: (lv_value_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5587:3: lv_value_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getCatEndStringTypeAccess().getValueEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleCatEndStringType12486);
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

            otherlv_5=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleCatEndStringType12498); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5615:1: entryRuleListStringType returns [EObject current=null] : iv_ruleListStringType= ruleListStringType EOF ;
    public final EObject entryRuleListStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5616:2: (iv_ruleListStringType= ruleListStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5617:2: iv_ruleListStringType= ruleListStringType EOF
            {
             newCompositeNode(grammarAccess.getListStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListStringType_in_entryRuleListStringType12534);
            iv_ruleListStringType=ruleListStringType();

            state._fsp--;

             current =iv_ruleListStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListStringType12544); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5624:1: ruleListStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5627:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5628:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5628:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5628:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '[' ( (lv_value_3_0= ruleEString ) ) (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )* otherlv_6= ']'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5628:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5629:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListStringTypeAccess().getListStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5634:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5635:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5635:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5636:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getListStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleListStringType12599);
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

            otherlv_2=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleListStringType12611); 

                	newLeafNode(otherlv_2, grammarAccess.getListStringTypeAccess().getLeftSquareBracketKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5656:1: ( (lv_value_3_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5657:1: (lv_value_3_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5657:1: (lv_value_3_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5658:3: lv_value_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType12632);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5674:2: (otherlv_4= ',' ( (lv_value_5_0= ruleEString ) ) )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==24) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5674:4: otherlv_4= ',' ( (lv_value_5_0= ruleEString ) )
            	    {
            	    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleListStringType12645); 

            	        	newLeafNode(otherlv_4, grammarAccess.getListStringTypeAccess().getCommaKeyword_4_0());
            	        
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5678:1: ( (lv_value_5_0= ruleEString ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5679:1: (lv_value_5_0= ruleEString )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5679:1: (lv_value_5_0= ruleEString )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5680:3: lv_value_5_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getListStringTypeAccess().getValueEStringParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleListStringType12666);
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
            	    break loop103;
                }
            } while (true);

            otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleListStringType12680); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5708:1: entryRuleLowerStringType returns [EObject current=null] : iv_ruleLowerStringType= ruleLowerStringType EOF ;
    public final EObject entryRuleLowerStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5709:2: (iv_ruleLowerStringType= ruleLowerStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5710:2: iv_ruleLowerStringType= ruleLowerStringType EOF
            {
             newCompositeNode(grammarAccess.getLowerStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType12716);
            iv_ruleLowerStringType=ruleLowerStringType();

            state._fsp--;

             current =iv_ruleLowerStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerStringType12726); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5717:1: ruleLowerStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) ;
    public final EObject ruleLowerStringType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5720:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5721:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5721:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5721:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'lower'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5721:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5722:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getLowerStringTypeAccess().getLowerStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5727:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5728:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5728:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5729:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getLowerStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleLowerStringType12781);
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

            otherlv_2=(Token)match(input,70,FollowSets000.FOLLOW_70_in_ruleLowerStringType12793); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5757:1: entryRuleReplaceStringType returns [EObject current=null] : iv_ruleReplaceStringType= ruleReplaceStringType EOF ;
    public final EObject entryRuleReplaceStringType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReplaceStringType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5758:2: (iv_ruleReplaceStringType= ruleReplaceStringType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5759:2: iv_ruleReplaceStringType= ruleReplaceStringType EOF
            {
             newCompositeNode(grammarAccess.getReplaceStringTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType12829);
            iv_ruleReplaceStringType=ruleReplaceStringType();

            state._fsp--;

             current =iv_ruleReplaceStringType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleReplaceStringType12839); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5766:1: ruleReplaceStringType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5769:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5770:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5770:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5770:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'replace' otherlv_3= '(' ( (lv_oldstring_4_0= ruleEString ) ) otherlv_5= ',' ( (lv_newstring_6_0= ruleEString ) ) otherlv_7= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5770:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5771:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getReplaceStringTypeAccess().getReplaceStringTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5776:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5777:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5777:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5778:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleReplaceStringType12894);
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

            otherlv_2=(Token)match(input,71,FollowSets000.FOLLOW_71_in_ruleReplaceStringType12906); 

                	newLeafNode(otherlv_2, grammarAccess.getReplaceStringTypeAccess().getReplaceKeyword_2());
                
            otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleReplaceStringType12918); 

                	newLeafNode(otherlv_3, grammarAccess.getReplaceStringTypeAccess().getLeftParenthesisKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5802:1: ( (lv_oldstring_4_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5803:1: (lv_oldstring_4_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5803:1: (lv_oldstring_4_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5804:3: lv_oldstring_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getOldstringEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType12939);
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

            otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleReplaceStringType12951); 

                	newLeafNode(otherlv_5, grammarAccess.getReplaceStringTypeAccess().getCommaKeyword_5());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5824:1: ( (lv_newstring_6_0= ruleEString ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5825:1: (lv_newstring_6_0= ruleEString )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5825:1: (lv_newstring_6_0= ruleEString )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5826:3: lv_newstring_6_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getReplaceStringTypeAccess().getNewstringEStringParserRuleCall_6_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEString_in_ruleReplaceStringType12972);
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

            otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleReplaceStringType12984); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5854:1: entryRuleDoubleType returns [EObject current=null] : iv_ruleDoubleType= ruleDoubleType EOF ;
    public final EObject entryRuleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5855:2: (iv_ruleDoubleType= ruleDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5856:2: iv_ruleDoubleType= ruleDoubleType EOF
            {
             newCompositeNode(grammarAccess.getDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleDoubleType_in_entryRuleDoubleType13020);
            iv_ruleDoubleType=ruleDoubleType();

            state._fsp--;

             current =iv_ruleDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDoubleType13030); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5863:1: ruleDoubleType returns [EObject current=null] : (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) ;
    public final EObject ruleDoubleType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificDoubleType_0 = null;

        EObject this_RandomDoubleType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5866:28: ( (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5867:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5867:1: (this_SpecificDoubleType_0= ruleSpecificDoubleType | this_RandomDoubleType_1= ruleRandomDoubleType )
            int alt104=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA104_1 = input.LA(2);

                if ( (LA104_1==72) ) {
                    alt104=2;
                }
                else if ( (LA104_1==RULE_INT||(LA104_1>=33 && LA104_1<=34)) ) {
                    alt104=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 1, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA104_2 = input.LA(2);

                if ( (LA104_2==RULE_INT||(LA104_2>=33 && LA104_2<=34)) ) {
                    alt104=1;
                }
                else if ( (LA104_2==72) ) {
                    alt104=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 2, input);

                    throw nvae;
                }
                }
                break;
            case 22:
                {
                int LA104_3 = input.LA(2);

                if ( (LA104_3==72) ) {
                    alt104=2;
                }
                else if ( (LA104_3==RULE_INT||(LA104_3>=33 && LA104_3<=34)) ) {
                    alt104=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 104, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5868:5: this_SpecificDoubleType_0= ruleSpecificDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getSpecificDoubleTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType13077);
                    this_SpecificDoubleType_0=ruleSpecificDoubleType();

                    state._fsp--;

                     
                            current = this_SpecificDoubleType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5878:5: this_RandomDoubleType_1= ruleRandomDoubleType
                    {
                     
                            newCompositeNode(grammarAccess.getDoubleTypeAccess().getRandomDoubleTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_ruleDoubleType13104);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5894:1: entryRuleRandomDoubleType returns [EObject current=null] : iv_ruleRandomDoubleType= ruleRandomDoubleType EOF ;
    public final EObject entryRuleRandomDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5895:2: (iv_ruleRandomDoubleType= ruleRandomDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5896:2: iv_ruleRandomDoubleType= ruleRandomDoubleType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType13139);
            iv_ruleRandomDoubleType=ruleRandomDoubleType();

            state._fsp--;

             current =iv_ruleRandomDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomDoubleType13149); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5903:1: ruleRandomDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5906:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5907:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5907:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5907:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-double' (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5907:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5908:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5913:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5914:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5914:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5915:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomDoubleType13204);
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

            otherlv_2=(Token)match(input,72,FollowSets000.FOLLOW_72_in_ruleRandomDoubleType13216); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomDoubleTypeAccess().getRandomDoubleKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5935:1: (otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')' )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==55) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5935:3: otherlv_3= '(' ( (lv_min_4_0= ruleEDouble ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEDouble ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleRandomDoubleType13229); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomDoubleTypeAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5939:1: ( (lv_min_4_0= ruleEDouble ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5940:1: (lv_min_4_0= ruleEDouble )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5940:1: (lv_min_4_0= ruleEDouble )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5941:3: lv_min_4_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMinEDoubleParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType13250);
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

                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomDoubleType13262); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomDoubleTypeAccess().getCommaKeyword_3_2());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5961:1: ( (lv_max_6_0= ruleEDouble ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5962:1: (lv_max_6_0= ruleEDouble )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5962:1: (lv_max_6_0= ruleEDouble )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5963:3: lv_max_6_0= ruleEDouble
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleTypeAccess().getMaxEDoubleParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleType13283);
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

                    otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomDoubleType13295); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5991:1: entryRuleSpecificDoubleType returns [EObject current=null] : iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF ;
    public final EObject entryRuleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificDoubleType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5992:2: (iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:5993:2: iv_ruleSpecificDoubleType= ruleSpecificDoubleType EOF
            {
             newCompositeNode(grammarAccess.getSpecificDoubleTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType13333);
            iv_ruleSpecificDoubleType=ruleSpecificDoubleType();

            state._fsp--;

             current =iv_ruleSpecificDoubleType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificDoubleType13343); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6000:1: ruleSpecificDoubleType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) ;
    public final EObject ruleSpecificDoubleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6003:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6004:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6004:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6004:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEDouble ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6004:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6005:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificDoubleTypeAccess().getSpecificDoubleTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6010:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6011:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6011:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6012:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificDoubleType13398);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6028:2: ( (lv_value_2_0= ruleEDouble ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6029:1: (lv_value_2_0= ruleEDouble )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6029:1: (lv_value_2_0= ruleEDouble )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6030:3: lv_value_2_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getSpecificDoubleTypeAccess().getValueEDoubleParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleSpecificDoubleType13419);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6054:1: entryRuleMinValueType returns [EObject current=null] : iv_ruleMinValueType= ruleMinValueType EOF ;
    public final EObject entryRuleMinValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinValueType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6055:2: (iv_ruleMinValueType= ruleMinValueType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6056:2: iv_ruleMinValueType= ruleMinValueType EOF
            {
             newCompositeNode(grammarAccess.getMinValueTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMinValueType_in_entryRuleMinValueType13455);
            iv_ruleMinValueType=ruleMinValueType();

            state._fsp--;

             current =iv_ruleMinValueType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinValueType13465); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6063:1: ruleMinValueType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleMinValueType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_0_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6066:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6067:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6067:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6067:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'min' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6067:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6068:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6068:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6069:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getMinValueTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleMinValueType13511);
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

            otherlv_1=(Token)match(input,73,FollowSets000.FOLLOW_73_in_ruleMinValueType13523); 

                	newLeafNode(otherlv_1, grammarAccess.getMinValueTypeAccess().getMinKeyword_1());
                
            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMinValueType13535); 

                	newLeafNode(otherlv_2, grammarAccess.getMinValueTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6093:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6094:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6094:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6095:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMinValueTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMinValueType13555); 

            		newLeafNode(otherlv_3, grammarAccess.getMinValueTypeAccess().getAttributeEAttributeCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMinValueType13567); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6118:1: entryRuleMaxValueType returns [EObject current=null] : iv_ruleMaxValueType= ruleMaxValueType EOF ;
    public final EObject entryRuleMaxValueType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxValueType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6119:2: (iv_ruleMaxValueType= ruleMaxValueType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6120:2: iv_ruleMaxValueType= ruleMaxValueType EOF
            {
             newCompositeNode(grammarAccess.getMaxValueTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMaxValueType_in_entryRuleMaxValueType13603);
            iv_ruleMaxValueType=ruleMaxValueType();

            state._fsp--;

             current =iv_ruleMaxValueType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxValueType13613); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6127:1: ruleMaxValueType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) ;
    public final EObject ruleMaxValueType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_0_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6130:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6131:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6131:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6131:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'max' otherlv_2= '(' ( (otherlv_3= RULE_ID ) ) otherlv_4= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6131:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6132:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6132:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6133:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getMaxValueTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleMaxValueType13659);
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

            otherlv_1=(Token)match(input,74,FollowSets000.FOLLOW_74_in_ruleMaxValueType13671); 

                	newLeafNode(otherlv_1, grammarAccess.getMaxValueTypeAccess().getMaxKeyword_1());
                
            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleMaxValueType13683); 

                	newLeafNode(otherlv_2, grammarAccess.getMaxValueTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6157:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6158:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6158:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6159:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMaxValueTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleMaxValueType13703); 

            		newLeafNode(otherlv_3, grammarAccess.getMaxValueTypeAccess().getAttributeEAttributeCrossReference_3_0()); 
            	

            }


            }

            otherlv_4=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleMaxValueType13715); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6182:1: entryRuleIntegerType returns [EObject current=null] : iv_ruleIntegerType= ruleIntegerType EOF ;
    public final EObject entryRuleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6183:2: (iv_ruleIntegerType= ruleIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6184:2: iv_ruleIntegerType= ruleIntegerType EOF
            {
             newCompositeNode(grammarAccess.getIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleIntegerType_in_entryRuleIntegerType13751);
            iv_ruleIntegerType=ruleIntegerType();

            state._fsp--;

             current =iv_ruleIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleIntegerType13761); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6191:1: ruleIntegerType returns [EObject current=null] : (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) ;
    public final EObject ruleIntegerType() throws RecognitionException {
        EObject current = null;

        EObject this_SpecificIntegerType_0 = null;

        EObject this_RandomIntegerType_1 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6194:28: ( (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6195:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6195:1: (this_SpecificIntegerType_0= ruleSpecificIntegerType | this_RandomIntegerType_1= ruleRandomIntegerType )
            int alt106=2;
            switch ( input.LA(1) ) {
            case 26:
                {
                int LA106_1 = input.LA(2);

                if ( (LA106_1==RULE_INT||LA106_1==33) ) {
                    alt106=1;
                }
                else if ( (LA106_1==75) ) {
                    alt106=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 106, 1, input);

                    throw nvae;
                }
                }
                break;
            case 80:
                {
                int LA106_2 = input.LA(2);

                if ( (LA106_2==75) ) {
                    alt106=2;
                }
                else if ( (LA106_2==RULE_INT||LA106_2==33) ) {
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

                if ( (LA106_3==75) ) {
                    alt106=2;
                }
                else if ( (LA106_3==RULE_INT||LA106_3==33) ) {
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
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6196:5: this_SpecificIntegerType_0= ruleSpecificIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getSpecificIntegerTypeParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType13808);
                    this_SpecificIntegerType_0=ruleSpecificIntegerType();

                    state._fsp--;

                     
                            current = this_SpecificIntegerType_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6206:5: this_RandomIntegerType_1= ruleRandomIntegerType
                    {
                     
                            newCompositeNode(grammarAccess.getIntegerTypeAccess().getRandomIntegerTypeParserRuleCall_1()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_ruleIntegerType13835);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6222:1: entryRuleSpecificIntegerType returns [EObject current=null] : iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF ;
    public final EObject entryRuleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6223:2: (iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6224:2: iv_ruleSpecificIntegerType= ruleSpecificIntegerType EOF
            {
             newCompositeNode(grammarAccess.getSpecificIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType13870);
            iv_ruleSpecificIntegerType=ruleSpecificIntegerType();

            state._fsp--;

             current =iv_ruleSpecificIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSpecificIntegerType13880); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6231:1: ruleSpecificIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) ;
    public final EObject ruleSpecificIntegerType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_operator_1_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6234:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6235:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6235:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6235:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (lv_value_2_0= ruleEInt ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6235:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6236:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSpecificIntegerTypeAccess().getSpecificIntegerTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6241:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6242:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6242:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6243:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleSpecificIntegerType13935);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6259:2: ( (lv_value_2_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6260:1: (lv_value_2_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6260:1: (lv_value_2_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6261:3: lv_value_2_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getSpecificIntegerTypeAccess().getValueEIntParserRuleCall_2_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleSpecificIntegerType13956);
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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6285:1: entryRuleRandomIntegerType returns [EObject current=null] : iv_ruleRandomIntegerType= ruleRandomIntegerType EOF ;
    public final EObject entryRuleRandomIntegerType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6286:2: (iv_ruleRandomIntegerType= ruleRandomIntegerType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6287:2: iv_ruleRandomIntegerType= ruleRandomIntegerType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType13992);
            iv_ruleRandomIntegerType=ruleRandomIntegerType();

            state._fsp--;

             current =iv_ruleRandomIntegerType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomIntegerType14002); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6294:1: ruleRandomIntegerType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6297:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6298:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6298:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )? )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6298:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random-int' (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6298:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6299:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomIntegerTypeAccess().getRandomIntegerTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6304:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6305:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6305:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6306:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomIntegerType14057);
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

            otherlv_2=(Token)match(input,75,FollowSets000.FOLLOW_75_in_ruleRandomIntegerType14069); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomIntegerTypeAccess().getRandomIntKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6326:1: (otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')' )?
            int alt107=2;
            int LA107_0 = input.LA(1);

            if ( (LA107_0==55) ) {
                alt107=1;
            }
            switch (alt107) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6326:3: otherlv_3= '(' ( (lv_min_4_0= ruleEInt ) ) otherlv_5= ',' ( (lv_max_6_0= ruleEInt ) ) otherlv_7= ')'
                    {
                    otherlv_3=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleRandomIntegerType14082); 

                        	newLeafNode(otherlv_3, grammarAccess.getRandomIntegerTypeAccess().getLeftParenthesisKeyword_3_0());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6330:1: ( (lv_min_4_0= ruleEInt ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6331:1: (lv_min_4_0= ruleEInt )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6331:1: (lv_min_4_0= ruleEInt )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6332:3: lv_min_4_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMinEIntParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType14103);
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

                    otherlv_5=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomIntegerType14115); 

                        	newLeafNode(otherlv_5, grammarAccess.getRandomIntegerTypeAccess().getCommaKeyword_3_2());
                        
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6352:1: ( (lv_max_6_0= ruleEInt ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6353:1: (lv_max_6_0= ruleEInt )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6353:1: (lv_max_6_0= ruleEInt )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6354:3: lv_max_6_0= ruleEInt
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerTypeAccess().getMaxEIntParserRuleCall_3_3_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerType14136);
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

                    otherlv_7=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomIntegerType14148); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6382:1: entryRuleRandomType returns [EObject current=null] : iv_ruleRandomType= ruleRandomType EOF ;
    public final EObject entryRuleRandomType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6383:2: (iv_ruleRandomType= ruleRandomType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6384:2: iv_ruleRandomType= ruleRandomType EOF
            {
             newCompositeNode(grammarAccess.getRandomTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomType_in_entryRuleRandomType14186);
            iv_ruleRandomType=ruleRandomType();

            state._fsp--;

             current =iv_ruleRandomType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomType14196); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6391:1: ruleRandomType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) ;
    public final EObject ruleRandomType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6394:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6395:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6395:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6395:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= 'random'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6395:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6396:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getRandomTypeAccess().getRandomTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6401:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6402:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6402:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6403:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomType14251);
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

            otherlv_2=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleRandomType14263); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6431:1: entryRuleRandomDoubleNumberType returns [EObject current=null] : iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF ;
    public final EObject entryRuleRandomDoubleNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomDoubleNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6432:2: (iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6433:2: iv_ruleRandomDoubleNumberType= ruleRandomDoubleNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomDoubleNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomDoubleNumberType_in_entryRuleRandomDoubleNumberType14299);
            iv_ruleRandomDoubleNumberType=ruleRandomDoubleNumberType();

            state._fsp--;

             current =iv_ruleRandomDoubleNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomDoubleNumberType14309); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6440:1: ruleRandomDoubleNumberType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6443:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6444:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6444:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6444:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEDouble ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6444:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6445:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6445:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6446:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomDoubleNumberType14355);
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

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleRandomDoubleNumberType14367); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomDoubleNumberTypeAccess().getRandomKeyword_1());
                
            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleRandomDoubleNumberType14379); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomDoubleNumberTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6470:1: ( (lv_min_3_0= ruleEDouble ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6471:1: (lv_min_3_0= ruleEDouble )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6471:1: (lv_min_3_0= ruleEDouble )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6472:3: lv_min_3_0= ruleEDouble
            {
             
            	        newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getMinEDoubleParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEDouble_in_ruleRandomDoubleNumberType14400);
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

            otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomDoubleNumberType14412); 

                	newLeafNode(otherlv_4, grammarAccess.getRandomDoubleNumberTypeAccess().getCommaKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6492:1: ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==43||LA108_0==45||(LA108_0>=62 && LA108_0<=64)) ) {
                alt108=1;
            }
            else if ( (LA108_0==RULE_ID) ) {
                int LA108_2 = input.LA(2);

                if ( (LA108_2==34||LA108_2==40||LA108_2==61) ) {
                    alt108=1;
                }
            }
            switch (alt108) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6492:2: ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6492:2: ( (lv_object_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6493:1: (lv_object_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6493:1: (lv_object_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6494:3: lv_object_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomDoubleNumberTypeAccess().getObjectObSelectionStrategyParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRandomDoubleNumberType14434);
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

                    otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRandomDoubleNumberType14446); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomDoubleNumberTypeAccess().getFullStopKeyword_5_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6514:3: ( (otherlv_7= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6515:1: (otherlv_7= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6515:1: (otherlv_7= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6516:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomDoubleNumberTypeRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomDoubleNumberType14468); 

            		newLeafNode(otherlv_7, grammarAccess.getRandomDoubleNumberTypeAccess().getMaxEAttributeCrossReference_6_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomDoubleNumberType14480); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6539:1: entryRuleRandomIntegerNumberType returns [EObject current=null] : iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF ;
    public final EObject entryRuleRandomIntegerNumberType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRandomIntegerNumberType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6540:2: (iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6541:2: iv_ruleRandomIntegerNumberType= ruleRandomIntegerNumberType EOF
            {
             newCompositeNode(grammarAccess.getRandomIntegerNumberTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleRandomIntegerNumberType_in_entryRuleRandomIntegerNumberType14516);
            iv_ruleRandomIntegerNumberType=ruleRandomIntegerNumberType();

            state._fsp--;

             current =iv_ruleRandomIntegerNumberType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRandomIntegerNumberType14526); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6548:1: ruleRandomIntegerNumberType returns [EObject current=null] : ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6551:28: ( ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6552:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6552:1: ( ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6552:2: ( (lv_operator_0_0= ruleOperator ) ) otherlv_1= 'random' otherlv_2= '(' ( (lv_min_3_0= ruleEInt ) ) otherlv_4= ',' ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )? ( (otherlv_7= RULE_ID ) ) otherlv_8= ')'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6552:2: ( (lv_operator_0_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6553:1: (lv_operator_0_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6553:1: (lv_operator_0_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6554:3: lv_operator_0_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getOperatorOperatorEnumRuleCall_0_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleRandomIntegerNumberType14572);
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

            otherlv_1=(Token)match(input,76,FollowSets000.FOLLOW_76_in_ruleRandomIntegerNumberType14584); 

                	newLeafNode(otherlv_1, grammarAccess.getRandomIntegerNumberTypeAccess().getRandomKeyword_1());
                
            otherlv_2=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleRandomIntegerNumberType14596); 

                	newLeafNode(otherlv_2, grammarAccess.getRandomIntegerNumberTypeAccess().getLeftParenthesisKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6578:1: ( (lv_min_3_0= ruleEInt ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6579:1: (lv_min_3_0= ruleEInt )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6579:1: (lv_min_3_0= ruleEInt )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6580:3: lv_min_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getMinEIntParserRuleCall_3_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleRandomIntegerNumberType14617);
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

            otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleRandomIntegerNumberType14629); 

                	newLeafNode(otherlv_4, grammarAccess.getRandomIntegerNumberTypeAccess().getCommaKeyword_4());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6600:1: ( ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.' )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==43||LA109_0==45||(LA109_0>=62 && LA109_0<=64)) ) {
                alt109=1;
            }
            else if ( (LA109_0==RULE_ID) ) {
                int LA109_2 = input.LA(2);

                if ( (LA109_2==34||LA109_2==40||LA109_2==61) ) {
                    alt109=1;
                }
            }
            switch (alt109) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6600:2: ( (lv_object_5_0= ruleObSelectionStrategy ) ) otherlv_6= '.'
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6600:2: ( (lv_object_5_0= ruleObSelectionStrategy ) )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6601:1: (lv_object_5_0= ruleObSelectionStrategy )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6601:1: (lv_object_5_0= ruleObSelectionStrategy )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6602:3: lv_object_5_0= ruleObSelectionStrategy
                    {
                     
                    	        newCompositeNode(grammarAccess.getRandomIntegerNumberTypeAccess().getObjectObSelectionStrategyParserRuleCall_5_0_0()); 
                    	    
                    pushFollow(FollowSets000.FOLLOW_ruleObSelectionStrategy_in_ruleRandomIntegerNumberType14651);
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

                    otherlv_6=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleRandomIntegerNumberType14663); 

                        	newLeafNode(otherlv_6, grammarAccess.getRandomIntegerNumberTypeAccess().getFullStopKeyword_5_1());
                        

                    }
                    break;

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6622:3: ( (otherlv_7= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6623:1: (otherlv_7= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6623:1: (otherlv_7= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6624:3: otherlv_7= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRandomIntegerNumberTypeRule());
            	        }
                    
            otherlv_7=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleRandomIntegerNumberType14685); 

            		newLeafNode(otherlv_7, grammarAccess.getRandomIntegerNumberTypeAccess().getMaxEAttributeCrossReference_6_0()); 
            	

            }


            }

            otherlv_8=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleRandomIntegerNumberType14697); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6647:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6648:2: (iv_ruleListType= ruleListType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6649:2: iv_ruleListType= ruleListType EOF
            {
             newCompositeNode(grammarAccess.getListTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleListType_in_entryRuleListType14733);
            iv_ruleListType=ruleListType();

            state._fsp--;

             current =iv_ruleListType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleListType14743); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6656:1: ruleListType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' ) ;
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
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6659:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6660:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6660:1: ( () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}' )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6660:2: () ( (lv_operator_1_0= ruleOperator ) ) otherlv_2= '{' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* otherlv_6= '}'
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6660:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6661:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getListTypeAccess().getListTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6666:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6667:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6667:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6668:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getListTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleListType14798);
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

            otherlv_2=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleListType14810); 

                	newLeafNode(otherlv_2, grammarAccess.getListTypeAccess().getLeftCurlyBracketKeyword_2());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6688:1: ( (otherlv_3= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6689:1: (otherlv_3= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6689:1: (otherlv_3= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6690:3: otherlv_3= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getListTypeRule());
            	        }
                    
            otherlv_3=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListType14830); 

            		newLeafNode(otherlv_3, grammarAccess.getListTypeAccess().getValueEObjectCrossReference_3_0()); 
            	

            }


            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6701:2: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
            loop110:
            do {
                int alt110=2;
                int LA110_0 = input.LA(1);

                if ( (LA110_0==24) ) {
                    alt110=1;
                }


                switch (alt110) {
            	case 1 :
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6701:4: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
            	    {
            	    otherlv_4=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleListType14843); 

            	        	newLeafNode(otherlv_4, grammarAccess.getListTypeAccess().getCommaKeyword_4_0());
            	        
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6705:1: ( (otherlv_5= RULE_ID ) )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6706:1: (otherlv_5= RULE_ID )
            	    {
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6706:1: (otherlv_5= RULE_ID )
            	    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6707:3: otherlv_5= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getListTypeRule());
            	    	        }
            	            
            	    otherlv_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleListType14863); 

            	    		newLeafNode(otherlv_5, grammarAccess.getListTypeAccess().getValueEObjectCrossReference_4_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop110;
                }
            } while (true);

            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleListType14877); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6730:1: entryRuleObjectAttributeType returns [EObject current=null] : iv_ruleObjectAttributeType= ruleObjectAttributeType EOF ;
    public final EObject entryRuleObjectAttributeType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectAttributeType = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6731:2: (iv_ruleObjectAttributeType= ruleObjectAttributeType EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6732:2: iv_ruleObjectAttributeType= ruleObjectAttributeType EOF
            {
             newCompositeNode(grammarAccess.getObjectAttributeTypeRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleObjectAttributeType_in_entryRuleObjectAttributeType14913);
            iv_ruleObjectAttributeType=ruleObjectAttributeType();

            state._fsp--;

             current =iv_ruleObjectAttributeType; 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleObjectAttributeType14923); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6739:1: ruleObjectAttributeType returns [EObject current=null] : ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleObjectAttributeType() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Enumerator lv_operator_1_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6742:28: ( ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6743:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6743:1: ( () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6743:2: () ( (lv_operator_1_0= ruleOperator ) ) ( (otherlv_2= RULE_ID ) ) otherlv_3= '.' ( (otherlv_4= RULE_ID ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6743:2: ()
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6744:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getObjectAttributeTypeAccess().getObjectAttributeTypeAction_0(),
                        current);
                

            }

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6749:2: ( (lv_operator_1_0= ruleOperator ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6750:1: (lv_operator_1_0= ruleOperator )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6750:1: (lv_operator_1_0= ruleOperator )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6751:3: lv_operator_1_0= ruleOperator
            {
             
            	        newCompositeNode(grammarAccess.getObjectAttributeTypeAccess().getOperatorOperatorEnumRuleCall_1_0()); 
            	    
            pushFollow(FollowSets000.FOLLOW_ruleOperator_in_ruleObjectAttributeType14978);
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

            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6767:2: ( (otherlv_2= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6768:1: (otherlv_2= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6768:1: (otherlv_2= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6769:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectAttributeTypeRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectAttributeType14998); 

            		newLeafNode(otherlv_2, grammarAccess.getObjectAttributeTypeAccess().getObjSelObjectEmitterCrossReference_2_0()); 
            	

            }


            }

            otherlv_3=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleObjectAttributeType15010); 

                	newLeafNode(otherlv_3, grammarAccess.getObjectAttributeTypeAccess().getFullStopKeyword_3());
                
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6784:1: ( (otherlv_4= RULE_ID ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6785:1: (otherlv_4= RULE_ID )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6785:1: (otherlv_4= RULE_ID )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6786:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getObjectAttributeTypeRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleObjectAttributeType15030); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6805:1: entryRuleMaxCardinality returns [String current=null] : iv_ruleMaxCardinality= ruleMaxCardinality EOF ;
    public final String entryRuleMaxCardinality() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleMaxCardinality = null;


        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6806:2: (iv_ruleMaxCardinality= ruleMaxCardinality EOF )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6807:2: iv_ruleMaxCardinality= ruleMaxCardinality EOF
            {
             newCompositeNode(grammarAccess.getMaxCardinalityRule()); 
            pushFollow(FollowSets000.FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality15067);
            iv_ruleMaxCardinality=ruleMaxCardinality();

            state._fsp--;

             current =iv_ruleMaxCardinality.getText(); 
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxCardinality15078); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6814:1: ruleMaxCardinality returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_EInt_0= ruleEInt | kw= '*' ) ;
    public final AntlrDatatypeRuleToken ruleMaxCardinality() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_EInt_0 = null;


         enterRule(); 
            
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6817:28: ( (this_EInt_0= ruleEInt | kw= '*' ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6818:1: (this_EInt_0= ruleEInt | kw= '*' )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6818:1: (this_EInt_0= ruleEInt | kw= '*' )
            int alt111=2;
            int LA111_0 = input.LA(1);

            if ( (LA111_0==RULE_INT||LA111_0==33) ) {
                alt111=1;
            }
            else if ( (LA111_0==77) ) {
                alt111=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 111, 0, input);

                throw nvae;
            }
            switch (alt111) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6819:5: this_EInt_0= ruleEInt
                    {
                     
                            newCompositeNode(grammarAccess.getMaxCardinalityAccess().getEIntParserRuleCall_0()); 
                        
                    pushFollow(FollowSets000.FOLLOW_ruleEInt_in_ruleMaxCardinality15125);
                    this_EInt_0=ruleEInt();

                    state._fsp--;


                    		current.merge(this_EInt_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6831:2: kw= '*'
                    {
                    kw=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleMaxCardinality15149); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6844:1: ruleLogicOperator returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) ;
    public final Enumerator ruleLogicOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6846:28: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6847:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6847:1: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) )
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==78) ) {
                alt112=1;
            }
            else if ( (LA112_0==79) ) {
                alt112=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 112, 0, input);

                throw nvae;
            }
            switch (alt112) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6847:2: (enumLiteral_0= 'and' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6847:2: (enumLiteral_0= 'and' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6847:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,78,FollowSets000.FOLLOW_78_in_ruleLogicOperator15203); 

                            current = grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getLogicOperatorAccess().getAndEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6853:6: (enumLiteral_1= 'or' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6853:6: (enumLiteral_1= 'or' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6853:8: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,79,FollowSets000.FOLLOW_79_in_ruleLogicOperator15220); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6863:1: ruleOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) ) ;
    public final Enumerator ruleOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6865:28: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6866:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6866:1: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '<>' ) | (enumLiteral_2= 'in' ) )
            int alt113=3;
            switch ( input.LA(1) ) {
            case 26:
                {
                alt113=1;
                }
                break;
            case 80:
                {
                alt113=2;
                }
                break;
            case 22:
                {
                alt113=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 113, 0, input);

                throw nvae;
            }

            switch (alt113) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6866:2: (enumLiteral_0= '=' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6866:2: (enumLiteral_0= '=' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6866:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleOperator15265); 

                            current = grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getOperatorAccess().getEqualsEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6872:6: (enumLiteral_1= '<>' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6872:6: (enumLiteral_1= '<>' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6872:8: enumLiteral_1= '<>'
                    {
                    enumLiteral_1=(Token)match(input,80,FollowSets000.FOLLOW_80_in_ruleOperator15282); 

                            current = grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getOperatorAccess().getDifferentEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6878:6: (enumLiteral_2= 'in' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6878:6: (enumLiteral_2= 'in' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6878:8: enumLiteral_2= 'in'
                    {
                    enumLiteral_2=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleOperator15299); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6888:1: ruleArithmeticOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) ;
    public final Enumerator ruleArithmeticOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6890:28: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6891:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6891:1: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            int alt114=5;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt114=1;
                }
                break;
            case 33:
                {
                alt114=2;
                }
                break;
            case 77:
                {
                alt114=3;
                }
                break;
            case 82:
                {
                alt114=4;
                }
                break;
            case 83:
                {
                alt114=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 114, 0, input);

                throw nvae;
            }

            switch (alt114) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6891:2: (enumLiteral_0= '+' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6891:2: (enumLiteral_0= '+' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6891:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,81,FollowSets000.FOLLOW_81_in_ruleArithmeticOperator15344); 

                            current = grammarAccess.getArithmeticOperatorAccess().getAddEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getArithmeticOperatorAccess().getAddEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6897:6: (enumLiteral_1= '-' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6897:6: (enumLiteral_1= '-' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6897:8: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleArithmeticOperator15361); 

                            current = grammarAccess.getArithmeticOperatorAccess().getSubtractEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_1, grammarAccess.getArithmeticOperatorAccess().getSubtractEnumLiteralDeclaration_1()); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6903:6: (enumLiteral_2= '*' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6903:6: (enumLiteral_2= '*' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6903:8: enumLiteral_2= '*'
                    {
                    enumLiteral_2=(Token)match(input,77,FollowSets000.FOLLOW_77_in_ruleArithmeticOperator15378); 

                            current = grammarAccess.getArithmeticOperatorAccess().getMultiplyEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_2, grammarAccess.getArithmeticOperatorAccess().getMultiplyEnumLiteralDeclaration_2()); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6909:6: (enumLiteral_3= '/' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6909:6: (enumLiteral_3= '/' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6909:8: enumLiteral_3= '/'
                    {
                    enumLiteral_3=(Token)match(input,82,FollowSets000.FOLLOW_82_in_ruleArithmeticOperator15395); 

                            current = grammarAccess.getArithmeticOperatorAccess().getDivideEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_3, grammarAccess.getArithmeticOperatorAccess().getDivideEnumLiteralDeclaration_3()); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6915:6: (enumLiteral_4= '%' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6915:6: (enumLiteral_4= '%' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6915:8: enumLiteral_4= '%'
                    {
                    enumLiteral_4=(Token)match(input,83,FollowSets000.FOLLOW_83_in_ruleArithmeticOperator15412); 

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
    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6925:1: ruleRepeat returns [Enumerator current=null] : ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) ;
    public final Enumerator ruleRepeat() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;

         enterRule(); 
        try {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6927:28: ( ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) ) )
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6928:1: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            {
            // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6928:1: ( (enumLiteral_0= 'yes' ) | (enumLiteral_1= 'no' ) )
            int alt115=2;
            int LA115_0 = input.LA(1);

            if ( (LA115_0==84) ) {
                alt115=1;
            }
            else if ( (LA115_0==85) ) {
                alt115=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 115, 0, input);

                throw nvae;
            }
            switch (alt115) {
                case 1 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6928:2: (enumLiteral_0= 'yes' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6928:2: (enumLiteral_0= 'yes' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6928:4: enumLiteral_0= 'yes'
                    {
                    enumLiteral_0=(Token)match(input,84,FollowSets000.FOLLOW_84_in_ruleRepeat15457); 

                            current = grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            newLeafNode(enumLiteral_0, grammarAccess.getRepeatAccess().getYesEnumLiteralDeclaration_0()); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6934:6: (enumLiteral_1= 'no' )
                    {
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6934:6: (enumLiteral_1= 'no' )
                    // ../wodel.dsls.wodel/src-gen/wodel/dsls/parser/antlr/internal/InternalWodel.g:6934:8: enumLiteral_1= 'no'
                    {
                    enumLiteral_1=(Token)match(input,85,FollowSets000.FOLLOW_85_in_ruleRepeat15474); 

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
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA20 dfa20 = new DFA20(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA102 dfa102 = new DFA102(this);
    static final String DFA15_eotS =
        "\22\uffff";
    static final String DFA15_eofS =
        "\22\uffff";
    static final String DFA15_minS =
        "\1\4\1\32\1\4\1\uffff\2\4\1\uffff\1\33\5\uffff\2\4\3\uffff";
    static final String DFA15_maxS =
        "\1\64\1\32\1\54\1\uffff\2\100\1\uffff\1\64\5\uffff\2\54\3\uffff";
    static final String DFA15_acceptS =
        "\3\uffff\1\3\2\uffff\1\12\1\uffff\1\1\1\6\1\11\1\5\1\4\2\uffff"+
        "\1\7\1\10\1\2";
    static final String DFA15_specialS =
        "\22\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\26\uffff\1\3\16\uffff\1\5\3\uffff\1\2\1\uffff\1\4\3\uffff"+
            "\1\6",
            "\1\7",
            "\1\10\47\uffff\1\11",
            "",
            "\1\12\46\uffff\1\12\1\uffff\1\12\4\uffff\1\14\1\13\12\uffff"+
            "\3\12",
            "\1\17\46\uffff\1\16\1\20\1\15\20\uffff\3\17",
            "",
            "\1\3\22\uffff\1\2\1\21\1\12\3\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "\1\17\47\uffff\1\20",
            "\1\17\47\uffff\1\20",
            "",
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
            return "836:1: (this_CreateObjectMutator_0= ruleCreateObjectMutator | this_SelectObjectMutator_1= ruleSelectObjectMutator | this_CompositeMutator_2= ruleCompositeMutator | this_ModifySourceReferenceMutator_3= ruleModifySourceReferenceMutator | this_ModifyTargetReferenceMutator_4= ruleModifyTargetReferenceMutator | this_CreateReferenceMutator_5= ruleCreateReferenceMutator | this_RemoveObjectMutator_6= ruleRemoveObjectMutator | this_RemoveReferenceMutator_7= ruleRemoveReferenceMutator | this_ModifyInformationMutator_8= ruleModifyInformationMutator | this_CloneObjectMutator_9= ruleCloneObjectMutator )";
        }
    }
    static final String DFA19_eotS =
        "\13\uffff";
    static final String DFA19_eofS =
        "\6\uffff\1\12\4\uffff";
    static final String DFA19_minS =
        "\1\26\3\5\2\uffff\1\16\4\uffff";
    static final String DFA19_maxS =
        "\1\120\3\114\2\uffff\1\117\4\uffff";
    static final String DFA19_acceptS =
        "\4\uffff\1\3\1\1\1\uffff\1\2\1\4\1\6\1\5";
    static final String DFA19_specialS =
        "\13\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\3\3\uffff\1\1\65\uffff\1\2",
            "\1\4\1\5\6\uffff\1\11\15\uffff\1\10\5\uffff\2\5\2\uffff\2"+
            "\7\32\uffff\1\7\6\4\4\5\1\6",
            "\1\4\1\5\6\uffff\1\11\15\uffff\1\10\5\uffff\2\5\2\uffff\2"+
            "\7\32\uffff\1\7\6\4\4\5\1\6",
            "\1\4\1\5\6\uffff\1\11\15\uffff\1\10\5\uffff\2\5\2\uffff\2"+
            "\7\32\uffff\1\7\6\4\4\5\1\6",
            "",
            "",
            "\1\12\11\uffff\1\12\36\uffff\1\5\26\uffff\2\12",
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
            return "1226:1: (this_NumberType_0= ruleNumberType | this_BooleanType_1= ruleBooleanType | this_StringType_2= ruleStringType | this_ListStringType_3= ruleListStringType | this_RandomType_4= ruleRandomType | this_ListType_5= ruleListType )";
        }
    }
    static final String DFA20_eotS =
        "\13\uffff";
    static final String DFA20_eofS =
        "\11\uffff\1\12\1\uffff";
    static final String DFA20_minS =
        "\1\26\3\6\4\uffff\1\6\1\16\1\uffff";
    static final String DFA20_maxS =
        "\1\120\3\114\4\uffff\1\42\1\117\1\uffff";
    static final String DFA20_acceptS =
        "\4\uffff\1\2\1\3\1\4\1\5\2\uffff\1\1";
    static final String DFA20_specialS =
        "\13\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\3\3\uffff\1\1\65\uffff\1\2",
            "\1\11\32\uffff\1\10\1\4\45\uffff\1\4\1\5\1\6\1\12\1\7",
            "\1\11\32\uffff\1\10\1\4\45\uffff\1\4\1\5\1\6\1\12\1\7",
            "\1\11\32\uffff\1\10\1\4\45\uffff\1\4\1\5\1\6\1\12\1\7",
            "",
            "",
            "",
            "",
            "\1\11\33\uffff\1\4",
            "\1\12\11\uffff\1\12\11\uffff\1\4\53\uffff\2\12",
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
            return "1306:1: (this_IntegerType_0= ruleIntegerType | this_DoubleType_1= ruleDoubleType | this_MinValueType_2= ruleMinValueType | this_MaxValueType_3= ruleMaxValueType | this_RandomNumberType_4= ruleRandomNumberType )";
        }
    }
    static final String DFA21_eotS =
        "\12\uffff";
    static final String DFA21_eofS =
        "\12\uffff";
    static final String DFA21_minS =
        "\1\26\3\114\1\67\2\6\1\30\2\uffff";
    static final String DFA21_maxS =
        "\1\120\3\114\1\67\3\42\2\uffff";
    static final String DFA21_acceptS =
        "\10\uffff\1\1\1\2";
    static final String DFA21_specialS =
        "\12\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\3\3\uffff\1\1\65\uffff\1\2",
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
            return "1376:1: (this_RandomDoubleNumberType_0= ruleRandomDoubleNumberType | this_RandomIntegerNumberType_1= ruleRandomIntegerNumberType )";
        }
    }
    static final String DFA102_eotS =
        "\13\uffff";
    static final String DFA102_eofS =
        "\13\uffff";
    static final String DFA102_minS =
        "\1\26\3\5\7\uffff";
    static final String DFA102_maxS =
        "\1\120\3\107\7\uffff";
    static final String DFA102_acceptS =
        "\4\uffff\1\3\1\1\1\4\1\7\1\5\1\6\1\2";
    static final String DFA102_specialS =
        "\13\uffff}>";
    static final String[] DFA102_transitionS = {
            "\1\3\3\uffff\1\1\65\uffff\1\2",
            "\1\5\74\uffff\1\12\1\4\1\10\1\11\1\6\1\7",
            "\1\5\74\uffff\1\12\1\4\1\10\1\11\1\6\1\7",
            "\1\5\74\uffff\1\12\1\4\1\10\1\11\1\6\1\7",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA102_eot = DFA.unpackEncodedString(DFA102_eotS);
    static final short[] DFA102_eof = DFA.unpackEncodedString(DFA102_eofS);
    static final char[] DFA102_min = DFA.unpackEncodedStringToUnsignedChars(DFA102_minS);
    static final char[] DFA102_max = DFA.unpackEncodedStringToUnsignedChars(DFA102_maxS);
    static final short[] DFA102_accept = DFA.unpackEncodedString(DFA102_acceptS);
    static final short[] DFA102_special = DFA.unpackEncodedString(DFA102_specialS);
    static final short[][] DFA102_transition;

    static {
        int numStates = DFA102_transitionS.length;
        DFA102_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA102_transition[i] = DFA.unpackEncodedString(DFA102_transitionS[i]);
        }
    }

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = DFA102_eot;
            this.eof = DFA102_eof;
            this.min = DFA102_min;
            this.max = DFA102_max;
            this.accept = DFA102_accept;
            this.special = DFA102_special;
            this.transition = DFA102_transition;
        }
        public String getDescription() {
            return "5179:1: (this_SpecificStringType_0= ruleSpecificStringType | this_RandomStringType_1= ruleRandomStringType | this_UpperStringType_2= ruleUpperStringType | this_LowerStringType_3= ruleLowerStringType | this_CatStartStringType_4= ruleCatStartStringType | this_CatEndStringType_5= ruleCatEndStringType | this_ReplaceStringType_6= ruleReplaceStringType )";
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
        public static final BitSet FOLLOW_13_in_ruleMutatorEnvironment278 = new BitSet(new long[]{0x0011440008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment299 = new BitSet(new long[]{0x0011440008004010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleMutatorEnvironment320 = new BitSet(new long[]{0x0011440008004010L});
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
        public static final BitSet FOLLOW_13_in_ruleBlock1222 = new BitSet(new long[]{0x0011440008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleBlock1243 = new BitSet(new long[]{0x0011440008004010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleBlock1264 = new BitSet(new long[]{0x0011440008004010L});
        public static final BitSet FOLLOW_14_in_ruleBlock1277 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleBlock1290 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleBlock1313 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleBlock1325 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
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
        public static final BitSet FOLLOW_ruleCloneObjectMutator_in_ruleMutator1882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_entryRuleObSelectionStrategy1917 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObSelectionStrategy1927 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomSelection_in_ruleObSelectionStrategy1974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificSelection_in_ruleObSelectionStrategy2001 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteSelection_in_ruleObSelectionStrategy2028 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherSelection_in_ruleObSelectionStrategy2055 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSubsetSelection_in_ruleObSelectionStrategy2082 = new BitSet(new long[]{0x0000000000000002L});
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
        public static final BitSet FOLLOW_ruleSubsetSelection_in_entryRuleSubsetSelection2506 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSubsetSelection2516 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEachTypeSelection_in_ruleSubsetSelection2562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluationType_in_entryRuleAttributeEvaluationType2596 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeEvaluationType2606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeEvaluationType2653 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectAttributeType_in_ruleAttributeEvaluationType2680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeType_in_entryRuleAttributeType2715 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeType2725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberType_in_ruleAttributeType2772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_ruleAttributeType2799 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_ruleAttributeType2826 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_ruleAttributeType2853 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomType_in_ruleAttributeType2880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListType_in_ruleAttributeType2907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleNumberType_in_entryRuleNumberType2942 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleNumberType2952 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_ruleNumberType2999 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_ruleNumberType3026 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinValueType_in_ruleNumberType3053 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxValueType_in_ruleNumberType3080 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomNumberType_in_ruleNumberType3107 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomNumberType_in_entryRuleRandomNumberType3142 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomNumberType3152 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleNumberType_in_ruleRandomNumberType3199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerNumberType_in_ruleRandomNumberType3226 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLoad_in_entryRuleLoad3261 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLoad3271 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleLoad3317 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleLoad3338 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEString_in_entryRuleEString3375 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEString3386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEString3426 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEString3452 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt3498 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEInt3509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleEInt3548 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEInt3565 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEDouble_in_entryRuleEDouble3611 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEDouble3622 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleEDouble3661 = new BitSet(new long[]{0x0000000400000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3679 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleEDouble3699 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3714 = new BitSet(new long[]{0x0000001800000002L});
        public static final BitSet FOLLOW_35_in_ruleEDouble3734 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_36_in_ruleEDouble3753 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_33_in_ruleEDouble3768 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleEDouble3785 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEBoolean_in_entryRuleEBoolean3833 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEBoolean3844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleEBoolean3882 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleEBoolean3901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_entryRuleBinaryOperator3941 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperator3951 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogicOperator_in_ruleBinaryOperator4006 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_entryRuleAttributeEvaluation4042 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeEvaluation4052 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeEvaluation4106 = new BitSet(new long[]{0x0000000004400000L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeEvaluation4127 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_entryRuleReferenceEvaluation4163 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceEvaluation4173 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation4228 = new BitSet(new long[]{0x0000010004400000L,0x0000000000010000L});
        public static final BitSet FOLLOW_39_in_ruleReferenceEvaluation4246 = new BitSet(new long[]{0x0000010004400000L,0x0000000000010000L});
        public static final BitSet FOLLOW_40_in_ruleReferenceEvaluation4260 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceEvaluation4280 = new BitSet(new long[]{0x0000000004400000L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleReferenceEvaluation4303 = new BitSet(new long[]{0xC0002A0000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceEvaluation4325 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleReferenceEvaluation4343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_entryRuleEvaluation4380 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEvaluation4390 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeEvaluation_in_ruleEvaluation4437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceEvaluation_in_ruleEvaluation4464 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleExpression_in_entryRuleExpression4499 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleExpression4509 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression4564 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
        public static final BitSet FOLLOW_ruleBinaryOperator_in_ruleExpression4586 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleEvaluation_in_ruleExpression4607 = new BitSet(new long[]{0x0000000000000002L,0x000000000000C000L});
        public static final BitSet FOLLOW_ruleRemoveObjectMutator_in_entryRuleRemoveObjectMutator4645 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveObjectMutator4655 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveObjectMutator4701 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4722 = new BitSet(new long[]{0x0000000008800002L});
        public static final BitSet FOLLOW_23_in_ruleRemoveObjectMutator4735 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveObjectMutator4756 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveObjectMutator4771 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveObjectMutator4793 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveObjectMutator4805 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveObjectMutator4828 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveObjectMutator4840 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveReferenceMutator_in_entryRuleRemoveReferenceMutator4878 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveReferenceMutator4888 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_ruleRemoveReferenceMutator4935 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_ruleRemoveReferenceMutator4962 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_ruleRemoveReferenceMutator4989 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveRandomReferenceMutator_in_entryRuleRemoveRandomReferenceMutator5024 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveRandomReferenceMutator5034 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveRandomReferenceMutator5080 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_43_in_ruleRemoveRandomReferenceMutator5092 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleRemoveRandomReferenceMutator5104 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5124 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveRandomReferenceMutator5136 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveRandomReferenceMutator5156 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveRandomReferenceMutator5169 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveRandomReferenceMutator5191 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveRandomReferenceMutator5203 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveRandomReferenceMutator5226 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveRandomReferenceMutator5238 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveSpecificReferenceMutator_in_entryRuleRemoveSpecificReferenceMutator5276 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveSpecificReferenceMutator5286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveSpecificReferenceMutator5332 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleRemoveSpecificReferenceMutator5344 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveSpecificReferenceMutator5364 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveSpecificReferenceMutator5376 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRemoveSpecificReferenceMutator5397 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleRemoveSpecificReferenceMutator5410 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRemoveSpecificReferenceMutator5432 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleRemoveSpecificReferenceMutator5444 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleRemoveSpecificReferenceMutator5467 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleRemoveSpecificReferenceMutator5479 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRemoveCompleteReferenceMutator_in_entryRuleRemoveCompleteReferenceMutator5517 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRemoveCompleteReferenceMutator5527 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleRemoveCompleteReferenceMutator5573 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleRemoveCompleteReferenceMutator5585 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleRemoveCompleteReferenceMutator5597 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5617 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleRemoveCompleteReferenceMutator5629 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRemoveCompleteReferenceMutator5649 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateObjectMutator_in_entryRuleCreateObjectMutator5685 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateObjectMutator5695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator5738 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCreateObjectMutator5755 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleCreateObjectMutator5769 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateObjectMutator5789 = new BitSet(new long[]{0x0000000008400802L});
        public static final BitSet FOLLOW_22_in_ruleCreateObjectMutator5802 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateObjectMutator5823 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleCreateObjectMutator5838 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCreateObjectMutator5850 = new BitSet(new long[]{0x1E40000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5872 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5899 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleCreateObjectMutator5914 = new BitSet(new long[]{0x1E40000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCreateObjectMutator5936 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCreateObjectMutator5963 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleCreateObjectMutator5978 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCreateObjectMutator5993 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateObjectMutator6015 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCreateObjectMutator6027 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateObjectMutator6050 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCreateObjectMutator6062 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSelectObjectMutator_in_entryRuleSelectObjectMutator6100 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSelectObjectMutator6110 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSelectObjectMutator6152 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleSelectObjectMutator6169 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleSelectObjectMutator6181 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6202 = new BitSet(new long[]{0x0000000000400002L});
        public static final BitSet FOLLOW_22_in_ruleSelectObjectMutator6215 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleSelectObjectMutator6236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyInformationMutator_in_entryRuleModifyInformationMutator6274 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyInformationMutator6284 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyInformationMutator6327 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleModifyInformationMutator6344 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleModifyInformationMutator6358 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyInformationMutator6379 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleModifyInformationMutator6392 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleModifyInformationMutator6404 = new BitSet(new long[]{0x1E40000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6426 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6453 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleModifyInformationMutator6468 = new BitSet(new long[]{0x1E40000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleModifyInformationMutator6490 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleModifyInformationMutator6517 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleModifyInformationMutator6532 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifyInformationMutator6547 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyInformationMutator6569 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifyInformationMutator6581 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyInformationMutator6604 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifyInformationMutator6616 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCreateReferenceMutator_in_entryRuleCreateReferenceMutator6654 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCreateReferenceMutator6664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6707 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCreateReferenceMutator6724 = new BitSet(new long[]{0x0000400000000000L});
        public static final BitSet FOLLOW_46_in_ruleCreateReferenceMutator6738 = new BitSet(new long[]{0x0000100000000000L});
        public static final BitSet FOLLOW_44_in_ruleCreateReferenceMutator6750 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCreateReferenceMutator6770 = new BitSet(new long[]{0x0002000008400002L});
        public static final BitSet FOLLOW_49_in_ruleCreateReferenceMutator6783 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6804 = new BitSet(new long[]{0x0000000008400002L});
        public static final BitSet FOLLOW_22_in_ruleCreateReferenceMutator6819 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCreateReferenceMutator6840 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCreateReferenceMutator6855 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCreateReferenceMutator6877 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCreateReferenceMutator6889 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCreateReferenceMutator6912 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCreateReferenceMutator6924 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifySourceReferenceMutator_in_entryRuleModifySourceReferenceMutator6962 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifySourceReferenceMutator6972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleModifySourceReferenceMutator7009 = new BitSet(new long[]{0x0004000000000000L});
        public static final BitSet FOLLOW_50_in_ruleModifySourceReferenceMutator7021 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifySourceReferenceMutator7041 = new BitSet(new long[]{0x0002000008800002L});
        public static final BitSet FOLLOW_23_in_ruleModifySourceReferenceMutator7054 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7075 = new BitSet(new long[]{0x0002000008000002L});
        public static final BitSet FOLLOW_49_in_ruleModifySourceReferenceMutator7090 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifySourceReferenceMutator7111 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifySourceReferenceMutator7126 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifySourceReferenceMutator7148 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifySourceReferenceMutator7160 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifySourceReferenceMutator7183 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifySourceReferenceMutator7195 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModifyTargetReferenceMutator_in_entryRuleModifyTargetReferenceMutator7233 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModifyTargetReferenceMutator7243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleModifyTargetReferenceMutator7280 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleModifyTargetReferenceMutator7292 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModifyTargetReferenceMutator7312 = new BitSet(new long[]{0x0002000008800002L});
        public static final BitSet FOLLOW_23_in_ruleModifyTargetReferenceMutator7325 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7346 = new BitSet(new long[]{0x0002000008000002L});
        public static final BitSet FOLLOW_49_in_ruleModifyTargetReferenceMutator7361 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleModifyTargetReferenceMutator7382 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleModifyTargetReferenceMutator7397 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleModifyTargetReferenceMutator7419 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleModifyTargetReferenceMutator7431 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleModifyTargetReferenceMutator7454 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleModifyTargetReferenceMutator7466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompositeMutator_in_entryRuleCompositeMutator7504 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompositeMutator7514 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompositeMutator7557 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCompositeMutator7574 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleCompositeMutator7588 = new BitSet(new long[]{0x0011440008000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator7609 = new BitSet(new long[]{0x0011440028000010L});
        public static final BitSet FOLLOW_ruleMutator_in_ruleCompositeMutator7630 = new BitSet(new long[]{0x0011440028000010L});
        public static final BitSet FOLLOW_29_in_ruleCompositeMutator7643 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCompositeMutator7656 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCompositeMutator7679 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCompositeMutator7691 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCompositeMutator7712 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCompositeMutator7740 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCompositeMutator7753 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCloneObjectMutator_in_entryRuleCloneObjectMutator7791 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCloneObjectMutator7801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCloneObjectMutator7844 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleCloneObjectMutator7861 = new BitSet(new long[]{0x0010000000000000L});
        public static final BitSet FOLLOW_52_in_ruleCloneObjectMutator7875 = new BitSet(new long[]{0xC020280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_53_in_ruleCloneObjectMutator7893 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator7928 = new BitSet(new long[]{0x0000000008400802L});
        public static final BitSet FOLLOW_22_in_ruleCloneObjectMutator7941 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleCloneObjectMutator7962 = new BitSet(new long[]{0x0000000008000802L});
        public static final BitSet FOLLOW_11_in_ruleCloneObjectMutator7977 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCloneObjectMutator7989 = new BitSet(new long[]{0x1E40000001004010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8011 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8038 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleCloneObjectMutator8053 = new BitSet(new long[]{0x1E40000000000010L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_ruleCloneObjectMutator8075 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_ruleCloneObjectMutator8102 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleCloneObjectMutator8117 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleCloneObjectMutator8132 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleCloneObjectMutator8154 = new BitSet(new long[]{0x0000000010000000L});
        public static final BitSet FOLLOW_28_in_ruleCloneObjectMutator8166 = new BitSet(new long[]{0x0000000200000040L,0x0000000000002000L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_ruleCloneObjectMutator8189 = new BitSet(new long[]{0x0000000020000000L});
        public static final BitSet FOLLOW_29_in_ruleCloneObjectMutator8201 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSet_in_entryRuleAttributeSet8239 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSet8249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeScalar_in_ruleAttributeSet8296 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_ruleAttributeSet8323 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_ruleAttributeSet8350 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_ruleAttributeSet8377 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_ruleAttributeSet8404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeOperation_in_ruleAttributeSet8431 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeScalar_in_entryRuleAttributeScalar8466 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeScalar8476 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeScalar8521 = new BitSet(new long[]{0x0000000004400000L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleAttributeScalar8542 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeUnset_in_entryRuleAttributeUnset8578 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeUnset8588 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleAttributeUnset8625 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleAttributeUnset8637 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeUnset8657 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeUnset8669 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeSwap_in_entryRuleAttributeSwap8705 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeSwap8715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleAttributeSwap8752 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleAttributeSwap8764 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap8784 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleAttributeSwap8796 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeSwap8818 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAttributeSwap8830 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeSwap8852 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeSwap8864 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeCopy_in_entryRuleAttributeCopy8900 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeCopy8910 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleAttributeCopy8947 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleAttributeCopy8959 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy8979 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleAttributeCopy8991 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleAttributeCopy9013 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleAttributeCopy9025 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeCopy9047 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeCopy9059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeReverse_in_entryRuleAttributeReverse9095 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeReverse9105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_59_in_ruleAttributeReverse9142 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleAttributeReverse9154 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeReverse9174 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleAttributeReverse9186 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAttributeOperation_in_entryRuleAttributeOperation9222 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAttributeOperation9232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAttributeOperation9277 = new BitSet(new long[]{0x0000000200000000L,0x00000000000E2000L});
        public static final BitSet FOLLOW_ruleArithmeticOperator_in_ruleAttributeOperation9298 = new BitSet(new long[]{0x0000000004400000L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleAttributeEvaluationType_in_ruleAttributeOperation9319 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSet_in_entryRuleReferenceSet9355 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSet9365 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_ruleReferenceSet9412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_ruleReferenceSet9439 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAtt_in_ruleReferenceSet9466 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceInit_in_entryRuleReferenceInit9501 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceInit9511 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceInit9556 = new BitSet(new long[]{0x0000000004000000L});
        public static final BitSet FOLLOW_26_in_ruleReferenceInit9568 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceInit9589 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceSwap_in_entryRuleReferenceSwap9625 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceSwap9635 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleReferenceSwap9672 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleReferenceSwap9684 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap9704 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleReferenceSwap9716 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleReferenceSwap9738 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleReferenceSwap9750 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceSwap9772 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleReferenceSwap9784 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReferenceAtt_in_entryRuleReferenceAtt9820 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReferenceAtt9830 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAtt9875 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleReferenceAtt9887 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceAtt9907 = new BitSet(new long[]{0x0000000004400000L,0x0000000000010000L});
        public static final BitSet FOLLOW_ruleAttributeType_in_ruleReferenceAtt9928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomTypeSelection_in_entryRuleRandomTypeSelection9964 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomTypeSelection9974 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleRandomTypeSelection10020 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTypeSelection10040 = new BitSet(new long[]{0x2000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleRandomTypeSelection10053 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomTypeSelection10073 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleRandomTypeSelection10088 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleRandomTypeSelection10100 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleRandomTypeSelection10121 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleRandomTypeSelection10133 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificObjectSelection_in_entryRuleSpecificObjectSelection10171 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificObjectSelection10181 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10235 = new BitSet(new long[]{0x2000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleSpecificObjectSelection10248 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificObjectSelection10268 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleSpecificObjectSelection10283 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSpecificObjectSelection10295 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSpecificObjectSelection10316 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSpecificObjectSelection10328 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificClosureSelection_in_entryRuleSpecificClosureSelection10366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificClosureSelection10376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleSpecificClosureSelection10422 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleSpecificClosureSelection10434 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificClosureSelection10454 = new BitSet(new long[]{0x0100010000000000L});
        public static final BitSet FOLLOW_40_in_ruleSpecificClosureSelection10467 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSpecificClosureSelection10487 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleSpecificClosureSelection10501 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleSpecificClosureSelection10514 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleSpecificClosureSelection10526 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleSpecificClosureSelection10547 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSpecificClosureSelection10559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCompleteTypeSelection_in_entryRuleCompleteTypeSelection10597 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCompleteTypeSelection10607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleCompleteTypeSelection10653 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompleteTypeSelection10673 = new BitSet(new long[]{0x2000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleCompleteTypeSelection10686 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleCompleteTypeSelection10706 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleCompleteTypeSelection10721 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleCompleteTypeSelection10733 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleCompleteTypeSelection10754 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleCompleteTypeSelection10766 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOtherTypeSelection_in_entryRuleOtherTypeSelection10804 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOtherTypeSelection10814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_63_in_ruleOtherTypeSelection10860 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOtherTypeSelection10880 = new BitSet(new long[]{0x2000010000000002L});
        public static final BitSet FOLLOW_40_in_ruleOtherTypeSelection10893 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleOtherTypeSelection10913 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleOtherTypeSelection10928 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleOtherTypeSelection10940 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleOtherTypeSelection10961 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleOtherTypeSelection10973 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEachTypeSelection_in_entryRuleEachTypeSelection11011 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEachTypeSelection11021 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleEachTypeSelection11067 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleEachTypeSelection11087 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleEachTypeSelection11100 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleEachTypeSelection11112 = new BitSet(new long[]{0x0000008000000010L});
        public static final BitSet FOLLOW_ruleExpression_in_ruleEachTypeSelection11133 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleEachTypeSelection11145 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBooleanType_in_entryRuleBooleanType11183 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBooleanType11193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_ruleBooleanType11240 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_ruleBooleanType11267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomBooleanType_in_entryRuleRandomBooleanType11302 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomBooleanType11312 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomBooleanType11367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleRandomBooleanType11379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificBooleanType_in_entryRuleSpecificBooleanType11415 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificBooleanType11425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificBooleanType11480 = new BitSet(new long[]{0x0000006000000000L});
        public static final BitSet FOLLOW_ruleEBoolean_in_ruleSpecificBooleanType11501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleStringType_in_entryRuleStringType11537 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleStringType11547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_ruleStringType11594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_ruleStringType11621 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_ruleStringType11648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_ruleStringType11675 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_ruleStringType11702 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_ruleStringType11729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_ruleStringType11756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomStringType_in_entryRuleRandomStringType11791 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomStringType11801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomStringType11856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleRandomStringType11868 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleRandomStringType11880 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType11901 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomStringType11913 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomStringType11934 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomStringType11946 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificStringType_in_entryRuleSpecificStringType11982 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificStringType11992 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificStringType12047 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSpecificStringType12064 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleUpperStringType_in_entryRuleUpperStringType12105 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleUpperStringType12115 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleUpperStringType12170 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleUpperStringType12182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatStartStringType_in_entryRuleCatStartStringType12218 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatStartStringType12228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleCatStartStringType12283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleCatStartStringType12295 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCatStartStringType12307 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatStartStringType12328 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCatStartStringType12340 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCatEndStringType_in_entryRuleCatEndStringType12376 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCatEndStringType12386 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleCatEndStringType12441 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
        public static final BitSet FOLLOW_69_in_ruleCatEndStringType12453 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleCatEndStringType12465 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleCatEndStringType12486 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleCatEndStringType12498 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListStringType_in_entryRuleListStringType12534 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListStringType12544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleListStringType12599 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleListStringType12611 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType12632 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_24_in_ruleListStringType12645 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleListStringType12666 = new BitSet(new long[]{0x0000000021000000L});
        public static final BitSet FOLLOW_29_in_ruleListStringType12680 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerStringType_in_entryRuleLowerStringType12716 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerStringType12726 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleLowerStringType12781 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
        public static final BitSet FOLLOW_70_in_ruleLowerStringType12793 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleReplaceStringType_in_entryRuleReplaceStringType12829 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleReplaceStringType12839 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleReplaceStringType12894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
        public static final BitSet FOLLOW_71_in_ruleReplaceStringType12906 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleReplaceStringType12918 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType12939 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleReplaceStringType12951 = new BitSet(new long[]{0x0000000000000030L});
        public static final BitSet FOLLOW_ruleEString_in_ruleReplaceStringType12972 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleReplaceStringType12984 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleDoubleType_in_entryRuleDoubleType13020 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDoubleType13030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_ruleDoubleType13077 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_ruleDoubleType13104 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleType_in_entryRuleRandomDoubleType13139 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomDoubleType13149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomDoubleType13204 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
        public static final BitSet FOLLOW_72_in_ruleRandomDoubleType13216 = new BitSet(new long[]{0x0080000000000002L});
        public static final BitSet FOLLOW_55_in_ruleRandomDoubleType13229 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType13250 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomDoubleType13262 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleType13283 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomDoubleType13295 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificDoubleType_in_entryRuleSpecificDoubleType13333 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificDoubleType13343 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificDoubleType13398 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleSpecificDoubleType13419 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinValueType_in_entryRuleMinValueType13455 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinValueType13465 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleMinValueType13511 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
        public static final BitSet FOLLOW_73_in_ruleMinValueType13523 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleMinValueType13535 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMinValueType13555 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleMinValueType13567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxValueType_in_entryRuleMaxValueType13603 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxValueType13613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleMaxValueType13659 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleMaxValueType13671 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleMaxValueType13683 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleMaxValueType13703 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleMaxValueType13715 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleIntegerType_in_entryRuleIntegerType13751 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleIntegerType13761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_ruleIntegerType13808 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_ruleIntegerType13835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSpecificIntegerType_in_entryRuleSpecificIntegerType13870 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSpecificIntegerType13880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleSpecificIntegerType13935 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleSpecificIntegerType13956 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerType_in_entryRuleRandomIntegerType13992 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomIntegerType14002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomIntegerType14057 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
        public static final BitSet FOLLOW_75_in_ruleRandomIntegerType14069 = new BitSet(new long[]{0x0080000000000002L});
        public static final BitSet FOLLOW_55_in_ruleRandomIntegerType14082 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType14103 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomIntegerType14115 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerType14136 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomIntegerType14148 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomType_in_entryRuleRandomType14186 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomType14196 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomType14251 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_76_in_ruleRandomType14263 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomDoubleNumberType_in_entryRuleRandomDoubleNumberType14299 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomDoubleNumberType14309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomDoubleNumberType14355 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_76_in_ruleRandomDoubleNumberType14367 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleRandomDoubleNumberType14379 = new BitSet(new long[]{0x0000000600000040L});
        public static final BitSet FOLLOW_ruleEDouble_in_ruleRandomDoubleNumberType14400 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomDoubleNumberType14412 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRandomDoubleNumberType14434 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleRandomDoubleNumberType14446 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomDoubleNumberType14468 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomDoubleNumberType14480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRandomIntegerNumberType_in_entryRuleRandomIntegerNumberType14516 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRandomIntegerNumberType14526 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleRandomIntegerNumberType14572 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_76_in_ruleRandomIntegerNumberType14584 = new BitSet(new long[]{0x0080000000000000L});
        public static final BitSet FOLLOW_55_in_ruleRandomIntegerNumberType14596 = new BitSet(new long[]{0x0000000200000040L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleRandomIntegerNumberType14617 = new BitSet(new long[]{0x0000000001000000L});
        public static final BitSet FOLLOW_24_in_ruleRandomIntegerNumberType14629 = new BitSet(new long[]{0xC000280000000010L,0x0000000000000001L});
        public static final BitSet FOLLOW_ruleObSelectionStrategy_in_ruleRandomIntegerNumberType14651 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleRandomIntegerNumberType14663 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleRandomIntegerNumberType14685 = new BitSet(new long[]{0x0100000000000000L});
        public static final BitSet FOLLOW_56_in_ruleRandomIntegerNumberType14697 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleListType_in_entryRuleListType14733 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleListType14743 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleListType14798 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleListType14810 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListType14830 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_24_in_ruleListType14843 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleListType14863 = new BitSet(new long[]{0x0000000001004000L});
        public static final BitSet FOLLOW_14_in_ruleListType14877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleObjectAttributeType_in_entryRuleObjectAttributeType14913 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleObjectAttributeType14923 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperator_in_ruleObjectAttributeType14978 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectAttributeType14998 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleObjectAttributeType15010 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleObjectAttributeType15030 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxCardinality_in_entryRuleMaxCardinality15067 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxCardinality15078 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEInt_in_ruleMaxCardinality15125 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleMaxCardinality15149 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_78_in_ruleLogicOperator15203 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleLogicOperator15220 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleOperator15265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_80_in_ruleOperator15282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_22_in_ruleOperator15299 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_81_in_ruleArithmeticOperator15344 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleArithmeticOperator15361 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_77_in_ruleArithmeticOperator15378 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_82_in_ruleArithmeticOperator15395 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleArithmeticOperator15412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleRepeat15457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleRepeat15474 = new BitSet(new long[]{0x0000000000000002L});
    }


}